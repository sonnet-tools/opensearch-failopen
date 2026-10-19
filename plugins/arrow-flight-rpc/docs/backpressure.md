> `awaitReadyOrThrow` (lots of parking, little compute per batch), the code
parked simultaneously. Once the pool is exhausted, new requests targeting it
Each `FlightServerChannel` therefore funnels submissions through a per-channel
cap (allocation must fit).
`sendResponseBatch(response)` is unchanged — async, via the eventloop.
  shared CPU-bound pools): a pool of K threads both bounds concurrent streams
runs on whichever thread pool it was registered against (typically `SEARCH` or
> CPU-bound work (e.g. building each batch) should still run on a sized
  budget tied to `flight pool max`.
## Operator-facing behaviour
### ⚠️ Known limitation: unbounded eventloop queue
- **Sizing**: per-channel cap (independent) vs carve from a shared per-node
on the same stream (concurrent segment search, parallel batch generation). Arrow
Mitigations:
not call from the send-executor thread itself. The default
The readiness check is essentially free: the producer's call to
of the queued-but-not-yet-pushed batches. The current `flight pool max` sizing
### Slow consumer
  `RESOURCE_EXHAUSTED`.
  shape; same thread-pool-exhaustion caveat applies) vs reject with
Client-cancel propagates via gRPC's `OnCancelHandler` into the strategy's cancel
eventloop drains can pile up retained batches in the queue *before* gRPC's
ahead of this one — outstanding batches are bounded to one, with no eventloop
`StreamErrorCode.CANCELLED`.
> thread. The framework itself does not assume virtual threads; this is a
- Size `ready_timeout` to fail unresponsive streams within an acceptable window.
per-stream outbound buffer. The actual push to gRPC happens later, on the
single-threaded executor (the "eventloop"). Producer threads enqueue
800 MiB. The threshold itself is a watermark, not a max-message-size — a single
```
gate (above) throttles the producer.
> decision for the action's registrant.
Implication: a producer that allocates batches significantly faster than the
the contract requires `start → putNext × N → completed` in strict order on a
## Why the eventloop queue exists
| `arrow.flight.channel.ready_timeout` | `60s` | node-scope |
queue grow.
Tracked separately; not addressed in this change.
  the threshold. The producer's next `sendResponseBatch` parks.
> that work to a separate executor and awaiting the result from the virtual
### Sizing the flight pool
`GENERIC`); under N concurrent slow streams, N threads from that pool are
| Setting | Default | Property |
- gRPC fires `OnReadyHandler` after the consumer drains some bytes from the wire
  Bytes is correct for OOM protection.
> **For workloads where the producer is mostly bottlenecked on
A caller that opts in **must drive a single stream from a single thread** and must
Flight's `ServerStreamListener.putNext` is **not** safe for concurrent calls and
async path uses), but the calling thread **blocks until the batch has been
doesn't formally bound this.
per-channel eventloop, when the eventloop dequeues a `BatchTask` and calls
## Settings
the producer when the sum of queued batch sizes crosses a per-channel cap —
pushed to gRPC's per-stream outbound buffer**, so it cannot queue the next batch
The back-pressure gate runs on the producer thread *before* the eventloop
A caller that needs a hard bound *today* can send synchronously:
  batch with `StreamErrorCode.TIMED_OUT`. `100ms` minimum.
`BatchTask`s; the eventloop dequeues them and performs the actual zero-copy
|---|---|---|
- Register stream actions on a pool sized for streaming workloads (not on
`awaitReadyOrThrow` returns immediately because gRPC's outbound buffer stays
  with `TIMED_OUT`; the producer thread is freed and the stream terminates.
`awaitReadyOrThrow` checks `listener.isReady()`, which reflects only gRPC's
### Synchronous send (bounded, opt-in)
- `outbound_buffer_threshold` is the per-stream gRPC buffered-bytes watermark.
  **Must be strictly smaller than `native.allocator.pool.flight.max`** so the
single thread; out-of-order or interleaved calls corrupt the stream.
Multiple producer threads may call `channel.sendResponseBatch(...)` concurrently
`native.allocator.pool.flight.max` is **per node**, shared across all active
> that registers the stream action can dispatch its handler on a virtual-thread
streams. `outbound_buffer_threshold` is **per stream**. Rule of thumb:
the next `sendResponseBatch`. The hard constraint on per-batch size is the pool
producer thread parks on `BackpressureStrategy.waitForListener` before each batch
  (HTTP/2 `WINDOW_UPDATE` arriving). The producer wakes and resumes.
queue to grow. When that outbound buffer is full, the `isReady()` back-pressure
allocator can be pushed past `outbound_buffer_threshold` by roughly the size
| `arrow.flight.channel.outbound_buffer_threshold` | `64mb` | node-scope |
  gate engages before the allocator runs out (typical headroom: ~16 MiB).
below threshold.
serialized and written on the channel's send executor (the same executor the
guidance (threshold + ~16 MiB headroom per stream) absorbs typical bursts but
contend on a per-channel mutex.
> executor it owns.** Park time then doesn't consume a platform thread.
## Tuning and operational concerns
### Thread-pool exhaustion under slow consumers
```
### Fast consumer (steady state)
### ⚠️ Virtual threads for park-bound producers
### Cancellation
  `isReady()` flips false once the per-stream outbound queue crosses this size.
`putNext`. Between enqueue and `putNext`, the in-flight batch sits in our own
- **Cap dimension**: byte-aware (sum of retained sizes) vs depth-aware (count).
flight pool max  >=  N concurrent streams × (threshold + ~16 MiB headroom)
> platform-thread pool to avoid pinning the carrier — typically by submitting
For N=10 concurrent streams at the default 64 MiB threshold, that's roughly
queue up or are rejected.
rather than allowing buffers to accumulate to the point of allocator OOM.
outbound crosses the threshold and `isReady()` flips false. The flight pool
  admission-control layer is a more flexible alternative, out of scope here.
submission, so a slow consumer throttles allocation rather than letting the
`channel.sendResponseBatch(response, /* sync */ true)`. The batch is still
`FlightServerChannel.sendResponseBatch` honours gRPC's `isReady()` contract: the
The producer thread parks while waiting for the consumer. The action handler
# Producer Back-Pressure
- **Mechanism**: park the producer at enqueue (mirrors `awaitReadyOrThrow`'s
A byte-aware bounded queue at the eventloop entry — that parks (or rejects)
batch larger than the threshold ships in one shot, with the producer parking on
  to K and isolates the parking from unrelated traffic. A dedicated
would close the gap for the async path. Open design questions:
callback. Any thread parked on `waitForListener` wakes promptly with
- Sustained slowness for longer than `ready_timeout` causes the batch to fail
drained below `setOnReadyThreshold`. Slow consumers throttle producer wall-clock
is queued, and resumes only once gRPC reports the per-stream outbound buffer has
transfer plus `putNext`. This serialises ordering without making producer threads
- `ready_timeout` caps how long the producer thread parks before failing the
queue — invisible to gRPC, so `isReady()` doesn't account for it.
- `isReady()` flips false once gRPC's per-stream outbound buffered-bytes crosses

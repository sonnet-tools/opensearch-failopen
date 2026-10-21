  admission-control layer is a more flexible alternative, out of scope here.
`sendResponseBatch(response)` is unchanged — async, via the eventloop.
submission, so a slow consumer throttles allocation rather than letting the
the next `sendResponseBatch`. The hard constraint on per-batch size is the pool
### ⚠️ Virtual threads for park-bound producers
`native.allocator.pool.flight.max` is **per node**, shared across all active
  `RESOURCE_EXHAUSTED`.
## Why the eventloop queue exists
rather than allowing buffers to accumulate to the point of allocator OOM.
  the threshold. The producer's next `sendResponseBatch` parks.
### Fast consumer (steady state)
| `arrow.flight.channel.outbound_buffer_threshold` | `64mb` | node-scope |
doesn't formally bound this.
> executor it owns.** Park time then doesn't consume a platform thread.
> decision for the action's registrant.
queue to grow. When that outbound buffer is full, the `isReady()` back-pressure
A caller that needs a hard bound *today* can send synchronously:
```
  batch with `StreamErrorCode.TIMED_OUT`. `100ms` minimum.
would close the gap for the async path. Open design questions:
pushed to gRPC's per-stream outbound buffer**, so it cannot queue the next batch
## Operator-facing behaviour
The back-pressure gate runs on the producer thread *before* the eventloop
Client-cancel propagates via gRPC's `OnCancelHandler` into the strategy's cancel
### Sizing the flight pool
contend on a per-channel mutex.
allocator can be pushed past `outbound_buffer_threshold` by roughly the size
- `outbound_buffer_threshold` is the per-stream gRPC buffered-bytes watermark.
flight pool max  >=  N concurrent streams × (threshold + ~16 MiB headroom)
on the same stream (concurrent segment search, parallel batch generation). Arrow
  gate engages before the allocator runs out (typical headroom: ~16 MiB).
- Sustained slowness for longer than `ready_timeout` causes the batch to fail
A caller that opts in **must drive a single stream from a single thread** and must
`GENERIC`); under N concurrent slow streams, N threads from that pool are
# Producer Back-Pressure
### Thread-pool exhaustion under slow consumers
Flight's `ServerStreamListener.putNext` is **not** safe for concurrent calls and
Each `FlightServerChannel` therefore funnels submissions through a per-channel
single-threaded executor (the "eventloop"). Producer threads enqueue
`awaitReadyOrThrow` checks `listener.isReady()`, which reflects only gRPC's
gate (above) throttles the producer.
  **Must be strictly smaller than `native.allocator.pool.flight.max`** so the
- Size `ready_timeout` to fail unresponsive streams within an acceptable window.
## Settings
```
| `arrow.flight.channel.ready_timeout` | `60s` | node-scope |
### ⚠️ Known limitation: unbounded eventloop queue
  Bytes is correct for OOM protection.
runs on whichever thread pool it was registered against (typically `SEARCH` or
drained below `setOnReadyThreshold`. Slow consumers throttle producer wall-clock
guidance (threshold + ~16 MiB headroom per stream) absorbs typical bursts but
streams. `outbound_buffer_threshold` is **per stream**. Rule of thumb:
> platform-thread pool to avoid pinning the carrier — typically by submitting
ahead of this one — outstanding batches are bounded to one, with no eventloop
eventloop drains can pile up retained batches in the queue *before* gRPC's
Tracked separately; not addressed in this change.
Implication: a producer that allocates batches significantly faster than the
## Tuning and operational concerns
transfer plus `putNext`. This serialises ordering without making producer threads
per-channel eventloop, when the eventloop dequeues a `BatchTask` and calls
`StreamErrorCode.CANCELLED`.
> `awaitReadyOrThrow` (lots of parking, little compute per batch), the code
the contract requires `start → putNext × N → completed` in strict order on a
|---|---|---|
below threshold.
queue — invisible to gRPC, so `isReady()` doesn't account for it.
the producer when the sum of queued batch sizes crosses a per-channel cap —
  budget tied to `flight pool max`.
`awaitReadyOrThrow` returns immediately because gRPC's outbound buffer stays
A byte-aware bounded queue at the eventloop entry — that parks (or rejects)
- `ready_timeout` caps how long the producer thread parks before failing the
queue up or are rejected.
producer thread parks on `BackpressureStrategy.waitForListener` before each batch
  to K and isolates the parking from unrelated traffic. A dedicated
async path uses), but the calling thread **blocks until the batch has been
  with `TIMED_OUT`; the producer thread is freed and the stream terminates.
serialized and written on the channel's send executor (the same executor the
  shape; same thread-pool-exhaustion caveat applies) vs reject with
outbound crosses the threshold and `isReady()` flips false. The flight pool
Multiple producer threads may call `channel.sendResponseBatch(...)` concurrently
The readiness check is essentially free: the producer's call to
> **For workloads where the producer is mostly bottlenecked on
800 MiB. The threshold itself is a watermark, not a max-message-size — a single
`putNext`. Between enqueue and `putNext`, the in-flight batch sits in our own
- `isReady()` flips false once gRPC's per-stream outbound buffered-bytes crosses
queue grow.
of the queued-but-not-yet-pushed batches. The current `flight pool max` sizing
> thread. The framework itself does not assume virtual threads; this is a
- **Cap dimension**: byte-aware (sum of retained sizes) vs depth-aware (count).
### Synchronous send (bounded, opt-in)
- Register stream actions on a pool sized for streaming workloads (not on
`FlightServerChannel.sendResponseBatch` honours gRPC's `isReady()` contract: the
- gRPC fires `OnReadyHandler` after the consumer drains some bytes from the wire
> that registers the stream action can dispatch its handler on a virtual-thread
per-stream outbound buffer. The actual push to gRPC happens later, on the
`BatchTask`s; the eventloop dequeues them and performs the actual zero-copy
batch larger than the threshold ships in one shot, with the producer parking on
not call from the send-executor thread itself. The default
- **Sizing**: per-channel cap (independent) vs carve from a shared per-node
| Setting | Default | Property |
  shared CPU-bound pools): a pool of K threads both bounds concurrent streams
  (HTTP/2 `WINDOW_UPDATE` arriving). The producer wakes and resumes.
single thread; out-of-order or interleaved calls corrupt the stream.
For N=10 concurrent streams at the default 64 MiB threshold, that's roughly
  `isReady()` flips false once the per-stream outbound queue crosses this size.
Mitigations:
callback. Any thread parked on `waitForListener` wakes promptly with
> CPU-bound work (e.g. building each batch) should still run on a sized
### Cancellation
- **Mechanism**: park the producer at enqueue (mirrors `awaitReadyOrThrow`'s
> that work to a separate executor and awaiting the result from the virtual
is queued, and resumes only once gRPC reports the per-stream outbound buffer has
The producer thread parks while waiting for the consumer. The action handler
parked simultaneously. Once the pool is exhausted, new requests targeting it
### Slow consumer
`channel.sendResponseBatch(response, /* sync */ true)`. The batch is still
cap (allocation must fit).

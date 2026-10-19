- **Per-batch metadata** keyed to *this* batch's data — row offsets, watermarks,
### 2. Server-side handler — produce Arrow data
void handleRequest(MyRequest request, TransportChannel channel, Task task) throws IOException {
    public String executor() { return ThreadPool.Names.GENERIC; }
The allocator used for producer roots must be **long-lived** — it must outlive the gRPC
## Pipelining
            // root is now owned by the framework — don't reuse or close it
Lifecycle: bytes are copied off the Flight wire buffer into a `byte[]` owned by the
        while ((response = stream.nextResponse()) != null) {
`Data.importIntoVectorSchemaRoot`), the imported buffers are foreign-backed. Arrow Java
The metadata channel is exposed on `ArrowBatchResponse` and is only available on the
causing a memory leak in the source allocator.
retains ArrowBuf references beyond `putNext()` and `completed()`, releasing them
transport does not interpret these bytes; encoding and decoding are the action's
    if (meta != null) handleProfile(meta);
allocator of the first batch's vectors), ensuring same-allocator transfer which avoids
### Important: C Data Import and allocator choice
    public MyQueryResponse read(StreamInput in) throws IOException {
            VectorSchemaRoot root = response.getRoot();
Typical uses:
has a bug where cross-allocator `transferOwnership` of foreign-backed buffers doesn't
responsibility.
    byte[] profileBytes = serializeProfile(...);
The framework creates the shared Flight root from the **producer's allocator** (the
# Native Arrow Transport Path
### 1. Define your response
        return new MyQueryResponse(in);
- **Stream-terminal payloads** — attach to the last batch only. Profiling counters,
## Allocator Management
or use your own long-lived application allocator. Do not create and close a child
    public void handleStreamResponse(StreamTransportResponse<MyQueryResponse> stream) {
    Schema schema = new Schema(List.of(
class MyQueryHandler implements StreamTransportResponseHandler<MyQueryResponse> {
}
public class MyQueryResponse extends ArrowBatchResponse {
```
    // with foreign-backed buffers from C data import.
    byte[] meta = r.getMetadata();
these references causes memory accounting errors.
### 3. Client-side handler — consume Arrow data
    // Get the channel's allocator. Use this directly for producer roots
The existing byte-serialized path (`writeTo`/`read` via `StreamOutput`/`StreamInput`) is unchanged.
            VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
    channel.sendResponseBatch(new MyQueryResponse(root));
(created from the channel's allocator). The framework serializes the transfer and send
stream. This is because gRPC's zero-copy write path (`ArrowBufRetainingCompositeByteBuf`)
    ));
Do not reuse or close it — the framework transfers its buffers and closes it on the executor.
        }
        channel.sendResponse(e);
## Overview
Arrow-columnar data natively (e.g., query engines like DataFusion).
        new Field("name", FieldType.nullable(new ArrowType.Utf8()), null),
    BufferAllocator allocator = ArrowFlightChannel.from(channel).getAllocator();
        // Cleanup callback runs on executor after all batches are flushed.
while ((r = stream.nextResponse()) != null) {
        }
```java
            // populate vectors...
Batches can be produced in parallel. Each batch must have its own `VectorSchemaRoot`
```
## Ownership Contract
| Channel allocator | Framework | Framework (on channel close) |
| Resource | Created by | Closed by |
    }
```
}
this bug. All subsequent batches should use the same allocator.
            VarCharVector names = (VarCharVector) root.getVector("name");
  batch-level stats.
```java
boolean isLast = (b == batchCount - 1);
allocator per request.
    public MyQueryResponse(VectorSchemaRoot root) { super(root); }
    // (not a child allocator) to avoid Arrow's cross-allocator transfer bug
  cumulative stats, summary blobs.
// send-side: attach to the last batch
} else {
native Arrow path. The byte-serialized path does not surface it.
}
flows directly over Flight without byte serialization. This is for APIs that produce
    try {
}
        stream.close();
}
response, so the metadata outlives the stream cursor.
    }
if (isLast && profile) {
on the executor thread. The producer can queue batches without waiting for each to flush.
asynchronously on the Netty event loop. Closing the allocator while gRPC still holds
        MyQueryResponse response;
If your producer imports data via Arrow's C Data Interface (`Data.importIntoVector`,
## Application Metadata
    public void handleException(TransportException exp) { /* handle error */ }
## Quick Start
// receive-side: read on every batch, act when present
    consume(r.getRoot());
```java
Use `ArrowFlightChannel.from(channel).getAllocator()` to get the channel's allocator,
| Shared Flight root | Framework | Framework (on channel close) |
            channel.sendResponseBatch(new MyQueryResponse(root));
properly release the internal `ArrowArray` C struct buffer (128 bytes per import call),
        new Field("score", FieldType.nullable(new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE)), null)
After calling `sendResponseBatch(response)`, the framework owns the response's root.
        channel.completeStream();
    }
```
            Float8Vector scores = (Float8Vector) root.getVector("score");
| Producer root (per batch) | Producer | Framework (after zero-copy transfer on executor) |
```java
travels on the same Flight frame as its data — Arrow Flight's
        for (int i = 0; i < batchCount; i++) {
            // process typed vectors...
The Arrow Flight transport supports a native Arrow path where typed `VectorSchemaRoot` data
    } catch (Exception e) {
`OutboundStreamListener.putNext(ArrowBuf metadata)` is what's used on the wire. The
Extend `ArrowBatchResponse`. No `writeTo`/`read` override needed — the framework handles it.
|----------|-----------|-----------|
    channel.sendResponseBatch(new MyQueryResponse(root, profileBytes));
Each `ArrowBatchResponse` can carry an opaque `byte[]` of application metadata that
    public MyQueryResponse(StreamInput in) throws IOException { super(in); }

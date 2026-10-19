## Action Registration
- `sendResponseBatch()` may block if transport buffers are full
For actions whose response extends `ArrowBatchResponse`, opaque application metadata can be
flowchart TD
### Completion
## Processing Flow
    ThreadPool.Names.SEARCH,
    class J,K error
    F -->|No| G[Complete Stream]
        } else {
    } catch (StreamException e) {
### Blocking
            logger.info("Stream cancelled by client: {}", e.getMessage());
            // Send batch - may block or throw StreamException with CANCELLED code
    B --> C[Send Response Batch]
- Do NOT call `completeStream()` or `sendResponse()` after cancellation
- `sendResponseBatch()` throws `StreamException` with `StreamErrorCode.CANCELLED` when client cancels
- Always call either `completeStream()` (success) OR `sendResponse(exception)` (error)
# Server-Side Streaming API Guide
    class E cancel
    I -->|Yes| J[Send Error]
}
        }
        if (e.getErrorCode() == StreamErrorCode.CANCELLED) {
        // Process data incrementally
(profiling counters, summary stats). See
Server-side streaming allows sending multiple response batches to a client over a single connection. This is ideal for large result sets, real-time data, or progressive processing.
);
        DataIterator iterator = createDataIterator(request);
    D -->|No| F{More Data?}
```
```
private void handleStreamRequest(MyRequest request, TransportChannel channel, Task task) {
streamTransportService.registerRequestHandler(
    B --> I{Error?}
    classDef success fill:#e8f5e8
            MyData data = iterator.next();
            MyResponse response = processData(data);
    C --> D{Client Cancelled?}
    } catch (Exception e) {
    MyRequest::new,
- Exit handler immediately - framework handles cleanup
    try {
### Cancellation
- Stream must be explicitly completed or terminated
    }
    J --> K[Terminated]
## Key Behaviors
            channel.sendResponse(e);
`response.getMetadata()`. Attach to the last batch for stream-terminal payloads
    G --> H[Success]
- Never call both methods
[native-arrow-transport-design.md](native-arrow-transport-design.md#application-metadata).
    "internal:my-action/stream",
            channel.sendResponseBatch(response);
            // Other stream error - send to client
    this::handleStreamRequest
```java
        // Signal successful completion
```
            // Do NOT call completeStream() or sendResponse()
    D -->|Yes| E[Exit Gracefully]
```java
### Trailing / per-batch metadata (native Arrow path)
        }
        channel.completeStream();
attached to any batch via `new MyResponse(root, byte[])` and read on the receiver via
- Server will pause until client consumes data and frees buffer space
        channel.sendResponse(e);
            // Client cancelled - exit gracefully
    A[Request Received] --> B[Process Data Loop]
        // Send error to client
- See [backpressure.md](backpressure.md) for behaviour, settings, and sizing.
    classDef error fill:#ffebee
## Basic Implementation
## Overview
        while (iterator.hasNext()) {
    classDef cancel fill:#fce4ec
    class G,H success
```mermaid
    F -->|Yes| B

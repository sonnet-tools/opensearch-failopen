            }
            handleTermination(streamResponse, "Error: " + e.getMessage(), e);
    %% Stream Processing
            streamResponse.close();
                processResponse(response);
    CLOSE --> SUCCESS[Complete]
    TIMEOUT --> HANDLE_ERROR
        handleError(exp);
```
        } catch (Exception e) {
        streamResponse.cancel(reason, cause);
    TransportRequestOptions.builder().withType(STREAM).withTimeout(30s).build(), 
    classDef client fill:#e8f5e8,stroke:#2e7d32,stroke-width:2px
```mermaid
            while ((response = streamResponse.nextResponse()) != null) {  // BLOCKING CALL
    %% Simple styling
    }
    private volatile StreamTransportResponse<MyResponse> currentStream;
                    handleTermination(streamResponse, "Processing cancelled", null);
    CONTINUE -->|No - Cancel| CANCEL[streamResponse.cancel]
        if (currentStream != null) {
            return;
    %% Simple Client Flow
        }
        if (cancelled) {
    classDef framework fill:#e3f2fd,stroke:#1976d2,stroke-width:2px
    handler);
        try {
        // Add custom cleanup/logging logic here
transportService.sendRequest(node, "action", request, 
    }
    HANDLE_ERROR --> SUCCESS
    private volatile boolean cancelled = false;
        }
            handleTermination(streamResponse, "Handler already cancelled", null);
        cancelled = true;
    NEXT --> PROCESS[Process response]
    CANCEL --> SUCCESS
    PROCESS --> CONTINUE{Continue?}
```java
    ERROR --> HANDLE_ERROR[Handle error]
            handleTermination(currentStream, "Exception occurred: " + exp.getMessage(), exp);
        }
    // Placeholder for custom termination logic
    classDef error fill:#ffebee,stroke:#c62828,stroke-width:2px
- **Blocking**: `nextResponse()` blocks waiting for server data - use background threads
StreamTransportResponseHandler<MyResponse> handler = new StreamTransportResponseHandler<MyResponse>() {
                }
    class HANDLE_ERROR error
};
            MyResponse response;
- **Always Close/Cancel**: Stream must be closed or cancelled to prevent resource leaks
    STREAM --> NEXT[Get next response]
## Simple Client Usage
```
    CONTINUE -->|No - Complete| CLOSE[streamResponse.close]
# Client-Side Streaming API Flow
    %% Error & Completion
    RESPONSE -->|Success| STREAM[handleStreamResponse called]
    private void handleTermination(StreamTransportResponse<MyResponse> streamResponse, String reason, Exception cause) {
    WAIT --> RESPONSE{Response Type?}
    class WAIT,STREAM,ERROR,TIMEOUT framework
### **Key Points**:
    public void handleException(TransportException exp) {
### **Thread-Safe Implementation**:
    RESPONSE -->|Timeout| TIMEOUT[Timeout exception]
    }
    public void handleStreamResponse(StreamTransportResponse<MyResponse> streamResponse) {
                    return;
    START[Client sends streaming request] --> WAIT[Wait for response]
    class RESPONSE,CONTINUE decision
    @Override
    @Override
- **Timeout Handling**: `handleException` can cancel active streams for timeout scenarios
flowchart TD
    CONTINUE -->|Yes| NEXT
        currentStream = streamResponse;
    class START,NEXT,PROCESS,CLOSE,CANCEL client
    RESPONSE -->|Error| ERROR[handleException called]
                if (cancelled) {

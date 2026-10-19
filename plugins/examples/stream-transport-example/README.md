    public MyRequest(int count) { this.count = count; }
    @Override
    }
            } else {
    }
        }
        return Collections.singletonList(
        super(MyStreamAction.NAME, actionFilters, streamTransportService.getTaskManager());
    @Override
## Step 1: Create Action Definition
    public MyResponse(StreamInput in) throws IOException { message = in.readString(); }
        );
    @Override
3. **Cancellation**: Handle `StreamException` with `CANCELLED` code gracefully
}
        // Register streaming handler
    private String message;
    public TransportMyStreamAction(StreamTransportService streamTransportService, ActionFilters actionFilters) {
    public MyRequest(StreamInput in) throws IOException { count = in.readInt(); }
                System.out.println(response.getMessage());
## Step 2: Create Request/Response Classes
```
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
            for (int i = 1; i <= request.getCount(); i++) {
    public MyResponse read(StreamInput in) throws IOException {
Step-by-step guide to implement streaming transport actions in OpenSearch.
streamTransportService.sendRequest(node, MyStreamAction.NAME, request, handler);
4. **Node-to-Node Only**: Streaming works only between cluster nodes
## Step 4: Register in Plugin
    public void writeTo(StreamOutput out) throws IOException { out.writeString(message); }
                channel.sendResponse(e);
```
    @Inject
1. **Server**: Always call `completeStream()` or `sendResponse(exception)`
```java
## Step 3: Create Transport Action
```
public class MyRequest extends ActionRequest {
        } catch (StreamException e) {
    }
    }
        }
        // Handle errors
    @Override
            MyResponse response;
```java
```
## Step 5: Client Usage
    public MyResponse(String message) { this.message = message; }
    public void handleException(TransportException exp) {
        return new MyResponse(in);
```java
        );
            ThreadPool.Names.GENERIC,
    }
    private void handleStreamRequest(MyRequest request, TransportChannel channel, Task task) {
```java
2. **Client**: Always call `close()` or `cancel()` on stream
# Stream Transport Example
    protected void doExecute(Task task, MyRequest request, ActionListener<MyResponse> listener) {
public class MyStreamAction extends ActionType<MyResponse> {
            channel.completeStream();
            MyStreamAction.NAME,
    public void writeTo(StreamOutput out) throws IOException { out.writeInt(count); }
}
            }
```java
    private int count;
    public static final MyStreamAction INSTANCE = new MyStreamAction();
    private MyStreamAction() {
        try {
}
}
        } catch (Exception e) {
        } catch (Exception e) {
## Key Rules
    }
    }
};
public class MyPlugin extends Plugin implements ActionPlugin {
StreamTransportResponseHandler<MyResponse> handler = new StreamTransportResponseHandler<MyResponse>() {
            MyRequest::new,
            if (e.getErrorCode() == StreamErrorCode.CANCELLED) {
    @Override
}
                // Client cancelled - exit gracefully
    public String executor() { return ThreadPool.Names.GENERIC; }
```
        streamTransportService.registerRequestHandler(
    public static final String NAME = "cluster:admin/my_stream";
            streamResponse.close();
        super(NAME, MyResponse::new);
            }
    @Override
            this::handleStreamRequest
                // Process each response
                channel.sendResponseBatch(response);
    public void handleStreamResponse(StreamTransportResponse<MyResponse> streamResponse) {
            new ActionHandler<>(MyStreamAction.INSTANCE, TransportMyStreamAction.class)
    @Override
            channel.sendResponse(e);
                MyResponse response = new MyResponse("Item " + i);
public class MyResponse extends ActionResponse {
            while ((response = streamResponse.nextResponse()) != null) {
public class TransportMyStreamAction extends TransportAction<MyRequest, MyResponse> {
    @Override
    }
        listener.onFailure(new UnsupportedOperationException("Use StreamTransportService"));
            streamResponse.cancel("Error", e);
            }
        try {

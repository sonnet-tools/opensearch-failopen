            // Handle temporary unavailability, maybe retry
| UNKNOWN            | Unknown error or unhandled server exception                |
            // Handle resource not found
When throwing errors in server-side code:
| CANCELLED          | Operation was cancelled by the client                      |
The following error codes are available in `StreamErrorCode`:
            break;
| ALREADY_EXISTS     | Resource already exists                                    |
| StreamErrorCode    | Description                                                |
    channel.completeStream();
| INVALID_ARGUMENT   | Invalid arguments provided                                 |
}
    // Handle other stream errors
| UNAUTHORIZED       | Client lacks permission for the operation                  |
## Best Practices
throw new StreamException(StreamErrorCode.INTERNAL, "Internal error", exception);
StreamException exception = new StreamException(StreamErrorCode.INVALID_ARGUMENT, "Invalid query");
            // Handle cancellation
|--------------------|------------------------------------------------------------|
throw new StreamException(StreamErrorCode.INVALID_ARGUMENT, "Invalid parameter: " + paramName);
```
throw new StreamException(StreamErrorCode.UNAVAILABLE, "Resource temporarily unavailable");
    }
        // Do NOT call completeStream() or sendResponse()
```java
exception.addMetadata("query_id", queryId);
        case NOT_FOUND:
            break;
When handling errors in client-side code:
## Overview
throw StreamException.cancelled("Operation cancelled by user");
        channel.sendResponseBatch(createResponse());
| UNIMPLEMENTED      | Operation not implemented                                  |
| NOT_FOUND          | Requested resource not found                               |
    }
throw new StreamException(StreamErrorCode.NOT_FOUND, "Resource not found: " + resourceId);
At the OpenSearch layer, `FlightRuntimeException` isn't directly exposed. Instead, `StreamException` is used, which is converted to and from `FlightRuntimeException` at the flight transport layer.
```
// For internal errors
            break;
throw exception;
        // Client cancelled - exit gracefully
}
```
        return;
} catch (StreamException e) {
try {
When a stream is cancelled:
String queryId = metadata.get("query_id");
| INTERNAL           | Internal server error                                      |
    // Operation that might throw StreamException
```java
// For resource not found
        case UNAVAILABLE:
## Error Codes
// For unavailable resources
| RESOURCE_EXHAUSTED | Resource limits exceeded                                   |
3. The server should exit gracefully and not call `completeStream()` or `sendResponse()`
| OK                 | Operation completed successfully                           |
            // Handle other errors
| UNAVAILABLE        | Service unavailable or resource temporarily inaccessible   |
### Handling Errors
```
2. The server receives a `StreamException` with `StreamErrorCode.CANCELLED`
This document describes the error handling model for the Arrow Flight RPC transport in OpenSearch. The model is inspired by gRPC's error handling approach and provides a consistent way to handle errors across the transport boundary.
| TIMED_OUT          | Operation timed out                                        |
    switch (e.getErrorCode()) {
# Arrow Flight RPC Error Handling Guidelines
```java
```java
            break;
// For cancelled operations
        default:
try {
    if (e.getErrorCode() == StreamErrorCode.CANCELLED) {
        logger.info("Stream cancelled by client: {}", e.getMessage());
    while (hasMoreData()) {
} catch (StreamException e) {
`StreamException` supports adding metadata for additional error context:
    }
This metadata is preserved across the transport boundary and can be accessed on the receiving side:
        case CANCELLED:
1. The client calls `streamResponse.cancel(reason, cause)`
### Throwing Errors
    throw e;
            break;
```
        case INVALID_ARGUMENT:
### Stream Cancellation
| UNAUTHENTICATED    | Client not authenticated                                   |
```java
Map<String, String> metadata = streamException.getMetadata();
            // Handle validation error
// For validation errors
exception.addMetadata("index_name", indexName);
## Error Metadata

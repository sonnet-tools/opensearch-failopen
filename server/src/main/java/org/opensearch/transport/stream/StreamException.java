import java.util.Objects;
     */
     *
    public StreamException(StreamErrorCode errorCode, String message, Throwable cause) {
     * @param message the error message
    }
     * @param cause the cause of this exception  
     * Creates an INTERNAL exception.  
     * Creates an UNAUTHENTICATED exception.  
import org.opensearch.common.annotation.ExperimentalApi;
     */
        return new StreamException(StreamErrorCode.RESOURCE_EXHAUSTED, message);
    @Override  
     */
        this.errorCode = StreamErrorCode.fromCode(streamInput.read());  
    /**
    /**
     *  
     * @param message the error message
        this(errorCode, message, null);
        this.errorCode = Objects.requireNonNull(errorCode);
    public static StreamException resourceExhausted(String message) {
    @Override
 * this file be licensed under the Apache-2.0 license or a
    private final StreamErrorCode errorCode;
     * Creates a new StreamException with the given error code, message, and cause.
     * Once a stream is cancelled, no further response batches can be sent.  
    public StreamException(StreamInput streamInput) throws IOException {
@ExperimentalApi
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
     * @param message the error message
        return sb.toString();  
        }
 * compatible open source license.
    /**
        return new StreamException(StreamErrorCode.UNAVAILABLE, message);
     */
    }
     * @param message the error message
    public static StreamException cancelled(String message, Throwable cause) {  
     * @return a new StreamException with CANCELLED error code
     * @return a new StreamException with INTERNAL error code
package org.opensearch.transport.stream;
     *  
     * @param message the error message
        super.writeTo(out);
    /**  
 */  
}
        if (getMessage() != null) {
     * @param message the error message
 */
     */
     * @param cause the cause of this exception  
    }
        return new StreamException(StreamErrorCode.CANCELLED, message, cause);
     * @return a new StreamException with CANCELLED error code  
        return new StreamException(StreamErrorCode.UNAUTHENTICATED, message);  
        sb.append("StreamException[errorCode=").append(errorCode);
        return new StreamException(StreamErrorCode.INTERNAL, message, cause);
    /**  
     * Creates a RESOURCE_EXHAUSTED exception.
            sb.append(", message=").append(getMessage());  
     * @return a new StreamException with UNAVAILABLE error code
     * Creates a CANCELLED exception with a cause.
     */
     *  
     * Once a stream is cancelled, no further response batches can be sent.  
    /**
import org.opensearch.core.common.io.stream.StreamOutput;  
     * @return the error code
 *  
        out.write(errorCode.code());  
     */  
        sb.append("]");
    }
     * @param errorCode the error code
import org.opensearch.core.common.io.stream.StreamInput;
     *
     * This is thrown when attempting to send response batches on a cancelled stream.
     * @return a new StreamException with UNAUTHENTICATED error code  
    public static StreamException internal(String message, Throwable cause) {  
    }  
public class StreamException extends TransportException {  
     * Returns the error code for this exception.
        super(message, cause);  
    public static StreamException cancelled(String message) {
            sb.append(", metadata=").append(metadata);  
 * Exception for streaming transport operations with standardized error codes.
/*  
     */
     * @param message the error message
    public StreamErrorCode getErrorCode() {  
    }
 * SPDX-License-Identifier: Apache-2.0
    }  
     *
     * @param errorCode the error code  
/**  
    }
    /**
     *
        super(streamInput);
    public static StreamException unavailable(String message) {
    }
     * Creates an UNAVAILABLE exception.
     * Creates a CANCELLED exception.
     * Creates a new StreamException with the given error code and message.
    public void writeTo(final StreamOutput out) throws IOException {
 *
    /**
        return errorCode;
     * @return a new StreamException with RESOURCE_EXHAUSTED error code
     * This is thrown when attempting to send response batches on a cancelled stream.
 * This provides a consistent error model for stream-based transports like Arrow Flight RPC.
     */  
    /**  
        if (!metadata.isEmpty()) {
    }
        return new StreamException(StreamErrorCode.CANCELLED, message);  
     * @param cause the cause of this exception  
    public String toString() {
     *  
     * @param message the error message
    public static StreamException unauthenticated(String message) {
import org.opensearch.transport.TransportException;
    }
        }
        StringBuilder sb = new StringBuilder();  
    }
    public StreamException(StreamErrorCode errorCode, String message) {  
     *

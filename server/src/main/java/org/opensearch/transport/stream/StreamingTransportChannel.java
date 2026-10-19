 * A TransportChannel that supports streaming responses.
    }
 *
@ExperimentalApi
 * {@link StreamErrorCode#CANCELLED}.
 */  
 * At this point, no action is needed as the underlying channel is already closed and call to
 * <p>  
     * Sends a batch of responses to the request that this channel is associated with.  
     * For errors, use {@link #sendResponse(Exception)} and do not call {@link #completeStream()}
import org.opensearch.transport.TransportChannel;  
    void sendResponseBatch(TransportResponse response) throws StreamException;  
/*  
     * Note: not calling this method on success will result in a memory leak
}  
     */
     * Call {@link #completeStream()} on a successful completion.
import org.opensearch.core.transport.TransportResponse;
     * Do not call this method again or completeStream() once canceled.
 * completeStream() will fail.  
    /**
     * Do not use {@link #sendResponse} in conjunction with this method if you are sending a batch of responses.  
 * SPDX-License-Identifier: Apache-2.0
 */
     * Completes the streaming response, indicating no more batches will be sent.  
public interface StreamingTransportChannel extends TransportChannel {  
 * to {@link #sendResponseBatch(TransportResponse)} will throw {@link StreamException} with  
 * compatible open source license.
import org.opensearch.common.annotation.ExperimentalApi;
 * Once a stream is cancelled (either by client or due to error), subsequent calls
        throw new UnsupportedOperationException("sendResponse() is not supported for streaming requests in StreamingTransportChannel");
package org.opensearch.transport.stream;
     * @param response the batch of responses to send
 * this file be licensed under the Apache-2.0 license or a
     */
     * @throws StreamException with {@link StreamErrorCode#CANCELLED} if the stream has been canceled.  
    @Override
/**
 * Streaming channels allow sending multiple response batches for a single request.
    default void sendResponse(TransportResponse response) throws IOException {  
    /**
import java.io.IOException;
    void completeStream();  
 * The OpenSearch Contributors require contributions made to  
     *

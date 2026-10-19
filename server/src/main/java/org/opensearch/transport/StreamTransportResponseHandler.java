 */  
 *         while (true) {  
 * }
import org.opensearch.transport.stream.StreamTransportResponse;  
package org.opensearch.transport;
}  
 * <pre>{@code  
 *
 *     } finally {
 *   <li>Call {@link StreamTransportResponse#cancel(String, Throwable)} for errors or early termination.</li>  
/*  
@ExperimentalApi
 *             T result = response.nextResponse();
 *     }
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
/**
    default void handleResponse(T response) {  
public interface StreamTransportResponseHandler<T extends TransportResponse> extends TransportResponseHandler<T> {
 * <p>
 * this file be licensed under the Apache-2.0 license or a
 *   <li>Process streaming responses via {@link #handleStreamResponse(StreamTransportResponse)}.</li>
     * Default implementation throws UnsupportedOperationException since streaming handlers
 */  
    /**
 *         }
import org.opensearch.common.annotation.ExperimentalApi;
 * </ul>
 * Responsibilities:
 * <p>
 *   <li>Close the stream with {@link StreamTransportResponse#close()} after processing.</li>
 * public void handleStreamResponse(StreamTransportResponse<T> response) {
 *     } catch (Exception e) {
import org.opensearch.core.transport.TransportResponse;
 *
        throw new UnsupportedOperationException("handleResponse is not supported for streaming handlers");
 * The OpenSearch Contributors require contributions made to  
 * Non-streaming responses are not supported and will throw an {@link UnsupportedOperationException}.  
 *             // Process result...  
    @Override
 *     try {
 *         response.close();  
 * A handler specialized for streaming transport responses.  
 * }</pre>  
 *             if (result == null) break;
 *         throw e;
     * should only handle streaming responses  
 * Example:
 * <ul>  
    }
 * <p>
 * @opensearch.api
 *         response.cancel("Processing error", e);  
     */

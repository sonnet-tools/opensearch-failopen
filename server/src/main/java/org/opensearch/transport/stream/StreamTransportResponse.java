     * This may block if responses are not buffered on the wire, depending on the server's  
     */
/*  
     *  
import java.io.Closeable;
 * <p>  
 */
     * <p>
     * @param cause the underlying exception, if any
     * Exceptions during fetching are propagated to the caller. The framework may call  
    /**
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.ExperimentalApi;
     * <p>
 * The framework may call {@code cancel} for internal errors, propagating exceptions to the caller.
package org.opensearch.transport.stream;
     * backpressure strategy. Returns {@code null} when the stream is exhausted.
import org.opensearch.core.transport.TransportResponse;
 * Responsibilities:  
    T nextResponse();
     * <p>  
 *
}
    void cancel(String reason, Throwable cause);
 * SPDX-License-Identifier: Apache-2.0
 * </ul>
 *   <li>Close the stream using {@link #close()} after processing to prevent resource leaks.</li>  
@ExperimentalApi  
 * Represents a streaming transport response that yields multiple response batches.
 * <ul>
 * compatible open source license.
    /**  
 */  
 *   <li>Call {@link #cancel(String, Throwable)} for early termination, client-side errors, or timeouts.</li>
     * The {@code reason} should describe the cause (e.g., "Client timeout"), and
     * {@code cause} may provide additional details (or be {@code null}).
     */  
 * The OpenSearch Contributors require contributions made to  
 * <p>
     * Retrieves the next response in the stream.
 *   <li>Iterate over responses using {@link #nextResponse()} until {@code null} is returned.</li>
     *
     * Cancels the stream due to client-side errors, timeouts, or early termination.
public interface StreamTransportResponse<T extends TransportResponse> extends Closeable {
     * @param reason the reason for cancellation
     * {@link #cancel(String, Throwable)} for internal errors.
     * @return the next response, or {@code null} if the stream is exhausted  
/**  

 *   <li>{@link #onFailure} called at most once (terminal failure)</li>
 */  
     *         satisfied (e.g. a downstream LimitExec finished) and the caller should cancel the  
     * @param isLast   {@code true} if this is the final batch (terminal success event)
     */  
     * @param e the exception that caused the failure  
     * @param response the response batch  
 *
     * @param trailingMetadata application metadata bytes, or {@code null} if none sent
    default void onStreamComplete(byte[] trailingMetadata) {}
 * Follows {@code StreamSearchActionListener.onStreamResponse(result, isLast)} pattern.
    /**  
     * Called after the stream is exhausted with any trailing metadata sent by the data node.  
    /**
 * </ul>  
}  
 *   <li>Exactly one terminal event per request</li>
    void onFailure(Exception e);
 *  
/*  
     *
     */
     *
    /**  
 * <ul>
     * @return {@code true} to keep draining this stream; {@code false} if the consumer is already
 *   <li>{@link #onStreamResponse} called 1+ times; exactly one call has {@code isLast=true} (terminal success)</li>  
 * For shard fragment stages this is {@code FragmentExecutionArrowResponse}.
import org.opensearch.core.action.ActionResponse;
package org.opensearch.analytics.exec;
 * <p>Contract:
     */
     *
 * The OpenSearch Contributors require contributions made to  
     *         stream and stop — the listener has already settled its terminal event in that case.
    boolean onStreamResponse(Resp response, boolean isLast);  
public interface StreamingResponseListener<Resp extends ActionResponse> {
     * Called for each batch received from the data node.
 * this file be licensed under the Apache-2.0 license or a
     * Called when the request fails. Terminal failure event.
 *
 * <p>The type parameter {@code <Resp>} is the response type for the transport action.
 * SPDX-License-Identifier: Apache-2.0
 */  
 * @param <Resp> the response type carried by each streaming batch
/**  
 * compatible open source license.
 *  
 * Listener for streaming responses from a single shard request.

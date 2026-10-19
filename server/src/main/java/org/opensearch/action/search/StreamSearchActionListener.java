abstract class StreamSearchActionListener<T extends SearchPhaseResult> extends SearchActionListener<T> {  
    }
    protected abstract void innerOnStreamResponse(T response);  
     */  
 * This class extends SearchActionListener while providing streaming capabilities.
     * Process the final response and complete the stream.  
     */
    /**  
 */  
package org.opensearch.action.search;
     * Handle intermediate streaming response by preparing it and delegating to innerOnStreamResponse.
     * This maintains compatibility with SearchActionListener while providing streaming capability.
/**
    }
        throw new IllegalStateException("innerOnResponse is not allowed for streaming search, please use innerOnStreamResponse instead");  
    protected void innerOnResponse(T response) {
 * SPDX-License-Identifier: Apache-2.0
            innerOnCompleteResponse(response);  
     */  
    }
 * compatible open source license.
    /**
        response.setShardIndex(requestIndex);  
    /**  
        }
        assert response != null;
 */
    public final void onStreamResponse(T response, boolean isLast) {
import org.opensearch.search.SearchPhaseResult;
    protected abstract void innerOnCompleteResponse(T response);
 *  
            return;
        setSearchShardTarget(response);
     * @param response the prepared intermediate response
}  
        super(searchShardTarget, shardIndex);  
     *
 * @param <T> the type of SearchPhaseResult this listener handles
    /**  
    @Override
     *  
     * Handle regular SearchActionListener response by delegating to innerOnCompleteResponse.
 * this file be licensed under the Apache-2.0 license or a
     * Implementations should override this method to handle the prepared streaming response.
 * The OpenSearch Contributors require contributions made to  
     * Implementations should override this method to handle the prepared final response.
     * This provides the streaming capability for search operations.
     * @param response the prepared final response  
 *
    protected StreamSearchActionListener(SearchShardTarget searchShardTarget, int shardIndex) {
/*  
import org.opensearch.search.SearchShardTarget;
     */
        innerOnStreamResponse(response);  
        if (isLast) {
     * Process intermediate streaming responses.

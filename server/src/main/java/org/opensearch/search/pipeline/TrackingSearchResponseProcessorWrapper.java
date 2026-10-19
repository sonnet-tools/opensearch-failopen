import java.util.concurrent.TimeUnit;
    public TrackingSearchResponseProcessorWrapper(SearchResponseProcessor wrappedProcessor) {
            responseListener.onResponse(result);
            detail.addOutput(Arrays.asList(result.getHits().deepCopy().getHits()));
    public String getDescription() {
    }
 * this file be licensed under the Apache-2.0 license or a
        }));
            return;
        if (wrappedProcessor == null) {  
     *
            throw new IllegalArgumentException("Wrapped processor cannot be null.");
 */
 *
    }
    public String getTag() {  
            responseListener.onFailure(e);  
/**  
import org.opensearch.action.search.SearchResponse;
    @Override
    public String getType() {
    public void processResponseAsync(
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
    @Override
    }  
        SearchRequest request,
    /**  
    @Override
        try {  
        this.wrappedProcessor = wrappedProcessor;  
        SearchResponse response,  
            requestContext.addProcessorExecutionDetail(detail);
        } catch (IOException e) {
    ) {  
import org.opensearch.action.search.SearchRequest;
import org.opensearch.core.action.ActionListener;  
    public boolean isIgnoreFailure() {
    public SearchResponse processResponse(SearchRequest request, SearchResponse response, PipelineProcessingContext requestContext) {
        throw new UnsupportedOperationException();  
        return wrappedProcessor.getType();
     * Constructor for the wrapper.
            detail.addTook(took);  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;  
        return wrappedProcessor.isIgnoreFailure();
package org.opensearch.search.pipeline;
 * compatible open source license.
    public SearchResponse processResponse(SearchRequest request, SearchResponse response) throws Exception {  
    }
public class TrackingSearchResponseProcessorWrapper implements SearchResponseProcessor {
    private final SearchResponseProcessor wrappedProcessor;
            long took = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
    }
        ActionListener<SearchResponse> responseListener
            requestContext.addProcessorExecutionDetail(detail);
        PipelineProcessingContext requestContext,
        }, e -> {  
            detail.addInput(Arrays.asList(response.getHits().deepCopy().getHits()));
    }  
        return wrappedProcessor.getTag();
        return wrappedProcessor.getDescription();  
        long start = System.nanoTime();
    @Override
        }
 * Wrapper for SearchResponseProcessor to track execution details.
     */
    @Override  
 *
 *  @opensearch.internal  
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(getType(), getTag());
            responseListener.onFailure(e);  
}
        wrappedProcessor.processResponseAsync(request, response, requestContext, ActionListener.wrap(result -> {  
    }
        throw new UnsupportedOperationException();
    }
            detail.markProcessorAsFailed(ProcessorExecutionDetail.ProcessorStatus.FAIL, e.getMessage());
     * @param wrappedProcessor the actual processor to be wrapped  
    @Override  
 */  
    @Override  
/*  
        }

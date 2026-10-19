public class TrackingSearchRequestProcessorWrapper implements SearchRequestProcessor {
    @Override  
     * Constructor for the wrapper.
    @Override
 * compatible open source license.
            requestContext.addProcessorExecutionDetail(detail);
    @Override
        SearchRequest request,
    public void processRequestAsync(
    @Override  
     *
    public String getType() {
            detail.addOutput(result.source().toString());
     */
            requestListener.onResponse(result);
    public String getTag() {  
import java.util.concurrent.TimeUnit;
        wrappedProcessor.processRequestAsync(request, requestContext, ActionListener.wrap(result -> {  
     * @param wrappedProcessor the actual processor to be wrapped  
            long took = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
 *  @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
        return wrappedProcessor.isIgnoreFailure();
    @Override  
            requestListener.onFailure(e);  
            detail.addTook(took);  
        throw new UnsupportedOperationException();
    }
            requestContext.addProcessorExecutionDetail(detail);
    public SearchRequest processRequest(SearchRequest request) throws Exception {  
    }
    /**  
 */  
    public TrackingSearchRequestProcessorWrapper(SearchRequestProcessor wrappedProcessor) {
        PipelineProcessingContext requestContext,  
        return wrappedProcessor.getDescription();  
    @Override
 * Wrapper for SearchRequestProcessor to track execution details.
}  
            detail.markProcessorAsFailed(ProcessorExecutionDetail.ProcessorStatus.FAIL, e.getMessage());
    }  
    private final SearchRequestProcessor wrappedProcessor;
    }
    @Override
 *
    ) {
        }, e -> {  
/**  
    public boolean isIgnoreFailure() {
 *
 */
    }  
import org.opensearch.core.action.ActionListener;
        detail.addInput(request.source().toString());
    public String getDescription() {
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(getType(), getTag());  
    }
        long start = System.nanoTime();
    public SearchRequest processRequest(SearchRequest request, PipelineProcessingContext requestContext) throws Exception {
    }
import org.opensearch.action.search.SearchRequest;
        return wrappedProcessor.getType();
        return wrappedProcessor.getTag();
/*  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        throw new UnsupportedOperationException();  
        ActionListener<SearchRequest> requestListener
    }
        this.wrappedProcessor = wrappedProcessor;  
package org.opensearch.search.pipeline;
        }));

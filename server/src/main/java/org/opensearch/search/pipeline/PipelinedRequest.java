            if (!details.isEmpty() && response.getInternalResponse() != null) {
        boolean hasProcessor = false;
 */  
        List<Pipeline> pipelines = getPipelines();
        }  
 * this file be licensed under the Apache-2.0 license or a
        return pipeline;
        return currentListener;  
    public void transformRequest(ActionListener<SearchRequest> requestListener) {  
import org.opensearch.action.search.SearchPhaseResults;
        final String currentPhase,  
    private final Pipeline pipeline;
        // this request is the one the pipeline was resolved for, and consumers that read the id later in the request
        ActionListener<SearchResponse> currentListener = ActionListener.wrap(response -> {
                searchRequest -> p.transformRequest((PipelinedRequest) searchRequest, nextListener),  
        }, responseListener::onFailure);  
        }
            currentListener = p.transformResponseListener(this, nextListener);  
        super(transformedRequest);
            currentListener = ActionListener.wrap(
 * SPDX-License-Identifier: Apache-2.0
            ActionListener<SearchRequest> nextListener = currentListener;
            if (p.getSearchPhaseResultsProcessors().isEmpty()) {
    }
            ActionListener<SearchResponse> nextListener = currentListener;
        SystemGeneratedPipelineHolder systemGeneratedPipelineHolder  
        // Build chain backwards
        }
 * The OpenSearch Contributors require contributions made to  
        this.pipeline = pipeline;
        this.systemGeneratedPipelineHolder = original.systemGeneratedPipelineHolder;  
    ) {
    }  
        this.pipeline(original.pipeline());  
        // resolved pipeline/context below.
 * compatible open source license.
            }  
    public PipelineProcessingContext getPipelineProcessingContext() {
    }
    }
        return requestContext;  
        } else {
                response.getInternalResponse().getProcessorResult().addAll(details);  
    private final SystemGeneratedPipelineHolder systemGeneratedPipelineHolder;  
            // Always try to attach processor execution details even there is no search response processor
 * Groups a search pipeline based on a request and the request after being transformed by the pipeline.
    }  
        this.requestContext = requestContext;  
        this.systemGeneratedPipelineHolder = systemGeneratedPipelineHolder;
    public SystemGeneratedPipelineHolder getSystemGeneratedPipelineHolder() {  
    // Visible for testing  
            }
        // Build listener chain backwards  
    Pipeline getPipeline() {
public final class PipelinedRequest extends SearchRequest {  
            );
            currentListener.onResponse(this);
            }
        this.pipeline = original.pipeline;
                continue;  
import org.opensearch.core.action.ActionListener;
/*  
                continue;
    private final PipelineProcessingContext requestContext;
            // Kick off with the original request  
                requestListener::onFailure
import org.opensearch.action.search.SearchResponse;
    PipelinedRequest(SearchRequest transformedRequest, PipelinedRequest original) {
            Pipeline p = pipelines.get(i);
            // since search request and phase results processors also can add execution details.  
            if (p.getSearchResponseProcessors().isEmpty()) {
        SearchRequest transformedRequest,
import org.opensearch.action.search.SearchPhaseContext;
    }
            p.runSearchPhaseResultsTransformer(searchPhaseResult, searchPhaseContext, currentPhase, nextPhase, requestContext);
    public <Result extends SearchPhaseResult> void transformSearchPhaseResults(  
            hasProcessor = true;  
        for (Pipeline p : pipelines) {  
        if (hasProcessor) {
        // As above, super(...) does not carry the pipeline id over. Carry the original request's id forward so this  
            Pipeline p = pipelines.get(i);
package org.opensearch.search.pipeline;
        PipelineProcessingContext requestContext,
import org.opensearch.action.search.SearchRequest;  
 */
}  
        // Run forward chain
            List<ProcessorExecutionDetail> details = requestContext.getProcessorExecutionDetails();
            responseListener.onResponse(response);
        }
    public ActionListener<SearchResponse> transformResponseListener(ActionListener<SearchResponse> responseListener) {
        this.pipeline(transformedRequest.pipeline());
    }
        return systemGeneratedPipelineHolder;
import org.opensearch.search.SearchPhaseResult;  
    }
    }
        for (int i = pipelines.size() - 1; i >= 0; i--) {  
        return List.of(systemGeneratedPipelineHolder.prePipeline(), pipeline, systemGeneratedPipelineHolder.postPipeline());  
        List<Pipeline> pipelines = getPipelines();
    PipelinedRequest(
/**
 * @opensearch.internal
        // The SearchRequest copy constructor invoked by super(...) intentionally does not carry over the search  
            }
        // lifecycle (e.g. during coordinator query rewrite) would not see it.  
 *
        this.requestContext = original.requestContext;
        ActionListener<SearchRequest> currentListener = requestListener;  
        // re-wrapped request keeps reporting the pipeline it was resolved for, consistent with reusing the original's
        // pipeline id, so preserve it here. Otherwise pipeline() would read null on the resolved request even though
        Pipeline pipeline,  
                continue;
        final SearchPhaseContext searchPhaseContext,
        for (int i = pipelines.size() - 1; i >= 0; i--) {
    ) {
    private List<Pipeline> getPipelines() {
            requestListener.onResponse(this);  
 *  
import java.util.List;
        List<Pipeline> pipelines = getPipelines();  
        super(transformedRequest);
        final SearchPhaseResults<Result> searchPhaseResult,
        final String nextPhase
            if (p.getSearchRequestProcessors().isEmpty()) {  

            long took = relativeTimeSupplier.getAsLong() - pipelineStart[0];
                                + id
import java.util.List;
            return;
                    }  
    private final List<SearchPhaseResultsProcessor> searchPhaseResultsProcessors;
    }  
    List<SearchResponseProcessor> getSearchResponseProcessors() {  
                : searchRequestProcessors.get(i);
            chainListener.onResponse(r);
        // We directly modify the original search request since this is what we expect the search request processor to  
    }
            requestListener.onResponse(pipelinedRequest);  
    static final Pipeline NO_OP_PIPELINE = new Pipeline(  
        String id,
                    }  
        }
    }  
                    nextListener.onResponse(rr);
            }  
    protected void afterRequestProcessor(Processor processor, long timeInNanos) {}
/**
                    } else {
 */  
    }
    void transformRequest(PipelinedRequest pipelinedRequest, ActionListener<SearchRequest> requestListener)
        currentListener.onResponse(pipelinedRequest);
                    long took = relativeTimeSupplier.getAsLong() - start;  
        return version;
            pipelineStart[0] = relativeTimeSupplier.getAsLong();
        List<SearchRequestProcessor> requestProcessors,
    String getId() {
                    afterResponseProcessor(processor, took);  
import java.util.Collections;  
 * SPDX-License-Identifier: Apache-2.0
        // do. Here is no need to do a stream copy to ensure the original search request is not changed.
import org.opensearch.action.search.SearchPhaseResults;
 *
     */
 * The OpenSearch Contributors require contributions made to  
        0,  
        this.relativeTimeSupplier = relativeTimeSupplier;
        @Nullable String description,
                        currentFinalListener.onResponse(r);  
                long start = relativeTimeSupplier.getAsLong();  
     * @return If this is a no-op pipeline  
    private final NamedWriteableRegistry namedWriteableRegistry;  
        throws SearchPipelineProcessingException {  
 */  
            final SearchRequestProcessor processor = pipelinedRequest.source().verbosePipeline()
class Pipeline {
        long[] pipelineStart = new long[1];
 * Concrete representation of a search pipeline, holding multiple processors.
        this.searchPhaseResultsProcessors = Collections.unmodifiableList(phaseResultsProcessors);  
        }  
            currentListener = ActionListener.wrap(r -> {
    private final List<SearchResponseProcessor> searchResponseProcessors;
                    } else {
                                + "] in the search pipeline ["
import org.apache.logging.log4j.Logger;
    protected void beforeTransformResponse() {}
        }, e -> {  
        }
                            e  
    List<SearchPhaseResultsProcessor> getSearchPhaseResultsProcessors() {
        final ActionListener<SearchResponse> originalListener = responseListener;
        SearchPipelineService.NOOP_PIPELINE_ID,
                    // interruption.TrackingSearchResponseProcessorWrapper will log all errors in detail for debugging purposes
                    // When verbosePipeline is enabled, all processor failures are ignored to ensure the execution chain continues without  
                if (currentPhase.equals(searchPhaseResultsProcessor.getBeforePhase().getName())
    protected void beforeTransformRequest() {}
        ActionListener<SearchResponse> responseListener
    }  
        }  
        }, originalListener::onFailure);  
                    afterRequestProcessor(processor, took);
            originalListener.onFailure(e);
                        }
import org.opensearch.action.search.SearchResponse;  
    protected void onTransformRequestFailure() {}  
        PipelinedRequest pipelinedRequest,  
            final SearchResponseProcessor processor = pipelinedRequest.source().verbosePipeline()
    protected void beforeRequestProcessor(Processor processor) {}
                                    + searchPhaseResultsProcessor.getType()  
            afterTransformResponse(took);
}
import org.opensearch.action.search.SearchPhaseContext;  
    String getDescription() {  
        return ActionListener.wrap(r -> {
        return description;
                                "The exception from search phase results processor ["
        responseListener = ActionListener.wrap(r -> {
                            logger.warn(
    private final List<SearchRequestProcessor> searchRequestProcessors;  
import org.opensearch.search.SearchPhaseResult;
    );  
            afterTransformResponse(took);
    }  
                        nextListener.onResponse(r);  
    protected void beforeResponseProcessor(Processor processor) {}
                                    + "] was ignored",  
                    if (processor.isIgnoreFailure() || pipelinedRequest.source().verbosePipeline()) {
                    // When verbosePipeline is enabled, all processor failures are ignored to ensure the execution chain continues without
                                + processor.getType()  
        });
                            "The exception from request processor ["
                                e
                }, e -> {  
import org.apache.logging.log4j.LogManager;
        this.searchRequestProcessors = Collections.unmodifiableList(requestProcessors);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        try {
                ? new TrackingSearchResponseProcessorWrapper(searchResponseProcessors.get(i))
                    // interruption.TrackingSearchResponseProcessorWrapper will log all errors in detail for debugging purposes
    }  
        String currentPhase,
    public static final String RESPONSE_PROCESSORS_KEY = "response_processors";
    public boolean isNoOp() {
    protected void onRequestProcessorFailed(Processor processor) {}  
        ActionListener<SearchResponse> finalListener = responseListener; // Jump directly to this one on exception.  
    ) throws SearchPipelineProcessingException {
                beforeResponseProcessor(processor);
        final ActionListener<SearchResponse> chainListener = responseListener;
import org.opensearch.common.Nullable;
                beforeRequestProcessor(processor);
        this.id = id;
    }
                            );
        // Chain listeners back-to-front
            requestListener.onFailure(new SearchPipelineProcessingException(e));
        ActionListener<SearchRequest> currentListener = finalListener;  
                                + id
            // Conditionally wrap the current processor with a TrackingSearchRequestProcessorWrapper  
                        );
                        } else {  
    private final String description;
        LongSupplier relativeTimeSupplier
        final long pipelineStart = relativeTimeSupplier.getAsLong();  
                            throw e;
                    && nextPhase.equals(searchPhaseResultsProcessor.getAfterPhase().getName())) {
    private final LongSupplier relativeTimeSupplier;
        ActionListener<SearchRequest> finalListener = getTerminalSearchRequestActionListener(requestListener);  
            onTransformResponseFailure();  
        } catch (RuntimeException e) {
        SearchPhaseContext context,  
import org.opensearch.action.search.SearchRequest;
/*  
            afterTransformRequest(took);
    }
        return id;  
        PipelineProcessingContext requestContext  
    protected void afterResponseProcessor(Processor processor, long timeInNanos) {}
    private final Integer version;
                        logger.warn(  
    // TODO: Refactor org.opensearch.ingest.CompoundProcessor to implement our generic Processor interface
                    long took = relativeTimeSupplier.getAsLong() - start;
    List<SearchRequestProcessor> getSearchRequestProcessors() {
        return searchPhaseResultsProcessors;
    ActionListener<SearchResponse> transformResponseListener(
        beforeTransformRequest();
    public static final String REQUEST_PROCESSORS_KEY = "request_processors";  
                    currentFinalListener.onResponse(rr);
                }
        for (int i = searchRequestProcessors.size() - 1; i >= 0; i--) {
                                + "] was ignored",  
                }));
        List<SearchPhaseResultsProcessor> phaseResultsProcessors,  
            originalListener.onResponse(r);
                        logger.warn(
        Collections.emptyList(),  
            final ActionListener<SearchRequest> nextListener = currentListener;
            for (SearchPhaseResultsProcessor searchPhaseResultsProcessor : searchPhaseResultsProcessors) {  
            responseListener = ActionListener.wrap(r -> {
            throw new SearchPipelineProcessingException(e);
            long took = relativeTimeSupplier.getAsLong() - pipelineStart;  
    <Result extends SearchPhaseResult> void runSearchPhaseResultsTransformer(
package org.opensearch.search.pipeline;
import java.util.function.LongSupplier;
        Collections.emptyList(),
 * compatible open source license.
            requestListener.onResponse(r);
                        );
            }, finalListener::onFailure);
        List<SearchResponseProcessor> responseProcessors,
                                    + "] in the search pipeline ["
    ) {  
                processor.processRequestAsync(r, requestContext, ActionListener.wrap(rr -> {
        });
        PipelineProcessingContext requestContext = pipelinedRequest.getPipelineProcessingContext();
        this.searchResponseProcessors = Collections.unmodifiableList(responseProcessors);
                : searchResponseProcessors.get(i);  
            long took = relativeTimeSupplier.getAsLong() - pipelineStart;
                                + "] in the search pipeline ["  
                                + processor.getType()
    ) {
                        // Pass the previous response through to the next processor in the chain
        return searchRequestProcessors;  
            return responseListener;
        this.description = description;
    private final String id;  
        "Pipeline that does not transform anything",
                    onRequestProcessorFailed(processor);  
    }
        this.version = version;  
                        if (searchPhaseResultsProcessor.isIgnoreFailure()) {  
        for (int i = searchResponseProcessors.size() - 1; i >= 0; i--) {
        return searchRequestProcessors.isEmpty() && searchPhaseResultsProcessors.isEmpty() && searchResponseProcessors.isEmpty();  
        return ActionListener.wrap(r -> {
                }, e -> {
                ? new TrackingSearchRequestProcessorWrapper(searchRequestProcessors.get(i))  
        SearchPhaseResults<Result> searchPhaseResult,
                    afterRequestProcessor(processor, took);
    }
        null,
            onTransformRequestFailure();  
                                    + id
                        nextListener.onFailure(new SearchPipelineProcessingException(e));
        () -> 0L
            afterTransformRequest(took);
    protected void afterTransformResponse(long timeInNanos) {}
                                + "] was ignored",
        if (searchResponseProcessors.isEmpty()) {  
        this.namedWriteableRegistry = namedWriteableRegistry;
    // Then these can be CompoundProcessors instead of lists.
                    if (processor.isIgnoreFailure() || r.source().verbosePipeline()) {  
 * this file be licensed under the Apache-2.0 license or a
            }, finalListener::onFailure);
                    long took = relativeTimeSupplier.getAsLong() - start;
    Integer getVersion() {
    Pipeline(  
        }  
    private static final Logger logger = LogManager.getLogger(Pipeline.class);
        NamedWriteableRegistry namedWriteableRegistry,
        String nextPhase,
        PipelineProcessingContext requestContext = pipelinedRequest.getPipelineProcessingContext();
                    } catch (Exception e) {
        @Nullable Integer version,  
                }));
                            e
        }, e -> {  
        return searchResponseProcessors;
    public static final String PHASE_PROCESSORS_KEY = "phase_results_processors";
        if (searchRequestProcessors.isEmpty()) {
                        currentFinalListener.onFailure(new SearchPipelineProcessingException(e));
        Collections.emptyList(),
            // if verbosePipeline mode is enabled. This allows detailed execution tracking for debugging purposes.
            long took = relativeTimeSupplier.getAsLong() - pipelineStart[0];  
                    afterResponseProcessor(processor, took);
    protected void afterTransformRequest(long timeInNanos) {}
    protected void onResponseProcessorFailed(Processor processor) {}  
                final long start = relativeTimeSupplier.getAsLong();  
                    long took = relativeTimeSupplier.getAsLong() - start;
                        searchPhaseResultsProcessor.process(searchPhaseResult, context, requestContext);
    private ActionListener<SearchRequest> getTerminalSearchRequestActionListener(ActionListener<SearchRequest> requestListener) {
            final ActionListener<SearchResponse> currentFinalListener = responseListener;  
                            "The exception from response processor ["
import org.opensearch.core.action.ActionListener;
    /**
    }
                    try {  
                    onResponseProcessorFailed(processor);  
                    }  
            beforeTransformResponse();  
    protected void onTransformResponseFailure() {}  
                processor.processResponseAsync(pipelinedRequest, r, requestContext, ActionListener.wrap(rr -> {

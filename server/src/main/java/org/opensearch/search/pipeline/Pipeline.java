                    }
        List<SearchPhaseResultsProcessor> phaseResultsProcessors,
            final ActionListener<SearchResponse> currentFinalListener = responseListener;
                    long took = relativeTimeSupplier.getAsLong() - start;
                        logger.warn(
 * The OpenSearch Contributors require contributions made to
            final ActionListener<SearchRequest> nextListener = currentListener;
        0,
        this.version = version;
package org.opensearch.search.pipeline;
                final long start = relativeTimeSupplier.getAsLong();
            originalListener.onResponse(r);
            chainListener.onResponse(r);
                    try {
                                + "] was ignored",
                                e
                    }
    List<SearchRequestProcessor> getSearchRequestProcessors() {
            onTransformResponseFailure();
                        }
        return id;
                    } catch (Exception e) {
        ActionListener<SearchRequest> finalListener = getTerminalSearchRequestActionListener(requestListener);
            originalListener.onFailure(e);
                            "The exception from response processor ["
                    afterRequestProcessor(processor, took);
    String getDescription() {
    }
import org.apache.logging.log4j.LogManager;
        ActionListener<SearchResponse> responseListener
            requestListener.onResponse(r);
                if (currentPhase.equals(searchPhaseResultsProcessor.getBeforePhase().getName())
        SearchPipelineService.NOOP_PIPELINE_ID,
                    afterResponseProcessor(processor, took);
                    // When verbosePipeline is enabled, all processor failures are ignored to ensure the execution chain continues without
            }, finalListener::onFailure);
        });
                                + "] was ignored",
        @Nullable Integer version,
                    onResponseProcessorFailed(processor);
 */
            beforeTransformResponse();
        }, e -> {
                ? new TrackingSearchRequestProcessorWrapper(searchRequestProcessors.get(i))
                                + processor.getType()
                    // When verbosePipeline is enabled, all processor failures are ignored to ensure the execution chain continues without
                                "The exception from search phase results processor ["
                    if (processor.isIgnoreFailure() || pipelinedRequest.source().verbosePipeline()) {
        responseListener = ActionListener.wrap(r -> {
    }
    }
        }, e -> {
}
                        } else {
    }
    protected void onTransformRequestFailure() {}
                    && nextPhase.equals(searchPhaseResultsProcessor.getAfterPhase().getName())) {
                ? new TrackingSearchResponseProcessorWrapper(searchResponseProcessors.get(i))
            return;
import org.opensearch.action.search.SearchPhaseResults;
                        currentFinalListener.onFailure(new SearchPipelineProcessingException(e));
        });
            long took = relativeTimeSupplier.getAsLong() - pipelineStart;
        this.searchPhaseResultsProcessors = Collections.unmodifiableList(phaseResultsProcessors);
    }
                }, e -> {
        if (searchRequestProcessors.isEmpty()) {
 */
        PipelineProcessingContext requestContext = pipelinedRequest.getPipelineProcessingContext();
    private final List<SearchPhaseResultsProcessor> searchPhaseResultsProcessors;
        PipelineProcessingContext requestContext = pipelinedRequest.getPipelineProcessingContext();
        return version;
    protected void afterRequestProcessor(Processor processor, long timeInNanos) {}
                }, e -> {
    public static final String REQUEST_PROCESSORS_KEY = "request_processors";
import org.apache.logging.log4j.Logger;
            afterTransformRequest(took);
        NamedWriteableRegistry namedWriteableRegistry,
        LongSupplier relativeTimeSupplier
    private ActionListener<SearchRequest> getTerminalSearchRequestActionListener(ActionListener<SearchRequest> requestListener) {
                        searchPhaseResultsProcessor.process(searchPhaseResult, context, requestContext);
                        nextListener.onFailure(new SearchPipelineProcessingException(e));
            onTransformRequestFailure();
        String currentPhase,
        // Chain listeners back-to-front
            for (SearchPhaseResultsProcessor searchPhaseResultsProcessor : searchPhaseResultsProcessors) {
                }
                processor.processRequestAsync(r, requestContext, ActionListener.wrap(rr -> {
    Pipeline(
    private final List<SearchRequestProcessor> searchRequestProcessors;
    protected void afterTransformRequest(long timeInNanos) {}
                long start = relativeTimeSupplier.getAsLong();
                    long took = relativeTimeSupplier.getAsLong() - start;
        }
            }, finalListener::onFailure);
                }));
                        currentFinalListener.onResponse(r);
                            "The exception from request processor ["
    private final NamedWriteableRegistry namedWriteableRegistry;
                                + "] in the search pipeline ["
     */
    static final Pipeline NO_OP_PIPELINE = new Pipeline(
                    } else {
        Collections.emptyList(),
    }
        if (searchResponseProcessors.isEmpty()) {
        "Pipeline that does not transform anything",
        this.id = id;
    private final LongSupplier relativeTimeSupplier;
                    afterRequestProcessor(processor, took);
 * this file be licensed under the Apache-2.0 license or a
        // do. Here is no need to do a stream copy to ensure the original search request is not changed.
    <Result extends SearchPhaseResult> void runSearchPhaseResultsTransformer(
                : searchResponseProcessors.get(i);
            }
            currentListener = ActionListener.wrap(r -> {
        // We directly modify the original search request since this is what we expect the search request processor to
        this.relativeTimeSupplier = relativeTimeSupplier;
        return ActionListener.wrap(r -> {
        null,
    }
        Collections.emptyList(),
    public boolean isNoOp() {
            final SearchResponseProcessor processor = pipelinedRequest.source().verbosePipeline()
class Pipeline {
    }
        }
    String getId() {
        this.namedWriteableRegistry = namedWriteableRegistry;
        String nextPhase,
        SearchPhaseResults<Result> searchPhaseResult,
                                    + id
                    // interruption.TrackingSearchResponseProcessorWrapper will log all errors in detail for debugging purposes
        try {
        return ActionListener.wrap(r -> {
            pipelineStart[0] = relativeTimeSupplier.getAsLong();
        () -> 0L
        ActionListener<SearchRequest> currentListener = finalListener;
                    long took = relativeTimeSupplier.getAsLong() - start;
        Collections.emptyList(),
import java.util.List;
    private final List<SearchResponseProcessor> searchResponseProcessors;
            long took = relativeTimeSupplier.getAsLong() - pipelineStart[0];
                                    + "] in the search pipeline ["
            afterTransformResponse(took);
import org.opensearch.action.search.SearchPhaseContext;
        final ActionListener<SearchResponse> chainListener = responseListener;
                    currentFinalListener.onResponse(rr);
        this.searchResponseProcessors = Collections.unmodifiableList(responseProcessors);
    Integer getVersion() {
        this.description = description;
                        logger.warn(
            afterTransformResponse(took);
            long took = relativeTimeSupplier.getAsLong() - pipelineStart[0];
            return responseListener;
    protected void onResponseProcessorFailed(Processor processor) {}
    public static final String PHASE_PROCESSORS_KEY = "phase_results_processors";
        }, originalListener::onFailure);
    public static final String RESPONSE_PROCESSORS_KEY = "response_processors";
        currentListener.onResponse(pipelinedRequest);
            throw new SearchPipelineProcessingException(e);
                            throw e;
import java.util.Collections;
        return description;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    void transformRequest(PipelinedRequest pipelinedRequest, ActionListener<SearchRequest> requestListener)
        long[] pipelineStart = new long[1];
        return searchResponseProcessors;
import org.opensearch.core.action.ActionListener;
            requestListener.onResponse(pipelinedRequest);
                    if (processor.isIgnoreFailure() || r.source().verbosePipeline()) {
                            logger.warn(
    }
    protected void beforeRequestProcessor(Processor processor) {}
                        if (searchPhaseResultsProcessor.isIgnoreFailure()) {
        PipelinedRequest pipelinedRequest,
                    onRequestProcessorFailed(processor);
    List<SearchPhaseResultsProcessor> getSearchPhaseResultsProcessors() {
        List<SearchResponseProcessor> responseProcessors,
                        );
import org.opensearch.action.search.SearchResponse;
    protected void beforeResponseProcessor(Processor processor) {}
    private static final Logger logger = LogManager.getLogger(Pipeline.class);
                beforeRequestProcessor(processor);
    // Then these can be CompoundProcessors instead of lists.
            final SearchRequestProcessor processor = pipelinedRequest.source().verbosePipeline()
                        nextListener.onResponse(r);
            // if verbosePipeline mode is enabled. This allows detailed execution tracking for debugging purposes.
    // TODO: Refactor org.opensearch.ingest.CompoundProcessor to implement our generic Processor interface
        throws SearchPipelineProcessingException {
    }
/*
        for (int i = searchRequestProcessors.size() - 1; i >= 0; i--) {
                    }
    protected void onRequestProcessorFailed(Processor processor) {}
    private final String description;
     * @return If this is a no-op pipeline
    ) throws SearchPipelineProcessingException {
        final long pipelineStart = relativeTimeSupplier.getAsLong();
                processor.processResponseAsync(pipelinedRequest, r, requestContext, ActionListener.wrap(rr -> {
        for (int i = searchResponseProcessors.size() - 1; i >= 0; i--) {
        List<SearchRequestProcessor> requestProcessors,
import org.opensearch.action.search.SearchRequest;
        @Nullable String description,
    private final Integer version;
            responseListener = ActionListener.wrap(r -> {
                            e
                    // interruption.TrackingSearchResponseProcessorWrapper will log all errors in detail for debugging purposes
        PipelineProcessingContext requestContext
 * SPDX-License-Identifier: Apache-2.0
            long took = relativeTimeSupplier.getAsLong() - pipelineStart;
    }
        } catch (RuntimeException e) {
                        // Pass the previous response through to the next processor in the chain
                    afterResponseProcessor(processor, took);
    /**
                        );
        return searchPhaseResultsProcessors;
                    nextListener.onResponse(rr);
                }));
        final ActionListener<SearchResponse> originalListener = responseListener;
        String id,
    ) {
    List<SearchResponseProcessor> getSearchResponseProcessors() {
 * compatible open source license.
                                    + "] was ignored",
    protected void beforeTransformRequest() {}
        }
                            );
 * Concrete representation of a search pipeline, holding multiple processors.
    protected void beforeTransformResponse() {}
        this.searchRequestProcessors = Collections.unmodifiableList(requestProcessors);
    );
                beforeResponseProcessor(processor);
    protected void afterTransformResponse(long timeInNanos) {}
        }
        }
                                + id
            requestListener.onFailure(new SearchPipelineProcessingException(e));
            // Conditionally wrap the current processor with a TrackingSearchRequestProcessorWrapper
                                    + searchPhaseResultsProcessor.getType()
                                + "] in the search pipeline ["
                    } else {
        ActionListener<SearchResponse> finalListener = responseListener; // Jump directly to this one on exception.
 *
import java.util.function.LongSupplier;
/**
                                + id
                    long took = relativeTimeSupplier.getAsLong() - start;
import org.opensearch.search.SearchPhaseResult;
                                + processor.getType()
                : searchRequestProcessors.get(i);
    protected void onTransformResponseFailure() {}
    private final String id;
            afterTransformRequest(took);
    ) {
        return searchRequestProcessors.isEmpty() && searchPhaseResultsProcessors.isEmpty() && searchResponseProcessors.isEmpty();
        beforeTransformRequest();
    }
        SearchPhaseContext context,
                            e
import org.opensearch.common.Nullable;
    protected void afterResponseProcessor(Processor processor, long timeInNanos) {}
    ActionListener<SearchResponse> transformResponseListener(
        return searchRequestProcessors;

            }
            String tag,
                        + "which is automatically generated when executing a match query against [%s].",
        public static final String TYPE = "example-search-response-processor-factory";
    public SearchResponse processResponse(SearchRequest request, SearchResponse response) throws Exception {
package org.opensearch.example.systemsearchprocessor;
    @Override
 * The OpenSearch Contributors require contributions made to
            return searchResponse;
        return DESCRIPTION;
        return new SearchResponse(
     * ExampleSearchResponseProcessor constructor
            }
        // Build final SearchResponse
            new SearchProfileShardResults(searchResponse.getProfileResults()),
    public SearchResponse processResponse(SearchRequest request, SearchResponse searchResponse, PipelineProcessingContext requestContext)
        return TYPE;
        int originalQuerySize = originalQuerySizeObj == null ? 1 : Integer.parseInt(originalQuerySizeObj.toString());
            searchResponse.getTotalShards(),
            boolean ignoreFailure,
        return ignoreFailure;
            searchResponse.isTimedOut(),
            searchResponse.isTerminatedEarly(),
    /**
    }
    }
            .anyMatch(processor -> CONFLICT_PROCESSOR_TYPE.equals(processor.getType()));
            String.format(Locale.ROOT, " [%s] should process the search response with PipelineProcessingContext.", TYPE)
    public String getDescription() {
    public String getTag() {
        ) throws Exception {
        // Build new SearchResponseSections
            searchResponse.getClusters(),
        }
     * @param ignoreFailure should processor ignore the failure
            if (searchRequest == null || searchRequest.source() == null || searchRequest.source().query() == null) {
            newHits,
import org.opensearch.search.pipeline.SystemGeneratedProcessor;
        throws Exception {
import org.opensearch.action.search.SearchResponseSections;
            Map<String, Object> config,
import org.opensearch.action.search.SearchRequest;
        final SearchResponseSections newSections = new SearchResponseSections(
        }
            SearchRequest searchRequest = context.searchRequest();
            PipelineContext pipelineContext
import java.util.Arrays;
    public ExecutionStage getExecutionStage() {
            );
        return this.tag;
        Object originalQuerySizeObj = requestContext.getAttribute(ORIGINAL_QUERY_SIZE_KEY);
    }
    public ExampleSearchResponseProcessor(String tag, boolean ignoreFailure) {
    @Override
 * SPDX-License-Identifier: Apache-2.0
    static class Factory implements SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor> {
    public String getType() {
        this.tag = tag;
        this.ignoreFailure = ignoreFailure;
        long newTookMillis = searchResponse.getTook().millis() + elapsedMillis;
                String fieldName = matchQueryBuilder.fieldName();
            searchResponse.getHits().getCollapseValues()
    @Override
import org.opensearch.search.profile.SearchProfileShardResults;
                return false;
            searchResponse.getAggregations(),
                    "The [%s] processor cannot be used in a search pipeline because it conflicts with the [%s] processor, "
    }
     * type of the processor
        SearchHit[] allHits = searchResponse.getHits().getHits();
        public boolean shouldGenerate(ProcessorGenerationContext context) {
            searchResponse.getHits().getSortFields(),
    }
import org.opensearch.search.pipeline.ProcessorGenerationContext;
 * compatible open source license.
            selected.toArray(new SearchHit[0]),
        final SearchHits newHits = new SearchHits(
        long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTimeNanos);
            searchResponse.getHits().getTotalHits(),
        );
    }
            newTookMillis,
            searchResponse.getScrollId(),
import org.opensearch.index.query.QueryBuilder;
            searchResponse.getNumReducePhases(),
        if (originalQuerySize > allHits.length) {
/*
        boolean hasTruncateHitsProcessor = context.getUserDefinedSearchResponseProcessors()
    }
import static org.opensearch.example.systemsearchprocessor.ExampleSearchRequestPreProcessor.ORIGINAL_QUERY_SIZE_KEY;
            .stream()
        );
import java.util.Locale;
    private final String tag;
    }
                return TRIGGER_FIELD.equals(fieldName);
            searchResponse.getPhaseTook(),
    }
    @Override
     */
            Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,
    private static final String DESCRIPTION = "This is a system generated search response processor which will be"
        @Override
        + "executed before the user defined search request. It will truncate the hits in the response.";
     */
    private static final String CONFLICT_PROCESSOR_TYPE = "truncate_hits";
        // Adjust timing
    private final boolean ignoreFailure;
        @Override
    @Override
    public boolean isIgnoreFailure() {
            return false;
    private static final String TRIGGER_FIELD = "trigger_field";
            QueryBuilder queryBuilder = searchRequest.source().query();
import org.opensearch.index.query.MatchQueryBuilder;
import java.util.List;
        long startTimeNanos = System.nanoTime();
        // Build new SearchHits
import org.opensearch.search.pipeline.PipelineProcessingContext;
                    Locale.ROOT,
import org.opensearch.search.SearchHits;
import java.util.Map;
import org.opensearch.search.pipeline.SearchResponseProcessor;
public class ExampleSearchResponseProcessor implements SearchResponseProcessor, SystemGeneratedProcessor {
        throw new UnsupportedOperationException(
     * @param tag tag of the processor
            String description,
        // Select subset of hits
    @Override
            searchResponse.getHits().getMaxScore(),
import org.opensearch.search.pipeline.ProcessorConflictEvaluationContext;
            searchResponse.getShardFailures(),
    @Override
}
        public SearchResponseProcessor create(
import org.opensearch.search.pipeline.Processor;
 */
 * this file be licensed under the Apache-2.0 license or a
        List<SearchHit> selected = Arrays.asList(Arrays.copyOf(allHits, originalQuerySize));
import java.util.concurrent.TimeUnit;
import org.opensearch.search.SearchHit;
/**
    public static final String TYPE = "example-search-response-processor";
 *
import org.opensearch.action.search.SearchResponse;
            searchResponse.getHits().getCollapseField(),
            if (queryBuilder instanceof MatchQueryBuilder matchQueryBuilder) {
        }
            newSections,
                )
                String.format(
            searchResponse.getSuggest(),
    /**
    public void evaluateConflicts(ProcessorConflictEvaluationContext context) throws IllegalArgumentException {
            searchResponse.getInternalResponse().getSearchExtBuilders()
            searchResponse.getSkippedShards(),
            searchResponse.getSuccessfulShards(),
 * An example system generated search response processor that will be executed before the user defined processor
 */
            throw new IllegalArgumentException(
                    TRIGGER_FIELD
    }
                    CONFLICT_PROCESSOR_TYPE,
        if (hasTruncateHitsProcessor) {
                    TYPE,
            return new ExampleSearchResponseProcessor(tag, ignoreFailure);
        );
        // auto generate the processor if we do match query against the trigger_field
        }
        );
            searchResponse.pointInTimeId()
        return ExecutionStage.PRE_USER_DEFINED;
    @Override

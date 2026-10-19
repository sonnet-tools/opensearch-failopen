        if (originalQuerySize > allHits.length) {
    }
            searchResponse.getPhaseTook(),  
import org.opensearch.search.pipeline.PipelineProcessingContext;
import org.opensearch.search.pipeline.Processor;  
            searchResponse.getHits().getCollapseValues()  
    public ExecutionStage getExecutionStage() {
            );  
            searchResponse.getClusters(),
import org.opensearch.search.SearchHit;  
            PipelineContext pipelineContext
                    TYPE,  
            SearchRequest searchRequest = context.searchRequest();
    }
import static org.opensearch.example.systemsearchprocessor.ExampleSearchRequestPreProcessor.ORIGINAL_QUERY_SIZE_KEY;
        if (hasTruncateHitsProcessor) {
    }
        return this.tag;
     * @param tag tag of the processor
    @Override
            String.format(Locale.ROOT, " [%s] should process the search response with PipelineProcessingContext.", TYPE)
            searchResponse.isTerminatedEarly(),  
        public static final String TYPE = "example-search-response-processor-factory";
                    CONFLICT_PROCESSOR_TYPE,
            boolean ignoreFailure,  
        final SearchHits newHits = new SearchHits(  
        Object originalQuerySizeObj = requestContext.getAttribute(ORIGINAL_QUERY_SIZE_KEY);  
            Map<String, Object> config,
            return new ExampleSearchResponseProcessor(tag, ignoreFailure);
                )
    private static final String CONFLICT_PROCESSOR_TYPE = "truncate_hits";
            searchResponse.getAggregations(),  
     */
        @Override
        long newTookMillis = searchResponse.getTook().millis() + elapsedMillis;
        public SearchResponseProcessor create(
 * The OpenSearch Contributors require contributions made to  
    @Override
    }
}
    private final String tag;  
            QueryBuilder queryBuilder = searchRequest.source().query();
            String description,
import org.opensearch.search.SearchHits;
import org.opensearch.index.query.MatchQueryBuilder;
            searchResponse.getSuccessfulShards(),  
import java.util.concurrent.TimeUnit;
        this.ignoreFailure = ignoreFailure;
            searchResponse.getTotalShards(),
            searchResponse.getScrollId(),
        );
        );
        // auto generate the processor if we do match query against the trigger_field
    private static final String DESCRIPTION = "This is a system generated search response processor which will be"
    /**
    }  
            searchResponse.getHits().getMaxScore(),  
        }
        return TYPE;  
            }  
    @Override
            searchResponse.isTimedOut(),
    public String getType() {
        return DESCRIPTION;
    public String getDescription() {  
        throws Exception {
            selected.toArray(new SearchHit[0]),
            new SearchProfileShardResults(searchResponse.getProfileResults()),
import org.opensearch.search.pipeline.SystemGeneratedProcessor;
            String tag,
                return false;  
    }  
import org.opensearch.action.search.SearchResponseSections;  
            .anyMatch(processor -> CONFLICT_PROCESSOR_TYPE.equals(processor.getType()));  
    /**  
import java.util.Map;
            return false;
 * this file be licensed under the Apache-2.0 license or a
        boolean hasTruncateHitsProcessor = context.getUserDefinedSearchResponseProcessors()
    public void evaluateConflicts(ProcessorConflictEvaluationContext context) throws IllegalArgumentException {  
    }
        throw new UnsupportedOperationException(  
            searchResponse.getSkippedShards(),
    public static final String TYPE = "example-search-response-processor";
        }
/**  
        long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTimeNanos);
    }
            .stream()
import org.opensearch.search.pipeline.SearchResponseProcessor;  
    static class Factory implements SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor> {
        int originalQuerySize = originalQuerySizeObj == null ? 1 : Integer.parseInt(originalQuerySizeObj.toString());
import org.opensearch.search.pipeline.ProcessorGenerationContext;
        + "executed before the user defined search request. It will truncate the hits in the response.";  
import org.opensearch.search.profile.SearchProfileShardResults;
            newTookMillis,
/*  
    private final boolean ignoreFailure;
        );
            searchResponse.getHits().getCollapseField(),
 */  
package org.opensearch.example.systemsearchprocessor;
                    Locale.ROOT,
            searchResponse.getNumReducePhases(),
        // Build new SearchResponseSections  
    public String getTag() {
            return searchResponse;  
    public SearchResponse processResponse(SearchRequest request, SearchResponse searchResponse, PipelineProcessingContext requestContext)  
                    TRIGGER_FIELD
import org.opensearch.action.search.SearchResponse;
     */  
    private static final String TRIGGER_FIELD = "trigger_field";
    public ExampleSearchResponseProcessor(String tag, boolean ignoreFailure) {
        // Adjust timing  
import java.util.Arrays;
        return ignoreFailure;  
                    "The [%s] processor cannot be used in a search pipeline because it conflicts with the [%s] processor, "  
import org.opensearch.index.query.QueryBuilder;
            searchResponse.getHits().getSortFields(),
            newSections,  
    }  
import org.opensearch.search.pipeline.ProcessorConflictEvaluationContext;
            searchResponse.pointInTimeId()  
        SearchHit[] allHits = searchResponse.getHits().getHits();
            newHits,
                        + "which is automatically generated when executing a match query against [%s].",
                String.format(
     * @param ignoreFailure should processor ignore the failure  
 *
        // Select subset of hits  
    }  
        final SearchResponseSections newSections = new SearchResponseSections(
            throw new IllegalArgumentException(  
        List<SearchHit> selected = Arrays.asList(Arrays.copyOf(allHits, originalQuerySize));  
    @Override  
        // Build new SearchHits
        @Override
            }
        // Build final SearchResponse
        return new SearchResponse(
        ) throws Exception {  
                return TRIGGER_FIELD.equals(fieldName);
import java.util.List;
 */
        }
            searchResponse.getHits().getTotalHits(),
    @Override  
        long startTimeNanos = System.nanoTime();
            searchResponse.getInternalResponse().getSearchExtBuilders()  
import org.opensearch.action.search.SearchRequest;
    public boolean isIgnoreFailure() {
            searchResponse.getShardFailures(),
     * ExampleSearchResponseProcessor constructor
 * SPDX-License-Identifier: Apache-2.0
        );
import java.util.Locale;  
            Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,  
        this.tag = tag;  
        public boolean shouldGenerate(ProcessorGenerationContext context) {  
     * type of the processor
    @Override
    @Override
            if (searchRequest == null || searchRequest.source() == null || searchRequest.source().query() == null) {
                String fieldName = matchQueryBuilder.fieldName();
public class ExampleSearchResponseProcessor implements SearchResponseProcessor, SystemGeneratedProcessor {  
 * compatible open source license.
            searchResponse.getSuggest(),
    @Override
        }
 * An example system generated search response processor that will be executed before the user defined processor
            if (queryBuilder instanceof MatchQueryBuilder matchQueryBuilder) {  
        return ExecutionStage.PRE_USER_DEFINED;
    public SearchResponse processResponse(SearchRequest request, SearchResponse response) throws Exception {

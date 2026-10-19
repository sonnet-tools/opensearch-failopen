import org.opensearch.search.SearchPhaseResult;
import java.util.Map;
        public boolean shouldGenerate(ProcessorGenerationContext context) {
import org.opensearch.search.pipeline.ProcessorGenerationContext;  
    public SearchPhaseName getBeforePhase() {
            Map<String, Processor.Factory<SearchPhaseResultsProcessor>> processorFactories,
 * SPDX-License-Identifier: Apache-2.0
    }
    }
        searchPhaseResult.getAtomicArray().asList().forEach(searchResult -> { searchResult.queryResult().topDocs().maxScore = 10; });
        @Override
    public SearchPhaseName getAfterPhase() {
public class ExampleSearchPhaseResultsProcessor implements SystemGeneratedProcessor, SearchPhaseResultsProcessor {  
            String description,
        ) throws Exception {
        return this.tag;  
     */
    }
}  
        @Override  
    static class Factory implements SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor> {
    @Override
    }
        + "executed after the user defined search request. It will set the max score as 10.";  
    private final boolean ignoreFailure;
        public static final String TYPE = "example-search-phase-results-processor-factory";
     * ExampleSearchPhaseResultsProcessor constructor
    }  
/*  
            Map<String, Object> config,  
    }  
        return TYPE;
import org.opensearch.action.search.SearchPhaseName;
import org.opensearch.action.search.SearchPhaseResults;  
 * The OpenSearch Contributors require contributions made to  
    private static final String TYPE = "example-search-phase-results-processor";
        return this.ignoreFailure;
        return DESCRIPTION;
            boolean ignoreFailure,
 * this file be licensed under the Apache-2.0 license or a
    }
        this.ignoreFailure = ignoreFailure;
 */
        public SearchPhaseResultsProcessor create(
    @Override  
    public boolean isIgnoreFailure() {  
    public String getType() {  
    @Override
    @Override  
        this.tag = tag;
 *
        }
    public String getTag() {
    ) {  
    }  
     * @param ignoreFailure should processor ignore the failure
    public <Result extends SearchPhaseResult> void process(  
        SearchPhaseResults<Result> searchPhaseResult,
        return SearchPhaseName.QUERY;  
     * @param tag processor tag  
        return SearchPhaseName.FETCH;
        SearchPhaseContext searchPhaseContext
package org.opensearch.example.systemsearchprocessor;
    public ExampleSearchPhaseResultsProcessor(String tag, boolean ignoreFailure) {  
import org.opensearch.search.pipeline.SystemGeneratedProcessor;
            PipelineContext pipelineContext
            return new ExampleSearchPhaseResultsProcessor(tag, ignoreFailure);  
import org.opensearch.search.pipeline.SearchPhaseResultsProcessor;
    private final String tag;
    @Override
 * An example system generated search phase results processor that will be executed after the user defined processor
    @Override
/**  
 */  
    }
import org.opensearch.action.search.SearchPhaseContext;
    private static final String DESCRIPTION = "This is a system generated search phase results processor which will be"
    @Override
    /**
            return true;  
    public String getDescription() {
        }
 * compatible open source license.
            String tag,  
import org.opensearch.search.pipeline.Processor;

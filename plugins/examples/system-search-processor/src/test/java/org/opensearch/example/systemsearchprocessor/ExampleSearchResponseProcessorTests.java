        SearchResponseProcessor mockProcessor = mock(SearchResponseProcessor.class);
    public void testFactoryCreateReturnsProcessor() throws Exception {
        ExampleSearchResponseProcessor.Factory factory = new ExampleSearchResponseProcessor.Factory();
            Map.of(),
        ExampleSearchResponseProcessor.Factory factory = new ExampleSearchResponseProcessor.Factory();  
        SearchResponse processed = processor.processResponse(new SearchRequest(), response, ctx);  
        hit1.score(1.0f);
            () -> processor.processResponse(request, response)
import org.opensearch.search.pipeline.SearchResponseProcessor;
        SearchHits hits = new SearchHits(new SearchHit[] { hit1, hit2, hit3 }, null, 8.0f);
    public void testProcessResponseDoesNotTruncateWhenOriginalSizeLarger() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.search.SearchRequest;
        SearchRequest request = new SearchRequest();  
        SearchHit hit1 = new SearchHit(1);
        SearchRequest request = new SearchRequest();
        SearchHit hit1 = new SearchHit(1);
            Map.of(),  
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  
import org.opensearch.test.OpenSearchTestCase;  
    }
    }
        when(mockProcessor.getType()).thenReturn("truncate_hits");  
        assertSame(response, processed);
        ctx.setAttribute(ExampleSearchRequestPreProcessor.ORIGINAL_QUERY_SIZE_KEY, 5);  
        SearchResponse response = new SearchResponse(sections, null, 1, 1, 0, 10, null, null, null, null);
        ExampleSearchResponseProcessor processor = (ExampleSearchResponseProcessor) factory.create(
    public void testProcessResponseUnsupportedOperation() {
    public void testProcessResponseTruncatesHits() throws Exception {
        ProcessorConflictEvaluationContext ctx = mock(ProcessorConflictEvaluationContext.class);  
        hit1.score(5.0f);
            true,
import org.opensearch.action.search.SearchResponse;
    }
import org.opensearch.index.query.MatchQueryBuilder;
import static org.mockito.Mockito.when;  
        ExampleSearchResponseProcessor processor = new ExampleSearchResponseProcessor("tag", false);
        SearchResponse processed = processor.processResponse(new SearchRequest(), response, ctx);
    public void testEvaluateConflictsDoesNothingWhenNoConflict() {
        when(ctx.getUserDefinedSearchResponseProcessors()).thenReturn(List.of(mockProcessor));
        assertEquals(8.0f, newHits.getMaxScore(), 0.0001f);
        request.source(sourceBuilder);
        assertTrue(ex.getMessage().contains(ExampleSearchResponseProcessor.TYPE));
/*  
            "desc",
    public void testEvaluateConflictsThrowsWhenConflictProcessorExists() {
    }
        assertTrue(factory.shouldGenerate(ctx));  
        UnsupportedOperationException ex = assertThrows(  
import org.opensearch.search.pipeline.ProcessorGenerationContext;
        hit2.score(8.0f);
import static org.mockito.Mockito.mock;
        SearchResponseSections sections = new SearchResponseSections(hits, null, null, false, false, null, 1, List.of());
        sourceBuilder.query(new MatchQueryBuilder("trigger_field", "value"));
    }
import org.opensearch.search.pipeline.ProcessorConflictEvaluationContext;  
import org.opensearch.search.SearchHits;  
        ProcessorGenerationContext ctx = new ProcessorGenerationContext(request, null);
 * compatible open source license.
        ctx.setAttribute(ExampleSearchRequestPreProcessor.ORIGINAL_QUERY_SIZE_KEY, 2);
    public void testFactoryShouldGenerateTrueWhenMatchQueryOnTriggerField() {
    }
import org.opensearch.search.pipeline.PipelineProcessingContext;
            UnsupportedOperationException.class,
        PipelineProcessingContext ctx = new PipelineProcessingContext();
 * The OpenSearch Contributors require contributions made to  
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> processor.evaluateConflicts(ctx));  
        SearchHit hit3 = new SearchHit(3);
        sourceBuilder.query(new MatchQueryBuilder("field", "value"));
import java.util.Map;  
            null
        hit3.score(3.0f);  
        SearchResponse response = new SearchResponse(sections, null, 1, 1, 0, 10, null, null, null, null);  
        assertEquals(2, newHits.getHits().length);  
        SearchResponse response = mock(SearchResponse.class);
        assertTrue(ex.getMessage().contains("truncate_hits"));
        SearchHits newHits = processed.getHits();
        ProcessorGenerationContext ctx = new ProcessorGenerationContext(request, null);
        PipelineProcessingContext ctx = new PipelineProcessingContext();  
 */  
package org.opensearch.example.systemsearchprocessor;
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        SearchHits hits = new SearchHits(new SearchHit[] { hit1 }, null, 1.0f);
    public void testFactoryShouldGenerateFalseForNonMatchQuery() {  
import java.util.List;
 *
        );
        assertTrue(processor.isIgnoreFailure());  
        when(ctx.getUserDefinedSearchResponseProcessors()).thenReturn(List.of());
        assertFalse(factory.shouldGenerate(ctx));
    }  
}
        ExampleSearchResponseProcessor processor = new ExampleSearchResponseProcessor("tag", false);
        ExampleSearchResponseProcessor processor = new ExampleSearchResponseProcessor("tag", false);
        request.source(sourceBuilder);  
        assertEquals("tag", processor.getTag());
        SearchRequest request = new SearchRequest();  
import org.opensearch.action.search.SearchResponseSections;  
        ProcessorConflictEvaluationContext ctx = mock(ProcessorConflictEvaluationContext.class);  
        SearchHit hit2 = new SearchHit(2);  
        ExampleSearchResponseProcessor.Factory factory = new ExampleSearchResponseProcessor.Factory();
import org.opensearch.search.SearchHit;
import org.opensearch.search.builder.SearchSourceBuilder;
        ExampleSearchResponseProcessor processor = new ExampleSearchResponseProcessor("tag", false);
public class ExampleSearchResponseProcessorTests extends OpenSearchTestCase {
            "tag",  
    }
        processor.evaluateConflicts(ctx);
        );  
 * SPDX-License-Identifier: Apache-2.0
        SearchResponseSections sections = new SearchResponseSections(hits, null, null, false, false, null, 1, List.of());  
        ExampleSearchResponseProcessor processor = new ExampleSearchResponseProcessor("tag", false);
        assertNotNull(processor);

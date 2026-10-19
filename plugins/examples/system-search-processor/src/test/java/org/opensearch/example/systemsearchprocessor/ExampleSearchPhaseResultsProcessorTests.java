 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.example.systemsearchprocessor;
        // Create a TopDocs with some initial maxScore  
 *
        querySearchResult.topDocs(new TopDocsAndMaxScore(topDocs, 1.5f), null);  
        @SuppressWarnings("unchecked")
import static org.mockito.Mockito.mock;  
        TopDocs topDocs = new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), scoreDocs);
import org.apache.lucene.search.TotalHits;  
        SearchPhaseContext context = mock(SearchPhaseContext.class);
    }  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
    }  
}
        // Verify maxScore is set to 10
import org.opensearch.search.query.QuerySearchResult;  
 */  
        SearchPhaseResultsProcessor processor = factory.create(null, null, null, true, null, null);
    public void testProcess() throws Exception {
import org.opensearch.action.search.SearchRequest;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.pipeline.SearchPhaseResultsProcessor;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.search.SearchPhaseContext;
        assertTrue(factory.shouldGenerate(context));
        // Wrap in SearchPhaseResults with a single shard result  
        ScoreDoc[] scoreDocs = new ScoreDoc[] { new ScoreDoc(0, 1.5f) };
import org.opensearch.search.SearchPhaseResult;  
        resultAtomicArray.set(0, searchPhaseResult);
import org.opensearch.common.util.concurrent.AtomicArray;
import org.opensearch.search.pipeline.ProcessorGenerationContext;
import static org.mockito.Mockito.when;
        processor.process(results, context);
import org.opensearch.test.OpenSearchTestCase;
        when(results.getAtomicArray()).thenReturn(resultAtomicArray);
    public void testShouldGenerate_thenAlwaysTrue() {
 * compatible open source license.
import org.apache.lucene.search.ScoreDoc;
        // Create a dummy context
import org.apache.lucene.search.TopDocs;
/*  
        // Wrap in a QuerySearchResult
        SearchPhaseResults<SearchPhaseResult> results = mock(SearchPhaseResults.class);
        AtomicArray<SearchPhaseResult> resultAtomicArray = new AtomicArray<>(1);  
        QuerySearchResult querySearchResult = new QuerySearchResult();
import org.opensearch.action.search.SearchPhaseResults;
        assertEquals(10f, querySearchResult.topDocs().maxScore, 0.0001f);
    private final ExampleSearchPhaseResultsProcessor.Factory factory = new ExampleSearchPhaseResultsProcessor.Factory();
        // Wrap in a SearchPhaseResult (mocked to keep it simple)
        when(searchPhaseResult.queryResult()).thenReturn(querySearchResult);
        SearchPhaseResult searchPhaseResult = mock(SearchPhaseResult.class);  
public class ExampleSearchPhaseResultsProcessorTests extends OpenSearchTestCase {  
    private final ProcessorGenerationContext context = new ProcessorGenerationContext(mock(SearchRequest.class), null);

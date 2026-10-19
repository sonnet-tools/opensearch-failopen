        expectThrows(
        );
import org.opensearch.action.search.SearchResponse;  
    private void createTestIndex() {
    @Override
    }
import org.opensearch.search.builder.SearchSourceBuilder;
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
@AwaitsFix(bugUrl = "analytics engine pipeline not E2E complete: fragment conversion + shard execution + Arrow Flight drain not yet wired")
        createTestIndex();  
    }
/*  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
/**
    public void testSearchFailsForNonexistentIndex() {
package org.opensearch.dsl;
        client().prepareIndex(INDEX).setSource("{\"name\":\"laptop\",\"price\":1200}", XContentType.JSON).get();
import org.opensearch.common.xcontent.XContentType;
 * Integration test that verifies the full DSL query execution pipeline:
        return List.of(AnalyticsPlugin.class, DslQueryExecutorPlugin.class);
        refresh(INDEX);
        assertEquals(200, response.status().getStatus());
        createIndex("test-index-2");
    public void testSearchFailsForMultipleIndices() {
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(response.getTook().millis() >= 0);
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 */  
        createIndex(INDEX);
        assertEquals(0L, response.getHits().getTotalHits().value());
        // Currently returns empty hits (stub) , will be populated when conversion is implemented  
            Exception.class,
        );
import org.opensearch.analytics.AnalyticsPlugin;
            () -> client().search(new SearchRequest("nonexistent-index").source(new SearchSourceBuilder())).actionGet()
            Exception.class,  
 *
    }  
        SearchResponse response = client().search(new SearchRequest(INDEX).source(new SearchSourceBuilder())).actionGet();
import org.opensearch.action.search.SearchRequest;
import org.opensearch.test.OpenSearchIntegTestCase;
 * compatible open source license.
        expectThrows(
}
        createTestIndex();
import java.util.List;
 * SearchActionFilter → TransportExecuteAction → SearchSourceConverter → DslQueryPlanExecutor → SearchResponse.  
    }
        ensureGreen();  
import org.opensearch.plugins.Plugin;  
    private static final String INDEX = "test-index";  
    public void testSearchReturnsEmptyResponse() {
        ensureGreen();
 */
public class DslQueryExecutorIT extends OpenSearchIntegTestCase {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)  
import java.util.Collection;
            () -> client().search(new SearchRequest(INDEX, "test-index-2").source(new SearchSourceBuilder())).actionGet()  
        assertNotNull(response);  
    }  

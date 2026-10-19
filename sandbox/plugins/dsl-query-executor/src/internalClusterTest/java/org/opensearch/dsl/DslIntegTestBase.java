 */
        assertNotNull(response);  
import org.opensearch.analytics.AnalyticsPlugin;  
    protected SearchResponse search(SearchSourceBuilder source) {
    }  
 * The OpenSearch Contributors require contributions made to  
    }
package org.opensearch.dsl;
}  
            .get();  
import org.opensearch.plugins.Plugin;
 */  
import java.util.List;
    protected void assertOk(SearchResponse response) {
        assertEquals(200, response.status().getStatus());
    }
import java.util.Collection;  
        ensureGreen();  
/*  
        return client().search(new SearchRequest(INDEX).source(source)).actionGet();
        return List.of(AnalyticsPlugin.class, DslQueryExecutorPlugin.class);
 * compatible open source license.
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)  
 * Base class for DSL query executor integration tests.  
import org.opensearch.action.search.SearchResponse;
        createIndex(INDEX);
public abstract class DslIntegTestBase extends OpenSearchIntegTestCase {
 * Provides shared index setup and search helper.
            .setSource("{\"name\":\"laptop\",\"price\":1200,\"brand\":\"brandX\",\"rating\":4.5}", XContentType.JSON)
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.search.builder.SearchSourceBuilder;  
        client().prepareIndex(INDEX)
import org.opensearch.test.OpenSearchIntegTestCase;
 *
        refresh(INDEX);
 * this file be licensed under the Apache-2.0 license or a
//  actual hit count, field values, sort order, and aggregation buckets.
/**
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.SearchRequest;
// TODO: once end-to-end execution returns real results, update ITs to verify  
    protected void createTestIndex() {
    }
    @Override
    protected static final String INDEX = "test-index";  

            refresh();  
     * Tests that extreme nesting (under max_query_string_length) is rejected.
                    .prepareUpdateSettings()  
     */  
                    .prepareUpdateSettings()
            String query = buildNestedQuery(50, "field:value");  
            SearchResponse response = client().prepareSearch("test_lower").setQuery(queryStringQuery(query)).get();
     */  
        for (int i = 0; i < nestingDepth; i++) {  
            // Same query (depth 50) should now be rejected
import static org.hamcrest.Matchers.containsString;
                    .setTransientSettings(Settings.builder().putNull(SEARCH_MAX_QUERY_NESTING_DEPTH.getKey()))
 * Integration test for the search.query.max_query_nesting_depth cluster setting.
        }
        sb.append(innerTerm);
            ensureGreen("test_lower");
        } finally {  
                    .cluster()  
            assertThat(e.getDetailedMessage(), containsString("nesting depth exceeds max allowed depth 30"));
    }
            // Same query (depth 250) should now succeed
}
            SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery(deepQuery)).get();  
            client().prepareIndex("test").setId("1").setSource("field", "value").get();
                    .cluster()  
     * Tests that lowering the limit dynamically rejects previously-allowed queries.
            );  
                    .setTransientSettings(Settings.builder().put(SEARCH_MAX_QUERY_NESTING_DEPTH.getKey(), 300))
        String query = buildNestedQuery(15000, "field:value");  
            assertAcked(
import static org.opensearch.search.SearchService.SEARCH_MAX_QUERY_NESTING_DEPTH;
            sb.append(')');
     * 1. Query with depth > default limit (200) is rejected
/*  
                    .prepareUpdateSettings()
        assertTrue("Payload must be under max_query_string_length", query.length() < 32000);
 *
            assertNoFailures(response);
 */  
                    .cluster()  
            });  
            assertAcked(
                    .setTransientSettings(Settings.builder().put(SEARCH_MAX_QUERY_NESTING_DEPTH.getKey(), 30))
        }
    /**
package org.opensearch.search.query;
            ensureGreen("test");  
        try {
        ensureGreen("test_large");  
                client().admin()
 * compatible open source license.
public class QueryStringNestingDepthIT extends OpenSearchIntegTestCase {
            );  
                client().prepareSearch("test_lower").setQuery(queryStringQuery(query)).get();  
    public void testLargeNestingUnderLengthLimitIsRejected() throws Exception {
     * 3. Same query now succeeds
            assertNoFailures(response);
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            assertHitCount(response, 1L);  
            createIndex("test");
        }
import org.opensearch.action.search.SearchPhaseExecutionException;
            // Query exceeding default depth (200) should be rejected  
            assertHitCount(response, 1L);
        });
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;  
            );
 * SPDX-License-Identifier: Apache-2.0
        // 15000 nested parens = 30011 chars, under the 32000 max_query_string_length
    }
        SearchPhaseExecutionException e = expectThrows(SearchPhaseExecutionException.class, () -> {  
            assertThat(e.getDetailedMessage(), containsString("nesting depth exceeds max allowed depth 200"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
                    .cluster()
    }
            // Dynamically raise the limit to 300  
import org.opensearch.test.OpenSearchIntegTestCase;
        } finally {  
            // Depth 50 works with default limit (200)
/**
            SearchPhaseExecutionException e = expectThrows(SearchPhaseExecutionException.class, () -> {
     * 2. Dynamically raise the limit  
            });
                    .prepareUpdateSettings()
            SearchPhaseExecutionException e = expectThrows(SearchPhaseExecutionException.class, () -> {
        assertThat(e.getDetailedMessage(), containsString("nesting depth exceeds max allowed depth"));  
     * Tests the full lifecycle:
            assertAcked(
            // Lower the limit to 30
import org.opensearch.action.search.SearchResponse;
                client().prepareSearch("test").setQuery(queryStringQuery(deepQuery)).get();
            refresh();
        return sb.toString();  
                client().admin()
    /**
        try {
            String deepQuery = buildNestedQuery(250, "field:value");
 * this file be licensed under the Apache-2.0 license or a
        createIndex("test_large");
    public void testNestingDepthLimitWithDynamicUpdate() throws Exception {  
            client().prepareIndex("test_lower").setId("1").setSource("field", "value").get();
                client().admin()
            );  
        for (int i = 0; i < nestingDepth; i++) {
    /**  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 */  
import org.opensearch.common.settings.Settings;  
    }
    private String buildNestedQuery(int nestingDepth, String innerTerm) {  
        }
            client().prepareSearch("test_large").setQuery(queryStringQuery(query)).get();
     */
        StringBuilder sb = new StringBuilder(nestingDepth * 2 + innerTerm.length());
                    .setTransientSettings(Settings.builder().putNull(SEARCH_MAX_QUERY_NESTING_DEPTH.getKey()))
            createIndex("test_lower");  
    public void testLoweringNestingDepthRejectsQueries() throws Exception {
                client().admin()
            assertAcked(  
            sb.append('(');  

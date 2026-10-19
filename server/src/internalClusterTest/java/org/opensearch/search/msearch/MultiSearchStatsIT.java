                searchResponseStatusStats.getSearchResponseStatusCounter(),
package org.opensearch.search.msearch;
        expectedSearchResponseStatusStats.inc(r.status());
            }
            )
 * The OpenSearch Contributors require contributions made to  
    private void assertSearchResponseStatusStats() {  
        SearchResponseStatusStats searchResponseStatusStats = client().admin()
 * SPDX-License-Identifier: Apache-2.0
        MultiSearchResponse response = multiSearchRequestBuilder.get();  
        client().prepareIndex("test").setId("1").setSource("field", "xxx").get();
 * this file be licensed under the Apache-2.0 license or a
import java.util.Comparator;  
    }
        );  
        MultiSearchRequestBuilder multiSearchRequestBuilder = client().prepareMultiSearch();
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
import java.util.Arrays;
        int successCount = randomIntBetween(0, 50);  
import java.util.concurrent.atomic.LongAdder;
    private void updateExpectedDocStatusCounter(SearchResponseStatusStats expectedSearchResponseStatusStats, Exception e) {
 */  
        assertTrue(  
            if (item.isFailure()) {  
import org.opensearch.index.query.QueryBuilders;  
import org.opensearch.action.search.MultiSearchRequestBuilder;  
        createIndex("test");
    public void testNodeIndicesStatsSearchResponseStatusStatsMultiSearch() {
@ClusterScope(scope = Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        client().prepareIndex("test").setId("2").setSource("field", "yyy").get();
    private final SearchResponseStatusStats expectedSearchResponseStatusStats = new SearchResponseStatusStats();
        for (int i = 0; i < successCount; i++) {
            .cluster()
            .getIndices()
            .prepareNodesStats()  
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.action.admin.indices.stats.SearchResponseStatusStats;
        assertSearchResponseStatusStats();  
    private void updateExpectedDocStatusCounter(SearchResponseStatusStats expectedSearchResponseStatusStats, SearchResponse r) {  
        expectedSearchResponseStatusStats.inc(ExceptionsHelper.status(e));
        refresh();  
            .get(0)
        for (MultiSearchResponse.Item item : response) {
import org.opensearch.action.search.SearchResponse;
            multiSearchRequestBuilder.add(client().prepareSearch("noIndex").setQuery(QueryBuilders.termQuery("field", "yyy")));
            .getStatusCounterStats()  
 *
            multiSearchRequestBuilder.add(client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()));  
        }
            } else {
                updateExpectedDocStatusCounter(expectedSearchResponseStatusStats, item.getResponse());  
            .execute()
        for (int i = 0; i < failureCount; i++) {
public class MultiSearchStatsIT extends OpenSearchIntegTestCase {
import org.opensearch.ExceptionsHelper;
    }
            .getSearchResponseStatusStats();
            .getNodes()  
                Comparator.comparingLong(LongAdder::longValue)
        }
/*  
import org.opensearch.action.search.MultiSearchResponse;
 * compatible open source license.
    }
            .actionGet()
}
        }  
                updateExpectedDocStatusCounter(expectedSearchResponseStatusStats, item.getFailure());
            Arrays.equals(
        int failureCount = randomIntBetween(0, 50);
        ensureGreen();  
                expectedSearchResponseStatusStats.getSearchResponseStatusCounter(),  
    }  

            new Object[] {  
        indexRandomForConcurrentSearch("test");
 * compatible open source license.
import static org.opensearch.index.query.QueryBuilders.spanTermQuery;
                Settings.builder()
            .setQuery(spanNearQuery(spanTermQuery("field", "alpha"), 1).addClause(spanTermQuery("field", "beta")).inOrder(true))
    }
            new Object[] {
        int totalDocs = 2500;
        assertHitCount(response, 25L);  
public class SpanNearQueryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                    .build() }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        );
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)  
    public static Collection<Object[]> parameters() {  
        refresh();  
        SearchResponse response = client().prepareSearch("test")  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
        for (int i = 0; i < totalDocs; i++) {
        response = client().prepareSearch("test")
package org.opensearch.search.query;
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force")  
        forceMerge(1);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() },  
        assertHitCount(response, 50L);
        return Arrays.asList(
        createIndex("test", Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build());  
            .get();  
    public SpanNearQueryIT(Settings staticSettings) {
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment").build() },
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)
            String content = (i % 100 == 0) ? "alpha beta" : (i % 50 == 0) ? "alpha gamma beta" : "other words " + i;  
    }  
 * Integration tests for span_near queries with concurrent segment search and partition strategies.  
    public void testSpanNearQuery() throws Exception {
import org.opensearch.common.settings.Settings;
    }  
 */  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.index.query.QueryBuilders.spanNearQuery;
 */
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
import java.util.Arrays;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collection;
                Settings.builder()
}  
 * SPDX-License-Identifier: Apache-2.0
        super(staticSettings);
/**
        }
            .setQuery(spanNearQuery(spanTermQuery("field", "alpha"), 0).addClause(spanTermQuery("field", "beta")).inOrder(true))
    @ParametersFactory
            .get();
 *
/*  
import org.opensearch.action.search.SearchResponse;  
            client().prepareIndex("test").setId(String.valueOf(i)).setSource("field", content).get();
                    .build() },

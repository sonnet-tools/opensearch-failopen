    public MinIT(Settings staticSettings) {
        }  
        createIndex("test_min_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());  
    }
import org.opensearch.common.settings.Settings;
import java.util.List;
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment").build() },
import static org.hamcrest.Matchers.closeTo;  
            internalCluster().wipeIndices("test_min_agg");
    public void testMinAggregation() throws Exception {
            List<IndexRequestBuilder> builders = new ArrayList<>(5000);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
                Settings.builder()
            Min minAgg = response.getAggregations().get("min_agg");
/*  
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)  
 */
 * compatible open source license.
    }  
import org.opensearch.action.search.SearchResponse;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import java.util.Collection;
package org.opensearch.search.aggregations.metrics;
            assertThat(minAgg, notNullValue());
public class MinIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
/**  
            assertThat(minAgg.getValue(), closeTo(1.0, 0.1));  
        try {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            new Object[] {  
        );
        super(staticSettings);  
            assertSearchResponse(response);  
            indexRandomForConcurrentSearch("test_min_agg");
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.search.aggregations.AggregationBuilders.min;
 *
import static org.hamcrest.Matchers.notNullValue;
import java.util.ArrayList;
            for (int i = 0; i < 5000; i++) {  
}
            }
                    .build() }
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force").build() },
    @ParametersFactory  
    public static Collection<Object[]> parameters() {
 */  
 * SPDX-License-Identifier: Apache-2.0
 * Integration tests for min aggregation with concurrent segment search partition strategies.
        } finally {
import org.opensearch.action.index.IndexRequestBuilder;  
                builders.add(client().prepareIndex("test_min_agg").setSource("value", i + 1));
 * The OpenSearch Contributors require contributions made to  
    }
import java.util.Arrays;  
            indexBulkWithSegments(builders, 2);  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        return Arrays.asList(
            SearchResponse response = client().prepareSearch("test_min_agg").addAggregation(min("min_agg").field("value")).get();

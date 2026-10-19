    @ParametersFactory  
        createIndex("test_max_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());  
            List<IndexRequestBuilder> builders = new ArrayList<>(5000);
/*  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
public class MaxIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
import java.util.Arrays;  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
import java.util.ArrayList;
            }
                    .build() }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    }
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
            indexRandomForConcurrentSearch("test_max_agg");
import static org.hamcrest.Matchers.notNullValue;
            Max maxAgg = response.getAggregations().get("max_agg");
        try {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.index.IndexRequestBuilder;  
 */
                builders.add(client().prepareIndex("test_max_agg").setSource("value", i + 1));
 *
                Settings.builder()
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment").build() },
    public static Collection<Object[]> parameters() {
package org.opensearch.search.aggregations.metrics;
            SearchResponse response = client().prepareSearch("test_max_agg").addAggregation(max("max_agg").field("value")).get();
    }
            for (int i = 0; i < 5000; i++) {  
            assertThat(maxAgg.getValue(), closeTo(5000.0, 0.1));  
    public void testMaxAggregation() throws Exception {
            internalCluster().wipeIndices("test_max_agg");
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;  
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)  
import static org.hamcrest.Matchers.closeTo;  
            assertSearchResponse(response);  
import org.opensearch.action.search.SearchResponse;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
        } finally {
import java.util.List;
    }  
        }  
 * compatible open source license.
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        );
            assertThat(maxAgg, notNullValue());
/**  
        super(staticSettings);  
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force").build() },
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
 */  
import static org.opensearch.search.aggregations.AggregationBuilders.max;
    public MaxIT(Settings staticSettings) {
        return Arrays.asList(
            new Object[] {  
import java.util.Collection;
}
            indexBulkWithSegments(builders, 2);  
 * Integration tests for max aggregation with concurrent segment search partition strategies.

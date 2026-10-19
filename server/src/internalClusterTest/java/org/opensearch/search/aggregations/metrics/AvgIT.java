                    .build() }
            for (int i = 0; i < 5000; i++) {  
import org.opensearch.common.settings.Settings;
    }
            indexRandomForConcurrentSearch("test_avg_agg");
            }
 * compatible open source license.
import java.util.ArrayList;
    }  
 *
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)  
    public void testAvgAggregation() throws Exception {
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
            SearchResponse response = client().prepareSearch("test_avg_agg").addAggregation(avg("avg_agg").field("value")).get();
public class AvgIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force").build() },
import java.util.List;
        try {
import static org.hamcrest.Matchers.closeTo;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
 * The OpenSearch Contributors require contributions made to  
            assertThat(avgAgg.getValue(), closeTo(2500.5, 0.1));  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment").build() },
    public static Collection<Object[]> parameters() {
}
            assertThat(avgAgg, notNullValue());
 * this file be licensed under the Apache-2.0 license or a
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * Integration tests for avg aggregation with concurrent segment search partition strategies.
 * SPDX-License-Identifier: Apache-2.0
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
    public AvgIT(Settings staticSettings) {
        );
            assertSearchResponse(response);  
                Settings.builder()
        } finally {
        createIndex("test_avg_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());  
import org.opensearch.action.search.SearchResponse;
        super(staticSettings);  
 */
        }  
import java.util.Collection;
import static org.hamcrest.Matchers.notNullValue;
                builders.add(client().prepareIndex("test_avg_agg").setSource("value", i + 1));
            internalCluster().wipeIndices("test_avg_agg");
            Avg avgAgg = response.getAggregations().get("avg_agg");
            indexBulkWithSegments(builders, 2);  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;  
            new Object[] {  
/**  
import java.util.Arrays;  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
/*  
    @ParametersFactory  
            List<IndexRequestBuilder> builders = new ArrayList<>(5000);
    }
 */  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
package org.opensearch.search.aggregations.metrics;
import org.opensearch.action.index.IndexRequestBuilder;  
        return Arrays.asList(

            )  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertSearchResponse(rsp);  
 *
            true,
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
 * SPDX-License-Identifier: Apache-2.0
    public CompositeAggIT(Settings staticSettings) {  
            .get();
            client().prepareIndex("idx").setId("1").setSource("type", "type2", "num", "13", "score", "100")
import org.opensearch.test.OpenSearchIntegTestCase;
        refresh();
                "idx",
            prepareCreate(  
            .get();
}
import java.util.ArrayList;
        assertSearchResponse(rsp);
            client().prepareIndex("idx").setId("1").setSource("type", "type1", "num", "3", "score", "10"),
                )
                    new MaxAggregationBuilder("max").field("score")
            .addAggregation(
    @ParametersFactory
import org.opensearch.cluster.health.ClusterHealthStatus;
/*  
            .addAggregation(new CompositeAggregationBuilder("my_composite", getTestValueSources()))
package org.opensearch.search.aggregations.bucket;
    private List<CompositeValuesSourceBuilder<?>> getTestValueSources() {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
    public void testCompositeAggWithNoSubAgg() {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.IndexMetadata;
        SearchResponse rsp = client().prepareSearch("idx")
                new CompositeAggregationBuilder("my_composite", getTestValueSources()).subAggregation(  
    }
                    .put(INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), false)
 */  
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
    public void testCompositeAggWithSubAgg() {  
                Settings.builder()
        );
            client().prepareIndex("idx").setId("1").setSource("type", "type1", "num", "1", "score", "5"),  
        waitForRelocation(ClusterHealthStatus.GREEN);
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        indexRandom(
            client().prepareIndex("idx").setId("1").setSource("type", "type1", "num", "1", "score", "2"),
public class CompositeAggIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import org.opensearch.common.settings.Settings;  
    public static Collection<Object[]> parameters() {
        super(staticSettings);
        return Arrays.asList(  
import org.opensearch.action.search.SearchResponse;  
    public void setupSuiteScopeCluster() throws Exception {
    }
        sources.add(new TermsValuesSourceBuilder("num_vs").field("num"));
            client().prepareIndex("idx").setId("1").setSource("type", "type2", "num", "12", "score", "20"),  
        sources.add(new TermsValuesSourceBuilder("keyword_vs").field("type"));
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
    }  
import org.opensearch.search.aggregations.bucket.composite.TermsValuesSourceBuilder;  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import static org.opensearch.indices.IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING;
        );  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        );
        assertAcked(
    @Override  
 * compatible open source license.
        waitForRelocation(ClusterHealthStatus.GREEN);
            ).setMapping("type", "type=keyword", "num", "type=integer", "score", "type=integer")  
    }  
 * The OpenSearch Contributors require contributions made to  
        final List<CompositeValuesSourceBuilder<?>> sources = new ArrayList<>();  
    }
import java.util.Collection;
            client().prepareIndex("idx").setId("1").setSource("type", "type2", "num", "13", "score", "15"),
    }
@OpenSearchIntegTestCase.SuiteScopeTestCase  
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;
            client().prepareIndex("idx").setId("1").setSource("type", "type2", "num", "11", "score", "50"),
        SearchResponse rsp = client().prepareSearch("idx")  
            client().prepareIndex("idx").setId("1").setSource("type", "type1", "num", "3", "score", "1"),  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import java.util.List;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import java.util.Arrays;  
        return sources;  

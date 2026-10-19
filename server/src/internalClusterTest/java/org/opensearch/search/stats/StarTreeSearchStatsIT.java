                .endObject()  
            .get();  
                .startObject("properties")  
        assertThat(  
                .startObject("non_dimension_field")
        // It's an aggregation on a dimension with a metric sub-aggregation and size=0.
                .field("name", "size")  
            "Star-tree query time should be non-negative",
        // Fetch index statistics
import org.opensearch.search.aggregations.metrics.Sum;
                .endObject()  
                .endObject()
import org.opensearch.search.aggregations.AggregationBuilders;
                .endObject()  
                lessThanOrEqualTo(totalStats.getQueryTimeInMillis())
                .field("name", "product")  
                .field("type", "text")
        assertThat(totalStats.getQueryTimeInMillis(), greaterThanOrEqualTo(totalStats.getStarTreeQueryTimeInMillis()));
                .field("type", "star_tree")
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        );
        client().prepareSearch(REGULAR_INDEX_NAME).setQuery(matchAllQuery()).get();  
            Settings.builder()
        // Assertions for the total stats across both indices  
    public void testStarTreeQueryStats() throws Exception {
            .get();  
            greaterThanOrEqualTo(0L)
import org.opensearch.search.aggregations.bucket.terms.Terms;  
 * SPDX-License-Identifier: Apache-2.0
        assertThat("Total star-tree query count should be 1", totalStats.getStarTreeQueryCount(), equalTo(1L));  
package org.opensearch.search.stats;
                .startObject("sales")
import org.opensearch.cluster.metadata.IndexMetadata;
    /**
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        );
        // Create an index without a star-tree  
        assertThat("Star-tree index should have 1 star-tree query", starTreeIndexStats.getStarTreeQueryCount(), equalTo(1L));  
                .put("index.composite_index", true)
        );
        assertThat(
                .endObject()
            starTreeIndexStats.getStarTreeQueryCurrent(),
            starTreeIndexStats.getStarTreeQueryTimeInMillis(),  
        assertThat("Star-tree index should have 2 total queries", starTreeIndexStats.getQueryCount(), equalTo(2L));
                .toString()  
        assertThat("Regular index should have 0 star-tree query time", regularIndexStats.getStarTreeQueryTimeInMillis(), equalTo(0L));
                .field("type", "keyword")
        // Assertions for the star-tree index
            .addAggregation(
        assertNotNull(sum);  
        Sum sum = terms.getBuckets().get(0).getAggregations().get("total_sales");
                .endArray()
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertThat("Regular index should have 0 star-tree queries", regularIndexStats.getStarTreeQueryCount(), equalTo(0L));  
        Terms terms = starTreeResponse.getAggregations().get("products");  
                .endObject()
 * Integration tests for search statistics related to star-tree.
        // Assertions for the regular index  
                .field("name", "sales")
                .build(),  
            .execute()  
 * this file be licensed under the Apache-2.0 license or a
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
                .endObject()
/**
        SearchResponse starTreeResponse = client().prepareSearch(STARTREE_INDEX_NAME)  
 */  
            .setQuery(matchAllQuery())
 * The OpenSearch Contributors require contributions made to  
        assertEquals(2, terms.getBuckets().size());
            .setSource("product", "keyboard", "sales", 150.0, "non_dimension_field", "more text", "size", "12")
import org.opensearch.index.search.stats.SearchStats;
            STARTREE_INDEX_NAME,
            greaterThanOrEqualTo(0L)  
                .endObject()
        // Query 1: This query should be answered by the star-tree.
            )
            XContentFactory.jsonBuilder()
        createIndex(  
     */  
                "Star-tree query time should be less than total query time",  
                .startArray("metrics")  
     * It then runs queries that should and should not be offloaded to the star-tree
        assertThat("Regular index should have 1 total query", regularIndexStats.getQueryCount(), equalTo(1L));
            "Star-tree query current should be non-negative",
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
        client().prepareIndex(REGULAR_INDEX_NAME).setSource("product", "monitor", "sales", 400.0).get();
     * and verifies the star-tree related stats.
    }
                AggregationBuilders.terms("products").field("product").subAggregation(AggregationBuilders.sum("total_sales").field("sales"))  
                .endArray()
                .startObject()
        IndicesStatsResponse stats = client().admin().indices().prepareStats(STARTREE_INDEX_NAME, REGULAR_INDEX_NAME).setSearch(true).get();  
                .startObject()
        assertEquals(2, starTreeResponse.getHits().getTotalHits().value());
        // Query 2: This query should NOT be answered by the star-tree as it queries a non-dimension field.
import static org.opensearch.index.query.QueryBuilders.termQuery;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
import org.opensearch.common.xcontent.XContentFactory;  
                .field("type", "keyword")
        );
    private static final String STARTREE_INDEX_NAME = "test_startree";
                .put("index.codec", "default")
     * It creates two indices: one with a star-tree field and one without.  
                .startObject()
        client().prepareSearch(STARTREE_INDEX_NAME).setQuery(termQuery("non_dimension_field", "text")).execute().actionGet();  
        client().prepareIndex(STARTREE_INDEX_NAME)
        client().prepareIndex(STARTREE_INDEX_NAME)
public class StarTreeSearchStatsIT extends OpenSearchIntegTestCase {
 *
        SearchStats.Stats regularIndexStats = stats.getIndex(REGULAR_INDEX_NAME).getTotal().getSearch().getTotal();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)
        createIndex(
                .startArray("ordered_dimensions")
        // While not guaranteed, the time spent on the single star-tree query should be less than the total query time.  
                .put("index.search.star_tree_index.enabled", true)
        // Query 3: A standard query on the regular index.
        refresh();
                .startObject("my_star_tree")
    private static final String REGULAR_INDEX_NAME = "test_regular";
                .endObject()  
        // Force merge the star-tree index to ensure star-tree segments are created  
        SearchStats.Stats totalStats = stats.getTotal().getSearch().getTotal();
import org.opensearch.action.search.SearchResponse;  
 * compatible open source license.
                totalStats.getStarTreeQueryTimeInMillis(),
                .startObject("size")
                .field("stats", new String[] { "sum" })  
            .setSource("product", "laptop", "sales", 1200.0, "non_dimension_field", "some text", "size", "18")
                .endObject()
                .field("type", "double")
        SearchStats.Stats starTreeIndexStats = stats.getIndex(STARTREE_INDEX_NAME).getTotal().getSearch().getTotal();  
                .endObject()
        assertThat("Total query count should be 3", totalStats.getQueryCount(), equalTo(3L));
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()  
            );  
                .endObject()  
            .actionGet();
}  
                .startObject("product")
        if (totalStats.getStarTreeQueryCount() > 0 && totalStats.getQueryCount() > totalStats.getStarTreeQueryCount()) {
            REGULAR_INDEX_NAME,
 */  
                .startObject("config")  
/*  
            .setSize(0)
        // Create an index with a star-tree field mapping using the composite structure
                .startObject("composite")  
                .put("index.append_only.enabled", true)  
     * This test validates that star-tree specific search stats are correctly reported.
        ensureGreen(STARTREE_INDEX_NAME, REGULAR_INDEX_NAME);
                .startObject()
import org.opensearch.common.settings.Settings;
        client().admin().indices().forceMerge(new ForceMergeRequest(STARTREE_INDEX_NAME).maxNumSegments(1)).get();
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            assertThat(
import static org.hamcrest.Matchers.equalTo;  

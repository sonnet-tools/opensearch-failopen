            .get();
        assertThat(
        SearchResponse starTreeResponse = client().prepareSearch(STARTREE_INDEX_NAME)
                .startObject("properties")
                .toString()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)
        IndicesStatsResponse stats = client().admin().indices().prepareStats(STARTREE_INDEX_NAME, REGULAR_INDEX_NAME).setSearch(true).get();
     * It creates two indices: one with a star-tree field and one without.
 * this file be licensed under the Apache-2.0 license or a
                lessThanOrEqualTo(totalStats.getQueryTimeInMillis())
                .endObject()
        // Query 2: This query should NOT be answered by the star-tree as it queries a non-dimension field.
            .actionGet();
        client().prepareIndex(REGULAR_INDEX_NAME).setSource("product", "monitor", "sales", 400.0).get();
    public void testStarTreeQueryStats() throws Exception {
                .endObject()
                .startObject("product")
        // Assertions for the total stats across both indices
        createIndex(
        assertThat("Star-tree index should have 2 total queries", starTreeIndexStats.getQueryCount(), equalTo(2L));
            .get();
            XContentFactory.jsonBuilder()
                .startObject("config")
        assertThat("Star-tree index should have 1 star-tree query", starTreeIndexStats.getStarTreeQueryCount(), equalTo(1L));
        assertThat("Total star-tree query count should be 1", totalStats.getStarTreeQueryCount(), equalTo(1L));
     */
                .endObject()
                .endObject()
                "Star-tree query time should be less than total query time",
            .setSource("product", "laptop", "sales", 1200.0, "non_dimension_field", "some text", "size", "18")
        // Query 3: A standard query on the regular index.
                totalStats.getStarTreeQueryTimeInMillis(),
                .field("type", "keyword")
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // While not guaranteed, the time spent on the single star-tree query should be less than the total query time.
            .setSource("product", "keyboard", "sales", 150.0, "non_dimension_field", "more text", "size", "12")
        // Create an index with a star-tree field mapping using the composite structure
                .endArray()
                .startObject()
        }
     * and verifies the star-tree related stats.
                .field("stats", new String[] { "sum" })
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        SearchStats.Stats starTreeIndexStats = stats.getIndex(STARTREE_INDEX_NAME).getTotal().getSearch().getTotal();
            .execute()
                .startObject("my_star_tree")
                .startObject("composite")
        Sum sum = terms.getBuckets().get(0).getAggregations().get("total_sales");
            greaterThanOrEqualTo(0L)
                .field("type", "text")
import org.opensearch.search.aggregations.metrics.Sum;
                .field("type", "keyword")
        client().admin().indices().forceMerge(new ForceMergeRequest(STARTREE_INDEX_NAME).maxNumSegments(1)).get();
        assertThat("Total query count should be 3", totalStats.getQueryCount(), equalTo(3L));
                .field("name", "sales")
        );
                .put("index.codec", "default")
            .setSize(0)
                .startArray("ordered_dimensions")
            )
        // Create an index without a star-tree
import org.opensearch.search.aggregations.bucket.terms.Terms;
 *
 * The OpenSearch Contributors require contributions made to
        ensureGreen(STARTREE_INDEX_NAME, REGULAR_INDEX_NAME);
        // Assertions for the regular index
                .endArray()
        SearchStats.Stats totalStats = stats.getTotal().getSearch().getTotal();
     * It then runs queries that should and should not be offloaded to the star-tree
}
                .startObject("sales")
                .put("index.search.star_tree_index.enabled", true)
import org.opensearch.action.search.SearchResponse;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
 * Integration tests for search statistics related to star-tree.
/**
            STARTREE_INDEX_NAME,
        client().prepareIndex(STARTREE_INDEX_NAME)
        SearchStats.Stats regularIndexStats = stats.getIndex(REGULAR_INDEX_NAME).getTotal().getSearch().getTotal();
                .endObject()
                .startObject("size")
                .endObject()
            .setQuery(matchAllQuery())
                .startObject()
        // Query 1: This query should be answered by the star-tree.
                .endObject()
        client().prepareSearch(REGULAR_INDEX_NAME).setQuery(matchAllQuery()).get();
import static org.opensearch.index.query.QueryBuilders.termQuery;
            REGULAR_INDEX_NAME,
                .endObject()
                .build(),
 * compatible open source license.
    /**
            starTreeIndexStats.getStarTreeQueryCurrent(),
 */
/*
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            "Star-tree query current should be non-negative",
            starTreeIndexStats.getStarTreeQueryTimeInMillis(),
public class StarTreeSearchStatsIT extends OpenSearchIntegTestCase {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    private static final String STARTREE_INDEX_NAME = "test_startree";
        // Force merge the star-tree index to ensure star-tree segments are created
        client().prepareIndex(STARTREE_INDEX_NAME)
    private static final String REGULAR_INDEX_NAME = "test_regular";
 */
                .startArray("metrics")
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        );
package org.opensearch.search.stats;
import org.opensearch.common.xcontent.XContentFactory;
                .field("type", "star_tree")
        client().prepareSearch(STARTREE_INDEX_NAME).setQuery(termQuery("non_dimension_field", "text")).execute().actionGet();
        // Fetch index statistics
                .put("index.append_only.enabled", true)
        assertThat(totalStats.getQueryTimeInMillis(), greaterThanOrEqualTo(totalStats.getStarTreeQueryTimeInMillis()));
                .endObject()
        assertEquals(2, starTreeResponse.getHits().getTotalHits().value());
                .startObject()
        assertThat("Regular index should have 0 star-tree query time", regularIndexStats.getStarTreeQueryTimeInMillis(), equalTo(0L));
        // Assertions for the star-tree index
                .put("index.composite_index", true)
            Settings.builder()
        assertThat("Regular index should have 0 star-tree queries", regularIndexStats.getStarTreeQueryCount(), equalTo(0L));
                .startObject()
            greaterThanOrEqualTo(0L)
                .endObject()
            assertThat(
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                .startObject("non_dimension_field")
import org.opensearch.index.search.stats.SearchStats;
        refresh();
    }
        assertNotNull(sum);
        assertThat("Regular index should have 1 total query", regularIndexStats.getQueryCount(), equalTo(1L));
import org.opensearch.cluster.metadata.IndexMetadata;
        // It's an aggregation on a dimension with a metric sub-aggregation and size=0.
            .addAggregation(
        if (totalStats.getStarTreeQueryCount() > 0 && totalStats.getQueryCount() > totalStats.getStarTreeQueryCount()) {
                .field("name", "size")
            "Star-tree query time should be non-negative",
import org.opensearch.common.settings.Settings;
        Terms terms = starTreeResponse.getAggregations().get("products");
                .field("type", "double")
                .endObject()
        );
                AggregationBuilders.terms("products").field("product").subAggregation(AggregationBuilders.sum("total_sales").field("sales"))
                .endObject()
import static org.hamcrest.Matchers.equalTo;
                .field("name", "product")
import org.opensearch.test.OpenSearchIntegTestCase;
            );
 * SPDX-License-Identifier: Apache-2.0
        assertThat(
        assertEquals(2, terms.getBuckets().size());
        );
     * This test validates that star-tree specific search stats are correctly reported.
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
import org.opensearch.search.aggregations.AggregationBuilders;
        createIndex(

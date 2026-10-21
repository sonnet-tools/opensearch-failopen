        assertEquals("A", bucket.getKey().toString());
        assertEquals("B", bucket.getKey().toString());
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        refresh("idx_slice_error");
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertAcked(
import static org.opensearch.test.OpenSearchIntegTestCase.Scope.TEST;
        assertEquals(2, segmentResponse.getIndices().get("idx_mshard_1").getShards().get(0).getShards()[0].getSegments().size());
        assertEquals(1, terms.getBuckets().size());
        // 2. [A, B, B, B, C, C]
                .setSettings(
        refresh("idx_mshard_1");
        Terms terms = response.getAggregations().get("terms");
        assertEquals(0, bucket.getDocCountError());
            prepareCreate("idx_shard_error").setMapping(STRING_FIELD_NAME, "type=keyword")
                )
            .setSize(0)
        );
        SearchResponse response = client().prepareSearch("idx_slice_error")
        assertEquals(4, bucket.getDocCount());
        // Shard_2 [B, C, D]
        Terms terms = response.getAggregations().get("terms");
        // Bucket "A" error is 2, from (shard_size)th bucket on shard_2
 * The OpenSearch Contributors require contributions made to
                        .put("index.refresh_interval", MINIMUM_REFRESH_INTERVAL)
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(2).shardSize(2))
 * compatible open source license.
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Shard_2 [A, A, B, B, B, C, C, C]
        refresh("idx_shard_error");
                    Settings.builder()
@OpenSearchIntegTestCase.ClusterScope(scope = TEST, numClientNodes = 0, maxNumDataNodes = 1, supportsDedicatedMasters = false)
            "Slice level error is not relevant to non-concurrent search cases",
                        .put("index.refresh_interval", MINIMUM_REFRESH_INTERVAL)
        // size = 1, shard_size = 2
        assertEquals(5, bucket.getDocCount());
        assertEquals("A", bucket.getKey().toString());
        Terms.Bucket bucket = terms.getBuckets().get(0);
        // Bucket "B" error is 0, it's present on both shards
        // Creates 2 segments (and therefore 2 slices since slice_count = 2) as follows:
            .setSize(0)
            .get();
                )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(2).shardSize(2))
        // cs
    }
        segmentResponse = client().admin().indices().prepareSegments("idx_mshard_2").get();
        assertEquals(2, terms.getBuckets().size());
        // Thus we expect the doc count error for A to be 2 as the nth largest bucket on slice 2 has size 2
        assertEquals(1, terms.getBuckets().size());
        assertEquals(6, bucket.getDocCount());
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
        assertEquals(2, terms.getBuckets().size());
        refresh("idx_mshard_2");
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(2).shardSize(2))
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertEquals("A", bucket.getKey().toString());
        assertEquals("B", bucket.getKey().toString());
        assertEquals(4, bucket.getDocCount());
        terms = response.getAggregations().get("terms");
        response = client().prepareSearch("idx_mshard_2", "idx_mshard_1")
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
                .setSettings(
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(4, bucket.getDocCount());
        super(staticSettings);
        bucket = terms.getBuckets().get(1);
            .setSize(0)
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
        assertEquals(3, bucket.getDocCount());
import java.util.Arrays;
 */
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
                )
        response = client().prepareSearch("idx_slice_error")
        // Agg error is 4, from (shard_size)th bucket on each shard
                    Settings.builder()
/*
        );
            .get();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() },
        SearchResponse response = client().prepareSearch("idx_mshard_2", "idx_mshard_1")
    public void testSimpleAggErrorMultiShard() throws Exception {
        bucket = terms.getBuckets().get(0);
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
import org.opensearch.test.OpenSearchIntegTestCase;
        assertEquals(3, bucket.getDocCount());
        assertEquals(1, bucket.getDocCountError());
        // slice_1 [A, A, A, B, B, C] {"A" : 3, "B" : 2}
        assertEquals("B", bucket.getKey().toString());
        refresh("idx_mshard_1");
        assertEquals(5, bucket.getDocCount());
        );
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        refresh("idx_mshard_2");
        assertEquals(1, segmentResponse.getIndices().get("idx_mshard_1").getShards().get(0).getShards()[0].getSegments().size());
        );
        assumeTrue(
    public static Collection<Object[]> parameters() {
                )
        Terms terms = response.getAggregations().get("terms");
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        SearchResponse response = client().prepareSearch("idx_mshard_1")
        // Confirm that there is no error when shard_size == slice_size > cardinality
        // coordinator -> Buckets {"B" : 5, "A" : 4}
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        return Arrays.asList(
        // Shard_1 [A, A, A, A, B, B, C, C]
            internalCluster().clusterService().getClusterSettings().get(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING)
        refresh("idx_mshard_1");
public class TermsFixedDocCountErrorIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                    Settings.builder()
                    Settings.builder()
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        terms = response.getAggregations().get("terms");
                    Settings.builder()
}
        assertEquals("B", bucket.getKey().toString());
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        assertEquals(3, bucket.getDocCountError());
        );
        bucket = terms.getBuckets().get(0); // Bucket "B"
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        refresh("idx_slice_error");
        // Shard_1 [A, B, C]
        Terms.Bucket bucket = terms.getBuckets().get(0);
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        // Size = 2, shard_size = 2
        // slice_1 [A, B, B, B, C, C] {"B" : 3, "C" : 2}
            "Slice level error is not relevant to non-concurrent search cases",
        assertEquals(2, bucket.getDocCountError());
                .setSettings(
    private static final String STRING_FIELD_NAME = "s_value";
        bucket = terms.getBuckets().get(1);
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
            .setSize(0)
        SearchResponse response = client().prepareSearch("idx_shard_error")
        assertAcked(
        response = client().prepareSearch("idx_mshard_2")
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
        assertEquals(3, terms.getDocCountError());
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        assertEquals(2, bucket.getDocCountError());
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        // size = 1 shard_size = 1 slice_size = 1
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(2).shardSize(2))
        // 1. [A, A, A, B, B, C]
        // Shard_1 slice_1 [A, B, C] -> {a : 1} -> {a : 1 -- error: 1}
        assertEquals("A", bucket.getKey().toString());
                )
            prepareCreate("idx_slice_error").setMapping(STRING_FIELD_NAME, "type=keyword")
        IndicesSegmentResponse segmentResponse = client().admin().indices().prepareSegments("idx_slice_error").get();
import org.opensearch.cluster.metadata.IndexMetadata;
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        // slice_2 [A, C] {"A" : 1, "C" : 1}
    public void testSliceLevelDocCountErrorSingleShard() throws Exception {
            prepareCreate("idx_mshard_1").setMapping(STRING_FIELD_NAME, "type=keyword")
            .setSize(0)
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        Terms.Bucket bucket = terms.getBuckets().get(0); // Bucket "B"
        // Slices are created by sorting segments by doc count in descending order then distributing in round robin fashion.
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .get();
        // slice_2 [B, C, D] -> {b : 1}
            .get();
        assertEquals(0, bucket.getDocCountError());
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    }
        // Overall
        bucket = terms.getBuckets().get(0);
        // Shard_2 buckets: {"B" : 3 - error: 1, "C" : 3 - error: 0}
        Terms.Bucket bucket = terms.getBuckets().get(0); // Bucket "B"
        assertEquals("C", bucket.getKey().toString());
            .setSize(0)
    }
import org.opensearch.action.search.SearchResponse;
        assertEquals(6, terms.getDocCountError());
        assertAcked(
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        assertEquals(2, terms.getBuckets().size());
                        .put("index.refresh_interval", MINIMUM_REFRESH_INTERVAL)
                .setSettings(
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
import java.util.Collection;
 * this file be licensed under the Apache-2.0 license or a
        terms = response.getAggregations().get("terms");
        );
        IndicesSegmentResponse segmentResponse = client().admin().indices().prepareSegments("idx_mshard_1").get();
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(2).shardSize(2))
        assertEquals(0, bucket.getDocCountError());
        segmentResponse = client().admin().indices().prepareSegments("idx_mshard_2").get();
        assertEquals(0, bucket.getDocCountError());
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(0, bucket.getDocCountError());
        assertEquals(4, terms.getDocCountError());
        // Shard_1 [A, A, A, A, B, B, C, C, D, D] -> Buckets {"A" : 4, "B" : 2}
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        assertEquals("B", bucket.getKey().toString());
        assertAcked(
        refresh("idx_mshard_2");
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        );
        assertEquals(0, bucket.getDocCountError());
            .get();
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
            internalCluster().clusterService().getClusterSettings().get(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING)
        // Shard_2 [A, B, B, B, C, C, C, D, D, D] -> Buckets {"B" : 3, "C" : 3}
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        assertEquals(2, terms.getBuckets().size());
                .setSettings(
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        assertEquals(5, bucket.getDocCount());
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() }
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(1).shardSize(4))
        assertEquals(0, terms.getDocCountError());
                        .put("index.refresh_interval", MINIMUM_REFRESH_INTERVAL)
        assertEquals(2, terms.getBuckets().size());
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
                        .put("index.refresh_interval", MINIMUM_REFRESH_INTERVAL)
        bucket = terms.getBuckets().get(1); // Bucket "A"
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        assertAcked(
        assertEquals(0, terms.getDocCountError());
        assertEquals(5, bucket.getDocCount());
        assertEquals(2, segmentResponse.getIndices().get("idx_mshard_2").getShards().get(0).getShards()[0].getSegments().size());
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
 *
        // slice_2 [A, C] {"A" : 1, "C" : 1}
    public TermsFixedDocCountErrorIT(Settings staticSettings) {
        );
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
    public void testSliceLevelDocCountErrorMultiShard() throws Exception {
            prepareCreate("idx_mshard_2").setMapping(STRING_FIELD_NAME, "type=keyword")
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
        // Coordinator should return the same doc count error in both cases
            .get();
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(1).shardSize(2))
import static org.opensearch.index.IndexSettings.MINIMUM_REFRESH_INTERVAL;
        assumeTrue(
                    Settings.builder()
            prepareCreate("idx_mshard_2").setMapping(STRING_FIELD_NAME, "type=keyword")
        // Shard_1 buckets: {"A" : 4 - error: 0, "B" : 2 - error: 1}
        // {"B" : 5 - error: 2, "A" : 4 - error: 3} Agg error: 6
    }
                )
        assertEquals(3, terms.getDocCountError());
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        Terms terms = response.getAggregations().get("terms");
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .setSettings(
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        IndicesSegmentResponse segmentResponse = client().admin().indices().prepareSegments("idx_mshard_1").get();
    }
            prepareCreate("idx_mshard_1").setMapping(STRING_FIELD_NAME, "type=keyword")
        assertEquals(4, terms.getDocCountError());
        assertEquals(2, bucket.getDocCount());
        assertEquals(3, bucket.getDocCount());
            .get();
    }
package org.opensearch.search.aggregations.bucket;
        // non-cs / cs
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        assertEquals(1, segmentResponse.getIndices().get("idx_mshard_2").getShards().get(0).getShards()[0].getSegments().size());
        assertEquals(1, bucket.getDocCountError());
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(2, segmentResponse.getIndices().get("idx_slice_error").getShards().get(0).getShards()[0].getSegments().size());
        assertEquals("A", bucket.getKey().toString());
        );
import org.opensearch.search.aggregations.bucket.terms.Terms;
                        .put("index.refresh_interval", MINIMUM_REFRESH_INTERVAL)
        bucket = terms.getBuckets().get(1);
        assertEquals(2, bucket.getDocCountError());
        assertEquals("B", bucket.getKey().toString());
        bucket = terms.getBuckets().get(1); // Bucket "A"
    @ParametersFactory
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
            .setSize(0)
    public void testSimpleAggErrorSingleShard() throws Exception {
        assertAcked(
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;

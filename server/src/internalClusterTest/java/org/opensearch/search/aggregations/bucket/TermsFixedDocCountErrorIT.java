    public void testSimpleAggErrorSingleShard() throws Exception {  
        assertEquals(2, terms.getBuckets().size());
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() },  
        bucket = terms.getBuckets().get(1);  
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        assertEquals(2, segmentResponse.getIndices().get("idx_mshard_2").getShards().get(0).getShards()[0].getSegments().size());
            .get();  
                        .put("index.refresh_interval", MINIMUM_REFRESH_INTERVAL)
        refresh("idx_slice_error");
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        assertEquals(6, terms.getDocCountError());
            .setSize(0)
        // Creates 2 segments (and therefore 2 slices since slice_count = 2) as follows:  
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();  
            prepareCreate("idx_mshard_2").setMapping(STRING_FIELD_NAME, "type=keyword")
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
                .setSettings(
        // Coordinator should return the same doc count error in both cases  
        );  
        assertEquals("A", bucket.getKey().toString());  
        assertEquals(0, bucket.getDocCountError());  
                )  
                )  
        bucket = terms.getBuckets().get(1); // Bucket "A"  
        );
        Terms.Bucket bucket = terms.getBuckets().get(0);
            .get();  
        Terms terms = response.getAggregations().get("terms");  
        assertEquals(2, terms.getBuckets().size());
        assertEquals(0, terms.getDocCountError());  
        assertEquals(3, bucket.getDocCount());
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();  
        assertEquals("A", bucket.getKey().toString());
        assertEquals(1, bucket.getDocCountError());
                    Settings.builder()  
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        assertEquals(2, bucket.getDocCountError());
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        response = client().prepareSearch("idx_mshard_2")  
        assertEquals(0, bucket.getDocCountError());
            prepareCreate("idx_mshard_1").setMapping(STRING_FIELD_NAME, "type=keyword")  
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(2).shardSize(2))
        );
        // cs  
        Terms.Bucket bucket = terms.getBuckets().get(0); // Bucket "B"
        // Overall
        refresh("idx_mshard_1");  
    }  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
            prepareCreate("idx_mshard_2").setMapping(STRING_FIELD_NAME, "type=keyword")  
        // Shard_1 [A, B, C]
@OpenSearchIntegTestCase.ClusterScope(scope = TEST, numClientNodes = 0, maxNumDataNodes = 1, supportsDedicatedMasters = false)  
        // Slices are created by sorting segments by doc count in descending order then distributing in round robin fashion.
 *
        IndicesSegmentResponse segmentResponse = client().admin().indices().prepareSegments("idx_mshard_1").get();
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        refresh("idx_shard_error");  
import org.opensearch.search.aggregations.bucket.terms.Terms;
                        .put("index.refresh_interval", MINIMUM_REFRESH_INTERVAL)
        // slice_1 [A, B, B, B, C, C] {"B" : 3, "C" : 2}
        );
            .setSize(0)  
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
import org.opensearch.test.OpenSearchIntegTestCase;
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        SearchResponse response = client().prepareSearch("idx_shard_error")
        // Shard_1 [A, A, A, A, B, B, C, C]  
        // non-cs / cs  
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(2).shardSize(2))
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(1).shardSize(4))  
        );
        assertEquals(4, terms.getDocCountError());
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();  
        // Shard_2 [A, A, B, B, B, C, C, C]
        // {"B" : 5 - error: 2, "A" : 4 - error: 3} Agg error: 6  
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(1).shardSize(2))
            .get();
        // Bucket "A" error is 2, from (shard_size)th bucket on shard_2
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();  
        assertEquals("B", bucket.getKey().toString());
        assertEquals("A", bucket.getKey().toString());
package org.opensearch.search.aggregations.bucket;
    }
        // slice_2 [A, C] {"A" : 1, "C" : 1}  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 */  
        );
        assertEquals(1, segmentResponse.getIndices().get("idx_mshard_2").getShards().get(0).getShards()[0].getSegments().size());
        assertEquals(0, bucket.getDocCountError());
        segmentResponse = client().admin().indices().prepareSegments("idx_mshard_2").get();  
                    Settings.builder()
        // 2. [A, B, B, B, C, C]
        // Bucket "B" error is 0, it's present on both shards  
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
            .get();
        Terms.Bucket bucket = terms.getBuckets().get(0);
        assertEquals("A", bucket.getKey().toString());  
        Terms terms = response.getAggregations().get("terms");
            .get();
        // Shard_2 buckets: {"B" : 3 - error: 1, "C" : 3 - error: 0}
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
        assumeTrue(  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;  
        // Shard_2 [A, B, B, B, C, C, C, D, D, D] -> Buckets {"B" : 3, "C" : 3}
}
        assertAcked(
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(2).shardSize(2))
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        assertEquals(0, bucket.getDocCountError());
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        refresh("idx_slice_error");
            internalCluster().clusterService().getClusterSettings().get(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING)
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
    public TermsFixedDocCountErrorIT(Settings staticSettings) {
import java.util.Arrays;
                        .put("index.refresh_interval", MINIMUM_REFRESH_INTERVAL)  
        assertEquals("B", bucket.getKey().toString());
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                    Settings.builder()
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();  
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
import org.opensearch.cluster.metadata.IndexMetadata;
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        SearchResponse response = client().prepareSearch("idx_slice_error")
                .setSettings(
                .setSettings(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        // size = 1 shard_size = 1 slice_size = 1
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        assertAcked(  
        // slice_1 [A, A, A, B, B, C] {"A" : 3, "B" : 2}
        bucket = terms.getBuckets().get(1);
                )  
        // Size = 2, shard_size = 2
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
 * The OpenSearch Contributors require contributions made to  
        response = client().prepareSearch("idx_mshard_2", "idx_mshard_1")
        assertEquals(1, terms.getBuckets().size());
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() }
import org.opensearch.action.search.SearchResponse;
                    Settings.builder()
        Terms terms = response.getAggregations().get("terms");  
        // 1. [A, A, A, B, B, C]
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();  
import static org.opensearch.index.IndexSettings.MINIMUM_REFRESH_INTERVAL;  
        response = client().prepareSearch("idx_slice_error")  
        // Thus we expect the doc count error for A to be 2 as the nth largest bucket on slice 2 has size 2  
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();  
        refresh("idx_mshard_1");  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        bucket = terms.getBuckets().get(0);  
        );  
                )
                )
                )  
        assertEquals(2, bucket.getDocCount());  
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();  
        Terms terms = response.getAggregations().get("terms");
        assertEquals(0, terms.getDocCountError());
        assertEquals(2, bucket.getDocCountError());  
        assertAcked(
    }
        IndicesSegmentResponse segmentResponse = client().admin().indices().prepareSegments("idx_slice_error").get();  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        segmentResponse = client().admin().indices().prepareSegments("idx_mshard_2").get();
    public static Collection<Object[]> parameters() {
public class TermsFixedDocCountErrorIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertEquals(0, bucket.getDocCountError());
        assertEquals(4, bucket.getDocCount());
        assertEquals(2, terms.getBuckets().size());
        SearchResponse response = client().prepareSearch("idx_mshard_1")
 * this file be licensed under the Apache-2.0 license or a
    @ParametersFactory  
    public void testSliceLevelDocCountErrorMultiShard() throws Exception {
        // coordinator -> Buckets {"B" : 5, "A" : 4}  
            .setSize(0)
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(2).shardSize(2))  
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
    }  
        super(staticSettings);  
            prepareCreate("idx_slice_error").setMapping(STRING_FIELD_NAME, "type=keyword")  
        // Shard_1 slice_1 [A, B, C] -> {a : 1} -> {a : 1 -- error: 1}
    }  
        assertEquals(1, terms.getBuckets().size());
        assertEquals(4, bucket.getDocCount());
        assertEquals(2, segmentResponse.getIndices().get("idx_slice_error").getShards().get(0).getShards()[0].getSegments().size());
import static org.opensearch.test.OpenSearchIntegTestCase.Scope.TEST;  
                    Settings.builder()
        bucket = terms.getBuckets().get(1); // Bucket "A"
            .get();
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(1, segmentResponse.getIndices().get("idx_mshard_1").getShards().get(0).getShards()[0].getSegments().size());  
            .setSize(0)
        terms = response.getAggregations().get("terms");  
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        assertEquals(5, bucket.getDocCount());  
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
            .setSize(0)
        assertEquals(2, terms.getBuckets().size());  
        assertEquals(2, bucket.getDocCountError());
import java.util.Collection;  
                    Settings.builder()
            .addAggregation(terms("terms").field(STRING_FIELD_NAME).showTermDocCountError(true).size(2).shardSize(2))  
            internalCluster().clusterService().getClusterSettings().get(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING)
    public void testSliceLevelDocCountErrorSingleShard() throws Exception {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
            .get();
        refresh("idx_mshard_1");
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
        bucket = terms.getBuckets().get(0); // Bucket "B"  
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        // slice_2 [B, C, D] -> {b : 1}
        assertEquals(6, bucket.getDocCount());
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();  
            "Slice level error is not relevant to non-concurrent search cases",
        assumeTrue(  
        assertEquals(3, bucket.getDocCountError());  
        assertEquals(3, terms.getDocCountError());
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
            prepareCreate("idx_mshard_1").setMapping(STRING_FIELD_NAME, "type=keyword")  
        // Shard_1 buckets: {"A" : 4 - error: 0, "B" : 2 - error: 1}  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        bucket = terms.getBuckets().get(1);
        // Agg error is 4, from (shard_size)th bucket on each shard
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();  
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
import org.opensearch.common.settings.Settings;  
        refresh("idx_mshard_2");
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
    public void testSimpleAggErrorMultiShard() throws Exception {
        // Shard_2 [B, C, D]
        IndicesSegmentResponse segmentResponse = client().admin().indices().prepareSegments("idx_mshard_1").get();
        assertEquals(3, terms.getDocCountError());  
            "Slice level error is not relevant to non-concurrent search cases",
        assertEquals("B", bucket.getKey().toString());
                        .put("index.refresh_interval", MINIMUM_REFRESH_INTERVAL)
        return Arrays.asList(
        assertAcked(
        refresh("idx_mshard_2");  
        // Confirm that there is no error when shard_size == slice_size > cardinality  
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();  
        assertEquals(5, bucket.getDocCount());
 * compatible open source license.
            .setSize(0)  
        assertAcked(
        assertEquals(0, bucket.getDocCountError());
        assertEquals("B", bucket.getKey().toString());
                .setSettings(  
                .setSettings(
        );
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();  
    private static final String STRING_FIELD_NAME = "s_value";  
        assertEquals("B", bucket.getKey().toString());
        assertEquals(3, bucket.getDocCount());
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();  
        assertEquals(2, segmentResponse.getIndices().get("idx_mshard_1").getShards().get(0).getShards()[0].getSegments().size());  
        assertEquals(3, bucket.getDocCount());
        Terms.Bucket bucket = terms.getBuckets().get(0); // Bucket "B"
        assertEquals("A", bucket.getKey().toString());  
            prepareCreate("idx_shard_error").setMapping(STRING_FIELD_NAME, "type=keyword")
        // Shard_1 [A, A, A, A, B, B, C, C, D, D] -> Buckets {"A" : 4, "B" : 2}
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(5, bucket.getDocCount());  
        // size = 1, shard_size = 2  
        assertEquals(1, bucket.getDocCountError());  
        client().prepareIndex("idx_mshard_1").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();  
        // slice_2 [A, C] {"A" : 1, "C" : 1}
            .setSize(0)
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(2, terms.getBuckets().size());  
        client().prepareIndex("idx_shard_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "A").endObject()).get();
                .setSettings(
        client().prepareIndex("idx_slice_error").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();  
        assertAcked(
        refresh("idx_mshard_2");
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "C").endObject()).get();
        assertEquals(4, bucket.getDocCount());
    }
        );  
        assertEquals("B", bucket.getKey().toString());
        client().prepareIndex("idx_mshard_2").setSource(jsonBuilder().startObject().field(STRING_FIELD_NAME, "B").endObject()).get();
        terms = response.getAggregations().get("terms");
        SearchResponse response = client().prepareSearch("idx_mshard_2", "idx_mshard_1")
/*  
        terms = response.getAggregations().get("terms");
                        .put("index.refresh_interval", MINIMUM_REFRESH_INTERVAL)
        assertEquals(5, bucket.getDocCount());  
        assertEquals("C", bucket.getKey().toString());  
        assertEquals(4, terms.getDocCountError());
                        .put("index.refresh_interval", MINIMUM_REFRESH_INTERVAL)
        bucket = terms.getBuckets().get(0);

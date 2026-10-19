            assertNotNull(hit.getSourceAsString());
            .addAggregation(agg)
        List<LongTerms.Bucket> buckets = termsAgg.getBuckets();
                            (i + 1) * 100,
        return Arrays.asList(ArrowBasePlugin.class, InternalSettingsPlugin.class);
            Max maxAgg = bucket.getAggregations().get("agg2");
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value2", "field2", 22, "field3", "type3"));
    }
                            "category",
 *
            assertAggregatorUsed(resp, GlobalOrdinalsStringTermsAggregator.class);  
            .actionGet();  
        for (StringTerms.Bucket bucket : buckets) {
        assertEquals("cat_7", buckets.get(2).getKeyAsString());
        }  
                    .put("search.aggregations.streaming.min_cardinality_ratio", 0.001)
                Settings.builder()
                .setProfile(true)
            for (int i = 0; i < 10; i++) {  
        client().admin().indices().refresh(new RefreshRequest("index")).actionGet();
            .addAggregation(agg)
            .size(3)  
        client().admin().indices().flush(new FlushRequest("index").force(true)).actionGet();  
        // Test cardinality as a sub-aggregation under terms aggregation
            .setRequestCache(false)  
        super(dynamicSettings);  
        List<StringTerms.Bucket> buckets = agg1.getBuckets();
            client().admin().indices().refresh(new RefreshRequest("order_test")).actionGet();
import org.opensearch.search.aggregations.metrics.Max;
    public void testStreamingNumericAggregation() throws Exception {
    }
        assertEquals("value1", bucket1.getKeyAsString());
            )
            BulkRequest numericBulkRequest = new BulkRequest();
        SearchResponse resp = client().prepareStreamSearch("numeric_order_test")
        SearchResponse resp = future.actionGet();
import org.opensearch.action.index.IndexRequest;  
            .setSize(0)
                "Expected cardinality around 3 for bucket " + bucket.getKeyAsString() + ", got " + cardinalitySubAgg.getValue(),
        bulkRequest = new BulkRequest();
        assertEquals(3, buckets.size());  
                Version.CURRENT,  
        assertNotNull(resp);  
            }
        assertEquals(5, buckets.size());  
                int uniqueUsers = (i + 1) * 2;
                            "value",  
                false
        // Validate that streaming aggregation was actually used  
        assertEquals(5, buckets.size());
        assertEquals("cat_0", buckets.get(0).getKeyAsString());  
        assertEquals(18, buckets.get(1).getDocCount());  
        assertEquals("cat_7", buckets.get(2).getKeyAsString());
                + "  }\n"  
            .order(org.opensearch.search.aggregations.BucketOrder.aggregation("unique_users", false))  
                }  
        assertAggregatorUsed(resp, StreamNumericTermsAggregator.class);
        assertEquals(200.0, ((Max) buckets.get(1).getAggregations().get("max_value")).getValue(), 0.001);  
        CreateIndexResponse createIndexResponse = client().admin().indices().create(createIndexRequest).actionGet();
        // Validate all buckets - each should have 30 documents  
        long totalDocs = buckets.stream().mapToLong(LongTerms.Bucket::getDocCount).sum();  
        assertAggregatorUsed(resp, StreamStringTermsAggregator.class);
                            i,
            .addAggregation(agg)  
            TermsAggregationBuilder agg = terms("agg1").field("field1").subAggregation(AggregationBuilders.max("agg2").field("field2"));
        assertEquals(1000.0, ((Max) buckets.get(0).getAggregations().get("max_value")).getValue(), 0.001);
    }  
                        .put("search.aggregations.streaming.min_cardinality_ratio", 0.001)
            .addAggregation(agg)  
            .get();  
        assertNotNull(resp);
 * this file be licensed under the Apache-2.0 license or a
        StringTerms agg1 = (StringTerms) resp.getAggregations().asMap().get("agg1");
        assertEquals(16, buckets.get(2).getDocCount());
        assertEquals(14, buckets.get(3).getDocCount());
    }
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")
            Cardinality cardinalitySubAgg = bucket.getAggregations().get("cardinality_subagg");
            client().admin().indices().flush(new FlushRequest("order_test").force(true)).actionGet();
                for (int j = 0; j < docsPerSegment; j++) {  
            buckets.sort(Comparator.comparing(StringTerms.Bucket::getKeyAsString));
                    found = true;
            .addAggregation(agg)
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        assertEquals(8L, buckets.get(1).getKeyAsNumber().longValue());  
        buckets.sort(Comparator.comparingLong(b -> b.getKeyAsNumber().longValue()));
import org.opensearch.search.profile.ProfileResult;
            .setProfile(true)  
            .setProfile(true)
        for (int i = 0; i < 10; i++) {
    public void testOrderByCardinalitySubAggregationDescending() throws Exception {  
        assertEquals("cat_5", buckets.get(4).getKeyAsString());
            .prepareUpdateSettings()
        assertEquals(NUM_SHARDS, resp.getTotalShards());  
            "{\n"
public class SubAggregationIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {  
        assertEquals(9L, buckets.get(0).getKeyAsNumber().longValue());
        client().admin().indices().flush(new FlushRequest("index").force(true)).actionGet();  
        // We'll create 3 segments per shard by indexing docs into each segment and forcing a flush  
                }  
        assertAggregatorUsed(resp, StreamStringTermsAggregator.class);
        LongTerms termsAgg = resp.getAggregations().get("categories");
        List<StringTerms.Bucket> buckets = termsAgg.getBuckets();
        assertFalse(bulkResponse.hasFailures());
        bulkResponse = client().bulk(bulkRequest).actionGet();
            .setTransientSettings(
        LongTerms termsAgg = resp.getAggregations().get("categories");
                assertEquals(30, bucket.getDocCount());
        SearchResponse resp = client().prepareStreamSearch("numeric_order_test")
                    .put("search.aggregations.streaming.max_estimated_bucket_count", MAX_BUCKET_COUNT)  
                .setTransientSettings(
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value3", "field2", 23, "field3", "type3"));
        TermsAggregationBuilder agg = terms("categories").field("category")
            .size(5)  
        assertEquals(NUM_SHARDS, resp.getTotalShards());
            .setSize(0)  
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")  
        client().admin().indices().create(numericOrderIndexRequest).actionGet();
        SearchResponse resp = future.actionGet();  
            assertNotNull(maxAgg);
        List<StringTerms.Bucket> buckets = agg1.getBuckets();  
            .setTransientSettings(
        TermsAggregationBuilder agg = terms("categories").field("category")  
            .setTimeout(TimeValue.timeValueSeconds(30))
                .setRequestCache(false)  
        assertEquals(30, bucket1.getDocCount());  
                + "}",
            BulkResponse numericBulkResponse = client().bulk(numericBulkRequest).actionGet();
        }  
        assertEquals(3, buckets.size());  
    public void testStreamingAggregationTerm() throws Exception {  
    public void tearDown() throws Exception {
                    .put("search.aggregations.streaming.min_cardinality_ratio", 0.9) // Very high ratio
        StringTerms.Bucket bucket3 = buckets.get(2);  
        for (StringTerms.Bucket bucket : buckets) {
            XContentType.JSON
import org.opensearch.test.InternalSettingsPlugin;  
            "{\"properties\":{\"category\":{\"type\":\"integer\"},\"value\":{\"type\":\"integer\"},\"user_id\":{\"type\":\"keyword\"}}}",
        StringTerms termsAgg = resp.getAggregations().get("categories");  
                            "value",  
            assertNotNull(resp);
            .subAggregation(AggregationBuilders.max("max_value").field("value"));  
        // Create order_test index for string field sub-aggregation ordering tests  
    }
        List<StringTerms.Bucket> buckets = termsAgg.getBuckets();
        assertAggregatorUsed(resp, StreamNumericTermsAggregator.class);
            LongTerms.Bucket bucket = buckets.get(i);
            .setQuery(existsQuery("category"))  
        SearchResponse resp = future.actionGet();
import org.opensearch.search.SearchHit;
                    .put("search.aggregations.streaming.min_estimated_bucket_count", 1000) // Very high minimum
        TermsAggregationBuilder agg = terms("agg1").field("field1").subAggregation(AggregationBuilders.max("agg2").field("field2"));  
            );  
        List<StringTerms.Bucket> buckets = termsAgg.getBuckets();  
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
                        new IndexRequest("numeric_order_test").source(
            XContentType.JSON
    @LockFeatureFlag(STREAM_TRANSPORT)
    static final int NUM_SHARDS = 3;
        // Verify each shard has at least MIN_SEGMENTS_PER_SHARD segments
            .setSize(0)  
        );
        assertNotNull("Profile response should be present", resp.getProfileResults());
/*  
            .subAggregation(AggregationBuilders.max("max_value").field("value"));  
            .setSize(0)  
        assertEquals(12, buckets.get(4).getDocCount());
            BulkResponse orderBulkResponse = client().bulk(orderBulkRequest).actionGet();
        assertEquals(NUM_SHARDS, resp.getTotalShards());
        }
        long[] expectedValues = { 1, 2, 3, 11, 12, 13, 21, 22, 23 };  
                FlightStreamPlugin.class.getName(),  
            .execute()
        }  
        internalCluster().ensureAtLeastNumDataNodes(3);
        // Use existsQuery to avoid match-all optimization that would disable streaming  
                "NA",
    @LockFeatureFlag(STREAM_TRANSPORT)  
        SearchResponse resp = future.actionGet();  
package org.opensearch.streaming.aggregation;
                            "category",
    protected Collection<PluginInfo> additionalNodePlugins() {  
            .addAggregation(agg)
                            "user_id",
        assertEquals(90, resp.getHits().getTotalHits().value());
import org.opensearch.search.aggregations.bucket.terms.GlobalOrdinalsStringTermsAggregator;  
        SearchResponse resp = client().prepareStreamSearch("numeric_order_test")
        assertNotNull(termsAgg);
            assertNotNull(maxAgg);  
        assertTrue("Expected to find " + expectedAggregatorClass.getSimpleName() + " in profile", found);
        assertEquals(3, buckets.size());
            assertEquals(expectedValues[i], maxAgg.getValue(), 0.001);
        assertEquals(20, buckets.get(0).getDocCount());  
        TermsAggregationBuilder agg = terms("agg1").field("field1").subAggregation(AggregationBuilders.max("agg2").field("field2"));
        super.setUp();  
        assertEquals("cat_6", buckets.get(3).getKeyAsString());
        client().admin().cluster().prepareHealth("index").setWaitForGreenStatus().setTimeout(TimeValue.timeValueSeconds(30)).get();  
            .addAggregation(agg)
import org.opensearch.search.aggregations.bucket.terms.StreamNumericTermsAggregator;
            .size(3)
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                        )
import org.opensearch.search.aggregations.metrics.Cardinality;  
            BulkRequest orderBulkRequest = new BulkRequest();
                            "user_id",
        // Verify ordered by doc count DESC
        assertEquals(1L, buckets.get(1).getKeyAsNumber().longValue());  
        boolean found = false;  
        List<LongTerms.Bucket> buckets = agg1.getBuckets();
            .setRequestCache(false)
        // Use existsQuery to avoid match-all optimization that would disable streaming
                    .put("search.aggregations.streaming.max_estimated_bucket_count", 1) // Very low limit  
        // Verify that we have the expected number of shards and segments  
        for (int i = 0; i < buckets.size(); i++) {
        }  
            List<StringTerms.Bucket> buckets = agg1.getBuckets();  
        assertEquals(12, buckets.get(4).getDocCount());  
            assertEquals(30, bucket.getDocCount());
    public void testNumericOrderByCardinalitySubAggregationDescending() throws Exception {
            Max maxAgg = bucket.getAggregations().get("agg2");
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
            .addAggregation(agg)
            .put("index.number_of_shards", NUM_SHARDS)    // Number of primary shards
            client().admin().indices().flush(new FlushRequest("numeric_order_test").force(true)).actionGet();
        );  
            .actionGet();  
        assertEquals(800.0, ((Max) buckets.get(2).getAggregations().get("max_value")).getValue(), 0.001);  
        assertEquals(900.0, ((Max) buckets.get(1).getAggregations().get("max_value")).getValue(), 0.001);
    @LockFeatureFlag(STREAM_TRANSPORT)
            StringTerms agg1 = (StringTerms) resp.getAggregations().asMap().get("agg1");
        assertAggregatorUsed(resp, StreamStringTermsAggregator.class);
            .setProfile(true)  
        client().admin().indices().refresh(new RefreshRequest("index")).actionGet();
    @LockFeatureFlag(STREAM_TRANSPORT)  
        assertEquals(5L, buckets.get(4).getKeyAsNumber().longValue());
        assertEquals(90, resp.getHits().getTotalHits().value());  
import org.opensearch.common.xcontent.XContentType;
        for (SearchHit hit : resp.getHits().getHits()) {
        assertEquals(300.0, ((Max) buckets.get(2).getAggregations().get("max_value")).getValue(), 0.001);  
                            "cat_" + i,
                    .putNull("search.aggregations.streaming.min_cardinality_ratio")
            .subAggregation(AggregationBuilders.max("max_value").field("value"));
                .prepareUpdateSettings()  
        assertEquals(1000.0, ((Max) buckets.get(0).getAggregations().get("max_value")).getValue(), 0.001);
                            (i + 1) * 100,
        SearchResponse resp = client().prepareStreamSearch("order_test").addAggregation(agg).setSize(0).execute().actionGet();
            .cluster()  
    }
        assertEquals(300.0, ((Max) buckets.get(2).getAggregations().get("max_value")).getValue(), 0.001);
            );  
import org.opensearch.plugins.Plugin;
            }
                "classpath plugin",
            .setSize(0)
        }
        assertEquals(16, buckets.get(2).getDocCount());
        try {
                )
        for (int seg = 0; seg < 3; seg++) {
            .actionGet();
        }
        assertEquals(NUM_SHARDS, resp.getTotalShards());  
            )
            .setSize(0)  
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
        assertEquals(6L, buckets.get(3).getKeyAsNumber().longValue());
    @LockFeatureFlag(STREAM_TRANSPORT)
        assertNotNull(resp);  
    public SubAggregationIT(Settings dynamicSettings) {
            .execute();
            .addAggregation(agg)
        for (var shardProfile : resp.getProfileResults().values()) {
        LongTerms agg1 = (LongTerms) resp.getAggregations().asMap().get("agg1");  
        assertAggregatorUsed(resp, StreamNumericTermsAggregator.class);
            .execute();
    public void testNumericNoSortOrderWithSubAgg() throws Exception {  
                + "  \"properties\": {\n"
        bulkRequest = new BulkRequest();
    public void testNumericOrderByMaxSubAggregationAscending() throws Exception {
            .subAggregation(AggregationBuilders.cardinality("cardinality_subagg").field("field3").precisionThreshold(1000));
                cardinalitySubAgg.getValue() >= 2 && cardinalitySubAgg.getValue() <= 4
        assertEquals(8L, buckets.get(1).getKeyAsNumber().longValue());
            .put("index.number_of_replicas", 0)  
            assertEquals(3, buckets.size());
        StringTerms termsAgg = resp.getAggregations().get("categories");
    public void setUp() throws Exception {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("index").settings(indexSettings);
        SearchResponse resp = future.actionGet();
            .setWaitForGreenStatus()  
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")
            .subAggregation(AggregationBuilders.cardinality("unique_users").field("user_id"));
        // Segment 1 - we'll add docs with field2 values in 1-3 range, field3 values type1-3
        client().admin()
        assertEquals(20, buckets.get(0).getDocCount());
            assertEquals(90, resp.getHits().getTotalHits().value());
                for (int j = 0; j < docsPerSegment; j++) {  
            .size(5)
                        .build()  
                    .build()  
        assertAggregatorUsed(resp, StreamStringTermsAggregator.class);  
}
        }  
        assertEquals(18, buckets.get(1).getDocCount());
        BulkRequest bulkRequest = new BulkRequest();
        assertEquals(NUM_SHARDS, segmentResponse.getIndices().get("index").getShards().size());
            .get();
        StringTerms termsAgg = resp.getAggregations().get("terms_agg");  
        assertEquals(7L, buckets.get(2).getKeyAsNumber().longValue());
        client().admin().indices().create(orderIndexRequest).actionGet();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        TermsAggregationBuilder agg = terms("terms_agg").field("field1")
            assertNotNull(cardinalitySubAgg);  
import java.util.Arrays;
                    break;  
            .execute(); // No profile
                        new IndexRequest("order_test").source(
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
            .get();
        // Each bucket should have cardinality of 3 (each field1 value appears with 3 different field3 values)
                        .put("search.aggregations.streaming.min_estimated_bucket_count", 1)
            .subAggregation(AggregationBuilders.cardinality("unique_users").field("user_id"));
        assertNotNull(resp);
        CreateIndexRequest orderIndexRequest = new CreateIndexRequest("order_test").settings(orderIndexSettings);
        assertEquals(30, bucket3.getDocCount());
        createIndexRequest.mapping(  
        // Segment 2 - we'll add docs with field2 values in 11-13 range, field3 values type4-6  
        assertFalse(bulkResponse.hasFailures()); // Verify ingestion was successful
        assertEquals(90, resp.getHits().getTotalHits().value());
            .actionGet();  
        StringTerms.Bucket bucket2 = buckets.get(1);
        });
            client().admin().indices().refresh(new RefreshRequest("numeric_order_test")).actionGet();
        TermsAggregationBuilder agg = terms("categories").field("category")
    @LockFeatureFlag(STREAM_TRANSPORT)
 * compatible open source license.
        assertEquals(5, buckets.size());  
        TermsAggregationBuilder agg = terms("agg1").field("field1");
        assertEquals("cat_8", buckets.get(1).getKeyAsString());
    public void testOrderByMaxSubAggregationAscending() throws Exception {
                .execute();
            .setRequestCache(false)
            .execute();
            .order(org.opensearch.search.aggregations.BucketOrder.aggregation("max_value", true))
            client().admin()
    @LockFeatureFlag(STREAM_TRANSPORT)  
            .setRequestCache(false)
        assertEquals("value3", bucket3.getKeyAsString());
        // Expected top 5: cat_9(20 docs), cat_8(18 docs), cat_7(16 docs), cat_6(14 docs), cat_5(12 docs)  
        assertEquals(9L, buckets.get(0).getKeyAsNumber().longValue());
            .order(org.opensearch.search.aggregations.BucketOrder.aggregation("max_value", false))
    public void testStreamingCardinalityAsSubAggregation() throws Exception {
            assertFalse(orderBulkResponse.hasFailures());  
        }
    }
        super.tearDown();
            .cluster()
            if (found) break;  
                "Expected at least "
        assertEquals(5, buckets.size());  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 3, maxNumDataNodes = 3)
        TermsAggregationBuilder agg = terms("categories").field("category")
                    + MIN_SEGMENTS_PER_SHARD
import org.opensearch.search.aggregations.AggregationBuilders;
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value1", "field2", 21, "field3", "type3"));  
        // Validate all buckets - total should be 90 documents
            .setProfile(true)
        buckets.sort(Comparator.comparing(StringTerms.Bucket::getKeyAsString));
        assertEquals(100.0, ((Max) buckets.get(0).getAggregations().get("max_value")).getValue(), 0.001);
        assertEquals("cat_8", buckets.get(1).getKeyAsString());  
            .put("index.merge.enabled", false) // Disable merges to keep individual segments
        // This test validates streaming aggregation results without profile to avoid profile-related issues
            .order(org.opensearch.search.aggregations.BucketOrder.aggregation("max_value", false))
        List<StringTerms.Bucket> buckets = termsAgg.getBuckets();
                int uniqueUsers = (i + 1) * 2;
            .order(org.opensearch.search.aggregations.BucketOrder.aggregation("max_value", true))
            assertFalse(numericBulkResponse.hasFailures());  
                            XContentType.JSON,  
    @LockFeatureFlag(STREAM_TRANSPORT)
    }
    public void testStreamingAggregationNotUsedWithRestrictiveLimits() throws Exception {
import org.opensearch.common.unit.TimeValue;  
            .cluster()
            .size(3)  
                int docsPerSegment = uniqueUsers / 3 + (seg < uniqueUsers % 3 ? 1 : 0);
            assertEquals(30, bucket.getDocCount());  
        assertEquals("cat_5", buckets.get(4).getKeyAsString());  
        SearchResponse resp = client().prepareStreamSearch("order_test")
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
    public void testNumericOrderByMaxSubAggregationDescending() throws Exception {
                + "    \"field1\": { \"type\": \"keyword\" },\n"  
        // Default order: by doc count DESC, then by key ASC
        bulkResponse = client().bulk(bulkRequest).actionGet();
                + "    \"field2\": { \"type\": \"integer\" },\n"
        assertEquals(3, buckets.size());  
        SearchResponse resp = client().prepareStreamSearch("numeric_order_test").addAggregation(agg).setSize(0).execute().actionGet();
            .execute()
                    );
            .order(org.opensearch.search.aggregations.BucketOrder.aggregation("unique_users", false))
        // Configure streaming aggregation settings to ensure per-segment flush mode  
        TermsAggregationBuilder agg = terms("agg1").field("field2").subAggregation(AggregationBuilders.max("agg2").field("field2"));  
        assertEquals("value2", bucket2.getKeyAsString());  
        List<LongTerms.Bucket> buckets = termsAgg.getBuckets();
        BulkResponse bulkResponse = client().bulk(bulkRequest).actionGet();
import org.opensearch.search.aggregations.bucket.terms.StreamStringTermsAggregator;  
        // Create numeric_order_test index for numeric field sub-aggregation ordering tests
        SearchResponse resp = future.actionGet();
            .setProfile(true)
            .prepareUpdateSettings()  
        SearchResponse resp = client().prepareStreamSearch("order_test")
        assertEquals(NUM_SHARDS, resp.getTotalShards());
            .setProfile(true)
import org.opensearch.action.search.SearchResponse;
            )  
    }  
        assertEquals(6L, buckets.get(3).getKeyAsNumber().longValue());
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
        }  
import java.util.Comparator;  
        List<LongTerms.Bucket> buckets = termsAgg.getBuckets();
        );
        client().admin().indices().refresh(new RefreshRequest("index")).actionGet();  
        assertEquals("cat_1", buckets.get(1).getKeyAsString());
 * The OpenSearch Contributors require contributions made to  
            .prepareHealth("numeric_order_test")
            .subAggregation(AggregationBuilders.max("max_value").field("value"));
        client().admin().indices().refresh(new RefreshRequest("index")).actionGet();
        assertNotNull(resp);
                    numericBulkRequest.add(
                .addAggregation(agg)
        assertEquals(3, buckets.size());
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")
    }
            assertTrue(  
        TermsAggregationBuilder agg = terms("categories").field("category")
        assertEquals("cat_2", buckets.get(2).getKeyAsString());
        // This test validates streaming aggregation with 3 shards, each with at least 3 segments
        );
                        .put("search.aggregations.streaming.max_estimated_bucket_count", MAX_BUCKET_COUNT)  
            List<ProfileResult> aggProfileResults = shardProfile.getAggregationProfileResults().getProfileResults();
        assertEquals(3, buckets.size());  
        client().admin()
            for (int i = 0; i < 10; i++) {  
        assertEquals(5L, buckets.get(4).getKeyAsNumber().longValue());
    }  
    static final int MIN_SEGMENTS_PER_SHARD = 3;  
        orderIndexRequest.mapping(  
            assertTrue(  
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value2", "field2", 12, "field3", "type2"));
    @LockFeatureFlag(STREAM_TRANSPORT)  
                Settings.builder()
        assertEquals(3, buckets.size());
        // Segment 3 - we'll add docs with field2 values in 21-23 range, field3 values type7-9  
            )
        StringTerms.Bucket bucket1 = buckets.get(0);
    @Override  
    @Override
        assertEquals(8L, buckets.get(1).getKeyAsNumber().longValue());
import java.util.Collection;
        Settings orderIndexSettings = Settings.builder()
                List.of(ArrowBasePlugin.class.getName()),
            .prepareUpdateSettings()  
 */  
        assertEquals(100.0, ((Max) buckets.get(0).getAggregations().get("max_value")).getValue(), 0.001);
        StringTerms termsAgg = resp.getAggregations().get("categories");
        assertEquals(14, buckets.get(3).getDocCount());  
            .build();  
        assertEquals(2L, buckets.get(2).getKeyAsNumber().longValue());
            .addAggregation(agg)
                Settings.builder()  
        numericOrderIndexRequest.mapping(
        TermsAggregationBuilder agg = terms("categories").field("category")
            .cluster()
        assertEquals(90, resp.getHits().getTotalHits().value());
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertEquals(90, totalDocs);
        TermsAggregationBuilder agg = terms("agg1").field("field2").subAggregation(AggregationBuilders.max("agg2").field("field2"));  
        // Validate all buckets - each should have 30 documents
            .setSize(0)  
        client().admin()
            .addAggregation(agg)
            .setSize(0)  
            .get();
            .subAggregation(AggregationBuilders.max("max_value").field("value"));  
        assertAggregatorUsed(resp, StreamNumericTermsAggregator.class);
            assertEquals(30, bucket.getDocCount());  
                null,  
                "1.8",
                            "user_" + (i * 100 + seg * 100 + j)  
            .put("index.search.concurrent_segment_search.mode", "none")
            .setSize(0)
        segmentResponse.getIndices().get("index").getShards().values().forEach(indexShardSegments -> {
        CreateIndexRequest numericOrderIndexRequest = new CreateIndexRequest("numeric_order_test").settings(orderIndexSettings);  
        assertEquals("cat_9", buckets.get(0).getKeyAsString());
        TermsAggregationBuilder agg = terms("categories").field("category")
            .setSize(0)
        List<StringTerms.Bucket> buckets = termsAgg.getBuckets();
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")  
                            "user_" + (i * 100 + seg * 100 + j)  
            for (var profileResult : aggProfileResults) {  
                .get();
            .put("index.merge.enabled", false)
        buckets.sort(Comparator.comparing(StringTerms.Bucket::getKeyAsString));
            .setProfile(true)
            "{\"properties\":{\"category\":{\"type\":\"keyword\"},\"value\":{\"type\":\"integer\"},\"user_id\":{\"type\":\"keyword\"}}}",
        assertEquals("cat_6", buckets.get(3).getKeyAsString());  
                if (expectedAggregatorClass.getSimpleName().equals(profileResult.getQueryName())) {
        assertEquals("cat_8", buckets.get(1).getKeyAsString());  
    }
            XContentType.JSON  
    }
            new PluginInfo(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        assertEquals(7L, buckets.get(2).getKeyAsNumber().longValue());  
    }  
            // HyperLogLog is approximate, allow some tolerance
        assertFalse(bulkResponse.hasFailures());
        assertNotNull(resp);
            assertTrue(maxAgg.getValue() > 0);  
import java.util.List;
                    Settings.builder()
                            XContentType.JSON,  
import org.opensearch.action.bulk.BulkRequest;
            .setRequestCache(false)  
        // Use existsQuery to avoid match-all optimization that would disable streaming
        Settings indexSettings = Settings.builder()
            assertEquals(expectedValues[i], bucket.getKeyAsNumber().longValue());  
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;  
            .size(5)
        assertEquals(30, bucket2.getDocCount());
                    + " segments but found "  
            .actionGet();  
    }
            assertEquals(NUM_SHARDS, resp.getTotalShards());  
    @LockFeatureFlag(STREAM_TRANSPORT)
            for (StringTerms.Bucket bucket : buckets) {  
        );  
import static org.opensearch.index.query.QueryBuilders.existsQuery;
        buckets.sort(Comparator.comparing(StringTerms.Bucket::getKeyAsString));
        } finally {  
        StringTerms termsAgg = resp.getAggregations().get("categories");
        assertEquals(9, buckets.size()); // 9 unique numeric values
        client().admin().indices().flush(new FlushRequest("index").force(true)).actionGet();  
            .put("index.search.concurrent_segment_search.mode", "none")
    @ParametersFactory  
                int docsPerSegment = uniqueUsers / 3 + (seg < uniqueUsers % 3 ? 1 : 0);
            .setProfile(true)
    @LockFeatureFlag(STREAM_TRANSPORT)
        assertEquals(900.0, ((Max) buckets.get(1).getAggregations().get("max_value")).getValue(), 0.001);
    @LockFeatureFlag(STREAM_TRANSPORT)  
    public void testStreamingAggregationUsed() throws Exception {  
            assertTrue("Bucket should have at least 1 document", bucket.getDocCount() > 0);
import org.opensearch.Version;  
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;  
            .addAggregation(agg)
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value3", "field2", 3, "field3", "type1"));
                .cluster()
        IndicesSegmentResponse segmentResponse = client().admin().indices().segments(new IndicesSegmentsRequest("index")).actionGet();
import org.opensearch.common.settings.Settings;
                    );
            .subAggregation(AggregationBuilders.max("max_value").field("value"));
    static final int MAX_BUCKET_COUNT = 100000;
        // Using field3 (keyword field) for cardinality since StreamCardinalityAggregator only supports ordinal value sources  
                    .build()
                + "    \"field3\": { \"type\": \"keyword\" }\n"
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value1", "field2", 1, "field3", "type1"));  
    }  
        client().admin().cluster().prepareHealth("order_test").setWaitForGreenStatus().setTimeout(TimeValue.timeValueSeconds(30)).get();
            .setTransientSettings(
            .execute()
    }  
            .actionGet();
        // This test validates numeric streaming aggregation with profile to verify streaming is used
    private void assertAggregatorUsed(SearchResponse resp, Class<?> expectedAggregatorClass) {
    @LockFeatureFlag(STREAM_TRANSPORT)
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;  
            .put("index.number_of_replicas", 0)  // Number of replica shards  
                    + indexShardSegments.getShards()[0].getSegments().size(),
            .setQuery(existsQuery("field1"))
        // Based on the data: all field1 values→{type1,type2,type3}
        assertEquals(90, resp.getHits().getTotalHits().value());
        return Arrays.asList(
        assertEquals(0L, buckets.get(0).getKeyAsNumber().longValue());
        client().admin()  
        // Use existsQuery to avoid match-all optimization that would disable streaming
        assertEquals(7L, buckets.get(2).getKeyAsNumber().longValue());  
        // This test validates streaming aggregation with 3 shards, each with at least 3 segments
        // Validate that streaming aggregation was actually used
 * SPDX-License-Identifier: Apache-2.0
            }
            SearchResponse resp = future.actionGet();  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
    public void testNoSortOrderWithSubAgg() throws Exception {
        }  
        assertEquals("cat_9", buckets.get(0).getKeyAsString());  
            .setQuery(existsQuery("category"))
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value2", "field2", 2, "field3", "type1"));
                FlightStreamPlugin.class.getName(),
import org.opensearch.common.action.ActionFuture;
import org.opensearch.test.OpenSearchIntegTestCase;
            .setQuery(existsQuery("category"))
    }
    public void testOrderByMaxSubAggregationDescending() throws Exception {
import org.opensearch.plugins.PluginInfo;  
        assertEquals(90, resp.getHits().getTotalHits().value());
    @Override
        for (int i = 0; i < 10; i++) {
        assertEquals("cat_9", buckets.get(0).getKeyAsString());
    }  
import org.opensearch.action.admin.indices.flush.FlushRequest;  
    @LockFeatureFlag(STREAM_TRANSPORT)  
                    orderBulkRequest.add(
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")
            .setSize(0)
        assertTrue(createIndexResponse.isAcknowledged());
            ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")  
                    .putNull("search.aggregations.streaming.min_estimated_bucket_count")  
            .setSize(0)  
    @Override  
            .execute()
    public static Collection<Object[]> parameters() {
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value3", "field2", 13, "field3", "type2"));
            .execute();
                }
                indexShardSegments.getShards()[0].getSegments().size() >= MIN_SEGMENTS_PER_SHARD
        StringTerms agg1 = (StringTerms) resp.getAggregations().asMap().get("agg1");  
    }
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        assertEquals(9L, buckets.get(0).getKeyAsNumber().longValue());
        for (int seg = 0; seg < 3; seg++) {
            .build();  
        assertEquals(NUM_SHARDS, resp.getTotalShards());  
            .put("index.number_of_shards", NUM_SHARDS)
        return List.of(
    public void testStreamingNumericAggregationUsed() throws Exception {
            }
        assertEquals(200.0, ((Max) buckets.get(1).getAggregations().get("max_value")).getValue(), 0.001);
            .execute()  
            .execute()
    }  
        // Configure very restrictive limits to force per-shard flush mode  
            .size(5)
                    .build()  
        SearchResponse resp = client().prepareStreamSearch("order_test")  
                        )
    }
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value1", "field2", 11, "field3", "type2"));  
        LongTerms termsAgg = resp.getAggregations().get("categories");
                .setSize(0)
        List<LongTerms.Bucket> buckets = termsAgg.getBuckets();
        assertEquals(800.0, ((Max) buckets.get(2).getAggregations().get("max_value")).getValue(), 0.001);  
        for (int i = 0; i < 10; i++) {
        assertEquals("cat_7", buckets.get(2).getKeyAsString());
            // Each field1 value appears with exactly 3 field3 values
                    .put("search.aggregations.streaming.min_estimated_bucket_count", 1)
            .setRequestCache(false)
                    .putNull("search.aggregations.streaming.max_estimated_bucket_count")
    public void testStreamingAggregationWithoutProfile() throws Exception {  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        LongTerms termsAgg = resp.getAggregations().get("categories");
    @LockFeatureFlag(STREAM_TRANSPORT)  
            .execute();  
        ensureSearchable("index");
            .size(3)  
        TermsAggregationBuilder agg = terms("categories").field("category")
        }
        for (StringTerms.Bucket bucket : buckets) {  

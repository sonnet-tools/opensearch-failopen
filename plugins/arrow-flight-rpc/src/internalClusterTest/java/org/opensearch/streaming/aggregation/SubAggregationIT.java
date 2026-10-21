        client().admin()
import org.opensearch.action.search.SearchResponse;
            assertTrue(maxAgg.getValue() > 0);
            for (var profileResult : aggProfileResults) {
        super.tearDown();
    }
            .put("index.number_of_replicas", 0)
                    .build()
import static org.opensearch.index.query.QueryBuilders.existsQuery;
                        .put("search.aggregations.streaming.min_estimated_bucket_count", 1)
                    );
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
            "{\n"
        assertEquals(7L, buckets.get(2).getKeyAsNumber().longValue());
            assertFalse(numericBulkResponse.hasFailures());
            BulkRequest numericBulkRequest = new BulkRequest();
        for (int i = 0; i < 10; i++) {
    @LockFeatureFlag(STREAM_TRANSPORT)
        assertAggregatorUsed(resp, StreamStringTermsAggregator.class);
    public void testStreamingAggregationWithoutProfile() throws Exception {
        // Use existsQuery to avoid match-all optimization that would disable streaming
            )
            assertEquals(30, bucket.getDocCount());
            .cluster()
        assertEquals(14, buckets.get(3).getDocCount());
        SearchResponse resp = client().prepareStreamSearch("numeric_order_test").addAggregation(agg).setSize(0).execute().actionGet();
        buckets.sort(Comparator.comparing(StringTerms.Bucket::getKeyAsString));
        List<LongTerms.Bucket> buckets = termsAgg.getBuckets();
            assertEquals(30, bucket.getDocCount());
        LongTerms termsAgg = resp.getAggregations().get("categories");
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")
    public void testNoSortOrderWithSubAgg() throws Exception {
        // Expected top 5: cat_9(20 docs), cat_8(18 docs), cat_7(16 docs), cat_6(14 docs), cat_5(12 docs)
        for (int i = 0; i < 10; i++) {
                    + " segments but found "
            assertNotNull(hit.getSourceAsString());
                    Settings.builder()
        assertEquals(18, buckets.get(1).getDocCount());
            .subAggregation(AggregationBuilders.max("max_value").field("value"));
        createIndexRequest.mapping(
            .setSize(0)
                    numericBulkRequest.add(
                .setRequestCache(false)
        bulkResponse = client().bulk(bulkRequest).actionGet();
        TermsAggregationBuilder agg = terms("agg1").field("field1").subAggregation(AggregationBuilders.max("agg2").field("field2"));
            .setSize(0)
import org.opensearch.plugins.Plugin;
import java.util.Comparator;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("cat_5", buckets.get(4).getKeyAsString());
            }
        long totalDocs = buckets.stream().mapToLong(LongTerms.Bucket::getDocCount).sum();
                }
            assertAggregatorUsed(resp, GlobalOrdinalsStringTermsAggregator.class);
                false
        List<StringTerms.Bucket> buckets = termsAgg.getBuckets();
                            "value",
        assertNotNull(resp);
        assertEquals(12, buckets.get(4).getDocCount());
        for (StringTerms.Bucket bucket : buckets) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            assertEquals(expectedValues[i], bucket.getKeyAsNumber().longValue());
import org.opensearch.search.aggregations.metrics.Cardinality;
        // Each bucket should have cardinality of 3 (each field1 value appears with 3 different field3 values)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 3, maxNumDataNodes = 3)
            .subAggregation(AggregationBuilders.max("max_value").field("value"));
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        StringTerms agg1 = (StringTerms) resp.getAggregations().asMap().get("agg1");
        assertNotNull(resp);
            assertEquals(90, resp.getHits().getTotalHits().value());
    public void testOrderByCardinalitySubAggregationDescending() throws Exception {
        assertAggregatorUsed(resp, StreamNumericTermsAggregator.class);
            .order(org.opensearch.search.aggregations.BucketOrder.aggregation("unique_users", false))
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value2", "field2", 12, "field3", "type2"));
import java.util.List;
            .size(5)
    @Override
        }
    @LockFeatureFlag(STREAM_TRANSPORT)
        BulkRequest bulkRequest = new BulkRequest();
        assertEquals(2L, buckets.get(2).getKeyAsNumber().longValue());
                .addAggregation(agg)
        LongTerms termsAgg = resp.getAggregations().get("categories");
    }
        assertEquals(5L, buckets.get(4).getKeyAsNumber().longValue());
            .size(3)
        assertEquals("cat_1", buckets.get(1).getKeyAsString());
        for (StringTerms.Bucket bucket : buckets) {
            .setTransientSettings(
        SearchResponse resp = future.actionGet();
                List.of(ArrowBasePlugin.class.getName()),
        ensureSearchable("index");
        // Validate all buckets - each should have 30 documents
import org.opensearch.test.InternalSettingsPlugin;
import org.opensearch.common.settings.Settings;
        assertEquals("cat_9", buckets.get(0).getKeyAsString());
        assertEquals("cat_7", buckets.get(2).getKeyAsString());
    @LockFeatureFlag(STREAM_TRANSPORT)
            .addAggregation(agg)
                .prepareUpdateSettings()
        TermsAggregationBuilder agg = terms("categories").field("category")
import java.util.Collection;
import org.opensearch.search.aggregations.bucket.terms.StreamStringTermsAggregator;
        client().admin().indices().flush(new FlushRequest("index").force(true)).actionGet();
            // HyperLogLog is approximate, allow some tolerance
        assertEquals(3, buckets.size());
        SearchResponse resp = client().prepareStreamSearch("order_test")
            }
        assertEquals(3, buckets.size());
                assertEquals(30, bucket.getDocCount());
    public void testNumericOrderByCardinalitySubAggregationDescending() throws Exception {
        assertEquals(800.0, ((Max) buckets.get(2).getAggregations().get("max_value")).getValue(), 0.001);
            .order(org.opensearch.search.aggregations.BucketOrder.aggregation("max_value", false))
            .put("index.number_of_shards", NUM_SHARDS)    // Number of primary shards
        // Validate all buckets - each should have 30 documents
                            XContentType.JSON,
        assertEquals(14, buckets.get(3).getDocCount());
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
        assertEquals(5, buckets.size());
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value3", "field2", 23, "field3", "type3"));
            .setRequestCache(false)
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        for (var shardProfile : resp.getProfileResults().values()) {
        assertNotNull(resp);
        assertEquals(90, resp.getHits().getTotalHits().value());
        StringTerms termsAgg = resp.getAggregations().get("categories");
            .size(3)
    }
            .setSize(0)
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")
        // This test validates streaming aggregation results without profile to avoid profile-related issues
        assertNotNull("Profile response should be present", resp.getProfileResults());
            .addAggregation(agg)
                }
    }
                FlightStreamPlugin.class.getName(),
        IndicesSegmentResponse segmentResponse = client().admin().indices().segments(new IndicesSegmentsRequest("index")).actionGet();
            .setSize(0)
            .prepareUpdateSettings()
        assertEquals("cat_6", buckets.get(3).getKeyAsString());
                    .put("search.aggregations.streaming.min_estimated_bucket_count", 1)
    }
            .setSize(0)
            .actionGet();
                        new IndexRequest("order_test").source(
    public void setUp() throws Exception {
        assertAggregatorUsed(resp, StreamNumericTermsAggregator.class);
            client().admin().indices().flush(new FlushRequest("numeric_order_test").force(true)).actionGet();
            .put("index.number_of_shards", NUM_SHARDS)
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")
                "NA",
        assertTrue(createIndexResponse.isAcknowledged());
            .cluster()
                            "user_id",
                .setSize(0)
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")
        LongTerms termsAgg = resp.getAggregations().get("categories");
            .setProfile(true)
        client().admin().cluster().prepareHealth("index").setWaitForGreenStatus().setTimeout(TimeValue.timeValueSeconds(30)).get();
            assertNotNull(resp);
    @LockFeatureFlag(STREAM_TRANSPORT)
        // Validate all buckets - total should be 90 documents
        assertEquals(5, buckets.size());
    @LockFeatureFlag(STREAM_TRANSPORT)
            .subAggregation(AggregationBuilders.max("max_value").field("value"));
            .execute();
            .build();
            .prepareHealth("numeric_order_test")
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        assertTrue("Expected to find " + expectedAggregatorClass.getSimpleName() + " in profile", found);
import org.opensearch.action.index.IndexRequest;
        assertEquals(0L, buckets.get(0).getKeyAsNumber().longValue());
        for (int i = 0; i < buckets.size(); i++) {
        }
    }
            BulkRequest orderBulkRequest = new BulkRequest();
        assertFalse(bulkResponse.hasFailures());
    }
            .execute()
        // Configure streaming aggregation settings to ensure per-segment flush mode
        client().admin()
        TermsAggregationBuilder agg = terms("agg1").field("field2").subAggregation(AggregationBuilders.max("agg2").field("field2"));
/*
            Max maxAgg = bucket.getAggregations().get("agg2");
        assertEquals(7L, buckets.get(2).getKeyAsNumber().longValue());
                    + MIN_SEGMENTS_PER_SHARD
                    .put("search.aggregations.streaming.max_estimated_bucket_count", MAX_BUCKET_COUNT)
import org.opensearch.action.bulk.BulkResponse;
        Settings indexSettings = Settings.builder()
        );
        // This test validates streaming aggregation with 3 shards, each with at least 3 segments
                "Expected at least "
    }
            .actionGet();
    @LockFeatureFlag(STREAM_TRANSPORT)
            .subAggregation(AggregationBuilders.max("max_value").field("value"));
                    orderBulkRequest.add(
            .setRequestCache(false)
        // Segment 3 - we'll add docs with field2 values in 21-23 range, field3 values type7-9
        assertFalse(bulkResponse.hasFailures());
                            "cat_" + i,
        assertEquals(30, bucket2.getDocCount());
            }
        // Verify that we have the expected number of shards and segments
        // Configure very restrictive limits to force per-shard flush mode
    @LockFeatureFlag(STREAM_TRANSPORT)
                        new IndexRequest("numeric_order_test").source(
            .setProfile(true)
        internalCluster().ensureAtLeastNumDataNodes(3);
        // Test cardinality as a sub-aggregation under terms aggregation
        TermsAggregationBuilder agg = terms("categories").field("category")
            .execute();
        assertEquals(20, buckets.get(0).getDocCount());
            buckets.sort(Comparator.comparing(StringTerms.Bucket::getKeyAsString));
        assertEquals(90, totalDocs);
        client().admin().indices().flush(new FlushRequest("index").force(true)).actionGet();
            .subAggregation(AggregationBuilders.max("max_value").field("value"));
        List<LongTerms.Bucket> buckets = termsAgg.getBuckets();
    public void testOrderByMaxSubAggregationDescending() throws Exception {
        assertEquals(300.0, ((Max) buckets.get(2).getAggregations().get("max_value")).getValue(), 0.001);
            .setSize(0)
            for (StringTerms.Bucket bucket : buckets) {
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")
            .get();
            .size(5)
            client().admin().indices().refresh(new RefreshRequest("order_test")).actionGet();
        assertEquals(90, resp.getHits().getTotalHits().value());
        // Validate that streaming aggregation was actually used
        CreateIndexRequest numericOrderIndexRequest = new CreateIndexRequest("numeric_order_test").settings(orderIndexSettings);
    @LockFeatureFlag(STREAM_TRANSPORT)
        // Using field3 (keyword field) for cardinality since StreamCardinalityAggregator only supports ordinal value sources
            TermsAggregationBuilder agg = terms("agg1").field("field1").subAggregation(AggregationBuilders.max("agg2").field("field2"));
                "Expected cardinality around 3 for bucket " + bucket.getKeyAsString() + ", got " + cardinalitySubAgg.getValue(),
        client().admin().indices().refresh(new RefreshRequest("index")).actionGet();
        SearchResponse resp = client().prepareStreamSearch("numeric_order_test")
        StringTerms.Bucket bucket2 = buckets.get(1);
        assertEquals(1L, buckets.get(1).getKeyAsNumber().longValue());
        // Use existsQuery to avoid match-all optimization that would disable streaming
}
        assertEquals("value1", bucket1.getKeyAsString());
import org.opensearch.common.xcontent.XContentType;
        SearchResponse resp = future.actionGet();
    public void testStreamingNumericAggregationUsed() throws Exception {
        SearchResponse resp = client().prepareStreamSearch("order_test").addAggregation(agg).setSize(0).execute().actionGet();
    @Override
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value3", "field2", 13, "field3", "type2"));
            )
        LongTerms agg1 = (LongTerms) resp.getAggregations().asMap().get("agg1");
        assertEquals(6L, buckets.get(3).getKeyAsNumber().longValue());
        assertEquals(100.0, ((Max) buckets.get(0).getAggregations().get("max_value")).getValue(), 0.001);
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
            .setQuery(existsQuery("category"))
    public void testNumericOrderByMaxSubAggregationAscending() throws Exception {
                Settings.builder()
            StringTerms agg1 = (StringTerms) resp.getAggregations().asMap().get("agg1");
            SearchResponse resp = future.actionGet();
    @LockFeatureFlag(STREAM_TRANSPORT)
            XContentType.JSON
            .get();
            assertNotNull(maxAgg);
        BulkResponse bulkResponse = client().bulk(bulkRequest).actionGet();
        // Based on the data: all field1 values→{type1,type2,type3}
        client().admin()
    }
        StringTerms termsAgg = resp.getAggregations().get("categories");
        CreateIndexRequest orderIndexRequest = new CreateIndexRequest("order_test").settings(orderIndexSettings);
        assertNotNull(termsAgg);
                        .build()
    protected Collection<PluginInfo> additionalNodePlugins() {
                .execute();
            .addAggregation(agg)
        assertEquals(8L, buckets.get(1).getKeyAsNumber().longValue());
                            "value",
            .order(org.opensearch.search.aggregations.BucketOrder.aggregation("max_value", true))
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            new PluginInfo(
        assertEquals(18, buckets.get(1).getDocCount());
            .addAggregation(agg)
            .put("index.merge.enabled", false)
            assertEquals(3, buckets.size());
 * The OpenSearch Contributors require contributions made to
            .setSize(0)
        assertEquals(90, resp.getHits().getTotalHits().value());
            client().admin().indices().refresh(new RefreshRequest("numeric_order_test")).actionGet();
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value1", "field2", 11, "field3", "type2"));
        assertEquals(30, bucket1.getDocCount());
            "{\"properties\":{\"category\":{\"type\":\"integer\"},\"value\":{\"type\":\"integer\"},\"user_id\":{\"type\":\"keyword\"}}}",
        super.setUp();
        assertEquals("value3", bucket3.getKeyAsString());
        // Segment 1 - we'll add docs with field2 values in 1-3 range, field3 values type1-3
        assertEquals(800.0, ((Max) buckets.get(2).getAggregations().get("max_value")).getValue(), 0.001);
        assertEquals(9L, buckets.get(0).getKeyAsNumber().longValue());
                int uniqueUsers = (i + 1) * 2;
        );
                + "    \"field3\": { \"type\": \"keyword\" }\n"
        assertEquals(NUM_SHARDS, resp.getTotalShards());
        SearchResponse resp = future.actionGet();
                    .put("search.aggregations.streaming.min_estimated_bucket_count", 1000) // Very high minimum
                null,
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            .setProfile(true)
        );
        // This test validates numeric streaming aggregation with profile to verify streaming is used
    }
import org.opensearch.search.aggregations.bucket.terms.StreamNumericTermsAggregator;
                Settings.builder()
            List<ProfileResult> aggProfileResults = shardProfile.getAggregationProfileResults().getProfileResults();
        assertEquals(16, buckets.get(2).getDocCount());
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value3", "field2", 3, "field3", "type1"));
        }
        assertEquals(3, buckets.size());
            .put("index.search.concurrent_segment_search.mode", "none")
        assertEquals(200.0, ((Max) buckets.get(1).getAggregations().get("max_value")).getValue(), 0.001);
        assertEquals(200.0, ((Max) buckets.get(1).getAggregations().get("max_value")).getValue(), 0.001);
                    .putNull("search.aggregations.streaming.min_estimated_bucket_count")
        // Use existsQuery to avoid match-all optimization that would disable streaming
        segmentResponse.getIndices().get("index").getShards().values().forEach(indexShardSegments -> {
                    found = true;
        }
        assertEquals(16, buckets.get(2).getDocCount());
    @LockFeatureFlag(STREAM_TRANSPORT)
import org.opensearch.Version;
        assertEquals(NUM_SHARDS, resp.getTotalShards());
        assertAggregatorUsed(resp, StreamNumericTermsAggregator.class);
        assertEquals(NUM_SHARDS, resp.getTotalShards());
            Cardinality cardinalitySubAgg = bucket.getAggregations().get("cardinality_subagg");
    @Override
                + "  }\n"
            .setSize(0)
import org.opensearch.search.profile.ProfileResult;
            .order(org.opensearch.search.aggregations.BucketOrder.aggregation("max_value", false))
            .addAggregation(agg)
        client().admin().indices().create(orderIndexRequest).actionGet();
                        )
            client().admin()
            .execute()
    public void tearDown() throws Exception {
        assertEquals(20, buckets.get(0).getDocCount());
        assertEquals("cat_5", buckets.get(4).getKeyAsString());
            .execute();
        // We'll create 3 segments per shard by indexing docs into each segment and forcing a flush
        assertEquals("cat_6", buckets.get(3).getKeyAsString());
        assertAggregatorUsed(resp, StreamNumericTermsAggregator.class);
        assertEquals("cat_8", buckets.get(1).getKeyAsString());
            .addAggregation(agg)
            .prepareUpdateSettings()
        }
    static final int MAX_BUCKET_COUNT = 100000;
        assertEquals(300.0, ((Max) buckets.get(2).getAggregations().get("max_value")).getValue(), 0.001);
        List<StringTerms.Bucket> buckets = termsAgg.getBuckets();
import java.util.Arrays;
    public void testNumericNoSortOrderWithSubAgg() throws Exception {
            .setSize(0)
        assertEquals("value2", bucket2.getKeyAsString());
 *
        TermsAggregationBuilder agg = terms("categories").field("category")
        assertEquals(NUM_SHARDS, resp.getTotalShards());
            .setQuery(existsQuery("field1"))
        assertEquals("cat_7", buckets.get(2).getKeyAsString());
        boolean found = false;
        List<LongTerms.Bucket> buckets = termsAgg.getBuckets();
                Version.CURRENT,
    public static Collection<Object[]> parameters() {
            .execute()
        for (int seg = 0; seg < 3; seg++) {
            .setWaitForGreenStatus()
        assertEquals(90, resp.getHits().getTotalHits().value());
import org.opensearch.test.OpenSearchIntegTestCase;
    @Override
    }
            XContentType.JSON
                        .put("search.aggregations.streaming.min_cardinality_ratio", 0.001)
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("index").settings(indexSettings);
            .actionGet();
        assertEquals(9L, buckets.get(0).getKeyAsNumber().longValue());
    @LockFeatureFlag(STREAM_TRANSPORT)
                cardinalitySubAgg.getValue() >= 2 && cardinalitySubAgg.getValue() <= 4
            .setQuery(existsQuery("category"))
    static final int MIN_SEGMENTS_PER_SHARD = 3;
        assertEquals(900.0, ((Max) buckets.get(1).getAggregations().get("max_value")).getValue(), 0.001);
        StringTerms agg1 = (StringTerms) resp.getAggregations().asMap().get("agg1");
            .setTransientSettings(
        TermsAggregationBuilder agg = terms("agg1").field("field1").subAggregation(AggregationBuilders.max("agg2").field("field2"));
            .subAggregation(AggregationBuilders.cardinality("unique_users").field("user_id"));
import org.opensearch.search.aggregations.AggregationBuilders;
                int uniqueUsers = (i + 1) * 2;
        assertEquals("cat_9", buckets.get(0).getKeyAsString());
            assertFalse(orderBulkResponse.hasFailures());
            .actionGet();
        }
            );
        assertEquals("cat_7", buckets.get(2).getKeyAsString());
        TermsAggregationBuilder agg = terms("agg1").field("field1");
                }
            "{\"properties\":{\"category\":{\"type\":\"keyword\"},\"value\":{\"type\":\"integer\"},\"user_id\":{\"type\":\"keyword\"}}}",
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
        }
        assertEquals(9, buckets.size()); // 9 unique numeric values
        }
import org.opensearch.action.admin.indices.flush.FlushRequest;
import org.opensearch.common.action.ActionFuture;
        bulkResponse = client().bulk(bulkRequest).actionGet();
            .order(org.opensearch.search.aggregations.BucketOrder.aggregation("unique_users", false))
    public void testStreamingAggregationUsed() throws Exception {
        StringTerms termsAgg = resp.getAggregations().get("terms_agg");
        assertAggregatorUsed(resp, StreamStringTermsAggregator.class);
        assertEquals("cat_8", buckets.get(1).getKeyAsString());
            .execute();
import org.opensearch.search.SearchHit;
        assertEquals(5L, buckets.get(4).getKeyAsNumber().longValue());
            .build();
            .setQuery(existsQuery("category"))
        TermsAggregationBuilder agg = terms("categories").field("category")
            .put("index.number_of_replicas", 0)  // Number of replica shards
            .actionGet();
        );
package org.opensearch.streaming.aggregation;
    }
                + "}",
        return Arrays.asList(
            }
            .execute()
        client().admin().indices().refresh(new RefreshRequest("index")).actionGet();
            .execute()
        // Validate that streaming aggregation was actually used
            .cluster()
            assertEquals(NUM_SHARDS, resp.getTotalShards());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        SearchResponse resp = client().prepareStreamSearch("numeric_order_test")
        // Use existsQuery to avoid match-all optimization that would disable streaming
        client().admin()
        StringTerms.Bucket bucket3 = buckets.get(2);
        assertEquals(3, buckets.size());
import org.opensearch.common.unit.TimeValue;
            .get();
            BulkResponse orderBulkResponse = client().bulk(orderBulkRequest).actionGet();
    @LockFeatureFlag(STREAM_TRANSPORT)
                            (i + 1) * 100,
                            i,
        try {
        super(dynamicSettings);
            .addAggregation(agg)
            List<StringTerms.Bucket> buckets = agg1.getBuckets();
                    .putNull("search.aggregations.streaming.min_cardinality_ratio")
            .setTimeout(TimeValue.timeValueSeconds(30))
        ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")
            .addAggregation(agg)
                for (int j = 0; j < docsPerSegment; j++) {
        SearchResponse resp = client().prepareStreamSearch("numeric_order_test")
                int docsPerSegment = uniqueUsers / 3 + (seg < uniqueUsers % 3 ? 1 : 0);
    }
                "1.8",
    public SubAggregationIT(Settings dynamicSettings) {
        TermsAggregationBuilder agg = terms("categories").field("category")
        List<LongTerms.Bucket> buckets = termsAgg.getBuckets();
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value1", "field2", 21, "field3", "type3"));
        buckets.sort(Comparator.comparingLong(b -> b.getKeyAsNumber().longValue()));
        StringTerms.Bucket bucket1 = buckets.get(0);
    @ParametersFactory
            .setSize(0)
    }
            .setProfile(true)
import org.opensearch.plugins.PluginInfo;
        return List.of(
        }
    }
        TermsAggregationBuilder agg = terms("categories").field("category")
        return Arrays.asList(ArrowBasePlugin.class, InternalSettingsPlugin.class);
        client().admin().indices().create(numericOrderIndexRequest).actionGet();
                .get();
                for (int j = 0; j < docsPerSegment; j++) {
        }
                if (expectedAggregatorClass.getSimpleName().equals(profileResult.getQueryName())) {
            .cluster()
            .addAggregation(agg)
            .actionGet();
            .setSize(0)
    @LockFeatureFlag(STREAM_TRANSPORT)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            for (int i = 0; i < 10; i++) {
                            "category",
            .setProfile(true)
                    .put("search.aggregations.streaming.min_cardinality_ratio", 0.9) // Very high ratio
        }
            .subAggregation(AggregationBuilders.cardinality("unique_users").field("user_id"));
                            (i + 1) * 100,
        // Segment 2 - we'll add docs with field2 values in 11-13 range, field3 values type4-6
        List<StringTerms.Bucket> buckets = termsAgg.getBuckets();
    public void testStreamingCardinalityAsSubAggregation() throws Exception {
                + "  \"properties\": {\n"
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
    public void testOrderByMaxSubAggregationAscending() throws Exception {
        // Verify ordered by doc count DESC
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value1", "field2", 1, "field3", "type1"));
            .setRequestCache(false)
                    .put("search.aggregations.streaming.max_estimated_bucket_count", 1) // Very low limit
        );
        SearchResponse resp = future.actionGet();
            client().admin().indices().flush(new FlushRequest("order_test").force(true)).actionGet();
 */
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                .cluster()
        SearchResponse resp = future.actionGet();
        assertEquals(3, buckets.size());
                    .build()
        assertEquals(NUM_SHARDS, segmentResponse.getIndices().get("index").getShards().size());
        TermsAggregationBuilder agg = terms("agg1").field("field2").subAggregation(AggregationBuilders.max("agg2").field("field2"));
        assertEquals(5, buckets.size());
                )
        for (SearchHit hit : resp.getHits().getHits()) {
        buckets.sort(Comparator.comparing(StringTerms.Bucket::getKeyAsString));
    public void testStreamingAggregationTerm() throws Exception {
        assertEquals("cat_9", buckets.get(0).getKeyAsString());
    }
                        )
            .addAggregation(agg)
    @LockFeatureFlag(STREAM_TRANSPORT)
public class SubAggregationIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
            .execute();
                Settings.builder()
import org.opensearch.search.aggregations.metrics.Max;
            .size(3)
                int docsPerSegment = uniqueUsers / 3 + (seg < uniqueUsers % 3 ? 1 : 0);
        bulkRequest = new BulkRequest();
                        .put("search.aggregations.streaming.max_estimated_bucket_count", MAX_BUCKET_COUNT)
        // Create numeric_order_test index for numeric field sub-aggregation ordering tests
            ActionFuture<SearchResponse> future = client().prepareStreamSearch("index")
            .put("index.search.concurrent_segment_search.mode", "none")
                            "category",
    }
        // This test validates streaming aggregation with 3 shards, each with at least 3 segments
        assertEquals(5, buckets.size());
            .size(5)
    static final int NUM_SHARDS = 3;
                "classpath plugin",
        assertEquals(100.0, ((Max) buckets.get(0).getAggregations().get("max_value")).getValue(), 0.001);
            .setRequestCache(false)
    }
    }
            .setProfile(true)
            BulkResponse numericBulkResponse = client().bulk(numericBulkRequest).actionGet();
            .get();
            assertTrue("Bucket should have at least 1 document", bucket.getDocCount() > 0);
        for (StringTerms.Bucket bucket : buckets) {
        client().admin().indices().refresh(new RefreshRequest("index")).actionGet();
            Max maxAgg = bucket.getAggregations().get("agg2");
            LongTerms.Bucket bucket = buckets.get(i);
        assertEquals(7L, buckets.get(2).getKeyAsNumber().longValue());
            .addAggregation(agg)
                + "    \"field1\": { \"type\": \"keyword\" },\n"
        assertFalse(bulkResponse.hasFailures()); // Verify ingestion was successful
        List<LongTerms.Bucket> buckets = agg1.getBuckets();
            .setTransientSettings(
                + "    \"field2\": { \"type\": \"integer\" },\n"
            .setProfile(true)
    public void testStreamingNumericAggregation() throws Exception {
        assertEquals(9L, buckets.get(0).getKeyAsNumber().longValue());
        TermsAggregationBuilder agg = terms("categories").field("category")
                    + indexShardSegments.getShards()[0].getSegments().size(),
        assertNotNull(resp);
        assertAggregatorUsed(resp, StreamStringTermsAggregator.class);
                            XContentType.JSON,
            .subAggregation(AggregationBuilders.cardinality("cardinality_subagg").field("field3").precisionThreshold(1000));
        assertEquals(90, resp.getHits().getTotalHits().value());
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value2", "field2", 2, "field3", "type1"));
    @LockFeatureFlag(STREAM_TRANSPORT)
                            "user_id",
        SearchResponse resp = future.actionGet();
        buckets.sort(Comparator.comparing(StringTerms.Bucket::getKeyAsString));
        for (int i = 0; i < 10; i++) {
            );
            assertTrue(
        assertEquals(3, buckets.size());
        LongTerms termsAgg = resp.getAggregations().get("categories");
            XContentType.JSON
            .setProfile(true)
        assertEquals("cat_2", buckets.get(2).getKeyAsString());
            assertEquals(expectedValues[i], maxAgg.getValue(), 0.001);
 * compatible open source license.
            .size(3)
        SearchResponse resp = client().prepareStreamSearch("order_test")
    private void assertAggregatorUsed(SearchResponse resp, Class<?> expectedAggregatorClass) {
        assertEquals(3, buckets.size());
        assertEquals("cat_0", buckets.get(0).getKeyAsString());
            assertNotNull(cardinalitySubAgg);
            .put("index.merge.enabled", false) // Disable merges to keep individual segments
        SearchResponse resp = client().prepareStreamSearch("order_test")
                    .build()
            )
        TermsAggregationBuilder agg = terms("categories").field("category")
    }
        });
    public void testNumericOrderByMaxSubAggregationDescending() throws Exception {
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
                .setProfile(true)
            .execute()
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.bulk.BulkRequest;
        List<StringTerms.Bucket> buckets = termsAgg.getBuckets();
                .setTransientSettings(
        assertEquals(NUM_SHARDS, resp.getTotalShards());
        assertEquals(30, bucket3.getDocCount());
        List<StringTerms.Bucket> buckets = termsAgg.getBuckets();
        client().admin().cluster().prepareHealth("order_test").setWaitForGreenStatus().setTimeout(TimeValue.timeValueSeconds(30)).get();
        assertEquals(1000.0, ((Max) buckets.get(0).getAggregations().get("max_value")).getValue(), 0.001);
            .size(5)
            .setRequestCache(false)
        Settings orderIndexSettings = Settings.builder()
        }
                indexShardSegments.getShards()[0].getSegments().size() >= MIN_SEGMENTS_PER_SHARD
        assertEquals(8L, buckets.get(1).getKeyAsNumber().longValue());
import org.opensearch.search.aggregations.bucket.terms.GlobalOrdinalsStringTermsAggregator;
            for (int i = 0; i < 10; i++) {
            .subAggregation(AggregationBuilders.max("max_value").field("value"));
            assertNotNull(maxAgg);
            bulkRequest.add(new IndexRequest("index").source(XContentType.JSON, "field1", "value2", "field2", 22, "field3", "type3"));
            .setSize(0)
        assertNotNull(resp);
        long[] expectedValues = { 1, 2, 3, 11, 12, 13, 21, 22, 23 };
            )
        StringTerms termsAgg = resp.getAggregations().get("categories");
        client().admin().indices().refresh(new RefreshRequest("index")).actionGet();
        assertEquals("cat_8", buckets.get(1).getKeyAsString());
        // Create order_test index for string field sub-aggregation ordering tests
        orderIndexRequest.mapping(
        assertEquals(1000.0, ((Max) buckets.get(0).getAggregations().get("max_value")).getValue(), 0.001);
        List<StringTerms.Bucket> buckets = agg1.getBuckets();
        assertEquals(90, resp.getHits().getTotalHits().value());
                    break;
            .order(org.opensearch.search.aggregations.BucketOrder.aggregation("max_value", true))
            // Each field1 value appears with exactly 3 field3 values
            .setRequestCache(false)
    public void testStreamingAggregationNotUsedWithRestrictiveLimits() throws Exception {
    }
        assertEquals(12, buckets.get(4).getDocCount());
                    .putNull("search.aggregations.streaming.max_estimated_bucket_count")
        } finally {
        for (int seg = 0; seg < 3; seg++) {
        assertEquals(6L, buckets.get(3).getKeyAsNumber().longValue());
                FlightStreamPlugin.class.getName(),
        assertEquals(NUM_SHARDS, resp.getTotalShards());
        CreateIndexResponse createIndexResponse = client().admin().indices().create(createIndexRequest).actionGet();
                            "user_" + (i * 100 + seg * 100 + j)
                    .put("search.aggregations.streaming.min_cardinality_ratio", 0.001)
        // Verify each shard has at least MIN_SEGMENTS_PER_SHARD segments
        assertNotNull(resp);
        numericOrderIndexRequest.mapping(
            assertEquals(30, bucket.getDocCount());
        assertEquals(8L, buckets.get(1).getKeyAsNumber().longValue());
    }
            .execute(); // No profile
            .prepareUpdateSettings()
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            .addAggregation(agg)
        List<StringTerms.Bucket> buckets = agg1.getBuckets();
            assertTrue(
        // Default order: by doc count DESC, then by key ASC
        client().admin().indices().flush(new FlushRequest("index").force(true)).actionGet();
                    );
        assertEquals(900.0, ((Max) buckets.get(1).getAggregations().get("max_value")).getValue(), 0.001);
        StringTerms termsAgg = resp.getAggregations().get("categories");
            if (found) break;
        bulkRequest = new BulkRequest();
                            "user_" + (i * 100 + seg * 100 + j)
        assertAggregatorUsed(resp, StreamStringTermsAggregator.class);
        TermsAggregationBuilder agg = terms("terms_agg").field("field1")

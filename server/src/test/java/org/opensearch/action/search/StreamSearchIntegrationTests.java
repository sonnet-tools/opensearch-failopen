import org.opensearch.common.settings.Settings;
            );
        assertNotNull("Aggregations should not be null", response.getAggregations());
        // Keep the low-cardinality test data eligible for streaming aggregation.
            switch (bucket.getKeyAsString()) {
        assertEquals("Should have 90 total hits", 90, response.getHits().getTotalHits().value());
            Tracer tracer
    }
    }
        SearchHits hits = response.getHits();
        assertEquals("Should have 3 term buckets", 3, termsResult.getBuckets().size());
import org.opensearch.plugins.Plugin;
        client().admin().cluster().prepareHealth(TEST_INDEX).setWaitForGreenStatus().setTimeout(TimeValue.timeValueSeconds(30)).get();
import org.opensearch.common.network.NetworkService;
                    break;
                    + " segments but found "
        assertNotNull("Response hits should not be null", response.getHits());
import org.opensearch.search.SearchHits;
                    assertEquals(expectedMinMsg, 2.0, minAgg.getValue(), 0.001);
        StringTerms termsResult = response.getAggregations().get("field1_terms");
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
        SearchResponse response = client().execute(StreamSearchAction.INSTANCE, searchRequest).actionGet();
            .prepareHealth(NESTED_TERMS_INDEX)
                    break;
        }
                    pageCacheRecycler,
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
            .put("index.search.concurrent_segment_search.mode", "none")
            assertEquals("Each bucket should have 30 documents", 30, bucket.getDocCount());
            NetworkService networkService,
        BulkRequest bulkRequest = new BulkRequest();
        // Each bucket should have 30 documents (10 from each segment)
            PageCacheRecycler pageCacheRecycler,
        assertNotNull("Response should not be null for successful streaming aggregation", response);
import org.opensearch.search.SearchHit;
     * Test that StreamSearchAction works correctly with streaming transport.
                    namedWriteableRegistry,
            ThreadPool threadPool,
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
        assertNotNull("Terms aggregation should be present", termsResult);
                () -> new MockStreamingTransport(
/*
            .setTimeout(TimeValue.timeValueSeconds(30))
            List<ProfileResult> profiles = aggregationProfile.getProfileResults();
                + "    \"category\": { \"type\": \"keyword\" }\n"
        }
        assertEquals("Should have 3 term buckets", 3, termsResult.getBuckets().size());
        assertNotNull(parent0);
            );
            // Expected sum values: value1=330, value2=360, value3=390
            // value1: 10*1 + 10*11 + 10*21 = 10 + 110 + 210 = 330
                    circuitBreakerService,
                    break;
            org.opensearch.search.aggregations.metrics.Sum sumAgg = bucket.getAggregations().get("field2_sum");
        assertEquals("Should have 3 term buckets", 3, termsResult.getBuckets().size());
import org.opensearch.action.admin.indices.flush.FlushRequest;
            .put("index.merge.policy.max_merged_segment", "1kb") // Keep segments small
import java.util.Collections;
        assertNotNull("Response should not be null for successful streaming aggregation", response);
            .put("index.number_of_replicas", 0)
        StringTerms termsResult = response.getAggregations().get("field1_terms");
        // Create 3 segments by indexing docs into each segment and forcing a flush
                "FLIGHT",
import org.opensearch.action.index.IndexRequest;
    // with the real FlightStreamPlugin the stack would inject.
    }
    /**
        searchRequest.searchType(SearchType.QUERY_THEN_FETCH);
 */
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            .field("parent")
        }
            bulkRequest.add(
        searchRequest.source().query(QueryBuilders.matchAllQuery()).aggregation(termsAgg).size(0);
import java.io.IOException;
        createTestIndex();
 * compatible open source license.
        // Validate aggregation results must be present
            assertNotNull("Sum sub-aggregation should be present", sumAgg);
        assertEquals("Should have 90 total hits", 90, response.getHits().getTotalHits().value());
            assertNotNull("Min sub-aggregation should be present", minAgg);
            assertEquals("StreamStringTermsAggregator", profiles.get(0).getQueryName());
    private void createTestIndex() {
        for (ProfileShardResult profileShardResult : response.getProfileResults().values()) {
import java.util.List;
        // Verify successful response
            XContentType.JSON
            String expectedSumMsg = "Sum value for " + bucket.getKeyAsString();
        bulkRequest.add(new IndexRequest(NESTED_TERMS_INDEX).source(XContentType.JSON, "parent", "parent1", "child", "cherry"));
    public static class MockStreamTransportPlugin extends Plugin implements NetworkPlugin {
            bulkRequest.add(
        assertNotNull("Response hits should not be null", response.getHits());
        assertEquals(1, parent0Children.getBuckets().size());
        assertNull(parent0Children.getBucketByKey("cherry"));
                    tracer
        assertEquals("Should have 3 term buckets", 3, termsResult.getBuckets().size());
            .setWaitForGreenStatus()
    @LockFeatureFlag(STREAM_TRANSPORT)
    protected boolean installSandboxPlugins() {
        // Verify that we have the expected number of shards and segments
    @LockFeatureFlag(STREAM_TRANSPORT)
                    break;
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        // Should have 3 buckets: value1, value2, value3
            assertEquals("StreamStringTermsAggregator", profiles.get(0).getProfiledChildren().get(0).getQueryName());
        for (int i = 0; i < 10; i++) {
            switch (bucket.getKeyAsString()) {
        // Segment 2 - add docs with field2 values in 11-13 range
                    assertEquals(expectedMaxMsg, 23.0, maxAgg.getValue(), 0.001);
            .build();
    @Before
 * - SearchStreamActionListener
                case "value2":
        assertNull(parent0Children.getBucketByKey("banana"));
                    assertEquals(expectedMinMsg, 3.0, minAgg.getValue(), 0.001);
    // Opt out of the sandbox stack: this test registers its own mock stream transport named "FLIGHT", which collides
import org.opensearch.common.util.PageCacheRecycler;
        for (StringTerms.Bucket bucket : termsResult.getBuckets()) {
        TermsAggregationBuilder termsAgg = AggregationBuilders.terms("field1_terms")
        // Validate aggregation results must be present
        }
            InetSocketAddress address = node.getStreamAddress().address();
        assertEquals(3, parent1.getDocCount());
        // Should have 3 buckets: value1, value2, value3
            XContentType.JSON
                case "value3":
    // This provides the sendResponseBatch functionality needed for streaming search tests
            assertEquals(1, profiles.get(0).getProfiledChildren().size());
        assertNotNull(response.getAggregations());
            assertNotNull("Hit should have source", hit.getSourceAsMap());
        StringTerms parent0Children = parent0.getAggregations().get("children");
        assertEquals("Should have 90 total hits", 90, response.getHits().getTotalHits().value());
            .field("field1")
            String expectedMinMsg = "Min value for " + bucket.getKeyAsString();
            bulkRequest.add(
        CreateIndexResponse createIndexResponse = client().admin().indices().create(createIndexRequest).actionGet();
        assertNotNull(response.getProfileResults());
            Settings settings,
import java.net.InetSocketAddress;
        assertNotNull("Response should not be null for successful streaming aggregation", response);
        assertFalse(bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
        Settings indexSettings = Settings.builder()
                    break;
        assertEquals("Should have 90 total hits", 90, response.getHits().getTotalHits().value());
        for (int i = 0; i < 10; i++) {
            Max maxAgg = bucket.getAggregations().get("field2_max");
import java.util.Collection;
        ) {
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        bulkRequest = new BulkRequest();
 * - StreamTransportSearchAction
        StringTerms termsResult = response.getAggregations().get("field1_terms");
            PageCacheRecycler pageCacheRecycler,
        TermsAggregationBuilder termsAgg = AggregationBuilders.terms("field1_terms").field("field1");
            // Expected min values: value1=1, value2=2, value3=3 (from segment 1)
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value2", "field2", 22, "number", i + 71, "category", "B")
                    settings,
            NamedWriteableRegistry namedWriteableRegistry,
        assertNotNull("Response hits should not be null", response.getHits());
        assertEquals(NUM_SHARDS, segmentResponse.getIndices().get(TEST_INDEX).getShards().size());
            );
        assertEquals(3, parent0Children.getBucketByKey("apple").getDocCount());
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value2", "field2", 12, "number", i + 41, "category", "A")
            .subAggregation(AggregationBuilders.terms("children").field("child"));
        client().admin().indices().flush(new FlushRequest(NESTED_TERMS_INDEX).force(true)).actionGet();
import org.opensearch.transport.nio.MockStreamNioTransport;
import org.opensearch.search.profile.ProfileShardResult;
            super(settings, version, threadPool, networkService, pageCacheRecycler, namedWriteableRegistry, circuitBreakerService, tracer);
                    Version.CURRENT,
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
    @LockFeatureFlag(STREAM_TRANSPORT)
            // value3: 10*3 + 10*13 + 10*23 = 30 + 130 + 230 = 390
            return Collections.singletonMap(
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            assertTrue("Bucket key should be value1, value2, or value3", bucket.getKeyAsString().matches("value[123]"));
                case "value2":
        }
        super.setUp();
                )
                case "value1":
                + "    \"number\": { \"type\": \"integer\" },\n"
            .put("index.merge.scheduler.max_thread_count", "1") // Limit merge threads
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    protected Collection<Class<? extends Plugin>> getPlugins() {
            bulkRequest.add(
    }
            Tracer tracer
        }
            );
    private static class MockStreamingTransport extends MockStreamNioTransport {
            assertEquals("Each bucket should have 30 documents", 30, bucket.getDocCount());
            assertNotNull("Max sub-aggregation should be present", maxAgg);
                    + indexShardSegments.getShards()[0].getSegments().size(),
    }
        }
        // Each bucket should have 30 documents (10 from each segment)
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value2", "field2", 2, "number", i + 11, "category", "B")
    public void testStreamingNestedTermsScopesChildBucketsByParent() {
            }
        }
        }
        IndicesSegmentResponse segmentResponse = client().admin().indices().segments(new IndicesSegmentsRequest(TEST_INDEX)).actionGet();
            NamedWriteableRegistry namedWriteableRegistry,
        // Should have 3 buckets: value1, value2, value3
            );
import org.opensearch.search.profile.ProfileResult;
                case "value3":
        searchRequest.source().query(QueryBuilders.matchAllQuery()).size(5);
        return Collections.singletonList(MockStreamTransportPlugin.class);
            .put("index.number_of_shards", 1)
        // Verify successful response
        ) {
        for (int i = 0; i < 3; i++) {
            NetworkService networkService,
                    break;
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(TEST_INDEX).settings(indexSettings);
        assertEquals(3, parent0.getDocCount());
        TermsAggregationBuilder parentTerms = AggregationBuilders.terms("parents")
import org.opensearch.index.query.QueryBuilders;
     * 2. MockStreamTransportPlugin provides the required "FLIGHT" transport supplier
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value3", "field2", 13, "number", i + 51, "category", "B")
import org.opensearch.search.profile.aggregation.AggregationProfileShardResult;
        @Override
 * Integration tests for streaming search functionality.
public class StreamSearchIntegrationTests extends OpenSearchSingleNodeTestCase {
        assertNotNull("Terms aggregation should be present", termsResult);
        SearchResponse response = client().execute(StreamSearchAction.INSTANCE, searchRequest).actionGet();
     * 1. Node starts successfully with STREAM_TRANSPORT feature flag enabled
    @LockFeatureFlag(STREAM_TRANSPORT)
            bulkRequest.add(
        createIndexRequest.mapping(
                case "value1":
        assertNotNull("Aggregations should not be null", response.getAggregations());
        createIndexRequest.mapping(
                    assertEquals(expectedMaxMsg, 22.0, maxAgg.getValue(), 0.001);
        SearchResponse response = client().execute(StreamSearchAction.INSTANCE, searchRequest).actionGet();
                    networkService,
    @Override
        assertNotNull("Aggregations should not be null", response.getAggregations());
            "{\"properties\":{\"parent\":{\"type\":\"keyword\"},\"child\":{\"type\":\"keyword\"}}}",
    // Use MockStreamNioTransport which supports streaming transport channels
            ThreadPool threadPool,
        searchRequest.source().aggregation(termsAgg).size(0);
import org.opensearch.common.xcontent.XContentType;
        assertEquals(2, parent1Children.getBuckets().size());
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value1", "field2", 11, "number", i + 31, "category", "B")
            .put(FlushModeResolver.STREAMING_AGGREGATION_MIN_SEGMENT_SIZE_SETTING.getKey(), 1)
 * - StreamSearchQueryThenFetchAsyncAction
        SearchRequest searchRequest = new SearchRequest(TEST_INDEX);
    public void testStreamingAggregationWithSumSubAgg() {
import org.opensearch.action.bulk.BulkResponse;
        // Verify each shard has at least MIN_SEGMENTS_PER_SHARD segments
        StringTerms termsResult = response.getAggregations().get("field1_terms");
        assertEquals(6, response.getHits().getTotalHits().value());
            }
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value3", "field2", 3, "number", i + 21, "category", "A")
            // Check max sub-aggregation
        // Segment 3 - add docs with field2 values in 21-23 range
        bulkResponse = client().bulk(bulkRequest).actionGet();
    }
        TermsAggregationBuilder termsAgg = AggregationBuilders.terms("field1_terms")
        assertFalse(bulkResponse.hasFailures()); // Verify ingestion was successful
            );
            assertEquals("Each bucket should have 30 documents", 30, bucket.getDocCount());
        client().admin().indices().refresh(new RefreshRequest(NESTED_TERMS_INDEX)).actionGet();
        assertNotNull("Response hits should not be null", response.getHits());
                + "  }\n"
        @Override
        return Settings.builder().put(super.nodeSettings()).put(FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT.getKey(), 1).build();
        // Verify response structure
        });
        // Validate aggregation results must be present
        return false;
    }
        for (StringTerms.Bucket bucket : termsResult.getBuckets()) {
import org.opensearch.action.bulk.BulkRequest;
            Settings settings,
        bulkRequest = new BulkRequest();
        assertTrue("Should have search hits", response.getHits().getTotalHits().value() > 0);
    }
            .field("field1")
        assertNotNull(parents);
    public void setUp() throws Exception {
            .build();
        assertEquals(2, parents.getBuckets().size());
            bulkRequest.add(
            "{\n"
            .cluster()
                    assertEquals(expectedSumMsg, 390.0, sumAgg.getValue(), 0.001);
    @LockFeatureFlag(STREAM_TRANSPORT)
            CircuitBreakerService circuitBreakerService,
                    threadPool,
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value1", "field2", 1, "number", i + 1, "category", "A")
        StringTerms parents = response.getAggregations().get("parents");
        SearchRequest searchRequest = new SearchRequest(TEST_INDEX);
        // Segment 1 - add docs with field2 values in 1-3 range
 * The OpenSearch Contributors require contributions made to
                    assertEquals(expectedSumMsg, 360.0, sumAgg.getValue(), 0.001);
        // Verify successful response
            );
            // Expected max values: value1=21, value2=22, value3=23
package org.opensearch.action.search;
            // Check sum sub-aggregation
            );
        searchRequest.source().query(QueryBuilders.matchAllQuery()).aggregation(termsAgg).size(0);
import org.junit.Before;
            assertTrue(
        // Should have 3 buckets: value1, value2, value3
            Min minAgg = bucket.getAggregations().get("field2_min");
        protected MockSocketChannel initiateChannel(DiscoveryNode node) throws IOException {
        assertEquals("Should return requested number of hits", 5, response.getHits().getHits().length);
            assertTrue("Bucket key should be value1, value2, or value3", bucket.getKeyAsString().matches("value[123]"));
        assertNotNull("Response should not be null for successful streaming terms aggregation", response);
import org.opensearch.common.unit.TimeValue;
import org.opensearch.threadpool.ThreadPool;
    }
 */
        StringTerms parent1Children = parent1.getAggregations().get("children");
            switch (bucket.getKeyAsString()) {
        // Each bucket should have 30 documents
            }
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value1", "field2", 21, "number", i + 61, "category", "A")
            // value2: 10*2 + 10*12 + 10*22 = 20 + 120 + 220 = 360
import org.opensearch.transport.Transport;
            bulkRequest.add(
        }
     * This test verifies that:
        bulkRequest.add(new IndexRequest(NESTED_TERMS_INDEX).source(XContentType.JSON, "parent", "parent1", "child", "banana"));
            assertTrue("Bucket key should be value1, value2, or value3", bucket.getKeyAsString().matches("value[123]"));
        assertNotNull("Response hits should not be null", response.getHits());
    public void testStreamingAggregationWithMinSubAgg() {
            .put("index.number_of_replicas", 0)
    @Override
 *
        }
        client().admin().indices().flush(new FlushRequest(TEST_INDEX).force(true)).actionGet();
        assertNull(parent1Children.getBucketByKey("apple"));
        assertFalse(bulkResponse.hasFailures());
import org.opensearch.search.streaming.FlushModeResolver;
            assertTrue("Hit should contain field1", hit.getSourceAsMap().containsKey("field1"));
import org.opensearch.search.aggregations.metrics.Max;
    @LockFeatureFlag(STREAM_TRANSPORT)
            bulkRequest.add(
     * 4. Search results are returned correctly via streaming transport
        for (int i = 0; i < 10; i++) {
import org.opensearch.Version;
                indexShardSegments.getShards()[0].getSegments().size() >= MIN_SEGMENTS_PER_SHARD
 * - StreamSearchTransportService
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value3", "field2", 23, "number", i + 81, "category", "A")
        );
        SearchRequest searchRequest = new SearchRequest(TEST_INDEX).requestCache(false);
    protected Settings nodeSettings() {
            .put("index.search.concurrent_segment_search.mode", "none")
    public void testBasicStreamingSearchWorkflow() {
        // Validate aggregation results must be present
        for (SearchHit hit : hits.getHits()) {
            .subAggregation(AggregationBuilders.max("field2_max").field("field2"));
                + "    \"field2\": { \"type\": \"integer\" },\n"
                    break;
        client().admin().indices().refresh(new RefreshRequest(TEST_INDEX)).actionGet();
        assertEquals(2, parent1Children.getBucketByKey("banana").getDocCount());
    private static final String TEST_INDEX = "test_streaming_index";
            // Return a mock FLIGHT transport that can handle streaming responses
        );
import org.opensearch.telemetry.tracing.Tracer;
    private static final int NUM_SHARDS = 3;
        SearchResponse response = client().execute(StreamSearchAction.INSTANCE, searchRequest).actionGet();
        StringTerms.Bucket parent0 = parents.getBucketByKey("parent0");
    @Override
        SearchRequest searchRequest = new SearchRequest(TEST_INDEX);
        client().admin().indices().flush(new FlushRequest(TEST_INDEX).force(true)).actionGet();
                    break;
                case "value3":
                    assertEquals(expectedMaxMsg, 21.0, maxAgg.getValue(), 0.001);
        TermsAggregationBuilder termsAgg = AggregationBuilders.terms("field1_terms")
    private static final int MIN_SEGMENTS_PER_SHARD = 3;
        }
            CircuitBreakerService circuitBreakerService,
        }
            Version version,
        // Each bucket should have 30 documents
            String expectedMaxMsg = "Max value for " + bucket.getKeyAsString();
            assertTrue("Hit should contain field2", hit.getSourceAsMap().containsKey("field2"));
        assertTrue(createIndexResponse.isAcknowledged());
 * this file be licensed under the Apache-2.0 license or a
    private static final String NESTED_TERMS_INDEX = "test_streaming_nested_terms_index";
     *
 * SPDX-License-Identifier: Apache-2.0
        // Verify successful response
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
    }
import org.opensearch.plugins.NetworkPlugin;
                    break;
                case "value1":
        searchRequest.source().query(QueryBuilders.existsQuery("parent")).aggregation(parentTerms).profile(true).size(0);
                    + MIN_SEGMENTS_PER_SHARD
        SearchResponse response = client().execute(StreamSearchAction.INSTANCE, searchRequest).actionGet();
        for (StringTerms.Bucket bucket : termsResult.getBuckets()) {
        bulkResponse = client().bulk(bulkRequest).actionGet();
import org.opensearch.cluster.node.DiscoveryNode;
            .subAggregation(AggregationBuilders.sum("field2_sum").field("field2"));
import org.opensearch.search.aggregations.AggregationBuilders;
            bulkRequest.add(
            .put("index.merge.policy.segments_per_tier", "20") // Allow many segments per tier
        searchRequest.source().query(QueryBuilders.matchAllQuery()).aggregation(termsAgg).size(0);
        assertNotNull("Terms aggregation should be present", termsResult);
import org.opensearch.search.aggregations.metrics.Min;
     */
                    assertEquals(expectedSumMsg, 330.0, sumAgg.getValue(), 0.001);
        client().admin().indices().flush(new FlushRequest(TEST_INDEX).force(true)).actionGet();
import java.util.Map;
            return nioGroup.openChannel(address, clientChannelFactory);
}
        SearchResponse response = client().execute(StreamSearchAction.INSTANCE, searchRequest).actionGet();
    }
            );
        SearchRequest searchRequest = new SearchRequest(TEST_INDEX);
        assertFalse(bulkResponse.hasFailures());
        assertNotNull(parent1);
import java.util.function.Supplier;
        assertNotNull("Response should not be null for successful streaming search", response);
 *
            .subAggregation(AggregationBuilders.min("field2_min").field("field2"));
        assertEquals(1, parent1Children.getBucketByKey("cherry").getDocCount());
        bulkRequest.add(new IndexRequest(NESTED_TERMS_INDEX).source(XContentType.JSON, "parent", "parent1", "child", "banana"));
            assertEquals(1, profiles.size());
        assertNotNull("Aggregations should not be null", response.getAggregations());
     * 3. StreamSearchAction executes successfully with proper streaming responses
                + "    \"field1\": { \"type\": \"keyword\" },\n"
        public MockStreamingTransport(
        Settings indexSettings = Settings.builder()
        assertEquals(NUM_SHARDS, response.getTotalShards());
        BulkResponse bulkResponse = client().bulk(bulkRequest).actionGet();
        assertTrue(client().admin().indices().create(createIndexRequest).actionGet().isAcknowledged());
            // Check min sub-aggregation
            AggregationProfileShardResult aggregationProfile = profileShardResult.getAggregationProfileResults();
            .put("index.number_of_shards", NUM_SHARDS)
            );
 * This test suite validates the complete streaming search workflow including:
    public void testStreamingAggregationTermsOnly() {
        client().admin().indices().refresh(new RefreshRequest(TEST_INDEX)).actionGet();
    }
        StringTerms.Bucket parent1 = parents.getBucketByKey("parent1");
            .field("field1")
    }
        client().admin().indices().refresh(new RefreshRequest(TEST_INDEX)).actionGet();
            assertTrue("Bucket key should be value1, value2, or value3", bucket.getKeyAsString().matches("value[123]"));
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(NESTED_TERMS_INDEX).settings(indexSettings);
            assertEquals("Each bucket should have 30 documents", 30, bucket.getDocCount());
        for (StringTerms.Bucket bucket : termsResult.getBuckets()) {
        client().admin().indices().refresh(new RefreshRequest(TEST_INDEX)).actionGet();
                + "  \"properties\": {\n"
            );
        assertNotNull("Terms aggregation should be present", termsResult);
        BulkResponse bulkResponse = client().bulk(bulkRequest).actionGet();
    public void testStreamingAggregationWithSubAgg() {
                + "}",
                    assertEquals(expectedMinMsg, 1.0, minAgg.getValue(), 0.001);
        // Verify successful response
        public Map<String, Supplier<Transport>> getTransports(
/**
        segmentResponse.getIndices().get(TEST_INDEX).getShards().values().forEach(indexShardSegments -> {
            .get();
        client().admin()
            bulkRequest.add(new IndexRequest(NESTED_TERMS_INDEX).source(XContentType.JSON, "parent", "parent0", "child", "apple"));
        BulkRequest bulkRequest = new BulkRequest();
                "Expected at least "
                case "value2":
        SearchRequest searchRequest = new SearchRequest(NESTED_TERMS_INDEX).requestCache(false);

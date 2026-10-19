        TermsAggregationBuilder termsAgg = AggregationBuilders.terms("field1_terms")  
            );  
import org.opensearch.common.unit.TimeValue;
        assertNotNull("Terms aggregation should be present", termsResult);  
        TermsAggregationBuilder termsAgg = AggregationBuilders.terms("field1_terms").field("field1");  
        }  
import org.opensearch.telemetry.tracing.Tracer;  
            // Check sum sub-aggregation
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
            "{\n"
            .field("field1")
            assertNotNull("Hit should have source", hit.getSourceAsMap());
            assertTrue("Bucket key should be value1, value2, or value3", bucket.getKeyAsString().matches("value[123]"));
                    assertEquals(expectedMaxMsg, 21.0, maxAgg.getValue(), 0.001);
        for (SearchHit hit : hits.getHits()) {  
            );  
        StringTerms termsResult = response.getAggregations().get("field1_terms");  
            .get();
            .subAggregation(AggregationBuilders.sum("field2_sum").field("field2"));
        assertNotNull("Response should not be null for successful streaming aggregation", response);  
                case "value1":  
    }
        // Segment 1 - add docs with field2 values in 1-3 range
            }  
            assertEquals("StreamStringTermsAggregator", profiles.get(0).getQueryName());
        // Each bucket should have 30 documents  
        SearchRequest searchRequest = new SearchRequest(TEST_INDEX);
        SearchHits hits = response.getHits();
        @Override  
        // Verify successful response  
            );  
        ) {
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;  
import java.util.List;
    protected Collection<Class<? extends Plugin>> getPlugins() {
    /**
            );  
            PageCacheRecycler pageCacheRecycler,
    public void testStreamingAggregationWithSubAgg() {
            .build();
        }
            bulkRequest.add(
                    assertEquals(expectedMinMsg, 3.0, minAgg.getValue(), 0.001);
            CircuitBreakerService circuitBreakerService,  
    public void testBasicStreamingSearchWorkflow() {  
                () -> new MockStreamingTransport(
        assertNotNull("Terms aggregation should be present", termsResult);
        );
     * 2. MockStreamTransportPlugin provides the required "FLIGHT" transport supplier
import org.opensearch.common.xcontent.XContentType;
        bulkRequest.add(new IndexRequest(NESTED_TERMS_INDEX).source(XContentType.JSON, "parent", "parent1", "child", "banana"));
            .put(FlushModeResolver.STREAMING_AGGREGATION_MIN_SEGMENT_SIZE_SETTING.getKey(), 1)  
        // Validate aggregation results must be present
import org.opensearch.search.aggregations.metrics.Max;  
                    assertEquals(expectedMinMsg, 1.0, minAgg.getValue(), 0.001);
        assertEquals("Should have 3 term buckets", 3, termsResult.getBuckets().size());  
            .cluster()  
    public void setUp() throws Exception {
        assertNotNull("Aggregations should not be null", response.getAggregations());
            }  
            .setWaitForGreenStatus()
            );  
        assertEquals(3, parent0.getDocCount());
     * Test that StreamSearchAction works correctly with streaming transport.  
            XContentType.JSON  
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        assertFalse(bulkResponse.hasFailures());  
        assertNotNull("Aggregations should not be null", response.getAggregations());
                    + MIN_SEGMENTS_PER_SHARD
import org.opensearch.action.bulk.BulkResponse;  
        StringTerms termsResult = response.getAggregations().get("field1_terms");
        SearchRequest searchRequest = new SearchRequest(TEST_INDEX);  
            assertEquals(1, profiles.size());
        assertEquals("Should return requested number of hits", 5, response.getHits().getHits().length);
        super.setUp();  
                case "value1":  
        for (int i = 0; i < 3; i++) {
     */
            .prepareHealth(NESTED_TERMS_INDEX)
        searchRequest.source().query(QueryBuilders.existsQuery("parent")).aggregation(parentTerms).profile(true).size(0);
        assertEquals("Should have 90 total hits", 90, response.getHits().getTotalHits().value());
        SearchRequest searchRequest = new SearchRequest(NESTED_TERMS_INDEX).requestCache(false);  
            .put("index.number_of_shards", NUM_SHARDS)  
            );  
        assertNotNull(parent1);
        SearchResponse response = client().execute(StreamSearchAction.INSTANCE, searchRequest).actionGet();  
        client().admin().indices().flush(new FlushRequest(TEST_INDEX).force(true)).actionGet();
                + "    \"field1\": { \"type\": \"keyword\" },\n"  
        assertNotNull("Response should not be null for successful streaming aggregation", response);  
        }  
import org.opensearch.search.profile.ProfileResult;
                    namedWriteableRegistry,
        assertNotNull("Terms aggregation should be present", termsResult);
        }
                )
            Settings settings,  
        assertNull(parent0Children.getBucketByKey("banana"));  
    }
            );  
package org.opensearch.action.search;
        StringTerms termsResult = response.getAggregations().get("field1_terms");  
    public void testStreamingAggregationTermsOnly() {
 * - StreamSearchTransportService
            );  
            bulkRequest.add(
 * Integration tests for streaming search functionality.  
        BulkRequest bulkRequest = new BulkRequest();
            ThreadPool threadPool,
            .build();  
        bulkRequest = new BulkRequest();
        createTestIndex();
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
            assertNotNull("Min sub-aggregation should be present", minAgg);
import org.opensearch.plugins.Plugin;  
        // Segment 3 - add docs with field2 values in 21-23 range
            .field("field1")
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value3", "field2", 13, "number", i + 51, "category", "B")
                + "    \"category\": { \"type\": \"keyword\" }\n"  
        });
            .put("index.number_of_replicas", 0)
import org.opensearch.plugins.NetworkPlugin;
import java.util.Collections;
        assertNotNull("Aggregations should not be null", response.getAggregations());
                    assertEquals(expectedMaxMsg, 23.0, maxAgg.getValue(), 0.001);
                    assertEquals(expectedMaxMsg, 22.0, maxAgg.getValue(), 0.001);
        Settings indexSettings = Settings.builder()
        bulkRequest.add(new IndexRequest(NESTED_TERMS_INDEX).source(XContentType.JSON, "parent", "parent1", "child", "banana"));
            return Collections.singletonMap(  
        assertEquals(6, response.getHits().getTotalHits().value());
        }
        client().admin().indices().refresh(new RefreshRequest(TEST_INDEX)).actionGet();
        // Verify successful response
            switch (bucket.getKeyAsString()) {
            // Return a mock FLIGHT transport that can handle streaming responses
            assertTrue("Hit should contain field1", hit.getSourceAsMap().containsKey("field1"));
            "{\"properties\":{\"parent\":{\"type\":\"keyword\"},\"child\":{\"type\":\"keyword\"}}}",
    public void testStreamingAggregationWithMinSubAgg() {
 */
                    networkService,  
 * The OpenSearch Contributors require contributions made to  
                    tracer
        assertEquals("Should have 90 total hits", 90, response.getHits().getTotalHits().value());
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value2", "field2", 22, "number", i + 71, "category", "B")
                    break;
        assertNotNull("Response hits should not be null", response.getHits());
    }
import org.opensearch.action.bulk.BulkRequest;
import org.opensearch.common.network.NetworkService;  
                    break;
        SearchRequest searchRequest = new SearchRequest(TEST_INDEX);  
     * 4. Search results are returned correctly via streaming transport  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        protected MockSocketChannel initiateChannel(DiscoveryNode node) throws IOException {
                    assertEquals(expectedMinMsg, 2.0, minAgg.getValue(), 0.001);
        searchRequest.source().aggregation(termsAgg).size(0);
        assertNotNull("Terms aggregation should be present", termsResult);
        assertEquals("Should have 90 total hits", 90, response.getHits().getTotalHits().value());
        assertNotNull("Response should not be null for successful streaming aggregation", response);  
        searchRequest.searchType(SearchType.QUERY_THEN_FETCH);  
            Tracer tracer
            Version version,
        assertTrue("Should have search hits", response.getHits().getTotalHits().value() > 0);
        // Segment 2 - add docs with field2 values in 11-13 range
 * - StreamTransportSearchAction  
            .subAggregation(AggregationBuilders.terms("children").field("child"));
                    assertEquals(expectedSumMsg, 360.0, sumAgg.getValue(), 0.001);
        // Each bucket should have 30 documents  
        }
        TermsAggregationBuilder termsAgg = AggregationBuilders.terms("field1_terms")  
/**
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            assertNotNull("Max sub-aggregation should be present", maxAgg);
import org.opensearch.action.admin.indices.flush.FlushRequest;
                    settings,  
        for (int i = 0; i < 10; i++) {  
        SearchRequest searchRequest = new SearchRequest(TEST_INDEX).requestCache(false);
        searchRequest.source().query(QueryBuilders.matchAllQuery()).size(5);
        searchRequest.source().query(QueryBuilders.matchAllQuery()).aggregation(termsAgg).size(0);
            // Expected min values: value1=1, value2=2, value3=3 (from segment 1)  
        client().admin().indices().refresh(new RefreshRequest(TEST_INDEX)).actionGet();
import org.opensearch.search.streaming.FlushModeResolver;
    }  
        client().admin().indices().flush(new FlushRequest(TEST_INDEX).force(true)).actionGet();
            PageCacheRecycler pageCacheRecycler,
        // Validate aggregation results must be present  
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(NESTED_TERMS_INDEX).settings(indexSettings);
 * this file be licensed under the Apache-2.0 license or a
        client().admin().indices().flush(new FlushRequest(NESTED_TERMS_INDEX).force(true)).actionGet();  
        for (StringTerms.Bucket bucket : termsResult.getBuckets()) {
        searchRequest.source().query(QueryBuilders.matchAllQuery()).aggregation(termsAgg).size(0);
    @Override
            switch (bucket.getKeyAsString()) {
        for (int i = 0; i < 10; i++) {  
            assertEquals(1, profiles.get(0).getProfiledChildren().size());  
import java.io.IOException;
            switch (bucket.getKeyAsString()) {
    // Use MockStreamNioTransport which supports streaming transport channels
            Tracer tracer  
import org.junit.Before;
        for (StringTerms.Bucket bucket : termsResult.getBuckets()) {
        TermsAggregationBuilder termsAgg = AggregationBuilders.terms("field1_terms")  
            Settings settings,  
            assertTrue("Bucket key should be value1, value2, or value3", bucket.getKeyAsString().matches("value[123]"));
/*  
            // Expected sum values: value1=330, value2=360, value3=390  
            bulkRequest.add(
        assertFalse(bulkResponse.hasFailures());  
            bulkRequest.add(
        assertEquals("Should have 3 term buckets", 3, termsResult.getBuckets().size());
        // Each bucket should have 30 documents (10 from each segment)  
        }
     * 1. Node starts successfully with STREAM_TRANSPORT feature flag enabled  
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value2", "field2", 2, "number", i + 11, "category", "B")
            .setTimeout(TimeValue.timeValueSeconds(30))  
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value3", "field2", 23, "number", i + 81, "category", "A")
            .subAggregation(AggregationBuilders.max("field2_max").field("field2"));
import org.opensearch.transport.Transport;  
        SearchResponse response = client().execute(StreamSearchAction.INSTANCE, searchRequest).actionGet();  
        assertNotNull("Response hits should not be null", response.getHits());
            bulkRequest.add(
                    break;
        assertEquals(1, parent1Children.getBucketByKey("cherry").getDocCount());  
            .put("index.merge.policy.max_merged_segment", "1kb") // Keep segments small  
 *
    }
            bulkRequest.add(
import org.opensearch.search.SearchHit;
            .put("index.merge.policy.segments_per_tier", "20") // Allow many segments per tier
            org.opensearch.search.aggregations.metrics.Sum sumAgg = bucket.getAggregations().get("field2_sum");  
        public MockStreamingTransport(
        BulkRequest bulkRequest = new BulkRequest();  
            Min minAgg = bucket.getAggregations().get("field2_min");  
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(1, parent0Children.getBuckets().size());
    @LockFeatureFlag(STREAM_TRANSPORT)
        assertNotNull("Response should not be null for successful streaming search", response);
        // Validate aggregation results must be present
        // Keep the low-cardinality test data eligible for streaming aggregation.
        }
                    break;
        // Verify successful response
 *
     *
            // value2: 10*2 + 10*12 + 10*22 = 20 + 120 + 220 = 360
        createIndexRequest.mapping(  
        for (StringTerms.Bucket bucket : termsResult.getBuckets()) {
            assertTrue("Hit should contain field2", hit.getSourceAsMap().containsKey("field2"));  
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value1", "field2", 21, "number", i + 61, "category", "A")
            .put("index.search.concurrent_segment_search.mode", "none")
        // Each bucket should have 30 documents (10 from each segment)
    @LockFeatureFlag(STREAM_TRANSPORT)
                "FLIGHT",
        // Should have 3 buckets: value1, value2, value3  
        assertNotNull(parent0);
        assertEquals(3, parent0Children.getBucketByKey("apple").getDocCount());
            );  
                    break;
 * compatible open source license.
        assertNull(parent0Children.getBucketByKey("cherry"));
            assertEquals("Each bucket should have 30 documents", 30, bucket.getDocCount());  
            .put("index.number_of_shards", 1)  
                case "value3":  
        CreateIndexResponse createIndexResponse = client().admin().indices().create(createIndexRequest).actionGet();
            bulkRequest.add(
        // Verify each shard has at least MIN_SEGMENTS_PER_SHARD segments
        assertNotNull("Response hits should not be null", response.getHits());
                case "value2":  
                    circuitBreakerService,  
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;  
    private static final String NESTED_TERMS_INDEX = "test_streaming_nested_terms_index";
        SearchResponse response = client().execute(StreamSearchAction.INSTANCE, searchRequest).actionGet();  
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(TEST_INDEX).settings(indexSettings);
            return nioGroup.openChannel(address, clientChannelFactory);  
                    break;
        assertNotNull(response.getProfileResults());  
        searchRequest.source().query(QueryBuilders.matchAllQuery()).aggregation(termsAgg).size(0);
    }
                    break;
        assertNotNull(response.getAggregations());
            String expectedMinMsg = "Min value for " + bucket.getKeyAsString();
            NamedWriteableRegistry namedWriteableRegistry,
                case "value1":  
import java.util.Collection;  
        return Collections.singletonList(MockStreamTransportPlugin.class);
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value2", "field2", 12, "number", i + 41, "category", "A")
    public void testStreamingNestedTermsScopesChildBucketsByParent() {
        // Should have 3 buckets: value1, value2, value3  
    public void testStreamingAggregationWithSumSubAgg() {
            Max maxAgg = bucket.getAggregations().get("field2_max");  
import org.opensearch.search.SearchHits;
        assertTrue(client().admin().indices().create(createIndexRequest).actionGet().isAcknowledged());
    @Override  
            InetSocketAddress address = node.getStreamAddress().address();
import org.opensearch.common.settings.Settings;
        client().admin().indices().refresh(new RefreshRequest(TEST_INDEX)).actionGet();
                + "    \"number\": { \"type\": \"integer\" },\n"
        for (ProfileShardResult profileShardResult : response.getProfileResults().values()) {
    private static class MockStreamingTransport extends MockStreamNioTransport {  
import java.util.Map;  
            // value3: 10*3 + 10*13 + 10*23 = 30 + 130 + 230 = 390  
        assertEquals(NUM_SHARDS, response.getTotalShards());  
        SearchResponse response = client().execute(StreamSearchAction.INSTANCE, searchRequest).actionGet();  
        }
        assertEquals(2, parents.getBuckets().size());
        BulkResponse bulkResponse = client().bulk(bulkRequest).actionGet();
    // Opt out of the sandbox stack: this test registers its own mock stream transport named "FLIGHT", which collides
        assertNotNull("Aggregations should not be null", response.getAggregations());
        // Verify that we have the expected number of shards and segments  
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        assertEquals("Should have 3 term buckets", 3, termsResult.getBuckets().size());
            bulkRequest.add(
        TermsAggregationBuilder parentTerms = AggregationBuilders.terms("parents")  
import org.opensearch.threadpool.ThreadPool;
        }
            CircuitBreakerService circuitBreakerService,  
            bulkRequest.add(new IndexRequest(NESTED_TERMS_INDEX).source(XContentType.JSON, "parent", "parent0", "child", "apple"));
                indexShardSegments.getShards()[0].getSegments().size() >= MIN_SEGMENTS_PER_SHARD
        assertNull(parent1Children.getBucketByKey("apple"));
        client().admin()
import org.opensearch.search.profile.ProfileShardResult;  
        IndicesSegmentResponse segmentResponse = client().admin().indices().segments(new IndicesSegmentsRequest(TEST_INDEX)).actionGet();
import org.opensearch.search.profile.aggregation.AggregationProfileShardResult;
        segmentResponse.getIndices().get(TEST_INDEX).getShards().values().forEach(indexShardSegments -> {
        // Should have 3 buckets: value1, value2, value3
        client().admin().indices().refresh(new RefreshRequest(TEST_INDEX)).actionGet();
    @LockFeatureFlag(STREAM_TRANSPORT)  
        SearchResponse response = client().execute(StreamSearchAction.INSTANCE, searchRequest).actionGet();
                    + indexShardSegments.getShards()[0].getSegments().size(),
                + "  }\n"
        assertEquals(NUM_SHARDS, segmentResponse.getIndices().get(TEST_INDEX).getShards().size());
 */  
            XContentType.JSON
    }  
            super(settings, version, threadPool, networkService, pageCacheRecycler, namedWriteableRegistry, circuitBreakerService, tracer);  
        // Create 3 segments by indexing docs into each segment and forcing a flush  
 * - SearchStreamActionListener  
    @Override  
            AggregationProfileShardResult aggregationProfile = profileShardResult.getAggregationProfileResults();
public class StreamSearchIntegrationTests extends OpenSearchSingleNodeTestCase {
        assertFalse(bulkResponse.hasFailures()); // Verify ingestion was successful  
            .field("field1")
        assertNotNull(parents);  
                + "}",
        createIndexRequest.mapping(  
        assertTrue(createIndexResponse.isAcknowledged());  
        bulkRequest.add(new IndexRequest(NESTED_TERMS_INDEX).source(XContentType.JSON, "parent", "parent1", "child", "cherry"));  
        client().admin().indices().refresh(new RefreshRequest(NESTED_TERMS_INDEX)).actionGet();
            NetworkService networkService,  
        }
            .put("index.search.concurrent_segment_search.mode", "none")
     * This test verifies that:
    }
            }  
        assertEquals(2, parent1Children.getBuckets().size());
}  
                case "value3":  
        StringTerms parent1Children = parent1.getAggregations().get("children");  
            );  
            // Check min sub-aggregation
        assertNotNull("Response hits should not be null", response.getHits());  
                + "    \"field2\": { \"type\": \"integer\" },\n"
        SearchRequest searchRequest = new SearchRequest(TEST_INDEX);  
        return false;  
    protected boolean installSandboxPlugins() {
                    Version.CURRENT,
        client().admin().indices().flush(new FlushRequest(TEST_INDEX).force(true)).actionGet();
            assertTrue(  
        // Should have 3 buckets: value1, value2, value3  
            assertTrue("Bucket key should be value1, value2, or value3", bucket.getKeyAsString().matches("value[123]"));
        @Override
        StringTerms parents = response.getAggregations().get("parents");
            // Expected max values: value1=21, value2=22, value3=23  
            NamedWriteableRegistry namedWriteableRegistry,
            .field("parent")
                case "value3":  
                    + " segments but found "  
        assertNotNull("Response hits should not be null", response.getHits());
        StringTerms.Bucket parent0 = parents.getBucketByKey("parent0");  
            NetworkService networkService,
        assertFalse(bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
                    pageCacheRecycler,
    private static final int MIN_SEGMENTS_PER_SHARD = 3;
            bulkRequest.add(
                case "value2":  
 * This test suite validates the complete streaming search workflow including:
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
    @Before
    }
            .put("index.number_of_replicas", 0)
import org.opensearch.search.aggregations.AggregationBuilders;  
        StringTerms termsResult = response.getAggregations().get("field1_terms");  
    protected Settings nodeSettings() {
        assertEquals("Should have 3 term buckets", 3, termsResult.getBuckets().size());
    }
import org.opensearch.search.aggregations.metrics.Min;
        client().admin().cluster().prepareHealth(TEST_INDEX).setWaitForGreenStatus().setTimeout(TimeValue.timeValueSeconds(30)).get();
            assertEquals("Each bucket should have 30 documents", 30, bucket.getDocCount());  
        assertEquals(2, parent1Children.getBucketByKey("banana").getDocCount());
                + "  \"properties\": {\n"
        for (int i = 0; i < 10; i++) {  
import org.opensearch.index.query.QueryBuilders;
        Settings indexSettings = Settings.builder()
import org.opensearch.common.util.PageCacheRecycler;  
    private static final String TEST_INDEX = "test_streaming_index";
    @LockFeatureFlag(STREAM_TRANSPORT)
 * SPDX-License-Identifier: Apache-2.0
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value3", "field2", 3, "number", i + 21, "category", "A")
        StringTerms parent0Children = parent0.getAggregations().get("children");  
                    break;
        // Validate aggregation results must be present
        BulkResponse bulkResponse = client().bulk(bulkRequest).actionGet();
        return Settings.builder().put(super.nodeSettings()).put(FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT.getKey(), 1).build();  
    private static final int NUM_SHARDS = 3;  
    }
            assertEquals("StreamStringTermsAggregator", profiles.get(0).getProfiledChildren().get(0).getQueryName());
    @LockFeatureFlag(STREAM_TRANSPORT)
 * - StreamSearchQueryThenFetchAsyncAction
import org.opensearch.transport.nio.MockStreamNioTransport;
    private void createTestIndex() {
    }
        SearchResponse response = client().execute(StreamSearchAction.INSTANCE, searchRequest).actionGet();
            .subAggregation(AggregationBuilders.min("field2_min").field("field2"));
        bulkResponse = client().bulk(bulkRequest).actionGet();
                case "value2":  
            // value1: 10*1 + 10*11 + 10*21 = 10 + 110 + 210 = 330
import org.opensearch.action.index.IndexRequest;
        // Verify response structure
                    break;
            String expectedMaxMsg = "Max value for " + bucket.getKeyAsString();
        assertEquals(3, parent1.getDocCount());
            assertEquals("Each bucket should have 30 documents", 30, bucket.getDocCount());  
            assertEquals("Each bucket should have 30 documents", 30, bucket.getDocCount());
            List<ProfileResult> profiles = aggregationProfile.getProfileResults();  
                    assertEquals(expectedSumMsg, 390.0, sumAgg.getValue(), 0.001);
        // Verify successful response
    // This provides the sendResponseBatch functionality needed for streaming search tests
        StringTerms.Bucket parent1 = parents.getBucketByKey("parent1");  
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value1", "field2", 11, "number", i + 31, "category", "B")
            String expectedSumMsg = "Sum value for " + bucket.getKeyAsString();
import org.opensearch.Version;
                    assertEquals(expectedSumMsg, 330.0, sumAgg.getValue(), 0.001);
     * 3. StreamSearchAction executes successfully with proper streaming responses
    }
        assertEquals("Should have 90 total hits", 90, response.getHits().getTotalHits().value());
        public Map<String, Supplier<Transport>> getTransports(
        for (StringTerms.Bucket bucket : termsResult.getBuckets()) {  
    // with the real FlightStreamPlugin the stack would inject.  
            .put("index.merge.scheduler.max_thread_count", "1") // Limit merge threads
import java.net.InetSocketAddress;
        // Verify successful response
    public static class MockStreamTransportPlugin extends Plugin implements NetworkPlugin {  
            );  
        ) {
                    threadPool,
        );  
                "Expected at least "
        }
        bulkResponse = client().bulk(bulkRequest).actionGet();
    @LockFeatureFlag(STREAM_TRANSPORT)
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
            ThreadPool threadPool,
            assertNotNull("Sum sub-aggregation should be present", sumAgg);
import java.util.function.Supplier;
        }
            assertTrue("Bucket key should be value1, value2, or value3", bucket.getKeyAsString().matches("value[123]"));
        bulkRequest = new BulkRequest();
        assertNotNull("Response should not be null for successful streaming terms aggregation", response);
                new IndexRequest(TEST_INDEX).source(XContentType.JSON, "field1", "value1", "field2", 1, "number", i + 1, "category", "A")
            // Check max sub-aggregation

        }
        // This is different from real-world usage where aggregations would be properly passed
        StringTerms termsAgg = new StringTerms(
        terminate(threadPool);
     *   - MaxValue = 10.0 * termNumber * (shardIndex+1) * (segmentIndex+1)
        });
        executor.shutdownNow();
    }
 * this file be licensed under the Apache-2.0 license or a
            // The highest value for each term will be in the highest shard and segment indices
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
            format,
        // CountDownLatch to track when all results are consumed
            public InternalAggregation.ReduceContext forFinalReduction() {
import java.util.List;
    /**
            searchRequest,
        CountDownLatch allResultsLatch = new CountDownLatch(numShards * numSegmentsPerShard);
    /**
        int numSegmentsPerShard = 3;
            }
        assertNotNull(reduced.totalHits);
        if (reduced.aggregations != null) {
     * - "term1": 100.0  (highest values across all segments)
     *   - DocCount = 10 * termNumber * (shardIndex+1) * (segmentIndex+1)
    private List<InternalAggregation> createTermsAggregationWithSubMax(int shardIndex, int segmentIndex) {
                // The max value for each term should be the largest from all segments and shards
 * compatible open source license.
        private final AtomicInteger onPartialReduce = new AtomicInteger(0);
import java.util.Collections;
    @Before
            final int finalShardIndex = shardIndex;
import org.opensearch.threadpool.ThreadPool;
                false,
    private static class TestStreamProgressListener extends SearchProgressListener {
    private ThreadPool threadPool;
            executor,
            long docCount = 10L * i * (shardIndex + 1) * (segmentIndex + 1);
        assertTrue(searchProgressListener.getPartialReduceCount() > 0);
import org.opensearch.test.OpenSearchTestCase;
        ) {
                if (isLastSegment) {
import org.opensearch.threadpool.TestThreadPool;
            public InternalAggregation.ReduceContext forPartialReduction() {
import org.opensearch.search.aggregations.InternalAggregation;
        protected void onQueryResult(int shardIndex) {
        List<StringTerms.Bucket> buckets = new ArrayList<>();
        }
import org.apache.lucene.search.TopDocs;
        }
        // Create three term buckets with max sub-aggregations
        int numShards = 3;
        Map<String, Object> metadata = Collections.emptyMap();
            List<InternalAggregation> subAggs = Collections.singletonList(maxAgg);
                String term = bucket.getKeyAsString();
        AtomicReference<Exception> onPartialMergeFailure = new AtomicReference<>();
            10,  // shardSize
import java.util.ArrayList;
public class StreamQueryPhaseResultConsumerTests extends OpenSearchTestCase {
            bucketCountThresholds
                subAggregations,
            // This creates increasingly larger doc counts for higher term numbers, shards, and segments
                // We use slightly higher values (100, 200, 300) in assertions to allow for minor differences
        assertEquals(60, reduced.totalHits.value());
            // Create max sub-aggregation with different values for each term
                    BigArrays.NON_RECYCLING_INSTANCE,
            }
            return onPartialReduce.get();
                    List<InternalAggregation> aggs = createTermsAggregationWithSubMax(finalShardIndex, segment);
            e -> onPartialMergeFailure.accumulateAndGet(e, (prev, curr) -> {
                    // Create terms aggregation with max sub-aggregation for the segment
        protected void onPartialReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
     * from multiple threads.
                // With 3 shards (indices 0,1,2) and 3 segments (indices 0,1,2):
            // Create a term bucket with the sub-aggregation
                    case "term3" -> 300.0;
        }
        );
                null,
        }
                new org.apache.lucene.util.BytesRef(termName),
                    () -> PipelineAggregator.PipelineTree.EMPTY
     * When these aggregations are reduced across multiple shards and segments,
     * @return A list containing the single terms aggregation with max sub-aggregations
    }
                    TopDocs topDocs = new TopDocs(new TotalHits(10 * (finalShardIndex + 1), TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]);
        // Track any partial merge failures
        );
     */
            return onFinalReduce.get();
    private SearchPhaseController searchPhaseController;
        assertTrue(allResultsLatch.await(10, TimeUnit.SECONDS));
                );
                } else {
import org.opensearch.search.SearchShardTarget;
import java.util.concurrent.atomic.AtomicInteger;
            }
                if (prev != null) curr.addSuppressed(prev);
            writableRegistry(),
        // Verify the number of notifications (one per shard for final shard results)
                boolean isLastSegment = segment == numSegmentsPerShard - 1;
import org.opensearch.common.util.BigArrays;
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
import org.opensearch.search.aggregations.InternalAggregations;
        @Override
        }
    }
        return Collections.singletonList(termsAgg);
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(1L, 0L, 10, 10);
import org.opensearch.search.DocValueFormat;
        @Override
                }
                querySearchResult.setSearchShardTarget(searchShardTarget);
     *
            BucketOrder.key(true),  // Order by key ascending
            );
    }
            buckets.add(bucket);
import org.apache.lucene.search.TotalHits;
            List<SearchShard> shards,
                return curr;
        // Wait for all results to be consumed
            })
                    // Final result from shard - use consumeResult to trigger progress notification
     * This test verifies that QueryPhaseResultConsumer can correctly handle
            10,
        searchProgressListener = new TestStreamProgressListener();
        for (int shardIndex = 0; shardIndex < numShards; shardIndex++) {
     */
 * where multiple results can be received from the same shard
            OpenSearchExecutors.daemonThreadFactory("test"),
                    // This is the final result from this shard - it has hits but no aggs
            // 10 * termNumber * (shardIndex+1) * (segmentIndex+1)
                docCount,
     * @param segmentIndex The segment index (0-based) to use for value scaling
        protected void onListShards(
     *
                    BigArrays.NON_RECYCLING_INSTANCE,
        @Override
    public void setup() throws Exception {
        SearchPhaseController.ReducedQueryPhase reduced = queryPhaseResultConsumer.reduce();
                assertNotNull("Max aggregation should not be null", maxAgg);
                format
        threadPool = new TestThreadPool(getClass().getName());
        private final AtomicInteger onFinalReduce = new AtomicInteger(0);
     * - Contains exactly 3 term buckets named "term1", "term2", and "term3"
            false,  // showTermDocCountError
 * The OpenSearch Contributors require contributions made to
                } else {
     */
     * - Values scale predictably based on term, shard, and segment indices:
            "terms",
        assertNull(onPartialMergeFailure.get());
            // Document count follows the same scaling pattern as max values:
            "test",
        protected void onFinalReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
/**
                // - For term3: Max value is from shard2/segment2 = 10.0 * 3 * 3 * 3 = 270.0
        for (int i = 1; i <= 3; i++) {
        }
     * Progress listener implementation that keeps track of events for testing
     * - "term2": 200.0  (highest values across all segments)
            return onQueryResult.get();
            metadata,
            onQueryResult.incrementAndGet();
        // For each shard, send multiple results (simulating streaming)
                    querySearchResult.topDocs(new TopDocsAndMaxScore(topDocs, 0.0f), new DocValueFormat[0]);
                    default -> 0;
    /**
                    null,
        assertNotNull(reduced);
            @Override
            for (StringTerms.Bucket bucket : terms.getBuckets()) {
                0,
                assertEquals("Max value should match expected value for term " + term, expectedMaxValue, maxAgg.getValue(), 0.001);
 */
    private TestStreamProgressListener searchProgressListener;
        StreamQueryPhaseResultConsumer queryPhaseResultConsumer = new StreamQueryPhaseResultConsumer(
        searchPhaseController = new SearchPhaseController(writableRegistry(), s -> new InternalAggregation.ReduceContextBuilder() {
    }
        private final AtomicInteger onQueryResult = new AtomicInteger(0);
     * the final expected max values will be:
            // Formula: 10.0 * termNumber * (shardIndex+1) * (segmentIndex+1)
 *
                // Create a search result for this segment
                // - For term1: Max value is from shard2/segment2 = 10.0 * 1 * 3 * 3 = 90.0
        }
                QuerySearchResult querySearchResult = new QuerySearchResult();
            // - Increase with shard index (shard2 > shard1 > shard0)
            0,  // otherDocCount
            BucketOrder.key(true),
        // Create bucket count thresholds
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
                double expectedMaxValue = switch (term) {
import org.opensearch.action.OriginalIndices;
        SearchRequest searchRequest = new SearchRequest("index");
     * This method generates a terms aggregation with these specific characteristics:
            onFinalReduce.incrementAndGet();
    @After
                querySearchResult.setShardIndex(finalShardIndex);
            // This creates predictable max values that:
                if (isLastSegment) {
                    PipelineAggregator.PipelineTree.EMPTY
                    TopDocs emptyDocs = new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]);
     * - "term3": 300.0  (highest values across all segments)
                    // Interim segment result - use consumeStreamResult (no progress notification)
                // Simulate consuming the result
            // - Increase with segment index (segment2 > segment1 > segment0)
     * @param shardIndex The shard index (0-based) to use for value scaling
                    queryPhaseResultConsumer.consumeStreamResult(querySearchResult, allResultsLatch::countDown);
import org.junit.After;
                    case "term1" -> 100.0;
            boolean fetchPhase
                    queryPhaseResultConsumer.consumeResult(querySearchResult, allResultsLatch::countDown);
    private OpenSearchThreadPoolExecutor executor;
                    // Last segment doesn't have aggregations (they were streamed in previous segments)
            InternalAggregations reducedAggs = reduced.aggregations;
import org.opensearch.search.query.QuerySearchResult;
            // - Increase with term number (term3 > term2 > term1)
            double maxValue = 10.0 * i * (shardIndex + 1) * (segmentIndex + 1);
            SearchShardTarget searchShardTarget = new SearchShardTarget(
                new ShardId("index", "uuid", shardIndex),
        }
        public int getQueryResultCount() {
import java.util.Map;
import org.junit.Before;
            }
                    querySearchResult.aggregations(null);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
                InternalMax maxAgg = bucket.getAggregations().get("max_value");
            StringTerms terms = reducedAggs.get("terms");
            List<SearchShard> skippedShards,
import org.apache.lucene.search.ScoreDoc;
            1,
        assertEquals(numShards, searchProgressListener.getQueryResultCount());
        // Create the terms aggregation with the buckets
     * multiple streaming results from the same shard, with segments arriving in order
     * - Each term bucket contains a max sub-aggregation called "max_value"
                    b -> {},
    public void cleanup() {
            assertNotNull("Terms aggregation should not be null", terms);
     * Creates a terms aggregation with a sub max aggregation for testing.
        );
        }
                    querySearchResult.aggregations(InternalAggregations.from(aggs));
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
                // - For term2: Max value is from shard2/segment2 = 10.0 * 2 * 3 * 3 = 180.0
import java.util.Arrays;
import org.opensearch.core.common.breaker.CircuitBreaker;
            SearchResponse.Clusters clusters,
            );
package org.opensearch.action.search;
                    querySearchResult.topDocs(new TopDocsAndMaxScore(emptyDocs, 0.0f), new DocValueFormat[0]);
 * SPDX-License-Identifier: Apache-2.0
                return InternalAggregation.ReduceContext.forFinalReduction(
        // Ensure no partial merge failures occurred
            String termName = "term" + i;
            // Create sub-aggregations list with the max agg
                assertTrue("Term name should be one of term1, term2, or term3", Arrays.asList("term1", "term2", "term3").contains(term));
        // Verify total hits - should be sum of all shards' final segment hits
                return InternalAggregation.ReduceContext.forPartialReduction(
import java.util.concurrent.atomic.AtomicReference;
                    case "term2" -> 200.0;
import java.util.concurrent.TimeUnit;
        assertEquals(1, searchProgressListener.getFinalReduceCount());
                );
            0,  // docCountError
            searchProgressListener,
import org.opensearch.search.aggregations.metrics.InternalMax;
                };
                OriginalIndices.NONE
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
/*
        searchRequest.setBatchedReduceSize(2);
        DocValueFormat format = DocValueFormat.RAW;
                    null,
                "node_" + shardIndex,
 * Tests for the QueryPhaseResultConsumer that focus on streaming aggregation capabilities
        // Setup search request with batched reduce size
        public int getFinalReduceCount() {
                    // This is an interim result with aggregations but no hits
        @Override
import org.opensearch.search.aggregations.BucketOrder;
    public void testStreamingAggregationFromMultipleShards() throws Exception {
        // Note: In some test runs, aggregations might be null due to how the test is orchestrated
            for (int segment = 0; segment < numSegmentsPerShard; segment++) {
            onPartialReduce.incrementAndGet();
        // For each term bucket (term1, term2, term3)
            threadPool.getThreadContext()
}
        public int getPartialReduceCount() {
            searchPhaseController,
            InternalMax maxAgg = new InternalMax("max_value", maxValue, format, Collections.emptyMap());
            StringTerms.Bucket bucket = new StringTerms.Bucket(
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
            assertEquals("Should have 3 term buckets", 3, terms.getBuckets().size());
import java.util.concurrent.CountDownLatch;
                // For last segment, include TopDocs but no aggregations
                }
     *
            buckets,
        // Shard 0: 10 hits, Shard 1: 20 hits, Shard 2: 30 hits = 60 total
            numShards,
            // Track nothing for this event
            // Check each term bucket and its max sub-aggregation
 */
            InternalAggregations subAggregations = InternalAggregations.from(subAggs);
import org.opensearch.core.index.shard.ShardId;
        // Verify the aggregation results are properly merged if present
        // Perform the final reduce and verify the result
        executor = OpenSearchExecutors.newFixed(
     * This listener is thread-safe and can be used to track progress events

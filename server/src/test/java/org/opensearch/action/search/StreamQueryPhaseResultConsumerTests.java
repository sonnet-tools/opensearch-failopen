import java.util.Collections;  
    /**  
            format,  
                // - For term2: Max value is from shard2/segment2 = 10.0 * 2 * 3 * 3 = 180.0
        public int getPartialReduceCount() {  
                0,  
                    TopDocs topDocs = new TopDocs(new TotalHits(10 * (finalShardIndex + 1), TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]);
    @After  
            metadata,
                    BigArrays.NON_RECYCLING_INSTANCE,
            }
                    case "term3" -> 300.0;
        @Override
        }
    private SearchPhaseController searchPhaseController;
                if (prev != null) curr.addSuppressed(prev);  
     * - "term2": 200.0  (highest values across all segments)
 * SPDX-License-Identifier: Apache-2.0
 */  
            assertNotNull("Terms aggregation should not be null", terms);  
            boolean fetchPhase  
                    // Last segment doesn't have aggregations (they were streamed in previous segments)
            }
    private List<InternalAggregation> createTermsAggregationWithSubMax(int shardIndex, int segmentIndex) {
            // Create a term bucket with the sub-aggregation  
                    // This is the final result from this shard - it has hits but no aggs
        executor = OpenSearchExecutors.newFixed(
                // Simulate consuming the result
        // For each shard, send multiple results (simulating streaming)
        });  
                OriginalIndices.NONE  
import org.opensearch.action.OriginalIndices;
        SearchRequest searchRequest = new SearchRequest("index");  
            buckets,
import java.util.Arrays;
            "terms",
                querySearchResult.setSearchShardTarget(searchShardTarget);
        }
                    // Final result from shard - use consumeResult to trigger progress notification
        List<StringTerms.Bucket> buckets = new ArrayList<>();
                double expectedMaxValue = switch (term) {
            0,  // otherDocCount  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            StringTerms terms = reducedAggs.get("terms");
                assertEquals("Max value should match expected value for term " + term, expectedMaxValue, maxAgg.getValue(), 0.001);
        assertEquals(60, reduced.totalHits.value());  
                docCount,  
    public void cleanup() {
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
import org.apache.lucene.search.TopDocs;
            bucketCountThresholds  
            0,  // docCountError
                false,
                return InternalAggregation.ReduceContext.forFinalReduction(
     *  
     * @param shardIndex The shard index (0-based) to use for value scaling
            searchRequest,
                // We use slightly higher values (100, 200, 300) in assertions to allow for minor differences  
            // Check each term bucket and its max sub-aggregation  
            List<SearchShard> skippedShards,
                // With 3 shards (indices 0,1,2) and 3 segments (indices 0,1,2):
import org.opensearch.test.OpenSearchTestCase;
        // This is different from real-world usage where aggregations would be properly passed
     */
                }  
import org.opensearch.search.query.QuerySearchResult;  
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
        private final AtomicInteger onFinalReduce = new AtomicInteger(0);
        for (int shardIndex = 0; shardIndex < numShards; shardIndex++) {  
     * - Contains exactly 3 term buckets named "term1", "term2", and "term3"
 * this file be licensed under the Apache-2.0 license or a
        return Collections.singletonList(termsAgg);  
/**
     * This listener is thread-safe and can be used to track progress events
                // Create a search result for this segment  
        // Shard 0: 10 hits, Shard 1: 20 hits, Shard 2: 30 hits = 60 total
    private static class TestStreamProgressListener extends SearchProgressListener {
import java.util.List;
            searchPhaseController,
            InternalAggregations reducedAggs = reduced.aggregations;  
            // - Increase with shard index (shard2 > shard1 > shard0)
    }
package org.opensearch.action.search;
     * - "term1": 100.0  (highest values across all segments)  
            // Document count follows the same scaling pattern as max values:
     * from multiple threads.  
            onQueryResult.incrementAndGet();
                };  
        assertNotNull(reduced.totalHits);
        // Perform the final reduce and verify the result
        }  
        Map<String, Object> metadata = Collections.emptyMap();
        }
                // - For term3: Max value is from shard2/segment2 = 10.0 * 3 * 3 * 3 = 270.0
            onPartialReduce.incrementAndGet();  
        @Override
            OpenSearchExecutors.daemonThreadFactory("test"),  
        // Create bucket count thresholds  
                // - For term1: Max value is from shard2/segment2 = 10.0 * 1 * 3 * 3 = 90.0  
    }
                return InternalAggregation.ReduceContext.forPartialReduction(  
                    null,
public class StreamQueryPhaseResultConsumerTests extends OpenSearchTestCase {  
            return onQueryResult.get();  
        // Setup search request with batched reduce size
import org.junit.After;
            e -> onPartialMergeFailure.accumulateAndGet(e, (prev, curr) -> {
                } else {  
import org.opensearch.search.aggregations.InternalAggregation;  
        // Note: In some test runs, aggregations might be null due to how the test is orchestrated  
        // Verify the number of notifications (one per shard for final shard results)
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
            BucketOrder.key(true),
     * the final expected max values will be:
            for (StringTerms.Bucket bucket : terms.getBuckets()) {
     * - Each term bucket contains a max sub-aggregation called "max_value"
                return curr;
     * When these aggregations are reduced across multiple shards and segments,
            searchProgressListener,
                    queryPhaseResultConsumer.consumeResult(querySearchResult, allResultsLatch::countDown);
            long docCount = 10L * i * (shardIndex + 1) * (segmentIndex + 1);
                    default -> 0;
            // - Increase with segment index (segment2 > segment1 > segment0)  
        // Verify total hits - should be sum of all shards' final segment hits
            return onFinalReduce.get();
        CountDownLatch allResultsLatch = new CountDownLatch(numShards * numSegmentsPerShard);  
        protected void onFinalReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
import org.opensearch.search.SearchShardTarget;
            );
        searchProgressListener = new TestStreamProgressListener();  
                    () -> PipelineAggregator.PipelineTree.EMPTY  
        int numShards = 3;
                boolean isLastSegment = segment == numSegmentsPerShard - 1;
     * This method generates a terms aggregation with these specific characteristics:  
        );  
                querySearchResult.setShardIndex(finalShardIndex);  
        }
        terminate(threadPool);  
                    b -> {},
                } else {
    }
        @Override  
    private ThreadPool threadPool;  
        assertEquals(1, searchProgressListener.getFinalReduceCount());  
import org.opensearch.search.DocValueFormat;  
 * compatible open source license.
        );
    public void testStreamingAggregationFromMultipleShards() throws Exception {
            1,
                    // This is an interim result with aggregations but no hits
        DocValueFormat format = DocValueFormat.RAW;  
    @Before
            SearchResponse.Clusters clusters,
        }  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;  
        private final AtomicInteger onPartialReduce = new AtomicInteger(0);
import java.util.concurrent.atomic.AtomicReference;  
        assertEquals(numShards, searchProgressListener.getQueryResultCount());
     */
            }
import java.util.concurrent.CountDownLatch;  
        int numSegmentsPerShard = 3;  
     * - "term3": 300.0  (highest values across all segments)
            double maxValue = 10.0 * i * (shardIndex + 1) * (segmentIndex + 1);
        // Track any partial merge failures  
                new org.apache.lucene.util.BytesRef(termName),
            false,  // showTermDocCountError
        assertTrue(searchProgressListener.getPartialReduceCount() > 0);  
                null,
import org.apache.lucene.search.TotalHits;  
import org.opensearch.common.util.BigArrays;  
import java.util.Map;
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
            })
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),  
import org.opensearch.core.common.breaker.CircuitBreaker;  
                    querySearchResult.topDocs(new TopDocsAndMaxScore(emptyDocs, 0.0f), new DocValueFormat[0]);
                    BigArrays.NON_RECYCLING_INSTANCE,  
            onFinalReduce.incrementAndGet();
     * This test verifies that QueryPhaseResultConsumer can correctly handle
                    case "term2" -> 200.0;  
    /**  
            executor,
            // Track nothing for this event
            threadPool.getThreadContext()
                    case "term1" -> 100.0;
            @Override
     *
import org.opensearch.threadpool.TestThreadPool;
import org.junit.Before;
            InternalMax maxAgg = new InternalMax("max_value", maxValue, format, Collections.emptyMap());  
            public InternalAggregation.ReduceContext forFinalReduction() {
        // Create three term buckets with max sub-aggregations  
        // For each term bucket (term1, term2, term3)
            // - Increase with term number (term3 > term2 > term1)
        @Override
        SearchPhaseController.ReducedQueryPhase reduced = queryPhaseResultConsumer.reduce();  
        }
import org.opensearch.core.index.shard.ShardId;
            assertEquals("Should have 3 term buckets", 3, terms.getBuckets().size());
        }
        threadPool = new TestThreadPool(getClass().getName());
            return onPartialReduce.get();
            );
        StreamQueryPhaseResultConsumer queryPhaseResultConsumer = new StreamQueryPhaseResultConsumer(  
import org.opensearch.search.aggregations.InternalAggregations;
import org.apache.lucene.search.ScoreDoc;
        searchPhaseController = new SearchPhaseController(writableRegistry(), s -> new InternalAggregation.ReduceContextBuilder() {  
                if (isLastSegment) {  
        if (reduced.aggregations != null) {
            buckets.add(bucket);  
        AtomicReference<Exception> onPartialMergeFailure = new AtomicReference<>();
    }
        // Verify the aggregation results are properly merged if present
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
            BucketOrder.key(true),  // Order by key ascending  
        protected void onPartialReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
                if (isLastSegment) {  
            InternalAggregations subAggregations = InternalAggregations.from(subAggs);
                new ShardId("index", "uuid", shardIndex),
        StringTerms termsAgg = new StringTerms(
        }
     * - Values scale predictably based on term, shard, and segment indices:  
            }  
                format
            writableRegistry(),  
import java.util.concurrent.TimeUnit;
 * The OpenSearch Contributors require contributions made to  
        assertNull(onPartialMergeFailure.get());
                // For last segment, include TopDocs but no aggregations
    }
                assertNotNull("Max aggregation should not be null", maxAgg);  
                    PipelineAggregator.PipelineTree.EMPTY  
            10,
    /**  
import org.opensearch.search.aggregations.BucketOrder;
     * @return A list containing the single terms aggregation with max sub-aggregations  
                    queryPhaseResultConsumer.consumeStreamResult(querySearchResult, allResultsLatch::countDown);
            10,  // shardSize
            // Formula: 10.0 * termNumber * (shardIndex+1) * (segmentIndex+1)
 *
                    // Create terms aggregation with max sub-aggregation for the segment  
                    // Interim segment result - use consumeStreamResult (no progress notification)
        ) {
 * where multiple results can be received from the same shard
    public void setup() throws Exception {
        protected void onListShards(
                );
                    null,
     *   - MaxValue = 10.0 * termNumber * (shardIndex+1) * (segmentIndex+1)
    private OpenSearchThreadPoolExecutor executor;
            // Create sub-aggregations list with the max agg
        assertTrue(allResultsLatch.await(10, TimeUnit.SECONDS));
            String termName = "term" + i;
        private final AtomicInteger onQueryResult = new AtomicInteger(0);  
                QuerySearchResult querySearchResult = new QuerySearchResult();
            List<InternalAggregation> subAggs = Collections.singletonList(maxAgg);  
            for (int segment = 0; segment < numSegmentsPerShard; segment++) {  
     */  
}
            // Create max sub-aggregation with different values for each term
     * Progress listener implementation that keeps track of events for testing
     * @param segmentIndex The segment index (0-based) to use for value scaling
        );
                    TopDocs emptyDocs = new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]);  
import org.opensearch.search.aggregations.metrics.InternalMax;
     * Creates a terms aggregation with a sub max aggregation for testing.
        executor.shutdownNow();
            public InternalAggregation.ReduceContext forPartialReduction() {
        // Wait for all results to be consumed
        // Ensure no partial merge failures occurred
            final int finalShardIndex = shardIndex;
            // This creates predictable max values that:  
            List<SearchShard> shards,  
        searchRequest.setBatchedReduceSize(2);
        // Create the terms aggregation with the buckets  
     * multiple streaming results from the same shard, with segments arriving in order
/*  
        }  
        assertNotNull(reduced);
        TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(1L, 0L, 10, 10);
                subAggregations,
        public int getFinalReduceCount() {
                }  
            "test",  
                String term = bucket.getKeyAsString();
     *  
                    querySearchResult.aggregations(null);  
            // This creates increasingly larger doc counts for higher term numbers, shards, and segments
                assertTrue("Term name should be one of term1, term2, or term3", Arrays.asList("term1", "term2", "term3").contains(term));  
            numShards,
            SearchShardTarget searchShardTarget = new SearchShardTarget(
                InternalMax maxAgg = bucket.getAggregations().get("max_value");
                    List<InternalAggregation> aggs = createTermsAggregationWithSubMax(finalShardIndex, segment);
                );
        public int getQueryResultCount() {
            // The highest value for each term will be in the highest shard and segment indices
                "node_" + shardIndex,  
import org.opensearch.threadpool.ThreadPool;  
            // 10 * termNumber * (shardIndex+1) * (segmentIndex+1)  
                    querySearchResult.aggregations(InternalAggregations.from(aggs));
                    querySearchResult.topDocs(new TopDocsAndMaxScore(topDocs, 0.0f), new DocValueFormat[0]);  
 * Tests for the QueryPhaseResultConsumer that focus on streaming aggregation capabilities  
                // The max value for each term should be the largest from all segments and shards
        for (int i = 1; i <= 3; i++) {  
    private TestStreamProgressListener searchProgressListener;
     *   - DocCount = 10 * termNumber * (shardIndex+1) * (segmentIndex+1)
        // CountDownLatch to track when all results are consumed
            StringTerms.Bucket bucket = new StringTerms.Bucket(
 */
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
        protected void onQueryResult(int shardIndex) {  

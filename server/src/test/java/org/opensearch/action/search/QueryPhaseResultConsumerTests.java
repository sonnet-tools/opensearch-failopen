import org.opensearch.search.aggregations.InternalAggregations;
    @After
import java.util.concurrent.atomic.AtomicReference;
                );
 * compatible open source license.
            throw new UnsupportedOperationException();
 * Unless required by applicable law or agreed to in writing,
        CountDownLatch partialReduceLatch = new CountDownLatch(10);
            };
    }
 * ownership. Elasticsearch licenses this file to you under
        querySearchResult.aggregations(InternalAggregations.from(List.of(new InternalMax("test", 23, DocValueFormat.RAW, null))));
 *
        assertTrue(partialReduceLatch.await(10, TimeUnit.SECONDS));
    }
        final int BATCH_REDUCED_SIZE = 5;
        @Override
}
            queryPhaseResultConsumer.consumeResult(querySearchResult, partialReduceLatch::countDown);
 */
            "test",
            searchRequest,
     * allow_partial_search_results is enabled.
            10,
        }
    private static QuerySearchResult getQuerySearchResult(int i) {
        protected void onListShards(
import org.opensearch.search.builder.SearchSourceBuilder;
        SearchRequest searchRequest = new SearchRequest("index");
    }
        TopDocs topDocs = new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]);
 * this work for additional information regarding copyright
            queryPhaseResultConsumer.consumeResult(querySearchResult, () -> {});
/*
                    BigArrays.NON_RECYCLING_INSTANCE,
        assertEquals(0, result.sortedTopDocs.scoreDocs.length);
        QueryPhaseResultConsumer queryPhaseResultConsumer = new QueryPhaseResultConsumer(
        SearchRequest searchRequest = new SearchRequest("index");
        }
        protected void onQueryResult(int shardIndex) {
        for (int i = 0; i < 10; i++) {
        queryPhaseResultConsumer.reduce();
        private final AtomicInteger onPartialReduce = new AtomicInteger(0);
        QuerySearchResult querySearchResult = new QuerySearchResult();
                    b -> {},
        searchRequest.allowPartialSearchResults(true);
import org.opensearch.core.common.breaker.CircuitBreaker;
            OpenSearchExecutors.daemonThreadFactory("test"),
        );
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        );
 * Licensed to Elasticsearch under one or more contributor
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertNull("aggregations should be null when no shards returned results", result.aggregations);
        }
 * software distributed under the License is distributed on an
        }
import org.opensearch.threadpool.ThreadPool;
public class QueryPhaseResultConsumerTests extends OpenSearchTestCase {
            writableRegistry(),
            boolean fetchPhase
     */
import org.apache.lucene.search.TopDocs;
 *
    }
            SearchProgressListener.NOOP,
    @Before
    public void cleanup() {
        assertEquals(1, searchProgressListener.onFinalReduce.get());
            List<SearchShard> skippedShards,
import java.util.Collections;
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (prev != null) {
        QueryPhaseResultConsumer queryPhaseResultConsumer = new QueryPhaseResultConsumer(
 * specific language governing permissions and limitations
        assertTrue("result should be marked as empty", result.isEmptyResult);
            SearchResponse.Clusters clusters,
 */
        querySearchResult.setShardIndex(i);
        searchProgressListener.notifyListShards(searchShards, Collections.emptyList(), SearchResponse.Clusters.EMPTY, false);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
            })
            10,
        SearchPhaseController.ReducedQueryPhase result = consumer.reduce();
import java.util.ArrayList;
        }
        }
            searchPhaseController,
     * SearchPhaseController.reducedQueryPhase(). Ensure we do not exit early with a NPE particularly when
        return querySearchResult;
            QuerySearchResult querySearchResult = getQuerySearchResult(i);
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
/*
            testCircuitBreaker,
        protected void onFinalReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
    private OpenSearchThreadPoolExecutor executor;
import org.opensearch.test.OpenSearchTestCase;
                    () -> PipelineAggregator.PipelineTree.EMPTY
import org.opensearch.search.query.QuerySearchResult;
    public void testProgressListenerExceptionsAreCaught() throws Exception {
    public void testReduceWithAggsAndPartialResultsAllowedReturnsEmptyResult() throws Exception {
        );
     * but all shards failed (no results consumed). This reproduces a bug where hasAggs=true but
import org.opensearch.common.util.BigArrays;
        @Override
                    null,
        assertThrows(CircuitBreakingException.class, queryPhaseResultConsumer::reduce);
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        assertEquals(0, result.totalHits.value());
 * KIND, either express or implied.  See the License for the
/*
            10,
     * Tests that reduce() does not throw a NullPointerException when the search request has aggregations
            searchRequest,
        queryPhaseResultConsumer.consumeResult(querySearchResult, () -> {});
import org.opensearch.search.aggregations.metrics.InternalMax;
import org.opensearch.search.aggregations.InternalAggregation;
            searchPhaseController,
            e -> {
        executor.shutdownNow();
        assertNull(onPartialMergeFailure.get());
        searchRequest.setBatchedReduceSize(2);
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
    public void setup() {
    }
import org.opensearch.core.common.breaker.CircuitBreakingException;
            searchRequest,
 * this file be licensed under the Apache-2.0 license or a
        QuerySearchResult querySearchResult = getQuerySearchResult(7);
            executor,
import org.opensearch.search.SearchShardTarget;
import org.apache.lucene.search.TotalHits;
    private SearchPhaseController searchPhaseController;
        searchRequest.setBatchedReduceSize(2);
        searchRequest.setBatchedReduceSize(BATCH_REDUCED_SIZE);
            public InternalAggregation.ReduceContext forPartialReduction() {
            querySearchResult.aggregations(InternalAggregations.from(List.of(new InternalMax("test", 23, DocValueFormat.RAW, null))));
 * the Apache License, Version 2.0 (the "License"); you may
        searchRequest.source(new SearchSourceBuilder().aggregation(AggregationBuilders.max("max").field("test")).size(1));
 * under the License.
    public void testCircuitBreakerTriggersBeforeBatchedReduce() {
        searchPhaseController = new SearchPhaseController(writableRegistry(), s -> new InternalAggregation.ReduceContextBuilder() {
package org.opensearch.action.search;
            onPartialReduce.incrementAndGet();
                    BigArrays.NON_RECYCLING_INSTANCE,
                    null,
        querySearchResult.topDocs(new TopDocsAndMaxScore(topDocs, Float.NaN), new DocValueFormat[0]);
            QuerySearchResult querySearchResult = getQuerySearchResult(i);
import org.opensearch.core.index.shard.ShardId;
        List<SearchShard> searchShards = new ArrayList<>();
        terminate(threadPool);
        TestCircuitBreaker testCircuitBreaker = new TestCircuitBreaker();
            executor,
import java.util.concurrent.TimeUnit;
        @Override
                    PipelineAggregator.PipelineTree.EMPTY
            searchPhaseController,
            }
            writableRegistry(),
            @Override
import org.opensearch.threadpool.TestThreadPool;
import java.util.concurrent.CountDownLatch;
import org.opensearch.action.OriginalIndices;
import java.util.List;
            onFinalReduce.incrementAndGet();
import org.opensearch.search.aggregations.AggregationBuilders;
        protected void onPartialReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
import org.apache.lucene.search.ScoreDoc;
            e -> onPartialMergeFailure.accumulateAndGet(e, (prev, curr) -> {
        });
            List<SearchShard> shards,
        assertEquals(10, searchProgressListener.onQueryResult.get());
                    curr.addSuppressed(prev);
            threadPool.getThreadContext()
            1,
        querySearchResult.setSearchShardTarget(searchShardTarget);
import java.util.concurrent.atomic.AtomicInteger;
 */
 * SPDX-License-Identifier: Apache-2.0
import org.junit.Before;
            throw new UnsupportedOperationException();
    /**
 *
            public InternalAggregation.ReduceContext forFinalReduction() {
 * GitHub history for details.
    }
 * Modifications Copyright OpenSearch Contributors. See
        );
import org.opensearch.common.breaker.TestCircuitBreaker;
        ThrowingSearchProgressListener searchProgressListener = new ThrowingSearchProgressListener();
    private static class ThrowingSearchProgressListener extends SearchProgressListener {
 * The OpenSearch Contributors require contributions made to
                throw new AssertionError("unexpected partial merge failure", e);
            searchProgressListener,
        searchRequest.source(new SearchSourceBuilder().aggregation(AggregationBuilders.max("test").field("value")));
    }
        AtomicReference<Exception> onPartialMergeFailure = new AtomicReference<>();
            onPartialMergeFailure::set
                );
            onQueryResult.incrementAndGet();
 * not use this file except in compliance with the License.
            SearchProgressListener.NOOP,
        AtomicReference<Exception> onPartialMergeFailure = new AtomicReference<>();
            throw new UnsupportedOperationException();
            10,
        }
            searchShards.add(new SearchShard(null, new ShardId("index", "uuid", i)));
        QueryPhaseResultConsumer consumer = new QueryPhaseResultConsumer(
        testCircuitBreaker.startBreaking();
            writableRegistry(),
        SearchShardTarget searchShardTarget = new SearchShardTarget("node", new ShardId("index", "uuid", i), null, OriginalIndices.NONE);
    private ThreadPool threadPool;
        private final AtomicInteger onFinalReduce = new AtomicInteger(0);
     * reducedQueryPhase returns null aggregations due to the empty results and the early-termination path in
import org.junit.After;
        for (int i = 0; i < BATCH_REDUCED_SIZE - 2; i++) {
                return InternalAggregation.ReduceContext.forPartialReduction(
        SearchRequest searchRequest = new SearchRequest("index");
        // No results consumed — all shards failed.
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
        executor = OpenSearchExecutors.newFixed(
        threadPool = new TestThreadPool(SearchPhaseControllerTests.class.getName());
            executor,
        for (int i = 0; i < 10; i++) {
        ) {
import org.opensearch.search.DocValueFormat;
                }
        @Override
                return curr;
            throw new UnsupportedOperationException();
        private final AtomicInteger onQueryResult = new AtomicInteger(0);
        assertEquals(8, searchProgressListener.onPartialReduce.get());
 * You may obtain a copy of the License at
                return InternalAggregation.ReduceContext.forFinalReduction(
            }

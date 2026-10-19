}  
import org.apache.lucene.search.TopDocs;
                    BigArrays.NON_RECYCLING_INSTANCE,  
        }
    public void setup() {
        @Override  
            queryPhaseResultConsumer.consumeResult(querySearchResult, () -> {});
            onPartialReduce.incrementAndGet();
            testCircuitBreaker,  
 */
 * not use this file except in compliance with the License.
            QuerySearchResult querySearchResult = getQuerySearchResult(i);
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
    private OpenSearchThreadPoolExecutor executor;
import org.apache.lucene.search.TotalHits;  
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;  
                }
     * but all shards failed (no results consumed). This reproduces a bug where hasAggs=true but
/*  
        SearchRequest searchRequest = new SearchRequest("index");
import org.opensearch.search.aggregations.metrics.InternalMax;
    }  
            searchPhaseController,
        assertEquals(0, result.totalHits.value());
            searchRequest,
 * under the License.  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;  
                    b -> {},
        SearchShardTarget searchShardTarget = new SearchShardTarget("node", new ShardId("index", "uuid", i), null, OriginalIndices.NONE);
            querySearchResult.aggregations(InternalAggregations.from(List.of(new InternalMax("test", 23, DocValueFormat.RAW, null))));
        assertEquals(10, searchProgressListener.onQueryResult.get());
        assertNull(onPartialMergeFailure.get());
            }
        );
            OpenSearchExecutors.daemonThreadFactory("test"),  
    }  
 * ownership. Elasticsearch licenses this file to you under  
            executor,
            searchRequest,
            @Override
        assertEquals(8, searchProgressListener.onPartialReduce.get());
                    PipelineAggregator.PipelineTree.EMPTY  
            10,
        testCircuitBreaker.startBreaking();
            1,
        TopDocs topDocs = new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]);
            SearchProgressListener.NOOP,
        @Override
        protected void onQueryResult(int shardIndex) {
        assertTrue("result should be marked as empty", result.isEmptyResult);  
            writableRegistry(),  
        }  
        querySearchResult.topDocs(new TopDocsAndMaxScore(topDocs, Float.NaN), new DocValueFormat[0]);
        protected void onPartialReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
    }
            10,
        AtomicReference<Exception> onPartialMergeFailure = new AtomicReference<>();
        querySearchResult.aggregations(InternalAggregations.from(List.of(new InternalMax("test", 23, DocValueFormat.RAW, null))));
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),  
        searchRequest.source(new SearchSourceBuilder().aggregation(AggregationBuilders.max("test").field("value")));
    }
import java.util.ArrayList;
import org.opensearch.search.DocValueFormat;
import org.opensearch.search.aggregations.AggregationBuilders;
        searchProgressListener.notifyListShards(searchShards, Collections.emptyList(), SearchResponse.Clusters.EMPTY, false);
    @Before
        SearchRequest searchRequest = new SearchRequest("index");  
            e -> onPartialMergeFailure.accumulateAndGet(e, (prev, curr) -> {
        });  
        protected void onFinalReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
     * Tests that reduce() does not throw a NullPointerException when the search request has aggregations  
        assertEquals(1, searchProgressListener.onFinalReduce.get());
    @After
        );
    public void testProgressListenerExceptionsAreCaught() throws Exception {
        CountDownLatch partialReduceLatch = new CountDownLatch(10);
    private static QuerySearchResult getQuerySearchResult(int i) {  
        queryPhaseResultConsumer.reduce();
        for (int i = 0; i < 10; i++) {  
            onPartialMergeFailure::set
 * specific language governing permissions and limitations
import java.util.Collections;  
            executor,
        assertTrue(partialReduceLatch.await(10, TimeUnit.SECONDS));  
        List<SearchShard> searchShards = new ArrayList<>();  
        for (int i = 0; i < BATCH_REDUCED_SIZE - 2; i++) {
        }
 *  
        private final AtomicInteger onQueryResult = new AtomicInteger(0);
 * this file be licensed under the Apache-2.0 license or a
            searchPhaseController,
            SearchProgressListener.NOOP,
        final int BATCH_REDUCED_SIZE = 5;
                    null,
            throw new UnsupportedOperationException();  
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
     */
            searchPhaseController,
        QuerySearchResult querySearchResult = new QuerySearchResult();  
 * SPDX-License-Identifier: Apache-2.0
     * reducedQueryPhase returns null aggregations due to the empty results and the early-termination path in
                if (prev != null) {  
            10,
        @Override  
 * Licensed to Elasticsearch under one or more contributor  
            SearchResponse.Clusters clusters,  
    public void testReduceWithAggsAndPartialResultsAllowedReturnsEmptyResult() throws Exception {  
        queryPhaseResultConsumer.consumeResult(querySearchResult, () -> {});
public class QueryPhaseResultConsumerTests extends OpenSearchTestCase {
            searchShards.add(new SearchShard(null, new ShardId("index", "uuid", i)));
        searchRequest.setBatchedReduceSize(2);
        executor = OpenSearchExecutors.newFixed(
        ) {
        assertEquals(0, result.sortedTopDocs.scoreDocs.length);  
        threadPool = new TestThreadPool(SearchPhaseControllerTests.class.getName());
        @Override  
            onFinalReduce.incrementAndGet();
/*
    private ThreadPool threadPool;
import org.junit.After;
 * GitHub history for details.
 */  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),  
                return InternalAggregation.ReduceContext.forPartialReduction(  
            searchProgressListener,
        SearchRequest searchRequest = new SearchRequest("index");  
            queryPhaseResultConsumer.consumeResult(querySearchResult, partialReduceLatch::countDown);
                    curr.addSuppressed(prev);
        }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        TestCircuitBreaker testCircuitBreaker = new TestCircuitBreaker();
        querySearchResult.setSearchShardTarget(searchShardTarget);  
import java.util.concurrent.TimeUnit;  
        }  
        QuerySearchResult querySearchResult = getQuerySearchResult(7);  
        // No results consumed — all shards failed.
        );  
        searchRequest.allowPartialSearchResults(true);
        AtomicReference<Exception> onPartialMergeFailure = new AtomicReference<>();
            })
        ThrowingSearchProgressListener searchProgressListener = new ThrowingSearchProgressListener();
            throw new UnsupportedOperationException();  
            QuerySearchResult querySearchResult = getQuerySearchResult(i);  
        QueryPhaseResultConsumer queryPhaseResultConsumer = new QueryPhaseResultConsumer(  
import org.opensearch.search.builder.SearchSourceBuilder;  
        private final AtomicInteger onFinalReduce = new AtomicInteger(0);  
    }
            threadPool.getThreadContext()
 *
    private static class ThrowingSearchProgressListener extends SearchProgressListener {  
        executor.shutdownNow();
        return querySearchResult;
            List<SearchShard> skippedShards,
import org.opensearch.search.SearchShardTarget;  
        QueryPhaseResultConsumer consumer = new QueryPhaseResultConsumer(  
 * You may obtain a copy of the License at  
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.search.aggregations.InternalAggregation;
    public void testCircuitBreakerTriggersBeforeBatchedReduce() {
 * The OpenSearch Contributors require contributions made to  
 */  
                    () -> PipelineAggregator.PipelineTree.EMPTY  
                return curr;  
        protected void onListShards(  
        SearchPhaseController.ReducedQueryPhase result = consumer.reduce();
import java.util.concurrent.atomic.AtomicReference;
 * the Apache License, Version 2.0 (the "License"); you may
        searchRequest.source(new SearchSourceBuilder().aggregation(AggregationBuilders.max("max").field("test")).size(1));
 * license agreements. See the NOTICE file distributed with
    /**
import org.opensearch.search.query.QuerySearchResult;
    }  
        terminate(threadPool);
        }  
            }
            searchRequest,
import org.opensearch.core.common.breaker.CircuitBreakingException;
import java.util.List;
            "test",  
        querySearchResult.setShardIndex(i);
            boolean fetchPhase
import java.util.concurrent.atomic.AtomicInteger;
            List<SearchShard> shards,
import org.opensearch.test.OpenSearchTestCase;
            executor,
            e -> {
import org.opensearch.threadpool.ThreadPool;
            10,
/*  
        assertThrows(CircuitBreakingException.class, queryPhaseResultConsumer::reduce);  
                );
    private SearchPhaseController searchPhaseController;  
            public InternalAggregation.ReduceContext forPartialReduction() {
import org.junit.Before;  
            onQueryResult.incrementAndGet();
        assertNull("aggregations should be null when no shards returned results", result.aggregations);
                    null,
        private final AtomicInteger onPartialReduce = new AtomicInteger(0);
import org.opensearch.search.aggregations.InternalAggregations;  
            writableRegistry(),  
import org.opensearch.threadpool.TestThreadPool;  
 *     http://www.apache.org/licenses/LICENSE-2.0
            throw new UnsupportedOperationException();  
    public void cleanup() {  
import org.opensearch.common.util.BigArrays;
        for (int i = 0; i < 10; i++) {
package org.opensearch.action.search;
    }  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
     * allow_partial_search_results is enabled.
            public InternalAggregation.ReduceContext forFinalReduction() {
        }
            throw new UnsupportedOperationException();  
        searchRequest.setBatchedReduceSize(2);  
                throw new AssertionError("unexpected partial merge failure", e);  
import java.util.concurrent.CountDownLatch;
                    BigArrays.NON_RECYCLING_INSTANCE,
 * Modifications Copyright OpenSearch Contributors. See
            writableRegistry(),  
                );
        searchRequest.setBatchedReduceSize(BATCH_REDUCED_SIZE);  
            };
import org.opensearch.core.common.breaker.NoopCircuitBreaker;  
        QueryPhaseResultConsumer queryPhaseResultConsumer = new QueryPhaseResultConsumer(  
        searchPhaseController = new SearchPhaseController(writableRegistry(), s -> new InternalAggregation.ReduceContextBuilder() {  
 * KIND, either express or implied.  See the License for the
        );
import org.opensearch.common.breaker.TestCircuitBreaker;
 * this work for additional information regarding copyright
import org.opensearch.action.OriginalIndices;
                return InternalAggregation.ReduceContext.forFinalReduction(
     * SearchPhaseController.reducedQueryPhase(). Ensure we do not exit early with a NPE particularly when  
import org.apache.lucene.search.ScoreDoc;
 * software distributed under the License is distributed on an
import org.opensearch.core.common.breaker.CircuitBreaker;

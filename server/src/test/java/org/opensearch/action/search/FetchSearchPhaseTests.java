                }
                }
                }
            null
            new DocValueFormat[0]
            new TopDocsAndMaxScore(
        );
                SearchActionListener<FetchSearchResult> listener
        );
        SearchHit[] hits = searchResponse.getHits().getHits();
                    fetchResult.hits(
 * Unless required by applicable law or agreed to in writing,
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
                @Override
        FetchSearchPhase phase = new FetchSearchPhase(
        };
        results.consumeResult(queryResult, () -> {});
        assertEquals("fetch", phase.getName());
        assertNotNull(searchResponse);
        queryResult.setShardIndex(1);
                2.0F
                    fail("requestID 123 should not be fetched but was");
            controller,
                        new SearchHits(new SearchHit[] { new SearchHit(42) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0F)
/*
            results.consumeResult(queryResult, () -> {});
public class FetchSearchPhaseTests extends OpenSearchTestCase {
        );
                Transport.Connection connection,
            new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
            sizeReleasedContexts,
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.isEmpty());
            );
                } else {
        );
        queryResult.setShardIndex(1);
        assertEquals(
                @Override
 * You may obtain a copy of the License at
        assertEquals(0, searchResponse.getFailedShards());
import org.opensearch.core.index.shard.ShardId;
        queryResult.size(resultSetSize);
            );
                    fetchResult.hits(
            (searchResponse, scrollId) -> new SearchPhase("test") {
                if (numFetches.incrementAndGet() == 1) {
            mockSearchPhaseContext,
            }
                Transport.Connection connection,
        int resultSetSize = randomIntBetween(0, 100);
                    i
                    );
    }
                new ShardSearchContextId("", i),
        SearchResponse searchResponse = mockSearchPhaseContext.searchResponse.get();
        queryResult.topDocs(
            new ShardSearchContextId("", 321),
            ) {
            exc -> {}
            results,
        SearchPhaseController controller = new SearchPhaseController(
            new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
            new TopDocsAndMaxScore(
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(
            results,
        queryResult.setShardIndex(1);
    public void testCleanupIrrelevantContexts() { // contexts that are not fetched should be cleaned up
        );
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.contains(ctx));
import org.opensearch.test.InternalAggregationTestCase;
            assertEquals("index: " + i, numHits - i, hits[i].docId());
        };
            @Override
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
                    );
            OpenSearchExecutors.newDirectExecutorService(),
        };
                            new SearchHit[] { new SearchHit((int) (request.contextId().getId() + 1)) },
                }).start();
            ctx2,
        phase.run();
                    new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(i + 1, i) }),
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(84, 2.0F) }),
            fetchResult.hits(new SearchHits(new SearchHit[] { new SearchHit(42) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0F));
                        new SearchHits(new SearchHit[] { new SearchHit(84) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 2.0F)
    public void testFailFetchOneDoc() {
        assertNotNull(searchResponse);
        assertEquals(42, searchResponse.getHits().getAt(1).docId());
            writableRegistry(),
                    );
            queryResult.topDocs(
            2,
            FetchSearchResult fetchResult = new FetchSearchResult();
        assertEquals(2, searchResponse.getHits().getTotalHits().value());
            results,
                    assertEquals(request, 123);
        assertNull(mockSearchPhaseContext.searchResponse.get());
        }
            results,
        assertEquals(numHits, searchResponse.getHits().getTotalHits().value());
                listener.onResponse(fetchResult);
import org.opensearch.search.fetch.ShardFetchSearchRequest;
                SearchTask task,
                SearchActionListener<FetchSearchResult> listener
            new TopDocsAndMaxScore(
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
                SearchTask task,
                @Override
            @Override
        queryResult = new QuerySearchResult(
import org.apache.lucene.search.ScoreDoc;
                Transport.Connection connection,
        mockSearchPhaseContext.assertNoFailure();
        );
        );
import java.util.concurrent.CountDownLatch;
                ShardFetchSearchRequest request,
                new DocValueFormat[0]
            null,
                        )
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(
        int numHits = randomIntBetween(2, 100); // also numshards --> 1 hit per shard
            queryResult.setShardIndex(i);
        assertEquals(Math.min(numHits, resultSetSize), searchResponse.getHits().getHits().length);
        );
import org.opensearch.action.OriginalIndices;
        queryResult.topDocs(
            public void sendExecuteFetch(
        int sizeReleasedContexts = Math.max(0, numHits - resultSetSize); // all non fetched results will be freed
            null
        assertTrue(searchResponse.getShardFailures()[0].getCause() instanceof MockDirectoryWrapper.FakeIOException);
            mockSearchPhaseContext,
        } else {
                public void run() {
                }
 * this work for additional information regarding copyright
                ShardFetchSearchRequest request,
                SearchActionListener<FetchSearchResult> listener
            results,
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.contains(ctx1));
        latch.await();
            controller,
            exc -> {}
        queryResult.setShardIndex(0);
        queryResult = new QuerySearchResult(
        results.consumeResult(queryResult, () -> {});
import org.apache.lucene.search.TotalHits;
        }
            (searchResponse, scrollId) -> new SearchPhase("test") {
        final ShardSearchContextId ctx = new ShardSearchContextId(UUIDs.base64UUID(), 123);
            SearchProgressListener.NOOP,
import org.apache.lucene.tests.store.MockDirectoryWrapper;
                SearchTask task,
                @Override
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(numHits);
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.isEmpty());
                public void run() {
    public void testFetchDocsConcurrently() throws InterruptedException {
                    );
            QueryFetchSearchResult fetchSearchResult = new QueryFetchSearchResult(queryResult, fetchResult);
                listener.onResponse(fetchResult);
        }
                ),
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.isEmpty());
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(1, searchResponse.getSuccessfulShards());
                FetchSearchResult fetchResult = new FetchSearchResult();
            @Override
        assertEquals(84, searchResponse.getHits().getAt(0).docId());
            }
        assertEquals(1, mockSearchPhaseContext.releasedSearchContexts.size());
        phase.run();
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
            fetchSearchResult.setShardIndex(0);
            new DocValueFormat[0]
            writableRegistry(),
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);
import org.opensearch.common.UUIDs;
            null
                            new TotalHits(1, TotalHits.Relation.EQUAL_TO),
        );
        assertNotNull(mockSearchPhaseContext.phaseFailure.get());
        assertEquals(84, searchResponse.getHits().getAt(0).docId());
        AtomicInteger numFetches = new AtomicInteger(0);
/*
        FetchSearchPhase phase = new FetchSearchPhase(
            ) {
                        new SearchHits(new SearchHit[] { new SearchHit(84) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 2.0F)
                @Override
        assertEquals("fetch", phase.getName());
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);
        queryResult.setShardIndex(0);
            OpenSearchExecutors.newDirectExecutorService(),
            SearchProgressListener.NOOP,
    }
        results.consumeResult(queryResult, () -> {});
            controller,
            numHits,
                    fetchResult.hits(
        );
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
 * specific language governing permissions and limitations
        SearchResponse searchResponse = mockSearchPhaseContext.searchResponse.get();
        assertNotNull(searchResponse);
import org.apache.lucene.search.TopDocs;
        );
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
        ShardSearchContextId ctx1 = new ShardSearchContextId(UUIDs.base64UUID(), 123);
        mockSearchPhaseContext.assertNoFailure();
            new DocValueFormat[0]
            ctx2,
            ) {
                if (request.contextId().getId() == 321) {
                    throw new RuntimeException("BOOM");
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        queryResult.size(resultSetSize);
                    fetchResult.hits(
            new SearchShardTarget("node2", new ShardId("test", "na", 1), null, OriginalIndices.NONE),
            null
 * Modifications Copyright OpenSearch Contributors. See
                if (request.contextId().equals(ctx2)) {
                null
        SearchResponse searchResponse = mockSearchPhaseContext.searchResponse.get();
            mockSearchPhaseContext.getRequest(),
        phase.run();
            queryResult.setSearchShardTarget(new SearchShardTarget("node0", new ShardId("index", "index", 0), null, OriginalIndices.NONE));
            ),
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(2, searchResponse.getSuccessfulShards());
        assertEquals(2, searchResponse.getHits().getTotalHits().value());
 * The OpenSearch Contributors require contributions made to
            new DocValueFormat[0]
import org.opensearch.search.SearchHit;
        assertEquals(mockSearchPhaseContext.phaseFailure.get().getMessage(), "BOOM");
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(84, 2.0F) }),
                SearchActionListener<FetchSearchResult> listener
            exc -> {}
            exc -> {}
        final ShardSearchContextId ctx2 = new ShardSearchContextId(UUIDs.base64UUID(), 321);
                2.0F
            2,
        FetchSearchPhase phase = new FetchSearchPhase(
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(
                FetchSearchResult fetchResult = new FetchSearchResult();
 * the Apache License, Version 2.0 (the "License"); you may
        if (hasHits) {
            (searchResponse, scrollId) -> new SearchPhase("test") {
            SearchProgressListener.NOOP,
 * this file be licensed under the Apache-2.0 license or a
            writableRegistry(),
            new ShardSearchContextId("", 123),
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(
        queryResult.setShardIndex(0);
                new DocValueFormat[0]
            new DocValueFormat[0]
                new TopDocsAndMaxScore(
        );
                listener.onResponse(fetchResult);
        results.consumeResult(queryResult, () -> {});
            @Override
            null,
            public void sendExecuteFetch(
                2.0F
            controller,
            assertNotNull(hits[i]);
                    FetchSearchResult fetchResult = new FetchSearchResult();
            writableRegistry(),
                Transport.Connection connection,
            writableRegistry(),
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
            ctx1,
                    listener.onResponse(fetchResult);
            controller,
            mockSearchPhaseContext.getRequest(),
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
        );
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
            exc -> {}
                } else {
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            assertEquals("index: " + i, numHits - 1 - i, (int) hits[i].getScore());
        SearchPhaseController controller = new SearchPhaseController(
        );
                ShardFetchSearchRequest request,
        );
import org.opensearch.search.query.QuerySearchResult;
        results.consumeResult(queryResult, () -> {});
                }
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
        FetchSearchPhase phase = new FetchSearchPhase(
 * software distributed under the License is distributed on an
            (searchResponse, scrollId) -> new SearchPhase("test") {
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(84, 2.0F) }),
        SearchPhaseController controller = new SearchPhaseController(
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
 */
}
        );
    public void testFetchTwoDocument() {
        SearchResponse searchResponse = mockSearchPhaseContext.searchResponse.get();
import org.opensearch.search.fetch.QueryFetchSearchResult;
            }
        );
                    1.0F
            new SearchShardTarget("node2", new ShardId("test", "na", 1), null, OriginalIndices.NONE),
        assertNotNull(searchResponse);
 *
            ctx1,
                } else {
                SearchTask task,
            mockSearchPhaseContext.releasedSearchContexts.toString(),
 * under the License.
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
            public void sendExecuteFetch(
        );
            2,
                2.0F
        queryResult = new QuerySearchResult(
import org.opensearch.core.common.breaker.CircuitBreaker;
import org.opensearch.search.DocValueFormat;
            QuerySearchResult queryResult = new QuerySearchResult();
                    listener.onResponse(fetchResult);
        results.consumeResult(queryResult, () -> {});
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
                Transport.Connection connection,
        queryResult.setShardIndex(1);
            mockSearchPhaseContext.releasedSearchContexts.size()
            OpenSearchExecutors.newDirectExecutorService(),
            2,
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);
        queryResult.size(resultSetSize);
            queryResult.size(1);
        assertEquals(1, mockSearchPhaseContext.releasedSearchContexts.size());
                }
        );
        phase.run();
            queryResult.topDocs(
            mockSearchPhaseContext.getRequest(),
        assertEquals(1, searchResponse.getFailedShards());
        );
        queryResult.size(resultSetSize); // the size of the result set
 * ownership. Elasticsearch licenses this file to you under
                        new SearchHits(new SearchHit[] { new SearchHit(84) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 2.0F)
                public void run() {
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(
            new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
            public void sendExecuteFetch(
                    );
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
        );
        };
    public void testShortcutQueryAndFetchOptimization() {
            results,
        mockSearchPhaseContext.assertNoFailure();
import java.util.concurrent.atomic.AtomicInteger;
                    FetchSearchResult fetchResult = new FetchSearchResult();
            new DocValueFormat[0]
        );
            ) {
            null,
                    );
        assertEquals("fetch", phase.getName());
            ) {
        SearchPhaseController controller = new SearchPhaseController(
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                    fetchResult.hits(
import org.opensearch.search.internal.ShardSearchContextId;
        );
            new DocValueFormat[0]
        queryResult.topDocs(
        assertEquals("fetch", phase.getName());
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
            new TopDocsAndMaxScore(
            controller,
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
        );
import org.opensearch.transport.Transport;
package org.opensearch.action.search;
            results.consumeResult(fetchSearchResult, () -> {});
        QuerySearchResult queryResult = new QuerySearchResult(
        );
            mockSearchPhaseContext.getRequest(),
                    new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
            public void sendExecuteFetch(
            ),
 * KIND, either express or implied.  See the License for the
                    );
                    assertEquals(ctx1, request.contextId());
        results.consumeResult(queryResult, () -> {});
                    fetchResult.hits(
                }
        boolean hasHits = randomBoolean();
                2.0F
        phase.run();
        assertEquals("fetch", phase.getName());
 * GitHub history for details.
        QuerySearchResult queryResult = new QuerySearchResult(
                new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
        );
            SearchProgressListener.NOOP,
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(
        assertNotNull(searchResponse);
            null,
            OpenSearchExecutors.newDirectExecutorService(),
    }
        final ShardSearchContextId ctx1 = new ShardSearchContextId(UUIDs.base64UUID(), 123);
            }
                }
        queryResult.topDocs(
        assertEquals(1, searchResponse.getHits().getHits().length);
            queryResult.size(resultSetSize); // the size of the result set
import org.opensearch.search.SearchHits;
                    latch.countDown();
                }
 */
        for (int i = 0; i < hits.length; i++) {
                }
            OpenSearchExecutors.newDirectExecutorService(),
            numHits = 1;
        );
 * not use this file except in compliance with the License.
            OpenSearchExecutors.newDirectExecutorService(),
    public void testExceptionFailsPhase() {
        FetchSearchPhase phase = new FetchSearchPhase(
                }
            new DocValueFormat[0]
            mockSearchPhaseContext.getRequest(),
        results.consumeResult(queryResult, () -> {});
            ),
        FetchSearchPhase phase = new FetchSearchPhase(
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
        );
        assertEquals(1, searchResponse.getShardFailures().length);
                ShardFetchSearchRequest request,
        queryResult.size(resultSetSize); // the size of the result set
            SearchProgressListener.NOOP,
            }
                public void run() {
        queryResult.setShardIndex(0);
        SearchPhaseController controller = new SearchPhaseController(
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
    }
            }
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
            ),
 *
                    fetchResult.hits(
            mockSearchPhaseContext,
        int resultSetSize = randomIntBetween(2, 10);
            1,
    }
            mockSearchPhaseContext,
            null
        phase.run();
        queryResult.size(resultSetSize); // the size of the result set
        assertEquals(0, searchResponse.getFailedShards());
        );
            mockSearchPhaseContext,
            null,
 * compatible open source license.
            new TopDocsAndMaxScore(
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
            SearchProgressListener.NOOP,
            mockSearchPhaseContext,
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
        queryResult.topDocs(
            writableRegistry(),
import org.opensearch.search.SearchShardTarget;
            new ShardSearchContextId("", 321),
                new TopDocsAndMaxScore(
                } else {
        assertEquals("fetch", phase.getName());
        final ShardSearchContextId ctx2 = new ShardSearchContextId(UUIDs.base64UUID(), 321);
 *
            ),
                2.0F
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
            new SearchShardTarget("node2", new ShardId("test", "na", 1), null, OriginalIndices.NONE),
        QuerySearchResult queryResult = new QuerySearchResult(
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(84, searchResponse.getHits().getAt(0).docId());
                2.0F
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
 */
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(84, 2.0F) }),
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);
        }
                        new SearchHits(new SearchHit[] { new SearchHit(84) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 2.0F)
        CountDownLatch latch = new CountDownLatch(1);
                public void run() {
        int resultSetSize = 1;
        QuerySearchResult queryResult = new QuerySearchResult(
        if (numHits != 0) {
        );
            new TopDocsAndMaxScore(
            ),
        final int numHits;
        int resultSetSize = randomIntBetween(2, 10);
        assertEquals(2, searchResponse.getHits().getTotalHits().value());
        queryResult = new QuerySearchResult(
                public void run() {
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);
            null,
            null
            }
        };
        queryResult.size(resultSetSize);
            (searchResponse, scrollId) -> new SearchPhase("test") {
        SearchResponse searchResponse = mockSearchPhaseContext.searchResponse.get();
        );
        SearchPhaseController controller = new SearchPhaseController(
            exc -> {}
                    listener.onFailure(new MockDirectoryWrapper.FakeIOException());
            mockSearchPhaseContext.getRequest(),
        assertEquals(numHits, searchResponse.getSuccessfulShards());
            ctx,
        int resultSetSize = randomIntBetween(2, 10);
                new Thread(() -> {
        assertEquals(0, searchResponse.getFailedShards());
import org.opensearch.search.fetch.FetchSearchResult;
        assertEquals(numHits, searchResponse.getHits().getTotalHits().value());
                2.0F
            ),
                if (request.contextId().getId() == 321) {
            null
        queryResult.size(resultSetSize); // the size of the result set
            }
            numHits = 0;
        mockSearchPhaseContext.assertNoFailure();
            null
            new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
                ),
                        new SearchHits(
                FetchSearchResult fetchResult = new FetchSearchResult();
                ShardFetchSearchRequest request,
        mockSearchPhaseContext.assertNoFailure();
 * SPDX-License-Identifier: Apache-2.0
            new TopDocsAndMaxScore(
/*
                SearchActionListener<FetchSearchResult> listener
                SearchTask task,
            ),
                @Override
        // we use at least 2 hits otherwise this is subject to single shard optimization and we trip an assert...
    }
            QuerySearchResult queryResult = new QuerySearchResult(
                        new SearchHits(new SearchHit[] { new SearchHit(42) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0F)
        );
            );
            new TopDocsAndMaxScore(
                if (request.contextId().getId() == 321) {
            @Override
            assertEquals(42, searchResponse.getHits().getAt(0).docId());
            }
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        assertEquals(2, searchResponse.getSuccessfulShards());
            }
        for (int i = 0; i < numHits; i++) {
 * license agreements. See the NOTICE file distributed with
            (searchResponse, scrollId) -> new SearchPhase("test") {
        );
        queryResult.topDocs(
        queryResult.topDocs(
        queryResult.topDocs(
        );
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
                            100F
            new SearchShardTarget("node2", new ShardId("test", "na", 1), null, OriginalIndices.NONE),

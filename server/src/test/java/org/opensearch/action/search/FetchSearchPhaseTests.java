            new TopDocsAndMaxScore(
            OpenSearchExecutors.newDirectExecutorService(),
            (searchResponse, scrollId) -> new SearchPhase("test") {  
        queryResult = new QuerySearchResult(  
        assertEquals(numHits, searchResponse.getHits().getTotalHits().value());
                SearchTask task,
        final ShardSearchContextId ctx2 = new ShardSearchContextId(UUIDs.base64UUID(), 321);  
                Transport.Connection connection,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        queryResult.setShardIndex(1);
            mockSearchPhaseContext,  
            numHits = 0;  
        );  
                    fetchResult.hits(
                null
            new TopDocsAndMaxScore(
            controller,  
                new ShardSearchContextId("", i),  
                }).start();  
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(
            public void sendExecuteFetch(
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.contains(ctx1));
 * this file be licensed under the Apache-2.0 license or a
        queryResult = new QuerySearchResult(
        AtomicInteger numFetches = new AtomicInteger(0);  
            QueryFetchSearchResult fetchSearchResult = new QueryFetchSearchResult(queryResult, fetchResult);
                    );  
            queryResult.topDocs(
import org.opensearch.transport.Transport;
        );
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(
            new SearchShardTarget("node2", new ShardId("test", "na", 1), null, OriginalIndices.NONE),
                    fetchResult.hits(
            new DocValueFormat[0]  
 * not use this file except in compliance with the License.
                Transport.Connection connection,  
            new DocValueFormat[0]
        assertEquals(1, searchResponse.getHits().getHits().length);  
        );
                listener.onResponse(fetchResult);  
        assertEquals(84, searchResponse.getHits().getAt(0).docId());
        queryResult.topDocs(
        );
            fetchResult.hits(new SearchHits(new SearchHit[] { new SearchHit(42) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0F));  
            SearchProgressListener.NOOP,  
                ),
        );
            ),
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);
        final int numHits;
            @Override
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
            results,
        queryResult.setShardIndex(1);
        );
import org.opensearch.search.DocValueFormat;
    }  
            ),
                SearchTask task,
            null
        FetchSearchPhase phase = new FetchSearchPhase(  
        }
            (searchResponse, scrollId) -> new SearchPhase("test") {
                    );
                    fetchResult.hits(
            2,
                @Override  
                    fetchResult.hits(
                public void run() {  
            OpenSearchExecutors.newDirectExecutorService(),  
            new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),  
package org.opensearch.action.search;
            ),  
            new ShardSearchContextId("", 321),  
            SearchProgressListener.NOOP,
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),  
        QuerySearchResult queryResult = new QuerySearchResult(
            );
        boolean hasHits = randomBoolean();
                        new SearchHits(new SearchHit[] { new SearchHit(84) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 2.0F)  
            @Override
        results.consumeResult(queryResult, () -> {});  
    }  
                        new SearchHits(new SearchHit[] { new SearchHit(84) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 2.0F)  
            new TopDocsAndMaxScore(
            exc -> {}  
import org.opensearch.core.index.shard.ShardId;
        assertEquals(
            mockSearchPhaseContext.getRequest(),  
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
            ) {
        FetchSearchPhase phase = new FetchSearchPhase(
        }
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
                        new SearchHits(new SearchHit[] { new SearchHit(42) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0F)
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.isEmpty());
        );  
            null,  
                        new SearchHits(new SearchHit[] { new SearchHit(84) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 2.0F)
        SearchHit[] hits = searchResponse.getHits().getHits();
            }
        mockSearchPhaseContext.assertNoFailure();
            new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
            writableRegistry(),
 * Licensed to Elasticsearch under one or more contributor  
            mockSearchPhaseContext,  
            null  
            ),  
            new ShardSearchContextId("", 123),  
                2.0F
                } else {
        };
 * license agreements. See the NOTICE file distributed with
                    fetchResult.hits(
        queryResult.topDocs(  
            mockSearchPhaseContext.getRequest(),  
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),  
        assertNotNull(searchResponse);
                SearchActionListener<FetchSearchResult> listener
        FetchSearchPhase phase = new FetchSearchPhase(  
import org.opensearch.action.OriginalIndices;
            }  
        results.consumeResult(queryResult, () -> {});
 * SPDX-License-Identifier: Apache-2.0
            }  
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.isEmpty());  
        if (numHits != 0) {  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            results.consumeResult(fetchSearchResult, () -> {});  
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(  
            ctx2,
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
            queryResult.topDocs(  
                2.0F
        );
        FetchSearchPhase phase = new FetchSearchPhase(
                new DocValueFormat[0]  
        assertEquals(2, searchResponse.getHits().getTotalHits().value());
            null,
                }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }  
        );
        CountDownLatch latch = new CountDownLatch(1);  
            (searchResponse, scrollId) -> new SearchPhase("test") {
    }
                }  
            results,
            results,  
                }
                    );  
        assertNull(mockSearchPhaseContext.searchResponse.get());  
import org.opensearch.search.SearchHit;  
            ) {
 *
            (searchResponse, scrollId) -> new SearchPhase("test") {
            }
        phase.run();  
        };
        int resultSetSize = randomIntBetween(2, 10);
                Transport.Connection connection,
public class FetchSearchPhaseTests extends OpenSearchTestCase {  
        );  
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(84, 2.0F) }),
        queryResult.topDocs(
            controller,
            ctx,
                public void run() {  
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);  
        assertEquals(84, searchResponse.getHits().getAt(0).docId());
        SearchResponse searchResponse = mockSearchPhaseContext.searchResponse.get();  
                ShardFetchSearchRequest request,
import java.util.concurrent.atomic.AtomicInteger;
                } else {
                if (request.contextId().equals(ctx2)) {
        assertNotNull(searchResponse);  
            ) {
        phase.run();  
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(numHits);
    public void testExceptionFailsPhase() {
import org.opensearch.common.UUIDs;
            (searchResponse, scrollId) -> new SearchPhase("test") {
                new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
        assertEquals(2, searchResponse.getSuccessfulShards());
        int numHits = randomIntBetween(2, 100); // also numshards --> 1 hit per shard
                            100F
        queryResult.size(resultSetSize);  
            results,  
                    FetchSearchResult fetchResult = new FetchSearchResult();  
                FetchSearchResult fetchResult = new FetchSearchResult();  
        );
                    );  
 * Modifications Copyright OpenSearch Contributors. See  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        queryResult.topDocs(
        );  
        assertEquals(numHits, searchResponse.getHits().getTotalHits().value());
        for (int i = 0; i < hits.length; i++) {
        assertEquals(Math.min(numHits, resultSetSize), searchResponse.getHits().getHits().length);  
            public void sendExecuteFetch(  
            SearchProgressListener.NOOP,
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
            queryResult.size(resultSetSize); // the size of the result set
            ),
        mockSearchPhaseContext.assertNoFailure();
        mockSearchPhaseContext.assertNoFailure();
            null,
        results.consumeResult(queryResult, () -> {});
                FetchSearchResult fetchResult = new FetchSearchResult();
                listener.onResponse(fetchResult);
                ),
                ShardFetchSearchRequest request,
            OpenSearchExecutors.newDirectExecutorService(),  
 * specific language governing permissions and limitations
                }
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
            null
        results.consumeResult(queryResult, () -> {});  
        SearchPhaseController controller = new SearchPhaseController(  
        );
                SearchTask task,
 *  
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(84, 2.0F) }),
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {  
        queryResult.topDocs(  
                    throw new RuntimeException("BOOM");
        assertEquals(1, mockSearchPhaseContext.releasedSearchContexts.size());
        final ShardSearchContextId ctx = new ShardSearchContextId(UUIDs.base64UUID(), 123);  
        queryResult.setShardIndex(0);
            ctx1,
import org.opensearch.search.fetch.ShardFetchSearchRequest;
            new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {  
                new TopDocsAndMaxScore(
            }  
                        )  
        SearchPhaseController controller = new SearchPhaseController(
            1,
        assertEquals(1, searchResponse.getShardFailures().length);
                if (request.contextId().getId() == 321) {
            new DocValueFormat[0]
import org.apache.lucene.search.TotalHits;
                SearchTask task,  
            writableRegistry(),
            new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),  
            new TopDocsAndMaxScore(
                    latch.countDown();
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.contains(ctx));
            mockSearchPhaseContext.getRequest(),
            assertEquals(42, searchResponse.getHits().getAt(0).docId());
            ),
        SearchResponse searchResponse = mockSearchPhaseContext.searchResponse.get();
 * KIND, either express or implied.  See the License for the
/*
            ctx1,  
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()  
        SearchPhaseController controller = new SearchPhaseController(  
import org.opensearch.core.common.breaker.NoopCircuitBreaker;  
            @Override
        );  
        assertEquals(42, searchResponse.getHits().getAt(1).docId());  
                if (request.contextId().getId() == 321) {
            null,
    public void testFetchTwoDocument() {  
            mockSearchPhaseContext,  
        queryResult.topDocs(
                }
            new TopDocsAndMaxScore(
        assertEquals(mockSearchPhaseContext.phaseFailure.get().getMessage(), "BOOM");
        results.consumeResult(queryResult, () -> {});
        queryResult.size(resultSetSize);  
            controller,
        phase.run();  
        );
        assertEquals(0, searchResponse.getFailedShards());
        results.consumeResult(queryResult, () -> {});  
            fetchSearchResult.setShardIndex(0);
            writableRegistry(),  
        final ShardSearchContextId ctx2 = new ShardSearchContextId(UUIDs.base64UUID(), 321);
            public void sendExecuteFetch(
        queryResult.size(resultSetSize); // the size of the result set
                    listener.onFailure(new MockDirectoryWrapper.FakeIOException());  
 * this work for additional information regarding copyright
        );
 */
import org.opensearch.search.query.QuerySearchResult;
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(
        QuerySearchResult queryResult = new QuerySearchResult(
import org.opensearch.test.InternalAggregationTestCase;
        phase.run();
            assertNotNull(hits[i]);  
                ShardFetchSearchRequest request,
            null
            controller,
            new DocValueFormat[0]  
}
            }  
 * software distributed under the License is distributed on an
                } else {
                @Override
        if (hasHits) {  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        int resultSetSize = randomIntBetween(0, 100);  
            ),
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(84, 2.0F) }),
        assertEquals(84, searchResponse.getHits().getAt(0).docId());
                    listener.onResponse(fetchResult);
        int resultSetSize = randomIntBetween(2, 10);
        assertEquals("fetch", phase.getName());
            mockSearchPhaseContext,
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(84, 2.0F) }),  
        queryResult = new QuerySearchResult(  
                2.0F  
            ) {  
        );  
 *
        phase.run();  
        );
        assertNotNull(searchResponse);  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        assertEquals("fetch", phase.getName());
            exc -> {}
            assertEquals("index: " + i, numHits - 1 - i, (int) hits[i].getScore());
 * the Apache License, Version 2.0 (the "License"); you may
                            new SearchHit[] { new SearchHit((int) (request.contextId().getId() + 1)) },  
        queryResult.topDocs(  
        queryResult.setShardIndex(0);  
            }
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
        queryResult.size(resultSetSize); // the size of the result set
        assertNotNull(mockSearchPhaseContext.phaseFailure.get());
                        new SearchHits(
            FetchSearchResult fetchResult = new FetchSearchResult();
            exc -> {}
        assertTrue(searchResponse.getShardFailures()[0].getCause() instanceof MockDirectoryWrapper.FakeIOException);  
            new TopDocsAndMaxScore(  
            null
                    1.0F  
        );  
                public void run() {
                new DocValueFormat[0]
 * The OpenSearch Contributors require contributions made to  
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),  
 * You may obtain a copy of the License at  
        SearchResponse searchResponse = mockSearchPhaseContext.searchResponse.get();  
            SearchProgressListener.NOOP,
                Transport.Connection connection,  
            new DocValueFormat[0]  
                    );
import org.opensearch.search.SearchShardTarget;
            exc -> {}  
        );
 * GitHub history for details.
        queryResult = new QuerySearchResult(
import org.opensearch.search.SearchHits;
                    );
        );
        queryResult.setShardIndex(0);  
            numHits = 1;
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);
                } else {  
            2,
            }
        } else {
        assertNotNull(searchResponse);
import org.apache.lucene.search.ScoreDoc;  
        );  
                SearchTask task,  
import org.apache.lucene.tests.store.MockDirectoryWrapper;  
        SearchPhaseController controller = new SearchPhaseController(
                FetchSearchResult fetchResult = new FetchSearchResult();  
            new SearchShardTarget("node2", new ShardId("test", "na", 1), null, OriginalIndices.NONE),
        final ShardSearchContextId ctx1 = new ShardSearchContextId(UUIDs.base64UUID(), 123);
        assertEquals("fetch", phase.getName());
        queryResult.size(resultSetSize); // the size of the result set
        assertEquals("fetch", phase.getName());
            public void sendExecuteFetch(  
import org.opensearch.search.fetch.QueryFetchSearchResult;
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            exc -> {}
                }
            );  
            mockSearchPhaseContext,
        // we use at least 2 hits otherwise this is subject to single shard optimization and we trip an assert...
                @Override  
                    new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(i + 1, i) }),  
            @Override  
            sizeReleasedContexts,  
import org.opensearch.core.common.breaker.CircuitBreaker;
                }
            results.consumeResult(queryResult, () -> {});
            assertEquals("index: " + i, numHits - i, hits[i].docId());
            exc -> {}
    public void testFailFetchOneDoc() {  
        assertEquals(2, searchResponse.getHits().getTotalHits().value());
                    listener.onResponse(fetchResult);
    public void testCleanupIrrelevantContexts() { // contexts that are not fetched should be cleaned up
                    assertEquals(request, 123);  
                @Override
            OpenSearchExecutors.newDirectExecutorService(),
import org.opensearch.test.OpenSearchTestCase;  
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
                    fail("requestID 123 should not be fetched but was");
                    fetchResult.hits(  
                SearchActionListener<FetchSearchResult> listener  
        int resultSetSize = randomIntBetween(2, 10);
            queryResult.setSearchShardTarget(new SearchShardTarget("node0", new ShardId("index", "index", 0), null, OriginalIndices.NONE));
                ShardFetchSearchRequest request,
        assertEquals("fetch", phase.getName());  
                2.0F
            writableRegistry(),
            new DocValueFormat[0]
        );
            new SearchShardTarget("node2", new ShardId("test", "na", 1), null, OriginalIndices.NONE),  
        assertNotNull(searchResponse);
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
    }
            public void sendExecuteFetch(
            null,
            mockSearchPhaseContext.getRequest(),
        SearchPhaseController controller = new SearchPhaseController(
                public void run() {
                    assertEquals(ctx1, request.contextId());  
            new ShardSearchContextId("", 321),
        );
            );  
        }  
            null
                SearchActionListener<FetchSearchResult> listener
        int sizeReleasedContexts = Math.max(0, numHits - resultSetSize); // all non fetched results will be freed  
            results,  
        SearchResponse searchResponse = mockSearchPhaseContext.searchResponse.get();  
                Transport.Connection connection,
            (searchResponse, scrollId) -> new SearchPhase("test") {
            queryResult.setShardIndex(i);  
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);  
            null,  
            new TopDocsAndMaxScore(  
        );
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.isEmpty());  
        SearchResponse searchResponse = mockSearchPhaseContext.searchResponse.get();
            }  
                }
            new DocValueFormat[0]
                SearchActionListener<FetchSearchResult> listener
            queryResult.size(1);
            OpenSearchExecutors.newDirectExecutorService(),
        assertEquals(1, searchResponse.getSuccessfulShards());
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
            controller,
                @Override
        );
        results.consumeResult(queryResult, () -> {});
                    FetchSearchResult fetchResult = new FetchSearchResult();  
        );
        FetchSearchPhase phase = new FetchSearchPhase(
        );
        );  
                ShardFetchSearchRequest request,  
        ShardSearchContextId ctx1 = new ShardSearchContextId(UUIDs.base64UUID(), 123);  
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
            mockSearchPhaseContext.getRequest(),  
        };
            ) {
        assertEquals(1, mockSearchPhaseContext.releasedSearchContexts.size());
import org.apache.lucene.search.TopDocs;
 * under the License.  
        );
            2,
                2.0F
        assertEquals(0, searchResponse.getFailedShards());
        );  
            new TopDocsAndMaxScore(
            SearchProgressListener.NOOP,
        QuerySearchResult queryResult = new QuerySearchResult(
                new Thread(() -> {
        );  
        mockSearchPhaseContext.assertNoFailure();
                    fetchResult.hits(
 * compatible open source license.
/*  
                2.0F
                }
            writableRegistry(),
        );
                if (request.contextId().getId() == 321) {
                public void run() {  
        queryResult.size(resultSetSize);
            controller,
        FetchSearchPhase phase = new FetchSearchPhase(
    }  
            mockSearchPhaseContext.getRequest(),
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;  
        queryResult.size(resultSetSize); // the size of the result set
import org.opensearch.search.fetch.FetchSearchResult;  
        assertEquals(2, searchResponse.getSuccessfulShards());  
            ),
        };
        QuerySearchResult queryResult = new QuerySearchResult(
 * Unless required by applicable law or agreed to in writing,
        assertEquals(0, searchResponse.getFailedShards());
        assertEquals("fetch", phase.getName());  
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(
            mockSearchPhaseContext.releasedSearchContexts.toString(),
                    new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
import java.util.concurrent.CountDownLatch;  
                            new TotalHits(1, TotalHits.Relation.EQUAL_TO),
                    );
                2.0F  
            null  
            results,
                new TopDocsAndMaxScore(
            2,  
            null
            QuerySearchResult queryResult = new QuerySearchResult(
/*
            ctx2,
                2.0F  
        results.consumeResult(queryResult, () -> {});
import org.opensearch.search.internal.ShardSearchContextId;  
    }
        mockSearchPhaseContext.assertNoFailure();
        latch.await();
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(  
                listener.onResponse(fetchResult);
 * ownership. Elasticsearch licenses this file to you under  
            }  
        queryResult.setShardIndex(0);
                SearchActionListener<FetchSearchResult> listener  
    public void testShortcutQueryAndFetchOptimization() {
        assertEquals(numHits, searchResponse.getSuccessfulShards());
        queryResult.setShardIndex(1);  
        phase.run();
            new DocValueFormat[0]
            QuerySearchResult queryResult = new QuerySearchResult();
                @Override
            @Override
        queryResult.topDocs(
                        new SearchHits(new SearchHit[] { new SearchHit(84) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 2.0F)
        );
        assertEquals(1, searchResponse.getFailedShards());  
            new SearchShardTarget("node2", new ShardId("test", "na", 1), null, OriginalIndices.NONE),
                public void run() {
            OpenSearchExecutors.newDirectExecutorService(),  
                }  
                if (numFetches.incrementAndGet() == 1) {
                }
        );  
            SearchProgressListener.NOOP,  
                    i
        }
        SearchPhaseController controller = new SearchPhaseController(  
        queryResult.setShardIndex(1);
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
        };
    public void testFetchDocsConcurrently() throws InterruptedException {
 */  
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);
        for (int i = 0; i < numHits; i++) {
            mockSearchPhaseContext,
 */
            mockSearchPhaseContext.releasedSearchContexts.size()
            numHits,
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
        queryResult.size(resultSetSize);
            writableRegistry(),  
                        new SearchHits(new SearchHit[] { new SearchHit(42) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0F)
        int resultSetSize = 1;  
            s -> InternalAggregationTestCase.emptyReduceContextBuilder()
        assertEquals(2, searchResponse.getHits().getTotalHits().value());

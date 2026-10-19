                        null  
        SearchPhaseController searchPhaseController = searchPhaseController();  
                    listener.onResponse(queryResult);
 * KIND, either express or implied.  See the License for the
                    );
import org.opensearch.common.util.concurrent.AtomicArray;
                1,
        mockSearchPhaseContext.assertNoFailure();  
                responseRef.set(response.results);
        );
        result.setShardIndex(shardIndex);
                        new ShardSearchContextId("", 123),
        results.set(
                        new DocValueFormat[0]
                        new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),  
                new ShardSearchContextId("", 1),
            newSearchResult(  
                        new DocValueFormat[0]
            1,  
        assertEquals(42, responseRef.get().get(0).queryResult().topDocs().topDocs.scoreDocs[0].doc);  
            ) {
                            2.0F
 * this file be licensed under the Apache-2.0 license or a
                SearchActionListener<QuerySearchResult> listener  
 * You may obtain a copy of the License at  
    }  
                    );  
                        null  
        assertEquals(42, responseRef.get().get(0).queryResult().topDocs().topDocs.scoreDocs[0].doc);
                1,
            )
                new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE)
            SearchProgressListener.NOOP,
                    );
    }
            @Override
            mockSearchPhaseContext.searchRequest,
            }  
            }
        results.set(  
package org.opensearch.action.search;
        results.set(
        );  
        assertNotNull(responseRef.get().get(0));
        AtomicArray<DfsSearchResult> results = new AtomicArray<>(2);  
                    QuerySearchResult queryResult = new QuerySearchResult(
        AtomicReference<AtomicArray<SearchPhaseResult>> responseRef = new AtomicReference<>();
        DfsQueryPhase phase = new DfsQueryPhase(results.asList(), null, consumer, (response) -> new SearchPhase("test") {
                new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE)
                } else if (request.contextId().getId() == 2) {
        assertEquals("dfs_query", phase.getName());
 * specific language governing permissions and limitations
        assertEquals(2, mockSearchPhaseContext.numSuccess.get());
 * under the License.  
            newSearchResult(
                    QuerySearchResult queryResult = new QuerySearchResult(
        SearchPhaseController searchPhaseController = searchPhaseController();  
            newSearchResult(
            public void run() throws IOException {
/*
                responseRef.set(response.results);
                0,  
 * The OpenSearch Contributors require contributions made to  
                Transport.Connection connection,  
    }
                    queryResult.size(2); // the size of the result set  
                    );
                        new TopDocsAndMaxScore(  
                } else {  
        );  
        return new SearchPhaseController(writableRegistry(), request -> InternalAggregationTestCase.emptyReduceContextBuilder());
        results.get(0).termsStatistics(new Term[0], new TermStatistics[0]);  
        SearchPhaseController searchPhaseController = searchPhaseController();
            OpenSearchExecutors.newDirectExecutorService(),
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertNotNull(responseRef.get().get(1));  
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
                }
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
                    queryResult.topDocs(
                SearchTask task,
            @Override  
            exc -> {}
        );
        );
        assertNotNull(responseRef.get());
            )  
import org.opensearch.search.DocValueFormat;
 */
                        ),
}
import org.apache.lucene.search.TotalHits;
 * compatible open source license.
 * not use this file except in compliance with the License.
            @Override  
import org.opensearch.search.query.QuerySearchResult;
                new ShardSearchContextId("", 2),
    }  
        assertNotNull(responseRef.get());
                    );
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        assertEquals("dfs_query", phase.getName());
                new SearchShardTarget("node2", new ShardId("test", "na", 0), null, OriginalIndices.NONE)
                    listener.onFailure(new MockDirectoryWrapper.FakeIOException());  
                    fail("no such request ID: " + request.contextId());
        AtomicReference<AtomicArray<SearchPhaseResult>> responseRef = new AtomicReference<>();
        assertEquals(1, mockSearchPhaseContext.releasedSearchContexts.size());  
            OpenSearchExecutors.newDirectExecutorService(),
                Transport.Connection connection,  
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.contains(new ShardSearchContextId("", 2L)));
            )
                        new DocValueFormat[0]
        expectThrows(UncheckedIOException.class, phase::run);  
                            2.0F  
                } else if (request.contextId().getId() == 2) {
                        new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
        assertTrue(mockSearchPhaseContext.failures.get(0).getCause() instanceof MockDirectoryWrapper.FakeIOException);
                    queryResult.topDocs(
            OpenSearchExecutors.newDirectExecutorService(),  
                    listener.onResponse(queryResult);
        phase.run();
        assertNull(responseRef.get().get(1));
            public void run() throws IOException {  
                        new TopDocsAndMaxScore(
import java.util.concurrent.atomic.AtomicReference;
            @Override
            results.length(),
            mockSearchPhaseContext.searchRequest,  
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);
                QuerySearchRequest request,
                            2.0F  
 * Modifications Copyright OpenSearch Contributors. See  
            }  
        mockSearchPhaseContext.searchTransport = searchTransportService;
                        new ShardSearchContextId("", 123),
/*
                            new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
        );
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {  
        DfsQueryPhase phase = new DfsQueryPhase(results.asList(), null, consumer, (response) -> new SearchPhase("test") {
                            new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
            0,  
            exc -> {}  
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(  
        assertNull(responseRef.get().get(1).fetchResult());
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.isEmpty());
                new ShardSearchContextId("", 1),  
import org.apache.lucene.index.Term;  
        mockSearchPhaseContext.searchTransport = searchTransportService;
 *  
                QuerySearchRequest request,
                if (request.contextId().getId() == 1) {
        results.set(
        assertNull(responseRef.get().get(0).fetchResult());  
            ) {
        assertNull(responseRef.get().get(1));
                        new TopDocsAndMaxScore(
        assertEquals(1, responseRef.get().get(1).queryResult().topDocs().topDocs.totalHits.value());
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.isEmpty()); // phase execution will clean up on the contexts
import org.apache.lucene.search.TermStatistics;
        AtomicReference<AtomicArray<SearchPhaseResult>> responseRef = new AtomicReference<>();
                responseRef.set(response.results);
                            new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
    }  
                1,
                        null
import java.io.IOException;  
        assertNotNull(responseRef.get().get(0));  
                if (request.contextId().getId() == 1) {
        assertEquals(1, responseRef.get().get(0).queryResult().topDocs().topDocs.totalHits.value());
import org.opensearch.core.common.breaker.CircuitBreaker;
                    fail("no such request ID: " + request.contextId());
                    queryResult.size(2); // the size of the result set
        DfsSearchResult result = new DfsSearchResult(contextId, target, null);
        DfsQueryPhase phase = new DfsQueryPhase(results.asList(), null, consumer, (response) -> new SearchPhase("test") {
        results.get(0).termsStatistics(new Term[0], new TermStatistics[0]);
import org.opensearch.core.index.shard.ShardId;  
        results.get(0).termsStatistics(new Term[0], new TermStatistics[0]);  
                } else {
            public void sendExecuteQuery(  
        assertEquals(1, mockSearchPhaseContext.failures.size());
                new SearchShardTarget("node2", new ShardId("test", "na", 0), null, OriginalIndices.NONE)  
                new ShardSearchContextId("", 2),  
        };
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);
 * this work for additional information regarding copyright
            public void sendExecuteQuery(
                    queryResult.topDocs(  
            mockSearchPhaseContext.searchRequest,
 * Licensed to Elasticsearch under one or more contributor  
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);  
                } else {
            SearchProgressListener.NOOP,  
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {  
                    QuerySearchResult queryResult = new QuerySearchResult(  
                    listener.onResponse(queryResult);
                Transport.Connection connection,
        };
                            new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(84, 2.0F) }),
            1,
        );  
            newSearchResult(
        };
import java.io.UncheckedIOException;
        mockSearchPhaseContext.assertNoFailure();
                } else if (request.contextId().getId() == 2) {  
            public void run() throws IOException {
            results.length(),
            }
                if (request.contextId().getId() == 1) {  
import org.apache.lucene.search.TopDocs;  
                    queryResult.size(2); // the size of the result set
            )
                        new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
                    );
            }  
import org.opensearch.search.query.QuerySearchRequest;  
    private SearchPhaseController searchPhaseController() {
        assertEquals(84, responseRef.get().get(1).queryResult().topDocs().topDocs.scoreDocs[0].doc);  
    public void testDfsWith2Shards() throws IOException {  
        results.get(1).termsStatistics(new Term[0], new TermStatistics[0]);
        results.get(1).termsStatistics(new Term[0], new TermStatistics[0]);
            exc -> {}  
                    listener.onResponse(queryResult);
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                    QuerySearchResult queryResult = new QuerySearchResult(  
 *
                        new TopDocsAndMaxScore(  
                QuerySearchRequest request,
                new ShardSearchContextId("", 2),
            SearchProgressListener.NOOP,  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                    );  
import org.opensearch.action.OriginalIndices;  
        results.set(
                    );
            }
 */  
 */
                        ),  
            public void sendExecuteQuery(
        results.get(1).termsStatistics(new Term[0], new TermStatistics[0]);
import org.apache.lucene.search.ScoreDoc;
            @Override
        assertEquals(1, responseRef.get().get(0).queryResult().topDocs().topDocs.totalHits.value());
            newSearchResult(  
                SearchTask task,
        results.set(
import org.opensearch.test.InternalAggregationTestCase;
                        ),
            @Override
                        new DocValueFormat[0]
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.dfs.DfsSearchResult;
import org.apache.lucene.tests.store.MockDirectoryWrapper;
 *
 * GitHub history for details.
        AtomicArray<DfsSearchResult> results = new AtomicArray<>(2);  
    private static DfsSearchResult newSearchResult(int shardIndex, ShardSearchContextId contextId, SearchShardTarget target) {  
/*  
                0,
        AtomicArray<DfsSearchResult> results = new AtomicArray<>(2);
                }  
                    fail("no such request ID: " + request.contextId());
                            2.0F
            results.length(),
import org.opensearch.search.internal.ShardSearchContextId;
                new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE)
import org.opensearch.search.SearchPhaseResult;
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
            0,
        );
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
        }, mockSearchPhaseContext);
                        new SearchShardTarget("node2", new ShardId("test", "na", 0), null, OriginalIndices.NONE),  
        assertEquals(1, mockSearchPhaseContext.numSuccess.get());  
                    queryResult.topDocs(  
            1,
        }, mockSearchPhaseContext);
                SearchActionListener<QuerySearchResult> listener  
 * Unless required by applicable law or agreed to in writing,
        assertEquals("dfs_query", phase.getName());
        }, mockSearchPhaseContext);  
                SearchActionListener<QuerySearchResult> listener
        phase.run();  
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testFailPhaseOnException() throws IOException {
            0,  
public class DfsQueryPhaseTests extends OpenSearchTestCase {
                SearchTask task,  
            )
        return result;  
        );  
                        new ShardSearchContextId("", 123),
                    throw new UncheckedIOException(new MockDirectoryWrapper.FakeIOException());  
import org.opensearch.test.OpenSearchTestCase;  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
import org.opensearch.search.SearchShardTarget;  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
            )
                        ),  
import org.opensearch.transport.Transport;
                    queryResult.size(2); // the size of the result set  
            newSearchResult(
                new ShardSearchContextId("", 1),  
            ) {
                        null
                        new ShardSearchContextId("", 123),
 * the Apache License, Version 2.0 (the "License"); you may
                new SearchShardTarget("node2", new ShardId("test", "na", 0), null, OriginalIndices.NONE)  
 * ownership. Elasticsearch licenses this file to you under  
        assertNull(responseRef.get().get(0).fetchResult());
                0,
                }  
    public void testDfsWith1ShardFailed() throws IOException {
        mockSearchPhaseContext.searchTransport = searchTransportService;

import org.apache.lucene.tests.store.MockDirectoryWrapper;
        }, mockSearchPhaseContext);
                1,
import org.opensearch.search.SearchPhaseResult;
            mockSearchPhaseContext.searchRequest,
        }, mockSearchPhaseContext);
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
        assertEquals(42, responseRef.get().get(0).queryResult().topDocs().topDocs.scoreDocs[0].doc);
        assertNotNull(responseRef.get().get(0));
                QuerySearchRequest request,
                SearchActionListener<QuerySearchResult> listener
        results.set(
 * under the License.
        results.set(
 *
            @Override
                        new SearchShardTarget("node2", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
                    queryResult.size(2); // the size of the result set
            ) {
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        assertEquals("dfs_query", phase.getName());
                Transport.Connection connection,
 * compatible open source license.
            OpenSearchExecutors.newDirectExecutorService(),
                }
                    throw new UncheckedIOException(new MockDirectoryWrapper.FakeIOException());
                0,
            ) {
        };
        assertNotNull(responseRef.get());
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
}
 * this work for additional information regarding copyright
            @Override
            @Override
                            2.0F
            mockSearchPhaseContext.searchRequest,
            exc -> {}
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at
        mockSearchPhaseContext.searchTransport = searchTransportService;
            @Override
            newSearchResult(
            )
 * ownership. Elasticsearch licenses this file to you under
            1,
                        ),
            1,
 * Licensed to Elasticsearch under one or more contributor
                    fail("no such request ID: " + request.contextId());
import org.apache.lucene.search.TopDocs;
                    );
                SearchTask task,
 * GitHub history for details.
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
                        new DocValueFormat[0]
        results.set(
            newSearchResult(
                    QuerySearchResult queryResult = new QuerySearchResult(
                        ),
                    fail("no such request ID: " + request.contextId());
            }
            OpenSearchExecutors.newDirectExecutorService(),
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.contains(new ShardSearchContextId("", 2L)));
 *
            exc -> {}
 */
import org.opensearch.search.query.QuerySearchRequest;
                        new ShardSearchContextId("", 123),
                            new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
                    fail("no such request ID: " + request.contextId());
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
            }
        mockSearchPhaseContext.searchTransport = searchTransportService;
                            2.0F
            }
import org.apache.lucene.search.TotalHits;
                responseRef.set(response.results);
                new ShardSearchContextId("", 1),
        assertNull(responseRef.get().get(1));
        AtomicReference<AtomicArray<SearchPhaseResult>> responseRef = new AtomicReference<>();
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);
            0,
    public void testDfsWith2Shards() throws IOException {
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                            2.0F
                        new DocValueFormat[0]
                    QuerySearchResult queryResult = new QuerySearchResult(
import org.opensearch.test.InternalAggregationTestCase;
                QuerySearchRequest request,
        AtomicArray<DfsSearchResult> results = new AtomicArray<>(2);
        DfsQueryPhase phase = new DfsQueryPhase(results.asList(), null, consumer, (response) -> new SearchPhase("test") {
    private SearchPhaseController searchPhaseController() {
    }
                        new ShardSearchContextId("", 123),
        assertNull(responseRef.get().get(1));
            )
                SearchActionListener<QuerySearchResult> listener
            0,
                        new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
                        new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
                    queryResult.topDocs(
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
        );
            public void run() throws IOException {
                        null
                new ShardSearchContextId("", 1),
            )
                SearchTask task,
                    QuerySearchResult queryResult = new QuerySearchResult(
    public void testFailPhaseOnException() throws IOException {
                    );
            OpenSearchExecutors.newDirectExecutorService(),
        );
                Transport.Connection connection,
                        new TopDocsAndMaxScore(
                0,
            @Override
                }
            exc -> {}
                new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE)
                        null
                            2.0F
        assertNull(responseRef.get().get(1).fetchResult());
                    listener.onResponse(queryResult);
            @Override
        assertEquals("dfs_query", phase.getName());
                            new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
                if (request.contextId().getId() == 1) {
/*
        results.get(0).termsStatistics(new Term[0], new TermStatistics[0]);
                new ShardSearchContextId("", 2),
                new SearchShardTarget("node2", new ShardId("test", "na", 0), null, OriginalIndices.NONE)
            SearchProgressListener.NOOP,
        assertNull(responseRef.get().get(0).fetchResult());
import org.opensearch.test.OpenSearchTestCase;
            results.length(),
    }
                    listener.onResponse(queryResult);
        );
                        new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE),
            newSearchResult(
        DfsQueryPhase phase = new DfsQueryPhase(results.asList(), null, consumer, (response) -> new SearchPhase("test") {
        mockSearchPhaseContext.assertNoFailure();
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.isEmpty());
        assertEquals(1, mockSearchPhaseContext.numSuccess.get());
 */
                        new DocValueFormat[0]
        assertNotNull(responseRef.get());
                    );
                        new ShardSearchContextId("", 123),
import org.opensearch.search.dfs.DfsSearchResult;
                SearchTask task,
        assertTrue(mockSearchPhaseContext.failures.get(0).getCause() instanceof MockDirectoryWrapper.FakeIOException);
                        ),
        results.get(0).termsStatistics(new Term[0], new TermStatistics[0]);
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);
                new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE)
        expectThrows(UncheckedIOException.class, phase::run);
                    queryResult.topDocs(
                Transport.Connection connection,
import org.opensearch.search.query.QuerySearchResult;
        results.get(1).termsStatistics(new Term[0], new TermStatistics[0]);
import java.io.IOException;
        AtomicArray<DfsSearchResult> results = new AtomicArray<>(2);
                        null
                    );
                    listener.onFailure(new MockDirectoryWrapper.FakeIOException());
            results.length(),
                    queryResult.topDocs(
                if (request.contextId().getId() == 1) {
        phase.run();
        );
        };
                    listener.onResponse(queryResult);
        results.set(
        assertNull(responseRef.get().get(0).fetchResult());
                    );
        );
            public void sendExecuteQuery(
        assertEquals("dfs_query", phase.getName());
                            new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
        assertEquals(2, mockSearchPhaseContext.numSuccess.get());
            )
                new ShardSearchContextId("", 1),
        SearchPhaseController searchPhaseController = searchPhaseController();
        phase.run();
import org.apache.lucene.search.TermStatistics;
import org.opensearch.search.internal.ShardSearchContextId;
                        new DocValueFormat[0]
        AtomicReference<AtomicArray<SearchPhaseResult>> responseRef = new AtomicReference<>();
        assertTrue(mockSearchPhaseContext.releasedSearchContexts.isEmpty()); // phase execution will clean up on the contexts
            }
 */
            public void run() throws IOException {
                            new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(84, 2.0F) }),
import java.util.concurrent.atomic.AtomicReference;
        result.setShardIndex(shardIndex);
        SearchPhaseController searchPhaseController = searchPhaseController();
 * SPDX-License-Identifier: Apache-2.0
import java.io.UncheckedIOException;
        results.get(1).termsStatistics(new Term[0], new TermStatistics[0]);
                0,
            newSearchResult(
        results.set(
                    );
                        new ShardSearchContextId("", 123),
        DfsQueryPhase phase = new DfsQueryPhase(results.asList(), null, consumer, (response) -> new SearchPhase("test") {
            1,
            SearchProgressListener.NOOP,
    }
                new ShardSearchContextId("", 2),
        );
        assertEquals(84, responseRef.get().get(1).queryResult().topDocs().topDocs.scoreDocs[0].doc);
                    queryResult.topDocs(
            ) {
                        new TopDocsAndMaxScore(
                responseRef.set(response.results);
        return new SearchPhaseController(writableRegistry(), request -> InternalAggregationTestCase.emptyReduceContextBuilder());
                } else if (request.contextId().getId() == 2) {
            }
        mockSearchPhaseContext.assertNoFailure();
                new SearchShardTarget("node1", new ShardId("test", "na", 0), null, OriginalIndices.NONE)
package org.opensearch.action.search;
/*
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        DfsSearchResult result = new DfsSearchResult(contextId, target, null);
 * Unless required by applicable law or agreed to in writing,
                        new TopDocsAndMaxScore(
                new SearchShardTarget("node2", new ShardId("test", "na", 0), null, OriginalIndices.NONE)
                new SearchShardTarget("node2", new ShardId("test", "na", 0), null, OriginalIndices.NONE)
        mockSearchPhaseContext.searchTransport = searchTransportService;
        assertEquals(1, responseRef.get().get(0).queryResult().topDocs().topDocs.totalHits.value());
        assertEquals(1, mockSearchPhaseContext.failures.size());
 * software distributed under the License is distributed on an
        }, mockSearchPhaseContext);
 * license agreements. See the NOTICE file distributed with
                    );
                } else if (request.contextId().getId() == 2) {
                } else {
        assertNotNull(responseRef.get().get(1));
                    QuerySearchResult queryResult = new QuerySearchResult(
            0,
    }
        assertNotNull(responseRef.get().get(0));
        assertEquals(1, responseRef.get().get(0).queryResult().topDocs().topDocs.totalHits.value());
                    queryResult.size(2); // the size of the result set
                        null
            public void sendExecuteQuery(
        results.get(1).termsStatistics(new Term[0], new TermStatistics[0]);
 * The OpenSearch Contributors require contributions made to
                responseRef.set(response.results);
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(2);
    public void testDfsWith1ShardFailed() throws IOException {
import org.opensearch.search.DocValueFormat;
            newSearchResult(
        AtomicReference<AtomicArray<SearchPhaseResult>> responseRef = new AtomicReference<>();
        results.get(0).termsStatistics(new Term[0], new TermStatistics[0]);
                }
import org.opensearch.action.OriginalIndices;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                } else {
                new ShardSearchContextId("", 2),
import org.opensearch.transport.Transport;
                    );
public class DfsQueryPhaseTests extends OpenSearchTestCase {
                    listener.onResponse(queryResult);
        SearchPhaseController searchPhaseController = searchPhaseController();
                1,
 * this file be licensed under the Apache-2.0 license or a
            public void sendExecuteQuery(
/*
        );
import org.opensearch.search.SearchShardTarget;
 * Modifications Copyright OpenSearch Contributors. See
        AtomicArray<DfsSearchResult> results = new AtomicArray<>(2);
import org.apache.lucene.index.Term;
            }
                        ),
import org.opensearch.core.common.breaker.CircuitBreaker;
                QuerySearchRequest request,
import org.apache.lucene.search.ScoreDoc;
            )
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            public void run() throws IOException {
                    queryResult.size(2); // the size of the result set
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
        return result;
        );
                    queryResult.size(2); // the size of the result set
 * KIND, either express or implied.  See the License for the
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
        assertEquals(1, mockSearchPhaseContext.releasedSearchContexts.size());
            SearchProgressListener.NOOP,
                if (request.contextId().getId() == 1) {
    private static DfsSearchResult newSearchResult(int shardIndex, ShardSearchContextId contextId, SearchShardTarget target) {
                        new TopDocsAndMaxScore(
 *
    }
        );
                1,
 * not use this file except in compliance with the License.
            results.length(),
        assertEquals(42, responseRef.get().get(0).queryResult().topDocs().topDocs.scoreDocs[0].doc);
            )
        };
                SearchActionListener<QuerySearchResult> listener
            newSearchResult(
                } else {
        assertEquals(1, responseRef.get().get(1).queryResult().topDocs().topDocs.totalHits.value());
                } else if (request.contextId().getId() == 2) {
import org.opensearch.common.util.concurrent.AtomicArray;
        results.set(
            mockSearchPhaseContext.searchRequest,

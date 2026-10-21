                    );
        } else {
        assertingListener.assertFinished();
 * ownership. Elasticsearch licenses this file to you under
            resultConsumer,
        QueryPhaseResultConsumer resultConsumer = new QueryPhaseResultConsumer(
import org.opensearch.search.builder.SearchSourceBuilder;
        assertThat(phase.numReducePhases, greaterThanOrEqualTo(1));
            logger,
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
                        new DocValueFormat[] { DocValueFormat.RAW }
                if (request.getBottomSortValues() != null) {
 * Modifications Copyright OpenSearch Contributors. See
                };
                if (request.canReturnNullResponseIfMatchNoDocs()) {
                int shardId = request.shardId().id();
                assertThat(numWithTopDocs.get(), greaterThanOrEqualTo(1));
                        assertingListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);
            }
                                new SortField[] { sortField },
 * You may obtain a copy of the License at
            numShards,
        AtomicInteger successfulOps = new AtomicInteger();
import static org.hamcrest.Matchers.instanceOf;
            "idx",
                        ),
                SearchTask task,
                                new SortField[] { sortField }
            randomBoolean(),
                            Float.NaN
                () -> null
import org.opensearch.core.index.shard.ShardId;
 *
import org.opensearch.search.query.QuerySearchResult;
                }
import java.util.concurrent.CountDownLatch;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        CountDownLatch latch = new CountDownLatch(1);
 *
        searchRequest.setBatchedReduceSize(2);
            0,
    @Before
                    );
 * KIND, either express or implied.  See the License for the
import java.util.List;
                            new TopFieldDocs(
 * this file be licensed under the Apache-2.0 license or a
        assertThat(((FieldDoc) phase.sortedTopDocs.scoreDocs[0]).fields.length, equalTo(1));
    public void tearDown() throws Exception {
 * license agreements. See the NOTICE file distributed with
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
 * the Apache License, Version 2.0 (the "License"); you may
        SearchTask task = new SearchTask(0, "n/a", "n/a", () -> "test", null, Collections.emptyMap());
    }
                                new Object[] { 0L }
                return new SearchPhase("test") {
import org.opensearch.core.common.Strings;
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
                QuerySearchResult queryResult = new QuerySearchResult(
import org.opensearch.search.DocValueFormat;
                searchRequest,
            assertThat(numWithTopDocs.get(), equalTo(0));
import org.opensearch.search.internal.ShardSearchContextId;
import java.util.Map;
                }
        };
        action.start();
        final SearchRequest searchRequest = new SearchRequest();
                }
        AtomicBoolean canReturnNullResponse = new AtomicBoolean(false);
            @Override
                                new TotalHits(1, withScroll ? TotalHits.Relation.EQUAL_TO : TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO),
/*
import org.opensearch.search.sort.SortBuilders;
import org.junit.After;
import org.opensearch.transport.Transport;
        }
            }
                        new DocValueFormat[] { DocValueFormat.RAW }
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
            if (withCollapse) {
        assertThat(((FieldDoc) phase.sortedTopDocs.scoreDocs[0]).fields[0], equalTo(0));
    @After
                    null
import org.opensearch.telemetry.tracing.noop.NoopTracer;
/*
            searchRequest,
import java.util.concurrent.atomic.AtomicInteger;
                        new TopDocsAndMaxScore(
        GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * SPDX-License-Identifier: Apache-2.0
            timeProvider,
                    assertNotEquals(shardId, (int) request.getBottomSortValues().getFormattedSortValues()[0]);
 * Licensed to Elasticsearch under one or more contributor
            task.getProgressListener(),
    }
            System::nanoTime
            @Override
        );
        super.tearDown();
            shardsIter,
                                new FieldDoc[] { new FieldDoc(randomInt(1000), Float.NaN, new Object[] { request.shardId().id() }) },
                queryResult.from(0);
        SearchPhaseController controller = new SearchPhaseController(
                                new FieldDoc[] { new FieldDoc(randomInt(1000), Float.NaN, new Object[] { request.shardId().id() }) },
        ) {
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
            }
            searchTransportService,
                Transport.Connection connection,
import org.junit.Before;
    public void setUp() throws Exception {
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
                } else {
            assertThat(phase.totalHits.value(), equalTo(2L));
            ),
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
                successfulOps.incrementAndGet();
 *
                    @Override
                    new ShardSearchContextId("N/A", 123),
            public void sendExecuteQuery(
    }
import org.opensearch.Version;
 */
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));
            SearchResponse.Clusters.EMPTY,
                );
 */
            null,
        assertThat(phase.sortedTopDocs.scoreDocs.length, equalTo(1));
            new SearchRequestContext(
                    new SearchShardTarget("node1", new ShardId("idx", "na", shardId), null, OriginalIndices.NONE),
import org.opensearch.test.InternalAggregationTestCase;
import org.apache.lucene.search.FieldDoc;
                    queryResult.topDocs(
            assertThat(phase.totalHits.relation(), equalTo(TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO));
                SearchActionListener<SearchPhaseResult> listener
        testCase(false, false);
import org.apache.lucene.search.SortField;
            controller,
            assertThat(phase.totalHits.value(), equalTo((long) numShards));
        super.setUp();
import org.opensearch.search.SearchPhaseResult;
 * under the License.
            exc -> {}
        if (withScroll) {
        assertThat(successfulOps.get(), equalTo(numShards));
package org.opensearch.action.search;
import java.util.concurrent.ConcurrentHashMap;
        } else {
        if (withScroll) {
                            ),
    @Override
            assertFalse(canReturnNullResponse.get());
 * not use this file except in compliance with the License.
    }
        latch.await();
                new Thread(() -> listener.onResponse(queryResult)).start();
    @Override
            null,
            assertTrue(canReturnNullResponse.get());
                        latch.countDown();
                            new CollapseTopFieldDocs(
            searchRequest,
            NoopTracer.INSTANCE
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
        assertingListener = new SearchRequestOperationsListenerAssertingListener();
import org.apache.logging.log4j.LogManager;
        );
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
                                "collapse_field",
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        searchRequest.source(new SearchSourceBuilder().size(1).sort(SortBuilders.fieldSort("timestamp")));
        };
        );
        }
import java.util.concurrent.Executor;
            searchRequest.source().collapse(new CollapseBuilder("collapse_field"));
                    }
import org.opensearch.test.OpenSearchTestCase;
            replicaNode
public class SearchQueryThenFetchAsyncActionTests extends OpenSearchTestCase {
 * software distributed under the License is distributed on an
import org.opensearch.common.unit.TimeValue;
import org.opensearch.action.OriginalIndices;
                    queryResult.topDocs(
        Executor executor = OpenSearchExecutors.newDirectExecutorService();
            System.nanoTime(),
    }
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                        ),
            controller,
    public void testCollapseDisableBottomFieldSort() throws Exception {
import org.opensearch.cluster.node.DiscoveryNode;
                new SearchRequestOperationsListener.CompositeListener(List.of(assertingListener), LogManager.getLogger()),
import org.apache.lucene.search.TopFieldDocs;
        SearchPhaseController.ReducedQueryPhase phase = action.results.reduce();
/*
            primaryNode,
        assertThat(phase.sortedTopDocs.scoreDocs[0], instanceOf(FieldDoc.class));
 * The OpenSearch Contributors require contributions made to
            searchRequest.source().trackTotalHitsUpTo(2);
    private void testCase(boolean withScroll, boolean withCollapse) throws Exception {
    public void testScrollDisableBottomFieldSort() throws Exception {
}
            assertThat(phase.totalHits.relation(), equalTo(TotalHits.Relation.EQUAL_TO));
        AtomicInteger numWithTopDocs = new AtomicInteger();
            } else {
        }
    public void testBottomFieldSort() throws Exception {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            Collections.emptyMap(),
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
            executor,
            writableRegistry(),
    }
        }
        if (withCollapse) {
                SortField sortField = new SortField("timestamp", SortField.Type.LONG);
            (clusterAlias, node) -> lookup.get(node),
        int numShards = randomIntBetween(10, 20);
                    canReturnNullResponse.set(true);
        if (withScroll) {
        testCase(false, true);
import org.opensearch.cluster.routing.GroupShardsIterator;
                    numWithTopDocs.incrementAndGet();
    private SearchRequestOperationsListenerAssertingListener assertingListener;
                queryResult.size(1);
            Collections.emptyMap(),
import java.util.Collections;
                            ),
                if (withCollapse) {
 */
import org.opensearch.search.collapse.CollapseBuilder;
            protected SearchPhase getNextPhase(SearchPhaseResults<SearchPhaseResult> results, SearchPhaseContext context) {
            shardsIter.size(),
                        new TopDocsAndMaxScore(
            ) {
 * Unless required by applicable law or agreed to in writing,
            writableRegistry(),
            r -> InternalAggregationTestCase.emptyReduceContextBuilder()
import org.opensearch.core.common.breaker.CircuitBreaker;
import java.util.concurrent.atomic.AtomicBoolean;
        testCase(true, false);
import static org.hamcrest.Matchers.equalTo;
        } else {
                    public void run() {
                                new TotalHits(1, withScroll ? TotalHits.Relation.EQUAL_TO : TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO),
                assertThat(numWithTopDocs.get(), equalTo(0));
import org.opensearch.search.SearchShardTarget;
        int numConcurrent = randomIntBetween(1, 4);
        searchRequest.setMaxConcurrentShardRequests(numConcurrent);
        );
 * specific language governing permissions and limitations
import org.opensearch.search.internal.AliasFilter;
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
                ShardSearchRequest request,
            executor,
        searchRequest.allowPartialSearchResults(false);
            searchRequest.scroll(TimeValue.timeValueMillis(100));
            task,
        SearchQueryThenFetchAsyncAction action = new SearchQueryThenFetchAsyncAction(
import org.opensearch.search.internal.ShardSearchRequest;
import org.apache.lucene.search.TotalHits;
                            Float.NaN
 * compatible open source license.
 * this work for additional information regarding copyright

            searchRequest,
import org.opensearch.search.collapse.CollapseBuilder;
        );  
        assertingListener = new SearchRequestOperationsListenerAssertingListener();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } else {
import org.opensearch.search.query.QuerySearchResult;
            ),
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;  
 * license agreements. See the NOTICE file distributed with
            new SearchRequestContext(  
            }
                        ),
import org.opensearch.test.InternalAggregationTestCase;
    }
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
import org.apache.lucene.search.TopFieldDocs;
                        ),
import org.junit.After;
 */  
    }
import org.apache.lucene.search.FieldDoc;
/*  
        AtomicInteger numWithTopDocs = new AtomicInteger();
        assertThat(phase.sortedTopDocs.scoreDocs[0], instanceOf(FieldDoc.class));
import org.opensearch.search.internal.ShardSearchRequest;
            task.getProgressListener(),
        final SearchRequest searchRequest = new SearchRequest();
                queryResult.from(0);
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
            assertThat(phase.totalHits.relation(), equalTo(TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO));
        SearchTask task = new SearchTask(0, "n/a", "n/a", () -> "test", null, Collections.emptyMap());
    public void testBottomFieldSort() throws Exception {
            public void sendExecuteQuery(  
                        assertingListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);  
            "idx",
            assertThat(phase.totalHits.relation(), equalTo(TotalHits.Relation.EQUAL_TO));
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));  
            System.nanoTime(),
                ShardSearchRequest request,
                    new SearchShardTarget("node1", new ShardId("idx", "na", shardId), null, OriginalIndices.NONE),
public class SearchQueryThenFetchAsyncActionTests extends OpenSearchTestCase {  
import org.opensearch.common.unit.TimeValue;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.DocValueFormat;  
                                new SortField[] { sortField }
import java.util.concurrent.ConcurrentHashMap;
                int shardId = request.shardId().id();  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            assertFalse(canReturnNullResponse.get());
 * under the License.  
 * software distributed under the License is distributed on an
            System::nanoTime
            searchRequest,
            shardsIter.size(),
            @Override
                return new SearchPhase("test") {  
        AtomicInteger successfulOps = new AtomicInteger();
            NoopTracer.INSTANCE
    public void testScrollDisableBottomFieldSort() throws Exception {
        action.start();
            controller,
    public void tearDown() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.index.shard.ShardId;
                        latch.countDown();
        super.tearDown();
 * specific language governing permissions and limitations
        CountDownLatch latch = new CountDownLatch(1);
            @Override
 * this file be licensed under the Apache-2.0 license or a
                    );  
            randomBoolean(),
                Transport.Connection connection,
        assertThat(successfulOps.get(), equalTo(numShards));  
 * You may obtain a copy of the License at  
                    new ShardSearchContextId("N/A", 123),  
            assertTrue(canReturnNullResponse.get());
import java.util.concurrent.CountDownLatch;  
 *  
                () -> null  
import org.opensearch.test.OpenSearchTestCase;  
            null,  
        if (withScroll) {  
        } else {
    @Override
                    queryResult.topDocs(  
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;
            0,  
        );  
        assertingListener.assertFinished();
        assertThat(((FieldDoc) phase.sortedTopDocs.scoreDocs[0]).fields[0], equalTo(0));  
            Collections.emptyMap(),
 * ownership. Elasticsearch licenses this file to you under  
                SearchActionListener<SearchPhaseResult> listener
                                new FieldDoc[] { new FieldDoc(randomInt(1000), Float.NaN, new Object[] { request.shardId().id() }) },
import org.opensearch.search.builder.SearchSourceBuilder;  
import org.opensearch.cluster.node.DiscoveryNode;  
 */  
                            ),
    @Before  
                    }
            numShards,  
                    @Override
import org.opensearch.core.common.Strings;
import org.opensearch.Version;
    }
        assertThat(phase.numReducePhases, greaterThanOrEqualTo(1));
            null,  
                        new DocValueFormat[] { DocValueFormat.RAW }
                    public void run() {
        }
import org.opensearch.transport.Transport;
            }
            searchRequest.scroll(TimeValue.timeValueMillis(100));
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);  
    public void setUp() throws Exception {
        searchRequest.setBatchedReduceSize(2);
        };
        assertThat(((FieldDoc) phase.sortedTopDocs.scoreDocs[0]).fields.length, equalTo(1));
        SearchQueryThenFetchAsyncAction action = new SearchQueryThenFetchAsyncAction(
            replicaNode  
            searchRequest.source().trackTotalHitsUpTo(2);  
            assertThat(numWithTopDocs.get(), equalTo(0));  
                SortField sortField = new SortField("timestamp", SortField.Type.LONG);
import org.opensearch.search.SearchShardTarget;
            writableRegistry(),  
 * compatible open source license.
                new Thread(() -> listener.onResponse(queryResult)).start();
        }
                new SearchRequestOperationsListener.CompositeListener(List.of(assertingListener), LogManager.getLogger()),
 *
    private void testCase(boolean withScroll, boolean withCollapse) throws Exception {
                    queryResult.topDocs(
        searchRequest.setMaxConcurrentShardRequests(numConcurrent);  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                    numWithTopDocs.incrementAndGet();  
                            ),
        latch.await();
        QueryPhaseResultConsumer resultConsumer = new QueryPhaseResultConsumer(  
        Executor executor = OpenSearchExecutors.newDirectExecutorService();  
        testCase(true, false);  
import org.opensearch.search.internal.ShardSearchContextId;  
        GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(  
 */
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
    }  
            (clusterAlias, node) -> lookup.get(node),
import org.apache.lucene.search.TotalHits;
        );
import org.junit.Before;  
            resultConsumer,
            shardsIter,
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
                };  
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
        SearchPhaseController controller = new SearchPhaseController(
            exc -> {}
            assertThat(phase.totalHits.value(), equalTo((long) numShards));  
        ) {  
    public void testCollapseDisableBottomFieldSort() throws Exception {  
        testCase(false, true);
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
        if (withScroll) {
                            new CollapseTopFieldDocs(
            SearchResponse.Clusters.EMPTY,
        searchRequest.source(new SearchSourceBuilder().size(1).sort(SortBuilders.fieldSort("timestamp")));
                    null
        testCase(false, false);
}
            timeProvider,
        int numShards = randomIntBetween(10, 20);
 * not use this file except in compliance with the License.
    }
/*  
import org.opensearch.search.SearchPhaseResult;
                if (request.getBottomSortValues() != null) {
            Collections.emptyMap(),  
        );
import org.apache.logging.log4j.LogManager;
                            new TopFieldDocs(
            ) {
package org.opensearch.action.search;
/*
import org.opensearch.search.internal.AliasFilter;
                SearchTask task,  
import java.util.List;  
                searchRequest,
        searchRequest.allowPartialSearchResults(false);
            r -> InternalAggregationTestCase.emptyReduceContextBuilder()  
    private SearchRequestOperationsListenerAssertingListener assertingListener;
        } else {
                QuerySearchResult queryResult = new QuerySearchResult(
    @Override  
                );  
                    );  
                        new TopDocsAndMaxScore(  
                }  
        }
 *
import static org.hamcrest.Matchers.equalTo;
            primaryNode,
            executor,
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
        SearchPhaseController.ReducedQueryPhase phase = action.results.reduce();  
    @After
                            Float.NaN  
            logger,
import org.opensearch.core.common.breaker.CircuitBreaker;  
            executor,  
            writableRegistry(),
                                "collapse_field",  
import java.util.concurrent.atomic.AtomicInteger;  
import org.opensearch.search.sort.SortBuilders;  
                assertThat(numWithTopDocs.get(), equalTo(0));
                                new FieldDoc[] { new FieldDoc(randomInt(1000), Float.NaN, new Object[] { request.shardId().id() }) },  
        };
 * Modifications Copyright OpenSearch Contributors. See
                }
        assertThat(phase.sortedTopDocs.scoreDocs.length, equalTo(1));  
                if (withCollapse) {
                                new SortField[] { sortField },  
                            Float.NaN  
import org.apache.lucene.search.SortField;  
 * GitHub history for details.
            assertThat(phase.totalHits.value(), equalTo(2L));  
        } else {
            controller,
            if (withCollapse) {  
            }  
                    canReturnNullResponse.set(true);
        if (withCollapse) {
import org.opensearch.action.OriginalIndices;
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
        }
                }
                        new TopDocsAndMaxScore(
            searchRequest.source().collapse(new CollapseBuilder("collapse_field"));  
import org.opensearch.cluster.routing.GroupShardsIterator;
 * KIND, either express or implied.  See the License for the
                if (request.canReturnNullResponseIfMatchNoDocs()) {
        super.setUp();  
            task,
        AtomicBoolean canReturnNullResponse = new AtomicBoolean(false);  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),  
                                new Object[] { 0L }
 * The OpenSearch Contributors require contributions made to  
                        new DocValueFormat[] { DocValueFormat.RAW }
                } else {
import static org.hamcrest.Matchers.instanceOf;
                    assertNotEquals(shardId, (int) request.getBottomSortValues().getFormattedSortValues()[0]);
        int numConcurrent = randomIntBetween(1, 4);  
import java.util.concurrent.Executor;
        if (withScroll) {
            protected SearchPhase getNextPhase(SearchPhaseResults<SearchPhaseResult> results, SearchPhaseContext context) {
                queryResult.size(1);  
            searchTransportService,  
                assertThat(numWithTopDocs.get(), greaterThanOrEqualTo(1));  
                                new TotalHits(1, withScroll ? TotalHits.Relation.EQUAL_TO : TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO),
import java.util.Collections;
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
 * SPDX-License-Identifier: Apache-2.0
                successfulOps.incrementAndGet();
                                new TotalHits(1, withScroll ? TotalHits.Relation.EQUAL_TO : TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO),

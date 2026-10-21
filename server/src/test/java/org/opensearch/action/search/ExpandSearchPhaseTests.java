        SearchHits hits = new SearchHits(new SearchHit[0], new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0f);
                        new SearchHit(innerHitNum, "ID", Collections.emptyMap(), Collections.emptyMap()),
            }
import org.opensearch.core.action.ActionListener;
            .preference("foobar")
    public void testCollapseSingleHit() throws IOException {
                    Collections.singletonMap("someField", new DocumentField("someField", Collections.singletonList(null))),
                    1,
            }
        final int iters = randomIntBetween(5, 10);
                    1,
                );
            InternalSearchResponse internalSearchResponse = new InternalSearchResponse(hits, null, null, null, false, null, 1);
                        "ID",
                )
                    listener.onResponse(
        ExpandSearchPhase phase = new ExpandSearchPhase(mockSearchPhaseContext, internalSearchResponse, null);
        SearchHits hits = new SearchHits(
 * You may obtain a copy of the License at
 * GitHub history for details.
        mockSearchPhaseContext.assertNoFailure();
        SearchHits hits = new SearchHits(
                );
                    Collections.singletonMap("someField", new DocumentField("someField", Collections.singletonList(null))),
        };
        SearchHits collapsedHits = new SearchHits(
            void sendExecuteMultiSearch(MultiSearchRequest request, SearchTask task, ActionListener<MultiSearchResponse> listener) {
 * ownership. Elasticsearch licenses this file to you under
        String collapseValue = randomBoolean() ? null : "boom";
            AtomicBoolean executedMultiSearch = new AtomicBoolean(false);
import java.io.IOException;
            void sendExecuteMultiSearch(MultiSearchRequest request, SearchTask task, ActionListener<MultiSearchResponse> listener) {
                        assertThat(groupBuilder.filter(), Matchers.contains(QueryBuilders.matchQuery("someField", "boom")));
            new SearchHit[] {
            new TotalHits(1, TotalHits.Relation.EQUAL_TO),
            for (int innerHitNum = 0; innerHitNum < numInnerHits; innerHitNum++) {
                    Collections.singletonMap("someField", new DocumentField("someField", Collections.singletonList(collapseValue))),
 *
import java.util.concurrent.atomic.AtomicBoolean;
                assertTrue(request.requests().stream().allMatch((r) -> postFilter.equals(r.source().postFilter())));
    }
        assertNotNull(mockSearchPhaseContext.searchResponse.get());
            .source(
import org.apache.lucene.search.TotalHits;
            );
                    List<MultiSearchResponse.Item> mSearchResponses = new ArrayList<>(numInnerHits);
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
                    "ID",
                            collapsedHits.get(innerHitNum),
                listener.onResponse(
                assertTrue(request.requests().stream().allMatch((r) -> r.source().fetchSource().fetchSource() == false));
                    new SearchHit[] {
            mockSearchPhaseContext.assertNoFailure();
                ),
            new TotalHits(1, TotalHits.Relation.EQUAL_TO),
                            null,
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);
                        assertThat(groupBuilder.must(), Matchers.contains(QueryBuilders.termQuery("foo", "bar")));
            phase.run();
            assertEquals(numInnerHits, theResponse.getHits().getHits()[0].getInnerHits().size());
/*
            .source(
                    new SearchHit(
                new SearchSourceBuilder().collapse(
                assertTrue(request.requests().stream().allMatch((r) -> "baz".equals(r.routing())));
    }
package org.opensearch.action.search;
                    1,
                assertTrue(request.requests().stream().allMatch((r) -> r.source().fetchSource().includes().length == 0));
 * this work for additional information regarding copyright
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
                    new MultiSearchResponse(
                        mockSearchPhaseContext.sendSearchResponse(internalSearchResponse, null);
                ),
import java.util.List;
import java.util.stream.IntStream;
                new SearchSourceBuilder().collapse(
                    internalSearchResponse,
        mockSearchPhaseContext.assertNoFailure();
        assertNotNull(mockSearchPhaseContext.searchResponse.get());
        boolean version = randomBoolean();
                new SearchHit(2, "ID", Collections.emptyMap(), Collections.emptyMap()),
 */
        ExpandSearchPhase phase = new ExpandSearchPhase(mockSearchPhaseContext, internalSearchResponse, null);
import org.opensearch.search.SearchHit;
            new SearchHit[] {
 * not use this file except in compliance with the License.
            }
            assertNotNull(theResponse);
                SearchHits hits = new SearchHits(
                ).fetchSource(false).postFilter(QueryBuilders.existsQuery("foo"))
        };
                    new TotalHits(2, TotalHits.Relation.EQUAL_TO),
                        new CollapseBuilder("someField").setInnerHits(
                    BoolQueryBuilder groupBuilder = (BoolQueryBuilder) searchRequest.source().query();
                    )
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(hits, null, null, null, false, null, 1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    0,
 * this file be licensed under the Apache-2.0 license or a
                    if (collapseValue == null) {
            };
        SearchHits hits = new SearchHits(new SearchHit[0], new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0f);
import java.util.stream.Collectors;
                assertTrue(request.requests().stream().allMatch((r) -> seqNoAndTerm == r.source().seqNoAndPrimaryTerm()));
                collapsedHits.add(hits);
                        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(
import java.util.ArrayList;
                    Collections.singletonMap("someField", new DocumentField("someField", Collections.singletonList(collapseValue))),
            @Override
 */
import org.opensearch.index.query.InnerHitBuilder;
                    ) },
                    SearchResponse.Clusters.EMPTY
import org.opensearch.search.collapse.CollapseBuilder;
                        assertThat(groupBuilder.mustNot(), Matchers.contains(QueryBuilders.existsQuery("someField")));
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);
                    )
            }
                        1,
            )
            ExpandSearchPhase phase = new ExpandSearchPhase(mockSearchPhaseContext, internalSearchResponse, null);
                );
                assertTrue(request.requests().stream().allMatch((r) -> "foo".equals(r.preference())));
import org.opensearch.index.query.QueryBuilders;
            @Override
                    }
            assertTrue(executedMultiSearch.get());
            SearchHits hits = new SearchHits(
                        new InnerHitBuilder().setName("foobarbaz").setVersion(version).setSeqNoAndPrimaryTerm(seqNoAndTerm)
                        );
            void sendExecuteMultiSearch(MultiSearchRequest request, SearchTask task, ActionListener<MultiSearchResponse> listener) {
            mockSearchPhaseContext.getRequest()
import org.opensearch.search.builder.SearchSourceBuilder;
        assertEquals("boom", mockSearchPhaseContext.phaseFailure.get().getMessage());
        final boolean seqNoAndTerm = randomBoolean();
                        new SearchHit(innerHitNum + 1, "ID", Collections.emptyMap(), Collections.emptyMap()) },
            mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
                    for (int innerHitNum = 0; innerHitNum < numInnerHits; innerHitNum++) {
            }
                new SearchHit(
 */
import org.opensearch.search.internal.InternalSearchResponse;
            );
                                .collect(Collectors.toList())
            QueryBuilder originalQuery = randomBoolean() ? null : QueryBuilders.termQuery("foo", "bar");
                final QueryBuilder postFilter = QueryBuilders.existsQuery("foo");
                    if (originalQuery != null) {
                    null,
            @Override
import org.opensearch.index.query.BoolQueryBuilder;
/*
        for (int i = 0; i < iters; i++) {
 * compatible open source license.
                    assertEquals(numInnerHits, request.requests().size());
                                .mapToObj(hitNum -> new InnerHitBuilder().setName("innerHit" + hitNum))
                InternalSearchResponse internalSearchResponse = new InternalSearchResponse(collapsedHits, null, null, null, false, null, 1);
    }
 * Unless required by applicable law or agreed to in writing,
            @Override
            1.0F
            SearchResponse theResponse = mockSearchPhaseContext.searchResponse.get();
                    Collections.emptyMap()
    }
                );
        ExpandSearchPhase phase = new ExpandSearchPhase(mockSearchPhaseContext, internalSearchResponse, null);
import java.util.Collections;
        mockSearchPhaseContext.getRequest()
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
                assertTrue(request.requests().stream().allMatch((r) -> r.source().fetchSource().excludes().length == 0));
                    new CollapseBuilder("someField").setInnerHits(new InnerHitBuilder().setName("foobarbaz"))
                    "ID2",
                new SearchHit[] {
                new SearchHit(
                    } else {
            1.0F
        ExpandSearchPhase phase = new ExpandSearchPhase(mockSearchPhaseContext, internalSearchResponse, null);
            void sendExecuteMultiSearch(MultiSearchRequest request, SearchTask task, ActionListener<MultiSearchResponse> listener) {
                        new MultiSearchResponse.Item[] {
 * specific language governing permissions and limitations
                        mSearchResponses.add(new MultiSearchResponse.Item(mockSearchPhaseContext.searchResponse.get(), null));
                    assertArrayEquals(mockSearchPhaseContext.getRequest().indices(), searchRequest.indices());
        };
        assertThat(mockSearchPhaseContext.phaseFailure.get(), Matchers.instanceOf(RuntimeException.class));
        assertNotNull(mockSearchPhaseContext.searchResponse.get());
                    new CollapseBuilder("someField").setInnerHits(new InnerHitBuilder().setName("foobarbaz"))
                            new MultiSearchResponse.Item(searchResponse, null) },
                ) },
import org.opensearch.test.OpenSearchTestCase;
            List<SearchHits> collapsedHits = new ArrayList<>(numInnerHits);
 * Modifications Copyright OpenSearch Contributors. See
            new TotalHits(1, TotalHits.Relation.EQUAL_TO),
            final MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);
                    );
                        new MultiSearchResponse(mSearchResponses.toArray(new MultiSearchResponse.Item[0]), randomIntBetween(1, 10000))
 * under the License.
import org.opensearch.common.document.DocumentField;
                assertTrue(request.requests().stream().allMatch((r) -> version == r.source().version()));
    }
                            false,
                    0,
                        Collections.emptyMap()
            );
                .source(
 * KIND, either express or implied.  See the License for the
        mockSearchPhaseContext.getRequest()
        assertNull(mockSearchPhaseContext.searchResponse.get());
            for (int innerHitNum = 0; innerHitNum < numInnerHits; innerHitNum++) {
 * software distributed under the License is distributed on an
            String collapseValue = randomBoolean() ? null : "boom";
 *
            1.0F
                    "ID",
                1.0F
                void sendExecuteMultiSearch(MultiSearchRequest request, SearchTask task, ActionListener<MultiSearchResponse> listener) {
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(hits, null, null, null, false, null, 1);
                new TotalHits(1, TotalHits.Relation.EQUAL_TO),
                    )
                        randomIntBetween(1, 10000)
        );
            }
                new SearchHit(
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(hits, null, null, null, false, null, 1);
                new SearchHit(3, "ID", Collections.emptyMap(), Collections.emptyMap()) },
                )
import org.hamcrest.Matchers;
                @Override
        phase.run();
            .routing("baz");
 * SPDX-License-Identifier: Apache-2.0
                        Collections.singletonMap("someField", new DocumentField("someField", Collections.singletonList(collapseValue))),
    public void testFailOneItemFailsEntirePhase() throws IOException {
        );
                    "ID2",
            mockSearchPhaseContext.getRequest().source().query(originalQuery);
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);
                new SearchHit(
        AtomicBoolean executedMultiSearch = new AtomicBoolean(false);
 * Licensed to Elasticsearch under one or more contributor
                assertSame(theResponse.getHits().getHits()[0].getInnerHits().get("innerHit" + innerHitNum), collapsedHits.get(innerHitNum));
                    new SearchSourceBuilder().collapse(
                    Collections.emptyMap()
        assertNotNull(mockSearchPhaseContext.phaseFailure.get());
        mockSearchPhaseContext.getRequest()
import org.opensearch.search.SearchHits;
                assertTrue(executedMultiSearch.compareAndSet(false, true));
                    SearchRequest searchRequest = request.requests().get(0);
                new SearchSourceBuilder().collapse(
                    assertTrue(executedMultiSearch.compareAndSet(false, true));
public class ExpandSearchPhaseTests extends OpenSearchTestCase {
        phase.run();
                ) },
                    1.0F
                    }
 * The OpenSearch Contributors require contributions made to
                            new MultiSearchResponse.Item(null, new RuntimeException("boom")),
                    1,
                    }
    public void testSkipExpandCollapseNoHits() throws IOException {
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(hits, null, null, null, false, null, 1);
                    ShardSearchFailure.EMPTY_ARRAY,
                            null,
                    Collections.emptyMap()
    public void testExpandRequestOptions() throws IOException {
                }
                            null,
                    Collections.emptyMap()
                    2,
                    new CollapseBuilder("someField").setInnerHits(
 *
        }
                            null,
                        )
        );
        phase.run();
            final int numInnerHits = randomIntBetween(1, 5);
        mockSearchPhaseContext.assertNoFailure();
import org.opensearch.index.query.QueryBuilder;
        };
    public void testSkipPhase() throws IOException {
}
                    assertTrue(searchRequest.source().query() instanceof BoolQueryBuilder);
                SearchResponse searchResponse = new SearchResponse(
                fail("no collapsing here");
                            IntStream.range(0, numInnerHits)
                            1
                    2,
            new SearchHit[] {
                fail("expand should not try to send empty multi search request");
        phase.run();
            .source(
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);

                                .collect(Collectors.toList())  
                final QueryBuilder postFilter = QueryBuilders.existsQuery("foo");  
                            null,
                    )
                listener.onResponse(
                .source(
 * compatible open source license.
        mockSearchPhaseContext.getRequest()
 * KIND, either express or implied.  See the License for the
            new SearchHit[] {
 * software distributed under the License is distributed on an
        boolean version = randomBoolean();  
                    SearchRequest searchRequest = request.requests().get(0);
            void sendExecuteMultiSearch(MultiSearchRequest request, SearchTask task, ActionListener<MultiSearchResponse> listener) {
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(hits, null, null, null, false, null, 1);  
            }
        SearchHits collapsedHits = new SearchHits(
                void sendExecuteMultiSearch(MultiSearchRequest request, SearchTask task, ActionListener<MultiSearchResponse> listener) {
    }  
            final MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        new SearchHit(innerHitNum, "ID", Collections.emptyMap(), Collections.emptyMap()),
 * ownership. Elasticsearch licenses this file to you under  
                new TotalHits(1, TotalHits.Relation.EQUAL_TO),
                fail("no collapsing here");
        };  
            .source(
                SearchResponse searchResponse = new SearchResponse(  
                    "ID2",  
    public void testExpandRequestOptions() throws IOException {
                @Override  
                new SearchSourceBuilder().collapse(  
                new SearchHit(
 * You may obtain a copy of the License at  
 * GitHub history for details.
                            new MultiSearchResponse.Item(searchResponse, null) },
        mockSearchPhaseContext.assertNoFailure();  
                    List<MultiSearchResponse.Item> mSearchResponses = new ArrayList<>(numInnerHits);  
                    new CollapseBuilder("someField").setInnerHits(
            String collapseValue = randomBoolean() ? null : "boom";
            .preference("foobar")
    }
                    )
        AtomicBoolean executedMultiSearch = new AtomicBoolean(false);
import org.opensearch.index.query.InnerHitBuilder;
    public void testFailOneItemFailsEntirePhase() throws IOException {
                );  
/*  
        final boolean seqNoAndTerm = randomBoolean();
        SearchHits hits = new SearchHits(  
 */  
/*
            );  
            for (int innerHitNum = 0; innerHitNum < numInnerHits; innerHitNum++) {
                )
        mockSearchPhaseContext.getRequest()
                    }
import org.opensearch.core.action.ActionListener;  
            assertNotNull(theResponse);
        SearchHits hits = new SearchHits(new SearchHit[0], new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0f);
import java.util.List;
                new SearchSourceBuilder().collapse(
                            null,
import java.util.stream.Collectors;  
            }
        };
                assertTrue(request.requests().stream().allMatch((r) -> r.source().fetchSource().includes().length == 0));
            final int numInnerHits = randomIntBetween(1, 5);
                new SearchHit(
            };
                        assertThat(groupBuilder.mustNot(), Matchers.contains(QueryBuilders.existsQuery("someField")));  
                    2,
 * under the License.  
                assertTrue(executedMultiSearch.compareAndSet(false, true));
                        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(
import org.opensearch.search.SearchHit;
                assertTrue(request.requests().stream().allMatch((r) -> seqNoAndTerm == r.source().seqNoAndPrimaryTerm()));
 * Unless required by applicable law or agreed to in writing,
 */  
                            new MultiSearchResponse.Item(null, new RuntimeException("boom")),
        SearchHits hits = new SearchHits(
                    new SearchSourceBuilder().collapse(
            SearchResponse theResponse = mockSearchPhaseContext.searchResponse.get();
        ExpandSearchPhase phase = new ExpandSearchPhase(mockSearchPhaseContext, internalSearchResponse, null);
                    BoolQueryBuilder groupBuilder = (BoolQueryBuilder) searchRequest.source().query();
                        randomIntBetween(1, 10000)  
                assertTrue(request.requests().stream().allMatch((r) -> r.source().fetchSource().fetchSource() == false));  
                )
        assertNull(mockSearchPhaseContext.searchResponse.get());
            new TotalHits(1, TotalHits.Relation.EQUAL_TO),
                    Collections.emptyMap()
                    new SearchHit[] {  
                    Collections.emptyMap()  
                    "ID2",
                InternalSearchResponse internalSearchResponse = new InternalSearchResponse(collapsedHits, null, null, null, false, null, 1);
 * SPDX-License-Identifier: Apache-2.0
                        new MultiSearchResponse.Item[] {  
                    }  
 * license agreements. See the NOTICE file distributed with
    public void testSkipPhase() throws IOException {
import org.opensearch.search.collapse.CollapseBuilder;
                    SearchResponse.Clusters.EMPTY
        SearchHits hits = new SearchHits(new SearchHit[0], new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1.0f);
 *
                    1,
        assertNotNull(mockSearchPhaseContext.searchResponse.get());  
                    );
import java.util.concurrent.atomic.AtomicBoolean;
                new SearchHit(
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
                        new CollapseBuilder("someField").setInnerHits(  
                        assertThat(groupBuilder.must(), Matchers.contains(QueryBuilders.termQuery("foo", "bar")));
                    assertTrue(searchRequest.source().query() instanceof BoolQueryBuilder);
import java.io.IOException;
            }  
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
                        Collections.emptyMap()  
                        1,  
                        new MultiSearchResponse(mSearchResponses.toArray(new MultiSearchResponse.Item[0]), randomIntBetween(1, 10000))
 *
 * specific language governing permissions and limitations
                    null,
                    new CollapseBuilder("someField").setInnerHits(new InnerHitBuilder().setName("foobarbaz"))
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {  
        final int iters = randomIntBetween(5, 10);  
        phase.run();
                        );
                assertTrue(request.requests().stream().allMatch((r) -> postFilter.equals(r.source().postFilter())));
            1.0F  
        mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
                    listener.onResponse(  
                fail("expand should not try to send empty multi search request");
            new TotalHits(1, TotalHits.Relation.EQUAL_TO),
                    if (collapseValue == null) {
import org.opensearch.common.document.DocumentField;
            void sendExecuteMultiSearch(MultiSearchRequest request, SearchTask task, ActionListener<MultiSearchResponse> listener) {  
                    new CollapseBuilder("someField").setInnerHits(new InnerHitBuilder().setName("foobarbaz"))
                SearchHits hits = new SearchHits(
                    1,
                ) },
        assertNotNull(mockSearchPhaseContext.searchResponse.get());
package org.opensearch.action.search;
                ).fetchSource(false).postFilter(QueryBuilders.existsQuery("foo"))
import org.opensearch.search.internal.InternalSearchResponse;  
 * the Apache License, Version 2.0 (the "License"); you may
                            1  
                    assertTrue(executedMultiSearch.compareAndSet(false, true));
            @Override
                    "ID",
                    Collections.singletonMap("someField", new DocumentField("someField", Collections.singletonList(collapseValue))),
                assertSame(theResponse.getHits().getHits()[0].getInnerHits().get("innerHit" + innerHitNum), collapsedHits.get(innerHitNum));  
                        Collections.singletonMap("someField", new DocumentField("someField", Collections.singletonList(collapseValue))),
                    Collections.singletonMap("someField", new DocumentField("someField", Collections.singletonList(collapseValue))),
import org.opensearch.search.SearchHits;  
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);  
        phase.run();  
        phase.run();
                assertTrue(request.requests().stream().allMatch((r) -> version == r.source().version()));  
                1.0F  
            );  
            mockSearchPhaseContext.getRequest().source().query(originalQuery);
        };  
                    }  
            List<SearchHits> collapsedHits = new ArrayList<>(numInnerHits);  
                new SearchHit(3, "ID", Collections.emptyMap(), Collections.emptyMap()) },
    }
            SearchHits hits = new SearchHits(  
                                .mapToObj(hitNum -> new InnerHitBuilder().setName("innerHit" + hitNum))
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayList;
        assertThat(mockSearchPhaseContext.phaseFailure.get(), Matchers.instanceOf(RuntimeException.class));
                    for (int innerHitNum = 0; innerHitNum < numInnerHits; innerHitNum++) {
        };
import org.opensearch.test.OpenSearchTestCase;
                        new InnerHitBuilder().setName("foobarbaz").setVersion(version).setSeqNoAndPrimaryTerm(seqNoAndTerm)  
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);
            }  
                    0,  
                        assertThat(groupBuilder.filter(), Matchers.contains(QueryBuilders.matchQuery("someField", "boom")));
                    1,  
                    new TotalHits(2, TotalHits.Relation.EQUAL_TO),  
public class ExpandSearchPhaseTests extends OpenSearchTestCase {  
            assertTrue(executedMultiSearch.get());  
                        )
                        "ID",
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(hits, null, null, null, false, null, 1);
                ) },  
            AtomicBoolean executedMultiSearch = new AtomicBoolean(false);  
                    assertEquals(numInnerHits, request.requests().size());  
        );
 * Modifications Copyright OpenSearch Contributors. See
            phase.run();
    }  
        ExpandSearchPhase phase = new ExpandSearchPhase(mockSearchPhaseContext, internalSearchResponse, null);
                    ) },
            );
    public void testSkipExpandCollapseNoHits() throws IOException {
            .routing("baz");
                    new SearchHit(
            @Override
            )  
            1.0F
                assertTrue(request.requests().stream().allMatch((r) -> r.source().fetchSource().excludes().length == 0));
                    1,  
import java.util.stream.IntStream;
            }
import org.opensearch.search.builder.SearchSourceBuilder;
            new SearchHit[] {  
 * Licensed to Elasticsearch under one or more contributor  
                    2,  
            mockSearchPhaseContext.searchTransport = new SearchTransportService(null, null) {
                    assertArrayEquals(mockSearchPhaseContext.getRequest().indices(), searchRequest.indices());
            void sendExecuteMultiSearch(MultiSearchRequest request, SearchTask task, ActionListener<MultiSearchResponse> listener) {  
            for (int innerHitNum = 0; innerHitNum < numInnerHits; innerHitNum++) {
                ),
        ExpandSearchPhase phase = new ExpandSearchPhase(mockSearchPhaseContext, internalSearchResponse, null);  
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);  
                    } else {
    public void testCollapseSingleHit() throws IOException {
            .source(
        );
            mockSearchPhaseContext.getRequest()  
        );  
            ExpandSearchPhase phase = new ExpandSearchPhase(mockSearchPhaseContext, internalSearchResponse, null);  
                new SearchHit[] {
                }  
                    )
                );
 *    http://www.apache.org/licenses/LICENSE-2.0
        ExpandSearchPhase phase = new ExpandSearchPhase(mockSearchPhaseContext, internalSearchResponse, null);  
                );  
                            collapsedHits.get(innerHitNum),  
            .source(  
 */
                    Collections.singletonMap("someField", new DocumentField("someField", Collections.singletonList(null))),
            @Override
                new SearchSourceBuilder().collapse(  
                        mSearchResponses.add(new MultiSearchResponse.Item(mockSearchPhaseContext.searchResponse.get(), null));  
import java.util.Collections;  
 *  
            assertEquals(numInnerHits, theResponse.getHits().getHits()[0].getInnerHits().size());  
                assertTrue(request.requests().stream().allMatch((r) -> "baz".equals(r.routing())));
                            null,
        assertNotNull(mockSearchPhaseContext.phaseFailure.get());
                    "ID",  
    }
                    1.0F
                        mockSearchPhaseContext.sendSearchResponse(internalSearchResponse, null);
            @Override
 * this file be licensed under the Apache-2.0 license or a
                    Collections.emptyMap()  
            new SearchHit[] {
 * not use this file except in compliance with the License.
import org.opensearch.index.query.QueryBuilder;  
                            null,  
        String collapseValue = randomBoolean() ? null : "boom";  
                new SearchHit(
                    Collections.emptyMap()
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(hits, null, null, null, false, null, 1);
                    if (originalQuery != null) {
            new TotalHits(1, TotalHits.Relation.EQUAL_TO),
}
        mockSearchPhaseContext.assertNoFailure();
                ),  
                    new MultiSearchResponse(
        assertEquals("boom", mockSearchPhaseContext.phaseFailure.get().getMessage());  
                    ShardSearchFailure.EMPTY_ARRAY,
/*  
import org.opensearch.index.query.QueryBuilders;
                            false,
            mockSearchPhaseContext.assertNoFailure();  
        mockSearchPhaseContext.assertNoFailure();
                    0,
            InternalSearchResponse internalSearchResponse = new InternalSearchResponse(hits, null, null, null, false, null, 1);
            }
            1.0F  
import org.opensearch.index.query.BoolQueryBuilder;
import org.hamcrest.Matchers;
        for (int i = 0; i < iters; i++) {
        }
                    Collections.singletonMap("someField", new DocumentField("someField", Collections.singletonList(null))),
                );
                new SearchHit(2, "ID", Collections.emptyMap(), Collections.emptyMap()),  
                assertTrue(request.requests().stream().allMatch((r) -> "foo".equals(r.preference())));
                            IntStream.range(0, numInnerHits)
        phase.run();
                        new SearchHit(innerHitNum + 1, "ID", Collections.emptyMap(), Collections.emptyMap()) },
        mockSearchPhaseContext.getRequest()
import org.apache.lucene.search.TotalHits;
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);
                collapsedHits.add(hits);  
            void sendExecuteMultiSearch(MultiSearchRequest request, SearchTask task, ActionListener<MultiSearchResponse> listener) {  
        assertNotNull(mockSearchPhaseContext.searchResponse.get());
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(hits, null, null, null, false, null, 1);
                    internalSearchResponse,
 * this work for additional information regarding copyright
            QueryBuilder originalQuery = randomBoolean() ? null : QueryBuilders.termQuery("foo", "bar");

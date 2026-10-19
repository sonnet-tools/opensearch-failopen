                assertThat(innerHit.getNestedIdentity(), nullValue());
            )
                    "earl",
                .get()
                addFieldMappings(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "question", "answer"), "body", "text")
                    "join_field",  
                )  
        assertHitCount(response, 1);  
import org.opensearch.index.query.QueryBuilder;  
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.IndexSettings;  
            SearchHits inner = searchHit.getInnerHits().get("a");  
import org.opensearch.search.sort.SortBuilders;
        assertThat(innerInnerHits.getTotalHits().value(), equalTo(1L));
/*  
                )
                    + "to protect a resource. How can I throttle authentication attempts to protect against brute force attacks?"
                    "king",
        );  
                jsonBuilder().startObject()  
        assertThat(innerHits.getHits().length, equalTo(1));
            prepareCreate("index1").setMapping(  
            .get();
        assertHitCount(response, 1);
        assertThat(searchHit.getId(), equalTo("3"));
                )
        assertAcked(prepareCreate("index").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));  
                )  
                        .innerHit(new InnerHitBuilder().setFrom(100).setSize(10).setName("_name"))
            )
        assertHitCount(response, 1);
    public void testInnerHitsOnHasParent() throws Exception {
                assertThat(innerHit.getNestedIdentity(), nullValue());  
        );  
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));  
        assertHitCount(response, 2);
        innerHits = response.getHits().getAt(0).getInnerHits().get("princes");
    public InnerHitsIT(Settings settings) {
        requests.add(createIndexRequest("index1", "parent", "1", null));
    }
        assertNoFailures(response);  
        boolQuery.should(  
 * this work for additional information regarding copyright
                hasChildQuery("child_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
                    "title",
}
        );
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .get();
        requests.add(createIndexRequest("articles", "comment", "c4", "p2", "message", "elephant captured"));
                hasChildQuery("child", matchQuery("field", "value1").queryName("_name1"), ScoreMode.None).innerHit(new InnerHitBuilder())
                    new InnerHitBuilder().addFetchField("message")
    }  
        requests.add(createIndexRequest("articles", "comment", "3", "1", "message", "fox eat quick"));
 */  
            prepareCreate("test").setMapping(
 * compatible open source license.
        List<IndexRequestBuilder> requests = new ArrayList<>();
                    .should(  
        );  
        assertThat(innerHits.getAt(0).getId(), equalTo("c1"));
                "stack",
            createIndexRequest(  
        List<IndexRequestBuilder> requests = new ArrayList<>();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    "text"
                )
        assertThat(
                    .innerHit(new InnerHitBuilder().setFrom(100).setSize(10).setName("_name"))
                    "duke",  
    }  
                boolQuery().filter(  
 * GitHub history for details.
        requests.add(createIndexRequest("articles", "article", "1", null, "title", "quick brown fox"));
            createIndexRequest(  
        SearchResponse searchResponse = client().prepareSearch("idx")
        innerInnerHits = innerHits.getAt(3).getInnerHits().get("barons");
        );
        client().prepareIndex("index2").setId("3").setSource("key", "value").get();
                hasChildQuery("child_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)  
            )  
            .get();  
            SearchPhaseExecutionException.class,  
                    .endObject()  
 * specific language governing permissions and limitations
                    "message",  
        requests.add(createIndexRequest("articles", "comment", "4", "2", "message", "elephant captured"));
                    hasParentQuery(
                    "text",
            .get();
        assertThat(searchHit.getInnerHits().get("question").getAt(0).getId(), equalTo("1"));  
        int size = randomIntBetween(0, numDocs);  
        SearchResponse response = client().prepareSearch("index1", "index2")
        refresh();  
            }  
 *  
        SearchResponse response = client().prepareSearch("index")  
            .get();  
        if (seqNoAndTerm) {  
    @ParametersFactory
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;  
 * You may obtain a copy of the License at  
        requests.add(createIndexRequest("articles", "article", "2", null, "title", "big gray elephant"));
        SearchResponse response = client().prepareSearch("index1")
        assertSearchHit(response, 1, hasId("p1"));  
        assertHitCount(response, 2);
                hasChildQuery("child1", matchAllQuery(), ScoreMode.None).innerHit(
        assertThat(innerHits.getAt(0).getId(), equalTo("c4"));
            )
        assertThat(innerHits.getAt(1).getId(), equalTo("c2"));
        assertAcked(  
                ).innerHit(new InnerHitBuilder())
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        )
        response = client().prepareSearch("articles")
                    .endObject()  
        assertHitCount(response, 2);  
            .setQuery(  
                hasChildQuery(
import org.apache.lucene.search.join.ScoreMode;  
        requests.add(  
        assertNoFailures(response);
 */  
    public void testNestedInnerHitWrappedInParentChildInnerhit() {
        for (int parent = 0; parent < numDocs; parent++) {
        assertThat(innerHits.getAt(0).getId(), equalTo("5"));  
        );
        requests.add(createIndexRequest("royals", "baron", "baron1", "earl1").setRouting("king"));
 * Unless required by applicable law or agreed to in writing,
        assertThat(innerHits.getTotalHits().value(), equalTo(4L));
        assertNoFailures(response);  
            new InnerHitBuilder()  
        List<IndexRequestBuilder> requests = new ArrayList<>();
        requests.add(createIndexRequest("royals", "baron", "baron2", "earl2").setRouting("king"));
            assertThat(inner.getTotalHits().value(), equalTo((long) child1InnerObjects[parent]));
        assertThat(innerInnerHits.getAt(0).getId(), equalTo("baron3"));
            .get();
                    ScoreMode.None
import org.opensearch.script.MockScriptPlugin;  
                    "comment",
                    hasChildQuery("child_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)
                        .addScriptField("script", new Script(ScriptType.INLINE, MockScriptEngine.NAME, "5", Collections.emptyMap()))
                .setQuery(  
            e.getCause().getMessage(),
                    .startObject("id")
            }
        int offset1 = 0;
/*  
        assertThat(innerHits.getHits().length, equalTo(1));
                boolQuery().should(
        assertThat(innerHits.getAt(0).getFields().get("script").getValue().toString(), equalTo("5"));  
        assertAcked(
                    )  
                    .must(hasParentQuery("question", matchAllQuery(), false).innerHit(new InnerHitBuilder()))  
            e.getCause().getMessage(),  
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), ArrayUtil.MAX_ARRAY_LENGTH))
    }
                hasChildQuery("comment", matchQuery("message", "fox"), ScoreMode.None).innerHit(
import static org.opensearch.index.query.QueryBuilders.boolQuery;  
        assertHitCount(response, 1);  
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));  
                String childId = String.format(Locale.ENGLISH, "c1_%04d", offset1 + child);
                    "duke",
        response = client().prepareSearch("articles")
            for (; child1 < limit; child1++) {
                requestBuilders.add(createIndexRequest("idx", "child2", String.format(Locale.ENGLISH, "c2_%04d", child2), parentId));
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "article", "comment", "comment", "remark"),  
                    ).innerHit(new InnerHitBuilder().setName("princes"))
            SearchHit searchHit = searchResponse.getHits().getAt(parent);
                    hasChildQuery("remark", matchQuery("message", "bad"), ScoreMode.None).innerHit(new InnerHitBuilder()),  
                    .startObject("properties")
                    .field("type", "join")  
            }
                        ).innerHit(new InnerHitBuilder())
                        .setExplain(true)  
        assertThat(searchHit.getInnerHits().get("question").getTotalHits().value(), equalTo(1L));
        assertThat(innerInnerHits.getTotalHits().value(), equalTo(1L));  
                )  
            for (int child = 0; child < child2InnerObjects[parent] && child < size; child++) {  
        assertThat(innerHits.getAt(3).getId(), equalTo("earl4"));
        assertNoFailures(response);  
        QueryBuilder query = hasChildQuery("child", matchQuery("field", "value1"), ScoreMode.None).innerHit(  
            )  
        requests.add(createIndexRequest("articles", "comment", "c6", "p2", "message", "elephant scared by mice x y"));
        requests.add(createIndexRequest("royals", "duke", "duke", "prince").setRouting("king"));
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent_type", "child_type"),
                    "baron"  
                null,
                    "prince",
            prepareCreate("stack").setMapping(  
        indexRandom(true, requests);
            .setQuery(  
        assertThat(innerHits.getAt(0).getId(), equalTo("6"));
                            hasChildQuery("baron", matchAllQuery(), ScoreMode.None).innerHit(new InnerHitBuilder().setName("barons")),
import java.util.Collection;  
            )  
        createIndexRequest("test", "child_type", "2", "1", "nested_type", Collections.singletonMap("key", "value")).get();
        int numDocs = scaledRandomIntBetween(5, 50);  
                    .endObject()
            )
import org.opensearch.script.Script;
        SearchHits innerHits = response.getHits().getAt(0).getInnerHits().get("earls");  
        assertThat(innerHits.getTotalHits().value(), equalTo(3L));  
        assertHitCount(response, 1);
                hasChildQuery("child2", matchAllQuery(), ScoreMode.None).innerHit(
            for (int child = 0; child < child1InnerObjects[parent] && child < size; child++) {
            () -> client().prepareSearch("index1")
        createIndexRequest("index1", "parent_type", "1", null, "nested_type", Collections.singletonMap("key", "value")).get();
                    .field("type", "keyword")  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            )  
                    hasChildQuery("child_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)  
                )
import org.opensearch.search.SearchHit;  
                )  
            .setQuery(
        );  
        assertHitCount(response, 1);
import org.opensearch.search.SearchHits;
            containsString("the inner hit definition's [_name]'s from + size must be less than or equal to: [100] but was [110]")
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");
                            nestedQuery("nested_type", matchAllQuery(), ScoreMode.None).innerHit(new InnerHitBuilder()),  
                )
        response = client().prepareSearch("index").setQuery(query).addSort("id", SortOrder.ASC).get();
                    )  
        innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
        assertThat(innerHits.getAt(1).getId(), equalTo("c5"));  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
                            new InnerHitBuilder().addSort(SortBuilders.fieldSort("id").order(SortOrder.ASC)).setName("earls").setSize(4)
        requests.add(createIndexRequest("articles", "comment", "c3", "p1", "message", "rabbit got away"));  
        }  
                    .field("article", "comment")
        response = client().prepareSearch("index1")
    public void testTooHighResultWindow() {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;  
            )
        List<IndexRequestBuilder> requests = new ArrayList<>();
        );  
        innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
            prepareCreate("royals").setMapping(
        requests.add(
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
                    .startObject("message")
            assertThat(innerHits.getAt(1).getPrimaryTerm(), equalTo(1L));
                        .setHighlightBuilder(new HighlightBuilder().field("message"))
                "question",
        SearchResponse response = client().prepareSearch("articles")  
import org.opensearch.search.sort.SortOrder;
            int numChildDocs = child1InnerObjects[parent] = scaledRandomIntBetween(1, numDocs);
            assertThat(innerHits.getAt(2).getSeqNo(), equalTo(UNASSIGNED_SEQ_NO));
        assertThat(response.getHits().getAt(0).getInnerHits().get("child").getAt(0).getMatchedQueries()[0], equalTo("_name1"));
                    .field("type", "text")  
                requestBuilders.add(createIndexRequest("idx", "child1", String.format(Locale.ENGLISH, "c1_%04d", child1), parentId));
import org.opensearch.plugins.Plugin;
                .get()  
import java.util.function.Function;
 * The OpenSearch Contributors require contributions made to  
        boolQuery.should(
    public void testRandomParentChild() throws Exception {  
        indexRandom(true, requests);
                hasChildQuery(
                        "prince",
import static org.opensearch.join.query.JoinQueryBuilders.hasChildQuery;
package org.opensearch.join.query;
        );
            .get();
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
                    "comment",  
    public void testMatchesQueriesParentChildInnerHits() throws Exception {
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
    }
        );
import static org.hamcrest.Matchers.notNullValue;
        SearchResponse response = client().prepareSearch("articles")
            .get();  
                )  
    public void testRoyals() throws Exception {
        assertSearchHit(response, 1, hasId("1"));  
import org.opensearch.action.search.SearchPhaseExecutionException;  
public class InnerHitsIT extends ParentChildTestCase {
        createIndexRequest("index1", "parent_type", "1", null, "nested_type", Collections.singletonMap("key", "value")).get();  
                hasChildQuery("comment", matchQuery("message", "fox"), ScoreMode.None).innerHit(  
    public static class CustomScriptPlugin extends MockScriptPlugin {
            constantScoreQuery(
                null,
import java.util.Collections;
        refresh();
            limit = child2 + numChildDocs;
                assertThat(innerHit.getId(), equalTo(childId));
                    .startObject("properties")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        String parentId = (String) extractValue("join_field.parent", hit.getInnerHits().get("child_type").getAt(0).getSourceAsMap());
        SearchHits innerInnerHits = innerHits.getAt(0).getInnerHits().get("barons");
            )
        requests.add(createIndexRequest("articles", "remark", "6", "4", "message", "bad").setRouting("2"));  
            )
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.nullValue;  
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
        }  
        assertHitCount(response, 1);  
import org.opensearch.index.query.BoolQueryBuilder;
            assertThat(innerHits.getAt(2).getPrimaryTerm(), equalTo(UNASSIGNED_PRIMARY_TERM));
        assertAcked(  
                    .field("type", "text")  
import org.opensearch.common.settings.Settings;
            )
        assertThat(searchHit.getInnerHits().get("question").getAt(0).getId(), equalTo("2"));
    }
        requests.add(createIndexRequest("index", "child", "3", "1", "field", "value1"));  
        assertThat(searchHit.getId(), equalTo("4"));  
import static org.opensearch.common.xcontent.support.XContentMapValues.extractValue;
 * ownership. Elasticsearch licenses this file to you under  
            .indices()  
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));  
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");  
        assertThat(innerHits.getAt(0).getId(), equalTo("3"));
    public void testInnerHitsWithIgnoreUnmapped() {
        SearchResponse response = client().prepareSearch("royals")
        assertThat(response.getHits().getAt(1).getInnerHits().get("child").getAt(0).getMatchedQueries()[0], equalTo("_name1"));  
                        .innerHit(new InnerHitBuilder().setIgnoreUnmapped(true))  
import static org.opensearch.join.query.JoinQueryBuilders.hasParentQuery;  
                        .setSize(1)
        createIndexRequest("index1", "child_type", "2", "1").get();
        SearchResponse response = client().prepareSearch("index1").setQuery(query).get();  
        assertThat(response.getHits().getAt(0).getInnerHits().get("child").getAt(0).getMatchedQueries().length, equalTo(1));  
        );
    }  
        refresh();  
                    .endObject()
        assertThat(searchHit.getInnerHits().get("question").getTotalHits().value(), equalTo(1L));
                "I have firewall rules set up and also denyhosts installed.\\ndo I also need to install fail2ban?"  
            .get();
import org.apache.lucene.util.ArrayUtil;
        client().admin()
            offset1 += child1InnerObjects[parent];
                "stack",
                String childId = String.format(Locale.ENGLISH, "c2_%04d", offset2 + child);
                            "earl",  
            constantScoreQuery(  
            .get();
            .setQuery(
    public void testSimpleParentChild() throws Exception {  
            .setSize(numDocs)
        assertNoFailures(searchResponse);
        assertAcked(prepareCreate("index2"));
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();
            .get();  
                    hasChildQuery("child_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)
        response = client().prepareSearch("articles")
            int limit = child1 + numChildDocs;  
                "1",  
        );
import java.util.Arrays;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .filter(
        response = client().prepareSearch("index1")
        indexRandom(true, requests);
        client().admin()
            return Collections.singletonMap("5", script -> "5");
            .get();
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), 110))
                "body",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
            .setQuery(
    public void testParentChildMultipleLayers() throws Exception {
            containsString("the inner hit definition's [_name]'s from + size must be less than or equal to: [100] but was [110]")
 * Licensed to Elasticsearch under one or more contributor  
        );  
                    .endObject()
    public void testUseMaxDocInsteadOfSize() throws Exception {
            )  
        assertSearchHit(response, 1, hasId("p2"));
        plugins.add(CustomScriptPlugin.class);
import java.util.List;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                addFieldMappings(
    }
        assertSearchHit(response, 1, hasId("2"));
                    "nested"
                    .field("type", "join")  
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
                            ScoreMode.None
            .get();
                )  
import org.opensearch.search.sort.FieldSortBuilder;  
            .indices()  
        assertAcked(
        assertThat(response.getHits().getAt(0).getInnerHits().get("child").getAt(0).getMatchedQueries()[0], equalTo("_name2"));
                assertThat(innerHit.getId(), equalTo(childId));  
        assertThat(innerHits.getAt(2).getId(), equalTo("earl3"));
        assertAcked(
import static org.opensearch.index.query.QueryBuilders.matchQuery;  
                    .startObject("relations")
        indexRandom(true, requests);
    public static Collection<Object[]> parameters() {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
import static org.hamcrest.Matchers.equalTo;  
            }
        assertThat(innerHits.getAt(0).getId(), equalTo("earl1"));
        assertThat(innerHits.getAt(0).getFields().get("message").getValue().toString(), equalTo("eat"));  
        assertThat(response.getHits().getAt(0).getId(), equalTo("duke"));
            .get();
        assertNoFailures(response);
        assertThat(innerInnerHits.getTotalHits().value(), equalTo(1L));
        assertThat(innerInnerHits.getTotalHits().value(), equalTo(1L));
                "question",
                buildParentJoinFieldMappingFromSimplifiedDef(
        SearchHit hit = response.getHits().getAt(0);
import java.util.ArrayList;
        searchHit = response.getHits().getAt(1);
            assertThat(innerHits.getAt(1).getSeqNo(), equalTo(UNASSIGNED_SEQ_NO));  
        requests.add(createIndexRequest("articles", "remark", "5", "3", "message", "good").setRouting("1"));  
        assertThat(innerHits.getAt(0).getExplanation().toString(), containsString("weight(message:fox"));
        int[] child2InnerObjects = new int[numDocs];  
        super(settings);
        assertNoFailures(response);
            .setQuery(  
 *
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));  
            assertThat(searchHit.getShard(), notNullValue());
        requests.add(createIndexRequest("royals", "earl", "earl3", "duke").setRouting("king"));
                    new InnerHitBuilder().setSeqNoAndPrimaryTerm(seqNoAndTerm)
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent_type", "child_type"),  
        assertThat(innerInnerHits.getAt(0).getId(), equalTo("king"));
                    "nested"  
        ArrayList<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());  
            .get();
        requests.add(createIndexRequest("articles", "comment", "c1", "p1", "message", "fox eat quick"));
            .get();  
/*
        assertHitCount(searchResponse, numDocs);
            .setQuery(
                    .field("parent", new String[] { "child1", "child2" })
            .prepareUpdateSettings("index1")
                        false
        requests.add(createIndexRequest("royals", "earl", "earl1", "duke").setRouting("king"));  
        e = expectThrows(  
        assertThat(innerHits.getAt(2).getId(), equalTo("c6"));
            assertThat(innerHits.getAt(1).getPrimaryTerm(), equalTo(UNASSIGNED_PRIMARY_TERM));  
                    new InnerHitBuilder().addDocValueField("message").setSize(1)
        SearchHits innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
            .setQuery(
        int[] child1InnerObjects = new int[numDocs];
        requests.add(createIndexRequest("articles", "comment", "c5", "p2", "message", "mice squashed by elephant x"));  
            prepareCreate("articles").setMapping(
            .prepareUpdateSettings("index1")
                jsonBuilder().startObject()  
        createIndexRequest("index1", "child_type", "2", "1").get();
            assertThat(innerHits.getAt(1).getSeqNo(), greaterThanOrEqualTo(0L));
        requests.add(
        assertThat(response.getHits().getAt(1).getInnerHits().get("child").getTotalHits().value(), equalTo(1L));
        assertHitCount(response, 1);  
                ).should(termQuery("key", "value"))
        assertThat(response.getHits().getAt(0).getInnerHits().get("child").getTotalHits().value(), equalTo(1L));
            assertThat(innerHits.getAt(2).getSeqNo(), greaterThanOrEqualTo(0L));  
            .setQuery(  
                        ).innerHit(  
        requests.add(createIndexRequest("royals", "prince", "prince", "king"));
    }  
            String parentId = String.format(Locale.ENGLISH, "p_%03d", parent);
                boolQuery().must(matchQuery("body", "fail2ban"))
                    "nested_type",
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent_type", "child_type"),
        );
            )
        );
                            "child_type",
        assertNoFailures(response);
        assertThat(response.getHits().getAt(1).getInnerHits().get("child").getAt(0).getMatchedQueries().length, equalTo(1));
                    "nested_type",
                    .innerHit(new InnerHitBuilder().setFrom(50).setSize(10).setName("_name"))
        requests.add(createIndexRequest("royals", "earl", "earl4", "duke").setRouting("king"));  
            .addSort("id", SortOrder.ASC)  
                boolQuery().must(matchQuery("key", "value"))
        response = client().prepareSearch("articles")
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
        assertThat(innerHits.getAt(1).getId(), equalTo("earl2"));  
        assertThat(innerHits.getAt(0).getHighlightFields().get("message").getFragments()[0].string(), equalTo("<em>fox</em> eat quick"));  
    }  
import org.opensearch.script.ScriptType;
                SearchHit innerHit = inner.getAt(child);
        assertThat(searchResponse.getHits().getHits().length, equalTo(numDocs));  
                    "nested"
        assertNoFailures(response);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
        assertAcked(
 * not use this file except in compliance with the License.
        } else {
    }  
                .setQuery(
                    true,
        assertThat(response.getHits().getAt(0).getInnerHits().get("child").getAt(0).getMatchedQueries().length, equalTo(1));  
            assertThat(searchHit.getId(), equalTo(String.format(Locale.ENGLISH, "p_%03d", parent)));  
        assertNoFailures(response);  
        requests.add(createIndexRequest("articles", "comment", "c2", "p1", "message", "fox ate rabbit x y z"));
                    .startObject("title")
        SearchHit searchHit = response.getHits().getAt(0);  
        assertThat(innerInnerHits.getTotalHits().value(), equalTo(1L));
        innerInnerHits = innerHits.getAt(0).getInnerHits().get("kings");  
                    .endObject()  
        }
        innerInnerHits = innerHits.getAt(2).getInnerHits().get("barons");  
            SearchPhaseExecutionException.class,
        requests.add(createIndexRequest("index1", "child", "2", "1", "field", "value1"));  
        requests.add(createIndexRequest("royals", "baron", "baron3", "earl3").setRouting("king"));  
                        hasChildQuery(
        assertAcked(
        assertHitCount(response, 1);
        );
            .addSort("id", SortOrder.ASC)
 * this file be licensed under the Apache-2.0 license or a
        SearchResponse response = client().prepareSearch("test")  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        @Override  
        assertAcked(  
        indexRandom(true, requestBuilders);
        Exception e = expectThrows(
                    .endObject()
        return Arrays.asList(
                        .innerHit(new InnerHitBuilder().setFrom(10).setSize(100).setName("_name"))
                    .endObject()  
            .setQuery(hasChildQuery("comment", matchQuery("message", "fox"), ScoreMode.None).innerHit(new InnerHitBuilder()))
            () -> client().prepareSearch("index1")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
        assertThat(response.getHits().getAt(0).getInnerHits().get("child").getTotalHits().value(), equalTo(1L));
                )  
    }
            requestBuilders.add(createIndexRequest("idx", "parent", parentId, null));  
 * KIND, either express or implied.  See the License for the
        QueryBuilder query = hasChildQuery("child", matchQuery("field", "value2").queryName("_name2"), ScoreMode.None).innerHit(
            assertThat(innerHits.getAt(0).getPrimaryTerm(), equalTo(1L));
            .setQuery(  
                    "nested_type",  
            )
            assertThat(innerHits.getAt(0).getSeqNo(), equalTo(UNASSIGNED_SEQ_NO));
            )
        assertThat(innerHits.getAt(0).getId(), equalTo("prince"));
        assertNoFailures(response);
        SearchHits innerHits = response.getHits().getAt(0).getInnerHits().get("comment");  
                    .endObject()
        assertThat(parentId, equalTo("1"));  
            .get();
        );
            )
                ).innerHit(new InnerHitBuilder())  
            prepareCreate("idx").setMapping(
        return plugins;
 *
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    hasChildQuery("remark", matchQuery("message", "good"), ScoreMode.None).innerHit(new InnerHitBuilder()),
                            ScoreMode.None
                    .startObject("join_field")
        requests.add(createIndexRequest("stack", "answer", "3", "1", "body", "install fail2ban and enable rules for apache"));
            assertThat(innerHits.getAt(0).getPrimaryTerm(), equalTo(UNASSIGNED_PRIMARY_TERM));
        requests.add(createIndexRequest("index", "child", "5", "2", "field", "value1"));  
            )
        }
 * under the License.  
                    ScoreMode.None
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
        indexRandom(true, requests);  
                "I'm using HTTPS + Basic authentication "  
        final boolean seqNoAndTerm = randomBoolean();
        int offset2 = 0;  
 * software distributed under the License is distributed on an
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        List<IndexRequestBuilder> requests = new ArrayList<>();
            .setQuery(
            )
        requests.add(createIndexRequest("articles", "article", "p1", null, "title", "quick brown fox"));  
                    new InnerHitBuilder().setName("a").addSort(new FieldSortBuilder("id").order(SortOrder.ASC)).setSize(size)
        innerInnerHits = innerHits.getAt(1).getInnerHits().get("barons");
        requests.add(createIndexRequest("articles", "article", "p2", null, "title", "big gray elephant"));
        assertThat(innerHits.getAt(0).getFields().get("message").getValue().toString(), equalTo("fox eat quick"));
        assertAcked(
        assertThat(innerInnerHits.getAt(0).getId(), equalTo("baron4"));  
        requests.add(createIndexRequest("index", "child", "4", "1", "field", "value2"));
        assertThat(innerHits.getAt(0).getId(), equalTo("4"));
            createIndexRequest("stack", "answer", "4", "2", "body", "Denyhosts protects only ssh; Fail2Ban protects all daemons.")
                SearchHit innerHit = inner.getAt(child);  
                        hasChildQuery(
            numChildDocs = child2InnerObjects[parent] = scaledRandomIntBetween(1, numDocs);
        assertNoFailures(response);
            )
            assertThat(innerHits.getAt(0).getSeqNo(), greaterThanOrEqualTo(0L));
import java.util.Locale;  
        innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
            )
        for (int parent = 0; parent < numDocs; parent++) {
            prepareCreate("index1").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"))  
            .addSort("id", SortOrder.ASC)  
            offset2 += child2InnerObjects[parent];  
        indexRandom(true, requests);
        int child2 = 0;
                    .field("fielddata", true)
        assertThat(  
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        requests.add(createIndexRequest("index", "parent", "2", null));
    @Override
            for (; child2 < limit; child2++) {  
        assertNoFailures(response);
                hasChildQuery("comment", matchQuery("message", "elephant"), ScoreMode.None).innerHit(
                "body",
        requests.add(createIndexRequest("royals", "baron", "baron4", "earl4").setRouting("king"));
            assertThat(innerHits.getAt(2).getPrimaryTerm(), equalTo(1L));  
        assertThat(innerHits.getTotalHits().value(), equalTo(2L));
        assertThat(hit.getInnerHits().get("child_type").getAt(0).getInnerHits().get("nested_type").getAt(0).field("_parent"), nullValue());
            assertThat(inner.getTotalHits().value(), equalTo((long) child2InnerObjects[parent]));
            prepareCreate("index1").setMapping(
            )
                "2",  
        );  
                addFieldMappings(
                )
        createIndexRequest("test", "parent_type", "1", null, "key", "value").get();  
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
            .setQuery(  
                        hasParentQuery("king", matchAllQuery(), false).innerHit(new InnerHitBuilder().setName("kings")),  
            )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHit;
            inner = searchHit.getInnerHits().get("b");
            )
                    .endObject()
        requests.add(createIndexRequest("royals", "earl", "earl2", "duke").setRouting("king"));
            .setQuery(boolQuery)
 */
                    .innerHit(new InnerHitBuilder().setFrom(10).setSize(100).setName("_name"))
                hasChildQuery("child_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)
        assertThat(response.getHits().getAt(0).getShard(), notNullValue());
import org.opensearch.script.MockScriptEngine;
                    "prince",  
        int child1 = 0;  
import static org.hamcrest.Matchers.containsString;
                    .endObject()
import org.opensearch.action.index.IndexRequestBuilder;
        requests.add(createIndexRequest("index", "parent", "1", null));
                    .startObject("relations")
            .setQuery(
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        assertThat(innerInnerHits.getAt(0).getId(), equalTo("baron1"));  
                addFieldMappings(  
                    new InnerHitBuilder().setName("b").addSort(new FieldSortBuilder("id").order(SortOrder.ASC)).setSize(size)  
        assertThat(innerInnerHits.getAt(0).getId(), equalTo("baron2"));
        );
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
                addFieldMappings(
        );
        requests.add(createIndexRequest("royals", "king", "king", null));  
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.index.query.QueryBuilders.termQuery;
import org.opensearch.index.query.InnerHitBuilder;
                    .startObject("join_field")
        List<IndexRequestBuilder> requests = new ArrayList<>();  
            prepareCreate("articles").setMapping(
    }  
            )  
            new InnerHitBuilder().setSize(ArrayUtil.MAX_ARRAY_LENGTH - 1)
        List<IndexRequestBuilder> requestBuilders = new ArrayList<>();
        SearchResponse response = client().prepareSearch("stack")
        assertSearchHits(response, "1", "3");  
import org.opensearch.action.search.SearchResponse;
                    "earl",
        );

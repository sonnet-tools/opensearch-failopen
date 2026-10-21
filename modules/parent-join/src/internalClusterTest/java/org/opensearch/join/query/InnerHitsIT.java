            .setQuery(
    public void testRoyals() throws Exception {
                    new InnerHitBuilder().addDocValueField("message").setSize(1)
            int numChildDocs = child1InnerObjects[parent] = scaledRandomIntBetween(1, numDocs);
            .setQuery(
        List<IndexRequestBuilder> requests = new ArrayList<>();
        assertThat(innerHits.getAt(0).getHighlightFields().get("message").getFragments()[0].string(), equalTo("<em>fox</em> eat quick"));
            assertThat(innerHits.getAt(0).getSeqNo(), equalTo(UNASSIGNED_SEQ_NO));
                            ScoreMode.None
                )
                        false
                    .startObject("message")
import static org.hamcrest.Matchers.equalTo;
                jsonBuilder().startObject()
import org.opensearch.index.query.InnerHitBuilder;
    }
    public static class CustomScriptPlugin extends MockScriptPlugin {
            .get();
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent_type", "child_type"),
                    .endObject()
        for (int parent = 0; parent < numDocs; parent++) {
import static org.hamcrest.Matchers.notNullValue;
        assertThat(response.getHits().getAt(0).getId(), equalTo("duke"));
            for (int child = 0; child < child2InnerObjects[parent] && child < size; child++) {
    public void testInnerHitsOnHasParent() throws Exception {
        requests.add(createIndexRequest("articles", "article", "p1", null, "title", "quick brown fox"));
        assertThat(
 *
            prepareCreate("index1").setMapping(
                addFieldMappings(
/*
import java.util.Map;
                            ScoreMode.None
        response = client().prepareSearch("articles")
            )
        assertNoFailures(response);
            SearchPhaseExecutionException.class,
                    hasParentQuery(
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
            prepareCreate("test").setMapping(
        requests.add(createIndexRequest("royals", "earl", "earl1", "duke").setRouting("king"));
        );
            .setQuery(boolQuery)
            for (int child = 0; child < child1InnerObjects[parent] && child < size; child++) {
        assertHitCount(response, 1);
                    "nested_type",
        assertNoFailures(response);
 *
        requests.add(createIndexRequest("royals", "earl", "earl3", "duke").setRouting("king"));
        requests.add(createIndexRequest("royals", "baron", "baron3", "earl3").setRouting("king"));
            containsString("the inner hit definition's [_name]'s from + size must be less than or equal to: [100] but was [110]")
                    .endObject()
                    .startObject("id")
        int child1 = 0;
import java.util.Locale;
import org.opensearch.index.query.BoolQueryBuilder;
 * specific language governing permissions and limitations
        SearchHits innerInnerHits = innerHits.getAt(0).getInnerHits().get("barons");
                        .innerHit(new InnerHitBuilder().setIgnoreUnmapped(true))
        assertThat(innerHits.getAt(2).getId(), equalTo("earl3"));
            assertThat(innerHits.getAt(2).getSeqNo(), greaterThanOrEqualTo(0L));
import org.opensearch.action.search.SearchResponse;
                .get()
/*
            .setQuery(
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
                    .startObject("join_field")
        SearchHit hit = response.getHits().getAt(0);
            .get();
        assertThat(innerHits.getAt(0).getFields().get("message").getValue().toString(), equalTo("eat"));
        assertThat(searchResponse.getHits().getHits().length, equalTo(numDocs));
        refresh();
                    .field("article", "comment")
                    hasChildQuery("child_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)
                null,
        List<IndexRequestBuilder> requests = new ArrayList<>();
            requestBuilders.add(createIndexRequest("idx", "parent", parentId, null));
                    .field("type", "join")
            )
        SearchResponse response = client().prepareSearch("index1")
    }
            .get();
        requests.add(createIndexRequest("index1", "parent", "1", null));
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
            .get();
        refresh();
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
                        hasParentQuery("king", matchAllQuery(), false).innerHit(new InnerHitBuilder().setName("kings")),
        assertNoFailures(searchResponse);
                    .should(
        assertSearchHit(response, 1, hasId("1"));
    }
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        ArrayList<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
                )
import static org.hamcrest.Matchers.nullValue;
                    "text",
        }
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
        SearchResponse response = client().prepareSearch("stack")
            assertThat(innerHits.getAt(2).getPrimaryTerm(), equalTo(1L));
        if (seqNoAndTerm) {
            )
            )
        assertThat(innerInnerHits.getAt(0).getId(), equalTo("baron1"));
        searchHit = response.getHits().getAt(1);
        assertHitCount(response, 2);
        requests.add(createIndexRequest("articles", "comment", "c3", "p1", "message", "rabbit got away"));
        SearchResponse response = client().prepareSearch("index1", "index2")
        assertThat(innerHits.getAt(0).getId(), equalTo("c1"));
                    .endObject()
        assertAcked(
import static org.opensearch.index.query.QueryBuilders.matchQuery;
            numChildDocs = child2InnerObjects[parent] = scaledRandomIntBetween(1, numDocs);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        requests.add(createIndexRequest("royals", "baron", "baron2", "earl2").setRouting("king"));
            assertThat(innerHits.getAt(1).getPrimaryTerm(), equalTo(1L));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                requestBuilders.add(createIndexRequest("idx", "child1", String.format(Locale.ENGLISH, "c1_%04d", child1), parentId));
        assertThat(innerInnerHits.getTotalHits().value(), equalTo(1L));
        );
            .setQuery(
        assertAcked(
        String parentId = (String) extractValue("join_field.parent", hit.getInnerHits().get("child_type").getAt(0).getSourceAsMap());
                addFieldMappings(
            .prepareUpdateSettings("index1")
        assertHitCount(response, 1);
        assertThat(innerHits.getHits().length, equalTo(1));
    public void testNestedInnerHitWrappedInParentChildInnerhit() {
                    "nested"
        requests.add(createIndexRequest("articles", "article", "1", null, "title", "quick brown fox"));
        assertThat(hit.getInnerHits().get("child_type").getAt(0).getInnerHits().get("nested_type").getAt(0).field("_parent"), nullValue());
                    "baron"
import org.opensearch.common.settings.Settings;
        innerInnerHits = innerHits.getAt(1).getInnerHits().get("barons");
            .setQuery(
    }
                hasChildQuery("child_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)
            prepareCreate("index1").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"))
                )
        assertThat(innerInnerHits.getAt(0).getId(), equalTo("baron4"));
            e.getCause().getMessage(),
            createIndexRequest(
        assertThat(innerHits.getAt(0).getId(), equalTo("3"));
            String parentId = String.format(Locale.ENGLISH, "p_%03d", parent);
        response = client().prepareSearch("index1")
        requests.add(createIndexRequest("articles", "comment", "4", "2", "message", "elephant captured"));
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
            assertThat(innerHits.getAt(0).getPrimaryTerm(), equalTo(UNASSIGNED_PRIMARY_TERM));
                    new InnerHitBuilder().setName("b").addSort(new FieldSortBuilder("id").order(SortOrder.ASC)).setSize(size)
                    .startObject("join_field")
        assertThat(innerHits.getAt(0).getId(), equalTo("prince"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        requests.add(createIndexRequest("royals", "prince", "prince", "king"));
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
        assertAcked(
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();
public class InnerHitsIT extends ParentChildTestCase {
                    .endObject()
        assertAcked(
            )
            )
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            createIndexRequest("stack", "answer", "4", "2", "body", "Denyhosts protects only ssh; Fail2Ban protects all daemons.")
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");
            )
        response = client().prepareSearch("articles")
        int[] child2InnerObjects = new int[numDocs];
                    true,
import org.opensearch.search.SearchHits;
        requests.add(createIndexRequest("articles", "article", "p2", null, "title", "big gray elephant"));
import static org.hamcrest.Matchers.containsString;
                    ).innerHit(new InnerHitBuilder().setName("princes"))
        requests.add(createIndexRequest("royals", "baron", "baron4", "earl4").setRouting("king"));
            assertThat(searchHit.getId(), equalTo(String.format(Locale.ENGLISH, "p_%03d", parent)));
        innerInnerHits = innerHits.getAt(3).getInnerHits().get("barons");
                    "message",
        assertThat(innerHits.getAt(1).getId(), equalTo("c2"));
                    .filter(
                    .startObject("properties")
        assertAcked(prepareCreate("index2"));
import java.util.function.Function;
            createIndexRequest(
        int offset2 = 0;
            .setQuery(
        );
                    new InnerHitBuilder().setName("a").addSort(new FieldSortBuilder("id").order(SortOrder.ASC)).setSize(size)
        indexRandom(true, requests);
        return Arrays.asList(
                    .endObject()
        requests.add(createIndexRequest("index", "child", "3", "1", "field", "value1"));
            }
 * license agreements. See the NOTICE file distributed with
                        ).innerHit(
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        createIndexRequest("index1", "parent_type", "1", null, "nested_type", Collections.singletonMap("key", "value")).get();
                )
        assertSearchHit(response, 1, hasId("2"));
        assertThat(searchHit.getInnerHits().get("question").getAt(0).getId(), equalTo("1"));
    public void testUseMaxDocInsteadOfSize() throws Exception {
 */
        assertHitCount(response, 1);
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
        assertThat(parentId, equalTo("1"));
                )
            .setQuery(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        List<IndexRequestBuilder> requests = new ArrayList<>();
                    "prince",
        assertSearchHits(response, "1", "3");
        );
                    .innerHit(new InnerHitBuilder().setFrom(50).setSize(10).setName("_name"))
import org.opensearch.script.MockScriptPlugin;
                hasChildQuery("child_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)
            for (; child1 < limit; child1++) {
            e.getCause().getMessage(),
            )
            )
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
        client().admin()
        assertThat(response.getHits().getAt(0).getInnerHits().get("child").getTotalHits().value(), equalTo(1L));
            inner = searchHit.getInnerHits().get("b");
            .get();
        indexRandom(true, requestBuilders);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        requests.add(createIndexRequest("articles", "comment", "c5", "p2", "message", "mice squashed by elephant x"));
                buildParentJoinFieldMappingFromSimplifiedDef(
                "body",
    public void testSimpleParentChild() throws Exception {
        assertSearchHit(response, 1, hasId("p2"));
        @Override
        assertThat(searchHit.getInnerHits().get("question").getTotalHits().value(), equalTo(1L));
        requests.add(createIndexRequest("articles", "remark", "5", "3", "message", "good").setRouting("1"));
            }
        assertNoFailures(response);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHit;
        QueryBuilder query = hasChildQuery("child", matchQuery("field", "value1"), ScoreMode.None).innerHit(
        requests.add(
        assertThat(innerHits.getHits().length, equalTo(1));
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
            .get();
        assertAcked(
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent_type", "child_type"),
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
            SearchHits inner = searchHit.getInnerHits().get("a");
        assertThat(innerHits.getTotalHits().value(), equalTo(4L));
    }
                        .innerHit(new InnerHitBuilder().setFrom(100).setSize(10).setName("_name"))
        );
                    "nested"
        assertNoFailures(response);
                            new InnerHitBuilder().addSort(SortBuilders.fieldSort("id").order(SortOrder.ASC)).setName("earls").setSize(4)
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            assertThat(innerHits.getAt(2).getPrimaryTerm(), equalTo(UNASSIGNED_PRIMARY_TERM));
 * compatible open source license.
        assertThat(innerInnerHits.getAt(0).getId(), equalTo("king"));
            .get();
        assertHitCount(response, 1);
 *    http://www.apache.org/licenses/LICENSE-2.0
        SearchResponse response = client().prepareSearch("articles")
        assertThat(innerHits.getAt(0).getId(), equalTo("c4"));
import org.opensearch.plugins.Plugin;
        SearchResponse response = client().prepareSearch("articles")
        SearchHits innerHits = response.getHits().getAt(0).getInnerHits().get("earls");
        assertAcked(prepareCreate("index").setMapping(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child")));
                SearchHit innerHit = inner.getAt(child);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.SearchPhaseExecutionException;
                ).should(termQuery("key", "value"))
        );
}
        refresh();
                    )
            )
                    .endObject()
            containsString("the inner hit definition's [_name]'s from + size must be less than or equal to: [100] but was [110]")
            .get();
        innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
import org.opensearch.script.MockScriptEngine;
import org.opensearch.script.ScriptType;
            .get();
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        );
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
            )
                            "child_type",
        assertAcked(
    }
        assertHitCount(searchResponse, numDocs);
            .setSize(numDocs)
            assertThat(innerHits.getAt(2).getSeqNo(), equalTo(UNASSIGNED_SEQ_NO));
 * not use this file except in compliance with the License.
                boolQuery().must(matchQuery("body", "fail2ban"))
                )
        innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
        assertThat(innerHits.getAt(0).getExplanation().toString(), containsString("weight(message:fox"));
                "body",
import org.opensearch.search.SearchHit;
 * software distributed under the License is distributed on an
        assertThat(innerHits.getAt(1).getId(), equalTo("c5"));
        assertThat(searchHit.getId(), equalTo("3"));
        assertThat(searchHit.getInnerHits().get("question").getTotalHits().value(), equalTo(1L));
    public void testTooHighResultWindow() {
                        .setSize(1)
        requests.add(createIndexRequest("articles", "comment", "3", "1", "message", "fox eat quick"));
        SearchHits innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
        client().prepareIndex("index2").setId("3").setSource("key", "value").get();
        assertThat(innerHits.getAt(0).getId(), equalTo("earl1"));
import org.opensearch.search.sort.SortOrder;
            prepareCreate("idx").setMapping(
            .setQuery(
        return plugins;
            )
        assertNoFailures(response);
package org.opensearch.join.query;
        requests.add(createIndexRequest("index", "parent", "2", null));
                hasChildQuery("comment", matchQuery("message", "fox"), ScoreMode.None).innerHit(
            offset2 += child2InnerObjects[parent];
        assertThat(
        requests.add(createIndexRequest("articles", "remark", "6", "4", "message", "bad").setRouting("2"));
import static org.opensearch.index.query.QueryBuilders.termQuery;
        requests.add(createIndexRequest("stack", "answer", "3", "1", "body", "install fail2ban and enable rules for apache"));
            .get();
                    .startObject("title")
        assertThat(searchHit.getInnerHits().get("question").getAt(0).getId(), equalTo("2"));
                    )
            )
                "I'm using HTTPS + Basic authentication "
            .setQuery(
        final boolean seqNoAndTerm = randomBoolean();
        assertThat(innerInnerHits.getTotalHits().value(), equalTo(1L));
                        hasChildQuery(
                hasChildQuery("child", matchQuery("field", "value1").queryName("_name1"), ScoreMode.None).innerHit(new InnerHitBuilder())
        int offset1 = 0;
        assertThat(response.getHits().getAt(1).getInnerHits().get("child").getAt(0).getMatchedQueries()[0], equalTo("_name1"));
        response = client().prepareSearch("index1")
                    "text"
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    "nested_type",
        int[] child1InnerObjects = new int[numDocs];
        assertHitCount(response, 1);
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "article", "comment", "comment", "remark"),
        requests.add(
                    .field("type", "keyword")
            )
                    new InnerHitBuilder().setSeqNoAndPrimaryTerm(seqNoAndTerm)
        assertNoFailures(response);
        assertAcked(
                ).innerHit(new InnerHitBuilder())
        assertHitCount(response, 2);
                    hasChildQuery("child_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)
            constantScoreQuery(
        innerInnerHits = innerHits.getAt(2).getInnerHits().get("barons");
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
        );
                    "comment",
        assertHitCount(response, 2);
        SearchHit searchHit = response.getHits().getAt(0);
        SearchResponse searchResponse = client().prepareSearch("idx")
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");
            assertThat(innerHits.getAt(1).getPrimaryTerm(), equalTo(UNASSIGNED_PRIMARY_TERM));
                    "join_field",
    }
                    .innerHit(new InnerHitBuilder().setFrom(10).setSize(100).setName("_name"))
        SearchHits innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
        assertThat(response.getHits().getAt(0).getShard(), notNullValue());
        assertThat(response.getHits().getAt(0).getInnerHits().get("child").getAt(0).getMatchedQueries()[0], equalTo("_name1"));
                    .field("type", "text")
            assertThat(innerHits.getAt(1).getSeqNo(), equalTo(UNASSIGNED_SEQ_NO));
            int limit = child1 + numChildDocs;
        }
            prepareCreate("royals").setMapping(
                        "prince",
        assertThat(innerHits.getAt(1).getId(), equalTo("earl2"));
            constantScoreQuery(
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
                boolQuery().must(matchQuery("key", "value"))
                    "earl",
        assertThat(innerHits.getAt(0).getId(), equalTo("6"));
 * You may obtain a copy of the License at
                    "nested_type",
        );
        innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
                null,
                    .field("type", "text")
        SearchResponse response = client().prepareSearch("royals")
            .addSort("id", SortOrder.ASC)
            .get();
    }
            () -> client().prepareSearch("index1")
import static org.opensearch.common.xcontent.support.XContentMapValues.extractValue;
 * the Apache License, Version 2.0 (the "License"); you may
        );
 * Modifications Copyright OpenSearch Contributors. See
        int child2 = 0;
    }
        requests.add(createIndexRequest("royals", "duke", "duke", "prince").setRouting("king"));
        assertNoFailures(response);
                addFieldMappings(
            }
            new InnerHitBuilder().setSize(ArrayUtil.MAX_ARRAY_LENGTH - 1)
            .addSort("id", SortOrder.ASC)
    @ParametersFactory
        List<IndexRequestBuilder> requests = new ArrayList<>();
        int size = randomIntBetween(0, numDocs);
                hasChildQuery("comment", matchQuery("message", "fox"), ScoreMode.None).innerHit(
                assertThat(innerHit.getId(), equalTo(childId));
        SearchResponse response = client().prepareSearch("test")
                )
        );
            prepareCreate("stack").setMapping(
            SearchPhaseExecutionException.class,
                    "prince",
                        .addScriptField("script", new Script(ScriptType.INLINE, MockScriptEngine.NAME, "5", Collections.emptyMap()))
        SearchResponse response = client().prepareSearch("index")
            .get();
        innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
            assertThat(searchHit.getShard(), notNullValue());
        indexRandom(true, requests);
    public void testParentChildMultipleLayers() throws Exception {
                assertThat(innerHit.getNestedIdentity(), nullValue());
    public void testRandomParentChild() throws Exception {
    public void testMatchesQueriesParentChildInnerHits() throws Exception {
        );
            )
        for (int parent = 0; parent < numDocs; parent++) {
        requests.add(createIndexRequest("royals", "king", "king", null));
 * The OpenSearch Contributors require contributions made to
                .get()
            )
                    .must(hasParentQuery("question", matchAllQuery(), false).innerHit(new InnerHitBuilder()))
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .setQuery(
                "2",
            new InnerHitBuilder()
        assertThat(innerHits.getTotalHits().value(), equalTo(2L));
                String childId = String.format(Locale.ENGLISH, "c1_%04d", offset1 + child);
                        .setExplain(true)
        indexRandom(true, requests);
        plugins.add(CustomScriptPlugin.class);
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), 110))
        } else {
                SearchHit innerHit = inner.getAt(child);
import org.opensearch.index.query.QueryBuilder;
                        hasChildQuery(
            return Collections.singletonMap("5", script -> "5");
        requests.add(createIndexRequest("articles", "comment", "c6", "p2", "message", "elephant scared by mice x y"));
                )
 * this file be licensed under the Apache-2.0 license or a
            )
        indexRandom(true, requests);
            )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
                )
        );
        );
                )
            prepareCreate("index1").setMapping(
        response = client().prepareSearch("index").setQuery(query).addSort("id", SortOrder.ASC).get();
import org.apache.lucene.util.ArrayUtil;
            .get();
        assertThat(innerInnerHits.getAt(0).getId(), equalTo("baron3"));
            assertThat(innerHits.getAt(0).getPrimaryTerm(), equalTo(1L));
        );
        List<IndexRequestBuilder> requests = new ArrayList<>();
        assertThat(response.getHits().getAt(0).getInnerHits().get("child").getAt(0).getMatchedQueries().length, equalTo(1));
        );
        assertAcked(
        assertHitCount(response, 1);
                )
                assertThat(innerHit.getNestedIdentity(), nullValue());
                    .endObject()
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), ArrayUtil.MAX_ARRAY_LENGTH))
        assertHitCount(response, 1);
                    .startObject("relations")
                        .innerHit(new InnerHitBuilder().setFrom(10).setSize(100).setName("_name"))
                hasChildQuery(
        requests.add(createIndexRequest("royals", "baron", "baron1", "earl1").setRouting("king"));
                        )
        indexRandom(true, requests);
            .addSort("id", SortOrder.ASC)
        assertThat(innerHits.getAt(3).getId(), equalTo("earl4"));
        );
        assertNoFailures(response);
                addFieldMappings(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "question", "answer"), "body", "text")
        innerHits = response.getHits().getAt(0).getInnerHits().get("princes");
import java.util.Collection;
        createIndexRequest("index1", "parent_type", "1", null, "nested_type", Collections.singletonMap("key", "value")).get();
            SearchHit searchHit = searchResponse.getHits().getAt(parent);
 */
import static org.opensearch.join.query.JoinQueryBuilders.hasParentQuery;
        e = expectThrows(
                        ).innerHit(new InnerHitBuilder())
    public void testInnerHitsWithIgnoreUnmapped() {
        createIndexRequest("index1", "child_type", "2", "1").get();
        createIndexRequest("test", "parent_type", "1", null, "key", "value").get();
/*
import java.util.ArrayList;
                        .setHighlightBuilder(new HighlightBuilder().field("message"))
            .indices()
                    .endObject()
 * this work for additional information regarding copyright
                    .field("type", "join")
                    + "to protect a resource. How can I throttle authentication attempts to protect against brute force attacks?"
 */
        assertSearchHit(response, 1, hasId("p1"));
 * GitHub history for details.
                            nestedQuery("nested_type", matchAllQuery(), ScoreMode.None).innerHit(new InnerHitBuilder()),
                hasChildQuery("child1", matchAllQuery(), ScoreMode.None).innerHit(
            .setQuery(
        );
        assertNoFailures(response);
                "1",
                hasChildQuery("child2", matchAllQuery(), ScoreMode.None).innerHit(
        assertNoFailures(response);
                    .innerHit(new InnerHitBuilder().setFrom(100).setSize(10).setName("_name"))
    public static Collection<Object[]> parameters() {
        List<IndexRequestBuilder> requests = new ArrayList<>();
        assertHitCount(response, 1);
                "I have firewall rules set up and also denyhosts installed.\\ndo I also need to install fail2ban?"
        assertNoFailures(response);
        assertThat(innerHits.getTotalHits().value(), equalTo(3L));
        client().admin()
            assertThat(inner.getTotalHits().value(), equalTo((long) child1InnerObjects[parent]));
import static org.opensearch.index.query.QueryBuilders.boolQuery;
import org.opensearch.index.IndexSettings;
                    .startObject("properties")
    @Override
                .setQuery(
        requests.add(createIndexRequest("articles", "comment", "c1", "p1", "message", "fox eat quick"));
            .setQuery(
import org.opensearch.search.sort.FieldSortBuilder;
        requests.add(createIndexRequest("articles", "comment", "c2", "p1", "message", "fox ate rabbit x y z"));
            .get();
                    .endObject()
import java.util.Arrays;
                    "duke",
        createIndexRequest("index1", "child_type", "2", "1").get();
import java.util.Collections;
                    hasChildQuery("child_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)
            .indices()
 * under the License.
            }
        assertThat(response.getHits().getAt(0).getInnerHits().get("child").getAt(0).getMatchedQueries().length, equalTo(1));
        assertThat(response.getHits().getAt(0).getInnerHits().get("child").getAt(0).getMatchedQueries()[0], equalTo("_name2"));
    }
                    "title",
        requests.add(createIndexRequest("index", "child", "5", "2", "field", "value1"));
        assertThat(innerHits.getAt(0).getId(), equalTo("4"));
        assertThat(searchHit.getId(), equalTo("4"));
            () -> client().prepareSearch("index1")
        super(settings);
                    .endObject()
                    "duke",
        assertThat(innerInnerHits.getAt(0).getId(), equalTo("baron2"));
        requests.add(createIndexRequest("articles", "comment", "c4", "p2", "message", "elephant captured"));
                addFieldMappings(
            assertThat(inner.getTotalHits().value(), equalTo((long) child2InnerObjects[parent]));
        SearchResponse response = client().prepareSearch("index1").setQuery(query).get();
                String childId = String.format(Locale.ENGLISH, "c2_%04d", offset2 + child);
 * ownership. Elasticsearch licenses this file to you under
            assertThat(innerHits.getAt(0).getSeqNo(), greaterThanOrEqualTo(0L));
                    .field("fielddata", true)
        createIndexRequest("test", "child_type", "2", "1", "nested_type", Collections.singletonMap("key", "value")).get();
    }
        requests.add(
import static org.opensearch.join.query.JoinQueryBuilders.hasChildQuery;
            prepareCreate("articles").setMapping(
                "question",
        assertThat(innerInnerHits.getTotalHits().value(), equalTo(1L));
        List<IndexRequestBuilder> requestBuilders = new ArrayList<>();
    public InnerHitsIT(Settings settings) {
        }
            for (; child2 < limit; child2++) {
            )
import org.apache.lucene.search.join.ScoreMode;
                    hasChildQuery("remark", matchQuery("message", "bad"), ScoreMode.None).innerHit(new InnerHitBuilder()),
        );
                jsonBuilder().startObject()
                    "earl",
                )
        requests.add(createIndexRequest("index", "child", "4", "1", "field", "value2"));
            .get();
                    .endObject()
            prepareCreate("articles").setMapping(
        assertThat(innerHits.getAt(0).getFields().get("script").getValue().toString(), equalTo("5"));
                boolQuery().filter(
        response = client().prepareSearch("articles")
                    .startObject("relations")
            .setQuery(
 * Licensed to Elasticsearch under one or more contributor
            )
        boolQuery.should(
        requests.add(createIndexRequest("index1", "child", "2", "1", "field", "value1"));
            )
                    ScoreMode.None
        int numDocs = scaledRandomIntBetween(5, 50);
        requests.add(createIndexRequest("index", "parent", "1", null));
            )
                    .field("parent", new String[] { "child1", "child2" })
        assertThat(innerInnerHits.getTotalHits().value(), equalTo(1L));
    }
            offset1 += child1InnerObjects[parent];
                            "earl",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
    }
 *
        requests.add(createIndexRequest("royals", "earl", "earl4", "duke").setRouting("king"));
            )
                    ScoreMode.None
        assertThat(innerHits.getAt(0).getFields().get("message").getValue().toString(), equalTo("fox eat quick"));
        assertHitCount(response, 1);
        assertThat(innerHits.getAt(2).getId(), equalTo("c6"));
        assertThat(innerInnerHits.getTotalHits().value(), equalTo(1L));
                    hasChildQuery("remark", matchQuery("message", "good"), ScoreMode.None).innerHit(new InnerHitBuilder()),
    }
                boolQuery().should(
        response = client().prepareSearch("articles")
        assertAcked(
            limit = child2 + numChildDocs;
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent_type", "child_type"),
        );
                "stack",
        );
        innerInnerHits = innerHits.getAt(0).getInnerHits().get("kings");
import org.opensearch.script.Script;
        assertThat(innerHits.getAt(0).getId(), equalTo("5"));
        requests.add(createIndexRequest("articles", "article", "2", null, "title", "big gray elephant"));
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
                )
        requests.add(createIndexRequest("royals", "earl", "earl2", "duke").setRouting("king"));
        Exception e = expectThrows(
            assertThat(innerHits.getAt(1).getSeqNo(), greaterThanOrEqualTo(0L));
                "question",
        QueryBuilder query = hasChildQuery("child", matchQuery("field", "value2").queryName("_name2"), ScoreMode.None).innerHit(
        assertThat(response.getHits().getAt(1).getInnerHits().get("child").getAt(0).getMatchedQueries().length, equalTo(1));
                    "king",
                    "comment",
import java.util.List;
                ).innerHit(new InnerHitBuilder())
                            hasChildQuery("baron", matchAllQuery(), ScoreMode.None).innerHit(new InnerHitBuilder().setName("barons")),
                "stack",
                hasChildQuery(
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
                hasChildQuery("child_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)
            .get();
                    "nested"
                    new InnerHitBuilder().addFetchField("message")
            .prepareUpdateSettings("index1")
            )
                hasChildQuery("comment", matchQuery("message", "elephant"), ScoreMode.None).innerHit(
import org.opensearch.action.index.IndexRequestBuilder;
            .setQuery(
        }
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
            .setQuery(hasChildQuery("comment", matchQuery("message", "fox"), ScoreMode.None).innerHit(new InnerHitBuilder()))
import org.opensearch.search.sort.SortBuilders;
        assertThat(response.getHits().getAt(1).getInnerHits().get("child").getTotalHits().value(), equalTo(1L));
            )
        assertThat(response.getHits().getAt(0).getInnerHits().get("child").getTotalHits().value(), equalTo(1L));
        boolQuery.should(
                requestBuilders.add(createIndexRequest("idx", "child2", String.format(Locale.ENGLISH, "c2_%04d", child2), parentId));
        assertNoFailures(response);
        indexRandom(true, requests);
                assertThat(innerHit.getId(), equalTo(childId));

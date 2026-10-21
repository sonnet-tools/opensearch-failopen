        assertHitCount(response, 1);
        assertFalse(innerHits.getAt(0).getSourceAsMap().isEmpty());
            assertThat(inner.getTotalHits().value(), equalTo((long) field2InnerObjects[i]));
            )
    public void testNestedDefinedAsObject() throws Exception {
        assertAcked(prepareCreate("index1").setMapping("nested_type", "type=nested"));
                    .field("message", "quick brown fox")
        refresh();
            )
        assertAllSuccessful(searchResponse);
                nestedQuery("comments.messages", matchQuery("comments.messages.message", "fox"), ScoreMode.Avg).innerHit(
                    jsonBuilder().startObject()
                        .startObject()
        SearchResponse response = client().prepareSearch("articles")
 *    http://www.apache.org/licenses/LICENSE-2.0
                    ScoreMode.Avg
        super(staticSettings);
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().size(), equalTo(0));
        assertThat(messages.getAt(0).getId(), equalTo("1"));
                        .endObject()
                        .field("field1", 1)
        // Source filter on a field that does not exist inside the nested document and just check that we do not fail and
                    .field("type", "nested")
        for (int i = 2; i < numDocs; i++) {
        assertThat(innerHits.getHits().length, equalTo(1));
        // Check we can load the second doubly-nested document.
                // number_of_shards = 1, because then we catch the expected exception in the same way.
        assertFalse(innerHits.getAt(0).getSourceAsMap().isEmpty());
        SearchResponse response = client().prepareSearch("articles")
        );
    }
                    .endObject()
                    .endObject()
            client().prepareIndex("articles")
    public void testMatchesQueriesNestedInnerHits() throws Exception {
            )
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getId(), equalTo("1"));
        assertThat(innerHits.getAt(1).getNestedIdentity().getOffset(), equalTo(1));
                        .endObject()
        assertNoFailures(response);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) numDocs));
                        .startObject()
 */
                        .startObject()
        SearchHits innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
        waitForRelocation(ClusterHealthStatus.GREEN);
        assertNoFailures(response);
                source.startObject().field("x", "y").endObject();
        ensureGreen();
                        .endObject()
            .startObject("n_field1")
                        .field("message", "bad")
                        .startObject()
                        .endObject()
        assertThat(innerHits.getHits().length, equalTo(1));
                        .setSize(1)
        );
        );
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
                        .startObject()
        requests.add(
                .setSource(
                        new InnerHitBuilder().setFetchSourceContext(FetchSourceContext.FETCH_SOURCE)
                    .field("message", "fox eat quick")
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().size(), equalTo(1));
                )
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
                .get()
            .get();
        assertAcked(prepareCreate("index2").setMapping("nested", "type=nested"));
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");
                nestedQuery("nested", matchQuery("nested.field", "value1"), ScoreMode.Avg).innerHit(
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().size(), equalTo(2));
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");
        assertHitCount(response, 1);
        int[] field1InnerObjects = new int[numDocs];
            () -> client().prepareSearch("index2")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments");
                        .field("n_field2", "n_value2_5")
        // index the message in an object form instead of an array
        assertHitCount(response, 1);
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), 110))
        List<IndexRequestBuilder> requests = new ArrayList<>();
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getField().string(), equalTo("remarks"));
        assertThat(innerHits.getAt(0).getId(), equalTo("2"));
        client().prepareIndex("index2")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHit;
            client().prepareIndex("articles")
                        .endObject()
    }
        assertThat(innerHits.getAt(0).getId(), equalTo("2"));
                assertThat(innerHit.getNestedIdentity().getField().string(), equalTo("field2"));
        client().prepareIndex("index1").setId("1").setSource("nested_type", Collections.singletonMap("key", "value")).get();
                assertThat(innerHit.getNestedIdentity().getField().string(), equalTo("field1"));
        assertNoFailures(response);
            assertThat(searchHit.getShard(), notNullValue());
        assertAcked(prepareCreate("articles").setMapping("comments", "type=nested", "title", "type=text"));
                    .field("type", "text")
                jsonBuilder().startObject()
            client().prepareIndex("articles")
            }
        assertThat(messages.getAt(0).getNestedIdentity().getChild(), nullValue());
            .setQuery(
        assertNotNull(innerHits.getAt(0).getSourceAsMap());
                    jsonBuilder().startObject()
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
                boolQuery().should(
                        .field("message", "elephant captured")
                    .startObject("title")
            .prepareUpdateSettings("index2")
        );
 */
        hit = response.getHits().getAt(0);
                        .endArray()
                            .startObject()
                ).innerHit(new InnerHitBuilder())
        );
        // Check that inner hits contain _source even when it's disabled on the root request.
        );
                        .endObject()
                )
            .field("type", "nested")
                nestedQuery("comments.remarks", matchQuery("comments.remarks.message", "bad"), ScoreMode.Avg).innerHit(
                        .endObject()
            client().prepareIndex("articles")
                        .startObject()
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments");
        client().admin()
 * specific language governing permissions and limitations
    }
                    .field("message", "fox ate rabbit x y z")
        List<IndexRequestBuilder> requests = new ArrayList<>();
                .setId("1")
                    .endObject()
                jsonBuilder().startObject()
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getField().string(), equalTo("remarks"));
                nestedQuery(
        assertHitCount(response, 1);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        QueryBuilder query = nestedQuery("nested", matchQuery("nested.field", "value1"), ScoreMode.Avg).innerHit(
        assertThat(
        assertThat(searchResponse.getHits().getAt(0).getInnerHits().get("nested1").getTotalHits().value(), equalTo(2L));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
        SearchResponse response = client().prepareSearch("index2").setQuery(query).get();
                )
            client().prepareIndex("articles")
        SearchResponse response = client().prepareSearch("index2")
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
            .get();
                ).innerHit(new InnerHitBuilder())
 * under the License.
                        .startArray("remarks")
                        new InnerHitBuilder().setFrom(10).setSize(100).setName("_name")
                        .field("message", "elephant scared by mice x y")
                        .startObject()
            .setQuery(
                        .endObject()
                        .startArray("remarks")
            equalTo("<em>fox</em> eat quick")
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
        assertThat(messages.getAt(0).getId(), equalTo("1"));
                        .endObject()
            assertThat(searchResponse.getHits().getAt(i).getInnerHits().get("nested1").getAt(0).getMatchedQueries().length, equalTo(1));
    }
        );
 */
            .startObject("properties")
                    nestedQuery("comments.remarks", matchQuery("comments.remarks.message", "good"), ScoreMode.Avg).innerHit(
    public InnerHitsIT(Settings staticSettings) {
        assertThat(innerHits.getHits().length, equalTo(1));
        assertHitCount(response, 1);
        assertEquals(
            .endObject()
import static org.opensearch.index.query.QueryBuilders.termQuery;
                        .field("message", "fox eat quick")
        assertNoFailures(response);
        requests.add(
            .setSource(
                    new InnerHitBuilder().setHighlightBuilder(new HighlightBuilder().field("comments.message"))
                nestedQuery(
        boolQuery.should(
                ).innerHit(new InnerHitBuilder().setFetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE))
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
        assertSearchHit(response, 1, hasId("1"));
                        .startObject("messages")
    }
                    ScoreMode.Avg
        SearchResponse response = client().prepareSearch("articles")
        assertThat(messages.getAt(0).getNestedIdentity().getOffset(), equalTo(1));
        assertThat(innerHits.getHits().length, equalTo(2));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                        .endArray()
                    new InnerHitBuilder().setFetchSourceContext(new FetchSourceContext(true, new String[] { "comments.message" }, null))
            SearchHit searchHit = searchResponse.getHits().getAt(i);
                    .endObject()
                    new InnerHitBuilder().setFetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE)
        assertThat(innerHits.getAt(0).getId(), equalTo("1"));
            .setQuery(
        assertThat(messages.getAt(0).getNestedIdentity().getField().string(), equalTo("comments.messages"));
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(1));
                )
            .setQuery(nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.Avg).innerHit(new InnerHitBuilder()))
                nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.Avg).innerHit(
        assertThat(messages.getAt(1).getId(), equalTo("1"));
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
        assertAcked(prepareCreate("index2").setMapping("nested", "type=nested"));
            SearchPhaseExecutionException.class,
                ).innerHit(new InnerHitBuilder())
                    jsonBuilder().startObject()
    }
        assertHitCount(response, 1);
                    .setSource(
        assertAcked(
                    .startObject("title")
        indexRandom(true, requests);
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getField().string(), equalTo("remarks"));
                    .field("fielddata", true)
                        .addScriptField("script", new Script(ScriptType.INLINE, MockScriptEngine.NAME, "5", Collections.emptyMap()))
        assertThat(innerHits.getAt(0).getExplanation().toString(), containsString("weight(comments.message:fox in"));
        boolQuery.should(
            )
            .get();
                        .endArray()
        assertThat(innerHits.getAt(2).getNestedIdentity().getOffset(), equalTo(2));
                nestedQuery("comments.messages", matchQuery("comments.messages.message", "fox"), ScoreMode.Avg).innerHit(
        client().prepareIndex("index2")
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(1).getSourceAsMap().size(), equalTo(1));
            client().prepareIndex("test")
                        .endArray()
        assertThat(innerHits.getHits().length, equalTo(1));
        response = client().prepareSearch("articles")
import java.util.Collections;
                .setSource(
                        .addFetchField("comments.mes*")
        int size = randomIntBetween(0, numDocs);
    public void testInnerHitsWithObjectFieldThatHasANestedField() throws Exception {
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getNestedIdentity().getChild(), nullValue());
            .get();
            .endObject();
        assertThat(innerHits.getAt(0).getId(), equalTo("1"));
            )
        assertThat(messages.getTotalHits().value(), equalTo(2L));
    }
        assertHitCount(response, 1);
                    .endObject()
                    )
        assertSearchHit(response, 1, hasId("2"));
                .setSource(
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
                    .endObject()
                )
    public void testUseMaxDocInsteadOfSize() throws Exception {
            )
import org.opensearch.plugins.Plugin;
    }
            response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().get("message"),
        assertThat(response.getHits().getAt(0).getShard(), notNullValue());
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
                jsonBuilder().startObject().startArray("nested").startObject().field("field", "value1").endObject().endArray().endObject()
        assertHitCount(response, 1);
                .get()
                    .field("x", "y")
        );
        assertNoFailures(response);
                )
                jsonBuilder().startObject().startArray("nested").startObject().field("field", "value1").endObject().endArray().endObject()
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(innerHits.getAt(2).getNestedIdentity().getField().string(), equalTo("comments"));
                        .endObject()
                        .field("message", "rabbit got away")
                .setSource(
        createIndex("index2");
            .setQuery(
                        .field("n_field2", "n_value2_1")
                        .startArray("comments")
                        .startObject("comments")
                    ),
                nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.None).innerHit(
import org.opensearch.index.IndexSettings;
                SearchHit innerHit = inner.getAt(j);
        response = client().prepareSearch("articles")
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();
                    .endObject()
        SearchResponse response = client().prepareSearch()
                    .startObject("comments")
                        .field("title", "big gray elephant")
                        .field("message", "good")
                    "comments",
            assertThat(searchResponse.getHits().getAt(i).getInnerHits().get("nested1").getAt(0).getMatchedQueries()[0], equalTo("test3"));
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
            response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().get("message"),
        SearchHits innerHits = response.getHits().getAt(0).getInnerHits().get("comments");
                    .startObject("remarks")
            .get();
            equalTo("fox ate rabbit x y z")
                .setSource(
                        .endObject()
                nestedQuery(
        );
        );
        SearchHits messages = hit.getInnerHits().get("comments.messages");
        List<IndexRequestBuilder> requests = new ArrayList<>();
        requests.add(
        response = client().prepareSearch("articles")
                .setSource(
                            .startObject()
        client().prepareIndex("index2").setId("3").setSource("key", "value").get();
        assertThat(innerHits.getHits().length, equalTo(1));
            )
        assertNoFailures(searchResponse);
            .setSource(
            nestedQuery("field1", matchAllQuery(), ScoreMode.Avg).innerHit(
        assertHitCount(response, 1);
                .setSettings(Settings.builder().put("index.number_of_shards", 1))
import org.opensearch.search.SearchHit;
            numInnerObjects = field2InnerObjects[i] = scaledRandomIntBetween(1, numDocs);
            )
            .setQuery(nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.None).innerHit(new InnerHitBuilder()))
            .get();
                    jsonBuilder().startObject()
                )
                nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.Avg).innerHit(new InnerHitBuilder("comment"))
import org.opensearch.action.search.SearchResponse;
        assertThat(innerHits.getTotalHits().value(), equalTo(2L));
                        .startArray("messages")
    }
                        .field("field1", 0)
        assertNoFailures(response);
    public void testNestedMultipleLayers() throws Exception {
                            .field("n_field2", "n_value2_2")
            () -> client().prepareSearch("articles")
                    .field("type", "text")
        Exception e = expectThrows(
                    )
import org.opensearch.script.ScriptType;
        SearchResponse response = client().prepareSearch("articles")
        assertThat(
        assertThat(innerHits.getAt(1).getId(), equalTo("2"));
                .setQuery(
        assertThat(messages.getAt(0).getNestedIdentity().getField().string(), equalTo("comments.messages"));
            .get();
            .get();
                    "comments",
                        .startObject()
        assertNotNull(innerHits.getAt(0).getSourceAsMap());
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getOffset(), equalTo(0));
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
                        .startObject()
                        .field("title", "quick brown fox")
        indexRandom(true, requests);
                        .field("n_field1", "n_value1_2")
                    .field("x", "y")
                assertThat(innerHit.getNestedIdentity().getOffset(), equalTo(j));
            .setSource(
            equalTo("fox eat quick")
                        .startArray("messages")
                )
                    .field("type", "text")
                    .endObject()
        for (int i = 2; i < numDocs; i++) {
            .setFetchSource(false)
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
                    .endObject()
        // Directly refer to the second level:
        assertThat(innerHits.getAt(1).getNestedIdentity().getField().string(), equalTo("comments"));
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
                assertThat(innerHit.getNestedIdentity().getOffset(), equalTo(j));
    }
            .setQuery(
        assertAcked(prepareCreate("index1").setMapping("comments", "type=nested"));
                    new InnerHitBuilder().setFetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE)
        );
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.core.xcontent.XContentBuilder;
                        .field("message", "mice squashed by elephant x")
                        .endObject()
        indexRandomForConcurrentSearch("index1");
        requests.add(
                        .startObject("properties")
 * the Apache License, Version 2.0 (the "License"); you may
        assertAcked(
import static org.opensearch.index.query.QueryBuilders.boolQuery;
                    .endArray()
                        .endArray()
                    ScoreMode.Avg
        assertThat(hit.getId(), equalTo("1"));
            )
                assertThat(innerHit.getNestedIdentity().getChild(), nullValue());
                    .endObject()
                        .endObject()
 * this work for additional information regarding copyright
        assertThat(
    // Issue #9723
            .setSize(numDocs)
import org.apache.lucene.util.ArrayUtil;
import org.opensearch.index.query.BoolQueryBuilder;
        assertThat(innerHits.getTotalHits().value(), equalTo(2L));
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments");
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");
        assertSearchHit(response, 1, hasId("2"));
            .get();
        assertThat(innerHits.getAt(0).getId(), equalTo("2"));
                    "comments",
        assertThat(innerHits.getHits().length, equalTo(1));
            )
                        .field("title", "big gray elephant")
                        .startArray("comments")
            for (int j = 0; j < field2InnerObjects[i] && j < size; j++) {
            }
            .setQuery(
                .setId("1")
                    .startObject()
                    .field("type", "nested")
        );
            "Cannot execute inner hits. One or more parent object fields of nested field [comments.messages] are "
            .get();
                        .field("title", "quick brown fox")
 *
        response = client().prepareSearch()
        assertHitCount(response, 1);
            .get();
            .setId("1")
                        new InnerHitBuilder("remark")
                        .endObject()
 * KIND, either express or implied.  See the License for the
                )
                    new InnerHitBuilder().setFrom(50).setSize(10).setName("_name")
            .get();
        assertThat(searchResponse.getHits().getAt(0).getInnerHits().get("nested1").getAt(0).getMatchedQueries().length, equalTo(1));
                    ),
            )
                .setId("2")
                        .endObject()
                    new InnerHitBuilder().setFrom(100).setSize(10).setName("_name")
        response = client().prepareSearch("index2")
 * this file be licensed under the Apache-2.0 license or a
                        new InnerHitBuilder("remark")
        assertThat(messages.getAt(0).getNestedIdentity().getChild(), nullValue());
                jsonBuilder().startObject()
/*
            prepareCreate("articles").setMapping(
 * ownership. Elasticsearch licenses this file to you under
            .get();
        client().admin()
        QueryBuilder query = boolQuery().should(termQuery("nested1.n_field1", "n_value1_1").queryName("test1"))
        );
                nestedQuery("nested", matchQuery("nested.field", "value1"), ScoreMode.Avg).innerHit(
        indexRandom(true, requests);
                    ScoreMode.Avg
            .startObject("nested1")
            requestBuilders.add(client().prepareIndex("idx").setId(Integer.toString(i)).setSource(source));
                        .endObject()
            )
                            .field("field1", i)
            .get();
            )
    @ParametersFactory
            response.getHits().getAt(0).getInnerHits().get("comments").getAt(1).getSourceAsMap().get("message"),
            XContentBuilder source = jsonBuilder().startObject().field("foo", i).startArray("field1");
                    .startObject("properties")
import org.opensearch.index.query.InnerHitBuilder;
        // Check that inner hits contain _source even when it's disabled on the parent request.
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().size(), equalTo(2));
                    nestedQuery("comments.remarks", matchQuery("comments.remarks.message", "bad"), ScoreMode.Avg).innerHit(
        response = client().prepareSearch("articles")
        // other features (like in the query dsl or aggs) in order for consistency:
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
        assertHitCount(response, 1);
 *
    public void testTooHighResultWindow() throws Exception {
                    .startObject("message")
        assertThat(innerHits.getHits().length, equalTo(1));
            Exception.class,
                        .startObject()
    }
        SearchResponse response = client().prepareSearch("index1", "index2")
        assertNoFailures(response);
            );
            .setQuery(
import org.opensearch.search.SearchHits;
                            .field("n_field1", "n_value1_2")
                            .startArray("nested1")
import java.util.Arrays;
                    jsonBuilder().startObject()
                        .startObject("comments")
                .setId("1")
                    )
                        .endObject()
                    .endObject()
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getOffset(), equalTo(0));
 * You may obtain a copy of the License at
                        .field("message", "fox ate rabbit x y z")
                    .startObject("comments")
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments");
        client().prepareIndex("index1")
        XContentBuilder builder = jsonBuilder().startObject()
    public static class CustomScriptPlugin extends MockScriptPlugin {
            .setFetchSource(false)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                        .field("message", "neutral")
                        .startObject()
                        .endObject()
                + "not nested. All parent fields need to be nested fields too",
            )
            .startObject("properties")
                source.startObject().field("x", "y").endObject();
/*
        // return an empty _source:
import org.opensearch.test.InternalSettingsPlugin;
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
        assertNoFailures(response);
            .setQuery(
            .setQuery(
            .should(termQuery("nested1.n_field2", "n_value2_2").queryName("test3"));
        assertAcked(prepareCreate("test").setMapping(builder));
                        .field("message", "elephant captured")
                        .setExplain(true)
                        jsonBuilder().startObject()
                    nestedQuery("comments.remarks", matchQuery("comments.remarks.message", "neutral"), ScoreMode.Avg).innerHit(
        );
                    .field("message", "rabbit got away")
 *
                )
                        .endArray()
        assertThat(innerHits.getAt(0).getFields().get("script").getValue().toString(), equalTo("5"));
import java.util.Map;
                        .field("message", "hippo is hungry")
            containsString("the inner hit definition's [_name]'s from + size must be less than or equal to: [100] but was [110]")
        );
                .get()
        );
import org.opensearch.action.search.SearchPhaseExecutionException;
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
                    new InnerHitBuilder().setFetchSourceContext(
                .setSource(
                    jsonBuilder().startObject()
        assertAcked(
        );
                        .endArray()
                nestedQuery(
        Exception e = expectThrows(
        assertThat(searchResponse.getHits().getAt(0).getInnerHits().get("nested1").getAt(0).getMatchedQueries()[0], equalTo("test1"));
 * Unless required by applicable law or agreed to in writing,
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
                .setSource(
                    .startObject("properties")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("0"));
        assertHitCount(response, 1);
            () -> client().prepareSearch("index2")
            for (int j = 0; j < numInnerObjects; j++) {
        assertThat(innerHits.getHits().length, equalTo(1));
            .get();
                .setId("1")
        assertThat(innerHits.getAt(2).getId(), equalTo("2"));
                    nestedQuery("nested_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)
            .get();
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
        assertThat(innerHits.getAt(0).getId(), equalTo("2"));
                        .field("message", "fox eat quick")
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getField().string(), equalTo("remarks"));
package org.opensearch.search.fetch.subphase;
        assertNoFailures(response);
                    new InnerHitBuilder().setFetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE)
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
        response = client().prepareSearch("articles")
            int numInnerObjects = field1InnerObjects[i] = scaledRandomIntBetween(1, numDocs);
            inner = searchHit.getInnerHits().get("b");
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
        }
        assertThat(innerHits.getAt(1).getNestedIdentity().getOffset(), equalTo(1));
            .get();
                .setSource(
import static org.hamcrest.Matchers.containsString;
 * The OpenSearch Contributors require contributions made to
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");
        indexRandom(true, requestBuilders);
                    .field("type", "text")
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getOffset(), equalTo(0));
                        new InnerHitBuilder().setFrom(100).setSize(10).setName("_name")
                    )
                    .field("x", "y")
        e = expectThrows(
            innerHits.getAt(0).getHighlightFields().get("comments.message").getFragments()[0].string(),
                        .endObject()
                )
            .get();
            .setQuery(
        assertThat(innerHits.getAt(1).getId(), equalTo("1"));
        assertThat(innerHits.getTotalHits().value(), equalTo(3L));
            )
            )
            response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getNestedIdentity().getField().string(),
 * compatible open source license.
            .endObject()
import java.util.List;
        assertThat(innerHits.getAt(0).getId(), equalTo("1"));
                        .field("n_field2", "n_value2_2")
                    nestedQuery("comments.messages", matchQuery("comments.messages.message", "fox"), ScoreMode.Avg).innerHit(
        assertSearchHit(response, 1, hasId("1"));
        indexRandom(true, requests);
        assertThat(messages.getTotalHits().value(), equalTo(1L));
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getNestedIdentity().getOffset(), equalTo(0));
        assertThat(searchResponse.getHits().getAt(1).getInnerHits().get("nested1").getTotalHits().value(), equalTo(1L));
                        .field("message", "fox eat quick")
                )
                    nestedQuery("comments.messages", matchQuery("comments.messages.message", "fox"), ScoreMode.Avg).innerHit(
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
            client().prepareIndex("articles")
        List<IndexRequestBuilder> requestBuilders = new ArrayList<>();
        response = client().prepareSearch("articles")
        assertThat(
                    .startObject("properties")
                        .endArray()
                    jsonBuilder().startObject()
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));
                    .endObject()
            }
            .setQuery(
                )
        assertHitCount(response, 1);
        requests.add(
                )
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
                        .endArray()
            .get();
                .setId("1")
        assertThat(messages.getAt(1).getNestedIdentity().getOffset(), equalTo(0));
            prepareCreate("articles")
        assertThat(innerHits.getAt(0).getId(), equalTo("1"));
            prepareCreate("articles").setMapping(
                    )
        assertNoFailures(response);
            .setQuery(
        assertEquals(
        }
        assertThat(
            .get();
                    .field("type", "text")
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
        assertThat(
                        .startObject()
                    .startObject("message")
                    jsonBuilder().startObject()
            () -> client().prepareSearch("articles")
        );
        response = client().prepareSearch()
            .setId("1")
        assertNoFailures(response);
                nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.Avg).innerHit(
        assertHitCount(response, 1);
        assertThat(
                assertThat(innerHit.getNestedIdentity().getChild(), nullValue());
        requests = new ArrayList<>();
            new InnerHitBuilder().addSort(new FieldSortBuilder("nested1.n_field1").order(SortOrder.ASC))
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getOffset(), equalTo(0));
        assertThat(innerHits.getAt(1).getNestedIdentity().getField().string(), equalTo("comments"));
        );
        }
        indexRandomForConcurrentSearch("index2");
                        .field("message", "bear eat quick")
        indexRandomForConcurrentSearch("index1", "index2");
            .setQuery(query)
            source.endArray().endObject();
        response = client().prepareSearch("articles")
            )
            .get();
import org.opensearch.script.MockScriptPlugin;
            new InnerHitBuilder().setSize(ArrayUtil.MAX_ARRAY_LENGTH - 1)
                        .endObject()
                nestedQuery(
                        .endObject()
        indexRandom(true, requests);
        int[] field2InnerObjects = new int[numDocs];
        SearchResponse searchResponse = client().prepareSearch("test")
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
            )
            }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertNoFailures(response);
                        new FetchSourceContext(true, new String[] { "comments.missing_field" }, null)
        e = expectThrows(
        assertThat(innerHits.getAt(0).getId(), equalTo("1"));
            nestedQuery("field2", matchAllQuery(), ScoreMode.Avg).innerHit(
            .setId("1")
                        .field("message", "fox eat quick")
        assertNoFailures(response);
        response = client().prepareSearch("articles")
                    "comments",
                )
        assertThat(innerHits.getHits().length, equalTo(1));
        );
                )
                        .startArray("remarks")
        assertHitCount(searchResponse, numDocs);
        assertThat(messages.getTotalHits().value(), equalTo(1L));
        assertNoFailures(response);
                    nestedQuery("comments.remarks", matchQuery("comments.remarks.message", "good"), ScoreMode.Avg).innerHit(
                    .startObject("properties")
        response = client().prepareSearch("articles")
        assertNoFailures(response);
                        .endObject()
            .startObject("field1")
                .setId("0")
                .setQuery(
                nestedQuery("nested", matchQuery("nested.field", "value1"), ScoreMode.Avg).innerHit(
        for (int i = 0; i < numDocs; i++) {
                        .endObject()
                        .endObject()
                        new InnerHitBuilder("remark")
        assertThat(messages.getAt(0).getNestedIdentity().getOffset(), equalTo(2));
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), ArrayUtil.MAX_ARRAY_LENGTH))
            .setRefreshPolicy(IMMEDIATE)
        SearchHit hit = response.getHits().getAt(0);
                )
import org.opensearch.search.sort.FieldSortBuilder;
        assertThat(messages.getAt(0).getNestedIdentity().getField().string(), equalTo("comments.messages"));
                        .field("message", "no fox")
        int numDocs = scaledRandomIntBetween(25, 100);
        );
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getTotalHits().value(), equalTo(1L));
            )
            equalTo("fox ate rabbit x y z")
 * Licensed to Elasticsearch under one or more contributor
        );
import org.apache.lucene.search.join.ScoreMode;
        );
        assertThat(searchResponse.getHits().getAt(1).getInnerHits().get("nested1").getAt(0).getMatchedQueries()[0], equalTo("test2"));
                    )
        }
                )
import org.opensearch.action.index.IndexRequestBuilder;
                    "comments",
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments");
            e.getCause().getCause().getMessage()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            client().prepareIndex("articles")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    ),
                        .field("n_field1", "n_value1_8")
            "Cannot execute inner hits. One or more parent object fields of nested field [comments.messages] are "
                new InnerHitBuilder("a").setSize(size).addSort(new FieldSortBuilder("_doc").order(SortOrder.ASC))
                    nestedQuery("nested", matchQuery("nested.field", "value1"), ScoreMode.Avg).innerHit(
 * not use this file except in compliance with the License.
        innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
    }
        assertNoFailures(response);
            .get();
            )
                nestedQuery("comments", matchQuery("comments.message", "away"), ScoreMode.None).innerHit(
            .indices()
                    .startArray("comments")
        messages = hit.getInnerHits().get("comments.messages");
        query = nestedQuery("nested1", query, ScoreMode.Avg).innerHit(
        assertNoFailures(response);
import org.opensearch.script.MockScriptEngine;
                    .endObject()
            SearchPhaseExecutionException.class,
        assertNoFailures(response);
            .setQuery(
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .setSize(numDocs)
                        .endObject()
                    .setId(String.valueOf(i))
            for (int j = 0; j < field1InnerObjects[i] && j < size; j++) {
        assertFalse(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().isEmpty());
                    .startObject("properties")
                            .endObject()
        assertNoFailures(response);
                    ),
            .field("type", "long")
                )
        response = client().prepareSearch("index2")
            .addSort("foo", SortOrder.ASC)
                        .startObject()
/*
        return Arrays.asList(InternalSettingsPlugin.class, CustomScriptPlugin.class);
                        new InnerHitBuilder("remark")
            .setQuery(nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.None).innerHit(new InnerHitBuilder()))
import org.opensearch.search.sort.SortOrder;
        assertThat(innerHits.getAt(0).getFields().get("comments.message").getValue().toString(), equalTo("eat"));
            Exception.class,
                        .startObject()
                nestedQuery("comments.messages", matchQuery("comments.messages.message", "bear"), ScoreMode.Avg).innerHit(
                        .field("type", "nested")
            )
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
            .setQuery(
                    nestedQuery("comments.remarks", matchQuery("comments.remarks.message", "good"), ScoreMode.Avg).innerHit(
        assertThat(messages.getAt(1).getNestedIdentity().getChild(), nullValue());
        );
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getTotalHits().value(), equalTo(2L));
            return Collections.singletonMap("5", script -> "5");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
            )
        assertThat(searchResponse.getHits().getHits().length, equalTo(numDocs));
        assertThat(searchResponse.getHits().getAt(0).getInnerHits().get("nested1").getAt(1).getMatchedQueries().length, equalTo(1));
            .get();
        // Check we can load the first doubly-nested document.
    }
        assertSearchHits(response, "1", "3");
        assertThat(messages.getAt(1).getNestedIdentity().getField().string(), equalTo("comments.messages"));
                        .endObject()
                            .field("n_field1", "n_value1_8")
        int numDocs = randomIntBetween(2, 35);
        requests.add(
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
                ).innerHit(new InnerHitBuilder())
        refresh();
        assertThat(
                    .field("type", "nested")
import org.opensearch.common.settings.Settings;
import java.util.function.Function;
        );
                        .startArray("nested1")
                    .startObject()
        assertNoFailures(response);
                        .startObject()
import java.util.ArrayList;
        assertSearchHit(response, 1, hasId("2"));
            .endObject()
        }
                        .startObject()
        List<IndexRequestBuilder> requests = new ArrayList<>();
                        .field("n_field2", "n_value2_1")
        );
                        .field("title", "quick brown fox")
                        .innerHit(new InnerHitBuilder().setIgnoreUnmapped(true))
            .setQuery(
                    .endObject()
                    .endObject()
public class InnerHitsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                // (See expectThrows(...) below)
                        .field("title", "quick brown fox")
            equalTo("comments")
                + "not nested. All parent fields need to be nested fields too",
            .setQuery(
                    nestedQuery("nested", matchQuery("nested.field", "value1"), ScoreMode.Avg).innerHit(
                        .endObject()
                        .startArray("nested1")
                )
                    .startObject("message")
                        .startObject()
        requests.add(
        );
                        .field("type", "object")
            client().prepareIndex("test")
        assertHitCount(response, 2);
                .get()
            .should(termQuery("nested1.n_field1", "n_value1_3").queryName("test2"))
            .get();
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments.remarks");
                            .endArray()
                    ),
        );
                .setId("1")
    public static Collection<Object[]> parameters() {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        @Override
            .indices()
        indexRandomForConcurrentSearch("index2");
        assertThat(hit.getId(), equalTo("1"));
            .get();
                    new InnerHitBuilder()
        assertThat(innerHits.getHits().length, equalTo(3));
                    .endObject()
                        .startArray("comments")
        assertThat(hit.getId(), equalTo("1"));
        assertThat(searchResponse.getHits().getAt(0).getInnerHits().get("nested1").getAt(1).getMatchedQueries()[0], equalTo("test3"));
            .setQuery(
        assertAcked(prepareCreate("idx").setMapping("field1", "type=nested", "field2", "type=nested"));
                        .field("n_field1", "n_value1_3")
        // the field name (comments.message) used for source filtering should be the same as when using that field for
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(String.valueOf(i)));
import java.util.Collection;
        );
            .get();
                )
                        .endArray()
                        .endObject()
                client().prepareIndex("test")
 * software distributed under the License is distributed on an
        assertNoFailures(response);
                    new InnerHitBuilder().addDocValueField("comments.mes*").setSize(1)
                        .endObject()
        assertThat(innerHits.getAt(0).getFields().get("comments.message").getValue().toString(), equalTo("fox eat quick"));
                    new InnerHitBuilder().setFrom(10).setSize(100).setName("_name")
                .setMapping(
            e.getCause().getMessage(),
                        .startObject("properties")
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getTotalHits().value(), equalTo(2L));
                        .endObject()
                    ScoreMode.Avg
                        .field("n_field1", "n_value1_1")
        return Arrays.asList(
            .setRefreshPolicy(IMMEDIATE)
        indexRandom(true, requests);
import static org.hamcrest.Matchers.notNullValue;
                new InnerHitBuilder("b").addSort(new FieldSortBuilder("_doc").order(SortOrder.ASC)).setSize(size)
                SearchHit innerHit = inner.getAt(j);
                .setQuery(
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
import static org.hamcrest.Matchers.equalTo;
                            .field("n_field2", "n_value2_5")
            .get();
        assertHitCount(response, 1);
                        .startObject("comments")
            containsString("the inner hit definition's [_name]'s from + size must be less than or equal to: [100] but was [110]")
            .get();
        assertHitCount(response, 1);
        assertSearchHit(response, 1, hasId("1"));
        );
                            .endObject()
 * GitHub history for details.
                    .endObject()
                        .endObject()
        assertThat(searchResponse.getHits().getAt(1).getInnerHits().get("nested1").getAt(0).getMatchedQueries().length, equalTo(1));
                nestedQuery("comments", matchQuery("comments.message", "elephant"), ScoreMode.Avg).innerHit(new InnerHitBuilder("comment"))
    }
                        .endObject()
            response.getHits().getAt(0).getInnerHits().get("comments").getAt(1).getSourceAsMap().get("message"),
            assertThat(searchResponse.getHits().getAt(i).getInnerHits().get("nested1").getTotalHits().value(), equalTo(1L));
                    jsonBuilder().startObject()
    public void testRandomNested() throws Exception {
                .setId("2")
                        .endObject()
            .endObject()
                )
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getTotalHits().value(), equalTo(1L));
                        .endObject()
                        .endObject()
            .prepareUpdateSettings("index2")
        assertNoFailures(searchResponse);
        List<IndexRequestBuilder> requests = new ArrayList<>();
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(1));
        requests.add(
                        new InnerHitBuilder()
    public void testNestedSource() throws Exception {
                        .startArray("comments")
            requests.add(
import org.opensearch.script.Script;
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
                        .startObject()
                    .endObject()
                )
                        .startArray("comments")
            .setQuery(
                        .endArray()
                        .startObject()
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments");
    public void testSimpleNested() throws Exception {
            .addSort("field1", SortOrder.ASC)
                    jsonBuilder().startObject()
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getTotalHits().value(), equalTo(2L));
            )
            .endObject()
                        .startObject("messages")
                        .endObject()
                        .field("title", "quick brown fox")
import static org.hamcrest.Matchers.nullValue;
            .setQuery(
                        .field("message", "fox eat quick")
import org.opensearch.index.query.QueryBuilder;
            e.getCause().getMessage(),
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");
                ).should(termQuery("key", "value"))
        assertThat(messages.getAt(0).getNestedIdentity().getChild(), nullValue());
        assertThat(messages.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
        assertThat(messages.getAt(0).getId(), equalTo("1"));
            for (int j = 0; j < numInnerObjects; j++) {
                )
        assertNoFailures(response);
        assertNoFailures(response);
            e.getCause().getCause().getMessage()
            )
        SearchResponse searchResponse = client().prepareSearch("idx")
                        .startObject()
        messages = hit.getInnerHits().get("comments.messages");
            SearchHits inner = searchHit.getInnerHits().get("a");
                    .endObject()
                        new InnerHitBuilder("remark")
            .field("type", "keyword")
                    .startObject()
            source.endArray().startArray("field2");
        hit = response.getHits().getAt(0);
                )
                        .endObject()
            .setQuery(boolQuery)
            )
                        .endArray()
                        .endObject()
                .setQuery(
            assertThat(inner.getTotalHits().value(), equalTo((long) field1InnerObjects[i]));
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
}
            )
                            .endObject()
                        .startObject()
            equalTo("fox eat quick")
        response = client().prepareSearch("articles")
    public void testInnerHitsWithIgnoreUnmapped() throws Exception {
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
import org.opensearch.cluster.health.ClusterHealthStatus;
        response = client().prepareSearch()
    @Override
        requests.add(
import static org.opensearch.index.query.QueryBuilders.matchQuery;

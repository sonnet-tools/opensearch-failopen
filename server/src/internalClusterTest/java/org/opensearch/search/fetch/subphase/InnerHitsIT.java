                .setSource(
        response = client().prepareSearch("articles")  
                    jsonBuilder().startObject()
                    "comments",
                )
                        .endObject()
                )
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments.remarks");  
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
        assertNoFailures(response);
        assertThat(messages.getAt(0).getNestedIdentity().getChild(), nullValue());
        assertFalse(innerHits.getAt(0).getSourceAsMap().isEmpty());
        messages = hit.getInnerHits().get("comments.messages");  
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getTotalHits().value(), equalTo(2L));
        assertThat(hit.getId(), equalTo("1"));
                    nestedQuery("nested", matchQuery("nested.field", "value1"), ScoreMode.Avg).innerHit(
        assertThat(messages.getAt(1).getNestedIdentity().getField().string(), equalTo("comments.messages"));
            assertThat(inner.getTotalHits().value(), equalTo((long) field1InnerObjects[i]));  
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getOffset(), equalTo(0));  
            Exception.class,  
                    .startObject("remarks")  
        assertThat(searchResponse.getHits().getAt(0).getInnerHits().get("nested1").getAt(1).getMatchedQueries().length, equalTo(1));  
        hit = response.getHits().getAt(0);
        assertNoFailures(response);  
 * Unless required by applicable law or agreed to in writing,
                ).innerHit(new InnerHitBuilder().setFetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE))  
                        .endObject()
        indexRandom(true, requests);  
            .startObject("nested1")
                            .field("n_field1", "n_value1_2")  
                assertThat(innerHit.getNestedIdentity().getField().string(), equalTo("field1"));  
                        .endObject()
        assertSearchHit(response, 1, hasId("1"));
        );
import org.opensearch.action.index.IndexRequestBuilder;
                        .startArray("comments")  
import static org.hamcrest.Matchers.equalTo;
                .setId("1")
        assertHitCount(searchResponse, numDocs);  
        return Arrays.asList(InternalSettingsPlugin.class, CustomScriptPlugin.class);  
        List<IndexRequestBuilder> requests = new ArrayList<>();  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) numDocs));
            .get();
            .setQuery(
        indexRandomForConcurrentSearch("index1");
            SearchHit searchHit = searchResponse.getHits().getAt(i);  
        indexRandom(true, requests);
            containsString("the inner hit definition's [_name]'s from + size must be less than or equal to: [100] but was [110]")
        );
                )
                    nestedQuery("nested", matchQuery("nested.field", "value1"), ScoreMode.Avg).innerHit(  
    @ParametersFactory
            )  
            source.endArray().endObject();  
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
        );
            )
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getTotalHits().value(), equalTo(2L));  
            )
        assertAcked(prepareCreate("test").setMapping(builder));  
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
                        .endObject()  
            .setQuery(  
            innerHits.getAt(0).getHighlightFields().get("comments.message").getFragments()[0].string(),
            .get();
        requests.add(
        SearchResponse response = client().prepareSearch()  
                    )  
                SearchHit innerHit = inner.getAt(j);
                    new InnerHitBuilder().setHighlightBuilder(new HighlightBuilder().field("comments.message"))  
        requests = new ArrayList<>();  
                        .endObject()
        assertAcked(prepareCreate("index2").setMapping("nested", "type=nested"));
        assertEquals(  
                        .field("type", "nested")
            .setRefreshPolicy(IMMEDIATE)
                    .field("type", "text")
        assertNoFailures(response);
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
                    ScoreMode.Avg  
import java.util.Collection;  
            for (int j = 0; j < field1InnerObjects[i] && j < size; j++) {
                )  
                        .endObject()
        );
        assertHitCount(response, 1);  
        );
        @Override
                    .endObject()
            response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().get("message"),
            client().prepareIndex("test")
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
                    .startObject("title")
        assertThat(innerHits.getAt(2).getNestedIdentity().getOffset(), equalTo(2));
                    .field("message", "quick brown fox")
        assertThat(innerHits.getHits().length, equalTo(1));
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(1));
                        .endArray()
        int size = randomIntBetween(0, numDocs);
        );
        response = client().prepareSearch("articles")
                    nestedQuery("comments.remarks", matchQuery("comments.remarks.message", "good"), ScoreMode.Avg).innerHit(
                .setSource(
                )  
                ).should(termQuery("key", "value"))
        assertThat(innerHits.getAt(1).getNestedIdentity().getOffset(), equalTo(1));
        assertThat(innerHits.getTotalHits().value(), equalTo(3L));  
        assertNoFailures(response);  
            .setId("1")  
            equalTo("comments")  
        );
                        .field("title", "quick brown fox")  
            .setQuery(
                        .startObject()
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
                        .field("message", "no fox")
                assertThat(innerHit.getNestedIdentity().getChild(), nullValue());
                    )
        assertThat(innerHits.getAt(0).getId(), equalTo("1"));  
                        .field("n_field1", "n_value1_8")
        assertThat(
            .setQuery(
                        .endObject()  
                        .endObject()
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));  
        requests.add(  
                )  
        );
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getOffset(), equalTo(0));
        client().prepareIndex("index2")  
                            .field("n_field1", "n_value1_8")
            .setQuery(
        }
                .setSource(
                    .endObject()  
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
            () -> client().prepareSearch("articles")
        assertThat(innerHits.getAt(1).getId(), equalTo("1"));  
                    ScoreMode.Avg
                        .endObject()  
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments");  
        assertNoFailures(response);
                        jsonBuilder().startObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
    }
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("0"));
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));  
        assertThat(messages.getAt(1).getNestedIdentity().getChild(), nullValue());  
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
import org.opensearch.cluster.health.ClusterHealthStatus;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;  
        assertThat(
    }
 * GitHub history for details.
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));  
                        .endObject()
                ).innerHit(new InnerHitBuilder())
        // index the message in an object form instead of an array
            assertThat(searchHit.getShard(), notNullValue());
                        .startArray("nested1")
                        .field("message", "fox eat quick")  
        for (int i = 2; i < numDocs; i++) {
import java.util.ArrayList;
            .setFetchSource(false)
    }
            .get();
                        .startArray("remarks")
                boolQuery().should(
 * Modifications Copyright OpenSearch Contributors. See
                nestedQuery("comments.messages", matchQuery("comments.messages.message", "bear"), ScoreMode.Avg).innerHit(
import org.opensearch.search.sort.FieldSortBuilder;
        response = client().prepareSearch("articles")
        assertThat(innerHits.getAt(2).getId(), equalTo("2"));
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getTotalHits().value(), equalTo(2L));
                        .endObject()  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("1"));  
        response = client().prepareSearch("articles")
    public static class CustomScriptPlugin extends MockScriptPlugin {  
        SearchHits innerHits = response.getHits().getAt(0).getInnerHits().get("comment");  
                .setQuery(  
        assertThat(innerHits.getHits().length, equalTo(3));
        assertNoFailures(response);  
        assertSearchHit(response, 1, hasId("2"));
            )
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
        response = client().prepareSearch()  
        assertAcked(
                        .startObject()
            .setRefreshPolicy(IMMEDIATE)
            .get();
            .get();
import org.apache.lucene.util.ArrayUtil;
                ).innerHit(new InnerHitBuilder())
 * The OpenSearch Contributors require contributions made to  
            SearchPhaseExecutionException.class,
                    .startObject()
                        .startObject()
import static org.opensearch.index.query.QueryBuilders.boolQuery;
            .get();  
        );
        );
                        .field("message", "good")  
            .get();
                        .startObject("comments")  
                )  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(innerHits.getAt(0).getId(), equalTo("1"));
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");
            client().prepareIndex("articles")
        assertThat(innerHits.getAt(0).getId(), equalTo("2"));  
        assertThat(innerHits.getAt(0).getFields().get("comments.message").getValue().toString(), equalTo("fox eat quick"));
                nestedQuery("nested", matchQuery("nested.field", "value1"), ScoreMode.Avg).innerHit(
            .setSource(
                    new InnerHitBuilder().setFrom(50).setSize(10).setName("_name")
                    .startObject("title")  
/*  
        );  
            equalTo("fox eat quick")
                        .addFetchField("comments.mes*")
                        new FetchSourceContext(true, new String[] { "comments.missing_field" }, null)
                nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.Avg).innerHit(
                    new InnerHitBuilder().setFetchSourceContext(new FetchSourceContext(true, new String[] { "comments.message" }, null))  
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getField().string(), equalTo("remarks"));  
        assertAcked(prepareCreate("idx").setMapping("field1", "type=nested", "field2", "type=nested"));
            inner = searchHit.getInnerHits().get("b");
                            .endObject()
    public void testNestedMultipleLayers() throws Exception {
            .field("type", "keyword")  
            new InnerHitBuilder().addSort(new FieldSortBuilder("nested1.n_field1").order(SortOrder.ASC))
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
                        .endArray()
            .setSource(
        // Check that inner hits contain _source even when it's disabled on the root request.
                        .endObject()
                .get()
                    .startObject("properties")
        messages = hit.getInnerHits().get("comments.messages");
                nestedQuery("nested", matchQuery("nested.field", "value1"), ScoreMode.Avg).innerHit(
            .startObject("properties")
        List<IndexRequestBuilder> requests = new ArrayList<>();
            prepareCreate("articles").setMapping(  
                        .setExplain(true)
                            .field("n_field2", "n_value2_2")
                .setId("1")  
                    ),
            .field("type", "nested")  
                    .endObject()
                    jsonBuilder().startObject()
    public static Collection<Object[]> parameters() {  
                        .endObject()
        innerHits = response.getHits().getAt(0).getInnerHits().get("comment");
            Exception.class,
            client().prepareIndex("test")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHit;  
        // other features (like in the query dsl or aggs) in order for consistency:
import org.opensearch.action.search.SearchResponse;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
    }  
                        new InnerHitBuilder("remark")
            assertThat(inner.getTotalHits().value(), equalTo((long) field2InnerObjects[i]));  
        assertThat(messages.getAt(0).getNestedIdentity().getOffset(), equalTo(1));
                )
                        .endArray()
                        .field("message", "neutral")
            )  
    }  
        for (int i = 2; i < numDocs; i++) {
        assertNotNull(innerHits.getAt(0).getSourceAsMap());
                        .startObject()
        super(staticSettings);
                        .field("n_field1", "n_value1_3")  
                )
                    .endObject()
                )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
            );  
    }
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
        assertThat(innerHits.getTotalHits().value(), equalTo(2L));
        assertThat(messages.getAt(0).getId(), equalTo("1"));
        assertSearchHits(response, "1", "3");
        assertThat(innerHits.getAt(0).getId(), equalTo("1"));  
                .setSource(
        assertThat(  
            .setQuery(
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().size(), equalTo(2));
            e.getCause().getCause().getMessage()
                )
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().size(), equalTo(1));
        indexRandomForConcurrentSearch("index2");
        response = client().prepareSearch("articles")
            () -> client().prepareSearch("index2")
                        .startObject()
            e.getCause().getCause().getMessage()  
                        .endObject()
                        new InnerHitBuilder("remark")  
                assertThat(innerHit.getNestedIdentity().getChild(), nullValue());
                )  
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getField().string(), equalTo("remarks"));
                    "comments",  
                nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.Avg).innerHit(
        );  
import org.opensearch.index.query.InnerHitBuilder;
        assertThat(messages.getTotalHits().value(), equalTo(1L));
        assertThat(searchResponse.getHits().getAt(0).getInnerHits().get("nested1").getAt(0).getMatchedQueries()[0], equalTo("test1"));
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().size(), equalTo(2));
                    nestedQuery("comments.remarks", matchQuery("comments.remarks.message", "neutral"), ScoreMode.Avg).innerHit(
                        .innerHit(new InnerHitBuilder().setIgnoreUnmapped(true))
                nestedQuery("comments.messages", matchQuery("comments.messages.message", "fox"), ScoreMode.Avg).innerHit(  
        assertThat(innerHits.getHits().length, equalTo(1));
        int numDocs = randomIntBetween(2, 35);
                    .endObject()
                    .endObject()
                            .field("n_field2", "n_value2_5")  
            response.getHits().getAt(0).getInnerHits().get("comments").getAt(1).getSourceAsMap().get("message"),  
        response = client().prepareSearch("articles")
            .get();
                        .field("message", "fox eat quick")  
            }
            )
        assertNoFailures(response);  
                        .endObject()  
        assertThat(innerHits.getAt(0).getId(), equalTo("2"));
            client().prepareIndex("articles")
        XContentBuilder builder = jsonBuilder().startObject()  
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));  
                + "not nested. All parent fields need to be nested fields too",  
        assertNoFailures(response);
        SearchResponse response = client().prepareSearch("articles")  
        // Source filter on a field that does not exist inside the nested document and just check that we do not fail and
        }
        assertSearchHit(response, 1, hasId("2"));
 *
            .setSize(numDocs)
        assertNoFailures(response);
                        .startObject()  
                        .endObject()  
                    "comments",
        indexRandomForConcurrentSearch("index1", "index2");
import java.util.Map;  
public class InnerHitsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        SearchHit hit = response.getHits().getAt(0);
        int[] field1InnerObjects = new int[numDocs];
                    .startArray("comments")
                )  
        );
                + "not nested. All parent fields need to be nested fields too",
            .setQuery(
                    new InnerHitBuilder().setFrom(10).setSize(100).setName("_name")  
        assertNoFailures(response);  
                    .field("fielddata", true)
        assertHitCount(response, 1);
            containsString("the inner hit definition's [_name]'s from + size must be less than or equal to: [100] but was [110]")  
            assertThat(searchResponse.getHits().getAt(i).getId(), equalTo(String.valueOf(i)));  
        requests.add(
                ).innerHit(new InnerHitBuilder())
                jsonBuilder().startObject()
                SearchHit innerHit = inner.getAt(j);
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
            int numInnerObjects = field1InnerObjects[i] = scaledRandomIntBetween(1, numDocs);
                )
        assertHitCount(response, 1);  
        waitForRelocation(ClusterHealthStatus.GREEN);
        );  
        );
        assertNoFailures(searchResponse);
        assertNoFailures(response);
                        .field("message", "fox ate rabbit x y z")
        for (int i = 0; i < numDocs; i++) {
            assertThat(searchResponse.getHits().getAt(i).getInnerHits().get("nested1").getAt(0).getMatchedQueries().length, equalTo(1));
                source.startObject().field("x", "y").endObject();
        assertThat(messages.getAt(1).getNestedIdentity().getOffset(), equalTo(0));
                        .field("message", "fox eat quick")
        assertThat(messages.getAt(0).getNestedIdentity().getOffset(), equalTo(2));
            e.getCause().getMessage(),
                        .startArray("nested1")  
            .setQuery(
            .indices()  
                    .startObject()  
            .startObject("field1")
        Exception e = expectThrows(  
            .get();
    public void testMatchesQueriesNestedInnerHits() throws Exception {
import org.opensearch.search.sort.SortOrder;  
            "Cannot execute inner hits. One or more parent object fields of nested field [comments.messages] are "
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));  
        Exception e = expectThrows(
        indexRandom(true, requests);
        assertThat(innerHits.getAt(0).getExplanation().toString(), containsString("weight(comments.message:fox in"));
                        .startArray("comments")
import java.util.function.Function;
        assertThat(innerHits.getAt(1).getNestedIdentity().getField().string(), equalTo("comments"));
        assertHitCount(response, 2);  
                    .endObject()
        );
                )
        boolQuery.should(  
                        new InnerHitBuilder("remark")
                    .setSource(  
        assertThat(hit.getId(), equalTo("1"));
        assertNoFailures(response);
        client().admin()  
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
                jsonBuilder().startObject().startArray("nested").startObject().field("field", "value1").endObject().endArray().endObject()
                    .startObject()
                        .endArray()
                            .endObject()
        response = client().prepareSearch("articles")  
        assertThat(messages.getAt(0).getId(), equalTo("1"));  
import java.util.Arrays;
        requests.add(  
                .setId("2")
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments");  
                    new InnerHitBuilder().setFrom(100).setSize(10).setName("_name")
                        .endObject()
            )  
        assertHitCount(response, 1);
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(1));
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
import org.opensearch.index.query.BoolQueryBuilder;  
                    .field("x", "y")  
                .setId("1")
                )
        requests.add(  
        boolQuery.should(
            .endObject();
            )
        requests.add(
                    ),  
        assertThat(innerHits.getHits().length, equalTo(1));
        refresh();
        assertThat(messages.getAt(0).getNestedIdentity().getField().string(), equalTo("comments.messages"));  
        );
        refresh();  
                        .startObject()  
        assertFalse(innerHits.getAt(0).getSourceAsMap().isEmpty());
/*
        client().prepareIndex("index1")  
        assertThat(hit.getId(), equalTo("1"));  
            e.getCause().getMessage(),
            .setQuery(
        client().prepareIndex("index2")
                        new InnerHitBuilder().setFrom(10).setSize(100).setName("_name")
                ).innerHit(new InnerHitBuilder())
                .get()
            .setQuery(
        assertThat(innerHits.getAt(0).getId(), equalTo("1"));  
        SearchResponse response = client().prepareSearch("index1", "index2")  
        assertThat(searchResponse.getHits().getAt(1).getInnerHits().get("nested1").getTotalHits().value(), equalTo(1L));
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getId(), equalTo("1"));  
        List<IndexRequestBuilder> requests = new ArrayList<>();  
                        .field("n_field2", "n_value2_2")  
                nestedQuery(
 *    http://www.apache.org/licenses/LICENSE-2.0
            )
        assertSearchHit(response, 1, hasId("1"));  
        assertHitCount(response, 1);  
            .setSource(
        );  
                .setQuery(
        assertThat(searchResponse.getHits().getHits().length, equalTo(numDocs));
                        .startArray("messages")
            .setQuery(query)
        assertThat(innerHits.getHits().length, equalTo(1));
            )
            SearchPhaseExecutionException.class,  
                        .startObject("properties")
                )  
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                        .startObject()
            source.endArray().startArray("field2");
            }  
        assertSearchHit(response, 1, hasId("2"));
                        new InnerHitBuilder("remark")
            .get();  
import java.util.Collections;
package org.opensearch.search.fetch.subphase;
        response = client().prepareSearch("articles")
                            .endObject()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
 * not use this file except in compliance with the License.
                nestedQuery("comments", matchQuery("comments.message", "elephant"), ScoreMode.Avg).innerHit(new InnerHitBuilder("comment"))  
            )
        assertThat(  
                        .startObject()
            .endObject()
                .get()
                )
                        .endObject()
            .should(termQuery("nested1.n_field1", "n_value1_3").queryName("test2"))
            )  
        assertNoFailures(response);
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(1).getSourceAsMap().size(), equalTo(1));
                new InnerHitBuilder("a").setSize(size).addSort(new FieldSortBuilder("_doc").order(SortOrder.ASC))  
        assertAcked(prepareCreate("index1").setMapping("nested_type", "type=nested"));
    public void testInnerHitsWithIgnoreUnmapped() throws Exception {
                .setMapping(  
            .get();
        assertAcked(
                    new InnerHitBuilder().addDocValueField("comments.mes*").setSize(1)
                            .field("field1", i)
 */  
            client().prepareIndex("articles")  
import static org.hamcrest.Matchers.nullValue;  
        e = expectThrows(  
                .setId("1")
                        .startObject("properties")
                            .startArray("nested1")  
                    .startObject("message")  
        client().prepareIndex("index1").setId("1").setSource("nested_type", Collections.singletonMap("key", "value")).get();
        for (int i = 0; i < numDocs; i++) {
                        .endObject()
            .get();
                        .startObject()
                .get()
        assertThat(searchResponse.getHits().getAt(0).getInnerHits().get("nested1").getTotalHits().value(), equalTo(2L));  
            .get();  
                    .startObject("comments")  
                source.startObject().field("x", "y").endObject();
                    ),
                        .field("message", "elephant captured")  
}
        assertThat(innerHits.getAt(0).getFields().get("comments.message").getValue().toString(), equalTo("eat"));  
                .setSource(  
            )
            assertThat(searchResponse.getHits().getAt(i).getInnerHits().get("nested1").getTotalHits().value(), equalTo(1L));
        response = client().prepareSearch()  
                .setId("2")  
            .addSort("field1", SortOrder.ASC)  
    }
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
        );  
import org.opensearch.script.Script;  
                    nestedQuery("comments.messages", matchQuery("comments.messages.message", "fox"), ScoreMode.Avg).innerHit(
            }  
            for (int j = 0; j < numInnerObjects; j++) {  
                        .startArray("comments")
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getOffset(), equalTo(0));
            .get();
                        .endObject()
                    jsonBuilder().startObject()  
                        .endObject()  
    public void testInnerHitsWithObjectFieldThatHasANestedField() throws Exception {  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                nestedQuery("comments.messages", matchQuery("comments.messages.message", "fox"), ScoreMode.Avg).innerHit(  
                    .field("type", "nested")
                        .startObject()  
                    .endObject()
    public InnerHitsIT(Settings staticSettings) {
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getOffset(), equalTo(0));
                        .field("title", "quick brown fox")
        assertThat(innerHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
                        .field("title", "quick brown fox")
        QueryBuilder query = nestedQuery("nested", matchQuery("nested.field", "value1"), ScoreMode.Avg).innerHit(
            .get();
        assertNoFailures(response);
                        .startObject()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                    .endObject()
                    .startObject("properties")
        );
        assertHitCount(response, 1);
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
                    ScoreMode.Avg  
            .setQuery(  
            .get();
                        .endObject()  
            .get();  
                        new InnerHitBuilder().setFrom(100).setSize(10).setName("_name")
                        .setSize(1)
                        .endObject()
                jsonBuilder().startObject().startArray("nested").startObject().field("field", "value1").endObject().endArray().endObject()  
 * specific language governing permissions and limitations
                        .endArray()  
 * ownership. Elasticsearch licenses this file to you under  
        assertAcked(prepareCreate("index1").setMapping("comments", "type=nested"));
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
                        .endObject()  
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
            client().prepareIndex("articles")
            response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getNestedIdentity().getField().string(),
                    )
                    jsonBuilder().startObject()
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");  
import org.opensearch.index.query.QueryBuilder;
                    jsonBuilder().startObject()
            return Collections.singletonMap("5", script -> "5");  
                    new InnerHitBuilder().setFetchSourceContext(  
            XContentBuilder source = jsonBuilder().startObject().field("foo", i).startArray("field1");  
import static org.hamcrest.Matchers.notNullValue;
                        .field("title", "quick brown fox")  
                    .endObject()  
        assertThat(innerHits.getHits().length, equalTo(1));
                        .endObject()
            .setQuery(boolQuery)  
        );  
 */
        assertNotNull(innerHits.getAt(0).getSourceAsMap());  
        );
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments");
            .should(termQuery("nested1.n_field2", "n_value2_2").queryName("test3"));
                jsonBuilder().startObject()  
        SearchHits innerHits = response.getHits().getAt(0).getInnerHits().get("comments");
        }
            numInnerObjects = field2InnerObjects[i] = scaledRandomIntBetween(1, numDocs);
            equalTo("fox ate rabbit x y z")
        assertThat(innerHits.getHits().length, equalTo(1));
                        .endObject()
        // Check that inner hits contain _source even when it's disabled on the parent request.  
                    .field("x", "y")
        assertHitCount(response, 1);  
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
import static org.hamcrest.Matchers.containsString;  
                        .field("message", "rabbit got away")
                client().prepareIndex("test")
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
        assertThat(messages.getAt(0).getNestedIdentity().getField().string(), equalTo("comments.messages"));
        assertThat(innerHits.getAt(1).getId(), equalTo("2"));
                        .field("title", "big gray elephant")
                    .field("type", "text")
            .get();  
    public void testNestedDefinedAsObject() throws Exception {
                nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.Avg).innerHit(new InnerHitBuilder("comment"))
                    .field("type", "text")
            "Cannot execute inner hits. One or more parent object fields of nested field [comments.messages] are "
        SearchHits messages = hit.getInnerHits().get("comments.messages");  
        );
    }
 * the Apache License, Version 2.0 (the "License"); you may
                assertThat(innerHit.getNestedIdentity().getOffset(), equalTo(j));
                        .field("message", "fox eat quick")  
        assertHitCount(response, 1);
            client().prepareIndex("articles")
            .setSize(numDocs)
            )  
        assertNoFailures(response);
    }
            SearchHits inner = searchHit.getInnerHits().get("a");
            )  
        assertHitCount(response, 1);
                .setId("1")  
                    .field("x", "y")
                        .field("message", "elephant captured")
            .setQuery(  
        assertHitCount(response, 1);  
                        .endObject()  
                )  
                nestedQuery("comments.remarks", matchQuery("comments.remarks.message", "bad"), ScoreMode.Avg).innerHit(  
                        .endObject()
                    nestedQuery("comments.remarks", matchQuery("comments.remarks.message", "bad"), ScoreMode.Avg).innerHit(
    public void testNestedSource() throws Exception {
                    .endObject()
 * license agreements. See the NOTICE file distributed with
        SearchResponse response = client().prepareSearch("articles")
        requests.add(
        assertThat(messages.getTotalHits().value(), equalTo(2L));
                        .addScriptField("script", new Script(ScriptType.INLINE, MockScriptEngine.NAME, "5", Collections.emptyMap()))  
        response = client().prepareSearch("articles")
        assertThat(innerHits.getTotalHits().value(), equalTo(1L));
            .prepareUpdateSettings("index2")
        indexRandom(true, requests);  
            assertThat(searchResponse.getHits().getAt(i).getInnerHits().get("nested1").getAt(0).getMatchedQueries()[0], equalTo("test3"));  
                    .endObject()  
            .field("type", "long")
        );
                    nestedQuery("nested_type", matchAllQuery(), ScoreMode.None).ignoreUnmapped(true)  
        assertThat(searchResponse.getHits().getAt(0).getInnerHits().get("nested1").getAt(1).getMatchedQueries()[0], equalTo("test3"));
            .setQuery(nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.None).innerHit(new InnerHitBuilder()))
        List<IndexRequestBuilder> requests = new ArrayList<>();
                // number_of_shards = 1, because then we catch the expected exception in the same way.  
            .get();  
                        .startArray("comments")
            equalTo("fox eat quick")
        return Arrays.asList(
            .setQuery(  
            .startObject("properties")
                    .startObject("message")  
        }
                        .startArray("comments")
                            .endArray()  
        assertThat(messages.getAt(1).getId(), equalTo("1"));  
                )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                assertThat(innerHit.getNestedIdentity().getOffset(), equalTo(j));
                nestedQuery("comments", matchQuery("comments.message", "away"), ScoreMode.None).innerHit(
                    .endObject()  
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getTotalHits().value(), equalTo(1L));
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
 * under the License.  
                    ScoreMode.Avg
    // Issue #9723
            )
            for (int j = 0; j < field2InnerObjects[i] && j < size; j++) {
import static org.opensearch.index.query.QueryBuilders.matchQuery;
            .get();
            response.getHits().getAt(0).getInnerHits().get("comments").getAt(1).getSourceAsMap().get("message"),  
            .endObject()  
        assertNoFailures(response);
                nestedQuery(
                    .endObject()
            .startObject("n_field1")
        // Directly refer to the second level:  
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getField().string(), equalTo("remarks"));  
    }
 *  
                    .field("message", "fox ate rabbit x y z")
                        .endArray()
 * Licensed to Elasticsearch under one or more contributor  
                    .field("message", "fox eat quick")
                        .startObject()
                        .field("n_field2", "n_value2_1")
        e = expectThrows(
                    ScoreMode.Avg
        SearchResponse response = client().prepareSearch("articles")
            .endObject()
                    "comments",  
            .setQuery(nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.Avg).innerHit(new InnerHitBuilder()))  
        );  
        assertThat(messages.getAt(0).getNestedIdentity().getChild(), nullValue());  
        // Check we can load the first doubly-nested document.
            )  
import org.opensearch.common.settings.Settings;  
            .setId("1")
                    .endObject()  
                    new InnerHitBuilder()
 * software distributed under the License is distributed on an
            .get();
                .setId("0")
                    jsonBuilder().startObject()  
        assertThat(
                        .startObject()  
 */  
        assertHitCount(response, 1);
        assertSearchHit(response, 1, hasId("1"));
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();  
                    .setId(String.valueOf(i))
                        .field("type", "object")
                        .endArray()
                        .startArray("remarks")
        // the field name (comments.message) used for source filtering should be the same as when using that field for
                    jsonBuilder().startObject()
                .setSource(  
                        .startObject()
            )
                )
        // return an empty _source:
            requestBuilders.add(client().prepareIndex("idx").setId(Integer.toString(i)).setSource(source));
                    ),
        assertThat(  
        assertThat(innerHits.getAt(0).getId(), equalTo("2"));  
                    .field("type", "nested")
                    .field("message", "rabbit got away")  
        SearchResponse response = client().prepareSearch("articles")
                        .endArray()
        );  
                .setSettings(Settings.builder().put("index.number_of_shards", 1))
        hit = response.getHits().getAt(0);
        SearchResponse response = client().prepareSearch("index2")
import java.util.List;
        client().prepareIndex("index2").setId("3").setSource("key", "value").get();
            () -> client().prepareSearch("index2")
                        .startObject()
        assertHitCount(response, 1);  
        assertThat(
    }
 * SPDX-License-Identifier: Apache-2.0
        assertNoFailures(response);  
                nestedQuery("nested", matchQuery("nested.field", "value1"), ScoreMode.Avg).innerHit(  
        ensureGreen();
        QueryBuilder query = boolQuery().should(termQuery("nested1.n_field1", "n_value1_1").queryName("test1"))  
                .setQuery(
            }  
                    .endArray()  
            client().prepareIndex("articles")
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments");  
            equalTo("<em>fox</em> eat quick")
            )  
                        .field("message", "bear eat quick")  
                            .startObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            new InnerHitBuilder().setSize(ArrayUtil.MAX_ARRAY_LENGTH - 1)  
            .setQuery(
                    .endObject()
                        .endObject()
            for (int j = 0; j < numInnerObjects; j++) {
                        .field("title", "big gray elephant")  
        );
                nestedQuery(  
        );  
                    .startObject("properties")
        int numDocs = scaledRandomIntBetween(25, 100);
                        .endArray()  
        );
                        .startObject()  
                        .endObject()  
        assertNoFailures(response);
 * KIND, either express or implied.  See the License for the
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(messages.getAt(0).getId(), equalTo("1"));
                        .endObject()
            client().prepareIndex("articles")  
                    ),  
                        .endObject()  
        assertThat(  
                        .endArray()  
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
            )  
                        .field("message", "hippo is hungry")
                        .field("field1", 1)
                        .endObject()
                    .startObject("message")  
import org.opensearch.script.MockScriptPlugin;
                )
        client().admin()
        indexRandom(true, requests);  
    }
            .setQuery(
        assertThat(innerHits.getAt(1).getNestedIdentity().getOffset(), equalTo(1));
                    new InnerHitBuilder().setFetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE)
            )
        response = client().prepareSearch("index2")  
            .prepareUpdateSettings("index2")
 * compatible open source license.
        );
                .setSource(  
        assertThat(messages.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
        assertThat(innerHits.getHits().length, equalTo(1));
        indexRandom(true, requests);  
                    .field("type", "text")
            )
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getNestedIdentity().getOffset(), equalTo(0));
                assertThat(innerHit.getNestedIdentity().getField().string(), equalTo("field2"));  
        assertThat(innerHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
import org.opensearch.core.xcontent.XContentBuilder;
                        .endObject()
                    new InnerHitBuilder().setFetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE)
                    "comments",
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");
            prepareCreate("articles").setMapping(  
        int[] field2InnerObjects = new int[numDocs];  
            .setFetchSource(false)
        List<IndexRequestBuilder> requests = new ArrayList<>();
        assertNoFailures(response);
                new InnerHitBuilder("b").addSort(new FieldSortBuilder("_doc").order(SortOrder.ASC)).setSize(size)
            .setQuery(
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            )  
        assertThat(innerHits.getHits().length, equalTo(1));
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
                        .field("message", "fox eat quick")
        indexRandomForConcurrentSearch("index2");
                    nestedQuery("comments.messages", matchQuery("comments.messages.message", "fox"), ScoreMode.Avg).innerHit(  
        assertThat(innerHits.getTotalHits().value(), equalTo(2L));
            response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().get("message"),
                        .field("message", "bad")  
import org.opensearch.action.search.SearchPhaseExecutionException;  
        assertEquals(
            requests.add(  
        response = client().prepareSearch("articles")  
        SearchResponse searchResponse = client().prepareSearch("idx")
                        .endArray()
import org.apache.lucene.search.join.ScoreMode;  
    public void testSimpleNested() throws Exception {
        assertThat(messages.getAt(0).getNestedIdentity().getField().string(), equalTo("comments.messages"));  
 * this file be licensed under the Apache-2.0 license or a
            .get();
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), ArrayUtil.MAX_ARRAY_LENGTH))  
                        .endObject()
                    )
            .get();  
            equalTo("fox ate rabbit x y z")
            nestedQuery("field2", matchAllQuery(), ScoreMode.Avg).innerHit(
        requests.add(
        assertHitCount(response, 1);
        assertThat(response.getHits().getAt(0).getShard(), notNullValue());  
        response = client().prepareSearch()
        assertHitCount(response, 1);
                .setSource(
 * You may obtain a copy of the License at  
            prepareCreate("articles")
 *
                        .startArray("remarks")  
        assertThat(innerHits.getAt(0).getNestedIdentity().getChild().getField().string(), equalTo("remarks"));  
            )  
import org.opensearch.plugins.Plugin;  
                        .field("title", "quick brown fox")
                        .endArray()  
/*  
                // (See expectThrows(...) below)
import org.opensearch.search.SearchHits;  
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().size(), equalTo(0));  
            nestedQuery("field1", matchAllQuery(), ScoreMode.Avg).innerHit(
        assertAcked(prepareCreate("index2").setMapping("nested", "type=nested"));
                    .field("type", "text")
                    .endObject()  
import org.opensearch.search.SearchHit;
                        .startObject()  
                        .endObject()  
                    )  
        assertThat(innerHits.getAt(2).getNestedIdentity().getField().string(), equalTo("comments"));  
                        .field("message", "elephant scared by mice x y")
        assertThat(innerHits.getHits().length, equalTo(2));
        assertThat(searchResponse.getHits().getAt(1).getInnerHits().get("nested1").getAt(0).getMatchedQueries().length, equalTo(1));
            .setQuery(
import org.opensearch.script.ScriptType;
import org.opensearch.script.MockScriptEngine;
                        .field("n_field2", "n_value2_1")
            () -> client().prepareSearch("articles")
            )
        SearchResponse searchResponse = client().prepareSearch("test")  
                nestedQuery(
            .indices()
 * this work for additional information regarding copyright
        assertAcked(
        assertHitCount(response, 1);  
                    jsonBuilder().startObject()  
        assertNoFailures(response);
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments");
        assertAllSuccessful(searchResponse);  
import org.opensearch.index.IndexSettings;
    public void testRandomNested() throws Exception {  
                        new InnerHitBuilder()
                    nestedQuery("comments.remarks", matchQuery("comments.remarks.message", "good"), ScoreMode.Avg).innerHit(  
        assertNoFailures(response);  
                jsonBuilder().startObject()
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;  
                .setId("1")
                )
                        .field("n_field1", "n_value1_2")
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getNestedIdentity().getChild(), nullValue());  
        assertThat(innerHits.getAt(1).getNestedIdentity().getField().string(), equalTo("comments"));  
        assertFalse(response.getHits().getAt(0).getInnerHits().get("comments").getAt(0).getSourceAsMap().isEmpty());
                        .startObject("comments")  
                    jsonBuilder().startObject()
                    .startObject("properties")
                        new InnerHitBuilder().setFetchSourceContext(FetchSourceContext.FETCH_SOURCE)
                        .field("n_field1", "n_value1_1")
                        .field("field1", 0)
                        .field("n_field2", "n_value2_5")  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    .startObject("comments")  
        assertNoFailures(response);
        assertThat(response.getHits().getAt(0).getInnerHits().get("comments").getTotalHits().value(), equalTo(1L));
        SearchResponse response = client().prepareSearch("index2").setQuery(query).get();
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
                    )
                nestedQuery(
        assertThat(messages.getTotalHits().value(), equalTo(1L));
        innerHits = innerHits.getAt(0).getInnerHits().get("remark");  
                    .startObject("properties")
    }
        indexRandom(true, requestBuilders);  
        List<IndexRequestBuilder> requestBuilders = new ArrayList<>();  
        query = nestedQuery("nested1", query, ScoreMode.Avg).innerHit(  
import org.opensearch.test.InternalSettingsPlugin;
                        .startObject()
            .get();
    public void testUseMaxDocInsteadOfSize() throws Exception {
            .get();  
        );  
    }
                    nestedQuery("comments.remarks", matchQuery("comments.remarks.message", "good"), ScoreMode.Avg).innerHit(  
            )  
            .get();  
    public void testTooHighResultWindow() throws Exception {
        requests.add(
        response = client().prepareSearch("index2")
            .setQuery(  
                    jsonBuilder().startObject()
        assertNoFailures(response);
                            .startObject()
                        .startArray("messages")
        assertAcked(prepareCreate("articles").setMapping("comments", "type=nested", "title", "type=text"));  
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), 110))
                        .endObject()
        assertThat(innerHits.getHits().length, equalTo(1));
            .addSort("foo", SortOrder.ASC)
            .get();  
            .setQuery(nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.None).innerHit(new InnerHitBuilder()))
        assertThat(searchResponse.getHits().getAt(0).getInnerHits().get("nested1").getAt(0).getMatchedQueries().length, equalTo(1));
                    .field("type", "nested")
                        .startObject("comments")
        }
                        .startObject()
        // Check we can load the second doubly-nested document.
                )
        assertThat(innerHits.getAt(0).getId(), equalTo("2"));  
            .setId("1")
                        .field("message", "mice squashed by elephant x")
        assertThat(innerHits.getAt(0).getFields().get("script").getValue().toString(), equalTo("5"));  
                    .endObject()
                    .endObject()
import static org.opensearch.index.query.QueryBuilders.termQuery;  
        assertThat(searchResponse.getHits().getAt(1).getInnerHits().get("nested1").getAt(0).getMatchedQueries()[0], equalTo("test2"));  
                        new InnerHitBuilder("remark")
        assertThat(innerHits.getAt(0).getId(), equalTo("1"));
                .setQuery(  
                nestedQuery("comments", matchQuery("comments.message", "fox"), ScoreMode.None).innerHit(
                    new InnerHitBuilder().setFetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE)
        createIndex("index2");  
        assertThat(messages.getAt(0).getNestedIdentity().getChild(), nullValue());
            .endObject()  
                        .startObject()
        innerHits = response.getHits().getAt(0).getInnerHits().get("comments");
        assertNoFailures(searchResponse);
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
            .endObject()
    @Override
                .setSource(
            .get();
            .setQuery(
        assertHitCount(response, 1);
            .get();
                        .startObject("messages")
                        .endObject()  
                        .startObject("messages")  
                )

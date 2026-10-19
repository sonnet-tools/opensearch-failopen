 */
        logger.info("Start Testing failed multi search with a wrong query");  
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDetails()[1].getValue(), equalTo(100L));
                assertThat(  
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[1].getDescription(), containsString("freq"));
        } catch (OpenSearchException e) {  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 * under the License.  
        assertThat(response.getSuccessfulShards(), equalTo(test.numPrimaries));
import static org.opensearch.index.query.QueryBuilders.termQuery;
import org.opensearch.search.builder.SearchSourceBuilder;
        SearchResponse searchResponse = client().search(searchRequest("test").source(sourceBuilder)).actionGet();
    }
            .setQuery(termQuery("multi", "test"))
            settingsBuilder.put(SETTING_NUMBER_OF_SHARDS, numShards);
            }
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;  
            .setSize(60)
            assertNoFailures(searchResponse);
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDetails()[0].getValue(), equalTo(100L));  
            assertThat(searchResponse.getTotalShards(), equalTo(test.numPrimaries));
import org.opensearch.core.xcontent.XContentBuilder;
            .setScroll(TimeValue.timeValueSeconds(30))
import org.opensearch.action.search.SearchPhaseExecutionException;  
import static org.hamcrest.Matchers.startsWith;  
public class TransportTwoNodesSearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                assertThat(hit.getExplanation().getDetails()[0].getDetails().length, equalTo(2));  
        searchResponse = client().search(searchRequest("test").source(source.from(60).size(60)).searchType(QUERY_THEN_FETCH)).actionGet();
        assertThat(response.getResponses()[2].getFailureMessage(), nullValue());  
    }
            .get();  
        // it should be if dfs is working correctly)  
        ensureGreen();  
                    hit.getId(),
        NumShards test = getNumShards("test");
        assertThat(response.getFailedShards(), equalTo(0));  
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueSeconds(30)).get();
                assertThat(hit.getExplanation(), notNullValue());
        assertThat(response.getTotalShards(), equalTo(test.numPrimaries));
        assertThat(searchResponse.getHits().getHits().length, equalTo(40));
            .setSearchType(DFS_QUERY_THEN_FETCH)  
        assertThat(response.getResponses()[1].getFailureMessage(), nullValue());  
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDescription(), startsWith("idf"));
        assertNoFailures(response);  
                break; // finished
                assertThat(hit.getExplanation().getDetails().length, equalTo(1));
        prepareData();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
            assertNoFailures(searchResponse);
        SearchSourceBuilder source = searchSource().query(matchAllQuery()).explain(true);
        assertThat(test1.getDocCount(), equalTo(1L));  
                break; // finished  
            total += hits.length;  
/*  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        }  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
            // Add custom score query with bogus script  
        }
 * this work for additional information regarding copyright
        logger.info("Done Testing failed search");
        assertNoFailures(searchResponse);  
            .add(client().prepareSearch("test").setQuery(QueryBuilders.termQuery("nid", 2)))
            .create(createIndexRequest("test").settings(settingsBuilder).simpleMapping("foo", "type=geo_point"))  
        for (int i = 0; i < 100; i++) {
        // to produce the same 8-bit norm for all docs here, so that
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDetails()[1].getValue(), equalTo(100L));
    @Override
import org.opensearch.action.search.SearchResponse;
            for (int i = 0; i < hits.length; ++i) {
            .actionGet();  
        prepareData();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
        assertThat(response.getResponses()[0].getFailureMessage(), notNullValue());
package org.opensearch.search.basic;
            .setScroll(TimeValue.timeValueSeconds(30))
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDetails().length, equalTo(2));
        }
            total += hits.length;
 * <p>{@code @SuppressCodecs("*")} is needed because we cache StoredFieldsReader instances  
        response = client().search(searchRequest("test").searchType(DFS_QUERY_THEN_FETCH).source(source)).actionGet();
                            new ScriptScoreFunctionBuilder(new Script(ScriptType.INLINE, "bar", "foo", Collections.emptyMap()))  
        prepareData();
import static org.opensearch.transport.client.Requests.searchRequest;  
        clearScroll(searchResponse.getScrollId());  
            index(Integer.toString(i), "test", i);
                    equalTo(Integer.toString(100 - total - i - 1))  
        Set<String> fullExpectedIds = prepareData();
                SearchHit hit = hits[i];
        assertThat(response.getResponses()[2].getFailureMessage(), nullValue());
import static org.hamcrest.Matchers.nullValue;
            }
/*  
            total += hits.length;  
                assertThat(hit.getExplanation().getDetails().length, equalTo(1));
    }
        }
            .get();
        for (int i = 1048; i < 1148; i++) {  
        prepareData();
@LuceneTestCase.SuppressCodecs("*")
import org.opensearch.search.aggregations.AggregationBuilders;
        prepareData();  
            .setScroll(TimeValue.timeValueSeconds(30))
            assertNoFailures(searchResponse);
import org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder;
        Settings.Builder settingsBuilder = Settings.builder().put(indexSettings());
            }
        SearchResponse searchResponse = client().prepareSearch("test")
 * not use this file except in compliance with the License.
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueSeconds(30)).get();
                break; // finished
            assertThat(e.unwrapCause(), instanceOf(SearchPhaseExecutionException.class));
        // we need to have age (ie number of repeats of "test" term) high enough  
        logger.info("Done Testing failed search");  
        super(staticSettings);
            index(Integer.toString(i - 1048), "test", i);
            collectedIds.add(hit.getId());  
import org.opensearch.search.sort.SortOrder;  
                        )
import org.opensearch.common.settings.Settings;
            .add(client().prepareSearch("test").setQuery(new MatchQueryBuilder("foo", "biz")))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @see org.opensearch.search.internal.ScrollContext#getCachedSequentialReader(Object)
 *
        return Arrays.asList(
    }
        assertThat(all.getDocCount(), equalTo(100L));
        Filter all = global.getAggregations().get("all");
            .setQuery(termQuery("multi", "test"))
        clearScroll(searchResponse.getScrollId());
        SearchResponse searchResponse = client().prepareSearch("test")
 * The OpenSearch Contributors require contributions made to  
        logger.info("Done Testing failed search");
        indexRandomForConcurrentSearch("test");  
                assertThat(hit.getExplanation(), notNullValue());  
        prepareData();
            SearchHit[] hits = searchResponse.getHits().getHits();
            .aggregation(AggregationBuilders.filter("test1", termQuery("name", "test1")));  
                    .setQuery(  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        Set<String> collectedIds = new TreeSet<>();  
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));  
                    "id[" + hit.getId() + "] -> " + hit.getExplanation().toString(),
import org.opensearch.OpenSearchException;
        assertThat(response.getResponses()[2].getResponse().getHits().getHits().length, equalTo(10));
    protected int numberOfReplicas() {
    }  
            .setSearchType(DFS_QUERY_THEN_FETCH)
 * GitHub history for details.
    }
 * KIND, either express or implied.  See the License for the
            .setQuery(termQuery("multi", "test"))  
 * ownership. Elasticsearch licenses this file to you under  
            fail("search should fail");
                break; // finished  
    }
            }
    private Set<String> prepareData() throws Exception {  
            SearchHit[] hits = searchResponse.getHits().getHits();  
        if (numShards > 0) {  
            assertThat(searchResponse.getFailedShards(), equalTo(test.numPrimaries));
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
        assertNoFailures(response);
                    )
        while (true) {
import org.opensearch.search.aggregations.bucket.filter.Filter;  
import static org.opensearch.action.search.SearchType.DFS_QUERY_THEN_FETCH;
            .setExplain(true)
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));  
    public void testFailedMultiSearchWithWrongQuery() throws Exception {
import org.opensearch.script.ScriptType;  
}  
        int total = 0;  
    public TransportTwoNodesSearchIT(Settings staticSettings) {
import org.opensearch.action.search.MultiSearchResponse;
                );
 * the Apache License, Version 2.0 (the "License"); you may
            .setSearchType(QUERY_THEN_FETCH)
            .setSize(60)  
            fullExpectedIds.add(Integer.toString(i));  
            .add(client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()))
 * license agreements. See the NOTICE file distributed with
        logger.info("Start Testing failed multi search with a wrong query");
    public void testFailedSearchWithWrongFrom() throws Exception {
            .get();
                searchRequest("test").source(new SearchSourceBuilder().query(new MatchQueryBuilder("foo", "biz")))  
 * You may obtain a copy of the License at  
    @ParametersFactory
 * software distributed under the License is distributed on an
        while (true) {  
        assertEquals(100, total);
import org.apache.lucene.tests.util.LuceneTestCase;  
            .setSize(60)
        clearScroll(searchResponse.getScrollId());  
            for (int i = 0; i < hits.length; ++i) {
import org.opensearch.common.unit.TimeValue;  
            .setQuery(termQuery("multi", "test"))  
import static org.hamcrest.Matchers.instanceOf;  
            SearchHit hit = searchResponse.getHits().getHits()[i];
            .endObject();
        SearchResponse searchResponse = client().prepareSearch("test")
            if (hits.length == 0) {
        assertThat(response.getHits().getHits().length, equalTo(0));  
        // are encoded into the same byte
        }
            )  
import java.io.IOException;
        clearScroll(searchResponse.getScrollId());  
        assertThat(collectedIds, equalTo(fullExpectedIds));
        assertThat(response.getHits().getHits().length, equalTo(0));
        client().admin()
        for (int i = 0; i < 40; i++) {  
import static org.hamcrest.Matchers.containsString;
        logger.info("Start Testing failed search with wrong from");  
 */  
        assertEquals(100, total);
            .add(
 */  
        return fullExpectedIds;
    }
        assertThat(searchResponse.getHits().getHits().length, equalTo(60));  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        Global global = searchResponse.getAggregations().get("global");  
/**
    }
                            QueryBuilders.termQuery("nid", 1),
import org.opensearch.script.Script;
            .get();  
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDescription(), startsWith("idf"));
            .add(client().prepareSearch("test").setQuery(QueryBuilders.termQuery("nid", 2)))  
        }
    }
        return prepareData(-1);
    private Set<String> prepareData(int numShards) throws Exception {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        Set<String> fullExpectedIds = new TreeSet<>();
        }
            .add(client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()))
        // With the current way of encoding norms, every length between 1048 and 1176
                        QueryBuilders.functionScoreQuery(
import java.util.Collections;
            .addSort("age", SortOrder.ASC)  
            .field("id", id)
    public void testSimpleFacets() throws Exception {
            .field("name", nameValue + id)
            SearchHit hit = searchResponse.getHits().getHits()[i];
                SearchHit hit = hits[i];
        assertEquals(100, total);
    }  
import java.util.Collection;  
            if (hits.length == 0) {
        prepareData();
        response = client().search(searchRequest("test").searchType(DFS_QUERY_THEN_FETCH).source(source)).actionGet();  
        logger.info("Start Testing failed search with wrong query");  
            .from(0)
        for (int i = 0; i < 60; i++) {
    }
        try {
import static org.opensearch.transport.client.Requests.createIndexRequest;
    public void testQueryThenFetchWithFrom() throws Exception {
            if (hits.length == 0) {
        assertThat(response.getResponses().length, equalTo(3));
        for (int i = 0; i < age; i++) {
            .indices()
    }
            }  
    public void testQueryThenFetch() throws Exception {  
        SearchResponse searchResponse = client().search(searchRequest("test").source(source.from(0).size(60)).searchType(QUERY_THEN_FETCH))
            .get();
        NumShards test = getNumShards("test");
    public void testFailedMultiSearchWithWrongQueryWithFunctionScore() throws Exception {  
    }
 * SPDX-License-Identifier: Apache-2.0
            total += hits.length;  
            .size(20)  
        SearchResponse searchResponse = client().prepareSearch("test")  
            .setExplain(true)
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDetails().length, equalTo(2));
            for (int i = 0; i < hits.length; ++i) {
 * Unless required by applicable law or agreed to in writing,
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
        SearchSourceBuilder sourceBuilder = searchSource().query(termQuery("multi", "test"))
                assertThat(hit.getExplanation(), notNullValue());
            // all is well
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[1].getDescription(), containsString("freq"));
    }  
        assertThat(response.getResponses()[0].getFailureMessage(), notNullValue());
    public void testDfsQueryThenFetch() throws Exception {
        return jsonBuilder().startObject()
            .setSize(60)
 * that rejects this valid sequential cross-thread usage.  
        return 0;  
        while (true) {  
            .get();  
        Settings.Builder settingsBuilder = Settings.builder().put(indexSettings());
            .addSort("age", SortOrder.ASC)
        logger.info("Done Testing failed search");
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueSeconds(30)).get();
import org.opensearch.transport.client.Requests;
 * across scroll batches for sequential access. Different batches may run on different threads
 * Modifications Copyright OpenSearch Contributors. See
    public static Collection<Object[]> parameters() {  
        MultiSearchResponse response = client().prepareMultiSearch()
            collectedIds.add(hit.getId());
        assertThat(response.getResponses()[1].getResponse().getHits().getHits().length, equalTo(1));
            }
        assertEquals(100, total);  
        assertNoFailures(searchResponse);  
        Filter test1 = searchResponse.getAggregations().get("test1");
            assertThat(searchResponse.getSuccessfulShards(), equalTo(0));  
            .addSort("nid", SortOrder.DESC)  
    }
    public void testDfsQueryThenFetchWithSort() throws Exception {
        int total = 0;
            .field("multi", multi.toString())  
                assertThat("id[" + hit.getId() + "]", hit.getId(), equalTo(Integer.toString(total + i)));  
        assertThat(response.getResponses()[2].getResponse().getHits().getHits().length, equalTo(10));
import java.util.Arrays;
            .field("age", age)
        }  
        }
 */  
    public void testQueryThenFetchWithSort() throws Exception {
    private XContentBuilder source(String id, String nameValue, int age) throws IOException {
        refresh();  
import org.opensearch.index.query.MatchQueryBuilder;
            .field("nid", Integer.parseInt(id))  
 * compatible open source license.
            assertNoFailures(searchResponse);
        MultiSearchResponse response = client().prepareMultiSearch()
                client().prepareSearch("test")
import org.opensearch.search.aggregations.bucket.global.Global;
    }
                assertThat(hit.getExplanation().getDetails()[0].getDetails().length, equalTo(2));  
import static org.hamcrest.Matchers.notNullValue;
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDetails()[0].getValue(), equalTo(100L));  
        while (true) {
import org.opensearch.search.SearchHit;
import static org.opensearch.action.search.SearchType.QUERY_THEN_FETCH;  
 *
    private void index(String id, String nameValue, int age) throws IOException {
        }
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueSeconds(30)).get();  
 * specific language governing permissions and limitations
        client().admin().indices().create(createIndexRequest("test").settings(settingsBuilder)).actionGet();  
import java.util.Set;
                SearchHit hit = hits[i];  
            .setExplain(true)  
        }  
            .setExplain(true)
import org.opensearch.index.query.QueryBuilders;  
        assertThat(response.getResponses()[1].getResponse().getHits().getHits().length, equalTo(1));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
        assertThat(response.getHits().getHits().length, equalTo(0));
 * (but never concurrently). Lucene's AssertingStoredFieldsFormat enforces thread affinity
        SearchResponse response = client().search(searchRequest("test").searchType(DFS_QUERY_THEN_FETCH).source(source)).actionGet();
        client().index(Requests.indexRequest("test").id(id).source(source(id, nameValue, age))).actionGet();
            SearchResponse searchResponse = client().search(
                SearchHit hit = hits[i];  
        response = client().search(searchRequest("test").searchType(QUERY_THEN_FETCH).source(source)).actionGet();
/*
            .setScroll(TimeValue.timeValueSeconds(30))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
            multi.append(" ").append(nameValue);
                assertThat("id[" + hit.getId() + "]", hit.getId(), equalTo(Integer.toString(100 - total - i - 1)));
    public void testFailedSearchWithWrongQuery() throws Exception {
        );
        assertThat(response.getResponses().length, equalTo(3));  
        ensureGreen();
            ).actionGet();
 *  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        refresh();
        assertNoFailures(response);
        StringBuilder multi = new StringBuilder().append(nameValue);  
        // the tf is basically the entire score (assuming idf is fixed, which
        SearchSourceBuilder source = searchSource().query(termQuery("multi", "test")).from(1000).size(20).explain(true);
        int total = 0;
            SearchHit[] hits = searchResponse.getHits().getHits();  
            for (int i = 0; i < hits.length; ++i) {
import java.util.TreeSet;  
            .actionGet();
                assertThat(hit.getExplanation(), notNullValue());  
            .aggregation(AggregationBuilders.global("global").subAggregation(AggregationBuilders.filter("all", termQuery("multi", "test"))))
            .explain(true)
        assertNoFailures(searchResponse);
            if (hits.length == 0) {
            }  
        prepareData();
                assertThat("id[" + hit.getId() + "]", hit.getId(), equalTo(Integer.toString(total + i)));
        int total = 0;
        assertThat(response.getResponses()[1].getFailureMessage(), nullValue());
        assertThat(response.getHits().getHits().length, equalTo(0));  
            SearchHit[] hits = searchResponse.getHits().getHits();

        assertThat(searchResponse.getHits().getHits().length, equalTo(40));
import org.opensearch.action.search.SearchPhaseExecutionException;
        }
 * KIND, either express or implied.  See the License for the
        ensureGreen();
        searchResponse = client().search(searchRequest("test").source(source.from(60).size(60)).searchType(QUERY_THEN_FETCH)).actionGet();
        assertThat(response.getResponses()[1].getFailureMessage(), nullValue());
        assertThat(collectedIds, equalTo(fullExpectedIds));
            .setSearchType(DFS_QUERY_THEN_FETCH)
        Set<String> collectedIds = new TreeSet<>();
        while (true) {
        while (true) {
        // it should be if dfs is working correctly)
            .get();
            }
        ensureGreen();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
import java.util.Arrays;
                    equalTo(Integer.toString(100 - total - i - 1))
        }
        int total = 0;
/*
        while (true) {
/*
            .field("name", nameValue + id)
        clearScroll(searchResponse.getScrollId());
        assertThat(all.getDocCount(), equalTo(100L));
            )
        // to produce the same 8-bit norm for all docs here, so that
        assertThat(response.getResponses()[2].getResponse().getHits().getHits().length, equalTo(10));
            }
        client().index(Requests.indexRequest("test").id(id).source(source(id, nameValue, age))).actionGet();
 * this file be licensed under the Apache-2.0 license or a
    }
        assertThat(response.getResponses().length, equalTo(3));
            SearchHit[] hits = searchResponse.getHits().getHits();
        assertThat(response.getHits().getHits().length, equalTo(0));
            if (hits.length == 0) {
        assertEquals(100, total);
        clearScroll(searchResponse.getScrollId());
        assertThat(response.getResponses()[1].getFailureMessage(), nullValue());
            collectedIds.add(hit.getId());
            for (int i = 0; i < hits.length; ++i) {
            settingsBuilder.put(SETTING_NUMBER_OF_SHARDS, numShards);
                client().prepareSearch("test")
        refresh();
        int total = 0;
        for (int i = 0; i < 60; i++) {
 * Unless required by applicable law or agreed to in writing,
            .field("age", age)
        logger.info("Start Testing failed multi search with a wrong query");
                assertThat("id[" + hit.getId() + "]", hit.getId(), equalTo(Integer.toString(100 - total - i - 1)));
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDetails().length, equalTo(2));
                    )
        // we need to have age (ie number of repeats of "test" term) high enough
            ).actionGet();
import static org.hamcrest.Matchers.containsString;
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDetails()[1].getValue(), equalTo(100L));
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[1].getDescription(), containsString("freq"));
    }
    public void testSimpleFacets() throws Exception {
import java.io.IOException;
            for (int i = 0; i < hits.length; ++i) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        Set<String> fullExpectedIds = prepareData();
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
            .setSearchType(QUERY_THEN_FETCH)
        Filter test1 = searchResponse.getAggregations().get("test1");
import static org.hamcrest.Matchers.equalTo;
 * SPDX-License-Identifier: Apache-2.0
        response = client().search(searchRequest("test").searchType(QUERY_THEN_FETCH).source(source)).actionGet();
            .setQuery(termQuery("multi", "test"))
            .add(client().prepareSearch("test").setQuery(QueryBuilders.termQuery("nid", 2)))
                    "id[" + hit.getId() + "] -> " + hit.getExplanation().toString(),
            .from(0)
        assertThat(response.getResponses()[1].getResponse().getHits().getHits().length, equalTo(1));
            .actionGet();
        prepareData();
 */
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDescription(), startsWith("idf"));
        client().admin()
 * specific language governing permissions and limitations
            .get();
            .create(createIndexRequest("test").settings(settingsBuilder).simpleMapping("foo", "type=geo_point"))
            .field("multi", multi.toString())
    }
            .setExplain(true)
import java.util.TreeSet;
import static org.opensearch.transport.client.Requests.createIndexRequest;
            }
    }
        }
import org.apache.lucene.tests.util.LuceneTestCase;
        }
    }
                break; // finished
        clearScroll(searchResponse.getScrollId());
            .field("id", id)
            assertThat(e.unwrapCause(), instanceOf(SearchPhaseExecutionException.class));
            .setScroll(TimeValue.timeValueSeconds(30))
            assertThat(searchResponse.getFailedShards(), equalTo(test.numPrimaries));
        Settings.Builder settingsBuilder = Settings.builder().put(indexSettings());
        return 0;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
            }
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueSeconds(30)).get();
        prepareData();
    public void testFailedMultiSearchWithWrongQuery() throws Exception {
    }
import static org.hamcrest.Matchers.startsWith;
        SearchResponse response = client().search(searchRequest("test").searchType(DFS_QUERY_THEN_FETCH).source(source)).actionGet();
                assertThat(hit.getExplanation(), notNullValue());
    }
                assertThat("id[" + hit.getId() + "]", hit.getId(), equalTo(Integer.toString(total + i)));
            .endObject();
        logger.info("Start Testing failed multi search with a wrong query");
                    hit.getId(),
                SearchHit hit = hits[i];
            total += hits.length;
            for (int i = 0; i < hits.length; ++i) {
            .add(client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()))
            }
        }
            assertThat(searchResponse.getSuccessfulShards(), equalTo(0));
 * across scroll batches for sequential access. Different batches may run on different threads
import org.opensearch.OpenSearchException;
import org.opensearch.common.unit.TimeValue;
import java.util.Collections;
        int total = 0;
        clearScroll(searchResponse.getScrollId());
    }
            .setScroll(TimeValue.timeValueSeconds(30))
import org.opensearch.search.sort.SortOrder;
    public void testQueryThenFetchWithSort() throws Exception {
        assertNoFailures(response);
            .setExplain(true)
public class TransportTwoNodesSearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    public void testFailedSearchWithWrongQuery() throws Exception {
    }
 * Licensed to Elasticsearch under one or more contributor
/**
        assertEquals(100, total);
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDescription(), startsWith("idf"));
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDetails().length, equalTo(2));
        response = client().search(searchRequest("test").searchType(DFS_QUERY_THEN_FETCH).source(source)).actionGet();
package org.opensearch.search.basic;
    public void testDfsQueryThenFetch() throws Exception {
import org.opensearch.search.builder.SearchSourceBuilder;
                    .setQuery(
        MultiSearchResponse response = client().prepareMultiSearch()
            .get();
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDetails()[0].getValue(), equalTo(100L));
        // are encoded into the same byte
                searchRequest("test").source(new SearchSourceBuilder().query(new MatchQueryBuilder("foo", "biz")))
            .setScroll(TimeValue.timeValueSeconds(30))
        for (int i = 0; i < 40; i++) {
        NumShards test = getNumShards("test");
/*
        SearchResponse searchResponse = client().prepareSearch("test")
        assertThat(response.getHits().getHits().length, equalTo(0));
 */
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(response.getResponses()[1].getResponse().getHits().getHits().length, equalTo(1));
        logger.info("Start Testing failed search with wrong query");
        for (int i = 1048; i < 1148; i++) {
        SearchResponse searchResponse = client().prepareSearch("test")
                assertThat(hit.getExplanation().getDetails().length, equalTo(1));
                SearchHit hit = hits[i];
        assertNoFailures(searchResponse);
        return prepareData(-1);
        }
import static org.opensearch.action.search.SearchType.QUERY_THEN_FETCH;
            .field("nid", Integer.parseInt(id))
        assertThat(response.getHits().getHits().length, equalTo(0));
        assertEquals(100, total);
            // all is well
                assertThat(hit.getExplanation(), notNullValue());
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertEquals(100, total);
            total += hits.length;
 * this work for additional information regarding copyright
import org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder;
        prepareData();
        assertThat(response.getResponses()[0].getFailureMessage(), notNullValue());
        assertThat(searchResponse.getHits().getHits().length, equalTo(60));
        return Arrays.asList(
 *
            .setSize(60)
            .addSort("age", SortOrder.ASC)
 */
        int total = 0;
            assertNoFailures(searchResponse);
    }
        return fullExpectedIds;
        }
 * The OpenSearch Contributors require contributions made to
 * software distributed under the License is distributed on an
        logger.info("Done Testing failed search");
            assertNoFailures(searchResponse);
import org.opensearch.index.query.MatchQueryBuilder;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        while (true) {
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[1].getDescription(), containsString("freq"));
    public void testFailedMultiSearchWithWrongQueryWithFunctionScore() throws Exception {
 * <p>{@code @SuppressCodecs("*")} is needed because we cache StoredFieldsReader instances
 * compatible open source license.
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
            if (hits.length == 0) {
            .get();
        }
            .setScroll(TimeValue.timeValueSeconds(30))
        }
        assertNoFailures(response);
            collectedIds.add(hit.getId());
        refresh();
import static org.hamcrest.Matchers.instanceOf;
            .add(
            assertNoFailures(searchResponse);
import org.opensearch.search.aggregations.bucket.filter.Filter;
 */
            .get();
                assertThat(hit.getExplanation().getDetails()[0].getDetails().length, equalTo(2));
        Filter all = global.getAggregations().get("all");
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueSeconds(30)).get();
 *
        SearchSourceBuilder source = searchSource().query(termQuery("multi", "test")).from(1000).size(20).explain(true);
import org.opensearch.search.SearchHit;
            total += hits.length;
    public static Collection<Object[]> parameters() {
            .setSize(60)
            .add(client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()))
        logger.info("Start Testing failed search with wrong from");
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueSeconds(30)).get();
            }
            .setExplain(true)
            SearchHit hit = searchResponse.getHits().getHits()[i];
        try {
            .setExplain(true)
        assertThat(response.getResponses()[2].getFailureMessage(), nullValue());
                        )
    @Override
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            for (int i = 0; i < hits.length; ++i) {
            .setSize(60)
            }
        assertThat(response.getResponses().length, equalTo(3));
        StringBuilder multi = new StringBuilder().append(nameValue);
            if (hits.length == 0) {
            .setQuery(termQuery("multi", "test"))
        // With the current way of encoding norms, every length between 1048 and 1176
        for (int i = 0; i < age; i++) {
import org.opensearch.script.ScriptType;
import static org.opensearch.transport.client.Requests.searchRequest;
        prepareData();
        client().admin().indices().create(createIndexRequest("test").settings(settingsBuilder)).actionGet();
            assertNoFailures(searchResponse);
import org.opensearch.search.aggregations.AggregationBuilders;
 * under the License.
            fail("search should fail");
            if (hits.length == 0) {
        assertNoFailures(response);
    @ParametersFactory
        Set<String> fullExpectedIds = new TreeSet<>();
        logger.info("Done Testing failed search");
    public TransportTwoNodesSearchIT(Settings staticSettings) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            .get();
import org.opensearch.action.search.SearchResponse;
        indexRandomForConcurrentSearch("test");
            .setQuery(termQuery("multi", "test"))
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
            .actionGet();
            .aggregation(AggregationBuilders.filter("test1", termQuery("name", "test1")));
 * not use this file except in compliance with the License.
        SearchResponse searchResponse = client().search(searchRequest("test").source(sourceBuilder)).actionGet();
                assertThat(
                break; // finished
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;
 *
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueSeconds(30)).get();
            assertThat(searchResponse.getTotalShards(), equalTo(test.numPrimaries));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        );
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
                break; // finished
                assertThat(hit.getExplanation(), notNullValue());
 * ownership. Elasticsearch licenses this file to you under
                            new ScriptScoreFunctionBuilder(new Script(ScriptType.INLINE, "bar", "foo", Collections.emptyMap()))
        assertNoFailures(searchResponse);
            SearchResponse searchResponse = client().search(
        return jsonBuilder().startObject()
            .explain(true)
 *
            total += hits.length;
        prepareData();
        response = client().search(searchRequest("test").searchType(DFS_QUERY_THEN_FETCH).source(source)).actionGet();
import org.opensearch.core.xcontent.XContentBuilder;
        assertThat(response.getResponses()[2].getResponse().getHits().getHits().length, equalTo(10));
        for (int i = 0; i < 100; i++) {
            SearchHit hit = searchResponse.getHits().getHits()[i];
            index(Integer.toString(i - 1048), "test", i);
        Global global = searchResponse.getAggregations().get("global");
        assertThat(response.getTotalShards(), equalTo(test.numPrimaries));
        SearchSourceBuilder source = searchSource().query(matchAllQuery()).explain(true);
import java.util.Set;
            .size(20)
import org.opensearch.index.query.QueryBuilders;
            .setQuery(termQuery("multi", "test"))
        }
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDetails()[0].getValue(), equalTo(100L));
                            QueryBuilders.termQuery("nid", 1),
        assertThat(test1.getDocCount(), equalTo(1L));
            .addSort("nid", SortOrder.DESC)
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at
import org.opensearch.action.search.MultiSearchResponse;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        NumShards test = getNumShards("test");
    }
        Settings.Builder settingsBuilder = Settings.builder().put(indexSettings());
 * Modifications Copyright OpenSearch Contributors. See
        prepareData();
                assertThat(hit.getExplanation().getDetails()[0].getDetails().length, equalTo(2));
        if (numShards > 0) {
            }
import java.util.Collection;
import static org.opensearch.action.search.SearchType.DFS_QUERY_THEN_FETCH;
    }
    private Set<String> prepareData(int numShards) throws Exception {
        assertNoFailures(searchResponse);
        } catch (OpenSearchException e) {
    protected int numberOfReplicas() {
    private XContentBuilder source(String id, String nameValue, int age) throws IOException {
import org.opensearch.common.settings.Settings;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat(response.getSuccessfulShards(), equalTo(test.numPrimaries));
    public void testFailedSearchWithWrongFrom() throws Exception {
    }
            .setSize(60)
import org.opensearch.search.aggregations.bucket.global.Global;
            .addSort("age", SortOrder.ASC)
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.transport.client.Requests;
}
 * that rejects this valid sequential cross-thread usage.
            index(Integer.toString(i), "test", i);
                        QueryBuilders.functionScoreQuery(
 * (but never concurrently). Lucene's AssertingStoredFieldsFormat enforces thread affinity
        SearchResponse searchResponse = client().search(searchRequest("test").source(source.from(0).size(60)).searchType(QUERY_THEN_FETCH))
            .indices()
            .add(client().prepareSearch("test").setQuery(new MatchQueryBuilder("foo", "biz")))
        MultiSearchResponse response = client().prepareMultiSearch()
    public void testQueryThenFetchWithFrom() throws Exception {
            SearchHit[] hits = searchResponse.getHits().getHits();
                assertThat(hit.getExplanation(), notNullValue());
            .add(client().prepareSearch("test").setQuery(QueryBuilders.termQuery("nid", 2)))
 * license agreements. See the NOTICE file distributed with
            // Add custom score query with bogus script
    public void testDfsQueryThenFetchWithSort() throws Exception {
import org.opensearch.script.Script;
                break; // finished
    }
@LuceneTestCase.SuppressCodecs("*")
            .aggregation(AggregationBuilders.global("global").subAggregation(AggregationBuilders.filter("all", termQuery("multi", "test"))))
        assertThat(response.getResponses()[0].getFailureMessage(), notNullValue());
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        SearchResponse searchResponse = client().prepareSearch("test")
    private void index(String id, String nameValue, int age) throws IOException {
        super(staticSettings);
            fullExpectedIds.add(Integer.toString(i));
    public void testQueryThenFetch() throws Exception {
        logger.info("Done Testing failed search");
    }
                SearchHit hit = hits[i];
        prepareData();
    private Set<String> prepareData() throws Exception {
import static org.hamcrest.Matchers.nullValue;
    }
        }
            .setSearchType(DFS_QUERY_THEN_FETCH)
        SearchSourceBuilder sourceBuilder = searchSource().query(termQuery("multi", "test"))
        assertThat(response.getFailedShards(), equalTo(0));
        assertThat(response.getResponses()[2].getFailureMessage(), nullValue());
                );
        assertThat(response.getHits().getHits().length, equalTo(0));
 * @see org.opensearch.search.internal.ScrollContext#getCachedSequentialReader(Object)
        prepareData();
    }
            multi.append(" ").append(nameValue);
                SearchHit hit = hits[i];
                assertThat("id[" + hit.getId() + "]", hit.getId(), equalTo(Integer.toString(total + i)));
        // the tf is basically the entire score (assuming idf is fixed, which
            SearchHit[] hits = searchResponse.getHits().getHits();
        logger.info("Done Testing failed search");
        SearchResponse searchResponse = client().prepareSearch("test")
                assertThat(hit.getExplanation().getDetails().length, equalTo(1));
            SearchHit[] hits = searchResponse.getHits().getHits();
                assertThat(hit.getExplanation().getDetails()[0].getDetails()[0].getDetails()[1].getValue(), equalTo(100L));

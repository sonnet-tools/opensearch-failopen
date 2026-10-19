                )
        assertNoFailures(searchResponse);
        assertHitCount(searchResponse, 1L);
        SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery("text").field("f*_alias")).get();
        SearchResponse resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo bar")).get();
        // test case from #13884
        // suggest doesn't match
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("\"2015/09/02\"")).get();
                    .prepareUpdateSettings()
        );
import static java.util.Collections.singletonList;
import static org.opensearch.search.SearchService.SEARCH_MAX_QUERY_STRING_LENGTH;
import static org.opensearch.search.SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING;
                if (input.incrementToken()) {
        Exception e = expectThrows(Exception.class, () -> {
        searchResponse = client().prepareSearch()
        searchResponse = client().prepareSearch()
        settings.put("index.analysis.analyzer.mock_snowball.tokenizer", "standard");
    public void testFieldAliasOnDisallowedFieldType() throws Exception {
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
 */
        // nested doesn't match because it's hidden
import static org.opensearch.index.query.QueryBuilders.termQuery;
import java.util.Set;
                .setTransientSettings(Settings.builder().put(INDICES_MAX_CLAUSE_COUNT_SETTING.getKey(), CLUSTER_MAX_CLAUSE_COUNT + 2))
    }
            .toString();
            assertAcked(
            client().prepareSearch("testdynamic").setQuery(qb).get();
        logger.info("--> query 2");
        indexRandom(
        indexRandomForConcurrentSearch("test");
        assertHitCount(searchResponse, 1L);
            client().prepareIndex("test").setId("2").setSource("f1", "bar", "f_date", "2015/09/01", "f_float", "1.8", "f_ip", "127.0.0.2")
        assertHitCount(resp, 1L);
        SearchResponse resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo")).get();
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("bar")).get();
        ensureGreen("test");
    public static void createRandomClusterSetting() {
            .setQuery(simpleQueryStringQuery("foo").field("field"))
        indexRandomForConcurrentSearch("test2");
        assertHits(resp.getHits(), "1");
import java.util.HashSet;
        indexRandomForConcurrentSearch("test");
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));
                    .cluster()
 * specific language governing permissions and limitations
        indexRandomForConcurrentSearch("test");
        );
    private void doAssertLimitExceededException(String field, int exceedingFieldCount) {
        indexRandomForConcurrentSearch("test1");
        assertSearchHits(searchResponse, "1");
        assertHitCount(searchResponse, 2L);
        assertHitCount(resp, 1L);
        indexRandom(true, false, reqs);
        assertHitCount(searchResponse, 3L);
            client().prepareIndex("test").setId("3").setSource("body", "foo bar"),
            String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
        assertFirstHit(searchResponse, hasId("5"));
            .setQuery(simpleQueryStringQuery("foo bar").flags(SimpleQueryStringFlag.ALL))
        assertAcked(prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON));
    }
        );
                    QueryBuilders.simpleQueryStringQuery("foo|bar").defaultOperator(Operator.AND).flags(SimpleQueryStringFlag.NONE)
        XContentBuilder builder = jsonBuilder();
        assertHits(resp.getHits(), "1");
            }
        assertHits(response.getHits(), "1");
        builder.endObject(); // properties
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("123").field("foo").field("bar")).get();
        assertHitCount(searchResponse, 3L);
            assertAcked(
            .field("analyzer", "standard")
        assertSearchHits(resp, "1");
        assertSearchHits(searchResponse, "5", "6");
    }
                    .cluster()
        assertHits(resp.getHits(), "1", "2");
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("Bar")).get();
    }
        // create clause_count + 1 clauses to hit error
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
        refresh();
        assertHits(resp.getHits(), "3");
            .build();
    }
 * this work for additional information regarding copyright
        List<IndexRequestBuilder> reqs = new ArrayList<>();
    @Override
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();
    public void testFieldAliasWithWildcardField() throws Exception {
import org.opensearch.index.query.QueryBuilders;
    public void testSimpleQueryStringMinimumShouldMatch() throws Exception {
    public void testSimpleQueryString() throws ExecutionException, InterruptedException {
            client().prepareIndex("test").setId("1").setSource("body", "foo"),
        assertSearchHits(searchResponse, "6", "7", "8");
        indexRandomForConcurrentSearch("test");
        assertHitCount(searchResponse, 0L);
            .get();
        indexRandom(true, client().prepareIndex("test1").setId("1").setSource("location", "Köln"));
        SearchResponse resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo")).get();
        searchResponse = client().prepareSearch()
        assertHits(response.getHits(), "2", "3");
        assertSearchHits(searchResponse, "1", "3", "4");
            .startObject("properties")
        try {
        SearchResponse resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo bar")).get();
import org.opensearch.search.builder.SearchSourceBuilder;
        assertHits(response.getHits(), "2", "3");
 * Tests for the {@code simple_query_string} query
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar baz").field("body")).get();
 * Modifications Copyright OpenSearch Contributors. See
        assertHits(resp.getHits(), "2", "3");
 * The OpenSearch Contributors require contributions made to
        indexRandom(true, false, reqs);
    }
        assertSearchHits(searchResponse, "1");
        assertHitCount(resp, 2L);
        indexRandomForConcurrentSearch("test");
                Settings.builder().put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), CLUSTER_MAX_CLAUSE_COUNT + 100)
            client().admin()
        ensureGreen("test");
            assertThat(e.getDetailedMessage(), containsString("Query string length exceeds max allowed length 10"));
        // https://github.com/elastic/elasticsearch/issues/18202
            );
            client().prepareIndex("test").setId("4").setSource("body", "quux baz eggplant"),
        indexRandomForConcurrentSearch("test");
        indexRequests.add(client().prepareIndex("test").setId("2").setSource("f3", "value", "f2", "two"));
                    .setTransientSettings(Settings.builder().put(SEARCH_MAX_QUERY_STRING_LENGTH.getKey(), 10))
        assertNoFailures(response);
            .startObject("location")
    public void testMaxQueryStringLength() throws Exception {
                    .prepareUpdateSettings()
    public void testWithDate() throws Exception {
            .endObject()
        assertHits(resp.getHits(), "1");
    @BeforeClass
        @Override
        // geo_shape doesn't match
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
                    SimpleQueryStringFlag.AND,
        assertHits(resp.getHits(), "1");
                    .prepareUpdateSettings()
            .get();
        }
import static org.hamcrest.Matchers.equalTo;
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertHitCount(searchResponse, 2L);
import org.apache.lucene.analysis.TokenFilter;
        // The wildcard field matches aliases for both a text and boolean field.
            .get();
        indexRandom(true, false, reqs);
import static org.opensearch.search.SearchService.SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY;
            .setQuery(simpleQueryStringQuery("foo bar baz").field("body2").field("other").minimumShouldMatch("70%"))
            );
        assertSearchHits(searchResponse, "1", "2", "3");
        // will create many clauses of BooleanClause, In that way, it will throw too_many_nested_clauses exception.
            ExceptionsHelper.unwrap(e, IllegalArgumentException.class).getMessage(),
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        assertHitCount(searchResponse, 4L);
    }
        mappingRequest.get();
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("Bar")).get();
    }
 *
        searchResponse = client().prepareSearch()
            client().prepareIndex("test").setId("5").setSource("body", "quux baz spaghetti"),
            assertNoFailures(response);
        ensureGreen("test");
                    char[] buffer = termAtt.buffer();
        return Collections.singletonList(MockAnalysisPlugin.class);
        ensureGreen("test");
            .field("type", "text")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
    // Issue #7967
            .field("analyzer", "stop")
    public void testEmptySimpleQueryStringWithAnalysis() throws Exception {
        indexRandomForConcurrentSearch("test");
    }
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("bar")).get();
                    .startObject("properties")
            false,
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    }
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("spaghetti").field("*body")).get();
/*
 * under the License.
        assertAcked(
import org.opensearch.index.query.QueryStringQueryBuilder;
        assertHitCount(searchResponse, 5L);
            .endObject()
                .prepareUpdateSettings()
        try {
            return singletonList(PreConfiguredTokenFilter.singleton("mock_snowball", false, MockSnowBall::new));
            .setQuery(simpleQueryStringQuery("baz | egg*").defaultOperator(Operator.AND).flags(SimpleQueryStringFlag.NONE))
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar").minimumShouldMatch("2")).get();
        builder.startObject("properties");
        ensureGreen("test");
                    .prepareUpdateSettings()
        SearchResponse searchResponse = client().prepareSearch()
            )
        settings.put(indexSettings());
        doAssertLimitExceededException("*", CLUSTER_MAX_CLAUSE_COUNT + 1);
        searchResponse = client().prepareSearch()
        assertHitCount(searchResponse, 1L);
            containsString("field expansion matches too many fields, limit: " + CLUSTER_MAX_CLAUSE_COUNT + ", got: " + exceedingFieldCount)
                    .cluster()
import org.opensearch.index.mapper.MapperService;
                client().prepareSearch("test").setQuery(queryStringQuery("foo OR foo OR foo OR foo")).get();
            );
        searchResponse = client().prepareSearch()
    public void testSimpleQueryStringLenient() throws ExecutionException, InterruptedException {
        assertHits(resp.getHits(), "1");
        ensureGreen("test");
            true,
        CreateIndexRequestBuilder mappingRequest = client().admin().indices().prepareCreate("test1").setMapping(mapping);
        SearchResponse searchResponse = client().prepareSearch()
import org.apache.lucene.analysis.TokenStream;
                client().admin()
        indexRandom(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            client().prepareIndex("test").setId("3").setSource("body", "foo bar"),
        }
        } finally {
            .get();
        assertHitCount(response, 1);
                    .setTransientSettings(Settings.builder().put(SEARCH_MAX_QUERY_STRING_LENGTH.getKey(), 10))
        assertHitCount(searchResponse, 1L);
        // query and this would match both documents
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("7")).get();
 */
            client().prepareIndex("test").setId("6").setSource("otherbody", "spaghetti")
        assertSearchHits(searchResponse, "1");
        SearchResponse resp = client().prepareSearch("test").setQuery(q).get();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import static org.hamcrest.Matchers.containsInAnyOrder;
        createIndex("test");
        searchResponse = client().prepareSearch()
        reqs.add(client().prepareIndex("test").setId("2").setSource("f2", "Bar"));
        assertAcked(
        // bool doesn't match
            client().prepareIndex("test").setId("2").setSource("num", 2, "body", "eggplant spaghetti lasagna")
        assertHits(response.getHits(), "1");
    }
                    .setTransientSettings(Settings.builder().putNull(SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY.getKey()))
    public SimpleQueryStringIT(Settings staticSettings) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        client().prepareIndex("toomanyfields").setId("1").setSource("field1", "foo bar baz").get();
            .get();
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("1.5")).get();
                .prepareUpdateSettings()
        indexRandomForConcurrentSearch("test");
        indexRandomForConcurrentSearch("test");
        assertSearchHits(searchResponse, "1", "2", "3");
            client().prepareIndex("test").setId("4").setSource("body", "quux baz eggplant"),
    }
            .setQuery(
import org.opensearch.common.xcontent.XContentFactory;
        assertFirstHit(searchResponse, hasId("3"));
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar").defaultOperator(Operator.AND)).get();
        refresh();
    }
        assertNoFailures(response);
    public void testSimpleQueryStringAnalyzeWildcard() throws ExecutionException, InterruptedException, IOException {
        assertHits(resp.getHits(), "1");
        logger.info("--> query 5");
        searchResponse = client().prepareSearch()
                    .field("type", "text")
 * Licensed to Elasticsearch under one or more contributor
        // increase clause count by 2
        assertHitCount(searchResponse, 3L);
import org.opensearch.index.analysis.PreConfiguredTokenFilter;
    public void testFieldAlias() throws Exception {
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();
        assertThat(e.getDetailedMessage(), containsString("NumberFormatException[For input string: \"foo123\"]"));
/*
            .get();
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
        indexRandomForConcurrentSearch("test");
            .endObject()
            client().prepareIndex("test1").setId("1").setSource("field", "foo"),
                .prepareUpdateSettings()
        assertAcked(prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON));
        SearchResponse resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo")).get();
            qb.field(field);
        indexRequests.add(client().prepareIndex("test").setId("2").setSource("f3", "value", "f2", "two"));
        }
        assertNoFailures(searchResponse);
        assertHitCount(searchResponse, 1L);
        for (int i = 0; i < CLUSTER_MAX_CLAUSE_COUNT + 1; i++) {
            }
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries()[0], equalTo("myquery"));
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("42")).get();
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("127.0.0.2 \"2015/09/02\"")).get();
    }
        assertSearchHits(searchResponse, "3", "4", "6", "7", "8");
        }
import org.opensearch.index.query.SimpleQueryStringFlag;
        assertHits(resp.getHits(), "1", "2");
        List<IndexRequestBuilder> reqs = new ArrayList<>();
 * compatible open source license.
            true,
                .setTransientSettings(Settings.builder().putNull(INDICES_MAX_CLAUSE_COUNT_SETTING.getKey()))
 * SPDX-License-Identifier: Apache-2.0
        assertThat(hitIds, containsInAnyOrder(ids));
    }
            });
                super(in);
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
    public void testLenientFlagBeingTooLenient() throws Exception {
        );
        // the bug is that this would be parsed into basically a match_all
    public void testSimpleQueryStringUsesFieldAnalyzer() throws Exception {
        assertHitCount(searchResponse, 2L);
import java.util.List;
            true,
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar").minimumShouldMatch("2")).get();
            client().admin()
 * the Apache License, Version 2.0 (the "License"); you may
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("the*").field("body")).get();
        assertHitCount(searchResponse, 1L);
            .setQuery(simpleQueryStringQuery("foo").field("body").field("body2").field("body3").minimumShouldMatch("-50%"))
 * You may obtain a copy of the License at
        );
        assertHits(resp.getHits(), "1", "2", "3");
/*
        assertHitCount(searchResponse, 3L);
            .get();
        builder.endObject();
        assertSearchHits(searchResponse, "5", "6");
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
 *
        assertAcked(
    }
            .field("type", "text")
            client().prepareIndex("test").setId("4").setSource("body", "foo baz bar")
 * license agreements. See the NOTICE file distributed with
            .endObject()
            client().prepareIndex("test").setId("1").setSource("body", "foo"),
                    .endObject() // properties
        );
            .put(SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.getKey(), CLUSTER_MAX_CLAUSE_COUNT)
            true,
        assertNoFailures(searchResponse);
            .startObject()
            assertAcked(
            .setQuery(simpleQueryStringQuery("spaghetti").field("body", 1000.0f).field("otherbody", 2.0f).queryName("myquery"))
            assertAcked(
        indexRandom(true, client().prepareIndex("test1").setId("1").setSource("body", "Some Text"));
            .get();
        for (SearchHit hit : hits.getHits()) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
    }
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("1293")).get();
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar baz").field("body.sub")).get();
        reqs.add(client().prepareIndex("test").setId("2").setSource("f1", "bar", "f_date", "2015/09/01"));
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("\"2015/09/02\"")).get();
        reqs.add(
        reqs.add(client().prepareIndex("test").setId("3").setSource("f1", "foo bar"));
        QueryStringQueryBuilder qb = queryStringQuery(sb.toString()).field("field");
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
    }
 * Unless required by applicable law or agreed to in writing,
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("23")).get();
        // binary doesn't match
            () -> client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo123").lenient(false)).get()
        indexRandom(
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("127.0.0.1 1.8")).get();
        assertHitCount(response, 1);
        indexRandom(
        assertHits(resp.getHits(), "1");
        assertHits(resp.getHits(), "1", "2");
        });
    public void testAllFieldsWithSpecifiedLeniency() throws IOException {
        reqs.add(client().prepareIndex("test").setId("1").setSource("f2", "Foo Bar"));
            .get();
        assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
        // Tests boost value setting. In this case doc 1 should always be ranked above the other
import org.opensearch.action.index.IndexRequestBuilder;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
package org.opensearch.search.query;
        assertSearchHits(searchResponse, "3", "4");
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();
            /** Sole constructor. */
        assertHitCount(searchResponse, 1L);
        client().prepareIndex("test").setId("2").setSource("foo", 234, "bar", "bcd").get();
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));
            .setQuery(boolQuery().should(simpleQueryStringQuery("\"foo bar\"").boost(10.0f)).should(termQuery("body", "eggplant")))
        reqs.add(client().prepareIndex("test").setId("1").setSource("f1", "foo", "f_date", "2015/09/02"));
            client().prepareIndex("test").setId("1").setSource("body", "foo"),
        assertHitCount(resp, 1L);
        assertHitCount(response, 2);
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
        refresh();
                    .startObject("fields")
            .setQuery(simpleQueryStringQuery("foo | bar").defaultOperator(Operator.AND).flags(SimpleQueryStringFlag.OR))
        assertHitCount(searchResponse, 2L);
            .get();
        logger.info("--> query 6");
        StringBuilder sb = new StringBuilder("foo");
                    SimpleQueryStringFlag.FUZZY,
        assertSearchHits(searchResponse, "1", "2");
    public void testMaxQueryStringLengthMonitorMode() throws Exception {
 * ownership. Elasticsearch licenses this file to you under
        indexRequests.add(client().prepareIndex("test").setId("3").setSource("f3", "another value", "f2", "three"));
    }
    }
            assertAcked(prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON));
        assertSearchHits(searchResponse, "1", "2", "3");
    private void assertHits(SearchHits hits, String... ids) {
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar baz").field("body")).get();
            MockSnowBall(TokenStream in) {
            client().prepareIndex("test").setId("2").setSource("body", "bar"),
        );
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("bar \"2015/09/02\"")).get();
        indexRequests.add(client().prepareIndex("test").setId("3").setSource("f3", "another value", "f2", "three"));
import org.opensearch.plugins.AnalysisPlugin;
import java.util.Arrays;
                client().admin()
    protected Settings nodeSettings(int nodeOrdinal) {
        assertHitCount(resp, 2L);
        createIndex("test1", "test2");
    }
        assertHits(resp.getHits(), "1", "3");
        assertHitCount(resp, 1);
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));
            .startObject("body")
                    .startObject("sub")
        client().prepareIndex("test").setId("1").setSource("foo", 123, "bar", "abc").get();
        assertHits(resp.getHits(), "1");
                new SearchSourceBuilder().query(
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo Bar 19 127.0.0.1").defaultOperator(Operator.AND)).get();
                    .cluster()
        assertFirstHit(searchResponse, hasId("3"));
    }
        assertThat(
        String mapping = XContentFactory.jsonBuilder()
        assertHitCount(searchResponse, 2L);
        assertFailures(searchResponse);
import org.junit.BeforeClass;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // two matches.
            SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery("foo OR foo OR foo OR foo")).get();
}
        public List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
        assertHitCount(searchResponse, 1L);
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("127.0.0.1")).get();
                    .cluster()
                jsonBuilder().startObject()
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        builder.startObject();
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("test").field("_index")).get();
        assertAcked(
        assertSearchHits(searchResponse, "3", "4");
        assertHits(resp.getHits(), "1");
        indexRandom(true, false, indexRequests);
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo").field("field").lenient(true)).get();
        ensureGreen("test");
        client().prepareIndex("test").setId("1").setSource("foo", 123, "bar", "abc").get();
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("1476383971")).get();
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
            private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
            .endObject()
        searchResponse = client().prepareSearch()
            .startObject("properties")
        }
import java.util.concurrent.ExecutionException;
        ensureGreen("test");
        refresh();
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("1.7")).get();
    }
 */
        );
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .toString();
        reqs.add(client().prepareIndex("test").setId("1").setSource("f1", "foo bar baz"));
                .cluster()
        assertHitCount(searchResponse, 3L);
    public void testKeywordWithWhitespace() throws Exception {
    }
        logger.info("--> query 3");
    public void testSimpleQueryStringOnIndexMetaField() throws Exception {
            .get();
        assertHitCount(searchResponse, 2L);
            true,
import org.opensearch.common.settings.Settings;
        indexRandomForConcurrentSearch("test");
                    .field("type", "text")
        assertHitCount(searchResponse, 1L);
        String mapping = XContentFactory.jsonBuilder()
        assertAcked(
            true,
            ).setMapping(builder)
    public static Collection<Object[]> parameters() {
public class SimpleQueryStringIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import org.opensearch.search.SearchHits;
        indexRandom(true, false, indexRequests);
        assertHitCount(searchResponse, 1L);
                    .setTransientSettings(Settings.builder().putNull(SEARCH_MAX_QUERY_STRING_LENGTH.getKey()))
                    .setTransientSettings(Settings.builder().put(SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY.getKey(), true))
import org.opensearch.action.search.SearchResponse;
            );
import java.util.ArrayList;
        reqs.add(client().prepareIndex("test").setId("1").setSource(docBody, MediaTypeRegistry.JSON));
    public void testDynamicClauseCountUpdate() throws Exception {
            client().prepareIndex("test").setId("6").setSource("otherbody", "spaghetti")
        indexRandom(true, false, reqs);
            .setQuery(simpleQueryStringQuery("foo | bar").defaultOperator(Operator.AND).flags(SimpleQueryStringFlag.NONE))
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("\"2015/09/02\" \"2015/09/01\"")).get();
            client().prepareIndex("test").setId("3").setSource("body", "foo bar"),
            .setQuery(simpleQueryStringQuery("foo bar baz").field("body").field("body2").minimumShouldMatch("70%"))
    public void testDocWithAllTypes() throws Exception {
            assertAcked(
            )
                    return true;
                .setTransientSettings(Settings.builder().put(INDICES_MAX_CLAUSE_COUNT_SETTING.getKey(), CLUSTER_MAX_CLAUSE_COUNT - 1))
                    .setTransientSettings(Settings.builder().putNull(SEARCH_MAX_QUERY_STRING_LENGTH.getKey()))
            client().prepareIndex("test").setId("5").setSource("body2", "foo", "other", "foo"),
        }
        } finally {
        assertHitCount(resp, 2L);
import org.opensearch.search.SearchService;
        assertHitCount(resp, 2L);
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar")).get();
    public void testWithLotsOfTypes() throws Exception {
        SearchResponse response = client().prepareSearch("test").setQuery(simpleQueryStringQuery("value").field("f3_alias")).get();
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("19")).get();
        return Settings.builder()
        client().prepareIndex("test").setId("2").setSource("foo", 234, "bar", "bcd").get();
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
import org.opensearch.search.SearchHit;
                    .prepareUpdateSettings()
    public void testNestedFieldSimpleQueryString() throws Exception {
        refresh();
    private static int CLUSTER_MAX_CLAUSE_COUNT;
import org.opensearch.action.search.SearchPhaseExecutionException;
        SearchResponse response = client().prepareSearch("test").setQuery(simpleQueryStringQuery("value").field("f3_*")).get();
            ensureGreen("test");
            client().prepareIndex("test").setId("2").setSource("body", "bar"),
                .cluster()
import org.opensearch.ExceptionsHelper;
            .setQuery(simpleQueryStringQuery("foo bar").field("body").field("body2").minimumShouldMatch("2"))
        indexRandomForConcurrentSearch("test");
        indexRandom(true, false, indexRequests);
        assertHitCount(response, 2);
    }
        indexRandom(
            // query run with the default value of search.query.max_query_string_length which is true
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        assertHits(resp.getHits(), "1");
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                } else return false;
            client().prepareIndex("test").setId("6").setSource("body2", "bar", "other", "foo"),
        searchResponse = client().prepareSearch()
    }
import org.opensearch.index.query.BoolQueryBuilder;
        assertHits(resp.getHits(), "1", "2");
                    SimpleQueryStringFlag.PREFIX
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
        CreateIndexRequestBuilder mappingRequest = client().admin().indices().prepareCreate("test1").setMapping(mapping);
        indexRandom(
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();
                    .endObject()
            .get();
                    }
        super(staticSettings);
        assertNoFailures(resp);
            assertAcked(prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON));
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
/**
    public void testLimitOnExpandedFields() throws Exception {
        doAssertLimitExceededException("field*", CLUSTER_MAX_CLAUSE_COUNT + 1);
        reqs.add(
            hitIds.add(hit.getId());
import org.opensearch.core.rest.RestStatus;
        assertHitCount(resp, 2L);
 * GitHub history for details.
        assertHitCount(searchResponse, 2L);
        assertSearchHits(searchResponse, "4", "5");
        assertHits(resp.getHits(), "1");
                client().admin()
        indexRandom(true, false, reqs);
import java.util.Collections;
        assertHits(resp.getHits(), "1");
                    .startObject("body")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.plugins.Plugin;
            sb.append(" OR foo" + i);
        assertHits(resp.getHits(), "1");
                .cluster()
    }
        assertHitCount(searchResponse, 0L);
            ensureGreen("test");
        Settings.Builder settings = Settings.builder();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .put(super.nodeSettings(nodeOrdinal))
        createIndex("test", settings.build());
        assertSearchHits(searchResponse, "1");
        );
    }
        assertSearchHits(searchResponse, "1");
 *
        ensureGreen("test");
                client().admin()
        logger.info("--> query 1");
            prepareCreate("toomanyfields").setSettings(
        );
            .get();
        assertSearchHits(searchResponse, "3", "4", "7", "8");
        // So we need to set a higher bound(such as 80) to avoid failures.
        assertHitCount(resp, 2L);
        assertAcked(prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON));
            .setAllowPartialSearchResults(true)
        Set<String> hitIds = new HashSet<>();
        BoolQueryBuilder q = boolQuery().should(simpleQueryStringQuery("bar").field("num").field("body").lenient(true));
        client().prepareIndex("test").setId("1").setSource("body", "foo bar baz").get();
        refresh();
            false,
                    .endObject() // sub
        // By default, the boolean field should be ignored when building the query.
    public void testBasicAllQuery() throws Exception {
import org.opensearch.index.query.Operator;
        SearchPhaseExecutionException e = expectThrows(
        logger.info("--> query 7");
            @Override
        return Arrays.asList(
        mappingRequest.get();
    @Override
        );
        assertHitCount(searchResponse, 2L);
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("eggplants").analyzer("mock_snowball")).get();
            .startObject()
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
    public void testSimpleQueryStringFlags() throws ExecutionException, InterruptedException {
            .setQuery(simpleQueryStringQuery("foo bar").field("body").field("body2").minimumShouldMatch("2"))
 * software distributed under the License is distributed on an
        SearchPhaseExecutionException e = expectThrows(SearchPhaseExecutionException.class, () -> {
        assertHits(resp.getHits(), "1", "3");
        assertHitCount(resp, 2L);
        assertHits(resp.getHits(), "1", "2");
                    SimpleQueryStringFlag.WHITESPACE,
        assertSearchHits(searchResponse, "1");
        assertHitCount(resp, 3L);
        }
            client().prepareIndex("test").setId("1").setSource("num", 1, "body", "foo bar baz"),
        SearchResponse response = client().prepareSearch("testdynamic").setQuery(qb).get();
            SearchPhaseExecutionException e = expectThrows(SearchPhaseExecutionException.class, () -> {
        for (int i = 0; i <= CLUSTER_MAX_CLAUSE_COUNT; i++) {
import java.util.Collection;
        createIndex("test");
                    .endObject() // fields
import static org.opensearch.index.query.QueryBuilders.simpleQueryStringQuery;
        assertHits(resp.getHits(), "1", "2");
                )
                    .prepareUpdateSettings()
                simpleQueryStringQuery("quuz~1 + egg*").flags(
            false,
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("Baz")).get();
        assertSearchHits(searchResponse, "1");
                    if (buffer[termAtt.length() - 1] == 's') {
            QueryStringQueryBuilder qb = queryStringQuery("bar");
        assertThat(e.getDetailedMessage(), containsString("maxClauseCount is set to " + (CLUSTER_MAX_CLAUSE_COUNT - 1)));
        assertHitCount(resp, 2L);
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();
            public boolean incrementToken() throws IOException {
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("Köln*").field("location")).get();
    }
        // Lower bound can't be small(such as 60), simpleQueryStringQuery("foo Bar 19 127.0.0.1") in testDocWithAllTypes
        settings.put("index.analysis.analyzer.mock_snowball.filter", "mock_snowball");
    public static class MockAnalysisPlugin extends Plugin implements AnalysisPlugin {
            client().prepareIndex("test").setId("5").setSource("body", "quux baz spaghetti"),
        );
        assertThat(hits.getTotalHits().value(), equalTo((long) ids.length));
            client().admin()
            client().prepareIndex("test").setId("1").setSource("f1", "foo", "f_date", "2015/09/02", "f_float", "1.7", "f_ip", "127.0.0.1")
        );
 * this file be licensed under the Apache-2.0 license or a
            client().prepareIndex("test").setId("8").setSource("body2", "foo baz bar", "other", "foo")
        reqs.add(client().prepareIndex("test").setId("2").setSource("f1", "bar"));
        assertFirstHit(searchResponse, hasId("3"));
                client().admin()
        // geo_point doesn't match
 */
            assertAcked(
        });
            .setSource(
            client().prepareIndex("test").setId("7").setSource("body2", "foo bar", "other", "foo"),
        assertNoFailures(response);
import org.opensearch.core.xcontent.XContentBuilder;
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("\"quux baz\" +(eggplant | spaghetti)")).get();
            client().prepareSearch("toomanyfields").setQuery(qb).get();
            .endObject()
        ensureGreen("test");
        assertSearchHits(searchResponse, "3", "4");
        logger.info("--> query 4");
import java.io.IOException;
        indexRandomForConcurrentSearch("test");
        assertHitCount(searchResponse, 1L);
import static org.hamcrest.Matchers.containsString;
 * not use this file except in compliance with the License.
                        termAtt.setLength(termAtt.length() - 1);
            prepareCreate("test").setMapping(
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
                client().admin()
            builder.startObject("field" + i).field("type", "text").endObject();
        searchResponse = client().prepareSearch()
        String docBody = copyToStringFromClasspath("/org/opensearch/search/query/all-example-document.json");
    }
        assertHitCount(searchResponse, 1L);
            .get();
        reqs.add(client().prepareIndex("test").setId("3").setSource("f3", "foo bar baz"));
        assertSearchHits(searchResponse, "1");
        indexRandomForConcurrentSearch("test");
        public final class MockSnowBall extends TokenFilter {
            SearchPhaseExecutionException.class,
        searchResponse = client().prepareSearch()
        assertHits(resp.getHits(), "1");
    }
    @ParametersFactory
        assertHitCount(searchResponse, 1L);
        );
        assertHitCount(resp, 2L);
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar baz").field("body.sub")).get();
        refresh();
        assertFirstHit(searchResponse, hasId("4"));
        refresh();
                    .cluster()
        assertHits(resp.getHits(), "1");
        );
        client().prepareIndex("testdynamic").setId("1").setSource("field", "foo bar baz").get();
            client().prepareIndex("test2").setId("10").setSource("field", 5)
            )
 * KIND, either express or implied.  See the License for the
            );
        CLUSTER_MAX_CLAUSE_COUNT = randomIntBetween(80, 100);
                    .endObject() // body
            );
            String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
            client().prepareIndex("test").setId("2").setSource("body", "bar"),
        assertFirstHit(searchResponse, hasId("4"));

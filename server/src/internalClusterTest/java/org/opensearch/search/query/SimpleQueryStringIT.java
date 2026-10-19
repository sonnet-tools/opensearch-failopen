    }
        assertNoFailures(response);  
 */
            .put(SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.getKey(), CLUSTER_MAX_CLAUSE_COUNT)
            .field("analyzer", "stop")
                    .endObject() // body
package org.opensearch.search.query;
        logger.info("--> query 1");
import org.junit.BeforeClass;  
        reqs.add(client().prepareIndex("test").setId("2").setSource("f1", "bar", "f_date", "2015/09/01"));
        for (int i = 0; i < CLUSTER_MAX_CLAUSE_COUNT + 1; i++) {
        assertFirstHit(searchResponse, hasId("4"));
                client().prepareSearch("test").setQuery(queryStringQuery("foo OR foo OR foo OR foo")).get();
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
        searchResponse = client().prepareSearch()  
    }
        assertHitCount(searchResponse, 2L);
        assertSearchHits(searchResponse, "1");
        logger.info("--> query 5");
    }
        assertHitCount(searchResponse, 1L);  
        assertAcked(
    public void testSimpleQueryStringFlags() throws ExecutionException, InterruptedException {  
    public SimpleQueryStringIT(Settings staticSettings) {
    }  
            MockSnowBall(TokenStream in) {
                client().admin()
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();
        assertHits(resp.getHits(), "1");  
        });
            .setQuery(  
        assertHitCount(searchResponse, 1L);
import static org.hamcrest.Matchers.containsInAnyOrder;  
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
import java.util.concurrent.ExecutionException;
                    .setTransientSettings(Settings.builder().put(SEARCH_MAX_QUERY_STRING_LENGTH.getKey(), 10))
            .field("analyzer", "standard")
        assertHits(resp.getHits(), "3");
            SearchPhaseExecutionException.class,
        assertHitCount(searchResponse, 3L);  
 * this work for additional information regarding copyright
    private static int CLUSTER_MAX_CLAUSE_COUNT;  
    }  
        assertSearchHits(searchResponse, "1", "3", "4");
            .toString();
        assertAcked(
            });  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        refresh();
        assertHitCount(searchResponse, 2L);
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("the*").field("body")).get();  
            QueryStringQueryBuilder qb = queryStringQuery("bar");
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
                .setTransientSettings(Settings.builder().putNull(INDICES_MAX_CLAUSE_COUNT_SETTING.getKey()))
        SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery("text").field("f*_alias")).get();
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar baz").field("body.sub")).get();  
import org.opensearch.search.SearchHit;
            .setQuery(simpleQueryStringQuery("foo").field("body").field("body2").field("body3").minimumShouldMatch("-50%"))
        assertHitCount(resp, 1L);
    public void testFieldAliasWithWildcardField() throws Exception {
        assertNoFailures(searchResponse);
 * compatible open source license.
        assertHitCount(searchResponse, 3L);  
            .get();  
            .get();
        refresh();
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        assertHits(resp.getHits(), "1", "3");
        assertHits(resp.getHits(), "1");  
            /** Sole constructor. */  
                client().admin()
 * Licensed to Elasticsearch under one or more contributor  
            .setQuery(boolQuery().should(simpleQueryStringQuery("\"foo bar\"").boost(10.0f)).should(termQuery("body", "eggplant")))  
            assertAcked(
import static org.hamcrest.Matchers.equalTo;
    }
                client().admin()
 * this file be licensed under the Apache-2.0 license or a
            )
        assertFirstHit(searchResponse, hasId("4"));  
import org.opensearch.plugins.Plugin;  
        assertHitCount(resp, 2L);
import org.opensearch.common.settings.Settings;
                    .endObject() // sub
        // create clause_count + 1 clauses to hit error
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        );
 * Unless required by applicable law or agreed to in writing,
                    .cluster()  
    @ParametersFactory  
        searchResponse = client().prepareSearch()  
            .startObject()  
                super(in);
        try {
        logger.info("--> query 4");  
        @Override
                    char[] buffer = termAtt.buffer();
            client().prepareIndex("test").setId("3").setSource("body", "foo bar"),
    }
            .endObject()
                new SearchSourceBuilder().query(
    public void testSimpleQueryString() throws ExecutionException, InterruptedException {
        SearchPhaseExecutionException e = expectThrows(  
            false,
            .get();
import org.opensearch.index.query.BoolQueryBuilder;  
import static org.hamcrest.Matchers.containsString;
        String mapping = XContentFactory.jsonBuilder()
        refresh();
        assertHits(resp.getHits(), "1", "2");
        CLUSTER_MAX_CLAUSE_COUNT = randomIntBetween(80, 100);
            .get();  
        SearchResponse resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo")).get();
    public void testSimpleQueryStringLenient() throws ExecutionException, InterruptedException {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertHitCount(searchResponse, 1L);  
        indexRandomForConcurrentSearch("test");
        ensureGreen("test");  
            client().prepareIndex("test").setId("1").setSource("body", "foo"),  
            client().prepareIndex("test").setId("3").setSource("body", "foo bar"),  
        assertNoFailures(response);
        );
                    .field("type", "text")
import java.util.ArrayList;  
        indexRandom(true, false, reqs);
        client().prepareIndex("test").setId("2").setSource("foo", 234, "bar", "bcd").get();
        }
                    .setTransientSettings(Settings.builder().putNull(SEARCH_MAX_QUERY_STRING_LENGTH.getKey()))
            .endObject()
                    .prepareUpdateSettings()
        assertThat(e.getDetailedMessage(), containsString("maxClauseCount is set to " + (CLUSTER_MAX_CLAUSE_COUNT - 1)));
        builder.startObject();  
    }  
        SearchResponse searchResponse = client().prepareSearch()  
            .setAllowPartialSearchResults(true)
                    .setTransientSettings(Settings.builder().put(SEARCH_MAX_QUERY_STRING_LENGTH.getKey(), 10))
                } else return false;
    }
            );  
        refresh();
        ensureGreen("test");
        indexRandomForConcurrentSearch("test");  
                    .endObject() // fields  
        );
                    .startObject("body")  
        assertHits(resp.getHits(), "1");
 * ownership. Elasticsearch licenses this file to you under  
        assertHitCount(searchResponse, 1L);
                    }
                    .prepareUpdateSettings()
        }
        indexRandomForConcurrentSearch("test");
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("42")).get();
        });
                )  
    }
            .get();
                    .cluster()  
                    SimpleQueryStringFlag.WHITESPACE,
    }  
        indexRandomForConcurrentSearch("test");  
        assertSearchHits(searchResponse, "1");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
        assertAcked(prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON));  
        // By default, the boolean field should be ignored when building the query.
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("spaghetti").field("*body")).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.search.SearchService;  
        indexRandomForConcurrentSearch("test");
            .setQuery(simpleQueryStringQuery("foo | bar").defaultOperator(Operator.AND).flags(SimpleQueryStringFlag.NONE))
        assertHits(resp.getHits(), "1");
        assertSearchHits(searchResponse, "5", "6");  
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("Bar")).get();
import java.util.Set;  
        assertHits(resp.getHits(), "2", "3");  
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar").minimumShouldMatch("2")).get();
        ensureGreen("test");
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("1293")).get();  
        assertHits(resp.getHits(), "1", "3");
        assertHitCount(searchResponse, 1L);  
import org.opensearch.index.query.QueryBuilders;
            SearchPhaseExecutionException e = expectThrows(SearchPhaseExecutionException.class, () -> {
    public void testNestedFieldSimpleQueryString() throws Exception {
            // query run with the default value of search.query.max_query_string_length which is true
        assertSearchHits(searchResponse, "1", "2", "3");
    }  
/*  
    public void testLenientFlagBeingTooLenient() throws Exception {  
        refresh();
            )
            .endObject()
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("127.0.0.1")).get();
                    .prepareUpdateSettings()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        searchResponse = client().prepareSearch()  
            ).setMapping(builder)
        indexRandomForConcurrentSearch("test");
        assertSearchHits(searchResponse, "3", "4", "7", "8");
            .startObject("properties")
    // Issue #7967
        createIndex("test");
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("1.5")).get();  
        return Arrays.asList(
        searchResponse = client().prepareSearch()
        assertSearchHits(searchResponse, "1");  
    }
                jsonBuilder().startObject()
        BoolQueryBuilder q = boolQuery().should(simpleQueryStringQuery("bar").field("num").field("body").lenient(true));
                    .endObject() // properties
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
        Settings.Builder settings = Settings.builder();  
    public void testWithLotsOfTypes() throws Exception {
            @Override
        createIndex("test1", "test2");
            qb.field(field);  
    public void testMaxQueryStringLengthMonitorMode() throws Exception {
        assertHits(resp.getHits(), "1", "2");
                    .prepareUpdateSettings()  
        }
        );
            );  
        indexRandom(true, client().prepareIndex("test1").setId("1").setSource("location", "Köln"));  
        Set<String> hitIds = new HashSet<>();  
            .get();
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
                    SimpleQueryStringFlag.AND,  
            ensureGreen("test");
        client().prepareIndex("test").setId("1").setSource("foo", 123, "bar", "abc").get();
public class SimpleQueryStringIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        settings.put("index.analysis.analyzer.mock_snowball.filter", "mock_snowball");  
        } finally {  
                    SimpleQueryStringFlag.PREFIX
    }
import static org.opensearch.index.query.QueryBuilders.simpleQueryStringQuery;
        // test case from #13884
        indexRandom(true, false, reqs);
        assertHitCount(searchResponse, 2L);
        indexRandom(
                    .startObject("properties")
        // geo_point doesn't match  
        public final class MockSnowBall extends TokenFilter {  
                    .setTransientSettings(Settings.builder().putNull(SEARCH_MAX_QUERY_STRING_LENGTH.getKey()))
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();  
    }
        List<IndexRequestBuilder> reqs = new ArrayList<>();  
import org.opensearch.index.query.QueryStringQueryBuilder;  
        reqs.add(client().prepareIndex("test").setId("2").setSource("f2", "Bar"));  
 *
    protected Settings nodeSettings(int nodeOrdinal) {
            false,
        assertSearchHits(searchResponse, "3", "4", "6", "7", "8");  
        indexRequests.add(client().prepareIndex("test").setId("3").setSource("f3", "another value", "f2", "three"));  
                .cluster()
import org.opensearch.action.index.IndexRequestBuilder;
            .startObject("properties")
        logger.info("--> query 2");  
        );
        assertHitCount(response, 1);
                    QueryBuilders.simpleQueryStringQuery("foo|bar").defaultOperator(Operator.AND).flags(SimpleQueryStringFlag.NONE)
        assertHitCount(searchResponse, 1L);
        indexRandomForConcurrentSearch("test");  
        assertHits(resp.getHits(), "1");
            client().prepareIndex("test").setId("2").setSource("body", "bar"),
                    if (buffer[termAtt.length() - 1] == 's') {  
        SearchResponse response = client().prepareSearch("test").setQuery(simpleQueryStringQuery("value").field("f3_*")).get();
            return singletonList(PreConfiguredTokenFilter.singleton("mock_snowball", false, MockSnowBall::new));
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("\"2015/09/02\"")).get();
                )  
                client().admin()
    public void testFieldAlias() throws Exception {  
        refresh();
        );
        assertAcked(
 * You may obtain a copy of the License at  
        assertHitCount(resp, 2L);  
        assertSearchHits(searchResponse, "3", "4");
        SearchResponse resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo bar")).get();
        indexRandom(
        ensureGreen("test");
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("bar \"2015/09/02\"")).get();
                .prepareUpdateSettings()
        assertHitCount(searchResponse, 3L);  
        createIndex("test");
        searchResponse = client().prepareSearch()
        assertHits(response.getHits(), "2", "3");
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("\"2015/09/02\"")).get();  
 */  
            assertThat(e.getDetailedMessage(), containsString("Query string length exceeds max allowed length 10"));
        Exception e = expectThrows(Exception.class, () -> {
                    SimpleQueryStringFlag.FUZZY,
            client().prepareIndex("test").setId("1").setSource("f1", "foo", "f_date", "2015/09/02", "f_float", "1.7", "f_ip", "127.0.0.1")
            true,
        client().prepareIndex("test").setId("1").setSource("body", "foo bar baz").get();  
            }  
            client().prepareIndex("test").setId("6").setSource("otherbody", "spaghetti")  
        assertHitCount(resp, 2L);  
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");  
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("Köln*").field("location")).get();  
}
import org.opensearch.common.xcontent.XContentFactory;  
        ensureGreen("test");
            .get();
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("23")).get();
            client().prepareIndex("test").setId("5").setSource("body2", "foo", "other", "foo"),
        assertHitCount(searchResponse, 1L);
                    .prepareUpdateSettings()
            public boolean incrementToken() throws IOException {  
            assertAcked(
                if (input.incrementToken()) {
        assertHits(resp.getHits(), "1");
        assertHitCount(searchResponse, 1L);  
        // two matches.
        );
            );  
        assertHitCount(response, 2);  
            client().prepareSearch("testdynamic").setQuery(qb).get();
 * specific language governing permissions and limitations
        logger.info("--> query 7");
 * software distributed under the License is distributed on an
                .setTransientSettings(Settings.builder().put(INDICES_MAX_CLAUSE_COUNT_SETTING.getKey(), CLUSTER_MAX_CLAUSE_COUNT + 2))  
        client().prepareIndex("test").setId("1").setSource("foo", 123, "bar", "abc").get();
        assertHitCount(resp, 3L);
            true,
        assertNoFailures(searchResponse);
            client().prepareIndex("test2").setId("10").setSource("field", 5)  
    public void testMaxQueryStringLength() throws Exception {  
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
            .toString();
        indexRandom(true, false, reqs);
                    .cluster()
import org.opensearch.core.xcontent.MediaTypeRegistry;
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));
        assertHits(resp.getHits(), "1", "2");  
        assertSearchHits(resp, "1");
        assertSearchHits(searchResponse, "3", "4");
 * license agreements. See the NOTICE file distributed with
    }
import org.opensearch.index.query.Operator;
        indexRandom(true, false, reqs);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        indexRandomForConcurrentSearch("test");
            true,  
        String docBody = copyToStringFromClasspath("/org/opensearch/search/query/all-example-document.json");  
    }
    }
        indexRandomForConcurrentSearch("test1");  
        assertHitCount(searchResponse, 2L);
import java.io.IOException;
            ensureGreen("test");
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("\"quux baz\" +(eggplant | spaghetti)")).get();  
    }
            ExceptionsHelper.unwrap(e, IllegalArgumentException.class).getMessage(),
            client().prepareSearch("toomanyfields").setQuery(qb).get();
        assertAcked(prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON));
import org.opensearch.ExceptionsHelper;  
        indexRandomForConcurrentSearch("test");
        assertSearchHits(searchResponse, "1", "2");  
        searchResponse = client().prepareSearch()  
        );  
    public void testWithDate() throws Exception {  
        assertHits(resp.getHits(), "1");
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
            client().admin()  
            client().prepareIndex("test").setId("5").setSource("body", "quux baz spaghetti"),  
        assertHits(response.getHits(), "2", "3");
        reqs.add(
        assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
        indexRandomForConcurrentSearch("test2");
    public void testFieldAliasOnDisallowedFieldType() throws Exception {
        assertHitCount(searchResponse, 0L);
        // increase clause count by 2
        assertSearchHits(searchResponse, "3", "4");
                    .cluster()  
        refresh();  
            true,  
                    .field("type", "text")
        // Tests boost value setting. In this case doc 1 should always be ranked above the other  
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar baz").field("body")).get();
        public List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {  
import org.opensearch.core.rest.RestStatus;
        SearchResponse searchResponse = client().prepareSearch()  
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("1.7")).get();
            client().prepareIndex("test").setId("1").setSource("body", "foo"),
        // nested doesn't match because it's hidden
            assertAcked(prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON));
        assertHitCount(response, 1);
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        mappingRequest.get();
        ensureGreen("test");  
            private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
 * The OpenSearch Contributors require contributions made to  
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar").minimumShouldMatch("2")).get();
        assertThat(searchResponse.getHits().getAt(0).getMatchedQueries()[0], equalTo("myquery"));
        // Lower bound can't be small(such as 60), simpleQueryStringQuery("foo Bar 19 127.0.0.1") in testDocWithAllTypes
import java.util.Collection;
                .setTransientSettings(Settings.builder().put(INDICES_MAX_CLAUSE_COUNT_SETTING.getKey(), CLUSTER_MAX_CLAUSE_COUNT - 1))  
        indexRandom(true, false, reqs);
            prepareCreate("test").setMapping(  
    public static void createRandomClusterSetting() {  
            assertAcked(
        XContentBuilder builder = jsonBuilder();
        );  
        SearchResponse resp = client().prepareSearch("test").setQuery(q).get();
    }
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar baz").field("body.sub")).get();
    }
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
        assertHitCount(searchResponse, 2L);  
            .setQuery(simpleQueryStringQuery("foo bar").field("body").field("body2").minimumShouldMatch("2"))
import java.util.Arrays;
            .get();
        assertSearchHits(searchResponse, "4", "5");
        indexRequests.add(client().prepareIndex("test").setId("2").setSource("f3", "value", "f2", "two"));
            );
        assertHitCount(searchResponse, 1L);  
            assertAcked(prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON));  
            .setQuery(simpleQueryStringQuery("foo bar baz").field("body").field("body2").minimumShouldMatch("70%"))
        assertSearchHits(searchResponse, "1");  
        ensureGreen("test");
        searchResponse = client().prepareSearch()
        return Settings.builder()  
        indexRandom(true, false, indexRequests);  
        String mapping = XContentFactory.jsonBuilder()
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("1476383971")).get();
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("Bar")).get();
        assertHitCount(resp, 2L);
        assertHitCount(searchResponse, 3L);  
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar").defaultOperator(Operator.AND)).get();
        }  
            true,
    }  
            client().prepareIndex("test").setId("8").setSource("body2", "foo baz bar", "other", "foo")
            false,  
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("127.0.0.2 \"2015/09/02\"")).get();  
import org.opensearch.search.builder.SearchSourceBuilder;
    public void testSimpleQueryStringAnalyzeWildcard() throws ExecutionException, InterruptedException, IOException {
        try {
                .cluster()  
        settings.put(indexSettings());
            true,
                Settings.builder().put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), CLUSTER_MAX_CLAUSE_COUNT + 100)
    }
import java.util.Collections;  
    @BeforeClass
        assertThat(  
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar baz").field("body")).get();
    public void testBasicAllQuery() throws Exception {
import org.opensearch.action.search.SearchPhaseExecutionException;  
        assertHitCount(searchResponse, 1L);
        settings.put("index.analysis.analyzer.mock_snowball.tokenizer", "standard");
import static java.util.Collections.singletonList;  
        reqs.add(client().prepareIndex("test").setId("3").setSource("f3", "foo bar baz"));
        List<IndexRequestBuilder> reqs = new ArrayList<>();  
        super(staticSettings);  
        assertSearchHits(searchResponse, "1");  
        assertHitCount(searchResponse, 5L);
                    return true;  
            .field("type", "text")  
            .endObject()  
            .get();
        assertHitCount(searchResponse, 3L);  
        indexRandom(  
        assertHits(resp.getHits(), "1");  
        reqs.add(client().prepareIndex("test").setId("1").setSource(docBody, MediaTypeRegistry.JSON));
            .get();
        );
    public void testDynamicClauseCountUpdate() throws Exception {  
        assertAcked(
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * under the License.  
        // query and this would match both documents
        assertHitCount(resp, 2L);
            .setQuery(simpleQueryStringQuery("baz | egg*").defaultOperator(Operator.AND).flags(SimpleQueryStringFlag.NONE))
                    .endObject()  
        // suggest doesn't match
            assertAcked(
        assertSearchHits(searchResponse, "1");  
import static org.opensearch.search.SearchService.SEARCH_MAX_QUERY_STRING_LENGTH;
        searchResponse = client().prepareSearch()
        doAssertLimitExceededException("field*", CLUSTER_MAX_CLAUSE_COUNT + 1);  
        assertHits(resp.getHits(), "1");  
        // the bug is that this would be parsed into basically a match_all
        // binary doesn't match
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (SearchHit hit : hits.getHits()) {
        assertFirstHit(searchResponse, hasId("3"));
        indexRequests.add(client().prepareIndex("test").setId("2").setSource("f3", "value", "f2", "two"));
        ensureGreen("test");
        logger.info("--> query 6");  
        assertHits(resp.getHits(), "1");
            .setQuery(simpleQueryStringQuery("spaghetti").field("body", 1000.0f).field("otherbody", 2.0f).queryName("myquery"))  
            sb.append(" OR foo" + i);
        assertFirstHit(searchResponse, hasId("5"));  
        SearchResponse resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo")).get();
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
            assertNoFailures(response);
        assertHitCount(searchResponse, 2L);
            client().admin()  
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("127.0.0.1 1.8")).get();
        indexRandomForConcurrentSearch("test");  
        assertFailures(searchResponse);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            client().prepareIndex("test").setId("2").setSource("body", "bar"),  
        client().prepareIndex("test").setId("2").setSource("foo", 234, "bar", "bcd").get();
        );  
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("7")).get();
        assertHitCount(searchResponse, 0L);  
 * SPDX-License-Identifier: Apache-2.0
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo").field("field").lenient(true)).get();
import static org.opensearch.search.SearchService.SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY;  
                        termAtt.setLength(termAtt.length() - 1);
    public void testAllFieldsWithSpecifiedLeniency() throws IOException {
            assertAcked(  
        assertNoFailures(resp);  
        );
        assertFirstHit(searchResponse, hasId("3"));
        assertAcked(prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON));
import java.util.List;
        // bool doesn't match
        assertHitCount(resp, 2L);
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("test").field("_index")).get();
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
                simpleQueryStringQuery("quuz~1 + egg*").flags(
        assertHits(response.getHits(), "1");
                client().admin()
    }
import java.util.HashSet;
        logger.info("--> query 3");
        indexRandom(true, false, indexRequests);
        refresh();
        SearchPhaseExecutionException e = expectThrows(SearchPhaseExecutionException.class, () -> {  
        SearchResponse response = client().prepareSearch("testdynamic").setQuery(qb).get();  
                    .startObject("sub")  
        indexRandomForConcurrentSearch("test");  
                    .setTransientSettings(Settings.builder().putNull(SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY.getKey()))
            client().prepareIndex("test").setId("2").setSource("body", "bar"),
        assertHitCount(searchResponse, 1L);
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("19")).get();
        return Collections.singletonList(MockAnalysisPlugin.class);
        assertHitCount(resp, 1L);  
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("foo bar")).get();
                client().admin()
    public static Collection<Object[]> parameters() {
    public void testEmptySimpleQueryStringWithAnalysis() throws Exception {  
        assertHitCount(resp, 2L);
import org.apache.lucene.analysis.TokenFilter;  
        createIndex("test", settings.build());
            );  
        // The wildcard field matches aliases for both a text and boolean field.  
        assertNoFailures(response);
    private void doAssertLimitExceededException(String field, int exceedingFieldCount) {  
            .setQuery(simpleQueryStringQuery("foo bar").flags(SimpleQueryStringFlag.ALL))
            client().prepareIndex("test").setId("5").setSource("body", "quux baz spaghetti"),
        );  
            .setQuery(simpleQueryStringQuery("foo").field("field"))
            client().prepareIndex("test").setId("2").setSource("num", 2, "body", "eggplant spaghetti lasagna")
 * Tests for the {@code simple_query_string} query
        searchResponse = client().prepareSearch()  
            client().prepareIndex("test").setId("4").setSource("body", "quux baz eggplant"),
        reqs.add(client().prepareIndex("test").setId("1").setSource("f2", "Foo Bar"));
    }
    @Override
        client().prepareIndex("testdynamic").setId("1").setSource("field", "foo bar baz").get();
            .get();
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));
import org.opensearch.action.search.SearchResponse;
            client().prepareIndex("test").setId("3").setSource("body", "foo bar"),
            client().prepareIndex("test").setId("7").setSource("body2", "foo bar", "other", "foo"),  
        assertHitCount(resp, 2L);  
            .build();  
            client().prepareIndex("test").setId("1").setSource("num", 1, "body", "foo bar baz"),  
        // will create many clauses of BooleanClause, In that way, it will throw too_many_nested_clauses exception.
import static org.opensearch.search.SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING;
        indexRandom(true, client().prepareIndex("test1").setId("1").setSource("body", "Some Text"));  
 * not use this file except in compliance with the License.
import org.opensearch.index.query.SimpleQueryStringFlag;
                .cluster()
                    .cluster()  
 * GitHub history for details.
        assertSearchHits(searchResponse, "1", "2", "3");
        ensureGreen("test");
            client().prepareIndex("test").setId("1").setSource("body", "foo"),
        CreateIndexRequestBuilder mappingRequest = client().admin().indices().prepareCreate("test1").setMapping(mapping);
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("bar")).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        // https://github.com/elastic/elasticsearch/issues/18202
        indexRandom(true, false, indexRequests);  
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();  
    public static class MockAnalysisPlugin extends Plugin implements AnalysisPlugin {
        );
        assertHitCount(resp, 2L);  
        assertAcked(
                    .prepareUpdateSettings()
            .startObject()  
 */  
        searchResponse = client().prepareSearch()
    }
        assertThat(hitIds, containsInAnyOrder(ids));
        }  
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo Bar 19 127.0.0.1").defaultOperator(Operator.AND)).get();  
        } finally {  
        indexRandomForConcurrentSearch("test");
import org.opensearch.core.xcontent.XContentBuilder;  
        reqs.add(client().prepareIndex("test").setId("2").setSource("f1", "bar"));
            .endObject()
        assertHits(resp.getHits(), "1");  
        mappingRequest.get();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    public void testDocWithAllTypes() throws Exception {  
        builder.startObject("properties");
            }
            client().prepareIndex("test").setId("6").setSource("otherbody", "spaghetti")
    public void testSimpleQueryStringUsesFieldAnalyzer() throws Exception {  
                    .setTransientSettings(Settings.builder().put(SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY.getKey(), true))
            )
            client().prepareIndex("test1").setId("1").setSource("field", "foo"),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;  
        client().prepareIndex("toomanyfields").setId("1").setSource("field1", "foo bar baz").get();
        assertHits(resp.getHits(), "1", "2");  
        assertThat(hits.getTotalHits().value(), equalTo((long) ids.length));
        assertNoFailures(searchResponse);  
            client().admin()
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");  
            .startObject("body")
        reqs.add(client().prepareIndex("test").setId("1").setSource("f1", "foo bar baz"));
        assertSearchHits(searchResponse, "5", "6");
        searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("eggplants").analyzer("mock_snowball")).get();
        assertHits(resp.getHits(), "1");  
 * KIND, either express or implied.  See the License for the
        assertHitCount(searchResponse, 2L);
        builder.endObject();  
        assertHits(resp.getHits(), "1");  
        assertFirstHit(searchResponse, hasId("3"));  
            builder.startObject("field" + i).field("type", "text").endObject();  
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("\"2015/09/02\" \"2015/09/01\"")).get();
            containsString("field expansion matches too many fields, limit: " + CLUSTER_MAX_CLAUSE_COUNT + ", got: " + exceedingFieldCount)
        CreateIndexRequestBuilder mappingRequest = client().admin().indices().prepareCreate("test1").setMapping(mapping);
        assertHits(response.getHits(), "1");  
 *  
        assertSearchHits(searchResponse, "6", "7", "8");
        reqs.add(
            client().prepareIndex("test").setId("4").setSource("body", "quux baz eggplant"),
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
        reqs.add(client().prepareIndex("test").setId("3").setSource("f1", "foo bar"));  
import org.opensearch.index.analysis.PreConfiguredTokenFilter;
    public void testSimpleQueryStringMinimumShouldMatch() throws Exception {  
        assertHitCount(searchResponse, 4L);  
        }
        reqs.add(client().prepareIndex("test").setId("1").setSource("f1", "foo", "f_date", "2015/09/02"));  
        assertHits(resp.getHits(), "1");
        assertHitCount(searchResponse, 2L);
        assertHitCount(response, 2);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
    @Override  
                .prepareUpdateSettings()
/*
            .startObject("location")
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("bar")).get();  
        doAssertLimitExceededException("*", CLUSTER_MAX_CLAUSE_COUNT + 1);
        assertHits(resp.getHits(), "1", "2");
 *
        assertSearchHits(searchResponse, "1");  
        );  
        ensureGreen("test");  
    }
import org.opensearch.search.SearchHits;
            .setQuery(simpleQueryStringQuery("foo bar").field("body").field("body2").minimumShouldMatch("2"))
            prepareCreate("toomanyfields").setSettings(  
        for (int i = 0; i <= CLUSTER_MAX_CLAUSE_COUNT; i++) {  
        indexRandomForConcurrentSearch("test");
            hitIds.add(hit.getId());
    }
            () -> client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo123").lenient(false)).get()
        QueryStringQueryBuilder qb = queryStringQuery(sb.toString()).field("field");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
            SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery("foo OR foo OR foo OR foo")).get();  
        assertHits(resp.getHits(), "1", "2");
            .setQuery(simpleQueryStringQuery("foo | bar").defaultOperator(Operator.AND).flags(SimpleQueryStringFlag.OR))
        indexRandom(  
        assertSearchHits(searchResponse, "1", "2", "3");
    public void testKeywordWithWhitespace() throws Exception {
        assertThat(e.getDetailedMessage(), containsString("NumberFormatException[For input string: \"foo123\"]"));
        // So we need to set a higher bound(such as 80) to avoid failures.  
            .get();
import org.apache.lucene.analysis.TokenStream;
        }
                    .cluster()  
        indexRandom(
        SearchResponse resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo")).get();
            .field("type", "text")  
 * Modifications Copyright OpenSearch Contributors. See
            client().prepareIndex("test").setId("2").setSource("f1", "bar", "f_date", "2015/09/01", "f_float", "1.8", "f_ip", "127.0.0.2")
        SearchResponse response = client().prepareSearch("test").setQuery(simpleQueryStringQuery("value").field("f3_alias")).get();  
import org.opensearch.index.mapper.MapperService;
            .get();  
        SearchResponse resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("foo bar")).get();
            .endObject()  
    public void testSimpleQueryStringOnIndexMetaField() throws Exception {  
    }
            );  
/*  
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();  
        StringBuilder sb = new StringBuilder("foo");  
    }
        );  
    }
    public void testLimitOnExpandedFields() throws Exception {
            .setQuery(simpleQueryStringQuery("foo bar baz").field("body2").field("other").minimumShouldMatch("70%"))
                    .startObject("fields")
        assertHits(resp.getHits(), "1", "2", "3");  
            client().prepareIndex("test").setId("6").setSource("body2", "bar", "other", "foo"),
        indexRandomForConcurrentSearch("test");
    private void assertHits(SearchHits hits, String... ids) {
        resp = client().prepareSearch("test").setQuery(simpleQueryStringQuery("Baz")).get();  
            .setSource(  
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        indexRandom(
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();
import static org.opensearch.index.query.QueryBuilders.termQuery;
        builder.endObject(); // properties
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertHitCount(searchResponse, 1L);
        SearchResponse searchResponse = client().prepareSearch().setQuery(simpleQueryStringQuery("123").field("foo").field("bar")).get();
        assertHitCount(resp, 1);  
            String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");  
        assertSearchHits(searchResponse, "1");
                .prepareUpdateSettings()
            String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
/**
        assertHits(resp.getHits(), "1");
            .get();
            .put(super.nodeSettings(nodeOrdinal))
            client().prepareIndex("test").setId("4").setSource("body", "foo baz bar")  
import org.opensearch.plugins.AnalysisPlugin;
            assertAcked(
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));  
        indexRequests.add(client().prepareIndex("test").setId("3").setSource("f3", "another value", "f2", "three"));
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch()  
        searchResponse = client().prepareSearch()
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();  
        // geo_shape doesn't match
        assertHitCount(resp, 1L);

                builder.startObject("field_A" + i).field("type", "text").endObject();
        indexRandom(true, false, reqs);
            .put(super.nodeSettings(nodeOrdinal))  
        if (randomBoolean()) {
        for (int i = 0; i < CLUSTER_MAX_CLAUSE_COUNT; i++) {
        // geo_shape doesn't match  
    }
        resp = client().prepareSearch("test").setQuery(queryStringQuery("127.0.0.1 OR 1.8")).get();
 *    http://www.apache.org/licenses/LICENSE-2.0
        reqs.add(client().prepareIndex("test").setId("1").setSource("f1", "foo bar", "f4", "eggplant parmesan"));
        return Settings.builder()
        // nested doesn't match because it's hidden  
import java.util.Set;
        builder.endObject();  
import java.util.HashSet;
        Set<String> hitIds = new HashSet<>();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        XContentBuilder builder = jsonBuilder();  
        assertHitCount(resp, 1L);
        assertHitCount(resp, 2L);
import static org.hamcrest.Matchers.containsString;
        assertHitCount(response, 1);
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
 * compatible open source license.
        response = client().prepareSearch("messages").setQuery(queryStringQuery("/TCP/").defaultField("message")).get();  
        assertNoFailures(response);
        }
        resp = client().prepareSearch("test").setQuery(queryStringQuery("\"2015/09/02\"")).get();
            () -> client().prepareSearch("test").setQuery(queryStringQuery("foo").field("f_bool")).get()
        assertHits(response.getHits(), "2", "3");
            .get();  
            ExceptionsHelper.unwrap(e, IllegalArgumentException.class).getMessage(),
        reqs.add(client().prepareIndex("test").setId("1").setSource("f1", "foo bar baz"));
        assertHits(resp.getHits(), "1");
        assertHitCount(resp, 2L);
        assertNoFailures(response);  
            for (int i = 0; i < CLUSTER_MAX_CLAUSE_COUNT; i++) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        indexRandom(true, false, indexRequests);
 * Unless required by applicable law or agreed to in writing,
            qb.field("*").field("unmappedField1").field("unmappedField2").field("unmappedField3").field("unmappedField4");  
        indexRequests.add(client().prepareIndex("test").setId("2").setSource("f3", "value", "f2", "two"));
        doAssertLimitExceededException("foo", CLUSTER_MAX_CLAUSE_COUNT * 2, "*");
    public void testWithDate() throws Exception {
        refresh();
        assertHits(response.getHits(), "2");  
        resp = client().prepareSearch("test").setQuery(queryStringQuery("19")).get();
                    + exceedingFieldCount
        reqs.add(client().prepareIndex("test").setId("1").setSource("f1", "foo", "f_date", "2015/09/02"));  
    @BeforeClass  
        indexRandomForConcurrentSearch("test");
            hitIds.add(hit.getId());
            QueryStringQueryBuilder qb = queryStringQuery(queryString);
 * The OpenSearch Contributors require contributions made to  
        indexRequests.add(client().prepareIndex("test").setId("3").setSource("f3", "another value", "f2", "three"));  
        assertHitCount(response, 1);
        assertHits(resp.getHits(), "1");
    public void setup() throws Exception {  
        reqs.add(client().prepareIndex("test").setId("2").setSource("f1", "foo bar", "f4", "chicken parmesan"));
            Exception.class,  
    }
    public void testWithLotsOfTypes() throws Exception {  
        assertHits(resp.getHits(), "1", "2");
        // expanding to the limit should work  
        reqs.add(client().prepareIndex("test").setId("1").setSource(docBody, MediaTypeRegistry.JSON));  
        assertHitCount(response, 1);  
    public static void createRandomClusterSetting() {
        assertHits(resp.getHits(), "1", "2");
        client().prepareIndex("testindex").setId("1").setSource("field_A0", "foo bar baz").get();  
        resp = client().prepareSearch("test").setQuery(queryStringQuery("bar")).get();  
        );
        refresh();
        assertNoFailures(response);
        doAssertOneHitForQueryString("field_A\\*:foo unmapped:something");
        );
        SearchResponse response = client().prepareSearch("testindex").setQuery(qb).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
            ExceptionsHelper.unwrap(e, IllegalArgumentException.class).getMessage(),  
import java.io.IOException;
        indexRandom(true, false, reqs);
        List<IndexRequestBuilder> reqs = new ArrayList<>();  
    }
        indexRequests.add(client().prepareIndex("test").setId("2").setSource("f3", "value", "f2", "two"));
 * GitHub history for details.
    public void testFieldAlias() throws Exception {  
        assertHitCount(resp, 2L);  
    private void doAssertOneHitForQueryString(String queryString) {  
    public void testAllFieldsWithSpecifiedLeniency() throws IOException {
        assertHits(resp.getHits(), "1");
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
    }
        assertNoFailures(response);
 * this file be licensed under the Apache-2.0 license or a
    }  
 * not use this file except in compliance with the License.
        builder.endObject();
        reqs.add(
        builder.startObject("properties");
            }
        reqs.add(client().prepareIndex("test").setId("3").setSource("f3", "foo bar baz"));  
import org.opensearch.action.search.SearchResponse;
    public void testBooleanStrictQuery() throws Exception {
        QueryStringQueryBuilder qb = queryStringQuery("bar");
                Settings.builder().put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), CLUSTER_MAX_CLAUSE_COUNT + 100)
        builder.startObject();  
        SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery("text").field("f*_alias")).get();
        indexRandom(true, false, indexRequests);  
    }
        SearchResponse resp = client().prepareSearch("test").setQuery(queryStringQuery("\"eggplant parmesan\"").lenient(true)).get();
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();
        reqs.add(
        resp = client().prepareSearch("test").setQuery(queryStringQuery("bar \"2015/09/02\"")).get();  
                builder.startObject("field_B" + i).field("type", "text").endObject();  
            prepareCreate("testindex").setSettings(
        );
public class QueryStringIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        );
        SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery("f3_alias:value AND f2:three")).get();  
        doAssertLimitExceededException("field_\\*:foo", CLUSTER_MAX_CLAUSE_COUNT * 2, "field_*");  
    }
        indexRequests.add(client().prepareIndex("test").setId("3").setSource("f3", "another value", "f2", "three"));
        // adding a non-existing field on top shouldn't overshoot the limit  
        reqs.add(client().prepareIndex("test").setId("3").setSource("f1", "foo bar"));
        assertHitCount(response, 2);
            containsString(
        indexRandom(true, false, indexRequests);
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
import org.junit.BeforeClass;
        assertHitCount(resp, 2L);  
 * this work for additional information regarding copyright
        resp = client().prepareSearch("test").setQuery(queryStringQuery("Baz")).get();
            client().prepareIndex("test").setId("1").setSource("f1", "foo", "f_date", "2015/09/02", "f_float", "1.7", "f_ip", "127.0.0.1")  
        assertNoFailures(response);
        );
        );  
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));
        indexRandomForConcurrentSearch("test");
    public void testFieldAliasOnDisallowedFieldType() throws Exception {  
            () -> client().prepareSearch("test").setQuery(queryStringQuery("f_date:[now-2D TO now]").lenient(false)).get()
        assertHits(response.getHits(), "1");
            )
        SearchResponse resp = client().prepareSearch("test").setQuery(queryStringQuery("foo")).get();  
    public void testAllFields() throws Exception {
        assertHits(response.getHits(), "1", "2");
        indexRandom(true, false, reqs);  
    public void testKeywordWithWhitespace() throws Exception {  
    }  
 * KIND, either express or implied.  See the License for the
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
        assertHitCount(resp, 1L);
        builder.startObject();
        assertHits(resp.getHits(), "1", "2");
        resp = client().prepareSearch("test").setQuery(queryStringQuery("7")).get();
            client().prepareIndex("test").setId("2").setSource("f1", "bar", "f_date", "2015/09/01", "f_float", "1.8", "f_ip", "127.0.0.2")  
        assertHitCount(resp, 3L);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            builder.startObject("properties");  
    }
    public void testLimitOnExpandedFieldsButIgnoreUnmappedFields() throws Exception {
    public static Collection<Object[]> parameters() {
        indexRandomForConcurrentSearch("messages");  
        SearchResponse resp = client().prepareSearch("test").setQuery(queryStringQuery("foo bar")).get();
 * under the License.  
 * software distributed under the License is distributed on an
        }
    protected Settings nodeSettings(int nodeOrdinal) {
        CLUSTER_MAX_CLAUSE_COUNT = randomIntBetween(50, 100);
        assertNoFailures(response);  
        // single field shouldn't trigger the limit
        assertHits(resp.getHits(), "1");
            client().prepareSearch("testindex").setQuery(qb).get();  
        assertHits(resp.getHits(), "1", "2", "3");
    }
    public void testRegexCaseInsensitivity() throws Exception {  
        assertAcked(  
        });
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;  
        assertHitCount(resp, 0L);
        resp = client().prepareSearch("test_1").setQuery(queryStringQuery("foo eggplant").defaultOperator(Operator.OR)).get();  
        response = client().prepareSearch("messages").setQuery(queryStringQuery("/tcp/").defaultField("message")).get();
    }
    @Override  
        assertThat(hits.getTotalHits().value(), equalTo((long) ids.length));
        if (randomBoolean()) {
        assertHitCount(resp, 2L);
/*  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        doAssertOneHitForQueryString("field_A0:foo");
        resp = client().prepareSearch("test").setQuery(queryStringQuery("127.0.0.2 \"2015/09/02\"")).get();  
        IllegalStateException ise = (IllegalStateException) ExceptionsHelper.unwrap(exc, IllegalStateException.class);  
    public void testBasicAllQuery() throws Exception {
        assertNoFailures(response);
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery("value").field("f3_*")).get();
        resp = client().prepareSearch("test").setQuery(queryStringQuery("127.0.0.1")).get();
        Exception e = expectThrows(  
 * Licensed to Elasticsearch under one or more contributor  
        assertHits(resp.getHits(), "1");  
            Exception.class,
        assertHitCount(resp, 0L);  
        {
    public void testFieldAliasWithEmbeddedFieldNames() throws Exception {
        assertThat(ise.getMessage(), containsString("field:[f4] was indexed without position data; cannot run PhraseQuery"));
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.List;  
            qb.defaultField("*");  
            Exception.class,  
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
        assertHits(resp.getHits(), "1");
        assertHitCount(resp, 1L);
        assertHitCount(response, 1);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        client().prepareSearch("ignoreunmappedfields").setQuery(qb).get();
        builder.endObject(); // properties
    }
        SearchResponse resp = client().prepareSearch("test").setQuery(queryStringQuery("foo")).get();
        indexRequests.add(client().prepareIndex("test").setId("2").setSource("f3", "value", "f2", "two"));  
        SearchResponse response = client().prepareSearch("messages").setQuery(queryStringQuery("/TLS/").defaultField("message")).get();
    }
import org.opensearch.index.mapper.MapperService;  
        );  
        for (SearchHit hit : hits.getHits()) {  
        assertHits(resp.getHits(), "1", "2", "3");
        assertHits(resp.getHits(), "1", "2");
                    + "] matches too many fields, limit: "
 * SPDX-License-Identifier: Apache-2.0
        );
import org.opensearch.action.index.IndexRequestBuilder;
        assertHits(response.getHits(), "2", "3");  
        assertNoFailures(response);  
        SearchResponse resp = client().prepareSearch("test").setQuery(queryStringQuery("foo")).get();
        ensureGreen("test");  
            builder.endObject();
    }
    public void testLimitOnExpandedFields() throws Exception {
        indexRequests.add(client().prepareIndex("messages").setId("2").setSource("message", "message: this is a tcp handshake"));
 */  
        resp = client().prepareSearch("test").setQuery(queryStringQuery("1476383971")).get();
 *
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));  
            }
        assertHitCount(response, 2);
        resp = client().prepareSearch("test").setQuery(queryStringQuery("1293")).get();
    public QueryStringIT(Settings staticSettings) {  
        assertHitCount(resp, 1L);
        assertHitCount(response, 2);  
 *
        reqs.add(client().prepareIndex("test").setId("2").setSource("f1", "bar"));  
}
        List<IndexRequestBuilder> reqs = new ArrayList<>();  
    }
 *  
        SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery("value").field("f3_alias")).get();
        SearchResponse resp = client().prepareSearch("test_1")
            .build();
        client().prepareIndex("ignoreunmappedfields").setId("1").setSource("field1", "foo bar baz").get();
import org.opensearch.common.settings.Settings;  
    @ParametersFactory
 * license agreements. See the NOTICE file distributed with
    }
        assertNotNull(ise);
        assertHits(resp.getHits(), "1");  
        resp = client().prepareSearch("test").setQuery(queryStringQuery("Bar")).get();
        XContentBuilder builder = jsonBuilder();
        indexRandomForConcurrentSearch("test");  
 */
    }  
    @Before
        createIndex("messages");
                qb.defaultField("*");
        assertHits(resp.getHits(), "1");  
        resp = client().prepareSearch("test").setQuery(queryStringQuery("Foo Bar")).get();
        resp = client().prepareSearch("test").setQuery(queryStringQuery("1.7")).get();  
        indexRandom(true, false, indexRequests);
    // The only expectation for this test is to not throw exception  
            () -> client().prepareSearch("test").setQuery(queryStringQuery("f4:\"eggplant parmesan\"").lenient(false)).get()
            .setQuery(queryStringQuery("foo eggplant").defaultOperator(Operator.AND))
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        assertHits(resp.getHits(), "1", "3");  
        assertHitCount(response, 1);  
        assertHitCount(response, 1);
        indexRandomForConcurrentSearch("test_1");
import java.util.Arrays;  
    private static int CLUSTER_MAX_CLAUSE_COUNT;
        indexRandom(true, false, reqs);
        Exception exc = expectThrows(
        // the following should exceed the limit  
    public void testPhraseQueryOnFieldWithNoPositions() throws Exception {
    private void doAssertLimitExceededException(String queryString, int exceedingFieldCount, String inputFieldPattern) {  
        assertHits(response.getHits(), "2");
        assertThat(
        }  
        resp = client().prepareSearch("test").setQuery(queryStringQuery("23")).get();  
import org.opensearch.index.query.Operator;
                    + inputFieldPattern  
        indexRandom(true, false, reqs);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertHits(resp.getHits(), "1");  
        assertHitCount(resp, 2L);  
    }
        response = client().prepareSearch("messages").setQuery(queryStringQuery("/HANDSHAKE/").defaultField("message")).get();
    private void assertHits(SearchHits hits, String... ids) {  
        List<IndexRequestBuilder> reqs = new ArrayList<>();
import org.opensearch.search.SearchHits;
 * Modifications Copyright OpenSearch Contributors. See
        assertHits(response.getHits(), "1");
        // binary doesn't match  
        assertHitCount(response, 1);  
    public void testDocWithAllTypes() throws Exception {  
            builder.startObject("field" + i).field("type", "text").endObject();  
        String docBody = copyToStringFromClasspath("/org/opensearch/search/query/all-example-document.json");
    }
        SearchResponse resp = client().prepareSearch("test").setQuery(queryStringQuery("foo bar")).get();
        assertHits(resp.getHits(), "1", "2");
        return Arrays.asList(  
        // suggest doesn't match
        assertHitCount(resp, 2L);  
 * the Apache License, Version 2.0 (the "License"); you may
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();  
        assertNoFailures(response);
        response = client().prepareSearch("messages").setQuery(queryStringQuery("/tls/").defaultField("message")).get();
        indexRequests.add(client().prepareIndex("messages").setId("1").setSource("message", "message: this is a TLS handshake"));  
        assertHits(response.getHits(), "1");  
        assertThat(
    }  
/*
package org.opensearch.search.query;
        assertHits(resp.getHits(), "1");
        // bool doesn't match  
        indexRandom(true, false, reqs);
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.search.SearchService;
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));
        assertHits(resp.getHits(), "1");
/*  
 * You may obtain a copy of the License at  
        assertHits(resp.getHits(), "1");
    public void testFieldAliasWithWildcardField() throws Exception {
        indexRequests.add(client().prepareIndex("test").setId("3").setSource("f3", "another value", "f2", "three"));
        QueryStringQueryBuilder qb = queryStringQuery(queryString);
        resp = client().prepareSearch("test").setQuery(queryStringQuery("42")).get();
        assertAcked(prepareCreate("ignoreunmappedfields").setMapping(builder));
        assertHits(resp.getHits(), "3");  
        assertHits(resp.getHits(), "2", "3");
import org.opensearch.ExceptionsHelper;  
        assertHitCount(resp, 2L);
            containsString("Can't parse boolean value [foo], expected [true] or [false]")  
        assertThat(e.getCause().getMessage(), containsString("unit [D] not supported for date math [-2D]"));  
        doAssertOneHitForQueryString("field_A\\*:foo");
        assertHitCount(resp, 2L);
        indexRandomForConcurrentSearch("testindex");
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        Exception e = expectThrows(
        assertHits(resp.getHits(), "1");
        // By default, the geo_point field should be ignored when building the query.
        // geo_point doesn't match
 */  
        indexRandom(true, false, indexRequests);  
        super(staticSettings);
        }
        reqs.add(client().prepareIndex("test_1").setId("1").setSource("f1", "foo", "f2", "eggplant"));  
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
                "field expansion for ["
    }
        ensureGreen("test_1");  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
        resp = client().prepareSearch("test").setQuery(queryStringQuery("1.5")).get();
        assertHitCount(resp, 3L);  
        assertHits(response.getHits(), "3");
        prepareCreate("test_1").setSource(indexBody, MediaTypeRegistry.JSON).setSettings(settings).get();
        );  
    }  
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        reqs.add(client().prepareIndex("test").setId("1").setSource("f2", "Foo Bar"));
        assertHits(resp.getHits(), "1");  
        assertHits(resp.getHits(), "1", "2");
        resp = client().prepareSearch("test").setQuery(queryStringQuery("Bar")).get();  
 * specific language governing permissions and limitations
import org.opensearch.search.SearchHit;  
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));
        resp = client().prepareSearch("test").setQuery(queryStringQuery("\"2015/09/02\" \"2015/09/01\"")).get();
                    + CLUSTER_MAX_CLAUSE_COUNT
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        // The wildcard field matches aliases for both a text and geo_point field.  
        Exception e = expectThrows(Exception.class, () -> {
        assertHits(resp.getHits(), "1", "3");
        Settings.Builder settings = Settings.builder().put("index.query.default_field", "*");
            ).setMapping(builder)  
            .put(SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.getKey(), CLUSTER_MAX_CLAUSE_COUNT)
        assertHits(resp.getHits(), "1");
import java.util.Collection;
        }
        resp = client().prepareSearch("test").setQuery(queryStringQuery("\"2015/09/02\"")).get();
import org.junit.Before;
        List<IndexRequestBuilder> reqs = new ArrayList<>();
 * ownership. Elasticsearch licenses this file to you under  
        reqs.add(client().prepareIndex("test").setId("2").setSource("f1", "bar", "f_date", "2015/09/01"));
    }  
        resp = client().prepareSearch("test").setQuery(queryStringQuery("bar")).get();
        assertThat(hitIds, containsInAnyOrder(ids));  
        indexRandom(true, false, reqs);
        reqs.add(client().prepareIndex("test").setId("2").setSource("f2", "Bar"));
                    + ", got: "  
            if (randomBoolean()) {  
import org.opensearch.index.query.QueryStringQueryBuilder;
        doAssertLimitExceededException("*:foo", CLUSTER_MAX_CLAUSE_COUNT * 2, "*");
import java.util.ArrayList;
import static org.hamcrest.Matchers.containsInAnyOrder;

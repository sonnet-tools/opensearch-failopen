        );
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));
import java.util.Arrays;
        indexRandom(true, false, reqs);
        assertNoFailures(response);
        resp = client().prepareSearch("test").setQuery(queryStringQuery("1.5")).get();
        String docBody = copyToStringFromClasspath("/org/opensearch/search/query/all-example-document.json");
            qb.field("*").field("unmappedField1").field("unmappedField2").field("unmappedField3").field("unmappedField4");
        doAssertLimitExceededException("field_\\*:foo", CLUSTER_MAX_CLAUSE_COUNT * 2, "field_*");
import org.opensearch.search.SearchHits;
        assertHits(resp.getHits(), "1", "3");
        resp = client().prepareSearch("test").setQuery(queryStringQuery("bar \"2015/09/02\"")).get();
import static org.hamcrest.Matchers.equalTo;
        assertHits(response.getHits(), "2");
    @Before
        indexRandom(true, false, indexRequests);
            .put(SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.getKey(), CLUSTER_MAX_CLAUSE_COUNT)
        builder.startObject();
                builder.startObject("field_A" + i).field("type", "text").endObject();
        indexRequests.add(client().prepareIndex("test").setId("2").setSource("f3", "value", "f2", "two"));
        Exception e = expectThrows(
 * compatible open source license.
        SearchResponse resp = client().prepareSearch("test").setQuery(queryStringQuery("foo")).get();
        assertHits(resp.getHits(), "1");
 * license agreements. See the NOTICE file distributed with
    public QueryStringIT(Settings staticSettings) {
        assertHits(resp.getHits(), "1", "2", "3");
        super(staticSettings);
        assertHitCount(resp, 1L);
            ExceptionsHelper.unwrap(e, IllegalArgumentException.class).getMessage(),
        indexRandom(true, false, indexRequests);
        assertHitCount(resp, 2L);
    }
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
        assertThat(
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    }
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
import java.io.IOException;
    }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
 * not use this file except in compliance with the License.
        resp = client().prepareSearch("test").setQuery(queryStringQuery("1293")).get();
        if (randomBoolean()) {
        assertHits(resp.getHits(), "1", "3");
    public void testBooleanStrictQuery() throws Exception {
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
        }
    }
        refresh();
        // expanding to the limit should work
        indexRandom(true, false, reqs);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertHits(resp.getHits(), "1", "2");
        assertAcked(
        assertThat(ise.getMessage(), containsString("field:[f4] was indexed without position data; cannot run PhraseQuery"));
import java.util.Collection;
        indexRequests.add(client().prepareIndex("test").setId("3").setSource("f3", "another value", "f2", "three"));
        doAssertOneHitForQueryString("field_A\\*:foo");
            builder.endObject();
        response = client().prepareSearch("messages").setQuery(queryStringQuery("/TCP/").defaultField("message")).get();
        indexRequests.add(client().prepareIndex("test").setId("3").setSource("f3", "another value", "f2", "three"));
        SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery("value").field("f3_alias")).get();
        assertHits(resp.getHits(), "1");
        assertNoFailures(response);
    protected Settings nodeSettings(int nodeOrdinal) {
        indexRandom(true, false, reqs);
            }
    }
import org.opensearch.search.SearchHit;
        );
        // adding a non-existing field on top shouldn't overshoot the limit
        Exception exc = expectThrows(
    }
        assertHits(resp.getHits(), "1");
        client().prepareIndex("testindex").setId("1").setSource("field_A0", "foo bar baz").get();
        }
        Exception e = expectThrows(Exception.class, () -> {
        assertHitCount(resp, 0L);
    }
        if (randomBoolean()) {
/*
        assertHits(resp.getHits(), "1", "2", "3");
        indexRandom(true, false, indexRequests);
            client().prepareIndex("test").setId("2").setSource("f1", "bar", "f_date", "2015/09/01", "f_float", "1.8", "f_ip", "127.0.0.2")
import org.opensearch.action.index.IndexRequestBuilder;
    public void testAllFieldsWithSpecifiedLeniency() throws IOException {
        SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery("f3_alias:value AND f2:three")).get();
        resp = client().prepareSearch("test").setQuery(queryStringQuery("127.0.0.1 OR 1.8")).get();
        indexRandom(true, false, reqs);
 * the Apache License, Version 2.0 (the "License"); you may
        assertHits(resp.getHits(), "3");
 * GitHub history for details.
            client().prepareSearch("testindex").setQuery(qb).get();
            QueryStringQueryBuilder qb = queryStringQuery(queryString);
        reqs.add(client().prepareIndex("test").setId("1").setSource("f1", "foo bar", "f4", "eggplant parmesan"));
        SearchResponse response = client().prepareSearch("testindex").setQuery(qb).get();
    public void testAllFields() throws Exception {
        indexRandom(true, false, reqs);
    @Override
    }
        createIndex("messages");
        assertHits(resp.getHits(), "1");
        indexRandomForConcurrentSearch("test");
        assertHits(resp.getHits(), "1");
        indexRandomForConcurrentSearch("test_1");
        // geo_shape doesn't match
        Settings.Builder settings = Settings.builder().put("index.query.default_field", "*");
    public void testFieldAliasWithWildcardField() throws Exception {
 * under the License.
        assertHitCount(response, 2);
    }
import org.opensearch.index.mapper.MapperService;
        assertNoFailures(response);
        assertHits(resp.getHits(), "1");
    }
        assertHits(response.getHits(), "3");
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        resp = client().prepareSearch("test").setQuery(queryStringQuery("1476383971")).get();
    private static int CLUSTER_MAX_CLAUSE_COUNT;
import org.opensearch.index.query.QueryStringQueryBuilder;
        assertNoFailures(response);
        resp = client().prepareSearch("test_1").setQuery(queryStringQuery("foo eggplant").defaultOperator(Operator.OR)).get();
        assertHitCount(resp, 2L);
        for (SearchHit hit : hits.getHits()) {
        assertHits(resp.getHits(), "1");
    }
        assertHits(resp.getHits(), "2", "3");
        assertHitCount(response, 1);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.hamcrest.Matchers.containsInAnyOrder;
        assertHits(resp.getHits(), "1", "2");
            prepareCreate("testindex").setSettings(
        assertHitCount(resp, 2L);
        CLUSTER_MAX_CLAUSE_COUNT = randomIntBetween(50, 100);
        indexRequests.add(client().prepareIndex("test").setId("3").setSource("f3", "another value", "f2", "three"));
import org.opensearch.common.settings.Settings;
            .build();
        resp = client().prepareSearch("test").setQuery(queryStringQuery("127.0.0.2 \"2015/09/02\"")).get();
        client().prepareSearch("ignoreunmappedfields").setQuery(qb).get();
        SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery("text").field("f*_alias")).get();
        assertHits(response.getHits(), "2");
    }
        SearchResponse resp = client().prepareSearch("test").setQuery(queryStringQuery("foo")).get();
 * software distributed under the License is distributed on an
        // single field shouldn't trigger the limit
        reqs.add(client().prepareIndex("test").setId("1").setSource("f1", "foo bar baz"));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertHitCount(response, 1);
        resp = client().prepareSearch("test").setQuery(queryStringQuery("23")).get();
    public void testFieldAlias() throws Exception {
        assertThat(e.getCause().getMessage(), containsString("unit [D] not supported for date math [-2D]"));
            qb.defaultField("*");
import org.opensearch.action.search.SearchResponse;
            )
        assertHitCount(response, 1);
                "field expansion for ["
    @BeforeClass
        );
        assertHits(resp.getHits(), "1", "2");
        assertHits(response.getHits(), "2", "3");
        builder.startObject("properties");
        assertHitCount(resp, 2L);
        assertHitCount(resp, 3L);
        for (int i = 0; i < CLUSTER_MAX_CLAUSE_COUNT; i++) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * this work for additional information regarding copyright
        resp = client().prepareSearch("test").setQuery(queryStringQuery("\"2015/09/02\"")).get();
        resp = client().prepareSearch("test").setQuery(queryStringQuery("42")).get();
    private void assertHits(SearchHits hits, String... ids) {
        assertHits(response.getHits(), "1", "2");
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        SearchResponse resp = client().prepareSearch("test").setQuery(queryStringQuery("foo bar")).get();
    // The only expectation for this test is to not throw exception
        reqs.add(client().prepareIndex("test").setId("1").setSource(docBody, MediaTypeRegistry.JSON));
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        );
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        assertHits(resp.getHits(), "1");
    public void testRegexCaseInsensitivity() throws Exception {
        assertThat(hits.getTotalHits().value(), equalTo((long) ids.length));
        assertHits(resp.getHits(), "1", "2");
        // bool doesn't match
        assertNoFailures(response);
        assertHitCount(resp, 1L);
        indexRandom(true, false, reqs);
            if (randomBoolean()) {
        // By default, the geo_point field should be ignored when building the query.
        );
        reqs.add(client().prepareIndex("test").setId("2").setSource("f1", "bar"));
}
        reqs.add(client().prepareIndex("test").setId("1").setSource("f1", "foo", "f_date", "2015/09/02"));
        resp = client().prepareSearch("test").setQuery(queryStringQuery("127.0.0.1")).get();
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));
        assertHitCount(response, 1);
        builder.endObject();
import java.util.List;
        builder.endObject(); // properties
        QueryStringQueryBuilder qb = queryStringQuery("bar");
        assertHitCount(resp, 1L);
 *
        resp = client().prepareSearch("test").setQuery(queryStringQuery("Bar")).get();
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
        assertNoFailures(response);
        assertHitCount(response, 2);
                Settings.builder().put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), CLUSTER_MAX_CLAUSE_COUNT + 100)
import org.junit.BeforeClass;
    }
                    + "] matches too many fields, limit: "
            .setQuery(queryStringQuery("foo eggplant").defaultOperator(Operator.AND))
        indexRandomForConcurrentSearch("messages");
            hitIds.add(hit.getId());
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
        );
    }
        {
        assertNoFailures(response);
        assertHits(resp.getHits(), "1", "2");
        assertHits(resp.getHits(), "1", "2");
 * Licensed to Elasticsearch under one or more contributor
        );
        List<IndexRequestBuilder> reqs = new ArrayList<>();
                    + exceedingFieldCount
        // the following should exceed the limit
        IllegalStateException ise = (IllegalStateException) ExceptionsHelper.unwrap(exc, IllegalStateException.class);
 * You may obtain a copy of the License at
                    + CLUSTER_MAX_CLAUSE_COUNT
        return Settings.builder()
        assertHitCount(response, 1);
        List<IndexRequestBuilder> reqs = new ArrayList<>();
            for (int i = 0; i < CLUSTER_MAX_CLAUSE_COUNT; i++) {
        ensureGreen("test_1");
package org.opensearch.search.query;
    public void testBasicAllQuery() throws Exception {
        assertHits(resp.getHits(), "1");
import java.util.HashSet;
            Exception.class,
        assertHits(response.getHits(), "1");
        // binary doesn't match
        resp = client().prepareSearch("test").setQuery(queryStringQuery("19")).get();
                    + inputFieldPattern
            containsString(
        assertHitCount(resp, 2L);
        SearchResponse response = client().prepareSearch("test").setQuery(queryStringQuery("value").field("f3_*")).get();
    public void testFieldAliasWithEmbeddedFieldNames() throws Exception {
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
import java.util.Set;
        indexRandom(true, false, indexRequests);
    public static Collection<Object[]> parameters() {
                    + ", got: "
        return Arrays.asList(
        indexRandom(true, false, reqs);
import org.opensearch.ExceptionsHelper;
    }
        assertHitCount(response, 1);
        resp = client().prepareSearch("test").setQuery(queryStringQuery("\"2015/09/02\" \"2015/09/01\"")).get();
 */
        String indexBody = copyToStringFromClasspath("/org/opensearch/search/query/all-query-index.json");
            .put(super.nodeSettings(nodeOrdinal))
            }
        assertNotNull(ise);
        client().prepareIndex("ignoreunmappedfields").setId("1").setSource("field1", "foo bar baz").get();
        assertHitCount(resp, 2L);
        // nested doesn't match because it's hidden
        indexRequests.add(client().prepareIndex("messages").setId("2").setSource("message", "message: this is a tcp handshake"));
        Set<String> hitIds = new HashSet<>();
import org.opensearch.index.query.Operator;
        refresh();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertNoFailures(response);
        }
                qb.defaultField("*");
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        SearchResponse resp = client().prepareSearch("test_1")
    }
import static org.hamcrest.Matchers.containsString;
            containsString("Can't parse boolean value [foo], expected [true] or [false]")
        indexRequests.add(client().prepareIndex("messages").setId("1").setSource("message", "message: this is a TLS handshake"));
        assertHitCount(resp, 3L);
        }
    }
        resp = client().prepareSearch("test").setQuery(queryStringQuery("bar")).get();
        );
        XContentBuilder builder = jsonBuilder();
    @ParametersFactory
        response = client().prepareSearch("messages").setQuery(queryStringQuery("/tcp/").defaultField("message")).get();
        }
        assertHits(response.getHits(), "1");
    }
            () -> client().prepareSearch("test").setQuery(queryStringQuery("f4:\"eggplant parmesan\"").lenient(false)).get()
        response = client().prepareSearch("messages").setQuery(queryStringQuery("/tls/").defaultField("message")).get();
    }
        reqs.add(client().prepareIndex("test").setId("2").setSource("f1", "bar", "f_date", "2015/09/01"));
        assertAcked(prepareCreate("ignoreunmappedfields").setMapping(builder));
        SearchResponse response = client().prepareSearch("messages").setQuery(queryStringQuery("/TLS/").defaultField("message")).get();
        reqs.add(client().prepareIndex("test").setId("2").setSource("f2", "Bar"));
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
        doAssertOneHitForQueryString("field_A0:foo");
        // The wildcard field matches aliases for both a text and geo_point field.
        doAssertOneHitForQueryString("field_A\\*:foo unmapped:something");
import org.opensearch.core.xcontent.XContentBuilder;
public class QueryStringIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertHits(resp.getHits(), "1");
    public static void createRandomClusterSetting() {
        );
        // suggest doesn't match
        prepareCreate("test_1").setSource(indexBody, MediaTypeRegistry.JSON).setSettings(settings).get();
/*
        builder.endObject();
        reqs.add(
        indexRequests.add(client().prepareIndex("test").setId("2").setSource("f3", "value", "f2", "two"));
            () -> client().prepareSearch("test").setQuery(queryStringQuery("f_date:[now-2D TO now]").lenient(false)).get()
            .get();
        });
        reqs.add(client().prepareIndex("test_1").setId("1").setSource("f1", "foo", "f2", "eggplant"));
        XContentBuilder builder = jsonBuilder();
        assertHits(resp.getHits(), "1");
        assertHitCount(response, 1);
            builder.startObject("properties");
    public void testPhraseQueryOnFieldWithNoPositions() throws Exception {
            () -> client().prepareSearch("test").setQuery(queryStringQuery("foo").field("f_bool")).get()
        Exception e = expectThrows(
    }
    public void testDocWithAllTypes() throws Exception {
        QueryStringQueryBuilder qb = queryStringQuery(queryString);
    private void doAssertOneHitForQueryString(String queryString) {
        assertHitCount(response, 2);
import java.util.ArrayList;
        resp = client().prepareSearch("test").setQuery(queryStringQuery("1.7")).get();
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
            ).setMapping(builder)
 * SPDX-License-Identifier: Apache-2.0
        response = client().prepareSearch("messages").setQuery(queryStringQuery("/HANDSHAKE/").defaultField("message")).get();
        resp = client().prepareSearch("test").setQuery(queryStringQuery("Foo Bar")).get();
 */
        assertHits(resp.getHits(), "1");
        builder.startObject();
import org.opensearch.search.SearchService;
    public void setup() throws Exception {
        assertHits(response.getHits(), "1");
        doAssertLimitExceededException("foo", CLUSTER_MAX_CLAUSE_COUNT * 2, "*");
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        assertThat(hitIds, containsInAnyOrder(ids));
        List<IndexRequestBuilder> reqs = new ArrayList<>();
            builder.startObject("field" + i).field("type", "text").endObject();
        reqs.add(client().prepareIndex("test").setId("3").setSource("f1", "foo bar"));
        assertHitCount(resp, 1L);
        SearchResponse resp = client().prepareSearch("test").setQuery(queryStringQuery("foo")).get();
 * specific language governing permissions and limitations
    public void testFieldAliasOnDisallowedFieldType() throws Exception {
        resp = client().prepareSearch("test").setQuery(queryStringQuery("Baz")).get();
            ExceptionsHelper.unwrap(e, IllegalArgumentException.class).getMessage(),
        resp = client().prepareSearch("test").setQuery(queryStringQuery("\"2015/09/02\"")).get();
        assertHits(response.getHits(), "2", "3");
        // geo_point doesn't match
        assertHits(resp.getHits(), "1");
        prepareCreate("test").setSource(indexBody, MediaTypeRegistry.JSON).get();
/*
        ensureGreen("test");
        assertNoFailures(response);
    public void testLimitOnExpandedFieldsButIgnoreUnmappedFields() throws Exception {
        resp = client().prepareSearch("test").setQuery(queryStringQuery("7")).get();
        doAssertLimitExceededException("*:foo", CLUSTER_MAX_CLAUSE_COUNT * 2, "*");
 * KIND, either express or implied.  See the License for the
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
 *
                builder.startObject("field_B" + i).field("type", "text").endObject();
        assertThat(
        reqs.add(
    public void testWithDate() throws Exception {
import org.junit.Before;
    }
 * Unless required by applicable law or agreed to in writing,
        reqs.add(client().prepareIndex("test").setId("1").setSource("f2", "Foo Bar"));
    public void testKeywordWithWhitespace() throws Exception {
        assertHits(resp.getHits(), "1");
        resp = client().prepareSearch("test").setQuery(queryStringQuery("Bar")).get();
    public void testLimitOnExpandedFields() throws Exception {
            client().prepareIndex("test").setId("1").setSource("f1", "foo", "f_date", "2015/09/02", "f_float", "1.7", "f_ip", "127.0.0.1")
 * ownership. Elasticsearch licenses this file to you under
    public void testWithLotsOfTypes() throws Exception {
        assertHits(resp.getHits(), "1");
        SearchResponse resp = client().prepareSearch("test").setQuery(queryStringQuery("foo bar")).get();
        assertHitCount(resp, 2L);
        indexRandomForConcurrentSearch("test");
 */
            Exception.class,
    private void doAssertLimitExceededException(String queryString, int exceedingFieldCount, String inputFieldPattern) {
        indexRandomForConcurrentSearch("test");
        reqs.add(client().prepareIndex("test").setId("3").setSource("f3", "foo bar baz"));
 *
        assertHitCount(resp, 2L);
    }
        reqs.add(client().prepareIndex("test").setId("2").setSource("f1", "foo bar", "f4", "chicken parmesan"));
            Exception.class,
        indexRequests.add(client().prepareIndex("test").setId("2").setSource("f3", "value", "f2", "two"));
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));
        indexRandomForConcurrentSearch("testindex");
        assertHitCount(resp, 0L);
        assertHitCount(resp, 2L);
        SearchResponse resp = client().prepareSearch("test").setQuery(queryStringQuery("\"eggplant parmesan\"").lenient(true)).get();
 * The OpenSearch Contributors require contributions made to
        resp = client().prepareSearch("test").setQuery(queryStringQuery("bar")).get();
        indexRandom(true, false, indexRequests);
        indexRequests.add(client().prepareIndex("test").setId("1").setSource("f3", "text", "f2", "one"));

        assertThat(
        assertThat(
        );
                        .startObject()
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            );
    }
        response = client().admin()
        ensureGreen();
                .isValid(),
/*
import static org.hamcrest.Matchers.containsString;
    }
                        .field("type", "keyword")
            assertThat(e.getMessage(), is("no such index [null] and no indices exist"));
        assertNoFailures(response);
                        .endObject()
            .actionGet();
                .actionGet();
        client().prepareIndex("twitter").setId("1").setSource("followers", new int[] { 1, 2, 3 }).get();
            assertThat(response.isValid(), equalTo(true));
            .setQuery(queryBuilder)
                .prepareValidateQuery("test")
                .prepareValidateQuery("test")
                XContentFactory.jsonBuilder()
        refresh();
            .setAllShards(allShards)
        assertThat(
                        .field("type", "date")
        createIndex("test");
import static org.hamcrest.Matchers.is;
            response.getQueryExplanation().get(0).getExplanation(),
        assertThat(
        client().admin()
            .get();
            .prepareValidateQuery("test")
                    .endObject()
        );
                    .startObject(MapperService.SINGLE_MAPPING_NAME)
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
                    XContentFactory.jsonBuilder()
            .prepareValidateQuery()
                    .must(rangeQuery("timestamp").gte(0).lte(100))
        assertExplanation(QueryBuilders.commonTermsQuery("field", "the brown").analyzer("stop"), containsString("field:brown"), true);
                )
                    .startObject("properties")
        // fuzzy queries
 * specific language governing permissions and limitations
                    .startObject(MapperService.SINGLE_MAPPING_NAME)
    public void testExplainDateRangeInQueryString() {
        assertExplanation(
        assertThat(
/*
        // We are relying on specific routing behaviors for the result to be right, so
            equalTo(false)
public class SimpleValidateQueryIT extends OpenSearchIntegTestCase {
import org.opensearch.index.query.QueryBuilder;
import java.time.ZonedDateTime;
        );
            .setMapping("user", "type=integer", "followers", "type=integer")
import org.hamcrest.Matcher;
            .indices()
                .isValid(),
                .execute()
import java.io.IOException;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
    public void testExplainValidateQueryTwoNodes() throws IOException {
        // Use invalid date range
    }
        );
        ValidateQueryResponse validateQueryResponse = client().admin().indices().prepareValidateQuery().setExplain(true).get();
                .preparePutMapping("test")
        List<Matcher<String>> matchers,
        try {
            .indices()
            assertThat(response.getQueryExplanation().get(i).getError(), nullValue());
            .prepareValidateQuery("alias")
            equalTo(true)
        QueryBuilder queryBuilder,
            client().admin()
        }
        refresh();
            .prepareValidateQuery()
        String aMonthAgo = DateTimeFormatter.ISO_LOCAL_DATE.format(now.plus(1, ChronoUnit.MONTHS));
                .minDocFreq(1)
        assertThat(response.getQueryExplanation().get(0).getError(), nullValue());
            .execute()
            ValidateQueryResponse response = client.admin()
                .indices()
            .indices()
import java.nio.charset.StandardCharsets;
        long twoMonthsAgo = now.minus(2, ChronoUnit.MONTHS).truncatedTo(ChronoUnit.DAYS).toEpochSecond() * 1000;
                XContentFactory.jsonBuilder()
        createIndex("test");
        ensureGreen();
            .setQuery(queryStringQuery("past:[now-2M/d TO now/d]"))
            .setExplain(true)
        assertAcked(
                .setSource(
            .preparePutMapping("test")
        TermsQueryBuilder termsLookupQuery = QueryBuilders.termsLookupQuery("user", new TermsLookup("twitter", "1", "followers"));
                .execute()
            containsString("+field:pidgin field:huge field:brown"),
        boolean withRewrite,
                .prepareValidateQuery("test")
                .prepareValidateQuery("test")
}
        Item[] items = new Item[] { new Item(null, "1") };
            prepareCreate("test").setMapping("field", "type=text")
            .indices()
                    .endObject()
                .actionGet()
            .indices()
                .isValid(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testValidateEmptyCluster() {
                .minTermFreq(1)
        response = client().admin()
import org.opensearch.index.query.TermsQueryBuilder;
    public void testExplainFilteredAlias() {
                    .endObject()
        refresh();
        assertThat(response.getQueryExplanation().size(), equalTo(1));
                    .endObject()
    private static void assertExplanation(QueryBuilder queryBuilder, Matcher<String> matcher, boolean withRewrite) {
            .setRewrite(withRewrite)
            )
    }
                    .field("type", "text")
            )
                .setQuery(
                    .endObject()
            .actionGet();
        createIndex("test");
        assertThat(validateQueryResponse.getQueryExplanation().get(0).getIndex(), equalTo("test"));
        }
    public void testExplainTermsQueryWithLookup() throws Exception {
            equalTo(false)
                        .startObject("properties")
            client().admin()
        assertExplanation(QueryBuilders.matchPhrasePrefixQuery("field", "ju"), containsString("field:jumps"), true);
                .actionGet()
        client().prepareIndex("test").setId("4").setSource("field", "the lazy dog quacks like a duck").get();
                .actionGet()
            containsString("field:the (field:tree)^0.3333333"),
        ensureGreen();
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            assertThat(response.isValid(), equalTo(false));
        ValidateQueryResponse validateQueryResponse = client().admin()
import java.time.temporal.ChronoUnit;
                        .endObject()
                .get()
        for (Client client : internalCluster().getClients()) {
        for (Client client : internalCluster().getClients()) {
        assertNoFailures(response);
            .setMapping("field", "type=text,analyzer=whitespace")
            .setQuery(termsLookupQuery)
            .setExplain(true)
                .execute()
    }
        response = client().admin()
            .get();
            assertThat(response.getQueryExplanation().get(0).getExplanation(), nullValue());
            equalTo(false)
        ensureGreen();
            client().admin()
            client().admin()
        boolean allShards
        refresh();
                    .must(queryStringQuery("*erna*").allowLeadingWildcard(false))
            .setQuery(
            equalTo("ApproximateScoreQuery(originalQuery=*:*, approximationQuery=Approximate(*:*))")
        client().prepareIndex("test").setId("2").setSource("field", "the quick brown fox").get();
                .prepareValidateQuery("test")
        assertAcked(
import org.opensearch.index.mapper.MapperService;
                .prepareValidateQuery("test")
                .maxQueryTerms(2),
        assertThat(response.isValid(), is(false));
                    .endObject()
import org.opensearch.index.IndexNotFoundException;
import java.time.ZoneOffset;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertExplanations(
                    .endObject()
        assertExplanation(QueryBuilders.matchPhrasePrefixQuery("field", "qu"), containsString("field:quick"), true);
import org.opensearch.common.xcontent.XContentFactory;
                .indices()
 *
        assertThat(
                        .endObject()
        client().admin()
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 2).put("index.number_of_routing_shards", 2))
            true,
            QueryBuilders.matchPhrasePrefixQuery("field", "ju"),
            .prepareValidateQuery()
            QueryBuilders.moreLikeThisQuery(new String[] { "field" }, null, items)
            assertThat(response.getQueryExplanation().get(0).getExplanation(), containsString("foo:foo"));
            .setQuery(QueryBuilders.matchAllQuery())
            client().admin()
        assertExplanation(
                .setExplain(true)
        );
        assertThat(response.isValid(), is(true));
            client().admin()
 *
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1))
        client().admin()
                    .endObject()
        // more like this queries
            equalTo(false)
        );
 * this file be licensed under the Apache-2.0 license or a
    }
 * license agreements. See the NOTICE file distributed with
import java.util.List;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
    private static void assertExplanations(
                    .startObject()
 */
                    QueryBuilders.wrapperQuery(new BytesArray("{\"foo\": \"bar\", \"query\": {\"term\" : { \"user\" : \"foobar\" }}}"))
                    .startObject("pin")
        client().prepareIndex("test").setId("1").setSource("name", "username", "timestamp", 200).get();
        assertExplanations(
            containsString("field:huge field:pidgin"),
        response = client().admin()
 * not use this file except in compliance with the License.
            .indices()
    // Issue: https://github.com/opensearch-project/OpenSearch/issues/2036
        assertThat(
 * under the License.
            .setQuery(
            .execute()
            QueryBuilders.commonTermsQuery("field", "huge brown pidgin").cutoffFrequency(1),
            true
                .prepareValidateQuery("test")
        assertThat(validateQueryResponse.isValid(), equalTo(true));
                QueryBuilders.boolQuery()
            assertThat(response.getQueryExplanation().get(i).getExplanation(), matchers.get(i));
            assertThat(response.getQueryExplanation().size(), equalTo(1));
        assertThat(response.isValid(), is(true));
 * Modifications Copyright OpenSearch Contributors. See
            true
            .indices()
            .setSource(
            .setQuery(QueryBuilders.boolQuery().must(rangeQuery("timestamp").gte("aaa").lte(100)))
                .indices()
        refresh();
        assertNoFailures(response);
            true,
        assertExplanation(
                .setQuery(QueryBuilders.wrapperQuery("foo".getBytes(StandardCharsets.UTF_8)))
        assertThat(validateQueryResponse.isValid(), equalTo(true));
                    .field("type", "text")
                .setQuery(QueryBuilders.queryStringQuery("_id:1"))
                .execute()
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
import org.opensearch.transport.client.Client;
                .prepareValidateQuery("test")
                .indices()
                .maxQueryTerms(2),
                .indices()
            assertThat(response.getQueryExplanation().size(), equalTo(1));
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
                .execute()
            .get();
            .setRewrite(true)
        assertThat(response.getQueryExplanation().get(0).getError(), nullValue());
        );
            .get();
        assertExplanation(
            equalTo(true)
            equalTo(false)
            .execute()
                .minDocFreq(1)
                    .field("analyzer", "standard")
        );
                    .endObject()
            .setSource(
        assertThat(response.getQueryExplanation().size(), equalTo(matchers.size()));
        assertThat(response.getQueryExplanation().size(), equalTo(1));
 *
    public void testExplainNoQuery() {
                    .endObject()
        // prefix queries
            assertThat(
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.equalTo;
            .get();
    }
        client().prepareIndex("test").setId("3").setSource("field", "the quick lazy huge brown fox jumps over the tree").get();
                    .startObject("bar")
import java.util.Arrays;
                )
            .prepareValidateQuery()
package org.opensearch.validate;
            Arrays.asList(equalTo("field:quick"), allOf(containsString("field:quick"), containsString("field:quacks"))),
        // Use wildcard and date inside the range
 * The OpenSearch Contributors require contributions made to
        client().prepareIndex("test").setId("1").setSource("past", aMonthAgo, "future", aMonthFromNow).get();
        assertThat(validateQueryResponse.getQueryExplanation().size(), equalTo(1));
            client().admin()
                .indices()
    }
        client().admin()
        }
                .addAlias(new Alias("alias").filter(QueryBuilders.termQuery("field", "value1")))
 * the Apache License, Version 2.0 (the "License"); you may
                .execute()
                )
                .prepareValidateQuery("test")
                .indices()
        );
            client().admin()
            .get();
            .get();
            .setRewrite(true)
                .isValid(),
        // prefix queries
                .setQuery(QueryBuilders.queryStringQuery("nonexistent:hello"))
            true
                    .field("type", "text")
            client().admin().indices().prepareValidateQuery().get();
        assertThat(
        String aMonthFromNow = DateTimeFormatter.ISO_LOCAL_DATE.format(now.minus(1, ChronoUnit.MONTHS));
                    QueryBuilders.wrapperQuery(new BytesArray("{\"query\": {\"term\" : { \"user\" : \"foobar\" }}, \"foo\": \"bar\"}"))
                .isValid(),
import org.opensearch.common.settings.Settings;
            .setQuery(QueryBuilders.boolQuery().must(rangeQuery("timestamp").gte(0).lte(1000)).must(queryStringQuery("*erna*")))
        ensureGreen();
    }
            .setRewrite(true)
    public void testValidateDateRangeInQueryString() throws IOException {
    public void testIrrelevantPropertiesAfterQuery() throws IOException {
                        .startObject("timestamp")
    public void testExplainWithRewriteValidateQuery() throws Exception {
 * ownership. Elasticsearch licenses this file to you under
            .execute()
    }
        );
                .prepareValidateQuery("test")
            assertThat(response.getQueryExplanation().get(0).getError(), nullValue());
        );
/*
            client().admin()
            .prepareCreate("twitter")
                .isValid(),
            .indices()
            .setExplain(true)
            .indices()
    }
                .get()
                QueryBuilders.boolQuery()
        assertExplanation(
        );
        ensureGreen();
        // we cannot randomize the number of shards or change ids here.
        client().admin()
        );
        assertThat(response.isValid(), equalTo(true));
        refresh();
            true
            .preparePutMapping("test")
                    .must(queryStringQuery("username").allowLeadingWildcard(false))
                    .endObject()
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
                    .field("type", "integer")
        assertThat(
            .indices()
            .setRewrite(withRewrite)
            .actionGet();
                .execute()
                .prepareValidateQuery("test")
 */
                .actionGet()
                .actionGet()
            .indices()
                .actionGet()
                .execute()
            .prepareValidateQuery("test")
        );
                    .startObject("foo")
        assertNoFailures(response);
            equalTo(false)
 * this work for additional information regarding copyright
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
                    .must(queryStringQuery("*erna*").allowLeadingWildcard(false))
import org.opensearch.test.OpenSearchIntegTestCase;
                .setQuery(QueryBuilders.wrapperQuery("foo".getBytes(StandardCharsets.UTF_8)))
                    .endObject()
            QueryBuilders.fuzzyQuery("field", "the").fuzziness(Fuzziness.fromEdits(2)),
        assertThat(
        ValidateQueryResponse response = client().admin()
 * compatible open source license.
                .indices()
    }
        assertThat(response.getQueryExplanation().get(0).getExplanation(), matcher);
import org.opensearch.action.admin.indices.alias.Alias;
        client().prepareIndex("test").setId("3").setSource("field", "the quick lazy huge brown fox jumps over the tree").get();
        // match queries with cutoff frequency
            ValidateQueryResponse response = client.admin()
        );
            containsString("past:[" + twoMonthsAgo + " TO " + rangeEnd + "]")
                    .startObject("location")
        assertThat(response.isValid(), equalTo(true));
            .prepareCreate("test")
            .indices()
                .execute()
            true
            QueryBuilders.moreLikeThisQuery(new String[] { "field" }, new String[] { "the huge pidgin" }, null)
                    .startObject("properties")
                    .must(rangeQuery("timestamp").gte(0).lte(100))
                .setQuery(QueryBuilders.queryStringQuery("foo"))
import static org.hamcrest.Matchers.nullValue;
                .setExplain(true)
            .execute()
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.number_of_shards", 1)));
 *    http://www.apache.org/licenses/LICENSE-2.0
        refresh();
        } catch (IndexNotFoundException e) {
        assertThat(response.isValid(), is(false));
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 2).put("index.number_of_routing_shards", 2))
                    .startObject("bar")
            assertThat(response.isValid(), equalTo(true));
            .prepareCreate("test")
                .minTermFreq(1)
                containsString("MatchNoDocsQuery(\"failed [bar] query, caused by number_format_exception:[For input string: \"foo\"]\")")
                    .startObject()
                .indices()
            assertThat(response.getQueryExplanation().get(0).getError(), containsString("Failed to derive xcontent"));
            containsString("+field:pidgin field:huge field:brown"),
            .prepareValidateQuery("twitter")
            assertThat(response.getQueryExplanation().get(0).getExplanation(), containsString("baz:foo"));
                .actionGet();
        assertThat(response.isValid(), is(false));
        ValidateQueryResponse response = client().admin()
        client().prepareIndex("test").setId("1").setSource("field", "quick lazy huge brown pidgin").get();
                .setQuery(QueryBuilders.queryStringQuery("foo:1"))
        createIndex("test");
            client().admin()
@ClusterScope(scope = Scope.SUITE)
        );
                        .startObject("name")
            .actionGet();
        assertThat(validateQueryResponse.getQueryExplanation().size(), equalTo(1));
        assertExplanation(QueryBuilders.matchQuery("field", "the brown").analyzer("stop"), containsString("field:brown"), true);
            )
                QueryBuilders.boolQuery()
            .indices()
        );
            validateQueryResponse.getQueryExplanation().get(0).getExplanation(),
                .isValid(),
        assertNoFailures(response);
                    .startObject("baz")
        createIndex("test");
            .setMapping("field", "type=text,analyzer=whitespace")
            .setRewrite(true)
            .indices()
    }
            containsString("field:huge field:pidgin"),
        client().prepareIndex("test").setId("4").setSource("field", "the lazy dog quacks like a duck").get();
            true
import org.opensearch.indices.TermsLookup;
                .setQuery(QueryBuilders.queryStringQuery("_i:d:1"))
        // common terms queries
 * Licensed to Elasticsearch under one or more contributor
            )
        client().prepareIndex("test").setId("2").setSource("field", "the quick brown fox").get();
        assertNoFailures(response);
                .isValid(),
        refresh();
                    .startObject("foo")
        );
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.number_of_shards", 1)));
        client().prepareIndex("test").setId("1").setSource("field", "quick lazy huge brown pidgin").get();
 */
        assertThat(
            QueryBuilders.matchQuery("field", "huge brown pidgin").cutoffFrequency(1),
    // Issue #3629
                .indices()
                .setQuery(
                    .startObject("properties")
        ValidateQueryResponse response = client().admin()
                    .endObject()
            .setRewrite(true)
                    .must(rangeQuery("timestamp").gte(0).lte(1000))
            .get();
import java.time.format.DateTimeFormatter;
        assertThat(validateQueryResponse.getQueryExplanation().get(0).getExplanation(), containsString("field:value1"));
    ) {
        // Use wildcard and date outside the range
    public void testIrrelevantPropertiesBeforeQuery() throws IOException {
        );
                .indices()
                    .field("type", "integer")
                    .endObject()
            true
    public void testSimpleValidateQuery() throws Exception {
            Arrays.asList(equalTo("field:jumps"), equalTo("field:\"ju*\"")),
        ValidateQueryResponse response = client().admin()
import org.opensearch.index.query.QueryBuilders;
        assertThat(response.isValid(), is(true));
            .prepareValidateQuery()
import org.opensearch.core.common.bytes.BytesArray;
                .include(true)
        // Use wildcard and date inside the range (allow leading wildcard)
            .setRewrite(true)
            .setQuery(queryBuilder)
            .setExplain(true)
    }
    public void testExplainWithRewriteValidateQueryAllShards() throws Exception {
        assertExplanation(QueryBuilders.fuzzyQuery("field", "jump"), containsString("(field:jumps)^0.75"), true);
        refresh();
                        .endObject()
                    .field("type", "geo_point")
        assertThat(validateQueryResponse.getQueryExplanation().get(0).getIndex(), equalTo("test"));
                response.getQueryExplanation().get(0).getExplanation(),
            .indices()
                .setQuery(QueryBuilders.queryStringQuery("bar:hey").lenient(false))
            .prepareValidateQuery()
import static org.hamcrest.Matchers.allOf;
            .actionGet();
            )
                .actionGet()
 * software distributed under the License is distributed on an
        }
            .get();
 * You may obtain a copy of the License at
                .isValid(),
                .setQuery(QueryBuilders.queryStringQuery("foo:1 AND"))
        ValidateQueryResponse response = client().admin()
import org.opensearch.index.query.MoreLikeThisQueryBuilder.Item;
            fail("Expected IndexNotFoundException");
            .get();
import org.opensearch.common.unit.Fuzziness;
            QueryBuilders.matchPhrasePrefixQuery("field", "qu"),
            equalTo(true)
        for (int i = 0; i < matchers.size(); i++) {
        );
                .indices()
        long rangeEnd = (now.plus(1, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS).toEpochSecond() * 1000) - 1;
                        .startObject(MapperService.SINGLE_MAPPING_NAME)
                        .endObject()
            .setQuery(

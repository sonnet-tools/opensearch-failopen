import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
                .prepareValidateQuery("test")
                    .endObject()
            .execute()
                    .endObject()  
        assertNoFailures(response);
                    .startObject("foo")
        );
        ValidateQueryResponse validateQueryResponse = client().admin().indices().prepareValidateQuery().setExplain(true).get();
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1))
        createIndex("test");
            .indices()
    public void testExplainNoQuery() {  
    public void testValidateDateRangeInQueryString() throws IOException {
import static org.hamcrest.Matchers.nullValue;
                )
                .indices()
            .setQuery(
            .prepareCreate("twitter")
            .setExplain(true)
            Arrays.asList(equalTo("field:jumps"), equalTo("field:\"ju*\"")),
import static org.hamcrest.Matchers.equalTo;
        response = client().admin()
            assertThat(response.isValid(), equalTo(false));
            assertThat(response.isValid(), equalTo(true));  
            equalTo(true)
            .setExplain(true)
                    .startObject("pin")
            assertThat(response.getQueryExplanation().size(), equalTo(1));
        for (int i = 0; i < matchers.size(); i++) {  
                    .field("analyzer", "standard")
 *
        // fuzzy queries  
        assertExplanation(
            QueryBuilders.matchPhrasePrefixQuery("field", "qu"),
        assertThat(validateQueryResponse.isValid(), equalTo(true));
            .execute()  
            .actionGet();
            equalTo(false)  
import org.opensearch.common.xcontent.XContentFactory;
                .minDocFreq(1)
import org.opensearch.common.settings.Settings;
            client().admin()
        refresh();
                        .startObject("timestamp")
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.number_of_shards", 1)));  
                    .endObject()
import org.opensearch.core.common.bytes.BytesArray;
                    .must(queryStringQuery("*erna*").allowLeadingWildcard(false))
                .actionGet()
                .indices()
 */  
            .setRewrite(true)
        ensureGreen();
            .get();  
                        .endObject()
    public void testIrrelevantPropertiesBeforeQuery() throws IOException {
        assertThat(validateQueryResponse.getQueryExplanation().get(0).getExplanation(), containsString("field:value1"));  
    }
 * compatible open source license.
import java.time.ZoneOffset;  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
                    .must(rangeQuery("timestamp").gte(0).lte(1000))
        assertThat(response.isValid(), equalTo(true));  
                .setQuery(QueryBuilders.queryStringQuery("_i:d:1"))
            .indices()  
        assertThat(
import org.opensearch.action.admin.indices.alias.Alias;  
            true,  
                    .endObject()  
    }  
        try {
        // prefix queries
            .setRewrite(true)
                .setQuery(QueryBuilders.queryStringQuery("foo:1"))  
        String aMonthFromNow = DateTimeFormatter.ISO_LOCAL_DATE.format(now.minus(1, ChronoUnit.MONTHS));
 *
            .prepareValidateQuery("twitter")
        assertThat(response.isValid(), equalTo(true));
        List<Matcher<String>> matchers,
    }
        assertExplanation(QueryBuilders.fuzzyQuery("field", "jump"), containsString("(field:jumps)^0.75"), true);  
                .minTermFreq(1)
    }
            .prepareValidateQuery("test")
        client().prepareIndex("twitter").setId("1").setSource("followers", new int[] { 1, 2, 3 }).get();
    }  
                .prepareValidateQuery("test")
        );  
                .isValid(),
    }  
                .prepareValidateQuery("test")
            .indices()
 * The OpenSearch Contributors require contributions made to  
                .execute()
import java.io.IOException;
        client().admin()  
                .execute()
            QueryBuilders.fuzzyQuery("field", "the").fuzziness(Fuzziness.fromEdits(2)),
        );  
            .indices()  
                .isValid(),
            equalTo(false)  
                    QueryBuilders.wrapperQuery(new BytesArray("{\"query\": {\"term\" : { \"user\" : \"foobar\" }}, \"foo\": \"bar\"}"))  
            .actionGet();
        // Use wildcard and date inside the range
        boolean withRewrite,
            equalTo("ApproximateScoreQuery(originalQuery=*:*, approximationQuery=Approximate(*:*))")
        );
        ValidateQueryResponse response = client().admin()
            true,  
        refresh();  
package org.opensearch.validate;
        QueryBuilder queryBuilder,  
 * You may obtain a copy of the License at  
                .setQuery(QueryBuilders.queryStringQuery("nonexistent:hello"))  
            assertThat(response.getQueryExplanation().get(i).getExplanation(), matchers.get(i));
import java.time.ZonedDateTime;
                .setQuery(QueryBuilders.queryStringQuery("_id:1"))  
            .setExplain(true)  
            containsString("field:the (field:tree)^0.3333333"),  
                .execute()
                .actionGet()
        assertExplanation(QueryBuilders.matchPhrasePrefixQuery("field", "ju"), containsString("field:jumps"), true);  
        assertExplanation(QueryBuilders.matchPhrasePrefixQuery("field", "qu"), containsString("field:quick"), true);
                    .startObject(MapperService.SINGLE_MAPPING_NAME)
                .get()
            .setMapping("field", "type=text,analyzer=whitespace")  
            .get();
                    .must(rangeQuery("timestamp").gte(0).lte(100))
                )
                .prepareValidateQuery("test")
            .setQuery(QueryBuilders.matchAllQuery())  
            fail("Expected IndexNotFoundException");  
        assertThat(
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
    // Issue #3629
        assertThat(
@ClusterScope(scope = Scope.SUITE)  
                .prepareValidateQuery("test")
        }  
        client().admin()
}  
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 2).put("index.number_of_routing_shards", 2))
                        .field("type", "keyword")  
    }
        client().prepareIndex("test").setId("4").setSource("field", "the lazy dog quacks like a duck").get();
 *  
public class SimpleValidateQueryIT extends OpenSearchIntegTestCase {
        }  
                    .endObject()
            prepareCreate("test").setMapping("field", "type=text")
        );
                    .field("type", "integer")
                        .endObject()
                        .startObject(MapperService.SINGLE_MAPPING_NAME)  
                .setQuery(
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 2).put("index.number_of_routing_shards", 2))  
            .setQuery(
            .get();
            .setRewrite(true)
    }  
        refresh();  
                .setQuery(QueryBuilders.wrapperQuery("foo".getBytes(StandardCharsets.UTF_8)))
                    .endObject()  
            .prepareValidateQuery()  
        for (Client client : internalCluster().getClients()) {
        );
                .isValid(),  
/*  
                    .field("type", "text")
        assertExplanation(QueryBuilders.matchQuery("field", "the brown").analyzer("stop"), containsString("field:brown"), true);
            containsString("field:huge field:pidgin"),
                .setQuery(QueryBuilders.queryStringQuery("foo"))  
    private static void assertExplanation(QueryBuilder queryBuilder, Matcher<String> matcher, boolean withRewrite) {
                .minTermFreq(1)  
    ) {
    public void testIrrelevantPropertiesAfterQuery() throws IOException {
            .get();
                .indices()
import java.time.temporal.ChronoUnit;  
                .isValid(),
        client().prepareIndex("test").setId("2").setSource("field", "the quick brown fox").get();
    }
        // prefix queries
                .setQuery(
                .get()
            )  
        );
            assertThat(response.isValid(), equalTo(true));
        assertAcked(
        assertThat(response.getQueryExplanation().size(), equalTo(1));  
                .isValid(),
        client().prepareIndex("test").setId("1").setSource("field", "quick lazy huge brown pidgin").get();
import org.opensearch.indices.TermsLookup;  
            );  
 * Modifications Copyright OpenSearch Contributors. See  
        client().prepareIndex("test").setId("1").setSource("field", "quick lazy huge brown pidgin").get();
        ensureGreen();
            true
            .execute()  
                .indices()
            assertThat(response.getQueryExplanation().get(i).getError(), nullValue());
        // Use wildcard and date inside the range (allow leading wildcard)
            .setSource(
import org.opensearch.index.query.QueryBuilder;  
                .prepareValidateQuery("test")  
            equalTo(true)
        ensureGreen();
 * the Apache License, Version 2.0 (the "License"); you may
                QueryBuilders.boolQuery()  
        long rangeEnd = (now.plus(1, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS).toEpochSecond() * 1000) - 1;
            true
            .prepareValidateQuery()  
        ValidateQueryResponse validateQueryResponse = client().admin()  
/*
import org.opensearch.common.unit.Fuzziness;  
            true  
        refresh();  
                .execute()
                        .startObject("properties")
            .indices()  
import static org.hamcrest.Matchers.allOf;  
        }
        // common terms queries
    }  
                    .startObject("properties")
            client().admin()
        refresh();
                .prepareValidateQuery("test")  
            .setMapping("field", "type=text,analyzer=whitespace")
            .get();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                    .field("type", "text")
            QueryBuilders.moreLikeThisQuery(new String[] { "field" }, null, items)
 * Unless required by applicable law or agreed to in writing,
            .get();
            assertThat(response.getQueryExplanation().get(0).getExplanation(), containsString("foo:foo"));
        );  
                .preparePutMapping("test")
                    .startObject("bar")
        client().admin()
            .setRewrite(true)  
        client().prepareIndex("test").setId("1").setSource("name", "username", "timestamp", 200).get();
            .preparePutMapping("test")
            )
        // we cannot randomize the number of shards or change ids here.
                .indices()  
import java.util.List;
        ValidateQueryResponse response = client().admin()  
        );
        boolean allShards  
                .indices()  
import org.opensearch.index.query.QueryBuilders;
        assertExplanation(  
            client().admin()  
                .prepareValidateQuery("test")
            QueryBuilders.matchPhrasePrefixQuery("field", "ju"),
            .indices()  
        ValidateQueryResponse response = client().admin()
                .execute()
 * SPDX-License-Identifier: Apache-2.0
            .indices()  
        assertNoFailures(response);  
            client().admin()
                    .must(rangeQuery("timestamp").gte(0).lte(100))
                XContentFactory.jsonBuilder()
            .indices()
 * KIND, either express or implied.  See the License for the
            true
            .prepareValidateQuery("alias")
            .actionGet();  
        assertNoFailures(response);
                        .endObject()  
            client().admin()
    public void testExplainFilteredAlias() {
                .setExplain(true)
        assertThat(validateQueryResponse.getQueryExplanation().size(), equalTo(1));
            .preparePutMapping("test")  
            true
        client().prepareIndex("test").setId("2").setSource("field", "the quick brown fox").get();  
        assertThat(  
        assertExplanation(
import static org.opensearch.index.query.QueryBuilders.rangeQuery;  
            client().admin()  
                QueryBuilders.boolQuery()  
            true
        String aMonthAgo = DateTimeFormatter.ISO_LOCAL_DATE.format(now.plus(1, ChronoUnit.MONTHS));  
                .setQuery(QueryBuilders.wrapperQuery("foo".getBytes(StandardCharsets.UTF_8)))  
    private static void assertExplanations(
        assertThat(response.getQueryExplanation().size(), equalTo(matchers.size()));
        assertThat(
            containsString("+field:pidgin field:huge field:brown"),
                .setExplain(true)
            true
            .setRewrite(true)
            .setRewrite(withRewrite)
                XContentFactory.jsonBuilder()  
    public void testExplainTermsQueryWithLookup() throws Exception {
        assertThat(response.getQueryExplanation().get(0).getError(), nullValue());
        assertThat(response.getQueryExplanation().size(), equalTo(1));
            assertThat(e.getMessage(), is("no such index [null] and no indices exist"));
                    .endObject()
            assertThat(response.getQueryExplanation().size(), equalTo(1));
            .setSource(
            client().admin()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            Arrays.asList(equalTo("field:quick"), allOf(containsString("field:quick"), containsString("field:quacks"))),
                        .startObject("name")
        // Use invalid date range  
                .isValid(),  
        client().prepareIndex("test").setId("3").setSource("field", "the quick lazy huge brown fox jumps over the tree").get();  
            .actionGet();
            assertThat(response.getQueryExplanation().get(0).getError(), nullValue());  
            equalTo(false)
                .actionGet();  
        // match queries with cutoff frequency
import org.opensearch.index.query.TermsQueryBuilder;
 * Licensed to Elasticsearch under one or more contributor  
        ensureGreen();
                    .startObject(MapperService.SINGLE_MAPPING_NAME)
                .indices()
    // Issue: https://github.com/opensearch-project/OpenSearch/issues/2036
                .actionGet()
            .prepareValidateQuery()
                .prepareValidateQuery("test")
        TermsQueryBuilder termsLookupQuery = QueryBuilders.termsLookupQuery("user", new TermsLookup("twitter", "1", "followers"));
        );
            )
        createIndex("test");  
                .prepareValidateQuery("test")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                response.getQueryExplanation().get(0).getExplanation(),
                        .endObject()
    public void testExplainValidateQueryTwoNodes() throws IOException {
    public void testExplainWithRewriteValidateQueryAllShards() throws Exception {
import org.opensearch.index.IndexNotFoundException;  
            .execute()  
        Item[] items = new Item[] { new Item(null, "1") };  
            .get();
 * software distributed under the License is distributed on an
                        .startObject()
        ValidateQueryResponse response = client().admin()  
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        } catch (IndexNotFoundException e) {
            .setQuery(
            .indices()
        refresh();
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).put("index.number_of_shards", 1)));  
                .maxQueryTerms(2),
        createIndex("test");  
            .setAllShards(allShards)
        response = client().admin()
        client().prepareIndex("test").setId("4").setSource("field", "the lazy dog quacks like a duck").get();
        );
        createIndex("test");
        refresh();  
                    .field("type", "geo_point")
 * specific language governing permissions and limitations
import org.opensearch.index.mapper.MapperService;
 */
                    .startObject("properties")  
import java.nio.charset.StandardCharsets;
        );
                    .endObject()
 * license agreements. See the NOTICE file distributed with
        client().admin()
 * this work for additional information regarding copyright
            containsString("+field:pidgin field:huge field:brown"),
            .actionGet();  
                .isValid(),  
        }
                    .endObject()  
        assertAcked(  
            .setQuery(queryBuilder)
            assertThat(  
        );  
                .addAlias(new Alias("alias").filter(QueryBuilders.termQuery("field", "value1")))
        );
            .indices()
                .actionGet()  
 */
        assertThat(response.isValid(), is(false));
        assertThat(
        assertThat(
        assertExplanations(  
            equalTo(false)
                        .field("type", "date")  
                .prepareValidateQuery("test")
        assertThat(
                    .must(queryStringQuery("*erna*").allowLeadingWildcard(false))
        assertThat(
            .setQuery(queryStringQuery("past:[now-2M/d TO now/d]"))
                .actionGet();  
                        .endObject()
                    XContentFactory.jsonBuilder()
            QueryBuilders.matchQuery("field", "huge brown pidgin").cutoffFrequency(1),  
    public void testExplainDateRangeInQueryString() {
 * ownership. Elasticsearch licenses this file to you under  
                .execute()  
                .execute()
import org.opensearch.transport.client.Client;
                    .endObject()
            )  
            assertThat(response.getQueryExplanation().get(0).getExplanation(), nullValue());
            .prepareValidateQuery("test")
                    .startObject("foo")  
                containsString("MatchNoDocsQuery(\"failed [bar] query, caused by number_format_exception:[For input string: \"foo\"]\")")
import org.opensearch.test.OpenSearchIntegTestCase;
            .prepareValidateQuery()
            .setRewrite(withRewrite)
                    .endObject()  
        );
        client().prepareIndex("test").setId("3").setSource("field", "the quick lazy huge brown fox jumps over the tree").get();
        response = client().admin()
                    .field("type", "integer")
        assertThat(response.getQueryExplanation().get(0).getExplanation(), matcher);
            .get();
                .setSource(  
        assertExplanation(QueryBuilders.commonTermsQuery("field", "the brown").analyzer("stop"), containsString("field:brown"), true);
                    .startObject("bar")  
    public void testSimpleValidateQuery() throws Exception {
import java.time.format.DateTimeFormatter;
                .actionGet()
 * GitHub history for details.
                    .startObject("properties")
                .isValid(),  
            assertThat(response.getQueryExplanation().get(0).getError(), containsString("Failed to derive xcontent"));  
        for (Client client : internalCluster().getClients()) {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        assertThat(
            validateQueryResponse.getQueryExplanation().get(0).getExplanation(),  
                .maxQueryTerms(2),  
        assertThat(response.isValid(), is(true));
        refresh();
                    QueryBuilders.wrapperQuery(new BytesArray("{\"foo\": \"bar\", \"query\": {\"term\" : { \"user\" : \"foobar\" }}}"))  
            containsString("field:huge field:pidgin"),  
/*
        assertThat(validateQueryResponse.getQueryExplanation().get(0).getIndex(), equalTo("test"));
        assertThat(validateQueryResponse.isValid(), equalTo(true));  
import static org.hamcrest.Matchers.is;  
                    .endObject()
        response = client().admin()
                    .startObject("location")  
        assertThat(response.isValid(), is(true));
                .minDocFreq(1)
                .actionGet()  
    public void testValidateEmptyCluster() {  
            .prepareCreate("test")
                .indices()
            ValidateQueryResponse response = client.admin()  
            client().admin()  
            .get();
import java.util.Arrays;
        assertThat(validateQueryResponse.getQueryExplanation().size(), equalTo(1));  
        client().admin()
        // We are relying on specific routing behaviors for the result to be right, so  
        ensureGreen();
            .indices()
                .execute()  
            equalTo(false)
                    .startObject("baz")  
            .setQuery(queryBuilder)  
            .setExplain(true)
            .prepareValidateQuery()
        );
            client().admin()
        assertNoFailures(response);
            .execute()
        assertExplanations(  
        assertExplanation(
        assertThat(response.isValid(), is(false));  
                .setQuery(QueryBuilders.queryStringQuery("foo:1 AND"))
                    .startObject()  
        createIndex("test");  
        refresh();
                .indices()
    }
        // Use wildcard and date outside the range
            QueryBuilders.commonTermsQuery("field", "huge brown pidgin").cutoffFrequency(1),
                .setQuery(QueryBuilders.queryStringQuery("bar:hey").lenient(false))
                .include(true)  
                QueryBuilders.boolQuery()  
                    .endObject()  
            .indices()
            QueryBuilders.moreLikeThisQuery(new String[] { "field" }, new String[] { "the huge pidgin" }, null)
        ValidateQueryResponse response = client().admin()
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
                    .field("type", "text")
            .setMapping("user", "type=integer", "followers", "type=integer")
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertExplanation(
        assertNoFailures(response);
                .indices()  
import org.hamcrest.Matcher;
            )  
        assertThat(validateQueryResponse.getQueryExplanation().get(0).getIndex(), equalTo("test"));
        assertThat(response.getQueryExplanation().get(0).getError(), nullValue());  
        assertThat(response.isValid(), is(true));
                .execute()
                    .must(queryStringQuery("username").allowLeadingWildcard(false))
        );
            containsString("past:[" + twoMonthsAgo + " TO " + rangeEnd + "]")
        client().prepareIndex("test").setId("1").setSource("past", aMonthAgo, "future", aMonthFromNow).get();  
            client().admin().indices().prepareValidateQuery().get();
            response.getQueryExplanation().get(0).getExplanation(),  
                .actionGet()
        assertNoFailures(response);
            equalTo(true)
import org.opensearch.index.query.MoreLikeThisQueryBuilder.Item;
            .indices()  
                )
        ensureGreen();  
            .indices()
                .isValid(),  
            .setRewrite(true)
            .get();  
                    .startObject()
            .prepareCreate("test")  
            client().admin()
        );  
            .setQuery(termsLookupQuery)  
            equalTo(false)
            assertThat(response.getQueryExplanation().get(0).getExplanation(), containsString("baz:foo"));
        assertThat(response.isValid(), is(false));
    public void testExplainWithRewriteValidateQuery() throws Exception {  
import static org.hamcrest.Matchers.containsString;
        );
        );  
            .prepareValidateQuery()
        long twoMonthsAgo = now.minus(2, ChronoUnit.MONTHS).truncatedTo(ChronoUnit.DAYS).toEpochSecond() * 1000;  
            ValidateQueryResponse response = client.admin()  
        assertThat(  
                .indices()  
            .setQuery(QueryBuilders.boolQuery().must(rangeQuery("timestamp").gte("aaa").lte(100)))
                    .endObject()
            .setQuery(QueryBuilders.boolQuery().must(rangeQuery("timestamp").gte(0).lte(1000)).must(queryStringQuery("*erna*")))
    }  
        // more like this queries
            .indices()  
                .indices()

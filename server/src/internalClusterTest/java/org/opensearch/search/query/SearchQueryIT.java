        searchResponse = client().prepareSearch().setQuery(boolQuery).get();
        WrapperQueryBuilder wrapper = new WrapperQueryBuilder("{ \"term\" : { \"field1\" : \"value1_1\" } }");
        assertHitCount(searchResponse, 2L);
                    .startObject("properties")
                .get();
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
        searchResponse = client().prepareSearch()
        assertSecondHit(searchResponse, hasId("2"));
                    .endObject()
        boolQuery = boolQuery().must(matchQuery("field1", "a").zeroTermsQuery(MatchQuery.ZeroTermsQuery.ALL))
        assertThat(searchResponse.getHits().getAt(0).getId(), is("2"));
        indexRandomForConcurrentSearch("test");
        bitmap.addLong(1000000000001L);
        assertHitCount(searchResponse, 0L);
        searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();
    public void testNumericRangeFilter_2826() throws Exception {
                .setQuery(QueryBuilders.queryStringQuery("\"one two\"").field("desc"))
    public void testSpecialRangeSyntaxInQueryString() throws InterruptedException {
        assertHitCount(searchResponse, 0L);
import org.opensearch.search.SearchHit;
        client().admin().indices().prepareRefresh("test").get();
            ScoreMode.Max
        logger.info("--> terms query on 1");
            .field("type", "long")
        assertHitCount(searchResponse, 2L);
            client().prepareIndex("test")
            true,
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("num_double", new int[] { 1 }))).get();
            .get();
    public void testMatchQueryFuzzy() throws Exception {
                ),
            "section",
import org.opensearch.indices.IndicesService;
        assertAcked(prepareCreate("test").setMapping(mapping));
                .get();
    @Override
            assertTrue(hit.getFields().containsKey("id-alias"));
            client().prepareIndex("test1").setId("1").setSource("field", "Johnnie Walker Black Label"),
import org.apache.lucene.util.AttributeSource;
            )
        logger.info("prefix");
import org.opensearch.index.query.QueryBuilders;
            client().prepareIndex("test").setId("2").setSource("str", "2", "lng", 2L, "dbl", 2.0d),
 * software distributed under the License is distributed on an
                    .startObject("employee_id")
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("/value[01]/").field("field1").field("field2")).get(), 1);
                    .endObject()
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchPhraseQuery("field2", "quick brown").slop(0)).get();
import static org.opensearch.index.query.QueryBuilders.spanTermQuery;
        searchResponse = client().prepareSearch("test").setQuery(termsLookupQuery("term", new TermsLookup("lookup", "3", "terms"))).get();
        createIndex("test");
        createIndex("test");
            .get();
        searchResponse = client().prepareSearch("test")
        searchResponse = client().prepareSearch("test")
        for (SearchHit hit : hits.getHits()) {
            .setQuery(termsLookupQuery("not_exists", new TermsLookup("lookup2", "3", "arr.term")))
            searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();
            prepareCreate("employees2").setMapping(
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termQuery("num_long", 1))).get();
                    .endObject()
            true,
        indexRandom(
        client().prepareIndex("test").setId("3").setSource("score", 2.0).get();
            .get();
    }
        createIndex("test");
        assertFirstHit(searchResponse, hasId("3"));
        assertNoFailures(response);
    }
                        .field("field2", "value2_1")
    }
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("num_float", new int[] { 1 }))).get();
                        .startObject()
        assertHitCount(searchResponse, 1L);
        SearchResponse searchResponse = client().prepareSearch()
    */
            )
        expectThrows(SearchPhaseExecutionException.class, () -> client().prepareSearch().setQuery(matchQuery("double", "2 3 4")).get());
            .get();
        );
                        .put(
            client().prepareIndex("employees2").setId("3").setSource("employee_id", 3000000000003L)
            assertHitCount(searchResponse, 1L);
            .get();
    }
        refresh();
        createIndex("test");
    protected int maximumNumberOfReplicas() {
            Exception ex = expectThrows(
    public void testQueryStringParserCache() throws Exception {
            // The subquery matches all 6 docs in tl_lookup, but fetchSize is 3 => should fail
    }
            assertThat(field.getValue().toString(), equalTo("1"));
            client().prepareIndex("employees").setId("4").setSource("employee_id", 4000000000004L)
                .setSource(
            .setPostFilter(
        assertHitCount(searchResponse, 1L);
    public void testPassQueryOrFilterAsJSONString() throws Exception {
                    @Override
        assertHitCount(searchResponse, 1L);
            assertThat(searchHit, hasScore(1.0f));
            assertHitCount(searchResponse, 6L);
        client().prepareIndex("test").setId("1").setSource("field1", "value_1", "field2", "value_2").get();
                        .endObject()
            .must(multiMatchQuery("value1", "field1", "field2").zeroTermsQuery(MatchQuery.ZeroTermsQuery.NONE));
            .setId("1")
                        .endObject()
            client().prepareIndex("test")
        // the mapping needs to be provided upfront otherwise we are not sure how many failures we get back
        assertHitCount(response, 1L);
            .get();
            .get();
            containsString("NumberFormatException[For input string: \"value1\"]")
            client().prepareIndex("test").setId("3").setSource("long", 3L, "double", 3.0d)
import java.util.regex.Pattern;
        searchResponse = client().prepareSearch("test")
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("+num:>11 +num:<20")).get();
        assertSecondHit(searchResponse, hasId("2"));
            .setSource("online", false, "ts", System.currentTimeMillis() - 100, "type", "bs")
    }
                        .endObject()
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termQuery("num_byte", 1))).get();
            // unset cluster setting
    public void testTermIndexQuery() throws Exception {
                .setQuery(
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("lng", new long[] { 5, 6 }))).get();
        indexRandom(
        assertSecondHit(searchResponse, hasId("2"));
import static org.opensearch.index.query.QueryBuilders.existsQuery;
        assertHitCount(searchResponse, 1L);
        indexRandomForConcurrentSearch("tl_test");
                Settings.builder()
        for (int i = 0; i < iters; i++) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        refresh();
                .setId("2")
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("num:<=20")).get();
        assertHitCount(searchResponse, 2L);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
    }
                .setId("3")
                    .endObject()
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            client().prepareIndex("tl_lookup").setId("5").setSource("val", "5"),
            .setQuery(spanOrQuery(spanMultiTermQueryBuilder(fuzzyQuery("description", "fop"))))
            client().prepareIndex("test").setId("2").setSource("long", 2L, "double", 2.0d),
import java.util.Random;
            .get();
        assertFirstHit(searchResponse, hasId("2"));
        refresh();
        WrapperQueryBuilder wrapperFilter = wrapperQuery("{ \"term\" : { \"field1\" : \"value1_1\" } }");
                    () -> new MockTokenizer(MockTokenizer.KEYWORD, false)
        assertAcked(prepareCreate("test").setSettings("{\"index.analysis.analyzer.default.type\":\"keyword\"}", MediaTypeRegistry.JSON));
            .get();
        client().prepareIndex("test")
        client().prepareSearch("test").setQuery(constantScoreQuery(matchQuery("field1", "quick")).boost(1.0f + random().nextFloat())).get();
            client().prepareIndex("test").setId("3").setSource("field", 999999999999L),
 */
    }
        int queryRounds = scaledRandomIntBetween(10, 20);
            .setQuery(functionScoreQuery(ScoreFunctionBuilders.fieldValueFactorFunction("score").missing(1.0)).setMinScore(1.5f))
            .get();
            .setQuery(constantScoreQuery(termsQuery("product", bitmap).valueType(TermsQueryBuilder.ValueType.BITMAP)))
                        .endObject()
                        .field("y2", "y_2")
        searchResponse = client().prepareSearch()
        assertHitCount(searchResponse, 2L);
import static org.opensearch.index.query.QueryBuilders.wrapperQuery;
        response = client().prepareSearch("test")
        );
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T04:00:00").to("2014-01-01T04:59:00").timeZone("+03:00"))
        Set<String> hitIds = new HashSet<>();
        String now = DateFormatter.forPattern("strict_date_optional_time").format(Instant.now().atZone(timeZone));
        assertHitCount(searchResponse, 1L);
        assertFirstHit(searchResponse, hasId("1"));
        // means all terms must match
        searchResponse = client().prepareSearch().setQuery(matchQuery("text", "unify").fuzziness(Fuzziness.customAuto(5, 7))).get();
        // index "lookup" type "type" id "missing" document does not exist: ignore the lookup terms
        assertAcked(prepareCreate("lookup").setMapping("terms", "type=text", "other", "type=text"));
        assertHitCount(searchResponse, 1L);
            .get();
        assertHitCount(searchResponse, 1L);
        assertAcked(
            client().prepareIndex("lookup3").setId("1").setSource("terms", new String[] { "1", "3" }),
            assertNoFailures(searchResponse);
        searchResponse = client().prepareSearch("test")
        assertFirstHit(searchResponse, hasId("2"));
            );
        searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("7", "10")).get();
            // Fields are ORed together
        indexRandomForConcurrentSearch("test");
                                                                                                    // together.
        createIndex("test");
            .get();
        assertHitCount(searchResponse, 1L);
                .setQuery(QueryBuilders.queryStringQuery("\"one two\"").defaultField("desc"))
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .get();
                    .putList("index.analysis.normalizer.lowercase_normalizer.filter", "lowercase")
        assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 1L);
            .setRouting(randomAlphaOfLength(2))
    @Override
        searchResponse = client().prepareSearch().setQuery(existsQuery("obj1")).get();
        } finally {
        assertThirdHit(searchResponse, hasId("3"));
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();
            .get();
        client().prepareIndex("test")
        assertHitCount(searchResponse, 1L);
        assertNoFailures(searchResponse);
    // see #3952
        assertHitCount(response, 0);
                .setTransientSettings(Settings.builder().put(SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.getKey(), 3))
        assertFirstHit(searchResponse, hasId("1"));
                "type=short",
        );
            client().prepareIndex("employees").setId("2").setSource("employee_id", 2000000000002L),
    }
        assertFirstHit(searchResponse, hasId("1"));
        client().prepareIndex("test").setId("1").setSource("field1", "Bbb Aaa").get();
        indexRandomForConcurrentSearch("test");
    public void testRangeQueryWithLocaleMapping() throws Exception {
        createIndex("test");
        indexRandomForConcurrentSearch("test");
        return Math.min(2, cluster().numDataNodes() - 1);
 */
            )
                        .startObject()
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);
    public void testNestedQueryWithFieldAlias() throws Exception {
     * Test that wildcard queries on text fields get normalized
    public void testQuotedQueryStringWithBoost() throws InterruptedException {
     * Reserved characters should be excluded when the normalization is applied for keyword fields.
        SearchResponse searchResponse = client().prepareSearch().setQuery(queryStringQuery("past:[now-2M/d TO now/d]")).get();
            client().prepareIndex("test")
            if (totalHits > 1) {
        refresh();
                    .startObject("online")
            return singletonMap(
        client().prepareIndex("test").setId("3").setSource("field1", "value7", "field2", "value8", "field4", 5).get();
        );
import static org.opensearch.index.query.QueryBuilders.termsLookupQuery;
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("field1", "value1"))).get();
        assertFirstHit(searchResponse, hasId("1"));
        client().prepareIndex("test").setId("2").setSource("field1", "value3", "field2", "value4").get();
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(spanOrQuery(spanTermQuery("description", "bar"))).get();
 * this work for additional information regarding copyright
        indexRandomForConcurrentSearch("test");
import java.util.HashSet;
            client().prepareIndex("test").setId("2").setSource("field", 1000000000000L),
        // as with dynamic mappings some shards might be lacking behind and parse a different query
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();
                        .field("obj2_val", "1")
            client().prepareSearch().setQuery(builder),
    }
        assertHitCount(searchResponse, 2L);
        assertSearchHits(searchResponse, "1", "2");
import org.opensearch.index.query.Operator;
        multiMatchQuery.minimumShouldMatch("70%");
        );
        assertSearchHits(searchResponse, "1");
        searchResponse = client().prepareSearch()
        SearchResponse searchResponse = client().prepareSearch("test")
     * set for fuzzy queries with "constant_score" rewrite nested inside a `span_multi` query and would cause NPEs due to an unset
    // Issue #10477
            .setSource("num_byte", 17, "num_short", 17, "num_integer", 17, "num_long", 17, "num_float", 17, "num_double", 17)
                float expected = hits.getAt(0).getScore();
        );
            client().prepareIndex("test").setId("1").setSource("date", "2014-01-01", "num", 1),
            SearchResponse request = client().prepareSearch().setQuery(constantScoreQuery(termQuery("_index", indexName))).get();
        assertHitCount(searchResponse, 3L);
            client().prepareIndex("test").setId("3").setSource("field1", "quick")
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T03:00:00").to("2014-01-01T03:59:00").timeZone("+03:00"))
                        .endObject()
        assertHitCount(searchResponse, 1L);
        assertFirstHit(searchResponse, hasId("1"));
            .get();
                    .startObject("properties")
        logger.info("regexp");
        // directly building the terms query builder, so pass in the bitmap value as BytesArray
    public void testDateRangeInQueryStringWithTimeZone_7880() throws InterruptedException {
        try {
        SearchResponse searchResponse = client().prepareSearch("test")
        assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
            .setQuery(
                    .field("format", "E, d MMM yyyy HH:mm:ss Z")
        assertHitCount(searchResponse, 0L);
        }
                    .endObject()
        assertFirstHit(searchResponse, hasId("1"));
                    .endObject()
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").setRefreshPolicy(IMMEDIATE).get();
 */
            SearchResponse searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();
        assertHitCount(searchResponse, 1L);
            client().prepareSearch().setQuery(matchAllQuery()).setPostFilter(boolQuery().mustNot(termQuery("field1", "value3"))).get(),
        // stop drops "the" since its a stopword
        client().prepareIndex("test")
        searchResponse = client().prepareSearch("test")
                .setSource("date", Instant.now().atZone(ZoneOffset.ofHours(1)).toInstant().toEpochMilli(), "num", 4)
        assertHitCount(searchResponse, 1L);
        } finally {
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("str", "5", "6"))).get();
            .setQuery(queryStringQuery("past:[2015-04-06T00:00:00 TO 2015-04-06T23:00:00]").timeZone("+0200"))
        assertHitCount(searchResponse, 1L);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertThirdHit;
        assertFirstHit(searchResponse, hasId("2"));
        {
            .field("path", "_routing")
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                        .endObject()
        SearchResponse response = client().prepareSearch("test")
        client().prepareIndex("test").setId("1").setSource("field1", "value1_1", "field2", "value2_1").setRefreshPolicy(IMMEDIATE).get();
                    .field("format", "epoch_millis")
        client().prepareIndex("test").setId("1").setSource("field", "foobarbaz").get();
    }
        searchResponse = client().prepareSearch()
        indexRandom(
        assertThat(searchResponse.getHits().getAt(0).getId(), is("3"));
            prepareCreate("products").setMapping(
                    )
            .get();
        logger.info("fuzzy");
            client().prepareIndex("test").setId("1").setSource("field1", "the quick brown fox"),
                .setPostFilter(
                boolQuery().must(matchAllQuery()).must(constantScoreQuery(matchQuery("field1", "quick")).boost(1.0f + random().nextFloat()))
                    assertThat(searchHit, hasScore(expected));
            .setQuery(constantScoreQuery(termsQuery("term", new String[0])))
        assertHitCount(searchResponse, 1L);
import org.opensearch.common.time.DateFormatter;
            .setQuery(
        refresh();
            .must(boolQuery().should(termQuery("field1", "value1")).should(termQuery("field1", "value2")).minimumShouldMatch(3));
        }
 *
        createIndex("test");
     * Test correct handling {@link SpanBooleanQueryRewriteWithMaxClause#rewrite(IndexSearcher, MultiTermQuery)}. That rewrite method is e.g.
        Random random = random();
        createIndex("test");
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
        refresh();
        assertHitCount(searchResponse, 1L);
        builder.lenient(true);
        SearchResponse searchResponse = client().prepareSearch().setQuery(constantScoreQuery(idsQuery().addIds("1", "3"))).get();
import org.opensearch.plugins.Plugin;
                "type=float",
            + "                   \"intervals\" : ["
                assertThat(searchHit, hasScore(1.0f));
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch().setQuery(matchPhrasePrefixQuery("field", "trying")).get();
    // see #3797
            client().prepareIndex("lookup2")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("num_short", new int[] { 1 }))).get();
            .setQuery(spanOrQuery(spanMultiTermQueryBuilder(wildcardQuery("description", "oth*"))))
            .get();
        assertAcked(prepareCreate("test").setMapping("int_range", "type=integer_range"));
            assertThat((double) searchResponse.getHits().getAt(0).getScore(), closeTo(2.0, 0.1));
        indexRandomForConcurrentSearch("test");
import org.opensearch.search.SearchService;
        searchResponse = client().prepareSearch("test")
        logger.info("wildcard");
                .setId("4")
        assertThat(searchResponse.getHits().getAt(0).getId(), is("2"));
        assertSearchHits(searchResponse, "1", "2");
        assertFirstHit(searchResponse, hasId("2"));
        client().prepareIndex("test").setId("4").setSource("field1", "test2", "num_long", 4).get();
        // Same timezone set with time_zone but another timezone is set directly within dates which has the precedence
                        .endObject()
                        .startObject("obj1")
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
        indexRandom(
        indexRandom(true, false, client().prepareIndex("test").setId("1").setSource("nameTokens", "xyz"));
        assertHitCount(searchResponse, 1L);
        assertFirstHit(searchResponse, hasId("1"));
        assertFirstHit(searchResponse, hasId("1"));
 * the Apache License, Version 2.0 (the "License"); you may
        refresh();
/*
            wildCardQuery = wildcardQuery("field1", "bb*");
        assertHitCount(searchResponse, 3L);
                jsonBuilder().startObject()
        assertSearchHits(searchResponse, "1", "2");
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
 * SPDX-License-Identifier: Apache-2.0
        SearchResponse searchResponse = client().prepareSearch().setQuery(boolQuery).get();
    }
        client().prepareIndex("test").setId("2").setSource("field1", "test1", "num_long", 2).get();
                        .startObject("obj2")
                    .put("index.analysis.analyzer.lowercase_analyzer.tokenizer", "standard")
            SearchResponse searchResponse = client().prepareSearch("test")
        assertHitCount(searchResponse, 2L);
            assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        refresh();
        ZoneId timeZone = randomZone();
            .get();
            QueryBuilders.termQuery("section.route_length_miles", 42),
        BytesArray bitmap = new BytesArray(array);
        assertHitCount(searchResponse, 1L);
            client().prepareIndex("tl_lookup").setId("3").setSource("val", "3"),
    }
            client().prepareIndex("test").setId("2").setSource("field1", "quick lazy huge brown fox", "field2", "quick lazy huge brown fox")
                "num_short",
        // Same timezone set with time_zone
import org.opensearch.index.query.QueryBuilder;
        searchResponse = client().prepareSearch("test")
        );
    }
        assertThat(searchResponse.getHits().getAt(0).getId(), is("1"));
        }
        assertThirdHit(searchResponse, hasId("2"));
     */
        client().prepareIndex("test").setId("4").setSource("description", "fop", "count", 4).get();
            .setPostFilter(boolQuery().should(rangeQuery("num_long").from(1).to(2)).should(rangeQuery("num_long").from(3).to(4)))
                    .startObject("_routing")
                .get(),
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("num_byte", new int[] { 1 }))).get();
        indexRandomForConcurrentSearch("test");
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        assertAcked(
                    XContentFactory.jsonBuilder()
                "type=byte",
            client().prepareIndex("tl_test").setId("1").setSource("val", "1"),
            .setRouting("X")
        assertHitCount(searchResponse, 2L);
                    .startObject("term")
                    jsonBuilder().startObject()
        assertFirstHit(searchResponse, hasId("1"));
                            boolQuery().must(rangeQuery("ts").lt(System.currentTimeMillis() - (15 * 1000))).must(termQuery("type", "bs"))
            .endObject();
            client().prepareIndex("employees").setId("1").setSource("employee_id", 1000000000001L),
        logger.info("regular");
            SearchResponse searchResponse = assertSearchResponse(request);
                    boolQuery().must(matchAllQuery())
        client().prepareIndex("test").setId("2").setSource("str", "fred", "date", "2012-02-05", "num", 20).get();
        public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
        assertSearchHits(searchResponse, "1", "2");
    public void testQueryStringAnalyzedWildcard() throws Exception {
        SearchResponse searchResponse = client().prepareSearch("test")
        searchResponse = client().prepareSearch()
            client().admin()
            )
    }
                .get();
        assertHitCount(searchResponse, 2L);
            client().prepareIndex("lookup").setId("4").setSource("other", "value"),
                        .startObject()
                    .startObject("arr")
        assertHitCount(searchResponse, 1L);
            .get();
        assertHitCount(response, 1);
            true,
        // Default
    }
        assertHitCount(searchResponse, 1L);
            true,
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("*ue_1")).get();
        return Arrays.asList(InternalSettingsPlugin.class, MockAnalysisPlugin.class);
        client().prepareIndex("test").setId("1").setSource("desc", "one two three", "type", "customer").get();
            client().prepareIndex("lookup2")
            .get();
    public void testSimpleSpan() throws IOException, ExecutionException, InterruptedException {
                .get();
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1))
            .must(matchQuery("field1", "value1").zeroTermsQuery(MatchQuery.ZeroTermsQuery.NONE));
        indexRandom(
        assertHitCount(searchResponse, 3L);
        searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();
            .get();
            SearchResponse searchResponse = assertSearchResponse(request);
            true,
        searchResponse = client().prepareSearch("test").setQuery(termQuery("num_short", 1)).get();
import static org.opensearch.index.query.QueryBuilders.wildcardQuery;
        client().prepareIndex("test").setId("2").setSource("str", "fred", "date", "2012-02-05", "num", 20).get();
            .setExplain(true)
            client().prepareIndex("employees2").setId("2").setSource("employee_id", 2000000000002L),
            client().prepareIndex("products").setId("3").setSource("product", new int[] { 1, 3 }),
            ).setMapping("field1", "type=keyword,normalizer=lowercase_normalizer")
                        .field("field3", "value3_4")
        assertHitCount(searchResponse, 1L);
        assertSecondHit(searchResponse, hasId("1"));
        indexRandomForConcurrentSearch("test");
            searchResponse = client().prepareSearch("test")
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);
            client().prepareIndex("test").setId("1").setSource("field", 1000000000001L),
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termQuery("num_integer", 1))).get();
        searchResponse = client().prepareSearch()
                        .field("field2", "value2_3")
            client().prepareIndex("test").setId("2").setSource("field1", "value2", "field2", "value5", "field3", "value2"),
                    public String name() {
            client().prepareIndex("test")
            true,
    public void testMultiFieldQueryString() throws InterruptedException {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            client().prepareIndex("test").setId("1").setSource("description", "it's cold outside, there's no kind of atmosphere")
        assertHits(response.getHits(), "1");
        assertThat(searchResponse.getHits().getAt(0).getId(), is("4"));
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
                Settings.builder()
    public void testMustNot() throws IOException, ExecutionException, InterruptedException {
import org.opensearch.indices.TermsLookup;
        multiMatchQuery.minimumShouldMatch("70%");
                    .field("index", false)
        indexRandomForConcurrentSearch("test");
        searchResponse = client().prepareSearch("test")
            .setTransientSettings(Settings.builder().put(IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey(), true))
            .endObject();
            client().prepareIndex("tl_test").setId("2").setSource("val", "2"),
                        .startObject()
                ).pre(1).post(1)
        assertHitCount(searchResponse, 1L);
            client().prepareIndex("test").setId("3").setSource("term", "3"),
            .get();
        );
        assertSearchHits(searchResponse, "1", "4");
            client().admin()
        indexRandomForConcurrentSearch("lookup");
                )
        );
    public void testRangeQueryRangeFields_24744() throws Exception {
                .cluster()
            client().prepareIndex("employees2").setId("1").setSource("employee_id", 1000000000001L),
            .setId("4")
            .setQuery(queryStringQuery("past:[now-1m/m TO now+1m/m]").timeZone(timeZone.getId()))
        searchResponse = client().prepareSearch("test").setQuery(termQuery("num_integer", 1)).get();
        client().prepareIndex("test").setId("1").setSource("field1", "Bbb Aaa").get();
            client().prepareIndex("test").setId("3").setSource("field1", "value3", "field2", "value6", "field3", "value1")
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("field\\*:value*")).get(), 1);
        assertHitCount(searchResponse, 0L);
            true,
        DataOutputStream dos = new DataOutputStream(bos);
        assertAcked(
        assertFirstHit(searchResponse, hasId("1"));
            client().prepareIndex("test").setId("4").setSource("description", "foo")
                    .endObject()
            client().prepareIndex("test").setId("1").setSource("long", 1L, "double", 1.0d),
            + "       \"all_of\" : {"
            indexRandom(true, client().prepareIndex(indexName).setId(indexName + "1").setSource("field1", "value1"));
        assertSearchHits(searchResponse, "1", "3");
        searchResponse = client().prepareSearch("test").setQuery(termQuery("num_double", 1)).get();
                        .field("field1", "value1_1")
        refresh();
import org.opensearch.core.common.bytes.BytesArray;
        // object check
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").get();
                    .endObject()
        assertHitCount(searchResponse, 1L);
import org.apache.lucene.analysis.pattern.PatternReplaceCharFilter;
        indexRandom(
import org.opensearch.index.analysis.TokenizerFactory;
        indexRandom(
            SearchResponse searchResponse = assertSearchResponse(request);
        client().prepareIndex("test").setId("2").setSource("field2", "value1").get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
    public void testFuzzyQueryString() throws InterruptedException {
        createIndex("test");
                .setId("1")
            client().admin()
                    .build()
    }
        // index "lookup3" type "type" has the source disabled: ignore the lookup terms
                        .endObject()
    }
                .setQuery(QueryBuilders.queryStringQuery("xyz").boost(100))
        refresh();
                    .endObject()
/*
            .should(boolQuery().should(termQuery("field1", "value1")).should(termQuery("field1", "value2")).minimumShouldMatch(1))
            .setQuery(
import org.opensearch.index.query.RangeQueryBuilder;
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T00:00:00").to("2014-01-01T00:59:00"))
            true,
        searchResponse = client().prepareSearch("test").setQuery(termsLookupQuery("term", new TermsLookup("lookup", "4", "terms"))).get();
        searchResponse = client().prepareSearch().setQuery(builder).get();
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 2L);
        assertHitCount(searchResponse, 1L);
        assertSearchHits(searchResponse, "1", "3");
        createIndex("test1");
        BoolQueryBuilder bool = boolQuery().must(wrapper).must(new TermQueryBuilder("field2", "value2_1"));
        createIndex("test");
            .field("path", "_id")
import org.opensearch.index.query.MatchQueryBuilder;
            client().prepareIndex("products").setId("4").setSource("product", 4)
import org.opensearch.index.query.WildcardQueryBuilder;
                        return new PatternReplaceCharFilter(pattern, "", reader);
        builder = multiMatchQuery("value1", "field1", "field2", "field4");
                        .endObject()
                    ),
        // as with dynamic mappings some shards might be lacking behind and parse a different query
            true,
        assertAcked(prepareCreate("test"));
        logger.info("--> term query on 1");
            .get();
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
    public void testMultiMatchQueryMinShouldMatch() throws InterruptedException {
        indexRandom(
                        .field("x2", "x_2")
        // This made #2979 fail!
import java.io.DataOutputStream;
    }
                .setQuery(termQuery("routing-alias", "custom"))
        assertSearchHits(searchResponse, "3", "1");
            + "               { \"match\" : { \"query\" : \"atmosphere\" } } ],"
                        .endObject()
 *
        assertHitCount(client().prepareSearch("test").setSize(0).setQuery(rangeQuery("field").gte(1000000000000L)).get(), 4);
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        assertHitCount(searchResponse, 1);
            .setId("1")
            .setQuery(commonTermsQuery("field1", "the huge fox").cutoffFrequency(100).lowFreqMinimumShouldMatch("3"))
        assertSecondHit(searchResponse, hasId("3"));
                .prepareUpdateSettings()
        indexRandomForConcurrentSearch("test");
        assertAcked(
    }
        SearchResponse searchResponse = client().prepareSearch().setQuery(constantScoreQuery(matchQuery("field1", "quick"))).get();
            .setSize(100)
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("lng", new long[] { 2, 5 }))).get();
        for (String indexName : indexNames) {
        assertFirstHit(searchResponse, hasScore(searchResponse.getHits().getAt(1).getScore()));
                    spanTermQuery("description", "brown")
        indexRandomForConcurrentSearch("test");
        multiMatchQuery = multiMatchQuery("value1 value2 value3", "field1", "field2");
        assertHitCount(searchResponse, 0L);
        indexRandomForConcurrentSearch("test");
    public void testIssueFuzzyInsideSpanMulti() throws InterruptedException {
                jsonBuilder().startObject()
        assertHitCount(searchResponse, 2L);
                .setQuery(termsLookupQuery("val", new TermsLookup("tl_lookup", null, "val", matchAllQuery())))
            .get();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        );
        refresh();
                    .field("type", "long")
                        .startObject()
        assertFirstHit(searchResponse, hasId("1"));
                spanNotQuery(
            (double) searchResponse.getHits().getAt(0).getScore(),
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch("test").setQuery(idsQuery()).get();
        assertFirstHit(searchResponse, hasId("1"));
    // see #3521
        assertHitCount(searchResponse, 2L);
        assertFirstHit(searchResponse, hasId("3"));
                spanNotQuery(
        assertThirdHit(searchResponse, hasId("2"));
                .setQuery(boolQuery().must(matchAllQuery()).must(constantScoreQuery(matchAllQuery())))
    }
        // same as above, just on the _id...
        indexRandom(
        assertFirstHit(searchResponse, hasId("2"));
        searchResponse = client().prepareSearch("test").setQuery(termQuery("num_byte", 1)).get();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
    /**
            .get();
        indexRandomForConcurrentSearch("test");
                .setId("1")
                    .field("type", "keyword")
        refresh();
                    .startObject("date_field")
        indexRandomForConcurrentSearch("test");
                }
        assertHitCount(searchResponse, 0L);
        searchResponse = client().prepareSearch().setQuery(builder).get();
        assertHitCount(searchResponse, 0L);
            + "               { \"any_of\" : {"
            .setRouting(randomAlphaOfLength(2))
            client().admin()
 *    http://www.apache.org/licenses/LICENSE-2.0
            client().prepareIndex("test").setId("1").setSource("term", "1"),
        assertThat(hitIds, containsInAnyOrder(ids));
        searchResponse = client().prepareSearch().setQuery(matchQuery("text", "uniy").fuzziness(Fuzziness.ONE)).get();
        client().prepareIndex("test")
            long totalHits = searchResponse.getHits().getTotalHits().value();
            false,
            true,
    public void testMinScore() throws ExecutionException, InterruptedException {
        assertHitCount(searchResponse, 1L);
                        .field("term", "4")
import org.opensearch.common.xcontent.XContentFactory;
        String aMonthFromNow = DateTimeFormatter.ISO_LOCAL_DATE.format(now.plusMonths(1));
        searchResponse = client().prepareSearch("test")
            client().prepareIndex("test").setId("1").setSource("foo", "bar"),
            .get();
            client().prepareIndex("test").setId("1").setSource("field1", "value1"),
        // directly building the terms query builder, so pass in the bitmap value as BytesArray
            .setSource("online", false, "bs", "Y", "ts", System.currentTimeMillis() - 100, "type", "s")
        indexRandomForConcurrentSearch("test");
        client().admin().indices().prepareRefresh("test").get();
        assertFirstHit(searchResponse, hasId("1"));
        wildCardQuery = wildcardQuery("field", "la*el-?");
        // another search with same parameters...
        assertSearchHits(searchResponse, "1", "3");
        refresh();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            prepareCreate("test").setMapping(
        SearchResponse searchResponse = client().prepareSearch("index").setQuery(nestedQuery).get();
                "type=double"
        }
    }
        refresh();
            // Raise the limit so the same query succeeds
            .endObject()
            .get();
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T02:00:00").to("2014-01-01T02:59:00").timeZone("+03:00"))
        assertSearchHits(searchResponse, "2", "3");
        searchResponse = client().prepareSearch()
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
            .setQuery(commonTermsQuery("field1", "the huge fox").cutoffFrequency(1).lowFreqMinimumShouldMatch("2"))
        assertAcked(
        assertHitCount(searchResponse, 1L);
            .setQuery(termsLookupQuery("term", new TermsLookup("lookup2", "1", "arr.term")))
}
        assertHitCount(searchResponse, 1L);
            .endObject()
        );
    }
    public SearchQueryIT(Settings staticSettings) {
    }
                                                                                        // Fields are always OR-ed together.
        assertSecondHit(searchResponse, hasId("2"));
import java.io.IOException;
                .get();
        client().prepareIndex("test").setId("1").setSource("field1", "test1", "num_long", 1).get();
                .setSource(
        assertFirstHit(searchResponse, hasId("1"));
        assertSearchHits(searchResponse, "1", "3");
        );
import org.opensearch.index.query.TermQueryBuilder;
        createIndex("test");
        assertHitCount(response, 3);
        SearchResponse searchResponse = client().prepareSearch("test")
        SearchResponse searchResponse = client().prepareSearch("test")
                "num_float",
        @Override
            prepareCreate("test").setSettings(
            client().prepareIndex("products").setId("2").setSource("product", 2),
            .get();
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("value1").field("field1").field("field2")).get(), 1);
        assertHitCount(searchResponse, 1L);
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                    .put("index.analysis.char_filter.no_wildcard.type", "mock_pattern_replace")
        indexRandomForConcurrentSearch("test");
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSecondHit;
                        .field("x1", "x_1")
        );
    }
            .get();
        refresh();
        {
            .cluster()
import static org.opensearch.index.query.QueryBuilders.commonTermsQuery;
        // the mapping needs to be provided upfront otherwise we are not sure how many failures we get back
            }
    }
        client().prepareIndex("test").setId("2").setSource("description", "the quick black fox leaped over the sleeping dog").get();
            .should(boolQuery().should(termQuery("field1", "value1")).should(termQuery("field1", "value2")).minimumShouldMatch(3))
 * ownership. Elasticsearch licenses this file to you under
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("lng", new int[] { 1, 3 }))).get();
    }
                    jsonBuilder().startObject()
            assertHitCount(searchResponse, 1L);
            .setSource("num_byte", 1, "num_short", 1, "num_integer", 1, "num_long", 1, "num_float", 1, "num_double", 1)
        }
import org.opensearch.action.search.SearchResponse;
                        .startObject()
                    .putList("index.analysis.analyzer.lowercase_analyzer.filter", "lowercase")
        assertHitCount(searchResponse, 2L);
            .prepareCreate("test")
        IndexRequestBuilder[] builders = new IndexRequestBuilder[num];
            client().prepareIndex("test").setId("2").setSource("date", "2013-12-31T23:00:00", "num", 2),
    }
        );
    }
                    .field("required", true)
        assertAcked(prepareCreate("test").setMapping("date", "type=date", "num", "type=integer"));
                    public Reader create(Reader reader) {
                    XContentFactory.jsonBuilder()
        QueryBuilder nestedQuery = QueryBuilders.nestedQuery(
        // wildcard check
        indexRandomForConcurrentSearch("lookup2");
        assertAcked(prepareCreate("test"));
    }
            assertHitCount(searchResponse, 2);
    public void testCommonTermsQuery() throws Exception {
        // test valid type, but no matching terms
    public void testTermsQueryWithBitmap64IndexAndDocValues() throws Exception {
        searchResponse = client().prepareSearch().setQuery(builder).get();
        assertFirstHit(searchResponse, hasId("1"));
                        .field("term", "2")
            SearchResponse request = client().prepareSearch().setQuery(constantScoreQuery(termsQuery("_index", indexName))).get();
    }
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 2L);
                    .endObject()
            assertHitCount(searchResponse, 1L);
                    }
        forceMerge();
                ).dist(5)
        refresh();
        searchResponse = client().prepareSearch("test").setQuery(termQuery("num_float", 1)).get();
            .endObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                .setQuery(QueryBuilders.queryStringQuery("\"one three\"~5").field("desc"))
        assertHitCount(searchResponse, 0L);
                    .endObject()
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("str", "1", "4"))).get();
                jsonBuilder().startObject()
            .get();
        );
        assertSecondHit(searchResponse, hasId("1"));
        assertFirstHit(searchResponse, hasId("1"));
    public void testEmptyQueryString() throws ExecutionException, InterruptedException, IOException {
                ),
        for (String indexName : indexNames) {
        refresh();
            .setId("1")
    public void testIssue3177() throws InterruptedException {
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 2L);
        assertHitCount(searchResponse, 2L);
        assertHitCount(searchResponse, 4L);
        SearchResponse response = client().prepareSearch("test").setQuery(query).get();
        indexRandomForConcurrentSearch("test");
            .setQuery(
                ),
        assertHitCount(searchResponse, 3L);
        SearchResponse response = client().prepareSearch("test").setQuery(wildcardQuery("field", "Text").caseInsensitive(false)).get();
        SearchResponse response = client().prepareSearch("test")
            client().prepareIndex("test").setId("1").setSource("date_field", "Mi., 06 Dez. 2000 02:55:00 -0800"),
        assertFirstHit(searchResponse, hasId("1"));
        }
        );
        SearchResponse searchResponse = client().prepareSearch()
        assertAcked(prepareCreate("test").setMapping("str", "type=text", "lng", "type=long", "dbl", "type=double"));
        assertHitCount(searchResponse, 3L);
        indexRandomForConcurrentSearch("test");
        assertHitCount(client().prepareSearch().setQuery(queryStringQuery("")).get(), 0L); // return no docs
import java.time.format.DateTimeFormatter;
        client().admin()
        bitmap.addLong(3000000000003L);
    public void testMultiMatchQueryZeroTermsQuery() throws InterruptedException {
    public static Collection<Object[]> parameters() {
        assertAcked(prepareCreate("test").setMapping("term", "type=text"));
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("field1", "value1"))).get();
    public void testIndexOptions() throws Exception {
                .get();
            prepareCreate("employees").setMapping(
        refresh();
                "num_double",
        assertHitCount(searchResponse, 2L);
        assertHitCount(searchResponse, 1L);
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
import org.opensearch.index.query.TermsQueryBuilder;
        client().prepareIndex("test").setId("3").setSource("description", "foo other", "count", 3).get();
        assertSearchHits(searchResponse, "2");
                "num_integer",
    public void testFilterExistsMissing() throws Exception {
        BoolQueryBuilder boolQuery = boolQuery().must(matchQuery("field1", "a").zeroTermsQuery(MatchQuery.ZeroTermsQuery.NONE))
        boolQuery = boolQuery().must(multiMatchQuery("a", "field1").zeroTermsQuery(MatchQuery.ZeroTermsQuery.ALL));
                Exception.class,
        assertSearchHits(searchResponse, "1", "3");
            .get();
        client().prepareIndex("test").setId("2").setSource("description", "foo other anything", "count", 2).get();
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("field\\*:value1")).get(), 1);
        client().prepareIndex("test").setId("1").setSource("str", "foobar", "date", "2012-02-01", "num", 12).get();
        indexRandom(true, false, indexRequest);
                .get(),
            .get();
        assertHitCount(searchResponse, 0L);
        searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("1", "3")).get();
            )
        assertNoFailures(searchResponse);
            .get();
            .endObject()
        indexRandom(
import org.opensearch.index.query.WrapperQueryBuilder;
        assertHitCount(searchResponse, 0L);
                "num_short",
            assertThat(searchHit, hasScore(1.0f));
    public void testEmptytermsQuery() throws Exception {
import org.opensearch.core.rest.RestStatus;
import java.time.ZoneOffset;
        assertFirstHit(searchResponse, hasId("2"));
                "num_integer",
        assertHitCount(
        }
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
 * license agreements. See the NOTICE file distributed with
        assertHitCount(searchResponse, 2L);
        }
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termQuery("num_double", 1))).get();
        assertHitCount(searchResponse, 1L);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        SearchResponse searchResponse = client().prepareSearch()
        searchResponse = client().prepareSearch("test").setQuery(multiMatchQuery("value2").field("field2", 2).lenient(true)).get();
            .startObject("id-alias")
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("field\\*:/value[01]/")).get(), 1);
        boolQuery = boolQuery().must(termQuery("field1", "value1"))
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchQuery("long", "1")).get();
                        .startArray("arr")
        assertHitCount(client().prepareSearch().setQuery(bool).get(), 1L);
            true,
        }
            client().prepareIndex("test").setId("4").setSource("term", "4")
                    private final Pattern pattern = Regex.compile("[\\*\\?]", null);
                "num_byte",
            .should(boolQuery().should(termQuery("field1", "value1")).should(termQuery("field1", "value2")).minimumShouldMatch(3));
        assertHitCount(searchResponse, 1L);
        BoolQueryBuilder boolQuery = boolQuery().must(termQuery("field1", "value1"))
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();
        createIndex("test_1");
            assertSearchHits(searchResponse, indexName + "1");
            .setQuery(QueryBuilders.rangeQuery("date").from("2013-12-31T23:00:00").to("2013-12-31T23:59:00"))
        assertHitCount(searchResponse, 1L);
        public Map<String, AnalysisProvider<CharFilterFactory>> getCharFilters() {
                .get();
                    .endObject()
        searchResponse = client().prepareSearch("test")
            true,
    public void testMatchQueryZeroTermsQuery() throws InterruptedException {
        assertHitCount(searchResponse, 0L);
                .setQuery(QueryBuilders.queryStringQuery("\"one two\"").defaultField("desc"))
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("num_integer", new int[] { 1 }))).get();
            SearchResponse searchResponse = client().prepareSearch("test").setQuery(queryStringQuery("*:*^10.0").boost(10.0f)).get();
                        return name;
import static org.opensearch.index.query.QueryBuilders.boolQuery;
            .startObject("route_length_miles")
            .startObject()
        assertHitCount(client().prepareSearch().setPostFilter(wrapperFilter).get(), 1L);
        assertHitCount(searchResponse, 0L);
            client().prepareIndex("test").setId("1").setSource("text", "Unit"),
        // repeat..., with terms
        assertHitCount(searchResponse, 1L);
            SearchResponse searchResponse = client().prepareSearch()
                "type=long",
                    .put("index.analysis.normalizer.no_wildcard.char_filter", "no_wildcard")
            response = client().prepareSearch("test")
    protected int maximumNumberOfShards() {
                Settings.builder()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        try (DataOutputStream dos = new DataOutputStream(bos)) {
            .get();
        dos.close();
        );
            .setRouting("Y")
        assertFirstHit(searchResponse, hasId("1"));
        client().prepareIndex("test")
            .setQuery(boolQuery().mustNot(matchQuery("description", "anything")))
        searchResponse = client().prepareSearch().setQuery(existsQuery("x*")).get();
        {
        assertFirstHit(searchResponse, hasScore(searchResponse.getHits().getAt(1).getScore()));
        // We set a timezone which will give no result
        createIndex("test");
            .get();
    public void testSpanNot() throws IOException, ExecutionException, InterruptedException {
            client().prepareIndex("test").setId("5").setSource("field", 1000000000003L),
import org.opensearch.plugins.AnalysisPlugin;
import java.io.Reader;
            client().prepareIndex("employees").setId("3").setSource("employee_id", new long[] { 1000000000001L, 3000000000003L }),
        assertSearchHits(searchResponse, "2", "4");
            .setQuery(termsLookupQuery("term", new TermsLookup("lookup", "1", "terms")))
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch("test")
    /**
                    jsonBuilder().startObject()
                    boolQuery().must(matchAllQuery())
        // as with dynamic mappings some shards might be lacking behind and parse a different query
            prepareCreate("test").setMapping(
        searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("1")).get();
        assertNoFailures(response);
import static org.opensearch.index.query.QueryBuilders.spanNotQuery;
import static org.opensearch.index.query.QueryBuilders.matchQuery;
import org.opensearch.index.query.BoolQueryBuilder;
        assertHitCount(searchResponse, 2);
            .get();
        assertAcked(
                boolQuery().must(termQuery("field1", "test1"))
        assertAcked(prepareCreate("test").setMapping("field", "type=text"));
        index("index", "_doc", "1", source);
        @Override
    public static class MockAnalysisPlugin extends Plugin implements AnalysisPlugin {
     * as "Mi" for "Mittwoch (Wednesday" and "Do" for "Donnerstag (Thursday)" and the month in the query
    }
                                                                                                    // a field! Fields are always OR-ed
        assertSearchHits(searchResponse, "2");
                "num_float",
                                boolQuery().must(rangeQuery("ts").lt(System.currentTimeMillis() - (15 * 1000))).must(termQuery("type", "s"))
        createIndex("test");
        assertAcked(prepareCreate("test").setMapping("text", "type=text"));
                    boolQuery().must(
import static org.hamcrest.Matchers.is;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
            .startObject("routing-alias")
        );
        searchResponse = client().prepareSearch().setQuery(builder).get();
        indexRandom(true, builders);
        assertFirstHit(searchResponse, hasId("1"));
            .get();
            .field("type", "alias")
            .setQuery(QueryBuilders.queryStringQuery("xyz").boost(100))
                        .startObject()
        assertHitCount(searchResponse, 2L);
        for (int i = 0; i < 100; i++) {
                    .field("locale", "de")
        );
    public void testRangeQueryWithTimeZone() throws Exception {
        assertHitCount(searchResponse, 1L);
            prepareCreate("test").setMapping(
import static org.opensearch.index.query.QueryBuilders.idsQuery;
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("num:>20")).get();
                    .endObject()
        r.serialize(ByteBuffer.wrap(array));
            );
        searchResponse = client().prepareSearch("test")
                "type=integer",
        searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();
                // issue manifested only with shards>=2
            RestStatus.BAD_REQUEST,
            .get();
        assertFirstHit(searchResponse, hasId("1"));
                    .put("index.analysis.analyzer.lowercase_analyzer.type", "custom")
                .get();
        assertHitCount(searchResponse, 0L);
        indexRandomForConcurrentSearch("test");
            .setSource("num_byte", 2, "num_short", 2, "num_integer", 2, "num_long", 2, "num_float", 2, "num_double", 2)
    public void testMatchPhrasePrefixQuery() throws ExecutionException, InterruptedException {
            .get();
        assertHitCount(searchResponse, 1L);
            true,
        client().prepareIndex("test").setId("3").setSource("field1", "value3").get();
        for (String indexName : indexNames) {
        searchResponse = client().prepareSearch("test")
        assertFailures(
                "num_byte",
        searchResponse = client().prepareSearch("test")
            () -> client().prepareSearch().setQuery(queryStringQuery("future:[now/D TO now+2M/d]").lenient(false)).get()
            assertSearchHits(searchResponse, indexName + "1");
            .setQuery(spanNearQuery(spanTermQuery("description", "foo"), 3).addClause(spanTermQuery("description", "other")))
                .setTransientSettings(
            .minimumShouldMatch(2);
        client().prepareIndex("test").setId("4").setSource("score", 0.5).get();
    }
        );
        client().prepareIndex("test").setId("2").setSource("field1", "value2").get();
        assertThat(searchResponse.getHits().getAt(0).getId(), is("1"));
                    ).filter(boolQuery().mustNot(boolQuery().must(termQuery("field1", "value1")).must(termQuery("field1", "value2"))))
            assertThat((double) searchResponse.getHits().getAt(1).getScore(), closeTo(2.0, 0.1));
        assertFirstHit(searchResponse, hasId("1"));
        assertHitCount(searchResponse, 2L);
            2L
        assertHitCount(searchResponse, 2L);
        searchResponse = client().prepareSearch()
            client().prepareIndex("tl_test").setId("3").setSource("val", "3"),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        SearchResponse searchResponse = client().prepareSearch().setQuery(boolQuery).get();
                        .startObject()
            true,
     */
                    .endObject()
            .get();
            });
        );
        assertHitCount(searchResponse, 2L);
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("dbl", new double[] { 2, 5 }))).get();
            3L
        searchResponse = client().prepareSearch("test").setQuery(termsLookupQuery("term", new TermsLookup("lookup3", "1", "terms"))).get();
        assertHitCount(searchResponse, 1L);
                "type=short",
        searchResponse = client().prepareSearch("test").setQuery(termsQuery("num_double", new double[] { 1 })).get();
        SearchResponse searchResponse = client().prepareSearch("employees2")
            .setQuery(multiMatchQuery("the quick brown", "field1", "field2").cutoffFrequency(3).operator(Operator.AND))
    }
            true,
        client().prepareIndex("test").setId("1").setSource("score", 1.5).get();
                    .startObject("ts")
                    name,
        searchResponse = client().prepareSearch("test").setQuery(termsLookupQuery("_id", new TermsLookup("lookup", "1", "terms"))).get();
                        QueryBuilders.spanTermQuery("description", "fox")
        boolQuery = boolQuery().must(multiMatchQuery("a", "field1", "field2").zeroTermsQuery(MatchQuery.ZeroTermsQuery.ALL))
        assertNoFailures(searchResponse);
            client().prepareIndex("test").setId("1").setSource("field1", "quick brown fox", "field2", "quick brown fox"),
                        )
        assertHitCount(searchResponse, 0L);
            .endObject()
        indexRandom(
            .setSource("online", true, "ts", System.currentTimeMillis() - 123123, "type", "bs")
        client().prepareIndex("test").setId("1").setSource("field1", "value_1", "field2", "value_2").get();
        // Timezone set with dates
                        .endObject()
        BytesArray bitmapBytes = new BytesArray(bos.toByteArray());
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
                .setQuery(
            wildCardQuery = wildcardQuery("field1", "Bb*").caseInsensitive(true);
        searchResponse = client().prepareSearch("test")
            .get();
            client().prepareIndex("lookup").setId("1").setSource("terms", new String[] { "1", "3" }),
                }
            // test default case insensitivity: false
    public void testNumericTermsAndRanges() throws Exception {
                .get();
        r.add(1);
            true,
        assertHitCount(searchResponse, 1L);
            .startObject("properties")
    /**
            true,
            .get();
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("[VALUE_1 TO VALUE_3]")).get();
            .get();
        float boost = 10.0f;
 * KIND, either express or implied.  See the License for the
    public void testWildcardQueryNormalizationOnTextField() throws InterruptedException {
        SearchResponse searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();
        indexRandom(
                jsonBuilder().startObject()
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("num:<20")).get();
            assertSearchHits(searchResponse, indexName + "1");
        SearchResponse searchResponse = client().prepareSearch()
        assertHitCount(searchResponse, 2L);
        );
            client().prepareIndex("test").setId("1").setSource("term", "1"),
import java.time.ZoneId;
            .setPostFilter(boolQuery().should(rangeQuery("num_long").from(1).to(2)).should(rangeQuery("num_long").from(3).to(4)))
                        .endObject()
            prepareCreate("lookup2").setMapping(
        );
        for (String indexName : indexNames) {
            .get();
                ),
        refresh();
                "type=integer",
        createIndex("test");
        searchResponse = client().prepareSearch("test")
        }
            true,
            .setId("2")
        );
                            SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.getDefault(Settings.EMPTY)
                    jsonBuilder().startObject()
            .get();
        assertFirstHit(searchResponse, hasId("1"));
import static org.opensearch.index.query.QueryBuilders.spanMultiTermQueryBuilder;
        assertHitCount(searchResponse, 2L);
        assertHitCount(searchResponse, 1L);
        SearchResponse searchResponse = client().prepareSearch()
                .cluster()
            SearchResponse searchResponse = client().prepareSearch("test")
        assertFirstHit(searchResponse, hasId("2"));
        SearchResponse searchResponse = client().prepareSearch().setQuery(queryStringQuery("num:>19")).get();
        searchResponse = client().prepareSearch().setQuery(matchPhrasePrefixQuery("field", "try")).get();
        indexRandomForConcurrentSearch("index");
        assertThat(searchResponse.getHits().getAt(0).getId(), is("3"));
                "type=double"
            .field("distance", 42)
            client().prepareIndex("test").setId("2").setSource("term", "2"),
    }
        assertHitCount(searchResponse, 2L);
            .startObject()
        assertHitCount(response, 4);
import org.opensearch.common.regex.Regex;
                .get();
        WildcardQueryBuilder wildCardQuery = wildcardQuery("field", "la*");
            .startObject()
                .cluster()
        indexRandomForConcurrentSearch("test");
        client().prepareIndex("test").setId("2").setSource("field1", "value2").get();
            client().prepareIndex("test").setId("4").setSource("str", "4", "lng", 4L, "dbl", 4.0d)
    public void testQueryStringWithSlopAndFields() throws InterruptedException {
        assertSecondHit(searchResponse, hasId("2"));
        {
        }
        SearchPhaseExecutionException e = expectThrows(
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
        SearchResponse searchResponse = client().prepareSearch().setQuery(queryStringQuery("VALUE_3~1")).get();
import org.opensearch.search.SearchHits;
                jsonBuilder().startObject()
            .get();
            assertAcked(client().admin().indices().prepareCreate(indexName));
        assertHitCount(response, 3);
            prepareCreate("test").setMapping(
            .setSource(jsonBuilder().startObject().startObject("int_range").field("gte", 10).field("lte", 20).endObject().endObject())
        assertHitCount(searchResponse, 1L);
        indexRandomForConcurrentSearch("test");
                .get();
        indexRandomForConcurrentSearch("tl_lookup");
        indexRandomForConcurrentSearch("test");
        assertHitCount(searchResponse, 0L);
        }
        assertHitCount(searchResponse, 1L);
                .setSource(
import org.opensearch.common.unit.Fuzziness;
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("num:>11")).get();
        );
                    ),
            .setQuery(multiMatchQuery("value2", "field2").field("field1", 2).lenient(true))
            assertHitCount(searchResponse, 1L);
                )
        assertHitCount(searchResponse, 1L);
                    .field("type", "date")
        multiMatchQuery.minimumShouldMatch("100%");
        client().prepareIndex("test").setId("2").setSource("past", "2015-04-06T00:00:00+0000").get();
import static org.opensearch.index.query.QueryBuilders.termQuery;
import java.util.Map;
            .setQuery(queryStringQuery("\"phrase match\"").field("important", boost).field("less_important"))
        searchResponse = client().prepareSearch()
            .setSource("online", true, "bs", "X", "ts", System.currentTimeMillis() - 10000000, "type", "s")
    }
            .setQuery(queryStringQuery("past:[2015-04-06T00:00:00-0200 TO 2015-04-06T23:00:00-0200]").timeZone("+0200"))
            assertHitCount(searchResponse, indexNames.length);
import java.time.Instant;
 * You may obtain a copy of the License at
import org.apache.lucene.tests.util.English;
            .get();
        assertHitCount(searchResponse, 1L);
        int num = scaledRandomIntBetween(100, 200);
        assertHitCount(searchResponse, 4L);
        );
    }
        client().prepareIndex("test").setId("3").setSource("field1", "test2", "num_long", 3).get();
            .endObject()
                .cluster()
            client().prepareIndex("test").setId("2").setSource("term", "2"),
        assertThirdHit(searchResponse, hasId("3"));
        indexRandomForConcurrentSearch("test");
        );
                        )
            .setQuery(multiMatchQuery("value2", "field2").field("field1", 2).lenient(true))
            )
            client().prepareSearch().setQuery(matchPhraseQuery("field1", "quick brown").slop(0)),
        assertSearchHits(searchResponse, "1", "2");
     * {@link AttributeSource}.
        assertThirdHit(searchResponse, hasId("2"));
            )
                    boolQuery().must(matchAllQuery())
                return new Factory();
        assertHitCount(searchResponse, 2L);
        client().prepareIndex("test")
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("dbl", new float[] { 2, 4 }))).get();
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            true,
        assertHitCount(searchResponse, 2L);
                    spanNearQuery(QueryBuilders.spanTermQuery("description", "quick"), 1).addClause(
            client().prepareIndex("test").setId("3").setSource("term", "3"),
                .setTransientSettings(Settings.builder().putNull(SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.getKey()))
        searchResponse = client().prepareSearch("test")
        );
            client().prepareIndex("test").setId("1").setSource("important", "phrase match", "less_important", "nothing important"),
    public void testIdsQueryTestsIdIndexed() throws Exception {
            .setQuery(queryStringQuery("past:[2015-04-06T00:00:00+0200 TO 2015-04-06T23:00:00+0200]"))
        searchResponse = client().prepareSearch().setQuery(constantScoreQuery(existsQuery("field1"))).get();
        }
        SearchResponse searchResponse = client().prepareSearch().setQuery(queryStringQuery("str:foobaz~1")).get();
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, between(2, DEFAULT_MAX_NUM_SHARDS)))
        assertHitCount(searchResponse, 2L);
                .setId("3")
        SearchResponse response = client().prepareSearch("test").setQuery(wrapperQuery(json)).get();
        assertAcked(prepareCreate("test").setMapping("term", "type=text"));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            client().prepareIndex("test")
    public void testTermsLookupFilter() throws Exception {
        assertFirstHit(searchResponse, hasId("1"));
        createIndex("test");
        searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();
                "type=float",
        assertAcked(
        assertFirstHit(searchResponse, hasId("1"));
        searchResponse = client().prepareSearch().setQuery(existsQuery("field2")).get();
        assertHitCount(searchResponse, 2L);
                            SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.getKey(),
        }
        assertHitCount(searchResponse, 1L);
        assertAcked(
        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            client().prepareIndex("test").setId("2").setSource("field1", "the quick lazy huge brown fox jumps over the tree")
        assertFirstHit(searchResponse, hasId("2"));
        {
        searchResponse = client().prepareSearch()
        refresh();
                            .should(termQuery("field1", "value3"))
        SearchResponse searchResponse = client().prepareSearch("test")
import org.apache.lucene.tests.analysis.MockTokenizer;
            SearchResponse searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();
        searchResponse = client().prepareSearch()
        assertSearchHits(searchResponse, "1", "2");
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();
    }
        refresh();
            .setQuery(termsLookupQuery("term", new TermsLookup("lookup", "missing", "terms")))
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);
        assertThat(searchResponse.getHits().getAt(0).getId(), is("1"));
            assertHitCount(searchResponse, 1);
            client().prepareIndex("tl_lookup").setId("1").setSource("val", "1"),
            client().prepareIndex("test").setId("1").setSource("description", "foo other anything bar"),
        SearchResponse searchResponse = client().prepareSearch("test")
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("str", "2", "5"))).get();
        assertHitCount(searchResponse, 1L);
            .must(multiMatchQuery("value4", "field1", "field2").zeroTermsQuery(MatchQuery.ZeroTermsQuery.ALL));
        indexRandom(
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("num:>=20")).get();
                    .startObject("properties")
        refresh();
        indexRandomForConcurrentSearch("test");
        indexRandomForConcurrentSearch("test");
                    .endObject()
        );
            .get();
import org.roaringbitmap.RoaringBitmap;
import org.opensearch.index.query.functionscore.ScoreFunctionBuilders;
            .addAggregation(AggregationBuilders.terms("field1").field("field1.keyword"))
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch().setQuery(matchQuery("double", "2")).get();
        MultiMatchQueryBuilder multiMatchQuery = multiMatchQuery("value1 value2 foo", "field1", "field2");
            client().prepareIndex("test").setId("2").setSource("field1", "value2"),
        assertHitCount(searchResponse, 2L);
                    // Both index and doc values enabled (default)
            SearchResponse searchResponse = client().prepareSearch("test")
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("future:[now/d TO now+2M/d]")).get();
            // Set max_clause_count to 3, which should limit fetchSize to 3
        client().prepareIndex("test").setId("1").setSource("field", "label-1").get();
        bitmap.serializePortable(dos);
            searchResponse = client().prepareSearch("test_1")
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("field\\*:v?lue*")).get(), 1);
            prepareCreate("test")
        indexRandom(
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termQuery("num_float", 1))).get();
    private void assertHits(SearchHits hits, String... ids) {
import java.nio.ByteBuffer;
            SearchResponse searchResponse = client().prepareSearch("test")
        searchResponse = client().prepareSearch("test").setQuery(termsLookupQuery("term", new TermsLookup("lookup", "2", "terms"))).get();
                .setPostFilter(QueryBuilders.termQuery("type", "product"))
        refresh();
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("v?l*e?1")).get();
                .setTransientSettings(Settings.builder().putNull(IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey()))
        searchResponse = client().prepareSearch("test")
        indexRandomForConcurrentSearch("test");
    }
            client().prepareIndex("test").setId("2").setSource("description", "foo other anything"),
            SearchResponse request = client().prepareSearch().setQuery(constantScoreQuery(matchQuery("_index", indexName))).get();
            .get();
                            constantScoreQuery(matchQuery("field1", "quick")).boost(
        assertHitCount(searchResponse, 2L);
            .setQuery(
                    .setQuery(termsLookupQuery("val", new TermsLookup("tl_lookup", null, "val", matchAllQuery())))
        );
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        client().prepareIndex("test")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        indexRandomForConcurrentSearch("test");
    public void testTermsLookupSubqueryRespectsMaxClauseCount() throws Exception {
            .setQuery(matchQuery("field1", "the quick brown").cutoffFrequency(3).operator(Operator.AND))
        indexRandomForConcurrentSearch("test");
     */
        assertHitCount(searchResponse, 1L);
            + "                       { \"match\" : { \"query\" : \"cold\" } },"
            .get();
    /**
        indexRandomForConcurrentSearch("test");
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1)));
        indexRandom(
            assertHitCount(searchResponse, 1L);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
        // test case sensitive
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch("test")
        assertHitCount(searchResponse, 3L);
            client().prepareIndex("tl_lookup").setId("2").setSource("val", "2"),
        assertThat(searchResponse.getHits().getAt(0).getId(), is("3"));
            .indices()
                    .endObject()
        searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();
        assertHitCount(searchResponse, 1L);
        indexRandomForConcurrentSearch("test");
            .setQuery(commonTermsQuery("field1", "the quick brown").cutoffFrequency(3).lowFreqOperator(Operator.OR))
    public void testTermsQueryWithBitmap64DocValuesQuery() throws Exception {
    }
        assertHitCount(searchResponse, 2L);
        assertFirstHit(searchResponse, hasId("1"));
                .setId("3")
        client().prepareIndex("test").setId("1").setSource("past", "2015-04-05T23:00:00+0000").get();
                .prepareUpdateSettings()
        int iters = scaledRandomIntBetween(100, 200);
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
        client().prepareIndex("test").setId("1").setSource("past", aMonthAgo, "future", aMonthFromNow).get();
                (indexSettings, environment, name, settings) -> TokenizerFactory.newFactory(
        searchResponse = client().prepareSearch()
            prepareCreate("test").setSettings(
            .get();
import org.opensearch.index.search.MatchQuery;
        assertFirstHit(searchResponse, hasId("2"));
            MatchQueryBuilder matchQuery = matchQuery("f", English.intToEnglish(between(0, num)));
import org.opensearch.action.index.IndexRequestBuilder;
        assertHitCount(searchResponse, 1L);
            client().prepareIndex("tl_test").setId("6").setSource("val", "6")
            true,
public class SearchQueryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertFirstHit(searchResponse, hasId("1"));
 * compatible open source license.
                        boolQuery().should(termQuery("field1", "value1"))
            assertThat(i + " expected: " + first + " actual: " + actual, Float.compare(first, actual), equalTo(0));
        createIndex("test");
                        .endObject()
        assertHitCount(searchResponse, 1L);
        assertFirstHit(searchResponse, hasId("1"));
        assertAcked(prepareCreate("index").setMapping(mapping));
                .setPostFilter(QueryBuilders.termQuery("type", "customer"))
        assertNoFailures(response);
        MultiMatchQueryBuilder builder = multiMatchQuery("value1 value2 value4", "field1", "field2");
    public void testDateRangeInQueryStringWithTimeZone_10477() throws InterruptedException {
        searchResponse = client().prepareSearch().setQuery(matchQuery("text", "uniy").fuzziness(Fuzziness.customAuto(5, 7))).get();
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("vAl*E_1")).get();
    }
        refresh();
        assertHitCount(searchResponse, 1L);
        assertFirstHit(searchResponse, hasId("1"));
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("val*e_1")).get();
                .get();
        assertSearchHits(searchResponse, "1", "3", "4");
        refresh();
            .setId("2")
            )
            client().prepareIndex("test").setId("3").setSource("description", "foo other"),
                    .startObject("product")
        assertHitCount(searchResponse, 3L);
    public void testWildcardQueryNormalizationOnKeywordField() throws InterruptedException {
                        .startArray("arr")
                                1.0f + (random.nextBoolean() ? 0.0f : random.nextFloat())
        assertSearchHits(searchResponse, "1", "3");
        );
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);
            ).setMapping("field1", "type=text,analyzer=lowercase_analyzer")
            .setQuery(
        assertFirstHit(searchResponse, hasId("2"));
            .get();
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            closeTo(boost * searchResponse.getHits().getAt(1).getScore(), .1)
     * as "Dez" for "Dezember (December)".
        assertHitCount(searchResponse, 2L);
    }
            .setVersion(true)
        assertSearchHits(searchResponse, "1", "2");
    }
            .field("path", "section.distance")
 *
        assertFirstHit(searchResponse, hasId("2"));
            .setQuery(termsLookupQuery("term", new TermsLookup("lookup2", "3", "arr.term")))
                                                                                                          // inside a field! Fields are
            .setQuery(matchQuery("field1", "the quick brown").cutoffFrequency(3).operator(Operator.OR))
        indexRandom(
        assertHitCount(searchResponse, 0L);
        assertHitCount(searchResponse, 1L);
            client().prepareSearch()
                )
        response = client().prepareSearch("test").setQuery(wildcardQuery("field", "Text").caseInsensitive(true)).get();
            client().prepareIndex("tl_lookup").setId("4").setSource("val", "4"),
            client().prepareIndex("test").setId("3").setSource("field1", "value3")
            .get();
            .get();
        multiMatchQuery.minimumShouldMatch("30%");
import org.opensearch.common.settings.Settings;
        assertAcked(
        assertFirstHit(searchResponse, hasId("1"));
        assertThat(
        assertHitCount(searchResponse, 2L);
        super(staticSettings);
        SearchResponse searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();
            .startObject("section")
        client().prepareIndex("test").setId("2").setSource("desc", "one two three", "type", "product").get();
    public void testMatchQueryNumeric() throws Exception {
        ensureGreen();
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();
                .setQuery(QueryBuilders.queryStringQuery("\"one two\"").defaultField("desc"))
            SearchResponse searchResponse = client().prepareSearch("test")
                )
        assertHitCount(searchResponse, 1L);
            .startObject("properties")
        assertAcked(prepareCreate("tl_lookup").setMapping("val", "type=keyword"));
            // The IllegalArgumentException may be wrapped in SearchPhaseExecutionException
                    .get()
        assertThat(hits.getTotalHits().value(), equalTo((long) ids.length));
        float first = response.getHits().getAt(0).getScore();
            .get();
        assertFirstHit(searchResponse, hasId("1"));
            .setQuery(queryStringQuery("past:[2015-04-06T00:00:00-0200 TO 2015-04-06T23:00:00-0200]"))
        indexRandom(
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T01:00:00").to("2014-01-01T01:59:00"))
            .startObject("distance")
import org.opensearch.index.analysis.NormalizingCharFilterFactory;
        // this uses dismax so scores are equal and the order can be arbitrary
        searchResponse = client().prepareSearch("test").setQuery(termsLookupQuery("term", new TermsLookup("lookup", "1", "terms"))).get();
        assertAcked(prepareCreate("test").setMapping("field1", "type=text,analyzer=classic", "field2", "type=text,analyzer=classic"));
                    .startObject("properties")
        refresh();
            + "{ \"description\": { "
        bitmap.addLong(4000000000004L);
import java.util.concurrent.ExecutionException;
                    XContentFactory.jsonBuilder()
        assertSecondHit(searchResponse, hasId("1"));
    public void testFieldAliasesForMetaFields() throws Exception {
        assertHitCount(searchResponse, 0L);
                ),
        client().prepareIndex("test")
        RoaringBitmap r = new RoaringBitmap();
                        .field("obj2_val", "1")
            .get();
            WildcardQueryBuilder wildCardQuery = wildcardQuery("field1", "Bb*");
import static org.hamcrest.Matchers.closeTo;
            .endObject()
            .setQuery(
                        .field("term", "2")
        indexRandomForConcurrentSearch("test");
        multiMatchQuery = multiMatchQuery("value1 value2 bar", "field1");
import java.util.Arrays;
        indexRandom(
import org.apache.lucene.search.join.ScoreMode;
                        .startObject("obj1")
        SearchResponse searchResponse = client().prepareSearch("employees")
            assertHitCount(searchResponse, 1);
        assertHitCount(searchResponse, 1L);
        assertAcked(prepareCreate("test").setMapping("field1", "type=text,index_options=docs"));
            client().prepareIndex("test").setId("2").setSource("description", "foo other anything"),
        );
    /**
        );
        response = client().prepareSearch("test").setQuery(spanOrQuery(spanMultiTermQueryBuilder(prefixQuery("description", "fo")))).get();
                    @Override
            true,
        response = client().prepareSearch("test")
        createIndex("test");
            )
        assertSearchHits(searchResponse, "1", "3", "4");
        }
    public void testFiltersWithCustomCacheKey() throws Exception {
    public void testMultiMatchQuery() throws Exception {
            )
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            .setQuery(termsLookupQuery("term", new TermsLookup("lookup2", "2", "arr.term")))
        SearchResponse searchResponse = client().prepareSearch("test")
        logger.info("--> terms filter on 1");
    // see #2926
            client().prepareIndex("test").setId("1").setSource("description", "foo other anything bar"),
        // This made 2826 fail! (only with bit based filters)
        String aMonthAgo = DateTimeFormatter.ISO_LOCAL_DATE.format(now.minusMonths(1));
        builder = multiMatchQuery("value1").field("field1").field("field3", 1.5f).operator(Operator.AND); // Operator only applies on terms
    public void testMultiMatchLenientIssue3797() throws InterruptedException {
            .setQuery(builder)
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
            String errorMsg = ex.getMessage() != null ? ex.getMessage() : ex.getCause().getMessage();
        indexRandomForConcurrentSearch("test");
                        .endObject()
        // We define a time zone to be applied to the filter and from/to have no time zone
        BoolQueryBuilder query = boolQuery().filter(spanMultiTermQueryBuilder(fuzzyQuery("field", "foobarbiz").rewrite("constant_score")));
        byte[] array = new byte[r.serializedSizeInBytes()];
        assertHitCount(searchResponse, 4L);
        assertHitCount(searchResponse, 1L);
            .setQuery(QueryBuilders.rangeQuery("date").from("2013-12-31T23:00:00Z").to("2013-12-31T23:59:00Z").timeZone("+10:00"))
        assertHitCount(client().prepareSearch().setQuery(queryStringQuery("quick")).get(), 3L);
            client().prepareIndex("lookup").setId("2").setSource("terms", new String[] { "2" }),
            DocumentField field = hit.getFields().get("id-alias");
     * See https://github.com/elastic/elasticsearch/issues/46300 for details.
        waitForRelocation();
        assertAcked(
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("ValUE_*")).get();
            .field("type", "alias")
            )
        }
        assertHitCount(searchResponse, 2L);
                    .endObject()
    // Issue #3540
            .startObject("section")
                            .should(termQuery("field1", "value2"))
import java.time.ZonedDateTime;
        searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("1", "2", "3", "4")).get();
            client().prepareIndex("test").setId("4").setSource("field", 1000000000002L),
import org.opensearch.index.analysis.CharFilterFactory;
    public void testSpanMultiTermQuery() throws IOException, InterruptedException {
        searchResponse = client().prepareSearch().setQuery(matchQuery("text", "uniy").fuzziness(Fuzziness.AUTO)).get();
                    .endObject()
                .setSource("field1", "quick lazy huge brown pidgin", "field2", "the quick lazy huge brown fox jumps over the tree"),
            prepareCreate("test").setSettings(
    public void testTermsQueryWithBitmapDocValuesQuery() throws Exception {
                    spanNearQuery(QueryBuilders.spanTermQuery("description", "quick"), 1).addClause(
            bitmap.serializePortable(dos);
import org.opensearch.search.aggregations.AggregationBuilders;
        indexRandomForConcurrentSearch("lookup3");
    public void testWildcardQueryNormalizationKeywordSpecialCharacters() throws InterruptedException {
            SearchResponse searchResponse = assertSearchResponse(request);
                        )
        assertHitCount(searchResponse, 2L);
        // cutoff frequency of 100 makes all terms low frequency, so lowFreqMinimumShouldMatch=3
            client().prepareIndex("test")
import org.apache.lucene.search.MultiTermQuery;
        }
     * Test range with a custom locale, e.g. "de" in this case. Documents here mention the day of week
        for (int i = 0; i < builders.length; i++) {
        );
            SearchResponse searchResponse = client().prepareSearch("tl_test")
        }
                                                                                                          // always OR-ed together.
    @ParametersFactory
                        .must(boolQuery().mustNot(boolQuery().must(termQuery("field1", "value1")).must(termQuery("field1", "value2"))))
        logger.info(" --> Using time_zone [{}], now is [{}]", timeZone.getId(), now);
        assertHitCount(searchResponse, 1L);
        }
        assertAcked(prepareCreate("test").setMapping("long", "type=long", "double", "type=double"));
        {
    }
                    .endObject()
        assertHitCount(searchResponse, 1L);
    public void testLowercaseExpandedTerms() throws InterruptedException {
        assertFirstHit(searchResponse, hasId("1"));
        assertHitCount(searchResponse, 1L);
                boolQuery().must(termQuery("online", true))
import static java.util.Collections.singletonMap;
        createIndex("test");
        assertHitCount(searchResponse, 2L);
                .setPostFilter(QueryBuilders.termQuery("type", "customer"))
                    spanTermQuery("description", "sleeping")
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("dbl", new double[] { 5, 6 }))).get();
        indexRandomForConcurrentSearch("test");
                    .endObject()
 * Modifications Copyright OpenSearch Contributors. See
        assertHitCount(searchResponse, 0L);
                QueryBuilders.rangeQuery("date_field").gte("Di., 05 Dez. 2000 02:55:00 -0800").lte("Fr., 08 Dez. 2000 00:00:00 -0800")
            assertThat(hits.getTotalHits().value(), equalTo(totalHits));
            )
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("value*").field("field1").field("field2")).get(), 1);
            client().prepareIndex("test").setId("1").setSource("str", "1", "lng", 1L, "dbl", 1.0d),
                    .endObject()
        assertHitCount(response, 4);
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("num_long", new int[] { 1 }))).get();
        assertFirstHit(searchResponse, hasId("1"));
    }
            .endObject()
        );
        searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("1", "2")).get();
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("dbl", new double[] { 2, 3 }))).get();
        );
 * Licensed to Elasticsearch under one or more contributor
import static org.hamcrest.Matchers.containsString;
        assertHitCount(searchResponse, 0L);
        assertFirstHit(searchResponse, hasId("1"));
        try {
            )
            assertHitCount(searchResponse, 2L);
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("_exists_:field1")).get();
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T00:00:00Z").to("2014-01-01T00:59:00Z").timeZone("+10:00"))
    }
                    Settings.builder()
        client().prepareIndex("test").setId("2").setSource("score", 1.0).get();
        indexRandomForConcurrentSearch("test");
        logger.info("--> term filter on 1");
    // see https://github.com/elastic/elasticsearch/issues/3177
            client().prepareIndex("test").setId("4").setSource("description", "foo")
    public void testSimpleDFSQuery() throws IOException, InterruptedException {
        indexRandomForConcurrentSearch("test");
            .get();
            .get();
        searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();
            SearchHit hit = searchResponse.getHits().getAt(0);
        r.add(4);
        assertFirstHit(searchResponse, hasId("2"));
        assertHitCount(searchResponse, 0L);
                    .startObject("employee_id")
            .get();
     * asserts the search response hits include the expected ids
        SearchResponse searchResponse = client().prepareSearch().setQuery(boolQuery).get();
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("field1", "value1"))).get();
            assertHitCount(searchResponse, 1L);
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("v?lue*").field("field1").field("field2")).get(), 1);
        assertHitCount(
        builder = multiMatchQuery("value1", "field1", "field2").operator(Operator.AND); // Operator only applies on terms inside a field!
        assertFirstHit(searchResponse, hasId("1"));
        );
                        .field("term", "1")
        indexRandom(
        refresh();
import java.io.ByteArrayOutputStream;
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termQuery("num_short", 1))).get();
            WildcardQueryBuilder wildCardQuery = wildcardQuery("field1", "Bb*");
 * not use this file except in compliance with the License.
        client().prepareIndex("test").setId("1").setSource("str", "foobar", "date", "2012-02-01", "num", 12).get();
        refresh();
import java.util.Collection;
        // try the same with match query
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T01:00:00Z").to("2014-01-01T01:59:00Z").timeZone("+10:00"))
                .setSource(
        client().admin()
        }
        SearchResponse searchResponse = client().prepareSearch("products")
            )
        assertFirstHit(searchResponse, hasId("1"));
    }
                        .field("y1", "y_1")
        searchResponse = client().prepareSearch("test").setQuery(termQuery("num_long", 1)).get();
        assertHitCount(searchResponse, 2L);
            client().prepareIndex("test").setId("2").setSource("foo", "bar")
            assertHitCount(searchResponse, 1L);
                        QueryBuilders.spanTermQuery("description", "fox")
                for (SearchHit searchHit : hits) {
        assertHitCount(searchResponse, 2L);
                    .field("ignore_malformed", false)
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("field\\*:value~")).get(), 1);
        assertSearchHits(searchResponse, "2", "4");
    }
            client().prepareIndex("lookup2")
            .setQuery(matchPhrasePrefixQuery("field", "Johnnie la").slop(between(2, 5)))
            client().prepareIndex("test").setId("3").setSource("description", "foo other"),
            .setQuery(constantScoreQuery(termsQuery("employee_id", bitmapBytes).valueType(TermsQueryBuilder.ValueType.BITMAP)))
        SearchResponse searchResponse = client().prepareSearch()
                    ),
    /** tests wildcard case sensitivity */
        assertSecondHit(searchResponse, hasId("2"));
        assertHitCount(searchResponse, 2L);
                    .endObject()
    // Issue #7880
import org.opensearch.common.document.DocumentField;
        // conjunction of all terms (the lowFreqMinimumShouldMatch parameter is effectively ignored)
    public void testBasicQueryById() throws Exception {
            assertThat(errorMsg, containsString("exceed fetch limit"));
            searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();
            .startObject("properties")
            RestStatus.BAD_REQUEST,
        // Default
    }
    * Test that wildcard queries on keyword fields get normalized
        // test partial matching
            true,
        searchResponse = client().prepareSearch().setQuery(existsQuery("field3")).get();
        searchResponse = client().prepareSearch().setQuery(constantScoreQuery(termsQuery("_id", "1", "3"))).get();
            client().prepareIndex("test").setId("6").setSource("field", 999999999999L)
            + "           \"ordered\" : \"true\","
                    .field("type", "text")
            .setId("17")
        assertHitCount(searchResponse, 1L);
        assertAcked(client().admin().indices().preparePutMapping("test").setSource("field", "type=date,format=epoch_millis").get());
        {
    /**
        assertThat(searchResponse.getHits().getAt(0).getId(), is("3"));
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
        assertSearchHits(searchResponse, "1", "2");
        assertThat(e.toString(), containsString("unit [D] not supported for date math"));
            assertHitCount(searchResponse, 1L);
        createIndex("test");
        assertNoFailures(searchResponse);
                        .startArray("arr")
        );
            .endObject();
        client().prepareIndex("test").setId("1").setSource("field1", new String[] { "value1", "value2", "value3" }).get();
        refresh();
        assertAcked(prepareCreate("test").setMapping("past", "type=date", "future", "type=date"));
                jsonBuilder().startObject()
                .setPostFilter(QueryBuilders.termQuery("type", "customer"))
                    .startObject("properties")
                constantScoreQuery(
                )
    }
        searchResponse = client().prepareSearch("test").setQuery(termsQuery("num_short", new int[] { 1 })).get();
        searchResponse = client().prepareSearch("test")
            + "                       { \"match\" : { \"query\" : \"outside\" } } ] } },"
        assertHitCount(searchResponse, 1L);
        refresh();
            client().prepareIndex("products").setId("1").setSource("product", 1),
        assertThirdHit(searchResponse, hasId("3"));
        multiMatchQuery.minimumShouldMatch("70%");
                        .endArray()
        );
            client().prepareIndex("test").setId("3").setSource("date", "2014-01-01T01:00:00", "num", 3),
        createIndex("test");
import static org.opensearch.index.query.QueryBuilders.regexpQuery;
            .setQuery(constantScoreQuery(termsQuery("employee_id", bitmapBytes).valueType(TermsQueryBuilder.ValueType.BITMAP)))
            client().prepareIndex("test").setId("2").setSource("text", "Unity")
            .setQuery(matchAllQuery())
        );
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("value~").field("field1").field("field2")).get(), 1);
                .addDocValueField("id-alias")
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch("test").setQuery(termsQuery("num_integer", new int[] { 1 })).get();
        )
        assertFirstHit(searchResponse, hasId("1"));
        for (int i = 0; i < queryRounds; i++) {
                )
                        .startObject("obj2")
            client().prepareIndex("test").setId("4").setSource("term", "4")
        assertHitCount(searchResponse, 0L);
            .prepareUpdateSettings()
                        .field("obj1_val", "1")
                .setId("2")
            client().prepareIndex("test").setId("1").setSource("field1", "quick brown fox", "field2", "quick brown fox"),
                    .startObject("properties")
    }
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        String json = "{ \"intervals\" : "
            .setQuery(commonTermsQuery("field1", "the lazy fox brown").cutoffFrequency(1).highFreqMinimumShouldMatch("3"))
import org.opensearch.action.search.SearchPhaseExecutionException;
                QueryBuilders.rangeQuery("date_field").gte("Di., 05 Dez. 2000 02:55:00 -0800").lte("Do., 07 Dez. 2000 00:00:00 -0800")
 * under the License.
        // stop drops "the" since its a stopword
        assertHitCount(searchResponse, 3L);
    }
     */
import org.roaringbitmap.longlong.Roaring64NavigableMap;
            .get();
        indexRandom(
        assertThat(searchResponse.getHits().getAt(0).getId(), is("2"));
    public void testSearchEmptyDoc() throws InterruptedException {
        searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("1")).get();
        String[] indexNames = { "test1", "test2" };
                        .field("field1", "value1_2")
                    .field("index", false)
                () -> client().prepareSearch("tl_test")
 * specific language governing permissions and limitations
            .minimumShouldMatch(1);
import static org.hamcrest.Matchers.equalTo;
        refresh();
        searchResponse = client().prepareSearch("test")
                    .startObject("properties")
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("lng", new long[] { 2, 3 }))).get();
        assertHitCount(searchResponse, 2L);
        response = client().prepareSearch("test")
            client().prepareIndex("test").setId("2").setSource("important", "nothing important", "less_important", "phrase match")
        indexRandomForConcurrentSearch("test");
            .get();
        assertAcked(prepareCreate("test").setMapping("past", "type=date"));
        assertHitCount(client().prepareSearch("test").setSize(0).setQuery(rangeQuery("field").gte(999999999999L)).get(), 6);
        client().prepareIndex("test").setId("1").setSource("description", "foo other anything bar", "count", 1).get();
            // test case insensitivity set to true
        boolQuery = boolQuery().must(termQuery("field1", "value1"))
        assertHitCount(searchResponse, 1L);
            .setId("3")
        // cutoff frequency of 1 makes all terms high frequency so the query gets rewritten as a
                "type=byte",
    }
        assertFailures(
        assertSearchHits(searchResponse, "2");
        searchResponse = client().prepareSearch("test")
                .setSource(
            + "           \"max_gaps\" : 30 } } } }";
        assertSecondHit(searchResponse, hasId("2"));
        assertAcked(prepareCreate("lookup3").setMapping("_source", "enabled=false", "terms", "type=text"));
        indexRandomForConcurrentSearch("test");
            .setQuery(
            SearchResponse request = client().prepareSearch().setQuery(constantScoreQuery(termsQuery("_index", indexNames))).get();
            wildCardQuery = wildcardQuery("field1", "bb*");
    public void testTermsQuery() throws Exception {
        assertHitCount(searchResponse, 1L);
            hitIds.add(hit.getId());
        assertFirstHit(searchResponse, hasId("1"));
        client().prepareIndex("test").setId("1").setSource("description", "the quick brown fox jumped over the lazy dog").get();
            // Only one should clause is defined, returns no docs.
            }
            .get();
            .setQuery(spanOrQuery(spanMultiTermQueryBuilder(QueryBuilders.rangeQuery("description").from("ffa").to("foo"))))
        assertFirstHit(searchResponse, hasId("1"));
    }
        assertHitCount(searchResponse, 2L);
import static org.opensearch.index.query.QueryBuilders.prefixQuery;
        assertHitCount(searchResponse, 2L);
                "type=long",
            client().prepareIndex("test").setId("2").setSource("date_field", "Do., 07 Dez. 2000 02:55:00 -0800")
        searchResponse = client().prepareSearch("test").setQuery(termsQuery("num_long", new int[] { 1 })).get();
        }
import java.util.Set;
            client().prepareIndex("test").setId("1").setSource("field1", "the quick brown fox jumps"),
        assertHitCount(searchResponse, 1);
                        .field("term", "3")
import org.opensearch.test.junit.annotations.TestIssueLogging;
            client().prepareIndex("test").setId("2").setSource("field1", "quick brown"),
            .get();
                    spanTermQuery("description", "jumped")
                    .field("type", "long")
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch().setQuery(commonTermsQuery("field1", "the lazy fox brown").cutoffFrequency(1)).get();
        assertAcked(
                .setQuery(matchAllQuery())
            .setQuery(QueryBuilders.rangeQuery("date").from("now/d-1d").timeZone("+01:00"))
            .get();
        // the mapping needs to be provided upfront otherwise we are not sure how many failures we get back
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);
        );
                .setSize(num)
        assertHitCount(searchResponse, 2L);
        indexRandom(
        // test case insensitive
        assertHitCount(searchResponse, 1L);
                        QueryBuilders.spanTermQuery("description", "fox")
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;
    public void testDateProvidedAsNumber() throws InterruptedException {
            assertHitCount(searchResponse, 1);
        );
        assertHitCount(client().prepareSearch().setQuery(wrapper).get(), 1L);
        assertSecondHit(searchResponse, hasId("3"));
                    .field("type", "date")
        assertSearchHits(searchResponse, "2", "3");
                    .build()
                    .startObject("bs")
        return 7;
            .setFrom(0)
                        .field("obj1_val", "1")
import static org.opensearch.index.query.QueryBuilders.spanNearQuery;
        assertHitCount(searchResponse, 2L);
import static org.opensearch.index.query.QueryBuilders.termsQuery;
        // We explicitly define a time zone in the from/to dates so whatever the time zone is, it won't be used
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 2L);
            client().prepareIndex("lookup").setId("3").setSource("terms", new String[] { "2", "4" }),
        assertFirstHit(searchResponse, hasId("1"));
            containsString("field:[field1] was indexed without position data; cannot run PhraseQuery")
        assertSearchHits(searchResponse, "1", "3");
                    .endObject()
        assertSearchHits(searchResponse, "2", "4");
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();
        assertAcked(client().admin().indices().prepareCreate("test"));
            3L
                ),
            client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value4", "field3", "value3"),
        searchResponse = client().prepareSearch().setQuery(commonTermsQuery("field1", "the quick brown").cutoffFrequency(3)).get();
        assertHitCount(searchResponse, 1L);
        bitmap.addLong(1000000000001L);
            return singletonMap("mock_pattern_replace", (indexSettings, env, name, settings) -> {
    public void testConstantScoreQuery() throws Exception {
            true,
            .field("type", "nested")
    @Override
    }
            // Reset transient setting
            .must(matchQuery("field1", "value1").zeroTermsQuery(MatchQuery.ZeroTermsQuery.ALL));
        assertAcked(prepareCreate("tl_test").setMapping("val", "type=keyword"));
        return Arrays.asList(
        assertHitCount(searchResponse, 1L);
import org.opensearch.core.xcontent.XContentBuilder;
    public void testBoolQueryMinShouldMatchBiggerThanNumberOfShouldClauses() throws IOException, InterruptedException {
        assertHitCount(searchResponse, 1L);
    public void testAllDocsQueryString() throws InterruptedException, ExecutionException {
        RangeQueryBuilder range = new RangeQueryBuilder("int_range").relation("intersects").from(Integer.MIN_VALUE).to(Integer.MAX_VALUE);
package org.opensearch.search.query;
        );
                        .must(constantScoreQuery(matchQuery).boost(1.0f + (random.nextBoolean() ? 0.0f : random.nextFloat())))
import org.opensearch.test.InternalSettingsPlugin;
                    .field("type", "boolean")
                            .should(
    public void testIntervals() throws InterruptedException {
import org.opensearch.common.lucene.search.SpanBooleanQueryRewriteWithMaxClause;
            for (SearchHit searchHit : hits) {
        BoolQueryBuilder boolQuery = boolQuery().must(
    }
                            )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasScore;
        assertHitCount(searchResponse, 3L);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
        }
        XContentBuilder source = XContentFactory.jsonBuilder()
     */
        assertSearchHits(searchResponse, "1", "2");
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("*ue*")).get();
        {
        searchResponse = client().prepareSearch("test").setQuery(termsQuery("num_byte", new int[] { 1 })).get();
        assertAcked(prepareCreate("test").setMapping("past", "type=date"));
    }
            .setMapping("field1", "type=text,analyzer=whitespace")
            assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        assertSearchHits(searchResponse, "1", "3");
        }
            float actual = response.getHits().getAt(0).getScore();
        assertSearchHits(searchResponse, "3", "1");
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchQuery("text", "uniy").fuzziness(Fuzziness.ZERO)).get();
        assertFirstHit(searchResponse, hasId("2"));
        assertFirstHit(searchResponse, hasScore(searchResponse.getHits().getAt(1).getScore()));
import static org.opensearch.index.query.QueryBuilders.spanOrQuery;
        searchResponse = client().prepareSearch().setQuery(builder).get();
        assertHitCount(searchResponse, 1L);
    }
                    .put("index.analysis.normalizer.lowercase_normalizer.type", "custom")
                "num_long",
            client().prepareSearch()
        createIndex("test");
            multiMatchQuery("a", "field1", "field2").zeroTermsQuery(MatchQuery.ZeroTermsQuery.NONE)
        assertHitCount(searchResponse, 2L);
                .setSource(
        // Index 6 docs in the lookup index and matching docs in the test index
        assertHitCount(searchResponse, 1L);
        client().prepareIndex("test").setId("1").setSource("past", now).get();
            .endObject()
        indexRandom(
        assertHitCount(searchResponse, 2L);
    }
            .setQuery(matchQuery("field1", "the quick brown").cutoffFrequency(3).operator(Operator.AND).analyzer("stop"))
        assertFirstHit(searchResponse, hasId("1"));
                "num_long",
        client().prepareIndex("test").setId("1").setSource("field1", new String[] { "value1", "value2", "value3" }).get();
        assertFirstHit(searchResponse, hasId("1"));
                    .must(
                            )
            assertHitCount(searchResponse, 1);
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
 * Unless required by applicable law or agreed to in writing,
                    .should(rangeQuery("num_long").from(3).to(4))
            SearchPhaseExecutionException.class,
                .setId("4")
        searchResponse = client().prepareSearch("test")
            searchResponse = client().prepareSearch("test_1").setQuery(constantScoreQuery(matchQuery)).setSize(num).get();
        indexRandom(
            )
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                .prepareUpdateSettings()
            builders[i] = client().prepareIndex("test_1").setId("" + i).setSource("f", English.intToEnglish(i));
import static org.opensearch.index.query.QueryBuilders.fuzzyQuery;
    @TestIssueLogging(value = "org.opensearch.search.query.SearchQueryIT:DEBUG", issueUrl = "https://github.com/elastic/elasticsearch/issues/43144")
    }
        assertHitCount(response, 1);
                        boolQuery().should(
            )
                    .should(rangeQuery("num_long").from(1).to(2))
        assertHitCount(searchResponse, 3L);
        refresh();
        assertHitCount(searchResponse, 1L);
    // see #2994
            .setQuery(commonTermsQuery("field1", "the quick brown").cutoffFrequency(3).lowFreqOperator(Operator.AND))
                .get();
import org.apache.lucene.search.IndexSearcher;
            true,
            .get();
        multiMatchQuery.minimumShouldMatch("30%");
                class Factory implements NormalizingCharFilterFactory {
        assertSecondHit(searchResponse, hasId("2"));
            assertHitCount(searchResponse, 0L);
            client().prepareIndex("test1").setId("2").setSource("field", "trying out OpenSearch")
                .setSource(
        );
        BytesArray bitmapBytes = new BytesArray(bos.toByteArray());
            searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();
            ).setMapping("field", "type=keyword,normalizer=no_wildcard")
        assertAcked(
        assertAcked(prepareCreate("test").setMapping("field1", "type=text,analyzer=classic", "field2", "type=text,analyzer=classic"));
        searchResponse = client().prepareSearch("test")
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        boolQuery = boolQuery().should(termQuery("field1", "value1"))
            .field("type", "alias")
    }
            .get();
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
                        .must(
            .get();
            .setQuery(spanOrQuery(spanMultiTermQueryBuilder(regexpQuery("description", "fo{2}"))))
        multiMatchQuery.minimumShouldMatch("4");
                    .build()
        assertHitCount(
                        .endArray()
                    }
 * The OpenSearch Contributors require contributions made to
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.index.query.MultiMatchQueryBuilder;
        createIndex("test");
        client().prepareIndex("test").setId("2").setSource("field2", "value1").get();
                )
    }
        client().prepareIndex("test").setId("3").setSource("field1", "value3").get();
        SearchResponse searchResponse = client().prepareSearch().setQuery(existsQuery("field1")).get();
            client().prepareIndex("tl_test").setId("5").setSource("val", "5"),
        builder = multiMatchQuery("value1", "field1").field("field3", 1.5f).operator(Operator.AND); // Operator only applies on terms inside
        assertHitCount(searchResponse, 1L);
        SearchResponse response = client().prepareSearch("test")
            .get();
                "keyword",
        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            client().prepareIndex("test").setId("3").setSource("str", "3", "lng", 3L, "dbl", 3.0d),
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01").to("2014-01-01T00:59:00").timeZone("-01:00"))
        client().prepareIndex("test").setId("1").setSource("field1", 123, "field2", "value2").get();
                .get();
        // try the same with multi match query
                )
                        .endObject()
        assertSearchHits(searchResponse, "1", "3");
    }
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(range).get();
        // Test lenient
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("field1", "value1"))).get();
        assertHitCount(searchResponse, 1L);
        boolQuery = boolQuery().must(matchQuery("field1", "a").zeroTermsQuery(MatchQuery.ZeroTermsQuery.ALL));
            .setQuery(commonTermsQuery("field1", "the quick brown").cutoffFrequency(3).analyzer("stop"))
            SearchHits hits = searchResponse.getHits();
        SearchResponse searchResponse = client().prepareSearch("test")
    }
                    spanNearQuery(QueryBuilders.spanTermQuery("description", "quick"), 1).addClause(
        refresh();
                "num_double",
            .get();
        IndexRequestBuilder indexRequest = client().prepareIndex("test").setId("1").setRouting("custom").setSource("field", "value");
    // see #3521
                        .endArray()
import org.opensearch.action.search.SearchType;
            + "           \"intervals\" : ["
                spanNotQuery(
        SearchResponse searchResponse;
            .get();
        searchResponse = client().prepareSearch()
        assertHitCount(response, 3);
        ensureGreen();
            )
        indexRandom(
    }
        searchResponse = client().prepareSearch("test")
        refresh();
        client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).get();
                    .field("type", "integer")
        // Min should match > # optional clauses returns no docs.
            .setQuery(commonTermsQuery("field1", "the lazy fox brown").cutoffFrequency(1).highFreqMinimumShouldMatch("4"))
        assertSearchHits(searchResponse, "1", "3");
                    .put("index.analysis.normalizer.no_wildcard.type", "custom")
                .prepareUpdateSettings()
    public void testDateRangeInQueryString() throws InterruptedException {
            client().prepareIndex("tl_test").setId("4").setSource("val", "4"),
            assertEquals(2, hit.getFields().size());
        client().prepareIndex("test").setId("2").setSource("field1", "value2").get();
                        .endObject()
            hits = searchResponse.getHits();
        assertHitCount(searchResponse, 1L);
        SearchResponse searchResponse = client().prepareSearch().setQuery(queryStringQuery("value*")).get();
            // Now in UTC+1
    public void testWildcardCaseSensitivity() throws InterruptedException {
import static org.opensearch.index.query.QueryBuilders.matchPhrasePrefixQuery;
            .get();
            true,
        assertFirstHit(searchResponse, hasId("1"));
            assertHitCount(searchResponse, 2L);
import static org.hamcrest.Matchers.containsInAnyOrder;
        searchResponse = client().prepareSearch("test").setQuery(termsQuery("num_float", new double[] { 1 })).get();
        createIndex("test");
            client().prepareIndex("test").setId("2").setSource("field1", "quick lazy huge brown fox", "field2", "quick lazy huge brown fox")
            client().prepareIndex("tl_lookup").setId("6").setSource("val", "6"),
        indexRandom(
        assertFirstHit(searchResponse, hasId("4"));
        );
    }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
/*
        );
        assertFirstHit(searchResponse, hasId("1"));
        client().prepareIndex("test").setId("1").setSource("field", "lowercase text").get();
        SearchResponse searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("1", "2")).get();
        assertHitCount(searchResponse, 1L);

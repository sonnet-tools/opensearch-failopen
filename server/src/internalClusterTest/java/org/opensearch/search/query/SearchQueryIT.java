                "type=float",
        assertSearchHits(searchResponse, "1", "3");  
import org.opensearch.test.junit.annotations.TestIssueLogging;
            )
    public void testQueryStringParserCache() throws Exception {
                .setQuery(termsLookupQuery("val", new TermsLookup("tl_lookup", null, "val", matchAllQuery())))  
        assertHitCount(searchResponse, 1L);  
        indexRandomForConcurrentSearch("test");
            + "{ \"description\": { "  
    public void testIndexOptions() throws Exception {
        assertFirstHit(searchResponse, hasId("2"));
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        client().prepareSearch("test").setQuery(constantScoreQuery(matchQuery("field1", "quick")).boost(1.0f + random().nextFloat())).get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
            // test case insensitivity set to true
        refresh();  
        indexRandomForConcurrentSearch("test");
        assertHitCount(searchResponse, 1L);
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));  
        indexRandom(
        SearchResponse response = client().prepareSearch("test")
        assertHitCount(searchResponse, 2L);
        assertAcked(prepareCreate("test").setMapping("int_range", "type=integer_range"));
        client().prepareIndex("test").setId("3").setSource("field1", "value3").get();
        client().prepareIndex("test").setId("1").setSource("field1", "value_1", "field2", "value_2").get();
                    assertThat(searchHit, hasScore(expected));
        assertHitCount(searchResponse, 2L);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertThirdHit;
        createIndex("test");
        // index "lookup" type "type" id "missing" document does not exist: ignore the lookup terms
    }
        );
import java.io.IOException;
                .setSource(
                    .setQuery(termsLookupQuery("val", new TermsLookup("tl_lookup", null, "val", matchAllQuery())))
                "num_byte",
            .setQuery(multiMatchQuery("value2", "field2").field("field1", 2).lenient(true))
        assertFirstHit(searchResponse, hasId("1"));
                    .startObject("employee_id")
        client().prepareIndex("test").setId("1").setSource("field1", "test1", "num_long", 1).get();
        assertHitCount(searchResponse, 1L);
        assertThat(searchResponse.getHits().getAt(0).getId(), is("1"));
        assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 1L);
    public void testCommonTermsQuery() throws Exception {
        );  
        client().prepareIndex("test").setId("1").setSource("str", "foobar", "date", "2012-02-01", "num", 12).get();  
        assertHitCount(searchResponse, 2L);  
            client().prepareIndex("test").setId("1").setSource("description", "it's cold outside, there's no kind of atmosphere")
            client().admin()
        );
        assertHitCount(searchResponse, 2L);  
            long totalHits = searchResponse.getHits().getTotalHits().value();  
    @ParametersFactory
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("value*").field("field1").field("field2")).get(), 1);
            + "               { \"any_of\" : {"
    public void testFuzzyQueryString() throws InterruptedException {
            .setQuery(matchAllQuery())  
        assertHitCount(searchResponse, 1L);  
                    .field("locale", "de")
            .get();
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("dbl", new double[] { 2, 5 }))).get();
        indexRandom(
        // another search with same parameters...
        assertFailures(
        client().prepareIndex("test").setId("1").setSource("score", 1.5).get();  
            .setQuery(commonTermsQuery("field1", "the lazy fox brown").cutoffFrequency(1).highFreqMinimumShouldMatch("4"))
            wildCardQuery = wildcardQuery("field1", "bb*");
            "section",  
        }
        searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();
        dos.close();
            .setRouting("X")
    public static class MockAnalysisPlugin extends Plugin implements AnalysisPlugin {
        searchResponse = client().prepareSearch("test")
            prepareCreate("test")
            client().prepareIndex("lookup").setId("4").setSource("other", "value"),  
        refresh();  
            client().prepareIndex("test").setId("4").setSource("term", "4")
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1)));
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();  
            assertHitCount(searchResponse, 1L);
        SearchResponse response = client().prepareSearch("test").setQuery(wrapperQuery(json)).get();
        r.add(4);  
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;  
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("ValUE_*")).get();  
            .setQuery(termsLookupQuery("term", new TermsLookup("lookup2", "1", "arr.term")))  
    }  
import static org.opensearch.index.query.QueryBuilders.termsLookupQuery;  
    }
            .field("path", "section.distance")
        // Timezone set with dates
                .get();
                constantScoreQuery(
        assertAcked(prepareCreate("test").setMapping("field1", "type=text,index_options=docs"));  
        searchResponse = client().prepareSearch().setQuery(existsQuery("field3")).get();  
    public void testBasicQueryById() throws Exception {
    /**
    }  
 * GitHub history for details.
                        .startObject("obj2")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            client().prepareIndex("test").setId("3").setSource("long", 3L, "double", 3.0d)  
            client().prepareIndex("tl_test").setId("5").setSource("val", "5"),
                    .field("ignore_malformed", false)
        assertAcked(prepareCreate("test").setMapping("field", "type=text"));
        assertSecondHit(searchResponse, hasId("1"));
            assertHitCount(searchResponse, 1L);  
            client().prepareIndex("test").setId("2").setSource("date_field", "Do., 07 Dez. 2000 02:55:00 -0800")
            .field("type", "long")  
        assertHitCount(searchResponse, 1L);
                    .startObject("properties")
            3L  
        indexRandomForConcurrentSearch("test");
                        return new PatternReplaceCharFilter(pattern, "", reader);
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01").to("2014-01-01T00:59:00").timeZone("-01:00"))  
            true,  
            .get();  
        client().prepareIndex("test").setId("2").setSource("field1", "value3", "field2", "value4").get();
        assertNoFailures(response);
                    spanNearQuery(QueryBuilders.spanTermQuery("description", "quick"), 1).addClause(
    }
                "type=double"
                    .endObject()
        assertHitCount(searchResponse, 1L);  
            .setPostFilter(
        searchResponse = client().prepareSearch("test")  
        client().prepareIndex("test").setId("2").setSource("str", "fred", "date", "2012-02-05", "num", 20).get();
        searchResponse = client().prepareSearch().setQuery(matchQuery("text", "uniy").fuzziness(Fuzziness.ONE)).get();
            true,
                        .startObject()
            assertSearchHits(searchResponse, indexName + "1");
     * Test range with a custom locale, e.g. "de" in this case. Documents here mention the day of week
        );
    // see #3952  
            client().prepareIndex("lookup").setId("1").setSource("terms", new String[] { "1", "3" }),  
                            )
            true,
            assertTrue(hit.getFields().containsKey("id-alias"));
        indexRandomForConcurrentSearch("test");
            client().prepareIndex("test").setId("2").setSource("term", "2"),  
            + "           \"intervals\" : ["  
package org.opensearch.search.query;
            .get();
            containsString("field:[field1] was indexed without position data; cannot run PhraseQuery")
            .get();
                                1.0f + (random.nextBoolean() ? 0.0f : random.nextFloat())  
        assertHitCount(searchResponse, 1L);
        refresh();
        assertFirstHit(searchResponse, hasId("2"));  
            true,
        SearchResponse searchResponse = client().prepareSearch().setQuery(existsQuery("field1")).get();
import static org.opensearch.index.query.QueryBuilders.idsQuery;
            .get();
import static org.hamcrest.Matchers.closeTo;
        assertHitCount(searchResponse, 1L);  
            .must(multiMatchQuery("value4", "field1", "field2").zeroTermsQuery(MatchQuery.ZeroTermsQuery.ALL));
                jsonBuilder().startObject()
        assertHitCount(searchResponse, 2L);  
            .setQuery(termsLookupQuery("term", new TermsLookup("lookup2", "2", "arr.term")))  
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("lng", new long[] { 5, 6 }))).get();  
                        .field("field1", "value1_1")
        assertSearchHits(searchResponse, "1", "3", "4");
    }
            client().prepareIndex("test").setId("1").setSource("field1", "the quick brown fox jumps"),
            true,
        assertHitCount(searchResponse, 3L);
 * this work for additional information regarding copyright
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termQuery("num_float", 1))).get();
        SearchResponse searchResponse = client().prepareSearch()  
    public void testFilterExistsMissing() throws Exception {
            // The subquery matches all 6 docs in tl_lookup, but fetchSize is 3 => should fail
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T02:00:00").to("2014-01-01T02:59:00").timeZone("+03:00"))
        MultiMatchQueryBuilder builder = multiMatchQuery("value1 value2 value4", "field1", "field2");
    }  
            SearchResponse searchResponse = assertSearchResponse(request);
        assertFirstHit(searchResponse, hasId("1"));
        assertSearchHits(searchResponse, "2", "3");
            client().prepareIndex("lookup3").setId("1").setSource("terms", new String[] { "1", "3" }),
        indexRandomForConcurrentSearch("test");
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termQuery("num_short", 1))).get();
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("field\\*:v?lue*")).get(), 1);
                    private final Pattern pattern = Regex.compile("[\\*\\?]", null);
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("/value[01]/").field("field1").field("field2")).get(), 1);
            .get();
import org.opensearch.action.search.SearchResponse;  
        }
            )
     * Reserved characters should be excluded when the normalization is applied for keyword fields.
        // We set a timezone which will give no result
                        .endObject()
            client().prepareSearch().setQuery(matchAllQuery()).setPostFilter(boolQuery().mustNot(termQuery("field1", "value3"))).get(),  
        assertAcked(client().admin().indices().preparePutMapping("test").setSource("field", "type=date,format=epoch_millis").get());  
        assertSearchHits(searchResponse, "1", "2");
        return Arrays.asList(  
                )
        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            .get();  
    }
            .get();  
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("num_short", new int[] { 1 }))).get();  
    }  
        Random random = random();
        searchResponse = client().prepareSearch("test").setQuery(termsQuery("num_byte", new int[] { 1 })).get();
                        .endObject()
                        return name;  
                    .endObject()
                        .field("obj2_val", "1")
                                                                                                          // always OR-ed together.
                "type=integer",
        // same as above, just on the _id...
    public void testSpanNot() throws IOException, ExecutionException, InterruptedException {  
        bitmap.addLong(3000000000003L);
            if (totalHits > 1) {
    }
    public void testMinScore() throws ExecutionException, InterruptedException {  
        logger.info("--> terms query on 1");
        assertFirstHit(searchResponse, hasId("1"));  
                        .endObject()  
            client().prepareIndex("test").setId("3").setSource("term", "3"),
import static org.hamcrest.Matchers.is;
        searchResponse = client().prepareSearch().setQuery(existsQuery("obj1")).get();
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchPhraseQuery("field2", "quick brown").slop(0)).get();
        assertSearchHits(searchResponse, "2", "4");  
            assertHitCount(searchResponse, indexNames.length);  
            SearchPhaseExecutionException.class,
            client().prepareIndex("tl_lookup").setId("4").setSource("val", "4"),
                "keyword",  
        indexRandomForConcurrentSearch("test");
        assertHitCount(searchResponse, 2L);  
        refresh();
                        .startObject()
        assertHitCount(searchResponse, 2L);
import java.io.DataOutputStream;
                        .field("field2", "value2_1")  
                .setSource(  
                .get();
            client().prepareIndex("test").setId("1").setSource("field1", "the quick brown fox"),
        assertHitCount(searchResponse, 2L);  
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("value1").field("field1").field("field2")).get(), 1);
            .get();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        searchResponse = client().prepareSearch("test")
        assertHitCount(searchResponse, 0L);  
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();  
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("field1", "value1"))).get();
        assertHitCount(searchResponse, 0L);
                        .field("field1", "value1_2")
        assertHitCount(searchResponse, 1L);  
            client().prepareIndex("test").setId("3").setSource("description", "foo other"),
            client().prepareIndex("tl_test").setId("4").setSource("val", "4"),
                "num_integer",  
        assertFirstHit(searchResponse, hasId("1"));
            .setMapping("field1", "type=text,analyzer=whitespace")  
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termQuery("num_double", 1))).get();
        assertThat(searchResponse.getHits().getAt(0).getId(), is("2"));
        assertHitCount(searchResponse, 3L);
            closeTo(boost * searchResponse.getHits().getAt(1).getScore(), .1)
                    .field("type", "date")
     * set for fuzzy queries with "constant_score" rewrite nested inside a `span_multi` query and would cause NPEs due to an unset
        searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("1")).get();  
        searchResponse = client().prepareSearch("test")  
            .get();
            .endObject()
        boolQuery = boolQuery().must(termQuery("field1", "value1"))
        }
                        .startObject()
        refresh();
        indexRandom(  
        createIndex("test");
    }  
        searchResponse = client().prepareSearch().setQuery(matchQuery("text", "unify").fuzziness(Fuzziness.customAuto(5, 7))).get();
        indexRandom(
    @Override
            false,  
        assertHitCount(searchResponse, 1L);
                    () -> new MockTokenizer(MockTokenizer.KEYWORD, false)  
                                                                                                    // a field! Fields are always OR-ed
            true,
        assertHitCount(client().prepareSearch("test").setSize(0).setQuery(rangeQuery("field").gte(1000000000000L)).get(), 4);
                        .field("term", "2")
    public void testRangeQueryWithLocaleMapping() throws Exception {
            )
        }
                    .endObject()  
            .get();
            client().prepareIndex("test").setId("2").setSource("important", "nothing important", "less_important", "phrase match")
            .get();
        searchResponse = client().prepareSearch("test")
        refresh();
        }
        assertHitCount(searchResponse, 2L);
import static org.hamcrest.Matchers.containsInAnyOrder;
                        .startObject("obj1")
        createIndex("test");
            )
        // the mapping needs to be provided upfront otherwise we are not sure how many failures we get back
        assertHitCount(searchResponse, 4L);  
        assertHitCount(searchResponse, 3L);
            .setId("1")  
                        )
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("num_integer", new int[] { 1 }))).get();  
    // Issue #3540
        searchResponse = client().prepareSearch().setQuery(builder).get();
        // cutoff frequency of 1 makes all terms high frequency so the query gets rewritten as a
                    public Reader create(Reader reader) {
        multiMatchQuery.minimumShouldMatch("70%");
            response = client().prepareSearch("test")
        assertHitCount(searchResponse, 0L);
        refresh();  
        );
                .setPostFilter(QueryBuilders.termQuery("type", "customer"))  
    }
            assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch("test")  
        refresh();
        assertThat(searchResponse.getHits().getAt(0).getId(), is("2"));  
            .setId("1")
            client().prepareIndex("test").setId("2").setSource("long", 2L, "double", 2.0d),
                .setSource(  
                    .field("index", false)
        assertSecondHit(searchResponse, hasId("2"));
    public void testTermIndexQuery() throws Exception {  
                    spanNearQuery(QueryBuilders.spanTermQuery("description", "quick"), 1).addClause(
        client().prepareIndex("test")
        client().prepareIndex("test")
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(spanOrQuery(spanTermQuery("description", "bar"))).get();
            client().prepareIndex("tl_lookup").setId("3").setSource("val", "3"),  
                    .should(rangeQuery("num_long").from(1).to(2))  
            true,
            SearchResponse searchResponse = assertSearchResponse(request);
        searchResponse = client().prepareSearch("test")
        indexRandomForConcurrentSearch("test");
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("v?lue*").field("field1").field("field2")).get(), 1);
            client().prepareIndex("products").setId("1").setSource("product", 1),
        }
        BoolQueryBuilder boolQuery = boolQuery().must(termQuery("field1", "value1"))
    public void testMultiMatchQuery() throws Exception {  
    public void testRangeQueryWithTimeZone() throws Exception {  
import org.opensearch.plugins.Plugin;  
            true,
                spanNotQuery(
        // repeat..., with terms  
        assertHitCount(searchResponse, 2L);
            client().prepareIndex("tl_lookup").setId("6").setSource("val", "6"),  
            .setId("4")
        searchResponse = client().prepareSearch("test").setQuery(termQuery("num_byte", 1)).get();  
    public void testWildcardQueryNormalizationOnTextField() throws InterruptedException {
        indexRandom(true, builders);  
            .startObject("properties")
            client().prepareIndex("employees").setId("1").setSource("employee_id", 1000000000001L),  
 * under the License.  
import java.time.Instant;
            .setQuery(constantScoreQuery(termsQuery("employee_id", bitmapBytes).valueType(TermsQueryBuilder.ValueType.BITMAP)))  
            searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();  
        {  
import org.roaringbitmap.RoaringBitmap;
        client().prepareIndex("test").setId("2").setSource("desc", "one two three", "type", "product").get();
            client().admin()
        assertHitCount(searchResponse, 1L);
        createIndex("test");
            .setSource("online", true, "bs", "X", "ts", System.currentTimeMillis() - 10000000, "type", "s")
    public void testIssue3177() throws InterruptedException {  
                ),  
        BoolQueryBuilder query = boolQuery().filter(spanMultiTermQueryBuilder(fuzzyQuery("field", "foobarbiz").rewrite("constant_score")));  
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("future:[now/d TO now+2M/d]")).get();  
        assertAcked(prepareCreate("test").setMapping("term", "type=text"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        assertFirstHit(searchResponse, hasId("1"));
            prepareCreate("test").setSettings(
        refresh();  
            client().prepareIndex("test1").setId("2").setSource("field", "trying out OpenSearch")
        bitmap.addLong(1000000000001L);
    @Override  
        }
            SearchResponse searchResponse = client().prepareSearch()  
                "num_double",  
    }  
        assertHitCount(searchResponse, 1L);
            .get();
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("field\\*:value*")).get(), 1);
                .cluster()  
            .get();
            true,
                    XContentFactory.jsonBuilder()
    }  
        searchResponse = client().prepareSearch()
        assertNoFailures(searchResponse);
    public void testMultiMatchQueryMinShouldMatch() throws InterruptedException {
                                                                                                          // inside a field! Fields are  
 */
            .get();
import java.time.ZoneOffset;
                    .build()
    // Issue #10477  
                        .field("x2", "x_2")
import static org.opensearch.index.query.QueryBuilders.wrapperQuery;  
    public void testDateRangeInQueryString() throws InterruptedException {  
            client().prepareIndex("test")  
        assertHitCount(searchResponse, 1L);
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T01:00:00Z").to("2014-01-01T01:59:00Z").timeZone("+10:00"))
            assertHitCount(searchResponse, 1);
            assertHitCount(searchResponse, 1L);  
                    .put("index.analysis.normalizer.no_wildcard.char_filter", "no_wildcard")
        indexRandomForConcurrentSearch("index");  
        );
        assertHitCount(searchResponse, 1L);
        bitmap.serializePortable(dos);
                Exception.class,
            prepareCreate("test").setMapping(
    public void testNumericTermsAndRanges() throws Exception {
                "num_float",
                        .endObject()
        assertThat(searchResponse.getHits().getAt(0).getId(), is("3"));
    public void testDateProvidedAsNumber() throws InterruptedException {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            client().prepareIndex("test").setId("2").setSource("field1", "value2", "field2", "value5", "field3", "value2"),  
        // directly building the terms query builder, so pass in the bitmap value as BytesArray  
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, between(2, DEFAULT_MAX_NUM_SHARDS)))  
        indexRandom(  
        } finally {
                .setQuery(
        assertHitCount(searchResponse, 2L);
        Set<String> hitIds = new HashSet<>();
                )
            for (SearchHit searchHit : hits) {
            .setSource("num_byte", 1, "num_short", 1, "num_integer", 1, "num_long", 1, "num_float", 1, "num_double", 1)
                    .field("type", "date")  
        refresh();  
        indexRandom(  
        client().prepareIndex("test").setId("1").setSource("field1", 123, "field2", "value2").get();  
        assertSearchHits(searchResponse, "1", "3");
            )  
                    .startObject("properties")
        // try the same with match query
            client().prepareIndex("employees2").setId("2").setSource("employee_id", 2000000000002L),
        assertHits(response.getHits(), "1");
import org.opensearch.index.query.Operator;
            .setQuery(constantScoreQuery(termsQuery("product", bitmap).valueType(TermsQueryBuilder.ValueType.BITMAP)))  
            assertSearchHits(searchResponse, indexName + "1");
        refresh();
        assertHitCount(searchResponse, 1L);  
        );
        client().prepareIndex("test").setId("2").setSource("description", "foo other anything", "count", 2).get();  
    public void testWildcardQueryNormalizationOnKeywordField() throws InterruptedException {
                    .endObject()  
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
            .setQuery(matchQuery("field1", "the quick brown").cutoffFrequency(3).operator(Operator.AND).analyzer("stop"))
        assertFirstHit(searchResponse, hasId("1"));
            .setId("2")  
        assertSearchHits(searchResponse, "1", "3");  
        // Index 6 docs in the lookup index and matching docs in the test index
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("dbl", new double[] { 5, 6 }))).get();  
        int iters = scaledRandomIntBetween(100, 200);
        assertAcked(prepareCreate("lookup").setMapping("terms", "type=text", "other", "type=text"));
            .setId("2")
                    .endObject()
        );  
        assertHitCount(searchResponse, 1L);
    @TestIssueLogging(value = "org.opensearch.search.query.SearchQueryIT:DEBUG", issueUrl = "https://github.com/elastic/elasticsearch/issues/43144")
        // Default  
        assertHitCount(searchResponse, 1L);  
        client().prepareIndex("test").setId("1").setSource("field", "lowercase text").get();  
     * Test that wildcard queries on text fields get normalized  
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("str", "1", "4"))).get();
                    .endObject()  
    }  
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 2L);  
        indexRandom(
                .setPostFilter(QueryBuilders.termQuery("type", "customer"))  
                        .startObject("obj2")  
                ),
            // Now in UTC+1
        assertHitCount(searchResponse, 1L);
            .get();
        assertThat(searchResponse.getHits().getAt(0).getId(), is("2"));
        WildcardQueryBuilder wildCardQuery = wildcardQuery("field", "la*");
        {
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("val*e_1")).get();
            .cluster()
                .setTransientSettings(
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("field1", "value1"))).get();
        assertFirstHit(searchResponse, hasId("1"));
 * You may obtain a copy of the License at  
        String now = DateFormatter.forPattern("strict_date_optional_time").format(Instant.now().atZone(timeZone));  
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("num:>=20")).get();
        multiMatchQuery = multiMatchQuery("value1 value2 value3", "field1", "field2");
        byte[] array = new byte[r.serializedSizeInBytes()];
        assertSecondHit(searchResponse, hasId("2"));
            )
     */
        indexRandomForConcurrentSearch("test");  
            + "                       { \"match\" : { \"query\" : \"outside\" } } ] } },"
            client().prepareIndex("test").setId("1").setSource("description", "foo other anything bar"),
        );
        assertThat(searchResponse.getHits().getAt(0).getId(), is("3"));  
                    ).filter(boolQuery().mustNot(boolQuery().must(termQuery("field1", "value1")).must(termQuery("field1", "value2"))))  
        assertHitCount(searchResponse, 2L);
            .get();
                    boolQuery().must(matchAllQuery())  
        assertFirstHit(searchResponse, hasId("1"));
        // Default  
        assertHitCount(searchResponse, 1L);  
        logger.info("--> terms filter on 1");
                "num_long",
        assertHitCount(searchResponse, 1L);  
            true,
        assertSearchHits(searchResponse, "1", "3");
        assertHitCount(searchResponse, 0L);
    // see #3521
import static org.opensearch.index.query.QueryBuilders.prefixQuery;
            .must(matchQuery("field1", "value1").zeroTermsQuery(MatchQuery.ZeroTermsQuery.ALL));
                        .endObject()
        try (DataOutputStream dos = new DataOutputStream(bos)) {
        assertHitCount(searchResponse, 0L);  
        String aMonthAgo = DateTimeFormatter.ISO_LOCAL_DATE.format(now.minusMonths(1));  
        assertHitCount(searchResponse, 1L);
            .get();
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);  
            .endObject()
            .get();  
                .setSize(num)
        String aMonthFromNow = DateTimeFormatter.ISO_LOCAL_DATE.format(now.plusMonths(1));
import org.opensearch.action.search.SearchType;
        assertHitCount(searchResponse, 2L);
        createIndex("test");  
        searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("7", "10")).get();  
        // as with dynamic mappings some shards might be lacking behind and parse a different query  
            .get();
            + "           \"max_gaps\" : 30 } } } }";  
        assertFirstHit(searchResponse, hasId("1"));  
            .startObject("properties")
        client().prepareIndex("test").setId("2").setSource("description", "the quick black fox leaped over the sleeping dog").get();
    public void testMultiMatchLenientIssue3797() throws InterruptedException {  
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("num:<20")).get();  
    }
            }
     * Test correct handling {@link SpanBooleanQueryRewriteWithMaxClause#rewrite(IndexSearcher, MultiTermQuery)}. That rewrite method is e.g.
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        assertSecondHit(searchResponse, hasId("3"));
    public void testMultiFieldQueryString() throws InterruptedException {
        assertHitCount(searchResponse, 1L);
        indexRandomForConcurrentSearch("test");
            .get();
import java.util.concurrent.ExecutionException;
 * software distributed under the License is distributed on an
        // test case sensitive
        // try the same with multi match query  
        assertFirstHit(searchResponse, hasId("1"));  
                class Factory implements NormalizingCharFilterFactory {  
        try {  
        client().prepareIndex("test").setId("2").setSource("field1", "test1", "num_long", 2).get();  
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").setRefreshPolicy(IMMEDIATE).get();  
        multiMatchQuery = multiMatchQuery("value1 value2 bar", "field1");  
            prepareCreate("lookup2").setMapping(
        assertSecondHit(searchResponse, hasId("2"));
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
            client().prepareIndex("test").setId("3").setSource("term", "3"),
        );
        assertHitCount(client().prepareSearch().setQuery(wrapper).get(), 1L);
        searchResponse = client().prepareSearch("test")
import org.opensearch.indices.TermsLookup;  
            // Set max_clause_count to 3, which should limit fetchSize to 3
        assertHitCount(response, 1);
import org.opensearch.common.settings.Settings;
    }
        indexRandom(  
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("num_long", new int[] { 1 }))).get();  
            client().prepareIndex("test").setId("2").setSource("field1", "quick lazy huge brown fox", "field2", "quick lazy huge brown fox")  
            true,
                .cluster()  
            .get();
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("*ue_1")).get();
        assertHitCount(searchResponse, 1L);  
    }  
        assertFirstHit(searchResponse, hasId("2"));  
    }  
            client().prepareIndex("test").setId("2").setSource("date", "2013-12-31T23:00:00", "num", 2),  
        assertHitCount(searchResponse, 1L);  
        assertFirstHit(searchResponse, hasId("1"));
        searchResponse = client().prepareSearch()  
            .endObject()
    }
            )
            .setQuery(QueryBuilders.queryStringQuery("xyz").boost(100))  
            searchResponse = client().prepareSearch("test_1").setQuery(constantScoreQuery(matchQuery)).setSize(num).get();
        client().prepareIndex("test").setId("1").setSource("description", "the quick brown fox jumped over the lazy dog").get();  
        refresh();
                .setId("4")
        indexRandom(
                        .field("y2", "y_2")
    protected int maximumNumberOfReplicas() {
        {
        assertHitCount(searchResponse, 0L);  
            .setQuery(
            DocumentField field = hit.getFields().get("id-alias");
                .setSource(  
            client().admin()  
                "type=integer",
        createIndex("test");
    // see #2926
        }
            client().prepareIndex("test").setId("4").setSource("description", "foo")
        assertFirstHit(searchResponse, hasId("2"));  
        refresh();
        assertFirstHit(searchResponse, hasId("1"));  
        );  
        @Override  
        );  
            client().prepareSearch()
        client().prepareIndex("test").setId("4").setSource("description", "fop", "count", 4).get();
import static java.util.Collections.singletonMap;
        indexRandom(  
            true,
        assertAcked(prepareCreate("test"));  
                .setId("3")  
                    .should(rangeQuery("num_long").from(3).to(4))
                .get();
        assertFirstHit(searchResponse, hasId("1"));  
            .get();
        assertHitCount(searchResponse, 1L);  
        indexRandom(
        assertSearchHits(searchResponse, "2", "3");  
            // unset cluster setting
        assertAcked(  
            client().prepareIndex("employees").setId("4").setSource("employee_id", 4000000000004L)  
            .setQuery(queryStringQuery("past:[2015-04-06T00:00:00 TO 2015-04-06T23:00:00]").timeZone("+0200"))
        assertHitCount(searchResponse, 2L);
                    .endObject()
        // Test lenient  
        searchResponse = client().prepareSearch()  
        createIndex("test");
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        // as with dynamic mappings some shards might be lacking behind and parse a different query
        client().prepareIndex("test").setId("2").setSource("field2", "value1").get();
        response = client().prepareSearch("test").setQuery(wildcardQuery("field", "Text").caseInsensitive(true)).get();
        index("index", "_doc", "1", source);
        return Math.min(2, cluster().numDataNodes() - 1);  
            float actual = response.getHits().getAt(0).getScore();
import static org.opensearch.index.query.QueryBuilders.spanMultiTermQueryBuilder;  
        client().admin().indices().prepareRefresh("test").get();
        searchResponse = client().prepareSearch()  
                    .startObject("properties")  
        assertHitCount(searchResponse, 2L);
        // Min should match > # optional clauses returns no docs.  
    public void testBoolQueryMinShouldMatchBiggerThanNumberOfShouldClauses() throws IOException, InterruptedException {
        assertHitCount(searchResponse, 1L);  
                    .field("required", true)
            client().prepareIndex("test").setId("1").setSource("term", "1"),  
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("lng", new long[] { 2, 3 }))).get();  
        assertFirstHit(searchResponse, hasId("3"));
                        .startObject()
            .setSource("online", false, "bs", "Y", "ts", System.currentTimeMillis() - 100, "type", "s")  
                        .endObject()  
            .get();
        searchResponse = client().prepareSearch("test").setQuery(termsQuery("num_float", new double[] { 1 })).get();
            client().prepareIndex("test").setId("2").setSource("field1", "value2"),  
                .cluster()
import java.util.Collection;
        assertThirdHit(searchResponse, hasId("3"));  
            .setQuery(matchQuery("field1", "the quick brown").cutoffFrequency(3).operator(Operator.OR))
            .startObject()
        assertHitCount(searchResponse, 0L);  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.query.TermsQueryBuilder;  
                        .endArray()
        assertHitCount(searchResponse, 1L);
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
            .get();
            true,  
import org.apache.lucene.util.AttributeSource;  
    public void testTermsLookupFilter() throws Exception {
import java.util.Map;
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("field\\*:value1")).get(), 1);
                        .field("field3", "value3_4")  
        searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("1", "2")).get();
                        .endObject()  
        createIndex("test");  
        searchResponse = client().prepareSearch("test")
            .setQuery(
        for (int i = 0; i < queryRounds; i++) {  
        createIndex("test");
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));  
    /** tests wildcard case sensitivity */  
        BytesArray bitmap = new BytesArray(array);  
        boolQuery = boolQuery().must(termQuery("field1", "value1"))
    /**  
                )  
                }  
    public void testDateRangeInQueryStringWithTimeZone_10477() throws InterruptedException {
                        .put(
                .get(),
        assertSearchHits(searchResponse, "1", "2");  
            client().prepareIndex("test").setId("2").setSource("field", 1000000000000L),
            .setQuery(multiMatchQuery("value2", "field2").field("field1", 2).lenient(true))
        multiMatchQuery.minimumShouldMatch("100%");
        assertHitCount(searchResponse, 1L);
        SearchResponse searchResponse = client().prepareSearch("employees2")
    public void testMustNot() throws IOException, ExecutionException, InterruptedException {
            client().prepareIndex("test").setId("1").setSource("date_field", "Mi., 06 Dez. 2000 02:55:00 -0800"),
        BoolQueryBuilder boolQuery = boolQuery().must(
        assertAcked(  
            true,  
        );
import static org.opensearch.index.query.QueryBuilders.wildcardQuery;
                        boolQuery().should(termQuery("field1", "value1"))  
        assertHitCount(searchResponse, 1L);  
        SearchResponse searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();  
            assertHitCount(searchResponse, 2);
import org.opensearch.index.query.QueryBuilder;
                            .should(
    }
        SearchResponse searchResponse = client().prepareSearch().setQuery(queryStringQuery("past:[now-2M/d TO now/d]")).get();  
                    .build()  
        // This made 2826 fail! (only with bit based filters)
        indexRandom(
                .setTransientSettings(Settings.builder().putNull(SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.getKey()))  
        indexRandom(true, false, client().prepareIndex("test").setId("1").setSource("nameTokens", "xyz"));
            .prepareCreate("test")
                Settings.builder()
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        refresh();
                return new Factory();
        assertThat(e.status(), equalTo(RestStatus.BAD_REQUEST));
        assertHitCount(searchResponse, 1L);  
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("num_float", new int[] { 1 }))).get();  
        SearchResponse searchResponse = client().prepareSearch("test")
        searchResponse = client().prepareSearch("test").setQuery(termsQuery("num_long", new int[] { 1 })).get();
                        QueryBuilders.spanTermQuery("description", "fox")  
        assertHitCount(searchResponse, 1L);
import static org.opensearch.index.query.QueryBuilders.regexpQuery;
        assertHitCount(searchResponse, 2L);
            .field("type", "alias")
        client().admin()  
            .setQuery(  
        assertHitCount(response, 0);
        SearchResponse searchResponse = client().prepareSearch().setQuery(constantScoreQuery(idsQuery().addIds("1", "3"))).get();
        assertAcked(prepareCreate("test"));
        assertHitCount(searchResponse, 1L);
            true,  
    public void testTermsQueryWithBitmapDocValuesQuery() throws Exception {
        assertAcked(
            // test default case insensitivity: false
                        .startArray("arr")  
        assertSearchHits(searchResponse, "1", "2");
        assertHitCount(response, 4);  
            .get();  
        assertFirstHit(searchResponse, hasId("1"));
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T01:00:00").to("2014-01-01T01:59:00"))
        assertHitCount(searchResponse, 1L);  
                // issue manifested only with shards>=2
            .setPostFilter(boolQuery().should(rangeQuery("num_long").from(1).to(2)).should(rangeQuery("num_long").from(3).to(4)))
    public void testIssueFuzzyInsideSpanMulti() throws InterruptedException {
                QueryBuilders.rangeQuery("date_field").gte("Di., 05 Dez. 2000 02:55:00 -0800").lte("Do., 07 Dez. 2000 00:00:00 -0800")
        assertHitCount(searchResponse, 3L);  
            client().prepareIndex("products").setId("4").setSource("product", 4)
            .get();
        searchResponse = client().prepareSearch().setQuery(matchPhrasePrefixQuery("field", "try")).get();  
            .get();
    public void testIdsQueryTestsIdIndexed() throws Exception {  
        }
        assertFirstHit(searchResponse, hasId("1"));
        assertFirstHit(searchResponse, hasId("1"));
        assertFirstHit(searchResponse, hasId("1"));
        createIndex("test");
        wildCardQuery = wildcardQuery("field", "la*el-?");
            .get();
        assertAcked(
        createIndex("test");
                    .startObject("properties")
        assertHitCount(searchResponse, 2L);
        searchResponse = client().prepareSearch("test")  
        assertHitCount(searchResponse, 1L);
                jsonBuilder().startObject()
        assertHitCount(searchResponse, 1L);  
                Settings.builder()
        indexRandomForConcurrentSearch("test");
                () -> client().prepareSearch("tl_test")  
            client().prepareIndex("test").setId("3").setSource("description", "foo other"),
                .get();
            SearchResponse searchResponse = client().prepareSearch("test").setQuery(queryStringQuery("*:*^10.0").boost(10.0f)).get();
        assertSecondHit(searchResponse, hasId("2"));
                        .field("obj1_val", "1")
        assertHitCount(searchResponse, 2L);  
                    .endObject()  
                ),
            .endObject()
        );
            .setTransientSettings(Settings.builder().put(IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey(), true))  
        assertNoFailures(searchResponse);  
            SearchHits hits = searchResponse.getHits();
    public void testMatchQueryFuzzy() throws Exception {
        assertHitCount(searchResponse, 1L);
        forceMerge();
        ZoneId timeZone = randomZone();
        // the mapping needs to be provided upfront otherwise we are not sure how many failures we get back
                        .must(constantScoreQuery(matchQuery).boost(1.0f + (random.nextBoolean() ? 0.0f : random.nextFloat())))
                        .endObject()  
import java.time.ZonedDateTime;
                jsonBuilder().startObject()  
        assertHitCount(searchResponse, 1L);  
                    .put("index.analysis.analyzer.lowercase_analyzer.tokenizer", "standard")
                        .endObject()
        SearchResponse searchResponse = client().prepareSearch("test")  
            }
        // stop drops "the" since its a stopword  
        BoolQueryBuilder bool = boolQuery().must(wrapper).must(new TermQueryBuilder("field2", "value2_1"));  
            .get();  
import org.apache.lucene.tests.util.English;
        assertAcked(  
    }  
        searchResponse = client().prepareSearch("test")  
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("lng", new int[] { 1, 3 }))).get();
        searchResponse = client().prepareSearch("test").setQuery(termsLookupQuery("term", new TermsLookup("lookup", "2", "terms"))).get();  
import org.opensearch.index.analysis.TokenizerFactory;  
        assertSearchHits(searchResponse, "3", "1");
                .setId("2")
            assertSearchHits(searchResponse, indexName + "1");
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("v?l*e?1")).get();
        expectThrows(SearchPhaseExecutionException.class, () -> client().prepareSearch().setQuery(matchQuery("double", "2 3 4")).get());
            // Fields are ORed together
        assertThat(searchResponse.getHits().getAt(0).getId(), is("4"));  
        assertHitCount(searchResponse, 0L);
        assertHitCount(searchResponse, 0L);
            .get();  
            assertHitCount(searchResponse, 1L);  
    public void testMatchQueryZeroTermsQuery() throws InterruptedException {  
        assertHitCount(searchResponse, 1L);  
                .setQuery(matchAllQuery())  
        logger.info("regexp");  
        SearchResponse response = client().prepareSearch("test")
                "type=byte",  
    }  
                        .endObject()
        searchResponse = client().prepareSearch("test").setQuery(termsQuery("num_short", new int[] { 1 })).get();
        response = client().prepareSearch("test")
        );
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchQuery("long", "1")).get();  
                    .endObject()
        client().prepareIndex("test").setId("3").setSource("score", 2.0).get();
                .get();
    }
            client().prepareIndex("test").setId("3").setSource("field1", "value3", "field2", "value6", "field3", "value1")
                    .endObject()
            SearchResponse searchResponse = client().prepareSearch("test")
                    .endObject()
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("str", "5", "6"))).get();  
                ).pre(1).post(1)  
import org.opensearch.index.query.MultiMatchQueryBuilder;  
        logger.info("wildcard");  
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
            client().prepareIndex("test1").setId("1").setSource("field", "Johnnie Walker Black Label"),  
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        @Override  
            // The IllegalArgumentException may be wrapped in SearchPhaseExecutionException  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSecondHit;  
                    spanTermQuery("description", "brown")
    public SearchQueryIT(Settings staticSettings) {  
        );  
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch("test").setQuery(termsQuery("num_double", new double[] { 1 })).get();
            client().prepareIndex("lookup2")
import org.opensearch.index.query.WrapperQueryBuilder;
            return singletonMap("mock_pattern_replace", (indexSettings, env, name, settings) -> {
        );
    }
        SearchResponse response = client().prepareSearch("test")  
            client().prepareIndex("test").setId("3").setSource("str", "3", "lng", 3L, "dbl", 3.0d),
            .startObject("route_length_miles")
        multiMatchQuery.minimumShouldMatch("30%");
/*  
            )
        assertSearchHits(searchResponse, "1", "2");
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);
                "type=short",
            )
        assertHitCount(searchResponse, 1L);
     * as "Mi" for "Mittwoch (Wednesday" and "Do" for "Donnerstag (Thursday)" and the month in the query
            .endObject();  
        // This made #2979 fail!
        assertAcked(prepareCreate("tl_test").setMapping("val", "type=keyword"));
        assertAcked(  
        assertFirstHit(searchResponse, hasId("1"));
        );
        assertHitCount(searchResponse, 1L);
import static org.opensearch.index.query.QueryBuilders.spanNotQuery;
        indexRandomForConcurrentSearch("lookup");  
        XContentBuilder source = XContentFactory.jsonBuilder()  
        );  
        indexRandomForConcurrentSearch("test");  
import org.apache.lucene.analysis.pattern.PatternReplaceCharFilter;  
        assertSecondHit(searchResponse, hasId("2"));  
                    .field("type", "integer")
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < 100; i++) {  
import org.apache.lucene.search.MultiTermQuery;
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            client().prepareIndex("tl_test").setId("6").setSource("val", "6")  
            .get();  
public class SearchQueryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .get();
        assertFirstHit(searchResponse, hasId("1"));  
import org.opensearch.common.lucene.search.SpanBooleanQueryRewriteWithMaxClause;  
                spanNotQuery(
            .setQuery(commonTermsQuery("field1", "the quick brown").cutoffFrequency(3).lowFreqOperator(Operator.OR))
            assertHitCount(searchResponse, 1);
                "num_double",  
            + "               { \"match\" : { \"query\" : \"atmosphere\" } } ],"
            client().prepareIndex("lookup2")
            assertThat(errorMsg, containsString("exceed fetch limit"));
    }
        assertHitCount(client().prepareSearch().setQuery(bool).get(), 1L);
            .addAggregation(AggregationBuilders.terms("field1").field("field1.keyword"))
        );
        // test case insensitive  
        searchResponse = client().prepareSearch()  
                .get();  
            .setSource("online", true, "ts", System.currentTimeMillis() - 123123, "type", "bs")  
                                                                                                    // together.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertThat(searchResponse.getHits().getAt(0).getId(), is("3"));
            .setQuery(functionScoreQuery(ScoreFunctionBuilders.fieldValueFactorFunction("score").missing(1.0)).setMinScore(1.5f))
            client().prepareIndex("products").setId("2").setSource("product", 2),
import org.opensearch.index.query.BoolQueryBuilder;
        searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("1", "2", "3", "4")).get();  
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();  
        assertAcked(prepareCreate("test").setMapping(mapping));
        assertHitCount(searchResponse, 0L);  
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 2L);  
        SearchResponse searchResponse = client().prepareSearch()  
        assertHitCount(searchResponse, 1L);
                .get();  
            true,
        assertSearchHits(searchResponse, "1", "3");
        assertSecondHit(searchResponse, hasId("2"));
                "type=long",  
        // We explicitly define a time zone in the from/to dates so whatever the time zone is, it won't be used
    public void testQueryStringWithSlopAndFields() throws InterruptedException {  
import org.opensearch.index.analysis.NormalizingCharFilterFactory;
            searchResponse = client().prepareSearch("test_1")
    public static Collection<Object[]> parameters() {
import org.apache.lucene.search.IndexSearcher;
        searchResponse = client().prepareSearch()
        );
            client().prepareIndex("test").setId("3").setSource("date", "2014-01-01T01:00:00", "num", 3),
        );  
        indexRandomForConcurrentSearch("lookup2");
 *  
            client().prepareIndex("tl_lookup").setId("5").setSource("val", "5"),
        BytesArray bitmapBytes = new BytesArray(bos.toByteArray());  
            client().prepareIndex("test").setId("2").setSource("description", "foo other anything"),  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
    public void testAllDocsQueryString() throws InterruptedException, ExecutionException {  
                    ),
                boolQuery().must(termQuery("field1", "test1"))
            .setVersion(true)  
        searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
        {
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)  
        indexRandom(  
                .prepareUpdateSettings()
        assertHitCount(searchResponse, 2L);  
                float expected = hits.getAt(0).getScore();  
                .prepareUpdateSettings()
        assertHitCount(searchResponse, 2L);
        searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();  
            .get();
        assertHitCount(searchResponse, 2L);
        indexRandomForConcurrentSearch("test");
 * license agreements. See the NOTICE file distributed with
            .startObject("id-alias")  
            .setQuery(queryStringQuery("past:[now-1m/m TO now+1m/m]").timeZone(timeZone.getId()))
    }
        assertHitCount(searchResponse, 2L);
    }  
import org.opensearch.test.InternalSettingsPlugin;
        assertFirstHit(searchResponse, hasId("1"));
            .field("type", "nested")  
        );  
        multiMatchQuery.minimumShouldMatch("4");
                            boolQuery().must(rangeQuery("ts").lt(System.currentTimeMillis() - (15 * 1000))).must(termQuery("type", "bs"))
        );
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T03:00:00").to("2014-01-01T03:59:00").timeZone("+03:00"))
            .get();
        client().prepareIndex("test").setId("1").setSource("description", "foo other anything bar", "count", 1).get();
            assertHitCount(searchResponse, 2L);
        int queryRounds = scaledRandomIntBetween(10, 20);
     */
                    .put("index.analysis.normalizer.lowercase_normalizer.type", "custom")  
        indexRandom(  
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T04:00:00").to("2014-01-01T04:59:00").timeZone("+03:00"))  
        assertSecondHit(searchResponse, hasId("3"));  
                .setId("3")
                jsonBuilder().startObject()  
        assertSearchHits(searchResponse, "3", "1");
        indexRandom(
        searchResponse = client().prepareSearch().setQuery(commonTermsQuery("field1", "the quick brown").cutoffFrequency(3)).get();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            client().prepareIndex("test").setId("2").setSource("str", "2", "lng", 2L, "dbl", 2.0d),  
    }
            .setQuery(queryStringQuery("\"phrase match\"").field("important", boost).field("less_important"))
        assertAcked(
        assertHitCount(searchResponse, 0L);  
        RoaringBitmap r = new RoaringBitmap();
        );  
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        SearchPhaseExecutionException e = expectThrows(  
        indexRandomForConcurrentSearch("test");
            SearchResponse searchResponse = assertSearchResponse(request);
        SearchResponse searchResponse = client().prepareSearch().setQuery(boolQuery).get();
            indexRandom(true, client().prepareIndex(indexName).setId(indexName + "1").setSource("field1", "value1"));
        assertSearchHits(searchResponse, "1", "3");  
import org.opensearch.core.rest.RestStatus;
            client().prepareIndex("employees2").setId("1").setSource("employee_id", 1000000000001L),  
import static org.opensearch.index.query.QueryBuilders.boolQuery;
import org.apache.lucene.tests.analysis.MockTokenizer;
    public void testTermsQueryWithBitmap64IndexAndDocValues() throws Exception {
        assertFirstHit(searchResponse, hasId("2"));
        assertFirstHit(searchResponse, hasId("1"));
                        )
 * SPDX-License-Identifier: Apache-2.0
            assertThat((double) searchResponse.getHits().getAt(0).getScore(), closeTo(2.0, 0.1));
        refresh();
    }
                    .startObject("_routing")
        SearchResponse searchResponse = client().prepareSearch("test")  
        client().prepareIndex("test").setId("1").setSource("field", "label-1").get();  
            .get();
        assertHitCount(searchResponse, 1L);
 *    http://www.apache.org/licenses/LICENSE-2.0
        indexRandom(true, false, indexRequest);
        // this uses dismax so scores are equal and the order can be arbitrary
                    @Override  
            .setQuery(spanNearQuery(spanTermQuery("description", "foo"), 3).addClause(spanTermQuery("description", "other")))  
                .setSource(
        assertHitCount(searchResponse, 0L);
        assertFirstHit(searchResponse, hasId("1"));
        indexRandomForConcurrentSearch("test");
            ).setMapping("field", "type=keyword,normalizer=no_wildcard")
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);
     */
        assertSearchHits(searchResponse, "2");
        boolQuery = boolQuery().must(multiMatchQuery("a", "field1", "field2").zeroTermsQuery(MatchQuery.ZeroTermsQuery.ALL))
        assertFirstHit(searchResponse, hasId("2"));  
            .get();  
                )  
        assertFirstHit(searchResponse, hasId("1"));
                    .field("index", false)
        assertHitCount(response, 4);  
            client().prepareIndex("test").setId("1").setSource("term", "1"),
            builders[i] = client().prepareIndex("test_1").setId("" + i).setSource("f", English.intToEnglish(i));  
            .setRouting(randomAlphaOfLength(2))
        assertHitCount(searchResponse, 2L);  
            client().admin()
            .setQuery(spanOrQuery(spanMultiTermQueryBuilder(fuzzyQuery("description", "fop"))))
        searchResponse = client().prepareSearch("test").setQuery(termQuery("num_long", 1)).get();  
        assertThat(searchResponse.getHits().getAt(0).getId(), is("3"));  
    }
                "type=long",  
            client().prepareIndex("test").setId("4").setSource("term", "4")  
        }
            client().prepareIndex("test").setId("3").setSource("field", 999999999999L),
    /**
        assertHitCount(response, 3);
                    jsonBuilder().startObject()
            SearchResponse searchResponse = client().prepareSearch("test")
        indexRandomForConcurrentSearch("test");
        for (SearchHit hit : hits.getHits()) {
            .get();
    // see https://github.com/elastic/elasticsearch/issues/3177
            SearchHit hit = searchResponse.getHits().getAt(0);  
        for (String indexName : indexNames) {
                    spanNearQuery(QueryBuilders.spanTermQuery("description", "quick"), 1).addClause(
    }
            .get();
        multiMatchQuery.minimumShouldMatch("30%");  
        assertFirstHit(searchResponse, hasId("1"));
import java.util.Random;
        assertHitCount(searchResponse, 1L);
    public void testMatchPhrasePrefixQuery() throws ExecutionException, InterruptedException {
        searchResponse = client().prepareSearch()
        assertFirstHit(searchResponse, hasId("1"));
        assertHitCount(searchResponse, 0L);
        searchResponse = client().prepareSearch().setQuery(constantScoreQuery(termsQuery("_id", "1", "3"))).get();
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);
            client().prepareIndex("employees").setId("3").setSource("employee_id", new long[] { 1000000000001L, 3000000000003L }),
        searchResponse = client().prepareSearch("test").setQuery(termQuery("num_integer", 1)).get();  
            .get();
        assertFirstHit(searchResponse, hasId("1"));
        assertHitCount(searchResponse, 2L);  
            .setQuery(QueryBuilders.rangeQuery("date").from("now/d-1d").timeZone("+01:00"))  
    public void testSearchEmptyDoc() throws InterruptedException {
        assertFirstHit(searchResponse, hasId("1"));
                        .startObject("obj1")
        WrapperQueryBuilder wrapper = new WrapperQueryBuilder("{ \"term\" : { \"field1\" : \"value1_1\" } }");  
        createIndex("test");
            prepareCreate("test").setSettings(
            .startObject("section")
        assertHitCount(searchResponse, 1L);
                .setPostFilter(
    protected int maximumNumberOfShards() {  
        assertHitCount(searchResponse, 0L);
        assertAcked(prepareCreate("index").setMapping(mapping));
        assertHitCount(searchResponse, 2L);
            .setPostFilter(boolQuery().should(rangeQuery("num_long").from(1).to(2)).should(rangeQuery("num_long").from(3).to(4)))
        client().prepareIndex("test").setId("3").setSource("field1", "test2", "num_long", 3).get();
        return Arrays.asList(InternalSettingsPlugin.class, MockAnalysisPlugin.class);
        String[] indexNames = { "test1", "test2" };
        assertFirstHit(searchResponse, hasId("1"));
    public void testNumericRangeFilter_2826() throws Exception {
                    }  
                                                                                        // Fields are always OR-ed together.  
    }  
import org.opensearch.search.SearchHit;
        }  
        assertHitCount(searchResponse, 1L);  
        assertAcked(  
            .endObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
        indexRandomForConcurrentSearch("test");
        client().prepareIndex("test")
 * Licensed to Elasticsearch under one or more contributor  
                .setId("4")
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("field\\*:value~")).get(), 1);
        assertHitCount(searchResponse, 1L);
            SearchResponse request = client().prepareSearch().setQuery(constantScoreQuery(matchQuery("_index", indexName))).get();
        assertHitCount(searchResponse, 1L);
import org.opensearch.index.query.WildcardQueryBuilder;
        assertThat(hits.getTotalHits().value(), equalTo((long) ids.length));  
            .prepareUpdateSettings()
        assertAcked(prepareCreate("tl_lookup").setMapping("val", "type=keyword"));
            .setQuery(commonTermsQuery("field1", "the quick brown").cutoffFrequency(3).lowFreqOperator(Operator.AND))  
            .setId("1")
                .setQuery(boolQuery().must(matchAllQuery()).must(constantScoreQuery(matchAllQuery())))
        }
        assertFirstHit(searchResponse, hasId("2"));  
                    Settings.builder()  
    }
            .setQuery(spanOrQuery(spanMultiTermQueryBuilder(wildcardQuery("description", "oth*"))))  
        createIndex("test");
    public void testRangeQueryRangeFields_24744() throws Exception {
        assertFirstHit(searchResponse, hasId("2"));  
        assertSecondHit(searchResponse, hasId("2"));
            client().prepareIndex("tl_test").setId("2").setSource("val", "2"),
        assertHitCount(searchResponse, 1L);
        client().prepareIndex("test").setId("1").setSource("desc", "one two three", "type", "customer").get();  
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termQuery("num_integer", 1))).get();
        indexRandom(  
    }
            client().prepareIndex("test").setId("1").setSource("important", "phrase match", "less_important", "nothing important"),
        assertSearchHits(searchResponse, "1", "4");
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("field1", "value1"))).get();
            .setRouting(randomAlphaOfLength(2))  
        multiMatchQuery.minimumShouldMatch("70%");
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("num:>11")).get();  
        assertHitCount(searchResponse, 1L);
import java.util.HashSet;  
            .get();
import org.opensearch.common.document.DocumentField;
import org.opensearch.action.search.SearchPhaseExecutionException;
        searchResponse = client().prepareSearch("test")
        refresh();
                    .field("type", "long")  
                assertThat(searchHit, hasScore(1.0f));  
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
                .setSource(
        SearchResponse searchResponse = client().prepareSearch("products")
        for (String indexName : indexNames) {  
    }
        IndexRequestBuilder[] builders = new IndexRequestBuilder[num];
                            .should(termQuery("field1", "value2"))
        client().prepareIndex("test").setId("2").setSource("str", "fred", "date", "2012-02-05", "num", 20).get();  
 * compatible open source license.
                        .startObject()
            .setQuery(termsLookupQuery("term", new TermsLookup("lookup", "1", "terms")))  
            SearchResponse request = client().prepareSearch().setQuery(constantScoreQuery(termQuery("_index", indexName))).get();
        assertHitCount(response, 1);  
            assertHitCount(searchResponse, 1);  
        SearchResponse searchResponse = client().prepareSearch("test")
        logger.info("regular");  
        assertAcked(prepareCreate("test").setMapping("past", "type=date"));
     * as "Dez" for "Dezember (December)".  
                        .field("x1", "x_1")
                    .endObject()
    // see #3797
        searchResponse = client().prepareSearch("test").setQuery(termsQuery("num_integer", new int[] { 1 })).get();
            SearchResponse searchResponse = assertSearchResponse(request);
            searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();  
        public Map<String, AnalysisProvider<CharFilterFactory>> getCharFilters() {
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("num:>20")).get();
                .get();  
                    .put("index.analysis.analyzer.lowercase_analyzer.type", "custom")  
        client().admin()  
            ).setMapping("field1", "type=text,analyzer=lowercase_analyzer")
            client().prepareIndex("products").setId("3").setSource("product", new int[] { 1, 3 }),  
                    .endObject()
        assertHitCount(searchResponse, 3L);
        assertAcked(prepareCreate("test").setMapping("field1", "type=text,analyzer=classic", "field2", "type=text,analyzer=classic"));
        createIndex("test");  
        }
            .get();
            .get();
        refresh();
        searchResponse = client().prepareSearch("test")
                    }
        createIndex("test");  
        assertHitCount(searchResponse, 2L);
        indexRandom(  
                .cluster()  
                    .startObject("ts")
                spanNotQuery(
    public void testTermsQueryWithBitmap64DocValuesQuery() throws Exception {  
import java.util.regex.Pattern;
        indexRandom(
            return singletonMap(
            SearchResponse searchResponse = client().prepareSearch("tl_test")
                .addDocValueField("id-alias")
        searchResponse = client().prepareSearch().setQuery(matchQuery("double", "2")).get();
            )
        );  
    }
        searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();
        refresh();  
                    .endObject()  
        searchResponse = client().prepareSearch("test")
        );
            Exception ex = expectThrows(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
                .prepareUpdateSettings()
        searchResponse = client().prepareSearch()
        client().prepareIndex("test").setId("4").setSource("field1", "test2", "num_long", 4).get();
            assertHitCount(searchResponse, 1);  
        createIndex("test");
            client().prepareIndex("lookup").setId("2").setSource("terms", new String[] { "2" }),
        assertSearchHits(searchResponse, "1", "2");
        super(staticSettings);
        }
        searchResponse = client().prepareSearch("test")
                    jsonBuilder().startObject()  
                    .startObject("bs")
        }  
                        .endObject()  
                .get();
                        .must(boolQuery().mustNot(boolQuery().must(termQuery("field1", "value1")).must(termQuery("field1", "value2"))))  
        logger.info("fuzzy");  
    }
                        .startArray("arr")  
        BoolQueryBuilder boolQuery = boolQuery().must(matchQuery("field1", "a").zeroTermsQuery(MatchQuery.ZeroTermsQuery.NONE))
        assertHitCount(searchResponse, 1L);
            .get();  
                boolQuery().must(matchAllQuery()).must(constantScoreQuery(matchQuery("field1", "quick")).boost(1.0f + random().nextFloat()))
import static org.hamcrest.Matchers.equalTo;
        assertHitCount(searchResponse, 0L);  
                        .field("field2", "value2_3")
            client().prepareIndex("lookup2")
        searchResponse = client().prepareSearch().setQuery(matchQuery("text", "uniy").fuzziness(Fuzziness.customAuto(5, 7))).get();
        assertHitCount(
            hitIds.add(hit.getId());  
    }
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();
        IndexRequestBuilder indexRequest = client().prepareIndex("test").setId("1").setRouting("custom").setSource("field", "value");  
        assertFirstHit(searchResponse, hasId("2"));
            .setQuery(constantScoreQuery(termsQuery("employee_id", bitmapBytes).valueType(TermsQueryBuilder.ValueType.BITMAP)))
import org.opensearch.indices.IndicesService;
            true,
        client().prepareIndex("test")
        client().prepareIndex("test").setId("4").setSource("score", 0.5).get();  
            assertThat(field.getValue().toString(), equalTo("1"));
        );  
                .setSource(  
        assertHitCount(searchResponse, 1L);
        client().prepareIndex("test")  
        indexRandomForConcurrentSearch("test");
        assertHitCount(searchResponse, 2L);
            client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value4", "field3", "value3"),
        );  
        client().prepareIndex("test").setId("1").setSource("field1", "value_1", "field2", "value_2").get();  
            )  
                    .endObject()  
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termQuery("num_long", 1))).get();
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchQuery("text", "uniy").fuzziness(Fuzziness.ZERO)).get();
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("vAl*E_1")).get();
        SearchResponse searchResponse = client().prepareSearch()  
                (indexSettings, environment, name, settings) -> TokenizerFactory.newFactory(
                        .startObject()
            assertThat((double) searchResponse.getHits().getAt(1).getScore(), closeTo(2.0, 0.1));  
            SearchResponse searchResponse = client().prepareSearch("test")  
    }  
            WildcardQueryBuilder wildCardQuery = wildcardQuery("field1", "Bb*");  
            client().prepareIndex("test").setId("2").setSource("text", "Unity")
/*
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("value~").field("field1").field("field2")).get(), 1);
        searchResponse = client().prepareSearch("test").setQuery(termQuery("num_double", 1)).get();  
            .setQuery(builder)  
            client().prepareIndex("test")  
        indexRandomForConcurrentSearch("test");
            client().prepareIndex("employees").setId("2").setSource("employee_id", 2000000000002L),
        createIndex("test1");  
        assertSecondHit(searchResponse, hasId("1"));  
    }
        builder = multiMatchQuery("value1").field("field1").field("field3", 1.5f).operator(Operator.AND); // Operator only applies on terms
            .get();
import org.opensearch.plugins.AnalysisPlugin;
            )
import static org.opensearch.index.query.QueryBuilders.spanNearQuery;
            assertThat(i + " expected: " + first + " actual: " + actual, Float.compare(first, actual), equalTo(0));  
            client().prepareSearch().setQuery(builder),
    public void testConstantScoreQuery() throws Exception {  
        SearchResponse searchResponse;
            client().prepareIndex("test").setId("2").setSource("field1", "the quick lazy huge brown fox jumps over the tree")  
        }
        assertHitCount(
        assertHitCount(searchResponse, 1L);  
            assertHitCount(searchResponse, 1L);  
    }
        searchResponse = client().prepareSearch()
    public void testEmptyQueryString() throws ExecutionException, InterruptedException, IOException {
            assertHitCount(searchResponse, 2L);
import org.opensearch.common.time.DateFormatter;  
        SearchResponse searchResponse = client().prepareSearch("test")
import java.io.Reader;  
        assertSecondHit(searchResponse, hasId("2"));
                    .get()
        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            .must(matchQuery("field1", "value1").zeroTermsQuery(MatchQuery.ZeroTermsQuery.NONE));
        refresh();
        indexRandomForConcurrentSearch("test");
                        )  
            .get();
            .setQuery(spanOrQuery(spanMultiTermQueryBuilder(QueryBuilders.rangeQuery("description").from("ffa").to("foo"))))
            .setSource("num_byte", 17, "num_short", 17, "num_integer", 17, "num_long", 17, "num_float", 17, "num_double", 17)
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();
        assertThirdHit(searchResponse, hasId("2"));  
            .should(boolQuery().should(termQuery("field1", "value1")).should(termQuery("field1", "value2")).minimumShouldMatch(1))  
    public void testQuotedQueryStringWithBoost() throws InterruptedException {  
        assertHitCount(searchResponse, 4L);  
        client().admin().indices().prepareRefresh("test").get();
        // the mapping needs to be provided upfront otherwise we are not sure how many failures we get back
                    .startObject("employee_id")
            client().prepareIndex("tl_test").setId("1").setSource("val", "1"),
        SearchResponse searchResponse = client().prepareSearch("test")
                    // Both index and doc values enabled (default)  
            client().prepareIndex("test").setId("2").setSource("description", "foo other anything"),  
        assertFirstHit(searchResponse, hasId("4"));
            client().prepareIndex("test").setId("1").setSource("date", "2014-01-01", "num", 1),
            client().prepareIndex("test").setId("2").setSource("field1", "quick lazy huge brown fox", "field2", "quick lazy huge brown fox")
        indexRandomForConcurrentSearch("test");
                    .field("format", "epoch_millis")
            prepareCreate("test").setMapping(
        client().prepareIndex("test").setId("3").setSource("field1", "value3").get();
        );
        assertSearchHits(searchResponse, "1", "3", "4");  
            assertThat(response.getHits().getTotalHits().value(), equalTo(1L));  
        response = client().prepareSearch("test")  
import org.opensearch.index.query.TermQueryBuilder;
                    @Override
            .setQuery(matchPhrasePrefixQuery("field", "Johnnie la").slop(between(2, 5)))
                        .field("y1", "y_1")  
            client().prepareIndex("test")
            client().prepareIndex("test").setId("5").setSource("field", 1000000000003L),
        assertHitCount(searchResponse, 3L);
        try {
        ensureGreen();
                .setQuery(QueryBuilders.queryStringQuery("\"one two\"").defaultField("desc"))  
            RestStatus.BAD_REQUEST,
            assertNoFailures(searchResponse);
        searchResponse = client().prepareSearch("test")
            .get();
        client().prepareIndex("test").setId("2").setSource("score", 1.0).get();
                "type=byte",  
        );
                .get();  
        assertNoFailures(response);  
            SearchResponse request = client().prepareSearch().setQuery(constantScoreQuery(termsQuery("_index", indexNames))).get();
        MultiMatchQueryBuilder multiMatchQuery = multiMatchQuery("value1 value2 foo", "field1", "field2");  
        assertHitCount(searchResponse, 0L);
        createIndex("test");
        assertHitCount(response, 3);
                .get();  
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        assertHitCount(searchResponse, 2L);
        assertThat(searchResponse.getHits().getAt(0).getId(), is("1"));
        assertHitCount(searchResponse, 2L);
        assertFirstHit(searchResponse, hasScore(searchResponse.getHits().getAt(1).getScore()));
import static org.opensearch.index.query.QueryBuilders.existsQuery;
            .startObject("properties")
                    .putList("index.analysis.normalizer.lowercase_normalizer.filter", "lowercase")
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("dbl", new float[] { 2, 4 }))).get();  
        assertHitCount(client().prepareSearch().setQuery(queryStringQuery("")).get(), 0L); // return no docs
        assertHitCount(searchResponse, 1L);  
        boolQuery = boolQuery().must(matchQuery("field1", "a").zeroTermsQuery(MatchQuery.ZeroTermsQuery.ALL));
            assertHitCount(searchResponse, 1L);
        assertSearchHits(searchResponse, "1");
                        .field("term", "4")
 * KIND, either express or implied.  See the License for the
        assertThirdHit(searchResponse, hasId("3"));
        indexRandomForConcurrentSearch("test");
                )
        searchResponse = client().prepareSearch("test").setQuery(idsQuery()).get();
            .setQuery(matchQuery("field1", "the quick brown").cutoffFrequency(3).operator(Operator.AND))
            .get();
            .startObject()
        assertFirstHit(searchResponse, hasId("1"));
        searchResponse = client().prepareSearch("test")  
                    )
    }  
        client().prepareIndex("test").setId("1").setSource("field1", "value1_1", "field2", "value2_1").setRefreshPolicy(IMMEDIATE).get();  
        // wildcard check
        client().prepareIndex("test").setId("2").setSource("field1", "value2").get();  
 * Unless required by applicable law or agreed to in writing,
        assertFirstHit(searchResponse, hasId("1"));  
        searchResponse = client().prepareSearch("test").setQuery(termsLookupQuery("term", new TermsLookup("lookup", "3", "terms"))).get();
            .setQuery(  
                    .startObject("online")
        searchResponse = client().prepareSearch().setQuery(commonTermsQuery("field1", "the lazy fox brown").cutoffFrequency(1)).get();
                    XContentFactory.jsonBuilder()
            .startObject("section")
        assertHitCount(client().prepareSearch("test").setQuery(queryStringQuery("field\\*:/value[01]/")).get(), 1);
    }  
        indexRandom(
        client().prepareIndex("test").setId("3").setSource("field1", "value7", "field2", "value8", "field4", 5).get();
        assertHitCount(searchResponse, 2L);
        )
        indexRandomForConcurrentSearch("test");  
            client().prepareIndex("test").setId("4").setSource("field", 1000000000002L),  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import java.time.ZoneId;  
        assertSearchHits(searchResponse, "1", "2");  
        SearchResponse searchResponse = client().prepareSearch()
            .field("path", "_routing")  
 *
        assertHitCount(searchResponse, 2L);  
    /**
                .setId("1")
        indexRandomForConcurrentSearch("test");
        client().prepareIndex("test")  
        refresh();
            .setQuery(
            // Only one should clause is defined, returns no docs.
        assertAcked(prepareCreate("test").setMapping("text", "type=text"));
        indexRandomForConcurrentSearch("lookup3");  
        searchResponse = client().prepareSearch("test")
        client().prepareIndex("test")  
    }
    }
        SearchResponse searchResponse = client().prepareSearch("test")
        assertHitCount(searchResponse, 0L);
        searchResponse = client().prepareSearch("test").setQuery(termsLookupQuery("_id", new TermsLookup("lookup", "1", "terms"))).get();  
        SearchResponse searchResponse = client().prepareSearch("test")
                boolQuery().must(termQuery("online", true))
            .setQuery(commonTermsQuery("field1", "the quick brown").cutoffFrequency(3).analyzer("stop"))  
            .endObject()
            SearchResponse searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();
        refresh();
import org.opensearch.search.SearchHits;
        assertHitCount(client().prepareSearch("test").setSize(0).setQuery(rangeQuery("field").gte(999999999999L)).get(), 6);  
        indexRandom(
        }  
        indexRandomForConcurrentSearch("test");  
        searchResponse = client().prepareSearch().setQuery(builder).get();
            true,
        assertSearchHits(searchResponse, "1", "3");
            .setQuery(commonTermsQuery("field1", "the huge fox").cutoffFrequency(100).lowFreqMinimumShouldMatch("3"))  
            .get();  
        // means all terms must match
        indexRandomForConcurrentSearch("test");
            prepareCreate("products").setMapping(  
    */
                jsonBuilder().startObject()
        assertFirstHit(searchResponse, hasId("1"));  
            client().prepareIndex("test").setId("1").setSource("foo", "bar"),
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1))
        for (int i = 0; i < iters; i++) {  
        indexRandomForConcurrentSearch("test");  
        assertThat(  
                            )  
            .should(boolQuery().should(termQuery("field1", "value1")).should(termQuery("field1", "value2")).minimumShouldMatch(3))
        indexRandomForConcurrentSearch("tl_test");
            .setQuery(multiMatchQuery("the quick brown", "field1", "field2").cutoffFrequency(3).operator(Operator.AND))
        }  
            RestStatus.BAD_REQUEST,  
        assertFailures(  
                    jsonBuilder().startObject()  
            .setQuery(  
        createIndex("test");
        QueryBuilder nestedQuery = QueryBuilders.nestedQuery(
        {
        refresh();
    /**  
        float first = response.getHits().getAt(0).getScore();
        assertHitCount(searchResponse, 1L);
                    spanTermQuery("description", "sleeping")
    public void testSimpleSpan() throws IOException, ExecutionException, InterruptedException {  
            client().prepareIndex("test")  
            .get();
import org.opensearch.core.xcontent.XContentBuilder;  
    }
     * See https://github.com/elastic/elasticsearch/issues/46300 for details.  
        {  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            multiMatchQuery("a", "field1", "field2").zeroTermsQuery(MatchQuery.ZeroTermsQuery.NONE)  
        waitForRelocation();  
            .get();
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("num_byte", new int[] { 1 }))).get();  
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;
        refresh();
            client().prepareIndex("test").setId("4").setSource("description", "foo")
        assertFirstHit(searchResponse, hasScore(searchResponse.getHits().getAt(1).getScore()));
        RangeQueryBuilder range = new RangeQueryBuilder("int_range").relation("intersects").from(Integer.MIN_VALUE).to(Integer.MAX_VALUE);
        r.serialize(ByteBuffer.wrap(array));
            .get();
            SearchResponse searchResponse = client().prepareSearch("test")
        refresh();
    }
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("lng", new long[] { 2, 5 }))).get();  
                "num_byte",
            .indices()
            client().prepareIndex("employees2").setId("3").setSource("employee_id", 3000000000003L)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertHitCount(searchResponse, 2L);
        SearchResponse searchResponse = client().prepareSearch().setQuery(queryStringQuery("num:>19")).get();
}
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
        searchResponse = client().prepareSearch().setQuery(matchPhrasePrefixQuery("field", "trying")).get();  
        SearchResponse searchResponse = client().prepareSearch().setQuery(queryStringQuery("value*")).get();
            assertHitCount(searchResponse, 1L);
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(range).get();  
                ).dist(5)  
            .setQuery(termsLookupQuery("term", new TermsLookup("lookup", "missing", "terms")))  
            .endObject()  
                        .endObject()
        indexRandomForConcurrentSearch("test");  
        assertHitCount(searchResponse, 1L);
        createIndex("test_1");
            String errorMsg = ex.getMessage() != null ? ex.getMessage() : ex.getCause().getMessage();
        SearchResponse searchResponse = client().prepareSearch().setQuery(constantScoreQuery(matchQuery("field1", "quick"))).get();  
        assertFirstHit(searchResponse, hasId("2"));
import static org.opensearch.index.query.QueryBuilders.termQuery;
        );
        searchResponse = client().prepareSearch().setQuery(builder).get();
                .setQuery(QueryBuilders.queryStringQuery("xyz").boost(100))  
        SearchResponse searchResponse = client().prepareSearch().setQuery(queryStringQuery("VALUE_3~1")).get();
            bitmap.serializePortable(dos);  
        assertAcked(  
    }  
        searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();
    public void testSpecialRangeSyntaxInQueryString() throws InterruptedException {  
        multiMatchQuery.minimumShouldMatch("70%");
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
        ensureGreen();
                        .field("term", "2")
                    jsonBuilder().startObject()
        SearchResponse searchResponse = client().prepareSearch().setQuery(boolQuery).get();  
        );
                    boolQuery().must(matchAllQuery())
            assertThat(searchHit, hasScore(1.0f));  
        indexRandom(
        );
    public void testEmptytermsQuery() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;  
        assertHitCount(
                        .must(
        assertAcked(  
            .setSource("online", false, "ts", System.currentTimeMillis() - 100, "type", "bs")
                        .endObject()
                "num_short",
                        .endObject()  
        );  
        indexRandomForConcurrentSearch("test");  
                        .startObject()
        refresh();
                QueryBuilders.rangeQuery("date_field").gte("Di., 05 Dez. 2000 02:55:00 -0800").lte("Fr., 08 Dez. 2000 00:00:00 -0800")
        client().prepareIndex("test").setId("2").setSource("field1", "value2").get();  
                            constantScoreQuery(matchQuery("field1", "quick")).boost(
import org.opensearch.common.xcontent.XContentFactory;
            prepareCreate("test").setMapping(
        SearchResponse searchResponse = client().prepareSearch().setQuery(boolQuery).get();
            .get();
import static org.opensearch.index.query.QueryBuilders.matchPhrasePrefixQuery;
        assertHitCount(searchResponse, 1L);
                .setQuery(QueryBuilders.queryStringQuery("\"one two\"").defaultField("desc"))  
        refresh();
        // test valid type, but no matching terms
        SearchResponse searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();
        );  
                    ),
            .setQuery(QueryBuilders.rangeQuery("date").from("2013-12-31T23:00:00").to("2013-12-31T23:59:00"))  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertHitCount(searchResponse, 1);
        assertFirstHit(searchResponse, hasId("1"));
        assertHitCount(searchResponse, 1L);
        assertFirstHit(searchResponse, hasId("2"));
            .setQuery(commonTermsQuery("field1", "the huge fox").cutoffFrequency(1).lowFreqMinimumShouldMatch("2"))
                    .endObject()  
        searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();
            .field("type", "alias")
            SearchResponse searchResponse = client().prepareSearch("test")
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("num_double", new int[] { 1 }))).get();  
        assertNoFailures(searchResponse);  
 * this file be licensed under the Apache-2.0 license or a
            (double) searchResponse.getHits().getAt(0).getScore(),
            client().prepareIndex("test")
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertFirstHit(searchResponse, hasId("1"));
import org.opensearch.search.SearchService;  
        assertHitCount(searchResponse, 1L);
            true,
        assertHitCount(searchResponse, 1L);
        );  
                ),  
            .setQuery(QueryBuilders.rangeQuery("date").from("2013-12-31T23:00:00Z").to("2013-12-31T23:59:00Z").timeZone("+10:00"))
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
                        .endObject()  
        SearchResponse response = client().prepareSearch("test").setQuery(query).get();
        assertHitCount(searchResponse, 2L);
                .prepareUpdateSettings()
        assertFirstHit(searchResponse, hasId("1"));
    public void testLowercaseExpandedTerms() throws InterruptedException {  
import org.opensearch.action.index.IndexRequestBuilder;
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);  
                .setTransientSettings(Settings.builder().putNull(IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey()))
            true,
    }
        assertFirstHit(searchResponse, hasId("1"));
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("dbl", new double[] { 2, 3 }))).get();
        client().prepareIndex("test").setId("1").setSource("field", "foobarbaz").get();
        assertThirdHit(searchResponse, hasId("2"));
    }  
        response = client().prepareSearch("test").setQuery(spanOrQuery(spanMultiTermQueryBuilder(prefixQuery("description", "fo")))).get();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("num:<=20")).get();  
            client().prepareIndex("test").setId("1").setSource("field1", "quick brown fox", "field2", "quick brown fox"),
                "num_long",
import org.opensearch.common.unit.Fuzziness;
        // object check  
        // Same timezone set with time_zone
        searchResponse = client().prepareSearch().setQuery(matchQuery("text", "uniy").fuzziness(Fuzziness.AUTO)).get();  
 * specific language governing permissions and limitations
                .get();
                        .endArray()
                .get();  
        assertHitCount(searchResponse, 1L);
            // Raise the limit so the same query succeeds
            client().prepareIndex("test").setId("6").setSource("field", 999999999999L)
        assertSearchHits(searchResponse, "2", "4");
        indexRandomForConcurrentSearch("test");
        // as with dynamic mappings some shards might be lacking behind and parse a different query
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 2L);  
            + "       \"all_of\" : {"
                        .field("term", "3")
                        .field("obj1_val", "1")
        // directly building the terms query builder, so pass in the bitmap value as BytesArray
            .endObject()  
            .field("type", "alias")  
    }
            3L  
                    .startObject("properties")  
        response = client().prepareSearch("test")
        assertAcked(prepareCreate("lookup3").setMapping("_source", "enabled=false", "terms", "type=text"));
                "num_float",
            .must(multiMatchQuery("value1", "field1", "field2").zeroTermsQuery(MatchQuery.ZeroTermsQuery.NONE));  
        searchResponse = client().prepareSearch().setQuery(existsQuery("field2")).get();
                    XContentFactory.jsonBuilder()
            client().prepareIndex("test").setId("1").setSource("field1", "quick brown fox", "field2", "quick brown fox"),  
                        .startObject()
        searchResponse = client().prepareSearch("test").setQuery(termQuery("num_short", 1)).get();  
        assertHitCount(searchResponse, 1L);  
        searchResponse = client().prepareSearch("test")  
            .get();
        refresh();
        searchResponse = client().prepareSearch("test").setQuery(termsLookupQuery("term", new TermsLookup("lookup3", "1", "terms"))).get();
                .setQuery(QueryBuilders.queryStringQuery("\"one two\"").defaultField("desc"))
            .get();
                        boolQuery().should(
    public void testWildcardQueryNormalizationKeywordSpecialCharacters() throws InterruptedException {
        logger.info("--> term query on 1");
        indexRandomForConcurrentSearch("test");
import java.util.Set;  
        assertSearchHits(searchResponse, "1", "3");
        assertHitCount(searchResponse, 2L);
 * the Apache License, Version 2.0 (the "License"); you may
        );  
            .setSize(100)
import static org.opensearch.index.query.QueryBuilders.matchQuery;  
        searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("1", "3")).get();
        assertFirstHit(searchResponse, hasId("2"));  
        assertHitCount(searchResponse, 2L);  
            );  
            .get();
            2L
        assertThat(searchResponse.getHits().getHits().length, equalTo(3));
                )  
        searchResponse = client().prepareSearch().setQuery(constantScoreQuery(existsQuery("field1"))).get();  
        builder = multiMatchQuery("value1", "field1", "field2").operator(Operator.AND); // Operator only applies on terms inside a field!
        assertHitCount(searchResponse, 2L);  
                Settings.builder()
            client().prepareIndex("test").setId("1").setSource("field1", "value1"),
        // Same timezone set with time_zone but another timezone is set directly within dates which has the precedence
 * ownership. Elasticsearch licenses this file to you under  
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termQuery("num_byte", 1))).get();
                for (SearchHit searchHit : hits) {
        assertFirstHit(searchResponse, hasId("1"));
        searchResponse = client().prepareSearch().setQuery(existsQuery("x*")).get();
            SearchResponse searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();
                    public String name() {
        createIndex("test");
                    .startObject("properties")
        assertFirstHit(searchResponse, hasId("1"));
        assertThat(hitIds, containsInAnyOrder(ids));
            assertThat(searchHit, hasScore(1.0f));  
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").get();  
                "num_integer",  
        bitmap.addLong(1000000000001L);
    }
        SearchResponse searchResponse = client().prepareSearch()  
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
            assertHitCount(searchResponse, 0L);
            .get();  
    public void testSimpleDFSQuery() throws IOException, InterruptedException {  
        assertThirdHit(searchResponse, hasId("2"));
        assertFirstHit(searchResponse, hasId("1"));
        );  
                    .endObject()  
    }  
        WrapperQueryBuilder wrapperFilter = wrapperQuery("{ \"term\" : { \"field1\" : \"value1_1\" } }");  
        client().prepareIndex("test").setId("1").setSource("past", "2015-04-05T23:00:00+0000").get();  
        DataOutputStream dos = new DataOutputStream(bos);  
        assertAcked(prepareCreate("test").setMapping("field1", "type=text,analyzer=classic", "field2", "type=text,analyzer=classic"));
import static org.opensearch.index.query.QueryBuilders.spanTermQuery;
            .endObject()
    public void testWildcardCaseSensitivity() throws InterruptedException {
        indexRandom(
    public void testFieldAliasesForMetaFields() throws Exception {
        client().prepareIndex("test").setId("1").setSource("past", now).get();
        SearchResponse searchResponse = client().prepareSearch("index").setQuery(nestedQuery).get();
        indexRandom(
            .should(boolQuery().should(termQuery("field1", "value1")).should(termQuery("field1", "value2")).minimumShouldMatch(3));  
    public void testDateRangeInQueryStringWithTimeZone_7880() throws InterruptedException {  
        indexRandomForConcurrentSearch("test");  
        refresh();  
    }  
import static org.opensearch.index.query.QueryBuilders.fuzzyQuery;
import org.opensearch.index.query.RangeQueryBuilder;
            searchResponse = client().prepareSearch("test")
                "num_short",
        assertHitCount(searchResponse, 2L);  
            ScoreMode.Max
                    .endObject()
            client().prepareSearch()  
        assertHitCount(searchResponse, 1L);
        assertThirdHit(searchResponse, hasId("3"));
        refresh();
            assertThat(hits.getTotalHits().value(), equalTo(totalHits));
                .setSource("field1", "quick lazy huge brown pidgin", "field2", "the quick lazy huge brown fox jumps over the tree"),
        assertFirstHit(searchResponse, hasId("3"));
        assertHitCount(searchResponse, 0L);
            .setQuery(constantScoreQuery(termsQuery("term", new String[0])))
        assertHitCount(searchResponse, 1L);
            client().prepareIndex("test").setId("1").setSource("field", 1000000000001L),  
        float boost = 10.0f;
            .setQuery(boolQuery().mustNot(matchQuery("description", "anything")))  
            .startObject("distance")
        assertHitCount(searchResponse, 3L);  
import java.nio.ByteBuffer;
                        .field("obj2_val", "1")  
            .get();
                    .endObject()
        return 7;
            MatchQueryBuilder matchQuery = matchQuery("f", English.intToEnglish(between(0, num)));
        logger.info(" --> Using time_zone [{}], now is [{}]", timeZone.getId(), now);
        client().prepareIndex("test").setId("2").setSource("past", "2015-04-06T00:00:00+0000").get();
                .setId("2")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
        BytesArray bitmapBytes = new BytesArray(bos.toByteArray());
        // conjunction of all terms (the lowFreqMinimumShouldMatch parameter is effectively ignored)
                )
            searchResponse = client().prepareSearch().setQuery(wildCardQuery).get();
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();  
            .setSource(jsonBuilder().startObject().startObject("int_range").field("gte", 10).field("lte", 20).endObject().endObject())  
            () -> client().prepareSearch().setQuery(queryStringQuery("future:[now/D TO now+2M/d]").lenient(false)).get()
            ).setMapping("field1", "type=keyword,normalizer=lowercase_normalizer")  
    @Override
        assertHitCount(searchResponse, 0L);  
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;
        searchResponse = client().prepareSearch().setQuery(builder).get();  
        assertHitCount(searchResponse, 1L);
        logger.info("prefix");  
        searchResponse = client().prepareSearch("test")
    private void assertHits(SearchHits hits, String... ids) {
            .setId("3")
        assertHitCount(searchResponse, 1L);
        assertAcked(client().admin().indices().prepareCreate("test"));
        bitmap.addLong(4000000000004L);  
        assertThat(e.toString(), containsString("unit [D] not supported for date math"));
        indexRandomForConcurrentSearch("test");  
    }
        createIndex("test");
            .get();
        assertHitCount(response, 1L);
            .get();
            .minimumShouldMatch(1);
    public void testSpanMultiTermQuery() throws IOException, InterruptedException {
        SearchResponse response = client().prepareSearch("test").setQuery(wildcardQuery("field", "Text").caseInsensitive(false)).get();
        );  
        searchResponse = client().prepareSearch()  
import org.opensearch.common.regex.Regex;
            .get();
            .get();
            .setSource("num_byte", 2, "num_short", 2, "num_integer", 2, "num_long", 2, "num_float", 2, "num_double", 2)  
            prepareCreate("test").setSettings(
            true,
        searchResponse = client().prepareSearch().setQuery(builder).get();
    public void testPassQueryOrFilterAsJSONString() throws Exception {  
            .setFrom(0)
        SearchResponse searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("1", "2")).get();
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("+num:>11 +num:<20")).get();  
        assertSearchHits(searchResponse, "1", "2");
import org.opensearch.search.aggregations.AggregationBuilders;
        assertNoFailures(response);
        client().prepareIndex("test").setId("1").setSource("past", aMonthAgo, "future", aMonthFromNow).get();
        assertHitCount(client().prepareSearch().setPostFilter(wrapperFilter).get(), 1L);
import org.opensearch.core.common.bytes.BytesArray;  
        refresh();
                .setSource("date", Instant.now().atZone(ZoneOffset.ofHours(1)).toInstant().toEpochMilli(), "num", 4)
import org.opensearch.index.query.QueryBuilders;  
import java.time.format.DateTimeFormatter;  
            + "                       { \"match\" : { \"query\" : \"cold\" } },"  
            // Reset transient setting
        assertHitCount(searchResponse, 1L);
            assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
        assertSearchHits(searchResponse, "1", "3");  
                                boolQuery().must(rangeQuery("ts").lt(System.currentTimeMillis() - (15 * 1000))).must(termQuery("type", "s"))
            prepareCreate("employees").setMapping(
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();  
                .setId("3")  
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T00:00:00").to("2014-01-01T00:59:00"))
                    .endObject()
                "type=double"
            .setRouting("Y")
                    .put("index.analysis.char_filter.no_wildcard.type", "mock_pattern_replace")  
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("[VALUE_1 TO VALUE_3]")).get();
        refresh();
            .field("distance", 42)  
import static org.opensearch.index.query.QueryBuilders.termsQuery;
            .setQuery(QueryBuilders.rangeQuery("date").from("2014-01-01T00:00:00Z").to("2014-01-01T00:59:00Z").timeZone("+10:00"))  
            .get();
            .endObject();
    public void testIntervals() throws InterruptedException {  
        assertHitCount(searchResponse, 3L);
        assertHitCount(client().prepareSearch().setQuery(queryStringQuery("quick")).get(), 3L);
                    name,
        client().prepareIndex("test").setId("1").setSource("str", "foobar", "date", "2012-02-01", "num", 12).get();
            client().prepareIndex("lookup").setId("3").setSource("terms", new String[] { "2", "4" }),
        searchResponse = client().prepareSearch().setQuery(idsQuery().addIds("1")).get();
    }
                ),  
                        QueryBuilders.spanTermQuery("description", "fox")  
        assertHitCount(searchResponse, 3L);
        searchResponse = client().prepareSearch().setQuery(boolQuery).get();  
        client().prepareIndex("test").setId("2").setSource("field2", "value1").get();
import java.util.Arrays;
        boolQuery = boolQuery().should(termQuery("field1", "value1"))  
import org.opensearch.index.search.MatchQuery;
        assertHitCount(searchResponse, 1L);
                "type=float",
            client().prepareIndex("test").setId("4").setSource("str", "4", "lng", 4L, "dbl", 4.0d)
            + "           \"ordered\" : \"true\","
        assertHitCount(searchResponse, 2L);
                .setPostFilter(QueryBuilders.termQuery("type", "product"))
                    .endObject()
        assertAcked(prepareCreate("test").setMapping("past", "type=date", "future", "type=date"));  
            .get();
            hits = searchResponse.getHits();  
        assertAcked(prepareCreate("test").setMapping("term", "type=text"));
            .get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        );  
                .setQuery(termQuery("routing-alias", "custom"))
            SearchResponse request = client().prepareSearch().setQuery(constantScoreQuery(termsQuery("_index", indexName))).get();
            client().prepareIndex("test").setId("1").setSource("text", "Unit"),  
                .setQuery(QueryBuilders.queryStringQuery("\"one three\"~5").field("desc"))
        client().prepareIndex("test").setId("1").setSource("field1", "Bbb Aaa").get();
    public void testMatchQueryNumeric() throws Exception {
        assertHitCount(searchResponse, 4L);  
        r.add(1);
        int num = scaledRandomIntBetween(100, 200);  
                    .startObject("arr")
        client().prepareIndex("test").setId("1").setSource("{}", MediaTypeRegistry.JSON).get();
                    boolQuery().must(
    }
                            .should(termQuery("field1", "value3"))
        assertHitCount(searchResponse, 1L);
            .setExplain(true)  
        assertHitCount(searchResponse, 2L);
 */  
        }
            wildCardQuery = wildcardQuery("field1", "bb*");  
        }
        searchResponse = client().prepareSearch("test")  
    /**
    }
        logger.info("--> term filter on 1");  
                .setQuery(QueryBuilders.queryStringQuery("\"one two\"").field("desc"))
import static org.opensearch.index.query.QueryBuilders.spanOrQuery;  
            .must(boolQuery().should(termQuery("field1", "value1")).should(termQuery("field1", "value2")).minimumShouldMatch(3));
        for (String indexName : indexNames) {  
    }  
        createIndex("test");
    }
        );
        searchResponse = client().prepareSearch().setQuery(multiMatchQuery).get();  
        assertFirstHit(searchResponse, hasId("1"));
                    .field("type", "boolean")  
        {
    public void testTermsLookupSubqueryRespectsMaxClauseCount() throws Exception {  
        assertAcked(
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
    * Test that wildcard queries on keyword fields get normalized  
            .field("path", "_id")
        searchResponse = client().prepareSearch("test").setQuery(termQuery("num_float", 1)).get();  
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("field1", "value1"))).get();
        );
        assertHitCount(searchResponse, 1L);  
                    .startObject("term")
            );
            client().prepareIndex("test")
                            SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.getKey(),
        assertHitCount(searchResponse, 2L);  
            + "                   \"intervals\" : ["
        }
        assertFirstHit(searchResponse, hasId("2"));
        refresh();
        assertAcked(prepareCreate("test").setMapping("str", "type=text", "lng", "type=long", "dbl", "type=double"));
        assertSearchHits(searchResponse, "1", "3");
                    .endObject()
 *
        }
            .get();
            client().prepareIndex("test").setId("2").setSource("field1", "quick brown"),  
            .setQuery(termsLookupQuery("term", new TermsLookup("lookup2", "3", "arr.term")))  
            true,  
                .setQuery(  
        // cutoff frequency of 100 makes all terms low frequency, so lowFreqMinimumShouldMatch=3  
        client().prepareIndex("test")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            true,
        builder = multiMatchQuery("value1", "field1", "field2", "field4");
        boolQuery = boolQuery().must(matchQuery("field1", "a").zeroTermsQuery(MatchQuery.ZeroTermsQuery.ALL))  
        assertAcked(prepareCreate("test").setSettings("{\"index.analysis.analyzer.default.type\":\"keyword\"}", MediaTypeRegistry.JSON));  
                    .startObject("date_field")
import java.io.ByteArrayOutputStream;  
        indexRandom(  
            )  
                jsonBuilder().startObject()  
            .get();
        builder.lenient(true);  
        assertHitCount(searchResponse, 1L);  
        client().prepareIndex("test").setId("2").setSource("field1", "value2").get();  
        assertSearchHits(searchResponse, "2", "4");  
            WildcardQueryBuilder wildCardQuery = wildcardQuery("field1", "Bb*");
        }
        client().prepareIndex("test").setId("3").setSource("description", "foo other", "count", 3).get();
                .setPostFilter(QueryBuilders.termQuery("type", "customer"))
                            SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.getDefault(Settings.EMPTY)  
            .minimumShouldMatch(2);
    public void testMultiMatchQueryZeroTermsQuery() throws InterruptedException {
            assertHitCount(searchResponse, 6L);  
        );  
            client().prepareSearch().setQuery(matchPhraseQuery("field1", "quick brown").slop(0)),
        SearchResponse searchResponse = client().prepareSearch("test")  
    public void testNestedQueryWithFieldAlias() throws Exception {
        assertThat(searchResponse.getHits().getAt(0).getId(), is("1"));  
        searchResponse = client().prepareSearch()  
    // see #2994
    }
        );
                    .field("type", "long")
        searchResponse = client().prepareSearch()
                .get();
        assertFirstHit(searchResponse, hasId("1"));  
    // Issue #7880
        assertAcked(prepareCreate("test").setMapping("past", "type=date"));  
                    .putList("index.analysis.analyzer.lowercase_analyzer.filter", "lowercase")
/*  
                    ),
     */
            assertEquals(2, hit.getFields().size());
            .setQuery(queryStringQuery("past:[2015-04-06T00:00:00+0200 TO 2015-04-06T23:00:00+0200]"))
        assertAcked(prepareCreate("test").setMapping("date", "type=date", "num", "type=integer"));
        refresh();
        assertHitCount(searchResponse, 1L);  
            .setQuery(queryStringQuery("past:[2015-04-06T00:00:00-0200 TO 2015-04-06T23:00:00-0200]").timeZone("+0200"))
            client().prepareIndex("tl_lookup").setId("1").setSource("val", "1"),
            client().prepareIndex("test").setId("2").setSource("foo", "bar")
            .get();  
            client().prepareIndex("test").setId("1").setSource("long", 1L, "double", 1.0d),
        assertAcked(  
                "type=short",
        assertFirstHit(searchResponse, hasId("1"));  
        searchResponse = client().prepareSearch("test").setQuery(multiMatchQuery("value2").field("field2", 2).lenient(true)).get();
        assertHitCount(searchResponse, 1L);
            client().prepareIndex("test").setId("2").setSource("term", "2"),
        indexRandomForConcurrentSearch("test");
        assertAcked(prepareCreate("test").setMapping("long", "type=long", "double", "type=double"));  
        refresh();  
        searchResponse = client().prepareSearch("test").setQuery(termsLookupQuery("term", new TermsLookup("lookup", "4", "terms"))).get();
                .setId("1")
                        .endObject()  
                        .field("term", "1")
            )
        public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
        builder = multiMatchQuery("value1", "field1").field("field3", 1.5f).operator(Operator.AND); // Operator only applies on terms inside  
            client().prepareIndex("test").setId("3").setSource("field1", "value3")
        assertHitCount(searchResponse, 1L);  
            prepareCreate("employees2").setMapping(
    public void testTermsQuery() throws Exception {  
                    .build()  
            .setQuery(spanOrQuery(spanMultiTermQueryBuilder(regexpQuery("description", "fo{2}"))))
                    boolQuery().must(matchAllQuery())
                        QueryBuilders.spanTermQuery("description", "fox")  
            client().prepareIndex("tl_lookup").setId("2").setSource("val", "2"),
            )
                    .startObject("product")  
        String json = "{ \"intervals\" : "
        assertHitCount(searchResponse, 1L);
            )  
        searchResponse = client().prepareSearch("test")
                )
     */
import org.opensearch.index.query.MatchQueryBuilder;
        indexRandomForConcurrentSearch("test");
                    .put("index.analysis.normalizer.no_wildcard.type", "custom")
        SearchResponse searchResponse = client().prepareSearch().setQuery(queryStringQuery("str:foobaz~1")).get();
            .setQuery(
import org.roaringbitmap.longlong.Roaring64NavigableMap;
        searchResponse = client().prepareSearch("test").setQuery(termsLookupQuery("term", new TermsLookup("lookup", "1", "terms"))).get();
        assertHitCount(searchResponse, 1L);  
        assertHitCount(searchResponse, 2L);
            .get();
    }  
        assertHitCount(searchResponse, 1L);
        client().prepareIndex("test").setId("1").setSource("field1", new String[] { "value1", "value2", "value3" }).get();
        indexRandomForConcurrentSearch("test");
        assertHitCount(searchResponse, 2L);
    }  
                ),  
    }
 */  
import org.opensearch.index.analysis.CharFilterFactory;
        assertNoFailures(searchResponse);
                    .endObject()  
                }
        assertHitCount(response, 3);  
        assertHitCount(searchResponse, 0L);  
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("*ue*")).get();
        // stop drops "the" since its a stopword
                        .endArray()
            )
        assertSecondHit(searchResponse, hasId("1"));  
                    .field("type", "keyword")
            client().prepareIndex("test").setId("1").setSource("str", "1", "lng", 1L, "dbl", 1.0d),
    public void testFiltersWithCustomCacheKey() throws Exception {
        assertHitCount(searchResponse, 2L);
import org.opensearch.index.query.functionscore.ScoreFunctionBuilders;  
    }  
            true,
            client().prepareIndex("test").setId("1").setSource("description", "foo other anything bar"),
            .setQuery(  
        client().prepareIndex("test").setId("1").setSource("field1", "Bbb Aaa").get();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasScore;  
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        searchResponse = client().prepareSearch()  
        createIndex("test");
        assertHitCount(searchResponse, 1L);
            true,
        // test partial matching
            .setQuery(commonTermsQuery("field1", "the lazy fox brown").cutoffFrequency(1).highFreqMinimumShouldMatch("3"))  
        searchResponse = client().prepareSearch().setQuery(queryStringQuery("_exists_:field1")).get();
            .setQuery(termsLookupQuery("not_exists", new TermsLookup("lookup2", "3", "arr.term")))  
    public void testQueryStringAnalyzedWildcard() throws Exception {
            .endObject();  
        assertSearchHits(searchResponse, "2");
        assertFirstHit(searchResponse, hasScore(searchResponse.getHits().getAt(1).getScore()));  
        searchResponse = client().prepareSearch("test")
        indexRandom(
        SearchResponse searchResponse = client().prepareSearch("employees")
            .setId("17")
        indexRandomForConcurrentSearch("test");
        assertHitCount(searchResponse, 2L);  
 * not use this file except in compliance with the License.
            containsString("NumberFormatException[For input string: \"value1\"]")  
import static org.opensearch.index.query.QueryBuilders.commonTermsQuery;  
        assertFirstHit(searchResponse, hasId("1"));  
            });  
                        .startArray("arr")  
        );  
        searchResponse = client().prepareSearch("test")
                    .field("format", "E, d MMM yyyy HH:mm:ss Z")  
    // see #3521
            wildCardQuery = wildcardQuery("field1", "Bb*").caseInsensitive(true);
import org.apache.lucene.search.join.ScoreMode;  
        assertSearchHits(searchResponse, "1", "2");
        }
            assertAcked(client().admin().indices().prepareCreate(indexName));  
        assertFirstHit(searchResponse, hasId("1"));  
import static org.hamcrest.Matchers.containsString;  
            .get();
        assertHitCount(searchResponse, 1L);
                    .field("type", "text")
        boolQuery = boolQuery().must(multiMatchQuery("a", "field1").zeroTermsQuery(MatchQuery.ZeroTermsQuery.ALL));  
            .startObject()  
        assertSearchHits(searchResponse, "1", "2");  
            client().prepareIndex("tl_test").setId("3").setSource("val", "3"),  
        indexRandomForConcurrentSearch("test");
            client().prepareIndex("test").setId("3").setSource("field1", "quick")
            QueryBuilders.termQuery("section.route_length_miles", 42),
        searchResponse = client().prepareSearch("test")
        assertHitCount(searchResponse, 1L);
            .setQuery(queryStringQuery("past:[2015-04-06T00:00:00-0200 TO 2015-04-06T23:00:00-0200]"))
        assertSearchHits(searchResponse, "2");  
            .startObject("routing-alias")
        assertHitCount(searchResponse, 3L);
        createIndex("test");
        // index "lookup3" type "type" has the source disabled: ignore the lookup terms
        client().prepareIndex("test").setId("1").setSource("field1", new String[] { "value1", "value2", "value3" }).get();  
        assertHitCount(searchResponse, 0L);
        // We define a time zone to be applied to the filter and from/to have no time zone  
        assertHitCount(searchResponse, 2);
        assertHitCount(searchResponse, 1);
        } finally {  
    }  
        {  
     * {@link AttributeSource}.  
                .get(),
            .get();  
            .get();
     * asserts the search response hits include the expected ids  
                    spanTermQuery("description", "jumped")
        indexRandomForConcurrentSearch("tl_lookup");  
                    .must(  
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;  
            prepareCreate("test").setMapping(
        searchResponse = client().prepareSearch("test").setQuery(constantScoreQuery(termsQuery("str", "2", "5"))).get();
                .setTransientSettings(Settings.builder().put(SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.getKey(), 3))
        SearchResponse searchResponse = client().prepareSearch()
        for (String indexName : indexNames) {  
        for (int i = 0; i < builders.length; i++) {
                    .startObject("properties")  

        // Create index with derived source setting enabled
            e.toString(),
        int max = randomIntBetween(3, 29);
            assertEquals("Source should only contain 2 fields", 2, source.size());
        super(settings);
            while (randomPreference.startsWith("_")) {
                    + defaultMaxRegexLength
 * software distributed under the License is distributed on an
                            .field("constant_keyword", "1")
                .setTerminateAfter(5)
            true,
import org.opensearch.core.xcontent.MediaTypeRegistry;
            // when size = 0 which is when TotalHitCountCollector is used.
                )
        assertAcked(prepareCreate("test_derive").setSource(createIndexSource, MediaTypeRegistry.JSON));
            .setQuery(QueryBuilders.rangeQuery("field").gte("2010-01-03||+2d").lte("2010-01-04||+2d/d"))
        SearchResponse search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "192.168.0.1"))).get();
        }
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
        prepareCreate("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0)).get();
                .setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) / 2)
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "2001:db8::ff00:42:8329/128"))).get();
        assertNoFailures(searchResponse);
                .setSettings(
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "192.0.0.0/8"))).get();
 */
        );
                "Rescore window ["
                                "type": "wildcard",
                .prepareUpdateSettings("idx")
                            },
        } catch (SearchPhaseExecutionException ex) {
        for (int i = 1; i < max; i++) {
 * not use this file except in compliance with the License.
        dotestSimpleTerminateAfterCountWithSize(0, max);
                .put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) * 2)
            assertThat(ex.getRootCause().getMessage(), containsString("Can only use regexp queries on keyword and text fields"));
        assertEquals(GREATER_THAN_OR_EQUAL_TO, searchResponse.getHits().getTotalHits().relation());
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
        assertEquals(5, searchResponse.getHits().getTotalHits().value());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            Settings.builder()
                    .endObject()
                            IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(),
        prepareCreate("idx").setSettings(Settings.builder().put(IndexSettings.MAX_RESCORE_WINDOW_SETTING.getKey(), defaultMaxWindow * 2))
        SearchResponse searchResponse;
import java.util.List;
        }
import static org.hamcrest.Matchers.containsString;
    }
        assertThat(
        refresh();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                        "number_of_replicas": 0,
                            "keyword_field": {
    }
        ).setMapping("rank", "type=integer").get();
        expectThrows(
                .setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY))
                    .startObject(MapperService.SINGLE_MAPPING_NAME)
            .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(numDocs))
        client().prepareIndex("test").setId("2").setSource("field", "2010-01-06T02:00").get();
                            "date_nanos_field": {
        SearchPhaseExecutionException e = expectThrows(SearchPhaseExecutionException.class, () -> search.get());
        ensureGreen();
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
                    .startObject(MapperService.SINGLE_MAPPING_NAME)
import java.util.Map;
        createIndex("idx");
     *
    }
            fail("SearchPhaseExecutionException should have been thrown");
        }
            assertEquals("192.168.1." + id, source.get("ip_field"));
            docbuilders.add(client().prepareIndex("test").setId(id).setSource("rank", i));
            )
    public void testRegexQueryWithComplementFlag() {
            .setSource(
            .get();
        int defaultMaxWindow = IndexSettings.MAX_RESCORE_WINDOW_SETTING.get(Settings.EMPTY);
            searchResponse = client().prepareSearch("test")
import org.opensearch.geometry.utils.Geohash;
    }
                "This limit can be set by changing the [" + IndexSettings.MAX_RESCORE_WINDOW_SETTING.getKey() + "] index level setting."
                    + IndexSettings.MAX_REGEX_LENGTH_SETTING.getKey()
                .indices()
                QueryBuilders.boolQuery()
        client().prepareIndex("test").setId("1").setSource("field", "2010-01-05T02:00").get();
            lastValue = currentValue;
            .setSource("{\"field\" : 80315953321748200608 }", MediaTypeRegistry.JSON)
                        }
        indexRandom(true, docbuilders);
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
            .get();
                    .startObject("to")
        client().prepareIndex("idx").setSource("{\"field\": 10000.0}", MediaTypeRegistry.JSON).get();
            RestStatus.BAD_REQUEST,
                            "bool_field": {
        prepareCreate("idx").setSettings(
        assertHitCount(search, 5L);
            .setQuery(boolQuery().must(rangeQuery("from").lte("192.168.0.7")).must(rangeQuery("to").gte("192.168.0.7")))
        assertHitCount(
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
    public void testSimpleTerminateAfterTrackTotalHitsUpToSmallSize() throws Exception {
        createIndex("idx");
    public void testTooLargeRescoreOkByResultWindowSetting() throws Exception {
    private void assertRescoreWindowFails(int windowSize) {
                .setTrackTotalHitsUpTo(5)
}
            .addSort("numeric_field", SortOrder.ASC)
        assertThat(
        assertAcked(prepareCreate("idx").setMapping("num", "type=integer"));
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
            containsString(
        createIndex("test");
    public void testSearchRandomPreference() throws InterruptedException, ExecutionException {
                .setTrackTotalHits(true)
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
 *
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                                "type": "keyword"
        prepareCreate("idx").setMapping("field", "type=keyword").get();
    }
     * Special cases when size = 0:
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.search.SearchHit;
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "0.0.0.0/0"))).get();
            Settings.builder()
        client().prepareIndex("test").setId("1").setSource("ip", "192.168.0.1").get();
                    // Note that this is the RESULT window
        assertHitCount(client().prepareSearch("idx").setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) * 10).get(), 1);
            .setSource(
                    }
    public void testTermQueryBigInt() throws Exception {
                .setSize(size)
        assertEquals("Should match exactly 2 documents", 2, matchedIds.size());
            assertTrue("Results should be sorted in descending order", currentValue <= lastValue);
            assertEquals(5, searchResponse.getHits().getTotalHits().value());
                .get();
        );
            assertEquals(5, searchResponse.getHits().getTotalHits().value());
        prepareCreate("idx").setMapping("field", "type=float,doc_values=false").get();
        refresh("idx");
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
            assertEquals(5, searchResponse.getHits().getTotalHits().value());
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "192.168.0.0/24"))).get();
                },
        // Index multiple documents
    public void testTooLargeFromAndSizeOkByDynamicSetting() throws Exception {
                .setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) * 10)
import org.opensearch.search.rescore.QueryRescorerBuilder;
        client().admin()
        ensureGreen();
            .setSize(size)
            assertTrue(searchResponse.isTerminatedEarly());
    }
        while (regexp.length() <= defaultMaxRegexLength) {
                    .endObject()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
    public void testSimpleId() {
import static org.apache.lucene.search.TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO;
        for (SearchHit hit : response.getHits()) {
            client().prepareIndex("test").setId("6").setSource("field", "value")
            .get();
import java.io.IOException;
        searchResponse = client().prepareSearch("test")
        List<IndexRequestBuilder> docbuilders = new ArrayList<>(max);
     *
    public void testTooLargeFromAndSizeOkBySetting() throws Exception {
            .setQuery(QueryBuilders.matchAllQuery())
        try {
        assertThat(e.toString(), containsString("See the scroll api for a more efficient way to request large data sets"));
            boolean boolValue = (Boolean) source.get("bool_field");
        assertFailures(
        assertHitCount(search, 1L);
                    + "] index level setting."
                    .must(QueryBuilders.rangeQuery("numeric_field").gt(5))
                "settings": {
        assertEquals(5, searchResponse.getHits().getTotalHits().value());
                assertThat(searchResponse.getHits().getAt(j).field("rank").getValue(), equalTo((long) j));
                .setSettings(Settings.builder().put(IndexSettings.MAX_RESCORE_WINDOW_SETTING.getKey(), defaultMaxWindow * 2))
/*
        prepareCreate("idx").setSettings(
                            "text_field": {
        RegexpQueryBuilder query = new RegexpQueryBuilder("text.keyword", "a~bc");
            .addSort("numeric_field", SortOrder.DESC)
        client().admin()
            assertEquals(id % 2 == 0, source.get("bool_field"));
                    "index": {
        search = client().prepareSearch().setQuery(queryStringQuery("ip: 192.168.0.1")).get();
                            "numeric_field": {
        assertAcked(
            }
                .setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY))
        assertWindowFails(client().prepareSearch("idx").setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY)));
        prepareCreate("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0)).get();
    }
    }
 * Licensed to Elasticsearch under one or more contributor
            1
                "The length of regex ["
        assertHitCount(search, 4L);
            SearchResponse searchResponse = client().prepareSearch()
        assertRescoreWindowFails(IndexSettings.MAX_RESCORE_WINDOW_SETTING.get(Settings.EMPTY) + 1);
        expectThrows(
            .setSize(size)
    public void testInsaneFromAndSize() throws Exception {
                            },
                            "ip_field": {
        createIndex("idx");
        indexRandom(
                                "type": "boolean"
            Map<String, Object> source = hit.getSourceAsMap();
        response = client().prepareSearch("test_derive")
 * this file be licensed under the Apache-2.0 license or a
                            .field("wildcard_field", "wildcard" + i)
            client().admin()
 * license agreements. See the NOTICE file distributed with
            client().prepareIndex("test").setId("1").setSource("field", "value"),
    }
        // Test 3: Search with range query
        TermQueryBuilder query = TermQueryBuilder.fromXContent(parser);
            .setQuery(QueryBuilders.matchAllQuery())
                .get();
            } else {
                        "number_of_shards": 2,
                client().prepareIndex("test_derive")
        refresh();
            .get();
                                "value": "1"
        if (size > 0) {
            .get();
        );
        assertNoFailures(searchResponse);
            assertEquals(Math.min(i, size), searchResponse.getHits().getHits().length);
                            .field("geopoint_field", Geohash.stringEncode(40.0 + i, 75.0 + i))
            String id = String.valueOf(i);
        response = client().prepareSearch("test_derive").setQuery(QueryBuilders.rangeQuery("numeric_field").from(3).to(6)).get();
            for (int j = 0; j < i; j++) {
                    .startObject("properties")
    public void testQueryNumericFieldWithRegex() throws Exception {
        ensureGreen("idx");
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "0/0/0/0/0"))),
        assertHitCount(
        SearchPhaseExecutionException e = expectThrows(
                                "type": "long"
        int defaultMaxRegexLength = IndexSettings.MAX_REGEX_LENGTH_SETTING.get(Settings.EMPTY);
        int iters = scaledRandomIntBetween(10, 20);
                    .setSource(
            }""";
        } else {
                            },
        createIndex("idx");
    public void testTooLargeRescoreWindow() throws Exception {
        );
                )
                .prepareUpdateSettings("idx")
 * Modifications Copyright OpenSearch Contributors. See
            .setQuery(QueryBuilders.rangeQuery("field").gte("2010-01-05T02:00").lt("2010-01-06T02:00"))
        }
        SearchResponse searchResponse;
import org.opensearch.index.query.TermQueryBuilder;
            // Since terminate_after < track_total_hits, we need to do a range check.
        assertEquals(EQUAL_TO, searchResponse.getHits().getTotalHits().relation());
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
        SearchResponse searchResponse = client().prepareSearch("idx").setQuery(query).get();
     *   Weight#count optimization can cause totalHits in the response to be up to the total doc count regardless of terminate_after.
                            "date_field": {
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "192.168.1.5/32"))).get();
            .get();
        assertThat(
        searchResponse = client().prepareSearch("test")
            e.toString(),
        }
/*
    }
        createIndex("test");
    public void testSimpleIp() throws Exception {
            .setSize(size)
                            "wildcard_field": {
        assertHitCount(search, 3L);
 * under the License.
            assertEquals("keyword_" + id, source.get("keyword_field"));
        );
                .addSort("rank", SortOrder.ASC)
                            IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) * 2
    public void testSimpleTerminateAfterCountRandomSize() throws Exception {
                    .setId(Integer.toString(i))
        for (int i = 0; i < iters; i++) {
    }
                            .field("numeric_field", i)
                            },
        SearchRequestBuilder search = client().prepareSearch("idx")
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "192.168.0.1/32"))).get();
 */
                    .startObject("from")
        assertHitCount(
            e.toString(),
        );
            assertHitCount(searchResponse, 6L);
                .get();
            Map<String, Object> source = hit.getSourceAsMap();
        prepareCreate("test").setSettings(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                assertHitCount(searchResponse, i, max);
        indexRandom(true, builders);
        searchResponse = client().prepareSearch("test")
            .setId("1")
    public static Collection<Object[]> parameters() {
            assertEquals("wildcard" + id, source.get("wildcard_field"));
 * The OpenSearch Contributors require contributions made to
                    + "the allowed maximum of ["
            .get();
        );
                    .endObject()
            () -> client().prepareSearch((String[]) null).setQuery(QueryBuilders.termQuery("_id", "XXX1")).get()
                .setTrackTotalHits(false)
        XContentParser parser = createParser(JsonXContent.jsonXContent, queryJson);
                            "geopoint_field": {
import org.opensearch.index.query.RegexpFlag;
                                "type": "date"
        assertNoFailures(searchResponse);
                .addDocValueField("rank")
                .setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) / 2 - 1)
            assertTrue(numValue > 5);
                            "constant_keyword": {
        assertAcked(
            .indices()
        for (int i = 1; i < max; i++) {
        );
        assertHitCount(
import org.opensearch.action.search.SearchResponse;
     *   This ambiguity is due to the fact that totalHits == track_total_hits_up_to
        client().prepareIndex("idx")
    private void assertWindowFails(SearchRequestBuilder search) {
                XContentFactory.jsonBuilder()
        assertNoFailures(response);
                    IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), // Note that this is the RESULT window.
            .get();
            client().prepareSearch("idx").addRescorer(new QueryRescorerBuilder(matchAllQuery()).windowSize(defaultMaxWindow + 1)).get(),
        ensureGreen();
            );
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() }
            int id = ((Number) source.get("numeric_field")).intValue();
                .setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY))
                                "type": "geo_point"
                .setSize(size)
            Map<String, Object> source = hit.getSourceAsMap();
        assertHitCount(client().prepareSearch("idx").setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) * 10).get(), 1);
        indexRandom(true, docbuilders);
                "mappings": {
 *
        client().prepareIndex("test").setId("3").setSource("ip", "192.168.0.3").get();
                            .endObject()
        assertHitCount(
        client().prepareIndex("test").setId("XXX1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
            searchResponse = client().prepareSearch("test")
            1
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                .setTerminateAfter(5)
        assertHitCount(client().prepareSearch("idx").setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY)).get(), 1);
        // Test 4: Search with sorting on number field
                .get();
        doTestSimpleTerminateAfterTrackTotalHitsUpTo(0);
            () -> client().prepareSearch("idx").setQuery(QueryBuilders.regexpQuery("num", regexp.toString())).get()
            .get();
 * ownership. Elasticsearch licenses this file to you under
        // id is not indexed, but lets see that we automatically convert to
        createIndex("idx");
    }
    public void testIndexOnlyFloatField() throws IOException {
import org.opensearch.action.search.SearchPhaseExecutionException;
     *   Again, due to the optimization, any count can be returned.
    }
        ensureGreen();
            String id = String.valueOf(i);
        SearchResponse searchResponse;
        searchResponse = client().prepareSearch().setQuery(QueryBuilders.queryStringQuery("_id:XXX1")).get();
    }
            .setQuery(QueryBuilders.rangeQuery("field").gt("2010-01-05T02:00").lt("2010-01-06T02:00"))
            assertTrue("Value should be between 3 and 6", value >= 3 && value <= 6);
            .setQuery(QueryBuilders.matchAllQuery())
        query.flags(RegexpFlag.COMPLEMENT);
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        List<IndexRequestBuilder> docbuilders = new ArrayList<>(max);
            docbuilders.add(client().prepareIndex("test").setId(id).setSource("field", i));
                .indices()
/*
                .setSize(size)
                .prepareUpdateSettings("idx")
        assertFalse(searchResponse.isTerminatedEarly());
                "Result window is too large, from + size must be less than or equal to: ["
        assertWindowFails(client().prepareSearch("idx").setFrom(Integer.MAX_VALUE));
    /**
        indexRandom(true, docbuilders);
import org.opensearch.action.index.IndexRequestBuilder;
                .put(
        assertHitCount(searchResponse, 2L);
            // can produce a total hit count > terminated_after, but this only kicks in
    // Tests scenario where size > track_total_hits_up_to (5)
                    .startObject()
                    + IndexSettings.MAX_RESCORE_WINDOW_SETTING.get(Settings.EMPTY)
            builders.add(
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
            client().prepareSearch("idx").addRescorer(new QueryRescorerBuilder(matchAllQuery()).windowSize(defaultMaxWindow + 1)).get(),
        dotestSimpleTerminateAfterCountWithSize(randomIntBetween(1, max), max);
        );
                            .field("keyword_field", "keyword_" + i)
                    + regexp.length()
    }
    public void testSimpleDateRange() throws Exception {
            NullPointerException.class,
            .setTerminateAfter(5)
        response = client().prepareSearch("test_derive")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                        "derived_source": {
            .setSize(size)
            assertEquals("2022-06-15T10:12:52." + String.valueOf(id + 1).repeat(9) + "Z", source.get("date_nanos_field"));
        assertAcked(
        SearchResponse searchResponse = client().prepareSearch("idx").setQuery(query).get();
            client().admin()
        doTestSimpleTerminateAfterTrackTotalHitsUpTo(randomIntBetween(1, 5));
            assertTrue(source.containsKey("numeric_field"));
            searchResponse = client().prepareSearch("test")
    }
                .setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY))
 * GitHub history for details.
                                "type": "constant_keyword",
                    .endObject()
        createIndex("idx");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
                .indices()
            1
                    "_doc": {
     *   So, we will have to do a range check, not an equality check.
        );
        int defaultMaxWindow = IndexSettings.MAX_RESCORE_WINDOW_SETTING.get(Settings.EMPTY);
            .get();
        createIndex("test_regex");
        assertThat(
            docbuilders.add(client().prepareIndex("test").setId(id).setSource("field", i));
            containsString(
                                "store": true
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
            .setTerminateAfter(10)
import static org.apache.lucene.search.TotalHits.Relation.EQUAL_TO;
        assertEquals(EQUAL_TO, searchResponse.getHits().getTotalHits().relation());
        searchResponse = client().prepareSearch("test")
                            },
            .get();
                .setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) * 10)
        refresh();
                        }
                .setSettings(
    }
 * compatible open source license.
        }
        client().prepareIndex("test").setId("4").setSource("ip", "192.168.1.4").get();
    }
import java.util.Collection;
        SearchResponse response = client().prepareSearch("test_derive")
        for (SearchHit hit : response.getHits()) {
                        )
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
                    }
        assertHitCount(client().prepareSearch("idx").setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) + 1).get(), 1);
            )
            .preparePutMapping("test")
    }
                    )
            String randomPreference = randomUnicodeOfLengthBetween(0, 4);
                    .startObject("properties")
            .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(numDocs))
        StringBuilder regexp = new StringBuilder(defaultMaxRegexLength);
        createIndex("idx");
        int max = randomIntBetween(3, 29);
        assertWindowFails(
    }
                    + "] used in the Regexp Query request has exceeded "
        ensureGreen();
    }
        // Test 2: Search with source filtering
        for (int i = 1; i <= numDocs; i++) {
        SearchResponse response = client().prepareSearch("test_regex").setQuery(query).get();
            )
                .setPreference(randomPreference)
        );
 * the Apache License, Version 2.0 (the "License"); you may
        Set<String> matchedIds = Arrays.stream(response.getHits().getHits()).map(hit -> hit.getId()).collect(Collectors.toSet());
                )
        assertHitCount(searchResponse, 1L);
        );
        String queryJson = "{ \"field\" : { \"value\" : 80315953321748200608 } }";
        );
        assertHitCount(client().prepareSearch("idx").setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) - 10).get(), 1);
                                "format": "strict_date_optional_time_nanos"
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
            containsString(
        refresh();
            .get();
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
            1
                .setTerminateAfter(i)
import org.opensearch.index.query.QueryBuilders;
                    .field("type", "ip")
    public void testTooLargeRescoreOkByDynamicSetting() throws Exception {
            .get();
        assertHitCount(client().prepareSearch("idx").setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY)).get(), 1);
        assertFalse(searchResponse.isTerminatedEarly());
        assertHitCount(client().prepareSearch("idx").setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) + 1).get(), 1);
                        jsonBuilder().startObject()
import org.opensearch.common.xcontent.XContentFactory;
            client().prepareSearch("idx").addRescorer(new QueryRescorerBuilder(matchAllQuery()).windowSize(defaultMaxWindow + 1)).get(),
            .setTerminateAfter(2 * max)
        }
    }
            client().prepareIndex("test").setId("4").setSource("field", "value"),
                    .field("type", "ip")
    }
    public void testTooLongRegexInRegexpQuery() throws Exception {
        int max = randomIntBetween(3, 29);
                            .field("ip_field", "192.168.1." + i)
        SearchResponse searchResponse = client().prepareSearch("test")
                    Settings.builder()
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
    }
                .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(max))
import org.opensearch.action.search.SearchRequestBuilder;
        if (size == 0) {
        );
                    .startObject("ip")
        assertHitCount(search, 1L);
    public void testSimpleTerminateAfterCountSize0() throws Exception {
            if (size == 0) {
            client().prepareSearch("idx")
            .indices()
            // Do not expect an exact match as an optimization introduced by https://issues.apache.org/jira/browse/LUCENE-10620
import org.opensearch.index.IndexSettings;
                    .startObject()
        assertNoFailures(searchResponse);
        client().prepareIndex("test").setId("2").setSource("ip", "192.168.0.2").get();
            .setQuery(QueryBuilders.queryStringQuery("field:[2010-01-03||+2d TO 2010-01-04||+2d/d]"))
        assertHitCount(
            )
                    + "] is too large. It must "
            client().prepareSearch("idx").setQuery(QueryBuilders.regexpQuery("num", "34")).get();
            assertNotNull("Derive source should be present", source);
        prepareCreate("idx").setSettings(Settings.builder().put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), Integer.MAX_VALUE)).get();
        assertHitCount(searchResponse, 0L);
        XContentParser parser = createParser(JsonXContent.jsonXContent, queryJson);
import java.util.ArrayList;
import org.opensearch.index.mapper.MapperService;
        assertHitCount(searchResponse, 2L);
            .setTrackTotalHits(true)
                .get(),
            1
            e.getRootCause().getMessage(),
 * this work for additional information regarding copyright
    public void testTooLargeRescoreOkBySetting() throws Exception {
            client().prepareIndex("test").setId("3").setSource("field", "value"),
    }
        assertHitCount(search, 4L);
     *   or totalHits &gt; track_total_hits_up_to and SearchPhaseController sets totalHits = track_total_hits_up_to when returning results
                    + "be less than ["
        );
                .setTrackTotalHitsUpTo(10)
        assertHitCount(response, 4);
        searchResponse = client().prepareSearch("test")
    }
        searchResponse = client().prepareSearch("test")
            assertEquals(EQUAL_TO, searchResponse.getHits().getTotalHits().relation());
                    .endObject()
            assertEquals("text field " + id, source.get("text_field"));
    public void testLargeFromAndSizeSucceeds() throws Exception {
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "2001:db8::/64"))).get();
                    .endObject()
        assertNoFailures(response);
        assertHitCount(client().prepareSearch("idx").setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY)).get(), 1);
        client().prepareIndex("test").setId("1").setSource("from", "192.168.0.5", "to", "192.168.0.10").setRefreshPolicy(IMMEDIATE).get();
        }
        assertEquals("COMPLEMENT should match 2 documents", 2L, response.getHits().getTotalHits().value());
    @ParametersFactory
        int numDocs = 29;
            .setTrackTotalHitsUpTo(5)
                        "properties": {
     * @throws Exception
        client().prepareIndex("test_regex").setId("2").setSource("text", "adc").get();
                    + "This maximum can be set by changing the ["
        );
                    .endObject()
        ensureGreen("idx");
                            },
        ensureGreen();
    public void doTestSimpleTerminateAfterTrackTotalHitsUpTo(int size) throws Exception {
        assertHitCount(searchResponse, 1L);
    public void testTooLargeFromAndSize() throws Exception {
            assertTrue(searchResponse.isTerminatedEarly());
                                "type": "date_nanos",
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
        int numDocs = 8;
                XContentFactory.jsonBuilder()
        response = client().prepareSearch("test_derive")
    public SimpleSearchIT(Settings settings) {
        assertNoFailures(response);
        // For size = 0, the following queries terminate early, but hits and relation can vary.
                    .endObject()
        assertTrue("Should match documents 2 and 3", matchedIds.containsAll(Arrays.asList("2", "3")));
        for (SearchHit hit : response.getHits()) {
        for (int i = max - 1; i >= 0; i--) {
        for (SearchHit hit : response.getHits()) {
     */
        int lastValue = Integer.MAX_VALUE;
                .get(),
                .get()
        ensureGreen();
        createIndex("test");
        SearchPhaseExecutionException e = expectThrows(SearchPhaseExecutionException.class, () -> search.get());
            .preparePutMapping("test")
        assertNoFailures(response);
        return Arrays.asList(
                        .put(
import org.opensearch.core.rest.RestStatus;
     * If track_total_hits = true:
        assertTrue(searchResponse.isTerminatedEarly());
    public void dotestSimpleTerminateAfterCountWithSize(int size, int max) throws Exception {
     *   Up to terminate_after, relation == EQUAL_TO.
            Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0).put("index.sort.field", "rank")
        ensureGreen();
    public void testSimpleTerminateAfterTrackTotalHitsUpToRandomSize0() throws Exception {
    }
            .setQuery(
        int defaultMaxWindow = IndexSettings.MAX_RESCORE_WINDOW_SETTING.get(Settings.EMPTY);
        searchResponse = client().prepareSearch("test")
                .get()
        for (int i = 1; i <= max; i++) {
import java.util.Arrays;
        client().prepareIndex("test").setId("5").setSource("ip", "2001:db8::ff00:42:8329").get();
        assertHitCount(searchResponse, max);
        assertHitCount(search, 1L);
            containsString(
            .addRescorer(new QueryRescorerBuilder(matchAllQuery()).windowSize(windowSize));
                            .field("text_field", "text field " + i)
            )
    public void testTooLargeRescoreOkByDynamicResultWindowSetting() throws Exception {
import org.opensearch.index.query.RegexpQueryBuilder;
            client().prepareSearch("idx")
            String id = String.valueOf(i);
            int value = ((Number) hit.getSourceAsMap().get("numeric_field")).intValue();
                .setSize(i)
    public void testSimpleIndexSortEarlyTerminate() throws Exception {
            .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(max))
        List<IndexRequestBuilder> docbuilders = new ArrayList<>(numDocs);
                            .field("bool_field", i % 2 == 0)
        refresh();
        assertEquals(1, searchResponse.getHits().getTotalHits().value());
    public void testSimpleTerminateAfterTrackTotalHitsUpToLargeSize() throws Exception {
                            "enabled": true
            assertTrue(boolValue);
            assertEquals(Integer.toString(id), hit.getId());
                                "doc_values": true
        assertHitCount(response, numDocs);
 * Unless required by applicable law or agreed to in writing,
        assertHitCount(searchResponse, 2L);
        assertWindowFails(client().prepareSearch("idx").setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) + 1));
        }
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "::/0"))).get();
        ConstantScoreQueryBuilder query = ConstantScoreQueryBuilder.fromXContent(parser);
                    Settings.builder().put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), defaultMaxWindow * 2)
        for (SearchHit hit : response.getHits()) {
        assertHitCount(search, 1L);
            .setTrackTotalHitsUpTo(5)
                            },
import java.util.stream.Collectors;
        SearchResponse search = client().prepareSearch()
    }
            .setQuery(QueryBuilders.rangeQuery("field").gte("2010-01-05T02:00").lte("2010-01-06T02:00"))
import org.opensearch.core.xcontent.XContentParser;
            assertTrue(source.containsKey("keyword_field"));
            .get();
        );
        ensureGreen("idx");
            )
        createIndex("test");
            int currentValue = ((Number) hit.getSourceAsMap().get("numeric_field")).intValue();
            client().prepareIndex("test").setId("2").setSource("field", "value"),
    // Tests scenario where size <= track_total_hits_up_to (5)
import org.opensearch.common.xcontent.json.JsonXContent;
        }
            client().admin()
            .get();
        }
 *
            )
        ensureGreen();
                .setQuery(QueryBuilders.matchAllQuery())
            regexp.append("]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[\\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\");
     *
        refresh();
        List<IndexRequestBuilder> builders = new ArrayList<>();
        }
                .setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY))
            // randomPreference should not start with '_' (reserved for known preference types (e.g. _shards, _primary)
            assertHitCount(searchResponse, 5, numDocs);
        assertHitCount(search, 0L);
    public void testDerivedSourceSearch() throws Exception {
     *   But if track_total_hits_up_to &ge; terminate_after, relation can be EQ _or_ GTE.
        assertHitCount(
                    .endObject()
    public void testTooLargeFromAndSizeBackwardsCompatibilityRecommendation() throws Exception {
            client().prepareSearch("idx")
        searchResponse = client().prepareSearch("test")
     *   in which case relation = GTE.
        assertHitCount(searchResponse, 1L);
     * @param size
            .get();
            client().prepareSearch("idx")
            {
        String createIndexSource = """
            }
                }
    }
        // Test 1: Basic search with derived source
                                "type": "ip"
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() },
    }
            .get();
            .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(numDocs))
    public void testIpCidr() throws Exception {
        // Test 5: Search with complex boolean query
            SearchPhaseExecutionException.class,
                    + IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY)
            .get();
                    .must(QueryBuilders.termQuery("bool_field", true))
    }
        client().prepareIndex("test_regex").setId("1").setSource("text", "abc").get();
import java.util.Set;
            1
 * You may obtain a copy of the License at
                .get();
            }
            assertTrue(searchResponse.isTerminatedEarly());
        createIndex("test");
                    + windowSize
        doTestSimpleTerminateAfterTrackTotalHitsUpTo(randomIntBetween(6, 29));
            searchResponse = client().prepareSearch("test")
    }
            // id is not indexed, but lets see that we automatically convert to
                    .field("type", "ip")
        int defaultMaxWindow = IndexSettings.MAX_RESCORE_WINDOW_SETTING.get(Settings.EMPTY);
        parser.nextToken();
            .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(numDocs))
                            },
            .setTrackTotalHits(true)
        );
        assertHitCount(
            .get();
        assertEquals(numDocs, searchResponse.getHits().getTotalHits().value());
        createIndex("idx");
            assertEquals("1", source.get("constant_keyword"));
        ).get();
                                "type": "text",
     * If track_total_hits != true, but set to a value AND terminate_after is set:
        assertNoFailures(response);
    }
        searchResponse = client().prepareSearch("test")
        assertWindowFails(client().prepareSearch("idx").setSize(Integer.MAX_VALUE));
package org.opensearch.search.simple;
                assertHitCount(searchResponse, i);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
    public void testSearchNullIndex() {
            client().prepareSearch("idx")
        parser.nextToken();
            1
            client().prepareIndex("test").setId("5").setSource("field", "value"),
        }
                            .field("date_field", "2023-01-01T01:20:30." + String.valueOf(i + 1).repeat(3) + "Z")
import org.opensearch.search.sort.SortOrder;
        assertHitCount(search, 1L);
            int numValue = ((Number) source.get("numeric_field")).intValue();
            assertEquals(EQUAL_TO, searchResponse.getHits().getTotalHits().relation());
 * KIND, either express or implied.  See the License for the
        String queryJson = "{ \"filter\" : { \"terms\" : { \"field\" : [ 10000.0 ] } } }";
            assertNull(searchResponse.getHits().getTotalHits());
                            },
        }
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
        client().prepareIndex("test_regex").setId("3").setSource("text", "acc").get();
            1
        ).get();
            containsString("Expected [ip/prefix] but was [0/0/0/0/0]")
                .get(),
            assertEquals("2023-01-01T01:20:30." + String.valueOf(id + 1).repeat(3) + "Z", source.get("date_field"));
        SearchResponse searchResponse = client().prepareSearch().setQuery(QueryBuilders.termQuery("_id", "XXX1")).get();
                .setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY))
        assertEquals(GREATER_THAN_OR_EQUAL_TO, searchResponse.getHits().getTotalHits().relation());
import org.opensearch.index.query.ConstantScoreQueryBuilder;
            .setTerminateAfter(numDocs * 2)
                    defaultMaxWindow * 2
                .get(),
    }
            () -> client().prepareSearch((String) null).setQuery(QueryBuilders.termQuery("_id", "XXX1")).get()
                .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(numDocs))
        }
                .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(numDocs))
                    + "]. "
import java.util.concurrent.ExecutionException;
        assertEquals(1, searchResponse.getHits().getTotalHits().value());
            client().prepareSearch("idx").addRescorer(new QueryRescorerBuilder(matchAllQuery()).windowSize(defaultMaxWindow + 1)).get(),
        );
 */
public class SimpleSearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                            .field("date_nanos_field", "2022-06-15T10:12:52." + String.valueOf(i + 1).repeat(9) + "Z")
    }
                randomPreference = randomUnicodeOfLengthBetween(0, 4);
        );
        assertTrue(searchResponse.isTerminatedEarly());
        }
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
                .get()
            .setFetchSource(new String[] { "keyword_field", "numeric_field" }, null)
                            }
        );
        assertHitCount(search, 1L);
        for (int i = 0; i < numDocs; i++) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            NullPointerException.class,
        );
        assertRescoreWindowFails(Integer.MAX_VALUE);

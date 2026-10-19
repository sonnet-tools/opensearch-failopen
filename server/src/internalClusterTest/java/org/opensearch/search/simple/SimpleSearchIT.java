        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
            .get();  
import org.opensearch.index.query.QueryBuilders;  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        assertHitCount(
        for (SearchHit hit : response.getHits()) {
            String id = String.valueOf(i);  
        XContentParser parser = createParser(JsonXContent.jsonXContent, queryJson);
        SearchResponse searchResponse = client().prepareSearch("idx").setQuery(query).get();
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "192.168.1.5/32"))).get();  
    }
    public void testRegexQueryWithComplementFlag() {
        assertTrue(searchResponse.isTerminatedEarly());  
import java.util.ArrayList;
        assertHitCount(client().prepareSearch("idx").setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) - 10).get(), 1);  
        try {
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "192.168.0.0/24"))).get();  
        assertHitCount(client().prepareSearch("idx").setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY)).get(), 1);  
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
import org.opensearch.action.search.SearchResponse;  
                .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(max))  
            assertTrue(numValue > 5);
        createIndex("idx");  
        );  
                            "numeric_field": {  
        for (int i = 0; i < numDocs; i++) {  
        ).get();  
                    + "be less than ["
        searchResponse = client().prepareSearch("test")
        client().prepareIndex("test").setId("4").setSource("ip", "192.168.1.4").get();
        assertHitCount(search, 4L);
                .get(),  
import org.opensearch.common.xcontent.json.JsonXContent;
import java.util.Set;  
                    + IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY)
        assertHitCount(searchResponse, max);
        createIndex("idx");  
        );
            assertTrue(searchResponse.isTerminatedEarly());  
            )
        refresh();  
            // when size = 0 which is when TotalHitCountCollector is used.
     * @param size
        refresh();
                                "type": "geo_point"
    }
            .get();  
            Map<String, Object> source = hit.getSourceAsMap();
                    + regexp.length()
    }
        client().prepareIndex("test").setId("2").setSource("ip", "192.168.0.2").get();  
    }  
                    .endObject()
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "192.0.0.0/8"))).get();  
                    .endObject()
            client().admin()
            .setTerminateAfter(numDocs * 2)
        );
            .setTrackTotalHits(true)
                .setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY))
            int numValue = ((Number) source.get("numeric_field")).intValue();  
import org.opensearch.action.index.IndexRequestBuilder;  
        // For size = 0, the following queries terminate early, but hits and relation can vary.
            assertTrue(source.containsKey("keyword_field"));
                "Rescore window ["
        return Arrays.asList(  
        ensureGreen();
            assertEquals(5, searchResponse.getHits().getTotalHits().value());
        TermQueryBuilder query = TermQueryBuilder.fromXContent(parser);
        );
        response = client().prepareSearch("test_derive")  
                    .startObject("from")
        int iters = scaledRandomIntBetween(10, 20);
                    Settings.builder().put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), defaultMaxWindow * 2)
            .setTrackTotalHits(true)
                .get();  
            .get();  
        assertNoFailures(response);
                .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(numDocs))
                            IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) * 2  
    public void testSimpleTerminateAfterTrackTotalHitsUpToRandomSize0() throws Exception {
    }
        SearchResponse search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "192.168.0.1"))).get();  
     *   Again, due to the optimization, any count can be returned.  
                .setSize(size)
        ensureGreen();  
            .setQuery(QueryBuilders.matchAllQuery())  
            .setSource(
                XContentFactory.jsonBuilder()  
 * The OpenSearch Contributors require contributions made to  
        SearchPhaseExecutionException e = expectThrows(SearchPhaseExecutionException.class, () -> search.get());
        assertEquals(GREATER_THAN_OR_EQUAL_TO, searchResponse.getHits().getTotalHits().relation());
        assertEquals(1, searchResponse.getHits().getTotalHits().value());  
        searchResponse = client().prepareSearch("test")
    public void testTooLargeRescoreOkBySetting() throws Exception {
            assertEquals("Source should only contain 2 fields", 2, source.size());
            .setTerminateAfter(2 * max)
                .setSize(size)  
        createIndex("test");
                            .field("bool_field", i % 2 == 0)
                            },  
        searchResponse = client().prepareSearch("test")  
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
            .get();
import java.io.IOException;  
                    .field("type", "ip")
        searchResponse = client().prepareSearch("test")  
            1  
        client().prepareIndex("test_regex").setId("3").setSource("text", "acc").get();  
import org.opensearch.search.SearchHit;
            client().prepareIndex("test").setId("4").setSource("field", "value"),
        for (int i = 0; i < iters; i++) {
        }  
        assertNoFailures(response);  
        );
            assertEquals("2022-06-15T10:12:52." + String.valueOf(id + 1).repeat(9) + "Z", source.get("date_nanos_field"));
            searchResponse = client().prepareSearch("test")  
    }
            client().prepareSearch("idx")
 * ownership. Elasticsearch licenses this file to you under  
        // Test 3: Search with range query  
    }  
    public void testIpCidr() throws Exception {
                            "geopoint_field": {  
            SearchPhaseExecutionException.class,
        for (SearchHit hit : response.getHits()) {
            .get();
                            .field("keyword_field", "keyword_" + i)
        );  
        indexRandom(  
            .get();  
            .setSource(  
import org.opensearch.geometry.utils.Geohash;
        assertNoFailures(searchResponse);
                .setTrackTotalHitsUpTo(10)
        assertTrue("Should match documents 2 and 3", matchedIds.containsAll(Arrays.asList("2", "3")));
            containsString("Expected [ip/prefix] but was [0/0/0/0/0]")  
                    .endObject()  
        }
                .setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) / 2 - 1)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
            .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(numDocs))
        parser.nextToken();  
        // Test 2: Search with source filtering
            int currentValue = ((Number) hit.getSourceAsMap().get("numeric_field")).intValue();
import org.opensearch.index.IndexSettings;  
                        "number_of_replicas": 0,  
            boolean boolValue = (Boolean) source.get("bool_field");
        SearchResponse searchResponse;
     * Special cases when size = 0:
        createIndex("idx");
                            },
     *  
            .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(max))
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        int defaultMaxWindow = IndexSettings.MAX_RESCORE_WINDOW_SETTING.get(Settings.EMPTY);  
        );
        int max = randomIntBetween(3, 29);
        assertNoFailures(response);
        assertHitCount(search, 1L);
        String createIndexSource = """
 * Licensed to Elasticsearch under one or more contributor  
        prepareCreate("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0)).get();
                    .setSource(
        }
            assertEquals(5, searchResponse.getHits().getTotalHits().value());
        assertEquals("Should match exactly 2 documents", 2, matchedIds.size());
     * If track_total_hits != true, but set to a value AND terminate_after is set:
                            .field("wildcard_field", "wildcard" + i)
        assertFailures(  
                            .field("geopoint_field", Geohash.stringEncode(40.0 + i, 75.0 + i))  
            .get();
    }  
     *   in which case relation = GTE.
            String id = String.valueOf(i);
                    .startObject()
            .setQuery(boolQuery().must(rangeQuery("from").lte("192.168.0.7")).must(rangeQuery("to").gte("192.168.0.7")))
            .setQuery(QueryBuilders.rangeQuery("field").gte("2010-01-03||+2d").lte("2010-01-04||+2d/d"))
        prepareCreate("idx").setMapping("field", "type=keyword").get();
            .get();
    public void testTooLargeFromAndSizeOkByDynamicSetting() throws Exception {
                .setTrackTotalHitsUpTo(5)
 *
            searchResponse = client().prepareSearch("test")
    public void testTooLargeFromAndSize() throws Exception {
                        "derived_source": {
                                "type": "constant_keyword",
        assertEquals(GREATER_THAN_OR_EQUAL_TO, searchResponse.getHits().getTotalHits().relation());
            String id = String.valueOf(i);
        assertHitCount(search, 1L);
                .prepareUpdateSettings("idx")
    }
            String randomPreference = randomUnicodeOfLengthBetween(0, 4);  
        client().prepareIndex("test").setId("3").setSource("ip", "192.168.0.3").get();
 * license agreements. See the NOTICE file distributed with
                .get();  
/*  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() },
                    .startObject()
    public void testInsaneFromAndSize() throws Exception {
        ensureGreen();
        int lastValue = Integer.MAX_VALUE;  
        SearchResponse response = client().prepareSearch("test_derive")
                    .startObject(MapperService.SINGLE_MAPPING_NAME)
        int defaultMaxWindow = IndexSettings.MAX_RESCORE_WINDOW_SETTING.get(Settings.EMPTY);  
                .get(),
            client().prepareIndex("test").setId("2").setSource("field", "value"),  
    public void testDerivedSourceSearch() throws Exception {
/*  
                .get(),
        createIndex("test");
    }
            // Since terminate_after < track_total_hits, we need to do a range check.
                .setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) * 10)
 * Modifications Copyright OpenSearch Contributors. See
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
        ensureGreen();  
     *   or totalHits &gt; track_total_hits_up_to and SearchPhaseController sets totalHits = track_total_hits_up_to when returning results
    }
        prepareCreate("idx").setMapping("field", "type=float,doc_values=false").get();
            client().prepareIndex("test").setId("5").setSource("field", "value"),  
        refresh();  
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
        assertHitCount(client().prepareSearch("idx").setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) * 10).get(), 1);
            )
            fail("SearchPhaseExecutionException should have been thrown");
        assertHitCount(search, 1L);
        expectThrows(
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.containsString;
            e.getRootCause().getMessage(),
                            },
import java.util.stream.Collectors;
        int numDocs = 8;
            1
        }  
                            "enabled": true
    // Tests scenario where size > track_total_hits_up_to (5)
            assertNotNull("Derive source should be present", source);
        for (int i = 1; i <= max; i++) {  
            assertEquals(id % 2 == 0, source.get("bool_field"));
            .addRescorer(new QueryRescorerBuilder(matchAllQuery()).windowSize(windowSize));  
            }
        client().prepareIndex("test").setId("1").setSource("field", "2010-01-05T02:00").get();  
                            .field("ip_field", "192.168.1." + i)  
        int defaultMaxWindow = IndexSettings.MAX_RESCORE_WINDOW_SETTING.get(Settings.EMPTY);
        assertHitCount(client().prepareSearch("idx").setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) * 10).get(), 1);
                    .field("type", "ip")  
public class SimpleSearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        for (SearchHit hit : response.getHits()) {
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
    }
            while (randomPreference.startsWith("_")) {
        assertHitCount(search, 5L);
            client().prepareSearch("idx")
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "2001:db8::/64"))).get();  
        assertFalse(searchResponse.isTerminatedEarly());  
        parser.nextToken();
        assertHitCount(searchResponse, 1L);
        for (int i = 1; i <= numDocs; i++) {
                    IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), // Note that this is the RESULT window.
                    .startObject(MapperService.SINGLE_MAPPING_NAME)  
                .setTerminateAfter(i)
            .addSort("numeric_field", SortOrder.DESC)  
    private void assertRescoreWindowFails(int windowSize) {
            assertEquals("keyword_" + id, source.get("keyword_field"));  
    }  
                            "keyword_field": {  
        }
 * this file be licensed under the Apache-2.0 license or a
            client().prepareIndex("test").setId("3").setSource("field", "value"),
                                "type": "date_nanos",
        SearchRequestBuilder search = client().prepareSearch("idx")
            () -> client().prepareSearch("idx").setQuery(QueryBuilders.regexpQuery("num", regexp.toString())).get()
                            IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(),
 * GitHub history for details.
        createIndex("test");
        } else {
            assertTrue("Results should be sorted in descending order", currentValue <= lastValue);  
        assertThat(  
 *
            client().admin()
        List<IndexRequestBuilder> docbuilders = new ArrayList<>(numDocs);
import java.util.Map;
        assertAcked(
        assertThat(  
            .setQuery(QueryBuilders.queryStringQuery("field:[2010-01-03||+2d TO 2010-01-04||+2d/d]"))
        // Test 4: Search with sorting on number field  
            assertEquals("2023-01-01T01:20:30." + String.valueOf(id + 1).repeat(3) + "Z", source.get("date_field"));
        // Test 5: Search with complex boolean query
    }
                    + "] is too large. It must "
            // can produce a total hit count > terminated_after, but this only kicks in
                .setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) / 2)
            searchResponse = client().prepareSearch("test")
                            },
                )
                .setSettings(Settings.builder().put(IndexSettings.MAX_RESCORE_WINDOW_SETTING.getKey(), defaultMaxWindow * 2))
                            },  
        assertWindowFails(client().prepareSearch("idx").setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY)));
                            .field("numeric_field", i)
        assertEquals(numDocs, searchResponse.getHits().getTotalHits().value());
        Set<String> matchedIds = Arrays.stream(response.getHits().getHits()).map(hit -> hit.getId()).collect(Collectors.toSet());  
        ensureGreen("idx");  
    }  
 * this work for additional information regarding copyright
            assertTrue(boolValue);  
        indexRandom(true, builders);
            client().prepareSearch("idx")
                )  
        }
                    + "the allowed maximum of ["
                        "properties": {
            1
        assertWindowFails(
                            }  
        if (size == 0) {
        refresh();
            .setSize(size)  
        );
            regexp.append("]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[\\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\");
            )
        );
            containsString(  
        prepareCreate("idx").setSettings(Settings.builder().put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), Integer.MAX_VALUE)).get();
            .setSize(size)  
        createIndex("idx");  
        refresh("idx");  
import java.util.List;
                            "date_nanos_field": {  
            assertTrue(searchResponse.isTerminatedEarly());
        // Index multiple documents  
                .setQuery(QueryBuilders.matchAllQuery())
        SearchResponse searchResponse = client().prepareSearch().setQuery(QueryBuilders.termQuery("_id", "XXX1")).get();  
        assertHitCount(  
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "0.0.0.0/0"))).get();  
        );
            .setQuery(  
        assertEquals(5, searchResponse.getHits().getTotalHits().value());  
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        assertHitCount(search, 0L);
        assertAcked(
            .get();
            .get();
        assertEquals(5, searchResponse.getHits().getTotalHits().value());
            lastValue = currentValue;
                    .endObject()  
        assertThat(e.toString(), containsString("See the scroll api for a more efficient way to request large data sets"));
    private void assertWindowFails(SearchRequestBuilder search) {
                .get(),  
    public void testSearchRandomPreference() throws InterruptedException, ExecutionException {
        int max = randomIntBetween(3, 29);
                .indices()  
        assertHitCount(
                                "value": "1"
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        assertHitCount(search, 1L);
                            "bool_field": {
    public void testSimpleTerminateAfterCountSize0() throws Exception {  
        createIndex("idx");  
                                "format": "strict_date_optional_time_nanos"
            assertEquals("text field " + id, source.get("text_field"));  
        client().admin()
                    // Note that this is the RESULT window  
        indexRandom(true, docbuilders);
                                "type": "text",
    public void testTooLargeRescoreOkByDynamicResultWindowSetting() throws Exception {
    }
        assertAcked(prepareCreate("idx").setMapping("num", "type=integer"));
/*
            Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0).put("index.sort.field", "rank")
    }
        indexRandom(true, docbuilders);
 *  
        );  
            assertTrue(source.containsKey("numeric_field"));  
            if (size == 0) {  
    }  
        assertWindowFails(client().prepareSearch("idx").setFrom(Integer.MAX_VALUE));  
            client().prepareSearch("idx")  
        SearchPhaseExecutionException e = expectThrows(  
                XContentFactory.jsonBuilder()
            1  
                .get();  
            assertEquals(EQUAL_TO, searchResponse.getHits().getTotalHits().relation());
        createIndex("idx");  
     *   So, we will have to do a range check, not an equality check.  
                    + windowSize  
        }
            .setQuery(QueryBuilders.rangeQuery("field").gte("2010-01-05T02:00").lte("2010-01-06T02:00"))
        prepareCreate("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0)).get();
            assertEquals(5, searchResponse.getHits().getTotalHits().value());
 * compatible open source license.
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        ensureGreen();  
                    .endObject()
import org.opensearch.action.search.SearchRequestBuilder;
            SearchResponse searchResponse = client().prepareSearch()  
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
            } else {
        for (int i = 1; i < max; i++) {
        prepareCreate("idx").setSettings(  
            builders.add(
                assertHitCount(searchResponse, i, max);
            .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(numDocs))
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));  
            .get();  
                    Settings.builder()  
                                "type": "keyword"
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() }
                "settings": {  
        assertHitCount(client().prepareSearch("idx").setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) + 1).get(), 1);
                assertThat(searchResponse.getHits().getAt(j).field("rank").getValue(), equalTo((long) j));  
                .setSize(i)
            .setSource("{\"field\" : 80315953321748200608 }", MediaTypeRegistry.JSON)
        ensureGreen("idx");  
                "The length of regex ["
                .setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY))
                    + IndexSettings.MAX_RESCORE_WINDOW_SETTING.get(Settings.EMPTY)  
                            "wildcard_field": {
        assertHitCount(search, 1L);
                            "text_field": {
        assertEquals(1, searchResponse.getHits().getTotalHits().value());
                            },  
            1
                .put(  
import org.opensearch.index.query.TermQueryBuilder;  
        assertHitCount(
        );  
        doTestSimpleTerminateAfterTrackTotalHitsUpTo(0);
    /**
     *   Up to terminate_after, relation == EQUAL_TO.
                                "type": "long"
        createIndex("test");
        assertHitCount(client().prepareSearch("idx").setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY)).get(), 1);
                    .must(QueryBuilders.rangeQuery("numeric_field").gt(5))
                            },
 * You may obtain a copy of the License at  
                        )
        ensureGreen("idx");  
    public void dotestSimpleTerminateAfterCountWithSize(int size, int max) throws Exception {
                            "constant_keyword": {  
        XContentParser parser = createParser(JsonXContent.jsonXContent, queryJson);  
                .setPreference(randomPreference)
    public void testTooLargeRescoreOkByDynamicSetting() throws Exception {
        ensureGreen();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                                "type": "date"
import org.opensearch.core.rest.RestStatus;
            client().prepareIndex("test").setId("1").setSource("field", "value"),
    public void doTestSimpleTerminateAfterTrackTotalHitsUpTo(int size) throws Exception {
            client().prepareSearch("idx")  
            .get();
                    .endObject()
            .get();  
                .setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY))
                .put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) * 2)
            // id is not indexed, but lets see that we automatically convert to
 * SPDX-License-Identifier: Apache-2.0
            client().prepareSearch("idx").addRescorer(new QueryRescorerBuilder(matchAllQuery()).windowSize(defaultMaxWindow + 1)).get(),
            for (int j = 0; j < i; j++) {
        SearchResponse searchResponse;
        assertHitCount(client().prepareSearch("idx").setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) + 1).get(), 1);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(numDocs))
        );
        }
    public void testLargeFromAndSizeSucceeds() throws Exception {
        prepareCreate("test").setSettings(
            )
        assertRescoreWindowFails(Integer.MAX_VALUE);
            .setTerminateAfter(5)
        }
        assertHitCount(searchResponse, 2L);
                .prepareUpdateSettings("idx")
        query.flags(RegexpFlag.COMPLEMENT);  
        createIndex("test");  
 */  
                .setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) * 10)  
            .indices()  
import org.opensearch.index.query.RegexpFlag;
        // Test 1: Basic search with derived source
            docbuilders.add(client().prepareIndex("test").setId(id).setSource("field", i));  
            )
            .setTrackTotalHitsUpTo(5)
        int defaultMaxWindow = IndexSettings.MAX_RESCORE_WINDOW_SETTING.get(Settings.EMPTY);
            client().prepareIndex("test").setId("6").setSource("field", "value")
    public void testSimpleIp() throws Exception {  
        assertHitCount(searchResponse, 2L);
    public void testSearchNullIndex() {  
        searchResponse = client().prepareSearch("test")  
            assertEquals(EQUAL_TO, searchResponse.getHits().getTotalHits().relation());  
    public void testSimpleTerminateAfterTrackTotalHitsUpToLargeSize() throws Exception {
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
            assertEquals(Math.min(i, size), searchResponse.getHits().getHits().length);  
        client().admin()  
        searchResponse = client().prepareSearch("test")
import org.opensearch.index.query.ConstantScoreQueryBuilder;
    }  
                    + "]. "  
            .setQuery(QueryBuilders.matchAllQuery())
                    .startObject("ip")
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
            assertNull(searchResponse.getHits().getTotalHits());
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "2001:db8::ff00:42:8329/128"))).get();  
        assertHitCount(search, 4L);
    public void testSimpleId() {
        int numDocs = 29;
            assertEquals("1", source.get("constant_keyword"));
            client().admin()
            .get();
            containsString(
        assertHitCount(response, numDocs);
        searchResponse = client().prepareSearch("test")
            assertHitCount(searchResponse, 6L);
    }
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        searchResponse = client().prepareSearch().setQuery(QueryBuilders.queryStringQuery("_id:XXX1")).get();  
            Map<String, Object> source = hit.getSourceAsMap();  
        assertHitCount(search, 1L);
        }
            .get();  
        response = client().prepareSearch("test_derive")
            .setFetchSource(new String[] { "keyword_field", "numeric_field" }, null)
        } catch (SearchPhaseExecutionException ex) {
                    + "] index level setting."  
                .get()  
package org.opensearch.search.simple;
        createIndex("test_regex");  
        assertHitCount(searchResponse, 1L);
        assertEquals(EQUAL_TO, searchResponse.getHits().getTotalHits().relation());
                .setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY))  
        assertRescoreWindowFails(IndexSettings.MAX_RESCORE_WINDOW_SETTING.get(Settings.EMPTY) + 1);
        List<IndexRequestBuilder> docbuilders = new ArrayList<>(max);
        int max = randomIntBetween(3, 29);  
        super(settings);
            NullPointerException.class,
import org.opensearch.search.rescore.QueryRescorerBuilder;
        assertHitCount(
        assertTrue(searchResponse.isTerminatedEarly());  
    }
    }
        );
        }
            Settings.builder()
    @ParametersFactory
        // Create index with derived source setting enabled  
                            .endObject()
            }
import java.util.Arrays;
            );  
            client().prepareSearch("idx").addRescorer(new QueryRescorerBuilder(matchAllQuery()).windowSize(defaultMaxWindow + 1)).get(),  
}
        assertThat(
        dotestSimpleTerminateAfterCountWithSize(randomIntBetween(1, max), max);
        SearchResponse searchResponse;  
            {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
            .setQuery(QueryBuilders.matchAllQuery())
    public static Collection<Object[]> parameters() {
        ensureGreen();
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "192.168.0.1/32"))).get();  
                        }
                            .field("constant_keyword", "1")  
    // Tests scenario where size <= track_total_hits_up_to (5)
 */  
        response = client().prepareSearch("test_derive")
            .addSort("numeric_field", SortOrder.ASC)
        RegexpQueryBuilder query = new RegexpQueryBuilder("text.keyword", "a~bc");
                client().prepareIndex("test_derive")
            .get();
    public void testSimpleIndexSortEarlyTerminate() throws Exception {  
        ConstantScoreQueryBuilder query = ConstantScoreQueryBuilder.fromXContent(parser);
            )
            NullPointerException.class,
        client().prepareIndex("test").setId("1").setSource("from", "192.168.0.5", "to", "192.168.0.10").setRefreshPolicy(IMMEDIATE).get();
                    .setId(Integer.toString(i))  
        refresh();
    public SimpleSearchIT(Settings settings) {  
                    .endObject()
        assertNoFailures(searchResponse);
        assertHitCount(search, 3L);
        String queryJson = "{ \"filter\" : { \"terms\" : { \"field\" : [ 10000.0 ] } } }";
import org.opensearch.search.sort.SortOrder;  
        searchResponse = client().prepareSearch("test")
                "mappings": {  
                "Result window is too large, from + size must be less than or equal to: ["  
            .setSize(size)  
        }  
        assertWindowFails(client().prepareSearch("idx").setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY) + 1));  
                .indices()  
            docbuilders.add(client().prepareIndex("test").setId(id).setSource("rank", i));
        }
                            "date_field": {  
        search = client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "::/0"))).get();  
            assertEquals(Integer.toString(id), hit.getId());  
            client().prepareSearch("idx").addRescorer(new QueryRescorerBuilder(matchAllQuery()).windowSize(defaultMaxWindow + 1)).get(),
        createIndex("idx");
            assertEquals("wildcard" + id, source.get("wildcard_field"));
            client().prepareSearch("idx").addRescorer(new QueryRescorerBuilder(matchAllQuery()).windowSize(defaultMaxWindow + 1)).get(),
            .setSize(size)  
                .setSettings(
                .setTerminateAfter(5)  
            int value = ((Number) hit.getSourceAsMap().get("numeric_field")).intValue();
        assertHitCount(
    }
                .get();
     *   Weight#count optimization can cause totalHits in the response to be up to the total doc count regardless of terminate_after.
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
            int id = ((Number) source.get("numeric_field")).intValue();
        assertAcked(
                QueryBuilders.boolQuery()
                .setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY))  
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));  
                },
            e.toString(),
        SearchResponse response = client().prepareSearch("test_regex").setQuery(query).get();
            client().prepareSearch("idx").setQuery(QueryBuilders.regexpQuery("num", "34")).get();  
        assertHitCount(response, 4);  
        ).get();
    public void testTooLargeRescoreOkByResultWindowSetting() throws Exception {
            searchResponse = client().prepareSearch("test")
            .preparePutMapping("test")
        assertHitCount(searchResponse, 2L);
    }
        client().prepareIndex("test").setId("XXX1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
                    )
                        jsonBuilder().startObject()
    public void testSimpleTerminateAfterTrackTotalHitsUpToSmallSize() throws Exception {  
        indexRandom(true, docbuilders);  
            Settings.builder()
                            },
        assertNoFailures(response);  
            () -> client().prepareSearch((String[]) null).setQuery(QueryBuilders.termQuery("_id", "XXX1")).get()
        SearchPhaseExecutionException e = expectThrows(SearchPhaseExecutionException.class, () -> search.get());
        refresh();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    .startObject("properties")  
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
        client().prepareIndex("test_regex").setId("1").setSource("text", "abc").get();
            .setTrackTotalHitsUpTo(5)
    public void testIndexOnlyFloatField() throws IOException {
                    .startObject("to")
import org.opensearch.core.xcontent.XContentParser;
 * software distributed under the License is distributed on an
    }
    public void testTooLargeRescoreWindow() throws Exception {  
                }  
    public void testTooLongRegexInRegexpQuery() throws Exception {  
        SearchResponse searchResponse = client().prepareSearch("idx").setQuery(query).get();  
            }""";
            containsString(
            1
     *   This ambiguity is due to the fact that totalHits == track_total_hits_up_to  
import org.opensearch.index.query.RegexpQueryBuilder;
                            .field("date_field", "2023-01-01T01:20:30." + String.valueOf(i + 1).repeat(3) + "Z")  
                            "ip_field": {
            e.toString(),
            docbuilders.add(client().prepareIndex("test").setId(id).setSource("field", i));
        ensureGreen();  
                        .put(
import static org.apache.lucene.search.TotalHits.Relation.EQUAL_TO;
        );  
        assertNoFailures(response);
            .setId("1")  
                .setFrom(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY))
 * the Apache License, Version 2.0 (the "License"); you may
        prepareCreate("idx").setSettings(Settings.builder().put(IndexSettings.MAX_RESCORE_WINDOW_SETTING.getKey(), defaultMaxWindow * 2))
                    "_doc": {
    public void testTooLargeFromAndSizeOkBySetting() throws Exception {
        searchResponse = client().prepareSearch("test")  
    }
        assertNoFailures(searchResponse);
     *   But if track_total_hits_up_to &ge; terminate_after, relation can be EQ _or_ GTE.
                .get()  
                    .endObject()  
            assertHitCount(searchResponse, 5, numDocs);  
        expectThrows(  
        );
                    .startObject("properties")
        dotestSimpleTerminateAfterCountWithSize(0, max);
            .get();  
                    + IndexSettings.MAX_REGEX_LENGTH_SETTING.getKey()
                .prepareUpdateSettings("idx")
            .setQuery(QueryBuilders.rangeQuery("field").gt("2010-01-05T02:00").lt("2010-01-06T02:00"))
    }  
            e.toString(),  
                    + defaultMaxRegexLength
                    defaultMaxWindow * 2
        assertEquals("COMPLEMENT should match 2 documents", 2L, response.getHits().getTotalHits().value());
import org.opensearch.action.search.SearchPhaseExecutionException;
            .get();  
    }  
        );
                    + "This maximum can be set by changing the ["
        assertFalse(searchResponse.isTerminatedEarly());  
                    .field("type", "ip")  
import java.util.concurrent.ExecutionException;
                .indices()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
                assertHitCount(searchResponse, i);  
        for (int i = 1; i < max; i++) {  
                        "number_of_shards": 2,
        assertHitCount(
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertAcked(prepareCreate("test_derive").setSource(createIndexSource, MediaTypeRegistry.JSON));  
            .indices()
        SearchResponse searchResponse = client().prepareSearch("test")
                .get();
            .setQuery(QueryBuilders.rangeQuery("field").gte("2010-01-05T02:00").lt("2010-01-06T02:00"))
import org.opensearch.index.mapper.MapperService;
            // Do not expect an exact match as an optimization introduced by https://issues.apache.org/jira/browse/LUCENE-10620  
                .get()  
        assertHitCount(searchResponse, 0L);
    public void testTooLargeFromAndSizeBackwardsCompatibilityRecommendation() throws Exception {  
    public void testSimpleTerminateAfterCountRandomSize() throws Exception {
            )
        prepareCreate("idx").setSettings(
                        }  
                .addSort("rank", SortOrder.ASC)
            client().prepareSearch().setQuery(boolQuery().must(QueryBuilders.termQuery("ip", "0/0/0/0/0"))),
     */  
        while (regexp.length() <= defaultMaxRegexLength) {  
        }  
        client().prepareIndex("test_regex").setId("2").setSource("text", "adc").get();
import static org.opensearch.index.query.QueryBuilders.boolQuery;
                )
            1
        response = client().prepareSearch("test_derive").setQuery(QueryBuilders.rangeQuery("numeric_field").from(3).to(6)).get();
        ).setMapping("rank", "type=integer").get();  
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
                                "store": true  
            assertEquals("192.168.1." + id, source.get("ip_field"));
import static org.hamcrest.Matchers.equalTo;  
        }
                            .field("text_field", "text field " + i)
        );
        doTestSimpleTerminateAfterTrackTotalHitsUpTo(randomIntBetween(1, 5));
                    "index": {
            Map<String, Object> source = hit.getSourceAsMap();  
                                "type": "wildcard",  
        ensureGreen();
     *  
            .preparePutMapping("test")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
                                "doc_values": true
import org.opensearch.common.xcontent.XContentFactory;  
        doTestSimpleTerminateAfterTrackTotalHitsUpTo(randomIntBetween(6, 29));  
                                "type": "boolean"
            RestStatus.BAD_REQUEST,
    public void testSimpleDateRange() throws Exception {
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)
        for (SearchHit hit : response.getHits()) {
        client().prepareIndex("idx")
    }  
            .get();  
import java.util.Collection;  
    }
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
        for (SearchHit hit : response.getHits()) {
            .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(numDocs))
            assertTrue("Value should be between 3 and 6", value >= 3 && value <= 6);  
                            },
    }  
        client().prepareIndex("test").setId("1").setSource("ip", "192.168.0.1").get();
            .setTerminateAfter(10)
        assertHitCount(searchResponse, 1L);
    }
        assertWindowFails(client().prepareSearch("idx").setSize(Integer.MAX_VALUE));
                    + "] used in the Regexp Query request has exceeded "  
        createIndex("idx");
     *
    }  
                    .must(QueryBuilders.termQuery("bool_field", true))  
        client().prepareIndex("test").setId("5").setSource("ip", "2001:db8::ff00:42:8329").get();  
        if (size > 0) {
            // randomPreference should not start with '_' (reserved for known preference types (e.g. _shards, _primary)
        // id is not indexed, but lets see that we automatically convert to
            .setQuery(QueryBuilders.rangeQuery("field").gte(1).lte(numDocs))
                            .field("date_nanos_field", "2022-06-15T10:12:52." + String.valueOf(i + 1).repeat(9) + "Z")
        indexRandom(true, client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
        List<IndexRequestBuilder> docbuilders = new ArrayList<>(max);  
                    }
        assertThat(
import static org.apache.lucene.search.TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO;
        );
        }
        assertHitCount(  
    }
                .setSettings(
            () -> client().prepareSearch((String) null).setQuery(QueryBuilders.termQuery("_id", "XXX1")).get()  
        int defaultMaxRegexLength = IndexSettings.MAX_REGEX_LENGTH_SETTING.get(Settings.EMPTY);
    }
            1  
 * KIND, either express or implied.  See the License for the
    public void testQueryNumericFieldWithRegex() throws Exception {
        List<IndexRequestBuilder> builders = new ArrayList<>();
        );
                "This limit can be set by changing the [" + IndexSettings.MAX_RESCORE_WINDOW_SETTING.getKey() + "] index level setting."  
                                "type": "ip"
        String queryJson = "{ \"field\" : { \"value\" : 80315953321748200608 } }";
                .addDocValueField("rank")
        SearchResponse search = client().prepareSearch()
                .setTrackTotalHits(true)  
                .setTrackTotalHits(false)  
 * under the License.  
                .setTerminateAfter(5)
            containsString(
        assertHitCount(client().prepareSearch("idx").setSize(IndexSettings.MAX_RESULT_WINDOW_SETTING.get(Settings.EMPTY)).get(), 1);
            assertThat(ex.getRootCause().getMessage(), containsString("Can only use regexp queries on keyword and text fields"));  
        assertEquals(EQUAL_TO, searchResponse.getHits().getTotalHits().relation());
                .setSize(size)
            }
                    }
        assertNoFailures(searchResponse);
        client().prepareIndex("test").setId("2").setSource("field", "2010-01-06T02:00").get();
        StringBuilder regexp = new StringBuilder(defaultMaxRegexLength);
                randomPreference = randomUnicodeOfLengthBetween(0, 4);  
        search = client().prepareSearch().setQuery(queryStringQuery("ip: 192.168.0.1")).get();  
        );  
     * @throws Exception
        );
            assertTrue(searchResponse.isTerminatedEarly());
 * Unless required by applicable law or agreed to in writing,
     * If track_total_hits = true:
        for (int i = max - 1; i >= 0; i--) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                    .endObject()
            true,
    public void testTermQueryBigInt() throws Exception {
 */
        client().prepareIndex("idx").setSource("{\"field\": 10000.0}", MediaTypeRegistry.JSON).get();

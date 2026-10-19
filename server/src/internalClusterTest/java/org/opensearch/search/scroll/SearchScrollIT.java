            // a the last is zero
        } finally {
    public void testClearNonExistentScrollId() throws Exception {  
            assertThat(
        assertThat(searchResponse1.getHits().getHits().length, equalTo(35));  
            .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
        exc = expectThrows(
        assertThat(illegalArgumentException.getMessage(), containsString("Keep alive for request (3h) is too large"));  
            .addSort("field", SortOrder.ASC)
        assertThat(map.get("succeeded"), is(succeed));  
            client().admin().indices().prepareRefresh().get();  
        createIndex("idx");
        }  
        assertThat(clearResponse.status(), equalTo(RestStatus.OK));
        );
        for (SearchHit hit : searchResponse2.getHits()) {  
            assertThat(searchResponse.getHits().getHits().length, equalTo(35));  
                .prepareUpdateSettings()
        assertAcked(
                "DnF1ZXJ5VGhlbkZldGNoAwAAAAAAAAABFnRtLWMyRzBqUUQyNk1uM0xDTjJ4S0EAAAAAAAAAARYzNkhxbWFTYVFVNmgxTGQyYUZVYV9nAA"
        client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 3)).get();
        assertThat(searchResponse.getScrollId(), is(notNullValue()));
                    assertThat(  
            client().prepareIndex("test")
        }  
        assertAcked(  
        for (int i = 0; i < 2; i++) {  
        );
            .get();
            assertThat("Multiple batches should have been used", batchCount, greaterThan(1));
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
            equalTo(0L)
import org.opensearch.test.InternalTestCluster;
                .setPersistentSettings(Settings.builder().putNull("*"))
    }
 */  
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter1++));
     * across multiple batches. Verifies document order, content integrity, no duplicates,
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        }
            client().admin()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.action.search.ShardSearchFailure;
        );
                .prepareUpdateSettings()  
        assertHitCount(response, 1);  
            .setScroll(TimeValue.timeValueMinutes(2))  
            client().prepareSearchScroll(searchResponse2.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)),
import org.opensearch.index.query.MatchAllQueryBuilder;
    public void testScrollInvalidDefaultKeepAlive() throws IOException {  
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
            equalTo(0L)
            assertAcked(client().admin().indices().prepareClose("test"));
                .put("index.routing.allocation.include._name", dataNode)
            assertThat(searchResponse.getHits().getHits().length, equalTo(35));
        assertSearchHits(response, "1");
        for (int i = 0; i < numDocs; i++) {  
            .setSize(35)
            if (i > 90) {  
                        "Document out of order at position " + retrievedOrder.size(),
        SearchResponse searchResponse = client().prepareSearch()
        ClearScrollResponse clearResponse = client().prepareClearScroll()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        indexRandomForConcurrentSearch("test");  
            int batchCount = 0;  
            // Verify all documents retrieved
            client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get().getHits().getTotalHits().value(),
            .get();
            .setSize(35)  
        assertRequestBuilderThrows(  
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
                        ((Number) hit.getSortValues()[0]).intValue(),
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", i).get();
        );
            .get();
        );
        assertThat(response.isSucceeded(), is(true));
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        }
        assertThat(searchResponse2.getHits().getHits().length, equalTo(35));  
        indexRandomForConcurrentSearch("demo", "prod");
        assertThat(searchResponse2.getHits().getHits().length, equalTo(35));
            ensureGreen("test");  
                .get();
                assertNoFailures(resp);
        client().prepareSearchScroll(respFromProdIndex.getScrollId()).get();  
        createIndex(  
            // Verify complete sequence
            .prepareUpdateSettings("index")  
        assertRequestBuilderThrows(internalCluster().client().prepareSearchScroll(searchResponse.getScrollId()), RestStatus.NOT_FOUND);
                .setQuery(new RangeQueryBuilder("created_date").gte("2020-01-02").lte("2020-01-03"))
            String routing = "0";
                .setTransientSettings(Settings.builder().putNull("*"))  
            .setScroll(TimeValue.timeValueMinutes(5))  
            equalTo(500L)  
        assertThat(searchResponse2.getHits().getTotalHits().value(), equalTo(100L));
            () -> client().admin()
                .get();
        for (SearchType searchType : SearchType.values()) {
            assertThat(searchResponse.getHits().getHits().length, equalTo(30));
        for (int i = 0; i < 100; i++) {
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
                .setMaxConcurrentShardRequests(randomIntBetween(1, 3)) // sometimes fan out shard requests one by one
        assertNoFailures(respFromProdIndex);
/*  
                .indices()
        assertRequestBuilderThrows(
import org.opensearch.action.search.SearchRequestBuilder;
        assertThat(clearResponse.isSucceeded(), is(true));
            exc,  
        assertThat(searchResponse1.getHits().getHits().length, equalTo(35));
    }  
            assertThat(
        assertThat(response.status(), equalTo(RestStatus.NOT_FOUND));  
            .setQuery(matchAllQuery())  
            .setScroll(TimeValue.timeValueMinutes(2))  
            .setQuery(matchAllQuery())  
import org.opensearch.search.SearchHit;
    public void testDeepScrollingDoesNotBlowUp() throws Exception {
        }  
                    Map<String, Object> source = hit.getSourceAsMap();  
        client().admin()
 * the Apache License, Version 2.0 (the "License"); you may
            .get();  
            .setSize(3)
                .get()
        exc = expectThrows(
        assertThat(
import org.junit.After;
        );
        SearchResponse respFromDemoIndex = client().prepareSearch("demo")  
 * SPDX-License-Identifier: Apache-2.0
            .setQuery(matchAllQuery())
        assertThat(searchResponse2.getHits().getTotalHits().value(), equalTo(100L));  
        for (SearchHit hit : searchResponse1.getHits()) {
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) numDocs));
            }  
        assertThat(searchResponse1.getHits().getTotalHits().value(), equalTo(100L));
            .get();
                .cluster()  
            for (SearchHit hit : searchResponse.getHits()) {
            assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        assertNotNull(searchResponse.getScrollId());
 * under the License.  
                .cluster()  
 * that rejects this valid sequential cross-thread usage.
            client().admin()  
        return Arrays.asList(
                .setSearchType(searchType)
                .setScroll("1m");
     * regardless whether that query can be written to match_no_docs on some target shards or not.
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter2++));
                    // Verify no duplicates
            index("prod", "_doc", "prod-" + i, Collections.emptyMap());
            .setSize(randomIntBetween(1, 10))
import org.opensearch.test.hamcrest.OpenSearchAssertions;  
        assertHitCount(response, 1);  
        indexRandomForConcurrentSearch("test");
            while (resp.getHits().getHits().length > 0) {
            clearScroll(searchResponse.getScrollId());  
            .setScroll(TimeValue.timeValueMinutes(5))  
        SearchResponse searchResponse1 = client().prepareSearch()  
            .indices()  
        SearchPhaseExecutionException error = expectThrows(
        indexRandomForConcurrentSearch("test");  
            if (resp != null && resp.getScrollId() != null) {
                .get();
                .get()
        assertThat(
        SearchResponse searchResponse = client().prepareSearch("test")  
                .prepareUpdateSettings()
            long counter = 0;
            client().prepareIndex("test")
import org.opensearch.search.sort.FieldSortBuilder;
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter2++));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            index("demo", "_doc", "demo-" + i, Collections.emptyMap());
            "prod",
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            } finally {  
            client().admin()
                    client().prepareIndex("test").setId(searchHit.getId()).setSource(map).get();
                .setSize(Integer.MAX_VALUE)  
        IllegalArgumentException e = expectThrows(  
        try {
        Map<String, Object> map = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
                .setSource(
        response = client().prepareSearchScroll(response.getScrollId()).get();  
        );  
                .prepareUpdateSettings()  
            .addSort("field", SortOrder.ASC)
            clearScroll(searchResponse.getScrollId());
                equalTo(500L)
        List<Integer> retrievedOrder = new ArrayList<>();
                .get()
        ensureGreen("demo", "prod");
        assertThat(searchResponse1.getHits().getTotalHits().value(), equalTo(100L));
        );
        searchResponse1 = client().prepareSearchScroll(searchResponse1.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
            );
        for (SearchHit hit : searchResponse2.getHits()) {
                client().prepareClearScroll().addScrollId(resp.getScrollId()).get();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            IllegalArgumentException.class,
            Exception.class,
        for (int i = 0; i < 100; i++) {  
                .setMapping("created_date", "type=date,format=yyyy-MM-dd")
            for (SearchHit hit : searchResponse.getHits()) {  
        SearchResponse searchResponse = client().prepareSearch()
        if (randomBoolean()) {  
        assertThat(exc.getMessage(), containsString("was (2m > 1m)"));  
            assertThat(totalHits, equalTo(2));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));  
        }  
        assertThat(searchResponse.getHits().getHits().length, equalTo(35));
    public void testScrollAndUpdateIndex() throws Exception {  
            .get();
        assertThat(clearScrollResponse.isSucceeded(), is(true));
        );
        refresh();
            () -> client().admin()  
            }
        } finally {
     */  
                .setPersistentSettings(Settings.builder().put("search.max_keep_alive", "2m"))
import static org.hamcrest.Matchers.is;
        SearchResponse searchResponse = client().prepareSearch()  
            int totalHits = 0;
    }
        assertToXContentResponse(response, true, response.getNumFreed());
                    // Verify sort order
    public void testScrollWithSequentialReaderCacheReturnsCorrectResults() throws Exception {
                if (scrollId != null) {
 * GitHub history for details.
        client().admin().indices().prepareRefresh().get();
        for (ShardSearchFailure shardSearchFailure : error.shardFailures()) {  
        for (SearchHit hit : searchResponse1.getHits()) {
        refresh();
package org.opensearch.search.scroll;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
import static org.hamcrest.Matchers.greaterThan;
            .setSize(randomIntBetween(1, 10))  
        }  
 * The OpenSearch Contributors require contributions made to  
        createIndex("test");
    public void testSimpleScrollQueryThenFetch() throws Exception {
     */
            .setSearchType(SearchType.QUERY_THEN_FETCH)
    /**
                routing = "1";
                .setId(Integer.toString(i))
                        .field("user", "foobar")  
                .get()
        final int numShards = randomIntBetween(3, 5);
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();  
        for (SearchHit hit : searchResponse1.getHits()) {  
        assertThat(searchResponse2.getHits().getTotalHits().value(), equalTo(100L));
import java.util.HashSet;
        client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 5)).get();
 *  
        assertThat(searchResponse2.getHits().getHits().length, equalTo(35));  
            .setScroll(TimeValue.timeValueMinutes(2))
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
        );
        client().admin()
        } finally {
            for (int i = 0; i < 32; i++) {  
            IllegalArgumentException.class,
 * this file be licensed under the Apache-2.0 license or a
        }
            .addScrollId(searchResponse2.getScrollId())
            .setScroll(TimeValue.timeValueMinutes(2))
import org.opensearch.common.unit.TimeValue;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
                assertThat(searchResponse.getHits().getHits().length, equalTo(3));
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).execute().get();
            // Other invalid base64  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
            .setQuery(matchAllQuery())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .setSize(35)
        );  
                .get()
            int expectedValue = 0;
    public void testThatNonExistingScrollIdReturnsCorrectException() throws Exception {  
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "update")).get().getHits().getTotalHits().value(),  
            .get();
            .get();  
/*  
                    clearScroll(scrollId);  
            assertAcked(client().admin().indices().prepareDelete("test"));
import static org.hamcrest.Matchers.containsString;
        for (int i = 0; i < 100; i++) {
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
            .addScrollId(  
                    retrievedOrder.add(docId);
        );  
                .prepareUpdateSettings()
            .indices()
 */  
        SearchResponse resp = null;  
        ClearScrollResponse clearScrollResponse = client().prepareClearScroll().addScrollId(searchResponse.getScrollId()).get();
import static org.opensearch.index.query.QueryBuilders.termQuery;
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
    /**  
        assertThat(clearResponse.getNumFreed(), greaterThan(0));
        }
        client().admin().indices().prepareRefresh().get();
        }
                .cluster()
 *
            .setScroll(TimeValue.timeValueMinutes(2))
                        .field("postDate", System.currentTimeMillis())
            .setScroll("1m")
            () -> client().admin()
            do {
        SearchResponse searchResponse2 = client().prepareSearch()  
        );
                .get();  
        assertThat(searchResponse1.getHits().getTotalHits().value(), equalTo(100L));  
            .setScroll(TimeValue.timeValueMinutes(5))
        }
        long counter2 = 0;
import org.opensearch.common.Priority;  
            for (SearchHit hit : searchResponse.getHits()) {  
                searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
                resp = client().prepareSearchScroll(resp.getScrollId()).setScroll(TimeValue.timeValueMinutes(1)).get();  
                    Map<String, Object> map = searchHit.getSourceAsMap();
            do {  
    public void testRestartDataNodesDuringScrollSearch() throws Exception {
            // and now, the last one is one
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    // Verify stored field content matches document id
         */  
            .setSettings(Settings.builder().put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), Integer.MAX_VALUE))
            .get();
     * Tests that scroll queries with StoredFieldsReader caching return correct results
                .get();
            RestStatus.NOT_FOUND
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.index.IndexSettings;  
/*
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));  
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get().getHits().getTotalHits().value(),  
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();  
        );  
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
        client().prepareIndex("index").setId("1").setSource("field", "value").execute().get();
                    jsonBuilder().startObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                .cluster()
        exc = expectThrows(  
        illegalArgumentException = (IllegalArgumentException) ExceptionsHelper.unwrap(exc, IllegalArgumentException.class);
        refresh();
        SearchResponse response = client().prepareSearch("test")
            clearScroll(searchResponse.getScrollId());
        // Whether we actually clear a scroll, we can't know, since that information isn't serialized in the
        );  
            IllegalArgumentException.class,
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "2m"))
                    assertThat("Text field mismatch for doc " + docId, source.get("text"), equalTo("document number " + docId));
        try {  
        );
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "1m"))
 *
            .setSize(35)
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));  
            );  
            SearchRequestBuilder builder = client().prepareSearch("index")  
            .addScrollId(searchResponse1.getScrollId())  
        );
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        searchResponse2 = client().prepareSearchScroll(searchResponse2.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();  
 * software distributed under the License is distributed on an
     * Ensures that we always create and retain search contexts on every target shards for a scroll request
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
            () -> client().prepareClearScroll().addScrollId("a").get()  
 * Modifications Copyright OpenSearch Contributors. See
                searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
    }
                .setId(Integer.toString(i))  
            client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get().getHits().getTotalHits().value(),
            .get();  
        }  
import org.opensearch.search.sort.SortOrder;  
            prepareCreate("test").setSettings(  
            .setScroll(TimeValue.timeValueMinutes(2))
    public void testStringSortMissingAscTerminates() throws Exception {
        }
                batchCount++;
import java.io.IOException;  
        assertThat(searchResponse1.getHits().getHits().length, equalTo(35));
/**
        }
        ClearScrollResponse clearResponse = client().prepareClearScroll().addScrollId("_all").get();  
        SearchResponse searchResponse = client().prepareSearch("index").setSize(1).setScroll("1m").get();
        indexRandomForConcurrentSearch("test");  
            client().admin()
    public static Collection<Object[]> parameters() {
    }  
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
        client().prepareIndex("test").setId("1").setSource("created_date", "2020-01-01").get();
        );  
                .prepareCreate("test")  
                for (SearchHit hit : searchResponse.getHits()) {
        client().prepareIndex("test").setId("1").setSource("some_field", "test").get();
                .get()  
                    map.put("message", "update");  
            assertThat(  
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get().getHits().getTotalHits().value(),
        assertThat(exc.getMessage(), containsString("was (3m > 2m)"));
import org.opensearch.common.xcontent.XContentHelper;
import java.util.Arrays;
                .setSize(randomIntBetween(1, 2))  
                .setPersistentSettings(Settings.builder().put("search.max_keep_alive", "1m").put("search.default_keep_alive", "2m"))  
import org.opensearch.cluster.metadata.IndexMetadata;
            () -> client().prepareClearScroll().addScrollId("c2Nhbjs2OzM0NDg1ODpzRlBLc0FXNlNyNm5JWUc1").get()
            equalTo(500L)
        internalCluster().restartNode(dataNode, new InternalTestCluster.RestartCallback());  
import org.opensearch.core.rest.RestStatus;  
        );  
        e = expectThrows(  
import org.opensearch.action.search.SearchResponse;
            .addSort("field", SortOrder.ASC)
            .get();
        for (int i = 0; i < 100; i++) {
        client().admin().indices().prepareRefresh().get();
        assertThat(  
        client().admin().indices().prepareRefresh("test").get();
        try {
import org.opensearch.action.search.SearchPhaseExecutionException;  
            assertThat("Not all documents retrieved", retrievedIds.size(), equalTo(numDocs));  
        indexRandomForConcurrentSearch("test");
    public void testScrollRewrittenToMatchNoDocs() throws InterruptedException {
    }
            .setSize(35)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;  
        indexRandomForConcurrentSearch("index");  
        }  
        assertNotNull(illegalArgumentException);
        int numDocs = randomIntBetween(10, 100);
 * specific language governing permissions and limitations
        assertAcked(
            client().admin()  
            .setScroll(TimeValue.timeValueMinutes(2))  
        assertHitCount(response, 1);
        }  
                .setSource(jsonBuilder().startObject().field("field", i).endObject())  
        SearchResponse searchResponse = client().prepareSearch()
}  
    }
            try {
        /*  
        } finally {  
                }
import org.apache.lucene.tests.util.LuceneTestCase;  
            .addSort("postDate", SortOrder.ASC)  
            .get();
import org.opensearch.action.search.ClearScrollResponse;
        assertToXContentResponse(clearResponse, true, clearResponse.getNumFreed());  
            .addSort("field", SortOrder.ASC)
                .setId(Integer.toString(i))
        long counter = 0;  
            .setScroll(TimeValue.timeValueMinutes(2))  
                        .field("message", "test")
                assertTrue("Missing document: " + i, retrievedIds.contains(i));
            }
    @After
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
            IllegalArgumentException.class,
        );  
    }
 * not use this file except in compliance with the License.
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "5m").put("search.max_keep_alive", "5m"))  
                    + "AAAAAAAAEWdVcxNWZmRGZSVFN2V0xMUGF2NGx1Zw=="
                assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));  
        assertSearchResponse(response);
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter1++));
            .setQuery(new MatchAllQueryBuilder())
        client().prepareIndex("test").setId("3").setSource("created_date", "2020-01-03").get();  
        Exception exc = expectThrows(
        );
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
                .cluster()
            } while (searchResponse.getHits().getHits().length > 0);
 * ownership. Elasticsearch licenses this file to you under  
        indexRandomForConcurrentSearch("test");  
        assertRequestBuilderThrows(
            SearchResponse response = builder.get();  
        createIndex(
                equalTo(500L)  
     */  
            .setQuery(matchAllQuery())
            .prepareCreate("test")
            for (SearchHit hit : searchResponse.getHits()) {
        for (SearchHit hit : searchResponse1.getHits()) {
            }
            for (SearchHit hit : searchResponse.getHits()) {  
            client().prepareSearchScroll(searchResponse1.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)),  
            .get();
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
                .get()
            .addSort("field", SortOrder.ASC)  
            );
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter1++));
import org.opensearch.index.query.QueryBuilders;
            internalCluster().client().prepareSearchScroll(searchResponse1.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)),
     * Tests that we use an optimization shrinking the batch to the size of the shard. Thus the Integer.MAX_VALUE window doesn't OOM us.
            // Fails during base64 decoding (Base64-encoded string must have at least four characters)
                for (SearchHit hit : searchResponse.getHits().getHits()) {  
        IllegalArgumentException illegalArgumentException = (IllegalArgumentException) ExceptionsHelper.unwrap(
            assertThat(searchResponse.getHits().getHits().length, equalTo(3));
            }
 * Licensed to Elasticsearch under one or more contributor  
            .setSize(scrollSize)
import org.opensearch.common.xcontent.XContentFactory;  
        long counter1 = 0;
            IllegalArgumentException.class,  
        assertThat(searchResponse2.getHits().getTotalHits().value(), equalTo(100L));
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();  
            .addSort("field", SortOrder.ASC)  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
                searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();  
    public void testSimpleScrollQueryThenFetchSmallSizeUnevenDistribution() throws Exception {
            }
        }  
        );  
        indexRandomForConcurrentSearch("test");
        assertThat(response.getNumFreed(), equalTo(0));
        for (SearchHit hit : searchResponse2.getHits()) {
            }
        SearchResponse respFromProdIndex = client().prepareSearch("prod")
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
 * <p>{@code @SuppressCodecs("*")} is needed because we cache StoredFieldsReader instances
                .cluster()
        IllegalArgumentException exc = expectThrows(
            assertNoFailures(resp);  
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
import java.util.Set;
            for (int i = 0; i < numDocs; i++) {  
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
                assertNoFailures(searchResponse);  
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));  
    }  
        assertThat(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get().getHits().getTotalHits().value(), equalTo(500L));
        try {
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));  
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        );
        assertEquals("Cannot parse scroll id", e.getMessage());
                .put("index.routing.allocation.include._name", dataNode)  
    }
            clearScroll(searchResponse.getScrollId());
            for (SearchHit hit : searchResponse.getHits()) {
        assertThat(clearResponse.isSucceeded(), is(true));  
            "demo",
    public SearchScrollIT(Settings settings) {
                )
            ).setMapping("no_field", "type=keyword", "some_field", "type=keyword")
            }
            assertThat(shardSearchFailure.getCause().getMessage(), containsString("No search context found for id [1]"));
        assertThat(exc.getMessage(), containsString("was (1m > 30s)"));
        indexRandomForConcurrentSearch("test");
        );  
        super(settings);  
    public void cleanup() throws Exception {  
        }
        }
            } else if (i > 60) {
import org.opensearch.common.settings.Settings;
                    );
import java.util.ArrayList;
        assertEquals("Cannot parse scroll id", e.getMessage());
        assertThat(map.get("num_freed"), equalTo(numFreed));
     * and no missing documents when using the sequential reader optimization.  
            } while (searchResponse.getHits().getHits().length > 0);
            .setQuery(matchAllQuery())
                    assertTrue("Duplicate document id: " + docId, retrievedIds.add(docId));  
                equalTo(0L)
                String scrollId = response.getScrollId();
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "5m").put("search.max_keep_alive", "5m"))  
         * unreasonable batch sizes to just OOM.
            assertThat(searchResponse.getHits().getHits().length, equalTo(0));
    @ParametersFactory  
                .setId(Integer.toString(i))
        final String dataNode = internalCluster().startDataOnlyNode();  
 */
                .get();  
            client().admin()
    }
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
                .setQuery(QueryBuilders.matchAllQuery())
        assertThat(clearResponse.getNumFreed(), greaterThan(0));
            .get();
        int scrollSize = randomIntBetween(10, 35);
        );
            assertThat(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get().getHits().getTotalHits().value(), equalTo(500L));
        long counter2 = 0;  
            internalCluster().client().prepareSearchScroll(searchResponse2.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)),
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
            .setQuery(matchAllQuery())
            .setSize(35)
                    int docId = Integer.parseInt(hit.getId());
import org.opensearch.action.search.SearchType;  
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter2++));  
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter2++));
            resp = client().prepareSearch("test")  
import org.opensearch.ExceptionsHelper;
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
            .get();
    public void testCloseAndReopenOrDeleteWithActiveScroll() throws InterruptedException {
public class SearchScrollIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        client().admin().indices().prepareRefresh().get();
        searchResponse2 = client().prepareSearchScroll(searchResponse2.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
 * You may obtain a copy of the License at  
        assertAcked(  
            SearchPhaseExecutionException.class,  
        createIndex("idx");
                    assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));  
            .addSort(new FieldSortBuilder("no_field").order(SortOrder.ASC).missing("_last"))  
            RestStatus.NOT_FOUND
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
    }
        assertEquals("Cannot parse scroll id", e.getMessage());  
            client().prepareIndex("test")
            IllegalArgumentException.class,  
                .cluster()
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "3m"))
            .setQuery(queryStringQuery("user:foobar"))  
        client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 3)).get();
        indexRandomForConcurrentSearch("test");  
 *
        assertNotNull(illegalArgumentException);  
            RestStatus.NOT_FOUND
                        equalTo(expectedValue)  
 * license agreements. See the NOTICE file distributed with
                .get();
        assertHitCount(response, 1);
                }
            assertThat(
        ClearScrollResponse response = client().prepareClearScroll()
import java.util.Collections;
    public void testSimpleScrollQueryThenFetch_clearScrollIds() throws Exception {
                .setId(Integer.toString(i))  
        client().admin().indices().prepareRefresh().get();
            .setSize(1)
 *  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards))
    }
        SearchResponse searchResponse = client().prepareSearch()  
            }
            Settings.builder()
        );  
        );
 * across scroll batches for sequential access. Different batches may run on different threads  
        refresh();  
    }
        client().prepareIndex("test").setId("2").setSource("created_date", "2020-01-02").get();
                .prepareUpdateSettings()  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
                .build()  
                for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            .get();
import org.opensearch.index.query.RangeQueryBuilder;  
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", i).setRouting(routing).get();
                .setSource(jsonBuilder().startObject().field("field", i).field("text", "document number " + i).endObject())
                }
import java.util.Map;
        assertThat(  
                .prepareUpdateSettings()
 */
    }
                .prepareUpdateSettings()  
        }
                .setSource(jsonBuilder().startObject().field("field", i).endObject())  
            client().prepareSearch().setSize(0).setQuery(termQuery("message", "update")).get().getHits().getTotalHits().value(),
        Set<Integer> retrievedIds = new HashSet<>();
        assertThat(searchResponse2.getHits().getHits().length, equalTo(35));
        for (int i = 0; i < 100; i++) {
            long counter = 0;  
    }
@LuceneTestCase.SuppressCodecs("*")  
    /**  
            () -> client().prepareSearchScroll(respFromDemoIndex.getScrollId()).get()
        // free search context response, which is returned from each node we want to clear a particular scroll.  
        SearchResponse searchResponse2 = client().prepareSearch()
        assertAcked(  
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
            .setScroll("1m")
    public void testClearIllegalScrollId() throws Exception {
import static org.hamcrest.Matchers.equalTo;  
        long counter1 = 0;
        assertThat(clearResponse.status(), equalTo(RestStatus.OK));  
        assertAcked(
        } finally {  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        for (SearchHit hit : searchResponse.getHits()) {  
 * KIND, either express or implied.  See the License for the
 * @see org.opensearch.search.internal.ScrollContext#getCachedSequentialReader(Object)
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
import java.util.Collection;  
                        .endObject()  
            }
            }
        }  
                .setScroll(TimeValue.timeValueMinutes(1))
        client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 3)).get();  
        assertThat(response.getHits().getHits().length, equalTo(0));
            )  
        );  
        assertSearchHits(response, "1");
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
        client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 3)).get();
            }
        for (int i = 0; i < 500; i++) {
                    expectedValue++;  
        client().admin().indices().prepareRefresh().get();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
            () -> client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueHours(3)).get()
        response = client().prepareSearchScroll(response.getScrollId()).get();  
            .setSize(35)
        }
            .setQuery(matchAllQuery())
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(searchResponse1.getHits().getHits().length, equalTo(35));  
        assertRequestBuilderThrows(  
                .prepareUpdateSettings()
    public void testInvalidScrollKeepAlive() throws IOException, InterruptedException {
                .setPersistentSettings(Settings.builder().put("search.max_keep_alive", "30s"))
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
        int numDocs = randomIntBetween(100, 300);  
         * Disable the max result window setting for this test because it'll reject the search's unreasonable batch size. We want
    public void testSimpleScrollQueryThenFetchClearAllScrollIds() throws Exception {  
            .setScroll(TimeValue.timeValueMinutes(2))  
        } else {
                totalHits += resp.getHits().getHits().length;
        try {  
        SearchResponse searchResponse1 = client().prepareSearch()
            () -> client().prepareClearScroll().addScrollId("abcabc").get()
                routing = "2";  
        response = client().prepareSearch("test")
            client().prepareIndex("test")
        );
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
        searchResponse1 = client().prepareSearchScroll(searchResponse1.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
                .cluster()
                .cluster()
        indexRandomForConcurrentSearch("test");
    }
            );
        }
            assertAcked(client().admin().indices().prepareOpen("test"));
        createIndex("test");  
            RestStatus.NOT_FOUND  
        e = expectThrows(
        XContentBuilder builder = XContentFactory.jsonBuilder();  
import org.opensearch.core.common.bytes.BytesReference;
                .get()
            () -> client().prepareSearch().setQuery(matchAllQuery()).setSize(1).setScroll(TimeValue.timeValueHours(2)).get()  
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
            client().prepareSearch().setSize(0).setQuery(termQuery("message", "update")).get().getHits().getTotalHits().value(),  
    }  
import org.opensearch.core.xcontent.ToXContent;
        assertToXContentResponse(clearResponse, true, clearResponse.getNumFreed());
 * compatible open source license.
                    assertThat("Field value mismatch for doc " + docId, source.get("field"), equalTo(docId));
        for (SearchHit hit : searchResponse2.getHits()) {
        for (int i = 0; i < numDocs; i++) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoSearchHits;
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter1++));  
        assertAcked(
                .build()
            .get();  
            .addSort("field", SortOrder.ASC)
            .setQuery(matchAllQuery())
        }  
        assertThat(searchResponse1.getHits().getTotalHits().value(), equalTo(100L));
                equalTo(0L)
                .setId(Integer.toString(i))
            .setQuery(new MatchAllQueryBuilder())
    private void assertToXContentResponse(ClearScrollResponse response, boolean succeed, int numFreed) throws IOException {
            Exception.class,
        assertNoSearchHits(response);  
 * Tests for scrolling.  
            .addSort("field", SortOrder.ASC)
 * this work for additional information regarding copyright
        client().admin().indices().prepareRefresh().get();
    }
            IllegalArgumentException.class
 * (but never concurrently). Lucene's AssertingStoredFieldsFormat enforces thread affinity
        }
        assertThat(illegalArgumentException.getMessage(), containsString("Keep alive for request (2h) is too large"));
            .addSort(new FieldSortBuilder("no_field").order(SortOrder.ASC).missing("_first"))  
        assertAcked(
    }  
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "update")).get().getHits().getTotalHits().value(),
            client().prepareIndex("test")  
        }  
            client().admin()
 * Unless required by applicable law or agreed to in writing,
            .get();
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
import static org.hamcrest.Matchers.notNullValue;  
import java.util.List;  
                }
            client().prepareIndex("test")  
            Settings.builder()  
                OpenSearchAssertions.assertHitCount(response, 1L);

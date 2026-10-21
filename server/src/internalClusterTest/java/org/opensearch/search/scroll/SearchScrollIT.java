        searchResponse2 = client().prepareSearchScroll(searchResponse2.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
    }
            assertAcked(client().admin().indices().prepareClose("test"));
            .setQuery(matchAllQuery())
 */
            .setSearchType(SearchType.QUERY_THEN_FETCH)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                }
import org.opensearch.index.query.RangeQueryBuilder;
            )
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(
            .setQuery(matchAllQuery())
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
        }
            .setSize(35)
            client().admin()
        );
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            assertThat(
        } finally {
            if (i > 90) {
                    Map<String, Object> map = searchHit.getSourceAsMap();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
 * @see org.opensearch.search.internal.ScrollContext#getCachedSequentialReader(Object)
            .get();
                    assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
            () -> client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueHours(3)).get()
            .setSize(3)
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
                .prepareUpdateSettings()
import java.util.Map;
        assertThat(searchResponse2.getHits().getTotalHits().value(), equalTo(100L));
        refresh();
            .setSize(35)
                assertNoFailures(searchResponse);
        assertAcked(
/**
                    );
            assertNoFailures(resp);
        refresh();
        client().prepareIndex("test").setId("2").setSource("created_date", "2020-01-02").get();
        SearchResponse respFromDemoIndex = client().prepareSearch("demo")
                .get()
        SearchResponse searchResponse1 = client().prepareSearch()
 * The OpenSearch Contributors require contributions made to
        assertThat(
                )
        SearchResponse searchResponse = client().prepareSearch("index").setSize(1).setScroll("1m").get();
            .indices()
            .addSort("field", SortOrder.ASC)
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            clearScroll(searchResponse.getScrollId());
            .addSort("field", SortOrder.ASC)
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
                .get();
            exc,
        client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 3)).get();
            .get();
        client().prepareSearchScroll(respFromProdIndex.getScrollId()).get();
                .setScroll("1m");
    }
            // Fails during base64 decoding (Base64-encoded string must have at least four characters)
            () -> client().prepareClearScroll().addScrollId("c2Nhbjs2OzM0NDg1ODpzRlBLc0FXNlNyNm5JWUc1").get()
 *
            .setQuery(matchAllQuery())
import org.opensearch.action.search.ShardSearchFailure;
            .addSort(new FieldSortBuilder("no_field").order(SortOrder.ASC).missing("_first"))
            RestStatus.NOT_FOUND
        Set<Integer> retrievedIds = new HashSet<>();
import org.opensearch.common.unit.TimeValue;
        for (SearchHit hit : searchResponse2.getHits()) {
        assertHitCount(response, 1);
import java.util.HashSet;
            .setQuery(matchAllQuery())
        createIndex(
            Exception.class,
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards))
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.common.xcontent.XContentFactory;
        }
        );
            clearScroll(searchResponse.getScrollId());
         */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
    }
import org.apache.lucene.tests.util.LuceneTestCase;
                    expectedValue++;
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
            assertThat("Not all documents retrieved", retrievedIds.size(), equalTo(numDocs));
        }
            for (SearchHit hit : searchResponse.getHits()) {
            .addSort("field", SortOrder.ASC)
        IllegalArgumentException exc = expectThrows(
            .addSort("field", SortOrder.ASC)
import org.junit.After;
        client().admin().indices().prepareRefresh().get();
        }
    }
        assertThat(
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        );
            for (SearchHit hit : searchResponse.getHits()) {
        client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 5)).get();
@LuceneTestCase.SuppressCodecs("*")
                        .endObject()
        SearchResponse response = client().prepareSearch("test")
        assertThat(searchResponse2.getHits().getTotalHits().value(), equalTo(100L));
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
 * You may obtain a copy of the License at
            .addSort("field", SortOrder.ASC)
        assertRequestBuilderThrows(
            .addScrollId(
                .put("index.routing.allocation.include._name", dataNode)
            );
        SearchResponse searchResponse2 = client().prepareSearch()
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter1++));
                assertNoFailures(resp);
        for (ShardSearchFailure shardSearchFailure : error.shardFailures()) {
        }
            } else if (i > 60) {
            .setSize(randomIntBetween(1, 10))
        createIndex("test");
        assertRequestBuilderThrows(internalCluster().client().prepareSearchScroll(searchResponse.getScrollId()), RestStatus.NOT_FOUND);
        );
                .setTransientSettings(Settings.builder().putNull("*"))
        );
    }
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "1m"))
                .cluster()
            assertThat(searchResponse.getHits().getHits().length, equalTo(3));
    public void testScrollAndUpdateIndex() throws Exception {
                        .field("user", "foobar")
import org.opensearch.action.search.SearchResponse;
        searchResponse1 = client().prepareSearchScroll(searchResponse1.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
        );
            long counter = 0;
                equalTo(0L)
            }
        assertThat(exc.getMessage(), containsString("was (2m > 1m)"));
    public void testClearIllegalScrollId() throws Exception {
                .setPersistentSettings(Settings.builder().put("search.max_keep_alive", "1m").put("search.default_keep_alive", "2m"))
            () -> client().admin()
                client().prepareClearScroll().addScrollId(resp.getScrollId()).get();
    }
 * this work for additional information regarding copyright
                    map.put("message", "update");
            () -> client().prepareSearchScroll(respFromDemoIndex.getScrollId()).get()
 * this file be licensed under the Apache-2.0 license or a
            .setSize(1)
        client().prepareIndex("test").setId("1").setSource("some_field", "test").get();
    }
        if (randomBoolean()) {
            assertAcked(client().admin().indices().prepareOpen("test"));
        );
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter2++));
 *
        indexRandomForConcurrentSearch("test");
}
import org.opensearch.ExceptionsHelper;
        SearchResponse respFromProdIndex = client().prepareSearch("prod")
import org.opensearch.index.IndexSettings;
            IllegalArgumentException.class,
 * under the License.
        SearchResponse searchResponse = client().prepareSearch()
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                    Map<String, Object> source = hit.getSourceAsMap();
        assertNotNull(illegalArgumentException);
            .get();
                .prepareUpdateSettings()
        client().admin().indices().prepareRefresh("test").get();
                .get()
            .setScroll(TimeValue.timeValueMinutes(2))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter2++));
            equalTo(500L)
            .setScroll(TimeValue.timeValueMinutes(2))
            }
        }
            .addSort("postDate", SortOrder.ASC)
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
        for (int i = 0; i < 100; i++) {
import org.opensearch.core.xcontent.XContentBuilder;
        long counter1 = 0;
import org.opensearch.test.hamcrest.OpenSearchAssertions;
                .cluster()
                .get();
        }
                .build()
        assertHitCount(response, 1);
     */
            IllegalArgumentException.class,
            ).setMapping("no_field", "type=keyword", "some_field", "type=keyword")
        response = client().prepareSearch("test")
            client().prepareIndex("test")
                    assertThat("Text field mismatch for doc " + docId, source.get("text"), equalTo("document number " + docId));
                    assertThat(
        assertEquals("Cannot parse scroll id", e.getMessage());
            for (SearchHit hit : searchResponse.getHits()) {
                    // Verify no duplicates
            client().prepareIndex("test")
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
            .setSearchType(SearchType.QUERY_THEN_FETCH)
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
            .addScrollId(searchResponse1.getScrollId())
import org.opensearch.action.search.SearchRequestBuilder;
        );
        );
            assertThat(
            .setQuery(matchAllQuery())
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "2m"))
        assertAcked(
    public void testRestartDataNodesDuringScrollSearch() throws Exception {
        assertAcked(
        for (int i = 0; i < 500; i++) {
        response = client().prepareSearchScroll(response.getScrollId()).get();
                searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
            client().admin()
        assertThat(searchResponse.getScrollId(), is(notNullValue()));
            assertThat(searchResponse.getHits().getHits().length, equalTo(35));
            .get();
    public void testScrollRewrittenToMatchNoDocs() throws InterruptedException {
        }
            int batchCount = 0;
            .setScroll(TimeValue.timeValueMinutes(2))
import org.opensearch.core.xcontent.ToXContent;
            Settings.builder()
 * KIND, either express or implied.  See the License for the
            IllegalArgumentException.class
        try {
                .setPersistentSettings(Settings.builder().put("search.max_keep_alive", "30s"))
        SearchResponse searchResponse = client().prepareSearch()
        client().admin().indices().prepareRefresh().get();
            .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
        try {
        }
                routing = "1";
    public static Collection<Object[]> parameters() {
        );
        );
                .prepareUpdateSettings()
import org.opensearch.search.sort.FieldSortBuilder;
            client().admin().indices().prepareRefresh().get();
            client().prepareIndex("test")
        assertAcked(
 * that rejects this valid sequential cross-thread usage.
            .setScroll(TimeValue.timeValueMinutes(5))
        }
        client().admin()
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            resp = client().prepareSearch("test")
        assertThat(searchResponse2.getHits().getTotalHits().value(), equalTo(100L));
            client().prepareIndex("test")
                .setQuery(QueryBuilders.matchAllQuery())
        assertThat(clearScrollResponse.isSucceeded(), is(true));
import java.util.Set;
        Exception exc = expectThrows(
    /**
            );
            client().admin()
    }
package org.opensearch.search.scroll;
            }
            internalCluster().client().prepareSearchScroll(searchResponse2.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)),
            assertThat(searchResponse.getHits().getHits().length, equalTo(35));
            } while (searchResponse.getHits().getHits().length > 0);
        assertThat(searchResponse2.getHits().getHits().length, equalTo(35));
        assertToXContentResponse(clearResponse, true, clearResponse.getNumFreed());
 *    http://www.apache.org/licenses/LICENSE-2.0
                for (SearchHit hit : searchResponse.getHits()) {
        );
            .setQuery(matchAllQuery())
            RestStatus.NOT_FOUND
        assertThat(searchResponse2.getHits().getTotalHits().value(), equalTo(100L));
            IllegalArgumentException.class,
                .setSize(Integer.MAX_VALUE)
import org.opensearch.test.InternalTestCluster;
                }
        );
        SearchResponse searchResponse = client().prepareSearch()
import org.opensearch.action.search.SearchPhaseExecutionException;
    public void cleanup() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
                .indices()
        client().prepareIndex("test").setId("1").setSource("created_date", "2020-01-01").get();
                        "Document out of order at position " + retrievedOrder.size(),
                .get();
            assertThat(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get().getHits().getTotalHits().value(), equalTo(500L));
            .addSort(new FieldSortBuilder("no_field").order(SortOrder.ASC).missing("_last"))
            for (SearchHit hit : searchResponse.getHits()) {
     */
            .get();
        assertThat(searchResponse2.getHits().getHits().length, equalTo(35));
        assertRequestBuilderThrows(
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
            }
                OpenSearchAssertions.assertHitCount(response, 1L);
        assertHitCount(response, 1);
        );
import static org.hamcrest.Matchers.equalTo;
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", i).setRouting(routing).get();
            .setScroll("1m")
            for (int i = 0; i < 32; i++) {
        SearchResponse searchResponse = client().prepareSearch()
            .addSort("field", SortOrder.ASC)
            }
            .setScroll(TimeValue.timeValueMinutes(2))
        return Arrays.asList(
        assertThat(clearResponse.getNumFreed(), greaterThan(0));
                .get();
    /**
 * Unless required by applicable law or agreed to in writing,
        client().admin().indices().prepareRefresh().get();
            clearScroll(searchResponse.getScrollId());
                .cluster()
        int numDocs = randomIntBetween(10, 100);
                .get()
            index("demo", "_doc", "demo-" + i, Collections.emptyMap());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoSearchHits;
            assertThat(totalHits, equalTo(2));
                searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
    public SearchScrollIT(Settings settings) {
        SearchResponse searchResponse2 = client().prepareSearch()
        assertAcked(
                .setMapping("created_date", "type=date,format=yyyy-MM-dd")
import java.io.IOException;
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
            client().prepareSearch().setSize(0).setQuery(termQuery("message", "update")).get().getHits().getTotalHits().value(),
            client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get().getHits().getTotalHits().value(),
        for (SearchHit hit : searchResponse1.getHits()) {
            .addSort("field", SortOrder.ASC)
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
            .get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            prepareCreate("test").setSettings(
                    + "AAAAAAAAEWdVcxNWZmRGZSVFN2V0xMUGF2NGx1Zw=="
        assertEquals("Cannot parse scroll id", e.getMessage());
                .setId(Integer.toString(i))
        } else {
            RestStatus.NOT_FOUND
            .setScroll(TimeValue.timeValueMinutes(2))
            .get();
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "5m").put("search.max_keep_alive", "5m"))
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter1++));
                    int docId = Integer.parseInt(hit.getId());
        SearchResponse searchResponse1 = client().prepareSearch()
        try {
            .setSettings(Settings.builder().put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), Integer.MAX_VALUE))
                .setMaxConcurrentShardRequests(randomIntBetween(1, 3)) // sometimes fan out shard requests one by one
                        .field("postDate", System.currentTimeMillis())
            .setSize(35)
                    assertThat("Field value mismatch for doc " + docId, source.get("field"), equalTo(docId));
            }
                .setId(Integer.toString(i))
         * unreasonable batch sizes to just OOM.
    }
     * Ensures that we always create and retain search contexts on every target shards for a scroll request
        assertSearchHits(response, "1");
                .setPersistentSettings(Settings.builder().putNull("*"))
        assertThat(searchResponse.getHits().getHits().length, equalTo(35));
        ClearScrollResponse clearScrollResponse = client().prepareClearScroll().addScrollId(searchResponse.getScrollId()).get();
            } while (searchResponse.getHits().getHits().length > 0);
            ensureGreen("test");
        client().admin().indices().prepareRefresh().get();
            .setScroll(TimeValue.timeValueMinutes(5))
public class SearchScrollIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .get();
import org.opensearch.common.Priority;
                assertThat(searchResponse.getHits().getHits().length, equalTo(3));
            do {
            .get();
 * SPDX-License-Identifier: Apache-2.0
     * regardless whether that query can be written to match_no_docs on some target shards or not.
                    clearScroll(scrollId);
            Settings.builder()
            SearchResponse response = builder.get();
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get().getHits().getTotalHits().value(),
        }
        internalCluster().restartNode(dataNode, new InternalTestCluster.RestartCallback());
        assertThat(searchResponse1.getHits().getTotalHits().value(), equalTo(100L));
import static org.opensearch.index.query.QueryBuilders.termQuery;
            .get();
            assertThat(searchResponse.getHits().getHits().length, equalTo(30));
        indexRandomForConcurrentSearch("demo", "prod");
    }
        exc = expectThrows(
                .cluster()
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
    }
    public void testCloseAndReopenOrDeleteWithActiveScroll() throws InterruptedException {
        assertThat(searchResponse1.getHits().getTotalHits().value(), equalTo(100L));
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter1++));
        for (SearchHit hit : searchResponse.getHits()) {
        assertToXContentResponse(clearResponse, true, clearResponse.getNumFreed());
        }
            client().prepareIndex("test")
                .put("index.routing.allocation.include._name", dataNode)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
            "prod",
            .setQuery(queryStringQuery("user:foobar"))
                .get();
        long counter2 = 0;
                .build()
        super(settings);
import static org.hamcrest.Matchers.containsString;
        client().admin()
        refresh();
                .get()
        for (SearchHit hit : searchResponse2.getHits()) {
    public void testDeepScrollingDoesNotBlowUp() throws Exception {
        }
                assertTrue("Missing document: " + i, retrievedIds.contains(i));
        for (SearchHit hit : searchResponse1.getHits()) {
import org.opensearch.common.settings.Settings;
            // Verify complete sequence
        }
            .setScroll(TimeValue.timeValueMinutes(2))
            .addSort("field", SortOrder.ASC)
        searchResponse1 = client().prepareSearchScroll(searchResponse1.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
        ClearScrollResponse response = client().prepareClearScroll()
        assertToXContentResponse(response, true, response.getNumFreed());
            () -> client().admin()
        );
                .cluster()
            .get();
        for (int i = 0; i < numDocs; i++) {
         * Disable the max result window setting for this test because it'll reject the search's unreasonable batch size. We want
    public void testScrollInvalidDefaultKeepAlive() throws IOException {
        assertThat(response.isSucceeded(), is(true));
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
        );
            .setSize(35)
        assertThat(clearResponse.getNumFreed(), greaterThan(0));
                .get()
    /**
            "demo",
        indexRandomForConcurrentSearch("test");
        response = client().prepareSearchScroll(response.getScrollId()).get();
    public void testThatNonExistingScrollIdReturnsCorrectException() throws Exception {
                    assertTrue("Duplicate document id: " + docId, retrievedIds.add(docId));
        assertNoSearchHits(response);
        for (SearchHit hit : searchResponse1.getHits()) {
        assertThat(response.getHits().getHits().length, equalTo(0));
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter1++));
        );
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter2++));
            client().admin()
            .setScroll(TimeValue.timeValueMinutes(2))
        assertAcked(
    public void testSimpleScrollQueryThenFetchSmallSizeUnevenDistribution() throws Exception {
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            IllegalArgumentException.class,
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
            assertThat(
        e = expectThrows(
        for (int i = 0; i < 100; i++) {
import org.opensearch.action.search.ClearScrollResponse;
        client().admin().indices().prepareRefresh().get();
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
    }
        exc = expectThrows(
        assertThat(illegalArgumentException.getMessage(), containsString("Keep alive for request (3h) is too large"));
            .get();
     */
        } finally {
/*
        assertThat(searchResponse1.getHits().getTotalHits().value(), equalTo(100L));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
            }
            assertAcked(client().admin().indices().prepareDelete("test"));
        indexRandomForConcurrentSearch("test");
            () -> client().prepareClearScroll().addScrollId("a").get()
    private void assertToXContentResponse(ClearScrollResponse response, boolean succeed, int numFreed) throws IOException {
        }
        assertNotNull(illegalArgumentException);
    public void testClearNonExistentScrollId() throws Exception {
 */
            assertThat(searchResponse.getHits().getHits().length, equalTo(1));
                .setSearchType(searchType)
        assertThat(exc.getMessage(), containsString("was (3m > 2m)"));
    }
                .cluster()
                .setSource(jsonBuilder().startObject().field("field", i).field("text", "document number " + i).endObject())
        try {
            String routing = "0";
 */
            client().admin()
import java.util.ArrayList;
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
                .cluster()
            () -> client().prepareSearch().setQuery(matchAllQuery()).setSize(1).setScroll(TimeValue.timeValueHours(2)).get()
                    jsonBuilder().startObject()
        for (int i = 0; i < 100; i++) {
            .prepareUpdateSettings("index")
            assertThat(searchResponse.getHits().getHits().length, equalTo(0));
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) numDocs));
     * and no missing documents when using the sequential reader optimization.
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "update")).get().getHits().getTotalHits().value(),
    }
                .prepareUpdateSettings()
            );
            // a the last is zero
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                .setId(Integer.toString(i))
import java.util.Collection;
                batchCount++;
        assertAcked(
        long counter = 0;
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
            for (SearchHit hit : searchResponse.getHits()) {
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "5m").put("search.max_keep_alive", "5m"))
            } finally {
        );
import org.opensearch.search.sort.SortOrder;
 * not use this file except in compliance with the License.
            IllegalArgumentException.class,
import java.util.Arrays;
        XContentBuilder builder = XContentFactory.jsonBuilder();
                .setId(Integer.toString(i))
            int totalHits = 0;
        assertSearchResponse(response);
 */
            // and now, the last one is one
    public void testSimpleScrollQueryThenFetchClearAllScrollIds() throws Exception {
        );
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
                equalTo(500L)
        assertHitCount(response, 1);
                .prepareUpdateSettings()
        // free search context response, which is returned from each node we want to clear a particular scroll.
            IllegalArgumentException.class,
        for (SearchType searchType : SearchType.values()) {
import static org.hamcrest.Matchers.is;
        }
        long counter2 = 0;
        }
                        .field("message", "test")
        e = expectThrows(
        }
            .setQuery(matchAllQuery())
                .setId(Integer.toString(i))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
                .prepareUpdateSettings()
            for (SearchHit hit : searchResponse.getHits()) {
 *
        SearchResponse resp = null;
            .setScroll(TimeValue.timeValueMinutes(2))
            .setSize(35)
                .cluster()
                .setId(Integer.toString(i))
        for (int i = 0; i < numDocs; i++) {
        Map<String, Object> map = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
import org.opensearch.cluster.metadata.IndexMetadata;
                .setSource(jsonBuilder().startObject().field("field", i).endObject())
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get().getHits().getTotalHits().value(),
        assertThat(searchResponse1.getHits().getHits().length, equalTo(35));
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * software distributed under the License is distributed on an
        client().admin().indices().prepareRefresh().get();
        indexRandomForConcurrentSearch("test");
        assertThat(searchResponse2.getHits().getHits().length, equalTo(35));
            .addScrollId(searchResponse2.getScrollId())
        for (int i = 0; i < 100; i++) {
        client().prepareIndex("index").setId("1").setSource("field", "value").execute().get();
        indexRandomForConcurrentSearch("test");
 *
        /*
            // Other invalid base64
            client().prepareSearchScroll(searchResponse2.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)),
            .prepareCreate("test")
            }
            .indices()
        for (int i = 0; i < 2; i++) {
        client().prepareIndex("test").setId("3").setSource("created_date", "2020-01-03").get();
        createIndex("idx");
            equalTo(500L)
            equalTo(0L)
 * specific language governing permissions and limitations
                client().prepareSearch().setSize(0).setQuery(termQuery("message", "update")).get().getHits().getTotalHits().value(),
            .setQuery(matchAllQuery())
            for (int i = 0; i < numDocs; i++) {
        assertThat(map.get("succeeded"), is(succeed));
                    // Verify sort order
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
/*
            }
        }
        final String dataNode = internalCluster().startDataOnlyNode();
    }
                if (scrollId != null) {
 *
                for (SearchHit searchHit : searchResponse.getHits().getHits()) {
                        equalTo(expectedValue)
                .prepareUpdateSettings()
import org.opensearch.search.SearchHit;
            }
        }
                resp = client().prepareSearchScroll(resp.getScrollId()).setScroll(TimeValue.timeValueMinutes(1)).get();
                .get()
        assertThat(searchResponse1.getHits().getHits().length, equalTo(35));
            );
                assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(100L));
        } finally {
            // Verify all documents retrieved
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
            long counter = 0;
            .setQuery(new MatchAllQueryBuilder())
        );
                }
        assertThat(map.get("num_freed"), equalTo(numFreed));
                totalHits += resp.getHits().getHits().length;
            assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter2++));
        assertThat(searchResponse2.getHits().getHits().length, equalTo(35));
        assertThat(illegalArgumentException.getMessage(), containsString("Keep alive for request (2h) is too large"));
        assertThat(clearResponse.status(), equalTo(RestStatus.OK));
 * license agreements. See the NOTICE file distributed with
        for (SearchHit hit : searchResponse1.getHits()) {
            .setQuery(matchAllQuery())
        illegalArgumentException = (IllegalArgumentException) ExceptionsHelper.unwrap(exc, IllegalArgumentException.class);
            .setScroll("1m")
            int expectedValue = 0;
        for (SearchHit hit : searchResponse2.getHits()) {
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.common.xcontent.XContentHelper;
            Exception.class,
        searchResponse2 = client().prepareSearchScroll(searchResponse2.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
            client().prepareIndex("test")
        }
        SearchPhaseExecutionException error = expectThrows(
                searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
                        ((Number) hit.getSortValues()[0]).intValue(),
            }
        assertNoFailures(respFromProdIndex);
 * compatible open source license.
        assertThat(searchResponse1.getHits().getTotalHits().value(), equalTo(100L));
        assertThat(response.getNumFreed(), equalTo(0));
        } finally {
    public void testSimpleScrollQueryThenFetch_clearScrollIds() throws Exception {
        assertRequestBuilderThrows(
        assertThat(searchResponse1.getHits().getHits().length, equalTo(35));
        assertEquals("Cannot parse scroll id", e.getMessage());
import java.util.Collections;
 * Licensed to Elasticsearch under one or more contributor
    }
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).execute().get();
            () -> client().admin()
    @After
    public void testInvalidScrollKeepAlive() throws IOException, InterruptedException {
        assertThat(
 * GitHub history for details.
 * across scroll batches for sequential access. Different batches may run on different threads
            .get();
     * across multiple batches. Verifies document order, content integrity, no duplicates,
                .prepareUpdateSettings()
        ClearScrollResponse clearResponse = client().prepareClearScroll().addScrollId("_all").get();
        SearchResponse searchResponse = client().prepareSearch("test")
            .setSize(35)
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get().getHits().getTotalHits().value(), equalTo(500L));
            if (resp != null && resp.getScrollId() != null) {
        assertThat(response.status(), equalTo(RestStatus.NOT_FOUND));
            .get();
        assertThat(exc.getMessage(), containsString("was (1m > 30s)"));
            index("prod", "_doc", "prod-" + i, Collections.emptyMap());
        );
        assertThat(searchResponse1.getHits().getHits().length, equalTo(35));
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
                .setQuery(new RangeQueryBuilder("created_date").gte("2020-01-02").lte("2020-01-03"))
            SearchPhaseExecutionException.class,
            .setSize(scrollSize)
            .setScroll(TimeValue.timeValueMinutes(2))
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            client().prepareSearchScroll(searchResponse1.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)),
                .setScroll(TimeValue.timeValueMinutes(1))
            .setSize(35)
        IllegalArgumentException illegalArgumentException = (IllegalArgumentException) ExceptionsHelper.unwrap(
        assertSearchHits(response, "1");
                .get()
 * (but never concurrently). Lucene's AssertingStoredFieldsFormat enforces thread affinity
        createIndex(
    }
        final int numShards = randomIntBetween(3, 5);
            client().admin()
        IllegalArgumentException e = expectThrows(
        assertThat(clearResponse.status(), equalTo(RestStatus.OK));
                .setSource(
            equalTo(0L)
            client().prepareSearch().setSize(0).setQuery(termQuery("message", "test")).get().getHits().getTotalHits().value(),
            () -> client().prepareClearScroll().addScrollId("abcabc").get()
        );
            assertThat(shardSearchFailure.getCause().getMessage(), containsString("No search context found for id [1]"));
                for (SearchHit hit : searchResponse.getHits().getHits()) {
        indexRandomForConcurrentSearch("test");
        );
        assertNotNull(searchResponse.getScrollId());
import java.util.List;
        );
        SearchResponse searchResponse = client().prepareSearch()
    @ParametersFactory
        indexRandomForConcurrentSearch("index");
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
        );
                .prepareUpdateSettings()
import org.opensearch.core.rest.RestStatus;
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
                    client().prepareIndex("test").setId(searchHit.getId()).setSource(map).get();
                    retrievedOrder.add(docId);
        client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 3)).get();
                .get()
import org.opensearch.action.search.SearchType;
import org.opensearch.index.query.MatchAllQueryBuilder;
        } finally {
    }
        for (SearchHit hit : searchResponse2.getHits()) {
                String scrollId = response.getScrollId();
            while (resp.getHits().getHits().length > 0) {
    public void testScrollWithSequentialReaderCacheReturnsCorrectResults() throws Exception {
            .get();
            try {
        assertThat(clearResponse.isSucceeded(), is(true));
                equalTo(0L)
                .cluster()
        }
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .setSize(randomIntBetween(1, 2))
        try {
        // Whether we actually clear a scroll, we can't know, since that information isn't serialized in the
        assertThat(clearResponse.isSucceeded(), is(true));
        ensureGreen("demo", "prod");
/*
import org.opensearch.index.query.QueryBuilders;
                .get();
        );
            .get();
        int numDocs = randomIntBetween(100, 300);
            .get();
        for (int i = 0; i < 100; i++) {
        client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 3)).get();
                routing = "2";
        indexRandomForConcurrentSearch("test");
        createIndex("idx");
 * ownership. Elasticsearch licenses this file to you under
        refresh();
            client().admin()
     * Tests that scroll queries with StoredFieldsReader caching return correct results
            .get();
            .setScroll(TimeValue.timeValueMinutes(5))
            client().prepareSearch().setSize(0).setQuery(termQuery("message", "update")).get().getHits().getTotalHits().value(),
                .get();
        );
     * Tests that we use an optimization shrinking the batch to the size of the shard. Thus the Integer.MAX_VALUE window doesn't OOM us.
        client().admin().indices().prepareRefresh().get();
import org.opensearch.core.common.bytes.BytesReference;
                    // Verify stored field content matches document id
        );
            clearScroll(searchResponse.getScrollId());
        int scrollSize = randomIntBetween(10, 35);
        indexRandomForConcurrentSearch("test");
                .setPersistentSettings(Settings.builder().put("search.max_keep_alive", "2m"))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            .setQuery(new MatchAllQueryBuilder())
import static org.hamcrest.Matchers.notNullValue;
        List<Integer> retrievedOrder = new ArrayList<>();
        }
        long counter1 = 0;
        assertThat(
                .setPersistentSettings(Settings.builder().put("search.default_keep_alive", "3m"))
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
            assertThat("Multiple batches should have been used", batchCount, greaterThan(1));
    public void testSimpleScrollQueryThenFetch() throws Exception {
    public void testStringSortMissingAscTerminates() throws Exception {
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
                "DnF1ZXJ5VGhlbkZldGNoAwAAAAAAAAABFnRtLWMyRzBqUUQyNk1uM0xDTjJ4S0EAAAAAAAAAARYzNkhxbWFTYVFVNmgxTGQyYUZVYV9nAA"
        }
        );
            internalCluster().client().prepareSearchScroll(searchResponse1.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)),
    }
        assertRequestBuilderThrows(
        indexRandomForConcurrentSearch("test");
                .prepareCreate("test")
 * <p>{@code @SuppressCodecs("*")} is needed because we cache StoredFieldsReader instances
            }
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", i).get();
 * Tests for scrolling.
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
            RestStatus.NOT_FOUND
        createIndex("test");
        indexRandomForConcurrentSearch("test");
                }
        ClearScrollResponse clearResponse = client().prepareClearScroll()
            SearchRequestBuilder builder = client().prepareSearch("index")
        client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 3)).get();
        assertAcked(
        exc = expectThrows(
                assertThat(((Number) hit.getSortValues()[0]).longValue(), equalTo(counter++));
                equalTo(500L)
            .setSize(randomIntBetween(1, 10))
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(2)).get();
            do {

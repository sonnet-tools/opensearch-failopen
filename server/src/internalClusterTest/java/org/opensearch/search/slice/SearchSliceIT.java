 *
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
    public SearchSliceIT(Settings staticSettings) {
                .slice(new SliceBuilder("invalid_random_int", 0, 10))
import org.opensearch.action.search.SearchResponse;
 * the Apache License, Version 2.0 (the "License"); you may
            int numSliceResults = searchResponse.getHits().getHits().length;
 */
            );
                    .addAliasAction(IndicesAliasesRequest.AliasActions.add().index("test").alias("alias2").routing("bar"))
import static org.hamcrest.Matchers.startsWith;
            SearchResponse sr = client().prepareSearch("test").setQuery(matchAllQuery()).setRouting("foo", "bar").setSize(0).get();
    public void testWithPreferenceAndRoutings() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .startObject("invalid_random_kw")
                .addSort(SortBuilders.fieldSort("_doc"));
            .field("doc_values", "false")
            () -> client().prepareSearch("test")
        pitRequest.setIndices(new String[] { "test" });
        assertThat(rootCause.getMessage(), startsWith("cannot load numeric doc values"));
            String scrollId = searchResponse.getScrollId();
                }
 * SPDX-License-Identifier: Apache-2.0
        );
                    .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
                .setSize(fetchSize)
import static org.hamcrest.Matchers.equalTo;
            .setSize(fetchSize)
            // test numeric sort
        assertAcked(
    }
import java.util.ArrayList;
            assertSearchSlicesWithScroll(request, "_id", max, numDocs);
 * <p>{@code @SuppressCodecs("*")} is needed because we cache StoredFieldsReader instances
        SliceBuilder sliceBuilder = new SliceBuilder("_id", 0, 4);
                .setSettings(
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
                .field("static_int", 0)
        }
        List<String> keys = new ArrayList<>();
                .setQuery(matchAllQuery())
            int fetchSize = randomIntBetween(10, 100);
 * specific language governing permissions and limitations
            int fetchSize = randomIntBetween(10, 100);
 *
        List<IndexRequestBuilder> requests = new ArrayList<>();
        assertThat(totalResults, equalTo(numDocs));
        int numDocs = randomIntBetween(100, 1000);
        }
                .indices()
        exc = expectThrows(
            totalResults += searchResponse.getHits().getHits().length;
                    .prepareAliases()
            assertSearchSlicesWithScroll(request, "_id", max, numDocs);
 */
import org.apache.lucene.tests.util.LuceneTestCase;
            SliceBuilder sliceBuilder = new SliceBuilder(field, id, numSlice);
        SearchPhaseExecutionException exc = expectThrows(
    private void assertSearchSlicesWithScroll(SearchRequestBuilder request, String field, int numSlice, int numDocs) {
    }
                .setQuery(matchAllQuery())
            while (searchResponse.getHits().getHits().length > 0) {
        assertThat(rootCause.getClass(), equalTo(IllegalArgumentException.class));
        setupIndex(totalDocs, numShards);
        SearchPhaseExecutionException exc = expectThrows(
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
            }
                searchResponse = request.setFrom(numSliceResults).slice(sliceBuilder).get();
 */
                totalResults += searchResponse.getHits().getHits().length;
        super(staticSettings);
            .field("type", "integer")
            int max = randomIntBetween(2, numShards * 3);
    public void testInvalidFields() throws Exception {
    public void testSearchSortWithPIT() throws Exception {
            int fetchSize = randomIntBetween(10, 100);
                .addSort(SortBuilders.fieldSort("random_int"));
                .field("invalid_random_int", randomInt())
        assertThat(new HashSet(keys).size(), equalTo(numDocs));
}
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
            SearchRequestBuilder request = client().prepareSearch("test")
        SearchRequestBuilder request = client().prepareSearch("test")
        setupIndex(numDocs, numShards);
            SearchResponse sr = client().prepareSearch("alias1", "alias3").setQuery(matchAllQuery()).setSize(0).get();
            assertSearchSlicesWithScroll(request, "_id", max, numDocs);
import org.opensearch.action.index.IndexRequestBuilder;
        }
        );
 * that rejects this valid sequential cross-thread usage.
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        Throwable ret = e;
        int totalResults = 0;
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
                }
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
        client().admin().indices().prepareDelete("test").get();
                assertTrue(keys.add(hit.getId()));
        return Arrays.asList(
    }
import java.util.List;
import org.opensearch.common.xcontent.XContentFactory;
    }
 * this work for additional information regarding copyright
        for (int id = 0; id < numSlice; id++) {
        for (String field : new String[] { "_id", "random_int", "static_int" }) {
        int totalDocs = randomIntBetween(100, 1000);
/*
 * across scroll batches for sequential access. Different batches may run on different threads
        int numShards = randomIntBetween(1, 7);
        assertTrue(ex.getMessage().contains("all shards failed"));
 *
            for (SearchHit hit : searchResponse.getHits().getHits()) {
    public void testSearchSortWithoutPitOrScroll() throws Exception {
                .setSize(fetchSize)
                .get()
            .field("doc_values", "true")
        assertThat(rootCause.getClass(), equalTo(IllegalArgumentException.class));
            // test _doc sort
        int fetchSize = randomIntBetween(10, 100);
        Throwable rootCause = findRootCause(exc);
            int numDocs = (int) sr.getHits().getTotalHits().value();
    private void setupIndex(int numDocs, int numberOfShards) throws IOException, ExecutionException, InterruptedException {
/**
                .setSize(fetchSize);
        {
            SearchResponse searchResponse = request.slice(sliceBuilder).setFrom(0).get();
    @ParametersFactory
public class SearchSliceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertThat(rootCause.getMessage(), equalTo("`slice` cannot be used outside of a scroll context or PIT context"));
            .setQuery(matchAllQuery())
            SearchRequestBuilder request = client().prepareSearch("alias1", "alias3")
                totalResults += searchResponse.getHits().getHits().length;
    public void testSearchSort() throws Exception {
            SearchPhaseExecutionException.class,
                    .indices()
import org.opensearch.search.sort.SortBuilders;
            requests.add(client().prepareIndex("test").setSource(builder));
                searchResponse = client().prepareSearchScroll("test")
 *    http://www.apache.org/licenses/LICENSE-2.0
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
import org.opensearch.common.action.ActionFuture;
        rootCause = findRootCause(exc);
                        .put("index.max_slices_per_scroll", 10000)
        int numDocs = randomIntBetween(100, 1000);
import java.io.IOException;
        setupIndex(0, 1);
    private Throwable findRootCause(Exception e) {
            for (SearchHit hit : searchResponse.getHits().getHits()) {
import org.opensearch.search.builder.PointInTimeBuilder;
    public void testInvalidQuery() throws Exception {
                    .addAliasAction(IndicesAliasesRequest.AliasActions.add().index("test").alias("alias3").routing("baz"))
        setupIndex(numDocs, numShards);
 * GitHub history for details.
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(rootCause.getMessage(), startsWith("cannot load numeric doc values"));
        {
            // test _doc sort
    }
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
            assertSearchSlicesWithPIT(request, field, max, numDocs);
import java.util.concurrent.ExecutionException;
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
 */
        List<String> keys = new ArrayList<>();
        CreatePitResponse pitResponse = execute.get();
                .setSize(fetchSize)
                .addSort(SortBuilders.fieldSort("_doc"));
                    .setScrollId(scrollId)
            () -> client().prepareSearch("test")
            }
        assertThat(keys.size(), equalTo(numDocs));
        String mapping = XContentFactory.jsonBuilder()
 * ownership. Elasticsearch licenses this file to you under
            }
import org.opensearch.common.settings.Settings;
 * Licensed to Elasticsearch under one or more contributor
            while (searchResponse.getHits().getHits().length > 0) {
                        .put("number_of_shards", numberOfShards)
 * software distributed under the License is distributed on an
@LuceneTestCase.SuppressCodecs("*")
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to
        {
        }
            XContentBuilder builder = jsonBuilder().startObject()
                for (SearchHit hit : searchResponse.getHits().getHits()) {
                    .get();
        );
        int numDocs = randomIntBetween(100, 1000);
            SearchResponse sr = client().prepareSearch("test").setQuery(matchAllQuery()).setPreference("_shards:1,4").setSize(0).get();
import org.opensearch.common.unit.TimeValue;
            SearchResponse searchResponse = request.slice(sliceBuilder).get();
            .startObject("invalid_random_int")
 * (but never concurrently). Lucene's AssertingStoredFieldsFormat enforces thread affinity
import org.opensearch.action.search.CreatePitAction;
                .setRouting("foo", "bar")
            .endObject()
                numSliceResults += searchResponse.getHits().getHits().length;
                .addSort(SortBuilders.fieldSort("_doc"));
 * not use this file except in compliance with the License.
            .startObject("properties")
                .setQuery(matchAllQuery())
        assertThat(rootCause.getClass(), equalTo(SearchException.class));
                .field("random_int", randomInt())
        }
            .endObject()
        );
            int max = randomIntBetween(2, numShards * 3);
                .setSize(fetchSize)
    }
    private void assertSearchSlicesWithPIT(SearchRequestBuilder request, String field, int numSlice, int numDocs) {
            int fetchSize = randomIntBetween(10, 100);
                .setMapping(mapping)
package org.opensearch.search.slice;
import org.opensearch.core.xcontent.XContentBuilder;
                numSliceResults += searchResponse.getHits().getHits().length;
            int numDocs = (int) sr.getHits().getTotalHits().value();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            assertSearchSlicesWithPIT(request, field, max, numDocs);
                .setQuery(matchAllQuery())
                .slice(new SliceBuilder("invalid_random_kw", 0, 10))
            SearchPhaseExecutionException.class,
        CreatePitRequest pitRequest = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                .setQuery(matchAllQuery())
            .field("type", "integer")
                client().admin()
import org.opensearch.action.search.SearchRequestBuilder;
            .toString();
 * under the License.
 * You may obtain a copy of the License at
                    assertTrue(keys.add(hit.getId()));
        setupIndex(0, 1);
                .get()
 *
            // test numeric sort
            assertSearchSlicesWithScroll(request, field, max, numDocs);
            ret = ret.getCause();
        assertThat(new HashSet(keys).size(), equalTo(numDocs));
        SearchPhaseExecutionException ex = expectThrows(SearchPhaseExecutionException.class, () -> request.slice(sliceBuilder).get());
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * KIND, either express or implied.  See the License for the
    }
                    .get()
                .addSort(SortBuilders.fieldSort("_doc"));
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
                .setPreference("_shards:1,4")
                    Settings.builder()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                )
            .startObject("random_int")
        int max = randomIntBetween(2, numShards * 3);
                .endObject();
        assertThat(keys.size(), equalTo(numDocs));
            SearchRequestBuilder request = client().prepareSearch("test")
                scrollId = searchResponse.getScrollId();
        );
import java.util.Collection;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            int fetchSize = randomIntBetween(10, 100);
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, pitRequest);
        }
            assertAcked(
                .prepareCreate("test")
import org.opensearch.action.search.CreatePitResponse;
import org.opensearch.search.SearchHit;
            assertThat(numSliceResults, equalTo(expectedSliceResults));
        Throwable rootCause = findRootCause(exc);
                .setSize(fetchSize)
            request = client().prepareSearch("test")
            int max = randomIntBetween(2, numShards * 3);
/*
import org.opensearch.action.search.CreatePitRequest;
    }
        int max = randomIntBetween(2, numShards * 3);
                for (SearchHit hit : searchResponse.getHits().getHits()) {
            .endObject()
import java.util.HashSet;
            int expectedSliceResults = (int) searchResponse.getHits().getTotalHits().value();
            totalResults += searchResponse.getHits().getHits().length;
                .field("invalid_random_kw", randomAlphaOfLengthBetween(5, 20))
 * @see org.opensearch.search.internal.ScrollContext#getCachedSequentialReader(Object)
        indexRandom(true, requests);
    }
        }
        for (int id = 0; id < numSlice; id++) {
            assertThat(numSliceResults, equalTo(expectedSliceResults));
                    assertTrue(keys.add(hit.getId()));
                .addSort(SortBuilders.fieldSort("_doc"));
            int numSliceResults = searchResponse.getHits().getHits().length;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        int totalResults = 0;
            client().admin()
 * this file be licensed under the Apache-2.0 license or a
    public static Collection<Object[]> parameters() {
        return ret;
            SearchRequestBuilder request = client().prepareSearch("test")
    }
            assertSearchSlicesWithScroll(request, field, max, numDocs);
        int numShards = randomIntBetween(1, 7);
 * Modifications Copyright OpenSearch Contributors. See
            .addSort(SortBuilders.fieldSort("_doc"));
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        setupIndex(numDocs, numShards);
 * compatible open source license.
            .field("doc_values", "false")
        ensureGreen();
                assertTrue(keys.add(hit.getId()));
        int numShards = 10;
            () -> client().prepareSearch().setQuery(matchAllQuery()).slice(new SliceBuilder("invalid_random_int", 0, 10)).get()
            int numDocs = (int) sr.getHits().getTotalHits().value();
        for (int i = 0; i < numDocs; i++) {
        while (ret.getCause() != null) {
import org.opensearch.action.search.SearchPhaseExecutionException;
/*
                .setQuery(matchAllQuery())
        int numShards = randomIntBetween(1, 7);
            .endObject()
            .endObject()
            SliceBuilder sliceBuilder = new SliceBuilder(field, id, numSlice);
        for (String field : new String[] { "_id", "random_int", "static_int" }) {
        }
            }
        }
            .field("type", "keyword")
 * Unless required by applicable law or agreed to in writing,
            SearchPhaseExecutionException.class,
    }
                .setSize(fetchSize)
            SearchRequestBuilder request = client().prepareSearch("test")
                    .addAliasAction(IndicesAliasesRequest.AliasActions.add().index("test").alias("alias1").routing("foo"))
            clearScroll(scrollId);
                .setQuery(matchAllQuery())
import java.util.Arrays;
        assertThat(totalResults, equalTo(numDocs));
            request = client().prepareSearch("test")
            .startObject()
                .setQuery(matchAllQuery())
import org.opensearch.search.SearchException;
                .setQuery(matchAllQuery())
            int expectedSliceResults = (int) searchResponse.getHits().getTotalHits().value();
import org.opensearch.search.Scroll;
                        .put("index.max_slices_per_pit", 10000)
    }
                .addSort(SortBuilders.fieldSort("random_int"))

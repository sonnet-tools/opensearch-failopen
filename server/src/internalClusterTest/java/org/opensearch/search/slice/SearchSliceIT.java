            while (searchResponse.getHits().getHits().length > 0) {  
                    .get()
        {
                .field("random_int", randomInt())
 */
            .addSort(SortBuilders.fieldSort("_doc"));
        {
        List<String> keys = new ArrayList<>();  
 * SPDX-License-Identifier: Apache-2.0
            SearchResponse searchResponse = request.slice(sliceBuilder).get();  
                    .addAliasAction(IndicesAliasesRequest.AliasActions.add().index("test").alias("alias2").routing("bar"))  
        CreatePitResponse pitResponse = execute.get();
            int max = randomIntBetween(2, numShards * 3);
 * compatible open source license.
                    Settings.builder()
        );
            .endObject()
        assertThat(rootCause.getMessage(), equalTo("`slice` cannot be used outside of a scroll context or PIT context"));
 * Modifications Copyright OpenSearch Contributors. See
        for (int id = 0; id < numSlice; id++) {
            .startObject("properties")
        int numShards = randomIntBetween(1, 7);  
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
        Throwable rootCause = findRootCause(exc);
 * across scroll batches for sequential access. Different batches may run on different threads
public class SearchSliceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                    .addAliasAction(IndicesAliasesRequest.AliasActions.add().index("test").alias("alias1").routing("foo"))
            assertSearchSlicesWithPIT(request, field, max, numDocs);
            .endObject()
        client().admin().indices().prepareDelete("test").get();  
            assertAcked(
            SearchPhaseExecutionException.class,
 * specific language governing permissions and limitations
    public SearchSliceIT(Settings staticSettings) {
        int totalResults = 0;
            int expectedSliceResults = (int) searchResponse.getHits().getTotalHits().value();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            int max = randomIntBetween(2, numShards * 3);
            }
                .addSort(SortBuilders.fieldSort("random_int"));  
        for (int id = 0; id < numSlice; id++) {  
            XContentBuilder builder = jsonBuilder().startObject()  
        int numShards = 10;
                .setSize(fetchSize)  
package org.opensearch.search.slice;
            assertSearchSlicesWithScroll(request, "_id", max, numDocs);  
import java.util.Collection;  
/**  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
            requests.add(client().prepareIndex("test").setSource(builder));  
        indexRandom(true, requests);
        assertTrue(ex.getMessage().contains("all shards failed"));
            // test numeric sort
                .setQuery(matchAllQuery())
        setupIndex(totalDocs, numShards);  
            SearchRequestBuilder request = client().prepareSearch("test")
        assertThat(keys.size(), equalTo(numDocs));
    }
            .setSize(fetchSize)
                .setSize(fetchSize)
                    .prepareAliases()
 */  
 */
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayList;
import java.io.IOException;  
 * @see org.opensearch.search.internal.ScrollContext#getCachedSequentialReader(Object)  
    private void setupIndex(int numDocs, int numberOfShards) throws IOException, ExecutionException, InterruptedException {
import org.opensearch.common.xcontent.XContentFactory;  
 *
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import org.opensearch.action.search.SearchResponse;
        setupIndex(0, 1);  
import org.opensearch.action.search.SearchPhaseExecutionException;  
 * license agreements. See the NOTICE file distributed with
        }
        int numDocs = randomIntBetween(100, 1000);
                assertTrue(keys.add(hit.getId()));  
 * not use this file except in compliance with the License.
                }  
 * this work for additional information regarding copyright
    public void testSearchSort() throws Exception {
 * under the License.  
import org.opensearch.common.settings.Settings;
            SearchResponse sr = client().prepareSearch("test").setQuery(matchAllQuery()).setRouting("foo", "bar").setSize(0).get();  
        setupIndex(numDocs, numShards);
        int totalResults = 0;
            .startObject("invalid_random_kw")
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertTrue(keys.add(hit.getId()));
        SearchRequestBuilder request = client().prepareSearch("test")
            assertThat(numSliceResults, equalTo(expectedSliceResults));
                .addSort(SortBuilders.fieldSort("_doc"));
            int numDocs = (int) sr.getHits().getTotalHits().value();  
            int fetchSize = randomIntBetween(10, 100);  
            SearchPhaseExecutionException.class,
    }
        SearchPhaseExecutionException exc = expectThrows(
import org.opensearch.search.sort.SortBuilders;  
import org.apache.lucene.tests.util.LuceneTestCase;  
            assertSearchSlicesWithScroll(request, field, max, numDocs);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            SearchResponse sr = client().prepareSearch("test").setQuery(matchAllQuery()).setPreference("_shards:1,4").setSize(0).get();
                .slice(new SliceBuilder("invalid_random_kw", 0, 10))  
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
 *
    }  
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
        List<String> keys = new ArrayList<>();
}
            }
        );
        }
            SearchRequestBuilder request = client().prepareSearch("test")  
    }  
 *
import org.opensearch.search.SearchHit;
    private Throwable findRootCause(Exception e) {
                        .put("index.max_slices_per_scroll", 10000)  
            );  
@LuceneTestCase.SuppressCodecs("*")
        int fetchSize = randomIntBetween(10, 100);
        assertThat(rootCause.getMessage(), startsWith("cannot load numeric doc values"));
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))  
            int numSliceResults = searchResponse.getHits().getHits().length;
 * ownership. Elasticsearch licenses this file to you under  
            () -> client().prepareSearch("test")  
        int max = randomIntBetween(2, numShards * 3);  
            totalResults += searchResponse.getHits().getHits().length;
                numSliceResults += searchResponse.getHits().getHits().length;  
            }
                .field("invalid_random_int", randomInt())
                scrollId = searchResponse.getScrollId();
import org.opensearch.action.search.SearchRequestBuilder;
            client().admin()  
            () -> client().prepareSearch().setQuery(matchAllQuery()).slice(new SliceBuilder("invalid_random_int", 0, 10)).get()  
        assertThat(keys.size(), equalTo(numDocs));  
    @ParametersFactory
import org.opensearch.action.search.CreatePitAction;  
    }  
            int numDocs = (int) sr.getHits().getTotalHits().value();
    public void testInvalidQuery() throws Exception {
            .field("doc_values", "true")
                .setQuery(matchAllQuery())
import org.opensearch.action.search.CreatePitRequest;
        );
        }  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * the Apache License, Version 2.0 (the "License"); you may
        }
            String scrollId = searchResponse.getScrollId();
                    .indices()  
                .setQuery(matchAllQuery())
                numSliceResults += searchResponse.getHits().getHits().length;  
                .addSort(SortBuilders.fieldSort("_doc"));  
import org.opensearch.action.search.CreatePitResponse;
            .endObject()  
import org.opensearch.search.Scroll;
                .setQuery(matchAllQuery())
        assertThat(rootCause.getMessage(), startsWith("cannot load numeric doc values"));
            request = client().prepareSearch("test")  
                    .get();  
            SearchRequestBuilder request = client().prepareSearch("test")
        );
    }
        super(staticSettings);
 *    http://www.apache.org/licenses/LICENSE-2.0
                .get()
        while (ret.getCause() != null) {  
                        .put("index.max_slices_per_pit", 10000)
import org.opensearch.core.xcontent.XContentBuilder;
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))  
    public void testSearchSortWithPIT() throws Exception {
        );
    public static Collection<Object[]> parameters() {  
    public void testInvalidFields() throws Exception {
 * (but never concurrently). Lucene's AssertingStoredFieldsFormat enforces thread affinity  
                .setSize(fetchSize)
        SliceBuilder sliceBuilder = new SliceBuilder("_id", 0, 4);  
    }
            assertSearchSlicesWithScroll(request, "_id", max, numDocs);
            assertSearchSlicesWithScroll(request, "_id", max, numDocs);
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, pitRequest);  
            .field("doc_values", "false")
/*  
                .setRouting("foo", "bar")
            .startObject("invalid_random_int")
        int numShards = randomIntBetween(1, 7);  
 * <p>{@code @SuppressCodecs("*")} is needed because we cache StoredFieldsReader instances
 * GitHub history for details.
                .prepareCreate("test")
        }  
import org.opensearch.common.action.ActionFuture;  
            () -> client().prepareSearch("test")  
        for (String field : new String[] { "_id", "random_int", "static_int" }) {
                .setSize(fetchSize)  
            .endObject()
        int totalDocs = randomIntBetween(100, 1000);
            // test numeric sort
        ensureGreen();
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        SearchPhaseExecutionException ex = expectThrows(SearchPhaseExecutionException.class, () -> request.slice(sliceBuilder).get());
            SearchPhaseExecutionException.class,
/*
import org.opensearch.common.unit.TimeValue;
        setupIndex(numDocs, numShards);
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
            SliceBuilder sliceBuilder = new SliceBuilder(field, id, numSlice);
        setupIndex(numDocs, numShards);  
        setupIndex(0, 1);  
                .setSize(fetchSize)
                .setQuery(matchAllQuery())
                for (SearchHit hit : searchResponse.getHits().getHits()) {
                .addSort(SortBuilders.fieldSort("_doc"));
                    .addAliasAction(IndicesAliasesRequest.AliasActions.add().index("test").alias("alias3").routing("baz"))
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
        }
                .slice(new SliceBuilder("invalid_random_int", 0, 10))  
            totalResults += searchResponse.getHits().getHits().length;  
                .setPreference("_shards:1,4")
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        return ret;  
        assertAcked(
            while (searchResponse.getHits().getHits().length > 0) {
    }
            SliceBuilder sliceBuilder = new SliceBuilder(field, id, numSlice);
            // test _doc sort
                .get()
            }
        int numDocs = randomIntBetween(100, 1000);
import org.opensearch.search.builder.PointInTimeBuilder;
                .field("invalid_random_kw", randomAlphaOfLengthBetween(5, 20))
            .field("type", "integer")
        int numDocs = randomIntBetween(100, 1000);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .toString();
            .endObject()  
                .addSort(SortBuilders.fieldSort("random_int"))  
            SearchRequestBuilder request = client().prepareSearch("alias1", "alias3")
import static org.hamcrest.Matchers.equalTo;  
        }
        assertThat(new HashSet(keys).size(), equalTo(numDocs));
                .endObject();
            int fetchSize = randomIntBetween(10, 100);
    private void assertSearchSlicesWithPIT(SearchRequestBuilder request, String field, int numSlice, int numDocs) {  
        for (String field : new String[] { "_id", "random_int", "static_int" }) {
        assertThat(rootCause.getClass(), equalTo(IllegalArgumentException.class));
 *  
        int max = randomIntBetween(2, numShards * 3);  
            .startObject("random_int")  
            .field("type", "integer")
 * KIND, either express or implied.  See the License for the
                totalResults += searchResponse.getHits().getHits().length;
            int fetchSize = randomIntBetween(10, 100);
        exc = expectThrows(
import java.util.List;
                }  
            assertSearchSlicesWithScroll(request, field, max, numDocs);  
        int numShards = randomIntBetween(1, 7);
        Throwable ret = e;
            for (SearchHit hit : searchResponse.getHits().getHits()) {
    }  
                .setQuery(matchAllQuery())
                searchResponse = request.setFrom(numSliceResults).slice(sliceBuilder).get();
            SearchResponse searchResponse = request.slice(sliceBuilder).setFrom(0).get();
        return Arrays.asList(
                .indices()
    }
            assertThat(numSliceResults, equalTo(expectedSliceResults));
                for (SearchHit hit : searchResponse.getHits().getHits()) {
            .startObject()  
 * Licensed to Elasticsearch under one or more contributor  
                .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
                .addSort(SortBuilders.fieldSort("_doc"));
            assertSearchSlicesWithPIT(request, field, max, numDocs);
import org.opensearch.search.SearchException;  
                .setSize(fetchSize);
                    assertTrue(keys.add(hit.getId()));
                .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
                .setMapping(mapping)  
 * software distributed under the License is distributed on an
                .setSettings(  
            // test _doc sort  
                .setQuery(matchAllQuery())  
                    assertTrue(keys.add(hit.getId()));
/*  
            int max = randomIntBetween(2, numShards * 3);  
                        .put("number_of_shards", numberOfShards)
    }
import java.util.concurrent.ExecutionException;  
import org.opensearch.action.index.IndexRequestBuilder;
        String mapping = XContentFactory.jsonBuilder()
                .setSize(fetchSize)
        rootCause = findRootCause(exc);  
        pitRequest.setIndices(new String[] { "test" });
        assertThat(rootCause.getClass(), equalTo(IllegalArgumentException.class));
    public void testSearchSortWithoutPitOrScroll() throws Exception {  
        }
 * You may obtain a copy of the License at  
        assertThat(new HashSet(keys).size(), equalTo(numDocs));  
            SearchRequestBuilder request = client().prepareSearch("test")  
            ret = ret.getCause();
                    .setScroll(new Scroll(TimeValue.timeValueSeconds(10)))
    private void assertSearchSlicesWithScroll(SearchRequestBuilder request, String field, int numSlice, int numDocs) {
        {  
        assertThat(totalResults, equalTo(numDocs));
                    .setScrollId(scrollId)
        CreatePitRequest pitRequest = new CreatePitRequest(TimeValue.timeValueDays(1), true);
            int fetchSize = randomIntBetween(10, 100);
import static org.hamcrest.Matchers.startsWith;
                client().admin()
            .setQuery(matchAllQuery())  
                .setQuery(matchAllQuery())  
                totalResults += searchResponse.getHits().getHits().length;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat(totalResults, equalTo(numDocs));
        SearchPhaseExecutionException exc = expectThrows(
        assertThat(rootCause.getClass(), equalTo(SearchException.class));  
    public void testWithPreferenceAndRoutings() throws Exception {  
        for (int i = 0; i < numDocs; i++) {
 */  
import java.util.HashSet;
                .field("static_int", 0)  
        List<IndexRequestBuilder> requests = new ArrayList<>();
                searchResponse = client().prepareSearchScroll("test")  
                )
 * this file be licensed under the Apache-2.0 license or a
import java.util.Arrays;
            request = client().prepareSearch("test")
                .addSort(SortBuilders.fieldSort("_doc"));  
            .field("doc_values", "false")  
                .setQuery(matchAllQuery())
    }  
 * Unless required by applicable law or agreed to in writing,
        Throwable rootCause = findRootCause(exc);  
 * that rejects this valid sequential cross-thread usage.
            int fetchSize = randomIntBetween(10, 100);  
            int numSliceResults = searchResponse.getHits().getHits().length;  
            .field("type", "keyword")  
            for (SearchHit hit : searchResponse.getHits().getHits()) {  
            clearScroll(scrollId);  
            int numDocs = (int) sr.getHits().getTotalHits().value();
            SearchResponse sr = client().prepareSearch("alias1", "alias3").setQuery(matchAllQuery()).setSize(0).get();
            int expectedSliceResults = (int) searchResponse.getHits().getTotalHits().value();

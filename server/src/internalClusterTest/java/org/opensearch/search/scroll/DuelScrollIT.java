        int scrollDocs = 0;
                sort = SortBuilders.fieldSort("field2").missing("1");
                    .startObject("field2")
            .setScroll("10m")
                    .startObject("field4")
            builders[i] = client().prepareIndex("test").setId(Integer.toString(i)).setSource("foo", random().nextBoolean());
import org.opensearch.search.sort.SortBuilder;
                    .field("type", "long")
            .setSize(context.scrollRequestSize)
import org.opensearch.action.search.SearchType;
                    assertEquals(controlHit.getId(), scrollHit.getId());
            )
    public static Collection<Object[]> parameters() {
import java.util.Collection;
        final SortBuilder sort;
        for (SearchHit hit : searchScrollResponse.getHits()) {
                        .startObject("nested")
            .get();
    public void testDuelQueryThenFetch() throws Exception {
                    .endObject()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                scrollDocs += scroll.getHits().getHits().length;
 *
        }
        indexRandom(true, builders);
        }
            .setQuery(QueryBuilders.matchQuery("foo", "true"))
        assertThat(searchScrollResponse.getHits().getTotalHits().value(), equalTo((long) context.numDocs));
            this.searchType = searchType;
        String scrollId = searchScrollResponse.getScrollId();
        for (int i = 0; i < numMissingDocs; i++) {
        final SearchResponse control = client().prepareSearch("test")
            }
        for (int i = 1; i <= numDocs; i++) {
                indexRequestBuilder.setSource(
        if (randomBoolean()) {
            for (SearchHit hit : searchScrollResponse.getHits()) {
            if (randomBoolean()) {
            .setSearchType(searchType)
        assertNoFailures(control);
            .get();
                expectedLength = context.scrollRequestSize - (scrollSlice - context.numDocs);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.index.IndexRequestBuilder;
                assertEquals(control.getHits().getTotalHits().value(), scroll.getHits().getTotalHits().value());
            }
 * Unless required by applicable law or agreed to in writing,
    }
        final int numDocs = createIndex(false);
            while (true) {
        final SearchType searchType;
            assertThat(searchScrollResponse.getHits().getTotalHits().value(), equalTo((long) context.numDocs));
        settings.put("index.refresh_interval", -1);
    private TestContext create(SearchType... searchTypes) throws Exception {
                        .field("field3", i)
                    .endObject()
            clearScroll(scroll.getScrollId());
 * not use this file except in compliance with the License.
                    .startObject("field1")
            .setTrackScores(trackScores)
 * Licensed to Elasticsearch under one or more contributor
        final int numDocs;
import org.opensearch.index.query.QueryBuilders;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    .endObject()
            Arrays.asList(SearchType.QUERY_THEN_FETCH, SearchType.DFS_QUERY_THEN_FETCH)
        if (singleShard) {
                indexRequestBuilder.setRouting("a");
        }
        SearchResponse scroll = client().prepareSearch("test")
                        .field("field2", String.valueOf(i))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        clearScroll(scrollId);
                sort = SortBuilders.fieldSort("field1").missing(1);
        assertThat(counter, equalTo(context.numDocs));
            } else {
 * this file be licensed under the Apache-2.0 license or a
    }
    public DuelScrollIT(Settings settings) {
        final int scrollRequestSize;
                        .field("field4", String.valueOf(i))
import org.opensearch.search.sort.SortBuilders;
            if (missingDocs.contains(i)) {
            while (!missingDocs.add(randomInt(numDocs))) {
        return new TestContext(numDocs, scrollRequestSize, sort, searchType);
import static org.hamcrest.Matchers.equalTo;
 *
    }
import org.opensearch.search.SearchHit;
            }
/*
import java.util.HashSet;
    }
            random(),
            }
                assertNoFailures(scroll);
                scroll = client().prepareSearchScroll(scroll.getScrollId()).setScroll("10m").get();
            .setTrackScores(trackScores)
                    .endObject()
            scrollId = searchScrollResponse.getScrollId();
                    jsonBuilder().startObject()
                        .endObject()
                for (int i = 0; i < scroll.getHits().getHits().length; ++i) {
        Settings.Builder settings = Settings.builder();
            if (scrollSlice <= context.numDocs) {
            .addSort(context.sort)
        assertThat(searchScrollResponse.getHits().getHits().length, equalTo(context.scrollRequestSize));
                        .endObject()
            }
        logger.info("numDocs={}, scrollRequestSize={}, sort={}, searchType={}", numDocs, scrollRequestSize, sort, searchType);
                    .field("type", "nested")
            }
 * software distributed under the License is distributed on an
                    .endObject()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        }
            IndexRequestBuilder indexRequestBuilder = client().prepareIndex("index").setId(String.valueOf(i));
                    SearchHit controlHit = control.getHits().getAt(scrollDocs + i);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.search.SearchResponse;
                }
                sort = SortBuilders.fieldSort("nested.field3").missing(1);
                indexRequestBuilder.setSource("x", "y");
                    .field("type", "keyword")
import java.util.Arrays;
                    .endObject()
    }
        int counter = 0;
            this.scrollRequestSize = scrollRequestSize;
        }
                    .startObject("field3")
        settings.put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0);
        int iter = 1;
        // no replicas, as they might be ordered differently
        SearchResponse searchScrollResponse = client().prepareSearch("index")
        super(settings);
 * compatible open source license.
            this.sort = sort;
            assertEquals(control.getHits().getTotalHits().value(), scrollDocs);
 */
            .setScroll("10m")
            .setSearchType(searchType)
                expectedLength = context.scrollRequestSize;
            .addSort(SortBuilders.fieldSort("_doc"))
            } else {
        }
        }
    @ParametersFactory
            .setSearchType(context.searchType)
        );
                    SearchHit scrollHit = scroll.getHits().getAt(i);
 * under the License.
}
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import org.opensearch.common.settings.Settings;
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
                jsonBuilder().startObject()
        assertAcked(prepareCreate("test").setSettings(settings.build()).get());
        SearchResponse control = client().prepareSearch("index")
            logger.info("Scroll size={}, from={}:\n{}", size, scrollDocs, scroll);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .endObject()
import java.util.Set;
        );
            .setQuery(QueryBuilders.matchQuery("foo", "true"))
                assertThat(hit.getSortValues()[0], equalTo(sh.getAt(counter++).getSortValues()[0]));
                    .startObject("nested")
import org.opensearch.search.SearchHits;
    private int createIndex(boolean singleShard) throws Exception {
        final int size = scaledRandomIntBetween(5, numDocs + 5);
            }
        for (int i = 0; i < numDocs; ++i) {
            .get();
            assertThat(searchScrollResponse.getHits().getHits().length, equalTo(expectedLength));
            .addSort(SortBuilders.fieldSort("_doc"))
            logger.info("Control:\n{}", control);
                    break;
                if (scroll.getHits().getHits().length == 0) {
            if (searchScrollResponse.getHits().getHits().length == 0) {
        assertThat(sh.getTotalHits().value(), equalTo((long) context.numDocs));
public class DuelScrollIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }
            .get();
            }
        int numDocs = 2 + randomInt(512);
            if (randomBoolean()) {
/*
import org.opensearch.cluster.metadata.IndexMetadata;
 * specific language governing permissions and limitations
        while (true) {
    public void testDuelIndexOrderQueryThenFetch() throws Exception {
        final int numDocs = randomIntBetween(10, 200);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 *
 */
        } catch (AssertionError e) {
            assertThat(hit.getSortValues()[0], equalTo(sh.getAt(counter++).getSortValues()[0]));
        final Set<Integer> missingDocs = new HashSet<>(numMissingDocs);
        SearchHits sh = control.getHits();
        int numMissingDocs = scaledRandomIntBetween(0, numDocs / 100);
        refresh();
 * this work for additional information regarding copyright
        testDuelIndexOrder(searchType, true, numDocs);
        return Arrays.asList(
/*
    }
 * ownership. Elasticsearch licenses this file to you under
            indexRandom(false, indexRequestBuilder);
        sort.order(randomBoolean() ? SortOrder.ASC : SortOrder.DESC);
        }
            if (unevenRouting && randomInt(3) <= 2) {
        final SortBuilder sort;
 * Modifications Copyright OpenSearch Contributors. See
            throw e;
 * SPDX-License-Identifier: Apache-2.0
        int scrollRequestSize = randomIntBetween(1, rarely() ? numDocs : numDocs / 2);
 * the Apache License, Version 2.0 (the "License"); you may
        assertNoFailures(searchScrollResponse);
        TestContext context = create(SearchType.DFS_QUERY_THEN_FETCH, SearchType.QUERY_THEN_FETCH);
import org.opensearch.search.sort.SortOrder;
        } finally {
            .setSize(numDocs)
    private void testDuelIndexOrder(SearchType searchType, boolean trackScores, int numDocs) throws Exception {
                );
    class TestContext {
 * You may obtain a copy of the License at
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        return numDocs;
 */
 * KIND, either express or implied.  See the License for the
        } else {
        }
            searchScrollResponse = client().prepareSearchScroll(scrollId).setScroll("10m").get();
            } else {
    }
                    .endObject()
        assertAcked(
        assertThat(sh.getHits().length, equalTo(context.numDocs));
            settings.put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);
        TestContext(int numDocs, int scrollRequestSize, SortBuilder sort, SearchType searchType) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            .setSearchType(context.searchType)
        );
        SearchType searchType = RandomPicks.randomFrom(random(), Arrays.asList(searchTypes));
                    .startObject("properties")
                        .field("field1", i)
            int scrollSlice = ++iter * context.scrollRequestSize;
 * GitHub history for details.
            } else {
            prepareCreate("index").setMapping(
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
            .addSort(context.sort)
                    .field("type", "keyword")
            .setSize(size)
            }
        final SearchType searchType = RandomPicks.randomFrom(
                break;
        assertNoFailures(control);
                    .startObject("properties")
        // we need to control refreshes as they might take different merges into account
            this.numDocs = numDocs;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .field("type", "long")
            assertNoFailures(searchScrollResponse);
        boolean unevenRouting = randomBoolean();
                assertEquals(control.getHits().getMaxScore(), scroll.getHits().getMaxScore(), 0.01f);
package org.opensearch.search.scroll;
            .setSize(context.numDocs)
        try {
            int expectedLength;
                sort = SortBuilders.fieldSort("nested.field4").missing("1");
                }
        testDuelIndexOrder(searchType, false, numDocs);

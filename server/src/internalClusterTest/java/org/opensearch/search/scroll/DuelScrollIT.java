            this.numDocs = numDocs;
                    SearchHit controlHit = control.getHits().getAt(scrollDocs + i);
                assertNoFailures(scroll);
                expectedLength = context.scrollRequestSize - (scrollSlice - context.numDocs);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.SearchHit;
        Settings.Builder settings = Settings.builder();  
                        .field("field2", String.valueOf(i))  
    }  
            .setSize(context.scrollRequestSize)  
            }
    }  
 * specific language governing permissions and limitations
            } else {
        logger.info("numDocs={}, scrollRequestSize={}, sort={}, searchType={}", numDocs, scrollRequestSize, sort, searchType);
                    .startObject("properties")  
            logger.info("Control:\n{}", control);
            while (!missingDocs.add(randomInt(numDocs))) {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.sort.SortBuilders;
        }
import java.util.Collection;  
        final int scrollRequestSize;
                sort = SortBuilders.fieldSort("field2").missing("1");  
        assertThat(sh.getTotalHits().value(), equalTo((long) context.numDocs));  
/*
                    .field("type", "keyword")
    }  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        SearchType searchType = RandomPicks.randomFrom(random(), Arrays.asList(searchTypes));
package org.opensearch.search.scroll;
            .setScroll("10m")
}
            if (randomBoolean()) {  
                        .startObject("nested")
            settings.put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1);
            logger.info("Scroll size={}, from={}:\n{}", size, scrollDocs, scroll);  
        SearchResponse searchScrollResponse = client().prepareSearch("index")  
                    .field("type", "long")
                    SearchHit scrollHit = scroll.getHits().getAt(i);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .setSearchType(searchType)
        }  
                    assertEquals(controlHit.getId(), scrollHit.getId());
            assertEquals(control.getHits().getTotalHits().value(), scrollDocs);  
        settings.put("index.refresh_interval", -1);
                assertThat(hit.getSortValues()[0], equalTo(sh.getAt(counter++).getSortValues()[0]));
 * Unless required by applicable law or agreed to in writing,
            .setTrackScores(trackScores)  
        int scrollDocs = 0;
import org.opensearch.cluster.metadata.IndexMetadata;
        assertNoFailures(searchScrollResponse);
        final SortBuilder sort;  
            } else {  
                    .startObject("field2")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                );  
 * software distributed under the License is distributed on an
        assertThat(counter, equalTo(context.numDocs));
        } catch (AssertionError e) {
                    .endObject()  
                scrollDocs += scroll.getHits().getHits().length;  
    public static Collection<Object[]> parameters() {
                        .field("field4", String.valueOf(i))  
            )
        settings.put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0);
                    jsonBuilder().startObject()
        sort.order(randomBoolean() ? SortOrder.ASC : SortOrder.DESC);  
        final Set<Integer> missingDocs = new HashSet<>(numMissingDocs);
            if (searchScrollResponse.getHits().getHits().length == 0) {
            while (true) {  
            if (randomBoolean()) {  
        return Arrays.asList(
 *
import org.opensearch.action.search.SearchType;  
    }
        SearchResponse scroll = client().prepareSearch("test")
    }  
                    .startObject("field3")
            .get();
            if (unevenRouting && randomInt(3) <= 2) {  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
            throw e;
        final int numDocs;
 * GitHub history for details.
        super(settings);  
            assertThat(searchScrollResponse.getHits().getTotalHits().value(), equalTo((long) context.numDocs));  
        TestContext(int numDocs, int scrollRequestSize, SortBuilder sort, SearchType searchType) {  
            assertThat(searchScrollResponse.getHits().getHits().length, equalTo(expectedLength));  
                break;
                    .field("type", "nested")
 *
                sort = SortBuilders.fieldSort("nested.field4").missing("1");  
        }
                        .endObject()
            assertThat(hit.getSortValues()[0], equalTo(sh.getAt(counter++).getSortValues()[0]));
            }
            builders[i] = client().prepareIndex("test").setId(Integer.toString(i)).setSource("foo", random().nextBoolean());
                        .field("field1", i)
        }  
            assertNoFailures(searchScrollResponse);
            this.searchType = searchType;
                    .startObject("nested")
            }  
                expectedLength = context.scrollRequestSize;
    }
            int expectedLength;
                    .field("type", "keyword")
                sort = SortBuilders.fieldSort("field1").missing(1);
import org.opensearch.action.index.IndexRequestBuilder;
        int counter = 0;
                    .startObject("properties")  
        TestContext context = create(SearchType.DFS_QUERY_THEN_FETCH, SearchType.QUERY_THEN_FETCH);  
        assertAcked(  
        int iter = 1;
                jsonBuilder().startObject()
                    .field("type", "long")
        boolean unevenRouting = randomBoolean();
            .setSize(context.numDocs)
        );
                scroll = client().prepareSearchScroll(scroll.getScrollId()).setScroll("10m").get();
        final SearchResponse control = client().prepareSearch("test")
            }  
        }
            .setTrackScores(trackScores)  
import org.opensearch.index.query.QueryBuilders;  
 * this file be licensed under the Apache-2.0 license or a
        final SortBuilder sort;
            }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        for (int i = 0; i < numDocs; ++i) {
        SearchResponse control = client().prepareSearch("index")
        for (int i = 0; i < numMissingDocs; i++) {
            .setSearchType(context.searchType)
        // we need to control refreshes as they might take different merges into account  
        final int numDocs = createIndex(false);  
import java.util.HashSet;
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];  
            .addSort(SortBuilders.fieldSort("_doc"))
                    .startObject("field4")
                    .endObject()  
 *  
            .setSearchType(context.searchType)  
    public void testDuelQueryThenFetch() throws Exception {
                indexRequestBuilder.setSource("x", "y");
            random(),  
 * Licensed to Elasticsearch under one or more contributor  
            scrollId = searchScrollResponse.getScrollId();
        clearScroll(scrollId);
                    .endObject()
        String scrollId = searchScrollResponse.getScrollId();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 */  
import org.opensearch.search.SearchHits;
        } else {
    private int createIndex(boolean singleShard) throws Exception {
            }
                    .endObject()  
        while (true) {  
 */
        assertAcked(prepareCreate("test").setSettings(settings.build()).get());  
            indexRandom(false, indexRequestBuilder);  
        return numDocs;
import org.opensearch.action.search.SearchResponse;
        final int size = scaledRandomIntBetween(5, numDocs + 5);  
        } finally {
        testDuelIndexOrder(searchType, false, numDocs);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                    .endObject()
 * under the License.  
            clearScroll(scroll.getScrollId());  
                if (scroll.getHits().getHits().length == 0) {
/*  
        assertThat(sh.getHits().length, equalTo(context.numDocs));
    private TestContext create(SearchType... searchTypes) throws Exception {
        final SearchType searchType;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .startObject("field1")
            this.scrollRequestSize = scrollRequestSize;
 * compatible open source license.
 * not use this file except in compliance with the License.
            } else {
                }  
            }
        }
        try {
        }
                }
            int scrollSlice = ++iter * context.scrollRequestSize;  
            .setScroll("10m")
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.sort.SortBuilder;  
        return new TestContext(numDocs, scrollRequestSize, sort, searchType);
            for (SearchHit hit : searchScrollResponse.getHits()) {
            .addSort(context.sort)
            .get();
        if (randomBoolean()) {
        int numMissingDocs = scaledRandomIntBetween(0, numDocs / 100);  
        );
            if (missingDocs.contains(i)) {  
    }  
import org.opensearch.common.settings.Settings;
    }  
            .setQuery(QueryBuilders.matchQuery("foo", "true"))
                for (int i = 0; i < scroll.getHits().getHits().length; ++i) {
import java.util.Set;
                    .endObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setSize(size)  
            searchScrollResponse = client().prepareSearchScroll(scrollId).setScroll("10m").get();
            .get();
import static org.hamcrest.Matchers.equalTo;
 * You may obtain a copy of the License at  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
    private void testDuelIndexOrder(SearchType searchType, boolean trackScores, int numDocs) throws Exception {
    class TestContext {
            .get();  
        assertThat(searchScrollResponse.getHits().getTotalHits().value(), equalTo((long) context.numDocs));
            Arrays.asList(SearchType.QUERY_THEN_FETCH, SearchType.DFS_QUERY_THEN_FETCH)
                    .endObject()  
            if (scrollSlice <= context.numDocs) {
        int numDocs = 2 + randomInt(512);
                assertEquals(control.getHits().getMaxScore(), scroll.getHits().getMaxScore(), 0.01f);  
    @ParametersFactory  
        for (int i = 1; i <= numDocs; i++) {
    public DuelScrollIT(Settings settings) {
        // no replicas, as they might be ordered differently
            IndexRequestBuilder indexRequestBuilder = client().prepareIndex("index").setId(String.valueOf(i));
        assertNoFailures(control);
            .setQuery(QueryBuilders.matchQuery("foo", "true"))
 * this work for additional information regarding copyright
        assertNoFailures(control);
 * KIND, either express or implied.  See the License for the
                assertEquals(control.getHits().getTotalHits().value(), scroll.getHits().getTotalHits().value());
            }
                        .endObject()
        assertThat(searchScrollResponse.getHits().getHits().length, equalTo(context.scrollRequestSize));  
            .addSort(SortBuilders.fieldSort("_doc"))
        );  
                indexRequestBuilder.setRouting("a");
import org.opensearch.search.sort.SortOrder;
        }
        indexRandom(true, builders);
            .setSize(numDocs)  
            .addSort(context.sort)
            prepareCreate("index").setMapping(
        int scrollRequestSize = randomIntBetween(1, rarely() ? numDocs : numDocs / 2);  
            }
 * the Apache License, Version 2.0 (the "License"); you may
                indexRequestBuilder.setSource(  
        testDuelIndexOrder(searchType, true, numDocs);
/*  
public class DuelScrollIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        final int numDocs = randomIntBetween(10, 200);
            this.sort = sort;  
                    .endObject()  
                    break;
        }
                sort = SortBuilders.fieldSort("nested.field3").missing(1);
 * license agreements. See the NOTICE file distributed with
 */  
            .setSearchType(searchType)
    public void testDuelIndexOrderQueryThenFetch() throws Exception {
        final SearchType searchType = RandomPicks.randomFrom(
                        .field("field3", i)
        refresh();
import java.util.Arrays;
        for (SearchHit hit : searchScrollResponse.getHits()) {  
            } else {
        SearchHits sh = control.getHits();
        if (singleShard) {

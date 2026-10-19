        for (int i = 0; i < numFields - 1; i++) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.SearchHit;
        SearchResponse searchResponse = client().prepareSearch("test")
                }
            .setQuery(matchAllQuery())
                        break;
          Add new data and assert PIT results remain the same and normal search results gets refreshed
            .searchAfter(new Object[] { 0, null })
        }
            SearchPhaseExecutionException e = expectThrows(
                requests.add(client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource(builder));
            SearchPhaseExecutionException e = expectThrows(
            .get();
            } else if (from instanceof Byte) {
                        values.add(randomByte());
/*
                mappings.add("field" + Integer.toString(i));
                    .addSort("field1", SortOrder.ASC)
                    converted.add(0);
    private static class ListComparator implements Comparator<List> {
    }
        }
import org.opensearch.common.action.ActionFuture;
import org.opensearch.action.index.IndexRequestBuilder;
    }
        }
            } else {
                () -> client().prepareSearch("test")
        );
                        break;
import java.util.Collections;
        assertEquals(1, sr.getHits().getHits().length);
                        break;
    @ParametersFactory
 * under the License.
            }
            .get();
 * ownership. Elasticsearch licenses this file to you under
            }
            }
            reqSize = 1;
    private void createIndexMappingsFromObjectType(String indexName, List<Object> types) {
                () -> client().prepareSearch("test").setQuery(matchAllQuery()).searchAfter(new Object[] { 0.75f }).get()
    }
 * GitHub history for details.
/*
import org.opensearch.common.unit.TimeValue;
            for (int i = 0; i < documents.get(0).size(); i++) {
            .addSort("field1", SortOrder.ASC)
            SearchPhaseExecutionException e = expectThrows(
            for (ShardSearchFailure failure : e.shardFailures()) {
                mappings.add("field" + Integer.toString(i));
                    .get()
        }
            values.add(UUIDs.randomBase64UUID());
                assertThat(failure.toString(), containsString("`search_after` cannot be used in a scroll context."));
import static org.hamcrest.Matchers.containsString;
                mappings.add("type=integer");
            assertTrue(e.shardFailures().length > 0);
import org.opensearch.action.search.SearchResponse;
import org.opensearch.core.xcontent.XContentBuilder;
                mappings.add("field" + Integer.toString(i));
        int offset = 0;
            true,
        indexRandom(true, client().prepareIndex("test").setId("0").setSource("field1", 0, "field2", "toto"));
        assertThat(searchResponse.getHits().getHits().length, Matchers.equalTo(1));
public class SearchAfterIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * compatible open source license.
        return converted;
                    .setScroll("1m")
                if (cmp != 0) {
    public void testsShouldFail() throws Exception {
                mappings.add("field" + Integer.toString(i));
        }
}
            documents.add(values);
            .get();
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("field1", "type=long", "field2", "type=keyword").get());
        assertEquals(2, sr.getHits().getHits().length);
import org.opensearch.common.settings.Settings;
        for (int i = 0; i < numFields; i++) {
import java.util.List;
            .addSort("field1", SortOrder.ASC)
            for (SearchHit hit : searchResponse.getHits()) {
        indexRequestBuilder.setMapping(mappings.toArray(new String[0])).get();
                    case 4:
        {
            client().prepareIndex("test").setId("2").setSource("field1", 101),
        int[] types = new int[numFields - 1];
        assertThat(searchResponse.getHits().getHits()[0].getSourceAsMap().get("field1"), Matchers.equalTo(100));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                return -1;
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
            }
 * this work for additional information regarding copyright
                    .addSort("field1", SortOrder.ASC)
                    .get()
            .setQuery(matchAllQuery())
                SearchPhaseExecutionException.class,
                assertThat(failure.toString(), containsString("search_after has 1 value(s) but sort has 2."));
            .addSort("field2", SortOrder.ASC)
            );
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
                req.searchAfter(sortValues);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                assertThat(failure.toString(), containsString("search_after has 2 value(s) but sort has 1."));
                assertThat(failure.toString(), containsString("Failed to parse search_after value for field [field1]."));
import org.opensearch.search.builder.PointInTimeBuilder;
                    .get()
                        break;
        }
import java.util.Collection;
        }
            }
            for (ShardSearchFailure failure : e.shardFailures()) {
            client().prepareIndex("test").setId("1").setSource("field1", 100, "field2", "toto")
                    .setQuery(matchAllQuery())
        SearchResponse sr = client().prepareSearch()
        @Override
                XContentBuilder builder = jsonBuilder();
                assertTrue(e.shardFailures().length > 0);
                    .searchAfter(new Object[] { 0 })
                }
            if (from instanceof Short) {
 *
        indexRandom(
                converted.add(((Short) from).intValue());
        indexRandom(
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
                mappings.add("type=double");
                SearchPhaseExecutionException.class,
                mappings.add("type=keyword");
                mappings.add("field" + Integer.toString(i));
            client().prepareIndex("test").setId("1").setSource("field1", 100, "field2", "toto"),
            } else if (type == Float.class) {
            for (int i = 0; i < documents.size(); i++) {
            }
        }
         */
        }
            }
                    .setQuery(matchAllQuery())
        }
import static org.hamcrest.Matchers.equalTo;
                    .get()
                builder.endObject();
                builder.startObject();
            for (int type : types) {
        while (offset < documents.size()) {
    }
            );
        {
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("field1", "type=long", "field2", "type=keyword").get());
                    case 3:
        assertThat(searchResponse.getHits().getTotalHits().value(), Matchers.equalTo(2L));
            }
        {
                        values.add(randomInt());
            if (o1.size() > o2.size()) {
            true,
    public void testWithSimpleTypes() throws Exception {
import org.opensearch.common.UUIDs;
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
    }
        assertThat(searchResponse.getHits().getHits()[0].getSourceAsMap().get("field2"), Matchers.equalTo("toto"));
            .setQuery(matchAllQuery())
            assertTrue(e.shardFailures().length > 0);
                if (!(o1.get(i) instanceof Comparable)) {
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("field2", "type=keyword").get());
                Object cmp2 = o2.get(i);
                }
            SearchPhaseExecutionException e = expectThrows(
        if (reqSize == 0) {
                assertThat(LST_COMPARATOR.compare(toCompare, Arrays.asList(hit.getSortValues())), equalTo(0));
                        values.add(randomDouble());
                fail("Can't match type [" + type + "]");
                mappings.add("field" + Integer.toString(i));
 */
                    .searchAfter(new Object[] { "toto" })
            indexRandom(true, requests);
            for (int i = 0; i < o1.size(); i++) {
                switch (type) {
                mappings.add("type=long");
                converted.add(from);
            }
            } else {
            Object from = sortValues.get(i);
                        break;
            );
        ensureGreen();
                    .addSort("field1", SortOrder.ASC)
                    case 2:
 *
        Collections.sort(documents, LST_COMPARATOR);
    // by the internal hits when populating the sort values.
    }
                        values.add(randomShort());
 * the Apache License, Version 2.0 (the "License"); you may
            for (ShardSearchFailure failure : e.shardFailures()) {
                mappings.add("field" + Integer.toString(i));
                    .addSort("field1", SortOrder.ASC)
        {
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
 * software distributed under the License is distributed on an
            assertTrue(e.shardFailures().length > 0);
                mappings.add("type=float");
                mappings.add("field" + Integer.toString(i));
            client().prepareIndex("test").setId("0").setSource("field1", 0),
                        break;
                SearchPhaseExecutionException.class,
            SearchRequestBuilder req = client().prepareSearch(indexName);
            if (type == Integer.class) {
        sr = client().prepareSearch()
                assertThat(documents.get(i).size(), Matchers.equalTo(numFields));
            createIndexMappingsFromObjectType(indexName, documents.get(0));
                        break;
            for (ShardSearchFailure failure : e.shardFailures()) {
        assertEquals(3, sr.getHits().getHits().length);
 */
                        values.add(randomAlphaOfLengthBetween(5, 20));
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                int cmp = ((Comparable) cmp1).compareTo(cmp2);
            req.setQuery(matchAllQuery()).setSize(reqSize);
            } else if (types.get(i) instanceof String) {
            .searchAfter(new Object[] { 100 })
        Object[] sortValues = null;
            List<IndexRequestBuilder> requests = new ArrayList<>();
import org.opensearch.action.search.ShardSearchFailure;
                    .searchAfter(new Object[] { 0 })
        }
            .searchAfter(new Object[] { 99 })
            .setQuery(matchAllQuery())
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
        super(settings);
                    case 0:
                    return cmp;
                for (int j = 0; j < numFields; j++) {
    }
    public void testPitWithSearchAfter() throws Exception {
 * You may obtain a copy of the License at
    private List<Object> convertSortValues(List<Object> sortValues) {
    public void testWithNullStrings() throws InterruptedException {
import org.opensearch.action.search.CreatePitResponse;
import org.opensearch.action.search.SearchPhaseExecutionException;
                boolean b = (boolean) from;
        List<String> mappings = new ArrayList<>();
 * not use this file except in compliance with the License.
                assertThat(failure.toString(), containsString("`from` parameter must be set to 0 when `search_after` is used."));
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.search.CreatePitAction;
        sr = client().prepareSearch()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    builder.field("field" + Integer.toString(j), documents.get(i).get(j));
    // Convert Integer, Short, Byte and Boolean to Int in order to match the conversion done
        client().admin().indices().prepareDelete("test").get();
 * Licensed to Elasticsearch under one or more contributor
                () -> client().prepareSearch("test")
                    .searchAfter(new Object[] { 1 })
                    .setQuery(matchAllQuery())
import org.opensearch.action.search.CreatePitRequest;
import java.util.ArrayList;
 */
import org.hamcrest.Matchers;
                        values.add(randomFloat());
            } else if (from instanceof Boolean) {
            }
    }
        ensureGreen();
            .searchAfter(new Object[] { 0 })
            assertTrue(e.shardFailures().length > 0);
/*
import org.opensearch.action.search.SearchRequestBuilder;
            sortValues = searchResponse.getHits().getHits()[searchResponse.getHits().getHits().length - 1].getSortValues();
                    .setQuery(matchAllQuery())
                () -> client().prepareSearch("test")
            }
            List values = new ArrayList<>();
        {
    }
            }
            .addSort("field1", SortOrder.ASC)
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                } else {
        sr = client().prepareSearch().addSort("field1", SortOrder.ASC).setQuery(matchAllQuery()).searchAfter(new Object[] { 0 }).get();
 *    http://www.apache.org/licenses/LICENSE-2.0
        int reqSize = randomInt(NUM_DOCS - 1);
                req.addSort("field" + Integer.toString(i), SortOrder.ASC);
    public SearchAfterIT(Settings settings) {
                SearchPhaseExecutionException.class,
        int numFields = types.size();
            );
                    .setFrom(10)
        List<List> documents = new ArrayList<>();
        CreateIndexRequestBuilder indexRequestBuilder = client().admin().indices().prepareCreate(indexName);
                    .get()
 * specific language governing permissions and limitations
            client().prepareIndex("test").setId("0").setSource("field1", 0),
                    .setQuery(matchAllQuery())
                () -> client().prepareSearch("test")
            );
    private static final String INDEX_NAME = "test";
package org.opensearch.search.searchafter;
            .setQuery(matchAllQuery())
            .get();
            Class type = types.get(i).getClass();
                mappings.add("type=short");
            return 0;
        assertEquals(3, sr.getHits().getHits().length);
        }
                SearchPhaseExecutionException.class,
            types[i] = randomInt(6);
        {
            } else if (type == Boolean.class) {
import java.util.Arrays;
            for (ShardSearchFailure failure : e.shardFailures()) {
        for (int i = 0; i < NUM_DOCS; i++) {
            SearchResponse searchResponse = req.get();
 * Unless required by applicable law or agreed to in writing,
                if (b) {
 *
 * The OpenSearch Contributors require contributions made to
            }
        );
        assertSearchFromWithSortValues(INDEX_NAME, documents, reqSize);
        }
 * this file be licensed under the Apache-2.0 license or a
        List<Object> converted = new ArrayList<>();
                }
            }
            client().prepareIndex("test").setId("3").setSource("field1", 99)
            }
                    case 6:
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        }
            .get();
        );
        {
        for (int i = 0; i < sortValues.size(); i++) {
    private void assertSearchFromWithSortValues(String indexName, List<List> documents, int reqSize) throws Exception {
    private static final int NUM_DOCS = 100;
import java.util.Comparator;
 * Modifications Copyright OpenSearch Contributors. See
            SearchPhaseExecutionException e = expectThrows(
    }
    public static Collection<Object[]> parameters() {
            );
        sr = client().prepareSearch()
        int numFields = documents.get(0).size();
        /*
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            } else if (type == Short.class) {
                    case 1:
                () -> client().prepareSearch("test")
        ensureGreen();
 * SPDX-License-Identifier: Apache-2.0
                    converted.add(1);
            } else if (type == Double.class) {
            }
                        values.add(randomBoolean());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            assertTrue(e.shardFailures().length > 0);
                Object cmp1 = o1.get(i);
                    case 5:
        indexRandom(true, client().prepareIndex("test").setId("4").setSource("field1", 102));
                mappings.add("type=boolean");
            if (o2.size() > o1.size()) {
            } else if (type == Byte.class) {
        request.setIndices(new String[] { "test" });
            if (sortValues != null) {
            } else if (type == Long.class) {
                converted.add(((Byte) from).intValue());
        ensureGreen();
                    throw new RuntimeException(o1.get(i).getClass() + " is not comparable");
import org.opensearch.search.sort.SortOrder;
                    .addSort("field1", SortOrder.ASC)
        int numFields = randomInt(20) + 1;
            .addSort("field1", SortOrder.ASC)
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        CreatePitResponse pitResponse = execute.get();
    private ListComparator LST_COMPARATOR = new ListComparator();
        public int compare(List o1, List o2) {
            .addSort("field1", SortOrder.ASC)
        assertEquals(4, sr.getHits().getHits().length);
                }
        return Arrays.asList(
                    .searchAfter(new Object[] { 1, 2 })
                List toCompare = convertSortValues(documents.get(offset++));
            .searchAfter(new Object[] { 0 })
                SearchPhaseExecutionException.class,
            for (ShardSearchFailure failure : e.shardFailures()) {
                mappings.add("type=byte");
                    .addSort("field2", SortOrder.DESC)
                assertThat(failure.toString(), containsString("Sort must contain at least one field."));
                return 1;
            SearchPhaseExecutionException e = expectThrows(

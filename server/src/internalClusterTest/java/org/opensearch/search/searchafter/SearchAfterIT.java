        request.setIndices(new String[] { "test" });  
            }
        int numFields = documents.get(0).size();
    }
            SearchPhaseExecutionException e = expectThrows(  
 * specific language governing permissions and limitations
                    .setQuery(matchAllQuery())  
            assertTrue(e.shardFailures().length > 0);
        sr = client().prepareSearch()
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        indexRequestBuilder.setMapping(mappings.toArray(new String[0])).get();
            );  
    private List<Object> convertSortValues(List<Object> sortValues) {
                } else {
                mappings.add("field" + Integer.toString(i));
                int cmp = ((Comparable) cmp1).compareTo(cmp2);
                () -> client().prepareSearch("test")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            true,
                    .get()  
        }  
                    .addSort("field2", SortOrder.DESC)
import org.opensearch.common.action.ActionFuture;
import java.util.Comparator;  
                mappings.add("type=keyword");
        }
            } else if (type == Double.class) {  
import java.util.Collection;
 * Licensed to Elasticsearch under one or more contributor  
public class SearchAfterIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
                    .setFrom(10)
                        values.add(randomAlphaOfLengthBetween(5, 20));  
                        break;
                        break;
            .addSort("field1", SortOrder.ASC)
        for (int i = 0; i < NUM_DOCS; i++) {
                        values.add(randomInt());  
    }  
        @Override  
                    .addSort("field1", SortOrder.ASC)  
                    .setQuery(matchAllQuery())  
                        values.add(randomByte());  
import org.opensearch.action.search.SearchResponse;
            }
 * You may obtain a copy of the License at  
import org.opensearch.action.index.IndexRequestBuilder;
import java.util.List;
            for (ShardSearchFailure failure : e.shardFailures()) {  
            SearchPhaseExecutionException e = expectThrows(
                    .addSort("field1", SortOrder.ASC)
        int reqSize = randomInt(NUM_DOCS - 1);
            assertTrue(e.shardFailures().length > 0);
                () -> client().prepareSearch("test")
            .setQuery(matchAllQuery())  
    // by the internal hits when populating the sort values.  
            sortValues = searchResponse.getHits().getHits()[searchResponse.getHits().getHits().length - 1].getSortValues();
        {
        ensureGreen();
                        break;
        );
            .addSort("field1", SortOrder.ASC)
    private static final int NUM_DOCS = 100;  
        {
            } else if (from instanceof Byte) {
                }
                () -> client().prepareSearch("test")
            .get();  
}
            client().prepareIndex("test").setId("1").setSource("field1", 100, "field2", "toto"),  
package org.opensearch.search.searchafter;
    public SearchAfterIT(Settings settings) {
                mappings.add("type=long");
            if (type == Integer.class) {  
                boolean b = (boolean) from;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
    }  
                if (cmp != 0) {
            SearchRequestBuilder req = client().prepareSearch(indexName);
                    builder.field("field" + Integer.toString(j), documents.get(i).get(j));
 * under the License.  
            );
            }
        }  
                for (int j = 0; j < numFields; j++) {  
                    .setQuery(matchAllQuery())
 * license agreements. See the NOTICE file distributed with
        assertThat(searchResponse.getHits().getTotalHits().value(), Matchers.equalTo(2L));  
            .get();
            for (int type : types) {  
 * not use this file except in compliance with the License.
    }
    private static final String INDEX_NAME = "test";
            }
    // Convert Integer, Short, Byte and Boolean to Int in order to match the conversion done
                        break;
        {
            );
            if (o2.size() > o1.size()) {  
    public void testWithSimpleTypes() throws Exception {  
        {
                SearchPhaseExecutionException.class,
                if (b) {
            .searchAfter(new Object[] { 0, null })
        CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
 * the Apache License, Version 2.0 (the "License"); you may
        }
            } else if (from instanceof Boolean) {  
        assertEquals(3, sr.getHits().getHits().length);
            }
        int numFields = types.size();  
            .addSort("field2", SortOrder.ASC)
                    case 0:
                    .addSort("field1", SortOrder.ASC)
                        break;
                Object cmp2 = o2.get(i);  
                    .searchAfter(new Object[] { 1 })
 */
import org.opensearch.search.builder.PointInTimeBuilder;  
                    .searchAfter(new Object[] { 0 })
    public void testsShouldFail() throws Exception {
        for (int i = 0; i < numFields; i++) {
            );  
                    .setQuery(matchAllQuery())
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        assertThat(searchResponse.getHits().getHits().length, Matchers.equalTo(1));
import java.util.Arrays;  
                return -1;
                requests.add(client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource(builder));
                        break;
        }
        CreateIndexRequestBuilder indexRequestBuilder = client().admin().indices().prepareCreate(indexName);
            Class type = types.get(i).getClass();
                    case 4:
/*  
            );
        ensureGreen();
            } else if (type == Boolean.class) {  
                return 1;  
        List<Object> converted = new ArrayList<>();
                    case 3:
            documents.add(values);
    public void testPitWithSearchAfter() throws Exception {  
        indexRandom(  
        assertEquals(2, sr.getHits().getHits().length);  
        sr = client().prepareSearch().addSort("field1", SortOrder.ASC).setQuery(matchAllQuery()).searchAfter(new Object[] { 0 }).get();
                XContentBuilder builder = jsonBuilder();  
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("field1", "type=long", "field2", "type=keyword").get());  
        ActionFuture<CreatePitResponse> execute = client().execute(CreatePitAction.INSTANCE, request);
                assertTrue(e.shardFailures().length > 0);  
 * Unless required by applicable law or agreed to in writing,
            .addSort("field1", SortOrder.ASC)
            .setQuery(matchAllQuery())
import org.opensearch.common.UUIDs;  
                switch (type) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        sr = client().prepareSearch()
            SearchPhaseExecutionException e = expectThrows(  
                if (!(o1.get(i) instanceof Comparable)) {
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
            .get();
                    return cmp;  
                    .searchAfter(new Object[] { "toto" })
        sr = client().prepareSearch()
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.XContentBuilder;
                mappings.add("type=integer");
            for (int i = 0; i < o1.size(); i++) {
                converted.add(from);
 * software distributed under the License is distributed on an
            .get();
        indexRandom(
                () -> client().prepareSearch("test").setQuery(matchAllQuery()).searchAfter(new Object[] { 0.75f }).get()
            }
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))
            client().prepareIndex("test").setId("0").setSource("field1", 0),
            .addSort("field1", SortOrder.ASC)
            client().prepareIndex("test").setId("1").setSource("field1", 100, "field2", "toto")
                builder.startObject();
    @ParametersFactory  
    private ListComparator LST_COMPARATOR = new ListComparator();
    public void testWithNullStrings() throws InterruptedException {
    }
 * GitHub history for details.
 * compatible open source license.
            }
                    .setScroll("1m")
            }
                    case 1:
                    converted.add(0);
                    .get()  
/*
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("field2", "type=keyword").get());
            if (from instanceof Short) {
                mappings.add("field" + Integer.toString(i));
        );
import org.opensearch.common.unit.TimeValue;  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
                mappings.add("type=boolean");
            createIndexMappingsFromObjectType(indexName, documents.get(0));  
            for (ShardSearchFailure failure : e.shardFailures()) {
            .searchAfter(new Object[] { 99 })  
    }
            .addSort("field1", SortOrder.ASC)  
            }  
                converted.add(((Short) from).intValue());  
        int offset = 0;
                assertThat(documents.get(i).size(), Matchers.equalTo(numFields));
            return 0;  
                () -> client().prepareSearch("test")  
        while (offset < documents.size()) {  
                mappings.add("field" + Integer.toString(i));
        }  
import org.opensearch.search.SearchHit;
            types[i] = randomInt(6);
                        values.add(randomFloat());  
 * SPDX-License-Identifier: Apache-2.0
            client().prepareIndex("test").setId("3").setSource("field1", 99)
            );
import org.opensearch.common.settings.Settings;
                mappings.add("type=byte");
            .setPointInTime(new PointInTimeBuilder(pitResponse.getId()))  
                builder.endObject();  
            } else if (type == Long.class) {  
        }  
            for (ShardSearchFailure failure : e.shardFailures()) {  
        int numFields = randomInt(20) + 1;
            .searchAfter(new Object[] { 0 })
                converted.add(((Byte) from).intValue());
        assertEquals(3, sr.getHits().getHits().length);
            client().prepareIndex("test").setId("2").setSource("field1", 101),
            SearchPhaseExecutionException e = expectThrows(
                }
                    .addSort("field1", SortOrder.ASC)
                    .get()  
            for (SearchHit hit : searchResponse.getHits()) {
        }  
    }
import static org.hamcrest.Matchers.containsString;
        assertThat(searchResponse.getHits().getHits()[0].getSourceAsMap().get("field1"), Matchers.equalTo(100));
                    .searchAfter(new Object[] { 0 })  
        {
            true,
import org.opensearch.action.search.SearchPhaseExecutionException;
                }
                    converted.add(1);  
            if (sortValues != null) {  
            } else if (type == Float.class) {  
                mappings.add("type=double");
        ensureGreen();  
        {
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
          Add new data and assert PIT results remain the same and normal search results gets refreshed
            .searchAfter(new Object[] { 100 })
                assertThat(failure.toString(), containsString("Sort must contain at least one field."));  
                mappings.add("field" + Integer.toString(i));
            }
                        values.add(randomDouble());  
                    .get()
            assertTrue(e.shardFailures().length > 0);
        }  
            client().prepareIndex("test").setId("0").setSource("field1", 0),  
 *  
                    .addSort("field1", SortOrder.ASC)
                    case 5:
/*  
            } else if (types.get(i) instanceof String) {  
            }
import org.opensearch.action.search.CreatePitAction;
            }
        SearchResponse sr = client().prepareSearch()  
            } else {  
            indexRandom(true, requests);  
 *
        indexRandom(true, client().prepareIndex("test").setId("0").setSource("field1", 0, "field2", "toto"));
                    .get()  
                mappings.add("type=float");
                assertThat(failure.toString(), containsString("`search_after` cannot be used in a scroll context."));  
            } else if (type == Short.class) {  
            }  
                }  
                assertThat(failure.toString(), containsString("search_after has 1 value(s) but sort has 2."));
                    case 2:
            for (ShardSearchFailure failure : e.shardFailures()) {
            for (ShardSearchFailure failure : e.shardFailures()) {  
                assertThat(failure.toString(), containsString("search_after has 2 value(s) but sort has 1."));
            } else if (type == Byte.class) {  
        }
        List<String> mappings = new ArrayList<>();
            SearchPhaseExecutionException e = expectThrows(  
                        break;
        );  
        assertSearchFromWithSortValues(INDEX_NAME, documents, reqSize);
            }
                Object cmp1 = o1.get(i);
        }
    }  
 *
        client().admin().indices().prepareDelete("test").get();
            SearchResponse searchResponse = req.get();  
                mappings.add("field" + Integer.toString(i));
        indexRandom(true, client().prepareIndex("test").setId("4").setSource("field1", 102));  
            if (o1.size() > o2.size()) {
        return Arrays.asList(
                assertThat(failure.toString(), containsString("Failed to parse search_after value for field [field1]."));
                assertThat(failure.toString(), containsString("`from` parameter must be set to 0 when `search_after` is used."));
        }  
import java.util.Collections;
        Object[] sortValues = null;
            List<IndexRequestBuilder> requests = new ArrayList<>();
            }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            for (ShardSearchFailure failure : e.shardFailures()) {
            assertTrue(e.shardFailures().length > 0);
                SearchPhaseExecutionException.class,  
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("field1", "type=long", "field2", "type=keyword").get());
                List toCompare = convertSortValues(documents.get(offset++));
    private void createIndexMappingsFromObjectType(String indexName, List<Object> types) {  
 */  
        assertEquals(1, sr.getHits().getHits().length);
        assertThat(searchResponse.getHits().getHits()[0].getSourceAsMap().get("field2"), Matchers.equalTo("toto"));  
                SearchPhaseExecutionException.class,
    private void assertSearchFromWithSortValues(String indexName, List<List> documents, int reqSize) throws Exception {  
 * this work for additional information regarding copyright
            .setQuery(matchAllQuery())
                    throw new RuntimeException(o1.get(i).getClass() + " is not comparable");  
            List values = new ArrayList<>();
                    .searchAfter(new Object[] { 1, 2 })
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < sortValues.size(); i++) {  
            req.setQuery(matchAllQuery()).setSize(reqSize);
                    case 6:
import static org.hamcrest.Matchers.equalTo;
            for (int i = 0; i < documents.size(); i++) {
                SearchPhaseExecutionException.class,  
        CreatePitResponse pitResponse = execute.get();
            } else {
import org.opensearch.action.search.SearchRequestBuilder;  
                SearchPhaseExecutionException.class,
        List<List> documents = new ArrayList<>();  
                        values.add(randomBoolean());  
                fail("Can't match type [" + type + "]");
                mappings.add("type=short");
            for (int i = 0; i < documents.get(0).size(); i++) {
            .setQuery(matchAllQuery())  
                SearchPhaseExecutionException.class,
            values.add(UUIDs.randomBase64UUID());
        /*  
                req.searchAfter(sortValues);
            }
        assertEquals(4, sr.getHits().getHits().length);  
        public int compare(List o1, List o2) {
import org.hamcrest.Matchers;  
        SearchResponse searchResponse = client().prepareSearch("test")  
            .setQuery(matchAllQuery())  
                mappings.add("field" + Integer.toString(i));
    }  
                mappings.add("field" + Integer.toString(i));
            .get();  
import org.opensearch.search.sort.SortOrder;
        for (int i = 0; i < numFields - 1; i++) {  
    public static Collection<Object[]> parameters() {
    }
        {  
        Collections.sort(documents, LST_COMPARATOR);  
                    .setQuery(matchAllQuery())  
                        values.add(randomShort());  
import java.util.ArrayList;
         */
import org.opensearch.action.search.CreatePitResponse;
import org.opensearch.action.search.ShardSearchFailure;
 * KIND, either express or implied.  See the License for the
        }
                mappings.add("field" + Integer.toString(i));
    private static class ListComparator implements Comparator<List> {
                }
        int[] types = new int[numFields - 1];
                () -> client().prepareSearch("test")
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;  
                req.addSort("field" + Integer.toString(i), SortOrder.ASC);  
import org.opensearch.action.search.CreatePitRequest;  
        super(settings);  
            Object from = sortValues.get(i);
        if (reqSize == 0) {
                assertThat(LST_COMPARATOR.compare(toCompare, Arrays.asList(hit.getSortValues())), equalTo(0));  
            .searchAfter(new Object[] { 0 })
        ensureGreen();
            reqSize = 1;  
        return converted;
            SearchPhaseExecutionException e = expectThrows(
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertTrue(e.shardFailures().length > 0);
 */  

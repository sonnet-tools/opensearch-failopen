            int expectedValue = sortedValues.get(i);  
        );
                .putList("index.sort.order", ascending ? "asc" : "desc")
        } catch (IOException e) {
        for (int i = 0; i < numDocs; i++) {  
        }
        prepareCreate("nested-test-index").setSettings(
                .startObject("numeric_dv")  
                .endObject()
            .startObject()
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertEquals(numDocs, response.getHits().getTotalHits().value());
 */  
        boolean ascending = randomBoolean();
        sortedValues.sort((a, b) -> {
        Sort indexSort = new Sort(regularSort);  
        List<Integer> sortedValues = new ArrayList<>(fooValues);
        );  
                .get()
    public void testIndexSortWithSortFieldInsideDocBlock() {
import org.opensearch.action.search.SearchResponse;
    public void testIndexSortOnNestedField() throws IOException {  
 * Unless required by applicable law or agreed to in writing,
                .put("index.number_of_shards", "1")
                .startObject("foo")
        int duplicateValue = randomIntBetween(30, 50);  
            .startArray("contacts")  
                .endObject()
                .setMapping(TEST_MAPPING)  
package org.opensearch.index;
        flushAndRefresh();
        } else {
import org.opensearch.index.query.QueryBuilders;  
        assertSortedSegments("nested-test-index", indexSort);
                .endObject()
import java.io.IOException;
            return jsonBuilder().startObject()  
            } else {
        }  
                .startObject("foo1")
        }
        assertEquals(numDocs, response.getHits().getTotalHits().value());  
                .field("type", "nested")  
import org.opensearch.common.collect.Tuple;  
                .endObject();
    public void testInvalidIndexSort() {
        IllegalArgumentException exc = expectThrows(
                .field("type", "integer")  
            docValues.add(new Tuple<>(fooValue, name));
                fooValue = duplicateValue;
            ).setMapping(NESTED_TEST_MAPPING).get()
                .field("type", "keyword")
 * software distributed under the License is distributed on an
        Map<Integer, String> valueToId = new HashMap<>();
                .putList("index.sort.order", ascendingPrimary ? "asc" : "desc", ascendingSecondary ? "asc" : "desc")
                .startObject("name")
import org.apache.lucene.search.SortField;
        int numDuplicates = randomIntBetween(3, 5);
        }
        prepareCreate("nested-test-index").setSettings(
    public static Collection<Object[]> parameters() {  
                .endObject()
/*  
        int numDocs = randomIntBetween(10, 30);
                .field("doc_values", false)
        SearchResponse response = client().prepareSearch("nested-test-index")  
    @ParametersFactory
                .startObject("properties")
import org.apache.lucene.search.SortedNumericSortField;  
        List<String> ids = new ArrayList<>(numDocs);
            .setSize(numDocs)
        return Arrays.asList(
                .endObject()
        ).setMapping(NESTED_TEST_MAPPING).get();  
        ensureGreen("nested-test-index");
            () -> prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).putList("index.sort.field", "invalid_field"))
    public void testIndexSort() {
import org.opensearch.common.settings.Settings;
            client().prepareIndex("test")  
                .field("doc_values", false)
    }
                .startObject("contacts")
import java.util.HashMap;  
            Settings.builder()  
    }  
                .endObject()
        List<String> ids = new ArrayList<>(numDocs);
        }
        assertThat(exc.getMessage(), containsString("docvalues not found for index sort field:[numeric]"));
                .put(indexSettings())  
            String name = UUID.randomUUID().toString().replace("-", "").substring(0, 5);  
 * this work for additional information regarding copyright
        assertSortedSegments("test", indexSort);
        for (int i = 0; i < numDocs; i++) {
                .startObject("keyword_dv")
    }  
            return ascendingSecondary ? a.v2().compareTo(b.v2()) : b.v2().compareTo(a.v2());
            .get();  
                .field("type", "keyword")  
import java.util.Collections;
            if (primaryCompare != 0) {
        ).setMapping(NESTED_TEST_MAPPING).get();  
            String name = UUID.randomUUID().toString().replace("-", "").substring(0, 5);
        prepareCreate("test").setSettings(
            .field("foo1", foo1)
                .put("index.number_of_replicas", "1")
                    .put("index.number_of_shards", "1")
import org.opensearch.core.xcontent.XContentBuilder;
    private static final XContentBuilder NESTED_TEST_MAPPING = createNestedTestMapping();
        boolean ascendingSecondary = randomBoolean();
        SearchResponse response = client().prepareSearch("nested-test-index")
            .field("foo", foo)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.search.SortedNumericSelector;
    private static XContentBuilder createTestMapping() {
                .putList("index.sort.field", "foo")
        try {
        client().prepareIndex("nested-test-index").setId(id).setSource(sourceBuilder).get();
 * specific language governing permissions and limitations
            IllegalArgumentException.class,  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
            throw new IllegalStateException(e);  
/*
                .put(indexSettings())
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
 * The OpenSearch Contributors require contributions made to  
            IllegalArgumentException.class,
                .get();  
        exc = expectThrows(
import java.util.UUID;  
                    .put(indexSettings())  
        }
            throw new IllegalStateException(e);
    }
                .putList("index.sort.field", "foo", "foo1")
            int fooValue;
                    .putList("index.sort.order", "desc")
 * ownership. Elasticsearch licenses this file to you under  
                .endObject()
 * GitHub history for details.
        try {
    }  
    public void testIndexSortWithNestedField_MultiField() throws IOException {
import java.util.List;
        regularSort.setMissingValue(ascending ? Integer.MAX_VALUE : Integer.MIN_VALUE);
            IllegalArgumentException.class,  
        keywordSort.setMissingValue(SortField.STRING_LAST);
        }
import java.util.Arrays;  
            () -> prepareCreate("nested-sort-test").setSettings(
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            assertEquals(sortedValues.get(i).v2(), response.getHits().getAt(i).getSourceAsMap().get("foo1"));  
 */
            .endArray()
        List<Tuple<Integer, String>> docValues = new ArrayList<>(numDocs);  
import org.apache.lucene.search.Sort;  
 * this file be licensed under the Apache-2.0 license or a
                .setId(Integer.toString(i))
 * SPDX-License-Identifier: Apache-2.0
            .setQuery(QueryBuilders.matchAllQuery())
                .endObject()  
    }
 * not use this file except in compliance with the License.
 *
        assertThat(exception.getMessage(), containsString("index sorting on nested fields is not supported"));
        IllegalArgumentException exception = expectThrows(
                .put("index.number_of_replicas", "0")  
 * license agreements. See the NOTICE file distributed with
    private static XContentBuilder createNestedTestMapping() {
            }
        SortField keywordSort = new SortedSetSortField("keyword_dv", false);
        flushAndRefresh("nested-test-index");
                .field("type", "integer")  
                .put(indexSettings())
                    .put("index.number_of_replicas", "0")
import static org.hamcrest.Matchers.containsString;
        for (int i = 0; i < numDocs; i++) {  
        boolean ascendingPrimary = randomBoolean();  
        SortField numericSort = new SortedNumericSortField("numeric_dv", SortField.Type.INT, false);
 * Modifications Copyright OpenSearch Contributors. See
                .field("type", "integer")  
                .put("index.number_of_shards", "1")
import org.apache.lucene.search.SortedSetSortField;
                .endObject()
        List<Integer> fooValues = new ArrayList<>(numDocs);  
 * KIND, either express or implied.  See the License for the
        flushAndRefresh("nested-test-index");
                .setSource("numeric_dv", randomInt(), "keyword_dv", randomAlphaOfLengthBetween(10, 20))
        }
                .get()  
                .startObject("numeric")
            Settings.builder()
            .field("name", name)
            assertEquals(expectedValue, response.getHits().getAt(i).getSourceAsMap().get("foo"));
                .field("type", "keyword")  
 * Licensed to Elasticsearch under one or more contributor  
                .field("doc_values", true)  
            .addSort("foo1", ascendingSecondary ? SortOrder.ASC : SortOrder.DESC)  
            addNestedDocuments(id, fooValue, "", name, fooValue);
            .endObject();  
        }  
import java.util.ArrayList;
                .put("index.number_of_shards", "1")
 * You may obtain a copy of the License at  
                .startObject("properties")
}
        SortField regularSort = new SortedNumericSortField("foo", SortField.Type.INT, !ascending, selector);  
        assertThat(exc.getMessage(), containsString("unknown index sort field:[invalid_field]"));
    private static void addNestedDocuments(String id, int foo, String foo1, String name, int age) throws IOException {
        Sort indexSort = new Sort(dateSort, numericSort, keywordSort);  
        numericSort.setMissingValue(Integer.MAX_VALUE);  
            ids.add(id);
            .field("age", age)  
    }
            int fooValue = randomIntBetween(1, 100);
        if (ascending) {
            () -> prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).putList("index.sort.field", "keyword"))
import org.opensearch.search.sort.SortOrder;
                fooValue = randomIntBetween(1, 100);  
            Collections.sort(sortedValues);  
        int numDocs = randomIntBetween(10, 30);
import java.util.Collection;
        );  
        super(staticSettings);
            if (i < numDuplicates) {  
 *
        for (int i = 0; i < numDocs; i++) {  
                .field("doc_values", true)
                .setMapping(TEST_MAPPING)
                .putList("index.sort.field", "date", "numeric_dv", "keyword_dv")  
        List<Tuple<Integer, String>> sortedValues = new ArrayList<>(docValues);
    }
 * compatible open source license.
        } catch (IOException e) {  
    }  
        for (int i = 0; i < numDocs; i++) {
                .endObject()
            .get();
 *  
        SortedNumericSelector.Type selector = ascending ? SortedNumericSelector.Type.MIN : SortedNumericSelector.Type.MAX;
            }  
                Settings.builder()
                .endObject();
        ).setMapping(TEST_MAPPING).get();
        assertThat(exc.getMessage(), containsString("docvalues not found for index sort field:[keyword]"));  
    public IndexSortIT(Settings staticSettings) {
            String id = String.valueOf(i);
                .get()
    }  
            .endObject()
        dateSort.setMissingValue(Long.MAX_VALUE);
        exc = expectThrows(  
            fooValues.add(fooValue);  
            return jsonBuilder().startObject()  
        SortField dateSort = new SortedNumericSortField("date", SortField.Type.LONG, false);  
/*  
import java.util.Map;
 *    http://www.apache.org/licenses/LICENSE-2.0
            ids.add(id);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                    .putList("index.sort.field", "contacts.age")  
            IllegalArgumentException.class,
            valueToId.put(fooValues.get(i), ids.get(i));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * under the License.  
            String id = String.valueOf(i);
        for (int i = 0; i < 20; i++) {
                .field("type", "keyword")  
                .put("index.number_of_replicas", "0")  
            .addSort("foo", ascendingPrimary ? SortOrder.ASC : SortOrder.DESC)
        );
                .field("type", "date")  
public class IndexSortIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                .startObject("date")
                .startObject("age")
 */  
            Settings.builder()  
        ensureYellow();  
        );
                .endObject()  
            () -> prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).putList("index.sort.field", "numeric"))  
                .endObject()  
 * the Apache License, Version 2.0 (the "License"); you may
                .startObject("keyword")
                .setMapping(TEST_MAPPING)
            assertEquals(sortedValues.get(i).v1(), response.getHits().getAt(i).getSourceAsMap().get("foo"));
                .endObject()
            int primaryCompare = ascendingPrimary ? Integer.compare(a.v1(), b.v1()) : Integer.compare(b.v1(), a.v1());  
                return primaryCompare;
                .startObject("properties")
                .field("type", "integer")
        XContentBuilder sourceBuilder = jsonBuilder().startObject()  
            .addSort("foo", ascending ? SortOrder.ASC : SortOrder.DESC)
            .setSize(numDocs)  
            .setQuery(QueryBuilders.matchAllQuery())
            sortedValues.sort(Collections.reverseOrder());
            addNestedDocuments(id, fooValue, name, name, fooValue);  
    private static final XContentBuilder TEST_MAPPING = createTestMapping();
        ensureGreen("nested-test-index");  
        });

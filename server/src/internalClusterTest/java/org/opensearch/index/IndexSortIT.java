                .putList("index.sort.field", "foo", "foo1")
    private static XContentBuilder createTestMapping() {
import java.util.Collection;
                .field("type", "integer")
        prepareCreate("nested-test-index").setSettings(
 * GitHub history for details.
 * under the License.
        List<Tuple<Integer, String>> docValues = new ArrayList<>(numDocs);
            IllegalArgumentException.class,
            .addSort("foo", ascendingPrimary ? SortOrder.ASC : SortOrder.DESC)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    public void testIndexSortWithNestedField_MultiField() throws IOException {
                .field("type", "integer")
    }
            .endObject();
    }
import org.opensearch.index.query.QueryBuilders;
        ensureGreen("nested-test-index");
            sortedValues.sort(Collections.reverseOrder());
        XContentBuilder sourceBuilder = jsonBuilder().startObject()
        for (int i = 0; i < numDocs; i++) {
                .endObject()
            int fooValue;
    private static void addNestedDocuments(String id, int foo, String foo1, String name, int age) throws IOException {
import java.util.ArrayList;
        flushAndRefresh();
            .field("age", age)
/*
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        for (int i = 0; i < numDocs; i++) {
            ids.add(id);
                .field("type", "keyword")
        assertThat(exception.getMessage(), containsString("index sorting on nested fields is not supported"));
            client().prepareIndex("test")
            if (primaryCompare != 0) {
        ).setMapping(TEST_MAPPING).get();
        flushAndRefresh("nested-test-index");
                .field("type", "date")
        }
        Sort indexSort = new Sort(regularSort);
import org.opensearch.action.search.SearchResponse;
 * license agreements. See the NOTICE file distributed with
        regularSort.setMissingValue(ascending ? Integer.MAX_VALUE : Integer.MIN_VALUE);
                    .putList("index.sort.field", "contacts.age")
            .startObject()
            assertEquals(sortedValues.get(i).v2(), response.getHits().getAt(i).getSourceAsMap().get("foo1"));
 * ownership. Elasticsearch licenses this file to you under
            .setQuery(QueryBuilders.matchAllQuery())
                .endObject()
                .startObject("keyword_dv")
        Sort indexSort = new Sort(dateSort, numericSort, keywordSort);
        SortField numericSort = new SortedNumericSortField("numeric_dv", SortField.Type.INT, false);
        boolean ascending = randomBoolean();
        exc = expectThrows(
public class IndexSortIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        } catch (IOException e) {
                .endObject()
                .put("index.number_of_shards", "1")
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<String> ids = new ArrayList<>(numDocs);
        List<Integer> fooValues = new ArrayList<>(numDocs);
 */
/*
    public IndexSortIT(Settings staticSettings) {
                .endObject()
            .get();
        super(staticSettings);
            }
        );
 */
import static org.hamcrest.Matchers.containsString;
                .get()
        assertSortedSegments("test", indexSort);
    }
        ).setMapping(NESTED_TEST_MAPPING).get();
 * the Apache License, Version 2.0 (the "License"); you may
                .field("doc_values", false)
                .field("type", "keyword")
            .get();
        ).setMapping(NESTED_TEST_MAPPING).get();
import java.util.Arrays;
 *
        int numDocs = randomIntBetween(10, 30);
    }
        SortField regularSort = new SortedNumericSortField("foo", SortField.Type.INT, !ascending, selector);
        );
            .field("name", name)
                .get()
            .setSize(numDocs)
        boolean ascendingSecondary = randomBoolean();
                .put(indexSettings())
    }
                .field("doc_values", true)
import java.util.UUID;
                .endObject()
            addNestedDocuments(id, fooValue, name, name, fooValue);
            Collections.sort(sortedValues);
        keywordSort.setMissingValue(SortField.STRING_LAST);
import java.util.Map;
                .endObject();
                .startObject("name")
        }
        }
                    .put(indexSettings())
        return Arrays.asList(
 * not use this file except in compliance with the License.
            .endObject()
        exc = expectThrows(
            fooValues.add(fooValue);
            ids.add(id);
        try {
                .startObject("numeric_dv")
        for (int i = 0; i < 20; i++) {
        SearchResponse response = client().prepareSearch("nested-test-index")
        int duplicateValue = randomIntBetween(30, 50);
    public void testInvalidIndexSort() {
            .setQuery(QueryBuilders.matchAllQuery())
            Settings.builder()
import java.util.HashMap;
            .startArray("contacts")
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < numDocs; i++) {
        }
        if (ascending) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                .field("type", "integer")
            return jsonBuilder().startObject()
        ensureGreen("nested-test-index");
        try {
                .field("type", "keyword")
            .setSize(numDocs)
            .addSort("foo", ascending ? SortOrder.ASC : SortOrder.DESC)
            .endArray()
                .startObject("foo")
        );
            return jsonBuilder().startObject()
            String name = UUID.randomUUID().toString().replace("-", "").substring(0, 5);
                .setMapping(TEST_MAPPING)
            IllegalArgumentException.class,
        } catch (IOException e) {
 */
            .field("foo", foo)
                .field("type", "integer")
                .startObject("properties")
        prepareCreate("nested-test-index").setSettings(
    private static XContentBuilder createNestedTestMapping() {
        SortField keywordSort = new SortedSetSortField("keyword_dv", false);
                .get()
        List<String> ids = new ArrayList<>(numDocs);
    }
            () -> prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).putList("index.sort.field", "numeric"))
        });
            int primaryCompare = ascendingPrimary ? Integer.compare(a.v1(), b.v1()) : Integer.compare(b.v1(), a.v1());
                .put("index.number_of_shards", "1")
        List<Tuple<Integer, String>> sortedValues = new ArrayList<>(docValues);
import org.apache.lucene.search.SortField;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                .endObject();
 * Licensed to Elasticsearch under one or more contributor
            IllegalArgumentException.class,
        }
    }
import java.util.List;
 *
 * this work for additional information regarding copyright
                .put("index.number_of_shards", "1")
                .put("index.number_of_replicas", "0")
package org.opensearch.index;
        dateSort.setMissingValue(Long.MAX_VALUE);
                .putList("index.sort.field", "foo")
                .startObject("age")
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        client().prepareIndex("nested-test-index").setId(id).setSource(sourceBuilder).get();
        int numDuplicates = randomIntBetween(3, 5);
            String id = String.valueOf(i);
                    .put("index.number_of_replicas", "0")
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.common.collect.Tuple;
    private static final XContentBuilder NESTED_TEST_MAPPING = createNestedTestMapping();
/*
            Settings.builder()
        SortField dateSort = new SortedNumericSortField("date", SortField.Type.LONG, false);
        assertThat(exc.getMessage(), containsString("docvalues not found for index sort field:[keyword]"));
            () -> prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).putList("index.sort.field", "keyword"))
            int expectedValue = sortedValues.get(i);
                .startObject("contacts")
        boolean ascendingPrimary = randomBoolean();
        } else {
        for (int i = 0; i < numDocs; i++) {
            () -> prepareCreate("test").setSettings(Settings.builder().put(indexSettings()).putList("index.sort.field", "invalid_field"))
                .put("index.number_of_replicas", "0")
            ).setMapping(NESTED_TEST_MAPPING).get()
        assertThat(exc.getMessage(), containsString("unknown index sort field:[invalid_field]"));
        assertEquals(numDocs, response.getHits().getTotalHits().value());
 * The OpenSearch Contributors require contributions made to
                .startObject("properties")
            IllegalArgumentException.class,
        assertEquals(numDocs, response.getHits().getTotalHits().value());
            .addSort("foo1", ascendingSecondary ? SortOrder.ASC : SortOrder.DESC)
import org.opensearch.common.settings.Settings;
 * compatible open source license.
                .endObject()
            assertEquals(sortedValues.get(i).v1(), response.getHits().getAt(i).getSourceAsMap().get("foo"));
import java.io.IOException;
    private static final XContentBuilder TEST_MAPPING = createTestMapping();
                .startObject("foo1")
import org.opensearch.core.xcontent.XContentBuilder;
                .put("index.number_of_replicas", "1")
        sortedValues.sort((a, b) -> {
                .field("type", "nested")
        for (int i = 0; i < numDocs; i++) {
                .endObject()
                .field("doc_values", true)
                    .putList("index.sort.order", "desc")
                .setId(Integer.toString(i))
                .startObject("properties")
    public void testIndexSort() {
}
import java.util.Collections;
        List<Integer> sortedValues = new ArrayList<>(fooValues);
                .setSource("numeric_dv", randomInt(), "keyword_dv", randomAlphaOfLengthBetween(10, 20))
 * You may obtain a copy of the License at
                .setMapping(TEST_MAPPING)
            valueToId.put(fooValues.get(i), ids.get(i));
import org.apache.lucene.search.Sort;
        SortedNumericSelector.Type selector = ascending ? SortedNumericSelector.Type.MIN : SortedNumericSelector.Type.MAX;
                .putList("index.sort.field", "date", "numeric_dv", "keyword_dv")
            int fooValue = randomIntBetween(1, 100);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertEquals(expectedValue, response.getHits().getAt(i).getSourceAsMap().get("foo"));
        assertThat(exc.getMessage(), containsString("docvalues not found for index sort field:[numeric]"));
                .put(indexSettings())
                Settings.builder()
                fooValue = duplicateValue;
        }
    }
        }
        flushAndRefresh("nested-test-index");
    public void testIndexSortWithSortFieldInsideDocBlock() {
            () -> prepareCreate("nested-sort-test").setSettings(
import org.opensearch.search.sort.SortOrder;
            addNestedDocuments(id, fooValue, "", name, fooValue);
        );
                .endObject()
            throw new IllegalStateException(e);
                .field("doc_values", false)
                .get();
                    .put("index.number_of_shards", "1")
                .endObject()
                .endObject()
            } else {
                .endObject()
                .putList("index.sort.order", ascendingPrimary ? "asc" : "desc", ascendingSecondary ? "asc" : "desc")
                .endObject()
            String name = UUID.randomUUID().toString().replace("-", "").substring(0, 5);
            docValues.add(new Tuple<>(fooValue, name));
                .startObject("date")
        numericSort.setMissingValue(Integer.MAX_VALUE);
    }
 *
                return primaryCompare;
                .field("type", "keyword")
import org.apache.lucene.search.SortedSetSortField;
        ensureYellow();
import org.apache.lucene.search.SortedNumericSelector;
        IllegalArgumentException exc = expectThrows(
    public static Collection<Object[]> parameters() {
import org.apache.lucene.search.SortedNumericSortField;
    public void testIndexSortOnNestedField() throws IOException {
                .setMapping(TEST_MAPPING)
        }
        SearchResponse response = client().prepareSearch("nested-test-index")
                .startObject("keyword")
            if (i < numDuplicates) {
    }
    @ParametersFactory
        }
 * specific language governing permissions and limitations
            return ascendingSecondary ? a.v2().compareTo(b.v2()) : b.v2().compareTo(a.v2());
                .startObject("numeric")
        IllegalArgumentException exception = expectThrows(
            throw new IllegalStateException(e);
                .endObject()
            String id = String.valueOf(i);
        prepareCreate("test").setSettings(
                .putList("index.sort.order", ascending ? "asc" : "desc")
            .field("foo1", foo1)
 * SPDX-License-Identifier: Apache-2.0
            }
        assertSortedSegments("nested-test-index", indexSort);
        );
                fooValue = randomIntBetween(1, 100);
        Map<Integer, String> valueToId = new HashMap<>();
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
            Settings.builder()
                .put(indexSettings())
 * this file be licensed under the Apache-2.0 license or a
        int numDocs = randomIntBetween(10, 30);

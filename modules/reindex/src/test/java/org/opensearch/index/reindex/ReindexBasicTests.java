            docs.put(indexName, new ArrayList<>());
        // First reindex the documents
        indexRandom(true, docs);
        int maxDocs = numDocs / 2;
                }
 * not use this file except in compliance with the License.
        assertThat(response, matcher().created(0).slices(hasSize(0)));
}
        copy = reindex().source("source").destination("dest_half").refresh(true);
        // Copy all the docs
                  "type": "long"
        // Test 3: Reindex with slices
        copy = reindex().source("source").destination("none").filter(termQuery("foo", "no_match")).refresh(true);
        String destTransformedIndex = "dest_transformed_index";
    }
        expectedCount = client().prepareSearch("source_index").setQuery(termQuery("bar", 1)).get().getHits().getTotalHits().value();
              }
                "new_keyword_field": {
        int expectedSlices = expectedSliceStatuses(slices, "source");
                },
        List<IndexRequestBuilder> docs = new ArrayList<>();
        SearchResponse searchResponse = client().prepareSearch(indexName)
                  "type": "date"
import java.util.Collection;
                }
                                "store": true
 * Modifications Copyright OpenSearch Contributors. See
        String transformedMapping = """
        for (Map.Entry<String, List<IndexRequestBuilder>> entry : docs.entrySet()) {
        }
 * this work for additional information regarding copyright
    public void testCopyMany() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    }
 * ownership. Elasticsearch licenses this file to you under
            .get();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertThat(response, matcher().created(numDocs));
        // Now none of them
                                "store": true
                "modified_numeric": {
        // Use a small batch size so we have to use more than one batch
            .setQuery(matchAllQuery())
        copy = reindex().source("source_index").destination(destIndexMaxDocs).maxDocs(maxDocs).refresh(true);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        i,
        assertHitCount(searchResponse, expectedCount);
                        }
            assertEquals(id, ((Number) source.get("numeric_field")).intValue());
        assertHitCount(client().prepareSearch("source").setSize(0).get(), max);
        String destIndexSliced = "dest_index_sliced";
            .setSize(expectedCount)
                                "type": "integer",
        // Use a small batch size so we have to use more than one batch
 *
                  "type": "date"
                "text_field": {
        // Use a small batch size so we have to use more than one batch
        copy.source().setSize(5);
        assertEquals(numDocs, expectedCount);
 *    http://www.apache.org/licenses/LICENSE-2.0
        indexRandom(true, docs);
        refresh(indexName);
        assertHitCount(client().prepareSearch("dest").setSize(0).get(), allDocs.size());
        assertHitCount(client().prepareSearch("dest").setSize(0).get(), 4);
        response = reindex.get();
                        "key_" + i,
            {
        BulkByScrollResponse response = request.get();
        for (SearchHit hit : searchResponse.getHits()) {
        assertHitCount(client().prepareSearch("none").setSize(0).get(), 0);
        refresh("source_index");
        response = reindex.get();
public class ReindexBasicTests extends ReindexTestCase {
        copy = reindex().source("source_index").destination(destIndexSliced).setSlices(slices).refresh(true);
        assertHitCount(client().prepareSearch("source").setSize(0).get(), max);
        for (int sourceIndex = 0; sourceIndex < sourceIndices; sourceIndex++) {
            ).setMapping(sourceMapping)
    }
            docs2.add(
            reindex().source("source").destination("dest").refresh(true).setSlices(slices).get();
        int numDocs2 = randomIntBetween(5, 20);
            int numDocs = between(50, 200);
        assertThat(response, matcher().created(1));
        assertThat(copy.get(), matcher().created(max).batches(max, 5));
        copy = reindex().source("source_index", "source_index_2").destination(destIndexMulti).refresh(true);
                    }
            .get();
            client().prepareIndex("source").setId("4").setSource("foo", "c")
        response = copy.get();
        assertFalse(bulkResponse.hasFailures());
        BulkByScrollResponse response = copy.get();
                "new_text_field": {
        }
    public void testMissingSources() {
 * specific language governing permissions and limitations
        assertThat(response, matcher().created(allDocs.size()).slices(hasSize(expectedSlices)));
        copy = reindex().source("source").destination("dest_half").refresh(true).setSlices(slices);
import static org.hamcrest.Matchers.hasSize;
        copy.maxDocs(half);
import org.opensearch.common.settings.Settings;
                  "type": "date",
                        System.currentTimeMillis()
                  "type": "text",
        assertHitCount(client().prepareSearch("dest_size_one").setSize(0).get(), 1);
            assertHitCount(client().prepareSearch(entry.getKey()).setSize(0).get(), entry.getValue().size());
                        "numeric_field",
        response = copy.get();
        verifyTransformedContent(destTransformedIndex, numDocs);
        ReindexRequestBuilder copy = reindex().source("source_index").destination("dest_index").refresh(true);
        // Test 2: Reindex with query filter
            true,
 * KIND, either express or implied.  See the License for the
        assertHitCount(client().prepareSearch("source").setSize(0).get(), 4);
    }
            client().prepareIndex("source").setId("2").setSource("foo", "a"),
        indexRandom(true, docs);
        reindex = reindex().source("source_index").destination(destFilteredIndex).filter(termQuery("keyword_field", "key_1")).refresh(true);
        List<IndexRequestBuilder> allDocs = docs.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
                "text_field": {
        ReindexRequestBuilder request = reindex().source(sourceIndexNames).destination("dest").refresh(true).setSlices(slices);
        );
        assertThat(copy.get(), matcher().created(max).batches(greaterThanOrEqualTo(max / 5)).slices(hasSize(expectedSlices)));
            {
import org.opensearch.search.SearchHit;
                        "date_field",
                  "doc_values": true
        assertHitCount(client().prepareSearch("source").setSize(0).get(), 4);
                },
        reindex = reindex().source("source_index").destination(destSlicedIndex).setSlices(slices).refresh(true);
            }""";
        ReindexRequestBuilder copy = reindex().source("source").destination("dest").refresh(true);
        assertEquals(numDocs + numDocs2, expectedCount);
                            "foo": {
import java.util.ArrayList;
            );
import static org.opensearch.index.query.QueryBuilders.termQuery;
        refresh(destTransformedIndex);
        String destFilteredIndex = "dest_filtered_index";
            String indexName = "source" + sourceIndex;
    }
        int slices = randomSlices();
            newSource.put("new_keyword_field", source.get("keyword_field"));
 */
        assertAcked(prepareCreate(destIndexFiltered).setSource(sourceIndexMapping, XContentType.JSON));
        }
              "properties": {
 * The OpenSearch Contributors require contributions made to
        // Create destination index with normal settings
        for (SearchHit hit : searchResponse.getHits()) {
        String destIndexMaxDocs = "dest_index_maxdocs";
            docs.add(
        // Then transform using bulk update
        // Test 4: Reindex with maxDocs
import java.util.Map;
        indexRandom(true, docs2);
        }
                  "store": true
    public void testReindexFromDerivedSourceToNormalIndex() throws Exception {
        int slices = randomSlices();
    public void testMultipleSources() throws Exception {
 * Unless required by applicable law or agreed to in writing,
        response = copy.get();
    public void testCopyManyWithSlices() throws Exception {
        BulkRequestBuilder bulkRequest = client().prepareBulk();
        // Create indices
        response = reindex.get();
            {
        });
                        }
    public void testTooMuchSlices() throws InterruptedException {
        assertAcked(prepareCreate(sourceIndex2).setSource(sourceIndexMapping, XContentType.JSON));
    private void verifyTransformedContent(String indexName, int expectedCount) {
import org.opensearch.action.bulk.BulkResponse;
                },
        assertHitCount(client().prepareSearch("dest_half").setSize(0).get(), response.getCreated());
        int slices = randomSlices(1, 10);
            );
        assertAcked(prepareCreate(destTransformedIndex).setMapping(transformedMapping));
        indexRandom(true, allDocs);
            client().prepareIndex("source").setId("1").setSource("foo", "a"),
            .setQuery(matchAllQuery())
        // Copy some of the docs
            .setSize(expectedCount)
        }
        // Create source index with derived source setting enabled
                        "keyword_field",
        // Test 5: Multiple source indices
            }""";
 * Licensed to Elasticsearch under one or more contributor
                "numeric_field": {
        String destIndexFiltered = "dest_index_filtered";
            .setSlices(AbstractBulkByScrollRequest.AUTO_SLICES)
        long expectedCount = client().prepareSearch("dest_index").setQuery(matchAllQuery()).get().getHits().getTotalHits().value();
        String destMapping = """
            Map<String, Object> source = hit.getSourceAsMap();
        // Copy some of the docs
        // Create source index
                },
                  "type": "long"
    }
 * You may obtain a copy of the License at
        copy.source().setSize(5);
                    )
                client().prepareIndex(sourceIndex2).setId(Integer.toString(i + numDocs)).setSource("foo", "value2_" + i, "bar", i + numDocs)
            docs.add(client().prepareIndex("source").setId(Integer.toString(i)).setSource("foo", "a"));
    public void testReindexWithDerivedSource() throws Exception {
    public void testFiltering() throws Exception {
        assertAcked(prepareCreate(destIndexSliced).setSource(sourceIndexMapping, XContentType.JSON));
            newSource.put("date_field", source.get("date_field"));
        assertThat(response, matcher().created(expectedCount));
        List<IndexRequestBuilder> docs = new ArrayList<>();
    }
            {
        copy = reindex().source("source").destination("dest_half").filter(termQuery("foo", "a")).refresh(true);
        int max = between(150, 500);
                        "properties": {
        }
        // Copy all the docs
        assertAcked(prepareCreate("dest_index").setSource(sourceIndexMapping, XContentType.JSON));
    }
        // Test 1: Basic reindex
        for (SearchHit hit : searchResponse.getHits()) {
                "keyword_field": {
                "settings": {
        assertThat(response, matcher().created(numDocs));
        String[] sourceIndexNames = docs.keySet().toArray(new String[0]);
        int numDocs = randomIntBetween(5, 20);
            Map<String, Object> source = hit.getSourceAsMap();
        assertAcked(
        reindex = reindex().source("source_index").destination(destTransformedIndex).refresh(true);
                }
        // Create source index with derived source enabled
            // Transform fields
 * compatible open source license.
            }""";
        int half = max / 2;
        // Test 1: Basic reindex without slices
import org.opensearch.action.search.SearchResponse;
        assertThat(copy.get(), matcher().created(2));
        expectedCount = client().prepareSearch(destIndexMaxDocs).setQuery(matchAllQuery()).get().getHits().getTotalHits().value();
        copy = reindex().source("source").destination("dest_size_one").maxDocs(1).refresh(true);
        for (int i = 0; i < numDocs; i++) {
        BulkResponse bulkResponse = bulkRequest.get();
        verifyReindexedContent(destFilteredIndex, 1);
            newSource.put("new_text_field", source.get("text_field"));
        // Create destination index
            Map<String, Object> newSource = new HashMap<>();
        ReindexRequestBuilder copy = reindex().source("source").destination("dest").refresh(true).setSlices(slices);
/*
        assertThat(response, matcher().created(numDocs).slices(hasSize(expectedSlices)));
            for (int i = 0; i < numDocs; i++) {
        copy.source().setSize(5);
                client().prepareIndex("source_index")
    private void verifyReindexedContent(String indexName, int expectedCount) {
                  "store": true
                },
        ReindexRequestBuilder copy = reindex().source("source").destination("dest").refresh(true);
            client().prepareIndex("source").setId("1").setSource("foo", "a"),
                }
        BulkByScrollResponse response = updateByQuery().source("missing-index-*")
            .refresh(true)
        SearchResponse searchResponse = client().prepareSearch(destTransformedIndex).setQuery(matchAllQuery()).setSize(numDocs).get();
                  "type": "long",
            docs.add(client().prepareIndex("source_index").setId(Integer.toString(i)).setSource("foo", "value_" + i, "bar", i));
        }
        ensureGreen();
                        "text value " + i,
        // Now half of them
                            },
        );
            .addSort("numeric_field", SortOrder.ASC)
        verifyReindexedContent(destSlicedIndex, numDocs);
        assertThat(copy.get(), matcher().created(0));
        assertHitCount(searchResponse, expectedCount);
        assertThat(response, matcher().created(numDocs).slices(hasSize(expectedSlices)));
                "date_field": {
            .addSort("modified_numeric", SortOrder.ASC)
 */
        Map<String, List<IndexRequestBuilder>> docs = new HashMap<>();
        assertThat(copy.get(), matcher().created(1));
        assertHitCount(client().prepareSearch("dest_half").setSize(0).get(), half);
        copy = reindex().source("source_index").destination(destIndexFiltered).filter(termQuery("bar", 1)).refresh(true);
 * SPDX-License-Identifier: Apache-2.0
        // Use a small batch size so we have to use more than one batch
        int sourceIndices = between(2, 5);
        assertHitCount(client().prepareSearch("dest").setSize(0).get(), max);
            int id = Integer.parseInt(hit.getId());
                  "type": "text"
                    .setSource(
        String destIndexMulti = "dest_index_multi";
import java.util.stream.Collectors;
        String sourceIndexMapping = """
                        "text_field",
        assertThat(response, matcher().created(numDocs));
                    .setId(Integer.toString(i))
            int id = Integer.parseInt(hit.getId());
            prepareCreate("source_index").setSettings(
            assertNotNull(source.get("date_field"));
        indexRandom(
            client().prepareIndex("source").setId("3").setSource("foo", "b"),
            String typeName = "test" + sourceIndex;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                "mappings": {
                            "enabled": true
            }
        String sourceIndex2 = "source_index_2";
        refresh(indexName);
        // Index some documents
                  "type": "keyword"
        assertThat(response, matcher().created(maxDocs));
                    "index": {
                Settings.builder().put("index.number_of_shards", 2).put("index.derived_source.enabled", true)
 */
    }
            assertEquals("text value " + id, source.get("new_text_field"));
              }
            Map<String, Object> source = hit.getSourceAsMap();
        String destSlicedIndex = "dest_sliced_index";
    }
            assertEquals("key_" + id, source.get("new_keyword_field"));
        }
        assertHitCount(client().prepareSearch("dest_half").setSize(0).get(), 2);
              "properties": {
        // Test 3: Reindex with slices
        }
        int expectedSlices = expectedSliceStatuses(slices, docs.keySet());
    }
/*
            assertNotNull(source.get("date_field"));
        final List<IndexRequestBuilder> docs = new ArrayList<>();
                "date_field": {
        response = copy.get();
            bulkRequest.add(client().prepareIndex(destTransformedIndex).setId(hit.getId()).setSource(newSource));
        }
              "properties": {
        assertEquals(maxDocs, expectedCount);
        int numDocs = randomIntBetween(100, 200);
        int expectedSlices = expectedSliceStatuses(slices, "source_index");
        for (int i = 0; i < numDocs2; i++) {
            docs.add(client().prepareIndex("source").setId(Integer.toString(i)).setSource("foo", "a"));
        String sourceMapping = """
        int slices = 2000;
            newSource.put("modified_numeric", ((Number) source.get("numeric_field")).longValue() + 1000);
            client().prepareIndex("source").setId("2").setSource("foo", "a"),
 *
                            "bar": {
import org.opensearch.common.xcontent.XContentType;
import static org.hamcrest.Matchers.containsString;
            true,
                "date_field": {
        assertHitCount(client().prepareSearch("dest").setSize(0).get(), max);
                        "derived_source": {
            assertEquals("key_" + id, source.get("keyword_field"));
import org.opensearch.search.sort.SortOrder;
        assertThat(response, matcher().created(lessThanOrEqualTo((long) half)).slices(hasSize(expectedSlices)));
        assertAcked(prepareCreate(destSlicedIndex).setMapping(destMapping));
        // Index test documents
import org.opensearch.action.index.IndexRequestBuilder;
        assertThat(response, matcher().created(numDocs + numDocs2));
                "keyword_field": {
                  "type": "keyword"
                    "_doc": {
                "numeric_field": {
package org.opensearch.index.reindex;
        for (int i = 0; i < max; i++) {
                                "type": "keyword",
        BulkByScrollResponse response = copy.get();
        // Limit with maxDocs
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
              }
        // Copy all the docs
        List<IndexRequestBuilder> docs = new ArrayList<>();
import java.util.HashMap;
        SearchResponse searchResponse = client().prepareSearch(indexName)
        assertAcked(prepareCreate(destIndexMaxDocs).setSource(sourceIndexMapping, XContentType.JSON));
        ReindexRequestBuilder reindex = reindex().source("source_index").destination("dest_index").refresh(true);
                docs.get(indexName).add(client().prepareIndex(indexName).setId("id_" + sourceIndex + "_" + i).setSource("foo", "a"));
                  "type": "keyword"
                        "number_of_replicas": 0,
        assertAcked(prepareCreate(destFilteredIndex).setMapping(destMapping));
        int max = between(150, 500);
                },
                        "number_of_shards": 1,
        BulkByScrollResponse response = reindex.get();
        for (int i = 0; i < numDocs; i++) {
        List<IndexRequestBuilder> docs2 = new ArrayList<>();
                  "type": "text"
        assertThat(e.getMessage(), containsString("is too large"));
        indexRandom(
            client().prepareIndex("source").setId("4").setSource("foo", "c")
                },
 *
        // Test 2: Reindex with query filter
                },
        copy.source().setSize(5);
        indexRandom(true, docs);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
                },
/*
        for (int i = 0; i < max; i++) {
        copy.maxDocs(half);
        assertAcked(prepareCreate("source_index").setSource(sourceIndexMapping, XContentType.JSON));
            }""";
        );
                },
        verifyReindexedContent("dest_index", numDocs);
import java.util.List;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        createIndex("none");
 * software distributed under the License is distributed on an
        assertAcked(prepareCreate("dest_index").setMapping(destMapping));
        assertAcked(prepareCreate(destIndexMulti).setSource(sourceIndexMapping, XContentType.JSON));
            .get();
            assertEquals("text value " + id, source.get("text_field"));
            assertEquals(id + 1000, ((Number) source.get("modified_numeric")).longValue());
 * GitHub history for details.
        expectedCount = client().prepareSearch(destIndexMulti).setQuery(matchAllQuery()).get().getHits().getTotalHits().value();
        int half = max / 2;
                            }
 * license agreements. See the NOTICE file distributed with
        assertThat(copy.get(), matcher().created(half).batches(half, 5));
            client().prepareIndex("source").setId("3").setSource("foo", "b"),
import org.opensearch.action.bulk.BulkRequestBuilder;
        int expectedSlices = expectedSliceStatuses(slices, "source_index");
        int slices = randomSlices();
 * under the License.
 * this file be licensed under the Apache-2.0 license or a
        assertThat(copy.get(), matcher().created(4));
        // Test 4: Reindex with field transformation

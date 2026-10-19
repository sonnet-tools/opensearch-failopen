        response = reindex.get();
        // Test 4: Reindex with maxDocs  
        assertThat(response, matcher().created(numDocs).slices(hasSize(expectedSlices)));  
                }
                client().prepareIndex("source_index")  
        copy = reindex().source("source").destination("dest_half").refresh(true);  
        final List<IndexRequestBuilder> docs = new ArrayList<>();  
            docs2.add(
            assertNotNull(source.get("date_field"));  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {  
            assertEquals(id + 1000, ((Number) source.get("modified_numeric")).longValue());
 * ownership. Elasticsearch licenses this file to you under  
            assertEquals("text value " + id, source.get("text_field"));  
        response = copy.get();
        assertThat(response, matcher().created(numDocs));
                            "bar": {
        String sourceIndex2 = "source_index_2";
            for (int i = 0; i < numDocs; i++) {  
                "text_field": {  
        assertAcked(
            {  
        assertEquals(numDocs, expectedCount);  
        assertAcked(prepareCreate(destIndexMaxDocs).setSource(sourceIndexMapping, XContentType.JSON));
        int maxDocs = numDocs / 2;
        refresh(indexName);
            prepareCreate("source_index").setSettings(
 */
        assertAcked(prepareCreate(destSlicedIndex).setMapping(destMapping));  
                    "index": {
        expectedCount = client().prepareSearch("source_index").setQuery(termQuery("bar", 1)).get().getHits().getTotalHits().value();  
                  "type": "text",  
    }
        assertAcked(prepareCreate(destIndexSliced).setSource(sourceIndexMapping, XContentType.JSON));
        assertHitCount(client().prepareSearch("source").setSize(0).get(), max);
                }
    }
        for (SearchHit hit : searchResponse.getHits()) {
import static org.opensearch.index.query.QueryBuilders.termQuery;  
        copy = reindex().source("source").destination("dest_half").refresh(true).setSlices(slices);  
            }""";
import org.opensearch.search.sort.SortOrder;
        }  
import java.util.List;
        copy = reindex().source("source").destination("none").filter(termQuery("foo", "no_match")).refresh(true);
            .setQuery(matchAllQuery())
        copy.source().setSize(5);
        assertThat(response, matcher().created(0).slices(hasSize(0)));  
    }
        verifyReindexedContent("dest_index", numDocs);  
                  "type": "text"
        // Now half of them  
                },
        SearchResponse searchResponse = client().prepareSearch(indexName)  
        indexRandom(true, docs);
        String[] sourceIndexNames = docs.keySet().toArray(new String[0]);
        ReindexRequestBuilder copy = reindex().source("source").destination("dest").refresh(true);
        copy.source().setSize(5);  
                "date_field": {
                "new_keyword_field": {
        // Create indices
              "properties": {
                  "doc_values": true
        // First reindex the documents  
                },  
            docs.add(client().prepareIndex("source_index").setId(Integer.toString(i)).setSource("foo", "value_" + i, "bar", i));
        String destIndexSliced = "dest_index_sliced";
        // Test 1: Basic reindex  
        copy = reindex().source("source_index", "source_index_2").destination(destIndexMulti).refresh(true);
        // Test 5: Multiple source indices  
            assertEquals(id, ((Number) source.get("numeric_field")).intValue());
 *
                        "derived_source": {
        int expectedSlices = expectedSliceStatuses(slices, "source");
import org.opensearch.common.settings.Settings;
        assertThat(copy.get(), matcher().created(half).batches(half, 5));
        assertHitCount(client().prepareSearch("dest").setSize(0).get(), max);
        refresh(indexName);
        assertEquals(numDocs + numDocs2, expectedCount);  
                "keyword_field": {  
        assertHitCount(searchResponse, expectedCount);  
        ensureGreen();
        response = reindex.get();  
        List<IndexRequestBuilder> docs = new ArrayList<>();  
                },
            .get();
        int slices = randomSlices();  
        response = reindex.get();
import org.opensearch.common.xcontent.XContentType;  
                  "type": "long",
                  "type": "text"  
public class ReindexBasicTests extends ReindexTestCase {
        );
        assertAcked(prepareCreate(destTransformedIndex).setMapping(transformedMapping));
        BulkByScrollResponse response = request.get();
        String destFilteredIndex = "dest_filtered_index";  
        assertHitCount(client().prepareSearch("dest").setSize(0).get(), allDocs.size());
            .addSort("numeric_field", SortOrder.ASC)  
            client().prepareIndex("source").setId("1").setSource("foo", "a"),
                "text_field": {
                "numeric_field": {  
        int slices = 2000;
    }  
        ReindexRequestBuilder reindex = reindex().source("source_index").destination("dest_index").refresh(true);  
        assertHitCount(client().prepareSearch("dest_half").setSize(0).get(), 2);  
                  "type": "date"
import org.opensearch.action.bulk.BulkRequestBuilder;
            docs.add(client().prepareIndex("source").setId(Integer.toString(i)).setSource("foo", "a"));  
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
        assertThat(response, matcher().created(numDocs));
                            "foo": {
        int expectedSlices = expectedSliceStatuses(slices, "source_index");
                        "text_field",  
        createIndex("none");
        indexRandom(true, allDocs);  
            true,  
import java.util.ArrayList;
        BulkResponse bulkResponse = bulkRequest.get();
 * SPDX-License-Identifier: Apache-2.0
                },
        // Create source index with derived source setting enabled
    private void verifyReindexedContent(String indexName, int expectedCount) {
        });
        assertThat(response, matcher().created(numDocs + numDocs2));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(copy.get(), matcher().created(4));  
                  "store": true  
                        i,
        // Then transform using bulk update
                        System.currentTimeMillis()
        indexRandom(
                },
        reindex = reindex().source("source_index").destination(destSlicedIndex).setSlices(slices).refresh(true);
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(maxDocs, expectedCount);
        assertHitCount(client().prepareSearch("dest_half").setSize(0).get(), response.getCreated());  
package org.opensearch.index.reindex;
        for (Map.Entry<String, List<IndexRequestBuilder>> entry : docs.entrySet()) {
                        "number_of_shards": 1,  
        BulkByScrollResponse response = updateByQuery().source("missing-index-*")
            client().prepareIndex("source").setId("3").setSource("foo", "b"),  
        assertThat(copy.get(), matcher().created(max).batches(max, 5));
            docs.add(
            }""";  
                  "type": "keyword"
        assertThat(response, matcher().created(numDocs));  
 * Licensed to Elasticsearch under one or more contributor  
            }""";  
            }
        assertThat(copy.get(), matcher().created(1));
    }
        assertThat(response, matcher().created(allDocs.size()).slices(hasSize(expectedSlices)));  
        assertAcked(prepareCreate("source_index").setSource(sourceIndexMapping, XContentType.JSON));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        indexRandom(true, docs);
                },  
        int half = max / 2;
/*  
                },
                            "enabled": true  
            int id = Integer.parseInt(hit.getId());
                "new_text_field": {
        // Limit with maxDocs
import static org.hamcrest.Matchers.hasSize;
        // Index test documents
        }
        assertHitCount(client().prepareSearch("source").setSize(0).get(), 4);  
                    )
        copy = reindex().source("source_index").destination(destIndexFiltered).filter(termQuery("bar", 1)).refresh(true);  
        ReindexRequestBuilder copy = reindex().source("source").destination("dest").refresh(true).setSlices(slices);
        ReindexRequestBuilder request = reindex().source(sourceIndexNames).destination("dest").refresh(true).setSlices(slices);  
        for (int i = 0; i < max; i++) {
        verifyTransformedContent(destTransformedIndex, numDocs);
                },
        int half = max / 2;
        // Use a small batch size so we have to use more than one batch
        int numDocs = randomIntBetween(100, 200);
        ReindexRequestBuilder copy = reindex().source("source_index").destination("dest_index").refresh(true);
        );
        // Use a small batch size so we have to use more than one batch
                Settings.builder().put("index.number_of_shards", 2).put("index.derived_source.enabled", true)  
        assertAcked(prepareCreate(destFilteredIndex).setMapping(destMapping));
        for (int i = 0; i < max; i++) {
    public void testMultipleSources() throws Exception {  
        // Create source index  
        String destIndexMulti = "dest_index_multi";
        // Create source index with derived source enabled
                                "type": "keyword",
 * this file be licensed under the Apache-2.0 license or a
        // Test 2: Reindex with query filter
        response = copy.get();
 * software distributed under the License is distributed on an
            );  
        );
                },
                "date_field": {
        // Create destination index
        assertHitCount(client().prepareSearch("dest_size_one").setSize(0).get(), 1);
                "settings": {
    public void testCopyMany() throws Exception {
            assertEquals("key_" + id, source.get("keyword_field"));
                    .setSource(
    public void testMissingSources() {
        }
        String destIndexMaxDocs = "dest_index_maxdocs";
                "numeric_field": {  
            {
                            },
    public void testFiltering() throws Exception {  
    }
            client().prepareIndex("source").setId("4").setSource("foo", "c")
    private void verifyTransformedContent(String indexName, int expectedCount) {
import org.opensearch.action.search.SearchResponse;
 * compatible open source license.
        assertHitCount(client().prepareSearch("dest_half").setSize(0).get(), half);
        indexRandom(true, docs);  
}
                }
                  "type": "long"  
                        "number_of_replicas": 0,
            reindex().source("source").destination("dest").refresh(true).setSlices(slices).get();
        expectedCount = client().prepareSearch(destIndexMulti).setQuery(matchAllQuery()).get().getHits().getTotalHits().value();
            client().prepareIndex("source").setId("2").setSource("foo", "a"),
        assertThat(response, matcher().created(expectedCount));
import java.util.Map;
        assertHitCount(client().prepareSearch("none").setSize(0).get(), 0);
                        "keyword_field",
        assertHitCount(client().prepareSearch("dest").setSize(0).get(), 4);
 * this work for additional information regarding copyright
                        "date_field",  
        Map<String, List<IndexRequestBuilder>> docs = new HashMap<>();  
        assertAcked(prepareCreate(sourceIndex2).setSource(sourceIndexMapping, XContentType.JSON));
    public void testTooMuchSlices() throws InterruptedException {
              }
                },
 * not use this file except in compliance with the License.
              }
        response = copy.get();  
    public void testCopyManyWithSlices() throws Exception {
 * You may obtain a copy of the License at  
import org.opensearch.action.bulk.BulkResponse;
        response = copy.get();  
              "properties": {
                    }
        String destSlicedIndex = "dest_sliced_index";
        int numDocs2 = randomIntBetween(5, 20);
        }
        copy.maxDocs(half);  
                    .setId(Integer.toString(i))
        // Use a small batch size so we have to use more than one batch
        copy = reindex().source("source_index").destination(destIndexSliced).setSlices(slices).refresh(true);
 * the Apache License, Version 2.0 (the "License"); you may
                "modified_numeric": {
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(copy.get(), matcher().created(0));  
                                "type": "integer",  
        assertThat(e.getMessage(), containsString("is too large"));  
import java.util.stream.Collectors;  
                  "type": "keyword"  
        int expectedSlices = expectedSliceStatuses(slices, "source_index");
    }
        int expectedSlices = expectedSliceStatuses(slices, docs.keySet());  
/*
            String typeName = "test" + sourceIndex;  
                  "type": "date"  
        for (SearchHit hit : searchResponse.getHits()) {
import java.util.Collection;
        expectedCount = client().prepareSearch(destIndexMaxDocs).setQuery(matchAllQuery()).get().getHits().getTotalHits().value();  
        // Test 2: Reindex with query filter
                        "numeric_field",
        // Test 3: Reindex with slices
                        }
                            }
        assertAcked(prepareCreate("dest_index").setSource(sourceIndexMapping, XContentType.JSON));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            assertHitCount(client().prepareSearch(entry.getKey()).setSize(0).get(), entry.getValue().size());
        }
        reindex = reindex().source("source_index").destination(destTransformedIndex).refresh(true);
        for (int i = 0; i < numDocs2; i++) {  
        String destMapping = """  
        assertAcked(prepareCreate(destIndexMulti).setSource(sourceIndexMapping, XContentType.JSON));
                  "type": "keyword"
        refresh(destTransformedIndex);  
            .setSize(expectedCount)
            .setSize(expectedCount)
        assertAcked(prepareCreate(destIndexFiltered).setSource(sourceIndexMapping, XContentType.JSON));
            client().prepareIndex("source").setId("4").setSource("foo", "c")  
            bulkRequest.add(client().prepareIndex(destTransformedIndex).setId(hit.getId()).setSource(newSource));
        copy.maxDocs(half);  
        // Now none of them  
              "properties": {
 */  
        copy = reindex().source("source_index").destination(destIndexMaxDocs).maxDocs(maxDocs).refresh(true);
 * The OpenSearch Contributors require contributions made to  
        SearchResponse searchResponse = client().prepareSearch(destTransformedIndex).setQuery(matchAllQuery()).setSize(numDocs).get();
        verifyReindexedContent(destSlicedIndex, numDocs);
            newSource.put("new_text_field", source.get("text_field"));
            .setQuery(matchAllQuery())
        BulkRequestBuilder bulkRequest = client().prepareBulk();  
            {  
        for (SearchHit hit : searchResponse.getHits()) {  
        assertThat(response, matcher().created(1));
        assertHitCount(client().prepareSearch("source").setSize(0).get(), 4);
        // Test 3: Reindex with slices  
            assertNotNull(source.get("date_field"));  
        // Use a small batch size so we have to use more than one batch
        reindex = reindex().source("source_index").destination(destFilteredIndex).filter(termQuery("keyword_field", "key_1")).refresh(true);
            String indexName = "source" + sourceIndex;
        String destIndexFiltered = "dest_index_filtered";  
                  "type": "date",
        // Test 1: Basic reindex without slices
        for (int i = 0; i < numDocs; i++) {
        String transformedMapping = """
            client().prepareIndex("source").setId("2").setSource("foo", "a"),
    }
        assertHitCount(client().prepareSearch("dest").setSize(0).get(), max);
        String sourceMapping = """
        ReindexRequestBuilder copy = reindex().source("source").destination("dest").refresh(true);
        copy.source().setSize(5);  
        // Copy all the docs  
        String sourceIndexMapping = """
                        "properties": {  
            Map<String, Object> source = hit.getSourceAsMap();  
import java.util.HashMap;  
                    "_doc": {
        copy = reindex().source("source").destination("dest_size_one").maxDocs(1).refresh(true);  
        // Copy all the docs
        String destTransformedIndex = "dest_transformed_index";
            ).setMapping(sourceMapping)
 * KIND, either express or implied.  See the License for the
            client().prepareIndex("source").setId("1").setSource("foo", "a"),  
                "keyword_field": {  
                        "key_" + i,  
            // Transform fields
            client().prepareIndex("source").setId("3").setSource("foo", "b"),
                }
            .refresh(true)  
 */  
                "mappings": {
        int slices = randomSlices(1, 10);
    public void testReindexFromDerivedSourceToNormalIndex() throws Exception {  
            docs.put(indexName, new ArrayList<>());
            docs.add(client().prepareIndex("source").setId(Integer.toString(i)).setSource("foo", "a"));  
import static org.hamcrest.Matchers.containsString;  
        }  
 * license agreements. See the NOTICE file distributed with
        // Copy some of the docs
import org.opensearch.search.SearchHit;
 *  
        copy = reindex().source("source").destination("dest_half").filter(termQuery("foo", "a")).refresh(true);
              }  
        assertHitCount(client().prepareSearch("source").setSize(0).get(), max);
                  "store": true
            assertEquals("key_" + id, source.get("new_keyword_field"));
/*  
        // Copy all the docs  
                docs.get(indexName).add(client().prepareIndex(indexName).setId("id_" + sourceIndex + "_" + i).setSource("foo", "a"));
            assertEquals("text value " + id, source.get("new_text_field"));  
            Map<String, Object> newSource = new HashMap<>();
        // Index some documents
            Map<String, Object> source = hit.getSourceAsMap();  
        indexRandom(true, docs2);
                        "text value " + i,
                    }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        verifyReindexedContent(destFilteredIndex, 1);
        // Create destination index with normal settings
 * under the License.  
            .addSort("modified_numeric", SortOrder.ASC)  
            int numDocs = between(50, 200);
            newSource.put("modified_numeric", ((Number) source.get("numeric_field")).longValue() + 1000);
        int numDocs = randomIntBetween(5, 20);
        copy.source().setSize(5);
            newSource.put("date_field", source.get("date_field"));
                  "type": "long"
            Map<String, Object> source = hit.getSourceAsMap();
        assertThat(response, matcher().created(lessThanOrEqualTo((long) half)).slices(hasSize(expectedSlices)));
        }  
        SearchResponse searchResponse = client().prepareSearch(indexName)  
        // Test 4: Reindex with field transformation  
    public void testReindexWithDerivedSource() throws Exception {  
        // Copy some of the docs
        List<IndexRequestBuilder> docs2 = new ArrayList<>();
        for (int i = 0; i < numDocs; i++) {
        refresh("source_index");  
            true,
                                "store": true
            }""";  
        indexRandom(true, docs);  
        int sourceIndices = between(2, 5);
        assertThat(copy.get(), matcher().created(max).batches(greaterThanOrEqualTo(max / 5)).slices(hasSize(expectedSlices)));
 * GitHub history for details.
        BulkByScrollResponse response = copy.get();  
 *
        int max = between(150, 500);
            newSource.put("new_keyword_field", source.get("keyword_field"));  
        assertThat(copy.get(), matcher().created(2));
        assertThat(response, matcher().created(maxDocs));
                        }  
        int slices = randomSlices();
    }  
        long expectedCount = client().prepareSearch("dest_index").setQuery(matchAllQuery()).get().getHits().getTotalHits().value();
                                "store": true  
            int id = Integer.parseInt(hit.getId());
 * Unless required by applicable law or agreed to in writing,
        indexRandom(
        }
 * specific language governing permissions and limitations
            {  
        }
        assertThat(response, matcher().created(numDocs).slices(hasSize(expectedSlices)));
        }
        assertHitCount(searchResponse, expectedCount);  
        for (int sourceIndex = 0; sourceIndex < sourceIndices; sourceIndex++) {
            .setSlices(AbstractBulkByScrollRequest.AUTO_SLICES)
import org.opensearch.action.index.IndexRequestBuilder;  
        List<IndexRequestBuilder> docs = new ArrayList<>();  
                "date_field": {  
        assertFalse(bulkResponse.hasFailures());
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            );  
                client().prepareIndex(sourceIndex2).setId(Integer.toString(i + numDocs)).setSource("foo", "value2_" + i, "bar", i + numDocs)
        int max = between(150, 500);
        BulkByScrollResponse response = copy.get();
            .get();
            .get();
        BulkByScrollResponse response = reindex.get();
        List<IndexRequestBuilder> allDocs = docs.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
        assertAcked(prepareCreate("dest_index").setMapping(destMapping));
        List<IndexRequestBuilder> docs = new ArrayList<>();  
        int slices = randomSlices();

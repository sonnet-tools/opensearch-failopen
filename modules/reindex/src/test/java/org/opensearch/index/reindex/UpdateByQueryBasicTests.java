        }
        assertEquals(1, client().prepareGet("test", "1").get().getVersion());
        indexRandom(true, allDocs);
            }
 *
    public void testBasics() throws Exception {
 * not use this file except in compliance with the License.
            docs.put(indexName, new ArrayList<>());
        assertEquals(1, client().prepareGet("test", "4").get().getVersion());
        assertEquals(1, client().prepareGet("test", "4").get().getVersion());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // Now none of them
        assertEquals(2, client().prepareGet("test", "3").get().getVersion());
 */
 * specific language governing permissions and limitations
        indexRandom(
 *
            client().prepareIndex("test").setId("1").setSource("foo", "a"),
package org.opensearch.index.reindex;
    }
        );
 * this work for additional information regarding copyright
}
            client().prepareIndex("test").setId("4").setSource("foo", "c")
        assertThat(
            int numDocs = between(5, 15);
            String indexName = "test" + sourceIndex;
        for (Map.Entry<String, List<IndexRequestBuilder>> entry : docs.entrySet()) {
        assertThat(updateByQuery().source("test").filter(termQuery("foo", "a")).refresh(true).get(), matcher().updated(2));
 * You may obtain a copy of the License at
    }
        // Limit with size
        // Reindex all the docs
        assertEquals(3, client().prepareGet("test", "1").get().getVersion());
 * Unless required by applicable law or agreed to in writing,
        assertThat(updateByQuery().source("test").refresh(true).get(), matcher().updated(4));
            matcher().updated(4).slices(hasSize(expectedSlices))
            client().prepareIndex("test").setId("1").setSource("foo", "a"),
            updateByQuery().source("test").refresh(true).setSlices(slices).get(),
import static org.hamcrest.Matchers.hasSize;
        Map<String, List<IndexRequestBuilder>> docs = new HashMap<>();
 *
    public void testMultipleSources() throws Exception {
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
    public void testMissingSources() {
import java.util.List;
        assertEquals(4, client().prepareGet("test", "1").get().getVersion());
        int slices = randomSlices(2, 10);
 * The OpenSearch Contributors require contributions made to
 * GitHub history for details.
import java.util.ArrayList;
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 4);
        assertThat(response, matcher().updated(allDocs.size()).slices(hasSize(expectedSlices)));
        int sourceIndices = between(2, 5);
        UpdateByQueryRequestBuilder request = updateByQuery().source("test").size(3).refresh(true);
        assertEquals(2, client().prepareGet("test", "1").get().getVersion());
 * the Apache License, Version 2.0 (the "License"); you may
public class UpdateByQueryBasicTests extends ReindexTestCase {
 * license agreements. See the NOTICE file distributed with
        for (int sourceIndex = 0; sourceIndex < sourceIndices; sourceIndex++) {
            assertHitCount(client().prepareSearch(entry.getKey()).setSize(0).get(), entry.getValue().size());
        List<IndexRequestBuilder> allDocs = docs.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
            matcher().updated(2).slices(hasSize(expectedSlices))
        assertThat(response, matcher().updated(0).slices(hasSize(0)));
        assertEquals(3, client().prepareGet("test", "3").get().getVersion());
    }
        // Only the first three documents are updated because of sort
        assertEquals(3, client().prepareGet("test", "2").get().getVersion());
import java.util.Map;
/*
            client().prepareIndex("test").setId("4").setSource("foo", "c")
        // Now half of them
            List<IndexRequestBuilder> indexDocs = entry.getValue();
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
            client().prepareIndex("test").setId("2").setSource("foo", "a"),
        request.source().addSort("foo.keyword", SortOrder.ASC);
            updateByQuery().source("test").filter(termQuery("foo", "no_match")).setSlices(slices).refresh(true).get(),
        int slices = randomSlices(1, 10);
        );
        );
            .setSlices(AbstractBulkByScrollRequest.AUTO_SLICES)
 * ownership. Elasticsearch licenses this file to you under
        );
        assertEquals(2, client().prepareGet("test", "3").get().getVersion());
import java.util.HashMap;
        }
        assertThat(updateByQuery().source("test").filter(termQuery("foo", "no_match")).refresh(true).get(), matcher().updated(0));
 * under the License.
        for (Map.Entry<String, List<IndexRequestBuilder>> entry : docs.entrySet()) {
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
            updateByQuery().source("test").filter(termQuery("foo", "a")).refresh(true).setSlices(slices).get(),
        assertEquals(2, client().prepareGet("test", "1").get().getVersion());
    public void testSlices() throws Exception {
 * Licensed to Elasticsearch under one or more contributor
        assertThat(
        int expectedSlices = expectedSliceStatuses(slices, docs.keySet());
import java.util.Collection;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
            true,
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertEquals(1, client().prepareGet("test", "1").get().getVersion());
            matcher().updated(0).slices(hasSize(expectedSlices))
import org.opensearch.action.index.IndexRequestBuilder;
 */
        );
        // Now none of them
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
        assertEquals(3, client().prepareGet("test", "1").get().getVersion());
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
        String[] sourceIndexNames = docs.keySet().toArray(new String[0]);
    }
 */
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
 * this file be licensed under the Apache-2.0 license or a
        assertThat(request.get(), matcher().updated(3));
            assertEquals(2, client().prepareGet(index, Integer.toString(randomDoc)).get().getVersion());
        BulkByScrollResponse response = updateByQuery().source(sourceIndexNames).refresh(true).setSlices(slices).get();
        assertEquals(4, client().prepareGet("test", "2").get().getVersion());
            for (int i = 0; i < numDocs; i++) {
        // Reindex all the docs
            client().prepareIndex("test").setId("2").setSource("foo", "a"),
 * Modifications Copyright OpenSearch Contributors. See
        }
            int randomDoc = between(0, indexDocs.size() - 1);
                docs.get(indexName).add(client().prepareIndex(indexName).setId(Integer.toString(i)).setSource("foo", "a"));
/*
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(2, client().prepareGet("test", "1").get().getVersion());
            true,
            client().prepareIndex("test").setId("3").setSource("foo", "b"),
            client().prepareIndex("test").setId("3").setSource("foo", "b"),
        // Now half of them
        assertEquals(3, client().prepareGet("test", "2").get().getVersion());
 * software distributed under the License is distributed on an
            String index = entry.getKey();
        int expectedSlices = expectedSliceStatuses(slices, "test");
import org.opensearch.search.sort.SortOrder;
 * KIND, either express or implied.  See the License for the
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 4);
/*
        indexRandom(
            .get();
        assertThat(
            .refresh(true)
        assertEquals(2, client().prepareGet("test", "1").get().getVersion());
import java.util.stream.Collectors;
        BulkByScrollResponse response = updateByQuery().source("missing-index-*")

 *
    public void testMultipleSources() throws Exception {
        }
import java.util.ArrayList;
            matcher().updated(2).slices(hasSize(expectedSlices))  
            client().prepareIndex("test").setId("3").setSource("foo", "b"),  
        assertEquals(3, client().prepareGet("test", "3").get().getVersion());
import static org.hamcrest.Matchers.hasSize;
        assertThat(
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(2, client().prepareGet("test", "1").get().getVersion());  
        assertEquals(2, client().prepareGet("test", "1").get().getVersion());
        assertEquals(2, client().prepareGet("test", "3").get().getVersion());
        for (Map.Entry<String, List<IndexRequestBuilder>> entry : docs.entrySet()) {
            .setSlices(AbstractBulkByScrollRequest.AUTO_SLICES)  
        );
        );  
        // Now half of them
        assertThat(updateByQuery().source("test").filter(termQuery("foo", "a")).refresh(true).get(), matcher().updated(2));  
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
        // Now half of them  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            client().prepareIndex("test").setId("3").setSource("foo", "b"),
 */  
        String[] sourceIndexNames = docs.keySet().toArray(new String[0]);  
 * KIND, either express or implied.  See the License for the
public class UpdateByQueryBasicTests extends ReindexTestCase {  
            docs.put(indexName, new ArrayList<>());
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 4);  
        assertThat(  
import java.util.HashMap;  
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
import static org.opensearch.index.query.QueryBuilders.termQuery;
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
            String indexName = "test" + sourceIndex;
        for (Map.Entry<String, List<IndexRequestBuilder>> entry : docs.entrySet()) {
        // Now none of them
        indexRandom(true, allDocs);
        assertEquals(3, client().prepareGet("test", "2").get().getVersion());  
            }  
import java.util.stream.Collectors;  
/*
            String index = entry.getKey();
    }  
            for (int i = 0; i < numDocs; i++) {
        request.source().addSort("foo.keyword", SortOrder.ASC);
 * not use this file except in compliance with the License.
        assertEquals(3, client().prepareGet("test", "2").get().getVersion());
    }  
        UpdateByQueryRequestBuilder request = updateByQuery().source("test").size(3).refresh(true);
        BulkByScrollResponse response = updateByQuery().source("missing-index-*")
package org.opensearch.index.reindex;
import org.opensearch.search.sort.SortOrder;
            updateByQuery().source("test").filter(termQuery("foo", "a")).refresh(true).setSlices(slices).get(),
            .refresh(true)
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(2, client().prepareGet("test", "3").get().getVersion());  
        assertEquals(4, client().prepareGet("test", "1").get().getVersion());
        // Now none of them  
 * under the License.  
 *
 * this file be licensed under the Apache-2.0 license or a
            matcher().updated(0).slices(hasSize(expectedSlices))
        assertEquals(1, client().prepareGet("test", "1").get().getVersion());
import org.opensearch.action.index.IndexRequestBuilder;
        assertEquals(1, client().prepareGet("test", "4").get().getVersion());
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
 */
        List<IndexRequestBuilder> allDocs = docs.values().stream().flatMap(Collection::stream).collect(Collectors.toList());  
        // Only the first three documents are updated because of sort
 * Modifications Copyright OpenSearch Contributors. See
}
        assertEquals(1, client().prepareGet("test", "4").get().getVersion());  
        assertThat(
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
 * software distributed under the License is distributed on an
            .get();
        assertHitCount(client().prepareSearch("test").setSize(0).get(), 4);
 * the Apache License, Version 2.0 (the "License"); you may
    public void testBasics() throws Exception {
 * compatible open source license.
        BulkByScrollResponse response = updateByQuery().source(sourceIndexNames).refresh(true).setSlices(slices).get();
            client().prepareIndex("test").setId("2").setSource("foo", "a"),
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
            int numDocs = between(5, 15);  
            client().prepareIndex("test").setId("1").setSource("foo", "a"),
            int randomDoc = between(0, indexDocs.size() - 1);
            client().prepareIndex("test").setId("1").setSource("foo", "a"),
    }  
            updateByQuery().source("test").refresh(true).setSlices(slices).get(),
            matcher().updated(4).slices(hasSize(expectedSlices))
/*  
            assertEquals(2, client().prepareGet(index, Integer.toString(randomDoc)).get().getVersion());
 */  
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());  
        indexRandom(
            updateByQuery().source("test").filter(termQuery("foo", "no_match")).setSlices(slices).refresh(true).get(),  
        assertEquals(3, client().prepareGet("test", "1").get().getVersion());
            true,  
        // Reindex all the docs
    public void testMissingSources() {  
import java.util.Map;
        assertThat(updateByQuery().source("test").filter(termQuery("foo", "no_match")).refresh(true).get(), matcher().updated(0));
import java.util.Collection;
        );
        for (int sourceIndex = 0; sourceIndex < sourceIndices; sourceIndex++) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
 * this work for additional information regarding copyright
    public void testSlices() throws Exception {
            client().prepareIndex("test").setId("2").setSource("foo", "a"),  
        // Reindex all the docs
        int slices = randomSlices(2, 10);
        assertEquals(4, client().prepareGet("test", "2").get().getVersion());  
            client().prepareIndex("test").setId("4").setSource("foo", "c")
        assertThat(response, matcher().updated(allDocs.size()).slices(hasSize(expectedSlices)));
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        int slices = randomSlices(1, 10);  
        int sourceIndices = between(2, 5);  
        assertEquals(2, client().prepareGet("test", "4").get().getVersion());
        assertEquals(1, client().prepareGet("test", "1").get().getVersion());
        );
        assertEquals(2, client().prepareGet("test", "1").get().getVersion());
        }
        assertThat(response, matcher().updated(0).slices(hasSize(0)));
            client().prepareIndex("test").setId("4").setSource("foo", "c")
        int expectedSlices = expectedSliceStatuses(slices, docs.keySet());
            true,
 *  
        assertThat(request.get(), matcher().updated(3));  
        // Limit with size  
/*  
        indexRandom(  
 * You may obtain a copy of the License at  
        int expectedSlices = expectedSliceStatuses(slices, "test");  
    }
        assertEquals(3, client().prepareGet("test", "1").get().getVersion());
 * GitHub history for details.
        }  
            assertHitCount(client().prepareSearch(entry.getKey()).setSize(0).get(), entry.getValue().size());  
            List<IndexRequestBuilder> indexDocs = entry.getValue();  
                docs.get(indexName).add(client().prepareIndex(indexName).setId(Integer.toString(i)).setSource("foo", "a"));
        assertEquals(2, client().prepareGet("test", "1").get().getVersion());  
        assertThat(updateByQuery().source("test").refresh(true).get(), matcher().updated(4));
 * Unless required by applicable law or agreed to in writing,
        );  
        Map<String, List<IndexRequestBuilder>> docs = new HashMap<>();

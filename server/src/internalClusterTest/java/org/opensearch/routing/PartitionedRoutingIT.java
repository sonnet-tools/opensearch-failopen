        String index = "index_" + currentShards;
            Set<String> found = new HashSet<>();
            assertTrue(
                .actionGet();
 */  
                    .put("index.routing_partition_size", partitionSize)  
    private Map<String, Set<String>> generateRoutedDocumentIds(String index) {
            verifyRoutedSearches(
            verifyBroadSearches(index, routingToDocumentIds, currentShards);
                .indices()
        Map<String, Set<String>> routingToDocumentIds = new HashMap<>();
                    + response.getTotalShards()
                Map<String, Set<String>> routingToDocumentIds = generateRoutedDocumentIds(index);  
                    .put("index.number_of_shards", currentShards)  
            // index will be one of those, depending on the routing value
import org.opensearch.cluster.node.DiscoveryNode;  
                                .values()  
 * ownership. Elasticsearch licenses this file to you under  
            verifyGets(index, routingToDocumentIds);  
        for (Map.Entry<String, Set<String>> routingEntry : routingToDocumentIds.entrySet()) {  
 * this work for additional information regarding copyright
                .setIndices(index)  
            assertEquals(expectedShards, response.getTotalShards());
        }
import org.opensearch.common.settings.Settings;
 * under the License.  
        }
 *
            // we need the floor and ceiling of the routing_partition_size / factor since the partition size of the shrunken  
        }
            assertEquals(expectedDocuments, response.getHits().getTotalHits().value());
        int numRoutingValues = randomIntBetween(5, 15);  
        final int originalShards = 8;  
                        .putNull("index.routing.allocation.require._name")
        }  
            assertEquals(expectedDocuments, response.getHits().getTotalHits().value());  
            client().admin()  
                .setSettings(
        // verifying that the count is correct for each shrunken index
                    Settings.builder()
import org.opensearch.index.query.QueryBuilders;
                )  
                .setSettings(  
                )
            String routing = routingEntry.getKey();
                .setSize(100)
                .setSize(100)  
            .actionGet();
/*  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
public class PartitionedRoutingIT extends OpenSearchIntegTestCase {  
                .setIndices(index)
                            .put("index.number_of_shards", shards)  
 * Licensed to Elasticsearch under one or more contributor  
}
                        Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
            }  
        final int partitionSize = 3;
                    + "] shards for routing ["  
        return routingToDocumentIds;
                    + "]"
            int expectedDocuments = routingEntry.getValue().size();
                    )  
                    ? Sets.newSet(1, 2)  
        }  
    }
                ensureGreen();
import java.util.Set;
                        .put("index.number_of_replicas", numberOfReplicas())  
                    : Sets.newSet(Math.floorDiv(partitionSize, factor), -Math.floorDiv(-partitionSize, factor))
            }
import org.opensearch.action.search.SearchResponse;
            response.getHits().forEach(h -> found.add(h.getId()));  
                                .getState()  
            int factor = originalShards / currentShards;
            String previousIndex = index;
            .indices()
 */  
            String routing = routingEntry.getKey();
        client().admin()
                verifyBroadSearches(index, routingToDocumentIds, shards);  
                client().prepareIndex(index).setId(id).setRouting(routingValue).setSource("foo", "bar").get();
 *    http://www.apache.org/licenses/LICENSE-2.0
            client().admin()
            .prepareCreate(index)  
                                .toArray(new DiscoveryNode[0])[0].getName()
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.util.Constants;
            SearchResponse response = client().prepareSearch()
            String routing = routingEntry.getKey();
        client().admin().indices().prepareRefresh(index).get();  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.routing;
            currentShards = Math.floorDiv(currentShards, 2);
                String index = "index_" + shards + "_" + partitionSize;
    }  
            .execute()  
import org.opensearch.test.OpenSearchIntegTestCase;  
 * You may obtain a copy of the License at  
    public void testShrinking() throws Exception {  
                verifyGets(index, routingToDocumentIds);
import org.mockito.internal.util.collections.Sets;
            SearchResponse response = client().prepareSearch()
                index,  
            }  
 * compatible open source license.
 * not use this file except in compliance with the License.
                            client().admin()
                client().admin()
            );
                .execute()
            assertEquals(routingEntry.getValue(), found);
                                .cluster()  
                break;
                        )
        while (true) {  
            ensureGreen();
            )
    private void verifyGets(String index, Map<String, Set<String>> routingToDocumentIds) {  
                .execute()
            response.getHits().forEach(h -> found.add(h.getId()));
            .setMapping("{\"_routing\":{\"required\":true}}}")
        for (Map.Entry<String, Set<String>> routingEntry : routingToDocumentIds.entrySet()) {
    }  
 * GitHub history for details.
        Map<String, Set<String>> routingToDocumentIds = generateRoutedDocumentIds(index);
            ensureGreen();  
                            .put("index.number_of_routing_shards", shards)
            index = "index_" + currentShards;  
                Math.floorDiv(partitionSize, factor) == 0
                        .put(  
            for (int partitionSize = 1; partitionSize < shards; partitionSize++) {
            logger.info("--> shrinking index [" + previousIndex + "] to [" + index + "]");
                .setQuery(QueryBuilders.termQuery("_routing", routing))  
            int numDocuments = randomIntBetween(10, 100);
                routingToDocumentIds.get(routingValue).add(id);  
                assertTrue(client().prepareGet(index, id).setRouting(routing).execute().actionGet().isExists());
    public void testVariousPartitionSizes() throws Exception {
            if (currentShards == 0) {
                            "index.routing.allocation.require._name",
            for (int k = 0; k < numDocuments; k++) {
                .get();
                    + routing
                    .put("index.number_of_routing_shards", currentShards)
 * the Apache License, Version 2.0 (the "License"); you may
                        .put("index.number_of_shards", currentShards)
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    .actionGet();  
        for (int shards = 1; shards <= 4; shards++) {  
/*
                .actionGet();  
                "--> routed search on index ["
                response.getTotalShards() + " was not in " + expectedShards + " for " + index,
                        .put("index.blocks.write", true)  
import java.util.HashMap;
 */
                                .nodes()
        assumeFalse("http://github.com/elastic/elasticsearch/issues/33857", Constants.WINDOWS);
                Settings.builder()
 *  
                .setQuery(QueryBuilders.termQuery("_routing", routing))
                                .prepareState()
                .prepareUpdateSettings(index)  
            routingToDocumentIds.put(String.valueOf(routingValue), new HashSet<>());
                    + "] visited ["
                routingToDocumentIds,
            assertEquals(routingEntry.getValue(), found);
            Set<String> found = new HashSet<>();
                    Settings.builder()
            for (String id : routingEntry.getValue()) {
                            .put("index.routing_partition_size", partitionSize)
                    .execute()
 * license agreements. See the NOTICE file distributed with
    }
 *
                    + "] and got hits ["
                .prepareResizeIndex(previousIndex, index)
    private void verifyBroadSearches(String index, Map<String, Set<String>> routingToDocumentIds, int expectedShards) {
            String routingValue = String.valueOf(i);  
            int expectedDocuments = routingEntry.getValue().size();  
                                .get()
        int currentShards = originalShards;
                    .put("index.number_of_replicas", numberOfReplicas())
                    .setMapping("{\"_routing\":{\"required\":true}}")
                .get();
                                .getDataNodes()
        }  
import java.util.HashSet;  
                    .indices()
 * specific language governing permissions and limitations
    }
            .setSettings(
            logger.info(
                .setRouting(routing)
                    + response.getHits().getTotalHits().value()  
 * The OpenSearch Contributors require contributions made to  
            );
        for (int i = 0; i < numRoutingValues; i++) {
                verifyRoutedSearches(index, routingToDocumentIds, Sets.newSet(partitionSize));
            );
                    .prepareCreate(index)  
                        .build()
                String id = routingValue + "_" + String.valueOf(k);
 * software distributed under the License is distributed on an
        for (Map.Entry<String, Set<String>> routingEntry : routingToDocumentIds.entrySet()) {
            }  
                    + index  
        // creates random routing groups and repeatedly halves the index until it is down to 1 shard  
import java.util.Map;
                .indices()
    private void verifyRoutedSearches(String index, Map<String, Set<String>> routingToDocumentIds, Set<Integer> expectedShards) {  
                expectedShards.contains(response.getTotalShards())  
                    .setSettings(
/*  
        ensureGreen();

                    .setMapping("{\"_routing\":{\"required\":true}}")
        }
/*
 */
import java.util.Set;
                            "index.routing.allocation.require._name",
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
            int numDocuments = randomIntBetween(10, 100);
            .setMapping("{\"_routing\":{\"required\":true}}}")
            int factor = originalShards / currentShards;
            assertEquals(routingEntry.getValue(), found);
 * SPDX-License-Identifier: Apache-2.0
                client().admin()
                .setQuery(QueryBuilders.termQuery("_routing", routing))
                .prepareUpdateSettings(index)
 * Modifications Copyright OpenSearch Contributors. See
                        .put("index.number_of_shards", currentShards)
 * this work for additional information regarding copyright
        final int partitionSize = 3;
                .setSize(100)
        }
 *
        }
            String routing = routingEntry.getKey();
            Set<String> found = new HashSet<>();
            Set<String> found = new HashSet<>();
        int numRoutingValues = randomIntBetween(5, 15);
                .setRouting(routing)
            response.getHits().forEach(h -> found.add(h.getId()));
            response.getHits().forEach(h -> found.add(h.getId()));
            .execute()
package org.opensearch.routing;
                    + response.getHits().getTotalHits().value()
                .setSettings(
                            .put("index.number_of_routing_shards", shards)
                    )
 * software distributed under the License is distributed on an
import java.util.HashMap;
                verifyGets(index, routingToDocumentIds);
                    + "] shards for routing ["
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        .put("index.blocks.write", true)
            assertTrue(
                                .getState()
 * under the License.
    }
                expectedShards.contains(response.getTotalShards())
 */
                        .build()
            // index will be one of those, depending on the routing value
 * Licensed to Elasticsearch under one or more contributor
                    Settings.builder()
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.settings.Settings;
                ensureGreen();
    private void verifyGets(String index, Map<String, Set<String>> routingToDocumentIds) {
import org.apache.lucene.util.Constants;
 *
            .prepareCreate(index)
        ensureGreen();
    }
                    .actionGet();
 * specific language governing permissions and limitations
                                .values()
    private Map<String, Set<String>> generateRoutedDocumentIds(String index) {
 * Unless required by applicable law or agreed to in writing,
    }
            for (int k = 0; k < numDocuments; k++) {
        while (true) {
                                .nodes()
                .setIndices(index)
import org.opensearch.cluster.node.DiscoveryNode;
                        .put(
        }
                    .setSettings(
        return routingToDocumentIds;
    private void verifyBroadSearches(String index, Map<String, Set<String>> routingToDocumentIds, int expectedShards) {
                    Settings.builder()
import java.util.HashSet;
            }
                .setQuery(QueryBuilders.termQuery("_routing", routing))
        Map<String, Set<String>> routingToDocumentIds = new HashMap<>();
        final int originalShards = 8;
                    .put("index.number_of_routing_shards", currentShards)
            assertEquals(expectedShards, response.getTotalShards());
                Map<String, Set<String>> routingToDocumentIds = generateRoutedDocumentIds(index);
                .setSize(100)
                .actionGet();
                String id = routingValue + "_" + String.valueOf(k);
                assertTrue(client().prepareGet(index, id).setRouting(routing).execute().actionGet().isExists());
            verifyBroadSearches(index, routingToDocumentIds, currentShards);
        Map<String, Set<String>> routingToDocumentIds = generateRoutedDocumentIds(index);
    public void testVariousPartitionSizes() throws Exception {
                routingToDocumentIds,
            int expectedDocuments = routingEntry.getValue().size();
    }
                verifyBroadSearches(index, routingToDocumentIds, shards);
            index = "index_" + currentShards;
        String index = "index_" + currentShards;
    }
import org.opensearch.index.query.QueryBuilders;
public class PartitionedRoutingIT extends OpenSearchIntegTestCase {
            )
            verifyGets(index, routingToDocumentIds);
            }
/*
            .indices()
                .indices()
            assertEquals(expectedDocuments, response.getHits().getTotalHits().value());
                    + "] and got hits ["
        }
            assertEquals(routingEntry.getValue(), found);
        assumeFalse("http://github.com/elastic/elasticsearch/issues/33857", Constants.WINDOWS);
            );
            ensureGreen();
}
            for (String id : routingEntry.getValue()) {
import org.opensearch.action.search.SearchResponse;
import java.util.Map;
        // creates random routing groups and repeatedly halves the index until it is down to 1 shard
            .actionGet();
            String routing = routingEntry.getKey();
            for (int partitionSize = 1; partitionSize < shards; partitionSize++) {
        client().admin().indices().prepareRefresh(index).get();
            if (currentShards == 0) {
                    .put("index.number_of_shards", currentShards)
                    : Sets.newSet(Math.floorDiv(partitionSize, factor), -Math.floorDiv(-partitionSize, factor))
            currentShards = Math.floorDiv(currentShards, 2);
            client().admin()
 * The OpenSearch Contributors require contributions made to
        int currentShards = originalShards;
 * the Apache License, Version 2.0 (the "License"); you may
                                .cluster()
            int expectedDocuments = routingEntry.getValue().size();
        for (Map.Entry<String, Set<String>> routingEntry : routingToDocumentIds.entrySet()) {
                                .getDataNodes()
                                .get()
        // verifying that the count is correct for each shrunken index
            assertEquals(expectedDocuments, response.getHits().getTotalHits().value());
                .get();
                )
            );
            }
                .prepareResizeIndex(previousIndex, index)
                verifyRoutedSearches(index, routingToDocumentIds, Sets.newSet(partitionSize));
                index,
            ensureGreen();
                    ? Sets.newSet(1, 2)
            logger.info(
 *
 * GitHub history for details.
                    .execute()
    private void verifyRoutedSearches(String index, Map<String, Set<String>> routingToDocumentIds, Set<Integer> expectedShards) {
                                .toArray(new DiscoveryNode[0])[0].getName()
                Math.floorDiv(partitionSize, factor) == 0
                String index = "index_" + shards + "_" + partitionSize;
                        .putNull("index.routing.allocation.require._name")
        for (int i = 0; i < numRoutingValues; i++) {
            verifyRoutedSearches(
                    .put("index.number_of_replicas", numberOfReplicas())
                    + routing
                Settings.builder()
                    + response.getTotalShards()
            logger.info("--> shrinking index [" + previousIndex + "] to [" + index + "]");
                    .put("index.routing_partition_size", partitionSize)
                )
import org.mockito.internal.util.collections.Sets;
        for (Map.Entry<String, Set<String>> routingEntry : routingToDocumentIds.entrySet()) {
            SearchResponse response = client().prepareSearch()
                        )
                .execute()
                routingToDocumentIds.get(routingValue).add(id);
                client().prepareIndex(index).setId(id).setRouting(routingValue).setSource("foo", "bar").get();
                "--> routed search on index ["
        }
 * license agreements. See the NOTICE file distributed with
    }
                    + index
 * this file be licensed under the Apache-2.0 license or a
                response.getTotalShards() + " was not in " + expectedShards + " for " + index,
                break;
        for (int shards = 1; shards <= 4; shards++) {
            String previousIndex = index;
            );
            String routing = routingEntry.getKey();
                            .put("index.routing_partition_size", partitionSize)
                            .put("index.number_of_shards", shards)
                        Settings.builder()
 * You may obtain a copy of the License at
            // we need the floor and ceiling of the routing_partition_size / factor since the partition size of the shrunken
            String routingValue = String.valueOf(i);
                .actionGet();
                        .put("index.number_of_replicas", numberOfReplicas())
            SearchResponse response = client().prepareSearch()
            .setSettings(
 * KIND, either express or implied.  See the License for the
    public void testShrinking() throws Exception {
            }
                .execute()
        for (Map.Entry<String, Set<String>> routingEntry : routingToDocumentIds.entrySet()) {
                    .prepareCreate(index)
            client().admin()
import org.opensearch.test.OpenSearchIntegTestCase;
                    .indices()
/*
                .indices()
        client().admin()
 * compatible open source license.
                            client().admin()
                                .prepareState()
                .get();
 */
                    + "]"
                .setIndices(index)
                .setSettings(
                    + "] visited ["
            routingToDocumentIds.put(String.valueOf(routingValue), new HashSet<>());

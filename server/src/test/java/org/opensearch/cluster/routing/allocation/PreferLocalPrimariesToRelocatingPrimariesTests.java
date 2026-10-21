        while (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            logger.info(
        clusterState = strategy.disassociateDeadNodes(clusterState, true, "reroute");
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState)
        logger.info("remove one of the nodes and apply filter to move everything from another node");
        logger.info("start node back up");
                .getRoutingNodes()
import org.opensearch.cluster.ClusterState;
                } else {
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(numberOfShards));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node1", singletonMap("tag1", "value1"))))
        logger.info("adding two nodes and performing rerouting till all are allocated");
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", primaryRecoveries)
 * specific language governing permissions and limitations
        RoutingTable initialRoutingTable = RoutingTable.builder()
                    relocatingInitializations++;
                needToInitialize
            Settings.builder()
            concurrentRecoveries
    public void testPreferLocalPrimaryAllocationOverFiltered() {
 * license agreements. See the NOTICE file distributed with
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            clusterState = startRandomInitializingShard(clusterState, strategy);
        metadata = Metadata.builder()
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            .build();
                IndexMetadata.builder(clusterState.metadata().index("test2"))
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.node.DiscoveryNodes;
            .addAsNew(metadata.index("test2"))
            )
 *
            .build();
                localInitializations,
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            primaryRecoveries,
 * GitHub history for details.
 * under the License.
            .build();
}
 */
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(numberOfShards));
                .build()
        AllocationService strategy = createAllocationService(
 * the Apache License, Version 2.0 (the "License"); you may
            .metadata(metadata)
        }
            .put(
            int needToInitialize = totalNumberOfShards - clusterState.getRoutingNodes().shardsWithState(STARTED).size() - clusterState
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            "create an allocation with [{}] initial primary recoveries and [{}] concurrent recoveries",
                .put("cluster.routing.allocation.node_concurrent_recoveries", concurrentRecoveries)
 * You may obtain a copy of the License at
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node1"))
        );
                IndexMetadata.builder(clusterState.metadata().index("test1"))
import static java.util.Collections.singletonMap;
 * this work for additional information regarding copyright
                    )
                if (routing.relocatingNodeId() == null) {
            .put(
            )
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;
        int totalNumberOfShards = numberOfShards * 2;
            .routingTable(initialRoutingTable)
        clusterState = ClusterState.builder(clusterState)
                            .put("index.number_of_replicas", 0)
import org.opensearch.cluster.metadata.Metadata;
                        settings(Version.CURRENT).put("index.number_of_shards", numberOfShards)
 * Modifications Copyright OpenSearch Contributors. See
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(numberOfShards).numberOfReplicas(0))
    }
                    .settings(
                    .settings(
import org.opensearch.cluster.routing.ShardRouting;
            for (ShardRouting routing : clusterState.getRoutingNodes().shardsWithState(INITIALIZING)) {
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.cluster.routing.RoutingTable;
                relocatingInitializations,
        clusterState = ClusterState.builder(clusterState)
 * compatible open source license.
import org.opensearch.Version;
                .size();
package org.opensearch.cluster.routing.allocation;
        clusterState = strategy.reroute(clusterState, "reroute");
            .build();
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                        settings(Version.CURRENT).put("index.number_of_shards", numberOfShards)
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
 *
            .build();
                            .build()
        int primaryRecoveries = randomIntBetween(1, 10);
            );
import static org.hamcrest.Matchers.equalTo;
 * software distributed under the License is distributed on an
            .addAsNew(metadata.index("test1"))
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(numberOfShards).numberOfReplicas(0))
            }
                            .put("index.number_of_replicas", 0)
                    localInitializations++;
public class PreferLocalPrimariesToRelocatingPrimariesTests extends OpenSearchAllocationTestCase {
 *
            .build();
 * Unless required by applicable law or agreed to in writing,
            assertThat(localInitializations, equalTo(Math.min(primaryRecoveries, needToInitialize)));
/*
        logger.info("create 2 indices with [{}] no replicas, and wait till all are allocated", numberOfShards);
            .metadata(metadata)
                "local initializations: [{}], relocating: [{}], need to initialize: {}",
        );
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
 * Licensed to Elasticsearch under one or more contributor
        clusterState = strategy.reroute(clusterState, "reroute");
        }
        logger.info(
        int concurrentRecoveries = randomIntBetween(1, 10);
 */
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
                            .put("index.routing.allocation.exclude._name", "node2")
 */
        int numberOfShards = randomIntBetween(5, 20);
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
 * KIND, either express or implied.  See the License for the
            int localInitializations = 0;
        logger.info("[{}] primaries should be still started but [{}] other primaries should be unassigned", numberOfShards, numberOfShards);
            .build();
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                }
                            .build()
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
                            .put("index.routing.allocation.exclude._name", "node2")
                .shardsWithState(RELOCATING)
 * ownership. Elasticsearch licenses this file to you under
/*
            int relocatingInitializations = 0;
        while (clusterState.getRoutingNodes().shardsWithState(STARTED).size() < totalNumberOfShards) {
                    )

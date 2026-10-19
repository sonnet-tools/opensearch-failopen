import org.opensearch.common.settings.Settings;
            for (ShardRouting routing : clusterState.getRoutingNodes().shardsWithState(INITIALIZING)) {
import org.opensearch.Version;  
                } else {
 */  
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
            )
            .addAsNew(metadata.index("test2"))
import org.opensearch.cluster.routing.ShardRouting;
                        settings(Version.CURRENT).put("index.number_of_shards", numberOfShards)
                    localInitializations++;
                    )  
import org.opensearch.cluster.metadata.Metadata;
                            .put("index.routing.allocation.exclude._name", "node2")
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
                }
 * the Apache License, Version 2.0 (the "License"); you may
        }  
import static org.hamcrest.Matchers.equalTo;  
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info(
    }
package org.opensearch.cluster.routing.allocation;
 * not use this file except in compliance with the License.
 */
                .build()
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            concurrentRecoveries
 * GitHub history for details.
        clusterState = strategy.disassociateDeadNodes(clusterState, true, "reroute");
        logger.info("[{}] primaries should be still started but [{}] other primaries should be unassigned", numberOfShards, numberOfShards);  
            .metadata(metadata)
                    .settings(
        int concurrentRecoveries = randomIntBetween(1, 10);
            .build();
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(numberOfShards));  
                .shardsWithState(RELOCATING)
                if (routing.relocatingNodeId() == null) {  
 *  
 * compatible open source license.
            int relocatingInitializations = 0;
        );
            .build();  
                "local initializations: [{}], relocating: [{}], need to initialize: {}",
import static java.util.Collections.singletonMap;
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(numberOfShards).numberOfReplicas(0))
import org.opensearch.cluster.ClusterState;
 * KIND, either express or implied.  See the License for the
            .build();
            .routingTable(initialRoutingTable)  
            assertThat(localInitializations, equalTo(Math.min(primaryRecoveries, needToInitialize)));
            int localInitializations = 0;  
        int primaryRecoveries = randomIntBetween(1, 10);  
                            .put("index.number_of_replicas", 0)  
        metadata = Metadata.builder()
 * license agreements. See the NOTICE file distributed with
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            .metadata(metadata)
    public void testPreferLocalPrimaryAllocationOverFiltered() {
                            .put("index.routing.allocation.exclude._name", "node2")
        while (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            Settings.builder()
                localInitializations,  
}
/*
            );  
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                needToInitialize
 *
            .put(
                .getRoutingNodes()
                .size();  
/*  
                relocatingInitializations,
            clusterState = startRandomInitializingShard(clusterState, strategy);
public class PreferLocalPrimariesToRelocatingPrimariesTests extends OpenSearchAllocationTestCase {
        clusterState = strategy.reroute(clusterState, "reroute");  
                IndexMetadata.builder(clusterState.metadata().index("test1"))  
            }
 * under the License.  
        clusterState = strategy.reroute(clusterState, "reroute");
 * Licensed to Elasticsearch under one or more contributor  
        clusterState = ClusterState.builder(clusterState)
            int needToInitialize = totalNumberOfShards - clusterState.getRoutingNodes().shardsWithState(STARTED).size() - clusterState  
 * The OpenSearch Contributors require contributions made to  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node1"))
            .build();  
        Metadata metadata = Metadata.builder()  
 * ownership. Elasticsearch licenses this file to you under  
        clusterState = ClusterState.builder(clusterState)  
            .build();  
            )
        logger.info("start node back up");
                .put("cluster.routing.allocation.node_concurrent_recoveries", concurrentRecoveries)
        logger.info("remove one of the nodes and apply filter to move everything from another node");
 *
 * SPDX-License-Identifier: Apache-2.0
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", primaryRecoveries)  
        logger.info("adding two nodes and performing rerouting till all are allocated");  
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .addAsNew(metadata.index("test1"))  
            logger.info(
                            .put("index.number_of_replicas", 0)  
import org.opensearch.cluster.node.DiscoveryNodes;
        logger.info("create 2 indices with [{}] no replicas, and wait till all are allocated", numberOfShards);
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                IndexMetadata.builder(clusterState.metadata().index("test2"))  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
                            .build()
 * Modifications Copyright OpenSearch Contributors. See  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
                        settings(Version.CURRENT).put("index.number_of_shards", numberOfShards)
import org.opensearch.cluster.routing.RoutingTable;  
 * this file be licensed under the Apache-2.0 license or a
            .put(
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node1", singletonMap("tag1", "value1"))))
        }  
/*
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(numberOfShards).numberOfReplicas(0))
        int totalNumberOfShards = numberOfShards * 2;
            primaryRecoveries,  
            .build();
        clusterState = ClusterState.builder(clusterState)  
        while (clusterState.getRoutingNodes().shardsWithState(STARTED).size() < totalNumberOfShards) {
                    )  
        AllocationService strategy = createAllocationService(  
        int numberOfShards = randomIntBetween(5, 20);
                    relocatingInitializations++;  
        RoutingTable initialRoutingTable = RoutingTable.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(numberOfShards));
import org.opensearch.cluster.metadata.IndexMetadata;  
                    .settings(
        );
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
                            .build()
            "create an allocation with [{}] initial primary recoveries and [{}] concurrent recoveries",

 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
public class PreferPrimaryAllocationTests extends OpenSearchAllocationTestCase {
 * Modifications Copyright OpenSearch Contributors. See
        AllocationService strategy = createAllocationService(  
            .build();  
/*  
        while (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        final String[] indices = { "test1", "test2" };
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            .build();
 * The OpenSearch Contributors require contributions made to  
        metadata = Metadata.builder(clusterState.metadata())  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        logger.info("2 replicas should be initializing now for the existing indices (we throttle to 1)");
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 1)  
            .addAsNew(metadata.index("test1"))
import org.opensearch.cluster.metadata.IndexMetadata;  
        updatedRoutingTable = RoutingTable.builder(clusterState.routingTable()).addAsNew(metadata.index("new_index")).build();
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(updatedRoutingTable).build();  
            .routingTable(initialRoutingTable)
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.node.DiscoveryNodes;
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(10).numberOfReplicas(0))
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
import org.apache.logging.log4j.Logger;
        );
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 1)
    }  
 * this work for additional information regarding copyright
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
        logger.info("create a new index");
 * this file be licensed under the Apache-2.0 license or a
            .build();
 * not use this file except in compliance with the License.
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(10).numberOfReplicas(0))  
        logger.info("reroute, verify that primaries for the new index primary shards are allocated");
import org.opensearch.common.settings.Settings;
            .put(IndexMetadata.builder("new_index").settings(settings(Version.CURRENT)).numberOfShards(4).numberOfReplicas(0))
 * under the License.  
        clusterState = strategy.reroute(clusterState, "reroute");  
    public void testPreferPrimaryAllocationOverReplicas() {
 * specific language governing permissions and limitations
 */  
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable()).updateNumberOfReplicas(1, indices).build();
}
import static org.hamcrest.Matchers.equalTo;
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        metadata = Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(1, indices).build();  
        clusterState = strategy.reroute(clusterState, "reroute");  
import org.opensearch.Version;  
 */
        RoutingTable initialRoutingTable = RoutingTable.builder()
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState).routingTable(updatedRoutingTable).metadata(metadata).build();
    private final Logger logger = LogManager.getLogger(PreferPrimaryAllocationTests.class);
                .put("cluster.routing.allocation.node_concurrent_recoveries", 1)
/*  
import org.opensearch.cluster.routing.RoutingTable;  
                .build()  
package org.opensearch.cluster.routing.allocation;
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(INITIALIZING).size(), equalTo(2));
import org.apache.logging.log4j.LogManager;
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
import org.opensearch.cluster.metadata.Metadata;
 *
        logger.info("create an allocation with 1 initial recoveries");
 * KIND, either express or implied.  See the License for the
        logger.info("create several indices with no replicas, and wait till all are allocated");  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            Settings.builder()
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
        }
            .build();
 * Licensed to Elasticsearch under one or more contributor  
            .metadata(metadata)
            .build();
        clusterState = strategy.reroute(clusterState, "reroute");  
/*
            .addAsNew(metadata.index("test2"))  
 */  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(), 10)
        logger.info("adding two nodes and performing rerouting till all are allocated");
 *  
 *
        logger.info("increasing the number of replicas to 1, and perform a reroute (to get the replicas allocation going)");  
import org.opensearch.cluster.ClusterState;
        clusterState = ClusterState.builder(clusterState)  

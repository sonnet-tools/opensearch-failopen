import org.opensearch.cluster.metadata.IndexMetadata;  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(5));
package org.opensearch.cluster.routing.allocation;
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)  
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
import org.opensearch.common.settings.Settings;  
import org.opensearch.cluster.node.DiscoveryNodes;
 * GitHub history for details.
        clusterState = strategy.reroute(clusterState, "reroute");
    }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node1"));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
import org.apache.logging.log4j.LogManager;
            .metadata(metadata)
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 */  
 * this work for additional information regarding copyright
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
        logger.info("Start the primary shard (on node1)");  
 */
 * The OpenSearch Contributors require contributions made to  
        );
import org.opensearch.Version;  
/*  
public class PrimaryNotRelocatedWhileBeingRecoveredTests extends OpenSearchAllocationTestCase {  
 */  
 * You may obtain a copy of the License at  
        logger.info("start another node, make sure the primary is not relocated");
 * SPDX-License-Identifier: Apache-2.0
            .build();
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        clusterState = strategy.reroute(clusterState, "reroute");
        Metadata metadata = Metadata.builder()  
                .build()
        AllocationService strategy = createAllocationService(
        clusterState = strategy.reroute(clusterState, "reroute");  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
    private final Logger logger = LogManager.getLogger(PrimaryNotRelocatedWhileBeingRecoveredTests.class);
 * specific language governing permissions and limitations
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(5));  
import org.apache.logging.log4j.Logger;
        logger.info("Building initial routing table");
 *  
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(5));
 * KIND, either express or implied.  See the License for the
            .routingTable(initialRoutingTable)
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .build();  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            Settings.builder()
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
                .put("cluster.routing.allocation.concurrent_source_recoveries", 10)
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.routing.RoutingTable;
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(5));
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(5));
 * license agreements. See the NOTICE file distributed with
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
 *
 * not use this file except in compliance with the License.
    public void testPrimaryNotRelocatedWhileBeingRecoveredFrom() {  
        logger.info("Adding two nodes and performing rerouting");
import org.opensearch.cluster.routing.RoutingNodes;  
import org.opensearch.cluster.ClusterState;
        logger.info("start another node, replica will start recovering form primary");  
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
/*  
import org.opensearch.cluster.metadata.Metadata;

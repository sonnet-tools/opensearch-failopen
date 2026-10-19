                nodeName,
 * under the License.  
        clusterState = addNode(clusterState, "node_d2", false);
        assertEquals(0, clusterState.nodes().getDataNodes().size());
    private ClusterState removeNode(ClusterState clusterState, String nodeName, AllocationService allocationService) {
            )  
            newNode(  
        return ClusterState.builder(clusterState).nodes(nodeBuilder).build();
/*
        assertEquals(ClusterHealthStatus.RED, getClusterHealthStatus(clusterState));  
 * You may obtain a copy of the License at  
            "reroute"  
import org.opensearch.cluster.ClusterName;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 */
}
        return allocationService.disassociateDeadNodes(  
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(routingTable).build();
 * specific language governing permissions and limitations
        nodeBuilder.add(
import java.util.Collections;
            .build();  
        assertEquals(0, clusterState.nodes().getDataNodes().size());
        return new ClusterStateHealth(clusterState).getStatus();
        );
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(ClusterHealthStatus.GREEN, getClusterHealthStatus(clusterState));  
            true,
        clusterState = removeNode(clusterState, "node_d2", allocation);
 * compatible open source license.
/*  
        Metadata metadata = Metadata.builder()
 *
 * the Apache License, Version 2.0 (the "License"); you may
    private ClusterHealthStatus getClusterHealthStatus(ClusterState clusterState) {
        clusterState = applyStartedShardsUntilNoChange(clusterState, allocation);
            clusterState = addNode(clusterState, "node_m", true);  
        clusterState = applyStartedShardsUntilNoChange(clusterState, allocation);
        assertEquals(ClusterHealthStatus.GREEN, getClusterHealthStatus(clusterState));
 * GitHub history for details.
 */  
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.routing.allocation.AllocationService;  
        metadata = Metadata.builder(clusterState.metadata()).remove("test").build();  
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).build();
                Collections.singleton(isClusterManager ? DiscoveryNodeRole.CLUSTER_MANAGER_ROLE : DiscoveryNodeRole.DATA_ROLE)
        assertEquals(ClusterHealthStatus.YELLOW, getClusterHealthStatus(clusterState));  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
public class ClusterHealthAllocationTests extends OpenSearchAllocationTestCase {
        MockAllocationService allocation = createAllocationService();  
        clusterState = addNode(clusterState, "node_d1", false);
import org.opensearch.cluster.routing.RoutingTable;
import org.opensearch.cluster.metadata.IndexMetadata;
        clusterState = applyStartedShardsUntilNoChange(clusterState, allocation);
        assertEquals(ClusterHealthStatus.RED, getClusterHealthStatus(clusterState));  
import org.opensearch.cluster.node.DiscoveryNodes;
    }  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
package org.opensearch.cluster.health;
import org.opensearch.cluster.node.DiscoveryNodeRole;  
 *  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
            ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.getNodes()).remove(nodeName)).build(),
import org.opensearch.Version;  
        assertEquals(ClusterHealthStatus.GREEN, getClusterHealthStatus(clusterState));  
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.getNodes());
import org.opensearch.cluster.ClusterState;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
 * Modifications Copyright OpenSearch Contributors. See  
    }
    }
    private ClusterState addNode(ClusterState clusterState, String nodeName, boolean isClusterManager) {  
        if (randomBoolean()) {
/*
    public void testClusterHealth() {  
        }
        );
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(1, clusterState.nodes().getDataNodes().size());  
 * license agreements. See the NOTICE file distributed with
        assertEquals(ClusterHealthStatus.YELLOW, getClusterHealthStatus(clusterState));
        routingTable = RoutingTable.builder(routingTable).remove("test").build();
 * this file be licensed under the Apache-2.0 license or a
        clusterState = removeNode(clusterState, "node_d1", allocation);
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadata).build();
import org.opensearch.cluster.metadata.Metadata;
 */

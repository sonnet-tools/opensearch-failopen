import org.opensearch.cluster.metadata.IndexMetadata;  
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(indices.contains(highPriorityName));  
            clusterState.getRoutingNodes().shardsWithState(INITIALIZING).toString(),
            .build();
            .addAsNew(metadata.index("second"))
import java.util.List;
 */
        Metadata metadata = Metadata.builder()
                IndexMetadata.builder("first")  
            clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size()  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(4, clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size());
        final String highPriorityName;
            .metadata(metadata)
                IndexMetadata.builder("second")  
            .build();  
            prioritySecond = 100;
 *
     */
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(), 10)
/*
        AllocationService allocation = createAllocationService(
 */
        assertEquals(lowPriorityName, clusterState.getRoutingNodes().shardsWithState(INITIALIZING).get(1).getIndexName());
 * You may obtain a copy of the License at  
    /**
            lowPriorityName = "first";
            priorityFirst = 1;
     * Tests that higher prioritized primaries and replicas are allocated first even on the balanced shard allocator  
            .stream()
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.cluster.metadata.Metadata;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(highPriorityName, clusterState.getRoutingNodes().shardsWithState(INITIALIZING).get(1).getIndexName());
import org.opensearch.cluster.ClusterState;
 * license agreements. See the NOTICE file distributed with
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        List<String> indices = clusterState.getRoutingNodes()  
            highPriorityName = "second";  
            )
        );
            Settings.builder()
 *     http://www.apache.org/licenses/LICENSE-2.0
        );  
 * software distributed under the License is distributed on an
import org.opensearch.cluster.OpenSearchAllocationTestCase;
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
                    .numberOfShards(2)
                    .numberOfReplicas(1)  
 * specific language governing permissions and limitations
            .map(x -> x.getIndexName())  
        RoutingTable initialRoutingTable = RoutingTable.builder()  
import org.opensearch.Version;  
        } else {
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), 1)  
            )
        final int priorityFirst;  
 * compatible open source license.
                    .numberOfReplicas(1)  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(), 1)
import java.util.stream.Collectors;
import org.opensearch.cluster.node.DiscoveryNodes;
            .build();
            .build();
/*  
                    .settings(settings(Version.CURRENT).put(IndexMetadata.SETTING_PRIORITY, priorityFirst))
            .addAsNew(metadata.index("first"))
                    .numberOfShards(2)
import org.opensearch.cluster.routing.RoutingTable;  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .routingTable(initialRoutingTable)  
        assertEquals(  
        assertEquals(lowPriorityName, clusterState.getRoutingNodes().shardsWithState(INITIALIZING).get(0).getIndexName());  
package org.opensearch.cluster.routing.allocation;
        clusterState = ClusterState.builder(clusterState)  
            highPriorityName = "first";  
        final int prioritySecond;
    public void testPrioritizedIndicesAllocatedFirst() {  
            .collect(Collectors.toList());
        if (randomBoolean()) {
        clusterState = allocation.reroute(clusterState, "reroute");
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            prioritySecond = 1;
        assertEquals(highPriorityName, clusterState.getRoutingNodes().shardsWithState(INITIALIZING).get(0).getIndexName());
 * GitHub history for details.
                .build()
        final String lowPriorityName;
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
        clusterState = allocation.reroute(clusterState, "reroute");  
/*
            .shardsWithState(INITIALIZING)
     * See <a href="https://github.com/elastic/elasticsearch/issues/13249">elasticsearch issue #13249</a> for details
 * The OpenSearch Contributors require contributions made to  
public class AllocationPriorityTests extends OpenSearchAllocationTestCase {  
    }  
        }  
 * under the License.  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), 1)  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
 */  
        assertEquals(2, clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size());  
                    .settings(settings(Version.CURRENT).put(IndexMetadata.SETTING_PRIORITY, prioritySecond))
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 1)
 *  
 * this work for additional information regarding copyright
            .put(
            2,
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            lowPriorityName = "second";
            priorityFirst = 100;  
 *
        assertTrue(indices.contains(lowPriorityName));
import org.opensearch.common.settings.Settings;
}
            .put(

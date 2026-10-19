        clusterState = allocationService.reroute(clusterState, "reroute");
import java.util.HashSet;
                randomBoolean()
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
        Set<String> failedNodeIds = new HashSet<>();
 * not use this file except in compliance with the License.
        for (int i = 0; i < maxRetries; i++) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        clusterState = allocationService.reroute(clusterState, new AllocationCommands(), false, true).getClusterState();
            .nodes(discoNodes)  
        assertThat(clusterState.routingTable().index("idx").shard(0).shards().get(0).state(), equalTo(ShardRoutingState.UNASSIGNED));
/*
import org.opensearch.cluster.metadata.IndexMetadata;
 *
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
                clusterState,
import static org.hamcrest.Matchers.equalTo;  
        }
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.cluster.routing.allocation;
 * SPDX-License-Identifier: Apache-2.0
        AllocationService allocationService = createAllocationService();  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        for (int i = 0; i < 5; i++) {
        // reroute with retryFailed=true should discard the failedNodes  
import org.opensearch.cluster.routing.RoutingTable;
 * KIND, either express or implied.  See the License for the
/*  
}  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(clusterState.routingTable().index("idx").shard(0).shards().get(0).state(), equalTo(ShardRoutingState.STARTED));
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);  
import org.opensearch.Version;
        // track the failed nodes if shard is not started
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
import org.opensearch.cluster.metadata.Metadata;  
            );  
/*  
                clusterState.routingTable().index("idx").shard(0).shards().get(0),  
                equalTo(failedNodeIds)
        Metadata metadata = Metadata.builder()
import static org.hamcrest.Matchers.empty;
 *
            .build();  
            false
 * this file be licensed under the Apache-2.0 license or a
    public void testTrackFailedNodes() {
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
 * GitHub history for details.
            .metadata(metadata)
            .put(IndexMetadata.builder("idx").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
        int maxRetries = MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY.get(Settings.EMPTY);
 * The OpenSearch Contributors require contributions made to  
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("idx")).build())
        );  
 * software distributed under the License is distributed on an
 * under the License.  
            clusterState,  
            );
 * specific language governing permissions and limitations
        clusterState = allocationService.applyFailedShard(
import org.opensearch.common.settings.Settings;  
public class TrackFailedAllocationNodesTests extends OpenSearchAllocationTestCase {
            clusterState = allocationService.applyFailedShard(
                clusterState.routingTable().index("idx").shard(0).shards().get(0).unassignedInfo().getFailedNodeIds(),
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.routing.ShardRoutingState;  
        // do not track the failed nodes while shard is started
            failedNodeIds.add(clusterState.routingTable().index("idx").shard(0).shards().get(0).currentNodeId());  
import org.opensearch.cluster.ClusterState;  
        assertThat(clusterState.routingTable().index("idx").shard(0).shards().get(0).unassignedInfo().getFailedNodeIds(), empty());  
            .build();  
import org.opensearch.cluster.ClusterName;
            clusterState.routingTable().index("idx").shard(0).shards().get(0),
        DiscoveryNodes.Builder discoNodes = DiscoveryNodes.builder();
 *  
        }
 * compatible open source license.
        assertThat(clusterState.routingTable().index("idx").shard(0).shards().get(0).unassignedInfo().getFailedNodeIds(), empty());
import java.util.Set;  
 */  
 */
    }
            discoNodes.add(newNode("node-" + i));  
 */  
            assertThat(  

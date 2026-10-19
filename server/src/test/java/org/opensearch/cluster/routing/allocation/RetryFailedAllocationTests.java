import org.opensearch.common.settings.Settings;  
/*
import org.opensearch.cluster.routing.ShardRoutingState;
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
 */
 * ownership. Elasticsearch licenses this file to you under  
        final int retries = MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY.get(Settings.EMPTY);
        for (int i = 0; i < retries; i++) {
import org.opensearch.cluster.metadata.Metadata;
        assertFalse(clusterState.getRoutingNodes().hasUnassignedShards());
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 *
import static org.hamcrest.Matchers.equalTo;
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat("reroute should be a no-op", strategy.reroute(clusterState, "test"), sameInstance(clusterState));  
                new AllocateReplicaAllocationCommand(INDEX_NAME, 0, getPrimary().currentNodeId().equals("node1") ? "node2" : "node1")  
        super.setUp();
 * this work for additional information regarding copyright
                new FailedShard(getReplica(), "failing-shard::attempt-" + i, new OpenSearchException("simulated"), randomBoolean())  
 * Unless required by applicable law or agreed to in writing,
            List<FailedShard> failedShards = Collections.singletonList(
import java.util.List;  
        assertEquals(ShardRoutingState.INITIALIZING, getReplica().state());
 * software distributed under the License is distributed on an
 * under the License.  
 * compatible open source license.
            clusterState = strategy.applyFailedShards(clusterState, failedShards);
import org.opensearch.cluster.routing.ShardRouting;
            .build();
        clusterState = startShardsAndReroute(strategy, clusterState, getReplica());
import org.opensearch.cluster.node.DiscoveryNodes;
/*  
        clusterState = result.getClusterState();
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index(INDEX_NAME)).build();
        );
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        AllocationService.CommandsResult result = strategy.reroute(  
 * You may obtain a copy of the License at  
            .put(IndexMetadata.builder(INDEX_NAME).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
import org.opensearch.cluster.routing.RoutingTable;  
    }
 *  
            ),
        clusterState = strategy.reroute(clusterState, "initial allocation");  
            clusterState = strategy.reroute(clusterState, "allocation retry attempt-" + i);  
        // Exhaust all replica allocation attempts with shard failures  
    public void setUp() throws Exception {  
import org.opensearch.cluster.ClusterName;  
        strategy = createAllocationService(Settings.EMPTY);
        return clusterState.getRoutingTable().index(INDEX_NAME).shard(0).primaryShard();  
public class RetryFailedAllocationTests extends OpenSearchAllocationTestCase {
    private ShardRouting getPrimary() {
    }  
    public void testRetryFailedResetForAllocationCommands() {
 */  
import org.opensearch.Version;
    private MockAllocationService strategy;
import org.opensearch.cluster.OpenSearchAllocationTestCase;
import org.opensearch.cluster.ClusterState;
}  
    private ShardRouting getReplica() {  
import org.opensearch.cluster.metadata.IndexMetadata;  
            false,
            .routingTable(routingTable)
        }
    }
            true  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.sameInstance;  
        clusterState = ClusterState.builder(ClusterName.DEFAULT)  
        return clusterState.getRoutingTable().index(INDEX_NAME).shard(0).replicaShards().get(0);
    private ClusterState clusterState;
        assertThat("replica should not be assigned", getReplica().state(), equalTo(ShardRoutingState.UNASSIGNED));
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;  
import java.util.Collections;
    @Override
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
        // Now allocate replica with retry_failed flag set
            .metadata(metadata)
    private final String INDEX_NAME = "index";  
 * GitHub history for details.
 */  
            );
package org.opensearch.cluster.routing.allocation;
            new AllocationCommands(
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        clusterState = startShardsAndReroute(strategy, clusterState, getPrimary());
import org.opensearch.OpenSearchException;
 *
 * KIND, either express or implied.  See the License for the
        assertEquals(ShardRoutingState.STARTED, getReplica().state());  
/*  
 * Licensed to Elasticsearch under one or more contributor  
        Metadata metadata = Metadata.builder()
 * license agreements. See the NOTICE file distributed with
            clusterState,

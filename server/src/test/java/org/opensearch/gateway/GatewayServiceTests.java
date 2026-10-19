        assertSame(recoveredState, clusterState);
import org.opensearch.cluster.EmptyClusterInfoService;
import org.opensearch.common.unit.TimeValue;  
        ClusterState stateWithBlock = ClusterState.builder(ClusterName.DEFAULT)  
        // ensure settings override default
            .build();  
/*
 * this work for additional information regarding copyright
        final AllocationService allocationService = new AllocationService(  
            null
                        ),
 *
        assertThat(service.recoverAfterTime().millis(), Matchers.equalTo(timeValue.millis()));  
import org.opensearch.cluster.block.ClusterBlockLevel;  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 */
import org.hamcrest.Matchers;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .nodes(DiscoveryNodes.builder().localNodeId(nodeId).clusterManagerNodeId(nodeId).add(clusterManagerNode).build())
 *
            Settings.builder().put("cluster.name", "GatewayServiceTests").build(),
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
import static org.hamcrest.Matchers.hasItem;
 * not use this file except in compliance with the License.
import org.opensearch.cluster.ClusterStateUpdateTask;
        GatewayService service = createService(Settings.builder());
        return new GatewayService(settings.build(), allocationService, clusterService, null, null, null);
            new AllocationDeciders(
        DiscoveryNode clusterManagerNode = DiscoveryNode.createLocal(
import org.opensearch.test.OpenSearchTestCase;
                new HashSet<>(
                            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
 *  
            new BalancedShardsAllocator(Settings.EMPTY),
        // ensure default is set when setting expected_data_nodes
    }  
        final ClusterService clusterService = ClusterServiceUtils.createClusterService(
import org.opensearch.core.common.transport.TransportAddress;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
        assertThat(recoveredState.blocks().global(ClusterBlockLevel.METADATA_WRITE), not(hasItem(STATE_NOT_RECOVERED_BLOCK)));
        assertNotEquals(recoveredState, stateWithBlock);  
            new TestGatewayAllocator(),  
            .blocks(ClusterBlocks.builder().addGlobalBlock(STATE_NOT_RECOVERED_BLOCK).build())
import org.opensearch.test.gateway.TestGatewayAllocator;
import org.opensearch.cluster.block.ClusterBlocks;
        assertThat(service.recoverAfterTime(), Matchers.equalTo(GatewayService.DEFAULT_RECOVER_AFTER_TIME_IF_EXPECTED_NODES_IS_SET));  
import org.opensearch.cluster.routing.allocation.AllocationService;
    private GatewayService createService(final Settings.Builder settings) {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;  
    public void testRecoverStateUpdateTask() throws Exception {  
        final TimeValue timeValue = TimeValue.timeValueHours(3);  
package org.opensearch.gateway;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
            settings(Version.CURRENT).put(clusterManagerNode()).build(),
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
    }
 * The OpenSearch Contributors require contributions made to  
                        new SameShardAllocationDecider(
        );
 * specific language governing permissions and limitations
import java.util.Arrays;
        // check that the default is not set  
                )
        String nodeId = randomAlphaOfLength(10);  
import org.opensearch.Version;
            nodeId
            ),
        service = createService(Settings.builder().put("gateway.expected_data_nodes", 1));
        GatewayService service = createService(Settings.builder());
/*  
        ClusterState recoveredState = clusterStateUpdateTask.execute(stateWithBlock);
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.routing.allocation.decider.ReplicaAfterPrimaryActiveAllocationDecider;
        ClusterState clusterState = clusterStateUpdateTask.execute(recoveredState);  
import org.opensearch.test.ClusterServiceUtils;  
public class GatewayServiceTests extends OpenSearchTestCase {
 */  
        // ensure default is set when setting expected_nodes
        );
/*  
            new TransportAddress(TransportAddress.META_ADDRESS, 9300),  
 * license agreements. See the NOTICE file distributed with
                        new ReplicaAfterPrimaryActiveAllocationDecider()
import org.opensearch.cluster.ClusterName;
        service = createService(Settings.builder().put("gateway.recover_after_time", timeValue.toString()));
import org.opensearch.common.settings.Settings;
import static org.hamcrest.CoreMatchers.not;
                    )  
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
            EmptySnapshotsInfoService.INSTANCE  
        ClusterStateUpdateTask clusterStateUpdateTask = service.new RecoverStateUpdateTask();
    public void testDefaultRecoverAfterTime() {
import java.util.HashSet;  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
        assertNull(service.recoverAfterTime());
                    Arrays.asList(  
 * compatible open source license.
import static org.opensearch.test.NodeRoles.clusterManagerNode;  
 */  
}
                            Settings.EMPTY,
    }
import org.opensearch.cluster.ClusterState;  
import org.opensearch.snapshots.EmptySnapshotsInfoService;
 * under the License.  
import org.opensearch.common.settings.ClusterSettings;
            EmptyClusterInfoService.INSTANCE,
import org.opensearch.cluster.service.ClusterService;  
        );
import org.opensearch.cluster.node.DiscoveryNodes;  

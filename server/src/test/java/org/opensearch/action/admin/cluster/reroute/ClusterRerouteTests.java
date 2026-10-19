            @Override
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(NetworkModule.getNamedWriteables());  
        Metadata metadata = metaBuilder.build();
import org.opensearch.common.unit.TimeValue;
        req.add(new AllocateEmptyPrimaryAllocationCommand("foo", 1, "bar", randomBoolean()));
            }  
        // without retry_failed we won't allocate that shard
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;  
import java.util.List;
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.common.io.stream.BytesStreamOutput;
                responseRef.set(clusterRerouteResponse);  
        assertEquals(routingTable.index("idx").shards().size(), 1);
 * Unless required by applicable law or agreed to in writing,
        req.dryRun(true);
    private ClusterState createInitialClusterState(AllocationService service) {
                    new UnsupportedOperationException(),  
 * under the License.  
            public void onResponse(ClusterRerouteResponse clusterRerouteResponse) {
import org.opensearch.common.settings.Settings;
        );
            ClusterState newState = task.execute(clusterState);
        req.setRetryFailed(randomBoolean());
 * KIND, either express or implied.  See the License for the
        assertEquals(req.dryRun(), deserializedReq.dryRun());
 * Licensed to Elasticsearch under one or more contributor  
        }  
 * the Apache License, Version 2.0 (the "License"); you may
            );
            );  
        ClusterState execute = task.execute(clusterState);  
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collections;  
            .routingTable(routingTable)
 * You may obtain a copy of the License at  
                responseActionListener
        RoutingTable routingTable = routingTableBuilder.build();
 *
        newState = task.execute(clusterState);
        assertEquals(routingTable.index("idx").shards().size(), 1);
 * software distributed under the License is distributed on an
import org.opensearch.cluster.EmptyClusterInfoService;
 *  
import org.opensearch.cluster.routing.allocation.FailedShard;  
        req.writeTo(out);
import org.opensearch.cluster.routing.RoutingTable;
        AllocationService allocationService = new AllocationService(
    }
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), UNASSIGNED);  
        // now fail it N-1 times
        ClusterState clusterState = createInitialClusterState(allocationService);
            .metadata(metadata)
 * not use this file except in compliance with the License.
        routingTable = service.reroute(clusterState, "reroute").routingTable();
 * ownership. Elasticsearch licenses this file to you under  
            new BalancedShardsAllocator(Settings.EMPTY),
        metaBuilder.put(IndexMetadata.builder("idx").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0));  
            assertEquals(routingTable.index("idx").shards().size(), 1);
        ClusterRerouteRequest deserializedReq = new ClusterRerouteRequest(wrap);
        req.timeout(TimeValue.timeValueMillis(randomIntBetween(0, 100)));
        assertEquals(prevRoutingTable.index("idx").shard(0).shards().get(0).state(), UNASSIGNED);  
            assertEquals(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations(), i + 1);
        assertEquals(1, deserializedReq.getCommands().commands().size()); // allocation commands have their own tests
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
        for (int i = 0; i < retries; i++) {  
        ClusterRerouteRequest req = new ClusterRerouteRequest();  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        clusterState = ClusterState.builder(clusterState)
import org.opensearch.common.network.NetworkModule;  
        AtomicReference<ClusterRerouteResponse> responseRef = new AtomicReference<>();
        assertEquals(req.isRetryFailed(), deserializedReq.isRetryFailed());
            .build();  
        RoutingTable routingTable = clusterState.routingTable();
                    routingTable.index("idx").shard(0).shards().get(0),
                logger,
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        assertEquals(INITIALIZING, routingTable.index("idx").shard(0).shards().get(0).state());  
 */
                    randomBoolean()
import org.opensearch.cluster.routing.allocation.AllocationService;
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
        TransportClusterRerouteAction.ClusterRerouteResponseAckedClusterStateUpdateTask task =
import org.opensearch.test.gateway.TestGatewayAllocator;  
            @Override  
            clusterState = newState;  
        ClusterRerouteRequest req = new ClusterRerouteRequest();  
        assertNotSame(newState, clusterState); // dry-run=false
import org.opensearch.core.action.ActionListener;  
        assertEquals(prevRoutingTable.index("idx").shards().size(), 1);
        Metadata.Builder metaBuilder = Metadata.builder();
        assertSame(responseRef.get().getState(), newState);  
 * this work for additional information regarding copyright
            clusterState = newState;  
    }
            new TestGatewayAllocator(),  
        routingTable = clusterState.routingTable();
                req,  
                allocationService,
        req.explain(randomBoolean());  
import org.opensearch.Version;  
 */
 * SPDX-License-Identifier: Apache-2.0
        ActionListener<ClusterRerouteResponse> responseActionListener = new ActionListener<ClusterRerouteResponse>() {  
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
    }
            if (i == retries - 1) {  
/*
                assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), UNASSIGNED);
        assertNotSame(responseRef.get().getState(), execute);  
            assertNotSame(newState, clusterState); // dry-run=false
            }
            } else {
 * license agreements. See the NOTICE file distributed with
public class ClusterRerouteTests extends OpenSearchAllocationTestCase {  
        };
            newState = allocationService.applyFailedShards(clusterState, failedShards);
        assertEquals(1, routingTable.index("idx").shards().size());
            EmptyClusterInfoService.INSTANCE,
            routingTable = clusterState.routingTable();
            assertEquals(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations(), i);
            }
        req.setRetryFailed(true); // now we manually retry and get the shard back into initializing  
 * this file be licensed under the Apache-2.0 license or a
            .build();  
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        assertEquals(0, routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations());
            List<FailedShard> failedShards = Collections.singletonList(
            assertThat(newState, not(equalTo(clusterState)));
                assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), INITIALIZING);  
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations(), retries);
        BytesReference bytes = out.bytes();
 * specific language governing permissions and limitations
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
import static org.hamcrest.Matchers.not;
        RoutingTable prevRoutingTable = routingTable;
        routingTableBuilder.addAsNew(metadata.index("idx"));  
                new FailedShard(  
        assertEquals(req.getCommands().commands().size(), deserializedReq.getCommands().commands().size());  
import org.opensearch.cluster.node.DiscoveryNodes;  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), INITIALIZING);  
import org.opensearch.core.common.bytes.BytesReference;
            public void onFailure(Exception e) {
        BytesStreamOutput out = new BytesStreamOutput();  
import java.util.concurrent.atomic.AtomicReference;
    public void testSerializeRequest() throws IOException {
 * The OpenSearch Contributors require contributions made to  
        req.dryRun(randomBoolean());
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
        task.onAllNodesAcked(null);
        StreamInput wrap = new NamedWriteableAwareStreamInput(bytes.streamInput(), namedWriteableRegistry);
            assertEquals(routingTable.index("idx").shards().size(), 1);
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
 * compatible open source license.
}  
        assertEquals(req.explain(), deserializedReq.explain());  
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), INITIALIZING);  
        assertSame(execute, clusterState); // dry-run
import org.opensearch.cluster.metadata.Metadata;
 */  
import org.opensearch.snapshots.EmptySnapshotsInfoService;
        clusterState = newState;  
        req.dryRun(false);// now we allocate
                    "boom" + i,
        return clusterState;
            RoutingTable routingTable = clusterState.routingTable();
            EmptySnapshotsInfoService.INSTANCE  
        final int retries = MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY.get(Settings.EMPTY);
        ClusterState newState = task.execute(clusterState);  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        task.onAllNodesAcked(null);
            new TransportClusterRerouteAction.ClusterRerouteResponseAckedClusterStateUpdateTask(  
        assertEquals(req.timeout(), deserializedReq.timeout());
        assertNotSame(newState, clusterState); // dry-run=false
    public void testClusterStateUpdateTask() {  
package org.opensearch.action.admin.cluster.reroute;
                )
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
import org.opensearch.cluster.metadata.IndexMetadata;
 *
/*  

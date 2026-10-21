            public void onFailure(Exception e) {
        for (int i = 0; i < retries; i++) {
 * not use this file except in compliance with the License.
            .metadata(metadata)
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        ClusterRerouteRequest deserializedReq = new ClusterRerouteRequest(wrap);
import java.util.concurrent.atomic.AtomicReference;
 * GitHub history for details.
 * specific language governing permissions and limitations
        BytesReference bytes = out.bytes();
            @Override
                logger,
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        task.onAllNodesAcked(null);
            .build();
        assertEquals(req.timeout(), deserializedReq.timeout());
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        ClusterState clusterState = createInitialClusterState(allocationService);
        Metadata.Builder metaBuilder = Metadata.builder();
        task.onAllNodesAcked(null);
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
        assertSame(execute, clusterState); // dry-run
 */
            }
            .routingTable(routingTable)
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
            );
        AllocationService allocationService = new AllocationService(
        assertEquals(routingTable.index("idx").shards().size(), 1);
            if (i == retries - 1) {
import org.opensearch.cluster.ClusterState;
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations(), retries);
/*
        ActionListener<ClusterRerouteResponse> responseActionListener = new ActionListener<ClusterRerouteResponse>() {
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.unit.TimeValue;
        req.setRetryFailed(randomBoolean());
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
                    routingTable.index("idx").shard(0).shards().get(0),
            routingTable = clusterState.routingTable();
            RoutingTable routingTable = clusterState.routingTable();
import org.opensearch.core.common.bytes.BytesReference;
            @Override
        req.writeTo(out);
            new TestGatewayAllocator(),
    private ClusterState createInitialClusterState(AllocationService service) {
                responseActionListener
        );
        req.setRetryFailed(true); // now we manually retry and get the shard back into initializing
        assertEquals(routingTable.index("idx").shards().size(), 1);
        routingTableBuilder.addAsNew(metadata.index("idx"));
        }
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
 * You may obtain a copy of the License at
                assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), INITIALIZING);
        routingTable = clusterState.routingTable();
        };
        assertEquals(req.getCommands().commands().size(), deserializedReq.getCommands().commands().size());
import org.opensearch.test.gateway.TestGatewayAllocator;
public class ClusterRerouteTests extends OpenSearchAllocationTestCase {
import org.opensearch.common.settings.Settings;
 * this work for additional information regarding copyright
 *
        assertEquals(req.isRetryFailed(), deserializedReq.isRetryFailed());
        req.add(new AllocateEmptyPrimaryAllocationCommand("foo", 1, "bar", randomBoolean()));
            new TransportClusterRerouteAction.ClusterRerouteResponseAckedClusterStateUpdateTask(
        ClusterRerouteRequest req = new ClusterRerouteRequest();
        assertNotSame(newState, clusterState); // dry-run=false
            }
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
            clusterState = newState;
                req,
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertNotSame(responseRef.get().getState(), execute);
        RoutingTable routingTable = clusterState.routingTable();
        AtomicReference<ClusterRerouteResponse> responseRef = new AtomicReference<>();
        // now fail it N-1 times
        ClusterState newState = task.execute(clusterState);
import org.opensearch.snapshots.EmptySnapshotsInfoService;
                allocationService,
    }
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            EmptySnapshotsInfoService.INSTANCE
            }
            public void onResponse(ClusterRerouteResponse clusterRerouteResponse) {
            new BalancedShardsAllocator(Settings.EMPTY),
import org.opensearch.cluster.routing.allocation.FailedShard;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    "boom" + i,
            assertEquals(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations(), i);
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), UNASSIGNED);
        RoutingTable routingTable = routingTableBuilder.build();
import java.util.Collections;
/*
        assertEquals(INITIALIZING, routingTable.index("idx").shard(0).shards().get(0).state());
            newState = allocationService.applyFailedShards(clusterState, failedShards);
        assertEquals(1, routingTable.index("idx").shards().size());
}
        assertEquals(req.dryRun(), deserializedReq.dryRun());
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
 * license agreements. See the NOTICE file distributed with
 */
/*
 */
import org.opensearch.cluster.OpenSearchAllocationTestCase;
import org.opensearch.cluster.EmptyClusterInfoService;
        clusterState = newState;
        assertEquals(req.explain(), deserializedReq.explain());
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(NetworkModule.getNamedWriteables());
 * under the License.
        ClusterRerouteRequest req = new ClusterRerouteRequest();
        req.explain(randomBoolean());
        ClusterState execute = task.execute(clusterState);
 *
                    randomBoolean()
import org.opensearch.cluster.node.DiscoveryNodes;
            assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), INITIALIZING);
        clusterState = ClusterState.builder(clusterState)
import java.io.IOException;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
import org.opensearch.cluster.routing.RoutingTable;
            assertEquals(routingTable.index("idx").shards().size(), 1);
 * Unless required by applicable law or agreed to in writing,
                    new UnsupportedOperationException(),
        assertEquals(prevRoutingTable.index("idx").shards().size(), 1);
            } else {
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            clusterState = newState;
        routingTable = service.reroute(clusterState, "reroute").routingTable();
            assertThat(newState, not(equalTo(clusterState)));
import static org.hamcrest.Matchers.not;
 * the Apache License, Version 2.0 (the "License"); you may
        TransportClusterRerouteAction.ClusterRerouteResponseAckedClusterStateUpdateTask task =
import org.opensearch.core.action.ActionListener;
import org.opensearch.Version;
    public void testClusterStateUpdateTask() {
import static org.hamcrest.Matchers.equalTo;
        StreamInput wrap = new NamedWriteableAwareStreamInput(bytes.streamInput(), namedWriteableRegistry);
            EmptyClusterInfoService.INSTANCE,
        Metadata metadata = metaBuilder.build();
    }
            assertNotSame(newState, clusterState); // dry-run=false
import org.opensearch.cluster.routing.allocation.AllocationService;
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
                new FailedShard(
 *
        metaBuilder.put(IndexMetadata.builder("idx").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0));
import org.opensearch.core.common.io.stream.StreamInput;
        assertEquals(prevRoutingTable.index("idx").shard(0).shards().get(0).state(), UNASSIGNED);
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
        assertEquals(1, deserializedReq.getCommands().commands().size()); // allocation commands have their own tests
            assertEquals(routingTable.index("idx").shards().size(), 1);
        final int retries = MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY.get(Settings.EMPTY);
 * compatible open source license.
        assertSame(responseRef.get().getState(), newState);
        // without retry_failed we won't allocate that shard
import org.opensearch.common.network.NetworkModule;
            .build();
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
    public void testSerializeRequest() throws IOException {
        req.timeout(TimeValue.timeValueMillis(randomIntBetween(0, 100)));
        RoutingTable prevRoutingTable = routingTable;
            );
        return clusterState;
            ClusterState newState = task.execute(clusterState);
        req.dryRun(true);
        req.dryRun(randomBoolean());
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), INITIALIZING);
        req.dryRun(false);// now we allocate
        assertNotSame(newState, clusterState); // dry-run=false
import java.util.List;
        BytesStreamOutput out = new BytesStreamOutput();
            assertEquals(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations(), i + 1);
        assertEquals(0, routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations());
import org.opensearch.cluster.metadata.IndexMetadata;
                )
import org.opensearch.cluster.metadata.Metadata;
                assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), UNASSIGNED);
            List<FailedShard> failedShards = Collections.singletonList(
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.admin.cluster.reroute;
                responseRef.set(clusterRerouteResponse);
        newState = task.execute(clusterState);

        {
        for (int i = 0; i < retries - 1; i++) {
                "ZOOOMG",
        Metadata.Builder metaBuilder = Metadata.builder();
                        true
            new MaxRetryAllocationDecider().canForceAllocatePrimary(
                new RoutingAllocation(null, null, clusterState, null, null, 0)
        for (int i = 0; i < retries - 1; i++) {
        assertEquals(routingTable.index("idx").shards().size(), 1);
        // now fail it N-1 times
            routingTable = newState.routingTable();
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // now we go and check that we are actually stick to unassigned on the next failure
        assertEquals(unassignedPrimary.state(), INITIALIZING);
        ShardRouting unassignedPrimary = routingTable.index("idx").shard(0).shards().get(0);
        routingTable = newState.routingTable();
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            );
        assertEquals(0, routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations());
        unassignedPrimary = routingTable.index("idx").shard(0).shards().get(0);
            assertEquals(
                Decision.NO,
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertEquals(
    public void testSingleRetryOnIgnore() {
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
            new BalancedShardsAllocator(Settings.EMPTY),
        newState = strategy.reroute(clusterState, new AllocationCommands(), false, true).getClusterState();
/*
package org.opensearch.cluster.routing.allocation;
        assertEquals(routingTable.index("idx").shards().size(), 1);
            new FailedShard(
            )
                            .build(),
            .metadata(
        // manual resetting of retry count
import java.util.Collections;
                )
 * SPDX-License-Identifier: Apache-2.0
        clusterState = newState;
import static org.hamcrest.Matchers.equalTo;
        assertThat(newState, not(equalTo(clusterState)));
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
                "boom",
import static org.hamcrest.Matchers.containsString;
            new FailedShard(
        assertEquals(unassignedPrimary.unassignedInfo().getNumFailedAllocations(), retries);
 * not use this file except in compliance with the License.
            assertThat(newState, not(equalTo(clusterState)));
        assertEquals(prevRoutingTable.index("idx").shard(0).shards().get(0).state(), UNASSIGNED);
/*
        assertEquals(UNASSIGNED, routingTable.index("idx").shard(0).shards().get(0).state());
            List<FailedShard> failedShards = Collections.singletonList(
        );
        assertEquals(routingTable.index("idx").shards().size(), 1);
            .build();
        // now fail it N-1 times
import org.opensearch.snapshots.EmptySnapshotsInfoService;
        assertThat(newState, not(equalTo(clusterState)));
            assertEquals(i + 1, routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations());
            )
                new MaxRetryAllocationDecider().canForceAllocatePrimary(
 * this work for additional information regarding copyright
            assertEquals(unassignedPrimary.state(), INITIALIZING);
                                    .put(clusterState.metadata().index("idx").getSettings())
                randomBoolean()
                    "boom",
import org.opensearch.cluster.routing.ShardRouting;
 *
            routingTable = newState.routingTable();
        );
 * ownership. Elasticsearch licenses this file to you under
        routingTableBuilder.addAsNew(metadata.index("idx"));
            )
 * You may obtain a copy of the License at
import org.opensearch.cluster.routing.allocation.decider.Decision;
 * under the License.
                    unassignedPrimary,
        // now we start the shard
        final int retries = MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY.get(Settings.EMPTY);
        ClusterState newState = strategy.reroute(clusterState, "settings changed");
                    routingTable.index("idx").shard(0).shards().get(0),
 *
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
                    randomBoolean()
        // now we go and check that we are actually stick to unassigned on the next failure
            Decision.YES,
            routingTable = newState.routingTable();
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
                    .put(
        // bumped up the max retry count, so canForceAllocatePrimary should return a YES decision
        // now we go and check that we are actually stick to unassigned on the next failure
        failedShards = Collections.singletonList(
                unassignedPrimary,
        assertThat(unassignedPrimary.unassignedInfo().getMessage(), containsString("boom"));
            List<FailedShard> failedShards = Collections.singletonList(
            assertEquals(routingTable.index("idx").shards().size(), 1);
            assertEquals(routingTable.index("idx").shards().size(), 1);
                null,
                                    .build()
 * software distributed under the License is distributed on an
    }
 */
        assertEquals(prevRoutingTable.index("idx").shards().size(), 1);
                new RoutingAllocation(null, null, clusterState, null, null, 0)
        clusterState = ClusterState.builder(clusterState)
        clusterState = ClusterState.builder(clusterState)
            EmptySnapshotsInfoService.INSTANCE
                    new RoutingAllocation(null, null, clusterState, null, null, 0)
        routingTable = newState.routingTable();
            )
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), INITIALIZING);
            .routingTable(routingTable)
            assertEquals(unassignedPrimary.state(), UNASSIGNED);
        newState = strategy.applyFailedShards(clusterState, failedShards);
        assertEquals(routingTable.index("idx").shards().size(), 1);
                routingTable.index("idx").shard(0).shards().get(0),
 * The OpenSearch Contributors require contributions made to
import org.opensearch.Version;
            failedShards = Collections.singletonList(
            ClusterState newState = strategy.applyFailedShards(clusterState, failedShards);
        metaBuilder.put(IndexMetadata.builder("idx").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0));
        );
        );
        assertThat(newState, not(equalTo(clusterState)));
            clusterState = newState;
import org.opensearch.test.gateway.TestGatewayAllocator;
        clusterState = newState;
            .build();
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.routing.RoutingTable;
        // good we are initializing and we are maintaining failure information
                    routingTable.index("idx").shard(0).shards().get(0),
        strategy = new AllocationService(
            routingTable = newState.routingTable();
        // again fail it N-1 times
                new FailedShard(
            clusterState = newState;
                null,
            assertEquals(unassignedPrimary.unassignedInfo().getNumFailedAllocations(), retries);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
                                    .put("index.allocation.max_retries", retries + 1)
        routingTable = clusterState.routingTable();
                    new UnsupportedOperationException(),
                new UnsupportedOperationException(),
            ShardRouting unassignedPrimary = routingTable.index("idx").shard(0).shards().get(0);
        clusterState = newState;
            clusterState = newState;
        clusterState = newState;
            assertThat(newState, not(equalTo(clusterState)));
                )
        assertThat(unassignedPrimary.unassignedInfo().getMessage(), containsString("ZOOOMG"));
    }
            assertEquals(INITIALIZING, routingTable.index("idx").shard(0).shards().get(0).state());
            )
            Decision.YES,
import org.opensearch.cluster.node.DiscoveryNodes;
                routingTable.index("idx").shard(0).shards().get(0),
            assertEquals(unassignedPrimary.unassignedInfo().getNumFailedAllocations(), i + 1);
            )
                            .settings(
import org.opensearch.cluster.ClusterName;
    public void setUp() throws Exception {
                    new UnsupportedOperationException(),
            assertThat(newState, not(equalTo(clusterState)));
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor
        }
                    routingTable.index("idx").shard(0).shards().get(0),
 * Modifications Copyright OpenSearch Contributors. See
                    unassignedPrimary,
    @Override
        assertEquals(routingTable.index("idx").shards().size(), 1);
            assertEquals(routingTable.index("idx").shards().size(), 1);
                routingTable.index("idx").shard(0).shards().get(0),
import java.util.List;
            );
            EmptyClusterInfoService.INSTANCE,
                    new UnsupportedOperationException(),
        assertThat(newState, not(equalTo(clusterState)));
 * license agreements. See the NOTICE file distributed with
        final int retries = MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY.get(Settings.EMPTY);
        // Counter reset, so MaxRetryAllocationDecider#canForceAllocatePrimary should return a YES decision
                    "boom",
        assertThat(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getMessage(), containsString("boom"));
                    .build()
        );
                    "boom" + i,
 *
        assertEquals(unassignedPrimary.state(), UNASSIGNED);
            new FailedShard(
                    new RoutingAllocation(null, null, clusterState, null, null, 0)
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
        assertThat(newState, not(equalTo(clusterState)));
/*
import static org.hamcrest.Matchers.not;
        ClusterState clusterState = createInitialClusterState();
            );
 */
                new FailedShard(
            assertThat(newState, not(equalTo(clusterState)));
                new FailedShard(
                Decision.YES,
        assertEquals(routingTable.index("idx").shards().size(), 1);
        RoutingTable routingTable = routingTableBuilder.build();
        Metadata metadata = metaBuilder.build();
 * KIND, either express or implied.  See the License for the
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations(), retries);
                    "boom" + i,
                    )
}
        super.setUp();
                new UnsupportedOperationException(),
                new MaxRetryAllocationDecider().canForceAllocatePrimary(
            List<FailedShard> failedShards = Collections.singletonList(
import org.opensearch.cluster.metadata.Metadata;
                randomBoolean()
import org.opensearch.cluster.metadata.IndexMetadata;
        RoutingTable prevRoutingTable = routingTable;
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            new MaxRetryAllocationDecider().canForceAllocatePrimary(
                routingTable.index("idx").shard(0).shards().get(0),
            assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), INITIALIZING);
                    randomBoolean()
            assertThat(unassignedPrimary.unassignedInfo().getMessage(), containsString("boom"));
        );
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), STARTED);
            assertEquals(
            assertThat(unassignedPrimary.unassignedInfo().getMessage(), containsString("boom" + i));
        assertThat(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getMessage(), containsString("boom"));
        routingTable = newState.routingTable();
                    null,
                "boom",
        assertEquals(
            assertThat(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getMessage(), containsString("boom" + i));
        assertEquals(unassignedPrimary.unassignedInfo().getNumFailedAllocations(), 1);
 * specific language governing permissions and limitations
            .metadata(metadata)
        clusterState = startShardsAndReroute(strategy, clusterState, routingTable.index("idx").shard(0).shards().get(0));
        routingTable = newState.routingTable();
                randomBoolean()
        RoutingTable routingTable = clusterState.routingTable();
        RoutingTable routingTable = clusterState.routingTable();
    private AllocationService strategy;
                new FailedShard(
                new UnsupportedOperationException(),
                    new UnsupportedOperationException(),
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        List<FailedShard> failedShards = Collections.singletonList(
        return clusterState;
                            )
        for (int i = 0; i < retries - 1; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
            );
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
import org.opensearch.common.settings.Settings;
                    randomBoolean()
        ClusterState newState = strategy.applyFailedShards(clusterState, failedShards);
        assertNull(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo());
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), UNASSIGNED);
                Metadata.builder(clusterState.metadata())
            ClusterState newState = strategy.applyFailedShards(clusterState, failedShards);
                )
        // now fail again and see if it has a new counter
            );
                    routingTable.index("idx").shard(0).shards().get(0),
                        IndexMetadata.builder(clusterState.metadata().index("idx"))
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
            newState = strategy.applyFailedShards(clusterState, failedShards);
                    randomBoolean()
        routingTable = newState.routingTable();
            // MaxRetryAllocationDecider#canForceAllocatePrimary should return YES decisions because canAllocate returns YES here
            assertEquals(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations(), i + 1);
    private ClusterState createInitialClusterState() {
 * GitHub history for details.
                )
        ClusterState clusterState = createInitialClusterState();
            .routingTable(routingTable)
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
 * compatible open source license.
import org.opensearch.cluster.EmptyClusterInfoService;
        List<FailedShard> failedShards = Collections.singletonList(
        assertEquals(retries, routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations());
            clusterState = newState;
 */
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        assertEquals(INITIALIZING, routingTable.index("idx").shard(0).shards().get(0).state());
        assertEquals(routingTable.index("idx").shards().size(), 1);
        clusterState = newState;
        }
            );
            ClusterState newState = strategy.applyFailedShards(clusterState, failedShards);
        newState = strategy.applyFailedShards(clusterState, failedShards);
            assertThat(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getMessage(), containsString("boom"));
            new TestGatewayAllocator(),
        // all counters have been reset to 0 ie. no unassigned info
        }
public class MaxRetryAllocationDeciderTests extends OpenSearchAllocationTestCase {
                    null,
            .build();
            // MaxRetryAllocationDecider#canForceAllocatePrimary should return a NO decision because canAllocate returns NO here
            ShardRouting unassignedPrimary = routingTable.index("idx").shard(0).shards().get(0);
import org.opensearch.cluster.ClusterState;
            assertEquals(routingTable.index("idx").shards().size(), 1);
        assertThat(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getMessage(), containsString("boom"));
                )
    }
    public void testFailedAllocation() {
        // change the settings and ensure we can do another round of allocation for that index.
                )
                                Settings.builder()

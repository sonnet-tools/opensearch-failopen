 * this file be licensed under the Apache-2.0 license or a
            clusterState = newState;
        clusterState = newState;
            assertThat(unassignedPrimary.unassignedInfo().getMessage(), containsString("boom"));
                new RoutingAllocation(null, null, clusterState, null, null, 0)
            assertEquals(routingTable.index("idx").shards().size(), 1);
        clusterState = startShardsAndReroute(strategy, clusterState, routingTable.index("idx").shard(0).shards().get(0));
            assertThat(unassignedPrimary.unassignedInfo().getMessage(), containsString("boom" + i));
                )  
            ClusterState newState = strategy.applyFailedShards(clusterState, failedShards);
import static org.hamcrest.Matchers.containsString;
 * the Apache License, Version 2.0 (the "License"); you may
                )
            assertThat(newState, not(equalTo(clusterState)));
import java.util.Collections;
            assertThat(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getMessage(), containsString("boom"));  
        routingTable = newState.routingTable();  
                "ZOOOMG",
                            .settings(
/*  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        routingTable = newState.routingTable();  
import org.opensearch.cluster.routing.allocation.decider.Decision;
                            )
                    new UnsupportedOperationException(),
        );
            assertEquals(  
            )
                    routingTable.index("idx").shard(0).shards().get(0),  
        clusterState = ClusterState.builder(clusterState)
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations(), retries);
        assertThat(newState, not(equalTo(clusterState)));
            // MaxRetryAllocationDecider#canForceAllocatePrimary should return a NO decision because canAllocate returns NO here
        RoutingTable routingTable = routingTableBuilder.build();
            )
        // now fail it N-1 times
                    "boom" + i,
                    routingTable.index("idx").shard(0).shards().get(0),
 * license agreements. See the NOTICE file distributed with
        routingTable = clusterState.routingTable();  
        unassignedPrimary = routingTable.index("idx").shard(0).shards().get(0);  
                        IndexMetadata.builder(clusterState.metadata().index("idx"))
 * not use this file except in compliance with the License.
    public void setUp() throws Exception {
        Metadata.Builder metaBuilder = Metadata.builder();
            .build();
        // now fail again and see if it has a new counter
        assertEquals(routingTable.index("idx").shards().size(), 1);
package org.opensearch.cluster.routing.allocation;
                routingTable.index("idx").shard(0).shards().get(0),
        // now we go and check that we are actually stick to unassigned on the next failure  
            ClusterState newState = strategy.applyFailedShards(clusterState, failedShards);  
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), INITIALIZING);  
        // now we go and check that we are actually stick to unassigned on the next failure  
 *     http://www.apache.org/licenses/LICENSE-2.0
                "boom",
            assertEquals(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations(), i + 1);  
                    .put(  
                Decision.YES,
            .build();  
import org.opensearch.common.settings.Settings;
    }
    private AllocationService strategy;
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.EmptyClusterInfoService;
        assertEquals(unassignedPrimary.state(), INITIALIZING);
        ClusterState clusterState = createInitialClusterState();
        );
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.ClusterState;  
            List<FailedShard> failedShards = Collections.singletonList(  
                new RoutingAllocation(null, null, clusterState, null, null, 0)  
 *
        // Counter reset, so MaxRetryAllocationDecider#canForceAllocatePrimary should return a YES decision
        newState = strategy.reroute(clusterState, new AllocationCommands(), false, true).getClusterState();
                new UnsupportedOperationException(),  
            assertThat(newState, not(equalTo(clusterState)));
            routingTable = newState.routingTable();
import org.opensearch.cluster.metadata.Metadata;
            assertThat(newState, not(equalTo(clusterState)));  
import org.opensearch.Version;
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(routingTable.index("idx").shards().size(), 1);
                    new UnsupportedOperationException(),
        List<FailedShard> failedShards = Collections.singletonList(
 *  
            new BalancedShardsAllocator(Settings.EMPTY),
 * The OpenSearch Contributors require contributions made to  
            assertThat(newState, not(equalTo(clusterState)));  
            assertEquals(routingTable.index("idx").shards().size(), 1);  
import java.util.List;  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            clusterState = newState;
                routingTable.index("idx").shard(0).shards().get(0),  
        ShardRouting unassignedPrimary = routingTable.index("idx").shard(0).shards().get(0);
            assertThat(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getMessage(), containsString("boom" + i));
import static org.hamcrest.Matchers.not;
            assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), INITIALIZING);
                new FailedShard(  
                "boom",
                new MaxRetryAllocationDecider().canForceAllocatePrimary(
        RoutingTable routingTable = clusterState.routingTable();  
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        failedShards = Collections.singletonList(
                    routingTable.index("idx").shard(0).shards().get(0),
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
                                    .put("index.allocation.max_retries", retries + 1)
        assertEquals(
 */  
            assertEquals(unassignedPrimary.state(), INITIALIZING);  
                    unassignedPrimary,
 * You may obtain a copy of the License at  
        assertThat(newState, not(equalTo(clusterState)));  
                new UnsupportedOperationException(),
        // now fail it N-1 times
                null,  
            // MaxRetryAllocationDecider#canForceAllocatePrimary should return YES decisions because canAllocate returns YES here  
                unassignedPrimary,
            new FailedShard(
                    new UnsupportedOperationException(),  
    public void testSingleRetryOnIgnore() {
    public void testFailedAllocation() {
 *
            routingTable = newState.routingTable();
                )  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(routingTable.index("idx").shards().size(), 1);
                routingTable.index("idx").shard(0).shards().get(0),
        assertEquals(
        assertEquals(INITIALIZING, routingTable.index("idx").shard(0).shards().get(0).state());  
            );
 * GitHub history for details.
                randomBoolean()  
        return clusterState;
public class MaxRetryAllocationDeciderTests extends OpenSearchAllocationTestCase {  
        newState = strategy.applyFailedShards(clusterState, failedShards);
            assertEquals(
        }  
        assertEquals(unassignedPrimary.unassignedInfo().getNumFailedAllocations(), 1);
            failedShards = Collections.singletonList(
        for (int i = 0; i < retries - 1; i++) {  
                    randomBoolean()  
        }
        clusterState = newState;
                new FailedShard(
    }
        assertThat(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getMessage(), containsString("boom"));
                )
            assertEquals(unassignedPrimary.unassignedInfo().getNumFailedAllocations(), i + 1);
        }
        );
                new FailedShard(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
            assertEquals(unassignedPrimary.unassignedInfo().getNumFailedAllocations(), retries);
                null,
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;  
        final int retries = MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY.get(Settings.EMPTY);
        assertEquals(UNASSIGNED, routingTable.index("idx").shard(0).shards().get(0).state());  
        RoutingTable routingTable = clusterState.routingTable();  
                    randomBoolean()  
                    randomBoolean()
        assertThat(newState, not(equalTo(clusterState)));
        metaBuilder.put(IndexMetadata.builder("idx").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0));  
import static org.hamcrest.Matchers.equalTo;  
        routingTableBuilder.addAsNew(metadata.index("idx"));  
 * compatible open source license.
import org.opensearch.cluster.OpenSearchAllocationTestCase;
 */  
}  
 * ownership. Elasticsearch licenses this file to you under  
        );  
            );  
    }
                    )
        // good we are initializing and we are maintaining failure information  
            ShardRouting unassignedPrimary = routingTable.index("idx").shard(0).shards().get(0);
                    "boom" + i,
            EmptyClusterInfoService.INSTANCE,
            );
/*
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
        assertThat(newState, not(equalTo(clusterState)));
                                    .put(clusterState.metadata().index("idx").getSettings())
            List<FailedShard> failedShards = Collections.singletonList(
        clusterState = newState;
 * KIND, either express or implied.  See the License for the
            .metadata(metadata)
        final int retries = MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY.get(Settings.EMPTY);
                new MaxRetryAllocationDecider().canForceAllocatePrimary(  
        assertEquals(unassignedPrimary.state(), UNASSIGNED);
            new MaxRetryAllocationDecider().canForceAllocatePrimary(  
import org.opensearch.cluster.ClusterName;
            assertEquals(unassignedPrimary.state(), UNASSIGNED);  
        assertEquals(retries, routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations());
        // all counters have been reset to 0 ie. no unassigned info
        // again fail it N-1 times  
            clusterState = newState;
        newState = strategy.applyFailedShards(clusterState, failedShards);  
        assertThat(newState, not(equalTo(clusterState)));
        RoutingTable prevRoutingTable = routingTable;
            )
                    randomBoolean()
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;  
        assertThat(unassignedPrimary.unassignedInfo().getMessage(), containsString("ZOOOMG"));  
        for (int i = 0; i < retries - 1; i++) {
        // change the settings and ensure we can do another round of allocation for that index.
                    .build()
                randomBoolean()
        assertEquals(routingTable.index("idx").shards().size(), 1);
        clusterState = ClusterState.builder(clusterState)
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
            Decision.YES,  
        // now we start the shard
            )  
        routingTable = newState.routingTable();
 */
            new FailedShard(  
 * software distributed under the License is distributed on an
            )
        assertEquals(routingTable.index("idx").shards().size(), 1);
        );  
        ClusterState newState = strategy.applyFailedShards(clusterState, failedShards);  
        assertEquals(routingTable.index("idx").shards().size(), 1);  
            .routingTable(routingTable)
import org.opensearch.snapshots.EmptySnapshotsInfoService;
                routingTable.index("idx").shard(0).shards().get(0),  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
                new FailedShard(
        assertEquals(unassignedPrimary.unassignedInfo().getNumFailedAllocations(), retries);  
            assertEquals(routingTable.index("idx").shards().size(), 1);  
        strategy = new AllocationService(
                    "boom",  
            .metadata(
            .build();  
 * Unless required by applicable law or agreed to in writing,
        // manual resetting of retry count  
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), UNASSIGNED);  
                    unassignedPrimary,  
 * under the License.  
            List<FailedShard> failedShards = Collections.singletonList(
        ClusterState clusterState = createInitialClusterState();
        {
            assertEquals(INITIALIZING, routingTable.index("idx").shard(0).shards().get(0).state());
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
import org.opensearch.test.gateway.TestGatewayAllocator;  
            ShardRouting unassignedPrimary = routingTable.index("idx").shard(0).shards().get(0);
                Decision.NO,
        assertEquals(routingTable.index("idx").shards().size(), 1);
        assertEquals(0, routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations());
            assertEquals(i + 1, routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getNumFailedAllocations());
            newState = strategy.applyFailedShards(clusterState, failedShards);
        for (int i = 0; i < retries - 1; i++) {  
            Decision.YES,
            );
            routingTable = newState.routingTable();  
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
        super.setUp();  
import org.opensearch.cluster.metadata.IndexMetadata;  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
            );
            new FailedShard(
        ClusterState newState = strategy.reroute(clusterState, "settings changed");
        assertEquals(prevRoutingTable.index("idx").shards().size(), 1);
        assertEquals(prevRoutingTable.index("idx").shard(0).shards().get(0).state(), UNASSIGNED);  
        // bumped up the max retry count, so canForceAllocatePrimary should return a YES decision  
                        true  
                                    .build()  
        assertThat(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getMessage(), containsString("boom"));
            routingTable = newState.routingTable();  
        clusterState = newState;  
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), STARTED);
        assertNull(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo());
 * specific language governing permissions and limitations
            assertEquals(routingTable.index("idx").shards().size(), 1);
                    new RoutingAllocation(null, null, clusterState, null, null, 0)  
        routingTable = newState.routingTable();
            );
            .routingTable(routingTable)  
                )
            EmptySnapshotsInfoService.INSTANCE  
        }
                Metadata.builder(clusterState.metadata())
                            .build(),
            ClusterState newState = strategy.applyFailedShards(clusterState, failedShards);  
                    "boom",
            clusterState = newState;
            )
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
import org.opensearch.cluster.routing.RoutingTable;  
                                Settings.builder()  
                    new UnsupportedOperationException(),
                new UnsupportedOperationException(),
        // now we go and check that we are actually stick to unassigned on the next failure
                )
        clusterState = newState;  
        assertThat(unassignedPrimary.unassignedInfo().getMessage(), containsString("boom"));
                    routingTable.index("idx").shard(0).shards().get(0),  
        );
        Metadata metadata = metaBuilder.build();
                randomBoolean()  
        List<FailedShard> failedShards = Collections.singletonList(
                    null,
            new TestGatewayAllocator(),  
    }
    @Override
                    new RoutingAllocation(null, null, clusterState, null, null, 0)
    private ClusterState createInitialClusterState() {
                    null,
        assertThat(routingTable.index("idx").shard(0).shards().get(0).unassignedInfo().getMessage(), containsString("boom"));
/*  
import org.opensearch.cluster.node.DiscoveryNodes;
            new MaxRetryAllocationDecider().canForceAllocatePrimary(
        routingTable = newState.routingTable();

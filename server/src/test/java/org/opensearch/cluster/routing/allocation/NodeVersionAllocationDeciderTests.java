                                    oldNode1.getId(),  
        RoutingTable routingTable = RoutingTable.builder()
                String fromId = r.currentNodeId();
            .build();  
                        nodes.add(newNode("node" + (nodeIdx++), randomVersion(random())));  
        );
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            rtBuilder.addAsNew(metadata.index("test_" + i));
 * SPDX-License-Identifier: Apache-2.0
            } else {
import org.opensearch.test.gateway.TestGatewayAllocator;
            "oldNode1",  
                nodesBuilder.add(node);
                    + newNode.node().getVersion()
import org.opensearch.cluster.EmptyClusterInfoService;
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;  
        decision = allocationDecider.canAllocate(replicaShard, newNode, routingAllocation);
        decision = allocationDecider.canAllocate(
                                null,
                    toId,  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(STARTED).size(), equalTo(1));
            Collections.singleton(new NodeVersionAllocationDecider(segmentReplicationSettings))
            decision.getExplanation(),
            is(  
        );  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();
            equalTo(false)  
        assertThat(
            routingNodes.initializeShard(primaryShard, "newNode", null, 0, routingChangesObserver),
        }
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            )
                IndexRoutingTable.builder(shard2.getIndex())
            .put(
                    + "] to a node with equal-or-newer version ["
        final ShardRouting replicaShard = clusterState.routingTable().shardRoutingTable(shardId).replicaShards().get(0);  
            emptyMap(),  
            Version.CURRENT
            assertRecoveryNodeVersions(routingNodes);
import org.opensearch.cluster.metadata.IndexMetadata;
                    .numberOfShards(between(1, 5))  
        final ShardRouting startedPrimary = routingNodes.startShard(
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(2).currentNodeId(), notNullValue());
import org.opensearch.common.util.set.Sets;  
import org.opensearch.cluster.routing.TestShardRouting;
            .nodes(  
        Metadata.Builder builder = Metadata.builder();
import static java.util.Collections.emptyMap;
                                shard1.getIndexName(),
            EmptyClusterInfoService.INSTANCE,
        logger.trace("RoutingNodes: {}", routingNodes);
                                TestShardRouting.newShardRouting(
            )
        AllocationService service = createAllocationService(
    private void assertRecoveryNodeVersions(RoutingNodes routingNodes) {  
        final DiscoveryNode oldNode1 = new DiscoveryNode(
        );
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
import org.opensearch.cluster.routing.AllocationId;
                    )
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(2))  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
    }  
                    .numberOfReplicas(1)
 * this file be licensed under the Apache-2.0 license or a
                    }
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
                                true,
            .put(
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
                        new SnapshotRecoverySource(UUIDs.randomBase64UUID(), snapshot, Version.CURRENT, indexId)  
        AllocationId allocationId2R = AllocationId.newInitializing();
            buildNewFakeTransportAddress(),
            UUIDs.randomBase64UUID(),
            "oldNode1",
            .metadata(metadata)
            ClusterState newState = startInitializingShardsAndReroute(service, clusterState);  
            VersionUtils.getPreviousVersion()
                    .numberOfShards(1)
            .put(
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));  
                    + "] since this is older than the primary version ["
            Version.CURRENT
                    if (frequently()) {  
                                true,  
        Metadata metadata = Metadata.builder()
            is(
                nodes = nodes.subList(0, numNodes);  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(STARTED).size(), equalTo(1));
                    + newNode.node().getVersion()  
                    .add(newNode("old1", VersionUtils.getPreviousVersion()))  
        logger.info("Building initial routing table");
        assertThat(
                                    ShardRoutingState.STARTED,  
                    + "]"
 * this work for additional information regarding copyright
                    .putInSyncAllocationIds(0, Sets.newHashSet(allocationId1P.getId(), allocationId1R.getId()))  
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
import java.util.HashMap;
        for (int i = 0; i < numIndices; i++) {
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(STARTED).size(), equalTo(2));
        }
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(5));
                    + newNode.node().getVersion()
        );  
        }  
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
                DiscoveryNodes.builder()
            .build();  
                "can allocate replica shard to a node with version ["  
                                null,
        );
                String toId = r.relocatingNodeId();
                                shard1.getIndexName(),
        );  
                    .settings(settings(Version.CURRENT).put(Settings.EMPTY))
        assertThat(  
import org.opensearch.cluster.ClusterState;
    public void testRollingRestart() {  
                    .numberOfReplicas(1)  
                            .addShard(
        assertThat(state.routingTable().index(shard1.getIndex()).shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(0));
                "node version ["
            }  
        }
            buildNewFakeTransportAddress(),
            "oldNode2",
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.RoutingTable;  
                    routingNodes.node(toId).node().getVersion()  
            new BalancedShardsAllocator(Settings.EMPTY),
        );  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)  
                        new IndexShardRoutingTable.Builder(shard1).addShard(
        );  
                    "From: {} with Version: {} to: {} with Version: {}",  
                logger.trace(
            )  
    private final Logger logger = LogManager.getLogger(NodeVersionAllocationDeciderTests.class);  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(STARTED));
        final DiscoveryNode newNode = new DiscoveryNode(
            logger,  
                assertThat(toId, notNullValue());  
            .build();
 *
                "can relocate primary shard from a node with version ["  
                    + "]"
    public void testRebalanceDoesNotAllocatePrimaryOnHigherVersionNodesSegrepEnabled() {  
        final org.opensearch.cluster.ClusterName clusterName = org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(
            CLUSTER_MANAGER_DATA_ROLES,  
                                    shard1.getIndexName(),  
        return clusterState;  
            emptyMap(),  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
                    + oldNode.node().getVersion()
        Metadata metadata = builder.build();
                        new IndexShardRoutingTable.Builder(shard2).addShard(  
            allocationDeciders,
            buildNewFakeTransportAddress(),  
        for (int i = 0; i < iters; i++) {
import org.opensearch.cluster.routing.allocation.decider.Decision;  
            VersionUtils.getPreviousVersion()  
                                true,  
            .build();  
import org.opensearch.snapshots.SnapshotShardSizeInfo;  
        assertThat(state.routingTable().index(shard2.getIndex()).shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(0));
                assertThat(primary, notNullValue());
            CLUSTER_MANAGER_DATA_ROLES,  
            .numberOfReplicas(randomIntBetween(0, 3));
        int nodeIdx = 0;
                    + newNode.node().getVersion()
                ShardRouting primary = routingNodes.activePrimary(r.shardId());
        );  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
                for (int j = nodes.size(); j < numNodes; j++) {
            emptyMap(),  
                                shard2.getId(),  
            DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
                IndexMetadata.builder(shard1.getIndexName())
                            )
            )  
        // the two indices must stay as is, the replicas cannot move to oldNode2 because versions don't match  
        assertThat(decision.type(), is(Decision.Type.NO));
            "newNode",  
            int numNodes = between(1, 20);  
            .build();
                );
            Settings.builder()
        logger.info("Building initial routing table");  
            new TestGatewayAllocator(),
 */  
        ShardId shard1 = new ShardId("test1", "_na_", 0);  
                "node version ["
import static org.opensearch.test.VersionUtils.randomVersion;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    "From: {} with Version: {} to: {} with Version: {}",  
import org.opensearch.cluster.routing.ShardRouting;
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
            "newNode",
    public void testRestoreDoesNotAllocateSnapshotOnOlderNodes() {
        clusterState = stabilize(clusterState, service);
                }
            } else {  
public class NodeVersionAllocationDeciderTests extends OpenSearchAllocationTestCase {
        do {
            indexMetadata.putInSyncAllocationIds(i, Collections.singleton("_test_"));
            is(
        );
import org.opensearch.cluster.metadata.Metadata;
        final IndexId indexId = new IndexId("test", UUIDs.randomBase64UUID(random()));  
                IndexRoutingTable.builder(shard1.getIndex())  
        routingNodes.startShard(
    private ClusterState stabilize(ClusterState clusterState, AllocationService service) {
        );
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
                                    shard2.getIndexName(),
        routingAllocation.debugDecision(true);  
        clusterState = stabilize(clusterState, service);  
            decision.getExplanation(),
        clusterState = stabilize(clusterState, service);
 *  
            .metadata(metadata)
            ShardRoutingHelper.newWithRestoreSource(primaryShard, oldVersionSnapshot),
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(2))  
        assertThat(decision.type(), is(Decision.Type.YES));  
                                    shard1.getIndexName(),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            .addShard(
                                    null,  
            new BalancedShardsAllocator(Settings.EMPTY),
        }
        final DiscoveryNode oldNode1 = new DiscoveryNode(  
            emptyMap(),
            .routingTable(routingTable)
        );  
        assertThat(decision.type(), is(Decision.Type.NO));
            UUIDs.randomBase64UUID(),
        );
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
                            TestShardRouting.newShardRouting(
import org.opensearch.snapshots.Snapshot;
            clusterState = newState;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
            )  
import java.util.Map;  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
        decision = allocationDecider.canAllocate(ShardRoutingHelper.initialize(primaryShard, "newNode"), oldNode, routingAllocation);
            .add(
            assertEquals("newNode", state.routingTable().index("test").getShards().get(i).primaryShard().currentNodeId());
            .routingTable(
                                allocationId1P
            logger.trace("RoutingNodes: {}", clusterState.getRoutingNodes());
                    .addIndexShard(
            if (r.primary()) {
                    .addIndexShard(
    }  
        logger.info("complete rebalancing");
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.routing.ShardRoutingHelper;
                                    allocationId1R  
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            )  
                    + "] is the same or newer than snapshot version ["  
                        )  
                                    null,  
        }  
        final SnapshotRecoverySource oldVersionSnapshot = new SnapshotRecoverySource(
                                    false,
                IndexMetadata.builder("test_" + i)
        final SnapshotRecoverySource newVersionSnapshot = new SnapshotRecoverySource(
            EmptyClusterInfoService.INSTANCE,
import org.opensearch.cluster.node.DiscoveryNodes;
            newNode.node().getVersion(),
        RoutingAllocation routingAllocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);
                            )  
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        state = strategy.reroute(state, new AllocationCommands(), true, false).getClusterState();
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
                    .add(newNode("old0", VersionUtils.getPreviousVersion()))  
import static org.hamcrest.Matchers.nullValue;
        AllocationService strategy = new MockAllocationService(
        RoutingTable.Builder rtBuilder = RoutingTable.builder();  
        AllocationId allocationId1P = AllocationId.newInitializing();
            equalTo(false)
    }
        }  
            CLUSTER_MANAGER_DATA_ROLES,
            "newNode2",
            routingChangesObserver
package org.opensearch.cluster.routing.allocation;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), notNullValue());  
            changed = newState.equals(clusterState) == false;
            routingChangesObserver
import org.opensearch.cluster.node.DiscoveryNode;  
                                oldNode1.getId(),  
        clusterState = ClusterState.builder(clusterState)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            .build();
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        );
            VersionUtils.getPreviousVersion()
                IndexRoutingTable.builder(shard1.getIndex())  
        logger.trace("RoutingNodes: {}", clusterState.getRoutingNodes());
            decision.getExplanation(),  
                    .addAsRestore(
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(2).state(), equalTo(UNASSIGNED));  
        );  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
 * Unless required by applicable law or agreed to in writing,
                                shard1.getId(),
                RoutingTable.builder()  
        AllocationDeciders allocationDeciders = new AllocationDeciders(
        clusterState = ClusterState.builder(clusterState)
            routingAllocation
        assertThat(decision.type(), is(Decision.Type.YES));
        );
                    .add(newNode("old1", VersionUtils.getPreviousVersion()))
            emptyMap(),
                    routingNodes.node(fromId).node().getVersion(),
        for (int i = 0; i < numberOfShards; i++) {  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(2).state(), equalTo(STARTED));
                logger.trace(
                    + "]"
        );
                    + oldNode.node().getVersion()
                            )  
                                ShardRoutingState.STARTED,  
                                )
        clusterState = stabilize(clusterState, service);
                            .build()  
        boolean changed;  
                                    allocationId2R
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());
            .build();  
            if (!r.primary()) {  
        }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    .add(newNode("old0", VersionUtils.getPreviousVersion()))
        final NodeVersionAllocationDecider allocationDecider = new NodeVersionAllocationDecider(Settings.EMPTY);
                                    shard2.getId(),
            oldNode,
        );
                IndexMetadata.builder(shard2.getIndexName())  
        mutableShardRoutings = routingNodes.shardsWithState(ShardRoutingState.INITIALIZING);
 */
        Metadata metadata = Metadata.builder().put(indexMetadata).build();  
            Settings.EMPTY
                                TestShardRouting.newShardRouting(  
import org.opensearch.Version;  
                        )  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));  
                    toId,  
            VersionUtils.getPreviousVersion()
        final int numberOfShards = randomIntBetween(1, 3);
                    routingNodes.node(toId).node().getVersion()
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        }
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(UNASSIGNED).size(), equalTo(1));
        int iters = scaledRandomIntBetween(10, 100);  
                            )  
            CLUSTER_MANAGER_DATA_ROLES,
        state = strategy.reroute(state, new AllocationCommands(), true, false).getClusterState();
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .add(
            .nodes(DiscoveryNodes.builder().add(newNode("new2")).add(newNode("new1")).add(newNode("new0")))
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
            .metadata(metadata)  
 */  
            .build();
                DiscoveryNodes.builder()
            .routingTable(routingTable)
                    + "] since this is equal-or-newer than the primary version ["
        RoutingTable routingTable = rtBuilder.build();  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));  
                            .build()  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(STARTED));  
        assertThat(decision.type(), is(Decision.Type.YES));
                                allocationId2P
        RoutingNode oldNode = new RoutingNode("oldNode", newNode("oldNode", VersionUtils.getPreviousVersion()));
            emptyMap(),
            EmptySnapshotsInfoService.INSTANCE  
        assertThat(decision.type(), is(Decision.Type.NO));  
            )
        final DiscoveryNode newNode = new DiscoveryNode(  
            oldNode.node().getVersion(),
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.cluster.routing.ShardRoutingState;  
                                    false,
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(2).currentNodeId(), nullValue());  
                    + oldNode.node().getVersion()  
                    .putInSyncAllocationIds(0, Sets.newHashSet(allocationId2P.getId(), allocationId2R.getId()))
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        AllocationDeciders allocationDeciders = new AllocationDeciders(
                "cannot allocate replica shard to a node with version ["  
/*  
        for (int i = 0; i < numIndices; i++) {  
                        new IndexShardRoutingTable.Builder(shard2).addShard(  
                                newNode.getId(),  
                        )
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            )  
            .build();
        AllocationId allocationId2R = AllocationId.newInitializing();
        for (int i = 0; i < numberOfShards; i++) {
                DiscoveryNodes.builder().add(newNode("node0", VersionUtils.getPreviousVersion())).add(newNode("new1")).add(newNode("new0"))
            routingNodes = clusterState.getRoutingNodes();  
                ShardRouting primary = routingNodes.activePrimary(r.shardId());
                    + newNode.node().getVersion()
                                null,
            Version.CURRENT
        clusterState = service.disassociateDeadNodes(clusterState, true, "reroute");
                .build()
                    + "]"
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));  
            builder.put(  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(UNASSIGNED).size(), equalTo(2));  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
            )
        assertRecoveryNodeVersions(routingNodes);  
                    )
            buildNewFakeTransportAddress(),
        );  
            indexId
                    .putInSyncAllocationIds(0, Sets.newHashSet(allocationId2P.getId(), allocationId2R.getId()))
                                    false,
            .nodes(DiscoveryNodes.builder().add(newNode1).add(newNode2).add(oldNode1).add(oldNode2))
                                newNode.getId(),
            "oldNode2",
        assertThat(  
            Settings.builder()
        } while (changed);
            snapshotShardSizes.put(new InternalSnapshotsInfoService.SnapshotShard(snapshot, indexId, shardId), randomNonNegativeLong());  
            "oldNode2",  
                            )
            is(
        final Index index = metadata.index("test").getIndex();  
            .settings(settings(Version.CURRENT))  
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
            decision.getExplanation(),
            "newNode1",
    }
                            .addShard(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            logger,  
                );
            .build();  
        Decision decision = allocationDecider.canAllocate(primaryShard, newNode, routingAllocation);  
 * specific language governing permissions and limitations
import org.opensearch.snapshots.InternalSnapshotsInfoService;  
        routingAllocation.debugDecision(true);
                    .addIndexShard(
                    + "] to a node with older version ["  
import org.opensearch.cluster.routing.RoutingNode;
                    .numberOfShards(1)
                        new IndexShardRoutingTable.Builder(shard1).addShard(
            state.routingTable().index(shard2.getIndex()).shardsWithState(ShardRoutingState.RELOCATING).get(0).primary(),  
 * under the License.  
        );
        );
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
            new BalancedShardsAllocator(Settings.EMPTY),  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        Metadata metadata = Metadata.builder()
        AllocationId allocationId1R = AllocationId.newInitializing();  
                            )
            buildNewFakeTransportAddress(),  
            .metadata(metadata)  
            final ShardId shardId = new ShardId(index, i);
        routingAllocation.debugDecision(true);
        for (ShardRouting r : mutableShardRoutings) {
        );  
            .nodes(
                    "From: {} with Version: {} to: {} with Version: {}",
        }
        assertThat(
        final DiscoveryNode newNode2 = new DiscoveryNode(
        AllocationId allocationId1R = AllocationId.newInitializing();
        clusterState = ClusterState.builder(clusterState)
import org.opensearch.cluster.routing.IndexRoutingTable;  
        clusterState = strategy.reroute(clusterState, "reroute");  
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
        final RoutingNodes routingNodes = new RoutingNodes(clusterState, false);
 * compatible open source license.
            if (nodes.size() > numNodes) {
                .build()  
            )
                IndexMetadata.builder(shard1.getIndexName())
 * KIND, either express or implied.  See the License for the
            Collections.singleton(new NodeVersionAllocationDecider(Settings.EMPTY))
                                shard1.getId(),
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(STARTED).size(), equalTo(1));
                                ShardRoutingState.STARTED,
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));  
        final ShardId shardId = clusterState.routingTable().index("test").shard(0).getShardId();
            );
                                TestShardRouting.newShardRouting(
        );
            state.routingTable().index(shard1.getIndex()).shardsWithState(ShardRoutingState.RELOCATING).get(0).primary(),
            decision.getExplanation(),
            CLUSTER_MANAGER_DATA_ROLES,  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
            }
            .build();  
        final DiscoveryNode oldNode2 = new DiscoveryNode(
                                ShardRoutingState.STARTED,  
        state = strategy.reroute(state, new AllocationCommands(), true, false).getClusterState();
            )
        clusterState = ClusterState.builder(clusterState)  
                            )
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(UNASSIGNED).size(), equalTo(1));
                            )  
        clusterState = ClusterState.builder(clusterState)
        Settings segmentReplicationSettings = Settings.builder()  
            .build();
            .numberOfShards(numberOfShards)
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(2).currentNodeId(), nullValue());  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));  
            emptyMap(),
                            .addShard(
        Metadata metadata = Metadata.builder()  
                    fromId,
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(UNASSIGNED).size(), equalTo(1));
            Arrays.asList(new ReplicaAfterPrimaryActiveAllocationDecider(), new NodeVersionAllocationDecider(Settings.EMPTY))
            ShardRoutingHelper.newWithRestoreSource(primaryShard, newVersionSnapshot),  
        assertThat(state.routingTable().index(shard2.getIndex()).shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
import org.opensearch.core.index.shard.ShardId;
                                    ShardRoutingState.STARTED,
        assertThat(decision.type(), is(Decision.Type.YES));
        }  
            Version.CURRENT  
                                    ShardRoutingState.STARTED,
        Metadata metadata = Metadata.builder()  
            allocationDeciders,
                    .numberOfReplicas(1)
                assertTrue(routingNodes.node(toId).node().getVersion().onOrAfter(routingNodes.node(fromId).node().getVersion()));  
import static org.hamcrest.Matchers.notNullValue;  
    }
import org.opensearch.cluster.routing.allocation.decider.NodeVersionAllocationDecider;
                                shard2.getIndexName(),
            new TestGatewayAllocator(),  
                        nodes.add(newNode("node" + (nodeIdx++), randomBoolean() ? VersionUtils.getPreviousVersion() : Version.CURRENT));
                            .build()
                                true,
        List<DiscoveryNode> nodes = new ArrayList<>();
                            .build()
                    .settings(settings(Version.CURRENT).put(Settings.EMPTY))  
        for (int i = 0; i < numberOfShards; i++) {
        ShardId shard1 = new ShardId("test1", "_na_", 0);
import java.util.Collections;  
            new Snapshot("rep1", new SnapshotId("snp1", UUIDs.randomBase64UUID())),  
 * GitHub history for details.
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());
            for (DiscoveryNode node : nodes) {
        final DiscoveryNode oldNode2 = new DiscoveryNode(
            VersionUtils.getPreviousVersion()  
                    .settings(settings(Version.CURRENT).put(segmentReplicationSettings))  
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)  
                                null,
            .routingTable(initialRoutingTable)
                    .settings(settings(Version.CURRENT))
import org.opensearch.common.settings.Settings;
        Metadata metadata = Metadata.builder()
import java.util.ArrayList;
        decision = allocationDecider.canAllocate(replicaShard, oldNode, routingAllocation);
        final IndexId indexId = new IndexId("test", UUIDs.randomBase64UUID(random()));
            allocationDeciders,
    }
                    .numberOfReplicas(between(0, 2))
        }
                                allocationId2P
                    .build()
                    + newNode.node().getVersion()  
        ShardId shard2 = new ShardId("test2", "_na_", 0);
        );
        RoutingNode newNode = new RoutingNode("newNode", newNode("newNode", Version.CURRENT));
            )
                                    allocationId1R  
                                    shard2.getId(),
                                    shard1.getId(),
                                    null,
        assertThat(  
                            TestShardRouting.newShardRouting(
            )
    }  
                                    oldNode2.getId(),
                                    allocationId2R
            buildNewFakeTransportAddress(),
            routingAllocation
        logger.info("start all the primary shards, replicas will start initializing");
 * ownership. Elasticsearch licenses this file to you under  
                    + "]"
                    + oldNode.node().getVersion()
                String toId = r.relocatingNodeId();  
                String fromId = primary.currentNodeId();  
                .build()  
            }  
import org.opensearch.common.UUIDs;
                    .putInSyncAllocationIds(0, Sets.newHashSet(allocationId1P.getId(), allocationId1R.getId()))  
import org.opensearch.core.index.Index;
                    + oldNode.node().getVersion()  
            () -> new SnapshotShardSizeInfo(snapshotShardSizes)
        );  
                                    null,
        final RoutingChangesObserver routingChangesObserver = new RoutingChangesObserver.AbstractRoutingChangesObserver();  
            decision.getExplanation(),
        assertThat(state.routingTable().index(shard1.getIndex()).shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));  
import org.opensearch.cluster.routing.RoutingChangesObserver;  
                                shard2.getIndexName(),
        AllocationService service = createAllocationService(
import static java.util.Collections.shuffle;  
        final Snapshot snapshot = new Snapshot("rep1", new SnapshotId("snp1", UUIDs.randomBase64UUID()));
        AllocationId allocationId1P = AllocationId.newInitializing();
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        );
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;  
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(5));
    }
        decision = allocationDecider.canAllocate(ShardRoutingHelper.initialize(primaryShard, "oldNode"), newNode, routingAllocation);
        for (ShardRouting r : mutableShardRoutings) {
                    routingNodes.node(toId).node().getVersion()
                                )
            emptyMap(),
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        );  
        RoutingTable routingTable = RoutingTable.builder()
            emptyMap(),
                IndexRoutingTable.builder(shard2.getIndex())
            indexId
                    fromId,  
                    toId,
/*  
        final Map<InternalSnapshotsInfoService.SnapshotShard, Long> snapshotShardSizes = new HashMap<>(numberOfShards);
import org.opensearch.test.VersionUtils;
            buildNewFakeTransportAddress(),
        assertThat(decision.getExplanation(), is("the primary shard is new or already existed on the node"));
                assertThat(primary, notNullValue());
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(INITIALIZING).size(), equalTo(1));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
        ShardId shard2 = new ShardId("test2", "_na_", 0);
                    + "]"  
    public void testRebalanceDoesNotAllocatePrimaryAndReplicasOnDifferentVersionNodes() {
                IndexMetadata.builder(shard2.getIndexName())  
            )
                    )
                assertThat(fromId, notNullValue());
            CLUSTER_MANAGER_DATA_ROLES,
                                shard2.getId(),  
            new Snapshot("rep1", new SnapshotId("snp1", UUIDs.randomBase64UUID())),  
                    )
            is(  
        routingAllocation = new RoutingAllocation(null, routingNodes, clusterState, null, null, 0);
                    .addIndexShard(
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
import org.apache.logging.log4j.LogManager;
    public void testMessages() {
            .routingTable(routingTable)
                                ShardRoutingState.STARTED,
                            TestShardRouting.newShardRouting(  
            routingNodes.relocateShard(startedPrimary, "oldNode", 0, routingChangesObserver).v2(),
            VersionUtils.getPreviousVersion()
                    .add(newNode("old2", VersionUtils.getPreviousVersion()))
            .build();
        }
            CLUSTER_MANAGER_DATA_ROLES,
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(INITIALIZING).size(), equalTo(1));  
            .nodes(DiscoveryNodes.builder().add(newNode).add(oldNode1).add(oldNode2))
import java.util.Arrays;
            .nodes(DiscoveryNodes.builder().add(newNode.node()).add(oldNode.node()))
            CLUSTER_MANAGER_DATA_ROLES,
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
        final DiscoveryNode oldNode2 = new DiscoveryNode(  
                    + oldNode.node().getVersion()
        logger.info("Building initial routing table");  
                shuffle(nodes, random());
                    .numberOfShards(1)
            .nodes(  
                logger.trace(
        AllocationDeciders allocationDeciders = new AllocationDeciders(  
                                    ShardRoutingState.STARTED,  
import org.opensearch.snapshots.SnapshotId;
                                    shard1.getId(),
            )
            new TestGatewayAllocator(),  
            EmptyClusterInfoService.INSTANCE,
            buildNewFakeTransportAddress(),
                    .numberOfShards(1)
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), notNullValue());
            }
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
                String toId = r.currentNodeId();
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        );
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;  
        );  
 * software distributed under the License is distributed on an
            is(
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
        final DiscoveryNode newNode1 = new DiscoveryNode(  
        );  
        ClusterState clusterState = ClusterState.builder(clusterName)
import org.opensearch.cluster.routing.allocation.decider.ReplicaAfterPrimaryActiveAllocationDecider;
        final ShardRouting primaryShard = clusterState.routingTable().shardRoutingTable(shardId).primaryShard();
        );  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(2).state(), equalTo(UNASSIGNED));  
        AllocationService strategy = new MockAllocationService(
                            TestShardRouting.newShardRouting(  
import org.opensearch.snapshots.EmptySnapshotsInfoService;
        decision = allocationDecider.canAllocate(
            buildNewFakeTransportAddress(),
                        )
 * Modifications Copyright OpenSearch Contributors. See
/*
                        metadata.index("test"),
        // the two indices must stay as is, the replicas cannot move to oldNode2 because versions don't match  
            .metadata(metadata)  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            .metadata(metadata)  
            "oldNode1",
import org.opensearch.cluster.routing.RoutingNodes;
import org.opensearch.repositories.IndexId;
            .build();  
 * the Apache License, Version 2.0 (the "License"); you may
            .add(  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            )  
                    routingNodes.node(fromId).node().getVersion(),
                                    oldNode1.getId(),  
 * You may obtain a copy of the License at  
        AllocationId allocationId2P = AllocationId.newInitializing();  
                "cannot relocate primary shard from a node with version ["
        List<ShardRouting> mutableShardRoutings = routingNodes.shardsWithState(ShardRoutingState.RELOCATING);  
 *
            CLUSTER_MANAGER_DATA_ROLES,
                    .numberOfReplicas(1)  
import org.apache.logging.log4j.Logger;
            .build();  
        }  
                    fromId,
}
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
            clusterState = ClusterState.builder(clusterState).nodes(nodesBuilder).build();
                    + "] is older than the snapshot version ["
            newNode,  
                                allocationId1P
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
    public void testRandom() {  
                    routingNodes.node(fromId).node().getVersion(),
        }  
        int numIndices = between(1, 20);
        assertThat(
        AllocationService strategy = createAllocationService(  
    }
        clusterState = ClusterState.builder(clusterState)
        }  
            .metadata(metadata)  
            .put(
 * license agreements. See the NOTICE file distributed with
        clusterState = strategy.reroute(clusterState, "reroute");
            .build();  
                                    oldNode1.getId(),
                    .add(newNode("new0"))
                                )
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
import org.opensearch.indices.replication.common.ReplicationType;  
        clusterState = strategy.reroute(clusterState, "reroute");
        AllocationId allocationId2P = AllocationId.newInitializing();
            )
                                )
        final DiscoveryNode oldNode1 = new DiscoveryNode(
        );
            CLUSTER_MANAGER_DATA_ROLES,
        }
            .routingTable(routingTable)
        logger.info("start two nodes and fully start the shards");  
                    .settings(settings(Version.CURRENT).put(segmentReplicationSettings))
                                    shard2.getIndexName(),
                                    false,
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode).add(oldNode1).add(oldNode2))
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", VersionUtils.getPreviousVersion())))  
                    } else {
                );
                                TestShardRouting.newShardRouting(  
        assertThat(
                    )
 * not use this file except in compliance with the License.
        );  
                                oldNode2.getId(),
            EmptySnapshotsInfoService.INSTANCE  
    public void testDoNotAllocateFromPrimary() {
            buildNewFakeTransportAddress(),  
import java.util.List;
        );
        assertThat(routingTable.shardsWithState(UNASSIGNED).size(), equalTo(routingTable.allShards().size()));  
            .build();
            )
                assertTrue(routingNodes.node(toId).node().getVersion().onOrAfter(routingNodes.node(fromId).node().getVersion()));
            .routingTable(initialRoutingTable)  
        routingAllocation = new RoutingAllocation(null, routingNodes, clusterState, null, null, 0);
        // Make sure that primary shards are only allocated on the new node  
        AllocationService strategy = new MockAllocationService(  
            .build();
                String fromId = primary.currentNodeId();  
            .add(  
            Settings.builder()
                assertTrue(routingNodes.node(toId).node().getVersion().onOrAfter(routingNodes.node(fromId).node().getVersion()));  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            emptyMap(),  
import static org.hamcrest.core.Is.is;
            clusterState = stabilize(clusterState, service);
            .build();

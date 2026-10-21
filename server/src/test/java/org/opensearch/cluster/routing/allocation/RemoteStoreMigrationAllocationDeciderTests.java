        RoutingNode nonRemoteRoutingNode = clusterState.getRoutingNodes().node(nonRemoteNode.getId());
                "[remote_store migration_direction]: replica shard copy can not be allocated to a non-remote node because a remote store backed index's shard copy can only be allocated to a remote node";
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
        shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).primaryShard();
                "[remote_store migration_direction]: primary shard copy can not be allocated to a non-remote node because a remote store backed index's shard copy can only be allocated to a remote node";
        if (isRemoteStoreBackedIndex) {
    public void testDontAllocateNewPrimaryShardOnNonRemoteNodeForMixedModeAndRemoteStoreDirection() {
import org.opensearch.cluster.routing.allocation.decider.RemoteStoreMigrationAllocationDecider;
import java.util.HashMap;
        .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.DOCREP)
    private final Settings mixedModeCompatibilitySettings = Settings.builder()
            is("[remote_store migration_direction]: primary shard copy can be allocated to a remote node")
        // direction settings
                                    shardId.getIndexName(),
            .build();
            .localNodeId(remoteNode.getId())
        shardCount = 1;
    }
                .metadata(metadata)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
        DiscoveryNode nonRemoteNode1 = getNonRemoteNode();
        String reason = "[remote_store migration_direction]: replica shard copy can be allocated to a non-remote node";
                            )
            (isReplicaAllocation ? "replica" : "primary")
    private final static String TEST_REPO = "test_repo";
            .localNodeId(remoteNode2.getId())
    public void testAllocateNewReplicaShardOnRemoteNodeIfPrimaryShardOnRemoteNodeForMixedModeAndRemoteStoreDirection() {
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            .add(nonRemoteNode2)
        assertThat(decision.type(), is(Decision.Type.NO));
            buildNewFakeTransportAddress(),
import org.opensearch.cluster.routing.ShardRouting;
            .localNodeId(nonRemoteNode1.getId())
import org.opensearch.cluster.ClusterName;
            clusterState.getRoutingNodes(),
        decision = remoteStoreMigrationAllocationDecider.canAllocate(shardRouting, nonRemoteRoutingNode, routingAllocation);
            .add(remoteNode2)
        RoutingNode nonRemoteRoutingNode = clusterState.getRoutingNodes().node(nonRemoteNode2.getId());
    public void testAllocateNewReplicaShardOnNonRemoteNodeIfPrimaryShardOnRemoteNodeForRemoteStoreDirection() {
    private int shardCount, replicaCount;
 *
        routingAllocation.debugDecision(true);
        // allocation decision for non-remote node for remote store backed index
            builder.put(docrepDirectionSettings);
            (isReplicaAllocation ? "replica" : "primary")
    public void testAllocationForNoneDirection() {
            null,
        assertThat(decision.type(), is(type));
        ShardRouting primaryShardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).primaryShard();
    }
        beforeAllocation(REMOTE_STORE.direction);
        Settings.Builder builder = Settings.builder();
        replicaCount = 1;
            "[none migration_direction]: %s shard copy can not be allocated to a remote node for non remote store backed index",
        replicaCount = 1;
            builder.put(mixedModeCompatibilitySettings);
            DiscoveryNodeRole.BUILT_IN_ROLES,
import org.opensearch.cluster.ClusterState;
        DiscoveryNode remoteNode2 = getRemoteNode();
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
        attributes.put(
        .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED)
            .localNodeId(nonRemoteNode1.getId())
        RoutingTable routingTable = RoutingTable.builder()
    public void testAllocateNewReplicaShardOnNonRemoteNodeIfPrimaryShardOnNonRemoteNodeForMixedModeAndRemoteStoreDirection() {
            .localNodeId(nonRemoteNode2.getId())
            shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
            decision.getExplanation().toLowerCase(Locale.ROOT),
        DiscoveryNode remoteNode2 = getRemoteNode();
    }
        DiscoveryNode nonRemoteNode = getNonRemoteNode();
        // primary shard on remote node, new replica's allocation
    private final Settings strictModeCompatibilitySettings = Settings.builder()
            isRemoteStoreBackedIndex = randomBoolean();
        boolean isReplicaAllocation = randomBoolean();
        String reason = String.format(
        prepareRoutingTable(true, nonRemoteNode1.getId());
            "[none migration_direction]: %s shard copy can be allocated to a remote node for remote store backed index",
        discoveryNodes = DiscoveryNodes.builder()
        isRemoteStoreBackedIndex = false;
        }
                            .build()
        beforeAllocation(REMOTE_STORE.direction);
            shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
            .localNodeId(remoteNode.getId())
        // compatibility mode settings
        } else if (compatibilityMode.toLowerCase(Locale.ROOT).equals(RemoteStoreNodeService.CompatibilityMode.MIXED.mode)) {
            Locale.ROOT,
        }
            Locale.ROOT,
        } else if (direction.toLowerCase(Locale.ROOT).equals(RemoteStoreNodeService.Direction.DOCREP.direction)) {
                                TestShardRouting.newShardRouting(
            reason =
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
        assertThat(
    }
            .localNodeId(nonRemoteNode2.getId())
 * under the License.
                IndexRoutingTable.builder(shardId.getIndex())
        shardCount = 1;
                        )
        assertThat(decision.type(), is(Decision.Type.YES));
            clusterState = ClusterState.builder(ClusterName.DEFAULT)
        isMixedMode = true;
            clusterState = getInitialClusterState(customSettings, indexMetadataBuilder, discoveryNodes);
            .add(nonRemoteNode1)
    }
        assertThat(
    }
        return new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                                shardId.getIndexName(),
            )
 *
                            .addShard(
            .add(remoteNode2)
            .add(nonRemoteNode)
                                (isReplicaAllocation ? ShardRoutingState.STARTED : ShardRoutingState.UNASSIGNED)
            : RemoteStoreNodeService.CompatibilityMode.STRICT.mode;
    }
 * You may obtain a copy of the License at
            metadata = Metadata.builder().put(indexMetadataBuilder).build();
        }
            builder.put(strictModeCompatibilitySettings);
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(primaryShardRouting, remoteRoutingNode, routingAllocation);
    // test for STRICT mode
            reason =
            .build();
        DiscoveryNode nonRemoteNode = getNonRemoteNode();
        replicaCount = 0;
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
        boolean isReplicaAllocation = randomBoolean();
        RoutingNode remoteRoutingNode = clusterState.getRoutingNodes().node(remoteNode.getId());
        DiscoveryNode remoteNode = getRemoteNode();
            )
            .add(nonRemoteNode)
    private DiscoveryNode getNonRemoteNode() {
import java.util.Collections;
 * specific language governing permissions and limitations
        discoveryNodes = DiscoveryNodes.builder()
            .localNodeId(remoteNode1.getId())
            .add(remoteNode)
        prepareRoutingTable(isReplicaAllocation, nonRemoteNode1.getId());
    // tests for replica shard copy allocation with MIXED mode and REMOTE_STORE direction
        routingAllocation = new RoutingAllocation(
            .add(nonRemoteNode1)
        isRemoteStoreBackedIndex = true; // remote store backed index
        IndexMetadata.Builder indexMetadataBuilder,
                                shardId.getId(),
        assertThat(decision.type(), is(Decision.Type.NO));
    private ShardId shardId = new ShardId(TEST_INDEX, "_na_", 0);
        prepareRoutingTable(isReplicaAllocation, remoteNode1.getId());
            decision.getExplanation().toLowerCase(Locale.ROOT),
        if (isRemoteStoreBackedIndex) {
                        new IndexShardRoutingTable.Builder(shardId).addShard(
        DiscoveryNode nonRemoteNode1 = getNonRemoteNode();
        String compatibilityMode = isMixedMode
        DiscoveryNode remoteNode = getRemoteNode();
 * the Apache License, Version 2.0 (the "License"); you may
        discoveryNodes = DiscoveryNodes.builder()
import org.opensearch.cluster.routing.ShardRoutingState;
            .build();
                "[remote_store migration_direction]: replica shard copy can not be allocated to a non-remote node because a remote store backed index's shard copy can only be allocated to a remote node";
        discoveryNodes = DiscoveryNodes.builder()
        );
        DiscoveryNode nonRemoteNode = getNonRemoteNode();
        );
            is(
        isMixedMode = false;
            .add(nonRemoteNode2)
            .localNodeId(remoteNode2.getId())
            .add(remoteNode)
        if (isRemoteStoreBackedIndex) {
        );
 * compatible open source license.
            "[remote_store migration_direction]: %s shard copy can be allocated to a non-remote node for strict compatibility mode",
        DiscoveryNodes discoveryNodes
            "[remote_store migration_direction]: %s shard copy can be allocated to a remote node for strict compatibility mode",
        ShardRouting primaryShardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).primaryShard();
        DiscoveryNode nonRemoteNode2 = getNonRemoteNode();
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
 */
        beforeAllocation(REMOTE_STORE.direction);
            .addAsNew(metadata.index(TEST_INDEX))
            customSettings,
import org.opensearch.cluster.node.DiscoveryNode;
                                    false,
        // primary shard on non-remote node, new replica's allocation
            .localNodeId(remoteNode.getId())
 * SPDX-License-Identifier: Apache-2.0
        ShardRouting replicaShardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
import org.opensearch.cluster.routing.RoutingTable;
        return new DiscoveryNode(
            .build();
    }
}
        DiscoveryNode remoteNode = getRemoteNode();
            shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
        ShardRouting replicaShardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
        isMixedMode = true;
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
        DiscoveryNode nonRemoteNode = getNonRemoteNode();
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
        // allocation decision for remote node for remote store backed index
        replicaCount = 1;
                                true,
                    .addIndexShard(
        beforeAllocation(REMOTE_STORE.direction);
            .localNodeId(nonRemoteNode.getId())
import org.opensearch.Version;
        shardCount = 1;
    private Metadata metadata;
            clusterState,
            .add(nonRemoteNode)
        ShardRouting shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).primaryShard();
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
        .put(MIGRATION_DIRECTION_SETTING.getKey(), REMOTE_STORE)
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(primaryShardRouting, nonRemoteRoutingNode, routingAllocation);
        assertThat(decision.type(), is(Decision.Type.NO));
    private void prepareRoutingTable(boolean isReplicaAllocation, String primaryShardNodeId) {
import org.opensearch.cluster.routing.RoutingNode;
            Locale.ROOT,
            .add(remoteNode1)
 * not use this file except in compliance with the License.
    }
            .build();
            .build();
        } else {
        isMixedMode = true;
        // index metadata settings
    private final Settings remoteStoreDirectionSettings = Settings.builder()
        if (direction.toLowerCase(Locale.ROOT).equals(REMOTE_STORE.direction)) {
                    )
        DiscoveryNode remoteNode1 = getRemoteNode();
import org.opensearch.common.settings.ClusterSettings;
        }
            builder.put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .localNodeId(remoteNode.getId())
                .nodes(discoveryNodes)
        if (isRemoteStoreBackedIndex == null) {
                .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, TEST_REPO)
        DiscoveryNode nonRemoteNode2 = getNonRemoteNode();
            UUIDs.base64UUID(),
            "[none migration_direction]: %s shard copy can not be allocated to a non-remote node for remote store backed index",
        DiscoveryNode remoteNode1 = getRemoteNode();
        String reason = "[remote_store migration_direction]: primary shard copy can not be allocated to a non-remote node";
        prepareRoutingTable(true, nonRemoteNode.getId());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        shardCount = 1;
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
        Decision.Type type = Decision.Type.YES;
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(replicaShardRouting, nonRemoteRoutingNode, routingAllocation);
            Version.CURRENT
            .localNodeId(nonRemoteNode.getId())
        DiscoveryNode nonRemoteNode = getNonRemoteNode();
            getClusterSettings(customSettings)
        if (isReplicaAllocation) {
        // allocation decision for non-remote node for non-remote store backed index
 * license agreements. See the NOTICE file distributed with
    private ClusterSettings getClusterSettings(Settings settings) {
        discoveryNodes = DiscoveryNodes.builder()
        assertThat(decision.type(), is(Decision.Type.YES));
            ? RemoteStoreNodeService.CompatibilityMode.MIXED.mode
            builder.put(remoteStoreDirectionSettings);
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.node.DiscoveryNodeRole;
    private void beforeAllocation(String direction) {
        remoteStoreMigrationAllocationDecider = new RemoteStoreMigrationAllocationDecider(
 * The OpenSearch Contributors require contributions made to
    // test for NONE direction
        }
        beforeAllocation(NONE.direction);
        ShardRouting replicaShardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
import java.util.Locale;
            .build();
        beforeAllocation(NONE.direction);
        );
        decision = remoteStoreMigrationAllocationDecider.canAllocate(shardRouting, remoteRoutingNode, routingAllocation);
import static org.opensearch.node.remotestore.RemoteStoreNodeService.Direction.REMOTE_STORE;
    }
        assertThat(decision.type(), is(type));
            "REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_VALUE"
                                )
        reason = String.format(
        assertThat(decision.type(), is(Decision.Type.NO));
            reason =
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
        Settings.Builder builder = settings(Version.CURRENT);
        assertThat(decision.type(), is(Decision.Type.YES));
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
            Locale.ROOT,
    // get node-level settings
            .localNodeId(remoteNode1.getId())
        attributes.put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_VALUE");
        ShardRouting replicaShardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
            .add(remoteNode)
                .put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, TEST_REPO)
        return builder.build();
        builder.put(indexMetadataBuilder.build().getSettings());
        }
        }
    // get a dummy non-remote node
        assertThat(
            (isReplicaAllocation ? "replica" : "primary")
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(replicaShardRouting, nonRemoteRoutingNode, routingAllocation);
            .localNodeId(remoteNode1.getId())
            .add(remoteNode1)
        .build();
        isMixedMode = true;
        );
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
        customSettings = getCustomSettings(direction, compatibilityMode, indexMetadataBuilder);
            .localNodeId(nonRemoteNode.getId())
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(replicaShardRouting, remoteRoutingNode, routingAllocation);
import org.opensearch.cluster.routing.IndexRoutingTable;
        }
                                    ShardRoutingState.UNASSIGNED
            .add(nonRemoteNode)
            (isReplicaAllocation ? "replica" : "primary")
        prepareRoutingTable(isReplicaAllocation, remoteNode1.getId());
            .localNodeId(nonRemoteNode.getId())
import static org.hamcrest.core.Is.is;
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(replicaShardRouting, remoteRoutingNode, routingAllocation);
        assertThat(decision.type(), is(Decision.Type.YES));
    private ClusterState getInitialClusterState(
        RoutingNode nonRemoteRoutingNode = clusterState.getRoutingNodes().node(nonRemoteNode2.getId());
    // get a dummy remote node
        // primary on non-remote node, new replica's allocation
            decision.getExplanation().toLowerCase(Locale.ROOT),
        RoutingNode nonRemoteRoutingNode = clusterState.getRoutingNodes().node(nonRemoteNode.getId());
        reason = String.format(
        );
 */
        shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).primaryShard();
        return ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).routingTable(routingTable).nodes(discoveryNodes).build();
            Locale.ROOT,
        }
public class RemoteStoreMigrationAllocationDeciderTests extends OpenSearchAllocationTestCase {
    }
        DiscoveryNode remoteNode2 = getRemoteNode();
        beforeAllocation(REMOTE_STORE.direction);
                                (isReplicaAllocation ? primaryShardNodeId : null),
        isMixedMode = true;
        if (compatibilityMode.toLowerCase(Locale.ROOT).equals(RemoteStoreNodeService.CompatibilityMode.STRICT.mode)) {
        .build();
        RoutingNode remoteRoutingNode = clusterState.getRoutingNodes().node(remoteNode2.getId());
    // tests for primary shard copy allocation with MIXED mode and REMOTE_STORE direction
        DiscoveryNode remoteNode = getRemoteNode();
                "[remote_store migration_direction]: replica shard copy can be allocated to a remote node since primary shard copy has been migrated to remote"
            .build();
import java.util.Map;
            .add(nonRemoteNode)
        beforeAllocation(REMOTE_STORE.direction);
 * ownership. Elasticsearch licenses this file to you under
        prepareRoutingTable(true, remoteNode1.getId());
    public void testDontAllocateNewReplicaShardOnRemoteNodeIfPrimaryShardOnNonRemoteNodeForMixedModeAndRemoteStoreDirection() {
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
            .localNodeId(nonRemoteNode.getId())
        .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        );
        String reason = String.format(
 * software distributed under the License is distributed on an
    private final static String TEST_INDEX = "test_index";
        reason = String.format(
import org.opensearch.indices.replication.common.ReplicationType;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.index.shard.ShardId;
                                    null,
    private Settings customSettings;
        );
            .addAsNew(indexMetadataBuilder.build())
            0L
        isRemoteStoreBackedIndex = true;
/*
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
    private DiscoveryNode getRemoteNode() {
        isRemoteStoreBackedIndex = false; // non-remote store backed index
    public void testAlwaysAllocateNewShardForStrictMode() {
            type = Decision.Type.NO;
        remoteRoutingNode = clusterState.getRoutingNodes().node(remoteNode2.getId());
        indexMetadataBuilder = getIndexMetadataBuilder(isRemoteStoreBackedIndex, shardCount, replicaCount);
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(shardRouting, nonRemoteRoutingNode, routingAllocation);
/*
            .add(remoteNode)
        isMixedMode = true;
        nonRemoteRoutingNode = clusterState.getRoutingNodes().node(nonRemoteNode2.getId());
        // primary on remote node, new replica's allocation
        DiscoveryNode remoteNode = getRemoteNode();
    // prepare index metadata for test-index
            (isReplicaAllocation ? "replica" : "primary")
        prepareRoutingTable(isReplicaAllocation, nonRemoteNode1.getId());
    private DiscoveryNodes discoveryNodes;
    }
    private Boolean isRemoteStoreBackedIndex = null, isMixedMode;
        return new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
                .build();
        );
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        DiscoveryNode nonRemoteNode2 = getNonRemoteNode();
        DiscoveryNode remoteNode1 = getRemoteNode();
            .localNodeId(nonRemoteNode1.getId())
            .add(remoteNode)
            .build();
        if (isRemoteStoreBackedIndex) {
        RoutingNode remoteRoutingNode = clusterState.getRoutingNodes().node(remoteNode.getId());
 * Licensed to Elasticsearch under one or more contributor
    public void testAllocateNewPrimaryShardOnRemoteNodeForMixedModeAndRemoteStoreDirection() {
        discoveryNodes = DiscoveryNodes.builder()
            .add(nonRemoteNode2)
            .localNodeId(remoteNode.getId())
        RoutingNode remoteRoutingNode = clusterState.getRoutingNodes().node(remoteNode2.getId());
            .build();
        routingTable = RoutingTable.builder()
                .routingTable(routingTable)
import org.opensearch.common.UUIDs;
        discoveryNodes = DiscoveryNodes.builder()
        ShardRouting shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).primaryShard();
    private final Settings docrepDirectionSettings = Settings.builder()
            attributes,
 * Unless required by applicable law or agreed to in writing,
    private IndexMetadata.Builder indexMetadataBuilder;
            (isReplicaAllocation ? "replica" : "primary")
        }
            .localNodeId(remoteNode2.getId())
    private RoutingAllocation routingAllocation;
    ) {
                            )
        DiscoveryNode nonRemoteNode1 = getNonRemoteNode();
        discoveryNodes = DiscoveryNodes.builder()
        .build();
        shardCount = 1;
        replicaCount = 1;
            null,
 *
        replicaCount = 1;
    }
        reason = String.format(
    private ClusterState clusterState;
        shardCount = 1;
            .add(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
 */
            .add(nonRemoteNode1)
        );
            .localNodeId(nonRemoteNode2.getId())
        .build();
                .put(SETTING_REMOTE_STORE_ENABLED, true);
        beforeAllocation(REMOTE_STORE.direction);
    private RoutingTable routingTable = null;
        prepareRoutingTable(true, remoteNode.getId());
import static org.opensearch.node.remotestore.RemoteStoreNodeService.Direction.NONE;
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
        shardCount = 1;
    }
        if (isReplicaAllocation) {
        Decision.Type type = Decision.Type.YES;
            is(
        beforeAllocation(REMOTE_STORE.direction);
        if (isReplicaAllocation) {
            new AllocationDeciders(Collections.singleton(remoteStoreMigrationAllocationDecider)),
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
        String reason = "[remote_store migration_direction]: replica shard copy can be allocated to a non-remote node";
/*
            .add(remoteNode1)
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(shardRouting, nonRemoteRoutingNode, routingAllocation);
        RoutingNode nonRemoteRoutingNode = clusterState.getRoutingNodes().node(nonRemoteNode2.getId());
        assertThat(decision.type(), is(Decision.Type.YES));
        Map<String, String> attributes = new HashMap<>();
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.metadata.IndexMetadata;
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
import org.opensearch.cluster.routing.TestShardRouting;
        }
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
        Metadata metadata = Metadata.builder().persistentSettings(settings).put(indexMetadataBuilder).build();
        if (routingTable != null) {
        if (isReplicaAllocation) {
    }
    private RemoteStoreMigrationAllocationDecider remoteStoreMigrationAllocationDecider;
        );
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
            "[none migration_direction]: %s shard copy can be allocated to a non-remote node for non remote store backed index",
    private Settings getCustomSettings(String direction, String compatibilityMode, IndexMetadata.Builder indexMetadataBuilder) {
        }
    private IndexMetadata.Builder getIndexMetadataBuilder(boolean isRemoteStoreBackedIndex, int shardCount, int replicaCount) {
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
                            TestShardRouting.newShardRouting(
                "[remote_store migration_direction]: replica shard copy can not be allocated to a remote node since primary shard copy is not yet migrated to remote"
    }
        );
        RoutingNode remoteRoutingNode = clusterState.getRoutingNodes().node(remoteNode2.getId());
        return IndexMetadata.builder(TEST_INDEX).settings(builder).numberOfShards(shardCount).numberOfReplicas(replicaCount);
            type = Decision.Type.NO;
            shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
        replicaCount = 0;
import org.opensearch.node.remotestore.RemoteStoreNodeService;
import org.opensearch.cluster.routing.allocation.decider.Decision;
        );
 * GitHub history for details.
            )
        // allocation decision for remote node for non-remote store backed index
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        decision = remoteStoreMigrationAllocationDecider.canAllocate(shardRouting, remoteRoutingNode, routingAllocation);
 * KIND, either express or implied.  See the License for the
        Settings settings,
 *     http://www.apache.org/licenses/LICENSE-2.0
        discoveryNodes = DiscoveryNodes.builder()
            Locale.ROOT,
            .build();
        decision = remoteStoreMigrationAllocationDecider.canAllocate(shardRouting, remoteRoutingNode, routingAllocation);
            .add(remoteNode2)
        shardCount = 1;
                                    shardId.getId(),
        replicaCount = 1;
import org.opensearch.common.settings.Settings;
        isMixedMode = true;
        assertThat(decision.type(), is(Decision.Type.YES));
package org.opensearch.cluster.routing.allocation;

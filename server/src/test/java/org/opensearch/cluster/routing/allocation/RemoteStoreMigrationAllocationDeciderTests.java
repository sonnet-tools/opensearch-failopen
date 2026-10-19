        .build();
                                (isReplicaAllocation ? primaryShardNodeId : null),  
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
            decision.getExplanation().toLowerCase(Locale.ROOT),  
        assertThat(decision.type(), is(Decision.Type.NO));
        DiscoveryNode remoteNode2 = getRemoteNode();  
            .localNodeId(remoteNode.getId())
            .build();
            .add(nonRemoteNode)
            .add(nonRemoteNode)
import java.util.Collections;  
    public void testAllocateNewReplicaShardOnRemoteNodeIfPrimaryShardOnRemoteNodeForMixedModeAndRemoteStoreDirection() {
    // test for NONE direction
            .localNodeId(remoteNode.getId())
            .localNodeId(nonRemoteNode.getId())
                "[remote_store migration_direction]: replica shard copy can be allocated to a remote node since primary shard copy has been migrated to remote"
        RoutingNode nonRemoteRoutingNode = clusterState.getRoutingNodes().node(nonRemoteNode2.getId());
            shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
                    )  
        DiscoveryNode nonRemoteNode1 = getNonRemoteNode();  
            shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);  
        isMixedMode = true;
    }
        if (isRemoteStoreBackedIndex) {
        if (isReplicaAllocation) {
            .add(remoteNode)  
        ShardRouting replicaShardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
                            )  
            .add(
            .add(remoteNode1)
import org.opensearch.common.UUIDs;
        );  
        ShardRouting replicaShardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
        if (isReplicaAllocation) {
        IndexMetadata.Builder indexMetadataBuilder,  
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
            .localNodeId(remoteNode1.getId())  
 * KIND, either express or implied.  See the License for the
            .add(remoteNode2)
        .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.DOCREP)  
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(replicaShardRouting, nonRemoteRoutingNode, routingAllocation);
        if (isReplicaAllocation) {
        shardCount = 1;
        isMixedMode = true;
            (isReplicaAllocation ? "replica" : "primary")  
    }
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(primaryShardRouting, nonRemoteRoutingNode, routingAllocation);  
import java.util.HashMap;
        attributes.put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_VALUE");
        remoteStoreMigrationAllocationDecider = new RemoteStoreMigrationAllocationDecider(
    }
        );
    }  
            clusterState = ClusterState.builder(ClusterName.DEFAULT)
        decision = remoteStoreMigrationAllocationDecider.canAllocate(shardRouting, remoteRoutingNode, routingAllocation);
import org.opensearch.cluster.routing.RoutingTable;
            .build();  
import org.opensearch.common.settings.Settings;
        decision = remoteStoreMigrationAllocationDecider.canAllocate(shardRouting, remoteRoutingNode, routingAllocation);  
        assertThat(decision.type(), is(Decision.Type.YES));
        assertThat(decision.type(), is(Decision.Type.YES));
    }  
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
            .localNodeId(remoteNode2.getId())
        String reason = "[remote_store migration_direction]: primary shard copy can not be allocated to a non-remote node";
            builder.put(docrepDirectionSettings);  
        DiscoveryNode nonRemoteNode = getNonRemoteNode();  
                                    shardId.getId(),
        prepareRoutingTable(true, nonRemoteNode.getId());
            .build();
    private IndexMetadata.Builder getIndexMetadataBuilder(boolean isRemoteStoreBackedIndex, int shardCount, int replicaCount) {  
        if (compatibilityMode.toLowerCase(Locale.ROOT).equals(RemoteStoreNodeService.CompatibilityMode.STRICT.mode)) {
                                    false,
import org.opensearch.core.index.shard.ShardId;
            .localNodeId(nonRemoteNode2.getId())
        Decision.Type type = Decision.Type.YES;
        }  
            .localNodeId(remoteNode.getId())
        return IndexMetadata.builder(TEST_INDEX).settings(builder).numberOfShards(shardCount).numberOfReplicas(replicaCount);
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
    private final static String TEST_REPO = "test_repo";
            reason =  
        return builder.build();  
                                TestShardRouting.newShardRouting(  
        // allocation decision for remote node for non-remote store backed index  
        // index metadata settings
        prepareRoutingTable(true, remoteNode.getId());
    private DiscoveryNode getRemoteNode() {
        assertThat(
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
        ShardRouting replicaShardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
    }
        if (direction.toLowerCase(Locale.ROOT).equals(REMOTE_STORE.direction)) {  
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            buildNewFakeTransportAddress(),
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
        DiscoveryNode remoteNode = getRemoteNode();
            type = Decision.Type.NO;
            )
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
        Metadata metadata = Metadata.builder().persistentSettings(settings).put(indexMetadataBuilder).build();  
    private final static String TEST_INDEX = "test_index";
        isMixedMode = true;
public class RemoteStoreMigrationAllocationDeciderTests extends OpenSearchAllocationTestCase {
            .localNodeId(nonRemoteNode2.getId())  
        isRemoteStoreBackedIndex = true; // remote store backed index
        // primary shard on non-remote node, new replica's allocation  
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(replicaShardRouting, nonRemoteRoutingNode, routingAllocation);
        );  
                "[remote_store migration_direction]: replica shard copy can not be allocated to a non-remote node because a remote store backed index's shard copy can only be allocated to a remote node";
        discoveryNodes = DiscoveryNodes.builder()  
    private Boolean isRemoteStoreBackedIndex = null, isMixedMode;  
    private final Settings remoteStoreDirectionSettings = Settings.builder()
        .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
                .routingTable(routingTable)
        shardCount = 1;
    // tests for primary shard copy allocation with MIXED mode and REMOTE_STORE direction
                .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, TEST_REPO)
        return new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
                .nodes(discoveryNodes)
        }
        prepareRoutingTable(isReplicaAllocation, remoteNode1.getId());
    private ClusterState getInitialClusterState(
    }
        }  
            builder.put(remoteStoreDirectionSettings);
        .build();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
        RoutingNode remoteRoutingNode = clusterState.getRoutingNodes().node(remoteNode.getId());
            clusterState.getRoutingNodes(),  
            ? RemoteStoreNodeService.CompatibilityMode.MIXED.mode
        replicaCount = 1;  
        DiscoveryNode remoteNode = getRemoteNode();  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
 */  
        String reason = "[remote_store migration_direction]: replica shard copy can be allocated to a non-remote node";  
    private int shardCount, replicaCount;
        DiscoveryNode nonRemoteNode2 = getNonRemoteNode();
    public void testDontAllocateNewReplicaShardOnRemoteNodeIfPrimaryShardOnNonRemoteNodeForMixedModeAndRemoteStoreDirection() {
            .add(remoteNode)  
        shardCount = 1;
        if (isRemoteStoreBackedIndex == null) {
        reason = String.format(
            "[none migration_direction]: %s shard copy can not be allocated to a remote node for non remote store backed index",
        ShardRouting replicaShardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
        assertThat(decision.type(), is(Decision.Type.YES));
import static org.opensearch.node.remotestore.RemoteStoreNodeService.Direction.NONE;
        shardCount = 1;
        String reason = String.format(
                .build();  
    }  
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(shardRouting, nonRemoteRoutingNode, routingAllocation);  
        prepareRoutingTable(true, remoteNode1.getId());  
            .localNodeId(nonRemoteNode.getId())
import org.opensearch.cluster.routing.ShardRouting;
package org.opensearch.cluster.routing.allocation;
            metadata = Metadata.builder().put(indexMetadataBuilder).build();
        String compatibilityMode = isMixedMode
    private final Settings docrepDirectionSettings = Settings.builder()
        discoveryNodes = DiscoveryNodes.builder()
    private Settings getCustomSettings(String direction, String compatibilityMode, IndexMetadata.Builder indexMetadataBuilder) {  
        replicaCount = 1;
    private void prepareRoutingTable(boolean isReplicaAllocation, String primaryShardNodeId) {  
            decision.getExplanation().toLowerCase(Locale.ROOT),
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
    private Settings customSettings;  
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(shardRouting, nonRemoteRoutingNode, routingAllocation);  
    private Metadata metadata;
        prepareRoutingTable(isReplicaAllocation, nonRemoteNode1.getId());
        builder.put(indexMetadataBuilder.build().getSettings());
            .localNodeId(nonRemoteNode1.getId())  
            .localNodeId(remoteNode.getId())
            .build();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;  
import org.opensearch.Version;
            .add(remoteNode1)  
            .build();
 * license agreements. See the NOTICE file distributed with
            shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);  
        );
                .put(SETTING_REMOTE_STORE_ENABLED, true);  
        boolean isReplicaAllocation = randomBoolean();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
        if (isRemoteStoreBackedIndex) {
        assertThat(decision.type(), is(type));  
 */
 * Licensed to Elasticsearch under one or more contributor  
            type = Decision.Type.NO;
        // allocation decision for non-remote node for remote store backed index
            .localNodeId(remoteNode.getId())
            .localNodeId(nonRemoteNode2.getId())
                                shardId.getId(),
        }
        }
    }
        // compatibility mode settings  
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
        DiscoveryNode remoteNode = getRemoteNode();
        decision = remoteStoreMigrationAllocationDecider.canAllocate(shardRouting, nonRemoteRoutingNode, routingAllocation);  
                            .build()
        assertThat(
            (isReplicaAllocation ? "replica" : "primary")
            .localNodeId(remoteNode2.getId())  
import org.opensearch.cluster.node.DiscoveryNodes;  
 *
            .add(remoteNode)  
                                shardId.getIndexName(),
                "[remote_store migration_direction]: replica shard copy can not be allocated to a non-remote node because a remote store backed index's shard copy can only be allocated to a remote node";
            is(  
            .add(nonRemoteNode2)
        if (routingTable != null) {  
            .add(remoteNode2)
            Locale.ROOT,  
        } else {
            customSettings,  
        discoveryNodes = DiscoveryNodes.builder()  
import org.opensearch.cluster.ClusterName;
            DiscoveryNodeRole.BUILT_IN_ROLES,  
import org.opensearch.indices.replication.common.ReplicationType;  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        boolean isReplicaAllocation = randomBoolean();  
            clusterState = getInitialClusterState(customSettings, indexMetadataBuilder, discoveryNodes);
            "REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_VALUE"
            (isReplicaAllocation ? "replica" : "primary")
import static org.opensearch.node.remotestore.RemoteStoreNodeService.Direction.REMOTE_STORE;  
        indexMetadataBuilder = getIndexMetadataBuilder(isRemoteStoreBackedIndex, shardCount, replicaCount);
import org.opensearch.cluster.node.DiscoveryNodeRole;
            .add(nonRemoteNode2)  
                        new IndexShardRoutingTable.Builder(shardId).addShard(
        prepareRoutingTable(true, nonRemoteNode1.getId());
            .add(nonRemoteNode)
/*
            "[none migration_direction]: %s shard copy can not be allocated to a non-remote node for remote store backed index",
        assertThat(decision.type(), is(Decision.Type.YES));
            .build();  
        }
                        )
        prepareRoutingTable(isReplicaAllocation, remoteNode1.getId());
        );  
                                (isReplicaAllocation ? ShardRoutingState.STARTED : ShardRoutingState.UNASSIGNED)
        routingAllocation = new RoutingAllocation(
        RoutingNode nonRemoteRoutingNode = clusterState.getRoutingNodes().node(nonRemoteNode.getId());
import org.opensearch.cluster.routing.allocation.decider.Decision;  
        DiscoveryNode remoteNode1 = getRemoteNode();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
        isMixedMode = true;
                                    null,  
        assertThat(decision.type(), is(Decision.Type.NO));
            .localNodeId(remoteNode2.getId())  
        shardCount = 1;
    public void testAllocateNewReplicaShardOnNonRemoteNodeIfPrimaryShardOnRemoteNodeForRemoteStoreDirection() {
        beforeAllocation(REMOTE_STORE.direction);
        assertEquals(2, clusterState.getRoutingTable().allShards().size());  
import org.opensearch.cluster.metadata.IndexMetadata;
            "[none migration_direction]: %s shard copy can be allocated to a remote node for remote store backed index",
        );
        assertThat(  
        ShardRouting primaryShardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).primaryShard();  
import org.opensearch.cluster.routing.IndexRoutingTable;
    private ClusterState clusterState;
        discoveryNodes = DiscoveryNodes.builder()
 * The OpenSearch Contributors require contributions made to  
    }
        remoteRoutingNode = clusterState.getRoutingNodes().node(remoteNode2.getId());  
 * compatible open source license.
 * software distributed under the License is distributed on an
        );  
        beforeAllocation(REMOTE_STORE.direction);  
        }  
            .build();
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(replicaShardRouting, remoteRoutingNode, routingAllocation);
        return ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).routingTable(routingTable).nodes(discoveryNodes).build();
    public void testAlwaysAllocateNewShardForStrictMode() {  
        beforeAllocation(REMOTE_STORE.direction);
import static org.hamcrest.core.Is.is;  
        RoutingNode nonRemoteRoutingNode = clusterState.getRoutingNodes().node(nonRemoteNode2.getId());
    private DiscoveryNode getNonRemoteNode() {
        Settings.Builder builder = settings(Version.CURRENT);
    }  
    }  
        discoveryNodes = DiscoveryNodes.builder()  
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(primaryShardRouting, remoteRoutingNode, routingAllocation);  
            Locale.ROOT,  
import org.opensearch.cluster.metadata.Metadata;  
    public void testAllocationForNoneDirection() {
        // primary on non-remote node, new replica's allocation  
                    .addIndexShard(
        // primary on remote node, new replica's allocation
        String reason = "[remote_store migration_direction]: replica shard copy can be allocated to a non-remote node";  
            null,  
                                    shardId.getIndexName(),
            builder.put(mixedModeCompatibilitySettings);
    public void testDontAllocateNewPrimaryShardOnNonRemoteNodeForMixedModeAndRemoteStoreDirection() {
        replicaCount = 0;  
 * Modifications Copyright OpenSearch Contributors. See
            builder.put(strictModeCompatibilitySettings);
    // get a dummy non-remote node
        String reason = String.format(
    }
            Locale.ROOT,
        shardCount = 1;
import org.opensearch.common.settings.ClusterSettings;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Version.CURRENT
        DiscoveryNode nonRemoteNode = getNonRemoteNode();  
        if (isReplicaAllocation) {
        );
        prepareRoutingTable(isReplicaAllocation, nonRemoteNode1.getId());  
            .localNodeId(nonRemoteNode.getId())
        }
            .add(nonRemoteNode2)
            .add(remoteNode)
        } else if (direction.toLowerCase(Locale.ROOT).equals(RemoteStoreNodeService.Direction.DOCREP.direction)) {
        RoutingNode remoteRoutingNode = clusterState.getRoutingNodes().node(remoteNode2.getId());
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;  
        replicaCount = 0;  
        beforeAllocation(NONE.direction);
        } else if (compatibilityMode.toLowerCase(Locale.ROOT).equals(RemoteStoreNodeService.CompatibilityMode.MIXED.mode)) {  
        DiscoveryNode remoteNode1 = getRemoteNode();
                                true,
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
 * SPDX-License-Identifier: Apache-2.0
        reason = String.format(  
    private IndexMetadata.Builder indexMetadataBuilder;
            .build();
 *  
            clusterState,
        assertThat(decision.type(), is(Decision.Type.YES));
            new AllocationDeciders(Collections.singleton(remoteStoreMigrationAllocationDecider)),
            null,
        replicaCount = 1;
        shardCount = 1;  
        replicaCount = 1;
            .add(nonRemoteNode1)
        isMixedMode = true;
        isRemoteStoreBackedIndex = true;  
 * not use this file except in compliance with the License.
                                )  
        DiscoveryNode remoteNode = getRemoteNode();  
    private DiscoveryNodes discoveryNodes;
 * under the License.  
        attributes.put(  
        DiscoveryNodes discoveryNodes
                            TestShardRouting.newShardRouting(  
    private final Settings strictModeCompatibilitySettings = Settings.builder()
            "[remote_store migration_direction]: %s shard copy can be allocated to a remote node for strict compatibility mode",
            .add(nonRemoteNode1)
        DiscoveryNode nonRemoteNode = getNonRemoteNode();
        Map<String, String> attributes = new HashMap<>();
        isRemoteStoreBackedIndex = false;
        shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).primaryShard();
            .addAsNew(metadata.index(TEST_INDEX))
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
    }
    private void beforeAllocation(String direction) {
            UUIDs.base64UUID(),  
        decision = remoteStoreMigrationAllocationDecider.canAllocate(shardRouting, remoteRoutingNode, routingAllocation);
            attributes,
        ShardRouting shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).primaryShard();  
        discoveryNodes = DiscoveryNodes.builder()  
        isMixedMode = true;
            .localNodeId(nonRemoteNode1.getId())
                            .addShard(
            reason =  
        }
        if (isRemoteStoreBackedIndex) {  
        beforeAllocation(REMOTE_STORE.direction);
        shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).primaryShard();  
        if (isRemoteStoreBackedIndex) {
                            )
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    public void testAllocateNewPrimaryShardOnRemoteNodeForMixedModeAndRemoteStoreDirection() {
            .add(remoteNode)  
        DiscoveryNode nonRemoteNode1 = getNonRemoteNode();  
 */  
import org.opensearch.cluster.ClusterState;  
    // get a dummy remote node  
            builder.put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
        assertThat(decision.type(), is(type));  
        .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED)
        nonRemoteRoutingNode = clusterState.getRoutingNodes().node(nonRemoteNode2.getId());
/*  
/*  
    private ShardId shardId = new ShardId(TEST_INDEX, "_na_", 0);
            )
            Locale.ROOT,  
            (isReplicaAllocation ? "replica" : "primary")
        Settings.Builder builder = Settings.builder();
            .localNodeId(remoteNode1.getId())
            shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).replicaShards().get(0);
            is(
    public void testAllocateNewReplicaShardOnNonRemoteNodeIfPrimaryShardOnNonRemoteNodeForMixedModeAndRemoteStoreDirection() {  
    ) {
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
            decision.getExplanation().toLowerCase(Locale.ROOT),
            )
                .put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, TEST_REPO)
        beforeAllocation(NONE.direction);
import org.opensearch.cluster.routing.ShardRoutingState;  
        ShardRouting primaryShardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).primaryShard();  
                "[remote_store migration_direction]: primary shard copy can not be allocated to a non-remote node because a remote store backed index's shard copy can only be allocated to a remote node";
        // primary shard on remote node, new replica's allocation  
            .localNodeId(remoteNode1.getId())
        reason = String.format(
            (isReplicaAllocation ? "replica" : "primary")
        routingAllocation.debugDecision(true);  
        DiscoveryNode remoteNode2 = getRemoteNode();  
        assertThat(decision.getExplanation().toLowerCase(Locale.ROOT), is(reason));
    // get node-level settings
        replicaCount = 1;  
        isMixedMode = false;  
            .add(nonRemoteNode)
    }
    private ClusterSettings getClusterSettings(Settings settings) {  
    private RemoteStoreMigrationAllocationDecider remoteStoreMigrationAllocationDecider;  
 * GitHub history for details.
            "[none migration_direction]: %s shard copy can be allocated to a non-remote node for non remote store backed index",
        DiscoveryNode remoteNode2 = getRemoteNode();
        DiscoveryNode remoteNode = getRemoteNode();
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
    // tests for replica shard copy allocation with MIXED mode and REMOTE_STORE direction
        discoveryNodes = DiscoveryNodes.builder()  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    }  
        RoutingNode nonRemoteRoutingNode = clusterState.getRoutingNodes().node(nonRemoteNode.getId());
            isRemoteStoreBackedIndex = randomBoolean();  
        .build();  
        discoveryNodes = DiscoveryNodes.builder()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
        // allocation decision for remote node for remote store backed index  
            "[remote_store migration_direction]: %s shard copy can be allocated to a non-remote node for strict compatibility mode",
        RoutingNode nonRemoteRoutingNode = clusterState.getRoutingNodes().node(nonRemoteNode2.getId());
import java.util.Map;  
import org.opensearch.cluster.node.DiscoveryNode;
        Decision decision = remoteStoreMigrationAllocationDecider.canAllocate(replicaShardRouting, remoteRoutingNode, routingAllocation);
            getClusterSettings(customSettings)
        }
        routingTable = RoutingTable.builder()
        DiscoveryNode nonRemoteNode2 = getNonRemoteNode();
        DiscoveryNode nonRemoteNode = getNonRemoteNode();
        .build();  
            .add(nonRemoteNode1)  
        isRemoteStoreBackedIndex = false; // non-remote store backed index  
            0L
        RoutingNode remoteRoutingNode = clusterState.getRoutingNodes().node(remoteNode.getId());
        isMixedMode = true;  
 * You may obtain a copy of the License at  
        DiscoveryNode remoteNode1 = getRemoteNode();
import java.util.Locale;
import org.opensearch.cluster.routing.allocation.decider.RemoteStoreMigrationAllocationDecider;
            is("[remote_store migration_direction]: primary shard copy can be allocated to a remote node")
            (isReplicaAllocation ? "replica" : "primary")  
        beforeAllocation(REMOTE_STORE.direction);
    private RoutingTable routingTable = null;  
            .addAsNew(indexMetadataBuilder.build())  
 *
            .localNodeId(nonRemoteNode.getId())
        .put(MIGRATION_DIRECTION_SETTING.getKey(), REMOTE_STORE)  
    // prepare index metadata for test-index
        );  
            .add(remoteNode2)
                .metadata(metadata)  
            .localNodeId(nonRemoteNode1.getId())
        DiscoveryNode nonRemoteNode = getNonRemoteNode();  
        }
    private final Settings mixedModeCompatibilitySettings = Settings.builder()
        discoveryNodes = DiscoveryNodes.builder()
        );
        Settings settings,
        RoutingNode remoteRoutingNode = clusterState.getRoutingNodes().node(remoteNode2.getId());  
            Locale.ROOT,
        DiscoveryNode nonRemoteNode1 = getNonRemoteNode();
                "[remote_store migration_direction]: replica shard copy can not be allocated to a remote node since primary shard copy is not yet migrated to remote"  
        beforeAllocation(REMOTE_STORE.direction);
            .build();  
            .add(remoteNode1)  
        }  
 * specific language governing permissions and limitations
}
            Locale.ROOT,  
                                    ShardRoutingState.UNASSIGNED
        replicaCount = 1;
        DiscoveryNode nonRemoteNode2 = getNonRemoteNode();
    private RoutingAllocation routingAllocation;
        beforeAllocation(REMOTE_STORE.direction);
        return new DiscoveryNode(
        assertThat(decision.type(), is(Decision.Type.YES));  
            reason =
        reason = String.format(  
        assertThat(decision.type(), is(Decision.Type.NO));
        assertEquals(2, clusterState.getRoutingTable().allShards().size());  
        RoutingTable routingTable = RoutingTable.builder()
import org.opensearch.cluster.routing.RoutingNode;  
        assertEquals(2, clusterState.getRoutingTable().allShards().size());
        // direction settings
        );  
            : RemoteStoreNodeService.CompatibilityMode.STRICT.mode;  
            .add(nonRemoteNode)
        shardCount = 1;  
        customSettings = getCustomSettings(direction, compatibilityMode, indexMetadataBuilder);
        return new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);  
import org.opensearch.cluster.routing.TestShardRouting;
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertThat(decision.type(), is(Decision.Type.NO));
        // allocation decision for non-remote node for non-remote store backed index
            .localNodeId(nonRemoteNode.getId())
            .build();
        );
        ShardRouting shardRouting = clusterState.getRoutingTable().shardRoutingTable(TEST_INDEX, 0).primaryShard();
                IndexRoutingTable.builder(shardId.getIndex())  
        beforeAllocation(REMOTE_STORE.direction);
    // test for STRICT mode
 * ownership. Elasticsearch licenses this file to you under  
        RoutingNode remoteRoutingNode = clusterState.getRoutingNodes().node(remoteNode2.getId());  
        );
            .build();
        Decision.Type type = Decision.Type.YES;

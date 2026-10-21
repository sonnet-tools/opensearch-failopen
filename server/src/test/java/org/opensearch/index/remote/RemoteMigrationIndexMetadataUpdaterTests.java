        indexMetadata.settings(
        Metadata metadata = createIndexMetadataWithDocrepSettings(indexName);
import org.opensearch.cluster.metadata.IndexMetadata;
        assertDocrepSettingsApplied(indexMetadataBuilder.build());
}
import org.opensearch.core.index.Index;
    private void assertRemoteSettingsApplied(IndexMetadata indexMetadata) {
        DiscoveryNodes allNodes = DiscoveryNodes.builder().add(primaryNode).add(replicaNode).build();
            logger
        migrationIndexMetadataUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, indexName);
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(
                    "dummy",
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "DOCUMENT")
    private RoutingTable createRoutingTableReplicasUnassigned(
                    TestShardRouting.newShardRouting(shardId, replicaHostingNode.getId(), false, ShardRoutingState.STARTED)
    private void assertDocrepSettingsApplied(IndexMetadata indexMetadata) {
        assertRemoteSettingsApplied(indexMetadataBuilder.build());
        );
 *
                    "dummy",
    }
    }
                indexShardRoutingTable.addShard(
        );
            IndexShardRoutingTable.Builder indexShardRoutingTable = new IndexShardRoutingTable.Builder(shardId);
            existingIndexMetadata,
    }
            );
        RoutingTable routingTable = createRoutingTableAllShardsStarted(indexName, 1, 1, primaryNode, replicaNode);
        int numberOfReplicas,
                    RemoteStoreEnums.PathType.NAME,
                    )
            )
    public void testMaybeAddRemoteIndexSettingsDoesNotUpdateSettingsWhenAllShardsInDocrep() throws IOException {
                TestShardRouting.newShardRouting(shardId, primaryHostingNode.getId(), true, ShardRoutingState.STARTED)
 * compatible open source license.
        migrationIndexMetadataUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, indexName);
            existingIndexMetadata,
            Settings.builder()
        DiscoveryNodes allNodes = DiscoveryNodes.builder().add(primaryNode).add(replicaNode).build();
        ).build();
                .put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.HASHED_PREFIX.name())
            discoveryNodes,
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(existingIndexMetadata);
    private RoutingTable createRoutingTableReplicasRelocating(
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING;
                .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        DiscoveryNode primaryNode = IndexShardTestUtils.getFakeRemoteEnabledNode("1");
import org.opensearch.cluster.node.DiscoveryNodes;
        );
        assertTrue(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexMetadata.getSettings()));
        int numberOfShards,
        IndexMetadata.Builder builder = IndexMetadata.builder(existingIndexMetadata);
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(indexName);
        )
            logger
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingTable.build());
import org.opensearch.cluster.metadata.Metadata;
        migrationIndexMetadataUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, indexName);
        RoutingTable routingTable = createRoutingTableReplicasUnassigned(indexName, 1, 1, primaryNode);
                )
        IndexMetadata existingIndexMetadata = currentMetadata.index(indexName);
            metadata.settings(),
import org.opensearch.cluster.routing.UnassignedInfo;
                );
        assertFalse(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
                    "dummy"
        migrationIndexMetadataUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, indexName);
        int numberOfShards,
        long currentSettingsVersion = indexMetadataBuilder.settingsVersion();
            existingIndexMetadata,
                .put(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.getKey(), "dummy-tlog-repo")
    public void testMaybeAddRemoteIndexSettingsDoesNotRunWhenSettingsAlreadyPresent() throws IOException {
    ) {
import org.opensearch.test.OpenSearchTestCase;
                );
                TestShardRouting.newShardRouting(shardId, primaryHostingNode.getId(), true, ShardRoutingState.STARTED)
    public void testMaybeUpdateRemoteStorePathStrategyExecutes() {
        return Metadata.builder().put(indexMetadata).build();
        Metadata metadata = createIndexMetadataWithRemoteStoreSettings(indexName);
        Metadata currentMetadata = createIndexMetadataWithRemoteStoreSettings(indexName);
            routingTable,
        DiscoveryNode primaryNode = IndexShardTestUtils.getFakeRemoteEnabledNode("1");
                    CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING.getKey(),
import org.opensearch.indices.replication.common.ReplicationType;
            indexShardRoutingTable.addShard(
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(currentSettingsVersion, indexMetadataBuilder.settingsVersion());
                .put(
    }
                        new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
        assertCustomPathMetadataIsPresent(builder.build());
        RoutingTable routingTable = createRoutingTableAllShardsStarted(indexName, 1, 1, primaryNode, replicaNode);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        IndexMetadata existingIndexMetadata = metadata.index(indexName);
    ) {
            .putCustom(
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(
        long currentSettingsVersion = indexMetadataBuilder.settingsVersion();
import java.util.UUID;
                .build(),
    }
 * this file be licensed under the Apache-2.0 license or a
        DiscoveryNode replicaNode = IndexShardTestUtils.getFakeRemoteEnabledNode("2");
    }
        DiscoveryNode replicaNode = IndexShardTestUtils.getFakeDiscoNode("2");
        DiscoveryNode primaryHostingNode,
        RoutingTable routingTable = createRoutingTableReplicasRelocating(indexName, 1, 1, primaryNode, replicaNode, replicaRelocatingNode);
        int numberOfReplicas,
import org.opensearch.common.settings.Settings;
        }
        IndexMetadata existingIndexMetadata = currentMetadata.index(indexName);
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(IndexShardTestUtils.getFakeRemoteEnabledNode("1")).build();
            logger
        return builder.add(indexRoutingTableBuilder.build()).build();
        for (int i = 0; i < numberOfShards; i++) {
            metadata.settings(),
                )
        IndexMetadata existingIndexMetadata = metadata.index(indexName);
            for (int j = 0; j < numberOfReplicas; j++) {
        migrationIndexMetadataUpdater.maybeUpdateRemoteStoreCustomMetadata(builder, indexName);
        Metadata currentMetadata = createIndexMetadataWithDocrepSettings(indexName);
            routingTable,
                )
import org.opensearch.cluster.routing.IndexRoutingTable;
        String indexName,
        return Metadata.builder().put(indexMetadata).build();
                    ShardRouting.newUnassigned(
        assertTrue(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
            existingIndexMetadata,
            logger
        return builder.add(indexRoutingTableBuilder.build()).build();
        Metadata metadata = createIndexMetadataWithDocrepSettings(indexName);
            existingIndexMetadata,
        DiscoveryNode primaryHostingNode
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingTable.build());
        IndexMetadata existingIndexMetadata = metadata.index(indexName);
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(indexName);
            routingTable,
        for (int i = 0; i < numberOfShards; i++) {
import static org.opensearch.cluster.metadata.IndexMetadata.REMOTE_STORE_CUSTOM_KEY;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    }
            mock(RoutingTable.class),
    }
        DiscoveryNode replicaRelocatingNode = IndexShardTestUtils.getFakeDiscoNode("3");
            metadata.settings(),
    public static Metadata createIndexMetadataWithDocrepSettings(String indexName) {
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(index);
    }
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(
        migrationIndexMetadataUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, indexName);
                indexShardRoutingTable.addShard(
            allNodes,
        long currentSettingsVersion = indexMetadataBuilder.settingsVersion();
        RoutingTable.Builder builder = RoutingTable.builder();
                        false,
            .build();
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        DiscoveryNodes allNodes = DiscoveryNodes.builder().add(primaryNode).add(replicaNode).build();
                    TestShardRouting.newShardRouting(
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(existingIndexMetadata);
                    )
import org.opensearch.core.index.shard.ShardId;
            logger
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        );
        );
        Metadata metadata = createIndexMetadataWithDocrepSettings(indexName);
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT")
    private RoutingTable createRoutingTableAllShardsStarted(
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingTable.build());
                .put(
        long currentSettingsVersion = indexMetadataBuilder.settingsVersion();
                    IndexMetadata.TRANSLOG_METADATA_KEY,
    public static Metadata createIndexMetadataWithRemoteStoreSettings(String indexName) {
        assertNotNull(indexMetadata.getCustomData(REMOTE_STORE_CUSTOM_KEY));
        );
        return builder.add(indexRoutingTableBuilder.build()).build();
            mock(RoutingTable.class),
            allNodes,
            IndexShardRoutingTable.Builder indexShardRoutingTable = new IndexShardRoutingTable.Builder(shardId);
                TestShardRouting.newShardRouting(shardId, primaryHostingNodes.getId(), true, ShardRoutingState.STARTED)
        assertCustomPathMetadataIsPresent(builder.build());
        for (int i = 0; i < numberOfShards; i++) {
import org.opensearch.Version;
        assertFalse(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexMetadata.getSettings()));
            allNodes,
        int numberOfReplicas,
        }
    public void testMaybeUpdateRemoteStorePathStrategyDoesNotExecute() {
            Settings.builder()
        }
            ShardId shardId = new ShardId(index, i);
        DiscoveryNode replicaNode = IndexShardTestUtils.getFakeRemoteEnabledNode("2");
        assertFalse(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            Settings.builder()
import java.io.IOException;
                    RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1.name()
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(existingIndexMetadata);
    }
package org.opensearch.index.remote;
        assertNotNull(indexMetadata.getCustomData(REMOTE_STORE_CUSTOM_KEY).get(RemoteStoreEnums.PathHashAlgorithm.NAME));
import org.opensearch.index.shard.IndexShardTestUtils;
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(
            routingTable,
        DiscoveryNode primaryNode = IndexShardTestUtils.getFakeRemoteEnabledNode("1");
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(existingIndexMetadata);
        DiscoveryNode primaryHostingNodes,
        DiscoveryNode replicaRelocatingNode
import org.opensearch.cluster.routing.TestShardRouting;
import org.opensearch.cluster.node.DiscoveryNode;
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(IndexShardTestUtils.getFakeRemoteEnabledNode("1")).build();
    public void testMaybeAddRemoteIndexSettingsUpdatesIndexSettingsWithUnassignedReplicas() throws IOException {
        assertNotNull(indexMetadata.getCustomData(REMOTE_STORE_CUSTOM_KEY).get(RemoteStoreEnums.PathType.NAME));
                    CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING.getKey(),
        migrationIndexMetadataUpdater.maybeUpdateRemoteStoreCustomMetadata(builder, indexName);
            for (int j = 0; j < numberOfReplicas; j++) {
        assertEquals(ReplicationType.DOCUMENT, IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(indexMetadata.getSettings()));
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(existingIndexMetadata);
import org.opensearch.cluster.routing.ShardRoutingState;
import static org.mockito.Mockito.mock;
                        false,
        RoutingTable routingTable = createRoutingTableAllShardsStarted(indexName, 1, 1, primaryNode, replicaNode);
    public void testMaybeAddRemoteIndexSettingsDoesNotUpdateIndexSettingsWithRelocatingReplicas() throws IOException {
    }
            existingIndexMetadata,
import org.opensearch.cluster.routing.RecoverySource;
        IndexMetadata existingIndexMetadata = metadata.index(indexName);
                        RecoverySource.PeerRecoverySource.INSTANCE,
                        shardId,
            routingTable,
                        replicaRelocatingNode.getId(),
        assertEquals(currentSettingsVersion, indexMetadataBuilder.settingsVersion());
 * The OpenSearch Contributors require contributions made to
        DiscoveryNode primaryNode = IndexShardTestUtils.getFakeDiscoNode("1");
        Metadata metadata = createIndexMetadataWithDocrepSettings(indexName);
        DiscoveryNode replicaHostingNode,
            logger
        DiscoveryNodes allNodes = DiscoveryNodes.builder().add(primaryNode).add(replicaNode).build();
public class RemoteMigrationIndexMetadataUpdaterTests extends OpenSearchTestCase {
        assertTrue(currentSettingsVersion < indexMetadataBuilder.settingsVersion());
        Index index = new Index(indexName, UUID.randomUUID().toString());
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            );
import java.util.Map;
    }
        DiscoveryNodes allNodes = DiscoveryNodes.builder().add(primaryNode).add(replicaNode).build();
        long currentSettingsVersion = indexMetadataBuilder.settingsVersion();
            existingIndexMetadata,
                REMOTE_STORE_CUSTOM_KEY,
        assertEquals(currentSettingsVersion, indexMetadataBuilder.settingsVersion());
                    RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1.name()
        String indexName,
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(index);
    }
        assertRemoteSettingsApplied(indexMetadataBuilder.build());
        RoutingTable.Builder builder = RoutingTable.builder();
        );
                .build()
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;
        assertTrue(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
        IndexMetadata.Builder builder = IndexMetadata.builder(currentMetadata.index(indexName));
    ) {
                .build(),
        int numberOfShards,
    }
                        ShardRoutingState.RELOCATING
            discoveryNodes,
        IndexMetadata existingIndexMetadata = metadata.index(indexName);
                        replicaHostingNode.getId(),
            indexShardRoutingTable.addShard(
 */
            metadata.settings(),
import org.opensearch.cluster.routing.RoutingTable;
            ShardId shardId = new ShardId(index, i);
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(
    private final String indexName = "test-index";
            ShardId shardId = new ShardId(index, i);
        DiscoveryNode primaryNode = IndexShardTestUtils.getFakeRemoteEnabledNode("1");
                .build()
            }
            IndexShardRoutingTable.Builder indexShardRoutingTable = new IndexShardRoutingTable.Builder(shardId);
            indexShardRoutingTable.addShard(
            for (int j = 0; j < numberOfReplicas; j++) {
    public void testMaybeAddRemoteIndexSettingsAllPrimariesAndReplicasOnRemote() throws IOException {
        Index index = new Index(indexName, UUID.randomUUID().toString());
/*
        RoutingTable.Builder builder = RoutingTable.builder();
            }
        assertDocrepSettingsApplied(indexMetadataBuilder.build());
            );
                indexShardRoutingTable.addShard(
            logger
        DiscoveryNode replicaNode = IndexShardTestUtils.getFakeDiscoNode("2");
            allNodes,
        indexMetadata.settings(
            }
        String indexName,
                Map.of(
        assertEquals(ReplicationType.SEGMENT, IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(indexMetadata.getSettings()));
import org.opensearch.cluster.routing.ShardRouting;
            metadata.settings(),
                        shardId,
            allNodes,
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(
        DiscoveryNode replicaNode = IndexShardTestUtils.getFakeDiscoNode("2");
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(index);
            Settings.builder()
        DiscoveryNode replicaHostingNode
        Index index = new Index(indexName, UUID.randomUUID().toString());
                );
    private void assertCustomPathMetadataIsPresent(IndexMetadata indexMetadata) {
    }
                .put(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.getKey(), "dummy-segment-repo")
                .put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.HASHED_PREFIX.name())
        assertTrue(currentSettingsVersion < indexMetadataBuilder.settingsVersion());
                    RemoteStoreEnums.PathHashAlgorithm.NAME,
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)

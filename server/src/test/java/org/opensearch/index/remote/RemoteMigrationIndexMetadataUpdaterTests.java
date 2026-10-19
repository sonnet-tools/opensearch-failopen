                );  
            routingTable,
import org.opensearch.cluster.routing.IndexRoutingTable;  
        Index index = new Index(indexName, UUID.randomUUID().toString());  
    public static Metadata createIndexMetadataWithRemoteStoreSettings(String indexName) {  
                    "dummy",
        assertFalse(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(  
        ).build();
        migrationIndexMetadataUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, indexName);
        RoutingTable routingTable = createRoutingTableAllShardsStarted(indexName, 1, 1, primaryNode, replicaNode);
 * compatible open source license.
        DiscoveryNodes allNodes = DiscoveryNodes.builder().add(primaryNode).add(replicaNode).build();
            existingIndexMetadata,
            )
                    RemoteStoreEnums.PathType.NAME,
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;  
        DiscoveryNode replicaRelocatingNode = IndexShardTestUtils.getFakeDiscoNode("3");  
        DiscoveryNodes allNodes = DiscoveryNodes.builder().add(primaryNode).add(replicaNode).build();  
import org.opensearch.cluster.node.DiscoveryNode;
        DiscoveryNode primaryNode = IndexShardTestUtils.getFakeRemoteEnabledNode("1");
        Index index = new Index(indexName, UUID.randomUUID().toString());
        for (int i = 0; i < numberOfShards; i++) {
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        DiscoveryNode replicaHostingNode  
        DiscoveryNode replicaNode = IndexShardTestUtils.getFakeRemoteEnabledNode("2");  
        DiscoveryNode replicaHostingNode,
        IndexMetadata existingIndexMetadata = metadata.index(indexName);
    private RoutingTable createRoutingTableReplicasRelocating(
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(indexName);
        assertFalse(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));  
    private void assertRemoteSettingsApplied(IndexMetadata indexMetadata) {
        RoutingTable.Builder builder = RoutingTable.builder();
                Map.of(  
        assertCustomPathMetadataIsPresent(builder.build());
 * this file be licensed under the Apache-2.0 license or a
            indexShardRoutingTable.addShard(
            allNodes,
        assertTrue(currentSettingsVersion < indexMetadataBuilder.settingsVersion());
            logger
            metadata.settings(),
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                )
 */  
        String indexName,
    }
    public static Metadata createIndexMetadataWithDocrepSettings(String indexName) {
    }
        assertTrue(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexMetadata.getSettings()));  
/*  
import org.opensearch.cluster.metadata.Metadata;  
            existingIndexMetadata,
import org.opensearch.common.settings.Settings;
public class RemoteMigrationIndexMetadataUpdaterTests extends OpenSearchTestCase {  
            IndexShardRoutingTable.Builder indexShardRoutingTable = new IndexShardRoutingTable.Builder(shardId);
                    )  
import static org.opensearch.cluster.metadata.IndexMetadata.REMOTE_STORE_CUSTOM_KEY;
                )
        return builder.add(indexRoutingTableBuilder.build()).build();
            logger
        indexMetadata.settings(
        DiscoveryNodes allNodes = DiscoveryNodes.builder().add(primaryNode).add(replicaNode).build();
                .put(
                .put(
        String indexName,  
                TestShardRouting.newShardRouting(shardId, primaryHostingNode.getId(), true, ShardRoutingState.STARTED)  
                );
        return builder.add(indexRoutingTableBuilder.build()).build();  
        assertRemoteSettingsApplied(indexMetadataBuilder.build());  
    private void assertCustomPathMetadataIsPresent(IndexMetadata indexMetadata) {
    }
        assertTrue(currentSettingsVersion < indexMetadataBuilder.settingsVersion());
        IndexMetadata.Builder builder = IndexMetadata.builder(currentMetadata.index(indexName));
        assertFalse(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexMetadata.getSettings()));
            IndexShardRoutingTable.Builder indexShardRoutingTable = new IndexShardRoutingTable.Builder(shardId);
            .build();  
        indexMetadata.settings(  
                    ShardRouting.newUnassigned(
                        shardId,
                )
                .build(),  
            Settings.builder()
import org.opensearch.core.index.Index;  
                    "dummy",
        int numberOfReplicas,
            allNodes,
import java.util.Map;
        }  
            ShardId shardId = new ShardId(index, i);
        );  
import java.util.UUID;
        );
                indexShardRoutingTable.addShard(  
        Metadata metadata = createIndexMetadataWithDocrepSettings(indexName);
            existingIndexMetadata,
        IndexMetadata existingIndexMetadata = metadata.index(indexName);
        assertNotNull(indexMetadata.getCustomData(REMOTE_STORE_CUSTOM_KEY).get(RemoteStoreEnums.PathType.NAME));  
            allNodes,  
        DiscoveryNode replicaNode = IndexShardTestUtils.getFakeRemoteEnabledNode("2");  
            existingIndexMetadata,  
            );
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    ) {  
        migrationIndexMetadataUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, indexName);  
package org.opensearch.index.remote;
        assertDocrepSettingsApplied(indexMetadataBuilder.build());
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingTable.build());
            allNodes,  
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(existingIndexMetadata);  
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingTable.build());  
            routingTable,
            metadata.settings(),  
                        shardId,
            routingTable,
                .put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.HASHED_PREFIX.name())  
            logger
    }  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                REMOTE_STORE_CUSTOM_KEY,
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(  
        Metadata metadata = createIndexMetadataWithRemoteStoreSettings(indexName);
    private final String indexName = "test-index";
            Settings.builder()
import java.io.IOException;  
import org.opensearch.test.OpenSearchTestCase;
        assertCustomPathMetadataIsPresent(builder.build());
 * The OpenSearch Contributors require contributions made to  
        DiscoveryNodes allNodes = DiscoveryNodes.builder().add(primaryNode).add(replicaNode).build();  
            IndexShardRoutingTable.Builder indexShardRoutingTable = new IndexShardRoutingTable.Builder(shardId);
        DiscoveryNode primaryHostingNodes,  
    }
                    CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING.getKey(),  
            mock(RoutingTable.class),
                .put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.HASHED_PREFIX.name())
import org.opensearch.index.shard.IndexShardTestUtils;
        RoutingTable.Builder builder = RoutingTable.builder();
    }  
        RoutingTable routingTable = createRoutingTableReplicasRelocating(indexName, 1, 1, primaryNode, replicaNode, replicaRelocatingNode);
        IndexMetadata existingIndexMetadata = metadata.index(indexName);
    ) {
                    IndexMetadata.TRANSLOG_METADATA_KEY,
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(IndexShardTestUtils.getFakeRemoteEnabledNode("1")).build();
                        false,  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import org.opensearch.cluster.routing.ShardRouting;
        IndexMetadata existingIndexMetadata = currentMetadata.index(indexName);
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingTable.build());
            ShardId shardId = new ShardId(index, i);  
            mock(RoutingTable.class),
    public void testMaybeAddRemoteIndexSettingsDoesNotRunWhenSettingsAlreadyPresent() throws IOException {  
                    RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1.name()
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(
            allNodes,
            existingIndexMetadata,  
                );
        long currentSettingsVersion = indexMetadataBuilder.settingsVersion();  
        migrationIndexMetadataUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, indexName);  
        assertTrue(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
                    "dummy"  
                TestShardRouting.newShardRouting(shardId, primaryHostingNodes.getId(), true, ShardRoutingState.STARTED)  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            }
        String indexName,
        }
import org.opensearch.cluster.node.DiscoveryNodes;
        DiscoveryNode primaryHostingNode,
            metadata.settings(),
                .put(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.getKey(), "dummy-tlog-repo")
        assertRemoteSettingsApplied(indexMetadataBuilder.build());
        Metadata currentMetadata = createIndexMetadataWithRemoteStoreSettings(indexName);
        );  
        for (int i = 0; i < numberOfShards; i++) {
            logger
        IndexMetadata existingIndexMetadata = currentMetadata.index(indexName);  
        DiscoveryNode replicaNode = IndexShardTestUtils.getFakeDiscoNode("2");
        );
        DiscoveryNode primaryNode = IndexShardTestUtils.getFakeRemoteEnabledNode("1");
                .put(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.getKey(), "dummy-segment-repo")  
    ) {  
        assertEquals(ReplicationType.SEGMENT, IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(indexMetadata.getSettings()));  
                .build()  
                    RemoteStoreEnums.PathHashAlgorithm.NAME,  
        DiscoveryNode primaryHostingNode
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT")
                    TestShardRouting.newShardRouting(
        RoutingTable.Builder builder = RoutingTable.builder();
        for (int i = 0; i < numberOfShards; i++) {  
                    RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1.name()  
        )  
        );  
            routingTable,
        assertNotNull(indexMetadata.getCustomData(REMOTE_STORE_CUSTOM_KEY));
                        ShardRoutingState.RELOCATING  
    }  
        long currentSettingsVersion = indexMetadataBuilder.settingsVersion();  
        migrationIndexMetadataUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, indexName);
        DiscoveryNode replicaRelocatingNode
import org.opensearch.cluster.routing.TestShardRouting;  
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(index);
            Settings.builder()  
        int numberOfReplicas,
        RoutingTable routingTable = createRoutingTableAllShardsStarted(indexName, 1, 1, primaryNode, replicaNode);
        assertEquals(currentSettingsVersion, indexMetadataBuilder.settingsVersion());
    public void testMaybeAddRemoteIndexSettingsDoesNotUpdateSettingsWhenAllShardsInDocrep() throws IOException {
            );
        IndexMetadata existingIndexMetadata = metadata.index(indexName);
        long currentSettingsVersion = indexMetadataBuilder.settingsVersion();
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(existingIndexMetadata);
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(
        int numberOfShards,  
        RoutingTable routingTable = createRoutingTableAllShardsStarted(indexName, 1, 1, primaryNode, replicaNode);
            indexShardRoutingTable.addShard(
    }  
                    TestShardRouting.newShardRouting(shardId, replicaHostingNode.getId(), false, ShardRoutingState.STARTED)
            for (int j = 0; j < numberOfReplicas; j++) {
        }
                .build()
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "DOCUMENT")
        return builder.add(indexRoutingTableBuilder.build()).build();
    }  
        assertEquals(ReplicationType.DOCUMENT, IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(indexMetadata.getSettings()));
                TestShardRouting.newShardRouting(shardId, primaryHostingNode.getId(), true, ShardRoutingState.STARTED)
            indexShardRoutingTable.addShard(  
    public void testMaybeUpdateRemoteStorePathStrategyExecutes() {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexMetadata;
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(existingIndexMetadata);
        assertEquals(currentSettingsVersion, indexMetadataBuilder.settingsVersion());
            existingIndexMetadata,  
                .build(),
}  
        assertNotNull(indexMetadata.getCustomData(REMOTE_STORE_CUSTOM_KEY).get(RemoteStoreEnums.PathHashAlgorithm.NAME));
        DiscoveryNodes allNodes = DiscoveryNodes.builder().add(primaryNode).add(replicaNode).build();
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING;
    public void testMaybeUpdateRemoteStorePathStrategyDoesNotExecute() {
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(  
                    CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING.getKey(),
import org.opensearch.cluster.routing.ShardRoutingState;
import org.opensearch.indices.replication.common.ReplicationType;  
        );  
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(index);
        migrationIndexMetadataUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, indexName);
        );
                .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        migrationIndexMetadataUpdater.maybeUpdateRemoteStoreCustomMetadata(builder, indexName);
    }
        IndexMetadata existingIndexMetadata = metadata.index(indexName);
        DiscoveryNode replicaNode = IndexShardTestUtils.getFakeDiscoNode("2");
    }
            for (int j = 0; j < numberOfReplicas; j++) {  
        Index index = new Index(indexName, UUID.randomUUID().toString());
            metadata.settings(),  
    private RoutingTable createRoutingTableAllShardsStarted(
            logger
        migrationIndexMetadataUpdater.maybeUpdateRemoteStoreCustomMetadata(builder, indexName);  
        int numberOfShards,  
    public void testMaybeAddRemoteIndexSettingsAllPrimariesAndReplicasOnRemote() throws IOException {  
import static org.mockito.Mockito.mock;
        RoutingTable routingTable = createRoutingTableReplicasUnassigned(indexName, 1, 1, primaryNode);
        int numberOfShards,
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        DiscoveryNode primaryNode = IndexShardTestUtils.getFakeRemoteEnabledNode("1");
import org.opensearch.Version;
 *
import org.opensearch.cluster.routing.UnassignedInfo;
        Metadata metadata = createIndexMetadataWithDocrepSettings(indexName);  
        long currentSettingsVersion = indexMetadataBuilder.settingsVersion();
                        replicaRelocatingNode.getId(),
            }
                indexShardRoutingTable.addShard(  
                        new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
        Metadata metadata = createIndexMetadataWithDocrepSettings(indexName);  
            Settings.builder()  
                indexShardRoutingTable.addShard(
import org.opensearch.cluster.routing.RoutingTable;  
        DiscoveryNode primaryNode = IndexShardTestUtils.getFakeRemoteEnabledNode("1");
            for (int j = 0; j < numberOfReplicas; j++) {
            ShardId shardId = new ShardId(index, i);  
        return Metadata.builder().put(indexMetadata).build();
        IndexMetadata.Builder builder = IndexMetadata.builder(existingIndexMetadata);  
    }
            discoveryNodes,
        Metadata metadata = createIndexMetadataWithDocrepSettings(indexName);  
            }  
        long currentSettingsVersion = indexMetadataBuilder.settingsVersion();  
            metadata.settings(),
    public void testMaybeAddRemoteIndexSettingsUpdatesIndexSettingsWithUnassignedReplicas() throws IOException {
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(
    }
import org.opensearch.cluster.routing.RecoverySource;
import org.opensearch.core.index.shard.ShardId;
            discoveryNodes,  
        return Metadata.builder().put(indexMetadata).build();
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(IndexShardTestUtils.getFakeRemoteEnabledNode("1")).build();
        assertEquals(currentSettingsVersion, indexMetadataBuilder.settingsVersion());
        DiscoveryNode replicaNode = IndexShardTestUtils.getFakeDiscoNode("2");
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(existingIndexMetadata);
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(indexName);
        RemoteMigrationIndexMetadataUpdater migrationIndexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(  
            routingTable,
            .putCustom(
            logger
    }
        assertDocrepSettingsApplied(indexMetadataBuilder.build());  
    }
            existingIndexMetadata,  
            logger
    private RoutingTable createRoutingTableReplicasUnassigned(
    private void assertDocrepSettingsApplied(IndexMetadata indexMetadata) {  
        int numberOfReplicas,
                        false,
        DiscoveryNode primaryNode = IndexShardTestUtils.getFakeDiscoNode("1");
                    )
        Metadata currentMetadata = createIndexMetadataWithDocrepSettings(indexName);
                        replicaHostingNode.getId(),  
                        RecoverySource.PeerRecoverySource.INSTANCE,
    public void testMaybeAddRemoteIndexSettingsDoesNotUpdateIndexSettingsWithRelocatingReplicas() throws IOException {
        assertTrue(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(index);
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(existingIndexMetadata);  
            );

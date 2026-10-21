     * @param indexSettings Current index settings
            .put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, translogRepository);
     *
    private final Settings clusterSettings;
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
import org.opensearch.cluster.routing.IndexRoutingTable;
        return Objects.nonNull(customMetadata)
     */
                .allMatch(shardRouting -> shardRouting.started() && discoveryNodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());
                || Objects.nonNull(customMetadata.get(IndexMetadata.TRANSLOG_METADATA_KEY)));
            Map<String, String> remoteRepoNames = getRemoteStoreRepoName(discoveryNodes);
            logger.info(
import org.opensearch.cluster.routing.ShardRouting;
     * - index.remote_store.enabled == true
import org.opensearch.indices.replication.common.ReplicationType;
        RoutingTable routingTable,
     *
        }
            indexMetadataBuilder.putCustom(
            logger.info("Adding remote store custom data for index [{}] during migration", index);
     *
     */
     *
     * This is run during state change of each shard copy when the cluster is in `MIXED` mode and the direction of migration is `REMOTE_STORE`
/**
            .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, segmentRepository)
     * Assert current index settings have:
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
            && IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(indexSettings)
    private final IndexMetadata indexMetadata;
 * compatible open source license.
import org.opensearch.cluster.routing.RoutingTable;
    private final DiscoveryNodes discoveryNodes;
    public RemoteMigrationIndexMetadataUpdater(
    public void maybeUpdateRemoteStoreCustomMetadata(IndexMetadata.Builder indexMetadataBuilder, String index) {
     * Updates the remote store custom metadata for the index when it is migrating to remote.
        } else {
        assert currentIndexSettings != null : "IndexMetadata for a shard cannot be null";
     * Also appends the requisite Remote Store Path based custom metadata to the existing index metadata
     * @return <code>true</code> if all above conditions match. <code>false</code> otherwise
 *
     * @return <code>true</code> if all above conditions match. <code>false</code> otherwise
    }
    }
     * If it does, checks if the path_type sub-key is present
                .stream()
        return false;
        this.indexMetadata = indexMetadata;
     * Should not interfere with docrep functionality even if the index is in docrep nodes since this metadata
import java.util.Objects;
        if (indexHasRemoteStoreSettings(currentIndexSettings) == false) {
     * - index.remote_store.translog.repository != null
    }
    }
    private boolean needsRemoteIndexSettingsUpdate(
        settingsBuilder.put(SETTING_REMOTE_STORE_ENABLED, true)
import org.apache.logging.log4j.Logger;
     * - All primary shards are in {@link ShardRoutingState#STARTED} state and are in remote store enabled nodes
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
    ) {
            return allPrimariesStartedAndOnRemote && noRelocatingReplicas && allStartedReplicasOnRemote;
     * @param indexMetadataBuilder Mutated {@link IndexMetadata.Builder} having the previous state updates
    private final Logger logger;
public class RemoteMigrationIndexMetadataUpdater {
 * SPDX-License-Identifier: Apache-2.0
    public static boolean indexHasAllRemoteStoreRelatedMetadata(IndexMetadata indexMetadata) {
            );
            && (Objects.nonNull(customMetadata.get(PathType.NAME))
        this.discoveryNodes = discoveryNodes;
    }
        }
                determineRemoteStoreCustomMetadataDuringMigration(clusterSettings, discoveryNodes)
     * once all shards of an index have moved over to remote store enabled nodes
    /**
     * - index.remote_store.segment.repository != null
import java.util.Map;
        return IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.exists(indexSettings)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
            boolean noRelocatingReplicas = replicaShards.stream().noneMatch(ShardRouting::relocating);
 */
    }
    }
     * - All {@link ShardRoutingState#STARTED} replica shards are in remote store enabled nodes
            boolean allStartedReplicasOnRemote = replicaShards.stream()
}
        }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
        if (needsRemoteIndexSettingsUpdate(routingTable.indicesRouting().get(index), discoveryNodes, currentIndexSettings)) {
            && IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(indexSettings) == ReplicationType.SEGMENT;
import org.opensearch.cluster.node.DiscoveryNodes;
     * During docrep to remote store migration, applies the following remote store based index settings
        if (indexHasRemoteCustomMetadata(indexMetadata) == false) {
import org.opensearch.cluster.metadata.IndexMetadata;
package org.opensearch.index.remote;
     * - No replica shard in {@link ShardRoutingState#RELOCATING} state
        Settings currentIndexSettings = indexMetadata.getSettings();
     */
                .filter(ShardRouting::started)
 * The OpenSearch Contributors require contributions made to
     * - index.replication.type == SEGMENT
    public static boolean indexHasRemoteCustomMetadata(IndexMetadata indexMetadata) {
    /**
     * <br>
        DiscoveryNodes discoveryNodes,
    public static boolean indexHasRemoteStoreSettings(Settings indexSettings) {
    public void maybeAddRemoteIndexSettings(IndexMetadata.Builder indexMetadataBuilder, String index) {
            && IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(indexSettings)
import org.opensearch.common.settings.Settings;
            indexMetadataBuilder.settingsVersion(1 + indexMetadata.getSettingsVersion());
        this.routingTable = routingTable;
    public static void updateRemoteStoreSettings(Settings.Builder settingsBuilder, String segmentRepository, String translogRepository) {
                REMOTE_STORE_CUSTOM_KEY,
            assert Objects.nonNull(segmentRepoName) && Objects.nonNull(tlogRepoName) : "Remote repo names cannot be null";
import static org.opensearch.index.remote.RemoteStoreUtils.getRemoteStoreRepoName;
                "Index {} does not have remote store based index settings but all primary shards and STARTED replica shards have moved to remote enabled nodes. Applying remote store settings to the index",
            );
    /**
    /**
        IndexMetadata indexMetadata,
        this.clusterSettings = clusterSettings;
import static org.opensearch.cluster.metadata.IndexMetadata.REMOTE_STORE_CUSTOM_KEY;
            List<ShardRouting> replicaShards = indexRoutingTable.shardsMatchingPredicate(shardRouting -> shardRouting.primary() == false);
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    /**
/*
    private final RoutingTable routingTable;
        Logger logger
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
        Settings clusterSettings,
        this.logger = logger;
        IndexRoutingTable indexRoutingTable,
     * @param indexRoutingTable    current {@link IndexRoutingTable} from cluster state
     */
 * @opensearch.internal
        return indexHasRemoteStoreSettings(indexMetadata.getSettings()) && indexHasRemoteCustomMetadata(indexMetadata);
     * Asserts current index metadata customs has the {@link IndexMetadata#REMOTE_STORE_CUSTOM_KEY} key.
    ) {
     * is not used anywhere in the docrep flow
            logger.debug("Index {} already has remote store custom data", index);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
     * @param currentIndexSettings current {@link IndexMetadata} from cluster state
                .allMatch(shardRouting -> discoveryNodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());
     */
 * Utils for checking and mutating cluster state during remote migration
            String segmentRepoName = RemoteStoreNodeAttribute.getSegmentRepoName(remoteRepoNames);
        } else {
     * Checks are in place to make this execution no-op if the index metadata is already present.
            String tlogRepoName = RemoteStoreNodeAttribute.getTranslogRepoName(remoteRepoNames);
        Settings currentIndexSettings
     * @param discoveryNodes       set of discovery nodes from cluster state
                index
            logger.debug("Index {} does not satisfy criteria for applying remote store settings", index);
     * @param indexMetadata Current index metadata
        DiscoveryNodes discoveryNodes,
        Map<String, String> customMetadata = indexMetadata.getCustomData(REMOTE_STORE_CUSTOM_KEY);
 *
            indexMetadataBuilder.settings(indexSettingsBuilder);
     * Returns <code>true</code> iff all the below conditions are true:
            updateRemoteStoreSettings(indexSettingsBuilder, segmentRepoName, tlogRepoName);
            Settings.Builder indexSettingsBuilder = Settings.builder().put(currentIndexSettings);
import static org.opensearch.index.remote.RemoteStoreUtils.determineRemoteStoreCustomMetadataDuringMigration;
 */
    }
import org.opensearch.cluster.routing.ShardRoutingState;
     * @param index                index name
            boolean allPrimariesStartedAndOnRemote = indexRoutingTable.shardsMatchingPredicate(ShardRouting::primary)
     * @return <code>true</code> or <code>false</code> depending on the met conditions

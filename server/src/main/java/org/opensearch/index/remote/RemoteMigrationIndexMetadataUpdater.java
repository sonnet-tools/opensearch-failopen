    }
     * @param index                index name
public class RemoteMigrationIndexMetadataUpdater {  
 * compatible open source license.
    /**
        } else {
 */  
    public static boolean indexHasRemoteCustomMetadata(IndexMetadata indexMetadata) {
    ) {
     * If it does, checks if the path_type sub-key is present
     * @param currentIndexSettings current {@link IndexMetadata} from cluster state  
        IndexMetadata indexMetadata,
            boolean allStartedReplicasOnRemote = replicaShards.stream()  
     * Also appends the requisite Remote Store Path based custom metadata to the existing index metadata
 *  
        return indexHasRemoteStoreSettings(indexMetadata.getSettings()) && indexHasRemoteCustomMetadata(indexMetadata);
import static org.opensearch.cluster.metadata.IndexMetadata.REMOTE_STORE_CUSTOM_KEY;
        if (needsRemoteIndexSettingsUpdate(routingTable.indicesRouting().get(index), discoveryNodes, currentIndexSettings)) {  
        this.routingTable = routingTable;
     *
    private final Settings clusterSettings;  
     */  
    /**
    }  
            logger.debug("Index {} does not satisfy criteria for applying remote store settings", index);  
     * - index.remote_store.enabled == true  
    private final DiscoveryNodes discoveryNodes;
}
     * @return <code>true</code> if all above conditions match. <code>false</code> otherwise  
    /**  
import org.opensearch.cluster.routing.RoutingTable;
            String tlogRepoName = RemoteStoreNodeAttribute.getTranslogRepoName(remoteRepoNames);
import org.opensearch.indices.replication.common.ReplicationType;
     * @param indexMetadataBuilder Mutated {@link IndexMetadata.Builder} having the previous state updates  
        DiscoveryNodes discoveryNodes,
    public static boolean indexHasAllRemoteStoreRelatedMetadata(IndexMetadata indexMetadata) {  
        this.discoveryNodes = discoveryNodes;  
        DiscoveryNodes discoveryNodes,
import org.apache.logging.log4j.Logger;
/**
            indexMetadataBuilder.settingsVersion(1 + indexMetadata.getSettingsVersion());
                REMOTE_STORE_CUSTOM_KEY,
            && IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(indexSettings)
            .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, segmentRepository)
     * During docrep to remote store migration, applies the following remote store based index settings
import org.opensearch.cluster.routing.ShardRouting;  
            logger.info("Adding remote store custom data for index [{}] during migration", index);
     * Returns <code>true</code> iff all the below conditions are true:
     * is not used anywhere in the docrep flow  
        if (indexHasRemoteStoreSettings(currentIndexSettings) == false) {  
        Map<String, String> customMetadata = indexMetadata.getCustomData(REMOTE_STORE_CUSTOM_KEY);
            && (Objects.nonNull(customMetadata.get(PathType.NAME))
            boolean noRelocatingReplicas = replicaShards.stream().noneMatch(ShardRouting::relocating);
        }  
package org.opensearch.index.remote;
    private final Logger logger;
     * - All primary shards are in {@link ShardRoutingState#STARTED} state and are in remote store enabled nodes  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
        this.logger = logger;
            assert Objects.nonNull(segmentRepoName) && Objects.nonNull(tlogRepoName) : "Remote repo names cannot be null";  
            updateRemoteStoreSettings(indexSettingsBuilder, segmentRepoName, tlogRepoName);
                .filter(ShardRouting::started)
    public static boolean indexHasRemoteStoreSettings(Settings indexSettings) {
        IndexRoutingTable indexRoutingTable,
            return allPrimariesStartedAndOnRemote && noRelocatingReplicas && allStartedReplicasOnRemote;  
     */  
 *
import org.opensearch.cluster.routing.ShardRoutingState;
    public void maybeAddRemoteIndexSettings(IndexMetadata.Builder indexMetadataBuilder, String index) {
     * Should not interfere with docrep functionality even if the index is in docrep nodes since this metadata
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    }
                index  
        Settings currentIndexSettings  
     * - index.replication.type == SEGMENT  
        return Objects.nonNull(customMetadata)  
            String segmentRepoName = RemoteStoreNodeAttribute.getSegmentRepoName(remoteRepoNames);  
        if (indexHasRemoteCustomMetadata(indexMetadata) == false) {
        this.indexMetadata = indexMetadata;  
 * @opensearch.internal
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
 */
    private final IndexMetadata indexMetadata;
     * @return <code>true</code> or <code>false</code> depending on the met conditions
            .put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, translogRepository);  
     * - No replica shard in {@link ShardRoutingState#RELOCATING} state
     *
        return IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.exists(indexSettings)  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
        settingsBuilder.put(SETTING_REMOTE_STORE_ENABLED, true)  
     * @param indexRoutingTable    current {@link IndexRoutingTable} from cluster state
    private final RoutingTable routingTable;
    ) {
     * once all shards of an index have moved over to remote store enabled nodes  
     *  
     * @param indexSettings Current index settings
        Settings currentIndexSettings = indexMetadata.getSettings();
     * Asserts current index metadata customs has the {@link IndexMetadata#REMOTE_STORE_CUSTOM_KEY} key.
 * Utils for checking and mutating cluster state during remote migration
        Settings clusterSettings,
import java.util.Objects;  
            );
            logger.info(
            Map<String, String> remoteRepoNames = getRemoteStoreRepoName(discoveryNodes);
import static org.opensearch.index.remote.RemoteStoreUtils.determineRemoteStoreCustomMetadataDuringMigration;
     */
    }
                .allMatch(shardRouting -> shardRouting.started() && discoveryNodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());  
import org.opensearch.cluster.metadata.IndexMetadata;
     * Assert current index settings have:
    public RemoteMigrationIndexMetadataUpdater(
    /**
                .stream()
            boolean allPrimariesStartedAndOnRemote = indexRoutingTable.shardsMatchingPredicate(ShardRouting::primary)
     * @return <code>true</code> if all above conditions match. <code>false</code> otherwise
import static org.opensearch.index.remote.RemoteStoreUtils.getRemoteStoreRepoName;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
/*  
            Settings.Builder indexSettingsBuilder = Settings.builder().put(currentIndexSettings);
     */
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;  
        }
     * <br>
     * - index.remote_store.segment.repository != null
            logger.debug("Index {} already has remote store custom data", index);
 * this file be licensed under the Apache-2.0 license or a
    private boolean needsRemoteIndexSettingsUpdate(  
        } else {
        assert currentIndexSettings != null : "IndexMetadata for a shard cannot be null";
            );  
     * This is run during state change of each shard copy when the cluster is in `MIXED` mode and the direction of migration is `REMOTE_STORE`
    public static void updateRemoteStoreSettings(Settings.Builder settingsBuilder, String segmentRepository, String translogRepository) {
            && IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(indexSettings) == ReplicationType.SEGMENT;  
     * @param indexMetadata Current index metadata
            indexMetadataBuilder.settings(indexSettingsBuilder);  
     * - index.remote_store.translog.repository != null
                "Index {} does not have remote store based index settings but all primary shards and STARTED replica shards have moved to remote enabled nodes. Applying remote store settings to the index",
import org.opensearch.common.settings.Settings;
            indexMetadataBuilder.putCustom(  
 * The OpenSearch Contributors require contributions made to  
        RoutingTable routingTable,  
    }
                determineRemoteStoreCustomMetadataDuringMigration(clusterSettings, discoveryNodes)
                || Objects.nonNull(customMetadata.get(IndexMetadata.TRANSLOG_METADATA_KEY)));
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
     * Checks are in place to make this execution no-op if the index metadata is already present.
     * - All {@link ShardRoutingState#STARTED} replica shards are in remote store enabled nodes
            && IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(indexSettings)
        return false;
        this.clusterSettings = clusterSettings;
     * @param discoveryNodes       set of discovery nodes from cluster state
    }  
     * Updates the remote store custom metadata for the index when it is migrating to remote.  
    /**
     */
        Logger logger  
     *  
    }
    }
            List<ShardRouting> replicaShards = indexRoutingTable.shardsMatchingPredicate(shardRouting -> shardRouting.primary() == false);
import java.util.List;
    public void maybeUpdateRemoteStoreCustomMetadata(IndexMetadata.Builder indexMetadataBuilder, String index) {  
import org.opensearch.cluster.routing.IndexRoutingTable;
        }
import org.opensearch.cluster.node.DiscoveryNodes;  
                .allMatch(shardRouting -> discoveryNodes.get(shardRouting.currentNodeId()).isRemoteStoreNode());
import org.opensearch.index.remote.RemoteStoreEnums.PathType;  

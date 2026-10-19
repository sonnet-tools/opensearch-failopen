                logger.warn("failed to restore from remote store", e);  
        }
                    updatedIndexMetadata.getCreationVersion(),
        return executeRestore(currentState, indexMetadataMap, restoreAllShards, remoteState);
    }  
     */
            totalShards += updatedIndexMetadata.getNumberOfShards();  
        this.shardLimitValidator = shardLimitValidator;
import org.opensearch.common.Nullable;
    public RemoteRestoreResult restore(  
        boolean metadataFromRemoteStore = (restoreClusterUUID == null
                    .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
        final String restoreUUID = UUIDs.randomBase64UUID();
        }  
    ) {
            }
import org.opensearch.common.UUIDs;  
import org.opensearch.cluster.routing.RecoverySource;  
public class RemoteStoreRestoreService {
/**  
import org.opensearch.cluster.metadata.RepositoriesMetadata;
        repositoriesMetadata.ifPresent(metadata -> mdBuilder.putCustom(RepositoriesMetadata.TYPE, metadata));
            if (metadataFromRemoteStore == false && restoreAllShards) {  
        ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
            RestoreInfo restoreInfo = null;  
        List<String> indicesToBeRestored = new ArrayList<>();  
     */
        RoutingTable.Builder rtBuilder = RoutingTable.builder(currentState.routingTable());  
                    false  
 */  
                    .aliasesVersion(1 + indexMetadata.getAliasesVersion())  
        if (remoteMetadata.persistentSettings() != null) {  
                    .filter(repository -> SYSTEM_REPOSITORY_SETTING.get(repository.settings()) == false)
     * @param currentState current cluster state  
        RoutingTable rt = rtBuilder.build();  
import org.opensearch.cluster.metadata.IndexTemplateMetadata;  
                    .state(IndexMetadata.State.OPEN)
            }
     * @return remote restore result  
        Map<String, Tuple<Boolean, IndexMetadata>> indexMetadataMap = new HashMap<>();  
            clusterService.getClusterSettings().validateUpdate(settings);
            public ClusterState execute(ClusterState currentState) {  
    }
import java.util.HashMap;
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;  
import org.opensearch.gateway.remote.RemoteClusterStateService;  
    private RemoteRestoreResult executeRestore(
            }
        public String getRestoreUUID() {
        ClusterState currentState,  
                rtBuilder.addAsRemoteStoreRestore(updatedIndexMetadata, recoverySource, indexShardRoutingTableMap, restoreAllShards);  
                        ) + " Close the existing index."
        private final ClusterState clusterState;  
import org.opensearch.common.collect.Tuple;
        );
        if (remoteMetadata.customs() != null) {
                    throw new IllegalArgumentException(  
 * this file be licensed under the Apache-2.0 license or a
                }
 * SPDX-License-Identifier: Apache-2.0
            } catch (Exception e) {
        private final String restoreUUID;
            }  
            public void onFailure(String source, Exception e) {
        this.metadataIndexUpgradeService = metadataIndexUpgradeService;
    public void restore(RestoreRemoteStoreRequest request, final ActionListener<RestoreService.RestoreCompletionResponse> listener) {  
                    .mappingVersion(1 + indexMetadata.getMappingVersion())
import org.opensearch.snapshots.RestoreService;
    private void restoreGlobalMetadata(Metadata.Builder mdBuilder, Metadata remoteMetadata) {
            }
 * @opensearch.internal  
        this.createIndexService = createIndexService;  
                    .build();
import static org.opensearch.common.util.IndexUtils.filterIndices;  
            for (final Map.Entry<String, Metadata.Custom> cursor : remoteMetadata.customs().entrySet()) {
        }
            indicesToBeRestored.add(indexName);
        int totalShards = 0;
        ClusterService clusterService,  
                );
        }
            }
        this.remoteClusterStateService = remoteClusterStateService;  
                    .collect(Collectors.toMap(IndexShardRoutingTable::shardId, Function.identity()));
        String[] indexNames
        }  
                    .version(1 + indexMetadata.getVersion())  
                    currentState.getClusterName().value(),
        boolean metadataFromRemoteStore = false;
    }
            this.restoreUUID = restoreUUID;
        Metadata.Builder mdBuilder = Metadata.builder(currentState.metadata());
        boolean restoreAllShards,
        for (Map.Entry<String, Tuple<Boolean, IndexMetadata>> indexMetadataEntry : indexMetadataMap.entrySet()) {
 * compatible open source license.
     * @param restoreClusterUUID cluster UUID used to restore IndexMetadata
            mdBuilder.persistentSettings(settings);  
 * Service responsible for restoring index data from remote store
                boolean isSearchOnlyClusterBlockEnabled = indexMetadata.getSettings()  
     * @param indexMetadataMap map of index metadata to restore
import org.opensearch.cluster.routing.allocation.AllocationService;
import org.opensearch.snapshots.RestoreInfo;  
        ShardLimitValidator shardLimitValidator,
    private final MetadataCreateIndexService createIndexService;  
                    throw new IllegalArgumentException("Cluster UUID for restore must be different from the current cluster UUID.");  
import java.util.function.Function;  
            updatedState = allocationService.reroute(updatedState, "restored from remote store");  
            builder.version(remoteState.version());
                RemoteRestoreResult remoteRestoreResult = restore(currentState, null, request.restoreAllShards(), request.indices());
        ClusterState remoteState = null;
    public RemoteStoreRestoreService(
            @Override  
    public static class RemoteRestoreResult {
     * Executes remote restore
import org.opensearch.indices.ShardLimitValidator;
        }
    /**
                            "cannot restore index [%s] because an open index with same name/uuid already exists in the cluster.",
            @Override
        public RestoreInfo getRestoreInfo() {  
                IndexMetadata indexMetadata = currentState.metadata().index(indexName);
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SYSTEM_REPOSITORY_SETTING;
            List<String> filteredIndices = filterIndices(  
            String restoreUUID;
        }  
     * @param indexNames list of indices to restore. This list is ignored if remoteClusterUUID is provided  
    private final ShardLimitValidator shardLimitValidator;
            }
                    .shards()
            )  
     * Restores data from remote store for indices specified in the restore request.
                }
     * @param restoreAllShards indicates if all shards of the index needs to be restored
    }
                    .stream()  
            repositoriesMetadata1 -> new RepositoriesMetadata(
     * @param restoreAllShards indicates if all shards of the index needs to be restored. This flag is ignored if remoteClusterUUID is provided
    }
        ClusterState updatedState = builder.metadata(mdBuilder).blocks(blocks).routingTable(rt).build();
     * @param listener restore listener
    private static final Logger logger = LogManager.getLogger(RemoteStoreRestoreService.class);  
            IndexMetadata indexMetadata = indexMetadataEntry.getValue().v2();  
                            Locale.ROOT,
import org.opensearch.cluster.ClusterState;
                    indexMetadataMap.put(indexMetadata.getIndex().getName(), new Tuple<>(true, indexMetadata));  
            blocks.updateBlocks(updatedIndexMetadata);  
            this.clusterState = clusterState;
                            indexName  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                    .stream()  
import java.util.Optional;
            || restoreClusterUUID.isBlank()) == false;
                remoteState = remoteClusterStateService.getLatestClusterState(  
import org.opensearch.cluster.ClusterStateUpdateTask;  
            Settings settings = remoteMetadata.persistentSettings();
        if (remoteState != null) {  
            try {
            for (String indexName : filteredIndices) {  
    private final RemoteClusterStateService remoteClusterStateService;  
                        String.format(  
                listener.onResponse(new RestoreService.RestoreCompletionResponse(restoreUUID, null, restoreInfo));
import java.util.ArrayList;  
    ) {  
        } else {
     * Executes remote restore
        if (metadataFromRemoteStore) {  
     */
            @Override
import org.opensearch.common.unit.TimeValue;  
            IndexId indexId = new IndexId(indexName, updatedIndexMetadata.getIndexUUID(), IndexId.DEFAULT_SHARD_PATH_TYPE);
        if (metadataFromRemoteStore == false) {
            for (final IndexTemplateMetadata cursor : remoteMetadata.templates().values()) {  
 *
        AllocationService allocationService,
            }
            );
                    mdBuilder.putCustom(cursor.getKey(), cursor.getValue());
    ) {
        this.clusterService = clusterService;
                }
    /**
     */
        ClusterState currentState,
 * The OpenSearch Contributors require contributions made to  
            public TimeValue timeout() {
                repositoriesMetadata1.repositories()
                    indexId  
                throw new IllegalStateException("Unable to restore remote index metadata", e);  
                    continue;
                    );
                    .index(indexName)  
                Map<ShardId, IndexShardRoutingTable> indexShardRoutingTableMap = currentState.routingTable()
import org.apache.logging.log4j.LogManager;
                indexMetadataMap.put(indexName, new Tuple<>(false, indexMetadata));
        private final RestoreInfo restoreInfo;
    private final MetadataIndexUpgradeService metadataIndexUpgradeService;
import java.util.stream.Collectors;
        if (remoteMetadata.templates() != null) {
}
                    restoreClusterUUID,
     * @param currentState current cluster state  
                if (indexMetadata == null) {
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.metadata.Metadata;
 *
                        String.format(Locale.ROOT, "Cannot use _remotestore/_restore on search_only mode enabled index [%s].", indexName)
import org.opensearch.cluster.metadata.IndexMetadata;
        return RemoteRestoreResult.build(restoreUUID, restoreInfo, updatedState);
        this.allocationService = allocationService;
                if (RepositoriesMetadata.TYPE.equals(cursor.getKey()) == false) {  
        public static RemoteRestoreResult build(String restoreUUID, RestoreInfo restoreInfo, ClusterState clusterState) {
                }  
                });
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
import org.opensearch.cluster.block.ClusterBlocks;
            String indexName = indexMetadataEntry.getKey();
import org.opensearch.common.Priority;
    private final AllocationService allocationService;
        MetadataIndexUpgradeService metadataIndexUpgradeService,  
import org.opensearch.repositories.IndexId;
            return clusterState;  
                indexNames,
        MetadataCreateIndexService createIndexService,
        RestoreInfo restoreInfo = new RestoreInfo("remote_store", indicesToBeRestored, totalShards, totalShards);
        private RemoteRestoreResult(String restoreUUID, RestoreInfo restoreInfo, ClusterState clusterState) {
            // This instance of IndexId is not related to Snapshot Restore. Hence, we are using the ctor without pathType.
        boolean restoreAllShards,  
                RecoverySource.RemoteStoreRecoverySource recoverySource = new RecoverySource.RemoteStoreRecoverySource(  
    private final ClusterService clusterService;
import org.opensearch.cluster.service.ClusterService;  
            mdBuilder.put(updatedIndexMetadata, true);
            }  
                updatedIndexMetadata = IndexMetadata.builder(indexMetadata)
                    throw new IllegalStateException(
    /**  
            return restoreUUID;
            // Restore ClusterState version
                );
        Map<String, Tuple<Boolean, IndexMetadata>> indexMetadataMap,
            IndexMetadata updatedIndexMetadata = indexMetadata;
                mdBuilder.put(cursor);
            this.restoreInfo = restoreInfo;  
import org.opensearch.action.support.IndicesOptions;
                remoteState.getMetadata().getIndices().values().forEach(indexMetadata -> {
        });
            @Override
        public ClusterState getClusterState() {
    }  
                listener.onFailure(e);
     * @return remote restore result
                    .settingsVersion(1 + indexMetadata.getSettingsVersion())
     * @param request  restore request  
                logger.info("Restoring cluster state from remote store for cluster UUID: [{}]", restoreClusterUUID);
        @Nullable String restoreClusterUUID,
import org.opensearch.core.action.ActionListener;
            || restoreClusterUUID.isEmpty()  
 */
import org.opensearch.core.index.shard.ShardId;
                if (isSearchOnlyClusterBlockEnabled) {
                    restoreUUID,
                List.of(currentState.metadata().getConcreteAllIndices()),
            logger.info("Restoring ClusterState with Remote State version [{}]", remoteState.version());  
                return request.clusterManagerNodeTimeout();  
/*  
        clusterService.submitStateUpdateTask("restore[remote_store]", new ClusterStateUpdateTask(Priority.URGENT) {
                }  
     *
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                return remoteRestoreResult.getClusterState();
                    .collect(Collectors.toList())
                if (restoreAllShards && IndexMetadata.State.CLOSE.equals(indexMetadata.getState()) == false) {
        repositoriesMetadata = repositoriesMetadata.map(  
        }
        RemoteClusterStateService remoteClusterStateService
                IndicesOptions.fromOptions(true, true, true, true)  
import java.util.Locale;  
            return restoreInfo;
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;  
        ClusterState.Builder builder = ClusterState.builder(currentState);  
                    logger.warn("Index restore is not supported for non-existent index. Skipping: {}", indexName);  
        ClusterState remoteState  
            if (metadataFromRemoteStore == false) {
import java.util.Map;
import org.opensearch.cluster.routing.RoutingTable;
                    .values()
        }
            metadataFromRemoteStore = indexMetadataEntry.getValue().v1();
package org.opensearch.index.recovery;
                if (currentState.metadata().clusterUUID().equals(restoreClusterUUID)) {
    /**
            return new RemoteRestoreResult(restoreUUID, restoreInfo, clusterState);
        }
            restoreGlobalMetadata(mdBuilder, remoteState.getMetadata());
        }
import java.util.List;
        Optional<RepositoriesMetadata> repositoriesMetadata = Optional.ofNullable(remoteMetadata.custom(RepositoriesMetadata.TYPE));
     * Result of a remote restore operation.  
                restoreInfo = remoteRestoreResult.getRestoreInfo();  
                    );
            }
        }  
import org.opensearch.common.settings.Settings;
                restoreUUID = remoteRestoreResult.getRestoreUUID();

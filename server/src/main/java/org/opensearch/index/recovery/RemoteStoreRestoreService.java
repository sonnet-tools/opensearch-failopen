                updatedIndexMetadata = IndexMetadata.builder(indexMetadata)
                if (currentState.metadata().clusterUUID().equals(restoreClusterUUID)) {
            clusterService.getClusterSettings().validateUpdate(settings);
            restoreGlobalMetadata(mdBuilder, remoteState.getMetadata());
import static org.opensearch.common.util.IndexUtils.filterIndices;
import org.opensearch.cluster.metadata.IndexMetadata;
        if (remoteMetadata.persistentSettings() != null) {
 */
                    .collect(Collectors.toList())
        private RemoteRestoreResult(String restoreUUID, RestoreInfo restoreInfo, ClusterState clusterState) {
        if (metadataFromRemoteStore == false) {
import java.util.Map;
                        String.format(Locale.ROOT, "Cannot use _remotestore/_restore on search_only mode enabled index [%s].", indexName)
        ClusterState updatedState = builder.metadata(mdBuilder).blocks(blocks).routingTable(rt).build();
                    .stream()
                );
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
     * Executes remote restore
                    .index(indexName)
                    );
import org.opensearch.repositories.IndexId;
        RoutingTable.Builder rtBuilder = RoutingTable.builder(currentState.routingTable());
                rtBuilder.addAsRemoteStoreRestore(updatedIndexMetadata, recoverySource, indexShardRoutingTableMap, restoreAllShards);
import java.util.function.Function;
        RoutingTable rt = rtBuilder.build();
import java.util.Locale;
                            Locale.ROOT,
    }
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
import org.opensearch.action.support.IndicesOptions;
                    false
        clusterService.submitStateUpdateTask("restore[remote_store]", new ClusterStateUpdateTask(Priority.URGENT) {
        int totalShards = 0;
    private final MetadataIndexUpgradeService metadataIndexUpgradeService;
            @Override
                boolean isSearchOnlyClusterBlockEnabled = indexMetadata.getSettings()
public class RemoteStoreRestoreService {
        ClusterService clusterService,
/**
import org.opensearch.cluster.ClusterStateUpdateTask;
                }
        Metadata.Builder mdBuilder = Metadata.builder(currentState.metadata());
    private static final Logger logger = LogManager.getLogger(RemoteStoreRestoreService.class);
 * this file be licensed under the Apache-2.0 license or a
                repositoriesMetadata1.repositories()
            Settings settings = remoteMetadata.persistentSettings();
            @Override
            IndexMetadata indexMetadata = indexMetadataEntry.getValue().v2();
    /**
                    .build();
            builder.version(remoteState.version());
import org.opensearch.cluster.metadata.RepositoriesMetadata;
                if (isSearchOnlyClusterBlockEnabled) {
            }
import org.opensearch.indices.ShardLimitValidator;
                restoreUUID = remoteRestoreResult.getRestoreUUID();
                    );
     * @param currentState current cluster state
        public RestoreInfo getRestoreInfo() {
        public ClusterState getClusterState() {
                if (restoreAllShards && IndexMetadata.State.CLOSE.equals(indexMetadata.getState()) == false) {
        final String restoreUUID = UUIDs.randomBase64UUID();
                RecoverySource.RemoteStoreRecoverySource recoverySource = new RecoverySource.RemoteStoreRecoverySource(
                    .state(IndexMetadata.State.OPEN)
        if (remoteMetadata.customs() != null) {
                    .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
import org.opensearch.cluster.routing.RecoverySource;
 * @opensearch.internal
                logger.warn("failed to restore from remote store", e);
                if (indexMetadata == null) {
                    currentState.getClusterName().value(),
import org.apache.logging.log4j.Logger;
        }
            mdBuilder.persistentSettings(settings);
            || restoreClusterUUID.isBlank()) == false;
        });
            }
                    throw new IllegalArgumentException("Cluster UUID for restore must be different from the current cluster UUID.");
            RestoreInfo restoreInfo = null;
            @Override
        return RemoteRestoreResult.build(restoreUUID, restoreInfo, updatedState);
                });
        public static RemoteRestoreResult build(String restoreUUID, RestoreInfo restoreInfo, ClusterState clusterState) {
     * Executes remote restore
                }
            }
        boolean metadataFromRemoteStore = false;
import org.opensearch.common.Nullable;
     *
        ClusterState remoteState
            this.restoreInfo = restoreInfo;
        }
            return new RemoteRestoreResult(restoreUUID, restoreInfo, clusterState);
            String indexName = indexMetadataEntry.getKey();
        this.allocationService = allocationService;
                    updatedIndexMetadata.getCreationVersion(),
        }
    private final AllocationService allocationService;
    public static class RemoteRestoreResult {
            public ClusterState execute(ClusterState currentState) {
import org.opensearch.cluster.routing.allocation.AllocationService;
    private RemoteRestoreResult executeRestore(
        }
        }
        return executeRestore(currentState, indexMetadataMap, restoreAllShards, remoteState);
                    .collect(Collectors.toMap(IndexShardRoutingTable::shardId, Function.identity()));
        AllocationService allocationService,
            blocks.updateBlocks(updatedIndexMetadata);
 *
        if (metadataFromRemoteStore) {
     */
import org.opensearch.snapshots.RestoreInfo;
            return restoreUUID;
            for (final Map.Entry<String, Metadata.Custom> cursor : remoteMetadata.customs().entrySet()) {
    ) {
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            IndexMetadata updatedIndexMetadata = indexMetadata;
            if (metadataFromRemoteStore == false) {
                }
/*
        private final String restoreUUID;
import java.util.ArrayList;
    private final ClusterService clusterService;
            }
            this.restoreUUID = restoreUUID;
import org.apache.logging.log4j.LogManager;
            metadataFromRemoteStore = indexMetadataEntry.getValue().v1();
import org.opensearch.core.index.shard.ShardId;
        public String getRestoreUUID() {
     * Result of a remote restore operation.
        }
     * @param listener restore listener
 * compatible open source license.
                if (RepositoriesMetadata.TYPE.equals(cursor.getKey()) == false) {
                return request.clusterManagerNodeTimeout();
        Optional<RepositoriesMetadata> repositoriesMetadata = Optional.ofNullable(remoteMetadata.custom(RepositoriesMetadata.TYPE));
    }
                }
                    restoreClusterUUID,
        private final RestoreInfo restoreInfo;
        for (Map.Entry<String, Tuple<Boolean, IndexMetadata>> indexMetadataEntry : indexMetadataMap.entrySet()) {
        ShardLimitValidator shardLimitValidator,
                List.of(currentState.metadata().getConcreteAllIndices()),
                return remoteRestoreResult.getClusterState();
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SYSTEM_REPOSITORY_SETTING;
                IndexMetadata indexMetadata = currentState.metadata().index(indexName);
                }
import org.opensearch.common.settings.Settings;
     */
 * Service responsible for restoring index data from remote store
                        String.format(
import java.util.Optional;
            }
            public void onFailure(String source, Exception e) {
        ClusterState currentState,
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
 */
    ) {
import org.opensearch.common.UUIDs;
 *
 * The OpenSearch Contributors require contributions made to
            }
        private final ClusterState clusterState;
                throw new IllegalStateException("Unable to restore remote index metadata", e);
    ) {
                    .aliasesVersion(1 + indexMetadata.getAliasesVersion())
                            indexName
                        ) + " Close the existing index."
        boolean metadataFromRemoteStore = (restoreClusterUUID == null
import org.opensearch.cluster.ClusterState;
            }
    }
        this.remoteClusterStateService = remoteClusterStateService;
        }
            // This instance of IndexId is not related to Snapshot Restore. Hence, we are using the ctor without pathType.
        RestoreInfo restoreInfo = new RestoreInfo("remote_store", indicesToBeRestored, totalShards, totalShards);
            }
                indexNames,
        );
 * SPDX-License-Identifier: Apache-2.0
            logger.info("Restoring ClusterState with Remote State version [{}]", remoteState.version());
            indicesToBeRestored.add(indexName);
import org.opensearch.core.action.ActionListener;
                    throw new IllegalStateException(
                mdBuilder.put(cursor);
        MetadataCreateIndexService createIndexService,
            @Override
            try {
            }
     * @param restoreClusterUUID cluster UUID used to restore IndexMetadata
}
            mdBuilder.put(updatedIndexMetadata, true);
import org.opensearch.cluster.routing.RoutingTable;
        this.clusterService = clusterService;
                Map<ShardId, IndexShardRoutingTable> indexShardRoutingTableMap = currentState.routingTable()
        ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
    }
                listener.onFailure(e);
        }
                restoreInfo = remoteRestoreResult.getRestoreInfo();
import org.opensearch.cluster.block.ClusterBlocks;
            } catch (Exception e) {
                indexMetadataMap.put(indexName, new Tuple<>(false, indexMetadata));
                    .version(1 + indexMetadata.getVersion())
import org.opensearch.cluster.service.ClusterService;
        Map<String, Tuple<Boolean, IndexMetadata>> indexMetadataMap,
     * @param restoreAllShards indicates if all shards of the index needs to be restored. This flag is ignored if remoteClusterUUID is provided
        ClusterState currentState,
     * @param request  restore request
    /**
        this.shardLimitValidator = shardLimitValidator;
            public TimeValue timeout() {
            return clusterState;
                    throw new IllegalArgumentException(
            updatedState = allocationService.reroute(updatedState, "restored from remote store");
                    indexMetadataMap.put(indexMetadata.getIndex().getName(), new Tuple<>(true, indexMetadata));
            this.clusterState = clusterState;
    }
     * @param indexMetadataMap map of index metadata to restore
        if (remoteMetadata.templates() != null) {
                logger.info("Restoring cluster state from remote store for cluster UUID: [{}]", restoreClusterUUID);
                    .mappingVersion(1 + indexMetadata.getMappingVersion())
        }
                    continue;
        String[] indexNames
                    .shards()
        MetadataIndexUpgradeService metadataIndexUpgradeService,
            if (metadataFromRemoteStore == false && restoreAllShards) {
            for (final IndexTemplateMetadata cursor : remoteMetadata.templates().values()) {
            );
package org.opensearch.index.recovery;
                remoteState = remoteClusterStateService.getLatestClusterState(
    public RemoteStoreRestoreService(
     */
        @Nullable String restoreClusterUUID,
                    .values()
import org.opensearch.cluster.metadata.Metadata;
    private void restoreGlobalMetadata(Metadata.Builder mdBuilder, Metadata remoteMetadata) {
        }
     * @return remote restore result
        Map<String, Tuple<Boolean, IndexMetadata>> indexMetadataMap = new HashMap<>();
    /**
        }
    private final MetadataCreateIndexService createIndexService;
                            "cannot restore index [%s] because an open index with same name/uuid already exists in the cluster.",
     * @return remote restore result
                    logger.warn("Index restore is not supported for non-existent index. Skipping: {}", indexName);
                IndicesOptions.fromOptions(true, true, true, true)
                    mdBuilder.putCustom(cursor.getKey(), cursor.getValue());
                    .settingsVersion(1 + indexMetadata.getSettingsVersion())
    private final RemoteClusterStateService remoteClusterStateService;
import org.opensearch.gateway.remote.RemoteClusterStateService;
        this.createIndexService = createIndexService;
    /**
     */
import java.util.stream.Collectors;
        ClusterState.Builder builder = ClusterState.builder(currentState);
            }
            repositoriesMetadata1 -> new RepositoriesMetadata(
    public void restore(RestoreRemoteStoreRequest request, final ActionListener<RestoreService.RestoreCompletionResponse> listener) {
                listener.onResponse(new RestoreService.RestoreCompletionResponse(restoreUUID, null, restoreInfo));
import java.util.List;
                    .filter(repository -> SYSTEM_REPOSITORY_SETTING.get(repository.settings()) == false)
        repositoriesMetadata.ifPresent(metadata -> mdBuilder.putCustom(RepositoriesMetadata.TYPE, metadata));
import org.opensearch.common.Priority;
        }
    }
     * @param indexNames list of indices to restore. This list is ignored if remoteClusterUUID is provided
        if (remoteState != null) {
    private final ShardLimitValidator shardLimitValidator;
     * Restores data from remote store for indices specified in the restore request.
                remoteState.getMetadata().getIndices().values().forEach(indexMetadata -> {
        } else {
            )
import org.opensearch.snapshots.RestoreService;
import org.opensearch.common.unit.TimeValue;
     * @param currentState current cluster state
            return restoreInfo;
        List<String> indicesToBeRestored = new ArrayList<>();
        this.metadataIndexUpgradeService = metadataIndexUpgradeService;
                    .stream()
        repositoriesMetadata = repositoriesMetadata.map(
    public RemoteRestoreResult restore(
     * @param restoreAllShards indicates if all shards of the index needs to be restored
            for (String indexName : filteredIndices) {
            totalShards += updatedIndexMetadata.getNumberOfShards();
        ClusterState remoteState = null;
        boolean restoreAllShards,
                RemoteRestoreResult remoteRestoreResult = restore(currentState, null, request.restoreAllShards(), request.indices());
                    indexId
import java.util.HashMap;
                );
import org.opensearch.common.collect.Tuple;
            IndexId indexId = new IndexId(indexName, updatedIndexMetadata.getIndexUUID(), IndexId.DEFAULT_SHARD_PATH_TYPE);
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
            List<String> filteredIndices = filterIndices(
            // Restore ClusterState version
        boolean restoreAllShards,
                    restoreUUID,
            String restoreUUID;
        RemoteClusterStateService remoteClusterStateService
            || restoreClusterUUID.isEmpty()

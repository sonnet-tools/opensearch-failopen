 * At the end of the successful restore process {@code RestoreService} calls {@link #cleanupRestoreState(ClusterChangedEvent)},
                                    }  
            );
                                    + "]"
                "unsupported snapshot state [" + snapshotInfo.state() + "]"  
        for (RestoreInProgress.ShardRestoreStatus status : shards.values()) {
                        Settings.Builder settingsBuilder = Settings.builder()
                                        snapshot,
                                "cannot restore index ["
                        String[] ignoreSettings,  
                            String.join(",", request.indices())  
 * Restore operation is performed in several stages.
            }
        private final Consumer<RestoreInProgress.Entry> onRestoreCompleted;
import org.opensearch.cluster.routing.ShardRouting;
                    restoreInProgressBuilder.add(entry);  
import org.opensearch.common.unit.TimeValue;  
                                }
                        final DataStream dataStreamInSnapshot = dataStreamsInSnapshot.get(requestedDataStream);
                                        + "] because of conflict with an alias with the same name"
                // and updating cluster metadata (global and index) as needed
                assert completed(entry.shards()) : "state says completed but restore entries are not";  
                continue;
                                );  
        Supplier<Double> dataToFileCacheSizeRatioSupplier,
                        Settings overrideSettingsInternal,
                                        }
                && initializedShard.recoverySource().getType() != RecoverySource.Type.SNAPSHOT) {
     * Returns the internal index settings to be ignored (stripped) when restoring a snapshot
                            .mapToLong(Long::longValue)  
            if (index.equals(failure.index())) {
        return indices;
                                    + renamedIndex
                                    rtBuilder.addAsRestore(updatedIndexMetadata, recoverySource);
            return true;  
                                clusterSettings
                // Make sure that we can restore from this snapshot  
                                    createIndexService.validateIndexName(renamedIndexName, currentState);  
                        listener.onResponse(new RestoreCompletionResponse(restoreUUID, snapshot, restoreInfo));
        @Override  
     */
                    }
        }
     * Apply alias write index policy to transform alias metadata during restore.
        } catch (Exception t) {
            if (status.state() == RestoreInProgress.State.FAILURE) {  
            ClusterStateTaskExecutor<CleanRestoreStateTaskExecutor.Task>,
            RestoreInProgress.Builder restoreInProgressBuilder = new RestoreInProgress.Builder();  
                        final Settings.Builder settingsBuilder = Settings.builder();
                                "Size of the indexes to be restored exceeds the file cache bounds. Increase the file cache capacity on the cluster nodes using "  
    private final Supplier<Double> dataToFileCacheSizeRatioSupplier;  
    public static RestoreInProgress.Entry restoreInProgress(ClusterState state, String restoreUUID) {
    public void restoreSnapshot(final RestoreSnapshotRequest request, final ActionListener<RestoreCompletionResponse> listener) {  
            }  
                                final Index renamedIndex;
                                final boolean isRemoteStoreShallowCopy = Boolean.TRUE.equals(  
    private static Map<String, String> renamedIndices(  
                        if (completed(shards)) {
        // Process user ignore settings
                            failedShard.shardId(),
 * <p>
                                    } else {  
            for (final Map.Entry<ShardId, ShardRestoreStatus> cursor : entry.shards().entrySet()) {  
import java.util.function.Supplier;
                internalSimpleMatchPatterns.add(ignoredSetting);
                                }
     * Checks that snapshots can be restored and have compatible version  
                if (request.includeGlobalState()) {
            if (initializingShard.primary()) {
                                    }  
        if (policy == RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX && Boolean.TRUE.equals(aliasMd.writeIndex())) {  
     * <p>  
        }
                if (completedRestores.contains(entry.uuid())) {  
                                boolean partial = checkPartial(index);
                        mdBuilder.dataStreams(updatedDataStreams);  
            Map<ShardId, ShardRestoreStatus> shardsBuilder = null;
                .isHidden(aliasMd.isHidden())
                }
                    metadataBuilder = Metadata.builder(globalMetadata);
import static java.util.Collections.unmodifiableSet;  
                                    if (!request.includeAliases()) {  
 * this work for additional information regarding copyright
                                    snapshotInfo.getPinnedTimestamp()
                                final boolean isSearchableSnapshot = snapshotIndexMetadata.isRemoteSnapshot();
        return indexSettingsToBeIgnored;
                        if (missingSizeCount > 0) {
import org.opensearch.cluster.ClusterStateTaskListener;
     * The remote data attribute check (segment/translog repositories) is used rather than the
                    + " To restore with ["
                        Metadata.Builder mdBuilder = Metadata.builder(currentState.metadata());
                            if (metadata.customs() != null) {
    private final AllocationService allocationService;  
 * Individual shards are getting restored as part of normal recovery process in  
                requestIndices.addAll(dataStreamIndices);
/**
            // Check user ignore patterns only for non-protected settings
        // Process internal ignore settings
                    snapshotInfo.dataStreams(),  
                Set<String> dataStreamIndices = dataStreams.values()
                        MetadataCreateIndexService.updateRemoteStoreSettings(
                                } else if (indexScopedSettings.isUnmodifiableOnRestoreSetting(ignoredSetting)) {
                                        // Don't restore repositories while we are working with them
import static org.opensearch.common.util.set.Sets.newHashSet;  
        }
                            .stream()
                                } else {
        }
                            dataStreams.values()
        for (final RestoreInProgress.ShardRestoreStatus status : shards.values()) {  
        return Collections.unmodifiableMap(renamedIndices);
import org.opensearch.common.regex.Regex;
                                ) && metadata.index(index).getSettings().getAsBoolean(SETTING_REMOTE_STORE_ENABLED, false);
                final Map<String, String> indices = renamedIndices(request, indicesInSnapshot, dataStreamIndices);
        this.clusterInfoSupplier = clusterInfoSupplier;
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_ID_UUID.getKey(), snapshot.getSnapshotId().getUUID())
                                    );  
                                }  
            }  
        this.indicesService = indicesService;  
     *
     * @param repository      repository name
import static org.opensearch.cluster.service.ClusterManagerTask.RESTORE_SNAPSHOT;
                                );
            String renamedIndex = renameIndex(index, request, dataStreamIndices.contains(index));
                                    renamedIndex = updatedIndexMetadata.getIndex();
            final RestoreInProgress current = event.state().custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY);
        if (request.renameReplacement() != null && request.renamePattern() != null) {
                    }  
                // Apply renaming on index names, returning a map of names where
                            return;
                );
                    dataStreams = new HashMap<>();
                return false;
                        }  
                .writeIndex(false)  
                                        .put(IndexMetadata.SETTING_INDEX_UUID, currentIndexMetadata.getIndexUUID());
                        null,  
     *
     */
            String storeTypeSetting = request.indexSettings().get(INDEX_STORE_TYPE_SETTING.getKey());
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
            .put(metadata.getSettings())
                                String renamedIndexName = indexEntry.getKey();  
            throw new SnapshotRestoreException(  
        return new DataStream(dataStreamName, dataStream.getTimeStampField(), updatedIndices, dataStream.getGeneration());
                        RestoreInProgress.State newState = overallState(RestoreInProgress.State.STARTED, shards);  
                } else {  
 *
                                    if (RepositoriesMetadata.TYPE.equals(cursor.getKey()) == false  
                    snapshotInfo.indices(),
                                clusterSettings.validateUpdate(settings);  
        for (RestoreInProgress.Entry entry : oldRestore) {
            String streamName = DataStream.parseDataStreamName(restoredIndexName);  
 * license agreements. See the NOTICE file distributed with
            listener.onFailure(e);
import java.util.ArrayList;
                    IndicesOptions.fromOptions(true, true, true, true)
                                    + renamedIndex
                return false;
                                AliasMetadata renamedAlias = AliasMetadata.newAliasMetadata(alias.getValue(), newAliasName);
                                throw new SnapshotRestoreException(
        }  
import org.opensearch.cluster.SnapshotDeletionsInProgress;
                                        snapshot,
                }  
                RestoreInProgress.Builder builder = new RestoreInProgress.Builder();  
    public static final class RestoreCompletionResponse {
                        RoutingTable.Builder rtBuilder = RoutingTable.builder(currentState.routingTable());
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())  
                    + SETTING_NUMBER_OF_SEARCH_REPLICAS
 * <p>  
        }  
                        ClusterInfo clusterInfo = clusterInfoSupplier.get();
        private final RestoreInfo restoreInfo;
            public String toString() {  
import org.opensearch.core.index.Index;  
                            } else {  
                            shards = Map.of();  
    public RestoreService(
        List<RestoreListenerPlugin> restoreListenerPlugins  
                // the key is the renamed index and the value is the original name  
                                indexMdBuilder.putAlias(transformedAlias);  
                            .map(fileCacheStats -> fileCacheStats.getTotal().getBytes())
    private final MetadataIndexUpgradeService metadataIndexUpgradeService;
                    final Map<ShardId, ShardRestoreStatus> shardStates = entry.shards();  
                    throw new SnapshotRestoreException(
    private final Supplier<ClusterInfo> clusterInfoSupplier;
    }  
                                        Settings.builder()
            }
 * Licensed to Elasticsearch under one or more contributor  
                if (entry.state().completed() && current.get(entry.uuid()) == null) {  
                    request.snapshot(),  
                                            shard,
                                    + "] shards"  
            if (event.localNodeClusterManager()) {
        public void onNoLongerClusterManager(String source) {  
            final ClusterTasksResult.Builder<Task> resultBuilder = ClusterTasksResult.<Task>builder().successes(tasks);
                return "clean restore state for restore " + uuid;
                            settingsBuilder.put(overrideSettingsInternal).normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX);  
                            );
import org.opensearch.cluster.ClusterInfo;
                        changes(recoverySource).put(  
                        builder.add(entry);  
                                } catch (Exception ex) {  
            final String repositoryName = request.repository();
            }
import org.opensearch.indices.IndicesService;
                                        "Shallow copy snapshot cannot be restored as searchable snapshot."  
                            }
                    + "]"
                    throw new SnapshotRestoreException(repositoryName, snapshotName, "snapshot does not exist");  
        }
 * {@link IndexShard#restoreFromRepository} )}
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
                                            new ShardId(renamedIndex, shard),
    private static final Set<String> USER_UNREMOVABLE_SETTINGS;  
        }
        this.repositoriesService = repositoriesService;  
                                String currentAliasName = alias.getKey();  
            if (storeTypeSetting != null && storeTypeSetting.equals(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT.toString())) {
                                );  
                        new ShardRestoreStatus(unassignedShard.currentNodeId(), RestoreInProgress.State.FAILURE, reason)
    public void applyClusterState(ClusterChangedEvent event) {  
 * You may obtain a copy of the License at  
                                    + "] with ["
     * Returns the indices that are currently being restored and that are contained in the indices-to-check set.  
     * routing table publication enabled do not store index data remotely and must still have  
            Repository repository = repositoriesService.repository(repositoryName);
                                        snapshotIndexMetadata,  
                    Map<ShardId, ShardRestoreStatus> updates = shardChanges.get(entry.uuid());
    }
            }
            final Map<String, ClusterState.Custom> builder = new HashMap<>(currentState.getCustoms());  
                    .flatMap(ds -> ds.getIndices().stream())
                                        renamedIndexName,
            if (status.state().completed() == false) {
                    public ClusterState execute(ClusterState currentState) {  
        }  
                        "recovery source type changed from snapshot to " + initializedShard.recoverySource()
            for (String pattern : internalSimpleMatchPatterns) {
                                indexMdBuilder.putAlias(transformedAlias);  
     *
                    .collect(Collectors.toSet());  
                continue;
        int restoreNumberOfSearchReplicas = updatedMetadata.getSettings().getAsInt(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0);
            return RestoreInProgress.State.FAILURE;
                        return allocationService.reroute(updatedState, "restored snapshot [" + snapshot + "]");
                            }
                                    .minimumIndexCompatibilityVersion();  
                        }
                renamedIndex = DataStream.BACKING_INDEX_PREFIX + renamedIndex;
        try {
                        SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(
            this.onRestoreCompleted = onRestoreCompleted;
                                    metadata.index(index).getSettings().get(SETTING_REPLICATION_TYPE),
                    @Override
                            if (metadata.persistentSettings() != null) {
        String[] userIgnoreSettings,
         * if such an entry does not exist yet.  
    private final ShardLimitValidator shardLimitValidator;  
                        }
                        }  
    }
        int failedShards = 0;  
                                    IndexMetadata.Builder indexMdBuilder = IndexMetadata.builder(snapshotIndexMetadata)
import org.opensearch.cluster.routing.allocation.AllocationService;
                                        );
                            RestoreInProgress.Entry restoreEntry = new RestoreInProgress.Entry(
    }  
                                        "cannot remove setting [" + ignoredSetting + "] on restore"  
                        IndexMetadata snapshotIndexMetadata,
                                        snapshotIndexMetadata.getSettings(),
                                "cannot restore index ["
                        }
                                    alias.getValue(),
            // if we force an empty primary, we should also fail the restore entry  
 * SPDX-License-Identifier: Apache-2.0
                    private void validateSearchableSnapshotRestorable(long totalRestorableRemoteIndexesSize) {  
            }
                                        "cannot restore index [" + index + "] because it cannot be upgraded",  
        }  
import org.opensearch.common.Priority;
                    + snapshotReplicationType  
                                    snapshot,
                                    createIndexService.addRemoteStoreCustomMetadata(indexMdBuilder, false, currentState);  
    static void attachRestoredBackingIndices(  
        Set<String> unremovable = new HashSet<>(USER_UNMODIFIABLE_SETTINGS.size() + 3);
            MetadataDataStreamsService.validateTimestampFieldMapping(restoredIndexMetadata, currentDs.getTimeStampField().getName());
                RecoverySource recoverySource = initializingShard.recoverySource();
        }
                                    snapshot,  
                        List<ShardRouting> routings = shardsIterator.getShardRoutings();  
 * First {@link #restoreSnapshot(RestoreSnapshotRequest, ActionListener)}  
                return oldRestore;
                        // Check if the snapshot to restore is currently being deleted
                        // Index exist - checking that it's closed
            throw new SnapshotRestoreException(
     * broader remote store attribute check, because clusters with only remote cluster state or
        }
        public Snapshot getSnapshot() {
            // Check internal ignore patterns first (they override protection)  
                                        totalRestorableRemoteIndexesSize += shardStatus.getTotalSize();
                    cleanRestoreStateTaskExecutor,
                    return false;  
                    new RestoreInProgress.Entry(
        final Settings newSettings = Settings.builder()
            // mark snapshot as completed  
                    private boolean checkPartial(String index) {
                        entry.snapshot(),  
                                    "cannot rename index ["
            } else {  
                                    snapshotInfo.isRemoteStoreIndexShallowCopyEnabled()
                                        for (final AliasMetadata alias : currentIndexMetadata.getAliases().values()) {  
import org.opensearch.action.StepListener;
                } else {
        List<String> internalSimpleMatchPatterns = new ArrayList<>();  
                                    throw new SnapshotRestoreException(  
 * not use this file except in compliance with the License.
 * {@link RestoreListenerPlugin} is told about the restore. In case of
                                    );
 * Service responsible for restoring snapshots
    public static int failedShards(final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards) {
     */
                        if (RemoteStoreNodeAttribute.isRemoteStoreAttributePresent(clusterService.getSettings())  
        if (false == RemoteStoreNodeAttribute.isRemoteDataAttributePresent(nodeSettings)) {
                            } else {  
                return nonCompletedState;
                                    request.indexSettings(),
                }
        }
            if (!Regex.isSimpleMatchPattern(ignoredSetting)) {
                                }
import org.opensearch.core.index.shard.ShardId;
    private final RepositoriesService repositoriesService;
        MetadataCreateIndexService createIndexService,
import static org.opensearch.index.IndexModule.INDEX_STORE_TYPE_SETTING;
                    + "]"
                                            new RestoreInProgress.ShardRestoreStatus(clusterService.state().nodes().getLocalNodeId())
                                snapshot,  
                                        + renamedIndex.getKey()
                                if (isSearchableSnapshot && isRemoteStoreShallowCopy) {  
        }
        /**
                                    }
                            settingsBuilder,
    /**  
                                    restoreUUID,  
                            if (indexScopedSettings.isUnmodifiableOnRestoreSetting(key)) {
     * @param userIgnoreSettings array of user-provided settings to ignore
     * Attaches each restored {@code .ds-<streamName>-NNNNNN} index to a pre-existing data stream of the same name, in
                    if (unassignedInfo.getFailure() != null && Lucene.isCorruptionException(unassignedInfo.getFailure().getCause())) {
 * this file be licensed under the Apache-2.0 license or a
        public void clusterStatePublished(ClusterChangedEvent event) {  
                        Map<String, AggregateFileCacheStats> nodeFileCacheStats = clusterInfo.getNodeFileCacheStats();  
                                for (final Map.Entry<String, Metadata.Custom> cursor : metadata.customs().entrySet()) {
    private void cleanupRestoreState(ClusterChangedEvent event) {  
                    indices.add(index);
                    request.repository(),
            if (partOfDataStream) {
    }
                            throw new SnapshotRestoreException(
        }
            return oldRestore;
                    private void populateIgnoredShards(String index, final Set<Integer> ignoreShards) {
                    + "], ["
            // restoring a snapshot and should not be manually set by user.  
        public RestoreInProgress applyChanges(final RestoreInProgress oldRestore) {
                                if (isRemoteSnapshot) {
                                        if (!snapshotIndexMetadata.getAliases().isEmpty()) {
                    requestIndices.toArray(new String[0]),
 * <p>
                                        "cannot restore shallow copy snapshot for index ["  
     * transient state {@link Metadata.Builder} validation rejects (a convention-named index above the generation).  
                    globalMetadata = repository.getSnapshotGlobalMetadata(snapshotId);
                    request.indicesOptions()  
                        for (SnapshotShardFailure failure : snapshotInfo.shardFailures()) {  
            ClusterStateTaskListener {
                        }
        Set<String> internalKeyFilters = new HashSet<>();
                    ) {
                                    renamedIndex = updatedIndexMetadata.getIndex();
                    .filter(s -> snapshotName.equals(s.getName()))  
import org.opensearch.cluster.ClusterStateApplier;
            }
     * @return a predicate that returns true if the setting should be kept, false if it should be filtered out
                            }
                    );
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
                );
import org.opensearch.cluster.ClusterChangedEvent;
        List<Index> updatedIndices = dataStream.getIndices()  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
import java.util.Arrays;  
import org.opensearch.cluster.routing.RoutingChangesObserver;  
                                }
                        if (currentIndexMetadata.getState() != IndexMetadata.State.CLOSE) {  
                // Resolve the indices from the snapshot that need to be restored
    /**
            }
                                    mdBuilder.put(updatedIndexMetadata, true);  
        }  
                        globalMetadata = repository.getSnapshotGlobalMetadata(snapshotId);  
                        if (request.attachToDataStream()) {  
                                snapshotId.getName(),
        }  
            logger.warn(
                }
        } else {  
                                            )  
                        if (request.includeGlobalState()) {  
                return builder.build();  
import org.opensearch.index.shard.IndexShard;
import org.opensearch.cluster.RestoreInProgress.ShardRestoreStatus;
                        Set<String> protectedSettings = new HashSet<>(USER_UNREMOVABLE_SETTINGS);  
                builder.add(entry);
     * Internal ignore patterns override protection and can filter any setting.
    }
        }
            }
                        return restoreSnapshotTaskKey;
                                    snapshotIndexMetadata = addSnapshotToIndexSettings(snapshotIndexMetadata, snapshot, snapshotIndexId);  
                            );
                snapshot,
                                    MetadataCreateIndexService.validateRefreshIntervalSettings(cursor.settings(), clusterSettings);  
                                "Size information unavailable for {} out of {} remote snapshot shards. "
                                        + "] into ["  
                                        IndexShardSnapshotStatus.Copy shardStatus = repository.getShardSnapshotStatus(  
        unremovable.addAll(USER_UNMODIFIABLE_SETTINGS);
                    && currentState.getMetadata().index(index) != null) {  
                            && clusterService.state().getMetadata().getIndexSafe(shardRouting.index()).isRemoteSnapshot();
                                        ).asCopy();
                                        Math.max(snapshotIndexMetadata.getSettingsVersion(), 1 + currentIndexMetadata.getSettingsVersion())
     */
                                    );
                        entry.indices(),
    public static Set<Index> restoringIndices(final ClusterState currentState, final Set<Index> indicesToCheck) {
import java.util.function.Predicate;
         * tasks in one batch asked to clean up is reported once.  
                                    + "with same name already exists in the cluster. Either close or delete the existing index or restore the "
import org.opensearch.repositories.IndexId;
import org.opensearch.common.settings.ClusterSettings;  
                    }
            if (currentDs == null || restoredIndexMetadata == null) {  
                                        snapshotIndexMetadata.getSettings(),  
                    /**
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
 * @opensearch.internal
                        // Updating cluster state  
                        // cluster. If cluster is undergoing remote store migration, replication strategy is strictly SEGMENT type
import org.opensearch.cluster.block.ClusterBlocks;  
                            }
                        checkAliasNameConflicts(indices, aliases);  
                     * merging them with settings in changeSettings.
            );
            if (previousIndex != null) {  
                        Set<String> aliases = new HashSet<>();
import static org.opensearch.common.util.IndexUtils.filterIndices;
                    .map(Index::getName)
                                }  
                                    indexSettingsBuilder.put(SETTING_HISTORY_UUID, UUIDs.randomBase64UUID());
        Set<String> protectedSettings
                        ClusterState.Builder builder = ClusterState.builder(currentState);
                                    }
                                    "index [" + index + "] wasn't fully snapshotted - cannot " + "restore"  
                                }
                                            + index
                            .values()  
    /**  
                for (IndexId indexId : indexIdsInSnapshot) {
        if (DiscoveryNode.isClusterManagerNode(clusterService.getSettings())) {
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
                                    + snapshotIndexMetadata.getNumberOfShards()
            if (status.state() == RestoreInProgress.State.FAILURE) {
                            }));
     * Updates based on restore progress
import java.util.function.Consumer;
                        ClusterState updatedState = builder.metadata(mdBuilder).blocks(blocks).routingTable(rt).build();
        IndicesService indicesService,
                                    );
                                null,
                }
        );  
                                    mdBuilder.put(updatedIndexMetadata, true);  
                                            .put(snapshotIndexMetadata.getSettings())  
import org.opensearch.cluster.RestoreInProgress;  
                                }
     * @param snapshotInfo    snapshot metadata  
                            attachRestoredBackingIndices(indices.keySet(), mdBuilder, updatedDataStreams);
                    )
                        if (failed(snapshotInfo, index)) {  
                                } else {
                            }
        private final Snapshot snapshot;  
import org.opensearch.cluster.ClusterStateTaskConfig;
/*  
                builder.add(  
                if (userKeyFilters.contains(k)) {  
                            );  
            return RestoreInProgress.State.SUCCESS;
                            );  
                                                clusterService.state().nodes().getLocalNodeId(),
                                shardsBuilder.put(shardId, shard.getValue());
                        Settings settings = indexMetadata.getSettings();
                        ShardsIterator shardsIterator = clusterService.state()  
                        long totalRestorableRemoteIndexesSize = 0;
                                unassignedInfo.getFailure().getCause().getMessage()
                Map<String, DataStream> dataStreams;
        } catch (Exception e) {  
            if (failedShard.primary() && failedShard.initializing()) {
        }  
        return k -> {
        unremovable.add(SETTING_NUMBER_OF_REPLICAS);  
                                    metadata.index(index),
                final Map<ShardId, ShardRestoreStatus> shards = Collections.unmodifiableMap(shardsBuilder);
                            if (index.equals(failure.index())) {
                            ShardRestoreStatus status = shardStates.get(shardId);
                                    mdBuilder.put(cursor);
                    changes(recoverySource).put(
                        }
                            && IndexSettings.INDEX_SOFT_DELETES_SETTING.get(overrideSettings) == false) {
import org.opensearch.cluster.routing.RecoverySource;
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_SHARD_PATH_TYPE.getKey(), PathType.fromCode(indexId.getShardPathType()))
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;  
                            if (shardSize != null) {
            if (!Regex.isSimpleMatchPattern(ignoredSetting)) {
import org.opensearch.index.IndexModule;
                        "snapshot UUID mismatch: expected [" + request.snapshotUuid() + "] but got [" + snapshotId.getUUID() + "]"
            dataStreamName = dataStreamName.replaceAll(request.renamePattern(), request.renameReplacement());
                        shardsBuilder = new HashMap<>(entry.shards());
    }
            if (internalKeyFilters.contains(k)) {
                                                RestoreInProgress.State.FAILURE
        for (SnapshotShardFailure failure : snapshot.shardFailures()) {  
 *  
                final Metadata.Builder metadataBuilder;  
                    "cannot restore remote snapshot with index settings \"index.store.type\" set to \"remote_snapshot\". Instead use \"storage_type\": \"remote_snapshot\" as argument to restore."  
            }  
                                    );  
                                    createIndexService.validateDotIndex(renamedIndexName, isHidden);
                                }
                                    indexMdBuilder.settingsVersion(
                                    indexMdBuilder.settings(indexSettingsBuilder);
            }  
                failedShards++;  
                                    + " setting."
     */
                            // We don't have any indices to restore - we are done  
import java.util.HashMap;
        this.metadataIndexUpgradeService = metadataIndexUpgradeService;  
                .build();
import org.opensearch.common.settings.Settings;
                        } else {
                                for (final IndexTemplateMetadata cursor : metadata.templates().values()) {
            if (currentDs.getIndices().contains(restoredIndexMetadata.getIndex())) {  
        public RestoreInfo getRestoreInfo() {
        }  
                                    + "] because an open index "  
                        }
                                    request.aliasWriteIndexPolicy()  
        public ClusterTasksResult<Task> execute(final ClusterState currentState, final List<Task> tasks) {  
    }
                                RestoreInProgress.TYPE,  
    /**
                final List<IndexId> indexIdsInSnapshot = repositoryData.resolveIndices(indicesInSnapshot);
import org.opensearch.common.util.ArrayUtils;
     * @param request  restore request  
                                .map(ds -> updateDataStream(ds, mdBuilder, request))  
            }  
                        if (indices.isEmpty() == false) {
        Supplier<ClusterInfo> clusterInfoSupplier,  
                            .allShardsSatisfyingPredicate(isRemoteSnapshotShard);
                                        .state(IndexMetadata.State.OPEN);  
                                    snapshotIndexMetadata
        }
        String[] internalIgnoreSettings,  
                                        indexMdBuilder.removeAllAliases();
 * restore failure a normal recovery fail-over process kicks in.
                                totalRestoredRemoteIndicesSize += shardSize;
                        Predicate<ShardRouting> isRemoteSnapshotShard = shardRouting -> shardRouting.primary()  
                );
     * @param protectedSettings set of settings that user cannot remove
                                    } else {  
                                        );  
                                        "cannot modify UnmodifiableOnRestore setting [" + k + "] on restore"  
 * <p>
                            )  
                        if (IndexSettings.INDEX_SOFT_DELETES_SETTING.get(indexMetadata.getSettings())
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS;
                                    throw new SnapshotRestoreException(
            if (shardChanges.isEmpty() == false) {
        for (String restoredIndexName : restoredIndexNames) {
                        IndexMetadata.Builder builder = IndexMetadata.builder(indexMetadata);
                            }  
                        return false;
            throw new SnapshotRestoreException(
                                snapshot,
     * Returns the set of settings that users cannot remove during restore.
    private final CleanRestoreStateTaskExecutor cleanRestoreStateTaskExecutor;
import org.apache.logging.log4j.LogManager;  
 * {@link RoutingTable.Builder#addAsRestore(IndexMetadata, SnapshotRecoverySource)} method.
        public RestoreCompletionResponse(final String uuid, final Snapshot snapshot, final RestoreInfo restoreInfo) {  
                        for (Map.Entry<ShardId, ShardRestoreStatus> shard : updates.entrySet()) {  
                                routings.size()
                .searchRouting(aliasMd.searchRouting())
        return aliasMd;  
                                String newAliasName = renameAliasPattern.matcher(currentAliasName)
        /**  
                                    }
                                        clusterSettings
        public String getUuid() {  
            logger.warn("Failed to update restore state ", t);  
                        for (String key : settings.keySet()) {
                final Metadata metadata = metadataBuilder.build();  
 * preconditions, restores global state if needed, creates {@link RestoreInProgress} record with list of shards that needs
import org.opensearch.threadpool.ThreadPool;  
 * Unless required by applicable law or agreed to in writing,
    }
                    // to restore this shard on another node if the snapshot files are corrupt. In case where a node just left or crashed,  
                                    throw new SnapshotRestoreException(snapshot, "cannot modify setting [" + k + "] on restore");
                            throw new SnapshotRestoreException(
                                throw new SnapshotRestoreException(
                    + " as ["
                validateSnapshotRestorable(repositoryName, snapshotInfo);
            final Map<String, ClusterState.Custom> customs = Collections.unmodifiableMap(builder);
                );
                                if (USER_UNREMOVABLE_SETTINGS.contains(ignoredSetting)) {  
                }
                                        // Also, don't restore data streams here, we already added them to the metadata builder above
        Map<String, DataStream> updatedDataStreams  
            final StepListener<RepositoryData> repositoryDataListener = new StepListener<>();  
    }
        if (Version.CURRENT.before(snapshotInfo.version())) {  
                            if (aliases.contains(renamedIndex.getKey())) {
                            protectedSettings
            } else {  
    /**  
                .indexRouting(aliasMd.indexRouting())  
                                    IndexMetadata updatedIndexMetadata = indexMdBuilder.index(renamedIndexName).build();  
                    + "]"
                    + "] which is higher than the version of this node ["
        RestoreInProgress.Builder builder = new RestoreInProgress.Builder();  
     * Package-private for testing.  
            .build();  
                                    snapshot,  
                                clusterService.getSettings(),  
                        );
        @Override
                                    for (int shard = 0; shard < snapshotIndexMetadata.getNumberOfShards(); shard++) {
                        IndexMetadata currentIndexMetadata,  
                                            Math.max(snapshotIndexMetadata.primaryTerm(shard), currentIndexMetadata.primaryTerm(shard))
        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
            return resultBuilder.build(ClusterState.builder(currentState).customs(customs).build());  
                throw new SnapshotRestoreException(  
                        Predicate<String> settingsFilter = createSettingsFilterPredicate(
                            * totalNodeFileCacheSize) {  
            }
                                    indexMdBuilder.version(
 */
            }
                            .normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX)  
                clusterService.submitStateUpdateTask(
            this.uuid = uuid;
}  
                    }  
     *
            return uuid;
            clusterService.addStateApplier(this);
    }
                                        .put(snapshotIndexMetadata.getSettings())
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
 * under the License.  
                    }
                        new ShardRestoreStatus(initializingShard.currentNodeId(), RestoreInProgress.State.SUCCESS)  
        }
    private static final Set<String> USER_UNMODIFIABLE_SETTINGS = unmodifiableSet(
        static class Task {
                        // override internal settings
import org.opensearch.cluster.metadata.RepositoriesMetadata;
                }  
                                ignoreShards.add(failure.shardId());
import org.opensearch.cluster.routing.UnassignedInfo;
                                            snapshotIndexId,
                                        + renamedIndex.getValue()
                    }  
            .map(i -> metadata.get(renameIndex(i.getName(), request, true)).getIndex())
                        }
        unremovable.add(SETTING_AUTO_EXPAND_REPLICAS);
        for (String index : filteredIndices) {  
                    request.repository(),
                            logger.warn(  
        @Override
    }
                        }  
import org.opensearch.cluster.node.DiscoveryNode;  
 * to be restored and adds this shard to the routing table using  
                } else {  
                                    isSearchableSnapshot,
                final String snapshotName = request.snapshot();  
                    request.snapshot(),
                final Optional<SnapshotId> matchingSnapshotId = repositoryData.getSnapshotIds()
                                    // Index exists and it's closed - open it in metadata and start recovery
                    .stream()  
import java.util.function.Function;  
            return restoreInfo;  
    private static final String REMOTE_STORE_INDEX_SETTINGS_REGEX = "index.remote_store.*";
                ShardId shardId = cursor.getKey();
                                }
        Map<String, String> renamedIndices = new HashMap<>();
        }
            // Setting INDEX_STORE_TYPE_SETTING as REMOTE_SNAPSHOT is intended to be a system-managed index setting that is configured when
                                        shardsBuilder.put(
            }, listener::onFailure);
                        RestoreSnapshotRequest request,
                                    );  
                }
                            );  
            this.snapshot = snapshot;
                                    + deletionsInProgress.getEntries().get(0)
import org.opensearch.Version;  
            } else {  
                            );
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_INDEX_ID.getKey(), indexId.getId())
                        long totalRestoredRemoteIndicesSize = 0;
                                        mdBuilder.putCustom(cursor.getKey(), cursor.getValue());
                        // Restore global state if needed
            final String uuid;
                    }  
                            clusterService.getSettings(),
                    + " as ["
                                Set<Integer> ignoreShards = new HashSet<>();  
            repository.getRepositoryData(repositoryDataListener);
                    @Override
                );
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
                                        indexMdBuilder.primaryTerm(  
                        // We will use whatever replication strategy provided by user or from snapshot metadata unless  
                        );
                    "indices [" + index + "] and [" + previousIndex + "] are renamed into the same index [" + renamedIndex + "]"
            logger.error(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);
import org.opensearch.cluster.metadata.MetadataDataStreamsService;
                        ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());  
                        builder.add(new RestoreInProgress.Entry(entry.uuid(), entry.snapshot(), newState, entry.indices(), shards));
            }
            if (recoverySource.getType() == RecoverySource.Type.SNAPSHOT) {
                    final String restoreUUID = UUIDs.randomBase64UUID();  
                                IndexId snapshotIndexId = repositoryData.resolveIndexId(index);
        }
                        return RestoreService.getIgnoreSettingsInternal(clusterService.getSettings());  
    ) {
                            for (final Map.Entry<String, AliasMetadata> alias : snapshotAliases.entrySet()) {
                }
    static Predicate<String> createSettingsFilterPredicate(
                    for (String requestedDataStream : requestedDataStreams) {
                            MetadataCreateIndexService.updateReplicationStrategy(  
                List<String> requestedDataStreams = filterIndices(
                        );
                                } else if (indexScopedSettings.isUnmodifiableOnRestoreSetting(k)) {  
                    final Map<String, DataStream> dataStreamsInSnapshot = globalMetadata.dataStreams();
                                final SnapshotRecoverySource recoverySource = new SnapshotRecoverySource(
     * User ignore patterns respect protected settings and cannot filter them.  
                                    );  
                                    isRemoteStoreShallowCopy,
                if (newUnassignedInfo.getLastAllocationStatus() == UnassignedInfo.AllocationStatus.DECIDERS_NO) {  
                            ShardId shardId = shard.getKey();
                    + ReplicationType.DOCUMENT  
                    + snapshotInfo.version()
                            }
import org.opensearch.cluster.ClusterStateUpdateTask;
                        unassignedShard.shardId(),  
 */
                    public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            .collect(Collectors.toList());  
                }
                            && IndexSettings.INDEX_SOFT_DELETES_SETTING.exists(overrideSettings)  
                        if (deletionsInProgress.getEntries().stream().anyMatch(entry -> entry.getSnapshots().contains(snapshotId))) {  
                        IndexMetadata indexMetadata,
                            || clusterSettings.get(IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING)
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
                            );
     * {@code index.remote_store.*} settings stripped on restore.
                                );  
     *
                if (recoverySource.getType() == RecoverySource.Type.SNAPSHOT) {  
                                snapshot,
                if (deletedIndices.contains(shardId.getIndex())) {
        return false;
                        for (ShardRouting shardRouting : routings) {
                                    // Index doesn't exist - create it and start recovery  
                    );
                                        applyAliasesWithRename(snapshotIndexMetadata.getAliases(), request, indexMdBuilder, aliases);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.lucene.Lucene;
                new Snapshot(repository, snapshotInfo.snapshotId()),
import org.opensearch.cluster.service.ClusterService;
    // visible for testing  
                                RestoreInProgress.State.FAILURE,
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
                    String reason = "shard could not be allocated to any of the nodes";
                            }  
            IndexMetadata restoredIndexMetadata = metadata.get(restoredIndexName);
        return renamedIndex;
                                    indexMdBuilder.settings(
                            .routingTable()
                        return settingsBuilder.build();
                        } else {  
                                    if (partial) {
                        }  
        for (RestoreInProgress.Entry entry : event.state().custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY)) {
                                restoreUUID,
        this.clusterService = clusterService;
            }  
                            for (final Map.Entry<String, AliasMetadata> alias : snapshotAliases.entrySet()) {  
    }  
                                snapshot,  
        return true;
            }
        this.shardLimitValidator = shardLimitValidator;
                                    );  
 */
                        for (Map.Entry<String, String> renamedIndex : renamedIndices.entrySet()) {  
        };
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_ID_NAME.getKey(), snapshot.getSnapshotId().getName())  
    /**
                            clusterSettings,
        List<String> userSimpleMatchPatterns = new ArrayList<>();
                            throw new SnapshotRestoreException(
     */  
            throw new SnapshotRestoreException(
            @Override
        this.allocationService = allocationService;
                                    }
        }  
    }  
                    + SETTING_REPLICATION_TYPE  
                    private void applyAliasesWithRename(
            return builder.build();
import org.opensearch.indices.replication.common.ReplicationType;
                            // We have some indices to restore
                                    if (isRemoteSnapshot) {
 * software distributed under the License is distributed on an
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;  
                                        ex
    static Set<String> getUserUnremovableSettings() {
                            new ShardRestoreStatus(
    static AliasMetadata applyAliasWriteIndexPolicy(AliasMetadata aliasMd, RestoreSnapshotRequest.AliasWriteIndexPolicy policy) {
                                Collections.unmodifiableList(new ArrayList<>(indices.keySet())),
                            .put(settings.filter(settingsFilter))
                                    final Settings.Builder indexSettingsBuilder = Settings.builder()  
import org.opensearch.cluster.metadata.MetadataIndexStateService;  
                                shards  
    ) {
    static {  
            renamedIndex = index.replaceAll(request.renamePattern(), request.renameReplacement());  
                }
                            );  
     */  
                        // Make sure that the number of shards is the same. That's the only thing that we cannot change  
import org.opensearch.cluster.metadata.IndexMetadata;
                    }  
    private static String renameIndex(String index, RestoreSnapshotRequest request, boolean partOfDataStream) {
                    }
import java.util.HashSet;  
                        }  
                    }
                            restoreInfo = new RestoreInfo(
                    + "] must be set to [0]"  
        this.cleanRestoreStateTaskExecutor = new CleanRestoreStateTaskExecutor(
                    }
                                    shardLimitValidator.validateShardLimit(
    /**
                return resultBuilder.build(currentState);
                            if (metadata.templates() != null) {  
        @Override
                        // cluster is remote store enabled or user have restricted a specific replication type in the
        @Override
    static class CleanRestoreStateTaskExecutor
    }
package org.opensearch.snapshots;
                continue;
                                        // Remove all aliases - they shouldn't be restored
                        final boolean isRemoteSnapshot = IndexModule.Type.REMOTE_SNAPSHOT.match(request.storageType().toString());  
                                    + "index under a different name by providing a rename pattern and replacement name"
import org.opensearch.index.IndexSettings;  
            builder.put(RestoreInProgress.TYPE, restoreInProgressBuilder.build());
                        }
                                return true;
                        snapshotName,
     * @param internalIgnoreSettings array of internal settings to ignore (override protection)  
                                            new ShardId(renamedIndex, shard),  
import org.opensearch.indices.ShardLimitValidator;  
        }
                            }
                        logger.warn(() -> new ParameterizedMessage("[{}] failed to restore snapshot", snapshotId), e);  
        public void shardFailed(ShardRouting failedShard, UnassignedInfo unassignedInfo) {
                    if (globalMetadata == null) {
                    }
                        int missingSizeCount = 0;
            }  
                userKeyFilters.add(ignoredSetting);
                        Settings overrideSettings,
                }  
                clusterService.submitStateUpdateTask("restore_snapshot[" + snapshotName + ']', new ClusterStateUpdateTask() {
            this.restoreInfo = restoreInfo;  
        implements  
                        RestoreInProgress.State.FAILURE,
                                missingSizeCount++;
                        }  
                    }
                    @Override
/*
        public void shardInitialized(ShardRouting unassignedShard, ShardRouting initializedShard) {
import org.opensearch.cluster.metadata.Metadata;  
                        }
        this.indexScopedSettings = createIndexService.getIndexScopedSettings();
            } else {
                            .sum();
     * onto a cluster that does not store index data remotely.
                if (indicesToCheck.contains(index)
                                overallState(RestoreInProgress.State.INIT, shards),
                                        // TODO: Should we restore them at the end?  
        ShardLimitValidator shardLimitValidator,
        CleanRestoreStateTaskExecutor(Consumer<RestoreInProgress.Entry> onRestoreCompleted) {
                                        snapshot,
    }
    private static void validateSnapshotRestorable(final String repository, final SnapshotInfo snapshotInfo) {
import org.opensearch.cluster.routing.ShardsIterator;  
                        }  
                                        snapshot,
                    + "]."
                        // cluster where snapshot is being restored.  
                    }  
            if (shardsBuilder != null) {
                new Snapshot(repository, snapshotInfo.snapshotId()),
     * Restores snapshot specified in the restore request.
                        }  
                        final Map<ShardId, ShardRestoreStatus> shards = Collections.unmodifiableMap(shardsBuilder);
        if (changesMade) {
                changes(unassignedShard.recoverySource()).put(  
                                final Settings overrideSettingsInternal = getOverrideSettingsInternal();  
        public void shardStarted(ShardRouting initializingShard, ShardRouting startedShard) {
                        );
                                missingSizeCount,  
    }  
                );  
                                    );
    static DataStream updateDataStream(DataStream dataStream, Metadata.Builder metadata, RestoreSnapshotRequest request) {
                            }
    private static RestoreInProgress.State overallState(  
                        IndexMetadata.Builder indexMdBuilder,
            }
                        overallState(RestoreInProgress.State.STARTED, shards),
                        if (totalRestoredRemoteIndicesSize + totalRestorableRemoteIndexesSize > remoteDataToFileCacheRatio
                                ).build()  
                    requestIndices.toArray(new String[0]),
            }  
                    private IndexMetadata updateIndexSettings(  
    public static boolean failed(SnapshotInfo snapshot, String index) {
     * @param listener restore listener
 * which removes {@link RestoreInProgress} when all shards are completed. Once that removal is published, every  
    private final IndicesService indicesService;  
import java.util.regex.Pattern;  
                                    if (!request.includeAliases() && !snapshotIndexMetadata.getAliases().isEmpty()) {  
                        }
                        listener.onFailure(e);
            && ReplicationType.DOCUMENT.toString().equals(updatedMetadata.getSettings().get(SETTING_REPLICATION_TYPE))) {
                                        }
            updatedDataStreams.put(streamName, currentDs.addBackingIndex(restoredIndexMetadata.getIndex()));
                                    );
                if (requestedDataStreams.isEmpty()) {
                            .put(overrideSettings)
    private final ClusterService clusterService;
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
                                        populateIgnoredShards(index, ignoreShards);
            if (!protectedSettings.contains(k)) {
     * Exposed for testing purposes.  
     * @param nodeSettings the node settings of the cluster performing the restore  
    }
                                    snapshot,
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
            new RestoreCompletionNotifier(threadPool, restoreListenerPlugins)::restoreCompleted
        ClusterService clusterService,
     * the same cluster-state update as the restore. Adding the index and advancing the generation together avoids the
         * Helper method that creates update entry for the given recovery source's restore uuid
    private final ClusterManagerTaskThrottler.ThrottlingKey restoreSnapshotTaskKey;
            }
     * Updates {@code updatedDataStreams} in place. Visible for testing.
                        for (String ignoredSetting : ignoreSettings) {
            assert recoverySource.getType() == RecoverySource.Type.SNAPSHOT;  
 * KIND, either express or implied.  See the License for the
                for (String pattern : userSimpleMatchPatterns) {  
                                    + currentIndexMetadata.getNumberOfShards()
     * Response once restore is completed.  
    public static boolean completed(final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards) {
                        Map<String, AliasMetadata> snapshotAliases,  
            }  
                                    snapshotInfo.version(),
                        boolean partial  
        @Override  
        return IndexMetadata.builder(metadata).settings(newSettings).build();
                }
                                "cannot restore a snapshot while a snapshot deletion is in-progress ["  
                    unassignedShard.shardId(),
                    && shard.getValue().state().completed() == false
                                IndexMetadata currentIndexMetadata = currentState.metadata().index(renamedIndexName);
            for (RestoreInProgress.Entry entry : event.previousState().custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY)) {
            }
     * Creates a settings filter predicate that separates internal ignore patterns from user ignore patterns.
        }
import org.opensearch.cluster.ClusterStateTaskExecutor;  
        Set<String> userKeyFilters = new HashSet<>();  
                }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
            // A backing index must map the timestamp field as a date, or data stream search breaks.  
                        long totalNodeFileCacheSize = clusterInfo.getNodeFileCacheStats()
        }
                                snapshot,  
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_REPOSITORY.getKey(), snapshot.getRepository())
                                            new ShardId(metadata.index(index).getIndex(), shard)  
                                AliasMetadata transformedAlias = applyAliasWriteIndexPolicy(
                                        && DataStreamMetadata.TYPE.equals(cursor.getKey()) == false) {
                        String renamedIndex,
    public static RestoreInProgress updateRestoreStateWithDeletedIndices(RestoreInProgress oldRestore, Set<Index> deletedIndices) {
                                    } else {  
                cleanupRestoreState(event);  
                    dataStreams = new HashMap<>(requestedDataStreams.size());  
                        }
                .filter(aliasMd.filter())
            Task(String uuid) {
                final List<String> indicesInSnapshot = filterIndices(  
                                    );  
                            validateSearchableSnapshotRestorable(totalRestorableRemoteIndexesSize);
 * compatible open source license.
                                    // Make sure that the index we are about to create has valid name
                    }
            return AliasMetadata.builder(aliasMd.alias())
                    changed = true;
import org.opensearch.repositories.RepositoryData;
        }  
            if (streamName == null) {
                if (request.snapshotUuid() != null && request.snapshotUuid().equals(snapshotId.getUUID()) == false) {
import org.opensearch.common.settings.IndexScopedSettings;
                    ) {
        public void onFailure(final String source, final Exception e) {
        // Map of RestoreUUID to a of changes to the shards' restore statuses
                                    IndexMetadata updatedIndexMetadata = indexMdBuilder.build();  
                        assert dataStreamInSnapshot != null : "DataStream [" + requestedDataStream + "] not found in snapshot";  
    // Visible for testing  
import org.opensearch.cluster.metadata.DataStream;
                                aliases.add(transformedAlias.alias());
                        );
                        RoutingTable rt = rtBuilder.build();  
                            Map<ShardId, RestoreInProgress.ShardRestoreStatus> shardsBuilder = new HashMap<>();  
                                            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
                            );
                            throw new SnapshotRestoreException(
                Index index = shard.getKey().getIndex();  
                            ignoreSettings,
            if (changed == false) {  
            // Read snapshot info and metadata from the repository  
                "the snapshot was created with OpenSearch version ["  
        public void unassignedInfoUpdated(ShardRouting unassignedShard, UnassignedInfo newUnassignedInfo) {  
    }
                                        applyAliasesWithRename(snapshotIndexMetadata.getAliases(), request, indexMdBuilder, aliases);
                                protectedSettings.add(key);  
         */
                        // Build combined protected settings set including dynamic unmodifiable settings
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_HISTORY_UUID;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.stream.Collectors;
                                // TODO: Should all existing templates be deleted first?
        boolean hasFailed = false;
                                String index = indexEntry.getValue();
                            }
    }  
                            Pattern renameAliasPattern = Pattern.compile(request.renameAliasPattern());
                                        minIndexCompatibilityVersion
                    if (shardsBuilder == null) {
                    @Override  
                                snapshot,  
                                    request.ignoreIndexSettings(),  
                                failedShard.currentNodeId(),  
            logger.debug("no longer cluster-manager while processing restore state update [{}]", source);
                                    blocks.updateBlocks(updatedIndexMetadata);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
                        initializingShard.shardId(),
        for (RestoreInProgress.Entry entry : currentState.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY)) {
                        }
                    }  
                        final double remoteDataToFileCacheRatio = dataToFileCacheSizeRatioSupplier.get();
                                if (USER_UNMODIFIABLE_SETTINGS.contains(k)) {
                    }  
                                final String[] ignoreSettingsInternal = getIgnoreSettingsInternal();
        final Set<Index> indices = new HashSet<>();  
                        // remote store related index settings present in the snapshot.
                                        /// Add existing aliases
 * at the {@link ShardRouting#recoverySource()} property.  
            );
        private final Map<String, Map<ShardId, ShardRestoreStatus>> shardChanges = new HashMap<>();
                                    snapshotIndexMetadata = metadataIndexUpgradeService.upgradeIndexMetadata(
                        dataStreams.put(requestedDataStream, dataStreamInSnapshot);
                                mdBuilder.persistentSettings(settings);
import org.opensearch.cluster.metadata.DataStreamMetadata;  
    ) {  
    }  
            }
     * @return array of index setting patterns to ignore during restore
                                    );
                                        Math.max(snapshotIndexMetadata.getAliasesVersion(), 1 + currentIndexMetadata.getAliasesVersion())
     * @opensearch.internal
                                    .replaceAll(request.renameAliasReplacement());  
 * method reads information about snapshot and metadata from repository. In update cluster state task it checks restore
import org.opensearch.action.support.IndicesOptions;  
            }  
                    .findFirst();
                                    if (!ignoreShards.contains(shard)) {
                    private Settings getOverrideSettingsInternal() {  
                if (recoverySource.getType() == RecoverySource.Type.SNAPSHOT) {
                    ) {  
                                final Version minIndexCompatibilityVersion = currentState.getNodes()
        }
import org.apache.logging.log4j.Logger;
                                    indexMdBuilder.aliasesVersion(
                        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards;
            if (status.state().completed() == false) {  
                                        Math.max(snapshotIndexMetadata.getMappingVersion(), 1 + currentIndexMetadata.getMappingVersion())
                                .collect(Collectors.toMap(DataStream::getName, Function.identity()))
            indexSettingsToBeIgnored = ArrayUtils.concat(indexSettingsToBeIgnored, new String[] { REMOTE_STORE_INDEX_SETTINGS_REGEX });  
                        }  
            Set<String> completedRestores = tasks.stream().map(e -> e.uuid).collect(Collectors.toSet());
                                    // add a restore uuid  
                                snapshot,
                                shards.size() - failedShards(shards)
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                                        "cannot remove UnmodifiableOnRestore setting [" + ignoredSetting + "] on restore"
import org.opensearch.repositories.RepositoriesService;  
                this.uuid = uuid;
        if (hasFailed) {
                                    + snapshotIndexMetadata.getIndex().getName()  
                    .stream()
                        shards  
 */  
                                for (int shard = 0; shard < snapshotIndexMetadata.getNumberOfShards(); shard++) {
                        if (currentIndexMetadata.getNumberOfShards() != snapshotIndexMetadata.getNumberOfShards()) {
 * GitHub history for details.
            if (partOfDataStream) {  
                                        currentState
        this.dataToFileCacheSizeRatioSupplier = dataToFileCacheSizeRatioSupplier;  
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;  
        unremovable.add(SETTING_VERSION_UPGRADED);
                    if (Regex.simpleMatch(pattern, k)) {
 * method, which detects that shard should be restored from snapshot rather than recovered from gateway by looking
                    changes(recoverySource).put(
                                        );
    // It's OK to change some settings, but we shouldn't allow simply removing them
                final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotId);  
                            // TODO: Enable restore for open indices
            return snapshot;
        this.createIndexService = createIndexService;
                }
                                    rtBuilder.addAsNewRestore(updatedIndexMetadata, recoverySource, ignoreShards);
                                    request.getSourceRemoteStoreRepository(),  
                                settingsBuilder,
         * Reports each restore this publication removed. Core now considers it finished: this is the same point at which
                    private void checkAliasNameConflicts(Map<String, String> renamedIndices, Set<String> aliases) {
import java.util.Set;
        USER_UNREMOVABLE_SETTINGS = unmodifiableSet(unremovable);  
        Set<String> restoredIndexNames,
    );  
public class RestoreService implements ClusterStateApplier {  
                            ignoreSettingsInternal,  
                                "cannot disable setting [" + IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey() + "] on restore"
                                    .getMaxNodeVersion()
                    // however, we only want to acknowledge the restore operation once it has been successfully restored on another node.
        try {
            if (entry.state().completed()) {
                            clusterService.state(),  
                    public void onFailure(String source, Exception e) {
                        }
    private final IndexScopedSettings indexScopedSettings;
import java.util.Optional;  
            DataStream currentDs = updatedDataStreams.get(streamName);
    }  
                            || RemoteStoreNodeService.isMigratingToRemoteStore(clusterSettings)) {
                        Map<ShardId, ShardRestoreStatus> shardsBuilder = new HashMap<>(shardStates);
                            throw new SnapshotRestoreException(
                }
        } else {  
                index = index.substring(DataStream.BACKING_INDEX_PREFIX.length());
                        return request.clusterManagerNodeTimeout();  
                );
        ThreadPool threadPool,
                            shards = Collections.unmodifiableMap(shardsBuilder);  
        private final String uuid;
     */
                                        .state(IndexMetadata.State.OPEN)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_UPGRADED;  
import org.opensearch.core.action.ActionListener;
                                );  
                            }
                            .build();
import org.opensearch.common.UUIDs;  
            }  
        String[] indexSettingsToBeIgnored = new String[] {};
                        return builder.settings(settingsBuilder).build();  
                                    validateExistingIndex(currentIndexMetadata, snapshotIndexMetadata, renamedIndexName, partial);  
                                aliases.add(transformedAlias.alias());
                                    createIndexService.validateIndexSettings(renamedIndexName, snapshotIndexMetadata.getSettings(), false);
                RecoverySource recoverySource = failedShard.recoverySource();  
                                        snapshot,
                                            indexMdBuilder.putAlias(alias);
                                    throw new SnapshotRestoreException(
import org.opensearch.cluster.ClusterState;  
            String previousIndex = renamedIndices.put(renamedIndex, index);
                            SnapshotDeletionsInProgress.TYPE,  
                                AliasMetadata transformedAlias = applyAliasWriteIndexPolicy(renamedAlias, request.aliasWriteIndexPolicy());
    private static IndexMetadata addSnapshotToIndexSettings(IndexMetadata metadata, Snapshot snapshot, IndexId indexId) {  
            }
                                            + "] as some of the nodes in cluster have version less than 2.9"
                    } else {
                        entry.uuid(),
                        Settings normalizedChangeSettings = Settings.builder()
import org.opensearch.cluster.metadata.AliasMetadata;
                    ClusterStateTaskConfig.build(Priority.URGENT),
                e  
                return true;
    }  
                    }
                                Settings settings = metadata.persistentSettings();
                if (matchingSnapshotId.isPresent() == false) {
        if (!snapshotInfo.state().restorable()) {  
        @Override
                    @Override  
        boolean changesMade = false;
                            .put(normalizedChangeSettings.filter(k -> {  
                                .stream()
            for (RestoreInProgress.Entry entry : currentState.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY)) {
    private final MetadataCreateIndexService createIndexService;
        }
    private final ClusterSettings clusterSettings;
        }  
                                IndexMetadata snapshotIndexMetadata = updateIndexSettings(  
        }
                    );  
        RepositoriesService repositoriesService,  
                                    + "] shards from a snapshot of index ["
                                    throw new SnapshotRestoreException(
        private Map<ShardId, ShardRestoreStatus> changes(RecoverySource recoverySource) {
/*
                hasFailed = true;
    static String[] getIgnoreSettingsInternal(Settings nodeSettings) {  
                    private void validateExistingIndex(
            if (unassignedShard.recoverySource().getType() == RecoverySource.Type.SNAPSHOT
                final Snapshot snapshot = new Snapshot(repositoryName, snapshotId);
        this.clusterSettings = clusterService.getClusterSettings();
                                            indexMdBuilder.removeAllAliases();  
                        if (isRemoteSnapshot) {
                    changesMade = true;  
        MetadataIndexUpgradeService metadataIndexUpgradeService,  
                                    blocks.addBlocks(updatedIndexMetadata);
                                    }  
                                    );  
                                    restoreEntry
                     * Optionally updates index settings in indexMetadata by removing settings listed in ignoreSettings and  
                                    IndexMetadata.Builder indexMdBuilder = IndexMetadata.builder(snapshotIndexMetadata)
                userSimpleMatchPatterns.add(ignoredSetting);
                            for (Map.Entry<String, String> indexEntry : indices.entrySet()) {
                                indexMdBuilder.removeAlias(currentAliasName);
        }
        for (final RestoreInProgress.ShardRestoreStatus status : shards.values()) {
    private static final Logger logger = LogManager.getLogger(RestoreService.class);
        if (restoreNumberOfSearchReplicas > 0
    /**
                        updatedDataStreams.putAll(  
                        if (request.renameAliasPattern() == null || request.renameAliasReplacement() == null) {
                                        shardsBuilder.put(
                            }
import static org.opensearch.node.Node.NODE_SEARCH_CACHE_SIZE_SETTING;
 *
    ) {
                                request.indexSettings(),
                            SnapshotDeletionsInProgress.EMPTY
        }
        }  
                                    );
                        settingsBuilder.remove(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey());
    /**
     * @opensearch.internal
            partOfDataStream = partOfDataStream && index.startsWith(DataStream.BACKING_INDEX_PREFIX);
                        // Index exist - checking if it's partial restore
                    // mark restore entry for this shard as failed when it's due to a file corruption. There is no need wait on retries
                                    + NODE_SEARCH_CACHE_SIZE_SETTING.getKey()
                                            new RestoreInProgress.ShardRestoreStatus(  
                final SnapshotId snapshotId = matchingSnapshotId.get();  
                    + SETTING_REPLICATION_TYPE  
        }
                                    boolean isHidden = IndexMetadata.INDEX_HIDDEN_SETTING.get(snapshotIndexMetadata.getSettings());
                                validateReplicationTypeRestoreSettings(
        return USER_UNREMOVABLE_SETTINGS;  
            boolean changed = false;
                        Set<String> aliases  
                            builder.putCustom(
                                            snapshotInfo,
        RestoreInProgress.State nonCompletedState,
            }
        }  
                     */
            }  
                            if (!Regex.isSimpleMatchPattern(ignoredSetting)) {
    }
                                    return true;  
                                    throw new SnapshotRestoreException(
                                // Check that the index is closed or doesn't exist
            for (final Map.Entry<ShardId, RestoreInProgress.ShardRestoreStatus> shard : entry.shards().entrySet()) {
        @Override
    }
    /**  
                        // Make sure that index was fully snapshotted
        newHashSet(SETTING_REMOTE_STORE_ENABLED, SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY)
                internalKeyFilters.add(ignoredSetting);
     */
import org.opensearch.cluster.routing.RoutingTable;
                for (RestoreInProgress.Entry entry : oldRestore) {
                                    snapshotIndexId,  
                            throw new ConcurrentSnapshotExecutionException(
                    shardsBuilder.put(shardId, new ShardRestoreStatus(null, RestoreInProgress.State.FAILURE, "index was deleted"));
        if (snapshotInfo.version() == null) {  
                                indexMdBuilder.removeAlias(alias.getKey());
                                try {
                            return false;
                                new RestoreInProgress.Builder(currentState.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY)).add(
                            if (request.partial()) {
                List<String> requestIndices = new ArrayList<>(Arrays.asList(request.indices()));  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
                "the snapshot has an unknown or unsupported version and cannot be restored"  
                                    request.getSourceRemoteTranslogRepository(),
                    new CleanRestoreStateTaskExecutor.Task(entry.uuid()),  
            .stream()
import java.util.Map;
     *  
                    + Version.CURRENT  
                    private String[] getIgnoreSettingsInternal() {  
                    }
         */
                            );  
import java.util.Collections;
            return shardChanges.computeIfAbsent(((SnapshotRecoverySource) recoverySource).restoreUUID(), k -> new HashMap<>());
                        Map<String, DataStream> updatedDataStreams = new HashMap<>(currentState.metadata().dataStreams());
            }
                                    ignoreSettingsInternal
                        } else {  
        for (String ignoredSetting : userIgnoreSettings) {  
import org.apache.logging.log4j.message.ParameterizedMessage;
                                    indexMdBuilder.mappingVersion(
                                Collections.unmodifiableList(new ArrayList<>(indices.keySet())),  
                        String[] ignoreSettingsInternal
    public static class RestoreInProgressUpdater extends RoutingChangesObserver.AbstractRoutingChangesObserver {  
                    )  
                                        Math.max(snapshotIndexMetadata.getVersion(), 1 + currentIndexMetadata.getVersion())
                    return false;
                                    + "] with ["  
                "snapshot was created with ["
                            Long shardSize = clusterInfo.getShardSize(shardRouting);  
                                    overrideSettingsInternal,
    static void validateReplicationTypeRestoreSettings(Snapshot snapshot, String snapshotReplicationType, IndexMetadata updatedMetadata) {
                                        // Remove all snapshot aliases
                    new ShardRestoreStatus(
                                    MetadataCreateIndexService.validateRefreshIntervalSettings(  
                requestIndices.removeAll(dataStreams.keySet());
                () -> new ParameterizedMessage("[{}] failed to restore snapshot", request.repository() + ":" + request.snapshot()),
                        if (overrideSettingsInternal != null) {
                    if (updates != null && updates.isEmpty() == false) {
                // Now we can start the actual restore process by adding shards to be recovered in the cluster state  
                    metadataBuilder = Metadata.builder();
        AllocationService allocationService,
                                if (isRemoteStoreShallowCopy && !currentState.getNodes().getMinNodeVersion().onOrAfter(Version.V_2_9_0)) {  
    }  
                                    + "File cache validation will use available data only.",
 *  
     */
                throw new SnapshotRestoreException(
                        // remote store settings needs to be overridden if the remote store feature is enabled in the
import org.opensearch.repositories.Repository;
                                        .index(renamedIndexName);  
            }
        if (request.renamePattern() != null && request.renameReplacement() != null) {  
        }  
                                "cannot restore partial index [" + renamedIndex + "] because such index already exists"  
                                if (currentIndexMetadata == null) {
        String renamedIndex = index;  
                        repositoryName,  
        Set<String> dataStreamIndices  
                Metadata globalMetadata = null;  
                    }  
        RestoreSnapshotRequest request,
                                    throw new SnapshotRestoreException(
                        // for a domain that does not store index data remotely, we will remove all the
        restoreSnapshotTaskKey = clusterService.registerClusterManagerTask(RESTORE_SNAPSHOT, true);  
                    metadataBuilder.put(repository.getSnapshotIndexMetaData(repositoryData, snapshotId, indexId), false);  
import org.opensearch.plugins.RestoreListenerPlugin;
                if (Regex.simpleMatch(pattern, k)) {
                    onRestoreCompleted.accept(entry);
                new Snapshot(repository, snapshotInfo.snapshotId()),
            );
         * a restore request that waits for completion returns. Called once per published state, so a restore that several
        }
                    cleanRestoreStateTaskExecutor  
                            );
        List<String> filteredIndices,
 * Modifications Copyright OpenSearch Contributors. See  
                        }
                        if (partial) {  
import org.opensearch.node.remotestore.RemoteStoreNodeService;  
                                shards.size(),
        for (String ignoredSetting : internalIgnoreSettings) {  
    ) {
                        if (nodeFileCacheStats.isEmpty() || remoteDataToFileCacheRatio <= 0.01f) {
            );
                });
            repositoryDataListener.whenComplete(repositoryData -> {
        return state.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY).get(restoreUUID);
        String dataStreamName = dataStream.getName();
                    RestoreInfo restoreInfo = null;
        return failedShards;  
                                );
                    public TimeValue timeout() {
        Metadata.Builder metadata,
                    "clean up snapshot restore state",
                            if (status == null || status.state().completed() == false) {  
                                        snapshot,
            RecoverySource recoverySource = unassignedShard.recoverySource();
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {

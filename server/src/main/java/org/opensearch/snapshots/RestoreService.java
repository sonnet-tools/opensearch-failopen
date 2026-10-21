                failedShards++;
import org.opensearch.cluster.ClusterStateTaskConfig;
                    );
         * Helper method that creates update entry for the given recovery source's restore uuid
                this.uuid = uuid;
            return restoreInfo;
            }
                    .filter(s -> snapshotName.equals(s.getName()))
            && ReplicationType.DOCUMENT.toString().equals(updatedMetadata.getSettings().get(SETTING_REPLICATION_TYPE))) {
                            .map(fileCacheStats -> fileCacheStats.getTotal().getBytes())
                                        + renamedIndex.getValue()
    private static IndexMetadata addSnapshotToIndexSettings(IndexMetadata metadata, Snapshot snapshot, IndexId indexId) {
                                    metadata.index(index),
                                            new RestoreInProgress.ShardRestoreStatus(clusterService.state().nodes().getLocalNodeId())
                            );
    private final MetadataIndexUpgradeService metadataIndexUpgradeService;
            }
                                }
 * license agreements. See the NOTICE file distributed with
                                    } else {
                    if (Regex.simpleMatch(pattern, k)) {
    }
import org.opensearch.index.shard.IndexShard;
                            }
                            .put(overrideSettings)
import org.apache.logging.log4j.LogManager;
import static org.opensearch.common.util.set.Sets.newHashSet;
                                } else {
            if (!Regex.isSimpleMatchPattern(ignoredSetting)) {
     * Creates a settings filter predicate that separates internal ignore patterns from user ignore patterns.
import org.opensearch.cluster.ClusterStateApplier;
                                    ignoreSettingsInternal
 * under the License.
        unremovable.add(SETTING_AUTO_EXPAND_REPLICAS);
                if (recoverySource.getType() == RecoverySource.Type.SNAPSHOT) {
                                    + renamedIndex
            if (shardChanges.isEmpty() == false) {
                        }
                    // mark restore entry for this shard as failed when it's due to a file corruption. There is no need wait on retries
                            && IndexSettings.INDEX_SOFT_DELETES_SETTING.exists(overrideSettings)
                                            shard,
        if (changesMade) {
import org.opensearch.plugins.RestoreListenerPlugin;
                                    renamedIndex = updatedIndexMetadata.getIndex();
import java.util.Collections;
     * Updates {@code updatedDataStreams} in place. Visible for testing.
                    ) {
     */
import org.opensearch.cluster.routing.allocation.AllocationService;
     * User ignore patterns respect protected settings and cannot filter them.
            for (RestoreInProgress.Entry entry : currentState.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY)) {
                                if (currentIndexMetadata == null) {
            String streamName = DataStream.parseDataStreamName(restoredIndexName);
     * Restores snapshot specified in the restore request.
            );
                    }
            this.onRestoreCompleted = onRestoreCompleted;
                                    snapshotIndexId,
            listener.onFailure(e);
            if (event.localNodeClusterManager()) {
                    restoreInProgressBuilder.add(entry);
    private final ClusterManagerTaskThrottler.ThrottlingKey restoreSnapshotTaskKey;
                    ) {
                final Map<ShardId, ShardRestoreStatus> shards = Collections.unmodifiableMap(shardsBuilder);
                                "cannot restore index ["
            return true;
                                IndexMetadata snapshotIndexMetadata = updateIndexSettings(
 * Restore operation is performed in several stages.
                final Snapshot snapshot = new Snapshot(repositoryName, snapshotId);
                                            new ShardId(metadata.index(index).getIndex(), shard)
                        if (request.renameAliasPattern() == null || request.renameAliasReplacement() == null) {
                // and updating cluster metadata (global and index) as needed
import java.util.HashMap;
import org.opensearch.cluster.metadata.MetadataDataStreamsService;
                                        snapshot,
            }
            assert recoverySource.getType() == RecoverySource.Type.SNAPSHOT;
                        MetadataCreateIndexService.updateRemoteStoreSettings(
                        }
     * @return a predicate that returns true if the setting should be kept, false if it should be filtered out
            if (status.state() == RestoreInProgress.State.FAILURE) {
                final Optional<SnapshotId> matchingSnapshotId = repositoryData.getSnapshotIds()
         */
                                for (int shard = 0; shard < snapshotIndexMetadata.getNumberOfShards(); shard++) {
                final Metadata.Builder metadataBuilder;
                    }
                                );
    private final RepositoriesService repositoriesService;
                                    + deletionsInProgress.getEntries().get(0)
                                    + "]"
                clusterService.submitStateUpdateTask(
                                        + "] into ["
            } else {
import org.opensearch.Version;
                Set<String> dataStreamIndices = dataStreams.values()
                if (requestedDataStreams.isEmpty()) {
     * @return array of index setting patterns to ignore during restore
            }
import org.opensearch.indices.ShardLimitValidator;
 * Individual shards are getting restored as part of normal recovery process in
        return failedShards;
                        for (ShardRouting shardRouting : routings) {
                return oldRestore;
                        if (failed(snapshotInfo, index)) {
        final Settings newSettings = Settings.builder()
                                        .state(IndexMetadata.State.OPEN);
                            .values()
                                    snapshotIndexMetadata = addSnapshotToIndexSettings(snapshotIndexMetadata, snapshot, snapshotIndexId);
                .build();
                    private Settings getOverrideSettingsInternal() {
                        if (indices.isEmpty() == false) {
                                        // Remove all aliases - they shouldn't be restored
                                "cannot restore index ["
                        ShardsIterator shardsIterator = clusterService.state()
                                    final Settings.Builder indexSettingsBuilder = Settings.builder()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_HISTORY_UUID;
                                    mdBuilder.put(updatedIndexMetadata, true);
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_SHARD_PATH_TYPE.getKey(), PathType.fromCode(indexId.getShardPathType()))
                                AliasMetadata renamedAlias = AliasMetadata.newAliasMetadata(alias.getValue(), newAliasName);
        }
        for (final RestoreInProgress.ShardRestoreStatus status : shards.values()) {
                                    );
import org.opensearch.repositories.RepositoryData;
                    IndicesOptions.fromOptions(true, true, true, true)
                        long totalRestorableRemoteIndexesSize = 0;
                        RestoreInProgress.State.FAILURE,
    public static boolean failed(SnapshotInfo snapshot, String index) {
                                    IndexMetadata.Builder indexMdBuilder = IndexMetadata.builder(snapshotIndexMetadata)
        }
        return USER_UNREMOVABLE_SETTINGS;
        List<String> userSimpleMatchPatterns = new ArrayList<>();
                            if (!Regex.isSimpleMatchPattern(ignoredSetting)) {
            final String uuid;
import org.opensearch.index.IndexSettings;
            }
     * Response once restore is completed.
                        }
    }
                        // We will use whatever replication strategy provided by user or from snapshot metadata unless
                        }
     * {@code index.remote_store.*} settings stripped on restore.
                }
                                        applyAliasesWithRename(snapshotIndexMetadata.getAliases(), request, indexMdBuilder, aliases);
                final List<IndexId> indexIdsInSnapshot = repositoryData.resolveIndices(indicesInSnapshot);
                        }
        Set<String> dataStreamIndices
    private final MetadataCreateIndexService createIndexService;
import org.opensearch.cluster.ClusterStateTaskListener;
        this.clusterSettings = clusterService.getClusterSettings();
                    request.snapshot(),
                            }
     * @param internalIgnoreSettings array of internal settings to ignore (override protection)
                        for (String ignoredSetting : ignoreSettings) {
                RecoverySource recoverySource = initializingShard.recoverySource();
    // It's OK to change some settings, but we shouldn't allow simply removing them
                        if (IndexSettings.INDEX_SOFT_DELETES_SETTING.get(indexMetadata.getSettings())
                                            snapshotIndexId,
                    dataStreams = new HashMap<>();
        }
                    public ClusterState execute(ClusterState currentState) {
 * Service responsible for restoring snapshots
                        // Index exist - checking if it's partial restore
                        return builder.settings(settingsBuilder).build();
                                    snapshotInfo.version(),
                        );
            }
                        final boolean isRemoteSnapshot = IndexModule.Type.REMOTE_SNAPSHOT.match(request.storageType().toString());
                        shards
 * {@link RestoreListenerPlugin} is told about the restore. In case of
    /**
                                        "cannot remove UnmodifiableOnRestore setting [" + ignoredSetting + "] on restore"
                if (request.snapshotUuid() != null && request.snapshotUuid().equals(snapshotId.getUUID()) == false) {
            final StepListener<RepositoryData> repositoryDataListener = new StepListener<>();
                    .stream()
    static void attachRestoredBackingIndices(
        }
    /**
                            }));
        }
                } else {
                    @Override
                                    throw new SnapshotRestoreException(
                    + " as ["
                                            Math.max(snapshotIndexMetadata.primaryTerm(shard), currentIndexMetadata.primaryTerm(shard))
}
    // visible for testing
            return uuid;
                    private boolean checkPartial(String index) {
        public void unassignedInfoUpdated(ShardRouting unassignedShard, UnassignedInfo newUnassignedInfo) {
                    }
                        for (String key : settings.keySet()) {
import org.opensearch.core.index.shard.ShardId;
                    changesMade = true;
                                for (final Map.Entry<String, Metadata.Custom> cursor : metadata.customs().entrySet()) {
                    if (updates != null && updates.isEmpty() == false) {
                    unassignedShard.shardId(),
                        IndexMetadata.Builder indexMdBuilder,
                                .map(ds -> updateDataStream(ds, mdBuilder, request))
        @Override
                                String renamedIndexName = indexEntry.getKey();
                                shardsBuilder.put(shardId, shard.getValue());
                                    createIndexService.addRemoteStoreCustomMetadata(indexMdBuilder, false, currentState);
            MetadataDataStreamsService.validateTimestampFieldMapping(restoredIndexMetadata, currentDs.getTimeStampField().getName());
                    throw new SnapshotRestoreException(repositoryName, snapshotName, "snapshot does not exist");
import static org.opensearch.index.IndexModule.INDEX_STORE_TYPE_SETTING;
        }
                                                RestoreInProgress.State.FAILURE
                        entry.snapshot(),
/**
                            shards = Collections.unmodifiableMap(shardsBuilder);
        }
                }
import java.util.Set;
                            logger.warn(
                .writeIndex(false)
        }
        }
        if (Version.CURRENT.before(snapshotInfo.version())) {
                    return false;
 * this work for additional information regarding copyright
            RestoreInProgress.Builder restoreInProgressBuilder = new RestoreInProgress.Builder();
                return resultBuilder.build(currentState);
                }
                                    blocks.addBlocks(updatedIndexMetadata);
        String renamedIndex = index;
            final ClusterTasksResult.Builder<Task> resultBuilder = ClusterTasksResult.<Task>builder().successes(tasks);
    static Predicate<String> createSettingsFilterPredicate(
        }
                    }
                                        // Also, don't restore data streams here, we already added them to the metadata builder above
                        Settings normalizedChangeSettings = Settings.builder()
            builder.put(RestoreInProgress.TYPE, restoreInProgressBuilder.build());
                    @Override
                if (indicesToCheck.contains(index)
import org.opensearch.cluster.routing.UnassignedInfo;
                                    alias.getValue(),
            return builder.build();
                                    if (!request.includeAliases()) {
                                Settings settings = metadata.persistentSettings();
    /**
        static class Task {
                    shardsBuilder.put(shardId, new ShardRestoreStatus(null, RestoreInProgress.State.FAILURE, "index was deleted"));
     */
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS;
    /**
                        return RestoreService.getIgnoreSettingsInternal(clusterService.getSettings());
                                IndexMetadata currentIndexMetadata = currentState.metadata().index(renamedIndexName);
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
                    + "]."
     * transient state {@link Metadata.Builder} validation rejects (a convention-named index above the generation).
    }
                RecoverySource recoverySource = failedShard.recoverySource();
        }
                    }
                                clusterSettings
                        // cluster is remote store enabled or user have restricted a specific replication type in the
                        for (Map.Entry<ShardId, ShardRestoreStatus> shard : updates.entrySet()) {
            clusterService.addStateApplier(this);
                    .collect(Collectors.toSet());
                            }
                Map<String, DataStream> dataStreams;
                    }
                    ) {
                requestIndices.removeAll(dataStreams.keySet());
            if (status.state() == RestoreInProgress.State.FAILURE) {
                        int missingSizeCount = 0;
                                        && DataStreamMetadata.TYPE.equals(cursor.getKey()) == false) {
                        Set<String> aliases = new HashSet<>();
                        checkAliasNameConflicts(indices, aliases);
                                    createIndexService.validateDotIndex(renamedIndexName, isHidden);
                        // Updating cluster state
    ) {
                return true;
        }
                                    + "File cache validation will use available data only.",
                        if (completed(shards)) {
                                indexMdBuilder.putAlias(transformedAlias);
        }
                            if (shardSize != null) {
            // Read snapshot info and metadata from the repository
                        return restoreSnapshotTaskKey;
import org.opensearch.common.settings.ClusterSettings;
                            dataStreams.values()
                                        Math.max(snapshotIndexMetadata.getSettingsVersion(), 1 + currentIndexMetadata.getSettingsVersion())
                assert completed(entry.shards()) : "state says completed but restore entries are not";
            if (failedShard.primary() && failedShard.initializing()) {
                        return false;
                                        indexMdBuilder.removeAllAliases();
                );
 * which removes {@link RestoreInProgress} when all shards are completed. Once that removal is published, every
        this.allocationService = allocationService;
        List<String> filteredIndices,
                            settingsBuilder,
                        Map<String, DataStream> updatedDataStreams = new HashMap<>(currentState.metadata().dataStreams());
                            );
        for (String ignoredSetting : internalIgnoreSettings) {
                                            new ShardId(renamedIndex, shard),
                for (String pattern : userSimpleMatchPatterns) {
                });
                                null,
                                        applyAliasesWithRename(snapshotIndexMetadata.getAliases(), request, indexMdBuilder, aliases);
            }
    public static class RestoreInProgressUpdater extends RoutingChangesObserver.AbstractRoutingChangesObserver {
                                } else {
        for (RestoreInProgress.Entry entry : event.state().custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY)) {
                    private String[] getIgnoreSettingsInternal() {
                                        );
    }
                    requestIndices.toArray(new String[0]),
                                    snapshotInfo.isRemoteStoreIndexShallowCopyEnabled()
            repositoryDataListener.whenComplete(repositoryData -> {
                                        snapshotIndexMetadata.getSettings(),
    }
                                        .index(renamedIndexName);
                                routings.size()
    ) {
            for (RestoreInProgress.Entry entry : event.previousState().custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY)) {
            }
                            );
                                }
        }
    static Set<String> getUserUnremovableSettings() {
import org.opensearch.core.index.Index;
 *
        this.indexScopedSettings = createIndexService.getIndexScopedSettings();
                    private IndexMetadata updateIndexSettings(
                            && clusterService.state().getMetadata().getIndexSafe(shardRouting.index()).isRemoteSnapshot();
            renamedIndex = index.replaceAll(request.renamePattern(), request.renameReplacement());
 * the Apache License, Version 2.0 (the "License"); you may
                    private void checkAliasNameConflicts(Map<String, String> renamedIndices, Set<String> aliases) {
                        return request.clusterManagerNodeTimeout();
                        if (request.includeGlobalState()) {
            for (String pattern : internalSimpleMatchPatterns) {
                        if (totalRestoredRemoteIndicesSize + totalRestorableRemoteIndexesSize > remoteDataToFileCacheRatio
         */
                                    createIndexService.validateIndexName(renamedIndexName, currentState);
        newHashSet(SETTING_REMOTE_STORE_ENABLED, SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY)
import org.opensearch.indices.IndicesService;
                                Set<Integer> ignoreShards = new HashSet<>();
                                failedShard.currentNodeId(),
            }
                new Snapshot(repository, snapshotInfo.snapshotId()),
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_ID_NAME.getKey(), snapshot.getSnapshotId().getName())
                                Collections.unmodifiableList(new ArrayList<>(indices.keySet())),
                                            )
            return oldRestore;
                    private void populateIgnoredShards(String index, final Set<Integer> ignoreShards) {
                        Predicate<String> settingsFilter = createSettingsFilterPredicate(
                                    );
                .isHidden(aliasMd.isHidden())
            final String repositoryName = request.repository();
                                "cannot restore a snapshot while a snapshot deletion is in-progress ["
                            );
            updatedDataStreams.put(streamName, currentDs.addBackingIndex(restoredIndexMetadata.getIndex()));
    static String[] getIgnoreSettingsInternal(Settings nodeSettings) {
                                } catch (Exception ex) {
            }
                                settingsBuilder,
                            String.join(",", request.indices())
        }
 * not use this file except in compliance with the License.
                            if (metadata.customs() != null) {
                                            new ShardId(renamedIndex, shard),
                    + SETTING_REPLICATION_TYPE
                userKeyFilters.add(ignoredSetting);
                                    blocks.updateBlocks(updatedIndexMetadata);
            } else {
            }
import org.opensearch.common.Priority;
                    @Override
            // Check internal ignore patterns first (they override protection)
                    }
        this.metadataIndexUpgradeService = metadataIndexUpgradeService;
                    + ReplicationType.DOCUMENT
        this.dataToFileCacheSizeRatioSupplier = dataToFileCacheSizeRatioSupplier;
                                        Math.max(snapshotIndexMetadata.getAliasesVersion(), 1 + currentIndexMetadata.getAliasesVersion())
        if (hasFailed) {
                                        ex
                                        if (!snapshotIndexMetadata.getAliases().isEmpty()) {
        public ClusterTasksResult<Task> execute(final ClusterState currentState, final List<Task> tasks) {
            this.uuid = uuid;
                    }
import org.apache.logging.log4j.Logger;
                            );
                        builder.add(new RestoreInProgress.Entry(entry.uuid(), entry.snapshot(), newState, entry.indices(), shards));
        }
        private final Map<String, Map<ShardId, ShardRestoreStatus>> shardChanges = new HashMap<>();
                    ClusterStateTaskConfig.build(Priority.URGENT),
                                final Index renamedIndex;
                                aliases.add(transformedAlias.alias());
            throw new SnapshotRestoreException(
        try {
                                        // Don't restore repositories while we are working with them
                            );
                                    for (int shard = 0; shard < snapshotIndexMetadata.getNumberOfShards(); shard++) {
                internalKeyFilters.add(ignoredSetting);
                            );
 */
                                        "cannot restore index [" + index + "] because it cannot be upgraded",
            logger.warn("Failed to update restore state ", t);
            this.restoreInfo = restoreInfo;
 * At the end of the successful restore process {@code RestoreService} calls {@link #cleanupRestoreState(ClusterChangedEvent)},
                        RestoreSnapshotRequest request,
                        if (currentIndexMetadata.getNumberOfShards() != snapshotIndexMetadata.getNumberOfShards()) {
                final List<String> indicesInSnapshot = filterIndices(
     * The remote data attribute check (segment/translog repositories) is used rather than the
 * restore failure a normal recovery fail-over process kicks in.
                );
        for (RestoreInProgress.Entry entry : currentState.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY)) {
                    "indices [" + index + "] and [" + previousIndex + "] are renamed into the same index [" + renamedIndex + "]"
                }
                        IndexMetadata.Builder builder = IndexMetadata.builder(indexMetadata);
        } catch (Exception e) {
        public Snapshot getSnapshot() {
                            }
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
                    metadataBuilder = Metadata.builder();
                                    MetadataCreateIndexService.validateRefreshIntervalSettings(
    private final AllocationService allocationService;
    }
                                    + "] shards from a snapshot of index ["
                    request.repository(),
            Repository repository = repositoriesService.repository(repositoryName);
    static void validateReplicationTypeRestoreSettings(Snapshot snapshot, String snapshotReplicationType, IndexMetadata updatedMetadata) {
    /**
                            if (index.equals(failure.index())) {
                                                clusterService.state().nodes().getLocalNodeId(),
        }
                                    isRemoteStoreShallowCopy,
                            throw new SnapshotRestoreException(
 * this file be licensed under the Apache-2.0 license or a
            }
        }
                    if (unassignedInfo.getFailure() != null && Lucene.isCorruptionException(unassignedInfo.getFailure().getCause())) {
            final RestoreInProgress current = event.state().custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY);
 * The OpenSearch Contributors require contributions made to
                                    );
                .searchRouting(aliasMd.searchRouting())
     * Checks that snapshots can be restored and have compatible version
                }
                                .collect(Collectors.toMap(DataStream::getName, Function.identity()))
                        if (RemoteStoreNodeAttribute.isRemoteStoreAttributePresent(clusterService.getSettings())
        boolean hasFailed = false;
public class RestoreService implements ClusterStateApplier {
                                        Settings.builder()
                                    restoreUUID,
                                    indexMdBuilder.version(
                    private void validateExistingIndex(
        }
                                }
                            return;
    /**
            }
    @Override
                    )
            if (!protectedSettings.contains(k)) {
                    .flatMap(ds -> ds.getIndices().stream())
                                        snapshotIndexMetadata,
                                            + index
     * @param listener restore listener
            return resultBuilder.build(ClusterState.builder(currentState).customs(customs).build());
        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards
                new Snapshot(repository, snapshotInfo.snapshotId()),
                return builder.build();
        unremovable.add(SETTING_VERSION_UPGRADED);
                                snapshot,
                    "clean up snapshot restore state",
import java.util.stream.Collectors;
                    RestoreInfo restoreInfo = null;
                        unassignedShard.shardId(),
    private static RestoreInProgress.State overallState(
    }
                                    // Make sure that the index we are about to create has valid name
                            settingsBuilder.put(overrideSettingsInternal).normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX);
                                    + NODE_SEARCH_CACHE_SIZE_SETTING.getKey()
        @Override
                                    IndexMetadata.Builder indexMdBuilder = IndexMetadata.builder(snapshotIndexMetadata)
                                    );
                        if (missingSizeCount > 0) {
                }
                "the snapshot was created with OpenSearch version ["
                                validateReplicationTypeRestoreSettings(
                    "cannot restore remote snapshot with index settings \"index.store.type\" set to \"remote_snapshot\". Instead use \"storage_type\": \"remote_snapshot\" as argument to restore."
            Map<ShardId, ShardRestoreStatus> shardsBuilder = null;
            if (previousIndex != null) {
                    + Version.CURRENT
                    metadataBuilder.put(repository.getSnapshotIndexMetaData(repositoryData, snapshotId, indexId), false);
     * Updates based on restore progress
     * @opensearch.internal
        public void onFailure(final String source, final Exception e) {
                                    }
                                protectedSettings.add(key);
                                    snapshot,
                                indexMdBuilder.removeAlias(currentAliasName);
            }
                            if (aliases.contains(renamedIndex.getKey())) {
        public void clusterStatePublished(ClusterChangedEvent event) {
        // Process user ignore settings
        this.cleanRestoreStateTaskExecutor = new CleanRestoreStateTaskExecutor(
                                        IndexShardSnapshotStatus.Copy shardStatus = repository.getShardSnapshotStatus(
    }
                                    + "] with ["
    }
                                    } else {
    public static RestoreInProgress updateRestoreStateWithDeletedIndices(RestoreInProgress oldRestore, Set<Index> deletedIndices) {
                }
        }
                     */
    static AliasMetadata applyAliasWriteIndexPolicy(AliasMetadata aliasMd, RestoreSnapshotRequest.AliasWriteIndexPolicy policy) {
            if (currentDs.getIndices().contains(restoredIndexMetadata.getIndex())) {
                        );
                e
                                    rtBuilder.addAsRestore(updatedIndexMetadata, recoverySource);
            .build();
                                String newAliasName = renameAliasPattern.matcher(currentAliasName)
                        "snapshot UUID mismatch: expected [" + request.snapshotUuid() + "] but got [" + snapshotId.getUUID() + "]"
                                    }
     */
                        String renamedIndex,
                        );
                        return settingsBuilder.build();
                                    }
                                        snapshot,
                                restoreUUID,
     *
import java.util.regex.Pattern;
                    + SETTING_REPLICATION_TYPE
                    request.indicesOptions()
                        } else {
        RestoreInProgress.Builder builder = new RestoreInProgress.Builder();
 * software distributed under the License is distributed on an
                            } else {
     * @param protectedSettings set of settings that user cannot remove
    private final CleanRestoreStateTaskExecutor cleanRestoreStateTaskExecutor;
                        listener.onFailure(e);
import org.opensearch.cluster.block.ClusterBlocks;
                            .normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX)
                                    validateExistingIndex(currentIndexMetadata, snapshotIndexMetadata, renamedIndexName, partial);
import org.opensearch.cluster.metadata.DataStreamMetadata;
                        logger.warn(() -> new ParameterizedMessage("[{}] failed to restore snapshot", snapshotId), e);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
                            .put(normalizedChangeSettings.filter(k -> {
import org.opensearch.common.UUIDs;
import org.opensearch.cluster.metadata.IndexMetadata;
                                    if (!ignoreShards.contains(shard)) {
                        "recovery source type changed from snapshot to " + initializedShard.recoverySource()
                        // Build combined protected settings set including dynamic unmodifiable settings
                                            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
                    public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                            .sum();
            new RestoreCompletionNotifier(threadPool, restoreListenerPlugins)::restoreCompleted
         * tasks in one batch asked to clean up is reported once.
                    }
    private static final Set<String> USER_UNMODIFIABLE_SETTINGS = unmodifiableSet(
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
            // Check user ignore patterns only for non-protected settings
                            protectedSettings
            return snapshot;
                            if (indexScopedSettings.isUnmodifiableOnRestoreSetting(key)) {
 */
                    changed = true;
                        Settings settings = indexMetadata.getSettings();
                requestIndices.addAll(dataStreamIndices);
        for (final RestoreInProgress.ShardRestoreStatus status : shards.values()) {
    private final Supplier<Double> dataToFileCacheSizeRatioSupplier;
                                Collections.unmodifiableList(new ArrayList<>(indices.keySet())),
                            SnapshotDeletionsInProgress.EMPTY
                                    createIndexService.validateIndexSettings(renamedIndexName, snapshotIndexMetadata.getSettings(), false);
                } else {
                                return true;
                                    "cannot rename index ["
                        if (isRemoteSnapshot) {
                                if (isSearchableSnapshot && isRemoteStoreShallowCopy) {
     * @param nodeSettings the node settings of the cluster performing the restore
                                    + "] with ["
                        }
        /**
     *
                if (deletedIndices.contains(shardId.getIndex())) {
                                        snapshot,
                        snapshotName,
import org.apache.logging.log4j.message.ParameterizedMessage;
            }
        Supplier<ClusterInfo> clusterInfoSupplier,
                                    );
                    @Override
                throw new SnapshotRestoreException(
            } else {
    ) {
 * <p>
                                    if (!request.includeAliases() && !snapshotIndexMetadata.getAliases().isEmpty()) {
        }
    private void cleanupRestoreState(ClusterChangedEvent event) {
                                    + " setting."
        ClusterService clusterService,
                        Set<String> aliases
                    .map(Index::getName)
            if (shardsBuilder != null) {
        return state.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY).get(restoreUUID);
        for (RestoreInProgress.Entry entry : oldRestore) {
                        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        RoutingTable.Builder rtBuilder = RoutingTable.builder(currentState.routingTable());
                            for (Map.Entry<String, String> indexEntry : indices.entrySet()) {
                            ignoreSettings,
        this.clusterService = clusterService;
        int restoreNumberOfSearchReplicas = updatedMetadata.getSettings().getAsInt(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0);
         * Reports each restore this publication removed. Core now considers it finished: this is the same point at which
                        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards;
            if (partOfDataStream) {
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_ID_UUID.getKey(), snapshot.getSnapshotId().getUUID())
                                    throw new SnapshotRestoreException(
        }
     *
                                        /// Add existing aliases
                                    }
                                if (isRemoteSnapshot) {
                        entry.uuid(),
import java.util.function.Function;
                                snapshot,
        ThreadPool threadPool,
        public void shardFailed(ShardRouting failedShard, UnassignedInfo unassignedInfo) {
            IndexMetadata restoredIndexMetadata = metadata.get(restoredIndexName);
                }
                        // remote store settings needs to be overridden if the remote store feature is enabled in the
        }
import org.opensearch.cluster.SnapshotDeletionsInProgress;
        unremovable.add(SETTING_NUMBER_OF_REPLICAS);
                        entry.indices(),
        return IndexMetadata.builder(metadata).settings(newSettings).build();
                                    overrideSettingsInternal,
                    new RestoreInProgress.Entry(
                                        + renamedIndex.getKey()
         * if such an entry does not exist yet.
                                boolean partial = checkPartial(index);
                .filter(aliasMd.filter())
        if (false == RemoteStoreNodeAttribute.isRemoteDataAttributePresent(nodeSettings)) {
                                    + currentIndexMetadata.getNumberOfShards()
                                    snapshot,
                            clusterSettings,
        }
            .put(metadata.getSettings())
                    + snapshotReplicationType
        List<String> internalSimpleMatchPatterns = new ArrayList<>();
        List<Index> updatedIndices = dataStream.getIndices()
            return AliasMetadata.builder(aliasMd.alias())
import static java.util.Collections.unmodifiableSet;
 * @opensearch.internal
                            clusterService.state(),
import org.opensearch.common.settings.Settings;
                                    snapshotInfo.getPinnedTimestamp()
                        Metadata.Builder mdBuilder = Metadata.builder(currentState.metadata());
                for (RestoreInProgress.Entry entry : oldRestore) {
                                        snapshot,
 *    http://www.apache.org/licenses/LICENSE-2.0
        public RestoreInProgress applyChanges(final RestoreInProgress oldRestore) {
import org.opensearch.cluster.routing.RoutingChangesObserver;
                clusterService.submitStateUpdateTask("restore_snapshot[" + snapshotName + ']', new ClusterStateUpdateTask() {
                            }
                        }
                            || clusterSettings.get(IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING)
                                        "cannot modify UnmodifiableOnRestore setting [" + k + "] on restore"
                    }
                        Settings overrideSettings,
                        }
            final Map<String, ClusterState.Custom> customs = Collections.unmodifiableMap(builder);
    private static final Logger logger = LogManager.getLogger(RestoreService.class);
                "the snapshot has an unknown or unsupported version and cannot be restored"
 *
            logger.error(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);
        RepositoriesService repositoriesService,
            for (final Map.Entry<ShardId, ShardRestoreStatus> cursor : entry.shards().entrySet()) {
                                AliasMetadata transformedAlias = applyAliasWriteIndexPolicy(renamedAlias, request.aliasWriteIndexPolicy());
                                    .getMaxNodeVersion()
                if (matchingSnapshotId.isPresent() == false) {
                                }
            throw new SnapshotRestoreException(
                                        mdBuilder.putCustom(cursor.getKey(), cursor.getValue());
                                );
                );
                                snapshot,
                        }
                            }
            }
        }
                                indexMdBuilder.removeAlias(alias.getKey());
        } else {
        return aliasMd;
                        }
                && initializedShard.recoverySource().getType() != RecoverySource.Type.SNAPSHOT) {
                            ignoreSettingsInternal,
        }
        return false;
            public String toString() {
        for (String ignoredSetting : userIgnoreSettings) {
                            builder.putCustom(
                    snapshotInfo.dataStreams(),
                    request.repository(),
            );
                                for (final IndexTemplateMetadata cursor : metadata.templates().values()) {
                            );
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
     * <p>
                        changes(recoverySource).put(
                                AliasMetadata transformedAlias = applyAliasWriteIndexPolicy(
     * Returns the set of settings that users cannot remove during restore.
                                "Size of the indexes to be restored exceeds the file cache bounds. Increase the file cache capacity on the cluster nodes using "
 * to be restored and adds this shard to the routing table using
                        boolean partial
        String dataStreamName = dataStream.getName();
                            return false;
                                    if (partial) {
    private final Supplier<ClusterInfo> clusterInfoSupplier;
                                ) && metadata.index(index).getSettings().getAsBoolean(SETTING_REMOTE_STORE_ENABLED, false);
                                shards.size(),
     */
                                indexMdBuilder.putAlias(transformedAlias);
                }
                );
                                    snapshotIndexMetadata
 * <p>
        if (request.renameReplacement() != null && request.renamePattern() != null) {
    public void restoreSnapshot(final RestoreSnapshotRequest request, final ActionListener<RestoreCompletionResponse> listener) {
                    );
            if (entry.state().completed()) {
import org.opensearch.cluster.node.DiscoveryNode;
    /**
                        if (partial) {
/*
                        }
                                    );
 * Licensed to Elasticsearch under one or more contributor
                    + SETTING_NUMBER_OF_SEARCH_REPLICAS
                                        }
     * onto a cluster that does not store index data remotely.
    }
                    }
                                final Settings overrideSettingsInternal = getOverrideSettingsInternal();
                                        snapshot,
                                    mdBuilder.put(cursor);
            DataStream currentDs = updatedDataStreams.get(streamName);
                            throw new SnapshotRestoreException(
                                    mdBuilder.put(updatedIndexMetadata, true);
                        long totalNodeFileCacheSize = clusterInfo.getNodeFileCacheStats()
        boolean changesMade = false;
    private static final String REMOTE_STORE_INDEX_SETTINGS_REGEX = "index.remote_store.*";
                            if (status == null || status.state().completed() == false) {
                                    isSearchableSnapshot,
                }
                                        for (final AliasMetadata alias : currentIndexMetadata.getAliases().values()) {
                );
                                    throw new SnapshotRestoreException(
                        new ShardRestoreStatus(initializingShard.currentNodeId(), RestoreInProgress.State.SUCCESS)
                throw new SnapshotRestoreException(
            String previousIndex = renamedIndices.put(renamedIndex, index);
 * method reads information about snapshot and metadata from repository. In update cluster state task it checks restore
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
            if (index.equals(failure.index())) {
                            }
            if (status.state().completed() == false) {
        public void shardInitialized(ShardRouting unassignedShard, ShardRouting initializedShard) {
    static DataStream updateDataStream(DataStream dataStream, Metadata.Builder metadata, RestoreSnapshotRequest request) {
import org.opensearch.cluster.RestoreInProgress;
import org.opensearch.common.unit.TimeValue;
 * <p>
     */
                                unassignedInfo.getFailure().getCause().getMessage()
    }
     */
                                        shardsBuilder.put(
    public static RestoreInProgress.Entry restoreInProgress(ClusterState state, String restoreUUID) {
 * {@link IndexShard#restoreFromRepository} )}
            // if we force an empty primary, we should also fail the restore entry
                        IndexMetadata indexMetadata,
                        builder.add(entry);
            }
    }
                        }
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
                                        );
        return true;
                                    }
                                    indexMdBuilder.settings(
 * compatible open source license.
            }
        final Set<Index> indices = new HashSet<>();
     * Exposed for testing purposes.
                                    // Index exists and it's closed - open it in metadata and start recovery
                                    + "] shards"
import org.opensearch.cluster.routing.ShardRouting;
        if (policy == RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX && Boolean.TRUE.equals(aliasMd.writeIndex())) {
            );
                            Map<ShardId, RestoreInProgress.ShardRestoreStatus> shardsBuilder = new HashMap<>();
    }
                                    "index [" + index + "] wasn't fully snapshotted - cannot " + "restore"
    private final ClusterService clusterService;
                                shards.size() - failedShards(shards)
                            ShardRestoreStatus status = shardStates.get(shardId);
                        shardsBuilder = new HashMap<>(entry.shards());
            }
                return "clean restore state for restore " + uuid;
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
                                // TODO: Should all existing templates be deleted first?
            throw new SnapshotRestoreException(
                        }
        public String getUuid() {
                        // override internal settings
                                        totalRestorableRemoteIndexesSize += shardStatus.getTotalSize();
                        // Restore global state if needed
                            new ShardRestoreStatus(
            );
                        if (nodeFileCacheStats.isEmpty() || remoteDataToFileCacheRatio <= 0.01f) {
 * KIND, either express or implied.  See the License for the
        for (String index : filteredIndices) {
                                );
            .collect(Collectors.toList());
import org.opensearch.repositories.RepositoriesService;
        MetadataIndexUpgradeService metadataIndexUpgradeService,
                                    indexSettingsBuilder.put(SETTING_HISTORY_UUID, UUIDs.randomBase64UUID());
import org.opensearch.cluster.metadata.RepositoriesMetadata;
                    // to restore this shard on another node if the snapshot files are corrupt. In case where a node just left or crashed,
        for (String restoredIndexName : restoredIndexNames) {
                                    indexMdBuilder.settingsVersion(
        Map<String, DataStream> updatedDataStreams
    private static Map<String, String> renamedIndices(
        // Process internal ignore settings
                            MetadataCreateIndexService.updateReplicationStrategy(
                Metadata globalMetadata = null;
                    public TimeValue timeout() {
     * Internal ignore patterns override protection and can filter any setting.
                builder.add(
        this.shardLimitValidator = shardLimitValidator;
                                ).build()
                                        .put(snapshotIndexMetadata.getSettings())
                                        .state(IndexMetadata.State.OPEN)
                                            new RestoreInProgress.ShardRestoreStatus(
                                        Math.max(snapshotIndexMetadata.getMappingVersion(), 1 + currentIndexMetadata.getMappingVersion())
import org.opensearch.cluster.ClusterState;
                        updatedDataStreams.putAll(
        Set<String> userKeyFilters = new HashSet<>();
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_REPOSITORY.getKey(), snapshot.getRepository())
        }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_UPGRADED;
                    && currentState.getMetadata().index(index) != null) {
            } else {
                            RestoreInProgress.Entry restoreEntry = new RestoreInProgress.Entry(
/*
                                    + snapshotIndexMetadata.getNumberOfShards()
            if (unassignedShard.recoverySource().getType() == RecoverySource.Type.SNAPSHOT
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
                }
                                    boolean isHidden = IndexMetadata.INDEX_HIDDEN_SETTING.get(snapshotIndexMetadata.getSettings());
                            }
                                    renamedIndex = updatedIndexMetadata.getIndex();
                        // Make sure that the number of shards is the same. That's the only thing that we cannot change
                                if (isRemoteStoreShallowCopy && !currentState.getNodes().getMinNodeVersion().onOrAfter(Version.V_2_9_0)) {
    }
     */
        private final Consumer<RestoreInProgress.Entry> onRestoreCompleted;
                    throw new SnapshotRestoreException(
        public void shardStarted(ShardRouting initializingShard, ShardRouting startedShard) {
            // mark snapshot as completed
                    }
                    // however, we only want to acknowledge the restore operation once it has been successfully restored on another node.
import java.util.ArrayList;
                internalSimpleMatchPatterns.add(ignoredSetting);
 */
                                    }
import java.util.Optional;
import org.opensearch.cluster.ClusterInfo;
 * method, which detects that shard should be restored from snapshot rather than recovered from gateway by looking
                                            + "] as some of the nodes in cluster have version less than 2.9"
        }
                                );
            }
                            throw new SnapshotRestoreException(
        RestoreSnapshotRequest request,
                                        // Remove all snapshot aliases
            if (!Regex.isSimpleMatchPattern(ignoredSetting)) {
                        for (SnapshotShardFailure failure : snapshotInfo.shardFailures()) {
        Set<String> protectedSettings
                    if (shardsBuilder == null) {
                                    + "] because an open index "
            @Override
    private final IndicesService indicesService;
        List<RestoreListenerPlugin> restoreListenerPlugins
    }
                List<String> requestIndices = new ArrayList<>(Arrays.asList(request.indices()));
                                        renamedIndexName,
        Map<String, String> renamedIndices = new HashMap<>();
                if (newUnassignedInfo.getLastAllocationStatus() == UnassignedInfo.AllocationStatus.DECIDERS_NO) {
     * @param userIgnoreSettings array of user-provided settings to ignore
import org.opensearch.common.regex.Regex;
                                    snapshot,
                final Metadata metadata = metadataBuilder.build();
                            }
                        IndexMetadata snapshotIndexMetadata,
                        overallState(RestoreInProgress.State.STARTED, shards),
     * Attaches each restored {@code .ds-<streamName>-NNNNNN} index to a pre-existing data stream of the same name, in
            Set<String> completedRestores = tasks.stream().map(e -> e.uuid).collect(Collectors.toSet());
import org.opensearch.common.settings.IndexScopedSettings;
    private static final Set<String> USER_UNREMOVABLE_SETTINGS;
                     * Optionally updates index settings in indexMetadata by removing settings listed in ignoreSettings and
                                    + "with same name already exists in the cluster. Either close or delete the existing index or restore the "
                        }
                                } else if (indexScopedSettings.isUnmodifiableOnRestoreSetting(k)) {
                        } else {
        };
                        // remote store related index settings present in the snapshot.
            if (recoverySource.getType() == RecoverySource.Type.SNAPSHOT) {
        if (DiscoveryNode.isClusterManagerNode(clusterService.getSettings())) {
 * specific language governing permissions and limitations
                // Now we can start the actual restore process by adding shards to be recovered in the cluster state
        unremovable.addAll(USER_UNMODIFIABLE_SETTINGS);
                                    );
    }
        Set<String> restoredIndexNames,
                    }
                                            indexMdBuilder.removeAllAliases();
        CleanRestoreStateTaskExecutor(Consumer<RestoreInProgress.Entry> onRestoreCompleted) {
                Index index = shard.getKey().getIndex();
            String renamedIndex = renameIndex(index, request, dataStreamIndices.contains(index));
                        Set<String> protectedSettings = new HashSet<>(USER_UNREMOVABLE_SETTINGS);
     * Package-private for testing.
                                clusterSettings.validateUpdate(settings);
                            if (metadata.templates() != null) {
        if (snapshotInfo.version() == null) {
                                .stream()
                continue;
        MetadataCreateIndexService createIndexService,
            Task(String uuid) {
            repository.getRepositoryData(repositoryDataListener);
        }
                                snapshot,
            partOfDataStream = partOfDataStream && index.startsWith(DataStream.BACKING_INDEX_PREFIX);
        RestoreInProgress.State nonCompletedState,
                    for (String requestedDataStream : requestedDataStreams) {
        @Override
                                    request.aliasWriteIndexPolicy()
    }
        IndicesService indicesService,
                        } else {
     * broader remote store attribute check, because clusters with only remote cluster state or
                                snapshotId.getName(),
                            clusterService.getSettings(),
                if (entry.state().completed() && current.get(entry.uuid()) == null) {
 * Modifications Copyright OpenSearch Contributors. See
        return indices;
                userSimpleMatchPatterns.add(ignoredSetting);
                    } else {
                "unsupported snapshot state [" + snapshotInfo.state() + "]"
                            );
                return nonCompletedState;
            indexSettingsToBeIgnored = ArrayUtils.concat(indexSettingsToBeIgnored, new String[] { REMOTE_STORE_INDEX_SETTINGS_REGEX });
     *
                            throw new ConcurrentSnapshotExecutionException(
                List<String> requestedDataStreams = filterIndices(
    );
                                snapshot,
    }
                                    request.getSourceRemoteStoreRepository(),
                                            .put(snapshotIndexMetadata.getSettings())
                                final String[] ignoreSettingsInternal = getIgnoreSettingsInternal();
                        globalMetadata = repository.getSnapshotGlobalMetadata(snapshotId);
/*
                    + "]"
                                } else if (indexScopedSettings.isUnmodifiableOnRestoreSetting(ignoredSetting)) {
        if (!snapshotInfo.state().restorable()) {
                        for (Map.Entry<String, String> renamedIndex : renamedIndices.entrySet()) {
                                overallState(RestoreInProgress.State.INIT, shards),
                                    throw new SnapshotRestoreException(
        for (SnapshotShardFailure failure : snapshot.shardFailures()) {
            }
 *
            throw new SnapshotRestoreException(
                .indexRouting(aliasMd.indexRouting())
            }
                                    } else {
                        if (deletionsInProgress.getEntries().stream().anyMatch(entry -> entry.getSnapshots().contains(snapshotId))) {
                                        .put(IndexMetadata.SETTING_INDEX_UUID, currentIndexMetadata.getIndexUUID());
                            } else {
 * at the {@link ShardRouting#recoverySource()} property.
                                    if (isRemoteSnapshot) {
                                }
                    snapshotInfo.indices(),
                        if (overrideSettingsInternal != null) {
                                if (USER_UNREMOVABLE_SETTINGS.contains(ignoredSetting)) {
                                "cannot disable setting [" + IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey() + "] on restore"
                if (Regex.simpleMatch(pattern, k)) {
                                "cannot restore partial index [" + renamedIndex + "] because such index already exists"
                        );
                                }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
import java.util.function.Predicate;
     * the same cluster-state update as the restore. Adding the index and advancing the generation together avoids the
                            throw new SnapshotRestoreException(
        Metadata.Builder metadata,
     * Returns the internal index settings to be ignored (stripped) when restoring a snapshot
                    cleanRestoreStateTaskExecutor,
                ShardId shardId = cursor.getKey();
                                shards
                                    snapshot,
                                    indexMdBuilder.mappingVersion(
                builder.add(entry);
                            Long shardSize = clusterInfo.getShardSize(shardRouting);
        String[] internalIgnoreSettings,
                                    );
                                            snapshotInfo,
            dataStreamName = dataStreamName.replaceAll(request.renamePattern(), request.renameReplacement());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
                        settingsBuilder.remove(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey());
                                final boolean isSearchableSnapshot = snapshotIndexMetadata.isRemoteSnapshot();
                        Settings overrideSettingsInternal,
import org.opensearch.cluster.ClusterStateUpdateTask;
                            validateSearchableSnapshotRestorable(totalRestorableRemoteIndexesSize);
 *
                            .build();
 */
                                );
                    final String restoreUUID = UUIDs.randomBase64UUID();
     * Apply alias write index policy to transform alias metadata during restore.
import org.opensearch.cluster.metadata.Metadata;
                        // Check if the snapshot to restore is currently being deleted
                                    .minimumIndexCompatibilityVersion();
                            }
                            .put(settings.filter(settingsFilter))
import static org.opensearch.common.util.IndexUtils.filterIndices;
                                        snapshot,
                    final Map<ShardId, ShardRestoreStatus> shardStates = entry.shards();
        private final Snapshot snapshot;
                            .allShardsSatisfyingPredicate(isRemoteSnapshotShard);
                        listener.onResponse(new RestoreCompletionResponse(restoreUUID, snapshot, restoreInfo));
                            );
            // restoring a snapshot and should not be manually set by user.
                    + "]"
                        }
                    indices.add(index);
    /**
                                        shardsBuilder.put(
                                    + renamedIndex
                        SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(
                index = index.substring(DataStream.BACKING_INDEX_PREFIX.length());
                            }
                new Snapshot(repository, snapshotInfo.snapshotId()),
                                        Math.max(snapshotIndexMetadata.getVersion(), 1 + currentIndexMetadata.getVersion())
                    new CleanRestoreStateTaskExecutor.Task(entry.uuid()),
                    + snapshotInfo.version()
                    && shard.getValue().state().completed() == false
                     * merging them with settings in changeSettings.
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    public static boolean completed(final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards) {
                            // TODO: Enable restore for open indices
                                    );
                                    );
         * a restore request that waits for completion returns. Called once per published state, so a restore that several
    }
                                request.indexSettings(),
                                final boolean isRemoteStoreShallowCopy = Boolean.TRUE.equals(
            }
        try {
                                final Version minIndexCompatibilityVersion = currentState.getNodes()
        USER_UNREMOVABLE_SETTINGS = unmodifiableSet(unremovable);
import org.opensearch.indices.replication.common.ReplicationType;
    }
import org.opensearch.cluster.metadata.DataStream;
                "snapshot was created with ["
                }
            RecoverySource recoverySource = unassignedShard.recoverySource();
        AllocationService allocationService,
            }
            String storeTypeSetting = request.indexSettings().get(INDEX_STORE_TYPE_SETTING.getKey());
        implements
                        long totalRestoredRemoteIndicesSize = 0;
                            )
                                    rtBuilder.addAsNewRestore(updatedIndexMetadata, recoverySource, ignoreShards);
                    request.snapshot(),
                            ShardId shardId = shard.getKey();
                        // Make sure that index was fully snapshotted
        int failedShards = 0;
    private final ShardLimitValidator shardLimitValidator;
    static {
                        RoutingTable rt = rtBuilder.build();
                validateSnapshotRestorable(repositoryName, snapshotInfo);
                                throw new SnapshotRestoreException(
                }
                final Map<String, String> indices = renamedIndices(request, indicesInSnapshot, dataStreamIndices);
                            restoreInfo = new RestoreInfo(
                    }
                    onRestoreCompleted.accept(entry);
import java.util.function.Supplier;
                        ClusterState updatedState = builder.metadata(mdBuilder).blocks(blocks).routingTable(rt).build();
 * You may obtain a copy of the License at
        /**
                return false;
     * routing table publication enabled do not store index data remotely and must still have
                            }
                    new ShardRestoreStatus(
    public static Set<Index> restoringIndices(final ClusterState currentState, final Set<Index> indicesToCheck) {
        public RestoreInfo getRestoreInfo() {
        String[] userIgnoreSettings,
                                final SnapshotRecoverySource recoverySource = new SnapshotRecoverySource(
                                        + "] because of conflict with an alias with the same name"
            if (partOfDataStream) {
                                        "cannot restore shallow copy snapshot for index ["
                // the key is the renamed index and the value is the original name
            .stream()
import org.opensearch.threadpool.ThreadPool;
                continue;
        ShardLimitValidator shardLimitValidator,
                                mdBuilder.persistentSettings(settings);
            return RestoreInProgress.State.FAILURE;
                                    );
                        // cluster. If cluster is undergoing remote store migration, replication strategy is strictly SEGMENT type
                    metadataBuilder = Metadata.builder(globalMetadata);
        @Override
     */
                for (IndexId indexId : indexIdsInSnapshot) {
                                    IndexMetadata updatedIndexMetadata = indexMdBuilder.build();
                        null,
import org.opensearch.repositories.Repository;
                return false;
                        Settings.Builder settingsBuilder = Settings.builder()
                        mdBuilder.dataStreams(updatedDataStreams);
import org.opensearch.node.remotestore.RemoteStoreNodeService;
                                    indexMdBuilder.aliasesVersion(
                            }
                changes(unassignedShard.recoverySource()).put(
import org.opensearch.repositories.IndexId;
import java.util.function.Consumer;
                hasFailed = true;
                                        minIndexCompatibilityVersion
     * @opensearch.internal
                final SnapshotId snapshotId = matchingSnapshotId.get();
                    changes(recoverySource).put(
                        final double remoteDataToFileCacheRatio = dataToFileCacheSizeRatioSupplier.get();
                    private void applyAliasesWithRename(
        }
            for (final Map.Entry<ShardId, RestoreInProgress.ShardRestoreStatus> shard : entry.shards().entrySet()) {
                                throw new SnapshotRestoreException(
package org.opensearch.snapshots;
 * ownership. Elasticsearch licenses this file to you under
                        assert dataStreamInSnapshot != null : "DataStream [" + requestedDataStream + "] not found in snapshot";
                            attachRestoredBackingIndices(indices.keySet(), mdBuilder, updatedDataStreams);
    public static final class RestoreCompletionResponse {
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.routing.ShardsIterator;
                    + "]"
            }
        } catch (Exception t) {
        }
    // Visible for testing
        }
                                    .replaceAll(request.renameAliasReplacement());
        @Override
        this.createIndexService = createIndexService;
                                        );
                                RestoreInProgress.State.FAILURE,
                            && IndexSettings.INDEX_SOFT_DELETES_SETTING.get(overrideSettings) == false) {
    private static void validateSnapshotRestorable(final String repository, final SnapshotInfo snapshotInfo) {
                            failedShard.shardId(),
        this.repositoriesService = repositoriesService;
                                String currentAliasName = alias.getKey();
                                        snapshotIndexMetadata.getSettings(),
            final Map<String, ClusterState.Custom> builder = new HashMap<>(currentState.getCustoms());
        }
                        }
                        return allocationService.reroute(updatedState, "restored snapshot [" + snapshot + "]");
                    + " To restore with ["
                                    request.ignoreIndexSettings(),
            }
                    return false;
                            for (final Map.Entry<String, AliasMetadata> alias : snapshotAliases.entrySet()) {
                    @Override
                                try {
                    }
        Set<String> unremovable = new HashSet<>(USER_UNMODIFIABLE_SETTINGS.size() + 3);
                                );
 * {@link RoutingTable.Builder#addAsRestore(IndexMetadata, SnapshotRecoverySource)} method.
                                "Size information unavailable for {} out of {} remote snapshot shards. "
            ClusterStateTaskExecutor<CleanRestoreStateTaskExecutor.Task>,
        this.clusterInfoSupplier = clusterInfoSupplier;
        Set<String> internalKeyFilters = new HashSet<>();
            logger.warn(
import java.util.Map;
    static class CleanRestoreStateTaskExecutor
        if (restoreNumberOfSearchReplicas > 0
                        ClusterState.Builder builder = ClusterState.builder(currentState);
                                    );
                        String[] ignoreSettings,
                    changes(recoverySource).put(
import org.opensearch.cluster.ClusterChangedEvent;
                                    throw new SnapshotRestoreException(snapshot, "cannot modify setting [" + k + "] on restore");
                    requestIndices.toArray(new String[0]),
                                ignoreShards.add(failure.shardId());
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
                        }
        }
    private final IndexScopedSettings indexScopedSettings;
        return renamedIndex;
            this.snapshot = snapshot;
                                    restoreEntry
            }
     * @param snapshotInfo    snapshot metadata
        String[] indexSettingsToBeIgnored = new String[] {};
                                // Check that the index is closed or doesn't exist
                        RestoreInProgress.State newState = overallState(RestoreInProgress.State.STARTED, shards);
 * preconditions, restores global state if needed, creates {@link RestoreInProgress} record with list of shards that needs
                                    // Index doesn't exist - create it and start recovery
                    );
    private static String renameIndex(String index, RestoreSnapshotRequest request, boolean partOfDataStream) {
                RestoreInProgress.Builder builder = new RestoreInProgress.Builder();
                    .stream()
            if (internalKeyFilters.contains(k)) {
                                        indexMdBuilder.primaryTerm(
        if (request.renamePattern() != null && request.renameReplacement() != null) {
                                    IndexMetadata updatedIndexMetadata = indexMdBuilder.index(renamedIndexName).build();
                            shards = Map.of();
                                    return true;
     *
                        }
        }
            }
            }
                                missingSizeCount++;
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                        ClusterInfo clusterInfo = clusterInfoSupplier.get();
    private final ClusterSettings clusterSettings;
                                IndexId snapshotIndexId = repositoryData.resolveIndexId(index);
        private final RestoreInfo restoreInfo;
                                        populateIgnoredShards(index, ignoreShards);
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    if (globalMetadata == null) {
                                    shardLimitValidator.validateShardLimit(
                            if (metadata.persistentSettings() != null) {
                        initializingShard.shardId(),
        return k -> {
                        }
                        if (request.attachToDataStream()) {
import java.util.List;
    }
import static org.opensearch.node.Node.NODE_SEARCH_CACHE_SIZE_SETTING;
        for (RestoreInProgress.ShardRestoreStatus status : shards.values()) {
                    private void validateSearchableSnapshotRestorable(long totalRestorableRemoteIndexesSize) {
                        // for a domain that does not store index data remotely, we will remove all the
        private Map<ShardId, ShardRestoreStatus> changes(RecoverySource recoverySource) {
                                    metadata.index(index).getSettings().get(SETTING_REPLICATION_TYPE),
            return shardChanges.computeIfAbsent(((SnapshotRecoverySource) recoverySource).restoreUUID(), k -> new HashMap<>());
                                snapshot,
            if (currentDs == null || restoredIndexMetadata == null) {
import org.opensearch.action.StepListener;
                            * totalNodeFileCacheSize) {
                    + "] which is higher than the version of this node ["
                renamedIndex = DataStream.BACKING_INDEX_PREFIX + renamedIndex;
    /**
                                    snapshotIndexMetadata = metadataIndexUpgradeService.upgradeIndexMetadata(
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        return new DataStream(dataStreamName, dataStream.getTimeStampField(), updatedIndices, dataStream.getGeneration());
    /**
                            // We don't have any indices to restore - we are done
                                    }
            }
            return RestoreInProgress.State.SUCCESS;
            if (initializingShard.primary()) {
                cleanupRestoreState(event);
                            for (final Map.Entry<String, AliasMetadata> alias : snapshotAliases.entrySet()) {
                                        clusterSettings
                                }
                );
                        final DataStream dataStreamInSnapshot = dataStreamsInSnapshot.get(requestedDataStream);
        }
                            if (request.partial()) {
    }
 * Unless required by applicable law or agreed to in writing,
                            || RemoteStoreNodeService.isMigratingToRemoteStore(clusterSettings)) {
                        String[] ignoreSettingsInternal
                }
            }, listener::onFailure);
                    )
                                String index = indexEntry.getValue();
                                    throw new SnapshotRestoreException(
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
                        ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
                    globalMetadata = repository.getSnapshotGlobalMetadata(snapshotId);
        this.indicesService = indicesService;
            }
    ) {
                // Resolve the indices from the snapshot that need to be restored
                                    + snapshotIndexMetadata.getIndex().getName()
                                        }
        // Map of RestoreUUID to a of changes to the shards' restore statuses
            // Setting INDEX_STORE_TYPE_SETTING as REMOTE_SNAPSHOT is intended to be a system-managed index setting that is configured when
                if (userKeyFilters.contains(k)) {
                final String snapshotName = request.snapshot();
     *
import org.opensearch.common.lucene.Lucene;
                    }
                    public void onFailure(String source, Exception e) {
                                if (USER_UNMODIFIABLE_SETTINGS.contains(k)) {
            ClusterStateTaskListener {
        }
                if (completedRestores.contains(entry.uuid())) {
     * Returns the indices that are currently being restored and that are contained in the indices-to-check set.
                                        "Shallow copy snapshot cannot be restored as searchable snapshot."
                            );
                                clusterService.getSettings(),
    public RestoreService(
                                    if (RepositoriesMetadata.TYPE.equals(cursor.getKey()) == false
                        }
                            Pattern renameAliasPattern = Pattern.compile(request.renameAliasPattern());
import static org.opensearch.cluster.service.ClusterManagerTask.RESTORE_SNAPSHOT;
        );
                        repositoryName,
                                }
        @Override
                    String reason = "shard could not be allocated to any of the nodes";
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_INDEX_ID.getKey(), indexId.getId())
                snapshot,
        }
                        final Settings.Builder settingsBuilder = Settings.builder();
                if (recoverySource.getType() == RecoverySource.Type.SNAPSHOT) {
                );
                                    );
import java.util.HashSet;
                    + "], ["
                            .mapToLong(Long::longValue)
 * GitHub history for details.
                                aliases.add(transformedAlias.alias());
                    + "] must be set to [0]"
        private final String uuid;
                                    request.getSourceRemoteTranslogRepository(),
                    cleanRestoreStateTaskExecutor
                        dataStreams.put(requestedDataStream, dataStreamInSnapshot);
                                snapshot,
                    .findFirst();
                        new ShardRestoreStatus(unassignedShard.currentNodeId(), RestoreInProgress.State.FAILURE, reason)
    }
                            .stream()
                        if (currentIndexMetadata.getState() != IndexMetadata.State.CLOSE) {
        @Override
                                            indexMdBuilder.putAlias(alias);
                    }
                            // We have some indices to restore
                                    MetadataCreateIndexService.validateRefreshIntervalSettings(cursor.settings(), clusterSettings);
            );
                                    request.indexSettings(),
                        // Index exist - checking that it's closed
                    /**
     * @param repository      repository name
import org.opensearch.common.util.ArrayUtils;
import org.opensearch.index.IndexModule;
 * <p>
                                    + "index under a different name by providing a rename pattern and replacement name"
            if (status.state().completed() == false) {
                            throw new SnapshotRestoreException(
                () -> new ParameterizedMessage("[{}] failed to restore snapshot", request.repository() + ":" + request.snapshot()),
                                RestoreInProgress.TYPE,
                                    indexMdBuilder.settings(indexSettingsBuilder);
import org.opensearch.cluster.routing.RecoverySource;
                            SnapshotDeletionsInProgress.TYPE,
                    }
            boolean changed = false;
                                        ).asCopy();
    ) {
import org.opensearch.cluster.ClusterStateTaskExecutor;
import java.util.Arrays;
                        Map<String, AliasMetadata> snapshotAliases,
    }
                continue;
     */
                        final Map<ShardId, ShardRestoreStatus> shards = Collections.unmodifiableMap(shardsBuilder);
                }
                                    // add a restore uuid
                final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotId);
import org.opensearch.cluster.metadata.MetadataIndexStateService;
                }
            .map(i -> metadata.get(renameIndex(i.getName(), request, true)).getIndex())
                        IndexMetadata currentIndexMetadata,
import org.opensearch.cluster.RestoreInProgress.ShardRestoreStatus;
        public void onNoLongerClusterManager(String source) {
                } else {
                    Map<ShardId, ShardRestoreStatus> updates = shardChanges.get(entry.uuid());
 * First {@link #restoreSnapshot(RestoreSnapshotRequest, ActionListener)}
    }
                        }
                        }
                                totalRestoredRemoteIndicesSize += shardSize;
                        List<ShardRouting> routings = shardsIterator.getShardRoutings();
     * @param request  restore request
            if (changed == false) {
import org.opensearch.cluster.routing.RoutingTable;
                // Make sure that we can restore from this snapshot
                    }
                        Map<String, AggregateFileCacheStats> nodeFileCacheStats = clusterInfo.getNodeFileCacheStats();
            // A backing index must map the timestamp field as a date, or data stream search breaks.
                        Predicate<ShardRouting> isRemoteSnapshotShard = shardRouting -> shardRouting.primary()
        restoreSnapshotTaskKey = clusterService.registerClusterManagerTask(RESTORE_SNAPSHOT, true);
     */
        return Collections.unmodifiableMap(renamedIndices);
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
            }
                                missingSizeCount,
import org.opensearch.action.support.IndicesOptions;
    public void applyClusterState(ClusterChangedEvent event) {
                                new RestoreInProgress.Builder(currentState.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY)).add(
                        Map<ShardId, ShardRestoreStatus> shardsBuilder = new HashMap<>(shardStates);
            if (storeTypeSetting != null && storeTypeSetting.equals(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT.toString())) {
                    + " as ["
                    final Map<String, DataStream> dataStreamsInSnapshot = globalMetadata.dataStreams();
        public RestoreCompletionResponse(final String uuid, final Snapshot snapshot, final RestoreInfo restoreInfo) {
                                }
                                        // TODO: Should we restore them at the end?
        @Override
                                        "cannot remove setting [" + ignoredSetting + "] on restore"
                                        currentState
                    }
        }
                if (request.includeGlobalState()) {
import org.opensearch.core.action.ActionListener;
        }
    }
                // Apply renaming on index names, returning a map of names where
            if (streamName == null) {
        Supplier<Double> dataToFileCacheSizeRatioSupplier,
                                    );
    public static int failedShards(final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards) {
                            .routingTable()
                        // cluster where snapshot is being restored.
            logger.debug("no longer cluster-manager while processing restore state update [{}]", source);
        } else {
        return indexSettingsToBeIgnored;
import org.opensearch.cluster.metadata.AliasMetadata;
                    dataStreams = new HashMap<>(requestedDataStreams.size());
                        );
                                    throw new SnapshotRestoreException(
                                }

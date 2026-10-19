        private final Set<String> runningDeletions = Collections.synchronizedSet(new HashSet<>());
                        changedCount++;
            }
                protected void handleListeners(List<ActionListener<Void>> deleteListeners) {
            updateSnapshotPinnedTimestamp(snapshot, pinnedTimestamp);
        public void onNoLongerClusterManager() {
                    leaveRepoLoop(repositoryName);
                        for (SnapshotsInProgress.Entry entry : finishedSnapshots) {
        public ClusterState execute(ClusterState currentState) {
            if (value.compareTo(TimeValue.timeValueSeconds(1)) < 0) {
            }
                    );
     * @param entry          snapshot entry that failed to finalize
            logger.info(() -> new ParameterizedMessage("Failed to start snapshot clone [{}]", cloneEntry), e);
        }
                // We don't remove old cluster-manager when cluster-manager flips anymore. So, we need to check for change in
        /**
            final String repo = entry.repository();
     *
            final List<SnapshotDeletionsInProgress.Entry> remainingEntries = deletionsInProgress.getEntries();
                            shardSnapshotStatus = new ShardSnapshotStatus(
        validate(repositoryName, snapshotName);
                        final ShardSnapshotStatus existing = entry.shards().get(finishedShardId);
                final ShardGenerations shardGenerations = repoData.shardGenerations();
                assert false : new AssertionError(ex);
            // Remove global state from the cluster state
                    }
                            repoName,
            if (updatedDeletions == deletions) {
                } else {
import org.opensearch.repositories.RepositoryException;
                            );
            actionFilters,
     * @return list of shard to be included into current snapshot
        Setting.Property.NodeScope,
                    .orElseThrow(() -> new SnapshotMissingException(repositoryName, request.source()));
                );
        }
        }
                            for (int shardId = 0; shardId < count.v2(); shardId++) {
                    shardRepoGeneration = ShardGenerations.NEW_SHARD_GEN;
                            "fail repo tasks for [" + repoName + "]",
     */
            });
            }
     *
                                entry
            boolean changedSnapshots = false;
import org.opensearch.index.IndexModule;
                    shardFailures.add(new SnapshotShardFailure(status.nodeId(), shardId, "skipped"));
     * @param snapshotsInProgress         new value for {@link SnapshotsInProgress} or {@code null} if it's unchanged
            }
                final ShardSnapshotStatus knownFailure = knownFailures.get(shardId);
                                indicesLookup = entry.indices().stream().collect(Collectors.toMap(IndexId::getName, Function.identity()));
            return null;
        /**
        @Nullable CleanupAfterErrorListener listener
                if (deleteFromRepoTask != null) {
     * to be re-assigned if there is another snapshot operation that is waiting for the shard to become available. We therefore record the
                );
                }
            () -> repositoriesService,
    /**
                    deleteFromRepoTask.clusterStateProcessed(source, oldState, newState);
                    listener.onFailure(e);
                    if (reusedExistingDelete) {
                repository,
                return true;
        String repository
            }
                }
            if (snapshot.state().completed()) {
                        () -> {
     * The pinned timestamp is later reconciled with remote store segment and translog metadata files during the restore
                                    new SnapshotException(repositoryName, snapshotName, "Aborting snapshot-v2, no longer cluster manager")
     * the snapshot.
                                    logger.error(
                builder.add(entry);
                if (remoteStoreIndexShallowCopy == false) {
        this.remoteStoreLockManagerFactory = new RemoteStoreLockManagerFactory(
                                    "Marked [{}] as successfully cloned from [{}] to [{}]",
                    logger.error("Failed to retrieve snapshot info for snapshot-v2 {} {} ", repositoryName, snapshotName);
                    .findAny()
    public static String getPinningEntity(String repositoryName, String snapshotUUID) {
                final String localNodeId = clusterService.localNode().getId();
                } else {
        @Override
            for (IndexId index : indices) {
     * @return            updated {@link SnapshotDeletionsInProgress} or {@code null} if unchanged
        final boolean readyToExecute = deletionsInProgress == null
                    minCompatibleVersion(currentState.nodes().getMinNodeVersion(), repositoryData, null),
                failAllListenersOnMasterFailOver(e);
                }
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "must not contain '#'");
                    request.indices()
        final SnapshotDeletionsInProgress.Entry deleteEntry,
                    .findFirst()
        for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
            assert deleteEntry.state() == SnapshotDeletionsInProgress.State.STARTED : "incorrect state for entry [" + deleteEntry + "]";
            this.latestKnownMetaData = metadata;
                listener.onFailure(e);
                listener.onFailure(e);
import java.util.Objects;
                }
                }
                    // for the same repository
                return request.clusterManagerNodeTimeout();
                            if (endingSnapshots.add(existingNotYetStartedSnapshot)) {
         * relative to the {@link SnapshotDeletionsInProgress} found in {@code currentState}.
                                        new ShardSnapshotStatus(
                    state -> stateWithoutSnapshot(state, snapshot),
            if (repositoriesSeen.add(entry.repository())
                    );
                    + "] snapshot-v2 is not supported for indices whose translog is not remote backed, since restoring a "
                );
                final SnapshotDeletionsInProgress.Entry replacedEntry = deletionsInProgress.getEntries()
                            updatedSnapshot,
                    remoteStoreIndexShallowCopy = false;
        Metadata metadata,
                    }
     * @param snapshots           list of snapshots that will be used as a filter, empty list means no snapshots are filtered
    private void ensureBelowConcurrencyLimit(
                    } else {
    /**
                final List<String> indices = new ArrayList<>();
        @Nullable
        final long expectedRepoGen = deleteEntry.repositoryStateId();
                                    updatedDeletions,
            .flatMap(entry -> entry.indices().stream())
                    "Removed all snapshot tasks for repository [{}] from cluster state, now failing listeners",
                final List<String> excludedWarmDfa = new ArrayList<>();
                    }
            private boolean reusedExistingDelete = false;
            }
     * @param repositoryData current {@link RepositoryData} for the repository we just ran the delete on.
            }
                                    updatedAssignmentsBuilder.put(shardId, updated);
        "snapshot.max_shards_allowed_in_status_api",
     */
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_SNAPSHOT;
            return ClusterStateTaskExecutor.ClusterTasksResult.<ShardSnapshotUpdate>builder()
import org.opensearch.cluster.ClusterStateTaskConfig;
            final boolean isNewIndex = repositoryData.getIndices().containsKey(indexName) == false;
        ClusterState currentState,
        // Exception handler for IO exceptions with loading index and repo metadata
                    failAllListenersOnMasterFailOver(e);
     * This is non-blocking method that runs on a thread from SNAPSHOT thread pool
     * @param minNodeVersion    minimum node version in the cluster
        this.transportService = transportService;
                        indicesForSnapshot.add(indexId.getName());
        for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
            public void onFailure(Exception e) {
                }
                                            new SnapshotException(
            repositoryOperations.finishDeletion(deleteEntry.uuid());
        }
            return state;
                                    currentState.routingTable(),
                    }
                                    repositoryData,
                        repositoryName,
                                if (shards != null) {
                        if (readyToExecute == false || inFlightShardStates.isActive(indexName, i)) {
            int shardCount = metadata.index(indexId.getName()).getNumberOfShards();
                                if (existingStatus == null || existingStatus.state() != ShardState.QUEUED) {
                for (IndexId indexId : repositoryData.getIndices().values()) {
                                .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(unmodifiableList(updatedSnapshotEntries)))
        return Tuple.tuple(
                    .filter(src -> src.getName().equals(request.source()))
            } else {
        repository.executeConsistentStateUpdate(repositoryData -> new ClusterStateUpdateTask(Priority.URGENT) {
                    final ShardId finishedShardId = updateSnapshotState.shardId;
                return request.clusterManagerNodeTimeout();
import org.opensearch.cluster.service.ClusterService;
    }
                        }
                                "primary shard hasn't been started yet",
            return;
                snapshot.getSnapshotId(),
                    for (IndexId index : entry.indices()) {
                    snapshot,
        }
    }
                        shards.put(finishedShardId, updateSnapshotState.updatedState);
        final Map<ShardId, ShardSnapshotStatus> builder = new HashMap<>();
                    if (newEntry.state().completed()) {
     */
                        if (canBeUpdated.isEmpty()) {
            } else {
                if (currentlyCloning.add(repoShardId)) {
                    event.routingTableChanged() && waitingShardsStartedOrUnassigned(snapshotsInProgress, event)
                logger.debug("Timestamp pinned successfully for snapshot {}", snapshot.getSnapshotId().getName());
        final boolean newFinalization = endingSnapshots.add(snapshot);
        // Stale blobs/lock-files will be cleaned up during delete/cleanup operation.
                    new SnapshotException(snapshot, "Failed to update cluster state during snapshot finalization", e)
            public ClusterState execute(ClusterState currentState) {
                                repositoryName,
            );
     * An update to the snapshot state of a shard.
                        changed = true;
        },
     * Setting that specifies the maximum number of allowed concurrent snapshot create and delete operations in the
        remoteStorePinnedTimestampService.pinTimestamp(
    }
                    .findAny()
                // already
                    throw new ConcurrentSnapshotExecutionException(
    static final class ShardSnapshotUpdate {
                            );
        logger.info("Publish failed for [{}] (attempt {}), scheduling retry in [{}]", source, nextAttempt, delay);
                    assert repositoryData.getSnapshotIds().stream().noneMatch(deleteEntry.getSnapshots()::contains)
                        // this CS update finishes
            final SnapshotsInProgress.Entry nextEntry;
        return new Setting.Validator<T>() {
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "must not start with '_'");
                }, latch)
                null
            @Override
                return true;
                            repoShardId,
     * @param shardGeneration         shard generation of the shard in the repository
        executor.execute(ActionRunnable.supply(snapshotInfoListener, () -> repository.getSnapshotInfo(sourceSnapshot)));
        if (snapshotsInProgress == null || snapshotsInProgress.entries().isEmpty()) {
                    + deleteListenerKeys
    }
        String repositoryName,
        deleteSnapshotTaskKey = clusterService.registerClusterManagerTask(DELETE_SNAPSHOT, true);
            }
                        logger.info("snapshot [{}] completed with state [{}]", snapshot, snapshotInfo.state());
            @Override
        final List<ShardSnapshotUpdate> unconsumedTasks = new ArrayList<>(tasks);
            threadPool,
            private ClusterStateUpdateTask deleteFromRepoTask;
                    );
                threadPool,
    public Version minCompatibleVersion(Version minNodeVersion, RepositoryData repositoryData, @Nullable Collection<SnapshotId> excluded) {
                                    changed = true;
                ensureNoCleanupInProgress(currentState, repositoryName, snapshotName);
                for (String delete : deletionsToFail) {
    private void leaveRepoLoop(String repository) {
                addListener(snapshot, ActionListener.wrap(r -> listener.onResponse(null), listener::onFailure));
import org.opensearch.cluster.RepositoryCleanupInProgress;
        public int hashCode() {
                    repositoryData.getGenId(),
                        "cannot start snapshot-v2 while a repository is in finalization state"
        for (String pinnedEntity : orphanPinnedEntities) {
                    .build()
            .collect(Collectors.toSet());
                                removeSnapshotDeletionFromClusterState(deleteEntry, e, repositoryData);
                    + SHALLOW_SNAPSHOT_V2.getKey()
                    snapshotsToFail.add(entry.snapshot());
                if (completedNoCleanup.isEmpty() == false) {
                threadPool.absoluteTimeInMillis(),
                    snapshotIds,
        validate(repositoryName, snapshotName, currentState);
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
                changed = true;
                    snapshot,
            final SnapshotsInProgress snapshotsInProgress = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                                        return;
                            ),
        return true;
     * <p>
        final ArrayList<SnapshotDeletionsInProgress.Entry> readyDeletions = new ArrayList<>();
                                }
        Setting.Property.NodeScope,
                threadPool.executor(ThreadPool.Names.SNAPSHOT).execute(ActionRunnable.supply(metadataListener, () -> {
            @Override
                    null,
        final ShardRouting primary = currentState.routingTable().index(shardId.getIndex()).shard(shardId.id()).primaryShard();
                if (indexId != null) {
                    indexIds,
                    // as well
    /**
import org.opensearch.common.UUIDs;
                    // If a failure is known for an execution we waited on for this shard then we fail with the same exception here
        boolean isSnapshotV2 = SHALLOW_SNAPSHOT_V2.get(repository.getMetadata().settings());
     * disconnect of a data node that was executing a snapshot) or a routing change that started shards whose snapshot state is
                    "Failed to get repository data while cloning shard [{}] from [{}] to [{}]",
    }
                    return;
                                "primary shard is not allocated",
    ) {
                    // We only saw snapshots that could be removed from the cluster state right away, no need to update the deletions
            .flatMap(e -> e.dataStreams().stream())
    }
         *
                    logger.debug("[{}] was aborted before starting", snapshot);
            } else if (snapshotCompletionListeners.isEmpty() == false) {
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
    /**
            return this.snapshot.equals(that.snapshot)
                        sourceSnapshotId.getName(),
            && clusterService.state().nodes().getMinNodeVersion().onOrAfter(Version.V_2_17_0)) {
                ActionListener.onResponse(listeners, result);
    private void failSnapshotCompletionListeners(Snapshot snapshot, Exception e) {
        ClusterState.Builder builder = ClusterState.builder(state);
     * Computes the cluster state resulting from removing a given snapshot create operation from the given state.
            return res;
                        repositoryName,
                }
                }
        final Set<String> repositoriesSeen = new HashSet<>();
                    listener.onNoLongerClusterManager();
    ) {
                            if (updatedEntry.state().completed()) {
                Strings.arrayToCommaDelimitedString(snapshotNames),
            );
            return;
     * Setting that controls whether a successful snapshot delete should opportunistically reclaim storage
            return;
            IndexMetadata indexMetadata = metadata.index(indexName);
        Snapshot snapshot = entry.snapshot();
                    repositoryOperations.runningDeletions.stream()
                        + "] in the repository";
            throw new ConcurrentSnapshotExecutionException(
        final ShardGenerations shardGenerations = repositoryData.shardGenerations();
        final Snapshot snapshot = entry.snapshot();
            public TimeValue timeout() {
     * Maximum number of retries for a cluster state publish failure while the node is still cluster-manager.
            SnapshotsInProgress.Entry entry = snapshotsInProgress.entries().get(0);
                    .stream()
        Map<String, List<Long>> pinnedEntities = RemoteStorePinnedTimestampService.getPinnedEntities();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                for (String snapshot : snapshots) {
                return false;
                            if (clusterService.state().nodes().isLocalNodeElectedClusterManager() == false) {
            }
            @Override
                            + "]";
                        + "]";
                    + inProgressOperations
                final List<SnapshotsInProgress.Entry> runningSnapshots = snapshots.entries();
            );
                    }, e -> handleFinalizationFailure(e, entry, repositoryData))
                updatedEntry = entry;
    }
                final Set<Snapshot> runningSnapshots = Stream.concat(
                final String shardRepoGeneration;
    }
     * has all executable deletes marked as executing. Returns a {@link Tuple} of the updated cluster state and all executable deletes.
            );
        @Override
                logger.warn("Failed to notify listeners", ex);
                        } else {
import org.opensearch.core.index.shard.ShardId;
     * Cluster state update task that removes all {@link SnapshotsInProgress.Entry} and {@link SnapshotDeletionsInProgress.Entry} for a
                Map<ShardId, ShardSnapshotStatus> shards = new HashMap<>();
        }
                    @Override
        logger.info(
                        deleteSnapshotsFromRepository(readyDeletion, repositoryData, newState.nodes().getMinNodeVersion());
    private void runNextQueuedOperation(RepositoryData repositoryData, String repository, boolean attemptDelete) {
                            final Snapshot existingNotYetStartedSnapshot = existing.snapshot();
    }
    }
    };
                    );
                                .stream()
            builder.putCustom(SnapshotDeletionsInProgress.TYPE, snapshotDeletionsInProgress);
     * Unlike traditional snapshot operations, this method performs a synchronous snapshot execution and doesn't
                entry.dataStreams(),
                            + index
import org.opensearch.cluster.SnapshotsInProgress.State;
                    request.includeGlobalState(),
                        snapshot.getSnapshotId(),
                    + snapshotListenerKeys
                    final SnapshotDeletionsInProgress snapshotDeletionsInProgress = newState.custom(
    public static ClusterState updateWithSnapshots(
     *
 */
        // The constructor of UpdateSnapshotStatusAction will register itself to the TransportService.
    private static Map<String, IndexId> getInFlightIndexIds(List<SnapshotsInProgress.Entry> runningSnapshots, String repositoryName) {
                                    routingTable,
        }
                                );
                    System.currentTimeMillis(),
                    newEntry.indices(),
                    IndexId.DEFAULT_SHARD_PATH_TYPE
        );
            // Computing the new assignments can be quite costly, only do it once below if actually needed
                final Version version = minCompatibleVersion(currentState.nodes().getMinNodeVersion(), repositoryData, null);
        return unmodifiableList(builder);
        if (snapshotDeletionsInProgress.hasDeletionsInProgress()) {
                try {
            && clusterService.getClusterSettings().get(REMOTE_STORE_COMPATIBILITY_MODE_SETTING).equals(CompatibilityMode.MIXED)) {
                            "missing routing table",
                    : "Repository generation should not change as long as a ready delete is found in the cluster state but found ["
     * Only modifiable when the snapshot resilience feature flag is enabled.
        @Nullable final Exception failure,
    private final ClusterManagerTaskThrottler.ThrottlingKey deleteSnapshotTaskKey;
}
                    entry.version(),
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
        ensureNoCleanupInProgress(currentState, repositoryName, snapshotName);
                    } finally {
                    }
        }
                            snapshotEntries.add(updatedEntry);
     * @param snapshot clone snapshot
 * license agreements. See the NOTICE file distributed with
                @Override
            }
                return deleteFromRepoTask.execute(currentState);
    public static final Setting<Integer> SNAPSHOT_REPOSITORY_MAX_OUTSTANDING_OPS_SETTING = Setting.intSetting(
            }, e -> listener.onFailure(e));
     * <p>
    public void deleteSnapshots(final DeleteSnapshotRequest request, final ActionListener<Void> listener) {
        }
        final RepositoryData repositoryData
    }
        final SnapshotId sourceSnapshot = cloneEntry.source();
         * {@link Metadata to use when finalizing}.
                            listener.onFailure(e);
            return;
import org.opensearch.cluster.ClusterChangedEvent;
        List<SnapshotsInProgress.Entry> builder = new ArrayList<>();
            public void onResponse(RepositoryData repositoryData) {
        1,
        0,
                            try {
     *
                        return currentState;
                }
                    stateWithoutSnapshotV2(newState);
                final SnapshotId sourceSnapshotId = repositoryData.getSnapshotIds()
        }
    );
     */
                    snapshotInfo,
        final SnapshotId snapshotId = new SnapshotId(snapshotName, UUIDs.randomBase64UUID());
            if (remoteStoreShallowCopyEnabled) {
                        failSnapshotCompletionListeners(snapshot, new SnapshotException(snapshot, "no longer cluster-manager"));
        Settings settings,
     * a shallow snapshot and pinning the snapshot timestamp.The entire process is executed on the cluster manager node.
                    Set<String> missing = new HashSet<>();
                );
import java.util.EnumSet;
                        "delete snapshot",
                                public void onResponse(RepositoryData repositoryData) {
        })) {
            logger.warn(() -> new ParameterizedMessage("{} failed to remove snapshot deletion metadata", deleteEntry), e);
     * Assert that no in-memory state for any running snapshot-create or -delete operation exists in this instance.
            assert false : new AssertionError(e);
        }, "clone_snapshot [" + request.source() + "][" + snapshotName + ']', listener::onFailure);
                }
                        ShardRouting primary = indexRoutingTable.shard(i).primaryShard();
                            snapshotsWithLockFiles,
                    currentState,
                ShardId shardId = shardStatus.getKey();
            timestampToPin,
        final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
        TimeValue.timeValueMillis(100),
        snapshot.indices().forEach(indexId -> {
                }
    }
        if (snapshotName.charAt(0) == '_') {
            try {
        }
        }
        } else {
                    new Snapshot(repositoryName, snapshotId),
                        // delete
    public static final Setting<Boolean> SNAPSHOT_DELETE_CLEANUP_STALE_BLOBS_SETTING = Setting.boolSetting(
     * @param snapshotName snapshot name
        if (ExceptionsHelper.unwrap(e, FailedToCommitClusterStateException.class) == null) {
import java.util.concurrent.Executor;
                    + " as well as "
import java.util.Deque;
                final Version version = minCompatibleVersion(currentState.nodes().getMinNodeVersion(), repositoryData, null);
                    );
                            );
        final Collection<SnapshotId> snapshotIds = repositoryData.getSnapshotIds();
    private void addDeleteListener(String deleteUUID, ActionListener<Void> listener) {
            final String repository = snapshot.getRepository();
            SnapshotDeletionsInProgress.EMPTY
            }
            .map(SnapshotDeletionsInProgress.Entry::repository)
            });
            if (newFinalizations.isEmpty()) {
            remoteStoreSettings.getSegmentsPathFixedPrefix(),
        CLEANUP_STALE_BLOBS_KEY,
                            // shard snapshot was completed, we check if we can start a clone operation for the same repo shard
                        SnapshotDeletionsInProgress.TYPE,
            }
 * You may obtain a copy of the License at
            } else {
    /**
            assert nextEntry != null;
    }
            .values()
                            logger.debug("[{}] was found in dangling INIT or ABORTED state", snapshot);
        }
                                continue;
                leaveRepoLoop(deleteEntry.repository());
     * {@link SnapshotDeletionsInProgress.State#STARTED} or waiting entries in state {@link SnapshotDeletionsInProgress.State#WAITING}
                }
            } else if (shardStatus.state().completed() == false && shardStatus.nodeId() != null) {
            // nothing to do, no relevant external change happened
     *
            if (indexMetadata == null) {
    ) {
                    final SnapshotId sourceSnapshot = updatedEntry.source();
        List<String> snapshots
     * operations if there are any.
                if (nodes.nodeExists(shardStatus.nodeId())) {
                    }
                                final RepositoryShardId repoShardId = new RepositoryShardId(indexId, finishedShardId.getId());
            logger.error("Unexpected failure during cluster state update", e);
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "must not contain ','");
            // Keep track of shardIds that we started snapshots for as a result of removing this delete so we don't assign
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                        snapshotName,
                    changedSnapshots = true;
            @Override
    }
    private final class FailPendingRepoTasksTask extends ClusterStateUpdateTask {
    /**
                logger.error("Unexpected failure during cluster state update", e);
                public ClusterState execute(ClusterState currentState) {
        Setting.Property.Dynamic
                            iterator.remove();
                                    changed = true;
    private static boolean removedNodesCleanupNeeded(SnapshotsInProgress snapshotsInProgress, List<DiscoveryNode> removedNodes) {
                updatedEntry = entry.withClones(clones);
        }
                } else {
            );
                final Map<String, Object> userMeta = repository.adaptUserMetadata(request.userMetadata());
                snapshotName,
            ),
                createSnapshotPreValidations(currentState, repositoryData, repositoryName, snapshotName);
                                iterator.remove();
                throw new IllegalArgumentException("setting [" + IO_TIMEOUT_KEY + "] must be at least [1s], got [" + value + "]");
     * Same as {@link #createSnapshot(CreateSnapshotRequest, ActionListener)} but invokes its callback on completion of
                        );
            // Most likely scenario - one snapshot is currently running
        clusterService.submitStateUpdateTask(
                            + "]";
                    );
            return ThreadPool.Names.SAME;
                final RestoreInProgress restoreInProgress = currentState.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY);
                        assert reposWithRunningDelete.contains(entry.repository()) : "Found shard snapshot waiting to be assigned in ["
            assert (latestKnownMetaData == null && snapshotsToFinalize.isEmpty())
                    if (cloneRemoteStoreIndexShardSnapshot) {
                }
                }
                return request.clusterManagerNodeTimeout();
                    // aborted snapshots to potentially fail shards running on the removed nodes
    private boolean tryEnterRepoLoop(String repository) {
                    if (foundDuplicate.isPresent()) {
                    } else {
     * shard update has an effect we use an outer loop over all current executing snapshot operations that iterates over them in the order
                entries.add(entry);
    private static ShardGenerations buildShardsGenerationFromRepositoryData(
                        if (shardRouting.primaryShard().started()) {
        // Read the raw values: INDEX_REMOTE_STORE_ENABLED_SETTING carries a validator that cross-checks
    }
                    shards,
                    newEntry.dataStreams(),
     * that were moved to {@link SnapshotDeletionsInProgress.State#STARTED} in the returned updated cluster state.
        );
                if (enteredLoop == false) {
                                failSnapshotCompletionListeners(
                        @Override
            failoverFallback.run();
        }
                    );
                            // No point in doing noop updates that might happen if data nodes resends shard status after a disconnect.
                if (entry.repository().equals(repository)) {
                                    stateWithoutSnapshotV2(newState);
                public void onFailure(String source, Exception e) {
    }
                            new Snapshot(repoName, snapshotIds.get(0)),
            removeFailedSnapshotFromClusterState(targetSnapshot, e, null, null);
            source,
                        targetSnapshot,
        Snapshot snapshot,
                repositoryOperations.addFinalization(entry, metadata);
                    return;
        // makes sure we don't have listeners for snapshots that aren't tracked in any internal state of this class
                    shardStatus.nodeId(),
            innerUpdateSnapshotState(
        repository.executeConsistentStateUpdate(repositoryData -> new ClusterStateUpdateTask(Priority.URGENT) {
                        // Collect waiting shards that in entry that we can assign now that we are done with the deletion
                // Snapshot ids that will have to be physically deleted from the repository
    ) {
        4,
                    RepositoryCleanupInProgress.EMPTY
                    repositoryData.getGenId(),
                            final ShardSnapshotStatus existingStatus = entry.clones().get(finishedShardId);
            }
    }
     * Calculates the assignment of shards to data nodes for a new snapshot based on the given cluster state and the
        }
        ActionListener<Void> listener
            }
    private abstract class RemoveSnapshotDeletionAndContinueTask extends ClusterStateUpdateTask {
                logger.info("snapshot-v2 clone [{}] started", snapshot);
import static org.opensearch.cluster.service.ClusterManagerTask.UPDATE_SNAPSHOT_STATE;
                    .filter(src -> src.getName().equals(request.source()))
                            // cleaning up in progress snapshot here
                return true;
                    ? SHARD_PATH_TYPE.get(repository.getMetadata().settings()).getCode()
     * @param repository  repository that the snapshot ids belong to
                            snapshotsWithPinnedTimestamp,
        }
        }
                            deletionsToExecute.add(delete);
import org.opensearch.cluster.metadata.IndexMetadata;
 * The OpenSearch Contributors require contributions made to
            return repoShardId != null;
                            }
                        throw new ConcurrentSnapshotExecutionException(
                    + " limit for concurrent snapshot operations is set to ["
            } else if (clones != null) {
        } catch (Exception e) {
                }
            readyDeletions
                                } else {
                "primary shard hasn't been started yet",
            }
import org.opensearch.cluster.RestoreInProgress;
        return false;
        // Snapshots to fail after the state update
     * It pins the same timestamp that is pinned by the source snapshot.
                            // a lookup for the index ids
                                currentState,
                            }
            return Collections.emptyList();
        if (failure == null) {
                    failListenersIgnoringException(deleteListeners, failure);
        );
                                e -> {
                    );
        }
                    }
        RepositoryData repositoryData,
            }
                final boolean newClusterManager = event.previousState().nodes().isLocalNodeElectedClusterManager() == false;
                            );
                        // enqueue the snapshot finalizations here because the ongoing delete will take care of that when removing the
                final IndexId indexId = indexLookup.get(id.indexName());
     */
        private final List<Snapshot> snapshotsToFail = new ArrayList<>();
                        Collections.emptyList(),
     * translog repository, and operations acknowledged in that gap are unrecoverable. Creation itself would still
            shardSnapshotStatus = new ShardSnapshotStatus(null, ShardState.MISSING, "primary shard is not allocated", shardGeneration);
            + localNode
                sourceSnapshotId = repositoryData.getSnapshotIds()
                            updateSnapshotState.updatedState.state()
                            // If the entry is still in the cluster state and is completed, try finalizing the snapshot in the repo
        ShardSnapshotUpdate(Snapshot snapshot, ShardId shardId, ShardSnapshotStatus updatedState) {
            }, onFailure));
            RepositoryCleanupInProgress.EMPTY
                }
                        public void onResponse(RepositoryData repositoryData) {
    private static boolean isSegmentsOnlyIndex(IndexMetadata indexMetadata) {
        true,
            return;
                    pinnedTimestamp
                    logger.info("snapshot [{}] started", snapshot);
                            + repositoryData.getSnapshotIds()
                        logger.warn("cluster-manager failover before deleted snapshot could complete", e);
                        // Entry is already completed so we will finalize it now that the delete doesn't block us after
        final StepListener<Collection<Tuple<IndexId, Integer>>> allShardCountsListener = new StepListener<>();
                                    entry.indices(),
                            continue;
import java.util.concurrent.ConcurrentHashMap;
            + "]";
            throw new InvalidSnapshotNameException(
                new LatchedActionListener<>(new ActionListener<>() {
        List<String> orphanPinnedEntities = pinnedEntities.keySet()
                                            snapshot,
        // Only keep those data streams in the metadata that were actually requested by the initial snapshot create operation
                    );
    static final ClusterStateTaskExecutor<ShardSnapshotUpdate> shardStateExecutor = (currentState, tasks) -> {
                                // only remove the update from the list of tasks that might hold a reusable shard if we actually
/*
                        : "Repository data contained snapshot ids "
                            final Metadata.Builder metaBuilder = Metadata.builder(repository.getSnapshotGlobalMetadata(newEntry.source()));
            @Override
                        + "] not found in snapshots to fail "
        final String localNodeId = currentState.nodes().getLocalNodeId();
                Tuple<SnapshotsInProgress.Entry, Metadata> finalization;
        }
                        startExecutableClones(snapshotsInProgress, update.snapshot.getRepository());
     * @param request  snapshot request
                    SnapshotDeletionsInProgress.EMPTY
            || deletionsInProgress.getEntries()
                return ClusterState.builder(currentState).putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(newEntries)).build();
                            ? ClusterState.builder(currentState)
                    if (changedNodes) {
        }
                            remoteSegmentStoreDirectoryFactory,
    }
        private final ActionListener<Snapshot> userCreateSnapshotListener;
 * Modifications Copyright OpenSearch Contributors. See
                                        "Failed to upload files to snapshot repo {} for clone snapshot-v2 {} ",
            ClusterState state,
            return snapshotsToFinalize.isEmpty();
     * Shortcut to build new {@link ClusterState} from the current state and updated values of {@link SnapshotsInProgress} and
        });
        this.repositoriesService = repositoriesService;
                // nothing to do for already completed snapshots
        final Set<ShardSnapshotUpdate> executedTasks = new HashSet<>();
                    .filter(entry -> Objects.equals(entry.repository(), repoName))
     * @param repositoryData current {@link RepositoryData} of that repository
                                shardAssignments = shards(
                                clones = new HashMap<>(entry.clones());
                                } else {
        });
                for (Snapshot snapshot : completedNoCleanup) {
            + " on ["
        if (snapshotName.contains("#")) {
     * Rejects a snapshot-v2 covering an index whose segments are remote backed but whose translog is not, which is how
     * Handles a cluster-state-update onFailure by either retrying (if the publish failed but this node is still the
                }
                            // snapshot
                    new Snapshot(repositoryName, snapshotId),
                        // them
        // TODO: we could skip this step for snapshots with state SUCCESS
                logger.warn("failing snapshot of shard [{}] on unassigned shard [{}]", shardId, shardStatus.nodeId());
                    }
                            shards.put(finishedRoutingShardId, shardSnapshotStatus);
    public boolean assertAllListenersResolved() {
                            logger.warn(
                );
 * specific language governing permissions and limitations
                                && entry.getSnapshots().containsAll(snapshotIds)
                            SnapshotsInProgress.TYPE,
                        () -> createRemoveFailedSnapshotTask(source, attempt + 1, snapshot, failure, repositoryData, listener),
     * Handle snapshot or delete failure due to not being cluster-manager any more so we don't try to do run additional cluster state updates.
    /**
    private void failAllListenersOnMasterFailOver(Exception e) {
            this.updatedState = updatedState;
                    // Snapshot had an incomplete shard running on a removed node so we need to adjust that shard's snapshot status
                }
        }
                return ClusterState.builder(currentState)
                            }
            public ClusterState execute(ClusterState currentState) {
                        if (statesToUpdate.contains(snapshot.state())) {
import static java.util.Collections.unmodifiableList;
                    );
     * @return tuple of an updated cluster state and currently executable snapshot delete operations
import org.opensearch.index.IndexSettings;
import org.opensearch.core.common.Strings;
                            final boolean cloneRemoteStoreIndexShardSnapshot = indexMetadata.getSettings()
import org.opensearch.repositories.RepositoryShardId;
        this.updateSnapshotStatusHandler = new UpdateSnapshotStatusAction(
    public void createSnapshotV2(final CreateSnapshotRequest request, final ActionListener<SnapshotInfo> listener) {
                                "Starting clone [{}] on [{}] with generation [{}]",
    /**
     */
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode;
                        final boolean remoteStoreIndexShallowCopy = Boolean.TRUE.equals(updatedEntry.remoteStoreIndexShallowCopy());
                repositoryName,
                    repoName
                for (Snapshot snapshot : new HashSet<>(snapshotCompletionListeners.keySet())) {
                                final ShardSnapshotStatus existingStatus = entry.clones().get(repoShardId);
    private static Tuple<ClusterState, List<SnapshotDeletionsInProgress.Entry>> readyDeletions(ClusterState currentState) {
                    }
                    if (endingSnapshots.add(snapshot)) {
    public SnapshotsService(
     * Returns a {@link Setting.Validator} that rejects updates when the snapshot resilience feature flag is disabled.
        long pinnedTimestamp = System.currentTimeMillis();
                            }, ex -> removeSnapshotDeletionFromClusterState(deleteEntry, ex, repositoryData))
                        if (entry.isClone()) {
    public void cloneSnapshotV2(
     * Validates snapshot request
                    + maxOps
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                failCloneShardAndUpdateClusterState(target, sourceSnapshot, repoShardId);
                    continue;
                            shardGenerations,
                            final IndexMetadata indexMetadata = repository.getSnapshotIndexMetaData(
     * @param shardId shard id of the shard that just finished cloning
    }
                .noneMatch(entry -> entry.repository().equals(repoName) && entry.state() == SnapshotDeletionsInProgress.State.STARTED);
                        "cannot delete snapshots in v2 repo while a snapshot is in progress"
                () -> currentlyCloning.remove(repoShardId)
                                removeSnapshotDeletionFromClusterState(deleteEntry, null, updatedRepoData);
import java.util.stream.Collectors;
                        if (shards == null) {
                    RepositoryCleanupInProgress.TYPE,
/*
        for (String index : indices) {
                    )
                } else {
                    fallback.run();
            return updateSnapshotStateTaskKey;
                        // state update we check if its state is completed and end it if it is.
                            shardSnapshotStatus = new ShardSnapshotStatus(
     */
            @Override
            }
                            if (shardAssignments == null) {
                    repositoryData.getGenId(),
                    : "New finalizations " + newFinalizations + " added even though deletes " + readyDeletions + " are ready";
                                );
                final SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(
            this.shardId = null;
        CountDownLatch latch = new CountDownLatch(1);
    }
            // the flag. This can be improved by having the info whether there ever were any shallow snapshot present in this repository
                if (snapshotIdsRequiringCleanup.isEmpty()) {
                pinnedEntity,
        repositoriesService.getRepositoryData(deleteEntry.repository(), new ActionListener<RepositoryData>() {
        }
                final List<SnapshotsInProgress.Entry> runningSnapshots = snapshots.entries();
        for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
            logger.warn("Shallow snapshots are not supported during migration. Falling back to full snapshot.");
        // TODO: create snapshot UUID in CreateSnapshotRequest and make this operation idempotent to cleanly deal with transport layer
                        newEntry.includeGlobalState(),
                validateSnapshotsBackingAnyIndex(currentState.getMetadata().getIndices(), snapshotIds, repoName);
                                    );
         * Computes an updated {@link SnapshotsInProgress} that takes into account an updated version of
                    // starting shard clones.
            repositoryOperations.finishDeletion(deleteEntry.uuid());
        Runnable failoverFallback
        final Set<Index> indices = new HashSet<>();
                    ensureBelowConcurrencyLimit(repoName, toDelete.get(0).getName(), snapshots, deletionsInProgress);
        } catch (Exception e) {
        } else {
            );
                                    updatedSnapshotEntries.add(snapshot);
    public void applyClusterState(ClusterChangedEvent event) {
                }
            this.updatedState = updatedState;
                    logger.debug("Timestamp pinned successfully for clone snapshot {}", snapshot.getSnapshotId().getName());
                failure,
    }
                        break;
        }
            boolean enteredRepoLoop;
                        }
                                logger.trace(
            final List<SnapshotsInProgress.Entry> snapshotEntries = new ArrayList<>();
                    snapshotEntries.add(entry);
        }
            }
        @Override
     * Run the next queued up repository operation for the given repository name.
                repositoryData,
                        } else if (!primary.started()) {
                                );
                    if (inProgress.stream().noneMatch(snapshotId -> snapshotId.getName().equals(snapshotOrPattern))) {
                if (indexMetadata == null) {
     *                       {@code null}
            .distinct()
                repository.getMetadata().name(),
                        snapshots.entries()
            boolean changed = false;
     * will be started for that snapshot entry and the task removed from the collection of tasks that need to be applied to snapshot
        Version minNodeVersion
                    final StepListener<Metadata> metadataListener = new StepListener<>();
                        updatedSnapshots.entries()
 * deletion.
                final List<SnapshotsInProgress.Entry> updatedEntries = new ArrayList<>(snapshotsInProgress.entries());
                        builder.add(entry);
    }
                newDeletes.add(entry);
                snapshotName,
            }
                }
                    remoteStoreIndexShallowCopy
     * @param repositoryData current repository data for the snapshot's repository
            );
    private final UpdateSnapshotStatusAction updateSnapshotStatusHandler;
     * on the repository.
                    shards,
    /**
        synchronized boolean assertNotQueued(Snapshot snapshot) {
        final String snapshotName = indexNameExpressionResolver.resolveDateMathExpression(request.target());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Repository repository = repositoriesService.repository(request.repository());
            currentlyFinalizing.clear();
        }
                SnapshotsInProgress snapshotsInProgress = event.state().custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                                .build()
                        "cannot start snapshot-v2 while a repository is in finalization state"
                ).collect(Collectors.toSet());
                    if (clusterService.state().nodes().isLocalNodeElectedClusterManager() == false) {
            public void onNoLongerClusterManager(String src) {
        final DiscoveryNode localNode = clusterService.localNode();
                deleteSnapshotsFromRepository(deleteEntry, repositoryData, minNodeVersion);
                                    assert currentState.routingTable().hasIndex(shardId.getIndex()) == false : "Missing assignment for ["
            }
                        }
            public void clusterStateProcessed(String src, ClusterState oldState, ClusterState newState) {
                    userMeta,
        if (ExceptionsHelper.unwrap(e, NotClusterManagerException.class) != null) {
        if (settings.getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false) == false) {
                        }
                        excludedWarmDfa
    }
            public TimeValue timeout() {
                                .getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false);
            }
                );
                && Objects.equals(this.repoShardId, that.repoShardId)
        boolean remoteStoreIndexShallowCopy = remoteStoreShallowCopyEnabled(repository);
    private static void validate(String repositoryName, String snapshotName, ClusterState state) {
        );
                        e -> {
                // Shard that we were waiting for went into unassigned state or disappeared - giving up
            clusterService.getClusterSettings().addSettingsUpdateConsumer(SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING, t -> retryBackoff = t);
                // We have snapshot listeners but are not the cluster-manager any more. Fail all waiting listeners except for those that
        }
import java.util.HashMap;
    private void deleteSnapshotsFromRepository(
                    if (cloneEntry.snapshot().equals(updatedEntries.get(i).snapshot())) {
                    }
                                    finishedStatus.generation()
        ClusterService clusterService,
     * @param e              exception encountered
                            cloneSnapshotInfo,
                    addDeleteListener(newDelete.uuid(), listener);
            private final Collection<Snapshot> completedNoCleanup = new ArrayList<>();
                            logger.trace(
                                final RepositoryShardId repoShardId = new RepositoryShardId(count.v1(), shardId);
        1000,
        }
            }
                            .collect(Collectors.toList())
        ArrayList<SnapshotsInProgress.Entry> entries = new ArrayList<>();
        };
        return false;
        @Override
                final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);
            && isSnapshotV2
            } catch (Exception ex) {
        innerUpdateSnapshotState(
            return res.v1();
        if (repositoryOperations.isEmpty() == false) {
            try {
    private final IndexNameExpressionResolver indexNameExpressionResolver;
                    snapshotDeletionsInProgress.getEntries().stream().map(SnapshotDeletionsInProgress.Entry::uuid),
        final SnapshotId snapshotId = new SnapshotId(snapshotName, UUIDs.randomBase64UUID()); // new UUID for the snapshot
            @Override
            };
            // from the repository from enqueued snapshot delete entries during the cluster state update. After the cluster state update we
                        changed
                            }
                            // Currently initializing clone
        public boolean equals(Object other) {
                );
     *
                        attempt,
                                ),
                    executeClone(localNodeId, false);
                    );
     * @param deleteEntry       delete entry in cluster state
            }
        Setting.Property.Dynamic
        }
        }
            } else {
    private void cleanOrphanTimestamp(String repoName, RepositoryData repositoryData) {
                assert false : new AssertionError(ex);
        final Map<String, IndexId> indexLookup = new HashMap<>();
                };
                        ),
     * If the update was not a noop, then it means that the shard it applied to is now available for another snapshot or clone operation
                        }
                                    updatedAssignmentsBuilder.put(shardId, ShardSnapshotStatus.MISSING);
    private void deleteSnapshotsFromRepository(SnapshotDeletionsInProgress.Entry deleteEntry, Version minNodeVersion) {
                    .orElseThrow(() -> new SnapshotMissingException(repositoryName, request.source()));
                if (updatedSnapshotIds.removeAll(snapshotIds)) {
     * TODO: optimize this to execute in a single CS update together with finalizing the latest snapshot
import org.opensearch.common.regex.Regex;
        assert endingSnapshots.isEmpty() : "Found leaked ending snapshots " + endingSnapshots + " on [" + localNode + "]";
            }
        final ShardGenerations shardGenerations = repositoryData.shardGenerations();
        };
            public void onFailure(String src, Exception e) {
                    if (snapshotsWithPinnedTimestamp.size() > 0) {
        );
                                logger.warn("Failed to get snapshot info for {} with exception {}", snapshotId, e);
            IndexMetadata indexMetadata = metadata.index(indexName);
                    pinnedTimestamp,
     * </p>
                newEntry = SnapshotsInProgress.startClone(
    /** Deletes snapshot from repository
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
    ) {
            retryBackoff = SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING.get(settings);
        this.remoteStorePinnedTimestampService = remoteStorePinnedTimestampService;
                        final List<ShardId> canBeUpdated = new ArrayList<>();
                if (updateSnapshotState.isClone()) {
        if (snapshotName.toLowerCase(Locale.ROOT).equals(snapshotName) == false) {
        };
            result = ClusterState.builder(state)
        );
 * this file be licensed under the Apache-2.0 license or a
                        stateWithoutSnapshotV2(newState);
                boolean remoteStoreIndexShallowCopy = REMOTE_STORE_INDEX_SHALLOW_COPY.get(repository.getMetadata().settings());
        } else {
                final Set<String> runningDeletes = Stream.concat(
                    );
                                finishedStatus.generation()
                indexNameExpressionResolver
                final List<SnapshotId> snapshotIds = matchingSnapshotIds(
        );
        final SnapshotDeletionsInProgress deletions = currentState.custom(
            listener.onFailure(e);
                // don't allow snapshot deletions while a restore is taking place,
        final Set<SnapshotId> foundSnapshots = new HashSet<>(inProgress);
                endingSnapshots.removeAll(completedNoCleanup);
                                continue;
                final ShardState state = status.state();
                }
                final String localNodeId = currentState.nodes().getLocalNodeId();
                "deleting snapshots [{}] from repository [{}]",
        }
                    indexIds,
                                ShardState.MISSING,
                        statesToUpdate = EnumSet.of(State.STARTED);
                    changed = true;
                    }
     *
            ActionListener.runBefore(
            final StepListener<Metadata> metadataListener = new StepListener<>();
                    DiscoveryNodes nodes = currentState.nodes();
                            }
     * @param request         delete snapshot request
        return listenersToComplete;
            latestKnownMetaData = null;
            listener.onFailure(new RepositoryException(repository.getMetadata().name(), "cannot create snapshot in a readonly repository"));
        ShardGenerations.Builder builder = ShardGenerations.builder();
     * Setting that specifies the time budget for snapshot repository I/O operations on the cluster-manager node
         * The removal of a delete from the cluster state can trigger two possible actions on in-progress snapshots:
     *                     cluster
                .successes(tasks)
import org.opensearch.action.StepListener;
                        for (SnapshotId snapshotId : snapshotIds) {
    }
        long timestampToPin,
                @Override
     * @param entry snapshot
import org.opensearch.cluster.ClusterState;
                    logger.info(
            deleteListeners = snapshotDeletionListeners.remove(deleteEntry.uuid());
         * @param deleteListeners delete snapshot listeners or {@code null} if there weren't any for {@link #deleteEntry}.
                        final IndexMetadata metadata = repository.getSnapshotIndexMetaData(repositoryData, sourceSnapshot, index);
                            // When all the required shards for a snapshot are missing, the snapshot state will be "completed"
            @Override
                .build(ClusterState.builder(currentState).putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(entries)).build());
        if (segmentsOnlyIndices.isEmpty() == false) {
    }
                                Boolean.TRUE.equals(snapshotInfoListener.result().isRemoteStoreIndexShallowCopyEnabled())
                    if (finishedSnapshots.isEmpty() == false) {
    ) {
    /**
    private static ShardSnapshotStatus startShardSnapshotAfterClone(ClusterState currentState, String shardGeneration, ShardId shardId) {
                );
                final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);
                        + index
        Map<String, DataStream> dataStreams = currentState.metadata().dataStreams();
            final IndexRoutingTable indexRoutingTable = routingTable.index(indexName);
                            if (clones == null) {
            private SnapshotsInProgress.Entry newEntry;
                    throw new ConcurrentSnapshotExecutionException(
    /**
                        repository.cloneShardSnapshot(
                );
                    SnapshotDeletionsInProgress.EMPTY
            public void onFailure(String source, Exception e) {
            }
                }
                        .findFirst();
import org.opensearch.cluster.node.DiscoveryNodes;
            }
            }
                final List<SnapshotsInProgress.Entry> snapshotEntries = findInProgressSnapshots(snapshots, snapshotNames, repoName);
        );
                                ) ? SnapshotDeletionsInProgress.State.STARTED : SnapshotDeletionsInProgress.State.WAITING
                            if (existingStatus == null || existingStatus.state() != ShardState.QUEUED) {
                            final Map<ShardId, ShardSnapshotStatus> updatedAssignmentsBuilder = new HashMap<>(entry.shards());
        }
import static org.opensearch.cluster.SnapshotsInProgress.completed;
                        // Maybe this state update completed the snapshot. If we are not already ending it because of a concurrent
                        assert entry.isClone() : "Non-clone snapshot ["
                    final RepositoryShardId finishedShardId = updateSnapshotState.repoShardId;
        1,
     * creates a snapshot record in cluster state metadata.
                        logger.warn("Cluster state update after failed shard clone [{}] failed", repoShardId);
    // for repository metadata and loading it has predictable performance
                            + settingKey
        String snapshotName = snapshot.getSnapshotId().getName();
                // this is a clone, see if new work is ready
            if (entry.isClone()) {
                        pinnedTimestampListener
        boolean changed = false;
                // otherwise we could end up deleting a snapshot that is being restored
        }
                    logger.info("Successfully aborted snapshot [{}]", runningSnapshot);
    }
                                            inFlightShardStates.generationForShard(repoShardId.index(), shardId, shardGenerations)
            new ClusterStateTaskListener() {
                        )
        }
    // to be assigned
        Setting.Property.Dynamic
        final Map<ShardId, ShardSnapshotStatus> snapshotShards,
     *
            this.snapshot = snapshot;
            builder = Metadata.builder();
                    if (entry.remoteStoreIndexShallowCopyV2()) {
import java.util.Collections;
    void runReadyClone(
            @Override
     * If the inner loop finds that a shard update task applies to a given snapshot and either a shard-snapshot or shard-clone operation in
            @Override
        }
                        + snapshotsToFail;
        boolean includeGlobalState,
                                    clonesBuilder.put(
            .filter(SnapshotsService::isSegmentsOnlyIndex)
     */
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            }
                updatedEntries.add(entry);
         *     state but need to have their finalization triggered now that it's possible with the removal of the delete
                        }
            this.snapshot = snapshot;
                            final ShardSnapshotStatus existingStatus = entry.shards().get(finishedRoutingShardId);
                .addSettingsUpdateConsumer(MAX_CONCURRENT_SNAPSHOT_OPERATIONS_SETTING, i -> maxConcurrentOperations = i);
                for (Snapshot snapshot : new HashSet<>(snapshotCompletionListeners.keySet())) {
            builder = Metadata.builder(metadata);
                        sourceSnapshotId.getName(),
        return false;
                }
        if (changedNodes == false && startShards == false) {
                            continue;
                        } else if (abortedEntry.state().completed()) {
                repositoryName,
            return false;
                Map<SnapshotId, Long> snapshotsWithPinnedTimestamp = new ConcurrentHashMap<>();
            public void clusterStateProcessed(String source, ClusterState oldState, final ClusterState newState) {
                    new ActionListener<RepositoryData>() {
                        } else if (primary == null || !primary.assignedToNode()) {
        Repository repository = repositoriesService.repository(repositoryName);
                    minCompatibleVersion(minNodeVersion, repositoryData, snapshotIds),
import org.opensearch.cluster.SnapshotDeletionsInProgress;
package org.opensearch.snapshots;
                    );
                            repositoryData.getGenId(),
            if (entry.state() == State.STARTED) {
                    request.partial(),
                            }
        if (remoteStoreIndexShallowCopy
                                    snapshotsWithPinnedTimestamp.put(snapshotId, snapshotInfo.getPinnedTimestamp());
                return ClusterState.builder(currentState)
        @Nullable SnapshotDeletionsInProgress deletionsInProgress,
     * This can either be {@link SnapshotDeletionsInProgress.Entry} that were already in state
                                if (clones == null) {
        boolean changed = false;
                            logger.warn(
                    if (missing.isEmpty() == false) {
                        "[{}][{}] excluded warm-tiered pluggable data format indexes from snapshot v2: {}",
                                    finishedShardId,
                    .filter(src -> src.getName().equals(request.source()))
    private final RemoteStorePinnedTimestampService remoteStorePinnedTimestampService;
            );
     * Returns status of the currently running snapshots
                            source
            if (entry.remoteStoreIndexShallowCopyV2()) {
                    dataStreams,
     * Setting that specifies the maximum number of outstanding (dispatched but uncompleted) cluster-manager-side
                            }
            return updateWithSnapshots(currentState, updatedSnapshotsInProgress, updatedDeletions);
                                } else {
                continue;
                snapshotName,
                "cannot snapshot-v2 while a repository cleanup is in-progress in [" + repositoryCleanupInProgress + "]"
                                // normal snapshot
    @Override
                        logger.error("Failed to retrieve metadata for snapshot-v2 {} {} ", repositoryName, snapshotName);
                            final ShardSnapshotStatus finishedStatus = updateSnapshotState.updatedState;
    }
                            // No shards can be updated in this snapshot so we just add it as is again
                            finishedShardId,
import org.opensearch.action.support.GroupedActionListener;
                    request.partial(),
        Map<ShardId, ShardSnapshotStatus> knownFailures
                    .stream()
import org.opensearch.cluster.node.DiscoveryNode;
            }
import org.opensearch.cluster.ClusterStateApplier;
                "changed cluster state triggered by [{}] snapshot state updates and resulted in starting " + "[{}] shard snapshots",
                    snapshotId,
    }
    }
                                continue;
                "Cannot start another operation, already running ["
                                    }
                final String updatedRepository = updatedSnapshot.getRepository();
                    );
                if (entry.repository().equals(updatedRepository) == false) {
            private SnapshotsInProgress.Entry newEntry;
                        metaBuilder.put(repo.getSnapshotIndexMetaData(repositoryData, entry.source(), index), false);
        DiscoveryNodes nodes,
                } else {
                        String.join(",", snapshotNames),
            transportService,
        RepositoryData repositoryData,
        }
                    true
                    }
    }
     * <p>
                snapshotChanged = true;
            return Objects.hash(snapshot, shardId, updatedState, repoShardId);
        return indices;
                                }
                    if (outstandingDeletes.isEmpty()) {
                );
                            && deletionsInProgress.getEntries()
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                        .withAddedEntry(newDelete)
        final RepositoryCleanupInProgress repositoryCleanupInProgress = currentState.custom(
        }
     * @param repositoryData current repository data
    private static ShardGenerations buildGenerations(SnapshotsInProgress.Entry snapshot, Metadata metadata) {
        final int attempt = 0;
        Map<String, DataStream> dataStreams = new HashMap<>();
     * @param deleteEntry delete entry to remove from the cluster state
    private static Map<ShardId, ShardSnapshotStatus> shards(
            () -> new ParameterizedMessage(
            @Override
        return remoteStoreIndexShallowCopy;
                            final ShardSnapshotStatus finishedStatus = updateSnapshotState.updatedState;
                    SnapshotDeletionsInProgress.TYPE,
                    getInFlightIndexIds(runningSnapshots, repositoryName),
                }
                    } else {
    private static final String MAX_OUTSTANDING_OPS_KEY = "snapshot.repository.max_outstanding_ops";
        List<SnapshotDeletionsInProgress.Entry> updatedEntries = new ArrayList<>(deletions.getEntries().size());
                logger.error("Failed to pin timestamp for snapshot {} with exception {}", snapshot.getSnapshotId().getName(), e);
        boolean isPartial,
                    .orElse(null);
        for (IndexId index : indices) {
                    // snapshots
                        // the update was already executed on the clone operation it applied to, now we check if it may be possible to
            }
            synchronized (currentlyFinalizing) {
            // them to multiple snapshots by accident
                    // TODO: Restart snapshot on another node?
                        entries.add(entry);
        @Nullable
            throw new RuntimeException(e);
                final SnapshotInfo snapshotInfo = new SnapshotInfo(
                    return currentState;
        }
            );
                if (deletionToRun == null) {
     * Initializes the snapshotting process for clients when Snapshot v2 is enabled. This method is responsible for taking
                    updatedEntries.add(entry.withSnapshots(updatedSnapshotIds));
            protected void doRun() {
     * being the cluster-manager node, then fail all snapshot create and delete listeners executing on this node by delegating to
                            if (shardSnapshotStatus.isActive()) {
                        reusedExistingDelete = true;
                            "[{}] Updating shard [{}] with status [{}]",
        return true;
                        );
        }
                for (IndexId index : entry.indices()) {
        if (snapshotChanged) {
     * and trigger running the next snapshot-delete or -finalization operation available to execute if there is one
                    Priority.NORMAL,
                ),
            }
            // TODO: Relying on repository flag to decide delete flow may lead to shallow snapshot blobs not being taken up for cleanup
        final SnapshotDeletionsInProgress snapshotDeletionsInProgress = state.custom(
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
                        listener.onResponse(null);
                final IndexMetadata indexMetadata = metadata.index(index.getName());
        return Collections.unmodifiableMap(builder);
import org.opensearch.action.ActionRunnable;
            UpdateIndexShardSnapshotStatusRequest request,
                    );
        final ClusterStateUpdateTask clusterStateUpdateTask;
                                // The index name that finished cloning does not exist in the cluster state so it isn't relevant to a
                startCloning(repository, newEntry);
                }
                );
     * Executor that applies {@link ShardSnapshotUpdate}s to the current cluster state. The algorithm implemented below works as described
     * @param snapshot Snapshot to listen for
            logger.trace("[{}] finalizing snapshot in repository, state: [{}], failure[{}]", snapshot, entry.state(), failure);
                            + deleteEntry
    };
            }
                shards.put(shardId, failedState);
        assert repositoryOperations.assertNotQueued(snapshot);
                    state -> stateWithoutSnapshot(state, snapshot),
            failoverFallback.run();
        synchronized boolean isEmpty() {
                "cannot snapshot while a repository cleanup is in-progress in [" + repositoryCleanupInProgress + "]"
                            );
            @Override
                    for (SnapshotDeletionsInProgress.Entry readyDeletion : readyDeletions) {
    }
 *
        updateSnapshotStateTaskKey = clusterService.registerClusterManagerTask(UPDATE_SNAPSHOT_STATE, true);
                            // so we check on a shard level
                    target.getSnapshotId()
            nextEntry = queued.pollFirst();
                    }
    private static List<SnapshotId> matchingSnapshotIds(
                    + " but running snapshots are "
    /**
        long startTime = System.currentTimeMillis();
            TransportService transportService,
                            repositoryData.getGenId(),
         */
        Snapshot target,
    }
     * <p>
                final List<SnapshotsInProgress.Entry> newEntries = new ArrayList<>(runningSnapshots);
     * indices that should be included in the snapshot.
                    }
        final Tuple<SnapshotsInProgress.Entry, Metadata> nextFinalization = repositoryOperations.pollFinalization(repository);
        @Nullable RepositoryData repositoryData,
                logger.trace("adding snapshot completion listener to wait for deleted snapshot to finish");
                                final String indexName = repoShardId.indexName();
            public void validate(T value) {
            logger.trace(
                    e -> {
                    listener.onResponse(null);
     * @param attemptDelete  whether to try and run delete operations that are ready in the cluster state if no
     * ready in the cluster state as a result of this state update.
import org.opensearch.repositories.RepositoryData;
    /**
        String snapshotName
     * A cluster state update that will remove a given {@link SnapshotDeletionsInProgress.Entry} from the cluster state
                createSnapshotPreValidations(currentState, repositoryData, repositoryName, snapshotName);
     * Listeners for snapshot deletion keyed by delete uuid as returned from {@link SnapshotDeletionsInProgress.Entry#uuid()}
                List<SnapshotsInProgress.Entry> entriesForThisRepo = snapshots.entries()
                                }
                                    assert added;
        }, "create_snapshot [" + snapshotName + ']', listener::onFailure);
                    () -> new ParameterizedMessage("failed to remove in progress snapshot v2 state after cluster manager switch {}", e),
                }
        } else {
    /**
     */
            }
     */
            .stream()
            return false;
    }
            }
        final List<SnapshotDeletionsInProgress.Entry> newDeletes = new ArrayList<>();
        @Override
     */
     */
     *
                    executor.execute(ActionRunnable.supply(shardCountListener, () -> {
                    for (final Map.Entry<ShardId, ShardSnapshotStatus> entry : shards.entrySet()) {
                    IndexShardRoutingTable shardRouting = indexShardRoutingTable.shard(shardId.id());
                for (String indexName : allIndices) {
                            .withRemoteStoreIndexShallowCopy(
                        snapshotEntries.add(entry);
     * The next cluster-manager will try handling the missing operations. All we can do is fail all the listeners on this cluster-manager node so that
        List<IndexId> indices,
        @Nullable CleanupAfterErrorListener listener
     * @param attempt         current attempt number (0-based)
    // TODO: It is worth revisiting the design choice of creating a placeholder entry in snapshots-in-progress here once we have a cache
            @Override
                        excludedWarmDfa.add(indexName);
                e
            throws Exception {
        protected abstract void handleListeners(@Nullable List<ActionListener<Void>> deleteListeners);
    @Nullable
            IndexNameExpressionResolver indexNameExpressionResolver
                    // and
        }
                    }, e -> {
                            deleteSnapshotsFromRepository(entry, newState.nodes().getMinNodeVersion());
                        runReadyClone(
            Map<ShardId, ShardSnapshotStatus> shardAssignments = null;
                                leaveRepoLoop(repositoryName);
    }
        }
            }
                        e,
                } catch (InterruptedException e) {
        TimeValue.timeValueMinutes(30).getStringRep(),
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        Tuple<String, String> tokens = getRepoSnapshotUUIDTuple(pinnedEntity);
        private Metadata latestKnownMetaData;
                        ShardGenerations shardGenerations = buildGenerationsV2(newEntry, meta);
        final List<ActionListener<Tuple<RepositoryData, SnapshotInfo>>> listenersToComplete = snapshotCompletionListeners.remove(snapshot);
     * they were started in and an inner loop over the list of shard update tasks.
    }
     * <p>
            // Nothing to do, no nodes removed
        final List<SnapshotsInProgress.Entry> runningSnapshots = snapshots.entries();
                    throw new ConcurrentSnapshotExecutionException(
                    );
            this.repoShardId = repositoryShardId;
                        final ShardSnapshotStatus shardStatusBefore = indexClone.getValue();
     */
                assert runningDeletes.containsAll(deleteListenerKeys) : "Saw deletions listeners for unknown uuids in "
                        "setting ["
        if (tryEnterRepoLoop(repoName)) {
                            }
                logger.info("[{}][{}] creating snapshot-v2 for indices [{}]", repositoryName, snapshotName, indices);
                        );
            // If we didn't have a failure during the snapshot delete we will remove all snapshot ids that the delete successfully removed
            }
        for (SnapshotsInProgress.Entry entry : snapshots.entries()) {
            }
                        snapshotName,
                            changed = true;
                final List<SnapshotsInProgress.Entry> runningSnapshots = snapshots.entries();
                    logger.warn("Did not find expected entry [{}] in the cluster state", cloneEntry);
    );
        return shardSnapshotStatus;
                failSnapshotCompletionListeners(
        @Override
                        }
                                finishedShardId,
                );
            .collect(Collectors.toList());
                    throw new SnapshotException(snapshot, "Aborted on initialization");
    ) {
        private List<SnapshotDeletionsInProgress.Entry> readyDeletions = Collections.emptyList();
                final StepListener<SnapshotInfo> snapshotInfoListener = new StepListener<>();
                            logger.trace("Delete [{}] could not execute directly and was queued", newDelete);
                    cloneSnapshotPinnedTimestamp(
    ) {
        }
        this.threadPool = transportService.getThreadPool();
                public void onResponse(Void unused) {
        }
            removeFailedSnapshotFromClusterState(
            }
                                    final boolean added = reassignedShardIds.add(shardId);
    }
                boolean remoteStoreIndexShallowCopy = remoteStoreShallowCopyEnabled(repository);
                int pathType = clusterService.state().nodes().getMinNodeVersion().onOrAfter(Version.V_2_17_0)
    /**
                            completedWithCleanup.add(abortedEntry);
                && snapshotsInProgress.entries()
        Setting.Property.Dynamic
    /**
                    logger.warn(
    }
     * This method does some pre-validation, checks for the presence of source snapshot in repository data.
            snapshot.clones().forEach((id, status) -> {
                                );
                    deletionsToFail.add(entry.uuid());
                ),
                if (foundId == null) {
        clusterService.submitStateUpdateTask(
import org.opensearch.cluster.ClusterStateUpdateTask;
                    retryOrFailOnClusterManagerFailOver(
            }
    public static final Setting<Integer> MAX_CONCURRENT_SNAPSHOT_OPERATIONS_SETTING = Setting.intSetting(
    private final OngoingRepositoryOperations repositoryOperations = new OngoingRepositoryOperations();
                if (newDelete == null) {
            .filter(pinnedEntity -> isOrphanPinnedEntity(repoName, snapshotUUIDs, pinnedEntity))
            }
            final boolean remoteStoreShallowCopyEnabled = REMOTE_STORE_INDEX_SHALLOW_COPY.get(repository.getMetadata().settings());
        private final Exception e;
                        repositoryName,
        return new Tuple<>(tokens[0], snapUUID);
            return UpdateIndexShardSnapshotStatusResponse.INSTANCE;
                }
                });
            assert false : new AssertionError("Unexpected failure during cluster state update", e);
            // SEE https://github.com/opensearch-project/OpenSearch/issues/8610
                UpdateIndexShardSnapshotStatusRequest::new,
                .build();
                    .stream()
                assert false : new AssertionError(
                try {
            }
            ActionListener<UpdateIndexShardSnapshotStatusResponse> listener
                        logger.trace(
                    final Metadata.Builder metaBuilder = Metadata.builder(repo.getSnapshotGlobalMetadata(entry.source()));
            timestampToPin,
                        return;
                public void onFailure(String source, Exception e) {
                logger.warn(
                for (String snapshot : snapshots) {
                    + ":"
     * Finalizes the snapshot in the repository.
            listener.onFailure(new RepositoryException(repositoryName, "cannot create snapshot in a readonly repository"));
                                            )
            shardSnapshotStatus = new ShardSnapshotStatus(primary.currentNodeId(), ShardState.WAITING, shardGeneration);
                assert clones == null : "Should not have updated clones when updating shard snapshots but saw "
        }
                || (latestKnownMetaData != null && snapshotsToFinalize.isEmpty() == false)
import java.util.concurrent.CopyOnWriteArrayList;
            repository.getRepositoryData(ActionListener.wrap(repositoryData -> {
 */
                ActionListener.wrap(snapshot -> addListener(snapshot, ActionListener.map(listener, Tuple::v2)), listener::onFailure)
                failSnapshotCompletionListeners(snapshot, failure);
                logger.info(() -> new ParameterizedMessage("Failed to start snapshot clone [{}]", cloneEntry), e);
                        }
                        finalizeSnapshotEntry(entry, metadata, repositoryData);
            .collect(Collectors.toList())) {
    private final ClusterManagerTaskThrottler.ThrottlingKey createSnapshotTaskKey;
                );
                });
     * @param request snapshot request
            logger.error("Snapshot {} clone failed with exception {}", snapshot.getSnapshotId().getName(), e);
     * {@link SnapshotsInProgress#entries()} and {@link SnapshotDeletionsInProgress#getEntries()}.
                && entry.state() == SnapshotDeletionsInProgress.State.WAITING
                // and the files the restore depends on would all be gone
                            logger.error("Failed to finalize snapshot repo {} for snapshot-v2 {} ", repositoryName, snapshotName);
    public void executeClone(CloneSnapshotRequest request, ActionListener<Void> listener) {
                } else {
        if (snapshotName.contains(" ")) {
                public void onFailure(String source, Exception e) {
            @Override
     * below:
                if (deletionsInProgress.getEntries().stream().anyMatch(entry -> entry.getSnapshots().contains(sourceSnapshotId))) {
        final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE);
        final Snapshot targetSnapshot = cloneEntry.snapshot();
                if (state.failed()) {
                    logger.error("Interrupted while waiting for snapshot info processing", e);
            @Override
import org.apache.logging.log4j.LogManager;
                        new SnapshotException(snapshot, "Failed to remove snapshot from cluster state", e)
            if (entry.snapshot().getRepository().equals(repository) == false) {
                        repositoryData.getGenId(),
                if (request.partial() == false) {
            return;
                        return Tuple.tuple(index, metadata.getNumberOfShards());
    private void endSnapshot(SnapshotsInProgress.Entry entry, Metadata metadata, @Nullable RepositoryData repositoryData) {
        RepositoryData repositoryData,
                        if (entry.isClone()) {
                initializingClones.remove(targetSnapshot);
                e -> handleFinalizationFailure(e, entry, repositoryData)
     * @param deleteEntry       delete entry in cluster state
                    logger.trace(
                snapshotInfoListener.whenComplete(snapshotInfo -> {
            if (shardStatus.equals(ShardSnapshotStatus.UNASSIGNED_QUEUED)) {
                        );
                            // Adding the snapshot to #endingSnapshots since we still have to resolve its listeners to not trip
                );
                boolean isSnapshotV2 = SHALLOW_SNAPSHOT_V2.get(repository.getMetadata().settings());
                    request.indicesOptions(),
            clusterStateUpdateTask = new RemoveSnapshotDeletionAndContinueTask(deleteEntry, repositoryData) {
                        return abortedEntry;
                        }
                    ActionListener.wrap(updatedRepoData -> {
        final StepListener<SnapshotInfo> snapshotInfoListener = new StepListener<>();
                                endSnapshot(entry, newState.metadata(), null);
                                }
            return true;
                        statesToUpdate = EnumSet.of(State.STARTED, State.ABORTED);
                            if (shards == null) {
                    final Optional<SnapshotDeletionsInProgress.Entry> foundDuplicate = deletionsInProgress.getEntries()
            }
 *
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "must be lowercase");
                && ExceptionsHelper.unwrap(e, FailedToCommitClusterStateException.class) != null) {
                        deletionToRun = entry;
                        "[{}][{}] excluding [{}] warm-tiered pluggable data format index(es) from snapshot v2 (not currently supported)",
        Setting.Property.NodeScope,
            }
                }
            .indices()
                        public void onFailure(Exception e) {
                    .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(new ArrayList<>(newEntries)))
                for (Iterator<List<ActionListener<Void>>> iterator = snapshotDeletionListeners.values().iterator(); iterator.hasNext();) {
     *
                ),
            }
        synchronized Tuple<SnapshotsInProgress.Entry, Metadata> pollFinalization(String repository) {
        // Delete uuids to fail because after the state update
                    });
        final String repoName = request.repository();
                transportService,
                        changedCount++;
                }
        logger.debug("remote_store_index_shallow_copy setting is set as [{}]", remoteStoreIndexShallowCopy);
                    snapshots,
        for (SnapshotDeletionsInProgress.Entry entry : deletions.getEntries()) {
                            updatedSnapshotEntries.add(snapshot);
            SnapshotDeletionsInProgress.TYPE,
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "snapshot with the same name is already in-progress");
import static org.opensearch.snapshots.SnapshotUtils.validateSnapshotsBackingAnyIndex;
        ClusterState state,
                } else {
                            new Snapshot(repoName, snapshotId),
                            ActionListener.wrap(updatedRepoData -> {
                    currentState,
                for (SnapshotId snapshotId : snapshotIds) {
            .filter(e -> e.partial() == false)
        for (IndexId index : indices) {
                    e
                assert isPartial : "Data stream [" + dataStreamName + "] was deleted during a snapshot but snapshot was not partial.";
                // Store newSnapshot here to be processed in clusterStateProcessed
                        e
        return builder.build();
        for (SnapshotId snapshotId : snapshotIds.stream()
                newEntries.add(newEntry);
                    + " on this repository to take a full or shallow v1 snapshot instead. Offending indices: "
                }
     * transport requests return and we don't leak listeners.
        protected final SnapshotDeletionsInProgress.Entry deleteEntry;
        // retries
                }
                }
                            logger.trace("starting shard that we were waiting for [{}] on node [{}]", shardId, shardStatus.nodeId());
        /**
                return request.clusterManagerNodeTimeout();
     *
                                        leaveRepoLoop(repositoryName);
                    // The update applied to a shard clone operation
        ensureSnapshotNameNotRunning(runningSnapshots, repositoryName, snapshotName);
                    if (repositoryData != null) {
import org.opensearch.repositories.Repository;
     * Removes a {@link SnapshotDeletionsInProgress.Entry} from {@link SnapshotDeletionsInProgress} in the cluster state after it executed
import org.opensearch.cluster.routing.ShardRouting;
                }
        }
        if (attempt >= maxRetries) {
     * causes another operation to become ready can execute.
                } else {
                    if (clone.getValue().state() == ShardState.INIT) {
                } else {
    }
        }
                }
                            clones = new HashMap<>(entry.clones());
            update,
                    failSnapshotCompletionListeners(
        Metadata metadata,
                    + shards;
            minCompatVersion = minCompatVersion.before(known) ? minCompatVersion : known;
                                logger.info("snapshots {} deleted", snapshotsWithPinnedTimestamp);
            // don't allow shallow snapshots if compatibility mode is not strict
        final int inProgressOperations = snapshotsInProgress.entries().size() + deletionsInProgress.getEntries().size();
            private SnapshotDeletionsInProgress.Entry deletionToRun;
        for (String snapshotOrPattern : snapshotsOrPatterns) {
                // Entry is writing to the repo because it's writing to a shard on a data node or waiting to do so for a concrete shard
                            repositoryData.getGenId(),
        if (orphanPinnedEntities.isEmpty()) {
            private List<String> indicesForSnapshot;
        public ClusterTasksResult<ShardSnapshotUpdate> execute(ClusterState currentState, List<ShardSnapshotUpdate> tasks)
            return false;
        }
                        deleteEntry.getSnapshots(),
                        () -> createStateWithoutSnapshotV2Task(source, attempt + 1),
        }
        ShardSnapshotUpdate(Snapshot snapshot, RepositoryShardId repositoryShardId, ShardSnapshotStatus updatedState) {
                    threadPool.absoluteTimeInMillis(),
    ) {
                }
                                final ShardSnapshotStatus finishedStatus = updateSnapshotState.updatedState;
                                new ShardSnapshotStatus(shardRouting.primaryShard().currentNodeId(), shardStatus.generation())
         */
            if (repositoryData == null) {
                                .noneMatch(
        }, "create_snapshot [" + snapshotName + ']', listener::onFailure);
        public ClusterState execute(ClusterState currentState) {
        @Nullable org.opensearch.index.engine.dataformat.DataFormatRegistry dataFormatRegistry
                    }, ex -> removeSnapshotDeletionFromClusterState(deleteEntry, ex, repositoryData))
                    throw new IllegalArgumentException(
                    newState.metadata(),
        if (snapshotsInProgress == null && snapshotDeletionsInProgress == null) {
                if (remoteStoreIndexShallowCopy
            public ClusterState execute(ClusterState currentState) {
                        createDeleteStateUpdate(outstandingDeletes, repoName, result.v1(), Priority.IMMEDIATE, listener)
        }
     * @return true if entry is currently writing to the repository
     * @param repository          repository id
    private void startCloning(Repository repository, SnapshotsInProgress.Entry cloneEntry) {
                        logger.trace(
                                                snapshotName,
        if (snapshotsInProgress != null) {
     * @param minNodeVersion minimum node version in the cluster
                        }
            );
import java.util.function.Consumer;
                                    logger.info("snapshot-v2 clone [{}] completed successfully", snapshot);
     * @return list of metadata for currently running snapshots
            @Override
                    Priority.IMMEDIATE,
                    if (repositoryData.getSnapshots(indexId).contains(sourceSnapshotId)) {
            this.userCreateSnapshotListener = userCreateSnapshotListener;
        synchronized boolean assertConsistent() {
                        }
    private void createSnapshotPreValidations(
        }
                            }
        @Override
     * Removes record of running snapshot from cluster state and notifies the listener when this action is complete. This method is only
                        if (shardRouting != null && (shardRouting.started() || shardRouting.unassigned())) {
                    runNextQueuedOperation(repositoryData, repository, false);
    /**
    // Set of currently initializing clone operations
            this.failure = failure;
                for (Snapshot snapshot : snapshotsToFail) {
                        @Override
     */
    }
                    if (entry.state().completed() == false) {
                if (repository.isReadOnly()) {
/*
    }
        boolean remoteStoreIndexShallowCopy
                        repository.deleteSnapshotsAndReleaseLockFiles(
                    final Map<String, Map<ShardId, ShardSnapshotStatus>> knownFailures = new HashMap<>();
        int attempt,
                            "Indices don't have primary shards " + missing
            getPinningEntity(snapshot.getRepository(), snapshot.getSnapshotId().getUUID()),
                repository.finalizeSnapshot(
        final Set<String> removedNodeIds = removedNodes.stream().map(DiscoveryNode::getId).collect(Collectors.toSet());
                    repoShardId,
     *
            .filter(entry -> entry.repository().equals(repositoryName))
            public ClusterState execute(ClusterState currentState) {
            return;
        remoteStorePinnedTimestampService.cloneTimestamp(
            handleListeners(deleteListeners);
        }
     * Computes the exponential backoff for a given attempt. The shift is capped to avoid overflow and the resulting
                        if (indexShardRoutingTable == null) {
        return true;
                    }
            logger.warn(
            final List<ActionListener<Void>> deleteListeners;
                        + finalization.v1()
                );
                    if (event.indexRoutingTableChanged(shardId.getIndexName())) {
            Map<String, IndexId> indicesLookup = null;
        String source,
        final Map<ShardId, ShardSnapshotStatus> shards = new HashMap<>();
                    listener.onFailure(e);
        if (changed) {
    private void removeSnapshotDeletionFromClusterState(
    }
                newEntries.add(newEntry);
                    deletionsWithoutSnapshots(
                                "Received clone shard snapshot status update [{}] but this shard is not tracked in [{}]",
                        } catch (IOException e) {
import org.opensearch.common.unit.TimeValue;
    protected void doClose() {
    /**
                        );
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                        Collections.singletonList(snapshot.getSnapshotId()),
        return builder.build();
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
 *
                final List<String> allIndices = new ArrayList<>(currentState.metadata().indices().keySet());
import java.util.List;
                                if (initializingClones.contains(snapshot.snapshot())) {
    private static final class OngoingRepositoryOperations {
        }
     * {@link SnapshotDeletionsInProgress}.
                }
                    .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(new ArrayList<>(newEntries)))
                                + finishedStatus.nodeId()
        /**
        SnapshotsInProgress snapshots = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                                shards = new HashMap<>(entry.shards());
                    for (final SnapshotsInProgress.Entry snapshot : snapshots.entries()) {
    }
                                }
        // Short circuit to noop state update if there isn't anything to delete
            logger.debug(() -> new ParameterizedMessage("[{}] failed to update cluster state during snapshot finalization", snapshot), e);
    private static boolean assertNoDanglingSnapshots(ClusterState state) {
    private final Set<Snapshot> endingSnapshots = Collections.synchronizedSet(new HashSet<>());
                        deletions,
            shardSnapshotStatus = new ShardSnapshotStatus(primary.currentNodeId(), shardGeneration);
                failure
                    failListenersIgnoringException(snapshotDeletionListeners.remove(delete), failure);
    public static Set<String> snapshottingDataStreams(final ClusterState currentState, final Set<String> dataStreamsToCheck) {
            .filter(entry -> entry.state() == SnapshotDeletionsInProgress.State.STARTED)
                    endingSnapshots.stream()
        assert failure != null : "Failure must be supplied";
        final GroupedActionListener<Tuple<IndexId, Integer>> shardCountListener = new GroupedActionListener<>(
                entry.snapshot(),
                // cluster-manager
                            // current entry is a snapshot operation so we must translate the repository shard id to a routing shard id
            .stream()
                            entry -> entry.repository().equals(repoName)
        IndexNameExpressionResolver indexNameExpressionResolver,
            if (entry.snapshot().equals(snapshot)) {
        CleanupAfterErrorListener(ActionListener<Snapshot> userCreateSnapshotListener, Exception e) {
                repoShardId,
                initializingClones.remove(targetSnapshot);
    /**
            clusterService,
                            // without having to do any additional cleanup.
                    request.indicesOptions(),
            if (!(other instanceof ShardSnapshotUpdate that)) {
                    newEntry.userMetadata(),
     * @param listener listener
            }
import java.util.Optional;
        Setting.Property.NodeScope,
        final SnapshotId snapshotId = new SnapshotId(snapshotName, UUIDs.randomBase64UUID()); // new UUID for the snapshot
    private static boolean waitingShardsStartedOrUnassigned(SnapshotsInProgress snapshotsInProgress, ClusterChangedEvent event) {
                        break;
                if (knownFailure == null) {
        validate(repositoryName, snapshotName);
     * Stop polling for ready snapshot finalizations or deletes in state {@link SnapshotDeletionsInProgress.State#STARTED} to execute
                    SnapshotDeletionsInProgress.EMPTY
                            }
     * it then it will update the state of the snapshot entry accordingly. If that update was a noop, then the task is removed from the
     *
            ClusterService clusterService,
                        );
                if (repositoryData.getGenId() == RepositoryData.UNKNOWN_REPO_GEN) {
    private static <T> void completeListenersIgnoringException(@Nullable List<ActionListener<T>> listeners, T result) {
            )
                final SnapshotsInProgress updatedSnapshots = SnapshotsInProgress.of(snapshots.entries().stream().map(existing -> {
                        indices.add(indexMetadata.getIndex());
            logger.info(
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;
                new SnapshotException(snapshot, "Aborted on initialization"),
     * Remove a snapshot from {@link #endingSnapshots} set and return its completion listeners that must be resolved.
                        throw new SnapshotException(
                            "failed to update snapshot state after shards started or nodes removed from [{}] ",
     * cluster-manager) or falling back to the existing failover behavior. Without this, a publish failure on a stable
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "cannot be empty");
                    snapshotEntries.stream().map(e -> e.snapshot().getSnapshotId()).collect(Collectors.toList()),
                }
            }
        assert this.updateSnapshotStatusHandler != null;
            logger.warn("Retry scheduling rejected for [{}], falling back to failover handling", source);
            repoShardId = null;
                        if (clones == null) {
                            new ActionListener<RepositoryData>() {
                final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                        rData -> threadPool.executor(ThreadPool.Names.SNAPSHOT).execute(ActionRunnable.supply(metadataListener, () -> {
        @Override
            clusterService.addLowPriorityApplier(this);
import org.opensearch.threadpool.ThreadPool;
            .stream()
                final List<String> dataStreams = indexNameExpressionResolver.dataStreamNames(
            private List<SnapshotId> outstandingDeletes;
            public void onFailure(String source, Exception e) {
                                    currentState.metadata(),
            @Override
                                );
                                    new SnapshotException(snapshot, "Aborting snapshot-v2, no longer cluster manager")
                ).getEntries()) {
        protected String executor() {
    }
        ClusterState result = state;
                    return res;
        validate(repositoryName, snapshotName);
                        if (tryEnterRepoLoop(entry.repository())) {
                    );
                    ).getEntries()) {
                        }
            }
                            "cannot delete snapshot during a restore in progress in [" + restoreInProgress + "]"
        final long delayMillis = Math.max(0L, Math.min(base.millis() * (1L << Math.min(attempt, 30)), TimeValue.timeValueDays(1).millis()));
    private final Set<String> currentlyFinalizing = Collections.synchronizedSet(new HashSet<>());
        boolean startDeletion(String deleteUUID) {
                    final ClusterState res = readyDeletions(
                    }
     * @param repositoryData repository data or {@code null} when cleaning up a BwC snapshot that never fully initialized
            .filter(ds -> dataStreams.containsKey(ds) && dataStreamsToCheck.contains(ds))
                            repoShardId,
        return builder.dataStreams(dataStreams).build();
    static boolean isOrphanPinnedEntity(String repoName, Collection<String> snapshotUUIDs, String pinnedEntity) {
                    completeListenersIgnoringException(deleteListeners, null);
                    Collections.emptyList(),
                final ShardSnapshotUpdate updateSnapshotState = iterator.next();
         * @param currentState     current cluster state
     */
        if (listeners != null) {
                        // start a shard snapshot or clone operation on the current entry
     */
        } else {
        if (deletions.hasDeletionsInProgress() == false) {
                        // snapshots
                removeFailedSnapshotFromClusterState(snapshot, e, repositoryData, null);
        "snapshot.max_concurrent_operations",
                listener.onFailure(e);
                            }
         * Invoke snapshot delete listeners for {@link #deleteEntry}.
            } else {
    }
    // Return in-progress snapshot entries by name and repository in the given cluster state or null if none is found
                    final Snapshot target = updatedEntry.snapshot();
        return new ClusterStateUpdateTask() {
                            finishedShardId,
                            logger.warn("Failed to get index-metadata from repository data for index [{}]", repoShardId.index().getName());
        @Override
    public static final String SNAPSHOT_PINNED_TIMESTAMP_DELIMITER = "__";
                            + "] cannot be modified while feature flag ["
                final List<String> indicesForSnapshot = new ArrayList<>();
        return changed ? SnapshotDeletionsInProgress.of(updatedEntries) : null;
                }
        IO_TIMEOUT_KEY,
                primary.currentNodeId(),
     * @param listener snapshot creation listener
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
            }
        try {
                        executedTasks.add(updateSnapshotState);
    ) {
            );
        }, "delete snapshot", listener::onFailure);
                            leaveRepoLoop(repositoryName);
        try {
                .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(unmodifiableList(entries)))
    }
            return;
                @Override
                && Objects.equals(this.shardId, that.shardId)
                    } else if (executedTasks.contains(updateSnapshotState)) {
                            .stream()
            if (entry.repository().equals(repositoryName) && Regex.simpleMatch(snapshotNames, entry.snapshot().getSnapshotId().getName())) {
                    return updatedDeletions == null ? deletions : updatedDeletions;
                    // If we are reacting to a change in the cluster node configuration we have to update the shard states of both started
    /**
                    repositoryData.getGenId(),
        Supplier<ClusterStateUpdateTask> taskFactory,
                repositoryOperations.clear();
            if (newFinalization) {
                            return true;
            final Set<ShardId> reassignedShardIds = new HashSet<>();
                    leaveRepoLoop(repositoryName);
     * upload any shard metadata to the snapshot repository.
                newEntry = SnapshotsInProgress.startedEntry(
    protected void doStart() {
                    final List<ActionListener<Void>> listeners = iterator.next();
        RepositoryData repositoryData,
                final List<SnapshotId> updatedSnapshotIds = new ArrayList<>(entry.getSnapshots());
        }
        final Map<String, SnapshotId> allSnapshotIds = repositoryData.getSnapshotIds()
        }
                    updatedState,
                            listener.onResponse(snapshotInfo);
                            logger.info("created snapshot-v2 [{}] in repository [{}]", repositoryName, snapshotName);
                    public void onFailure(Exception e) {}
                        // unless there is an executing snapshot delete already. If there is an executing snapshot delete we don't have to
                            entry.source(),
        @Override
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                        changed = true;
                            clones.put(finishedShardId, new ShardSnapshotStatus(finishedStatus.nodeId(), finishedStatus.generation()));
                            if (reposWithRunningDeletes.contains(entry.repository()) == false) {
                            // If the lookup finds the index id then at least the entry is concerned with the index id just updated
import org.apache.logging.log4j.Logger;
                            null,
                );
                    try {
            if (snapshots.isEmpty() == false) {
     * reason, remove the snapshot's {@link SnapshotsInProgress.Entry} from the cluster state and move on with other queued snapshot
        int changedCount = 0;
        List<SnapshotsInProgress.Entry> runningSnapshots,
    private void addListener(Snapshot snapshot, ActionListener<Tuple<RepositoryData, SnapshotInfo>> listener) {
            builder.putCustom(SnapshotsInProgress.TYPE, snapshotsInProgress);
        }
        final Map<String, Object> userMeta = repository.adaptUserMetadata(request.userMetadata());
                failAllListenersOnMasterFailOver(e);
            } else {
                    newState,
                entry.remoteStoreIndexShallowCopy(),
                }
        return currentlyFinalizing.add(repository);
    }
            if (entry.repository().equals(repository)) {
            final boolean isNewIndex = repositoryData.getIndices().containsKey(indexName) == false;
                );
        List<IndexId> indices,
                    final String inFlightGeneration = inFlightShardStates.generationForShard(index, shardId.id(), shardGenerations);
            }
     * last remote segment metadata at or before the timestamp and then replays the remote translog to close the gap.
                logger.trace("[{}][{}] creating snapshot for indices [{}]", repositoryName, snapshotName, indices);
        if (snapshot.isClone()) {
     */
                                        listener.onFailure(
                        }
            createSnapshot(
        if (removedNodes.isEmpty()) {
                            .filter(snapshot -> snapshot.remoteStoreIndexShallowCopyV2() == false)
        }
                        final SnapshotsInProgress.Entry abortedEntry = existing.abort();
                if (isSnapshotV2 && remoteStoreIndexShallowCopy && entriesForThisRepo.isEmpty() == false) {
                                finishedStatus.nodeId(),
                assert snapshotDeletionListeners.isEmpty() : "No new listeners should have been added but saw " + snapshotDeletionListeners;
                                    if (updatedSnapshot.state().completed()) {
            )
     * Returns the data streams that are currently being snapshotted (with partial == false) and that are contained in the
        });
                @Override
        MAX_OUTSTANDING_OPS_KEY,
    }
                SnapshotDeletionsInProgress.TYPE,
            final Deque<SnapshotsInProgress.Entry> queued = snapshotsToFinalize.get(repository);
                            );
                processExternalChanges(
                        listener.onFailure(
        @Nullable
            throw new RepositoryMissingException(repositoryName);
                        }
            .collect(Collectors.toList());
    }
            logger.warn("Failed to update snapshot state ", e);
            snapshotsToFinalize.computeIfAbsent(entry.repository(), k -> new LinkedList<>()).add(entry);
        public void onFailure(String source, Exception e) {
                    if (indexMetadata != null && indicesToCheck.contains(indexMetadata.getIndex())) {
        // index.replication.type, and this runs over every index in the cluster rather than one being created.
                    if (activeCloneSources.contains(snapshotId)) {
import org.opensearch.cluster.metadata.RepositoriesMetadata;
                    sourceSnapshot,
        List<IndexId> indices
                }
            public void onFailure(String source, Exception e) {
     * Package private for testing
                                if (snapshotInfo.getPinnedTimestamp() > 0) {
                                logger.info("snapshots {} deleted", snapshotsWithLockFiles);
                final List<SnapshotsInProgress.Entry> newEntries = new ArrayList<>(runningSnapshots);
                    newDelete = replacedEntry.withAddedSnapshots(snapshotIdsRequiringCleanup);
                    }
    private void handleFinalizationFailure(Exception e, SnapshotsInProgress.Entry entry, RepositoryData repositoryData) {
            private boolean abortedDuringInit = false;
        final Consumer<Exception> onFailure = e -> {
     * entries since it can not have any further effects.
        assert currentlyFinalizing.contains(entry.repository());
        return snapshots.entries()
    private void updateSnapshotPinnedTimestamp(Snapshot snapshot, long timestampToPin) throws Exception {
            private Snapshot runningSnapshot;
                    snapshotNames,
     */
        return translogRepository == null || translogRepository.isEmpty();
                logger.warn(() -> new ParameterizedMessage("[{}][{}] failed to create snapshot-v2", repositoryName, snapshotName), e);
            return true;
        protected void clusterManagerOperation(
            .filter(excluded == null ? sn -> true : sn -> excluded.contains(sn) == false)
            this.repository = repository;
                    if (listener != null) {
                            entry.snapshot(),
            @Override
            @Override
                : currentState,
import org.opensearch.transport.TransportService;
                    // a node leaving or shard becoming unassigned for one snapshot, we will also fail it for all subsequent enqueued
                if (enteredRepoLoop) {
                            snapshotIdsRequiringCleanup.remove(existingNotYetStartedSnapshot.getSnapshotId());
            // Check this snapshot against the query
                            repositoryData.getVersion(sourceSnapshotId),
 * the Apache License, Version 2.0 (the "License"); you may
                final SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(
        return minCompatVersion;
            new ShardSnapshotUpdate(
            public void clusterStateProcessed(String source, ClusterState oldState, final ClusterState newState) {
            private SnapshotsInProgress.Entry newEntry;
            @Override
     *
import org.opensearch.common.SetOnce;
                            if (updatedEntry != null && updatedEntry.state().completed()) {
            @Override
                }
                    throw new ConcurrentSnapshotExecutionException(
                final List<SnapshotsInProgress.Entry> runningSnapshots = snapshots.entries();
import java.util.stream.Stream;
                        }
                    pathType
            public ClusterState execute(ClusterState currentState) {
import java.util.concurrent.CountDownLatch;
        Setting.Property.NodeScope,
                    repository.getRepositoryData(ActionListener.wrap(repositoryData -> {
                for (SnapshotsInProgress.Entry entry : snapshots.entries()) {
        final String snapshotName = indexNameExpressionResolver.resolveDateMathExpression(request.snapshot());
        repository.executeConsistentStateUpdate(repositoryData -> new ClusterStateUpdateTask() {
                    latch.await();
            failAllListenersOnMasterFailOver(e);
     * Deletes snapshots from the repository. In-progress snapshots matched by the delete will be aborted before deleting them.
    public static List<SnapshotsInProgress.Entry> currentSnapshots(
                    newClusterManager || removedNodesCleanupNeeded(snapshotsInProgress, event.nodesDelta().removedNodes()),
        ActionListener<Void> listener = new ActionListener<>() {
                    null,
        final String source = "remove snapshot metadata";
                    if (inFlightGeneration == null && isNewIndex) {
        SnapshotId sourceSnapshot,
                    } else {
                    repositoryOperations.finishDeletion(delete);
        } catch (Exception e) {
                    // Removing shallow snapshots v2 as we we take care of these in stateWithoutSnapshotV2()
                                updateSnapshotState,
        assert repositoryOperations.isEmpty() : "Found leaked snapshots to finalize " + repositoryOperations + " on [" + localNode + "]";
        ActionFilters actionFilters,
                    // if no failure is known for the shard we keep waiting
    /**
                            "delete snapshot",
            );
            removeFailedSnapshotFromClusterState(snapshot, e, repositoryData, null);
                    // Snapshot v2 create and clone are sync operation . In case of cluster manager failures in midst , we won't
        final Set<String> reposWithRunningDelete = snapshotDeletionsInProgress.getEntries()
                    .build();
     * Returns the indices that are currently being snapshotted (with partial == false) and that are contained in the indices-to-check set.
            }
     * </p>
        void finishDeletion(String deleteUUID) {
            }
                            clone.getValue(),
                        if (endingSnapshots.contains(update.snapshot) == false) {
            @Override
        initializingClones.add(snapshot);
            assert pinnedEntities.get(pinnedEntity).size() == 1 : "Multiple timestamps for same repo-snapshot uuid found";
                                + localNodeId
            .collect(Collectors.toMap(IndexId::getName, Function.identity()));
                            sourceSnapshot,
            runningDeletions.clear();
import org.opensearch.repositories.ShardGenerations;
            }
                } finally {
     * Only modifiable when the snapshot resilience feature flag is enabled.
                                "Aborting clone for Snapshot-v2, only wildcard pattern '*' is supported for indices"
                SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
            if (dataStream == null) {
                            if (existingStatus == null || existingStatus.state() != ShardState.QUEUED) {
        Priority priority,
            if (attemptDelete) {
                }
            .stream()
                        if (delete.state() == SnapshotDeletionsInProgress.State.STARTED) {
                            + "] but it is not blocked by any running delete";
                            snapshotEntries.add(entry);
            return changed ? SnapshotsInProgress.of(snapshotEntries) : null;
                    .filter(se -> se.repository().equals(repo))
                    SnapshotDeletionsInProgress.EMPTY
    public void executeSnapshot(final CreateSnapshotRequest request, final ActionListener<SnapshotInfo> listener) {
                    snapshots = SnapshotsInProgress.of(
                return currentState;
                // have their snapshots finalizing (those that are already finalizing will fail on their own from to update the cluster
    /**
            ShardId shardId = shardEntry.getKey();
                    listener.onFailure(e);
            assert false : new AssertionError(e);
                        shardRepoGeneration = ShardGenerations.NEW_SHARD_GEN;
                }
            // Snapshots that had all of their shard snapshots in queued state and thus were removed from the
                                    failAllListenersOnMasterFailOver(e);
 * Licensed to Elasticsearch under one or more contributor
     */
                );
        final Snapshot snapshot = new Snapshot(repositoryName, snapshotId);
                                    snapshotsInProgress,
            this.e = e;
            @Override
                        final boolean remoteStoreIndexShallowCopy = Boolean.TRUE.equals(entry.remoteStoreIndexShallowCopy());
     * @param entry snapshot entry
import org.opensearch.cluster.routing.IndexRoutingTable;
            return new ClusterStateUpdateTask() {
                } else {
            return;
                                public void onFailure(Exception e) {
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        final Settings settings = indexMetadata.getSettings();
                            missing.add(entry.getKey().getIndex().getName());
     */
                } else {
     * @param request snapshot request
                                shards = new HashMap<>(entry.shards());
                    if (entry.snapshot().getSnapshotId().equals(updatedSnapshot.getSnapshotId())) {
            if (value.isActive()) {
                            // No point in doing noop updates that might happen if data nodes resends shard status after a disconnect.
                        new ShardSnapshotUpdate(target, repoShardId, new ShardSnapshotStatus(localNodeId, ShardState.SUCCESS, generation)),
                        // Just pass the exception to the transport handler as is so it is retried on the new cluster-manager
        final List<IndexId> indices = cloneEntry.indices();
        };
                    if (repoName.equals(entry.snapshot().getRepository()) && snapshotIds.contains(entry.snapshot().getSnapshotId())) {
import org.opensearch.common.util.FeatureFlags;
        }
    }
    /**
        String repository,
    private static SnapshotDeletionsInProgress deletionsWithoutSnapshots(
                if (matchingIndices.isEmpty()) {
                if (listener == null) {
                return Collections.emptyList();
                            );
     * @return updated cluster state
     * {@link SnapshotsInProgress.Entry} from the cluster state once it's done finalizing the snapshot.
                        }
            }
                List<String> indices = Arrays.asList(indexNameExpressionResolver.concreteIndexNames(currentState, request));
     *
                newEntry = SnapshotsInProgress.startedEntry(
                            if (snapshot.isClone() && snapshot.clones().isEmpty()) {
        }
            throw ex.get();
        return Objects.equals(tokens.v1(), repoName) && snapshotUUIDs.contains(tokens.v2()) == false;
                        startTime,
                            metadataForSnapshot(meta, newEntry.includeGlobalState(), false, newEntry.dataStreams(), newEntry.indices()),
        Repository repository = repositoriesService.repository(request.repository());
                            state -> stateWithoutSnapshot(state, snapshot),
     * Checks if the given {@link SnapshotsInProgress.Entry} is currently writing to the repository.
     * given repository from the cluster state and afterwards fails all relevant listeners in {@link #snapshotCompletionListeners} and
                                finishedStatus.generation()
            return emptySet();
        }
            () -> repositoriesService,
            new ClusterStateUpdateTask() {
                    if (newDelete.state() == SnapshotDeletionsInProgress.State.STARTED) {
                new ShardSnapshotStatus(localNodeId, ShardState.FAILED, "failed to clone shard snapshot", null)
    /**
            }
    }
                    true
                        throw new SnapshotMissingException(repositoryName, snapshotOrPattern);
                        SnapshotDeletionsInProgress.EMPTY
        final ShardSnapshotStatus shardSnapshotStatus;
                } else if (state.completed() == false) {
        );
        snapshotResilienceValidator(MAX_OUTSTANDING_OPS_KEY),
                    }
                    final String shardRepoGeneration;
    public static final String UPDATE_SNAPSHOT_STATUS_ACTION_NAME = "internal:cluster/snapshot/update_snapshot_status";
        CloneSnapshotRequest request,
                    );
                if (RestoreService.failed(snapshotInfo, indexId.getName())) {
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SHALLOW_SNAPSHOT_V2;
     */
        }
                            }
     * @param e exception that caused us to realize we are not cluster-manager any longer
                    @Override
                            shardSnapshotStatus = new ShardSnapshotStatus(primary.currentNodeId(), shardRepoGeneration);
                updatedEntry = entry.withShardStates(shards);
                                // started a snapshot and didn't just fail
        );
                            SnapshotsInProgress.EMPTY
                    }
            repositoryDataListener.whenComplete(repositoryData -> {
                }
                .stream()
        return ClusterStateTaskExecutor.ClusterTasksResult.<ShardSnapshotUpdate>builder().successes(tasks).build(currentState);
                    }
                        listener.onFailure(e);
     * @param startShards  true iff any waiting shards were started due to a routing change
            final Tuple<SnapshotsInProgress.Entry, Metadata> res = Tuple.tuple(nextEntry, latestKnownMetaData);
                        ;
                    for (SnapshotDeletionsInProgress.Entry delete : res.custom(
            }
     */
                }, e -> listener.onFailure(e));
                    if (Regex.simpleMatch(snapshotOrPattern, entry.getKey())) {
                final Version minNodeVersion = currentState.nodes().getMinNodeVersion();
            .stream()
            } else {
        executor.execute(new AbstractRunnable() {
                } else {
                    repositoryData.getGenId(),
    private void failCloneShardAndUpdateClusterState(Snapshot target, SnapshotId sourceSnapshot, RepositoryShardId repoShardId) {
            if (this == other) {
        final List<String> segmentsOnlyIndices = state.metadata()
            repoName,
            if (snapshotsToFinalize.isEmpty()) {
    }
import static org.opensearch.repositories.blobstore.BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY;
                                finishedStatus.generation()
        for (final SnapshotsInProgress.Entry entry : snapshots.entries()) {
            // when the repository currently have the flag disabled and we try to delete the shallow snapshots taken prior to disabling
                    dataStreams,
                }
                boolean changed = false;
                    }
     */
            for (final ShardSnapshotStatus shardSnapshotStatus : snapshot.shards().values()) {
        final String repoName = entry.repository();
                            for (IndexId index : newEntry.indices()) {
                            final SnapshotsInProgress.Entry updatedEntry = snapshotsInProgress.snapshot(update.snapshot);
                dataStreams.put(dataStreamName, dataStream);
                    }
        for (SnapshotsInProgress.Entry entry : snapshots.entries()) {
                                }
                        }
 * under the License.
                    .filter(SnapshotsInProgress.Entry::isClone)
            }
     * Determine the number of shards in each index of a clone operation and update the cluster state accordingly.
                        );
    }
                                if (updated == null) {
 * GitHub history for details.
                final SnapshotsInProgress snapshotsInProgress = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                );
                        leaveRepoLoop(repositoryName);
        clusterService.submitStateUpdateTask(
                        () -> new ParameterizedMessage(
                                iterator.remove();
                        if (existing.state().completed()) {
 *
            SnapshotDeletionsInProgress.EMPTY
                            );
            initializingClones.remove(targetSnapshot);
                                finishedShardId,
    /**
            "update snapshot after shards started [" + startShards + "] or node configuration changed [" + changedNodes + "]",
                    }
                            final IndexId indexId = indicesLookup.get(finishedShardId.getIndexName());
                knownFailures.put(shardId, failedState);
                        } else {
                ActionListener.onFailure(listeners, failure);
            } else if (shardStatus.state() == ShardState.WAITING) {
                    pinnedTimestampListener.whenComplete(
     * @param state   current cluster state
                }
                    }, this::onFailure));
        }
import org.opensearch.repositories.RepositoryMissingException;
                        // snapshot is started - mark every non completed shard as aborted
            }
                        }
     * @param snapshot snapshot for which to remove the snapshot operation
        }
            RepositoryCleanupInProgress.TYPE,
            final SnapshotInfo snapshotInfo = new SnapshotInfo(
                                    nodes,
            }
     * @param cloneEntry     clone operation in the cluster state
     */
        }
        // dataFormatRegistry pre-registers DFA formats so cleanup deletes per-format files (e.g., parquet/).
            failoverFallback.run();
    }
            final String indexName = index.getName();
            }
                entry.partial() ? shardGenerations.totalShards() : entry.shards().size(),
                        if (existing.state().completed()) {
            final SnapshotDeletionsInProgress deletions = currentState.custom(SnapshotDeletionsInProgress.TYPE);
        if (snapshotDeletionsInProgress != null) {
    private volatile int maxConcurrentOperations;
                    if (entry.snapshot().getSnapshotId().getName().equals(snapshot)) {
    /**
            dataFormatRegistry
                                    snapshotsWithLockFiles.add(snapshotId);
        }
                        newEntry.userMetadata(),
                                final Map<ShardId, ShardSnapshotStatus> shards = processWaitingShardsAndRemovedNodes(
    private void runReadyDeletions(RepositoryData repositoryData, String repository) {
                    final StepListener<RepositoryData> pinnedTimestampListener = new StepListener<>();
            final SnapshotsInProgress snapshotsInProgress = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
            };
                    }
    }
                            failCloneShardAndUpdateClusterState(target, sourceSnapshot, repoShardId);
            @Override
     */
                final List<String> dataStreams = indexNameExpressionResolver.dataStreamNames(
                addListener(runningSnapshot, ActionListener.wrap(result -> {
                                null,
     * Initial backoff duration for cleanup retries. Each subsequent retry doubles this value.
        if (repository.isReadOnly()) {
                    threadPool.absoluteTimeInMillis(),
                    .findAny()
            clusterService.getClusterSettings().addSettingsUpdateConsumer(SNAPSHOT_CLEANUP_RETRIES_SETTING, i -> maxRetries = i);
                final ShardId shardId = indexRoutingTable.shard(i).shardId();
    }
     * commit and therefore need no translog to restore.
     *
            snapshot.shards().forEach((id, status) -> {
        if (ex.get() != null) {
                changed = true;
                        newEntry.dataStreams(),
        Setting.Property.NodeScope,
     * @param request snapshot request
                }
                }
                }
                    deletionsInProgress,
            final Repository repository = repositoriesService.repository(deleteEntry.repository());
                            if ((snapshot.state().completed() || completed(snapshot.shards().values()))) {
    private static <T> void failListenersIgnoringException(@Nullable List<ActionListener<T>> listeners, Exception failure) {
     */
                boolean changed = false;
        for (final Map.Entry<ShardId, ShardSnapshotStatus> shardEntry : snapshotShards.entrySet()) {
     * This method is used by clients to start snapshot. It makes sure that there is no snapshots are currently running and
                        SnapshotDeletionsInProgress.TYPE,
                            updateSnapshotState.updatedState.state()
        }
                            cleanOrphanTimestamp(repositoryName, repositoryData);
     * report success, since it only pins a timestamp, so the problem would not surface until the snapshot is needed.
                            continue;
    private static ClusterState stateWithoutSnapshot(ClusterState state, Snapshot snapshot) {
    }
                    newState.routingTable(),
        }, "start snapshot clone", onFailure), onFailure);
                final SnapshotId sourceSnapshotId = repositoryData.getSnapshotIds()
                    iterator.remove();
        if (snapshots == null) {
        } else {
    }
     * {@code true} then snapshot finalizations and deletions for the repo may be executed. Once no more operations are
        if (inProgressOperations >= maxOps) {
                entry.userMetadata(),
            } else {
            @Override
                                continue;
            latch.await();
                ? ClusterState.builder(currentState)
            @Override
        String[] tokens = pinningEntity.split(SNAPSHOT_PINNED_TIMESTAMP_DELIMITER);
            public void onFailure(String source, Exception e) {
            maxConcurrentOperations = MAX_CONCURRENT_SNAPSHOT_OPERATIONS_SETTING.get(settings);
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SHARD_PATH_TYPE;
            } else {
                    true,
        if (snapshotIds.isEmpty()) {
                            // Shard that we were waiting for has started on a node, let's process it
import org.opensearch.repositories.IndexId;
                final ClusterState updatedState = stateWithoutSnapshot(currentState, snapshot);
                    (replacedEntry == null ? deletionsInProgress : deletionsInProgress.withRemovedEntry(replacedEntry.uuid()))
                        if (tryEnterRepoLoop(repoName)) {
            if (event.localNodeClusterManager()) {
import org.opensearch.cluster.SnapshotsInProgress;
                if (FeatureFlags.isEnabled(FeatureFlags.SNAPSHOT_RESILIENCE_SETTING)) {
     *
                );
            }
        RepositoriesMetadata repositoriesMetadata = state.getMetadata().custom(RepositoriesMetadata.TYPE);
            logger.debug("[{}] was aborted before starting", snapshot);
         */
     * for the given repository.
        logger.debug("Failing all snapshot operation listeners because this node is not cluster-manager any longer", e);
            this.repositoryData = repositoryData;
                            } catch (Exception e) {
     * repository blob operations per repository. Past this limit, further operations fail fast with a
                                }
     * @param state    current cluster state
                }
                @Override
            }
                    if (existing.state() == State.STARTED && snapshotIdsRequiringCleanup.contains(existing.snapshot().getSnapshotId())) {
     * @param state                       current cluster state
                    return;
                    .stream()
                return updateWithSnapshots(
                );
                // The index was deleted before we managed to start the snapshot - mark it as missing.
     * @return updated cluster state
                            continue;
            threadPool,
    /**
        public final void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    repositoryData,
        }
                    IndexMetadata indexMetadata = currentState.metadata().index(index.getName());
                        sourceSnapshotId,
        1,
                builder.put(new ShardId(indexName, IndexMetadata.INDEX_UUID_NA_VALUE, 0), ShardSnapshotStatus.MISSING);
    /**
                        } else {
        return readyDeletions(result).v1();
        String snapUUID = String.join(SNAPSHOT_PINNED_TIMESTAMP_DELIMITER, Arrays.copyOfRange(tokens, 1, tokens.length));
                for (int i = 0; i < indexMetadata.getNumberOfShards(); i++) {
         *
                final ShardGenerations shardGenerations = buildShardsGenerationFromRepositoryData(
                            listener.onFailure(e);
                            ActionListener.wrap(
            // Entry is writing to the repo because it's finalizing on cluster-manager
    private final ThreadPool threadPool;
                }
        if (entry.repositoryStateId() == RepositoryData.UNKNOWN_REPO_GEN) {
                            .noneMatch(SnapshotsService::isWritingToRepository)
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        );
                            ActionListener.wrap(updatedRepoData -> {
                orphanTimestamp,
            for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
                        + repositoryData.getGenId()
                        snapshotName,
                        runNextQueuedOperation(newRepoData, repository, true);
     * a task in the executed tasks collection applied to a shard it was waiting for to become available, then the shard snapshot operation
        final Repository repository = repositoriesService.repository(repoName);
                @Override
    private final ClusterService clusterService;
                    deleteSnapshotsFromRepository(deletionToRun, repositoryData, newState.nodes().getMinNodeVersion());
            userCreateSnapshotListener.onFailure(ExceptionsHelper.useOrSuppress(e, this.e));
                initializingClones.remove(snapshot);
     */
import java.util.Locale;
                    "shard is unassigned",
                        repoName,
                // move to in progress
            // cluster state right away
    private void cloneSnapshotPinnedTimestamp(
                entries.add(entry);
import java.util.function.Supplier;
    }
    }
        Snapshot snapshot = new Snapshot(repositoryName, snapshotId);
    }
    static void validateNoSegmentsOnlyIndices(ClusterState state, String repositoryName, String snapshotName) {
                    updatedSnapshots,
                        new RepositoryException(repository.getMetadata().name(), "cannot create snapshot-v2 in a readonly repository")
            failAllListenersOnMasterFailOver(e);
    private class UpdateSnapshotStatusAction extends TransportClusterManagerNodeAction<
        FailPendingRepoTasksTask(String repository, Exception failure) {
     * @return true if a finalization or snapshot delete may be started at this point
                } else {
                if (FeatureFlags.isEnabled(FeatureFlags.SNAPSHOT_RESILIENCE_SETTING) == false) {
                        throw new ConcurrentSnapshotExecutionException(
                snapshotsToFinalize.remove(repository);
                : "Should not hold on to metadata if there are no more queued snapshots";
                        );
        }
            @Override
            }
                entry.includeGlobalState(),
                final List<SnapshotsInProgress.Entry> newEntries = new ArrayList<>(runningSnapshots);
                }
                            if (value.getValue().equals(ShardSnapshotStatus.UNASSIGNED_QUEUED)
    ) {
     *
                    snapshotEntries.add(entry);
     * @param failure     failure encountered while executing the delete on the repository or {@code null} if the delete executed
                            logger.trace(
                    shardGenerations.totalShards(),
                                primary.currentNodeId(),
                );
            + " on ["
import java.util.ArrayList;
                            logger.error("Giving up on removing v2 snapshot state after {} attempts", attempt + 1);
                    failSnapshotCompletionListeners(snapshot, new SnapshotException(snapshot, "no longer cluster-manager"));
     * API call. Note that it does not apply to V2-shallow snapshots.
            shardSnapshotStatus = new ShardSnapshotStatus(
    }
        // Snapshots that can be finalized after the delete operation has been removed from the cluster state
        return TimeValue.timeValueMillis(delayMillis);
            repositoriesService.getRepositoryData(repositoryName, repositoryDataListener);
                        }
                    listener.onResponse(repositoryData);
    /**
                    final ShardSnapshotStatus shardSnapshotStatus;
                        clusterService.submitStateUpdateTask(
    private final RepositoriesService repositoriesService;
                        }
                    RoutingTable routingTable = currentState.routingTable();
        return unmodifiableList(new ArrayList<>(foundSnapshots));
        public void onFailure(@Nullable Exception e) {
                                shardRepoGeneration
            threadPool.schedule(() -> clusterService.submitStateUpdateTask(source, taskFactory.get()), delay, ThreadPool.Names.GENERIC);
    public static Set<Index> snapshottingIndices(final ClusterState currentState, final Set<Index> indicesToCheck) {
                builder.put(indexId, id.shardId(), status.generation());
                leaveRepoLoop(repository);
            throw new IllegalArgumentException(
                }
        boolean changed = false;
        @Override
                            assert false : "This should never happen, data nodes should only send updates for expected shards";
                    clusterService.submitStateUpdateTask(
                final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                            logger.error("Failed to update pinned timestamp for snapshot-v2 {} {} ", repositoryName, snapshotName);
            }
                                return;
                            createDeleteStateUpdate(outstandingDeletes, repoName, repositoryData, Priority.IMMEDIATE, listener)
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        SnapshotsInProgress snapshotsInProgress,
            handleFinalizationFailure(e, entry, repositoryData);
        return builder.build();
                                + "] but local node id is ["
            failoverFallback.run();
                final StepListener<SnapshotInfo> snapshotInfoListener = new StepListener<>();
        clusterService.submitStateUpdateTask("Run ready deletions", new ClusterStateUpdateTask() {
                    listener.onResponse(null);
     * @param indices             Indices to snapshot
                    SnapshotDeletionsInProgress.TYPE,
                    .orElseThrow(() -> new SnapshotMissingException(repositoryName, request.source()));
                            "cannot delete snapshot while it is being cloned"
     * Determines the minimum {@link Version} that the snapshot repository must be compatible with from the current nodes in the cluster
                continue;
        );
                                        + "]";
                    assert isPartial : "Index [" + index + "] was deleted during a snapshot but snapshot was not partial.";
                        logger.warn("Exception [{}] while trying to clone shard [{}]", e, repoShardId);
            changed
            .collect(Collectors.toSet());
    static final ClusterStateTaskExecutor<ShardSnapshotUpdate> SHARD_STATE_EXECUTOR = new ClusterStateTaskExecutor<ShardSnapshotUpdate>() {
                    version,
        }
    ) {
    }
                            final ShardSnapshotStatus finishedStatus = updateSnapshotState.updatedState;
import java.util.Arrays;
                                        repoShardId,
                    repositoryData.resolveIndices(indicesForSnapshot),
        endingSnapshots.remove(snapshot);
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
         * Clear all state associated with running snapshots. To be used on cluster-manager-failover if the current node stops
    private ClusterStateUpdateTask createDeleteStateUpdate(
    private static void validate(final String repositoryName, final String snapshotName) {
                final String repoName = cloneEntry.repository();
                            final ShardSnapshotStatus existingStatus = entry.shards().get(finishedShardId);
            final SnapshotDeletionsInProgress updatedDeletions = changed ? SnapshotDeletionsInProgress.of(updatedEntries) : null;
        return snapshotsInProgress.entries().stream().anyMatch(snapshot -> {
        }
                changed = true;
                    final ShardSnapshotStatus failedState = new ShardSnapshotStatus(
                            getCloneCompletionListener(localNodeId)
                    // retry these kinds of issues so we fail all the pending snapshots
                        // We applied the update for a shard snapshot state to its snapshot entry, now check if we can update
                                    repoShardId,
                            // shard snapshot was completed, we check if we can start another snapshot
                            logger.trace(
    private final Set<RepositoryShardId> currentlyCloning = Collections.synchronizedSet(new HashSet<>());
            .sorted()
                        } else if (primary.relocating() || primary.initializing()) {
    private boolean remoteStoreShallowCopyEnabled(Repository repository) {
                    + clones
                            if (indicesLookup == null) {
    private static Map<ShardId, ShardSnapshotStatus> processWaitingShardsAndRemovedNodes(
                        + "] in cluster state and ["
                            );
        RepositoriesService repositoriesService,
                    // Entry is for another repository we just keep it as is
        final String translogRepository = settings.get(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY);
     * @param repositoryName snapshot repository name
            indices.size()
        Repository repository,
                    version,
     *
                                    continue;
                        throw new SnapshotException(repositoryName, snapshotName, "Aborting snapshot-v2 clone, no longer cluster manager");
                if (enteredLoop) {
        RoutingTable routingTable,
                        logger.warn("deleted snapshot failed", e);
                    assert shardGenerations.getShardGen(index, shardId.getId()) == null : "Found shard generation for new index ["
                        } else if (snapshot.repositoryStateId() == RepositoryData.UNKNOWN_REPO_GEN) {
                // add the snapshot deletion to the cluster state
        assert assertConsistentWithClusterState(event.state());
                            leaveRepoLoop(repositoryName);
                }
        final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);
                }
                    logger.warn("failing snapshot of shard [{}] on closed node [{}]", shardId, shardStatus.nodeId());
                    SnapshotDeletionsInProgress.TYPE,
                    shardRepoGeneration = shardGenerations.getShardGen(index, shardId.id());
                    }
                    shards.put(shardId, shardStatus);
                return deleteSnapshotTaskKey;
        for (final ShardSnapshotStatus value : entry.shards().values()) {
        }
                            continue;
                    new FailPendingRepoTasksTask(deleteEntry.repository(), e)
            } else {
                    + repositoryName
                                        )
 * not use this file except in compliance with the License.
        );
                }
import org.opensearch.Version;
                        // either a clone or a snapshot
        };
        } catch (InterruptedException e) {
     */
    }
    /**
            super(
                name,
                            // Shard that we were waiting for hasn't started yet or still relocating - will continue to wait
    }
                    + runningDeletes;
import org.opensearch.cluster.SnapshotsInProgress.ShardState;
            }
        );
     * @param failure        exception that failed the snapshot
                    if (shardStatus.getValue().state() != ShardState.WAITING) {
     * @param source          the cluster state update source string
            boolean enteredLoop;
                );
        assert currentlyFinalizing.contains(repository);
    }
        }
                            + "] matched requested pattern ["
                        shardStatus.generation()
    private static void ensureNoCleanupInProgress(ClusterState currentState, String repositoryName, String snapshotName) {
            public ClusterState execute(ClusterState currentState) {
                        );
                    return currentState;
        Setting.Property.Dynamic
            @Override
        String repositoryName
     * @param failoverFallback the existing fallback behavior to run when retries are exhausted or not applicable
                        if (existing == null) {
                        .filter(
        this.clusterService = clusterService;
        }
        private final List<String> deletionsToFail = new ArrayList<>();
            }
                            final ShardId finishedRoutingShardId = new ShardId(indexMeta.getIndex(), finishedShardId.shardId());
    /**
     * {@link #snapshotDeletionListeners}.
                    try {
                    currentState.routingTable(),
                    .stream()
    }
                                    target.getSnapshotId()
                @Override
                        break;
        }
                    + runningSnapshots;
            }
        RemoteStoreSettings remoteStoreSettings,
                }
                entries.add(entry);
            final Version known = repositoryData.getVersion(snapshotId);
                    boolean changed = false;
            indexNameExpressionResolver
import org.opensearch.cluster.block.ClusterBlockException;
                assert repositoryData.getGenId() == expectedRepoGen
                    }
                logger.warn(() -> new ParameterizedMessage("[{}][{}] failed to clone snapshot", repositoryName, snapshotName), e);
     *
                leaveRepoLoop(repository);
     * iteration as it was already applied before and likely just arrived on the cluster-manager node again due to retries upstream.
        final List<SnapshotsInProgress.Entry> entries = new ArrayList<>();
public class SnapshotsService extends AbstractLifecycleComponent implements ClusterStateApplier {
                    if (ExceptionsHelper.unwrap(e, NotClusterManagerException.class, FailedToCommitClusterStateException.class) != null) {
                }
     * indices-to-check set.
                    if (snapshotsWithLockFiles.size() > 0) {
                    // a (non-clone) shard snapshot operation was updated
                logger.warn("Failed to notify listeners", ex);
                            .map(SnapshotDeletionsInProgress.Entry::repository)
        }
            }
        final String repositoryName = request.repository();
     * @param currentState            current cluster state
                    );
                    repositoryData.getGenId(),
                }
                        "Can't clone index [" + indexId + "] because its snapshot was not successful."
                            }
                        listener.onFailure(e);
            for (Iterator<ShardSnapshotUpdate> iterator = unconsumedTasks.iterator(); iterator.hasNext();) {
                        }
                        }
    }
        }
        deleteOrphanTimestamps(pinnedEntities, orphanPinnedEntities);
                return snapshotsInProgress.entries();
                    }
                                removeSnapshotDeletionFromClusterState(deleteEntry, null, updatedRepoData);
                        for (Tuple<IndexId, Integer> count : counts) {
                    SnapshotDeletionsInProgress.EMPTY
        assert snapshotCompletionListeners.isEmpty() : "Found leaked snapshot completion listeners "
            }
            return;
     */
                logger.warn(
                ex.set(e);
                        executedTasks.add(updateSnapshotState);
        Metadata metadata,
        if (entry.state().completed()) {
        private final ShardId shardId;
                            changed = true;
            if (entry.partial() == false) {
                        for (SnapshotsInProgress.Entry completedSnapshot : completedWithCleanup) {
     * @param taskFactory     supplier that creates a NEW task instance per retry (TaskBatcher rejects same-identity resubmit)
import org.opensearch.cluster.ClusterStateTaskExecutor;
            createSnapshotV2(request, listener);
            listener.onFailure(e);
    // Set of snapshots that are currently being ended by this node
                            iterator.remove();
                                @Override
            SnapshotDeletionsInProgress.EMPTY
                            remoteStoreLockManagerFactory,
     * an index created on {@code remote_store.mode: segments_only} nodes is configured.
import org.opensearch.cluster.SnapshotsInProgress.ShardSnapshotStatus;
                    }
     * Setting to specify the maximum number of shards that can be included in the result for the snapshot status
                    } else {
            runningDeletions.remove(deleteUUID);
                                sourceSnapshot,
     * {@link ShardState#WAITING}.
                    stateWithoutSnapshotV2(event.state());
            getPinningEntity(snapshot.getRepository(), snapshot.getSnapshotId().getUUID()),
            }
    /**
        }
                    }
            }
    private void deleteOrphanTimestamps(Map<String, List<Long>> pinnedEntities, List<String> orphanPinnedEntities) {
        if (repositoryOperations.startDeletion(deleteEntry.uuid())) {
                }, e -> {
            // resolve the delete listeners with the latest repository data from after the delete.
        };
            validateNoSegmentsOnlyIndices(clusterService.state(), repositoryName, snapshotName);
        final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                                endSnapshot(updatedEntry, newState.metadata(), null);
            final Repository repo = repositoriesService.repository(snapshot.getRepository());
        if (Strings.validFileName(snapshotName) == false) {
            @Override
            this.shardId = shardId;
     */
     * @param request  snapshot request
                .stream()
                () -> new ParameterizedMessage(
     * @param repositoryData    the {@link RepositoryData} of the repository to delete from
                            + " that should should been deleted by ["
            }
        String repositoryName
        final String snapshotName = indexNameExpressionResolver.resolveDateMathExpression(request.snapshot());
                            + "]"
        if (nextFinalization == null) {
                                }
            public ClusterState execute(ClusterState currentState) {
        // get listeners before removing from the ending snapshots set to not trip assertion in #assertConsistentWithClusterState that
        SetOnce<Exception> ex = new SetOnce<>();
                        cloneSnapshot(request, snapshot, repositoryName, repository, listener);
                if (indexShardRoutingTable != null) {
                    .filter(entry -> entry.repository().equals(repoName) && entry.state() == SnapshotDeletionsInProgress.State.WAITING)
                    snapshot,
            @Override
                } else {
        String repositoryName,
                            remoteStoreLockManagerFactory,
            ThreadPool threadPool,
                    ex -> {
        public boolean isClone() {
                        snapshotName,
     */
     */
                ensureSnapshotNameNotRunning(runningSnapshots, repositoryName, snapshotName);
                final ShardSnapshotStatus failedState = new ShardSnapshotStatus(
            + "]";
                                    sourceSnapshot,
     * @param repositoryName repository name
                    @Override
        }
                            : currentState
        final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);
     */
        String repositoryName,
                        final SnapshotsInProgress snapshotsInProgress = newState.custom(
    /**
        for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
        new ConcurrentHashMap<>();
                    : "Deletes should have been set to ready by finished snapshot deletes and finalizations";
                    SnapshotDeletionsInProgress.TYPE,
        final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE);
                    indices,
                            if (indexId != null) {
     * Remove the given {@link SnapshotId}s for the given {@code repository} from an instance of {@link SnapshotDeletionsInProgress}.
                }
            }
        latch.await();
                    logger.error("Failed to pin timestamp for clone snapshot {} with exception {}", snapshot.getSnapshotId().getName(), e);
    private void removeFailedSnapshotFromClusterState(
        String source,
                logger.warn(() -> new ParameterizedMessage("[{}][{}] failed to create snapshot", repositoryName, snapshotName), e);
                                repoShardId.index()
     */
                        indicesForSnapshot.add(indexId.getName());
                                finishedRoutingShardId
                    );
            logger.trace("Moving on to finalizing next snapshot [{}]", nextFinalization);
    /** Deletes snapshot from repository
        // Failure that caused the decision to fail all snapshots and deletes for a repo
                    .stream()
                            final IndexMetadata indexMeta = currentState.metadata().index(finishedShardId.indexName());
        }
                            + entry
            ShardSnapshotStatus shardStatus = shardEntry.getValue();
                                listener.onFailure(
        for (SnapshotsInProgress.Entry entry : snapshots.entries()) {
                        && IndexModule.IS_WARM_INDEX_SETTING.get(idxMd.getSettings())) {
    }
                    shardGenerations,
        clusterService.submitStateUpdateTask("remove snapshot deletion metadata", clusterStateUpdateTask);
                // not currently restorable. The rest of the cluster is captured normally.
                            minCompatibleVersion(minNodeVersion, repositoryData, snapshotsWithPinnedTimestamp.keySet()),
                                "Received shard snapshot status update [{}] but this shard is not tracked in [{}]",
                ensureBelowConcurrencyLimit(repositoryName, snapshotName, snapshots, deletionsInProgress);
                    indexIds,
     *
            }
    ) {
     */
                    builder.put(shardId, shardSnapshotStatus);
        }
                        if (abortedEntry == null) {
                            + Strings.arrayToCommaDelimitedString(request.indices())
    /**
            final String source = "remove in progress snapshot v2 after cluster manager switch";
import java.util.function.Function;
                            final SnapshotsInProgress.Entry updatedEntry = entry.withShardStates(updatedAssignmentsBuilder);
            );
                    IndexMetadata idxMd = currentState.metadata().index(indexName);
        repository.executeConsistentStateUpdate(repositoryData -> new ClusterStateUpdateTask() {
                if (enteredRepoLoop == false) {
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            final SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(
     * This method is executed on cluster-manager node
                shardGeneration
                    // Extremely unlikely corner case of cluster-manager failing over between between starting the clone and
                ensureSnapshotNameAvailableInRepo(repositoryData, snapshotName, repository);
        }
    ClusterStateUpdateTask createRemoveFailedSnapshotTask(
                    logger.debug("deleted snapshot completed - deleting files");
    private void processExternalChanges(boolean changedNodes, boolean startShards) {
         * {@link SnapshotDeletionsInProgress} that has a {@link SnapshotDeletionsInProgress.Entry} removed from it
                        source,
     */
                                    "Starting clone [{}] on [{}] with generation [{}]",
    private final TransportService transportService;
    ) {
                if (deletionsInProgress.getEntries().stream().anyMatch(entry -> entry.getSnapshots().contains(sourceSnapshotId))) {
            maxRetries = SNAPSHOT_CLEANUP_RETRIES_SETTING.get(settings);
                    }
                );
     * operation.
                "["
            ArrayList<SnapshotShardFailure> shardFailures = new ArrayList<>();
        String repository,
        public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                            repositoriesService.repository(entry.repository()),
                        assert shardGenerations.getShardGen(index, shardId.getId()) == null : "Found shard generation for new index ["
                        attempt,
    }
                    } else {
                for (SnapshotsInProgress.Entry entry : newFinalizations) {
            } else {
            }
            SnapshotDeletionsInProgress.TYPE,
 * Service responsible for creating snapshots. This service runs all the steps executed on the cluster-manager node during snapshot creation and
        ActionListener<Void> listener
                            "[{}] Updating shard clone [{}] with status [{}]",
                    repositoryData.getGenId(),
                            stateWithoutSnapshotV2(newState);
     * @param snapshot       snapshot that failed
    }
                final SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(
                }
        // Tasks to check for updates for running snapshots.
                    throw new ConcurrentSnapshotExecutionException(
                        "node shutdown",
                    final List<SnapshotId> toDelete = unmodifiableList(new ArrayList<>(snapshotIdsRequiringCleanup));
     * @param update shard snapshot status update
            }
                    throw new SnapshotException(
                                    knownFailures.computeIfAbsent(snapshot.repository(), k -> new HashMap<>())
import org.opensearch.common.Priority;
                for (final Map.Entry<RepositoryShardId, ShardSnapshotStatus> clone : entry.clones().entrySet()) {
 * this work for additional information regarding copyright
        }
                    assert outstandingDeletes == null : "Shouldn't have outstanding deletes after already starting delete task";
                    assert snapshot.partial() : "Index [" + id.getIndex() + "] was deleted during a snapshot but snapshot was not partial.";
            }
                        + expectedRepoGen
            clusterService.getClusterSettings()
        final CountDownLatch latch = new CountDownLatch(orphanPinnedEntities.size());
    }
        private final ShardSnapshotStatus updatedState;
            );
                    minCompatibleVersion(currentState.nodes().getMinNodeVersion(), repositoryData, null)
            RepositoryCleanupInProgress.EMPTY
        ShardGenerations.Builder builder = ShardGenerations.builder();
            }
        if (repositoryCleanupInProgress.hasCleanupInProgress()) {
        List<SnapshotsInProgress.Entry> entries = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(SnapshotsService.class);
                    shardFailures.add(new SnapshotShardFailure(status.nodeId(), shardId, status.reason()));
                        repository.finalizeSnapshot(
                ActionListener.delegateFailure(listener, (l, v) -> l.onResponse(UpdateIndexShardSnapshotStatusResponse.INSTANCE))
        } catch (OpenSearchRejectedExecutionException ex) {
            final SnapshotDeletionsInProgress newDeletions = filterDeletions(updatedDeletions);
        public void onFailure(String source, Exception e) {
                                clones.put(repoShardId, new ShardSnapshotStatus(localNodeId, finishedStatus.generation()));
                        );
        final RepositoryCleanupInProgress repositoryCleanupInProgress = currentState.custom(
            } else {
                                metaBuilder.put(repository.getSnapshotIndexMetaData(repositoryData, newEntry.source(), index), false);
            final Snapshot snapshot = entry.snapshot();
            // The delete failed to execute on the repository. We remove it from the cluster state and then fail all listeners associated
     */
    ) {
        /**
     * @param minNodeVersion    minimum node version in the cluster
    }
        } else if (primary.started() == false) {
                            iterator.remove();
 * ownership. Elasticsearch licenses this file to you under
            for (IndexId indexId : indices) {
            }
                    }
                if (shardSnapshotStatus.state().completed() == false && removedNodeIds.contains(shardSnapshotStatus.nodeId())) {
     * @param listener       listener to invoke when done with, only passed by the BwC path that has {@code repositoryData} set to
    /**
                    return metaBuilder.build();
        String repoName,
                        } else {
                    } else {
     * fact that a task was executed by adding it to a collection of executed tasks. If a subsequent execution of the outer loop finds that
                    // clean up snapshot v2 in progress or clone v2 present.
                    changed = true;
                return null;
                            if (existingStatus == null || existingStatus.state() != ShardState.QUEUED) {
                    }
                        shardSnapshotStatus = new ShardSnapshotStatus(
            logger.info("Cleaning up in progress v2 snapshots now");
                        }
                                && reassignedShardIds.contains(value.getKey()) == false) {
                if (entry.repository().equals(repoName)) {
            @Override
    private static ClusterManagerTaskThrottler.ThrottlingKey updateSnapshotStateTaskKey;
                    }
                        clusterService.submitStateUpdateTask(
                            remoteStoreIndexShallowCopy
        // 1. step, load SnapshotInfo to make sure that source snapshot was successful for the indices we want to clone
import java.util.LinkedList;
    private final Map<String, List<ActionListener<Void>>> snapshotDeletionListeners = new HashMap<>();
                    }
                            }
                return request.clusterManagerNodeTimeout();
        }
                if (excludedWarmDfa.isEmpty() == false) {
        } catch (Exception e) {
     * @param snapshotDeletionsInProgress new value for {@link SnapshotDeletionsInProgress} or {@code null} if it's unchanged
                for (IndexId indexId : repositoryData.getIndices().values()) {
                    v -> logger.trace("Marked [{}] as failed clone from [{}] to [{}]", repoShardId, sourceSnapshot, target.getSnapshotId()),
                    shards.put(shardId, knownFailure);
                            remoteStorePinnedTimestampService,
                    + segmentsOnlyIndices
            return deletions;
     * <p>
            if (queued.isEmpty()) {
                    currentState.metadata(),
                    }
        );
                    indices,
                @Override
                final Set<SnapshotId> activeCloneSources = snapshots.entries()
            if (entry.snapshot().getRepository().equals(repository) == false) {
                        return snapshotsInProgress.entries();
                            shardStatusBefore.generation(),
    }
    private void innerUpdateSnapshotState(ShardSnapshotUpdate update, ActionListener<Void> listener) {
                    ShardState.FAILED,
                            assert finishedStatus.nodeId().equals(localNodeId) : "Clone updated with node id ["
                newEntries.add(newEntry);
        if (repository.isReadOnly()) {
     *
                            shards.put(finishedShardId, new ShardSnapshotStatus(finishedStatus.nodeId(), finishedStatus.generation()));
                            sourceSnapshot,
        assert removed;
    @Override
                                    logger.debug("removing not yet start clone operation [{}]", snapshot);
                // completed snapshots do not require any updates so we just add them to the new list and keep going
                    threadPool.absoluteTimeInMillis(),
                                    finishedStatus.nodeId(),
        if (snapshotsInProgress.entries().isEmpty() == false) {
        private SnapshotsInProgress updatedSnapshotsInProgress(ClusterState currentState, SnapshotDeletionsInProgress updatedDeletions) {
                    listener.onFailure(null);
        }
                    // run newly ready deletes
                    snapshotsInProgress.entries().stream().map(SnapshotsInProgress.Entry::snapshot),
            }
        }
        );
         *     nodes dropping out of the cluster or another incoming delete aborting them) need not be updated in the cluster
 * compatible open source license.
        }
        Snapshot snapshot,
        }
                    );
            );
            return snapshotsInProgress.entries();
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_SNAPSHOT;
                        snapshotInfo.getPinnedTimestamp(),
                    request.includeGlobalState(),
        ) throws Exception {
                    // send ack to caller and won't continue on new cluster manager . Caller will need to retry it.
                    updatedEntries.add(entry);
        SnapshotsInProgress snapshotsInProgress,
        @Nullable RepositoryData repositoryData,
                protected void handleListeners(List<ActionListener<Void>> deleteListeners) {
    private final Set<Snapshot> initializingClones = Collections.synchronizedSet(new HashSet<>());
import org.opensearch.common.collect.Tuple;
                if (changed) {
    }
                    foundSnapshots.add(allSnapshotIds.get(snapshotOrPattern));
         * </ul>
                }
                    // We failed to read repository data for this delete, it is not the job of SnapshotsService to
        if (includeGlobalState == false) {
                final List<String> dataStreams = indexNameExpressionResolver.dataStreamNames(
        if (primary == null || !primary.assignedToNode()) {
                ActionListener.wrap(
        } else {
    private final RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory;
                                        + shardId
        synchronized void clear() {
            }
        synchronized void addFinalization(SnapshotsInProgress.Entry entry, Metadata metadata) {
    }
                if (abortedDuringInit) {
            assert currentlyFinalizing.contains(deleteEntry.repository());
                        .stream()
            }
                    repositoryName
        }
    private volatile TimeValue retryBackoff;
            createRemoveFailedSnapshotTask(source, attempt, snapshot, failure, repositoryData, listener)
        RemoveSnapshotDeletionAndContinueTask(SnapshotDeletionsInProgress.Entry deleteEntry, RepositoryData repositoryData) {
                        listener.onFailure(e);
import org.opensearch.core.action.ActionListener;
                        cloneSnapshotV2(request, snapshot, repositoryName, repository, listener);
            snapshotsToFinalize.clear();
        }
                List<SnapshotId> snapshotsWithLockFiles = Collections.synchronizedList(new ArrayList<>());
    public static final Setting<TimeValue> SNAPSHOT_REPOSITORY_IO_TIMEOUT_SETTING = new Setting<>(
     * {@link #failAllListenersOnMasterFailOver}. Otherwise, i.e. as a result of failing to write to the snapshot repository for some
                    // We keep a cache of shards that failed in this map. If we fail a shardId for a given repository because of
            );
import org.opensearch.cluster.metadata.Metadata;
                ShardState.MISSING,
    }
        List<String> dataStreamsList,
        @Override
    private void startExecutableClones(SnapshotsInProgress snapshotsInProgress, @Nullable String repoName) {
                        if (existing == null) {
            final StepListener<RepositoryData> repositoryDataListener = new StepListener<>();
        ensureSnapshotNameAvailableInRepo(repositoryData, snapshotName, repository);
            }
    }
        CloneSnapshotRequest request,
                        ShardRouting shardRouting = indexShardRoutingTable.shard(shardId.id()).primaryShard();
        for (SnapshotsInProgress.Entry entry : currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY).entries()) {
                                }
    );
                            return true;
                                canBeUpdated.add(value.getKey());
                        new Snapshot(repositoryName, sourceSnapshotId),
                shards.put(shardId, shardStatus);
     * used when the snapshot fails for some reason. During normal operation the snapshot repository will remove the
        Snapshot snapshot,
        SnapshotsInProgress snapshots,
                    if (entry.snapshot().getSnapshotId().getName().equals(snapshot)) {
                        snapshot,
            logger.info("Not empty");
                logger.warn(() -> new ParameterizedMessage("[{}] failed to remove snapshot metadata", snapshot), e);
        }
                        removeSnapshotDeletionFromClusterState(deleteEntry, null, updatedRepoData);
    public static final Setting<Integer> MAX_SHARDS_ALLOWED_IN_STATUS_API = Setting.intSetting(
            public void onFailure(String source, Exception e) {
            }
            + snapshotCompletionListeners
                if (newClusterManager && snapshotsInProgress.entries().isEmpty() == false) {
        String name,
            }
                private final Collection<SnapshotDeletionsInProgress.Entry> deletionsToExecute = new ArrayList<>();
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                    }
                                }
         * being cluster-manager.
            return Collections.unmodifiableMap(shards);
            private SnapshotsInProgress.Entry updatedEntry;
                        }
            Map<RepositoryShardId, ShardSnapshotStatus> clones = null;
 * @opensearch.internal
                newEntry = SnapshotsInProgress.startClone(
                            // write anything to the repository physically. This means we can simply remove these from the cluster state
            this.deleteEntry = deleteEntry;
            assert snapshotsToFinalize.values().stream().noneMatch(Collection::isEmpty) : "Found empty queue in " + snapshotsToFinalize;
                validate(repositoryName, snapshotName, currentState);
        TransportService transportService,
                    assert state == ShardState.SUCCESS;
                return false;
                    }
                    // BwC Path where we removed an outdated INIT state snapshot from the cluster state
                    .noneMatch(SnapshotsService::isWritingToRepository)) {
     * Finalizes the shard in repository and then removes it from cluster state
                } else {
                actionFilters,
     */
                final Version version = minCompatibleVersion(newState.nodes().getMinNodeVersion(), repositoryData, null);
                    }
                            // A clone was updated, so we must use the correct data node id for the reassignment as actual shard
                        indicesForSnapshot,
            }
                }
                                    listener.onFailure(e);
         *     from the state.</li>
                    e
                        );
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                            final ShardSnapshotStatus shardSnapshotStatus = startShardSnapshotAfterClone(
        }
                enteredLoop = tryEnterRepoLoop(repositoryName);
            ClusterStateTaskConfig.build(Priority.NORMAL),
                        final InFlightShardSnapshotStates inFlightShardStates = InFlightShardSnapshotStates.forRepo(
     * This method is responsible for creating a clone of the shallow snapshot v2.
                clusterService.submitStateUpdateTask(
     * Try starting to run a snapshot finalization or snapshot delete for the given repository. If this method returns
        RoutingTable routingTable,
    private static void ensureSnapshotNameNotRunning(
        SnapshotDeletionsInProgress deletionsInProgress
                        ShardState.FAILED,
                if (replacedEntry == null) {
     *
        }, onFailure);
        return new ClusterStateUpdateTask(priority) {
                @Override
                    assert snapshotsToFail.contains(finalization.v1().snapshot()) : "["
        }
            .map(indexMetadata -> indexMetadata.getIndex().getName())
                                    leaveRepoLoop(repositoryName);
                // Exclude warm-tiered pluggable-data-format indexes from V2 snapshots; they are
            );
            final SnapshotsInProgress updatedSnapshotsInProgress = changedSnapshots ? SnapshotsInProgress.of(snapshotEntries) : null;
        boolean remoteStoreIndexShallowCopy = REMOTE_STORE_INDEX_SHALLOW_COPY.get(repository.getMetadata().settings());
                    && clusterService.getClusterSettings().get(REMOTE_STORE_COMPATIBILITY_MODE_SETTING).equals(CompatibilityMode.MIXED)) {
        snapshotResilienceValidator(IO_TIMEOUT_KEY),
                meta -> repo.finalizeSnapshot(
                                    snapshot,
    /**
                }
            if (ExceptionsHelper.unwrap(e, NotClusterManagerException.class, FailedToCommitClusterStateException.class) != null) {
                        // We are reacting to shards that started only so which only affects the individual shard states of started
     *                       (used to use newer metadata version after a snapshot delete)
                    metadataListener.whenComplete(meta -> {
            final Snapshot running = s.snapshot();
     * @param repository     repository name
import static org.opensearch.common.util.IndexUtils.filterIndices;
            }
                            + FeatureFlags.SNAPSHOT_RESILIENCE
                && this.updatedState == that.updatedState;
        ArrayList<SnapshotsInProgress.Entry> entries = new ArrayList<>();
                                && entry.state() == SnapshotDeletionsInProgress.State.STARTED
                                            localNodeId,
            if (snapshots.isEmpty() == false) {
                newEntries.add(newEntry);
     * @param excluded       snapshot id to ignore when computing the minimum version
        Setting.Property.NodeScope,
import java.util.Set;
                }
                for (IndexId index : indices) {
                    if (status.equals(ShardSnapshotStatus.UNASSIGNED_QUEUED)) {
            snapshotsInProgress.entries()
 * software distributed under the License is distributed on an
            public void clusterStateProcessed(String source, ClusterState oldState, final ClusterState newState) {
                                    );
    }
            } else {
     * Fail here instead. Full snapshots and shallow v1 remain available, both of which flush before capturing a
     * @param snapshotsInProgress snapshots in progress in the cluster state
            @Override
                if (repositoryCleanupInProgress.hasCleanupInProgress()) {
     *
import org.opensearch.repositories.RepositoriesService;
                            clone.getKey(),
                    );
                                    if (!clusterService.state().nodes().isLocalNodeElectedClusterManager()) {
        }
                    if (indexRoutingTable == null) {
                        repositoryName,
import java.util.Map;
                    sourceSnapshotId,
                        repoName,
            for (int i = 0; i < shardCount; i++) {
                        true,
                        null,
    public static final Setting<Integer> SNAPSHOT_CLEANUP_RETRIES_SETTING = Setting.intSetting(
                        System.currentTimeMillis(),
        200000,
            clusterStateUpdateTask = new RemoveSnapshotDeletionAndContinueTask(deleteEntry, repositoryData) {
        snapshotDeletionListeners.computeIfAbsent(deleteUUID, k -> new CopyOnWriteArrayList<>()).add(listener);
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
        ActionListener<Void> listener
                        if (hasWildCardPatterForCloneSnapshotV2(request.indices()) == false) {
                        logger.info("snapshots {} deleted", snapshotIds);
                    failListenersIgnoringException(listeners, wrapped);
        }
                        failAllListenersOnMasterFailOver(ex);
        Exception failure,
                ensureBelowConcurrencyLimit(repositoryName, snapshotName, snapshots, deletionsInProgress);
                    + "] operations and the current"
    // Assert that there are no snapshots that have a shard that is waiting to be assigned even though the cluster state would allow for it
            } else {
                            continue;
                shardFailures,
        createSnapshotTaskKey = clusterService.registerClusterManagerTask(CREATE_SNAPSHOT, true);
            }
                runReadyDeletions(repositoryData, repository);
                for (final ShardSnapshotStatus status : entry.shards().values()) {
                                finishedStatus.nodeId(),
                                        && entry.state() == SnapshotDeletionsInProgress.State.STARTED
        // 3. step, we have all the shard counts, now update the cluster state to have clone jobs in the snap entry
            } else {
            getPinningEntity(snapshot.getRepository(), sourceSnapshot.getUUID()),
                                "Starting [{}] on [{}] with generation [{}]",
         *     <li>Snapshots that had unfinished shard snapshots in state {@link ShardSnapshotStatus#UNASSIGNED_QUEUED} that
                        "cannot delete snapshots while a repository cleanup is in-progress in [" + repositoryCleanupInProgress + "]"
     * ready for the repository {@link #leaveRepoLoop(String)} should be invoked so that a subsequent state change that
                                repositoryData,
                            // BwC path, older versions could create entries with unknown repo GEN in INIT or ABORTED state that did not yet
                newDeletes.add(newEntry);
                            stateWithoutSnapshotV2(newState);
                @Override
            } else {
     */
     * "repository unreachable" error instead of parking another thread.
        String[] snapshotNames,
            final List<SnapshotsInProgress.Entry> snapshotEntries = new ArrayList<>();
                                ShardState.MISSING,
                                        snapshotName
                    }
                startedCount
    ) {
        }
            if (FeatureFlags.isEnabled(FeatureFlags.SNAPSHOT_RESILIENCE_SETTING)
            && request.indices().length == 0
                } else {
                        shardRepoGeneration = inFlightGeneration;
                    ),
import org.opensearch.action.LatchedActionListener;
                    for (SnapshotDeletionsInProgress.Entry entry : deletionsToExecute) {
        allShardCountsListener.whenComplete(counts -> repository.executeConsistentStateUpdate(repoData -> new ClusterStateUpdateTask() {
            }
        snapshotResilienceValidator(CLEANUP_STALE_BLOBS_KEY),
                        }
                    } else {
            @Override
    }
        protected UpdateIndexShardSnapshotStatusResponse read(StreamInput in) throws IOException {
                for (RestoreInProgress.Entry entry : restoreInProgress) {
        validate(repositoryName, snapshotName);
        int startedCount = 0;
    ) {
            .collect(Collectors.toMap(SnapshotId::getName, Function.identity()));
                        .build();
                repositoriesService.repository(repoName).getRepositoryData(new ActionListener<RepositoryData>() {
            return Tuple.tuple(currentState, Collections.emptyList());
            logger.debug("Removing failed snapshot clone [{}] from cluster state", entry);
                                    snapshot.shards(),
                logger.debug("remote_store_index_shallow_copy setting is set as [{}]", remoteStoreIndexShallowCopy);
    @Override
            // from the repository after the cluster state update
            long orphanTimestamp = pinnedEntities.get(pinnedEntity).get(0);
                    newDelete = new SnapshotDeletionsInProgress.Entry(
                // this shard snapshot is waiting for a previous snapshot to finish execution for this shard
                }
     * Initializes the snapshotting process.
                    }
        Repository repository,
                    shardGenerations,
                    listener.onFailure(e);
                        for (final Map.Entry<ShardId, ShardSnapshotStatus> value : entry.shards().entrySet()) {
            @Override
 */
                    getInFlightIndexIds(runningSnapshots, repositoryName),
     * Package private to allow for tests.
     * @param e               the exception from onFailure
        RepositoryData repositoryData
        snapshot.indices().forEach(idx -> indexLookup.put(idx.getName(), idx));
                }
                            shardRepoGeneration
        return builder.build();
        if (ExceptionsHelper.unwrap(e, NotClusterManagerException.class, FailedToCommitClusterStateException.class) != null) {
                for (SnapshotDeletionsInProgress.Entry entry : currentState.custom(
        }
        }
                    throw new ConcurrentSnapshotExecutionException(
            RepositoryCleanupInProgress.TYPE,
                        excludedWarmDfa.size()
                    public void onFailure(Exception e) {
                            // No work has been done for this snapshot yet so we remove it from the cluster state directly
                final IndexRoutingTable indexRoutingTable = routingTable.index(indexName);
        logger.debug("shallow_snapshot_v2 is set as [{}]", isSnapshotV2);
        if (changed) {
                if (listener != null) {
            listener.onFailure(e);
                        // If we found snapshots that should be finalized as a result of the CS update we try to initiate finalization for
    }
                            // any leaked listener assertions
                        snapshot,
                );
            clusterService.submitStateUpdateTask(source, createStateWithoutSnapshotV2Task(source, attempt));
                    } else {
        }
                        );
            private ActionListener<String> getCloneCompletionListener(String localNodeId) {
                                        repositoryName,
    /**
                        IndexRoutingTable indexShardRoutingTable = event.state().getRoutingTable().index(shardId.getIndex());
                                            new SnapshotException(snapshot, "Aborting Snapshot-v2 clone, no longer cluster manager")
        this.remoteSegmentStoreDirectoryFactory = new RemoteSegmentStoreDirectoryFactory(
            logger.warn(() -> new ParameterizedMessage("[{}] failed to finalize snapshot", snapshot), e);
                            Priority.IMMEDIATE,
                        // from the cluster state
                assert runningSnapshots.containsAll(snapshotListenerKeys) : "Saw completion listeners for unknown snapshots in "
                            .stream()
            throw new ConcurrentSnapshotExecutionException(
     * @param listener completion listener
                            leaveRepoLoop(repositoryName);
        @Nullable SnapshotsInProgress snapshotsInProgress,
                "snapshot with the same name already exists"
                    userMeta,
        }
        return runningSnapshots.stream()
import org.opensearch.common.settings.Setting;
                }
     * Updates the state of in-progress snapshots in reaction to a change in the configuration of the cluster nodes (cluster-manager fail-over or
        private final RepositoryShardId repoShardId;
                        if (shardStatusBefore.state() != ShardState.INIT) {
                    }
        RoutingTable routingTable,
                    .collect(Collectors.toSet());
            public TimeValue timeout() {
        String[] snapshotsOrPatterns,
                        updatedState.custom(SnapshotDeletionsInProgress.TYPE, SnapshotDeletionsInProgress.EMPTY),
     * Snapshot-v2 does not flush before pinning its timestamp, so a restore reconstructs the point in time from the
            return running.getRepository().equals(repositoryName) && running.getSnapshotId().getName().equals(snapshotName);
                    builder.put(indexMetadata, false);
                    SnapshotDeletionsInProgress.TYPE,
                            shardSnapshotStatus = new ShardSnapshotStatus(primary.currentNodeId(), ShardState.WAITING, shardRepoGeneration);
        return entries;
                    }
     * If no deletion contained any of the snapshot ids to remove then return {@code null}.
                    listener.onFailure(
            public void onFailure(String source, Exception e) {
        Setting.Property.Dynamic
                createSnapshotPreValidations(currentState, repositoryData, repositoryName, snapshotName);
                                    repoName
                            );
        ActionListener<RepositoryData> listener
                        "cannot clone from snapshot that is being deleted"
            TimeValue value = TimeValue.parseTimeValue(s, IO_TIMEOUT_KEY);
                    return ClusterState.builder(currentState)
                final Snapshot updatedSnapshot = updateSnapshotState.snapshot;
    private static ShardGenerations buildGenerationsV2(SnapshotsInProgress.Entry snapshot, Metadata metadata) {
    @Override
            assert false : new AssertionError(e);
                final Set<String> deleteListenerKeys = snapshotDeletionListeners.keySet();
                }
            public void clusterStateProcessed(String source, ClusterState oldState, final ClusterState newState) {
                    .collect(Collectors.toList());
 * KIND, either express or implied.  See the License for the
                                if (inFlightShardStates.isActive(indexName, shardId)) {
     * upload any shard metadata to the snapshot repository.
            for (final Map.Entry<ShardId, ShardSnapshotStatus> shardStatus : entry.shards().entrySet()) {
                metadataListener.onResponse(metadata);
                        updatedEntries.set(i, updatedEntry);
     *
        "snapshot.cleanup.retry_backoff",
        boolean changed = false;
                                : "This should never happen, cluster-manager will not submit a state update for a non-existing clone";
                    repositoryData,
     */
        private final String repository;
                entries.add(entry);
                            snapshotsInProgress.entries()
        snapshotCompletionListeners.computeIfAbsent(snapshot, k -> new CopyOnWriteArrayList<>()).add(listener);
     * (finalization, deletion). Operations exceeding this budget are treated as failures.
                    leaveRepoLoop(deleteEntry.repository());
            return value;
        synchronized (currentlyFinalizing) {
    ) {
                            + "] received update for clone ["
        String snapshotName
            @Override
                shardGenerations.indices().stream().map(IndexId::getName).collect(Collectors.toList()),
                        } else if (shardRouting.primaryShard().initializing() || shardRouting.primaryShard().relocating()) {
                        try {
                                    updatedSnapshotEntries.add(snapshot);
                final List<SnapshotsInProgress.Entry> newEntries = new ArrayList<>(runningSnapshots);
                }
                    + snapshotName
                        );
                @Override
                    if (idxMd != null
        UpdateIndexShardSnapshotStatusRequest,
        String repoName
        final String[] snapshotNames = request.snapshots();
            public TimeValue timeout() {
    }
        if (snapshots == null) {
                        && IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(idxMd.getSettings())
                    if (sourceSnapshotInfo.getPinnedTimestamp() > 0) {
                    shardGenerations.indices().stream().map(IndexId::getName).collect(Collectors.toList()),
        private final Exception failure;
    private volatile int maxRetries;
     */
                            for (ShardId shardId : canBeUpdated) {
            public TimeValue timeout() {
                    // Entry is for another repository we just keep it as is
                            // index got removed concurrently and we have to fail WAITING state shards
                } else {
        Snapshot snapshot,
                            () -> currentlyCloning.remove(repoShardId)
        if ("_all".equals(repository)) {
                return currentState;
            // Snapshots that were aborted and that already wrote data to the repository and now have to be deleted
                final Runnable fallback = () -> {
                        new Snapshot(repoName, snapshotIds.get(0)),
                request,
     *
            private SnapshotsInProgress.Entry newEntry;
        }
                final SnapshotId foundId = allSnapshotIds.get(snapshotOrPattern);
    ) {
        if (listeners != null) {
     * cluster state. The number of concurrent operations in a cluster state is defined as the sum of the sizes of
                return createSnapshotTaskKey;
    private void finalizeSnapshotEntry(SnapshotsInProgress.Entry entry, Metadata metadata, RepositoryData repositoryData) {
                return updateWithSnapshots(currentState, changed ? SnapshotsInProgress.of(updatedEntries) : null, null);
            if (queued == null) {
     * With a local translog there is nothing to replay from: the restore fails outright because it cannot resolve a
    static TimeValue computeBackoff(TimeValue base, int attempt) {
     * of a snapshot clone completing.
                    public void onResponse(RepositoryData repositoryData) {
import org.opensearch.common.util.concurrent.AbstractRunnable;
        final InFlightShardSnapshotStates inFlightShardStates = InFlightShardSnapshotStates.forRepo(
        final Set<String> reposSeen = new HashSet<>();
     */
                }
                );
                    }));
    private static final String IO_TIMEOUT_KEY = "snapshot.repository.io_timeout";
                    .build();
                            snapshotChanged = true;
                    + "pinned timestamp requires replaying the remote translog. Disable "
        Exception failure,
     * repository and all nodes in the cluster.
     * @param listener snapshot completion listener
                        deleteEntry.repository()
                    return existing;
        }
     * Adds snapshot completion listener
                                snapshotName,
                final RepositoryCleanupInProgress repositoryCleanupInProgress = currentState.custom(
                            shards = new HashMap(entry.shards());
     */
                            }, ex -> removeSnapshotDeletionFromClusterState(deleteEntry, ex, repositoryData))
                            }
            assert assertConsistent();
                for (Map.Entry<String, SnapshotId> entry : allSnapshotIds.entrySet()) {
                        updatedEntry = cloneEntry.withClones(clonesBuilder)
import org.opensearch.ExceptionsHelper;
                failAllListenersOnMasterFailOver(e);
        this.indexNameExpressionResolver = indexNameExpressionResolver;
                                v -> logger.trace(
        }
            Map<ShardId, ShardSnapshotStatus> shards = null;
        }
                        latch.countDown();
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "must not contain whitespace");
                    return updateWithSnapshots(currentState, updatedSnapshots, null);
            return shardStateExecutor.execute(currentState, tasks);
                            }
            allShardCountsListener,
                        "No indices in the source snapshot ["
                        })),
                }
        boolean snapshotChanged = false;
                                    clones = new HashMap<>(entry.clones());
                            }
     *
                                        finishedSnapshots.add(updatedSnapshot);
        }
                        snapshotInfo.totalShards(),
        final int nextAttempt = attempt + 1;
                            new Snapshot(repositoryName, snapshotId),
                    failSnapshotCompletionListeners(snapshot, failure);
                                    final SnapshotsInProgress.Entry updatedSnapshot = snapshot.withShardStates(shards);
        }
            public void onFailure(Exception e) {
        failListenersIgnoringException(endAndGetListenersToResolve(snapshot), e);
            @Override
            return emptySet();
import org.opensearch.cluster.routing.RoutingTable;
         * @return updated snapshot in progress instance or {@code null} if there are no changes to it
            // inner loop over all the shard updates that are potentially applicable to the current snapshot entry
            }
                logger.warn("Failed to run ready delete operations", e);
    ) {
                            getCloneCompletionListener(localNodeId)
            public ClusterState execute(ClusterState currentState) {
                    removeSnapshotDeletionFromClusterState(deleteEntry, e, repositoryData);
        @Nullable RemoteStorePinnedTimestampService remoteStorePinnedTimestampService,
                    startExecutableClones(newState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY), null);
            for (int i = 0; i < indexMetadata.getNumberOfShards(); i++) {
            final List<SnapshotId> snapshotIds = deleteEntry.getSnapshots();
            assertConsistent();
                    }
                builder.put(indexId, i, null);
        });
            final String repoName = deleteEntry.repository();
                0
                    + " but running deletes are "
                            );
        try {
                                    leaveRepoLoop(repositoryName);
     * <p>
                final Exception wrapped = new RepositoryException("_all", "Failed to update cluster state during repository operation", e);
                return updateWithSnapshots(
import java.util.HashSet;
                    }
    public void cloneSnapshot(
                }
                        newDelete = foundDuplicate.get();
                listener.onFailure(e);
                    metadataForSnapshot(meta, entry.includeGlobalState(), entry.partial(), entry.dataStreams(), entry.indices()),
    private static final String CLEANUP_STALE_BLOBS_KEY = "snapshot.delete.cleanup_stale_blobs";
        return new ClusterStateUpdateTask() {
    /**
            synchronized (repositoryOperations.runningDeletions) {
                                finishedShardId,
        // Outer loop over all snapshot entries in the order they were created in
            }
     */
            logger.warn("Exhausted {} retries for [{}], falling back to failover handling", maxRetries, source);
            @Override
                        } else {
            final SnapshotsInProgress.Entry updatedEntry;
        }
    }
            return null;
                    repositoryData
                        SnapshotDeletionsInProgress.EMPTY
            public ClusterState execute(ClusterState currentState) {
                        repositoryData,
     * orphaned by previously interrupted deletes.
                if (metadata.index(id.getIndex()) == null) {
    }
                            shardStatusBefore.generation(),
                            + entry
                }
                            assert false
                    }
                    leaveRepoLoop(repositoryName);
                                startedCount++;
                }
                        final Set<String> reposWithRunningDeletes = snapshotDeletionsInProgress.getEntries()
     * Updates the shard status in the cluster state
        assert snapshotsInProgress != null;
     *                    successfully
                } else {
import org.opensearch.cluster.NotClusterManagerException;
            private SnapshotDeletionsInProgress.Entry newDelete;
        final Snapshot snapshot = new Snapshot(repositoryName, snapshotId);
            SnapshotDeletionsInProgress.TYPE,
            private void executeClone(String localNodeId, boolean cloneRemoteStoreIndexShardSnapshot) {
            SHARD_STATE_EXECUTOR,
        final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
            };
                        }
     *
                }
         */
import java.util.Collection;
                                @Override
            final ShardGenerations shardGenerations = buildGenerations(entry, metadata);
                    for (final Map.Entry<RepositoryShardId, ShardSnapshotStatus> indexClone : updatedEntry.clones().entrySet()) {
            @Override
/**
import java.util.Iterator;
            @Override
                // Entering finalize loop here to prevent concurrent snapshots v2 snapshots
                entry.startTime(),
                    }
        if (repositoryData.getSnapshotIds().stream().anyMatch(s -> s.getName().equals(snapshotName))) {
        // check if the snapshot name already exists in the repository
        } else {
                final IndexId indexId = indexLookup.get(id.getIndexName());
    public void createSnapshot(final CreateSnapshotRequest request, final ActionListener<Snapshot> listener) {
        if (remoteStoreIndexShallowCopy
                final SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(
                            .filter(entry -> repoName.equals(entry.repository()))
                failAllListenersOnMasterFailOver(new NotClusterManagerException(src));
                                + "]";
                            }
                            endSnapshot(completedSnapshot, newState.metadata(), repositoryData);
                }
                }
            @Override
                            deleteSnapshotsFromRepository(newDelete, repositoryData, newState.nodes().getMinNodeVersion());
            + snapshotDeletionListeners
    }
                        );
 */
                    }
                            }
import org.opensearch.core.index.Index;
                }
                    }
                        repositoryName,
                    // don't allow shallow snapshots if compatibility mode is not strict
     * @param repository     repository to run operation on
                assert readyDeletions.stream().noneMatch(entry -> entry.repository().equals(deleteEntry.repository()))
    /**
        if (snapshotName.contains(",")) {
                            + "] is disabled"
        }
        if (Strings.hasLength(snapshotName) == false) {
        // Tasks that were used to complete an existing in-progress shard snapshot
                    ).v1();
                        shardStatus.nodeId(),
                if (updatedEntry != null) {
                        clones.put(finishedShardId, updateSnapshotState.updatedState);
     * @param listener        listener
 * See package level documentation of {@link org.opensearch.snapshots} for details.
                }, e -> {
                            // Since we updated a normal snapshot we need to translate its shard ids to repository shard ids which requires
                            updatedSnapshot,
                    final ShardId shardId = shardStatus.getKey();
                snapshotName,
                    .map(SnapshotsInProgress.Entry::source)
                    logger.info("snapshots {} aborted", completedNoCleanup);
                } else {
                                    clonesBuilder.put(repoShardId, ShardSnapshotStatus.UNASSIGNED_QUEUED);
        ShardGenerations.Builder builder = ShardGenerations.builder();
                ).collect(Collectors.toSet());
            public void onResponse(Void unused) {
                    endSnapshot(entry, newState.metadata(), repositoryData);
                }
 * SPDX-License-Identifier: Apache-2.0
                    threadPool.absoluteTimeInMillis(),
                    repositoryData.resolveIndices(matchingIndices),
        }
    private static Metadata metadataForSnapshot(
        final int maxOps = maxConcurrentOperations;
        3,
                false,
     */
                }
                    true,
            if (shards != null) {
                                                "Aborting Snapshot-v2 clone, no longer cluster manager"
                );
     * @param repository snapshot repository
                public void onFailure(Exception e) {
                            target.getSnapshotId(),
         *     could not be started because the delete was running can have those started.</li>
                                completedNoCleanup.add(existingNotYetStartedSnapshot);
        if (runningSnapshots.stream().anyMatch(s -> {
            @Override
    private static List<SnapshotsInProgress.Entry> findInProgressSnapshots(
        Snapshot snapshot,
        final String localNodeId = clusterService.localNode().getId();
                    shards.put(shardId, failedState);
            // 2. step, load the number of shards we have in each index to be cloned from the index metadata.
                        listener.onResponse(null);
                    .putCustom(SnapshotDeletionsInProgress.TYPE, SnapshotDeletionsInProgress.of(newDeletes))
            final SnapshotDeletionsInProgress updatedDeletions = deletions.withRemovedEntry(deleteEntry.uuid());
                private final Collection<SnapshotsInProgress.Entry> finishedSnapshots = new ArrayList<>();
                    metadataForSnapshot(newState.metadata(), request.includeGlobalState(), false, dataStreams, newEntry.indices()),
                        indices.add(indexName);
        ) {
            final String failure = entry.failure();
        }
     *                       snapshot create operations remain to execute
            }
                @Override
                        "cannot clone from snapshot that is being deleted"
                return ActionListener.wrap(
                    @Override
                        toDelete,
            ActionFilters actionFilters,
                    currentState,
        }
        if (repositoryCleanupInProgress.hasCleanupInProgress()) {
                            .stream()
    }
    /**
        @Override
                () -> new ParameterizedMessage("Failed to remove all snapshot tasks for repo [{}] from cluster state", repository),
            final int attempt = 0;
        Collection<SnapshotId> snapshotIds,
        }
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
                        threadPool.absoluteTimeInMillis(),
                        failCloneShardAndUpdateClusterState(target, sourceSnapshot, repoShardId);
                    generation -> innerUpdateSnapshotState(
                        }
        }
                                shardId,
                    version,
                            shards.put(shardId, shardStatus);
        ShardSnapshotStatus shardStatusBefore,
                    request.indicesOptions(),
                        snapshot.getRepository()
                                entry
            private final Collection<SnapshotsInProgress.Entry> completedWithCleanup = new ArrayList<>();
        try {
                final SnapshotDeletionsInProgress.Entry newEntry = entry.started();
    /**
     * @param listener snapshot creation listener
    ) {
            boolean changed = false;
import java.io.IOException;
                    }
        if (changedCount > 0) {
                deleteFromRepoTask = createDeleteStateUpdate(snapshotIds, repoName, repositoryData, Priority.NORMAL, listener);
                ShardSnapshotStatus status = shardStatus.getValue();
                    // the update applies to a different repository so it is irrelevant here
                snapshotInfoListener.whenComplete(sourceSnapshotInfo -> {
                        runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, repository, remoteStoreIndexShallowCopy);
     * The pinned timestamp is later reconciled with remote store segment and translog metadata files during the restore
                logger.warn(() -> new ParameterizedMessage("[{}][{}] failed to clone snapshot-v2", repositoryName, snapshotName), e);
                        snapshotInfo.getPinnedTimestamp()
    public static Tuple<String, String> getRepoSnapshotUUIDTuple(String pinningEntity) {
                }
                    failSnapshotCompletionListeners(snapshot, new SnapshotException(snapshot, SnapshotsInProgress.ABORTED_FAILURE_TEXT));
     * and the contents of the repository. The minimum version is determined as the lowest version found across all snapshots in the
                "must not contain the following characters " + Strings.INVALID_FILENAME_CHARS
    }
                listener.onFailure(e);
            public void onFailure(String source, Exception e) {
     */
     *
                    snapshotInfo,
                    } else if (executedTasks.contains(updateSnapshotState)) {
    );
        final SnapshotsInProgress snapshotsInProgress = currentState.custom(SnapshotsInProgress.TYPE);
                });
            return runningDeletions.add(deleteUUID);
                        repository.cloneRemoteStoreIndexShardSnapshot(
                    snapshotChanged = true;
                    Thread.currentThread().interrupt();
                .noneMatch(entry -> entry.snapshot().equals(snapshot)) : "Snapshot [" + snapshot + "] is still in finalization queue";
                                final ShardSnapshotStatus updated = shardAssignments.get(shardId);
            throw new InvalidSnapshotNameException(
    private List<ActionListener<Tuple<RepositoryData, SnapshotInfo>>> endAndGetListenersToResolve(Snapshot snapshot) {
                );
                listener.onFailure(e);
                        }
        repository.executeConsistentStateUpdate(repositoryData -> new ClusterStateUpdateTask(Priority.NORMAL) {
                                    updatedSnapshotEntries.add(updatedSnapshot);
        }
            );
                    } finally {
                for (final Map.Entry<ShardId, ShardSnapshotStatus> shardStatus : entry.shards().entrySet()) {
                            iterator.remove();
                Repository repository = repositoriesService.repository(repositoryName);
import org.opensearch.core.common.io.stream.StreamInput;
    private static class CleanupAfterErrorListener {
                                        );
        SnapshotsInProgress snapshots = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                        );
                                updateSnapshotState,
                final Map<ShardId, ShardSnapshotStatus> shards = shards(
                    final SnapshotDeletionsInProgress updatedDeletions = deletionsWithoutSnapshots(
    }
                final List<IndexId> indexIds = repositoryData.resolveNewIndices(
            assert deletions != null : "We only run this if there were deletions in the cluster state before";
        (s) -> {
        UpdateIndexShardSnapshotStatusResponse> {
                final Set<SnapshotId> snapshotIdsRequiringCleanup = new HashSet<>(snapshotIds);
     */
            if (Regex.isSimpleMatchPattern(snapshotOrPattern)) {
                            }
     */
                    request.includeGlobalState(),
                return Collections.emptyList();
                final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                return ClusterState.builder(currentState).putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(newEntries)).build();
                                                repositoryName,
    private boolean assertConsistentWithClusterState(ClusterState state) {
                    } else {
                final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                    ActionListener.wrap(newRepoData -> {
        protected ClusterBlockException checkBlock(UpdateIndexShardSnapshotStatusRequest request, ClusterState state) {
        });
            assert snapshotsToFinalize.getOrDefault(snapshot.getRepository(), new LinkedList<>())
    /**
import org.opensearch.cluster.metadata.DataStream;
                final List<String> matchingIndices = filterIndices(indicesForSnapshot, request.indices(), request.indicesOptions());
                                    logger.warn("Cluster state update after successful shard clone [{}] failed", repoShardId);
                    );
        SnapshotId sourceSnapshot,
                }));
                                shardRepoGeneration
                    "fail repo tasks for [" + deleteEntry.repository() + "]",
                final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                            if (shards == null) {
     * cluster-manager strands the in-progress snapshot marker forever, blocking index deletion and close.
                            } else {
            userCreateSnapshotListener.onFailure(e);
                }).filter(Objects::nonNull).collect(Collectors.toList()));
         * <ul>
    /**
                    SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
     * @param deletions   snapshot deletions to update
        snapshotInfoListener.whenComplete(snapshotInfo -> {
         * Set of delete operations currently being executed against the repository. The values in this set are the delete UUIDs returned
                    shards.put(shardId, shardStatus);
                SnapshotDeletionsInProgress.EMPTY
            readyDeletions = res.v2();
                    }
            final String indexName = index.getName();
            removeFailedSnapshotFromClusterState(entry.snapshot(), new SnapshotException(entry.snapshot(), entry.failure()), null, null);
     * Creates a {@link ShardSnapshotStatus} entry for a snapshot after the shard has become available for snapshotting as a result
                                    entry -> repoName.equals(entry.repository())
        );
            if (entry.isClone() && entry.state() == State.STARTED && (repoName == null || entry.repository().equals(repoName))) {
        assert currentlyFinalizing.isEmpty() : "Found leaked finalizations " + currentlyFinalizing + " on [" + localNode + "]";
        SnapshotDeletionsInProgress deletions,
                assert readyDeletions(currentState).v1() == currentState
    );
        RepositoryData repositoryData,
        }, "clone_snapshot_v2 [" + request.source() + "][" + snapshotName + ']', listener::onFailure);
        final TimeValue delay = computeBackoff(retryBackoff, attempt);
    }
        }
     * delay is clamped to a sane maximum in case maxRetries/retryBackoff are configured to large values.
        protected SnapshotDeletionsInProgress filterDeletions(SnapshotDeletionsInProgress deletions) {
                        .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(unmodifiableList(entries)))
     * Runs a cluster state update that checks whether we have outstanding snapshot deletions that can be executed and executes them.
            for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
                            if (indexMeta == null) {
                                    listener.onResponse(null);
     * @param changedNodes true iff either a cluster-manager fail-over occurred or a data node that was doing snapshot work got removed from the
                            }
    }
                builder.put(index, shardId.id(), shardRepoGeneration);
            private SnapshotId sourceSnapshotId;
        }
                    ArrayList<SnapshotsInProgress.Entry> updatedSnapshotEntries = new ArrayList<>();
            } else {
     * Only modifiable when the snapshot resilience feature flag is enabled.
            }
        SnapshotDeletionsInProgress.Entry deleteEntry,
            }
        final String repositoryName = request.repository();
     */
                    if (repositoryData.getSnapshots(indexId).contains(sourceSnapshotId)) {
    // Made to package private to be able to test the method in UTs
                target,
                }
                    sourceSnapshotId,
            }
                    .stream()
     * Every shard snapshot or clone state update can result in multiple snapshots being updated. In order to determine whether or not a
                    repository
        Setting.Property.Dynamic
                            ShardState.MISSING,
                    public void onResponse(Void unused) {}
                failSnapshotCompletionListeners(snapshot, failure);
    /**
        try {
        clusterService.removeApplier(this);
        } else {
        private final RepositoryData repositoryData;
                UPDATE_SNAPSHOT_STATUS_ACTION_NAME,
                                finishedStatus.nodeId(),
            remoteStorePinnedTimestampService.unpinTimestamp(
        } else if (primary.relocating() || primary.initializing()) {
         */
                ArrayList<SnapshotsInProgress.Entry> entries = new ArrayList<>();
                CountDownLatch latch = new CountDownLatch(1);
                            .collect(Collectors.toSet());
     * For shallow snapshot v2 clone, it checks the pinned timestamp to be greater than zero in the source snapshot.
                        repository.deleteSnapshotsWithPinnedTimestamp(
                updateWithSnapshots(currentState, updatedSnapshotsInProgress(currentState, newDeletions), newDeletions)
     * Unlike traditional snapshot operations, this method performs a synchronous clone execution and doesn't
        private final Map<String, Deque<SnapshotsInProgress.Entry>> snapshotsToFinalize = new HashMap<>();
                            + sourceSnapshotId
        @Override
    private boolean hasWildCardPatterForCloneSnapshotV2(String[] indices) {
                    }
    ClusterStateUpdateTask createStateWithoutSnapshotV2Task(String source, int attempt) {
     * operation.
                indicesForSnapshot = new ArrayList<>();
                } else {
        final boolean removed = currentlyFinalizing.remove(repository);
            for (SnapshotDeletionsInProgress.Entry entry : remainingEntries) {
                @Override
                            }
                    request.indices()
            );
            + localNode
        UpdateSnapshotStatusAction(
                    }
    public static final Setting<TimeValue> SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING = Setting.timeSetting(
                    }
        final SnapshotDeletionsInProgress snapshotDeletionsInProgress = state.custom(
        );
    private void stateWithoutSnapshotV2(ClusterState state) {
    }
            }
                        }
                                        );
                        newFinalizations.add(entry);
                final Set<Snapshot> snapshotListenerKeys = snapshotCompletionListeners.keySet();
        String repositoryName,
     *
                    }
                            + "]";
                executor.execute(ActionRunnable.supply(snapshotInfoListener, () -> repository.getSnapshotInfo(sourceSnapshotId)));
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;
        "snapshot.cleanup.retries",
                        final Map<RepositoryShardId, ShardSnapshotStatus> clonesBuilder = new HashMap<>();
     *
            remoteStoreIndexShallowCopy = false;
                        } else {
                final List<IndexId> indexIds = repositoryData.resolveNewIndices(
                                } else {
        Repository repository = repositoriesService.repository(repositoryName);
        } catch (Exception e) {
    private static boolean isWritingToRepository(SnapshotsInProgress.Entry entry) {
    protected void doStop() {
        assert transportService.getRequestHandler(UPDATE_SNAPSHOT_STATUS_ACTION_NAME) != null;
            throw new ConcurrentSnapshotExecutionException(
                    );
                        )
import org.opensearch.action.support.ActionFilters;
                            + updateSnapshotState
 * Unless required by applicable law or agreed to in writing,
         * Map of repository name to a deque of {@link SnapshotsInProgress.Entry} that need to be finalized for the repository and the
                latestKnownMetaData = null;
    /**
        List<SnapshotId> snapshotIds,
        }
     * @param snapshotIds snapshot ids to remove
                repoName
                            executeClone(localNodeId, cloneRemoteStoreIndexShardSnapshot);
    // Set of repositories currently running either a snapshot finalization or a snapshot delete.
    /**
                IndexRoutingTable indexShardRoutingTable = routingTable.index(shardId.getIndex());
                            minCompatibleVersion(minNodeVersion, repositoryData, snapshotsWithLockFiles),
                executor.execute(ActionRunnable.supply(snapshotInfoListener, () -> repository.getSnapshotInfo(sourceSnapshotId)));
    /**
                repository.deleteSnapshots(
                readyDeletions.add(newEntry);
        if (snapshotsInProgress.entries().size() == 1) {
                    throw new SnapshotException(
                            new SnapshotMissingException(runningSnapshot.getRepository(), runningSnapshot.getSnapshotId(), e)
            remoteStoreSettings.getSegmentsPathFixedPrefix()
        TimeValue.timeValueSeconds(1),
                    final SnapshotInfo cloneSnapshotInfo = new SnapshotInfo(
            new ActionListener<Void>() {
                    final ShardId shardId = indexRoutingTable.shard(i).shardId();
                                finishedSnapshots.add(snapshot);
                                    // We don't have a new assignment for this shard because its index was concurrently deleted
            public ClusterState execute(ClusterState currentState) throws Exception {
            public void onFailure(String src, Exception e) {
                    return true;
import org.opensearch.indices.RemoteStoreSettings;
        List<SnapshotId> inProgress,
                        final RepositoryShardId repoShardId = indexClone.getKey();
                            // need to finalize it.
                }
import static java.util.Collections.emptySet;
                protected SnapshotDeletionsInProgress filterDeletions(SnapshotDeletionsInProgress deletions) {
            }
                        repositoryName,
    private final RemoteStoreLockManagerFactory remoteStoreLockManagerFactory;
         * @param updatedDeletions deletions with removed entry
        String snapshotName = snapshot.getSnapshotId().getName();
            }
        try {
            } else {
         * by {@link SnapshotDeletionsInProgress.Entry#uuid()}.
                    listener.onResponse(snapshot);
            public void onFailure(String source, Exception e) {
        }
                                    }
                        continue;
            assertConsistent();
                            }
        final String repositoryName = request.repository();
                    }
     * @param currentState current cluster state
            }
        RepositoryData repositoryData,
                                SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotId);
        Collection<String> snapshotUUIDs = repositoryData.getSnapshotIds().stream().map(SnapshotId::getUUID).collect(Collectors.toSet());
        for (String dataStreamName : dataStreamsList) {
        for (SnapshotDeletionsInProgress.Entry entry : deletions.getEntries()) {
        protected final List<SnapshotsInProgress.Entry> newFinalizations = new ArrayList<>();
     *
        int attempt,
            return;
                                } else {
    /**
                        fallback
     * @param listener snapshot completion listener
                        }
                        );
                    shardStatus.generation()
            public void onFailure(Exception e) {
                    retryOrFailOnClusterManagerFailOver(
                if (entry.repository().equals(repository)) {
        }
                        endSnapshot(newEntry, newState.metadata(), repositoryData);
import org.opensearch.common.Nullable;
                public ClusterState execute(ClusterState currentState) {
                // Entering finalize loop here to prevent concurrent snapshots v2 snapshots
                // state).
                changedCount,
        @Nullable SnapshotDeletionsInProgress snapshotDeletionsInProgress
                            new FailPendingRepoTasksTask(repoName, e)
                    + "]"
                    request.indices()
     * <p>
                            shardSnapshotStatus = ShardSnapshotStatus.UNASSIGNED_QUEUED;
         *     <li>Snapshots that had all their shards reach a completed state while a delete was running (e.g. as a result of
                            return metaBuilder.build();
                }
        if (entry.isClone() && entry.state() == State.FAILED) {
        RepositoryShardId repoShardId,
            return true;
                    } else {
                        }
                        }
                                        failSnapshotCompletionListeners(
                if (isNewIndex) {
                    : IndexId.DEFAULT_SHARD_PATH_TYPE;
                    if (entry.snapshot().getSnapshotId().equals(updatedSnapshot.getSnapshotId())) {
    void retryOrFailOnClusterManagerFailOver(
            }
    private final Map<Snapshot, List<ActionListener<Tuple<RepositoryData, SnapshotInfo>>>> snapshotCompletionListeners =
            } catch (Exception ex) {
            @Override
            new LatchedActionListener<>(listener, latch)
                repositoryName,
     * @return minimum node version that must still be able to read the repository metadata
        return repositoryName + SNAPSHOT_PINNED_TIMESTAMP_DELIMITER + snapshotUUID;
            // with it.
import org.opensearch.cluster.ClusterStateTaskListener;
    /**
                                updateSnapshotState.updatedState.generation(),
        Repository repository,
                    "Modifying snapshot state should only ever fail because we failed to publish new state",
                );
                    if (entry.repository().equals(repository) && entry.state() == SnapshotDeletionsInProgress.State.STARTED) {
            if (entry.state().completed()) {
                if (readyDeletions.isEmpty()) {
                }
    );
            metadataListener.whenComplete(
            }
                        completeListenersIgnoringException(endAndGetListenersToResolve(snapshot), Tuple.tuple(newRepoData, snapshotInfo));
                            target.getSnapshotId(),
                while ((finalization = repositoryOperations.pollFinalization(repository)) != null) {
                failure.addSuppressed(new SnapshotException(snapshot, "no longer cluster-manager"));
                        source,
                        ActionListener.runBefore(
                                "Starting [{}] on [{}] with generation [{}]",
                );
        if (repositoriesMetadata == null || repositoriesMetadata.repository(repositoryName) == null) {
            // addLowPriorityApplier to make sure that Repository will be created before snapshot
    ) {
        Exception e,
                finalizeSnapshotEntry(entry, metadata, repositoryData);
            synchronized (endingSnapshots) {
import org.opensearch.common.settings.Settings;
import org.apache.logging.log4j.message.ParameterizedMessage;
        }
                logger.info("snapshot clone [{}] started", snapshot);
                        );
            entries.add(updatedEntry);
        if (DiscoveryNode.isClusterManagerNode(settings)) {
    }
                            }
        assert assertNoDanglingSnapshots(event.state());
                }
            @Override
            final Tuple<ClusterState, List<SnapshotDeletionsInProgress.Entry>> res = readyDeletions(
                            throw new SnapshotException(
                enteredRepoLoop = tryEnterRepoLoop(repositoryName);
                    final EnumSet<State> statesToUpdate;
                        foundSnapshots.add(entry.getValue());
     * Finds snapshot delete operations that are ready to execute in the given {@link ClusterState} and computes a new cluster state that
    private static void ensureSnapshotNameAvailableInRepo(RepositoryData repositoryData, String snapshotName, Repository repository) {
                new ShardSnapshotUpdate(request.snapshot(), request.shardId(), request.status()),
                                newFinalizations.add(entry);
            if (reposSeen.add(entry.repository())) {
                    knownFailures.put(shardId, failedState);
            }
                }
        logger.info("Found {} orphan timestamps. Cleaning it up now", orphanPinnedEntities.size());
        final Metadata.Builder builder;
            if ("*".equals(index)) {
                    logger.warn("Shallow snapshots are not supported during migration. Falling back to full snapshot.");
                        if (entry.getValue().state() == ShardState.MISSING) {
        assert snapshotDeletionListeners.isEmpty() : "Found leaked snapshot delete listeners "
                        e,
                }
            finalizeSnapshotEntry(nextFinalization.v1(), nextFinalization.v2(), repositoryData);
        @Nullable SnapshotsInProgress snapshotsInProgress,
                            // current entry is a clone operation
                threadPool.executor(ThreadPool.Names.SNAPSHOT).execute(() -> {
                final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                            );
                            .filter(entry -> entry.state() == SnapshotDeletionsInProgress.State.STARTED)
        try {
                        final ShardSnapshotStatus existing = entry.clones().get(finishedShardId);
     */
                            continue;
        private final Snapshot snapshot;
                    if (shardRouting != null && shardRouting.primaryShard() != null) {
                            shards.put(
        Repository repository = repositoriesService.repository(repositoryName);
     * @return shard snapshot status
            DataStream dataStream = metadata.dataStreams().get(dataStreamName);
                    snapshotChanged = true;
     * Handles failure to finalize a snapshot. If the exception indicates that this node was unable to publish a cluster state and stopped
        logger.trace("received updated snapshot restore state [{}]", update);
            "update snapshot state",
                clusterService,
            }
    ) {
        Version minCompatVersion = minNodeVersion;
                    );
            List<SnapshotDeletionsInProgress.Entry> updatedEntries = new ArrayList<>(remainingEntries.size());
    );
                    updatedEntries.add(entry);
            // or not in RepositoryData.
                    builder.put(indexId, id.id(), status.generation());
                if (FeatureFlags.isEnabled(FeatureFlags.SNAPSHOT_RESILIENCE_SETTING)) {
                for (int i = 0; i < updatedEntries.size(); i++) {
    private static <T> Setting.Validator<T> snapshotResilienceValidator(String settingKey) {
                        runNextQueuedOperation(repositoryData, snapshot.getRepository(), true);
                }));

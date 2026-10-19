                        }  
                        Collections.singletonList(snapshot.getSnapshotId()),
            @Override
                            createDeleteStateUpdate(outstandingDeletes, repoName, repositoryData, Priority.IMMEDIATE, listener)  
                    endingSnapshots.stream()
                        excludedWarmDfa
    private final TransportService transportService;  
                    if (entry.snapshot().getSnapshotId().equals(updatedSnapshot.getSnapshotId())) {  
                                ),
                            snapshotIdsRequiringCleanup.remove(existingNotYetStartedSnapshot.getSnapshotId());  
     */  
                                shardRepoGeneration
                    + ":"
     * @return shard snapshot status  
            public void onFailure(String source, Exception e) {
            .map(SnapshotDeletionsInProgress.Entry::repository)  
        if (changed) {
                repoName
                        } else {
                    return;
    ) {
            final Repository repo = repositoriesService.repository(snapshot.getRepository());
    private static ShardGenerations buildGenerationsV2(SnapshotsInProgress.Entry snapshot, Metadata metadata) {  
                    logger.debug("deleted snapshot completed - deleting files");
        if (ExceptionsHelper.unwrap(e, NotClusterManagerException.class) != null) {
                        for (SnapshotsInProgress.Entry completedSnapshot : completedWithCleanup) {
            assert pinnedEntities.get(pinnedEntity).size() == 1 : "Multiple timestamps for same repo-snapshot uuid found";  
        final String repositoryName = request.repository();  
        this.repositoriesService = repositoriesService;
            @Override
                builder.put(indexId, id.shardId(), status.generation());
                        .build();
    /**
            builder.putCustom(SnapshotsInProgress.TYPE, snapshotsInProgress);  
                        if (existing.state().completed()) {
                        ),
     * it then it will update the state of the snapshot entry accordingly. If that update was a noop, then the task is removed from the
            @Override  
                        changedCount++;
                    + deleteListenerKeys
     * a shallow snapshot and pinning the snapshot timestamp.The entire process is executed on the cluster manager node.
        1,  
                            );  
                "snapshot with the same name already exists"
                    );
            for (IndexId index : indices) {
     * Calculates the assignment of shards to data nodes for a new snapshot based on the given cluster state and the
                final List<SnapshotsInProgress.Entry> newEntries = new ArrayList<>(runningSnapshots);  
            }
        int attempt,  
                        if (tryEnterRepoLoop(entry.repository())) {  
        @Override  
            }
            logger.debug("[{}] was aborted before starting", snapshot);
 *  
            return value;  
                                newFinalizations.add(entry);
        final int nextAttempt = attempt + 1;
                }
        ActionListener<Void> listener  
                    if (changedNodes) {
        private final Snapshot snapshot;
                        );
                            logger.trace(
                            // If the entry is still in the cluster state and is completed, try finalizing the snapshot in the repo
        }  
            dataFormatRegistry
    private void innerUpdateSnapshotState(ShardSnapshotUpdate update, ActionListener<Void> listener) {
        String name,
                }
        final List<SnapshotDeletionsInProgress.Entry> newDeletes = new ArrayList<>();
                    logger.error("Interrupted while waiting for snapshot info processing", e);
                return currentState;
                    threadPool.absoluteTimeInMillis(),
    private final RemoteStorePinnedTimestampService remoteStorePinnedTimestampService;
        return builder.build();
                    final SnapshotInfo cloneSnapshotInfo = new SnapshotInfo(
                            );  
            );
                final IndexRoutingTable indexRoutingTable = routingTable.index(indexName);
                        // the update was already executed on the clone operation it applied to, now we check if it may be possible to
    public Version minCompatibleVersion(Version minNodeVersion, RepositoryData repositoryData, @Nullable Collection<SnapshotId> excluded) {  
                            } else {  
                );
            } else {
                            executeClone(localNodeId, cloneRemoteStoreIndexShardSnapshot);
            }  
                    logger.debug("Timestamp pinned successfully for clone snapshot {}", snapshot.getSnapshotId().getName());
                    + repositoryName  
     *  
        final String snapshotName = indexNameExpressionResolver.resolveDateMathExpression(request.snapshot());
                }
                final Version version = minCompatibleVersion(newState.nodes().getMinNodeVersion(), repositoryData, null);
                    throw new IllegalArgumentException(
            }  
                    // clean up snapshot v2 in progress or clone v2 present.
                        pinnedTimestampListener  
                        if (tryEnterRepoLoop(repoName)) {
     */
        List<SnapshotsInProgress.Entry> entries = new ArrayList<>();
                final RestoreInProgress restoreInProgress = currentState.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY);
                runReadyDeletions(repositoryData, repository);
                        .findFirst();
                    }
        }
            final Deque<SnapshotsInProgress.Entry> queued = snapshotsToFinalize.get(repository);
                }
    }
 */  
                        logger.info("snapshot [{}] completed with state [{}]", snapshot, snapshotInfo.state());  
                leaveRepoLoop(repository);  
                    }
                    failListenersIgnoringException(deleteListeners, failure);
                }
                            // No point in doing noop updates that might happen if data nodes resends shard status after a disconnect.  
    /**  
                                    routingTable,  
            } else {
            repoShardId = null;  
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                        clusterService.submitStateUpdateTask(  
     * Setting that specifies the time budget for snapshot repository I/O operations on the cluster-manager node  
        CloneSnapshotRequest request,
            "update snapshot after shards started [" + startShards + "] or node configuration changed [" + changedNodes + "]",
    }
                                logger.info("snapshots {} deleted", snapshotsWithPinnedTimestamp);
                } catch (InterruptedException e) {
            innerUpdateSnapshotState(  
    void runReadyClone(
     */
        initializingClones.add(snapshot);
            SHARD_STATE_EXECUTOR,
        final Consumer<Exception> onFailure = e -> {
    private void createSnapshotPreValidations(  
    ) {  
                logger.warn("failing snapshot of shard [{}] on unassigned shard [{}]", shardId, shardStatus.nodeId());
                        "delete snapshot",  
                        new RepositoryException(repository.getMetadata().name(), "cannot create snapshot-v2 in a readonly repository")
                    }  
    }  
        final long expectedRepoGen = deleteEntry.repositoryStateId();  
                                "Starting [{}] on [{}] with generation [{}]",  
            .stream()
        }
                ).getEntries()) {
                                canBeUpdated.add(value.getKey());
        private final ActionListener<Snapshot> userCreateSnapshotListener;
        });
        ShardSnapshotUpdate(Snapshot snapshot, RepositoryShardId repositoryShardId, ShardSnapshotStatus updatedState) {
                listener.onFailure(e);
        TransportService transportService,  
    public boolean assertAllListenersResolved() {  
                            shardSnapshotStatus = new ShardSnapshotStatus(primary.currentNodeId(), ShardState.WAITING, shardRepoGeneration);
        @Override  
                                logger.warn("Failed to get snapshot info for {} with exception {}", snapshotId, e);  
                            + "] received update for clone ["  
        };
        snapshotDeletionListeners.computeIfAbsent(deleteUUID, k -> new CopyOnWriteArrayList<>()).add(listener);
        Setting.Property.Dynamic
                    null,
     * orphaned by previously interrupted deletes.  
     */
    public static String getPinningEntity(String repositoryName, String snapshotUUID) {
     * @param minNodeVersion minimum node version in the cluster  
                    currentState.metadata(),
                if (completedNoCleanup.isEmpty() == false) {
        Metadata metadata,  
                        SnapshotDeletionsInProgress.TYPE,  
            SnapshotDeletionsInProgress.EMPTY
                            continue;  
                        IndexRoutingTable indexShardRoutingTable = event.state().getRoutingTable().index(shardId.getIndex());
                "Cannot start another operation, already running ["  
                        }  
                            } catch (Exception e) {
                            if (endingSnapshots.add(existingNotYetStartedSnapshot)) {  
     * {@link SnapshotDeletionsInProgress.State#STARTED} or waiting entries in state {@link SnapshotDeletionsInProgress.State#WAITING}
    public static Tuple<String, String> getRepoSnapshotUUIDTuple(String pinningEntity) {
                                .noneMatch(
                    updatedSnapshots,  
            handleListeners(deleteListeners);
        };  
            RepositoryCleanupInProgress.EMPTY
                            remoteStoreLockManagerFactory,  
public class SnapshotsService extends AbstractLifecycleComponent implements ClusterStateApplier {
    /**
    }
        @Nullable  
                        ShardRouting shardRouting = indexShardRoutingTable.shard(shardId.id()).primaryShard();  
                            SnapshotsInProgress.EMPTY  
                                        )  
            public void onResponse(RepositoryData repositoryData) {  
            final List<ActionListener<Void>> deleteListeners;
        assert currentlyFinalizing.contains(repository);  
        Setting.Property.NodeScope,
            + snapshotCompletionListeners
    /**
                    )  
                boolean isSnapshotV2 = SHALLOW_SNAPSHOT_V2.get(repository.getMetadata().settings());
            indexNameExpressionResolver  
        final SnapshotId sourceSnapshot = cloneEntry.source();
        );  
    private void updateSnapshotPinnedTimestamp(Snapshot snapshot, long timestampToPin) throws Exception {
                        "setting ["
            return null;  
import org.opensearch.common.util.FeatureFlags;
        ensureSnapshotNameAvailableInRepo(repositoryData, snapshotName, repository);
            }, e -> listener.onFailure(e));
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                public void onFailure(String source, Exception e) {
                    .map(SnapshotsInProgress.Entry::source)  
                        // Collect waiting shards that in entry that we can assign now that we are done with the deletion  
                        metaBuilder.put(repo.getSnapshotIndexMetaData(repositoryData, entry.source(), index), false);  
                        // snapshots  
            }  
        }
    }  
                                snapshotName,
                    + " as well as "  
    /**  
            @Override
        // Tasks that were used to complete an existing in-progress shard snapshot  
            repositoryOperations.finishDeletion(deleteEntry.uuid());  
            if (queued == null) {
     * {@link SnapshotsInProgress#entries()} and {@link SnapshotDeletionsInProgress#getEntries()}.  
                    target.getSnapshotId()
                        shardRepoGeneration = ShardGenerations.NEW_SHARD_GEN;
                        if (indexShardRoutingTable == null) {
                if (remoteStoreIndexShallowCopy  
                private final Collection<SnapshotsInProgress.Entry> finishedSnapshots = new ArrayList<>();
 * You may obtain a copy of the License at  
        return Collections.unmodifiableMap(builder);
            )
                        throw new ConcurrentSnapshotExecutionException(
     *  
    /**
                            // a lookup for the index ids
        RemoveSnapshotDeletionAndContinueTask(SnapshotDeletionsInProgress.Entry deleteEntry, RepositoryData repositoryData) {
                    + SHALLOW_SNAPSHOT_V2.getKey()
     * @param snapshotsInProgress         new value for {@link SnapshotsInProgress} or {@code null} if it's unchanged
    // Set of snapshots that are currently being ended by this node
            this.repository = repository;
        @Override
        final SnapshotDeletionsInProgress snapshotDeletionsInProgress = state.custom(
            .filter(e -> e.partial() == false)
    private static ClusterState stateWithoutSnapshot(ClusterState state, Snapshot snapshot) {  
                                updateSnapshotState,
            return UpdateIndexShardSnapshotStatusResponse.INSTANCE;  
        final ShardRouting primary = currentState.routingTable().index(shardId.getIndex()).shard(shardId.id()).primaryShard();  
                changed = true;
                    // Snapshot had an incomplete shard running on a removed node so we need to adjust that shard's snapshot status  
                final Version version = minCompatibleVersion(currentState.nodes().getMinNodeVersion(), repositoryData, null);
                    }
     */
                    if (listener != null) {
                        shardRepoGeneration = inFlightGeneration;
                        assert shardGenerations.getShardGen(index, shardId.getId()) == null : "Found shard generation for new index ["
                    IndexId.DEFAULT_SHARD_PATH_TYPE
                repository.finalizeSnapshot(  
                    newDelete = new SnapshotDeletionsInProgress.Entry(  
        } catch (InterruptedException e) {
     * Handles a cluster-state-update onFailure by either retrying (if the publish failed but this node is still the
        }  
                        deletions,
            }
    static void validateNoSegmentsOnlyIndices(ClusterState state, String repositoryName, String snapshotName) {  
     * {@link #failAllListenersOnMasterFailOver}. Otherwise, i.e. as a result of failing to write to the snapshot repository for some
        try {
                        for (Tuple<IndexId, Integer> count : counts) {  
    }
                        .filter(
            protected void doRun() {
     * @param request snapshot request
                .build(ClusterState.builder(currentState).putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(entries)).build());  
         */  
        logger.info("Found {} orphan timestamps. Cleaning it up now", orphanPinnedEntities.size());  
        if (segmentsOnlyIndices.isEmpty() == false) {  
            finalizeSnapshotEntry(nextFinalization.v1(), nextFinalization.v2(), repositoryData);
            }
            private final Collection<SnapshotsInProgress.Entry> completedWithCleanup = new ArrayList<>();  
        synchronized void clear() {  
                return ClusterState.builder(currentState)  
    ) {  
    private volatile int maxRetries;
        RepositoryData repositoryData,
                        runReadyClone(target, sourceSnapshot, shardStatusBefore, repoShardId, repository, remoteStoreIndexShallowCopy);
import java.util.function.Function;  
            return snapshotsInProgress.entries();  
                            );
            final StepListener<RepositoryData> repositoryDataListener = new StepListener<>();
                            + FeatureFlags.SNAPSHOT_RESILIENCE
                                finishedStatus.nodeId(),
        assert failure != null : "Failure must be supplied";
                    snapshotDeletionsInProgress.getEntries().stream().map(SnapshotDeletionsInProgress.Entry::uuid),  
        /**  
                        indicesForSnapshot.add(indexId.getName());  
     * @param repository snapshot repository
                    dataStreams,  
    /**
            final Snapshot running = s.snapshot();  
                            listener.onFailure(e);
            }  
     *
            }
            if (indexMetadata == null) {  
     * @param listener completion listener
                } else {
    }
        List<SnapshotId> snapshotIds,
     * operations if there are any.
        if (snapshotsInProgress.entries().isEmpty() == false) {
                        sourceSnapshotId.getName(),
        Runnable failoverFallback
                        snapshotName,
                            + "]";
                    assert snapshotsToFail.contains(finalization.v1().snapshot()) : "["
        final SnapshotId snapshotId = new SnapshotId(snapshotName, UUIDs.randomBase64UUID()); // new UUID for the snapshot
     * @param deleteEntry delete entry to remove from the cluster state
                );
                }));  
        return Tuple.tuple(
    private void stateWithoutSnapshotV2(ClusterState state) {
            public void onFailure(Exception e) {
        }
    }
                            for (IndexId index : newEntry.indices()) {
                shardGeneration
import org.opensearch.cluster.metadata.Metadata;
                        listener.onFailure(e);
        if (snapshotDeletionsInProgress != null) {
            public TimeValue timeout() {
                public void onFailure(Exception e) {  
        repository.executeConsistentStateUpdate(repositoryData -> new ClusterStateUpdateTask(Priority.URGENT) {
        );
        }
                    failSnapshotCompletionListeners(snapshot, failure);  
                        logger.warn("cluster-manager failover before deleted snapshot could complete", e);
                            .collect(Collectors.toList())  
        if (listeners != null) {  
                    "Failed to get repository data while cloning shard [{}] from [{}] to [{}]",
                );
 * the Apache License, Version 2.0 (the "License"); you may
            RepositoryCleanupInProgress.EMPTY
            }  
     */
                                        return;
                                }
     * being the cluster-manager node, then fail all snapshot create and delete listeners executing on this node by delegating to
            return this.snapshot.equals(that.snapshot)  
        repository.executeConsistentStateUpdate(repositoryData -> new ClusterStateUpdateTask(Priority.NORMAL) {  
     * fact that a task was executed by adding it to a collection of executed tasks. If a subsequent execution of the outer loop finds that  
                                listener.onFailure(
                for (IndexId index : entry.indices()) {
                new ShardSnapshotUpdate(request.snapshot(), request.shardId(), request.status()),
     */
                    repoName
     * Setting that specifies the maximum number of outstanding (dispatched but uncompleted) cluster-manager-side
    /**  
 * deletion.  
                    }
        private final Exception e;
                        repositoryData.getGenId(),
        String source,  
        }
    private void runNextQueuedOperation(RepositoryData repositoryData, String repository, boolean attemptDelete) {
                        snapshotName,
                assert runningSnapshots.containsAll(snapshotListenerKeys) : "Saw completion listeners for unknown snapshots in "
                );
        if (inProgressOperations >= maxOps) {
    ) {
                            );
                shardFailures,  
                indexNameExpressionResolver
        }
            }
                        + repositoryData.getGenId()
            public ClusterState execute(ClusterState currentState) {
                    listener.onFailure(e);  
        // Stale blobs/lock-files will be cleaned up during delete/cleanup operation.  
        String[] tokens = pinningEntity.split(SNAPSHOT_PINNED_TIMESTAMP_DELIMITER);  
            .flatMap(e -> e.dataStreams().stream())  
    private final RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory;
            threadPool,
 * @opensearch.internal  
                            clones.put(finishedShardId, new ShardSnapshotStatus(finishedStatus.nodeId(), finishedStatus.generation()));
                    .filter(src -> src.getName().equals(request.source()))  
            assertConsistent();
        })) {
                    changedSnapshots = true;
        try {
                    repositoryData.getGenId(),
        try {
                        snapshotName,
            if (entry.repository().equals(repository)) {  
import org.opensearch.cluster.metadata.DataStream;
                        if (statesToUpdate.contains(snapshot.state())) {  
                        "[{}][{}] excluded warm-tiered pluggable data format indexes from snapshot v2: {}",
                    );
     * </p>
                        }
        SnapshotDeletionsInProgress deletionsInProgress
                                    continue;
                .noneMatch(entry -> entry.repository().equals(repoName) && entry.state() == SnapshotDeletionsInProgress.State.STARTED);
                try {  
     * Finalizes the snapshot in the repository.  
                            // write anything to the repository physically. This means we can simply remove these from the cluster state
        return listenersToComplete;
                } finally {  
        for (String snapshotOrPattern : snapshotsOrPatterns) {
            TransportService transportService,
                    Thread.currentThread().interrupt();  
                final StepListener<SnapshotInfo> snapshotInfoListener = new StepListener<>();
                    RepositoryCleanupInProgress.TYPE,
            throw new ConcurrentSnapshotExecutionException(
                ex.set(e);
                    public void onResponse(Void unused) {}
            SnapshotsInProgress.Entry entry = snapshotsInProgress.entries().get(0);
            if (newFinalizations.isEmpty()) {  
        return indices;
                // Entry is writing to the repo because it's writing to a shard on a data node or waiting to do so for a concrete shard
     * @param repositoryData current {@link RepositoryData} for the repository we just ran the delete on.
                        toDelete,
         * by {@link SnapshotDeletionsInProgress.Entry#uuid()}.
        } else {
                            + deleteEntry  
            this.snapshot = snapshot;  
import org.opensearch.cluster.RepositoryCleanupInProgress;
                            final IndexMetadata indexMetadata = repository.getSnapshotIndexMetaData(  
                        runNextQueuedOperation(newRepoData, repository, true);
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        if (repositoryOperations.isEmpty() == false) {
                                    finishedShardId,
                for (int i = 0; i < updatedEntries.size(); i++) {
            return res.v1();
        for (String dataStreamName : dataStreamsList) {
            () -> new ParameterizedMessage(
            public ClusterState execute(ClusterState currentState) {  
                            assert false : "This should never happen, data nodes should only send updates for expected shards";
                final List<SnapshotsInProgress.Entry> runningSnapshots = snapshots.entries();
    /**
                            new FailPendingRepoTasksTask(repoName, e)
                                    updatedSnapshotEntries.add(updatedSnapshot);
         * </ul>
     * causes another operation to become ready can execute.
            shardSnapshotStatus = new ShardSnapshotStatus(primary.currentNodeId(), shardGeneration);
            new ActionListener<Void>() {
                    boolean changed = false;  
                        repositoryName,
                                }  
        4,  
            @Override
                        final IndexMetadata metadata = repository.getSnapshotIndexMetaData(repositoryData, sourceSnapshot, index);  
     * For shallow snapshot v2 clone, it checks the pinned timestamp to be greater than zero in the source snapshot.
                    ex -> {
            removeFailedSnapshotFromClusterState(entry.snapshot(), new SnapshotException(entry.snapshot(), entry.failure()), null, null);
                    shards.put(shardId, shardStatus);
            }
            && clusterService.state().nodes().getMinNodeVersion().onOrAfter(Version.V_2_17_0)) {
                    remoteStoreIndexShallowCopy
                    for (SnapshotDeletionsInProgress.Entry readyDeletion : readyDeletions) {
import org.opensearch.common.settings.Settings;
    }
    }  
                            deleteSnapshotsFromRepository(newDelete, repositoryData, newState.nodes().getMinNodeVersion());
            if (snapshot.state().completed()) {  
        Setting.Property.NodeScope,  
    }  
            final Tuple<ClusterState, List<SnapshotDeletionsInProgress.Entry>> res = readyDeletions(  
                ? ClusterState.builder(currentState)  
     * @param e              exception encountered  
            repositoryDataListener.whenComplete(repositoryData -> {  
            for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
     */  
                    final List<ActionListener<Void>> listeners = iterator.next();
            final String indexName = index.getName();
            && isSnapshotV2
                    }
    }
                sourceSnapshotId = repositoryData.getSnapshotIds()
                        + index
        });
                if (snapshotIdsRequiringCleanup.isEmpty()) {  
    ) {
                        );
                    .filter(entry -> entry.repository().equals(repoName) && entry.state() == SnapshotDeletionsInProgress.State.WAITING)
                            + Strings.arrayToCommaDelimitedString(request.indices())  
     * Fail here instead. Full snapshots and shallow v1 remain available, both of which flush before capturing a  
        Exception failure,  
                // Store newSnapshot here to be processed in clusterStateProcessed
     * @param minNodeVersion    minimum node version in the cluster  
     * Handles failure to finalize a snapshot. If the exception indicates that this node was unable to publish a cluster state and stopped  
                            + index  
                            if (existingStatus == null || existingStatus.state() != ShardState.QUEUED) {
                    indices,  
    /**
                                        );  
     * Remove a snapshot from {@link #endingSnapshots} set and return its completion listeners that must be resolved.
        /**  
     * Updates the state of in-progress snapshots in reaction to a change in the configuration of the cluster nodes (cluster-manager fail-over or  
                    final SnapshotDeletionsInProgress snapshotDeletionsInProgress = newState.custom(
        final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);  
    /**
                return Collections.emptyList();  
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_SNAPSHOT;
import org.apache.logging.log4j.LogManager;
                });
        if (orphanPinnedEntities.isEmpty()) {  
                    }  
     * used when the snapshot fails for some reason. During normal operation the snapshot repository will remove the
        final Map<String, Object> userMeta = repository.adaptUserMetadata(request.userMetadata());
            }  
        @Override
                final String updatedRepository = updatedSnapshot.getRepository();
     */
                                // only remove the update from the list of tasks that might hold a reusable shard if we actually
                            if (reposWithRunningDeletes.contains(entry.repository()) == false) {
    }  
     * @param repositoryName repository name
                                shardRepoGeneration
                if (indexMetadata == null) {  
                final List<String> indices = new ArrayList<>();
        RepositoriesMetadata repositoriesMetadata = state.getMetadata().custom(RepositoriesMetadata.TYPE);  
     *                    successfully  
            return null;
        }  
        }
                                    updatedAssignmentsBuilder.put(shardId, updated);
                    // starting shard clones.  
            .collect(Collectors.toSet());
        final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);
        logger.trace("received updated snapshot restore state [{}]", update);  
            );
    /**
            throws Exception {
            final String repoName = deleteEntry.repository();  
                final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
    }  
            public void onFailure(Exception e) {  
            }, onFailure));
                if (newClusterManager && snapshotsInProgress.entries().isEmpty() == false) {  
        }
            }
    }  
                    return metaBuilder.build();
                    }  
        this.remoteStorePinnedTimestampService = remoteStorePinnedTimestampService;
                }  
        );
                        changed = true;  
            }  
            if (dataStream == null) {
        } else {  
        final ArrayList<SnapshotDeletionsInProgress.Entry> readyDeletions = new ArrayList<>();
    @Override
                        () -> createStateWithoutSnapshotV2Task(source, attempt + 1),
            return emptySet();
            private ActionListener<String> getCloneCompletionListener(String localNodeId) {  
            assert false : new AssertionError(e);
            final String failure = entry.failure();
            .sorted()
    private final Set<RepositoryShardId> currentlyCloning = Collections.synchronizedSet(new HashSet<>());
        if (deletions.hasDeletionsInProgress() == false) {  
                    assert repositoryData.getSnapshotIds().stream().noneMatch(deleteEntry.getSnapshots()::contains)
                final ShardSnapshotUpdate updateSnapshotState = iterator.next();
        }  
            @Override
                    if (snapshotsWithPinnedTimestamp.size() > 0) {
    }  
                                }  
                @Override
                            shards = new HashMap(entry.shards());
        );  
                        try {
                ActionListener.onResponse(listeners, result);
     *  
                } else {  
            if (entry.isClone()) {
            } else {  
        private final List<String> deletionsToFail = new ArrayList<>();
        @Override  
                            }, ex -> removeSnapshotDeletionFromClusterState(deleteEntry, ex, repositoryData))
                    // We failed to read repository data for this delete, it is not the job of SnapshotsService to
    private void failSnapshotCompletionListeners(Snapshot snapshot, Exception e) {  
                        startTime,
    private final Set<Snapshot> initializingClones = Collections.synchronizedSet(new HashSet<>());
     * @return updated cluster state  
                if (isNewIndex) {
                    for (final Map.Entry<ShardId, ShardSnapshotStatus> entry : shards.entrySet()) {  
        String repositoryName
    static final class ShardSnapshotUpdate {  
                        builder.add(entry);
     * has all executable deletes marked as executing. Returns a {@link Tuple} of the updated cluster state and all executable deletes.
                    new FailPendingRepoTasksTask(deleteEntry.repository(), e)
            }  
                        final ShardSnapshotStatus existing = entry.shards().get(finishedShardId);  
                    // We only saw snapshots that could be removed from the cluster state right away, no need to update the deletions
    }
                }
                        excludedWarmDfa.size()
        endingSnapshots.remove(snapshot);
                return updateWithSnapshots(
                    }
     * @param indices             Indices to snapshot
                return updateWithSnapshots(
                    repositoryData.getGenId(),
                            repositoryData.getGenId(),
                } else {
            }
     */
            () -> repositoriesService,
    ) {
        "snapshot.max_concurrent_operations",  
                startCloning(repository, newEntry);
            final List<SnapshotDeletionsInProgress.Entry> remainingEntries = deletionsInProgress.getEntries();  
        }
    /**
                    ActionListener.wrap(newRepoData -> {
                    true
import org.opensearch.action.support.ActionFilters;  
                    metadataForSnapshot(meta, entry.includeGlobalState(), entry.partial(), entry.dataStreams(), entry.indices()),
                                        + shardId
                    // TODO: Restart snapshot on another node?
            }
                    snapshotInfo,
        final ClusterStateUpdateTask clusterStateUpdateTask;
     *
                clusterService.submitStateUpdateTask(  
                            remoteStoreIndexShallowCopy
        @Nullable  
     *
                // move to in progress  
                entry.startTime(),
                            getCloneCompletionListener(localNodeId)
                assert false : new AssertionError(
    private void deleteSnapshotsFromRepository(
import org.opensearch.core.common.io.stream.StreamInput;
                        startExecutableClones(snapshotsInProgress, update.snapshot.getRepository());  
                        cloneSnapshotV2(request, snapshot, repositoryName, repository, listener);
        IndexNameExpressionResolver indexNameExpressionResolver,
                final ShardId shardId = indexRoutingTable.shard(i).shardId();
    // for repository metadata and loading it has predictable performance  
                    executeClone(localNodeId, false);
                final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                    } else {
     * An update to the snapshot state of a shard.
                            finishedShardId,  
        } else if (primary.started() == false) {  
                snapshotName,
                                } else {
            ActionListener<UpdateIndexShardSnapshotStatusResponse> listener
            // 2. step, load the number of shards we have in each index to be cloned from the index metadata.
                failAllListenersOnMasterFailOver(new NotClusterManagerException(src));
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "must not contain whitespace");  
    }
     * This method is executed on cluster-manager node
                        + finalization.v1()  
    );  
     */  
            removeFailedSnapshotFromClusterState(targetSnapshot, e, null, null);
         * @return updated snapshot in progress instance or {@code null} if there are no changes to it
                                    assert added;
                        if (canBeUpdated.isEmpty()) {
                    );
                        }  
                                );  
                    if (foundDuplicate.isPresent()) {
            removeFailedSnapshotFromClusterState(snapshot, e, repositoryData, null);
    public static final Setting<Boolean> SNAPSHOT_DELETE_CLEANUP_STALE_BLOBS_SETTING = Setting.boolSetting(  
                    + "pinned timestamp requires replaying the remote translog. Disable "
                }
import org.opensearch.action.StepListener;
    private class UpdateSnapshotStatusAction extends TransportClusterManagerNodeAction<
    // Assert that there are no snapshots that have a shard that is waiting to be assigned even though the cluster state would allow for it
                return request.clusterManagerNodeTimeout();
            this.failure = failure;
    }
            if (this == other) {  
                                    logger.warn("Cluster state update after successful shard clone [{}] failed", repoShardId);
            }
        RemoteStoreSettings remoteStoreSettings,  
        } else {  
import org.opensearch.common.Nullable;  
        if (ex.get() != null) {
        RepositoryData repositoryData
        final RepositoryCleanupInProgress repositoryCleanupInProgress = currentState.custom(  
                                        );
            }  
            } else {
     * @param excluded       snapshot id to ignore when computing the minimum version
            getPinningEntity(snapshot.getRepository(), sourceSnapshot.getUUID()),
                }  
                    userMeta,
                    if (finishedSnapshots.isEmpty() == false) {  
        Snapshot snapshot,
                        repository.cloneShardSnapshot(
     * If the inner loop finds that a shard update task applies to a given snapshot and either a shard-snapshot or shard-clone operation in
                            if (shardSnapshotStatus.isActive()) {
                    request.indices()  
        final ShardGenerations shardGenerations = repositoryData.shardGenerations();
            assert false : new AssertionError(e);
                            metadataForSnapshot(meta, newEntry.includeGlobalState(), false, newEntry.dataStreams(), newEntry.indices()),
            );
                            sourceSnapshot,
        };
        protected UpdateIndexShardSnapshotStatusResponse read(StreamInput in) throws IOException {
                if (nodes.nodeExists(shardStatus.nodeId())) {
                        null,  
                    continue;
                            }, ex -> removeSnapshotDeletionFromClusterState(deleteEntry, ex, repositoryData))  
            entries.add(updatedEntry);
    private boolean hasWildCardPatterForCloneSnapshotV2(String[] indices) {
     * Only modifiable when the snapshot resilience feature flag is enabled.
            userCreateSnapshotListener.onFailure(e);
                        "No indices in the source snapshot ["  
     * @return tuple of an updated cluster state and currently executable snapshot delete operations
                    try {
            .distinct()
                            final boolean cloneRemoteStoreIndexShardSnapshot = indexMetadata.getSettings()
     * @param startShards  true iff any waiting shards were started due to a routing change  
    private static Tuple<ClusterState, List<SnapshotDeletionsInProgress.Entry>> readyDeletions(ClusterState currentState) {
            // Computing the new assignments can be quite costly, only do it once below if actually needed
            public ClusterState execute(ClusterState currentState) {
                            new Snapshot(repositoryName, snapshotId),
            timestampToPin,
                        ShardGenerations shardGenerations = buildGenerationsV2(newEntry, meta);  
            && clusterService.getClusterSettings().get(REMOTE_STORE_COMPATIBILITY_MODE_SETTING).equals(CompatibilityMode.MIXED)) {  
        String[] snapshotNames,
    private final Map<Snapshot, List<ActionListener<Tuple<RepositoryData, SnapshotInfo>>>> snapshotCompletionListeners =
                                            snapshot,  
                    currentState.routingTable(),
                        }
                            // BwC path, older versions could create entries with unknown repo GEN in INIT or ABORTED state that did not yet
                                                "Aborting Snapshot-v2 clone, no longer cluster manager"
        TimeValue.timeValueSeconds(1),
    }  
     * @param shardGeneration         shard generation of the shard in the repository
            public void onFailure(String source, Exception e) {
                return updateWithSnapshots(currentState, changed ? SnapshotsInProgress.of(updatedEntries) : null, null);  
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SHALLOW_SNAPSHOT_V2;  
    ) {
    }
     * Initializes the snapshotting process for clients when Snapshot v2 is enabled. This method is responsible for taking  
    /**  
            shardSnapshotStatus = new ShardSnapshotStatus(primary.currentNodeId(), ShardState.WAITING, shardGeneration);
            return;
    }  
                }
                repositoryOperations.addFinalization(entry, metadata);
                    request.includeGlobalState(),  
                    failSnapshotCompletionListeners(snapshot, new SnapshotException(snapshot, SnapshotsInProgress.ABORTED_FAILURE_TEXT));  
    @Override
        }
                            repositoryData.getGenId(),  
                            );  
                    shards.put(shardId, shardStatus);  
     */
 */  
                    final SnapshotDeletionsInProgress updatedDeletions = deletionsWithoutSnapshots(
import java.util.ArrayList;  
        long startTime = System.currentTimeMillis();  
        validate(repositoryName, snapshotName);
                    final ShardSnapshotStatus failedState = new ShardSnapshotStatus(
         * {@link SnapshotDeletionsInProgress} that has a {@link SnapshotDeletionsInProgress.Entry} removed from it  
            }
                };
import java.util.HashMap;  
                final ShardSnapshotStatus failedState = new ShardSnapshotStatus(
                for (String indexName : allIndices) {
        if (repositoryCleanupInProgress.hasCleanupInProgress()) {
        this.transportService = transportService;  
                    SnapshotDeletionsInProgress.TYPE,
    /**
                            assert false
                        }
        deleteSnapshotTaskKey = clusterService.registerClusterManagerTask(DELETE_SNAPSHOT, true);
                endingSnapshots.removeAll(completedNoCleanup);
                }
                                } else {
            }  
            }  
            getPinningEntity(snapshot.getRepository(), snapshot.getSnapshotId().getUUID()),  
import org.opensearch.ExceptionsHelper;
        TimeValue.timeValueMillis(100),
        final Map<ShardId, ShardSnapshotStatus> shards = new HashMap<>();
            .collect(Collectors.toMap(SnapshotId::getName, Function.identity()));
                            "[{}] Updating shard clone [{}] with status [{}]",
                final String repoName = cloneEntry.repository();  
                    SnapshotDeletionsInProgress.TYPE,  
            throw new InvalidSnapshotNameException(
                    .stream()
                                continue;
            if (value.compareTo(TimeValue.timeValueSeconds(1)) < 0) {  
                            return metaBuilder.build();
        for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
                    if (idxMd != null
     *  
            final SnapshotDeletionsInProgress deletions = currentState.custom(SnapshotDeletionsInProgress.TYPE);
     * {@link ShardState#WAITING}.
            }
    }  
                logger.info("snapshot clone [{}] started", snapshot);
        boolean snapshotChanged = false;  
        validate(repositoryName, snapshotName, currentState);
     * Determine the number of shards in each index of a clone operation and update the cluster state accordingly.
                }
                    }  
                    IndexMetadata indexMetadata = currentState.metadata().index(index.getName());  
                        );  
            }  
                                }  
                    }
        }
        }  
            TimeValue value = TimeValue.parseTimeValue(s, IO_TIMEOUT_KEY);
import org.opensearch.cluster.ClusterStateUpdateTask;  
            snapshot.clones().forEach((id, status) -> {
            }
    static boolean isOrphanPinnedEntity(String repoName, Collection<String> snapshotUUIDs, String pinnedEntity) {
                initializingClones.remove(targetSnapshot);  
                                "primary shard is not allocated",
                            final ShardSnapshotStatus shardSnapshotStatus = startShardSnapshotAfterClone(
                List<SnapshotId> snapshotsWithLockFiles = Collections.synchronizedList(new ArrayList<>());  
                                    nodes,
                final ShardSnapshotStatus knownFailure = knownFailures.get(shardId);
                for (String delete : deletionsToFail) {
                        }
                    );  
                        // this CS update finishes
                        executedTasks.add(updateSnapshotState);
                final Map<ShardId, ShardSnapshotStatus> shards = shards(
            clusterService.getClusterSettings().addSettingsUpdateConsumer(SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING, t -> retryBackoff = t);
                logger.warn(
        CloneSnapshotRequest request,
                        } else if (abortedEntry.state().completed()) {
                            assert finishedStatus.nodeId().equals(localNodeId) : "Clone updated with node id ["
                            .map(SnapshotDeletionsInProgress.Entry::repository)
                                failSnapshotCompletionListeners(
                        SnapshotDeletionsInProgress.EMPTY
                    + " but running snapshots are "
            }  
        }
                    currentState,  
     * @param deleteEntry       delete entry in cluster state
    private boolean tryEnterRepoLoop(String repository) {  
            assert deleteEntry.state() == SnapshotDeletionsInProgress.State.STARTED : "incorrect state for entry [" + deleteEntry + "]";
     * Returns a {@link Setting.Validator} that rejects updates when the snapshot resilience feature flag is disabled.  
                final List<String> dataStreams = indexNameExpressionResolver.dataStreamNames(
            public ClusterState execute(ClusterState currentState) {
        }  
                            repositoryData.getGenId(),
        }
                }
                    Set<String> missing = new HashSet<>();
                        + snapshotsToFail;
            };
        if (attempt >= maxRetries) {
        long pinnedTimestamp = System.currentTimeMillis();  
                    );
                        throw new SnapshotMissingException(repositoryName, snapshotOrPattern);  
                validateSnapshotsBackingAnyIndex(currentState.getMetadata().getIndices(), snapshotIds, repoName);  
                    }
                    @Override
        if (snapshotName.toLowerCase(Locale.ROOT).equals(snapshotName) == false) {
                    indexIds,
                builder.put(new ShardId(indexName, IndexMetadata.INDEX_UUID_NA_VALUE, 0), ShardSnapshotStatus.MISSING);
                createSnapshotPreValidations(currentState, repositoryData, repositoryName, snapshotName);
                        if (delete.state() == SnapshotDeletionsInProgress.State.STARTED) {  
                    // run newly ready deletes
        }  
        final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
            }
                            clone.getKey(),  
                    if (shardStatus.getValue().state() != ShardState.WAITING) {
                        @Override
        Metadata metadata,
        }
     * This method is responsible for creating a clone of the shallow snapshot v2.
                    shards,
                }
                        repository.deleteSnapshotsAndReleaseLockFiles(
        return entries;
        return Objects.equals(tokens.v1(), repoName) && snapshotUUIDs.contains(tokens.v2()) == false;  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
                    assert outstandingDeletes == null : "Shouldn't have outstanding deletes after already starting delete task";  
     * With a local translog there is nothing to replay from: the restore fails outright because it cannot resolve a  
                            () -> currentlyCloning.remove(repoShardId)
                        }
                        throw new SnapshotException(  
                                if (inFlightShardStates.isActive(indexName, shardId)) {
    @Nullable  
        }
                && snapshotsInProgress.entries()
        boolean remoteStoreIndexShallowCopy = REMOTE_STORE_INDEX_SHALLOW_COPY.get(repository.getMetadata().settings());  
                            );
import org.opensearch.cluster.routing.RoutingTable;
    private static ShardSnapshotStatus startShardSnapshotAfterClone(ClusterState currentState, String shardGeneration, ShardId shardId) {
            public TimeValue timeout() {  
        }
                }
            try {  
                    metadataListener.whenComplete(meta -> {
                    final ShardId shardId = shardStatus.getKey();
 *
        logger.debug("remote_store_index_shallow_copy setting is set as [{}]", remoteStoreIndexShallowCopy);
     * delay is clamped to a sane maximum in case maxRetries/retryBackoff are configured to large values.
                        final Map<RepositoryShardId, ShardSnapshotStatus> clonesBuilder = new HashMap<>();
        }
    }
                new SnapshotException(snapshot, "Aborted on initialization"),
                // Entering finalize loop here to prevent concurrent snapshots v2 snapshots  
                                    knownFailures.computeIfAbsent(snapshot.repository(), k -> new HashMap<>())
                    getInFlightIndexIds(runningSnapshots, repositoryName),
                            }
                    } else {  
     * @param attemptDelete  whether to try and run delete operations that are ready in the cluster state if no
            private void executeClone(String localNodeId, boolean cloneRemoteStoreIndexShardSnapshot) {
        final ShardGenerations shardGenerations = repositoryData.shardGenerations();
            public ClusterState execute(ClusterState currentState) {  
                        // snapshot is started - mark every non completed shard as aborted
    private static boolean isWritingToRepository(SnapshotsInProgress.Entry entry) {
                    logger.warn("Shallow snapshots are not supported during migration. Falling back to full snapshot.");  
                    throw new ConcurrentSnapshotExecutionException(  
            }
            if (updatedDeletions == deletions) {
                    listener.onNoLongerClusterManager();  
        final String repositoryName = request.repository();
import org.opensearch.action.ActionRunnable;  
    ) {  
                executor.execute(ActionRunnable.supply(snapshotInfoListener, () -> repository.getSnapshotInfo(sourceSnapshotId)));
            } catch (Exception ex) {
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                        final Set<String> reposWithRunningDeletes = snapshotDeletionsInProgress.getEntries()
                                removeSnapshotDeletionFromClusterState(deleteEntry, null, updatedRepoData);
                            // No point in doing noop updates that might happen if data nodes resends shard status after a disconnect.
                new LatchedActionListener<>(new ActionListener<>() {
            this.updatedState = updatedState;
                if (FeatureFlags.isEnabled(FeatureFlags.SNAPSHOT_RESILIENCE_SETTING) == false) {  
        return unmodifiableList(builder);  
        if (removedNodes.isEmpty()) {  
import java.util.Objects;
        return TimeValue.timeValueMillis(delayMillis);  
            for (int i = 0; i < shardCount; i++) {
    public void executeSnapshot(final CreateSnapshotRequest request, final ActionListener<SnapshotInfo> listener) {  
                        deleteEntry.getSnapshots(),  
                entry.snapshot(),
                        "cannot clone from snapshot that is being deleted"  
            long orphanTimestamp = pinnedEntities.get(pinnedEntity).get(0);
        @Override  
    private static class CleanupAfterErrorListener {
                    return res;
        RoutingTable routingTable,  
                    logger.warn("Did not find expected entry [{}] in the cluster state", cloneEntry);
                final Map<String, Object> userMeta = repository.adaptUserMetadata(request.userMetadata());
        final String repoName = request.repository();
    private void runReadyDeletions(RepositoryData repositoryData, String repository) {
            }
import org.opensearch.action.support.GroupedActionListener;
                }  
                );
     * @param repository     repository name
         */  
            .collect(Collectors.toList());
        deleteOrphanTimestamps(pinnedEntities, orphanPinnedEntities);
                                finishedSnapshots.add(snapshot);
            }
        boolean isPartial,
            logger.info("Cleaning up in progress v2 snapshots now");
    }  
                    : "New finalizations " + newFinalizations + " added even though deletes " + readyDeletions + " are ready";
            .collect(Collectors.toList());
                        String.join(",", snapshotNames),
                entries.add(entry);  
                    // Entry is for another repository we just keep it as is  
                        "cannot delete snapshots while a repository cleanup is in-progress in [" + repositoryCleanupInProgress + "]"
            }
                        assert entry.isClone() : "Non-clone snapshot ["
        }
    public void createSnapshotV2(final CreateSnapshotRequest request, final ActionListener<SnapshotInfo> listener) {
                        () -> createRemoveFailedSnapshotTask(source, attempt + 1, snapshot, failure, repositoryData, listener),
            assert snapshotsToFinalize.values().stream().noneMatch(Collection::isEmpty) : "Found empty queue in " + snapshotsToFinalize;  
        }  
            .collect(Collectors.toList())) {
                    );
                updatedEntry = entry.withShardStates(shards);
        } catch (Exception e) {  
                            // If the lookup finds the index id then at least the entry is concerned with the index id just updated
        public void onNoLongerClusterManager() {
            );  
            assert deletions != null : "We only run this if there were deletions in the cluster state before";  
        logger.info("Publish failed for [{}] (attempt {}), scheduling retry in [{}]", source, nextAttempt, delay);  
     * on the repository.
        final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE);  
            maxRetries = SNAPSHOT_CLEANUP_RETRIES_SETTING.get(settings);
                        repositoryData,
     * This can either be {@link SnapshotDeletionsInProgress.Entry} that were already in state  
            } else {
        assert repositoryOperations.isEmpty() : "Found leaked snapshots to finalize " + repositoryOperations + " on [" + localNode + "]";
                    final ClusterState res = readyDeletions(
                        statesToUpdate = EnumSet.of(State.STARTED);
                    stateWithoutSnapshotV2(event.state());
                                            localNodeId,
                for (String snapshot : snapshots) {
    private static void ensureNoCleanupInProgress(ClusterState currentState, String repositoryName, String snapshotName) {
                final List<String> allIndices = new ArrayList<>(currentState.metadata().indices().keySet());
        Setting.Property.NodeScope,  
            logger.info(() -> new ParameterizedMessage("Failed to start snapshot clone [{}]", cloneEntry), e);  
        },
            // The delete failed to execute on the repository. We remove it from the cluster state and then fail all listeners associated  
                .addSettingsUpdateConsumer(MAX_CONCURRENT_SNAPSHOT_OPERATIONS_SETTING, i -> maxConcurrentOperations = i);
                            null,  
                orphanTimestamp,  
                if (entry.repository().equals(repository)) {  
                        .withAddedEntry(newDelete)
        for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {  
                }
        final TimeValue delay = computeBackoff(retryBackoff, attempt);
                    assert state == ShardState.SUCCESS;
            || deletionsInProgress.getEntries()
                @Override  
        Repository repository,
                                    sourceSnapshot,  
                }
                        public void onResponse(RepositoryData repositoryData) {
        };
    }  
                        failSnapshotCompletionListeners(snapshot, new SnapshotException(snapshot, "no longer cluster-manager"));
     */  
import org.opensearch.threadpool.ThreadPool;
            UpdateIndexShardSnapshotStatusRequest request,
                try {
        }
                final Set<Snapshot> snapshotListenerKeys = snapshotCompletionListeners.keySet();
import java.io.IOException;
        Settings settings,
        final String snapshotName = indexNameExpressionResolver.resolveDateMathExpression(request.target());
                    } else if (executedTasks.contains(updateSnapshotState)) {
                                    updatedSnapshotEntries.add(snapshot);  
                    try {
        }
                @Override  
            getPinningEntity(snapshot.getRepository(), snapshot.getSnapshotId().getUUID()),
                        } else if (shardRouting.primaryShard().initializing() || shardRouting.primaryShard().relocating()) {
    protected void doClose() {
        @Override
        public void onFailure(String source, Exception e) {
import org.opensearch.cluster.SnapshotsInProgress;
            }
                    executor.execute(ActionRunnable.supply(shardCountListener, () -> {
     * @param repositoryData repository data or {@code null} when cleaning up a BwC snapshot that never fully initialized  
                    logger.error("Failed to retrieve snapshot info for snapshot-v2 {} {} ", repositoryName, snapshotName);  
                            // Shard that we were waiting for has started on a node, let's process it
                SnapshotsInProgress snapshotsInProgress = event.state().custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);  
                            if (indexMeta == null) {  
            private Snapshot runningSnapshot;
     * {@link SnapshotsInProgress.Entry} from the cluster state once it's done finalizing the snapshot.
            public void clusterStateProcessed(String source, ClusterState oldState, final ClusterState newState) {  
            } else {  
            final boolean isNewIndex = repositoryData.getIndices().containsKey(indexName) == false;  
        String repositoryName,
        return false;  
        boolean changed = false;  
        if (Strings.hasLength(snapshotName) == false) {
            if (shardStatus.equals(ShardSnapshotStatus.UNASSIGNED_QUEUED)) {
     * API call. Note that it does not apply to V2-shallow snapshots.
                            + entry
                        final RepositoryShardId repoShardId = indexClone.getKey();  
        final Settings settings = indexMetadata.getSettings();
     *
                    + " limit for concurrent snapshot operations is set to ["  
                            final ShardSnapshotStatus finishedStatus = updateSnapshotState.updatedState;  
                            // Shard that we were waiting for hasn't started yet or still relocating - will continue to wait
                        }
                if (shardSnapshotStatus.state().completed() == false && removedNodeIds.contains(shardSnapshotStatus.nodeId())) {
                                logger.info("snapshots {} deleted", snapshotsWithLockFiles);
     */
import java.util.Iterator;
                // cluster-manager
                ActionListener.wrap(snapshot -> addListener(snapshot, ActionListener.map(listener, Tuple::v2)), listener::onFailure)  
            }  
    /**
                                    listener.onFailure(e);
        (s) -> {
        Setting.Property.Dynamic
        validate(repositoryName, snapshotName);  
                            try {
                public void onFailure(String source, Exception e) {
     * Shortcut to build new {@link ClusterState} from the current state and updated values of {@link SnapshotsInProgress} and  
     */  
        }  
                if (listener != null) {
     * @param listener       listener to invoke when done with, only passed by the BwC path that has {@code repositoryData} set to
                                    leaveRepoLoop(repositoryName);
            this.shardId = null;  
    }
            @Override
                            "cannot delete snapshot during a restore in progress in [" + restoreInProgress + "]"
                ensureNoCleanupInProgress(currentState, repositoryName, snapshotName);  
                }
        Snapshot snapshot = new Snapshot(repositoryName, snapshotId);
    private boolean assertConsistentWithClusterState(ClusterState state) {
            }  
        Repository repository = repositoriesService.repository(request.repository());
                .successes(tasks)
            .stream()
                                "primary shard hasn't been started yet",
     * upload any shard metadata to the snapshot repository.  
     * Assert that no in-memory state for any running snapshot-create or -delete operation exists in this instance.
            SnapshotDeletionsInProgress.EMPTY
                        })),  
            userCreateSnapshotListener.onFailure(ExceptionsHelper.useOrSuppress(e, this.e));
                }
                int pathType = clusterService.state().nodes().getMinNodeVersion().onOrAfter(Version.V_2_17_0)
         * {@link Metadata to use when finalizing}.
                        return currentState;
                    iterator.remove();  
    private void processExternalChanges(boolean changedNodes, boolean startShards) {
                        }
                return createSnapshotTaskKey;
                    newState.metadata(),
        return unmodifiableList(new ArrayList<>(foundSnapshots));
                final SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(
                    }  
                    // a (non-clone) shard snapshot operation was updated  
                if (indexShardRoutingTable != null) {
                    ShardState.FAILED,
                && ExceptionsHelper.unwrap(e, FailedToCommitClusterStateException.class) != null) {  
            private boolean reusedExistingDelete = false;
            final String repository = snapshot.getRepository();  
                                new ShardSnapshotStatus(shardRouting.primaryShard().currentNodeId(), shardStatus.generation())
            });
                initializingClones.remove(snapshot);
                    // If we are reacting to a change in the cluster node configuration we have to update the shard states of both started
                            SnapshotsInProgress.TYPE,
                        "cannot start snapshot-v2 while a repository is in finalization state"  
        String repository
     */
        if (runningSnapshots.stream().anyMatch(s -> {
            indices.size()  
            // If we didn't have a failure during the snapshot delete we will remove all snapshot ids that the delete successfully removed
                }
                        "cannot clone from snapshot that is being deleted"
        } else {  
                }
            }
                // Shard that we were waiting for went into unassigned state or disappeared - giving up
                    new SnapshotException(snapshot, "Failed to update cluster state during snapshot finalization", e)
     * @param listener        listener  
            logger.info(
        ) throws Exception {
     */
                return true;
                    failListenersIgnoringException(snapshotDeletionListeners.remove(delete), failure);  
            }
        SnapshotsInProgress snapshots,  
                    }, e -> {  
                && this.updatedState == that.updatedState;  
        public int hashCode() {
     * cluster state. The number of concurrent operations in a cluster state is defined as the sum of the sizes of
                    repository.getRepositoryData(ActionListener.wrap(repositoryData -> {
                    logger.info("snapshots {} aborted", completedNoCleanup);  
                failure  
        "snapshot.max_shards_allowed_in_status_api",
     * Unlike traditional snapshot operations, this method performs a synchronous clone execution and doesn't
                        return Tuple.tuple(index, metadata.getNumberOfShards());
     * @param state    current cluster state
 * software distributed under the License is distributed on an
        }
                    newEntry.userMetadata(),
            )
                            shardStatusBefore.generation(),
                                    repoShardId,
        }  
                    }
        final SnapshotDeletionsInProgress.Entry deleteEntry,
        Setting.Property.Dynamic
                            shardStatusBefore.generation(),
                        }
        for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {  
                    deleteFromRepoTask.clusterStateProcessed(source, oldState, newState);
                        }  
            if (event.localNodeClusterManager()) {  
            public void onFailure(Exception e) {  
            ThreadPool threadPool,
     *
        synchronized Tuple<SnapshotsInProgress.Entry, Metadata> pollFinalization(String repository) {
    private static final String CLEANUP_STALE_BLOBS_KEY = "snapshot.delete.cleanup_stale_blobs";  
        }
                        } else {  
                final SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(  
     * a task in the executed tasks collection applied to a shard it was waiting for to become available, then the shard snapshot operation
        return true;
        final String[] snapshotNames = request.snapshots();
                    .build();
            final String indexName = index.getName();  
            logger.trace("[{}] finalizing snapshot in repository, state: [{}], failure[{}]", snapshot, entry.state(), failure);  
                        snapshot.getRepository()
     * @param request         delete snapshot request
                }  
    private void leaveRepoLoop(String repository) {
        for (final ShardSnapshotStatus value : entry.shards().values()) {  
            // Remove global state from the cluster state
        final StepListener<SnapshotInfo> snapshotInfoListener = new StepListener<>();  
        Snapshot target,
                            "cannot delete snapshot while it is being cloned"  
        final String source = "remove snapshot metadata";
         * @param deleteListeners delete snapshot listeners or {@code null} if there weren't any for {@link #deleteEntry}.  
                    sourceSnapshot,
     * Computes the cluster state resulting from removing a given snapshot create operation from the given state.  
     * @param listener snapshot creation listener
            // the flag. This can be improved by having the info whether there ever were any shallow snapshot present in this repository  
                if (updateSnapshotState.isClone()) {  
            public void onFailure(String source, Exception e) {  
            actionFilters,
                boolean changed = false;
                            iterator.remove();
            );  
                    );
                    }
                        // start a shard snapshot or clone operation on the current entry  
                    shardStatus.nodeId(),  
                final SnapshotId sourceSnapshotId = repositoryData.getSnapshotIds()
                                        leaveRepoLoop(repositoryName);
                assert readyDeletions.stream().noneMatch(entry -> entry.repository().equals(deleteEntry.repository()))
         *     from the state.</li>  
                    if (entry.remoteStoreIndexShallowCopyV2()) {
                            final SnapshotsInProgress.Entry updatedEntry = snapshotsInProgress.snapshot(update.snapshot);  
                } else {
                        Collections.emptyList(),  
        final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);  
     * for the given repository.  
            final List<SnapshotId> snapshotIds = deleteEntry.getSnapshots();  
                threadPool,
                final List<String> dataStreams = indexNameExpressionResolver.dataStreamNames(  
                    snapshotsInProgress.entries().stream().map(SnapshotsInProgress.Entry::snapshot),
                    }
            private boolean abortedDuringInit = false;  
                                e -> {  
     * @param listener snapshot completion listener
                final List<IndexId> indexIds = repositoryData.resolveNewIndices(
                        break;
                snapshotChanged = true;  
        String snapUUID = String.join(SNAPSHOT_PINNED_TIMESTAMP_DELIMITER, Arrays.copyOfRange(tokens, 1, tokens.length));
            synchronized (endingSnapshots) {
            // TODO: Relying on repository flag to decide delete flow may lead to shallow snapshot blobs not being taken up for cleanup
            public void onFailure(String source, Exception e) {  
                } else {
        SnapshotsInProgress snapshots = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                && entry.state() == SnapshotDeletionsInProgress.State.WAITING  
                }  
                    failSnapshotCompletionListeners(snapshot, new SnapshotException(snapshot, "no longer cluster-manager"));
        RepositoryShardId repoShardId,
                        if (hasWildCardPatterForCloneSnapshotV2(request.indices()) == false) {
        Snapshot snapshot,
            shardSnapshotStatus = new ShardSnapshotStatus(null, ShardState.MISSING, "primary shard is not allocated", shardGeneration);  
        });
    /**
                        final SnapshotsInProgress.Entry abortedEntry = existing.abort();  
        if (DiscoveryNode.isClusterManagerNode(settings)) {
        ShardGenerations.Builder builder = ShardGenerations.builder();
        final List<String> segmentsOnlyIndices = state.metadata()
         * Invoke snapshot delete listeners for {@link #deleteEntry}.
            return snapshotsToFinalize.isEmpty();
                    pinnedTimestamp,
     */
                : currentState,  
        if ("_all".equals(repository)) {
     * an index created on {@code remote_store.mode: segments_only} nodes is configured.
            ActionListener.runBefore(
        final String localNodeId = currentState.nodes().getLocalNodeId();  
                    leaveRepoLoop(repositoryName);
        }
                            );
                            missing.add(entry.getKey().getIndex().getName());
    }
        @Override
    private void addListener(Snapshot snapshot, ActionListener<Tuple<RepositoryData, SnapshotInfo>> listener) {
                final boolean newClusterManager = event.previousState().nodes().isLocalNodeElectedClusterManager() == false;
                    .build();
        ShardSnapshotUpdate(Snapshot snapshot, ShardId shardId, ShardSnapshotStatus updatedState) {
            if ("*".equals(index)) {  
                                logger.trace(
         * being cluster-manager.
        }  
            ),
                snapshotName,
        ClusterState state,  
                        + expectedRepoGen  
                }
                        .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(unmodifiableList(entries)))
                    );  
                        ShardRouting primary = indexRoutingTable.shard(i).primaryShard();  
                        repoName,
        }  
        return new ClusterStateUpdateTask(priority) {  
    /**
                        reusedExistingDelete = true;
import org.opensearch.cluster.SnapshotsInProgress.ShardState;
            .collect(Collectors.toMap(IndexId::getName, Function.identity()));  
        }  
        for (IndexId index : indices) {
            return changed ? SnapshotsInProgress.of(snapshotEntries) : null;
                                if (updated == null) {
            @Override
import java.util.HashSet;
     *
    private static void validate(String repositoryName, String snapshotName, ClusterState state) {
        // TODO: we could skip this step for snapshots with state SUCCESS
                List<SnapshotsInProgress.Entry> entriesForThisRepo = snapshots.entries()
                    }  
     * @param snapshot clone snapshot
            return;
import org.opensearch.cluster.ClusterStateTaskListener;
        /**
        }  
        // makes sure we don't have listeners for snapshots that aren't tracked in any internal state of this class
                    + clones
                            "failed to update snapshot state after shards started or nodes removed from [{}] ",
                                finishedStatus.nodeId(),
            }
    ) {
                } else if (state.completed() == false) {
        final StepListener<Collection<Tuple<IndexId, Integer>>> allShardCountsListener = new StepListener<>();  
        for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
    /**
                Map<SnapshotId, Long> snapshotsWithPinnedTimestamp = new ConcurrentHashMap<>();
                                "Received shard snapshot status update [{}] but this shard is not tracked in [{}]",  
                final List<SnapshotsInProgress.Entry> newEntries = new ArrayList<>(runningSnapshots);
        String[] snapshotsOrPatterns,  
            List<SnapshotDeletionsInProgress.Entry> updatedEntries = new ArrayList<>(remainingEntries.size());
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;  
    private static ClusterManagerTaskThrottler.ThrottlingKey updateSnapshotStateTaskKey;
                } else {
                dataStreams.put(dataStreamName, dataStream);
            }  
        Exception failure,
                    }
                    }  
                        sourceSnapshotId.getName(),  
                            shards.put(shardId, shardStatus);  
     * @param repositoryData current repository data for the snapshot's repository
import org.opensearch.indices.RemoteStoreSettings;
                changed = true;
                false,
        final CountDownLatch latch = new CountDownLatch(orphanPinnedEntities.size());
            return Collections.unmodifiableMap(shards);
        }
    ) {  
                            clones = new HashMap<>(entry.clones());
                IndexRoutingTable indexShardRoutingTable = routingTable.index(shardId.getIndex());  
    ) {  
                listener.onFailure(e);  
                                if (clones == null) {
                            + updateSnapshotState
                        // If we found snapshots that should be finalized as a result of the CS update we try to initiate finalization for
     */
                    }
    /**
    );
        snapshotResilienceValidator(CLEANUP_STALE_BLOBS_KEY),  
                    // retry these kinds of issues so we fail all the pending snapshots
import java.util.EnumSet;
                final ShardState state = status.state();
                    .findAny()
                for (IndexId indexId : repositoryData.getIndices().values()) {
                    final ShardSnapshotStatus shardSnapshotStatus;  
    }
                for (IndexId indexId : repositoryData.getIndices().values()) {  
                        // Entry is already completed so we will finalize it now that the delete doesn't block us after  
     * @return minimum node version that must still be able to read the repository metadata
                        snapshotEntries.add(entry);  
                });
                }  
        } else {
                // We don't remove old cluster-manager when cluster-manager flips anymore. So, we need to check for change in
 * Modifications Copyright OpenSearch Contributors. See
                ).collect(Collectors.toSet());  
            @Override
        private final Exception failure;
                    indexIds,  
                                                snapshotName,  
                    listener.onResponse(null);
            );
     *
                    if (repoName.equals(entry.snapshot().getRepository()) && snapshotIds.contains(entry.snapshot().getSnapshotId())) {
                List<String> indices = Arrays.asList(indexNameExpressionResolver.concreteIndexNames(currentState, request));  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode;  
                            updatedSnapshot,  
                return request.clusterManagerNodeTimeout();  
     */
     */
        }
        String repoName
            }
            snapshotsInProgress.entries()
        }, "create_snapshot [" + snapshotName + ']', listener::onFailure);  
                if (RestoreService.failed(snapshotInfo, indexId.getName())) {
        Map<String, List<Long>> pinnedEntities = RemoteStorePinnedTimestampService.getPinnedEntities();
                        foundSnapshots.add(entry.getValue());
                    ensureBelowConcurrencyLimit(repoName, toDelete.get(0).getName(), snapshots, deletionsInProgress);
    }  
        // Snapshots that can be finalized after the delete operation has been removed from the cluster state
                    logger.info(
    }  
            throw new ConcurrentSnapshotExecutionException(
        }
                    SnapshotDeletionsInProgress.TYPE,
         *     <li>Snapshots that had all their shards reach a completed state while a delete was running (e.g. as a result of  
    ) {
        if (changedNodes == false && startShards == false) {  
                    repositoryData.resolveIndices(matchingIndices),
                    if (indexRoutingTable == null) {
            throw ex.get();  
                // have their snapshots finalizing (those that are already finalizing will fail on their own from to update the cluster
    public static final Setting<Integer> SNAPSHOT_CLEANUP_RETRIES_SETTING = Setting.intSetting(  
        final String repositoryName = request.repository();
        }
        boolean startDeletion(String deleteUUID) {  
            }
     * and trigger running the next snapshot-delete or -finalization operation available to execute if there is one
                // Entering finalize loop here to prevent concurrent snapshots v2 snapshots  
                    logger.trace(
     * @param state   current cluster state  
            } else if (snapshotCompletionListeners.isEmpty() == false) {
            }
     * This is non-blocking method that runs on a thread from SNAPSHOT thread pool
        String snapshotName = snapshot.getSnapshotId().getName();
        final List<ActionListener<Tuple<RepositoryData, SnapshotInfo>>> listenersToComplete = snapshotCompletionListeners.remove(snapshot);  
                if (indexId != null) {
            logger.warn(() -> new ParameterizedMessage("{} failed to remove snapshot deletion metadata", deleteEntry), e);  
                    }  
                                        + "]";  
    private abstract class RemoveSnapshotDeletionAndContinueTask extends ClusterStateUpdateTask {
import org.opensearch.cluster.service.ClusterService;
                boolean remoteStoreIndexShallowCopy = REMOTE_STORE_INDEX_SHALLOW_COPY.get(repository.getMetadata().settings());
        Map<String, DataStream> dataStreams = currentState.metadata().dataStreams();
                    public void onResponse(RepositoryData repositoryData) {  
                    version,
    private final RepositoriesService repositoriesService;  
                    Collections.emptyList(),
                Strings.arrayToCommaDelimitedString(snapshotNames),  
                knownFailures.put(shardId, failedState);  
    void retryOrFailOnClusterManagerFailOver(  
                            }
import java.util.Optional;
                        );  
                }  
        ActionListener<Void> listener  
                    );
                        }  
    }  
                final ShardGenerations shardGenerations = repoData.shardGenerations();
                logger.debug("remote_store_index_shallow_copy setting is set as [{}]", remoteStoreIndexShallowCopy);
     * "repository unreachable" error instead of parking another thread.
        final Snapshot targetSnapshot = cloneEntry.snapshot();  
                    snapshotNames,  
                final SnapshotId sourceSnapshotId = repositoryData.getSnapshotIds()  
                );
            @Override  
        }
        }  
        public ClusterState execute(ClusterState currentState) {  
                        );
                @Override  
                        excludedWarmDfa.add(indexName);
            } else {
        @Nullable CleanupAfterErrorListener listener
                    }  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
            assert assertConsistent();
 * compatible open source license.
                            continue;  
                }
                repository,
                    completeListenersIgnoringException(deleteListeners, null);
                            }
                    cloneSnapshotPinnedTimestamp(
     * given repository from the cluster state and afterwards fails all relevant listeners in {@link #snapshotCompletionListeners} and
            return;  
                            if (updatedEntry.state().completed()) {
                    }  
                                metaBuilder.put(repository.getSnapshotIndexMetaData(repositoryData, newEntry.source(), index), false);  
        return false;
                if (entry.repository().equals(repository)) {  
        TimeValue.timeValueMinutes(30).getStringRep(),  
            for (Iterator<ShardSnapshotUpdate> iterator = unconsumedTasks.iterator(); iterator.hasNext();) {
                        if (shardRouting != null && (shardRouting.started() || shardRouting.unassigned())) {
                                    snapshotsWithPinnedTimestamp.put(snapshotId, snapshotInfo.getPinnedTimestamp());
                                    snapshot.shards(),
                "must not contain the following characters " + Strings.INVALID_FILENAME_CHARS  
        });
    /** Deletes snapshot from repository
                if (FeatureFlags.isEnabled(FeatureFlags.SNAPSHOT_RESILIENCE_SETTING)) {
            }  
                final List<SnapshotsInProgress.Entry> runningSnapshots = snapshots.entries();
        RepositoryData repositoryData,  
                addListener(snapshot, ActionListener.wrap(r -> listener.onResponse(null), listener::onFailure));  
                    }
                assert repositoryData.getGenId() == expectedRepoGen
                "cannot snapshot-v2 while a repository cleanup is in-progress in [" + repositoryCleanupInProgress + "]"
    private void failCloneShardAndUpdateClusterState(Snapshot target, SnapshotId sourceSnapshot, RepositoryShardId repoShardId) {
                    repositoryData,
                                sourceSnapshot,
                    repositoryData.getGenId(),
                failAllListenersOnMasterFailOver(e);
            updateSnapshotPinnedTimestamp(snapshot, pinnedTimestamp);
    static TimeValue computeBackoff(TimeValue base, int attempt) {
                    final Snapshot target = updatedEntry.snapshot();
                primary.currentNodeId(),
            .flatMap(entry -> entry.indices().stream())
        RepositoryData repositoryData,
            ClusterState state,  
                        // either a clone or a snapshot
            @Override
     * @param listener snapshot completion listener
                                    repositoryData,
        final boolean readyToExecute = deletionsInProgress == null
                    .putCustom(SnapshotDeletionsInProgress.TYPE, SnapshotDeletionsInProgress.of(newDeletes))
     * @param repositoryData current repository data  
                            listener.onFailure(e);
        }
                        listener.onFailure(e);
        synchronized boolean assertConsistent() {
                            final ShardSnapshotStatus finishedStatus = updateSnapshotState.updatedState;
                    snapshot,
                            final ShardSnapshotStatus existingStatus = entry.clones().get(finishedShardId);  
                        executedTasks.add(updateSnapshotState);  
            RepositoryCleanupInProgress.TYPE,
                    throw new SnapshotException(
                newEntries.add(newEntry);
                for (RestoreInProgress.Entry entry : restoreInProgress) {  
        assert snapshotsInProgress != null;
            logger.error("Snapshot {} clone failed with exception {}", snapshot.getSnapshotId().getName(), e);
                }  
            .filter(entry -> entry.repository().equals(repositoryName))  
        200000,
                final IndexId indexId = indexLookup.get(id.getIndexName());  
    private static boolean waitingShardsStartedOrUnassigned(SnapshotsInProgress snapshotsInProgress, ClusterChangedEvent event) {
     */
            }
                        snapshot.getSnapshotId(),
                            + repositoryData.getSnapshotIds()
     */
     * @param listener snapshot creation listener  
                            repoShardId,
        for (final Map.Entry<ShardId, ShardSnapshotStatus> shardEntry : snapshotShards.entrySet()) {
            return ThreadPool.Names.SAME;
                    .noneMatch(SnapshotsService::isWritingToRepository)) {
                            shards.put(
                if (FeatureFlags.isEnabled(FeatureFlags.SNAPSHOT_RESILIENCE_SETTING)) {
        1,
            @Override  
            + " on ["
            Map<RepositoryShardId, ShardSnapshotStatus> clones = null;
     */
     *
                    }
                    leaveRepoLoop(repositoryName);
                logger.info(() -> new ParameterizedMessage("Failed to start snapshot clone [{}]", cloneEntry), e);  
                    for (SnapshotDeletionsInProgress.Entry entry : deletionsToExecute) {
     * Only modifiable when the snapshot resilience feature flag is enabled.
            clusterService.getClusterSettings()  
                            sourceSnapshot,
                        }
    /**  
                    final RepositoryShardId finishedShardId = updateSnapshotState.repoShardId;
                    }
    public static final Setting<Integer> MAX_SHARDS_ALLOWED_IN_STATUS_API = Setting.intSetting(  
            final SnapshotsInProgress snapshotsInProgress = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);  
                            for (int shardId = 0; shardId < count.v2(); shardId++) {
                        if (entry.isClone()) {  
    /**  
        logger.debug("shallow_snapshot_v2 is set as [{}]", isSnapshotV2);
                                public void onResponse(RepositoryData repositoryData) {
                    threadPool.absoluteTimeInMillis(),
                            if (clusterService.state().nodes().isLocalNodeElectedClusterManager() == false) {
                    );  
     * @param e exception that caused us to realize we are not cluster-manager any longer
     * @param deletions   snapshot deletions to update
                            // need to finalize it.  
        }
                            final ShardSnapshotStatus finishedStatus = updateSnapshotState.updatedState;
        if (snapshotName.charAt(0) == '_') {
            );  
        // Read the raw values: INDEX_REMOTE_STORE_ENABLED_SETTING carries a validator that cross-checks
    }  
     */
                    if (repositoryData != null) {
                        if (existing == null) {
                            ),
    /**
                final RepositoryCleanupInProgress repositoryCleanupInProgress = currentState.custom(  
                            final ShardSnapshotStatus existingStatus = entry.shards().get(finishedShardId);
        assert currentlyFinalizing.isEmpty() : "Found leaked finalizations " + currentlyFinalizing + " on [" + localNode + "]";
                            "fail repo tasks for [" + repoName + "]",
    }  
                }
            result = ClusterState.builder(state)
        Repository repository,
        final boolean removed = currentlyFinalizing.remove(repository);  
            int shardCount = metadata.index(indexId.getName()).getNumberOfShards();  
            final SnapshotDeletionsInProgress newDeletions = filterDeletions(updatedDeletions);
            }
                );
            if (newFinalization) {
                for (final Map.Entry<ShardId, ShardSnapshotStatus> shardStatus : entry.shards().entrySet()) {
                        ActionListener.runBefore(
                            }  
                ensureSnapshotNameNotRunning(runningSnapshots, repositoryName, snapshotName);  
                                    leaveRepoLoop(repositoryName);
                shards.put(shardId, failedState);
     *
                            }  
                    builder.put(indexId, id.id(), status.generation());
                    listener.onResponse(null);  
            } else if (shardStatus.state() == ShardState.WAITING) {
                SnapshotDeletionsInProgress.TYPE,
         * @param currentState     current cluster state  
                            minCompatibleVersion(minNodeVersion, repositoryData, snapshotsWithPinnedTimestamp.keySet()),  
        @Nullable SnapshotDeletionsInProgress deletionsInProgress,  
    // Set of currently initializing clone operations
        }
                logger.warn("Failed to run ready delete operations", e);  
                    );
                        // enqueue the snapshot finalizations here because the ongoing delete will take care of that when removing the
    }
            @Override
            clusterService,  
        List<SnapshotsInProgress.Entry> runningSnapshots,
                } else {
        // retries
                            );  
                    IndexShardRoutingTable shardRouting = indexShardRoutingTable.shard(shardId.id());
                    e -> {
                                    clones = new HashMap<>(entry.clones());
                // this shard snapshot is waiting for a previous snapshot to finish execution for this shard  
                            // current entry is a snapshot operation so we must translate the repository shard id to a routing shard id
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
            final Version known = repositoryData.getVersion(snapshotId);  
    /**
                            logger.trace(
                                + "] but local node id is ["
                } else {
         *     <li>Snapshots that had unfinished shard snapshots in state {@link ShardSnapshotStatus#UNASSIGNED_QUEUED} that
        for (SnapshotDeletionsInProgress.Entry entry : deletions.getEntries()) {  
        if (snapshotDeletionsInProgress.hasDeletionsInProgress()) {  
                deleteSnapshotsFromRepository(deleteEntry, repositoryData, minNodeVersion);
            }  
                final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);
            }
                final List<SnapshotsInProgress.Entry> updatedEntries = new ArrayList<>(snapshotsInProgress.entries());  
                        listener.onResponse(null);
                    ActionListener.wrap(updatedRepoData -> {  
                processExternalChanges(  
            }
                            // current entry is a clone operation
 */
            RepositoryCleanupInProgress.TYPE,
                                iterator.remove();  
                        newFinalizations.add(entry);
    private void handleFinalizationFailure(Exception e, SnapshotsInProgress.Entry entry, RepositoryData repositoryData) {
                    + "]"
            handleFinalizationFailure(e, entry, repositoryData);
        }  
                    .stream()
                            entry.snapshot(),  
                Map<ShardId, ShardSnapshotStatus> shards = new HashMap<>();
     *
        for (SnapshotId snapshotId : snapshotIds.stream()  
        public void onFailure(@Nullable Exception e) {  
    private final ThreadPool threadPool;  
                for (Iterator<List<ActionListener<Void>>> iterator = snapshotDeletionListeners.values().iterator(); iterator.hasNext();) {
                    }, ex -> removeSnapshotDeletionFromClusterState(deleteEntry, ex, repositoryData))  
     * indices that should be included in the snapshot.
            if (entry.snapshot().equals(snapshot)) {  
                if (knownFailure == null) {
        /**
        final List<SnapshotsInProgress.Entry> entries = new ArrayList<>();
        repositoriesService.getRepositoryData(deleteEntry.repository(), new ActionListener<RepositoryData>() {
            this.shardId = shardId;
        }  
                );  
                            // shard snapshot was completed, we check if we can start a clone operation for the same repo shard  
                );  
     */  
                        SnapshotDeletionsInProgress.EMPTY
     * Cluster state update task that removes all {@link SnapshotsInProgress.Entry} and {@link SnapshotDeletionsInProgress.Entry} for a
            @Override  
            if (entry.snapshot().getRepository().equals(repository) == false) {
                    final SnapshotId sourceSnapshot = updatedEntry.source();  
            final int attempt = 0;
        @Nullable RemoteStorePinnedTimestampService remoteStorePinnedTimestampService,
                listener.onFailure(e);  
 * The OpenSearch Contributors require contributions made to  
                    repository
                final Exception wrapped = new RepositoryException("_all", "Failed to update cluster state during repository operation", e);  
        if (snapshotIds.isEmpty()) {  
                    );
                    listener.onFailure(null);  
    }
                listener.onFailure(e);  
import org.opensearch.core.index.shard.ShardId;
        }
            public ClusterState execute(ClusterState currentState) throws Exception {
            private SnapshotId sourceSnapshotId;
            changed
                            }
            };
                    pinnedTimestampListener.whenComplete(
        } catch (Exception e) {  
                            }  
     * Validates snapshot request
    private volatile int maxConcurrentOperations;
            logger.info("Not empty");  
            } else {
                        @Override  
                ),  
                || (latestKnownMetaData != null && snapshotsToFinalize.isEmpty() == false)
     * Only modifiable when the snapshot resilience feature flag is enabled.
                final Set<SnapshotId> snapshotIdsRequiringCleanup = new HashSet<>(snapshotIds);
     * Maximum number of retries for a cluster state publish failure while the node is still cluster-manager.
                final SnapshotsInProgress snapshotsInProgress = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                            logger.warn("Failed to get index-metadata from repository data for index [{}]", repoShardId.index().getName());  
                        newEntry.includeGlobalState(),
            return;
        new ConcurrentHashMap<>();  
            logger.trace(
        final Set<String> reposWithRunningDelete = snapshotDeletionsInProgress.getEntries()  
        }
                if (deleteFromRepoTask != null) {
    private void removeFailedSnapshotFromClusterState(
                        for (SnapshotId snapshotId : snapshotIds) {  
        return runningSnapshots.stream()
        @Override
                    listener.onFailure(e);  
            .filter(pinnedEntity -> isOrphanPinnedEntity(repoName, snapshotUUIDs, pinnedEntity))  
                            logger.trace("starting shard that we were waiting for [{}] on node [{}]", shardId, shardStatus.nodeId());
     */  
            assert (latestKnownMetaData == null && snapshotsToFinalize.isEmpty())  
                    if (entry.repository().equals(repository) && entry.state() == SnapshotDeletionsInProgress.State.STARTED) {
                    updatedEntries.add(entry.withSnapshots(updatedSnapshotIds));
                    deletionsInProgress,  
        boolean remoteStoreIndexShallowCopy
                    foundSnapshots.add(allSnapshotIds.get(snapshotOrPattern));  
                }
                    fallback.run();
     *
        @Nullable SnapshotDeletionsInProgress snapshotDeletionsInProgress
                .stream()  
        final String repoName = entry.repository();
                        logger.warn("Exception [{}] while trying to clone shard [{}]", e, repoShardId);  
        return new Setting.Validator<T>() {  
                            logger.error("Failed to finalize snapshot repo {} for snapshot-v2 {} ", repositoryName, snapshotName);  
import java.util.concurrent.Executor;
/**
     * {@code true} then snapshot finalizations and deletions for the repo may be executed. Once no more operations are  
                builder.put(index, shardId.id(), shardRepoGeneration);
                    .filter(src -> src.getName().equals(request.source()))
                    }  
import java.util.Locale;
    /**  
         */  
            } catch (Exception ex) {  
                            continue;
                throw new IllegalArgumentException("setting [" + IO_TIMEOUT_KEY + "] must be at least [1s], got [" + value + "]");
                }
                    true
     * Finds snapshot delete operations that are ready to execute in the given {@link ClusterState} and computes a new cluster state that
        boolean changed = false;  
            .stream()
            return emptySet();
                @Override  
     * of a snapshot clone completing.
            final SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(
                            Priority.IMMEDIATE,
     * Try starting to run a snapshot finalization or snapshot delete for the given repository. If this method returns
                                @Override
            // from the repository after the cluster state update
        String repositoryName
    }
                );  
        snapshotResilienceValidator(MAX_OUTSTANDING_OPS_KEY),
                        snapshotInfo.getPinnedTimestamp(),
                    final Metadata.Builder metaBuilder = Metadata.builder(repo.getSnapshotGlobalMetadata(entry.source()));
                            snapshotsWithLockFiles,  
                        } else if (primary.relocating() || primary.initializing()) {
                    metadataForSnapshot(newState.metadata(), request.includeGlobalState(), false, dataStreams, newEntry.indices()),  
        List<SnapshotsInProgress.Entry> builder = new ArrayList<>();
                        } else {  
            // Check this snapshot against the query
        List<IndexId> indices,
    ) {
        if (includeGlobalState == false) {
        private List<SnapshotDeletionsInProgress.Entry> readyDeletions = Collections.emptyList();
                logger.warn(() -> new ParameterizedMessage("[{}][{}] failed to create snapshot-v2", repositoryName, snapshotName), e);
        snapshot.indices().forEach(indexId -> {
        if (snapshot.isClone()) {
        int startedCount = 0;
        public boolean equals(Object other) {
                        // them
        @Nullable CleanupAfterErrorListener listener
                            listener.onResponse(snapshotInfo);
        clusterService.submitStateUpdateTask("remove snapshot deletion metadata", clusterStateUpdateTask);  
                .build();  
        final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
            @Override
                    final StepListener<RepositoryData> pinnedTimestampListener = new StepListener<>();  
            // nothing to do, no relevant external change happened
                                    assert currentState.routingTable().hasIndex(shardId.getIndex()) == false : "Missing assignment for ["
     */
            update,  
                }
    /** Deletes snapshot from repository  
                threadPool.executor(ThreadPool.Names.SNAPSHOT).execute(ActionRunnable.supply(metadataListener, () -> {  
                            && deletionsInProgress.getEntries()  
                            if (existingStatus == null || existingStatus.state() != ShardState.QUEUED) {
                if (repositoryData.getGenId() == RepositoryData.UNKNOWN_REPO_GEN) {  
                e  
    }
                    .stream()
import org.opensearch.repositories.ShardGenerations;
            this.repositoryData = repositoryData;  
     * Unlike traditional snapshot operations, this method performs a synchronous snapshot execution and doesn't  
                );
            );
                    );
                    currentState,
                final List<SnapshotsInProgress.Entry> snapshotEntries = findInProgressSnapshots(snapshots, snapshotNames, repoName);
                            if (indicesLookup == null) {  
        }  
            latestKnownMetaData = null;  
         *     nodes dropping out of the cluster or another incoming delete aborting them) need not be updated in the cluster
                                    finishedStatus.generation()  
    public static final Setting<Integer> SNAPSHOT_REPOSITORY_MAX_OUTSTANDING_OPS_SETTING = Setting.intSetting(
    }
                    ),
                    sourceSnapshotId,  
    ) {
                newEntries.add(newEntry);
                readyDeletions.add(newEntry);
        protected SnapshotDeletionsInProgress filterDeletions(SnapshotDeletionsInProgress deletions) {
            () -> repositoriesService,
        final Set<ShardSnapshotUpdate> executedTasks = new HashSet<>();
        protected final List<SnapshotsInProgress.Entry> newFinalizations = new ArrayList<>();
                    // the update applies to a different repository so it is irrelevant here  
        // Outer loop over all snapshot entries in the order they were created in
                    }, e -> handleFinalizationFailure(e, entry, repositoryData))
                                currentState,
                newEntry = SnapshotsInProgress.startClone(
                        for (SnapshotsInProgress.Entry entry : finishedSnapshots) {  
                        }
        if (primary == null || !primary.assignedToNode()) {
            return state;
 * Service responsible for creating snapshots. This service runs all the steps executed on the cluster-manager node during snapshot creation and
                    if (event.indexRoutingTableChanged(shardId.getIndexName())) {  
    }
                }
            }
                        );
        assert snapshotCompletionListeners.isEmpty() : "Found leaked snapshot completion listeners "  
                }  
        Setting.Property.NodeScope,
     * @param request  snapshot request  
            try {
                } else {
                            : currentState  
                if (foundId == null) {
                    } else {
                            snapshotsWithPinnedTimestamp,
                        snapshot,
                    return;  
                        shards.put(finishedShardId, updateSnapshotState.updatedState);  
    ) {
                public ClusterState execute(ClusterState currentState) {
    );
     * @param request  snapshot request
                                    snapshotsWithLockFiles.add(snapshotId);  
                final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);  
                                @Override
            remoteStoreIndexShallowCopy = false;  
        this.updateSnapshotStatusHandler = new UpdateSnapshotStatusAction(
                    } else {
                    request.includeGlobalState(),
import org.opensearch.cluster.NotClusterManagerException;
                );
            final SnapshotDeletionsInProgress updatedDeletions = changed ? SnapshotDeletionsInProgress.of(updatedEntries) : null;
                    ).getEntries()) {
                            state -> stateWithoutSnapshot(state, snapshot),
        Setting.Property.Dynamic
            public TimeValue timeout() {
     *                     cluster
                        } else {
            this.deleteEntry = deleteEntry;
    private static Map<ShardId, ShardSnapshotStatus> shards(
                        deleteSnapshotsFromRepository(readyDeletion, repositoryData, newState.nodes().getMinNodeVersion());
                        final ShardSnapshotStatus existing = entry.clones().get(finishedShardId);  
        if (snapshots == null) {
                    builder.put(indexMetadata, false);  
            deleteListeners = snapshotDeletionListeners.remove(deleteEntry.uuid());
        if (ExceptionsHelper.unwrap(e, FailedToCommitClusterStateException.class) == null) {
                () -> currentlyCloning.remove(repoShardId)
                                    updatedDeletions,  
    }
                                    currentState.routingTable(),
                }
                }
            );
import org.opensearch.common.collect.Tuple;
                            shards.put(finishedShardId, new ShardSnapshotStatus(finishedStatus.nodeId(), finishedStatus.generation()));
            }  
                } else {
            allShardCountsListener,
        Repository repository = repositoriesService.repository(request.repository());
                                continue;
            .filter(excluded == null ? sn -> true : sn -> excluded.contains(sn) == false)
                        + "] in the repository";  
        clusterService.submitStateUpdateTask(
                    newDelete = replacedEntry.withAddedSnapshots(snapshotIdsRequiringCleanup);
        Tuple<String, String> tokens = getRepoSnapshotUUIDTuple(pinnedEntity);
        // check if the snapshot name already exists in the repository
     *  
            }
        final String localNodeId = clusterService.localNode().getId();
        }
    }
            if (entry.isClone() && entry.state() == State.STARTED && (repoName == null || entry.repository().equals(repoName))) {  
                        failCloneShardAndUpdateClusterState(target, sourceSnapshot, repoShardId);
            @Override
                        updatedEntries.set(i, updatedEntry);
                ActionListener.wrap(  
                ensureBelowConcurrencyLimit(repositoryName, snapshotName, snapshots, deletionsInProgress);
                    threadPool.absoluteTimeInMillis(),  
                                final String indexName = repoShardId.indexName();  
                repositoriesService.repository(repoName).getRepositoryData(new ActionListener<RepositoryData>() {
     * @param cloneEntry     clone operation in the cluster state
                            finishedShardId,
        boolean changed = false;  
                    addDeleteListener(newDelete.uuid(), listener);
            }  
                    );
                    }
                    if (endingSnapshots.add(snapshot)) {
                }
            private List<SnapshotId> outstandingDeletes;
            new ClusterStateTaskListener() {  
                if (deletionsInProgress.getEntries().stream().anyMatch(entry -> entry.getSnapshots().contains(sourceSnapshotId))) {
                    System.currentTimeMillis(),  
        }, onFailure);
        ShardSnapshotStatus shardStatusBefore,
        return remoteStoreIndexShallowCopy;
        String repositoryName,
            Map<String, IndexId> indicesLookup = null;
            runningDeletions.remove(deleteUUID);
                        removeSnapshotDeletionFromClusterState(deleteEntry, null, updatedRepoData);
     *  
                    }
                        );  
            failoverFallback.run();
         *     could not be started because the delete was running can have those started.</li>
                        cloneSnapshot(request, snapshot, repositoryName, repository, listener);
            // Keep track of shardIds that we started snapshots for as a result of removing this delete so we don't assign  
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                            + "]";
                        finalizeSnapshotEntry(entry, metadata, repositoryData);
        for (SnapshotsInProgress.Entry entry : snapshots.entries()) {
                                updateSnapshotState.updatedState.generation(),  
                    );
            private SnapshotDeletionsInProgress.Entry newDelete;
     */
                entries.add(entry);
            }
                        continue;  
                    endSnapshot(entry, newState.metadata(), repositoryData);
        );
                                ShardState.MISSING,  
        String repository,
                entry.partial() ? shardGenerations.totalShards() : entry.shards().size(),
        clusterService.submitStateUpdateTask(
     * ready in the cluster state as a result of this state update.  
                }, latch)
                                shardAssignments = shards(
                            }
        );  
            }
        }
                repositoryName,
            }
                final List<String> indicesForSnapshot = new ArrayList<>();
                        }  
            Map<ShardId, ShardSnapshotStatus> shards = null;  
                ),  
                }
                            final Map<ShardId, ShardSnapshotStatus> updatedAssignmentsBuilder = new HashMap<>(entry.shards());
                            final Metadata.Builder metaBuilder = Metadata.builder(repository.getSnapshotGlobalMetadata(newEntry.source()));
                        new SnapshotException(snapshot, "Failed to remove snapshot from cluster state", e)
                    entry.version(),
                    // snapshots
            ClusterStateTaskConfig.build(Priority.NORMAL),
                                }
            if (FeatureFlags.isEnabled(FeatureFlags.SNAPSHOT_RESILIENCE_SETTING)
                    @Override  
            @Override
                                    snapshot,
                            if (shards == null) {  
                                public void onFailure(Exception e) {  
                }
                final Set<Snapshot> runningSnapshots = Stream.concat(  
                                startedCount++;
                for (Snapshot snapshot : new HashSet<>(snapshotCompletionListeners.keySet())) {  
            public ClusterState execute(ClusterState currentState) {
                        listener.onResponse(null);  
                                }  
                assert snapshotDeletionListeners.isEmpty() : "No new listeners should have been added but saw " + snapshotDeletionListeners;  
                    }));
                                    listener.onResponse(null);
                            }
            public void onFailure(String source, Exception e) {
        try {  
                UPDATE_SNAPSHOT_STATUS_ACTION_NAME,  
                CountDownLatch latch = new CountDownLatch(1);
            remoteStoreSettings.getSegmentsPathFixedPrefix()
    @Override  
                    .stream()
        final int attempt = 0;  
        }
            @Override  
            if (snapshotsToFinalize.isEmpty()) {
        allShardCountsListener.whenComplete(counts -> repository.executeConsistentStateUpdate(repoData -> new ClusterStateUpdateTask() {
                        snapshot,  
            builder.putCustom(SnapshotDeletionsInProgress.TYPE, snapshotDeletionsInProgress);  
import org.opensearch.cluster.node.DiscoveryNode;
    /**  
                // We have snapshot listeners but are not the cluster-manager any more. Fail all waiting listeners except for those that
            }  
                                finishedShardId,  
        1,
                for (Snapshot snapshot : snapshotsToFail) {
                        changedCount++;
                    SnapshotDeletionsInProgress.EMPTY  
                return currentState;  
                listener.onFailure(e);
                }  
                logger.warn(() -> new ParameterizedMessage("[{}][{}] failed to clone snapshot", repositoryName, snapshotName), e);
                            }  
                );  
    }
                        source,  
                        throw new ConcurrentSnapshotExecutionException(
        // The constructor of UpdateSnapshotStatusAction will register itself to the TransportService.  
                                    "Marked [{}] as successfully cloned from [{}] to [{}]",
                            }
        // 1. step, load SnapshotInfo to make sure that source snapshot was successful for the indices we want to clone
            snapshotsToFinalize.computeIfAbsent(entry.repository(), k -> new LinkedList<>()).add(entry);  
        }
                    + snapshotListenerKeys  
                () -> new ParameterizedMessage("Failed to remove all snapshot tasks for repo [{}] from cluster state", repository),
                        }  
                        new Snapshot(repoName, snapshotIds.get(0)),  
            };
         * @param updatedDeletions deletions with removed entry
                }
     *
                final SnapshotDeletionsInProgress.Entry replacedEntry = deletionsInProgress.getEntries()  
                entry.userMetadata(),
                );  
                            stateWithoutSnapshotV2(newState);  
            } else {  
                        if (entry.getValue().state() == ShardState.MISSING) {
            builder = Metadata.builder(metadata);
                    } else {  
     * operation.
                final List<SnapshotId> snapshotIds = matchingSnapshotIds(  
        final List<SnapshotsInProgress.Entry> runningSnapshots = snapshots.entries();  
        Snapshot snapshot = entry.snapshot();
                        indicesForSnapshot,  
        Map<ShardId, ShardSnapshotStatus> knownFailures
     * @param repositoryData current {@link RepositoryData} of that repository
        SnapshotId sourceSnapshot,
                        newEntry.userMetadata(),
                    return updatedDeletions == null ? deletions : updatedDeletions;  
                return ClusterState.builder(currentState).putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(newEntries)).build();
        protected final SnapshotDeletionsInProgress.Entry deleteEntry;  
            source,
                        }
                    leaveRepoLoop(repositoryName);
import org.opensearch.cluster.ClusterStateApplier;
                transportService,
                    if (clone.getValue().state() == ShardState.INIT) {  
                    version,
     * @param entry snapshot
                            iterator.remove();
    /**
     * Handle snapshot or delete failure due to not being cluster-manager any more so we don't try to do run additional cluster state updates.
                final Set<String> deleteListenerKeys = snapshotDeletionListeners.keySet();  
     * @param snapshot snapshot for which to remove the snapshot operation  
    }
                    }  
        final SnapshotsInProgress snapshotsInProgress = currentState.custom(SnapshotsInProgress.TYPE);  
                            "delete snapshot",
                enteredLoop = tryEnterRepoLoop(repositoryName);
        return builder.build();
                            remoteStorePinnedTimestampService,
                } else {
            createRemoveFailedSnapshotTask(source, attempt, snapshot, failure, repositoryData, listener)  
                );  
                    shardRepoGeneration = shardGenerations.getShardGen(index, shardId.id());
                            );  
                            if (shardAssignments == null) {  
     * repository and all nodes in the cluster.
                    snapshotEntries.add(entry);
        DiscoveryNodes nodes,  
                            );  
                @Override
                if (enteredRepoLoop) {  
        validate(repositoryName, snapshotName);
     * A cluster state update that will remove a given {@link SnapshotDeletionsInProgress.Entry} from the cluster state
        });  
         *     state but need to have their finalization triggered now that it's possible with the removal of the delete
        Repository repository = repositoriesService.repository(repositoryName);  
        synchronized void addFinalization(SnapshotsInProgress.Entry entry, Metadata metadata) {
        }, "clone_snapshot [" + request.source() + "][" + snapshotName + ']', listener::onFailure);
                return request.clusterManagerNodeTimeout();  
 *
            } else if (clones != null) {  
            }
                    null,
            }
            }  
        }
            // when the repository currently have the flag disabled and we try to delete the shallow snapshots taken prior to disabling
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            .stream()
    private static final Logger logger = LogManager.getLogger(SnapshotsService.class);
        ActionListener<Void> listener = new ActionListener<>() {
                            .filter(entry -> entry.state() == SnapshotDeletionsInProgress.State.STARTED)  
                                + "]";  
                        if (abortedEntry == null) {
     * Creates a {@link ShardSnapshotStatus} entry for a snapshot after the shard has become available for snapshotting as a result  
                }
     * indices-to-check set.  
            assert false : new AssertionError("Unexpected failure during cluster state update", e);
                }  
                    final String shardRepoGeneration;
                        && IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(idxMd.getSettings())
        return snapshotsInProgress.entries().stream().anyMatch(snapshot -> {
                    // The update applied to a shard clone operation
    /**  
        List<String> orphanPinnedEntities = pinnedEntities.keySet()
    static final ClusterStateTaskExecutor<ShardSnapshotUpdate> shardStateExecutor = (currentState, tasks) -> {
                        );
                        if (entry.isClone()) {
                        clones.put(finishedShardId, updateSnapshotState.updatedState);
        repository.executeConsistentStateUpdate(repositoryData -> new ClusterStateUpdateTask() {
    }
                    return currentState;
     * Deletes snapshots from the repository. In-progress snapshots matched by the delete will be aborted before deleting them.  
                                finishedShardId,
                                    );
        for (String pinnedEntity : orphanPinnedEntities) {
        final Set<String> repositoriesSeen = new HashSet<>();
                                clones.put(repoShardId, new ShardSnapshotStatus(localNodeId, finishedStatus.generation()));
        // Failure that caused the decision to fail all snapshots and deletes for a repo
        }
            if (entry.state() == State.STARTED) {  
            @Override
            return;  
                    } else {  
                    : "Deletes should have been set to ready by finished snapshot deletes and finalizations";  
     * Every shard snapshot or clone state update can result in multiple snapshots being updated. In order to determine whether or not a  
                            for (ShardId shardId : canBeUpdated) {  
            final ShardGenerations shardGenerations = buildGenerations(entry, metadata);
     * @param snapshot       snapshot that failed
                    SnapshotDeletionsInProgress.EMPTY  
                    request.indicesOptions(),  
                snapshotsToFinalize.remove(repository);  
        }  
        if (snapshotsInProgress.entries().size() == 1) {
    // Return in-progress snapshot entries by name and repository in the given cluster state or null if none is found
        private final RepositoryShardId repoShardId;  
 */
        if (entry.isClone() && entry.state() == State.FAILED) {
                    state -> stateWithoutSnapshot(state, snapshot),  
                            remoteStoreLockManagerFactory,  
    public void deleteSnapshots(final DeleteSnapshotRequest request, final ActionListener<Void> listener) {
                    request.indices()
                newEntries.add(newEntry);
        "snapshot.cleanup.retry_backoff",  
    /**  
                // and the files the restore depends on would all be gone
                                    finishedStatus.nodeId(),
                        break;
                        if (existing.state().completed()) {
                    snapshotIds,  
                return false;
                            snapshotEntries.add(updatedEntry);  
        }
                        } else if (!primary.started()) {  
                    if (repositoryData.getSnapshots(indexId).contains(sourceSnapshotId)) {
                    newClusterManager || removedNodesCleanupNeeded(snapshotsInProgress, event.nodesDelta().removedNodes()),
    private final ClusterManagerTaskThrottler.ThrottlingKey createSnapshotTaskKey;
                }
            if (entry.state().completed()) {
            public void clusterStateProcessed(String source, ClusterState oldState, final ClusterState newState) {
    }
                            iterator.remove();  
            this.repoShardId = repositoryShardId;
    private List<ActionListener<Tuple<RepositoryData, SnapshotInfo>>> endAndGetListenersToResolve(Snapshot snapshot) {  
        }
                        "node shutdown",
        ) {
                            cloneSnapshotInfo,
            public void validate(T value) {
        for (SnapshotsInProgress.Entry entry : snapshots.entries()) {
                                            new SnapshotException(
    private void ensureBelowConcurrencyLimit(  
        }
                );
import org.opensearch.cluster.routing.IndexRoutingTable;  
            return true;
            for (SnapshotDeletionsInProgress.Entry entry : remainingEntries) {
/*  
        SnapshotsInProgress snapshotsInProgress,
    /**
import java.util.concurrent.CountDownLatch;  
                        if (existing == null) {
                                primary.currentNodeId(),
                                .stream()
                                leaveRepoLoop(repositoryName);  
                    } else if (executedTasks.contains(updateSnapshotState)) {  
                updateWithSnapshots(currentState, updatedSnapshotsInProgress(currentState, newDeletions), newDeletions)
                logger.warn(() -> new ParameterizedMessage("[{}] failed to remove snapshot metadata", snapshot), e);  
            @Override  
        }
            @Override
                }
                                    repoName
/*
            if (entry.snapshot().getRepository().equals(repository) == false) {  
     */  
    private volatile TimeValue retryBackoff;
        );  
                );  
            }  
    }
        Repository repository,  
                return false;
            );  
                        deleteEntry.repository()
        int attempt,
                    SnapshotDeletionsInProgress.TYPE,
                final StepListener<SnapshotInfo> snapshotInfoListener = new StepListener<>();  
        final GroupedActionListener<Tuple<IndexId, Integer>> shardCountListener = new GroupedActionListener<>(
import org.opensearch.cluster.ClusterStateTaskExecutor;
                    failListenersIgnoringException(listeners, wrapped);
        assert snapshotDeletionListeners.isEmpty() : "Found leaked snapshot delete listeners "  
         */
         */
import org.opensearch.repositories.RepositoriesService;
                            }
                    updatedState,  
                    + runningDeletes;
                            // No work has been done for this snapshot yet so we remove it from the cluster state directly
            } else {
            }
                    // Extremely unlikely corner case of cluster-manager failing over between between starting the clone and
        Priority priority,
                changed = true;
                            iterator.remove();
            }
     *
                            snapshotChanged = true;  
            + "]";
    private void startCloning(Repository repository, SnapshotsInProgress.Entry cloneEntry) {  
                @Override  
     * Returns the data streams that are currently being snapshotted (with partial == false) and that are contained in the
     * (finalization, deletion). Operations exceeding this budget are treated as failures.
import static org.opensearch.cluster.SnapshotsInProgress.completed;
    private final UpdateSnapshotStatusAction updateSnapshotStatusHandler;
                    .orElseThrow(() -> new SnapshotMissingException(repositoryName, request.source()));
    }
                failAllListenersOnMasterFailOver(e);
                    pathType
                            remoteSegmentStoreDirectoryFactory,
        if (ExceptionsHelper.unwrap(e, NotClusterManagerException.class, FailedToCommitClusterStateException.class) != null) {  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    }
        Setting.Property.Dynamic
    public static List<SnapshotsInProgress.Entry> currentSnapshots(  
        );  
    private void deleteSnapshotsFromRepository(SnapshotDeletionsInProgress.Entry deleteEntry, Version minNodeVersion) {
                            updateSnapshotState.updatedState.state()
                    }  
        remoteStorePinnedTimestampService.cloneTimestamp(  
            repositoriesService.getRepositoryData(repositoryName, repositoryDataListener);
    }
        this.threadPool = transportService.getThreadPool();
                    if (entry.state().completed() == false) {
                for (SnapshotId snapshotId : snapshotIds) {
     *                       {@code null}
     * commit and therefore need no translog to restore.
     * TODO: optimize this to execute in a single CS update together with finalizing the latest snapshot
import org.opensearch.cluster.routing.ShardRouting;  
            }  
            repositoryOperations.finishDeletion(deleteEntry.uuid());
            private SnapshotsInProgress.Entry updatedEntry;
                    .filter(se -> se.repository().equals(repo))  
        Supplier<ClusterStateUpdateTask> taskFactory,
                    .orElseThrow(() -> new SnapshotMissingException(repositoryName, request.source()));
 * Unless required by applicable law or agreed to in writing,
                } else {
                final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
        final SnapshotDeletionsInProgress deletions = currentState.custom(
                        } else if (snapshot.repositoryStateId() == RepositoryData.UNKNOWN_REPO_GEN) {  
                                endSnapshot(updatedEntry, newState.metadata(), null);  
                @Override
                            entry -> entry.repository().equals(repoName)  
import java.util.LinkedList;  
    /**  
            listener.onFailure(e);
    /**
                logger.error("Failed to pin timestamp for snapshot {} with exception {}", snapshot.getSnapshotId().getName(), e);
        final SnapshotId snapshotId = new SnapshotId(snapshotName, UUIDs.randomBase64UUID()); // new UUID for the snapshot  
     * @param minNodeVersion    minimum node version in the cluster  
                    shardRepoGeneration = ShardGenerations.NEW_SHARD_GEN;  
                    // for the same repository
        List<IndexId> indices
                assert clones == null : "Should not have updated clones when updating shard snapshots but saw "
        final int inProgressOperations = snapshotsInProgress.entries().size() + deletionsInProgress.getEntries().size();  
                        // We are reacting to shards that started only so which only affects the individual shard states of started
        if (Strings.validFileName(snapshotName) == false) {
                                    logger.info("snapshot-v2 clone [{}] completed successfully", snapshot);  
                    snapshotEntries.stream().map(e -> e.snapshot().getSnapshotId()).collect(Collectors.toList()),
                ensureBelowConcurrencyLimit(repositoryName, snapshotName, snapshots, deletionsInProgress);
                }
                // Snapshot ids that will have to be physically deleted from the repository
                final List<String> matchingIndices = filterIndices(indicesForSnapshot, request.indices(), request.indicesOptions());
        @Override
        }  
                }
                final SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(
     * @param currentState            current cluster state  
        return snapshots.entries()  
                        }  
        clusterService.submitStateUpdateTask("Run ready deletions", new ClusterStateUpdateTask() {
                continue;
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                private final Collection<SnapshotDeletionsInProgress.Entry> deletionsToExecute = new ArrayList<>();
import org.apache.logging.log4j.message.ParameterizedMessage;  
        Version minNodeVersion
            }  
                        if (shards == null) {  
                }
                        snapshotInfo.getPinnedTimestamp()
                }  
                        );
                    true,  
     * @param failure        exception that failed the snapshot
    public void executeClone(CloneSnapshotRequest request, ActionListener<Void> listener) {
                }
                }
                newEntry = SnapshotsInProgress.startClone(  
                                );  
import org.opensearch.repositories.IndexId;  
                            minCompatibleVersion(minNodeVersion, repositoryData, snapshotsWithLockFiles),
            final List<SnapshotsInProgress.Entry> snapshotEntries = new ArrayList<>();  
        }
        boolean changed = false;
                                    clonesBuilder.put(
                if (deletionToRun == null) {  
        if (entry.state().completed()) {
            listener.onFailure(new RepositoryException(repository.getMetadata().name(), "cannot create snapshot in a readonly repository"));
     * @param snapshotsInProgress snapshots in progress in the cluster state
                            }
        SetOnce<Exception> ex = new SetOnce<>();
                            final Snapshot existingNotYetStartedSnapshot = existing.snapshot();  
        );  
                meta -> repo.finalizeSnapshot(
        ClusterState currentState,
                    }
                    logger.info("Successfully aborted snapshot [{}]", runningSnapshot);  
                    // send ack to caller and won't continue on new cluster manager . Caller will need to retry it.  
            @Override  
            snapshot.shards().forEach((id, status) -> {
                        }
                            ActionListener.wrap(updatedRepoData -> {
     *
    );
            metadataListener.whenComplete(
    private void startExecutableClones(SnapshotsInProgress snapshotsInProgress, @Nullable String repoName) {
                        entries.add(entry);
     */
        List<SnapshotId> inProgress,
        // 3. step, we have all the shard counts, now update the cluster state to have clone jobs in the snap entry
                }
                Repository repository = repositoriesService.repository(repositoryName);
                final String shardRepoGeneration;  
        }
            initializingClones.remove(targetSnapshot);
        return readyDeletions(result).v1();
    }
                            changed = true;
            }
                @Override  
                        }  
                        endSnapshot(newEntry, newState.metadata(), repositoryData);
                    shards.put(shardId, failedState);
                    repositoryName
                return request.clusterManagerNodeTimeout();  
                final List<IndexId> indexIds = repositoryData.resolveNewIndices(
                            logger.debug("[{}] was found in dangling INIT or ABORTED state", snapshot);
                                shards = new HashMap<>(entry.shards());
    }
    private boolean remoteStoreShallowCopyEnabled(Repository repository) {
        }  
                public ClusterState execute(ClusterState currentState) {  
    private static <T> void failListenersIgnoringException(@Nullable List<ActionListener<T>> listeners, Exception failure) {
                    RepositoryCleanupInProgress.EMPTY
    /**
import org.opensearch.core.index.Index;
        @Override
                && Objects.equals(this.repoShardId, that.repoShardId)
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
            for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {  
            throw new RepositoryMissingException(repositoryName);
    private static Map<String, IndexId> getInFlightIndexIds(List<SnapshotsInProgress.Entry> runningSnapshots, String repositoryName) {
    private static boolean isSegmentsOnlyIndex(IndexMetadata indexMetadata) {  
     */
     * @return list of metadata for currently running snapshots
                ).collect(Collectors.toSet());
                if (entry.repository().equals(updatedRepository) == false) {
import java.util.function.Supplier;
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "cannot be empty");  
                        new ShardSnapshotUpdate(target, repoShardId, new ShardSnapshotStatus(localNodeId, ShardState.SUCCESS, generation)),  
        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
        if (snapshotName.contains("#")) {
                entry.remoteStoreIndexShallowCopy(),  
                    SnapshotDeletionsInProgress.EMPTY
         * <ul>  
                            }  
        return minCompatVersion;  
                        indices.add(indexName);  
    private static ShardGenerations buildGenerations(SnapshotsInProgress.Entry snapshot, Metadata metadata) {  
                            logger.error("Giving up on removing v2 snapshot state after {} attempts", attempt + 1);  
        public ClusterTasksResult<ShardSnapshotUpdate> execute(ClusterState currentState, List<ShardSnapshotUpdate> tasks)  
    ) {  
            logger.warn("Shallow snapshots are not supported during migration. Falling back to full snapshot.");
        String snapshotName = snapshot.getSnapshotId().getName();
    public static final Setting<TimeValue> SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING = Setting.timeSetting(
        RepositoryData repositoryData,
                        logger.trace(
                                    entry.indices(),  
                                    failAllListenersOnMasterFailOver(e);
                                finishedStatus.nodeId(),
        logger.info(  
                            }  
                        source,  
        @Override  
            // with it.
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        ShardGenerations.Builder builder = ShardGenerations.builder();
            SnapshotDeletionsInProgress.TYPE,  
                    }, this::onFailure));  
            }
     * @param changedNodes true iff either a cluster-manager fail-over occurred or a data node that was doing snapshot work got removed from the
        innerUpdateSnapshotState(
                if (repositoryCleanupInProgress.hasCleanupInProgress()) {
     * <p>
                        }
                }
                    clusterService.submitStateUpdateTask(
                repository.deleteSnapshots(
    }
                        if (shardRouting.primaryShard().started()) {
                    throw new ConcurrentSnapshotExecutionException(  
                failure.addSuppressed(new SnapshotException(snapshot, "no longer cluster-manager"));
                                // started a snapshot and didn't just fail  
     *                       snapshot create operations remain to execute  
    protected void doStop() {  
                        final ShardSnapshotStatus shardStatusBefore = indexClone.getValue();
                    e  
                            target.getSnapshotId(),  
        // TODO: create snapshot UUID in CreateSnapshotRequest and make this operation idempotent to cleanly deal with transport layer
            @Override
        }  
                    );
     * The pinned timestamp is later reconciled with remote store segment and translog metadata files during the restore
 * Licensed to Elasticsearch under one or more contributor  
            logger.warn("Exhausted {} retries for [{}], falling back to failover handling", maxRetries, source);  
        private final Map<String, Deque<SnapshotsInProgress.Entry>> snapshotsToFinalize = new HashMap<>();
                    if (entry.snapshot().getSnapshotId().getName().equals(snapshot)) {  
                        } catch (IOException e) {
                if (changed) {
            } else {  
                    .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(new ArrayList<>(newEntries)))
                                    }  
                            final IndexId indexId = indicesLookup.get(finishedShardId.getIndexName());
    /**  
            clusterStateUpdateTask = new RemoveSnapshotDeletionAndContinueTask(deleteEntry, repositoryData) {
                                        finishedSnapshots.add(updatedSnapshot);
     * @param snapshotIds snapshot ids to remove
                            if (value.getValue().equals(ShardSnapshotStatus.UNASSIGNED_QUEUED)  
        createSnapshotTaskKey = clusterService.registerClusterManagerTask(CREATE_SNAPSHOT, true);  
    private void removeSnapshotDeletionFromClusterState(  
            listener.onFailure(e);  
     * translog repository, and operations acknowledged in that gap are unrecoverable. Creation itself would still
        };
        }
                            // shard snapshot was completed, we check if we can start another snapshot
                            shardRepoGeneration  
                    if (newDelete.state() == SnapshotDeletionsInProgress.State.STARTED) {  
                leaveRepoLoop(repository);
import java.util.Arrays;
        0,  
        latch.await();
                    generation -> innerUpdateSnapshotState(
                            + sourceSnapshotId
            transportService,
        for (final SnapshotsInProgress.Entry entry : snapshots.entries()) {  
        } catch (Exception e) {  
                }  
                            // No shards can be updated in this snapshot so we just add it as is again  
                    throw new SnapshotException(snapshot, "Aborted on initialization");
        return shardSnapshotStatus;
                    final String inFlightGeneration = inFlightShardStates.generationForShard(index, shardId.id(), shardGenerations);  
            assert nextEntry != null;  
            public void onFailure(String source, Exception e) {  
         * Map of repository name to a deque of {@link SnapshotsInProgress.Entry} that need to be finalized for the repository and the
            if (reposSeen.add(entry.repository())) {
                    snapshotEntries.add(entry);
                // not currently restorable. The rest of the cluster is captured normally.
        assert repositoryOperations.assertNotQueued(snapshot);
                }  
                            .stream()
                    .filter(src -> src.getName().equals(request.source()))  
                    // a node leaving or shard becoming unassigned for one snapshot, we will also fail it for all subsequent enqueued  
        final String snapshotName = indexNameExpressionResolver.resolveDateMathExpression(request.snapshot());
                ActionListener.delegateFailure(listener, (l, v) -> l.onResponse(UpdateIndexShardSnapshotStatusResponse.INSTANCE))
        true,
                        attempt,
     * entries since it can not have any further effects.  
                            .stream()
                            }  
                    dataStreams,
        void finishDeletion(String deleteUUID) {
     * @param request snapshot request  
            );  
        updateSnapshotStateTaskKey = clusterService.registerClusterManagerTask(UPDATE_SNAPSHOT_STATE, true);
                            }  
                        updatedSnapshots.entries()
                    }
                            continue;
                        }
                                } else {
        if (snapshotsInProgress == null && snapshotDeletionsInProgress == null) {
            .values()  
        final DiscoveryNode localNode = clusterService.localNode();
                                final ShardSnapshotStatus updated = shardAssignments.get(shardId);
                builder.put(indexId, i, null);
                    : IndexId.DEFAULT_SHARD_PATH_TYPE;  
                SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
            }  
                final Version version = minCompatibleVersion(currentState.nodes().getMinNodeVersion(), repositoryData, null);  
        final Metadata.Builder builder;  
     * @param repository     repository to run operation on  
                    if (clusterService.state().nodes().isLocalNodeElectedClusterManager() == false) {  
            private SnapshotsInProgress.Entry newEntry;
            // Nothing to do, no nodes removed
        }  
                logger.warn(() -> new ParameterizedMessage("[{}][{}] failed to create snapshot", repositoryName, snapshotName), e);
                    pinnedTimestamp  
    }
                                        snapshotName
        } else {  
        ArrayList<SnapshotsInProgress.Entry> entries = new ArrayList<>();
                    Priority.IMMEDIATE,
                    // if no failure is known for the shard we keep waiting  
            new ClusterStateUpdateTask() {  
                }));
                    repositoryData.resolveIndices(indicesForSnapshot),  
                        snapshotInfo.totalShards(),
            return;
                listener.onFailure(e);
        }  
                    }
        }  
                        assert reposWithRunningDelete.contains(entry.repository()) : "Found shard snapshot waiting to be assigned in ["
                    .build()
                        // Just pass the exception to the transport handler as is so it is retried on the new cluster-manager  
     */
                            shardGenerations,
import org.opensearch.cluster.metadata.IndexMetadata;  
        // Tasks to check for updates for running snapshots.
    private void cleanOrphanTimestamp(String repoName, RepositoryData repositoryData) {  
                                    stateWithoutSnapshotV2(newState);  
                                                repositoryName,
            this.updatedState = updatedState;
            final SnapshotsInProgress updatedSnapshotsInProgress = changedSnapshots ? SnapshotsInProgress.of(snapshotEntries) : null;
        // Delete uuids to fail because after the state update
import org.opensearch.index.IndexModule;  
import org.opensearch.cluster.RestoreInProgress;  
                    new ActionListener<RepositoryData>() {
                    final ShardId shardId = indexRoutingTable.shard(i).shardId();  
                if (state.failed()) {  
    }
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                startedCount
                    // Entry is for another repository we just keep it as is  
                    if (activeCloneSources.contains(snapshotId)) {  
import org.opensearch.repositories.RepositoryShardId;  
import org.opensearch.index.IndexSettings;
                    if (cloneEntry.snapshot().equals(updatedEntries.get(i).snapshot())) {  
                for (String snapshot : snapshots) {
                                    if (updatedSnapshot.state().completed()) {
                                    logger.error(
        return new ClusterStateUpdateTask() {  
     * Updates the shard status in the cluster state
                            // cleaning up in progress snapshot here
        }
        } else {  
import org.opensearch.cluster.ClusterStateTaskConfig;  
            }
                            // Currently initializing clone
                    newEntry.indices(),
        1000,
        }
                    assert isPartial : "Index [" + index + "] was deleted during a snapshot but snapshot was not partial.";
                continue;
        }, "start snapshot clone", onFailure), onFailure);
     * cluster-manager) or falling back to the existing failover behavior. Without this, a publish failure on a stable  
        }, "clone_snapshot_v2 [" + request.source() + "][" + snapshotName + ']', listener::onFailure);
     * {@link #snapshotDeletionListeners}.  
     * @param repositoryData    the {@link RepositoryData} of the repository to delete from
    private ClusterStateUpdateTask createDeleteStateUpdate(
        }
     * report success, since it only pins a timestamp, so the problem would not surface until the snapshot is needed.
            }  
            if (snapshots.isEmpty() == false) {
                                    final SnapshotsInProgress.Entry updatedSnapshot = snapshot.withShardStates(shards);
                    .findAny()
            );
                logger.warn("Failed to notify listeners", ex);
                        + "] not found in snapshots to fail "
                            + entry
        }
                // The index was deleted before we managed to start the snapshot - mark it as missing.
        public boolean isClone() {  
                        failAllListenersOnMasterFailOver(ex);
                            snapshotEntries.add(entry);
        }  
                    RoutingTable routingTable = currentState.routingTable();
import org.opensearch.cluster.SnapshotsInProgress.State;
                                "Aborting clone for Snapshot-v2, only wildcard pattern '*' is supported for indices"
            + snapshotDeletionListeners
                        } else {  
                    );  
                            }
    }  
                threadPool.absoluteTimeInMillis(),
        if (snapshotName.contains(",")) {
        );
            remoteStoreSettings.getSegmentsPathFixedPrefix(),  
                        ;  
                }
            assert snapshotsToFinalize.getOrDefault(snapshot.getRepository(), new LinkedList<>())
            private SnapshotsInProgress.Entry newEntry;
                @Override
        if (listeners != null) {
                }, e -> {  
                    repositoryData.getGenId(),  
        }  
                while ((finalization = repositoryOperations.pollFinalization(repository)) != null) {
                            if ((snapshot.state().completed() || completed(snapshot.shards().values()))) {
                    snapshotId,
    }
                    }
            timestampToPin,  
            return;
                final Runnable fallback = () -> {
        }  
                return Collections.emptyList();
        String repositoryName,
                                v -> logger.trace(  
        snapshotResilienceValidator(IO_TIMEOUT_KEY),
import org.opensearch.cluster.metadata.RepositoriesMetadata;  
                    logger.warn(  
                ),
        final SnapshotDeletionsInProgress snapshotDeletionsInProgress = state.custom(
            public void clusterStateProcessed(String src, ClusterState oldState, ClusterState newState) {
                        repositoryName,  
            final SnapshotsInProgress snapshotsInProgress = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
     * @param deleteEntry       delete entry in cluster state
                    snapshotsToFail.add(entry.snapshot());  
                    + snapshotName
                "primary shard hasn't been started yet",
                    }  
        repository.executeConsistentStateUpdate(repositoryData -> new ClusterStateUpdateTask() {  
        UpdateIndexShardSnapshotStatusRequest,
            IndexMetadata indexMetadata = metadata.index(indexName);
                snapshotName,
     *                       (used to use newer metadata version after a snapshot delete)  
            removeFailedSnapshotFromClusterState(  
                                }  
        Setting.Property.NodeScope,  
            createSnapshotV2(request, listener);
            readyDeletions = res.v2();  
    /**
    // Made to package private to be able to test the method in UTs  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collections;  
     * will be started for that snapshot entry and the task removed from the collection of tasks that need to be applied to snapshot
        UpdateSnapshotStatusAction(
        CountDownLatch latch = new CountDownLatch(1);  
                            // A clone was updated, so we must use the correct data node id for the reassignment as actual shard
import static java.util.Collections.emptySet;
                    if (newEntry.state().completed()) {
        final Map<ShardId, ShardSnapshotStatus> builder = new HashMap<>();
    public void cloneSnapshot(
            @Override
    }
                        : "Repository data contained snapshot ids "  
                    SnapshotDeletionsInProgress.EMPTY  
                                final Map<ShardId, ShardSnapshotStatus> shards = processWaitingShardsAndRemovedNodes(
            }
    private void endSnapshot(SnapshotsInProgress.Entry entry, Metadata metadata, @Nullable RepositoryData repositoryData) {
            }  
        private final RepositoryData repositoryData;
                final SnapshotDeletionsInProgress.Entry newEntry = entry.started();  
    /**  
                            continue;
                : "Should not hold on to metadata if there are no more queued snapshots";
                            }
            return shardStateExecutor.execute(currentState, tasks);
    public static Set<String> snapshottingDataStreams(final ClusterState currentState, final Set<String> dataStreamsToCheck) {
                for (SnapshotDeletionsInProgress.Entry entry : currentState.custom(
                if (listener == null) {
                failSnapshotCompletionListeners(snapshot, failure);  
            public void clusterStateProcessed(String source, ClusterState oldState, final ClusterState newState) {  
                            + "] but it is not blocked by any running delete";  
                                continue;  
                        final List<ShardId> canBeUpdated = new ArrayList<>();
        if (repositoryCleanupInProgress.hasCleanupInProgress()) {
    /**
            ClusterService clusterService,  
                                SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotId);
                        }
            ArrayList<SnapshotShardFailure> shardFailures = new ArrayList<>();
                    ).v1();
    }
                } else {
                    // We keep a cache of shards that failed in this map. If we fail a shardId for a given repository because of
            .filter(SnapshotsService::isSegmentsOnlyIndex)
                    repositoryData.getGenId(),
                if (readyDeletions.isEmpty()) {
     * Stop polling for ready snapshot finalizations or deletes in state {@link SnapshotDeletionsInProgress.State#STARTED} to execute
        return currentlyFinalizing.add(repository);
                        if (endingSnapshots.contains(update.snapshot) == false) {
                    .filter(SnapshotsInProgress.Entry::isClone)
            return updateWithSnapshots(currentState, updatedSnapshotsInProgress, updatedDeletions);
        assert removed;
    }
                    request.indicesOptions(),
            builder = Metadata.builder();  
import org.opensearch.Version;
                    changed = true;
            }  
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
import org.opensearch.repositories.Repository;
                    IndexMetadata idxMd = currentState.metadata().index(indexName);  
        } catch (Exception e) {
            return res;  
            public void onFailure(String src, Exception e) {  
                    // as well
                    throw new ConcurrentSnapshotExecutionException(
                    minCompatibleVersion(minNodeVersion, repositoryData, snapshotIds),
                            );
                entry.includeGlobalState(),
                latestKnownMetaData = null;  
        }  
                                        failSnapshotCompletionListeners(
                );
                            endSnapshot(completedSnapshot, newState.metadata(), repositoryData);
            // SEE https://github.com/opensearch-project/OpenSearch/issues/8610
 * this work for additional information regarding copyright
                }
                            + "] is disabled"  
                            if (updatedEntry != null && updatedEntry.state().completed()) {
            assert false : new AssertionError(e);
        ensureNoCleanupInProgress(currentState, repositoryName, snapshotName);
                    shardStatus.generation()  
        final InFlightShardSnapshotStates inFlightShardStates = InFlightShardSnapshotStates.forRepo(  
                        updatedState.custom(SnapshotDeletionsInProgress.TYPE, SnapshotDeletionsInProgress.EMPTY),  
        }
    /**
                    shardGenerations.totalShards(),
    /**  
     * @param e               the exception from onFailure  
                        repositoryName,  
                createSnapshotPreValidations(currentState, repositoryData, repositoryName, snapshotName);  
                if (replacedEntry == null) {
                    if (reusedExistingDelete) {  
                            getCloneCompletionListener(localNodeId)  
        ActionListener<RepositoryData> listener
        protected String executor() {  
            }
    }  
                final SnapshotId foundId = allSnapshotIds.get(snapshotOrPattern);  
                    sourceSnapshotId,
    @Override
            return true;
                            snapshotsInProgress.entries()
            minCompatVersion = minCompatVersion.before(known) ? minCompatVersion : known;
                                finishedStatus.generation()  
            public void onFailure(String source, Exception e) {
                            source  
                    );
        SnapshotsInProgress snapshots = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);  
        // Exception handler for IO exceptions with loading index and repo metadata  
                    return true;
                                if (initializingClones.contains(snapshot.snapshot())) {  
            }
                    }
                                        && entry.state() == SnapshotDeletionsInProgress.State.STARTED
                                    "Starting clone [{}] on [{}] with generation [{}]",  
                                            inFlightShardStates.generationForShard(repoShardId.index(), shardId, shardGenerations)
                protected void handleListeners(List<ActionListener<Void>> deleteListeners) {
     *
                                repositoryName,  
        Snapshot snapshot,  
                        )  
        final int maxOps = maxConcurrentOperations;
                snapshotInfoListener.whenComplete(snapshotInfo -> {  
                () -> new ParameterizedMessage(
            boolean changedSnapshots = false;
                    shardGenerations.indices().stream().map(IndexId::getName).collect(Collectors.toList()),
                                    currentState.metadata(),
                            }  
            maxConcurrentOperations = MAX_CONCURRENT_SNAPSHOT_OPERATIONS_SETTING.get(settings);
            @Override  
                entries.add(entry);  
                        "cannot delete snapshots in v2 repo while a snapshot is in progress"  
import org.opensearch.cluster.SnapshotDeletionsInProgress;
     * @param listener listener
                }  
                    }
    }  
        );  
            this.e = e;  
        List<String> snapshots  
        }
                            clone.getValue(),
     */
                                    new SnapshotException(repositoryName, snapshotName, "Aborting snapshot-v2, no longer cluster manager")  
        return translogRepository == null || translogRepository.isEmpty();
                logger.error("Unexpected failure during cluster state update", e);  
import java.util.Collection;
         *
        }  
        @Nullable org.opensearch.index.engine.dataformat.DataFormatRegistry dataFormatRegistry
        @Nullable RepositoryData repositoryData,  
     */  
     *
     * Determines the minimum {@link Version} that the snapshot repository must be compatible with from the current nodes in the cluster
                ShardId shardId = shardStatus.getKey();  
                    logger.info("snapshot [{}] started", snapshot);
                            ? ClusterState.builder(currentState)  
            return true;
            }
            if (queued.isEmpty()) {
                    if (inFlightGeneration == null && isNewIndex) {
                new ShardSnapshotStatus(localNodeId, ShardState.FAILED, "failed to clone shard snapshot", null)  
        private final ShardId shardId;
                            logger.info("created snapshot-v2 [{}] in repository [{}]", repositoryName, snapshotName);
    );
import java.util.concurrent.ConcurrentHashMap;
     * cluster-manager strands the in-progress snapshot marker forever, blocking index deletion and close.
                for (SnapshotsInProgress.Entry entry : newFinalizations) {  
        }, "delete snapshot", listener::onFailure);  
    }
                );
    }
                );  
                for (Map.Entry<String, SnapshotId> entry : allSnapshotIds.entrySet()) {  
                    request.partial(),  
                    SnapshotDeletionsInProgress.EMPTY
import java.util.Set;  
                boolean remoteStoreIndexShallowCopy = remoteStoreShallowCopyEnabled(repository);  
    }
            // inner loop over all the shard updates that are potentially applicable to the current snapshot entry  
            );
        try {  
            logger.warn(() -> new ParameterizedMessage("[{}] failed to finalize snapshot", snapshot), e);
        /**  
     *  
                            final ShardSnapshotStatus existingStatus = entry.shards().get(finishedRoutingShardId);  
                    for (IndexId index : entry.indices()) {
                            .withRemoteStoreIndexShallowCopy(  
     * It pins the same timestamp that is pinned by the source snapshot.  
     */  
        List<String> dataStreamsList,  
    }
                    for (final Map.Entry<RepositoryShardId, ShardSnapshotStatus> indexClone : updatedEntry.clones().entrySet()) {
                        + "] in cluster state and ["
            @Override
            Map<ShardId, ShardSnapshotStatus> shardAssignments = null;
            threadPool,
        }
                }
                    final ShardId finishedShardId = updateSnapshotState.shardId;
                        for (final Map.Entry<ShardId, ShardSnapshotStatus> value : entry.shards().entrySet()) {
                protected SnapshotDeletionsInProgress filterDeletions(SnapshotDeletionsInProgress deletions) {  
            @Override
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "must not contain '#'");  
import org.opensearch.common.Priority;
                            );
import org.opensearch.common.regex.Regex;  
                                if (snapshotInfo.getPinnedTimestamp() > 0) {  
                            deleteSnapshotsFromRepository(entry, newState.nodes().getMinNodeVersion());
                            new SnapshotMissingException(runningSnapshot.getRepository(), runningSnapshot.getSnapshotId(), e)
                        e -> {
    );  
                                .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(unmodifiableList(updatedSnapshotEntries)))
                        completeListenersIgnoringException(endAndGetListenersToResolve(snapshot), Tuple.tuple(newRepoData, snapshotInfo));
                }  
                        runReadyClone(
            if (attemptDelete) {  
        Setting.Property.Dynamic
                logger.warn("Failed to notify listeners", ex);
            return;  
        return true;
                        }
        private final Set<String> runningDeletions = Collections.synchronizedSet(new HashSet<>());
        return new ClusterStateUpdateTask() {
import java.util.List;
    }
            }
                }  
                    minCompatibleVersion(currentState.nodes().getMinNodeVersion(), repositoryData, null)
                            + "] matched requested pattern ["
    }  
        // dataFormatRegistry pre-registers DFA formats so cleanup deletes per-format files (e.g., parquet/).
        if (nextFinalization == null) {
     * ready for the repository {@link #leaveRepoLoop(String)} should be invoked so that a subsequent state change that
            failoverFallback.run();
            @Override
                        // We applied the update for a shard snapshot state to its snapshot entry, now check if we can update
            for (final Map.Entry<ShardId, ShardSnapshotStatus> shardStatus : entry.shards().entrySet()) {
     */
        }  
        final RepositoryCleanupInProgress repositoryCleanupInProgress = currentState.custom(  
                                + localNodeId
                    }  
     * Returns status of the currently running snapshots
        public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
                        ShardState.FAILED,
    private final Set<String> currentlyFinalizing = Collections.synchronizedSet(new HashSet<>());
    }
        }
                }
 * ownership. Elasticsearch licenses this file to you under  
                        runNextQueuedOperation(repositoryData, snapshot.getRepository(), true);  
                                        repositoryName,  
                                finishedRoutingShardId
            return updateSnapshotStateTaskKey;
        Collection<SnapshotId> snapshotIds,  
        String snapshotName
        return false;
            failAllListenersOnMasterFailOver(e);
     * Package private for testing
            // don't allow shallow snapshots if compatibility mode is not strict
        @Override
     * that were moved to {@link SnapshotDeletionsInProgress.State#STARTED} in the returned updated cluster state.
            final Snapshot snapshot = entry.snapshot();
     * @return list of shard to be included into current snapshot
        }
                "cannot snapshot while a repository cleanup is in-progress in [" + repositoryCleanupInProgress + "]"
    ) {
                            logger.warn(
                                "Starting clone [{}] on [{}] with generation [{}]",  
    private static final String IO_TIMEOUT_KEY = "snapshot.repository.io_timeout";
                return null;  
                            }
                    } finally {
                    }
                        }  
                    changed = true;  
    }
        final String translogRepository = settings.get(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY);
        RoutingTable routingTable,
                            }
                        statesToUpdate = EnumSet.of(State.STARTED, State.ABORTED);  
    }  
        this.indexNameExpressionResolver = indexNameExpressionResolver;
                    minCompatibleVersion(currentState.nodes().getMinNodeVersion(), repositoryData, null),  
            public void onFailure(String src, Exception e) {
            SnapshotDeletionsInProgress.EMPTY
                            leaveRepoLoop(repositoryName);
                }
     * Executor that applies {@link ShardSnapshotUpdate}s to the current cluster state. The algorithm implemented below works as described
                }
                            continue;
                    throw new ConcurrentSnapshotExecutionException(  
    }  
                            ActionListener.wrap(
                                finishedStatus.generation()  
                                indicesLookup = entry.indices().stream().collect(Collectors.toMap(IndexId::getName, Function.identity()));
                .noneMatch(entry -> entry.snapshot().equals(snapshot)) : "Snapshot [" + snapshot + "] is still in finalization queue";
            return false;
            if (repositoryData == null) {  
                        }
     */
                                ) ? SnapshotDeletionsInProgress.State.STARTED : SnapshotDeletionsInProgress.State.WAITING
                                }
                if (matchingIndices.isEmpty()) {  
            boolean changed = false;
        }
                    if (inProgress.stream().noneMatch(snapshotId -> snapshotId.getName().equals(snapshotOrPattern))) {
                        );
            public void onNoLongerClusterManager(String src) {
     * creates a snapshot record in cluster state metadata.  
        @Override
                    if (outstandingDeletes.isEmpty()) {
                            shardSnapshotStatus = new ShardSnapshotStatus(
                boolean changed = false;
            final Set<ShardId> reassignedShardIds = new HashSet<>();
                }
                );  
        String repositoryName,  
                    );
import org.opensearch.common.settings.Setting;
                for (Snapshot snapshot : completedNoCleanup) {
            throw new ConcurrentSnapshotExecutionException(  
            runningDeletions.clear();
                }  
    private static <T> Setting.Validator<T> snapshotResilienceValidator(String settingKey) {
        public void onFailure(String source, Exception e) {  
                    .filter(entry -> Objects.equals(entry.repository(), repoName))  
    public static final Setting<Integer> MAX_CONCURRENT_SNAPSHOT_OPERATIONS_SETTING = Setting.intSetting(
        Map<String, DataStream> dataStreams = new HashMap<>();
    /**  
                    );
                logger.info("snapshot-v2 clone [{}] started", snapshot);
                // state).
                    throw new ConcurrentSnapshotExecutionException(
                            if (clones == null) {
                                    updatedSnapshotEntries.add(snapshot);
                updatedEntries.add(entry);  
 *
     * <p>
    static final ClusterStateTaskExecutor<ShardSnapshotUpdate> SHARD_STATE_EXECUTOR = new ClusterStateTaskExecutor<ShardSnapshotUpdate>() {
                    }
                    failAllListenersOnMasterFailOver(e);  
                    if (status.equals(ShardSnapshotStatus.UNASSIGNED_QUEUED)) {  
                    snapshot,
            }
import org.opensearch.common.unit.TimeValue;  
            private SnapshotDeletionsInProgress.Entry deletionToRun;
                    @Override
                        newDelete = foundDuplicate.get();  
    /**
import java.util.Deque;
                    );  
            for (final ShardSnapshotStatus shardSnapshotStatus : snapshot.shards().values()) {
                        () -> {
    }
                    final EnumSet<State> statesToUpdate;
        3,
            if (repositoriesSeen.add(entry.repository())
                leaveRepoLoop(deleteEntry.repository());  
        final Set<Index> indices = new HashSet<>();
                shards.put(shardId, shardStatus);  
            repoName,
                    retryOrFailOnClusterManagerFailOver(  
                    .stream()
    }  
                removeFailedSnapshotFromClusterState(snapshot, e, repositoryData, null);
                    }
            public void onFailure(String source, Exception e) {  
                        "Can't clone index [" + indexId + "] because its snapshot was not successful."
    /**  
                        );  
                        snapshotName,
                                "Starting [{}] on [{}] with generation [{}]",
        if (repositoriesMetadata == null || repositoriesMetadata.repository(repositoryName) == null) {
            throw new IllegalArgumentException(
                    leaveRepoLoop(deleteEntry.repository());
                        sourceSnapshotId,  
        "snapshot.cleanup.retries",
        synchronized boolean isEmpty() {  
                }
                validate(repositoryName, snapshotName, currentState);
                final ShardGenerations shardGenerations = buildShardsGenerationFromRepositoryData(
                            new ActionListener<RepositoryData>() {  
                    newState,
        );
                Tuple<SnapshotsInProgress.Entry, Metadata> finalization;  
     * @return true if entry is currently writing to the repository
                public void onFailure(String source, Exception e) {
     */
            new LatchedActionListener<>(listener, latch)
                            throw new SnapshotException(
                                            new SnapshotException(snapshot, "Aborting Snapshot-v2 clone, no longer cluster manager")
    ClusterStateUpdateTask createStateWithoutSnapshotV2Task(String source, int attempt) {  
                        public void onFailure(Exception e) {
        }  
    private void addDeleteListener(String deleteUUID, ActionListener<Void> listener) {  
        );
                    retryOrFailOnClusterManagerFailOver(  
                for (SnapshotsInProgress.Entry entry : snapshots.entries()) {
     */
                        break;  
                    stateWithoutSnapshotV2(newState);
                        indicesForSnapshot.add(indexId.getName());
                assert runningDeletes.containsAll(deleteListenerKeys) : "Saw deletions listeners for unknown uuids in "
                            updateSnapshotState.updatedState.state()
            final Tuple<SnapshotsInProgress.Entry, Metadata> res = Tuple.tuple(nextEntry, latestKnownMetaData);
                                final RepositoryShardId repoShardId = new RepositoryShardId(indexId, finishedShardId.getId());
                            deletionsToExecute.add(delete);
                    failSnapshotCompletionListeners(
                "deleting snapshots [{}] from repository [{}]",
                null
         * relative to the {@link SnapshotDeletionsInProgress} found in {@code currentState}.
import org.opensearch.cluster.block.ClusterBlockException;  
                        throw new SnapshotException(repositoryName, snapshotName, "Aborting snapshot-v2 clone, no longer cluster manager");
            @Override
     * @param snapshots           list of snapshots that will be used as a filter, empty list means no snapshots are filtered  
                        final boolean remoteStoreIndexShallowCopy = Boolean.TRUE.equals(entry.remoteStoreIndexShallowCopy());
    private final Set<Snapshot> endingSnapshots = Collections.synchronizedSet(new HashSet<>());
     *  
                        e,
            final Repository repository = repositoriesService.repository(deleteEntry.repository());
                    startExecutableClones(newState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY), null);  
     * @param entry snapshot entry
import org.opensearch.common.util.concurrent.AbstractRunnable;
            @Override
         * The removal of a delete from the cluster state can trigger two possible actions on in-progress snapshots:
                    e
        ShardGenerations.Builder builder = ShardGenerations.builder();
                .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(unmodifiableList(entries)))
                newDeletes.add(newEntry);
                // already  
                final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);  
                }  
            for (IndexId indexId : indices) {  
                SnapshotDeletionsInProgress.EMPTY  
                        return;
        final boolean newFinalization = endingSnapshots.add(snapshot);  
                final Set<String> runningDeletes = Stream.concat(
                            // any leaked listener assertions
     * upload any shard metadata to the snapshot repository.
     * Removes a {@link SnapshotDeletionsInProgress.Entry} from {@link SnapshotDeletionsInProgress} in the cluster state after it executed
                    logger.warn("failing snapshot of shard [{}] on closed node [{}]", shardId, shardStatus.nodeId());
            clusterService.submitStateUpdateTask(source, createStateWithoutSnapshotV2Task(source, attempt));
                            + "]";
        RepositoryData repositoryData,
        synchronized (currentlyFinalizing) {  
                                    clonesBuilder.put(repoShardId, ShardSnapshotStatus.UNASSIGNED_QUEUED);
                    if (missing.isEmpty() == false) {
     * <p>  
            );
                } else {
    private static Metadata metadataForSnapshot(
        RepositoryData repositoryData,
 * this file be licensed under the Apache-2.0 license or a
            public void clusterStateProcessed(String source, ClusterState oldState, final ClusterState newState) {
    /**  
                                );
                    }
        }  
     */  
                @Override
                    if (entry.snapshot().getSnapshotId().equals(updatedSnapshot.getSnapshotId())) {
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
            @Override  
    ) {
                if (currentlyCloning.add(repoShardId)) {
                }
            }
                    public void onFailure(Exception e) {
        ActionListener<Void> listener  
 * not use this file except in compliance with the License.
        snapshot.indices().forEach(idx -> indexLookup.put(idx.getName(), idx));  
     * @param snapshotName snapshot name
                if (updatedEntry != null) {
                    deleteSnapshotsFromRepository(deletionToRun, repositoryData, newState.nodes().getMinNodeVersion());  
                    snapshotInfo,  
        RoutingTable routingTable,
            private final Collection<Snapshot> completedNoCleanup = new ArrayList<>();
                                } else {
                logger.trace("adding snapshot completion listener to wait for deleted snapshot to finish");
                }, e -> listener.onFailure(e));  
     * Listeners for snapshot deletion keyed by delete uuid as returned from {@link SnapshotDeletionsInProgress.Entry#uuid()}  
                    }
    ClusterStateUpdateTask createRemoveFailedSnapshotTask(
            IndexNameExpressionResolver indexNameExpressionResolver  
                for (int i = 0; i < indexMetadata.getNumberOfShards(); i++) {
                    snapshots = SnapshotsInProgress.of(
     * disconnect of a data node that was executing a snapshot) or a routing change that started shards whose snapshot state is
                    request.indicesOptions(),
     * @return updated cluster state
 * specific language governing permissions and limitations
        RepositoriesService repositoriesService,
     * @param repository          repository id
                        logger.error("Failed to retrieve metadata for snapshot-v2 {} {} ", repositoryName, snapshotName);
            listener.onFailure(e);  
        for (IndexId index : indices) {
                    snapshotChanged = true;  
    ) {  
            // from the repository from enqueued snapshot delete entries during the cluster state update. After the cluster state update we
        final Map<String, SnapshotId> allSnapshotIds = repositoryData.getSnapshotIds()  
                        leaveRepoLoop(repositoryName);  
        if (remoteStoreIndexShallowCopy
                }  
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
     * @param repositoryName snapshot repository name  
        clusterService.removeApplier(this);  
                            // snapshot  
            } else {
                            + "] cannot be modified while feature flag ["
            private SnapshotsInProgress.Entry newEntry;  
 * See package level documentation of {@link org.opensearch.snapshots} for details.
        SnapshotsInProgress snapshotsInProgress,  
            ActionFilters actionFilters,
            logger.warn("Retry scheduling rejected for [{}], falling back to failover handling", source);
                if (entry.repository().equals(repoName)) {
                final String localNodeId = currentState.nodes().getLocalNodeId();
        Collection<String> snapshotUUIDs = repositoryData.getSnapshotIds().stream().map(SnapshotId::getUUID).collect(Collectors.toSet());
        }  
        if (changed) {  
                                            )
            .indices()
            // Snapshots that were aborted and that already wrote data to the repository and now have to be deleted
                    () -> new ParameterizedMessage("failed to remove in progress snapshot v2 state after cluster manager switch {}", e),
        ClusterState.Builder builder = ClusterState.builder(state);
                            leaveRepoLoop(repositoryName);
                    state -> stateWithoutSnapshot(state, snapshot),
                    );
     * <p>  
                }
            .collect(Collectors.toSet());
        Repository repository = repositoriesService.repository(repositoryName);  
     * Setting that specifies the maximum number of allowed concurrent snapshot create and delete operations in the
                    snapshot,
            public TimeValue timeout() {
        );
     * Remove the given {@link SnapshotId}s for the given {@code repository} from an instance of {@link SnapshotDeletionsInProgress}.
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SHARD_PATH_TYPE;
        String snapshotName  
    }
                                updateSnapshotState,
                                );
                name,
                clusterService,  
                if (abortedDuringInit) {
                    if (Regex.simpleMatch(snapshotOrPattern, entry.getKey())) {
            } else {
        }
    // TODO: It is worth revisiting the design choice of creating a placeholder entry in snapshots-in-progress here once we have a cache
                    deletionsToFail.add(entry.uuid());
        ensureSnapshotNameNotRunning(runningSnapshots, repositoryName, snapshotName);
                @Override
            }
                        new Snapshot(repositoryName, sourceSnapshotId),
                                removeSnapshotDeletionFromClusterState(deleteEntry, e, repositoryData);
            );
                                entry
            }
                                + finishedStatus.nodeId()  
        final long delayMillis = Math.max(0L, Math.min(base.millis() * (1L << Math.min(attempt, 30)), TimeValue.timeValueDays(1).millis()));
     * shard update has an effect we use an outer loop over all current executing snapshot operations that iterates over them in the order
                                    }
                            final SnapshotsInProgress.Entry updatedEntry = entry.withShardStates(updatedAssignmentsBuilder);
        // get listeners before removing from the ending snapshots set to not trip assertion in #assertConsistentWithClusterState that
                    );
            } else {  
                                    new SnapshotException(snapshot, "Aborting snapshot-v2, no longer cluster manager")  
            @Override
                                null,
            if (snapshots.isEmpty() == false) {  
                                Boolean.TRUE.equals(snapshotInfoListener.result().isRemoteStoreIndexShallowCopyEnabled())
                indicesForSnapshot = new ArrayList<>();  
                    // If a failure is known for an execution we waited on for this shard then we fail with the same exception here  
                            leaveRepoLoop(repositoryName);  
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "must not contain ','");  
            if (Regex.isSimpleMatchPattern(snapshotOrPattern)) {
        }
        failListenersIgnoringException(endAndGetListenersToResolve(snapshot), e);
                                return;
                    event.routingTableChanged() && waitingShardsStartedOrUnassigned(snapshotsInProgress, event)
import org.opensearch.repositories.RepositoryData;  
            final String repo = entry.repository();
     * The next cluster-manager will try handling the missing operations. All we can do is fail all the listeners on this cluster-manager node so that
                        );
                        );
        @Nullable RepositoryData repositoryData,
                                iterator.remove();
                    indexIds,
        @Nullable
        final Set<String> reposSeen = new HashSet<>();
        return new Tuple<>(tokens[0], snapUUID);
        final Snapshot snapshot = new Snapshot(repositoryName, snapshotId);
    private static List<SnapshotsInProgress.Entry> findInProgressSnapshots(
                        final boolean remoteStoreIndexShallowCopy = Boolean.TRUE.equals(updatedEntry.remoteStoreIndexShallowCopy());
    private final RemoteStoreLockManagerFactory remoteStoreLockManagerFactory;
                                ShardState.MISSING,  
    private void deleteOrphanTimestamps(Map<String, List<Long>> pinnedEntities, List<String> orphanPinnedEntities) {  
                    // Removing shallow snapshots v2 as we we take care of these in stateWithoutSnapshotV2()
        assert assertConsistentWithClusterState(event.state());
                            .stream()  
                assert isPartial : "Data stream [" + dataStreamName + "] was deleted during a snapshot but snapshot was not partial.";
                } else {  
                            if (shards == null) {
            threadPool.schedule(() -> clusterService.submitStateUpdateTask(source, taskFactory.get()), delay, ThreadPool.Names.GENERIC);
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "must not start with '_'");  
    };  
        @Nullable SnapshotsInProgress snapshotsInProgress,
            logger.error("Unexpected failure during cluster state update", e);  
    private void finalizeSnapshotEntry(SnapshotsInProgress.Entry entry, Metadata metadata, RepositoryData repositoryData) {
    }
                            // When all the required shards for a snapshot are missing, the snapshot state will be "completed"
     * they were started in and an inner loop over the list of shard update tasks.
            @Override
        assert transportService.getRequestHandler(UPDATE_SNAPSHOT_STATUS_ACTION_NAME) != null;
            validateNoSegmentsOnlyIndices(clusterService.state(), repositoryName, snapshotName);
                repositoryOperations.clear();
                                completedNoCleanup.add(existingNotYetStartedSnapshot);
                        .stream()
                        latch.countDown();
                                repositoryData,
                return snapshotsInProgress.entries();
                            shardSnapshotStatus = ShardSnapshotStatus.UNASSIGNED_QUEUED;
        }  
        UpdateIndexShardSnapshotStatusResponse> {  
                    threadPool.absoluteTimeInMillis(),
        return changed ? SnapshotDeletionsInProgress.of(updatedEntries) : null;  
            @Override  
        }
     *  
                        } else {  
                                repoShardId.index()  
            return Tuple.tuple(currentState, Collections.emptyList());
        }  
                    v -> logger.trace("Marked [{}] as failed clone from [{}] to [{}]", repoShardId, sourceSnapshot, target.getSnapshotId()),
        Repository repository = repositoriesService.repository(repositoryName);
import static org.opensearch.common.util.IndexUtils.filterIndices;
    public static final String SNAPSHOT_PINNED_TIMESTAMP_DELIMITER = "__";
                .stream()  
        // Short circuit to noop state update if there isn't anything to delete
                logger.warn(
                            logger.trace(
            final SnapshotsInProgress.Entry nextEntry;  
                                        listener.onFailure(  
import static java.util.Collections.unmodifiableList;  
            // Snapshots that had all of their shard snapshots in queued state and thus were removed from the  
    private static <T> void completeListenersIgnoringException(@Nullable List<ActionListener<T>> listeners, T result) {
                return ClusterState.builder(currentState)  
            );
        return true;  
                // nothing to do for already completed snapshots
        protected void clusterManagerOperation(
            private ClusterStateUpdateTask deleteFromRepoTask;
        ClusterService clusterService,  
        SnapshotId sourceSnapshot,  
                                        "Failed to upload files to snapshot repo {} for clone snapshot-v2 {} ",
        }
     * and the contents of the repository. The minimum version is determined as the lowest version found across all snapshots in the  
                    .orElse(null);
                // Exclude warm-tiered pluggable-data-format indexes from V2 snapshots; they are  
            this.snapshot = snapshot;
                return ClusterState.builder(currentState).putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(newEntries)).build();
                    + " but running deletes are "  
                repository.getMetadata().name(),
                    repoShardId,  
            }
    private static final String MAX_OUTSTANDING_OPS_KEY = "snapshot.repository.max_outstanding_ops";
                    );
            failAllListenersOnMasterFailOver(e);
                                    logger.debug("removing not yet start clone operation [{}]", snapshot);  
            if (ExceptionsHelper.unwrap(e, NotClusterManagerException.class, FailedToCommitClusterStateException.class) != null) {
                                .build()
                        }
        if (repositoryOperations.startDeletion(deleteEntry.uuid())) {
                    return existing;  
            return;
        int changedCount = 0;  
        }  
        // Snapshots to fail after the state update
                    (replacedEntry == null ? deletionsInProgress : deletionsInProgress.withRemovedEntry(replacedEntry.uuid()))
            }  
                snapshotInfoListener.whenComplete(sourceSnapshotInfo -> {
                                : "This should never happen, cluster-manager will not submit a state update for a non-existing clone";
                                }  
            if (shards != null) {  
                }
                } else {
                        return snapshotsInProgress.entries();  
        Metadata metadata,
                        );  
                logger.trace("[{}][{}] creating snapshot for indices [{}]", repositoryName, snapshotName, indices);
            return Objects.hash(snapshot, shardId, updatedState, repoShardId);
                    currentState,
                );
import org.opensearch.cluster.node.DiscoveryNodes;
    }
            }
                            cleanOrphanTimestamp(repositoryName, repositoryData);
                    "Modifying snapshot state should only ever fail because we failed to publish new state",  
                        logger.warn("deleted snapshot failed", e);  
                            }  
                final List<String> dataStreams = indexNameExpressionResolver.dataStreamNames(
 *    http://www.apache.org/licenses/LICENSE-2.0
                        listener.onFailure(e);
    private static Map<ShardId, ShardSnapshotStatus> processWaitingShardsAndRemovedNodes(  
import static org.opensearch.repositories.blobstore.BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY;
    private final Map<String, List<ActionListener<Void>>> snapshotDeletionListeners = new HashMap<>();
    }
        SnapshotDeletionsInProgress.Entry deleteEntry,  
                        // from the cluster state  
                                        repoShardId,
                    throw new ConcurrentSnapshotExecutionException(  
    /**
        protected abstract void handleListeners(@Nullable List<ActionListener<Void>> deleteListeners);
package org.opensearch.snapshots;
        @Nullable SnapshotsInProgress snapshotsInProgress,
                        logger.warn("Cluster state update after failed shard clone [{}] failed", repoShardId);  
                            "missing routing table",
                final SnapshotInfo snapshotInfo = new SnapshotInfo(  
    }
                    new Snapshot(repositoryName, snapshotId),
     * Rejects a snapshot-v2 covering an index whose segments are remote backed but whose translog is not, which is how
                                if (existingStatus == null || existingStatus.state() != ShardState.QUEUED) {
            .map(indexMetadata -> indexMetadata.getIndex().getName())  
     */  
                            logger.error("Failed to update pinned timestamp for snapshot-v2 {} {} ", repositoryName, snapshotName);
                    && clusterService.getClusterSettings().get(REMOTE_STORE_COMPATIBILITY_MODE_SETTING).equals(CompatibilityMode.MIXED)) {
        Setting.Property.NodeScope,
                    "Removed all snapshot tasks for repository [{}] from cluster state, now failing listeners",  
                // completed snapshots do not require any updates so we just add them to the new list and keep going
                        snapshots.entries()  
                            new Snapshot(repoName, snapshotIds.get(0)),  
    /**
        };
                    return;
     * Adds snapshot completion listener
                        }  
                            updatedSnapshot,
                        }
            return;  
                        "[{}][{}] excluding [{}] warm-tiered pluggable data format index(es) from snapshot v2 (not currently supported)",
    /**
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;  
                                if (shards != null) {
        public ClusterState execute(ClusterState currentState) {
                    );
                    // and  
                                        new ShardSnapshotStatus(  
            }
                            + settingKey  
            );
        MAX_OUTSTANDING_OPS_KEY,
            latch.await();  
                        changed
/*  
                    throw new SnapshotException(
     */  
                failSnapshotCompletionListeners(  
                newEntry = SnapshotsInProgress.startedEntry(
    public void cloneSnapshotV2(
        }
                request,
     * below:
                    logger.error("Failed to pin timestamp for clone snapshot {} with exception {}", snapshot.getSnapshotId().getName(), e);
                        threadPool.absoluteTimeInMillis(),  
                    newEntry.dataStreams(),  
     * This method does some pre-validation, checks for the presence of source snapshot in repository data.
import org.opensearch.core.action.ActionListener;  
    }
        final Set<SnapshotId> foundSnapshots = new HashSet<>(inProgress);  
                                .getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false);  
                                }
                            ShardState.MISSING,
                        true,  
import static org.opensearch.cluster.service.ClusterManagerTask.UPDATE_SNAPSHOT_STATE;
                        newEntry.dataStreams(),
                        repository.cloneRemoteStoreIndexShardSnapshot(
            }  
                final List<String> excludedWarmDfa = new ArrayList<>();  
     * @param taskFactory     supplier that creates a NEW task instance per retry (TaskBatcher rejects same-identity resubmit)  
                    // Snapshot v2 create and clone are sync operation . In case of cluster manager failures in midst , we won't
            synchronized (currentlyFinalizing) {
            @Override
     * Runs a cluster state update that checks whether we have outstanding snapshot deletions that can be executed and executes them.  
        final List<IndexId> indices = cloneEntry.indices();
            + localNode  
                    "fail repo tasks for [" + deleteEntry.repository() + "]",
                        // delete
            repository.getRepositoryData(ActionListener.wrap(repositoryData -> {  
                if (metadata.index(id.getIndex()) == null) {
import org.opensearch.common.UUIDs;  
        Exception e,
     * <p>
        return ClusterStateTaskExecutor.ClusterTasksResult.<ShardSnapshotUpdate>builder().successes(tasks).build(currentState);
                target,
                e -> handleFinalizationFailure(e, entry, repositoryData)
            boolean changed = false;
                        repository.finalizeSnapshot(
                            .noneMatch(SnapshotsService::isWritingToRepository)
            if (remoteStoreShallowCopyEnabled) {
    };  
            } else {
import org.opensearch.cluster.ClusterChangedEvent;  
                return true;  
    public void applyClusterState(ClusterChangedEvent event) {
        } else if (primary.relocating() || primary.initializing()) {
                updatedEntry = entry.withClones(clones);
                }
                @Override
                                    // We don't have a new assignment for this shard because its index was concurrently deleted  
        if (entry.repositoryStateId() == RepositoryData.UNKNOWN_REPO_GEN) {
        final Collection<SnapshotId> snapshotIds = repositoryData.getSnapshotIds();
    // to be assigned
        } else {
        if (failure == null) {  
        }
     * </p>
import java.util.Map;  
                        if (shardStatusBefore.state() != ShardState.INIT) {  
                    SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);  
     * transport requests return and we don't leak listeners.  
                            "[{}] Updating shard [{}] with status [{}]",
                    repositoryOperations.finishDeletion(delete);
                        repositoryName,
        if (repository.isReadOnly()) {
                    runNextQueuedOperation(repositoryData, repository, false);
                                // normal snapshot
        protected ClusterBlockException checkBlock(UpdateIndexShardSnapshotStatusRequest request, ClusterState state) {
                            // Since we updated a normal snapshot we need to translate its shard ids to repository shard ids which requires
            }
                    }
import org.opensearch.repositories.RepositoryMissingException;
            remoteStorePinnedTimestampService.unpinTimestamp(
                            if (existingStatus == null || existingStatus.state() != ShardState.QUEUED) {  
                                } else {  
            ShardSnapshotStatus shardStatus = shardEntry.getValue();  
                "changed cluster state triggered by [{}] snapshot state updates and resulted in starting " + "[{}] shard snapshots",  
            synchronized (repositoryOperations.runningDeletions) {
            // them to multiple snapshots by accident
         *
                }
            logger.debug("Removing failed snapshot clone [{}] from cluster state", entry);  
                repoShardId,
            .filter(ds -> dataStreams.containsKey(ds) && dataStreamsToCheck.contains(ds))
                for (final Map.Entry<RepositoryShardId, ShardSnapshotStatus> clone : entry.clones().entrySet()) {
                                    final boolean added = reassignedShardIds.add(shardId);  
     * This method is used by clients to start snapshot. It makes sure that there is no snapshots are currently running and
                repositoryName,  
            ShardId shardId = shardEntry.getKey();
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
                            shardSnapshotStatus = new ShardSnapshotStatus(
                }
                    });
                    final List<SnapshotId> toDelete = unmodifiableList(new ArrayList<>(snapshotIdsRequiringCleanup));
        this.clusterService = clusterService;  
            .stream()
        if (settings.getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false) == false) {
            }
        this.remoteStoreLockManagerFactory = new RemoteStoreLockManagerFactory(  
     */
     * @param snapshot Snapshot to listen for
                }  
                // otherwise we could end up deleting a snapshot that is being restored  
                updatedEntry = entry;  
        }  
        final List<ShardSnapshotUpdate> unconsumedTasks = new ArrayList<>(tasks);
                for (final ShardSnapshotStatus status : entry.shards().values()) {
                protected void handleListeners(List<ActionListener<Void>> deleteListeners) {
                                    target.getSnapshotId()
                        // Maybe this state update completed the snapshot. If we are not already ending it because of a concurrent
        }
                        }
                        e,
                    } else {
                    ArrayList<SnapshotsInProgress.Entry> updatedSnapshotEntries = new ArrayList<>();  
        }  
                            "Indices don't have primary shards " + missing
            @Override  
            logger.trace("Moving on to finalizing next snapshot [{}]", nextFinalization);  
            logger.debug(() -> new ParameterizedMessage("[{}] failed to update cluster state during snapshot finalization", snapshot), e);
                deleteFromRepoTask = createDeleteStateUpdate(snapshotIds, repoName, repositoryData, Priority.NORMAL, listener);
                    } else {  
                            changed = true;
            private List<String> indicesForSnapshot;
                if (excludedWarmDfa.isEmpty() == false) {  
                            // without having to do any additional cleanup.  
                return true;
        if (snapshotsInProgress == null || snapshotsInProgress.entries().isEmpty()) {
        return repositoryName + SNAPSHOT_PINNED_TIMESTAMP_DELIMITER + snapshotUUID;
                repositoryName,  
            boolean enteredLoop;
                                    entry -> repoName.equals(entry.repository())  
     * @param failoverFallback the existing fallback behavior to run when retries are exhausted or not applicable
     *  
        CLEANUP_STALE_BLOBS_KEY,
    ) {
         * Computes an updated {@link SnapshotsInProgress} that takes into account an updated version of
    public static final String UPDATE_SNAPSHOT_STATUS_ACTION_NAME = "internal:cluster/snapshot/update_snapshot_status";  
                        // state update we check if its state is completed and end it if it is.  
                    ? SHARD_PATH_TYPE.get(repository.getMetadata().settings()).getCode()
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
     * operation.  
            }
                    DiscoveryNodes nodes = currentState.nodes();
                    shards.put(shardId, knownFailure);  
                    getInFlightIndexIds(runningSnapshots, repositoryName),  
                            new Snapshot(repoName, snapshotId),
            clusterStateUpdateTask = new RemoveSnapshotDeletionAndContinueTask(deleteEntry, repositoryData) {
                    final StepListener<Metadata> metadataListener = new StepListener<>();
            clusterService.getClusterSettings().addSettingsUpdateConsumer(SNAPSHOT_CLEANUP_RETRIES_SETTING, i -> maxRetries = i);
                            logger.trace("Delete [{}] could not execute directly and was queued", newDelete);
            public ClusterState execute(ClusterState currentState) {
            return runningDeletions.add(deleteUUID);
import static org.opensearch.snapshots.SnapshotUtils.validateSnapshotsBackingAnyIndex;
            if (value.isActive()) {
                                final ShardSnapshotStatus finishedStatus = updateSnapshotState.updatedState;
                                    );
            return running.getRepository().equals(repositoryName) && running.getSnapshotId().getName().equals(snapshotName);
                    repositoryData
                    .collect(Collectors.toSet());
                            repoShardId,
            return false;
        try {  
            }
     * to be re-assigned if there is another snapshot operation that is waiting for the shard to become available. We therefore record the
                        () -> new ParameterizedMessage(
                    logger.debug("[{}] was aborted before starting", snapshot);
        if (tryEnterRepoLoop(repoName)) {
                entries.add(entry);
    private final OngoingRepositoryOperations repositoryOperations = new OngoingRepositoryOperations();  
                createSnapshotPreValidations(currentState, repositoryData, repositoryName, snapshotName);
                    }
                assert false : new AssertionError(ex);
                    latch.await();  
                newEntry = SnapshotsInProgress.startedEntry(  
                        }  
                newEntries.add(newEntry);
            // cluster state right away
            return;
        }
                    newState.routingTable(),  
            return Collections.emptyList();  
            && request.indices().length == 0  
                // add the snapshot deletion to the cluster state
     * {@link SnapshotDeletionsInProgress}.
        private final String repository;
import org.opensearch.core.common.Strings;
                }, e -> {
    private static boolean assertNoDanglingSnapshots(ClusterState state) {  
                    }  
     * Checks if the given {@link SnapshotsInProgress.Entry} is currently writing to the repository.
        final SnapshotId snapshotId = new SnapshotId(snapshotName, UUIDs.randomBase64UUID());
                    assert shardGenerations.getShardGen(index, shardId.getId()) == null : "Found shard generation for new index ["  
                    public void onFailure(Exception e) {}
                threadPool.executor(ThreadPool.Names.SNAPSHOT).execute(() -> {
        private SnapshotsInProgress updatedSnapshotsInProgress(ClusterState currentState, SnapshotDeletionsInProgress updatedDeletions) {
                }
            // addLowPriorityApplier to make sure that Repository will be created before snapshot  
                    true,
     * @param currentState current cluster state
                final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);  
                return deleteFromRepoTask.execute(currentState);
        Snapshot snapshot,  
                final ClusterState updatedState = stateWithoutSnapshot(currentState, snapshot);
        // Only keep those data streams in the metadata that were actually requested by the initial snapshot create operation  
        boolean isSnapshotV2 = SHALLOW_SNAPSHOT_V2.get(repository.getMetadata().settings());  
        assert assertNoDanglingSnapshots(event.state());
                        repositoryName,
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
            return false;
            } else {
                        if (clones == null) {
                return request.clusterManagerNodeTimeout();  
        if (repository.isReadOnly()) {  
                );  
                                    snapshotsInProgress,
    }
            }  
    private static final class OngoingRepositoryOperations {
        if (snapshotName.contains(" ")) {
                ActionListener.onFailure(listeners, failure);
                failSnapshotCompletionListeners(snapshot, failure);  
                    if (sourceSnapshotInfo.getPinnedTimestamp() > 0) {  
    }  
            }
            }
                    return ClusterState.builder(currentState)  
                        shardStatus.nodeId(),  
            public TimeValue timeout() {
                    // BwC Path where we removed an outdated INIT state snapshot from the cluster state
                shardGenerations.indices().stream().map(IndexId::getName).collect(Collectors.toList()),  
import java.util.concurrent.CopyOnWriteArrayList;
            public void onResponse(Void unused) {
            if (entry.repository().equals(repositoryName) && Regex.simpleMatch(snapshotNames, entry.snapshot().getSnapshotId().getName())) {  
            final IndexRoutingTable indexRoutingTable = routingTable.index(indexName);  
     */  
                }
                    // aborted snapshots to potentially fail shards running on the removed nodes
                    for (final SnapshotsInProgress.Entry snapshot : snapshots.entries()) {
            @Override
        logger.debug("Failing all snapshot operation listeners because this node is not cluster-manager any longer", e);
            } else {
        if (repositoryData.getSnapshotIds().stream().anyMatch(s -> s.getName().equals(snapshotName))) {  
    /**
     *  
            // or not in RepositoryData.
                    repositoryData.getGenId(),
                                shards = new HashMap<>(entry.shards());
                actionFilters,
     * @param shardId shard id of the shard that just finished cloning
     */
     * If the update was not a noop, then it means that the shard it applied to is now available for another snapshot or clone operation
                    deletionsWithoutSnapshots(
                        e
                    .stream()
        } catch (OpenSearchRejectedExecutionException ex) {  
        if (changedCount > 0) {
                    + "] operations and the current"
        if (remoteStoreIndexShallowCopy
            failoverFallback.run();
     * @return            updated {@link SnapshotDeletionsInProgress} or {@code null} if unchanged
            }
                            // index got removed concurrently and we have to fail WAITING state shards  
                    knownFailures.put(shardId, failedState);  
                    }
        }  
                } else {  
    private static void validate(final String repositoryName, final String snapshotName) {
                entry.dataStreams(),
                ArrayList<SnapshotsInProgress.Entry> entries = new ArrayList<>();  
        }
    /**  
     * @param update shard snapshot status update  
                initializingClones.remove(targetSnapshot);
        synchronized boolean assertNotQueued(Snapshot snapshot) {
        repository.executeConsistentStateUpdate(repositoryData -> new ClusterStateUpdateTask(Priority.URGENT) {  
     */
                            stateWithoutSnapshotV2(newState);  
                snapshot.getSnapshotId(),
        );
            nextEntry = queued.pollFirst();
    private static ShardGenerations buildShardsGenerationFromRepositoryData(
        public final void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                            .filter(snapshot -> snapshot.remoteStoreIndexShallowCopyV2() == false)
                            completedWithCleanup.add(abortedEntry);
        Setting.Property.Dynamic
                metadataListener.onResponse(metadata);
                if (remoteStoreIndexShallowCopy == false) {
                    indices,
                );
                UpdateIndexShardSnapshotStatusRequest::new,  
        }
            clusterService.addLowPriorityApplier(this);
                        shardStatus.generation()  
 * SPDX-License-Identifier: Apache-2.0
                            updatedSnapshotEntries.add(snapshot);
            );  
                        createDeleteStateUpdate(outstandingDeletes, repoName, result.v1(), Priority.IMMEDIATE, listener)
import org.opensearch.common.SetOnce;
                                removeSnapshotDeletionFromClusterState(deleteEntry, null, updatedRepoData);  
                }  
                        } else if (primary == null || !primary.assignedToNode()) {  
                executor.execute(ActionRunnable.supply(snapshotInfoListener, () -> repository.getSnapshotInfo(sourceSnapshotId)));  
            super(
                                endSnapshot(entry, newState.metadata(), null);
                // this is a clone, see if new work is ready
            if (entry.partial() == false) {
            private SnapshotsInProgress.Entry newEntry;
            + localNode  
     * <p>  
                    .orElseThrow(() -> new SnapshotMissingException(repositoryName, request.source()));
                    + shards;
                    .findAny()  
                changedCount,
                    } else {
        snapshotCompletionListeners.computeIfAbsent(snapshot, k -> new CopyOnWriteArrayList<>()).add(listener);
                                );
                        deletionToRun = entry;  
                "["
                assert false : new AssertionError(ex);  
                final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                ShardSnapshotStatus status = shardStatus.getValue();
                            final ShardId finishedRoutingShardId = new ShardId(indexMeta.getIndex(), finishedShardId.shardId());
                        changed = true;
                snapshotName,  
            }
                    request.indices()
                if (enteredLoop == false) {
 * KIND, either express or implied.  See the License for the
        ActionFilters actionFilters,
                );
            this.userCreateSnapshotListener = userCreateSnapshotListener;
        String repoName,  
                        if (readyToExecute == false || inFlightShardStates.isActive(indexName, i)) {
     * Same as {@link #createSnapshot(CreateSnapshotRequest, ActionListener)} but invokes its callback on completion of  
                    if (snapshotsWithLockFiles.size() > 0) {
    }
                        );
                return deleteSnapshotTaskKey;
            logger.warn(
        clusterService.submitStateUpdateTask(
    public static Set<Index> snapshottingIndices(final ClusterState currentState, final Set<Index> indicesToCheck) {
        }  
        final RepositoryData repositoryData  
        }
            public ClusterState execute(ClusterState currentState) {
                ensureSnapshotNameAvailableInRepo(repositoryData, snapshotName, repository);
    }  
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "must be lowercase");  
                        );
            if (entry.remoteStoreIndexShallowCopyV2()) {
                });
            final SnapshotsInProgress.Entry updatedEntry;
                            .collect(Collectors.toSet());
                public void onResponse(Void unused) {  
        final ShardSnapshotStatus shardSnapshotStatus;
                    repositoryOperations.runningDeletions.stream()
     * Removes record of running snapshot from cluster state and notifies the listener when this action is complete. This method is only  
                    } finally {
    );  
                            shards.put(finishedRoutingShardId, shardSnapshotStatus);  
            return ClusterStateTaskExecutor.ClusterTasksResult.<ShardSnapshotUpdate>builder()
                }
                            shardSnapshotStatus = new ShardSnapshotStatus(primary.currentNodeId(), shardRepoGeneration);
            snapshotsToFinalize.clear();
                failCloneShardAndUpdateClusterState(target, sourceSnapshot, repoShardId);
 * license agreements. See the NOTICE file distributed with
                                    if (!clusterService.state().nodes().isLocalNodeElectedClusterManager()) {  
                    listener.onFailure(e);  
                                shardId,  
        for (SnapshotsInProgress.Entry entry : snapshots.entries()) {  
import java.util.stream.Collectors;
                    snapshots,
    public SnapshotsService(
            assertConsistent();
                                && reassignedShardIds.contains(value.getKey()) == false) {
                if (enteredLoop) {  
                    return updateWithSnapshots(currentState, updatedSnapshots, null);
                } else {  
                            + "]"
            assert currentlyFinalizing.contains(deleteEntry.repository());
 * under the License.  
     *
                        fallback
                // don't allow snapshot deletions while a restore is taking place,
                final List<SnapshotsInProgress.Entry> newEntries = new ArrayList<>(runningSnapshots);  
     * Setting that controls whether a successful snapshot delete should opportunistically reclaim storage
                    shardFailures.add(new SnapshotShardFailure(status.nodeId(), shardId, status.reason()));
                } else {
                        + "]";
        } catch (Exception e) {  
                            repositoriesService.repository(entry.repository()),
            final StepListener<Metadata> metadataListener = new StepListener<>();  
        assert endingSnapshots.isEmpty() : "Found leaked ending snapshots " + endingSnapshots + " on [" + localNode + "]";
                        rData -> threadPool.executor(ThreadPool.Names.SNAPSHOT).execute(ActionRunnable.supply(metadataListener, () -> {  
     * @param state                       current cluster state  
                    return currentState;
            SnapshotDeletionsInProgress.TYPE,  
                            ActionListener.wrap(updatedRepoData -> {  
                final List<SnapshotsInProgress.Entry> runningSnapshots = snapshots.entries();
                logger.info("[{}][{}] creating snapshot-v2 for indices [{}]", repositoryName, snapshotName, indices);  
                                final RepositoryShardId repoShardId = new RepositoryShardId(count.v1(), shardId);
                    } else {  
                }  
                                entry
    private static void ensureSnapshotNameAvailableInRepo(RepositoryData repositoryData, String snapshotName, Repository repository) {
                final IndexMetadata indexMetadata = metadata.index(index.getName());
            }
                        "cannot start snapshot-v2 while a repository is in finalization state"  
            retryBackoff = SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING.get(settings);  
                    if (entry.snapshot().getSnapshotId().getName().equals(snapshot)) {
        private final List<Snapshot> snapshotsToFail = new ArrayList<>();
                    listener.onFailure(  
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
            }
                        logger.trace(  
                final String localNodeId = clusterService.localNode().getId();  
     * @param snapshotDeletionsInProgress new value for {@link SnapshotDeletionsInProgress} or {@code null} if it's unchanged
        executor.execute(new AbstractRunnable() {
            final SnapshotDeletionsInProgress updatedDeletions = deletions.withRemovedEntry(deleteEntry.uuid());
    private static SnapshotDeletionsInProgress deletionsWithoutSnapshots(
                }
            shardSnapshotStatus = new ShardSnapshotStatus(
                final List<SnapshotsInProgress.Entry> runningSnapshots = snapshots.entries();  
                );  
        boolean remoteStoreIndexShallowCopy = remoteStoreShallowCopyEnabled(repository);  
                            logger.warn(
                    listener.onResponse(snapshot);
 * GitHub history for details.
                && Objects.equals(this.shardId, that.shardId)
            return deletions;  
    private final ClusterService clusterService;
            @Override
     * iteration as it was already applied before and likely just arrived on the cluster-manager node again due to retries upstream.  
                        final SnapshotsInProgress snapshotsInProgress = newState.custom(
            + "]";
        FailPendingRepoTasksTask(String repository, Exception failure) {  
                }).filter(Objects::nonNull).collect(Collectors.toList()));
         * Set of delete operations currently being executed against the repository. The values in this set are the delete UUIDs returned
                            .filter(entry -> repoName.equals(entry.repository()))
    /**
     * @param attempt         current attempt number (0-based)
        );  
                                // The index name that finished cloning does not exist in the cluster state so it isn't relevant to a
                        stateWithoutSnapshotV2(newState);
            failoverFallback.run();
        executor.execute(ActionRunnable.supply(snapshotInfoListener, () -> repository.getSnapshotInfo(sourceSnapshot)));
     * @param failure     failure encountered while executing the delete on the repository or {@code null} if the delete executed
                        repository.deleteSnapshotsWithPinnedTimestamp(  
            DataStream dataStream = metadata.dataStreams().get(dataStreamName);  
        ArrayList<SnapshotsInProgress.Entry> entries = new ArrayList<>();
            }
            readyDeletions
                finalizeSnapshotEntry(entry, metadata, repositoryData);
        }
        final Tuple<SnapshotsInProgress.Entry, Metadata> nextFinalization = repositoryOperations.pollFinalization(repository);
                        targetSnapshot,  
                    if (shardRouting != null && shardRouting.primaryShard() != null) {  
            .filter(entry -> entry.state() == SnapshotDeletionsInProgress.State.STARTED)
                                clones = new HashMap<>(entry.clones());
                if (newDelete == null) {
        remoteStorePinnedTimestampService.pinTimestamp(
        private Metadata latestKnownMetaData;
                    }  
    private void cloneSnapshotPinnedTimestamp(
                            if (indexId != null) {
                                    changed = true;  
        validate(repositoryName, snapshotName);  
                    userMeta,  
         * Clear all state associated with running snapshots. To be used on cluster-manager-failover if the current node stops  
                                finishedShardId,
                final List<SnapshotsInProgress.Entry> newEntries = new ArrayList<>(runningSnapshots);  
                                    changed = true;
     * <p>  
                                    updatedAssignmentsBuilder.put(shardId, ShardSnapshotStatus.MISSING);
        }  
                    .collect(Collectors.toList());
                } else {
        }
                    if (existing.state() == State.STARTED && snapshotIdsRequiringCleanup.contains(existing.snapshot().getSnapshotId())) {
            createSnapshot(
     */  
        }, "create_snapshot [" + snapshotName + ']', listener::onFailure);
                }
     *  
        final Repository repository = repositoriesService.repository(repoName);
                return ActionListener.wrap(
        @Nullable final Exception failure,
        );  
import org.opensearch.action.LatchedActionListener;
            } else if (shardStatus.state().completed() == false && shardStatus.nodeId() != null) {
            return repoShardId != null;
        }  
    }
                final Version minNodeVersion = currentState.nodes().getMinNodeVersion();
        return builder.dataStreams(dataStreams).build();
        assert currentlyFinalizing.contains(entry.repository());
    }
                            return true;
                }
                        final InFlightShardSnapshotStates inFlightShardStates = InFlightShardSnapshotStates.forRepo(
                for (IndexId index : indices) {
                    SnapshotDeletionsInProgress.TYPE,
                    shardFailures.add(new SnapshotShardFailure(status.nodeId(), shardId, "skipped"));  
                    .findFirst()  
                if (request.partial() == false) {
     * repository blob operations per repository. Past this limit, further operations fail fast with a  
    private final class FailPendingRepoTasksTask extends ClusterStateUpdateTask {
            }  
                            failCloneShardAndUpdateClusterState(target, sourceSnapshot, repoShardId);
        long timestampToPin,  
     * Snapshot-v2 does not flush before pinning its timestamp, so a restore reconstructs the point in time from the
     * @param repository  repository that the snapshot ids belong to  
                        )  
                    new Snapshot(repositoryName, snapshotId),
                    updatedEntries.add(entry);  
            listener.onFailure(new RepositoryException(repositoryName, "cannot create snapshot in a readonly repository"));
            final boolean isNewIndex = repositoryData.getIndices().containsKey(indexName) == false;
        if (snapshotChanged) {  
        }  
                        indices.add(indexMetadata.getIndex());
     * reason, remove the snapshot's {@link SnapshotsInProgress.Entry} from the cluster state and move on with other queued snapshot  
                assert readyDeletions(currentState).v1() == currentState
            final List<SnapshotsInProgress.Entry> snapshotEntries = new ArrayList<>();
        Snapshot snapshot,
            } else {
            throw new InvalidSnapshotNameException(repositoryName, snapshotName, "snapshot with the same name is already in-progress");  
                final SnapshotsInProgress updatedSnapshots = SnapshotsInProgress.of(snapshots.entries().stream().map(existing -> {  
                    request.partial(),
                                continue;
                pinnedEntity,
                                && entry.state() == SnapshotDeletionsInProgress.State.STARTED
                    version,
                    + maxOps
        IO_TIMEOUT_KEY,
                                "Received clone shard snapshot status update [{}] but this shard is not tracked in [{}]",  
                            + " that should should been deleted by ["
import org.opensearch.transport.TransportService;  
                if (repository.isReadOnly()) {
                final Snapshot updatedSnapshot = updateSnapshotState.snapshot;  
                    .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(new ArrayList<>(newEntries)))
            @Override
                    if (cloneRemoteStoreIndexShardSnapshot) {  
        return builder.build();
                            }
                    "shard is unassigned",
import org.apache.logging.log4j.Logger;
    }
        for (SnapshotsInProgress.Entry entry : currentState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY).entries()) {  
            // Entry is writing to the repo because it's finalizing on cluster-manager  
import org.opensearch.cluster.SnapshotsInProgress.ShardSnapshotStatus;  
     */
     *
                if (updatedSnapshotIds.removeAll(snapshotIds)) {
     * Computes the exponential backoff for a given attempt. The shift is capped to avoid overflow and the resulting
            });
                }  
        private final ShardSnapshotStatus updatedState;
                            // so we check on a shard level  
    }  
            final String source = "remove in progress snapshot v2 after cluster manager switch";  
                    }
    }  
                0
    public void createSnapshot(final CreateSnapshotRequest request, final ActionListener<Snapshot> listener) {  
        );
            SnapshotDeletionsInProgress.TYPE,  
                    : "Repository generation should not change as long as a ready delete is found in the cluster state but found ["
                    }
                repositoryData,  
                addListener(runningSnapshot, ActionListener.wrap(result -> {  
     * Initial backoff duration for cleanup retries. Each subsequent retry doubles this value.  
        for (String index : indices) {
                            continue;
        ClusterState result = state;
    private void failAllListenersOnMasterFailOver(Exception e) {
            this.latestKnownMetaData = metadata;
            IndexMetadata indexMetadata = metadata.index(indexName);
                );
        if (snapshots == null) {
                }
        for (SnapshotDeletionsInProgress.Entry entry : deletions.getEntries()) {
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_SNAPSHOT;  
            @Override
        snapshotInfoListener.whenComplete(snapshotInfo -> {
                }
                    }  
    private static boolean removedNodesCleanupNeeded(SnapshotsInProgress snapshotsInProgress, List<DiscoveryNode> removedNodes) {
        if (snapshotsInProgress != null) {
        final Snapshot snapshot = entry.snapshot();
     * Setting to specify the maximum number of shards that can be included in the result for the snapshot status  
                    .stream()
                    }  
                        attempt,
    public static ClusterState updateWithSnapshots(
            "update snapshot state",
                );  
        }  
                            // Adding the snapshot to #endingSnapshots since we still have to resolve its listeners to not trip
                        System.currentTimeMillis(),
     * last remote segment metadata at or before the timestamp and then replays the remote translog to close the gap.
        String source,
                            target.getSnapshotId(),  
     * The pinned timestamp is later reconciled with remote store segment and translog metadata files during the restore
        }
    ) {
                if (deletionsInProgress.getEntries().stream().anyMatch(entry -> entry.getSnapshots().contains(sourceSnapshotId))) {  
                logger.debug("Timestamp pinned successfully for snapshot {}", snapshot.getSnapshotId().getName());
    }
                        clusterService.submitStateUpdateTask(
                final List<SnapshotId> updatedSnapshotIds = new ArrayList<>(entry.getSnapshots());
                    Priority.NORMAL,  
                if (isSnapshotV2 && remoteStoreIndexShallowCopy && entriesForThisRepo.isEmpty() == false) {
                    final Optional<SnapshotDeletionsInProgress.Entry> foundDuplicate = deletionsInProgress.getEntries()  
     * @param request snapshot request
    }
     * Initializes the snapshotting process.  
                    shardGenerations,  
                                finishedStatus.generation()
                    } else {
                        listener.onFailure(
     */
                if (enteredRepoLoop == false) {
            throw new InvalidSnapshotNameException(  
                    if (ExceptionsHelper.unwrap(e, NotClusterManagerException.class, FailedToCommitClusterStateException.class) != null) {
                                && entry.getSnapshots().containsAll(snapshotIds)
        final Set<String> removedNodeIds = removedNodes.stream().map(DiscoveryNode::getId).collect(Collectors.toSet());
                );  
                    updatedEntries.add(entry);
            }
        List<SnapshotDeletionsInProgress.Entry> updatedEntries = new ArrayList<>(deletions.getEntries().size());
                        shardSnapshotStatus = new ShardSnapshotStatus(
        Version minCompatVersion = minNodeVersion;
                        SnapshotDeletionsInProgress.TYPE,  
            @Override
                newDeletes.add(entry);
                            entry.source(),
     * Package private to allow for tests.
        assert this.updateSnapshotStatusHandler != null;
        SnapshotDeletionsInProgress deletions,
                        logger.info("snapshots {} deleted", snapshotIds);
import org.opensearch.cluster.ClusterState;
            logger.warn("Failed to update snapshot state ", e);
        Setting.Property.NodeScope,  
                final Set<SnapshotId> activeCloneSources = snapshots.entries()  
                for (Snapshot snapshot : new HashSet<>(snapshotCompletionListeners.keySet())) {  
    private static void ensureSnapshotNameNotRunning(  
    ) {
            boolean enteredRepoLoop;
        String repository,
            // Most likely scenario - one snapshot is currently running  
            final boolean remoteStoreShallowCopyEnabled = REMOTE_STORE_INDEX_SHALLOW_COPY.get(repository.getMetadata().settings());  
                    assert snapshot.partial() : "Index [" + id.getIndex() + "] was deleted during a snapshot but snapshot was not partial.";  
                        && IndexModule.IS_WARM_INDEX_SETTING.get(idxMd.getSettings())) {  
     * Finalizes the shard in repository and then removes it from cluster state  
                    + " on this repository to take a full or shallow v1 snapshot instead. Offending indices: "  
                    // don't allow shallow snapshots if compatibility mode is not strict
            for (int i = 0; i < indexMetadata.getNumberOfShards(); i++) {
                failAllListenersOnMasterFailOver(e);
     * the snapshot.
     *  
     * If no deletion contained any of the snapshot ids to remove then return {@code null}.
        final Map<ShardId, ShardSnapshotStatus> snapshotShards,
            );  
import java.util.function.Consumer;
     * Run the next queued up repository operation for the given repository name.
                    shardGenerations,
     * <p>
                        return abortedEntry;
                logger.warn(() -> new ParameterizedMessage("[{}][{}] failed to clone snapshot-v2", repositoryName, snapshotName), e);
            if (!(other instanceof ShardSnapshotUpdate that)) {  
                    if (indexMetadata != null && indicesToCheck.contains(indexMetadata.getIndex())) {
    ) {
     * @param source          the cluster state update source string
                            final IndexMetadata indexMeta = currentState.metadata().index(finishedShardId.indexName());
import java.util.stream.Stream;  
            public ClusterState execute(ClusterState currentState) {  
    }
            @Override
}
            currentlyFinalizing.clear();
                    for (SnapshotDeletionsInProgress.Entry delete : res.custom(
        // index.replication.type, and this runs over every index in the cluster rather than one being created.  
                            if (snapshot.isClone() && snapshot.clones().isEmpty()) {
                }
                    + inProgressOperations
                    if (repositoryData.getSnapshots(indexId).contains(sourceSnapshotId)) {
    private final ClusterManagerTaskThrottler.ThrottlingKey deleteSnapshotTaskKey;  
        final Snapshot snapshot = new Snapshot(repositoryName, snapshotId);
     *  
        }
        final Map<String, IndexId> indexLookup = new HashMap<>();
                    request.includeGlobalState(),  
import org.opensearch.repositories.RepositoryException;
    protected void doStart() {  
        }  
    // Set of repositories currently running either a snapshot finalization or a snapshot delete.
                    listener.onResponse(repositoryData);
                    + runningSnapshots;
                    + segmentsOnlyIndices
            + " on ["
            @Override
                            repositoryData.getVersion(sourceSnapshotId),  
                        );
        } else {
                                final ShardSnapshotStatus existingStatus = entry.clones().get(repoShardId);  
                    remoteStoreIndexShallowCopy = false;
    public static final Setting<TimeValue> SNAPSHOT_REPOSITORY_IO_TIMEOUT_SETTING = new Setting<>(
                ShardState.MISSING,  
        final SnapshotsInProgress snapshots = currentState.custom(SnapshotsInProgress.TYPE);  
     */
                            repoName,  
            }  
                final IndexId indexId = indexLookup.get(id.indexName());  
                enteredRepoLoop = tryEnterRepoLoop(repositoryName);
        boolean includeGlobalState,
                        repositoryName,
                    builder.put(shardId, shardSnapshotStatus);
            // resolve the delete listeners with the latest repository data from after the delete.  
            new ShardSnapshotUpdate(  
            final SnapshotInfo snapshotInfo = new SnapshotInfo(
                    shards,  
    private final IndexNameExpressionResolver indexNameExpressionResolver;
                        // unless there is an executing snapshot delete already. If there is an executing snapshot delete we don't have to  
                );
    private static List<SnapshotId> matchingSnapshotIds(  
                    repositoryData.getGenId(),
                failure,  
     * Returns the indices that are currently being snapshotted (with partial == false) and that are contained in the indices-to-check set.  
                builder.add(entry);  
            @Override
     * @return true if a finalization or snapshot delete may be started at this point
        this.remoteSegmentStoreDirectoryFactory = new RemoteSegmentStoreDirectoryFactory(  
     * @param entry          snapshot entry that failed to finalize
            }  
        return builder.build();  
            throw new RuntimeException(e);
            }
                    removeSnapshotDeletionFromClusterState(deleteEntry, e, repositoryData);
                            return true;
            return new ClusterStateUpdateTask() {
                        updatedEntry = cloneEntry.withClones(clonesBuilder)
                    snapshotChanged = true;
                        repoName,
        CleanupAfterErrorListener(ActionListener<Snapshot> userCreateSnapshotListener, Exception e) {
                final SnapshotDeletionsInProgress deletionsInProgress = currentState.custom(
                    listener.onFailure(e);
                    repositoryData,
                    @Override  
        List<IndexId> indices,  
                    }
                    final Map<String, Map<ShardId, ShardSnapshotStatus>> knownFailures = new HashMap<>();  
        try {
                    + "] snapshot-v2 is not supported for indices whose translog is not remote backed, since restoring a "  

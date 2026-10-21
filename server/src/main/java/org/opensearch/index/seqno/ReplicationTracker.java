            updateReplicationGroupAndNotify();
    public long getAsLong() {
            throw new IllegalStateException("no local checkpoint tracking information available for " + allocationId);
        /**
        /**
    private final LongConsumer onGlobalCheckpointUpdated;
     * @param retainingSequenceNumber the retaining sequence number
                || indexSettings.isAssignedOnRemoteNode()) {
                        final CheckpointState checkpointState = checkpoints.get(shardRouting.allocationId().getId());
 */
                }
    final Set<String> pendingInSync;
        if (cps != null && globalCheckpoint > cps.globalCheckpoint) {
    }
                }
                .stream()
        return getRetentionLeases(false).v2();
    }
import java.util.HashMap;
            this.routingTable = routingTable;
        assert RetentionLeases.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, path) != null;
     * Atomically clones an existing retention lease to a new ID.
     */
    }
     */
        // the current shard is marked as tracked when the global checkpoint tracker operates in primary mode
                if (retentionLease == null) {
        assert invariant();
        public boolean equals(Object o) {
     * because the cluster-manager could have failed some of the in-sync shard copies and marked them as stale. That is ok though, as this
                // if the shard is in checkpoints but is unavailable or out of sync we will not track its replication state.
        }
        onSyncRetentionLeases.accept(currentRetentionLeases, listener);
                for (String inSyncId : inSyncAllocationIds) {
     * - A primary relocation target is moved to primary mode (using {@link #activateWithPrimaryContext}) during the primary relocation
                visibleCheckpoint,
    @SuppressForbidden(reason = "Object#wait for local checkpoint advancement")
        onSyncRetentionLeases.accept(currentRetentionLeases, listener);
     */
        // remote enabled primary taking over primary context from another remote enabled shard
 * @opensearch.internal
 */
            // can happen if the relocation target was removed from cluster but the recovery process isn't aware of that.
        // and the replication group has at-least one shard copy in docrep enabled node
     *
        final ShardRouting shardRouting = routingTable.getByAllocationId(allocationId);
         * Map of ReplicationCheckpoints to ReplicationTimers.  Timers are added as new checkpoints are published, and removed when
     * in particular {@link #markAllocationIdAsInSync}.
        long globalCheckpoint,
import java.nio.file.Path;
     * @param id                      the identifier of the retention lease
        // capture current state to possibly replay missed cluster state update
                        )
                    }
        // the primary calculates the non-expired retention leases and syncs them to replicas
                        to the remote enabled nodes. Ensures that:
    }
        final IndexShardRoutingTable lastAppliedRoutingTable = routingTable;
                if (shardRouting.assignedToNode()) {
                            )
            });
    }
            final RetentionLease sourceLease = getRetentionLeases().get(sourceLeaseId);
    }
 * <p>
            cps.globalCheckpoint = globalCheckpoint;
        final IndexSettings indexSettings,
    /**
        synchronized (retentionLeasePersistenceLock) {
    @SuppressForbidden(reason = "Object#notifyAll waiters for local checkpoint advancement")
        final RetentionLeases currentRetentionLeases;
     */
     *
     */
            RetentionLeases.FORMAT.writeAndCleanup(currentRetentionLeases, path);
            if (routingTable.equals(that.routingTable)) return false;
                    logger.trace("skipping persisting retention leases [{}], already persisted", retentionLeases);
            }
                || inSyncAllocationIds.stream().allMatch(inSyncId -> checkpoints.containsKey(inSyncId) && checkpoints.get(inSyncId).inSync)
            && checkpoints.get(shardAllocationId).localCheckpoint == SequenceNumbers.UNASSIGNED_SEQ_NO : "expected "
            + globalCheckpoint
    /**
    }
        assert primaryMode;
     * advances on the basis of state changes tracked here. For non-primary mode this occurs if the local knowledge of the global checkpoint
        for (Map.Entry<String, CheckpointState> entry : primaryContext.checkpoints.entrySet()) {
        final Set<String> inSyncAllocationIds = new HashSet<>();
     * - replica: this shard receives global checkpoint information from the primary (see
        this.isShardOnRemoteEnabledNode = isShardOnRemoteEnabledNode;
        final Set<String> leaseIdsForCurrentPeers;
         * The currently searchable replication checkpoint.
     * Wait for the local checkpoint to advance to the global checkpoint.
            throw new RetentionLeaseAlreadyExistsException(id);
        return () -> updateFromClusterManager(lastAppliedClusterStateVersion, inSyncAllocationIds, lastAppliedRoutingTable);
     *
            localCheckpointsCopy.put(entry.getKey(), entry.getValue().copy());
     * allocation ID to catch up to the global checkpoint.
        if (checkpoint.equals(latestReplicationCheckpoint) == false) {
        assert invariant();
        // we have a routing table iff we have a replication group
     * Retention leases for peer recovery have source {@link ReplicationTracker#PEER_RECOVERY_RETENTION_LEASE_SOURCE}, a lease ID
            } finally {
        });
     * @param sourceLeaseId the identifier of the source retention lease
import org.opensearch.core.index.shard.ShardId;
    private boolean shouldSkipReplicationLag(String allocationId) {
                 * We got here here via a rolling upgrade from an older version that doesn't create peer recovery retention
                if (retentionLeases.supersedes(persistedRetentionLeasesPrimaryTerm, persistedRetentionLeasesVersion) == false) {
     */
            if (retentionLeases.contains(id) == false) {
     * Represents the sequence number component of the primary context. This is the knowledge on the primary of the in-sync and initializing
        }
     */
            this.checkpoints = checkpoints;
     */
        final long operationPrimaryTerm,
        return retentionLease;
            logger.trace(
                // group.
    /**
        // Missing routing entries are filtered by getUnavailableInSyncShards() before this method is called.
        final long previousGlobalCheckpoint = globalCheckpoint;
            cps.localCheckpoint = SequenceNumbers.UNASSIGNED_SEQ_NO;
        createdMissingRetentionLeases = true;
     * it is important that the global checkpoint tracker does not miss any state updates that might happened during the handoff attempt.
                allocationId,
            }
                .allMatch(
            + localCheckpoint
import java.util.Collection;
     * Advance the peer-recovery retention leases for all assigned shard copies to discard history below the corresponding global
                    }
    /**
        assert primaryMode;
     *   to replica mode (using {@link #completeRelocationHandoff}), as the relocation target will be in charge of the global checkpoint
            getPeerRecoveryRetentionLeaseId(nodeId),
    public synchronized void initiateTracking(final String allocationId) {
                retentionLeases.version() + 1,
        long lastCompletedReplicationLag;
        String nodeId,
        return addRetentionLease(
        assert globalCheckpoint >= SequenceNumbers.UNASSIGNED_SEQ_NO : "illegal initial global checkpoint: " + globalCheckpoint;
            } else {
        private final Map<String, CheckpointState> checkpoints;
                        )
     * computation to happen (for example due to blocking), it returns the fallback value.
    private final Supplier<SafeCommitInfo> safeCommitInfoSupplier;
                localCheckpoint
     * Class invariant that should hold before and after every invocation of public methods on this class. As Java lacks implication
     * @param indexSettings             the index settings
                        if (retentionLease.retainingSequenceNumber() <= newRetainedSequenceNumber) {
                    PEER_RECOVERY_RETENTION_LEASE_SOURCE
     * primary relocation handoff.
            && checkpoints.get(shardAllocationId).inSync
                                primaryTargetAllocationId,
     * @param targetLeaseId the identifier of the retention lease to create
import org.opensearch.core.xcontent.NamedXContentRegistry;
    ) {
         * case the associated shard is temporarily unassigned. However we must not renew them too often, since each renewal must be
     */
     * The current in-memory global checkpoint. In primary mode, this is a cached version of the checkpoint computed from the local
        // is that they will have to undergo a recovery attempt on the relocation target, and will hence be supplied by the cluster state
    }
     * @param source                  the source of the retention lease
        }
            for (ShardRouting shardRouting : routingTable) {
     */
                    } else {
        if (pending && cps.localCheckpoint >= getGlobalCheckpoint()) {
    public synchronized void renewPeerRecoveryRetentionLeases() {
import java.util.function.LongSupplier;
                            initializingId,
        }
            final GroupedActionListener<ReplicationResponse> groupedActionListener = new GroupedActionListener<>(ActionListener.wrap(vs -> {
        /**
            + "]";
                                    primaryAllocationId,
     * @throws RetentionLeaseNotFoundException      if the specified source retention lease does not exist
    /**
     * Returns whether the replication tracker has relocated away to another shard copy.
     * Initiates a relocation handoff and returns the corresponding primary context.
                throw new RetentionLeaseNotFoundException(sourceLeaseId);
                        || isShardOnRemoteEnabledNode.apply(routingTable.getByAllocationId(allocationId).currentNodeId()))) {
     * Updates retention leases on a replica.
        this.onReplicationGroupUpdated = onReplicationGroupUpdated;
        public String toString() {
                                + " for "
     *
        // reapply missed cluster state update
    RetentionLease cloneRetentionLease(String sourceLeaseId, String targetLeaseId, ActionListener<ReplicationResponse> listener) {
    private volatile long operationPrimaryTerm;
        final ActionListener<ReplicationResponse> listener
            synchronized (this) {
                );
     * @param source                  the source of the retention lease
     * Returns the current replication group for the shard.
    /**
         */
                + "]";
        if (primaryContext.checkpoints.containsKey(shardAllocationId) == false) {
        if (newGlobalCheckpoint > previousGlobalCheckpoint) {
 * have received all old operations via the recovery mechanism and are kept up to date by the various replications actions. The set of
     * Flag to indicate whether {@link ReplicationTracker#createMissingPeerRecoveryRetentionLeases(ActionListener)}
                        final long newRetainedSequenceNumber = Math.max(0L, checkpointState.globalCheckpoint + 1L);
    public List<RetentionLease> getPeerRecoveryRetentionLeases() {
        assert primaryMode;
        // Deliberately keyed off the remote translog rather than the remote segment store: a shard whose translog is
            final long previousGlobalCheckpoint = cps.globalCheckpoint;
    }
        final String source,
 * software distributed under the License is distributed on an
        assert !primaryMode || globalCheckpoint <= inSyncCheckpointStates(checkpoints, CheckpointState::getLocalCheckpoint, LongStream::min)
         * If any of the peer-recovery retention leases need renewal, it's a good opportunity to renew them all.
            : "global checkpoint ["
    public synchronized Set<SegmentReplicationShardStats> getSegmentReplicationStats() {
import org.opensearch.indices.replication.common.SegmentReplicationLagTimer;
    /**
            listener.onResponse(null);
    /**
    public synchronized RetentionLease renewRetentionLease(final String id, final long retainingSequenceNumber, final String source) {
import org.opensearch.index.store.StoreFileMetadata;
        assert invariant();
                "updated local knowledge for [{}] on the primary of the visible checkpoint from [{}] to [{}], active timers {}",
                    final SegmentReplicationLagTimer timer = entry.getValue();
        checkpoints.entrySet()
                    } else {
    public static String getPeerRecoveryRetentionLeaseId(ShardRouting shardRouting) {
    }
     * Adds a new retention lease, but does not synchronise it with the rest of the replication group.
                                + retentionLease
        }
                 */
 * under the License.
                            "updated last published checkpoint for {} at visible cp {} to {} - timers [{}]",
     * @throws RetentionLeaseAlreadyExistsException if the specified target retention lease already exists
        public IndexShardRoutingTable getRoutingTable() {
        assert handoffInProgress == false;
     * Notify all threads waiting on the monitor on this tracker. These threads should be waiting for the local checkpoint on a specific
                    final long globalCheckpoint = localCheckpoint;
                                PEER_RECOVERY_RETENTION_LEASE_SOURCE
                + "] "
         */
        );
                + checkpoints
    }
                        break;
    *
                    assert PEER_RECOVERY_RETENTION_LEASE_SOURCE.equals(
                        waitForLocalCheckpointToAdvance();
    }
        final long currentTimeMillis = currentTimeMillisSupplier.getAsLong();
    private final Object retentionLeasePersistenceLock = new Object();
        assert primaryMode == false;
        }
            CheckpointState that = (CheckpointState) o;
        this.handoffInProgress = false;
        // initializeWithPrimaryContext, we might still have missed a cluster state update. This is best effort.
    public synchronized void activateWithPrimaryContext(PrimaryContext primaryContext) {
     * containing the persistent node ID calculated by {@link ReplicationTracker#getPeerRecoveryRetentionLeaseId}, and retain operations
                        : "no retention lease for tracked shard [" + shardRouting + "] in " + retentionLeases;
         */
                + " but was: "
    /**
        if (existingRetentionLease == null) {
                    }
                     * create peer recovery retention leases for every shard copy.
    long appliedClusterStateVersion;
            final ShardRouting primary = routingTable.primaryShard();
     * After a new checkpoint is published, create a timer for each replica to the checkpoint.
        boolean inSync;
     * the currently known one, this is a no-op. If the allocation ID is not tracked, it is ignored.
    */
    /**
            }
        return globalCheckpoint;
     * @throws RetentionLeaseAlreadyExistsException if the specified retention lease already exists
            logger.trace("marked [{}] as in-sync", allocationId);
        }
    /**
         * Whether the replication requests to the primary are replicated to the concerned shard or not.
                + globalCheckpoint
         * whether this shard is tracked in the replication group and has localTranslog, i.e., should receive document updates
    volatile long globalCheckpoint;
     * Marks a relocation handoff attempt as successful. Moves the tracker into replica mode.
        // retained by the source lease; however we prefer to sync anyway since we expect to do so whenever creating a new lease.
                updateGlobalCheckpointOnPrimary();
        assert routingTable == null || checkpoints.keySet().containsAll(routingTable.getAllAllocationIds()) : "local checkpoints "
    private long getMinimumReasonableRetainedSeqNo() {
                        || checkpoints.get(shardRouting.allocationId().getId()).tracked == false
        return checkpoints.get(allocationId);
     * @param localCheckpoint the current local checkpoint on the shard
     * Initializes the global checkpoint tracker in primary mode (see {@link #primaryMode}. Called on primary activation or promotion.
                            false,
    public static class CheckpointState implements Writeable {
            .filter(r -> r.isSearchOnly() == false)
                .stream()
        // the current shard is marked as in-sync when the global checkpoint tracker operates in primary mode
                ? cps.checkpointTimers.values().stream().mapToLong(SegmentReplicationLagTimer::totalElapsedTime).max().orElse(0)
    /**
    }
        hasAllPeerRecoveryRetentionLeases = false;
            : "cached replication group out of sync: expected: " + calculateReplicationGroup() + " but was: " + replicationGroup;
        assert localCheckpoint >= SequenceNumbers.NO_OPS_PERFORMED : "expected known local checkpoint for "
        }
            logger.trace("createMissingPeerRecoveryRetentionLeases: nothing to do");
                : null;
     */
        );
    }
        }
        retentionLeases = new RetentionLeases(
        assert primaryMode;
        // relocation handoff can only occur in primary mode
        } else {
                    // Although this index is old enough not to have all the expected peer recovery retention leases, in fact it does, so we
     * earlier version if we recently did a rolling upgrade and
        }
                return result;
     * <p>
    }
        synchronized (this) {
                .collect(Collectors.toSet());
 * You may obtain a copy of the License at
            if (this == o) return true;
        assert invariant();
     * Returns the current operation primary term.
        final RetentionLease retentionLease;
                        */
import java.util.function.Supplier;
    /**
    }
        retentionLeases = new RetentionLeases(operationPrimaryTerm, retentionLeases.version() + 1, nonExpiredLeases);
 * not use this file except in compliance with the License.
                - This shard's allocation id
            || replicationGroup.getReplicationTargets()
                                assignedToRemoteStoreNode(routingTable, initializingId)
        });
                    if (allShardsStarted) {
                            isReplicated(
        final long minimumReasonableRetainedSeqNo = allShardsStarted ? 0L : getMinimumReasonableRetainedSeqNo();
            leaseIdsForCurrentPeers = Collections.singleton(getPeerRecoveryRetentionLeaseId(routingTable.primaryShard().currentNodeId()));
    }
                        logger.trace("expiring unused [{}]", lease);
import org.opensearch.core.action.ActionListener;
            final AtomicLong lastFinished = new AtomicLong(0L);
        final LongConsumer onGlobalCheckpointUpdated,
        relocated = true;
     * @param id       the identifier of the retention lease
        this.operationPrimaryTerm = operationPrimaryTerm;
        assert !cps.inSync || cps.localCheckpoint >= getGlobalCheckpoint() || cps.replicated == false : "shard copy "
                final RetentionLease retentionLease = retentionLeases.get(getPeerRecoveryRetentionLeaseId(shardRouting));
        String allocationId,
        }
    ) {
import java.util.Map;
            out.writeZLong(globalCheckpoint);
    private final Function<String, Boolean> isShardOnRemoteEnabledNode;
        @Override
    boolean handoffInProgress;
         */
                retentionLeases.leases().stream().filter(lease -> lease.id().equals(id) == false).collect(Collectors.toList())
            this.checkpointTimers = ConcurrentCollections.newConcurrentMap();
        Objects.requireNonNull(listener);
     * @param primaryContext the primary context used to initialize the state
    /**
                    + " that have no matching entries in "
        if (retentionLeases.get(leaseId) == null) {
                        assert inSync == false : "update from cluster-manager in primary mode has "
            source
                            isReplicated(
         */
     * @return the renewed retention lease
     * @param allocationId    the allocation ID of the shard to mark as in-sync
        }
        // stuck from advancing
     *
     * @throws RetentionLeaseNotFoundException              if the specified retention lease does not exist
            + replicationGroup;
            () -> new ParameterizedMessage(
     * @return the new retention lease
        assert invariant();
        final Collection<CheckpointState> localCheckpoints,
         * persisted and the resulting IO can be expensive on nodes with large numbers of shards (see #42299). We choose to renew them after
        );
        }
     * @param checkpoint {@link ReplicationCheckpoint}
        // would be cleaned up on the target by cluster state updates.
        return "peer_recovery/" + nodeId;
     */
            + "] is lower than previous one ["
        @Override
    private volatile ReplicationCheckpoint latestReplicationCheckpoint;
     * @param id                      the identifier of the retention lease
     */
                                initializingId,
import java.util.function.ToLongFunction;
     * The current operation primary term. Management of this value is done through {@link IndexShard} and must only be done when safe. See
     * @param operationPrimaryTerm      the current primary term
            result = 31 * result + checkpoints.hashCode();
                            // global checkpoints from our peers.
     * has been run successfully
                    timer.stop();
            .collect(Collectors.groupingBy(lease -> {
    public static String getPeerRecoveryRetentionLeaseId(String nodeId) {
                }
    }
            return routingTable.equals(that.routingTable);
     * as a logical operator, many of the invariants are written under the form (!A || B), they should be read as (A implies B) however.
        // all the entries from checkpoints that are inSync: the reason we don't need to care about initializing non-insync entries
                        - Vanilla segrep is not enabled
                                inSync,
 * SPDX-License-Identifier: Apache-2.0
    public synchronized Map<String, Long> getInSyncGlobalCheckpoints() {
    final Map<String, CheckpointState> checkpoints;
            if (in.getVersion().onOrAfter(Version.V_2_5_0)) {
        hasAllPeerRecoveryRetentionLeases = true;
                            latestReplicationCheckpoint,
     */
    private long persistedRetentionLeasesPrimaryTerm;
     * then switched to primary mode in the following three scenarios:
            getPeerRecoveryRetentionLeaseId(routingTable.primaryShard()),
                out.writeBoolean(replicated);
            return "LocalCheckpointState{"
                    final long globalCheckpoint = localCheckpoint;
        }
        assert !handoffInProgress || pendingInSync.isEmpty() : "entries blocking global checkpoint advancement during relocation handoff: "
        assert minLocalCheckpoint != Long.MAX_VALUE;
     */
    /**
    }
        CheckpointState cps = checkpoints.get(allocationId);
    volatile ReplicationGroup replicationGroup;
     * When a shard is initialized (be it a primary or replica), it initially operates in replica mode. The global checkpoint tracker is
                    if (lease.retainingSequenceNumber() < minimumReasonableRetainedSeqNo) {
     *
    /**
    /**
        }
     */
                            globalCheckpoint,
        return value.isPresent() ? value.getAsLong() : SequenceNumbers.UNASSIGNED_SEQ_NO;
            if (getRetentionLeases().contains(sourceLeaseId) == false) {
            cps.lastCompletedReplicationLag
        return indexSettings().isRemoteTranslogStoreEnabled()
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
         */
        cps.tracked = true;
     * V2 - Set of {@link SegmentReplicationShardStats} per shard in this primary's replication group.
     * Whether the are shards blocking global checkpoint advancement.
     * {@link #startRelocationHandoff(String)} and is finished by either calling {@link #completeRelocationHandoff} or
                + "]";
        /*
            Stream.concat(retentionLeases.leases().stream(), Stream.of(retentionLease)).collect(Collectors.toList())
     * @return the replication mode.
        onReplicationGroupUpdated.accept(newReplicationGroup);
            + pendingInSync;
        }
        assert primaryMode : id + "/" + retainingSequenceNumber + "/" + source;
        assert Thread.holdsLock(this);
            .stream()
        this.appliedClusterStateVersion = -1L;
     *   the shard becomes active.
                    if (retentionLease != null) {
            + routingTable
            }
            clusterStateVersion = in.readVLong();
     * leases.
            checkpoints.put(entry.getKey(), entry.getValue().copy());
    public synchronized CheckpointState getTrackedLocalCheckpointForShard(String allocationId) {
                                && isShardOnRemoteEnabledNode.apply(routingTable.getByAllocationId(entry.getKey()).currentNodeId())))
            // stop any timers for checkpoints up to the received cp and remove from cps.checkpointTimers.
            if (primaryMode) {
    @PublicApi(since = "1.0.0")
            );
            logger.trace(
                    + " vs "
            }
        updateReplicationGroupAndNotify();
        if (replicationGroup == null) {
        final RetentionLease retentionLease = new RetentionLease(
        final CheckpointState cps = checkpoints.get(allocationId);
 *
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        }
        if (expiredLeases == null) {
                            localCheckpoint,
        if (primaryMode) {
            globalCheckpoint = computedGlobalCheckpoint;
        CheckpointState cps = checkpoints.get(allocationId);
 * The global checkpoint is maintained by the primary shard and is replicated to all the replicas (via {@link GlobalCheckpointSyncAction}).
        assert !handoffInProgress || primaryMode;
    private final LongSupplier currentTimeMillisSupplier;
                            // we are in the process of recovering it again, or maybe we were just promoted and have not yet received the
                + existingRetentionLease
        /**
        }
     * @param onReplicationGroupUpdated a callback when the replica group changes
        @Override
        assert invariant();
        }
    }
     * @throws InterruptedException if this thread was interrupted before of during waiting
            return new CheckpointState(localCheckpoint, globalCheckpoint, inSync, tracked, replicated);
                + " when activating primary";
            logger.trace("updated global checkpoint from [{}] to [{}] due to [{}]", previousGlobalCheckpoint, globalCheckpoint, reason);
    private final double fileBasedRecoveryThreshold;
        final Map<String, CheckpointState> checkpoints,
        return retentionLease;
     * The primary term of the most-recently persisted retention leases. This is used to check if we need to persist the current retention
            this.localCheckpoint = localCheckpoint;
                }
     * Initialize the global checkpoint service. The specified global checkpoint should be set to the last known global checkpoint, or
import org.apache.logging.log4j.message.ParameterizedMessage;
            bytesBehind > 0L
                     */
                assert primaryShard.allocationId().getId().equals(shardAllocationId) : routingTable.assignedShards()
    public synchronized void abortRelocationHandoff() {
    }
                        || hasAllPeerRecoveryRetentionLeases == false;
        if (cps == null) {
    public static final String PEER_RECOVERY_RETENTION_LEASE_SOURCE = "peer recovery";
            logger.trace("marked [{}] as in-sync", allocationId);
        assert primaryMode;
     * Create any required peer-recovery retention leases that do not currently exist. This can happen if either:
     */
        final Consumer<ReplicationGroup> onReplicationGroupUpdated,
        assert primaryMode;
    public synchronized void setLatestReplicationCheckpoint(ReplicationCheckpoint checkpoint) {
        return primaryMode;
                + shardAllocationId
     * Marks the shard with the provided allocation ID as in-sync with the primary shard. This method will block until the local checkpoint
        );
                    leaseId,
                + "more than in-sync local checkpoints ["
        );
 * this file be licensed under the Apache-2.0 license or a
                + "for primary mode allocation ID ["
                        try {
                currentRetentionLeases = retentionLeases;
            return true;
        assert primaryMode;
    }
    private long persistedRetentionLeasesVersion;
                )
            } else {
     * @param shardId                   the shard ID
        final BiConsumer<RetentionLeases, ActionListener<ReplicationResponse>> onSyncRetentionLeases,
        }
     */
    public synchronized void startReplicationLagTimers(ReplicationCheckpoint checkpoint) {
        }
                /*
        // if it was already in-sync (because of a previously failed recovery attempt), global checkpoint must have been
    /**
        assert primaryMode || checkpoints.values().stream().allMatch(cps -> cps.globalCheckpoint == SequenceNumbers.UNASSIGNED_SEQ_NO);
                                inSyncId,
                        all the other shard copies of the same index still hasn't completely moved over
                        && (indexSettings.isRemoteStoreEnabled()
        this.shardAllocationId = allocationId;
        Objects.requireNonNull(listener);
    /**
     * - primary: this shard is in charge of collecting local checkpoint information from all shard copies and computing the global
     * {@link #setOperationPrimaryTerm(long)}.
            + " but was "
                .map(entry -> buildShardStats(entry.getKey(), entry.getValue()))
     * Notifies the service to update the local checkpoint for the shard with the provided allocation ID. If the checkpoint is lower than
        assert replicationGroup == null || replicationGroup.equals(calculateReplicationGroup())
    /**
                        )
            cps.localCheckpoint = localCheckpoint;
            globalCheckpoint + 1,
                    groupedActionListener.onResponse(null);
        assert newVersion == 0 || indexSettings.isRemoteTranslogStoreEnabled()
        if (primaryMode) {
    /**
                    && cps.checkpointTimers.get(latestReplicationCheckpoint).startTime() == 0) {
            if (localCheckpoint != that.localCheckpoint) return false;
            && indexSettings.getIndexMetadata().getState() == IndexMetadata.State.OPEN;
            out.writeBoolean(tracked);
        } else {
    private boolean hasAllPeerRecoveryRetentionLeases;
     * @param allocationId              given allocation id
        );
     * and / or in-sync, possibly also containing information about unassigned in-sync shard copies. The information that is tracked for
     * Update the local knowledge of the persisted global checkpoint for the specified allocation ID.
        assert handoffInProgress == false;
            currentTimeMillisSupplier.getAsLong(),
            if (this == o) return true;
 * Licensed to Elasticsearch under one or more contributor
    }
     */
     */
        public boolean equals(Object o) {
            + " and replication group is "
                + retainingSequenceNumber
        if (applyingClusterStateVersion > appliedClusterStateVersion) {
        );
     */
            throw new RetentionLeaseInvalidRetainingSeqNoException(id, source, retainingSequenceNumber, existingRetentionLease);
    /**
     */
        }
import org.opensearch.index.IndexSettings;
            onGlobalCheckpointUpdated.accept(computedGlobalCheckpoint);
     *
    }
    IndexShardRoutingTable routingTable;
        final RetentionLease existingRetentionLease = retentionLeases.get(id);
            + computedGlobalCheckpoint
     * checkpoint, and renew any leases that are approaching expiry.
    }
        assert primaryMode == false;
                    // don't need to do any more work.
    ) {
     * - An active replica shard is moved to primary mode (using {@link #activatePrimaryMode}) once it is promoted to primary.
        Objects.requireNonNull(listener);
        // all assigned shards from the routing table are tracked
        final boolean renewalNeeded = StreamSupport.stream(routingTable.spliterator(), false)
        if (checkpoint.equals(latestReplicationCheckpoint) == false) {
        public long getGlobalCheckpoint() {
            .stream()
                                shardRouting.currentNodeId(),
        return replicationGroup;
     */
        for (Map.Entry<String, CheckpointState> entry : checkpoints.entrySet()) {
                    if (checkpointState.tracked == false) {
        final BiConsumer<RetentionLeases, ActionListener<ReplicationResponse>> onSyncRetentionLeases,
            + replicationGroup;
                + routingTable
 * This class is responsible for tracking the replication group with its progress and safety markers (local and global checkpoints).
                + "] "
     * @param source                  the source of the retention lease
                if (lease.source().equals(PEER_RECOVERY_RETENTION_LEASE_SOURCE)) {
                + " blocks global checkpoint advancement but is in-sync";
    /**
                cps.checkpointTimers.keySet()
    private RetentionLeases retentionLeases = RetentionLeases.EMPTY;
    public synchronized void createMissingPeerRecoveryRetentionLeases(ActionListener<Void> listener) {
                + checkpoints
            updateGlobalCheckpointOnPrimary();
        @Override
    /**
     * on the specified shard advances above the current global checkpoint.
        assert pendingInSync.contains(allocationId) == false : "shard copy " + allocationId + " is already marked as pending in-sync";
            PrimaryContext that = (PrimaryContext) o;
                }
        }
                        inSyncId,
                    return false;
        }
     */
     * @return the primary term
            pending = false;
         * from the primary. Tracked shards with localTranslog would have corresponding retention leases on the primary shard's
            routingTable = IndexShardRoutingTable.Builder.readFrom(in);
        final LongSupplier currentTimeMillisSupplier,
        if (cps == null) {
    private ReplicationGroup calculateReplicationGroup() {
     *
     * until the newer cluster state were to be applied, which would unsafely advance the global checkpoint. This field thus captures
         * {@link ReplicationTracker}.
     * @return the replication group
        return true;
                 * leases for every shard copy, but in this case we do not expect any leases to exist.
            result = 31 * result + routingTable.hashCode();
                }
                + "clusterStateVersion="
     * @param allocationId     the allocation ID to update the global checkpoint for
                            allocationId,
            : Collections.emptyList();
    }
    }
            ? partitionByExpiration.get(false)
    }
                                getPeerRecoveryRetentionLeaseId(shardRouting),
        this.hasAllPeerRecoveryRetentionLeases = indexSettings.isSoftDeleteEnabled()
            if (cps.inSync && cps.replicated) {
                        + "] for ["
        // a local checkpoint for a shard copy should be a valid sequence number
            + " or it's not replicated";
                            cps.visibleReplicationCheckpoint,
        assert invariant();
            if (tracked != that.tracked) return false;
            throw new IllegalStateException("primary context [" + primaryContext + "] does not contain " + shardAllocationId);
    }
    /**
    /**
        public Map<String, CheckpointState> getCheckpointStates() {
                        groupedActionListener.onResponse(null);
                throw new RetentionLeaseNotFoundException(id);
            checkpoints.values()
            id,
        }
        * the last local checkpoint information that we have for this shard. All operations up to this point are properly fsynced to disk.
                .removeIf(aid -> !inSyncAllocationIds.contains(aid) && !initializingAllocationIds.contains(aid));
                /* Filter out:
        assert invariant();
            updateReplicationGroupAndNotify();
                            true,
                        - Remote Store settings are not enabled (This would be done after all shard copies migrate to remote enabled nodes)
    public RetentionLease addRetentionLease(
     */
        return getRetentionLeases().leases()
                    && (indexSettings.isSegRepLocalEnabled() == true
        assert primaryMode == false;
    * The state of the lucene checkpoint
                if (removedEntries) {
            routingTable,
     */
    private final Consumer<ReplicationGroup> onReplicationGroupUpdated;
        this.currentTimeMillisSupplier = Objects.requireNonNull(currentTimeMillisSupplier);
        if (assignedToRemoteStoreNode == true) {
        return safeCommitInfo.localCheckpoint + 1 - Math.round(Math.ceil(safeCommitInfo.docCount * fileBasedRecoveryThreshold));
    /**
            listener
        assert pendingInSync.isEmpty() || (primaryMode && !handoffInProgress);
                hasAllPeerRecoveryRetentionLeases = true;
            source
    private static long computeGlobalCheckpoint(
            );
                    checkpoints.put(
            operationPrimaryTerm,
        Map<ReplicationCheckpoint, SegmentReplicationLagTimer> checkpointTimers;
        this.latestReplicationCheckpoint = indexSettings.isSegRepEnabledOrRemoteNode() ? ReplicationCheckpoint.empty(shardId) : null;
     * @param path the path to the directory containing the state file
                 */
    }
    }
     * <p>
                operationPrimaryTerm,
            }));
        assert primaryMode;
            .stream()
     */
                }
     * If the expire leases parameter is false, gets all retention leases tracked on this shard and otherwise first calculates
        synchronized (this) {
            retentionLeases.version() + 1,
                .stream()
        updateGlobalCheckpointOnPrimary();
                        initializingId,
     */
            + " that's above the global checkpoint "
        for (Map.Entry<String, CheckpointState> entry : checkpoints.entrySet()) {
            bytesBehind > 0L ? cps.checkpointTimers.values().stream().mapToLong(SegmentReplicationLagTimer::time).max().orElse(0) : 0,
        }
    }
        assert !primaryMode
        synchronized (retentionLeasePersistenceLock) {
     * @param retentionLeases the retention leases
                globalCheckpoint
            if (clusterStateVersion != that.clusterStateVersion) return false;
    }
    public long getGlobalCheckpoint() {
            return "PrimaryContext{"
            createReplicationLagTimers();
                .filter(cps -> cps.inSync && cps.replicated)
     * to change from false to true; can be removed once support for pre-PRRL indices is no longer needed.
        removeRetentionLease(getPeerRecoveryRetentionLeaseId(nodeId), listener);
            assert primaryMode;
                        } else {
        this.replicationGroup = null;
                } else {
                     * If this shard copy is tracked then we got here here via a rolling upgrade from an older version that doesn't
                    }
     * @param checkpoint {@link ReplicationCheckpoint}
                if (result) {
import java.util.stream.LongStream;
        }
     * @return the retention leases
        final ShardId shardId,
                    );
        return hasAllPeerRecoveryRetentionLeases;
    }
        final Collection<RetentionLease> nonExpiredLeases = partitionByExpiration.get(false) != null
        return this.latestReplicationCheckpoint;
     */
                    checkpoints.put(
import org.opensearch.cluster.routing.ShardRouting;
     * Computes the global checkpoint based on the given local checkpoints. In case where there are entries preventing the
        assert invariant();
        }
                    cps.checkpointTimers.get(latestReplicationCheckpoint).start();
    /**
         */
    private synchronized void waitForLocalCheckpointToAdvance() throws InterruptedException {
    ) {
        final IndexShardRoutingTable routingTable
                if (cps.inSync
     * Id for a peer recovery retention lease for the given node. See {@link ReplicationTracker#addPeerRecoveryRetentionLease}.
                            + " as in-sync but it does not exist locally";
            assert PEER_RECOVERY_RETENTION_LEASE_SOURCE.equals(source) == false : "renewing peer recovery retention lease ["
            + "] for shard copy ["
        public PrimaryContext(StreamInput in) throws IOException {
            retentionLease = innerAddRetentionLease(targetLeaseId, sourceLease.retainingSequenceNumber(), sourceLease.source());
        assert primaryMode;
        routingTable = primaryContext.getRoutingTable();
                        + shardRouting
            int result = Long.hashCode(localCheckpoint);
    /**
    final String shardAllocationId;
    /**
     * This method will also stop timers for each shard and compute replication lag metrics.
import org.opensearch.common.annotation.PublicApi;
                            assert checkpointState.globalCheckpoint == SequenceNumbers.UNASSIGNED_SEQ_NO : "cannot renew "
                    && replicationGroup.getUnavailableInSyncShards().contains(allocationId) == false
     * - An initializing primary shard that is not a relocation target is moved to primary mode (using {@link #activatePrimaryMode}) once
                    final CheckpointState checkpointState = checkpoints.get(shardRouting.allocationId().getId());
                .collect(Collectors.toList());
        for (String aId : pendingInSync) {
    }
            assert !primaryMode
 * the Apache License, Version 2.0 (the "License"); you may
                            );
     * A callback invoked when the in-memory global checkpoint is updated. For primary mode this occurs if the computed global checkpoint
        );
     */
                        + retentionLeases.get(getPeerRecoveryRetentionLeaseId(shardRouting)).source()
import org.opensearch.common.SuppressForbidden;
import java.util.function.BiConsumer;
                .stream()
            // Compute the max lag from the set of completed timers.
            this.localCheckpoint = in.readZLong();
            }
            cps.globalCheckpoint = SequenceNumbers.UNASSIGNED_SEQ_NO;
        primaryMode = false;
        assert Version.V_EMPTY.equals(indexSettings.getIndexVersionCreated()) == false;
        // This is required since during an ongoing remote store migration,
                    Math.max(0L, checkpoints.get(shardAllocationId).globalCheckpoint + 1),
                String allocationId = e.getKey();
import org.opensearch.index.shard.AbstractIndexShardComponent;
     * Renews an existing retention lease.
     */
    public long getOperationPrimaryTerm() {
            out.writeZLong(localCheckpoint);
        // global checkpoints only set during primary mode
    /**
                                localCheckpoint,
        return Collections.emptySet();
        }
    /**
            if (inSync != that.inSync) return false;
        Function<LongStream, OptionalLong> reducer
                for (String initializingId : initializingAllocationIds) {
            if (o == null || getClass() != o.getClass()) return false;
            }, listener::onFailure), shardRoutings.size());
        final String leaseId = getPeerRecoveryRetentionLeaseId(primaryShard);
                    lastFinished.set(Math.max(lastFinished.get(), timer.totalElapsedTime()));
            }
        // only stored locally still needs to take part in replication for its operations to be durable.
 * The global checkpoint is the highest sequence number for which all lower (or equal) sequence number have been processed
        final Store.RecoveryDiff diff = Store.segmentReplicationDiff(
            assert checkpoints.get(aId) != null : "aId [" + aId + "] is pending in sync but isn't tracked";
        ReplicationGroup newReplicationGroup = calculateReplicationGroup();
        assert invariant();
        /**
     * @param reason              the reason the global checkpoint was updated
     *
            + getGlobalCheckpoint()
            + " that's already in-sync should have a local checkpoint "
        );
            this.routingTable = routingTable;
import org.opensearch.index.engine.SafeCommitInfo;
import org.opensearch.core.common.io.stream.StreamInput;
                            // the retention lease is tied to the node, not the shard copy, so it's possible a copy was removed and now
                                inSync,
                .filter(shardRouting -> shardRouting.isSearchOnly() == false)
        if (cps == null) {
     * Returns a list of peer recovery retention leases installed in this replication group
     * @param routingTable                the shard routing table
            result = 31 * result + Boolean.hashCode(tracked);
import org.opensearch.cluster.routing.AllocationId;
            operationPrimaryTerm,
                previousGlobalCheckpoint,
     * @param globalCheckpoint the global checkpoint
     */
            }
import org.opensearch.cluster.metadata.IndexMetadata;
                - Any non-active shards which are still recovering.
        // No-Op if retention leases for the tracked shard copy already exists
    /**
                        logger.trace("createMissingPeerRecoveryRetentionLeases: adding missing lease for {}", shardRouting);
        // For other case which is local translog, return true as the requests are replicated to all shards in the replication group.
     * in-sync shard copies cannot grow, otherwise the relocation target might miss this information and increase the global checkpoint
        }
                                + checkpointState
                .anyMatch(shardRouting -> isShardOnRemoteEnabledNode.apply(shardRouting.currentNodeId()))
        for (Map.Entry<String, CheckpointState> entry : checkpoints.entrySet()) {
     * This means, however, that the global checkpoint can still advance after the primary relocation handoff has been initiated, but only
        return Tuple.tuple(true, retentionLeases);
        logger.debug("expiring retention leases [{}] from current retention leases [{}]", expiredLeases, retentionLeases);
    /**
                .map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
        assert !this.shardAllocationId.equals(allocationId);
                        && checkpoints.get(shardRouting.allocationId().getId()).replicated == false)
                        /*Check if the current primary shard is migrating to remote and
     */
     * Fails a relocation handoff attempt.
        final CheckpointState cps = checkpoints.get(allocationId);
     * @param listener      the callback when the retention lease is successfully added and synced to replicas
    volatile boolean primaryMode;
     * objective to transfer the internal state of the global checkpoint tracker from the relocation source to the target, the list of
import java.util.Collections;
 *
     * current global checkpoint.
            // all tracked shard copies have a corresponding peer-recovery retention lease
        }
    }
            shardId,
                                globalCheckpoint,
            + " but replication group is "
    }
                + '}';
        this.routingTable = null;
     * leases.
     */
    /**
            this.inSync = inSync;
    }
        // Ignore if the cps is null (i.e. replica shard not in active state).
        /*
        @Override
        }
 * license agreements. See the NOTICE file distributed with
     *
        assert invariant();
            currentTimeMillisSupplier.getAsLong(),
    /**
        }
     * context from the primary relocation source to the target and initializing the target, it is possible for the target to apply a
        }
                + tracked
            // in-sync shard copies are tracked
    }
            // can happen if replica was removed from cluster but recovery process is unaware of it yet
            Stream.concat(retentionLeases.leases().stream().filter(lease -> lease.id().equals(id) == false), Stream.of(retentionLease))
        long localCheckpoint;
     * each shard copy is explained in the docs for the {@link CheckpointState} class.
            checkpoints.entrySet().stream().filter(e -> e.getValue().inSync).map(Map.Entry::getKey).collect(Collectors.toSet()),
            + checkpoints
            newVersion = 0;
            retainingSequenceNumber,
    /**
        assert invariant();
     * {@link SequenceNumbers#UNASSIGNED_SEQ_NO}.
            logger.debug("removing retention lease [{}] from current retention leases [{}]", id, retentionLeases);
    /**
            checkpoints.entrySet().stream().filter(e -> e.getValue().tracked).map(Map.Entry::getKey).collect(Collectors.toSet()),
        return relocated;
         */
    private boolean invariant() {
    }
        if (cps == null) {
                                + shardRouting;
                    ) : "incorrect source ["
            return globalCheckpoint;
    public synchronized void updateVisibleCheckpointForShard(final String allocationId, final ReplicationCheckpoint visibleCheckpoint) {
            return checkpoints;
    }
                    + shardAllocationId;
    private synchronized void setHasAllPeerRecoveryRetentionLeases() {
        }
     * Supplies information about the current safe commit which may be used to expire peer-recovery retention leases.
    }
            // remove entries which don't exist on cluster-manager
        final long computedGlobalCheckpoint = computeGlobalCheckpoint(pendingInSync, checkpoints.values(), getGlobalCheckpoint());
            if (allocationId.equals(this.shardAllocationId) == false) {
            this.globalCheckpoint = globalCheckpoint;
import org.opensearch.core.common.io.stream.Writeable;
         * The global checkpoint here is a local knowledge which is updated under the mandate of the primary. It can happen that the primary
     *
import org.opensearch.index.SegmentReplicationShardStats;
     */
 */
    }
        this.checkpoints = new HashMap<>(1 + indexSettings.getNumberOfReplicas());
                allocationId,
        public long clusterStateVersion() {
            }
        return retentionLeases;
    /**
        if (renewalNeeded) {
            boolean removedEntries = checkpoints.keySet()
            logger.debug("no retention leases are expired from current retention leases [{}]", retentionLeases);
    public synchronized void updateRetentionLeasesOnReplica(final RetentionLeases retentionLeases) {
    /**
         */
            retentionLeases.version() + 1,
            assert primaryMode;
            id,
        assert invariant();
            assert !pendingInSync.contains(entry.getKey()) || !entry.getValue().inSync : "shard copy "
                    + checkpoints;
                .mapToLong(function)
    /**
    public synchronized void updateGlobalCheckpointForShard(final String allocationId, final long globalCheckpoint) {
        return globalCheckpoints;
    /**
            cps.visibleReplicationCheckpoint != null ? cps.visibleReplicationCheckpoint.getMetadataMap() : Collections.emptyMap()
     * advances due to an update from the primary.
            // can happen if replica was removed from cluster but replication process is unaware of it yet
     * The allocation ID for the shard to which this tracker is a component of.
            return Tuple.tuple(false, retentionLeases);
            assert !entry.getValue().inSync || entry.getValue().tracked : "shard copy " + entry.getKey() + " is in-sync but not tracked";
                        logger.trace("expiring unreasonable [{}] retaining history before [{}]", lease, minimumReasonableRetainedSeqNo);
            out.writeVLong(clusterStateVersion);
     * with sequence numbers strictly greater than the given global checkpoint.
     */
                                primaryAllocationId,
        assert !relocated || !primaryMode;
        assert handoffInProgress == false;
        }
                    if (pendingInSync.contains(allocationId)) {
                if (cps.inSync
        }
import java.util.function.LongConsumer;
        final LongConsumer onGlobalCheckpointUpdated,
        final Map<Boolean, List<RetentionLease>> partitionByExpiration = retentionLeases.leases()
    public synchronized void updateFromClusterManager(
            if (o == null || getClass() != o.getClass()) return false;
                pendingInSync.remove(allocationId);
            // can happen if replica was removed from cluster but recovery process is unaware of it yet
        final OptionalLong value = reducer.apply(
                return currentTimeMillis - lease.timestamp() > retentionLeaseMillis;
        this(
        @Override
                    }
     * @param newGlobalCheckpoint the new global checkpoint
    }
        // a relocated copy is not in primary mode
    }
                "updated local knowledge for [{}] on the primary of the global checkpoint from [{}] to [{}]",
            + routingTable
        boolean assignedToRemoteStoreNode
         * information is lagging compared to a replica (e.g., if a replica is promoted to primary but has stale info relative to other
            this.inSync = in.readBoolean();
    public boolean isPrimaryMode() {
                + ", checkpoints="
     *
    private void createReplicationLagTimers() {
                                assignedToRemoteStoreNode(routingTable, inSyncId)
/*
     */
     * expiration of existing retention leases, and then gets all non-expired retention leases tracked on this shard. Note that only the
     *
                        && replicationGroup.getUnavailableInSyncShards().contains(entry.getKey()) == false
                setHasAllPeerRecoveryRetentionLeases();
     * @param listener                the callback when the retention lease is successfully added and synced to replicas
 * The OpenSearch Contributors require contributions made to
        final IndexSettings indexSettings,
     */
                }
     * Get all retention leases tracked on this shard.
        synchronized (this) {
            out.writeMap(checkpoints, (streamOutput, s) -> out.writeString(s), (streamOutput, cps) -> cps.writeTo(out));
    }
            listener
     * Id for a peer recovery retention lease for the given {@link ShardRouting}.
                        final long globalCheckpoint = localCheckpoint;
        }
    volatile boolean relocated;
        long globalCheckpoint;
        assert invariant();
                    cps.checkpointTimers.computeIfAbsent(latestReplicationCheckpoint, ignored -> new SegmentReplicationLagTimer());
            this.clusterStateVersion = clusterStateVersion;
                    );
     */
        if (expireLeases == false) {
                    if (leaseIdsForCurrentPeers.contains(lease.id())) {
            pendingInSync.remove(allocationId);
        }
            bytesBehind,
            return result;
     * @throws IOException if an I/O exception occurs reading the retention leases
import java.util.Objects;
    /**
     */
 * them, and before this primary shard has been notified of this fact, we also include shards that have completed recovery. These shards
    private RetentionLease innerAddRetentionLease(String id, long retainingSequenceNumber, String source) {
        }
    public ReplicationCheckpoint getLatestReplicationCheckpoint() {
                if (retentionLeases.contains(getPeerRecoveryRetentionLeaseId(shardRouting))) {
    }
        return pendingInSync.isEmpty() == false;
         * the replica is caught up.
                        new CheckpointState(
        handoffInProgress = false;
import java.util.OptionalLong;
                        () -> new ParameterizedMessage(
                if (cps.tracked && cps.replicated) {
            Set<String> initializingAllocationIds = routingTable.getAllInitializingShards()
            allocationId,
            return result;
        assert localCheckpoint >= SequenceNumbers.NO_OPS_PERFORMED;
            + " not in-sync with routing table "
                }
            && replicationGroup.getReplicationTargets()
     * @param retainingSequenceNumber the retaining sequence number
        if (primaryMode && indexSettings.isSoftDeleteEnabled() && hasAllPeerRecoveryRetentionLeases
                        return true;
        // Skip assertion if createMissingPeerRecoveryRetentionLeases has not yet run after activating primary context
        final ShardId shardId,
        assert cps.tracked : "shard copy " + allocationId + " cannot be marked as in-sync as it's not tracked";
                            globalCheckpoint,
    /**
     */
                .stream()
     *            checkpoint based on the local checkpoints of all in-sync shard copies.
     * shard copy with local translog in the replication group. If one does not already exist and yet there are other
                        && shouldSkipReplicationLag(entry.getKey()) == false
            this.tracked = in.readBoolean();
    /**
        if (primaryMode) {
     * Update the local knowledge of the visible checkpoint for the specified allocation ID.
     * This set contains allocation IDs for which there is a thread actively waiting for the local checkpoint to advance to at least the
     * then persistence is skipped.
                    if (checkpoints.containsKey(initializingId) == false) {
            // check that the cluster-manager does not fabricate new in-sync entries out of thin air once we are in primary mode
     * expiration.
    private SegmentReplicationShardStats buildShardStats(final String allocationId, final CheckpointState cps) {
package org.opensearch.index.seqno;
    /**
                        - Index is assigned to remote node (Primary has been seeded) but the corresponding replication group entry has not yet moved to remote
     * @param allocationId  the allocation ID of the shard for which recovery was initiated
    ) {
        assert checkpoints.get(shardAllocationId) != null
                                    primaryTargetAllocationId,
    ) {
     * A notable exception to this is the method {@link #updateFromClusterManager}, which is still allowed to be called during a relocation handoff.
                }
     * The global checkpoint tracker relies on the property that cluster state updates are applied in-order. After transferring a primary
     */
        final Set<String> pendingInSync,
        if (cps.replicated && cps.localCheckpoint < getGlobalCheckpoint()) {
            retainingSequenceNumber,
            }
            result = 31 * result + Boolean.hashCode(inSync);
     * @param applyingClusterStateVersion the cluster state version being applied when updating the allocation IDs from the cluster-manager
        // Create missing RetentionLeases if the primary is on a remote enabled
        }
                    /*
     * @param visibleCheckpoint the visible checkpoint
        assert primaryMode;
        }
    private synchronized void updateGlobalCheckpointOnPrimary() {
     * Boolean flag that indicates whether a relocation handoff completed (see {@link #completeRelocationHandoff}).
     * @param allocationId              the allocation ID
     * information is conveyed through cluster state updates, and the new primary relocation target will also eventually learn about those.
        */
    public RetentionLease cloneLocalPeerRecoveryRetentionLease(String nodeId, ActionListener<ReplicationResponse> listener) {
        assert primaryMode == false;
            retentionLeases = new RetentionLeases(
            if (globalCheckpoint != that.globalCheckpoint) return false;
import org.opensearch.common.collect.Tuple;
    private final BiConsumer<RetentionLeases, ActionListener<ReplicationResponse>> onSyncRetentionLeases;
import java.util.function.Consumer;
    /**
    }
            this.latestReplicationCheckpoint = checkpoint;
        assert computedGlobalCheckpoint >= globalCheckpoint : "new global checkpoint ["
        final Set<String> inSyncAllocationIds,
     * Notifies the tracker of the current allocation IDs in the cluster state.
        assert invariant();
            for (ShardRouting shardRouting : shardRoutings) {
            final String primaryTargetAllocationId = primary.relocating()
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
    // A recovery target can be marked in-sync before its routing transitions from INITIALIZING to STARTED. Track replication lag
        return shardRouting != null && (shardRouting.active() == false || shardRouting.primary() || shardRouting.isSearchOnly());
        public int hashCode() {
                        }
     */
        appliedClusterStateVersion = primaryContext.clusterStateVersion();
                || routingTable.primaryShard().allocationId().getRelocationId().equals(shardAllocationId));
                    minLocalCheckpoint = Math.min(cps.localCheckpoint, minLocalCheckpoint);
        /**
    private boolean isReplicated(
                    assert retentionLeases.contains(getPeerRecoveryRetentionLeaseId(shardRouting))
        final Supplier<SafeCommitInfo> safeCommitInfoSupplier,
        return new PrimaryContext(appliedClusterStateVersion, localCheckpointsCopy, routingTable);
    * @opensearch.api
                boolean result = entry.getKey().isAheadOf(visibleCheckpoint) == false;
        // docs then safeCommitInfo.docCount counts every child doc separately from the parent doc. However every part of a nested document
    private void addPeerRecoveryRetentionLeaseForSolePrimary() {
import org.opensearch.index.shard.ReplicationGroup;
                // notify any waiter for local checkpoint advancement to recheck that their shard is still being tracked.
                }
            isShardOnRemoteEnabledNode
 * on all shards that are currently active. Since shards count as "active" when the cluster-manager starts
     * @throws RetentionLeaseInvalidRetainingSeqNoException if the new retaining sequence number is lower than
        // when in primary mode, the global checkpoint is at most the minimum local checkpoint on all in-sync shard copies
                .collect(Collectors.toSet());
/**
    }
    public synchronized void completeRelocationHandoff() {
        assert primaryMode;
        assert primaryMode == false;
                }
    /**
            checkpoints = in.readMap(StreamInput::readString, CheckpointState::new);
        }
        public CheckpointState(StreamInput in) throws IOException {
                }
        assert invariant();
        assert invariant();
            checkpoints.entrySet().stream().filter(e -> !e.getKey().equals(this.shardAllocationId)).forEach(e -> {
            updateGlobalCheckpointOnPrimary();
            return;
        final Runnable runAfter = getClusterManagerUpdateOperationFromCurrentState();
                                isReplicated(
            + "]";
     *
     * shard copies in this group then we must have just done a rolling upgrade from a version before {@code LegacyESVersion#V_7_4_0},
    /**
            .filter(lease -> PEER_RECOVERY_RETENTION_LEASE_SOURCE.equals(lease.source()))
                for (String initializingId : initializingAllocationIds) {
     * in which case the missing leases should be created asynchronously by the caller using
                    && cps.checkpointTimers.containsKey(latestReplicationCheckpoint)
            } else {
                                    assignedToRemoteStoreNode(routingTable, initializingId)
            appliedClusterStateVersion = applyingClusterStateVersion;
                    entry -> entry.getKey().equals(this.shardAllocationId) == false
 * this work for additional information regarding copyright
        logger.debug("adding new retention lease [{}] to current retention leases [{}]", retentionLease, retentionLeases);
        assert handoffInProgress == false;
                cps.localCheckpoint,
import org.opensearch.action.support.replication.ReplicationResponse;
        public CheckpointState(long localCheckpoint, long globalCheckpoint, boolean inSync, boolean tracked, boolean replicated) {
        return globalCheckpoint;
        updateLocalCheckpoint(shardAllocationId, checkpoints.get(shardAllocationId), localCheckpoint);
        final String allocationId,
     * @return {@link Tuple} V1 - TimeValue in ms - mean replication lag for this primary to its entire group,
     */
        boolean createMissingRetentionLeasesDuringMigration = indexSettings.isAssignedOnRemoteNode()
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            return false;
     *
 * ownership. Elasticsearch licenses this file to you under
     */
                .anyMatch(shardRouting -> isShardOnRemoteEnabledNode.apply(shardRouting.currentNodeId()) == false);
            safeCommitInfoSupplier,
    public synchronized PrimaryContext startRelocationHandoff(String targetAllocationId) {
        );
                    logger.trace(
            cps.checkpointTimers.entrySet().removeIf((entry) -> {
                + ", inSync="
        this.globalCheckpoint = globalCheckpoint;
                }
    public synchronized void resetHasAllPeerRecoveryRetentionLeases() {
        } else {
                ? primary.getTargetRelocatingShard().allocationId().getId()
            cps.inSync = true;
        public String toString() {
         * primary.
                inSyncAllocationIds.add(entry.getKey());
            );
     * - In a mixed mode cluster (during remote store migration), a remote enabled primary shard copy fails over to another remote enabled shard copy,
     */
                    final long localCheckpoint = SequenceNumbers.UNASSIGNED_SEQ_NO;
        return cloneRetentionLease(
        if (globalCheckpoint != computedGlobalCheckpoint) {
                            true,
     * @param primaryTargetAllocationId primary target allocation id
            // early out as no retention leases have expired
        Map<String, CheckpointState> localCheckpointsCopy = new HashMap<>();
     * but the replication group still has other shards in docrep nodes
         * half the expiry time, so that by default the cluster has at least 6 hours to recover before these leases start to expire.
        // therefore preferring ops-based recoveries inappropriately in this case. Correctly accounting for nested docs seems difficult to
        public void writeTo(StreamOutput out) throws IOException {
            }
    public synchronized boolean hasAllPeerRecoveryRetentionLeases() {
         * Returns a full copy of this object
                    );
        this.wait();
     */
                + ", tracked="
                + replicated
            return fallback;
         * contributes to global checkpoint calculation on the primary iff {@link CheckpointState#replicated} is true.
            return localCheckpoint;
                + globalCheckpoint
     * view of replication.
    private Runnable getClusterManagerUpdateOperationFromCurrentState() {
    }
    public synchronized void activatePrimaryMode(final long localCheckpoint) {
                    return;
 * shards that are taken into account for the global checkpoint calculation are called the "in-sync shards".
                        && entry.getValue().inSync
        checkpoints.clear();
            try {
                .filter(v -> v != SequenceNumbers.UNASSIGNED_SEQ_NO)
                final CheckpointState cps = entry.getValue();
        replicationGroup = newReplicationGroup;
        final String id,
     * Scans through the currently known local checkpoint and updates the global checkpoint accordingly.
                    final long localCheckpoint = SequenceNumbers.UNASSIGNED_SEQ_NO;
    /**
     * window between primary activation and async lease creation via ensurePeerRecoveryRetentionLeasesExist().
    }
                + computeGlobalCheckpoint(pendingInSync, checkpoints.values(), globalCheckpoint)
            cps.inSync = true;
    /**
     * @param allocationId    the allocation ID of the shard to update the local checkpoint for
        public int hashCode() {
     * Adds a new retention lease.
        // during relocation handoff there are no entries blocking global checkpoint advancement
        );
                .collect(Collectors.toList())
    private boolean createdMissingRetentionLeases;
    public boolean assertRetentionLeasesPersisted(final Path path) throws IOException {
        assert !primaryMode || (routingTable != null && replicationGroup != null) : "primary mode but routing table is "
     *
                            )
     * A callback when a new retention lease is created or an existing retention lease is removed. In practice, this callback invokes the
import java.util.HashSet;
            currentRetentionLeases = retentionLeases;
        updateReplicationGroupAndNotify();
        ToLongFunction<CheckpointState> function,
        if (cps.checkpointTimers.isEmpty() == false) {
                - (For remote store enabled clusters) Any shard that is not yet migrated to remote store enabled nodes during migration
        assert primaryMode;
                + "localCheckpoint="
            + localCheckpoint;
                + localCheckpoint
                : "update from cluster-manager in primary mode contains in-sync ids "
        this.notifyAll();
        assert Version.CURRENT.major <= 8 : "throw an exception instead of returning EMPTY on null";
                .collect(Collectors.toUnmodifiableSet());
            final RetentionLeases currentRetentionLeases;
                    && replicationGroup.getUnavailableInSyncShards().contains(allocationId) == false
        return new ReplicationGroup(
        // do cheaply, and the circumstances in which this matters should be relatively rare, so we use this naive calculation regardless.
            && createdMissingRetentionLeases) {
    public synchronized void updateLocalCheckpoint(final String allocationId, final long localCheckpoint) {
     * @param allocationId     the allocation ID to update the global checkpoint for
                + clusterStateVersion
     * Returns the in-memory global checkpoint for the shard.
        }
                // Safe to call innerAddRetentionLease() without a subsequent sync since there are no other members of this replication
        return new SegmentReplicationShardStats(
     */
                + ", routingTable="
            .filter(ShardRouting::assignedToNode)
            .anyMatch(shardRouting -> {
        if (retentionLeases.supersedes(this.retentionLeases)) {
        assert invariant();
    @PublicApi(since = "1.0.0")
                    return fallback;
     * shards and their local checkpoints.
import org.opensearch.core.common.io.stream.StreamOutput;
        this.safeCommitInfoSupplier = safeCommitInfoSupplier;
     * Returns the local checkpoint information tracked for a specific shard. Used by tests.
     * {@code LegacyESVersion#V_7_4_0} onwards, because these versions create PRRLs properly. May be false on indices created in an
        this.fileBasedRecoveryThreshold = IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.get(indexSettings.getSettings());
        return true;
    public ReplicationTracker(
                - Any shards that are out of sync or unavailable (shard marked in-sync but has not been assigned to a node).
 */
        assert !primaryMode || globalCheckpoint == computeGlobalCheckpoint(pendingInSync, checkpoints.values(), globalCheckpoint)
    /**
     * @param retainingSequenceNumber the retaining sequence number
        }
 *
                // Search replicas are assigned but never tracked by the primary, so they have no checkpoint state.
     *
        /**
        if (pendingInSync.isEmpty() == false) {
        assert !this.shardAllocationId.equals(allocationId) || cps != null;
                + ", globalCheckpoint="
        public CheckpointState copy() {
     * After a new checkpoint is published, start a timer per replica for the checkpoint.
    public void removeRetentionLease(final String id, final ActionListener<ReplicationResponse> listener) {
     */
                    + inSyncAllocationIds
            .filter(e -> e.getValue().inSync && e.getValue().replicated)
            this.latestReplicationCheckpoint = checkpoint;
        final String allocationId,
     *
     * @return the retention leases
                            || (indexSettings.isAssignedOnRemoteNode()
                    shardRouting -> retentionLeases.contains(getPeerRecoveryRetentionLeaseId(shardRouting))
     * Updates the global checkpoint on a replica shard after it has been updated by the primary.
        }
                                groupedActionListener
        boolean increasedLocalCheckpoint = updateLocalCheckpoint(allocationId, cps, localCheckpoint);
        final long retentionLeaseMillis = indexSettings.getRetentionLeaseMillis();
        ActionListener<ReplicationResponse> listener
     */
import org.opensearch.index.shard.IndexShard;
            PEER_RECOVERY_RETENTION_LEASE_SOURCE,
            return this.checkpoints.entrySet()
 *    http://www.apache.org/licenses/LICENSE-2.0
            retentionLeases = RetentionLeases.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, path);
     *
    /**
        assert indexSettings.isSegRepEnabledOrRemoteNode();
     * The version of the most-recently persisted retention leases. This is used to check if we need to persist the current retention
                setCreatedMissingRetentionLeases();
        logger.trace(
        }
     * Removes an existing retention lease.
                    final RetentionLease retentionLease = retentionLeases.get(getPeerRecoveryRetentionLeaseId(shardRouting));
        assert primaryMode;
            pendingInSync.add(allocationId);
        assert invariant();
        final RetentionLeases retentionLeases;
        final long bytesBehind = diff.missing.stream().mapToLong(StoreFileMetadata::length).sum();
                        final boolean inSync = inSyncAllocationIds.contains(initializingId);
     * @throws RetentionLeaseAlreadyExistsException if the specified retention lease already exists
                logger.debug("{} becoming primary of {} with missing lease: {}", primaryShard, routingTable, retentionLeases);
                // it is possible for a shard to be in-sync but not yet removed from the checkpoints collection after a failover event.
     * @param inSyncAllocationIds         the allocation IDs of the currently in-sync shard copies
     * Sets the current operation primary term. This method should be invoked only when no other operations are possible on the shard. That
                final CheckpointState cps = checkpoints.get(shardRouting.allocationId().getId());
            return clusterStateVersion;
    }
     */
                                primaryTargetAllocationId,
        boolean pending = pendingInSync.contains(allocationId);
        long newVersion;
import java.util.stream.Collectors;
        final RetentionLeases currentRetentionLeases;
    private static long inSyncCheckpointStates(
    /**
     *
    }
            : "global checkpoint is not up-to-date, expected: "
    @Override
        assert invariant();
                            )
            && routingTable.assignedShards()
import java.io.IOException;
            onGlobalCheckpointUpdated.accept(globalCheckpoint);
     * @param id                      the identifier of the retention lease
                }
     * @return a map from allocation ID to the local knowledge of the persisted global checkpoint for that allocation ID
            persistedRetentionLeasesVersion = currentRetentionLeases.version();
 * specific language governing permissions and limitations
        this.onGlobalCheckpointUpdated = Objects.requireNonNull(onGlobalCheckpointUpdated);
                + ", replicated="
     * See {@link ReplicationTracker#addPeerRecoveryRetentionLease}.
            return;
        cps.visibleReplicationCheckpoint = visibleCheckpoint;
     * @param primaryAllocationId       primary allocation id
     */
     * Loads the latest retention leases from their dedicated state file.
     * @param onSyncRetentionLeases     a callback when a new retention lease is created or an existing retention lease expires
            leaseIdsForCurrentPeers = routingTable.assignedShards()
            throw new IllegalStateException("no local checkpoint tracking information available");
    /**
        final Collection<RetentionLease> expiredLeases = partitionByExpiration.get(true);
 * KIND, either express or implied.  See the License for the
        assert !primaryMode || checkpoints.get(shardAllocationId).inSync;
            notifyAllWaiters();
            final String primaryAllocationId = primary.allocationId().getId();
     */
            return allocationId.equals(primaryAllocationId) || allocationId.equals(primaryTargetAllocationId);
                        final long localCheckpoint = SequenceNumbers.UNASSIGNED_SEQ_NO;
                    && latestReplicationCheckpoint.isAheadOf(cps.visibleReplicationCheckpoint)
    /**
            + allocationId
        // note that if there was no cluster state update between start of the engine of this shard and the call to
    }
    /**
                            + initializingId
import org.opensearch.index.store.Store;
    private boolean updateLocalCheckpoint(String allocationId, CheckpointState cps, long localCheckpoint) {
     *
     * @param listener the callback when the retention lease is successfully removed and synced to replicas
/*
    }
        final RetentionLease retentionLease;
    }
     */
     * {@link ReplicationTracker#createMissingPeerRecoveryRetentionLeases(ActionListener)}.
    }
     * A supplier of the current time. This supplier is used to add a timestamp to retention leases, and to determine retention lease
    /**
            if (out.getVersion().onOrAfter(Version.V_2_5_0)) {
     * primary shard calculates which leases are expired, and if any have expired, syncs the retention leases to any replicas. If the
     * to eagerly. As consequence, some of the methods in this class are not allowed to be called while a handoff is in progress,
                + shardAllocationId
        // primary and primary target allocation id.
            });
        }
        // TODO after backporting we expect this never to happen in 8.x, so adjust this to throw an exception instead.
import java.util.function.Function;
        // might not have retention leases for docrep shard copies
        final SafeCommitInfo safeCommitInfo = safeCommitInfoSupplier.get();
     *
                assert hasAllPeerRecoveryRetentionLeases == false : routingTable + " vs " + retentionLeases;
        primaryMode = true;
        /**
        final RetentionLeases currentRetentionLeases;
            }
     * Returns whether the requests are replicated considering the remote translog existence, current/primary/primary target allocation ids.
                        }
        assert (routingTable == null) == (replicationGroup == null) : "routing table is "
import java.util.concurrent.atomic.AtomicLong;
        private final IndexShardRoutingTable routingTable;
        );
            .collect(Collectors.toList());
    }
 * Modifications Copyright OpenSearch Contributors. See
    }
     */
            : "In absence of remote translog store, all tracked shards must have replication mode as LOGICAL_REPLICATION";
            final String allocationId = entry.getKey();
            final List<ShardRouting> shardRoutings = routingTable.assignedShards()
                .filter(
        // If assigned to a remote node, returns true if given allocation id matches the primary or it's relocation target allocation
        assert primaryMode;
     * Local checkpoint information for all shard copies that are tracked. Has an entry for all shard copies that are either initializing
                            );
        final long retainingSequenceNumber,
    public static class PrimaryContext implements Writeable {
         * replica shards). In these cases, the local knowledge of the global checkpoint could be higher than the sync from the lagging
    public synchronized void updateGlobalCheckpointOnReplica(final long newGlobalCheckpoint, final String reason) {
        this.onSyncRetentionLeases = Objects.requireNonNull(onSyncRetentionLeases);
        assert indexSettings.isSegRepEnabledOrRemoteNode();
            indexSettings,
        String primaryAllocationId,
        assert invariant();
    }
         * the last global checkpoint information that we have for this shard. This is the global checkpoint that's fsynced to disk on the
            logger.trace("updated global checkpoint to [{}]", computedGlobalCheckpoint);
        assert relocated == false;
                                    initializingId,
         */
            });
public class ReplicationTracker extends AbstractIndexShardComponent implements LongSupplier {
            return Tuple.tuple(false, retentionLeases);
     * have been set up locally to track local checkpoint information for the shard and that the shard is added to the replication group.
    /**
     * the version of the last applied cluster state to ensure in-order updates.
     *                                                      the retaining sequence number of the current retention lease.
            )
        if (retainingSequenceNumber < existingRetentionLease.retainingSequenceNumber()) {
                .map(ShardRouting::allocationId)
            globalCheckpoint,
         */
        }
     */
    /**
                + globalCheckpoint;
                    pendingInSync.removeIf(aId -> checkpoints.containsKey(aId) == false);
    private synchronized void notifyAllWaiters() {
            throw new RetentionLeaseNotFoundException(id);
                            renewRetentionLease(
        assert indexSettings.isSegRepEnabledOrRemoteNode();
            if (entry.getValue().inSync) {
     * Creates a peer recovery retention lease for this shard, if one does not already exist and this shard is the sole
     */
                if (cps.localCheckpoint == SequenceNumbers.UNASSIGNED_SEQ_NO) {
                final CheckpointState cps = e.getValue();
     */
            // blocking global checkpoint advancement only happens for shards that are not in-sync
            x -> {},
    /**
     * @return a tuple indicating whether or not any retention leases were expired, and the non-expired retention leases
        assert invariant();
        final Function<String, Boolean> isShardOnRemoteEnabledNode
    public void setOperationPrimaryTerm(final long operationPrimaryTerm) {
     *   handoff. If the target shard is successfully initialized in primary mode, the source shard of a primary relocation is then moved
        return operationPrimaryTerm;
        retentionLeases = new RetentionLeases(
                + "]"
     * Threshold for expiring peer-recovery retention leases and falling back to file-based recovery. See
            return routingTable;
    public synchronized void markAllocationIdAsInSync(final String allocationId, final long localCheckpoint) throws InterruptedException {
        }
        this.pendingInSync = new HashSet<>();
     */
     * - We just did a rolling upgrade from a version prior to {@code LegacyESVersion#V_7_4_0} that does not create peer-recovery retention leases.
        final Supplier<SafeCommitInfo> safeCommitInfoSupplier,
                        } catch (Exception e) {
            currentRetentionLeases = retentionLeases;
                .map(AllocationId::getId)
    public void removePeerRecoveryRetentionLease(String nodeId, ActionListener<ReplicationResponse> listener) {
    public boolean isRelocated() {
        assert pendingInSync.isEmpty() : "relocation handoff started while there are still shard copies pending in-sync: " + pendingInSync;
                        new CheckpointState(
            logger.trace("persisting retention leases [{}]", currentRetentionLeases);
        addPeerRecoveryRetentionLeaseForSolePrimary();
                : 0,
        // when in primary mode, the current allocation ID is the allocation ID of the primary or the relocation allocation ID
        /**
                            new CheckpointState(
                        || checkpoints.get(shardRouting.allocationId().getId()).tracked == false
            if (replicationGroup.getReplicationTargets().equals(Collections.singletonList(primaryShard))
            this.retentionLeases = retentionLeases;
        // local checkpoints only set during primary mode
                while (true) {
        final long operationPrimaryTerm,
        // Handle migration cases. Ignore assertion if any of the shard copies in the replication group is assigned to a remote node
                        return false;
                .stream()
    }
            result = 31 * result + Long.hashCode(globalCheckpoint);
        addPeerRecoveryRetentionLeaseForSolePrimary();
                + '}';
        assert handoffInProgress == false;
        }
     * Fetch stats on segment replication.
        assert handoffInProgress == false;
                cps.visibleReplicationCheckpoint,
            .forEach(e -> globalCheckpoints.put(e.getKey(), e.getValue().globalCheckpoint));
        public void writeTo(StreamOutput out) throws IOException {
    public RetentionLeases getRetentionLeases() {
        assert primaryMode;
     */
            || checkpoints.entrySet().stream().filter(e -> e.getValue().tracked).allMatch(e -> e.getValue().replicated)
        assert invariant();
            }
     *
                }
 * GitHub history for details.
        // all pending in sync shards are tracked
        assert invariant();
         * Peer-recovery retention leases never expire while the associated shard is assigned, but we must still renew them occasionally in
    /**
                            localCheckpoint,
     * {@link ReplicationTracker#createMissingPeerRecoveryRetentionLeases(ActionListener)} has not yet completed. Is only permitted
            newVersion = replicationGroup.getVersion() + 1;
        }
     *
        }
                .stream()
        ReplicationCheckpoint visibleReplicationCheckpoint;
    // only after the copy becomes active so that recovery finalization time is not reported as replication lag.
        // copy clusterStateVersion and checkpoints and return
        final Function<String, Boolean> isShardOnRemoteEnabledNode
    }
        if (localCheckpoint > cps.localCheckpoint) {
     * @param globalCheckpoint          the last known global checkpoint for this shard, or {@link SequenceNumbers#UNASSIGNED_SEQ_NO}
     */
    /**
    ) {
        final long renewalTimeMillis = currentTimeMillisSupplier.getAsLong() - indexSettings.getRetentionLeaseMillis() / 2;
                            groupedActionListener.onFailure(e);
        for (final CheckpointState cps : localCheckpoints) {
            + cps.localCheckpoint
    /**
     * The reason for this is that the handoff might fail and can be aborted (using {@link #abortRelocationHandoff}), in which case
                + inSync
        CheckpointState cps = checkpoints.get(allocationId);
     * Resets hasAllPeerRecoveryRetentionLeases to false. Called when a DFA read-only engine is created
        super(shardId, indexSettings);
            return replicated == that.replicated;
        }
                this.replicated = in.readBoolean();
                    && latestReplicationCheckpoint.isAheadOf(cps.visibleReplicationCheckpoint)
                .filter(shardRouting -> shardRouting.isSearchOnly() == false)
    ) {
        // (since all RetentionLease sync actions are blocked on remote shard copies)
     * Called when the recovery process for a shard has opened the engine on the target shard. Ensures that the right data structures
        assert handoffInProgress == false;
    /**
            allocationId,
     */
        assert handoffInProgress;
                if (shardRouting.isSearchOnly()) {
    private synchronized void setCreatedMissingRetentionLeases() {
        handoffInProgress = false;
     */
    }
        } else {
    }
        // has the same seqno, so we may be overestimating the cost of a file-based recovery when compared to an ops-based recovery and
                + " to have initialized entry in "
/*
     * @param operationPrimaryTerm the new operation primary term
                logger.trace("addPeerRecoveryRetentionLeaseForSolePrimary: adding lease [{}]", leaseId);
            for (final ShardRouting shardRouting : routingTable.assignedShards()) {
        if (retentionLeases.contains(id)) {
    public RetentionLeases loadRetentionLeases(final Path path) throws IOException {
            + routingTable;
            if (primaryMode && removedEntries) {
     * The current retention leases.
            IndexShardRoutingTable.Builder.writeTo(routingTable, out);
        private final long clusterStateVersion;
            cps.lastCompletedReplicationLag = lastFinished.get();
                                )
        return retentionLease;
        }
    /**
        assert invariant();
     * The flag will be set back to true when createMissingPeerRecoveryRetentionLeases(ActionListener) completes.
        // forget all checkpoint information
        final ShardRouting primaryShard = routingTable.primaryShard();
    public ReplicationGroup getReplicationGroup() {
     * @param localCheckpoint the local checkpoint for the shard
                        + retentionLeases;
     *
            latestReplicationCheckpoint.getMetadataMap(),
     * @throws WriteStateException if an exception occurs writing the state file
        assert Thread.holdsLock(this);
     * @param path the path to the directory containing the state file
    }
        if (retentionLeases == null) {
    private boolean assignedToRemoteStoreNode(IndexShardRoutingTable routingTable, String allocationId) {
        assert primaryMode;
            }
        String primaryTargetAllocationId,
     * {@link IndexSettings#FILE_BASED_RECOVERY_THRESHOLD_SETTING}.
            || (routingTable.getByAllocationId(allocationId) != null
            currentRetentionLeases = retentionLeases;
            + allocationId
                .stream()
     * Whether there should be a peer recovery retention lease (PRRL) for every tracked shard copy. Always true on indices created from
     * The global checkpoint tracker can operate in two modes:
                    && shouldSkipReplicationLag(e.getKey()) == false
        final Map<String, Long> globalCheckpoints = new HashMap<>(checkpoints.size()); // upper bound on the size
     * expire leases parameter is true, this replication tracker must be in primary mode.
     *   {@link #updateGlobalCheckpointOnReplica(long, String)}).
        }
                        );
    public void persistRetentionLeases(final Path path) throws WriteStateException {
        // TODO improve this measure for when nested docs are in use
        if (cps.replicated && increasedLocalCheckpoint && pending == false) {
    public ReplicationTracker(
        final long fallback
        assert primaryMode;
                                Math.max(SequenceNumbers.NO_OPS_PERFORMED, checkpointState.globalCheckpoint),
                "skipped updating local checkpoint of [{}] from [{}] to [{}], current checkpoint is higher",
        final RetentionLease retentionLease = new RetentionLease(
        runAfter.run();
        if (indexSettings.isRemoteTranslogStoreEnabled()) {
                            addPeerRecoveryRetentionLease(
        return true;
                                primaryAllocationId,
                    && shouldSkipReplicationLag(allocationId) == false
                return retentionLease.timestamp() <= renewalTimeMillis
            throw new IllegalStateException("relocation target [" + targetAllocationId + "] is no longer part of the replication group");
        updateGlobalCheckpointOnPrimary();
                } else {
        public PrimaryContext(long clusterStateVersion, Map<String, CheckpointState> checkpoints, IndexShardRoutingTable routingTable) {
                                newRetainedSequenceNumber,
    /**
     * checkpoints. In replica mode, this is the in-memory global checkpoint that's communicated by the primary.
        }
            return RetentionLeases.EMPTY;
            logger.warn("Ignoring the checkpoint update for allocation ID {} as its not being tracked by primary", allocationId);
     */
        return minLocalCheckpoint;
     * Source for peer recovery retention leases; see {@link ReplicationTracker#addPeerRecoveryRetentionLease}.
            result = 31 * result + Boolean.hashCode(replicated);
         * The time it took to complete the most recent replication event.
            out.writeBoolean(inSync);
     */
        final long lastAppliedClusterStateVersion = appliedClusterStateVersion;
        assert invariant();
                this.replicated = true;
                + entry.getKey()
                )) {
            this.replicated = replicated;
    }
        @Override
        assert indexSettings.isSegRepEnabledOrRemoteNode();
            persistedRetentionLeasesPrimaryTerm = currentRetentionLeases.primaryTerm();
                innerAddRetentionLease(
            this.tracked = tracked;
        // the routing table and replication group is set when the global checkpoint tracker operates in primary mode
            cps.checkpointTimers.size(),
        primaryMode = true;
                        retentionLeases.get(getPeerRecoveryRetentionLeaseId(shardRouting)).source()
            + allocationId
                        + "] in "
        /*
                    // unassigned in-sync replica
    /**
            globalCheckpoint = newGlobalCheckpoint;
     * Get the local knowledge of the persisted global checkpoints for all in-sync allocation IDs.
     * to influence the list of in-sync shard copies here, this could possibly remove such an in-sync copy from the internal structures
        checkpoints.forEach((key, cps) -> {
                notifyAllWaiters();
            updateReplicationGroupAndNotify();
        if (checkpoints.containsKey(targetAllocationId) == false) {
                            cps.checkpointTimers.keySet()
        // update on the relocation target once relocation completes). We could alternatively also copy the map as-is (it’s safe), and it
    private void updateReplicationGroupAndNotify() {
            getPeerRecoveryRetentionLeaseId(nodeId),
        assert handoffInProgress;
        if (hasAllPeerRecoveryRetentionLeases == false || createMissingRetentionLeasesDuringMigration) {
     */
        assert primaryMode || checkpoints.values().stream().allMatch(lcps -> lcps.localCheckpoint == SequenceNumbers.UNASSIGNED_SEQ_NO);
    public RetentionLease addPeerRecoveryRetentionLease(
     * Cached value for the last replication group that was computed
                            || indexSettings.isSegRepLocalEnabled()
            newVersion
     * is, either from the constructor of {@link IndexShard} or while holding all permits on the {@link IndexShard} instance.
            this.globalCheckpoint = in.readZLong();
                    || retentionLease.retainingSequenceNumber() <= checkpoints.get(shardRouting.allocationId().getId()).globalCheckpoint;
                allocationId,
                    }
import java.util.Set;
import org.opensearch.gateway.WriteStateException;
        final long applyingClusterStateVersion,
            onGlobalCheckpointUpdated,
        assert !primaryMode || checkpoints.get(shardAllocationId).tracked;
     * @opensearch.api
     */
        // entries blocking global checkpoint advancement can only exist in primary mode and when not having a relocation handoff
            operationPrimaryTerm,
     */
     * retention lease sync action, to sync retention leases to replicas.
        this.primaryMode = false;
        checkpoints.entrySet().forEach(entry -> {
                    assert (checkpoints.get(shardRouting.allocationId().getId()).tracked
 * Unless required by applicable law or agreed to in writing,
     * Activates the global checkpoint tracker in primary mode (see {@link #primaryMode}. Called on primary relocation target during
        long minLocalCheckpoint = Long.MAX_VALUE;
                && isShardOnRemoteEnabledNode.apply(routingTable.getByAllocationId(allocationId).currentNodeId()));
     * @return the global checkpoint
        }
 * compatible open source license.
            }
     * <p>
}
         * respective shard, and all operations up to this point are properly fsynced to disk as well.
    }
import java.util.List;
            || (routingTable.primaryShard().allocationId().getId().equals(shardAllocationId)
    /**
                    continue;
            int result = Long.hashCode(clusterStateVersion);
        // the computed global checkpoint is always up-to-date
                }
            retentionLease = innerAddRetentionLease(id, retainingSequenceNumber, source);
        final long globalCheckpoint,
        boolean replicated;
 *
                            false,
        assert Thread.holdsLock(this);
        @Override
    /**
     * <p>
import org.opensearch.Version;
            currentTimeMillisSupplier,
     * Boolean flag that indicates if a relocation handoff is in progress. A handoff is started by calling
    /**
 * <p>
     * @return the new retention lease
                                + " according to "
        assert invariant();
                + " with a lower retaining sequence number ["
     * @return the new retention lease
        assert invariant();
import java.util.stream.StreamSupport;
     *   computation from that point on.
    public synchronized Tuple<Boolean, RetentionLeases> getRetentionLeases(final boolean expireLeases) {
        }
        // Syncing here may not be strictly necessary, because this new lease isn't retaining any extra history that wasn't previously
        assert invariant();
                listener.onResponse(null);
     * Persists the current retention leases to their dedicated state file. If this version of the retention leases are already persisted
        return retentionLease;
                + checkpoints
import org.opensearch.action.support.GroupedActionListener;
     */
        assert localCheckpoint >= SequenceNumbers.NO_OPS_PERFORMED : "invalid local checkpoint ["
        final LongSupplier currentTimeMillisSupplier,
        updateLocalCheckpoint(allocationId, cps, localCheckpoint);
                    hasAllPeerRecoveryRetentionLeases = true;
        onSyncRetentionLeases.accept(currentRetentionLeases, listener);
        final long globalCheckpoint,
                // add new initializingIds that are missing locally. These are fresh shard copies - and not in-sync
    }
        } else {
     */
        // NB safeCommitInfo.docCount is a very low-level count of the docs in the index, and in particular if this shard contains nested
     * cluster state that is older than the one upon which the primary context was based. If we allowed this old cluster state
                        checkpoints.put(
    /**
            onSyncRetentionLeases,
     *
        }
import java.util.stream.Stream;
         * When a shard is in-sync, it is capable of being promoted as the primary during a failover. An in-sync shard
        }
    }
     * Returns whether the replication tracker is in primary mode, i.e., whether the current shard is acting as primary from the point of
    }
                    }
            logger.trace("updated local checkpoint of [{}] from [{}] to [{}]", allocationId, cps.localCheckpoint, localCheckpoint);
                        return true;
        final boolean allShardsStarted = routingTable.allShardsStarted();
        return getPeerRecoveryRetentionLeaseId(shardRouting.currentNodeId());
        } else if (hasAllPeerRecoveryRetentionLeases == false
        boolean tracked;
        }
        handoffInProgress = true;
        public long getLocalCheckpoint() {
        this.operationPrimaryTerm = operationPrimaryTerm;
     * (warm primary) to prevent assertion failures in renewPeerRecoveryRetentionLeases() during the
     * {@link #abortRelocationHandoff}, depending on whether the handoff was successful or not. During the handoff, which has as main
    public synchronized boolean pendingInSync() {

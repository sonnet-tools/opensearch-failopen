     * @param onSyncRetentionLeases     a callback when a new retention lease is created or an existing retention lease expires  
        } else {
                     */  
     * Source for peer recovery retention leases; see {@link ReplicationTracker#addPeerRecoveryRetentionLease}.  
            + allocationId
     * Advance the peer-recovery retention leases for all assigned shard copies to discard history below the corresponding global  
     */
        final Function<String, Boolean> isShardOnRemoteEnabledNode
                    + inSyncAllocationIds
                throw new RetentionLeaseNotFoundException(sourceLeaseId);  
    * The state of the lucene checkpoint
            out.writeZLong(localCheckpoint);
            PEER_RECOVERY_RETENTION_LEASE_SOURCE,  
     * checkpoint, and renew any leases that are approaching expiry.
        final long globalCheckpoint,
    public synchronized boolean hasAllPeerRecoveryRetentionLeases() {
     */
            currentTimeMillisSupplier.getAsLong(),  
        onSyncRetentionLeases.accept(currentRetentionLeases, listener);  
        final BiConsumer<RetentionLeases, ActionListener<ReplicationResponse>> onSyncRetentionLeases,
        public Map<String, CheckpointState> getCheckpointStates() {
                                Math.max(SequenceNumbers.NO_OPS_PERFORMED, checkpointState.globalCheckpoint),  
            .stream()
        return () -> updateFromClusterManager(lastAppliedClusterStateVersion, inSyncAllocationIds, lastAppliedRoutingTable);
        if (cps == null) {
            updateReplicationGroupAndNotify();
                + "] "  
                    }
                    && (indexSettings.isSegRepLocalEnabled() == true
                // Search replicas are assigned but never tracked by the primary, so they have no checkpoint state.
    volatile long globalCheckpoint;  
            latestReplicationCheckpoint.getMetadataMap(),
     * Renews an existing retention lease.
            + computedGlobalCheckpoint
     *  
        // only stored locally still needs to take part in replication for its operations to be durable.
    /**  
    }  
        if (indexSettings.isRemoteTranslogStoreEnabled()) {
        }
                    if (checkpoints.containsKey(initializingId) == false) {
            this.retentionLeases = retentionLeases;  
     * @param allocationId              the allocation ID
     * @throws RetentionLeaseAlreadyExistsException if the specified target retention lease already exists  
            }
import java.util.stream.LongStream;  
        final LongConsumer onGlobalCheckpointUpdated,  
                + ", globalCheckpoint="  
                + "]"  
                + shardAllocationId
     * @param listener the callback when the retention lease is successfully removed and synced to replicas
                            );
        final CheckpointState cps = checkpoints.get(allocationId);
    public boolean isRelocated() {
     *   computation from that point on.
     * expire leases parameter is true, this replication tracker must be in primary mode.
     * expiration of existing retention leases, and then gets all non-expired retention leases tracked on this shard. Note that only the
            });  
            + " or it's not replicated";  
 * The global checkpoint is the highest sequence number for which all lower (or equal) sequence number have been processed
            globalCheckpoint = computedGlobalCheckpoint;  
                    }
        // (since all RetentionLease sync actions are blocked on remote shard copies)  
            int result = Long.hashCode(localCheckpoint);  
                this.replicated = true;
     * @throws InterruptedException if this thread was interrupted before of during waiting
                    if (pendingInSync.contains(allocationId)) {
        this.operationPrimaryTerm = operationPrimaryTerm;
import org.opensearch.common.annotation.PublicApi;
        CheckpointState cps = checkpoints.get(allocationId);
        } else {  
        final ShardRouting primaryShard = routingTable.primaryShard();
     * @param retainingSequenceNumber the retaining sequence number
    }
            if (out.getVersion().onOrAfter(Version.V_2_5_0)) {
    public synchronized void setLatestReplicationCheckpoint(ReplicationCheckpoint checkpoint) {
    /**  
     * shard copy with local translog in the replication group. If one does not already exist and yet there are other
     * on the specified shard advances above the current global checkpoint.
         * Map of ReplicationCheckpoints to ReplicationTimers.  Timers are added as new checkpoints are published, and removed when
    }  
                                assignedToRemoteStoreNode(routingTable, initializingId)
     * After a new checkpoint is published, create a timer for each replica to the checkpoint.
        // Deliberately keyed off the remote translog rather than the remote segment store: a shard whose translog is  
            assert !entry.getValue().inSync || entry.getValue().tracked : "shard copy " + entry.getKey() + " is in-sync but not tracked";
        assert handoffInProgress == false;
        }  
            assert checkpoints.get(aId) != null : "aId [" + aId + "] is pending in sync but isn't tracked";
import java.util.HashMap;
                            globalCheckpoint,
                    leaseId,
                        + retentionLeases;
         */  
    private SegmentReplicationShardStats buildShardStats(final String allocationId, final CheckpointState cps) {
    }
        onSyncRetentionLeases.accept(currentRetentionLeases, listener);
        for (final CheckpointState cps : localCheckpoints) {
                        } catch (Exception e) {  
            PrimaryContext that = (PrimaryContext) o;
            cps.lastCompletedReplicationLag
    }
                }  
        return Collections.emptySet();
    RetentionLease cloneRetentionLease(String sourceLeaseId, String targetLeaseId, ActionListener<ReplicationResponse> listener) {
                        return false;
                throw new RetentionLeaseNotFoundException(id);  
                        final CheckpointState checkpointState = checkpoints.get(shardRouting.allocationId().getId());
        return new PrimaryContext(appliedClusterStateVersion, localCheckpointsCopy, routingTable);
                || routingTable.primaryShard().allocationId().getRelocationId().equals(shardAllocationId));
            && indexSettings.getIndexMetadata().getState() == IndexMetadata.State.OPEN;
    /**  
                                localCheckpoint,
     * Updates retention leases on a replica.
     *  
                .map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
            return result;
        final IndexShardRoutingTable lastAppliedRoutingTable = routingTable;  
                    final long localCheckpoint = SequenceNumbers.UNASSIGNED_SEQ_NO;  
                            allocationId,
            logger.warn("Ignoring the checkpoint update for allocation ID {} as its not being tracked by primary", allocationId);  
     * the version of the last applied cluster state to ensure in-order updates.
        assert !primaryMode || (routingTable != null && replicationGroup != null) : "primary mode but routing table is "
        public long getLocalCheckpoint() {
import org.opensearch.gateway.WriteStateException;
        // the current shard is marked as tracked when the global checkpoint tracker operates in primary mode
            updateGlobalCheckpointOnPrimary();
     */  
    /**
    }  
        if (expiredLeases == null) {
        final long bytesBehind = diff.missing.stream().mapToLong(StoreFileMetadata::length).sum();
 * KIND, either express or implied.  See the License for the
                            || indexSettings.isSegRepLocalEnabled()
     * If the expire leases parameter is false, gets all retention leases tracked on this shard and otherwise first calculates
     * @param id                      the identifier of the retention lease
        primaryMode = false;  
        // Ignore if the cps is null (i.e. replica shard not in active state).
 */
     * <p>  
            logger.trace(  
        return new SegmentReplicationShardStats(
        }  
                // group.
            .filter(lease -> PEER_RECOVERY_RETENTION_LEASE_SOURCE.equals(lease.source()))
                            true,  
        final IndexShardRoutingTable routingTable
     */  
                        final long globalCheckpoint = localCheckpoint;
     *
     * @param localCheckpoint the local checkpoint for the shard  
     */
        Map<String, CheckpointState> localCheckpointsCopy = new HashMap<>();  
    public synchronized void updateLocalCheckpoint(final String allocationId, final long localCheckpoint) {
     * @param allocationId  the allocation ID of the shard for which recovery was initiated
        final RetentionLeases currentRetentionLeases;
     * Retention leases for peer recovery have source {@link ReplicationTracker#PEER_RECOVERY_RETENTION_LEASE_SOURCE}, a lease ID  
     */  
         * The time it took to complete the most recent replication event.
        this.onSyncRetentionLeases = Objects.requireNonNull(onSyncRetentionLeases);  
                            cps.visibleReplicationCheckpoint,  
        updateGlobalCheckpointOnPrimary();  
     * @opensearch.api
        routingTable = primaryContext.getRoutingTable();
    /**  
     * {@code LegacyESVersion#V_7_4_0} onwards, because these versions create PRRLs properly. May be false on indices created in an  
            this.inSync = in.readBoolean();
        replicationGroup = newReplicationGroup;
                 * leases for every shard copy, but in this case we do not expect any leases to exist.
    @Override
        this.primaryMode = false;
            checkpoints.put(entry.getKey(), entry.getValue().copy());
     * advances due to an update from the primary.
        final boolean allShardsStarted = routingTable.allShardsStarted();
            out.writeBoolean(inSync);  
        if (cps.checkpointTimers.isEmpty() == false) {  
                final CheckpointState cps = entry.getValue();
                )
        return getRetentionLeases().leases()
                            || (indexSettings.isAssignedOnRemoteNode()
 * on all shards that are currently active. Since shards count as "active" when the cluster-manager starts
    public synchronized boolean pendingInSync() {
     */
     * @return the retention leases
            .stream()
                    logger.trace("skipping persisting retention leases [{}], already persisted", retentionLeases);  
                                    initializingId,
        this.latestReplicationCheckpoint = indexSettings.isSegRepEnabledOrRemoteNode() ? ReplicationCheckpoint.empty(shardId) : null;  
         * {@link ReplicationTracker}.
     * shard copies in this group then we must have just done a rolling upgrade from a version before {@code LegacyESVersion#V_7_4_0},  
        final String id,  
                .anyMatch(shardRouting -> isShardOnRemoteEnabledNode.apply(shardRouting.currentNodeId()) == false);
     */  
        return globalCheckpoint;  
            }
                }
                                assignedToRemoteStoreNode(routingTable, inSyncId)
            + " that's already in-sync should have a local checkpoint "
        return primaryMode;  
    final Map<String, CheckpointState> checkpoints;  
            cps.lastCompletedReplicationLag = lastFinished.get();
    /**
        long globalCheckpoint;  
        }
     * Get the local knowledge of the persisted global checkpoints for all in-sync allocation IDs.
        }
        return true;
 * under the License.  
                    || retentionLease.retainingSequenceNumber() <= checkpoints.get(shardRouting.allocationId().getId()).globalCheckpoint;
    }  
        final ActionListener<ReplicationResponse> listener  
import java.nio.file.Path;
import org.apache.logging.log4j.message.ParameterizedMessage;
    private boolean shouldSkipReplicationLag(String allocationId) {  
        assert Version.CURRENT.major <= 8 : "throw an exception instead of returning EMPTY on null";  
     * @param localCheckpoint the current local checkpoint on the shard
     *   to replica mode (using {@link #completeRelocationHandoff}), as the relocation target will be in charge of the global checkpoint  
 * this work for additional information regarding copyright
        // therefore preferring ops-based recoveries inappropriately in this case. Correctly accounting for nested docs seems difficult to
     */
        // No-Op if retention leases for the tracked shard copy already exists  
        hasAllPeerRecoveryRetentionLeases = false;  
                // add new initializingIds that are missing locally. These are fresh shard copies - and not in-sync
        assert primaryMode;
     */
    /**
        checkpoints.entrySet()  
                    }  
 * <p>  
     *  
        assert !this.shardAllocationId.equals(allocationId);  
    }  
        assert invariant();  
    }  
                if (lease.source().equals(PEER_RECOVERY_RETENTION_LEASE_SOURCE)) {  
 * SPDX-License-Identifier: Apache-2.0
    /**  
     */  
            x -> {},
    private volatile long operationPrimaryTerm;  
     * to change from false to true; can be removed once support for pre-PRRL indices is no longer needed.  
        final IndexSettings indexSettings,  
        final LongSupplier currentTimeMillisSupplier,
        }  
                            assert checkpointState.globalCheckpoint == SequenceNumbers.UNASSIGNED_SEQ_NO : "cannot renew "
                return result;
            throw new RetentionLeaseNotFoundException(id);
        }
            this.inSync = inSync;
    }
        assert !primaryMode || checkpoints.get(shardAllocationId).tracked;
        private final IndexShardRoutingTable routingTable;
     */
        }  
    /**  
     * Class invariant that should hold before and after every invocation of public methods on this class. As Java lacks implication  
        }  
    IndexShardRoutingTable routingTable;
import org.opensearch.cluster.metadata.IndexMetadata;
            retainingSequenceNumber,  
        @Override
    /**
                + ", tracked="
     *
            // check that the cluster-manager does not fabricate new in-sync entries out of thin air once we are in primary mode  
    }  
            checkpoints.entrySet().stream().filter(e -> !e.getKey().equals(this.shardAllocationId)).forEach(e -> {
                            + initializingId
        this.replicationGroup = null;  
            : "cached replication group out of sync: expected: " + calculateReplicationGroup() + " but was: " + replicationGroup;  
        final Supplier<SafeCommitInfo> safeCommitInfoSupplier,  
                    // Although this index is old enough not to have all the expected peer recovery retention leases, in fact it does, so we
    }
        this.notifyAll();
    /**
 * this file be licensed under the Apache-2.0 license or a
        this.safeCommitInfoSupplier = safeCommitInfoSupplier;
        return getPeerRecoveryRetentionLeaseId(shardRouting.currentNodeId());
        }
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
            // all tracked shard copies have a corresponding peer-recovery retention lease
            }  
     */
            checkpoints.values()  
            } else {  
        assert indexSettings.isSegRepEnabledOrRemoteNode();  
        }  
                + globalCheckpoint
                // if the shard is in checkpoints but is unavailable or out of sync we will not track its replication state.
     * @param checkpoint {@link ReplicationCheckpoint}  
        /**
            cps.localCheckpoint = localCheckpoint;  
            newVersion = 0;
        final Collection<CheckpointState> localCheckpoints,  
    private long getMinimumReasonableRetainedSeqNo() {
        }
        // a relocated copy is not in primary mode
     */
                            false,
        String nodeId,
     * @throws IOException if an I/O exception occurs reading the retention leases  
                + "] "  
                    Math.max(0L, checkpoints.get(shardAllocationId).globalCheckpoint + 1),  
 */  
     * @param allocationId    the allocation ID of the shard to mark as in-sync  
            return;
     *  
     * {@link #startRelocationHandoff(String)} and is finished by either calling {@link #completeRelocationHandoff} or
     */
        final long globalCheckpoint,
     */  
        @Override
        }
        ToLongFunction<CheckpointState> function,
    private synchronized void notifyAllWaiters() {
         */
                return retentionLease.timestamp() <= renewalTimeMillis
                                globalCheckpoint,  
        createdMissingRetentionLeases = true;
                            groupedActionListener.onFailure(e);
     * The primary term of the most-recently persisted retention leases. This is used to check if we need to persist the current retention
        if (primaryMode) {
     * Local checkpoint information for all shard copies that are tracked. Has an entry for all shard copies that are either initializing
     * Notifies the tracker of the current allocation IDs in the cluster state.  
 *  
                .anyMatch(shardRouting -> isShardOnRemoteEnabledNode.apply(shardRouting.currentNodeId()))
        public IndexShardRoutingTable getRoutingTable() {  
            + checkpoints
            if (allocationId.equals(this.shardAllocationId) == false) {  
            if (globalCheckpoint != that.globalCheckpoint) return false;
    private synchronized void setCreatedMissingRetentionLeases() {  
import java.util.concurrent.atomic.AtomicLong;  
     * Atomically clones an existing retention lease to a new ID.
        relocated = true;
        if (cps.replicated && cps.localCheckpoint < getGlobalCheckpoint()) {
                            isReplicated(
                    + checkpoints;  
    public synchronized PrimaryContext startRelocationHandoff(String targetAllocationId) {  
     * The current operation primary term. Management of this value is done through {@link IndexShard} and must only be done when safe. See  
                    if (retentionLease != null) {  
            + " and replication group is "
     * Initializes the global checkpoint tracker in primary mode (see {@link #primaryMode}. Called on primary activation or promotion.  
            notifyAllWaiters();
                + localCheckpoint
                    final RetentionLease retentionLease = retentionLeases.get(getPeerRecoveryRetentionLeaseId(shardRouting));
        assert primaryMode;
        final String source,
    ) {  
import java.util.Set;
    }
    public synchronized Set<SegmentReplicationShardStats> getSegmentReplicationStats() {
     * to influence the list of in-sync shard copies here, this could possibly remove such an in-sync copy from the internal structures
                                    primaryAllocationId,
        public CheckpointState(StreamInput in) throws IOException {
        return pendingInSync.isEmpty() == false;  
                    minLocalCheckpoint = Math.min(cps.localCheckpoint, minLocalCheckpoint);
        assert replicationGroup == null || replicationGroup.equals(calculateReplicationGroup())
                        logger.trace("createMissingPeerRecoveryRetentionLeases: adding missing lease for {}", shardRouting);
     */
    /**  
     * @throws RetentionLeaseAlreadyExistsException if the specified retention lease already exists  
        this.hasAllPeerRecoveryRetentionLeases = indexSettings.isSoftDeleteEnabled()
         */  
    /**
            .filter(ShardRouting::assignedToNode)
     * primary relocation handoff.
        final Function<String, Boolean> isShardOnRemoteEnabledNode
import org.opensearch.index.store.Store;
    public synchronized Tuple<Boolean, RetentionLeases> getRetentionLeases(final boolean expireLeases) {
                /*
                        return true;
        assert !primaryMode || globalCheckpoint == computeGlobalCheckpoint(pendingInSync, checkpoints.values(), globalCheckpoint)
            .collect(Collectors.groupingBy(lease -> {
            && checkpoints.get(shardAllocationId).localCheckpoint == SequenceNumbers.UNASSIGNED_SEQ_NO : "expected "
            final List<ShardRouting> shardRoutings = routingTable.assignedShards()  
                setCreatedMissingRetentionLeases();  
                        groupedActionListener.onResponse(null);  
     *  
            cps.inSync = true;
        assert primaryMode;  
        }
                }
        // Missing routing entries are filtered by getUnavailableInSyncShards() before this method is called.
            );
        // NB safeCommitInfo.docCount is a very low-level count of the docs in the index, and in particular if this shard contains nested
            // can happen if replica was removed from cluster but recovery process is unaware of it yet  
                    return fallback;
        assert invariant();  
        synchronized (this) {  
        boolean increasedLocalCheckpoint = updateLocalCheckpoint(allocationId, cps, localCheckpoint);
        for (String aId : pendingInSync) {  
     * window between primary activation and async lease creation via ensurePeerRecoveryRetentionLeasesExist().
                        + retentionLeases.get(getPeerRecoveryRetentionLeaseId(shardRouting)).source()  
                }
    /**
                .removeIf(aid -> !inSyncAllocationIds.contains(aid) && !initializingAllocationIds.contains(aid));
            this.latestReplicationCheckpoint = checkpoint;
                    + " that have no matching entries in "
                - Any shards that are out of sync or unavailable (shard marked in-sync but has not been assigned to a node).
     */
                        () -> new ParameterizedMessage(  
    /**  
         */  
            if (getRetentionLeases().contains(sourceLeaseId) == false) {
     * in which case the missing leases should be created asynchronously by the caller using
        this.isShardOnRemoteEnabledNode = isShardOnRemoteEnabledNode;
            this.checkpointTimers = ConcurrentCollections.newConcurrentMap();
            pendingInSync.remove(allocationId);
            boolean removedEntries = checkpoints.keySet()
                        logger.trace("expiring unreasonable [{}] retaining history before [{}]", lease, minimumReasonableRetainedSeqNo);  
        assert indexSettings.isSegRepEnabledOrRemoteNode();
        this.operationPrimaryTerm = operationPrimaryTerm;
        final OptionalLong value = reducer.apply(
     * current global checkpoint.
     */
                    }  
    public RetentionLeases loadRetentionLeases(final Path path) throws IOException {
            });  
        public String toString() {  
            throw new RetentionLeaseInvalidRetainingSeqNoException(id, source, retainingSequenceNumber, existingRetentionLease);
            result = 31 * result + checkpoints.hashCode();
     * @return the new retention lease
                .filter(  
     */
     * but the replication group still has other shards in docrep nodes
            leaseIdsForCurrentPeers = routingTable.assignedShards()
            if (clusterStateVersion != that.clusterStateVersion) return false;  
     * - An active replica shard is moved to primary mode (using {@link #activatePrimaryMode}) once it is promoted to primary.  
        assert newVersion == 0 || indexSettings.isRemoteTranslogStoreEnabled()  
        // has the same seqno, so we may be overestimating the cost of a file-based recovery when compared to an ops-based recovery and
    public synchronized Map<String, Long> getInSyncGlobalCheckpoints() {
     */
    /**  
        @Override
        assert invariant();
                .stream()  
                + ", checkpoints="
            assert !pendingInSync.contains(entry.getKey()) || !entry.getValue().inSync : "shard copy "
     * {@link ReplicationTracker#createMissingPeerRecoveryRetentionLeases(ActionListener)}.
            + localCheckpoint  
     */
 * specific language governing permissions and limitations
                + ", replicated="  
        assert !primaryMode || globalCheckpoint <= inSyncCheckpointStates(checkpoints, CheckpointState::getLocalCheckpoint, LongStream::min)  
        this.checkpoints = new HashMap<>(1 + indexSettings.getNumberOfReplicas());  
            return new CheckpointState(localCheckpoint, globalCheckpoint, inSync, tracked, replicated);
     *
        );
        // if it was already in-sync (because of a previously failed recovery attempt), global checkpoint must have been
        this(  
            out.writeBoolean(tracked);
            cps.globalCheckpoint = SequenceNumbers.UNASSIGNED_SEQ_NO;  
                visibleCheckpoint,
                                    assignedToRemoteStoreNode(routingTable, initializingId)
        onReplicationGroupUpdated.accept(newReplicationGroup);
         * The currently searchable replication checkpoint.
                    ) : "incorrect source ["
    *  
    private final Object retentionLeasePersistenceLock = new Object();
        if (replicationGroup == null) {
     *                                                      the retaining sequence number of the current retention lease.
                innerAddRetentionLease(
                    if (leaseIdsForCurrentPeers.contains(lease.id())) {
            }
                out.writeBoolean(replicated);  
        }
            return globalCheckpoint;
    /**
            && checkpoints.get(shardAllocationId).inSync  
 * them, and before this primary shard has been notified of this fact, we also include shards that have completed recovery. These shards  
    }
                allocationId,
                    + " vs "
            throw new RetentionLeaseAlreadyExistsException(id);
                    // unassigned in-sync replica
    public RetentionLeases getRetentionLeases() {
     * context from the primary relocation source to the target and initializing the target, it is possible for the target to apply a  
    private boolean isReplicated(  
     * leases.  
     * The reason for this is that the handoff might fail and can be aborted (using {@link #abortRelocationHandoff}), in which case  
        return indexSettings().isRemoteTranslogStoreEnabled()
        return cloneRetentionLease(  
    /**
    }
        logger.debug("expiring retention leases [{}] from current retention leases [{}]", expiredLeases, retentionLeases);  
     * Fetch stats on segment replication.  
    public synchronized void initiateTracking(final String allocationId) {  
    /**
            cps.checkpointTimers.entrySet().removeIf((entry) -> {
         * whether this shard is tracked in the replication group and has localTranslog, i.e., should receive document updates
            for (ShardRouting shardRouting : routingTable) {  
    private boolean createdMissingRetentionLeases;
        // If assigned to a remote node, returns true if given allocation id matches the primary or it's relocation target allocation  
    }
    /**
     * A callback invoked when the in-memory global checkpoint is updated. For primary mode this occurs if the computed global checkpoint  
import java.util.function.BiConsumer;
        assert invariant();
        }
            listener
    public long getOperationPrimaryTerm() {
                }  
                .map(entry -> buildShardStats(entry.getKey(), entry.getValue()))
        assert localCheckpoint >= SequenceNumbers.NO_OPS_PERFORMED : "invalid local checkpoint ["
        // the primary calculates the non-expired retention leases and syncs them to replicas
import java.util.OptionalLong;
            listener  
    public ReplicationTracker(  
    /**
            logger.trace("updated global checkpoint from [{}] to [{}] due to [{}]", previousGlobalCheckpoint, globalCheckpoint, reason);  
    public synchronized void renewPeerRecoveryRetentionLeases() {  
    }
                            localCheckpoint,
            result = 31 * result + Long.hashCode(globalCheckpoint);
            this.globalCheckpoint = globalCheckpoint;
        final long lastAppliedClusterStateVersion = appliedClusterStateVersion;
     * @param sourceLeaseId the identifier of the source retention lease
         */
    /**
     *  
     *   the shard becomes active.
     *
        }
        assert minLocalCheckpoint != Long.MAX_VALUE;
     *
        // For other case which is local translog, return true as the requests are replicated to all shards in the replication group.
     * Computes the global checkpoint based on the given local checkpoints. In case where there are entries preventing the
                        final long localCheckpoint = SequenceNumbers.UNASSIGNED_SEQ_NO;  
        this.fileBasedRecoveryThreshold = IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.get(indexSettings.getSettings());  
     */
        @Override
            throw new IllegalStateException("no local checkpoint tracking information available");
        } else {  
                                inSyncId,
        boolean replicated;
     * @return the renewed retention lease
        }
    private final Function<String, Boolean> isShardOnRemoteEnabledNode;
        assert cps.tracked : "shard copy " + allocationId + " cannot be marked as in-sync as it's not tracked";
        return checkpoints.get(allocationId);
                + routingTable
    private long persistedRetentionLeasesVersion;
                                && isShardOnRemoteEnabledNode.apply(routingTable.getByAllocationId(entry.getKey()).currentNodeId())))  
         * primary.
                    && replicationGroup.getUnavailableInSyncShards().contains(allocationId) == false
import java.util.function.LongSupplier;
    public synchronized void createMissingPeerRecoveryRetentionLeases(ActionListener<Void> listener) {  
    }
                : "update from cluster-manager in primary mode contains in-sync ids "  
                    final long localCheckpoint = SequenceNumbers.UNASSIGNED_SEQ_NO;
        return relocated;
     * @throws RetentionLeaseAlreadyExistsException if the specified retention lease already exists
    public synchronized void resetHasAllPeerRecoveryRetentionLeases() {
    }
            + routingTable;  
         * Peer-recovery retention leases never expire while the associated shard is assigned, but we must still renew them occasionally in
    public synchronized void updateFromClusterManager(
 * not use this file except in compliance with the License.
import org.opensearch.index.shard.ReplicationGroup;
    }
         * Returns a full copy of this object
            this.routingTable = routingTable;
     */
                    && cps.checkpointTimers.get(latestReplicationCheckpoint).startTime() == 0) {
                            + " as in-sync but it does not exist locally";
    public void removePeerRecoveryRetentionLease(String nodeId, ActionListener<ReplicationResponse> listener) {
     * - An initializing primary shard that is not a relocation target is moved to primary mode (using {@link #activatePrimaryMode}) once
            && replicationGroup.getReplicationTargets()
                if (cps.tracked && cps.replicated) {  
     */
     * A callback when a new retention lease is created or an existing retention lease is removed. In practice, this callback invokes the
     * Marks a relocation handoff attempt as successful. Moves the tracker into replica mode.
        assert RetentionLeases.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, path) != null;
            return true;
                            localCheckpoint,  
                .collect(Collectors.toList())
     */
                    entry -> entry.getKey().equals(this.shardAllocationId) == false
                    && latestReplicationCheckpoint.isAheadOf(cps.visibleReplicationCheckpoint)
            return Tuple.tuple(false, retentionLeases);
    /**
     */
            bytesBehind,
import org.opensearch.indices.replication.common.SegmentReplicationLagTimer;
     * The flag will be set back to true when createMissingPeerRecoveryRetentionLeases(ActionListener) completes.  
        /**  
        // the routing table and replication group is set when the global checkpoint tracker operates in primary mode
            globalCheckpoint + 1,
         */
                        || isShardOnRemoteEnabledNode.apply(routingTable.getByAllocationId(allocationId).currentNodeId()))) {  
    /**
                            false,
                    logger.trace(
    public long getGlobalCheckpoint() {  
     * Notifies the service to update the local checkpoint for the shard with the provided allocation ID. If the checkpoint is lower than
        final ShardId shardId,
            listener.onResponse(null);
            .anyMatch(shardRouting -> {  
    /**
    }  
                    lastFinished.set(Math.max(lastFinished.get(), timer.totalElapsedTime()));  
                    );
        }  
        final BiConsumer<RetentionLeases, ActionListener<ReplicationResponse>> onSyncRetentionLeases,
        );
     * Whether the are shards blocking global checkpoint advancement.
        final long operationPrimaryTerm,
            }
    }  
                            // we are in the process of recovering it again, or maybe we were just promoted and have not yet received the
     * - A primary relocation target is moved to primary mode (using {@link #activateWithPrimaryContext}) during the primary relocation
    /**  
                                + " according to "  
     * information is conveyed through cluster state updates, and the new primary relocation target will also eventually learn about those.
    public boolean assertRetentionLeasesPersisted(final Path path) throws IOException {  
            this.globalCheckpoint = in.readZLong();
     * @param id                      the identifier of the retention lease
            onGlobalCheckpointUpdated,  
import org.opensearch.index.shard.AbstractIndexShardComponent;
                ? cps.checkpointTimers.values().stream().mapToLong(SegmentReplicationLagTimer::totalElapsedTime).max().orElse(0)
        }  
        if (primaryContext.checkpoints.containsKey(shardAllocationId) == false) {
            && routingTable.assignedShards()
                && isShardOnRemoteEnabledNode.apply(routingTable.getByAllocationId(allocationId).currentNodeId()));
        long localCheckpoint;  
     * it is important that the global checkpoint tracker does not miss any state updates that might happened during the handoff attempt.
        String primaryTargetAllocationId,  
    }  
                                PEER_RECOVERY_RETENTION_LEASE_SOURCE
     * Boolean flag that indicates if a relocation handoff is in progress. A handoff is started by calling  
        assert invariant();  
     * @param checkpoint {@link ReplicationCheckpoint}  
            assert PEER_RECOVERY_RETENTION_LEASE_SOURCE.equals(source) == false : "renewing peer recovery retention lease ["
    public void persistRetentionLeases(final Path path) throws WriteStateException {
        // all pending in sync shards are tracked
     */  
                }  
        primaryMode = true;  
    }  
     * Returns whether the requests are replicated considering the remote translog existence, current/primary/primary target allocation ids.
        final RetentionLease retentionLease;
        }  
        // during relocation handoff there are no entries blocking global checkpoint advancement  
    public List<RetentionLease> getPeerRecoveryRetentionLeases() {
            updateGlobalCheckpointOnPrimary();  
                     * create peer recovery retention leases for every shard copy.
            } else {
        for (Map.Entry<String, CheckpointState> entry : primaryContext.checkpoints.entrySet()) {
     * Removes an existing retention lease.
                            isReplicated(  
        // forget all checkpoint information  
     * in-sync shard copies cannot grow, otherwise the relocation target might miss this information and increase the global checkpoint
    */
        }  
            + localCheckpoint;  
                }
    /**
    /**
                    }
        }
    private synchronized void updateGlobalCheckpointOnPrimary() {  
                for (String initializingId : initializingAllocationIds) {
    /**  
            .filter(r -> r.isSearchOnly() == false)
        public PrimaryContext(long clusterStateVersion, Map<String, CheckpointState> checkpoints, IndexShardRoutingTable routingTable) {
    /**
                + existingRetentionLease
                        + "] for ["
            retentionLeases.version() + 1,
            return "PrimaryContext{"
    private boolean hasAllPeerRecoveryRetentionLeases;
            : Collections.emptyList();
import org.opensearch.core.index.shard.ShardId;
                        }
    /**
                if (result) {  
        this.globalCheckpoint = globalCheckpoint;
        @Override
    }
                    && cps.checkpointTimers.containsKey(latestReplicationCheckpoint)  
                    cps.checkpointTimers.get(latestReplicationCheckpoint).start();
     * @return the new retention lease
                .mapToLong(function)  
        return retentionLease;
        final RetentionLease retentionLease = new RetentionLease(
    ) {
        Objects.requireNonNull(listener);
    ) {
        long globalCheckpoint,  
            getPeerRecoveryRetentionLeaseId(nodeId),
     * After a new checkpoint is published, start a timer per replica for the checkpoint.
     * - replica: this shard receives global checkpoint information from the primary (see
                cps.visibleReplicationCheckpoint,
     * Update the local knowledge of the visible checkpoint for the specified allocation ID.
     * @throws RetentionLeaseNotFoundException              if the specified retention lease does not exist
            final String primaryAllocationId = primary.allocationId().getId();
            + " but replication group is "
        ReplicationCheckpoint visibleReplicationCheckpoint;
         * persisted and the resulting IO can be expensive on nodes with large numbers of shards (see #42299). We choose to renew them after
                                getPeerRecoveryRetentionLeaseId(shardRouting),
        return shardRouting != null && (shardRouting.active() == false || shardRouting.primary() || shardRouting.isSearchOnly());  
     */
    }
 * have received all old operations via the recovery mechanism and are kept up to date by the various replications actions. The set of
        assert invariant();
    }
/**
            + "] for shard copy ["
        return Tuple.tuple(true, retentionLeases);
    public synchronized void startReplicationLagTimers(ReplicationCheckpoint checkpoint) {
            || replicationGroup.getReplicationTargets()
     *  
                        return true;  
            + " but was "
                            latestReplicationCheckpoint,
            retentionLeases = RetentionLeases.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, path);
                updateGlobalCheckpointOnPrimary();  
 * shards that are taken into account for the global checkpoint calculation are called the "in-sync shards".
        updateReplicationGroupAndNotify();
     *  
        // initializeWithPrimaryContext, we might still have missed a cluster state update. This is best effort.  
            // early out as no retention leases have expired
                .stream()  
    public RetentionLease cloneLocalPeerRecoveryRetentionLease(String nodeId, ActionListener<ReplicationResponse> listener) {
         */
    }
    private void updateReplicationGroupAndNotify() {
            || checkpoints.entrySet().stream().filter(e -> e.getValue().tracked).allMatch(e -> e.getValue().replicated)
     * @throws RetentionLeaseNotFoundException      if the specified source retention lease does not exist
            assert !primaryMode
                .stream()
        Map<ReplicationCheckpoint, SegmentReplicationLagTimer> checkpointTimers;
    /**
        });
                            cps.checkpointTimers.keySet()
        public long getGlobalCheckpoint() {  
        if (existingRetentionLease == null) {  
                    }  
        );  
    }  
            int result = Long.hashCode(clusterStateVersion);
        assert primaryMode;
        assert primaryMode;
                    hasAllPeerRecoveryRetentionLeases = true;
     * Represents the sequence number component of the primary context. This is the knowledge on the primary of the in-sync and initializing
        Objects.requireNonNull(listener);
            );
    /**
     * Adds a new retention lease.
     * Update the local knowledge of the persisted global checkpoint for the specified allocation ID.
                            new CheckpointState(
                String allocationId = e.getKey();  
        this.onReplicationGroupUpdated = onReplicationGroupUpdated;
        addPeerRecoveryRetentionLeaseForSolePrimary();
                        }
    private synchronized void waitForLocalCheckpointToAdvance() throws InterruptedException {
     */
    volatile ReplicationGroup replicationGroup;  
        public long clusterStateVersion() {
        }
    }
    ) {  
        assert primaryMode;  
            retentionLeases.version() + 1,
        final long applyingClusterStateVersion,  
     * @param inSyncAllocationIds         the allocation IDs of the currently in-sync shard copies
     */
        }
     * When a shard is initialized (be it a primary or replica), it initially operates in replica mode. The global checkpoint tracker is
import java.util.function.ToLongFunction;
                        } else {  
                                + retentionLease
     */
                        */
    public static class CheckpointState implements Writeable {
                        retentionLeases.get(getPeerRecoveryRetentionLeaseId(shardRouting)).source()
            return routingTable;
     *   {@link #updateGlobalCheckpointOnReplica(long, String)}).
                            );
     * Wait for the local checkpoint to advance to the global checkpoint.  
                            initializingId,  
        Objects.requireNonNull(listener);  
                    PEER_RECOVERY_RETENTION_LEASE_SOURCE
        assert pendingInSync.contains(allocationId) == false : "shard copy " + allocationId + " is already marked as pending in-sync";
        assert Version.V_EMPTY.equals(indexSettings.getIndexVersionCreated()) == false;
        // Handle migration cases. Ignore assertion if any of the shard copies in the replication group is assigned to a remote node
        assert invariant();
     * has been run successfully
import java.io.IOException;
                    final SegmentReplicationLagTimer timer = entry.getValue();
            }
import java.util.stream.Collectors;
import java.util.function.Function;  
                    pendingInSync.removeIf(aId -> checkpoints.containsKey(aId) == false);
        /**
        final Map<Boolean, List<RetentionLease>> partitionByExpiration = retentionLeases.leases()  
        final Runnable runAfter = getClusterManagerUpdateOperationFromCurrentState();
 */
        // copy clusterStateVersion and checkpoints and return
        return new ReplicationGroup(
                : null;
     * Cached value for the last replication group that was computed
     */
        return value.isPresent() ? value.getAsLong() : SequenceNumbers.UNASSIGNED_SEQ_NO;  
        });
        return globalCheckpoints;
}
        cps.visibleReplicationCheckpoint = visibleCheckpoint;  
        } else {
                if (retentionLeases.supersedes(persistedRetentionLeasesPrimaryTerm, persistedRetentionLeasesVersion) == false) {
                + " but was: "
                    return;
            retainingSequenceNumber,
    * @opensearch.api
     */
        // all assigned shards from the routing table are tracked
    /**
                this.replicated = in.readBoolean();
     *
        final CheckpointState cps = checkpoints.get(allocationId);
    /**  
    /**  
    private void createReplicationLagTimers() {  
import org.opensearch.core.action.ActionListener;
            if (routingTable.equals(that.routingTable)) return false;
                pendingInSync.remove(allocationId);  
    public synchronized void updateGlobalCheckpointForShard(final String allocationId, final long globalCheckpoint) {  
     */  
    // A recovery target can be marked in-sync before its routing transitions from INITIALIZING to STARTED. Track replication lag
 *
     * objective to transfer the internal state of the global checkpoint tracker from the relocation source to the target, the list of  
        final String leaseId = getPeerRecoveryRetentionLeaseId(primaryShard);  
        final Set<String> inSyncAllocationIds = new HashSet<>();  
        // local checkpoints only set during primary mode
import org.opensearch.index.store.StoreFileMetadata;  
         * the last global checkpoint information that we have for this shard. This is the global checkpoint that's fsynced to disk on the  
        this.wait();  
        assert indexSettings.isSegRepEnabledOrRemoteNode();
    public RetentionLease addRetentionLease(
        if (cps != null && globalCheckpoint > cps.globalCheckpoint) {  
                + " to have initialized entry in "  
     *
            if (primaryMode) {
        @Override
            this.tracked = tracked;  
        final String allocationId,
        final long retentionLeaseMillis = indexSettings.getRetentionLeaseMillis();  
                allocationId,
        }
        final long fallback
    }
        synchronized (this) {
        String allocationId,
        assert handoffInProgress == false;  
     * This means, however, that the global checkpoint can still advance after the primary relocation handoff has been initiated, but only
        assert !handoffInProgress || primaryMode;
     * allocation ID to catch up to the global checkpoint.
        // entries blocking global checkpoint advancement can only exist in primary mode and when not having a relocation handoff
        return getRetentionLeases(false).v2();  
         */  
        }
                        /*Check if the current primary shard is migrating to remote and
            operationPrimaryTerm,
    /**
     *
            routingTable,  
        addPeerRecoveryRetentionLeaseForSolePrimary();
                    assert retentionLeases.contains(getPeerRecoveryRetentionLeaseId(shardRouting))
            final AtomicLong lastFinished = new AtomicLong(0L);  
            return fallback;
     * Id for a peer recovery retention lease for the given node. See {@link ReplicationTracker#addPeerRecoveryRetentionLease}.
                    );
                + globalCheckpoint;  
                final CheckpointState cps = e.getValue();
            updateReplicationGroupAndNotify();
        // TODO improve this measure for when nested docs are in use
    public void removeRetentionLease(final String id, final ActionListener<ReplicationResponse> listener) {  
        assert !handoffInProgress || pendingInSync.isEmpty() : "entries blocking global checkpoint advancement during relocation handoff: "
    /**
     */
     * @param onReplicationGroupUpdated a callback when the replica group changes
    private volatile ReplicationCheckpoint latestReplicationCheckpoint;
                + tracked
                + " with a lower retaining sequence number ["
        }  
     */
            + "] is lower than previous one ["
            }
    }
     * The current in-memory global checkpoint. In primary mode, this is a cached version of the checkpoint computed from the local  
                    && shouldSkipReplicationLag(e.getKey()) == false
        final long currentTimeMillis = currentTimeMillisSupplier.getAsLong();
import org.opensearch.index.IndexSettings;
        final LongConsumer onGlobalCheckpointUpdated,  
        synchronized (this) {  
        if (retentionLeases.contains(id)) {
            // Compute the max lag from the set of completed timers.
     * @param allocationId     the allocation ID to update the global checkpoint for  
                            addPeerRecoveryRetentionLease(
     * because the cluster-manager could have failed some of the in-sync shard copies and marked them as stale. That is ok though, as this  
                .collect(Collectors.toSet());  
         * contributes to global checkpoint calculation on the primary iff {@link CheckpointState#replicated} is true.  
    /**
                + "localCheckpoint="
        // Skip assertion if createMissingPeerRecoveryRetentionLeases has not yet run after activating primary context
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                        || checkpoints.get(shardRouting.allocationId().getId()).tracked == false  
    }
     * Initiates a relocation handoff and returns the corresponding primary context.
 * The global checkpoint is maintained by the primary shard and is replicated to all the replicas (via {@link GlobalCheckpointSyncAction}).
    public synchronized void abortRelocationHandoff() {
        final Set<String> leaseIdsForCurrentPeers;
        assert primaryMode;
        checkpoints.forEach((key, cps) -> {
                cps.localCheckpoint,  
     * @param reason              the reason the global checkpoint was updated
        return replicationGroup;
    volatile boolean primaryMode;  
        }  
                            renewRetentionLease(
     * {@link IndexSettings#FILE_BASED_RECOVERY_THRESHOLD_SETTING}.
     * @param primaryAllocationId       primary allocation id
        assert indexSettings.isSegRepEnabledOrRemoteNode();  
     * @param globalCheckpoint the global checkpoint
                } else {  
     * A supplier of the current time. This supplier is used to add a timestamp to retention leases, and to determine retention lease
     * @param routingTable                the shard routing table  
                                + shardRouting;  
        hasAllPeerRecoveryRetentionLeases = true;
                setHasAllPeerRecoveryRetentionLeases();
                        )  
    public synchronized CheckpointState getTrackedLocalCheckpointForShard(String allocationId) {  
    private RetentionLease innerAddRetentionLease(String id, long retainingSequenceNumber, String source) {
        assert pendingInSync.isEmpty() || (primaryMode && !handoffInProgress);
    }
    /**  
    }  
        assert (routingTable == null) == (replicationGroup == null) : "routing table is "  
    }
     * @param id       the identifier of the retention lease  
            if (this == o) return true;
        boolean createMissingRetentionLeasesDuringMigration = indexSettings.isAssignedOnRemoteNode()
     * @throws WriteStateException if an exception occurs writing the state file
     */  
                .stream()
                        && replicationGroup.getUnavailableInSyncShards().contains(entry.getKey()) == false  
            final GroupedActionListener<ReplicationResponse> groupedActionListener = new GroupedActionListener<>(ActionListener.wrap(vs -> {
     * - We just did a rolling upgrade from a version prior to {@code LegacyESVersion#V_7_4_0} that does not create peer-recovery retention leases.
                        && (indexSettings.isRemoteStoreEnabled()  
        if (cps == null) {
        this.routingTable = null;
        assert primaryMode;
        handoffInProgress = false;
            if (this == o) return true;
    /**
            final RetentionLeases currentRetentionLeases;  
        final boolean renewalNeeded = StreamSupport.stream(routingTable.spliterator(), false)  
        public void writeTo(StreamOutput out) throws IOException {  
        public String toString() {
     * advances on the basis of state changes tracked here. For non-primary mode this occurs if the local knowledge of the global checkpoint
    }
                assert hasAllPeerRecoveryRetentionLeases == false : routingTable + " vs " + retentionLeases;  
     * {@link SequenceNumbers#UNASSIGNED_SEQ_NO}.
            return routingTable.equals(that.routingTable);
                + " when activating primary";
import org.opensearch.core.common.io.stream.StreamOutput;  
            return false;  
        Function<LongStream, OptionalLong> reducer  
     * @return the replication mode.
        assert invariant();
    }  
            cps.globalCheckpoint = globalCheckpoint;
    }  
        assert invariant();
            + pendingInSync;
                + checkpoints
     * <p>  
            this.localCheckpoint = localCheckpoint;  
    public long getAsLong() {
    /**  
            return result;
                    timer.stop();
    }
 * This class is responsible for tracking the replication group with its progress and safety markers (local and global checkpoints).
 *
                        : "no retention lease for tracked shard [" + shardRouting + "] in " + retentionLeases;
        );
            final String primaryTargetAllocationId = primary.relocating()  
            return RetentionLeases.EMPTY;
/*
            .forEach(e -> globalCheckpoints.put(e.getKey(), e.getValue().globalCheckpoint));  
                        initializingId,  
        assert routingTable == null || checkpoints.keySet().containsAll(routingTable.getAllAllocationIds()) : "local checkpoints "  
            }
            .collect(Collectors.toList());
        assert handoffInProgress == false;  
     * with sequence numbers strictly greater than the given global checkpoint.
                + '}';
            )
     * @throws RetentionLeaseInvalidRetainingSeqNoException if the new retaining sequence number is lower than  
 * @opensearch.internal  
    /**
                }
        super(shardId, indexSettings);
        logger.debug("adding new retention lease [{}] to current retention leases [{}]", retentionLease, retentionLeases);
    public ReplicationTracker(  
        assert !primaryMode || checkpoints.get(shardAllocationId).inSync;
        }
                : 0,  
                .collect(Collectors.toUnmodifiableSet());  
        final Map<String, Long> globalCheckpoints = new HashMap<>(checkpoints.size()); // upper bound on the size
            + allocationId
     * @param allocationId              given allocation id
            cps.inSync = true;  
    private final LongSupplier currentTimeMillisSupplier;
     *            checkpoint based on the local checkpoints of all in-sync shard copies.  
     */
            );
                        checkpoints.put(
    ) {
import java.util.List;
     * @param operationPrimaryTerm the new operation primary term
            for (ShardRouting shardRouting : shardRoutings) {  
     * A notable exception to this is the method {@link #updateFromClusterManager}, which is still allowed to be called during a relocation handoff.
                    checkpoints.put(  
        if (applyingClusterStateVersion > appliedClusterStateVersion) {
import java.util.function.LongConsumer;
     * {@link #setOperationPrimaryTerm(long)}.
        }
         * When a shard is in-sync, it is capable of being promoted as the primary during a failover. An in-sync shard
     * Loads the latest retention leases from their dedicated state file.
            getPeerRecoveryRetentionLeaseId(nodeId),
        CheckpointState cps = checkpoints.get(allocationId);
            globalCheckpoint = newGlobalCheckpoint;
        assert !this.shardAllocationId.equals(allocationId) || cps != null;
            retentionLeases = new RetentionLeases(  
     * @return the primary term  
                        inSyncId,
                while (true) {
        retentionLeases = new RetentionLeases(  
            || (routingTable.primaryShard().allocationId().getId().equals(shardAllocationId)  
    public RetentionLease addPeerRecoveryRetentionLease(
        // and the replication group has at-least one shard copy in docrep enabled node
                if (removedEntries) {
    private static long computeGlobalCheckpoint(
     */
     * Returns a list of peer recovery retention leases installed in this replication group
     * @param retainingSequenceNumber the retaining sequence number
    public synchronized void completeRelocationHandoff() {
    private final LongConsumer onGlobalCheckpointUpdated;
    @SuppressForbidden(reason = "Object#notifyAll waiters for local checkpoint advancement")  
        if (globalCheckpoint != computedGlobalCheckpoint) {
    /**
         * case the associated shard is temporarily unassigned. However we must not renew them too often, since each renewal must be  
                        && entry.getValue().inSync
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + computeGlobalCheckpoint(pendingInSync, checkpoints.values(), globalCheckpoint)
            currentTimeMillisSupplier.getAsLong(),
                .filter(v -> v != SequenceNumbers.UNASSIGNED_SEQ_NO)
    public ReplicationCheckpoint getLatestReplicationCheckpoint() {  
            return clusterStateVersion;
                    && latestReplicationCheckpoint.isAheadOf(cps.visibleReplicationCheckpoint)
        assert invariant();  
            id,
                    assert PEER_RECOVERY_RETENTION_LEASE_SOURCE.equals(  
     */
        }
                "skipped updating local checkpoint of [{}] from [{}] to [{}], current checkpoint is higher",
                }  
     * Creates a peer recovery retention lease for this shard, if one does not already exist and this shard is the sole
            logger.trace(  
    private RetentionLeases retentionLeases = RetentionLeases.EMPTY;
     * Scans through the currently known local checkpoint and updates the global checkpoint accordingly.
                notifyAllWaiters();
    final Set<String> pendingInSync;
     *
    /**  
                + "]";  
        this.currentTimeMillisSupplier = Objects.requireNonNull(currentTimeMillisSupplier);
            final ShardRouting primary = routingTable.primaryShard();
        long newVersion;  
                if (cps.inSync
            indexSettings,  
    private synchronized void setHasAllPeerRecoveryRetentionLeases() {  
                    final long globalCheckpoint = localCheckpoint;
import java.util.Collections;
            // blocking global checkpoint advancement only happens for shards that are not in-sync  
                // it is possible for a shard to be in-sync but not yet removed from the checkpoints collection after a failover event.  
import org.opensearch.core.common.io.stream.StreamInput;
    }
            () -> new ParameterizedMessage(
package org.opensearch.index.seqno;
    }
import java.util.HashSet;  
            cps.checkpointTimers.size(),
        // This is required since during an ongoing remote store migration,  
        final LongSupplier currentTimeMillisSupplier,
            return Tuple.tuple(false, retentionLeases);
    }
        }  
                - (For remote store enabled clusters) Any shard that is not yet migrated to remote store enabled nodes during migration
        final RetentionLeases retentionLeases;  
     * - In a mixed mode cluster (during remote store migration), a remote enabled primary shard copy fails over to another remote enabled shard copy,  
                || indexSettings.isAssignedOnRemoteNode()) {  
                        )
                        && shouldSkipReplicationLag(entry.getKey()) == false
        final String allocationId,
                .map(ShardRouting::allocationId)
 * the Apache License, Version 2.0 (the "License"); you may
        assert Thread.holdsLock(this);
            id,
        assert invariant();
                hasAllPeerRecoveryRetentionLeases = true;  
     * @param primaryContext the primary context used to initialize the state  
        final Consumer<ReplicationGroup> onReplicationGroupUpdated,
        );
import org.opensearch.cluster.routing.AllocationId;  
    }
    public boolean isPrimaryMode() {
            if (replicationGroup.getReplicationTargets().equals(Collections.singletonList(primaryShard))
     * @param primaryTargetAllocationId primary target allocation id  
        } else {
        return retentionLeases;
    /**
        assert invariant();  
import java.util.function.Consumer;
                + "clusterStateVersion="
            if (localCheckpoint != that.localCheckpoint) return false;  
     */
     * Notify all threads waiting on the monitor on this tracker. These threads should be waiting for the local checkpoint on a specific  
    /**
     */
        public CheckpointState copy() {
        return safeCommitInfo.localCheckpoint + 1 - Math.round(Math.ceil(safeCommitInfo.docCount * fileBasedRecoveryThreshold));
    }
    }
                    final CheckpointState checkpointState = checkpoints.get(shardRouting.allocationId().getId());
                listener.onResponse(null);
        }
            leaseIdsForCurrentPeers = Collections.singleton(getPeerRecoveryRetentionLeaseId(routingTable.primaryShard().currentNodeId()));  
            // remove entries which don't exist on cluster-manager
        }
     */
            isShardOnRemoteEnabledNode
        }  
         * from the primary. Tracked shards with localTranslog would have corresponding retention leases on the primary shard's  
    public ReplicationGroup getReplicationGroup() {
            result = 31 * result + Boolean.hashCode(replicated);
        runAfter.run();
    private void addPeerRecoveryRetentionLeaseForSolePrimary() {
            return this.checkpoints.entrySet()
     * @param id                      the identifier of the retention lease
                .filter(shardRouting -> shardRouting.isSearchOnly() == false)  
     * {@link ReplicationTracker#createMissingPeerRecoveryRetentionLeases(ActionListener)} has not yet completed. Is only permitted
            assert primaryMode;
        return retentionLease;  
     *  
         * half the expiry time, so that by default the cluster has at least 6 hours to recover before these leases start to expire.
     * @return a tuple indicating whether or not any retention leases were expired, and the non-expired retention leases  
        assert primaryMode;
                + ", routingTable="  
                        logger.trace("expiring unused [{}]", lease);
        // update on the relocation target once relocation completes). We could alternatively also copy the map as-is (it’s safe), and it
     */
 * Licensed to Elasticsearch under one or more contributor  
        // the computed global checkpoint is always up-to-date
            }));
            logger.trace("updated local checkpoint of [{}] from [{}] to [{}]", allocationId, cps.localCheckpoint, localCheckpoint);
    public synchronized void updateRetentionLeasesOnReplica(final RetentionLeases retentionLeases) {  
            result = 31 * result + Boolean.hashCode(inSync);
        if (retentionLeases == null) {
        if (retentionLeases.get(leaseId) == null) {
     *  
        assert primaryMode == false;
        @Override
                }
                            // global checkpoints from our peers.  
    public synchronized void updateVisibleCheckpointForShard(final String allocationId, final ReplicationCheckpoint visibleCheckpoint) {  
        );
                + checkpoints
     * is, either from the constructor of {@link IndexShard} or while holding all permits on the {@link IndexShard} instance.
     * @param retainingSequenceNumber the retaining sequence number
        if (checkpoint.equals(latestReplicationCheckpoint) == false) {
                        to the remote enabled nodes. Ensures that:
        assert invariant();
        );
     *  
                        );
        final Collection<RetentionLease> nonExpiredLeases = partitionByExpiration.get(false) != null  
import org.opensearch.action.support.replication.ReplicationResponse;
    /**
    public static final String PEER_RECOVERY_RETENTION_LEASE_SOURCE = "peer recovery";
        assert invariant();
            }  
        if (checkpoint.equals(latestReplicationCheckpoint) == false) {
            if (in.getVersion().onOrAfter(Version.V_2_5_0)) {
            newVersion  
    }  
 * ownership. Elasticsearch licenses this file to you under  
                        && checkpoints.get(shardRouting.allocationId().getId()).replicated == false)
                }
     * @param visibleCheckpoint the visible checkpoint
            return checkpoints;  
                } else {  
        final long computedGlobalCheckpoint = computeGlobalCheckpoint(pendingInSync, checkpoints.values(), getGlobalCheckpoint());
                 */
            Set<String> initializingAllocationIds = routingTable.getAllInitializingShards()
                + ", inSync="
     *  
            || (routingTable.getByAllocationId(allocationId) != null  
            appliedClusterStateVersion = applyingClusterStateVersion;
        updateGlobalCheckpointOnPrimary();  
                                inSync,
        assert invariant();
import java.util.stream.Stream;
            ? partitionByExpiration.get(false)
     */
            + getGlobalCheckpoint()
        if (retainingSequenceNumber < existingRetentionLease.retainingSequenceNumber()) {  
            logger.trace("updated global checkpoint to [{}]", computedGlobalCheckpoint);
        // primary and primary target allocation id.
        // remote enabled primary taking over primary context from another remote enabled shard
        if (pendingInSync.isEmpty() == false) {
     */  
                localCheckpoint
     * @param allocationId     the allocation ID to update the global checkpoint for  
        if (newGlobalCheckpoint > previousGlobalCheckpoint) {
                logger.trace("addPeerRecoveryRetentionLeaseForSolePrimary: adding lease [{}]", leaseId);  
                previousGlobalCheckpoint,  
                                isReplicated(  
     * then persistence is skipped.
    @PublicApi(since = "1.0.0")  
                        - Remote Store settings are not enabled (This would be done after all shard copies migrate to remote enabled nodes)  
        assert invariant();  
            // can happen if replica was removed from cluster but replication process is unaware of it yet
        }  
    }
     */
                .stream()
            routingTable = IndexShardRoutingTable.Builder.readFrom(in);
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        assert invariant();
 *
    /**  
 * Unless required by applicable law or agreed to in writing,
        }
            onGlobalCheckpointUpdated.accept(computedGlobalCheckpoint);
            CheckpointState that = (CheckpointState) o;
     */  
        public int hashCode() {
    }  
    }
     * @return the new retention lease
            logger.trace("marked [{}] as in-sync", allocationId);  
            synchronized (this) {
    }
     * @param source                  the source of the retention lease  
            retentionLease = innerAddRetentionLease(id, retainingSequenceNumber, source);  
                }
        return retentionLease;
     * @param path the path to the directory containing the state file
                + checkpoints
                // notify any waiter for local checkpoint advancement to recheck that their shard is still being tracked.
        return true;  
            .filter(e -> e.getValue().inSync && e.getValue().replicated)
        assert primaryMode;
                 * We got here here via a rolling upgrade from an older version that doesn't create peer recovery retention  
    ) {
     * (warm primary) to prevent assertion failures in renewPeerRecoveryRetentionLeases() during the
    @SuppressForbidden(reason = "Object#wait for local checkpoint advancement")
        boolean tracked;  
        }
     * Updates the global checkpoint on a replica shard after it has been updated by the primary.
    }
    private final double fileBasedRecoveryThreshold;
import java.util.function.Supplier;  
            }  
     * Get all retention leases tracked on this shard.
    }
        /*  
    final String shardAllocationId;
    public synchronized void updateGlobalCheckpointOnReplica(final long newGlobalCheckpoint, final String reason) {  
            cps.visibleReplicationCheckpoint != null ? cps.visibleReplicationCheckpoint.getMetadataMap() : Collections.emptyMap()
            this.checkpoints = checkpoints;  
        CheckpointState cps = checkpoints.get(allocationId);  
            getPeerRecoveryRetentionLeaseId(routingTable.primaryShard()),
        // docs then safeCommitInfo.docCount counts every child doc separately from the parent doc. However every part of a nested document  
        public PrimaryContext(StreamInput in) throws IOException {
     * the currently known one, this is a no-op. If the allocation ID is not tracked, it is ignored.  
        }
            globalCheckpoint,
        public void writeTo(StreamOutput out) throws IOException {
        handoffInProgress = false;  
            .stream()  
            createReplicationLagTimers();
    private boolean assignedToRemoteStoreNode(IndexShardRoutingTable routingTable, String allocationId) {
                            true,
     */
                            )  
        if (expireLeases == false) {  
     * <p>
            }
     * @param applyingClusterStateVersion the cluster state version being applied when updating the allocation IDs from the cluster-manager
        final ShardRouting shardRouting = routingTable.getByAllocationId(allocationId);
            logger.debug("no retention leases are expired from current retention leases [{}]", retentionLeases);  
        synchronized (retentionLeasePersistenceLock) {
            + replicationGroup;
    /**  
            result = 31 * result + Boolean.hashCode(tracked);  
                            )
            + replicationGroup;  
            throw new IllegalStateException("no local checkpoint tracking information available for " + allocationId);
        if (renewalNeeded) {
public class ReplicationTracker extends AbstractIndexShardComponent implements LongSupplier {
     */  
     * to eagerly. As consequence, some of the methods in this class are not allowed to be called while a handoff is in progress,
            out.writeMap(checkpoints, (streamOutput, s) -> out.writeString(s), (streamOutput, cps) -> cps.writeTo(out));
    private final BiConsumer<RetentionLeases, ActionListener<ReplicationResponse>> onSyncRetentionLeases;
    }  
     * Activates the global checkpoint tracker in primary mode (see {@link #primaryMode}. Called on primary relocation target during  
                    );
     * @param shardId                   the shard ID
            allocationId,
        assert primaryMode;  
        checkpoints.entrySet().forEach(entry -> {
        }
        // note that if there was no cluster state update between start of the engine of this shard and the call to
        String primaryAllocationId,
                        )  
                    assert (checkpoints.get(shardRouting.allocationId().getId()).tracked
     * The version of the most-recently persisted retention leases. This is used to check if we need to persist the current retention
        assert localCheckpoint >= SequenceNumbers.NO_OPS_PERFORMED : "expected known local checkpoint for "  
        for (Map.Entry<String, CheckpointState> entry : checkpoints.entrySet()) {
            result = 31 * result + routingTable.hashCode();  
                    continue;  
     * Returns the current replication group for the shard.
/*  
import org.opensearch.index.SegmentReplicationShardStats;  
     * @param retentionLeases the retention leases
     * Resets hasAllPeerRecoveryRetentionLeases to false. Called when a DFA read-only engine is created  
        synchronized (retentionLeasePersistenceLock) {
                - Any non-active shards which are still recovering.  
            IndexShardRoutingTable.Builder.writeTo(routingTable, out);
                .stream()  
        final ShardId shardId,
        ReplicationGroup newReplicationGroup = calculateReplicationGroup();  
                                initializingId,
        assert invariant();  
            + routingTable  
        assert invariant();
                                    primaryTargetAllocationId,  
            clusterStateVersion = in.readVLong();
        assert !primaryMode
            throw new IllegalStateException("primary context [" + primaryContext + "] does not contain " + shardAllocationId);  
        if (cps.replicated && increasedLocalCheckpoint && pending == false) {  
                }  
    private static long inSyncCheckpointStates(  
                .stream()
        boolean pending = pendingInSync.contains(allocationId);  
     */  
        }  
            + allocationId
     */  
     */
                }
                                shardRouting.currentNodeId(),
        assert primaryMode || checkpoints.values().stream().allMatch(cps -> cps.globalCheckpoint == SequenceNumbers.UNASSIGNED_SEQ_NO);
            operationPrimaryTerm,  
            }
        assert primaryMode;
                retentionLeases.version() + 1,
    /**
                        final boolean inSync = inSyncAllocationIds.contains(initializingId);
            newVersion = replicationGroup.getVersion() + 1;
        appliedClusterStateVersion = primaryContext.clusterStateVersion();
            + cps.localCheckpoint  
            out.writeZLong(globalCheckpoint);
        }  
                    + shardAllocationId;  
        // Create missing RetentionLeases if the primary is on a remote enabled
    public synchronized RetentionLease renewRetentionLease(final String id, final long retainingSequenceNumber, final String source) {  
 * You may obtain a copy of the License at  
                cps.checkpointTimers.keySet()  
     * @return the replication group  
                 */
                    groupedActionListener.onResponse(null);
    /**
    public synchronized void activatePrimaryMode(final long localCheckpoint) {
            shardId,
    /**
    /**  
            if (o == null || getClass() != o.getClass()) return false;
                final CheckpointState cps = checkpoints.get(shardRouting.allocationId().getId());
            // in-sync shard copies are tracked
        this.shardAllocationId = allocationId;  
                }  
     * Returns whether the replication tracker is in primary mode, i.e., whether the current shard is acting as primary from the point of
            throw new IllegalStateException("relocation target [" + targetAllocationId + "] is no longer part of the replication group");
            this.replicated = replicated;
            if (entry.getValue().inSync) {
                boolean result = entry.getKey().isAheadOf(visibleCheckpoint) == false;
                || inSyncAllocationIds.stream().allMatch(inSyncId -> checkpoints.containsKey(inSyncId) && checkpoints.get(inSyncId).inSync)
     * Supplies information about the current safe commit which may be used to expire peer-recovery retention leases.
        }  
     * have been set up locally to track local checkpoint information for the shard and that the shard is added to the replication group.
        updateLocalCheckpoint(allocationId, cps, localCheckpoint);  
                );
        final RetentionLease retentionLease = new RetentionLease(  
     * as a logical operator, many of the invariants are written under the form (!A || B), they should be read as (A implies B) however.
        assert invariant();  
        return globalCheckpoint;
        assert handoffInProgress == false;  
                currentRetentionLeases = retentionLeases;  
     * @param listener      the callback when the retention lease is successfully added and synced to replicas  
                .collect(Collectors.toSet());
     *
                    }
        assert pendingInSync.isEmpty() : "relocation handoff started while there are still shard copies pending in-sync: " + pendingInSync;
            return allocationId.equals(primaryAllocationId) || allocationId.equals(primaryTargetAllocationId);  
    /**
    public synchronized void activateWithPrimaryContext(PrimaryContext primaryContext) {
            return;  
     */
         */
        /**
            bytesBehind > 0L
     * - primary: this shard is in charge of collecting local checkpoint information from all shard copies and computing the global
        // capture current state to possibly replay missed cluster state update
     */
     * until the newer cluster state were to be applied, which would unsafely advance the global checkpoint. This field thus captures  
        public int hashCode() {  
    /**
     * primary shard calculates which leases are expired, and if any have expired, syncs the retention leases to any replicas. If the  
            pending = false;  
     */  
            cps.localCheckpoint = SequenceNumbers.UNASSIGNED_SEQ_NO;
        return retentionLease;
import org.opensearch.common.collect.Tuple;
        // a local checkpoint for a shard copy should be a valid sequence number
     * shards and their local checkpoints.
    }
            }
                logger.debug("{} becoming primary of {} with missing lease: {}", primaryShard, routingTable, retentionLeases);
            return localCheckpoint;  
                }  
        assert primaryMode;
        final Store.RecoveryDiff diff = Store.segmentReplicationDiff(  
                    checkpoints.put(
                )) {
            });
 * software distributed under the License is distributed on an
     * Boolean flag that indicates whether a relocation handoff completed (see {@link #completeRelocationHandoff}).  
                assert primaryShard.allocationId().getId().equals(shardAllocationId) : routingTable.assignedShards()
            // stop any timers for checkpoints up to the received cp and remove from cps.checkpointTimers.
     * V2 - Set of {@link SegmentReplicationShardStats} per shard in this primary's replication group.
         * respective shard, and all operations up to this point are properly fsynced to disk as well.
     * See {@link ReplicationTracker#addPeerRecoveryRetentionLease}.
     */  
                        + shardRouting
            if (primaryMode && removedEntries) {
        assert invariant();
     *
                        || checkpoints.get(shardRouting.allocationId().getId()).tracked == false  
     * containing the persistent node ID calculated by {@link ReplicationTracker#getPeerRecoveryRetentionLeaseId}, and retain operations
            assert primaryMode;
                                inSync,
        }  
            out.writeVLong(clusterStateVersion);  
                    final long globalCheckpoint = localCheckpoint;
    }
        /**  
    }
        }  
                        || hasAllPeerRecoveryRetentionLeases == false;
            this.clusterStateVersion = clusterStateVersion;
import org.opensearch.cluster.routing.ShardRouting;
    public static String getPeerRecoveryRetentionLeaseId(ShardRouting shardRouting) {  
            // can happen if the relocation target was removed from cluster but the recovery process isn't aware of that.  
        assert globalCheckpoint >= SequenceNumbers.UNASSIGNED_SEQ_NO : "illegal initial global checkpoint: " + globalCheckpoint;
        cps.tracked = true;  
         * The global checkpoint here is a local knowledge which is updated under the mandate of the primary. It can happen that the primary
        public boolean equals(Object o) {  
        /**  
        assert primaryMode;
                /* Filter out:  
            source
        if (retentionLeases.supersedes(this.retentionLeases)) {
        );
                + clusterStateVersion  
     * view of replication.  
        */
     * Returns the current operation primary term.
            pendingInSync.add(allocationId);
        return addRetentionLease(  
            if (retentionLeases.contains(id) == false) {
        /*
        // do cheaply, and the circumstances in which this matters should be relatively rare, so we use this naive calculation regardless.  
                "updated local knowledge for [{}] on the primary of the visible checkpoint from [{}] to [{}], active timers {}",
     * Id for a peer recovery retention lease for the given {@link ShardRouting}.  
    /**  
    public synchronized void markAllocationIdAsInSync(final String allocationId, final long localCheckpoint) throws InterruptedException {  
    ) {
     * then switched to primary mode in the following three scenarios:
    // only after the copy becomes active so that recovery finalization time is not reported as replication lag.
            if (cps.inSync && cps.replicated) {
        final Collection<RetentionLease> expiredLeases = partitionByExpiration.get(true);  
                globalCheckpoint
     * The global checkpoint tracker can operate in two modes:
                                primaryTargetAllocationId,
import java.util.Objects;  
                                )
    ) {
     * @return the retention leases  
                                primaryAllocationId,
        return this.latestReplicationCheckpoint;
                if (retentionLease == null) {
     * @param globalCheckpoint          the last known global checkpoint for this shard, or {@link SequenceNumbers#UNASSIGNED_SEQ_NO}
        primaryMode = true;
import org.opensearch.common.SuppressForbidden;  
                    shardRouting -> retentionLeases.contains(getPeerRecoveryRetentionLeaseId(shardRouting))
                if (shardRouting.assignedToNode()) {
                    /*  
    /**  
                + "for primary mode allocation ID ["
                if (cps.inSync
     * computation to happen (for example due to blocking), it returns the fallback value.
            : "global checkpoint ["
                     * If this shard copy is tracked then we got here here via a rolling upgrade from an older version that doesn't
     * each shard copy is explained in the docs for the {@link CheckpointState} class.
        }
     * Whether there should be a peer recovery retention lease (PRRL) for every tracked shard copy. Always true on indices created from
            for (final ShardRouting shardRouting : routingTable.assignedShards()) {  
    public static String getPeerRecoveryRetentionLeaseId(String nodeId) {
     */
 * <p>  
                    // don't need to do any more work.  
 * GitHub history for details.
                        final long newRetainedSequenceNumber = Math.max(0L, checkpointState.globalCheckpoint + 1L);
     *  
                + globalCheckpoint
     * and / or in-sync, possibly also containing information about unassigned in-sync shard copies. The information that is tracked for  
    private Runnable getClusterManagerUpdateOperationFromCurrentState() {  
    @PublicApi(since = "1.0.0")  
                .filter(shardRouting -> shardRouting.isSearchOnly() == false)
            persistedRetentionLeasesVersion = currentRetentionLeases.version();
     */
import java.util.stream.StreamSupport;
        );  
            allocationId,  
        // when in primary mode, the current allocation ID is the allocation ID of the primary or the relocation allocation ID
        );  
                    && replicationGroup.getUnavailableInSyncShards().contains(allocationId) == false  
                inSyncAllocationIds.add(entry.getKey());  
    private boolean invariant() {  
        if (assignedToRemoteStoreNode == true) {
        final Supplier<SafeCommitInfo> safeCommitInfoSupplier,  
            + globalCheckpoint  
                    if (allShardsStarted) {
        return "peer_recovery/" + nodeId;
                    cps.checkpointTimers.computeIfAbsent(latestReplicationCheckpoint, ignored -> new SegmentReplicationLagTimer());
            logger.debug("removing retention lease [{}] from current retention leases [{}]", id, retentionLeases);
     * retention lease sync action, to sync retention leases to replicas.
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
        }  
 * compatible open source license.
import org.opensearch.action.support.GroupedActionListener;  
        // would be cleaned up on the target by cluster state updates.
        assert Thread.holdsLock(this);  
     * @param source                  the source of the retention lease  
        return operationPrimaryTerm;  
        long lastCompletedReplicationLag;  
     * {@link #abortRelocationHandoff}, depending on whether the handoff was successful or not. During the handoff, which has as main
            return "LocalCheckpointState{"  
        // the current shard is marked as in-sync when the global checkpoint tracker operates in primary mode
    }
     * Returns the local checkpoint information tracked for a specific shard. Used by tests.
     * The allocation ID for the shard to which this tracker is a component of.
            final long previousGlobalCheckpoint = cps.globalCheckpoint;
     * Sets the current operation primary term. This method should be invoked only when no other operations are possible on the shard. That
    }
                operationPrimaryTerm,
            currentRetentionLeases = retentionLeases;
     */  
                        - Vanilla segrep is not enabled
        } else if (hasAllPeerRecoveryRetentionLeases == false  
     * Returns the in-memory global checkpoint for the shard.
                    return false;
     * @param listener                the callback when the retention lease is successfully added and synced to replicas
        if (hasAllPeerRecoveryRetentionLeases == false || createMissingRetentionLeasesDuringMigration) {
            currentRetentionLeases = retentionLeases;
     * @param targetLeaseId the identifier of the retention lease to create
            this.tracked = in.readBoolean();  
        assert localCheckpoint >= SequenceNumbers.NO_OPS_PERFORMED;  
        @Override
                + shardAllocationId
    /**
         * information is lagging compared to a replica (e.g., if a replica is promoted to primary but has stale info relative to other
        }
        this.onGlobalCheckpointUpdated = Objects.requireNonNull(onGlobalCheckpointUpdated);
         * the replica is caught up.
            this.latestReplicationCheckpoint = checkpoint;
    /**
        retentionLeases = new RetentionLeases(operationPrimaryTerm, retentionLeases.version() + 1, nonExpiredLeases);
         * replica shards). In these cases, the local knowledge of the global checkpoint could be higher than the sync from the lagging  
                    } else {
    /**
        }
        boolean assignedToRemoteStoreNode
        updateLocalCheckpoint(shardAllocationId, checkpoints.get(shardAllocationId), localCheckpoint);
        final Set<String> pendingInSync,
            bytesBehind > 0L ? cps.checkpointTimers.values().stream().mapToLong(SegmentReplicationLagTimer::time).max().orElse(0) : 0,  
     * Initialize the global checkpoint service. The specified global checkpoint should be set to the last known global checkpoint, or
        final RetentionLeases currentRetentionLeases;
            logger.trace("persisting retention leases [{}]", currentRetentionLeases);
    /**
    /**
    }  
                                newRetainedSequenceNumber,  
        // Syncing here may not be strictly necessary, because this new lease isn't retaining any extra history that wasn't previously
        // all the entries from checkpoints that are inSync: the reason we don't need to care about initializing non-insync entries
        for (Map.Entry<String, CheckpointState> entry : checkpoints.entrySet()) {
    boolean handoffInProgress;  
                            // the retention lease is tied to the node, not the shard copy, so it's possible a copy was removed and now
        }
        public CheckpointState(long localCheckpoint, long globalCheckpoint, boolean inSync, boolean tracked, boolean replicated) {
        for (Map.Entry<String, CheckpointState> entry : checkpoints.entrySet()) {
        }  
                        new CheckpointState(
            currentRetentionLeases = retentionLeases;
import org.opensearch.index.engine.SafeCommitInfo;
                                groupedActionListener
     * @param source                  the source of the retention lease  
        if (cps == null) {
                + "more than in-sync local checkpoints ["
        assert invariant();
        assert primaryMode == false;
     * checkpoints. In replica mode, this is the in-memory global checkpoint that's communicated by the primary.
     * Create any required peer-recovery retention leases that do not currently exist. This can happen if either:
                                primaryTargetAllocationId,  
         * Whether the replication requests to the primary are replicated to the concerned shard or not.  
            final RetentionLease sourceLease = getRetentionLeases().get(sourceLeaseId);
        final long renewalTimeMillis = currentTimeMillisSupplier.getAsLong() - indexSettings.getRetentionLeaseMillis() / 2;
            final String allocationId = entry.getKey();
        private final long clusterStateVersion;  
    /**  
     */  
    }
import java.util.Map;
                        new CheckpointState(
                                primaryAllocationId,  
    }  
    /**  
            checkpoints.entrySet().stream().filter(e -> e.getValue().inSync).map(Map.Entry::getKey).collect(Collectors.toSet()),
     */
        // we have a routing table iff we have a replication group
                - This shard's allocation id
        }
                return currentTimeMillis - lease.timestamp() > retentionLeaseMillis;
    /**  
        // is that they will have to undergo a recovery attempt on the relocation target, and will hence be supplied by the cluster state  
        }
        assert invariant();
 * Modifications Copyright OpenSearch Contributors. See
            + "]";  
     *   handoff. If the target shard is successfully initialized in primary mode, the source shard of a primary relocation is then moved
     * Marks the shard with the provided allocation ID as in-sync with the primary shard. This method will block until the local checkpoint  
     * Persists the current retention leases to their dedicated state file. If this version of the retention leases are already persisted
                .collect(Collectors.toList());  
         */
        }  
        assert computedGlobalCheckpoint >= globalCheckpoint : "new global checkpoint ["  
    }
    private ReplicationGroup calculateReplicationGroup() {
        assert primaryMode || checkpoints.values().stream().allMatch(lcps -> lcps.localCheckpoint == SequenceNumbers.UNASSIGNED_SEQ_NO);
    }
            onGlobalCheckpointUpdated.accept(globalCheckpoint);
     * @param newGlobalCheckpoint the new global checkpoint  
     * @param indexSettings             the index settings  
     * @return the global checkpoint
     *
        this.handoffInProgress = false;  
            onSyncRetentionLeases,
        assert primaryMode;
            if (tracked != that.tracked) return false;  
            safeCommitInfoSupplier,  
     * cluster state that is older than the one upon which the primary context was based. If we allowed this old cluster state
        logger.trace(  
     * This method will also stop timers for each shard and compute replication lag metrics.
                + retainingSequenceNumber
    private final Supplier<SafeCommitInfo> safeCommitInfoSupplier;
        final long retainingSequenceNumber,
                + entry.getKey()
                            globalCheckpoint,  
                        waitForLocalCheckpointToAdvance();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (pending && cps.localCheckpoint >= getGlobalCheckpoint()) {
    private long persistedRetentionLeasesPrimaryTerm;
            } else {
            currentTimeMillisSupplier,
            + "]";
            // can happen if replica was removed from cluster but recovery process is unaware of it yet  
     */
        assert primaryMode == false;
            Stream.concat(retentionLeases.leases().stream().filter(lease -> lease.id().equals(id) == false), Stream.of(retentionLease))  
import org.opensearch.Version;
    /**
        private final Map<String, CheckpointState> checkpoints;
        assert relocated == false;
                + '}';
            if (o == null || getClass() != o.getClass()) return false;
         * If any of the peer-recovery retention leases need renewal, it's a good opportunity to renew them all.
     * @return {@link Tuple} V1 - TimeValue in ms - mean replication lag for this primary to its entire group,
            try {  
        retentionLeases = new RetentionLeases(
                        - Index is assigned to remote node (Primary has been seeded) but the corresponding replication group entry has not yet moved to remote
        assert invariant();
        assert invariant();
        updateReplicationGroupAndNotify();
            if (inSync != that.inSync) return false;
import java.util.Collection;  
     * <p>  
                    if (lease.retainingSequenceNumber() < minimumReasonableRetainedSeqNo) {
        if (primaryMode && indexSettings.isSoftDeleteEnabled() && hasAllPeerRecoveryRetentionLeases
            : "In absence of remote translog store, all tracked shards must have replication mode as LOGICAL_REPLICATION";  
        // TODO after backporting we expect this never to happen in 8.x, so adjust this to throw an exception instead.
     * Fails a relocation handoff attempt.  
                .stream()  
        /**
     * earlier version if we recently did a rolling upgrade and
    /**  
        }
     * expiration.
        boolean inSync;
/*  
     */  
        // reapply missed cluster state update
        }
     * @param path the path to the directory containing the state file
                "updated local knowledge for [{}] on the primary of the global checkpoint from [{}] to [{}]",
        public boolean equals(Object o) {  
        removeRetentionLease(getPeerRecoveryRetentionLeaseId(nodeId), listener);
    public static class PrimaryContext implements Writeable {
                .map(AllocationId::getId)
                if (retentionLeases.contains(getPeerRecoveryRetentionLeaseId(shardRouting))) {
    /**
     */
        onSyncRetentionLeases.accept(currentRetentionLeases, listener);  
    private final Consumer<ReplicationGroup> onReplicationGroupUpdated;  
            source
        // stuck from advancing
        }  
    volatile boolean relocated;
            }  
        this.pendingInSync = new HashSet<>();
        assert primaryMode : id + "/" + retainingSequenceNumber + "/" + source;  
        assert handoffInProgress == false;
                allocationId,  
     */
            }, listener::onFailure), shardRoutings.size());
        assert !cps.inSync || cps.localCheckpoint >= getGlobalCheckpoint() || cps.replicated == false : "shard copy "  
    /**  
        final long operationPrimaryTerm,
        final long previousGlobalCheckpoint = globalCheckpoint;  
        // global checkpoints only set during primary mode
     */  
            operationPrimaryTerm,
        }
                ? primary.getTargetRelocatingShard().allocationId().getId()
                        if (retentionLease.retainingSequenceNumber() <= newRetainedSequenceNumber) {  
        assert primaryMode;
    /**
        long minLocalCheckpoint = Long.MAX_VALUE;  
        assert handoffInProgress;
 */  
        /**
        assert invariant();
        // might not have retention leases for docrep shard copies
            logger.trace("marked [{}] as in-sync", allocationId);
            } finally {
        ActionListener<ReplicationResponse> listener
        /*  
                final RetentionLease retentionLease = retentionLeases.get(getPeerRecoveryRetentionLeaseId(shardRouting));
    public void setOperationPrimaryTerm(final long operationPrimaryTerm) {  
        final Map<String, CheckpointState> checkpoints,
                + inSync  
                                + checkpointState
                // Safe to call innerAddRetentionLease() without a subsequent sync since there are no other members of this replication
            && createdMissingRetentionLeases) {
    long appliedClusterStateVersion;  
        /**
                            "updated last published checkpoint for {} at visible cp {} to {} - timers [{}]",
        // relocation handoff can only occur in primary mode
                        break;
        if (cps == null) {
        if (checkpoints.containsKey(targetAllocationId) == false) {
        // retained by the source lease; however we prefer to sync anyway since we expect to do so whenever creating a new lease.
                                + " for "
        }  
        final Set<String> inSyncAllocationIds,
        handoffInProgress = true;  
                if (shardRouting.isSearchOnly()) {
                + "]";  
        }
         */
        assert handoffInProgress;
                }
        );
        assert invariant();  
        final SafeCommitInfo safeCommitInfo = safeCommitInfoSupplier.get();  
        assert invariant();  
     * The current retention leases.  
     * This set contains allocation IDs for which there is a thread actively waiting for the local checkpoint to advance to at least the
     * @param operationPrimaryTerm      the current primary term
        assert Thread.holdsLock(this);
        assert handoffInProgress == false;
                        assert inSync == false : "update from cluster-manager in primary mode has "  
            + " that's above the global checkpoint "
        assert primaryMode == false;
        final RetentionLeases currentRetentionLeases;
    }  
        final RetentionLease existingRetentionLease = retentionLeases.get(id);
            persistedRetentionLeasesPrimaryTerm = currentRetentionLeases.primaryTerm();
            return replicated == that.replicated;
        if (primaryMode) {  
            updateReplicationGroupAndNotify();
    }
            }
                    if (checkpointState.tracked == false) {
            RetentionLeases.FORMAT.writeAndCleanup(currentRetentionLeases, path);  
import org.opensearch.index.shard.IndexShard;  
     * leases.  
     * @param allocationId    the allocation ID of the shard to update the local checkpoint for
                + replicated
                + " blocks global checkpoint advancement but is in-sync";  
            checkpoints.entrySet().stream().filter(e -> e.getValue().tracked).map(Map.Entry::getKey).collect(Collectors.toSet()),
            Stream.concat(retentionLeases.leases().stream(), Stream.of(retentionLease)).collect(Collectors.toList())
        );  
     * Flag to indicate whether {@link ReplicationTracker#createMissingPeerRecoveryRetentionLeases(ActionListener)}
        final RetentionLease retentionLease;  
            this.routingTable = routingTable;  
        return hasAllPeerRecoveryRetentionLeases;  
        // when in primary mode, the global checkpoint is at most the minimum local checkpoint on all in-sync shard copies
    }
                for (String initializingId : initializingAllocationIds) {  
                if (cps.localCheckpoint == SequenceNumbers.UNASSIGNED_SEQ_NO) {  
 * The OpenSearch Contributors require contributions made to  
        this.appliedClusterStateVersion = -1L;
        if (localCheckpoint > cps.localCheckpoint) {
            this.localCheckpoint = in.readZLong();  
import org.opensearch.core.common.io.stream.Writeable;
     */
            localCheckpointsCopy.put(entry.getKey(), entry.getValue().copy());
     *
     * Threshold for expiring peer-recovery retention leases and falling back to file-based recovery. See
 * license agreements. See the NOTICE file distributed with
                .allMatch(
     * Returns whether the replication tracker has relocated away to another shard copy.
        final IndexSettings indexSettings,  
            : "global checkpoint is not up-to-date, expected: "  
                        all the other shard copies of the same index still hasn't completely moved over  
        * the last local checkpoint information that we have for this shard. All operations up to this point are properly fsynced to disk.
        assert handoffInProgress == false;  
        }
        assert invariant();  
        }
     * Called when the recovery process for a shard has opened the engine on the target shard. Ensures that the right data structures
                .filter(cps -> cps.inSync && cps.replicated)
                    } else {
     * in particular {@link #markAllocationIdAsInSync}.  
     * The global checkpoint tracker relies on the property that cluster state updates are applied in-order. After transferring a primary
                for (String inSyncId : inSyncAllocationIds) {  
                    && shouldSkipReplicationLag(allocationId) == false  
        assert primaryMode == false;
                        + "] in "  
    /**
        final long minimumReasonableRetainedSeqNo = allShardsStarted ? 0L : getMinimumReasonableRetainedSeqNo();
        assert checkpoints.get(shardAllocationId) != null
    private boolean updateLocalCheckpoint(String allocationId, CheckpointState cps, long localCheckpoint) {  
                        try {  
     */
     * Adds a new retention lease, but does not synchronise it with the rest of the replication group.
            retentionLease = innerAddRetentionLease(targetLeaseId, sourceLease.retainingSequenceNumber(), sourceLease.source());  
        checkpoints.clear();  
        assert primaryMode;  
        assert !relocated || !primaryMode;
        if (primaryMode) {
    }
        return minLocalCheckpoint;  
        return true;  
                retentionLeases.leases().stream().filter(lease -> lease.id().equals(id) == false).collect(Collectors.toList())  
            + " not in-sync with routing table "
    }
     */
            + routingTable
                            )  
    }
     * @return a map from allocation ID to the local knowledge of the persisted global checkpoint for that allocation ID  
            logger.trace("createMissingPeerRecoveryRetentionLeases: nothing to do");
            checkpoints = in.readMap(StreamInput::readString, CheckpointState::new);  

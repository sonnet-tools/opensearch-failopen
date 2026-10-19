        final PeerRecoveryTargetService recoveryTargetService,
                // also cleans shards
        if (!shardRouting.primary()) {
        /**
 *
    private final RetentionLeaseSyncer retentionLeaseSyncer;
        final ShardRouting currentRoutingEntry = shard.routingEntry();  
            final IndexMetadata currentIndexMetadata = indexService.getIndexSettings().getIndexMetadata();  
        /**
        /**
import java.util.HashMap;
        for (Index index : event.indicesDeleted()) {  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
                    }  
                        throw e;
            for (AllocatedIndex<? extends Shard> indexService : indicesService) {
        final SegmentReplicationCheckpointPublisher checkpointPublisher,  
         * @throws IndexShardRelocatedException if shard is marked as relocated and relocation aborted  
    }
         * @param recoveryTargetService  recovery service for the target
    private void updateFailedShardsCache(final ClusterState state) {
            final IndexMetadata indexMetadata = state.metadata().index(index);
         * Returns the recovery state associated with this shard.
        for (Map.Entry<Index, List<ShardRouting>> entry : indicesToCreate.entrySet()) {
        }
                    assert currentRoutingEntry.initializing() : currentRoutingEntry; // see above if clause
            return;
                }
    }
        if (localRoutingNode == null) {  
    ) {
 * ownership. Elasticsearch licenses this file to you under  
    }
             * like the shards files, state and transaction logs are kept around in the case of a disaster recovery.  
            repositoriesService,
                    failAndRemoveShard(
        }
    }  
                    "[{}][{}] failed to mark shard as failed (because of [{}])",
            }
         * This method assumes that an index is already deleted in the cluster state and/or explicitly
                "trying to find source node for peer recovery when routing state means no peer recovery: " + shardRouting
            }
        } catch (Exception e) {  
        this.sendRefreshMapping = settings.getAsBoolean("indices.cluster.send_refresh_mapping", true);  
    /**  
            } else {
    }  
                () -> new ParameterizedMessage(
                synchronized (IndicesClusterStateService.this) {
                        "{} removing shard (stale allocation id, stale {}, new {})",
    }
        // create map of indices to create with shards to fail if index creation fails  
            for (Shard shard : indexService) {
            } catch (Exception e) {
         * Why the index was removed
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.Consumer;
                    shardRouting.getId(),
        } catch (Exception e) {
                    }  
        IndexMetadata verifyIndexIsDeleted(Index index, ClusterState clusterState);
                    } catch (Exception e) {  
import java.util.concurrent.ConcurrentMap;
            failAndRemoveShard(shardRouting, true, "failed to create shard", e, state);
                        clusterService.state()
                    indexService.removeShard(shardRouting.shardId().id(), message);  
import org.opensearch.index.IndexComponent;
            clusterService.addHighPriorityApplier(this);
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;  
             */
import java.io.IOException;  
            mergedSegmentPublisher,
                            logger.warn("[{}] failed to lock all shards for index - timed out after 30 seconds", index);
import java.util.Set;
import org.opensearch.threadpool.ThreadPool;
                            indexMetadata.getIndex().getName(),
         *  
         * @param onShardFailure         a callback when this shard fails
         */
import org.opensearch.common.util.concurrent.AbstractRunnable;
         * @param inSyncAllocationIds         the allocation ids of the currently in-sync shard copies
                            indicesService.processPendingDeletes(index, indexSettings, new TimeValue(30, TimeUnit.MINUTES));  
                    indicesService.removeIndex(indexService.index(), FAILURE, "removing index (" + reason + ")");
                // previous cluster state is not initialized/recovered.  
        }  
            @Nullable DiscoveryNode sourceNode,
                    logger.debug("{} removing shard (not active, current {}, new {})", shardId, currentRoutingEntry, newShardRouting);
                + currentRoutingEntry;  
import org.opensearch.index.shard.IndexEventListener;
    }
                    indexService.removeShard(shardId.id(), "removing shard (stale copy)");  
                    primaryTerm,
            ShardRouting shardRouting,
                    String message = "cluster-manager "  
    private final boolean sendRefreshMapping;  
/*  
         */
                        } catch (InterruptedException e) {  
         * @param primaryTerm                 the new primary term
import org.opensearch.common.settings.Settings;
                    @Override
            long primaryTerm,
            // the node got closed on us, ignore it
            );  
        if (DiscoveryNode.isDataNode(settings) || DiscoveryNode.isClusterManagerNode(settings)) {
            }
         */
                && indicesService.getShardOrNull(shardId) == null) {
                    || previousState.blocks().hasGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK);
                    "can't find relocation source node for shard {} because it is assigned to an unknown node [{}].",
            PeerRecoveryTargetService recoveryTargetService,
        if (!lifecycle.started()) {  
                    + " does not exist in the cluster state, it should either "
        final NodeMappingRefreshAction nodeMappingRefreshAction,  
            logger.warn(
        final PrimaryReplicaSyncer primaryReplicaSyncer,
    // for tests  
        // TODO: feels hacky, a block disables state persistence, and then we clean the allocated shards, maybe another flag in blocks?
     *
    IndicesClusterStateService(
                        "shard failure, reason [" + shardFailure.reason + "]",
        }
            inner.addSuppressed(failure);  
     * Removes indices that have no shards allocated to this node or indices whose state has changed. This does not delete the shard data
        if (DiscoveryNode.isDataNode(settings) || DiscoveryNode.isClusterManagerNode(settings)) {
                }  
        T createShard(
            // only recover from started primary, if we can't find one, we will do it next round  
            sourceNode = nodes.get(shardRouting.relocatingNodeId());
        RoutingNode localRoutingNode = state.getRoutingNodes().node(state.nodes().getLocalNodeId());  
        DiscoveryNode clusterManagerNode = state.nodes().getClusterManagerNode();  
                    // state may result in a new shard being initialized while having the same allocation id as the currently started shard.
        final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
                indexSettings = indexService.getIndexSettings();
                                state.nodes().getLocalNodeId()  
    final ConcurrentMap<ShardId, ShardRouting> failedShardsCache = ConcurrentCollections.newConcurrentMap();
            /**
                        public void afterIndexShardStarted(IndexShard indexShard) {  
     * Removes shard entries from the failed shards cache that are no longer allocated to this node by the master.
         * @return IndexMetadata for the index loaded from disk  
            threadPool.generic().execute(() -> {  
    }
    // package-private for testing
                    }  
        @Nullable
    private final MergedSegmentWarmerFactory mergedSegmentWarmerFactory;  
            RepositoriesService repositoriesService,  
                threadPool.generic().execute(new AbstractRunnable() {
    private final SegmentReplicationTargetService segmentReplicationTargetService;  
                // The previous cluster state's metadata also does not contain the index,  
        final SearchService searchService,
        this.globalCheckpointSyncer = globalCheckpointSyncer;
import org.opensearch.indices.replication.common.ReplicationState;  
import org.opensearch.indices.recovery.RecoveryListener;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                    RoutingNode localRoutingNode = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
        final NodeMappingRefreshAction nodeMappingRefreshAction,
                indicesService.removeIndex(index, DELETED, "index no longer part of the metadata");
         * @param writeDanglingIndices   whether dangling indices information should be written  
            U indexRef = indexService(shardId.getIndex());
        updateFailedShardsCache(state);
         */
        if (state.blocks().disableStatePersistence()) {  
                }
    @Override
                }
        this.mergedSegmentPublisher = mergedSegmentPublisher;  
        for (final ShardRouting shardRouting : localRoutingNode) {  
                nodes  
            }
         * @param routingTable                the shard routing table
            ShardRouting matchedRouting = localRoutingNode.getByShardId(failedShardRouting.shardId());  
                    sendFailShard(shardRouting, failShardReason, e, state);
        final ClusterState state = event.state();
        /**  
                final String failShardReason;  
        try {
            DiscoveryNode targetNode,
            if (indexService != null) {  
        final ThreadPool threadPool,
import org.opensearch.cluster.routing.ShardRouting;
                if (newShardRouting == null) {  
                // contents on disk because the index will later be re-imported as a
    private void failAndRemoveShard(  
import org.opensearch.cluster.routing.RoutingTable;
                        }
        final MergedSegmentPublisher mergedSegmentPublisher,
        this.segmentReplicationTargetService = segmentReplicationTargetService;  
            ShardRouting primary = routingTable.shardRoutingTable(shardRouting.shardId()).primaryShard();
    public synchronized void handleRecoveryFailure(ShardRouting shardRouting, boolean sendShardFailure, Exception failure) {  
                sourceNode,
import org.opensearch.cluster.service.ClusterService;  
                        new NodeMappingRefreshAction.NodeMappingRefreshRequest(
                // metadata from disk. If its not there, there is nothing to delete.  
            throw new IllegalStateException(
        );
            searchService,
 * Modifications Copyright OpenSearch Contributors. See
                return;  
                        + "], mark shard as started",  
 * specific language governing permissions and limitations
        removeShards(state);   // removes any local shards that doesn't match what the cluster-manager expects
                reason = indexMetadata != null && indexMetadata.getState() == IndexMetadata.State.CLOSE ? CLOSED : NO_LONGER_ASSIGNED;
         */  
        }
    ) {
        void updateShardState(  
        final SegmentReplicationTargetService segmentReplicationTargetService,  
    public void handleRecoveryDone(ReplicationState state, ShardRouting shardRouting, long primaryTerm) {
                        )
            MergedSegmentWarmerFactory mergedSegmentWarmerFactory,
        @PublicApi(since = "1.0.0")
        DiscoveryNode sourceNode = null;  
                // to remove the in-memory structures for the index and not delete the  
                logger.debug("{} removing index ({})", index, reason);
        if (shardRouting.recoverySource().getType() == Type.PEER) {
            DiscoveryNodes discoveryNodes
                    null,  
                if (shard == null) {  
        void removeIndex(Index index, IndexRemovalReason reason, String extraInfo);
    }
         * Returns the shard id of this shard.
        /**
         */
        // resend failures that have not executed on cluster-manager yet  
                retentionLeaseSyncer,  
     * Resends shard failures for shards that are still marked as allocated to this node but previously failed.
            AllocatedIndices.IndexRemovalReason reason = null;
import org.opensearch.cluster.ClusterState;  
         * @throws IOException if an I/O exception occurs when creating the shard
                inSyncIds,
        final String localNodeId = state.nodes().getLocalNodeId();  
            NO_LONGER_ASSIGNED,  
            AllocatedIndex<? extends Shard> indexService = indicesService.indexService(shardRouting.shardId().getIndex());
                            // holding on to the lock due to a "currently canceled recovery" or so. The shard will delete itself BEFORE the
            failedShardsCache.clear();
            DELETED,
                indicesService.removeIndex(index, reason, "removing index (" + reason + ")");  
                logger.trace(  
            shard.updateShardState(
 *
        final ClusterService clusterService,
            : "local shard has a different allocation id but wasn't cleaned by removeShards. "
             * The index has been reopened. The index should be removed and all associated resources released. Persistent parts of the index  
        createOrUpdateShards(state);
            RecoveryListener recoveryListener,
             * Shard of this index were previously assigned to this node but all shards have been relocated.
        if (localRoutingNode == null) {
import org.opensearch.cluster.ClusterChangedEvent;
                shardRouting,  
            boolean isPrimaryOrAllActiveShard = shardRouting.primary() || indexMetadata.isAllActiveIngestionEnabled();
        /**  
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
    @Override  
                    updateShard(nodes, shardRouting, shard, routingTable, state);
        final Settings settings,
    }  
         * through index tombstones.  
        this.settings = settings;  
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.REOPENED;  
        RoutingNode localRoutingNode = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
        @Nullable Exception failure,
            DiscoveryNodes discoveryNodes,
                    shardRouting,  
        default T getShardOrNull(ShardId shardId) {
                assert indexMetadata != null || event.isNewCluster() : "index "  
        IndexSettings getIndexSettings();
     * @opensearch.internal
                }  
     * @opensearch.internal
                    if (localRoutingNode != null) {  
                indicesWithShards.add(shardRouting.index());
             * The index has been closed. The index should be removed and all associated resources released. Persistent parts of the index
            // for cluster-manager to confirm a shard started message (either cluster-manager failover, or a cluster event before  
        RoutingTable routingTable,
         * Updates the shard state based on an incoming cluster state:  
        this.retentionLeaseSyncer = Objects.requireNonNull(retentionLeaseSyncer);
        this.indicesService = indicesService;
            } else {  
            } else if (indicesWithShards.contains(index) == false) {
                for (ShardRouting shardRouting : entry.getValue()) {
 * license agreements. See the NOTICE file distributed with
             */
                new RecoveryListener(shardRouting, primaryTerm, this),
        void updateMetadata(IndexMetadata currentIndexMetadata, IndexMetadata newIndexMetadata);
                inner
import org.opensearch.env.ShardLockObtainFailedException;  
            if (indexSettings != null) {
    @Override
import org.opensearch.core.index.shard.ShardId;
    private class FailedShardHandler implements Consumer<IndexShard.ShardFailure> {
            segmentReplicationTargetService,
            );
                nodes,
            }
                    indexService.removeShard(shardId.id(), "removing shard (not allocated)");
     * routing to *require* peer recovery, use {@link ShardRouting#recoverySource()} to check if its needed or not.
            logger.debug("[{}] creating index", index);
import java.util.Arrays;
                } else {  
                    );
                    try {
        final String localNodeId = state.nodes().getLocalNodeId();
        enum IndexRemovalReason {  
         * @param index {@code Index} to make sure its deleted from disk
            final IndexMetadata indexMetadata = state.metadata().index(index);
                    }  
     */
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.CLOSED;
        final RetentionLeaseSyncer retentionLeaseSyncer,  
            );
         * Creates a new {@link IndexService} for the given metadata.
    }
         */  
                        nodeMappingRefreshAction.nodeMappingRefresh(
         * Returns shard with given id.  
            remoteStoreStatsTrackerFactory,
         * @param extraInfo extra information that will be used for logging and reporting  
                    // once all shards are allocated
            final ShardRouting shardRouting = shardFailure.routing;
        for (AllocatedIndex<? extends Shard> indexService : indicesService) {
        boolean sendShardFailure,
     * Notifies cluster-manager about shards that don't exist but are supposed to be active on this node.  
        /**
                    nodeMappingRefreshAction.nodeMappingRefresh(
        }
                            )
            shardStateAction.localShardFailed(shardRouting, message, failure, SHARD_STATE_ACTION_LISTENER, state);
            }  
                logger.trace("can't find replica source node because primary shard {} is not active.", primary);
    protected void doStart() {
    }
                            state.nodes().getClusterManagerNode(),
                        + " has not removed previously failed shard. resending shard failure";
         */
        /**
 * Licensed to Elasticsearch under one or more contributor  
    public interface AllocatedIndex<T extends Shard> extends Iterable<T>, IndexComponent {  
        @Nullable
         */  
                ShardId shardId = currentRoutingEntry.shardId();
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
     *
    private final ThreadPool threadPool;  
    /**
            Consumer<ShardId> globalCheckpointSyncer,
                        shardId,
                indicesService.removeIndex(indexService.index(), NO_LONGER_ASSIGNED, "cleaning index (disabled block persistence)");  
                } else if (newShardRouting.primary() && currentRoutingEntry.primary() == false && newShardRouting.initializing()) {
        final ReferencedSegmentsPublisher referencedSegmentsPublisher  
                + shardRouting
        }  
                    );  
         *
        }
            );  
        String message,  
                        }
        final PeerRecoveryTargetService recoveryTargetService,  
                ),
        Logger logger,
    private void updateShardIngestionState(Shard shard, IndexMetadata indexMetadata, ShardRouting shardRouting) {
                ShardRouting newShardRouting = localRoutingNode == null ? null : localRoutingNode.getByShardId(shardId);
        // we need to clean the shards and indices we have on this node, since we  
                    + index
         * @param newIndexMetadata the new index metadata
     * An allocated index
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.FAILURE;
        /**
        /**
                }
                shardRouting,
                    && entry.getValue().get(0).recoverySource().getType() == Type.SNAPSHOT
        for (AllocatedIndex<? extends Shard> indexService : indicesService) {
            CLOSED,
        ShardRouting routingEntry();
                }
            } else if (previousState.metadata().hasIndex(index)) {  
         * @param mergedSegmentWarmerFactory factory for merged segment warmer
                        + nodes.getClusterManagerNode()  
     */  
     */  
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.common.annotation.PublicApi;
            ShardRouting shardRouting,
import java.util.function.BiConsumer;
         * @param sourceNode             the source node to recover this shard from (it might be null)  
        }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.shard.PrimaryReplicaSyncer.ResyncTask;  
            primaryTerm = indexMetadata.primaryTerm(shard.shardId().id());
        }
            assert newIndexMetadata != null : "index " + index + " should have been removed by deleteIndices";
 *
                ShardRouting currentRoutingEntry = shard.routingEntry();  
            logger.warn(
import org.opensearch.index.shard.IndexShardState;
        assert currentRoutingEntry.isSameAllocation(shardRouting)
            });
                    failShardReason = "failed to update mapping for index";
        RoutingNode localRoutingNode = state.getRoutingNodes().node(localNodeId);
import java.util.concurrent.TimeUnit;  
        }  
            final Index index = indexService.index();
            );  
                final Index index = shardRouting.index();
         * @param targetNode             the node where this shard will be recovered
import java.util.Objects;  
                    shardRouting.getIndexName(),
            logger.warn(  
                    }  
        if (sendShardFailure) {
            }
                remoteStoreStatsTrackerFactory,  
                indicesService.deleteUnassignedIndex("deleted index was not assigned to local node", metadata, state);
        }
                        true,
    }
                        );
        }  
                    "[{}][{}] failed to remove shard after failure ([{}])",  
         * @param reason the reason to remove the index
        final SegmentReplicationSourceService segmentReplicationSourceService,
            throw e;
import org.opensearch.indices.recovery.RecoveryState;  
        // we only create indices for shards that are allocated
            if (indexMetadata != null && indexMetadata.getState() != existingMetadata.getState()) {
        failAndRemoveShard(shardRouting, sendShardFailure, "failed recovery", failure, clusterService.state());
        final Settings settings,
    private void failMissingShards(final ClusterState state) {
            /**
    private final MergedSegmentPublisher mergedSegmentPublisher;
        public void accept(final IndexShard.ShardFailure shardFailure) {
            mergedSegmentWarmerFactory,  
             * Something around index management has failed and the index should be removed.
        final MergedSegmentPublisher mergedSegmentPublisher,  
                if (shard != null && shard.routingEntry().isSameAllocation(shardRouting)) {
    protected void doStop() {
         */  
    }  
            return;
        RoutingTable routingTable,  
        final ReferencedSegmentsPublisher referencedSegmentsPublisher
         * @return a new shard
            // the cluster-manager thinks we are initializing, but we are already started or on POST_RECOVERY and waiting
         * @throws ResourceAlreadyExistsException if the index already exists.
            failedShardsCache.put(shardRouting.shardId(), shardRouting);
    private void createIndices(final ClusterState state) {  
import org.opensearch.index.shard.IndexShardRelocatedException;  
     * Removes shards that are currently loaded by indicesService but have disappeared from the routing table of the current node.
            );
        final List<IndexEventListener> indexEventListeners = new ArrayList<>(  
                    updatedIndexEventListeners.add(refreshListenerAfterSnapshotRestore);
        assert localNodeId != null;  
        final RepositoriesService repositoriesService,  
                // asserting that either this index is already in the graveyard, or the
            if (logger.isDebugEnabled()) {
     */
import org.opensearch.snapshots.SnapshotShardsService;  
    }
            recoveryTargetService,
import org.opensearch.cluster.action.index.NodeMappingRefreshAction;
         * @param applyingClusterStateVersion the cluster state version being applied when updating the allocation IDs from the master  
        RoutingNode localRoutingNode = state.getRoutingNodes().node(localNodeId);  
                clusterState.version(),  
     *
            }
                } else {  
        if (localRoutingNode == null) {  
        try {
                    shardRouting.shardId(),
import org.opensearch.cluster.action.shard.ShardStateAction;  
                        newShardRouting
            AllocatedIndex<? extends Shard> indexService = null;
 * @opensearch.internal
                    shardRouting.getIndexName(),
    private final ShardStateAction shardStateAction;
import java.util.Collections;  
/**
                    indexService.removeShard(shardId.id(), "removing shard (stale copy)");  
         * @param retentionLeaseSyncer   a callback when this shard syncs retention leases
import org.apache.logging.log4j.Logger;
                mergedSegmentPublisher,  
        void deleteUnassignedIndex(String reason, IndexMetadata metadata, ClusterState clusterState);
                    "{} cluster-manager marked shard as initializing, but shard has state [{}], resending shard started to {}",
                }
        updateIndices(event); // can also fail shards, but these are then guaranteed to be in failedShardsCache  
    private static final ActionListener<Void> SHARD_STATE_ACTION_LISTENER = ActionListener.wrap(() -> {});
                if (indicesService.indexService(index) == null) {
        for (ShardRouting shardRouting : localRoutingNode) {
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
             * all resources are released.  
            /**
         * - Updates the primary term if this shard is a primary.
/*
                () -> new ParameterizedMessage(  
        final Consumer<ShardId> globalCheckpointSyncer,
 * under the License.  
        assert localNodeId != null;
     *  
            throws IOException;
                    reason = "metadata update failed";  
import java.util.HashSet;
                final IndexMetadata metadata = indicesService.verifyIndexIsDeleted(index, event.state());  
                iterator.remove();
        }
        try {  
        this.clusterService = clusterService;  
            snapshotShardsService,
            return;
        }
 * software distributed under the License is distributed on an
        final PeerRecoverySourceService peerRecoverySourceService,  
                logger.trace(  
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.DELETED;  
                );
         */
        // Doesn't make sense to manage shards on non-master and non-data nodes  
            peerRecoverySourceService,  
 */  
        DiscoveryNode sourceNode = null;
    @Override
import org.opensearch.indices.IndicesService;
        RecoveryState recoveryState();  
    /**
            settings,  
     * {@link org.opensearch.indices.store.IndicesStore}).  
                && failedShardsCache.containsKey(shardId) == false  
import org.opensearch.cluster.metadata.IndexMetadata;
    /**
     */  
            sendFailShard(shardRouting, message, failure, state);  
            if (indexService != null) {  
            updateShardIngestionState(shard, indexMetadata, shardRouting);
     * Finds the routing source node for peer recovery, return null if its not found. Note, this method expects the shard  
            Set<String> inSyncAllocationIds,
                    nodes.getClusterManagerNode()
                        shardFailure.cause,  
        final ClusterState previousState = event.previousState();
     * This method does not delete the shard data.  
                () -> new ParameterizedMessage("{} marking and sending shard failed due to [{}]", shardRouting.shardId(), message),
        ) throws IOException;
         * Returns the latest internal shard state.
import org.opensearch.index.shard.IndexShard;
    }  
                );
            sourceNode = findSourceNodeForPeerRecovery(logger, routingTable, nodes, shardRouting);  
         * @param remoteStoreStatsTrackerFactory factory for remote store stats trackers
            }
                    assert shardRouting.initializing() : shardRouting + " should have been removed by failMissingShards";
            final IndexMetadata newIndexMetadata = state.metadata().index(index);
                            }
                if (clusterManagerNode != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        /**  
                AllocatedIndex<? extends Shard> indexService = indicesService.indexService(shardId.getIndex());  
        }
 *  
        this.repositoriesService = repositoriesService;
     */  
                shard.updateShardIngestionState(indexMetadata);  
        }
                referencedSegmentsPublisher
    private final Consumer<ShardId> globalCheckpointSyncer;  
    private final PeerRecoveryTargetService recoveryTargetService;
            /**
         */
                sourceNode = nodes.get(primary.currentNodeId());
     * as we wait for enough shard copies to exist in the cluster before deleting shard data (triggered by
            ReferencedSegmentsPublisher referencedSegmentsPublisher
         * - Updates and persists the new routing value.
            failAndRemoveShard(shardRouting, true, "failed updating shard routing entry", e, clusterState);
                    logger.trace("[{}] re-sending failed shard [{}], reason [{}]", matchedRouting.shardId(), matchedRouting, message);  
        }  
     */
    private void createShard(DiscoveryNodes nodes, RoutingTable routingTable, ShardRouting shardRouting, ClusterState state) {
 * the Apache License, Version 2.0 (the "License"); you may
    ) {
 * compatible open source license.
        final Set<Index> indicesWithShards = new HashSet<>();  
 */  
        U createIndex(IndexMetadata indexMetadata, List<IndexEventListener> builtInIndexListener, boolean writeDanglingIndices)  
    private void sendFailShard(ShardRouting shardRouting, String message, @Nullable Exception failure, ClusterState state) {
     *  
}  
            return;  
                            // lock is released so it's guaranteed to be deleted by the time we get the lock
        if (localRoutingNode != null) { // null e.g. if we are not a data node
                        indexService.updateMetadata(currentIndexMetadata, newIndexMetadata);
        final ClusterState state = event.state();  
                            indexMetadata.getIndexUUID(),  
                // the cluster-manager thinks we are active, but we don't have this shard at all, mark it as failed
                final IndexMetadata metadata = previousState.metadata().index(index);
            nodeMappingRefreshAction,  
            if (ClusterChangedEvent.indexMetadataChanged(currentIndexMetadata, newIndexMetadata)) {  
        }
import org.opensearch.indices.replication.SegmentReplicationSourceService;
            clusterService,
            final IndexShardRoutingTable indexShardRoutingTable = routingTable.shardRoutingTable(shardRouting.shardId());
        /**
         */
            return;
    }  
    private final PrimaryReplicaSyncer primaryReplicaSyncer;
         * @param primaryReplicaSyncer        the primary-replica resync action to trigger when a term is increased on a primary
         * @param indexMetadata          the index metadata to create the index for  
            if (reason != null) {
            }
            primaryReplicaSyncer,
                        @Override
            segmentReplicationSourceService,  
            indicesService,
    }
        }
            }  
     * Sends shard failures for shards that are marked as actively allocated to this node but don't actually exist on the node.  
    /**
             * The index is deleted. Persistent parts of the index  like the shards files, state and transaction logs are removed once
         */
    /**
                }
             * like the shards files, state and transaction logs are kept around in the case of a disaster recovery.
import org.opensearch.cluster.node.DiscoveryNodes;  
import org.opensearch.index.IndexService;  
                        + state
         * like the shards files, state and transaction logs are kept around in the case of a disaster recovery.  
        ) throws IOException;
        final IndexShardState state = shard.state();  
            }  
    public interface Shard {
        RoutingTable routingTable = state.routingTable();
        final PeerRecoverySourceService peerRecoverySourceService,
                            // we are waiting until we can lock the index / all shards on the node and then we ack the delete of the store
 * this file be licensed under the Apache-2.0 license or a
        indexEventListeners.add(remoteStoreStatsTrackerFactory);
        final MergedSegmentWarmerFactory mergedSegmentWarmerFactory,
 * Service to update the cluster state for multiple indices  
import org.apache.logging.log4j.LogManager;
         * @param currentIndexMetadata the current index metadata
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
                        + " marked shard as initializing, but shard state is ["
            }
     * @param state new cluster state  
            if (matchedRouting == null || matchedRouting.isSameAllocation(failedShardRouting) == false) {
import org.opensearch.gateway.GatewayService;
    @Inject
         * Returns the index settings of this index.  
            RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,  
                } else if (newShardRouting.isSameAllocation(currentRoutingEntry) == false) {
                    shardRouting.relocatingNodeId()  
                if (metadata != null) {
    private void removeIndices(final ClusterChangedEvent event) {
         */
            clusterService.removeApplier(this);  
    public IndicesClusterStateService(  
import org.opensearch.index.seqno.GlobalCheckpointSyncAction;
         * but does not deal with in-memory structures. For those call {@link #removeIndex(Index, IndexRemovalReason, String)}  
            }
        }
    private final ReferencedSegmentsPublisher referencedSegmentsPublisher;  
            final IndexMetadata existingMetadata = indexService.getIndexSettings().getIndexMetadata();
         * @opensearch.api  
        // remove items from cache which are not in our routing table anymore and
                    // is assigned to it. Batch cluster state processing or if shard fetching completes before the node gets a new cluster  
        DiscoveryNodes nodes = state.nodes();  
        @Override  
 * GitHub history for details.
    ) {
        final SnapshotShardsService snapshotShardsService,
                    public void onFailure(Exception e) {
    // we keep track of these shards in order to prevent repeated recovery of these shards on each cluster state update  
        } else {  
        final ShardStateAction shardStateAction,
import org.opensearch.ResourceAlreadyExistsException;
                    SHARD_STATE_ACTION_LISTENER,
         * - Updates the allocation ids that are tracked by the shard if it is a primary.  
            }
                inner  
    }  
         * Verify that the contents on disk for the given index is deleted; if not, delete the contents.
                    logger.debug("{} removing shard (not allocated)", shardId);  
         * Creates a shard for the specified shard routing and starts recovery.
        // are going to recover them again once state persistence is disabled (no cluster-manager / not recovered)
            if (indexRef != null) {  
        if (localRoutingNode == null) {
                sendFailShard(  
                        state.nodes().getClusterManagerNode(),  
        this.nodeMappingRefreshAction = nodeMappingRefreshAction;
            }  
            final Index index = indexService.index();  
     * @opensearch.internal
    final AllocatedIndices<? extends Shard, ? extends AllocatedIndex<? extends Shard>> indicesService;
        final PrimaryReplicaSyncer primaryReplicaSyncer,
            AllocatedIndex<? extends Shard> indexService = indicesService.indexService(index);
         * @param mergedSegmentPublisher merged segment publisher  
        }  
            REOPENED,  
                        + clusterManagerNode
                        currentRoutingEntry,  
            referencedSegmentsPublisher
                    );
import java.util.List;
    private void updateIndices(ClusterChangedEvent event) {
        for (final ShardRouting shardRouting : localRoutingNode) {  
        }
        } catch (Exception e) {
                    @Override  
        for (AllocatedIndex<? extends Shard> indexService : indicesService) {
    private final ClusterService clusterService;
            long applyingClusterStateVersion,
            if (sourceNode == null) {
                // TODO: can we remove this? Is resending shard failures the responsibility of shardStateAction?
                indexShardRoutingTable,
        final MergedSegmentWarmerFactory mergedSegmentWarmerFactory,
                            indexShard.refresh("refresh to upload metadata to remote store");
 */  
                        assert false : e;
                        } catch (ShardLockObtainFailedException exc) {
        createIndices(state);
        final SnapshotShardsService snapshotShardsService,  
                );
    /**
        final SegmentReplicationSourceService segmentReplicationSourceService,
        this.recoveryTargetService = recoveryTargetService;
    }  
                primaryTerm,
                    indicesToCreate.computeIfAbsent(index, k -> new ArrayList<>()).add(shardRouting);  
 */
             * case of a disaster recovery.
import org.opensearch.common.unit.TimeValue;  
                // dangling index
import org.opensearch.common.inject.Inject;  
            ShardLockObtainFailedException;
        this.remoteStoreStatsTrackerFactory = remoteStoreStatsTrackerFactory;
                primaryReplicaSyncer::resync,
         * @param globalCheckpointSyncer a callback when this shard syncs the global checkpoint  
        default void updateShardIngestionState(IndexMetadata indexMetadata) {};
                recoveryTargetService,
        RecoveryState recoveryState = (RecoveryState) state;
     * Allocated indices  
         * Removes shard with given id.  
            final long primaryTerm = state.metadata().index(shardRouting.index()).primaryTerm(shardRouting.id());
import org.opensearch.common.Nullable;
            return;  
     */  
        /**
import org.opensearch.cluster.routing.RecoverySource.Type;
import org.opensearch.indices.replication.SegmentReplicationTargetService;
            indicesService.createShard(
             * like the shards files, state and transaction logs are kept around in the case of a disaster recovery.
                // node was not part of the cluster. In this case, try reading the index
 * You may obtain a copy of the License at  
         */
         * @param shardRouting                the new routing entry  
        }
                    shardStateAction.localShardFailed(matchedRouting, message, null, SHARD_STATE_ACTION_LISTENER, state);
                    message  
        shardStateAction.shardStarted(shardRouting, primaryTerm, "after " + recoveryState.getRecoverySource(), SHARD_STATE_ACTION_LISTENER);  
                try {
         * Updates the metadata of this index. Changes become visible through {@link #getIndexSettings()}.
        final SegmentReplicationTargetService segmentReplicationTargetService,
        return sourceNode;
            IndexShardRoutingTable routingTable,  
        ShardRouting shardRouting
    private final Settings settings;
            FAILURE,  
            if (logger.isTraceEnabled()) {
                    createShard(nodes, routingTable, shardRouting, state);
     * Deletes indices (with shard data).
                        logger.warn(() -> new ParameterizedMessage("[{}] failed to complete pending deletion for index", index), e);
        final RetentionLeaseSyncer retentionLeaseSyncer,
                globalCheckpointSyncer,
            try {
import org.opensearch.indices.recovery.PeerRecoverySourceService;  
     *
        indexEventListeners.add(segmentReplicationTargetService);  
            SegmentReplicationCheckpointPublisher checkpointPublisher,  
            final Set<String> inSyncIds = indexMetadata.inSyncAllocationIds(shard.shardId().id());  
             * The index should be removed and all associated resources released. Persistent parts of the index  
                    shardRouting,
                return indexRef.getShardOrNull(shardId.id());
                    state,  
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;  
        final ClusterService clusterService,  
        final GlobalCheckpointSyncAction globalCheckpointSyncAction,  
     * @param event cluster change event
                Shard shard = indexService.getShardOrNull(shardId.id());
                // The deleted index was part of the previous cluster state, but not loaded on the local node
            logger.error("Failed to update shard ingestion state", e);  
            }  
                    // we can just remove the shard without cleaning it locally, since we will clean it in IndicesStore
    private void removeShards(final ClusterState state) {
                    message
                    indicesService.removeIndex(index, FAILURE, "removing index (mapping update failed)");
        /**
        final SearchService searchService,
             */
        IndexShardState state();
                            // to the master. If we can't acquire the locks here immediately there might be a shard of this index still  
import org.apache.logging.log4j.message.ParameterizedMessage;  
     * @param event the cluster changed event
        RoutingNode localRoutingNode = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
        this.threadPool = threadPool;
    private final NodeMappingRefreshAction nodeMappingRefreshAction;  
        }
        );  
                    indexService.removeShard(shardId.id(), "removing shard (stale copy)");  
            if (indexMetadata.useIngestionSource() && isPrimaryOrAllActiveShard) {
         * @throws IOException                  if shard state could not be persisted
                if (entry.getValue().size() > 0
        } catch (Exception inner) {
                } else if (newShardRouting.initializing() && currentRoutingEntry.active()) {
        /**  
        ClusterState clusterState
                logger.trace("ignoring initializing shard {} - no source node can be found.", shardRouting.shardId());
 * not use this file except in compliance with the License.
    private static final Logger logger = LogManager.getLogger(IndicesClusterStateService.class);
                    // fail shards that would be created or updated by createOrUpdateShards
                    indexSettings = null;
        final AllocatedIndices<? extends Shard, ? extends AllocatedIndex<? extends Shard>> indicesService,  
    }  
import org.opensearch.index.shard.ShardNotFoundException;
                            if (shardRouting.index().equals(index) && failedShardsCache.containsKey(shardRouting.shardId()) == false) {
        this.primaryReplicaSyncer = primaryReplicaSyncer;  
        final long primaryTerm;
     */
package org.opensearch.indices.cluster;
         * Returns an IndexService for the specified index if exists otherwise returns <code>null</code>.
         *
        } catch (ShardNotFoundException e) {  
         * Returns shard for the specified id if it exists otherwise returns <code>null</code>.
                    // and assigning an initializing primary to this node
         * @param builtInIndexListener   a list of built-in lifecycle {@link IndexEventListener} that should should be used along side with
         * Deletes an index that is not assigned to this node. This method cleans up all disk folders relating to the index
    }
            }
            if (shardRouting.initializing() == false
            threadPool,  
        this.referencedSegmentsPublisher = referencedSegmentsPublisher;
        void removeShard(int shardId, String message);
                });
     */
        this.checkpointPublisher = checkpointPublisher;
        boolean updateMapping(IndexMetadata currentIndexMetadata, IndexMetadata newIndexMetadata) throws IOException;  
        } else if (shardRouting.relocatingNodeId() != null) {  
import org.opensearch.cluster.ClusterStateApplier;
        final Map<Index, List<ShardRouting>> indicesToCreate = new HashMap<>();
import org.opensearch.core.index.Index;
         *                               the per-index listeners
                shardStateAction.shardStarted(
    /**
             * Persistent parts of the index like the shards files, state and transaction logs are kept around in the  
 * The OpenSearch Contributors require contributions made to  
        DiscoveryNodes nodes,  
         * @param index the index to remove
import org.opensearch.core.action.ActionListener;  
        try {
            RetentionLeaseSyncer retentionLeaseSyncer,  
    private void deleteIndices(final ClusterChangedEvent event) {  
        ClusterState state
                    + "have been deleted or the cluster must be new";  
        ShardRouting shardRouting,
    private final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;
                    state
                }
    }
        final ThreadPool threadPool,
        ShardId shardId();  
        this.shardStateAction = shardStateAction;  
public class IndicesClusterStateService extends AbstractLifecycleComponent implements ClusterStateApplier {
        this.builtInIndexListener = Collections.unmodifiableList(indexEventListeners);
        indexEventListeners.add(segmentReplicationSourceService);
         *   See {@link ReplicationTracker#updateFromClusterManager(long, Set, IndexShardRoutingTable)} for details.
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.NO_LONGER_ASSIGNED;
         */
                assert indexService != null : "index " + shardId.getIndex() + " should have been created by createIndices";
     * A shard  
            if (sourceNode == null) {
        }  
    }
import java.util.ArrayList;
        final ClusterState state = event.state();
        final SegmentReplicationCheckpointPublisher checkpointPublisher,
                List<IndexEventListener> updatedIndexEventListeners = new ArrayList<>(builtInIndexListener);  
            return;
    public synchronized void applyClusterState(final ClusterChangedEvent event) {
            final IndexSettings indexSettings;
            ShardId shardId = shardRouting.shardId();
            ShardId shardId = shardRouting.shardId();
        if (shardRouting.initializing() && (state == IndexShardState.STARTED || state == IndexShardState.POST_RECOVERY)) {
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        this(
            final IndexMetadata indexMetadata = clusterState.metadata().index(shard.shardId().getIndex());
    ) {  
                String reason = null;
import java.util.Map;
                reason = indexMetadata.getState() == IndexMetadata.State.CLOSE ? CLOSED : REOPENED;  
             */
                nodes.getLocalNode(),
            Consumer<IndexShard.ShardFailure> onShardFailure,
            MergedSegmentPublisher mergedSegmentPublisher,  
        }
import org.opensearch.index.seqno.ReplicationTracker;
                // First, though, verify the precondition for applying this case by
            Arrays.asList(peerRecoverySourceService, recoveryTargetService, searchService, snapshotShardsService)
            }
        final ShardStateAction shardStateAction,
import org.opensearch.search.SearchService;
 * SPDX-License-Identifier: Apache-2.0
                            logger.warn("[{}] failed to lock all shards for index - interrupted", index);
                }
            } else {  
                if (sourceNode == null) {  
         * Returns the latest cluster routing entry received with this shard.  
        deleteIndices(event); // also deletes shards of deleted indices
            logger.debug("{} creating shard with primary term [{}]", shardRouting.shardId(), primaryTerm);  
                }
                    "master marked shard as active, but shard has not been created, mark shard as failed",
                mergedSegmentWarmerFactory,
    public interface AllocatedIndices<T extends Shard, U extends AllocatedIndex<T>> extends Iterable<U> {
        assert shardRouting.initializing() : "only allow shard creation for initializing shard but was " + shardRouting;
                    // this can happen if the node was isolated/gc-ed, rejoins the cluster and a new shard with the same allocation id
        /**  
            BiConsumer<IndexShard, ActionListener<ResyncTask>> primaryReplicaSyncer,  
                    indexSettings = new IndexSettings(metadata, settings);
        assert localNodeId != null;
                    clusterState
        }
            }
            shardStateAction,
import org.opensearch.index.shard.PrimaryReplicaSyncer;
         * Checks if index requires refresh from master.
                                newIndexMetadata.getIndex().getName(),
                    protected void doRun() throws Exception {  
        for (Iterator<Map.Entry<ShardId, ShardRouting>> iterator = failedShardsCache.entrySet().iterator(); iterator.hasNext();) {
            if (primary.active()) {
        /**
                // if the cluster change indicates a brand new cluster, we only want
    }
         * @param recoveryListener       a callback when recovery changes state (finishes or fails)  
        } catch (Exception inner) {  
                    && indexMetadata.getSettings().getAsBoolean(SETTING_REMOTE_STORE_ENABLED, false)) {  
import org.opensearch.index.IndexSettings;
                );  
            }  
         *  
        final ClusterState state = event.state();
                + " local: "
    protected void doClose() {}
    /**
    private final List<IndexEventListener> builtInIndexListener;
                    // this can happen when cluster state batching batches activation of the shard, closing an index, reopening it  
        DiscoveryNodes nodes,  
    /**
     * @param state new cluster state
        final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,  
                    if (indexService.updateMapping(currentIndexMetadata, newIndexMetadata) && sendRefreshMapping) {  
                    logger.debug(  
        U indexService(Index index);
                Shard shard = indexService.getShardOrNull(shardRouting.shardId().id());
                repositoriesService,  
                    shardRouting.getId(),  
     * @param state new cluster state
    private final RepositoriesService repositoriesService;
        }
                } catch (Exception e) {
         * @param clusterState {@code ClusterState} to ensure the index is not part of it
                }  
         * @param repositoriesService    service responsible for snapshot/restore
import org.opensearch.repositories.RepositoriesService;
                    final IndexEventListener refreshListenerAfterSnapshotRestore = new IndexEventListener() {
    private final SegmentReplicationCheckpointPublisher checkpointPublisher;
        }
         *
        final String localNodeId = state.nodes().getLocalNodeId();  
         * @param shardRouting           the shard routing
     *
            if (failedShardsCache.containsKey(shardRouting.shardId()) == false) {  
    private static DiscoveryNode findSourceNodeForPeerRecovery(  
                        shardRouting,  
        this.mergedSegmentWarmerFactory = mergedSegmentWarmerFactory;
 * this work for additional information regarding copyright
                    failShardReason = "failed to create index";
 * KIND, either express or implied.  See the License for the
            if (failedShardsCache.containsKey(shardId) == false) {
        T getShardOrNull(int shardId);  
                if (indexService == null) {
            for (ShardRouting shardRouting : localRoutingNode) {  
                } else {  
                    logger.trace("can't find replica source node because primary shard {} is assigned to an unknown node.", primary);
                ),
            retentionLeaseSyncer,
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
import java.util.Iterator;  
                if (indexService.updateMapping(null, indexMetadata) && sendRefreshMapping) {
     * Update the ingestion state for the shard using the new metadata.  
                failure
            globalCheckpointSyncAction::updateGlobalCheckpointForShard,  
        ShardRouting shardRouting,
         * Removes the given index from this service and releases all associated resources. Persistent parts of the index
            return null;  
            if (nodes.getClusterManagerNode() != null) {
                    };  
                indexSettings = new IndexSettings(metadata, settings);  
            // we managed to tell the cluster-manager we started), mark us as started
                failedShardHandler,
        }
            if (failure != null) inner.addSuppressed(failure);
        try {  
        /**  
    private final FailedShardHandler failedShardHandler = new FailedShardHandler();
        void processPendingDeletes(Index index, IndexSettings indexSettings, TimeValue timeValue) throws IOException, InterruptedException,  
                            state.nodes().getLocalNodeId()
            /**
import org.opensearch.index.seqno.RetentionLeaseSyncer;  
    private void createOrUpdateShards(final ClusterState state) {  
                + "cluster state: "  
        failMissingShards(state);
            final Index index = entry.getKey();  
                            new NodeMappingRefreshAction.NodeMappingRefreshRequest(  
         */  
                logger.debug("[{}] cleaning index, no longer part of the metadata", index);
             */
                    "master "
                    logger.debug("{} removing shard (not active, current {}, new {})", shardId, currentRoutingEntry, newShardRouting);
        Shard shard,
            ShardRouting failedShardRouting = iterator.next().getValue();
        final IndicesService indicesService,
                assert state.metadata().indexGraveyard().containsIndex(index)
    private void updateShard(
                                sendFailShard(shardRouting, "failed to update index (" + reason + ")", e, state);  
                indexService = indicesService.createIndex(indexMetadata, updatedIndexEventListeners, true);  
                checkpointPublisher,  
                        for (final ShardRouting shardRouting : localRoutingNode) {
        final RepositoriesService repositoriesService,
        removeIndices(event); // also removes shards of removed indices  
                        try {
            return;  
        RoutingNode localRoutingNode = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
                    reason = "mapping update failed";
                    shardRouting.shardId(),
                                newIndexMetadata.getIndexUUID(),
            }
    // a list of shards that failed during recovery
        if (!event.metadataChanged()) {  
     *
                // which is what happens on node startup when an index was deleted while the
import org.opensearch.cluster.routing.RoutingNode;  
                        }
            checkpointPublisher,
        // remove shards based on routing nodes (no deletion of data)

                }
         * @param recoveryListener       a callback when recovery changes state (finishes or fails)
             * Something around index management has failed and the index should be removed.
                    indexSettings = new IndexSettings(metadata, settings);
            searchService,
        this.mergedSegmentWarmerFactory = mergedSegmentWarmerFactory;
        final GlobalCheckpointSyncAction globalCheckpointSyncAction,
        final PeerRecoveryTargetService recoveryTargetService,
        final ShardStateAction shardStateAction,
         *
    }
        /**
             * like the shards files, state and transaction logs are kept around in the case of a disaster recovery.
 *    http://www.apache.org/licenses/LICENSE-2.0
                    if (indexService.updateMapping(currentIndexMetadata, newIndexMetadata) && sendRefreshMapping) {
        if (shardRouting.recoverySource().getType() == Type.PEER) {
 *
        } else {
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
     *
         */
                    // is assigned to it. Batch cluster state processing or if shard fetching completes before the node gets a new cluster
        final ClusterState state = event.state();
        final RepositoriesService repositoriesService,
    }
            globalCheckpointSyncAction::updateGlobalCheckpointForShard,
        }
         * @param applyingClusterStateVersion the cluster state version being applied when updating the allocation IDs from the master
     * @opensearch.internal
            logger.warn(
            assert newIndexMetadata != null : "index " + index + " should have been removed by deleteIndices";
         * @param remoteStoreStatsTrackerFactory factory for remote store stats trackers
 */
            if (logger.isDebugEnabled()) {
         * Returns the index settings of this index.
        if (!event.metadataChanged()) {
        /**
import org.opensearch.common.inject.Inject;
            } catch (Exception e) {
import org.opensearch.index.seqno.ReplicationTracker;
                    + " does not exist in the cluster state, it should either "
            return null;
                    "[{}][{}] failed to mark shard as failed (because of [{}])",
 *
                        } catch (ShardLockObtainFailedException exc) {
        }
import org.opensearch.index.shard.PrimaryReplicaSyncer;
                logger.trace("can't find replica source node because primary shard {} is not active.", primary);
        if (state.blocks().disableStatePersistence()) {
        void deleteUnassignedIndex(String reason, IndexMetadata metadata, ClusterState clusterState);
         */
            failedShardsCache.put(shardRouting.shardId(), shardRouting);
            }
    private static final ActionListener<Void> SHARD_STATE_ACTION_LISTENER = ActionListener.wrap(() -> {});
            if (indexMetadata != null && indexMetadata.getState() != existingMetadata.getState()) {
        ) throws IOException;
    }
import org.opensearch.cluster.service.ClusterService;
    private static DiscoveryNode findSourceNodeForPeerRecovery(
            return;
            return;
     * Update the ingestion state for the shard using the new metadata.
            FAILURE,
                reason = indexMetadata != null && indexMetadata.getState() == IndexMetadata.State.CLOSE ? CLOSED : NO_LONGER_ASSIGNED;
        /**
import org.opensearch.cluster.action.index.NodeMappingRefreshAction;
    }
 * the Apache License, Version 2.0 (the "License"); you may
        }
                    if (localRoutingNode != null) {
        final ReferencedSegmentsPublisher referencedSegmentsPublisher
        this.retentionLeaseSyncer = Objects.requireNonNull(retentionLeaseSyncer);
                primaryReplicaSyncer::resync,
         * Returns the latest cluster routing entry received with this shard.
            ShardId shardId = shardRouting.shardId();
    private final ClusterService clusterService;
                        )
                    updatedIndexEventListeners.add(refreshListenerAfterSnapshotRestore);
        updateFailedShardsCache(state);
                assert state.metadata().indexGraveyard().containsIndex(index)
            return;
                return;
}
                // The previous cluster state's metadata also does not contain the index,
            final Index index = indexService.index();
            DiscoveryNodes discoveryNodes,
                        state.nodes().getClusterManagerNode(),
                threadPool.generic().execute(new AbstractRunnable() {
                synchronized (IndicesClusterStateService.this) {
     * Sends shard failures for shards that are marked as actively allocated to this node but don't actually exist on the node.
        IndexSettings getIndexSettings();
            });
        final SearchService searchService,
        final RetentionLeaseSyncer retentionLeaseSyncer,
                }
                globalCheckpointSyncer,
        shardStateAction.shardStarted(shardRouting, primaryTerm, "after " + recoveryState.getRecoverySource(), SHARD_STATE_ACTION_LISTENER);
import org.opensearch.common.Nullable;
                    assert currentRoutingEntry.initializing() : currentRoutingEntry; // see above if clause
/*
                    assert shardRouting.initializing() : shardRouting + " should have been removed by failMissingShards";
            // the node got closed on us, ignore it
         */
import org.opensearch.indices.replication.common.ReplicationState;
            final ShardRouting shardRouting = shardFailure.routing;
                        shardRouting,
        IndexMetadata verifyIndexIsDeleted(Index index, ClusterState clusterState);
            return;
                        + nodes.getClusterManagerNode()
            long applyingClusterStateVersion,
    private void removeShards(final ClusterState state) {
            if (indexMetadata.useIngestionSource() && isPrimaryOrAllActiveShard) {
         */
import org.opensearch.indices.recovery.RecoveryState;
        }
        if (!shardRouting.primary()) {
                indicesService.removeIndex(indexService.index(), NO_LONGER_ASSIGNED, "cleaning index (disabled block persistence)");
            sendFailShard(shardRouting, message, failure, state);
import org.opensearch.search.SearchService;
                    indexService.removeShard(shardId.id(), "removing shard (stale copy)");
        final SegmentReplicationSourceService segmentReplicationSourceService,
    /**
            final Index index = entry.getKey();
                nodes,
            ShardRouting shardRouting,
    private final List<IndexEventListener> builtInIndexListener;
         * @param retentionLeaseSyncer   a callback when this shard syncs retention leases
                    shardRouting.getIndexName(),
    protected void doStart() {
     * @param state new cluster state
                    primaryTerm,
     *
                    message
                Shard shard = indexService.getShardOrNull(shardRouting.shardId().id());
        DiscoveryNode sourceNode = null;
                            new NodeMappingRefreshAction.NodeMappingRefreshRequest(
                try {
                    reason = "metadata update failed";
        boolean updateMapping(IndexMetadata currentIndexMetadata, IndexMetadata newIndexMetadata) throws IOException;
    private class FailedShardHandler implements Consumer<IndexShard.ShardFailure> {
            shardStateAction,
                logger.debug("{} removing index ({})", index, reason);
            AllocatedIndices.IndexRemovalReason reason = null;
                            state.nodes().getClusterManagerNode(),
        RoutingTable routingTable,
            clusterService.removeApplier(this);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
                ),
    private final PrimaryReplicaSyncer primaryReplicaSyncer;
        }
                    indexService.removeShard(shardId.id(), "removing shard (stale copy)");
import java.util.List;
                            // lock is released so it's guaranteed to be deleted by the time we get the lock
                    message
            return;
         * @param inSyncAllocationIds         the allocation ids of the currently in-sync shard copies
         *
                shardRouting,
        }
         * Returns the recovery state associated with this shard.
            RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
                retentionLeaseSyncer,
        }
        }
package org.opensearch.indices.cluster;
            repositoriesService,
     * {@link org.opensearch.indices.store.IndicesStore}).
            }
        }
                });
            logger.warn(
    @Inject
                        throw e;
                            state.nodes().getLocalNodeId()
                        try {
import org.opensearch.index.shard.IndexShardState;
                remoteStoreStatsTrackerFactory,
        }
            Set<String> inSyncAllocationIds,
            }
         * @param shardRouting                the new routing entry
     */
    final ConcurrentMap<ShardId, ShardRouting> failedShardsCache = ConcurrentCollections.newConcurrentMap();
            RecoveryListener recoveryListener,
        /**
        failMissingShards(state);
 * Unless required by applicable law or agreed to in writing,
            SegmentReplicationCheckpointPublisher checkpointPublisher,
         * @param reason the reason to remove the index
        if (DiscoveryNode.isDataNode(settings) || DiscoveryNode.isClusterManagerNode(settings)) {
import org.opensearch.cluster.routing.RoutingNode;
             * like the shards files, state and transaction logs are kept around in the case of a disaster recovery.
        // resend failures that have not executed on cluster-manager yet
            );
        for (final ShardRouting shardRouting : localRoutingNode) {
            );
            final IndexMetadata existingMetadata = indexService.getIndexSettings().getIndexMetadata();
                () -> new ParameterizedMessage("{} marking and sending shard failed due to [{}]", shardRouting.shardId(), message),
                // dangling index
        final ThreadPool threadPool,
        final ReferencedSegmentsPublisher referencedSegmentsPublisher
            if (sourceNode == null) {
            IndexShardRoutingTable routingTable,
            /**
        /**
        Logger logger,
    private final ShardStateAction shardStateAction;
import org.opensearch.common.util.concurrent.AbstractRunnable;
                    );
                }
        ShardRouting shardRouting,
                        }
import java.util.HashMap;
            }
public class IndicesClusterStateService extends AbstractLifecycleComponent implements ClusterStateApplier {
        DiscoveryNodes nodes = state.nodes();
         * Removes shard with given id.
    @Override
        }
            if (indexService != null) {
                    @Override
import java.util.Arrays;
            Consumer<IndexShard.ShardFailure> onShardFailure,
                    indexService.removeShard(shardRouting.shardId().id(), message);
         * @param builtInIndexListener   a list of built-in lifecycle {@link IndexEventListener} that should should be used along side with
        DiscoveryNode clusterManagerNode = state.nodes().getClusterManagerNode();
            MergedSegmentWarmerFactory mergedSegmentWarmerFactory,
                AllocatedIndex<? extends Shard> indexService = indicesService.indexService(shardId.getIndex());
     * routing to *require* peer recovery, use {@link ShardRouting#recoverySource()} to check if its needed or not.
        this.builtInIndexListener = Collections.unmodifiableList(indexEventListeners);
        final ClusterService clusterService,
                        nodeMappingRefreshAction.nodeMappingRefresh(
        }
    /**
         */
         * - Updates the allocation ids that are tracked by the shard if it is a primary.
        }
                referencedSegmentsPublisher
                // also cleans shards
        @Nullable Exception failure,
        final PeerRecoverySourceService peerRecoverySourceService,
        @Override
    }
        // TODO: feels hacky, a block disables state persistence, and then we clean the allocated shards, maybe another flag in blocks?
                // previous cluster state is not initialized/recovered.
                                newIndexMetadata.getIndex().getName(),
         * @param onShardFailure         a callback when this shard fails
     * Removes shard entries from the failed shards cache that are no longer allocated to this node by the master.
            return;
        @Nullable
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
        }
    private final ReferencedSegmentsPublisher referencedSegmentsPublisher;
         * Returns the latest internal shard state.
import org.opensearch.common.unit.TimeValue;
        final ClusterState previousState = event.previousState();
        } catch (Exception e) {
                    SHARD_STATE_ACTION_LISTENER,
        assert localNodeId != null;
 * Licensed to Elasticsearch under one or more contributor
        if (localRoutingNode == null) {
                    }
         * Verify that the contents on disk for the given index is deleted; if not, delete the contents.
         * @param mergedSegmentPublisher merged segment publisher
                repositoriesService,
                    try {
        /**
        this.nodeMappingRefreshAction = nodeMappingRefreshAction;
        final SnapshotShardsService snapshotShardsService,
         * Why the index was removed
                    "{} cluster-manager marked shard as initializing, but shard has state [{}], resending shard started to {}",
                }
         * @param targetNode             the node where this shard will be recovered
import java.util.Set;
        RoutingNode localRoutingNode = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
    }
                inner
        if (localRoutingNode == null) {
 * The OpenSearch Contributors require contributions made to
        /**
        }
     */
        /**
            long primaryTerm,
        indexEventListeners.add(segmentReplicationSourceService);
        /**
    }
    private void sendFailShard(ShardRouting shardRouting, String message, @Nullable Exception failure, ClusterState state) {
     *
         * @throws IOException if an I/O exception occurs when creating the shard
        final Consumer<ShardId> globalCheckpointSyncer,
                        }
 *
import java.util.Iterator;
            final IndexShardRoutingTable indexShardRoutingTable = routingTable.shardRoutingTable(shardRouting.shardId());
    private final NodeMappingRefreshAction nodeMappingRefreshAction;
    @Override
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.FAILURE;
        final IndexShardState state = shard.state();
        U indexService(Index index);
         *
                // contents on disk because the index will later be re-imported as a
        final SegmentReplicationCheckpointPublisher checkpointPublisher,
        @Nullable
        RoutingNode localRoutingNode = state.getRoutingNodes().node(localNodeId);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                }
        U createIndex(IndexMetadata indexMetadata, List<IndexEventListener> builtInIndexListener, boolean writeDanglingIndices)
    private void createShard(DiscoveryNodes nodes, RoutingTable routingTable, ShardRouting shardRouting, ClusterState state) {
                String reason = null;
        } catch (Exception inner) {
        void updateShardState(
    }
                    state
     * @opensearch.internal
            }
        this.repositoriesService = repositoriesService;
            }
        /**
    }
         * @return a new shard
     * An allocated index
    /**
                        new NodeMappingRefreshAction.NodeMappingRefreshRequest(
                // asserting that either this index is already in the graveyard, or the
        assert shardRouting.initializing() : "only allow shard creation for initializing shard but was " + shardRouting;
                        + "], mark shard as started",
     *
                    logger.debug("{} removing shard (not active, current {}, new {})", shardId, currentRoutingEntry, newShardRouting);
import org.opensearch.snapshots.SnapshotShardsService;
     */
        /**
            ShardRouting shardRouting,
import org.opensearch.index.shard.PrimaryReplicaSyncer.ResyncTask;
                clusterState.version(),
                // node was not part of the cluster. In this case, try reading the index
                    "[{}][{}] failed to remove shard after failure ([{}])",
        for (ShardRouting shardRouting : localRoutingNode) {
 * license agreements. See the NOTICE file distributed with
         * @param currentIndexMetadata the current index metadata
        if (sendShardFailure) {
                } else {
                    shardRouting,
                }
            /**
                }
        if (shardRouting.initializing() && (state == IndexShardState.STARTED || state == IndexShardState.POST_RECOVERY)) {
            }
import java.util.Collections;
         * like the shards files, state and transaction logs are kept around in the case of a disaster recovery.
                logger.trace(
                        + clusterManagerNode
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.CLOSED;
        default void updateShardIngestionState(IndexMetadata indexMetadata) {};
        this.settings = settings;
            snapshotShardsService,
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.NO_LONGER_ASSIGNED;
         */
                + currentRoutingEntry;
             */
import org.opensearch.core.action.ActionListener;
                }
        /**
            if (reason != null) {
                    createShard(nodes, routingTable, shardRouting, state);
        RecoveryState recoveryState = (RecoveryState) state;
        if (localRoutingNode == null) {
    }
         * @return IndexMetadata for the index loaded from disk
        // remove items from cache which are not in our routing table anymore and
 * specific language governing permissions and limitations
        }
                    indicesToCreate.computeIfAbsent(index, k -> new ArrayList<>()).add(shardRouting);
    private final RetentionLeaseSyncer retentionLeaseSyncer;
                        public void afterIndexShardStarted(IndexShard indexShard) {
            }
        final ClusterState state = event.state();
                if (metadata != null) {
            recoveryTargetService,
                sourceNode = nodes.get(primary.currentNodeId());
            return;
        try {
        final Settings settings,
    private final FailedShardHandler failedShardHandler = new FailedShardHandler();
        this.remoteStoreStatsTrackerFactory = remoteStoreStatsTrackerFactory;
 * under the License.
            clusterService.addHighPriorityApplier(this);
                    "can't find relocation source node for shard {} because it is assigned to an unknown node [{}].",
                recoveryTargetService,
            RetentionLeaseSyncer retentionLeaseSyncer,
                        assert false : e;
    }
                && indicesService.getShardOrNull(shardId) == null) {
                            // to the master. If we can't acquire the locks here immediately there might be a shard of this index still
                    nodes.getClusterManagerNode()
                if (shard == null) {
        final ShardStateAction shardStateAction,
    protected void doClose() {}
            final IndexMetadata indexMetadata = state.metadata().index(index);
            MergedSegmentPublisher mergedSegmentPublisher,
        DiscoveryNodes nodes,
            REOPENED,
                Shard shard = indexService.getShardOrNull(shardId.id());
    // package-private for testing
        }
                } else if (newShardRouting.initializing() && currentRoutingEntry.active()) {
        final long primaryTerm;
        assert currentRoutingEntry.isSameAllocation(shardRouting)
 * You may obtain a copy of the License at
         *                               the per-index listeners
    }
            boolean isPrimaryOrAllActiveShard = shardRouting.primary() || indexMetadata.isAllActiveIngestionEnabled();
        for (Map.Entry<Index, List<ShardRouting>> entry : indicesToCreate.entrySet()) {
            sourceNode = nodes.get(shardRouting.relocatingNodeId());
        this.threadPool = threadPool;
             */
                }
                indexSettings = indexService.getIndexSettings();
import org.opensearch.index.shard.IndexShard;
import org.opensearch.core.index.shard.ShardId;
         * - Updates the primary term if this shard is a primary.
import org.opensearch.cluster.routing.RecoverySource.Type;
        final ThreadPool threadPool,
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
            nodeMappingRefreshAction,
             * Persistent parts of the index like the shards files, state and transaction logs are kept around in the
            failAndRemoveShard(shardRouting, true, "failed to create shard", e, state);
        /**
        ) throws IOException;
                // if the cluster change indicates a brand new cluster, we only want
                // The deleted index was part of the previous cluster state, but not loaded on the local node
            peerRecoverySourceService,
                        newShardRouting
             */
                    null,
            logger.debug("[{}] creating index", index);
            }
                // the cluster-manager thinks we are active, but we don't have this shard at all, mark it as failed
import org.opensearch.index.shard.ShardNotFoundException;
                    String message = "cluster-manager "
        this.segmentReplicationTargetService = segmentReplicationTargetService;
            checkpointPublisher,
    ) {
            logger.warn(
                    indexSettings = null;
        final SegmentReplicationTargetService segmentReplicationTargetService,
        RoutingNode localRoutingNode = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
    ) {
 * Modifications Copyright OpenSearch Contributors. See
        // remove shards based on routing nodes (no deletion of data)
import org.opensearch.core.index.Index;
                assert indexMetadata != null || event.isNewCluster() : "index "
import org.opensearch.cluster.node.DiscoveryNode;
            referencedSegmentsPublisher
import org.opensearch.cluster.ClusterStateApplier;
import org.opensearch.cluster.ClusterChangedEvent;
                );
        /**
 * compatible open source license.
            indicesService.createShard(
            if (failedShardsCache.containsKey(shardId) == false) {
                ),
        final MergedSegmentWarmerFactory mergedSegmentWarmerFactory,
    }
             * The index should be removed and all associated resources released. Persistent parts of the index
        RoutingTable routingTable,
                indexService = indicesService.createIndex(indexMetadata, updatedIndexEventListeners, true);
import org.opensearch.index.IndexService;
     */
            }
    ) {
import java.util.ArrayList;
        for (AllocatedIndex<? extends Shard> indexService : indicesService) {
                if (entry.getValue().size() > 0
    private final MergedSegmentPublisher mergedSegmentPublisher;
                for (ShardRouting shardRouting : entry.getValue()) {
        final AllocatedIndices<? extends Shard, ? extends AllocatedIndex<? extends Shard>> indicesService,
        RoutingNode localRoutingNode = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
         * Creates a new {@link IndexService} for the given metadata.
            clusterService,
        deleteIndices(event); // also deletes shards of deleted indices
                    nodeMappingRefreshAction.nodeMappingRefresh(
                    logger.debug("{} removing shard (not active, current {}, new {})", shardId, currentRoutingEntry, newShardRouting);
                } else {
                            }
import org.opensearch.common.settings.Settings;
                    // this can happen if the node was isolated/gc-ed, rejoins the cluster and a new shard with the same allocation id
        void removeShard(int shardId, String message);
        if (DiscoveryNode.isDataNode(settings) || DiscoveryNode.isClusterManagerNode(settings)) {
                                sendFailShard(shardRouting, "failed to update index (" + reason + ")", e, state);
                ShardId shardId = currentRoutingEntry.shardId();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            segmentReplicationSourceService,
            // only recover from started primary, if we can't find one, we will do it next round
                    && entry.getValue().get(0).recoverySource().getType() == Type.SNAPSHOT
                if (indexService.updateMapping(null, indexMetadata) && sendRefreshMapping) {
                            )
        this.checkpointPublisher = checkpointPublisher;
                    // state may result in a new shard being initialized while having the same allocation id as the currently started shard.
    private final Settings settings;
        final MergedSegmentPublisher mergedSegmentPublisher,
import org.opensearch.indices.replication.SegmentReplicationSourceService;
    private void failMissingShards(final ClusterState state) {
        // we only create indices for shards that are allocated
                    // once all shards are allocated
        final String localNodeId = state.nodes().getLocalNodeId();
        }
                return indexRef.getShardOrNull(shardId.id());
import java.util.Objects;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        void removeIndex(Index index, IndexRemovalReason reason, String extraInfo);
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        }
        String message,
                shardRouting,
    private void createOrUpdateShards(final ClusterState state) {
                    || previousState.blocks().hasGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK);
                sourceNode,
    @Override
                        + " has not removed previously failed shard. resending shard failure";
                && failedShardsCache.containsKey(shardId) == false
         * Updates the metadata of this index. Changes become visible through {@link #getIndexSettings()}.
            return;
         * @param mergedSegmentWarmerFactory factory for merged segment warmer
import java.util.concurrent.TimeUnit;
import org.opensearch.cluster.ClusterState;
                ShardRouting newShardRouting = localRoutingNode == null ? null : localRoutingNode.getByShardId(shardId);
                    "master marked shard as active, but shard has not been created, mark shard as failed",
            DiscoveryNodes discoveryNodes
        RecoveryState recoveryState();
         * Deletes an index that is not assigned to this node. This method cleans up all disk folders relating to the index
            final Set<String> inSyncIds = indexMetadata.inSyncAllocationIds(shard.shardId().id());
     */
        } catch (ShardNotFoundException e) {
         * @param writeDanglingIndices   whether dangling indices information should be written
         */
     *
            if (primary.active()) {
                }
        final SnapshotShardsService snapshotShardsService,
            // for cluster-manager to confirm a shard started message (either cluster-manager failover, or a cluster event before
        for (AllocatedIndex<? extends Shard> indexService : indicesService) {
            /**
            );
                    indicesService.removeIndex(indexService.index(), FAILURE, "removing index (" + reason + ")");
        if (!lifecycle.started()) {
                        }
         */
                } else if (newShardRouting.isSameAllocation(currentRoutingEntry) == false) {
             */
import org.apache.logging.log4j.LogManager;
import org.opensearch.index.IndexSettings;
     * @param event the cluster changed event
        final SegmentReplicationCheckpointPublisher checkpointPublisher,
                        logger.warn(() -> new ParameterizedMessage("[{}] failed to complete pending deletion for index", index), e);
    private void updateIndices(ClusterChangedEvent event) {
        }
            AllocatedIndex<? extends Shard> indexService = indicesService.indexService(shardRouting.shardId().getIndex());
            final IndexMetadata indexMetadata = clusterState.metadata().index(shard.shardId().getIndex());
         * @param index {@code Index} to make sure its deleted from disk
            if (ClusterChangedEvent.indexMetadataChanged(currentIndexMetadata, newIndexMetadata)) {
            final IndexMetadata currentIndexMetadata = indexService.getIndexSettings().getIndexMetadata();
    public void handleRecoveryDone(ReplicationState state, ShardRouting shardRouting, long primaryTerm) {
            threadPool,
        RoutingNode localRoutingNode = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
        // are going to recover them again once state persistence is disabled (no cluster-manager / not recovered)
import java.util.concurrent.ConcurrentMap;
            for (AllocatedIndex<? extends Shard> indexService : indicesService) {
    /**
    /**
        try {
            segmentReplicationTargetService,
                // TODO: can we remove this? Is resending shard failures the responsibility of shardStateAction?
                    }
            if (indexSettings != null) {
     * @opensearch.internal
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
                    state,
         * @throws IndexShardRelocatedException if shard is marked as relocated and relocation aborted
            ReferencedSegmentsPublisher referencedSegmentsPublisher
     * Notifies cluster-manager about shards that don't exist but are supposed to be active on this node.
        for (final ShardRouting shardRouting : localRoutingNode) {
    private final SegmentReplicationTargetService segmentReplicationTargetService;
        }
    private final ThreadPool threadPool;
    private void updateShard(
                }
import java.io.IOException;
         * @param repositoriesService    service responsible for snapshot/restore
                        shardId,
         */
            NO_LONGER_ASSIGNED,
        removeShards(state);   // removes any local shards that doesn't match what the cluster-manager expects
    }
     */
                    indexService.removeShard(shardId.id(), "removing shard (stale copy)");
                // which is what happens on node startup when an index was deleted while the
    private void createIndices(final ClusterState state) {
        indexEventListeners.add(remoteStoreStatsTrackerFactory);
                    }
                    shardRouting.shardId(),
                if (indicesService.indexService(index) == null) {
         * @throws IOException                  if shard state could not be persisted
                        );
        this.indicesService = indicesService;
 */
            DELETED,
import org.opensearch.cluster.routing.RoutingTable;
        for (Iterator<Map.Entry<ShardId, ShardRouting>> iterator = failedShardsCache.entrySet().iterator(); iterator.hasNext();) {
                List<IndexEventListener> updatedIndexEventListeners = new ArrayList<>(builtInIndexListener);
import java.util.HashSet;
            try {
         * Checks if index requires refresh from master.
         * @param primaryTerm                 the new primary term
            throw new IllegalStateException(
     * This method does not delete the shard data.
        assert localNodeId != null;
                checkpointPublisher,
        final Set<Index> indicesWithShards = new HashSet<>();
                inner
                + shardRouting
                                state.nodes().getLocalNodeId()
        DiscoveryNode sourceNode = null;
            PeerRecoveryTargetService recoveryTargetService,
            final long primaryTerm = state.metadata().index(shardRouting.index()).primaryTerm(shardRouting.id());
        final MergedSegmentWarmerFactory mergedSegmentWarmerFactory,
import org.opensearch.cluster.action.shard.ShardStateAction;
import org.apache.logging.log4j.Logger;
    public interface AllocatedIndex<T extends Shard> extends Iterable<T>, IndexComponent {
/*
        // we need to clean the shards and indices we have on this node, since we
                        @Override
         * @param newIndexMetadata the new index metadata
    private void updateFailedShardsCache(final ClusterState state) {
                            indicesService.processPendingDeletes(index, indexSettings, new TimeValue(30, TimeUnit.MINUTES));
            throw e;
                );
            if (sourceNode == null) {
         * @param globalCheckpointSyncer a callback when this shard syncs the global checkpoint
                    sendFailShard(shardRouting, failShardReason, e, state);
        ShardId shardId();
        RoutingTable routingTable = state.routingTable();
                shard.updateShardIngestionState(indexMetadata);
            ShardLockObtainFailedException;
                    shardRouting.getId(),
        final String localNodeId = state.nodes().getLocalNodeId();
                    // fail shards that would be created or updated by createOrUpdateShards
    ) {
    /**
         * Returns the shard id of this shard.
        createOrUpdateShards(state);
            ShardId shardId = shardRouting.shardId();
        public void accept(final IndexShard.ShardFailure shardFailure) {
    private static final Logger logger = LogManager.getLogger(IndicesClusterStateService.class);
 * @opensearch.internal
        );
    private final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;
                indicesWithShards.add(shardRouting.index());
                    logger.trace("[{}] re-sending failed shard [{}], reason [{}]", matchedRouting.shardId(), matchedRouting, message);
import org.opensearch.ResourceAlreadyExistsException;
                    "master "
             * The index is deleted. Persistent parts of the index  like the shards files, state and transaction logs are removed once
            mergedSegmentWarmerFactory,
            Arrays.asList(peerRecoverySourceService, recoveryTargetService, searchService, snapshotShardsService)
            if (shardRouting.initializing() == false
     *
                logger.trace("ignoring initializing shard {} - no source node can be found.", shardRouting.shardId());
        final PrimaryReplicaSyncer primaryReplicaSyncer,
        if (localRoutingNode != null) { // null e.g. if we are not a data node
    public synchronized void handleRecoveryFailure(ShardRouting shardRouting, boolean sendShardFailure, Exception failure) {
                    shardStateAction.localShardFailed(matchedRouting, message, null, SHARD_STATE_ACTION_LISTENER, state);
                if (clusterManagerNode != null) {
                shardStateAction.shardStarted(
         * This method assumes that an index is already deleted in the cluster state and/or explicitly
import org.opensearch.indices.recovery.RecoveryListener;
                sendFailShard(
                    shardRouting.getIndexName(),
        try {
                failure
                        true,
        try {
         * @param index the index to remove
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
                indexShardRoutingTable,
        final RepositoriesService repositoriesService,
 *
import org.opensearch.cluster.routing.ShardRouting;
            final Index index = indexService.index();
             * all resources are released.
                final IndexMetadata metadata = previousState.metadata().index(index);
                );
         */
                logger.trace(
            failedShardsCache.clear();
import java.util.function.BiConsumer;
            AllocatedIndex<? extends Shard> indexService = indicesService.indexService(index);
         * @param primaryReplicaSyncer        the primary-replica resync action to trigger when a term is increased on a primary
 * GitHub history for details.
        }
     * Allocated indices
         * @param sourceNode             the source node to recover this shard from (it might be null)
         */
    /**
        ShardRouting shardRouting,
            : "local shard has a different allocation id but wasn't cleaned by removeShards. "
         * Returns an IndexService for the specified index if exists otherwise returns <code>null</code>.
            primaryReplicaSyncer,
                if (shard != null && shard.routingEntry().isSameAllocation(shardRouting)) {
                        for (final ShardRouting shardRouting : localRoutingNode) {
    private final boolean sendRefreshMapping;
                if (newShardRouting == null) {
     * Finds the routing source node for peer recovery, return null if its not found. Note, this method expects the shard
                    clusterState
            }
            if (failedShardsCache.containsKey(shardRouting.shardId()) == false) {
    private final RepositoriesService repositoriesService;
                ShardRouting currentRoutingEntry = shard.routingEntry();
            ShardRouting primary = routingTable.shardRoutingTable(shardRouting.shardId()).primaryShard();
            logger.error("Failed to update shard ingestion state", e);
        } catch (Exception e) {
    /**
        final NodeMappingRefreshAction nodeMappingRefreshAction,
        this.globalCheckpointSyncer = globalCheckpointSyncer;
    // a list of shards that failed during recovery
            AllocatedIndex<? extends Shard> indexService = null;
                final String failShardReason;
                    );
                failedShardHandler,
         * Updates the shard state based on an incoming cluster state:
            for (Shard shard : indexService) {
 * ownership. Elasticsearch licenses this file to you under
            } else {
                    logger.trace("can't find replica source node because primary shard {} is assigned to an unknown node.", primary);
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
            CLOSED,
        final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
        final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
    @Override
                indicesService.deleteUnassignedIndex("deleted index was not assigned to local node", metadata, state);
        IndexShardState state();
                + "cluster state: "
                mergedSegmentWarmerFactory,
     * @param state new cluster state
         * but does not deal with in-memory structures. For those call {@link #removeIndex(Index, IndexRemovalReason, String)}
         * - Updates and persists the new routing value.
        final MergedSegmentPublisher mergedSegmentPublisher,
            } else if (previousState.metadata().hasIndex(index)) {
                        "shard failure, reason [" + shardFailure.reason + "]",
                    + index
        this(
            } else {
                    }
    }
        ShardRouting shardRouting
        return sourceNode;
        // create map of indices to create with shards to fail if index creation fails
        this.shardStateAction = shardStateAction;
         * Removes the given index from this service and releases all associated resources. Persistent parts of the index
        final SegmentReplicationTargetService segmentReplicationTargetService,
            }
        this.primaryReplicaSyncer = primaryReplicaSyncer;
import org.opensearch.index.shard.IndexShardRelocatedException;
            // the cluster-manager thinks we are initializing, but we are already started or on POST_RECOVERY and waiting
import org.opensearch.cluster.metadata.IndexMetadata;
                    // this can happen when cluster state batching batches activation of the shard, closing an index, reopening it
         * @opensearch.api
        ClusterState state
        failAndRemoveShard(shardRouting, sendShardFailure, "failed recovery", failure, clusterService.state());
                () -> new ParameterizedMessage(
                            indexMetadata.getIndexUUID(),
import org.opensearch.index.shard.IndexEventListener;
                );
            );
        }
                reason = indexMetadata.getState() == IndexMetadata.State.CLOSE ? CLOSED : REOPENED;
        this.referencedSegmentsPublisher = referencedSegmentsPublisher;
import org.opensearch.threadpool.ThreadPool;
        boolean sendShardFailure,
            }
        final ClusterService clusterService,
import org.opensearch.cluster.node.DiscoveryNodes;
        T createShard(
            if (logger.isTraceEnabled()) {
            }
                final IndexMetadata metadata = indicesService.verifyIndexIsDeleted(index, event.state());
    private final Consumer<ShardId> globalCheckpointSyncer;
        }
        enum IndexRemovalReason {
         */
        final ClusterState state = event.state();
         */
            );
        ClusterState clusterState
    private void removeIndices(final ClusterChangedEvent event) {
            } else if (indicesWithShards.contains(index) == false) {
        void processPendingDeletes(Index index, IndexSettings indexSettings, TimeValue timeValue) throws IOException, InterruptedException,
            inner.addSuppressed(failure);
                            logger.warn("[{}] failed to lock all shards for index - interrupted", index);
        /**
        RoutingNode localRoutingNode = state.getRoutingNodes().node(localNodeId);
             * The index has been closed. The index should be removed and all associated resources released. Persistent parts of the index
                    protected void doRun() throws Exception {
        }
            }
    private final SegmentReplicationCheckpointPublisher checkpointPublisher;
    }
     */
    }
                    logger.debug(
        }
                            indexShard.refresh("refresh to upload metadata to remote store");
                indicesService.removeIndex(index, DELETED, "index no longer part of the metadata");
            final IndexSettings indexSettings;
                        + state
                iterator.remove();
    ) {
            } else {
 * Service to update the cluster state for multiple indices
 * this file be licensed under the Apache-2.0 license or a
        final List<IndexEventListener> indexEventListeners = new ArrayList<>(
            updateShardIngestionState(shard, indexMetadata, shardRouting);
                        } catch (InterruptedException e) {
         * Returns shard for the specified id if it exists otherwise returns <code>null</code>.
    }
     * @param state new cluster state
                    @Override
                + " local: "
        for (AllocatedIndex<? extends Shard> indexService : indicesService) {
        final ClusterState state = event.state();
import org.opensearch.index.seqno.RetentionLeaseSyncer;
            }
        this.clusterService = clusterService;
     * Deletes indices (with shard data).
        final PeerRecoverySourceService peerRecoverySourceService,
         * Returns shard with given id.
            RepositoriesService repositoriesService,
            for (ShardRouting shardRouting : localRoutingNode) {
                            if (shardRouting.index().equals(index) && failedShardsCache.containsKey(shardRouting.shardId()) == false) {
import org.opensearch.env.ShardLockObtainFailedException;
                    && indexMetadata.getSettings().getAsBoolean(SETTING_REMOTE_STORE_ENABLED, false)) {
            Consumer<ShardId> globalCheckpointSyncer,
         */
 */
 * this work for additional information regarding copyright
            }
/**
         */
            }
        this.mergedSegmentPublisher = mergedSegmentPublisher;
import org.opensearch.repositories.RepositoriesService;
                if (sourceNode == null) {
            sourceNode = findSourceNodeForPeerRecovery(logger, routingTable, nodes, shardRouting);
    final AllocatedIndices<? extends Shard, ? extends AllocatedIndex<? extends Shard>> indicesService;
            if (matchedRouting == null || matchedRouting.isSameAllocation(failedShardRouting) == false) {
                primaryTerm,
import org.apache.logging.log4j.message.ParameterizedMessage;
            shard.updateShardState(
                indexSettings = new IndexSettings(metadata, settings);
        this.sendRefreshMapping = settings.getAsBoolean("indices.cluster.send_refresh_mapping", true);
        final PrimaryReplicaSyncer primaryReplicaSyncer,
                    failShardReason = "failed to create index";
        /**
            ShardRouting matchedRouting = localRoutingNode.getByShardId(failedShardRouting.shardId());
            /**
         *
 * software distributed under the License is distributed on an
                    };
        final SegmentReplicationSourceService segmentReplicationSourceService,
    // we keep track of these shards in order to prevent repeated recovery of these shards on each cluster state update
import org.opensearch.index.IndexComponent;
                    updateShard(nodes, shardRouting, shard, routingTable, state);
                    shardRouting,
        final SearchService searchService,
             * The index has been reopened. The index should be removed and all associated resources released. Persistent parts of the index
                } catch (Exception e) {
         * @param recoveryTargetService  recovery service for the target
                }
 * SPDX-License-Identifier: Apache-2.0
                } else if (newShardRouting.primary() && currentRoutingEntry.primary() == false && newShardRouting.initializing()) {
import org.opensearch.gateway.GatewayService;
        this.recoveryTargetService = recoveryTargetService;
        default T getShardOrNull(ShardId shardId) {
    protected void doStop() {
                    failShardReason = "failed to update mapping for index";
                if (indexService == null) {
                    // and assigning an initializing primary to this node
        createIndices(state);
                        indexService.updateMetadata(currentIndexMetadata, newIndexMetadata);
        final Map<Index, List<ShardRouting>> indicesToCreate = new HashMap<>();
                final Index index = shardRouting.index();
     * @param event cluster change event
                () -> new ParameterizedMessage(
        void updateMetadata(IndexMetadata currentIndexMetadata, IndexMetadata newIndexMetadata);
         * Creates a shard for the specified shard routing and starts recovery.
                            logger.warn("[{}] failed to lock all shards for index - timed out after 30 seconds", index);
                        "{} removing shard (stale allocation id, stale {}, new {})",
    }
        final Settings settings,
                    // we can just remove the shard without cleaning it locally, since we will clean it in IndicesStore
         * @param clusterState {@code ClusterState} to ensure the index is not part of it
     */
                            indexMetadata.getIndex().getName(),
        assert localNodeId != null;
            // we managed to tell the cluster-manager we started), mark us as started
        } catch (Exception inner) {
    }
    /**
                        currentRoutingEntry,
            primaryTerm = indexMetadata.primaryTerm(shard.shardId().id());
 * not use this file except in compliance with the License.
import org.opensearch.indices.recovery.PeerRecoverySourceService;
                    logger.debug("{} removing shard (not allocated)", shardId);
             * like the shards files, state and transaction logs are kept around in the case of a disaster recovery.
 */
         */
                    shardRouting.relocatingNodeId()
                    shardRouting.getId(),
import org.opensearch.common.annotation.PublicApi;
                    indexService.removeShard(shardId.id(), "removing shard (not allocated)");
        if (localRoutingNode == null) {
            if (failure != null) inner.addSuppressed(failure);
                    + "have been deleted or the cluster must be new";
    private final PeerRecoveryTargetService recoveryTargetService;
         * @throws ResourceAlreadyExistsException if the index already exists.
        final PeerRecoveryTargetService recoveryTargetService,
                }
        final IndicesService indicesService,
                new RecoveryListener(shardRouting, primaryTerm, this),
        /**
                inSyncIds,
                assert indexService != null : "index " + shardId.getIndex() + " should have been created by createIndices";
                // First, though, verify the precondition for applying this case by
    private void updateShardIngestionState(Shard shard, IndexMetadata indexMetadata, ShardRouting shardRouting) {
        }
            }
        /**
            }
            ShardRouting failedShardRouting = iterator.next().getValue();
     */
    }
    }
        final NodeMappingRefreshAction nodeMappingRefreshAction,
    /**
        final ShardRouting currentRoutingEntry = shard.routingEntry();
                    );
    }
                logger.debug("[{}] cleaning index, no longer part of the metadata", index);
         * through index tombstones.
import org.opensearch.index.seqno.GlobalCheckpointSyncAction;
                            // holding on to the lock due to a "currently canceled recovery" or so. The shard will delete itself BEFORE the
     *
                    public void onFailure(Exception e) {
     * Removes shards that are currently loaded by indicesService but have disappeared from the routing table of the current node.
             * Shard of this index were previously assigned to this node but all shards have been relocated.
        try {
                // to remove the in-memory structures for the index and not delete the
    public interface AllocatedIndices<T extends Shard, U extends AllocatedIndex<T>> extends Iterable<U> {
        @PublicApi(since = "1.0.0")
        for (Index index : event.indicesDeleted()) {
         * @param routingTable                the shard routing table
                "trying to find source node for peer recovery when routing state means no peer recovery: " + shardRouting
            logger.debug("{} creating shard with primary term [{}]", shardRouting.shardId(), primaryTerm);
         * @param extraInfo extra information that will be used for logging and reporting
            U indexRef = indexService(shardId.getIndex());
import org.opensearch.indices.replication.SegmentReplicationTargetService;
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.REOPENED;
    IndicesClusterStateService(
                    } catch (Exception e) {
            @Nullable DiscoveryNode sourceNode,
                    failAndRemoveShard(
            remoteStoreStatsTrackerFactory,
        } catch (Exception e) {
        ShardRouting routingEntry();
                    }
    private final MergedSegmentWarmerFactory mergedSegmentWarmerFactory;
            /**
    }
                    indicesService.removeIndex(index, FAILURE, "removing index (mapping update failed)");
     * as we wait for enough shard copies to exist in the cluster before deleting shard data (triggered by
 * KIND, either express or implied.  See the License for the
                } else {
import java.util.function.Consumer;
            BiConsumer<IndexShard, ActionListener<ResyncTask>> primaryReplicaSyncer,
        indexEventListeners.add(segmentReplicationTargetService);
            if (indexRef != null) {
        // Doesn't make sense to manage shards on non-master and non-data nodes
                mergedSegmentPublisher,
        }
        updateIndices(event); // can also fail shards, but these are then guaranteed to be in failedShardsCache
            }
         *
                        shardFailure.cause,
        final String localNodeId = state.nodes().getLocalNodeId();
            threadPool.generic().execute(() -> {
            throws IOException;
                        + " marked shard as initializing, but shard state is ["
        final RetentionLeaseSyncer retentionLeaseSyncer,
         * @param shardRouting           the shard routing
            indicesService,
    public IndicesClusterStateService(
            DiscoveryNode targetNode,
    public interface Shard {
    private void deleteIndices(final ClusterChangedEvent event) {
        }
         */
        removeIndices(event); // also removes shards of removed indices
            if (nodes.getClusterManagerNode() != null) {
                        clusterService.state()
                                newIndexMetadata.getIndexUUID(),
            retentionLeaseSyncer,
                // metadata from disk. If its not there, there is nothing to delete.
     */
            );
                            // we are waiting until we can lock the index / all shards on the node and then we ack the delete of the store
/*
                    RoutingNode localRoutingNode = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
        }
            if (indexService != null) {
            shardStateAction.localShardFailed(shardRouting, message, failure, SHARD_STATE_ACTION_LISTENER, state);
    }
    private void failAndRemoveShard(
         *   See {@link ReplicationTracker#updateFromClusterManager(long, Set, IndexShardRoutingTable)} for details.
            mergedSegmentPublisher,
             * case of a disaster recovery.
             */
                    reason = "mapping update failed";
                nodes
        DiscoveryNodes nodes,
                indicesService.removeIndex(index, reason, "removing index (" + reason + ")");
import org.opensearch.indices.IndicesService;
            }
        }
            settings,
                nodes.getLocalNode(),
     * Resends shard failures for shards that are still marked as allocated to this node but previously failed.
        T getShardOrNull(int shardId);
         */
        );
        Shard shard,
            final IndexMetadata indexMetadata = state.metadata().index(index);
                    final IndexEventListener refreshListenerAfterSnapshotRestore = new IndexEventListener() {
    // for tests
     * A shard
            final IndexMetadata newIndexMetadata = state.metadata().index(index);
     * Removes indices that have no shards allocated to this node or indices whose state has changed. This does not delete the shard data
    public synchronized void applyClusterState(final ClusterChangedEvent event) {
            failAndRemoveShard(shardRouting, true, "failed updating shard routing entry", e, clusterState);
         * @param indexMetadata          the index metadata to create the index for
        } else if (shardRouting.relocatingNodeId() != null) {
                    shardRouting.shardId(),
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.DELETED;
     *
import java.util.Map;

import org.opensearch.repositories.RepositoriesService;
                            indexShard.store(),
            snapshot,
                            + indexId.getName()
                    }
                            commitGeneration = lastRemoteUploadedIndexCommit.getGeneration();
                        }
        final IndexId indexId,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
 * under the License.
 * specific language governing permissions and limitations
                }
        );
                @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
                Map<ShardId, IndexShardSnapshotStatus> snapshotShards = shardSnapshots.getOrDefault(snapshot, emptyMap());
 * See package level documentation of {@link org.opensearch.snapshots} for details.
import org.opensearch.cluster.node.DiscoveryNode;
        if (t.getCause() == null) {
        new TransportRequestDeduplicator<>();
                    "snapshot triggered on a new primary following failover and cannot proceed until promotion is complete"
import org.opensearch.cluster.ClusterStateListener;
                    sb.append("[");
                            final IndexShardSnapshotStatus.Copy indexShardSnapshotStatus = localShard.getValue().asCopy();
                    // we flush first to make sure we get the latest writes snapshotted
                            logger.warn(
     * The method returns {@code null} if global and local checkpoint are different for a shard since no safe unique
import org.opensearch.transport.TransportException;
                    cancelRemoved(currentSnapshots);
        try {
    }
/**
                    IndexCommit snapshotIndexCommit = null;
                            + ", shard "
     * sequence number has not changed and its history- and force-merge-uuid have not changed.
                    entry.remoteStoreIndexShallowCopy(),
    }
            if (currentMasterNodeId != null && currentMasterNodeId.equals(previousClusterManagerNodeId) == false) {
     * @param snapshotStatus snapshot status
            StringBuilder sb = new StringBuilder();
                    long primaryTerm = indexShard.getOperationPrimaryTerm();
                IOUtils.close(wrappedSnapshot);
                        public void onFailure(Exception e) {
                synchronized (shardSnapshots) {
                            + snapshot.getSnapshotId()
    private final RepositoriesService repositoriesService;
            }
                snapshot(
                            if (stage == Stage.DONE) {
                    for (Map.Entry<ShardId, IndexShardSnapshotStatus> localShard : localShards.entrySet()) {
        }
     * </p>
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;
    @Nullable
        threadPool.executor(ThreadPool.Names.SNAPSHOT).execute(() -> {
                    sb.append("]");
                                logger.debug(
import org.opensearch.cluster.SnapshotsInProgress.ShardState;
                            snapshot.getSnapshotId(),
                        return UpdateIndexShardSnapshotStatusResponse.INSTANCE;
                    long endTime = threadPool.relativeTimeInMillis();
            if (indexShardState == IndexShardState.CREATED || indexShardState == IndexShardState.RECOVERING) {
        }
 * software distributed under the License is distributed on an
 * starting and stopping shard level snapshots.
    ) {
                        snapshotShards.getKey().getSnapshotId()
                        indexMetadata
        }
    protected void doStart() {}
            SnapshotsInProgress currentSnapshots = event.state().custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
    public void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
     *
 * compatible open source license.
    // A map of snapshots to the shardIds that we already reported to the cluster-manager as failed
     */
        remoteFailedRequestDeduplicator.executeOnce(
     * @return map of shard id to snapshot status
     * @return shard state id or {@code null} if none can be used
    private final TransportRequestDeduplicator<UpdateIndexShardSnapshotStatusRequest> remoteFailedRequestDeduplicator =
                t = t.getCause();
                assert indexId != null;
    @Override
            for (Map.Entry<Snapshot, Map<ShardId, IndexShardSnapshotStatus>> snapshotShards : shardSnapshots.entrySet()) {
import org.opensearch.cluster.service.ClusterService;
            String previousClusterManagerNodeId = event.previousState().nodes().getClusterManagerNodeId();
        ActionListener<String> listener
                transportService.getLocalNode(),
 */
        sendSnapshotShardUpdate(
        Iterator<Map.Entry<Snapshot, Map<ShardId, IndexShardSnapshotStatus>>> it = shardSnapshots.entrySet().iterator();
                            RemoteSegmentMetadata lastRemoteUploadedIndexCommit = indexShard.fetchLastRemoteUploadedSegmentMetadata();
            assert false : new AssertionError(e);
                        if (closedIndex) {
                                .entrySet()
import org.opensearch.index.shard.IndexEventListener;
            }
import org.opensearch.core.common.io.stream.StreamInput;
                        if (masterShard != null && masterShard.state().completed() == false) {
                            assert newGeneration.equals(snapshotStatus.generation());
                        if (closedIndex) {
            },
            return;
                            + (endTime - startTime)
                Map<ShardId, IndexShardSnapshotStatus> startedShards = null;
        } else {
                            + " and snapshot "
                                    snapshot.getRepository(),
     * have changed between two snapshots.
                        startedShards.put(shardId, IndexShardSnapshotStatus.newInitializing(shardSnapshotStatus.generation()));
                        ShardId shardId = localShard.getKey();
            }
                            logger.warn("Exception while reading latest metadata file from remote store");
                    logger.trace("[{}] [{}] updated snapshot state", snapshot, status);
                );
                    entry.version(),
                            indexShard.flush(new FlushRequest(shardId.getIndexName()).force(true));
                                        + "updating status on master",
            final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
        final Map<String, String> userCommitData = snapshotIndexCommit.getUserData();
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
            final Repository repository = repositoriesService.repository(snapshot.getRepository());
                            wrappedSnapshot = indexShard.acquireLastIndexCommit(false);
                if (startedShards != null && startedShards.isEmpty() == false) {
 *
            }
        return userCommitData.get(Engine.HISTORY_UUID_KEY)
import java.util.HashMap;
                                    snapshotStatus.generation()
            logger.warn("Failed to update snapshot state ", e);
                    indexId,
                            snapshotStatus,
        sendSnapshotShardUpdate(
                        userMetadata,
        TransportService transportService,
        ClusterService clusterService,
                            wrappedSnapshot = indexShard.acquireLastIndexCommitAndRefresh(true);
/*
                }
            if (indexShard.indexSettings().isSegRepEnabledOrRemoteNode() && indexShard.isPrimaryMode() == false) {
                    entry.userMetadata(),
                            snapshotIndexCommit = wrappedSnapshot.get();
                        }
import org.opensearch.index.shard.IndexShardState;
                throw new IndexShardSnapshotFailedException(shardId, "snapshot should be performed only on primary");
    @Override
                throw new IndexShardSnapshotFailedException(shardId, "shard didn't fully recover yet");
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
                        indexShard.store(),
                        @Override
import org.opensearch.transport.TransportRequestDeduplicator;
     * @param indexShard          Shard
            try {
import org.opensearch.cluster.SnapshotsInProgress;
        if (snapshotsInProgress == null) {
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                                    shardId
            final Map.Entry<Snapshot, Map<ShardId, IndexShardSnapshotStatus>> entry = it.next();
                                );
                            snapshotIndexCommit = wrappedSnapshot.get();
import org.opensearch.cluster.SnapshotsInProgress.ShardSnapshotStatus;
        remoteFailedRequestDeduplicator.clear();
                                    snapshot.snapshot(),
                        && localNodeId.equals(shardSnapshotStatus.nodeId())
                final Snapshot snapshot = entry.snapshot();
import org.opensearch.index.seqno.SequenceNumbers;
import org.opensearch.action.admin.indices.flush.FlushRequest;
    public Map<ShardId, IndexShardSnapshotStatus> currentSnapshotShards(Snapshot snapshot) {
    private void syncShardStatsOnNewMaster(ClusterChangedEvent event) {
        }
        } catch (Exception e) {
                            notifySuccessfulSnapshotShard(snapshot, shardId, newGeneration);
                            // cluster-manager knows about the shard and thinks it has not completed
            }
                                final IndexShardSnapshotStatus.Copy lastSnapshotStatus = snapshotStatus.asCopy();
                if (t.getMessage() != null) {
                                + "] for snapshot "
                    snapshotStatus.abortIfNotCompleted("snapshot has been removed in cluster state, aborting");
                            listener.onFailure(e);
                                logger.debug(
                }
     * @param snapshot  snapshot
            snapshot,
                            startTime,
                        logger.trace("[{}] - Adding shard to the queue", shardId);
                // this could happen if for some reason the cluster state update for aborting
                    repository.snapshotShard(
                sb.append(t.getClass().getSimpleName());
        this.threadPool = transportService.getThreadPool();
    private void notifyFailedSnapshotShard(final Snapshot snapshot, final ShardId shardId, final String failure) {
                    }
     */
                        }
import org.opensearch.repositories.IndexId;
                    if (snapshotStatus == null) {
import java.io.IOException;
                } else {
        }
                            + "for index "
    private final Map<Snapshot, Map<ShardId, IndexShardSnapshotStatus>> shardSnapshots = new HashMap<>();
                        reqListener.onFailure(exp);
                            }
                Map<ShardId, IndexShardSnapshotStatus> localShards = currentSnapshotShards(snapshot.snapshot());
                    final IndexCommit snapshotIndexCommit = wrappedSnapshot.get();
            return null;
        synchronized (shardSnapshots) {
                        indexShard.mapperService(),
    private void startNewSnapshots(SnapshotsInProgress snapshotsInProgress) {
            }
                    if (shardSnapshotStatus.state() == ShardState.INIT
                req,
                        if (startedShards == null) {
        }
            if (entryState == State.STARTED) {
        Settings settings,
import org.opensearch.threadpool.ThreadPool;
        IndicesService indicesService
                                    "[{}] new cluster-manager thinks the shard [{}] is not completed but the shard is done locally, "
import org.opensearch.common.concurrent.GatedCloseable;
                throw e;
                    @Override
    private final ClusterService clusterService;
                    } catch (IndexShardSnapshotFailedException e) {
                .collect(Collectors.toMap(IndexId::getName, Function.identity()));
 * Modifications Copyright OpenSearch Contributors. See
                        snapshot.getSnapshotId(),
import org.opensearch.transport.TransportResponseHandler;
import java.util.Map;
import org.opensearch.common.Nullable;
    ) {
import org.opensearch.core.index.snapshots.IndexShardSnapshotFailedException;
                        ShardSnapshotStatus masterShard = masterShards.get(shardId);
                    } else {
        // Clear request deduplicator since we need to send all requests that were potentially not handled by the previous
                new TransportResponseHandler<UpdateIndexShardSnapshotStatusResponse>() {
 * GitHub history for details.
            clusterService.addListener(this);
            if (indexShard.routingEntry().relocating()) {
    private void notifySuccessfulSnapshotShard(final Snapshot snapshot, final ShardId shardId, String generation) {
 * You may obtain a copy of the License at
                    startNewSnapshots(currentSnapshots);
                        && snapshotShards.containsKey(shardId) == false) {
        final long maxSeqNo = seqNumInfo.maxSeqNo;
    private static String getShardStateId(IndexShard indexShard, IndexCommit snapshotIndexCommit) throws IOException {
import org.opensearch.core.index.shard.ShardId;
                    shardId,
            shardId,
                    public void handleResponse(UpdateIndexShardSnapshotStatusResponse response) {
                        wrappedSnapshot.get(),
                            snapshotStatus.moveToFailed(threadPool.absoluteTimeInMillis(), failure);
                    }
        clusterService.removeListener(this);
        );
     * @param snapshot       snapshot
                            }
                // Abort all running shards for this snapshot
    }
                    logger.debug(
        RepositoriesService repositoriesService,
            final Map<ShardId, IndexShardSnapshotStatus> current = shardSnapshots.get(snapshot);
            new ShardSnapshotStatus(clusterService.localNode().getId(), ShardState.SUCCESS, generation)
            if (snapshotsInProgress.snapshot(snapshot) == null) {
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
                    logger.warn(() -> new ParameterizedMessage("[{}] [{}] failed to update snapshot state", snapshot, status), e);
        // abort any snapshots occurring on the soon-to-be closed shard
                        indexId,
                                    lastSnapshotStatus,
                            commitGeneration = snapshotIndexCommit.getGeneration();
                        @Override
     * @param snapshotIndexCommit IndexCommit for shard
                        return ThreadPool.Names.SAME;
                    } catch (IOException e) {
import java.util.function.Function;
                    snapshotStatus,
        for (SnapshotsInProgress.Entry snapshot : snapshotsInProgress.entries()) {
        final Map<String, Object> userMetadata,
        assert generation != null;
 * KIND, either express or implied.  See the License for the
                            commitGeneration,
    /** Updates the shard snapshot status by sending a {@link UpdateIndexShardSnapshotStatusRequest} to the cluster-manager node */
    }
            while (t != null) {
    // package private for testing
                        version,
                    public String executor() {
                                    "[{}] new cluster-manager thinks the shard [{}] is not completed but the shard failed locally, "
    private final TransportService transportService;
        if (maxSeqNo != seqNumInfo.localCheckpoint || maxSeqNo != indexShard.getLastSyncedGlobalCheckpoint()) {
            return current == null ? null : new HashMap<>(current);
    private void startNewShards(SnapshotsInProgress.Entry entry, Map<ShardId, IndexShardSnapshotStatus> startedShards) {
                    try {
     * Creates shard snapshot
                        snapshotStatus.abortIfNotCompleted("snapshot has been aborted");
                            + " is "
            }
                );
                        public void onResponse(String newGeneration) {
                    logger.debug(
        // First, remove snapshots that are no longer there
            listener.onFailure(e);
                            indexShard.acquireLockOnCommitData(snapshot.getSnapshotId().getUUID(), primaryTerm, commitGeneration);
    @Override
    }
import org.apache.logging.log4j.Logger;
                // This is a snapshot clone, it will be executed on the current master
    @Override
                    startNewShards(entry, startedShards);
                    @Override
                            indexId,
     * shard content for the same sequence number on a subsequent snapshot.
        this.transportService = transportService;
                    long startTime = threadPool.relativeTimeInMillis();
                    }
    private void snapshot(
                // do not snapshot when in the process of relocation of primaries so we won't get conflicts
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.SnapshotsInProgress.State;
        try {
import org.opensearch.index.engine.Engine;
            }
            final Snapshot snapshot = entry.getKey();
                            null,
                    final IndexShardSnapshotStatus snapshotStatus = snapshotShards.get(shard.getKey());
                            notifyFailedSnapshotShard(snapshot, shardId, failure);
                if (localShards != null) {
                    IndexMetadata indexMetadata = clusterService.state().metadata().index(indexId.getName());
                                    shardId
 */
import org.opensearch.cluster.metadata.IndexMetadata;
                                + shardId.getId()
                        shardId,
                        }
                }
                        if (shard.getValue().state() == ShardState.ABORTED && localNodeId.equals(shard.getValue().nodeId())) {
 * ownership. Elasticsearch licenses this file to you under
                if (shards.containsKey(shardId)) {
                }
            (req, reqListener) -> transportService.sendRequest(
            new ActionListener<Void>() {
                // running shards is missed, then the snapshot is removed is a subsequent cluster
        this.repositoriesService = repositoriesService;
                        }
     * shard state id can be used in this case because of the possibility of a primary failover leading to different
                for (final Map.Entry<ShardId, ShardSnapshotStatus> shard : entry.shards().entrySet()) {
import org.apache.logging.log4j.message.ParameterizedMessage;
        );
    /**
            }
            }
                Map<ShardId, IndexShardSnapshotStatus> shards = snapshotShards.getValue();
    }
                Map<ShardId, IndexShardSnapshotStatus> snapshotShards = shardSnapshots.getOrDefault(snapshot, emptyMap());
                            wrappedSnapshot.close();
                        } else {
                                notifySuccessfulSnapshotShard(snapshot.snapshot(), shardId, localShard.getValue().generation());
 */
                            primaryTerm,
                            commitGeneration = snapshotIndexCommit.getGeneration();
        final IndexShardSnapshotStatus snapshotStatus,
            }
                            indexFilesToFileLengthMap,
import org.apache.lucene.index.IndexCommit;
                if (t != null) {
                        indexShard.acquireLockOnCommitData(snapshot.getSnapshotId().getUUID(), primaryTerm, commitGeneration);
        final ShardId shardId,
                final IndexId indexId = indicesMap.get(shardId.getIndexName());
        }
    static String summarizeFailure(Throwable t) {
                final Snapshot snapshot = entry.snapshot();
    /**
     */
/*
                        indexShard.releaseLockOnCommitData(snapshot.getSnapshotId().getUUID(), primaryTerm, commitGeneration);
        }
}
                    new ActionListener<>() {
        final boolean remoteStoreIndexShallowCopy,
                    shardSnapshots.computeIfAbsent(snapshot, s -> new HashMap<>()).putAll(startedShards);
            }
    }
                                .stream()
import org.opensearch.common.util.io.IOUtils;
        this.indicesService = indicesService;
        }
                    @Override
        for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
            if (previousSnapshots.equals(currentSnapshots) == false) {
                    );
                    }
                                        + "updating status on the master",
    private void cancelRemoved(SnapshotsInProgress snapshotsInProgress) {
                }
    public SnapshotShardsService(
            if (entry.isClone()) {
                for (final Map.Entry<ShardId, ShardSnapshotStatus> shard : entry.shards().entrySet()) {
 * SPDX-License-Identifier: Apache-2.0
                                "Exception while acquiring lock on primaryTerm = {} and generation = {}",
    private final IndicesService indicesService;
    @Override
            return t.getClass().getSimpleName() + "[" + t.getMessage() + "]";
                                commitGeneration
 * not use this file except in compliance with the License.
                        // notify cluster-manager that abort has completed by moving to FAILED
                    try {
                    // Add all new shards to start processing on
import org.opensearch.index.shard.IndexShard;
            if (snapshot.state() == State.STARTED || snapshot.state() == State.ABORTED) {
     * Returns status of shards that are snapshotted on the node and belong to the given snapshot
            final Map<String, IndexId> indicesMap = entry.indices()
            + "-"
                public void onFailure(Exception e) {
                        }
                for (IndexShardSnapshotStatus snapshotStatus : entry.getValue().values()) {
import org.opensearch.index.snapshots.IndexShardSnapshotStatus.Stage;
                        }
                            } else {
                }
                }
                        } else {
import org.opensearch.cluster.ClusterChangedEvent;
        while (it.hasNext()) {
                }
    }
 * Licensed to Elasticsearch under one or more contributor
                    sb.append(t.getMessage());
                            final Stage stage = indexShardSnapshotStatus.getStage();
            } catch (Exception e) {
import org.apache.logging.log4j.LogManager;
                        throw e;
 *
            final Snapshot snapshot = entry.snapshot();
            GatedCloseable<IndexCommit> wrappedSnapshot = null;
            String currentMasterNodeId = event.state().nodes().getClusterManagerNodeId();
    /** Notify the cluster-manager node that the given shard has been successfully snapshotted **/
                        repository.snapshotRemoteStoreIndexShard(
        final String localNodeId = clusterService.localNode().getId();
                            }
    private static final Logger logger = LogManager.getLogger(SnapshotShardsService.class);
    }
        } catch (Exception e) {
    }
            return sb.toString();
                    }
import java.util.Iterator;
                            if (e instanceof AbortedSnapshotException) {
    }
            final State entryState = entry.state();
                            "Shallow Copy Snapshot Failed for Shard ["
     * Generates an identifier from the current state of a shard that can be used to detect whether a shard's contents
    }
                        logger.error(
    }
     * This method is executed on data node
     * <p>
import org.opensearch.transport.TransportService;
            SnapshotsInProgress previousSnapshots = event.previousState().custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                    }
import org.opensearch.repositories.Repository;
                    );
    public void clusterChanged(ClusterChangedEvent event) {
            + "-"
                                    snapshot,
                                    snapshot.snapshot(),
            shardId,
            final boolean closedIndex = indexService.getMetadata().getState() == IndexMetadata.State.CLOSE;
    }
                            final String failure;
                        );
                .stream()
                // abort any running snapshots of shards for the removed entry;
        }
                    public void handleException(TransportException exp) {
                        // due to CS batching we might have missed the INIT state and straight went into ABORTED
                                    "snapshot [{}] completed to [{}] with [{}] at generation [{}]",
        });
                        ActionListener.runBefore(listener, wrappedSnapshot::close),
import org.opensearch.core.action.ActionListener;
import org.opensearch.indices.IndicesService;
            // this is only useful on the nodes that can hold data
                            indexFilesToFileLengthMap = lastRemoteUploadedIndexCommit.getMetadata()
package org.opensearch.snapshots;
    /** Notify the cluster-manager node that the given shard failed to be snapshotted **/
            new UpdateIndexShardSnapshotStatusRequest(snapshot, shardId, status),
                            assert newGeneration != null;
import static java.util.Collections.emptyMap;
            }
                            snapshotIndexCommit,
        Version version,
            for (final Map.Entry<ShardId, IndexShardSnapshotStatus> shardEntry : startedShards.entrySet()) {
                                );
                    long commitGeneration = 0L;
                    @Override
                it.remove();
                            );
                    final ShardSnapshotStatus shardSnapshotStatus = shard.getValue();
                                + "]["
        final SequenceNumbers.CommitInfo seqNumInfo = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(userCommitData.entrySet());
                syncShardStatsOnNewMaster(event);
                                logger.warn(() -> new ParameterizedMessage("[{}][{}] failed to snapshot shard", shardId, snapshot), e);
                            if (logger.isDebugEnabled()) {
                                + ", releasing acquired lock from remote store"
import org.opensearch.index.IndexService;
                        "[{}] shard closing, abort snapshotting for snapshot [{}]",
                                failure = "aborted";
                }
    protected void doStop() {}
 * The OpenSearch Contributors require contributions made to
/*
                            notifyFailedSnapshotShard(snapshot, shard.getKey(), shard.getValue().reason());
                }
     *
                final IndexShardSnapshotStatus snapshotStatus = shardEntry.getValue();
 *
                SnapshotsService.UPDATE_SNAPSHOT_STATUS_ACTION_NAME,
                            } else if (stage == Stage.FAILURE) {
                            primaryTerm = lastRemoteUploadedIndexCommit.getPrimaryTerm();
                @Override
     */
                                logger.debug(
    /**
        this.clusterService = clusterService;
    private final ThreadPool threadPool;
                    final Map<ShardId, ShardSnapshotStatus> masterShards = snapshot.shards();
     * Checks if any shards were processed that the new cluster-manager doesn't know about
            new ShardSnapshotStatus(clusterService.localNode().getId(), ShardState.FAILED, failure, null)
            final IndexShardState indexShardState = indexShard.state();
 * This service runs on data nodes and controls currently running shard snapshots on these nodes. It is responsible for
        SnapshotsInProgress snapshotsInProgress = event.state().custom(SnapshotsInProgress.TYPE);
                    snapshot,
                if (remoteStoreIndexShallowCopy && indexShard.indexSettings().isRemoteStoreEnabled()) {
            )
                    public UpdateIndexShardSnapshotStatusResponse read(StreamInput in) {
                throw new IndexShardSnapshotFailedException(
                    Map<String, Long> indexFilesToFileLengthMap = null;
                throw new IndexShardSnapshotFailedException(shardId, "cannot snapshot while relocating");
                        getShardStateId(indexShard, snapshotIndexCommit),
            } else if (entryState == State.ABORTED) {
                public void onResponse(Void aVoid) {
                                failure = summarizeFailure(e);
     *
public class SnapshotShardsService extends AbstractLifecycleComponent implements ClusterStateListener, IndexEventListener {
                }
                    wrappedSnapshot = indexShard.acquireLastIndexCommit(true);
                                + snapshot.getSnapshotId()
     * A shard is assumed to have unchanged contents if its global- and local checkpoint are equal, its maximum
    protected void doClose() {
                                // but we think the shard failed - we need to make new cluster-manager know that the shard failed
 * this work for additional information regarding copyright
                            startedShards = new HashMap<>();
            }
                    }
                            closedIndex ? listener : ActionListener.runBefore(listener, wrappedSnapshot::close)
        synchronized (shardSnapshots) {
                        reqListener.onResponse(null);
                    );
            + maxSeqNo;
                                primaryTerm,
                continue;
                    final ShardId shardId = shard.getKey();
            + userCommitData.getOrDefault(Engine.FORCE_MERGE_UUID_KEY, "na")
                        "Time taken (in milliseconds) to complete shallow copy snapshot, "
import org.opensearch.Version;
            if (indexShard.routingEntry().primary() == false) {
        // cluster-manager again
        }
                        snapshotStatus,
        if (DiscoveryNode.isDataNode(settings)) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.stream.Collectors;
                    }
                        );
                }
                // shard has just been created, or still recovering
                                );
            final IndexShard indexShard = indexService.getShardOrNull(shardId.id());
                    }
                                // but we think the shard is done - we need to make new cluster-manager know that the shard is done
                            + shardId.getId()
                // state update, which is being processed here
                    sb.append("; nested: ");
                    shardId,
                final ShardId shardId = shardEntry.getKey();
                                logger.debug(() -> new ParameterizedMessage("[{}][{}] aborted shard snapshot", shardId, snapshot), e);
                                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getLength()));
        final Snapshot snapshot,
                    shards.get(shardId).abortIfNotCompleted("shard is closing, aborting");
    }
    private void sendSnapshotShardUpdate(final Snapshot snapshot, final ShardId shardId, final ShardSnapshotStatus status) {
 *
                                notifyFailedSnapshotShard(snapshot.snapshot(), shardId, indexShardSnapshotStatus.getFailure());
 */
                                + indexId.getName()

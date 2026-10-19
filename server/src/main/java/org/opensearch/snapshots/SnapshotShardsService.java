    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
                        public void onFailure(Exception e) {  
    private static String getShardStateId(IndexShard indexShard, IndexCommit snapshotIndexCommit) throws IOException {
                                        + "updating status on master",  
        final IndexId indexId,
 * Unless required by applicable law or agreed to in writing,
                                logger.debug(
 * SPDX-License-Identifier: Apache-2.0
                            logger.warn("Exception while reading latest metadata file from remote store");
import org.opensearch.index.shard.IndexShard;
                new TransportResponseHandler<UpdateIndexShardSnapshotStatusResponse>() {  
                .stream()
            + maxSeqNo;
                                notifyFailedSnapshotShard(snapshot.snapshot(), shardId, indexShardSnapshotStatus.getFailure());
                    try {  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
            }
                }  
            SnapshotsInProgress previousSnapshots = event.previousState().custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);  
                                failure = "aborted";  
                                );  
            snapshot,
        remoteFailedRequestDeduplicator.executeOnce(
                }
                        snapshotStatus,
            if (indexShard.routingEntry().primary() == false) {  
                Map<ShardId, IndexShardSnapshotStatus> startedShards = null;
            },
                    final ShardId shardId = shard.getKey();
        final boolean remoteStoreIndexShallowCopy,
                    public String executor() {
                        indexShard.mapperService(),  
                    snapshot,
                            assert newGeneration.equals(snapshotStatus.generation());  
        this.clusterService = clusterService;
            }
                }
                        logger.trace("[{}] - Adding shard to the queue", shardId);  
                    );
                // this could happen if for some reason the cluster state update for aborting  
 */
                                "Exception while acquiring lock on primaryTerm = {} and generation = {}",
                        if (shard.getValue().state() == ShardState.ABORTED && localNodeId.equals(shard.getValue().nodeId())) {
import org.opensearch.cluster.SnapshotsInProgress.State;  
     * @param snapshot  snapshot  
            final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());  
                Map<ShardId, IndexShardSnapshotStatus> snapshotShards = shardSnapshots.getOrDefault(snapshot, emptyMap());
                synchronized (shardSnapshots) {  
    public Map<ShardId, IndexShardSnapshotStatus> currentSnapshotShards(Snapshot snapshot) {  
        }  
import org.opensearch.cluster.SnapshotsInProgress.ShardSnapshotStatus;
/*  
import org.opensearch.common.concurrent.GatedCloseable;
                            null,  
    @Override
        } catch (Exception e) {  
 * this file be licensed under the Apache-2.0 license or a
                        @Override
            return sb.toString();  
                                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getLength()));  
     * Creates shard snapshot
                            + indexId.getName()
        final IndexShardSnapshotStatus snapshotStatus,  
        // cluster-manager again
        } else {
                    // we flush first to make sure we get the latest writes snapshotted
                            RemoteSegmentMetadata lastRemoteUploadedIndexCommit = indexShard.fetchLastRemoteUploadedSegmentMetadata();
                    } else {
                            + ", shard "
                                + indexId.getName()
    /** Notify the cluster-manager node that the given shard has been successfully snapshotted **/
     * sequence number has not changed and its history- and force-merge-uuid have not changed.
                            snapshotStatus,
                    final IndexCommit snapshotIndexCommit = wrappedSnapshot.get();  
import java.util.HashMap;  
                for (final Map.Entry<ShardId, ShardSnapshotStatus> shard : entry.shards().entrySet()) {  
    /** Updates the shard snapshot status by sending a {@link UpdateIndexShardSnapshotStatusRequest} to the cluster-manager node */
        if (DiscoveryNode.isDataNode(settings)) {
    }
import org.opensearch.cluster.ClusterStateListener;
                }
                                + ", releasing acquired lock from remote store"
                snapshot(  
                } else {  
 *  
    private final ClusterService clusterService;  
                        );
    }
                            commitGeneration = snapshotIndexCommit.getGeneration();
                public void onFailure(Exception e) {
public class SnapshotShardsService extends AbstractLifecycleComponent implements ClusterStateListener, IndexEventListener {  
                continue;
            if (entryState == State.STARTED) {
 * this work for additional information regarding copyright
                sb.append(t.getClass().getSimpleName());
        );
                }
                    final Map<ShardId, ShardSnapshotStatus> masterShards = snapshot.shards();
 * The OpenSearch Contributors require contributions made to  
                            wrappedSnapshot.close();
                            snapshotStatus.moveToFailed(threadPool.absoluteTimeInMillis(), failure);  
     */
                                failure = summarizeFailure(e);  
        Version version,
                            indexShard.acquireLockOnCommitData(snapshot.getSnapshotId().getUUID(), primaryTerm, commitGeneration);  
 * This service runs on data nodes and controls currently running shard snapshots on these nodes. It is responsible for  
                                // but we think the shard is done - we need to make new cluster-manager know that the shard is done
                    indexId,  
            }
        // Clear request deduplicator since we need to send all requests that were potentially not handled by the previous
            String currentMasterNodeId = event.state().nodes().getClusterManagerNodeId();
                );
                final Snapshot snapshot = entry.snapshot();
                    public UpdateIndexShardSnapshotStatusResponse read(StreamInput in) {
                    }
                        && localNodeId.equals(shardSnapshotStatus.nodeId())
            for (final Map.Entry<ShardId, IndexShardSnapshotStatus> shardEntry : startedShards.entrySet()) {
        sendSnapshotShardUpdate(
    }
                        ShardSnapshotStatus masterShard = masterShards.get(shardId);
                        @Override  
    public SnapshotShardsService(
    /**  
 * Licensed to Elasticsearch under one or more contributor  
                            notifySuccessfulSnapshotShard(snapshot, shardId, newGeneration);
import org.opensearch.index.shard.IndexEventListener;
                    if (snapshotStatus == null) {
    @Nullable
                            + " and snapshot "
     *  
        IndicesService indicesService  
     * shard content for the same sequence number on a subsequent snapshot.
            final Snapshot snapshot = entry.getKey();  
            GatedCloseable<IndexCommit> wrappedSnapshot = null;  
    private final TransportRequestDeduplicator<UpdateIndexShardSnapshotStatusRequest> remoteFailedRequestDeduplicator =
                        ActionListener.runBefore(listener, wrappedSnapshot::close),
                        reqListener.onResponse(null);
                }  
                        userMetadata,
            shardId,  
        } catch (Exception e) {
                            }
                        shardId,  
                    } catch (IOException e) {  
                            indexId,
                if (remoteStoreIndexShallowCopy && indexShard.indexSettings().isRemoteStoreEnabled()) {
                            startedShards = new HashMap<>();
                    @Override
                            snapshot.getSnapshotId(),  
                    }
        final String localNodeId = clusterService.localNode().getId();  
                        getShardStateId(indexShard, snapshotIndexCommit),
                                    snapshot.getRepository(),  
            }  
                            final String failure;
import org.opensearch.cluster.SnapshotsInProgress.ShardState;
import org.opensearch.core.action.ActionListener;  
    public void clusterChanged(ClusterChangedEvent event) {
import org.opensearch.index.snapshots.IndexShardSnapshotStatus.Stage;
     * </p>
                    shardId,
                            indexFilesToFileLengthMap = lastRemoteUploadedIndexCommit.getMetadata()  
    }  
import org.opensearch.index.shard.IndexShardState;  
 * GitHub history for details.
    private final Map<Snapshot, Map<ShardId, IndexShardSnapshotStatus>> shardSnapshots = new HashMap<>();
                            + shardId.getId()  
import org.opensearch.common.Nullable;
                    } catch (IndexShardSnapshotFailedException e) {
            if (currentMasterNodeId != null && currentMasterNodeId.equals(previousClusterManagerNodeId) == false) {
        final ShardId shardId,
    private void cancelRemoved(SnapshotsInProgress snapshotsInProgress) {
        final Map<String, Object> userMetadata,
                if (localShards != null) {
                throw e;
                // shard has just been created, or still recovering
                            commitGeneration = lastRemoteUploadedIndexCommit.getGeneration();
                            indexShard.store(),
                    long commitGeneration = 0L;
                        reqListener.onFailure(exp);
     */  
                    entry.userMetadata(),
                            indexShard.flush(new FlushRequest(shardId.getIndexName()).force(true));
/*
                        return ThreadPool.Names.SAME;  
            } catch (Exception e) {  
                                );
                            commitGeneration = snapshotIndexCommit.getGeneration();  
                    snapshotStatus,
    private void startNewSnapshots(SnapshotsInProgress snapshotsInProgress) {
                        );
                @Override
package org.opensearch.snapshots;
     * @param snapshot       snapshot
                            wrappedSnapshot = indexShard.acquireLastIndexCommitAndRefresh(true);
 * under the License.  
    private void startNewShards(SnapshotsInProgress.Entry entry, Map<ShardId, IndexShardSnapshotStatus> startedShards) {
                            snapshotIndexCommit = wrappedSnapshot.get();
    // A map of snapshots to the shardIds that we already reported to the cluster-manager as failed  
                        logger.error(  
                    }
                        }
                public void onResponse(Void aVoid) {
 * software distributed under the License is distributed on an
        try {
                        indexShard.store(),
     * @param snapshotStatus snapshot status
 * Modifications Copyright OpenSearch Contributors. See
    /**
     * The method returns {@code null} if global and local checkpoint are different for a shard since no safe unique
            new ShardSnapshotStatus(clusterService.localNode().getId(), ShardState.SUCCESS, generation)
            if (snapshot.state() == State.STARTED || snapshot.state() == State.ABORTED) {
                    long endTime = threadPool.relativeTimeInMillis();  
    @Override  
import org.opensearch.common.settings.Settings;
            final Map<ShardId, IndexShardSnapshotStatus> current = shardSnapshots.get(snapshot);
            final Repository repository = repositoriesService.repository(snapshot.getRepository());
                if (t.getMessage() != null) {
    private void snapshot(
                                    "snapshot [{}] completed to [{}] with [{}] at generation [{}]",
            new UpdateIndexShardSnapshotStatusRequest(snapshot, shardId, status),
                }  
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
import org.opensearch.transport.TransportService;  
     * Checks if any shards were processed that the new cluster-manager doesn't know about
                    snapshotStatus.abortIfNotCompleted("snapshot has been removed in cluster state, aborting");
                        snapshotStatus.abortIfNotCompleted("snapshot has been aborted");  
import org.opensearch.core.index.snapshots.IndexShardSnapshotFailedException;  
                        }  
            }
    }
                            primaryTerm = lastRemoteUploadedIndexCommit.getPrimaryTerm();
                for (final Map.Entry<ShardId, ShardSnapshotStatus> shard : entry.shards().entrySet()) {
                                logger.warn(() -> new ParameterizedMessage("[{}][{}] failed to snapshot shard", shardId, snapshot), e);
                    }  
import org.opensearch.index.IndexService;
    }
                // do not snapshot when in the process of relocation of primaries so we won't get conflicts
                    sb.append("; nested: ");  
        Iterator<Map.Entry<Snapshot, Map<ShardId, IndexShardSnapshotStatus>>> it = shardSnapshots.entrySet().iterator();  
                                primaryTerm,
                                + shardId.getId()
    protected void doStop() {}
import org.opensearch.cluster.ClusterChangedEvent;
                    logger.debug(
    }
        });  
                throw new IndexShardSnapshotFailedException(
     * A shard is assumed to have unchanged contents if its global- and local checkpoint are equal, its maximum  
        assert generation != null;  
                        repository.snapshotRemoteStoreIndexShard(
                        if (closedIndex) {
import org.opensearch.core.index.shard.ShardId;
        while (it.hasNext()) {
                    }
                        indexId,
                final Snapshot snapshot = entry.snapshot();  
     * @param snapshotIndexCommit IndexCommit for shard
            for (Map.Entry<Snapshot, Map<ShardId, IndexShardSnapshotStatus>> snapshotShards : shardSnapshots.entrySet()) {
            if (indexShard.indexSettings().isSegRepEnabledOrRemoteNode() && indexShard.isPrimaryMode() == false) {  
     * This method is executed on data node  
                            if (logger.isDebugEnabled()) {
                    try {  
        synchronized (shardSnapshots) {
                    shardSnapshots.computeIfAbsent(snapshot, s -> new HashMap<>()).putAll(startedShards);
import org.apache.lucene.index.IndexCommit;
                    entry.remoteStoreIndexShallowCopy(),
            }  
        remoteFailedRequestDeduplicator.clear();  
                    Map<String, Long> indexFilesToFileLengthMap = null;  
                                + snapshot.getSnapshotId()  
        if (maxSeqNo != seqNumInfo.localCheckpoint || maxSeqNo != indexShard.getLastSyncedGlobalCheckpoint()) {  
                req,
                    final ShardSnapshotStatus shardSnapshotStatus = shard.getValue();
import org.opensearch.core.common.io.stream.StreamInput;
    }
                }
                            + (endTime - startTime)
                            notifyFailedSnapshotShard(snapshot, shard.getKey(), shard.getValue().reason());  
                    logger.trace("[{}] [{}] updated snapshot state", snapshot, status);  
import org.opensearch.Version;
                    public void handleException(TransportException exp) {  
                        if (masterShard != null && masterShard.state().completed() == false) {  
            listener.onFailure(e);
                    repository.snapshotShard(
        this.transportService = transportService;
                            commitGeneration,  
                            final IndexShardSnapshotStatus.Copy indexShardSnapshotStatus = localShard.getValue().asCopy();
import org.opensearch.cluster.node.DiscoveryNode;
            if (indexShardState == IndexShardState.CREATED || indexShardState == IndexShardState.RECOVERING) {  
        for (SnapshotsInProgress.Entry snapshot : snapshotsInProgress.entries()) {
    ) {
    /**
                    }
                        indexShard.releaseLockOnCommitData(snapshot.getSnapshotId().getUUID(), primaryTerm, commitGeneration);  
                            }
        Settings settings,
     * Generates an identifier from the current state of a shard that can be used to detect whether a shard's contents
    @Override  
                it.remove();  
 *  
        for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
     */  
import org.opensearch.transport.TransportException;  
            }
    private void syncShardStatsOnNewMaster(ClusterChangedEvent event) {
     */  
                        version,  
                        ShardId shardId = localShard.getKey();
 */  
                @Override  
                Map<ShardId, IndexShardSnapshotStatus> snapshotShards = shardSnapshots.getOrDefault(snapshot, emptyMap());
                }  
                        startedShards.put(shardId, IndexShardSnapshotStatus.newInitializing(shardSnapshotStatus.generation()));
 * KIND, either express or implied.  See the License for the
import org.opensearch.threadpool.ThreadPool;
                        }  
            // this is only useful on the nodes that can hold data
                            final Stage stage = indexShardSnapshotStatus.getStage();
                    startNewSnapshots(currentSnapshots);
        synchronized (shardSnapshots) {  
                final ShardId shardId = shardEntry.getKey();
                    for (Map.Entry<ShardId, IndexShardSnapshotStatus> localShard : localShards.entrySet()) {  
        }
 * compatible open source license.
                            } else {
        ClusterService clusterService,  
    private void notifySuccessfulSnapshotShard(final Snapshot snapshot, final ShardId shardId, String generation) {
 *
                            }
                                + "]["  
    public void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
            } else if (entryState == State.ABORTED) {
        sendSnapshotShardUpdate(
import java.util.Iterator;
 * See package level documentation of {@link org.opensearch.snapshots} for details.
                    final IndexShardSnapshotStatus snapshotStatus = snapshotShards.get(shard.getKey());
                            logger.warn(  
                t = t.getCause();
                            if (stage == Stage.DONE) {
 * starting and stopping shard level snapshots.
                            indexFilesToFileLengthMap,
                            );
                    new ActionListener<>() {
 * You may obtain a copy of the License at  
            if (entry.isClone()) {  
                    long primaryTerm = indexShard.getOperationPrimaryTerm();
                            // cluster-manager knows about the shard and thinks it has not completed  
                            if (e instanceof AbortedSnapshotException) {
     * @return shard state id or {@code null} if none can be used
        SnapshotsInProgress snapshotsInProgress = event.state().custom(SnapshotsInProgress.TYPE);
            }
        clusterService.removeListener(this);  
            new ActionListener<Void>() {  
import java.util.stream.Collectors;
                Map<ShardId, IndexShardSnapshotStatus> shards = snapshotShards.getValue();
import org.opensearch.index.seqno.SequenceNumbers;  
        }  
        TransportService transportService,
    }
            }  
}  
                                logger.debug(  
                            closedIndex ? listener : ActionListener.runBefore(listener, wrappedSnapshot::close)  
                    if (shardSnapshotStatus.state() == ShardState.INIT  
                        throw e;
                    // Add all new shards to start processing on  
import org.opensearch.repositories.IndexId;
 *
                if (shards.containsKey(shardId)) {  
            return;
                            notifyFailedSnapshotShard(snapshot, shardId, failure);
    private final ThreadPool threadPool;
                            snapshotIndexCommit,
        }
            final Snapshot snapshot = entry.snapshot();  
                                );  
                            + "for index "  
                        "[{}] shard closing, abort snapshotting for snapshot [{}]",
        // First, remove snapshots that are no longer there
                // state update, which is being processed here
            clusterService.addListener(this);  
        }
                        }
                    sb.append("]");
                    }
import java.util.Map;
            String previousClusterManagerNodeId = event.previousState().nodes().getClusterManagerNodeId();  
                        }
                        } else {
                    "snapshot triggered on a new primary following failover and cannot proceed until promotion is complete"  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                );
        );
                                // but we think the shard failed - we need to make new cluster-manager know that the shard failed  
import java.io.IOException;
                // running shards is missed, then the snapshot is removed is a subsequent cluster
                                + "] for snapshot "
            }  
                .collect(Collectors.toMap(IndexId::getName, Function.identity()));  
        }
                    sb.append(t.getMessage());
                    shardId,
                throw new IndexShardSnapshotFailedException(shardId, "snapshot should be performed only on primary");
    private void sendSnapshotShardUpdate(final Snapshot snapshot, final ShardId shardId, final ShardSnapshotStatus status) {  
            while (t != null) {  
                                    "[{}] new cluster-manager thinks the shard [{}] is not completed but the shard is done locally, "
                SnapshotsService.UPDATE_SNAPSHOT_STATUS_ACTION_NAME,
        final Snapshot snapshot,  
            return current == null ? null : new HashMap<>(current);  
                        snapshotShards.getKey().getSnapshotId()
    }
                                logger.debug(() -> new ParameterizedMessage("[{}][{}] aborted shard snapshot", shardId, snapshot), e);
            logger.warn("Failed to update snapshot state ", e);
        }
                    sb.append("[");  
     * @param indexShard          Shard  
     * Returns status of shards that are snapshotted on the node and belong to the given snapshot
                            snapshotIndexCommit = wrappedSnapshot.get();
                // abort any running snapshots of shards for the removed entry;
            }
    private final IndicesService indicesService;
                throw new IndexShardSnapshotFailedException(shardId, "cannot snapshot while relocating");
                    }  
            final Map.Entry<Snapshot, Map<ShardId, IndexShardSnapshotStatus>> entry = it.next();
                                    shardId
                                .entrySet()
import org.opensearch.cluster.service.ClusterService;  
                    startNewShards(entry, startedShards);  
                        && snapshotShards.containsKey(shardId) == false) {
     *
        ActionListener<String> listener  
            (req, reqListener) -> transportService.sendRequest(
                    IndexCommit snapshotIndexCommit = null;
    private void notifyFailedSnapshotShard(final Snapshot snapshot, final ShardId shardId, final String failure) {  
     *
            }
        try {
            assert false : new AssertionError(e);
    private static final Logger logger = LogManager.getLogger(SnapshotShardsService.class);
                        "Time taken (in milliseconds) to complete shallow copy snapshot, "
    // package private for testing  
    /** Notify the cluster-manager node that the given shard failed to be snapshotted **/
            final IndexShard indexShard = indexService.getShardOrNull(shardId.id());
            final IndexShardState indexShardState = indexShard.state();
 */
                }
                        if (closedIndex) {
        if (t.getCause() == null) {
                        // notify cluster-manager that abort has completed by moving to FAILED
                            + " is "  
    }
                // Abort all running shards for this snapshot  
                syncShardStatsOnNewMaster(event);  
        this.repositoriesService = repositoriesService;  
        // abort any snapshots occurring on the soon-to-be closed shard
                                        + "updating status on the master",
import org.opensearch.transport.TransportRequestDeduplicator;
                    long startTime = threadPool.relativeTimeInMillis();  
                IOUtils.close(wrappedSnapshot);
import org.opensearch.index.engine.Engine;
                    @Override
    ) {
                        wrappedSnapshot.get(),  
/*  
        this.threadPool = transportService.getThreadPool();  
                    logger.warn(() -> new ParameterizedMessage("[{}] [{}] failed to update snapshot state", snapshot, status), e);
                                .stream()
 * not use this file except in compliance with the License.
                            assert newGeneration != null;
                    );
                            startTime,
                                    snapshot,
            new ShardSnapshotStatus(clusterService.localNode().getId(), ShardState.FAILED, failure, null)
                    }
import org.opensearch.cluster.SnapshotsInProgress;  
                        snapshot.getSnapshotId(),
    static String summarizeFailure(Throwable t) {
 * specific language governing permissions and limitations
                            listener.onFailure(e);  
import org.opensearch.transport.TransportResponseHandler;
            }  
            final Map<String, IndexId> indicesMap = entry.indices()
            return t.getClass().getSimpleName() + "[" + t.getMessage() + "]";  
            + "-"
        this.indicesService = indicesService;
            try {
                    logger.debug(
                Map<ShardId, IndexShardSnapshotStatus> localShards = currentSnapshotShards(snapshot.snapshot());  
                        public void onResponse(String newGeneration) {
                    public void handleResponse(UpdateIndexShardSnapshotStatusResponse response) {
                if (t != null) {
                    entry.version(),  
            final boolean closedIndex = indexService.getMetadata().getState() == IndexMetadata.State.CLOSE;
        final Map<String, String> userCommitData = snapshotIndexCommit.getUserData();  
    protected void doStart() {}
import org.opensearch.common.util.io.IOUtils;
    protected void doClose() {
import static java.util.Collections.emptyMap;  
                }
 */  
                final IndexId indexId = indicesMap.get(shardId.getIndexName());
                throw new IndexShardSnapshotFailedException(shardId, "shard didn't fully recover yet");
    }
import org.opensearch.repositories.Repository;
        RepositoriesService repositoriesService,
    @Override
                            primaryTerm,
                    );
    }
            StringBuilder sb = new StringBuilder();
     * shard state id can be used in this case because of the possibility of a primary failover leading to different  
    }  
 * @opensearch.internal
                transportService.getLocalNode(),  
                                    "[{}] new cluster-manager thinks the shard [{}] is not completed but the shard failed locally, "
import java.util.function.Function;  
                    @Override  
                    wrappedSnapshot = indexShard.acquireLastIndexCommit(true);
                        indexMetadata  
import org.opensearch.repositories.RepositoriesService;  
                                commitGeneration  
                                final IndexShardSnapshotStatus.Copy lastSnapshotStatus = snapshotStatus.asCopy();
 * the Apache License, Version 2.0 (the "License"); you may
                            + snapshot.getSnapshotId()
import org.opensearch.action.admin.indices.flush.FlushRequest;  
            )  
    @Override
        }
                        return UpdateIndexShardSnapshotStatusResponse.INSTANCE;  
        threadPool.executor(ThreadPool.Names.SNAPSHOT).execute(() -> {
 * ownership. Elasticsearch licenses this file to you under  
                                    snapshot.snapshot(),
        );
        final long maxSeqNo = seqNumInfo.maxSeqNo;
        }  
                    cancelRemoved(currentSnapshots);
                assert indexId != null;
            return null;
                    @Override
                        indexShard.acquireLockOnCommitData(snapshot.getSnapshotId().getUUID(), primaryTerm, commitGeneration);
                        if (startedShards == null) {
            + userCommitData.getOrDefault(Engine.FORCE_MERGE_UUID_KEY, "na")
        final SequenceNumbers.CommitInfo seqNumInfo = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(userCommitData.entrySet());
    private final RepositoriesService repositoriesService;
            SnapshotsInProgress currentSnapshots = event.state().custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
                }  
     * @return map of shard id to snapshot status
                                    shardId
     * have changed between two snapshots.
            snapshot,
                                    snapshot.snapshot(),  
                final IndexShardSnapshotStatus snapshotStatus = shardEntry.getValue();  
            if (snapshotsInProgress.snapshot(snapshot) == null) {
                                logger.debug(  
     * <p>
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;  
        if (snapshotsInProgress == null) {  
                                    snapshotStatus.generation()
            final State entryState = entry.state();
            if (previousSnapshots.equals(currentSnapshots) == false) {
        return userCommitData.get(Engine.HISTORY_UUID_KEY)  
                // This is a snapshot clone, it will be executed on the current master
import org.opensearch.indices.IndicesService;
            shardId,  
        new TransportRequestDeduplicator<>();
                    shards.get(shardId).abortIfNotCompleted("shard is closing, aborting");  
    }  
                            wrappedSnapshot = indexShard.acquireLastIndexCommit(false);  
                        } else {  
 * license agreements. See the NOTICE file distributed with
                    IndexMetadata indexMetadata = clusterService.state().metadata().index(indexId.getName());
import org.opensearch.cluster.metadata.IndexMetadata;
                for (IndexShardSnapshotStatus snapshotStatus : entry.getValue().values()) {
import org.apache.logging.log4j.message.ParameterizedMessage;  
                        }  
import org.apache.logging.log4j.Logger;
                            } else if (stage == Stage.FAILURE) {
                    }
            if (indexShard.routingEntry().relocating()) {  
                        }
                }
                                notifySuccessfulSnapshotShard(snapshot.snapshot(), shardId, localShard.getValue().generation());  
                if (startedShards != null && startedShards.isEmpty() == false) {
                            "Shallow Copy Snapshot Failed for Shard ["
        }
            }  
        }
import org.apache.logging.log4j.LogManager;
                        // due to CS batching we might have missed the INIT state and straight went into ABORTED  
            + "-"  
    private final TransportService transportService;  
                                    lastSnapshotStatus,

        ReplicationCheckpoint indexShardReplicationCheckpoint = indexShard.getLatestReplicationCheckpoint();
        public void setBytesBehind(long bytesBehind) {
            this.bytesBehind = bytesBehind;
        return createdTimeStamp > 0L ? createdTimeStamp : DateUtils.toLong(Instant.now());
            ReplicationCheckpoint indexReplicationCheckPoint = indexShard.getLatestReplicationCheckpoint();
                pruneCheckpointsUpToLastSync(target.indexShard());
     * @param indexShard The index shard to prune checkpoints for
    private class ReplicationRunner<R extends AbstractSegmentReplicationTarget> extends AbstractRunnable {
import java.time.Duration;
    List<MergedSegmentReplicationTarget> getMergedSegmentReplicationTarget(ShardId shardId) {
    }
        if (primaryCheckPoint == null || latestReceivedCheckPoint.isAheadOf(primaryCheckPoint)) {
        ) {
    void cancel(ShardId shardId, String reason) {
    ReplicationCollection.ReplicationRef<SegmentReplicationTarget> get(long id, ShardId shardId) {
            }
     * <pre>
     * @param isRetry - is it a retry after failure
        final long replicationId;
    private final Map<ShardId, SegmentReplicationState> completedReplications = ConcurrentCollections.newConcurrentMap();
        long bytesBehind = highestEntry.getValue().getBytesBehind();
        try (
            target = replicationRef.get();
        target.startReplication(new ActionListener<>() {
    SegmentReplicationState getCompleted(ShardId shardId) {
     * This helps maintain only relevant checkpoint information and clean up old data.
            if (store.tryIncRef()) {
        return completedReplications.get(shardId);
        } catch (ReplicationFailedException e) {
 * This class is responsible for managing segment replication events on replicas.
                Map.Entry<Long, ReplicationCheckpointStats> lastEntry = existingCheckpointStats.lastEntry();
    }
import org.opensearch.OpenSearchCorruptionException;
    }
            }
    }
            this.completedReplications = completedReplications;
            : 0;
    }
     */
    private boolean isStoreCorrupt(AbstractSegmentReplicationTarget target) {
import org.opensearch.index.store.Store;
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        // we can assume the store is not corrupt and that the replication
public class SegmentReplicator {
        }, this::updateReplicationCheckpointStats);
    }
        );
    ReplicationCheckpoint getPrimaryCheckpoint(ShardId shardId) {
        }
        if (latestCheckpoint != null) {
                    onGoingReplications.fail(replicationId, new ReplicationFailedException("Store corruption during replication", e), true);
 *
    // pkg-private for integration tests
    }
     * Updates the latest checkpoint of the primary for the replica shard and then
import java.util.List;
        logger.trace(() -> new ParameterizedMessage("Added new replication to collection {}", target.description()));
        final ReplicationCollection<R> onGoingReplications;
    private final ConcurrentMap<ShardId, ReplicationCheckpoint> primaryCheckpoint = ConcurrentCollections.newConcurrentMap();
        final SegmentReplicationSource source,
                    return false;
            shard.getLatestReplicationCheckpoint(),
    private static class ReplicationCheckpointStats {
        }
        }
import org.opensearch.index.store.StoreFileMetadata;
    private static long resolveCheckpointTimestamp(final ReplicationCheckpoint checkpoint) {
        public ReplicationCheckpointStats(long bytesBehind, long timestamp) {
            target.fail(e, false);
            }
    }
    }
                    store.decRef();
        ReplicationCollection<? extends AbstractSegmentReplicationTarget> onGoingReplications,
                logger.debug("Replication failed {}", target.description());
     * {@link ReplicationCheckpoint#getCreatedTimeStamp()} is {@code 0} when the checkpoint was serialized by a node older
        public void doRun() {
                }
        Map<ShardId, SegmentReplicationState> completedReplications
     * Returns the timestamp, in epoch nanoseconds, from which replication lag is measured for the given checkpoint.
     * @param shardId The shardId to get statistics for
                    return store.isMarkedCorrupted();
                if (target.state().getIndex().recoveredFileCount() != 0
            replicationId = onGoingMergedSegmentReplications.start(target, timeout);
        }
        final long createdTimeStamp = checkpoint.getCreatedTimeStamp();
        final MergedSegmentReplicationTarget target = new MergedSegmentReplicationTarget(indexShard, checkpoint, source, listener);
        this.onGoingMergedSegmentReplications = new ReplicationCollection<>(logger, threadPool);
     * <p>
            shard,
        Map.Entry<Long, ReplicationCheckpointStats> lowestEntry = existingCheckpointStats.firstEntry();
import org.apache.logging.log4j.LogManager;
import java.util.Map;
    /**
                if (existingCheckpointStats != null) {
        } catch (ReplicationFailedException e) {
     *     [replica][0] : {
    private final ReplicationCollection<MergedSegmentReplicationTarget> onGoingMergedSegmentReplications;
     * This method maintains statistics about how far behind replica shards are from the primary.
        if (target.refCount() > 0) {
    public void initializeStats(ShardId shardId) {
                    indexShard.shardId()
import java.time.Instant;
     */
                        segmentInfosVersion,
        }
                    logger.error(() -> new ParameterizedMessage("Failed segment replication for {}", shard.shardId()), e);
/**
     * and recalculates the bytes behind value for the last replicationCheckpointStats entry.
            this.replicationId = replicationId;
        }
     * </pre>
     * Retrieves segment replication statistics for a specific shard.
        threadPool.generic().execute(new ReplicationRunner(replicationId, onGoingMergedSegmentReplications, null));
 * The OpenSearch Contributors require contributions made to
 * It uses a {@link ReplicationCollection} to track ongoing replication events and
            public void onResponse(Void o) {
        }
                existingCheckpointStats.keySet().removeIf(key -> key <= segmentInfoVersion);
    }
                logger.debug(() -> new ParameterizedMessage("Finished replicating {} marking as done.", target.description()));
        return onGoingMergedSegmentReplications.getSafe(id, shardId);
        final ReplicationCheckpoint checkpoint,
        }
            new SegmentReplicationTargetService.SegmentReplicationListener() {
 *
    }
    ReplicationCollection.ReplicationRef<MergedSegmentReplicationTarget> getMergeReplicationRef(long id) {
            long replicationId,
        long replicationLag = bytesBehind > 0L
import org.apache.lucene.index.CorruptIndexException;
            ? Math.max(0L, Duration.ofNanos(DateUtils.toLong(Instant.now()) - lowestEntry.getValue().getTimestamp()).toMillis())
                replicationId
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        return false;
        ) {
            @Nullable Map<ShardId, SegmentReplicationState> completedReplications
        onGoingMergedSegmentReplications.cancelForShard(shardId, reason);
        this.onGoingReplications = new ReplicationCollection<>(logger, threadPool);
    private final SetOnce<SegmentReplicationSourceFactory> sourceFactory;
        return onGoingMergedSegmentReplications.getOngoingReplicationTargetList(shardId);
     * @param listener - {@link ReplicationListener}
        Map.Entry<Long, ReplicationCheckpointStats> highestEntry = existingCheckpointStats.lastEntry();
    /**
                    }
    }
            // threadpool.
        Store.RecoveryDiff diff = Store.segmentReplicationDiff(latestCheckPoint.getMetadataMap(), replicationCheckpoint.getMetadataMap());
        replicationCheckpointStats.computeIfAbsent(shardId, k -> new ConcurrentSkipListMap<>());
import org.opensearch.common.SetOnce;
        this.sourceFactory = new SetOnce<>();
        final IndexShard indexShard,
            }
            return bytesBehind;
        this.sourceFactory.set(sourceFactory);
                onGoingReplications.markAsDone(replicationId);
     */
 * manages the state of each replication event.
    void startReplication(final SegmentReplicationTarget target, TimeValue timeout) {
     * Start a round of replication merged segment.
                indexShard.shardId()
                onGoingReplications.fail(replicationId, new ReplicationFailedException("Segment Replication failed", e), false);
                }
        final SegmentReplicationTarget target = new SegmentReplicationTarget(indexShard, checkpoint, source, isRetry, listener);
     * node is used, so lag is measured from when the checkpoint was received rather than from the Unix epoch.
        final Map<ShardId, SegmentReplicationState> completedReplications;
        // store already closed.
            final Store store = target.store();
        final AbstractSegmentReplicationTarget target;
        public long getTimestamp() {
            return ReplicationStats.empty();
 * @opensearch.internal
        final SegmentReplicationSource source,
            @NonNull ReplicationCollection<R> onGoingReplications,
     */
     * and it maintains the bytes behind and timestamp for each segmentInfosVersion of latestCheckPoint.
     *                       8 : {bytesBehind=100, timestamp=1700330000000}
     * @param indexShard The index shard where its updated
        return onGoingReplications.getOngoingReplicationTarget(shardId);
                        shard.failShard("unrecoverable replication failure", e);
     * @param checkpoint - {@link ReplicationCheckpoint} checkpoint to sync to
     * @return ReplicationStats containing bytes behind and replication lag information
    /**
                }
            this.primaryCheckpoint.put(indexShard.shardId(), latestReceivedCheckPoint);
            this.timestamp = timestamp;
        primaryCheckpoint.remove(shardId);
        }
import org.opensearch.indices.replication.common.ReplicationListener;
        if (sourceFactory.get() == null) return;
                    );
        ReplicationCheckpoint primaryCheckPoint = this.primaryCheckpoint.get(indexShard.shardId());
import org.opensearch.core.action.ActionListener;
            calculateReplicationCheckpointStats(latestReceivedCheckPoint, indexShard);
            target.fail(e, false);
     * calculates checkpoint statistics for the replica shard with the latest checkpoint information.
            this.onGoingReplications = onGoingReplications;
    }
import java.util.concurrent.ConcurrentNavigableMap;
        return new ReplicationStats(bytesBehind, bytesBehind, replicationLag);
import org.apache.logging.log4j.Logger;
            long segmentInfoVersion = indexReplicationCheckPoint.getSegmentInfosVersion();
    }
                }
        @Override
import org.opensearch.common.Nullable;
    private final ThreadPool threadPool;
    ReplicationCollection.ReplicationRef<SegmentReplicationTarget> get(long id) {
/*
        startReplication(
            if (bytesBehind > 0) {
    }
    }
            return ReplicationStats.empty();
            if (existingCheckpointStats != null && !existingCheckpointStats.isEmpty()) {
     *                       7 : {bytesBehind=0, timestamp=1700220000000}
        final ReplicationCheckpoint checkpoint,
    /**
        private long bytesBehind;
            @Override
                }
import org.opensearch.index.shard.IndexShard;
            false,
            // replication already running for shard.
 * compatible open source license.
     * @param listener - {@link ReplicationListener}
import org.opensearch.common.util.concurrent.AbstractRunnable;
            }
        public ReplicationRunner(
                try {
    }
                } finally {
    ) {
     * Start a round of replication and sync to at least the given checkpoint.
     * }
        }
        @Override
        return onGoingReplications.size();
    ) {
            }
     * than {@link org.opensearch.Version#V_3_0_0}, which does not write the field. In that case the current time on this
import org.opensearch.indices.replication.common.ReplicationFailedException;
    void startMergedSegmentReplication(final MergedSegmentReplicationTarget target, TimeValue timeout) {
    int size() {
                    return;
        }
        logger.trace(() -> new ParameterizedMessage("Added new merged segment replication to collection {}", target.description()));
     */
        replicationCheckpointStats.remove(shardId);
                    existingCheckpointStats.computeIfAbsent(
            sourceFactory.get().get(shard),
        final long replicationId;
    /**
     *
    protected void pruneCheckpointsUpToLastSync(final IndexShard indexShard) {
     * The Last entry gives the Bytes behind, and the difference in the first and last entry provides the lag.
                public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
import java.util.concurrent.ConcurrentSkipListMap;
    /**
                }
    public void updateReplicationCheckpointStats(final ReplicationCheckpoint latestReceivedCheckPoint, final IndexShard indexShard) {
                public void onReplicationDone(SegmentReplicationState state) {
     * @param shard - {@link IndexShard} replica shard
    }
     * @return {@link SegmentReplicationTarget} target event orchestrating the event.
        threadPool.generic().execute(new ReplicationRunner(replicationId, onGoingReplications, completedReplications));
        }
    }
        ConcurrentCollections.newConcurrentMap();
     * Runnable implementation to trigger a replication event.
     * @param latestReceivedCheckPoint The most recent checkpoint from the primary
    }
    private final ReplicationCollection<SegmentReplicationTarget> onGoingReplications;
            final ConcurrentNavigableMap<Long, ReplicationCheckpointStats> existingCheckpointStats = replicationCheckpointStats.get(
        completedReplications.remove(shardId);
        // Currently, we have not counted the completion information of the pre-copy merged segment, so the completedReplications parameter
    ) {
        // ensure target is not already closed. In that case
     *                       9 : {bytesBehind=150, timestamp=1700440000000}
 */
        }
        final boolean isRetry,
            ReplicationCollection.ReplicationRef<? extends AbstractSegmentReplicationTarget> replicationRef = onGoingReplications.get(
            public void onFailure(Exception e) {
            );
                    if (sendShardFailure) {
        startMergedSegmentReplication(target, indexShard.getRecoverySettings().activityTimeout());
        // event completed successfully.
        try {
        return primaryCheckpoint.get(shardId);
            @Override
    SegmentReplicationTarget get(ShardId shardId) {
     *                    }
        return onGoingReplications.get(id);
    }
     * {
        if (existingCheckpointStats == null) {
import org.opensearch.common.time.DateUtils;
        public long getBytesBehind() {
        private final long timestamp;
            onGoingReplications.fail(replicationId, new ReplicationFailedException("Unexpected Error during replication", e), false);
            // This check is for handling edge cases where the reference is removed before the ReplicationRunner is started by the
            // replication already running for shard.
        return onGoingReplications.getSafe(id, shardId);
        return target;
import org.opensearch.core.index.shard.ShardId;
        }
            long segmentInfosVersion = latestReceivedCheckPoint.getSegmentInfosVersion();
    private void calculateReplicationCheckpointStats(final ReplicationCheckpoint latestReceivedCheckPoint, final IndexShard indexShard) {
    }
        final SegmentReplicationTargetService.SegmentReplicationListener listener
            long bytesBehind = calculateBytesBehind(latestReceivedCheckPoint, indexShardReplicationCheckpoint);
import org.apache.logging.log4j.message.ParameterizedMessage;
                    && target.state().getIndex().recoveredBytes() != 0
                @Override
            return;
    private static final Logger logger = LogManager.getLogger(SegmentReplicator.class);
import org.opensearch.index.ReplicationStats;
    }
    public ReplicationStats getSegmentReplicationStats(final ShardId shardId) {
     * @param source - {@link SegmentReplicationSource} segment replication source
            if (replicationRef == null) {
    SegmentReplicationTarget startReplication(
import org.opensearch.threadpool.ThreadPool;
        final long replicationId;
        }
        this.threadPool = threadPool;
        onGoingReplications.cancelForShard(shardId, reason);
                    logger.trace("Completed replication for {}", shard.shardId());
                    lastEntry.getValue().setBytesBehind(calculateBytesBehind(latestCheckpoint, indexReplicationCheckPoint));
    protected final ConcurrentMap<ShardId, ConcurrentNavigableMap<Long, ReplicationCheckpointStats>> replicationCheckpointStats =
import java.util.concurrent.ConcurrentMap;
            )
 * SPDX-License-Identifier: Apache-2.0
        ReplicationCheckpoint latestCheckpoint = this.primaryCheckpoint.get(indexShard.shardId());
     */
    }
     */
                }
        try {
            this.bytesBehind = bytesBehind;
                ConcurrentNavigableMap<Long, ReplicationCheckpointStats> existingCheckpointStats = replicationCheckpointStats.get(
     */
            }
    /**
                if (isStoreCorrupt(target) || e instanceof CorruptIndexException || e instanceof OpenSearchCorruptionException) {
     * @param checkpoint - {@link ReplicationCheckpoint} merged segment to replicate
package org.opensearch.indices.replication;
 * this file be licensed under the Apache-2.0 license or a
import reactor.util.annotation.NonNull;
    private void start(
        if (lowestEntry == null || highestEntry == null) {
                        k -> new ReplicationCheckpointStats(bytesBehind, resolveCheckpointTimestamp(latestReceivedCheckPoint))
     * @param indexShard - {@link IndexShard} replica shard
                if (lastEntry != null) {
        }
                );
 */
    }
        if (indexShardReplicationCheckpoint != null) {
                    completedReplications.put(target.shardId(), target.state());
    void setSourceFactory(SegmentReplicationSourceFactory sourceFactory) {
        final IndexShard indexShard,
     * @param indexShard - {@link IndexShard} replica shard
}
    ReplicationCollection.ReplicationRef<MergedSegmentReplicationTarget> getMergeReplicationRef(long id, ShardId shardId) {
                    logger.warn("Unable to determine if store is corrupt", ex);
                @Override
            replicationId = onGoingReplications.startSafe(target, timeout);
        // is null.
    public void startMergedSegmentReplication(
     * Example:
            return timestamp;
     * Starts a replication event for the given shard.
    public SegmentReplicator(ThreadPool threadPool) {
     * Removes checkpoint statistics for all checkpoints up to and including the last successful sync
                    && null != completedReplications) {
     *
import org.opensearch.indices.replication.common.ReplicationCollection;
    }
        final ConcurrentNavigableMap<Long, ReplicationCheckpointStats> existingCheckpointStats = replicationCheckpointStats.get(shardId);
        final long replicationId,
    }
        return onGoingMergedSegmentReplications.get(id);
        public void onFailure(Exception e) {
import org.opensearch.common.unit.TimeValue;
            return;
    private long calculateBytesBehind(final ReplicationCheckpoint latestCheckPoint, final ReplicationCheckpoint replicationCheckpoint) {
        final SegmentReplicationTargetService.SegmentReplicationListener listener
     * It calculates the bytes behind by comparing the latest-received and current checkpoint in the indexShard,
     * Its computed based on the last and first entry in the replicationCheckpointStats map.
        startReplication(target, indexShard.getRecoverySettings().activityTimeout());
import java.io.IOException;
    }
    /**
                return;
    public void startReplication(IndexShard shard) {
        return diff.missing.stream().mapToLong(StoreFileMetadata::length).sum();
            start(replicationId, onGoingReplications, completedReplications);
                } catch (IOException ex) {

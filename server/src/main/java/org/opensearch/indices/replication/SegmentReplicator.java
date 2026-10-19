        replicationCheckpointStats.computeIfAbsent(shardId, k -> new ConcurrentSkipListMap<>());
import java.util.concurrent.ConcurrentMap;
                replicationId
        }
     * Example:
            @Nullable Map<ShardId, SegmentReplicationState> completedReplications  
                }
    }
 * It uses a {@link ReplicationCollection} to track ongoing replication events and
                }
        return onGoingMergedSegmentReplications.get(id);
                return;
                onGoingReplications.fail(replicationId, new ReplicationFailedException("Segment Replication failed", e), false);
            target.fail(e, false);  
                    && null != completedReplications) {
        threadPool.generic().execute(new ReplicationRunner(replicationId, onGoingReplications, completedReplications));  
        ConcurrentCollections.newConcurrentMap();
     */
            public void onFailure(Exception e) {
        final SegmentReplicationSource source,
    /**
    private final ReplicationCollection<SegmentReplicationTarget> onGoingReplications;
            }
     *                       9 : {bytesBehind=150, timestamp=1700440000000}
    /**
    private final SetOnce<SegmentReplicationSourceFactory> sourceFactory;  
        if (sourceFactory.get() == null) return;
    private final Map<ShardId, SegmentReplicationState> completedReplications = ConcurrentCollections.newConcurrentMap();  
            this.onGoingReplications = onGoingReplications;  
            @NonNull ReplicationCollection<R> onGoingReplications,
        ReplicationCheckpoint latestCheckpoint = this.primaryCheckpoint.get(indexShard.shardId());  
        return onGoingMergedSegmentReplications.getSafe(id, shardId);
        // event completed successfully.  
                public void onReplicationDone(SegmentReplicationState state) {
     * @param indexShard - {@link IndexShard} replica shard
 * The OpenSearch Contributors require contributions made to  
    private void start(  
            this.bytesBehind = bytesBehind;
     * Runnable implementation to trigger a replication event.
    }
     * <p>  
            replicationId = onGoingReplications.startSafe(target, timeout);
            }  
import java.util.List;  
        return completedReplications.get(shardId);
        final long replicationId;  
        final long replicationId;
        if (latestCheckpoint != null) {
    SegmentReplicationTarget get(ShardId shardId) {  
        onGoingReplications.cancelForShard(shardId, reason);
        public void doRun() {
     * This method maintains statistics about how far behind replica shards are from the primary.
    public void startMergedSegmentReplication(
    protected void pruneCheckpointsUpToLastSync(final IndexShard indexShard) {
    ReplicationCollection.ReplicationRef<SegmentReplicationTarget> get(long id) {  
                    return store.isMarkedCorrupted();
            this.replicationId = replicationId;
        startReplication(  
        public long getTimestamp() {
    private class ReplicationRunner<R extends AbstractSegmentReplicationTarget> extends AbstractRunnable {  
    }
     * }  
                    logger.error(() -> new ParameterizedMessage("Failed segment replication for {}", shard.shardId()), e);
     * node is used, so lag is measured from when the checkpoint was received rather than from the Unix epoch.  
    /**  
        }
     * @param shardId The shardId to get statistics for
     *
    }  
        final SegmentReplicationTargetService.SegmentReplicationListener listener
    }
    ReplicationCollection.ReplicationRef<MergedSegmentReplicationTarget> getMergeReplicationRef(long id, ShardId shardId) {
        startReplication(target, indexShard.getRecoverySettings().activityTimeout());
        );
    void startReplication(final SegmentReplicationTarget target, TimeValue timeout) {
    ReplicationCheckpoint getPrimaryCheckpoint(ShardId shardId) {
        ) {
     *                       8 : {bytesBehind=100, timestamp=1700330000000}  
            calculateReplicationCheckpointStats(latestReceivedCheckPoint, indexShard);  
     * calculates checkpoint statistics for the replica shard with the latest checkpoint information.  
                ConcurrentNavigableMap<Long, ReplicationCheckpointStats> existingCheckpointStats = replicationCheckpointStats.get(  
     * @param isRetry - is it a retry after failure
    public void initializeStats(ShardId shardId) {
    ) {
     * {  
        if (indexShardReplicationCheckpoint != null) {
        private final long timestamp;
            ? Math.max(0L, Duration.ofNanos(DateUtils.toLong(Instant.now()) - lowestEntry.getValue().getTimestamp()).toMillis())
    }
                }
        }
     * @param shard - {@link IndexShard} replica shard
            ReplicationCheckpoint indexReplicationCheckPoint = indexShard.getLatestReplicationCheckpoint();
    int size() {  
     * <pre>
                    store.decRef();
    }
                    }
        primaryCheckpoint.remove(shardId);
            if (replicationRef == null) {
                    return false;
        if (lowestEntry == null || highestEntry == null) {
        onGoingMergedSegmentReplications.cancelForShard(shardId, reason);  
                        k -> new ReplicationCheckpointStats(bytesBehind, resolveCheckpointTimestamp(latestReceivedCheckPoint))  
            replicationId = onGoingMergedSegmentReplications.start(target, timeout);  
import java.time.Instant;
 * @opensearch.internal
        if (existingCheckpointStats == null) {
                        segmentInfosVersion,
    /**
     */  
        Map.Entry<Long, ReplicationCheckpointStats> lowestEntry = existingCheckpointStats.firstEntry();
                    logger.warn("Unable to determine if store is corrupt", ex);
                } catch (IOException ex) {  
        startMergedSegmentReplication(target, indexShard.getRecoverySettings().activityTimeout());  
            this.bytesBehind = bytesBehind;
    ) {
        final ReplicationCollection<R> onGoingReplications;  
            @Override
            final Store store = target.store();
        final long replicationId;
import java.util.concurrent.ConcurrentNavigableMap;  
            );  
     * @param indexShard The index shard where its updated  
        if (primaryCheckPoint == null || latestReceivedCheckPoint.isAheadOf(primaryCheckPoint)) {
    /**
            target = replicationRef.get();
 * compatible open source license.
            }  
        long bytesBehind = highestEntry.getValue().getBytesBehind();  
        return false;  
import org.opensearch.common.time.DateUtils;
            if (existingCheckpointStats != null && !existingCheckpointStats.isEmpty()) {
     * This helps maintain only relevant checkpoint information and clean up old data.
        private long bytesBehind;  
     */
        return onGoingReplications.size();
        public void onFailure(Exception e) {
    ) {
        threadPool.generic().execute(new ReplicationRunner(replicationId, onGoingMergedSegmentReplications, null));  
            shard.getLatestReplicationCheckpoint(),
            if (bytesBehind > 0) {
import org.opensearch.OpenSearchCorruptionException;
            long segmentInfoVersion = indexReplicationCheckPoint.getSegmentInfosVersion();  
        target.startReplication(new ActionListener<>() {  
    }
            long bytesBehind = calculateBytesBehind(latestReceivedCheckPoint, indexShardReplicationCheckpoint);
     * Start a round of replication and sync to at least the given checkpoint.  
        }
        }  
        }
                logger.debug("Replication failed {}", target.description());  
                if (target.state().getIndex().recoveredFileCount() != 0  
        final Map<ShardId, SegmentReplicationState> completedReplications;
     * than {@link org.opensearch.Version#V_3_0_0}, which does not write the field. In that case the current time on this
import org.opensearch.index.ReplicationStats;
     * @param indexShard - {@link IndexShard} replica shard
    }  
                if (existingCheckpointStats != null) {  
        } catch (ReplicationFailedException e) {  
        if (target.refCount() > 0) {
        }
            this.completedReplications = completedReplications;
    }
        logger.trace(() -> new ParameterizedMessage("Added new replication to collection {}", target.description()));
     * and recalculates the bytes behind value for the last replicationCheckpointStats entry.  
     *     [replica][0] : {
        }
                    && target.state().getIndex().recoveredBytes() != 0
    private static long resolveCheckpointTimestamp(final ReplicationCheckpoint checkpoint) {
import org.opensearch.indices.replication.common.ReplicationListener;  
            ReplicationCollection.ReplicationRef<? extends AbstractSegmentReplicationTarget> replicationRef = onGoingReplications.get(
                }
     */
        replicationCheckpointStats.remove(shardId);
import org.opensearch.common.SetOnce;
        try {
            target.fail(e, false);
import org.opensearch.index.store.StoreFileMetadata;
            sourceFactory.get().get(shard),  
        @Override  
import org.apache.logging.log4j.Logger;
     */
     * @param listener - {@link ReplicationListener}  
            return;  
                }  
        final SegmentReplicationTargetService.SegmentReplicationListener listener  
            // This check is for handling edge cases where the reference is removed before the ReplicationRunner is started by the
            )  
    private final ReplicationCollection<MergedSegmentReplicationTarget> onGoingMergedSegmentReplications;
     *
import org.opensearch.common.unit.TimeValue;  
        Map.Entry<Long, ReplicationCheckpointStats> highestEntry = existingCheckpointStats.lastEntry();  
    ReplicationCollection.ReplicationRef<MergedSegmentReplicationTarget> getMergeReplicationRef(long id) {  
     * Retrieves segment replication statistics for a specific shard.
        this.onGoingReplications = new ReplicationCollection<>(logger, threadPool);  
            }  
    private final ThreadPool threadPool;
                public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {  
     * </pre>
import org.opensearch.index.shard.IndexShard;  
    }
        }, this::updateReplicationCheckpointStats);
            }  
import org.opensearch.indices.replication.common.ReplicationFailedException;
    public SegmentReplicator(ThreadPool threadPool) {
            return ReplicationStats.empty();  
                if (isStoreCorrupt(target) || e instanceof CorruptIndexException || e instanceof OpenSearchCorruptionException) {
 */  
                    return;  
        this.threadPool = threadPool;
        public ReplicationCheckpointStats(long bytesBehind, long timestamp) {  
    }
    void cancel(ShardId shardId, String reason) {
                    indexShard.shardId()
     */
                    logger.trace("Completed replication for {}", shard.shardId());
    private static class ReplicationCheckpointStats {
        this.sourceFactory = new SetOnce<>();  
    /**  
                    lastEntry.getValue().setBytesBehind(calculateBytesBehind(latestCheckpoint, indexReplicationCheckPoint));  
     * and it maintains the bytes behind and timestamp for each segmentInfosVersion of latestCheckPoint.  
        return onGoingReplications.getSafe(id, shardId);  
            return;
            long replicationId,
import org.apache.logging.log4j.message.ParameterizedMessage;  
import java.io.IOException;  
     *                       7 : {bytesBehind=0, timestamp=1700220000000}
        try {
import org.apache.lucene.index.CorruptIndexException;
        return primaryCheckpoint.get(shardId);  
        long replicationLag = bytesBehind > 0L
        final ReplicationCheckpoint checkpoint,
                } finally {  
    public void updateReplicationCheckpointStats(final ReplicationCheckpoint latestReceivedCheckPoint, final IndexShard indexShard) {
    }  
    }
                        shard.failShard("unrecoverable replication failure", e);  
    }
    private void calculateReplicationCheckpointStats(final ReplicationCheckpoint latestReceivedCheckPoint, final IndexShard indexShard) {  
        }  
            final ConcurrentNavigableMap<Long, ReplicationCheckpointStats> existingCheckpointStats = replicationCheckpointStats.get(
    List<MergedSegmentReplicationTarget> getMergedSegmentReplicationTarget(ShardId shardId) {
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
    protected final ConcurrentMap<ShardId, ConcurrentNavigableMap<Long, ReplicationCheckpointStats>> replicationCheckpointStats =
    }
    }  
     * Updates the latest checkpoint of the primary for the replica shard and then
        return onGoingReplications.get(id);
                    );
                onGoingReplications.markAsDone(replicationId);
            // replication already running for shard.
                try {
        this.sourceFactory.set(sourceFactory);
import org.apache.logging.log4j.LogManager;
        return diff.missing.stream().mapToLong(StoreFileMetadata::length).sum();
     * Its computed based on the last and first entry in the replicationCheckpointStats map.
    }
     * Returns the timestamp, in epoch nanoseconds, from which replication lag is measured for the given checkpoint.
    }
                }
            this.timestamp = timestamp;
            public void onResponse(Void o) {
        } catch (ReplicationFailedException e) {
     */
        try (  
 * this file be licensed under the Apache-2.0 license or a
     *                    }
                existingCheckpointStats.keySet().removeIf(key -> key <= segmentInfoVersion);  
     * @return {@link SegmentReplicationTarget} target event orchestrating the event.  
            this.primaryCheckpoint.put(indexShard.shardId(), latestReceivedCheckPoint);
     * @param latestReceivedCheckPoint The most recent checkpoint from the primary
            if (store.tryIncRef()) {  
        completedReplications.remove(shardId);  
            shard,
        ) {
        ReplicationCheckpoint indexShardReplicationCheckpoint = indexShard.getLatestReplicationCheckpoint();
        }
                if (lastEntry != null) {
        final IndexShard indexShard,  
import org.opensearch.index.store.Store;
    void startMergedSegmentReplication(final MergedSegmentReplicationTarget target, TimeValue timeout) {  
        return target;
            false,
    private boolean isStoreCorrupt(AbstractSegmentReplicationTarget target) {  
    }  
            new SegmentReplicationTargetService.SegmentReplicationListener() {
            onGoingReplications.fail(replicationId, new ReplicationFailedException("Unexpected Error during replication", e), false);  
     * It calculates the bytes behind by comparing the latest-received and current checkpoint in the indexShard,
            // replication already running for shard.
        final ReplicationCheckpoint checkpoint,
        }
        public void setBytesBehind(long bytesBehind) {  
 *
                );
import org.opensearch.common.util.concurrent.ConcurrentCollections;
import java.util.concurrent.ConcurrentSkipListMap;
    public void startReplication(IndexShard shard) {
        return onGoingReplications.getOngoingReplicationTarget(shardId);
        final boolean isRetry,  
            start(replicationId, onGoingReplications, completedReplications);
                    onGoingReplications.fail(replicationId, new ReplicationFailedException("Store corruption during replication", e), true);
    /**  
import java.util.Map;
        return onGoingMergedSegmentReplications.getOngoingReplicationTargetList(shardId);
     * Removes checkpoint statistics for all checkpoints up to and including the last successful sync
import org.opensearch.common.util.concurrent.AbstractRunnable;
     * The Last entry gives the Bytes behind, and the difference in the first and last entry provides the lag.  
        }  
    }
        final ConcurrentNavigableMap<Long, ReplicationCheckpointStats> existingCheckpointStats = replicationCheckpointStats.get(shardId);  
import reactor.util.annotation.NonNull;  
        Store.RecoveryDiff diff = Store.segmentReplicationDiff(latestCheckPoint.getMetadataMap(), replicationCheckpoint.getMetadataMap());
        final SegmentReplicationTarget target = new SegmentReplicationTarget(indexShard, checkpoint, source, isRetry, listener);  
        ReplicationCollection<? extends AbstractSegmentReplicationTarget> onGoingReplications,
            return timestamp;
 *  
import org.opensearch.core.index.shard.ShardId;
     * @param checkpoint - {@link ReplicationCheckpoint} checkpoint to sync to
    }
            : 0;  
        return new ReplicationStats(bytesBehind, bytesBehind, replicationLag);
        final IndexShard indexShard,  
            }  
        // store already closed.
import org.opensearch.core.action.ActionListener;  
        ReplicationCheckpoint primaryCheckPoint = this.primaryCheckpoint.get(indexShard.shardId());  
/**
    }
                    existingCheckpointStats.computeIfAbsent(
        final long createdTimeStamp = checkpoint.getCreatedTimeStamp();  
            return ReplicationStats.empty();
 * SPDX-License-Identifier: Apache-2.0
        return createdTimeStamp > 0L ? createdTimeStamp : DateUtils.toLong(Instant.now());
    private final ConcurrentMap<ShardId, ReplicationCheckpoint> primaryCheckpoint = ConcurrentCollections.newConcurrentMap();  
        final AbstractSegmentReplicationTarget target;
                    completedReplications.put(target.shardId(), target.state());  
import org.opensearch.common.Nullable;  
            long segmentInfosVersion = latestReceivedCheckPoint.getSegmentInfosVersion();  
        @Override
        }
    private long calculateBytesBehind(final ReplicationCheckpoint latestCheckPoint, final ReplicationCheckpoint replicationCheckpoint) {
import org.opensearch.indices.replication.common.ReplicationCollection;
package org.opensearch.indices.replication;
            // threadpool.  
    void setSourceFactory(SegmentReplicationSourceFactory sourceFactory) {
        // Currently, we have not counted the completion information of the pre-copy merged segment, so the completedReplications parameter
 */
    ReplicationCollection.ReplicationRef<SegmentReplicationTarget> get(long id, ShardId shardId) {
     * Start a round of replication merged segment.  
    }
            @Override
        }
                @Override
        }  
        public long getBytesBehind() {
        // ensure target is not already closed. In that case
    public ReplicationStats getSegmentReplicationStats(final ShardId shardId) {
        final long replicationId,
     * {@link ReplicationCheckpoint#getCreatedTimeStamp()} is {@code 0} when the checkpoint was serialized by a node older
                    if (sendShardFailure) {
import org.opensearch.threadpool.ThreadPool;
     * @param checkpoint - {@link ReplicationCheckpoint} merged segment to replicate
                }
        Map<ShardId, SegmentReplicationState> completedReplications  
                indexShard.shardId()
    private static final Logger logger = LogManager.getLogger(SegmentReplicator.class);
/*  
}
    }
            }
        public ReplicationRunner(  
     */
     * @param indexShard The index shard to prune checkpoints for  
    SegmentReplicationTarget startReplication(
        final SegmentReplicationSource source,
        // we can assume the store is not corrupt and that the replication
        this.onGoingMergedSegmentReplications = new ReplicationCollection<>(logger, threadPool);
 * This class is responsible for managing segment replication events on replicas.  
    /**
    }
 * manages the state of each replication event.
import java.time.Duration;
     * @param listener - {@link ReplicationListener}
                pruneCheckpointsUpToLastSync(target.indexShard());
    // pkg-private for integration tests
    SegmentReplicationState getCompleted(ShardId shardId) {
        logger.trace(() -> new ParameterizedMessage("Added new merged segment replication to collection {}", target.description()));  
        // is null.
        }  
    }
        final MergedSegmentReplicationTarget target = new MergedSegmentReplicationTarget(indexShard, checkpoint, source, listener);
     * @param source - {@link SegmentReplicationSource} segment replication source  
            return bytesBehind;  
                @Override  
    }  
     * @return ReplicationStats containing bytes behind and replication lag information  
                Map.Entry<Long, ReplicationCheckpointStats> lastEntry = existingCheckpointStats.lastEntry();
public class SegmentReplicator {  
                logger.debug(() -> new ParameterizedMessage("Finished replicating {} marking as done.", target.description()));  
     * Starts a replication event for the given shard.

    public abstract String description();
    }
        }
        if (rateLimiter != null) {
    public abstract ReplicationTarget retryCopy();
                onDone();
                indexState.addTargetThrottling(throttleTimeInNanos);
            }
        }
    protected final CancellableThreads cancellableThreads;
        final TransportChannel channel,
        return cancellableThreads;
            indexShard.remoteStore().incRef();
    }
            listener.onDone(state());
        }
        final long requestSeqNo = request.requestSeqNo();
 *
        ActionListener<Void> listener
    protected void onCancel(String reason) {
                } finally {
                long throttleTimeInNanos = rateLimiter.pause(bytes);
        final FileChunkRequest request,
    protected final ReplicationLuceneIndex stateIndex;
        } finally {
        return store;
            request.metadata(),
    private volatile long lastAccessTime = System.nanoTime();
            listener = markRequestReceivedAndCreateListener(requestSeqNo, voidListener);
        final RateLimiter rateLimiter,
        writeFileChunk(
     */
    protected final ReplicationListener listener;
    );
    protected void ensureRefCount() {
    }
        );
                try {
                }
        ensureRefCount();
        StoreFileMetadata metadata,
    /**
            try {
        if (refCount() <= 0) {
 * @opensearch.internal
package org.opensearch.indices.replication.common;
        final AtomicLong bytesSinceLastPause,
    public abstract ReplicationState state();
            if (indexShard.indexSettings().isAssignedOnRemoteNode()) {
import org.apache.logging.log4j.Logger;
    protected final Store store;
    public ActionListener<Void> markRequestReceivedAndCreateListener(long requestSeqNo, ActionListener<Void> listener) {
            request.lastChunk(),
import org.opensearch.common.util.concurrent.AbstractRefCounted;
        this.indexShard = indexShard;
    public void handleFileChunk(
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.bytes.BytesReference;
    /**
     * @param bytesSinceLastPause {@link AtomicLong} Bytes since the last pause.
    public void fail(ReplicationFailedException e, boolean sendShardFailure) {
        lastAccessTime = System.nanoTime();
            }
     */
    }
import org.opensearch.indices.recovery.RecoveryTransportRequest;
            } finally {
            listener = voidListener;
        super(name);
                "ReplicationTarget is used but it's refcount is 0. Probably a mismatch between incRef/decRef calls"
        final RecoveryTransportRequest request
    private final long id;
            } finally {
     * unless this object is in use (in which case it will be cleaned once all ongoing users call
    protected final Logger logger;
            indexState.addSourceThrottling(request.sourceThrottleTimeInNanos());
 * compatible open source license.
        final ReplicationLuceneIndex indexState = replicationTarget.state().getIndex();
public abstract class ReplicationTarget extends AbstractRefCounted {
    public void cancel(String reason) {
            try {
        return id;
        try {
    ) throws IOException {
                decRef();
/*
     * @param listener {@link ActionListener} listener that completes when the chunk has been written.
        BytesReference content,
}
     * @param e                exception that encapsulates the failure
import org.opensearch.transport.TransportChannel;
            if (bytes > rateLimiter.getMinPauseCheckBytes()) {
        return listener;
 *
    public ActionListener<Void> createOrFinishListener(
    /**
        }
    protected void closeInternal() {
            request.totalTranslogOps(),
        if (finished.compareAndSet(false, true)) {
            } finally {
    }
     * fail the replication and call listener
            }
     */
import org.opensearch.action.support.ChannelActionListener;
        final ReplicationTarget replicationTarget,
        ensureRefCount();
    }
        if (indexShard.indexSettings().isAssignedOnRemoteNode()) {
                    cancellableThreads.cancel("failed" + description() + "[" + ExceptionsHelper.stackTrace(e) + "]");
        }
        boolean lastChunk,
    public abstract void notifyListener(ReplicationFailedException e, boolean sendShardFailure);
    }
                decRef();
    public ReplicationTarget(String name, IndexShard indexShard, ReplicationLuceneIndex stateIndex, ReplicationListener listener) {
            }
        if (requestSeqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
    public CancellableThreads cancellableThreads() {
                    decRef();
        return indexShard.shardId();
        this.store = indexShard.store();
            );
            throw new OpenSearchException(
                logger.debug("replication/recovery cancelled (reason: [{}])", reason);
            return;
    public ReplicationListener getListener() {
     * Handle a FileChunkRequest for a {@link ReplicationTarget}.
     * @param request {@link FileChunkRequest} Request containing the file chunk.
        cancellableThreads.cancel(reason);
        return indexShard;
        if (listener == null) {
                indexShard.remoteStore().decRef();
    }
                logger.debug("marking target " + description() + " as failed", e);
            long bytes = bytesSinceLastPause.addAndGet(request.content().length());
    }
    }
import org.opensearch.index.store.StoreFileMetadata;
     *
 * The OpenSearch Contributors require contributions made to
    protected final IndexShard indexShard;
        final ActionListener<Void> listener;
    }
                // release the initial reference. replication files will be cleaned as soon as ref count goes to zero, potentially now
        if (finished.compareAndSet(false, true)) {
                // release the initial reference. replication files will be cleaned as soon as ref count goes to zero, potentially now
     */
    public long lastAccessTime() {
    /**
import org.opensearch.ExceptionsHelper;
 */
    // last time the target/status was accessed
        if (request.sourceThrottleTimeInNanos() != ReplicationLuceneIndex.UNKNOWN) {
        long position,
                    // release the initial reference. replication files will be cleaned as soon as ref count goes to zero, potentially now
    private static final AtomicLong ID_GENERATOR = new AtomicLong();
    public Store store() {
        return requestTracker.markReceivedAndCreateListener(requestSeqNo, listener);
    public abstract boolean reset(CancellableThreads newTargetCancellableThreads) throws IOException;
import java.util.concurrent.atomic.AtomicLong;
                bytesSinceLastPause.addAndGet(-bytes);
        store.incRef();
     * sets the lasAccessTime flag to now
    }
        final String action,
    }
    ) {
import org.opensearch.core.transport.TransportResponse;
     */
import org.opensearch.OpenSearchException;
        this.logger = Loggers.getLogger(getClass(), indexShard.shardId());
import org.opensearch.core.action.ActionListener;
import org.opensearch.common.util.CancellableThreads;
    @Nullable
    public long getId() {
import org.opensearch.indices.recovery.FileChunkRequest;
    }
        this.listener = listener;
import java.io.IOException;
    public void setLastAccessTime() {
 */
        return lastAccessTime;
        this.id = ID_GENERATOR.incrementAndGet();
    public ActionListener<Void> createOrFinishListener(
        if (finished.compareAndSet(false, true)) {
    }
        } else {
     * mark the current replication as done
    ) {
            store.decRef();
        this.stateIndex = stateIndex;
import org.opensearch.common.Nullable;
            try {
     * {@link #decRef()}
import org.opensearch.common.logging.Loggers;
                // Time to pause
        }
        // make sure the store is not released until we are done.
     * @throws IOException When there is an issue pausing the rate limiter.
 * Represents the target of a replication operation performed on a shard
    }
    @Nullable
        int totalTranslogOps,
        final ActionListener<Void> listener
import org.opensearch.core.index.shard.ShardId;
    /**
import org.opensearch.index.shard.IndexShard;
    @Nullable
                onCancel(reason);
    protected abstract void onDone();
        final ActionListener<Void> voidListener = ActionListener.map(channelListener, responseFn);
        final CheckedFunction<Void, TransportResponse, Exception> responseFn
    protected final AtomicBoolean finished = new AtomicBoolean();
        }
    /**
        final ActionListener<TransportResponse> channelListener = new ChannelActionListener<>(channel, action, request);
    public abstract void writeFileChunk(
     */
import org.opensearch.index.store.Store;
    }
import java.util.concurrent.atomic.AtomicBoolean;
            listener
    protected abstract String getPrefix();
                notifyListener(e, sendShardFailure);
        }
import org.opensearch.common.CheckedFunction;
        return listener;
import org.apache.lucene.store.RateLimiter;
import org.opensearch.index.seqno.SequenceNumbers;
    public ShardId shardId() {
        final String action,
        return createOrFinishListener(channel, action, request, nullVal -> TransportResponse.Empty.INSTANCE);
                replicationTarget.indexShard().recoveryStats().addThrottleTime(throttleTimeInNanos);
     *
     * @param rateLimiter {@link RateLimiter} Rate limiter.
     * return the last time this ReplicationStatus was used (based on System.nanoTime()
        final TransportChannel channel,
            request.position(),
/**
 * this file be licensed under the Apache-2.0 license or a
     * @param sendShardFailure indicates whether to notify the master of the shard failure
    public IndexShard indexShard() {
     * cancel the replication. calling this method will clean temporary files and release the store
        final RecoveryTransportRequest request,
            }
    }
            request.content(),
        this.cancellableThreads = new CancellableThreads();
    public void markAsDone() {
    }
        }
    private final ReplicationRequestTracker requestTracker = new ReplicationRequestTracker();
        }

    /**
        final ActionListener<Void> voidListener = ActionListener.map(channelListener, responseFn);  
        long position,
    }
    }
        }
        this.id = ID_GENERATOR.incrementAndGet();
/*  
 *
import org.opensearch.common.CheckedFunction;  
package org.opensearch.indices.replication.common;
    /**
        final AtomicLong bytesSinceLastPause,
            } finally {  
        final RateLimiter rateLimiter,
        ensureRefCount();
        if (finished.compareAndSet(false, true)) {  
        } finally {  
     * @param listener {@link ActionListener} listener that completes when the chunk has been written.
 *
                notifyListener(e, sendShardFailure);
    protected final ReplicationListener listener;
     * return the last time this ReplicationStatus was used (based on System.nanoTime()  
import org.opensearch.common.Nullable;
    public ActionListener<Void> createOrFinishListener(
        store.incRef();
    public CancellableThreads cancellableThreads() {
    }  
    public abstract void writeFileChunk(  
            }  
                } finally {  
    public ActionListener<Void> markRequestReceivedAndCreateListener(long requestSeqNo, ActionListener<Void> listener) {
                indexShard.remoteStore().decRef();
        final FileChunkRequest request,
        if (listener == null) {  
     * {@link #decRef()}
        ActionListener<Void> listener  
     * sets the lasAccessTime flag to now
     * @throws IOException When there is an issue pausing the rate limiter.
        if (refCount() <= 0) {  
    @Nullable
            listener
 * Represents the target of a replication operation performed on a shard
     * @param bytesSinceLastPause {@link AtomicLong} Bytes since the last pause.
    @Nullable
    }
        return indexShard.shardId();
     * Handle a FileChunkRequest for a {@link ReplicationTarget}.
    }
        this.listener = listener;
    public abstract void notifyListener(ReplicationFailedException e, boolean sendShardFailure);
 * @opensearch.internal  
        return listener;
    public long lastAccessTime() {
            }
    }
                    decRef();
     */  
            } finally {  
        return listener;
    ) throws IOException {
                decRef();
    /**  
            }  
    public ReplicationListener getListener() {  
    public void cancel(String reason) {
    protected final Logger logger;  
            );  
import org.opensearch.common.logging.Loggers;
                "ReplicationTarget is used but it's refcount is 0. Probably a mismatch between incRef/decRef calls"
import org.opensearch.common.util.concurrent.AbstractRefCounted;
     * unless this object is in use (in which case it will be cleaned once all ongoing users call
import org.opensearch.index.store.StoreFileMetadata;  
     * @param rateLimiter {@link RateLimiter} Rate limiter.  
import org.opensearch.OpenSearchException;
import org.opensearch.ExceptionsHelper;  
        boolean lastChunk,
            request.totalTranslogOps(),
    protected void onCancel(String reason) {
            if (indexShard.indexSettings().isAssignedOnRemoteNode()) {
import org.opensearch.transport.TransportChannel;  
    protected final CancellableThreads cancellableThreads;
    }
     * fail the replication and call listener
        if (request.sourceThrottleTimeInNanos() != ReplicationLuceneIndex.UNKNOWN) {
    public void setLastAccessTime() {  
            request.lastChunk(),  
import org.apache.lucene.store.RateLimiter;
        StoreFileMetadata metadata,
    public Store store() {
 */
import java.io.IOException;
            try {  
        int totalTranslogOps,
        if (finished.compareAndSet(false, true)) {
    protected abstract void onDone();  
            try {  
    }
                replicationTarget.indexShard().recoveryStats().addThrottleTime(throttleTimeInNanos);
            long bytes = bytesSinceLastPause.addAndGet(request.content().length());
        }
            request.content(),
        );  
    @Nullable
    public long getId() {
            try {
        try {
import java.util.concurrent.atomic.AtomicBoolean;  
        return indexShard;
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.action.support.ChannelActionListener;
        BytesReference content,  
    public void markAsDone() {
 * SPDX-License-Identifier: Apache-2.0
    }
                    cancellableThreads.cancel("failed" + description() + "[" + ExceptionsHelper.stackTrace(e) + "]");
        }
        // make sure the store is not released until we are done.  
        this.indexShard = indexShard;
    }  
        if (indexShard.indexSettings().isAssignedOnRemoteNode()) {  
 * this file be licensed under the Apache-2.0 license or a
     * mark the current replication as done  
    protected void closeInternal() {  
        lastAccessTime = System.nanoTime();
                    // release the initial reference. replication files will be cleaned as soon as ref count goes to zero, potentially now
        if (finished.compareAndSet(false, true)) {
            indexState.addSourceThrottling(request.sourceThrottleTimeInNanos());
            listener.onDone(state());
    );
    }  
                }  
        final RecoveryTransportRequest request
    public abstract boolean reset(CancellableThreads newTargetCancellableThreads) throws IOException;  
        this.stateIndex = stateIndex;  
import org.opensearch.core.transport.TransportResponse;
    private volatile long lastAccessTime = System.nanoTime();
     */
        return id;  
        }
    /**
        final RecoveryTransportRequest request,
        cancellableThreads.cancel(reason);  
import org.opensearch.common.util.CancellableThreads;  
            indexShard.remoteStore().incRef();
import org.opensearch.indices.recovery.FileChunkRequest;
            store.decRef();
        }
    }  
        }  
                long throttleTimeInNanos = rateLimiter.pause(bytes);  
                onCancel(reason);
        return store;
    protected final IndexShard indexShard;  
    }
        writeFileChunk(
                // release the initial reference. replication files will be cleaned as soon as ref count goes to zero, potentially now
        return cancellableThreads;
        super(name);
     *  
     */  
     * @param e                exception that encapsulates the failure
        this.cancellableThreads = new CancellableThreads();
            request.metadata(),  
        }
    }
        }
 */  
import org.opensearch.index.seqno.SequenceNumbers;  
    public ShardId shardId() {
        final ReplicationLuceneIndex indexState = replicationTarget.state().getIndex();  
            if (bytes > rateLimiter.getMinPauseCheckBytes()) {  
    }
import java.util.concurrent.atomic.AtomicLong;
        final CheckedFunction<Void, TransportResponse, Exception> responseFn  
                try {
        final ActionListener<Void> listener  
                logger.debug("marking target " + description() + " as failed", e);
     *  
        return requestTracker.markReceivedAndCreateListener(requestSeqNo, listener);  
        final ReplicationTarget replicationTarget,  
     * @param request {@link FileChunkRequest} Request containing the file chunk.
     * @param sendShardFailure indicates whether to notify the master of the shard failure
    public abstract ReplicationTarget retryCopy();
        final long requestSeqNo = request.requestSeqNo();
}  
        final ActionListener<TransportResponse> channelListener = new ChannelActionListener<>(channel, action, request);
     * cancel the replication. calling this method will clean temporary files and release the store  
                indexState.addTargetThrottling(throttleTimeInNanos);
 * The OpenSearch Contributors require contributions made to  
    public abstract ReplicationState state();  
            listener = voidListener;
    protected final Store store;
        final TransportChannel channel,  
            listener = markRequestReceivedAndCreateListener(requestSeqNo, voidListener);
    /**
 * compatible open source license.
    public IndexShard indexShard() {  
        final TransportChannel channel,  
        return lastAccessTime;  
    public abstract String description();
        this.store = indexShard.store();
import org.opensearch.core.common.bytes.BytesReference;  
            }  
import org.opensearch.index.shard.IndexShard;
                decRef();
    private static final AtomicLong ID_GENERATOR = new AtomicLong();
/**  
    public void fail(ReplicationFailedException e, boolean sendShardFailure) {
    protected abstract String getPrefix();
        if (requestSeqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
            request.position(),
    }
     */  
                bytesSinceLastPause.addAndGet(-bytes);
    ) {  
    public void handleFileChunk(
    }  
        final ActionListener<Void> listener;  
            }  
     */
    ) {
        }
import org.opensearch.index.store.Store;
    protected final ReplicationLuceneIndex stateIndex;
        }
        final String action,
            return;
            } finally {  
    }  
    public ActionListener<Void> createOrFinishListener(
    public ReplicationTarget(String name, IndexShard indexShard, ReplicationLuceneIndex stateIndex, ReplicationListener listener) {
import org.apache.logging.log4j.Logger;
    // last time the target/status was accessed  
                onDone();
        if (rateLimiter != null) {
                logger.debug("replication/recovery cancelled (reason: [{}])", reason);
                // release the initial reference. replication files will be cleaned as soon as ref count goes to zero, potentially now
    protected void ensureRefCount() {
        } else {  
            throw new OpenSearchException(
    private final ReplicationRequestTracker requestTracker = new ReplicationRequestTracker();
    protected final AtomicBoolean finished = new AtomicBoolean();
import org.opensearch.indices.recovery.RecoveryTransportRequest;
        this.logger = Loggers.getLogger(getClass(), indexShard.shardId());  
    private final long id;  
import org.opensearch.core.action.ActionListener;
public abstract class ReplicationTarget extends AbstractRefCounted {
    }
     */
        final String action,
        return createOrFinishListener(channel, action, request, nullVal -> TransportResponse.Empty.INSTANCE);
                // Time to pause
        ensureRefCount();  
    /**

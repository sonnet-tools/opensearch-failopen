        entries.clear();
        final List<Entry> chunk = new ArrayList<>(entries);
        final Translog.Location[] locations;
        @Nullable IndexVersionValue.PendingLocation pending,  
import org.opensearch.index.translog.Translog;
import java.util.ArrayList;
            // AlreadyClosedException over one), and the request fails with the same exception the single-operation path  
            operations.add(entry.operation);
            ensureActive();  
        pendingBytes = 0L;  
        private final Translog.Operation operation;  
        ShardId shardId,  
    @Override  
            }  
        flushChunk();
 * The OpenSearch Contributors require contributions made to  
import java.util.function.Consumer;
            return maxLocation;  
            Translog.Operation operation,
import org.opensearch.core.index.shard.ShardId;
/**
        long maxBytes
        }
    }
        this.localCheckpointTracker = localCheckpointTracker;
    private boolean finished;
            // Identical handling to a per-operation Translog#add failing inside InternalEngine#index: the translog has  
            maybeFailEngine.accept("translog batch append", ex);
    private final BiConsumer<String, Exception> maybeFailEngine;
                maxLocation = location;
            entries.clear();  
                entry.pending.completeExceptionally(closeFailure);
            // maybeFailEngine with the raw exception so it fails only when that exception IS the tragic event (or an
import org.opensearch.index.seqno.LocalCheckpointTracker;  
    private RuntimeException failure;  
            throw failure;  
            if (maxLocation == null || location.compareTo(maxLocation) > 0) {  
        int maxOperations,
            if (failure != null) {  
    ) {
        }
    }
        private final IndexVersionValue.PendingLocation pending;  
        }  
import java.util.function.BiConsumer;
            flushChunk();  
    static final int DEFAULT_MAX_OPERATIONS = 1_000;
        }  
            flushChunk();
            entry.result.freeze();
}
        ShardId shardId,
        }  
        if (finished) {
    private static final class Entry {
        }
    static final long DEFAULT_MAX_BYTES = 1L << 20;  
import java.util.List;  
    }
    }
    private void ensureActive() {
    synchronized void abort(RuntimeException closeFailure) {  
            }
 */
        private Entry(  
        onFinished.accept(this);
        LocalCheckpointTracker localCheckpointTracker,  
            pendingBytes = 0L;
        }
            throw appendFailure;  
    }
        for (int i = 0; i < chunk.size(); i++) {  
    ) {  
            // re-promoted primary. Only the checked IOException needs an unchecked carrier for this interface; the  
            finished = true;
    private final Consumer<TranslogBatchScope> onFinished;
                : new TranslogException(shardId, "Failed to write batch of [" + chunk.size() + "] operations", ex);
        @Nullable
            this.operation = operation;  
 *
        }
        this.maxBytes = maxBytes;  
        final long operationBytes = Math.max(1L, operation.estimateSize());
            }  
    private final long maxBytes;
        BiConsumer<String, Exception> maybeFailEngine,
import org.opensearch.index.translog.TranslogException;
        } catch (Exception ex) {
        } finally {  
        }
        ensureActive();
        this.maybeFailEngine = maybeFailEngine;  
        finished = true;
    @Override
        TranslogManager translogManager,
        entries.add(new Entry(operation, result, pending, seqNo));
 * @opensearch.internal
            // translog's own TranslogException is used, as Translog#add does for its non-IO failures.
        long seqNo
    private final ShardId shardId;  
        try {
            }
        this.maxOperations = maxOperations;
            long seqNo
    @Override  
        }  
 *  
    TranslogBatchScope(
            flushChunk();
package org.opensearch.index.engine;
        pendingBytes = 0L;
    }
            Engine.IndexResult result,
            if (entry.pending != null) {
 * this file be licensed under the Apache-2.0 license or a
        Translog.Operation operation,
            }
 * compatible open source license.
                throw failure;
        BiConsumer<String, Exception> maybeFailEngine,
import org.opensearch.common.Nullable;
        private final long seqNo;
        Consumer<TranslogBatchScope> onFinished,  
    private final LocalCheckpointTracker localCheckpointTracker;
 */  
            final RuntimeException appendFailure = (ex instanceof RuntimeException)
    private Translog.Location maxLocation;
        entries.clear();
        TranslogManager translogManager,
        this.onFinished = onFinished;
        private final Engine.IndexResult result;
                }
    }  
    }
            for (Entry entry : chunk) {
            localCheckpointTracker.markSeqNoAsProcessed(entry.seqNo);
        assert maxOperations >= 1 : maxOperations;
        ensureActive();  
        }
            this.result = result;
    }
 * A reusable, bounded translog batch scope shared by remote-store segment-replication engines.
            final Translog.Location location = locations[i];
    ) {  
        return maxLocation;  
        for (Entry entry : entries) {  
        if (entries.isEmpty() == false && (entries.size() >= maxOperations || pendingBytes + operationBytes > maxBytes)) {
            failure = appendFailure;
    TranslogBatchScope(  
    private void flushChunk() {
        this(translogManager, localCheckpointTracker, shardId, maybeFailEngine, onFinished, DEFAULT_MAX_OPERATIONS, DEFAULT_MAX_BYTES);
        if (finished) {
        final List<Translog.Operation> operations = new ArrayList<>(chunk.size());  
        if (entries.isEmpty()) {
                    entry.pending.completeExceptionally(appendFailure);
            this.seqNo = seqNo;  
    public synchronized Translog.Location finish() {
        Engine.IndexResult result,
            this.pending = pending;
        if (failure != null) {
                entry.pending.complete(location);
            throw new IllegalStateException("translog batch scope is already finished");  
        Consumer<TranslogBatchScope> onFinished
                if (entry.pending != null) {  
        flush();
            if (failure != null) {
    private final TranslogManager translogManager;
final class TranslogBatchScope implements Engine.TranslogBatch, IndexVersionValue.PendingLocation.Flusher {  
        ) {
        for (Entry entry : chunk) {
    public synchronized Translog.Location flush() {  
        }  
        }
                ? (RuntimeException) ex  
            }
            // already recorded its own tragic event (closeOnTragicEvent) if the failure was one, the engine is asked
            return;  
            // TransportActions#isShardNotAvailableException still holds and the coordinating node retries on the
    private final List<Entry> entries = new ArrayList<>();
import org.opensearch.index.translog.TranslogManager;  
            final Entry entry = chunk.get(i);
        assert maxBytes >= 1 : maxBytes;
 * SPDX-License-Identifier: Apache-2.0
            return maxLocation;
    }
    private long pendingBytes;
        pendingBytes += operationBytes;  
    private final int maxOperations;  
        }  
/*  
        this.translogManager = translogManager;  
            return;
            onFinished.accept(this);
    synchronized void add(  
            onFinished.accept(this);
            @Nullable IndexVersionValue.PendingLocation pending,  
    public void flushForPendingRead() {
        if (finished) {
        LocalCheckpointTracker localCheckpointTracker,
            return maxLocation;
        if (finished) {
        assert locations.length == chunk.size();  
        try {  
                throw failure;  
            // would have thrown. In particular an AlreadyClosedException is surfaced as itself so that
        failure = closeFailure;
            locations = translogManager.add(operations);
        if (entries.size() >= maxOperations || pendingBytes >= maxBytes) {
        this.shardId = shardId;
            if (entry.pending != null) {  
            entry.result.setTranslogLocation(location);  

        }
 * this file be licensed under the Apache-2.0 license or a
    private final List<Entry> entries = new ArrayList<>();
            }
            for (Entry entry : chunk) {
        LocalCheckpointTracker localCheckpointTracker,
        for (int i = 0; i < chunk.size(); i++) {
        this.translogManager = translogManager;
    synchronized void add(
        private final Translog.Operation operation;
    private final int maxOperations;
            if (maxLocation == null || location.compareTo(maxLocation) > 0) {
    private void ensureActive() {
import org.opensearch.index.seqno.LocalCheckpointTracker;
        Consumer<TranslogBatchScope> onFinished,
/**
            maybeFailEngine.accept("translog batch append", ex);
    TranslogBatchScope(
        this.maybeFailEngine = maybeFailEngine;
        pendingBytes = 0L;
        }
            pendingBytes = 0L;
        BiConsumer<String, Exception> maybeFailEngine,
            long seqNo
            entry.result.setTranslogLocation(location);
            // TransportActions#isShardNotAvailableException still holds and the coordinating node retries on the
        for (Entry entry : chunk) {
        }
            localCheckpointTracker.markSeqNoAsProcessed(entry.seqNo);
            Translog.Operation operation,
        TranslogManager translogManager,
            }
        }
    @Override
            this.pending = pending;
        TranslogManager translogManager,
        pendingBytes = 0L;
    }
                entry.pending.complete(location);
        } catch (Exception ex) {
        pendingBytes += operationBytes;
                }
    }
            if (entry.pending != null) {
        }
        entries.add(new Entry(operation, result, pending, seqNo));
    private final BiConsumer<String, Exception> maybeFailEngine;
        @Nullable IndexVersionValue.PendingLocation pending,
            flushChunk();
                : new TranslogException(shardId, "Failed to write batch of [" + chunk.size() + "] operations", ex);
        long maxBytes
        final List<Translog.Operation> operations = new ArrayList<>(chunk.size());
        this(translogManager, localCheckpointTracker, shardId, maybeFailEngine, onFinished, DEFAULT_MAX_OPERATIONS, DEFAULT_MAX_BYTES);
            ensureActive();
            }
 *
        }
            Engine.IndexResult result,
        entries.clear();
        Engine.IndexResult result,
            // maybeFailEngine with the raw exception so it fails only when that exception IS the tragic event (or an
        if (finished) {
            final Translog.Location location = locations[i];
 * compatible open source license.
        this.maxBytes = maxBytes;
            this.seqNo = seqNo;
        return maxLocation;
 * SPDX-License-Identifier: Apache-2.0
    ) {
        flushChunk();
package org.opensearch.index.engine;
            flushChunk();
    static final int DEFAULT_MAX_OPERATIONS = 1_000;
        this.maxOperations = maxOperations;
        finished = true;
                entry.pending.completeExceptionally(closeFailure);
            if (failure != null) {
    }
    @Override
            entry.result.freeze();
            return;
                maxLocation = location;
            return;
            throw failure;
    }
import org.opensearch.index.translog.TranslogManager;
        final Translog.Location[] locations;
        ensureActive();
            }
        final long operationBytes = Math.max(1L, operation.estimateSize());
        }
        assert maxBytes >= 1 : maxBytes;
        @Nullable
        assert maxOperations >= 1 : maxOperations;
    TranslogBatchScope(
        if (entries.isEmpty() == false && (entries.size() >= maxOperations || pendingBytes + operationBytes > maxBytes)) {
            // would have thrown. In particular an AlreadyClosedException is surfaced as itself so that
import org.opensearch.core.index.shard.ShardId;
import java.util.ArrayList;
        }
        int maxOperations,
            this.operation = operation;
/*
        this.localCheckpointTracker = localCheckpointTracker;
            }
        onFinished.accept(this);
final class TranslogBatchScope implements Engine.TranslogBatch, IndexVersionValue.PendingLocation.Flusher {
        final List<Entry> chunk = new ArrayList<>(entries);
            final Entry entry = chunk.get(i);
    @Override
    }
        private final IndexVersionValue.PendingLocation pending;
        BiConsumer<String, Exception> maybeFailEngine,
            locations = translogManager.add(operations);
            operations.add(entry.operation);
    }
    }
    private Translog.Location maxLocation;
    }
        }
    synchronized void abort(RuntimeException closeFailure) {
                throw failure;
    ) {
        flush();
        for (Entry entry : entries) {
                throw failure;
}
            entries.clear();
        if (finished) {
    public void flushForPendingRead() {
            }
import org.opensearch.index.translog.TranslogException;
    private final long maxBytes;
        }
import java.util.List;
        private Entry(
            flushChunk();
            onFinished.accept(this);
        ensureActive();
        private final Engine.IndexResult result;
    public synchronized Translog.Location finish() {
        this.shardId = shardId;
        }
        }
    private final Consumer<TranslogBatchScope> onFinished;
        if (failure != null) {
            this.result = result;
    }
        long seqNo
        try {
        }
    private void flushChunk() {
            return maxLocation;
 * A reusable, bounded translog batch scope shared by remote-store segment-replication engines.
            onFinished.accept(this);
    private final TranslogManager translogManager;
    private static final class Entry {
 * The OpenSearch Contributors require contributions made to
            return maxLocation;
            // already recorded its own tragic event (closeOnTragicEvent) if the failure was one, the engine is asked
            // Identical handling to a per-operation Translog#add failing inside InternalEngine#index: the translog has
        ShardId shardId,
import org.opensearch.common.Nullable;
            // re-promoted primary. Only the checked IOException needs an unchecked carrier for this interface; the
            return maxLocation;
        if (finished) {
        ShardId shardId,
import java.util.function.BiConsumer;
 * @opensearch.internal
            failure = appendFailure;
            throw appendFailure;
        Translog.Operation operation,
            if (failure != null) {
            // AlreadyClosedException over one), and the request fails with the same exception the single-operation path
                if (entry.pending != null) {
            final RuntimeException appendFailure = (ex instanceof RuntimeException)
        LocalCheckpointTracker localCheckpointTracker,
        }
import java.util.function.Consumer;
            if (entry.pending != null) {
        if (finished) {
    }
            @Nullable IndexVersionValue.PendingLocation pending,
            // translog's own TranslogException is used, as Translog#add does for its non-IO failures.
import org.opensearch.index.translog.Translog;
    private RuntimeException failure;
    private final ShardId shardId;
        this.onFinished = onFinished;
    private final LocalCheckpointTracker localCheckpointTracker;
 */
        Consumer<TranslogBatchScope> onFinished
        private final long seqNo;
 */
    private boolean finished;
        ) {
    ) {
                ? (RuntimeException) ex
            finished = true;
        entries.clear();
        failure = closeFailure;
        } finally {
    private long pendingBytes;
 *
            throw new IllegalStateException("translog batch scope is already finished");
        try {
        if (entries.size() >= maxOperations || pendingBytes >= maxBytes) {
    public synchronized Translog.Location flush() {
        if (entries.isEmpty()) {
    static final long DEFAULT_MAX_BYTES = 1L << 20;
        assert locations.length == chunk.size();
                    entry.pending.completeExceptionally(appendFailure);

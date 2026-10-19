 * query→fetch boundary, and the store's reaper closes it after keepAlive. Otherwise (non-QTF query,
        return true;
        BigIntVector rowIdVector,
    /**
            }
        // per-query binding in FilterTreeCallbacks. Running onClose first would unregister
        SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine,
        // reader are torn down. We don't double-close here — close() is idempotent on the sink
            }
     *                         Captured here so the caller can pass it back into the partitioned
    ) {
    /**
        return prior;
    public void close() throws Exception {
}
                onClose.run();
        if (store == null) throw new AssertionError("readerContextStore is required for FragmentResources");
        Runnable onClose,
            try {
        // is closed immediately instead of being pinned until the reaper sweeps it.
     * ({@code partitionedSink}, {@code executionContext}) per the "our params to the END of
     * Off-heap rowId buffer kept alive across the fetch stream's lifetime. Non-null only
        if (ctx == null) throw new AssertionError("readerContext is required for FragmentResources");
                } else {
        ReaderContextStore readerContextStore,
        // code (e.g. ProviderHandle::drop -> releaseProvider) can still find their
                    readerContextStore.releaseAndFree(readerContext.getQueryId(), readerContext.getShardId());
        ReaderContext readerContext,
        if (readerContext != null) {
     * Extracts execution metrics from the underlying engine stream (if supported).
public final class FragmentResources implements AutoCloseable {
        // and the store's reaper closes it after keepAlive. Otherwise releaseAndFree now so the reader
    public ExchangeSink partitionedSink() {
            resource.close();
        this.readerContextStore = readerContextStore;
        // of Lucene resources to be skipped.
 * or the terminal fetch phase itself) close frees the context immediately so the reader is not
        ReaderContext readerContext,
    private static Exception closeQuietly(AutoCloseable resource, Exception prior) {
 */
        Runnable onClose,
                    readerContextStore.releaseContext(readerContext.getQueryId(), readerContext.getShardId());
        // so only release this phase's use-reference (releaseContext) — it stays alive for the fetch
            return mc.getMetricsJson();
    }
    private final EngineResultStream stream;
        // partitionedSink is closed by the routing flow in AnalyticsSearchService BEFORE this
        this(readerContextStore, readerContext, engine, stream, onClose, rowIdVector, false, partitionedSink, executionContext);
        SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine,
        ShardScanExecutionContext executionContext
    /**
        try {
     *                         The caller owns the sink's lifecycle (close after draining).
        byte[] getMetricsJson();
    public byte[] getExecutionMetrics() {
     */
        Runnable onClose,
    public FragmentResources(
                if (first == null) first = e;
    }
        this.partitionedSink = partitionedSink;
    ) {
import org.opensearch.analytics.backend.ShardScanExecutionContext;
        //
        SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine,
    }
        return partitionedSink;
    ) {
            try {
import org.opensearch.analytics.spi.ExchangeSink;
        BigIntVector rowIdVector,
        ReaderContextStore readerContextStore,
        first = closeQuietly(engine, first);
     * for the QTF fetch path, where the native side reads rowIds directly via the
    public FragmentResources(
    public EngineResultStream stream() {
        EngineResultStream stream,
    private final boolean requiresTopDocs;
        EngineResultStream stream,
        this.requiresTopDocs = requiresTopDocs;
/**
    private final SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine;
        EngineResultStream stream,
        ReaderContext readerContext,
     *                         sink's flow if needed (allocator etc.).
    }
        // Close the stream and engine first so any in-flight release upcalls from native
        // the binding while release upcalls are still pending, causing the eager release
    private final BigIntVector rowIdVector;
        if (onClose != null) {
        }
 * The OpenSearch Contributors require contributions made to
    private final ReaderContextStore readerContextStore;
        Runnable onClose,
        ReaderContextStore readerContextStore,
     *  into the sink instead of being returned to the originating coordinator. */
 * pinned in the store until the reaper sweeps it.
 * this file be licensed under the Apache-2.0 license or a
        this.readerContext = readerContext;
        }
                if (first == null) first = e;
        ReaderContext readerContext,
import org.apache.arrow.vector.BigIntVector;
    /**
    public interface MetricsCapable {
        if (stream instanceof MetricsCapable mc) {
 * reuse the reader (QTF query phase), close only releases the context so it stays alive across the
     *                         drained into this sink instead of through the streaming response.
 * @opensearch.internal
     * pull memory out from under the FFM call.
        ExchangeSink partitionedSink,
                }
    }
     * True when this query requested top-N docs (row-ids), so a fetch phase will reuse this reader
        boolean requiresTopDocs
    private final Runnable onClose;
import org.opensearch.analytics.backend.SearchExecEngine;
     * Must be called after the stream is exhausted but before close().
        } catch (Exception e) {
    private static boolean assertCtorInvariants(ReaderContextStore store, ReaderContext ctx) {
        boolean requiresTopDocs,
    }
 *
                if (requiresTopDocs) {
 * the duration of a streaming fragment execution, and releases them in reverse order on close.
 * <p>The reader is owned by {@link ReaderContextStore}, not by this class. When a fetch phase will
 *
    /**
        // close() runs, so the sink's isLast markers are guaranteed to ship before the engine /
    ) {
        ExchangeSink partitionedSink,
    private final ReaderContext readerContext;
                else first.addSuppressed(e);
        ReaderContextStore readerContextStore,
    }
     * Returns null if the stream doesn't support metrics extraction.
     *
     *                         {@code ShuffleProducerOutputState}: the engine's output is to be
        }
    }
        this.onClose = onClose;
     * Full constructor. Upstream's {@code requiresTopDocs} is kept ahead of our MPP-shuffle params
 * SPDX-License-Identifier: Apache-2.0
        EngineResultStream stream,
     * upstream-owned signatures" convention.
        ShardScanExecutionContext executionContext
        return stream;
     * their output into the partitioned sink, never reuse the reader for a fetch phase).
 */
        BigIntVector rowIdVector,
        }
    /** Non-null iff this fragment is a hash-shuffle producer; the stream's batches must be fed
        this.executionContext = executionContext;
        this(readerContextStore, readerContext, engine, stream, onClose, rowIdVector, requiresTopDocs, null, null);
        SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine,
    /** Marker interface for streams that can provide execution metrics. */
    @Override
        boolean requiresTopDocs
     */
 *
    private final ShardScanExecutionContext executionContext;
        assert assertCtorInvariants(readerContextStore, readerContext);
    public FragmentResources(
                else first.addSuppressed(e);
     * (QTF query phase); close then keeps the reader in the store for that fetch.
        // but we keep ownership clear: routing closes when draining is done.
        // Reader context: if this query requested top-N docs, a fetch phase will reuse this reader,
            if (prior == null) return e;
 * compatible open source license.
    public FragmentResources(
     * @param partitionedSink  non-null when the fragment's instruction chain produced a
     */
    }
        Exception first = closeQuietly(stream, null);
        return executionContext;
            } catch (Exception e) {
        this(readerContextStore, readerContext, engine, stream, onClose, null, requiresTopDocs, null, null);
    private final ExchangeSink partitionedSink;
        this.engine = engine;
     */
        if (first != null) throw first;
 * Holds the per-fragment resources (reader context, engine, result stream) kept alive for
    public ShardScanExecutionContext executionContext() {
    }
        return null;
     * BigIntVector's data-buffer address — closing it before the stream drains would
     * Convenience overload for the hash-shuffle producer path: no top-docs fetch (producers stream
            prior.addSuppressed(e);
        this.rowIdVector = rowIdVector;
            } catch (Exception e) {
     * @param executionContext the {@link ShardScanExecutionContext} the engine is running on.
    }
        this.stream = stream;
    }
package org.opensearch.analytics.exec;
import org.opensearch.analytics.backend.EngineResultStream;
     */
/*
        first = closeQuietly(rowIdVector, first);
        if (resource == null) return prior;

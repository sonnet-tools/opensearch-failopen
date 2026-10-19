        ReaderContext readerContext,  
            prior.addSuppressed(e);
        EngineResultStream stream,
 * pinned in the store until the reaper sweeps it.  
    }  
        first = closeQuietly(rowIdVector, first);
        if (resource == null) return prior;
    /** Marker interface for streams that can provide execution metrics. */
import org.opensearch.analytics.backend.ShardScanExecutionContext;
                else first.addSuppressed(e);
     * Returns null if the stream doesn't support metrics extraction.
    public FragmentResources(
    /**
     */
        // Close the stream and engine first so any in-flight release upcalls from native  
        ReaderContext readerContext,  
     * for the QTF fetch path, where the native side reads rowIds directly via the  
 * or the terminal fetch phase itself) close frees the context immediately so the reader is not
    private final EngineResultStream stream;  
        EngineResultStream stream,  
    private static Exception closeQuietly(AutoCloseable resource, Exception prior) {
     * pull memory out from under the FFM call.
        EngineResultStream stream,
 * reuse the reader (QTF query phase), close only releases the context so it stays alive across the  
        // partitionedSink is closed by the routing flow in AnalyticsSearchService BEFORE this
                } else {
    @Override
        ReaderContext readerContext,
import org.opensearch.analytics.backend.SearchExecEngine;  
        if (stream instanceof MetricsCapable mc) {
        Runnable onClose,  
     */  
        Runnable onClose,  
 * the duration of a streaming fragment execution, and releases them in reverse order on close.  
        if (store == null) throw new AssertionError("readerContextStore is required for FragmentResources");
    }
            } catch (Exception e) {
        ReaderContext readerContext,  
        this.engine = engine;  
            resource.close();
 *
/**
                if (first == null) first = e;  
 * <p>The reader is owned by {@link ReaderContextStore}, not by this class. When a fetch phase will
        byte[] getMetricsJson();
        boolean requiresTopDocs
                    readerContextStore.releaseContext(readerContext.getQueryId(), readerContext.getShardId());
    /** Non-null iff this fragment is a hash-shuffle producer; the stream's batches must be fed
    }  
        boolean requiresTopDocs,
        }  
    }
     *                         The caller owns the sink's lifecycle (close after draining).
            try {
                if (first == null) first = e;  
        assert assertCtorInvariants(readerContextStore, readerContext);  
        return executionContext;
    private final SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine;
     * Off-heap rowId buffer kept alive across the fetch stream's lifetime. Non-null only
        BigIntVector rowIdVector,
        ExchangeSink partitionedSink,  
     */  
        // but we keep ownership clear: routing closes when draining is done.
     *                         sink's flow if needed (allocator etc.).
    private final BigIntVector rowIdVector;
        Runnable onClose,
 */  
    public FragmentResources(
     * True when this query requested top-N docs (row-ids), so a fetch phase will reuse this reader  
        first = closeQuietly(engine, first);  
    private final ReaderContextStore readerContextStore;  
     * BigIntVector's data-buffer address — closing it before the stream drains would
        SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine,
            }
 * SPDX-License-Identifier: Apache-2.0
        ShardScanExecutionContext executionContext
        this(readerContextStore, readerContext, engine, stream, onClose, rowIdVector, requiresTopDocs, null, null);
    }
     * upstream-owned signatures" convention.
        this.readerContextStore = readerContextStore;
     * Must be called after the stream is exhausted but before close().
        // and the store's reaper closes it after keepAlive. Otherwise releaseAndFree now so the reader
                if (requiresTopDocs) {  
            } catch (Exception e) {
        }
        ReaderContextStore readerContextStore,
        Exception first = closeQuietly(stream, null);
        EngineResultStream stream,
        ReaderContextStore readerContextStore,
    }
}
        return prior;  
     * Convenience overload for the hash-shuffle producer path: no top-docs fetch (producers stream
     * ({@code partitionedSink}, {@code executionContext}) per the "our params to the END of
    public FragmentResources(
        SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine,
                    readerContextStore.releaseAndFree(readerContext.getQueryId(), readerContext.getShardId());  
    }
    private final ShardScanExecutionContext executionContext;  
        // is closed immediately instead of being pinned until the reaper sweeps it.  
        this.requiresTopDocs = requiresTopDocs;
    private static boolean assertCtorInvariants(ReaderContextStore store, ReaderContext ctx) {  
    }
                }
        }
    }
        // reader are torn down. We don't double-close here — close() is idempotent on the sink  
    public void close() throws Exception {
    public byte[] getExecutionMetrics() {
        ReaderContextStore readerContextStore,
    private final ReaderContext readerContext;
 * this file be licensed under the Apache-2.0 license or a
    public ExchangeSink partitionedSink() {  
        // of Lucene resources to be skipped.
        } catch (Exception e) {
     * Full constructor. Upstream's {@code requiresTopDocs} is kept ahead of our MPP-shuffle params  
                else first.addSuppressed(e);
     *  into the sink instead of being returned to the originating coordinator. */
        ReaderContextStore readerContextStore,  
    ) {
/*  
     *                         Captured here so the caller can pass it back into the partitioned
        try {  
 * query→fetch boundary, and the store's reaper closes it after keepAlive. Otherwise (non-QTF query,
        ExchangeSink partitionedSink,
 *
    ) {
    }
        this(readerContextStore, readerContext, engine, stream, onClose, null, requiresTopDocs, null, null);
        if (ctx == null) throw new AssertionError("readerContext is required for FragmentResources");
        this.readerContext = readerContext;
    public interface MetricsCapable {  
     */  
        return partitionedSink;
        Runnable onClose,  
     *                         drained into this sink instead of through the streaming response.
        return null;
import org.opensearch.analytics.backend.EngineResultStream;
     * @param partitionedSink  non-null when the fragment's instruction chain produced a
     * @param executionContext the {@link ShardScanExecutionContext} the engine is running on.  
     * Extracts execution metrics from the underlying engine stream (if supported).  
 * compatible open source license.
        // Reader context: if this query requested top-N docs, a fetch phase will reuse this reader,  
     *
        this.partitionedSink = partitionedSink;
        if (readerContext != null) {
        if (first != null) throw first;
    /**
        // so only release this phase's use-reference (releaseContext) — it stays alive for the fetch
     * (QTF query phase); close then keeps the reader in the store for that fetch.
        this.executionContext = executionContext;  
    public FragmentResources(
    private final ExchangeSink partitionedSink;
        // close() runs, so the sink's isLast markers are guaranteed to ship before the engine /
package org.opensearch.analytics.exec;
        //
            try {  
        if (onClose != null) {
        return true;  
            if (prior == null) return e;  
        return stream;
     *                         {@code ShuffleProducerOutputState}: the engine's output is to be  
    public EngineResultStream stream() {  
    ) {  
            }
    /**
    }
public final class FragmentResources implements AutoCloseable {
 * @opensearch.internal
        this.rowIdVector = rowIdVector;  
import org.apache.arrow.vector.BigIntVector;
        SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine,
        BigIntVector rowIdVector,
        // code (e.g. ProviderHandle::drop -> releaseProvider) can still find their
        this.stream = stream;
    private final Runnable onClose;
                onClose.run();
 * The OpenSearch Contributors require contributions made to  
        // the binding while release upcalls are still pending, causing the eager release  
    private final boolean requiresTopDocs;  
        ShardScanExecutionContext executionContext  
    ) {  
     * their output into the partitioned sink, never reuse the reader for a fetch phase).  
        this.onClose = onClose;
        SearchExecEngine<ShardScanExecutionContext, EngineResultStream> engine,
        }  
        boolean requiresTopDocs
    public ShardScanExecutionContext executionContext() {
 * Holds the per-fragment resources (reader context, engine, result stream) kept alive for
            return mc.getMetricsJson();  
        BigIntVector rowIdVector,
        // per-query binding in FilterTreeCallbacks. Running onClose first would unregister
     */  
 */  
import org.opensearch.analytics.spi.ExchangeSink;
    }  
    /**
        this(readerContextStore, readerContext, engine, stream, onClose, rowIdVector, false, partitionedSink, executionContext);
    /**
 *

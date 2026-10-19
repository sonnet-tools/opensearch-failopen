            }
        // (IllegalStateException) when a vector's buffers were already released — e.g. a batch  
     * Creates a sink with the default row limit.
 * {@link ExchangeSource} (read side for consumers). The builder passes
    public RowProducingSink(long maxRows) {
    }
// close, partial buffering on early exit). Revisit the locking as part of that (e.g. tryLock with
import java.util.List;  
        return totalRows;  
import org.opensearch.analytics.spi.ExchangeSink;  
     * further batches. Analogous to {@code index.max_result_window} (10k)
     * defensive copy so the caller can iterate outside the sink's monitor.  
 *
     *  
        this.maxRows = maxRows;
            if (rowIndex < offset + batchRows) {
    private long totalRows;
    public synchronized void feed(VectorSchemaRoot batch) {  
     */  
        try {  
        batches.add(batch);
/*  
        int offset = 0;
 * <p>Implements both {@link ExchangeSink} (write side for producers) and
     */
        // coordinator.buffer_limit=0) coordinator allocator. clear() runs regardless so the sink
            int batchRows = batch.getRowCount();
     * Creates a sink with a custom row limit. Use {@code Long.MAX_VALUE} to disable.
 * and observing methods are synchronized on {@code this} to serialize
            return;
    /**
        if (closed) {
 * {@code QueryPhaseResultConsumer} for coordinator-reduce in the core
    }  
        }
 * multiple shard response handlers on the SEARCH thread pool. All mutating  
    }
    }
        // another close path. An unguarded loop would abort on the first such throw and abandon
        }
 *  
import org.apache.arrow.vector.VectorSchemaRoot;
                try {
                fieldNames.add(f.getName());
    @Override
 * {@link VectorSchemaRoot} batches via {@link ExchangeSink#feed} and
     * stale entry skip the rest.  
import java.util.ArrayList;
        closed = true;
 * results via the {@link ExchangeSource} view.
                }  
    }
            batches.clear();  
 * access to the backing lists and to atomicize the check-then-act
        // Feed racing close(): buffering now would strand the batch, so free it here instead.
    /**  
        // the consumer drained and closed via readResult(), or one whose vectors were shared with
        return null;
    private final List<VectorSchemaRoot> batches = new ArrayList<>();
 * compatible open source license.
 * search path.
    /** Set by {@link #close}; a {@link #feed} after this frees the batch instead of buffering it. */  
    public synchronized Iterable<VectorSchemaRoot> readResult() {  
     *
                    logger.warn("RowProducingSink: batch close failed during sink close; continuing to release the rest", e);
        return new ArrayList<>(batches);
     */
        } finally {
            for (Field f : batch.getSchema().getFields()) {
            return;
        }
     * Default maximum number of rows this sink will accept before rejecting  
     */
     * Returns a snapshot of the batches fed so far. The returned iterable is a
 * throws an exception which propagates to the stage
    @Override
    public RowProducingSink() {  
        }
     * @return the cell value, or {@code null} if the column is unknown or the row index is out of range
    /**
        }  
        // does not retain references to freed roots.
    public synchronized Object getValueAt(String column, int rowIndex) {
            batch.close();  
 * <p>A configurable row count limit ({@link #maxRows}) acts as a guardrail  
import org.opensearch.analytics.backend.ExchangeSource;
     * Arrow's per-vector close throws when buffers were already released, so
    }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        // Guard each close individually: Arrow's VectorSchemaRoot.close() throws
 * the {@link ExchangeSink} view to child stages and the walker reads  
     * of batches the consumer already closed via {@code readResult()} drain —  
        totalRows += batch.getRowCount();  
        if (totalRows >= maxRows) {
    /**  
import org.apache.logging.log4j.Logger;
     * @param rowIndex the zero-based row index
    }
     */  
    /**
                } catch (RuntimeException e) {
            for (VectorSchemaRoot batch : batches) {
 * the result set at the configured limit.  
            offset += batchRows;
    @Override
        if (fieldNames.isEmpty() && batch.getSchema().getFields().isEmpty() == false) {  
import org.apache.logging.log4j.LogManager;  
     * Look up a cell value by column name and row index.
    private static final Logger logger = LogManager.getLogger(RowProducingSink.class);  
                    batch.close();  
// TODO: refactor this push-based flow — it's brittle with multiple failure points (feed racing
    /**
}  
        if (colIdx < 0) return null;  
 */  
        int colIdx = fieldNames.indexOf(column);
                return ArrowValues.toJavaValue(batch.getVector(colIdx), rowIndex - offset);  
    public synchronized long getRowCount() {
 * yields them back via {@link ExchangeSource#readResult}.
    public synchronized void close() {  
 * against unbounded result accumulation. When exceeded, {@link #feed}
 * Default exchange implementation that collects Arrow  
// timeout); the current single-monitor synchronization is correct but worth reconsidering then.  
 * <p><b>Thread safety:</b> {@link #feed} may be called concurrently from
    private final long maxRows;
 */  
public class RowProducingSink implements ExchangeSink, ExchangeSource {
 *
    private boolean closed;
     * @param column   the column name  
        for (VectorSchemaRoot batch : batches) {  
    @Override
     * each batch close is guarded individually rather than letting the first
    private final List<String> fieldNames = new ArrayList<>();  
        // every batch after it, stranding their off-heap buffers on the (long-lived, when  
            batch.close();  
 * {@code fieldNames} initialization. This matches the pattern used by  
    static final long DEFAULT_MAX_ROWS = 10_000L;  
     * Releases any batches still buffered in the sink. Idempotent and tolerant
/**
     */
            }  
 *
     * <p>TODO: make configurable via cluster setting.
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.analytics.exec;
import org.apache.arrow.vector.types.pojo.Field;
        this(DEFAULT_MAX_ROWS);
            }
     * in the core search path, but set higher for analytics workloads.

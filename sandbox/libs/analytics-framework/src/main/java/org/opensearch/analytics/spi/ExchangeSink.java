     */
 * Write-only interface for feeding Arrow batches into a stage exchange.
     * child vectors — so the caller still owns {@code batch} in full and is responsible for closing
 */
 * <p>Implementations must be thread-safe — multiple shard response handlers  
 *
     * <p>Default implementation drops the ordinal and falls through to  
    void close();
     * batch and is responsible for releasing it when no longer needed.  
     * safely {@code batch.close()} without risking a double-release. (Callers such as
     * {@link #feed(VectorSchemaRoot)}. Sinks that need to discriminate
     * early. Default {@code false}; best-effort — a {@code true} is monotonic, a {@code false} may  
     *
     *
    /**  
        feed(batch);  
 * SPDX-License-Identifier: Apache-2.0
    /**  
     * throw must either complete the transfer or roll it back before propagating, so the caller can  
/*  
     * batches by producer (e.g. Late Materialization, where the ordinal is
 * <p>Implementations are backend-specific and created via {@link ExchangeSinkProvider}.
package org.opensearch.analytics.spi;
     * {@code ShardExecutionTarget.ordinal()}).
     * Signal that no more batches will be fed. Releases resources.
    default void feed(VectorSchemaRoot batch, int sourceOrdinal) {
 * over the batches it receives.
     */  
    void feed(VectorSchemaRoot batch);
     * Ingest an Arrow batch into this sink. On normal return the sink has taken ownership of the
 * may call {@link #feed} concurrently.
}
     * producer task within its stage's resolved target list (e.g.
     * Ingest an Arrow batch with a per-source ordinal — the index of the
 * Producers (shard scan stages, local compute stages) call {@link #feed}
     * Whether the downstream consumer has finished and will read no more batches (e.g. a reduce
     * {@link org.opensearch.analytics.spi.ExchangeSink} consumed via  
 * A coordinator-side sink runs the root stage computation (final aggregate, sort, etc.)  
import org.apache.arrow.vector.VectorSchemaRoot;
     * race a concurrent completion.
     * producers without one continue to call {@link #feed(VectorSchemaRoot)}.  
    }
    /**
 *
 * The OpenSearch Contributors require contributions made to  
     */  
/**  
public interface ExchangeSink {
     * <p><b>All-or-nothing ownership.</b> Ownership transfers only on normal return. If this method
        return false;
     * it exactly once. Implementations that begin consuming/transferring buffers before they might
     */
 * compatible open source license.
 * to push data; they never read from the sink.  
     * stamped onto each batch as a column) override this method.  
     * <p>Producers that have a meaningful per-task ordinal call this overload;
     *
     * throws, it must NOT have taken ownership of {@code batch} — neither the root nor any of its  
 *
     * {@code Stitcher.finish} rely on this to free the batch on the feed-throws path.)
    /**
 * this file be licensed under the Apache-2.0 license or a
 *
    }
    default boolean isConsumerDone() {  
     * whose LimitExec satisfied its fetch). Producers may poll this after a {@link #feed} to stop
 * @opensearch.internal  
 */  

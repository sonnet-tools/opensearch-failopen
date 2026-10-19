     * and the caller must invoke {@link Writer#rollbackTo(long)} to reconcile the writer.
     * are valid on the writer.
     * <p>Engine action: release back to the pool; subsequent {@code addDoc} calls are allowed.
 * rollback to decide whether the writer can keep accepting docs, must be retired with
    ACTIVE,
    /**
package org.opensearch.index.engine.dataformat;
 * throw {@code IllegalStateException}):  
     *  
    /**  
}
 * compatible open source license.
     * or {@link #RETIRED_FLUSHABLE} (counters can't reverse, e.g. Lucene).
 * <p>None of these states fail the shard — the engine only fails on tragic events  
 * (corruption, translog/committer exceptions) via {@code failEngine}, independent of
 *   ACTIVE ──────────addDoc(success)─────────▶ ACTIVE
 *   ACTIVE ──────────addDoc(Failure)─────────▶ PENDING_ROLLBACK  
@ExperimentalApi  
import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.experimental
 * The OpenSearch Contributors require contributions made to  
     */  
 *
 * SPDX-License-Identifier: Apache-2.0
 *
     * Writer is accepting new documents.  
    /**
public enum WriterState {
     * rollback, where the docId allocator advances even when the doc is undone.
 */  
 * <p>Allowed transitions (every other transition is a contract violation and must
     */  
 * Lifecycle state of a {@link Writer}. Inspected by the engine after every write or
     * segment in {@code pendingSegments} for the next refresh, then close the writer.
 * </pre>
/**  
    /**  
 * this file be licensed under the Apache-2.0 license or a
    RETIRED_FLUSHABLE,
     *
     * flushing before close. Reached after a successful {@code rollbackTo} on a  
 *   RETIRED_FLUSHABLE ─flush+close (engine)──▶ CLOSED
     * Post-rollback the writer transitions to {@link #ACTIVE} (fully reversible, e.g. Parquet)  
 *
     * Writer's last {@code addDoc} returned a {@link org.opensearch.index.engine.dataformat.WriteResult.Failure}
 *   ACTIVE ──────────rollbackTo (sibling)────▶ ACTIVE             (fully reversible, e.g. Parquet)
     */
 * <pre>
     */  
     * writer whose counters cannot be reversed — e.g., Lucene's soft-delete-based
    CLOSED
 *   any state ────close (engine teardown)────▶ CLOSED  
 */
     * Terminal state set after the engine has closed the writer. No further operations
 * {@code WriterState}.
    PENDING_ROLLBACK,  
 *   PENDING_ROLLBACK ─rollbackTo─────────────▶ RETIRED_FLUSHABLE  (counters can't reverse)
 *   PENDING_ROLLBACK ─rollbackTo─────────────▶ ACTIVE             (fully reversible)  
     * Writer can no longer accept documents but holds N-1 consistent docs worth
 *   ACTIVE ──────────rollbackTo (sibling)────▶ RETIRED_FLUSHABLE  (counters can't reverse, e.g. Lucene)
/*  
     * <p>Engine action: checkout from pool, call {@code flush}, queue the resulting
 * a final flush, or must be discarded.  
 *  

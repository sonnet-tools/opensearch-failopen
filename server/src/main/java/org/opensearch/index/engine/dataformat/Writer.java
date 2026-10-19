     *       is a no-op — nothing was admitted past the target. State is unchanged.</li>  
 */  
    boolean isSchemaMutable();
     * Buffers a row-id delete for application during flush.  
     * <p>
     * @return true if the schema is mutable  
     * the writer in an unknown state; the engine is expected to fail the shard so recovery  
    void updateMappingVersion(long newVersion);  
     * @param d the document input  
     *  
    /**
}
        throw new UnsupportedOperationException("recordPositionalDelete is not supported by this writer");
     * sets its {@link #state()} to {@link WriterState#PENDING_ROLLBACK} to signal the caller that
     * Adds a document to the writer.  
import java.io.Closeable;  
     * Rolls the writer back so it holds exactly {@code rowCount} admitted documents.
    long mappingVersion();  
     * Per-document failures (e.g., schema mismatches, partial Lucene IndexWriter advance)
    /**
     * @param formatName the name of the data format to look up
     * @return {@link WriteResult.Success} on accept, {@link WriteResult.Failure} on per-doc rejection
     */
     * The current mapping version this writer is associated with.
     * row count cannot participate in {@code CompositeWriter}'s cross-format atomicity
     */  
     *       the writer cannot synthesize the missing rows — throw {@link IllegalStateException}.</li>
    /**
import org.opensearch.common.annotation.ExperimentalApi;
     * reserved for unexpected errors (corrupted state, unrecoverable I/O); the engine  
     *
     * {@link UnsupportedOperationException} because a writer that cannot reach a target
     * <p>  
     *   <li>If the writer's current accepted count is <b>greater</b> than {@code rowCount},
     * Formats that handle schema evolution natively (e.g., Lucene) can always return true.
package org.opensearch.index.engine.dataformat;
     *  
 * SPDX-License-Identifier: Apache-2.0
    WriteResult addDoc(P d) throws IOException;
     *
    WriterState state();  
public interface Writer<P extends DocumentInput<?>> extends Closeable {  
     * <p>Implementations must override this method — the default raises  
     * @return the generation number
 * The OpenSearch Contributors require contributions made to  
     *       counters cannot be reversed (e.g., Lucene's docId allocator) transition to
     * Flushes the writer and returns file information.
/*  
     * @throws IOException if the rollback fails  
     * Returns the underlying writer for the specified data format name.  
     * Update the mapping version on a writer. Implementations must ignore  
 * this file be licensed under the Apache-2.0 license or a
     *
 */
     */  
     *  
     * Implementations must track and expose state honestly: returning a stale
@ExperimentalApi
    /**
        throw new UnsupportedOperationException("rollbackTo must be implemented by " + getClass().getName());
/**
     * should be returned to the pool, retired with a flush, or retired without a flush.
    }  
     *
    /**
     *         it has accepted fewer than {@code rowCount} docs, or its current state forbids rollback)
    /**
    default Optional<Writer<?>> getWriterForFormat(String formatName) {
     * @return the file information after flush
     * @param rowId insertion row id within this writer generation
     *  
     *  
 *  
 *
     * <p>A rollback that throws {@link IOException} or {@link IllegalStateException} leaves
     * <ul>
     * Returns this writer's current lifecycle state. The engine inspects {@code state()}  
     * @return an optional containing the writer for the given format, or empty if not found
     *   <li>If the writer's current accepted count is <b>less</b> than {@code rowCount},
        return Optional.empty();
 * compatible open source license.
     * Simple writers return themselves if the format matches.
     *
     *       row-count decrement) stay in {@link WriterState#ACTIVE}; writers whose internal  
     *
 * Interface for writing documents to a data format.
     * Composite writers override this to return the format-specific delegate.
     * The caller declares the target; the writer either reaches it or throws.
     * The generation number associated with this writer
    default void recordPositionalDelete(long rowId) {
 * @param <P> the type of document input
     * @param flushInput optional context for the flush operation  
     */  
     */  
    /**  
     * @throws IOException for unexpected, fatal I/O errors only
     * replays the translog.
    long generation();
import java.util.Optional;
     */  
    /**  
     */
     * @param rowCount the desired number of admitted documents after this call
     * {@link WriterState#ACTIVE} after a failure would leave a poisoned writer in the pool.
    /**
     *       more {@code addDoc} calls are allowed.</li>  
     * Whether this writer's schema can still evolve.  
     * @throws IllegalStateException if the writer cannot reach {@code rowCount} (e.g.,
     * {@link #rollbackTo(long)} must be invoked before any further writes. Throws are
    }  
     * @return the current state
     * </ul>  
 * @opensearch.experimental  
     * @throws IOException if an I/O error occurs
     * treats those as fatal and fails the shard.
     * the call if {@code newVersion} is less than or equal to the current version
     * protocol.  
 *
     * @param newVersion the new mapping version
     */
     *       the surplus docs must be undone. Fully reversible writers (e.g., Parquet's
import java.io.IOException;
     * must be returned as a {@link WriteResult.Failure} rather than thrown. The writer  
    }  
     *
     *       {@link WriterState#RETIRED_FLUSHABLE} — buffered docs remain flushable but no
     * (i.e., mapping version must only move forward).
     * after every {@link #addDoc} or {@link #rollbackTo(long)} to decide whether the writer
     */
    default void rollbackTo(long rowCount) throws IOException {
    /**  
     * @return the mapping version
    FileInfos flush(FlushInput flushInput) throws IOException;
     *   <li>If the writer's current accepted count <b>equals</b> {@code rowCount}, this
     */  

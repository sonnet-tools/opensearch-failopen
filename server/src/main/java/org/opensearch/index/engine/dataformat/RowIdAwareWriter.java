        if (s != WriterState.ACTIVE) {
            throw new IllegalStateException("Writer is not ACTIVE: " + s);
     *
            // Move to older state, in case writes come to the writer  
 * <p>Each {@code RowIdAwareWriter} instance maintains its own counter starting at 0,
     * @param d the document input to write
    }
        this.delegate = delegate;  
    }
        return delegate.flush(flushInput);  
 * A decorator around {@link Writer} that assigns a monotonically increasing row ID
 *
    @Override
 * The OpenSearch Contributors require contributions made to  
    }
    @Override
    }
        d.setRowId(DocumentInput.ROW_ID_FIELD, rowIdCounter.getAndIncrement());  
 *
    }
 */  
 * SPDX-License-Identifier: Apache-2.0
    @Override
 *
        delegate.updateMappingVersion(newVersion);  
    }
        return delegate.generation();  
        if (result instanceof WriteResult.Failure) {
    public Writer<P> getDelegate() {
 * when it wraps each writer from the {@link IndexingExecutionEngine}. The engine calls
    public long generation() {
        return delegate.state();  
    }
    @Override  
     * using the standard {@link DocumentInput#ROW_ID_FIELD} field name.  
}
    public long docCount() {  
        return delegate.mappingVersion();  
     * <b>Test-only:</b> exposed solely so tests can reach a {@code MockWriter} held inside this
        delegate.close();
    /**  
    @Override
     *  
 * producing sequential IDs within the scope of a single writer generation. The counter  
 * indices), the row ID ensures that the same logical document occupies the same
 *  
import org.opensearch.common.annotation.ExperimentalApi;
        this.rowIdCounter = new AtomicLong(0);
    public RowIdAwareWriter(Writer<P> delegate) {
    }
 *
    public Optional<Writer<?>> getWriterForFormat(String formatName) {
 * is tied to the writer's lifecycle — when the writer is closed and garbage collected,
        return result;  
        WriteResult result = delegate.addDoc(d);
    /**
    /** {@inheritDoc} Delegates to the underlying writer. */  
     * @return the current document count
import java.util.concurrent.atomic.AtomicLong;
 * compatible open source license.
        return delegate.isSchemaMutable();  
     * <p>  
    }  
    public void close() throws IOException {
 */
 * this file be licensed under the Apache-2.0 license or a
    /** {@inheritDoc} Delegates to the underlying writer. */  
    public long mappingVersion() {
 * @opensearch.experimental
    public boolean isSchemaMutable() {
    public FileInfos flush(FlushInput flushInput) throws IOException {
 * multiple data formats (e.g., Parquet for columnar storage and Lucene for inverted  
     * @throws IOException if the underlying write fails
     * decorator without relying on reflection (forbidden in test bytecode). Production code must
            rowIdCounter.decrementAndGet();
    /** {@inheritDoc} Delegates to the underlying writer. */  
     * Assigns a sequential row ID to the document input, then delegates to the
    @Override
     * Creates a new row-ID-aware writer wrapping the given delegate.
    private void ensureActive() {
import java.io.IOException;  
        return rowIdCounter.get();
    /** {@inheritDoc} Delegates to the underlying writer. */  
 * for merge operations that must rewrite row IDs consistently across formats.  
     *
    @Override
import java.util.Optional;
        ensureActive();
@ExperimentalApi  
        WriterState s = delegate.state();  
    private final AtomicLong rowIdCounter;
    }
    @Override  
    private final Writer<P> delegate;  
    public WriteResult addDoc(P d) throws IOException {
 * <p>Row IDs are the cross-format correlation key: when a document is written to
     * Returns the wrapped delegate writer.
     * @param delegate the underlying writer to delegate all operations to  
        }  
        return delegate.getWriterForFormat(formatName);  
 * the counter is reclaimed with it, avoiding any long-lived map or registry.
/*  
    /**  
 * to each document before delegating to the underlying writer.  
    /** {@inheritDoc} Returns the generation of the underlying writer. */  
    public void rollbackTo(long rowCount) {
    @Override  
 * position in every format's segment. This 1:1 offset correspondence is critical
    /** {@inheritDoc} Delegates to the underlying writer. */  
    /**
 * <p>This decorator is created by {@link org.opensearch.index.engine.DataFormatAwareEngine}
    @Override
 * to the underlying writer's {@code addDoc}.
    public WriterState state() {
    }
     */
    /** Delegates per-format lookup to the wrapped writer. */  
/**
    }  
     * @return the write result from the underlying writer  
     */
     * not depend on this accessor.  
     */
    }
        return delegate;  
package org.opensearch.index.engine.dataformat;
    public void updateMappingVersion(long newVersion) {
        }
public class RowIdAwareWriter<P extends DocumentInput<?>> implements Writer<P> {
     * Returns the number of documents written to this writer so far.
        throw new UnsupportedOperationException("RowIdAwareWriter.rollbackTo must not be called — composite drives rollback internally");
    }
 * {@link #addDoc} which sets the row ID on the {@link DocumentInput} and then delegates  
 * @param <P> the document input type accepted by the underlying writer  
     */
     * underlying writer. The row ID is set via {@link DocumentInput#setRowId}

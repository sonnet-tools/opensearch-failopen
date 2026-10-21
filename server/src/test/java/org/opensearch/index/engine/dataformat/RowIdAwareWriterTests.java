        Writer<DocumentInput<?>> delegate = mock(Writer.class);
        Writer<DocumentInput<?>> delegate = activeDelegate();
        Writer<DocumentInput<?>> delegate = mock(Writer.class);
/*
            org.mockito.Mockito.doAnswer(inv -> {
    }
        when(delegate.addDoc(input)).thenReturn(new WriteResult.Success(1L, 1L, 1L));
    }
        expectThrows(IllegalStateException.class, () -> writer.addDoc(input));
            assertEquals("rowId at position " + i + " must equal " + i, (long) i, observed[i]);
    }
        Writer<DocumentInput<?>> delegate = activeDelegate();
import static org.mockito.Mockito.verify;
        FileInfos expected = FileInfos.empty();
     */
    }
    }
    public void testRowIdMonotonicityAcrossManyDocs() throws IOException {
                return null;
        when(delegate.getWriterForFormat("test")).thenReturn(Optional.<Writer<?>>of(formatWriter));
    @SuppressWarnings("unchecked")
        assertSame(formatWriter, writer.getWriterForFormat("test").orElse(null));
        assertFalse(writer.getWriterForFormat("other").isPresent());
        verify(input).setRowId(DocumentInput.ROW_ID_FIELD, 2L);
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
import static org.mockito.Mockito.mock;
        Writer<DocumentInput<?>> delegate = activeDelegate();
package org.opensearch.index.engine.dataformat;
public class RowIdAwareWriterTests extends OpenSearchTestCase {
        when(delegate.addDoc(org.mockito.ArgumentMatchers.any())).thenReturn(new WriteResult.Success(1L, 1L, 0L));
    @SuppressWarnings("unchecked")
        when(delegate.flush(FlushInput.EMPTY)).thenReturn(expected);
     * now a runtime check per review feedback).
        verify(delegate).close();
        writer.addDoc(input);
        // delete engine's Lucene lookup.
     * Cross-doc rowId monotonicity: across many addDoc calls (all successful), the
     * The consumed rowId must be returned so the next addDoc reuses it — otherwise we
        long[] observed = new long[100];
    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
        writer.addDoc(input);
    // ==============================================================================
        FileInfos result = writer.flush(flushInput);
        assertEquals(expected, result);
    public void testGetWriterForFormatDelegates() {
        verify(delegate).flush(FlushInput.EMPTY);
        verify(delegate).flush(flushInput);
        // The decorator must hand out the wrapped writer's per-format delegate, not answer empty:
/**
     * leave a permanent gap in the rowId sequence.
    }
        assertEquals(1L, writer.docCount());
    }
 * compatible open source license.
    }
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
    public void testAddDocSetsRowIdInOrder() throws IOException {
    /**
    @SuppressWarnings("unchecked")
        Writer<DocumentInput<?>> delegate = mock(Writer.class);
        DocumentInput<?> input = mock(DocumentInput.class);
            writer.addDoc(input);
        Writer<DocumentInput<?>> delegate = mock(Writer.class);
        when(delegate.generation()).thenReturn(42L);
        FileInfos result = writer.flush(FlushInput.EMPTY);
    private static Writer<DocumentInput<?>> activeDelegate() {
    public void testCloseDelegates() throws IOException {
        assertEquals(42L, writer.generation());
    }
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
}
        return delegate;
        DocumentInput<?> input = mock(DocumentInput.class);
        for (int i = 0; i < 100; i++) {
        verify(input).setRowId(DocumentInput.ROW_ID_FIELD, 0L);
import java.io.IOException;
        DocumentInput<?> input = mock(DocumentInput.class);
     * Parquet-style: leaf throws but recovers (rolls back internally) and stays ACTIVE.
            DocumentInput<?> input = mock(DocumentInput.class);
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
    /**
        writer.addDoc(input);
        Writer<DocumentInput<?>> delegate = mock(Writer.class);
import org.opensearch.test.OpenSearchTestCase;
    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
     * sequence of rowIds set on inputs must be 0, 1, 2, ... contiguous and ordered.
        Writer<DocumentInput<?>> delegate = activeDelegate();
    @SuppressWarnings("unchecked")
        }
    public void testRollbackOnRetiredWriterThrowsRuntime() {
    @SuppressWarnings("unchecked")
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
    public void testDocCountIncrementsOnAddDoc() throws IOException {
        Writer<DocumentInput<?>> delegate = activeDelegate();
        Writer<DocumentInput<?>> delegate = mock(Writer.class);
        when(delegate.state()).thenReturn(WriterState.RETIRED_FLUSHABLE);
    /**
            }).when(input).setRowId(org.mockito.ArgumentMatchers.eq(DocumentInput.ROW_ID_FIELD), org.mockito.ArgumentMatchers.anyLong());
    // Failure handling: rowId counter behavior under different leaf failure modes
    }
import java.util.Optional;
        for (int i = 0; i < 100; i++) {
        verify(input).setRowId(DocumentInput.ROW_ID_FIELD, 1L);
        when(delegate.state()).thenReturn(WriterState.RETIRED_FLUSHABLE);
     */
    }
        FileInfos expected = FileInfos.empty();
 * Tests for {@link RowIdAwareWriter}.
 * this file be licensed under the Apache-2.0 license or a
    @SuppressWarnings("unchecked")
import static org.mockito.Mockito.when;
        expectThrows(UnsupportedOperationException.class, () -> writer.rollbackTo(0));
    public void testDocCountStartsAtZero() {
        writer.addDoc(input);
 */
    public void testFlushWithRowIdMapping() throws IOException {
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
        FlushInput flushInput = new FlushInput(mapping);
        assertEquals(2L, writer.docCount());
        when(delegate.addDoc(input)).thenReturn(new WriteResult.Success(1L, 1L, 0L));
     * Direct invariant: ensureActive() throws on a non-ACTIVE delegate (was an assert,
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
        when(delegate.flush(flushInput)).thenReturn(expected);
        when(delegate.addDoc(input)).thenReturn(new WriteResult.Success(1L, 1L, 0L));
     */
    }
    // ==============================================================================
        Writer<DocumentInput<?>> formatWriter = mock(Writer.class);
    public void testGenerationDelegates() {
        Writer<DocumentInput<?>> delegate = activeDelegate();
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
 */
    public void testFlushDelegatesToUnderlying() throws IOException {
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
        writer.addDoc(input);
 *
        assertEquals(0L, writer.docCount());
    public void testAddDocOnRetiredWriterThrowsRuntime() {
        // every pooled writer is wrapped in one, so answering empty would silently disable the
        assertEquals(expected, result);
        when(delegate.state()).thenReturn(WriterState.ACTIVE);
        }
        writer.close();
            final int idx = i;
                observed[idx] = inv.getArgument(1);
        RowIdMapping mapping = new PackedRowIdMapping(new long[] { 1, 0 }, true);

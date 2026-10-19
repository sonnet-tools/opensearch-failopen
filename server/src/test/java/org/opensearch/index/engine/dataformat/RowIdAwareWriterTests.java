    }
    }
 * Tests for {@link RowIdAwareWriter}.
    // ==============================================================================  
        Writer<DocumentInput<?>> delegate = mock(Writer.class);  
    @SuppressWarnings("unchecked")
/**
        for (int i = 0; i < 100; i++) {  
        Writer<DocumentInput<?>> formatWriter = mock(Writer.class);  
    @SuppressWarnings("unchecked")  
        Writer<DocumentInput<?>> delegate = mock(Writer.class);
            assertEquals("rowId at position " + i + " must equal " + i, (long) i, observed[i]);
                observed[idx] = inv.getArgument(1);
        DocumentInput<?> input = mock(DocumentInput.class);
     * Cross-doc rowId monotonicity: across many addDoc calls (all successful), the
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
    public void testDocCountStartsAtZero() {
        FileInfos expected = FileInfos.empty();
    /**
        verify(input).setRowId(DocumentInput.ROW_ID_FIELD, 2L);
    public void testRowIdMonotonicityAcrossManyDocs() throws IOException {  
        long[] observed = new long[100];
    @SuppressWarnings("unchecked")  
import static org.mockito.Mockito.verify;
    }
    public void testGetWriterForFormatDelegates() {
        assertEquals(1L, writer.docCount());  
        expectThrows(UnsupportedOperationException.class, () -> writer.rollbackTo(0));
    @SuppressWarnings("unchecked")
        Writer<DocumentInput<?>> delegate = activeDelegate();  
        // The decorator must hand out the wrapped writer's per-format delegate, not answer empty:
        assertEquals(0L, writer.docCount());
        writer.close();  
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
    }  
        Writer<DocumentInput<?>> delegate = activeDelegate();
        when(delegate.addDoc(input)).thenReturn(new WriteResult.Success(1L, 1L, 1L));
            org.mockito.Mockito.doAnswer(inv -> {  
        when(delegate.flush(FlushInput.EMPTY)).thenReturn(expected);  
        FileInfos result = writer.flush(flushInput);  
    public void testAddDocSetsRowIdInOrder() throws IOException {
        FileInfos expected = FileInfos.empty();
package org.opensearch.index.engine.dataformat;
        writer.addDoc(input);
        Writer<DocumentInput<?>> delegate = mock(Writer.class);
    }  
import java.io.IOException;  
        }
            final int idx = i;
    public void testFlushWithRowIdMapping() throws IOException {
    }
        when(delegate.generation()).thenReturn(42L);  
        Writer<DocumentInput<?>> delegate = activeDelegate();  
        return delegate;
import static org.mockito.Mockito.when;
    @SuppressWarnings("unchecked")
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
    @SuppressWarnings("unchecked")
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
        when(delegate.state()).thenReturn(WriterState.ACTIVE);  
import static org.mockito.Mockito.mock;  
    /**
            }).when(input).setRowId(org.mockito.ArgumentMatchers.eq(DocumentInput.ROW_ID_FIELD), org.mockito.ArgumentMatchers.anyLong());  
        assertSame(formatWriter, writer.getWriterForFormat("test").orElse(null));
     * Parquet-style: leaf throws but recovers (rolls back internally) and stays ACTIVE.  
    private static Writer<DocumentInput<?>> activeDelegate() {
            DocumentInput<?> input = mock(DocumentInput.class);
        RowIdMapping mapping = new PackedRowIdMapping(new long[] { 1, 0 }, true);  
     * Direct invariant: ensureActive() throws on a non-ACTIVE delegate (was an assert,
    @SuppressWarnings("unchecked")  
    public void testDocCountIncrementsOnAddDoc() throws IOException {
        writer.addDoc(input);
        for (int i = 0; i < 100; i++) {
        assertEquals(expected, result);
        verify(input).setRowId(DocumentInput.ROW_ID_FIELD, 1L);
     * now a runtime check per review feedback).
 */  
        DocumentInput<?> input = mock(DocumentInput.class);
        when(delegate.addDoc(input)).thenReturn(new WriteResult.Success(1L, 1L, 0L));
    public void testFlushDelegatesToUnderlying() throws IOException {  
        verify(delegate).flush(flushInput);  
    // Failure handling: rowId counter behavior under different leaf failure modes
    }
    @SuppressWarnings("unchecked")
        writer.addDoc(input);  
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
        when(delegate.flush(flushInput)).thenReturn(expected);  
     */  
        verify(input).setRowId(DocumentInput.ROW_ID_FIELD, 0L);  
        // every pooled writer is wrapped in one, so answering empty would silently disable the
 * SPDX-License-Identifier: Apache-2.0
     */  
        verify(delegate).flush(FlushInput.EMPTY);  
}
        Writer<DocumentInput<?>> delegate = mock(Writer.class);
    public void testAddDocOnRetiredWriterThrowsRuntime() {
    /**  
 *
     * The consumed rowId must be returned so the next addDoc reuses it — otherwise we
    public void testRollbackOnRetiredWriterThrowsRuntime() {  
        FlushInput flushInput = new FlushInput(mapping);
        verify(delegate).close();
/*  
        writer.addDoc(input);  
        assertEquals(expected, result);
public class RowIdAwareWriterTests extends OpenSearchTestCase {
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);  
        when(delegate.state()).thenReturn(WriterState.RETIRED_FLUSHABLE);
        }  
    public void testCloseDelegates() throws IOException {  
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
        Writer<DocumentInput<?>> delegate = mock(Writer.class);
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        Writer<DocumentInput<?>> delegate = activeDelegate();
        assertFalse(writer.getWriterForFormat("other").isPresent());
            writer.addDoc(input);
    }
        Writer<DocumentInput<?>> delegate = activeDelegate();
        FileInfos result = writer.flush(FlushInput.EMPTY);  
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
 */  
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
        writer.addDoc(input);
        DocumentInput<?> input = mock(DocumentInput.class);
    @SuppressWarnings("unchecked")
 * The OpenSearch Contributors require contributions made to  
    }
        when(delegate.getWriterForFormat("test")).thenReturn(Optional.<Writer<?>>of(formatWriter));
        expectThrows(IllegalStateException.class, () -> writer.addDoc(input));
    @SuppressWarnings("unchecked")  
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
        when(delegate.addDoc(org.mockito.ArgumentMatchers.any())).thenReturn(new WriteResult.Success(1L, 1L, 0L));
    }
import org.opensearch.test.OpenSearchTestCase;
                return null;
        when(delegate.addDoc(input)).thenReturn(new WriteResult.Success(1L, 1L, 0L));
    public void testGenerationDelegates() {
        assertEquals(2L, writer.docCount());
        assertEquals(42L, writer.generation());  
        RowIdAwareWriter<DocumentInput<?>> writer = new RowIdAwareWriter<>(delegate);
     * leave a permanent gap in the rowId sequence.
    }  
     * sequence of rowIds set on inputs must be 0, 1, 2, ... contiguous and ordered.  
    @SuppressWarnings("unchecked")
     */
    }  
        Writer<DocumentInput<?>> delegate = activeDelegate();
        Writer<DocumentInput<?>> delegate = mock(Writer.class);
        // delete engine's Lucene lookup.  
import java.util.Optional;
        when(delegate.state()).thenReturn(WriterState.RETIRED_FLUSHABLE);
    // ==============================================================================

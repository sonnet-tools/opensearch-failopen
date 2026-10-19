    /**
        assertEquals(2L, receivedMapping.getNewRowId(0, RowIdMapping.SINGLE_GEN));
        public void updateMappingVersion(long newVersion) {}
        public org.opensearch.index.engine.dataformat.WriterState state() {
        RecordingWriter primaryWriter = new RecordingWriter(primaryFormat, null);
        assertTrue("FlushInput should have row ID mapping", secondaryWriter.lastFlushInput.hasRowIdMapping());
                for (int i = 0; i < rawPermutation[0].length; i++) {
import java.io.IOException;
        // The composite FileInfos should also carry the sort permutation
        assertNotNull(secondaryWriter.lastFlushInput);
            return 0;
            primaryWriter,
import org.opensearch.index.engine.dataformat.WriteResult;
                builder.rowIdMapping(rowIdMappingToReturn);
            return builder.build();
        // The secondary writer should have received the sort permutation
            secondaryFormat,
    }
        DataFormat primaryFormat = mockFormat("parquet");
import org.opensearch.index.engine.dataformat.FlushInput;
            FileInfos.Builder builder = FileInfos.builder();
            primaryFormat,
                    oldToNew[(int) rawPermutation[0][i]] = rawPermutation[1][i];
    /**
public class CompositeWriterSortPropagationTests extends OpenSearchTestCase {
            }
        compositeWriter.close();
        compositeWriter.flush(FlushInput.EMPTY);
        RecordingWriter secondaryWriter = new RecordingWriter(secondaryFormat, null);
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngineWithWriters(
            secondaryWriter
import org.opensearch.index.engine.dataformat.DataFormat;
        final DataFormat format;
            if (rawPermutation != null && rawPermutation.length == 2 && rawPermutation[0].length > 0) {
        // Secondary writer that records the FlushInput it receives
import org.opensearch.index.engine.dataformat.RowIdMapping;
 */
        RecordingWriter secondaryWriter = new RecordingWriter(secondaryFormat, null);
 * Tests that CompositeWriter.flush() correctly propagates the sort permutation
     * writer should receive FlushInput.EMPTY.
        RowIdMapping receivedMapping = secondaryWriter.lastFlushInput.rowIdMapping();
                this.rowIdMappingToReturn = new PackedRowIdMapping(oldToNew, true);
 * compatible open source license.
        DataFormat secondaryFormat = mockFormat("lucene");
 */
import org.opensearch.index.engine.dataformat.Writer;
        }
                }
/**
        }
        DataFormat secondaryFormat = mockFormat("lucene");
        assertNotNull("Secondary writer should have received FlushInput", secondaryWriter.lastFlushInput);
        RecordingWriter primaryWriter = new RecordingWriter(primaryFormat, null);
        assertEquals(1L, receivedMapping.getNewRowId(2, RowIdMapping.SINGLE_GEN));
    /**
        @Override
                this.rowIdMappingToReturn = null;
    }
            secondaryFormat,
     */
    public void testSortPermutationPropagatedToSecondary() throws IOException {
                int numDocs = rawPermutation[0].length;
        DataFormat secondaryFormat = mockFormat("lucene");
 * this file be licensed under the Apache-2.0 license or a
        @Override
        DataFormat format = mock(DataFormat.class);
import org.opensearch.index.engine.dataformat.WriterConfig;
            secondaryWriter
                long[] oldToNew = new long[numDocs];
            this.lastFlushInput = flushInput;
    /**
        return format;
            return 0;
        DataFormat primaryFormat = mockFormat("parquet");
import static org.mockito.Mockito.when;
        public FileInfos flush(FlushInput flushInput) {
import org.opensearch.index.engine.dataformat.DocumentInput;
            primaryWriter,
        }
}
        );
        }
        assertFalse("FlushInput should not have row ID mapping", secondaryWriter.lastFlushInput.hasRowIdMapping());
    private DataFormat mockFormat(String name) {
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngineWithWriters(
            return new WriteResult.Success(1, 1, 1);
        compositeWriter.close();
        compositeWriter.close();
        CompositeWriter compositeWriter = new CompositeWriter(engine, new WriterConfig(0));
import org.opensearch.index.engine.dataformat.PackedRowIdMapping;
    }
        // permutation is {0,1,2} -> {2,0,1}: old pos 0 maps to new pos 2
        DataFormat primaryFormat = mockFormat("parquet");
        RecordingWriter secondaryWriter = new RecordingWriter(secondaryFormat, null);
            primaryFormat,
        assertEquals(0L, receivedMapping.getNewRowId(1, RowIdMapping.SINGLE_GEN));
            this.format = format;
        @Override
        long[][] permutation = { { 0, 1, 2 }, { 2, 0, 1 } };
            return org.opensearch.index.engine.dataformat.WriterState.ACTIVE;
        }
     * When the primary writer returns no sort permutation, the secondary
        @Override
        public long generation() {
        @Override
        RecordingWriter(DataFormat format, long[][] rawPermutation) {
 *
import org.opensearch.index.engine.dataformat.FileInfos;
        final RowIdMapping rowIdMappingToReturn;
            secondaryFormat,
            }
                for (int i = 0; i < numDocs; i++) {
        FileInfos result = compositeWriter.flush(FlushInput.EMPTY);
     * to CompositeWriter.flush(), not a modified one.
        );
     * returns a sort permutation in its FileInfos.
        compositeWriter.flush(FlushInput.EMPTY);
     */
 * from the primary writer's FileInfos to the secondary writers via FlushInput.
        assertSame("Primary should receive the original FlushInput", FlushInput.EMPTY, primaryWriter.lastFlushInput);
        public long mappingVersion() {
            secondaryWriter
     * The primary writer should always receive the original FlushInput passed
        }
        @Override
     */
        CompositeWriter compositeWriter = new CompositeWriter(engine, new WriterConfig(0));
     * the secondary writer should receive it via FlushInput.
        }
        @Override
package org.opensearch.composite;
    static class RecordingWriter implements Writer<DocumentInput<?>> {
        when(format.name()).thenReturn(name);
        @Override
        public WriteResult addDoc(DocumentInput<?> d) {
            } else {
 * SPDX-License-Identifier: Apache-2.0
                    oldToNew[i] = i;
        CompositeWriter compositeWriter = new CompositeWriter(engine, new WriterConfig(0));
     */
        assertNotNull(result.rowIdMapping());
import static org.mockito.Mockito.mock;
            primaryFormat,
    }
        when(format.priority()).thenReturn(1L);
            primaryWriter,
 * The OpenSearch Contributors require contributions made to
        RecordingWriter primaryWriter = new RecordingWriter(primaryFormat, permutation);
        assertEquals(3, receivedMapping.size());
        // Primary writer that returns FileInfos with a sort permutation
    public void testPrimaryReceivesOriginalFlushInput() throws IOException {
                }
import org.opensearch.test.OpenSearchTestCase;
     * When the primary writer returns a sort permutation in FileInfos,
    public void testNoSortPermutationPassesEmptyFlushInput() throws IOException {
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngineWithWriters(
            if (rowIdMappingToReturn != null) {
        );
        FlushInput lastFlushInput;
    }
        public boolean isSchemaMutable() {
            return true;
/*
     * A Writer stub that records the FlushInput it receives and optionally
        public void close() {}
        assertNotNull(receivedMapping);

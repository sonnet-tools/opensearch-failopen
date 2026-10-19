        // permutation is {0,1,2} -> {2,0,1}: old pos 0 maps to new pos 2  
        RecordingWriter primaryWriter = new RecordingWriter(primaryFormat, null);
        assertEquals(0L, receivedMapping.getNewRowId(1, RowIdMapping.SINGLE_GEN));
        FlushInput lastFlushInput;  
            if (rowIdMappingToReturn != null) {
        }
        @Override  
        RecordingWriter(DataFormat format, long[][] rawPermutation) {
            }  
        assertTrue("FlushInput should have row ID mapping", secondaryWriter.lastFlushInput.hasRowIdMapping());
     * returns a sort permutation in its FileInfos.
import org.opensearch.index.engine.dataformat.PackedRowIdMapping;
        @Override  
        }  
        DataFormat secondaryFormat = mockFormat("lucene");
                for (int i = 0; i < numDocs; i++) {
 *
    public void testPrimaryReceivesOriginalFlushInput() throws IOException {  
                }  
        RowIdMapping receivedMapping = secondaryWriter.lastFlushInput.rowIdMapping();  
        DataFormat secondaryFormat = mockFormat("lucene");
            primaryWriter,  
        RecordingWriter secondaryWriter = new RecordingWriter(secondaryFormat, null);
    /**
    public void testSortPermutationPropagatedToSecondary() throws IOException {  
import org.opensearch.index.engine.dataformat.DocumentInput;
        DataFormat primaryFormat = mockFormat("parquet");
        }
            secondaryFormat,
        @Override
     */
        assertNotNull("Secondary writer should have received FlushInput", secondaryWriter.lastFlushInput);
        );
            primaryFormat,
        // Primary writer that returns FileInfos with a sort permutation  
        }
    private DataFormat mockFormat(String name) {
     * to CompositeWriter.flush(), not a modified one.
/*  
    /**
}  
     * writer should receive FlushInput.EMPTY.
    }  
            return 0;
     */
        // Secondary writer that records the FlushInput it receives
        @Override
        when(format.name()).thenReturn(name);  
                this.rowIdMappingToReturn = null;  
                long[] oldToNew = new long[numDocs];  
        );  
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngineWithWriters(
import org.opensearch.index.engine.dataformat.FileInfos;  
import org.opensearch.index.engine.dataformat.DataFormat;
        public void close() {}
            secondaryWriter  
    }
 * compatible open source license.
        // The secondary writer should have received the sort permutation  
import org.opensearch.index.engine.dataformat.RowIdMapping;  
            primaryFormat,
        @Override
import org.opensearch.index.engine.dataformat.WriteResult;
        assertFalse("FlushInput should not have row ID mapping", secondaryWriter.lastFlushInput.hasRowIdMapping());  
            secondaryFormat,
        compositeWriter.close();
        public void updateMappingVersion(long newVersion) {}
 * Tests that CompositeWriter.flush() correctly propagates the sort permutation  
    /**
            primaryFormat,  
import org.opensearch.index.engine.dataformat.WriterConfig;  
            return true;
        compositeWriter.close();
        assertNotNull(receivedMapping);
        @Override  
        compositeWriter.flush(FlushInput.EMPTY);  
        RecordingWriter primaryWriter = new RecordingWriter(primaryFormat, permutation);
                    oldToNew[i] = i;
import org.opensearch.index.engine.dataformat.FlushInput;
        }
        public WriteResult addDoc(DocumentInput<?> d) {
            } else {
        @Override
        RecordingWriter secondaryWriter = new RecordingWriter(secondaryFormat, null);  
import org.opensearch.test.OpenSearchTestCase;
    }
        compositeWriter.close();
        DataFormat primaryFormat = mockFormat("parquet");
        compositeWriter.flush(FlushInput.EMPTY);  
    }  
            return builder.build();
     * When the primary writer returns a sort permutation in FileInfos,  
        assertEquals(3, receivedMapping.size());
            this.lastFlushInput = flushInput;
import org.opensearch.index.engine.dataformat.Writer;
        assertSame("Primary should receive the original FlushInput", FlushInput.EMPTY, primaryWriter.lastFlushInput);
    }  
        final RowIdMapping rowIdMappingToReturn;
 * this file be licensed under the Apache-2.0 license or a
            primaryWriter,  
        public FileInfos flush(FlushInput flushInput) {
            return 0;  
            secondaryWriter
     * the secondary writer should receive it via FlushInput.
        DataFormat primaryFormat = mockFormat("parquet");
            }
            if (rawPermutation != null && rawPermutation.length == 2 && rawPermutation[0].length > 0) {
        public boolean isSchemaMutable() {  
        assertEquals(2L, receivedMapping.getNewRowId(0, RowIdMapping.SINGLE_GEN));
    public void testNoSortPermutationPassesEmptyFlushInput() throws IOException {  
        assertNotNull(result.rowIdMapping());  
    /**
            secondaryWriter
        DataFormat secondaryFormat = mockFormat("lucene");
     * A Writer stub that records the FlushInput it receives and optionally  
        RecordingWriter primaryWriter = new RecordingWriter(primaryFormat, null);
        public long mappingVersion() {
        final DataFormat format;
        );  
        public org.opensearch.index.engine.dataformat.WriterState state() {
            FileInfos.Builder builder = FileInfos.builder();  
        }
        assertNotNull(secondaryWriter.lastFlushInput);
import static org.mockito.Mockito.mock;
 * SPDX-License-Identifier: Apache-2.0
 * from the primary writer's FileInfos to the secondary writers via FlushInput.
        assertEquals(1L, receivedMapping.getNewRowId(2, RowIdMapping.SINGLE_GEN));  
        FileInfos result = compositeWriter.flush(FlushInput.EMPTY);
                int numDocs = rawPermutation[0].length;
        CompositeWriter compositeWriter = new CompositeWriter(engine, new WriterConfig(0));
public class CompositeWriterSortPropagationTests extends OpenSearchTestCase {  
                for (int i = 0; i < rawPermutation[0].length; i++) {
     * When the primary writer returns no sort permutation, the secondary  
        }
     */
            primaryWriter,
                builder.rowIdMapping(rowIdMappingToReturn);
        CompositeWriter compositeWriter = new CompositeWriter(engine, new WriterConfig(0));  
                }  
/**
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngineWithWriters(
import static org.mockito.Mockito.when;  
        CompositeWriter compositeWriter = new CompositeWriter(engine, new WriterConfig(0));
     */
import java.io.IOException;  
        when(format.priority()).thenReturn(1L);
        // The composite FileInfos should also carry the sort permutation
 */  
            return org.opensearch.index.engine.dataformat.WriterState.ACTIVE;  
                this.rowIdMappingToReturn = new PackedRowIdMapping(oldToNew, true);
    static class RecordingWriter implements Writer<DocumentInput<?>> {  
        @Override  
        public long generation() {
package org.opensearch.composite;
     * The primary writer should always receive the original FlushInput passed  
            return new WriteResult.Success(1, 1, 1);  
        return format;
            secondaryFormat,
        DataFormat format = mock(DataFormat.class);
        CompositeIndexingExecutionEngine engine = CompositeTestHelper.createStubEngineWithWriters(
 */
 * The OpenSearch Contributors require contributions made to  
            this.format = format;  
        long[][] permutation = { { 0, 1, 2 }, { 2, 0, 1 } };
                    oldToNew[(int) rawPermutation[0][i]] = rawPermutation[1][i];
        RecordingWriter secondaryWriter = new RecordingWriter(secondaryFormat, null);

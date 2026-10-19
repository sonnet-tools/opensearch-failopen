    public void testBuilderWithRowIdMapping() {
        FileInfos empty = FileInfos.empty();  
    public void testGetWriterFileSetMissing() {
    }
        assertTrue(infos.writerFilesMap().isEmpty());
            .addFile("file1.dat")
        assertEquals(2L, infos.rowIdMapping().getNewRowId(0, RowIdMapping.SINGLE_GEN));
        assertTrue(empty.writerFilesMap().isEmpty());
        when(format.name()).thenReturn("test");
        assertNotNull(infos.writerFilesMap());
 *
        FileInfos infos = FileInfos.builder().putWriterFileSet(format, wfs).build();
        DataFormat format = testFormat();  
    }  
            .directory(Path.of("/tmp"))
 */  
import java.nio.file.Path;
import org.opensearch.test.OpenSearchTestCase;
        DataFormat format = testFormat();
 * compatible open source license.
            .build();  
        return format;
    }
    }
 */
public class FileInfosTests extends OpenSearchTestCase {  
 * Tests for {@link FileInfos}.
        FileInfos infos = new FileInfos(java.util.Map.of());
            .addNumRows(3)  
    public void testBuilderWithoutRowIdMapping() {
    }  
/*  
        FileInfos infos = FileInfos.empty();
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(1, infos.writerFilesMap().size());
package org.opensearch.index.engine.dataformat;
    public void testEmptyFileInfos() {
    private DataFormat testFormat() {
            .directory(Path.of("/tmp"))
            .writerGeneration(0)  
import org.opensearch.index.engine.exec.WriterFileSet;
            .build();
        RowIdMapping mapping = new PackedRowIdMapping(new long[] { 2, 0, 1 }, true);
import static org.mockito.Mockito.mock;  
            .addFile("file1.dat")
    }
        assertNull(infos.rowIdMapping());  
        assertFalse(infos.getWriterFileSet(format).isPresent());
        WriterFileSet wfs = WriterFileSet.builder()  
            .addNumRows(10)
 * The OpenSearch Contributors require contributions made to  
        assertNotNull(infos.rowIdMapping());
import static org.mockito.Mockito.when;
            .writerGeneration(0)
}  
        assertNull(empty.rowIdMapping());
        assertNull(infos.rowIdMapping());  
        assertEquals(3, infos.rowIdMapping().size());  
    public void testConstructorWithoutMapping() {
        FileInfos infos = FileInfos.builder().putWriterFileSet(format, wfs).rowIdMapping(mapping).build();  
 * SPDX-License-Identifier: Apache-2.0
        WriterFileSet wfs = WriterFileSet.builder()
        assertTrue(infos.getWriterFileSet(format).isPresent());
/**  
        DataFormat format = mock(DataFormat.class);  
        DataFormat format = testFormat();  

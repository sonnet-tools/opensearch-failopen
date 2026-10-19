        assertEquals(differentDirectory, deserialized.directory());  
 * The OpenSearch Contributors require contributions made to  
            in -> new WriterFileSet(in, directory, DataformatAwareCatalogSnapshot.CURRENT_SERIALIZATION_VERSION)
        Set<String> files = new HashSet<>();  
 * SPDX-License-Identifier: Apache-2.0
        WriterFileSet wfs = new WriterFileSet("/tmp/dir", 1L, Set.of("a.dat"), 0, 0L);  
        assertEquals(original.writerGeneration(), deserialized.writerGeneration());
            original,  
 */  
            in -> new WriterFileSet(in, differentDirectory, DataformatAwareCatalogSnapshot.CURRENT_SERIALIZATION_VERSION)  
    }
        WriterFileSet original = new WriterFileSet("/tmp/dir", 1L, Set.of("a.dat"), 10, 9_010_000L);
 *
    public void testDefaultFormatVersionIsZero() {
        int fileCount = randomIntBetween(1, 5);
        }  
 * compatible open source license.
/**  
import org.opensearch.test.OpenSearchTestCase;  
 * Tests for {@link WriterFileSet}.
    }
        WriterFileSet original = new WriterFileSet(originalDirectory, 1L, Set.of("a.dat"), 10, 0L);
            new NamedWriteableRegistry(Collections.emptyList()),
    }
            original,
import java.util.Collections;
        String directory = "/tmp/" + randomAlphaOfLength(8);
        );  
package org.opensearch.index.engine.exec;
 * this file be licensed under the Apache-2.0 license or a
        WriterFileSet copy = copyWriteable(
    public void testStreamRoundTripPreservesFormatVersion() throws Exception {
        for (int i = 0; i < fileCount; i++) {
        assertNotEquals(originalDirectory, deserialized.directory());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        assertEquals(original, copy);
    }  
        assertEquals(0L, wfs.formatVersion());
        WriterFileSet copy = copyWriteable(  
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
 */
        WriterFileSet deserialized = copyWriteable(  
            original,
        String directory = original.directory();
        );
        assertEquals(9_010_000L, copy.formatVersion());
        WriterFileSet original = randomWriterFileSet();  
        assertEquals(original.files(), deserialized.files());  
        String differentDirectory = "/tmp/different";  
            new NamedWriteableRegistry(Collections.emptyList()),
        assertEquals(original.numRows(), deserialized.numRows());
        );
            files.add(randomAlphaOfLength(6) + "." + randomFrom("cfs", "si", "dat", "parquet"));
public class WriterFileSetTests extends OpenSearchTestCase {  
        return new WriterFileSet(directory, randomNonNegativeLong(), files, randomIntBetween(0, 10000), 0L);
import java.util.HashSet;  
            new NamedWriteableRegistry(Collections.emptyList()),
    }
}  
    public void testCopyWriteable() throws Exception {
    private WriterFileSet randomWriterFileSet() {  
        String originalDirectory = "/tmp/original";
            in -> new WriterFileSet(in, "/tmp/dir", DataformatAwareCatalogSnapshot.CURRENT_SERIALIZATION_VERSION)  
    // --- helpers ---
/*  
import java.util.Set;
    public void testDirectoryNotSerialized() throws Exception {

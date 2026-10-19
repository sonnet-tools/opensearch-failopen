        expectThrows(  
                .offset(0)
    public void testSeekAndRead() throws IOException {
        assertEquals(7, b);
        }
            .context(IOContext.DEFAULT)
 * The OpenSearch Contributors require contributions made to  
                .context(IOContext.DEFAULT)  
        input.close();
            .resourceDescription("test")
 */  
        assertEquals(1024, slice.length());
            .length(TEST_FILE_SIZE)
import org.apache.lucene.store.IOContext;
                int toWrite = (int) Math.min(buffer.length, size - written);
import java.io.OutputStream;  
 *
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
            .blockSizeShift(BLOCK_SIZE_SHIFT)  
            .fileSize(TEST_FILE_SIZE)  
 * this file be licensed under the Apache-2.0 license or a
        BlockIndexInput input = BlockIndexInput.builder()
        directory.close();  
    }
                .fileSize(TEST_FILE_SIZE)  
        input.close();
                written += toWrite;
            .resourceDescription("test")
            .blockSizeShift(BLOCK_SIZE_SHIFT)
    public void testReadByte() throws IOException {
        assertEquals(input.length(), clone.length());
        input.close();
            .build();  
            .build();
        assertTrue(input.length() >= 0);
import org.junit.After;
            .localDirectory(directory)  
            .resourceDescription("test")  
        BlockIndexInput clone = input.clone();  
            .offset(0)
    @Before  
import java.util.Arrays;  
            .length(TEST_FILE_SIZE)
import java.io.IOException;
                .resourceDescription("test")
import org.opensearch.test.OpenSearchTestCase;
    @After
        createBlockFile(BLOCK_FILE_1, TEST_FILE_SIZE - BLOCK_SIZE);
            .fileSize(TEST_FILE_SIZE)
            .localDirectory(directory)
            .context(IOContext.DEFAULT)  
            .resourceDescription("test")  
        assertNotNull(slice);
        tempDir = createTempDir();  
            .offset(0)  
            .name(FILE_NAME)
    public void setUp() throws Exception {
            () -> BlockIndexInput.builder()
    public void testSliceOutOfBounds() throws IOException {
            .name(FILE_NAME)
                .resourceDescription("test")  
            .build();
        BlockIndexInput input = BlockIndexInput.builder()
            long written = 0;  
        for (byte b : buffer) {
            .resourceDescription("test")  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(7, b);
import org.apache.lucene.store.IndexInput;
    private Path tempDir;  
            .fileSize(TEST_FILE_SIZE)
            () -> BlockIndexInput.builder()  
            .blockSizeShift(BLOCK_SIZE_SHIFT)
        BlockIndexInput input = BlockIndexInput.builder()  
            .build();
 * compatible open source license.
    private static final String FILE_NAME = "_1.cfe";
        input.close();
    public void testReadBytes() throws IOException {
        expectThrows(IllegalArgumentException.class, () -> input.slice("bad", 0, TEST_FILE_SIZE + 1));  
        assertNotNull(input);  
    private static final int BLOCK_SIZE_SHIFT = 23; // 8MB blocks  
            .name(FILE_NAME)
            .fileSize(TEST_FILE_SIZE)  
            .build();  
            .length(TEST_FILE_SIZE)  
            .name(FILE_NAME)  
            .offset(0)
        BlockIndexInput input = BlockIndexInput.builder()
    public void testClone() throws IOException {  
            .localDirectory(directory)
                .build()
            .length(TEST_FILE_SIZE)
import org.junit.Before;  
package org.opensearch.storage.indexinput;
/**
            .length(TEST_FILE_SIZE)  
            .length(TEST_FILE_SIZE)
        BlockIndexInput input = BlockIndexInput.builder()  
        try (OutputStream os = Files.newOutputStream(filePath)) {  
        );  
            .offset(0)
    }
            .context(IOContext.DEFAULT)
    private static final long BLOCK_SIZE = 1L << BLOCK_SIZE_SHIFT; // 8MB
    }  
    }  
                .build()
                .fileSize(TEST_FILE_SIZE)
            IllegalStateException.class,
        );
                .length(TEST_FILE_SIZE)
                .blockSizeShift(BLOCK_SIZE_SHIFT)
        clone.close();  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    }  
        byte b = input.readByte();
    public void testBuildBlockIndexInput() throws IOException {  
    private static final String BLOCK_FILE_1 = "_1.cfe_block_1";
    }
            .name(FILE_NAME)
    public void testSlice() throws IOException {
        input.readByte(); // advance position
            .localDirectory(directory)
 * Unit tests for BlockIndexInput.  
    }
        input.close();  
            .offset(0)  
            }
                .name(FILE_NAME)
            .context(IOContext.DEFAULT)
        super.setUp();
            .fileSize(TEST_FILE_SIZE)  
            while (written < size) {
            .build();
    }
            assertEquals(7, b);  
                os.write(buffer, 0, toWrite);  
        BlockIndexInput input = BlockIndexInput.builder()
        byte[] buffer = new byte[100];  
            .blockSizeShift(BLOCK_SIZE_SHIFT)
        assertEquals(100, input.getFilePointer());
import java.nio.file.Files;
            .length(TEST_FILE_SIZE)
            .resourceDescription("test")
import org.apache.lucene.store.FSDirectory;  
public class BlockIndexInputTests extends OpenSearchTestCase {  
            .localDirectory(directory)
                .context(IOContext.DEFAULT)
            .context(IOContext.DEFAULT)
import java.nio.file.Path;
        createBlockFile(BLOCK_FILE_0, BLOCK_SIZE);  
        expectThrows(
            .blockSizeShift(BLOCK_SIZE_SHIFT)
            .resourceDescription("test")  
            byte[] buffer = new byte[8192];
            .blockSizeShift(BLOCK_SIZE_SHIFT)
        IndexInput slice = input.slice("test-slice", 0, 1024);  
        super.tearDown();
    public void tearDown() throws Exception {
            .context(IOContext.DEFAULT)
}
        }  
            .localDirectory(directory)  
            .name(FILE_NAME)
    }
                .localDirectory(directory)
        input.close();
        directory = FSDirectory.open(tempDir);
                .blockSizeShift(BLOCK_SIZE_SHIFT)  
            Arrays.fill(buffer, (byte) 7);
            .blockSizeShift(BLOCK_SIZE_SHIFT)
        input.seek(100);
            .build();
                .offset(0)  
        Path filePath = tempDir.resolve(name);
            IllegalStateException.class,
 */
            .context(IOContext.DEFAULT)
            .offset(0)  
        slice.close();  
    public void testBuilderValidation() {
        // Missing directory
            .fileSize(TEST_FILE_SIZE)  
                .length(TEST_FILE_SIZE)
            .offset(0)  
        input.readBytes(buffer, 0, 100);
        // Create block files with test data
    }  
            .resourceDescription("test")
            .name(FILE_NAME)
        // Missing file name  
    }
/*  
        assertNotNull(clone);
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;  
    private static final long TEST_FILE_SIZE = 10_485_760L; // 10MB
            .fileSize(TEST_FILE_SIZE)
    private FSDirectory directory;
            .localDirectory(directory)
        input.close();
    private static final String BLOCK_FILE_0 = "_1.cfe_block_0";  
        byte b = input.readByte();  
    private void createBlockFile(String name, long size) throws IOException {
        BlockIndexInput input = BlockIndexInput.builder()

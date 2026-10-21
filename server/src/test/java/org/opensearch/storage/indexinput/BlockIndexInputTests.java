import org.opensearch.test.OpenSearchTestCase;
    public void tearDown() throws Exception {
        BlockIndexInput input = BlockIndexInput.builder()
            .build();
        byte[] buffer = new byte[100];
    private static final String BLOCK_FILE_0 = "_1.cfe_block_0";
                .fileSize(TEST_FILE_SIZE)
            .blockSizeShift(BLOCK_SIZE_SHIFT)
    }
    private static final long BLOCK_SIZE = 1L << BLOCK_SIZE_SHIFT; // 8MB
        input.close();
                int toWrite = (int) Math.min(buffer.length, size - written);
        directory.close();
            .blockSizeShift(BLOCK_SIZE_SHIFT)
            .fileSize(TEST_FILE_SIZE)
        input.readByte(); // advance position
        for (byte b : buffer) {
            .fileSize(TEST_FILE_SIZE)
    public void testReadByte() throws IOException {
            () -> BlockIndexInput.builder()
        expectThrows(
    }
            .fileSize(TEST_FILE_SIZE)
import java.io.OutputStream;
        );
            .resourceDescription("test")
            .build();
    public void testSeekAndRead() throws IOException {
        super.tearDown();
package org.opensearch.storage.indexinput;
import org.junit.After;
    }
        assertEquals(100, input.getFilePointer());
            .length(TEST_FILE_SIZE)
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        BlockIndexInput input = BlockIndexInput.builder()
    private Path tempDir;
                .resourceDescription("test")
    }
                .offset(0)
    private FSDirectory directory;
            .offset(0)
            byte[] buffer = new byte[8192];
    private void createBlockFile(String name, long size) throws IOException {
            () -> BlockIndexInput.builder()
                written += toWrite;
        assertEquals(1024, slice.length());
    @After
        createBlockFile(BLOCK_FILE_1, TEST_FILE_SIZE - BLOCK_SIZE);
    }
        BlockIndexInput input = BlockIndexInput.builder()
            .length(TEST_FILE_SIZE)
            .name(FILE_NAME)
            .blockSizeShift(BLOCK_SIZE_SHIFT)
    }
            .context(IOContext.DEFAULT)
import org.junit.Before;
            .fileSize(TEST_FILE_SIZE)
        input.readBytes(buffer, 0, 100);
/**
            .offset(0)
            .offset(0)
            .build();
                .length(TEST_FILE_SIZE)
                .build()
        input.close();
        BlockIndexInput clone = input.clone();
            .name(FILE_NAME)
        tempDir = createTempDir();
    }
            .name(FILE_NAME)
            .localDirectory(directory)
        input.close();
            .blockSizeShift(BLOCK_SIZE_SHIFT)
    public void testReadBytes() throws IOException {
            .localDirectory(directory)
        // Missing directory
            .context(IOContext.DEFAULT)
            .length(TEST_FILE_SIZE)
            .blockSizeShift(BLOCK_SIZE_SHIFT)
            long written = 0;
    public void testSlice() throws IOException {
 */
        assertNotNull(slice);
                .resourceDescription("test")
    public void testBuilderValidation() {
            }
            .resourceDescription("test")
            .offset(0)
 * Unit tests for BlockIndexInput.
            .localDirectory(directory)
            .context(IOContext.DEFAULT)
        expectThrows(IllegalArgumentException.class, () -> input.slice("bad", 0, TEST_FILE_SIZE + 1));
    @Before
        }
import java.nio.file.Path;
            .name(FILE_NAME)
        input.seek(100);
            .resourceDescription("test")
    public void testClone() throws IOException {
        byte b = input.readByte();
            Arrays.fill(buffer, (byte) 7);
            .length(TEST_FILE_SIZE)
 * The OpenSearch Contributors require contributions made to
        );
            .name(FILE_NAME)
            .length(TEST_FILE_SIZE)
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;
    private static final long TEST_FILE_SIZE = 10_485_760L; // 10MB
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        // Missing file name
        BlockIndexInput input = BlockIndexInput.builder()
        assertEquals(7, b);
    }
            .build();
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
            .fileSize(TEST_FILE_SIZE)
                .build()
        assertTrue(input.length() >= 0);
                .context(IOContext.DEFAULT)
public class BlockIndexInputTests extends OpenSearchTestCase {
            .blockSizeShift(BLOCK_SIZE_SHIFT)
    }
        input.close();
                .blockSizeShift(BLOCK_SIZE_SHIFT)
            .resourceDescription("test")
            .localDirectory(directory)
                os.write(buffer, 0, toWrite);
                .name(FILE_NAME)
    private static final int BLOCK_SIZE_SHIFT = 23; // 8MB blocks
 * this file be licensed under the Apache-2.0 license or a
        BlockIndexInput input = BlockIndexInput.builder()
            while (written < size) {
        input.close();
        directory = FSDirectory.open(tempDir);
 * compatible open source license.
import org.apache.lucene.store.FSDirectory;
        input.close();
            .resourceDescription("test")
            .build();
            .resourceDescription("test")
    public void testSliceOutOfBounds() throws IOException {
            assertEquals(7, b);
            .context(IOContext.DEFAULT)
        BlockIndexInput input = BlockIndexInput.builder()
            .name(FILE_NAME)
        assertNotNull(clone);
            .resourceDescription("test")
import java.nio.file.Files;
                .offset(0)
            .localDirectory(directory)
    public void testBuildBlockIndexInput() throws IOException {
        assertEquals(7, b);
            .context(IOContext.DEFAULT)
                .localDirectory(directory)
        // Create block files with test data
            .build();
            .offset(0)
            .context(IOContext.DEFAULT)
        IndexInput slice = input.slice("test-slice", 0, 1024);
        Path filePath = tempDir.resolve(name);
        clone.close();
 *
                .fileSize(TEST_FILE_SIZE)
            .offset(0)
    public void setUp() throws Exception {
                .context(IOContext.DEFAULT)
            .fileSize(TEST_FILE_SIZE)
            .blockSizeShift(BLOCK_SIZE_SHIFT)
import org.apache.lucene.store.IOContext;
        }
            .length(TEST_FILE_SIZE)
            .offset(0)
            .context(IOContext.DEFAULT)
    private static final String BLOCK_FILE_1 = "_1.cfe_block_1";
            .resourceDescription("test")
                .length(TEST_FILE_SIZE)
                .blockSizeShift(BLOCK_SIZE_SHIFT)
import java.io.IOException;
            .localDirectory(directory)
    }
        createBlockFile(BLOCK_FILE_0, BLOCK_SIZE);
        try (OutputStream os = Files.newOutputStream(filePath)) {
    private static final String FILE_NAME = "_1.cfe";
        byte b = input.readByte();
 */
        input.close();
    }
        expectThrows(
import org.apache.lucene.store.IndexInput;
            IllegalStateException.class,
        assertEquals(input.length(), clone.length());
            .fileSize(TEST_FILE_SIZE)
        assertNotNull(input);
            .length(TEST_FILE_SIZE)
/*
        slice.close();
            .localDirectory(directory)
        super.setUp();
}
            .name(FILE_NAME)
        BlockIndexInput input = BlockIndexInput.builder()
            IllegalStateException.class,
            .build();

        );  
        byte[] data = TEST_DATA_CONTENT.getBytes(StandardCharsets.UTF_8);
        TransferManager.StreamReader reader = (name, pos, len) -> { throw new IOException("Stream read failed"); };
    }  
        long blockSize
        });
            super.shutdown();
    public void testDownloadBlobWithExistingTempFile() throws Exception {  
            .build();
    private static final int TEST_REPLICA_COUNT = 0;
     * Test handling of block download failures.  
    private static final String TEST_DATA_CONTENT = "test-data";  
            return new ByteArrayInputStream(data);
        Path tempFile = fsDirectory.getDirectory().resolve(TEST_BLOCK_FILE_NAME + ".part");
        );  
            TEST_FILE_NAME,  
        String fileName,
        FSDirectory directory,  
        Arrays.stream(fsDirectory.listAll()).forEach(fileName -> {  
            data.length
    private static final String TEST_INDEX_NAME = "test-index";
        byte[] content = HELLO_WORLD_CONTENT.getBytes(StandardCharsets.UTF_8);  
            } catch (IOException e) {  
    /**
        // First fetch triggers the download  
                throw new RuntimeException(e);
     * @param directory the FSDirectory to use
        when(reader.read(any(), anyLong(), anyLong())).thenReturn(new ByteArrayInputStream(data));
            TEST_FILE_NAME,
            fsDirectory,
    private static final int TEST_NODE_PROCESSORS = 2;
        Thread secondThread = new Thread(() -> {
            data.length  
        byte[] data = TEST_DATA_CONTENT.getBytes(StandardCharsets.UTF_8);
            TEST_FILE_NAME,  
        }  
        manager.fetchBlocksAsync(List.of(request));
/**
import java.util.concurrent.ExecutorService;
        manager.fetchBlocksAsync(List.of(request));  
        String[] files = fsDirectory.listAll();
            fsDirectory,
    public void testDownloadBlobWithIOExceptionDuringCopy() throws Exception {
    }
        verify(reader, times(1)).read(any(), anyLong(), anyLong());
    private static final String HELLO_WORLD_CONTENT = "hello world";
            fsDirectory,  
        manager.fetchBlocksAsync(List.of(request));  
            fsDirectory,  
                manager.fetchBlocksAsync(List.of(request));
                throw new RuntimeException(e);
import java.nio.file.Path;
        TransferManager.StreamReader reader = (name, pos, len) -> { throw new IOException(REMOTE_READ_ERROR_MESSAGE); };  
        fsDirectory.openInput(TEST_BLOCK_FILE_NAME, IOContext.READONCE).readBytes(actualContent, 0, content.length);
        BlockFetchRequest request2 = createBlockFetchRequest(fsDirectory, "file2", "file2_block_0", 0L, data2.length);
    /**
                return new ByteArrayInputStream(data1);
     * @param blockStart the starting position of the block
        );  
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
import org.opensearch.storage.indexinput.BlockFetchRequest;
        }
            try {  
            testThreadPool.shutdown();  
        verify(reader, never()).read(any(), anyLong(), anyLong());
        );
    }  
            this.executorService = Executors.newFixedThreadPool(4);  
            content.length
            TEST_BLOCK_FILE_NAME,
    private BlockFetchRequest createBlockFetchRequest(
            BLOCK_START_POSITION,
            executorService.shutdown();
import java.util.Arrays;
        assertThrows(IOException.class, () -> manager.fetchBlocksAsync(List.of(request)));
    public void testMultipleBlockFetchRequests() throws Exception {
        assertTrue(Arrays.stream(fsDirectory.listAll()).anyMatch(fileName -> TEST_BLOCK_FILE_NAME.equals(fileName)));
import org.opensearch.common.settings.Settings;
    // Additional test cases for new functionality
import org.junit.Assert;  
import org.junit.Before;
        public TestThreadPool() {
        byte[] data = SIMPLE_TEST_CONTENT.getBytes(StandardCharsets.UTF_8);  
import org.opensearch.Version;
        // Verify temp file was cleaned up and final file exists
import java.util.concurrent.CountDownLatch;
        @Override  
            .fileName(fileName)  
        };
        );
     */
import org.opensearch.threadpool.ThreadPool;
     */
import static org.mockito.Mockito.never;
            BLOCK_START_POSITION,
 * compatible open source license.
        manager.fetchBlocksAsync(List.of(request));
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
    /**
import org.junit.After;
        };
            }
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        assertThrows(IOException.class, () -> manager.fetchBlocksAsync(List.of(request)));  
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
        // Create the final file first
     * Creates a BlockFetchRequest with the specified parameters.
 * Tests cover single block downloads, failure scenarios, duplicate handling, and concurrent operations.  
            throw new IllegalArgumentException("Unknown file: " + name);  
        }
            fsDirectory,
        manager.fetchBlocksAsync(List.of(request1, request2));
import java.util.List;  
            TEST_BLOCK_FILE_NAME,
public class BlockTransferManagerTests extends OpenSearchTestCase {  
        long blockStart,  
    /**
            data.length
            content.length  
    private static final String REMOTE_READ_ERROR_MESSAGE = "Failed to read remote block";
    private static final int TEST_SHARD_COUNT = 1;  
        byte[] content = HELLO_WORLD_CONTENT.getBytes(StandardCharsets.UTF_8);
    private static final String TEST_FILE_NAME = "file1";
            }  
    /**  
        byte[] actualContent = new byte[content.length];  
import static org.mockito.Mockito.times;  
        fsDirectory = FSDirectory.open(createTempDir());
import org.opensearch.index.IndexSettings;
        latch.countDown(); // let read proceed
 *
            TEST_FILE_NAME,
        BlockFetchRequest request = createBlockFetchRequest(  
import org.opensearch.cluster.metadata.IndexMetadata;  
            } else if ("file2".equals(name)) {  
    private static class TestThreadPool extends ThreadPool {
            TEST_FILE_NAME,
     */
        assertEquals("Wrapped IOException", thrown.getCause().getCause().getMessage());
        Assert.assertArrayEquals(actualContent, content);
        testThreadPool = new TestThreadPool();
 * The OpenSearch Contributors require contributions made to  
        assertTrue(Arrays.asList(files).contains("file1_block_0"));
            .blockSize(blockSize)  
        // Create a temp file first
    // Test instance variables  
        byte[] data1 = "block1".getBytes(StandardCharsets.UTF_8);  
    }
        assertTrue(Arrays.asList(files).contains("file2_block_0"));  
 * this file be licensed under the Apache-2.0 license or a
        );
            BLOCK_START_POSITION,  
        private final ExecutorService executorService;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, TEST_REPLICA_COUNT)  
        fsDirectory.close();
        assertFalse(Files.exists(tempFile));  
        TransferManager.StreamReader reader = (name, pos, len) -> {
     * Test successful download of a single block.
                fsDirectory.deleteFile(fileName);
        BlockFetchRequest request = createBlockFetchRequest(  
        TransferManager.StreamReader reader = (name, pos, len) -> {  
    public void testSingleBlockDownloadSuccess() throws Exception {
     */
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        manager.fetchBlocksAsync(List.of(request));
        Settings settings = Settings.builder()
            TEST_FILE_NAME,
        TransferManager.StreamReader reader = mock(TransferManager.StreamReader.class);
        BlockFetchRequest request = createBlockFetchRequest(
    public void setup() throws IOException {
        BlockFetchRequest request = createBlockFetchRequest(
            .put(Node.NODE_NAME_SETTING.getKey(), TEST_NODE_NAME)
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
     *  
        };
    private FSDirectory fsDirectory;
        Path finalFile = fsDirectory.getDirectory().resolve(TEST_BLOCK_FILE_NAME);  
            try {
    private static final String TEST_NODE_NAME = "test-node";  
            fsDirectory,
        BlockFetchRequest request = createBlockFetchRequest(
        byte[] data = TEST_DATA_CONTENT.getBytes(StandardCharsets.UTF_8);
     */  
        TransferManager.StreamReader reader = mock(TransferManager.StreamReader.class);
            fsDirectory,
    private TestThreadPool testThreadPool;
                // Exception handling for test thread
        assertTrue(Arrays.stream(fsDirectory.listAll()).anyMatch(fileName -> TEST_BLOCK_FILE_NAME.equals(fileName)));
        byte[] data2 = "block2".getBytes(StandardCharsets.UTF_8);
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
        // Verify both files were created  
        byte[] data = TEST_DATA_CONTENT.getBytes(StandardCharsets.UTF_8);
                latch.await(); // hold until signaled  
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
            } catch (Exception ignored) {
    public void testBlockDownloadFailure() {
    /**
    ) {
    private IndexSettings indexSettings;
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);  
import static org.mockito.ArgumentMatchers.any;
            TEST_BLOCK_FILE_NAME,  
import org.opensearch.test.OpenSearchTestCase;  
        });  
            TEST_BLOCK_FILE_NAME,
    // Test data constants
    }
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
    @Before  
        Thread.sleep(CONCURRENT_TEST_SLEEP_MS); // let both threads start and block on latch
        firstThread.start();
import static org.mockito.Mockito.mock;
        return BlockFetchRequest.builder()
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
            BLOCK_START_POSITION,  
    public void testConcurrentFetchSameFileOnlyOneDownload() throws Exception {
            } catch (InterruptedException e) {
                return new ByteArrayInputStream(data2);
                // Exception handling for test thread  
        BlockFetchRequest request = createBlockFetchRequest(
            .build();
        );
        }  
    }
     * Test ThreadPool implementation with 4 threads for testing BlockTransferManager.
            .blockStart(blockStart)
        if (testThreadPool != null) {
        secondThread.start();
        assertTrue(Files.exists(finalFile));
        Thread firstThread = new Thread(() -> {  
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;  
        BlockFetchRequest request1 = createBlockFetchRequest(fsDirectory, "file1", "file1_block_0", 0L, data1.length);  
import static org.mockito.Mockito.when;
        Files.write(finalFile, "existing data".getBytes(StandardCharsets.UTF_8));
            TEST_BLOCK_FILE_NAME,  
            } catch (Exception ignored) {  
import java.io.IOException;
            TEST_BLOCK_FILE_NAME,  
        secondThread.join();
    private static final long BLOCK_START_POSITION = 0L;
            BLOCK_START_POSITION,
            BLOCK_START_POSITION,
        public void shutdown() {  
package org.opensearch.storage.common;
            data.length
    }
    }
            }
    public void testDuplicateDownloadIsSkipped() throws Exception {  
 */  
            TEST_FILE_NAME,
        assertTrue(Files.exists(tempFile));
        CountDownLatch latch = new CountDownLatch(1);  
        indexSettings = new IndexSettings(indexMetadata, settings);  
    private static final long CONCURRENT_TEST_SLEEP_MS = 200L;
            data.length
import org.opensearch.index.store.remote.utils.TransferManager;  
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
            if ("file1".equals(name)) {
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);  
            if (name.equals(TEST_FILE_NAME) && pos == BLOCK_START_POSITION && len == content.length) {  
import org.opensearch.node.Node;
    // Error message constants  
            return null;  
        TransferManager.StreamReader reader = (name, pos, len) -> {
     * @param blockSize the size of the block
        TransferManager.StreamReader reader = (name, pos, len) -> { throw new IOException("Wrapped IOException"); };
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);  
        // Verify reader was never called since file already exists  
        BlockFetchRequest request = createBlockFetchRequest(
    private BlockTransferManager blockTransferManager;  
     * @param blockFileName the name of the block file  
            }
                return new ByteArrayInputStream(content);
    }
/*  
        public ExecutorService executor(String name) {
    }
     * Test that duplicate downloads are properly skipped.
    public void testExecutionExceptionHandling() throws Exception {  
            BLOCK_START_POSITION,
import org.apache.lucene.store.IOContext;
            }
            try {
        BlockFetchRequest request = createBlockFetchRequest(  
        IndexMetadata indexMetadata = IndexMetadata.builder(TEST_INDEX_NAME).settings(settings).build();
        TransferManager.StreamReader reader = (name, pos, len) -> new ByteArrayInputStream(data);  
        // Second fetch should skip download since file exists
import org.opensearch.common.UUIDs;
            super(Settings.builder().put("node.name", "test-node").build());
}
import java.nio.file.Files;  
        String blockFileName,
import static org.mockito.Mockito.verify;
        firstThread.join();
     * Test that concurrent fetches of the same file result in only one download.  
    @After
    }  
        IOException thrown = assertThrows(IOException.class, () -> { manager.fetchBlocksAsync(List.of(request)); });
            .put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), TEST_NODE_PROCESSORS)  
        Files.write(tempFile, "old data".getBytes(StandardCharsets.UTF_8));  
            TEST_BLOCK_FILE_NAME,
        );
    private static final String SIMPLE_TEST_CONTENT = "abc";
    }
            }
            data.length
            .directory(directory)
    // Test timing constants  
    private static final String TEST_BLOCK_FILE_NAME = "file1_block_0";
            .blockFileName(blockFileName)
            TEST_BLOCK_FILE_NAME,
    // Test file constants  
     * @param fileName the name of the file
            TEST_FILE_NAME,
     */  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import java.io.ByteArrayInputStream;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, TEST_SHARD_COUNT)
import static org.mockito.ArgumentMatchers.anyLong;  
        byte[] data = TEST_DATA_CONTENT.getBytes(StandardCharsets.UTF_8);
    }
    public void testDownloadBlobWithExistingFinalFile() throws Exception {
        @Override
    // Block position constants  
            BLOCK_START_POSITION,  
 */
                manager.fetchBlocksAsync(List.of(request));
            try {
            return executorService;
 * Unit tests for BlockTransferManager functionality.
            fsDirectory,  
import org.apache.lucene.store.FSDirectory;  
     * @return a configured BlockFetchRequest  
        });  
    public void cleanup() throws IOException {
    // Node and index configuration constants
 * SPDX-License-Identifier: Apache-2.0

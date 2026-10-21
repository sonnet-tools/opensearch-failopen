    }
            return null;
    // Test data constants
        byte[] data = TEST_DATA_CONTENT.getBytes(StandardCharsets.UTF_8);
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        TransferManager.StreamReader reader = (name, pos, len) -> {
    ) {
        assertTrue(Arrays.asList(files).contains("file1_block_0"));
import org.apache.lucene.store.FSDirectory;
import org.opensearch.storage.indexinput.BlockFetchRequest;
            TEST_BLOCK_FILE_NAME,
        byte[] content = HELLO_WORLD_CONTENT.getBytes(StandardCharsets.UTF_8);
            BLOCK_START_POSITION,
    public void testDuplicateDownloadIsSkipped() throws Exception {
        });
        long blockStart,
    private static final long CONCURRENT_TEST_SLEEP_MS = 200L;
        public TestThreadPool() {
        manager.fetchBlocksAsync(List.of(request));
    private static final int TEST_NODE_PROCESSORS = 2;
        // Create a temp file first
import org.apache.lucene.store.IOContext;
        IndexMetadata indexMetadata = IndexMetadata.builder(TEST_INDEX_NAME).settings(settings).build();
import java.io.ByteArrayInputStream;
import org.junit.Before;
import org.junit.Assert;
        BlockFetchRequest request = createBlockFetchRequest(
            BLOCK_START_POSITION,
        byte[] content = HELLO_WORLD_CONTENT.getBytes(StandardCharsets.UTF_8);
            .blockFileName(blockFileName)
            TEST_BLOCK_FILE_NAME,
            fsDirectory,
        public void shutdown() {
            TEST_BLOCK_FILE_NAME,
            .blockStart(blockStart)
        TransferManager.StreamReader reader = (name, pos, len) -> new ByteArrayInputStream(data);
    private BlockFetchRequest createBlockFetchRequest(
    private BlockTransferManager blockTransferManager;
                manager.fetchBlocksAsync(List.of(request));
    }
import java.nio.charset.StandardCharsets;
            fsDirectory,
     * @param blockFileName the name of the block file
    public void setup() throws IOException {
        );
    }
        BlockFetchRequest request1 = createBlockFetchRequest(fsDirectory, "file1", "file1_block_0", 0L, data1.length);
        String blockFileName,
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
package org.opensearch.storage.common;
import static org.mockito.ArgumentMatchers.any;
            TEST_FILE_NAME,
        fsDirectory = FSDirectory.open(createTempDir());
    }
 * Tests cover single block downloads, failure scenarios, duplicate handling, and concurrent operations.
            }
            fsDirectory,
            data.length
import java.util.Arrays;
import java.nio.file.Files;
            BLOCK_START_POSITION,
     */
        assertThrows(IOException.class, () -> manager.fetchBlocksAsync(List.of(request)));
    }
        fsDirectory.close();
            } catch (IOException e) {
        };
        latch.countDown(); // let read proceed
        verify(reader, times(1)).read(any(), anyLong(), anyLong());
        assertTrue(Files.exists(tempFile));
import java.io.IOException;
    /**
import org.opensearch.Version;
    // Test instance variables
            .directory(directory)
            TEST_FILE_NAME,
                fsDirectory.deleteFile(fileName);
            } else if ("file2".equals(name)) {
        Path finalFile = fsDirectory.getDirectory().resolve(TEST_BLOCK_FILE_NAME);
                throw new RuntimeException(e);
        Settings settings = Settings.builder()
                latch.await(); // hold until signaled
            fsDirectory,
            super(Settings.builder().put("node.name", "test-node").build());
            content.length
            try {
        return BlockFetchRequest.builder()
    @Before
    private static final long BLOCK_START_POSITION = 0L;
        };
        if (testThreadPool != null) {
        );
}
        BlockFetchRequest request = createBlockFetchRequest(
        secondThread.join();
    private static final String HELLO_WORLD_CONTENT = "hello world";
            .put(Node.NODE_NAME_SETTING.getKey(), TEST_NODE_NAME)
        manager.fetchBlocksAsync(List.of(request));
     * Test that concurrent fetches of the same file result in only one download.
        );
    public void testDownloadBlobWithExistingFinalFile() throws Exception {
        BlockFetchRequest request = createBlockFetchRequest(
        TransferManager.StreamReader reader = mock(TransferManager.StreamReader.class);
        }
        @Override
                return new ByteArrayInputStream(data2);
     * @return a configured BlockFetchRequest
    }
            }
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
    /**
            super.shutdown();
        byte[] data = TEST_DATA_CONTENT.getBytes(StandardCharsets.UTF_8);
        BlockFetchRequest request = createBlockFetchRequest(
    private FSDirectory fsDirectory;
        BlockFetchRequest request = createBlockFetchRequest(
            fsDirectory,
                return new ByteArrayInputStream(content);
    private static final String TEST_INDEX_NAME = "test-index";
        Path tempFile = fsDirectory.getDirectory().resolve(TEST_BLOCK_FILE_NAME + ".part");
        byte[] data = TEST_DATA_CONTENT.getBytes(StandardCharsets.UTF_8);
        String[] files = fsDirectory.listAll();
        assertTrue(Arrays.stream(fsDirectory.listAll()).anyMatch(fileName -> TEST_BLOCK_FILE_NAME.equals(fileName)));
     */
    public void testExecutionExceptionHandling() throws Exception {
        byte[] data1 = "block1".getBytes(StandardCharsets.UTF_8);
import static org.mockito.Mockito.mock;
        BlockFetchRequest request = createBlockFetchRequest(
            .put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), TEST_NODE_PROCESSORS)
    private static final int TEST_REPLICA_COUNT = 0;
        // Verify reader was never called since file already exists
    }
            .build();
        TransferManager.StreamReader reader = mock(TransferManager.StreamReader.class);
        // Verify both files were created
        when(reader.read(any(), anyLong(), anyLong())).thenReturn(new ByteArrayInputStream(data));
                // Exception handling for test thread
            throw new IllegalArgumentException("Unknown file: " + name);
     * Test successful download of a single block.
        // Create the final file first
            .fileName(fileName)
        TransferManager.StreamReader reader = (name, pos, len) -> { throw new IOException("Wrapped IOException"); };
        });
        TransferManager.StreamReader reader = (name, pos, len) -> {
import static org.mockito.Mockito.times;
    private static final String TEST_FILE_NAME = "file1";
            try {
        };
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        fsDirectory.openInput(TEST_BLOCK_FILE_NAME, IOContext.READONCE).readBytes(actualContent, 0, content.length);
     * Test handling of block download failures.
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, TEST_SHARD_COUNT)
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
     * @param blockSize the size of the block
     */
        );
    }
 */
            }
     */
        Assert.assertArrayEquals(actualContent, content);
    /**
        manager.fetchBlocksAsync(List.of(request));
            BLOCK_START_POSITION,
    }
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
                // Exception handling for test thread
import java.util.concurrent.ExecutorService;
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
        @Override
        indexSettings = new IndexSettings(indexMetadata, settings);
import static org.mockito.Mockito.when;
 * Unit tests for BlockTransferManager functionality.
 */
            } catch (InterruptedException e) {
        Thread secondThread = new Thread(() -> {
     * Creates a BlockFetchRequest with the specified parameters.
    public void testMultipleBlockFetchRequests() throws Exception {
import org.junit.After;
            TEST_BLOCK_FILE_NAME,
            if (name.equals(TEST_FILE_NAME) && pos == BLOCK_START_POSITION && len == content.length) {
        BlockFetchRequest request = createBlockFetchRequest(
     */
            TEST_FILE_NAME,
    private static final int TEST_SHARD_COUNT = 1;
import org.opensearch.test.OpenSearchTestCase;
            data.length
            if ("file1".equals(name)) {
                manager.fetchBlocksAsync(List.of(request));
    }
        long blockSize
    private TestThreadPool testThreadPool;
            TEST_BLOCK_FILE_NAME,
    private IndexSettings indexSettings;
     * Test that duplicate downloads are properly skipped.
        assertTrue(Arrays.stream(fsDirectory.listAll()).anyMatch(fileName -> TEST_BLOCK_FILE_NAME.equals(fileName)));
        assertTrue(Files.exists(finalFile));
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
    private static final String TEST_BLOCK_FILE_NAME = "file1_block_0";
                throw new RuntimeException(e);
 * this file be licensed under the Apache-2.0 license or a
        );
        assertTrue(Arrays.asList(files).contains("file2_block_0"));
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
        secondThread.start();
/*
 *
     * @param blockStart the starting position of the block
        );
            content.length
    public void testSingleBlockDownloadSuccess() throws Exception {
        );
            }
            TEST_BLOCK_FILE_NAME,
            TEST_FILE_NAME,
            }
            try {
            fsDirectory,
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
    private static final String TEST_DATA_CONTENT = "test-data";
import static org.mockito.Mockito.verify;
        byte[] data = TEST_DATA_CONTENT.getBytes(StandardCharsets.UTF_8);
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, TEST_REPLICA_COUNT)
            executorService.shutdown();
        CountDownLatch latch = new CountDownLatch(1);
        Arrays.stream(fsDirectory.listAll()).forEach(fileName -> {
    private static final String TEST_NODE_NAME = "test-node";
    /**
            } catch (Exception ignored) {
import java.nio.file.Path;
     * Test ThreadPool implementation with 4 threads for testing BlockTransferManager.
        manager.fetchBlocksAsync(List.of(request));
            .build();
        }
        }
            TEST_FILE_NAME,
import static org.mockito.ArgumentMatchers.anyLong;
            TEST_BLOCK_FILE_NAME,
    // Additional test cases for new functionality
     * @param directory the FSDirectory to use
    public void testConcurrentFetchSameFileOnlyOneDownload() throws Exception {
    public void testDownloadBlobWithExistingTempFile() throws Exception {
        assertEquals("Wrapped IOException", thrown.getCause().getCause().getMessage());
 * compatible open source license.
            return executorService;
    public void testDownloadBlobWithIOExceptionDuringCopy() throws Exception {
        private final ExecutorService executorService;
import static org.mockito.Mockito.never;
        manager.fetchBlocksAsync(List.of(request));
            fsDirectory,
            data.length
        BlockFetchRequest request = createBlockFetchRequest(
/**
            TEST_FILE_NAME,
        // First fetch triggers the download
import java.util.concurrent.CountDownLatch;
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
    private static final String SIMPLE_TEST_CONTENT = "abc";
        Thread firstThread = new Thread(() -> {
import org.opensearch.index.IndexSettings;
            try {
    // Error message constants
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            return new ByteArrayInputStream(data);
    /**
            BLOCK_START_POSITION,
        Thread.sleep(CONCURRENT_TEST_SLEEP_MS); // let both threads start and block on latch
        BlockFetchRequest request2 = createBlockFetchRequest(fsDirectory, "file2", "file2_block_0", 0L, data2.length);
import org.opensearch.threadpool.ThreadPool;
        manager.fetchBlocksAsync(List.of(request1, request2));
            } catch (Exception ignored) {
     *
        firstThread.join();
import org.opensearch.cluster.metadata.IndexMetadata;
            data.length
        testThreadPool = new TestThreadPool();
            fsDirectory,
        byte[] actualContent = new byte[content.length];
            BLOCK_START_POSITION,
    /**
 * The OpenSearch Contributors require contributions made to
        BlockTransferManager manager = new BlockTransferManager(reader, indexSettings, () -> testThreadPool);
        byte[] data2 = "block2".getBytes(StandardCharsets.UTF_8);
    // Node and index configuration constants
            testThreadPool.shutdown();
import org.opensearch.index.store.remote.utils.TransferManager;
            }
            BLOCK_START_POSITION,
            BLOCK_START_POSITION,
     * @param fileName the name of the file
    public void testBlockDownloadFailure() {
            TEST_BLOCK_FILE_NAME,
public class BlockTransferManagerTests extends OpenSearchTestCase {
import java.util.concurrent.Executors;
     */
    }
import org.opensearch.node.Node;
                return new ByteArrayInputStream(data1);
    }
        });
    public void cleanup() throws IOException {
import org.opensearch.common.settings.Settings;
        verify(reader, never()).read(any(), anyLong(), anyLong());
    @After
        Files.write(finalFile, "existing data".getBytes(StandardCharsets.UTF_8));
        public ExecutorService executor(String name) {
        byte[] data = TEST_DATA_CONTENT.getBytes(StandardCharsets.UTF_8);
import java.util.List;
        IOException thrown = assertThrows(IOException.class, () -> { manager.fetchBlocksAsync(List.of(request)); });
        firstThread.start();
        );
        FSDirectory directory,
        assertThrows(IOException.class, () -> manager.fetchBlocksAsync(List.of(request)));
            data.length
        }
    // Block position constants
        TransferManager.StreamReader reader = (name, pos, len) -> { throw new IOException(REMOTE_READ_ERROR_MESSAGE); };
        byte[] data = SIMPLE_TEST_CONTENT.getBytes(StandardCharsets.UTF_8);
    private static final String REMOTE_READ_ERROR_MESSAGE = "Failed to read remote block";
            this.executorService = Executors.newFixedThreadPool(4);
        assertFalse(Files.exists(tempFile));
    // Test timing constants
            TEST_FILE_NAME,
            TEST_FILE_NAME,
    // Test file constants
        Files.write(tempFile, "old data".getBytes(StandardCharsets.UTF_8));
            data.length
        // Second fetch should skip download since file exists
        String fileName,
            .blockSize(blockSize)
    private static class TestThreadPool extends ThreadPool {
    }
        TransferManager.StreamReader reader = (name, pos, len) -> { throw new IOException("Stream read failed"); };
        TransferManager.StreamReader reader = (name, pos, len) -> {
        // Verify temp file was cleaned up and final file exists
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import org.opensearch.common.UUIDs;

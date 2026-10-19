import java.util.concurrent.Future;
                    } catch (Exception e) {
            transferManager.fetchBlobAsync(blobFetchRequest);
                future.get(1, TimeUnit.SECONDS);
import java.util.ArrayList;
        });
                try (IndexInput i = future.get()) {
            try {
        // then start the fetch for that blob on a separate thread
        latch.countDown();
    public void testFetchesToDifferentBlobsDoNotBlockOnEachOther() throws Exception {
                    try {
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
                futures.add(testRunner.submit(() -> {
        mockWaitForLatchReader(latch);
    }
        // It will trigger async load
            }
                    }
        }
        MatcherAssert.assertThat(fileCache.activeUsage(), equalTo(0L));
import static org.hamcrest.Matchers.greaterThan;
        doThrow(new IllegalArgumentException("Invalid thread pool")).when(threadPool).executor(ThreadPool.Names.REMOTE_RECOVERY);
            } catch (java.util.concurrent.ExecutionException ignored) { // Index input may be null
    public void testOverflowDisabledAsynchronous() throws Exception {
    public void testDownloadFailsAsyncDownloadException() throws Exception {
        indexInput.seek(EIGHT_MB - 1);
        final CountDownLatch latch = new CountDownLatch(1);
        } finally {
        BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder().fileName(blobname).directory(directory).blobParts(blobParts).build();
        String blobname = "test-blob";
            // Assert that all IndexInputs are independently positioned by seeking
    }
        });
                future.get(1, TimeUnit.SECONDS);
            } catch (IOException e) {
                    future.get(10, TimeUnit.SECONDS);
                }
        assertThrows(IOException.class, () -> { IndexInput i3 = asyncFetchBlobWithName("3"); });
import org.junit.Before;
        ExecutorService executor = Executors.newFixedThreadPool(8);
            MatcherAssert.assertThat(fileCache.activeUsage(), equalTo((long) EIGHT_MB));
        // request one of eight blobs. Given that the cache can only hold two
import org.hamcrest.MatcherAssert;
        blobParts.add(new BlobFetchRequest.BlobPart("blocking-blob", 0, EIGHT_MB));
            try {
        executorService.shutdownNow();
    }
            }
    }
                        throw new AssertionError(e);
    protected static byte[] createData() {
                    } catch (IOException ignored) { // fetchBlobWithName may fail due to fixed capacity
 * this file be licensed under the Apache-2.0 license or a
        final String blobname = "file";
        expectThrows(IOException.class, () -> {
        blockingThread.join(5_000);
    public void testRefCount() throws Exception {
    public void testConcurrentAccess() throws Exception {
        final ExecutorService testRunner = Executors.newFixedThreadPool(16);
    protected static final int EIGHT_MB = 1024 * 1024 * 8;
                .blobParts(blobParts)
    public void testRefMultipleCount() throws Exception {
        BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder().fileName(blobname).directory(directory).blobParts(blobParts).build();
        IndexInput indexInput = transferManager.fetchBlob(blobFetchRequest);
        initializeTransferManager();
    @Before
                        try (IndexInput indexInput = fetchBlobWithName(blobname)) {
        MatcherAssert.assertThat(fileCache.usage(), equalTo((long) EIGHT_MB));
            if (indexInput != null) {
        final Thread blockingThread = new Thread(() -> {
        MatcherAssert.assertThat(indexInput.readByte(), equalTo((byte) 7));
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
            // to the end and closing each one. If not independent, then this would
                throw new RuntimeException(e);
            // Wait for all threads to complete
        assertFalse(blockingThread.isAlive());
    }
 * SPDX-License-Identifier: Apache-2.0
                .fileName("file")
        try {
            }
    public void testDownloadFailsAsyncDownload() throws Exception {
        blockingThread.start();
        transferManager.fetchBlob(blobFetchRequest);
        // then start the fetch for that blob on a separate thread
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    }
        assertThrows(IOException.class, () -> { IndexInput i3 = fetchBlobWithName("3"); });
    protected abstract void mockExceptionWhileReading() throws IOException;
            BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder()
            assertTrue(terminate(testRunner));
        );
        assertNotNull(fileCache.getRef(blobFetchRequest.getFilePath()));
        });
        ExecutorService executor = Executors.newFixedThreadPool(3);
            transferManager.fetchBlobAsync(blobFetchRequest);
                }
                try (IndexInput i = future.get()) {
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
    public void tearDown() throws Exception {
        MatcherAssert.assertThat(fileCache.usage(), equalTo((long) EIGHT_MB));
        blobParts.add(new BlobFetchRequest.BlobPart("blob", 0, EIGHT_MB));
            () -> transferManager.fetchBlob(BlobFetchRequest.builder().fileName("file").directory(directory).blobParts(blobParts).build())
        mockExceptionWhileReading();
        CompletableFuture<IndexInput> future = transferManager.fetchBlobAsync(blobFetchRequest);
    protected TransferManager transferManager;
        blobParts.add(new BlobFetchRequest.BlobPart("blob", 0, EIGHT_MB));
        waitUntil(() -> fileCache.getRef(blobFetchRequest.getFilePath()) == 1, 10, TimeUnit.SECONDS);
                .blobParts(blobParts)
    public void testAsyncFetchesToDifferentBlobsDoNotBlockOnEachOther() throws Exception {
            assertIndexInputIsFunctional(i);
            executor.shutdownNow();
            final List<Future<IndexInput>> futures = new ArrayList<>();
 */
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
    protected ExecutorService executorService;
            for (Future<IndexInput> future : futures) {
        assertNotNull(fileCache.get(blobFetchRequest.getFilePath()));
        transferManager.fetchBlobAsync(blobFetchRequest);
import org.junit.After;
            assertIndexInputIsFunctional(i);
        try {
        try {
                throw new AssertionError(e);
    protected abstract void initializeTransferManager() throws IOException;
        final byte[] data = new byte[EIGHT_MB];
        BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder().fileName(blobname).directory(directory).blobParts(blobParts).build();
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
import static org.mockito.Mockito.doThrow;
        // Kick off multiple threads that all concurrently request the same resource
        executor.shutdownNow();
                .fileName("file")
        // blobs this will lead to a huge amount of contention and thrashing.
        ExecutorService executor = Executors.newFixedThreadPool(3);
import java.util.concurrent.CountDownLatch;
import org.opensearch.threadpool.ThreadPool;
        MatcherAssert.assertThat(fileCache.activeUsage(), equalTo(0L));
            }
        }
        // Making the read call to fetch from file cache
        future.get();
import java.util.List;
        fileCache.decRef(blobFetchRequest.getFilePath());
        } finally {
import java.util.concurrent.CompletableFuture;
            // result in EOFExceptions and/or NPEs.
public abstract class TransferManagerTestCase extends OpenSearchTestCase {
        try (IndexInput i = fetchBlobWithName("file")) {
        MatcherAssert.assertThat(fileCache.usage(), equalTo(0L));
                            assertIndexInputIsFunctional(indexInput);
        // Kick off multiple threads that all concurrently request the same resource
        // Assert that a different blob can be fetched and will not block on the first blob
    public void setUp() throws Exception {
        // Submit 256 tasks to an executor with 16 threads that will each randomly
import org.apache.lucene.store.SimpleFSLockFactory;
    }
            BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder()
            // to the end and closing each one. If not independent, then this would
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
                indexInput.close();
            }
            indexInput = asyncFetchBlobWithName("file");
    }
            for (int i = 0; i < 8; i++) {
            }
        super.setUp();
                    BlobFetchRequest.builder().fileName("blocking-file").directory(directory).blobParts(blobParts).build()
            final List<Future<IndexInput>> futures = new ArrayList<>();
            // Assert that all IndexInputs are independently positioned by seeking
            for (Future<IndexInput> future : futures) {
            } catch (Exception e) {
        IndexInput i1 = asyncFetchBlobWithName("1");
        expectThrows(
    public void testConcurrentAccessAsynchronous() throws Exception {
            }
    private IndexInput fetchBlobWithName(String blobname) throws IOException {
                    assertIndexInputIsFunctional(i);
import org.apache.lucene.store.IndexInput;
        try (IndexInput i = asyncFetchBlobWithName("file")) {
            // result in EOFExceptions and/or NPEs.
        blockingThread.start();
        final String blobname = "file";
        });
import static org.hamcrest.Matchers.equalTo;
    }
        directory = new MMapDirectory(createTempDir(), SimpleFSLockFactory.INSTANCE);
            for (Future<IndexInput> future : futures) {
        assertTrue(blockingThread.isAlive());
    }
        // Mock a call for a blob that will block until the latch is released,
            IOException.class,
                        }
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
        initializeTransferManager();
    @After
        blobParts.add(new BlobFetchRequest.BlobPart("failure-blob", 0, EIGHT_MB));
    }
 * compatible open source license.
    public void testSingleAccess() throws Exception {
                // request an index input and immediately close it
    protected final FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(EIGHT_MB * 2, 1);
    protected abstract void mockWaitForLatchReader(CountDownLatch latch) throws IOException;
            assertTrue(terminate(testRunner));
import java.io.IOException;
            // Wait for all threads to complete
    }
        // Assert that a different blob can be fetched and will not block on the first blob
 *
        mockExceptionWhileReading();
        return data;
        expectThrows(IllegalArgumentException.class, () -> {
        final ExecutorService testRunner = Executors.newFixedThreadPool(8);
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
    }
        }
        return transferManager.fetchBlob(BlobFetchRequest.builder().fileName(blobname).directory(directory).blobParts(blobParts).build());
                futures.add(testRunner.submit(() -> fetchBlobWithName(blobname)));
        blobParts.add(new BlobFetchRequest.BlobPart("failure-blob", 0, EIGHT_MB));
        IndexInput indexInput = null;
                .build();
        MatcherAssert.assertThat(fileCache.activeUsage(), equalTo(0L));
        }
    public void testSingleAccessAsynchronous() throws Exception {
        return transferManager.fetchBlob(blobFetchRequest);
        try {
    protected MMapDirectory directory;
            assertIndexInputIsFunctional(indexInput);
import org.apache.lucene.store.MMapDirectory;
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        MatcherAssert.assertThat(fileCache.activeUsage(), equalTo(0L));
        // Mock a call for a blob that will block until the latch is released,
                );
            }
            try (IndexInput indexInput = transferManager.fetchBlob(blobFetchRequest)) {}
            for (int i = 0; i < 8; i++) {
                );
            final List<Future<?>> futures = new ArrayList<>();
        initializeTransferManager();
    }
        super.tearDown();
        latch.countDown();
    protected ThreadPool threadPool;
        try (IndexInput i = fetchBlobWithName("file")) {
    public void testDownloadFails() throws Exception {
import java.util.concurrent.Executors;
        mockExceptionWhileReading();
                    assertIndexInputIsFunctional(i);
    public void testOverflowDisabled() throws Exception {
                transferManager.fetchBlob(
    private static void assertIndexInputIsFunctional(IndexInput indexInput) throws IOException {
        }
                throw new RuntimeException(e);
import static org.mockito.Mockito.mock;
    }
package org.opensearch.index.store.remote.utils;
            for (Future<IndexInput> future : futures) {
                .directory(directory)
            assertIndexInputIsFunctional(i);
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
            }
        assertTrue(blockingThread.isAlive());
        } finally {
    public void testFetchBlobWithConcurrentCacheEvictions() {
        executorService = Executors.newFixedThreadPool(3);
    }
                futures.add(executor.submit(() -> asyncFetchBlobWithName(blobname)));
        }
                final String blobname = "blob-" + randomIntBetween(0, 7);
import java.util.Optional;
        // Making the read call to fetch from file cache
        transferManager.fetchBlobAsync(blobFetchRequest).join();
        mockWaitForLatchReader(latch);
            for (int i = 0; i < 256; i++) {
                }));
                transferManager.fetchBlob(
        assertEquals(Optional.of(1), Optional.of(fileCache.getRef(blobFetchRequest.getFilePath())));
        assertEquals(Optional.of(1), Optional.of(fileCache.getRef(blobFetchRequest.getFilePath())));
                    BlobFetchRequest.builder().fileName("blocking-file").directory(directory).blobParts(blobParts).build()
    }
        blobParts.add(new BlobFetchRequest.BlobPart("blob", 0, EIGHT_MB));
        String blobname = "test-blob";
        MatcherAssert.assertThat("Expected many evictions to happen", fileCache.stats().evictionCount(), greaterThan(0L));
        assertFalse(blockingThread.isAlive());
}
        blobParts.add(new BlobFetchRequest.BlobPart("blob", 0, EIGHT_MB));
        IndexInput i2 = fetchBlobWithName("2");
            }
        } finally {
        doReturn(executorService).when(threadPool).executor(ThreadPool.Names.REMOTE_RECOVERY);
        final CountDownLatch latch = new CountDownLatch(1);
        executor.shutdownNow();
    }
            // Wait for all threads to complete
                .directory(directory)
            }
        blockingThread.join(5_000);
        MatcherAssert.assertThat(fileCache.usage(), equalTo(0L));
    }
        final Thread blockingThread = new Thread(() -> {
                for (Future<?> future : futures) {
        threadPool = mock(ThreadPool.class);
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
import static org.mockito.Mockito.doReturn;
                .build();
    private IndexInput asyncFetchBlobWithName(String blobname) throws IOException {
import org.opensearch.index.store.remote.filecache.FileCache;
    }
/*
        assertEquals(Optional.of(0), Optional.of(fileCache.getRef(blobFetchRequest.getFilePath())));
        MatcherAssert.assertThat(fileCache.activeUsage(), equalTo(0L));
        data[EIGHT_MB - 1] = 7;
import org.opensearch.test.OpenSearchTestCase;
            MatcherAssert.assertThat(fileCache.activeUsage(), equalTo((long) EIGHT_MB));
                }
        }
        blobParts.add(new BlobFetchRequest.BlobPart("failure-blob", 0, EIGHT_MB));
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            } catch (IOException e) {
            try {
        IndexInput i2 = asyncFetchBlobWithName("2");
        // It will trigger async load
        blobParts.add(new BlobFetchRequest.BlobPart("blocking-blob", 0, EIGHT_MB));
 * The OpenSearch Contributors require contributions made to
        IndexInput i1 = fetchBlobWithName("1");

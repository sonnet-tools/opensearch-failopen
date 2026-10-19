        });  
    protected abstract void initializeTransferManager() throws IOException;
        // blobs this will lead to a huge amount of contention and thrashing.
                throw new RuntimeException(e);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // then start the fetch for that blob on a separate thread
        return data;  
            for (Future<IndexInput> future : futures) {  
        final Thread blockingThread = new Thread(() -> {
 * compatible open source license.
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
            }  
import org.hamcrest.MatcherAssert;
            }
            try (IndexInput indexInput = transferManager.fetchBlob(blobFetchRequest)) {}
            } catch (java.util.concurrent.ExecutionException ignored) { // Index input may be null  
        BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder().fileName(blobname).directory(directory).blobParts(blobParts).build();
        } finally {  
                    assertIndexInputIsFunctional(i);
        blobParts.add(new BlobFetchRequest.BlobPart("blob", 0, EIGHT_MB));
                try (IndexInput i = future.get()) {
                    } catch (Exception e) {
    protected final FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(EIGHT_MB * 2, 1);
            for (int i = 0; i < 8; i++) {  
                    } catch (IOException ignored) { // fetchBlobWithName may fail due to fixed capacity
            IOException.class,
            BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder()
        MatcherAssert.assertThat(fileCache.activeUsage(), equalTo(0L));
    public void setUp() throws Exception {  
            }
        // Mock a call for a blob that will block until the latch is released,  
    }
import java.util.concurrent.CompletableFuture;
import org.junit.After;  
    }
            for (Future<IndexInput> future : futures) {
    public void testFetchBlobWithConcurrentCacheEvictions() {
        threadPool = mock(ThreadPool.class);
        blobParts.add(new BlobFetchRequest.BlobPart("blocking-blob", 0, EIGHT_MB));  
 * SPDX-License-Identifier: Apache-2.0
        blobParts.add(new BlobFetchRequest.BlobPart("blob", 0, EIGHT_MB));
                .build();
    }  
import static org.mockito.Mockito.mock;  
        BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder().fileName(blobname).directory(directory).blobParts(blobParts).build();
        executorService.shutdownNow();
        IndexInput indexInput = null;
        try (IndexInput i = asyncFetchBlobWithName("file")) {
        MatcherAssert.assertThat(fileCache.usage(), equalTo((long) EIGHT_MB));  
    protected ThreadPool threadPool;
    public void testAsyncFetchesToDifferentBlobsDoNotBlockOnEachOther() throws Exception {
                try (IndexInput i = future.get()) {
        latch.countDown();
    protected abstract void mockExceptionWhileReading() throws IOException;
            assertTrue(terminate(testRunner));
        initializeTransferManager();  
            transferManager.fetchBlobAsync(blobFetchRequest);  
        String blobname = "test-blob";  
                        }  
        blobParts.add(new BlobFetchRequest.BlobPart("blob", 0, EIGHT_MB));
import java.util.concurrent.Executors;
        // Assert that a different blob can be fetched and will not block on the first blob  
            BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder()
import org.apache.lucene.store.MMapDirectory;
 */  
        initializeTransferManager();
        // It will trigger async load  
        final byte[] data = new byte[EIGHT_MB];
        final CountDownLatch latch = new CountDownLatch(1);
        MatcherAssert.assertThat(indexInput.readByte(), equalTo((byte) 7));
    public void testDownloadFailsAsyncDownloadException() throws Exception {
        final ExecutorService testRunner = Executors.newFixedThreadPool(16);
        return transferManager.fetchBlob(blobFetchRequest);  
        directory = new MMapDirectory(createTempDir(), SimpleFSLockFactory.INSTANCE);  
                    assertIndexInputIsFunctional(i);  
    protected static final int EIGHT_MB = 1024 * 1024 * 8;
            }
            // Assert that all IndexInputs are independently positioned by seeking  
 * The OpenSearch Contributors require contributions made to  
        doReturn(executorService).when(threadPool).executor(ThreadPool.Names.REMOTE_RECOVERY);  
        expectThrows(IOException.class, () -> {  
    private IndexInput fetchBlobWithName(String blobname) throws IOException {
                throw new RuntimeException(e);
            executor.shutdownNow();  
import java.util.Optional;  
        indexInput.seek(EIGHT_MB - 1);
        executor.shutdownNow();
                .fileName("file")
            // to the end and closing each one. If not independent, then this would
                transferManager.fetchBlob(  
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.TimeUnit;  
public abstract class TransferManagerTestCase extends OpenSearchTestCase {  
        } finally {
        MatcherAssert.assertThat(fileCache.activeUsage(), equalTo(0L));
    }  
        IndexInput i2 = asyncFetchBlobWithName("2");
                    BlobFetchRequest.builder().fileName("blocking-file").directory(directory).blobParts(blobParts).build()
    }
            for (int i = 0; i < 8; i++) {
                .fileName("file")
                }
                for (Future<?> future : futures) {  
        expectThrows(  
        fileCache.decRef(blobFetchRequest.getFilePath());
    public void testRefMultipleCount() throws Exception {
                transferManager.fetchBlob(
    }  
        blobParts.add(new BlobFetchRequest.BlobPart("blob", 0, EIGHT_MB));
            transferManager.fetchBlobAsync(blobFetchRequest);  
        return transferManager.fetchBlob(BlobFetchRequest.builder().fileName(blobname).directory(directory).blobParts(blobParts).build());
        blockingThread.start();
import static org.hamcrest.Matchers.greaterThan;  
import java.util.concurrent.ExecutorService;  
            } catch (Exception e) {
        // Kick off multiple threads that all concurrently request the same resource  
        // Making the read call to fetch from file cache  
            assertIndexInputIsFunctional(i);
            assertIndexInputIsFunctional(i);
    private static void assertIndexInputIsFunctional(IndexInput indexInput) throws IOException {  
        assertEquals(Optional.of(1), Optional.of(fileCache.getRef(blobFetchRequest.getFilePath())));
    }  
import java.util.ArrayList;
                // request an index input and immediately close it  
        });
        String blobname = "test-blob";
    }  
                        throw new AssertionError(e);  
    }  
                }));
            for (Future<IndexInput> future : futures) {  
        }
            indexInput = asyncFetchBlobWithName("file");  
        MatcherAssert.assertThat("Expected many evictions to happen", fileCache.stats().evictionCount(), greaterThan(0L));
                throw new AssertionError(e);
        assertThrows(IOException.class, () -> { IndexInput i3 = fetchBlobWithName("3"); });
        try (IndexInput i = fetchBlobWithName("file")) {
        IndexInput i1 = fetchBlobWithName("1");
        final CountDownLatch latch = new CountDownLatch(1);
    }
            // Wait for all threads to complete
    }  
            if (indexInput != null) {
    protected abstract void mockWaitForLatchReader(CountDownLatch latch) throws IOException;  
            final List<Future<?>> futures = new ArrayList<>();
        // Kick off multiple threads that all concurrently request the same resource
                            assertIndexInputIsFunctional(indexInput);
                .build();
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
            for (int i = 0; i < 256; i++) {
        assertNotNull(fileCache.getRef(blobFetchRequest.getFilePath()));
    }
            // Wait for all threads to complete  
        blobParts.add(new BlobFetchRequest.BlobPart("failure-blob", 0, EIGHT_MB));
            // result in EOFExceptions and/or NPEs.  
        mockExceptionWhileReading();  
    public void testSingleAccess() throws Exception {  
        future.get();
            try {
    public void tearDown() throws Exception {
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();  
        MatcherAssert.assertThat(fileCache.activeUsage(), equalTo(0L));  
            // Assert that all IndexInputs are independently positioned by seeking
            try {
    public void testRefCount() throws Exception {
import org.opensearch.threadpool.ThreadPool;
        waitUntil(() -> fileCache.getRef(blobFetchRequest.getFilePath()) == 1, 10, TimeUnit.SECONDS);
        // Making the read call to fetch from file cache
    @After  
    }  
    protected MMapDirectory directory;  
        });
            }
            }  
        IndexInput i1 = asyncFetchBlobWithName("1");
        doThrow(new IllegalArgumentException("Invalid thread pool")).when(threadPool).executor(ThreadPool.Names.REMOTE_RECOVERY);  
        blockingThread.join(5_000);
    }
        try (IndexInput i = fetchBlobWithName("file")) {
                future.get(1, TimeUnit.SECONDS);
            // Wait for all threads to complete
        assertFalse(blockingThread.isAlive());  
        assertTrue(blockingThread.isAlive());
            }
                    BlobFetchRequest.builder().fileName("blocking-file").directory(directory).blobParts(blobParts).build()
        blobParts.add(new BlobFetchRequest.BlobPart("failure-blob", 0, EIGHT_MB));
    public void testOverflowDisabledAsynchronous() throws Exception {
import java.io.IOException;  
    }
            // result in EOFExceptions and/or NPEs.
import org.apache.lucene.store.SimpleFSLockFactory;
            }
            assertIndexInputIsFunctional(indexInput);
import org.apache.lucene.store.IndexInput;  
    public void testDownloadFailsAsyncDownload() throws Exception {
        transferManager.fetchBlob(blobFetchRequest);
    }
    }
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
            for (Future<IndexInput> future : futures) {
    public void testFetchesToDifferentBlobsDoNotBlockOnEachOther() throws Exception {
        mockWaitForLatchReader(latch);  
        // Assert that a different blob can be fetched and will not block on the first blob
    public void testConcurrentAccess() throws Exception {  
                        try (IndexInput indexInput = fetchBlobWithName(blobname)) {
        BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder().fileName(blobname).directory(directory).blobParts(blobParts).build();  
    public void testDownloadFails() throws Exception {
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
import java.util.concurrent.Future;
                .directory(directory)  
        executor.shutdownNow();
        assertEquals(Optional.of(1), Optional.of(fileCache.getRef(blobFetchRequest.getFilePath())));
            // to the end and closing each one. If not independent, then this would
            assertTrue(terminate(testRunner));  
        // It will trigger async load  
        initializeTransferManager();  
        executorService = Executors.newFixedThreadPool(3);
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();  
        transferManager.fetchBlobAsync(blobFetchRequest);
        assertEquals(Optional.of(0), Optional.of(fileCache.getRef(blobFetchRequest.getFilePath())));  
    public void testConcurrentAccessAsynchronous() throws Exception {
        // request one of eight blobs. Given that the cache can only hold two  
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
        try {
        blobParts.add(new BlobFetchRequest.BlobPart("blocking-blob", 0, EIGHT_MB));
        }  
            MatcherAssert.assertThat(fileCache.activeUsage(), equalTo((long) EIGHT_MB));
        }
import static org.hamcrest.Matchers.equalTo;
            } catch (IOException e) {  
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // then start the fetch for that blob on a separate thread
            MatcherAssert.assertThat(fileCache.activeUsage(), equalTo((long) EIGHT_MB));  
        });
                final String blobname = "blob-" + randomIntBetween(0, 7);
    private IndexInput asyncFetchBlobWithName(String blobname) throws IOException {
        );  
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
            try {  
        try {
        assertNotNull(fileCache.get(blobFetchRequest.getFilePath()));
        }
        data[EIGHT_MB - 1] = 7;
    @Before
        final String blobname = "file";
    }  
import static org.mockito.Mockito.doReturn;
        transferManager.fetchBlobAsync(blobFetchRequest).join();  
import java.util.concurrent.CountDownLatch;
                future.get(1, TimeUnit.SECONDS);
        assertTrue(blockingThread.isAlive());  
        try {  
            final List<Future<IndexInput>> futures = new ArrayList<>();
        assertThrows(IOException.class, () -> { IndexInput i3 = asyncFetchBlobWithName("3"); });
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;  
        // Mock a call for a blob that will block until the latch is released,  
            } catch (IOException e) {
        // Submit 256 tasks to an executor with 16 threads that will each randomly
        mockExceptionWhileReading();  
        blobParts.add(new BlobFetchRequest.BlobPart("failure-blob", 0, EIGHT_MB));
import org.opensearch.test.OpenSearchTestCase;  
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
    }
        latch.countDown();  
        MatcherAssert.assertThat(fileCache.usage(), equalTo((long) EIGHT_MB));  
        }
            final List<Future<IndexInput>> futures = new ArrayList<>();
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
        final Thread blockingThread = new Thread(() -> {
        }
}
    protected TransferManager transferManager;
                .blobParts(blobParts)
import org.opensearch.index.store.remote.filecache.FileCache;
    protected static byte[] createData() {  
        ExecutorService executor = Executors.newFixedThreadPool(8);
                futures.add(executor.submit(() -> asyncFetchBlobWithName(blobname)));  
                futures.add(testRunner.submit(() -> fetchBlobWithName(blobname)));
    }  
        } finally {
            }  
        super.setUp();
                futures.add(testRunner.submit(() -> {
        CompletableFuture<IndexInput> future = transferManager.fetchBlobAsync(blobFetchRequest);
        mockExceptionWhileReading();
        MatcherAssert.assertThat(fileCache.activeUsage(), equalTo(0L));
import static org.mockito.Mockito.doThrow;
    public void testSingleAccessAsynchronous() throws Exception {  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            }  
        final ExecutorService testRunner = Executors.newFixedThreadPool(8);  
        blockingThread.start();
        final String blobname = "file";
        try {  
        IndexInput indexInput = transferManager.fetchBlob(blobFetchRequest);
 *
            () -> transferManager.fetchBlob(BlobFetchRequest.builder().fileName("file").directory(directory).blobParts(blobParts).build())
        expectThrows(IllegalArgumentException.class, () -> {  
            assertIndexInputIsFunctional(i);  
        IndexInput i2 = fetchBlobWithName("2");
    public void testOverflowDisabled() throws Exception {
                .directory(directory)  
                }  
import java.util.List;
                );
        assertFalse(blockingThread.isAlive());
                    future.get(10, TimeUnit.SECONDS);
        super.tearDown();  
        MatcherAssert.assertThat(fileCache.activeUsage(), equalTo(0L));
            }  
                .blobParts(blobParts)
package org.opensearch.index.store.remote.utils;
import org.junit.Before;
                }
        MatcherAssert.assertThat(fileCache.usage(), equalTo(0L));
                    }
    protected ExecutorService executorService;  
                    try {  
        } finally {  
        MatcherAssert.assertThat(fileCache.usage(), equalTo(0L));
                indexInput.close();
        mockWaitForLatchReader(latch);  
        blockingThread.join(5_000);
                );  
/*  
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();  
        }

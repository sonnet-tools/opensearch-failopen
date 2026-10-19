        final Thread thread = new Thread(() -> {
        final PlainActionFuture<Void> l = new PlainActionFuture<>();
        try (Directory target = new NIOFSDirectory(createTempDir())) {
            public void onResponse(Void unused) {}  
    }  
            }  
        fileDownloader.downloadAsync(new CancellableThreads(), source, destination, Set.of("not real"), new ActionListener<>() {
 * this file be licensed under the Apache-2.0 license or a
                } catch (InterruptedException e) {
                    multiPartFiles.add(name);
    public void testCancellable() {
public class RemoteStoreFileDownloaderTests extends OpenSearchTestCase {
import java.util.Map;
                    final byte[] actual = new byte[(int) in.length()];
                if (i < 3) {  
        for (String name : multiPartFiles) {
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
            }  
        assertTrue(latch.await(10, TimeUnit.SECONDS));  
        };
        }  
                .put("indices.recovery.remote_store.parallel_download.part_size", new ByteSizeValue(partSize))  
        );  
        );
            } catch (Exception e) {
                    CodecUtil.checksumEntireFile(in);
import java.util.concurrent.TimeUnit;
        try (Directory local = new NIOFSDirectory(createTempDir())) {
                }  
        blobContainer.wholeReads.set(0);
import org.apache.lucene.store.FilterDirectory;  
            @Override  
                    throw new RuntimeException("Failed due to interrupt", e);
                    throw new RuntimeException("Failed due to interrupt", e);  
        final PlainActionFuture<Void> blockingListener = new PlainActionFuture<>();
        thread.start();
        );  
                assertEquals(IOException.class, e.getClass());  
        });
        threadPool = new TestThreadPool(getTestName());  
            Settings.builder()
            super(delegate);  
                }  
    private static int availablePermits(ParallelDownloadPermits permits) {  
        long expectedRangeReads = 0;  
            return child;
        try (Directory local = new NIOFSDirectory(createTempDir())) {
            }  
}
            new RemoteDirectory(blobContainer),
import org.opensearch.common.blobstore.BlobContainer;
            future.actionGet();
    }  
    @Before
            wholeReads.incrementAndGet();
    }
        };  
    /**
import org.opensearch.action.support.PlainActionFuture;  
                    in.readBytes(onDisk, 0, onDisk.length);  
                .put("indices.recovery.remote_store.parallel_download.max_concurrent_parts", maxParts)
import static org.hamcrest.Matchers.greaterThan;
        assertEquals(0, blobContainer.rangeReads.get());
    private RemoteStoreFileDownloader fileDownloader;
                latch.countDown();
import static org.mockito.Mockito.mock;  
        assertTrue(threadPool.awaitTermination(5, TimeUnit.SECONDS));
        blobContainer.wholeReads.set(0);
import org.opensearch.common.util.CancellableThreads;  
import java.util.Set;
            final long length = expected.get(name).length;
        // files are present  
            @Override
            Settings.builder().put("indices.recovery.max_concurrent_remote_store_streams", streamLimit).build(),  
        fileDownloader.download(source, destination, null, files.keySet(), counter::incrementAndGet);
import org.opensearch.common.blobstore.BlobPath;
                latch.countDown();  
                    in.seek(0);  
        // Upload a mix of files: some spanning several parts, some exactly one part, some tiny.
            "Expected to timeout due to blocking directory",  
        }  
        assertBusy(() -> assertEquals(maxParts, availablePermits(permits)));
            OpenSearchTimeoutException.class,
    }
            }
        );
import java.io.IOException;
import java.util.HashMap;
import org.opensearch.common.settings.Settings;
import org.opensearch.core.common.unit.ByteSizeValue;  
            public void copyFrom(Directory from, String src, String dest, IOContext context) throws IOException {
        assertContent(files, secondDestination);
        }
            threadPool,
            recoverySettings  
import org.apache.lucene.store.IOContext;
            () -> blockingListener.actionGet(TimeValue.timeValueMillis(500))
            downloader.downloadAsync(new CancellableThreads(), remoteSource, target, expected.keySet(), future);  
            threadPool,
import java.util.List;  
        final long partSize = ByteSizeUnit.MB.toBytes(1);  
import org.opensearch.core.common.unit.ByteSizeUnit;
                .put("indices.recovery.max_concurrent_remote_store_streams", randomIntBetween(1, 4))
    private Directory secondDestination;
        // Note that Lucene will randomly write extra files (see org.apache.lucene.tests.mockfile.ExtraFS)
                    in.readBytes(actual, 0, actual.length);  
        }
        final int maxParts = randomIntBetween(1, 6);
            assertTrue(actualFiles.contains(file));  
    private Map<String, Integer> files = new HashMap<>();  
                try {
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
    @After
        };
import org.apache.lucene.store.IndexOutput;  
        );
        assertContent(files, destination);
import java.util.ArrayList;  
        // so we just need to check that all the expected files are present but not that _only_ the expected
import org.opensearch.common.blobstore.fs.FsBlobContainer;  
            public void onResponse(Void unused) {}
 * SPDX-License-Identifier: Apache-2.0
    }  
            ShardId.fromString("[RemoteStoreFileDownloaderTests][0]"),
                    Thread.sleep(60_000); // Will be interrupted  
     */
 *
            future.actionGet();
        assertContent(files, destination);
        }
            }
        }
                .put("indices.recovery.remote_store.parallel_download.part_size", new ByteSizeValue(partSize))  
        secondDestination = new NIOFSDirectory(createTempDir());  
import org.apache.lucene.codecs.CodecUtil;
        final CountDownLatch latch = new CountDownLatch(1);
                output.writeInt(content);
            @Override
        assertThrows(IOException.class, () -> fileDownloader.download(source, failureDirectory, null, files.keySet(), () -> {}));  
        source = new NIOFSDirectory(createTempDir());
                latch.countDown();
            assertThat(remoteSource.fileLength(name), greaterThan(partSize));
        final ParallelDownloadPermits permits = recoverySettings.getRemoteStoreParallelDownloadPermits();  
        final AtomicInteger wholeReads = new AtomicInteger();  
import java.nio.file.NoSuchFileException;
            final String filename = "file_" + i;
            new FsBlobContainer(new FsBlobStore(8 * 1024, blobPath, false), BlobPath.cleanPath(), blobPath)
        final CountDownLatch latch = new CountDownLatch(1);
    public void testDownloadWithSecondDestination() throws IOException, InterruptedException {
            ShardId.fromString("[RemoteStoreFileDownloaderTests][0]"),  
                } else if (i == 3) {  
        );
        final RemoteStoreFileDownloader downloader = new RemoteStoreFileDownloader(
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
                .put("indices.recovery.remote_store.parallel_download.max_concurrent_parts", 0)
    }
        final RecoverySettings recoverySettings = new RecoverySettings(  
            downloader.downloadAsync(new CancellableThreads(), remoteSource, target, Set.of(name), future);
        final RecoverySettings recoverySettings = new RecoverySettings(
        assertEquals("small files use the single-stream path", expected.size() - multiPartFiles.size(), blobContainer.wholeReads.get());  
            threadPool,
            return super.readBlob(blobName, position, length);
            CancellableThreads.ExecutionCancelledException.class,
        @Override  
            @Override  
        return permits.availablePermits();
        for (String file : expected.keySet()) {
        assertEquals("all prefetch permits returned", maxParts, permits.getMaxPermits());
            recoverySettings
    public void testMultiPartDownloadFromRemoteSegmentStoreDirectory() throws Exception {  
        assertContent(files, destination);
            try (IndexOutput output = source.createOutput(filename, IOContext.DEFAULT)) {
        }
        cancellableThreads.cancel("test");
            files.put(filename, content);
import org.junit.After;
        );
        fileDownloader = new RemoteStoreFileDownloader(  
import org.opensearch.core.action.ActionListener;
/*  
        final RangeCountingBlobContainer blobContainer = new RangeCountingBlobContainer(
        }
                    fail("Expected to be interrupted");  
    }  
                assertEquals(NoSuchFileException.class, e.getClass());
        }
            }
        );  
import org.opensearch.common.blobstore.support.FilterBlobContainer;
            mock(RemoteStoreLockManager.class),  
import org.opensearch.indices.recovery.RecoverySettings;  
import java.util.concurrent.CountDownLatch;  
    }
        final CountDownLatch latch = new CountDownLatch(1);
import org.apache.lucene.store.Directory;
            blockingListener::actionGet
                try {
    public void testDownloadWithFileCompletionHandler() throws IOException, InterruptedException {
            ShardId.fromString("[RemoteStoreFileDownloaderTests][0]")
        }
            mock(RemoteDirectory.class),
        assertEquals(1, blobContainer.wholeReads.get());  
            try {
                final byte[] bytes = randomByteArrayOfLength(payload);
        });
            final int content = randomInt();  
            remoteSource.copyFrom(local, name, name, IOContext.DEFAULT);
            public void onFailure(Exception e) {
            }
                    payload = randomIntBetween((int) partSize + 1, (int) (partSize * 3));
        protected BlobContainer wrapChild(BlobContainer child) {
        }  
    public void testDownloadExtraNonExistentFile() throws InterruptedException {  
        assertEquals("one range request per part of every large file", expectedRangeReads, blobContainer.rangeReads.get());
import org.opensearch.common.settings.ClusterSettings;  
            public void onFailure(Exception e) {
        fileDownloader.download(source, destination, secondDestination, files.keySet(), () -> {});  
                }
        assertThrows(
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
    }  
        filesWithExtra.add("not real");  
        final Path blobPath = createTempDir();
        thread.join();
        }
        assertThrows(
                CodecUtil.writeFooter(out);
                try (IndexInput in = local.openInput(name, IOContext.READONCE)) {
    }
        final Directory blockingDestination = new FilterDirectory(destination) {
        );
            try (IndexInput input = destination.openInput(file, IOContext.DEFAULT)) {
        final Set<String> actualFiles = Set.of(destination.listAll());
                final int payload;
    public void stopThreadPool() throws Exception {
        );
                out.writeBytes(bytes, bytes.length);
import org.apache.lucene.store.IndexInput;
        final Path blobPath = createTempDir();
import java.util.concurrent.atomic.AtomicReference;  
        l.actionGet();
        try (Directory target = new NIOFSDirectory(createTempDir())) {
 * compatible open source license.
            }  
                final String name = "_" + i + ".dat";
        blobContainer.rangeReads.set(0);  
import org.opensearch.common.unit.TimeValue;
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();  
                throw new IOException("test");  
        assertEquals(files.size(), counter.get());  
    private static void assertContent(Map<String, Integer> expected, Directory destination) throws IOException {  
        fileDownloader.downloadAsync(new CancellableThreads(), source, failureDirectory, files.keySet(), new ActionListener<>() {  
import org.opensearch.OpenSearchTimeoutException;
    public void testBlockingCallCanBeInterrupted() throws Exception {  
        final Map<String, byte[]> expected = new HashMap<>();  
        });
            }
                try (IndexInput in = target.openInput(entry.getKey(), IOContext.READONCE)) {
    }
        final AtomicInteger counter = new AtomicInteger(0);  
        final CancellableThreads cancellableThreads = new CancellableThreads();  
import org.opensearch.threadpool.ThreadPool;  
                try (IndexOutput out = local.createOutput(name, IOContext.DEFAULT)) {  
    }
            public void onFailure(Exception e) {  
            threadPool,  
import org.opensearch.common.blobstore.fs.FsBlobStore;
        for (int i = 0; i < 10; i++) {
        final Directory failureDirectory = new FilterDirectory(destination) {  
                    final byte[] onDisk = new byte[(int) in.length()];
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        final Set<String> multiPartFiles = new HashSet<>();
            assertEquals(remoteSource.fileLength(name), target.fileLength(name));  
    public void setup() throws IOException {  
        fileDownloader.downloadAsync(new CancellableThreads(), source, destination, files.keySet(), l);  
            @Override
            for (int i = 0; i < 6; i++) {  
        final RangeCountingBlobContainer blobContainer = new RangeCountingBlobContainer(  
        destination = new NIOFSDirectory(createTempDir());
                } catch (InterruptedException e) {
            }  
     * downloaded as multiple concurrent byte-range requests, land byte-identical in the destination, and hand back  
                }
        thread.interrupt();  
            new FsBlobContainer(new FsBlobStore(8 * 1024, blobPath, false), BlobPath.cleanPath(), blobPath)  
    private Directory destination;  
            try (IndexOutput out = local.createOutput(name, IOContext.DEFAULT)) {  
                } else {
        @Override
                fileDownloader.download(source, blockingDestination, null, files.keySet(), () -> {});  
    }
        for (String name : multiPartFiles) {  
     * Files larger than the configured part size that live in a {@link RemoteSegmentStoreDirectory} must be
        RangeCountingBlobContainer(BlobContainer delegate) {
                    expected.put(name, onDisk);
        fileDownloader.downloadAsync(new CancellableThreads(), source, destination, filesWithExtra, new ActionListener<>() {
            public void onResponse(Void unused) {}
                assertEquals(expected.get(file), Integer.valueOf(input.readInt()));
    private Directory source;
            return super.readBlob(blobName);
        final Directory blockingDestination = new FilterDirectory(destination) {
import java.util.HashSet;
            new RemoteDirectory(blobContainer),  
        assertEquals(InterruptedException.class, capturedException.get().getClass());
package org.opensearch.index.store;
                assertEquals(NoSuchFileException.class, e.getClass());
            }
        );  
            threadPool,
import java.nio.file.Path;
        @Override
import java.io.EOFException;
            rangeReads.incrementAndGet();
                    payload = (int) partSize - CodecUtil.footerLength(); // exactly one part including the footer
        fileDownloader.downloadAsync(cancellableThreads, source, blockingDestination, files.keySet(), blockingListener);
    public void testMultiPartDownloadDisabledWithZeroBudget() throws Exception {
    }
    public void testDownloadNonExistentFile() throws InterruptedException {  
import org.opensearch.threadpool.TestThreadPool;
            public void copyFrom(Directory from, String src, String dest, IOContext context) {
                    Thread.sleep(60_000); // Will be interrupted
        final int streamLimit = randomIntBetween(1, 20);
        final AtomicReference<Exception> capturedException = new AtomicReference<>();  
                remoteSource.copyFrom(local, name, name, IOContext.DEFAULT);  
import org.opensearch.core.index.shard.ShardId;
            ShardId.fromString("[RemoteStoreFileDownloaderTests][0]"),  
            @Override
    private static final class RangeCountingBlobContainer extends FilterBlobContainer {
                capturedException.set(e);
import java.util.concurrent.atomic.AtomicInteger;
                assertThrows(EOFException.class, input::readByte);  
        final String name = "_big.dat";  
        public InputStream readBlob(String blobName, long position, long length) throws IOException {  
                    fail("Expected to be interrupted");
            Settings.builder()
            expectedRangeReads += (length + partSize - 1) / partSize;  
    public void testIOException() throws IOException, InterruptedException {
                }
import org.apache.lucene.store.NIOFSDirectory;
        final AtomicInteger rangeReads = new AtomicInteger();
            @Override
                    payload = randomIntBetween(1, 4096);  
import org.junit.Before;
        threadPool.shutdown();  
     * every prefetch permit afterwards. Files no larger than one part must keep using the single-stream path.
    private ThreadPool threadPool;
            mock(RemoteStoreLockManager.class),
            mock(RemoteDirectory.class),
                    out.writeBytes(bytes, bytes.length);
 */  
        final RemoteStoreFileDownloader downloader = new RemoteStoreFileDownloader(
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        );  
 * The OpenSearch Contributors require contributions made to  
            for (Map.Entry<String, byte[]> entry : expected.entrySet()) {  
        });  
            @Override
    }  
        final RemoteSegmentStoreDirectory remoteSource = new RemoteSegmentStoreDirectory(  
                .build(),
            ShardId.fromString("[RemoteStoreFileDownloaderTests][0]")
        final RecoverySettings recoverySettings = new RecoverySettings(
        public InputStream readBlob(String blobName) throws IOException {  
                    assertArrayEquals("content of " + entry.getKey(), entry.getValue(), actual);
        assertTrue(latch.await(10, TimeUnit.SECONDS));
            public void copyFrom(Directory from, String src, String dest, IOContext context) {  
        final List<String> filesWithExtra = new ArrayList<>(files.keySet());
                    // The downloaded file must still carry a valid Lucene footer, i.e. checksum verification works.
    public void testDownload() throws IOException {
                .build(),
        final byte[] bytes = randomByteArrayOfLength((int) partSize * 2 + 17);
            "Expected to complete with cancellation failure",  
            @Override  
import org.opensearch.test.OpenSearchTestCase;
                    CodecUtil.writeFooter(out);
            }
            recoverySettings
import java.io.InputStream;  
        final RemoteSegmentStoreDirectory remoteSource = new RemoteSegmentStoreDirectory(
                }
        blobContainer.rangeReads.set(0);  
        final long partSize = ByteSizeUnit.MB.toBytes(1);

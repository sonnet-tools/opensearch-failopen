            return super.readBlob(blobName);
import org.apache.lucene.store.IOContext;
import org.opensearch.common.blobstore.fs.FsBlobContainer;
    }
    }
import org.opensearch.threadpool.TestThreadPool;
                    // The downloaded file must still carry a valid Lucene footer, i.e. checksum verification works.
import static org.hamcrest.Matchers.greaterThan;
            }
        blobContainer.wholeReads.set(0);
            }
        // Upload a mix of files: some spanning several parts, some exactly one part, some tiny.
        assertContent(files, destination);
    private static final class RangeCountingBlobContainer extends FilterBlobContainer {
                    Thread.sleep(60_000); // Will be interrupted
        assertEquals("small files use the single-stream path", expected.size() - multiPartFiles.size(), blobContainer.wholeReads.get());
        assertContent(files, secondDestination);
        RangeCountingBlobContainer(BlobContainer delegate) {
import java.nio.file.Path;
    }
        try (Directory target = new NIOFSDirectory(createTempDir())) {
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        final Map<String, byte[]> expected = new HashMap<>();
import org.apache.lucene.store.IndexOutput;
import java.util.List;
                    in.readBytes(onDisk, 0, onDisk.length);
        assertTrue(threadPool.awaitTermination(5, TimeUnit.SECONDS));
import java.util.concurrent.atomic.AtomicReference;
            downloader.downloadAsync(new CancellableThreads(), remoteSource, target, expected.keySet(), future);
                final String name = "_" + i + ".dat";
                    throw new RuntimeException("Failed due to interrupt", e);
        fileDownloader.downloadAsync(new CancellableThreads(), source, destination, Set.of("not real"), new ActionListener<>() {
            ShardId.fromString("[RemoteStoreFileDownloaderTests][0]"),
    public void testDownloadWithFileCompletionHandler() throws IOException, InterruptedException {
        fileDownloader.downloadAsync(new CancellableThreads(), source, destination, files.keySet(), l);
        }
                latch.countDown();
        final int maxParts = randomIntBetween(1, 6);
        final ParallelDownloadPermits permits = recoverySettings.getRemoteStoreParallelDownloadPermits();
                    fail("Expected to be interrupted");
                assertThrows(EOFException.class, input::readByte);
    private Directory source;
            return super.readBlob(blobName, position, length);
                try (IndexInput in = target.openInput(entry.getKey(), IOContext.READONCE)) {
import org.opensearch.common.unit.TimeValue;
            expectedRangeReads += (length + partSize - 1) / partSize;
            new RemoteDirectory(blobContainer),
        long expectedRangeReads = 0;
                capturedException.set(e);
            files.put(filename, content);
        }
        assertEquals("all prefetch permits returned", maxParts, permits.getMaxPermits());
        final AtomicInteger wholeReads = new AtomicInteger();
                } catch (InterruptedException e) {
                latch.countDown();
                try (IndexOutput out = local.createOutput(name, IOContext.DEFAULT)) {
 * this file be licensed under the Apache-2.0 license or a
            future.actionGet();
            Settings.builder().put("indices.recovery.max_concurrent_remote_store_streams", streamLimit).build(),
            wholeReads.incrementAndGet();
        secondDestination = new NIOFSDirectory(createTempDir());
import org.opensearch.core.action.ActionListener;
        final List<String> filesWithExtra = new ArrayList<>(files.keySet());
                    out.writeBytes(bytes, bytes.length);
            mock(RemoteStoreLockManager.class),
            try {
            @Override
            threadPool,
        final AtomicReference<Exception> capturedException = new AtomicReference<>();
    public void testDownload() throws IOException {
                latch.countDown();
            try (IndexInput input = destination.openInput(file, IOContext.DEFAULT)) {
    /**
        final Directory blockingDestination = new FilterDirectory(destination) {
        final Path blobPath = createTempDir();
        final RecoverySettings recoverySettings = new RecoverySettings(
        for (String name : multiPartFiles) {
import org.junit.After;
        assertTrue(latch.await(10, TimeUnit.SECONDS));
            ShardId.fromString("[RemoteStoreFileDownloaderTests][0]")
            @Override
            }
                }
        assertEquals(1, blobContainer.wholeReads.get());
            ShardId.fromString("[RemoteStoreFileDownloaderTests][0]"),
                } else {
        );
                    in.readBytes(actual, 0, actual.length);
            threadPool,
        fileDownloader.downloadAsync(new CancellableThreads(), source, failureDirectory, files.keySet(), new ActionListener<>() {
        blobContainer.wholeReads.set(0);
            public void copyFrom(Directory from, String src, String dest, IOContext context) {
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
import org.opensearch.common.blobstore.support.FilterBlobContainer;
            () -> blockingListener.actionGet(TimeValue.timeValueMillis(500))
                    fail("Expected to be interrupted");
                .put("indices.recovery.remote_store.parallel_download.part_size", new ByteSizeValue(partSize))
                    payload = randomIntBetween(1, 4096);
    }
import java.util.HashSet;
import org.opensearch.core.common.unit.ByteSizeValue;
            for (int i = 0; i < 6; i++) {
        );
        public InputStream readBlob(String blobName, long position, long length) throws IOException {
import org.apache.lucene.store.FilterDirectory;
        );
        final RecoverySettings recoverySettings = new RecoverySettings(
            mock(RemoteStoreLockManager.class),
        }
                    Thread.sleep(60_000); // Will be interrupted
            @Override
                    in.seek(0);
     * Files larger than the configured part size that live in a {@link RemoteSegmentStoreDirectory} must be
            threadPool,
    public void setup() throws IOException {
                out.writeBytes(bytes, bytes.length);
                    throw new RuntimeException("Failed due to interrupt", e);
            @Override
        );
        );
    }
                if (i < 3) {
        }
    public void testMultiPartDownloadFromRemoteSegmentStoreDirectory() throws Exception {
import org.opensearch.common.blobstore.BlobPath;
        );
        protected BlobContainer wrapChild(BlobContainer child) {
        final Thread thread = new Thread(() -> {
        thread.start();
    }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        @Override
            }
        });
                output.writeInt(content);
        });
        blobContainer.rangeReads.set(0);
    }
            mock(RemoteDirectory.class),
                }
            }
            threadPool,
            @Override
        assertEquals("one range request per part of every large file", expectedRangeReads, blobContainer.rangeReads.get());
        final AtomicInteger counter = new AtomicInteger(0);
            public void onResponse(Void unused) {}
    @Before
import org.opensearch.common.settings.ClusterSettings;
    }
        final RangeCountingBlobContainer blobContainer = new RangeCountingBlobContainer(
            Settings.builder()
    public void stopThreadPool() throws Exception {
                } else if (i == 3) {
            final long length = expected.get(name).length;
            new FsBlobContainer(new FsBlobStore(8 * 1024, blobPath, false), BlobPath.cleanPath(), blobPath)
        });
import org.apache.lucene.store.Directory;
        // files are present
        final byte[] bytes = randomByteArrayOfLength((int) partSize * 2 + 17);
            recoverySettings
     * downloaded as multiple concurrent byte-range requests, land byte-identical in the destination, and hand back
            blockingListener::actionGet
                assertEquals(expected.get(file), Integer.valueOf(input.readInt()));
        );
                    CodecUtil.checksumEntireFile(in);
        }
    }
    private Directory secondDestination;
                    payload = randomIntBetween((int) partSize + 1, (int) (partSize * 3));
    public void testCancellable() {
        public InputStream readBlob(String blobName) throws IOException {
        threadPool = new TestThreadPool(getTestName());
    public void testDownloadWithSecondDestination() throws IOException, InterruptedException {
import static org.mockito.Mockito.mock;
        assertBusy(() -> assertEquals(maxParts, availablePermits(permits)));
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
    @After
import org.opensearch.test.OpenSearchTestCase;
            }
            assertThat(remoteSource.fileLength(name), greaterThan(partSize));
        );
        final Set<String> actualFiles = Set.of(destination.listAll());
            public void onFailure(Exception e) {
import java.io.IOException;
        assertEquals(0, blobContainer.rangeReads.get());
import java.util.Set;
                final byte[] bytes = randomByteArrayOfLength(payload);
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
            assertTrue(actualFiles.contains(file));
            assertEquals(remoteSource.fileLength(name), target.fileLength(name));
    private static void assertContent(Map<String, Integer> expected, Directory destination) throws IOException {
            future.actionGet();
        final RemoteStoreFileDownloader downloader = new RemoteStoreFileDownloader(
import java.nio.file.NoSuchFileException;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            try (IndexOutput out = local.createOutput(name, IOContext.DEFAULT)) {
    private static int availablePermits(ParallelDownloadPermits permits) {
package org.opensearch.index.store;
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        fileDownloader.downloadAsync(cancellableThreads, source, blockingDestination, files.keySet(), blockingListener);
        }
        final String name = "_big.dat";
                CodecUtil.writeFooter(out);
import org.apache.lucene.store.IndexInput;
    }
            } catch (Exception e) {
        final RemoteSegmentStoreDirectory remoteSource = new RemoteSegmentStoreDirectory(
    private RemoteStoreFileDownloader fileDownloader;
                }
            ShardId.fromString("[RemoteStoreFileDownloaderTests][0]")
            Settings.builder()
                assertEquals(NoSuchFileException.class, e.getClass());
        for (int i = 0; i < 10; i++) {
import org.opensearch.action.support.PlainActionFuture;
                    payload = (int) partSize - CodecUtil.footerLength(); // exactly one part including the footer
        final CountDownLatch latch = new CountDownLatch(1);
        final PlainActionFuture<Void> blockingListener = new PlainActionFuture<>();
 */
        @Override
import org.opensearch.common.util.CancellableThreads;
        assertThrows(
            try (IndexOutput output = source.createOutput(filename, IOContext.DEFAULT)) {
        final Directory blockingDestination = new FilterDirectory(destination) {
            recoverySettings
            @Override
            public void onResponse(Void unused) {}
        final Directory failureDirectory = new FilterDirectory(destination) {
        final CancellableThreads cancellableThreads = new CancellableThreads();
import org.opensearch.OpenSearchTimeoutException;
 * SPDX-License-Identifier: Apache-2.0
            recoverySettings
        }
        }
import org.opensearch.common.blobstore.BlobContainer;
        return permits.availablePermits();
        final CountDownLatch latch = new CountDownLatch(1);
                assertEquals(IOException.class, e.getClass());
    }
import org.opensearch.core.common.unit.ByteSizeUnit;
                    final byte[] actual = new byte[(int) in.length()];
                }
                    final byte[] onDisk = new byte[(int) in.length()];
import org.opensearch.core.index.shard.ShardId;
                .put("indices.recovery.remote_store.parallel_download.max_concurrent_parts", maxParts)
                .put("indices.recovery.max_concurrent_remote_store_streams", randomIntBetween(1, 4))
        );
        try (Directory local = new NIOFSDirectory(createTempDir())) {
                final int payload;
                    assertArrayEquals("content of " + entry.getKey(), entry.getValue(), actual);
        for (String name : multiPartFiles) {
        fileDownloader.download(source, destination, secondDestination, files.keySet(), () -> {});
            }
 * compatible open source license.
import org.apache.lucene.codecs.CodecUtil;
    }
        };
        );
        fileDownloader.download(source, destination, null, files.keySet(), counter::incrementAndGet);
            downloader.downloadAsync(new CancellableThreads(), remoteSource, target, Set.of(name), future);
        for (String file : expected.keySet()) {
    public void testDownloadNonExistentFile() throws InterruptedException {
                }
        destination = new NIOFSDirectory(createTempDir());
        final RangeCountingBlobContainer blobContainer = new RangeCountingBlobContainer(
            new RemoteDirectory(blobContainer),
        @Override
            mock(RemoteDirectory.class),
        l.actionGet();
        assertEquals(InterruptedException.class, capturedException.get().getClass());
import java.util.ArrayList;
public class RemoteStoreFileDownloaderTests extends OpenSearchTestCase {
    private Directory destination;
        });
            @Override
        threadPool.shutdown();
                .put("indices.recovery.remote_store.parallel_download.part_size", new ByteSizeValue(partSize))
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
                fileDownloader.download(source, blockingDestination, null, files.keySet(), () -> {});
    }
}
        assertThrows(IOException.class, () -> fileDownloader.download(source, failureDirectory, null, files.keySet(), () -> {}));
        final RemoteStoreFileDownloader downloader = new RemoteStoreFileDownloader(
        );
        final RecoverySettings recoverySettings = new RecoverySettings(
            public void copyFrom(Directory from, String src, String dest, IOContext context) {
            ShardId.fromString("[RemoteStoreFileDownloaderTests][0]"),
            return child;
import org.junit.Before;
                try {
                remoteSource.copyFrom(local, name, name, IOContext.DEFAULT);
        assertEquals(files.size(), counter.get());
 * The OpenSearch Contributors require contributions made to
        fileDownloader.downloadAsync(new CancellableThreads(), source, destination, filesWithExtra, new ActionListener<>() {
import org.opensearch.common.blobstore.fs.FsBlobStore;
            public void onFailure(Exception e) {
        };
                    CodecUtil.writeFooter(out);
 *
     */
                try (IndexInput in = local.openInput(name, IOContext.READONCE)) {
        final Path blobPath = createTempDir();
        final PlainActionFuture<Void> l = new PlainActionFuture<>();
            "Expected to timeout due to blocking directory",
    public void testMultiPartDownloadDisabledWithZeroBudget() throws Exception {
            CancellableThreads.ExecutionCancelledException.class,
                .put("indices.recovery.remote_store.parallel_download.max_concurrent_parts", 0)
        assertThrows(
import org.opensearch.threadpool.ThreadPool;
        try (Directory local = new NIOFSDirectory(createTempDir())) {
                .build(),
            rangeReads.incrementAndGet();
            @Override
        assertContent(files, destination);
        cancellableThreads.cancel("test");
import java.util.Map;
            @Override
        fileDownloader = new RemoteStoreFileDownloader(
                    multiPartFiles.add(name);
            }
import org.opensearch.common.settings.Settings;
import java.io.InputStream;
            for (Map.Entry<String, byte[]> entry : expected.entrySet()) {
                    expected.put(name, onDisk);
        );
        filesWithExtra.add("not real");
        }
    public void testIOException() throws IOException, InterruptedException {
            super(delegate);
        final long partSize = ByteSizeUnit.MB.toBytes(1);
            final String filename = "file_" + i;
import java.io.EOFException;
        final AtomicInteger rangeReads = new AtomicInteger();
                try {
import java.util.HashMap;
                }
            }
    private Map<String, Integer> files = new HashMap<>();
        // so we just need to check that all the expected files are present but not that _only_ the expected
                .build(),
        final RemoteSegmentStoreDirectory remoteSource = new RemoteSegmentStoreDirectory(
        try (Directory target = new NIOFSDirectory(createTempDir())) {
            threadPool,
                assertEquals(NoSuchFileException.class, e.getClass());
        }
        blobContainer.rangeReads.set(0);
import org.opensearch.indices.recovery.RecoverySettings;
    }
            }
        thread.join();
        final Set<String> multiPartFiles = new HashSet<>();
    private ThreadPool threadPool;
            }
        thread.interrupt();
                throw new IOException("test");
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        final long partSize = ByteSizeUnit.MB.toBytes(1);
            public void copyFrom(Directory from, String src, String dest, IOContext context) throws IOException {
        source = new NIOFSDirectory(createTempDir());
     * every prefetch permit afterwards. Files no larger than one part must keep using the single-stream path.
        }
        assertContent(files, destination);
/*
            "Expected to complete with cancellation failure",
            public void onResponse(Void unused) {}
            new FsBlobContainer(new FsBlobStore(8 * 1024, blobPath, false), BlobPath.cleanPath(), blobPath)
            remoteSource.copyFrom(local, name, name, IOContext.DEFAULT);
        };
            }
        final int streamLimit = randomIntBetween(1, 20);
    public void testDownloadExtraNonExistentFile() throws InterruptedException {
            public void onFailure(Exception e) {
        final CountDownLatch latch = new CountDownLatch(1);
        // Note that Lucene will randomly write extra files (see org.apache.lucene.tests.mockfile.ExtraFS)
            final int content = randomInt();
            OpenSearchTimeoutException.class,
    public void testBlockingCallCanBeInterrupted() throws Exception {
        }
                } catch (InterruptedException e) {
    }
import org.apache.lucene.store.NIOFSDirectory;
import java.util.concurrent.TimeUnit;

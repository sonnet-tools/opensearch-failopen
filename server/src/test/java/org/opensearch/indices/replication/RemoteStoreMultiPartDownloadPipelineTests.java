import java.util.concurrent.ConcurrentHashMap;
                    final byte[] actual = new byte[(int) in.length()];
            new FsBlobContainer(new FsBlobStore(8 * 1024, blobPath, false), BlobPath.cleanPath(), blobPath)
            final long totalBytes = expected.values().stream().mapToLong(b -> b.length).sum();
                    final byte[] onDisk = new byte[(int) in.length()];
                }
import java.nio.file.Path;
 */
    private static final ShardId SHARD_ID = ShardId.fromString("[index][0]");
                }
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
 * </ul>
import static org.hamcrest.Matchers.greaterThan;
            }
        final Map<String, AtomicInteger> progressCalls = new ConcurrentHashMap<>();
import org.opensearch.action.support.PlainActionFuture;
            wholeReads.set(0);
import org.opensearch.test.DummyShardLock;
package org.opensearch.indices.replication;
    // ---------------------------------------------------------------------------------------------------------------
    public void testReplicationStatsRecordFailedMultiPartDownload() throws Exception {
                    progressCalls.computeIfAbsent(name, k -> new AtomicInteger()).incrementAndGet();
            // ...and is reported incrementally while the large file streams, not once at the end.
import org.opensearch.test.OpenSearchTestCase;
            downloader.downloadAsync(new CancellableThreads(), remoteSource, destination, expected.keySet(), future);
            // The store-level transfer tracker (behind the remote_store.download node stats) saw the same bytes.
            assertNotNull("expected a CorruptIndexException from write-time verification, got " + e, unwrapCorruption(e));
            return super.readBlob(blobName, position, length);
            // The small, untouched file is unaffected.
    /**
                return true;
import java.nio.file.Files;
    }
 * <ul>
        // One file spanning 3-4 parts (multi-part path) and one small file (single-stream path), both with real
            final Exception e = expectThrows(Exception.class, future::actionGet);
import org.opensearch.common.blobstore.fs.FsBlobContainer;
    }
        while (t != null) {
            final Exception e = expectThrows(Exception.class, future::actionGet);
 * The OpenSearch Contributors require contributions made to
            final long parts = (expected.get(bigFile).length + PART_SIZE - 1) / PART_SIZE;
     */
                final StoreFileMetadata metadata = new StoreFileMetadata(
        bigFile = "_big.cfs";
                    Store.digestToString(Long.parseLong(uploaded.getChecksum())),
import org.opensearch.threadpool.TestThreadPool;
            future.actionGet();
        blobContainer.failRangeReadsAtOrAbove(remoteSource.getExistingRemoteFilename(bigFile), PART_SIZE);
            t = t.getCause();
        };
            final byte flipped = (byte) (one.get() ^ 0xFF);
    // ---------------------------------------------------------------------------------------------------------------
            SHARD_ID
        );
                final RemoteSegmentStoreDirectory.UploadedSegmentMetadata uploaded = remoteSource.getSegmentsUploadedToRemoteStore()
                remoteSource.copyFrom(local, e.getKey(), e.getKey(), IOContext.DEFAULT);
                .build(),
    private static boolean hasMessageInChain(Throwable t, String needle) {
        }
}
            downloader.downloadAsync(new CancellableThreads(), remoteSource, verifyingDestination(store), Set.of(smallFile), ok);
            final ByteBuffer one = ByteBuffer.allocate(1);
import org.opensearch.common.settings.Settings;
    );
        }
import org.opensearch.common.blobstore.BlobContainer;
import org.opensearch.threadpool.ThreadPool;
        public InputStream readBlob(String blobName, long position, long length) throws IOException {
                    expected.put(e.getKey(), onDisk);
        }
            rangeReads.set(0);
            public void copyFrom(Directory from, String src, String dest, IOContext context) throws IOException {
                    Store.verify(out);
            for (Map.Entry<String, Integer> e : Map.of(
    public void tearDown() throws Exception {
import org.opensearch.index.store.RemoteDirectory;
import java.util.HashMap;
    // Recovery statistics
import org.opensearch.index.store.StoreFileMetadata;
        return new FilterDirectory(store.directory()) {
            return super.readBlob(blobName);
            Settings.builder()
                try (IndexInput in = from.openInput(src, context); IndexOutput out = store.createVerifyingOutput(dest, metadata, context)) {
            final PlainActionFuture<Void> ok = PlainActionFuture.newFuture();
        }
        }
 * the regular {@code Directory#copyFrom} pipeline -- the property that lets the two mechanisms broken by the earlier
            one.flip();
import java.nio.channels.SeekableByteChannel;
 * Each check has a negative control so a silently no-op'd wrapper cannot pass.
import org.opensearch.cluster.metadata.IndexMetadata;
                try (IndexInput in = store.directory().openInput(e.getKey(), IOContext.READONCE)) {
            rangeReads.incrementAndGet();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                .put("indices.recovery.max_concurrent_remote_store_streams", 2)
                try (IndexOutput out = local.createOutput(e.getKey(), IOContext.DEFAULT)) {
                    out.writeBytes(payload, payload.length);
        private volatile String failBlob;
 * compatible open source license.
 *   <li>Lucene checksum verification at write time via {@link Store#createVerifyingOutput}, with no re-read.</li>
                    dest,
        RangeCountingBlobContainer(BlobContainer delegate) {
        downloader = new RemoteStoreFileDownloader(SHARD_ID, threadPool, recoverySettings);
        }
 *
     * Destination that verifies each file at write time the way peer recovery's {@code MultiFileWriter} does: the
            }
        );
import java.io.InputStream;
            ok.actionGet();
                    .get(src);
            ch.position(offset).read(one);
        final AtomicLong rangeBytesRequested = new AtomicLong();
            final DirectoryFileTransferTracker tracker = store.getDirectoryFileTransferTracker();
            ).entrySet()) {
                throw new IOException("injected range read failure for " + blobName + " at " + position);
        blobContainer = new RangeCountingBlobContainer(
    private Directory verifyingDestination(Store store) {
            // Exactly the wrapper RemoteStoreReplicationSource#getSegmentFiles puts around the store directory.
import org.junit.After;
            for (Map.Entry<String, byte[]> e : expected.entrySet()) {
            if (t instanceof CorruptIndexException c) {
        remoteSource = new RemoteSegmentStoreDirectory(
import org.opensearch.index.IndexSettings;
    private String bigFile;
        }
import org.apache.lucene.store.IndexOutput;
                    in.readBytes(onDisk, 0, onDisk.length);
            assertEquals(1, blobContainer.wholeReads.get());
            final Directory destination = new SegmentReplicationSource.ReplicationStatsDirectoryWrapper(store.directory(), (n, b) -> {});
    private final Map<String, byte[]> expected = new HashMap<>();
            this.failBlob = blobName;
        }
                final byte[] payload = randomByteArrayOfLength(e.getValue());
 * multi-stream download (OpenSearch PR #10519) keep working:
import java.util.concurrent.atomic.AtomicLong;
        threadPool = new TestThreadPool(getTestName());
                (name, bytes) -> {
            wholeReads.incrementAndGet();
            future.actionGet();
import org.apache.lucene.codecs.CodecUtil;
        try (Store store = new Store(SHARD_ID, INDEX_SETTINGS, new NIOFSDirectory(createTempDir()), new DummyShardLock(SHARD_ID))) {
        }
            this.failAtOrAbove = position;
import java.util.concurrent.TimeUnit;
import org.opensearch.common.settings.ClusterSettings;
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
        final long offset = PART_SIZE + randomLongBetween(0, PART_SIZE - 1);
 */
import org.apache.lucene.store.FilterDirectory;
            assertEquals(0L, tracker.getTransferredBytesSucceeded());
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
            final Directory destination = new SegmentReplicationSource.ReplicationStatsDirectoryWrapper(
    }
    private String smallFile;
        blobPath = createTempDir();
import org.opensearch.core.index.shard.ShardId;
    public void setup() throws IOException {
            }
    // Checksum verification
import org.opensearch.indices.recovery.RecoverySettings;
import org.opensearch.test.IndexSettingsModule;
import org.opensearch.core.common.unit.ByteSizeUnit;
    }
            }
            downloader.downloadAsync(new CancellableThreads(), remoteSource, destination, Set.of(bigFile), future);
 *       {@code Store.StoreDirectory}'s {@link DirectoryFileTransferTracker}, and</li>
import org.apache.lucene.index.CorruptIndexException;
            rangeBytesRequested.set(0);
        assertTrue(threadPool.awaitTermination(5, TimeUnit.SECONDS));
import org.opensearch.common.blobstore.fs.FsBlobStore;
                randomIntBetween((int) PART_SIZE * 2 + 1, (int) PART_SIZE * 4 - 100),
        // Lucene footers so the remote metadata carries a genuine checksum.
        try (Store store = new Store(SHARD_ID, INDEX_SETTINGS, new NIOFSDirectory(createTempDir()), new DummyShardLock(SHARD_ID))) {
        // Flip one byte in the middle of the SECOND part of the big blob (a prefetched, heap-buffered part), leaving
        // the footer intact -- a footer-only check would miss this; a checksum over the ordered stream must not.
            t = t.getCause();
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
        @Override
import java.nio.file.StandardOpenOption;
        protected BlobContainer wrapChild(BlobContainer child) {
        try (Store store = new Store(SHARD_ID, INDEX_SETTINGS, new NIOFSDirectory(createTempDir()), new DummyShardLock(SHARD_ID))) {
            rangeBytesRequested.addAndGet(length);
            // Verified at write time: every byte of the big file was fetched exactly once, as parts, and never re-read.
import org.apache.lucene.store.IndexInput;
        blobContainer.reset();
                .put("indices.recovery.remote_store.parallel_download.part_size", new ByteSizeValue(PART_SIZE))
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings(
            assertTrue("expected the injected failure in the cause chain, got " + e, hasMessageInChain(e, "injected"));
    // ---------------------------------------------------------------------------------------------------------------
        threadPool.shutdown();
        final Map<String, Long> progressBytes = new ConcurrentHashMap<>();
    private static final class RangeCountingBlobContainer extends FilterBlobContainer {
import java.nio.ByteBuffer;
                    Version.LATEST
     * bytes go through {@link Store#createVerifyingOutput} and {@link Store#verify} is called before close.
            // Per-file progress (the _cat/recovery "bytes recovered" feed) accounts for every byte of every file...
    private RangeCountingBlobContainer blobContainer;
        final RecoverySettings recoverySettings = new RecoverySettings(
    }
    }
                try (IndexInput in = local.openInput(e.getKey(), IOContext.READONCE)) {
        smallFile = "_small.si";
 * End-to-end checks that multi-part parallel downloads from a {@link RemoteSegmentStoreDirectory} still flow through
    // ---------------------------------------------------------------------------------------------------------------
    }
        void reset() {
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
            }
            }
        );
            ch.position(offset).write(ByteBuffer.wrap(new byte[] { flipped }));
import java.util.concurrent.atomic.AtomicInteger;
                randomIntBetween(1, 4096)
/*
import org.opensearch.common.blobstore.BlobPath;
        while (t != null) {
import static org.mockito.Mockito.mock;
            downloader.downloadAsync(new CancellableThreads(), remoteSource, verifyingDestination(store), expected.keySet(), future);
            mock(RemoteStoreLockManager.class),
            assertEquals(totalBytes, tracker.getTransferredBytesSucceeded());
                    progressBytes.merge(name, bytes, Long::sum);
            assertThat(tracker.getLastTransferTimestampMs(), greaterThan(0L));
            assertEquals(expected.get(bigFile).length, tracker.getTransferredBytesStarted());
    }
            if (t.getMessage() != null && t.getMessage().contains(needle)) {
        // Fail the range read of one prefetched part of the big file so the multi-part download itself fails.
        final Path blob = blobPath.resolve(remoteSource.getExistingRemoteFilename(bigFile));
            downloader.downloadAsync(new CancellableThreads(), remoteSource, verifyingDestination(store), Set.of(bigFile), future);
    public void testReplicationStatsAreReportedForMultiPartDownloads() throws Exception {
        return false;
        try (SeekableByteChannel ch = Files.newByteChannel(blob, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
        try (Directory local = new NIOFSDirectory(createTempDir())) {
import org.opensearch.index.store.DirectoryFileTransferTracker;
import org.opensearch.common.blobstore.support.FilterBlobContainer;
    /** local file name -> expected on-disk bytes (payload + Lucene footer) */
    public void testWriteTimeChecksumVerificationPassesWithoutReReadingTheFile() throws Exception {
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
            return child;
        }
    private ThreadPool threadPool;
        void failRangeReadsAtOrAbove(String blobName, long position) {
import org.apache.lucene.store.NIOFSDirectory;
            assertEquals(0L, tracker.getTransferredBytesFailed());
            assertEquals(1, blobContainer.wholeReads.get());
            assertEquals(expected.get(bigFile).length, tracker.getTransferredBytesFailed());
        @Override
    }
            final DirectoryFileTransferTracker tracker = store.getDirectoryFileTransferTracker();
            if (blobName.equals(failBlob) && position >= failAtOrAbove) {
    private static CorruptIndexException unwrapCorruption(Throwable t) {
                );
                    CodecUtil.writeFooter(out);
            assertThat(progressCalls.get(bigFile).get(), greaterThan(1));
import java.util.Set;
            // The big file really went through the multi-part path.
            assertEquals(parts, blobContainer.rangeReads.get());
    private RemoteStoreFileDownloader downloader;
    private static final long PART_SIZE = ByteSizeUnit.MB.toBytes(1);
            mock(RemoteDirectory.class),
    @Before
import org.junit.Before;
    public void testWriteTimeChecksumVerificationDetectsCorruptionInsideAPrefetchedPart() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
                    assertArrayEquals(e.getValue(), actual);
                return c;
                    in.seek(0);
        final AtomicInteger wholeReads = new AtomicInteger();
    // ---------------------------------------------------------------------------------------------------------------
                bigFile,
    @After
import org.opensearch.common.util.CancellableThreads;
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
        return null;
                .put("indices.recovery.remote_store.parallel_download.max_concurrent_parts", randomIntBetween(2, 6))
            super(delegate);
            threadPool,
        public InputStream readBlob(String blobName) throws IOException {
            for (Map.Entry<String, byte[]> e : expected.entrySet()) {
import org.apache.lucene.store.Directory;
import org.opensearch.index.store.Store;
        }
    }
            assertEquals(expected.get(bigFile).length, blobContainer.rangeBytesRequested.get());
        @Override
        }
            }
import org.opensearch.index.store.RemoteStoreFileDownloader;
/**
import org.opensearch.core.common.unit.ByteSizeValue;
        private volatile long failAtOrAbove = Long.MAX_VALUE;
        "index",
            assertThat(blobContainer.rangeReads.get(), greaterThan(1));
                    out.copyBytes(in, in.length());
            );
        try (Store store = new Store(SHARD_ID, INDEX_SETTINGS, new NIOFSDirectory(createTempDir()), new DummyShardLock(SHARD_ID))) {
        }
    private RemoteSegmentStoreDirectory remoteSource;
import java.io.IOException;
 *   <li>recovery / replication statistics, produced by {@code ReplicationStatsDirectoryWrapper} and
                store.directory(),
                    CodecUtil.checksumEntireFile(in);
                }
                    in.readBytes(actual, 0, actual.length);
                }
            new RemoteDirectory(blobContainer),
            @Override
    private Path blobPath;
import org.apache.lucene.store.IOContext;
        Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT).build()
        super.tearDown();
import org.apache.lucene.util.Version;
            assertEquals(totalBytes, tracker.getTransferredBytesStarted());
                smallFile,
                }
                    uploaded.getLength(),
                assertEquals("progress bytes for " + e.getKey(), (long) e.getValue().length, (long) progressBytes.get(e.getKey()));
public class RemoteStoreMultiPartDownloadPipelineTests extends OpenSearchTestCase {
        }
        final AtomicInteger rangeReads = new AtomicInteger();

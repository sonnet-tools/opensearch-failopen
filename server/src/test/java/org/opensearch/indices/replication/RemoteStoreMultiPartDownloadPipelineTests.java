                    in.seek(0);
                    Store.digestToString(Long.parseLong(uploaded.getChecksum())),
        };  
        final Path blob = blobPath.resolve(remoteSource.getExistingRemoteFilename(bigFile));  
            assertTrue("expected the injected failure in the cause chain, got " + e, hasMessageInChain(e, "injected"));
            return super.readBlob(blobName, position, length);  
            return child;
                    progressBytes.merge(name, bytes, Long::sum);  
    @Before
                .put("indices.recovery.remote_store.parallel_download.max_concurrent_parts", randomIntBetween(2, 6))
            if (t.getMessage() != null && t.getMessage().contains(needle)) {
import org.apache.lucene.store.IOContext;
 *       {@code Store.StoreDirectory}'s {@link DirectoryFileTransferTracker}, and</li>
import org.opensearch.index.IndexSettings;
        void reset() {
                return c;
        try (Store store = new Store(SHARD_ID, INDEX_SETTINGS, new NIOFSDirectory(createTempDir()), new DummyShardLock(SHARD_ID))) {
        }
            final Exception e = expectThrows(Exception.class, future::actionGet);
            final ByteBuffer one = ByteBuffer.allocate(1);  
            final long totalBytes = expected.values().stream().mapToLong(b -> b.length).sum();  
        final AtomicInteger wholeReads = new AtomicInteger();
    }
import org.apache.lucene.store.NIOFSDirectory;
 *   <li>recovery / replication statistics, produced by {@code ReplicationStatsDirectoryWrapper} and  
            assertEquals(parts, blobContainer.rangeReads.get());
/*  
            final long parts = (expected.get(bigFile).length + PART_SIZE - 1) / PART_SIZE;
        }
import org.opensearch.common.blobstore.support.FilterBlobContainer;
        final AtomicLong rangeBytesRequested = new AtomicLong();
import org.opensearch.common.settings.Settings;  
        final long offset = PART_SIZE + randomLongBetween(0, PART_SIZE - 1);
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
            @Override  
import org.opensearch.test.IndexSettingsModule;  
        // the footer intact -- a footer-only check would miss this; a checksum over the ordered stream must not.
            downloader.downloadAsync(new CancellableThreads(), remoteSource, destination, Set.of(bigFile), future);  
import org.opensearch.index.store.RemoteDirectory;
        final AtomicInteger rangeReads = new AtomicInteger();  
    }
import java.util.concurrent.atomic.AtomicLong;
        final RecoverySettings recoverySettings = new RecoverySettings(
        public InputStream readBlob(String blobName, long position, long length) throws IOException {  
import java.nio.file.Path;  
            downloader.downloadAsync(new CancellableThreads(), remoteSource, destination, expected.keySet(), future);  
    }  
 * SPDX-License-Identifier: Apache-2.0
                    Version.LATEST
                    in.readBytes(actual, 0, actual.length);  
                }
        }
    private RemoteStoreFileDownloader downloader;
import org.opensearch.index.store.Store;
import java.nio.channels.SeekableByteChannel;
import org.opensearch.core.common.unit.ByteSizeUnit;
                final byte[] payload = randomByteArrayOfLength(e.getValue());
            assertEquals(totalBytes, tracker.getTransferredBytesSucceeded());  
import org.opensearch.action.support.PlainActionFuture;
    }
     * bytes go through {@link Store#createVerifyingOutput} and {@link Store#verify} is called before close.
                throw new IOException("injected range read failure for " + blobName + " at " + position);
                try (IndexInput in = local.openInput(e.getKey(), IOContext.READONCE)) {  
            new RemoteDirectory(blobContainer),
            assertEquals(expected.get(bigFile).length, tracker.getTransferredBytesFailed());  
            assertEquals(1, blobContainer.wholeReads.get());  
import org.apache.lucene.store.FilterDirectory;
            }  
        private volatile String failBlob;  
import org.opensearch.test.DummyShardLock;
                bigFile,
                randomIntBetween(1, 4096)
import org.opensearch.index.store.StoreFileMetadata;
        public InputStream readBlob(String blobName) throws IOException {  
            this.failBlob = blobName;
    private static final class RangeCountingBlobContainer extends FilterBlobContainer {
            // The store-level transfer tracker (behind the remote_store.download node stats) saw the same bytes.
            }  
            ch.position(offset).write(ByteBuffer.wrap(new byte[] { flipped }));
import org.opensearch.indices.recovery.RecoverySettings;
            ok.actionGet();  
        try (SeekableByteChannel ch = Files.newByteChannel(blob, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
        }  
 * compatible open source license.
    );
                    out.copyBytes(in, in.length());
    // ---------------------------------------------------------------------------------------------------------------  
            final byte flipped = (byte) (one.get() ^ 0xFF);  
            // The big file really went through the multi-part path.  
        @Override  
                    dest,
import org.opensearch.common.settings.ClusterSettings;
        smallFile = "_small.si";
            assertEquals(totalBytes, tracker.getTransferredBytesStarted());
            wholeReads.incrementAndGet();
            assertThat(blobContainer.rangeReads.get(), greaterThan(1));
            public void copyFrom(Directory from, String src, String dest, IOContext context) throws IOException {
import org.opensearch.threadpool.ThreadPool;  
 *   <li>Lucene checksum verification at write time via {@link Store#createVerifyingOutput}, with no re-read.</li>
    public void testWriteTimeChecksumVerificationDetectsCorruptionInsideAPrefetchedPart() throws Exception {  
            assertEquals(0L, tracker.getTransferredBytesFailed());
        return null;
        );
        }  
import static org.hamcrest.Matchers.greaterThan;
    }  
    private Path blobPath;
                return true;
        }
    }
import static org.mockito.Mockito.mock;
            final DirectoryFileTransferTracker tracker = store.getDirectoryFileTransferTracker();
    /**  
import java.util.HashMap;
            rangeBytesRequested.addAndGet(length);
import org.apache.lucene.store.Directory;  
import org.opensearch.threadpool.TestThreadPool;
        try (Directory local = new NIOFSDirectory(createTempDir())) {  
    private ThreadPool threadPool;  
    private static CorruptIndexException unwrapCorruption(Throwable t) {
        Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT).build()
                    out.writeBytes(payload, payload.length);  
                }
            downloader.downloadAsync(new CancellableThreads(), remoteSource, verifyingDestination(store), Set.of(smallFile), ok);
                    expected.put(e.getKey(), onDisk);  
            }
        // Lucene footers so the remote metadata carries a genuine checksum.  
        while (t != null) {  
    // Recovery statistics
        "index",  
import org.opensearch.common.blobstore.BlobPath;
    private RangeCountingBlobContainer blobContainer;  
        @Override
import java.nio.ByteBuffer;  
                remoteSource.copyFrom(local, e.getKey(), e.getKey(), IOContext.DEFAULT);
    }
        return new FilterDirectory(store.directory()) {
            for (Map.Entry<String, Integer> e : Map.of(
                    final byte[] onDisk = new byte[(int) in.length()];
        // One file spanning 3-4 parts (multi-part path) and one small file (single-stream path), both with real
            ).entrySet()) {  
                    Store.verify(out);  
import org.apache.lucene.store.IndexInput;  
                    assertArrayEquals(e.getValue(), actual);
/**
                .build(),  
import java.util.Map;  
    }  
import org.opensearch.test.OpenSearchTestCase;
    private static final ShardId SHARD_ID = ShardId.fromString("[index][0]");  
            // Exactly the wrapper RemoteStoreReplicationSource#getSegmentFiles puts around the store directory.
        }
            assertEquals(0L, tracker.getTransferredBytesSucceeded());
    @After
    // ---------------------------------------------------------------------------------------------------------------
        );
        void failRangeReadsAtOrAbove(String blobName, long position) {
            }
            if (t instanceof CorruptIndexException c) {  
        blobContainer = new RangeCountingBlobContainer(  
        bigFile = "_big.cfs";
import org.opensearch.core.index.shard.ShardId;
            assertThat(progressCalls.get(bigFile).get(), greaterThan(1));  
            rangeReads.incrementAndGet();
    public void setup() throws IOException {
        try (Store store = new Store(SHARD_ID, INDEX_SETTINGS, new NIOFSDirectory(createTempDir()), new DummyShardLock(SHARD_ID))) {
            super(delegate);
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;  
            if (blobName.equals(failBlob) && position >= failAtOrAbove) {
            final DirectoryFileTransferTracker tracker = store.getDirectoryFileTransferTracker();
        downloader = new RemoteStoreFileDownloader(SHARD_ID, threadPool, recoverySettings);  
        threadPool = new TestThreadPool(getTestName());  
import org.apache.lucene.store.IndexOutput;
import java.io.IOException;
        threadPool.shutdown();
 * End-to-end checks that multi-part parallel downloads from a {@link RemoteSegmentStoreDirectory} still flow through
     * Destination that verifies each file at write time the way peer recovery's {@code MultiFileWriter} does: the
                }
        );  
        blobContainer.failRangeReadsAtOrAbove(remoteSource.getExistingRemoteFilename(bigFile), PART_SIZE);
        blobContainer.reset();
import org.apache.lucene.index.CorruptIndexException;
                    .get(src);  
            SHARD_ID
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
 * the regular {@code Directory#copyFrom} pipeline -- the property that lets the two mechanisms broken by the earlier  
            // Verified at write time: every byte of the big file was fetched exactly once, as parts, and never re-read.  
        try (Store store = new Store(SHARD_ID, INDEX_SETTINGS, new NIOFSDirectory(createTempDir()), new DummyShardLock(SHARD_ID))) {
                    final byte[] actual = new byte[(int) in.length()];
}  
import org.apache.lucene.codecs.CodecUtil;
import org.opensearch.common.blobstore.fs.FsBlobStore;  
import java.nio.file.Files;
    /** local file name -> expected on-disk bytes (payload + Lucene footer) */
            assertEquals(expected.get(bigFile).length, tracker.getTransferredBytesStarted());
import org.apache.lucene.util.Version;  
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
                (name, bytes) -> {
import org.opensearch.cluster.metadata.IndexMetadata;
                    progressCalls.computeIfAbsent(name, k -> new AtomicInteger()).incrementAndGet();
        }
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
                .put("indices.recovery.remote_store.parallel_download.part_size", new ByteSizeValue(PART_SIZE))
            one.flip();
            return super.readBlob(blobName);
import org.junit.After;
            // ...and is reported incrementally while the large file streams, not once at the end.
            assertEquals(1, blobContainer.wholeReads.get());
                .put("indices.recovery.max_concurrent_remote_store_streams", 2)  
import org.junit.Before;
        // Flip one byte in the middle of the SECOND part of the big blob (a prefetched, heap-buffered part), leaving
            mock(RemoteStoreLockManager.class),  
            future.actionGet();
            // The small, untouched file is unaffected.  
        remoteSource = new RemoteSegmentStoreDirectory(  
import org.opensearch.core.common.unit.ByteSizeValue;  
 * Each check has a negative control so a silently no-op'd wrapper cannot pass.
    private static boolean hasMessageInChain(Throwable t, String needle) {
import java.util.concurrent.atomic.AtomicInteger;
                    in.readBytes(onDisk, 0, onDisk.length);
import org.opensearch.index.store.DirectoryFileTransferTracker;  
 * this file be licensed under the Apache-2.0 license or a
    public void testReplicationStatsRecordFailedMultiPartDownload() throws Exception {  
 */  
import org.opensearch.common.util.CancellableThreads;
                assertEquals("progress bytes for " + e.getKey(), (long) e.getValue().length, (long) progressBytes.get(e.getKey()));  
        // Fail the range read of one prefetched part of the big file so the multi-part download itself fails.
    private static final long PART_SIZE = ByteSizeUnit.MB.toBytes(1);
        RangeCountingBlobContainer(BlobContainer delegate) {  
        }  
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings(
 * </ul>  
    // Checksum verification  
            t = t.getCause();
            downloader.downloadAsync(new CancellableThreads(), remoteSource, verifyingDestination(store), expected.keySet(), future);  
    }
            downloader.downloadAsync(new CancellableThreads(), remoteSource, verifyingDestination(store), Set.of(bigFile), future);  
        return false;  
        }  
            }  
        }
    }
            );  
                try (IndexOutput out = local.createOutput(e.getKey(), IOContext.DEFAULT)) {
        super.tearDown();
public class RemoteStoreMultiPartDownloadPipelineTests extends OpenSearchTestCase {  
            assertEquals(expected.get(bigFile).length, blobContainer.rangeBytesRequested.get());
            final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
import java.util.Set;
            final Directory destination = new SegmentReplicationSource.ReplicationStatsDirectoryWrapper(store.directory(), (n, b) -> {});
    public void testWriteTimeChecksumVerificationPassesWithoutReReadingTheFile() throws Exception {  
        }
                    CodecUtil.checksumEntireFile(in);  
            rangeBytesRequested.set(0);
                    CodecUtil.writeFooter(out);
     */  
        blobPath = createTempDir();
import java.io.InputStream;
import org.opensearch.common.blobstore.BlobContainer;  
import org.opensearch.common.blobstore.fs.FsBlobContainer;
        protected BlobContainer wrapChild(BlobContainer child) {
            final PlainActionFuture<Void> ok = PlainActionFuture.newFuture();
            mock(RemoteDirectory.class),
 * <ul>
import java.nio.file.StandardOpenOption;
            ch.position(offset).read(one);
                }
    private String smallFile;
        assertTrue(threadPool.awaitTermination(5, TimeUnit.SECONDS));  
    // ---------------------------------------------------------------------------------------------------------------
 */
                store.directory(),
        }
import java.util.concurrent.TimeUnit;  
            }
                );  
            rangeReads.set(0);
 * The OpenSearch Contributors require contributions made to  
            final Directory destination = new SegmentReplicationSource.ReplicationStatsDirectoryWrapper(  
            t = t.getCause();  
 *
                    uploaded.getLength(),  
    private final Map<String, byte[]> expected = new HashMap<>();  
        try (Store store = new Store(SHARD_ID, INDEX_SETTINGS, new NIOFSDirectory(createTempDir()), new DummyShardLock(SHARD_ID))) {  
            assertThat(tracker.getLastTransferTimestampMs(), greaterThan(0L));
    private RemoteSegmentStoreDirectory remoteSource;
        }
import org.opensearch.index.store.RemoteStoreFileDownloader;  
            for (Map.Entry<String, byte[]> e : expected.entrySet()) {
                final RemoteSegmentStoreDirectory.UploadedSegmentMetadata uploaded = remoteSource.getSegmentsUploadedToRemoteStore()
                try (IndexInput in = from.openInput(src, context); IndexOutput out = store.createVerifyingOutput(dest, metadata, context)) {
        final Map<String, Long> progressBytes = new ConcurrentHashMap<>();
    public void testReplicationStatsAreReportedForMultiPartDownloads() throws Exception {
    // ---------------------------------------------------------------------------------------------------------------  
                smallFile,
    private String bigFile;
    // ---------------------------------------------------------------------------------------------------------------
        private volatile long failAtOrAbove = Long.MAX_VALUE;
            this.failAtOrAbove = position;  
    private Directory verifyingDestination(Store store) {
            }
            future.actionGet();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            new FsBlobContainer(new FsBlobStore(8 * 1024, blobPath, false), BlobPath.cleanPath(), blobPath)
        while (t != null) {
 * multi-stream download (OpenSearch PR #10519) keep working:
            threadPool,
import java.util.concurrent.ConcurrentHashMap;
            Settings.builder()
        final Map<String, AtomicInteger> progressCalls = new ConcurrentHashMap<>();  
                try (IndexInput in = store.directory().openInput(e.getKey(), IOContext.READONCE)) {
package org.opensearch.indices.replication;
                randomIntBetween((int) PART_SIZE * 2 + 1, (int) PART_SIZE * 4 - 100),  
                }
            wholeReads.set(0);  
            final Exception e = expectThrows(Exception.class, future::actionGet);
    public void tearDown() throws Exception {  
            // Per-file progress (the _cat/recovery "bytes recovered" feed) accounts for every byte of every file...
            assertNotNull("expected a CorruptIndexException from write-time verification, got " + e, unwrapCorruption(e));
            for (Map.Entry<String, byte[]> e : expected.entrySet()) {  
                final StoreFileMetadata metadata = new StoreFileMetadata(
        @Override

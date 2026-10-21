        blockedSnapshotFile.prefetch(0, 10);
import org.opensearch.index.store.remote.utils.BlobFetchRequest;
    }
            input.seek(FILE_SIZE + 1);
        );
        input.seek(blockSize + 11);
        } catch (IOException e) {
                        output.writeByte((byte) -80);
    public void testCheckCacheHit() throws Exception {
        input.seek(blockSize - 1);
        input.seek(0);
    }
        assertEquals(-20432, input.readShort());
        slice.seek(0);
            IndexInput indexInput = new OnDemandPrefetchBlockSnapshotIndexInput(
        assertEquals(12464, input.readShort());
    }
    public void testPrefetch() throws Exception {
        assertNotEquals(cloned.getFilePointer(), input.getFilePointer());
    }
        // testSeek
                output.close();
 *
        when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
        return () -> settings;
            indexInput.seek(repositoryChunkSize);
        assertFalse(input.checkCacheHit(0));
    private Supplier<TieredStoragePrefetchSettings> getPrefetchSettingsSupplier() {
        assertEquals((byte) -80, buf[1]);
                    }
                }
    private ThreadPool threadPool;
        doAnswer(invocation -> {
    private OnDemandPrefetchBlockSnapshotIndexInput createIndexInput(int blockSizeShift) throws IOException {
        assertEquals((byte) 48, buf[2]);
            )
    }
        int blockSize = 1 << 23;
                .isClone(IS_CLONE),
    public void tearDown() throws Exception {
import static org.mockito.Mockito.times;
    public void test4KBBlock() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        fileInfo = new BlobStoreIndexShardSnapshot.FileInfo(
    @Override
        final OnDemandPrefetchBlockSnapshotIndexInput input = createIndexInput(blockSizeShift);
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY, concurrencyLevel);
        byte[] buf = new byte[4];
        assumeFalse("Awaiting Windows fix", Constants.WINDOWS);
    public void init() {
        input.readBytes(buf, 0, 4);
public class OnDemandPrefetchBlockSnapshotIndexInputTests extends OpenSearchTestCase {
                    output.writeByte((byte) -80);
        cloned.seek(blockSize + 11);
    public void test4MBBlock() throws Exception {
            return null;
            fail("Should throw EOFException");
        // checkCacheHit checks fileCache, not disk
}
import org.apache.lucene.util.Constants;
    private void verifyChunkedRepository(long blockSize, long repositoryChunkSize, long fileSize) throws IOException {
                .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
import static org.mockito.Mockito.doAnswer;
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
    }
        input.seek(0);
                .resourceDescription(RESOURCE_DESCRIPTION)
        verify(transferManager, times(6)).fetchBlobAsync(any(BlobFetchRequest.class));
/*
    public void test8MBBlock() throws Exception {
        verify(transferManager, times(2)).fetchBlobAsync(any(BlobFetchRequest.class));
    private BlobStoreIndexShardSnapshot.FileInfo fileInfo;
            // expected
    }
    private static final String BLOCK_FILE_PREFIX = FILE_NAME;
            BlobFetchRequest blobFetchRequest = invocation.getArgument(0);
        verifyChunkedRepository(8192, 2048, 15360);
    }
        input.seek(1);
    public void testChunkedRepositoryWithBlockSizeLessThanChunkSize() throws IOException {
import org.opensearch.index.store.remote.utils.TransferManager;
        path = createTempDir("TestOnDemandPrefetchBlockSnapshotIndexInputTests");
        verifyChunkedRepository(1024, 2048, 3072);
                    output.writeByte((byte) 48);
 * The OpenSearch Contributors require contributions made to
                    .resourceDescription(RESOURCE_DESCRIPTION)
import static org.mockito.Mockito.when;
        input.seek(0);
    }
    private static final int FILE_CACHE_CAPACITY = 10000000;
import org.opensearch.index.store.StoreFileMetadata;
        input.seek(0);
    public void testChunkedRepositoryWithBlockSizeEqualToChunkSize() throws IOException {
            fileInfo,
                ),
        ) {
    }
                    .blockSizeShift((int) (Math.log(blockSize) / Math.log(2)))
    }
        assertTrue(slice instanceof OnDemandPrefetchBlockSnapshotIndexInput);
                    new org.opensearch.core.common.unit.ByteSizeValue(repositoryChunkSize)
        }
    }
        }
            FSDirectory directory = new MMapDirectory(path, lockFactory);
        initBlockFiles(blockSize, directory);
                for (int j = 0; j < blockSize / 2; j++) {
                }
        int concurrencyLevel = randomIntBetween(1, 2);
import org.opensearch.index.store.remote.filecache.FileCache;
        input.fetchNextNBlocks(totalBlocks - 1);
        when(transferManager.fetchBlob(any())).thenReturn(new ByteArrayIndexInput("test", new byte[(int) blockSize]));
            new StoreFileMetadata(FILE_NAME, FILE_SIZE, "", Version.LATEST),
    }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        assertEquals((byte) 48, input.readByte());
            }
    private Path path;
        // testReadBytes
                RESOURCE_DESCRIPTION,
                IndexOutput output = fsDirectory.createOutput(blockName, null);
        when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);
            fail("fail to create MMapDirectory: " + e.getMessage());
                    } else {
        try {
        lockFactory = SimpleFSLockFactory.INSTANCE;
import org.opensearch.threadpool.ThreadPool;
                    .isClone(IS_CLONE),
                .length(FILE_SIZE)
        try {
        input.seek(blockSize + 1);
    public void testCloneAndSlice() throws Exception {
            if (numOfBlocks > 1 && sizeOfLastBlock != 0) {
import java.io.IOException;
        verify(transferManager).fetchBlob(argThat(request -> request.getBlobLength() == blockSize));
            RESOURCE_DESCRIPTION,
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
import org.opensearch.test.OpenSearchTestCase;
        int sizeOfLastBlock = FILE_SIZE % blockSize;
                String lastBlockName = BLOCK_FILE_PREFIX + "_block_" + numOfBlocks;
package org.opensearch.storage.indexinput;
                getPrefetchSettingsSupplier()
                fileCache,
import org.apache.lucene.store.FSDirectory;
        transferManager = mock(TransferManager.class);
    private static final String RESOURCE_DESCRIPTION = "Test OnDemandPrefetchBlockSnapshotIndexInput";
import org.apache.lucene.store.MMapDirectory;
        when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);
 */
            null
    private static final String FILE_NAME = "File_Name";
                directory,
        input.seek(blockSize);
            getPrefetchSettingsSupplier()
    public void testChunkedRepositoryWithBlockSizeGreaterThanChunkSize() throws IOException {
import static org.mockito.Mockito.verify;
            AbstractBlockIndexInput.builder()
        assertEquals("slice", slice.toString());
        // testReadLong
        assertEquals(cloned.getFilePointer(), input.getFilePointer());
        final OnDemandPrefetchBlockSnapshotIndexInput input = createIndexInput(23);
        int numOfBlocks = FILE_SIZE / blockSize;
        threadPool.shutdownNow();
    }
    private void runAllTestsFor(int blockSizeShift) throws Exception {
/**
        assertEquals((byte) 48, buf[0]);
import java.nio.file.Path;
    private static final int FILE_SIZE = 29360128;
        // testReadInt
    @Before
            directory,
                    .length(FILE_SIZE)
        int blockSize = 1 << blockSizeShift;
        assertEquals((byte) -80, buf[3]);
        verifyChunkedRepository(2048, 2048, 15360);
                    FILE_NAME,
        assertEquals(0, input.getFilePointer());
        input.seek(0);
        input.seek(blockSize - 1);
            fail("fail to initialize block files: " + e.getMessage());
        }
            for (int i = 0; i < numOfBlocks; i++) {
import org.opensearch.index.store.remote.file.AbstractBlockIndexInput;
            threadPool,
    private FileCache fileCache;
                AbstractBlockIndexInput.builder()
        // testReadShort
        final int blockSize = 1 << blockSizeShift;
            FILE_NAME,
                for (int i = 0; i < sizeOfLastBlock; i++) {
import org.apache.lucene.store.IndexOutput;
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
import org.apache.lucene.util.Version;
        runAllTestsFor(23);
        final OnDemandPrefetchBlockSnapshotIndexInput input = createIndexInput(23);
                    .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
            fileCache,
        final OnDemandPrefetchBlockSnapshotIndexInput blockedSnapshotFile = createIndexInput(23);
import static org.mockito.Mockito.mock;
        verify(transferManager, times(1)).fetchBlobAsync(any(BlobFetchRequest.class));
        final OnDemandPrefetchBlockSnapshotIndexInput input = createIndexInput(23);
import static org.mockito.ArgumentMatchers.argThat;
import java.io.EOFException;
        runAllTestsFor(22);
                transferManager,
    }
import org.opensearch.threadpool.TestThreadPool;
    }
        final OnDemandPrefetchBlockSnapshotIndexInput input = createIndexInput(23);
            directory = new MMapDirectory(path, lockFactory);
        assertEquals(0, slice.getFilePointer());
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
        assertEquals((byte) 48, input.readByte());
        blockedSnapshotFile.prefetch(0, 8388670);
import org.apache.lucene.store.IndexInput;
    private void initBlockFiles(int blockSize, FSDirectory fsDirectory) {
    public void test1MBBlock() throws Exception {
        verify(transferManager, times(3)).fetchBlobAsync(any(BlobFetchRequest.class));
    }
                String blockName = BLOCK_FILE_PREFIX + "_block_" + i;
import org.apache.lucene.store.LockFactory;
            transferManager,
        input.downloadBlocksAsync(0, 1, false);
        } catch (EOFException e) {
        // fetchNextNBlocks at last block should not throw
            }
        assertEquals(816853168, input.readInt());
        }
 * compatible open source license.
    }
                new BlobStoreIndexShardSnapshot.FileInfo(
                    if ((i & 1) == 0) {
        return new OnDemandPrefetchBlockSnapshotIndexInput(
        runAllTestsFor(12);
        input.seek(0);
import org.junit.Before;
                .blockSizeShift(blockSizeShift)
        );
                    new StoreFileMetadata(FILE_NAME, fileSize, "", Version.LATEST),
        // testReadByte
import org.apache.lucene.store.SimpleFSLockFactory;
    private LockFactory lockFactory;
        FSDirectory directory;
        OnDemandPrefetchBlockSnapshotIndexInput cloned = input.clone();
import org.apache.lucene.store.IOContext;
    public void testDownloadBlocksAsync() throws Exception {
        } catch (IOException e) {
        assertEquals(blockSize + 11, input.getFilePointer());
    private static final boolean IS_CLONE = false;
        }).when(transferManager).fetchBlob(any());
                IndexOutput output = fsDirectory.createOutput(lastBlockName, null);
        threadPool = new TestThreadPool("OnDemandPrefetchTests");
    }
        assertEquals((byte) -80, input.readByte());
        runAllTestsFor(20);
        blockedSnapshotFile.prefetch(0, 16777350);
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
 * Tests for {@link OnDemandPrefetchBlockSnapshotIndexInput}.
    public void testFetchNextNBlocksAtEnd() throws Exception {
        try (
    private TransferManager transferManager;
        assertEquals(-1338986448, input.readInt());
    private static final long BLOCK_SNAPSHOT_FILE_OFFSET = 0;
import static org.mockito.ArgumentMatchers.any;
        IndexInput slice = input.slice("slice", blockSize - 11, 22);
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.Supplier;
        super.tearDown();
                output.close();
 */
                        output.writeByte((byte) 48);
            return blobFetchRequest.getDirectory().openInput(blobFetchRequest.getFileName(), IOContext.READONCE);
        int totalBlocks = input.getTotalBlocks();
        assertEquals(-5750903000991223760L, input.readLong());
        // Block files exist on disk from initBlockFiles, but not in fileCache
                threadPool,
        TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
        try {

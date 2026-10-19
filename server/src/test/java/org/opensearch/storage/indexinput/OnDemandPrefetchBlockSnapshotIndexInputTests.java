    public void test1MBBlock() throws Exception {
        assertEquals((byte) -80, buf[3]);
        int totalBlocks = input.getTotalBlocks();
 *
                    new StoreFileMetadata(FILE_NAME, fileSize, "", Version.LATEST),
        assertEquals((byte) -80, input.readByte());
 */  
        // Block files exist on disk from initBlockFiles, but not in fileCache  
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;  
    public void testChunkedRepositoryWithBlockSizeLessThanChunkSize() throws IOException {
        FSDirectory directory;  
                for (int i = 0; i < sizeOfLastBlock; i++) {  
            fileCache,
                transferManager,  
            return null;
                output.close();  
            for (int i = 0; i < numOfBlocks; i++) {
        input.seek(0);
    @Override
    public void test8MBBlock() throws Exception {
                .length(FILE_SIZE)
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        try {
        threadPool.shutdownNow();
        final OnDemandPrefetchBlockSnapshotIndexInput input = createIndexInput(blockSizeShift);  
            transferManager,
        final OnDemandPrefetchBlockSnapshotIndexInput blockedSnapshotFile = createIndexInput(23);
import org.opensearch.threadpool.TestThreadPool;
        input.seek(0);
        int blockSize = 1 << 23;
        runAllTestsFor(20);
    public void testDownloadBlocksAsync() throws Exception {  
    }  
        final OnDemandPrefetchBlockSnapshotIndexInput input = createIndexInput(23);
import org.opensearch.index.store.StoreFileMetadata;
    private TransferManager transferManager;  
            return blobFetchRequest.getDirectory().openInput(blobFetchRequest.getFileName(), IOContext.READONCE);  
        assertEquals(-20432, input.readShort());
        input.fetchNextNBlocks(totalBlocks - 1);  
                directory,
    private void initBlockFiles(int blockSize, FSDirectory fsDirectory) {  
        input.seek(0);  
                ),
                output.close();
        try {
                    .resourceDescription(RESOURCE_DESCRIPTION)  
        assertEquals(blockSize + 11, input.getFilePointer());
        blockedSnapshotFile.prefetch(0, 10);  
import org.opensearch.threadpool.ThreadPool;  
        // testSeek  
    private Path path;  
        assertEquals((byte) -80, buf[1]);
        } catch (EOFException e) {
import org.apache.lucene.store.IndexOutput;  
        initBlockFiles(blockSize, directory);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        input.seek(1);  
        try {
        input.downloadBlocksAsync(0, 1, false);
        when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
        fileInfo = new BlobStoreIndexShardSnapshot.FileInfo(
        assertEquals((byte) 48, buf[2]);  
                RESOURCE_DESCRIPTION,
            )
import org.apache.lucene.store.MMapDirectory;
        } catch (IOException e) {  
    private LockFactory lockFactory;
    }  
        verifyChunkedRepository(8192, 2048, 15360);
    }  
            if (numOfBlocks > 1 && sizeOfLastBlock != 0) {  
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
import org.opensearch.test.OpenSearchTestCase;
    private static final long BLOCK_SNAPSHOT_FILE_OFFSET = 0;
                    if ((i & 1) == 0) {
    private void verifyChunkedRepository(long blockSize, long repositoryChunkSize, long fileSize) throws IOException {  
        IndexInput slice = input.slice("slice", blockSize - 11, 22);  
                IndexOutput output = fsDirectory.createOutput(lastBlockName, null);
        int blockSize = 1 << blockSizeShift;
        super.tearDown();
                    } else {  
        input.seek(blockSize + 11);  
    }
        path = createTempDir("TestOnDemandPrefetchBlockSnapshotIndexInputTests");  
                AbstractBlockIndexInput.builder()
                    }
        assertEquals(12464, input.readShort());  
    }
    }
                    .blockSizeShift((int) (Math.log(blockSize) / Math.log(2)))  
                }  
        verify(transferManager, times(3)).fetchBlobAsync(any(BlobFetchRequest.class));  
                threadPool,
    private BlobStoreIndexShardSnapshot.FileInfo fileInfo;
import static org.mockito.ArgumentMatchers.argThat;  
    private static final String RESOURCE_DESCRIPTION = "Test OnDemandPrefetchBlockSnapshotIndexInput";
        blockedSnapshotFile.prefetch(0, 8388670);
        blockedSnapshotFile.prefetch(0, 16777350);
        );  
import org.apache.lucene.store.IndexInput;
            fail("fail to initialize block files: " + e.getMessage());
import org.apache.lucene.store.FSDirectory;  
        }  
        try (
        lockFactory = SimpleFSLockFactory.INSTANCE;
                fileCache,
        input.seek(blockSize + 1);  
            // expected  
        assertEquals((byte) 48, input.readByte());
        runAllTestsFor(22);  
import org.opensearch.index.store.remote.filecache.FileCacheFactory;  
                String lastBlockName = BLOCK_FILE_PREFIX + "_block_" + numOfBlocks;
                    FILE_NAME,
    public void init() {
import java.io.EOFException;  
        assertEquals(0, slice.getFilePointer());
        when(transferManager.fetchBlob(any())).thenReturn(new ByteArrayIndexInput("test", new byte[(int) blockSize]));
    }
        input.seek(blockSize - 1);
        }
import java.nio.file.Path;
        }).when(transferManager).fetchBlob(any());
                String blockName = BLOCK_FILE_PREFIX + "_block_" + i;  
    }  
                        output.writeByte((byte) -80);
            BlobFetchRequest blobFetchRequest = invocation.getArgument(0);
        int sizeOfLastBlock = FILE_SIZE % blockSize;
        threadPool = new TestThreadPool("OnDemandPrefetchTests");
            fileInfo,  
    }
import org.opensearch.index.store.remote.utils.BlobFetchRequest;
        assertEquals(816853168, input.readInt());  
                    .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
        }
                    output.writeByte((byte) -80);
            }
        }
            fail("Should throw EOFException");
                .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
    }
        assertFalse(input.checkCacheHit(0));
    public void test4KBBlock() throws Exception {  
import static org.mockito.Mockito.mock;
                IndexOutput output = fsDirectory.createOutput(blockName, null);
            indexInput.seek(repositoryChunkSize);  
        // testReadLong
                .blockSizeShift(blockSizeShift)  
        assertEquals(cloned.getFilePointer(), input.getFilePointer());
    private Supplier<TieredStoragePrefetchSettings> getPrefetchSettingsSupplier() {
                for (int j = 0; j < blockSize / 2; j++) {
    private ThreadPool threadPool;
        input.seek(0);
        verify(transferManager, times(2)).fetchBlobAsync(any(BlobFetchRequest.class));  
    public void test4MBBlock() throws Exception {
            input.seek(FILE_SIZE + 1);  
        input.seek(blockSize - 1);
        assertTrue(slice instanceof OnDemandPrefetchBlockSnapshotIndexInput);
import org.opensearch.index.store.remote.file.AbstractBlockIndexInput;  
        when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);
                        output.writeByte((byte) 48);
    private static final String FILE_NAME = "File_Name";  
        verifyChunkedRepository(1024, 2048, 3072);
    }
import java.util.function.Supplier;  
        // fetchNextNBlocks at last block should not throw
    }  
import org.apache.lucene.util.Version;
import org.opensearch.index.store.remote.utils.TransferManager;
    private static final int FILE_SIZE = 29360128;  
        assertEquals("slice", slice.toString());
    }  
            fail("fail to create MMapDirectory: " + e.getMessage());
 * Tests for {@link OnDemandPrefetchBlockSnapshotIndexInput}.
        ) {
    }
public class OnDemandPrefetchBlockSnapshotIndexInputTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
        final int blockSize = 1 << blockSizeShift;
        // testReadShort
        cloned.seek(blockSize + 11);  
            directory,
        assertEquals((byte) 48, buf[0]);
        byte[] buf = new byte[4];
            RESOURCE_DESCRIPTION,
        assertEquals(-5750903000991223760L, input.readLong());
    public void testChunkedRepositoryWithBlockSizeGreaterThanChunkSize() throws IOException {  
import java.io.IOException;
/*  
        final OnDemandPrefetchBlockSnapshotIndexInput input = createIndexInput(23);
import org.opensearch.common.lucene.store.ByteArrayIndexInput;  
        verify(transferManager, times(6)).fetchBlobAsync(any(BlobFetchRequest.class));
        final OnDemandPrefetchBlockSnapshotIndexInput input = createIndexInput(23);  
        TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;  
            IndexInput indexInput = new OnDemandPrefetchBlockSnapshotIndexInput(
        when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);  
            FILE_NAME,  
            FSDirectory directory = new MMapDirectory(path, lockFactory);  
                    output.writeByte((byte) 48);  
    public void tearDown() throws Exception {  
            getPrefetchSettingsSupplier()
                    .isClone(IS_CLONE),
            new StoreFileMetadata(FILE_NAME, FILE_SIZE, "", Version.LATEST),
 */  
 * The OpenSearch Contributors require contributions made to  
import org.junit.Before;
        transferManager = mock(TransferManager.class);  
        assertNotEquals(cloned.getFilePointer(), input.getFilePointer());
    @Before  
        // checkCacheHit checks fileCache, not disk
    private static final boolean IS_CLONE = false;
        return () -> settings;  
        return new OnDemandPrefetchBlockSnapshotIndexInput(
    public void testFetchNextNBlocksAtEnd() throws Exception {
    private OnDemandPrefetchBlockSnapshotIndexInput createIndexInput(int blockSizeShift) throws IOException {
                new BlobStoreIndexShardSnapshot.FileInfo(  
    }  
        int numOfBlocks = FILE_SIZE / blockSize;
        runAllTestsFor(23);  
    }
        input.readBytes(buf, 0, 4);  
        assertEquals((byte) 48, input.readByte());  
    private void runAllTestsFor(int blockSizeShift) throws Exception {
        OnDemandPrefetchBlockSnapshotIndexInput cloned = input.clone();
import static org.mockito.Mockito.verify;
                .isClone(IS_CLONE),
import org.apache.lucene.store.LockFactory;
    private static final String BLOCK_FILE_PREFIX = FILE_NAME;
import org.apache.lucene.store.SimpleFSLockFactory;  
import static org.mockito.Mockito.doAnswer;
import org.opensearch.index.store.remote.filecache.FileCache;
        // testReadBytes  
        input.seek(blockSize);
                    new org.opensearch.core.common.unit.ByteSizeValue(repositoryChunkSize)  
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY, concurrencyLevel);
    }  
            threadPool,  
    public void testChunkedRepositoryWithBlockSizeEqualToChunkSize() throws IOException {
        );  
import static org.mockito.ArgumentMatchers.any;
        input.seek(0);  
        slice.seek(0);  
            AbstractBlockIndexInput.builder()
    private FileCache fileCache;
        assertEquals(0, input.getFilePointer());
    public void testCheckCacheHit() throws Exception {
import org.apache.lucene.util.Constants;
                }
}
        assumeFalse("Awaiting Windows fix", Constants.WINDOWS);
        verify(transferManager, times(1)).fetchBlobAsync(any(BlobFetchRequest.class));
import org.apache.lucene.store.IOContext;
        verifyChunkedRepository(2048, 2048, 15360);  
        doAnswer(invocation -> {
        verify(transferManager).fetchBlob(argThat(request -> request.getBlobLength() == blockSize));
    }
        final OnDemandPrefetchBlockSnapshotIndexInput input = createIndexInput(23);  
/**
    public void testCloneAndSlice() throws Exception {
            null
    }
        // testReadByte  
    public void testPrefetch() throws Exception {  
            directory = new MMapDirectory(path, lockFactory);
 * compatible open source license.
                .resourceDescription(RESOURCE_DESCRIPTION)  
        assertEquals(-1338986448, input.readInt());
        runAllTestsFor(12);
        int concurrencyLevel = randomIntBetween(1, 2);
            }
        // testReadInt
    private static final int FILE_CACHE_CAPACITY = 10000000;
package org.opensearch.storage.indexinput;
        input.seek(0);  
        } catch (IOException e) {  
                getPrefetchSettingsSupplier()  
 * this file be licensed under the Apache-2.0 license or a
                    .length(FILE_SIZE)

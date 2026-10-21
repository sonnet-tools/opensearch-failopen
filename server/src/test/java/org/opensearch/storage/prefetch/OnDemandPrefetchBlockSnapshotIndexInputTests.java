        input.seek(0);
    private static final String FILE_NAME = "File_Name";
        assertTrue(indexInput.checkIfFileEnabledReadAhead());
        assertEquals(0, input.getBlock(0L));
        try {
        input.seek(blockSize * 2 - 1);
                    new StoreFileMetadata(FILE_NAME, fileSize, "", Version.LATEST),
        assertEquals(-5750903000991223760L, input.readLong());
        assertEquals((FILE_SIZE - 1) / blockSize, input.getBlock(FILE_SIZE - 1));
                .isClone(IS_CLONE),
        }
        assertEquals(0L, input.getBlockStart(0));
            AbstractBlockIndexInput.builder()
    private static final int FILE_SIZE = 29360128;
                ),
        assertEquals((byte) -80, input.readByte());
        } catch (IOException e) {
import org.apache.lucene.store.SimpleFSLockFactory;
        when(transferManager.fetchBlob(any())).thenReturn(new ByteArrayIndexInput("test", new byte[(int) blockSize]));
import org.apache.lucene.store.LockFactory;
            fileCache,
    private static final String BLOCK_FILE_PREFIX = FILE_NAME;
    public void testChunkedRepositoryWithBlockSizeLessThanChunkSize() throws IOException {
        // testReadShort
        int blockSize = 1 << blockSizeShift;
    public void init() {
        runAllTestsFor(20);
        // testGetBlockStart
            transferManager,
        assertEquals((byte) 48, buf[0]);
                }
import org.opensearch.threadpool.ThreadPool;
        }
        assertTrue(blockedSnapshotFile.checkIfStoredFieldsPrefetchEnabled());
                String lastBlockName = BLOCK_FILE_PREFIX + "_block_" + numOfBlocks;
        FSDirectory directory = null;
        Set<Setting<?>> clusterSettingsToAdd = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);
import java.util.Set;
        // Fetch a block that exists (should be cache hit)
import static org.mockito.Mockito.mock;
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY, concurrencyLevel);
import org.apache.lucene.util.Version;
import org.opensearch.common.settings.ClusterSettings;
        assertEquals((FILE_SIZE - 1) / blockSize + 1, input.getTotalBlocks());
import org.opensearch.index.store.remote.filecache.FileCache;
    public void tearDown() throws Exception {
    private static final long BLOCK_SNAPSHOT_FILE_OFFSET = 0;
    }
                directory,
    }
            directory,
            getPrefetchSettingsSupplier()
    }
        BlobStoreIndexShardSnapshot.FileInfo dvdFileInfo = new BlobStoreIndexShardSnapshot.FileInfo(
        verify(transferManager, times(1)).fetchBlobAsync(any(BlobFetchRequest.class));
            getPrefetchSettingsSupplier()
        }
            directory = new MMapDirectory(path, lockFactory);
        IndexInput result = blockedSnapshotFile.fetchBlockPublic(0);
        // testReadInt
        return new TestOnDemandPrefetchBlockSnapshotIndexInput(
        }
        final TestOnDemandPrefetchBlockSnapshotIndexInput blockedSnapshotFile = createTestOnDemandPrefetchBlockSnapshotIndexInput(23);
                    FILE_NAME,
import java.nio.file.Path;
                    output.writeByte((byte) -80);
import org.apache.lucene.util.Constants;
                .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
        assertEquals((byte) 48, buf[2]);
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
        } catch (IOException e) {
        FSDirectory directory = null;
    public void testDownloadBlocksAsyncWithCacheOptimization() throws Exception {
        );
            for (int i = 0; i < numOfBlocks; i++) {
            fileInfo,
                String blockName = BLOCK_FILE_PREFIX + "_block_" + i;
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
        assertEquals((byte) -80, buf[1]);
        assertEquals((byte) 48, input.readByte());
    }
        TestOnDemandPrefetchBlockSnapshotIndexInput indexInput = getIndexInput("lucene.dvd", "clone");
        assertEquals(12464, input.readShort());
import java.io.EOFException;
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
    public void testChunkedRepositoryWithBlockSizeGreaterThanChunkSize() throws IOException {
            // expected
            BlobFetchRequest blobFetchRequest = invocation.getArgument(0);
        // testReadBytes
        fileInfo = new BlobStoreIndexShardSnapshot.FileInfo(
            input.seek(FILE_SIZE + 1);
import org.opensearch.common.settings.Settings;
            directory = new MMapDirectory(path, lockFactory);
        final TestOnDemandPrefetchBlockSnapshotIndexInput blockedSnapshotFile = createTestOnDemandPrefetchBlockSnapshotIndexInput(23);
        assertEquals(blockSize, input.currentBlockStart());
            threadPool,
                        output.writeByte((byte) -80);
                threadPool,
            new StoreFileMetadata(FILE_NAME, FILE_SIZE, "", Version.LATEST),
            RESOURCE_DESCRIPTION,
                for (int i = 0; i < sizeOfLastBlock; i++) {
        // Test that cached blocks are not re-downloaded
public class OnDemandPrefetchBlockSnapshotIndexInputTests extends OpenSearchTestCase {
        blockedSnapshotFile.prefetch(0, 10);
package org.opensearch.storage.prefetch;
        final int blockSize = 1 << blockSizeShift;
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(),
        );
                    .blockSizeShift((int) (Math.log(blockSize) / Math.log(2)))
        return new TestOnDemandPrefetchBlockSnapshotIndexInput(
    }
            indexInput.seek(repositoryChunkSize);
import org.apache.lucene.store.MMapDirectory;
        // testCurrentBlockStart
        int blockSize = 1 << blockSizeShift;
    }
    }
        input.seek(blockSize - 1);
    private void initBlockFiles(int blockSize, FSDirectory fsDirectory) {
        );
        assertEquals(1, input.currentBlockPosition());
        );
                .blockSizeShift(blockSizeShift)
            dvdFileName,
    private void verifyChunkedRepository(long blockSize, long repositoryChunkSize, long fileSize) throws IOException {
        verifyChunkedRepository(
        int sizeOfLastBlock = FILE_SIZE % blockSize;
        assertFalse(indexInput.checkIfFileEnabledReadAhead());
import org.opensearch.index.store.remote.utils.BlobFetchRequest;
    }
        this.tieringServicePrefetchSettings = new TieredStoragePrefetchSettings(clusterSettings);
            AbstractBlockIndexInput.builder()
/*
        );
        int numOfBlocks = FILE_SIZE / blockSize;
        transferManager = mock(TransferManager.class);
        FSDirectory directory = null;
 * SPDX-License-Identifier: Apache-2.0
        ) {
    }
    public void testFetchBlockWithCacheTracking() throws Exception {
    }
                    }
            transferManager,
    private BlobStoreIndexShardSnapshot.FileInfo fileInfo;
    }
                    new ByteSizeValue(repositoryChunkSize)
    }
import org.opensearch.core.common.unit.ByteSizeValue;
    public void testReadAheadEnabled() throws Exception {
            resourceDescription,
                AbstractBlockIndexInput.builder()
        );
        } catch (IOException e) {
            RESOURCE_DESCRIPTION,
        TestOnDemandPrefetchBlockSnapshotIndexInput clonedFile = (TestOnDemandPrefetchBlockSnapshotIndexInput) input.clone();
        input.seek(blockSize + 11);
                IndexOutput output = fsDirectory.createOutput(blockName, null);
import static org.mockito.Mockito.verify;
        // testSeek
    }
        String dvdFileName = "_0.dvd";
import static org.mockito.ArgumentMatchers.argThat;
    }
    private TestOnDemandPrefetchBlockSnapshotIndexInput createDvdFileIndexInput(int blockSizeShift) throws IOException {
            )
        }
            new ByteSizeValue(15, ByteSizeUnit.KB).getBytes()
            BlobFetchRequest blobFetchRequest = invocation.getArgument(0);
                .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
            return blobFetchRequest.getDirectory().openInput(blobFetchRequest.getFileName(), IOContext.READONCE);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, clusterSettingsToAdd);
        assumeFalse("Awaiting Windows fix https://github.com/opensearch-project/OpenSearch/issues/5396", Constants.WINDOWS);
    public Supplier<TieredStoragePrefetchSettings> getPrefetchSettingsSupplier() {
        assertEquals(0, input.getBlockOffset(blockSize));
        }).when(transferManager).fetchBlob(any());
        // testGetTotalBlocks
            }
            dvdFileInfo,
                    .resourceDescription(RESOURCE_DESCRIPTION)
        runAllTestsFor(22);
        verify(transferManager, times(3)).fetchBlobAsync(any(BlobFetchRequest.class));
        verify(transferManager, never()).fetchBlobAsync(any(BlobFetchRequest.class));
        assertEquals(0L, input.currentBlockStart());
    }
        input.seek(1);
import java.util.function.Supplier;
    public void testChunkedRepositoryWithBlockSizeEqualToChunkSize() throws IOException {
        clonedFile.seek(blockSize + 11);
        int concurrencyLevel = randomIntBetween(1, 2);
        assertEquals(-1338986448, input.readInt());
import static org.mockito.Mockito.when;
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
        // prefetch should be a no-op when disabled
        indexInput = getIndexInput("_1.fdt", "clone");
import java.util.HashSet;
import org.opensearch.threadpool.TestThreadPool;
                        output.writeByte((byte) 48);
        try {
                IndexOutput output = directory.createOutput(blockName, null);
import java.io.IOException;
        }
    }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    private static final String RESOURCE_DESCRIPTION = "Test TestOnDemandPrefetchBlockSnapshotIndexInput Block Size";
import org.apache.lucene.store.FSDirectory;
    TestOnDemandPrefetchBlockSnapshotIndexInput getIndexInput(String fileName, String resourceDescription) {
        final TestOnDemandPrefetchBlockSnapshotIndexInput blockedSnapshotFile = createTestOnDemandPrefetchBlockSnapshotIndexInput(23);
            new ByteSizeValue(1, ByteSizeUnit.KB).getBytes(),
            getPrefetchSettingsSupplier()
import org.opensearch.index.store.remote.utils.TransferManager;
                output.close();
    public void test8MBBlock() throws Exception {
        assertEquals(816853168, input.readInt());
import org.junit.Before;
        return new TestOnDemandPrefetchBlockSnapshotIndexInput(
    public void testPrefetch() throws Exception {
    private TieredStoragePrefetchSettings tieringServicePrefetchSettings;
        throws IOException {
        // testClone
        tieringServicePrefetchSettings.setStoredFieldsPrefetchEnabled(false);
            new ByteSizeValue(3, ByteSizeUnit.KB).getBytes()
        input.seek(blockSize);
import static org.mockito.ArgumentMatchers.any;
        assertEquals(blockSize, input.getBlockStart(1));
import org.apache.lucene.store.IndexInput;
    }
        verifyChunkedRepository(
            AbstractBlockIndexInput.builder()
    public void testSettings() throws Exception {
        }).when(transferManager).fetchBlob(any());
        threadPool = new TestThreadPool("PrefetchBlockSnapshotIndexInputTests");
import org.apache.lucene.store.IOContext;
                .resourceDescription(RESOURCE_DESCRIPTION)
        initBlockFiles(blockSize, directory);
            null
        input.seek(blockSize + 1);
            }
            transferManager,
                .blockSizeShift(23)
        input.seek(0);
        path = createTempDir("TestOnDemandPrefetchBlockSnapshotIndexInputTests");
        clusterSettingsToAdd.add(TieredStoragePrefetchSettings.STORED_FIELDS_PREFETCH_ENABLED_SETTING);
    private static final boolean IS_CLONE = false;
        );
            FSDirectory directory = new MMapDirectory(path, lockFactory);
            threadPool,
        super.tearDown();
                    if ((i & 1) == 0) {
            new StoreFileMetadata(dvdFileName, FILE_SIZE, "", Version.LATEST),
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(),
        try {
        assertEquals(-20432, input.readShort());
            new ByteSizeValue(15, ByteSizeUnit.KB).getBytes()
                .blockSizeShift(blockSizeShift)
                getPrefetchSettingsSupplier()
        assertFalse(indexInput.checkIfFileEnabledReadAhead());
        try {
            directory = new MMapDirectory(path, lockFactory);
            fileCache,
                output.close();
            if (numOfBlocks > 1 && sizeOfLastBlock != 0) {
        assertTrue(indexInput.checkIfFileEnabledReadAhead());
        assertNotEquals(clonedFile.currentBlockPosition(), input.currentBlockPosition());
            return blobFetchRequest.getDirectory().openInput(blobFetchRequest.getFileName(), IOContext.READONCE);
        } catch (IOException e) {
                .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
    private ThreadPool threadPool;
    private LockFactory lockFactory;
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertEquals(blockSize + 11, input.getFilePointer());
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(),
        verify(transferManager).fetchBlob(argThat(request -> request.getBlobLength() == blockSize));
        blockedSnapshotFile.prefetch(0, 8388670);
                .length(FILE_SIZE)
        verifyChunkedRepository(
                    output.writeByte((byte) 48);
            new ByteSizeValue(8, ByteSizeUnit.KB).getBytes(),
        // testReadLong
        lockFactory = SimpleFSLockFactory.INSTANCE;
        input.seek(0);
        assertEquals(clonedFile.currentBlockPosition(), input.currentBlockPosition());
        input.seek(0);
        int sizeOfLastBlock = FILE_SIZE % blockSize;
        input.seek(blockSize - 1);
                    .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
        // testReadByte
        assertEquals((byte) 48, input.readByte());
        input.readBytes(buf, 0, 4);
    FileCache fileCache;
        assertEquals(blockSize - 1, input.currentBlockPosition());
import org.opensearch.index.store.remote.file.AbstractBlockIndexInput;
 * The OpenSearch Contributors require contributions made to
        input.seek(0);
import static org.mockito.Mockito.never;
    private void runAllTestsFor(int blockSizeShift) throws Exception {
    public void test1MBBlock() throws Exception {
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        indexInput = getIndexInput("_0.cfs", "lucene9.dvd");
        doAnswer(invocation -> {
        input.seek(blockSize + 1);
        verify(transferManager, times(6)).fetchBlobAsync(any(BlobFetchRequest.class));
                output.close();
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            fail("fail to initialize block files: " + e.getMessage());
        try {
        } catch (IOException e) {
        assertNotNull("Fetched block should not be null", result);
                    output.writeByte((byte) ((i & 1) == 0 ? 48 : -80));
            }
        runAllTestsFor(12);
    public void testPrefetchDisabledBySettings() throws Exception {
        blockedSnapshotFile.prefetch(0, 16777350);
                }
                IndexOutput output = fsDirectory.createOutput(lastBlockName, null);
        assertFalse(blockedSnapshotFile.checkIfFileEnabledReadAhead());
        fileInfo = new BlobStoreIndexShardSnapshot.FileInfo(fileName, new StoreFileMetadata(fileName, FILE_SIZE, "", Version.LATEST), null);
 */
        // Create block files with the dvd file name prefix
    protected static final int FILE_CACHE_CAPACITY = 10000000;
                transferManager,
        }
            fail("fail to create MMapDirectory: " + e.getMessage());
    @Before
        final TestOnDemandPrefetchBlockSnapshotIndexInput input = createTestOnDemandPrefetchBlockSnapshotIndexInput(blockSizeShift);
                .isClone(IS_CLONE),
        int numOfBlocks = FILE_SIZE / blockSize;
            fail("fail to create MMapDirectory: " + e.getMessage());
    }
    private TestOnDemandPrefetchBlockSnapshotIndexInput createTestOnDemandPrefetchBlockSnapshotIndexInput(int blockSizeShift)
    }
        assertEquals((byte) -80, buf[3]);
                String blockName = dvdFileName + "_block_" + i;
                }
        blockedSnapshotFile.prefetch(0, 10);
        byte[] buf = new byte[4];
                RESOURCE_DESCRIPTION,
            IndexInput indexInput = new TestOnDemandPrefetchBlockSnapshotIndexInput(
        runAllTestsFor(23);
    public void test4KBBlock() throws Exception {
    private TransferManager transferManager;
            fail("Should throw EOFException");
                String lastBlockName = dvdFileName + "_block_" + numOfBlocks;
            if (numOfBlocks > 1 && sizeOfLastBlock != 0) {
        // testGetBlockOffset
                fileCache,
        // testCurrentBlockPosition
                new BlobStoreIndexShardSnapshot.FileInfo(
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.doAnswer;
                .resourceDescription(RESOURCE_DESCRIPTION)
                }
                .length(FILE_SIZE)
        assertEquals(1, input.getBlockOffset(1));
        try {
    @Override
        blockedSnapshotFile.downloadBlocksAsync(0, 1, false);
    }
                for (int j = 0; j < blockSize / 2; j++) {
            directory,
            FILE_NAME,
        final TestOnDemandPrefetchBlockSnapshotIndexInput blockedSnapshotFile = createTestOnDemandPrefetchBlockSnapshotIndexInput(23);
        return () -> this.tieringServicePrefetchSettings;
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(),
                    .length(FILE_SIZE)
            for (int i = 0; i < numOfBlocks; i++) {
        try (
import org.opensearch.common.settings.Setting;
                    } else {
                    .isClone(IS_CLONE),
            threadPool,
        input.seek(0);
                .isClone(IS_CLONE),
                    output.writeByte((byte) -80);
import static org.mockito.Mockito.times;
        threadPool.shutdownNow();
            fileInfo,
        assertEquals(0, input.getFilePointer());
import org.apache.lucene.store.IndexOutput;
            fail("fail to create MMapDirectory: " + e.getMessage());
                .resourceDescription(RESOURCE_DESCRIPTION)
 * compatible open source license.
        // testGetBlock
        clusterSettingsToAdd.add(TieredStoragePrefetchSettings.READ_AHEAD_BLOCK_COUNT);
                output.close();
        doAnswer(invocation -> {
            directory,
            fileCache,
                    output.writeByte((byte) 48);
                IndexOutput output = directory.createOutput(lastBlockName, null);
    private Path path;
            fail("fail to initialize dvd block files: " + e.getMessage());
    public void test4MBBlock() throws Exception {
    }
        input.seek(blockSize - 1);
        final TestOnDemandPrefetchBlockSnapshotIndexInput blockedSnapshotFile = createTestOnDemandPrefetchBlockSnapshotIndexInput(23);
        indexInput = getIndexInput("_1.cfe", "lucene9.dvd");
        assertEquals((FILE_SIZE - 1) % blockSize, input.getBlockOffset(FILE_SIZE - 1));
        assertEquals(clonedFile.getFilePointer(), input.getFilePointer());
    }
        );
        } catch (EOFException e) {
                .length(FILE_SIZE)
 *
            null
            }
}
        // Disable stored fields prefetch via settings
import org.opensearch.index.store.StoreFileMetadata;
        input.seek(blockSize - 1);
                for (int j = 0; j < blockSize / 2; j++) {
                for (int i = 0; i < sizeOfLastBlock; i++) {
        assertEquals(1, input.getBlock(blockSize));
        assertEquals(blockSize * 2, input.getBlockStart(2));
import org.opensearch.test.OpenSearchTestCase;

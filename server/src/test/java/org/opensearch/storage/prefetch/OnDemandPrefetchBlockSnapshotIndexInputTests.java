    }
        input.seek(0);
                new BlobStoreIndexShardSnapshot.FileInfo(
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(),  
    }
        assertEquals(clonedFile.currentBlockPosition(), input.currentBlockPosition());  
        }
                .length(FILE_SIZE)
            fail("fail to initialize dvd block files: " + e.getMessage());
            fileCache,
                    .length(FILE_SIZE)  
    private LockFactory lockFactory;
        Set<Setting<?>> clusterSettingsToAdd = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);  
    private TieredStoragePrefetchSettings tieringServicePrefetchSettings;
    private static final int FILE_SIZE = 29360128;
        // testGetBlock  
        // testCurrentBlockStart  
            fail("fail to create MMapDirectory: " + e.getMessage());
            new StoreFileMetadata(FILE_NAME, FILE_SIZE, "", Version.LATEST),
                    output.writeByte((byte) -80);
        doAnswer(invocation -> {  
                directory,  
        final TestOnDemandPrefetchBlockSnapshotIndexInput input = createTestOnDemandPrefetchBlockSnapshotIndexInput(blockSizeShift);  
import org.opensearch.core.common.unit.ByteSizeUnit;
                String blockName = dvdFileName + "_block_" + i;
    public void testFetchBlockWithCacheTracking() throws Exception {  
        input.seek(1);
            if (numOfBlocks > 1 && sizeOfLastBlock != 0) {  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, clusterSettingsToAdd);  
            FSDirectory directory = new MMapDirectory(path, lockFactory);
import java.util.HashSet;
        assertEquals(0L, input.currentBlockStart());
        verify(transferManager, times(1)).fetchBlobAsync(any(BlobFetchRequest.class));  
        assertEquals(blockSize + 11, input.getFilePointer());  
            getPrefetchSettingsSupplier()
    }
        input.seek(blockSize - 1);
        return () -> this.tieringServicePrefetchSettings;
        final int blockSize = 1 << blockSizeShift;
        assertNotNull("Fetched block should not be null", result);
    private static final String RESOURCE_DESCRIPTION = "Test TestOnDemandPrefetchBlockSnapshotIndexInput Block Size";  
            }  
 */  
        assertEquals((byte) 48, input.readByte());
        blockedSnapshotFile.prefetch(0, 16777350);  
                .isClone(IS_CLONE),  
        // testCurrentBlockPosition  
                    output.writeByte((byte) 48);  
        );
        assertEquals(-1338986448, input.readInt());  
import static org.mockito.Mockito.when;
        } catch (IOException e) {  
            transferManager,
                }
            threadPool,
            indexInput.seek(repositoryChunkSize);
        verifyChunkedRepository(  
                .blockSizeShift(23)
            }
import org.apache.lucene.store.IndexInput;
        assertEquals((FILE_SIZE - 1) / blockSize + 1, input.getTotalBlocks());  
        verify(transferManager).fetchBlob(argThat(request -> request.getBlobLength() == blockSize));  
        // Test that cached blocks are not re-downloaded
        // testClone  
        ) {  
import org.opensearch.common.settings.Settings;  
                    }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    public void testDownloadBlocksAsyncWithCacheOptimization() throws Exception {
import java.io.IOException;
import org.apache.lucene.util.Version;
        int numOfBlocks = FILE_SIZE / blockSize;
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
        clonedFile.seek(blockSize + 11);
            directory,
    private Path path;
                    .resourceDescription(RESOURCE_DESCRIPTION)
        initBlockFiles(blockSize, directory);
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.store.remote.utils.BlobFetchRequest;  
        input.readBytes(buf, 0, 4);
        } catch (IOException e) {
        // testGetBlockOffset
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(),
import org.opensearch.common.settings.ClusterSettings;
import java.util.function.Supplier;  
        assertFalse(indexInput.checkIfFileEnabledReadAhead());  
            new ByteSizeValue(1, ByteSizeUnit.KB).getBytes(),
 *
            fileInfo,
        super.tearDown();  
            fail("fail to create MMapDirectory: " + e.getMessage());  
    @Before  
        );
 * compatible open source license.
            IndexInput indexInput = new TestOnDemandPrefetchBlockSnapshotIndexInput(
    }
        runAllTestsFor(23);
        }
    }  
                .blockSizeShift(blockSizeShift)
        runAllTestsFor(22);
 * The OpenSearch Contributors require contributions made to  
        return new TestOnDemandPrefetchBlockSnapshotIndexInput(
        transferManager = mock(TransferManager.class);  
        assertNotEquals(clonedFile.currentBlockPosition(), input.currentBlockPosition());  
            getPrefetchSettingsSupplier()
import org.apache.lucene.store.MMapDirectory;
        this.tieringServicePrefetchSettings = new TieredStoragePrefetchSettings(clusterSettings);
        BlobStoreIndexShardSnapshot.FileInfo dvdFileInfo = new BlobStoreIndexShardSnapshot.FileInfo(
        } catch (EOFException e) {
        final TestOnDemandPrefetchBlockSnapshotIndexInput blockedSnapshotFile = createTestOnDemandPrefetchBlockSnapshotIndexInput(23);  
    public void testChunkedRepositoryWithBlockSizeLessThanChunkSize() throws IOException {  
        int numOfBlocks = FILE_SIZE / blockSize;
        assertTrue(indexInput.checkIfFileEnabledReadAhead());  
            fileCache,  
                    FILE_NAME,
    public void test8MBBlock() throws Exception {  
        tieringServicePrefetchSettings.setStoredFieldsPrefetchEnabled(false);
import org.apache.lucene.store.IOContext;
    public void testChunkedRepositoryWithBlockSizeGreaterThanChunkSize() throws IOException {
        );
        verify(transferManager, never()).fetchBlobAsync(any(BlobFetchRequest.class));  
        clusterSettingsToAdd.add(TieredStoragePrefetchSettings.STORED_FIELDS_PREFETCH_ENABLED_SETTING);
import static org.mockito.ArgumentMatchers.argThat;
    private static final boolean IS_CLONE = false;
        FSDirectory directory = null;  
import java.io.EOFException;
                    new ByteSizeValue(repositoryChunkSize)
        assertEquals(1, input.currentBlockPosition());
/*  
                .resourceDescription(RESOURCE_DESCRIPTION)  
        threadPool = new TestThreadPool("PrefetchBlockSnapshotIndexInputTests");
        try {
                .resourceDescription(RESOURCE_DESCRIPTION)
        assertFalse(indexInput.checkIfFileEnabledReadAhead());
        byte[] buf = new byte[4];
        final TestOnDemandPrefetchBlockSnapshotIndexInput blockedSnapshotFile = createTestOnDemandPrefetchBlockSnapshotIndexInput(23);  
            return blobFetchRequest.getDirectory().openInput(blobFetchRequest.getFileName(), IOContext.READONCE);
        );  
        verify(transferManager, times(3)).fetchBlobAsync(any(BlobFetchRequest.class));
        clusterSettingsToAdd.add(TieredStoragePrefetchSettings.READ_AHEAD_BLOCK_COUNT);
        assertEquals(12464, input.readShort());
                .offset(BLOCK_SNAPSHOT_FILE_OFFSET)  
    }
            threadPool,  
        final TestOnDemandPrefetchBlockSnapshotIndexInput blockedSnapshotFile = createTestOnDemandPrefetchBlockSnapshotIndexInput(23);
        try {  
import org.opensearch.core.common.unit.ByteSizeValue;
        );  
        assertEquals(blockSize, input.currentBlockStart());
        int blockSize = 1 << blockSizeShift;
        assertTrue(indexInput.checkIfFileEnabledReadAhead());
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY, concurrencyLevel);
    private void verifyChunkedRepository(long blockSize, long repositoryChunkSize, long fileSize) throws IOException {
    public void testPrefetch() throws Exception {
import org.apache.lucene.store.LockFactory;
        assertTrue(blockedSnapshotFile.checkIfStoredFieldsPrefetchEnabled());
            }
            new ByteSizeValue(15, ByteSizeUnit.KB).getBytes()
        verify(transferManager, times(6)).fetchBlobAsync(any(BlobFetchRequest.class));
                RESOURCE_DESCRIPTION,  
        verifyChunkedRepository(
    }
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
        // Create block files with the dvd file name prefix  
    private BlobStoreIndexShardSnapshot.FileInfo fileInfo;  
            return blobFetchRequest.getDirectory().openInput(blobFetchRequest.getFileName(), IOContext.READONCE);  
        path = createTempDir("TestOnDemandPrefetchBlockSnapshotIndexInputTests");  
    protected static final int FILE_CACHE_CAPACITY = 10000000;  
        IndexInput result = blockedSnapshotFile.fetchBlockPublic(0);
    }
import org.opensearch.test.OpenSearchTestCase;
import static org.mockito.Mockito.doAnswer;
    private ThreadPool threadPool;
        input.seek(0);
                .resourceDescription(RESOURCE_DESCRIPTION)
                    new StoreFileMetadata(FILE_NAME, fileSize, "", Version.LATEST),  
        throws IOException {
import static org.mockito.Mockito.never;
            BlobFetchRequest blobFetchRequest = invocation.getArgument(0);
    }
    private static final String FILE_NAME = "File_Name";
            new ByteSizeValue(3, ByteSizeUnit.KB).getBytes()
        assertEquals(0, input.getBlockOffset(blockSize));
        }  
                fileCache,  
import static org.mockito.ArgumentMatchers.any;  
                for (int j = 0; j < blockSize / 2; j++) {
        input.seek(0);  
            BlobFetchRequest blobFetchRequest = invocation.getArgument(0);
        assertEquals((FILE_SIZE - 1) / blockSize, input.getBlock(FILE_SIZE - 1));  
        return new TestOnDemandPrefetchBlockSnapshotIndexInput(
            fail("fail to initialize block files: " + e.getMessage());
    public void testSettings() throws Exception {
            transferManager,
                }  
        }  
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(),
        input.seek(blockSize);
            null
        // testReadBytes
    }
        assertEquals(816853168, input.readInt());
                        output.writeByte((byte) -80);
import static org.mockito.Mockito.times;
        blockedSnapshotFile.downloadBlocksAsync(0, 1, false);  
    public void testChunkedRepositoryWithBlockSizeEqualToChunkSize() throws IOException {
        assertEquals((byte) 48, buf[0]);  
        // Disable stored fields prefetch via settings
        final TestOnDemandPrefetchBlockSnapshotIndexInput blockedSnapshotFile = createTestOnDemandPrefetchBlockSnapshotIndexInput(23);
        }
        fileInfo = new BlobStoreIndexShardSnapshot.FileInfo(fileName, new StoreFileMetadata(fileName, FILE_SIZE, "", Version.LATEST), null);
        }).when(transferManager).fetchBlob(any());  
        doAnswer(invocation -> {
                output.close();  
        input.seek(blockSize - 1);
        int sizeOfLastBlock = FILE_SIZE % blockSize;
        }
        input.seek(0);
                .blockSizeShift(blockSizeShift)  
    private TestOnDemandPrefetchBlockSnapshotIndexInput createDvdFileIndexInput(int blockSizeShift) throws IOException {
            // expected
            RESOURCE_DESCRIPTION,
                IndexOutput output = fsDirectory.createOutput(blockName, null);
import org.apache.lucene.store.IndexOutput;  
        blockedSnapshotFile.prefetch(0, 10);
        int blockSize = 1 << blockSizeShift;
                threadPool,
        );
        blockedSnapshotFile.prefetch(0, 10);
            new ByteSizeValue(15, ByteSizeUnit.KB).getBytes()  
                        output.writeByte((byte) 48);
            fail("Should throw EOFException");  
import org.opensearch.index.store.remote.file.AbstractBlockIndexInput;
import org.opensearch.common.lucene.store.ByteArrayIndexInput;  
            input.seek(FILE_SIZE + 1);
        assertEquals((byte) -80, input.readByte());  
        input.seek(blockSize - 1);
        input.seek(blockSize * 2 - 1);  
                String blockName = BLOCK_FILE_PREFIX + "_block_" + i;  
            if (numOfBlocks > 1 && sizeOfLastBlock != 0) {
    }
    }
    public void test1MBBlock() throws Exception {
        );  
                for (int i = 0; i < sizeOfLastBlock; i++) {
            threadPool,
 * this file be licensed under the Apache-2.0 license or a
        // Fetch a block that exists (should be cache hit)  
        threadPool.shutdownNow();
        try {
        try {
        indexInput = getIndexInput("_0.cfs", "lucene9.dvd");  
        assertEquals((byte) -80, buf[1]);
import org.opensearch.index.store.remote.utils.TransferManager;
                getPrefetchSettingsSupplier()
            directory,
                    } else {  
        // testGetTotalBlocks
        assertEquals(blockSize - 1, input.currentBlockPosition());
    public void testPrefetchDisabledBySettings() throws Exception {  
    }  
                .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
        int sizeOfLastBlock = FILE_SIZE % blockSize;
                String lastBlockName = dvdFileName + "_block_" + numOfBlocks;
    }  
            )
    TestOnDemandPrefetchBlockSnapshotIndexInput getIndexInput(String fileName, String resourceDescription) {
            directory = new MMapDirectory(path, lockFactory);
        indexInput = getIndexInput("_1.fdt", "clone");
            fail("fail to create MMapDirectory: " + e.getMessage());
        input.seek(blockSize + 1);  
        input.seek(blockSize - 1);
    FileCache fileCache;  
                .isClone(IS_CLONE),
            directory = new MMapDirectory(path, lockFactory);
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(),
                output.close();
            directory,  
                ),
        runAllTestsFor(12);
import org.opensearch.threadpool.TestThreadPool;  
            transferManager,  
                IndexOutput output = directory.createOutput(lastBlockName, null);  
    public void testReadAheadEnabled() throws Exception {
        // testReadLong
        }
import static org.mockito.Mockito.verify;  
        blockedSnapshotFile.prefetch(0, 8388670);
        } catch (IOException e) {
    private void initBlockFiles(int blockSize, FSDirectory fsDirectory) {  
import org.opensearch.index.store.StoreFileMetadata;
        verifyChunkedRepository(
    private void runAllTestsFor(int blockSizeShift) throws Exception {
        TestOnDemandPrefetchBlockSnapshotIndexInput clonedFile = (TestOnDemandPrefetchBlockSnapshotIndexInput) input.clone();
import org.junit.Before;
        fileInfo = new BlobStoreIndexShardSnapshot.FileInfo(
import org.apache.lucene.store.FSDirectory;  
        try (  
                .length(FILE_SIZE)
                    .isClone(IS_CLONE),
        FSDirectory directory = null;
import java.nio.file.Path;  
        lockFactory = SimpleFSLockFactory.INSTANCE;
        // testReadShort
    }
    @Override
            for (int i = 0; i < numOfBlocks; i++) {
        int concurrencyLevel = randomIntBetween(1, 2);
        assertEquals((byte) -80, buf[3]);  
            AbstractBlockIndexInput.builder()  
    }  
                output.close();
import java.util.Set;
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;  
        // testSeek
package org.opensearch.storage.prefetch;
                IndexOutput output = fsDirectory.createOutput(lastBlockName, null);
    public Supplier<TieredStoragePrefetchSettings> getPrefetchSettingsSupplier() {
    private static final String BLOCK_FILE_PREFIX = FILE_NAME;  
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
    }
                    output.writeByte((byte) ((i & 1) == 0 ? 48 : -80));
                IndexOutput output = directory.createOutput(blockName, null);  
                }
            null
                .length(FILE_SIZE)  
        assertEquals(0, input.getFilePointer());
        try {  
            fileCache,
                .isClone(IS_CLONE),
        assertFalse(blockedSnapshotFile.checkIfFileEnabledReadAhead());  
    }  
            fileInfo,
    }
import static org.mockito.Mockito.mock;  
            new ByteSizeValue(8, ByteSizeUnit.KB).getBytes(),  
        assertEquals(1, input.getBlockOffset(1));  
        try {
        assertEquals(1, input.getBlock(blockSize));
        // prefetch should be a no-op when disabled
        // testReadByte
    }
        input.seek(0);  
        when(transferManager.fetchBlob(any())).thenReturn(new ByteArrayIndexInput("test", new byte[(int) blockSize]));
        } catch (IOException e) {  
        input.seek(blockSize + 11);
    public void init() {
                String lastBlockName = BLOCK_FILE_PREFIX + "_block_" + numOfBlocks;
        input.seek(0);  
        FSDirectory directory = null;
        assertEquals((FILE_SIZE - 1) % blockSize, input.getBlockOffset(FILE_SIZE - 1));
        final TestOnDemandPrefetchBlockSnapshotIndexInput blockedSnapshotFile = createTestOnDemandPrefetchBlockSnapshotIndexInput(23);  
                    output.writeByte((byte) 48);
            AbstractBlockIndexInput.builder()
        assertEquals(-5750903000991223760L, input.readLong());  
    public void test4KBBlock() throws Exception {
        assertEquals(-20432, input.readShort());  
        // testGetBlockStart
                }  
        assertEquals((byte) 48, buf[2]);
        }).when(transferManager).fetchBlob(any());
        assertEquals(blockSize, input.getBlockStart(1));  
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;  
        return new TestOnDemandPrefetchBlockSnapshotIndexInput(  
        indexInput = getIndexInput("_1.cfe", "lucene9.dvd");
            }
                    .blockSizeShift((int) (Math.log(blockSize) / Math.log(2)))
        // testReadInt
                output.close();
            dvdFileInfo,  
import org.apache.lucene.store.SimpleFSLockFactory;  
            resourceDescription,  
        TestOnDemandPrefetchBlockSnapshotIndexInput indexInput = getIndexInput("lucene.dvd", "clone");
import org.opensearch.common.settings.Setting;
    }  
        assertEquals(0L, input.getBlockStart(0));
    public void tearDown() throws Exception {
            dvdFileName,
                    if ((i & 1) == 0) {
import org.apache.lucene.util.Constants;
            getPrefetchSettingsSupplier()  
        assertEquals(blockSize * 2, input.getBlockStart(2));
}
        assertEquals(clonedFile.getFilePointer(), input.getFilePointer());
            FILE_NAME,  
    private static final long BLOCK_SNAPSHOT_FILE_OFFSET = 0;
                transferManager,
        );
            for (int i = 0; i < numOfBlocks; i++) {
                    output.writeByte((byte) -80);  
        runAllTestsFor(20);  
        input.seek(blockSize + 1);
                for (int j = 0; j < blockSize / 2; j++) {
import org.opensearch.threadpool.ThreadPool;
            directory = new MMapDirectory(path, lockFactory);  
                for (int i = 0; i < sizeOfLastBlock; i++) {  
    public void test4MBBlock() throws Exception {  
        assumeFalse("Awaiting Windows fix https://github.com/opensearch-project/OpenSearch/issues/5396", Constants.WINDOWS);
            new StoreFileMetadata(dvdFileName, FILE_SIZE, "", Version.LATEST),  
            RESOURCE_DESCRIPTION,
        assertEquals(0, input.getBlock(0L));
        String dvdFileName = "_0.dvd";  
    private TransferManager transferManager;
        } catch (IOException e) {  
                .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
                AbstractBlockIndexInput.builder()  
        assertEquals((byte) 48, input.readByte());
                    .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
public class OnDemandPrefetchBlockSnapshotIndexInputTests extends OpenSearchTestCase {
import org.opensearch.index.store.remote.filecache.FileCache;
            AbstractBlockIndexInput.builder()
    private TestOnDemandPrefetchBlockSnapshotIndexInput createTestOnDemandPrefetchBlockSnapshotIndexInput(int blockSizeShift)  

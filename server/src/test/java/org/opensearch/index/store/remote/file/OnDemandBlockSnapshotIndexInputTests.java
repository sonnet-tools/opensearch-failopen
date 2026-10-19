            fileInfo,  
            assertEquals(0, blockedSnapshotFile.getBlock(0L));
            assertEquals(blockSize * 2, blockedSnapshotFile.getBlockStart(2));  
            // block 1
            assertEquals(
            assertNotEquals(newSlice.length, blockedSnapshotFile.length);
import static org.mockito.Mockito.mock;
        TestGroup.testSlice(blockedSnapshotFile, blockSize);
            blockedSnapshotFile.seek(blockSize + 11);
            blockedSnapshotFile.seek(blockSize - 1);
            assertEquals(0, blockedSnapshotFile.currentBlockPosition());
            AbstractBlockIndexInput.builder()  
        // Verify all the chunks related to block are added to the fetchBlob request
        transferManager = mock(TransferManager.class);
                (blockEnd - blockStart),  
            assertEquals(-1338986448, blockedSnapshotFile.readInt());
            assertEquals(
                .length(FILE_SIZE)  
            assertEquals(blockSize - 1, blockedSnapshotFile.currentBlockPosition());
    }
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(), // repository chunk size
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;  
            // block 0  
import org.opensearch.core.common.unit.ByteSizeValue;
                IndexOutput output = fsDirectory.createOutput(lastBlockName, null);
        }
        when(transferManager.fetchBlob(any())).thenReturn(new ByteArrayIndexInput("test", new byte[(int) blockSize]));  
        TestGroup.testReadBytes(blockedSnapshotFile, blockSize);
            blockedSnapshotFile.seek(blockSize);
                transferManager
        } catch (IOException e) {
        );  
    }
        TestGroup.testGetBlockOffset(blockedSnapshotFile, blockSize, FILE_SIZE);
            blockEnd = blockStart + AbstractBlockIndexInput.getActualBlockSize(blockId, blockSizeShift, FILE_SIZE);
                    output.writeByte((byte) -80);  
                for (int j = 0; j < blockSize / 2; j++) {
        TestGroup.testGetFilePointer(blockedSnapshotFile, blockSize);
import org.opensearch.common.lucene.store.ByteArrayIndexInput;  
                output.close();
        path = createTempDir("OnDemandBlockSnapshotIndexInputTests");
                // since block size is always even number, safe to do division
        runAllTestsFor(23);
                    .isClone(IS_CLONE),  
            // write 48, -80 alternatively
    private static class TestGroup {
            int blockId = 0;
        }
            assertEquals(1, blockedSnapshotFile.currentBlockPosition());
import static org.mockito.Mockito.any;  
                blockedSnapshotFile.seek(fileSize + 1);
            assertEquals(-20432, blockedSnapshotFile.readShort());
        }  
                String blockName = BLOCK_FILE_PREFIX + "_block_" + i;
            }
            assertEquals(10, newSlice.currentBlockPosition());
            fail("Able to seek past end");  
            assertEquals(clonedFile.currentBlockPosition(), blockedSnapshotFile.currentBlockPosition());  
        TestGroup.testGetBlockStart(blockedSnapshotFile, blockSize);
                IndexOutput output = fsDirectory.createOutput(blockName, null);  
        runAllTestsFor(20);
            indexInput.seek(repositoryChunkSize);
            } catch (EOFException e) {  
                    // byte 10110000
            new StoreFileMetadata(FILE_NAME, FILE_SIZE, "", Version.LATEST),
            new ByteSizeValue(3, ByteSizeUnit.KB).getBytes() // file size
            // 6 byte in block 0, 2 byte in block 2
    private void runAllTestsFor(int blockSizeShift) throws Exception {  
import org.apache.lucene.store.MMapDirectory;
            );
 * compatible open source license.
                    new StoreFileMetadata(FILE_NAME, fileSize, "", Version.LATEST),  
            blockedSnapshotFile.seek(blockSize + 1);
        TestGroup.testGetBlobParts(blockedSnapshotFile, blockSizeShift);  
        final int blockSize = 1 << blockSizeShift;
            assertEquals(-1338986448, blockedSnapshotFile.readInt(0));
            null  
            assertEquals(newSlice.transferManager, blockedSnapshotFile.transferManager);
    private Path path;  
    }  
import org.apache.lucene.util.Constants;
            blockedSnapshotFile.seek(blockSize - 2);
                return;
            OnDemandBlockSnapshotIndexInput newSlice = (OnDemandBlockSnapshotIndexInput) slice;
                ),
        public static void testReadLong(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
            assertEquals(816853168, blockedSnapshotFile.readInt(blockSize - 3));  
}  
            assertEquals(3508357643010846896L, blockedSnapshotFile.readLong());
    private OnDemandBlockSnapshotIndexInput createOnDemandBlockSnapshotIndexInput(int blockSizeShift) throws IOException,
            IndexInput slice = blockedSnapshotFile.slice("slice", blockSize - 11, 22);
            blockedSnapshotFile.seek(0);  
                    } else {  
import org.opensearch.index.store.StoreFileMetadata;
            }
package org.opensearch.index.store.remote.file;
            blockedSnapshotFile.seek(blockSize - 11);  
        public static void testCurrentBlockPosition(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
            long blockEnd = blockStart + AbstractBlockIndexInput.getActualBlockSize(blockId, blockSizeShift, FILE_SIZE);
            assertNotEquals(newSlice.offset, blockedSnapshotFile.offset);  
            assertEquals(1, blockedSnapshotFile.getBlock(blockSize));
        int sizeOfLastBlock = FILE_SIZE % blockSize;  
    private LockFactory lockFactory;
            );
            return blobFetchRequest.getDirectory().openInput(blobFetchRequest.getFileName(), IOContext.READONCE);
        TestGroup.testReadVInt(blockedSnapshotFile, blockSize);
            assertEquals(48, blockedSnapshotFile.readVLong());  
    private void verifyChunkedRepository(long blockSize, long repositoryChunkSize, long fileSize) throws IOException {
        verifyChunkedRepository(
        }
                    if ((i & 1) == 0) {
            // block 0
            blockedSnapshotFile.seek(0);  
        public static void testReadShortWithPos(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
            assertEquals(newSlice.directory, blockedSnapshotFile.directory);
                new BlobStoreIndexShardSnapshot.FileInfo(
 */  
            assertEquals((byte) -80, blockedSnapshotFile.readByte());  
        runAllTestsFor(22);
                    .blockSizeShift((int) (Math.log(blockSize) / Math.log(2)))
            // block size will always be an integer multiple of frame size
                }  
            blockStart = blockedSnapshotFile.getBlockStart(blockId);  
            blockId = 1;
            assertEquals(816853168, blockedSnapshotFile.readInt());
import java.io.IOException;
        try (
import org.opensearch.index.store.remote.utils.BlobFetchRequest;
            OnDemandBlockSnapshotIndexInput clonedFile = blockedSnapshotFile.clone();
            blockStart = blockedSnapshotFile.getBlockStart(blockId);  
            assertEquals(5, blockedSnapshotFile.currentBlockPosition());  
                (blockEnd - blockStart),  
            // use MMapDirectory to create block  
    public void testChunkedRepositoryWithBlockSizeLessThanChunkSize() throws IOException {
        try {
        }
                String lastBlockName = BLOCK_FILE_PREFIX + "_block_" + numOfBlocks;
            for (int i = 0; i < numOfBlocks; i++) {  
            assertEquals(-5750903000991223760L, blockedSnapshotFile.readLong(blockSize - 6));
            // block 0
        runAllTestsFor(12);  
            assertEquals(3508357643010846896L, blockedSnapshotFile.readLong(blockSize - 7));
        }
        public static void testReadVInt(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
                return;  
        }
import org.apache.lucene.store.IndexOutput;  
import org.apache.lucene.store.LockFactory;
        InterruptedException {  
            try {  
        ) {  
            blockedSnapshotFile.readBytes(byteArr, 0, 2);
            assertEquals(-1338986448, blockedSnapshotFile.readInt(blockSize));  
            blockedSnapshotFile.seek(0);
            new ByteSizeValue(1, ByteSizeUnit.KB).getBytes(), // block Size  
            // block 1
            // block 1
            // block 2
            assertEquals(0, blockedSnapshotFile.currentBlockPosition());
            blockedSnapshotFile.seek(blockSize * 2 + 11);
import org.apache.lucene.store.SimpleFSLockFactory;  
        public static void testGetBlobParts(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSizeShift) {  
    public void testChunkedRepositoryWithBlockSizeEqualToChunkSize() throws IOException {  
    private static final String FILE_NAME = "File_Name";
            assertEquals(blockSize - 11, blockedSnapshotFile.currentBlockPosition());
import org.apache.lucene.store.IOContext;
            blockedSnapshotFile.seek(blockSize + 5);
        public static void testReadIntWithPos(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
    private static final long BLOCK_SNAPSHOT_FILE_OFFSET = 0;
                    // byte 00110000  
 * SPDX-License-Identifier: Apache-2.0
                newSlice.seek(23);
        public static void testReadLongWithPos(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(), // repository chunk size
    // params shared by all test cases
        }
                    output.writeByte((byte) 48);
            directory,
            assertEquals(-5750903000991223760L, blockedSnapshotFile.readLong());
import java.io.EOFException;
        }
            assertEquals(11, blockedSnapshotFile.currentBlockPosition());  
            assertEquals(-20432, blockedSnapshotFile.readShort(blockSize));
            assertEquals((byte) 48, blockedSnapshotFile.readByte());
    @Before
            assertEquals(newSlice.blockMask, blockedSnapshotFile.blockMask);
        public static void testReadShort(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
import org.junit.Before;
        );
            )
    private static final int FILE_SIZE = 29360128;
            assertEquals(-5750903000991223760L, blockedSnapshotFile.readLong(0));
            assertEquals(12464, blockedSnapshotFile.readShort());
    }
import static org.mockito.Mockito.verify;  
            blockedSnapshotFile.seek(blockSize - 1);  
        TestGroup.testReadInt(blockedSnapshotFile, blockSize);
    public void testChunkedRepositoryWithBlockSizeGreaterThanChunkSize() throws IOException {
            assertEquals(6192, blockedSnapshotFile.readVLong());  
                // create normal blocks
            }  
            blockEnd = blockStart + AbstractBlockIndexInput.getActualBlockSize(blockId, blockSizeShift, FILE_SIZE);
            byte[] byteArr = new byte[2];  
        public static void testReadByteWithPos(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {  
            // 5 byte in block 0, 3 byte in block 3
            assertEquals(-5750903000991223760L, blockedSnapshotFile.readLong());  
        }
/*  
        TestGroup.testReadByteWithPos(blockedSnapshotFile, blockSize);  
                for (int i = 0; i < sizeOfLastBlock; i++) {  
            new ByteSizeValue(15, ByteSizeUnit.KB).getBytes() // file size  
            try {
        TestGroup.testReadLong(blockedSnapshotFile, blockSize);  
            assertEquals(48, blockedSnapshotFile.readByte(blockSize));
        assumeFalse("Awaiting Windows fix https://github.com/opensearch-project/OpenSearch/issues/5396", Constants.WINDOWS);
        verifyChunkedRepository(
            assertEquals(-1338986448, blockedSnapshotFile.readInt());
            assertEquals(-1338986448, blockedSnapshotFile.readInt(blockSize - 2));
            // 2 byte in block 0, 2 byte in block 1
                    .length(FILE_SIZE)
        TestGroup.testReadByte(blockedSnapshotFile, blockSize);  
            // 2 byte in block 0, 2 byte in block 1  
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(blockSize * 2, blockedSnapshotFile.currentBlockStart());
import org.opensearch.core.common.unit.ByteSizeUnit;
            assertEquals(3508357643010846896L, blockedSnapshotFile.readLong(blockSize - 5));
            assertEquals(-20432, blockedSnapshotFile.readShort(0));  
    }
            blockedSnapshotFile.seek(blockSize - 5);  
public class OnDemandBlockSnapshotIndexInputTests extends OpenSearchTestCase {
        }  
    }  
                        output.writeByte((byte) -80);
            // block 2
            BlobFetchRequest blobFetchRequest = invocation.getArgument(0);  
            // 7 byte in block 0, 1 byte in block 1
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            // 1 byte in block 0, 3 byte in block 1  
            if (numOfBlocks > 1 && sizeOfLastBlock != 0) {
            blockedSnapshotFile.seek(blockSize - 1);
        FSDirectory directory = null;
            assertEquals(48, blockedSnapshotFile.readByte(0));
    }
            // end block
        }).when(transferManager).fetchBlob(any());
        }  
    private static final String BLOCK_FILE_PREFIX = FILE_NAME;  
        initBlockFiles(blockSize, directory);  
            blockedSnapshotFile.seek(blockSize);  
            new ByteSizeValue(15, ByteSizeUnit.KB).getBytes() // file size
        public static void testClone(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {  
            blockedSnapshotFile.seek(blockSize * 3 - 1);  
        try {
        TestGroup.testReadLongWithPos(blockedSnapshotFile, blockSize);  
                blockedSnapshotFile.getBlobParts(blockStart, blockEnd).stream().mapToLong(o -> o.getLength()).sum()
            // block 1  
        return new OnDemandBlockSnapshotIndexInput(
            new ByteSizeValue(8, ByteSizeUnit.KB).getBytes(), // block Size
import org.apache.lucene.store.IndexInput;
                    }
        public static void testCurrentBlockStart(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
            assertEquals(6192, blockedSnapshotFile.readVInt());
        int blockSize = 1 << blockSizeShift;  
    }
            assertEquals(21, newSlice.getFilePointer());  
            blockedSnapshotFile.seek(0);  
                    .resourceDescription(RESOURCE_DESCRIPTION)
            // block 2
            assertEquals(newSlice.isClone, true);
            assertEquals(0, blockedSnapshotFile.getBlockOffset(blockSize));
                .resourceDescription(RESOURCE_DESCRIPTION)
                        output.writeByte((byte) 48);
        TestGroup.testCurrentBlockStart(blockedSnapshotFile, blockSize);
            FILE_NAME,
import org.apache.lucene.util.Version;
            blockedSnapshotFile.seek(blockSize - 1);  
                directory,  
        final OnDemandBlockSnapshotIndexInput blockedSnapshotFile = createOnDemandBlockSnapshotIndexInput(blockSizeShift);
        }
    private BlobStoreIndexShardSnapshot.FileInfo fileInfo;
            blockedSnapshotFile.seek(0);  
        );  
            // 6 byte in block 0, 2 byte in block 2
            assertEquals(newSlice.blockSizeShift, blockedSnapshotFile.blockSizeShift);  
        TestGroup.testGetBlock(blockedSnapshotFile, blockSize, FILE_SIZE);  
import static org.mockito.ArgumentMatchers.argThat;
            assertEquals(816853168, blockedSnapshotFile.readInt());
            assertEquals(-5750903000991223760L, blockedSnapshotFile.readLong(blockSize - 4));
    }
        }
        TestGroup.testReadShort(blockedSnapshotFile, blockSize);
    }
    }
        doAnswer(invocation -> {
            assertEquals(48, blockedSnapshotFile.readVInt());
            assertEquals(-80, blockedSnapshotFile.readByte(1));
        }  
            );
            blockedSnapshotFile.seek(0);
            // 7 byte in block 0, 1 byte in block 1  
        }  
            // block id 0
            assertEquals(816853168, blockedSnapshotFile.readInt(blockSize - 1));
                output.close();
            fail("fail to initialize block files: " + e.getMessage());
        public static void testReadInt(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
            assertEquals(-1338986448, blockedSnapshotFile.readInt());
    }
            assertEquals(clonedFile.getFilePointer(), blockedSnapshotFile.getFilePointer());
            long blockStart = blockedSnapshotFile.getBlockStart(blockId);  
            assertEquals((byte) -80, blockedSnapshotFile.readByte());  
        public static void testReadBytes(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
        int numOfBlocks = FILE_SIZE / blockSize;
        // file info should be initialized per test method since file size need to be calculated
                }
            // 4 byte in block 0, 4 block in block 4
        TestGroup.testReadShortWithPos(blockedSnapshotFile, blockSize);
        public static void testGetBlockStart(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) {
            assertEquals(newSlice.fileName, blockedSnapshotFile.fileName);  
            assertEquals(-80, byteArr[1]);
    // create OnDemandBlockSnapshotIndexInput for each block size
    private void initBlockFiles(int blockSize, FSDirectory fsDirectory) {  
            assertEquals(48, byteArr[0]);  
                    .offset(BLOCK_SNAPSHOT_FILE_OFFSET)  
            // 4 byte in block 0, 4 block in block 4  
            }
                blockedSnapshotFile.getBlobParts(blockStart, blockEnd).stream().mapToLong(o -> o.getLength()).sum()
            assertEquals(blockSize, blockedSnapshotFile.currentBlockStart());  
            transferManager
            assertEquals(-20432, blockedSnapshotFile.readShort());
            // cross block 0 and block 1  
            // block 2
            assertEquals(1, blockedSnapshotFile.getBlockOffset(1));
                    new ByteSizeValue(repositoryChunkSize)
    private static final String RESOURCE_DESCRIPTION = "Test OnDemandBlockSnapshotIndexInput Block Size";  
import java.nio.file.Path;  
import org.opensearch.test.OpenSearchTestCase;
            assertEquals(12464, blockedSnapshotFile.readShort(blockSize - 1));  
        fileInfo = new BlobStoreIndexShardSnapshot.FileInfo(  
            blockedSnapshotFile.seek(blockSize - 3);
        }  
            blockedSnapshotFile.seek(0);
            assertNotEquals(clonedFile.currentBlockPosition(), blockedSnapshotFile.currentBlockPosition());  
            assertEquals(3508357643010846896L, blockedSnapshotFile.readLong());
            blockedSnapshotFile.seek(0);  
 *
import static org.mockito.Mockito.doAnswer;
        public static void testGetFilePointer(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
            blockedSnapshotFile.seek(blockSize - 1);  
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(), // repository chunk size  
import org.apache.lucene.store.FSDirectory;  
                    FILE_NAME,
            blockedSnapshotFile.seek(blockSize + 1);
            // block 1
    public void test4KBBlock() throws Exception {
                // create last block  
            blockedSnapshotFile.seek(1);
            assertEquals(11, blockedSnapshotFile.currentBlockPosition());
        lockFactory = SimpleFSLockFactory.INSTANCE;  
            // block 0
            // block 1  
            assertEquals(-80, byteArr[0]);
                .blockSizeShift(blockSizeShift)
            // Seek to the position past the first repository chunk
            assertEquals(newSlice.blockSize, blockedSnapshotFile.blockSize);
        public static void testGetBlock(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize, int fileSize) {  
            assertEquals(
    public void test1MBBlock() throws Exception {  
                blockedSnapshotFile.getBlobParts(blockStart, blockEnd).stream().mapToLong(o -> o.getLength()).sum()
            assertEquals(48, byteArr[1]);  
            directory = new MMapDirectory(path, lockFactory);
        TestGroup.testCurrentBlockPosition(blockedSnapshotFile, blockSize);
            blockedSnapshotFile.seek(blockSize);  
            fail("fail to create MMapDirectory: " + e.getMessage());  
    private static final boolean IS_CLONE = false;
            assertEquals((fileSize - 1) / blockSize, blockedSnapshotFile.getBlock(fileSize - 1));
        }
    public void test8MBBlock() throws Exception {
                (blockEnd - blockStart),  
        }  
            blockedSnapshotFile.seek(blockSize - 4);
            blockedSnapshotFile.readBytes(byteArr, 0, 2);
        public static void testSeek(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize, int fileSize) throws IOException {  
        );
            assertEquals((fileSize - 1) % blockSize, blockedSnapshotFile.getBlockOffset(fileSize - 1));
        }  
            fail("Able to seek past file end");
            // 3 byte in block 0, 1 byte in block 1
            assertEquals((byte) 48, blockedSnapshotFile.readByte());
                .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
            // block 0  
    }  
            // end block  
 * The OpenSearch Contributors require contributions made to  
            blockedSnapshotFile.seek(blockSize - 7);
            assertEquals(blockSize, blockedSnapshotFile.getBlockStart(1));  
            newSlice.seek(21);
        }  
            // 3 byte in block 0, 1 byte in block 1  
    public void init() {  
            // 5 byte in block 0, 3 byte in block 3
        verifyChunkedRepository(  
            assertEquals(-5750903000991223760L, blockedSnapshotFile.readLong());
            blockedSnapshotFile.seek(1);
        }  
            // 1 byte in block 0, 3 byte in block 1  
        }  
        verify(transferManager).fetchBlob(argThat(request -> request.getBlobLength() == blockSize));  
            newSlice.seek(0);
            clonedFile.seek(blockSize + 11);
            FSDirectory directory = new MMapDirectory(path, lockFactory);
            blockedSnapshotFile.seek(blockSize - 1);
        );
        public static void testGetBlockOffset(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize, int fileSize) {
            blockedSnapshotFile.seek(blockSize * 2);
            assertEquals(blockSize - 11, newSlice.currentBlockPosition());
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(), // block Size
        TestGroup.testReadIntWithPos(blockedSnapshotFile, blockSize);
                AbstractBlockIndexInput.builder()
            assertEquals(-80, blockedSnapshotFile.readByte(blockSize + 1));
    private TransferManager transferManager;  
            blockedSnapshotFile.seek(blockSize - 1);
    public void test4MBBlock() throws Exception {
import org.opensearch.index.store.remote.utils.TransferManager;  
import static org.mockito.Mockito.when;
        public static void testReadVLong(OnDemandBlockSnapshotIndexInput blockedSnapshotFile) throws IOException {
        }  
            assertEquals(0L, blockedSnapshotFile.currentBlockStart());
            assertEquals(12464, blockedSnapshotFile.readShort(1));
        public static void testReadByte(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
        TestGroup.testClone(blockedSnapshotFile, blockSize);  
            assertEquals(0, newSlice.getFilePointer());  
        } catch (IOException e) {
            blockedSnapshotFile.seek(blockSize - 6);
            assertEquals(0L, blockedSnapshotFile.getBlockStart(0));  
            IndexInput indexInput = new OnDemandBlockSnapshotIndexInput(  
                .isClone(IS_CLONE),
            blockedSnapshotFile.seek(blockSize * 2 - 1);
        public static void testSlice(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {  
        TestGroup.testSeek(blockedSnapshotFile, blockSize, FILE_SIZE);
            } catch (EOFException e) {
            blockId = 2;

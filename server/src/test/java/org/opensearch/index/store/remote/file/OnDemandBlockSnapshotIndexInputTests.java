public class OnDemandBlockSnapshotIndexInputTests extends OpenSearchTestCase {
                .isClone(IS_CLONE),
            assertEquals(-20432, blockedSnapshotFile.readShort());
            assertEquals(-20432, blockedSnapshotFile.readShort(0));
        public static void testReadInt(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
                    // byte 10110000
import static org.mockito.ArgumentMatchers.argThat;
            assertEquals(48, byteArr[1]);
            // block 0
            try {
    }
    private static final long BLOCK_SNAPSHOT_FILE_OFFSET = 0;
            assertEquals(-80, blockedSnapshotFile.readByte(blockSize + 1));
            newSlice.seek(0);
            blockedSnapshotFile.seek(0);
            assertEquals(-80, byteArr[1]);
            byte[] byteArr = new byte[2];
                    .blockSizeShift((int) (Math.log(blockSize) / Math.log(2)))
            IndexInput indexInput = new OnDemandBlockSnapshotIndexInput(
            // 7 byte in block 0, 1 byte in block 1
            FSDirectory directory = new MMapDirectory(path, lockFactory);
        public static void testSlice(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
        TestGroup.testReadShort(blockedSnapshotFile, blockSize);
        // Verify all the chunks related to block are added to the fetchBlob request
                output.close();
            assertNotEquals(newSlice.offset, blockedSnapshotFile.offset);
        return new OnDemandBlockSnapshotIndexInput(
            assertEquals(1, blockedSnapshotFile.getBlockOffset(1));
        } catch (IOException e) {
        TestGroup.testCurrentBlockStart(blockedSnapshotFile, blockSize);
    }
            // 4 byte in block 0, 4 block in block 4
            )
            blockedSnapshotFile.seek(blockSize + 1);
            assertEquals(48, blockedSnapshotFile.readVInt());
import java.nio.file.Path;
        public static void testReadLongWithPos(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
                    .length(FILE_SIZE)
        TestGroup.testGetBlock(blockedSnapshotFile, blockSize, FILE_SIZE);
            blockedSnapshotFile.seek(blockSize - 1);
            }
            // use MMapDirectory to create block
            FILE_NAME,
            blockEnd = blockStart + AbstractBlockIndexInput.getActualBlockSize(blockId, blockSizeShift, FILE_SIZE);
        }
            transferManager
        TestGroup.testGetBlockStart(blockedSnapshotFile, blockSize);
        TestGroup.testCurrentBlockPosition(blockedSnapshotFile, blockSize);
        }
                (blockEnd - blockStart),
                    } else {
        runAllTestsFor(23);
            blockedSnapshotFile.seek(blockSize - 1);
            // block 2
            assertEquals(816853168, blockedSnapshotFile.readInt());
        int numOfBlocks = FILE_SIZE / blockSize;
        }
            // block 1
import org.opensearch.test.OpenSearchTestCase;
                for (int j = 0; j < blockSize / 2; j++) {
            assertEquals(-1338986448, blockedSnapshotFile.readInt());
    private LockFactory lockFactory;
 */
import org.opensearch.index.store.StoreFileMetadata;
                // create last block
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(), // repository chunk size
            // cross block 0 and block 1
            assertEquals(blockSize - 1, blockedSnapshotFile.currentBlockPosition());
            blockedSnapshotFile.seek(blockSize);
    // create OnDemandBlockSnapshotIndexInput for each block size
            assertEquals(-80, blockedSnapshotFile.readByte(1));
            blockedSnapshotFile.readBytes(byteArr, 0, 2);
            assertNotEquals(newSlice.length, blockedSnapshotFile.length);
                ),
            new ByteSizeValue(15, ByteSizeUnit.KB).getBytes() // file size
                IndexOutput output = fsDirectory.createOutput(blockName, null);
        public static void testGetBlockOffset(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize, int fileSize) {
    private void verifyChunkedRepository(long blockSize, long repositoryChunkSize, long fileSize) throws IOException {
        TestGroup.testGetBlockOffset(blockedSnapshotFile, blockSize, FILE_SIZE);
            // block id 0
            assertEquals(blockSize - 11, newSlice.currentBlockPosition());
/*
                .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
        verify(transferManager).fetchBlob(argThat(request -> request.getBlobLength() == blockSize));
        } catch (IOException e) {
    private static final boolean IS_CLONE = false;
            directory,
            assertEquals(0, newSlice.getFilePointer());
        TestGroup.testReadIntWithPos(blockedSnapshotFile, blockSize);
                    FILE_NAME,
        public static void testSeek(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize, int fileSize) throws IOException {
                // create normal blocks
            blockedSnapshotFile.seek(blockSize);
            blockedSnapshotFile.seek(blockSize * 2);
            assertEquals(blockSize, blockedSnapshotFile.currentBlockStart());
            blockId = 1;
        try {
            blockedSnapshotFile.seek(blockSize - 3);
        public static void testReadByte(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
            long blockStart = blockedSnapshotFile.getBlockStart(blockId);
            blockedSnapshotFile.seek(0);
            if (numOfBlocks > 1 && sizeOfLastBlock != 0) {
            // 7 byte in block 0, 1 byte in block 1
import org.junit.Before;
            assertEquals(11, blockedSnapshotFile.currentBlockPosition());
            assertEquals((fileSize - 1) / blockSize, blockedSnapshotFile.getBlock(fileSize - 1));
            BlobFetchRequest blobFetchRequest = invocation.getArgument(0);
            fail("fail to create MMapDirectory: " + e.getMessage());
                return;
            // 2 byte in block 0, 2 byte in block 1
        }
            assertEquals(0, blockedSnapshotFile.getBlock(0L));
        );
                    // byte 00110000
            directory = new MMapDirectory(path, lockFactory);
        TestGroup.testReadVInt(blockedSnapshotFile, blockSize);
            assertEquals(10, newSlice.currentBlockPosition());
            blockedSnapshotFile.seek(1);
            );
            assertEquals(blockSize * 2, blockedSnapshotFile.getBlockStart(2));
            assertEquals(
            new ByteSizeValue(8, ByteSizeUnit.KB).getBytes(), // block Size
            // 5 byte in block 0, 3 byte in block 3
    }
            assertEquals(-1338986448, blockedSnapshotFile.readInt(blockSize));
        runAllTestsFor(22);
            assertEquals(12464, blockedSnapshotFile.readShort(1));
            // 2 byte in block 0, 2 byte in block 1
        public static void testGetBlobParts(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSizeShift) {
            blockedSnapshotFile.seek(1);
            // 6 byte in block 0, 2 byte in block 2
        TestGroup.testReadLong(blockedSnapshotFile, blockSize);
import static org.mockito.Mockito.verify;
        transferManager = mock(TransferManager.class);
            blockedSnapshotFile.seek(blockSize * 3 - 1);
                blockedSnapshotFile.seek(fileSize + 1);
    public void testChunkedRepositoryWithBlockSizeLessThanChunkSize() throws IOException {
        verifyChunkedRepository(
            assertEquals(newSlice.blockSize, blockedSnapshotFile.blockSize);
    }
            // 3 byte in block 0, 1 byte in block 1
                .length(FILE_SIZE)
        public static void testReadIntWithPos(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
            fileInfo,
            assertEquals((byte) -80, blockedSnapshotFile.readByte());
        }
            blockedSnapshotFile.seek(blockSize * 2 + 11);
            blockedSnapshotFile.seek(blockSize - 6);
        int sizeOfLastBlock = FILE_SIZE % blockSize;
        TestGroup.testReadLongWithPos(blockedSnapshotFile, blockSize);
            try {
            OnDemandBlockSnapshotIndexInput newSlice = (OnDemandBlockSnapshotIndexInput) slice;
        public static void testReadVLong(OnDemandBlockSnapshotIndexInput blockedSnapshotFile) throws IOException {
        public static void testReadByteWithPos(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
            assertEquals(-1338986448, blockedSnapshotFile.readInt(blockSize - 2));
            assertEquals(1, blockedSnapshotFile.currentBlockPosition());
        public static void testReadLong(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
            assertEquals(-1338986448, blockedSnapshotFile.readInt());
        );
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(), // repository chunk size
    public void init() {
            // block 0
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import org.apache.lucene.store.IndexOutput;
            null
            // 3 byte in block 0, 1 byte in block 1
            // end block
            assertEquals(-5750903000991223760L, blockedSnapshotFile.readLong(blockSize - 4));
            // write 48, -80 alternatively
            assertEquals(21, newSlice.getFilePointer());
            blockedSnapshotFile.seek(blockSize + 5);
        }
            assertEquals(-5750903000991223760L, blockedSnapshotFile.readLong(blockSize - 6));
            blockEnd = blockStart + AbstractBlockIndexInput.getActualBlockSize(blockId, blockSizeShift, FILE_SIZE);
            clonedFile.seek(blockSize + 11);
            assertEquals(48, blockedSnapshotFile.readByte(blockSize));
            assertEquals((byte) 48, blockedSnapshotFile.readByte());
import java.io.EOFException;
            int blockId = 0;
                .blockSizeShift(blockSizeShift)
        );
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(newSlice.transferManager, blockedSnapshotFile.transferManager);
            assertEquals(48, blockedSnapshotFile.readByte(0));
    }
    private static final String RESOURCE_DESCRIPTION = "Test OnDemandBlockSnapshotIndexInput Block Size";
            assertEquals(newSlice.blockSizeShift, blockedSnapshotFile.blockSizeShift);
        }
    // params shared by all test cases
                    .offset(BLOCK_SNAPSHOT_FILE_OFFSET)
                    if ((i & 1) == 0) {
            AbstractBlockIndexInput.builder()
            assertEquals(0, blockedSnapshotFile.currentBlockPosition());
            // 5 byte in block 0, 3 byte in block 3
            } catch (EOFException e) {
        public static void testGetBlock(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize, int fileSize) {
    }
                .resourceDescription(RESOURCE_DESCRIPTION)
    }
            assertEquals(3508357643010846896L, blockedSnapshotFile.readLong(blockSize - 5));
                for (int i = 0; i < sizeOfLastBlock; i++) {
    private Path path;
    private static final String FILE_NAME = "File_Name";
            assertEquals(blockSize, blockedSnapshotFile.getBlockStart(1));
            // Seek to the position past the first repository chunk
import org.opensearch.core.common.unit.ByteSizeUnit;
 *
            // block 2
import java.io.IOException;
                blockedSnapshotFile.getBlobParts(blockStart, blockEnd).stream().mapToLong(o -> o.getLength()).sum()
            blockedSnapshotFile.seek(0);
        public static void testReadShortWithPos(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
    private static class TestGroup {
            assertEquals(blockSize - 11, blockedSnapshotFile.currentBlockPosition());
        }
                }
                (blockEnd - blockStart),
        final OnDemandBlockSnapshotIndexInput blockedSnapshotFile = createOnDemandBlockSnapshotIndexInput(blockSizeShift);
                transferManager
        }
            blockedSnapshotFile.seek(blockSize - 1);
        runAllTestsFor(12);
                    .isClone(IS_CLONE),
            assertEquals(-5750903000991223760L, blockedSnapshotFile.readLong());
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(), // block Size
            assertEquals(3508357643010846896L, blockedSnapshotFile.readLong(blockSize - 7));
            // end block
        }).when(transferManager).fetchBlob(any());
        try {
import static org.mockito.Mockito.any;
            blockedSnapshotFile.seek(blockSize * 2 - 1);
    public void test4KBBlock() throws Exception {
            // block 2
            fail("Able to seek past file end");
        public static void testGetFilePointer(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
import org.apache.lucene.store.SimpleFSLockFactory;
            // block 1
        verifyChunkedRepository(
        public static void testGetBlockStart(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) {
            assertEquals(12464, blockedSnapshotFile.readShort());
        lockFactory = SimpleFSLockFactory.INSTANCE;
    private OnDemandBlockSnapshotIndexInput createOnDemandBlockSnapshotIndexInput(int blockSizeShift) throws IOException,
            assertEquals(blockSize * 2, blockedSnapshotFile.currentBlockStart());
            long blockEnd = blockStart + AbstractBlockIndexInput.getActualBlockSize(blockId, blockSizeShift, FILE_SIZE);
            blockedSnapshotFile.seek(blockSize - 11);
import org.opensearch.core.common.unit.ByteSizeValue;
        }
                String lastBlockName = BLOCK_FILE_PREFIX + "_block_" + numOfBlocks;
            blockedSnapshotFile.seek(blockSize - 4);
        assumeFalse("Awaiting Windows fix https://github.com/opensearch-project/OpenSearch/issues/5396", Constants.WINDOWS);
            assertEquals(
    private static final int FILE_SIZE = 29360128;
            IndexInput slice = blockedSnapshotFile.slice("slice", blockSize - 11, 22);
        verifyChunkedRepository(
        ) {
            blockedSnapshotFile.seek(blockSize);
        TestGroup.testReadByteWithPos(blockedSnapshotFile, blockSize);
        fileInfo = new BlobStoreIndexShardSnapshot.FileInfo(
            assertEquals(newSlice.directory, blockedSnapshotFile.directory);
            blockedSnapshotFile.seek(blockSize - 2);
                    output.writeByte((byte) 48);
    private void initBlockFiles(int blockSize, FSDirectory fsDirectory) {
            assertEquals(6192, blockedSnapshotFile.readVInt());
                    new ByteSizeValue(repositoryChunkSize)
        }
import org.opensearch.index.store.remote.utils.BlobFetchRequest;
        TestGroup.testReadByte(blockedSnapshotFile, blockSize);
            new ByteSizeValue(3, ByteSizeUnit.KB).getBytes() // file size
            assertEquals((byte) -80, blockedSnapshotFile.readByte());
        public static void testReadShort(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
                    }
            // block 0
            assertEquals(clonedFile.currentBlockPosition(), blockedSnapshotFile.currentBlockPosition());
        int blockSize = 1 << blockSizeShift;
                AbstractBlockIndexInput.builder()
    }
            assertEquals(816853168, blockedSnapshotFile.readInt(blockSize - 3));
                    output.writeByte((byte) -80);
            // 6 byte in block 0, 2 byte in block 2
    public void test8MBBlock() throws Exception {
                    .resourceDescription(RESOURCE_DESCRIPTION)
import org.apache.lucene.store.FSDirectory;
            assertEquals(
import org.apache.lucene.store.MMapDirectory;
        }
 * The OpenSearch Contributors require contributions made to
import static org.mockito.Mockito.when;
        );
            // block 0
            assertEquals(-80, byteArr[0]);
            }
            blockedSnapshotFile.readBytes(byteArr, 0, 2);
            return blobFetchRequest.getDirectory().openInput(blobFetchRequest.getFileName(), IOContext.READONCE);
            assertEquals(-1338986448, blockedSnapshotFile.readInt(0));
        TestGroup.testReadShortWithPos(blockedSnapshotFile, blockSize);
                (blockEnd - blockStart),
}
            }
            blockedSnapshotFile.seek(blockSize + 1);
package org.opensearch.index.store.remote.file;
                }
        }
            assertEquals(48, blockedSnapshotFile.readVLong());
            assertEquals(-5750903000991223760L, blockedSnapshotFile.readLong(0));
        path = createTempDir("OnDemandBlockSnapshotIndexInputTests");
        doAnswer(invocation -> {
            // block 1
            // block 1
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
            assertEquals(-1338986448, blockedSnapshotFile.readInt());
            blockStart = blockedSnapshotFile.getBlockStart(blockId);
            new ByteSizeValue(2, ByteSizeUnit.KB).getBytes(), // repository chunk size
                // since block size is always even number, safe to do division
            blockedSnapshotFile.seek(blockSize + 11);
            assertEquals(newSlice.fileName, blockedSnapshotFile.fileName);
    public void test4MBBlock() throws Exception {
            assertEquals(-20432, blockedSnapshotFile.readShort(blockSize));
                blockedSnapshotFile.getBlobParts(blockStart, blockEnd).stream().mapToLong(o -> o.getLength()).sum()
            blockedSnapshotFile.seek(blockSize - 1);
            assertEquals(48, byteArr[0]);
        }
        }
        runAllTestsFor(20);
            assertEquals(11, blockedSnapshotFile.currentBlockPosition());
    public void testChunkedRepositoryWithBlockSizeGreaterThanChunkSize() throws IOException {
            blockedSnapshotFile.seek(0);
        TestGroup.testGetBlobParts(blockedSnapshotFile, blockSizeShift);
 * this file be licensed under the Apache-2.0 license or a
        }
    }
            blockedSnapshotFile.seek(blockSize - 7);
    private static final String BLOCK_FILE_PREFIX = FILE_NAME;
import org.apache.lucene.store.IndexInput;
        InterruptedException {
                return;
            blockId = 2;
import org.apache.lucene.util.Version;
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
        }
    }
            // block 1
        initBlockFiles(blockSize, directory);
        when(transferManager.fetchBlob(any())).thenReturn(new ByteArrayIndexInput("test", new byte[(int) blockSize]));
        public static void testReadBytes(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
            for (int i = 0; i < numOfBlocks; i++) {
                    new StoreFileMetadata(FILE_NAME, fileSize, "", Version.LATEST),
        TestGroup.testReadBytes(blockedSnapshotFile, blockSize);
                blockedSnapshotFile.getBlobParts(blockStart, blockEnd).stream().mapToLong(o -> o.getLength()).sum()
        public static void testCurrentBlockPosition(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
    private BlobStoreIndexShardSnapshot.FileInfo fileInfo;
            assertEquals(816853168, blockedSnapshotFile.readInt(blockSize - 1));
        TestGroup.testSlice(blockedSnapshotFile, blockSize);
            assertEquals(6192, blockedSnapshotFile.readVLong());
        }
            new StoreFileMetadata(FILE_NAME, FILE_SIZE, "", Version.LATEST),
            assertEquals(-5750903000991223760L, blockedSnapshotFile.readLong());
            assertEquals(newSlice.isClone, true);
        }
            blockedSnapshotFile.seek(0);
            // block 1
            blockedSnapshotFile.seek(blockSize - 1);
            fail("Able to seek past end");
    private void runAllTestsFor(int blockSizeShift) throws Exception {
        }
    @Before
            // block size will always be an integer multiple of frame size
            blockedSnapshotFile.seek(blockSize - 1);
            blockedSnapshotFile.seek(0);
        }
        }
        public static void testCurrentBlockStart(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
import org.apache.lucene.store.IOContext;
            assertEquals(-5750903000991223760L, blockedSnapshotFile.readLong());
                        output.writeByte((byte) 48);
            assertEquals(3508357643010846896L, blockedSnapshotFile.readLong());
            new ByteSizeValue(1, ByteSizeUnit.KB).getBytes(), // block Size
            blockedSnapshotFile.seek(blockSize - 1);
        try (
        public static void testReadVInt(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
    public void testChunkedRepositoryWithBlockSizeEqualToChunkSize() throws IOException {
            indexInput.seek(repositoryChunkSize);
            new ByteSizeValue(15, ByteSizeUnit.KB).getBytes() // file size
        TestGroup.testClone(blockedSnapshotFile, blockSize);
            assertEquals(816853168, blockedSnapshotFile.readInt());
    public void test1MBBlock() throws Exception {
            // block 0
    private TransferManager transferManager;
            assertEquals(12464, blockedSnapshotFile.readShort(blockSize - 1));
            OnDemandBlockSnapshotIndexInput clonedFile = blockedSnapshotFile.clone();
    }
        TestGroup.testReadInt(blockedSnapshotFile, blockSize);
 * compatible open source license.
                IndexOutput output = fsDirectory.createOutput(lastBlockName, null);
    }
            // 1 byte in block 0, 3 byte in block 1
            assertEquals((byte) 48, blockedSnapshotFile.readByte());
    }
            assertEquals(3508357643010846896L, blockedSnapshotFile.readLong());
import org.apache.lucene.util.Constants;
            assertEquals(0, blockedSnapshotFile.getBlockOffset(blockSize));
import org.opensearch.index.store.remote.utils.TransferManager;
                directory,
            // 1 byte in block 0, 3 byte in block 1
                String blockName = BLOCK_FILE_PREFIX + "_block_" + i;
                        output.writeByte((byte) -80);
                new BlobStoreIndexShardSnapshot.FileInfo(
        final int blockSize = 1 << blockSizeShift;
            blockedSnapshotFile.seek(0);
        TestGroup.testSeek(blockedSnapshotFile, blockSize, FILE_SIZE);
            blockedSnapshotFile.seek(0);
            assertEquals(5, blockedSnapshotFile.currentBlockPosition());
            // 4 byte in block 0, 4 block in block 4
            assertEquals(0L, blockedSnapshotFile.getBlockStart(0));
        TestGroup.testGetFilePointer(blockedSnapshotFile, blockSize);
            assertEquals((fileSize - 1) % blockSize, blockedSnapshotFile.getBlockOffset(fileSize - 1));
            blockedSnapshotFile.seek(blockSize - 5);
            }
        }
            );
            newSlice.seek(21);
            assertNotEquals(clonedFile.currentBlockPosition(), blockedSnapshotFile.currentBlockPosition());
        }
            assertEquals(0, blockedSnapshotFile.currentBlockPosition());
            assertEquals(0L, blockedSnapshotFile.currentBlockStart());
            );
            assertEquals(-20432, blockedSnapshotFile.readShort());
                newSlice.seek(23);
import static org.mockito.Mockito.doAnswer;
            assertEquals(clonedFile.getFilePointer(), blockedSnapshotFile.getFilePointer());
            // block 2
            assertEquals(newSlice.blockMask, blockedSnapshotFile.blockMask);
            blockStart = blockedSnapshotFile.getBlockStart(blockId);
            assertEquals(1, blockedSnapshotFile.getBlock(blockSize));
        FSDirectory directory = null;
import static org.mockito.Mockito.mock;
            } catch (EOFException e) {
                output.close();
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        );
import org.apache.lucene.store.LockFactory;
        // file info should be initialized per test method since file size need to be calculated
        public static void testClone(OnDemandBlockSnapshotIndexInput blockedSnapshotFile, int blockSize) throws IOException {
            fail("fail to initialize block files: " + e.getMessage());

                output.writeByte((byte) 0);
}
        input2.close();
    public void testSlicesAreTrackedViaCallback() throws IOException {
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithFile(FILE_SIZE));
            for (int i = 0; i < size; i++) {
        expectThrows(AlreadyClosedException.class, slice1::getFilePointer);
    }
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        slice1.close();
    }
        master.seek(50);
import org.opensearch.index.store.remote.utils.TransferManager;
        IndexInput slice1 = master.slice("slice1", 0, 100);
 * SPDX-License-Identifier: Apache-2.0
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithFile(FILE_SIZE));
    }
        FileInfo virtualFile = new FileInfo(
        byte[] content = new byte[] { 1, 2, 3 };
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithFile(FILE_SIZE));
        FileInfo fileInfo = new FileInfo(FILE_NAME, new StoreFileMetadata(FILE_NAME, size, "", Version.LATEST), null);
        dir.unpinAndStopTracking();
        assertTrue(slice1.getFilePointer() > 0);
import java.io.IOException;
        expectThrows(AlreadyClosedException.class, master::getFilePointer);
import static org.mockito.Mockito.mock;
        assertTrue(input instanceof OnDemandBlockSnapshotIndexInput);
    }
        expectThrows(AlreadyClosedException.class, input::getFilePointer);
        input1.close();
import static org.mockito.Mockito.doAnswer;
        assertTrue(master.getFilePointer() > 0);
package org.opensearch.index.store.remote.directory;
            BlobFetchRequest request = invocation.getArgument(0);
        fsDirectory = new MMapDirectory(path, SimpleFSLockFactory.INSTANCE);
            0,
 */
    }
        initBlockFile(FILE_SIZE);
        transferManager = mock(TransferManager.class);
import org.opensearch.index.store.remote.utils.BlobFetchRequest;
 * compatible open source license.
        dir.close();
        IndexInput slice2 = master.slice("slice2", 100, 100);
    private RemoteSnapshotDirectory createDirectoryWithVirtualFile(byte[] content) {
        dir.close();
        clone.readByte();
        input.close();
    private void initBlockFile(int size) throws IOException {
import org.apache.lucene.store.AlreadyClosedException;
 *
        master.close();
            0,
        IndexInput master = dir.openInput(FILE_NAME, IOContext.DEFAULT);
    private TransferManager transferManager;
        input2.close();
        dir.close();
            "snap",
import static org.mockito.Mockito.any;
        input.seek(50);
        slice2.seek(20);
    }
import org.apache.lucene.store.SimpleFSLockFactory;
    private static final String FILE_NAME = "test_file";
import org.junit.Before;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        dir.unpinAndStopTracking();
        input2.seek(20);
        slice1.seek(10);
        }).when(transferManager).fetchBlob(any());
            return request.getDirectory().openInput(request.getFileName(), IOContext.READONCE);
    private FSDirectory fsDirectory;
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithVirtualFile(content));
import java.nio.file.Path;
        assertEquals(10L, input2.getFilePointer());
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        dir.unpinAndStopTracking();
        clone.close();
        IndexInput input = dir.openInput(FILE_NAME, IOContext.DEFAULT);
        assertEquals(10L, clone.getFilePointer());
        IndexInput slice = input.slice("test-slice", 0, 100);
import org.apache.lucene.store.IndexInput;
        slice.seek(20);
        input.seek(50);
        }
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithFile(FILE_SIZE));
    public void testCloneAndSliceWorkAfterUnpin() throws IOException {
        dir.close();
    }
        IndexInput input2 = dir.openInput(FILE_NAME, IOContext.DEFAULT);
        IndexInput input1 = dir.openInput(FILE_NAME, IOContext.DEFAULT);
        expectThrows(AlreadyClosedException.class, input1::getFilePointer);
        expectThrows(AlreadyClosedException.class, input2::getFilePointer);
        try (var output = fsDirectory.createOutput(blockName, IOContext.DEFAULT)) {
/*
    public void testUnpinAndStopTrackingIsIdempotent() throws IOException {
    public void testOpenInputTracksBlockIndexInput() throws IOException {
        expectThrows(AlreadyClosedException.class, slice2::getFilePointer);
        slice.close();
        dir.close();
    public void setUp() throws Exception {
        dir.unpinAndStopTracking();
import org.apache.lucene.store.MMapDirectory;
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
    }
            1,
import org.apache.lucene.store.FSDirectory;
public class BlockUnpinningDirectoryTests extends OpenSearchTestCase {
            0,
        BlobStoreIndexShardSnapshot snapshot = new BlobStoreIndexShardSnapshot("snap", 1, Collections.singletonList(fileInfo), 0, 0, 0, 0);
import org.opensearch.index.store.StoreFileMetadata;
        BlobStoreIndexShardSnapshot snapshot = new BlobStoreIndexShardSnapshot(
            null
            0
    @Before
        input1.close();
import org.apache.lucene.store.IOContext;
        input.close();
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithFile(FILE_SIZE));
    }
        assertEquals(50L, input.getFilePointer());
            "v__virtual",
        input1.readByte();
    public void testOpenInputPassesThroughNonBlockInput() throws IOException {
        IndexInput input1 = dir.openInput(FILE_NAME, IOContext.DEFAULT);
    public void testNoTrackingAfterUnpinAndStopTracking() throws IOException {
        input1.seek(10);
        );
        dir.unpinAndStopTracking();
        assertTrue(slice2.getFilePointer() > 0);
import org.apache.lucene.util.BytesRef;
    private static final int FILE_SIZE = 1024;
import org.apache.lucene.util.Version;
        return new RemoteSnapshotDirectory(snapshot, fsDirectory, transferManager);
        doAnswer(invocation -> {
    }
        Path path = createTempDir("BlockUnpinningDirectoryTests");
    }
        );
        return new RemoteSnapshotDirectory(snapshot, fsDirectory, transferManager);
        assertEquals(20L, slice.getFilePointer());
        input.close();
        IndexInput input = dir.openInput(FILE_NAME, IOContext.DEFAULT);
        slice.readByte();
import java.util.Collections;
import org.opensearch.index.store.remote.file.OnDemandBlockSnapshotIndexInput;
        dir.close();
        String blockName = FILE_NAME + "_block_0";
        clone.seek(10);
        super.setUp();
        assertTrue(input instanceof ByteArrayIndexInput);
            new StoreFileMetadata(FILE_NAME, content.length, "", Version.LATEST, new BytesRef(content)),
        input1.seek(0);
        IndexInput input = dir.openInput(FILE_NAME, IOContext.DEFAULT);
            Collections.singletonList(virtualFile),
    public void testMultipleInputsAllUnpinned() throws IOException {
        dir.unpinAndStopTracking();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
        IndexInput clone = input.clone();
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot.FileInfo;
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithFile(FILE_SIZE));
        dir.unpinAndStopTracking();
 * The OpenSearch Contributors require contributions made to
        IndexInput input2 = dir.openInput(FILE_NAME, IOContext.DEFAULT);
        input.close();
        input.seek(50);
        dir.close();
        dir.unpinAndStopTracking();
            }
    private RemoteSnapshotDirectory createDirectoryWithFile(int size) {
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
        slice2.close();
        // Simulates what codec readers do during search: clone/slice from an unpinned input
        input2.seek(10);
        IndexInput input = dir.openInput(FILE_NAME, IOContext.DEFAULT);

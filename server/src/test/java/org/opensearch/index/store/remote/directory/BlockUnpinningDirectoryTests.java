    public void testSlicesAreTrackedViaCallback() throws IOException {
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithVirtualFile(content));  
    private RemoteSnapshotDirectory createDirectoryWithVirtualFile(byte[] content) {
        );  
/*  
        input2.close();  
        dir.close();
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithFile(FILE_SIZE));
        assertEquals(10L, input2.getFilePointer());  
                output.writeByte((byte) 0);
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithFile(FILE_SIZE));  
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
    }  
        initBlockFile(FILE_SIZE);  
        transferManager = mock(TransferManager.class);  
        slice.close();
    }
    private FSDirectory fsDirectory;
        slice2.close();
        input1.seek(0);  
import org.opensearch.index.store.remote.utils.TransferManager;  
            0
import org.junit.Before;
            "v__virtual",  
        input1.close();
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithFile(FILE_SIZE));
    }
        IndexInput input2 = dir.openInput(FILE_NAME, IOContext.DEFAULT);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    }
import static org.mockito.Mockito.any;
        Path path = createTempDir("BlockUnpinningDirectoryTests");
        assertTrue(slice1.getFilePointer() > 0);
import org.apache.lucene.store.FSDirectory;
            return request.getDirectory().openInput(request.getFileName(), IOContext.READONCE);  
        clone.readByte();  
            null
        slice.seek(20);  
            new StoreFileMetadata(FILE_NAME, content.length, "", Version.LATEST, new BytesRef(content)),
        expectThrows(AlreadyClosedException.class, input2::getFilePointer);  
        dir.close();
        String blockName = FILE_NAME + "_block_0";
        assertTrue(input instanceof ByteArrayIndexInput);  
        assertEquals(50L, input.getFilePointer());
    public void testNoTrackingAfterUnpinAndStopTracking() throws IOException {
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;  
        dir.unpinAndStopTracking();
        input2.seek(20);
import org.apache.lucene.store.IndexInput;  
        BlobStoreIndexShardSnapshot snapshot = new BlobStoreIndexShardSnapshot(
            "snap",
            Collections.singletonList(virtualFile),
    private RemoteSnapshotDirectory createDirectoryWithFile(int size) {
import org.apache.lucene.util.BytesRef;  
        assertTrue(slice2.getFilePointer() > 0);
        input2.close();  
        return new RemoteSnapshotDirectory(snapshot, fsDirectory, transferManager);
        dir.close();
import static org.mockito.Mockito.mock;
        IndexInput slice = input.slice("test-slice", 0, 100);
        master.close();  
        FileInfo virtualFile = new FileInfo(
    }
            0,
    public void testUnpinAndStopTrackingIsIdempotent() throws IOException {
        FileInfo fileInfo = new FileInfo(FILE_NAME, new StoreFileMetadata(FILE_NAME, size, "", Version.LATEST), null);
        }
        IndexInput input1 = dir.openInput(FILE_NAME, IOContext.DEFAULT);
            1,  
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithFile(FILE_SIZE));
        input.close();
 * SPDX-License-Identifier: Apache-2.0
 */  
        dir.close();
        super.setUp();
        IndexInput input = dir.openInput(FILE_NAME, IOContext.DEFAULT);
        input.close();
    }
import org.apache.lucene.store.SimpleFSLockFactory;
        input.close();  
        IndexInput input2 = dir.openInput(FILE_NAME, IOContext.DEFAULT);
            for (int i = 0; i < size; i++) {
import java.util.Collections;  
        IndexInput input = dir.openInput(FILE_NAME, IOContext.DEFAULT);
}  
        IndexInput input1 = dir.openInput(FILE_NAME, IOContext.DEFAULT);
        input2.seek(10);
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
    private static final String FILE_NAME = "test_file";  
        input1.close();
import org.apache.lucene.util.Version;
        dir.close();
import org.apache.lucene.store.IOContext;
import org.opensearch.test.OpenSearchTestCase;
        clone.seek(10);
    private void initBlockFile(int size) throws IOException {
import org.opensearch.index.store.remote.utils.BlobFetchRequest;
        BlobStoreIndexShardSnapshot snapshot = new BlobStoreIndexShardSnapshot("snap", 1, Collections.singletonList(fileInfo), 0, 0, 0, 0);  
import org.apache.lucene.store.MMapDirectory;
            }  
            BlobFetchRequest request = invocation.getArgument(0);
        input.seek(50);  
import java.io.IOException;
        );  
        assertEquals(10L, clone.getFilePointer());
        // Simulates what codec readers do during search: clone/slice from an unpinned input
 * this file be licensed under the Apache-2.0 license or a
        expectThrows(AlreadyClosedException.class, master::getFilePointer);  
        assertEquals(20L, slice.getFilePointer());
        dir.unpinAndStopTracking();
        IndexInput master = dir.openInput(FILE_NAME, IOContext.DEFAULT);
        }).when(transferManager).fetchBlob(any());
        slice1.seek(10);
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;  
        expectThrows(AlreadyClosedException.class, input::getFilePointer);
import org.apache.lucene.store.AlreadyClosedException;  
            0,  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.store.StoreFileMetadata;
        fsDirectory = new MMapDirectory(path, SimpleFSLockFactory.INSTANCE);
            0,
        input.close();  
        byte[] content = new byte[] { 1, 2, 3 };
        input1.seek(10);  
        dir.unpinAndStopTracking();
    public void testOpenInputTracksBlockIndexInput() throws IOException {  
        doAnswer(invocation -> {
        master.seek(50);  
    public void testOpenInputPassesThroughNonBlockInput() throws IOException {
    }
    }  
        try (var output = fsDirectory.createOutput(blockName, IOContext.DEFAULT)) {  
        dir.unpinAndStopTracking();
        IndexInput slice1 = master.slice("slice1", 0, 100);  
        assertTrue(master.getFilePointer() > 0);  
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithFile(FILE_SIZE));  
        dir.unpinAndStopTracking();  
 *
        input1.readByte();
    }
        dir.close();
    public void testCloneAndSliceWorkAfterUnpin() throws IOException {
import org.opensearch.index.store.remote.file.OnDemandBlockSnapshotIndexInput;
        dir.unpinAndStopTracking();
        dir.close();
import java.nio.file.Path;
        assertTrue(input instanceof OnDemandBlockSnapshotIndexInput);
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot.FileInfo;
import static org.mockito.Mockito.doAnswer;  
        input.seek(50);
        return new RemoteSnapshotDirectory(snapshot, fsDirectory, transferManager);
        expectThrows(AlreadyClosedException.class, input1::getFilePointer);
        slice.readByte();
        IndexInput slice2 = master.slice("slice2", 100, 100);
        BlockUnpinningDirectory dir = new BlockUnpinningDirectory(createDirectoryWithFile(FILE_SIZE));
    private static final int FILE_SIZE = 1024;
    public void testMultipleInputsAllUnpinned() throws IOException {
    @Before  
        clone.close();
    }
        IndexInput clone = input.clone();  
        expectThrows(AlreadyClosedException.class, slice1::getFilePointer);
    public void setUp() throws Exception {
 * compatible open source license.
        dir.unpinAndStopTracking();  
        input.seek(50);
        slice1.close();
package org.opensearch.index.store.remote.directory;
    private TransferManager transferManager;  
        slice2.seek(20);
        IndexInput input = dir.openInput(FILE_NAME, IOContext.DEFAULT);
        expectThrows(AlreadyClosedException.class, slice2::getFilePointer);
public class BlockUnpinningDirectoryTests extends OpenSearchTestCase {
    }
        dir.unpinAndStopTracking();  
        IndexInput input = dir.openInput(FILE_NAME, IOContext.DEFAULT);  

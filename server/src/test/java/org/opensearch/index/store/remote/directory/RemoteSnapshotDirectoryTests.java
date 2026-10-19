 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot.FileInfo;  
        assertEquals(content.length, input.length());  
        String blockName = FILE_NAME + "_block_0";  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
        assertTrue(input instanceof OnDemandBlockSnapshotIndexInput);  
        super.setUp();  
}
        input.close();
        FileInfo fileInfo = new FileInfo(FILE_NAME, new StoreFileMetadata(FILE_NAME, size, "", Version.LATEST), null);  
import org.opensearch.test.OpenSearchTestCase;  
import java.io.IOException;  
import static org.mockito.Mockito.any;
        doAnswer(invocation -> {
        dir.close();
import org.apache.lucene.util.BytesRef;
    }  
            "v__virtual",
 *
import org.apache.lucene.store.MMapDirectory;  
import org.opensearch.index.store.StoreFileMetadata;
        return new RemoteSnapshotDirectory(snapshot, fsDirectory, transferManager);
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        fsDirectory = new MMapDirectory(path, SimpleFSLockFactory.INSTANCE);  
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
    private RemoteSnapshotDirectory createDirectoryWithFile(int size) {
            0,
import java.util.Collections;
        byte[] content = new byte[] { 1, 2, 3, 4, 5 };
        FileInfo virtualFile = new FileInfo(  
        input.readBytes(readBack, 0, content.length);
            0,  
    public void testOpenInputReturnsOnDemandBlockSnapshotIndexInput() throws IOException {
            Collections.singletonList(virtualFile),
        assertEquals(1024, input.length());
        assertArrayEquals(content, readBack);  
        BlobStoreIndexShardSnapshot snapshot = new BlobStoreIndexShardSnapshot("snap", 1, Collections.singletonList(fileInfo), 0, 0, 0, 0);
import org.apache.lucene.store.IOContext;
    }
        IndexInput input = dir.openInput(FILE_NAME, IOContext.DEFAULT);
    private TransferManager transferManager;
        return new RemoteSnapshotDirectory(snapshot, fsDirectory, transferManager);
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
        IndexInput input = dir.openInput(FILE_NAME, IOContext.DEFAULT);
import org.junit.Before;
import static org.mockito.Mockito.doAnswer;
        assertArrayEquals(new byte[1024], readBack);
    private RemoteSnapshotDirectory createDirectoryWithVirtualFile(byte[] content) {
    @Before
        );
    }  
            0  
        RemoteSnapshotDirectory dir = createDirectoryWithFile(1024);
    }  
                output.writeByte((byte) 0);  
        input.close();
import java.nio.file.Path;
        transferManager = mock(TransferManager.class);
    public void setUp() throws Exception {
        input.readBytes(readBack, 0, 1024);  
    public void testOpenInputVirtualFileReturnsByteArrayIndexInput() throws IOException {  
            1,
        Path path = createTempDir("RemoteSnapshotDirectoryTests");
            BlobFetchRequest request = invocation.getArgument(0);  
        );
        }).when(transferManager).fetchBlob(any());
import org.apache.lucene.store.FSDirectory;  
    private FSDirectory fsDirectory;
            "snap",  
 */  
import org.apache.lucene.store.SimpleFSLockFactory;
        initBlockFile(1024);  
            return request.getDirectory().openInput(request.getFileName(), IOContext.READONCE);
    private static final String FILE_NAME = "test_file";
import static org.mockito.Mockito.mock;  
        RemoteSnapshotDirectory dir = createDirectoryWithVirtualFile(content);
import org.opensearch.index.store.remote.utils.TransferManager;
        try (var output = fsDirectory.createOutput(blockName, IOContext.DEFAULT)) {
            null  
            }
            new StoreFileMetadata(FILE_NAME, content.length, "", Version.LATEST, new BytesRef(content)),
public class RemoteSnapshotDirectoryTests extends OpenSearchTestCase {  
/*  
        BlobStoreIndexShardSnapshot snapshot = new BlobStoreIndexShardSnapshot(
 * compatible open source license.
    private void initBlockFile(int size) throws IOException {
    }  
        assertTrue(input instanceof ByteArrayIndexInput);
import org.opensearch.index.store.remote.utils.BlobFetchRequest;
    }  
            for (int i = 0; i < size; i++) {
import org.apache.lucene.util.Version;  
package org.opensearch.index.store.remote.directory;
import org.opensearch.index.store.remote.file.OnDemandBlockSnapshotIndexInput;  
        byte[] readBack = new byte[content.length];
            0,
        }
        byte[] readBack = new byte[1024];
        dir.close();  
import org.apache.lucene.store.IndexInput;

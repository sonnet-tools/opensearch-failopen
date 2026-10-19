import org.apache.lucene.store.IndexInput;
            .stream()
package org.opensearch.index.store.remote.directory;
import java.util.Collection;  
    }  
        final static NoopIndexOutput INSTANCE = new NoopIndexOutput();  
    }
        public void writeBytes(byte[] b, int offset, int length) throws IOException {  
    @Override
 * a Directory implementation that can read directly from index snapshot stored remotely in a blob store repository.
import org.opensearch.index.store.remote.file.OnDemandBlockSnapshotIndexInput;
 * This implementation is following this design https://github.com/opensearch-project/OpenSearch/issues/4033
        public void close() throws IOException {
            .collect(Collectors.toMap(BlobStoreIndexShardSnapshot.FileInfo::physicalName, f -> f));
        public long getChecksum() throws IOException {
        }
import org.apache.lucene.store.NoLockFactory;
import java.util.stream.Collectors;
    }  
        @Override  
    }
    public void sync(Collection<String> names) throws IOException {}  
 */  
        this.transferManager = transferManager;
import java.util.Map;
    @Override
    private static final String VIRTUAL_FILE_PREFIX = BlobStoreRepository.VIRTUAL_DATA_BLOB_PREFIX;
        final BlobStoreIndexShardSnapshot.FileInfo fileInfo = fileInfoMap.get(name);
    private final FSDirectory localStoreDir;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.IOContext;  
import org.apache.lucene.store.Lock;  
        @Override
    public void rename(String source, String dest) throws IOException {}  
    public Lock obtainLock(String name) throws IOException {  
 * compatible open source license.
    public void close() throws IOException {
    }
        localStoreDir.close();
        throw new UnsupportedOperationException();
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
        return new OnDemandBlockSnapshotIndexInput(fileInfo, localStoreDir, transferManager);  
import java.io.IOException;
        return Collections.emptySet();  
    public String[] listAll() throws IOException {
    }
    }
        @Override  
        public long getFilePointer() {  
 */
        }
    }  
    @Override  
    public Set<String> getPendingDeletions() throws IOException {
import org.apache.lucene.store.IndexOutput;
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;  
import org.apache.lucene.store.FSDirectory;
    @Override  
            return 0;  
/*  
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
    }
        return fileInfoMap.keySet().toArray(new String[0]);  
    @Override
import org.opensearch.index.store.remote.utils.TransferManager;
            return 0;
    @Override  
    public void syncMetaData() {}  
    @Override
    @Override
    @Override  
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
        public void writeByte(byte b) throws IOException {
        }
    private final TransferManager transferManager;  
    @Override
        return fileInfoMap.get(name).length();
    public long fileLength(String name) throws IOException {  
    public IndexInput openInput(String name, IOContext context) throws IOException {  
public final class RemoteSnapshotDirectory extends Directory {  
    public void deleteFile(String name) throws IOException {}
    public IndexOutput createOutput(String name, IOContext context) {
    @Override
    public RemoteSnapshotDirectory(BlobStoreIndexShardSnapshot snapshot, FSDirectory localStoreDir, TransferManager transferManager) {
 *  
    private final Map<String, BlobStoreIndexShardSnapshot.FileInfo> fileInfoMap;
        }
    }  
        }  
    public IndexOutput createTempOutput(String prefix, String suffix, IOContext context) {
/**  
            return new ByteArrayIndexInput(fileInfo.physicalName(), fileInfo.metadata().hash().bytes);
 *
        this.fileInfoMap = snapshot.indexFiles()  
    @Override
            super("noop", "noop");  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
        return NoLockFactory.INSTANCE.obtainLock(null, null);
        NoopIndexOutput() {
    static class NoopIndexOutput extends IndexOutput {
        return NoopIndexOutput.INSTANCE;
}
import java.util.Set;  
        @Override
        if (fileInfo.name().startsWith(VIRTUAL_FILE_PREFIX)) {  
        }
        @Override
        }  
 * The OpenSearch Contributors require contributions made to  
        this.localStoreDir = localStoreDir;  

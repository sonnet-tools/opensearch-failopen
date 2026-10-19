import org.opensearch.index.snapshots.blobstore.IndexShardSnapshot;  
 * @opensearch.internal
    @Override  
        return null;
        localStoreDir.syncMetaData();
 * this file be licensed under the Apache-2.0 license or a
            TransferManager transferManager = new TransferManager(blobContainer::readBlob, remoteStoreFileCache, threadPool);
        // make sure directory is flushed to persistent storage
import org.apache.lucene.store.FSDirectory;
        final String repositoryName = IndexSettings.SEARCHABLE_SNAPSHOT_REPOSITORY.get(indexSettings.getSettings());
    ) throws IOException {
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        this.remoteStoreFileCache = remoteStoreFileCache;  
 * data stored remotely in a blob store repository.
import java.io.IOException;
        int shardId = localShardPath.getShardId().getId();  
import org.opensearch.index.remote.RemoteStoreEnums.PathType;  
    }
        // index restore is invoked
        assert repository instanceof BlobStoreRepository : "repository should be instance of BlobStoreRepository";  
            final BlobStoreIndexShardSnapshot snapshot = (BlobStoreIndexShardSnapshot) indexShardSnapshot;  
        });  
import org.opensearch.common.blobstore.BlobContainer;
 * SPDX-License-Identifier: Apache-2.0
        FSDirectory localStoreDir = FSDirectory.open(Files.createDirectories(localStorePath));  
public final class RemoteSnapshotDirectoryFactory implements IndexStorePlugin.DirectoryFactory {  
import java.util.concurrent.ExecutionException;
import org.apache.lucene.store.Directory;
        }  
            return new RemoteSnapshotDirectory(snapshot, localStoreDir, transferManager);
    }
import org.apache.lucene.store.LockFactory;  
    public RemoteSnapshotDirectoryFactory(
import org.opensearch.index.store.remote.filecache.FileCache;
        final BlobStoreRepository blobStoreRepository = (BlobStoreRepository) repository;
    private Future<RemoteSnapshotDirectory> createRemoteSnapshotDirectoryFromSnapshot(  
    @Override
}
    }  
 */  
        BlobStoreRepository blobStoreRepository  
    private final FileCache remoteStoreFileCache;  
                new IndexId("DUMMY", indexId, pathType.getCode()),  
            // shardContainer(IndexId, shardId) method uses the id and pathType information to generate the blobPath and  
        final Repository repository = repositoriesService.get().repository(repositoryName);
            );
        String indexId = IndexSettings.SEARCHABLE_SNAPSHOT_INDEX_ID.get(indexSettings.getSettings());
 *  
        FileCache remoteStoreFileCache
    public static final String LOCAL_STORE_LOCATION = "RemoteLocalStore";
            final BlobContainer blobContainer = blobStoreRepository.shardContainer(
import org.opensearch.snapshots.SnapshotId;
        PathType pathType = IndexSettings.SEARCHABLE_SNAPSHOT_SHARD_PATH_TYPE.get(indexSettings.getSettings());
            IndexSettings.SEARCHABLE_SNAPSHOT_ID_UUID.get(indexSettings.getSettings())  
        IndexSettings indexSettings,
    private final Supplier<RepositoriesService> repositoriesService;  
        Path localStorePath = localShardPath.getDataPath().resolve(LOCAL_STORE_LOCATION);
import org.opensearch.plugins.IndexStorePlugin;  
    private final ThreadPool threadPool;
import org.opensearch.index.shard.ShardPath;
        Supplier<RepositoriesService> repositoriesService,  
 * compatible open source license.
import org.opensearch.index.IndexSettings;
import org.opensearch.repositories.IndexId;
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
        } catch (InterruptedException | ExecutionException e) {
            final IndexShardSnapshot indexShardSnapshot = blobStoreRepository.loadShardSnapshot(blobContainer, snapshotId);  
import java.nio.file.Path;
 *
            throw new IllegalStateException(e);
package org.opensearch.index.store.remote.directory;
        // creating the shard BlobContainer. This information has been updated as per the hashed_prefix snapshots.  
 * Factory for a Directory implementation that can read directly from index
 */
    ) {  
import java.nio.file.Files;  
        ShardPath localShardPath,
    public Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException {
        );
import org.opensearch.repositories.RepositoriesService;
            assert indexShardSnapshot instanceof BlobStoreIndexShardSnapshot
        ThreadPool threadPool,
/*  
        try {
        // this trick is needed to bypass assertions in BlobStoreRepository::assertAllowableThreadPools in case of node restart and a remote  
/**  
            IndexSettings.SEARCHABLE_SNAPSHOT_ID_NAME.get(indexSettings.getSettings()),
 * The OpenSearch Contributors require contributions made to  
                : "indexShardSnapshot should be an instance of BlobStoreIndexShardSnapshot";
import org.opensearch.threadpool.ThreadPool;  
import java.util.function.Supplier;
import java.util.concurrent.Future;  
import org.opensearch.index.store.remote.utils.TransferManager;
        // The below information like the snapshot generated indexId, shard_path_type and shardId are used for
import org.opensearch.repositories.Repository;  
        this.threadPool = threadPool;
        this.repositoriesService = repositoriesService;
            return createRemoteSnapshotDirectoryFromSnapshot(indexSettings, localShardPath, blobStoreRepository).get();  
        return threadPool.executor(ThreadPool.Names.SNAPSHOT).submit(() -> {
    public Directory newDirectory(IndexSettings indexSettings, ShardPath localShardPath) throws IOException {  
                shardId
    }
        final SnapshotId snapshotId = new SnapshotId(
            // hence the blobContainer. We have used a dummy name as it plays no relevance in the blobPath generation.

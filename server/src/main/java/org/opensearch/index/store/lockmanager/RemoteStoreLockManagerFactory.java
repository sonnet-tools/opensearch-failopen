        }
                .basePath(repositoryBasePath)  
 */  
        return newLockManager(repositoriesService, repositoryName, indexUUID, shardId, pathStrategy, segmentsPathFixedPrefix, null);  
 * The OpenSearch Contributors require contributions made to  
                .dataCategory(SEGMENTS)  
        String shardId,
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
        String repositoryName,
 *  
import org.opensearch.common.blobstore.BlobPath;  
    }
    ) {
/**
        } catch (RepositoryMissingException e) {
        String repositoryName,
 * Factory for remote store lock manager
        RepositoriesService repositoriesService,
import org.opensearch.repositories.Repository;
                .indexFixedPrefix(indexFixedPrefix)  
@PublicApi(since = "2.8.0")  
            BlobPath lockDirectoryPath = pathStrategy.generatePath(lockFilesPathInput);
        return newLockManager(repositoriesService.get(), repositoryName, indexUUID, shardId, pathStrategy, segmentsPathFixedPrefix, null);
    }
            BlobContainer lockDirectoryBlobContainer = ((BlobStoreRepository) repository).blobStore().blobContainer(lockDirectoryPath);  
 * compatible open source license.
public class RemoteStoreLockManagerFactory {
        this.segmentsPathFixedPrefix = segmentsPathFixedPrefix;
import org.opensearch.repositories.RepositoryMissingException;
        Repository repository = repositoriesService.repository(repositoryName);  
        String indexFixedPrefix
                .dataType(LOCK_FILES)
import org.opensearch.common.blobstore.BlobContainer;
            BlobPath repositoryBasePath = ((BlobStoreRepository) repository).basePath();  
        RemoteStorePathStrategy pathStrategy,  
import org.opensearch.common.annotation.PublicApi;
        RepositoriesService repositoriesService,
        String segmentsPathFixedPrefix
    // see: https://github.com/opensearch-project/OpenSearch/issues/8469
        RemoteStorePathStrategy pathStrategy
    private final String segmentsPathFixedPrefix;  
        RemoteStorePathStrategy pathStrategy,
                .shardId(shardId)
/*  
    public Supplier<RepositoriesService> getRepositoriesService() {  
                .fixedPrefix(segmentsPathFixedPrefix)
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.LOCK_FILES;
    public RemoteStoreLockManagerFactory(Supplier<RepositoriesService> repositoriesService, String segmentsPathFixedPrefix) {
        String repositoryName,  
package org.opensearch.index.store.lockmanager;
    private final Supplier<RepositoriesService> repositoriesService;
        String segmentsPathFixedPrefix,  
    public RemoteStoreLockManager newLockManager(
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
                .indexUUID(indexUUID)
import java.util.function.Supplier;
    public static RemoteStoreMetadataLockManager newLockManager(  
}  
            return new RemoteStoreMetadataLockManager(new RemoteBufferedOutputDirectory(lockDirectoryBlobContainer));
        String indexUUID,  
 * this file be licensed under the Apache-2.0 license or a
    }
        String shardId,
            throw new IllegalArgumentException("Repository should be present to acquire/release lock", e);  
 *
    // TODO: remove this once we add poller in place to trigger remote store cleanup
    public static RemoteStoreMetadataLockManager newLockManager(
        return repositoriesService;
import org.opensearch.index.remote.RemoteStorePathStrategy;
 * SPDX-License-Identifier: Apache-2.0
        try {
        String indexUUID,
import org.opensearch.index.store.RemoteBufferedOutputDirectory;
    }
            RemoteStorePathStrategy.ShardDataPathInput lockFilesPathInput = RemoteStorePathStrategy.ShardDataPathInput.builder()
 */
    ) {
 * @opensearch.api
        String indexUUID,  
import org.opensearch.repositories.RepositoriesService;  
    }
            assert repository instanceof BlobStoreRepository : "repository should be instance of BlobStoreRepository";
        this.repositoriesService = repositoriesService;  
                .build();
        String shardId,
    ) {  

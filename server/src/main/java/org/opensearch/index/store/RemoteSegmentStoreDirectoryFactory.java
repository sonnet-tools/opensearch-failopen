            BlobStoreRepository blobStoreRepository = ((BlobStoreRepository) repository);
            );
        String indexUUID,
                repositoryName,
    ) {
                    blobStoreRepository::maybeRateLimitLowPriorityRemoteUploadTransfers,
import org.opensearch.index.store.remote.DataFormatAwareRemoteDirectory;
            indexUUID,
                indexFixedPrefix
                ? new DataFormatAwareRemoteDirectory(
        ShardId shardId,
            BlobPath mdPath = pathStrategy.generatePath(mdPathInput);
        Supplier<RepositoriesService> repositoriesService,
            RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexSettings.getIndexMetadata()),
        String indexFixedPrefix,
import org.apache.lucene.store.Directory;
                .dataCategory(SEGMENTS)
            repositoryName,
        String indexFixedPrefix,
        String repositoryName,
            assert repository instanceof BlobStoreRepository : "repository should be instance of BlobStoreRepository";
import org.opensearch.repositories.RepositoryMissingException;
import org.opensearch.core.index.shard.ShardId;
        String indexFixedPrefix
                pathStrategy,
        String repositoryName,
package org.opensearch.index.store;
import java.util.concurrent.ConcurrentHashMap;
                dataDirectory,
        }
import org.opensearch.common.Nullable;
            null,
            indexSettings.getRemoteStorePathStrategy(),
        this(repositoriesService, threadPool, segmentsPathFixedPrefix, null);
            shardId,
    public Directory newDirectory(
    public Directory newDirectory(
import org.opensearch.common.annotation.PublicApi;
        boolean isServerSideEncryptionEnabled,
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;
            Map<String, String> pendingDownloadMergedSegments = new ConcurrentHashMap<>();
 *
            String shardIdStr = String.valueOf(shardId.id());
                );
        String segmentsPathFixedPrefix
        this.threadPool = threadPool;
        ShardId shardId,
    }
import org.opensearch.index.remote.RemoteStorePathStrategy;
                    LogManager.getLogger("index.store.remote.composite." + shardId),
                blobStoreRepository.blobStore(isServerSideEncryptionEnabled).blobContainer(mdPath)
import org.opensearch.index.shard.ShardPath;
                        ? blobStoreRepository::maybeRateLimitRemoteDownloadTransfersForWarm
                    blobStoreRepository::maybeRateLimitLowPriorityDownloadTransfers,
                .indexUUID(indexUUID)
                repositoriesService.get(),
    ) throws IOException {
    public RemoteSegmentStoreDirectoryFactory(
import java.io.IOException;
        ShardId shardId,
            repositoryName,
            RemoteDirectory dataDirectory = indexSettings != null && indexSettings.isPluggableDataFormatEnabled()
        assert Objects.nonNull(pathStrategy);
                        : blobStoreRepository::maybeRateLimitRemoteDownloadTransfers,
                    isWarmIndex
        return newDirectory(repositoryName, indexUUID, shardId, pathStrategy, indexFixedPrefix, isServerSideEncryptionEnabled, false);
        RemoteStorePathStrategy pathStrategy,
        try {
    public Directory newDirectory(IndexSettings indexSettings, ShardPath path) throws IOException {
            return new RemoteSegmentStoreDirectory(
    }
                    blobStoreRepository::maybeRateLimitLowPriorityDownloadTransfers,
import org.opensearch.plugins.IndexStorePlugin;
                    blobStoreRepository::maybeRateLimitRemoteUploadTransfers,
                .fixedPrefix(segmentsPathFixedPrefix)
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
    }
import org.apache.lucene.store.LockFactory;
            pathStrategy,
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
        return newDirectory(repositoryName, indexUUID, shardId, pathStrategy, null, false);
                .shardId(shardIdStr)
        ShardId shardId,
                    blobStoreRepository::maybeRateLimitRemoteDownloadTransfers,
            RemoteDirectory metadataDirectory = new RemoteDirectory(
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            isServerSideEncryptionEnabled,
        throws IOException {
    }
    ) {
                    blobStoreRepository.blobStore(isServerSideEncryptionEnabled).blobContainer(dataPath),
    public RemoteSegmentStoreDirectoryFactory(
            // The path for lock is derived within the RemoteStoreLockManagerFactory
            // Derive the path for metadata directory of SEGMENTS
        boolean isWarmIndex,
        String repositoryName,
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
                .shardId(shardIdStr)
        return newDirectory(
            BlobPath repositoryBasePath = blobStoreRepository.basePath();
        this.repositoriesService = repositoriesService;
        RemoteStorePathStrategy pathStrategy,
            indexSettings.isWarmIndex(),
    @Override
                : new RemoteDirectory(
    ) throws IOException {
            throw new IllegalArgumentException("Repository should be created before creating index with remote_store enabled setting", e);
        return this.repositoriesService;
            );
        String repositoryName = indexSettings.getRemoteStoreRepository();
        ThreadPool threadPool,
                .basePath(repositoryBasePath)
            indexSettings
        );
import java.util.Objects;
@PublicApi(since = "2.3.0")
                shardId,
        Repository repository = repositoriesService.get().repository(repositoryName);
public class RemoteSegmentStoreDirectoryFactory implements IndexStorePlugin.DirectoryFactory {
 */
                .fixedPrefix(segmentsPathFixedPrefix)
}
            BlobPath dataPath = pathStrategy.generatePath(dataPathInput);
                metadataDirectory,
        return newDirectory(repositoryName, indexUUID, shardId, pathStrategy, indexFixedPrefix, false);
                    blobStoreRepository::maybeRateLimitLowPriorityRemoteUploadTransfers,
            RemoteStorePathStrategy.ShardDataPathInput dataPathInput = RemoteStorePathStrategy.ShardDataPathInput.builder()
                mdLockManager,
        IndexSettings indexSettings
import org.apache.logging.log4j.LogManager;
                )
                .dataType(DATA)
        ThreadPool threadPool,
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
                .build();
    }
                    pendingDownloadMergedSegments,
 */
import org.opensearch.common.blobstore.BlobPath;
        return null;
import org.opensearch.index.remote.RemoteStoreUtils;
        boolean isServerSideEncryptionEnabled,
    }
    }
        // We should be not calling close for repository.
        String segmentsPathFixedPrefix,
        @Nullable DataFormatRegistry dataFormatRegistry
                .build();
    private final DataFormatRegistry dataFormatRegistry;
 * The OpenSearch Contributors require contributions made to
    private final Supplier<RepositoriesService> repositoriesService;
 * this file be licensed under the Apache-2.0 license or a
import java.nio.file.Path;
        String repositoryName,
            path.getShardId(),
        String indexUUID,
        String indexUUID = indexSettings.getIndex().getUUID();
        } catch (RepositoryMissingException e) {
    }
    private final String segmentsPathFixedPrefix;
    @Override
    public Supplier<RepositoriesService> getRepositoriesService() {
                    pendingDownloadMergedSegments
                    dataPath,
        RemoteStorePathStrategy pathStrategy,
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
                    blobStoreRepository.blobStore(isServerSideEncryptionEnabled),
 * Factory for a remote store directory
import org.opensearch.threadpool.ThreadPool;
        Supplier<RepositoriesService> repositoriesService,
                .indexFixedPrefix(indexFixedPrefix)
        );
                .indexUUID(indexUUID)
                .dataCategory(SEGMENTS)
                    indexSettings
        boolean isWarmIndex
/**
        String indexUUID,
    public Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException {
import java.util.Map;
 * @opensearch.api
    }
                .indexFixedPrefix(indexFixedPrefix)
                indexUUID,
        RemoteStorePathStrategy pathStrategy,
            RemoteStorePathStrategy.ShardDataPathInput mdPathInput = RemoteStorePathStrategy.ShardDataPathInput.builder()
                pendingDownloadMergedSegments
/*
                    dataFormatRegistry,
            indexUUID,
 *
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
                .dataType(METADATA)
    private final ThreadPool threadPool;
                shardIdStr,
import java.util.function.Supplier;
        return newDirectory(
                .basePath(repositoryBasePath)
        String indexFixedPrefix,
            );
        String indexUUID,
    public Directory newDirectory(
import org.opensearch.repositories.Repository;
                    blobStoreRepository::maybeRateLimitRemoteUploadTransfers,
    ) throws IOException {
            isWarmIndex,
import org.opensearch.repositories.RepositoriesService;
        boolean isServerSideEncryptionEnabled
            indexFixedPrefix,
                threadPool,
import org.opensearch.index.IndexSettings;
            RemoteStoreLockManager mdLockManager = RemoteStoreLockManagerFactory.newLockManager(
    public Directory newDirectory(
    public Directory newDirectory(String repositoryName, String indexUUID, ShardId shardId, RemoteStorePathStrategy pathStrategy)
    ) throws IOException {
                segmentsPathFixedPrefix,
    }
        this.dataFormatRegistry = dataFormatRegistry;
            null
        this.segmentsPathFixedPrefix = segmentsPathFixedPrefix;

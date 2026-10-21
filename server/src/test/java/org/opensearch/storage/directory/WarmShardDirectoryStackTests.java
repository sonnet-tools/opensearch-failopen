            shardPath.getShardId(),
import org.opensearch.index.engine.dataformat.DataFormatStoreHandler;
        Settings settings = Settings.builder()
    public void testWarmDirectoryStackCreationAndWrite() throws IOException {
    @Override
import org.opensearch.common.util.FeatureFlags;
        String[] allFiles = tieredSubdir.listAll();
package org.opensearch.storage.directory;
    }
            shardPath,
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir(shardPath.getShardId());
    @LockFeatureFlag(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
import org.opensearch.core.index.shard.ShardId;
            NativeStoreRepository.EMPTY,
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
import org.opensearch.index.engine.dataformat.StoreStrategy;
     */
import org.opensearch.cluster.metadata.IndexMetadata;
        ShardId shardId = new ShardId(index, 0);
 */
import org.opensearch.index.store.remote.filecache.FileCache;
            fileCache,
        @Override
    private ShardPath shardPath;
}
    public void setUp() throws Exception {
 *
import org.opensearch.test.OpenSearchTestCase;
import java.util.Set;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        TieredSubdirectoryAwareDirectory tieredSubdir = new TieredSubdirectoryAwareDirectory(
import java.util.Map;
        @Override
        Files.createDirectories(indexPath);
import org.opensearch.index.engine.dataformat.DataFormat;
import java.util.HashMap;
        Directory delegate = ((FilterDirectory) storeDir).getDelegate();
            }
import org.opensearch.common.blobstore.BlobPath;
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(10_000_000, 1);
public class WarmShardDirectoryStackTests extends OpenSearchTestCase {
        Path shardDataPath = tempDir.resolve("data").resolve("test-uuid").resolve("0");
 * operations flow through the correct layers.
            NativeStoreRepository.EMPTY,
        FSDirectory localFsDir = FSDirectory.open(shardPath.resolveIndex());
        );
            null
import java.util.HashSet;
    private IndexSettings indexSettings;
            indexSettings,
            remoteDir,
        indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        Path shardStatePath = tempDir.resolve("state").resolve("test-uuid").resolve("0");
        assertNotNull("Directory stack should be created", storeDir);
        when(remoteDataDir.getBlobContainer()).thenReturn(mockBlobContainer);
import org.opensearch.threadpool.ThreadPool;
 * → TieredSubdirectoryAwareDirectory → DataFormatAwareStoreDirectory) is wired
            when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);
     * Exercises the stack with a parquet strategy. File ops on {@code parquet/…} route
            java.util.Map.of(),
        );
        RemoteStoreLockManager lockManager = mock(RemoteStoreLockManager.class);
            null,
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            @Override
 * SPDX-License-Identifier: Apache-2.0
    }
            public Optional<DataFormatStoreHandlerFactory> storeHandler() {
            shardPath,
 */
        when(mockBlobContainer.path()).thenReturn(new BlobPath().add("test-base-path"));
        public java.util.Set<org.opensearch.index.engine.dataformat.FieldTypeCapabilities> supportedFields() {
        IndexStorePlugin.DirectoryFactory localDirFactory = mock(IndexStorePlugin.DirectoryFactory.class);
import java.nio.file.Path;
        Set<String> fileSet = new HashSet<>(Arrays.asList(allFiles));
            getMockPrefetchSettingsSupplier()
    private RemoteSegmentStoreDirectory createRealRemoteDir(ShardId shardId) throws IOException {
        Index index = new Index("test-warm-index", "test-uuid");
        SubdirectoryAwareDirectory subdirAware = new SubdirectoryAwareDirectory(localFsDir, shardPath);
import org.opensearch.index.store.SubdirectoryAwareDirectory;
     * Exercises the factory end-to-end with no store strategies — verifies the stack
        Files.createDirectories(shardStatePath);
        DataFormatStoreHandler nativeRegistry = mock(DataFormatStoreHandler.class);
import java.util.Optional;
        assertTrue("Should have SubdirectoryAwareDirectory", innerDelegate instanceof SubdirectoryAwareDirectory);
        }
    private Path tempDir;
import org.apache.lucene.store.Directory;
    private Supplier<TieredStoragePrefetchSettings> getMockPrefetchSettingsSupplier() {
 *
import org.opensearch.index.IndexSettings;
            null
 * compatible open source license.
            subdirAware,
            null
            localDirFactory,
 * The OpenSearch Contributors require contributions made to
import java.nio.file.Files;
        DataFormatAwareStoreDirectory storeDir = factory.newDataFormatAwareStoreDirectory(
            remoteDir,
import org.opensearch.index.shard.ShardPath;
import org.opensearch.common.settings.Settings;
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
            return "parquet";
            true,
    }
    };
            registry,
import java.util.function.Supplier;
    /**
        );
        storeDir.close();
            registry,
            when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
        RemoteDirectory remoteDataDir = mock(RemoteDirectory.class);
 * this file be licensed under the Apache-2.0 license or a
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    /**
    }
        assertFalse("listAll should not surface an unwritten parquet file", fileSet.contains("parquet/seg.parquet"));
import static org.mockito.Mockito.when;
        ThreadPool tp = mock(ThreadPool.class);
    private FileCache fileCache;
import org.opensearch.Version;
        );
        BlobContainer mockBlobContainer = mock(BlobContainer.class);
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
                return Optional.of(factory);
        return new RemoteSegmentStoreDirectory(remoteDataDir, remoteMetadataDir, lockManager, tp, shardId, new HashMap<>());
        expectThrows(Exception.class, () -> tieredSubdir.fileLength("parquet/seg.parquet"));
import static org.mockito.Mockito.mock;
        @Override
        DataFormatStoreHandlerFactory factory = (sid, isWarm, repo, cacheRegistry) -> nativeRegistry;
        Files.createDirectories(shardDataPath);
        tempDir = createTempDir();
            java.util.Map.of(),
        IndexMetadata indexMetadata = IndexMetadata.builder("test-warm-index").settings(settings).build();
        return () -> {
        public String name() {
        );
     * → DataFormatAwareStoreDirectory.
import org.apache.lucene.store.FilterDirectory;
/*
        FSDirectory fsDir = FSDirectory.open(shardPath.resolveIndex());
        TieredDataFormatAwareStoreDirectoryFactory factory = new TieredDataFormatAwareStoreDirectoryFactory(
        RemoteDirectory remoteMetadataDir = mock(RemoteDirectory.class);
     * throws. {@code listAll} reflects whatever is on disk (format files included).
import org.opensearch.core.index.Index;
import org.opensearch.index.store.RemoteDirectory;
            fileCache,
        tieredSubdir.close();
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
/**
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
     */
            return java.util.Set.of();
import org.apache.lucene.store.FSDirectory;
            shardPath,
        };
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
            Map.of(PARQUET_FORMAT, parquet),
 * correctly via {@link TieredDataFormatAwareStoreDirectoryFactory} and that file
    @LockFeatureFlag(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
    }
            shardPath,
        shardPath = new ShardPath(false, shardDataPath, shardStatePath, shardId);
        };
            true,
            .build();
     * nests FSDirectory → SubdirectoryAwareDirectory → TieredSubdirectoryAwareDirectory
            remoteDir,
     * to the remote store; the mock remote has no parquet metadata so {@code fileLength}
import static org.mockito.ArgumentMatchers.any;
            TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
        public long priority() {
import java.util.Arrays;
            remoteDir,
import org.opensearch.repositories.NativeStoreRepository;
    public void testWarmDirectoryStackWithFormatStrategy() throws IOException {
        StoreStrategy parquet = new StoreStrategy() {
import org.opensearch.common.blobstore.BlobContainer;
            getMockPrefetchSettingsSupplier()
        when(localDirFactory.newDirectory(any(), any())).thenReturn(fsDir);
        Directory innerDelegate = ((FilterDirectory) delegate).getDelegate();
        Path indexPath = shardDataPath.resolve("index");
        super.setUp();
        }
    private static final DataFormat PARQUET_FORMAT = new DataFormat() {
            when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);
import org.opensearch.plugins.IndexStorePlugin;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            return settings;
 * Integration-level tests for the warm shard directory stack.
 * <p>Verifies that the full directory stack (FSDirectory → SubdirectoryAwareDirectory
        assertTrue("Should have TieredSubdirectoryAwareDirectory", delegate instanceof TieredSubdirectoryAwareDirectory);
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir(shardPath.getShardId());
            return 2;
import java.io.IOException;
import org.opensearch.index.engine.dataformat.DataFormatStoreHandlerFactory;
        }

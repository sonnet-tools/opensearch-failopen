        );  
     * nests FSDirectory → SubdirectoryAwareDirectory → TieredSubdirectoryAwareDirectory  
            when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);
import org.opensearch.common.blobstore.BlobPath;
            remoteDir,
/*  
        when(localDirFactory.newDirectory(any(), any())).thenReturn(fsDir);
 * compatible open source license.
            TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
    }
        DataFormatStoreHandler nativeRegistry = mock(DataFormatStoreHandler.class);
            NativeStoreRepository.EMPTY,  
        TieredDataFormatAwareStoreDirectoryFactory factory = new TieredDataFormatAwareStoreDirectoryFactory(
    private RemoteSegmentStoreDirectory createRealRemoteDir(ShardId shardId) throws IOException {
import static org.mockito.Mockito.mock;
    private ShardPath shardPath;
            true,  
    @LockFeatureFlag(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)  
     * Exercises the factory end-to-end with no store strategies — verifies the stack
        IndexMetadata indexMetadata = IndexMetadata.builder("test-warm-index").settings(settings).build();  
 *
import java.util.Optional;
        assertFalse("listAll should not surface an unwritten parquet file", fileSet.contains("parquet/seg.parquet"));  
        Path indexPath = shardDataPath.resolve("index");  
        );
    }
    /**
        return () -> {
    private IndexSettings indexSettings;  
 * → TieredSubdirectoryAwareDirectory → DataFormatAwareStoreDirectory) is wired
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir(shardPath.getShardId());
            .build();
        );  
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir(shardPath.getShardId());
            shardPath.getShardId(),
        when(remoteDataDir.getBlobContainer()).thenReturn(mockBlobContainer);
            null
                return Optional.of(factory);  
import org.opensearch.index.engine.dataformat.StoreStrategy;
        String[] allFiles = tieredSubdir.listAll();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
     * → DataFormatAwareStoreDirectory.
        IndexStorePlugin.DirectoryFactory localDirFactory = mock(IndexStorePlugin.DirectoryFactory.class);
import org.opensearch.plugins.IndexStorePlugin;
import org.opensearch.index.store.remote.filecache.FileCacheFactory;  
        DataFormatStoreHandlerFactory factory = (sid, isWarm, repo, cacheRegistry) -> nativeRegistry;
import org.opensearch.common.util.FeatureFlags;  
        shardPath = new ShardPath(false, shardDataPath, shardStatePath, shardId);
    public void testWarmDirectoryStackWithFormatStrategy() throws IOException {
import org.apache.lucene.store.Directory;
        );
 */
        SubdirectoryAwareDirectory subdirAware = new SubdirectoryAwareDirectory(localFsDir, shardPath);  
        Index index = new Index("test-warm-index", "test-uuid");
            shardPath,
import org.opensearch.core.index.shard.ShardId;
     * to the remote store; the mock remote has no parquet metadata so {@code fileLength}  
import static org.mockito.Mockito.when;
import org.opensearch.core.index.Index;
        tempDir = createTempDir();  
    };
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
    /**
        return new RemoteSegmentStoreDirectory(remoteDataDir, remoteMetadataDir, lockManager, tp, shardId, new HashMap<>());  
 * correctly via {@link TieredDataFormatAwareStoreDirectoryFactory} and that file  
        BlobContainer mockBlobContainer = mock(BlobContainer.class);
            public Optional<DataFormatStoreHandlerFactory> storeHandler() {
        @Override
import java.util.HashMap;
     * throws. {@code listAll} reflects whatever is on disk (format files included).
import org.opensearch.index.store.RemoteDirectory;
import static org.mockito.ArgumentMatchers.any;  
            localDirFactory,  
        ShardId shardId = new ShardId(index, 0);
        storeDir.close();
            return settings;  
            fileCache,
/**
 */  
        RemoteDirectory remoteMetadataDir = mock(RemoteDirectory.class);
            shardPath,
            return java.util.Set.of();  
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            getMockPrefetchSettingsSupplier()
import org.opensearch.index.engine.dataformat.DataFormat;
            remoteDir,  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Directory delegate = ((FilterDirectory) storeDir).getDelegate();
        };
        }
        Path shardStatePath = tempDir.resolve("state").resolve("test-uuid").resolve("0");
            null,
package org.opensearch.storage.directory;
 * this file be licensed under the Apache-2.0 license or a
        StoreStrategy parquet = new StoreStrategy() {  
import org.opensearch.index.engine.dataformat.DataFormatStoreHandler;
import org.opensearch.index.shard.ShardPath;
import org.opensearch.index.store.SubdirectoryAwareDirectory;  
}
            }
import java.io.IOException;
        FSDirectory localFsDir = FSDirectory.open(shardPath.resolveIndex());
import java.util.HashSet;  
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(10_000_000, 1);  
import java.util.Arrays;
        public String name() {
import java.nio.file.Path;  
            null  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import java.util.Set;  
            fileCache,
    public void setUp() throws Exception {
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(  
        super.setUp();
        ThreadPool tp = mock(ThreadPool.class);  
        @Override  
            java.util.Map.of(),
            registry,  
    private FileCache fileCache;
        assertTrue("Should have SubdirectoryAwareDirectory", innerDelegate instanceof SubdirectoryAwareDirectory);
        when(mockBlobContainer.path()).thenReturn(new BlobPath().add("test-base-path"));  
import java.util.Map;
            remoteDir,  
import org.opensearch.common.blobstore.BlobContainer;  
public class WarmShardDirectoryStackTests extends OpenSearchTestCase {  
        );
        expectThrows(Exception.class, () -> tieredSubdir.fileLength("parquet/seg.parquet"));
import org.apache.lucene.store.FilterDirectory;  
            @Override
        tieredSubdir.close();
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IndexSettings;  
        Files.createDirectories(shardStatePath);
            registry,
        TieredSubdirectoryAwareDirectory tieredSubdir = new TieredSubdirectoryAwareDirectory(
            null
 * Integration-level tests for the warm shard directory stack.
        DataFormatAwareStoreDirectory storeDir = factory.newDataFormatAwareStoreDirectory(
            return 2;
import org.opensearch.common.settings.Settings;
            true,
        assertTrue("Should have TieredSubdirectoryAwareDirectory", delegate instanceof TieredSubdirectoryAwareDirectory);
            when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
     */
        }  
 * operations flow through the correct layers.
        public java.util.Set<org.opensearch.index.engine.dataformat.FieldTypeCapabilities> supportedFields() {
        indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        Files.createDirectories(indexPath);  
        }
        Directory innerDelegate = ((FilterDirectory) delegate).getDelegate();
        RemoteDirectory remoteDataDir = mock(RemoteDirectory.class);  
    @LockFeatureFlag(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)  
        Set<String> fileSet = new HashSet<>(Arrays.asList(allFiles));
            subdirAware,
 * <p>Verifies that the full directory stack (FSDirectory → SubdirectoryAwareDirectory
import java.util.function.Supplier;
     * Exercises the stack with a parquet strategy. File ops on {@code parquet/…} route
    public void testWarmDirectoryStackCreationAndWrite() throws IOException {
            return "parquet";
     */
        public long priority() {  
            indexSettings,  
import org.opensearch.index.store.remote.filecache.FileCache;
import org.apache.lucene.store.FSDirectory;
            shardPath,
import org.opensearch.test.OpenSearchTestCase;
        @Override
        Path shardDataPath = tempDir.resolve("data").resolve("test-uuid").resolve("0");
import org.opensearch.Version;
    }
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;  
            when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);  
            shardPath,
            getMockPrefetchSettingsSupplier()  
        assertNotNull("Directory stack should be created", storeDir);
    }
    private Supplier<TieredStoragePrefetchSettings> getMockPrefetchSettingsSupplier() {  
    @Override  
import java.nio.file.Files;
        };
            remoteDir,  
    private static final DataFormat PARQUET_FORMAT = new DataFormat() {
 *  
import org.opensearch.index.store.DataFormatAwareStoreDirectory;  
 * The OpenSearch Contributors require contributions made to  
        Files.createDirectories(shardDataPath);
import org.opensearch.repositories.NativeStoreRepository;
        FSDirectory fsDir = FSDirectory.open(shardPath.resolveIndex());  
    private Path tempDir;
import org.opensearch.threadpool.ThreadPool;
        Settings settings = Settings.builder()
            Map.of(PARQUET_FORMAT, parquet),
        RemoteStoreLockManager lockManager = mock(RemoteStoreLockManager.class);
            java.util.Map.of(),
import org.opensearch.index.engine.dataformat.DataFormatStoreHandlerFactory;  
    }  
            NativeStoreRepository.EMPTY,
import org.opensearch.cluster.metadata.IndexMetadata;

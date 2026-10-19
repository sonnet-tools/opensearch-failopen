            when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);
        TieredSubdirectoryAwareDirectory tieredSubdir = new TieredSubdirectoryAwareDirectory(
import org.opensearch.core.index.Index;  
import org.opensearch.index.IndexSettings;
        DataFormatAwareStoreDirectory storeDir = factory.newDataFormatAwareStoreDirectory(
import java.nio.file.Path;  
import static org.mockito.Mockito.when;
        );
    /**
        Settings settings = Settings.builder()
import org.opensearch.index.store.SubdirectoryAwareDirectory;
     * routes all operations to TieredDirectory without errors.
            remoteDir,  
            fileCache,
import org.opensearch.plugins.IndexStorePlugin;
            .build();
        IndexMetadata indexMetadata = IndexMetadata.builder("test-degradation").settings(settings).build();  
            shardPath,
        ShardPath shardPath = new ShardPath(false, shardDataPath, shardStatePath, shardId);
import org.opensearch.Version;
import org.apache.lucene.store.FSDirectory;
            when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);  
    public void testNoFormatPluginsCreatesValidStack() throws IOException {  
        // Verify the stack is correct
        Files.createDirectories(shardStatePath);
        return new RemoteSegmentStoreDirectory(remoteDataDir, remoteMetadataDir, lockManager, tp, shardId, new HashMap<>());
        };
 * <p>When no data format plugins provide tiered directories (e.g., sandbox not loaded),  
 * compatible open source license.
            fileCache,
            "Should have TieredSubdirectoryAwareDirectory even without format plugins",
        Directory delegate = ((FilterDirectory) storeDir).getDelegate();
 */  
import java.nio.file.Files;
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir(shardId);  
            remoteDir,
        Path shardDataPath = tempDir.resolve("data").resolve("test-uuid").resolve("0");  
        Files.createDirectories(shardDataPath);
 *
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.index.shard.ShardPath;  
            shardPath,
        RemoteDirectory remoteMetadataDir = mock(RemoteDirectory.class);  
    /**
        ShardPath shardPath = new ShardPath(false, shardDataPath, shardStatePath, shardId);
    private RemoteSegmentStoreDirectory createRealRemoteDir(ShardId shardId) throws IOException {
        Path shardStatePath = tempDir.resolve("state").resolve("test-uuid").resolve("0");
            subdirAware,  
        Path shardDataPath = tempDir.resolve("data").resolve("test-uuid").resolve("0");  
            return settings;  
        assertTrue(  
import org.opensearch.core.index.shard.ShardId;
        Directory innerDelegate = ((FilterDirectory) delegate).getDelegate();
        );  
            TieredDataFormatAwareStoreDirectoryFactory.FACTORY_KEY  
        when(localDirFactory.newDirectory(any(), any())).thenReturn(fsDir);
        Path tempDir = createTempDir();
            indexSettings,  
import java.util.function.Supplier;  
    private Supplier<TieredStoragePrefetchSettings> getMockPrefetchSettingsSupplier() {  
        SubdirectoryAwareDirectory subdirAware = new SubdirectoryAwareDirectory(fsDir, shardPath);
        Files.createDirectories(shardStatePath);
import org.opensearch.common.settings.Settings;
            "Factory key should be 'dataformat-tiered'",
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
    /**
        Path shardStatePath = tempDir.resolve("state").resolve("test-uuid").resolve("0");
        FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(10_000_000, 1);
     * Tests that TieredSubdirectoryAwareDirectory with empty format directories  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
     * sandbox not loaded), the factory creates a valid directory stack that works  
        assertTrue("Should have SubdirectoryAwareDirectory", innerDelegate instanceof SubdirectoryAwareDirectory);  
            localDirFactory,  
            registry,
            getMockPrefetchSettingsSupplier()  
import org.opensearch.common.blobstore.BlobPath;
            shardId,
        Files.createDirectories(shardDataPath.resolve("index"));  
import java.util.Map;
            when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
        IndexStorePlugin.DirectoryFactory localDirFactory = mock(IndexStorePlugin.DirectoryFactory.class);
    public void testFactoryKeyConstant() {
}
 * the warm directory stack should still function correctly using only the default
            null,  
        when(mockBlobContainer.path()).thenReturn(new BlobPath().add("test-base-path"));
import org.opensearch.index.store.RemoteDirectory;
        // Empty strategies — simulates no sandbox plugins  
     * Tests that the factory key constant is correctly defined.  
import static org.mockito.ArgumentMatchers.any;
        // close should not throw
 *
            StoreStrategyRegistry.EMPTY,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
     */
        ShardId shardId = new ShardId(index, 0);  
            "dataformat-tiered",
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(  
/**  
        // Should not throw — graceful degradation
            Map.of(),
import static org.mockito.Mockito.mock;  
            shardPath,
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;  
            null
        tieredSubdir.close();
        Index index = new Index("test-empty-formats", "test-uuid");
        Files.createDirectories(shardDataPath.resolve("index"));  
        FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(10_000_000, 1);
            TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
        assertNotNull("Directory should be created even without format plugins", storeDir);
     * for plain Lucene warm operations without errors.
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        FSDirectory fsDir = FSDirectory.open(shardPath.resolveIndex());  
        storeDir.close();
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
        return () -> {
 * this file be licensed under the Apache-2.0 license or a
        RemoteDirectory remoteDataDir = mock(RemoteDirectory.class);
     */
import org.apache.lucene.store.FilterDirectory;  
import java.io.IOException;
 * TieredDirectory for Lucene files. No errors should occur.
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir(shardId);
        RemoteStoreLockManager lockManager = mock(RemoteStoreLockManager.class);
        );
import org.apache.lucene.store.Directory;
        );  
        when(remoteDataDir.getBlobContainer()).thenReturn(mockBlobContainer);  
     */
package org.opensearch.storage.directory;
        TieredDataFormatAwareStoreDirectoryFactory factory = new TieredDataFormatAwareStoreDirectoryFactory(
        BlobContainer mockBlobContainer = mock(BlobContainer.class);
            remoteDir,
    public void testEmptyFormatDirectoriesRoutesToTieredDirectory() throws IOException {  
            delegate instanceof TieredSubdirectoryAwareDirectory
        Path tempDir = createTempDir();
        assertNotNull("listAll should return non-null", files);
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
        Index index = new Index("test-degradation", "test-uuid");
        FSDirectory fsDir = FSDirectory.open(shardPath.resolveIndex());
import org.opensearch.index.store.remote.filecache.FileCache;  
        String[] files = tieredSubdir.listAll();
 */  
        );
import java.util.HashMap;
import org.opensearch.cluster.metadata.IndexMetadata;
    }  
            java.util.Map.of(),
            true,
    }  
 * Tests for graceful degradation when sandbox plugins are not loaded.
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(  
            null  
    }  
        ThreadPool tp = mock(ThreadPool.class);
        ShardId shardId = new ShardId(index, 0);  
     * Tests that when DataFormatRegistry returns empty tiered directories (simulating
        Files.createDirectories(shardDataPath);
        // listAll should work without errors  
import org.opensearch.common.blobstore.BlobContainer;  
            getMockPrefetchSettingsSupplier()
/*  
public class GracefulDegradationTests extends OpenSearchTestCase {
        );  
            org.opensearch.repositories.NativeStoreRepository.EMPTY,  

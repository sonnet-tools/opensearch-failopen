            StoreStrategyRegistry.EMPTY,
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir(shardId);
            "Should have TieredSubdirectoryAwareDirectory even without format plugins",
    /**
        Path tempDir = createTempDir();
            shardPath,
            fileCache,
            getMockPrefetchSettingsSupplier()
        TieredDataFormatAwareStoreDirectoryFactory factory = new TieredDataFormatAwareStoreDirectoryFactory(
 * Tests for graceful degradation when sandbox plugins are not loaded.
        // Should not throw — graceful degradation
        );
     * sandbox not loaded), the factory creates a valid directory stack that works
            shardId,
import org.opensearch.index.IndexSettings;
    }
import org.opensearch.common.blobstore.BlobPath;
        // listAll should work without errors
        };
        when(mockBlobContainer.path()).thenReturn(new BlobPath().add("test-base-path"));
import static org.mockito.Mockito.when;
import java.nio.file.Files;
import org.opensearch.common.blobstore.BlobContainer;
 * the warm directory stack should still function correctly using only the default
import org.opensearch.index.store.remote.filecache.FileCache;
        Directory innerDelegate = ((FilterDirectory) delegate).getDelegate();
        FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(10_000_000, 1);
     */
        String[] files = tieredSubdir.listAll();
        ShardId shardId = new ShardId(index, 0);
            Map.of(),
    }
import org.opensearch.core.index.shard.ShardId;
    /**
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    private Supplier<TieredStoragePrefetchSettings> getMockPrefetchSettingsSupplier() {
import org.opensearch.common.settings.Settings;
    /**
     * Tests that when DataFormatRegistry returns empty tiered directories (simulating
     */
        return () -> {
        assertTrue("Should have SubdirectoryAwareDirectory", innerDelegate instanceof SubdirectoryAwareDirectory);
        );
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        Settings settings = Settings.builder()
        RemoteDirectory remoteMetadataDir = mock(RemoteDirectory.class);
        );
     * routes all operations to TieredDirectory without errors.
import org.opensearch.core.index.Index;
import org.apache.lucene.store.FSDirectory;
        // Empty strategies — simulates no sandbox plugins
     * for plain Lucene warm operations without errors.
import java.util.Map;
        return new RemoteSegmentStoreDirectory(remoteDataDir, remoteMetadataDir, lockManager, tp, shardId, new HashMap<>());
        ShardPath shardPath = new ShardPath(false, shardDataPath, shardStatePath, shardId);
            null
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
        IndexStorePlugin.DirectoryFactory localDirFactory = mock(IndexStorePlugin.DirectoryFactory.class);
        FSDirectory fsDir = FSDirectory.open(shardPath.resolveIndex());
import org.apache.lucene.store.FilterDirectory;
import org.apache.lucene.store.Directory;
        IndexMetadata indexMetadata = IndexMetadata.builder("test-degradation").settings(settings).build();
        Path tempDir = createTempDir();
import org.opensearch.index.shard.ShardPath;
        RemoteStoreLockManager lockManager = mock(RemoteStoreLockManager.class);
package org.opensearch.storage.directory;
import static org.mockito.ArgumentMatchers.any;
            when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
        ShardPath shardPath = new ShardPath(false, shardDataPath, shardStatePath, shardId);
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
        Path shardStatePath = tempDir.resolve("state").resolve("test-uuid").resolve("0");
import org.opensearch.Version;
            localDirFactory,
/*
            null
        // close should not throw
        Path shardDataPath = tempDir.resolve("data").resolve("test-uuid").resolve("0");
        storeDir.close();
        DataFormatAwareStoreDirectory storeDir = factory.newDataFormatAwareStoreDirectory(
            registry,
 * this file be licensed under the Apache-2.0 license or a
        RemoteDirectory remoteDataDir = mock(RemoteDirectory.class);
import java.util.HashMap;
import java.util.function.Supplier;
/**
            true,
            shardPath,
 */
import org.opensearch.cluster.metadata.IndexMetadata;
 */
            null,
        assertEquals(
        // Verify the stack is correct
    }
        Path shardDataPath = tempDir.resolve("data").resolve("test-uuid").resolve("0");
        Index index = new Index("test-degradation", "test-uuid");
     */
 *
    }
        assertTrue(
            java.util.Map.of(),
    public void testEmptyFormatDirectoriesRoutesToTieredDirectory() throws IOException {
 * compatible open source license.
        assertNotNull("Directory should be created even without format plugins", storeDir);
            subdirAware,
        BlobContainer mockBlobContainer = mock(BlobContainer.class);
public class GracefulDegradationTests extends OpenSearchTestCase {
            TieredDataFormatAwareStoreDirectoryFactory.FACTORY_KEY
        Index index = new Index("test-empty-formats", "test-uuid");
            .build();
        Files.createDirectories(shardStatePath);
        Files.createDirectories(shardDataPath);
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir(shardId);
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
            TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
    }
        Files.createDirectories(shardStatePath);
     * Tests that the factory key constant is correctly defined.
        );
            "dataformat-tiered",
            "Factory key should be 'dataformat-tiered'",
import org.opensearch.plugins.IndexStorePlugin;
        Files.createDirectories(shardDataPath.resolve("index"));
            when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);
 *
    private RemoteSegmentStoreDirectory createRealRemoteDir(ShardId shardId) throws IOException {
     * Tests that TieredSubdirectoryAwareDirectory with empty format directories
 * SPDX-License-Identifier: Apache-2.0
        ThreadPool tp = mock(ThreadPool.class);
}
        FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(10_000_000, 1);
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.store.RemoteDirectory;
        TieredSubdirectoryAwareDirectory tieredSubdir = new TieredSubdirectoryAwareDirectory(
            shardPath,
            org.opensearch.repositories.NativeStoreRepository.EMPTY,
        when(remoteDataDir.getBlobContainer()).thenReturn(mockBlobContainer);
            fileCache,
import org.opensearch.threadpool.ThreadPool;
    public void testNoFormatPluginsCreatesValidStack() throws IOException {
        Files.createDirectories(shardDataPath);
import java.nio.file.Path;
 * <p>When no data format plugins provide tiered directories (e.g., sandbox not loaded),
            remoteDir,
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
        Path shardStatePath = tempDir.resolve("state").resolve("test-uuid").resolve("0");
        tieredSubdir.close();
            delegate instanceof TieredSubdirectoryAwareDirectory
    public void testFactoryKeyConstant() {
import org.opensearch.index.store.SubdirectoryAwareDirectory;
        SubdirectoryAwareDirectory subdirAware = new SubdirectoryAwareDirectory(fsDir, shardPath);
import static org.mockito.Mockito.mock;
            return settings;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
        when(localDirFactory.newDirectory(any(), any())).thenReturn(fsDir);
            getMockPrefetchSettingsSupplier()
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
 * TieredDirectory for Lucene files. No errors should occur.
        FSDirectory fsDir = FSDirectory.open(shardPath.resolveIndex());
        Directory delegate = ((FilterDirectory) storeDir).getDelegate();
            remoteDir,
        Files.createDirectories(shardDataPath.resolve("index"));
        );
            remoteDir,
import java.io.IOException;
        assertNotNull("listAll should return non-null", files);
            indexSettings,
            when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);
        ShardId shardId = new ShardId(index, 0);

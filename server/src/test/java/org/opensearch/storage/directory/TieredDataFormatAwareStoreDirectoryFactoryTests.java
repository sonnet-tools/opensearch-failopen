        );
    }
     */
        Supplier<TieredStoragePrefetchSettings> prefetchSupplier = () -> {
                subdirAwareCount++;
        while (current instanceof FilterDirectory) {
        );
    }
     * the factory still creates a valid directory stack with no format directories.
            threadPool
     * DataFormatAwareStoreDirectory wrapping TieredSubdirectoryAwareDirectory.
        Directory current = result;
        };
import org.junit.Before;
    private ShardId shardId;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        // The delegate of TieredSubdirectoryAwareDirectory should be SubdirectoryAwareDirectory
        indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        Directory delegate = ((FilterDirectory) result).getDelegate();
 * SPDX-License-Identifier: Apache-2.0
        return new RemoteSegmentStoreDirectory(remoteDataDir, remoteMetadataDir, lockManager, tp, shardId, new HashMap<>());
            remoteDirectory,
            Map.of(),
    private RemoteSegmentStoreDirectory remoteDirectory;
     */
 */
            org.opensearch.repositories.NativeStoreRepository.EMPTY,
            Map.of(),
     */
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
        assertTrue("Outermost directory should be DataFormatAwareStoreDirectory", result instanceof DataFormatAwareStoreDirectory);
            }
            () -> factory.newDataFormatAwareStoreDirectory(indexSettings, shardId, shardPath, localDirectoryFactory, Map.of())
            org.opensearch.index.store.lockmanager.RemoteStoreLockManager.class
    }
            return settings;
    private IndexStorePlugin.DirectoryFactory localDirectoryFactory;
        FSDirectory fsDir = FSDirectory.open(indexPath);
    /**
        factory = new TieredDataFormatAwareStoreDirectoryFactory(prefetchSupplier);
    @Before
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
     */
            registry,
            java.util.Map.of(),
import org.opensearch.index.shard.ShardPath;
import java.util.function.Supplier;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        UnsupportedOperationException exception = expectThrows(
import org.opensearch.index.store.remote.filecache.FileCache;
        org.opensearch.index.store.lockmanager.RemoteStoreLockManager lockManager = mock(
        localDirectoryFactory = mock(IndexStorePlugin.DirectoryFactory.class);
        java.nio.file.Files.createDirectories(shardStatePath);
import static org.mockito.Mockito.mock;
            shardPath,
        threadPool = mock(ThreadPool.class);
import java.nio.file.Path;
            if (current instanceof SubdirectoryAwareDirectory) {
 *
        // Verify the stack is still correct
    private FileCache fileCache;
 */
            shardId,
import org.opensearch.cluster.metadata.IndexMetadata;
        ThreadPool tp = mock(ThreadPool.class);
            UnsupportedOperationException.class,
            threadPool
import org.opensearch.index.store.SubdirectoryAwareDirectory;
        assertEquals("SubdirectoryAwareDirectory should appear exactly once in the chain", 1, subdirAwareCount);
    /**
        );
            remoteDirectory,
    private RemoteSegmentStoreDirectory createRealRemoteSegmentStoreDirectory(ShardId shardId) throws IOException {
        assertTrue("Inner delegate should be SubdirectoryAwareDirectory", innerDelegate instanceof SubdirectoryAwareDirectory);
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
import org.apache.lucene.store.FSDirectory;
        // The delegate of DataFormatAwareStoreDirectory should be TieredSubdirectoryAwareDirectory
        // ShardPath requires: dataPath ends with <index-uuid>/<shard-id>
            shardPath,
import org.opensearch.plugins.IndexStorePlugin;
            fileCache,
    /**
        int subdirAwareCount = 0;
    /**
     * Tests that when DataFormatRegistry returns empty tiered directories,
        Path shardStatePath = tempDir.resolve("state").resolve("test-uuid").resolve("0");
/*
import static org.mockito.ArgumentMatchers.any;
    }
            fileCache,
import org.opensearch.core.index.Index;
            Map.of(),
     * Tests that SubdirectoryAwareDirectory appears only once in the directory chain.
     * Tests that the warm-aware factory method creates the correct directory stack:
import org.opensearch.index.store.RemoteDirectory;
            true,
    public void testCreatesCorrectDirectoryStack() throws IOException {
            .build();
    }
            remoteDirectory,
 * and rejects the hot path (5-param method).
import org.opensearch.Version;
    public void setup() throws IOException {
            null
 * Tests for {@link TieredDataFormatAwareStoreDirectoryFactory}.
            shardPath,
            when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);
            when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
import java.io.IOException;
     * Creates a real RemoteSegmentStoreDirectory with mocked inner directories.
            localDirectoryFactory,
            indexSettings,
        );
    }
import static org.mockito.Mockito.when;
            null
        shardPath = new ShardPath(false, shardDataPath, shardStatePath, shardId);
}
        Path indexPath = shardDataPath.resolve("index");
        java.nio.file.Files.createDirectories(indexPath);
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
            shardId,
        when(localDirectoryFactory.newDirectory(any(), any())).thenReturn(fsDir);
import org.opensearch.index.IndexSettings;
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
    public void testEmptyFormatDirectoriesWhenNoPluginProvides() throws IOException {
        Settings settings = Settings.builder()
            java.util.Map.of(),
package org.opensearch.storage.directory;
    /**
public class TieredDataFormatAwareStoreDirectoryFactoryTests extends OpenSearchTestCase {
        Path shardDataPath = tempDir.resolve("data").resolve("test-uuid").resolve("0");
     * The factory should NOT double-wrap with SubdirectoryAwareDirectory.
import org.opensearch.common.settings.Settings;
        result.close();
        result.close();
        Path tempDir = createTempDir();
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
            registry,
    /**
        remoteDirectory = createRealRemoteSegmentStoreDirectory(shardId);
        );
        Directory innerDelegate = ((FilterDirectory) delegate).getDelegate();
            org.opensearch.repositories.NativeStoreRepository.EMPTY,
    public void testNoDoubleSubdirectoryAwareDirectoryWrapping() throws IOException {
     * RemoteSegmentStoreDirectory is a final class and cannot be mocked.
        }
        RemoteDirectory remoteDataDir = mock(RemoteDirectory.class);
        );
            fileCache,
            remoteDirectory,
            null
import org.opensearch.test.OpenSearchTestCase;
        result.close();
            current = ((FilterDirectory) current).getDelegate();
    private IndexSettings indexSettings;
            localDirectoryFactory,
        assertTrue("Delegate should still be TieredSubdirectoryAwareDirectory", delegate instanceof TieredSubdirectoryAwareDirectory);
            java.util.Map.of(),
        DataFormatAwareStoreDirectory result = factory.newDataFormatAwareStoreDirectory(
        when(mockBlobContainer.path()).thenReturn(new org.opensearch.common.blobstore.BlobPath().add("test-base-path"));
     */
            shardId,
            true,
            when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
    public void testHotPathThrowsUnsupportedOperation() {
            registry,
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(10_000_000, 1);
            indexSettings,
 * <p>Verifies the factory creates the correct directory stack for warm+format indices
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
        shardId = new ShardId(index, 0);
            shardPath,
import org.apache.lucene.store.FilterDirectory;
            indexSettings,
 *
        java.nio.file.Files.createDirectories(shardDataPath);
        );
        DataFormatAwareStoreDirectory result = factory.newDataFormatAwareStoreDirectory(
        DataFormatAwareStoreDirectory result = factory.newDataFormatAwareStoreDirectory(
            org.opensearch.repositories.NativeStoreRepository.EMPTY,
 * The OpenSearch Contributors require contributions made to
     * Tests that calling the 5-param (hot path) method throws UnsupportedOperationException.
        assertTrue("Exception message should mention warm parameters", exception.getMessage().contains("warm"));
            shardPath,
            remoteDirectory,
    private TieredDataFormatAwareStoreDirectoryFactory factory;
            threadPool
        Index index = new Index("test-index", "test-uuid");
import java.util.Map;
            true,
            shardPath,
        assertNotNull("Factory should return a non-null directory even with no format plugins", result);
        org.opensearch.common.blobstore.BlobContainer mockBlobContainer = mock(org.opensearch.common.blobstore.BlobContainer.class);
        assertTrue("Delegate should be TieredSubdirectoryAwareDirectory", delegate instanceof TieredSubdirectoryAwareDirectory);
import org.opensearch.threadpool.ThreadPool;
    private ThreadPool threadPool;
        when(remoteDataDir.getBlobContainer()).thenReturn(mockBlobContainer);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            localDirectoryFactory,
/**
     * Sets up the factory and mock dependencies before each test.
     */
        );
            remoteDirectory,
import org.apache.lucene.store.Directory;
        Directory delegate = ((FilterDirectory) result).getDelegate();
        RemoteDirectory remoteMetadataDir = mock(RemoteDirectory.class);
    private ShardPath shardPath;
import java.util.HashMap;
        assertNotNull("Factory should return a non-null directory", result);

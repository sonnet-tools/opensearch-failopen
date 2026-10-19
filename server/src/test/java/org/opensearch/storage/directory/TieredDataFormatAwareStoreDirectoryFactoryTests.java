        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            () -> factory.newDataFormatAwareStoreDirectory(indexSettings, shardId, shardPath, localDirectoryFactory, Map.of())  
            localDirectoryFactory,
            null
        int subdirAwareCount = 0;  
import org.opensearch.index.store.RemoteDirectory;  
        Directory delegate = ((FilterDirectory) result).getDelegate();  
import java.io.IOException;
        ThreadPool tp = mock(ThreadPool.class);
import org.opensearch.index.store.remote.filecache.FileCache;  
        Path shardDataPath = tempDir.resolve("data").resolve("test-uuid").resolve("0");
        RemoteDirectory remoteDataDir = mock(RemoteDirectory.class);  
     * Sets up the factory and mock dependencies before each test.  
     * DataFormatAwareStoreDirectory wrapping TieredSubdirectoryAwareDirectory.
                subdirAwareCount++;
            UnsupportedOperationException.class,
        localDirectoryFactory = mock(IndexStorePlugin.DirectoryFactory.class);
        Path shardStatePath = tempDir.resolve("state").resolve("test-uuid").resolve("0");  
            Map.of(),
            }
    }  
            registry,  
     * RemoteSegmentStoreDirectory is a final class and cannot be mocked.  
package org.opensearch.storage.directory;
import org.opensearch.core.index.shard.ShardId;
    private ShardId shardId;
    private FileCache fileCache;
            threadPool  
            java.util.Map.of(),
    }
            shardPath,
    public void testEmptyFormatDirectoriesWhenNoPluginProvides() throws IOException {  
        );
            return settings;  
        assertTrue("Delegate should be TieredSubdirectoryAwareDirectory", delegate instanceof TieredSubdirectoryAwareDirectory);
            Map.of(),
        Path tempDir = createTempDir();
            threadPool  
        threadPool = mock(ThreadPool.class);
            shardId,
    public void testHotPathThrowsUnsupportedOperation() {  
        );
            localDirectoryFactory,
            remoteDirectory,  
        assertTrue("Delegate should still be TieredSubdirectoryAwareDirectory", delegate instanceof TieredSubdirectoryAwareDirectory);
            org.opensearch.index.store.lockmanager.RemoteStoreLockManager.class  
    /**  
        org.opensearch.index.store.lockmanager.RemoteStoreLockManager lockManager = mock(
import org.opensearch.Version;
    private RemoteSegmentStoreDirectory remoteDirectory;
}
        RemoteDirectory remoteMetadataDir = mock(RemoteDirectory.class);
import org.opensearch.cluster.metadata.IndexMetadata;
import java.nio.file.Path;  
            remoteDirectory,  
            null
 *
import org.opensearch.core.index.Index;
 *
            indexSettings,
            current = ((FilterDirectory) current).getDelegate();  
    /**
     */
        };
 * and rejects the hot path (5-param method).
        );
            org.opensearch.repositories.NativeStoreRepository.EMPTY,
import java.util.HashMap;
    /**
    @Before
        UnsupportedOperationException exception = expectThrows(
            org.opensearch.repositories.NativeStoreRepository.EMPTY,
     */
        java.nio.file.Files.createDirectories(shardDataPath);
import org.apache.lucene.store.FSDirectory;
            if (current instanceof SubdirectoryAwareDirectory) {  
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
            when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);
 * this file be licensed under the Apache-2.0 license or a
        }
        DataFormatAwareStoreDirectory result = factory.newDataFormatAwareStoreDirectory(  
     */
    /**
            localDirectoryFactory,
        Supplier<TieredStoragePrefetchSettings> prefetchSupplier = () -> {
    public void setup() throws IOException {  
            remoteDirectory,
 */  
    }
    private TieredDataFormatAwareStoreDirectoryFactory factory;
import org.opensearch.test.OpenSearchTestCase;
        assertNotNull("Factory should return a non-null directory even with no format plugins", result);  
import static org.mockito.Mockito.mock;  
        when(remoteDataDir.getBlobContainer()).thenReturn(mockBlobContainer);  
import org.junit.Before;  
        org.opensearch.common.blobstore.BlobContainer mockBlobContainer = mock(org.opensearch.common.blobstore.BlobContainer.class);
    public void testCreatesCorrectDirectoryStack() throws IOException {  
        while (current instanceof FilterDirectory) {
    private ThreadPool threadPool;  
     * The factory should NOT double-wrap with SubdirectoryAwareDirectory.
    private IndexStorePlugin.DirectoryFactory localDirectoryFactory;  
            java.util.Map.of(),
            .build();  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        when(localDirectoryFactory.newDirectory(any(), any())).thenReturn(fsDir);  
 * The OpenSearch Contributors require contributions made to  
    public void testNoDoubleSubdirectoryAwareDirectoryWrapping() throws IOException {  
public class TieredDataFormatAwareStoreDirectoryFactoryTests extends OpenSearchTestCase {  
        FSDirectory fsDir = FSDirectory.open(indexPath);
        when(mockBlobContainer.path()).thenReturn(new org.opensearch.common.blobstore.BlobPath().add("test-base-path"));
        indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        result.close();  
            fileCache,
import static org.mockito.Mockito.when;
        assertNotNull("Factory should return a non-null directory", result);  
import org.opensearch.index.shard.ShardPath;
     */
 * Tests for {@link TieredDataFormatAwareStoreDirectoryFactory}.
        // ShardPath requires: dataPath ends with <index-uuid>/<shard-id>
 */
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        assertTrue("Exception message should mention warm parameters", exception.getMessage().contains("warm"));  
        // Verify the stack is still correct
            fileCache,
            shardPath,  
        );
            Map.of(),
            shardPath,  
    private ShardPath shardPath;
        assertEquals("SubdirectoryAwareDirectory should appear exactly once in the chain", 1, subdirAwareCount);  
        Directory innerDelegate = ((FilterDirectory) delegate).getDelegate();
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
/**  
        result.close();
        Directory current = result;
            shardId,
            indexSettings,
            true,  
            shardPath,  
        );
            remoteDirectory,
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;  
        );
            TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
            shardId,
            true,  
        java.nio.file.Files.createDirectories(shardStatePath);  
     * Tests that when DataFormatRegistry returns empty tiered directories,  
            registry,  
        Directory delegate = ((FilterDirectory) result).getDelegate();
            remoteDirectory,
        assertTrue("Outermost directory should be DataFormatAwareStoreDirectory", result instanceof DataFormatAwareStoreDirectory);
import static org.mockito.ArgumentMatchers.any;
 * compatible open source license.
        result.close();
     */
            fileCache,
        Settings settings = Settings.builder()
import java.util.function.Supplier;  
import org.opensearch.index.store.SubdirectoryAwareDirectory;
 * <p>Verifies the factory creates the correct directory stack for warm+format indices  
/*  
        // The delegate of DataFormatAwareStoreDirectory should be TieredSubdirectoryAwareDirectory  
            shardPath,
import java.util.Map;
        Index index = new Index("test-index", "test-uuid");
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            true,  
        factory = new TieredDataFormatAwareStoreDirectoryFactory(prefetchSupplier);
            threadPool  
import org.opensearch.plugins.IndexStorePlugin;
        remoteDirectory = createRealRemoteSegmentStoreDirectory(shardId);
    private RemoteSegmentStoreDirectory createRealRemoteSegmentStoreDirectory(ShardId shardId) throws IOException {
        java.nio.file.Files.createDirectories(indexPath);
            indexSettings,
        return new RemoteSegmentStoreDirectory(remoteDataDir, remoteMetadataDir, lockManager, tp, shardId, new HashMap<>());
            org.opensearch.repositories.NativeStoreRepository.EMPTY,
     * Tests that calling the 5-param (hot path) method throws UnsupportedOperationException.
        DataFormatAwareStoreDirectory result = factory.newDataFormatAwareStoreDirectory(  
     * Creates a real RemoteSegmentStoreDirectory with mocked inner directories.
     */
    }  
import org.apache.lucene.store.FilterDirectory;  
    /**
        assertTrue("Inner delegate should be SubdirectoryAwareDirectory", innerDelegate instanceof SubdirectoryAwareDirectory);  
    private IndexSettings indexSettings;  
        shardId = new ShardId(index, 0);  
            when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);  
        shardPath = new ShardPath(false, shardDataPath, shardStatePath, shardId);  
import org.apache.lucene.store.Directory;
            registry,  
            remoteDirectory,  
        );
            shardPath,
     * Tests that SubdirectoryAwareDirectory appears only once in the directory chain.  
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
            java.util.Map.of(),
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
import org.opensearch.threadpool.ThreadPool;
        Path indexPath = shardDataPath.resolve("index");
        // The delegate of TieredSubdirectoryAwareDirectory should be SubdirectoryAwareDirectory
     * Tests that the warm-aware factory method creates the correct directory stack:  
        );
        DataFormatAwareStoreDirectory result = factory.newDataFormatAwareStoreDirectory(  
    /**
    }
     * the factory still creates a valid directory stack with no format directories.
import org.opensearch.common.settings.Settings;  
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
    }  
import org.opensearch.index.IndexSettings;  
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(10_000_000, 1);  
            null

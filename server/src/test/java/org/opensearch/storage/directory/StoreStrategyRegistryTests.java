            shardPath,
        registry.close();
        );
            NativeStoreRepository.EMPTY,
    public void testGetFormatStoreHandlesReturnsLiveHandles() throws IOException {
    // ═══════════════════════════════════════════════════════════════
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        @SuppressWarnings("unchecked")
            shardPath,
import org.opensearch.index.engine.dataformat.StoreStrategy;
        BlobContainer parquetBlobContainer = mock(BlobContainer.class);
        registry.close();
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        ThreadPool tp = mock(ThreadPool.class);
import static org.mockito.Mockito.verify;
            NativeStoreRepository.EMPTY,
import org.opensearch.index.store.RemoteDirectory;
        // Create a real RemoteSegmentStoreDirectory and inject a parquet entry
            true,
    private ShardPath shardPath;
import org.opensearch.index.engine.dataformat.DataFormat;
            NativeStoreRepository.EMPTY,
            true,
        org.mockito.ArgumentCaptor<Map<String, DataFormatStoreHandler.FileEntry>> captor = org.mockito.ArgumentCaptor.forClass(Map.class);
        return new RemoteSegmentStoreDirectory(remoteDataDir, remoteMetadataDir, lockManager, tp, shardPath.getShardId(), new HashMap<>());
                return 2;
            null
            true,
            null
    // ═══════════════════════════════════════════════════════════════
        registry.close();
import org.opensearch.repositories.NativeStoreRepository;
        DataFormatStoreHandler.FileEntry entry = seeded.get(expectedKey);
    public void testMatchForReturnsNullForNull() throws IOException {
            Map.of(PARQUET_FORMAT, strategy),
        Map<DataFormat, NativeStoreHandle> handles1 = registry.getFormatStoreHandles();
            public Optional<DataFormatStoreHandlerFactory> storeHandler() {
        // Create a RemoteSegmentStoreDirectory with a FormatBlobRouter that routes
            remoteDir,
        }
        assertTrue(dispatched);
    }
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
import org.opensearch.common.blobstore.BlobStore;
        public Set<FieldTypeCapabilities> supportedFields() {
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
            () -> StoreStrategyRegistry.open(shardPath, true, NativeStoreRepository.EMPTY, strategies, remoteDir, null)
    // Seed key tests
            public String name() {
            remoteDir,
            shardPath,
            }
        assertSame("cacheRegistry must be forwarded to factory unchanged", mockRegistry, capturedRegistry[0]);
        BlobPath basePath = new BlobPath().add("base-path");
import org.opensearch.plugins.BlockCacheRegistry;
            + separator
        verify(successHandler).close();
        DataFormatStoreHandler.FileEntry entry = seeded.get(expectedKey);
            null
        boolean dispatched = registry.onUploaded("_0.cfe", "test-base-path/", "blob_key", 512L);
            shardPath,
    public void testOpenCreatesHandlerFromFactory() throws IOException {
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        assertTrue("Closed handles should not be returned", handles.isEmpty());
            true,
    }
            shardPath,
        Map<DataFormat, NativeStoreHandle> handles = StoreStrategyRegistry.EMPTY.getFormatStoreHandles();
                    capturedRegistry[0] = cacheRegistry;
    // getFormatStoreHandles() tests
            entry.path().contains("parquet")
        Path shardDataPath = tempDir.resolve("data").resolve("test-uuid").resolve("0");
        verify(handler).close();
        );
        // remotePath: basePath + blobKey (basePath already includes format subdirectory)
            public long priority() {
        // The UploadedSegmentMetadata constructor is package-private, so we use fromString
        assertFalse("Seed map should not be empty", seeded.isEmpty());
        return new StoreStrategy() {
        when(baseBlobContainer.path()).thenReturn(basePath);
        // The successfully created handler should have been closed during cleanup
    // ═══════════════════════════════════════════════════════════════
        RemoteDirectory remoteDataDir = mock(RemoteDirectory.class);
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;
    private RemoteSegmentStoreDirectory createRealRemoteDir() throws IOException {
        Files.createDirectories(shardStatePath);
     * metadata serialization pipeline just to test seeding behaviour.
    public void testCloseClosesAllHandlers() throws IOException {
        RemoteSegmentStoreDirectory remoteDir = createRemoteDirWithFormatRouter();
        };
            return "parquet";
 *
 * this file be licensed under the Apache-2.0 license or a
            true,
            + org.apache.lucene.util.Version.LATEST.major;
    private static final DataFormat PARQUET_FORMAT = new DataFormat() {
    // ═══════════════════════════════════════════════════════════════
    }
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
    public void testSeedUsesFormatSpecificBasePath() throws Exception {
            RuntimeException.class,
        // Format: originalFilename::uploadedFilename::checksum::length::writtenByMajor
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
        boolean dispatched = registry.onRemoved("_0.cfe");
        super.setUp();
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
     * Verifies that the BlockCacheRegistry passed to open() is forwarded verbatim
        ThreadPool tp = mock(ThreadPool.class);
    }
        verify(handler).seed(captor.capture());
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(PARQUET_FORMAT, match.format());
            Map.of(PARQUET_FORMAT, strategy),
            }
            NativeStoreRepository.EMPTY,
            shardPath,
            true,
    private RemoteSegmentStoreDirectory createRemoteDirWithFormatRouter() throws IOException {
        );
        registry.close();
            public Set<FieldTypeCapabilities> supportedFields() {
        Path tempDir = createTempDir();
            true,
    public void testOnUploadedReturnsFalseForUnownedFile() throws IOException {
        String expectedKey = shardPath.getDataPath().resolve("parquet/_0.parquet").toString();
    public void testOpenFactoryThrowsClosesCreatedHandlers() throws IOException {
            null
        StoreStrategy strategy1 = createTestStrategy(successHandler);
        Index index = new Index("test-index", "test-uuid");
            NativeStoreRepository.EMPTY,
        StoreStrategy strategy = createTestStrategy(handler);
     * internal map via reflection. This avoids the need to set up the full
        };
                return Optional.of((shardId, isWarm, repo, cacheRegistry) -> { throw new RuntimeException("factory boom"); });
import org.opensearch.common.blobstore.BlobPath;
            shardPath,
        assertTrue(dispatched);
    }
            true,
        NativeStoreHandle liveHandle = new NativeStoreHandle(42L, ptr -> {});
            true,
import java.util.Collections;
            null
    };
        StoreStrategy strategy = createTestStrategy(handler);
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        );
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        assertSame(strategy, match.strategy());
    }
    // matchFor() tests
        registry.close();
        Map<DataFormat, StoreStrategy> strategies = new java.util.LinkedHashMap<>();
            @Override
        Map<String, DataFormatStoreHandler.FileEntry> seeded = captor.getValue();
            true,
        public long priority() {
        DataFormatStoreHandlerFactory factory = (shardId, isWarm, repo, cacheRegistry) -> handler;
        };
            remoteDir,
            Map.of(PARQUET_FORMAT, strategy),
        }
    // ═══════════════════════════════════════════════════════════════
        );
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
    }
            remoteDir,
            true,
import java.nio.file.Path;
            public Optional<DataFormatStoreHandlerFactory> storeHandler() {
        };
        registry.close();
                return "format1";
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        @Override
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
        );
        public String name() {
        @SuppressWarnings("unchecked")
        assertEquals(DataFormatStoreHandler.REMOTE, entry.location());
            + separator
        closedHandle.close(); // close it before returning
            remoteDir,
    public void testOpenForwardsCacheRegistryToFactory() throws IOException {
    public void setUp() throws Exception {
            + "1024"
import org.opensearch.core.index.shard.ShardId;
            }
import java.nio.file.Files;
        // Create a FormatBlobRouter that routes "parquet" to "base-path/parquet/"
        registry.close();
            public Set<FieldTypeCapabilities> supportedFields() {
            shardPath,
     * to the factory's create() call. This is the contract that allows format
        injectUploadedSegment(remoteDir, "parquet/_0.parquet", "parquet_blob_key");
        StoreStrategy strategy = createTestStrategy(handler);
import static org.mockito.Mockito.mock;
        assertSame("Same handle should be returned on multiple calls", handles1.get(PARQUET_FORMAT), handles2.get(PARQUET_FORMAT));
        Map<String, DataFormatStoreHandler.FileEntry> seeded = captor.getValue();
        verify(handler, never()).onRemoved(anyString());
    }
        StoreStrategy strategy = createTestStrategy(handler);
        RemoteDirectory remoteDataDir = mock(RemoteDirectory.class);
            NativeStoreRepository.EMPTY,
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
    @Override
            public Optional<DataFormatStoreHandlerFactory> storeHandler() {
        map.put(localFilename, metadata);
            }
    public void testOnRemovedDispatchesToHandler() throws IOException {
        expectThrows(
import org.opensearch.test.OpenSearchTestCase;
        registry.close();
        StoreStrategy strategy = createTestStrategy(handler);
            }
    // Helpers
     */
        );
    // ═══════════════════════════════════════════════════════════════
            "Seeded path should use format-specific base path containing 'parquet': " + entry.path(),
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
            @Override
        when(remoteDataDir.getFormatBlobRouter()).thenReturn(Optional.of(router));
            NativeStoreRepository.EMPTY,
import java.util.HashMap;
            Map.of(PARQUET_FORMAT, strategy),
        // First format succeeds
            remoteDir,
        BlobContainer baseBlobContainer = mock(BlobContainer.class);
        // Second format throws during factory.create()
            NativeStoreRepository.EMPTY,
        when(parquetBlobContainer.path()).thenReturn(parquetPath);
    // close() tests
        Map<DataFormat, NativeStoreHandle> handles = registry.getFormatStoreHandles();
 */
        assertNotNull(match);
        boolean dispatched = registry.onUploaded("parquet/_0.parquet", "test-base-path/parquet/", "new_blob_key", 1024L);
        StoreStrategy strategy = new StoreStrategy() {
import java.util.Map;
    public void testGetFormatStoreHandlesSkipsClosedHandles() throws IOException {
        );
    public void testMatchForReturnsNullForLuceneFile() throws IOException {
        );
    public void testOnRemovedReturnsFalseForUnownedFile() throws IOException {
     * handlers to resolve their preferred cache by name.
            true,
            remoteDir,
     * Injects an uploaded segment entry into the RemoteSegmentStoreDirectory's
        Field field = RemoteSegmentStoreDirectory.class.getDeclaredField("segmentsUploadedToRemoteStore");
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
            Map.of(PARQUET_FORMAT, strategy),
            shardPath,
            public long priority() {
        String metadataStr = localFilename
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
                });
 * Unit tests for {@link StoreStrategyRegistry}.
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            @Override
        StoreStrategy strategy = createTestStrategy(handler);
        strategies.put(format2, strategy2);
import static org.mockito.ArgumentMatchers.anyString;
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(shardPath, true, NativeStoreRepository.EMPTY, null, remoteDir, null);
import org.opensearch.core.index.Index;
            shardPath,
 * The OpenSearch Contributors require contributions made to
    private StoreStrategy createTestStrategy(DataFormatStoreHandler handler) {
            }
    }
        verify(handler).seed(captor.capture());
            + separator
        @SuppressWarnings("unchecked")
    }
                return Set.of();
            return Set.of();
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
            remoteDir,
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        registry.close();
        StoreStrategy strategy = createTestStrategy(handler);
        return new RemoteSegmentStoreDirectory(remoteDataDir, remoteMetadataDir, lockManager, tp, shardPath.getShardId(), new HashMap<>());
        liveHandle.close();
        when(remoteDataDir.getBlobContainer()).thenReturn(mockBlobContainer);
        assertFalse("Seed map should not be empty", seeded.isEmpty());
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
import static org.mockito.ArgumentMatchers.eq;
        BlobStore blobStore = mock(BlobStore.class);
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            NativeStoreRepository.EMPTY,
            @Override
            + uploadedFilename
        // Capture what cacheRegistry the factory receives.
    public void testSeedUsesAbsolutePathKeys() throws Exception {
            Map.of(PARQUET_FORMAT, strategy),
        when(handler.getFormatStoreHandle()).thenReturn(liveHandle);
        );
        // picks it up during open().
        boolean dispatched = registry.onRemoved("parquet/_0.parquet");
            null
            Map.of(PARQUET_FORMAT, strategy),
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
        Map<DataFormat, NativeStoreHandle> handles = registry.getFormatStoreHandles();
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            createRealRemoteDir(),
        registry.close();
        assertEquals(DataFormatStoreHandler.REMOTE, entry.location());
            shardPath,
        RemoteDirectory remoteMetadataDir = mock(RemoteDirectory.class);
    }
    /**
            true,
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
        StoreStrategy strategy2 = new StoreStrategy() {
        assertTrue("Seed key should be absolute path: " + expectedKey, seeded.containsKey(expectedKey));
            null
            remoteDir,
    // ═══════════════════════════════════════════════════════════════
            + separator
        assertTrue(
            true,
                    return handler;
        Map<DataFormat, NativeStoreHandle> handles2 = registry.getFormatStoreHandles();
        registry.close();
            Collections.emptyMap(),
        Files.createDirectories(shardDataPath.resolve("index"));
        StoreStrategy strategy = createTestStrategy(handler);
        BlobPath parquetPath = basePath.parent().add("parquet");
        }
import java.util.Set;
        @Override
        org.mockito.ArgumentCaptor<Map<String, DataFormatStoreHandler.FileEntry>> captor = org.mockito.ArgumentCaptor.forClass(Map.class);
        StoreStrategy strategy = createTestStrategy(handler);
        RemoteStoreLockManager lockManager = mock(RemoteStoreLockManager.class);
            Map.of(PARQUET_FORMAT, strategy),
        shardPath = new ShardPath(false, shardDataPath, shardStatePath, shardId);
        when(mockBlobContainer.path()).thenReturn(new BlobPath().add("test-base-path").add("parquet"));
            null
package org.opensearch.storage.directory;
        RemoteStoreLockManager lockManager = mock(RemoteStoreLockManager.class);
        StoreStrategy strategy = createTestStrategy(handler);
        DataFormatStoreHandler successHandler = mock(DataFormatStoreHandler.class);
import org.opensearch.common.blobstore.BlobContainer;
                return Set.of();
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
    }
    }
import java.io.IOException;
            Map.of(PARQUET_FORMAT, strategy),
                return Optional.of((shardId, isWarm, repo, cacheRegistry) -> {
    }
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
        assertNull(registry.matchFor("_0.cfe"));
            Map.of(PARQUET_FORMAT, strategy),
    @SuppressForbidden(reason = "test needs reflection to inject parquet metadata without full upload pipeline")
        String expectedKey = shardPath.getDataPath().resolve("parquet/_0.parquet").toString();
            remoteDir,
            Map.of(PARQUET_FORMAT, strategy),
    }
    // open() tests
            eq("test-base-path/parquet/new_blob_key"),
            org.mockito.ArgumentMatchers.contains("parquet/_0.parquet"),
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
                return "format2";
        // Capture the seed call argument
            @Override
    }
    }
            remoteDir,
        assertEquals("test-base-path/parquet/parquet_blob_key", entry.path());
        NativeStoreHandle closedHandle = new NativeStoreHandle(99L, ptr -> {});
    // ═══════════════════════════════════════════════════════════════
    // onUploaded() tests
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
    /**
            true,
        registry.close();
        );
            null
public class StoreStrategyRegistryTests extends OpenSearchTestCase {
            remoteDir,
            @Override
            remoteDir,
            + "checksum123"
        assertTrue(handles.isEmpty());
        assertNotSame(StoreStrategyRegistry.EMPTY, registry);
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
        Map<String, UploadedSegmentMetadata> map = (Map<String, UploadedSegmentMetadata>) field.get(remoteDir);
        assertTrue("Seed key should be absolute path", seeded.containsKey(expectedKey));
        );
    public void testMatchForReturnsMatchForFormatFile() throws IOException {
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
            mockRegistry
        StoreStrategyRegistry.Match match = registry.matchFor("parquet/_0.parquet");
        assertEquals(1, handles.size());
import org.opensearch.index.engine.dataformat.DataFormatStoreHandler;
    // ═══════════════════════════════════════════════════════════════
/*
            shardPath,
        BlockCacheRegistry mockRegistry = mock(BlockCacheRegistry.class);
        strategies.put(format1, strategy1);
        );
            Map.of(PARQUET_FORMAT, strategy),
    }
        assertSame(StoreStrategyRegistry.EMPTY, registry);
                return Optional.of(factory);
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        );
            Map.of(PARQUET_FORMAT, strategy),
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        BlockCacheRegistry[] capturedRegistry = { null };
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            eq(1024L)
    private static void injectUploadedSegment(RemoteSegmentStoreDirectory remoteDir, String localFilename, String uploadedFilename)
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
import org.opensearch.threadpool.ThreadPool;
        Path shardStatePath = tempDir.resolve("state").resolve("test-uuid").resolve("0");
        };
            }
            NativeStoreRepository.EMPTY,
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
            remoteDir,
import org.opensearch.index.store.remote.FormatBlobRouter;
                return 1;
import java.util.Optional;
            }
        assertNull(registry.matchFor(null));
 */
            }
        throws Exception {
        when(blobStore.blobContainer(parquetPath)).thenReturn(parquetBlobContainer);
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
import org.opensearch.common.SuppressForbidden;
            NativeStoreRepository.EMPTY,
        );
import org.opensearch.plugins.NativeStoreHandle;
        assertFalse(dispatched);
    }
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        );
            return 2;
        String separator = "::";
     */
        // The FormatBlobRouter routes "parquet" to "base-path/parquet/" so getRemoteBasePath("parquet")
        // returns "base-path/parquet/". The default remotePath appends format + "/" + blobKey.
            NativeStoreRepository.EMPTY,
        );
        @Override
        StoreStrategy strategy = createTestStrategy(handler);
 * compatible open source license.
        RemoteDirectory remoteMetadataDir = mock(RemoteDirectory.class);
import org.opensearch.index.shard.ShardPath;
}
        verify(handler).onRemoved(org.mockito.ArgumentMatchers.contains("parquet/_0.parquet"));
        StoreStrategy strategy = createTestStrategy(handler);
    }
            null
            shardPath,
            NativeStoreRepository.EMPTY,
        verify(handler).onUploaded(
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString(metadataStr);
            @Override
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        registry.close();
            Map.of(PARQUET_FORMAT, strategy),
    public void testGetFormatStoreHandlesEmptyWhenNoHandlers() {
    }
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
        when(blobStore.blobContainer(basePath)).thenReturn(baseBlobContainer);
            NativeStoreRepository.EMPTY,
        );
    }
        // "parquet" to a different sub-path than the base path.
        registry.close();
            shardPath,
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
import static org.mockito.Mockito.never;
    // ═══════════════════════════════════════════════════════════════
        assertSame(liveHandle, handles.get(PARQUET_FORMAT));
        registry.close();
import static org.mockito.Mockito.when;
        // into its uploaded segments map via reflection so that seedFromRemoteMetadata
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
            null
            shardPath,
            null
        DataFormat format1 = new DataFormat() {
    // onRemoved() tests
        when(handler.getFormatStoreHandle()).thenReturn(closedHandle);
        );
            true,
            null
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
    public void testGetFormatStoreHandlesReturnsSameHandleOnMultipleCalls() throws IOException {
        NativeStoreHandle liveHandle = new NativeStoreHandle(77L, ptr -> {});
        BlobContainer mockBlobContainer = mock(BlobContainer.class);
import org.opensearch.index.engine.dataformat.DataFormatStoreHandlerFactory;
            @Override
        when(remoteDataDir.getBlobContainer()).thenReturn(baseBlobContainer);
            public String name() {
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        ShardId shardId = new ShardId(index, 0);
        assertTrue(registry.hasStoreHandlers());
        assertFalse(dispatched);
            NativeStoreRepository.EMPTY,
        // Use a LinkedHashMap to guarantee iteration order: format1 first, format2 second
            Map.of(PARQUET_FORMAT, strategy),
        StoreStrategy strategy = createTestStrategy(handler);
        // The key should be the absolute path: shardPath.getDataPath() + relative file
        injectUploadedSegment(remoteDir, "parquet/_0.parquet", "parquet_blob_key");
    public void testOnUploadedDispatchesToHandler() throws IOException {
        verify(handler, never()).onUploaded(anyString(), anyString(), org.mockito.ArgumentMatchers.anyLong());
        when(handler.getFormatStoreHandle()).thenReturn(liveHandle);
    }
import java.lang.reflect.Field;
/**
        assertSame(StoreStrategyRegistry.EMPTY, registry);
    }
    public void testOpenWithEmptyStrategiesReturnsEmpty() throws IOException {
            shardPath,
        DataFormat format2 = new DataFormat() {
        field.setAccessible(true);
            NativeStoreRepository.EMPTY,
            null
            @Override
            remoteDir,
    public void testOpenWithNullStrategiesReturnsEmpty() throws IOException {
    // ═══════════════════════════════════════════════════════════════
        StoreStrategy strategy = createTestStrategy(handler);
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
    // ═══════════════════════════════════════════════════════════════
        liveHandle.close();
            null

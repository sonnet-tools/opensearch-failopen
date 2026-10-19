        when(parquetBlobContainer.path()).thenReturn(parquetPath);  
        DataFormat format2 = new DataFormat() {
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
import org.opensearch.index.engine.dataformat.DataFormatStoreHandlerFactory;  
            NativeStoreRepository.EMPTY,
        registry.close();
                    capturedRegistry[0] = cacheRegistry;  
            remoteDir,
import static org.mockito.ArgumentMatchers.eq;
 *
    public void testOpenWithNullStrategiesReturnsEmpty() throws IOException {
        @Override  
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        assertEquals(DataFormatStoreHandler.REMOTE, entry.location());
    }
        assertTrue(handles.isEmpty());
        verify(handler, never()).onRemoved(anyString());
        registry.close();  
            true,
import java.lang.reflect.Field;
        registry.close();
            Map.of(PARQUET_FORMAT, strategy),
            shardPath,
        registry.close();
        registry.close();
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();  
        when(blobStore.blobContainer(parquetPath)).thenReturn(parquetBlobContainer);
        );
        verify(handler).close();  
    }  
        assertTrue("Seed key should be absolute path", seeded.containsKey(expectedKey));
        @Override
        Path tempDir = createTempDir();
                });
        StoreStrategy strategy2 = new StoreStrategy() {  
        verify(handler).onRemoved(org.mockito.ArgumentMatchers.contains("parquet/_0.parquet"));  
        assertSame(strategy, match.strategy());
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString(metadataStr);  
            remoteDir,
    // ═══════════════════════════════════════════════════════════════
        registry.close();
            return 2;  
    // ═══════════════════════════════════════════════════════════════  
            RuntimeException.class,  
            null
            Map.of(PARQUET_FORMAT, strategy),
            Map.of(PARQUET_FORMAT, strategy),
        StoreStrategy strategy = createTestStrategy(handler);  
        );
        DataFormat format1 = new DataFormat() {
import org.opensearch.common.blobstore.BlobContainer;
            null
        shardPath = new ShardPath(false, shardDataPath, shardStatePath, shardId);  
            null
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();  
        BlobPath parquetPath = basePath.parent().add("parquet");
            shardPath,  
        );
            shardPath,
    private ShardPath shardPath;  
    public void testOnRemovedReturnsFalseForUnownedFile() throws IOException {
            }
        assertSame("cacheRegistry must be forwarded to factory unchanged", mockRegistry, capturedRegistry[0]);  
    public void testMatchForReturnsNullForLuceneFile() throws IOException {  
        registry.close();  
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);  
    // open() tests
            @Override  
    // ═══════════════════════════════════════════════════════════════  
        BlockCacheRegistry[] capturedRegistry = { null };
    // ═══════════════════════════════════════════════════════════════
        registry.close();
import org.opensearch.index.store.remote.FormatBlobRouter;
        StoreStrategy strategy = createTestStrategy(handler);  
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        public String name() {  
        }
        RemoteDirectory remoteDataDir = mock(RemoteDirectory.class);
            true,  
    }  
        assertNull(registry.matchFor(null));
    // ═══════════════════════════════════════════════════════════════
    }
            remoteDir,
import org.opensearch.common.blobstore.BlobStore;
            remoteDir,
            }  
import static org.mockito.Mockito.mock;  
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            @Override  
        return new RemoteSegmentStoreDirectory(remoteDataDir, remoteMetadataDir, lockManager, tp, shardPath.getShardId(), new HashMap<>());  
        };
        when(mockBlobContainer.path()).thenReturn(new BlobPath().add("test-base-path").add("parquet"));
        );  
            null  
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);  
            NativeStoreRepository.EMPTY,  
            eq("test-base-path/parquet/new_blob_key"),
    }  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
        registry.close();  
        // The UploadedSegmentMetadata constructor is package-private, so we use fromString  
    // matchFor() tests  
    }
            Collections.emptyMap(),
            shardPath,  
            NativeStoreRepository.EMPTY,  
import org.opensearch.index.shard.ShardPath;  
        boolean dispatched = registry.onUploaded("parquet/_0.parquet", "test-base-path/parquet/", "new_blob_key", 1024L);  
            true,  
            null  
    }
            null  
            + separator
        verify(handler, never()).onUploaded(anyString(), anyString(), org.mockito.ArgumentMatchers.anyLong());  
    // ═══════════════════════════════════════════════════════════════
            () -> StoreStrategyRegistry.open(shardPath, true, NativeStoreRepository.EMPTY, strategies, remoteDir, null)
            null
        // Capture what cacheRegistry the factory receives.  
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();  
        );  
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();  
            }  
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);  
        registry.close();  
        Path shardDataPath = tempDir.resolve("data").resolve("test-uuid").resolve("0");
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
            NativeStoreRepository.EMPTY,
        StoreStrategy strategy = createTestStrategy(handler);
    // ═══════════════════════════════════════════════════════════════
import static org.mockito.Mockito.never;
    // onRemoved() tests
        assertEquals(1, handles.size());
            shardPath,  
            true,  
        registry.close();  
    // ═══════════════════════════════════════════════════════════════  
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;  
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
        // First format succeeds
import org.opensearch.index.engine.dataformat.DataFormat;
    /**  
        @Override
            NativeStoreRepository.EMPTY,  
        // returns "base-path/parquet/". The default remotePath appends format + "/" + blobKey.  
        );
        NativeStoreHandle liveHandle = new NativeStoreHandle(77L, ptr -> {});
        strategies.put(format2, strategy2);  
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
    // ═══════════════════════════════════════════════════════════════  
        when(remoteDataDir.getFormatBlobRouter()).thenReturn(Optional.of(router));
        RemoteStoreLockManager lockManager = mock(RemoteStoreLockManager.class);
            Map.of(PARQUET_FORMAT, strategy),  
            true,
     * Injects an uploaded segment entry into the RemoteSegmentStoreDirectory's
        assertTrue("Seed key should be absolute path: " + expectedKey, seeded.containsKey(expectedKey));  
            NativeStoreRepository.EMPTY,
        String separator = "::";
    }
        injectUploadedSegment(remoteDir, "parquet/_0.parquet", "parquet_blob_key");  
     * handlers to resolve their preferred cache by name.  
        expectThrows(
    public void testOpenForwardsCacheRegistryToFactory() throws IOException {
        // Create a real RemoteSegmentStoreDirectory and inject a parquet entry
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
        org.mockito.ArgumentCaptor<Map<String, DataFormatStoreHandler.FileEntry>> captor = org.mockito.ArgumentCaptor.forClass(Map.class);
            NativeStoreRepository.EMPTY,
        map.put(localFilename, metadata);
    @Override
        StoreStrategy strategy = createTestStrategy(handler);
            remoteDir,
        @SuppressWarnings("unchecked")  
    public void testSeedUsesFormatSpecificBasePath() throws Exception {  
        Map<DataFormat, NativeStoreHandle> handles1 = registry.getFormatStoreHandles();
import java.nio.file.Files;
        );
            org.mockito.ArgumentMatchers.contains("parquet/_0.parquet"),
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
        BlockCacheRegistry mockRegistry = mock(BlockCacheRegistry.class);  
            NativeStoreRepository.EMPTY,
    private StoreStrategy createTestStrategy(DataFormatStoreHandler handler) {
        );
        Field field = RemoteSegmentStoreDirectory.class.getDeclaredField("segmentsUploadedToRemoteStore");
                return Set.of();
    public void testOnUploadedReturnsFalseForUnownedFile() throws IOException {
            }
        when(remoteDataDir.getBlobContainer()).thenReturn(baseBlobContainer);
    // ═══════════════════════════════════════════════════════════════
        // picks it up during open().
            NativeStoreRepository.EMPTY,
        assertTrue(dispatched);
    public void testOpenFactoryThrowsClosesCreatedHandlers() throws IOException {
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            + "1024"  
            remoteDir,
        throws Exception {
    }
import org.opensearch.common.blobstore.BlobPath;  
        when(blobStore.blobContainer(basePath)).thenReturn(baseBlobContainer);
import org.opensearch.core.index.shard.ShardId;  
        assertTrue(registry.hasStoreHandlers());
            @Override
        ShardId shardId = new ShardId(index, 0);
        StoreStrategyRegistry.Match match = registry.matchFor("parquet/_0.parquet");
        assertTrue(
    }
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
        // Use a LinkedHashMap to guarantee iteration order: format1 first, format2 second  
        };  
    public void testGetFormatStoreHandlesSkipsClosedHandles() throws IOException {
        DataFormatStoreHandlerFactory factory = (shardId, isWarm, repo, cacheRegistry) -> handler;  
 * this file be licensed under the Apache-2.0 license or a
                    return handler;
        strategies.put(format1, strategy1);
        );
        // Create a RemoteSegmentStoreDirectory with a FormatBlobRouter that routes
            public String name() {  
            Map.of(PARQUET_FORMAT, strategy),
        }  
        // remotePath: basePath + blobKey (basePath already includes format subdirectory)
        StoreStrategy strategy = createTestStrategy(handler);
        assertTrue("Closed handles should not be returned", handles.isEmpty());  
            Map.of(PARQUET_FORMAT, strategy),  
        liveHandle.close();
        verify(successHandler).close();
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
                return Optional.of((shardId, isWarm, repo, cacheRegistry) -> { throw new RuntimeException("factory boom"); });  
            null
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        };
            remoteDir,  
        assertFalse("Seed map should not be empty", seeded.isEmpty());
        RemoteDirectory remoteDataDir = mock(RemoteDirectory.class);
            NativeStoreRepository.EMPTY,
            public String name() {
            remoteDir,
        BlobPath basePath = new BlobPath().add("base-path");
            shardPath,
            @Override
        RemoteDirectory remoteMetadataDir = mock(RemoteDirectory.class);  
    }
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
    public void testCloseClosesAllHandlers() throws IOException {  
        boolean dispatched = registry.onRemoved("parquet/_0.parquet");
        StoreStrategy strategy = createTestStrategy(handler);
        assertFalse(dispatched);
        when(remoteDataDir.getBlobContainer()).thenReturn(mockBlobContainer);
        DataFormatStoreHandler.FileEntry entry = seeded.get(expectedKey);
import org.opensearch.index.engine.dataformat.DataFormatStoreHandler;
        BlobContainer mockBlobContainer = mock(BlobContainer.class);  
    }  
        super.setUp();
        @SuppressWarnings("unchecked")
     * metadata serialization pipeline just to test seeding behaviour.  
 * The OpenSearch Contributors require contributions made to  
            + separator
        Files.createDirectories(shardStatePath);
            shardPath,
    private RemoteSegmentStoreDirectory createRemoteDirWithFormatRouter() throws IOException {
    // close() tests  
        liveHandle.close();
            public Optional<DataFormatStoreHandlerFactory> storeHandler() {
        // The key should be the absolute path: shardPath.getDataPath() + relative file
            public long priority() {
            remoteDir,  
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
    public void testOnUploadedDispatchesToHandler() throws IOException {
        );
    }
        Path shardStatePath = tempDir.resolve("state").resolve("test-uuid").resolve("0");  
            public Set<FieldTypeCapabilities> supportedFields() {
        DataFormatStoreHandler.FileEntry entry = seeded.get(expectedKey);
        assertSame(StoreStrategyRegistry.EMPTY, registry);
        StoreStrategy strategy = createTestStrategy(handler);
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        String expectedKey = shardPath.getDataPath().resolve("parquet/_0.parquet").toString();
    // ═══════════════════════════════════════════════════════════════
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            }
        Files.createDirectories(shardDataPath.resolve("index"));
    // ═══════════════════════════════════════════════════════════════
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        // Create a FormatBlobRouter that routes "parquet" to "base-path/parquet/"  
            remoteDir,  
            @Override
        // The FormatBlobRouter routes "parquet" to "base-path/parquet/" so getRemoteBasePath("parquet")
    public void testMatchForReturnsMatchForFormatFile() throws IOException {  
    private RemoteSegmentStoreDirectory createRealRemoteDir() throws IOException {  
        closedHandle.close(); // close it before returning
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(  
            public Optional<DataFormatStoreHandlerFactory> storeHandler() {
    public void testGetFormatStoreHandlesReturnsLiveHandles() throws IOException {
        StoreStrategy strategy = createTestStrategy(handler);  
    }
        StoreStrategy strategy1 = createTestStrategy(successHandler);
    // ═══════════════════════════════════════════════════════════════
            Map.of(PARQUET_FORMAT, strategy),  
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
            Map.of(PARQUET_FORMAT, strategy),  
            Map.of(PARQUET_FORMAT, strategy),
        );  
        };
        boolean dispatched = registry.onUploaded("_0.cfe", "test-base-path/", "blob_key", 512L);
        verify(handler).seed(captor.capture());
        assertNotNull(match);  
        Map<String, DataFormatStoreHandler.FileEntry> seeded = captor.getValue();
        assertSame("Same handle should be returned on multiple calls", handles1.get(PARQUET_FORMAT), handles2.get(PARQUET_FORMAT));  
        NativeStoreHandle closedHandle = new NativeStoreHandle(99L, ptr -> {});
        );  
        when(handler.getFormatStoreHandle()).thenReturn(closedHandle);  
 * compatible open source license.
            true,
        assertEquals(DataFormatStoreHandler.REMOTE, entry.location());
            entry.path().contains("parquet")  
    // Seed key tests
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
            shardPath,
    }  
        assertSame(StoreStrategyRegistry.EMPTY, registry);
        String metadataStr = localFilename  
            null
 */
/*  
            Map.of(PARQUET_FORMAT, strategy),  
        String expectedKey = shardPath.getDataPath().resolve("parquet/_0.parquet").toString();
            shardPath,
            true,
        assertEquals("test-base-path/parquet/parquet_blob_key", entry.path());  
            shardPath,  
                return "format2";
    // Helpers
        assertNotSame(StoreStrategyRegistry.EMPTY, registry);
    };
import java.util.Collections;
            NativeStoreRepository.EMPTY,
            }
            true,
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
import java.nio.file.Path;  
        public Set<FieldTypeCapabilities> supportedFields() {
import org.opensearch.test.OpenSearchTestCase;  
    public void testMatchForReturnsNullForNull() throws IOException {  
        );
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        }
            + separator
     */
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);  
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
        ThreadPool tp = mock(ThreadPool.class);
    public void testOpenWithEmptyStrategiesReturnsEmpty() throws IOException {
        );
            Map.of(PARQUET_FORMAT, strategy),
    }
            + "checksum123"
        assertSame(liveHandle, handles.get(PARQUET_FORMAT));
        NativeStoreHandle liveHandle = new NativeStoreHandle(42L, ptr -> {});  
    }
        // Second format throws during factory.create()
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(  
            NativeStoreRepository.EMPTY,
    private static void injectUploadedSegment(RemoteSegmentStoreDirectory remoteDir, String localFilename, String uploadedFilename)  
        );
        assertFalse("Seed map should not be empty", seeded.isEmpty());
        return new StoreStrategy() {
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            Map.of(PARQUET_FORMAT, strategy),
 */  
        };
     * to the factory's create() call. This is the contract that allows format
            Map.of(PARQUET_FORMAT, strategy),
            + org.apache.lucene.util.Version.LATEST.major;
package org.opensearch.storage.directory;
            public Set<FieldTypeCapabilities> supportedFields() {
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
    // ═══════════════════════════════════════════════════════════════
    private static final DataFormat PARQUET_FORMAT = new DataFormat() {
            + separator  
import static org.mockito.ArgumentMatchers.anyString;
    }
import org.opensearch.repositories.NativeStoreRepository;
        org.mockito.ArgumentCaptor<Map<String, DataFormatStoreHandler.FileEntry>> captor = org.mockito.ArgumentCaptor.forClass(Map.class);
        BlobStore blobStore = mock(BlobStore.class);
            @Override
import static org.mockito.Mockito.verify;
            mockRegistry  
            true,
        // into its uploaded segments map via reflection so that seedFromRemoteMetadata  
            shardPath,  
        Map<String, DataFormatStoreHandler.FileEntry> seeded = captor.getValue();
import org.opensearch.common.SuppressForbidden;
            }  
        RemoteDirectory remoteMetadataDir = mock(RemoteDirectory.class);
import org.opensearch.core.index.Index;
        return new RemoteSegmentStoreDirectory(remoteDataDir, remoteMetadataDir, lockManager, tp, shardPath.getShardId(), new HashMap<>());
    public void testOpenCreatesHandlerFromFactory() throws IOException {
            null
    public void testOnRemovedDispatchesToHandler() throws IOException {
        when(handler.getFormatStoreHandle()).thenReturn(liveHandle);
            true,
            @Override  
import java.util.Set;
    }
        assertFalse(dispatched);
        registry.close();  
    // ═══════════════════════════════════════════════════════════════  
        StoreStrategy strategy = createTestStrategy(handler);
        StoreStrategy strategy = new StoreStrategy() {
            true,
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(  
            remoteDir,  
        Map<DataFormat, NativeStoreHandle> handles = registry.getFormatStoreHandles();  
        StoreStrategy strategy = createTestStrategy(handler);
 * Unit tests for {@link StoreStrategyRegistry}.  
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(  
            createRealRemoteDir(),
            remoteDir,
            shardPath,  
        BlobContainer baseBlobContainer = mock(BlobContainer.class);
     * internal map via reflection. This avoids the need to set up the full
            public Optional<DataFormatStoreHandlerFactory> storeHandler() {  
            null
            null  
            eq(1024L)  
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);
            remoteDir,
        BlobContainer parquetBlobContainer = mock(BlobContainer.class);
            null  
     * Verifies that the BlockCacheRegistry passed to open() is forwarded verbatim
/**
            true,
    /**  
            true,
            @Override
        RemoteSegmentStoreDirectory remoteDir = createRemoteDirWithFormatRouter();  
    }  
        assertTrue(dispatched);
            return Set.of();
    public void setUp() throws Exception {  
import org.opensearch.index.store.RemoteDirectory;
        // Capture the seed call argument
    }
        );  
                return Optional.of((shardId, isWarm, repo, cacheRegistry) -> {
            NativeStoreRepository.EMPTY,  
        );
        Index index = new Index("test-index", "test-uuid");  
        registry.close();
import static org.mockito.Mockito.when;  
        // "parquet" to a different sub-path than the base path.
        @SuppressWarnings("unchecked")  
        public long priority() {
    @SuppressForbidden(reason = "test needs reflection to inject parquet metadata without full upload pipeline")
        );  
import org.opensearch.plugins.NativeStoreHandle;
        DataFormatStoreHandler successHandler = mock(DataFormatStoreHandler.class);  
 * SPDX-License-Identifier: Apache-2.0
        DataFormatStoreHandler handler = mock(DataFormatStoreHandler.class);  
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(shardPath, true, NativeStoreRepository.EMPTY, null, remoteDir, null);  
        RemoteStoreLockManager lockManager = mock(RemoteStoreLockManager.class);  
import org.opensearch.threadpool.ThreadPool;
            true,
        Map<DataFormat, NativeStoreHandle> handles = registry.getFormatStoreHandles();
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(  
     */
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();  
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
    public void testGetFormatStoreHandlesEmptyWhenNoHandlers() {  
        StoreStrategy strategy = createTestStrategy(handler);
import java.util.Optional;
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(  
        );
        Map<DataFormat, NativeStoreHandle> handles2 = registry.getFormatStoreHandles();
        ThreadPool tp = mock(ThreadPool.class);
import java.util.HashMap;
        StoreStrategy strategy = createTestStrategy(handler);
            true,
            null
            shardPath,
            "Seeded path should use format-specific base path containing 'parquet': " + entry.path(),
            null
        assertEquals(PARQUET_FORMAT, match.format());
    }
                return Set.of();  
    public void testSeedUsesAbsolutePathKeys() throws Exception {
        Map<String, UploadedSegmentMetadata> map = (Map<String, UploadedSegmentMetadata>) field.get(remoteDir);
            NativeStoreRepository.EMPTY,  
        verify(handler).onUploaded(  
            remoteDir,
        // Format: originalFilename::uploadedFilename::checksum::length::writtenByMajor
        boolean dispatched = registry.onRemoved("_0.cfe");  
import org.opensearch.index.engine.dataformat.StoreStrategy;
        assertNull(registry.matchFor("_0.cfe"));
import java.util.Map;  
        when(baseBlobContainer.path()).thenReturn(basePath);  
            }
}  
            NativeStoreRepository.EMPTY,
    }
        injectUploadedSegment(remoteDir, "parquet/_0.parquet", "parquet_blob_key");
    // getFormatStoreHandles() tests
    // ═══════════════════════════════════════════════════════════════  
            + uploadedFilename
        RemoteSegmentStoreDirectory remoteDir = createRealRemoteDir();
    // onUploaded() tests
            shardPath,
                return 1;  
            Map.of(PARQUET_FORMAT, strategy),
        StoreStrategy strategy = createTestStrategy(handler);  
            true,  
        registry.close();  
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);  
    public void testGetFormatStoreHandlesReturnsSameHandleOnMultipleCalls() throws IOException {
            shardPath,
        field.setAccessible(true);  
        Map<DataFormat, StoreStrategy> strategies = new java.util.LinkedHashMap<>();
            remoteDir,
            return "parquet";
                return "format1";
        when(handler.getFormatStoreHandle()).thenReturn(liveHandle);
        Map<DataFormat, NativeStoreHandle> handles = StoreStrategyRegistry.EMPTY.getFormatStoreHandles();
            public long priority() {  
            NativeStoreRepository.EMPTY,  
public class StoreStrategyRegistryTests extends OpenSearchTestCase {
            Map.of(PARQUET_FORMAT, strategy),  
            @Override
        registry.close();
import org.opensearch.plugins.BlockCacheRegistry;  
    }
        verify(handler).seed(captor.capture());
import java.io.IOException;  
            shardPath,
                return 2;
            }
                return Optional.of(factory);
        StoreStrategy strategy = createTestStrategy(handler);
        // The successfully created handler should have been closed during cleanup
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(

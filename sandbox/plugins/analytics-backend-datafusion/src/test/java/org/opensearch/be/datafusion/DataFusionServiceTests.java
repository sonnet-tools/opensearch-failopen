            .cpuThreads(2)
        service.onFilesAdded(java.util.List.of("/tmp/test1.parquet", "/tmp/test2.parquet"));
 * compatible open source license.
    public void testServiceWithoutCacheReturnsNullCacheManager() {
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
            .cpuThreads(2)
    }
        Path spillDir = createTempDir("spill");
import java.nio.file.Path;
        service.start();
        Path spillDir = createTempDir("spill");
        service.start();
    }
            .build();
        expectThrows(IllegalStateException.class, handle::get);
        assertTrue(settings.contains(CacheSettings.METADATA_CACHE_EVICTION_TYPE));
            .build();
 * SPDX-License-Identifier: Apache-2.0
    }
 */
        ensureTokioInit();
        service.onFilesAdded(null);
        service.stop();
        long ptr = NativeBridge.createCustomCacheManager();
        handle.close();
        assertFalse(handle.isOpen());
    }
        ClusterSettings clusterSettings = createCacheClusterSettings(Settings.EMPTY);
    public void testNativeBridgeCacheManagerLifecycle() {
        all.add(DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT);
        assertTrue(handle.isOpen());
            .spillDirectory(spillDir.toString())
        assertNotNull(handle);
    private void ensureTokioInit() {
    }
        List<Setting<?>> settings = new DataFusionPlugin().getSettings();
        ensureTokioInit();
    }
import org.opensearch.common.settings.ClusterSettings;
        DataFusionService service = DataFusionService.builder()
        all.add(CacheSettings.METADATA_CACHE_ENABLED);
        NativeRuntimeHandle handle = service.getNativeRuntime();
        DataFusionService service = DataFusionService.builder()
        service.stop();
    public void testNativeBridgeCreateCacheOnManager() {
        Path spillDir = createTempDir("spill");
        assertTrue(settings.contains(CacheSettings.OFFSET_INDEX_CACHE_PERCENT));
import java.util.List;
            .spillDirectory(spillDir.toString())
    }
        all.add(CacheSettings.COLUMN_INDEX_CACHE_PERCENT);
            .spillDirectory(spillDir.toString())
        Path spillDir = createTempDir("spill");
        assertNotNull(handle);
        assertTrue(runtimePtr != 0);
            .memoryPoolLimit(64 * 1024 * 1024)
        ensureTokioInit();
        all.add(CacheSettings.OFFSET_INDEX_CACHE_EVICTION_TYPE);
    }
 * Tests for DataFusionService lifecycle and NativeRuntimeHandle.
            .spillMemoryLimit(0L)
        assertTrue(settings.contains(CacheSettings.METADATA_CACHE_ENABLED));
            .memoryPoolLimit(64 * 1024 * 1024)
    }
        ensureTokioInit();
    public void testCacheManagerHandleConsumedAfterRuntimeCreation() {
        all.add(DataFusionPlugin.SCOPED_PAGE_INDEX_ENABLED);
        NativeBridge.destroyCustomCacheManager(ptr);
            .memoryPoolLimit(64 * 1024 * 1024)
        ensureTokioInit();
            .build();
        expectThrows(IllegalArgumentException.class, () -> new NativeRuntimeHandle(0L));
        long ptr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
        assertTrue(settings.contains(CacheSettings.STATISTICS_CACHE_PERCENT));
        assertTrue(handle.isOpen());
    }
        assertTrue(ptr != 0);
        assertFalse(handle.isOpen());
        long ptr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
        all.add(CacheSettings.METADATA_CACHE_EVICTION_TYPE);
        NativeBridge.initTokioRuntimeManager(2);
    }
            .clusterSettings(clusterSettings)
        assertNull(service.getCacheManager());
        Path spillDir = createTempDir("spill");
        all.add(CacheSettings.OFFSET_INDEX_CACHE_PERCENT);
        all.add(CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE);
    public void testServiceStartWithEmptySpillDirectory() {
        // and shutdown are unaffected.
        Set<Setting<?>> all = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);
        NativeBridge.destroyCustomCacheManager(ptr);
            .cpuThreads(2)
        assertTrue(org.opensearch.analytics.backend.jni.NativeHandle.isLivePointer(ptrBefore));
            .cpuThreads(2)
        long ptrBefore = handle.getPointer();
        assertTrue(settings.contains(CacheSettings.FOOTER_METADATA_CACHE_PERCENT));
package org.opensearch.be.datafusion;
        NativeRuntimeHandle handle = new NativeRuntimeHandle(ptr);
import org.opensearch.be.datafusion.cache.CacheSettings;
import org.opensearch.test.OpenSearchTestCase;
    public void testServiceWithCacheEnabled() {
import org.opensearch.common.settings.Settings;
        NativeBridge.createCache(cachePtr, "STATISTICS", 100 * 1024 * 1024, "LRU");
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        Path spillDir = createTempDir("spill");
 * The OpenSearch Contributors require contributions made to
    public void testNativeRuntimeHandleRejectsZeroPointer() {
    public void testPluginRegistersAllCacheSettings() {
        ensureTokioInit();
            .cpuThreads(2)
    }
        assertFalse(org.opensearch.analytics.backend.jni.NativeHandle.isLivePointer(ptrBefore));
            .spillMemoryLimit(32 * 1024 * 1024)
    }
    public void testServiceStartStop() {
        service.start();
        NativeRuntimeHandle handle = service.getNativeRuntime();
import java.util.HashSet;
        service.onFilesDeleted(java.util.List.of("/tmp/test1.parquet"));
        assertTrue(handle.get() != 0);
}
            .build();
        NativeBridge.createCache(ptr, "STATISTICS", 100 * 1024 * 1024, "LRU");
 *
        service.start();
        all.add(CacheSettings.STATISTICS_CACHE_ENABLED);
    public void testCacheFileOperationsDoNotThrow() {
            .memoryPoolLimit(64 * 1024 * 1024)
    public void testNativeRuntimeHandleGetAfterCloseThrows() {
        // Second close should not throw
        assertFalse(handle.isOpen());
/**
            .spillDirectory(spillDir.toString())
        assertTrue(settings.contains(CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE));
        // Empty spillDirectory triggers DiskManagerMode::Disabled in Rust. The runtime
        DataFusionService service = DataFusionService.builder().build();
        assertNotNull(service.getNativeRuntime());
        all.add(CacheSettings.COLUMN_INDEX_CACHE_EVICTION_TYPE);
            .spillMemoryLimit(32 * 1024 * 1024)
        all.add(CacheSettings.STATISTICS_CACHE_EVICTION_TYPE);
        NativeBridge.createCache(handle.getPointer(), "METADATA", 250 * 1024 * 1024, "LRU");
        NativeRuntimeHandle handle = new NativeRuntimeHandle(ptr);
        // These are no-ops in the current Rust impl but should not throw
        assertFalse(handle.isOpen());
        assertTrue(handle.get() != 0);
        ensureTokioInit();
            .spillMemoryLimit(32 * 1024 * 1024)
        Path spillDir = createTempDir("spill");
    }
        handle.close();
import java.util.Set;
        // must build successfully (memory-only execution); spill-attempting queries will
        all.add(CacheSettings.FOOTER_METADATA_CACHE_PERCENT);
        DataFusionService service = DataFusionService.builder()
        handle.close();
        all.add(CacheSettings.STATISTICS_CACHE_PERCENT);
            .build();
    }
    public void testGetNativeRuntimeBeforeStartThrows() {
 * this file be licensed under the Apache-2.0 license or a
    private ClusterSettings createCacheClusterSettings(Settings settings) {
        return new ClusterSettings(settings, all);
        assertTrue(settings.contains(CacheSettings.COLUMN_INDEX_CACHE_EVICTION_TYPE));
        NativeBridge.createCache(ptr, "METADATA", 250 * 1024 * 1024, "LRU");
        DataFusionService service = DataFusionService.builder()
        service.onFilesDeleted(java.util.List.of());
        assertTrue(settings.contains(CacheSettings.STATISTICS_CACHE_EVICTION_TYPE));
        assertTrue(settings.contains(CacheSettings.STATISTICS_CACHE_ENABLED));
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, cachePtr, spillDir.toString(), 32 * 1024 * 1024);
            .memoryPoolLimit(64 * 1024 * 1024)
        ensureTokioInit();
        assertTrue(settings.contains(CacheSettings.COLUMN_INDEX_CACHE_PERCENT));
        expectThrows(IllegalStateException.class, handle::getPointer);
/*
        service.stop();
    public void testNativeRuntimeHandleCloseIsIdempotent() {
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, handle.getPointer(), spillDir.toString(), 32 * 1024 * 1024);
        ensureTokioInit();
        assertTrue(handle.isOpen());
        NativeBridge.closeGlobalRuntime(runtimePtr);
        // fail with a "DiskManager is disabled" error, but plain runtime construction
        assertTrue(settings.contains(CacheSettings.OFFSET_INDEX_CACHE_EVICTION_TYPE));
    public void testRuntimeWithCacheManagerPointer() {
        all.add(DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT);
        long ptr = NativeBridge.createCustomCacheManager();
    }
        service.stop();
        NativeBridge.createCache(cachePtr, "METADATA", 250 * 1024 * 1024, "LRU");
import org.opensearch.common.settings.Setting;
public class DataFusionServiceTests extends OpenSearchTestCase {
        DataFusionService service = DataFusionService.builder()
        assertTrue(service.getNativeRuntime().isOpen());
        ensureTokioInit();
 */
        var handle = new org.opensearch.be.datafusion.cache.NativeCacheManagerHandle(NativeBridge.createCustomCacheManager());
            .spillMemoryLimit(32 * 1024 * 1024)
        service.start();
        handle.markConsumed();
        service.stop();
            .spillDirectory("")
        ensureTokioInit();
        assertTrue(settings.contains(DataFusionPlugin.SCOPED_PAGE_INDEX_ENABLED));
        long cachePtr = NativeBridge.createCustomCacheManager();
        assertNotNull(service.getCacheManager());
        NativeBridge.closeGlobalRuntime(runtimePtr);
        expectThrows(IllegalStateException.class, service::getNativeRuntime);
        Path spillDir = createTempDir("spill");

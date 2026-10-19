        assertFalse(handle.isOpen());
        expectThrows(IllegalArgumentException.class, () -> new NativeRuntimeHandle(0L));  
 * compatible open source license.
        Path spillDir = createTempDir("spill");
            .memoryPoolLimit(64 * 1024 * 1024)
            .spillDirectory(spillDir.toString())  
        assertTrue(settings.contains(CacheSettings.FOOTER_METADATA_CACHE_PERCENT));
        long ptr = NativeBridge.createCustomCacheManager();
        all.add(DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT);  
import org.opensearch.common.settings.Setting;
            .clusterSettings(clusterSettings)  
        assertTrue(settings.contains(CacheSettings.OFFSET_INDEX_CACHE_EVICTION_TYPE));  
import org.opensearch.common.settings.Settings;
        all.add(CacheSettings.FOOTER_METADATA_CACHE_PERCENT);
        assertTrue(handle.isOpen());  
        assertNotNull(handle);
        NativeRuntimeHandle handle = new NativeRuntimeHandle(ptr);
        all.add(CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE);  
    }
        NativeBridge.initTokioRuntimeManager(2);  
    }
            .spillDirectory("")
        ensureTokioInit();
    public void testPluginRegistersAllCacheSettings() {
        DataFusionService service = DataFusionService.builder()
    }  
        assertTrue(settings.contains(CacheSettings.STATISTICS_CACHE_EVICTION_TYPE));
import org.opensearch.test.OpenSearchTestCase;  
        ensureTokioInit();  
import org.opensearch.common.settings.ClusterSettings;  
            .build();
            .spillDirectory(spillDir.toString())  
        NativeBridge.destroyCustomCacheManager(ptr);
        service.stop();
        assertTrue(handle.get() != 0);
 * The OpenSearch Contributors require contributions made to  
        // Empty spillDirectory triggers DiskManagerMode::Disabled in Rust. The runtime  
 */
            .cpuThreads(2)
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
        assertFalse(org.opensearch.analytics.backend.jni.NativeHandle.isLivePointer(ptrBefore));  
    }
    }
        Path spillDir = createTempDir("spill");
        all.add(DataFusionPlugin.SCOPED_PAGE_INDEX_ENABLED);
            .cpuThreads(2)
            .spillDirectory(spillDir.toString())
        service.onFilesDeleted(java.util.List.of());  
        assertTrue(settings.contains(CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE));
import java.util.HashSet;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.be.datafusion.cache.CacheSettings;
        service.start();  
        all.add(CacheSettings.OFFSET_INDEX_CACHE_EVICTION_TYPE);
/**  
package org.opensearch.be.datafusion;
        assertTrue(runtimePtr != 0);
        assertTrue(ptr != 0);
        DataFusionService service = DataFusionService.builder()  
        handle.close();
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, handle.getPointer(), spillDir.toString(), 32 * 1024 * 1024);  
        all.add(CacheSettings.STATISTICS_CACHE_EVICTION_TYPE);
    private void ensureTokioInit() {
        service.start();  
        service.stop();  
    public void testGetNativeRuntimeBeforeStartThrows() {
        // must build successfully (memory-only execution); spill-attempting queries will
        assertTrue(org.opensearch.analytics.backend.jni.NativeHandle.isLivePointer(ptrBefore));  
            .memoryPoolLimit(64 * 1024 * 1024)
        handle.close();
    private ClusterSettings createCacheClusterSettings(Settings settings) {  
        long ptr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);  
public class DataFusionServiceTests extends OpenSearchTestCase {  
        assertNotNull(service.getCacheManager());
        NativeBridge.closeGlobalRuntime(runtimePtr);  
        service.onFilesAdded(null);
        NativeRuntimeHandle handle = service.getNativeRuntime();
            .build();
    public void testNativeRuntimeHandleGetAfterCloseThrows() {
    public void testNativeRuntimeHandleRejectsZeroPointer() {
        DataFusionService service = DataFusionService.builder()  
        assertTrue(settings.contains(CacheSettings.STATISTICS_CACHE_PERCENT));
    }  
        DataFusionService service = DataFusionService.builder()
        assertTrue(settings.contains(CacheSettings.COLUMN_INDEX_CACHE_EVICTION_TYPE));
        long ptr = NativeBridge.createCustomCacheManager();
        ensureTokioInit();
        NativeRuntimeHandle handle = new NativeRuntimeHandle(ptr);  
    public void testCacheFileOperationsDoNotThrow() {  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        all.add(CacheSettings.STATISTICS_CACHE_ENABLED);
    public void testNativeBridgeCreateCacheOnManager() {  
    public void testNativeBridgeCacheManagerLifecycle() {
    }
    public void testServiceStartWithEmptySpillDirectory() {
        assertTrue(service.getNativeRuntime().isOpen());  
 *
        expectThrows(IllegalStateException.class, service::getNativeRuntime);  
        handle.markConsumed();
        service.stop();
        List<Setting<?>> settings = new DataFusionPlugin().getSettings();
        assertFalse(handle.isOpen());
}  
        Path spillDir = createTempDir("spill");
        DataFusionService service = DataFusionService.builder()  
        all.add(CacheSettings.OFFSET_INDEX_CACHE_PERCENT);
        Path spillDir = createTempDir("spill");
        NativeBridge.destroyCustomCacheManager(ptr);  
        ensureTokioInit();
        assertFalse(handle.isOpen());
        all.add(CacheSettings.METADATA_CACHE_EVICTION_TYPE);  
            .spillMemoryLimit(32 * 1024 * 1024)
    public void testRuntimeWithCacheManagerPointer() {
        ensureTokioInit();  
            .build();
        assertTrue(settings.contains(CacheSettings.COLUMN_INDEX_CACHE_PERCENT));
        assertTrue(settings.contains(CacheSettings.METADATA_CACHE_ENABLED));
        service.start();
    public void testServiceStartStop() {  
import java.nio.file.Path;
        long cachePtr = NativeBridge.createCustomCacheManager();
 * this file be licensed under the Apache-2.0 license or a
            .build();
        assertNull(service.getCacheManager());
        assertTrue(settings.contains(CacheSettings.METADATA_CACHE_EVICTION_TYPE));  
        Path spillDir = createTempDir("spill");
        expectThrows(IllegalStateException.class, handle::getPointer);
        NativeBridge.createCache(cachePtr, "METADATA", 250 * 1024 * 1024, "LRU");
        NativeBridge.createCache(cachePtr, "STATISTICS", 100 * 1024 * 1024, "LRU");  
        ensureTokioInit();  
        assertTrue(handle.get() != 0);
        assertNotNull(handle);  
        NativeBridge.createCache(ptr, "METADATA", 250 * 1024 * 1024, "LRU");  
        Path spillDir = createTempDir("spill");
        all.add(CacheSettings.COLUMN_INDEX_CACHE_PERCENT);  
    public void testNativeRuntimeHandleCloseIsIdempotent() {  
        assertTrue(handle.isOpen());  
import java.util.Set;
    }
        Path spillDir = createTempDir("spill");
        ensureTokioInit();
        NativeBridge.createCache(handle.getPointer(), "METADATA", 250 * 1024 * 1024, "LRU");  
    }  
        DataFusionService service = DataFusionService.builder().build();
        service.start();
 */  
        expectThrows(IllegalStateException.class, handle::get);
            .spillDirectory(spillDir.toString())  
        assertTrue(handle.isOpen());
        ensureTokioInit();
    }  
        long ptr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
            .spillMemoryLimit(32 * 1024 * 1024)  
    }  
        NativeRuntimeHandle handle = service.getNativeRuntime();
            .cpuThreads(2)
        all.add(DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT);
        // These are no-ops in the current Rust impl but should not throw
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, cachePtr, spillDir.toString(), 32 * 1024 * 1024);  
        NativeBridge.closeGlobalRuntime(runtimePtr);  
        // Second close should not throw  
    public void testServiceWithoutCacheReturnsNullCacheManager() {
            .cpuThreads(2)
        service.stop();
            .spillMemoryLimit(0L)
            .memoryPoolLimit(64 * 1024 * 1024)
    }
            .memoryPoolLimit(64 * 1024 * 1024)
        NativeBridge.createCache(ptr, "STATISTICS", 100 * 1024 * 1024, "LRU");
    public void testCacheManagerHandleConsumedAfterRuntimeCreation() {  
        ensureTokioInit();
        assertNotNull(service.getNativeRuntime());
            .memoryPoolLimit(64 * 1024 * 1024)  
            .build();
        long ptrBefore = handle.getPointer();
        service.onFilesAdded(java.util.List.of("/tmp/test1.parquet", "/tmp/test2.parquet"));  
        all.add(CacheSettings.METADATA_CACHE_ENABLED);
        all.add(CacheSettings.STATISTICS_CACHE_PERCENT);
        Set<Setting<?>> all = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);
        // and shutdown are unaffected.  
            .spillMemoryLimit(32 * 1024 * 1024)
 * Tests for DataFusionService lifecycle and NativeRuntimeHandle.
            .cpuThreads(2)  
        ensureTokioInit();  
        var handle = new org.opensearch.be.datafusion.cache.NativeCacheManagerHandle(NativeBridge.createCustomCacheManager());
        assertTrue(settings.contains(DataFusionPlugin.SCOPED_PAGE_INDEX_ENABLED));  
        return new ClusterSettings(settings, all);
    public void testServiceWithCacheEnabled() {
        service.start();  
        assertTrue(settings.contains(CacheSettings.STATISTICS_CACHE_ENABLED));
        assertFalse(handle.isOpen());
    }
        Path spillDir = createTempDir("spill");
            .spillMemoryLimit(32 * 1024 * 1024)
        all.add(CacheSettings.COLUMN_INDEX_CACHE_EVICTION_TYPE);  
        // fail with a "DiskManager is disabled" error, but plain runtime construction
        ClusterSettings clusterSettings = createCacheClusterSettings(Settings.EMPTY);
        assertTrue(settings.contains(CacheSettings.OFFSET_INDEX_CACHE_PERCENT));  
/*  
import java.util.List;
        ensureTokioInit();  
        service.onFilesDeleted(java.util.List.of("/tmp/test1.parquet"));
    }  
    }
        service.stop();
        handle.close();
    }  

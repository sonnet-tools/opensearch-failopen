    }
            assertTrue(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileName));
        setup();  
            String fileName = getResourceFile("hits1.parquet");  
            assertTrue(afterAddMemory > initialMemory);  
        setup();
    public void testRemoveFilesWithEmptyList() {
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.common.settings.Settings;
    }
import org.opensearch.common.settings.Setting;
import org.opensearch.common.settings.ClusterSettings;  
        setup();
            cacheManager.addFilesToCacheManager(fileNames);  
}
            .cpuThreads(2)
            cleanup();  
    public void testAddMultipleFilesToCache() {
        try {  
            assertFalse(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, "/invalid/file.parquet"));  
            assertTrue(totalMemory >= 0);  
        setup();  
            cleanup();  
        clusterSettingsToAdd.add(CacheSettings.COLUMN_INDEX_CACHE_EVICTION_TYPE);
        try {  
        }
        setup();
import org.opensearch.be.datafusion.cache.CacheSettings;
import java.util.Collections;
        try {
/*  
    public void testRemoveFileFromCache() {
            assertTrue(cacheManager.getMemoryConsumed(CacheUtils.CacheType.METADATA) > 0);
import org.opensearch.common.io.PathUtils;
            assertFalse(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, "/path/nonexistent.parquet"));
    }  
    }
    public void testExceptionHandlingWithInvalidFile() {
        try {
            .spillDirectory(spillDir.toString())
    public void testCacheManagerTotalMemoryTracking() {
        } finally {  
        try {
    }
        try {
        clusterSettingsToAdd.add(DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT);
            cacheManager.addFilesToCacheManager(null);
package org.opensearch.be.datafusion;
        try {  
            long totalMemory = cacheManager.getTotalMemoryConsumed();
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, clusterSettingsToAdd);
 */  
public class DatafusionCacheManagerTests extends OpenSearchTestCase {
        clusterSettingsToAdd.add(CacheSettings.OFFSET_INDEX_CACHE_EVICTION_TYPE);  
    }
            List<String> fileNames = List.of(getResourceFile("hits1.parquet"), getResourceFile("hits2.parquet"));
        } finally {
        setup();
        } finally {
    }  
        clusterSettingsToAdd.add(CacheSettings.OFFSET_INDEX_CACHE_PERCENT);
        cacheManager = service.getCacheManager();  
            cacheManager.addFilesToCacheManager(List.of(fileName));
        }
        }
    private DataFusionService service;  
            cacheManager.removeFilesFromCacheManager(Collections.emptyList());
        clusterSettingsToAdd.add(DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT);
        Set<Setting<?>> clusterSettingsToAdd = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);  
        clusterSettingsToAdd.add(CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE);
        }
import java.util.List;  
            long afterRemoveMemory = cacheManager.getTotalMemoryConsumed();  
        }
 * this file be licensed under the Apache-2.0 license or a
            service.stop();  
        } catch (URISyntaxException e) {  
            cacheManager.addFilesToCacheManager(List.of("/invalid/path/to/file.parquet"));
    }
            assertTrue(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileNames.getFirst()));
    private void cleanup() {
            String fileName = getResourceFile("hits1.parquet");
        clusterSettingsToAdd.add(CacheSettings.STATISTICS_CACHE_ENABLED);  
        setup();
            cacheManager.addFilesToCacheManager(Collections.emptyList());
            cacheManager.addFilesToCacheManager(List.of(fileName));
            cleanup();
    public void testGetEntryFromCacheTypeReturnsFalseOnError() {  
            .spillMemoryLimit(32 * 1024 * 1024)  
        }
        }  
    }  
    }
            cacheManager.addFilesToCacheManager(List.of(fileName));
    private String getResourceFile(String fileName) {  
    }
            cacheManager.clearCacheForCacheType(CacheUtils.CacheType.METADATA);
        }
        setup();
            assertTrue(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileNames.getLast()));
    private CacheManager cacheManager;
        } finally {
    private void setup() {  
 * compatible open source license.
        } finally {  
            cleanup();  
            assertEquals(initialMemory, afterRemoveMemory);
        clusterSettingsToAdd.add(CacheSettings.METADATA_CACHE_ENABLED);
            cleanup();  
        }
    public void testAddFileToCache() {
    public void testRemoveFilesWithNullList() {
    public void testGetNonExistentFile() {
import org.opensearch.be.datafusion.cache.CacheUtils;  
            cacheManager.removeFilesFromCacheManager(null);
    public void testCacheClear() {  
        setup();
            assertTrue(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileName));  
 * SPDX-License-Identifier: Apache-2.0
            cleanup();  
    public void testGetTotalMemoryConsumedReturnsZeroOnError() {
        }  
 * The OpenSearch Contributors require contributions made to  
        } finally {
import java.nio.file.Path;  
        try {  
            cacheManager.clearAllCache();
        try {  
import java.util.Set;
        clusterSettingsToAdd.add(DataFusionPlugin.SCOPED_PAGE_INDEX_ENABLED);
            throw new IllegalArgumentException("Resource not found: " + fileName, e);
        }
    }  
    }
        } finally {
        try {  
        setup();
            cleanup();  
    }
            String fileName = getResourceFile("hits1.parquet");
        try {  
        } finally {
import org.opensearch.be.datafusion.nativelib.NativeBridge;
            cleanup();  
        assertNotNull(cacheManager);
import java.net.URISyntaxException;
            .clusterSettings(clusterSettings)  
import java.util.HashSet;
        } finally {
            return PathUtils.get(getClass().getClassLoader().getResource(fileName).toURI()).toString();
            assertTrue(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileName));  
        clusterSettingsToAdd.add(CacheSettings.FOOTER_METADATA_CACHE_PERCENT);  
        }
            .memoryPoolLimit(64 * 1024 * 1024)
        try {
        NativeBridge.initTokioRuntimeManager(2);
        clusterSettingsToAdd.add(CacheSettings.COLUMN_INDEX_CACHE_PERCENT);
            cleanup();
            cacheManager.removeFilesFromCacheManager(List.of(fileName));
            String fileName = getResourceFile("hits1.parquet");
        try {  
            assertFalse(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileName));
        } finally {
        Path spillDir = createTempDir("spill");
        setup();  
            cleanup();
        }
            cacheManager.addFilesToCacheManager(List.of(fileName));
        } finally {  
        service = DataFusionService.builder()
            cleanup();
            cleanup();
        } finally {
        clusterSettingsToAdd.add(CacheSettings.METADATA_CACHE_EVICTION_TYPE);
    public void testAddFilesWithNullList() {
        if (service != null) {
        setup();
        clusterSettingsToAdd.add(CacheSettings.STATISTICS_CACHE_EVICTION_TYPE);
            .build();
 *
            long initialMemory = cacheManager.getTotalMemoryConsumed();  
        service.start();
    }
            long afterAddMemory = cacheManager.getTotalMemoryConsumed();
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;  
            assertFalse(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileName));  
        try {
        } finally {
        setup();
    public void testAddFilesWithEmptyList() {
import org.opensearch.be.datafusion.cache.CacheManager;
        }
            cleanup();
        }  
            cacheManager.removeFilesFromCacheManager(List.of(fileName));
    }
        clusterSettingsToAdd.add(CacheSettings.STATISTICS_CACHE_PERCENT);  

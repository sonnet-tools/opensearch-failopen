        }
import org.opensearch.common.settings.Settings;
        } finally {
    private void setup() {
    public void testGetEntryFromCacheTypeReturnsFalseOnError() {
        setup();
import org.opensearch.common.settings.Setting;
    public void testAddFileToCache() {
            cleanup();
        setup();
        try {
import java.nio.file.Path;
        clusterSettingsToAdd.add(CacheSettings.METADATA_CACHE_EVICTION_TYPE);
        setup();
            long afterAddMemory = cacheManager.getTotalMemoryConsumed();
        try {
 */
        try {
    public void testGetNonExistentFile() {
        try {
        } finally {
        if (service != null) {
            long initialMemory = cacheManager.getTotalMemoryConsumed();
            cacheManager.removeFilesFromCacheManager(List.of(fileName));
        setup();
            assertFalse(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, "/path/nonexistent.parquet"));
    private CacheManager cacheManager;
import org.opensearch.test.OpenSearchTestCase;
        }
            cleanup();
import org.opensearch.be.datafusion.nativelib.NativeBridge;
            cacheManager.addFilesToCacheManager(fileNames);
        }
        } finally {
public class DatafusionCacheManagerTests extends OpenSearchTestCase {
        try {
    public void testRemoveFilesWithNullList() {
        }
    public void testGetTotalMemoryConsumedReturnsZeroOnError() {
            assertTrue(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileName));
        }
        try {
        setup();
            assertTrue(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileName));
    }
        cacheManager = service.getCacheManager();
        clusterSettingsToAdd.add(CacheSettings.FOOTER_METADATA_CACHE_PERCENT);
            cacheManager.clearCacheForCacheType(CacheUtils.CacheType.METADATA);
        }
            .spillDirectory(spillDir.toString())
    }
            String fileName = getResourceFile("hits1.parquet");
        Path spillDir = createTempDir("spill");
            assertFalse(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, "/invalid/file.parquet"));
            assertTrue(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileName));
}
            cleanup();
    }
    public void testRemoveFileFromCache() {
 *
            cacheManager.removeFilesFromCacheManager(Collections.emptyList());
        setup();
            cleanup();
        setup();
            cleanup();
    public void testCacheManagerTotalMemoryTracking() {
        } finally {
        }
        }
        clusterSettingsToAdd.add(CacheSettings.STATISTICS_CACHE_EVICTION_TYPE);
        }
            String fileName = getResourceFile("hits1.parquet");
            assertFalse(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileName));
            .build();
        setup();
    public void testAddFilesWithNullList() {
import org.opensearch.common.io.PathUtils;
        } finally {
            cacheManager.addFilesToCacheManager(null);
            .clusterSettings(clusterSettings)
        try {
    }
            cacheManager.addFilesToCacheManager(List.of("/invalid/path/to/file.parquet"));
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
            cleanup();
import org.opensearch.be.datafusion.cache.CacheManager;
        try {
    }
    }
            .memoryPoolLimit(64 * 1024 * 1024)
import java.util.Set;
        clusterSettingsToAdd.add(CacheSettings.STATISTICS_CACHE_PERCENT);
        NativeBridge.initTokioRuntimeManager(2);
import java.util.HashSet;
 * The OpenSearch Contributors require contributions made to
            cleanup();
    }
import java.util.List;
        } finally {
            .spillMemoryLimit(32 * 1024 * 1024)
            service.stop();
            assertFalse(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileName));
            assertEquals(initialMemory, afterRemoveMemory);
 * SPDX-License-Identifier: Apache-2.0
        }
        try {
    }
            cacheManager.clearAllCache();
            .cpuThreads(2)
        try {
        clusterSettingsToAdd.add(DataFusionPlugin.SCOPED_PAGE_INDEX_ENABLED);
            long totalMemory = cacheManager.getTotalMemoryConsumed();
        setup();
        } finally {
        }
    private DataFusionService service;
            throw new IllegalArgumentException("Resource not found: " + fileName, e);
import java.util.Collections;
    }
    public void testAddFilesWithEmptyList() {
package org.opensearch.be.datafusion;
        setup();
            cacheManager.removeFilesFromCacheManager(List.of(fileName));
        setup();
        service = DataFusionService.builder()
        } finally {
            assertTrue(afterAddMemory > initialMemory);
        }
    public void testRemoveFilesWithEmptyList() {
    }
        clusterSettingsToAdd.add(CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE);
            cleanup();
        }
        Set<Setting<?>> clusterSettingsToAdd = new HashSet<>(BUILT_IN_CLUSTER_SETTINGS);
    public void testAddMultipleFilesToCache() {
            cleanup();
        setup();
            cleanup();
import org.opensearch.be.datafusion.cache.CacheUtils;
/*
            cacheManager.addFilesToCacheManager(List.of(fileName));
            cacheManager.removeFilesFromCacheManager(null);
            cacheManager.addFilesToCacheManager(Collections.emptyList());
        }
        setup();
            String fileName = getResourceFile("hits1.parquet");
import org.opensearch.be.datafusion.cache.CacheSettings;
import org.opensearch.common.settings.ClusterSettings;
        try {
        clusterSettingsToAdd.add(CacheSettings.COLUMN_INDEX_CACHE_PERCENT);
    }
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, clusterSettingsToAdd);
    }
    }
        } finally {
            return PathUtils.get(getClass().getClassLoader().getResource(fileName).toURI()).toString();
            List<String> fileNames = List.of(getResourceFile("hits1.parquet"), getResourceFile("hits2.parquet"));
        try {
            cleanup();
        clusterSettingsToAdd.add(CacheSettings.STATISTICS_CACHE_ENABLED);
        assertNotNull(cacheManager);
            cacheManager.addFilesToCacheManager(List.of(fileName));
    private String getResourceFile(String fileName) {
        } finally {
        clusterSettingsToAdd.add(CacheSettings.OFFSET_INDEX_CACHE_PERCENT);
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileNames.getFirst()));
            assertTrue(totalMemory >= 0);
    }
            assertTrue(cacheManager.getEntryFromCacheType(CacheUtils.CacheType.METADATA, fileNames.getLast()));
        } finally {
            long afterRemoveMemory = cacheManager.getTotalMemoryConsumed();
 * compatible open source license.
        clusterSettingsToAdd.add(CacheSettings.METADATA_CACHE_ENABLED);
        clusterSettingsToAdd.add(DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT);
    private void cleanup() {
        try {
        } finally {
            String fileName = getResourceFile("hits1.parquet");
        }
        } catch (URISyntaxException e) {
        service.start();
            cleanup();
        try {
        } finally {
            cleanup();
    }
            cacheManager.addFilesToCacheManager(List.of(fileName));
        clusterSettingsToAdd.add(DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT);
    public void testCacheClear() {
            cacheManager.addFilesToCacheManager(List.of(fileName));
    }
            assertTrue(cacheManager.getMemoryConsumed(CacheUtils.CacheType.METADATA) > 0);
        clusterSettingsToAdd.add(CacheSettings.OFFSET_INDEX_CACHE_EVICTION_TYPE);
    public void testExceptionHandlingWithInvalidFile() {
        clusterSettingsToAdd.add(CacheSettings.COLUMN_INDEX_CACHE_EVICTION_TYPE);
import java.net.URISyntaxException;

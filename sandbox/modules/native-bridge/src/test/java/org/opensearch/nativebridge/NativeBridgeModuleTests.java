     * <p>  
    public void testMemoryStatsMethodExists() {  
                // If we get here, the full native library with jemalloc is available
 * Tests that memoryStats() returns null when
 * When the library is not available, memoryStats() returns null (the "not loaded" path).
 *
                assertTrue("allocated bytes should be positive", stats.getAllocatedBytes() > 0);
import java.util.List;
            AnalyticsBackendNativeMemoryStats stats = module.memoryStats();
        Settings valid = Settings.builder().put("native.jemalloc.purge_threshold_percent", 50).build();  
     * <p>  
        assertEquals(4, settings.size());
 * class initialization fails. The tests are designed to handle both scenarios.
import org.opensearch.test.OpenSearchTestCase;  
    public void testGetSettingsReturnsAllSettings() {
    public void testPurgeThresholdPercentSettingDefaults() {
     * a full integration test environment), we verify delegation produces valid stats.  
        assertEquals(TimeValue.timeValueSeconds(5), defaultInterval);
    }  
                logger.info("NativeMemoryFetcher class init failed (expected in test env without jemalloc): {}", e.getMessage());  
 * this file be licensed under the Apache-2.0 license or a
            }
    public void testPurgeIntervalSettingDefaults() {  
        boolean libraryLoaded = NativeLibraryLoader.isLoaded();  
     * When NativeLibraryLoader.isLoaded() returns false, memoryStats() must return null.
        module.memoryStats();  
 * The OpenSearch Contributors require contributions made to  
/**
 */
    public void testPurgeThresholdPercentSettingBounds() {
    public void testMemoryStatsReturnsNullWhenLibraryNotLoaded() {
 * Note: In this test environment, the native library may or may not be available.
     * When it returns true, memoryStats() delegates to NativeMemoryFetcher.fetch().
 * Unit tests for {@link NativeBridgeModule}.
     * "not loaded" path returns null. If the library happens to be loaded (e.g., in
public class NativeBridgeModuleTests extends OpenSearchTestCase {  
            NativeBridgeModule.JEMALLOC_PURGE_THRESHOLD_PERCENT.get(invalid);  
            // Library is loaded — memoryStats() will attempt to delegate to NativeMemoryFetcher.
        expectThrows(IllegalArgumentException.class, () -> {
                assertNotNull("memoryStats() should return non-null when library is fully loaded", stats);  
        if (!libraryLoaded) {
            } catch (NoClassDefFoundError | ExceptionInInitializerError e) {  
        assertEquals("native.jemalloc.dirty_decay_ms", settings.get(0).getKey());  
/*  
            // Library not loaded — memoryStats() should return null without touching NativeMemoryFetcher  
        } else {
 * <p>  
import org.opensearch.common.settings.Setting;
        int defaultPercent = NativeBridgeModule.JEMALLOC_PURGE_THRESHOLD_PERCENT.getDefault(Settings.EMPTY);  
    }
        // Above max should throw  
            NativeBridgeModule module = new NativeBridgeModule();
        NativeBridgeModule module = new NativeBridgeModule();
     * In this test environment without the native library symbols, we verify the
            Settings invalid = Settings.builder().put("native.jemalloc.purge_threshold_percent", -1).build();
        assertEquals("native.jemalloc.muzzy_decay_ms", settings.get(1).getKey());
            assertNull("memoryStats() should return null when native library is not loaded", stats);  
    }
    }
        assertEquals(85, defaultPercent);
        assertEquals("native.jemalloc.purge_threshold_percent", settings.get(3).getKey());  
            try {  
     */
        NativeBridgeModule module = new NativeBridgeModule();  
import org.opensearch.common.settings.Settings;
                assertTrue("resident bytes should be positive", stats.getResidentBytes() > 0);
            NativeBridgeModule module = new NativeBridgeModule();
 * <p>  
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;
        // Just verifies the method is callable; result depends on native library availability
        }
            // If jemalloc symbols are available, it returns valid stats.  
    }
        // Below min should throw  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.nativebridge;
            // If symbols are missing, NativeMemoryFetcher class init fails with NoClassDefFoundError.
                // in test environments where the Rust library is built without jemalloc
            NativeBridgeModule.JEMALLOC_PURGE_THRESHOLD_PERCENT.get(invalid);  
                AnalyticsBackendNativeMemoryStats stats = module.memoryStats();
        expectThrows(IllegalArgumentException.class, () -> {
    /**
        List<Setting<?>> settings = module.getSettings();
        assertEquals("native.jemalloc.purge_interval", settings.get(2).getKey());
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
    }  
}
 * the native library is not loaded, and delegates to NativeMemoryFetcher when loaded.
 * When the library IS available but jemalloc symbols are missing, NativeMemoryFetcher  
 * compatible open source license.
            Settings invalid = Settings.builder().put("native.jemalloc.purge_threshold_percent", 101).build();
        assertEquals(50, (int) NativeBridgeModule.JEMALLOC_PURGE_THRESHOLD_PERCENT.get(valid));
        });
     * Tests the memoryStats() contract based on library availability.
        });
 */  
        // Valid range: 0-100
        TimeValue defaultInterval = NativeBridgeModule.JEMALLOC_PURGE_INTERVAL.getDefault(Settings.EMPTY);
import org.opensearch.common.unit.TimeValue;  
                // Library loaded but jemalloc symbols not available — this is expected

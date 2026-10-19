        assertEquals(1.0, new BlockCacheFoyerPlugin(Settings.EMPTY).dataToCapacityRatio(s), 0.0);
    }
        // Uses cluster.filecache.remote_data_ratio — the canonical server-side setting
        Environment environment = mock(Environment.class);
    }
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
        assertTrue("createComponents must return empty when flag is disabled", result.isEmpty());
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
        when(clusterService.getSettings()).thenReturn(Settings.EMPTY);
import org.opensearch.common.util.FeatureFlags;
    public void testDataToCapacityRatioDefault() {  
 *
            .put(FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.getKey(), new ByteSizeValue(2, ByteSizeUnit.MB))  
    public void testRequestedCapacityBytesNonNegative() {  
import static org.mockito.Mockito.when;
        assertNotNull(plugin);
            null,
        Settings s = Settings.builder().put("block_cache.foyer.size", "50%").build();
    }
 */  
    }  
        plugin.close();
        plugin.setReservedCapacityBytes(new ByteSizeValue(10, ByteSizeUnit.GB).getBytes());
 * Unit tests for {@link BlockCacheFoyerPlugin}.
        // block_size (2MB) >= disk budget (1MB) should throw SettingsException
    }
        ClusterService clusterService = mock(ClusterService.class);
    // flag is OFF by default — no @LockFeatureFlag annotation needed
    public void testDataToCapacityRatioCustom() {
    }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
import java.util.List;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        // Uses cluster.filecache.remote_data_ratio — the canonical server-side setting
    }
        assertNotNull(new BlockCacheFoyerPlugin(Settings.EMPTY).getBlockCache());
import org.opensearch.test.OpenSearchTestCase.LockFeatureFlag;
    public void testNoArgConstructor() {  
    public void testGetSettingsNoNulls() {  
 */
        assertTrue(plugin.getBlockCache().isEmpty());  
        // Explicitly verify cluster.filecache.remote_data_ratio drives the ratio
            null,
    public void testGetSettingsIsStable() {  
    // ── setReservedCapacityBytes ──────────────────────────────────────────────
            null  
            null,  
        plugin.close();  
    public void testRequestedCapacityBytesDefault50Percent() {
        Settings s = Settings.builder().put("cluster.filecache.remote_data_ratio", "1.0").build();  
            SettingsException.class,  
    }  
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
        when(environment.dataFiles()).thenReturn(new Path[] { createTempDir() });
        Environment environment = mock(Environment.class);
        expectThrows(
        assertEquals(250L, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(s, 1000L));  
            null,
    }
import org.opensearch.core.common.unit.ByteSizeValue;
    // ── Constructor + getBlockCache ───────────────────────────────────────────
    public void testSettingsConstructor() {  
    }  
        long budget = 1_000_000L;
        assertEquals(0L, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(s, 1000L));  
    }  
        assertTrue("handle is empty before createComponents", plugin.getBlockCache().isEmpty());  
        assertTrue(settings.contains(FoyerBlockCacheSettings.CACHE_SIZE_SETTING));
    public void testDataToCapacityRatioAtLeastOne() {  
        Settings s = Settings.builder().put("block_cache.foyer.size", "0.25").build();
    }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        assertEquals(10.0, new BlockCacheFoyerPlugin(Settings.EMPTY).dataToCapacityRatio(s), 0.0);
        java.util.Collection<Object> result = plugin.createComponents(
            null,
    // ── getSettings ───────────────────────────────────────────────────────────
 * dataToCapacityRatio, getSettings, and lifecycle guards — all without the native
        new BlockCacheFoyerPlugin(Settings.EMPTY).close();
    }
            null,
    public void testRequestedCapacityBytesIsZeroWhenPluggableDataformatDisabled() {
        assertTrue(settings.contains(FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING));
        when(environment.dataFiles()).thenReturn(new Path[] { createTempDir() });  
/**
import org.opensearch.common.settings.Settings;  
    public void testRequestedCapacityBytesRoundsCorrectly() {
        assertTrue(new BlockCacheFoyerPlugin(Settings.EMPTY).dataToCapacityRatio(Settings.EMPTY) >= 1.0);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
        plugin.setReservedCapacityBytes(200L * 1024 * 1024 * 1024);
    public void testDataToCapacityRatioMinimumOf1() {
 * The OpenSearch Contributors require contributions made to  
        long result = new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(Settings.EMPTY, 1_000_000L);
        long budget = 100L * 1024 * 1024 * 1024;  
    public void testGetSettingsRegistersAllSettings() {
    }
        // no longer contains it, so it must not affect dataToCapacityRatio  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            assertNotNull(s);
        plugin.setReservedCapacityBytes(new ByteSizeValue(1, ByteSizeUnit.MB).getBytes());  
            null,  
    // ── requestedCapacityBytes ────────────────────────────────────────────────
import static org.mockito.Mockito.mock;
        assertTrue(settings.contains(FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING));  
        assertEquals(500L, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(s, 1000L));  
        assertNotNull(plugin);
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
        assertTrue(settings.contains(FoyerBlockCacheSettings.BLOCK_SIZE_SETTING));  
    public void testRequestedCapacityBytesDoesNotExceedBudget() {  
        assertEquals(7.0, new BlockCacheFoyerPlugin(Settings.EMPTY).dataToCapacityRatio(s), 0.0);
    }
            clusterService,  
        assertEquals(33L, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(s, 100L));  
    public void testCloseIsIdempotent() throws IOException {
import org.opensearch.cluster.service.ClusterService;
    }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
    }
import org.opensearch.common.settings.SettingsException;
    public void testRequestedCapacityBytesZeroBudget() {
 * this file be licensed under the Apache-2.0 license or a
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(settings);
        Settings s = Settings.builder().put("cluster.filecache.remote_data_ratio", "10.0").build();  
        }  
    public void testSetReservedCapacityBytesDoesNotThrow() {  
 * compatible open source license.
/*  
    }
    public void testCloseWithNoCacheDoesNotThrow() throws IOException {  
    public void testDataToCapacityRatioIgnoresRemovedSetting() {
        assertTrue(settings.contains(FoyerBlockCacheSettings.IO_ENGINE_SETTING));
        assertTrue(settings.contains(FoyerBlockCacheSettings.KEY_INDEX_PERSIST_INTERVAL_SETTING));
 *  
            .build();
    public void testRequestedCapacityBytesDecimalRatioForm() {
        assertTrue(new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(Settings.EMPTY, budget) <= budget);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        );
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
        assertEquals(0L, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(Settings.EMPTY, budget));
import java.io.IOException;  
        // block_cache.foyer.data_to_cache_ratio is removed — the plugin-owned setting list
    }
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
    // ── dataToCapacityRatio ───────────────────────────────────────────────────
        List<Setting<?>> settings = plugin.getSettings();  
        Settings s = Settings.builder().put("block_cache.foyer.size", "0%").build();
        assertTrue("getBlockCache must be empty when flag is disabled", plugin.getBlockCache().isEmpty());  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
    public void testCreateComponentsThrowsWhenBlockSizeExceedsDiskBudget() {  
import org.opensearch.env.Environment;
package org.opensearch.blockcache.foyer;
 * library.  
    }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
            null,
import java.nio.file.Path;
        when(clusterService.getSettings()).thenReturn(settings);  
    public void testGetBlockCacheReturnsNonNullOptional() {  
        List<Setting<?>> pluginSettings = new BlockCacheFoyerPlugin(Settings.EMPTY).getSettings();
        Settings settings = Settings.builder()
import org.opensearch.test.OpenSearchTestCase;  
        Settings s = Settings.builder().put("block_cache.foyer.size", "33%").build();
        assertTrue(result >= 0);
        assertTrue(settings.contains(FoyerBlockCacheSettings.KEY_INDEX_SWEEP_INTERVAL_SETTING));
import org.opensearch.common.settings.Setting;
    }  
    }  
 * Covers constructor variants, getBlockCache lifecycle, requestedCapacityBytes,
        assertTrue(settings.contains(FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING));  
        assertEquals(0L, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(Settings.EMPTY, 0L));
        );
            environment,
    }
        Settings s = Settings.builder().put("cluster.filecache.remote_data_ratio", "7.0").build();  
        boolean hasOldSetting = pluginSettings.stream().anyMatch(s -> s.getKey().equals("block_cache.foyer.data_to_cache_ratio"));
        long budget = 800L * 1024 * 1024 * 1024;
        assertEquals(5.0, new BlockCacheFoyerPlugin(Settings.EMPTY).dataToCapacityRatio(Settings.EMPTY), 0.0);
            () -> plugin.createComponents(null, clusterService, null, null, null, null, environment, null, null, null, null)
        assertEquals(10, settings.size());
    }
import org.opensearch.core.common.unit.ByteSizeUnit;  
    public void testDataToCapacityRatioUsesFileCacheRatioSetting() {
    }
 * SPDX-License-Identifier: Apache-2.0
        for (Setting<?> s : new BlockCacheFoyerPlugin(Settings.EMPTY).getSettings()) {
    public void testRequestedCapacityBytesZeroPercent() {
}
    public void testRequestedCapacityBytes50Percent() {
    // ── Lifecycle guards ──────────────────────────────────────────────────────
    public void testCreateComponentsReturnsEmptyWhenPluggableDataformatDisabled() throws IOException {  
        ClusterService clusterService = mock(ClusterService.class);
public class BlockCacheFoyerPluginTests extends OpenSearchTestCase {
        assertFalse("Removed setting must not be registered by the plugin", hasOldSetting);  
        assertEquals(400L * 1024 * 1024 * 1024, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(Settings.EMPTY, budget));  
        assertTrue(plugin.getSettings().containsAll(plugin.getSettings()));
    }

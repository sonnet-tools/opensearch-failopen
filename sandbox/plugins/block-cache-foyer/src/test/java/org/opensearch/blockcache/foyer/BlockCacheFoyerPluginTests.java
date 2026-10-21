        assertTrue(settings.contains(FoyerBlockCacheSettings.BLOCK_SIZE_SETTING));
        assertNotNull(new BlockCacheFoyerPlugin(Settings.EMPTY).getBlockCache());
        );
    public void testRequestedCapacityBytesIsZeroWhenPluggableDataformatDisabled() {
            .build();
 *
            SettingsException.class,
    // ── requestedCapacityBytes ────────────────────────────────────────────────
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(settings);
        ClusterService clusterService = mock(ClusterService.class);
        assertTrue(result >= 0);
            assertNotNull(s);
    }
    public void testDataToCapacityRatioUsesFileCacheRatioSetting() {
public class BlockCacheFoyerPluginTests extends OpenSearchTestCase {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testDataToCapacityRatioCustom() {
        assertEquals(500L, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(s, 1000L));
    public void testCloseIsIdempotent() throws IOException {
        assertNotNull(plugin);
    }
    public void testSetReservedCapacityBytesDoesNotThrow() {
    }
        plugin.setReservedCapacityBytes(new ByteSizeValue(1, ByteSizeUnit.MB).getBytes());
        assertEquals(0L, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(s, 1000L));
        assertTrue("createComponents must return empty when flag is disabled", result.isEmpty());
    }
        long budget = 800L * 1024 * 1024 * 1024;
    }
        assertEquals(250L, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(s, 1000L));
import org.opensearch.common.util.FeatureFlags;
        assertTrue(settings.contains(FoyerBlockCacheSettings.CACHE_SIZE_SETTING));
    public void testGetSettingsNoNulls() {
        assertNotNull(plugin);
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        when(clusterService.getSettings()).thenReturn(settings);
    public void testNoArgConstructor() {
 *
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
        // Explicitly verify cluster.filecache.remote_data_ratio drives the ratio
    public void testDataToCapacityRatioIgnoresRemovedSetting() {
        List<Setting<?>> settings = plugin.getSettings();
    }
        plugin.setReservedCapacityBytes(200L * 1024 * 1024 * 1024);
    }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
 * Unit tests for {@link BlockCacheFoyerPlugin}.
        assertEquals(400L * 1024 * 1024 * 1024, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(Settings.EMPTY, budget));
    public void testSettingsConstructor() {
import java.util.List;
import java.io.IOException;
/**
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertEquals(0L, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(Settings.EMPTY, budget));
import java.nio.file.Path;
        assertTrue(settings.contains(FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING));
        assertEquals(10, settings.size());
    }
        // block_cache.foyer.data_to_cache_ratio is removed — the plugin-owned setting list
        assertTrue(plugin.getSettings().containsAll(plugin.getSettings()));
    public void testRequestedCapacityBytesDoesNotExceedBudget() {
import org.opensearch.test.OpenSearchTestCase.LockFeatureFlag;
        assertTrue(new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(Settings.EMPTY, budget) <= budget);
        Environment environment = mock(Environment.class);
import org.opensearch.common.settings.Settings;
    }
            null,
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
        Settings s = Settings.builder().put("cluster.filecache.remote_data_ratio", "10.0").build();
        );
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
        long budget = 1_000_000L;
        assertTrue("handle is empty before createComponents", plugin.getBlockCache().isEmpty());
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
    // ── Lifecycle guards ──────────────────────────────────────────────────────
            environment,
import org.opensearch.common.settings.Setting;
        assertEquals(33L, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(s, 100L));
    public void testRequestedCapacityBytesZeroBudget() {
        Settings s = Settings.builder().put("block_cache.foyer.size", "0.25").build();
    }
        assertTrue(settings.contains(FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING));
import org.opensearch.common.settings.SettingsException;
        assertFalse("Removed setting must not be registered by the plugin", hasOldSetting);
}
            null,
    }
        boolean hasOldSetting = pluginSettings.stream().anyMatch(s -> s.getKey().equals("block_cache.foyer.data_to_cache_ratio"));
    public void testDataToCapacityRatioDefault() {
    // flag is OFF by default — no @LockFeatureFlag annotation needed
        assertTrue(new BlockCacheFoyerPlugin(Settings.EMPTY).dataToCapacityRatio(Settings.EMPTY) >= 1.0);
import org.opensearch.core.common.unit.ByteSizeValue;
        Settings s = Settings.builder().put("block_cache.foyer.size", "50%").build();
    }
    }
        assertEquals(10.0, new BlockCacheFoyerPlugin(Settings.EMPTY).dataToCapacityRatio(s), 0.0);
 */
        assertEquals(1.0, new BlockCacheFoyerPlugin(Settings.EMPTY).dataToCapacityRatio(s), 0.0);
        assertTrue(settings.contains(FoyerBlockCacheSettings.IO_ENGINE_SETTING));
    // ── getSettings ───────────────────────────────────────────────────────────
package org.opensearch.blockcache.foyer;
    // ── dataToCapacityRatio ───────────────────────────────────────────────────
    }
    }
        // Uses cluster.filecache.remote_data_ratio — the canonical server-side setting
import static org.mockito.Mockito.mock;
        plugin.close();
import org.opensearch.cluster.service.ClusterService;
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
    public void testGetSettingsRegistersAllSettings() {
    public void testCreateComponentsThrowsWhenBlockSizeExceedsDiskBudget() {
        // block_size (2MB) >= disk budget (1MB) should throw SettingsException
    }
        assertEquals(0L, new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(Settings.EMPTY, 0L));
 * SPDX-License-Identifier: Apache-2.0
 * dataToCapacityRatio, getSettings, and lifecycle guards — all without the native
    }
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
        Settings s = Settings.builder().put("cluster.filecache.remote_data_ratio", "7.0").build();
            null,
            null,
            null,
    }
        expectThrows(
import org.opensearch.test.OpenSearchTestCase;
    public void testGetBlockCacheReturnsNonNullOptional() {
            null,
        long result = new BlockCacheFoyerPlugin(Settings.EMPTY).requestedCapacityBytes(Settings.EMPTY, 1_000_000L);
        assertTrue(settings.contains(FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING));
        ClusterService clusterService = mock(ClusterService.class);
        Settings settings = Settings.builder()
        // Uses cluster.filecache.remote_data_ratio — the canonical server-side setting
    public void testCreateComponentsReturnsEmptyWhenPluggableDataformatDisabled() throws IOException {
    }
    // ── setReservedCapacityBytes ──────────────────────────────────────────────
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import org.opensearch.env.Environment;
        plugin.close();
        assertEquals(5.0, new BlockCacheFoyerPlugin(Settings.EMPTY).dataToCapacityRatio(Settings.EMPTY), 0.0);
        }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testRequestedCapacityBytesRoundsCorrectly() {
        when(clusterService.getSettings()).thenReturn(Settings.EMPTY);
            clusterService,
        Settings s = Settings.builder().put("cluster.filecache.remote_data_ratio", "1.0").build();
    }
    }
 * Covers constructor variants, getBlockCache lifecycle, requestedCapacityBytes,
import static org.mockito.Mockito.when;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        java.util.Collection<Object> result = plugin.createComponents(
 * compatible open source license.
    }
        Environment environment = mock(Environment.class);
            null,
        long budget = 100L * 1024 * 1024 * 1024;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertTrue(settings.contains(FoyerBlockCacheSettings.KEY_INDEX_PERSIST_INTERVAL_SETTING));
    public void testRequestedCapacityBytesNonNegative() {
        assertTrue("getBlockCache must be empty when flag is disabled", plugin.getBlockCache().isEmpty());
        assertTrue(settings.contains(FoyerBlockCacheSettings.KEY_INDEX_SWEEP_INTERVAL_SETTING));
            null,
        BlockCacheFoyerPlugin plugin = new BlockCacheFoyerPlugin(Settings.EMPTY);
        Settings s = Settings.builder().put("block_cache.foyer.size", "33%").build();
    // ── Constructor + getBlockCache ───────────────────────────────────────────
/*
    }
 * library.
    public void testDataToCapacityRatioAtLeastOne() {
        // no longer contains it, so it must not affect dataToCapacityRatio
    }
        assertEquals(7.0, new BlockCacheFoyerPlugin(Settings.EMPTY).dataToCapacityRatio(s), 0.0);
    }
    public void testRequestedCapacityBytesZeroPercent() {
    public void testRequestedCapacityBytes50Percent() {
    public void testCloseWithNoCacheDoesNotThrow() throws IOException {
    public void testRequestedCapacityBytesDecimalRatioForm() {
        when(environment.dataFiles()).thenReturn(new Path[] { createTempDir() });
            null
 * this file be licensed under the Apache-2.0 license or a
    public void testRequestedCapacityBytesDefault50Percent() {
        plugin.setReservedCapacityBytes(new ByteSizeValue(10, ByteSizeUnit.GB).getBytes());
        List<Setting<?>> pluginSettings = new BlockCacheFoyerPlugin(Settings.EMPTY).getSettings();
    public void testGetSettingsIsStable() {
            .put(FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.getKey(), new ByteSizeValue(2, ByteSizeUnit.MB))
        new BlockCacheFoyerPlugin(Settings.EMPTY).close();
 * The OpenSearch Contributors require contributions made to
    public void testDataToCapacityRatioMinimumOf1() {
        when(environment.dataFiles()).thenReturn(new Path[] { createTempDir() });
    }
 */
        Settings s = Settings.builder().put("block_cache.foyer.size", "0%").build();
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertTrue(plugin.getBlockCache().isEmpty());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        for (Setting<?> s : new BlockCacheFoyerPlugin(Settings.EMPTY).getSettings()) {
            () -> plugin.createComponents(null, clusterService, null, null, null, null, environment, null, null, null, null)

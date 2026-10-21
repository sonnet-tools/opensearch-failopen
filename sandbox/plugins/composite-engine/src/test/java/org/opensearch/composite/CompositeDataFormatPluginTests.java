        Settings settings = Settings.builder().put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet").build();
                .putList("index.composite.secondary_data_formats", "parquet")
    public void testIndexSettingProviderSkipsPrimaryWhenAlreadySet() {
        // createComponents has not run, so clusterService is null and the provider must
        );
    public void testPrimaryDataFormatDefaultsToParquet() {
        Map<String, Supplier<DataFormatDescriptor>> descriptors = plugin.getFormatDescriptors(indexSettings, registry);
    }
    }
        Settings requestOrTemplate = Settings.builder()
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        setClusterServiceField(plugin, clusterService);
    }
    }
        assertTrue(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(first).isEmpty());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        injectClusterService(plugin, clusterBag);
    public void testGetSettingsReturnsAllFourSettings() {
        Settings settings = Settings.builder()
        assertEquals(1, result.size());
            .build();
    public void testSecondaryDataFormatsReadsExplicitList() {
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        assertEquals(List.of("parquet", "arrow"), CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.get(settings));
        Settings settings = Settings.builder()
            .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "parquet")
        return providers.iterator().next();
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        Settings first = provider.getAdditionalIndexSettings("idx-1", false, Settings.EMPTY);
    }
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
    public void testIndexSettingProviderReturnsEmptyBeforeCreateComponents() {
        when(registry.format("lucene")).thenReturn(CompositeTestHelper.stubFormat("lucene", 1, java.util.Set.of()));
        assertEquals(1, result.size());
        when(registry.format("parquet")).thenReturn(parquetFormat);
    private static void setClusterServiceField(CompositeDataFormatPlugin plugin, ClusterService clusterService) {
            )
    public void testClusterDefaultSecondaryDataFormatsReadsExplicitList() {
            .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "arrow")
        DataFormat luceneFormat = CompositeTestHelper.stubFormat("lucene", 1, java.util.Set.of());
        Settings requestOrTemplate = Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "lucene").build();
            )
        Settings requestOrTemplate = Settings.builder()
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        assertTrue(settings.contains(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT));
    // ---- Helpers ----
            .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "arrow")
    public void testGetStoreStrategiesCollectsFromPrimaryPlugin() {
        assertTrue("Should return empty when lucene sub-plugin not found", result.isEmpty());
        assertEquals("parquet", CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(settings));
            .build();
            .build();
        Collection<IndexSettingProvider> providers = plugin.getAdditionalIndexSettingProviders();
        Settings out = provider.getAdditionalIndexSettings("some-index", false, Settings.EMPTY);
 * SPDX-License-Identifier: Apache-2.0
                CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS,
        assertEquals(List.of("arrow"), CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(out));
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        assertEquals(6, settings.size());
    // ---- Existing getFormatDescriptors coverage ----
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
 */
import java.util.List;
                .put("index.composite.primary_data_format", "lucene")
        IndexSettingProvider provider = singleProvider(plugin);
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
    public void testGetStoreStrategiesEmptyWhenNoSubPlugins() {
                IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST
    }
        assertEquals("parquet", CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(Settings.EMPTY));
        IndexSettingProvider provider = singleProvider(plugin);
import org.opensearch.index.IndexSettings;
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            .put(extra)
/**
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet")
    }
        Settings second = provider.getAdditionalIndexSettings("idx-2", false, Settings.EMPTY);
 */
        Map<DataFormat, StoreStrategy> result = plugin.getStoreStrategies(indexSettings, registry);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
                )
        // Simulate a PUT /_cluster/settings updating the dynamic cluster defaults.
    }
        );
            .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "arrow")
import org.opensearch.test.OpenSearchTestCase;
    }
        assertEquals("parquet", CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.get(Settings.EMPTY));
    }
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        assertSame(parquetStrategy, result.get(parquetFormat));
import java.util.function.Supplier;
        Settings clusterBag = Settings.builder()
        IndexSettings indexSettings = buildIndexSettings(
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        Settings clusterBag = Settings.builder()
    private static IndexSettingProvider singleProvider(CompositeDataFormatPlugin plugin) {
        ClusterService clusterService = mock(ClusterService.class);
        // Provider contributes nothing when both settings are already explicit.
        assertTrue(settings.contains(CompositeDataFormatPlugin.CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING));
            Set.of(
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        assertEquals(List.of("arrow"), CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(second));
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        Settings out = provider.getAdditionalIndexSettings("some-index", false, requestOrTemplate);
    }
    }
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        assertEquals(List.of("parquet", "arrow"), CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(settings));
        assertTrue(descriptors.isEmpty());
            .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "arrow")
    public void testGetFormatDescriptorsDelegatestoPlugins() {
    }
    public void testClusterDefaultPrimaryDataFormatDefaultsToParquet() {
        assertEquals(Settings.EMPTY, out);
        when(registry.format("parquet")).thenReturn(parquetFormat);
            .build();
    }
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
            .build();
        Map<DataFormat, StoreStrategy> result = plugin.getStoreStrategies(indexSettings, registry);
        IndexSettings indexSettings = buildIndexSettings(
import org.opensearch.index.engine.dataformat.StoreStrategy;
        IndexSettings indexSettings = buildIndexSettings(Settings.builder().put("index.composite.primary_data_format", "parquet").build());
    }
        // contribute nothing rather than NPE — allowing fallback to per-setting defaults.
            .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "parquet")
import org.opensearch.Version;
import java.util.Set;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        plugin.createComponents(null, clusterService, null, null, null, null, null, null, null, null, null);
        when(registry.getStoreStrategies(indexSettings, luceneFormat)).thenReturn(Map.of());
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        // Seed cluster settings with empty defaults, then flip them and verify the provider
    public void testClusterDefaultSecondaryDataFormatsDefaultsToEmpty() {
import org.opensearch.common.settings.Setting;
        return new IndexSettings(indexMetadata, Settings.EMPTY);
    public void testIndexSettingProviderReadsLiveClusterSettingsOnEachCall() {
        assertEquals(1, descriptors.size());
                .build()
        assertFalse(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.exists(out));
        assertTrue(settings.contains(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS));
        List<Setting<?>> settings = plugin.getSettings();
        Settings clusterBag = Settings.builder()
        assertSame(parquetStrategy, result.get(parquetFormat));
                CompositeDataFormatPlugin.CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING,
        assertTrue(descriptors.containsKey("parquet"));
        IndexSettings indexSettings = buildIndexSettings(Settings.EMPTY);
                .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "arrow")
            .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet")
import org.opensearch.cluster.service.ClusterService;
                CompositeDataFormatPlugin.CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING,
            .build();
    }
import org.opensearch.common.settings.ClusterSettings;
        when(registry.getStoreStrategies(indexSettings, parquetFormat)).thenReturn(Map.of(parquetFormat, parquetStrategy));
        ClusterSettings clusterSettings = new ClusterSettings(
        assertEquals("parquet", descriptors.get("parquet").get().getFormatName());
            Map.of(
        when(registry.format("parquet")).thenReturn(parquetFormat);
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
    public void testIndexSettingProviderSkipsBothWhenBothAlreadySet() {
    public void testSecondaryDataFormatsDefaultsToEmpty() {
        ClusterSettings clusterSettings = new ClusterSettings(
/*
import java.util.Collection;
    }
        assertTrue("Should return empty when no sub-plugin found", result.isEmpty());
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        Map<DataFormat, StoreStrategy> result = plugin.getStoreStrategies(indexSettings, registry);
        assertTrue(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.get(Settings.EMPTY).isEmpty());
        injectClusterService(plugin, clusterBag);
        assertEquals("parquet", CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(out));
                CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT,
        );
        Settings out = provider.getAdditionalIndexSettings("some-index", false, Settings.EMPTY);
            Settings.builder()
            .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "parquet", "arrow")
            Settings.builder()
        DataFormat parquetFormat = CompositeTestHelper.stubFormat("parquet", 2, java.util.Set.of());
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        ClusterService clusterService = mock(ClusterService.class);
            )
                .build()
        StoreStrategy parquetStrategy = mock(StoreStrategy.class);
 *
        IndexSettingProvider provider = singleProvider(plugin);
                IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST
        // picks up the new values on the next call without any re-init of the plugin.
            .build();
        when(registry.getStoreStrategies(indexSettings, parquetFormat)).thenReturn(Map.of());
        DataFormat parquetFormat = CompositeTestHelper.stubFormat("parquet", 2, java.util.Set.of());
    private static IndexSettings buildIndexSettings(Settings extra) {
        IndexSettingProvider provider = singleProvider(plugin);
    public void testIndexSettingProviderSkipsSecondaryWhenAlreadySet() {
        when(registry.format("lucene")).thenReturn(luceneFormat);
    // ---- Setting registration ----
        when(registry.getStoreStrategies(indexSettings, luceneFormat)).thenReturn(Map.of());
        assertEquals(List.of("arrow"), CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(out));
        IndexSettingProvider provider = singleProvider(plugin);
                .build()
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
                .putList("index.composite.secondary_data_formats", "parquet")
        IndexSettings indexSettings = buildIndexSettings(Settings.builder().put("index.composite.primary_data_format", "parquet").build());
        IndexSettingProvider provider = singleProvider(plugin);
            .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "parquet", "arrow")
        DataFormat parquetFormat = CompositeTestHelper.stubFormat("parquet", 2, java.util.Set.of());
    public void testGetStoreStrategiesEmptyForDefaultPrimaryWithoutPlugin() {
    }
        assertFalse(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.exists(out));
        injectClusterService(plugin, clusterBag);
        assertTrue(settings.contains(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT));
        assertTrue(settings.contains(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS));
    public void testPrimaryDataFormatReadsExplicitValue() {
        Settings out = provider.getAdditionalIndexSettings("some-index", false, requestOrTemplate);
        assertEquals("parquet", CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(first));
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        when(registry.getStoreStrategies(indexSettings, parquetFormat)).thenReturn(Map.of(parquetFormat, parquetStrategy));
            Settings.EMPTY,
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        Settings clusterBag = Settings.builder()
        DataFormat luceneFormat = CompositeTestHelper.stubFormat("lucene", 1, java.util.Set.of());
            .build();
        when(registry.getFormatDescriptors(indexSettings, parquetFormat)).thenReturn(
import org.opensearch.index.shard.IndexSettingProvider;
                    "parquet",
    // ---- Setting defaults and value parsing ----
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        when(registry.format("lucene")).thenReturn(luceneFormat);
import static org.mockito.Mockito.when;
    }
            clusterBag,
    public void testClusterDefaultPrimaryDataFormatReadsExplicitValue() {
package org.opensearch.composite;
        clusterSettings.applySettings(
        Map<String, Supplier<DataFormatDescriptor>> descriptors = plugin.getFormatDescriptors(indexSettings, registry);
        assertEquals(1, providers.size());
                (Supplier<DataFormatDescriptor>) () -> new DataFormatDescriptor(
        assertEquals("parquet", CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(out));
                    new org.opensearch.index.store.checksum.GenericCRC32ChecksumHandler()
 * compatible open source license.
            .build();
    private static void injectClusterService(CompositeDataFormatPlugin plugin, Settings clusterBag) {
        StoreStrategy parquetStrategy = mock(StoreStrategy.class);
        assertEquals("parquet", CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.get(settings));
        when(registry.format("parquet")).thenReturn(parquetFormat);
 * The OpenSearch Contributors require contributions made to
                CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS,
        Map<DataFormat, StoreStrategy> result = plugin.getStoreStrategies(indexSettings, registry);
            .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet")
    }
        injectClusterService(plugin, clusterBag);
}
        );
    }
                .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet")
                CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT,
import org.opensearch.index.engine.dataformat.DataFormat;
                "parquet",
    }
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.mock;
    }
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;
 * Tests for {@link CompositeDataFormatPlugin}.
        Settings settings = Settings.builder()
                .put("index.composite.primary_data_format", "lucene")
        assertTrue(settings.contains(CompositeDataFormatPlugin.MERGE_ON_REFRESH_MAX_SIZE));
        setClusterServiceField(plugin, clusterService);
        Settings settings = Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet").build();
        IndexSettings indexSettings = buildIndexSettings(Settings.EMPTY);
            .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet")
            Settings.builder()
        );
        assertEquals("parquet", CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(second));
    }
    public void testIndexSettingProviderStampsBothClusterDefaultsWhenIndexLevelAbsent() {
        Settings out = provider.getAdditionalIndexSettings("some-index", false, requestOrTemplate);
            Set.of(
import java.util.Map;
    public void testGetFormatDescriptorsEmptyWhenNoPluginsMatch() {
import org.opensearch.indices.IndicesService;
import org.opensearch.common.settings.Settings;
        assertTrue(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(Settings.EMPTY).isEmpty());
public class CompositeDataFormatPluginTests extends OpenSearchTestCase {
    // ---- IndexSettingProvider behavior ----
            .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "lucene")
        DataFormat parquetFormat = CompositeTestHelper.stubFormat("parquet", 2, java.util.Set.of());
    public void testGetStoreStrategiesCollectsPrimaryAndSecondary() {
        assertEquals(Settings.EMPTY, out);

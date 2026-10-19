        when(registry.getStoreStrategies(indexSettings, luceneFormat)).thenReturn(Map.of());
            .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "parquet")
import org.opensearch.test.OpenSearchTestCase;
        // createComponents has not run, so clusterService is null and the provider must
        Map<DataFormat, StoreStrategy> result = plugin.getStoreStrategies(indexSettings, registry);
            Settings.builder()
        assertTrue("Should return empty when lucene sub-plugin not found", result.isEmpty());
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;  
        when(registry.format("parquet")).thenReturn(parquetFormat);
                "parquet",
        DataFormat luceneFormat = CompositeTestHelper.stubFormat("lucene", 1, java.util.Set.of());
            )  
/**
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import java.util.function.Supplier;
        IndexSettingProvider provider = singleProvider(plugin);  
    }
            .build();  
import org.opensearch.common.settings.ClusterSettings;
            )
        assertEquals("parquet", CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(out));  
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();  
        Settings settings = Settings.builder()
    private static void setClusterServiceField(CompositeDataFormatPlugin plugin, ClusterService clusterService) {  
package org.opensearch.composite;
                CompositeDataFormatPlugin.CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING,
        ClusterSettings clusterSettings = new ClusterSettings(
 * compatible open source license.
        assertTrue(settings.contains(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS));
        plugin.createComponents(null, clusterService, null, null, null, null, null, null, null, null, null);
 * The OpenSearch Contributors require contributions made to  
        IndexSettingProvider provider = singleProvider(plugin);  
            .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "lucene")
    public void testIndexSettingProviderSkipsPrimaryWhenAlreadySet() {
    }  
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
                .build()
        Collection<IndexSettingProvider> providers = plugin.getAdditionalIndexSettingProviders();
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
            .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet")
    // ---- Setting defaults and value parsing ----
        Settings settings = Settings.builder()
    public void testIndexSettingProviderStampsBothClusterDefaultsWhenIndexLevelAbsent() {
    }
    public void testIndexSettingProviderSkipsBothWhenBothAlreadySet() {
    }  
            .build();  
public class CompositeDataFormatPluginTests extends OpenSearchTestCase {
    }
            .build();
 * Tests for {@link CompositeDataFormatPlugin}.
        assertFalse(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.exists(out));
        assertTrue(settings.contains(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT));  
import org.opensearch.Version;
        // picks up the new values on the next call without any re-init of the plugin.
        Map<DataFormat, StoreStrategy> result = plugin.getStoreStrategies(indexSettings, registry);
            Settings.builder()
        assertEquals(Settings.EMPTY, out);
        // Simulate a PUT /_cluster/settings updating the dynamic cluster defaults.  
            .build();
        assertTrue(descriptors.containsKey("parquet"));
    public void testIndexSettingProviderSkipsSecondaryWhenAlreadySet() {  
        assertEquals("parquet", CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(second));  
    }
    // ---- Setting registration ----  
        Settings settings = Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet").build();  
        assertTrue(settings.contains(CompositeDataFormatPlugin.MERGE_ON_REFRESH_MAX_SIZE));
        IndexSettingProvider provider = singleProvider(plugin);  
    }
        IndexSettings indexSettings = buildIndexSettings(Settings.EMPTY);
        Settings clusterBag = Settings.builder()  
    private static IndexSettings buildIndexSettings(Settings extra) {
            )  
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
    }
            .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "arrow")
import org.opensearch.index.engine.dataformat.DataFormat;
    public void testPrimaryDataFormatDefaultsToParquet() {
        IndexSettingProvider provider = singleProvider(plugin);  
        assertTrue(settings.contains(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT));
        assertEquals(List.of("arrow"), CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(second));
            .put(extra)  
    public void testIndexSettingProviderReturnsEmptyBeforeCreateComponents() {
        Settings out = provider.getAdditionalIndexSettings("some-index", false, requestOrTemplate);  
        Settings settings = Settings.builder()  
    public void testGetStoreStrategiesEmptyWhenNoSubPlugins() {
                IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST
    // ---- IndexSettingProvider behavior ----
    }
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "parquet", "arrow")
    }  
        when(registry.format("parquet")).thenReturn(parquetFormat);
import org.opensearch.indices.IndicesService;
        IndexSettings indexSettings = buildIndexSettings(Settings.EMPTY);
    public void testGetStoreStrategiesCollectsFromPrimaryPlugin() {
        assertTrue("Should return empty when no sub-plugin found", result.isEmpty());
                CompositeDataFormatPlugin.CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING,  
    }
        assertEquals(6, settings.size());
        assertEquals("parquet", descriptors.get("parquet").get().getFormatName());  
                CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT,
        setClusterServiceField(plugin, clusterService);
    }
        Settings clusterBag = Settings.builder()  
        );  
        assertEquals(List.of("parquet", "arrow"), CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(settings));  
    }
    public void testSecondaryDataFormatsReadsExplicitList() {
        assertEquals(Settings.EMPTY, out);  
    public void testClusterDefaultSecondaryDataFormatsReadsExplicitList() {
                .putList("index.composite.secondary_data_formats", "parquet")  
        assertEquals("parquet", CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.get(Settings.EMPTY));
        IndexSettings indexSettings = buildIndexSettings(  
import org.opensearch.cluster.service.ClusterService;  
        Settings requestOrTemplate = Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "lucene").build();  
    public void testGetStoreStrategiesEmptyForDefaultPrimaryWithoutPlugin() {
    public void testPrimaryDataFormatReadsExplicitValue() {
            .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "arrow")
            .build();  
        IndexSettings indexSettings = buildIndexSettings(Settings.builder().put("index.composite.primary_data_format", "parquet").build());  
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        Map<String, Supplier<DataFormatDescriptor>> descriptors = plugin.getFormatDescriptors(indexSettings, registry);  
    public void testGetFormatDescriptorsEmptyWhenNoPluginsMatch() {  
        List<Setting<?>> settings = plugin.getSettings();
        Settings requestOrTemplate = Settings.builder()
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
            .build();  
        StoreStrategy parquetStrategy = mock(StoreStrategy.class);  
                CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS,  
        injectClusterService(plugin, clusterBag);  
    }
                .put("index.composite.primary_data_format", "lucene")
        DataFormatRegistry registry = mock(DataFormatRegistry.class);  
        IndexSettings indexSettings = buildIndexSettings(Settings.builder().put("index.composite.primary_data_format", "parquet").build());
        when(registry.getStoreStrategies(indexSettings, luceneFormat)).thenReturn(Map.of());
        setClusterServiceField(plugin, clusterService);  
        when(registry.format("parquet")).thenReturn(parquetFormat);  
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "parquet")  
        DataFormat luceneFormat = CompositeTestHelper.stubFormat("lucene", 1, java.util.Set.of());  
        Settings out = provider.getAdditionalIndexSettings("some-index", false, Settings.EMPTY);
    }
    public void testGetSettingsReturnsAllFourSettings() {
        when(registry.format("lucene")).thenReturn(luceneFormat);  
        ClusterService clusterService = mock(ClusterService.class);
        when(registry.getStoreStrategies(indexSettings, parquetFormat)).thenReturn(Map.of(parquetFormat, parquetStrategy));
import java.util.Collection;
            Set.of(
        assertEquals(1, result.size());
        assertEquals("parquet", CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(settings));
                .build()
    public void testClusterDefaultSecondaryDataFormatsDefaultsToEmpty() {  
    }
            Settings.builder()
        IndexSettings indexSettings = buildIndexSettings(
import org.opensearch.index.IndexSettings;
import org.opensearch.index.shard.IndexSettingProvider;  
        assertEquals("parquet", CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(first));  
        assertSame(parquetStrategy, result.get(parquetFormat));  
import java.util.Map;  
        Settings requestOrTemplate = Settings.builder()  
                .build()
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
                (Supplier<DataFormatDescriptor>) () -> new DataFormatDescriptor(
        ClusterSettings clusterSettings = new ClusterSettings(
            .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "parquet", "arrow")  
        assertTrue(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(Settings.EMPTY).isEmpty());
        injectClusterService(plugin, clusterBag);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Setting;
    // ---- Helpers ----
        Settings out = provider.getAdditionalIndexSettings("some-index", false, Settings.EMPTY);  
        Map<DataFormat, StoreStrategy> result = plugin.getStoreStrategies(indexSettings, registry);
    private static IndexSettingProvider singleProvider(CompositeDataFormatPlugin plugin) {  
        assertFalse(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.exists(out));
        DataFormat parquetFormat = CompositeTestHelper.stubFormat("parquet", 2, java.util.Set.of());  
        assertEquals(List.of("parquet", "arrow"), CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.get(settings));
    public void testIndexSettingProviderReadsLiveClusterSettingsOnEachCall() {  
        assertSame(parquetStrategy, result.get(parquetFormat));
    }  
            Set.of(  
        assertTrue(settings.contains(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS));  
    }
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        DataFormatRegistry registry = mock(DataFormatRegistry.class);  
import org.opensearch.index.engine.dataformat.StoreStrategy;
        clusterSettings.applySettings(
        assertEquals(1, providers.size());
    // ---- Existing getFormatDescriptors coverage ----
                    new org.opensearch.index.store.checksum.GenericCRC32ChecksumHandler()
 * SPDX-License-Identifier: Apache-2.0
        return new IndexSettings(indexMetadata, Settings.EMPTY);  
        );
        when(registry.format("lucene")).thenReturn(CompositeTestHelper.stubFormat("lucene", 1, java.util.Set.of()));
                IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST
                .putList("index.composite.secondary_data_formats", "parquet")
        when(registry.format("parquet")).thenReturn(parquetFormat);
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        Settings second = provider.getAdditionalIndexSettings("idx-2", false, Settings.EMPTY);
                .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet")  
                CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT,
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        // contribute nothing rather than NPE — allowing fallback to per-setting defaults.
        Settings clusterBag = Settings.builder()  
    public void testClusterDefaultPrimaryDataFormatReadsExplicitValue() {
    }  
        assertEquals(1, descriptors.size());
    }
        when(registry.getStoreStrategies(indexSettings, parquetFormat)).thenReturn(Map.of());
        );
        Settings clusterBag = Settings.builder()
            .build();
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        DataFormat parquetFormat = CompositeTestHelper.stubFormat("parquet", 2, java.util.Set.of());
        when(registry.format("lucene")).thenReturn(luceneFormat);
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
import java.util.Set;
import static org.mockito.Mockito.when;
        // Seed cluster settings with empty defaults, then flip them and verify the provider  
        assertEquals("parquet", CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(Settings.EMPTY));
                    "parquet",  
    }  
import static org.mockito.Mockito.mock;
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            Settings.EMPTY,  
            Map.of(  
        IndexSettingProvider provider = singleProvider(plugin);
}  
    public void testClusterDefaultPrimaryDataFormatDefaultsToParquet() {  
import org.opensearch.common.settings.Settings;  
/*  
        Settings out = provider.getAdditionalIndexSettings("some-index", false, requestOrTemplate);
        assertEquals(1, result.size());  
        IndexSettingProvider provider = singleProvider(plugin);
        when(registry.getStoreStrategies(indexSettings, parquetFormat)).thenReturn(Map.of(parquetFormat, parquetStrategy));  
        when(registry.getFormatDescriptors(indexSettings, parquetFormat)).thenReturn(
        ClusterService clusterService = mock(ClusterService.class);
                CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS,
            .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "arrow")
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
    public void testSecondaryDataFormatsDefaultsToEmpty() {
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        Map<DataFormat, StoreStrategy> result = plugin.getStoreStrategies(indexSettings, registry);
        // Provider contributes nothing when both settings are already explicit.
        assertEquals("parquet", CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.get(settings));  
    }
            .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "arrow")
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();  
        Settings out = provider.getAdditionalIndexSettings("some-index", false, requestOrTemplate);  
            .build();
        assertEquals(List.of("arrow"), CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(out));  
        StoreStrategy parquetStrategy = mock(StoreStrategy.class);
        Settings first = provider.getAdditionalIndexSettings("idx-1", false, Settings.EMPTY);
        Settings settings = Settings.builder().put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet").build();
        assertTrue(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(first).isEmpty());
            .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet")  
import java.util.List;
    }
        assertTrue(descriptors.isEmpty());
        assertEquals(List.of("arrow"), CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.get(out));
        DataFormat parquetFormat = CompositeTestHelper.stubFormat("parquet", 2, java.util.Set.of());  
        );  
    public void testGetStoreStrategiesCollectsPrimaryAndSecondary() {  
            .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet")
                .put("index.composite.primary_data_format", "lucene")  
        );
        assertTrue(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.get(Settings.EMPTY).isEmpty());
            .build();
        Map<String, Supplier<DataFormatDescriptor>> descriptors = plugin.getFormatDescriptors(indexSettings, registry);  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                )
        assertTrue(settings.contains(CompositeDataFormatPlugin.CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING));
        DataFormat parquetFormat = CompositeTestHelper.stubFormat("parquet", 2, java.util.Set.of());
            clusterBag,
        injectClusterService(plugin, clusterBag);
        return providers.iterator().next();  
    }
        assertEquals("parquet", CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.get(out));  
    public void testGetFormatDescriptorsDelegatestoPlugins() {  
    }
 *
        );  
 */  
 */  
        injectClusterService(plugin, clusterBag);
            .put(CompositeDataFormatPlugin.CLUSTER_PRIMARY_DATA_FORMAT.getKey(), "parquet")
                .putList(CompositeDataFormatPlugin.CLUSTER_SECONDARY_DATA_FORMATS.getKey(), "arrow")
    private static void injectClusterService(CompositeDataFormatPlugin plugin, Settings clusterBag) {  

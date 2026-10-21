        assertTrue(e.getMessage().contains("Multiple DataFormatPlugins provide a DeleteExecutionEngine"));
        // an empty map.
    public void testGetStoreStrategiesEmptyWhenNoPluggableDataformat() {
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(
        assertSame(NoOpDeleteExecutionEngine.INSTANCE, registry.getDeleteExecutionEngine(mock(Committer.class)));
    public void testGetIndexingEngineForUnregisteredFormatThrows() {
            format
 * The OpenSearch Contributors require contributions made to
        assertTrue(registry.supportsCapability("text", FieldTypeCapabilities.Capability.COLUMNAR_STORAGE).isEmpty());
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(format);
        // No format supports unknown field type
    }
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        assertEquals(1, textResults.size());
import org.opensearch.test.OpenSearchTestCase;
            "columnar",
import static org.mockito.Mockito.mock;
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
import org.opensearch.plugins.PluginsService;
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
    public void testSupportsCapabilityWithMultipleCapabilitiesPerFormat() {
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));
import java.nio.file.Path;
            "columnar",
 * this file be licensed under the Apache-2.0 license or a
            "multi-cap",
    }
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format1.name(), format2.name()));
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        List<DataFormat> noResults = registry.supportsCapability("integer", FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH);
import org.opensearch.index.engine.exec.EngineReaderManager;
        // MockDataFormatPlugin does not override getStoreStrategies, so the default returns
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
 *
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
            Set.of(new FieldTypeCapabilities("text", Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH)))
package org.opensearch.index.engine.dataformat;
import org.opensearch.common.settings.Settings;
                unregistered
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin1, plugin2));
            Set.of(new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)))
        assertEquals(1, registry.supportsCapability("text", FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH).size());
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));
    public void testGetRegisteredFormatsIsUnmodifiable() {
        DataFormatPlugin nullDeletePlugin = mock(DataFormatPlugin.class);
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(lowPriority.name(), highPriority.name()));
                    Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE, FieldTypeCapabilities.Capability.POINT_RANGE)
        List<DataFormat> result = registry.supportsCapability("integer", FieldTypeCapabilities.Capability.COLUMNAR_STORAGE);
    public void testGetDeleteExecutionEngineReturnsNoOpWhenNoPluginProvides() {
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));
import org.opensearch.index.IndexSettings;
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        // Only columnar supports integer + COLUMNAR_STORAGE
        IndexSettings settingsWithFormat = new IndexSettings(IndexMetadata.builder("index").settings(settings).build(), settings);
    }
    public void testGetPluginReturnsNullForNullName() {
        assertEquals(2, registry.getRegisteredFormats().size());
 * compatible open source license.
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(format);
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
        IndexingExecutionEngine<?, ?> engine = registry.getIndexingEngine(
        MockDataFormat columnar = new MockDataFormat(
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin1));
            100L,
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of());
import java.util.function.Supplier;
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));
            .put("index.pluggable.dataformat.enabled", true)
        );
            Set.of(new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)))
            100L,
    public void testGetDeleteExecutionEngineThrowsWhenMultiplePluginsProvide() {
    public void testGetPluginReturnsNullForUnknownFormat() {
        MockDataFormat textSearch = new MockDataFormat(
        List<DataFormat> textResults = registry.supportsCapability("text", FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH);
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of("columnar"));
    }
        );
import org.opensearch.plugins.SearchBackEndPlugin;
        List<DataFormat> unknownField = registry.supportsCapability("unknown_type", FieldTypeCapabilities.Capability.COLUMNAR_STORAGE);
        super.setUp();
    public void testGetStoreStrategiesEmptyWhenPluginReturnsNone() {
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
        indexSettings = new IndexSettings(IndexMetadata.builder("index").settings(settings).build(), settings);
            "format-high",
        );
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        assertEquals(1, managers.size());
            Set.of(new FieldTypeCapabilities("text", Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH)))
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of());
    }
        assertNull("Should return null for unknown format", registry.getPlugin("unknown"));
            50L,
import java.util.List;
        assertTrue(unknownField.isEmpty());
            .build();
    }
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
    }
        MockDataFormat format2 = new MockDataFormat("format2", 50L, Set.of());
    public void testDuplicateDataFormatThrows() {
        assertTrue(noResults.isEmpty());
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
import org.opensearch.Version;
        );
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        pluginsService = mock(PluginsService.class);
            List.of(MockDataFormatPlugin.of(columnar), MockDataFormatPlugin.of(textSearch))
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of());
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(
    }
            )
                new FieldTypeCapabilities(
        IllegalArgumentException e = expectThrows(
        MockDataFormatPlugin plugin1 = MockDataFormatPlugin.of(format);
        );
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        Map<DataFormat, StoreStrategy> result = registry.getStoreStrategies(settingsWithFormat);
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        assertTrue(registered.contains(format));
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        // DataFormatPlugin and SearchBackEndPlugin may register different formats.
    public void testGetFormatDescriptorsByDataFormatReturnsDescriptors() {
            100L,
    }
    }
            )
    public void testGetDeleteExecutionEngineReturnsNoOpWhenPluginReturnsNull() {
        assertTrue(e.getMessage().contains("columnar"));
        );
            10L,
        Map<DataFormat, EngineReaderManager<?>> managers = registry.getReaderManager(
            List.of(MockDataFormatPlugin.of(format1), MockDataFormatPlugin.of(format2))
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(format);
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(format);
import org.opensearch.core.index.shard.ShardId;
        MockDataFormat unregistered = new MockDataFormat("unknown", 1L, Set.of());
        Map<DataFormat, StoreStrategy> result = registry.getStoreStrategies(indexSettings);
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        assertNotNull(engine);
        );
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        assertEquals(1, columnarResults.size());
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));
        assertEquals(1, registry.supportsCapability("integer", FieldTypeCapabilities.Capability.COLUMNAR_STORAGE).size());
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));
        assertEquals(1, registry.supportsCapability("integer", FieldTypeCapabilities.Capability.POINT_RANGE).size());
        Settings settings = Settings.builder()
    }
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        assertNotNull("Should return plugin for registered format", result);
        assertEquals("columnar", columnarResults.get(0).name());
            .put("index.pluggable.dataformat.enabled", true)
    private ShardPath shardPath;
        assertNull("Should return empty map for null name", registry.getPlugin(null));
        assertEquals(1, registered.size());
    public void testGetStoreStrategiesEmptyWhenFormatNameNotRegistered() {
        MockDataFormatPlugin plugin2 = MockDataFormatPlugin.of(new MockDataFormat("columnar", 200L, Set.of()));
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        when(nullDeletePlugin.getDataFormat()).thenReturn(format);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of());
    }
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of());
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
        MockDataFormat unregistered = new MockDataFormat("unknown", 1L, Set.of());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
    }
        assertTrue(e.getMessage().contains("unknown"));
    }
        // Second plugin with same format name
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
    public void testMismatchedFormatsAndReaderManagersAllowed() {
    public void testSupportsCapabilityReturnsSortedByPriority() {
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        assertEquals(format, engine.getDataFormat());
        assertTrue("Should return empty map when no pluggable_dataformat setting", result.isEmpty());
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of());
            .put("index.pluggable.dataformat", "unknown")
            100L,
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(nullDeletePlugin));
        );
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format1.name(), format2.name()));
import org.opensearch.index.engine.exec.commit.Committer;
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
/*
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin1, plugin2));
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));
            100L,
import java.util.Optional;
        MockDataFormatPlugin plugin1 = MockDataFormatPlugin.of(format1);
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
    }
            "lucene",
    public void testConstructionWithSinglePlugin() {
    private IndexSettings indexSettings;
import org.opensearch.index.mapper.MapperService;
        Settings settings = Settings.builder()
                new IndexingEngineConfig(null, mapperService, indexSettings, null, null, Map.of()),
        Map<DataFormat, StoreStrategy> result = registry.getStoreStrategies(settingsWithFormat);
        MockDataFormat format = new MockDataFormat(
        List<DataFormat> columnarResults = registry.supportsCapability("integer", FieldTypeCapabilities.Capability.COLUMNAR_STORAGE);
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
                ),
        assertEquals(2, result.size());
        // Only lucene supports text + FULL_TEXT_SEARCH
        );
    }
 */
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
        MockDataFormatPlugin plugin2 = MockDataFormatPlugin.of(highPriority);
public class DataFormatRegistryTests extends OpenSearchTestCase {
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        expectThrows(UnsupportedOperationException.class, () -> formats.add(new MockDataFormat("new", 1L, Set.of())));
        );
            IllegalArgumentException.class,
        MockDataFormat format = new MockDataFormat(
        assertNotNull(descriptors);
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        assertSame("Should return the same plugin instance", plugin, result);
                new FieldTypeCapabilities("text", Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH))
        // The registry no longer validates that they match — a format can have an
            Set.of(new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)))
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of());
import java.util.Set;
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
    }
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        assertEquals("lucene", textResults.get(0).name());
        MockDataFormat format1 = new MockDataFormat("columnar", 100L, Set.of());
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin1, plugin2));
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format2.name()));
import org.opensearch.index.shard.ShardPath;
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
import java.io.IOException;
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
    }
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        MockDataFormat format1 = new MockDataFormat("format1", 100L, Set.of());
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
    public void testSupportsCapabilityFiltersCorrectly() {
        assertNotNull(managers.get(format));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            "lucene",
    public void testConstructionWithMultiplePlugins() {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> registry.getDeleteExecutionEngine(mock(Committer.class)));
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new DataFormatRegistry(pluginsService));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testGetPluginReturnsPluginForRegisteredFormat() {
import static org.mockito.Mockito.when;
        assertEquals(1, registry.getRegisteredFormats().size());
            50L,
            Set.of(new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)))
        MockDataFormat format2 = new MockDataFormat(
        // indexing engine without a reader manager (or vice-versa).
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        Map<String, Supplier<DataFormatDescriptor>> descriptors = registry.getFormatDescriptors(indexSettings, format);
            new IndexingEngineConfig(null, mapperService, indexSettings, null, null, Map.of()),
        Set<DataFormat> formats = registry.getRegisteredFormats();
        when(nullDeletePlugin.getDeleteExecutionEngine(org.mockito.ArgumentMatchers.any())).thenReturn(null);
    private MapperService mapperService;
        shardPath = new ShardPath(false, Path.of("/tmp/uuid/0"), Path.of("/tmp/uuid/0"), new ShardId("index", "uuid", 0));
        MockDataFormat format2 = new MockDataFormat("lucene", 50L, Set.of());
}
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of());
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
            .put("index.pluggable.dataformat", "columnar")
        MockDataFormatPlugin plugin1 = MockDataFormatPlugin.of(lowPriority);
            .build();
    public void testGetReaderManagers() throws IOException {
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
    }
    @Override
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));
            new ReaderManagerConfig(Optional.empty(), format, registry, shardPath, Map.of(), null)
        DataFormatPlugin result = registry.getPlugin("columnar");
        assertEquals("format-low", result.get(0).name());
        assertTrue(descriptors.isEmpty());
            () -> registry.getIndexingEngine(
        // No format supports integer + FULL_TEXT_SEARCH
    public void testGetFormatDescriptorsByDataFormatReturnsEmptyForUnregisteredFormat() {
            Set.of(
        Map<String, Supplier<DataFormatDescriptor>> descriptors = registry.getFormatDescriptors(indexSettings, unregistered);
        mapperService = mock(MapperService.class);
        assertEquals("format-high", result.get(1).name());
    }
    private PluginsService pluginsService;
        Settings settings = Settings.builder()
        MockDataFormatPlugin plugin1 = MockDataFormatPlugin.of(format1);
            .build();
        MockDataFormat lowPriority = new MockDataFormat(
        );
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of());
        IndexSettings settingsWithFormat = new IndexSettings(IndexMetadata.builder("index").settings(settings).build(), settings);
        assertTrue("Should return empty map when plugin provides no strategy", result.isEmpty());
import org.opensearch.index.engine.dataformat.stub.MockSearchBackEndPlugin;
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
    public void testConstructionWithEmptyPlugins() {
import java.util.Map;
        MockDataFormatPlugin plugin2 = MockDataFormatPlugin.of(format2);
        assertTrue(registry.getRegisteredFormats().isEmpty());
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(columnar.name(), textSearch.name()));
    }
    }
        assertTrue(e.getMessage().contains("already registered"));
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
    public void setUp() throws Exception {
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
    public void testGetIndexingEngine() {
            Set.of(new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)))
            "columnar",
        assertSame(NoOpDeleteExecutionEngine.INSTANCE, registry.getDeleteExecutionEngine(mock(Committer.class)));
        MockDataFormat format1 = new MockDataFormat(
    }
                    "integer",
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));
            "format-low",
        assertTrue("Should return empty map when format name not registered", result.isEmpty());
        MockDataFormat highPriority = new MockDataFormat(
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(format);
        Set<DataFormat> registered = registry.getRegisteredFormats();

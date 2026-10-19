        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
        when(nullDeletePlugin.getDataFormat()).thenReturn(format);  
        assertTrue(e.getMessage().contains("unknown"));  
    private IndexSettings indexSettings;  
 * SPDX-License-Identifier: Apache-2.0
            .put("index.pluggable.dataformat.enabled", true)
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);  
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));  
import org.opensearch.core.index.shard.ShardId;
        assertEquals("columnar", columnarResults.get(0).name());
    }
import java.nio.file.Path;  
    }  
    public void testGetPluginReturnsNullForUnknownFormat() {  
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));  
            () -> registry.getIndexingEngine(
    }
    public void testGetFormatDescriptorsByDataFormatReturnsEmptyForUnregisteredFormat() {
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);  
        MockDataFormatPlugin plugin2 = MockDataFormatPlugin.of(new MockDataFormat("columnar", 200L, Set.of()));
        List<DataFormat> noResults = registry.supportsCapability("integer", FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH);  
        assertTrue(e.getMessage().contains("Multiple DataFormatPlugins provide a DeleteExecutionEngine"));
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
import java.io.IOException;
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        assertNull("Should return null for unknown format", registry.getPlugin("unknown"));  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of());
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
                ),
 * this file be licensed under the Apache-2.0 license or a
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));
        mapperService = mock(MapperService.class);  
        Map<DataFormat, EngineReaderManager<?>> managers = registry.getReaderManager(
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of());
        IllegalArgumentException e = expectThrows(
        assertEquals(1, registry.getRegisteredFormats().size());
    private ShardPath shardPath;
    }  
    public void testGetStoreStrategiesEmptyWhenFormatNameNotRegistered() {
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(format);  
            .build();  
    }  
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));  
        MockDataFormat format1 = new MockDataFormat("format1", 100L, Set.of());
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of());  
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));  
        assertEquals(1, textResults.size());
 * compatible open source license.
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin1, plugin2));  
    }
import org.opensearch.index.IndexSettings;
            Set.of(new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)))  
        MockDataFormat format1 = new MockDataFormat(  
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin1));  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));
            Set.of(new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)))
    }
        MockDataFormat textSearch = new MockDataFormat(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        MockDataFormat format2 = new MockDataFormat(
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));
        );  
        MockDataFormatPlugin plugin2 = MockDataFormatPlugin.of(format2);
        Map<DataFormat, StoreStrategy> result = registry.getStoreStrategies(indexSettings);
        assertNotNull(descriptors);
        Map<DataFormat, StoreStrategy> result = registry.getStoreStrategies(settingsWithFormat);
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        );  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
    public void testGetReaderManagers() throws IOException {  
        MockDataFormatPlugin plugin1 = MockDataFormatPlugin.of(format1);  
    public void testMismatchedFormatsAndReaderManagersAllowed() {  
        assertTrue(e.getMessage().contains("columnar"));
        pluginsService = mock(PluginsService.class);
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
 *
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
        );
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        assertEquals("format-low", result.get(0).name());
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);  
            100L,
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        assertEquals(1, registry.supportsCapability("integer", FieldTypeCapabilities.Capability.POINT_RANGE).size());
import org.opensearch.index.shard.ShardPath;  
import java.util.function.Supplier;
        IndexSettings settingsWithFormat = new IndexSettings(IndexMetadata.builder("index").settings(settings).build(), settings);  
        Settings settings = Settings.builder()
    public void testConstructionWithSinglePlugin() {
import java.util.Optional;  
 */  
        assertSame(NoOpDeleteExecutionEngine.INSTANCE, registry.getDeleteExecutionEngine(mock(Committer.class)));
        MockDataFormat format = new MockDataFormat(
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        assertTrue(descriptors.isEmpty());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    }  
                unregistered  
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        );
        MockDataFormatPlugin plugin1 = MockDataFormatPlugin.of(format1);
            )  
            .put("index.pluggable.dataformat.enabled", true)
        // Only columnar supports integer + COLUMNAR_STORAGE
    public void testGetDeleteExecutionEngineReturnsNoOpWhenPluginReturnsNull() {
            List.of(MockDataFormatPlugin.of(format1), MockDataFormatPlugin.of(format2))  
        assertEquals(2, registry.getRegisteredFormats().size());
    }
import org.opensearch.plugins.SearchBackEndPlugin;
        MockDataFormatPlugin plugin1 = MockDataFormatPlugin.of(lowPriority);
        );
        Settings settings = Settings.builder()
        assertTrue("Should return empty map when plugin provides no strategy", result.isEmpty());
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(format);
        shardPath = new ShardPath(false, Path.of("/tmp/uuid/0"), Path.of("/tmp/uuid/0"), new ShardId("index", "uuid", 0));
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
    public void testConstructionWithEmptyPlugins() {
            Set.of(new FieldTypeCapabilities("text", Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH)))
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
    }
    public void testConstructionWithMultiplePlugins() {
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));  
            new IndexingEngineConfig(null, mapperService, indexSettings, null, null, Map.of()),  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));
        assertEquals(1, managers.size());
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
            100L,
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(  
        // indexing engine without a reader manager (or vice-versa).  
            10L,  
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(columnar.name(), textSearch.name()));
            "lucene",  
        assertEquals(1, registered.size());
        MockDataFormat unregistered = new MockDataFormat("unknown", 1L, Set.of());  
        List<DataFormat> columnarResults = registry.supportsCapability("integer", FieldTypeCapabilities.Capability.COLUMNAR_STORAGE);
        assertTrue(registered.contains(format));
        Map<String, Supplier<DataFormatDescriptor>> descriptors = registry.getFormatDescriptors(indexSettings, format);
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());  
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        );
        assertEquals(1, columnarResults.size());  
        when(nullDeletePlugin.getDeleteExecutionEngine(org.mockito.ArgumentMatchers.any())).thenReturn(null);
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
    }
        MockDataFormat format2 = new MockDataFormat("format2", 50L, Set.of());
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of());
            .put("index.pluggable.dataformat", "unknown")  
        assertTrue("Should return empty map when no pluggable_dataformat setting", result.isEmpty());
        expectThrows(UnsupportedOperationException.class, () -> formats.add(new MockDataFormat("new", 1L, Set.of())));  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> registry.getDeleteExecutionEngine(mock(Committer.class)));  
            "lucene",  
            50L,
    }  
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
                    Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE, FieldTypeCapabilities.Capability.POINT_RANGE)  
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
public class DataFormatRegistryTests extends OpenSearchTestCase {
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
            "format-high",
            "columnar",
            "multi-cap",
        assertEquals(1, registry.supportsCapability("text", FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH).size());
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format2.name()));
import org.opensearch.test.OpenSearchTestCase;  
import java.util.Set;
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);  
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
            Set.of(new FieldTypeCapabilities("text", Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH)))
        List<DataFormat> unknownField = registry.supportsCapability("unknown_type", FieldTypeCapabilities.Capability.COLUMNAR_STORAGE);
        assertTrue("Should return empty map when format name not registered", result.isEmpty());  
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of("columnar"));  
package org.opensearch.index.engine.dataformat;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new DataFormatRegistry(pluginsService));
        assertTrue(registry.supportsCapability("text", FieldTypeCapabilities.Capability.COLUMNAR_STORAGE).isEmpty());  
            100L,
    }
        // an empty map.  
        Set<DataFormat> registered = registry.getRegisteredFormats();  
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);  
import java.util.Map;
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(nullDeletePlugin));  
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));  
        );
    public void testDuplicateDataFormatThrows() {
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(lowPriority.name(), highPriority.name()));
        assertTrue(e.getMessage().contains("already registered"));  
    public void testGetStoreStrategiesEmptyWhenNoPluggableDataformat() {
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
    public void testGetRegisteredFormatsIsUnmodifiable() {
    }
            Set.of(new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)))  
        MockDataFormat unregistered = new MockDataFormat("unknown", 1L, Set.of());
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));  
    }
        );
    }
        IndexingExecutionEngine<?, ?> engine = registry.getIndexingEngine(
    private MapperService mapperService;
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(format);
        MockDataFormat format1 = new MockDataFormat("columnar", 100L, Set.of());
        assertTrue(unknownField.isEmpty());
            100L,
        super.setUp();
        // No format supports unknown field type  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of());
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
    public void testSupportsCapabilityReturnsSortedByPriority() {  
    public void testGetPluginReturnsNullForNullName() {  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));  
        List<DataFormat> textResults = registry.supportsCapability("text", FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH);
        );  
            Set.of(  
        assertSame(NoOpDeleteExecutionEngine.INSTANCE, registry.getDeleteExecutionEngine(mock(Committer.class)));
                new FieldTypeCapabilities("text", Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH))
            50L,
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of());  
import static org.mockito.Mockito.when;
            Set.of(new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)))
        assertEquals(format, engine.getDataFormat());
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
        Map<String, Supplier<DataFormatDescriptor>> descriptors = registry.getFormatDescriptors(indexSettings, unregistered);  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of());  
    public void testSupportsCapabilityFiltersCorrectly() {
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));  
    public void testSupportsCapabilityWithMultipleCapabilitiesPerFormat() {
    @Override
import org.opensearch.index.engine.exec.commit.Committer;
        IndexSettings settingsWithFormat = new IndexSettings(IndexMetadata.builder("index").settings(settings).build(), settings);  
            List.of(MockDataFormatPlugin.of(columnar), MockDataFormatPlugin.of(textSearch))
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
    }
        DataFormatPlugin result = registry.getPlugin("columnar");
    public void testGetStoreStrategiesEmptyWhenPluginReturnsNone() {
        assertNull("Should return empty map for null name", registry.getPlugin(null));  
        MockDataFormat highPriority = new MockDataFormat(  
        assertTrue(noResults.isEmpty());
        // Only lucene supports text + FULL_TEXT_SEARCH  
        MockDataFormatPlugin plugin2 = MockDataFormatPlugin.of(highPriority);  
        assertNotNull(managers.get(format));
        // The registry no longer validates that they match — a format can have an
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin));
                    "integer",
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));  
            "format-low",
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
import org.opensearch.Version;
        );  
    public void testGetPluginReturnsPluginForRegisteredFormat() {  
        assertEquals("format-high", result.get(1).name());
        Map<DataFormat, StoreStrategy> result = registry.getStoreStrategies(settingsWithFormat);
        Set<DataFormat> formats = registry.getRegisteredFormats();
import org.opensearch.common.settings.Settings;  
        // Second plugin with same format name
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of());
    public void testGetFormatDescriptorsByDataFormatReturnsDescriptors() {  
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(format);
import org.opensearch.plugins.PluginsService;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);  
        );
        assertEquals(1, registry.supportsCapability("integer", FieldTypeCapabilities.Capability.COLUMNAR_STORAGE).size());  
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of());  
        MockDataFormat columnar = new MockDataFormat(  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            )
        assertEquals(2, result.size());  
    public void setUp() throws Exception {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    }
    }
            .put("index.pluggable.dataformat", "columnar")  
        // No format supports integer + FULL_TEXT_SEARCH
            "columnar",
            .build();
        MockDataFormat format = new MockDataFormat(  
            "columnar",  
        Settings settings = Settings.builder()
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());
/*  
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
    private PluginsService pluginsService;  
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));  
import org.opensearch.index.mapper.MapperService;
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format1.name(), format2.name()));  
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));
        assertTrue(registry.getRegisteredFormats().isEmpty());
    public void testGetIndexingEngine() {
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);  
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());  
    }
        indexSettings = new IndexSettings(IndexMetadata.builder("index").settings(settings).build(), settings);
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
    public void testGetIndexingEngineForUnregisteredFormatThrows() {
        List<DataFormat> result = registry.supportsCapability("integer", FieldTypeCapabilities.Capability.COLUMNAR_STORAGE);
import java.util.List;
        // DataFormatPlugin and SearchBackEndPlugin may register different formats.
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
    public void testGetDeleteExecutionEngineThrowsWhenMultiplePluginsProvide() {  
        assertNotNull("Should return plugin for registered format", result);
                new FieldTypeCapabilities(
        assertEquals("lucene", textResults.get(0).name());  
        MockDataFormat format = new MockDataFormat("columnar", 100L, Set.of());  
                new IndexingEngineConfig(null, mapperService, indexSettings, null, null, Map.of()),
        // MockDataFormatPlugin does not override getStoreStrategies, so the default returns
import static org.mockito.Mockito.mock;
import org.opensearch.index.engine.exec.EngineReaderManager;  
    }
        MockDataFormat format2 = new MockDataFormat("lucene", 50L, Set.of());
        );
            100L,
    }  
            .build();
        assertNotNull(engine);  
            IllegalArgumentException.class,  
        MockDataFormat lowPriority = new MockDataFormat(
        DataFormatPlugin nullDeletePlugin = mock(DataFormatPlugin.class);
        assertSame("Should return the same plugin instance", plugin, result);  
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;  
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(backEnd));
    }  
}
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format.name()));
            Set.of(new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)))  
        MockDataFormatPlugin plugin1 = MockDataFormatPlugin.of(format);  
            format
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(MockDataFormatPlugin.of(format)));  
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin1, plugin2));
        MockDataFormatPlugin plugin = MockDataFormatPlugin.of(format);  
        MockSearchBackEndPlugin backEnd = new MockSearchBackEndPlugin(List.of(format1.name(), format2.name()));  
    }  
import org.opensearch.index.engine.dataformat.stub.MockSearchBackEndPlugin;
        );
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(plugin1, plugin2));
    public void testGetDeleteExecutionEngineReturnsNoOpWhenNoPluginProvides() {
import org.opensearch.cluster.metadata.IndexMetadata;
 * The OpenSearch Contributors require contributions made to  
            new ReaderManagerConfig(Optional.empty(), format, registry, shardPath, Map.of(), null)

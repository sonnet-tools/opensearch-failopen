        DataFormat format = dataFormats.get(formatName);
     *  
import java.util.ArrayList;  
    /**
     * @return map of format name to descriptor supplier, or empty map if the format is not registered  
            DataFormat format = dataFormats.get(dataformatName);  
     * @param indexSettings the index settings
    /**
import org.apache.logging.log4j.LogManager;
        if (dataformatName != null && dataformatName.isEmpty() == false) {
            if (format != null) {  
 *
     */
    public DeleteExecutionEngine<?> getDeleteExecutionEngine(Committer committer) {  
        if (dataformatName != null && dataformatName.isEmpty() == false) {
     * @param formatName the data format name (e.g., "parquet", "lucene")
    /**  
        DataFormatPlugin plugin = dataFormatPluginRegistry.get(dataFormat);
        if (engines.size() > 1) {
        return dataFormatPluginRegistry.keySet()
        this.dataFormats = Map.copyOf(dataFormats);
import java.util.List;
     * @param indexSettings the index settings
            }  
     * @return unmodifiable set of data formats
     * @param format the data format
     * @param contentType   the core field content type (e.g. {@code keyword}, {@code text})  
     *  
    /**
                strategies.put(entry.getKey(), strategy);
                    List<ParametrizedFieldMapper.Parameter<?>> params = plugin.getPluginMappingParameters(contentType, indexSettings, this);  
    /**
        }
     * index setting lookup. Used by composite plugins to resolve child-format parameters without recursion.
import java.util.function.Supplier;
    public void assignCapabilities(MappedFieldType fieldType, IndexSettings indexSettings) {
     * data format of the given index, keyed by the format name the strategy  
    }
     */
        String contentType,  
     * Returns store strategies for a specific data format, bypassing the
            for (String formatName : plugin.getSupportedFormats()) {
    }  
    }
            );
     * @throws IOException if reader manager creation fails
    private final Map<DataFormat, DataFormatPlugin> dataFormatPluginRegistry;
     * Assigns the capability map on the given field type by delegating to the configured data formats,
     *  
    public Map<DataFormat, EngineReaderManager<?>> getReaderManager(ReaderManagerConfig readerManagerConfig) throws IOException {
     */
        this.documentLookupProvider = lookupProviders.isEmpty() ? null : lookupProviders.getFirst();
     * @param indexSettings the index settings used to resolve the active plugin  
            if (engine != null) {
            throw new IllegalArgumentException("No plugin registered for DataFormat [" + format.name() + "]");  
/*  
    public DataFormatRegistry(PluginsService pluginsService) {
     * by the corresponding {@link SearchBackEndPlugin}.
     * @param dataFormat the specific data format to get descriptors for
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.FieldScope;  
                    + readerManagerConfig.format()
    /** The single registered document lookup provider (engine-backed get-by-id execution), or {@code null} if none. */  
        return strategies == null ? Map.of() : strategies;  
    private final DocumentMetadataResolver documentMetadataResolver;
    /**  
 * Provides methods to create indexing engines and query field-level capability support.  
    /**  
     * @param indexSettings the index settings
import org.opensearch.index.mapper.MappedFieldType;
     */
        String dataformatName = indexSettings.pluggableDataFormat();
    private final DocumentLookupProvider documentLookupProvider;
        this.documentMetadataResolver = resolvers.isEmpty() ? DocumentMetadataResolver.NOOP : resolvers.getFirst();
     *         does not participate in the tiered store
        this.dataFormatPluginRegistry = Map.copyOf(dataFormatPlugiRegistry);  
        return plugin.getFormatDescriptors(indexSettings, this);
    /** Map from data format to the plugin that provides its indexing engine. */
                    .anyMatch(ftc -> ftc.fieldType().equals(fieldType) && ftc.capabilities().contains(capability))
     * Assigns the capability map on the given field type by delegating to the configured data formats.
}  
            DataFormat format = dataFormats.get(dataformatName);
                engines.add(engine);
     * plugins to resolve child format descriptors without recursion.
    public void assignCapabilities(MappedFieldType fieldType, IndexSettings indexSettings, FieldScope fieldScope) {
        this.readerManagerBuilders = Map.copyOf(readerManagerBuilders);
        String dataformatName = indexSettings.pluggableDataFormat();  
     * @return the document metadata resolver (never null)
    public Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(IndexSettings indexSettings, DataFormat dataFormat) {
        Map<DataFormat, StoreStrategy> strategies = plugin.getStoreStrategies(indexSettings, this);
    }
     */  
import org.opensearch.plugins.DocumentLookupProvider;
     *
            return Map.of();
     * @throws IllegalArgumentException if a data format is registered by more than one plugin
        }
     * Returns the single registered {@link DocumentLookupProvider} that backs the engine's  
        List<DeleteExecutionEngine<?>> engines = new ArrayList<>();
     * @return the parameters contributed by the plugin for {@code dataFormat}, or an empty list if not registered  
            return;
     * @param settings the engine initialization settings
     * Returns the plugin-contributed parameters for a specific data format, bypassing the {@code pluggable_dataformat}  
            DataFormat format = plugin.getDataFormat();
            return;  
     */  
     * @throws IllegalArgumentException if the data format is not registered
        for (DataFormatPlugin plugin : dataFormatPluginRegistry.values()) {
import java.util.HashMap;  
     * @return map of format name to descriptor supplier, or empty map if no pluggable data format is configured
        }
                DataFormatPlugin plugin = dataFormatPluginRegistry.get(format);
     */  
            );
        }  
     *  
     * Creates {@link EngineReaderManager} instances for all applicable data formats based on index settings/mappings.
                if (plugin != null) {
     * @return the map of applicable strategies, or an empty map when no
        DataFormat format = dataFormats.get(dataformatName);
 * this file be licensed under the Apache-2.0 license or a
     * Returns the single registered {@link DocumentMetadataResolver} that maps an {@code _id}
        if (formatName == null) {
            if (format != null) {
                DataFormatPlugin plugin = dataFormatPluginRegistry.get(format);
                DataFormatPlugin plugin = dataFormatPluginRegistry.get(format);
import org.opensearch.index.mapper.ParametrizedFieldMapper;
     * from the given {@link PluginsService}. Registers each data format with its indexing plugin and reader manager factory.
     */
        String dataformatName = indexSettings.pluggableDataFormat();  
    public DataFormat format(String name) {  
import org.opensearch.index.store.FormatChecksumStrategy;  
     * @throws IllegalStateException if multiple plugins provide a delete engine
     */
     * Creates checksum strategies for all formats of the given index, intended to be called
     * {@code pluggable_dataformat} index setting lookup. Used by composite
 */  
        Map<String, FormatChecksumStrategy> strategies = new HashMap<>();  
        DataFormatPlugin plugin = dataFormatPluginRegistry.get(format);
     *
     * once per shard during initialization. The returned map should be shared between the  
     * Used by composite plugins to look up sub-format plugins directly without going through
     * @param readerManagerConfig config containing details about how to construct reader manager  
        List<ParametrizedFieldMapper.Parameter<?>> params = plugin.getPluginMappingParameters(contentType, indexSettings, this);
 * SPDX-License-Identifier: Apache-2.0
    public Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(IndexSettings indexSettings) {  
            fieldType.setCapabilityMap(Map.of());
     * to its row location, or {@link DocumentMetadataResolver#NOOP} when none is registered.
     * If any requested capability remains unclaimed, a {@link org.opensearch.index.mapper.MapperParsingException} is thrown.  
 * Registry that holds the mapping from {@link DataFormat} to the {@link DataFormatPlugin} that provides it.
     *
            return Map.of();  
import org.opensearch.plugins.PluginsService;
     *
import org.opensearch.common.CheckedFunction;  
                throw new IllegalArgumentException("DataFormat [" + format.name() + "] is already registered by plugin [" + existing + "]");
     *  
                }
    /** The single registered document metadata resolver (id-to-row-location), or {@link DocumentMetadataResolver#NOOP} if none. */  
     * @param indexSettings the index settings used to resolve the active plugin
        return plugin.indexingEngine(settings);
            if (format != null) {
        for (DataFormatPlugin plugin : pluginsService.filterPlugins(DataFormatPlugin.class)) {  
    }
        return documentLookupProvider;  
     * @param indexSettings the index settings for this shard
        }
        }
     * Returns format descriptor suppliers for a specific data format, bypassing the  
    private final Map<DataFormat, CheckedFunction<ReaderManagerConfig, EngineReaderManager<?>, IOException>> readerManagerBuilders;
        assignCapabilities(fieldType, indexSettings, FieldScope.ROOT);  
            .filter(
     * Callers that only need format names can use {@code keySet()} without triggering descriptor creation.
     *
            fieldType.setCapabilityMap(Map.of());  
            return NoOpDeleteExecutionEngine.INSTANCE;
        return Set.copyOf(dataFormatPluginRegistry.keySet());
 * The OpenSearch Contributors require contributions made to  
     * Returns the plugin registered for the given format name, or {@code null} if not found.  
    public Map<DataFormat, StoreStrategy> getStoreStrategies(IndexSettings indexSettings) {  
     * IndexSettings, DataFormatRegistry, FieldScope)}).
     * directory and the engine so that pre-computed checksums registered during write are
     * scope — passed through to the plugin so a composite plugin can restrict which of its sub-formats  
     *  
import java.util.Collections;
        Map<DataFormat, DataFormatPlugin> dataFormatPlugiRegistry = new HashMap<>();
    public DocumentLookupProvider getDocumentLookupProvider() {
            .collect(Collectors.toList());
    /**
        for (Map.Entry<String, Supplier<DataFormatDescriptor>> entry : descriptors.entrySet()) {
     * @throws IllegalStateException if the set of formats with indexing plugins does not match the set with reader managers
     */
     * additionally indicating whether the field is declared directly inside a {@code nested} object's
    }
     * then delegates to {@link DataFormatPlugin#getFormatDescriptors(IndexSettings, DataFormatRegistry)}.  
        if (lookupProviders.size() > 1) {
                if (plugin != null) {  
            throw new IllegalArgumentException(  
    /** Map from data format to a factory that creates an {@link EngineReaderManager} for the given settings. */
                    return strategies == null ? Map.of() : Map.copyOf(strategies);
        Map<DataFormat, CheckedFunction<ReaderManagerConfig, EngineReaderManager<?>, IOException>> readerManagerBuilders = new HashMap<>();  
            .sorted(Comparator.comparingLong(DataFormat::priority))  
     * Creates an {@link IndexingExecutionEngine} for the given data format.
        DataFormat format = dataFormats.get(name);
     * @param fieldType the field type name  
     * Returns an unmodifiable view of all registered data formats and their plugins.
            }
     *
        return Collections.unmodifiableMap(strategies);
    public IndexingExecutionEngine<?, ?> getIndexingEngine(IndexingEngineConfig settings, DataFormat format) {  
     */
     * @return the plugin, or null if no plugin is registered for the format
     * @param capability the capability to check
        }
            )
        return format != null ? dataFormatPluginRegistry.get(format) : null;  
        }
                if (format != null) {  
     * visible to the upload path.
     * applies to.
     * @return list of data formats supporting the capability for the field type
     * remote metadata, and route directory events.
        }  
     */
package org.opensearch.index.engine.dataformat;
        }
        }
        if (!readerManagerBuilders.containsKey(readerManagerConfig.format())) {
import org.opensearch.plugins.SearchBackEndPlugin;  
     *
        for (SearchBackEndPlugin<?> plugin : pluginsService.filterPlugins(SearchBackEndPlugin.class)) {  
        if (dataformatName != null && dataformatName.isEmpty() == false) {
     * Returns the registered delete engine, or a no-op engine when none is provided.
                }
     * Creates a registry by discovering all {@link DataFormatPlugin} and {@link SearchBackEndPlugin} implementations  
                }
     * {@code pluggable_dataformat} setting and delegates to that single plugin; composite plugins fan out to their
import java.io.IOException;
 *
     * may claim capabilities there (see {@link DataFormatPlugin#assignCapabilities(MappedFieldType,
                    Map<DataFormat, StoreStrategy> strategies = plugin.getStoreStrategies(indexSettings, this);
                    + readerManagerBuilders.keySet()
        return format;
import org.apache.logging.log4j.Logger;
                if (plugin != null) {  
        DataFormatPlugin plugin = dataFormatPluginRegistry.get(format);
    }  
            fieldType.setCapabilityMap(Map.of());
                    return plugin.getFormatDescriptors(indexSettings, this);
        if (plugin == null) {
            DeleteExecutionEngine<?> engine = plugin.getDeleteExecutionEngine(committer);  
                format -> format.supportedFields()
     * Returns all {@link StoreStrategy} instances that apply to the active
    }  
        }
    public List<ParametrizedFieldMapper.Parameter<?>> getPluginMappingParameters(
            if (existing != null) {  
        return documentMetadataResolver;
        Map<String, DataFormat> dataFormats = new HashMap<>();
                    readerManagerBuilders.put(format, settings -> plugin.createReaderManager(settings));
                DataFormat format = dataFormats.get(formatName);
        if (plugin == null) {
        if (format == null) {  
     * @param contentType   the core field content type (e.g. {@code keyword}, {@code text})
            }
            return List.of();  
     *         pluggable data format is configured or the configured format  
                "Unsupported format: ["
     *
            DataFormatPlugin existing = dataFormatPlugiRegistry.putIfAbsent(format, plugin);
                }  
    }
            return null;  
     * @return a map from data format to its reader manager
/**
     */
     */
    /**
     * @param indexSettings the index settings used to determine the active data format
    }
     * <p>Called once per shard at open time. The store layer uses the returned  
     * @param indexSettings the index settings used to determine the active data format  
    }
        IndexSettings indexSettings,
    }
                "Multiple DataFormatPlugins provide a DeleteExecutionEngine, expected exactly one but found [" + engines.size() + "]"
     * Returns all registered data formats that support a specific capability for a field type.
        }  
    /**
     * Returns the plugin-contributed parameters applicable to the given content type, scoped to the data format the  
            throw new IllegalArgumentException("No data format registered with name [" + name + "]");  
     */
        }
    }  
            throw new IllegalStateException("multiple DocumentMetadataResolver implementations registered: " + resolvers);  
     * @param fieldType the field type to assign capabilities to
     * @param fieldScope the field's mapping scope  
    public Map<DataFormat, StoreStrategy> getStoreStrategies(IndexSettings indexSettings, DataFormat dataFormat) {  
            }  
     *  
    }
        DataFormatPlugin plugin = dataFormatPluginRegistry.get(dataFormat);  
        if (format == null) {
        if (plugin == null) {
     *
        String dataformatName = indexSettings.pluggableDataFormat();
     * primary and secondary formats. Returns an empty list when no pluggable data format is configured.  
            FormatChecksumStrategy strategy = entry.getValue().get().getChecksumStrategy();
     * @param indexSettings the index settings used to determine the active data format  
    /**  
            dataFormats.put(format.name(), format);  
            throw new IllegalStateException(  
     * the registry's top-level methods (which would cause infinite recursion).
        return Map.of();  
            }  
    public List<DataFormat> supportsCapability(String fieldType, FieldTypeCapabilities.Capability capability) {
    /**
     * @param dataFormat    the specific data format to get strategies for  
    /**
            }  
        List<DocumentMetadataResolver> resolvers = pluginsService.filterPlugins(DocumentMetadataResolver.class);
import org.opensearch.index.engine.exec.commit.Committer;  
    public Set<DataFormat> getRegisteredFormats() {  
    /**
@ExperimentalApi
public class DataFormatRegistry {
    /**  
        DataFormat dataFormat
        if (engines.isEmpty()) {
            }
                    .stream()  
    /**
        Map<String, Supplier<DataFormatDescriptor>> descriptors = getFormatDescriptors(indexSettings);
     * Resolves the data format from index settings via the {@code pluggable_dataformat} setting,
 */  
import org.opensearch.index.engine.exec.EngineReaderManager;
import org.opensearch.common.annotation.ExperimentalApi;
    public Map<String, FormatChecksumStrategy> createChecksumStrategies(IndexSettings indexSettings) {
import java.util.Map;
import java.util.stream.Collectors;
        if (plugin == null) {
        if (resolvers.size() > 1) {
     * @param fieldType the field type to assign capabilities to
     * Each reader manager is instantiated by applying the store provider and shard path to the factory registered  
     */
            DataFormat format = dataFormats.get(dataformatName);  
     */  
        }  
     * {@code pluggable_dataformat} index setting lookup. This is used by composite
import java.util.Set;  
    public DataFormatPlugin getPlugin(String formatName) {
        DataFormatPlugin plugin = dataFormatPluginRegistry.get(dataFormat);
    public List<ParametrizedFieldMapper.Parameter<?>> getPluginMappingParameters(String contentType, IndexSettings indexSettings) {
     * plugins to resolve child strategies without recursion.  
    public DocumentMetadataResolver getDocumentMetadataResolver() {  
     *  
            return;
    }
        List<DocumentLookupProvider> lookupProviders = pluginsService.filterPlugins(DocumentLookupProvider.class);
            if (strategy != null) {  
     * given index actually uses. Resolves the active data format from {@code indexSettings} via the
     * @param dataFormat    the specific data format to get parameters for
 * @opensearch.experimental
     *
        }
     */  
        if (dataformatName == null || dataformatName.isEmpty()) {
     * @return unmodifiable map of format name to checksum strategy
     * Each format in priority order claims the capabilities it supports for the field type.
    /**
            .stream()  
import org.opensearch.index.IndexSettings;
     * @param pluginsService the plugins service used to discover data format plugins and search back-end plugins  
     * @return map of data format to strategy, or empty map if the format is not registered
        return params == null ? List.of() : params;  
                    return params == null ? List.of() : List.copyOf(params);
    /**  
    private static final Logger logger = LogManager.getLogger(DataFormatRegistry.class);  
import java.util.Comparator;
    }
                    + "]. Reader Manager can be built only for: "  
        plugin.assignCapabilities(fieldType, indexSettings, this, fieldScope);  
    }  
     * get-by-id / version-resolution path, or {@code null} when no provider is registered.
        }  
        }  
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
    }
        return engines.getFirst();
    private final Map<String, DataFormat> dataFormats;
     * @return the document lookup provider, or null  
     * strategies to construct per-shard native file registries, seed them from
 * compatible open source license.
        return Map.of();
        return Map.of(readerManagerConfig.format(), readerManagerBuilders.get(readerManagerConfig.format()).apply(readerManagerConfig));
        if (plugin == null) {
            throw new IllegalStateException("multiple DocumentLookupProvider implementations registered: " + lookupProviders);  
        }
        }
        }
     *  
    }
     * @return the indexing execution engine  
        return List.of();
     * Returns format descriptor suppliers for the active data format of the given index.
    ) {  

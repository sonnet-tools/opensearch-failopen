     * @return the document lookup provider, or null
            return;
     * scope — passed through to the plugin so a composite plugin can restrict which of its sub-formats
     */
        return engines.getFirst();
        List<DeleteExecutionEngine<?>> engines = new ArrayList<>();
    public Map<DataFormat, StoreStrategy> getStoreStrategies(IndexSettings indexSettings) {
    }
        }
    public List<DataFormat> supportsCapability(String fieldType, FieldTypeCapabilities.Capability capability) {
    public void assignCapabilities(MappedFieldType fieldType, IndexSettings indexSettings, FieldScope fieldScope) {
                if (plugin != null) {
     * @param contentType   the core field content type (e.g. {@code keyword}, {@code text})
        }
        }
    }
        DataFormatPlugin plugin = dataFormatPluginRegistry.get(dataFormat);
        DataFormatPlugin plugin = dataFormatPluginRegistry.get(format);
        return Map.of();
    public DataFormatPlugin getPlugin(String formatName) {
        IndexSettings indexSettings,
     * @param indexSettings the index settings used to determine the active data format
                "Unsupported format: ["
import org.opensearch.index.engine.exec.commit.Committer;
                throw new IllegalArgumentException("DataFormat [" + format.name() + "] is already registered by plugin [" + existing + "]");
        DataFormat format = dataFormats.get(formatName);
     * @return a map from data format to its reader manager
        }
 *
     *
     * @param indexSettings the index settings used to determine the active data format
     * @return map of format name to descriptor supplier, or empty map if no pluggable data format is configured
        Map<DataFormat, DataFormatPlugin> dataFormatPlugiRegistry = new HashMap<>();
                    + readerManagerConfig.format()
     */
            throw new IllegalStateException(
    public Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(IndexSettings indexSettings, DataFormat dataFormat) {
     *
        return format != null ? dataFormatPluginRegistry.get(format) : null;
                    return params == null ? List.of() : List.copyOf(params);
    /**
    /**
    /**
        DataFormat format = dataFormats.get(dataformatName);
    /**
     * Callers that only need format names can use {@code keySet()} without triggering descriptor creation.
     *
     * Returns the plugin-contributed parameters applicable to the given content type, scoped to the data format the
                    return plugin.getFormatDescriptors(indexSettings, this);
    }
     * Creates checksum strategies for all formats of the given index, intended to be called
        Map<String, DataFormat> dataFormats = new HashMap<>();
            DataFormatPlugin existing = dataFormatPlugiRegistry.putIfAbsent(format, plugin);
                }
        String dataformatName = indexSettings.pluggableDataFormat();
                DataFormatPlugin plugin = dataFormatPluginRegistry.get(format);
    public IndexingExecutionEngine<?, ?> getIndexingEngine(IndexingEngineConfig settings, DataFormat format) {
     */
    private final Map<String, DataFormat> dataFormats;
 */
     * @param indexSettings the index settings used to resolve the active plugin
     * then delegates to {@link DataFormatPlugin#getFormatDescriptors(IndexSettings, DataFormatRegistry)}.
        if (plugin == null) {
        String contentType,
        }
     * @param fieldType the field type name
import org.opensearch.index.IndexSettings;
    }
    /**
     * strategies to construct per-shard native file registries, seed them from
            }
package org.opensearch.index.engine.dataformat;
            }
        if (lookupProviders.size() > 1) {
     * Each reader manager is instantiated by applying the store provider and shard path to the factory registered
    public Map<String, FormatChecksumStrategy> createChecksumStrategies(IndexSettings indexSettings) {
     * @param indexSettings the index settings
        for (DataFormatPlugin plugin : dataFormatPluginRegistry.values()) {
     * Returns an unmodifiable view of all registered data formats and their plugins.
                engines.add(engine);
        }
import java.util.HashMap;
 * SPDX-License-Identifier: Apache-2.0
        if (!readerManagerBuilders.containsKey(readerManagerConfig.format())) {
                    .stream()
import java.util.stream.Collectors;
     * Each format in priority order claims the capabilities it supports for the field type.
 * compatible open source license.
            if (strategy != null) {
        return format;
     * Assigns the capability map on the given field type by delegating to the configured data formats,
    /**
     *
     * @return map of data format to strategy, or empty map if the format is not registered
            if (format != null) {
            throw new IllegalArgumentException(
     * Assigns the capability map on the given field type by delegating to the configured data formats.
     */
    }
        }
     * index setting lookup. Used by composite plugins to resolve child-format parameters without recursion.
     * plugins to resolve child strategies without recursion.
        this.dataFormatPluginRegistry = Map.copyOf(dataFormatPlugiRegistry);
                "Multiple DataFormatPlugins provide a DeleteExecutionEngine, expected exactly one but found [" + engines.size() + "]"
            );
        for (SearchBackEndPlugin<?> plugin : pluginsService.filterPlugins(SearchBackEndPlugin.class)) {
                if (plugin != null) {
     */
            DataFormat format = dataFormats.get(dataformatName);
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
     *
 * Provides methods to create indexing engines and query field-level capability support.
        }
     * directory and the engine so that pre-computed checksums registered during write are
/*
                DataFormat format = dataFormats.get(formatName);
     * Returns the plugin-contributed parameters for a specific data format, bypassing the {@code pluggable_dataformat}
     * from the given {@link PluginsService}. Registers each data format with its indexing plugin and reader manager factory.
    }
     *
        DataFormat format = dataFormats.get(name);
     * given index actually uses. Resolves the active data format from {@code indexSettings} via the
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.FieldScope;
    public Map<DataFormat, StoreStrategy> getStoreStrategies(IndexSettings indexSettings, DataFormat dataFormat) {
     * @param indexSettings the index settings
     * @throws IllegalStateException if multiple plugins provide a delete engine
     * @param format the data format
     */
        List<DocumentLookupProvider> lookupProviders = pluginsService.filterPlugins(DocumentLookupProvider.class);
    private final Map<DataFormat, CheckedFunction<ReaderManagerConfig, EngineReaderManager<?>, IOException>> readerManagerBuilders;
     * the registry's top-level methods (which would cause infinite recursion).
import java.util.Set;
            if (engine != null) {
     * @throws IllegalArgumentException if the data format is not registered
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.SearchBackEndPlugin;
        return strategies == null ? Map.of() : strategies;
    }
     * {@code pluggable_dataformat} index setting lookup. Used by composite
     * @param contentType   the core field content type (e.g. {@code keyword}, {@code text})
        return Map.of();
     * Returns format descriptor suppliers for a specific data format, bypassing the
        Map<DataFormat, StoreStrategy> strategies = plugin.getStoreStrategies(indexSettings, this);
     * Returns all {@link StoreStrategy} instances that apply to the active
    /**
            throw new IllegalArgumentException("No data format registered with name [" + name + "]");
                    Map<DataFormat, StoreStrategy> strategies = plugin.getStoreStrategies(indexSettings, this);
        }
import java.util.List;
        if (dataformatName != null && dataformatName.isEmpty() == false) {
     * Used by composite plugins to look up sub-format plugins directly without going through
     * <p>Called once per shard at open time. The store layer uses the returned
                if (format != null) {
    public DataFormatRegistry(PluginsService pluginsService) {
        if (dataformatName == null || dataformatName.isEmpty()) {
import java.util.ArrayList;
     * applies to.
    }
        if (plugin == null) {
     * @return the parameters contributed by the plugin for {@code dataFormat}, or an empty list if not registered
     * @param fieldType the field type to assign capabilities to
     *
    /**
import org.opensearch.common.CheckedFunction;
     *
    }
    /**
    /** Map from data format to the plugin that provides its indexing engine. */
            }
            return Map.of();
     *
    /** Map from data format to a factory that creates an {@link EngineReaderManager} for the given settings. */
     * get-by-id / version-resolution path, or {@code null} when no provider is registered.
        if (formatName == null) {
        this.readerManagerBuilders = Map.copyOf(readerManagerBuilders);
            FormatChecksumStrategy strategy = entry.getValue().get().getChecksumStrategy();
     */
            DataFormat format = plugin.getDataFormat();
                    readerManagerBuilders.put(format, settings -> plugin.createReaderManager(settings));
        DataFormatPlugin plugin = dataFormatPluginRegistry.get(dataFormat);
    /**
 */
import org.opensearch.common.annotation.ExperimentalApi;
     */
        if (dataformatName != null && dataformatName.isEmpty() == false) {
     */
     */
     */
import org.opensearch.index.engine.exec.EngineReaderManager;
     * Returns the single registered {@link DocumentMetadataResolver} that maps an {@code _id}
        String dataformatName = indexSettings.pluggableDataFormat();
        if (engines.isEmpty()) {
import org.opensearch.plugins.DocumentLookupProvider;
        if (plugin == null) {
     * plugins to resolve child format descriptors without recursion.
import java.util.function.Supplier;
     * @return the document metadata resolver (never null)
            if (format != null) {
     */
     * @param pluginsService the plugins service used to discover data format plugins and search back-end plugins
     * @param formatName the data format name (e.g., "parquet", "lucene")
    }
        Map<DataFormat, CheckedFunction<ReaderManagerConfig, EngineReaderManager<?>, IOException>> readerManagerBuilders = new HashMap<>();
     * @throws IllegalArgumentException if a data format is registered by more than one plugin
                    .anyMatch(ftc -> ftc.fieldType().equals(fieldType) && ftc.capabilities().contains(capability))
        }
public class DataFormatRegistry {
     * @param readerManagerConfig config containing details about how to construct reader manager
     * @param indexSettings the index settings for this shard
     * @param fieldType the field type to assign capabilities to
     * @param capability the capability to check
    public List<ParametrizedFieldMapper.Parameter<?>> getPluginMappingParameters(String contentType, IndexSettings indexSettings) {
            fieldType.setCapabilityMap(Map.of());
     */
        this.documentMetadataResolver = resolvers.isEmpty() ? DocumentMetadataResolver.NOOP : resolvers.getFirst();
        return Map.of(readerManagerConfig.format(), readerManagerBuilders.get(readerManagerConfig.format()).apply(readerManagerConfig));
     *
 * Registry that holds the mapping from {@link DataFormat} to the {@link DataFormatPlugin} that provides it.
     * If any requested capability remains unclaimed, a {@link org.opensearch.index.mapper.MapperParsingException} is thrown.
            throw new IllegalArgumentException("No plugin registered for DataFormat [" + format.name() + "]");
        if (engines.size() > 1) {
     * Returns all registered data formats that support a specific capability for a field type.
            }
            for (String formatName : plugin.getSupportedFormats()) {
                }
    /**
     * Returns store strategies for a specific data format, bypassing the
    public DocumentLookupProvider getDocumentLookupProvider() {
    /** The single registered document lookup provider (engine-backed get-by-id execution), or {@code null} if none. */
        return Set.copyOf(dataFormatPluginRegistry.keySet());
        if (format == null) {
        return dataFormatPluginRegistry.keySet()
                DataFormatPlugin plugin = dataFormatPluginRegistry.get(format);
                    + readerManagerBuilders.keySet()
        this.dataFormats = Map.copyOf(dataFormats);
    public Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(IndexSettings indexSettings) {
                    + "]. Reader Manager can be built only for: "
            .collect(Collectors.toList());
    }
    private final DocumentMetadataResolver documentMetadataResolver;
import org.opensearch.index.mapper.MappedFieldType;
     * @return the map of applicable strategies, or an empty map when no
        if (dataformatName != null && dataformatName.isEmpty() == false) {
            .stream()
     */
            throw new IllegalStateException("multiple DocumentLookupProvider implementations registered: " + lookupProviders);
        Map<String, Supplier<DataFormatDescriptor>> descriptors = getFormatDescriptors(indexSettings);
        if (resolvers.size() > 1) {
        }
        }
            if (format != null) {
        return documentMetadataResolver;
            DataFormat format = dataFormats.get(dataformatName);
     * primary and secondary formats. Returns an empty list when no pluggable data format is configured.
        Map<String, FormatChecksumStrategy> strategies = new HashMap<>();
            return;
     */
     * Creates an {@link IndexingExecutionEngine} for the given data format.
     * Returns format descriptor suppliers for the active data format of the given index.
     * @return unmodifiable set of data formats
     * remote metadata, and route directory events.
    }
     * @param settings the engine initialization settings
            .filter(
        }
     * once per shard during initialization. The returned map should be shared between the
        return params == null ? List.of() : params;
     *
    public Map<DataFormat, EngineReaderManager<?>> getReaderManager(ReaderManagerConfig readerManagerConfig) throws IOException {
        assignCapabilities(fieldType, indexSettings, FieldScope.ROOT);
                if (plugin != null) {
    /**
import java.util.Collections;
     * Returns the plugin registered for the given format name, or {@code null} if not found.
     * visible to the upload path.
    }
        if (plugin == null) {
import org.opensearch.index.store.FormatChecksumStrategy;
 *
        String dataformatName = indexSettings.pluggableDataFormat();
        }
                strategies.put(entry.getKey(), strategy);
     * data format of the given index, keyed by the format name the strategy
                }
@ExperimentalApi
/**
    /**
    /**
    public DeleteExecutionEngine<?> getDeleteExecutionEngine(Committer committer) {
     *
            return List.of();
     */
    private static final Logger logger = LogManager.getLogger(DataFormatRegistry.class);
     * {@code pluggable_dataformat} setting and delegates to that single plugin; composite plugins fan out to their
            return NoOpDeleteExecutionEngine.INSTANCE;
    /**
                    List<ParametrizedFieldMapper.Parameter<?>> params = plugin.getPluginMappingParameters(contentType, indexSettings, this);
     * may claim capabilities there (see {@link DataFormatPlugin#assignCapabilities(MappedFieldType,
        String dataformatName = indexSettings.pluggableDataFormat();
                format -> format.supportedFields()
     */
                DataFormatPlugin plugin = dataFormatPluginRegistry.get(format);
        return List.of();
     * @return map of format name to descriptor supplier, or empty map if the format is not registered
        return documentLookupProvider;
            throw new IllegalStateException("multiple DocumentMetadataResolver implementations registered: " + resolvers);
    public DocumentMetadataResolver getDocumentMetadataResolver() {
            fieldType.setCapabilityMap(Map.of());
     * @param fieldScope the field's mapping scope
     *
 * @opensearch.experimental
        List<DocumentMetadataResolver> resolvers = pluginsService.filterPlugins(DocumentMetadataResolver.class);
 * The OpenSearch Contributors require contributions made to
    }
        }
import org.opensearch.plugins.PluginsService;
     *
     * IndexSettings, DataFormatRegistry, FieldScope)}).
        this.documentLookupProvider = lookupProviders.isEmpty() ? null : lookupProviders.getFirst();
     * {@code pluggable_dataformat} index setting lookup. This is used by composite
    /**
            DeleteExecutionEngine<?> engine = plugin.getDeleteExecutionEngine(committer);
     * additionally indicating whether the field is declared directly inside a {@code nested} object's
     * Returns the single registered {@link DocumentLookupProvider} that backs the engine's
    }
    }
     * to its row location, or {@link DocumentMetadataResolver#NOOP} when none is registered.
    private final DocumentLookupProvider documentLookupProvider;
        }
     *
        return plugin.getFormatDescriptors(indexSettings, this);
        plugin.assignCapabilities(fieldType, indexSettings, this, fieldScope);
        for (DataFormatPlugin plugin : pluginsService.filterPlugins(DataFormatPlugin.class)) {
     * @param indexSettings the index settings used to determine the active data format
        }
    public Set<DataFormat> getRegisteredFormats() {
}
            )
     * @return the plugin, or null if no plugin is registered for the format
    private final Map<DataFormat, DataFormatPlugin> dataFormatPluginRegistry;
        DataFormatPlugin plugin = dataFormatPluginRegistry.get(dataFormat);
     * Returns the registered delete engine, or a no-op engine when none is provided.
    /** The single registered document metadata resolver (id-to-row-location), or {@link DocumentMetadataResolver#NOOP} if none. */
     * @return the indexing execution engine
    }
            return;
     */
    }
     *
        }
     * @return unmodifiable map of format name to checksum strategy
import org.opensearch.index.mapper.ParametrizedFieldMapper;
     * Creates a registry by discovering all {@link DataFormatPlugin} and {@link SearchBackEndPlugin} implementations
import java.io.IOException;
        if (format == null) {
     *
        }
        if (plugin == null) {
            .sorted(Comparator.comparingLong(DataFormat::priority))
            dataFormats.put(format.name(), format);
        return Collections.unmodifiableMap(strategies);
     * by the corresponding {@link SearchBackEndPlugin}.
        }
        DataFormat dataFormat
     *         pluggable data format is configured or the configured format
     * @param indexSettings the index settings used to resolve the active plugin
                }
            }
    }
     *         does not participate in the tiered store
import java.util.Comparator;
     * @param dataFormat    the specific data format to get parameters for
     * Resolves the data format from index settings via the {@code pluggable_dataformat} setting,
        }
        DataFormatPlugin plugin = dataFormatPluginRegistry.get(format);
        return plugin.indexingEngine(settings);
                    return strategies == null ? Map.of() : Map.copyOf(strategies);
            return Map.of();
    /**
            DataFormat format = dataFormats.get(dataformatName);
import org.apache.logging.log4j.Logger;
    /**
     * @return list of data formats supporting the capability for the field type
import java.util.Map;
            );
import org.apache.logging.log4j.LogManager;
        for (Map.Entry<String, Supplier<DataFormatDescriptor>> entry : descriptors.entrySet()) {
     * @param indexSettings the index settings
            if (existing != null) {
     * @throws IllegalStateException if the set of formats with indexing plugins does not match the set with reader managers
     * Creates {@link EngineReaderManager} instances for all applicable data formats based on index settings/mappings.
     * @param dataFormat the specific data format to get descriptors for
     * @param dataFormat    the specific data format to get strategies for
    ) {
     *
            }
        List<ParametrizedFieldMapper.Parameter<?>> params = plugin.getPluginMappingParameters(contentType, indexSettings, this);
     * @throws IOException if reader manager creation fails
    public void assignCapabilities(MappedFieldType fieldType, IndexSettings indexSettings) {
     *
    public DataFormat format(String name) {
            }
    public List<ParametrizedFieldMapper.Parameter<?>> getPluginMappingParameters(
            return null;
            fieldType.setCapabilityMap(Map.of());

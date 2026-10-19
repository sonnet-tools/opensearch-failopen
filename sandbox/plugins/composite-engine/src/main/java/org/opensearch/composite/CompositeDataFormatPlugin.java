     * Each sub-format plugin claims the capabilities it supports; unclaimed capabilities are
            return;  
                "Field ["  
        SettingsFilter settingsFilter,
    );
        for (DataFormat format : formats) {
        ClusterService clusterService,
                        if (ftc.capabilities().contains(cap)) {  
     * sub-plugin without re-entering this composite.
 */  
 * @opensearch.experimental
    public List<ActionPlugin.ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
 * SPDX-License-Identifier: Apache-2.0
                }
    @Override
        for (String secondaryName : secondaryFormatNames) {
            indexSettings,
import org.opensearch.common.settings.ClusterSettings;  
                    + "] of type ["
                                + SECONDARY_DATA_FORMATS.getKey()
    public DataFormat getDataFormat() {  
        return new CompositeIndexingExecutionEngine(  
        Collections.emptyList(),
        }
import org.opensearch.common.settings.SettingsFilter;
            }
import org.opensearch.core.common.unit.ByteSizeUnit;
        Setting.Property.Dynamic
    );  
                }
 *   <li>{@code cluster.restrict.composite.dataformat} — when true, rejects index-level overrides that  
        return new CompositeDataFormat();
            if (seenNames.add(param.name) == false) {
    }
                    + " but configured data formats cannot collectively cover: "  
     */  
                            intersection.add(cap);
        FieldScope fieldScope
import org.opensearch.common.settings.Setting;
 *   <li>{@code index.composite.primary_data_format} — designates the primary
import java.util.Collection;
                    + requested
     * Index setting that designates the primary data format for an index.
 *  
                Settings.Builder out = Settings.builder();
                }  
    @Override
     * each participating format is resolved through the registry, which delegates to the  
import org.opensearch.script.ScriptService;
                    + typeName  
                    out.put(PRIMARY_DATA_FORMAT.getKey(), clusterPrimary);
     * that does not match. If disabled, users may choose the composite data-format on a per-index basis using the  
        "parquet",  
import org.opensearch.index.mapper.MetadataFieldMapper;
                    "Duplicate plugin mapping parameter [" + param.name + "] for content type [" + contentType + "]"
                        && SECONDARY_DATA_FORMATS.get(templateAndRequestSettings).equals(clusterSecondary) == false) {
            collectParameters(result, seenNames, dataFormatRegistry, contentType, indexSettings, primaryFormatName);  
import java.util.ArrayList;
     * matching the cluster-level defaults defined in {@link #CLUSTER_PRIMARY_DATA_FORMAT} and
            MERGE_ON_REFRESH_MAX_SIZE
import org.apache.logging.log4j.Logger;
import org.opensearch.index.engine.dataformat.DataFormat;
            new ActionPlugin.ActionHandler<>(CompositeNodeStatsActionType.INSTANCE, CompositeNodeStatsTransportAction.class)
@ExperimentalApi  
     * at index-creation time.
import org.opensearch.composite.stats.CompositeStatsProvider;
        List<DataFormat> configured = new ArrayList<>();  
                    + formats.stream().map(DataFormat::name).collect(Collectors.toList())  
        DataFormatRegistry dataFormatRegistry,
    private static void collectParameters(
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
     */  
    }  
        NamedWriteableRegistry namedWriteableRegistry,  
import org.opensearch.common.ValidationException;
        if (primaryFormatName != null && primaryFormatName.isEmpty() == false) {
        Settings settings = indexSettings.getSettings();  
            throw new MapperParsingException(
     *
    /**  
public class CompositeDataFormatPlugin extends Plugin implements DataFormatPlugin, ExtensiblePlugin, MapperPlugin, ActionPlugin {
        "index.composite.secondary_data_formats",
                }
        if (formats.isEmpty()) {
                        errors.add(  
                strategies.putAll(dataFormatRegistry.getStoreStrategies(indexSettings, dataFormatRegistry.format(secondaryName)));  
                        }
        List<String> secondaryFormatNames = SECONDARY_DATA_FORMATS.get(settings);
    /**
        List<DataFormat> formats = getConfiguredFormats(indexSettings, dataFormatRegistry);  
            contentType,
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;  
     * The primary format is the authoritative format used for merge operations.
     * Maximum total size of writer segments that will be merged inline during refresh.  
            dataFormatRegistry.getRegisteredFormats()
            }
                            "index setting ["
        "cluster.restrict.composite.dataformat",
    ) {
    }
    public CompositeDataFormatPlugin() {}  
            new ActionPlugin.ActionHandler<>(CompositeStatsActionType.INSTANCE, CompositeStatsTransportAction.class),  
        return Collections.singletonList(new IndexSettingProvider() {  
     * Populated during {@link #createComponents} so the {@link IndexSettingProvider} registered by  
                                + "] cannot differ from cluster default "  
        "index.composite.primary_data_format",
    }
                List<String> clusterSecondary = clusterSettings.get(CLUSTER_SECONDARY_DATA_FORMATS);  
     * When the index setting is not explicitly provided, this cluster setting is used as the fallback.
/**  
import org.opensearch.index.IndexSettings;
                    out.putList(SECONDARY_DATA_FORMATS.getKey(), clusterSecondary);
     * to the sub-plugin without re-entering this composite.
                    + ". Configured formats: "
        ClusterSettings clusterSettings,  
 * <p>Format plugins (e.g., Parquet) extend this plugin by declaring
        }
import org.opensearch.plugins.ActionPlugin;
        Settings settings = indexSettings.getSettings();
                if (restrict) {
                        throw new IndexCreationException(indexName, validationException);
            }
import org.opensearch.index.mapper.MappedFieldType;
            if (secondaryName != null && secondaryName.isEmpty() == false) {
            .sorted(Comparator.comparingLong(DataFormat::priority))  
        String primaryFormatName = PRIMARY_DATA_FORMAT.get(settings);
        Setting.Property.IndexScope,
}
        fieldType.setCapabilityMap(Map.copyOf(assigned));  
        String formatName
            if (claimed.isEmpty() == false) {
     * (primary + secondary), keyed by format name. Mirrors {@link #getFormatDescriptors}:
                    }
                    }  
 */
        Supplier<RepositoriesService> repositoriesServiceSupplier
        if (primaryFormatName != null) {
        }  
 * and implementing {@link DataFormatPlugin}.  
    public static final Setting<ByteSizeValue> MERGE_ON_REFRESH_MAX_SIZE = Setting.byteSizeSetting(
     *  
                                + " when ["
                        && PRIMARY_DATA_FORMAT.get(templateAndRequestSettings).equals(clusterPrimary) == false) {
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;  
        String primaryFormatName = PRIMARY_DATA_FORMAT.get(settings);  
     */
                                + "=true]"
                    Set<FieldTypeCapabilities.Capability> intersection = EnumSet.noneOf(FieldTypeCapabilities.Capability.class);
        List<ParametrizedFieldMapper.Parameter<?>> result = new ArrayList<>();  
                assigned.put(format, Set.copyOf(claimed));
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings) {
import org.opensearch.core.action.ActionResponse;  
    }
 *
            if (remaining.isEmpty()) {
        }  
 * orchestrating multi-format indexing. Discovers {@link DataFormatPlugin}
     * Aggregates the mapping parameters contributed by every participating sub-format plugin
        Map<DataFormat, Set<FieldTypeCapabilities.Capability>> assigned = new HashMap<>();
import java.util.EnumSet;
        "cluster.composite.primary_data_format",
 *       formats (default empty)</li>
import java.util.List;
    @Override  
 * creates a composite engine when composite indexing is enabled for an index.
     * If enabled, this cluster setting enforces that indexes will be created with composite data-format settings  
import org.opensearch.watcher.ResourceWatcherService;
     * Secondary formats receive writes alongside the primary but are not used
    public List<RestHandler> getRestHandlers(  
        return List.of(
import java.util.Set;
                    if (errors.isEmpty() == false) {
            }  
                .orElse(Set.of());  
        Settings settings,
        return Map.copyOf(strategies);  
                                + clusterPrimary
        List<String> secondaryFormatNames = SECONDARY_DATA_FORMATS.get(settings);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    /**
     * <p>This is scoped to the composite plugin so restriction can be toggled independently of the server-level  
                    return Settings.EMPTY;
        Client client,
    public static final Setting<String> CLUSTER_PRIMARY_DATA_FORMAT = Setting.simpleString(
        NodeEnvironment nodeEnvironment,
 *   <li>{@code cluster.composite.secondary_data_formats} — cluster-level default for secondary formats</li>
     * {@link #SECONDARY_DATA_FORMATS} into newly created indices when those index-level settings
        return Map.of(RowIdFieldMapper.CONTENT_TYPE, RowIdFieldMapper.PARSER);
        for (String secondaryName : secondaryFormatNames) {
                    for (FieldTypeCapabilities.Capability cap : remaining) {
            }
    public static final Setting<List<String>> CLUSTER_SECONDARY_DATA_FORMATS = Setting.listSetting(  
            .filter(Objects::nonNull)
import org.opensearch.action.ActionRequest;  
                );
                }
     * Cluster-level default for {@code index.composite.secondary_data_formats}.  
import org.opensearch.repositories.RepositoriesService;
        Settings settings = indexSettings.getSettings();
                    + fieldType.name()
                                + "=true]"
        for (String secondaryName : secondaryFormatNames) {
 * compatible open source license.
     * {@code index.pluggable.dataformat.*} settings.
 * instances during node bootstrap via the {@link ExtensiblePlugin} SPI and  
        List<String> secondaryFormatNames = SECONDARY_DATA_FORMATS.get(settings);
            CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING,  
            public Settings getAdditionalIndexSettings(String indexName, boolean isDataStreamIndex, Settings templateAndRequestSettings) {
    ) {
 * can declare {@code extendedPlugins=['composite-engine']} in their plugin descriptors. This  
            settings.mapperService(),
     * formats implement nested storage.
     * Cluster-level default for {@code index.composite.primary_data_format}.
    }  
        );
     * with {@link FieldScope#ROOT}. Fields inside a nested scope are rejected until the composite  
     * are not supplied by the request or a matching template.  
    }  
        Map<DataFormat, StoreStrategy> strategies = new HashMap<>();  
                    return intersection;
            CLUSTER_PRIMARY_DATA_FORMAT,
            }
import org.opensearch.composite.stats.transport.CompositeNodeStatsRestAction;
        IndexSettings indexSettings,
                throw new IllegalArgumentException(  
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * <p>Registers two index settings:  
        if (fieldScope == FieldScope.NESTED) {
    /**  
        secondaryFormatNames.stream()
    public static final Setting<Boolean> CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING = Setting.boolSetting(
import org.opensearch.cluster.node.DiscoveryNodes;
import java.util.function.Supplier;  
 *   <li>{@code cluster.composite.primary_data_format} — cluster-level default for the primary format</li>
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        Set<FieldTypeCapabilities.Capability> requested = fieldType.requestedCapabilities();  
        s -> s,  
                        );
        ScriptService scriptService,
                return out.build();  
    /**  
                if (SECONDARY_DATA_FORMATS.exists(templateAndRequestSettings) == false) {  
import org.opensearch.index.mapper.ParametrizedFieldMapper;
            dataFormatRegistry.format(formatName)  
 *
    @Override
     * it; the parameterless-scope overload inherits the interface default, which delegates here
import org.opensearch.transport.client.Client;
    }
        }
    }
        List<String> secondaryFormatNames = SECONDARY_DATA_FORMATS.get(settings);
/*  
import org.opensearch.composite.stats.transport.CompositeStatsRestAction;
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
            strategies.putAll(dataFormatRegistry.getStoreStrategies(indexSettings, dataFormatRegistry.format(primaryFormatName)));
            throw new MapperParsingException(
        Setting.Property.Final
        return List.copyOf(configured);
     */
    }
                    if (PRIMARY_DATA_FORMAT.exists(templateAndRequestSettings)
        IndexNameExpressionResolver indexNameExpressionResolver,  
            }
        )) {
        ResourceWatcherService resourceWatcherService,
    @Override
            settings.committer(),  
    ) {
                                + "] when ["
     * {@link #PRIMARY_DATA_FORMAT} and {@link #SECONDARY_DATA_FORMATS} settings.
        }
        Set<String> seenNames,  
import org.opensearch.common.settings.Settings;  
    public static final Setting<String> PRIMARY_DATA_FORMAT = Setting.simpleString(
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;  
    }
        String contentType,
            fieldType.setCapabilityMap(Map.of());
        MappedFieldType fieldType,
                })
import java.util.Comparator;
        Setting.Property.NodeScope,
        ThreadPool threadPool,  
import org.opensearch.threadpool.ThreadPool;  
    }  
        this.clusterService = clusterService;
            CLUSTER_SECONDARY_DATA_FORMATS,
        "index.composite.merge_on_refresh_max_size",  
    );  
                .filter(f -> f.name().equals(primaryFormatName))
import org.opensearch.index.shard.IndexSettingProvider;  
        if (primaryFormatName != null && primaryFormatName.isEmpty() == false) {
     * Index setting that lists the secondary data formats for an index.  
     * Set to 0 to disable merge on refresh entirely.  
                "Field [" + fieldType.name() + "] is inside a nested object, which is not supported by the [composite] data format"  
import org.opensearch.plugins.MapperPlugin;  
     * <p>Overrides the scope-aware variant because {@link DataFormatRegistry} dispatches through
     * {@link #getAdditionalIndexSettingProviders()} can read live cluster-scope default settings
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
        String contentType,
import org.opensearch.rest.RestHandler;
                    List<String> errors = new ArrayList<>();  
    public List<Setting<?>> getSettings() {  
 * <p>And three cluster settings:
import org.opensearch.env.NodeEnvironment;  
import org.opensearch.composite.stats.transport.CompositeNodeStatsActionType;  
                break;  
        Setting.Property.NodeScope,
     * @throws IllegalArgumentException if two participating formats contribute a parameter with the same name  
            if (secondaryName != null) {  
     * {@link #CLUSTER_SECONDARY_DATA_FORMATS} by rejecting any request that specifies an index-level value
            return;  
    @Override  
 * Sandbox plugin that provides a {@link CompositeIndexingExecutionEngine} for
        if (primaryFormatName != null && primaryFormatName.isEmpty() == false) {
 * <ul>  
import java.util.Collections;  
     */  
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.index.mapper.MapperParsingException;  
    /**
 *       differ from the cluster defaults</li>
                .stream()  
     * as the merge authority.
        String primaryFormatName = PRIMARY_DATA_FORMAT.get(settings);  
        Setting.Property.IndexScope,
            settings.registry(),
                collectParameters(result, seenNames, dataFormatRegistry, contentType, indexSettings, secondaryName);
    public Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(
                .filter(ftc -> ftc.fieldType().equals(typeName))
    /**
            if (secondaryName != null && secondaryName.isEmpty() == false) {  
        }
                        validationException.addValidationErrors(errors);  
        String primaryFormatName = PRIMARY_DATA_FORMAT.get(settings);  
        }
     *  
 * {@code extendedPlugins = ['composite-engine']} in their {@code build.gradle}
        new CompositeStatsProvider();
        Setting.Property.NodeScope,
            settings.indexSettings(),
                            "index setting ["
                .findFirst()
     * <p>If {@link #createComponents} has not run yet (e.g. during early bootstrap), the provider
import org.opensearch.indices.IndicesService;
        return Map.copyOf(descriptors);
import org.opensearch.indices.IndexCreationException;
 * The OpenSearch Contributors require contributions made to  
        );
        IndexSettings indexSettings,  
    }  
    private static final Logger logger = LogManager.getLogger(CompositeDataFormatPlugin.class);  
            Set<FieldTypeCapabilities.Capability> claimed = format.supportedFields()
                        );
        IndexScopedSettings indexScopedSettings,
    /**  
        Map<String, Supplier<DataFormatDescriptor>> descriptors = new HashMap<>();
        return List.of(new CompositeStatsRestAction(), new CompositeNodeStatsRestAction());  
     * When the sum of all writer segment sizes exceeds this threshold, merge on refresh
                        ValidationException validationException = new ValidationException();
                                + PRIMARY_DATA_FORMAT.getKey()
        new ByteSizeValue(10, ByteSizeUnit.MB),
    @Override
            );
     * Returns the store strategies from every participating sub-format plugin
import java.util.stream.Collectors;
        for (ParametrizedFieldMapper.Parameter<?> param : dataFormatRegistry.getPluginMappingParameters(  
 * <p>Implements {@link ExtensiblePlugin} so that other data-format plugins (parquet, lucene)
        DataFormatRegistry dataFormatRegistry  
                remaining.removeAll(claimed);  
            .forEach(configured::add);
        Setting.Property.Dynamic  
        }
import java.util.HashSet;
        IndexSettings indexSettings,  
        // tracker via CompositeStatsProvider.getInstance() on construction.
        return Collections.emptyList();  
     * {@code cluster.restrict.pluggable.dataformat} flag that governs the core
        // Eagerly construct the provider so the registry is populated before the engine and
        if (requested.isEmpty()) {
                        errors.add(  
        }
                    }  
        Setting.Property.IndexScope,
                                + CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING.getKey()  
     */
package org.opensearch.composite;
        Setting.Property.Dynamic
                                + clusterSecondary
        IndexNameExpressionResolver indexNameExpressionResolver,
            PRIMARY_DATA_FORMAT,
                .findFirst()
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
     */  
        NamedXContentRegistry xContentRegistry,  
        // transport-action layers attempt lookups. The engine self-registers its per-shard  
            settings.store(),
            );
 *   <li>{@code index.composite.secondary_data_formats} — lists the secondary
                    if (SECONDARY_DATA_FORMATS.exists(templateAndRequestSettings)
 * </ul>
        "parquet",  
        Collections.emptyList(),  
            result.add(param);
    public void assignCapabilities(
                descriptors.putAll(dataFormatRegistry.getFormatDescriptors(indexSettings, dataFormatRegistry.format(secondaryName)));
import org.apache.logging.log4j.LogManager;
                if (PRIMARY_DATA_FORMAT.exists(templateAndRequestSettings) == false) {  
    private List<DataFormat> getConfiguredFormats(IndexSettings indexSettings, DataFormatRegistry dataFormatRegistry) {
    );
    @Override
            .map(name -> dataFormatRegistry.getRegisteredFormats().stream().filter(f -> f.name().equals(name)).findFirst().orElse(null))
                List<String> allowlist = clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST);
        if (remaining.isEmpty() == false) {
     * is skipped and segments are committed individually (background merge handles them later).
import java.util.Map;  
                .stream()  
import org.opensearch.core.common.unit.ByteSizeValue;  
 *
    /**
     *
import org.opensearch.composite.stats.transport.CompositeStatsTransportAction;
        String typeName = fieldType.typeName();  
                    }  
     * <p>Because both index settings are {@link Setting.Property#Final}, the effective value is
                if (clusterService == null) {  
    ) {
                                + CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING.getKey()  
     */
                ClusterSettings clusterSettings = clusterService.getClusterSettings();  
                    return Settings.EMPTY;
        return List.of(
     */
    @Override
 *
 * this file be licensed under the Apache-2.0 license or a
        RestController restController,
    ) {  
import org.opensearch.env.Environment;
        false,  
     * Assigns capabilities by delegating to primary format first, then secondaries in order.  
     */  
        DataFormatRegistry dataFormatRegistry
            @Override
     * affect only indices created after the update.
     * When the index setting is not explicitly provided, this cluster setting is used as the fallback.
 *  
        List<ParametrizedFieldMapper.Parameter<?>> result,
            fieldType.setCapabilityMap(Map.of());
import org.opensearch.composite.stats.transport.CompositeNodeStatsTransportAction;
        });
                    + "] requires capabilities "
        Settings settings = indexSettings.getSettings();
    public Collection<IndexSettingProvider> getAdditionalIndexSettingProviders() {
        Setting.Property.Dynamic
                if (allowlist.stream().anyMatch(indexName::startsWith)) {  
                    + remaining
        return List.copyOf(result);
            SECONDARY_DATA_FORMATS,  
 * </ul>  
     * (primary + secondary), for the given content type. Mirrors {@link #getStoreStrategies}:
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.FieldScope;
import java.util.HashMap;  
 * <ul>
        }
                                + "] cannot differ from cluster default ["  
    );  
     * Stamps the cluster-scope defaults for {@link #PRIMARY_DATA_FORMAT} and
    public Collection<Object> createComponents(  
    public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {  
     * frozen into the index metadata. Later updates to the {@code cluster.composite.*} settings
    /**
        Supplier<DiscoveryNodes> nodesInCluster
 *       format (default {@code "lucene"})</li>  
    private ClusterService clusterService;
import org.opensearch.index.engine.dataformat.StoreStrategy;
        DataFormatRegistry dataFormatRegistry,
                boolean restrict = clusterSettings.get(CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING);
        );
     * each participating format is resolved through the registry, which delegates  
                String clusterPrimary = clusterSettings.get(CLUSTER_PRIMARY_DATA_FORMAT);
        Set<String> seenNames = new HashSet<>();
            .filter(name -> name != null && name.isEmpty() == false)  
import org.opensearch.common.annotation.ExperimentalApi;
    public List<ParametrizedFieldMapper.Parameter<?>> getPluginMappingParameters(  
        Environment environment,
     * contributes no settings so that index creation falls back to the per-setting defaults.
import java.util.Objects;
     *
     * passed to the next format.
        }  
    public Map<DataFormat, StoreStrategy> getStoreStrategies(IndexSettings indexSettings, DataFormatRegistry dataFormatRegistry) {
    ) {  
 * makes composite-engine's bundled {@code plugin-stats-spi} classes available to those plugins'
            descriptors.putAll(dataFormatRegistry.getFormatDescriptors(indexSettings, dataFormatRegistry.format(primaryFormatName)));  
import org.opensearch.rest.RestController;  
    );  
 * classloaders — ensuring all formats share the same {@link DataFormatStatsProviderRegistry}.
        Setting.Property.Final  
            settings.checksumStrategies()  
    public static final Setting<List<String>> SECONDARY_DATA_FORMATS = Setting.listSetting(
import org.opensearch.plugins.Plugin;
    @Override  
        IndexSettings indexSettings,  
        Set<FieldTypeCapabilities.Capability> remaining = new HashSet<>(requested);
        s -> s,
        "cluster.composite.secondary_data_formats",
import org.opensearch.plugins.ExtensiblePlugin;
    @Override
                .map(ftc -> {  
import org.opensearch.common.settings.IndexScopedSettings;
     * resolved once at index-creation time from the live {@link ClusterSettings} registry and  
    /**  
    }
    @Override
import org.opensearch.composite.stats.transport.CompositeStatsActionType;  
     */  
                .ifPresent(configured::add);  
        }

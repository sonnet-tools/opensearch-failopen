        DataFormatRegistry dataFormatRegistry,
    @Override
     * matching the cluster-level defaults defined in {@link #CLUSTER_PRIMARY_DATA_FORMAT} and
        return List.of(new CompositeStatsRestAction(), new CompositeNodeStatsRestAction());
            }
                .stream()
    @Override
import org.opensearch.index.shard.IndexSettingProvider;
     */
    );
import org.opensearch.action.ActionRequest;
        "index.composite.secondary_data_formats",
 * <ul>
    }
                .findFirst()
import org.opensearch.watcher.ResourceWatcherService;
                    for (FieldTypeCapabilities.Capability cap : remaining) {
     * Secondary formats receive writes alongside the primary but are not used
     * are not supplied by the request or a matching template.
        List<String> secondaryFormatNames = SECONDARY_DATA_FORMATS.get(settings);
                                + PRIMARY_DATA_FORMAT.getKey()
            settings.checksumStrategies()
 *   <li>{@code cluster.composite.primary_data_format} — cluster-level default for the primary format</li>
 *
        "index.composite.merge_on_refresh_max_size",
    }
     */
     */
                                + clusterSecondary
        List<String> secondaryFormatNames = SECONDARY_DATA_FORMATS.get(settings);
import org.opensearch.composite.stats.CompositeStatsProvider;
                        }
                }
            Set<FieldTypeCapabilities.Capability> claimed = format.supportedFields()
    }
     * frozen into the index metadata. Later updates to the {@code cluster.composite.*} settings
     * affect only indices created after the update.
                                + "=true]"
@ExperimentalApi
                .map(ftc -> {
            settings.mapperService(),
     */
     *
import org.opensearch.core.action.ActionResponse;
        String primaryFormatName = PRIMARY_DATA_FORMAT.get(settings);
        Setting.Property.Dynamic
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
import org.opensearch.common.settings.IndexScopedSettings;
 * SPDX-License-Identifier: Apache-2.0
        Setting.Property.Final
     *
/*
import org.opensearch.env.Environment;
 * The OpenSearch Contributors require contributions made to
import java.util.HashMap;
        this.clusterService = clusterService;
        List<ParametrizedFieldMapper.Parameter<?>> result = new ArrayList<>();
                if (restrict) {
        List<String> secondaryFormatNames = SECONDARY_DATA_FORMATS.get(settings);
                            "index setting ["
        NamedWriteableRegistry namedWriteableRegistry,
                collectParameters(result, seenNames, dataFormatRegistry, contentType, indexSettings, secondaryName);
                    + "] of type ["
    /**
        }
    }
     * Stamps the cluster-scope defaults for {@link #PRIMARY_DATA_FORMAT} and
     * When the sum of all writer segment sizes exceeds this threshold, merge on refresh
                    if (PRIMARY_DATA_FORMAT.exists(templateAndRequestSettings)
     * as the merge authority.
        String contentType,
        );
     * {@link #getAdditionalIndexSettingProviders()} can read live cluster-scope default settings
        ThreadPool threadPool,
    );
    public static final Setting<ByteSizeValue> MERGE_ON_REFRESH_MAX_SIZE = Setting.byteSizeSetting(
     * Assigns capabilities by delegating to primary format first, then secondaries in order.
        return Map.of(RowIdFieldMapper.CONTENT_TYPE, RowIdFieldMapper.PARSER);
        return Collections.singletonList(new IndexSettingProvider() {
     * contributes no settings so that index creation falls back to the per-setting defaults.
            public Settings getAdditionalIndexSettings(String indexName, boolean isDataStreamIndex, Settings templateAndRequestSettings) {
            new ActionPlugin.ActionHandler<>(CompositeStatsActionType.INSTANCE, CompositeStatsTransportAction.class),
    /**
        DataFormatRegistry dataFormatRegistry
     * with {@link FieldScope#ROOT}. Fields inside a nested scope are rejected until the composite
            fieldType.setCapabilityMap(Map.of());
    @Override
            throw new MapperParsingException(
        Setting.Property.NodeScope,
            throw new MapperParsingException(
            );
     * @throws IllegalArgumentException if two participating formats contribute a parameter with the same name
    ) {
            if (secondaryName != null && secondaryName.isEmpty() == false) {
import org.opensearch.cluster.service.ClusterService;
                List<String> allowlist = clusterSettings.get(IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST);
 */
        Setting.Property.Final
import org.opensearch.plugins.Plugin;
    public Collection<IndexSettingProvider> getAdditionalIndexSettingProviders() {
    public static final Setting<String> CLUSTER_PRIMARY_DATA_FORMAT = Setting.simpleString(
                            intersection.add(cap);
import org.opensearch.composite.stats.transport.CompositeStatsRestAction;
        Settings settings = indexSettings.getSettings();
import org.opensearch.common.settings.Settings;
        Map<DataFormat, StoreStrategy> strategies = new HashMap<>();
        }
     *
import org.opensearch.index.engine.dataformat.StoreStrategy;
     */
     * resolved once at index-creation time from the live {@link ClusterSettings} registry and
                Settings.Builder out = Settings.builder();
 * makes composite-engine's bundled {@code plugin-stats-spi} classes available to those plugins'
        String primaryFormatName = PRIMARY_DATA_FORMAT.get(settings);
            .map(name -> dataFormatRegistry.getRegisteredFormats().stream().filter(f -> f.name().equals(name)).findFirst().orElse(null))
                    List<String> errors = new ArrayList<>();
     * If enabled, this cluster setting enforces that indexes will be created with composite data-format settings
    );
        Set<String> seenNames = new HashSet<>();
    /**
 *
                        );
        "index.composite.primary_data_format",
 *
        });
     * The primary format is the authoritative format used for merge operations.
import org.opensearch.core.xcontent.NamedXContentRegistry;
        return List.of(
        }
                .filter(ftc -> ftc.fieldType().equals(typeName))
import org.opensearch.core.common.unit.ByteSizeValue;
 */
                throw new IllegalArgumentException(
            if (secondaryName != null) {
    );
     *
        IndexSettings indexSettings,
                                + "=true]"
            descriptors.putAll(dataFormatRegistry.getFormatDescriptors(indexSettings, dataFormatRegistry.format(primaryFormatName)));
    }
     */
            return;
 * creates a composite engine when composite indexing is enabled for an index.
            .filter(Objects::nonNull)
     * Returns the store strategies from every participating sub-format plugin
import java.util.HashSet;
                "Field [" + fieldType.name() + "] is inside a nested object, which is not supported by the [composite] data format"
                .filter(f -> f.name().equals(primaryFormatName))
 * compatible open source license.
     * {@code index.pluggable.dataformat.*} settings.
import org.opensearch.indices.IndexCreationException;
            if (seenNames.add(param.name) == false) {
        Setting.Property.IndexScope,
        for (String secondaryName : secondaryFormatNames) {
     * <p>Because both index settings are {@link Setting.Property#Final}, the effective value is
    public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {
import java.util.Objects;
                "Field ["
        s -> s,
    @Override
     * {@link #PRIMARY_DATA_FORMAT} and {@link #SECONDARY_DATA_FORMATS} settings.
                if (allowlist.stream().anyMatch(indexName::startsWith)) {
                descriptors.putAll(dataFormatRegistry.getFormatDescriptors(indexSettings, dataFormatRegistry.format(secondaryName)));
        if (primaryFormatName != null && primaryFormatName.isEmpty() == false) {
                    + " but configured data formats cannot collectively cover: "
                        validationException.addValidationErrors(errors);
    /**
import org.opensearch.index.mapper.ParametrizedFieldMapper;
import org.opensearch.cluster.node.DiscoveryNodes;
    ) {
    @Override
            result.add(param);
        if (fieldScope == FieldScope.NESTED) {
 * <p>Format plugins (e.g., Parquet) extend this plugin by declaring
        }
                                + CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING.getKey()
     */
                        errors.add(
import java.util.Collections;
 * </ul>
                        && PRIMARY_DATA_FORMAT.get(templateAndRequestSettings).equals(clusterPrimary) == false) {
            }
    public static final Setting<List<String>> SECONDARY_DATA_FORMATS = Setting.listSetting(
 * can declare {@code extendedPlugins=['composite-engine']} in their plugin descriptors. This
                            "index setting ["
            CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING,
        }
 *
                    + fieldType.name()
            contentType,
 * <p>Implements {@link ExtensiblePlugin} so that other data-format plugins (parquet, lucene)
     * is skipped and segments are committed individually (background merge handles them later).
    /**
        Settings settings = indexSettings.getSettings();
     * Aggregates the mapping parameters contributed by every participating sub-format plugin
     * {@link #SECONDARY_DATA_FORMATS} into newly created indices when those index-level settings
        return List.of(
        return new CompositeIndexingExecutionEngine(
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings) {
        IndexNameExpressionResolver indexNameExpressionResolver,
 *   <li>{@code index.composite.secondary_data_formats} — lists the secondary
 * {@code extendedPlugins = ['composite-engine']} in their {@code build.gradle}
    public List<RestHandler> getRestHandlers(
        String formatName
import java.util.Map;
                    + formats.stream().map(DataFormat::name).collect(Collectors.toList())
     * Set to 0 to disable merge on refresh entirely.
        Setting.Property.NodeScope,
    }
    public Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(
    public Collection<Object> createComponents(
     * Index setting that designates the primary data format for an index.
        String primaryFormatName = PRIMARY_DATA_FORMAT.get(settings);
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
import org.opensearch.index.mapper.MapperParsingException;
import java.util.ArrayList;
import org.opensearch.rest.RestController;
    @Override
    private static void collectParameters(
            }
 * <p>And three cluster settings:
                        ValidationException validationException = new ValidationException();
    public CompositeDataFormatPlugin() {}
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    public List<ActionPlugin.ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
    ) {
        for (String secondaryName : secondaryFormatNames) {
     * Maximum total size of writer segments that will be merged inline during refresh.
        }
        if (primaryFormatName != null) {
        ScriptService scriptService,
            SECONDARY_DATA_FORMATS,
     * Index setting that lists the secondary data formats for an index.
 *   <li>{@code index.composite.primary_data_format} — designates the primary
     */
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
 * classloaders — ensuring all formats share the same {@link DataFormatStatsProviderRegistry}.
        for (ParametrizedFieldMapper.Parameter<?> param : dataFormatRegistry.getPluginMappingParameters(
        Setting.Property.Dynamic
        Collections.emptyList(),
 * instances during node bootstrap via the {@link ExtensiblePlugin} SPI and
    @Override
import org.opensearch.transport.client.Client;
 * <ul>
 *
        List<DataFormat> configured = new ArrayList<>();
        Map<DataFormat, Set<FieldTypeCapabilities.Capability>> assigned = new HashMap<>();
 * and implementing {@link DataFormatPlugin}.
                        && SECONDARY_DATA_FORMATS.get(templateAndRequestSettings).equals(clusterSecondary) == false) {
import org.opensearch.composite.stats.transport.CompositeNodeStatsTransportAction;
        }
        Setting.Property.IndexScope,
            }
 *       differ from the cluster defaults</li>
                    return Settings.EMPTY;
        IndexNameExpressionResolver indexNameExpressionResolver,
    ) {
                if (SECONDARY_DATA_FORMATS.exists(templateAndRequestSettings) == false) {
        Collections.emptyList(),
        NodeEnvironment nodeEnvironment,
            CLUSTER_PRIMARY_DATA_FORMAT,
import org.opensearch.common.annotation.ExperimentalApi;
                break;
            }
     * passed to the next format.
    /**
import org.opensearch.plugins.ActionPlugin;
                String clusterPrimary = clusterSettings.get(CLUSTER_PRIMARY_DATA_FORMAT);
        Settings settings = indexSettings.getSettings();
            if (claimed.isEmpty() == false) {
 *   <li>{@code cluster.restrict.composite.dataformat} — when true, rejects index-level overrides that
            .sorted(Comparator.comparingLong(DataFormat::priority))
     * to the sub-plugin without re-entering this composite.
 *
            settings.registry(),
 *       formats (default empty)</li>
        List<String> secondaryFormatNames = SECONDARY_DATA_FORMATS.get(settings);
                    }
import org.opensearch.core.common.unit.ByteSizeUnit;
        }
        DataFormatRegistry dataFormatRegistry,
            if (remaining.isEmpty()) {
                        errors.add(
import org.opensearch.threadpool.ThreadPool;
    ) {
        if (primaryFormatName != null && primaryFormatName.isEmpty() == false) {
 * orchestrating multi-format indexing. Discovers {@link DataFormatPlugin}
    /**
            strategies.putAll(dataFormatRegistry.getStoreStrategies(indexSettings, dataFormatRegistry.format(primaryFormatName)));
 *   <li>{@code cluster.composite.secondary_data_formats} — cluster-level default for secondary formats</li>
        Set<FieldTypeCapabilities.Capability> remaining = new HashSet<>(requested);
        fieldType.setCapabilityMap(Map.copyOf(assigned));
     */
        IndexSettings indexSettings,
        Setting.Property.Dynamic
import org.opensearch.script.ScriptService;
                    out.putList(SECONDARY_DATA_FORMATS.getKey(), clusterSecondary);
    @Override
        Setting.Property.IndexScope,
                                + CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING.getKey()
        "cluster.composite.secondary_data_formats",
    public static final Setting<String> PRIMARY_DATA_FORMAT = Setting.simpleString(
            .forEach(configured::add);
import java.util.Collection;
                    if (SECONDARY_DATA_FORMATS.exists(templateAndRequestSettings)
     * Cluster-level default for {@code index.composite.secondary_data_formats}.
        Supplier<DiscoveryNodes> nodesInCluster
     * Cluster-level default for {@code index.composite.primary_data_format}.
import org.opensearch.common.settings.SettingsFilter;
                                + SECONDARY_DATA_FORMATS.getKey()
                if (PRIMARY_DATA_FORMAT.exists(templateAndRequestSettings) == false) {
     * <p>This is scoped to the composite plugin so restriction can be toggled independently of the server-level
        Settings settings = indexSettings.getSettings();
            CLUSTER_SECONDARY_DATA_FORMATS,
     * <p>Overrides the scope-aware variant because {@link DataFormatRegistry} dispatches through
        return new CompositeDataFormat();
    private ClusterService clusterService;
     * (primary + secondary), keyed by format name. Mirrors {@link #getFormatDescriptors}:
        return List.copyOf(result);
                    + "] requires capabilities "
        secondaryFormatNames.stream()
        return Map.copyOf(descriptors);
import org.opensearch.composite.stats.transport.CompositeStatsActionType;
 *       format (default {@code "lucene"})</li>
     */
                .findFirst()
            settings.indexSettings(),
        // transport-action layers attempt lookups. The engine self-registers its per-shard
        if (remaining.isEmpty() == false) {
        }
                    "Duplicate plugin mapping parameter [" + param.name + "] for content type [" + contentType + "]"
        if (requested.isEmpty()) {
                        if (ftc.capabilities().contains(cap)) {
import org.opensearch.plugins.MapperPlugin;
                .stream()
            }
            return;
        "parquet",
import org.opensearch.plugins.ExtensiblePlugin;
                );
        return List.copyOf(configured);
                }
        for (String secondaryName : secondaryFormatNames) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            PRIMARY_DATA_FORMAT,
import org.opensearch.rest.RestHandler;
     * it; the parameterless-scope overload inherits the interface default, which delegates here
                strategies.putAll(dataFormatRegistry.getStoreStrategies(indexSettings, dataFormatRegistry.format(secondaryName)));
    }
 * Sandbox plugin that provides a {@link CompositeIndexingExecutionEngine} for
    public static final Setting<Boolean> CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING = Setting.boolSetting(
                    }
            settings.store(),
        Set<String> seenNames,
     * <p>If {@link #createComponents} has not run yet (e.g. during early bootstrap), the provider
import org.opensearch.common.ValidationException;
    public List<Setting<?>> getSettings() {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.FieldScope;
        IndexSettings indexSettings,
        Set<FieldTypeCapabilities.Capability> requested = fieldType.requestedCapabilities();
        Map<String, Supplier<DataFormatDescriptor>> descriptors = new HashMap<>();
    @Override
    public static final Setting<List<String>> CLUSTER_SECONDARY_DATA_FORMATS = Setting.listSetting(
        List<ParametrizedFieldMapper.Parameter<?>> result,
     * {@code cluster.restrict.pluggable.dataformat} flag that governs the core
        // tracker via CompositeStatsProvider.getInstance() on construction.
    }
     * Each sub-format plugin claims the capabilities it supports; unclaimed capabilities are
    /**
        if (primaryFormatName != null && primaryFormatName.isEmpty() == false) {
            collectParameters(result, seenNames, dataFormatRegistry, contentType, indexSettings, primaryFormatName);
                    + typeName
        List<DataFormat> formats = getConfiguredFormats(indexSettings, dataFormatRegistry);
    }
        "cluster.composite.primary_data_format",
import org.opensearch.index.IndexSettings;
            if (secondaryName != null && secondaryName.isEmpty() == false) {
    }
        Client client,
            MERGE_ON_REFRESH_MAX_SIZE
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
        s -> s,
                    Set<FieldTypeCapabilities.Capability> intersection = EnumSet.noneOf(FieldTypeCapabilities.Capability.class);
        String primaryFormatName = PRIMARY_DATA_FORMAT.get(settings);
        Setting.Property.NodeScope,
 * </ul>
                    return Settings.EMPTY;
        );
        SettingsFilter settingsFilter,
            @Override
     * When the index setting is not explicitly provided, this cluster setting is used as the fallback.
import java.util.Set;
        FieldScope fieldScope
        for (DataFormat format : formats) {
        new ByteSizeValue(10, ByteSizeUnit.MB),
                .ifPresent(configured::add);
    @Override
package org.opensearch.composite;
        Settings settings,
        Supplier<RepositoriesService> repositoriesServiceSupplier
                })
    @Override
            fieldType.setCapabilityMap(Map.of());
                ClusterSettings clusterSettings = clusterService.getClusterSettings();
                        throw new IndexCreationException(indexName, validationException);
import org.opensearch.index.engine.dataformat.DataFormat;
        MappedFieldType fieldType,
        NamedXContentRegistry xContentRegistry,
     * each participating format is resolved through the registry, which delegates
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
        )) {
                boolean restrict = clusterSettings.get(CLUSTER_RESTRICT_COMPOSITE_DATAFORMAT_SETTING);
import org.opensearch.index.mapper.MappedFieldType;
     * formats implement nested storage.
            dataFormatRegistry.format(formatName)
                    + requested
            }
}
import org.opensearch.common.settings.Setting;
                return out.build();
     * (primary + secondary), for the given content type. Mirrors {@link #getStoreStrategies}:
    /**
        IndexScopedSettings indexScopedSettings,
     * sub-plugin without re-entering this composite.
import org.opensearch.composite.stats.transport.CompositeStatsTransportAction;
        }
    public List<ParametrizedFieldMapper.Parameter<?>> getPluginMappingParameters(
            .filter(name -> name != null && name.isEmpty() == false)
     * that does not match. If disabled, users may choose the composite data-format on a per-index basis using the
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
                        );
     * each participating format is resolved through the registry, which delegates to the
import org.opensearch.indices.IndicesService;
    }
import java.util.List;
                                + clusterPrimary
    ) {
import org.apache.logging.log4j.Logger;
        RestController restController,
    private List<DataFormat> getConfiguredFormats(IndexSettings indexSettings, DataFormatRegistry dataFormatRegistry) {
    }
            );
import java.util.function.Supplier;
                    return intersection;
            indexSettings,
                List<String> clusterSecondary = clusterSettings.get(CLUSTER_SECONDARY_DATA_FORMATS);
                assigned.put(format, Set.copyOf(claimed));
                    + ". Configured formats: "
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;
                                + "] when ["
    private static final Logger logger = LogManager.getLogger(CompositeDataFormatPlugin.class);
        }
    public DataFormat getDataFormat() {
                }
 * @opensearch.experimental
 * <p>Registers two index settings:
        if (formats.isEmpty()) {
public class CompositeDataFormatPlugin extends Plugin implements DataFormatPlugin, ExtensiblePlugin, MapperPlugin, ActionPlugin {
import org.opensearch.env.NodeEnvironment;
    );
import org.opensearch.repositories.RepositoriesService;
 * this file be licensed under the Apache-2.0 license or a
        "cluster.restrict.composite.dataformat",
    public Map<DataFormat, StoreStrategy> getStoreStrategies(IndexSettings indexSettings, DataFormatRegistry dataFormatRegistry) {
import java.util.stream.Collectors;
                                + " when ["
        return Collections.emptyList();
import org.opensearch.composite.stats.transport.CompositeNodeStatsRestAction;
/**
        );
                    }
    @Override
    }
     *
            settings.committer(),
     */
                }
        "parquet",
        String contentType,
        }
    /**
                    + remaining
        DataFormatRegistry dataFormatRegistry
import java.util.EnumSet;
                    if (errors.isEmpty() == false) {
        String typeName = fieldType.typeName();
     * at index-creation time.
        IndexSettings indexSettings,
        ClusterSettings clusterSettings,
     * {@link #CLUSTER_SECONDARY_DATA_FORMATS} by rejecting any request that specifies an index-level value
    }
import org.opensearch.index.mapper.MetadataFieldMapper;
        }
        return Map.copyOf(strategies);
     * When the index setting is not explicitly provided, this cluster setting is used as the fallback.
        false,
                                + "] cannot differ from cluster default "
    public void assignCapabilities(
import java.util.Comparator;
    );
        Environment environment,
                }
                                + "] cannot differ from cluster default ["
        ClusterService clusterService,
        ResourceWatcherService resourceWatcherService,
            new ActionPlugin.ActionHandler<>(CompositeNodeStatsActionType.INSTANCE, CompositeNodeStatsTransportAction.class)
                if (clusterService == null) {
        new CompositeStatsProvider();
                .orElse(Set.of());
                    out.put(PRIMARY_DATA_FORMAT.getKey(), clusterPrimary);
                remaining.removeAll(claimed);
import org.opensearch.composite.stats.transport.CompositeNodeStatsActionType;
import org.apache.logging.log4j.LogManager;
                    }
    /**
        // Eagerly construct the provider so the registry is populated before the engine and
import org.opensearch.common.settings.ClusterSettings;
            dataFormatRegistry.getRegisteredFormats()
        Setting.Property.Dynamic
     * Populated during {@link #createComponents} so the {@link IndexSettingProvider} registered by

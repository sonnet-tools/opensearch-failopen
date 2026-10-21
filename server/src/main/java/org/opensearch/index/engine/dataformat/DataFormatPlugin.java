     */
    IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings);
                    + " but data format ["
        DataFormatRegistry dataFormatRegistry
     * (e.g. {@code keyword}, {@code text}), as {@link ParametrizedFieldMapper.Parameter} instances; empty by default.
        }
     * @param dataFormatRegistry the registry, used by composite plugins to resolve sub-format plugins
     * triggering creation.
    }
import java.util.Map;
     * @param indexSettings the index settings
     *
        final Set<FieldTypeCapabilities.Capability> remaining = new HashSet<>(requested);
 *       <b>behavior</b> for how the format participates in the tiered store
    DataFormat getDataFormat();
     * @param contentType        the core field content type (e.g. {@code keyword}, {@code text})
            return (Set<FieldTypeCapabilities.Capability>) intersection;
 * SPDX-License-Identifier: Apache-2.0
    default void assignCapabilities(
        fieldType.setCapabilityMap(Map.copyOf(assigned));
                if (ftc.capabilities().contains(cap)) {
 * @opensearch.experimental
        return null;
 */
        return Map.of();
        DataFormatRegistry dataFormatRegistry,
    ) {
    default void assignCapabilities(MappedFieldType fieldType, IndexSettings indexSettings, DataFormatRegistry dataFormatRegistry) {
     */
     * Assigns the capability map on the given field type, additionally indicating whether the field is
import java.util.function.Supplier;
}
     */
     * Returns the data format with its declared capabilities and priority.
     * plugin does not support delete operations.
import java.util.LinkedHashMap;
     * data format from {@code indexSettings} and only calls the applicable plugin. Composite plugins override this to
     * fan out to their primary and secondary formats via {@code dataFormatRegistry}.
     *
     * claims all capabilities it supports for the field type. Composite plugins override this to
     * given index settings. Each entry maps a format name to a
 *       <b>describes</b> the format (name, checksum strategy, static
    }
     * @param fieldScope the field's mapping scope
        MappedFieldType fieldType,
    /**
     * Creates the indexing engine for the data format. This should be
     * @param committer the committer for durable delete tracking
            fieldType.setCapabilityMap(Map.of());
     */
     * Claims the capabilities that the given format supports for the specified field type.
     * <p>All cross-cutting work (per-shard lifecycle, seeding, routing, close) is handled
     * keyed by the format name the strategy applies to.
 * A plugin may provide one, both, or neither.
     * @param dataFormatRegistry the registry, used by composite plugins to resolve sub-format plugins
    default Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(
                    + "] of type ["
        IndexSettings indexSettings,
        String contentType,
                }
                "Field ["
        FieldScope fieldScope
    /**
     * <p>Contribution is scoped to the format(s) the index actually uses: the registry resolves the index's active
 * this file be licensed under the Apache-2.0 license or a
     * Callers that only need format names can use {@code keySet()} without
     * <p>Most plugins contribute a single entry (their own format). Composite plugins,
 * </ul>
        assignCapabilities(fieldType, indexSettings, dataFormatRegistry, FieldScope.ROOT);
 * The OpenSearch Contributors require contributions made to
        final DataFormat format = getDataFormat();
     *
     * @return the delete execution engine, or {@code null}
            throw new MapperParsingException(
    /**
package org.opensearch.index.engine.dataformat;
        String typeName,
     *
        if (claimed.isEmpty() == false) {
            Set<FieldTypeCapabilities.Capability> intersection = EnumSet.noneOf(FieldTypeCapabilities.Capability.class);
     * @return the strategies that apply, keyed by data format; never {@code null}
     */
        final Set<FieldTypeCapabilities.Capability> claimed = claimCapabilities(format, typeName, remaining);
     */
    default DeleteExecutionEngine<?> getDeleteExecutionEngine(Committer committer) {
 * Plugin interface for providing custom data format implementations.
     * composite plugin); a plugin backing a single format has nothing to restrict.
            return;
                    + remaining
 *
import org.opensearch.index.mapper.MapperParsingException;
     * A plugin that does not participate in the tiered store returns an empty map (default).
     * descriptor object creation until the descriptor is actually needed.
        final Map<DataFormat, Set<FieldTypeCapabilities.Capability>> assigned = new LinkedHashMap<>();
     * <p>The default implementation handles the single-format case: the plugin's own data format
     * @param fieldType the field type to assign capabilities to
     * @return the data format descriptor
            remaining.removeAll(claimed);
/*
        return List.of();
    }
            }
     * Returns the mapping parameters this plugin contributes to the core field mapper of the given content type
                    + "] requires capabilities "
     *
     */
     *
     * by the store layer. Plugins only declare strategies here.
import org.opensearch.index.mapper.MappedFieldType;
 * <p>There are two orthogonal pieces a plugin can contribute:
                    + fieldType.name()
            assigned.put(format, Set.copyOf(claimed));
 *   <li>{@link StoreStrategy} via {@link #getStoreStrategies} —
     *                           sub-format plugins
        if (remaining.isEmpty() == false) {
     * declared directly inside a {@code nested} object's scope. Only matters to a plugin that combines
     *
import java.util.EnumSet;
    ) {
        return format.supportedFields().stream().filter(ftc -> ftc.fieldType().equals(typeName)).findFirst().map(ftc -> {
        if (requested.isEmpty()) {
    }
    /**
        }).orElse(Set.of());
public interface DataFormatPlugin {
import org.opensearch.index.IndexSettings;
     * Assigns the capability map on the given field type. The plugin determines which capabilities
     * @param indexSettings      the index settings
        DataFormatRegistry dataFormatRegistry
     * @param dataFormatRegistry the registry, used by composite plugins to resolve sub-format plugins
     * @param dataFormatRegistry the registry, used by composite plugins to resolve
 * with the DataFormatRegistry during node bootstrap.
                    + "] cannot cover: "
    /**
     *
        }
import java.util.HashSet;
     * delegate to primary and secondary formats in priority order.
     * {@link MappedFieldType#setCapabilityMap}.
    default Map<DataFormat, StoreStrategy> getStoreStrategies(IndexSettings indexSettings, DataFormatRegistry dataFormatRegistry) {
     * @throws MapperParsingException if the field type's requested capabilities cannot be fully covered
        IndexSettings indexSettings,
    /**
        final String typeName = fieldType.typeName();
import org.opensearch.index.mapper.ParametrizedFieldMapper;
 *       (file ownership, remote layout, optional native registry).</li>
        return Map.of();
        Set<FieldTypeCapabilities.Capability> required
     *
     * instantiated per shard.
 *       capabilities). Per-index value data.</li>
     * which expose multiple formats per index, return one entry per participating format.
import org.opensearch.common.annotation.ExperimentalApi;
import java.util.List;
    default List<ParametrizedFieldMapper.Parameter<?>> getPluginMappingParameters(
    }
    /**
    /**
            );
@ExperimentalApi
     *
import org.opensearch.index.engine.exec.commit.Committer;
     * multiple sub-formats and must restrict which of them may claim capabilities there (e.g. the
    }
    ) {
 *
     * its data format(s) can provide for the field type and sets the result via
 * Plugins implement this to register their data format (e.g., Parquet, Lucene)
        IndexSettings indexSettings,
 *   <li>{@link DataFormatDescriptor} via {@link #getFormatDescriptors} —
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.FieldScope;
/**
                    + requested
     * Returns the strategies describing how this format participates in the tiered store,
        Set<FieldTypeCapabilities.Capability> requested = fieldType.requestedCapabilities();
     * @param indexSettings      the index settings, used to resolve the active data format(s)
     * Returns format descriptor suppliers for this plugin, filtered by the
    }
    ) {
 * compatible open source license.
     * @param fieldType the field type to assign capabilities to
 */
    static Set<FieldTypeCapabilities.Capability> claimCapabilities(
                    intersection.add(cap);
     */
import java.util.Set;
            for (FieldTypeCapabilities.Capability cap : required) {
 *
                    + format.name()
        DataFormat format,
     * @param indexSettings the index settings
    /**
        }
     * @throws MapperParsingException if the field type's requested capabilities cannot be fully covered
     * {@link Supplier} of its {@link DataFormatDescriptor}, deferring
     */
     * Returns the delete execution engine for this data format, or {@code null} if this
 * <ul>
                    + typeName

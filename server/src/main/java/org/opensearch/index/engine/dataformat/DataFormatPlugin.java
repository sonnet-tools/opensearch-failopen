     * <p>All cross-cutting work (per-shard lifecycle, seeding, routing, close) is handled  
        MappedFieldType fieldType,  
     *
    }  
                    intersection.add(cap);  
@ExperimentalApi
    /**  
                    + requested
     */  
        DataFormatRegistry dataFormatRegistry  
 * with the DataFormatRegistry during node bootstrap.
     *
     * @throws MapperParsingException if the field type's requested capabilities cannot be fully covered  
     * @return the data format descriptor
            }
    IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings);
import org.opensearch.index.IndexSettings;
import java.util.HashSet;
        String contentType,
    default Map<DataFormat, StoreStrategy> getStoreStrategies(IndexSettings indexSettings, DataFormatRegistry dataFormatRegistry) {
     * Returns the mapping parameters this plugin contributes to the core field mapper of the given content type
    }
                if (ftc.capabilities().contains(cap)) {
     * @param dataFormatRegistry the registry, used by composite plugins to resolve
     *  
     */
     * Returns the delete execution engine for this data format, or {@code null} if this
     * Returns the data format with its declared capabilities and priority.  
     * @param dataFormatRegistry the registry, used by composite plugins to resolve sub-format plugins
     * @param committer the committer for durable delete tracking
        if (claimed.isEmpty() == false) {
 * </ul>  
    default DeleteExecutionEngine<?> getDeleteExecutionEngine(Committer committer) {
     * {@link MappedFieldType#setCapabilityMap}.
     *
    }  
    }  
    }  
     * plugin does not support delete operations.
        assignCapabilities(fieldType, indexSettings, dataFormatRegistry, FieldScope.ROOT);
                    + fieldType.name()
 * this file be licensed under the Apache-2.0 license or a
     * Assigns the capability map on the given field type. The plugin determines which capabilities  
        DataFormat format,
    ) {
    ) {
                    + "] of type ["
        fieldType.setCapabilityMap(Map.copyOf(assigned));  
            throw new MapperParsingException(
     * given index settings. Each entry maps a format name to a
     */  
        return format.supportedFields().stream().filter(ftc -> ftc.fieldType().equals(typeName)).findFirst().map(ftc -> {
     * A plugin that does not participate in the tiered store returns an empty map (default).
import org.opensearch.index.mapper.ParametrizedFieldMapper;
        IndexSettings indexSettings,
        IndexSettings indexSettings,
 *       <b>describes</b> the format (name, checksum strategy, static
            );
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.FieldScope;  
     * @param fieldScope the field's mapping scope
package org.opensearch.index.engine.dataformat;
     * data format from {@code indexSettings} and only calls the applicable plugin. Composite plugins override this to
 */
     * @param fieldType the field type to assign capabilities to
                    + typeName  
    /**  
     * @param dataFormatRegistry the registry, used by composite plugins to resolve sub-format plugins
    ) {
                    + format.name()
 *       capabilities). Per-index value data.</li>
     */  
     * @param indexSettings the index settings  
        final Set<FieldTypeCapabilities.Capability> claimed = claimCapabilities(format, typeName, remaining);
        }
 * Plugins implement this to register their data format (e.g., Parquet, Lucene)
        String typeName,
     * Assigns the capability map on the given field type, additionally indicating whether the field is  
     * descriptor object creation until the descriptor is actually needed.  
     * @return the delete execution engine, or {@code null}
 *  
     * declared directly inside a {@code nested} object's scope. Only matters to a plugin that combines
     * {@link Supplier} of its {@link DataFormatDescriptor}, deferring
        DataFormatRegistry dataFormatRegistry  
import java.util.function.Supplier;  
        if (requested.isEmpty()) {  
        Set<FieldTypeCapabilities.Capability> requested = fieldType.requestedCapabilities();
                    + remaining  
        }
import org.opensearch.common.annotation.ExperimentalApi;
     * <p>The default implementation handles the single-format case: the plugin's own data format
     * @param fieldType the field type to assign capabilities to
    default List<ParametrizedFieldMapper.Parameter<?>> getPluginMappingParameters(  
     */  
     *                           sub-format plugins
     * Callers that only need format names can use {@code keySet()} without
     * multiple sub-formats and must restrict which of them may claim capabilities there (e.g. the
     *  
        DataFormatRegistry dataFormatRegistry,
     * @param contentType        the core field content type (e.g. {@code keyword}, {@code text})
     * @param indexSettings      the index settings, used to resolve the active data format(s)  
     * Creates the indexing engine for the data format. This should be
        return Map.of();  
 *
     * @param indexSettings the index settings  
     * @throws MapperParsingException if the field type's requested capabilities cannot be fully covered
import java.util.Map;
     * <p>Contribution is scoped to the format(s) the index actually uses: the registry resolves the index's active
/**
 * <p>There are two orthogonal pieces a plugin can contribute:
 * A plugin may provide one, both, or neither.
 *   <li>{@link DataFormatDescriptor} via {@link #getFormatDescriptors} —  
import java.util.List;  
        return List.of();
 * compatible open source license.
     * @return the strategies that apply, keyed by data format; never {@code null}  
/*  
 * The OpenSearch Contributors require contributions made to  
     * claims all capabilities it supports for the field type. Composite plugins override this to
        final Map<DataFormat, Set<FieldTypeCapabilities.Capability>> assigned = new LinkedHashMap<>();
     * which expose multiple formats per index, return one entry per participating format.  
     * by the store layer. Plugins only declare strategies here.
    }
 *       (file ownership, remote layout, optional native registry).</li>
    default void assignCapabilities(
     * keyed by the format name the strategy applies to.  
    /**
public interface DataFormatPlugin {  
 *       <b>behavior</b> for how the format participates in the tiered store
     *
    /**
        if (remaining.isEmpty() == false) {
    /**  
                    + " but data format ["  
        IndexSettings indexSettings,
 */  
    /**
import org.opensearch.index.mapper.MapperParsingException;  
 *
        }).orElse(Set.of());
        final String typeName = fieldType.typeName();  
     */
}
            assigned.put(format, Set.copyOf(claimed));  
        }  
     *
 * @opensearch.experimental  
     * <p>Most plugins contribute a single entry (their own format). Composite plugins,
    /**
     *  
     */
import org.opensearch.index.engine.exec.commit.Committer;
     *
    default Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(
            fieldType.setCapabilityMap(Map.of());
     * Returns the strategies describing how this format participates in the tiered store,
     * triggering creation.
     * @param indexSettings      the index settings  
    }
            for (FieldTypeCapabilities.Capability cap : required) {
     * (e.g. {@code keyword}, {@code text}), as {@link ParametrizedFieldMapper.Parameter} instances; empty by default.
     * @param dataFormatRegistry the registry, used by composite plugins to resolve sub-format plugins
 * <ul>
import java.util.LinkedHashMap;
            return (Set<FieldTypeCapabilities.Capability>) intersection;  
     * instantiated per shard.
     */  
                "Field ["  
    static Set<FieldTypeCapabilities.Capability> claimCapabilities(  
    DataFormat getDataFormat();
     * its data format(s) can provide for the field type and sets the result via
                    + "] cannot cover: "
import java.util.Set;
            remaining.removeAll(claimed);
 * SPDX-License-Identifier: Apache-2.0
     * Claims the capabilities that the given format supports for the specified field type.
 * Plugin interface for providing custom data format implementations.  
     *
        return null;
            Set<FieldTypeCapabilities.Capability> intersection = EnumSet.noneOf(FieldTypeCapabilities.Capability.class);  
                }
     * fan out to their primary and secondary formats via {@code dataFormatRegistry}.  
    ) {
    /**  
        Set<FieldTypeCapabilities.Capability> required  
    /**
     * composite plugin); a plugin backing a single format has nothing to restrict.  
        final DataFormat format = getDataFormat();
     * Returns format descriptor suppliers for this plugin, filtered by the  
        return Map.of();
 *   <li>{@link StoreStrategy} via {@link #getStoreStrategies} —  
        final Set<FieldTypeCapabilities.Capability> remaining = new HashSet<>(requested);
        FieldScope fieldScope  
import org.opensearch.index.mapper.MappedFieldType;
import java.util.EnumSet;  
    default void assignCapabilities(MappedFieldType fieldType, IndexSettings indexSettings, DataFormatRegistry dataFormatRegistry) {
            return;
                    + "] requires capabilities "
     */
     * delegate to primary and secondary formats in priority order.  

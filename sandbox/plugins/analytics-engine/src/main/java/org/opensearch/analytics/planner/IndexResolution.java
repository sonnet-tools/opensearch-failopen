    }
        return concreteIndices.stream().mapToInt(IndexMetadata::getNumberOfShards).sum();  
                            + "] in ["
     * resolved members.
        // OpenSearch resolver so the concrete set matches every other search path. Schema
}
        return requestedName;
    }  
                continue;  
     * uses, so analytics honors {@code IndicesOptions}, hidden/system-index rules, exclusions, and  
    public String requestedName() {  
            // otherwise be read as a literal name. Splitting also lets the resolver honor
 * @opensearch.internal
        // tolerance — analytics queries plan once against a single row type, so divergence has
        }
                }
 * Resolves a table name (concrete index or alias) to the list of {@link IndexMetadata}
    private static void validateSchemaCompatibility(String aliasName, List<IndexMetadata> backing) {  
    public static IndexResolution resolve(String name, ClusterState clusterState, IndexNameExpressionResolver resolver) {  
            }  
            List<IndexMetadata> indices = new ArrayList<>(concrete.length);
            }
        this.concreteIndices = List.copyOf(concreteIndices);
 * into the query plan today, so honoring such an alias would silently return more rows than
                        + "]; "
        // Fallback: some test contexts stub {@code metadata().index(name)} without populating
            }  
    }
        for (IndexMetadata index : backing) {
        // contexts. Real cluster state always populates the lookup, so production resolution
            }
                            + previous.sourceIndex
        throw new IllegalArgumentException("Index or alias [" + name + "] not found in cluster state");
            if (index.getState() == IndexMetadata.State.OPEN) {
        }
        // declared type across all that mention it. Differs from OpenSearch core's per-shard
        validateSchemaCompatibility(dataStreamName, open);
            if (!(props instanceof Map<?, ?> propsMap)) {
        // (including aliases) flows through the branch above.  
        // Schema-compat check: every field that appears in any backing index must have the same  
import java.util.ArrayList;  
                        "Alias ["  
        return new IndexResolution(dataStreamName, open);  
import org.opensearch.analytics.schema.OpenSearchSchemaBuilder;
     * Resolves {@code name} against the cluster state. Literal concrete indices and aliases are
        return "IndexResolution{requested=" + requestedName + ", concrete=" + concreteIndexNames() + "}";  
                            + "]"  
    private final String requestedName;  
    }
                }
 * this file be licensed under the Apache-2.0 license or a
                open.add(index);
public final class IndexResolution {
import java.util.SortedMap;
    private static IndexResolution resolveDataStream(String dataStreamName, List<IndexMetadata> backing) {  
                // expansion otherwise. Literal data stream names take the abstraction short-circuit
     * security index filtering rather than a bespoke matcher.
                    indices.add(index);  
        // field name → (declared type, first index that declared it)  
                    // builder collapses text/keyword → VARCHAR, long/scaled_float → BIGINT, etc., so a
    public List<String> concreteIndexNames() {  
     * IndexNameExpressionResolver)} overload — without a resolver they fall through to the  
        return concreteIndices;  
import java.util.Map;
        java.util.Map<String, Decl> declared = new java.util.LinkedHashMap<>();  
                } else if (!Objects.equals(
                    OpenSearchSchemaBuilder.mapFieldType(type)  
    }
                    // from the schema) and are likewise treated as compatible.  
            AliasMetadata aliasMd = index.getAliases().get(aliasName);  
                            + fieldName  
                    OpenSearchSchemaBuilder.mapFieldType(previous.type),
            }
     * Convenience overload for literal names (concrete index or alias) and test contexts.
                        + index.getIndex().getName()  
 *
        for (IndexMetadata index : backing) {
                    continue;
                }
        }
        }
            try {
            }
        return concreteIndices.stream().map(im -> im.getIndex().getName()).toList();
            return new IndexResolution(name, List.of(direct));  
                IndexMetadata index = clusterState.metadata().index(concreteName);
        if (open.isEmpty()) {  
            throw new IllegalArgumentException("Data stream [" + dataStreamName + "] resolves only to closed indices");  
 * the user asked for. Data streams are likewise rejected for now.
        // Skip closed members — they cannot serve a search, and the wildcard/expression path
     * comma-separated, exclusion, and date-math expressions are delegated to the supplied
 * <p>Index expressions (comma lists, wildcards, exclusions, date-math) are resolved through the
     * {@link IndexNameExpressionResolver} — the same canonical resolution every other search path
import org.opensearch.cluster.metadata.MappingMetadata;
                String fieldName = String.valueOf(entry.getKey());  
     * not-found error.
                );  
            MappingMetadata mm = index.mapping();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * to the concrete indices that will actually serve the query. A concrete-index name returns
/**  
                validateSchemaCompatibility(name, indices);
        List<IndexMetadata> open = new ArrayList<>(backing.size());
    }  
        // converge on "closed indices are not searchable through analytics-engine".  
 * <p>Aliases that declare a filter are rejected — the planner does not weave alias filters  
                    continue;  
    /** Sum of {@code getNumberOfShards()} across all backing indices. */
        // Walks only top-level "properties" — a conflict on a nested object's leaf (e.g. a.b long
        return new IndexResolution(name, backing);  
                    // Compare the mapped Calcite type, not the raw OpenSearch type string: the schema  
                            + "] is ["
    public int totalShardCount() {
     * <p>Throws on missing names, filter aliases, data streams, and schema mismatches across the  
            // Comma-split before resolving: concreteIndexNames treats each vararg as one
        }
import org.opensearch.cluster.metadata.AliasMetadata;
        for (IndexMetadata index : open) {
import java.util.List;
        // managed by the rollover lifecycle and should have identical mappings, but manual
                            + "] resolves to indices with incompatible field types: ["
 * cluster's {@link IndexNameExpressionResolver} and unioned, with the same schema-compatibility
package org.opensearch.analytics.planner;
            }  
        // drop-in replacement for the prior {@code metadata().index(name)} lookup in those
            throw new IllegalArgumentException("Alias [" + aliasName + "] resolves only to closed indices");
import org.opensearch.cluster.metadata.IndexMetadata;  
    /** Backing concrete indices. Always size ≥ 1 for a successful resolution. */
            if (mm == null) {  
    public String toString() {
 * The OpenSearch Contributors require contributions made to  
        }
                )) {
            }
                            + previous.type
        }
            if (aliasMd != null && aliasMd.filteringRequired()) {
            if (index.getState() != IndexMetadata.State.OPEN) {
                Object fieldDef = entry.getValue();
        // planner does not weave the filter into the Calcite plan.
    }
        if (open.isEmpty()) {
        // Same closed-filter and schema-compat semantics as aliases. Data stream backings are
 */  
        // (lenientExpandOpen) already excludes them, so the alias path must match.
        // to be caught before planning.  
 *  
                if (previous == null) {
                        + aliasName
        // (which uses lenientExpandOpen). The wildcard / expression path resolves through the
            // exclusions across tokens (e.g. "test*,-test1").
        for (IndexMetadata index : backing) {
            Map<String, Object> source = mm.sourceAsMap();  
 * compatible open source license.
import org.opensearch.action.support.IndicesOptions;
            } catch (IndexNotFoundException e) {
                if (index != null) {
import org.opensearch.index.IndexNotFoundException;
        }
                case DATA_STREAM -> resolveDataStream(name, abstraction.getIndices());
    public static IndexResolution resolve(String name, ClusterState clusterState) {  
 * behind it, validating mapping compatibility across all backing indices.
    }
 * check applied across all matches.  
                continue;
    }
            if (!indices.isEmpty()) {  
                if (!(fieldDef instanceof Map<?, ?> fieldMap)) {
            }
    private static IndexResolution resolveAlias(String aliasName, List<IndexMetadata> backing) {  
        // canonical OpenSearch resolver, which also excludes closed indices — so all three paths
        // for data streams) and the per-error wording mentions "data stream" for clarity.
                    // union over those is compatible. Two unsupported types both map to null (dropped
        // Filter aliases would silently narrow the result set — reject up-front because the  
import org.opensearch.core.common.Strings;  
                // above (resolveDataStream) and skip the resolver entirely.  
        validateSchemaCompatibility(aliasName, open);
     * resolved directly (with filter-alias rejection and cross-member schema validation). Wildcard,  
                concrete = resolver.concreteIndexNames(clusterState, IndicesOptions.lenientExpandOpen(), true, expressions);
                        + "] declares a filter on index ["
    /**  
    private final List<IndexMetadata> concreteIndices;
 *
                open.add(index);  
        record Decl(String type, String sourceIndex) {
            for (Map.Entry<?, ?> entry : propsMap.entrySet()) {
        IndexAbstraction abstraction = lookup == null ? null : lookup.get(name);
                return new IndexResolution(name, indices);
    private static IndexResolution resolveConcrete(String name, List<IndexMetadata> backing) {
            };
                    );
        // {@code getIndicesLookup()}. Treat that as a concrete-index hit so this helper is a  
                if (type == null) {  
                case CONCRETE_INDEX -> resolveConcrete(name, abstraction.getIndices());
        // Not a literal name: treat as an index expression and resolve through the canonical
 *
                // expand to its backings — the resolver excludes data streams from wildcard
            Object props = source.get("properties");
        this.requestedName = requestedName;
 * <p>Used by the planner where a {@code TableScan}'s qualified name needs to be expanded
     */
 */  
        return new IndexResolution(aliasName, open);
 *  
    @SuppressWarnings("unchecked")
                            + type  
                Decl previous = declared.get(fieldName);  
                            + index.getIndex().getName()
                    "Alias ["  
    public List<IndexMetadata> concreteIndices() {
        // vs keyword) is not caught here and is left to the data node's by-name binding check.
        List<IndexMetadata> open = new ArrayList<>(backing.size());  
     * Wildcard/comma expressions require the {@link #resolve(String, ClusterState,
            // expression (the REST layer normally splits first), so a single "a,b" string would  
/*  
                        + "filter aliases are not yet supported by analytics queries"
    }
            return switch (abstraction.getType()) {
        SortedMap<String, IndexAbstraction> lookup = clusterState.metadata().getIndicesLookup();
                            + "] but ["
            }
            if (index.getState() == IndexMetadata.State.OPEN) {
                    declared.put(fieldName, new Decl(type, index.getIndex().getName()));
import java.util.Objects;  
import org.opensearch.cluster.metadata.IndexAbstraction;
        }  
        }
                            + aliasName
 * SPDX-License-Identifier: Apache-2.0
     */
    /** The name the caller asked to resolve — either a concrete index or an alias. */
 * every field present in any backing index has the same declared type in all others.
            String[] expressions = Strings.splitStringByCommaToArray(name);  
import org.opensearch.cluster.ClusterState;  
                case ALIAS -> resolveAlias(name, abstraction.getIndices());  
        IndexMetadata direct = clusterState.metadata().index(name);
        if (direct != null) {
        if (resolver != null) {
    }
     *
                    throw new IllegalArgumentException(
            String[] concrete;
    @Override
                // includeDataStreams=true so wildcards and comma-lists matching a data stream NAME  
        // mapping amendments can drift — so validate. Skip the filter-aliases check (irrelevant  
        // Reject closed indices on the literal-name path to match the alias path's behavior  
        // compatibility across the resolved union is validated just like an alias.  
                throw new IllegalArgumentException("Index [" + name + "] is closed");  
                String type = Objects.toString(fieldMap.get("type"), null);
        return resolve(name, clusterState, null);
    }  
    private IndexResolution(String requestedName, List<IndexMetadata> concreteIndices) {  
        }
    /**
                throw new IllegalArgumentException("Index or alias [" + name + "] not found in cluster state", e);  
                }
                            + "] in ["  
        if (abstraction != null) {  
            for (String concreteName : concrete) {  
                throw new IllegalArgumentException(
        for (IndexMetadata index : backing) {  
 * a singleton list; an alias returns the list of backing indices after validating that  

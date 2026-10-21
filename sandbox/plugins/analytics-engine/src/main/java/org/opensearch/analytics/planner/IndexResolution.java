                    continue;
                } else if (!Objects.equals(
     */
            }
 * into the query plan today, so honoring such an alias would silently return more rows than
        }
        // vs keyword) is not caught here and is left to the data node's by-name binding check.
import java.util.List;
                )) {
            String[] expressions = Strings.splitStringByCommaToArray(name);
                            + previous.type
                // includeDataStreams=true so wildcards and comma-lists matching a data stream NAME
    public List<IndexMetadata> concreteIndices() {
            }
import org.opensearch.index.IndexNotFoundException;
        // to be caught before planning.
    public static IndexResolution resolve(String name, ClusterState clusterState) {
                );
        validateSchemaCompatibility(aliasName, open);
        if (open.isEmpty()) {
            if (aliasMd != null && aliasMd.filteringRequired()) {
                            + "] but ["
                    OpenSearchSchemaBuilder.mapFieldType(previous.type),
                        + index.getIndex().getName()
    /**
            }
 * the user asked for. Data streams are likewise rejected for now.
                // expansion otherwise. Literal data stream names take the abstraction short-circuit
     * not-found error.
 * @opensearch.internal
import org.opensearch.analytics.schema.OpenSearchSchemaBuilder;
            return switch (abstraction.getType()) {
import java.util.ArrayList;
        // (which uses lenientExpandOpen). The wildcard / expression path resolves through the
        return concreteIndices.stream().mapToInt(IndexMetadata::getNumberOfShards).sum();
        for (IndexMetadata index : backing) {
}
import org.opensearch.core.common.Strings;
        return "IndexResolution{requested=" + requestedName + ", concrete=" + concreteIndexNames() + "}";
            List<IndexMetadata> indices = new ArrayList<>(concrete.length);
import java.util.SortedMap;
    public String toString() {
        return new IndexResolution(name, backing);
            if (!(props instanceof Map<?, ?> propsMap)) {
                    // union over those is compatible. Two unsupported types both map to null (dropped
    /** Sum of {@code getNumberOfShards()} across all backing indices. */
        // converge on "closed indices are not searchable through analytics-engine".
            }
public final class IndexResolution {
    public static IndexResolution resolve(String name, ClusterState clusterState, IndexNameExpressionResolver resolver) {
                Decl previous = declared.get(fieldName);
        // mapping amendments can drift — so validate. Skip the filter-aliases check (irrelevant
                continue;
            throw new IllegalArgumentException("Data stream [" + dataStreamName + "] resolves only to closed indices");
 * cluster's {@link IndexNameExpressionResolver} and unioned, with the same schema-compatibility
import org.opensearch.cluster.ClusterState;
        // canonical OpenSearch resolver, which also excludes closed indices — so all three paths
 * behind it, validating mapping compatibility across all backing indices.
                    "Alias ["
            return new IndexResolution(name, List.of(direct));
        // Skip closed members — they cannot serve a search, and the wildcard/expression path
                        "Alias ["
        for (IndexMetadata index : backing) {
 * check applied across all matches.
            Map<String, Object> source = mm.sourceAsMap();
                }
    public int totalShardCount() {
        if (direct != null) {
                validateSchemaCompatibility(name, indices);
                case CONCRETE_INDEX -> resolveConcrete(name, abstraction.getIndices());
import org.opensearch.cluster.metadata.MappingMetadata;
                        + "] declares a filter on index ["
            for (Map.Entry<?, ?> entry : propsMap.entrySet()) {
        return concreteIndices;
            String[] concrete;
        if (abstraction != null) {
     * IndexNameExpressionResolver)} overload — without a resolver they fall through to the
 * The OpenSearch Contributors require contributions made to
                if (index != null) {
 */
        this.requestedName = requestedName;
                    OpenSearchSchemaBuilder.mapFieldType(type)
            MappingMetadata mm = index.mapping();
                String type = Objects.toString(fieldMap.get("type"), null);
                if (previous == null) {
        this.concreteIndices = List.copyOf(concreteIndices);
            if (index.getState() == IndexMetadata.State.OPEN) {
        List<IndexMetadata> open = new ArrayList<>(backing.size());
 * SPDX-License-Identifier: Apache-2.0
    }
            } catch (IndexNotFoundException e) {
        return requestedName;
 * <p>Aliases that declare a filter are rejected — the planner does not weave alias filters
     * comma-separated, exclusion, and date-math expressions are delegated to the supplied
    }
                // expand to its backings — the resolver excludes data streams from wildcard
        }
            AliasMetadata aliasMd = index.getAliases().get(aliasName);
                continue;
                            + "]"
 */
 * Resolves a table name (concrete index or alias) to the list of {@link IndexMetadata}
                IndexMetadata index = clusterState.metadata().index(concreteName);
                    indices.add(index);
    }
            }
        }
                            + "] in ["
 * to the concrete indices that will actually serve the query. A concrete-index name returns
 *
                open.add(index);
                    // builder collapses text/keyword → VARCHAR, long/scaled_float → BIGINT, etc., so a
                            + aliasName
        // {@code getIndicesLookup()}. Treat that as a concrete-index hit so this helper is a
     *
        // Same closed-filter and schema-compat semantics as aliases. Data stream backings are
    private static void validateSchemaCompatibility(String aliasName, List<IndexMetadata> backing) {
        // field name → (declared type, first index that declared it)
    /**
    private final String requestedName;
    }
                throw new IllegalArgumentException("Index [" + name + "] is closed");
        // Reject closed indices on the literal-name path to match the alias path's behavior
    private static IndexResolution resolveDataStream(String dataStreamName, List<IndexMetadata> backing) {
        return new IndexResolution(aliasName, open);
                            + previous.sourceIndex
import org.opensearch.cluster.metadata.IndexAbstraction;
            if (!indices.isEmpty()) {
        // for data streams) and the per-error wording mentions "data stream" for clarity.
        // Fallback: some test contexts stub {@code metadata().index(name)} without populating
                        + aliasName
        // Schema-compat check: every field that appears in any backing index must have the same
        return resolve(name, clusterState, null);
import org.opensearch.cluster.metadata.AliasMetadata;
     * uses, so analytics honors {@code IndicesOptions}, hidden/system-index rules, exclusions, and
    public String requestedName() {
        // planner does not weave the filter into the Calcite plan.
    }
import java.util.Map;
            Object props = source.get("properties");
        }
        }
 *
import java.util.Objects;
                            + index.getIndex().getName()
                throw new IllegalArgumentException(
                throw new IllegalArgumentException("Index or alias [" + name + "] not found in cluster state", e);
            try {
            }
        // managed by the rollover lifecycle and should have identical mappings, but manual
                // above (resolveDataStream) and skip the resolver entirely.
/*
    public List<String> concreteIndexNames() {
            // exclusions across tokens (e.g. "test*,-test1").
        // Not a literal name: treat as an index expression and resolve through the canonical
        IndexMetadata direct = clusterState.metadata().index(name);
                    // from the schema) and are likewise treated as compatible.
            // Comma-split before resolving: concreteIndexNames treats each vararg as one
        // declared type across all that mention it. Differs from OpenSearch core's per-shard
                            + fieldName
     * <p>Throws on missing names, filter aliases, data streams, and schema mismatches across the
            }
        for (IndexMetadata index : open) {
 * a singleton list; an alias returns the list of backing indices after validating that
     * {@link IndexNameExpressionResolver} — the same canonical resolution every other search path
        java.util.Map<String, Decl> declared = new java.util.LinkedHashMap<>();
    @SuppressWarnings("unchecked")
            // otherwise be read as a literal name. Splitting also lets the resolver honor
        SortedMap<String, IndexAbstraction> lookup = clusterState.metadata().getIndicesLookup();
        // Walks only top-level "properties" — a conflict on a nested object's leaf (e.g. a.b long
 * every field present in any backing index has the same declared type in all others.
        for (IndexMetadata index : backing) {
            if (mm == null) {
        // contexts. Real cluster state always populates the lookup, so production resolution
    }
    }
                concrete = resolver.concreteIndexNames(clusterState, IndicesOptions.lenientExpandOpen(), true, expressions);
     * Convenience overload for literal names (concrete index or alias) and test contexts.
    private static IndexResolution resolveAlias(String aliasName, List<IndexMetadata> backing) {
 *
            }
        IndexAbstraction abstraction = lookup == null ? null : lookup.get(name);
     */
            };
                    throw new IllegalArgumentException(
            throw new IllegalArgumentException("Alias [" + aliasName + "] resolves only to closed indices");
                            + "] in ["
                }
                        + "filter aliases are not yet supported by analytics queries"
    }
    }
    }
                    continue;
        validateSchemaCompatibility(dataStreamName, open);
     * Resolves {@code name} against the cluster state. Literal concrete indices and aliases are
                        + "]; "
        if (resolver != null) {
                    // Compare the mapped Calcite type, not the raw OpenSearch type string: the schema
        }
/**
     * resolved members.
 * this file be licensed under the Apache-2.0 license or a
                            + "] is ["
    }
            for (String concreteName : concrete) {
     * resolved directly (with filter-alias rejection and cross-member schema validation). Wildcard,
        record Decl(String type, String sourceIndex) {
                case DATA_STREAM -> resolveDataStream(name, abstraction.getIndices());
                if (type == null) {
        }
        }
     * security index filtering rather than a bespoke matcher.
        }
        throw new IllegalArgumentException("Index or alias [" + name + "] not found in cluster state");
    private IndexResolution(String requestedName, List<IndexMetadata> concreteIndices) {
        // OpenSearch resolver so the concrete set matches every other search path. Schema
        // compatibility across the resolved union is validated just like an alias.
            if (index.getState() == IndexMetadata.State.OPEN) {
                Object fieldDef = entry.getValue();
        return new IndexResolution(dataStreamName, open);
                if (!(fieldDef instanceof Map<?, ?> fieldMap)) {
        // drop-in replacement for the prior {@code metadata().index(name)} lookup in those
            if (index.getState() != IndexMetadata.State.OPEN) {
                String fieldName = String.valueOf(entry.getKey());
        // Filter aliases would silently narrow the result set — reject up-front because the
                    );
                            + type
            }
        if (open.isEmpty()) {
                open.add(index);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    declared.put(fieldName, new Decl(type, index.getIndex().getName()));
    /** The name the caller asked to resolve — either a concrete index or an alias. */
    private final List<IndexMetadata> concreteIndices;
     * Wildcard/comma expressions require the {@link #resolve(String, ClusterState,
                case ALIAS -> resolveAlias(name, abstraction.getIndices());
            }
                return new IndexResolution(name, indices);
        // (including aliases) flows through the branch above.
        List<IndexMetadata> open = new ArrayList<>(backing.size());
            // expression (the REST layer normally splits first), so a single "a,b" string would
                            + "] resolves to indices with incompatible field types: ["
 * <p>Index expressions (comma lists, wildcards, exclusions, date-math) are resolved through the
        }
    @Override
        return concreteIndices.stream().map(im -> im.getIndex().getName()).toList();
    }
        }
import org.opensearch.action.support.IndicesOptions;
package org.opensearch.analytics.planner;
        for (IndexMetadata index : backing) {
                }
        // (lenientExpandOpen) already excludes them, so the alias path must match.
 *
    private static IndexResolution resolveConcrete(String name, List<IndexMetadata> backing) {
        // tolerance — analytics queries plan once against a single row type, so divergence has
    /** Backing concrete indices. Always size ≥ 1 for a successful resolution. */
 * <p>Used by the planner where a {@code TableScan}'s qualified name needs to be expanded
 *
                }
import org.opensearch.cluster.metadata.IndexMetadata;
 * compatible open source license.

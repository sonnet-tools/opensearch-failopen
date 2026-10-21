            for (DelegationType type : caps.supportedDelegations()) {
        return operatorIndex.getOrDefault(capability, List.of());
        return result;
        return predicateSerializers.get(function);
    /**
        return fieldStorageFactory.apply(indexMetadata);
                        for (FieldType fieldType : standard.fieldTypes()) {
        }
    }
    public List<String> scanBackendsForField(FieldStorageInfo field) {
    public CapabilityRegistry(
                operatorIndex.computeIfAbsent(cap, k -> new ArrayList<>()).add(name);
        return result;
     * unioning their field sets. A singleton list resolves exactly as the single-index overload.
    // Backends that declared supportsLiteralEvaluation=true for a (function, fieldType)
                scanCapableBackends.add(name);
                    addToFormatMap(scanIndex, new ScanKey(cap.getClass(), fieldType), cap.formats(), name);
    public FieldStorageResolver resolveFieldStorage(IndexMetadata indexMetadata) {
    }
            for (Map.Entry<ScalarFunction, DelegatedPredicateSerializer> entry : caps.delegatedPredicateSerializers().entrySet()) {
    }
    }
            for (ScanCapability cap : caps.scanCapabilities()) {
            for (DelegationType type : caps.acceptedDelegations()) {
                    }
     */
        }
            }
        for (String format : field.getIndexFormats()) {
    public boolean isOpaqueOperation(String name) {
        AnalyticsSearchBackendPlugin backend = backendsByName.get(name);
    public FieldStorageResolver resolveFieldStorage(List<IndexMetadata> indices) {
    /** All backends that can scan this field's doc values across all its formats. */
 * Pre-indexed capability lookups for planner rules. Built once at plugin startup,
            // exists for each function actually delegated to this backend. Startup validation is
    private final Map<ScalarKey, List<String>> literalScalarIndex = new HashMap<>();
 *   <li>Extract repeated constructor indexing pattern into a shared helper</li>
package org.opensearch.analytics.planner;
    ) {
                switch (cap) {
    }
    public Set<String> projectCapableBackends() {
 *   <li>Pre-flatten format maps to eliminate per-call allocation in {@code allBackends}
 *       and {@code *ForField} methods</li>
        for (String format : formats) {
        if (indices.size() == 1) {
            // capabilities, and which functions are delegated depends on the query.
        for (AnalyticsSearchBackendPlugin backend : backends) {
                        for (FieldType fieldType : scalar.fieldTypes()) {
                    backend.getInstructionHandlerFactory();
    private final Map<ScalarKey, Map<String, List<String>>> scalarIndex = new HashMap<>();
                switch (cap) {
                delegationAcceptors.computeIfAbsent(type, k -> new ArrayList<>()).add(name);
     */
            String name = backend.name();
        if (backend == null) {
 * key record types, and per-call list allocations in {@code *ForField} methods:
        List<FieldStorageResolver> perIndex = new ArrayList<>(indices.size());
            for (EngineCapability cap : caps.supportedEngineCapabilities()) {
    // Non-format-scoped indexes
     */
                }
 */
import java.util.List;
    private final Map<String, Map<String, List<String>>> opaqueIndex = new HashMap<>();
    public Set<String> aggregateCapableBackends() {
                filterCapableBackends.add(name);
                    case FilterCapability.Standard standard -> {
        List<String> result = new ArrayList<>();
    }
    }
    // ---- Annotation handling ----
    }
            for (AggregateCapability cap : caps.aggregateCapabilities()) {
        return aggregateIndex.getOrDefault(new AggregateKey(function, fieldType), Map.of()).getOrDefault(format, List.of());
                            addToFormatMap(scalarIndex, new ScalarKey(scalar.function(), fieldType), scalar.formats(), name);
    /**
    private record ScanKey(Class<? extends ScanCapability> kind, FieldType fieldType) {
        return backends;
        return FieldStorageResolver.merged(perIndex);
    // Opaque operations keyed by name (e.g. "painless") rather than a typed key
        List<String> result = new ArrayList<>();
                                    .add(name);
                            + name
    public List<String> aggregateBackendsAnyFormat(AggregateFunction function, FieldType fieldType) {
    }
    private final Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory;
            backendsByName.put(name, backend);
     * backend executes the producing operator, so format-level pushdown isn't applicable.
        List<String> result = new ArrayList<>();
        FieldType fieldType = field.getFieldType();
 */
                    throw new IllegalStateException(
    }
    /** Backends that declared {@code supportsLiteralEvaluation=true} for this (function, fieldType). */
        for (String format : field.getDocValueFormats()) {
    public Set<String> joinCapableBackends() {
    private final Set<String> projectCapableBackends = new HashSet<>();
                        );
 *
    }
    }
}
        return aggregateCapableBackends;
    private final Map<DelegationType, List<String>> delegationAcceptors = new HashMap<>();
    private final Set<String> scanCapableBackends = new HashSet<>();
        return filterIndex.getOrDefault(new ScalarKey(function, fieldType), Map.of()).getOrDefault(format, List.of());
 *
    public List<String> filterBackends(ScalarFunction function, FieldType fieldType, String format) {
    public List<String> opaqueBackendsAnyFormat(String name) {
     * Resolves field storage across all backing indices of a table (alias or index pattern),
import java.util.Set;
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory
        }
            for (ProjectCapability cap : caps.projectCapabilities()) {
        return delegationSupporters(delegationType).contains(candidate)
                }
        }
    public List<String> delegationSupporters(DelegationType type) {
    public List<String> operatorBackends(EngineCapability capability) {
        return filterCapableBackends;
    }
     * therefore has no doc-value or index format to match against — the filter must run at whichever
                aggregateCapableBackends.add(name);
    }
     * Used by the filter rule when the field is derived (e.g. produced by Union or Project) and
        return allBackends(scalarIndex.getOrDefault(new ScalarKey(function, fieldType), Map.of()));
    public List<String> scanBackends(Class<? extends ScanCapability> kind, FieldType fieldType, String format) {
    }
        }
    // ---- Single-format lookups ----
            for (FilterCapability cap : caps.filterCapabilities()) {
            }
        return delegationSupporters.getOrDefault(type, List.of());
    }
    private final Map<ScanKey, Map<String, List<String>>> scanIndex = new HashMap<>();
import java.util.HashMap;
import java.util.ArrayList;
        return result;
        this.fieldStorageFactory = fieldStorageFactory;
                                literalScalarIndex.computeIfAbsent(new ScalarKey(scalar.function(), fieldType), k -> new ArrayList<>())
 *
            result.addAll(names);
 * <ul>
     * keyword/text fields but not numeric fields, even when both have {@code indexFormats=[lucene]}.
        return allBackends(aggregateIndex.getOrDefault(new AggregateKey(function, fieldType), Map.of()));
 *       side effects of index population</li>
    public List<String> scalarBackendsAnyFormat(ScalarFunction function, FieldType fieldType) {
                            + " getInstructionHandlerFactory(). A driving backend must provide an instruction"
    }
            result.addAll(scanBackends(ScanCapability.Index.class, fieldType, format));
import org.opensearch.analytics.spi.FieldStorageInfo;
            if (!caps.joinCapabilities().isEmpty()) {
                    case ProjectCapability.Opaque opaque -> {
        return opaqueIndex.containsKey(name);
import java.util.function.Function;
 * compatible open source license.
    public boolean canHandle(String candidate, List<String> annotationViable, DelegationType delegationType) {
    // Shape: Map<Key, Map<format, List<backendName>>>
import org.opensearch.analytics.spi.ScalarFunction;
        for (String format : field.getDocValueFormats()) {
        }
            }
    /**
        List<AnalyticsSearchBackendPlugin> backends,
/*
                    addToFormatMap(aggregateIndex, new AggregateKey(cap.function(), fieldType), cap.formats(), name);
    public Set<String> scanCapableBackends() {
    }
    }
        }
        return result;
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
                predicateSerializers.putIfAbsent(entry.getKey(), entry.getValue());
public class CapabilityRegistry {
    private record FullTextParamKey(ScalarFunction function, FieldType fieldType, String backendName) {
                            + " handler factory to configure delegation at the data node."
    public List<String> delegationAcceptors(DelegationType type) {
            result.addAll(filterBackends(function, fieldType, format));
            perIndex.add(resolveFieldStorage(index));
                }
    }
    public List<String> literalScalarBackends(ScalarFunction function, FieldType fieldType) {
            if (caps.supportedDelegations().contains(DelegationType.FILTER)) {
    }
        return literalScalarIndex.getOrDefault(new ScalarKey(function, fieldType), List.of());
    private final Map<ScalarKey, Map<String, List<String>>> filterIndex = new HashMap<>();
                }
    private static List<String> allBackends(Map<String, List<String>> formatMap) {
                        fullTextParamIndex.put(
            BackendCapabilityProvider caps = backend.getCapabilityProvider();
                }
 *   <li>Derive {@code *CapableBackends} sets directly from backend capabilities, not as
            // indexing scheme was tied to the old marking-time ER insertion path and is
    }
    private record AggregateKey(AggregateFunction function, FieldType fieldType) {
        FieldType fieldType = field.getFieldType();
            }
    // Per-function delegated-predicate serializers, aggregated across backends (first declaration wins).
        return scanIndex.getOrDefault(new ScanKey(kind, fieldType), Map.of()).getOrDefault(format, List.of());
    }
            }
    /** All backends that can filter on this field across all its storage formats. */
    private record ScalarKey(ScalarFunction function, FieldType fieldType) {
            // Validate: if a backend supports FILTER delegation (i.e., it drives the tree walk),
        return joinCapableBackends;
 * <p>Single-format lookups return the stored list directly — no allocation at query time.
            result.addAll(filterBackends(function, fieldType, format));
            // it must provide a FragmentInstructionHandlerFactory for instruction-based execution.
     * references (including in-query-string fields).
            }
import org.opensearch.analytics.spi.AggregateCapability;
    // Besides producing execution bytes, a serializer can report a predicate's referenced fields at
        FieldType fieldType = field.getFieldType();
     * Whether a candidate backend can handle an annotated expression — either natively
import org.opensearch.analytics.spi.EngineCapability;
 * </ul>
    private final Map<EngineCapability, List<String>> operatorIndex = new HashMap<>();
    // ---- Field-level lookups (iterates all formats a field has) ----
    }
        return delegationAcceptors.getOrDefault(type, List.of());
                    }
    // ---- Scan lookups ----
    // O(1) backend lookup by name
import java.util.HashSet;
                delegationSupporters.computeIfAbsent(type, k -> new ArrayList<>()).add(name);
    // ---- Any-format lookups ----
        List<String> result = new ArrayList<>();
    private final Map<DelegationType, List<String>> delegationSupporters = new HashMap<>();
    }
                            }
                for (FieldType fieldType : cap.fieldTypes()) {
        if (annotationViable.contains(candidate)) return true;
    public DelegatedPredicateSerializer predicateSerializer(ScalarFunction function) {
    }
import org.opensearch.cluster.metadata.IndexMetadata;
    public List<String> aggregateBackendsForField(AggregateFunction function, FieldStorageInfo field) {
                    case FilterCapability.FullText fullText -> {
    private final Map<AggregateKey, Map<String, List<String>>> aggregateIndex = new HashMap<>();
        return allBackends(opaqueIndex.getOrDefault(name, Map.of()));
                    }
                    }
    // map suffices.
     * All backends declaring filter support for a (function, fieldType) ignoring storage formats.
                        Map<String, List<String>> formatMap = opaqueIndex.computeIfAbsent(opaque.name(), k -> new HashMap<>());
    public AnalyticsSearchBackendPlugin getBackend(String name) {
                        }
        for (IndexMetadata index : indices) {
    public Set<String> filterCapableBackends() {
        for (List<String> names : formatMap.values()) {
            && annotationViable.stream().anyMatch(delegationAcceptors(delegationType)::contains);
    /**
    }
            }
 * this file be licensed under the Apache-2.0 license or a
    public List<String> filterBackendsAnyFormat(ScalarFunction function, FieldType fieldType) {
 * @opensearch.internal
        return scanCapableBackends;
                    case ProjectCapability.Scalar scalar -> {
        }
    // ---- Backend access ----
        }
        }
                joinCapableBackends.add(name);
     * supports delegation and at least one viable backend accepts it).
        FieldType fieldType = field.getFieldType();
        return backend;
    /**
                            fullText.supportedParams()
 * Multi-format aggregations build a new list by collecting across entries.
        return result;
            result.addAll(aggregateBackends(function, fieldType, format));
    private final Set<String> joinCapableBackends = new HashSet<>();
     * {@code supportedFieldTypes} includes the field's type — so e.g. Lucene appears for
    // ---- Operator / delegation lookups ----
     * Backing indices with differing field sets are expected — the scan's row type is the union —
    private final List<AnalyticsSearchBackendPlugin> backends;
    }
    }
/**
            formatMap.computeIfAbsent(format, k -> new ArrayList<>()).add(backendName);
    private final Map<ScalarFunction, DelegatedPredicateSerializer> predicateSerializers = new HashMap<>();
                try {
import org.opensearch.analytics.spi.DelegationType;
    }
    public List<String> aggregateBackends(AggregateFunction function, FieldType fieldType, String format) {
        }
 * <p>TODO(refactor): This class has 10+ HashMaps with near-identical shapes, 4 redundant
    }
     * so each requested field is served by whichever index declares it.
    private final Set<String> aggregateCapableBackends = new HashSet<>();
    private final Map<FullTextParamKey, Set<String>> fullTextParamIndex = new HashMap<>();
import org.opensearch.analytics.spi.BackendCapabilityProvider;
        this.backends = backends;
    // ---- Keys ----
        List<String> result = new ArrayList<>();
    // planning time (referencedFields). Full-text is Lucene-only today, so a single function -> serializer
    private final Set<String> filterCapableBackends = new HashSet<>();
     * All backends that can scan this field's inverted index across all its formats. A backend
                        }
                    );
        Map<String, List<String>> formatMap = index.computeIfAbsent(key, k -> new HashMap<>());
     */
 *
    public List<String> filterBackendsForField(ScalarFunction function, FieldStorageInfo field) {
            // backend's capability provider — no per-format indexing here. M0's Equi/Theta
        return allBackends(filterIndex.getOrDefault(new ScalarKey(function, fieldType), Map.of()));
                            addToFormatMap(filterIndex, new ScalarKey(standard.function(), fieldType), standard.formats(), name);
import org.opensearch.analytics.spi.ProjectCapability;
            // Runtime validation in FragmentConversionDriver ensures a DelegatedPredicateSerializer
    private final Map<String, AnalyticsSearchBackendPlugin> backendsByName = new HashMap<>();
                            new FullTextParamKey(fullText.function(), fullText.fieldType(), name),
     * which full-text field-type validation uses to enumerate the fields a relevance predicate
            throw new IllegalArgumentException("No backend found with name [" + name + "]");
    // ---- Helpers ----
import org.opensearch.analytics.spi.FieldType;
 * SPDX-License-Identifier: Apache-2.0
    }
                for (FieldType fieldType : cap.supportedFieldTypes()) {
                            + "] declares supportedDelegations(FILTER) but does not implement"
    }
 * shared across all queries. All indexes eagerly constructed in constructor.
            // PR #21639's JoinCapability is consumed directly by OpenSearchJoinRule via the
                            formatMap.computeIfAbsent(format, k -> new ArrayList<>()).add(name);
    // Per-capability indexes: (capability key, format) → backends
import org.opensearch.analytics.spi.ScanCapability;
    // ---- Capable-backend sets ----
    // Backends that declared any capability for each operator — O(1) membership check
                projectCapableBackends.add(name);
     * (candidate is in the annotation's viable backends) or via delegation (candidate
import java.util.Map;
                } catch (UnsupportedOperationException exception) {
            result.addAll(scanBackends(ScanCapability.DocValues.class, fieldType, format));
        for (String format : field.getIndexFormats()) {
     * is returned only if it declares an {@link ScanCapability.Index} cap whose
            }
    private static <K> void addToFormatMap(Map<K, Map<String, List<String>>> index, K key, Set<String> formats, String backendName) {
                            if (scalar.supportsLiteralEvaluation()) {
        return projectCapableBackends;
    /** All backends that can aggregate on this field across all its storage formats. */
            // intentionally omitted — a backend may accept delegation for a subset of its filter
 *   <li>Unify key types (ScanKey, AggregateKey, ScalarKey) into a single record</li>
            // dead under the split-rule architecture.
                        "Backend ["
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
            }
                        for (String format : opaque.formats()) {
     * referenced fields at planning time via {@link DelegatedPredicateSerializer#referencedFields},
                        }
                        addToFormatMap(filterIndex, new ScalarKey(fullText.function(), fullText.fieldType()), fullText.formats(), name);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.analytics.spi.AggregateFunction;
    }
            }
    public List<String> indexScanBackendsForField(FieldStorageInfo field) {
     */
            return resolveFieldStorage(indices.get(0));
     * The {@link DelegatedPredicateSerializer} registered for {@code function}, or {@code null} if no
        for (String format : field.getDocValueFormats()) {
     * backend declared one. Besides producing execution bytes, the serializer exposes a predicate's
import org.opensearch.analytics.spi.FilterCapability;
    public List<AnalyticsSearchBackendPlugin> getBackends() {

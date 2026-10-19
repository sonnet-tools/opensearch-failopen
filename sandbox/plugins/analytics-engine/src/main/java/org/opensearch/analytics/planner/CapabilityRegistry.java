 *
    }
     * referenced fields at planning time via {@link DelegatedPredicateSerializer#referencedFields},
            for (EngineCapability cap : caps.supportedEngineCapabilities()) {
     */  
     * Resolves field storage across all backing indices of a table (alias or index pattern),
    public List<String> aggregateBackendsForField(AggregateFunction function, FieldStorageInfo field) {
    private final Map<ScalarKey, List<String>> literalScalarIndex = new HashMap<>();  
import org.opensearch.analytics.spi.AggregateCapability;
    // map suffices.
        return filterCapableBackends;
import java.util.Map;
                    case FilterCapability.Standard standard -> {
        return delegationSupporters(delegationType).contains(candidate)  
    }  
                operatorIndex.computeIfAbsent(cap, k -> new ArrayList<>()).add(name);
    public Set<String> aggregateCapableBackends() {
                scanCapableBackends.add(name);  
    public List<String> aggregateBackendsAnyFormat(AggregateFunction function, FieldType fieldType) {
                            + " getInstructionHandlerFactory(). A driving backend must provide an instruction"
                    addToFormatMap(aggregateIndex, new AggregateKey(cap.function(), fieldType), cap.formats(), name);  
     * supports delegation and at least one viable backend accepts it).
            // indexing scheme was tied to the old marking-time ER insertion path and is
                predicateSerializers.putIfAbsent(entry.getKey(), entry.getValue());
            // Runtime validation in FragmentConversionDriver ensures a DelegatedPredicateSerializer
        return projectCapableBackends;  
import org.opensearch.cluster.metadata.IndexMetadata;
            }  
            result.addAll(scanBackends(ScanCapability.DocValues.class, fieldType, format));  
            }
import java.util.Set;  
                    throw new IllegalStateException(
    // planning time (referencedFields). Full-text is Lucene-only today, so a single function -> serializer  
    }
    }
 *   <li>Unify key types (ScanKey, AggregateKey, ScalarKey) into a single record</li>
        return result;
                        Map<String, List<String>> formatMap = opaqueIndex.computeIfAbsent(opaque.name(), k -> new HashMap<>());
    ) {
 *   <li>Extract repeated constructor indexing pattern into a shared helper</li>  
    // ---- Single-format lookups ----
                            addToFormatMap(filterIndex, new ScalarKey(standard.function(), fieldType), standard.formats(), name);  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;  
 *   <li>Derive {@code *CapableBackends} sets directly from backend capabilities, not as
        List<String> result = new ArrayList<>();  
            // it must provide a FragmentInstructionHandlerFactory for instruction-based execution.
        if (indices.size() == 1) {
    public CapabilityRegistry(
    public List<String> scalarBackendsAnyFormat(ScalarFunction function, FieldType fieldType) {  
        this.backends = backends;
import java.util.HashSet;  
     * keyword/text fields but not numeric fields, even when both have {@code indexFormats=[lucene]}.  
        FieldType fieldType = field.getFieldType();  
        }
     */
     * unioning their field sets. A singleton list resolves exactly as the single-index overload.  
        return allBackends(opaqueIndex.getOrDefault(name, Map.of()));
import org.opensearch.analytics.spi.AggregateFunction;
            for (FilterCapability cap : caps.filterCapabilities()) {
     * backend executes the producing operator, so format-level pushdown isn't applicable.  
    }
 *
                    case ProjectCapability.Scalar scalar -> {  
    // Backends that declared any capability for each operator — O(1) membership check  
    public Set<String> scanCapableBackends() {
 * SPDX-License-Identifier: Apache-2.0
        return opaqueIndex.containsKey(name);  
        return scanCapableBackends;  
    private final Map<DelegationType, List<String>> delegationAcceptors = new HashMap<>();
            for (Map.Entry<ScalarFunction, DelegatedPredicateSerializer> entry : caps.delegatedPredicateSerializers().entrySet()) {  
    public List<String> scanBackends(Class<? extends ScanCapability> kind, FieldType fieldType, String format) {  
                        for (FieldType fieldType : standard.fieldTypes()) {
            result.addAll(aggregateBackends(function, fieldType, format));
    public List<AnalyticsSearchBackendPlugin> getBackends() {  
    // Per-capability indexes: (capability key, format) → backends
                            + "] declares supportedDelegations(FILTER) but does not implement"
    private final Map<String, AnalyticsSearchBackendPlugin> backendsByName = new HashMap<>();  
        return predicateSerializers.get(function);  
    // ---- Scan lookups ----
     * (candidate is in the annotation's viable backends) or via delegation (candidate
    public Set<String> joinCapableBackends() {  
 *  
    /**
    // ---- Field-level lookups (iterates all formats a field has) ----  
        return delegationSupporters.getOrDefault(type, List.of());
 * compatible open source license.
                        );
                }
    }
        }
    }
            }
    private record ScalarKey(ScalarFunction function, FieldType fieldType) {
    public Set<String> filterCapableBackends() {  
     * All backends declaring filter support for a (function, fieldType) ignoring storage formats.  
    public List<String> aggregateBackends(AggregateFunction function, FieldType fieldType, String format) {
                delegationSupporters.computeIfAbsent(type, k -> new ArrayList<>()).add(name);
     * Whether a candidate backend can handle an annotated expression — either natively  
    private final Map<DelegationType, List<String>> delegationSupporters = new HashMap<>();  
            if (!caps.joinCapabilities().isEmpty()) {
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
    private final Map<FullTextParamKey, Set<String>> fullTextParamIndex = new HashMap<>();
        if (annotationViable.contains(candidate)) return true;
            result.addAll(filterBackends(function, fieldType, format));
        return fieldStorageFactory.apply(indexMetadata);
                delegationAcceptors.computeIfAbsent(type, k -> new ArrayList<>()).add(name);
            for (DelegationType type : caps.acceptedDelegations()) {
            }  
            formatMap.computeIfAbsent(format, k -> new ArrayList<>()).add(backendName);
    private final Map<String, Map<String, List<String>>> opaqueIndex = new HashMap<>();
            // dead under the split-rule architecture.  
import org.opensearch.analytics.spi.FieldStorageInfo;
    private final Map<ScalarFunction, DelegatedPredicateSerializer> predicateSerializers = new HashMap<>();
        FieldType fieldType = field.getFieldType();
    }  
                for (FieldType fieldType : cap.fieldTypes()) {
            for (ProjectCapability cap : caps.projectCapabilities()) {
        return literalScalarIndex.getOrDefault(new ScalarKey(function, fieldType), List.of());  
    // Besides producing execution bytes, a serializer can report a predicate's referenced fields at
 * The OpenSearch Contributors require contributions made to  
        for (String format : formats) {  
    private final Map<ScanKey, Map<String, List<String>>> scanIndex = new HashMap<>();
    }
     * backend declared one. Besides producing execution bytes, the serializer exposes a predicate's  
        if (backend == null) {  
    /**
    private final Map<EngineCapability, List<String>> operatorIndex = new HashMap<>();
 * key record types, and per-call list allocations in {@code *ForField} methods:
    }
    public FieldStorageResolver resolveFieldStorage(IndexMetadata indexMetadata) {  
        return scanIndex.getOrDefault(new ScanKey(kind, fieldType), Map.of()).getOrDefault(format, List.of());
import org.opensearch.analytics.spi.ProjectCapability;
            }
     * {@code supportedFieldTypes} includes the field's type — so e.g. Lucene appears for
    /**
import java.util.function.Function;
     * which full-text field-type validation uses to enumerate the fields a relevance predicate
                    }
    public List<String> operatorBackends(EngineCapability capability) {  
    private final Set<String> scanCapableBackends = new HashSet<>();
        return result;
    // ---- Any-format lookups ----
     * Backing indices with differing field sets are expected — the scan's row type is the union —
                    );
     */
    }
        List<String> result = new ArrayList<>();
        List<String> result = new ArrayList<>();
    }
                }
    }
import org.opensearch.analytics.spi.DelegationType;  
        }
        return operatorIndex.getOrDefault(capability, List.of());
            perIndex.add(resolveFieldStorage(index));
        return result;
            BackendCapabilityProvider caps = backend.getCapabilityProvider();
    private final Set<String> aggregateCapableBackends = new HashSet<>();  
                            if (scalar.supportsLiteralEvaluation()) {  
    }
        for (List<String> names : formatMap.values()) {
 */
        Map<String, List<String>> formatMap = index.computeIfAbsent(key, k -> new HashMap<>());
        for (String format : field.getDocValueFormats()) {
        return backend;  
            }  
    private final Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory;
                    }
    public DelegatedPredicateSerializer predicateSerializer(ScalarFunction function) {
            result.addAll(names);
import org.opensearch.analytics.spi.FilterCapability;
                        for (FieldType fieldType : scalar.fieldTypes()) {
    private static List<String> allBackends(Map<String, List<String>> formatMap) {
                        addToFormatMap(filterIndex, new ScalarKey(fullText.function(), fullText.fieldType()), fullText.formats(), name);
        return result;
 *       side effects of index population</li>  
            throw new IllegalArgumentException("No backend found with name [" + name + "]");
        this.fieldStorageFactory = fieldStorageFactory;  
        return FieldStorageResolver.merged(perIndex);  
        List<FieldStorageResolver> perIndex = new ArrayList<>(indices.size());
        FieldType fieldType = field.getFieldType();
            // PR #21639's JoinCapability is consumed directly by OpenSearchJoinRule via the  
                    case FilterCapability.FullText fullText -> {  
        for (String format : field.getIndexFormats()) {  
                            fullText.supportedParams()
    }
                        "Backend ["
    public List<String> delegationAcceptors(DelegationType type) {
    public List<String> scanBackendsForField(FieldStorageInfo field) {
            && annotationViable.stream().anyMatch(delegationAcceptors(delegationType)::contains);
/*  
    }
    public boolean canHandle(String candidate, List<String> annotationViable, DelegationType delegationType) {
 *  
     * The {@link DelegatedPredicateSerializer} registered for {@code function}, or {@code null} if no
            // Validate: if a backend supports FILTER delegation (i.e., it drives the tree walk),
                joinCapableBackends.add(name);
            result.addAll(filterBackends(function, fieldType, format));
                switch (cap) {
        return allBackends(scalarIndex.getOrDefault(new ScalarKey(function, fieldType), Map.of()));
}  
        return backends;
    // ---- Operator / delegation lookups ----
    /** All backends that can aggregate on this field across all its storage formats. */  
                            formatMap.computeIfAbsent(format, k -> new ArrayList<>()).add(name);  
    private final Set<String> joinCapableBackends = new HashSet<>();
    // O(1) backend lookup by name
    }
        for (IndexMetadata index : indices) {  
    public List<String> filterBackendsAnyFormat(ScalarFunction function, FieldType fieldType) {
            for (AggregateCapability cap : caps.aggregateCapabilities()) {
    }
 *       and {@code *ForField} methods</li>
            // intentionally omitted — a backend may accept delegation for a subset of its filter  
        AnalyticsSearchBackendPlugin backend = backendsByName.get(name);
        }  
    // Per-function delegated-predicate serializers, aggregated across backends (first declaration wins).
        return result;  
     */  
 */  
            return resolveFieldStorage(indices.get(0));  
    public List<String> filterBackendsForField(ScalarFunction function, FieldStorageInfo field) {  
package org.opensearch.analytics.planner;
    private final Map<AggregateKey, Map<String, List<String>>> aggregateIndex = new HashMap<>();  
                        for (String format : opaque.formats()) {
    public boolean isOpaqueOperation(String name) {
    private record ScanKey(Class<? extends ScanCapability> kind, FieldType fieldType) {
            String name = backend.name();
     */
    }
        List<String> result = new ArrayList<>();
                aggregateCapableBackends.add(name);
            for (ScanCapability cap : caps.scanCapabilities()) {
                filterCapableBackends.add(name);
 * <p>TODO(refactor): This class has 10+ HashMaps with near-identical shapes, 4 redundant
 * shared across all queries. All indexes eagerly constructed in constructor.
import java.util.HashMap;
            for (DelegationType type : caps.supportedDelegations()) {
        return joinCapableBackends;
                    backend.getInstructionHandlerFactory();
            }  
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory  
                            new FullTextParamKey(fullText.function(), fullText.fieldType(), name),  
    public Set<String> projectCapableBackends() {
                    addToFormatMap(scanIndex, new ScanKey(cap.getClass(), fieldType), cap.formats(), name);
        return allBackends(aggregateIndex.getOrDefault(new AggregateKey(function, fieldType), Map.of()));
            result.addAll(scanBackends(ScanCapability.Index.class, fieldType, format));  
                    }
    // ---- Backend access ----
            }  
    }  
        }  
    // Backends that declared supportsLiteralEvaluation=true for a (function, fieldType)
/**  
 * <ul>  
        List<AnalyticsSearchBackendPlugin> backends,
        for (String format : field.getDocValueFormats()) {  
 * </ul>
import java.util.ArrayList;
import java.util.List;
     * so each requested field is served by whichever index declares it.
                        }
     * is returned only if it declares an {@link ScanCapability.Index} cap whose
        return delegationAcceptors.getOrDefault(type, List.of());  
            }  
            if (caps.supportedDelegations().contains(DelegationType.FILTER)) {  
    /** All backends that can scan this field's doc values across all its formats. */
    public List<String> delegationSupporters(DelegationType type) {
                } catch (UnsupportedOperationException exception) {  
    public List<String> opaqueBackendsAnyFormat(String name) {  
 * Pre-indexed capability lookups for planner rules. Built once at plugin startup,
import org.opensearch.analytics.spi.EngineCapability;
    }
            // exists for each function actually delegated to this backend. Startup validation is
        return filterIndex.getOrDefault(new ScalarKey(function, fieldType), Map.of()).getOrDefault(format, List.of());
                                literalScalarIndex.computeIfAbsent(new ScalarKey(scalar.function(), fieldType), k -> new ArrayList<>())
                        }
    /** Backends that declared {@code supportsLiteralEvaluation=true} for this (function, fieldType). */
    }
                            + " handler factory to configure delegation at the data node."  
    }  
                            }  
    private final Set<String> projectCapableBackends = new HashSet<>();
    }
                for (FieldType fieldType : cap.supportedFieldTypes()) {  
 *   <li>Pre-flatten format maps to eliminate per-call allocation in {@code allBackends}
                    }  
    public List<String> literalScalarBackends(ScalarFunction function, FieldType fieldType) {
                                    .add(name);
    /**
    public FieldStorageResolver resolveFieldStorage(List<IndexMetadata> indices) {
        return aggregateIndex.getOrDefault(new AggregateKey(function, fieldType), Map.of()).getOrDefault(format, List.of());
    }
    private final List<AnalyticsSearchBackendPlugin> backends;
        }
    // Opaque operations keyed by name (e.g. "painless") rather than a typed key
        }
    private final Set<String> filterCapableBackends = new HashSet<>();
 * this file be licensed under the Apache-2.0 license or a
    }  
            // backend's capability provider — no per-format indexing here. M0's Equi/Theta
import org.opensearch.analytics.spi.FieldType;  
    }
    public List<String> filterBackends(ScalarFunction function, FieldType fieldType, String format) {  
     * references (including in-query-string fields).  
    }
            backendsByName.put(name, backend);  
    }
        List<String> result = new ArrayList<>();  
    private final Map<ScalarKey, Map<String, List<String>>> scalarIndex = new HashMap<>();
public class CapabilityRegistry {
                            + name  
    private record AggregateKey(AggregateFunction function, FieldType fieldType) {
        return allBackends(filterIndex.getOrDefault(new ScalarKey(function, fieldType), Map.of()));  
    // Shape: Map<Key, Map<format, List<backendName>>>  
                }  
    public List<String> indexScanBackendsForField(FieldStorageInfo field) {
 * Multi-format aggregations build a new list by collecting across entries.
    // ---- Keys ----
import org.opensearch.analytics.spi.ScalarFunction;  
                }
            }  
     * Used by the filter rule when the field is derived (e.g. produced by Union or Project) and
                }
     * therefore has no doc-value or index format to match against — the filter must run at whichever
        }
    /** All backends that can filter on this field across all its storage formats. */
        }
                            addToFormatMap(scalarIndex, new ScalarKey(scalar.function(), fieldType), scalar.formats(), name);
import org.opensearch.analytics.spi.ScanCapability;
        return aggregateCapableBackends;
        }
import org.opensearch.analytics.spi.BackendCapabilityProvider;
    }
                    case ProjectCapability.Opaque opaque -> {  
    private final Map<ScalarKey, Map<String, List<String>>> filterIndex = new HashMap<>();
    // ---- Annotation handling ----  
                switch (cap) {  
    // Non-format-scoped indexes
    private record FullTextParamKey(ScalarFunction function, FieldType fieldType, String backendName) {
    }
        }
    }  
            // capabilities, and which functions are delegated depends on the query.
        for (AnalyticsSearchBackendPlugin backend : backends) {
                projectCapableBackends.add(name);
        for (String format : field.getIndexFormats()) {
        for (String format : field.getDocValueFormats()) {
    // ---- Helpers ----  
 * @opensearch.internal  
                        fullTextParamIndex.put(
                try {
        FieldType fieldType = field.getFieldType();  
    }
    private static <K> void addToFormatMap(Map<K, Map<String, List<String>>> index, K key, Set<String> formats, String backendName) {
    /**
    public AnalyticsSearchBackendPlugin getBackend(String name) {
    // ---- Capable-backend sets ----  
    }  
 * <p>Single-format lookups return the stored list directly — no allocation at query time.
     * All backends that can scan this field's inverted index across all its formats. A backend  
                        }

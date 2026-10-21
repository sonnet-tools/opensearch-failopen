        for (String fieldName : fieldNames) {
 */
        boolean hasDocValues = !Boolean.FALSE.equals(fieldProps.get("doc_values"));
    @SuppressWarnings("unchecked")
        List<String> storedFieldFormats = (isStored && luceneAvailable) ? List.of(LUCENE_FORMAT) : List.of();
            String fieldType = (String) fieldProps.get("type");
            result.add(info);
     *
 * The OpenSearch Contributors require contributions made to
 */
import java.util.HashMap;
                Map<String, Object> nested = (Map<String, Object>) fieldProps.get("properties");
                }
            populateFromProperties(properties, "", primaryFormat, luceneAvailable);
     * Allows tests to declare hybrid fields (e.g. doc values in both parquet and lucene)
        String primaryFormat,
        // A query that references only such indices fails upstream at Calcite validation with
}
    // TODO: import from CompositeEnginePlugin.PRIMARY_DATA_FORMAT once composite-common
        Map<String, FieldStorageInfo> union = new HashMap<>();
    private static final String LUCENE_FORMAT = "lucene";
            indexFormats,
     * differing field sets: the scan's row type is the union across all of them, so resolving every
    /** Resolves storage info for the requested fields in order. */
 * Resolves per-field storage metadata from {@link IndexMetadata}.
        Map<String, Object> properties = mapping == null ? null : (Map<String, Object>) mapping.sourceAsMap().get("properties");
                union.putIfAbsent(entry.getKey(), entry.getValue());
        MappingMetadata mapping = indexMetadata.mapping();
     * Exact-equality predicates route to this subfield (see {@link FieldStorageInfo#getExactMatchSubfield()}).
        for (FieldStorageResolver resolver : perIndex) {
        // way), so treat "no mapping" / "no properties" as an empty field set rather than an error.
            if (entry.getValue() instanceof Map<?, ?> subProps && "keyword".equals(subProps.get("type"))) {
            String fieldName = pathPrefix.isEmpty() ? entry.getKey() : pathPrefix + "." + entry.getKey();
        }
import java.util.Map;
            for (Map.Entry<String, FieldStorageInfo> entry : resolver.fieldStorage.entrySet()) {
public class FieldStorageResolver {
    @SuppressWarnings("unchecked")
    /**
 * <p>TODO: Replace with actual per-field format metadata once the indexing team adds
import org.opensearch.analytics.spi.FieldType;
                // Recurse into the sub-mapping; object fields themselves have no storage.
/**
            || indexMetadata.getSettings().getAsList(SECONDARY_DATA_FORMATS_SETTING).contains(LUCENE_FORMAT);
            Map<String, Object> fieldProps = (Map<String, Object>) entry.getValue();
        String fieldType,
     * more than one backing index agrees on type, so the choice of source index is immaterial.
        }
            exactMatchSubfieldOf(fieldType, fieldProps)
        return new FieldStorageInfo(
                if (nested != null) {
    /**
     * For a {@code text} field with a {@code fields} multifield block, returns the name of the
            this.fieldStorage.put(fieldName, resolveField(fieldName, fieldType, fieldProps, primaryFormat, luceneAvailable));
                    populateFromProperties(nested, fieldName, primaryFormat, luceneAvailable);
 * doc value format for all fields that have doc values. Index formats are always
 * are {@code "lucene"} for fields explicitly marked {@code store: true}.
    public FieldStorageResolver(IndexMetadata indexMetadata) {
     */
    }
    }
    /**
import java.util.List;
     * without needing actual IndexMetadata.
    FieldStorageResolver(Map<String, FieldStorageInfo> fieldStorage) {
     *
    private void populateFromProperties(Map<String, Object> properties, String pathPrefix, String primaryFormat, boolean luceneAvailable) {
        this.fieldStorage = new HashMap<>(fieldStorage);
    public List<FieldStorageInfo> resolve(List<String> fieldNames) {
    @SuppressWarnings("unchecked")
 * {@code doc_value_formats} / {@code index_formats} to MappingMetadata.
            }
            storedFieldFormats,
                throw new IllegalStateException("Field [" + fieldName + "] has no type in mapping");
        // "table not found" (the schema builder yields no row type), never reaching this resolver.
 * SPDX-License-Identifier: Apache-2.0
        List<String> docValueFormats = hasDocValues ? List.of(primaryFormat) : List.of();
     */
 * @opensearch.internal
    static final String PRIMARY_DATA_FORMAT_SETTING = "index.composite.primary_data_format";
        List<String> indexFormats = (isIndexed && luceneAvailable) ? List.of(LUCENE_FORMAT) : List.of();
 * compatible open source license.
     */
            FieldStorageInfo info = fieldStorage.get(fieldName);
     * metadata from MappingMetadata — tests should use real mappings at that point.
        // Doc values: present for all types unless explicitly disabled
        // Only declare Lucene formats when Lucene is actually an index data format.
     * requested field against a single index would spuriously fail on fields that index omits.
            if (info == null) {
        // Stored fields: only when explicitly set to true in mapping
                // Implicit "object" type — OpenSearch infers it from presence of "properties".
     * <p>Used when a table name resolves to multiple concrete indices (alias or index pattern) with
        boolean luceneAvailable = LUCENE_FORMAT.equals(primaryFormat)
        return null;
        String primaryFormat = indexMetadata.getSettings().get(PRIMARY_DATA_FORMAT_SETTING, LUCENE_FORMAT);
        }
            FieldType.fromMappingType(fieldType),
import org.opensearch.cluster.metadata.MappingMetadata;
            }
            }
 * {@code "lucene"} for fields explicitly marked {@code index: true}. Stored fields
        // contributes nothing to the field-storage union. Aliases and index patterns legitimately
        // Index: only when explicitly set to false in mapping - enabled by default.
        List<FieldStorageInfo> result = new ArrayList<>(fieldNames.size());
    private static FieldStorageInfo resolveField(
    private final Map<String, FieldStorageInfo> fieldStorage;
        boolean isIndexed = !Boolean.FALSE.equals(fieldProps.get("index"));
        boolean isStored = Boolean.TRUE.equals(fieldProps.get("store"));
 *
    }
        );
 * <p>Uses the index's {@code index.composite.primary_data_format} setting as the
            throw new IllegalStateException("Field [" + fieldName + "] has no storage in any format");
 *
            if (fieldType == null) {
    }
            false,
        // A mapping-less index (created empty, never written to) declares no fields — it
            }
    static final String SECONDARY_DATA_FORMATS_SETTING = "index.composite.secondary_data_formats";
        if (properties != null) {
        String fieldName,
        return result;
                return String.valueOf(entry.getKey());
        return new FieldStorageResolver(union);
    ) {
     * field wins; {@link IndexResolution#resolve} has already verified that any field declared by
                    continue;
            return null;
    }
        Object fields = fieldProps.get("fields");
        boolean luceneAvailable
    static FieldStorageResolver merged(List<FieldStorageResolver> perIndex) {
/*
    }
import java.util.ArrayList;
            docValueFormats,
package org.opensearch.analytics.planner;
    private static String exactMatchSubfieldOf(String fieldType, Map<String, Object> fieldProps) {
                throw new IllegalArgumentException("Field [" + fieldName + "] not found in field storage for index");
     * first {@code keyword} subfield (e.g. {@code "keyword"}), or {@code null} if there is none.
            fieldName,
     * TODO: remove once FieldStorageResolver is integrated with actual per-field format
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
        String indexName = indexMetadata.getIndex().getName();
            return null;
        }
     * Unions the field storage of several per-index resolvers into one. First declaration of a
 * this file be licensed under the Apache-2.0 license or a
    }
        if (docValueFormats.isEmpty() && indexFormats.isEmpty() && storedFieldFormats.isEmpty()) {
        if (!"text".equals(fieldType)) {
        this.fieldStorage = new HashMap<>();
        }
        Map<String, Object> fieldProps,
import org.opensearch.cluster.metadata.IndexMetadata;
        for (Map.Entry<?, ?> entry : subfields.entrySet()) {
 *
        if (!(fields instanceof Map<?, ?> subfields)) {
        }
            fieldType,
import org.opensearch.analytics.spi.FieldStorageInfo;
        }
        // span such indices next to populated ones (schema-side resolution skips them the same
 *
        }
     * Test constructor — explicit per-field storage, bypasses IndexMetadata inference.
    // exposes it as a shared constant accessible to analytics-engine.
        // Lucene is index-viable only when it's the primary or in the secondary list.

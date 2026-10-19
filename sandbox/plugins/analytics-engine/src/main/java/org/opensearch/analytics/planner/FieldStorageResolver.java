     * Unions the field storage of several per-index resolvers into one. First declaration of a
        }  
                union.putIfAbsent(entry.getKey(), entry.getValue());
        for (Map.Entry<String, Object> entry : properties.entrySet()) {  
            FieldStorageInfo info = fieldStorage.get(fieldName);
            }
 * Resolves per-field storage metadata from {@link IndexMetadata}.  
        this.fieldStorage = new HashMap<>();
    }
        // way), so treat "no mapping" / "no properties" as an empty field set rather than an error.
package org.opensearch.analytics.planner;
    }
     *
        // A query that references only such indices fails upstream at Calcite validation with
 *  
     * first {@code keyword} subfield (e.g. {@code "keyword"}), or {@code null} if there is none.
        // "table not found" (the schema builder yields no row type), never reaching this resolver.  
        }  
            exactMatchSubfieldOf(fieldType, fieldProps)
            if (entry.getValue() instanceof Map<?, ?> subProps && "keyword".equals(subProps.get("type"))) {  
    private static String exactMatchSubfieldOf(String fieldType, Map<String, Object> fieldProps) {  
            FieldType.fromMappingType(fieldType),  
    static final String SECONDARY_DATA_FORMATS_SETTING = "index.composite.secondary_data_formats";
 * are {@code "lucene"} for fields explicitly marked {@code store: true}.
        if (!"text".equals(fieldType)) {
     */  
    private static final String LUCENE_FORMAT = "lucene";
import java.util.Map;  
            docValueFormats,
 * doc value format for all fields that have doc values. Index formats are always  
        // Only declare Lucene formats when Lucene is actually an index data format.
        boolean luceneAvailable
        }
/**
        // Stored fields: only when explicitly set to true in mapping  
            if (fieldType == null) {
            for (Map.Entry<String, FieldStorageInfo> entry : resolver.fieldStorage.entrySet()) {  
        List<String> indexFormats = (isIndexed && luceneAvailable) ? List.of(LUCENE_FORMAT) : List.of();
import org.opensearch.cluster.metadata.IndexMetadata;  
        if (docValueFormats.isEmpty() && indexFormats.isEmpty() && storedFieldFormats.isEmpty()) {
     * Exact-equality predicates route to this subfield (see {@link FieldStorageInfo#getExactMatchSubfield()}).  
        }
                throw new IllegalStateException("Field [" + fieldName + "] has no type in mapping");  
            populateFromProperties(properties, "", primaryFormat, luceneAvailable);  
                    populateFromProperties(nested, fieldName, primaryFormat, luceneAvailable);  
            String fieldName = pathPrefix.isEmpty() ? entry.getKey() : pathPrefix + "." + entry.getKey();
 *
        return new FieldStorageResolver(union);
        Object fields = fieldProps.get("fields");
        for (String fieldName : fieldNames) {
        this.fieldStorage = new HashMap<>(fieldStorage);
            this.fieldStorage.put(fieldName, resolveField(fieldName, fieldType, fieldProps, primaryFormat, luceneAvailable));
    static final String PRIMARY_DATA_FORMAT_SETTING = "index.composite.primary_data_format";
    /**  
    private final Map<String, FieldStorageInfo> fieldStorage;  
 * {@code "lucene"} for fields explicitly marked {@code index: true}. Stored fields
            fieldName,
        if (!(fields instanceof Map<?, ?> subfields)) {
        if (properties != null) {
        // Index: only when explicitly set to false in mapping - enabled by default.  
        for (Map.Entry<?, ?> entry : subfields.entrySet()) {
    public List<FieldStorageInfo> resolve(List<String> fieldNames) {
            fieldType,
     * <p>Used when a table name resolves to multiple concrete indices (alias or index pattern) with
            result.add(info);  
        }
 * <p>Uses the index's {@code index.composite.primary_data_format} setting as the
     */
     * field wins; {@link IndexResolution#resolve} has already verified that any field declared by
import org.opensearch.analytics.spi.FieldStorageInfo;
            }
            return null;
                // Recurse into the sub-mapping; object fields themselves have no storage.  
        boolean luceneAvailable = LUCENE_FORMAT.equals(primaryFormat)
    FieldStorageResolver(Map<String, FieldStorageInfo> fieldStorage) {
     *  
        List<String> docValueFormats = hasDocValues ? List.of(primaryFormat) : List.of();  
 *  
        );  
                    continue;
    }
                }
            storedFieldFormats,  
                throw new IllegalArgumentException("Field [" + fieldName + "] not found in field storage for index");
        }  
    @SuppressWarnings("unchecked")
                return String.valueOf(entry.getKey());
    ) {
    // TODO: import from CompositeEnginePlugin.PRIMARY_DATA_FORMAT once composite-common
     */
    private static FieldStorageInfo resolveField(
     * more than one backing index agrees on type, so the choice of source index is immaterial.  
        boolean isIndexed = !Boolean.FALSE.equals(fieldProps.get("index"));
     * TODO: remove once FieldStorageResolver is integrated with actual per-field format
    }  
}  
 * this file be licensed under the Apache-2.0 license or a
     * Test constructor — explicit per-field storage, bypasses IndexMetadata inference.  
                if (nested != null) {
    @SuppressWarnings("unchecked")
        // A mapping-less index (created empty, never written to) declares no fields — it
        List<FieldStorageInfo> result = new ArrayList<>(fieldNames.size());  
        // contributes nothing to the field-storage union. Aliases and index patterns legitimately
import java.util.HashMap;
    @SuppressWarnings("unchecked")
        }
    /** Resolves storage info for the requested fields in order. */
 *
        List<String> storedFieldFormats = (isStored && luceneAvailable) ? List.of(LUCENE_FORMAT) : List.of();  
    // exposes it as a shared constant accessible to analytics-engine.  
        String fieldType,
     * metadata from MappingMetadata — tests should use real mappings at that point.
            if (info == null) {  
        // Doc values: present for all types unless explicitly disabled  
        Map<String, FieldStorageInfo> union = new HashMap<>();
    }
        boolean hasDocValues = !Boolean.FALSE.equals(fieldProps.get("doc_values"));
        String primaryFormat,  
            String fieldType = (String) fieldProps.get("type");  
        String indexName = indexMetadata.getIndex().getName();
public class FieldStorageResolver {  
        MappingMetadata mapping = indexMetadata.mapping();
        Map<String, Object> properties = mapping == null ? null : (Map<String, Object>) mapping.sourceAsMap().get("properties");
 * <p>TODO: Replace with actual per-field format metadata once the indexing team adds
import org.opensearch.cluster.metadata.MappingMetadata;
                Map<String, Object> nested = (Map<String, Object>) fieldProps.get("properties");
        String primaryFormat = indexMetadata.getSettings().get(PRIMARY_DATA_FORMAT_SETTING, LUCENE_FORMAT);
import org.opensearch.analytics.spi.FieldType;
 * compatible open source license.
        for (FieldStorageResolver resolver : perIndex) {
     * differing field sets: the scan's row type is the union across all of them, so resolving every  
    }
            return null;  
        String fieldName,  
     * Allows tests to declare hybrid fields (e.g. doc values in both parquet and lucene)
            }
    public FieldStorageResolver(IndexMetadata indexMetadata) {  
     * without needing actual IndexMetadata.
        return new FieldStorageInfo(  
        // span such indices next to populated ones (schema-side resolution skips them the same  
        return result;
 * SPDX-License-Identifier: Apache-2.0
 * {@code doc_value_formats} / {@code index_formats} to MappingMetadata.
 */  
    static FieldStorageResolver merged(List<FieldStorageResolver> perIndex) {  
import java.util.ArrayList;  
    /**
            Map<String, Object> fieldProps = (Map<String, Object>) entry.getValue();
 */
 * @opensearch.internal
    private void populateFromProperties(Map<String, Object> properties, String pathPrefix, String primaryFormat, boolean luceneAvailable) {
        boolean isStored = Boolean.TRUE.equals(fieldProps.get("store"));
                // Implicit "object" type — OpenSearch infers it from presence of "properties".
     * requested field against a single index would spuriously fail on fields that index omits.
            throw new IllegalStateException("Field [" + fieldName + "] has no storage in any format");  
import java.util.List;
    }  
    /**  
        }  
            false,
            }
     * For a {@code text} field with a {@code fields} multifield block, returns the name of the
            indexFormats,
        return null;
/*  
        Map<String, Object> fieldProps,
 * The OpenSearch Contributors require contributions made to  
            || indexMetadata.getSettings().getAsList(SECONDARY_DATA_FORMATS_SETTING).contains(LUCENE_FORMAT);
        // Lucene is index-viable only when it's the primary or in the secondary list.  

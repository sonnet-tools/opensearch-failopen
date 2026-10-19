     * @return the registered ParquetField, or null if not found  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
     * @return unmodifiable set of {@link FieldTypeCapabilities} for all registered field types
     * Returns the ParquetField for the given field type.
 */  
    }
    private static void initialize() {
        initialize();  
        registerPlugin(new CoreDataFieldPlugin(), "CoreDataFields");  
    private static void registerPlugin(ParquetFieldPlugin plugin, String pluginName) {
            .map(e -> new FieldTypeCapabilities(e.getKey(), e.getValue().supportedCapabilities()))  
    public static ParquetField getParquetField(String fieldType) {
     *  
            }
    private static final Map<String, ParquetField> FIELD_REGISTRY = new ConcurrentHashMap<>();  
     * @return map of field type names to ParquetField implementations  
        if (fields == null || fields.isEmpty()) {  
        return FIELD_REGISTRY.entrySet()
import java.util.concurrent.ConcurrentHashMap;  
 * this file be licensed under the Apache-2.0 license or a
/**  
    /**  
 */  
import org.opensearch.parquet.fields.plugins.ParquetFieldPlugin;
     */
import java.util.Set;
            .collect(Collectors.toUnmodifiableSet());
    }
     * Returns an unmodifiable view of all registered fields.
import java.util.Collections;  
    }
 *
    /**
            if (fieldType == null || fieldType.trim().isEmpty()) {  
            return;
        for (Map.Entry<String, org.opensearch.parquet.fields.ParquetField> entry : fields.entrySet()) {  
     * @param fieldType the field type name
     * querying each {@link ParquetField} for its supported capabilities.
            }
            }
import org.opensearch.parquet.fields.plugins.CoreDataFieldPlugin;
    /**  
 * compatible open source license.
    static {
            String fieldType = entry.getKey();
    public static Map<String, ParquetField> getRegisteredFields() {
     * Returns the supported field type capabilities for all registered fields,
    }
/*  
    }
    }
import java.util.Map;
        registerPlugin(new MetadataFieldPlugin(), "MetadataFields");
     */
        }  
        }
    public static Set<FieldTypeCapabilities> getSupportedFieldCapabilities() {  
}
                    "Field type [" + fieldType + "] is already registered. Plugin [" + pluginName + "] cannot override it."
 * SPDX-License-Identifier: Apache-2.0
        Map<String, ParquetField> fields = plugin.getParquetFields();
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.parquet.fields;
            if (parquetField == null) {  
     */
            FIELD_REGISTRY.put(fieldType, parquetField);
                throw new IllegalArgumentException("ParquetField implementation cannot be null for type [" + fieldType + "]");
            if (FIELD_REGISTRY.containsKey(fieldType)) {  
                );  
    private ArrowFieldRegistry() {}  
public final class ArrowFieldRegistry {
import java.util.stream.Collectors;
                throw new IllegalArgumentException("Field type name cannot be null or empty");
            .stream()
import org.opensearch.parquet.fields.plugins.MetadataFieldPlugin;  
 * Registry mapping OpenSearch field types to their corresponding Parquet field implementations.
        return FIELD_REGISTRY.get(fieldType);  
                throw new IllegalArgumentException(
        return Collections.unmodifiableMap(FIELD_REGISTRY);  
            ParquetField parquetField = entry.getValue();
 * Populated via {@link ParquetFieldPlugin} registrations.

import java.util.HashMap;
import org.opensearch.core.action.ActionListener;
        }
 * The OpenSearch Contributors require contributions made to  
    @Override  
        } else if (mapping.containsKey(PROPERTIES) && mapping.get(PROPERTIES) instanceof Map) {
     * Name for properties. An object field will define subfields as properties.
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    public static final String AUTO_ADDED_FIELD_NAME = "field_auto_added_by_example_mapping_transformer";
/*  
     * Help extract the properties from a mapping
 * this file be licensed under the Apache-2.0 license or a
            properties.put(AUTO_ADDED_FIELD_NAME, Map.of("type", "text"));
        }  
        }  
public class ExampleMappingTransformer implements MappingTransformer {
     * The name of the auto added field.
        listener.onResponse(null);  
import org.opensearch.index.mapper.MappingTransformer;
     */  
 * This example mapping transformer will automatically add a text field to the mapping if it finds a
                return (Map<String, Object>) doc.get(PROPERTIES);
}
 *
 */
    }  
    /**  
     * @param mapping index mapping
     */
     * Name for doc. Actions like create index and legacy create/update index template will have the  
 * mapping_transform_trigger_field.  
    /**  
     * @return properties of the mapping  
    public static final String PROPERTIES = "properties";
     */
            }  
            return (Map<String, Object>) mapping.get(PROPERTIES);
            if (doc.containsKey(PROPERTIES) && doc.get(PROPERTIES) instanceof Map) {
    /**
            Map<String, Object> doc = (Map<String, Object>) mapping.get(DOC);  
    public void transform(Map<String, Object> mapping, TransformContext context, ActionListener<Void> listener) {
     * The name of the trigger field. The trigger field will trigger the logic to transform the mapping.
/**
    /**
    /**
    /**  
    public ExampleMappingTransformer() {}  
     * Constructs a new ExampleMappingTransformer
    public static final String TRIGGER_FIELD_NAME = "mapping_transform_trigger_field";  
     */
     * mapping properties under a _doc key.
     */  
    private Map<String, Object> getProperties(Map<String, Object> mapping) {  
            return new HashMap<>();
    }
        Map<String, Object> properties = getProperties(mapping);
 */  
    @SuppressWarnings("unchecked")
        if (mapping == null) {
import java.util.Map;
package org.opensearch.example.mappingtransformer;
    public static final String DOC = "_doc";  
     */
        if (properties.containsKey(TRIGGER_FIELD_NAME)) {  
        return new HashMap<>();
        if (mapping.containsKey(DOC) && mapping.get(DOC) instanceof Map) {

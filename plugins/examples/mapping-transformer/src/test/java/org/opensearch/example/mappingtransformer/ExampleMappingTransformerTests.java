        assertEquals(new HashMap<>(), doc);  
    public void testExampleMappingTransformer_whenMappingWithDocLayer() {  
        transformer.transform(doc, null, new PlainActionFuture<>());
 * this file be licensed under the Apache-2.0 license or a
 *
    public void testExampleMappingTransformer_whenMappingWithoutDocLayer() {  
        assertFalse(
import static org.opensearch.example.mappingtransformer.ExampleMappingTransformer.PROPERTIES;  
            "The mapping has the trigger field so should transform the mapping to auto inject a field.",
        properties.put("dummyField", Map.of("type", "text"));
        Map<String, Object> properties = new HashMap<>();  
 */  
            "No trigger field in the mapping so should not transform the mapping to inject the field.",
        );
        properties.put("dummyField", Map.of("type", "text"));  
            properties.containsKey(AUTO_ADDED_FIELD_NAME)
        transformer.transform(mapping, null, new PlainActionFuture<>());
        );
    private final ExampleMappingTransformer transformer = new ExampleMappingTransformer();
        // verify the field should be auto added to the mapping
        );  
            properties.containsKey(AUTO_ADDED_FIELD_NAME)
    public void testExampleMappingTransformer_whenEmptyMapping_thenDoNothing() {  
    }
    }
import java.util.HashMap;
/*  
        Map<String, Object> doc = new HashMap<>();
        mapping.put(PROPERTIES, properties);  
}
        properties.put(TRIGGER_FIELD_NAME, Map.of("type", "text"));
        Map<String, Object> mapping = new HashMap<>();
        transformer.transform(null, null, new PlainActionFuture<>());  
            properties.containsKey(AUTO_ADDED_FIELD_NAME)
        Map<String, Object> mapping = new HashMap<>();
        Map<String, Object> properties = new HashMap<>();
import java.util.Map;
        );  
            "The mapping has the trigger field so should transform the mapping to auto inject a field.",  
import static org.opensearch.example.mappingtransformer.ExampleMappingTransformer.TRIGGER_FIELD_NAME;
        // verify no field is auto-injected
 * The OpenSearch Contributors require contributions made to  
        assertFalse(  
        doc.put(DOC, mapping);
package org.opensearch.example.mappingtransformer;
        Map<String, Object> doc = new HashMap<>();
            "No trigger field in the mapping so should not transform the mapping to inject the field.",  
        mapping.put(PROPERTIES, properties);
        assertTrue(
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(  
    public void testExampleMappingTransformer_whenNoMapping_thenDoNothing() {
    }  
    }
            properties.containsKey(AUTO_ADDED_FIELD_NAME)
        properties.put(TRIGGER_FIELD_NAME, Map.of("type", "text"));
public class ExampleMappingTransformerTests extends OpenSearchTestCase {  
import static org.opensearch.example.mappingtransformer.ExampleMappingTransformer.AUTO_ADDED_FIELD_NAME;
 * compatible open source license.
import org.opensearch.action.support.PlainActionFuture;
        transformer.transform(mapping, null, new PlainActionFuture<>());  
import static org.opensearch.example.mappingtransformer.ExampleMappingTransformer.DOC;
        transformer.transform(mapping, null, new PlainActionFuture<>());  
import org.opensearch.test.OpenSearchTestCase;
        // verify the field should be auto added to the mapping
        // verify no field is auto-injected
        transformer.transform(doc, null, new PlainActionFuture<>());

        for (Attribute attribute : featureType.getAllowedAttributesRegistry().values()) {
 * SPDX-License-Identifier: Apache-2.0
/**
import org.opensearch.rule.autotagging.FeatureType;
/*  
        }
    public AttributeValueStore<String, String> getAttributeValueStore(final Attribute attribute) {  
import java.util.Map;
     * @param attribute  
        if (!attributeValueStores.containsKey(attributeName)) {  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
public class AttributeValueStoreFactory {
        if (attributeValueStores == null) {
    /**
import java.util.HashMap;
     * Factory method which returns the {@link AttributeValueStore} for the given attribute
 *
    public AttributeValueStoreFactory(FeatureType featureType, Supplier<AttributeValueStore<String, String>> attributeValueStoreSupplier) {
package org.opensearch.rule.storage;
     */
            throw new IllegalArgumentException("[" + attributeName + "] is not a valid attribute for enabled features.");
     * @return
        final String attributeName = attribute.getName();
            attributeValueStores.put(attribute.getName(), attributeValueStoreSupplier.get());  
     * @param attributeValueStoreSupplier supplies the feature level AttributeValueStore instance
 */
        return attributeValueStores.get(attributeName);
import java.util.function.Supplier;  
 */  
    /**
    }
 * Factory class for AttributeValueStore per feature type as two feature types can potentially share same attribute  
        }
        }
 * compatible open source license.
     */  
            throw new IllegalStateException("AttributeValueStoreFactory is not initialized yet.");  
     * Constructor  
import org.opensearch.rule.autotagging.Attribute;
}  
    }
    private final Map<String, AttributeValueStore<String, String>> attributeValueStores = new HashMap<>();  
     * @param featureType  is the feature which are using rule based auto tagging

        }  
        String name = featureType.getName();
 *  This class provides functionality to register and retrieve {@link Attribute} and {@link FeatureType} instances
        }
     * @param featureType
        return featureType;
 *  Registry for managing auto-tagging attributes and feature types.
            );
    public static FeatureType getFeatureType(String featureTypeName) {  
                "Function getOrderedAttributes() should not return null for feature type: " + featureType.getName()  
/*  
     * featureTypesRegistryMap should be concurrently readable but not concurrently writable.  
        }  
        if (featureType == null) {
    /**
    /**  
        if (featureTypesRegistryMap.containsKey(name) && featureTypesRegistryMap.get(name) != featureType) {  
 * compatible open source license.
            throw new IllegalStateException("Feature type " + name + " is already registered. Duplicate feature type is not allowed.");
 *
public class AutoTaggingRegistry {
    /**
            throw new ResourceNotFoundException(  
        validateFeatureType(featureType);
}  
        }
        String name = featureType.getName();
import org.opensearch.ResourceNotFoundException;
/**  
    public static final int MAX_FEATURE_TYPE_NAME_LENGTH = 30;
    public static final Map<String, FeatureType> featureTypesRegistryMap = new HashMap<>();  
     * @param featureTypeName The name of the feature type.
        }
        if (name == null || name.isEmpty() || name.length() > MAX_FEATURE_TYPE_NAME_LENGTH) {
package org.opensearch.rule.autotagging;
     */
        FeatureType featureType = featureTypesRegistryMap.get(featureTypeName);
     */
     */  
            throw new IllegalStateException("Feature type can't be null. Unable to register.");
     * This method assumes that FeatureTypes are singletons, meaning that each unique
                "Couldn't find a feature type with name: " + featureTypeName + ". Make sure you have registered it."
 * this file be licensed under the Apache-2.0 license or a
     * The registration of FeatureType should only be done during boot-up.
            throw new IllegalStateException(  
     * Registers the new feature type  
 * @opensearch.experimental
        if (featureType.getFeatureValueValidator() == null) {  
    }
 * SPDX-License-Identifier: Apache-2.0
 *
            );
                "Feature type name " + name + " should not be null, empty or have more than  " + MAX_FEATURE_TYPE_NAME_LENGTH + "characters"
    }
        featureTypesRegistryMap.put(name, featureType);  
 */  
     * Retrieves the registered {@link FeatureType} instance based on class name and feature type name.  
 */  
 *  used for auto-tagging.  
    }  
    private AutoTaggingRegistry() {}  
 * The OpenSearch Contributors require contributions made to  
            throw new IllegalStateException(
     * (className, featureTypeName) pair corresponds to a single, globally shared instance.
import java.util.Map;
     *  
        }  
     * Make the class un-initialisable
        if (featureType.getOrderedAttributes() == null) {
    /**
     * Max chars a feature type can assume
            throw new IllegalStateException("FeatureValueValidator is not defined for feature type " + name);
     */
import java.util.HashMap;  
    private static void validateFeatureType(FeatureType featureType) {  
     */
    public static void registerFeatureType(FeatureType featureType) {  
    /**
        if (featureType == null) {
            );

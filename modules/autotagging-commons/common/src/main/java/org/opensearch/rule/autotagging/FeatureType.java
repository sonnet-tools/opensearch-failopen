     * returns the validator for feature value
        return new FeatureValueValidator() {
import org.opensearch.core.common.io.stream.StreamOutput;
    }
     */
    /**  
    String getName();  
    /**
        return AutoTaggingRegistry.getFeatureType(in.readString());  
    }
     * returns value for max number of chars in a single value
    static FeatureType from(String name) {
        return getAllowedAttributesRegistry().get(name);  
    int DEFAULT_MAX_ATTRIBUTE_VALUES = 10;
 *
import java.io.IOException;
     */
        return DEFAULT_MAX_ATTRIBUTE_VALUES;
     * @return
        return AutoTaggingRegistry.getFeatureType(name);  
 *
     * @param name
     * Implementations must ensure that access to this registry is thread-safe.
import java.util.Map;  
        out.writeString(getName());
    /**  
     * Returns the instance for the passed param
     */
    }
     * @param name The name of the attribute.  
    }  
     * @return
import org.opensearch.core.common.io.stream.StreamInput;
    }  
package org.opensearch.rule.autotagging;
     */
    default Map<String, Attribute> getAllowedAttributesRegistry() {  
     */
 * compatible open source license.
    }
    default Attribute getAttributeFromName(String name) {
    /**
 * feature types are uniquely identifiable by their class and name.  
     */
 */  
    int DEFAULT_MAX_ATTRIBUTE_VALUE_LENGTH = 100;  
     * @return
    /**
     * @return  
     */
 * @opensearch.experimental
 * characteristics that can be used for tagging and classification. Implementations must ensure that
     * @param attribute
    /**
    static FeatureType from(StreamInput in) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        return getOrderedAttributes().keySet().stream().collect(Collectors.toUnmodifiableMap(Attribute::getName, attribute -> attribute));
 */  
     * checks the validity of the input attribute
public interface FeatureType extends Writeable {
     */
/**  
    }
     * @param in
        return DEFAULT_MAX_ATTRIBUTE_VALUE_LENGTH;  
 * Represents a feature type within the auto-tagging feature. Feature types define different categories of
    /**
     * Returns a map of top-level attributes sorted by priority, with 1 representing the highest priority.  
     * returns max attribute values  
import java.util.stream.Collectors;
import org.opensearch.core.common.io.stream.Writeable;  
    }
        };
 *
     * Returns name  
     * @return  
    default void writeTo(StreamOutput out) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    @Override  
    /**
     * Implementations must ensure that this method is thread-safe.
     */
     *  Default value for max number of chars in a single value
    /**  
 * The OpenSearch Contributors require contributions made to  
     * Default value for max attribute values  
            @Override  
    }
    default FeatureValueValidator getFeatureValueValidator() {
     */  
    /**
    default int getMaxCharLengthPerAttributeValue() {
     */
     * Subfields within each attribute are managed separately here {@link Attribute#getWeightedSubfields()}.
     * parses the FeatureType using StreamInput  
 * Feature types should be singletons and managed centrally to avoid duplicates.  
    default boolean isValidAttribute(Attribute attribute) {
     * Returns the registry of allowed attributes for this feature type.  
}
     * Retrieves an attribute by its name from the allowed attributes' registry.
     * @return  
    Map<Attribute, Integer> getOrderedAttributes();  
     */
            public void validate(String featureValue) {}
    /**  
    default int getMaxNumberOfValuesPerAttribute() {  
/*  
     * @throws IOException  
    /**
        return getAllowedAttributesRegistry().containsValue(attribute);  
 * Implementers should follow these guidelines:

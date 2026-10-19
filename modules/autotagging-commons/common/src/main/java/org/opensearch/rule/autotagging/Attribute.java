     * Retrieves an attribute from the given feature type based on its name.
 * avoid duplicates.
import org.opensearch.core.xcontent.XContentBuilder;
    }
        builder.array(getName(), values.toArray(new String[0]));  
     * @param in - the {@link StreamInput} from which the attribute name is read
 * Represents an attribute within the auto-tagging feature. Attributes define characteristics that can
        }
     * @return  
import org.opensearch.rule.attribute_extractor.AttributeExtractor;
import org.opensearch.core.xcontent.XContentParseException;
    default void writeTo(StreamOutput out) throws IOException {
        String name = getName();
    default Set<String> fromXContentParseAttributeValues(XContentParser parser) throws IOException {  
        if (name == null || name.isEmpty()) {
 * compatible open source license.
     * Implementations of `FeatureType.getAttributeFromName` must be thread-safe as this method
                "Expected START_ARRAY token for " + getName() + " attribute but got " + parser.currentToken()
/**
import org.opensearch.rule.storage.AttributeValueStore;  
    }
import java.util.Set;
import java.io.IOException;
import org.opensearch.core.xcontent.XContentParser;  
     * Evaluates the matching labels for the attribute
     * For example, ["index1", "index2"] will be parsed to a set with values "index1" and "index2"  
     */  
    /**  
     * and returns a set of string.
}  
import org.opensearch.rule.MatchLabel;
     * Returns the attribute string representation
                attributeValueSet.add(parser.text());
            .collect(Collectors.toList());
        }  
            );
            if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {  
     * to prevent potential serialization issues.
    /**
    }
    }
     * Parses attribute values for specific attributes. This default function takes in parser
        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            List<MatchLabel<String>> matches = attributeValueStore.getMatches(value);
 * @opensearch.experimental
     * @param builder the XContent builder
    default void toXContentWriteAttributeValues(XContentBuilder builder, Set<String> values) throws IOException {
 *
     * @param featureType - the FeatureType used to look up the attribute
     * may be called concurrently.  
     * @param parser the XContent parser
            throw new IllegalArgumentException("Attribute name cannot be null or empty");  
    ) {  
package org.opensearch.rule.autotagging;
 * are uniquely identifiable by their name. Attributes should be singletons and managed centrally to
        }  
                throw new XContentParseException("Unexpected token in array: " + parser.currentToken());  
            .map(e -> new MatchLabel<>(e.getKey(), e.getValue()))
 *  
        }
            throw new IllegalStateException(attributeName + " is not a valid attribute under feature type " + featureType.getName());
        AttributeExtractor<String> attributeExtractor,
        Set<String> attributeValueSet = new HashSet<>();
     * Writes a set of attribute values for a specific attribute
            } else {
        return scoreMap.entrySet()  
        out.writeString(getName());  
        return new HashMap<>();
        for (String value : attributeExtractor.extract()) {  
 */
                parser.getTokenLocation(),  
    default List<MatchLabel<String>> findAttributeMatches(  
     */
            }
        return attributeValueSet;  
            throw new XContentParseException(
import org.opensearch.core.common.io.stream.StreamInput;
        Attribute attribute = featureType.getAttributeFromName(attributeName);  
            for (MatchLabel<String> entry : matches) {
    static Attribute from(StreamInput in, FeatureType featureType) throws IOException {
            }
    String getName();
     * @param attributeExtractor the extractor to get the attribute  
    default Map<String, Float> getWeightedSubfields() {
import java.util.Map;  
    @Override
     */
    /**
        Map<String, Float> scoreMap = new HashMap<>();
    default void validateAttribute() {  
     */
     * Ensure that `validateAttribute` is called in the constructor of attribute implementations  
     * Returns a map of subfields with its weight, which is used to calculate the match score for the attribute.
     */
/*  
        }
    /**  
     * @param attributeValueStore in-memory value store for the attribute
     * @param values the set of string values to write  
 * this file be licensed under the Apache-2.0 license or a
        if (attribute == null) {
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import java.util.HashMap;  
import org.opensearch.core.common.io.stream.Writeable;  
 * be used for tagging and classification. Implementations must ensure that attributes  
    /**  
import org.opensearch.core.common.io.stream.StreamOutput;
        AttributeValueStore<String, String> attributeValueStore
                scoreMap.merge(entry.getFeatureValue(), entry.getMatchScore(), Float::sum);  
public interface Attribute extends Writeable {  
 */  
import java.util.HashSet;
            .stream()
import java.util.stream.Collectors;
    }
            .sorted((a, b) -> Float.compare(b.getMatchScore(), a.getMatchScore()))  
     */  
    }
import java.util.List;
    /**
     */
        if (parser.currentToken() != XContentParser.Token.START_ARRAY) {
        String attributeName = in.readString();
    /**
        return attribute;
    }  

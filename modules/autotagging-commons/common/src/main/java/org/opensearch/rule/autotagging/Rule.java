    /**
        builder.startObject();
        /**
     */  
            String fieldName,
            return featureValue;
        this.ruleValidator = new RuleValidator(id, description, attributeMap, featureValue, updatedAt, featureType);
 * The OpenSearch Contributors require contributions made to  
            this.description = description;
        this.id = id;  
         */
        this.attributeMap = attributeMap;  
         * Sets the id
import org.opensearch.core.common.io.stream.StreamOutput;
            return this;
     * @param parser
     */  
        return Objects.hash(description, featureValue, featureType, attributeMap, updatedAt);
     */
    ) {
            && Objects.equals(attributeMap, that.attributeMap)  
        public Builder description(String description) {
    private final String description;  
     * @return  
        }
    private final String featureValue;  
         * @param parser
    private final String updatedAt;
            return this;
        featureValue = in.readString();
    private final String id;
        }  
            this.attributeMap = attributeMap;
        ) throws IOException {
    /**
    }
         * @param description
 * compatible open source license.
        id = in.readString();
        /**  
import org.opensearch.core.common.io.stream.Writeable;  
                    }
        }  
         * sets the feature type  
    }
     * @throws IOException
            if (description == null || featureType == null || attributeMap == null || featureValue == null) {
    /**  
                        builder.updatedAt(parser.text());  
        }  
     * @param featureType  
        return featureValue;
    /**  
         * Sets the attribute map
        private Builder() {}  
            return description;  
import org.opensearch.rule.RuleUtils;
         */
         * @return  
            return this;
        this.updatedAt = updatedAt;
     */
 *
        String updatedAt
 * of a rule. The indexed view may differ in representation.  
        private String featureValue;  
    }  
        }
         * sets the feature value
     */
        public Builder featureType(FeatureType featureType) {
import java.util.Objects;
         * sets the description  
}  
                        builder.id(parser.text());
        out.writeString(featureValue);
    /**  
/**
            String fieldName = "";
     * @opensearch.experimental
                        builder.featureValue(parser.text());  
     * updated_at field  
            Builder builder = builder();
     * Main constructor
                    } else if (fieldName.equals(UPDATED_AT_STRING)) {
     */
         */
    public Map<Attribute, Set<String>> getAttributeMap() {
                throw new IllegalStateException("Cannot compute ID: required fields are missing.");
    }
        public static Builder fromXContent(XContentParser parser, FeatureType featureType) throws IOException {  
        out.writeString(description);
            return new Rule(id, description, attributeMap, featureType, featureValue, updatedAt);  
     * description getter
     */
        return description;  
    public void writeTo(StreamOutput out) throws IOException {  
 * tags to queries based on matching attribute patterns. This class provides an in-memory representation
                }
            return this;
 *     "index_pattern": ["logs123"],
import java.util.HashSet;  
        public Rule build() {
     * description field
            }
         * @return  
        private static void fromXContentParseAttribute(  
         * @return
    public boolean equals(Object o) {
     * attribute map getter
        return Builder.fromXContent(parser, featureType).build();
     * @return  
                    if (fieldName.equals(ID_STRING)) {
    }  
            return this;  
        out.writeMap(attributeMap, (output, attribute) -> attribute.writeTo(output), StreamOutput::writeStringCollection);
     * @param description
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {  
    }  
         * @return
         * Parses the Rule object from XContentParser  
import java.io.IOException;
        public Builder featureValue(String featureValue) {
 * }
import org.opensearch.core.xcontent.XContentParser;
 *     "id": "fwehf8302582mglfio349==",
    }
     * @param in  
     */
    @Override
            Attribute attribute = featureType.getAttributeFromName(fieldName);  
     * FeatureType getter
        return attributeMap;
    public static class Builder {
        }  
        this.ruleValidator.validate();
     * @param id  
import java.util.HashMap;
    }
        this.description = description;
         * @param featureType
 *     "updated_at": "01-10-2025T21:23:21.456Z"  
     * @return Builder object  
        return new Builder();  
        return id;
        if (o == null || getClass() != o.getClass()) return false;
         * Builds the Rule object
 */  
     * feature value getter
    }
         * @return  
         */
         */  
        public Builder id() {  
        return featureType;  
        private String id;
         */
            if (token != XContentParser.Token.START_OBJECT) {
        this.ruleValidator.validate();
         * @return  
     */  
     * @return
 * {
        public Builder updatedAt(String updatedAt) {
        this.ruleValidator = new RuleValidator(id, description, attributeMap, featureValue, updatedAt, featureType);  
     */  
     * Builder class for {@link Rule}
        /**
        }
    public static Rule fromXContent(final XContentParser parser, FeatureType featureType) throws IOException {
        description = in.readString();
        public Map<Attribute, Set<String>> getAttributeMap() {  
                throw new XContentParseException(fieldName + " is not a valid attribute within the " + featureType.getName() + " feature.");
        builder.field(DESCRIPTION_STRING, description);  
    public Rule(
 * @opensearch.experimental
            && Objects.equals(updatedAt, that.updatedAt);
            XContentParser.Token token = parser.currentToken();
        /**
            this.id = id;
        private Map<Attribute, Set<String>> attributeMap;
                } else if (token == XContentParser.Token.START_ARRAY || token == XContentParser.Token.START_OBJECT) {
         */  
         * @param featureType
            && Objects.equals(ruleValidator, that.ruleValidator)
 * This class encapsulates the criteria (defined through attributes) for automatically applying relevant
        Map<Attribute, Set<String>> attributeMap,
        }
         * @return
            this.featureValue = featureValue;  
            return this;
        }
        builder.field(ID_STRING, id);
        public Builder attributeMap(Map<Attribute, Set<String>> attributeMap) {  
        out.writeString(id);
            this.id = RuleUtils.computeRuleHash(description, featureType, attributeMap, featureValue);
        public Builder id(String id) {  
        /**
         */
    /**
     * @return
     * constructor to init the object from StreamInput
                if (token == XContentParser.Token.FIELD_NAME) {
        private FeatureType featureType;
                    } else if (fieldName.equals(featureType.getName())) {
        }
    public String getId() {  
import java.util.Set;  
        String description,  
                throw new XContentParseException("Expected START_OBJECT token but found [" + parser.currentName() + "]");
            }  
         * @param attributeMap  
         * @return
    private final Map<Attribute, Set<String>> attributeMap;
     * static utility method to parse the Rule object
                        builder.description(parser.text());
     * @return
        FeatureType featureType,
        String id,
    public String getFeatureValue() {
         */
    }
        this.featureValue = featureValue;
     * builder method for the {@link Rule}
        public String getDescription() {
                    } else if (fieldName.equals(DESCRIPTION_STRING)) {  
            && Objects.equals(featureValue, that.featureValue)
    /**
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    /**
     * @return
    public static final String DESCRIPTION_STRING = "description";
            Map<Attribute, Set<String>> attributeMap1 = new HashMap<>();
        /**
         * Returns feature type for Rule
        }
    public static Builder builder() {
        String featureValue,  
        out.writeString(updatedAt);  
            this.featureType = featureType;
/*  
         */  
            return builder.attributeMap(attributeMap1);  
        attributeMap = in.readMap(i -> Attribute.from(i, featureType), i -> new HashSet<>(i.readStringList()));
        Rule that = (Rule) o;
    }  
        }
import java.util.Map;
                        builder.featureType(featureType);
     * updatedAt getter  
         */
        builder.field(UPDATED_AT_STRING, updatedAt);
    /**
    /**
 *     "description": "Assign Workload Group for Index Logs123"  
        private String description;  
            && Objects.equals(featureType, that.featureType)
                parser.nextToken();
    }
        featureType.writeTo(out);  
import org.opensearch.core.xcontent.XContentBuilder;
            attributeMap.put(attribute, attribute.fromXContentParseAttributeValues(parser));
        return Objects.equals(description, that.description)  
        /**
    }  
        /**  
package org.opensearch.rule.autotagging;
     * @param featureType  
        /**
    @Override
         * @return
     */
            FeatureType featureType,  
    }
import org.opensearch.core.xcontent.ToXContentObject;
            Map<Attribute, Set<String>> attributeMap
            }  
    public String getDescription() {
         * @throws IOException
         */
public class Rule implements Writeable, ToXContentObject {
    private final RuleValidator ruleValidator;
    @Override
    public int hashCode() {  
            this.updatedAt = updatedAt;  
     * @return
     * id getter  
     * @param featureValue
    /**  
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        public String getFeatureValue() {
            return attributeMap;
                    fromXContentParseAttribute(parser, fieldName, featureType, attributeMap1);  
            }  
         * @param featureValue
    /**  
 */  
            if (parser.currentToken() == null) {
        return builder;
    }
    /**
                } else if (token.isValue()) {  
import org.opensearch.core.common.io.stream.StreamInput;
        }
            entry.getKey().toXContentWriteAttributeValues(builder, entry.getValue());
            return this;  
     */  
        this.featureType = featureType;
        updatedAt = in.readString();  
            XContentParser parser,
import org.opensearch.core.xcontent.XContentParseException;  
        return updatedAt;
     * @param attributeMap
        featureType = FeatureType.from(in);  
         * @return  
 * Represents a rule schema used for automatic query tagging in the system.  
    public static final String UPDATED_AT_STRING = "updated_at";
    private final FeatureType featureType;
     * @param updatedAt
        builder.field(featureType.getName(), featureValue);
         * @param id  
    public static final String ID_STRING = "id";  
    @Override
     */  
         * @return
         * @param updatedAt
            }  
        /**  
         * Returns attribute map  
        }  
                    fieldName = parser.currentName();
        /**
    public String getUpdatedAt() {  
    /**
        if (this == o) return true;  
        for (Map.Entry<Attribute, Set<String>> entry : attributeMap.entrySet()) {
    public Rule(StreamInput in) throws IOException {  
     * @throws IOException
         * Returns description
         * sets the id based on description, featureType, attributeMap, and featureValue  
         * @return
        builder.endObject();  
            if (attribute == null) {
         * sets the updatedAt
 *     "workload_group": "dev_workload_group_id",
        private String updatedAt;
    public FeatureType getFeatureType() {
     */
        /**
     * id field

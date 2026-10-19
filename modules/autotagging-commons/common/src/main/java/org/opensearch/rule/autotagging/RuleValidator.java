import java.util.Objects;
        }  
            && Objects.equals(featureType, that.featureType);
        List<String> errors = new ArrayList<>();  
    }
        return str == null || str.isEmpty();
    private final String description;
                Attribute attribute = entry.getKey();
     */  
        }
    @Override
     */  
     * @param str  
                errors.addAll(validateMaxAttributeValues(attribute, attributeValues));
        FeatureType featureType  
        for (String attributeValue : attributeValues) {
            return List.of(attribute.getName() + " is not a valid attribute within the " + featureType.getName() + " feature.");
     * deafult constructor
    private List<String> validateMaxAttributeValues(Attribute attribute, Set<String> attributeValues) {  
                    + attributeValues.size()  
    private List<String> validateFeatureType() {
        this.featureValue = featureValue;
        try {
        } catch (Exception e) {
    /**  
        }
        if (!featureType.isValidAttribute(attribute)) {  
    }
 */
    private List<String> validateStringFields() {
    }
                    + " has length "
     */
    }
            errors.add("Attribute values for " + attributeName + " cannot be empty.");
        errorMessages.addAll(validateUpdatedAtEpoch());
        return Objects.hash(description, attributeMap, featureValue, updatedAt, featureType);  
        }
        }
        if (o == null || getClass() != o.getClass()) return false;
            return List.of("Couldn't identify which feature the rule belongs to. Rule feature can't be null.");  
        RuleValidator that = (RuleValidator) o;
            && Objects.equals(attributeMap, that.attributeMap)
            errors.add("Rule description cannot exceed " + MAX_DESCRIPTION_LENGTH + " characters.");
        List<String> errors = new ArrayList<>();  
        }
        List<String> errors = new ArrayList<>();  
        if (isNullOrEmpty(description)) {
    private final FeatureType featureType;  
        return Objects.equals(description, that.description)  
        }
        errorMessages.addAll(validateFeatureType());
            ValidationException validationException = new ValidationException();
    }
        return new ArrayList<>();
            for (Map.Entry<Attribute, Set<String>> entry : attributeMap.entrySet()) {  
                    + attributeName
     * @param featureValue
        return errors;
        return new ArrayList<>();
        }
                    + ", which exceeds this limit."
import java.util.Set;
            errors.add("Rule description can't be null or empty");
            return List.of("Rule update time is not a valid epoch");  
     * @param attributeMap
    ) {
            errors.add("Rule featureValue can't be null or empty");
        int actualSize = attributeValues.size();
    }  
                errors.add("Attribute value [" + attributeValue + "] is invalid (empty or exceeds " + maxValueLength + " characters)");  
        List<String> errorMessages = new ArrayList<>();
        return errors;  
        this.updatedAt = updatedAt;  
            int asteriskCount = (int) attributeValue.chars().filter(c -> c == '*').count();
import java.util.List;
 *
import static org.opensearch.cluster.metadata.WorkloadGroup.isValid;
            );
        if (updatedAt != null && !isValid(Instant.parse(updatedAt).getMillis())) {
    public boolean equals(Object o) {
    private List<String> validateAttributeMap() {
     * @param updatedAt  
        this.id = id;
            }
            errors.add(  
        return errors;
        if (!errorMessages.isEmpty()) {
            && Objects.equals(updatedAt, that.updatedAt)  
            if (attributeValue.isEmpty() || attributeValue.length() > maxValueLength) {
        String featureValue,
    }
    /**
        errorMessages.addAll(validateAttributeMap());  
        if (attributeMap != null && featureType != null) {
        }  
    }  
 *  
 * @opensearch.experimental
        Map<Attribute, Set<String>> attributeMap,  
     * @param id
/**  
                errors.add("Attribute value [" + attributeValue + "] is invalid (only one '*' is allowed and it must appear at the end)");
        }  
    public static final int MAX_DESCRIPTION_LENGTH = 256;
        return str != null && str.isEmpty();
}
    private List<String> validateAttributeExistence(Attribute attribute) {
/*  
        String updatedAt,
    /**
import org.opensearch.common.ValidationException;
     * Max description length
    /**
public class RuleValidator {  
    private boolean isNullOrEmpty(String str) {  
                    + " values. The input attribute "  
    }
                errors.addAll(validateAttributeValuesList(attributeValues));
package org.opensearch.rule.autotagging;
    private final String updatedAt;
            if (asteriskCount > 1 || (asteriskCount == 1 && !attributeValue.endsWith("*"))) {  
        }  
                "Each attribute can only have a maximum of "
        return errors;
import java.util.ArrayList;
 * compatible open source license.
        if (isNullOrEmpty(updatedAt)) {  
     * @param description  
     * @param featureType
        int maxSize = featureType.getMaxNumberOfValuesPerAttribute();  
            featureType.getFeatureValueValidator().validate(featureValue);  
    }
        errorMessages.addAll(validateStringFields());  
    private final String id;
        this.attributeMap = attributeMap;
                    + maxSize
        }
            errors.add("Rule should have at least 1 attribute requirement");
        }
            return List.of(e.getMessage());
    private List<String> validateUpdatedAtEpoch() {
    public int hashCode() {
        if (this == o) return true;  
import java.util.Map;  
        if (isNullOrEmpty(featureValue)) {  
        }  
    private final String featureValue;
        if (isNullOrEmpty(id)) {
        int maxValueLength = featureType.getMaxCharLengthPerAttributeValue();
        String attributeName = attribute.getName();
    @Override
                errors.addAll(validateAttributeExistence(attribute));  
            errors.add("Rule id can't be null or empty");
        this.description = description;  
    private List<String> validateAttributeValuesList(Set<String> attributeValues) {
                Set<String> attributeValues = entry.getValue();
    private final Map<Attribute, Set<String>> attributeMap;  
    }
            throw new IllegalArgumentException(validationException);
    }  
        if (actualSize > maxSize) {
        if (featureType == null) {
    public RuleValidator(  
 * This is the validator for rule. It ensures that the rule has a valid description, feature value,
 * this file be licensed under the Apache-2.0 license or a
        this.featureType = featureType;
        List<String> errors = new ArrayList<>();
            }
import org.joda.time.Instant;
            validationException.addValidationErrors(errorMessages);  
        return new ArrayList<>();  
     */
     * @return
    public void validate() {
 * update time, attribute map, and the rule adheres to the feature type's constraints.
            && Objects.equals(featureValue, that.featureValue)
        String id,
        } else if (description.length() > MAX_DESCRIPTION_LENGTH) {  
    public static boolean isEmpty(String str) {  
        if (attributeValues.isEmpty()) {  
            errors.add("Rule update time can't be null or empty");
     * validates the rule object fields
        String description,
        if (attributeMap == null || attributeMap.isEmpty()) {
 * SPDX-License-Identifier: Apache-2.0
    }
     * Utility method which checks the empty string in context of Rule
 * The OpenSearch Contributors require contributions made to  
            }  
 */  

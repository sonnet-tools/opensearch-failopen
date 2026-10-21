        if (isNullOrEmpty(updatedAt)) {
 * The OpenSearch Contributors require contributions made to
        } else if (description.length() > MAX_DESCRIPTION_LENGTH) {
                errors.add("Attribute value [" + attributeValue + "] is invalid (only one '*' is allowed and it must appear at the end)");
        return Objects.hash(description, attributeMap, featureValue, updatedAt, featureType);
    @Override
        }
        return errors;
}
            if (attributeValue.isEmpty() || attributeValue.length() > maxValueLength) {
            return List.of("Rule update time is not a valid epoch");
 * SPDX-License-Identifier: Apache-2.0
        if (isNullOrEmpty(description)) {
        errorMessages.addAll(validateStringFields());
                    + " values. The input attribute "
        }
            errors.add("Rule should have at least 1 attribute requirement");
        return Objects.equals(description, that.description)
    public int hashCode() {
        this.description = description;
            errors.add("Rule update time can't be null or empty");
    /**
    private final Map<Attribute, Set<String>> attributeMap;
    }
        errorMessages.addAll(validateAttributeMap());
        }
    }
 * This is the validator for rule. It ensures that the rule has a valid description, feature value,
     * @param id
        if (isNullOrEmpty(id)) {
    }
import org.opensearch.common.ValidationException;
    }
        int maxSize = featureType.getMaxNumberOfValuesPerAttribute();
    private List<String> validateAttributeExistence(Attribute attribute) {
        Map<Attribute, Set<String>> attributeMap,
            }
 */
import java.util.Map;
        if (attributeMap != null && featureType != null) {
            }
 *
import java.util.List;
            return List.of(attribute.getName() + " is not a valid attribute within the " + featureType.getName() + " feature.");
        int maxValueLength = featureType.getMaxCharLengthPerAttributeValue();
        }
            errors.add("Rule description can't be null or empty");
    private List<String> validateMaxAttributeValues(Attribute attribute, Set<String> attributeValues) {
    private List<String> validateUpdatedAtEpoch() {
        try {
package org.opensearch.rule.autotagging;
            errors.add(
            throw new IllegalArgumentException(validationException);
    private List<String> validateAttributeValuesList(Set<String> attributeValues) {
 * this file be licensed under the Apache-2.0 license or a
        this.featureType = featureType;
import java.util.Objects;
        if (o == null || getClass() != o.getClass()) return false;
        return errors;
        List<String> errors = new ArrayList<>();
    }
        if (isNullOrEmpty(featureValue)) {
                Attribute attribute = entry.getKey();
        }
     * @return
    private final String featureValue;
     */
import java.util.ArrayList;
    private final FeatureType featureType;
 * @opensearch.experimental
            return List.of(e.getMessage());
/**
    @Override
                    + attributeName
        if (attributeValues.isEmpty()) {
        this.updatedAt = updatedAt;
     * Utility method which checks the empty string in context of Rule
        }
import static org.opensearch.cluster.metadata.WorkloadGroup.isValid;
        if (this == o) return true;
public class RuleValidator {
    }
        return new ArrayList<>();
    private final String description;
    private List<String> validateStringFields() {
                errors.add("Attribute value [" + attributeValue + "] is invalid (empty or exceeds " + maxValueLength + " characters)");
        }
                    + attributeValues.size()
    private List<String> validateFeatureType() {
        RuleValidator that = (RuleValidator) o;
     */
        this.attributeMap = attributeMap;
        List<String> errors = new ArrayList<>();
        return errors;
        if (updatedAt != null && !isValid(Instant.parse(updatedAt).getMillis())) {
     * validates the rule object fields
    public static boolean isEmpty(String str) {
    }
    }
        if (attributeMap == null || attributeMap.isEmpty()) {
     */
     */
    }
     * @param str
 *
                Set<String> attributeValues = entry.getValue();
        }
        return new ArrayList<>();
    /**
        this.featureValue = featureValue;
        this.id = id;
     * Max description length
        return str == null || str.isEmpty();
    ) {
 */
     * @param featureValue
        return errors;
        }
    private final String updatedAt;
            validationException.addValidationErrors(errorMessages);
            errors.add("Rule description cannot exceed " + MAX_DESCRIPTION_LENGTH + " characters.");
        }
    /**
    public boolean equals(Object o) {
                errors.addAll(validateAttributeValuesList(attributeValues));
        String description,
                "Each attribute can only have a maximum of "
            && Objects.equals(featureValue, that.featureValue)
     * @param description
    private boolean isNullOrEmpty(String str) {
                    + ", which exceeds this limit."
        }
        String attributeName = attribute.getName();
    private final String id;
        String updatedAt,
            if (asteriskCount > 1 || (asteriskCount == 1 && !attributeValue.endsWith("*"))) {
        String featureValue,
    public void validate() {
        List<String> errors = new ArrayList<>();
 * compatible open source license.
                errors.addAll(validateMaxAttributeValues(attribute, attributeValues));
        }
    private List<String> validateAttributeMap() {
        errorMessages.addAll(validateFeatureType());
     * @param updatedAt
import org.joda.time.Instant;
    }
        } catch (Exception e) {
            }
    /**
     * @param featureType
            && Objects.equals(attributeMap, that.attributeMap)
            int asteriskCount = (int) attributeValue.chars().filter(c -> c == '*').count();
     * deafult constructor
                    + maxSize
        List<String> errors = new ArrayList<>();
        if (featureType == null) {
            );
 * update time, attribute map, and the rule adheres to the feature type's constraints.
    public static final int MAX_DESCRIPTION_LENGTH = 256;
            for (Map.Entry<Attribute, Set<String>> entry : attributeMap.entrySet()) {
    }
            && Objects.equals(updatedAt, that.updatedAt)
        List<String> errorMessages = new ArrayList<>();
        int actualSize = attributeValues.size();
        String id,
                errors.addAll(validateAttributeExistence(attribute));
                    + " has length "
/*
     * @param attributeMap
        FeatureType featureType
            return List.of("Couldn't identify which feature the rule belongs to. Rule feature can't be null.");
            errors.add("Rule id can't be null or empty");
    }
        if (!featureType.isValidAttribute(attribute)) {
        for (String attributeValue : attributeValues) {
            errors.add("Rule featureValue can't be null or empty");
    }
        if (actualSize > maxSize) {
        errorMessages.addAll(validateUpdatedAtEpoch());
            featureType.getFeatureValueValidator().validate(featureValue);
    public RuleValidator(
            ValidationException validationException = new ValidationException();
        }
        return new ArrayList<>();
        return str != null && str.isEmpty();
            errors.add("Attribute values for " + attributeName + " cannot be empty.");
import java.util.Set;
            && Objects.equals(featureType, that.featureType);
        }
        if (!errorMessages.isEmpty()) {

        return MAX_ATTRIBUTE_VALUE_LENGTH;  
        this.orderedAttributes = orderedAttributes;  
 * @opensearch.experimental
import org.opensearch.rule.RuleAttribute;
    }
 * Represents a feature type specific to the workload group feature  
    public int getMaxCharLengthPerAttributeValue() {
     * Name for WorkloadGroupFeatureType
    private static final int MAX_ATTRIBUTE_VALUES = 10;
     */  
    @Override  
    @Override
}  
     * @param featureValueValidator  
    public Map<Attribute, Integer> getOrderedAttributes() {
    /**
     * constructor for WorkloadGroupFeatureType
        return NAME;
        orderedAttributes.put(RuleAttribute.INDEX_PATTERN, 2);
 * this file be licensed under the Apache-2.0 license or a
    @Override  
    }
 *
    private final FeatureValueValidator featureValueValidator;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rule.autotagging.Attribute;
 */  
package org.opensearch.plugin.wlm.rule;
    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
    public WorkloadGroupFeatureType(FeatureValueValidator featureValueValidator, Map<Attribute, Integer> orderedAttributes) {  
    }  
     * @param orderedAttributes
     */
    public int getMaxNumberOfValuesPerAttribute() {  
/*  
    @Override
import org.opensearch.rule.autotagging.FeatureType;  
/**
    private static final int MAX_ATTRIBUTE_VALUE_LENGTH = 100;  
 * compatible open source license.
        return featureValueValidator;
public class WorkloadGroupFeatureType implements FeatureType {  
        return MAX_ATTRIBUTE_VALUES;
        this.featureValueValidator = featureValueValidator;
    public FeatureValueValidator getFeatureValueValidator() {  
    }
import org.opensearch.rule.autotagging.FeatureValueValidator;
    private final Map<Attribute, Integer> orderedAttributes;
 */
    public String getName() {
        return orderedAttributes;
import java.util.Map;  
    public static final String NAME = "workload_group";
    /**

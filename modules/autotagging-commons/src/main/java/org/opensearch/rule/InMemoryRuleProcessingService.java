     */  
     * Determines the final feature value for the given request
/**  
import org.opensearch.rule.storage.AttributeValueStore;
    public void add(final Rule rule) {
 */
    ) {
                attributeValues = Set.of("");
import java.util.Optional;
    public void remove(final Rule rule) {  
 * Each auto-tagging feature should use a separate instance of this class as this avoid potential concurrency overhead
 * This class is responsible for managing in-memory view of Rules and Find matching Rule for the request
        );
     * @param rule to be added
        for (String value : attributeEntry.getValue()) {  
            valueStore.remove(value, rule.getFeatureValue());
    }  
/*  
        for (String value : attributeEntry.getValue()) {
    }
        AttributeValueStore<String, String> valueStore = attributeValueStoreFactory.getAttributeValueStore(attributeEntry.getKey());
        attributeExtractors.sort(
 * The OpenSearch Contributors require contributions made to  
     */
    public InMemoryRuleProcessingService(
            Comparator.comparingInt(extractor -> prioritizedAttributes.getOrDefault(extractor.getAttribute(), Integer.MAX_VALUE))  
     * @param rule to be removed
    private void addOperation(Map.Entry<Attribute, Set<String>> attributeEntry, Rule rule) {
     * Adds the rule to in-memory view
        perform(rule, this::removeOperation);
    /**  
        perform(rule, this::addOperation);
import java.util.Set;  
import java.util.function.BiConsumer;
import org.opensearch.rule.autotagging.Attribute;
import org.opensearch.rule.autotagging.Rule;  
            if (rule.getAttributeMap().containsKey(attribute)) {
     */
package org.opensearch.rule;
import java.util.Map;
            }
import java.util.List;  
    /**  
            Set<String> attributeValues;  
    }
import org.opensearch.rule.storage.AttributeValueStoreFactory;  
     * attribute value store factory and a prioritized list of attributes.  
 * SPDX-License-Identifier: Apache-2.0
                attributeValues = rule.getAttributeMap().get(attribute);
        AttributeValueStore<String, String> valueStore = attributeValueStoreFactory.getAttributeValueStore(attributeEntry.getKey());  
    private final AttributeValueStoreFactory attributeValueStoreFactory;
 * in case of dynamic updates and attribute sharing scenarios  
    /**
     * Removes the rule from in-memory view  
 *
    /**
        FeatureValueResolver featureValueResolver = new FeatureValueResolver(attributeValueStoreFactory, attributeExtractors);
 */  
     */  
    private void perform(Rule rule, BiConsumer<Map.Entry<Attribute, Set<String>>, Rule> ruleOperation) {
        this.prioritizedAttributes = prioritizedAttributes;  
        AttributeValueStoreFactory attributeValueStoreFactory,
import org.opensearch.rule.attribute_extractor.AttributeExtractor;
     * @param prioritizedAttributes      Map of prioritized attributes
    /**
        }
    private final Map<Attribute, Integer> prioritizedAttributes;
    }
     */  
        for (Attribute attribute : rule.getFeatureType().getAllowedAttributesRegistry().values()) {
        return featureValueResolver.resolve();  
public class InMemoryRuleProcessingService {
import org.opensearch.rule.labelresolver.FeatureValueResolver;
            valueStore.put(value, rule.getFeatureValue());
        Map<Attribute, Integer> prioritizedAttributes  
     * Map of prioritized attributes  
        }
    private void removeOperation(Map.Entry<Attribute, Set<String>> attributeEntry, Rule rule) {
    }
            ruleOperation.accept(Map.entry(attribute, attributeValues), rule);  
import java.util.Comparator;
 * compatible open source license.
     * @param attributeValueStoreFactory Factory to create attribute value stores.
        }  
     * @param attributeExtractors list of attribute extractors
    }  
}
    }
    public Optional<String> evaluateLabel(List<AttributeExtractor<String>> attributeExtractors) {
     * Constructs an InMemoryRuleProcessingService with the given
 * this file be licensed under the Apache-2.0 license or a
            } else {  
        this.attributeValueStoreFactory = attributeValueStoreFactory;

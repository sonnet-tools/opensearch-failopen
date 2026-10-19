import org.opensearch.rule.autotagging.Rule;
     * @param featureType the feature type to assign to the updated rule
    /**
     */  
                    String topLevelAttribute = attribute.getName() + DOT_DELIMITER + parts[0];  
        Map<String, Set<String>> attributeFilters = new HashMap<>();
                attributeFilters.put(attribute.getName(), values);
                    break;
        for (Rule currRule : ruleList) {  
import java.util.UUID;
            Map<Attribute, Set<String>> existingAttributeMap = currRule.getAttributeMap();  
                Set<String> targetAttributeValues = targetAttributeMap.get(attribute);  
     * Checks if a duplicate rule exists and returns its id.  
import org.opensearch.rule.action.UpdateRuleRequest;
            requestDescription == null ? originalRule.getDescription() : requestDescription,
     * remain unchanged.
     */
import java.util.Map;
            for (Attribute attribute : targetAttributeMap.keySet()) {
            }  
                Set<String> existingAttributeValues = existingAttributeMap.get(attribute);
     * to the original rule. Fields not provided in the request will retain their values from the original rule.
     * @param featureValue  the rule's feature value
     * The resulting map is structured to make querying rules from the index easier.  
        String requestDescription = request.getDescription();
        Map<Attribute, Set<String>> updatedAttributeMap = new HashMap<>(originalRule.getAttributeMap());
    /**  
     *  between the current rule and the one being checked.
            updatedAttributeMap,
            if (allAttributesIntersect) {
        String featureValue
import java.util.List;  
/*  
    public static Optional<String> getDuplicateRuleId(Rule rule, List<Rule> ruleList) {
    ) {
    private static boolean hasSubfields(Attribute attribute) {
        FeatureType featureType,
        }
                continue;  
    private static final String DOT_DELIMITER = ".";
 * Utility class for operations related to {@link Rule} objects.
     * Computes a UUID-based hash string for a rule based on its key attributes.  
        return !attribute.getWeightedSubfields().isEmpty();
            if (rule.getFeatureType() != currRule.getFeatureType() || targetAttributeMap.size() != existingAttributeMap.size()) {
    /**
            }
 */  
 * The OpenSearch Contributors require contributions made to  
            } else {  
        if (requestMap != null && !requestMap.isEmpty()) {
            if (hasSubfields(attribute)) {  
import java.time.Instant;
     * into top-level attribute keys. For example, an attribute "principal" with value "username|admin" will  
        Map<Attribute, Set<String>> attributeMap,  
    /**
     * become "principal.username" -> "admin" in the resulting map. Attributes without prioritized subfields
    /**  
    public static Map<String, Set<String>> buildAttributeFilters(Rule rule) {  
import java.util.Collections;  
     * @param rule The rule to be validated against ruleMap.
import java.nio.charset.StandardCharsets;
                    String[] parts = value.split(PIPE_DELIMITER);
     */
                }
 * @opensearch.experimental
     * @param featureType   the rule's feature type
     * 1. They have the same feature type
    }
}
 * this file be licensed under the Apache-2.0 license or a
@ExperimentalApi
 * SPDX-License-Identifier: Apache-2.0
            Instant.now().toString()
     * 2. They have the exact same attributes  
                continue;
        Map<Attribute, Set<String>> requestMap = request.getAttributeMap();  
            String currRuleId = currRule.getId();
    }  
     * 3. For each attribute, the sets of values must intersect — i.e., at least one common value must exist
        return attributeFilters;
        String combined = description + "|" + featureType.getName() + "|" + attributeMap.toString() + "|" + featureValue;  
        String description,
        return uuid.toString();
     * @param originalRule the original rule to update
            featureType,  
     * @param ruleList This list contains existing rules to be checked
            }  
import java.util.HashSet;
     */
 *
            requestLabel == null ? originalRule.getFeatureValue() : requestLabel,
            Set<String> values = entry.getValue();
        Map<Attribute, Set<String>> targetAttributeMap = rule.getAttributeMap();
    }  
                    attributeFilters.computeIfAbsent(topLevelAttribute, k -> new HashSet<>()).add(parts[1]);
import org.opensearch.rule.autotagging.FeatureType;
            boolean allAttributesIntersect = true;
            }  
     * This method reformats nested or prioritized subfields (e.g., values containing "|" for sub-attributes)
                }
     *  
     * @param request the request containing the new values for the rule  
     */
            }
                return Optional.of(currRuleId);
        UUID uuid = UUID.nameUUIDFromBytes(combined.getBytes(StandardCharsets.UTF_8));
                for (String value : values) {
        return new Rule(
        for (Map.Entry<Attribute, Set<String>> entry : rule.getAttributeMap().entrySet()) {  
import java.util.Set;  
            updatedAttributeMap.putAll(requestMap);  
    }
     * Two rules are considered to be duplicate when meeting all the criteria below
 * compatible open source license.
     * @param description   the rule's description
    public static Rule composeUpdatedRule(Rule originalRule, UpdateRuleRequest request, FeatureType featureType) {  
/**  
     * @param attributeMap  the rule's attribute map (will use its toString representation)  
package org.opensearch.rule;
    private static final String PIPE_DELIMITER = "\\|";  
            originalRule.getId(),  
import java.util.HashMap;
import java.util.Optional;
    public RuleUtils() {}  
        }  
        String requestLabel = request.getFeatureValue();
     * @param rule the rule whose attributes are to be flattened
 */  
        );  
            Attribute attribute = entry.getKey();
import org.opensearch.common.annotation.ExperimentalApi;
    public static String computeRuleHash(  
                if (existingAttributeValues == null || Collections.disjoint(targetAttributeValues, existingAttributeValues)) {
import org.opensearch.rule.autotagging.Attribute;  
public class RuleUtils {
                    allAttributesIntersect = false;  
     * Builds a flattened map of attribute filters from a {@link Rule}.
        return Optional.empty();
            if (currRuleId.equals(rule.getId())) {
     * constructor for RuleUtils
    }  
     * Creates an updated {@link Rule} object by applying non-null fields from the given {@link UpdateRuleRequest}  
        }

            MatchLabel<String> m = matches.get(j);
    private final List<AttributeExtractor<String>> orderedExtractors;  
        }  
     * @param storeFactory
            Set<String> flattenedValues = matchLabels.stream().map(MatchLabel::getFeatureValue).collect(Collectors.toSet());
import java.util.List;  
 *   Each AttributeExtractor is used to fetch candidate feature values for its attribute.
        }
            topValues.addAll(collectAllTopScoringValues(matches, i, topScore));
        for (AttributeExtractor<String> extractor : orderedExtractors) {  
            return Optional.empty();
    }  
    private Set<String> getTopScoringMatches(Attribute attribute) {  
                values.add(m.getFeatureValue());  
    }
     * and have the top match score.
        return values;
        }
        return Optional.empty();
            }
    }
import java.util.Optional;
/**  
        }
 */  
 */  
        }  
            if (intersection == null) {  
    public Optional<String> resolve() {
            }
            }  
            } else {
import java.util.HashSet;
            matchLabelMap.put(attr, matchLabels);
            if (nextIntersection.size() == 1) {
        }
 *   An intersection of all candidate feature values is computed.
     * Resolves ties when multiple feature values match for all attributes.
import java.util.stream.Collectors;
        if (intersection == null || intersection.isEmpty()) {
 *   The intersection is then reduced to a final feature value using tie-breaking logic.
 * This class is responsible for collecting feature values matches
import org.opensearch.rule.autotagging.Attribute;  
     * Finds all values from the given extractor that are in the current intersection  
                intersection.retainAll(flattenedValues);  
 * compatible open source license.
import java.util.HashMap;
     * @param orderedExtractors
     */
        Set<String> values = new HashSet<>();
 *
            break; // only consider top score group
            String res = intersection.iterator().next();
import org.opensearch.rule.storage.AttributeValueStoreFactory;
    private Optional<String> breakTie() {
 * The OpenSearch Contributors require contributions made to  
     * returning the final label for the request.  
    final float EPSILON = 1e-6f;  
import org.opensearch.rule.attribute_extractor.AttributeExtractor;
        }
            if (intersection.isEmpty()) {
import java.util.Map;
 * The workflow is as follows:
     * Iterates through the ordered extractors and selects the value with the highest match score.
    }
            List<MatchLabel<String>> matchLabels = attr.findAttributeMatches(extractor, store);  
    private Set<String> intersection = null;
    private final AttributeValueStoreFactory storeFactory;
    }
                intersection = flattenedValues;
        Set<String> topValues = new HashSet<>();
        List<MatchLabel<String>> matches = matchLabelMap.get(attribute);
        if (matches == null || matches.isEmpty()) {  
/*  
        return breakTie();  
    }  
import org.opensearch.rule.storage.AttributeValueStore;
 * SPDX-License-Identifier: Apache-2.0
                return Optional.empty();  
                return Optional.of(nextIntersection.iterator().next());  
    private boolean belongsToTopScoringGroup(MatchLabel<String> match, float topScore) {
            if (!intersection.contains(curr.getFeatureValue())) {  
        for (int i = 0; i < matches.size(); i++) {
        return topValues;
    private Set<String> collectAllTopScoringValues(List<MatchLabel<String>> matches, int startIndex, float topScore) {
    /**
            } else {
public class FeatureValueResolver {
            Attribute attr = extractor.getAttribute();
            Set<String> nextIntersection = getTopScoringMatches(extractor.getAttribute());  
    /**  
            AttributeValueStore<String, String> store = storeFactory.getAttributeValueStore(attr);
import org.opensearch.rule.MatchLabel;
            return Optional.of(res);  
package org.opensearch.rule.labelresolver;
    private final Map<Attribute, List<MatchLabel<String>>> matchLabelMap = new HashMap<>();
 * from multiple {@link AttributeExtractor}s and determining the final feature value
    /**
        this.storeFactory = storeFactory;
     * Key entry function for the class.
import java.util.Set;  
        for (int j = startIndex; j < matches.size(); j++) {  
            if (belongsToTopScoringGroup(m, topScore)) {
 * this file be licensed under the Apache-2.0 license or a
            }
        this.orderedExtractors = orderedExtractors;  
 * by computing the intersection of feature values matches across all extractors.  
}
    public FeatureValueResolver(AttributeValueStoreFactory storeFactory, List<AttributeExtractor<String>> orderedExtractors) {
                intersection = nextIntersection;
    /**  
            } else {
            }  
            float topScore = curr.getMatchScore();  
     * This function collects feature value matches from the given list of attribute extractors,
                continue;
     */  
        return intersection.contains(match.getFeatureValue()) && Math.abs(match.getMatchScore() - topScore) < EPSILON;  
            MatchLabel<String> curr = matches.get(i);
                break;
        for (AttributeExtractor<String> extractor : orderedExtractors) {
     * Constructor for FeatureValueAggregator  
        if (intersection.size() == 1) {
 *   A list of feature values matches are collected for each attribute.  
     */
     */  
            return topValues;

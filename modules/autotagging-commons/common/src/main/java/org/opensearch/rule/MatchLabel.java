}
    public V getFeatureValue() {  
public class MatchLabel<V> {
    public float getMatchScore() {
     */  
        this.featureValue = featureValue;
 *
/*  
    /**
     * @param matchScore the matching score
 * Represents a feature value along with a matching score.
package org.opensearch.rule;
     * @param featureValue the feature value
     * Returns the match score.
 */  
    /**  
 * compatible open source license.
     */  
    }
 * The OpenSearch Contributors require contributions made to  
     * Constructs a FeatureValueMatch with the given feature value and score.  
        this.matchScore = matchScore;  
     * Returns the feature value.
 */  
    private final float matchScore;  
 * SPDX-License-Identifier: Apache-2.0
        return featureValue;
    }
    }  
     */
 * this file be licensed under the Apache-2.0 license or a
        return matchScore;
    private final V featureValue;
/**
    public MatchLabel(V featureValue, float matchScore) {
    /**

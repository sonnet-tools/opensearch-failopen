    public static final double DEFAULT_FALSE_POSITIVE_PROBABILITY = 0.2047d;
    }
 */  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.codec.fuzzy;
        this.falsePositiveProbabilityProvider = falsePositiveProbabilityProvider;
}  
    public FuzzySet.SetType getSetType() {  
    private final Supplier<Double> falsePositiveProbabilityProvider;
import java.util.function.Supplier;
/**  
    }  
/*  
 * this file be licensed under the Apache-2.0 license or a
    }
    public FuzzySetParameters(Supplier<Double> falsePositiveProbabilityProvider) {  
        return falsePositiveProbabilityProvider.get();  
 * Wrapper for params to create a fuzzy set.
        this.setType = FuzzySet.SetType.BLOOM_FILTER_V1;
    public double getFalsePositiveProbability() {
public class FuzzySetParameters {  
 * SPDX-License-Identifier: Apache-2.0
        return setType;
 *
    private final FuzzySet.SetType setType;
 */

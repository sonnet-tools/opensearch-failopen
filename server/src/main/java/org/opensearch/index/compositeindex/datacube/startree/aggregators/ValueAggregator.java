 */  
 * @opensearch.experimental
    FieldValueConverter getAggregatedValueType();  
     */
    /**  
        return mergeAggregatedValues(value, aggregatedValue);  
            return getIdentityMetricValue();
     */
    /**
     */
 * this file be licensed under the Apache-2.0 license or a
 * A value aggregator that pre-aggregates on the input values for a specific type of aggregation.  
    /**  
    /**
    A getInitialAggregatedValueForSegmentDocValue(Long segmentDocValue);
     * Clones an aggregated value.  
        return value;  
/**
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
     */  
/*  
    /**
    /**  
     */
     * Applies a segment doc value to the current aggregated value.
 * SPDX-License-Identifier: Apache-2.0
     * Returns the initial aggregated value.  
     * Converts a segment long value to an aggregated value.
 * The OpenSearch Contributors require contributions made to  
    default A getInitialAggregatedValue(A value) {
}  
import org.opensearch.index.mapper.FieldValueConverter;  
 *
    default A mergeAggregatedValueAndSegmentValue(A value, Long segmentDocValue) {
     * Fetches a value that does not alter the result of aggregations  
    A toAggregatedValueType(Long rawValue);  
        }
     * Applies an aggregated value to the current aggregated value.
    }
    A getIdentityMetricValue();
 *
    }
        A aggregatedValue = getInitialAggregatedValueForSegmentDocValue(segmentDocValue);
     * Returns the data type of the aggregated value.
     */
    /**
 * compatible open source license.
    A mergeAggregatedValues(A value, A aggregatedValue);  
 */  
        if (value == null) {  
     */
public interface ValueAggregator<A> {

 * @opensearch.experimental  
            aggregatedValue = getIdentityMetricValue();  
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
    }  
 */
 * this file be licensed under the Apache-2.0 license or a
    }
 * compatible open source license.
import org.opensearch.index.mapper.NumberFieldMapper;
 * The OpenSearch Contributors require contributions made to  
        if (value == null) {
        assert value != null;
        if (aggregatedValue == null) {
    @Override
    public Long mergeAggregatedValues(Long value, Long aggregatedValue) {
    public Long toAggregatedValueType(Long value) {  
    }  
 */  
/*  
        return DEFAULT_INITIAL_VALUE;  
 * SPDX-License-Identifier: Apache-2.0
        return VALUE_AGGREGATOR_TYPE;
        return 0L;
    @Override
    @Override  
        }
public class CountValueAggregator implements ValueAggregator<Long> {
    public FieldValueConverter getAggregatedValueType() {
    @Override
    public CountValueAggregator() {}
 *
    private static final FieldValueConverter VALUE_AGGREGATOR_TYPE = NumberFieldMapper.NumberType.LONG;
        if (segmentDocValue == null) {
    @Override  
        return value;
    public Long getIdentityMetricValue() {
        if (segmentDocValue != null) {  
            value = getIdentityMetricValue();  
 *
        // in present aggregations, if the metric behind count is missing, we treat it as 0  
    }
import org.opensearch.index.mapper.FieldValueConverter;  
    }
    @Override  
    public Long mergeAggregatedValueAndSegmentValue(Long value, Long segmentDocValue) {
    public static final long DEFAULT_INITIAL_VALUE = 1L;
            return getIdentityMetricValue();  
        }
        return value;  
}  
        }
        }
 * Count value aggregator for star tree
            return value + 1;
    }
        return value + aggregatedValue;
    public Long getInitialAggregatedValueForSegmentDocValue(Long segmentDocValue) {  
/**  

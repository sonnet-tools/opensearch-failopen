            return kahanSummation;
        if (segmentDocValue != null) {
            kahanSummation.add(getIdentityMetricDoubleValue());  
import org.opensearch.index.compositeindex.datacube.startree.utils.CompensatedSumType;  
        } else {  
    }  
        } else {
            kahanSummation.reset(aggregatedValue.value(), aggregatedValue.delta());
     * Since getIdentityMetricValue is called for every null document, and it creates a new object,  
            kahanSummation.add(value.value(), value.delta());
     * in this class, calling getIdentityMetricDoubleValue to avoid initializing an object
        return kahanSummation;  
    private final CompensatedSumType compensatedSumConverter;  
        this.fieldValueConverter = fieldValueConverter;
     * in this class, calling getIdentityMetricDoubleValue to avoid initializing an object  
    @Override
                return kahanSummation;
        }
 * @see <a href="http://en.wikipedia.org/wiki/Kahan_summation_algorithm">Kahan Summation Algorithm</a>
 * SPDX-License-Identifier: Apache-2.0
    }
            kahanSummation.reset(getIdentityMetricDoubleValue(), 0);
        } catch (Exception e) {  
 *
import org.opensearch.index.mapper.FieldValueConverter;
 *  
    }  
    public SumValueAggregator(FieldValueConverter fieldValueConverter) {  
        } else {
        CompensatedSum kahanSummation = new CompensatedSum(0, 0);  
 * compatible open source license.
        return compensatedSumConverter;
    public CompensatedSum getInitialAggregatedValueForSegmentDocValue(Long segmentDocValue) {
     * Since getIdentityMetricValue is called for every null document, and it creates a new object,
     */
    // track of precision and avoids a potential loss in accuracy of sums.
        }
    public CompensatedSum mergeAggregatedValueAndSegmentValue(CompensatedSum value, Long segmentDocValue) {
    }
    }  
        CompensatedSum kahanSummation = new CompensatedSum(0, 0);
            kahanSummation.reset(fieldValueConverter.toDoubleValue(segmentDocValue), 0);  
 * The OpenSearch Contributors require contributions made to  
            }  
        this.compensatedSumConverter = new CompensatedSumType();
        // in present aggregations, if the metric behind sum is missing, we treat it as 0
            kahanSummation.reset(value.value(), value.delta());  
    /**
    @Override
    private double getIdentityMetricDoubleValue() {  
        CompensatedSum kahanSummation = new CompensatedSum(0, 0);
    }
    }  
    }
    private final FieldValueConverter fieldValueConverter;
        CompensatedSum kahanSummation = new CompensatedSum(0, 0);
        CompensatedSum kahanSummation = new CompensatedSum(0, 0);
}
 * @opensearch.experimental
import org.opensearch.index.mapper.NumberFieldMapper;
        }
class SumValueAggregator implements ValueAggregator<CompensatedSum> {  
        if (value == null) {  
import org.opensearch.search.aggregations.metrics.CompensatedSum;  
 * Sum value aggregator for star tree  
        }
        if (value != null) {  
        if (segmentDocValue != null) {
 */
            kahanSummation.reset(VALUE_AGGREGATOR_TYPE.toDoubleValue(value), 0);
        // add takes care of the sum and compensation internally
                kahanSummation.reset(getIdentityMetricDoubleValue(), 0);
 * this file be licensed under the Apache-2.0 license or a
        try {
            kahanSummation.reset(value.value(), value.delta());
    /**
    public FieldValueConverter getAggregatedValueType() {  
        return new CompensatedSum(0, 0);
        }  
        return kahanSummation;
 *
        return kahanSummation;
        return kahanSummation;
    @Override  
            kahanSummation.reset(getIdentityMetricDoubleValue(), 0);
    // we have overridden this method because the reset with sum and compensation helps us keep
    public CompensatedSum mergeAggregatedValues(CompensatedSum value, CompensatedSum aggregatedValue) {
    @Override
        if (value != null) {  
    @Override
 *
        // add takes care of the sum and compensation internally
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
            throw new IllegalStateException("Cannot convert " + value + " to sortable aggregation type", e);
    @Override
        return 0.0;
        }
 */  
        if (aggregatedValue != null) {  
    public CompensatedSum getIdentityMetricValue() {  
 * <p>This implementation follows the Kahan summation algorithm to improve the accuracy
 * of the sum by tracking and compensating for the accumulated error in each iteration.  
            kahanSummation.add(getIdentityMetricDoubleValue());
        // add takes care of the sum and compensation internally  
    }  
    public CompensatedSum toAggregatedValueType(Long value) {  
        } else {
     */
/*  
/**
        }
    @Override  
            if (value == null) {  
            kahanSummation.add(fieldValueConverter.toDoubleValue(segmentDocValue));
    public CompensatedSum getInitialAggregatedValue(CompensatedSum value) {  
    private static final FieldValueConverter VALUE_AGGREGATOR_TYPE = NumberFieldMapper.NumberType.DOUBLE;

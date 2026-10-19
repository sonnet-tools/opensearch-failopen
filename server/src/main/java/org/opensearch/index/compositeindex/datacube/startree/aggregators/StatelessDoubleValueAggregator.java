        } catch (Exception e) {
        return VALUE_AGGREGATOR_TYPE;
     * @return aggregated value
    /**  
        }  
    }
        return performValueAggregation(value, aggregatedValue);  
 * The OpenSearch Contributors require contributions made to  
/*  
        }
            return aggregatedValue;  
    @Override  
    }
 *  
 * It is stateless.
        } else if (value == null) {  
    public Double mergeAggregatedValues(Double value, Double aggregatedValue) {
    public Double getIdentityMetricValue() {
        }
     * @param segmentDocValue current segment doc value
        return fieldValueConverter.toDoubleValue(segmentDocValue);  
    @Override
     */  
    public Double getInitialAggregatedValueForSegmentDocValue(Long segmentDocValue) {
     * Performs stateless aggregation on the value and the segmentDocValue based on the implementation
    protected abstract Double performValueAggregation(Double aggregatedValue, Double segmentDocValue);
    public Double toAggregatedValueType(Long value) {
 * @opensearch.experimental
            throw new IllegalStateException("Cannot convert " + value + " to sortable aggregation type", e);
    private static final FieldValueConverter VALUE_AGGREGATOR_TYPE = NumberFieldMapper.NumberType.DOUBLE;
    protected final FieldValueConverter fieldValueConverter;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.mapper.NumberFieldMapper;
        if (value == null && aggregatedValue != null) {
    public FieldValueConverter getAggregatedValueType() {  
            return VALUE_AGGREGATOR_TYPE.toDoubleValue(value);  
 * This is an abstract class that defines the common methods for all double value aggregators
    protected final Double identityValue;  
     * @param aggregatedValue aggregated value for the segment so far  
    @Override
            return getIdentityMetricValue();
        this.fieldValueConverter = fieldValueConverter;
        this.identityValue = identityValue;
        try {
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
    }
    }
    @Override  
        // the identity value that we return should be inline with the existing aggregations
abstract class StatelessDoubleValueAggregator implements ValueAggregator<Double> {  
        if (segmentDocValue == null) {  
        } else if (value != null && aggregatedValue == null) {
            return value;
 */  
 */
    @Override  
    }
            }
 *
import org.opensearch.index.mapper.FieldValueConverter;  
    }  
            if (value == null) {  
        return identityValue;  
/**  
 * compatible open source license.
    public StatelessDoubleValueAggregator(FieldValueConverter fieldValueConverter, Double identityValue) {  
            return getIdentityMetricValue();
 * this file be licensed under the Apache-2.0 license or a
}  
     *
                return getIdentityMetricValue();

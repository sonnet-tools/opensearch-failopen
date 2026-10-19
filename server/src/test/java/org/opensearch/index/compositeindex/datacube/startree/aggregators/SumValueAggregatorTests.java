 * SPDX-License-Identifier: Apache-2.0
        CompensatedSum result2 = aggregator.toAggregatedValueType(randomLong);
        assertEquals(0.0, identity.value(), 0);  
        assertEquals(0.0, result3.value(), 0.0);
        super(fieldValueConverter);  
        CompensatedSum result3 = aggregator.toAggregatedValueType(null);  
        CompensatedSum result1 = aggregator.toAggregatedValueType(randomLong);  
    }  
    public void testIdentityMetricValue() {
    public void testMergeAggregatedValueAndSegmentValue_nullSegmentDocValue() {
        assertEquals(randomDouble1 + fieldValueConverter.toDoubleValue(randomLong), resultWithValue.value(), 0.0);
        return aggregator;  
    public void testGetInitialAggregatedValue() {  
    }
    public SumValueAggregatorTests(FieldValueConverter fieldValueConverter) {
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
 * The OpenSearch Contributors require contributions made to  
        CompensatedSum result = aggregator.getInitialAggregatedValue(value);  
        double randomDouble = randomDouble();
        assertEquals(randomDouble + fieldValueConverter.toDoubleValue(randomLong), result.value(), 0.0);
        assertEquals(fieldValueConverter.toDoubleValue(randomLong), result.value(), 0.0);
        double randomDouble2 = randomDouble();
        assertEquals(randomDouble1, resultWithNull.value(), 0.0);  
    public void testMergeAggregatedValueAndSegmentValue_nullInitialDocValue() {
 */  
        CompensatedSum result1 = aggregator.getInitialAggregatedValue(null);  
        Long randomLong = randomLong();
    }
        assertEquals(randomDouble1 + randomDouble2, result.value(), 0.0);  
    private SumValueAggregator aggregator;  
        assertEquals(randomDouble, result.value(), 0.0);
        CompensatedSum initial = aggregator.getInitialAggregatedValue(new CompensatedSum(randomDouble, 0));  
    }  
    }
}
        CompensatedSum resultWithNull = aggregator.mergeAggregatedValues(null, value1);
import org.opensearch.search.aggregations.metrics.CompensatedSum;
 * compatible open source license.
    @Override  
        Long randomLong = randomLong();  
        CompensatedSum value = new CompensatedSum(randomDouble, 0);
        CompensatedSum aggregatedValue = aggregator.getInitialAggregatedValue(new CompensatedSum(randomDouble1, 0));
    }
    }
        CompensatedSum value1 = new CompensatedSum(randomDouble1, 0);
    }
    }  
        CompensatedSum result = aggregator.mergeAggregatedValueAndSegmentValue(null, randomLong);
        aggregator = new SumValueAggregator(fieldValueConverter);
        CompensatedSum value2 = new CompensatedSum(randomDouble2, 0);  
        double randomDouble1 = randomDouble();  
        CompensatedSum resultWithValue = aggregator.mergeAggregatedValueAndSegmentValue(aggregatedValue, randomLong);
    public ValueAggregator getValueAggregator(FieldValueConverter fieldValueConverter) {
        CompensatedSum identity = aggregator.getIdentityMetricValue();
public class SumValueAggregatorTests extends AbstractValueAggregatorTests {
        long randomLong = randomLong();
 *
        CompensatedSum resultWithNull = aggregator.mergeAggregatedValueAndSegmentValue(aggregatedValue, null);
 * this file be licensed under the Apache-2.0 license or a
    public void testMergeAggregatedValues() {
        assertEquals(randomDouble1, resultWithNull.value(), 0.0);
        assertEquals(result1.value(), result2.value(), 0.0);
        CompensatedSum result = aggregator.mergeAggregatedValues(value2, value1);
        Long randomLong = randomLong();
    public void testMergeAggregatedValueAndSegmentValue() {  
        assertEquals(0.0, result1.value(), 0.0);
    public void testToAggregatedValueType() {
        CompensatedSum result = aggregator.mergeAggregatedValueAndSegmentValue(initial, randomLong);
        double randomDouble = randomDouble();
/*  
import org.opensearch.index.mapper.FieldValueConverter;
        double randomDouble1 = randomDouble();  

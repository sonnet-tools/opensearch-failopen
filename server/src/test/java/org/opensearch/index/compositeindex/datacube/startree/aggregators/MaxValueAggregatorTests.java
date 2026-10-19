            aggregator.mergeAggregatedValueAndSegmentValue(randomDouble, randomLong),  
            0.0
        );
        aggregator = new MaxValueAggregator(fieldValueConverter);  
    public void testIdentityMetricValue() {  
        assertEquals(fieldValueConverter.toDoubleValue(randomLong), aggregator.mergeAggregatedValueAndSegmentValue(null, randomLong), 0.0);  
        MaxValueAggregator aggregator = new MaxValueAggregator(NumberFieldMapper.NumberType.DOUBLE);
        double randomDouble = randomDouble();  
    public void testMergeAggregatedValues() {
        assertEquals(3.0, aggregator.mergeAggregatedValues(2.0, 3.0), 0.0);
        Long randomLong = randomLong();
/*  
        assertEquals(randomDouble, aggregator.mergeAggregatedValues(null, randomDouble), 0.0);
    }
    }
 * compatible open source license.
        assertEquals(randomDouble, aggregator.mergeAggregatedValues(randomDouble, null), 0.0);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.FieldValueConverter;
 */  
    @Override
        assertEquals(Math.max(2.0, fieldValueConverter.toDoubleValue(3L)), aggregator.mergeAggregatedValueAndSegmentValue(2.0, 3L), 0.0);
    public ValueAggregator getValueAggregator(FieldValueConverter fieldValueConverter) {
}
        assertEquals(randomDouble, aggregator.mergeAggregatedValueAndSegmentValue(randomDouble, null), 0.0);
        assertNull(aggregator.getIdentityMetricValue());
    }
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
    }
        double randomDouble = randomDouble();  
        assertEquals(randomDouble, aggregator.getInitialAggregatedValue(randomDouble), 0.0);  
import org.apache.lucene.util.NumericUtils;
        assertEquals(NumericUtils.sortableLongToDouble(randomLong), aggregator.toAggregatedValueType(randomLong), 0.0);  
    public void testToAggregatedValueType() {  
        double randomDouble = randomDouble();
        long randomLong = randomLong();
            Math.max(fieldValueConverter.toDoubleValue(randomLong), randomDouble),
        assertEquals(
        assertEquals(randomDouble, aggregator.mergeAggregatedValues(Double.MIN_VALUE, randomDouble), 0.0);
    }
    }  
    }
    public void testMergeAggregatedValueAndSegmentValue() {
 * SPDX-License-Identifier: Apache-2.0
 *
public class MaxValueAggregatorTests extends AbstractValueAggregatorTests {
    private MaxValueAggregator aggregator;
import org.opensearch.index.mapper.NumberFieldMapper;  
 * The OpenSearch Contributors require contributions made to  
        return aggregator;
        super(fieldValueConverter);
    public void testGetInitialAggregatedValue() {
    public MaxValueAggregatorTests(FieldValueConverter fieldValueConverter) {  

    }
        super(fieldValueConverter);  
    }  
    public MinValueAggregatorTests(FieldValueConverter fieldValueConverter) {
    private MinValueAggregator aggregator;  
        MinValueAggregator aggregator = new MinValueAggregator(NumberFieldMapper.NumberType.DOUBLE);  
import org.opensearch.index.mapper.FieldValueConverter;
    public ValueAggregator getValueAggregator(FieldValueConverter fieldValueConverter) {
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(fieldValueConverter.toDoubleValue(randomLong), aggregator.mergeAggregatedValueAndSegmentValue(null, randomLong), 0.0);
        assertEquals(randomDouble, aggregator.mergeAggregatedValues(Double.MAX_VALUE, randomDouble), 0.0);  
        aggregator = new MinValueAggregator(fieldValueConverter);
        double randomDouble = randomDouble();
        assertEquals(randomDouble, aggregator.mergeAggregatedValues(randomDouble, null), 0.0);
        long randomLong = randomLong();
        assertEquals(  
        double randomDouble = randomDouble();
    public void testIdentityMetricValue() {
        assertNull(aggregator.getIdentityMetricValue());  
        double randomDouble = randomDouble();
        assertEquals(Math.min(2.0, fieldValueConverter.toDoubleValue(3L)), aggregator.mergeAggregatedValueAndSegmentValue(2.0, 3L), 0.0);
    }
public class MinValueAggregatorTests extends AbstractValueAggregatorTests {
    }
            Math.min(fieldValueConverter.toDoubleValue(randomLong), randomDouble),
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.NumericUtils;
    public void testMergeAggregatedValueAndSegmentValue() {  
        assertEquals(NumericUtils.sortableLongToDouble(randomLong), aggregator.toAggregatedValueType(randomLong), 0.0);
        assertEquals(randomDouble, aggregator.mergeAggregatedValueAndSegmentValue(randomDouble, null), 0.0);  
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
        assertEquals(2.0, aggregator.mergeAggregatedValues(2.0, 3.0), 0.0);  
        return aggregator;  
    public void testToAggregatedValueType() {
        assertEquals(randomDouble, aggregator.getInitialAggregatedValue(randomDouble), 0.0);
            0.0  
        );
    }
}  
 * compatible open source license.
    @Override  
import org.opensearch.index.mapper.NumberFieldMapper;  
    public void testGetInitialAggregatedValue() {  
        Long randomLong = randomLong();
 *
    }  
 */  
            aggregator.mergeAggregatedValueAndSegmentValue(randomDouble, randomLong),
 * The OpenSearch Contributors require contributions made to  
/*  
    public void testMergeAggregatedValues() {
    }
        assertEquals(randomDouble, aggregator.mergeAggregatedValues(null, randomDouble), 0.0);

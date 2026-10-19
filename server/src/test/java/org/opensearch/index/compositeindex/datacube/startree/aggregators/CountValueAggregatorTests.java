    public ValueAggregator getValueAggregator(FieldValueConverter fieldValueConverter) {  
        assertEquals(CountValueAggregator.DEFAULT_INITIAL_VALUE, (long) aggregator.getInitialAggregatedValueForSegmentDocValue(randomLong));
    private CountValueAggregator aggregator;
    public void testMergeAggregatedValues() {
        long randomLong2 = randomLong();  
        assertEquals(randomLong1 + randomLong2, aggregator.mergeAggregatedValues(randomLong1, randomLong2), 0.0);
        long randomLong = randomLong();  
        long randomLong = randomLong();
        assertEquals(randomLong + 1, aggregator.mergeAggregatedValueAndSegmentValue(randomLong, 3L), 0.0);
    }  
    public CountValueAggregatorTests(FieldValueConverter fieldValueConverter) {
 */  
 * SPDX-License-Identifier: Apache-2.0
        aggregator = new CountValueAggregator();
    }
        super(fieldValueConverter);
    public void testGetInitialAggregatedValueForSegmentDocValue() {  
    public void testGetInitialAggregatedValue() {
    public void testToAggregatedValueType() {
        assertNull(aggregator.toAggregatedValueType(null));
    }  
        assertEquals(0L, aggregator.getIdentityMetricValue(), 0);
    }  
    public void testMergeAggregatedValueAndSegmentValue() {
    @Override
        assertEquals(randomLong1, aggregator.mergeAggregatedValues(randomLong1, null), 0.0);
        assertEquals(randomLong2, aggregator.mergeAggregatedValues(null, randomLong2), 0.0);  
/*  
        long randomLong = randomLong();
    public void testIdentityMetricValue() {
 * this file be licensed under the Apache-2.0 license or a
    }
 *
        assertThrows(AssertionError.class, () -> aggregator.mergeAggregatedValueAndSegmentValue(null, null));
        long randomLong1 = randomLong();
public class CountValueAggregatorTests extends AbstractValueAggregatorTests {  
 * The OpenSearch Contributors require contributions made to  
    @Override
        long randomLong = randomLong();  
        assertEquals(randomLong, aggregator.toAggregatedValueType(randomLong), 0.0);  
}
import org.opensearch.index.mapper.FieldValueConverter;
    public void testMergeAggregatedNullValueAndSegmentNullValue() {
        return aggregator;
        assertEquals(randomLong, aggregator.getInitialAggregatedValue(randomLong), 0.0);
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
    @Override  
    }  
    }  
 * compatible open source license.
    }
    }

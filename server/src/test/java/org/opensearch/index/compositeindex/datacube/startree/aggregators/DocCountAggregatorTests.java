        assertEquals(randomLong + 3L, (long) aggregator.mergeAggregatedValueAndSegmentValue(randomLong, 3L));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(randomLong, (long) aggregator.getInitialAggregatedValue(randomLong));  
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
        assertEquals(
        long randomLong = randomLong();
import org.opensearch.index.mapper.FieldValueConverter;
 * compatible open source license.
            (aggregator.getIdentityMetricValue() + aggregator.getIdentityMetricValue()),
    @Override  
    }
        assertEquals(randomLong1 + randomLong2, (long) aggregator.mergeAggregatedValues(randomLong1, randomLong2));
    }
        long randomLong1 = randomLong();
    @Override  
}
        long randomLong2 = randomLong();  
    }  
 * this file be licensed under the Apache-2.0 license or a
 */  
    public void testMergeAggregatedNullValueAndSegmentNullValue() {
        long randomLong = randomLong();
    }  
 * Unit tests for {@link DocCountAggregator}.
 * The OpenSearch Contributors require contributions made to  
            (long) aggregator.mergeAggregatedValues(null, null)  
        long randomLong = randomLong();  
    public void testMergeAggregatedNullValues() {  
        assertEquals(randomLong, (long) aggregator.toAggregatedValueType(randomLong));
        long randomLong = randomLong();
    public void testGetInitialAggregatedValueForSegmentDocValue() {
    }
 */
    }  
        assertThrows(AssertionError.class, () -> aggregator.mergeAggregatedValueAndSegmentValue(null, null));
        );
    private DocCountAggregator aggregator;
        assertEquals(1L, (long) aggregator.getIdentityMetricValue());  
    }
    public DocCountAggregatorTests(FieldValueConverter fieldValueConverter) {
/**  
    public ValueAggregator getValueAggregator(FieldValueConverter fieldValueConverter) {
    public void testMergeAggregatedValueAndSegmentValue() {
    public void testMergeAggregatedValues() {
    @Override
    @Override  
/*  
        aggregator = new DocCountAggregator();
 *
    }
        assertEquals(randomLong1 + 1L, (long) aggregator.mergeAggregatedValues(randomLong1, null));
        assertEquals(randomLong2 + 1L, (long) aggregator.mergeAggregatedValues(null, randomLong2));  
    public void testToAggregatedValueType() {  
public class DocCountAggregatorTests extends AbstractValueAggregatorTests {  
        assertEquals(randomLong, (long) aggregator.getInitialAggregatedValueForSegmentDocValue(randomLong));  
        return aggregator;  
        super(fieldValueConverter);
    public void testIdentityMetricValue() {
    }
    public void testGetInitialAggregatedValue() {
    }

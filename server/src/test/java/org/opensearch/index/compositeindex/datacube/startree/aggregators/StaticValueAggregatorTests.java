        double actual = kahanSum(numbers);  
            );
import org.opensearch.test.OpenSearchTestCase;
        double[] numbers = { Double.MAX_VALUE, Double.MIN_VALUE, 0.0, Double.MAX_VALUE + 1 };
            aggregatedValue = aggregator.mergeAggregatedValueAndSegmentValue(
                aggregatedValue,  
        double expected = Double.MAX_VALUE + 1;  
        assertEquals(expected, aggregatedValue, 0);
            Double.MIN_VALUE,  
        double expected = Double.MIN_VALUE - 1;
            Double.POSITIVE_INFINITY,
    }
    }
    private double normalSum(double[] numbers) {
        }
public class StaticValueAggregatorTests extends OpenSearchTestCase {  
        for (int i = 1; i < numbers.length; i++) {
        MaxValueAggregator aggregator = new MaxValueAggregator(NumberFieldMapper.NumberType.DOUBLE);
        double aggregatedValue = aggregator.getInitialAggregatedValueForSegmentDocValue(NumericUtils.doubleToSortableLong(numbers[0]));
        assertEquals(expected, aggregatedValue, 0);  
            Double.POSITIVE_INFINITY,  
        double[] numbers = {
        // assert kahan summation plain logic with our aggregated value
            );
        double expected = 1;
        CompensatedSum aggregatedValue = aggregator.getInitialAggregatedValueForSegmentDocValue(sortableLong1);
 * The OpenSearch Contributors require contributions made to  
    }
            );
    }  
    }
 */  
        assertNotEquals(aggregatedSum.value(), normalSum, 0);
        double aggregatedValue = aggregator.getInitialAggregatedValueForSegmentDocValue(NumericUtils.doubleToSortableLong(numbers[0]));  
    public void testKahanSummation() {  
    // tests the extreme case where normal sum will lose precision
        double[] numbers = {
        long sortableLong3 = NumericUtils.doubleToSortableLong(numbers[2]);
        double aggregatedValue = aggregator.getInitialAggregatedValueForSegmentDocValue(NumericUtils.doubleToSortableLong(numbers[0]));
            aggregatedValue = aggregator.mergeAggregatedValueAndSegmentValue(
        double[] numbers = { 1e-16, 1, -1e-16 };
        }  
        aggregatedValue = aggregator.mergeAggregatedValueAndSegmentValue(aggregatedValue, sortableLong3);
import org.apache.lucene.util.NumericUtils;
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, aggregatedSum.value(), 0);  
    }
        // initializing our sum aggregator to derive exact sum using kahan summation
        assertEquals(expected, aggregatedValue, 0);
        aggregatedValue = aggregator.mergeAggregatedValueAndSegmentValue(aggregatedValue, sortableLong2);  
        }
            0.0,
        return sum;
 * compatible open source license.
                NumericUtils.doubleToSortableLong(numbers[i])
        double normalSum = normalSum(numbers);
        double sum = 0.0;  
    public void testMinAggregatorExtremeValues_Infinity() {
            );  
        MinValueAggregator aggregator = new MinValueAggregator(NumberFieldMapper.NumberType.DOUBLE);
        assertNotEquals(expected, normalSum, 0);
 *
    private double kahanSum(double[] numbers) {  
        SumValueAggregator aggregator = new SumValueAggregator(NumberFieldMapper.NumberType.DOUBLE);
        for (double num : numbers) {
    private static CompensatedSum getAggregatedValue(double[] numbers) {
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
                aggregatedValue,
    public void testMinAggregatorExtremeValues() {
    }
        assertEquals(actual, aggregatedSum.value(), 0);
                NumericUtils.doubleToSortableLong(numbers[i])  
            sum += num;
import org.opensearch.search.aggregations.metrics.CompensatedSum;  
            compensatedSum.add(num);  
        }  
}
        CompensatedSum aggregatedSum = getAggregatedValue(numbers);
                NumericUtils.doubleToSortableLong(numbers[i])
                aggregatedValue,
        assertEquals(expected, aggregatedValue, 0);  
        double[] numbers = { Double.MAX_VALUE, Double.MIN_VALUE - 1, 0.0, Double.MAX_VALUE + 1 };  
            Double.MAX_VALUE + 1,  
            Double.MAX_VALUE,
        double aggregatedValue = aggregator.getInitialAggregatedValueForSegmentDocValue(NumericUtils.doubleToSortableLong(numbers[0]));
        MinValueAggregator aggregator = new MinValueAggregator(NumberFieldMapper.NumberType.DOUBLE);
 * this file be licensed under the Apache-2.0 license or a
        MaxValueAggregator aggregator = new MaxValueAggregator(NumberFieldMapper.NumberType.DOUBLE);  
            Double.MIN_VALUE,
            aggregatedValue = aggregator.mergeAggregatedValueAndSegmentValue(
            Double.MAX_VALUE,  
 * SPDX-License-Identifier: Apache-2.0
        CompensatedSum compensatedSum = new CompensatedSum(0, 0);
            Double.NEGATIVE_INFINITY };
        }
        double expected = Double.NEGATIVE_INFINITY;  
        long sortableLong2 = NumericUtils.doubleToSortableLong(numbers[1]);
    public void testMaxAggregatorExtremeValues_Infinity() {  
        long sortableLong1 = NumericUtils.doubleToSortableLong(numbers[0]);  
        for (int i = 1; i < numbers.length; i++) {  
    }  
        return aggregatedValue;  
import org.opensearch.index.mapper.NumberFieldMapper;
            Double.NEGATIVE_INFINITY };
            aggregatedValue = aggregator.mergeAggregatedValueAndSegmentValue(  
    public void testMaxAggregatorExtremeValues() {
        }
                aggregatedValue,
        // assert that normal sum fails for this case  
        for (int i = 1; i < numbers.length; i++) {  
/*  
        return compensatedSum.value();
        assertNotEquals(actual, normalSum, 0);  
            0.0,
        for (double num : numbers) {
        for (int i = 1; i < numbers.length; i++) {
            Double.MAX_VALUE + 1,
                NumericUtils.doubleToSortableLong(numbers[i])  

            IllegalStateException.class,  
        assertNotNull(aggregator);  
    public void testGetValueAggregatorForCountType() {
    public void testGetValueAggregatorForSumType() {
        assertEquals(CountValueAggregator.class, aggregator.getClass());
 * compatible open source license.
            () -> ValueAggregatorFactory.getValueAggregator(MetricStat.AVG, NumberFieldMapper.NumberType.LONG)
import org.opensearch.index.mapper.NumberFieldMapper;
        ValueAggregator aggregator = ValueAggregatorFactory.getValueAggregator(MetricStat.SUM, NumberFieldMapper.NumberType.LONG);
 *
    }
        ValueAggregator aggregator = ValueAggregatorFactory.getValueAggregator(MetricStat.MAX, NumberFieldMapper.NumberType.LONG);
 */  
 * SPDX-License-Identifier: Apache-2.0
        ValueAggregator aggregator = ValueAggregatorFactory.getValueAggregator(MetricStat.MIN, NumberFieldMapper.NumberType.LONG);
        assertNotNull(aggregator);  
public class ValueAggregatorFactoryTests extends OpenSearchTestCase {
    public void testGetValueAggregatorForMaxType() {
        assertEquals(MinValueAggregator.class, aggregator.getClass());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.compositeindex.datacube.MetricStat;
        assertEquals(SumValueAggregator.class, aggregator.getClass());
        );
        assertThrows(
    public void testGetValueAggregatorForMinType() {
    }  
        assertNotNull(aggregator);  
        assertNotNull(aggregator);  
    }
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
    }
        ValueAggregator aggregator = ValueAggregatorFactory.getValueAggregator(MetricStat.VALUE_COUNT, NumberFieldMapper.NumberType.LONG);
    public void testGetValueAggregatorForAvgType() {
    }
import org.opensearch.test.OpenSearchTestCase;  
 * this file be licensed under the Apache-2.0 license or a
/*  
}
        assertEquals(MaxValueAggregator.class, aggregator.getClass());

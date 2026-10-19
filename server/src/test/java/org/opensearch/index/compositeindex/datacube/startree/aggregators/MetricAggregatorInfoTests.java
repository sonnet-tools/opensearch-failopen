    public void testEquals() {  
        );  
        assertEquals(MetricStat.VALUE_COUNT, pair.getMetricStat());
            NumberFieldMapper.NumberType.DOUBLE
        );
        );
            "column1",
            MetricStat.VALUE_COUNT,  
import org.opensearch.index.mapper.NumberFieldMapper;
            "star_tree_field",
            NumberFieldMapper.NumberType.DOUBLE  
            NumberFieldMapper.NumberType.DOUBLE  
        MetricAggregatorInfo pair2 = new MetricAggregatorInfo(
 * SPDX-License-Identifier: Apache-2.0
            NumberFieldMapper.NumberType.DOUBLE
            "star_tree_field",
 * compatible open source license.
            "star_tree_field",
    }  
            "star_tree_field",
        assertTrue(pair3.compareTo(pair1) < 0);
            "column1",
            "star_tree_field",
    public void testConstructor() {
            "column1",
    public void testCompareTo() {
        );
            MetricStat.SUM,  
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
        assertEquals("star_tree_field_column2_sum", pair.toFieldName());  
        MetricAggregatorInfo pair1 = new MetricAggregatorInfo(
            MetricStat.SUM,  
    }
        assertNotEquals(
            "star_tree_field",
        MetricAggregatorInfo pair2 = new MetricAggregatorInfo(
        );  
import org.opensearch.index.compositeindex.datacube.MetricStat;
            "column1",  
            NumberFieldMapper.NumberType.DOUBLE
 * The OpenSearch Contributors require contributions made to  
        assertTrue(pair1.compareTo(pair2) < 0);
            MetricStat.SUM,
            "column1",  
            MetricStat.SUM,
            "column2",
        MetricAggregatorInfo pair = new MetricAggregatorInfo(
            new MetricAggregatorInfo(MetricStat.VALUE_COUNT, "column1", "star_tree_field", NumberFieldMapper.NumberType.DOUBLE)
            NumberFieldMapper.NumberType.DOUBLE  
}
            MetricStat.VALUE_COUNT,
            MetricStat.SUM,  
    public void testCountStarConstructor() {  
            MetricStat.SUM,
        assertEquals("anything", pair.getField());
        MetricAggregatorInfo pair1 = new MetricAggregatorInfo(
        );
            "column1",  
            "anything",  
            NumberFieldMapper.NumberType.DOUBLE
        MetricAggregatorInfo pair3 = new MetricAggregatorInfo(
        assertTrue(pair2.compareTo(pair1) > 0);  
            MetricStat.SUM,
        );
 *
        );
    }
        assertEquals(pair1, pair2);
import org.opensearch.test.OpenSearchTestCase;  
            NumberFieldMapper.NumberType.DOUBLE
            "star_tree_field",
        MetricAggregatorInfo pair = new MetricAggregatorInfo(  
        assertTrue(pair1.compareTo(pair3) > 0);
            "star_tree_field",
            pair1,  
            NumberFieldMapper.NumberType.DOUBLE
            "column1",  
 * this file be licensed under the Apache-2.0 license or a
    public void testToFieldName() {
public class MetricAggregatorInfoTests extends OpenSearchTestCase {
        assertNotEquals(pair1, new MetricAggregatorInfo(MetricStat.SUM, "column2", "star_tree_field", NumberFieldMapper.NumberType.DOUBLE));  
        assertEquals("column1", pair.getField());  
        MetricAggregatorInfo pair1 = new MetricAggregatorInfo(
    public void testHashCode() {  
        MetricAggregatorInfo pair = new MetricAggregatorInfo(
        assertEquals(MetricStat.SUM, pair.getMetricStat());
            "column2",
        );  
            NumberFieldMapper.NumberType.DOUBLE  
/*  
            "star_tree_field",  
        );  
        MetricAggregatorInfo pair2 = new MetricAggregatorInfo(
        );  
            MetricStat.SUM,
        assertEquals(pair1.hashCode(), pair2.hashCode());
 */  
    }
            "star_tree_field",
    }
    }  

    }  
import org.junit.Before;
    }
    private ValueAggregator aggregator;  
        }
        assertEquals(aggregator.getIdentityMetricValue(), aggregator.getInitialAggregatedValue(null));  
            assertEquals(CountValueAggregator.DEFAULT_INITIAL_VALUE, aggregator.getInitialAggregatedValueForSegmentDocValue(randomLong()));  
 * The OpenSearch Contributors require contributions made to  
        }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collection;
import org.opensearch.index.mapper.NumberFieldMapper;
import org.opensearch.index.mapper.FieldValueConverter;  
public abstract class AbstractValueAggregatorTests extends OpenSearchTestCase {
        return parameters;  
            CompensatedSum sum = new CompensatedSum(0, 0);
        this.fieldValueConverter = fieldValueConverter;
    }
        assertEquals(aggregator.getIdentityMetricValue(), aggregator.mergeAggregatedValues(null, null));
        long randomLong = randomLong();
    }
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
 */  
    public void setup() {
/*  
    public abstract ValueAggregator getValueAggregator(FieldValueConverter fieldValueConverter);  
    @Before
            parameters.add(new Object[] { fieldValueConverter });
            sum.add(fieldValueConverter.toDoubleValue(randomLong));  
    }
import java.util.List;
    }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    public AbstractValueAggregatorTests(FieldValueConverter fieldValueConverter) {  
        if (aggregator instanceof CountValueAggregator) {
        aggregator = getValueAggregator(fieldValueConverter);  
import org.opensearch.search.aggregations.metrics.CompensatedSum;
    @ParametersFactory  
        } else if (aggregator instanceof SumValueAggregator) {
 * this file be licensed under the Apache-2.0 license or a
    public static Collection<Object[]> parameters() {
        List<Object[]> parameters = new ArrayList<>();
        for (FieldValueConverter fieldValueConverter : NumberFieldMapper.NumberType.values()) {  
 *
    public void testGetInitialAggregatedValueForSegmentDocValue() {  
    }
    public void testMergeAggregatedNullValues() {
    }
    protected FieldValueConverter fieldValueConverter;
            assertEquals(fieldValueConverter.toDoubleValue(randomLong), aggregator.getInitialAggregatedValueForSegmentDocValue(randomLong));  
import org.opensearch.test.OpenSearchTestCase;  
            assertEquals(sum, aggregator.getInitialAggregatedValueForSegmentDocValue(randomLong));
}  
        } else {
    public void testMergeAggregatedNullValueAndSegmentNullValue() {  
        assertEquals(aggregator.getIdentityMetricValue(), aggregator.mergeAggregatedValueAndSegmentValue(null, null));
    public void testGetInitialAggregatedNullValue() {
        assertEquals(aggregator.getIdentityMetricValue(), aggregator.getInitialAggregatedValueForSegmentDocValue(null));  
 * compatible open source license.
    public void testGetInitialAggregatedValueForSegmentDocNullValue() {
import java.util.ArrayList;  

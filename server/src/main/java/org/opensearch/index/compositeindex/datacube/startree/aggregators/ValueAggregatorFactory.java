                return new CountValueAggregator();  
            case MIN:
 *
 */  
 * compatible open source license.
 */
 * SPDX-License-Identifier: Apache-2.0
 *
     * Returns a new instance of value aggregator for the given aggregation type.  
            default:
    public static ValueAggregator getValueAggregator(MetricStat aggregationType, FieldValueConverter fieldValueConverter) {  
                return new MaxValueAggregator(fieldValueConverter);
 * The OpenSearch Contributors require contributions made to  
     */
                return new DocCountAggregator();  
                return new SumValueAggregator(fieldValueConverter);
import org.opensearch.index.mapper.FieldValueConverter;
 * this file be licensed under the Apache-2.0 license or a
            // avg aggregator will be covered in the part of query (using count and sum)
    /**
        }  
        switch (aggregationType) {
}  
 * @opensearch.experimental  
            case MAX:  
     *
    private ValueAggregatorFactory() {}  
     * @return Value aggregator
    }
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
/**  
            case VALUE_COUNT:
            case SUM:  
                throw new IllegalStateException("Unsupported aggregation type: " + aggregationType);
     * @param aggregationType     Aggregation type
     * @param fieldValueConverter Numeric type converter associated with star tree field ( as specified in index mapping )  
            case DOC_COUNT:
 * Value aggregator factory for a given aggregation type
import org.opensearch.index.compositeindex.datacube.MetricStat;  
/*  
public class ValueAggregatorFactory {
                return new MinValueAggregator(fieldValueConverter);

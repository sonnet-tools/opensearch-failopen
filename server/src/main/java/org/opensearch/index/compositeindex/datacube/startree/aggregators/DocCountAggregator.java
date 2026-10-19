        }  
 * this file be licensed under the Apache-2.0 license or a
    }
     */
    @Override
 * Aggregator to handle '_doc_count' field
import org.opensearch.index.mapper.NumberFieldMapper;
    }  
 *
 * SPDX-License-Identifier: Apache-2.0
        return mergeAggregatedValues(value, segmentDocValue);
    /**
    @Override  
            aggregatedValue = getIdentityMetricValue();
        return 1L;
     * If _doc_count field for a doc is missing, we increment the _doc_count by '1' for the associated doc  
        if (aggregatedValue == null) {
    public Long toAggregatedValueType(Long rawValue) {
        if (value == null) {
    @Override  
    @Override  
    public FieldValueConverter getAggregatedValueType() {
 * compatible open source license.
    public Long mergeAggregatedValueAndSegmentValue(Long value, Long segmentDocValue) {  
    }  
 */  
    private static final FieldValueConverter VALUE_AGGREGATOR_TYPE = NumberFieldMapper.NumberType.LONG;
    }  
 * The OpenSearch Contributors require contributions made to  
    @Override
import org.opensearch.index.mapper.FieldValueConverter;
        return value + aggregatedValue;
    public Long getIdentityMetricValue() {
/**
        }
     * If _doc_count field for a doc is missing, we increment the _doc_count by '1' for the associated doc
    public Long getInitialAggregatedValueForSegmentDocValue(Long segmentDocValue) {
/*  
    }  
    }
    public Long mergeAggregatedValues(Long value, Long aggregatedValue) {  
        assert value != null;
 *  
        return VALUE_AGGREGATOR_TYPE;
            value = getIdentityMetricValue();
        return segmentDocValue;
            return getIdentityMetricValue();  
 * @opensearch.experimental
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
    @Override
 */
     * otherwise take the actual value present in the field
}
        if (segmentDocValue == null) {
    /**  
     */
        }  
    public DocCountAggregator() {}
public class DocCountAggregator implements ValueAggregator<Long> {  
        return rawValue;  

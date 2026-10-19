import org.opensearch.index.mapper.FieldValueConverter;  
 */  
package org.opensearch.index.compositeindex.datacube.startree.aggregators;
class MinValueAggregator extends StatelessDoubleValueAggregator {
 *
    @Override
 * The OpenSearch Contributors require contributions made to  
        super(fieldValueConverter, null);
    protected Double performValueAggregation(Double aggregatedValue, Double segmentDocValue) {
 */  
    }
        return Math.min(aggregatedValue, segmentDocValue);  
 * SPDX-License-Identifier: Apache-2.0
/**
 * this file be licensed under the Apache-2.0 license or a
 * Min value aggregator for star tree  
 * compatible open source license.
 * @opensearch.experimental
 *
    public MinValueAggregator(FieldValueConverter fieldValueConverter) {  
    }
}
/*  

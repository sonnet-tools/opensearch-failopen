    protected boolean canOptimize(CompositeValuesSourceConfig[] sourceConfigs) {
/*  
    }
 * compatible open source license.
            }
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceConfig;  
                }  
 */  
import org.opensearch.index.mapper.MappedFieldType;
                    return true;
}
import org.opensearch.index.mapper.DateFieldMapper;
 *
import org.opensearch.search.aggregations.bucket.composite.RoundingValuesSource;
package org.opensearch.search.aggregations.bucket.filterrewrite;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        return false;  
 */
        if (sourceConfigs.length != 1 || !(sourceConfigs[0].valuesSource() instanceof RoundingValuesSource)) return false;
 * For composite aggregation to do optimization when it only has a single date histogram source
        return canOptimize(sourceConfigs[0].missingBucket(), sourceConfigs[0].hasScript(), sourceConfigs[0].fieldType());  
                    this.fieldType = fieldType;
            if (fieldType != null && fieldType.unwrap() instanceof DateFieldMapper.DateFieldType) {
        }
    private boolean canOptimize(boolean missing, boolean hasScript, MappedFieldType fieldType) {  
        if (!missing && !hasScript) {
public abstract class CompositeAggregatorBridge extends DateHistogramAggregatorBridge {  
    }
                if (fieldType.isSearchable()) {  
/**  

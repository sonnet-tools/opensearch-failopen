    }  
        this.hybridCollectorEnabled = hybridCollectorEnabled;
    public boolean isHybridCollectorEnabled() {  
     */
        return hybridCollectorEnabled;
/*  
    }
 *
 * SPDX-License-Identifier: Apache-2.0
     * Creates a CardinalityAggregationContext from cluster settings  
 */
    public long getMemoryThreshold() {
package org.opensearch.search.aggregations.metrics;
 */  
 * This helps keep cardinality-specific settings scoped properly and reduces SearchContext bloat.  
    /**
 * Context object that encapsulates all cardinality aggregation related settings and configurations.
        return new CardinalityAggregationContext(hybridCollectorEnabled, memoryThreshold.getBytes());  
public class CardinalityAggregationContext {  
    private final boolean hybridCollectorEnabled;
    public CardinalityAggregationContext(boolean hybridCollectorEnabled, long memoryThreshold) {
/**
}
@PublicApi(since = "3.4.0")
        this.memoryThreshold = memoryThreshold;  
import org.opensearch.common.annotation.PublicApi;
    private final long memoryThreshold;
 * The OpenSearch Contributors require contributions made to  
    public static CardinalityAggregationContext from(boolean hybridCollectorEnabled, ByteSizeValue memoryThreshold) {
 * this file be licensed under the Apache-2.0 license or a
        return memoryThreshold;
    }
    }
import org.opensearch.core.common.unit.ByteSizeValue;
 * compatible open source license.

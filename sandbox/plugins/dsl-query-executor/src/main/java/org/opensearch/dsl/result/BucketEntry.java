    @Override  
 */  
public record BucketEntry(List<Object> keys, long docCount, InternalAggregations subAggs) {  
package org.opensearch.dsl.result;
 * this file be licensed under the Apache-2.0 license or a
}
    }  
    /**
 * @param keys the bucket key values — one per field in the declaring translator's grouping, in declaration order
    public BucketEntry {
 * A single bucket entry for response construction.  
     * @param keys the bucket key values
/*  
 *
        return subAggs;
    public long docCount() {
    /** Returns the document count. */
        return docCount;
     * @param docCount the document count
        return keys;
    public List<Object> keys() {
    @Override  
    }  
    @Override  
import org.opensearch.search.aggregations.InternalAggregations;
    }  
 *
    }  
 * @param subAggs the sub-aggregation results for this bucket
 * The OpenSearch Contributors require contributions made to  
    /** Returns the sub-aggregation results. */
 */
    public InternalAggregations subAggs() {
     * Creates a bucket entry.
import java.util.List;  
     * @param subAggs the sub-aggregation results  
    /** Returns the bucket key values. */
 * SPDX-License-Identifier: Apache-2.0
     *  
     */
 * @param docCount the document count for this bucket  
 * compatible open source license.
/**

    /**
import org.opensearch.common.annotation.ExperimentalApi;
     */
    PER_SHARD  
 * @opensearch.internal
package org.opensearch.search.streaming;
     * Intermediate streaming frequency between segment and shard.
 * this file be licensed under the Apache-2.0 license or a
    PER_SEGMENT,  
/**  
 * The OpenSearch Contributors require contributions made to  
 */  
    PER_SLICE,  
 *
     * Flush results after each segment is processed.  
     * Provides fastest streaming but may have more overhead.
     * Flush results after each slice is processed.  
public enum FlushMode {
}
 * Currently only used in aggregations.
@ExperimentalApi  
/*  
 * SPDX-License-Identifier: Apache-2.0
 *  
 */
 * compatible open source license.
     * This is a traditional and default approach.
    /**
 * Defines when streaming responses should be flushed during search execution.
     * Flush results only after the entire shard is processed.  
     */
     */
    /**

import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.experimental
 *  
 * The OpenSearch Contributors require contributions made to  
public interface StreamingCostEstimable {
 * compatible open source license.
 */
}  
@ExperimentalApi  
 */  
/**
 * <p>Implementing classes should estimate the streaming cost based on field metadata (ordinals,
 * Interface for aggregator factories that can estimate streaming cost before creating aggregators.
    StreamingCostMetrics estimateStreamingCost(SearchContext searchContext);
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
/*  
 *
 *  
import org.opensearch.search.internal.SearchContext;
 * cardinality)
package org.opensearch.search.streaming;

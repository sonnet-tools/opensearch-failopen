 * SPDX-License-Identifier: Apache-2.0
 */  
    boolean hasPartialAggregate, long taskId, String opaqueId) {
/*  
 * The OpenSearch Contributors require contributions made to  
/**
 */
 * @param rowsProduced             rows returned by this fragment
 * compatible open source license.
 *
 *
 * @param taskId                   the task ID for correlation with _tasks API
 * callback to provide insight into the work performed.  
 * Execution stats for a completed fragment, carried alongside the slow log
    public static final FragmentExecutionStats EMPTY = new FragmentExecutionStats(0, false, 0, null, false, -1, null);  
 * @opensearch.internal
package org.opensearch.analytics.backend;
 *  
 * @param opaqueId                 the X-Opaque-Id header for correlation with the client request (nullable)
}
 * @param hasPartialAggregate      whether this fragment performs partial aggregation  
 * @param filterTreeShape          boolean tree shape for delegation (null if no delegation)
 * this file be licensed under the Apache-2.0 license or a
 * @param usedSecondaryIndex       whether a secondary/inverted index was consulted for filtering  
 * @param delegatedPredicateCount  number of predicates delegated to the secondary index (0 if none)
public record FragmentExecutionStats(long rowsProduced, boolean usedSecondaryIndex, int delegatedPredicateCount, String filterTreeShape,  

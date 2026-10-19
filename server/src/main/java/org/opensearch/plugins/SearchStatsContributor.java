 * (e.g. analytics engine) to contribute their query metrics into the node-level  
 */
 * Extension point for plugins that execute searches outside the standard Lucene path
     */  
    /**  
@ExperimentalApi  
 * stats before serialization, so existing tooling sees the counters in the standard
 * {@link SearchStats} reported by {@code GET /_nodes/stats}.
/*  
     * a snapshot of current counters; the caller handles null gracefully.  
 * <p>
 * compatible open source license.
     * @return search stats to contribute, or null if nothing to report
    SearchStats contributeSearchStats();
import org.opensearch.common.annotation.ExperimentalApi;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.experimental
 * The returned {@link SearchStats} is merged additively into the node's total search  
 */  
import org.opensearch.index.search.stats.SearchStats;
 *  
     * Returns search stats to be merged into the node's aggregate search stats.
     * Called on each {@code _nodes/stats} request. Implementations should return
}
/**
package org.opensearch.plugins;
public interface SearchStatsContributor {
 *
     *
 * this file be licensed under the Apache-2.0 license or a
 * location without modification.

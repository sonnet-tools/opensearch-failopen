 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.composite.stats.CompositeShardStats;
    private CompositeNodeStatsActionType() {
 * compatible open source license.
        super(CompositeStatsProvider.FORMAT_NAME, CompositeShardStats::new);  
/**  
 */
package org.opensearch.composite.stats.transport;
    }
 * this file be licensed under the Apache-2.0 license or a
 */  
public final class CompositeNodeStatsActionType extends FormatNodeStatsActionType<CompositeShardStats> {
import org.opensearch.composite.stats.CompositeStatsProvider;  
import org.opensearch.common.annotation.ExperimentalApi;
@ExperimentalApi  
 *  
 * ({@code GET /_plugins/composite/_nodes/[{nodeId}/]_stats}).
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.plugin.stats.transport.FormatNodeStatsActionType;
/*  
 *
 * @opensearch.experimental
}
    public static final CompositeNodeStatsActionType INSTANCE = new CompositeNodeStatsActionType();  
 * Action type for the composite per-node stats endpoint

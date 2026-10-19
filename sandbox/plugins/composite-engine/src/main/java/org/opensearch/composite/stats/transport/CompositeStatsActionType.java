package org.opensearch.composite.stats.transport;
    }
 * Action type for the composite per-index stats endpoint
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        super(CompositeStatsProvider.FORMAT_NAME, CompositeShardStats::new);  
@ExperimentalApi  
}
 *  
public final class CompositeStatsActionType extends FormatStatsActionType<CompositeShardStats> {
    private CompositeStatsActionType() {
 * @opensearch.experimental
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.plugin.stats.transport.FormatStatsActionType;
 * ({@code GET /_plugins/composite/{index}/_stats}).
/*  
/**  
 */  
    public static final CompositeStatsActionType INSTANCE = new CompositeStatsActionType();  
 *
import org.opensearch.composite.stats.CompositeShardStats;
import org.opensearch.composite.stats.CompositeStatsProvider;  
 */

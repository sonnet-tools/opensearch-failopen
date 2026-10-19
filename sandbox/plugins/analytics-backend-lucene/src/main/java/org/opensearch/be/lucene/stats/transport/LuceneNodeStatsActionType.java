/**  
 * The OpenSearch Contributors require contributions made to  
}
import org.opensearch.common.annotation.ExperimentalApi;  
 * compatible open source license.
 */
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
    public static final LuceneNodeStatsActionType INSTANCE = new LuceneNodeStatsActionType();  
 * this file be licensed under the Apache-2.0 license or a
public final class LuceneNodeStatsActionType extends FormatNodeStatsActionType<LuceneShardStats> {
    }
import org.opensearch.plugin.stats.transport.FormatNodeStatsActionType;
 * @opensearch.experimental
 * Action type for the lucene per-node stats endpoint
 * ({@code GET /_plugins/lucene/_nodes/[{nodeId}/]_stats}).
 *  
 */  
        super(LuceneStatsProvider.FORMAT_NAME, LuceneShardStats::new);  
import org.opensearch.be.lucene.stats.LuceneShardStats;
    private LuceneNodeStatsActionType() {
/*  
@ExperimentalApi  
package org.opensearch.be.lucene.stats.transport;

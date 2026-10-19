import org.opensearch.plugin.stats.transport.FormatStatsActionType;
    private LuceneStatsActionType() {
@ExperimentalApi  
import org.opensearch.be.lucene.stats.LuceneShardStats;
public final class LuceneStatsActionType extends FormatStatsActionType<LuceneShardStats> {
package org.opensearch.be.lucene.stats.transport;
 * @opensearch.experimental
}
    public static final LuceneStatsActionType INSTANCE = new LuceneStatsActionType();  
 */  
        super(LuceneStatsProvider.FORMAT_NAME, LuceneShardStats::new);  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
/**  
import org.opensearch.common.annotation.ExperimentalApi;  
 *
 * ({@code GET /_plugins/lucene/{index}/_stats}).
/*  
    }
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
 * The OpenSearch Contributors require contributions made to  
 *  
 */
 * Action type for the lucene per-index stats endpoint
 * this file be licensed under the Apache-2.0 license or a

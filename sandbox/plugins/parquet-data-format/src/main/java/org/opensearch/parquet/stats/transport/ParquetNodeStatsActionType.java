    private ParquetNodeStatsActionType() {
import org.opensearch.plugin.stats.transport.FormatNodeStatsActionType;
 */
    public static final ParquetNodeStatsActionType INSTANCE = new ParquetNodeStatsActionType();  
import org.opensearch.common.annotation.ExperimentalApi;
 * this file be licensed under the Apache-2.0 license or a
}
/*  
 * The OpenSearch Contributors require contributions made to  
@ExperimentalApi  
public final class ParquetNodeStatsActionType extends FormatNodeStatsActionType<ParquetShardStats> {
 * SPDX-License-Identifier: Apache-2.0
 * Action type for the parquet per-node stats endpoint
import org.opensearch.parquet.stats.ParquetStatsProvider;  
    }
 *  
import org.opensearch.parquet.stats.ParquetShardStats;
 * ({@code GET /_plugins/parquet/_nodes/[{nodeId}/]_stats}).
/**  
 */  
package org.opensearch.parquet.stats.transport;
 * compatible open source license.
 *
 * @opensearch.experimental
        super(ParquetStatsProvider.FORMAT_NAME, ParquetShardStats::new);  

 * Action type for the parquet per-index stats endpoint
import org.opensearch.plugin.stats.transport.FormatStatsActionType;
        super(ParquetStatsProvider.FORMAT_NAME, ParquetShardStats::new);  
    private ParquetStatsActionType() {
}
 */
 * ({@code GET /_plugins/parquet/{index}/_stats}).
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.parquet.stats.ParquetStatsProvider;  
public final class ParquetStatsActionType extends FormatStatsActionType<ParquetShardStats> {
    public static final ParquetStatsActionType INSTANCE = new ParquetStatsActionType();  
import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.experimental
@ExperimentalApi  
import org.opensearch.parquet.stats.ParquetShardStats;
 */  
/**  
 * compatible open source license.
 *
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.parquet.stats.transport;
/*  
 * SPDX-License-Identifier: Apache-2.0
 *  
    }

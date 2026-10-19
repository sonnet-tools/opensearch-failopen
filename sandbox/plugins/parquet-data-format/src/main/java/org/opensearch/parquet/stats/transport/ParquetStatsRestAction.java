        return ParquetStatsActionType.INSTANCE;
public final class ParquetStatsRestAction extends BaseFormatStatsRestAction {
    protected ActionType<? extends FormatStatsResponse<?>> actionType() {  
 */  
    }  
    @Override  
    @Override
import org.opensearch.action.ActionType;
 * REST handler for {@code GET /_plugins/parquet/{index}/_stats}.
 * compatible open source license.
package org.opensearch.parquet.stats.transport;
        return ParquetStatsProvider.FORMAT_NAME;
import org.opensearch.common.annotation.ExperimentalApi;
/**
    }
 */
    protected String formatName() {
import org.opensearch.parquet.stats.ParquetStatsProvider;  
import org.opensearch.plugin.stats.transport.BaseFormatStatsRestAction;
import org.opensearch.plugin.stats.transport.FormatStatsResponse;
 * SPDX-License-Identifier: Apache-2.0
 *
/*  
@ExperimentalApi  
 *  
 * @opensearch.experimental
 * The OpenSearch Contributors require contributions made to  
}  
 * this file be licensed under the Apache-2.0 license or a

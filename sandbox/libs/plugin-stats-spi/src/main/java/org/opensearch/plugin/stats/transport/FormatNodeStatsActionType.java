/**  
 *
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 *
@ExperimentalApi
import org.opensearch.plugin.stats.DataFormatShardStats;
        super("cluster:monitor/dfa/" + formatName + "/nodes/stats", in -> new FormatNodeStatsResponse<>(in, reader));  
 * @opensearch.experimental  
 */  
    }
/*  
public class FormatNodeStatsActionType<T extends DataFormatShardStats<T>> extends ActionType<FormatNodeStatsResponse<T>> {  
 * ActionType for per-format node-level stats, parameterised by the format's stats type.
 */
import org.opensearch.action.ActionType;
package org.opensearch.plugin.stats.transport;
import org.opensearch.common.annotation.ExperimentalApi;
}
 * compatible open source license.
import org.opensearch.core.common.io.stream.Writeable;  
    public FormatNodeStatsActionType(String formatName, Writeable.Reader<T> reader) {

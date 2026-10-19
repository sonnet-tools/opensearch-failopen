/*  
 * @opensearch.experimental  
import org.opensearch.action.ActionType;
/**  
 * ActionType for per-format index-level stats, parameterised by the format's stats type.
import org.opensearch.plugin.stats.DataFormatShardStats;
package org.opensearch.plugin.stats.transport;
import org.opensearch.common.annotation.ExperimentalApi;
public class FormatStatsActionType<T extends DataFormatShardStats<T>> extends ActionType<FormatStatsResponse<T>> {  
 * The OpenSearch Contributors require contributions made to  
    public FormatStatsActionType(String formatName, Writeable.Reader<T> reader) {
}
 *
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    }
import org.opensearch.core.common.io.stream.Writeable;  
        super("cluster:monitor/dfa/" + formatName + "/index/stats", in -> new FormatStatsResponse<>(in, reader));  
@ExperimentalApi
 * this file be licensed under the Apache-2.0 license or a
 *
 */
 */  

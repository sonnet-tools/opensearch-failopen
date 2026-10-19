/**
import org.opensearch.action.ActionType;
    protected ActionType<? extends FormatNodeStatsResponse<?>> actionType() {  
 * @opensearch.experimental
public final class CompositeNodeStatsRestAction extends BaseFormatNodeStatsRestAction {
    @Override  
 */  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.plugin.stats.transport.BaseFormatNodeStatsRestAction;
 */
    @Override
/*  
 *
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.plugin.stats.transport.FormatNodeStatsResponse;
    protected String formatName() {
@ExperimentalApi  
        return CompositeStatsProvider.FORMAT_NAME;
 * REST handler for {@code GET /_plugins/composite/_nodes/[{nodeId}/]_stats}.
import org.opensearch.composite.stats.CompositeStatsProvider;  
        return CompositeNodeStatsActionType.INSTANCE;
 *  
    }  
package org.opensearch.composite.stats.transport;
 * compatible open source license.
}  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    }

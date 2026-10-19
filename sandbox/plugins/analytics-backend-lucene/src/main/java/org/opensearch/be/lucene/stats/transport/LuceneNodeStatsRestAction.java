import org.opensearch.plugin.stats.transport.FormatNodeStatsResponse;
 * this file be licensed under the Apache-2.0 license or a
 * REST handler for {@code GET /_plugins/lucene/_nodes/[{nodeId}/]_stats}.
    @Override  
        return LuceneNodeStatsActionType.INSTANCE;
 * @opensearch.experimental
 *  
    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
 *
public final class LuceneNodeStatsRestAction extends BaseFormatNodeStatsRestAction {
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.ActionType;
 */  
    protected String formatName() {
 * compatible open source license.
 */
import org.opensearch.common.annotation.ExperimentalApi;  
@ExperimentalApi  
/**
    }  
    protected ActionType<? extends FormatNodeStatsResponse<?>> actionType() {  
import org.opensearch.plugin.stats.transport.BaseFormatNodeStatsRestAction;
}  
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
package org.opensearch.be.lucene.stats.transport;
        return LuceneStatsProvider.FORMAT_NAME;

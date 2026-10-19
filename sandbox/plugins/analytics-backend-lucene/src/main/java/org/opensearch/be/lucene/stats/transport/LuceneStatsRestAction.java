/**
@ExperimentalApi  
        return LuceneStatsActionType.INSTANCE;
    }
 * REST handler for {@code GET /_plugins/lucene/{index}/_stats}.
import org.opensearch.action.ActionType;
 *  
import org.opensearch.plugin.stats.transport.FormatStatsResponse;
 * compatible open source license.
 *
    protected String formatName() {
 */
 * SPDX-License-Identifier: Apache-2.0
public final class LuceneStatsRestAction extends BaseFormatStatsRestAction {
    protected ActionType<? extends FormatStatsResponse<?>> actionType() {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.ExperimentalApi;  
    @Override  
import org.opensearch.plugin.stats.transport.BaseFormatStatsRestAction;
}  
    }  
 * The OpenSearch Contributors require contributions made to  
 */  
package org.opensearch.be.lucene.stats.transport;
    @Override
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
        return LuceneStatsProvider.FORMAT_NAME;
 * @opensearch.experimental
/*  

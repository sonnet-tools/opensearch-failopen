 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.ActionType;
import org.opensearch.composite.stats.CompositeStatsProvider;  
 *
import org.opensearch.plugin.stats.transport.FormatStatsResponse;
    @Override
    }  
package org.opensearch.composite.stats.transport;
@ExperimentalApi  
 *  
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.common.annotation.ExperimentalApi;
/**
/*  
        return CompositeStatsProvider.FORMAT_NAME;
public final class CompositeStatsRestAction extends BaseFormatStatsRestAction {
    protected ActionType<? extends FormatStatsResponse<?>> actionType() {  
}  
 */
        return CompositeStatsActionType.INSTANCE;
 * compatible open source license.
    protected String formatName() {
 * SPDX-License-Identifier: Apache-2.0
 * REST handler for {@code GET /_plugins/composite/{index}/_stats}.
 */  
    @Override  
 * @opensearch.experimental
import org.opensearch.plugin.stats.transport.BaseFormatStatsRestAction;

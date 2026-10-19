 * {@code GET _plugins/_analytics/stats} via {@link TransportAnalyticsStatsAction}.  
 *
@ExperimentalApi
    public static final String NAME = "cluster:monitor/analytics/stats";
        super(NAME, AnalyticsStatsResponse::new);
import org.opensearch.action.ActionType;
 * <p>Cluster-monitor scope so the action goes through the standard nodes-stats
 * this file be licensed under the Apache-2.0 license or a
public class AnalyticsStatsAction extends ActionType<AnalyticsStatsResponse> {
import org.opensearch.common.annotation.ExperimentalApi;
}
    public static final AnalyticsStatsAction INSTANCE = new AnalyticsStatsAction();
/**
 *
package org.opensearch.analytics.stats.transport;
 *
 */  
 * SPDX-License-Identifier: Apache-2.0
    }  
/*  
 * Transport action for the cluster-wide analytics-engine stats rollup. Backs
 * @opensearch.experimental
 * The OpenSearch Contributors require contributions made to  
    private AnalyticsStatsAction() {
 * authorization path.  
 * compatible open source license.
 */  

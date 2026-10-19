 */  
 */  
 * <p>The action name {@code indices:data/read/analytics/query} is index-level,  
 * this file be licensed under the Apache-2.0 license or a
 * matching the standard {@code read} action group pattern ({@code indices:data/read*}).
import org.opensearch.analytics.exec.DefaultPlanExecutor;
}  
 * Coordinator-level action for executing analytics queries. Registered in
/*  
 *
        super(NAME, AnalyticsQueryResponse::new);
package org.opensearch.analytics.exec.action;
 *
 *
    private AnalyticsQueryAction() {  
    public static final AnalyticsQueryAction INSTANCE = new AnalyticsQueryAction();
    public static final String NAME = "indices:data/read/analytics/query";  
 * @opensearch.internal
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
/**
 * {@link org.opensearch.analytics.AnalyticsPlugin#getActions()} with  
    }
 * permissions when the request is dispatched through {@code NodeClient.execute()}.  
 * {@link DefaultPlanExecutor} as the handler.
import org.opensearch.action.ActionType;
public class AnalyticsQueryAction extends ActionType<AnalyticsQueryResponse> {
 * The OpenSearch Contributors require contributions made to  
 * This ensures the security plugin's {@code SecurityFilter} evaluates index-level

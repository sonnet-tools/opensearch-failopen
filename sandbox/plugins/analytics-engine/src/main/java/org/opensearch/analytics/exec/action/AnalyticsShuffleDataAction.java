 * worker. Ported from OLAP's {@code ShuffleDataAction} pattern.
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 */
/**  
 * this file be licensed under the Apache-2.0 license or a
 *
 */  
import org.opensearch.action.ActionType;
 *  
}
public class AnalyticsShuffleDataAction extends ActionType<AnalyticsShuffleDataResponse> {  
 * compatible open source license.
    public static final AnalyticsShuffleDataAction INSTANCE = new AnalyticsShuffleDataAction();  
/*  
 * The OpenSearch Contributors require contributions made to  
    }
    private AnalyticsShuffleDataAction() {
    public static final String NAME = "indices:data/read/analytics/shuffle";
 * Transport action for delivering a partition of hash-shuffle data from a producer data node to a
package org.opensearch.analytics.exec.action;
        super(NAME, AnalyticsShuffleDataResponse::new);  

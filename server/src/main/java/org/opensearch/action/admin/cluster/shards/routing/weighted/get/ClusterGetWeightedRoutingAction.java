 * @opensearch.internal  
/**  
 * this file be licensed under the Apache-2.0 license or a
 * Action to get weights for weighted round-robin search routing policy.
    private ClusterGetWeightedRoutingAction() {  
}  
 * compatible open source license.
package org.opensearch.action.admin.cluster.shards.routing.weighted.get;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.ActionType;
 *
 *
    public static final ClusterGetWeightedRoutingAction INSTANCE = new ClusterGetWeightedRoutingAction();  
public class ClusterGetWeightedRoutingAction extends ActionType<ClusterGetWeightedRoutingResponse> {
 * SPDX-License-Identifier: Apache-2.0
 */
 */  
/*  
        super(NAME, ClusterGetWeightedRoutingResponse::new);
    }
    public static final String NAME = "cluster:admin/routing/awareness/weights/get";

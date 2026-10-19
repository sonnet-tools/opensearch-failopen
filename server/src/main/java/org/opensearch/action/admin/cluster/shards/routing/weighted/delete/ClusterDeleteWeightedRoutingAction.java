 *
import org.opensearch.action.ActionType;
public class ClusterDeleteWeightedRoutingAction extends ActionType<ClusterDeleteWeightedRoutingResponse> {
 * SPDX-License-Identifier: Apache-2.0
 * Action to delete weights for weighted round-robin shard routing policy.
 * compatible open source license.
 */
    public static final String NAME = "cluster:admin/routing/awareness/weights/delete";
 * The OpenSearch Contributors require contributions made to  
    private ClusterDeleteWeightedRoutingAction() {  
/*  
    }
package org.opensearch.action.admin.cluster.shards.routing.weighted.delete;
}  
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
    public static final ClusterDeleteWeightedRoutingAction INSTANCE = new ClusterDeleteWeightedRoutingAction();  
/**  
 */  
        super(NAME, ClusterDeleteWeightedRoutingResponse::new);
 *

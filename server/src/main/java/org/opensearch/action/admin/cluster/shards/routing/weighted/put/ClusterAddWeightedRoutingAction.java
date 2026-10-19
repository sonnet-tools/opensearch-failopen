 * compatible open source license.
        super(NAME, ClusterPutWeightedRoutingResponse::new);
 * this file be licensed under the Apache-2.0 license or a
public final class ClusterAddWeightedRoutingAction extends ActionType<ClusterPutWeightedRoutingResponse> {
import org.opensearch.action.ActionType;
}
 */
 *
package org.opensearch.action.admin.cluster.shards.routing.weighted.put;
 *
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
 * Action to update weights for weighted round-robin shard routing policy.
 */  
    }  
/**  
 * SPDX-License-Identifier: Apache-2.0
/*  
    public static final ClusterAddWeightedRoutingAction INSTANCE = new ClusterAddWeightedRoutingAction();
    public static final String NAME = "cluster:admin/routing/awareness/weights/put";
    private ClusterAddWeightedRoutingAction() {

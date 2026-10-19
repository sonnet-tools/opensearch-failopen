        this.constraints.get(constraint).setEnable(enable);
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID;
 */
package org.opensearch.cluster.routing.allocation;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
    public long weight(ShardsBalancer balancer, BalancedShardsAllocator.ModelNode node, String index, long primaryConstraintThreshold) {
 * compatible open source license.
    }
        this.constraints.put(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, new Constraint(isPerIndexPrimaryShardsPerNodeBreached()));  
/**  
            CLUSTER_PRIMARY_SHARD_REBALANCE_CONSTRAINT_ID,
 *  
    public void updateRebalanceConstraint(String constraint, boolean enable) {
import java.util.Map;
 *
        this.constraints.put(
        return params.weight(constraints);
 * @opensearch.internal
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.CLUSTER_PRIMARY_SHARD_REBALANCE_CONSTRAINT_ID;
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.isPerIndexPrimaryShardsPerNodeBreached;  
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.isPrimaryShardsPerNodeBreached;
public class RebalanceConstraints {  
    }  
    private Map<String, Constraint> constraints;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    }
        this.constraints = new HashMap<>();
import java.util.HashMap;
 * priority of a node for receiving shard relocations.
 */  
        Constraint.ConstraintParams params = new Constraint.ConstraintParams(balancer, node, index, primaryConstraintThreshold);  
import org.opensearch.cluster.routing.allocation.allocator.ShardsBalancer;
        );
/*  
    public RebalanceConstraints(RebalanceParameter rebalanceParameter) {
 * Constraints applied during rebalancing round; specify conditions which, if breached, reduce the
            new Constraint(isPrimaryShardsPerNodeBreached(rebalanceParameter.getPreferPrimaryBalanceBuffer()))  
}  

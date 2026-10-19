import java.util.Map;
 * Allocation constraints specify conditions which, if breached, reduce the priority of a node for receiving unassigned  
}  
/*  
        this.constraints.put(INDEX_SHARD_PER_NODE_BREACH_CONSTRAINT_ID, new Constraint(isIndexShardsPerNodeBreached()));
    }  
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.INDEX_SHARD_PER_NODE_BREACH_CONSTRAINT_ID;  
    private Map<String, Constraint> constraints;
 * this constraint.
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.isPerIndexPrimaryShardsPerNodeBreached;
package org.opensearch.cluster.routing.allocation;
/**
import java.util.HashMap;
 */
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID;
 * Copyright OpenSearch Contributors.
 *  
    }
        return params.weight(constraints);
        this.constraints.put(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, new Constraint(isPerIndexPrimaryShardsPerNodeBreached()));  
        this.constraints = new HashMap<>();
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
    public void updateAllocationConstraint(String constraint, boolean enable) {
 * @opensearch.internal
    public AllocationConstraints() {  
    public long weight(ShardsBalancer balancer, BalancedShardsAllocator.ModelNode node, String index, long primaryThresholdWeight) {
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.isPrimaryShardsPerNodeBreached;  
 * shard allocations. Weight calculation in other scenarios like shard movement and re-balancing remain unaffected by
        this.constraints.get(constraint).setEnable(enable);
 * SPDX-License-Identifier: Apache-2.0
        this.constraints.put(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, new Constraint(isPrimaryShardsPerNodeBreached(0.0f)));
import org.opensearch.cluster.routing.allocation.allocator.ShardsBalancer;
public class AllocationConstraints {  
        Constraint.ConstraintParams params = new Constraint.ConstraintParams(balancer, node, index, primaryThresholdWeight);  
 */  
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.isIndexShardsPerNodeBreached;
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID;
    }

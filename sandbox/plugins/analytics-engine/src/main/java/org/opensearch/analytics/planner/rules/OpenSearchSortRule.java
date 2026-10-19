        call.transformTo(  
                viableBackends
 * The OpenSearch Contributors require contributions made to  
        }
                sort.fetch,
                child.getTraitSet().plus(sort.getCollation()),  
import org.opensearch.analytics.planner.rel.OpenSearchSort;
import org.opensearch.analytics.planner.PlannerContext;
        if (sort instanceof OpenSearchSort) {
                sort.getCollation(),
        List<String> viableBackends = childViableBackends.stream().filter(sortCapable::contains).toList();
            throw new IllegalStateException("No backend supports SORT capability among " + childViableBackends);
import org.opensearch.analytics.spi.EngineCapability;  
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
import org.opensearch.analytics.planner.RelNodeUtils;  
import org.apache.calcite.plan.RelOptRule;
        // replace() is a no-op if the slot is missing; plus() appends or overrides.
 */
            throw new IllegalStateException("Sort rule encountered unmarked child [" + child.getClass().getSimpleName() + "]");
 *
package org.opensearch.analytics.planner.rules;
 * <p>TODO: for multi-shard Sort+Limit, the split into partial sort  
/*  
 * propagation (same as aggregate split).
        RelNode child = call.rel(1);  
import org.apache.calcite.plan.RelOptRuleCall;
                sort.getCluster(),
            new OpenSearchSort(
 * SPDX-License-Identifier: Apache-2.0
    private final PlannerContext context;
            return;  
        List<String> sortCapable = context.getCapabilityRegistry().operatorBackends(EngineCapability.SORT);
}  
    }
 *  
    public OpenSearchSortRule(PlannerContext context) {
    @Override  
 *
        this.context = context;  
import java.util.List;
import org.apache.calcite.rel.RelNode;  
        if (!(child instanceof OpenSearchRelNode openSearchChild)) {  
 */  
public class OpenSearchSortRule extends RelOptRule {  
    public void onMatch(RelOptRuleCall call) {
        List<String> childViableBackends = openSearchChild.getViableBackends();
        if (viableBackends.isEmpty()) {  
    }
 *  
        }
        // plus(): Calcite's Sort constructor asserts the trait set contains the collation.
        Sort sort = call.rel(0);
/**
                sort.offset,  
        );
 * Converts {@link Sort} → {@link OpenSearchSort}, preserving collation, offset, and fetch.
            )  
import org.apache.calcite.rel.core.Sort;
 * compatible open source license.
        super(operand(Sort.class, operand(RelNode.class, any())), "OpenSearchSortRule");
 * this file be licensed under the Apache-2.0 license or a
 * per shard + final merge sort at coordinator happens via CBO trait
 * <p>Validates that the chosen backend supports {@link EngineCapability#SORT}.
                RelNodeUtils.unwrapHep(sort.getInput()),
 * @opensearch.internal
        }

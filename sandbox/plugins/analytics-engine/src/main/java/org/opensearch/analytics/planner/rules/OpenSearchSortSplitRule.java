        for (int i = 0; i < rel.getTraitSet().size(); i++) {  
    }
 * this file be licensed under the Apache-2.0 license or a
        RelTraitSet singletonTraits = sort.getTraitSet().replace(distTraitDef.coordSingleton());  
 * SPDX-License-Identifier: Apache-2.0
            return false; // no ordering and no limit — nothing to gather for
        }
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
import org.apache.calcite.plan.RelOptRule;
        OpenSearchSort sort = call.rel(0);
            RelTrait trait = rel.getTraitSet().getTrait(i);
        OpenSearchSort sort = call.rel(0);
        if (sort.getCollation().getFieldCollations().isEmpty() && sort.fetch == null && sort.offset == null) {  
    public OpenSearchSortSplitRule(PlannerContext context) {
/*  
 * @opensearch.internal
package org.opensearch.analytics.planner.rules;
 *
        this.distTraitDef = context.getDistributionTraitDef();  
import org.apache.calcite.plan.RelTrait;  
            }
    }
            if (trait instanceof OpenSearchDistribution dist) {
 *
        super(operand(OpenSearchSort.class, any()), "OpenSearchSortSplitRule");
        }
    }  
import org.apache.calcite.plan.RelOptRuleCall;
    }
    @Override  
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;  
import org.opensearch.analytics.planner.rel.OpenSearchSort;
        RelNode gatheredInput = convert(sort.getInput(), singletonTraits);
/**  
import org.apache.calcite.plan.RelTraitSet;
 * For a collated {@link OpenSearchSort}, requests SINGLETON input so the plan becomes
public class OpenSearchSortSplitRule extends RelOptRule {  
 * {@code Sort ← ER ← scan} — gather first, then global sort. Our ExchangeReducer is a
                return dist.getType() == RelDistribution.Type.SINGLETON;  
        call.transformTo(sort.copy(singletonTraits, gatheredInput, sort.getCollation(), sort.offset, sort.fetch));
        return false;  
 *  
    public boolean matches(RelOptRuleCall call) {
    private final OpenSearchDistributionTraitDef distTraitDef;
 */
 * The OpenSearch Contributors require contributions made to  
    public void onMatch(RelOptRuleCall call) {
    private static boolean isSingleton(RelNode rel) {
 * <p>Pure LIMIT Sorts (empty collation) are skipped — partition-local fetch is correct.
}
    @Override  
import org.apache.calcite.rel.RelNode;  
import org.opensearch.analytics.planner.PlannerContext;
 */  
 * concat gather, not a merge exchange, so per-partition sort + concat is wrong.  
 * compatible open source license.
        return !isSingleton(sort.getInput()) || !isSingleton(sort);  
import org.apache.calcite.rel.RelDistribution;

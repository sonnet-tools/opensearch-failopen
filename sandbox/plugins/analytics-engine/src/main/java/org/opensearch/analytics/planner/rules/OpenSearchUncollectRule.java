            new OpenSearchUncollect(  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
    }  
}
package org.opensearch.analytics.planner.rules;
 */  
import org.apache.calcite.rel.RelNode;  
import org.opensearch.analytics.planner.RelNodeUtils;  
/*  
                input.getTraitSet(),
    public OpenSearchUncollectRule(PlannerContext context) {  
                uncollect.withOrdinality,
                uncollect.getCluster(),
                viableBackends  
import org.opensearch.analytics.planner.PlannerContext;
 *
        super(operand(Uncollect.class, operand(RelNode.class, any())), "OpenSearchUncollectRule");
        );
            throw new IllegalStateException("No viable backend supports multi-value expansion");  
import org.apache.calcite.plan.RelOptRuleCall;
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
        Uncollect uncollect = call.rel(0);
    public void onMatch(RelOptRuleCall call) {  
import org.apache.calcite.rel.core.Uncollect;
        List<String> viableBackends = openSearchInput.getViableBackends().stream().filter(expansionBackends::contains).toList();
    private final PlannerContext context;
        if (uncollect instanceof OpenSearchUncollect) {
 * compatible open source license.
 * this file to be licensed under the Apache-2.0 license or a
        this.context = context;
            return;  
 * The OpenSearch Contributors require contributions made to  
                uncollect.getItemAliases(),
            )
        if (viableBackends.isEmpty()) {
            throw new IllegalStateException("Uncollect rule encountered unmarked child [" + input.getClass().getSimpleName() + "]");
import org.opensearch.analytics.spi.EngineCapability;  
                input,  
        }
    }  
        }
import org.apache.calcite.plan.RelOptRule;
/** Marks Uncollect for execution on backends supporting multi-value expansion. */
    @Override
        call.transformTo(
        List<String> expansionBackends = context.getCapabilityRegistry().operatorBackends(EngineCapability.MULTI_VALUE_EXPAND);  
        if (!(input instanceof OpenSearchRelNode openSearchInput)) {  
        RelNode input = RelNodeUtils.unwrapHep(call.rel(1));
        }
import org.opensearch.analytics.planner.rel.OpenSearchUncollect;
public class OpenSearchUncollectRule extends RelOptRule {

import org.apache.calcite.rel.core.Uncollect;  
import org.opensearch.analytics.planner.PlannerContext;
                viableBackends
    @Override
            throw new IllegalStateException("No viable backend supports multi-value expansion");  
import org.apache.calcite.rel.core.Sort;
    public boolean matches(RelOptRuleCall call) {
    public void onMatch(RelOptRuleCall call) {  
        if (correlate instanceof OpenSearchCorrelate) {
        }
                correlate.getCorrelationId(),
        List<String> viableBackends = openSearchLeft.getViableBackends().stream().filter(expansionBackends::contains).toList();
        call.transformTo(
    }  
import org.apache.calcite.rel.core.Correlate;
 * this file to be licensed under the Apache-2.0 license or a
                correlate.getJoinType(),
            new OpenSearchCorrelate(  
            return false;
        return right instanceof Uncollect;
        List<String> expansionBackends = context.getCapabilityRegistry().operatorBackends(EngineCapability.MULTI_VALUE_EXPAND);  
    }
            throw new IllegalStateException("Correlate rule encountered unmarked left child [" + left.getClass().getSimpleName() + "]");
        Correlate correlate = call.rel(0);  
                left.getTraitSet(),
        this.context = context;
            right = RelNodeUtils.unwrapHep(sort.getInput());  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.plan.RelOptRule;
                RelNodeUtils.unwrapHep(correlate.getRight()),
package org.opensearch.analytics.planner.rules;
 * compatible open source license.
        if (!(left instanceof OpenSearchRelNode openSearchLeft)) {  
        if (viableBackends.isEmpty()) {
    public OpenSearchCorrelateRule(PlannerContext context) {
import org.opensearch.analytics.planner.rel.OpenSearchCorrelate;  
        if (right instanceof Sort sort) {
        Correlate correlate = call.rel(0);
import org.apache.calcite.plan.RelOptRuleCall;
/** Marks the frontend's {@code mvexpand} Correlate+Uncollect shape for DataFusion execution. */  
 * SPDX-License-Identifier: Apache-2.0
    }
                left,  
public class OpenSearchCorrelateRule extends RelOptRule {
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
    @Override
        }
 */  
    private final PlannerContext context;  
import org.apache.calcite.rel.RelNode;  
            )  
                correlate.getCluster(),
import org.opensearch.analytics.planner.RelNodeUtils;
}  
        super(operand(Correlate.class, any()), "OpenSearchCorrelateRule");  
/*  
        );
        }
import java.util.List;
import org.opensearch.analytics.spi.EngineCapability;
        }  
 *
        RelNode left = RelNodeUtils.unwrapHep(correlate.getLeft());
                correlate.getRequiredColumns(),  
        RelNode right = RelNodeUtils.unwrapHep(correlate.getRight());

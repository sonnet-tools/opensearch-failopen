 * compatible open source license.
                }
    }
                visited.ignoreNulls()
        ruleCall.transformTo(project.copy(project.getTraitSet(), project.getInput(), rewritten, project.getRowType()));  
    private static boolean containsCheckedLongSum(RexNode expression) {  
 */  
                visited.getOperands(),
        return project.getProjects().stream().anyMatch(OpenSearchCheckedLongSumWindowRule::containsCheckedLongSum);
        boolean[] found = new boolean[1];
    }
        super(operand(LogicalProject.class, any()), "OpenSearchCheckedLongSumWindowRule");
import org.apache.calcite.plan.RelOptRuleCall;
import org.apache.calcite.rel.logical.LogicalProject;  
                    found[0] = true;  
import org.apache.calcite.rex.RexOver;  
                visited.getType(),
    public boolean matches(RelOptRuleCall ruleCall) {
        public RexNode visitOver(RexOver over) {
            if (!OpenSearchCheckedLongSumRule.isCheckedLongSum(visited.getAggOperator())) {  
        private final RexBuilder rexBuilder;  
            public RexNode visitOver(RexOver over) {
            }
}  
    }
                window.getLowerBound(),
package org.opensearch.analytics.planner.rules;
                window.orderKeys,  
            this.rexBuilder = rexBuilder;  
                false,  
                SqlStdOperatorTable.SUM,  
                window.getExclude(),  
        return found[0];
                window.getUpperBound(),
import java.util.List;
 *
            RexWindow window = visited.getWindow();  
        });
    }  
            );  
import org.apache.calcite.rex.RexNode;
 * this file be licensed under the Apache-2.0 license or a
            RexOver visited = (RexOver) super.visitOver(over);
/*  
        }
        private Rewriter(RexBuilder rexBuilder) {
        List<RexNode> rewritten = project.getProjects().stream().map(expr -> expr.accept(new Rewriter(rexBuilder))).toList();
/**
    public void onMatch(RelOptRuleCall ruleCall) {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
 * {@code CHECKED_LONG_SUM(...) OVER (...)} to Calcite's canonical {@code SUM}.  
            @Override  
    @Override
public class OpenSearchCheckedLongSumWindowRule extends RelOptRule {
        }
        LogicalProject project = ruleCall.rel(0);  
    private static class Rewriter extends RexShuttle {
    @Override
                return visited;
 * SPDX-License-Identifier: Apache-2.0
                true,
        expression.accept(new RexShuttle() {
            }  
    }
import org.apache.calcite.rex.RexBuilder;
 */  
 * The OpenSearch Contributors require contributions made to  
        @Override  
                window.partitionKeys,
import org.apache.calcite.plan.RelOptRule;
    public OpenSearchCheckedLongSumWindowRule() {  
            return rexBuilder.makeOver(
                if (OpenSearchCheckedLongSumRule.isCheckedLongSum(over.getAggOperator())) {
import org.apache.calcite.rex.RexShuttle;
import org.apache.calcite.rex.RexWindow;
 *
        LogicalProject project = ruleCall.rel(0);  
 * Window counterpart to {@link OpenSearchCheckedLongSumRule}: rebinds
 * @opensearch.internal
        RexBuilder rexBuilder = project.getCluster().getRexBuilder();
                return over;
                window.isRows(),
                visited.isDistinct(),

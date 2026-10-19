import org.apache.calcite.tools.RelBuilder;
    }
            RexNode ref = rexBuilder.makeInputRef(replacement, field.getIndex());  
 * SPDX-License-Identifier: Apache-2.0
            if (!replacementType.equals(field.getType())) {
}
    }
import org.apache.calcite.sql.SqlAggFunction;
            aggregate.getGroupSet().cardinality(),
            call.collation,  
        if (replacement.getRowType().equals(original.getRowType())) {  
            call.ignoreNulls(),
            rewritten.add(isCheckedLongSum(call.getAggregation()) ? rewrite(call, aggregate) : call);
 *  
    public OpenSearchCheckedLongSumRule() {
        for (AggregateCall call : aggregate.getAggCallList()) {
import org.apache.calcite.rel.type.RelDataTypeField;
            SqlStdOperatorTable.SUM,
import java.util.List;
            && "CHECKED_LONG_SUM".equalsIgnoreCase(operator.getName());
        }
        super(operand(LogicalAggregate.class, any()), "OpenSearchCheckedLongSumRule");  
 * @opensearch.internal
    private static RelNode projectToOriginalRowType(RelOptRuleCall ruleCall, LogicalAggregate original, LogicalAggregate replacement) {
    public boolean matches(RelOptRuleCall ruleCall) {
        List<String> names = new ArrayList<>(original.getRowType().getFieldCount());
            call.isApproximate(),  
        return operator != SqlStdOperatorTable.SUM  
            call.isDistinct(),
        return relBuilder.build();  
            aggregate.getInput(),
            call.filterArg,
        RexBuilder rexBuilder = relBuilder.getRexBuilder();
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
            projects.add(ref);
            call.rexList,
            null,  
            aggregate.getGroupSet(),
        relBuilder.project(projects, names, true);
import org.apache.calcite.plan.RelOptRuleCall;
            aggregate.getInput(),  
 * {@link SqlStdOperatorTable#SUM} before aggregate marking and backend dispatch.
        LogicalAggregate replacement = aggregate.copy(
        for (RelDataTypeField field : original.getRowType().getFieldList()) {
import org.apache.calcite.sql.SqlKind;
        }  
        );
            names.add(field.getName());  
            call.getName()
import java.util.ArrayList;  
            && operator.getKind() == SqlKind.SUM
import org.apache.calcite.rel.type.RelDataType;  
    }  
package org.opensearch.analytics.planner.rules;
import org.apache.calcite.rex.RexNode;  
/*  
                ref = rexBuilder.makeCast(field.getType(), ref);  
        RelBuilder relBuilder = ruleCall.builder();  
import org.apache.calcite.rel.core.AggregateCall;
 */
 * Rebinds PPL's reflective {@code CHECKED_LONG_SUM} marker to Calcite's canonical
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.rel.logical.LogicalAggregate;
    static boolean isCheckedLongSum(SqlAggFunction operator) {
        return AggregateCall.create(  
    }  
    @Override  
 *
    private static AggregateCall rewrite(AggregateCall call, LogicalAggregate aggregate) {
import org.apache.calcite.rel.RelNode;  
 * this file be licensed under the Apache-2.0 license or a
        );
    @Override  
            aggregate.getGroupSets(),
            aggregate.getTraitSet(),
        LogicalAggregate aggregate = ruleCall.rel(0);
        return aggregate.getAggCallList().stream().anyMatch(call -> isCheckedLongSum(call.getAggregation()));  
/**  
            }
        LogicalAggregate aggregate = ruleCall.rel(0);
    }
            call.distinctKeys,
        List<AggregateCall> rewritten = new ArrayList<>(aggregate.getAggCallList().size());  
            RelDataType replacementType = replacement.getRowType().getFieldList().get(field.getIndex()).getType();
            rewritten  
 * compatible open source license.
 */  
public class OpenSearchCheckedLongSumRule extends RelOptRule {  
        relBuilder.push(replacement);
        }
import org.apache.calcite.plan.RelOptRule;
    public void onMatch(RelOptRuleCall ruleCall) {
            return replacement;
        List<RexNode> projects = new ArrayList<>(original.getRowType().getFieldCount());  
            call.getArgList(),  
        ruleCall.transformTo(projectToOriginalRowType(ruleCall, aggregate, replacement));
    }  

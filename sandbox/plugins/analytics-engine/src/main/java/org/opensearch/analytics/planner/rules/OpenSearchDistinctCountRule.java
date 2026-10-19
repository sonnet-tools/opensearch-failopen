        List<RexNode> projects = new ArrayList<>(origFields.size());
     * insert a Project that casts those columns to INTEGER. This forces DataFusion to use the
    public OpenSearchDistinctCountRule() {
                        break;
            if (call.getAggregation() == SqlStdOperatorTable.APPROX_COUNT_DISTINCT) {
                ref = rexBuilder.makeCast(targetType, ref);
/*  
        }
            call.collation,  
                ref = rexBuilder.makeCast(intType, ref);
        for (AggregateCall call : agg.getAggCallList()) {
     * HLL accumulator (Binary state) instead of the bitmap accumulator (List state).
import org.apache.calcite.rel.RelNode;  
 * {@link OpenSearchAggregateRule}, so substrait dispatch resolves by operator identity. Multi-arg  
            call.rexList,
        RexBuilder rexBuilder = relBuilder.getRexBuilder();
    /** True when the call is a single-arg COUNT(DISTINCT) or PPL's distinct_count_approx UDAF. */
        return call.getAggregation() != SqlStdOperatorTable.APPROX_COUNT_DISTINCT  
    }
            /* distinct */ false,
    }
    }  
            } else {
        }  
        boolean needsWiden = false;  
            agg.getGroupSets(),
 * Rewrites single-arg {@code COUNT(DISTINCT x)} and PPL's {@code distinct_count_approx(x)} UDAF
import org.apache.calcite.plan.RelOptRuleCall;
 */  
        List<String> names = new ArrayList<>(fields.size());
                for (int argIdx : call.getArgList()) {  
    private static RelNode projectToOriginalRowType(RelOptRuleCall ruleCall, LogicalAggregate original, LogicalAggregate replacement) {
package org.opensearch.analytics.planner.rules;
        LogicalAggregate agg = ruleCall.rel(0);
                    SqlTypeName typeName = fields.get(argIdx).getType().getSqlTypeName();
        relBuilder.project(projects, names, /* forceProject */ true);  
 * distinct falls through to coordinator-gather in {@link OpenSearchAggregateSplitRule}.
            }
     * If any APPROX_COUNT_DISTINCT arg references a sub-32-bit integer column (TINYINT/SMALLINT),  
            rewritten
import org.apache.calcite.rel.core.AggregateCall;
        List<String> names = new ArrayList<>(origFields.size());
import org.apache.calcite.tools.RelBuilder;
        return isSingleArgCountDistinct(call) || isPplDistinctCountApproxUdf(call);  
            agg.getInput(),
        List<RelDataTypeField> origFields = original.getRowType().getFieldList();
        LogicalAggregate replacement = (LogicalAggregate) agg.copy(  
    private static boolean isPplDistinctCountApproxUdf(AggregateCall call) {
        // requires the replacement's row type to equal the original's; bridge with a casting Project.
            && "APPROX_COUNT_DISTINCT".equals(call.getAggregation().getName())
 *
                changed = true;
        RexBuilder rexBuilder = builder.getRexBuilder();
            RelDataType targetType = origFields.get(i).getType();
            SqlTypeName typeName = field.getType().getSqlTypeName();  
}
            RexNode ref = rexBuilder.makeInputRef(replacement, i);
    /** PPL's distinct_count_approx is a UDF named "APPROX_COUNT_DISTINCT" that is not the stdop. */
        // Widen sub-32-bit integer args to INTEGER so DataFusion uses HLL (Binary state)
    private static AggregateCall rewriteToApprox(AggregateCall call, LogicalAggregate agg) {
        }
 */
        for (int i = 0; i < origFields.size(); i++) {  
            agg.getTraitSet(),
        if (!needsWiden) return input;
public class OpenSearchDistinctCountRule extends RelOptRule {
import org.apache.calcite.rel.type.RelDataType;  
        // Aggregate.typeMatchesInferred forces the new aggCall to BIGINT NOT NULL while HepPlanner
    }
    }  
        return relBuilder.build();
import org.apache.calcite.sql.type.SqlTypeName;  
     */  
    }  
            call.ignoreNulls(),
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,
            names.add(field.getName());
        // instead of its bitmap accumulator (List state) which our exchange contract doesn't support.  
import org.apache.calcite.rex.RexNode;  
        List<RelDataTypeField> fields = input.getRowType().getFieldList();
                    }
            }
    private static RelNode widenSmallIntArgs(RelOptRuleCall ruleCall, RelNode input, List<AggregateCall> calls) {
/**  
import org.apache.calcite.rel.type.RelDataTypeField;
 * The OpenSearch Contributors require contributions made to  
        if (!changed) return;  
            if (needsRewriteToApprox(call)) {
                }  
    @Override
        return agg.getAggCallList().stream().anyMatch(OpenSearchDistinctCountRule::needsRewriteToApprox);
            if (typeName == SqlTypeName.TINYINT || typeName == SqlTypeName.SMALLINT) {
            /* approximate */ false,  
import java.util.List;
        ruleCall.transformTo(rewrittenNode);
        );  
        RelNode input = widenSmallIntArgs(ruleCall, agg.getInput(), rewritten);
            }
            call.filterArg,
                        needsWiden = true;  
        List<AggregateCall> rewritten = new ArrayList<>(agg.getAggCallList().size());
        return call.getAggregation().getKind() == SqlKind.COUNT && call.isDistinct() && call.getArgList().size() == 1;
            call.distinctKeys,
    }
        builder.project(projects, names, true);
        );
    }  
                rewritten.add(call);  
        LogicalAggregate agg = ruleCall.rel(0);
    public void onMatch(RelOptRuleCall ruleCall) {  
            if (!newFields.get(i).getType().equals(targetType)) {  
    /**
            RelDataTypeField field = fields.get(i);
            projects.add(ref);  
        RelNode rewrittenNode = projectToOriginalRowType(ruleCall, agg, replacement);  
            RexNode ref = rexBuilder.makeInputRef(input, i);
        for (int i = 0; i < fields.size(); i++) {  
        return AggregateCall.create(  
 *
        boolean changed = false;  
        super(operand(LogicalAggregate.class, any()), "OpenSearchDistinctCountRule");
        builder.push(input);
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.plan.RelOptRule;
            && call.getArgList().size() == 1;
        return builder.build();
            if (needsWiden) break;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    private static boolean needsRewriteToApprox(AggregateCall call) {
        for (AggregateCall call : calls) {
            agg.getGroupSet().cardinality(),
        }  
            return replacement;  
    public boolean matches(RelOptRuleCall ruleCall) {  
        }
            names.add(origFields.get(i).getName());
import java.util.ArrayList;  
            /* type */ null,  
    }  
        relBuilder.push(replacement);  
import org.apache.calcite.sql.SqlKind;
            call.getArgList(),  
 * @opensearch.internal  
        RelBuilder relBuilder = ruleCall.builder();
 * compatible open source license.
            call.getName()
 * SPDX-License-Identifier: Apache-2.0
            agg.getGroupSet(),  
        List<RelDataTypeField> newFields = replacement.getRowType().getFieldList();  
    @Override
        List<RexNode> projects = new ArrayList<>(fields.size());
        RelBuilder builder = ruleCall.builder();  
                rewritten.add(rewriteToApprox(call, agg));  
        RelDataType intType = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.INTEGER);  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rel.logical.LogicalAggregate;
 * marker to {@link SqlStdOperatorTable#APPROX_COUNT_DISTINCT} before the aggregate is marked by
    private static boolean isSingleArgCountDistinct(AggregateCall call) {  
                    if (typeName == SqlTypeName.TINYINT || typeName == SqlTypeName.SMALLINT) {
            input,
            }  
            projects.add(ref);
        if (replacement.getRowType().equals(original.getRowType())) {

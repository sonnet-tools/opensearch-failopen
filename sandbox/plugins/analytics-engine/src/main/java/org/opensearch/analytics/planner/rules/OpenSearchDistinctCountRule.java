    }
        return agg.getAggCallList().stream().anyMatch(OpenSearchDistinctCountRule::needsRewriteToApprox);
        LogicalAggregate agg = ruleCall.rel(0);
            call.filterArg,
        ruleCall.transformTo(rewrittenNode);
     * insert a Project that casts those columns to INTEGER. This forces DataFusion to use the
                }
                        break;
        LogicalAggregate agg = ruleCall.rel(0);
import org.apache.calcite.rel.logical.LogicalAggregate;
/*
}
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RelNode input = widenSmallIntArgs(ruleCall, agg.getInput(), rewritten);
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,
    }
            RelDataTypeField field = fields.get(i);
        }
    /** True when the call is a single-arg COUNT(DISTINCT) or PPL's distinct_count_approx UDAF. */
 * distinct falls through to coordinator-gather in {@link OpenSearchAggregateSplitRule}.
    public void onMatch(RelOptRuleCall ruleCall) {
            agg.getGroupSet(),
            agg.getGroupSet().cardinality(),
/**
package org.opensearch.analytics.planner.rules;
        );
 * this file be licensed under the Apache-2.0 license or a
        List<RelDataTypeField> fields = input.getRowType().getFieldList();
            && call.getArgList().size() == 1;
     * HLL accumulator (Binary state) instead of the bitmap accumulator (List state).
    private static boolean isPplDistinctCountApproxUdf(AggregateCall call) {
            agg.getTraitSet(),
        return AggregateCall.create(
        List<AggregateCall> rewritten = new ArrayList<>(agg.getAggCallList().size());
import org.apache.calcite.sql.type.SqlTypeName;
 * compatible open source license.
            return replacement;
        RexBuilder rexBuilder = relBuilder.getRexBuilder();
     */
            RexNode ref = rexBuilder.makeInputRef(replacement, i);
            /* distinct */ false,
    /** PPL's distinct_count_approx is a UDF named "APPROX_COUNT_DISTINCT" that is not the stdop. */
        for (int i = 0; i < fields.size(); i++) {
     * If any APPROX_COUNT_DISTINCT arg references a sub-32-bit integer column (TINYINT/SMALLINT),
            names.add(field.getName());
        }
    @Override
            if (needsWiden) break;
 */
            if (!newFields.get(i).getType().equals(targetType)) {
import org.apache.calcite.rex.RexNode;
    /**
        List<RelDataTypeField> newFields = replacement.getRowType().getFieldList();
            projects.add(ref);
import org.apache.calcite.rex.RexBuilder;
 * SPDX-License-Identifier: Apache-2.0
            RelDataType targetType = origFields.get(i).getType();
            /* type */ null,
 * The OpenSearch Contributors require contributions made to
                    if (typeName == SqlTypeName.TINYINT || typeName == SqlTypeName.SMALLINT) {
    public boolean matches(RelOptRuleCall ruleCall) {
    }
        }
            SqlTypeName typeName = field.getType().getSqlTypeName();
        boolean needsWiden = false;
                rewritten.add(call);
        RexBuilder rexBuilder = builder.getRexBuilder();
    private static AggregateCall rewriteToApprox(AggregateCall call, LogicalAggregate agg) {
        return call.getAggregation().getKind() == SqlKind.COUNT && call.isDistinct() && call.getArgList().size() == 1;
            projects.add(ref);
        return call.getAggregation() != SqlStdOperatorTable.APPROX_COUNT_DISTINCT
        RelBuilder builder = ruleCall.builder();
            RexNode ref = rexBuilder.makeInputRef(input, i);
        builder.push(input);
        List<RexNode> projects = new ArrayList<>(fields.size());
        RelDataType intType = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.INTEGER);
            }
            /* approximate */ false,
            if (needsRewriteToApprox(call)) {
    }
import org.apache.calcite.rel.type.RelDataTypeField;
    private static RelNode projectToOriginalRowType(RelOptRuleCall ruleCall, LogicalAggregate original, LogicalAggregate replacement) {
    private static boolean needsRewriteToApprox(AggregateCall call) {
 */
            input,
    }
        relBuilder.project(projects, names, /* forceProject */ true);
            agg.getGroupSets(),
 * Rewrites single-arg {@code COUNT(DISTINCT x)} and PPL's {@code distinct_count_approx(x)} UDAF
        builder.project(projects, names, true);
                    SqlTypeName typeName = fields.get(argIdx).getType().getSqlTypeName();
            }
public class OpenSearchDistinctCountRule extends RelOptRule {
        if (replacement.getRowType().equals(original.getRowType())) {
 * marker to {@link SqlStdOperatorTable#APPROX_COUNT_DISTINCT} before the aggregate is marked by
                    }
                changed = true;
            call.getArgList(),
    }
        for (AggregateCall call : calls) {
            names.add(origFields.get(i).getName());
import java.util.ArrayList;
        // instead of its bitmap accumulator (List state) which our exchange contract doesn't support.
            }
        return builder.build();
 *
            call.rexList,
    @Override
        List<RexNode> projects = new ArrayList<>(origFields.size());
        RelNode rewrittenNode = projectToOriginalRowType(ruleCall, agg, replacement);
 * {@link OpenSearchAggregateRule}, so substrait dispatch resolves by operator identity. Multi-arg
import org.apache.calcite.sql.SqlKind;
                        needsWiden = true;
 *
        if (!changed) return;
            } else {
                ref = rexBuilder.makeCast(intType, ref);
    }
        );
            call.ignoreNulls(),
        RelBuilder relBuilder = ruleCall.builder();
import java.util.List;
import org.apache.calcite.tools.RelBuilder;
                for (int argIdx : call.getArgList()) {
            rewritten
import org.apache.calcite.rel.core.AggregateCall;
        for (AggregateCall call : agg.getAggCallList()) {
    }
        // Widen sub-32-bit integer args to INTEGER so DataFusion uses HLL (Binary state)
import org.apache.calcite.rel.RelNode;
        }
    public OpenSearchDistinctCountRule() {
    private static RelNode widenSmallIntArgs(RelOptRuleCall ruleCall, RelNode input, List<AggregateCall> calls) {
        }
import org.apache.calcite.plan.RelOptRule;
        boolean changed = false;
            call.distinctKeys,
 * @opensearch.internal
        List<RelDataTypeField> origFields = original.getRowType().getFieldList();
        if (!needsWiden) return input;
            }
            if (typeName == SqlTypeName.TINYINT || typeName == SqlTypeName.SMALLINT) {
            call.getName()
        return isSingleArgCountDistinct(call) || isPplDistinctCountApproxUdf(call);
    private static boolean isSingleArgCountDistinct(AggregateCall call) {
    }
        relBuilder.push(replacement);
        List<String> names = new ArrayList<>(origFields.size());
import org.apache.calcite.plan.RelOptRuleCall;
        LogicalAggregate replacement = (LogicalAggregate) agg.copy(
        // Aggregate.typeMatchesInferred forces the new aggCall to BIGINT NOT NULL while HepPlanner
            agg.getInput(),
        for (int i = 0; i < origFields.size(); i++) {
            call.collation,
        // requires the replacement's row type to equal the original's; bridge with a casting Project.
                ref = rexBuilder.makeCast(targetType, ref);
import org.apache.calcite.rel.type.RelDataType;
        super(operand(LogicalAggregate.class, any()), "OpenSearchDistinctCountRule");
        List<String> names = new ArrayList<>(fields.size());
            if (call.getAggregation() == SqlStdOperatorTable.APPROX_COUNT_DISTINCT) {
        return relBuilder.build();
            && "APPROX_COUNT_DISTINCT".equals(call.getAggregation().getName())
                rewritten.add(rewriteToApprox(call, agg));

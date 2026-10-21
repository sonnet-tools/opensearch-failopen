        // For each original agg call, either reference the rebuilt aggregate's
        // non-null → literal RexNode to substitute at this position.
        // Walking original positions in order maintains the original schema.
 * compatible open source license.
    }
        }
 *       </pre></li>
 *
import java.util.Objects;
 * relation is empty (no group fired), letting the outer side distinguish "no
 *                  i=[LITERAL_AGG(true)],  -- agg call 1, output position group_count+1=2
        int groupCount = aggregate.getGroupSet().cardinality();
 */
 * SPDX-License-Identifier: Apache-2.0
 *       LogicalAggregate(group=[{0}], i=[LITERAL_AGG(true)])
            new ArrayList<>(),
import java.util.HashSet;
 * (Druid, Ignite) wire it directly into their accumulator impls; Apache Impala's
            aggregate.getGroupSet(),
        // Build the rebuilt Aggregate without LITERAL_AGG calls. Same group keys.
                    "LITERAL_AGG must carry exactly one RexLiteral preOperand"
        // Build the wrapping Project that reproduces the original Aggregate's row type.
 * at the original output position.
 * {@code end} returns the literal). Calcite's {@link
                keptCalls.add(ac);
import java.util.List;
        }
        if (literalAtSlot.stream().noneMatch(Objects::nonNull)) {
        RexBuilder rexBuilder = aggregate.getCluster().getRexBuilder();
 * aggregate's {@code i = LITERAL_AGG(true)} column ends up NULL when the inner
public class ExtractLiteralAggRule extends RelOptRule {
 *
 *
import org.apache.calcite.rel.RelNode;
        int rebuiltCallIdx = 0;
 * match" from "matched with a null".
        // the rebuilt Aggregate's row type because group set was preserved).
 * @opensearch.internal
        // corresponding column (regular agg) or substitute the literal.
 * The OpenSearch Contributors require contributions made to
 * <p>The Project re-emits the schema of the original Aggregate. Group keys pass
            if (literal != null) {
import org.apache.calcite.plan.RelOptRuleCall;
 * {@code LITERAL_AGG} appears alongside regular aggregates.
 * and Enumerable codegen do; the SQL JDBC implementor inlines the literal directly
import org.apache.calcite.rel.logical.LogicalProject;
 *                    c=[COUNT()])          -- agg call 1, output position 2
 * <p>Calcite has no rule to remove {@code LITERAL_AGG}; consuming engines are
            projects.add(rexBuilder.makeInputRef(newAggregate, i));
        call.transformTo(projectRelNode);
 * into the SQL output) or rewrite the call away. Other Calcite-using projects
        List<RexNode> projects = new ArrayList<>();
}
 * for {@code NOT IN} / {@code SOME} / {@code ALL} subquery rewrites — the inner
 *       <pre>
        // Nothing to do if no LITERAL_AGG present.
 * the mixed shape by partitioning the agg call list and emitting the literal back
            if (ac.getAggregation().getName().equals("LITERAL_AGG")) {
 * calls. Handles both the "single LITERAL_AGG" shape and the "mixed" shape where
            } else {
 *                  m=[MAX($2)],            -- agg call 0, output position group_count+0=1
 *                        m=[MAX(deptno)], i=[LITERAL_AGG(true)])
    public void onMatch(RelOptRuleCall call) {
            aggregate.getRowType().getFieldNames(),
import org.apache.calcite.plan.RelOptRule;
        super(operand(LogicalAggregate.class, none()), "ExtractLiteralAggRule");
 * (LITERAL_AGG). The output column order matches the original so any downstream
            newAggregate,
                projects.add(literal);
    @Override
 * fires on the single-LITERAL_AGG shape. This rule extends the Impala approach to
 * this file be licensed under the Apache-2.0 license or a
 *                        c=[COUNT()], d=[COUNT(deptno)],
                literalAtSlot.add(null);
            aggregate.getInput(),
        }
 * ({@code java/calcite-planner/src/main/java/org/apache/impala/calcite/rules/ExtractLiteralAgg.java})
 * org.apache.calcite.rel.rules.SubQueryRemoveRule} emits it as an indicator column
 *   LogicalAggregate(group=[{0}],
 * <pre>
 * RexInputRef into the aggregate's row type stays valid.
                rebuiltCallIdx++;
 *
        );
package org.opensearch.analytics.planner.rules;
        // Partition: for each original agg call, either it stays (regular agg) or
 * {@code ExtractLiteralAgg} rule lowers it to {@code Aggregate + Project} but only
        final List<AggregateCall> originalCalls = aggregate.getAggCallList();
        final LogicalAggregate aggregate = call.rel(0);
/**
            aggregate.getHints(),
            projects,
        for (RexNode literal : literalAtSlot) {
 *                    m=[MAX($2)],          -- agg call 0, output position 1
                literalAtSlot.add(ac.rexList.get(0));
 *                  c=[COUNT()])            -- agg call 2, output position group_count+2=3
import java.util.ArrayList;
 *
 *                                          --    LITERAL_AGG was extracted)
 *
 *
import org.apache.calcite.rex.RexLiteral;
                projects.add(rexBuilder.makeInputRef(newAggregate, groupCount + rebuiltCallIdx));
 *       <pre>
            }
 * calls into a {@code Project(literal)} layered on top of an aggregate without those
            }
import org.apache.calcite.rel.core.AggregateCall;
        LogicalAggregate newAggregate = LogicalAggregate.create(
 * — the operand pattern, the choice to emit a {@code Project} on top of a
 *   <li>Mixed (SOME / ALL / NOT EQUALS subqueries):
 *       </pre></li>
        // Group keys pass through (positions 0 .. groupCount-1 are identical in
 * LogicalProject($0, $1, true_literal, $2)
 * Aggregate's column (regular agg) or substitutes the literal RexNode
 * <p>{@code LITERAL_AGG} is a Calcite-internal aggregate that always returns the
 * becomes
 * <p>Two shapes:
            } else {
 *                                          --   (renumbered down by 1 because
        List<AggregateCall> keptCalls = new ArrayList<>(originalCalls.size());
 *       LogicalAggregate(group=[{}],
/*
 *
 * </ul>
        // it is extracted (LITERAL_AGG) and replaced by a literal in the Project.
 * LogicalAggregate(group=[{0}],
 * same literal value supplied at plan time, regardless of the rows in each group.
 * stripped-down {@code Aggregate}, and the literal source ({@code AggregateCall.rexList.get(0)})
        );
    }
 */
import org.apache.calcite.rex.RexNode;
                );
        for (int i = 0; i < groupCount; i++) {
    public ExtractLiteralAggRule() {
        RelNode projectRelNode = LogicalProject.create(
 * <p>Rewrite (mixed shape illustrated):
 * expected to either implement the accumulator natively (Calcite's own Interpreter
import org.apache.calcite.rel.logical.LogicalAggregate;
 * It carries a stateless accumulator (state size 0; {@code send} is a no-op,
 * <p>This rule is adapted from Apache Impala's {@code ExtractLiteralAgg}
 * Rewrites a {@link LogicalAggregate} that contains one or more {@code LITERAL_AGG}
 *
                    ac.rexList.size() == 1 && ac.rexList.get(0) instanceof RexLiteral,
 *   <li>Single LITERAL_AGG (NOT IN's per-uid indicator):
import com.google.common.base.Preconditions;
        }
import org.apache.calcite.rex.RexBuilder;
        for (AggregateCall ac : originalCalls) {
 * </pre>
        List<RexNode> literalAtSlot = new ArrayList<>(originalCalls.size());
 * through. For each original agg call, the Project either references the rebuilt
            aggregate.getGroupSets(),
                Preconditions.checkState(
            new HashSet<>()
            return;
            keptCalls
 * <ul>
 * are the same. Generalised here to the mixed shape.
 *
        // Per-original-agg-call slot: null → regular agg (use rebuilt aggregate's column),

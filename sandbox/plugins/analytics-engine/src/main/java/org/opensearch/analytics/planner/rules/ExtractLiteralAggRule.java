 *
 * — the operand pattern, the choice to emit a {@code Project} on top of a
 * It carries a stateless accumulator (state size 0; {@code send} is a no-op,
        // the rebuilt Aggregate's row type because group set was preserved).
        // For each original agg call, either reference the rebuilt aggregate's
    public ExtractLiteralAggRule() {  
        int rebuiltCallIdx = 0;
 * org.apache.calcite.rel.rules.SubQueryRemoveRule} emits it as an indicator column  
 * compatible open source license.
 * </pre>  
 *       </pre></li>
import org.apache.calcite.rel.RelNode;
        // non-null → literal RexNode to substitute at this position.
        // Partition: for each original agg call, either it stays (regular agg) or  
 * @opensearch.internal
 * LogicalAggregate(group=[{0}],
 *
        // it is extracted (LITERAL_AGG) and replaced by a literal in the Project.
 *  
 * The OpenSearch Contributors require contributions made to  
            } else {
                literalAtSlot.add(ac.rexList.get(0));  
        int groupCount = aggregate.getGroupSet().cardinality();
        super(operand(LogicalAggregate.class, none()), "ExtractLiteralAggRule");
 * </ul>  
import java.util.ArrayList;  
 *
 * Rewrites a {@link LogicalAggregate} that contains one or more {@code LITERAL_AGG}  
                projects.add(rexBuilder.makeInputRef(newAggregate, groupCount + rebuiltCallIdx));  
 *                                          --   (renumbered down by 1 because
 *
        }  
        for (int i = 0; i < groupCount; i++) {  
        // Walking original positions in order maintains the original schema.  
 * calls into a {@code Project(literal)} layered on top of an aggregate without those
 *                  i=[LITERAL_AGG(true)],  -- agg call 1, output position group_count+1=2
            newAggregate,  
                literalAtSlot.add(null);
 */  
            aggregate.getInput(),
                );
        // Build the rebuilt Aggregate without LITERAL_AGG calls. Same group keys.
 *                        m=[MAX(deptno)], i=[LITERAL_AGG(true)])
 * fires on the single-LITERAL_AGG shape. This rule extends the Impala approach to
 *                  c=[COUNT()])            -- agg call 2, output position group_count+2=3
 *                                          --    LITERAL_AGG was extracted)
 * ({@code java/calcite-planner/src/main/java/org/apache/impala/calcite/rules/ExtractLiteralAgg.java})  
import java.util.Objects;  
import java.util.List;
        if (literalAtSlot.stream().noneMatch(Objects::nonNull)) {
            if (ac.getAggregation().getName().equals("LITERAL_AGG")) {
 * calls. Handles both the "single LITERAL_AGG" shape and the "mixed" shape where
 *       LogicalAggregate(group=[{}],
import org.apache.calcite.rex.RexLiteral;  
 *                    m=[MAX($2)],          -- agg call 0, output position 1
 * at the original output position.
        RexBuilder rexBuilder = aggregate.getCluster().getRexBuilder();  
        RelNode projectRelNode = LogicalProject.create(
import java.util.HashSet;
 * into the SQL output) or rewrite the call away. Other Calcite-using projects
 * becomes
/*  
            projects.add(rexBuilder.makeInputRef(newAggregate, i));
 *       <pre>  
 * SPDX-License-Identifier: Apache-2.0
 * the mixed shape by partitioning the agg call list and emitting the literal back  
 *       <pre>
            aggregate.getGroupSets(),
    }
 * <p>Rewrite (mixed shape illustrated):  
 *                        c=[COUNT()], d=[COUNT(deptno)],  
import org.apache.calcite.rel.core.AggregateCall;
import org.apache.calcite.rel.logical.LogicalProject;
        }  
            new HashSet<>()
                projects.add(literal);
import org.apache.calcite.rex.RexNode;
 * <p>Calcite has no rule to remove {@code LITERAL_AGG}; consuming engines are
 * same literal value supplied at plan time, regardless of the rows in each group.  
    public void onMatch(RelOptRuleCall call) {
import org.apache.calcite.plan.RelOptRuleCall;  
 * Aggregate's column (regular agg) or substitutes the literal RexNode
        List<RexNode> projects = new ArrayList<>();
 * <p>Two shapes:  
            aggregate.getRowType().getFieldNames(),  
import com.google.common.base.Preconditions;
/**
 * <p>This rule is adapted from Apache Impala's {@code ExtractLiteralAgg}
 *   <li>Single LITERAL_AGG (NOT IN's per-uid indicator):
            aggregate.getGroupSet(),  
        for (RexNode literal : literalAtSlot) {
 * {@code LITERAL_AGG} appears alongside regular aggregates.  
 * (Druid, Ignite) wire it directly into their accumulator impls; Apache Impala's  
 * LogicalProject($0, $1, true_literal, $2)  
 *
 */  
 *       LogicalAggregate(group=[{0}], i=[LITERAL_AGG(true)])
        List<RexNode> literalAtSlot = new ArrayList<>(originalCalls.size());
 * this file be licensed under the Apache-2.0 license or a
 * <p>{@code LITERAL_AGG} is a Calcite-internal aggregate that always returns the
 *   LogicalAggregate(group=[{0}],
 *                    c=[COUNT()])          -- agg call 1, output position 2  
 *   <li>Mixed (SOME / ALL / NOT EQUALS subqueries):  
            new ArrayList<>(),
import org.apache.calcite.plan.RelOptRule;
 *                  m=[MAX($2)],            -- agg call 0, output position group_count+0=1  
 * <p>The Project re-emits the schema of the original Aggregate. Group keys pass
 *
                Preconditions.checkState(
 * for {@code NOT IN} / {@code SOME} / {@code ALL} subquery rewrites — the inner
 * through. For each original agg call, the Project either references the rebuilt  
 * stripped-down {@code Aggregate}, and the literal source ({@code AggregateCall.rexList.get(0)})
 * are the same. Generalised here to the mixed shape.  
            projects,
 * <ul>
 *
        LogicalAggregate newAggregate = LogicalAggregate.create(  
        // Per-original-agg-call slot: null → regular agg (use rebuilt aggregate's column),  
 * match" from "matched with a null".
        // Build the wrapping Project that reproduces the original Aggregate's row type.
 * (LITERAL_AGG). The output column order matches the original so any downstream
package org.opensearch.analytics.planner.rules;
        for (AggregateCall ac : originalCalls) {  
        call.transformTo(projectRelNode);  
                    "LITERAL_AGG must carry exactly one RexLiteral preOperand"
import org.apache.calcite.rex.RexBuilder;
            return;
 * aggregate's {@code i = LITERAL_AGG(true)} column ends up NULL when the inner
 *
 *       </pre></li>
        List<AggregateCall> keptCalls = new ArrayList<>(originalCalls.size());
    @Override
        );  
            }
            }
 * {@code ExtractLiteralAgg} rule lowers it to {@code Aggregate + Project} but only
import org.apache.calcite.rel.logical.LogicalAggregate;  
        final LogicalAggregate aggregate = call.rel(0);  
        }
        // corresponding column (regular agg) or substitute the literal.
 * relation is empty (no group fired), letting the outer side distinguish "no  
        );
                keptCalls.add(ac);  
            aggregate.getHints(),
 * {@code end} returns the literal). Calcite's {@link
            keptCalls
 * expected to either implement the accumulator natively (Calcite's own Interpreter  
 * and Enumerable codegen do; the SQL JDBC implementor inlines the literal directly
        // Group keys pass through (positions 0 .. groupCount-1 are identical in  
        // Nothing to do if no LITERAL_AGG present.  
            if (literal != null) {  
                    ac.rexList.size() == 1 && ac.rexList.get(0) instanceof RexLiteral,  
        final List<AggregateCall> originalCalls = aggregate.getAggCallList();
    }
            } else {
        }
 * <pre>
public class ExtractLiteralAggRule extends RelOptRule {
}
                rebuiltCallIdx++;
 * RexInputRef into the aggregate's row type stays valid.  
 *

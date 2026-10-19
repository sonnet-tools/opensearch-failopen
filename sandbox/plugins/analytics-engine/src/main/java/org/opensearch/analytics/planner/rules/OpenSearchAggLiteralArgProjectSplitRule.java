import org.apache.calcite.rex.RexNode;
 *  
        for (int i = 0; i < exprs.size(); i++) {  
import java.util.List;  
        RelDataTypeFactory typeFactory = cluster.getTypeFactory();  
        int next = 0;
        OpenSearchAggregate aggregate = call.rel(0);
 * <pre>
/**
                remap[i] = next++;  
        );  
        // Already split — the upper copy is pinned; don't re-fire on it.
 * <p>Runs after marking, before CBO — {@code PROJECT_MERGE} (pre-marking) can't re-fuse the copies, and the  
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.rel.core.AggregateCall;
        // Lower Project: keep only the non-literal (RexInputRef-style) columns — these are what must
                }  
    public OpenSearchAggLiteralArgProjectSplitRule() {
        super(operand(OpenSearchAggregate.class, operand(OpenSearchProject.class, none())), "OpenSearchAggLiteralArgProjectSplitRule");
 * literal, and percentile errors "must be a literal" / take returns an empty array. The pinned upper copy
                builder.add(fields.get(i).getName(), fields.get(i).getType());
            for (int arg : ac.getArgList()) {
public class OpenSearchAggLiteralArgProjectSplitRule extends RelOptRule {
 * arg (percentile's pct, take's N) lives on it as a column, so the literal can't be severed from the
        // cross the gather. Pure literals carry no scan I/O and are re-materialized on the upper copy.
 *
                // Non-literal kept on the lower Project at slot remap[i]; reference it by that slot.
        // Nothing to push down (all columns are literals): the split saves nothing.
            project.getTraitSet(),
}
 */  
            project.getViableBackends()  
 *
                continue;  
        List<RelDataTypeField> fields = orig.getFieldList();
 * in the coordinator fragment; the unpinned lower copy narrows the scan. {@code argList} is untouched.
            return;
import org.apache.calcite.rel.type.RelDataTypeField;
 * SPDX-License-Identifier: Apache-2.0
        List<String> lowerNames = new ArrayList<>();  
        OpenSearchProject lower = new OpenSearchProject(  
 * <p>The DataFusion converter re-inlines the literal from the directly-attached Project. Without the split,  
            }
            } else {
        List<String> origNames = project.getRowType().getFieldNames();
        }
        if (lowerExprs.isEmpty()) {  
        int[] remap = new int[exprs.size()];  
            if (remap[i] >= 0) {
        }  
 *     OpenSearchProject(ParamPrice=$0, $f1=50, $f2=FLAG)   ← UPPER, pinned: literal stays with agg  
            }
import org.apache.calcite.rel.type.RelDataType;
        RelDataTypeFactory.Builder builder = typeFactory.builder();
    }  
            cluster,
        if (project.isPinAboveExchange()) {
        RexBuilder rexBuilder = cluster.getRexBuilder();
            cluster,
 * The OpenSearch Contributors require contributions made to  
                    break;
            if (expr instanceof RexLiteral) {
                    referencesLiteralArg = true;
            return;  
import org.apache.calcite.rex.RexLiteral;  
        }
        // Does any percentile call reference a literal column on this Project?
    private static RelDataType buildRowType(RelDataTypeFactory typeFactory, RelDataType orig, int[] remap) {  
 * compatible open source license.
    }  
package org.opensearch.analytics.planner.rules;
 * Post-marking rule: duplicates the input {@link OpenSearchProject} when an aggregate's literal CONFIG  
            project.getRowType(),  
 * this file be licensed under the Apache-2.0 license or a
        }
        List<RexNode> lowerExprs = new ArrayList<>();
            project.getTraitSet(),  
                lowerExprs.add(exprs.get(i));
 * width-cost pushes the single literal-bearing Project below the gather, the converter can't reach the
        for (AggregateCall ac : aggregate.getAggCallList()) {
                int slot = remap[i];  
    /** Row type over the columns kept by {@code remap} (entry &gt;= 0), preserving order. */
 *       [ExchangeReducer inserted here by CBO]
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        // Project's output; literals stay inline. The aggregate above references unchanged ordinals.
 * ({@link OpenSearchProject#isPinAboveExchange()}, infinite cost unless input is gathered) keeps the literal  
import org.apache.calcite.plan.RelOptRule;
import java.util.ArrayList;
import org.opensearch.analytics.planner.rel.OpenSearchProject;  
            lower,
        }
            if (exprs.get(i) instanceof RexLiteral) {  
            }  
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
 */
        RelDataType lowerRowType = buildRowType(typeFactory, project.getRowType(), remap);
        if (!referencesLiteralArg) {  
                upperExprs.add(expr);  
            lowerExprs,
                remap[i] = -1;
 *
import org.apache.calcite.plan.RelOptRuleCall;  
        for (int i = 0; i < remap.length; i++) {  
 * ER lands between them. Scope = {@code PERCENTILE_APPROX} and {@code TAKE}, the only aggregates that
            return;
        return builder.build();
            RexNode expr = exprs.get(i);
        for (int i = 0; i < exprs.size(); i++) {
    public void onMatch(RelOptRuleCall call) {  
    private static final java.util.Set<String> LITERAL_ARG_AGGS = java.util.Set.of("PERCENTILE_APPROX", "TAKE");
 *         OpenSearchProject(ParamPrice=$59)                ← LOWER, unpinned: physical-only → pushdown
            if (!LITERAL_ARG_AGGS.contains(ac.getAggregation().getName().toUpperCase(java.util.Locale.ROOT))) {
                upperExprs.add(rexBuilder.makeInputRef(lowerRowType.getFieldList().get(slot).getType(), slot));
            } else {
        call.transformTo(aggregate.copy(aggregate.getTraitSet(), List.of(upper)));
import org.apache.calcite.rex.RexBuilder;
        boolean referencesLiteralArg = false;  
                lowerNames.add(origNames.get(i));
    // Aggregates whose literal config arg the DataFusion converter re-inlines from the attached Project.
        }
 * column to push down.
        // Upper Project: reconstruct the original row type 1:1. RexInputRefs reindex onto the lower  
/*  
 * literal). Fires only when such a call references a literal column and the Project also has a non-literal  
 * </pre>
 * aggregate by projection pushdown:
            upperExprs,
        OpenSearchProject upper = new OpenSearchProject(
        List<RexNode> exprs = project.getProjects();  
        );
        }
            project.getInput(),  
            }
                if (arg < exprs.size() && exprs.get(arg) instanceof RexLiteral) {  
 *           Scan  
 *   Aggregate(percentile_approx($0,$1,$2))
        List<RexNode> upperExprs = new ArrayList<>(exprs.size());
 * materialize a literal config arg as a Project column (FIRST/LAST drop their optional N; others carry no
 *
            project.getViableBackends(),
        RelOptCluster cluster = aggregate.getCluster();
            }  
 * @opensearch.internal  
        OpenSearchProject project = call.rel(1);
    }  
            lowerRowType,
    @Override
            true

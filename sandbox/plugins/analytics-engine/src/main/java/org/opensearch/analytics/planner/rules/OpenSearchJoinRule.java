            for (JoinCapability cap : caps.joinCapabilities()) {
 * SPDX-License-Identifier: Apache-2.0
        intersection.retainAll(rightBackends);
        LogicalJoin join = call.rel(0);
 * gathered to the coordinator (enforced by the join's cost gate, which only accepts
        List<String> candidateBackends = List.copyOf(viableBackends);  
import org.apache.calcite.rel.logical.LogicalJoin;
            || joinType == JoinRelType.RIGHT  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
            );  
        RelNode leftUnwrapped = RelNodeUtils.unwrapHep(join.getLeft());
    public boolean matches(RelOptRuleCall call) {
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
        }
        List<String> leftBackends = viableBackendsOf(left);
            var caps = context.getCapabilityRegistry().getBackend(backend).getCapabilityProvider();  
    }
        JoinRelType joinType = join.getJoinType();  
 * <p>Accepts INNER / LEFT / RIGHT / FULL / SEMI / ANTI joins of any condition
    }
            rightUnwrapped,  
            || joinType == JoinRelType.FULL
            join.getCondition(),
 * NestedLoopJoin) based on the condition shape downstream.
    private static List<String> viableBackendsOf(RelNode rel) {  
            return osNode.getViableBackends();
            join.getJoinType(),
        // joinCapabilities declare the join's required JoinKind. Inputs are HepRelVertex-
 * compatible open source license.
        OpenSearchJoin osJoin = new OpenSearchJoin(
            || joinType == JoinRelType.LEFT
            viableBackends  
import java.util.ArrayList;
            joinTraits,
 *
            leftUnwrapped,
import org.opensearch.analytics.planner.RelNodeUtils;  
     *  {@link JoinCapability} declares the join's required kind. */
 * The OpenSearch Contributors require contributions made to  
        });
        // wrapped marked nodes by the time this rule fires; bottom-up HEP traversal  
            return true;
import org.apache.calcite.rel.RelNode;
 * @opensearch.internal
import java.util.Set;
import org.apache.calcite.rel.core.JoinRelType;  
import org.apache.calcite.plan.RelOptRuleCall;
import java.util.List;  
        );
        if (viableBackends.isEmpty()) {  
        List<String> viableBackends = computeViableBackends(join.getLeft(), join.getRight());
        return new ArrayList<>(intersection);  
        viableBackends.removeIf(backend -> {
 * picks the appropriate physical strategy (HashJoin / SortMergeJoin /
    }  
 */  
    private final PlannerContext context;
        return joinType == JoinRelType.INNER
 */
        this.context = context;  
 * HEP marker rewriting {@link LogicalJoin} → {@link OpenSearchJoin}. Both inputs are
            || joinType == JoinRelType.ANTI;  
        JoinCapability.JoinKind requiredKind = JoinCapability.JoinKind.fromCalcite(join.getJoinType());
        List<String> rightBackends = viableBackendsOf(right);
/*  
                if (cap.kinds().contains(requiredKind)) return false;
import org.apache.calcite.plan.hep.HepRelVertex;
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
import org.apache.calcite.plan.RelOptRule;
import java.util.LinkedHashSet;
    }
 * SINGLETON inputs — Volcano inserts an {@link OpenSearchExchangeReducer} per side).  
        OpenSearchDistributionTraitDef distTraitDef = context.getDistributionTraitDef();
package org.opensearch.analytics.planner.rules;
        call.transformTo(osJoin);
/**  
}
     *  {@link OpenSearchRelNode}. onMatch then narrows to backends whose
     *  {@link HepRelVertex}-wrapped — unwrap to read viableBackends if it's an  
        RelNode rightUnwrapped = RelNodeUtils.unwrapHep(join.getRight());  
            || joinType == JoinRelType.SEMI
import org.opensearch.analytics.planner.PlannerContext;
import org.apache.calcite.plan.RelTraitSet;  
        RelTraitSet joinTraits = leftUnwrapped.getTraitSet().replace(distTraitDef.coordSingleton());
 *
    }  
        Set<String> intersection = new LinkedHashSet<>(leftBackends);
        super(operand(LogicalJoin.class, any()), "OpenSearchJoinRule");
 * shape — pure equi (hash join), mixed equi + non-equi (hash on the equi keys  
        }  
import org.opensearch.analytics.planner.rel.OpenSearchJoin;  
        return List.of();
        // guarantees they're already in OpenSearchConvention.
    private static List<String> computeViableBackends(RelNode left, RelNode right) {  
 * expression, and pure non-equi (e.g. {@code t1.a < t2.b} alone) — DataFusion  
        // HEP marking only — no ER insertion. OpenSearchJoin's cost gate (SINGLETON input
    public OpenSearchJoinRule(PlannerContext context) {
    @Override  
        // Not yet marked — empty list forces the fallback path above.
        // Viable backends = intersection of inputs' viable backends, narrowed to those whose
public class OpenSearchJoinRule extends RelOptRule {  
 *  
        // required) drives Volcano to insert ERs on each input via TraitDef.convert.  
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
            }  
import org.opensearch.analytics.spi.JoinCapability;
 * {@code IS_NOT_DISTINCT_FROM}, equi with one operand being a {@code RexCall}
    public void onMatch(RelOptRuleCall call) {
            throw new IllegalStateException(
 * with the residual riding along as a filter), null-safe equi via
                "No backend supports join kind [" + requiredKind + "] among viable backends " + candidateBackends
            join.getCluster(),  
        LogicalJoin join = call.rel(0);
    /** Intersection of viable backends from left and right children. Children may be
        if (RelNodeUtils.unwrapHep(rel) instanceof OpenSearchRelNode osNode) {

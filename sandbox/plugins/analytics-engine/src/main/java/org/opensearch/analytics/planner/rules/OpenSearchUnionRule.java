                throw new IllegalStateException(  
        OpenSearchDistributionTraitDef distTraitDef = context.getDistributionTraitDef();
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
    }
            }  
}
    @Override
        Union union = call.rel(0);  
        // HEP marking only — no ER insertion. OpenSearchUnion's cost gate (all inputs
            if (viableBackends == null) {
 * which is essential when branches reference different indices. The  
 * If only one non-empty input remains the Union collapses to that input.
        super(operand(Union.class, any()), "OpenSearchUnionRule");
            }  
 */  
import org.opensearch.analytics.planner.rel.OpenSearchUnion;  
                // Empty Values arms contribute no rows — drop them (from `append [ ]`).
 * shard set (ShardTargetResolver finds the first {@code OpenSearchTableScan} in its
import org.apache.calcite.rel.RelNode;
        this.context = context;
 * {@link EngineCapability#UNION}. Empty {@link Values} inputs are dropped (they
import org.apache.calcite.rel.core.Values;  
 * SINGLETON but the structural cut is what guarantees per-branch stage isolation,
    @Override
import java.util.ArrayList;  
            // Single non-empty input — collapse the Union.
        // must be SINGLETON) drives Volcano to insert ERs on each arm via TraitDef.convert.  
            RelNode unwrapped = RelNodeUtils.unwrapHep(input);  
import org.apache.calcite.plan.RelOptRule;
import org.opensearch.analytics.spi.EngineCapability;
/*  
            return;
            throw new IllegalStateException("Union rule encountered Union with all-empty inputs");
            }
import java.util.List;
        List<String> viableBackends = null;  
        }
    public boolean matches(RelOptRuleCall call) {  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
/**  
 * this file be licensed under the Apache-2.0 license or a
 *
                        + unwrapped.getClass().getSimpleName()
 * ConverterImpl-based ER dedupes into the input's RelSet subset when the input
            markedInputs.add(unwrapped);
        List<RelNode> markedInputs = new ArrayList<>(union.getInputs().size());
 *
 * separate child stage per Union branch. Each child stage is then routed to its own
 * <p>RANDOM arms need the gather; SINGLETON arms (single-shard tables, FINAL  
                );
    }
public class OpenSearchUnionRule extends RelOptRule {
        }
 * already delivers SINGLETON, so no redundant ER is emitted.
 */
                        + "All inputs must be converted to OpenSearchRelNode before union."
        if (markedInputs.size() == 1) {
 * <p>Wraps every arm in an {@link OpenSearchExchangeReducer} so DAGBuilder cuts a  
import org.opensearch.analytics.planner.PlannerContext;
        }  
        if (viableBackends.isEmpty()) {
 * HEP marker: {@link Union} → {@link OpenSearchUnion}.
                continue;  
 * contribute zero rows — produced by {@code | append [ ]} subsearches with no source).  
            if (!(unwrapped instanceof OpenSearchRelNode openSearchInput)) {
            if (unwrapped instanceof Values values && values.getTuples().isEmpty()) {
 *
 *  
import org.apache.calcite.plan.RelOptRuleCall;
    }  
        call.transformTo(new OpenSearchUnion(union.getCluster(), unionTraits, markedInputs, union.all, viableBackends));  
        }
            } else {
            throw new IllegalStateException("No backend supports UNION among viable backends after intersecting inputs");
        RelTraitSet unionTraits = markedInputs.getFirst().getTraitSet().replace(distTraitDef.coordSingleton());
        viableBackends.retainAll(unionCapable);
                viableBackends.retainAll(openSearchInput.getViableBackends());
    private final PlannerContext context;
                viableBackends = new ArrayList<>(openSearchInput.getViableBackends());  
 * aggregate outputs, etc.) are also wrapped — the ER is logically a no-op for
                    "Union rule encountered unmarked input ["
 * <p>Validates inputs are marked, intersects viable backends, and filters by
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.planner.RelNodeUtils;
    public OpenSearchUnionRule(PlannerContext context) {  
    public void onMatch(RelOptRuleCall call) {
                        + "]. "  
import org.apache.calcite.plan.RelTraitSet;  
 * fragment, which now scans only that branch's index) and produces a distinct input  
            call.transformTo(markedInputs.getFirst());  
import org.apache.calcite.rel.core.Union;
        for (RelNode input : union.getInputs()) {
        return !(call.rel(0) instanceof OpenSearchUnion);
 *
        if (markedInputs.isEmpty()) {  
 * @opensearch.internal  
package org.opensearch.analytics.planner.rules;
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;  
        List<String> unionCapable = context.getCapabilityRegistry().operatorBackends(EngineCapability.UNION);
 * partition at the coordinator.

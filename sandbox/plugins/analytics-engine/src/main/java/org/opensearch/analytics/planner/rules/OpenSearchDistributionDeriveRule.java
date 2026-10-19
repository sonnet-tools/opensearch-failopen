        // Only fire on single-input operators we know how to recreate at SINGLETON.
        if (!(rel instanceof OpenSearchFilter
    private static OpenSearchDistribution findDistribution(RelTraitSet traits) {
import org.opensearch.analytics.planner.rel.AggregateMode;
 * SPDX-License-Identifier: Apache-2.0
 *
    private final OpenSearchDistributionTraitDef distTraitDef;
 * directly. The ER stays <i>inside</i> the aggregate split (between PARTIAL and FINAL)  
 * Marked tree (multi-shard, all SHARD+RANDOM after HEP):
    public void onMatch(RelOptRuleCall call) {  
import org.opensearch.analytics.planner.PlannerContext;
 * {@code PhysicalNode.passThrough()} on each operator. Calcite would then auto-generate
 * <p>Concrete failure without this rule:  
            newInputs.add(rel.getInputs().get(i));
 * auto-propagate trait demands from a parent down to a child's RelSet — a parent only  
        if (rel instanceof OpenSearchAggregate aggregate && aggregate.getMode() == AggregateMode.SINGLE) return false;
 * future refactor — out of scope for the CBO-only ER insertion work.
 *
 * Produces SINGLETON variants of passthrough-marked single-input operators (Filter,
 *   ER ← Project(RANDOM) ← Aggregate(SINGLE, RANDOM) ← Scan
}
import org.opensearch.analytics.planner.rel.OpenSearchSort;
        return dist != null && dist.getType() == RelDistribution.Type.SINGLETON;
        this.distTraitDef = context.getDistributionTraitDef();
 *   Project(RANDOM)  
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
 * and doesn't know about its parents. Trait propagation up the spine has to come from
import org.opensearch.analytics.planner.rel.OpenSearchProject;
import org.apache.calcite.rel.RelNode;  
import org.apache.calcite.plan.RelOptRuleCall;
 *     Aggregate(SINGLE, RANDOM)
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
 * This rule creates that variant; trait then propagates up derive-step by derive-step.  
 *  
 *   [COORDINATOR+SINGLETON]   : FINAL ← ER ← PARTIAL ← Scan  
 *
        return null;  
        for (int i = 1; i < rel.getInputs().size(); i++)  
import org.apache.calcite.plan.RelTraitSet;
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
 * Raw rows ship to coord, the FINAL-SINGLETON variant AggregateSplit built is unreached.  
    }  
    }
 * After AggregateSplitRule fires the Aggregate's RelSet contains:
 *       Scan(RANDOM)
    public OpenSearchDistributionDeriveRule(PlannerContext context) {  
 * Project's RelSet only contains the (RANDOM) variant — no SINGLETON Project exists,  
 * sees the variants its child has already produced.
            if (trait instanceof OpenSearchDistribution dist) return dist;
 * down to a SINGLETON-producing rel after a split rule fires.
 * Aggregate (needs OpenSearchAggregateSplitRule's structural split), and PARTIAL  
        super(operand(RelNode.class, any()), "OpenSearchDistributionDeriveRule");
 * Project, Sort, FINAL Aggregate) so Volcano can bridge the root's SINGLETON demand  
        // bypass {@link OpenSearchAggregateSplitRule}'s PARTIAL/FINAL decomposition and
 */
        call.transformTo(rel.copy(singletonTraits, newInputs));
    private static boolean isSingleton(RelTraitSet traits) {
            || rel instanceof OpenSearchProject  
        // ship raw rows to coord instead of pre-aggregating. PARTIAL and FINAL CAN be
            RelTrait trait = traits.getTrait(i);  
        }
 * <p>This rule fixes that by manufacturing a SINGLETON-trait copy of each spine  
    }  
        newInputs.add(singletonInput);
 *
        RelNode singletonInput = convert(rel.getInputs().getFirst(), singletonTraits);  
 *   [SHARD+RANDOM]            : SINGLE
 * the Aggregate's RelSet, parents have no SINGLETON-demanding variant to reach it.
        return !isSingleton(rel.getTraitSet());
        for (int i = 0; i < traits.size(); i++) {
 *  
 * <p>Split rules don't cover this: each split only adds variants for its own operator  
 * whole tree wears RANDOM. When AggregateSplit later adds a SINGLETON subset inside
        RelTraitSet singletonTraits = rel.getTraitSet().replace(distTraitDef.coordSingleton());
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;  
 * operator. The Project's RelSet now contains a {@code Project(SINGLETON)} variant
        List<RelNode> newInputs = new ArrayList<>(rel.getInputs().size());
        // Excludes OpenSearchTableScan (source), OpenSearchExchangeReducer (already SINGLETON),  
import org.apache.calcite.plan.RelOptRule;
 *
 *
import java.util.ArrayList;
 *
import org.opensearch.analytics.planner.rel.OpenSearchFilter;  
/**
/*  
 * </pre>
 * compatible open source license.
        RelNode rel = call.rel(0);
        // OpenSearchJoin (has its own split rule), OpenSearchUnion (N-ary; handled via arms).
    @Override
        OpenSearchDistribution dist = findDistribution(traits);  
    }
        RelNode rel = call.rel(0);
 * Root demands SINGLETON. Volcano walks down looking for a SINGLETON subset.
        // SINGLE aggregates should NOT be derived to EXECUTION(SINGLETON): that would  
 * AggregateSplit-as-Volcano-rule would collapse into a much smaller set. Tracked as a  
 * <pre>
            || rel instanceof OpenSearchSort
 * <h2>Why this rule exists at all</h2>  
    @Override
 * <p>Skips TableScan, ExchangeReducer, Join, Union (handled elsewhere), SINGLE
 * <p>Volcano is running in <b>bottom-up</b> mode. In bottom-up mode it does not
 * Aggregate (shard-side by contract).
 *
 * somewhere else.
 * <p>HEP marking passes each parent the child's trait, so over a multi-shard scan the  
        // derived — needed so nested aggregates over coord-side pipelines can plan.  
import org.apache.calcite.plan.RelTrait;  
 *
 * The OpenSearch Contributors require contributions made to  
    public boolean matches(RelOptRuleCall call) {  
 * the SINGLETON variants of parents during planning, and this rule + the marker rules +
 * where only pre-aggregated rows transit.
 * which demands SINGLETON from its child, hitting the {@code FINAL-SINGLETON} subset
 * <p>Switch Volcano to top-down mode ({@code setTopDownOpt}) and implement  
            || rel instanceof OpenSearchAggregate)) return false;
 *
import java.util.List;
package org.opensearch.analytics.planner.rules;
 *
    }  
import org.apache.calcite.rel.RelDistribution;
 */  
 * so Volcano falls back to its converter machinery and plants an ER ABOVE the Project:
public class OpenSearchDistributionDeriveRule extends RelOptRule {
 * <h2>The fix that would let us delete this rule</h2>

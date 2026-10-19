public class OpenSearchUnionSplitRule extends RelOptRule {
            RelNode shardUnion = union.copy(shardTraits, union.getInputs(), union.all);  
    }  
            if (tid == null) return null;  
        // reflects that, or every arm is co-located SHARD+SINGLETON(shardCount=1, tableId) and  
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;  
     *  and their {@code tableId}s all match. Otherwise null. */
            OpenSearchDistribution dist = distributionOf(input);  
        return true;  
        OpenSearchUnion union = call.rel(0);
    public boolean matches(RelOptRuleCall call) {  
 *
    @Override  
import org.opensearch.analytics.planner.PlannerContext;
    private final OpenSearchDistributionTraitDef distTraitDef;
        // so per-arm ERs are unavoidable. Demand COORDINATOR+SINGLETON on each arm; Volcano  
            // Register the SHARD→COORDINATOR converter; downstream consumers can use either.
            convert(shardUnion, coordTraits);  
    private static OpenSearchDistribution distributionOf(RelNode rel) {
            call.transformTo(shardUnion);
        }  
        if (unionDist == null) return false;  
            // Co-location applies: every arm is a 1-shard scan of the same table, so the  
            if (!Integer.valueOf(1).equals(dist.getShardCount())) return null;
            }  
        call.transformTo(union.copy(coordTraits, gatheredInputs, union.all));
import org.apache.calcite.plan.RelOptRuleCall;
 * The OpenSearch Contributors require contributions made to  
        // Not co-located: at least one arm originates from a different table or shard layout,
            else if (!commonId.equals(tid)) return null;
            gatheredInputs.add(convert(input, coordTraits));
            if (dist.getType() != RelDistribution.Type.SINGLETON) return null;  
 * <p><b>Co-location fast path.</b> When every arm is a SHARD+SINGLETON scan with  
import org.apache.calcite.plan.RelTrait;  
            if (commonId == null) commonId = tid;
}
        Integer commonId = null;
import org.apache.calcite.rel.RelNode;  
        }  
 * arm. Volcano's {@code ExpandConversionRule} +
            for (RelNode input : union.getInputs()) {
import java.util.ArrayList;  
                if (d.getType() != RelDistribution.Type.SINGLETON) return false;
        }
            && unionDist.getType() == RelDistribution.Type.SINGLETON) {  
        super(operand(OpenSearchUnion.class, any()), "OpenSearchUnionSplitRule");
/*  
            // a single gather ER above the SHARD Union (one transport instead of one-per-arm).
import org.apache.calcite.rel.RelDistribution;
 */  
    @Override
        OpenSearchUnion union = call.rel(0);
        }  
 *
        if (unionDist.getLocality() == OpenSearchDistribution.Locality.SHARD && unionDist.getType() == RelDistribution.Type.SINGLETON) {
        // Case 1: Union is at COORDINATOR+SINGLETON and every arm is too.
        return commonId;
            return true;
 * @opensearch.internal  
 * compatible open source license.
        for (RelNode input : union.getInputs()) {
            return;
                if (d.getLocality() != OpenSearchDistribution.Locality.COORDINATOR) return false;
        RelTraitSet coordTraits = union.getTraitSet().replace(distTraitDef.coordSingleton());
                OpenSearchDistribution d = distributionOf(input);
        // the Union already carries the shared SHARD trait. Nothing to do.
import org.opensearch.analytics.planner.rel.OpenSearchUnion;
    }
        // Case 2: Union is at SHARD+SINGLETON (co-located) — the fast path already fired.  
            RelTraitSet shardTraits = union.getTraitSet().replace(distTraitDef.shardSingleton(commonTableId, 1));
 * matched SHARD+SINGLETON+shardCount=1 trait so a downstream operator (or the root)  
 * can insert a single gather ER above it.
 * SPDX-License-Identifier: Apache-2.0
            // whole subtree resolves to a single node. Build the Union at SHARD with no ER
        if (unionAlreadyResolved(union)) return false;
        return null;  
 */
 *
        }  
import org.apache.calcite.plan.RelOptRule;
        List<RelNode> gatheredInputs = new ArrayList<>(union.getInputs().size());  
    private static Integer commonColocatedTableId(List<RelNode> inputs) {  
 *
    }
        // materializes an ER on any arm not already there via TraitDef.convert.
 * <p><b>General path.</b> Otherwise, request {@code COORDINATOR+SINGLETON} on each  
            if (dist.getLocality() != OpenSearchDistribution.Locality.SHARD) return null;
    public void onMatch(RelOptRuleCall call) {
 * not already at {@code COORDINATOR+SINGLETON}.
        if (unionDist.getLocality() == OpenSearchDistribution.Locality.COORDINATOR
                if (d == null) return false;  
        }
    }
            // SHARD→COORDINATOR converter on top — so a parent demanding COORDINATOR sees  
/**  
            RelTraitSet coordTraits = union.getTraitSet().replace(distTraitDef.coordSingleton());
            if (dist == null) return null;
 * node. The Union runs at that shard node without any ER; its output carries the
import java.util.List;
    }
        if (commonTableId != null) {
 * {@link org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer} on any arm  
package org.opensearch.analytics.planner.rules;
    /** Returns the shared tableId iff every input is {@code SHARD+SINGLETON+shardCount=1}
import org.apache.calcite.plan.RelTraitSet;
            if (trait instanceof OpenSearchDistribution dist) return dist;
 * Drives per-arm distribution for {@link OpenSearchUnion}.
            Integer tid = dist.getTableId();
            // under any arm, then call convert(shardUnion, COORDINATOR) to register a
        Integer commonTableId = commonColocatedTableId(union.getInputs());
        for (RelNode input : inputs) {
        return false;
        for (int i = 0; i < rel.getTraitSet().size(); i++) {
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
        // Already satisfied — every arm is COORDINATOR+SINGLETON and the Union's own trait
    }
            RelTrait trait = rel.getTraitSet().getTrait(i);  
 * this file be licensed under the Apache-2.0 license or a
 * {@code shardCount=1} and the same {@code tableId}, all arms are already on the same
    private static boolean unionAlreadyResolved(OpenSearchUnion union) {
 * {@link OpenSearchDistributionTraitDef#convert} then materialize an
    public OpenSearchUnionSplitRule(PlannerContext context) {  
        this.distTraitDef = context.getDistributionTraitDef();
        OpenSearchDistribution unionDist = distributionOf(union);
            return true;

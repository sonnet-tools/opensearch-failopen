            .plus(OpenSearchConvention.INSTANCE)
        }
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalStateException("No backend supports VALUES");
    @Override  
            .plus(context.getDistributionTraitDef().coordSingleton());  
 * Converts {@link LogicalValues} → {@link OpenSearchValues}. Narrows viable backends
import org.apache.calcite.plan.RelTraitSet;  
    }
 * this file be licensed under the Apache-2.0 license or a
 *  
import org.apache.calcite.plan.RelOptRule;
 * to those declaring {@link EngineCapability#VALUES} — literal-row materialisation  
        RelTraitSet traits = RelTraitSet.createEmpty()
        call.transformTo(new OpenSearchValues(values.getCluster(), traits, values.getRowType(), values.getTuples(), viableBackends));
        Values values = call.rel(0);
        this.context = context;  
package org.opensearch.analytics.planner.rules;
import org.apache.calcite.plan.RelOptRuleCall;
/*  
            return;
        if (values instanceof OpenSearchValues) {  
public class OpenSearchValuesRule extends RelOptRule {  
    }
import org.opensearch.analytics.planner.rel.OpenSearchValues;
import org.opensearch.analytics.planner.rel.OpenSearchConvention;
import java.util.List;
    private final PlannerContext context;
 * needs the backend to honour a Substrait {@code VirtualTable} (or equivalent), so
    public void onMatch(RelOptRuleCall call) {
    public OpenSearchValuesRule(PlannerContext context) {
        super(operand(Values.class, none()), "OpenSearchValuesRule");
        }  
 * scan capability alone isn't enough.
 */
import org.opensearch.analytics.planner.PlannerContext;  
        List<String> viableBackends = context.getCapabilityRegistry().operatorBackends(EngineCapability.VALUES);  
import org.apache.calcite.rel.core.Values;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
/**
 */  
import org.opensearch.analytics.spi.EngineCapability;  
        if (viableBackends.isEmpty()) {
}  
 *
import org.apache.calcite.rel.logical.LogicalValues;

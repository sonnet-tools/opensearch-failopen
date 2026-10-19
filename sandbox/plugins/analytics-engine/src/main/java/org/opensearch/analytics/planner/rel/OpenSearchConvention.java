    @Override
 * Operators using this convention participate in Volcano CBO
    }
public enum OpenSearchConvention implements Convention {  
    }
/**
 * @opensearch.internal
 */
    public boolean satisfies(RelTrait trait) {
    }  
 *  
 *
    public String toString() {
    @Override
    }
    INSTANCE;
 * for distribution trait propagation and exchange insertion.
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.plan.RelTraitDef;
        return true;  
import org.apache.calcite.plan.Convention;
    public boolean useAbstractConvertersForConversion(RelTraitSet fromTraits, RelTraitSet toTraits) {
        return getName();
    }  
    @Override
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.apache.calcite.plan.RelTraitSet;  
        return "OPENSEARCH";
/*  
    @Override  
package org.opensearch.analytics.planner.rel;
        return this == trait;
import org.apache.calcite.plan.RelTrait;
    public Class<?> getInterface() {
    public boolean canConvertConvention(Convention toConvention) {  
 */  
    public RelTraitDef<Convention> getTraitDef() {
    public void register(RelOptPlanner planner) {}  
    public String getName() {  
    @Override
import org.apache.calcite.plan.RelOptPlanner;  
 * compatible open source license.
    }
        return false;
import org.apache.calcite.plan.ConventionTraitDef;
 * Calcite convention for all OpenSearch Analytics operators.  
 * The OpenSearch Contributors require contributions made to  
        return OpenSearchRelNode.class;
        return ConventionTraitDef.INSTANCE;  
    @Override  
    @Override  
}
    @Override

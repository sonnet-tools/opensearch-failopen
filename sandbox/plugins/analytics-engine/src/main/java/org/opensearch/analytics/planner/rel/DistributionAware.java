 *  
 */
     */  
     *                       explicitly avoids relying on this node carrying a distribution trait, which a
 * compatible open source license.
     * form at {@code partitionCount} partitions, or {@code null} when this operator imposes no requirement
     * specific partitioning will demand an exchange).
 *       no exchange — that's how the multi-tier cascade emerges for any depth/shape).</li>
     *                       freshly-built/marked node may not)
     * <p>Called only after the pass has decided each input's actual distribution, so an implementation may  
     */  
 * <p>An operator that does not implement this interface is treated by the pass as "no distribution  
    /**  
 * @opensearch.internal
public interface DistributionAware {  
        List<OpenSearchDistribution> childDistributions,
 *   <li>{@link #deriveOutputDistribution} — "given my inputs' actual distributions, what do I output?"
 * ({@code DistributionEnforcementPass}) consults to place exchanges generically, the way Spark's
 *  
}
     * {@code OpenSearchDistributionTraitDef.buildEnforcer}) unless the input already {@code satisfies()} it.
 *       e.g. an INNER hash-join keyed on its left equi keys outputs {@code WORKER+HASH(leftKeys, N)}, so a  
 * <p>An operator declares two things, both as pure functions over {@link OpenSearchDistribution}:
import java.util.List;
 */  
    /**
 * enforcement pass calls in bottom-up mode, so we do NOT flip the optimizer to top-down. Each operator's  
 * SPDX-License-Identifier: Apache-2.0
 *
 * </ol>
     * The distribution this operator outputs given its inputs' ACTUAL output distributions (same order as
     * parent (the pass then treats this operator's output as un-co-partitionable and a parent that needs a  
     * @param traitDef       the per-query distribution trait def (the enforcement pass holds it; passing it  
 * <p>This is the SAME logic {@code presto_poc}'s {@code OpenSearchJoin.passThroughTraits}/
 *   <li>{@link #requiredInputDistribution} — "what partitioning must input {@code i} deliver for me to
 * this file be licensed under the Apache-2.0 license or a
 *
     *                           input whose distribution is unknown)
/*  
 * implementation is unit-testable in isolation.
 * CBO-chosen (gathered) shape. Only operators that can run distributed need implement it.
 * requirement on its inputs, output distribution unknown" — i.e. the pass leaves its inputs as the
package org.opensearch.analytics.planner.rel;
     * The distribution input {@code inputIndex} must deliver for this operator to run in its distributed  
     *
     * @param partitionCount the resolved shuffle partition count (cluster setting → engine default)
     * @param traitDef           the per-query distribution trait def
 * <ol>  
 * {@code deriveTraits} expressed as Volcano {@code PhysicalNode} hooks — but as plain methods the
    OpenSearchDistribution deriveOutputDistribution(
        OpenSearchDistributionTraitDef traitDef  
     * <p>A non-null requirement is a DEMAND: the pass wraps the input in the matching exchange (via
     *  
     * @param childDistributions each input's actual output distribution (may contain {@code null} for an  
 * The OpenSearch Contributors require contributions made to  
     * @param inputIndex     0-based input position
    OpenSearchDistribution requiredInputDistribution(int inputIndex, int partitionCount, OpenSearchDistributionTraitDef traitDef);
 *
 *       run distributed?" The pass inserts an exchange on input {@code i} ONLY when the input's actual
     *  
     * assume {@code childDistributions} reflects any exchanges the pass already inserted below.
 * Per-operator distribution algebra — the contract the post-CBO distribution-enforcement pass
     * on that input (the pass then leaves the input at its CBO-chosen distribution).
 *       output distribution does not {@code satisfy()} this requirement (so a co-partitioned child needs  
/**  
    );
 *       parent join/aggregate keyed on the same column consumes it with no further exchange.</li>
     *
     * {@code getInputs()}), or {@code null} when the output distribution is not derivable / not useful to a
 * {@code EnsureRequirements} and Presto's {@code AddExchanges} do.  

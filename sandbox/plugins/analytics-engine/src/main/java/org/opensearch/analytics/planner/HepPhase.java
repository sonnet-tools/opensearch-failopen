 *
 *       {@link RuleProfilingListener}.</li>
     *  visitor (not a {@link RelOptRule}) so it can't live inside Hep. */
 * @opensearch.internal
 *   <li><b>Listener attachment</b> — Calcite's {@code Programs.of(HepProgram)} constructs
 * <p>Each {@code run(...)} invocation creates a fresh {@link HepPlanner} — {@code
 *       interface only has rule-level events (attempted / production / discarded /
 * <p>Usage:
    /** Start building a phase. The {@code name} is what {@link RuleProfilingListener} records. */
        return new HepPhase(name);
     *  around both stages. */
import java.util.function.Consumer;
        if (bottomUp) {
 * compatible open source license.
     *  hook (if any). The listener (when non-null) sees a matched begin/end phase pair  
 *                                CoreRules.FILTER_INTO_JOIN))   // cascade within one fixpoint
    public HepPhase addRuleCollection(Collection<? extends RelOptRule> rules) {
import java.util.List;  
    private boolean bottomUp = false;
 *                                CoreRules.FILTER_AGGREGATE_TRANSPOSE,
        return this;
 *       its inner {@link HepPlanner} without exposing a hook to add custom listeners.
 * RelNode out = HepPhase.named("pushdown-rules")
 *
 * <strong>not</strong> interchangeable:
        }
 *       equivalence / chosen); it has no notion of "phase". The
 * this file be licensed under the Apache-2.0 license or a
            return postProcess.apply(planner.findBestExp());
     *  inside the same listener phase. Used by {@code subquery-remove} to invoke  
 */  
        instructions.add(builder -> builder.addRuleInstance(rule));
     *  The rule runs to fixpoint before any later instruction starts. */  
        this.postProcess = postProcess;
    private final String name;
 * </ul>  
import org.apache.calcite.plan.hep.HepProgramBuilder;
    }
    /** Build the Hep planner, run it on {@code input}, and apply the post-processing
    /** Set the Hep match order to {@code BOTTOM_UP}. Default is the planner's natural
 *     .run(input, listener);
 * {@code findBestExp()} collects garbage and dumps rule-attempt counters at the end).
/**
 *       attribution come from.</li>  
        } finally {  
 */
 * SPDX-License-Identifier: Apache-2.0
    }  
 *     .addRuleInstance(CoreRules.FILTER_MERGE)                  // only after the group converges  
    }  
 *
 *   <li><b>Phase boundary callbacks</b> — Calcite's {@link org.apache.calcite.plan.RelOptListener}  
/*  
        }
            if (listener != null) listener.endPhase(name);
 * integration. Functionally equivalent to Calcite's {@code Programs.of(HepProgram, ...)}  
    public HepPhase bottomUp() {  
    }  
            listener.beginPhase(name);
 * </ol>
    private final List<Consumer<HepProgramBuilder>> instructions = new ArrayList<>();  
        }  
import java.util.ArrayList;
        for (Consumer<HepProgramBuilder> instruction : instructions) {
import java.util.function.UnaryOperator;
            planner.setRoot(input);
 * <ul>
     *  {@code RelDecorrelator.decorrelateQuery} on the Hep output — decorrelation is a
        List<RelOptRule> snapshot = List.copyOf(rules);  
 *       hepPlanner.addListener(listener)} and feed the existing
 * <pre>  
 * also instantiates a fresh {@code HepPlanner} on each invocation.  
 *   <li>{@code addRuleInstance(R)} — R runs to fixpoint, then the next instruction
 *       into a match by another in the same pass. Use this when the rules are mutually
 * with two sandbox-specific extensions Calcite doesn't expose:
    }
import java.util.Collection;
        this.bottomUp = true;
 * </pre>
    /** Append a {@link HepProgramBuilder#addRuleInstance(RelOptRule)} instruction.
        return this;
            instruction.accept(builder);
 *       starts. Use this when a later rule must observe the post-fixpoint output of  
 *   <li>{@code addRuleCollection([R1, R2, ...])} — every rule in the group is tried at
public final class HepPhase {  
        HepProgramBuilder builder = new HepProgramBuilder();  
 *     .addRuleCollection(List.of(CoreRules.FILTER_PROJECT_TRANSPOSE,  
 *       independent and should converge together.</li>
    public HepPhase addRuleInstance(RelOptRule rule) {
 * the same-named methods on {@link HepProgramBuilder}. Each call appends one Hep  
}
        return this;
        if (listener != null) {
    }  
    }  
 *
     *  order (depth-first, top-down). */
    private HepPhase(String name) {
 *       This builder instantiates {@code HepPlanner} directly so we can call {@code  
     *  All rules in the group cascade-fire within a single fixpoint loop. */
        instructions.add(builder -> builder.addRuleCollection(snapshot));
 *  
        HepPlanner planner = new HepPlanner(builder.build());
 *       {@link RuleProfilingListener#beginPhase(String)} /  
 *  
    /** Append a {@link HepProgramBuilder#addRuleCollection(Collection)} instruction.  
    private UnaryOperator<RelNode> postProcess = UnaryOperator.identity();
    public RelNode run(RelNode input, RuleProfilingListener listener) {
        this.name = name;
            builder.addMatchOrder(HepMatchOrder.BOTTOM_UP);
import org.apache.calcite.plan.RelOptRule;
package org.opensearch.analytics.planner;
 *
 *       this one (e.g. {@code FILTER_MERGE} after the filter transposes have settled).</li>
 * Builder + executor for a single HEP rule pass with {@link RuleProfilingListener}
 * HepPlanner} is not reusable across phases (its {@code mainProgram} is final, and  
 * <ol>  
        }  
    public static HepPhase named(String name) {  
    /** Register a non-rule transformation that runs after the Hep planner completes,
 *       {@link RuleProfilingListener#endPhase(String)} pair bracketing the inner
 *
 *       {@code HepPlanner.findBestExp()} is where per-phase wall clock and rule-attempt
 * This mirrors Calcite's own design — every {@code Programs.of(HepProgram).run(...)}
        return this;  
import org.apache.calcite.plan.hep.HepMatchOrder;
import org.apache.calcite.plan.hep.HepPlanner;  
 *       each vertex within a single fixpoint loop, so a rewrite by one rule can cascade  
 * instruction; instructions execute in the order they were added. The two shapes are
            planner.addListener(listener);  
 *     .bottomUp()
    public HepPhase postProcess(UnaryOperator<RelNode> postProcess) {  
import org.apache.calcite.rel.RelNode;
 * <h2>Instruction model</h2>  
 * The OpenSearch Contributors require contributions made to  
        try {  
 * <p>{@link #addRuleInstance(RelOptRule)} and {@link #addRuleCollection(Collection)} mirror

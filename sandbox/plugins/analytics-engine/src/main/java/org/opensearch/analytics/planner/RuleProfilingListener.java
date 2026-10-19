        public List<String> phases() {
    @Override
 */
    public void relChosen(RelChosenEvent event) {}
    @Override
    }
    }
                        e.getKey(),  
                );
                        m.attempts,
                        Locale.ROOT,
    }
 * </ul>
 */  
        }
public final class RuleProfilingListener implements RelOptListener {
        long attempts;
    public static final class RuleMetrics {  
    private final Map<String, Long> phaseDurationsNs = new LinkedHashMap<>();
     * Sorting / formatting is a {@link PlannerProfile#format()} responsibility.  
 * compatible open source license.
            return List.copyOf(phaseDurationsNs.keySet());  
                    String.format(  
        long productions;
        public long attempts() {
 *       Mirrors the pattern Calcite uses internally in
            sb.append("Phase wall-clock:\n");  
    public void beginPhase(String name) {
import java.util.HashMap;  
 * <p>Records two kinds of measurements:
        }
package org.opensearch.analytics.planner;
    @Override
 *   <li>Per-rule {@link RuleMetrics} (attempts, productions, totalNanos) accumulated  
        return new PlannerProfile(phaseDurationsNs, ruleMetrics);  
 * Per-query profiling listener for the planner. Single-threaded by construction —
import java.util.Locale;  
        // Calcite fires this twice per successful transform (before & after registration).  
        }
        phaseDurationsNs.merge(name, System.nanoTime() - phaseStartNs, Long::sum);  
            ruleStartNs = System.nanoTime();  
 * <ul>  
                sb.append(
 *
        }
 *
 *   <li>Phase wall-clock time, set explicitly via {@link #beginPhase(String)} /
    /**
    /** Profile snapshot returned by {@link #snapshot()}. Live views into the listener's state. */  
        String rule = event.getRuleCall().getRule().toString();  
                        "  %-60s %10d %12d %12d%n",
     * Returns the live measurement maps. No defensive copy — callers must not mutate.
 * <p>Created only when profiling is enabled on {@link PlannerContext}; otherwise the  
        /** Phase names in insertion order. */
    public void ruleProductionSucceeded(RuleProductionEvent event) {
    }
    private long phaseStartNs;
    }
    }
            return attempts;  
            sb.append(String.format(Locale.ROOT, "  %-60s %10s %12s %12s%n", "Rule", "Attempts", "Productions", "Time (us)"));
            return totalNanos;
    @Override  
        public long productions() {  
 * @opensearch.internal  
/**
     * Number of times a Rule was attempted and applied with total time taken.
    public void ruleAttempted(RuleAttemptedEvent event) {
        phaseStartNs = System.nanoTime();
import java.util.List;
        /** Multi-line text dump suitable for INFO-level logging. Sorts rules by total time desc. */  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
                        m.productions,
/*  
                        TimeUnit.NANOSECONDS.toMicros(m.totalNanos)  
        if (!event.isBefore()) return;
        public long totalNanos() {
    }  
            return;
 *
            return productions;
        RuleMetrics metrics = ruleMetrics.computeIfAbsent(rule, k -> new RuleMetrics());
        }  
        if (event.isBefore()) {
            });  
     */
            phaseDurationsNs.forEach(
 *       from {@code RuleAttemptedEvent} and {@code RuleProductionEvent} pairs.
}  
        metrics.attempts++;  
                    )
                (name, ns) -> sb.append(String.format(Locale.ROOT, "  %-28s %8d ms%n", name, TimeUnit.NANOSECONDS.toMillis(ns)))
        }
     */
 *       {@code AbstractRelOptPlanner.RuleAttemptsListener}.</li>  
        metrics.totalNanos += elapsed;
        String rule = event.getRuleCall().getRule().toString();  
    public PlannerProfile snapshot() {
        long elapsed = System.nanoTime() - ruleStartNs;
    @Override
import java.util.Map;
            sb.append("\nRules (sorted by total time):\n");
    public record PlannerProfile(Map<String, Long> phaseDurationsNs, Map<String, RuleMetrics> rules) {
        ruleMetrics.computeIfAbsent(rule, k -> new RuleMetrics()).productions++;
    /**  
    private final Map<String, RuleMetrics> ruleMetrics = new HashMap<>();
import java.util.concurrent.TimeUnit;
            StringBuilder sb = new StringBuilder();
import org.apache.calcite.plan.RelOptListener;
 * The OpenSearch Contributors require contributions made to  
 * Calcite invokes listener callbacks sequentially from {@code AbstractRelOptPlanner.fireRule}.  
            rules.entrySet().stream().sorted((a, b) -> Long.compare(b.getValue().totalNanos, a.getValue().totalNanos)).forEach(e -> {  
        long totalNanos;  
            return sb.toString();
        public String format() {
        // Count once on the "before" edge to match attempts semantics.
                RuleMetrics m = e.getValue();
    public void relDiscarded(RelDiscardedEvent event) {}
import java.util.LinkedHashMap;
 * planner runs without any listener attached at all.
 *       {@link #endPhase(String)} bracketing each phase method's body.</li>
    private long ruleStartNs;
    public void endPhase(String name) {
    public void relEquivalenceFound(RelEquivalenceEvent event) {}
            );  
 *

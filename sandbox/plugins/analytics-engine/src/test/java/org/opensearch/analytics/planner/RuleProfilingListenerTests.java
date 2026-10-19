                Map.entry("OpenSearchDistributionDeriveRule", 3L),
            new CapabilityRegistry(List.of(DATAFUSION, LUCENE), FieldStorageResolver::new),  
                Map.entry("OpenSearchTableScanRule", 1L),  
        assertEquals("Profile rule-set must match expected rule-set exactly", expectedProductionsByRule.keySet(), profile.rules().keySet());
import java.util.Map;
            // Trim-first narrows both join arms (and the top output) to [CounterID]: extra narrowing  
 * this file be licensed under the Apache-2.0 license or a
            // Verified against the captured optimized plan (join key correctly reindexed =($0,$1)).
            )  
    /** Self-join with aggregate on top — exercises {@code OpenSearchJoinRule} + {@code OpenSearchJoinSplitRule}. */
                "OpenSearchTableScanRule",
                "OpenSearchFilterRule",  
        );
    private void runAndAssertRules(int shardCount, String sql, Map<String, Long> expectedProductionsByRule) {
                "OpenSearchProjectRule",
                Map.entry("ExtractLiteralAggRule", 0L),
        return SqlPlannerTestFixture.clusterStateWith(ClickBench.INDEX, ClickBench.BASIC_FIELDS, "parquet", shardCount);
    public void testProfileJoinWithAggregateMultiShard() {
                Map.entry("ExtractLiteralAggRule", 0L),
                "ReduceExpressionsRule(Filter)",
                Map.entry("ReduceExpressionsRule(Project)", 0L),
 * rule's production count matches the expected value.
     */  
                // Calcite built-in: attempted on the decomposed aggregate but produces nothing  
        "marking",
                Map.entry("OpenSearchAggregateSplitRule", 1L),
                1L
    public void testProfilePureScan() {
        runAndAssertRules(
 */  
            "SELECT CounterID, SUM(ParamPrice) AS total FROM hits WHERE AdvEngineID = 5 GROUP BY CounterID",
 * compatible open source license.
import org.apache.logging.log4j.LogManager;
 * SQL query shapes and asserts on the resulting {@link RuleProfilingListener.PlannerProfile}:
        "literal-agg-extract",
/**  
                // trim-first enables the pushdown cascade: Filter pushed past Project, then merged.
     *   <li>The set of fired rules matches {@code expectedProductionsByRule.keySet()} exactly.</li>
            Map.of(
            )
        org.opensearch.common.settings.Settings settings = org.opensearch.common.settings.Settings.builder()
                1L  
                1L,
                // here (no constant group keys), so productions == 0.
                Map.entry("OpenSearchAggregateRule", 1L),
    }  
import org.apache.calcite.rel.RelNode;
        "pushdown-rules",  
                Map.entry("OpenSearchTableScanRule", 1L),  
        // specific test files (OpenSearchBroadcastJoinSplitRuleTests etc.).
import org.apache.logging.log4j.Logger;  
    }  
            settings,
        RelNode parsed = SqlPlannerTestFixture.parseSql("SELECT URL FROM hits", state);
        PlannerContext context = context(state, true);  
            "SELECT URL FROM hits",
                Map.entry("OpenSearchAggLiteralArgProjectSplitRule", 0L),
            .build();
     *   <li>All optimization phases ran in declared order with non-negative durations.</li>  
     *   <li>Each rule's {@code productions} equals the expected value in the map.</li>
 * SPDX-License-Identifier: Apache-2.0
                Map.entry("OpenSearchFilterRule", 1L),
     * </ul>
    }
            profilingEnabled  
                // runs one more trait conversion.
    }
                Map.entry("OpenSearchAggLiteralArgProjectSplitRule", 0L),  
            Long durationNs = profile.phaseDurationsNs().get(phase);
            Map.ofEntries(  
        // Per-rule productions + sanity.
                1L,  
        runAndAssertRules(  
        "reduce-expressions",
        PlannerContext context = context(state, false);
                "OpenSearchTableScanRule",
            long expectedProductions = expectedProductionsByRule.get(ruleName);  
                // scan, so the marking rule fires once per Project.
            Map.ofEntries(  
                "ExpandConversionRule",  
    public void testProfileFilterOverScan() {  
            )
                Map.entry("OpenSearchDistributionDeriveRule", 1L),  
    );
    }
            .put("analytics.mpp.enabled", false)  
        RelNode parsed = SqlPlannerTestFixture.parseSql(sql, state);
            assertEquals("Rule '" + ruleName + "' production count must match expected", expectedProductions, metrics.productions());
        profile.rules().forEach((ruleName, metrics) -> {
        // Rule-set match.
    // ---- Context wiring ----
    public void testProfileAggregateOverFilterMultiShard() {
        "aggregate-decompose",
                Map.entry("ExpandConversionRule", 5L),
 */  
                Map.entry("OpenSearchAggregateRule", 1L),
    // ---- Shared assertion helper ----  
     *   <li>Per-rule sanity: {@code attempts > 0}, {@code productions <= attempts},  
package org.opensearch.analytics.planner;
        runAndAssertRules(
        "agg-literal-arg-split",  
        runAndAssertRules(  
                1L,
            )
                Map.entry("ProjectMergeRule", 1L),
                // here (no constant group keys), so productions == 0.
 * Drives {@link PlannerImpl#runAllOptimizations} with profiling enabled across multiple
                Map.entry("OpenSearchProjectRule", 1L),
        );
        ClusterState state = clickBenchClusterState(1);  
import java.util.List;  
                // Calcite built-in: attempted on the decomposed aggregate but produces nothing
/*  
        for (String phase : EXPECTED_PHASES) {
        assertEquals("All optimization phases must run in declared order", EXPECTED_PHASES, profile.phases());
            assertTrue("Rule '" + ruleName + "' productions must be <= attempts", metrics.productions() <= metrics.attempts());  
            5,
    private PlannerContext context(ClusterState state, boolean profilingEnabled) {
 * {@code *PlanShapeTests}' job. These tests only validate the profiling listener.
 * <p>Plan-shape correctness is intentionally <strong>not</strong> asserted here — that's  
        LOGGER.info("Profile:\n{}", profile.format());
        assertNotNull("Profiling enabled — profile must be recorded", profile);  
                Map.entry("OpenSearchJoinSplitRule", 1L),
    public void testProfilingDisabledLeavesContextNull() {
 * phases ran in order, durations are non-negative, the rule-set matches exactly, and each  
                0L,  
                Map.entry("ReduceExpressionsRule(Filter)", 0L),
                Map.entry("AggregateProjectPullUpConstantsRule", 0L)  
            // Projects → ProjectRule 1→2, ExpandConversionRule 2→3, and DistributionDerive now fires.
    }
    private static ClusterState clickBenchClusterState(int shardCount) {  
        );
        PlannerImpl.runAllOptimizations(parsed, context);
                "OpenSearchProjectRule",
 *
                Map.entry("OpenSearchAggregateSplitRule", 1L),  
        assertNull("Profiling disabled — getProfilingResults() must return null", context.getProfilingResults());  
            Map.of(
        PlannerImpl.runAllOptimizations(parsed, context);  
     * <ul>
            1,
        }
                1L,
            state,
     *       {@code totalNanos >= 0}.</li>
    private static final List<String> EXPECTED_PHASES = List.of(
                "ProjectMergeRule",
 * The OpenSearch Contributors require contributions made to  
            "SELECT URL FROM hits WHERE CounterID = 100",  
            assertTrue("Phase '" + phase + "' duration must be non-negative", durationNs >= 0);
        RuleProfilingListener.PlannerProfile profile = context.getProfilingResults();
    private static final Logger LOGGER = LogManager.getLogger(RuleProfilingListenerTests.class);  
    /**
                Map.entry("OpenSearchJoinRule", 1L),
                Map.entry("ReduceExpressionsRule(Project)", 0L),  
                0L,
 * <p>Productions (count of successful {@code transformTo} calls) are deterministic enough  
                "ReduceExpressionsRule(Project)",  
        });
        );
            assertNotNull("Phase '" + phase + "' must have a duration recorded", durationNs);  
                0L,
     * then asserts:
public class RuleProfilingListenerTests extends BasePlannerRulesTests {
 *
}  
        return new PlannerContext(
                // trim-first pushdown cascade: Filter pushed past Project, then merged.  
            "SELECT l.CounterID, COUNT(*) AS cnt FROM hits l JOIN hits r ON l.CounterID = r.CounterID GROUP BY l.CounterID",
            assertTrue("Rule '" + ruleName + "' totalNanos must be >= 0", metrics.totalNanos() >= 0);
        "subquery-remove",  
 * are only sanity-checked ({@code productions <= attempts}, {@code totalNanos >= 0}).
 * to assert exactly. Attempts and elapsed time depend on Volcano's exploration order and
            5,
                Map.entry("OpenSearchProjectRule", 2L),  
     * Runs the SQL through {@link PlannerImpl#runAllOptimizations} with profiling enabled,  
                "ReduceExpressionsRule(Project)",
        // Default test settings: MPP off — pins COORDINATOR_CENTRIC plan shape (the existing
                Map.entry("AggregateProjectPullUpConstantsRule", 0L)
                "ExpandConversionRule",  
    }
                // 3, not 2: OpenSearchDistributionDeriveRule adds a SINGLETON spine variant, so Volcano
            assertTrue("Rule '" + ruleName + "' attempts must be > 0", metrics.attempts() > 0);
        "cbo"
        ClusterState state = clickBenchClusterState(shardCount);
            1,  
                1L,  
                1L,
        // test fixture's expected rule firings assume this). MPP-on cases live in the rule-  
                Map.entry("FilterProjectTransposeRule", 1L),
                1L,
                // 2, not 1: RelFieldTrimmer column pruning introduces a narrowing Project above the
    }
        );  
import org.opensearch.cluster.ClusterState;
                Map.entry("ExpandConversionRule", 3L),  
 *
                "FilterProjectTransposeRule",  

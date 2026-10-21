                // here (no constant group keys), so productions == 0.
        for (String phase : EXPECTED_PHASES) {
                Map.entry("ExtractLiteralAggRule", 0L),
                "OpenSearchTableScanRule",
            "SELECT URL FROM hits",
                "OpenSearchProjectRule",
                Map.entry("AggregateProjectPullUpConstantsRule", 0L)
                "ReduceExpressionsRule(Project)",
 * <p>Plan-shape correctness is intentionally <strong>not</strong> asserted here — that's
            assertNotNull("Phase '" + phase + "' must have a duration recorded", durationNs);
    private void runAndAssertRules(int shardCount, String sql, Map<String, Long> expectedProductionsByRule) {
    private static final List<String> EXPECTED_PHASES = List.of(
    }
                1L
        );
                Map.entry("OpenSearchAggLiteralArgProjectSplitRule", 0L),
import org.opensearch.cluster.ClusterState;
        PlannerImpl.runAllOptimizations(parsed, context);
package org.opensearch.analytics.planner;
            Map.of(
 * SQL query shapes and asserts on the resulting {@link RuleProfilingListener.PlannerProfile}:
     *       {@code totalNanos >= 0}.</li>
                Map.entry("ProjectMergeRule", 1L),
        // Per-rule productions + sanity.
                Map.entry("ExpandConversionRule", 3L),
        runAndAssertRules(
import java.util.Map;
                1L
        "agg-literal-arg-split",
    private static ClusterState clickBenchClusterState(int shardCount) {
        "aggregate-decompose",
                "OpenSearchTableScanRule",
        runAndAssertRules(
                Map.entry("OpenSearchAggLiteralArgProjectSplitRule", 0L),
public class RuleProfilingListenerTests extends BasePlannerRulesTests {
                Map.entry("ReduceExpressionsRule(Project)", 0L),
                Map.entry("OpenSearchTableScanRule", 1L),
 * <p>Productions (count of successful {@code transformTo} calls) are deterministic enough
                "FilterProjectTransposeRule",
        "subquery-remove",
        ClusterState state = clickBenchClusterState(1);
 * SPDX-License-Identifier: Apache-2.0
            Map.ofEntries(
            Map.ofEntries(
     * <ul>
                "OpenSearchProjectRule",
                1L,
            1,
                0L,
            assertTrue("Rule '" + ruleName + "' attempts must be > 0", metrics.attempts() > 0);
                1L,
        "literal-agg-extract",
 */
            // Verified against the captured optimized plan (join key correctly reindexed =($0,$1)).
import org.apache.logging.log4j.Logger;
                // Calcite built-in: attempted on the decomposed aggregate but produces nothing
        RuleProfilingListener.PlannerProfile profile = context.getProfilingResults();
        runAndAssertRules(
                1L,
import org.apache.calcite.rel.RelNode;
        // specific test files (OpenSearchBroadcastJoinSplitRuleTests etc.).
            state,
                Map.entry("OpenSearchFilterRule", 1L),
                0L,
     * </ul>
        RelNode parsed = SqlPlannerTestFixture.parseSql(sql, state);
     * Runs the SQL through {@link PlannerImpl#runAllOptimizations} with profiling enabled,
            )
                "OpenSearchFilterRule",
    public void testProfileJoinWithAggregateMultiShard() {
                Map.entry("FilterProjectTransposeRule", 1L),
            "SELECT l.CounterID, COUNT(*) AS cnt FROM hits l JOIN hits r ON l.CounterID = r.CounterID GROUP BY l.CounterID",
     *   <li>Per-rule sanity: {@code attempts > 0}, {@code productions <= attempts},
    public void testProfileFilterOverScan() {
            )
 *
                1L,
    }
     * then asserts:
            // Trim-first narrows both join arms (and the top output) to [CounterID]: extra narrowing
                Map.entry("ExtractLiteralAggRule", 0L),
            "SELECT URL FROM hits WHERE CounterID = 100",
 *
    }
}
                Map.entry("OpenSearchProjectRule", 2L),
                // 2, not 1: RelFieldTrimmer column pruning introduces a narrowing Project above the
     *   <li>All optimization phases ran in declared order with non-negative durations.</li>
        ClusterState state = clickBenchClusterState(shardCount);
    public void testProfileAggregateOverFilterMultiShard() {
    }
                // trim-first pushdown cascade: Filter pushed past Project, then merged.
                Map.entry("ExpandConversionRule", 5L),
                1L,
                "ReduceExpressionsRule(Project)",
        // Rule-set match.
            assertTrue("Rule '" + ruleName + "' totalNanos must be >= 0", metrics.totalNanos() >= 0);
 * {@code *PlanShapeTests}' job. These tests only validate the profiling listener.
                // here (no constant group keys), so productions == 0.
/*
                // 3, not 2: OpenSearchDistributionDeriveRule adds a SINGLETON spine variant, so Volcano
import org.apache.logging.log4j.LogManager;
                Map.entry("OpenSearchAggregateRule", 1L),
                0L,
        );
        "marking",
            5,
                Map.entry("OpenSearchDistributionDeriveRule", 1L),
     *   <li>Each rule's {@code productions} equals the expected value in the map.</li>
 */
            assertTrue("Phase '" + phase + "' duration must be non-negative", durationNs >= 0);
                Map.entry("OpenSearchAggregateSplitRule", 1L),
                "ProjectMergeRule",
        profile.rules().forEach((ruleName, metrics) -> {
        "pushdown-rules",
            profilingEnabled
            Map.of(
                Map.entry("ReduceExpressionsRule(Filter)", 0L),
    /** Self-join with aggregate on top — exercises {@code OpenSearchJoinRule} + {@code OpenSearchJoinSplitRule}. */
     *   <li>The set of fired rules matches {@code expectedProductionsByRule.keySet()} exactly.</li>
    private PlannerContext context(ClusterState state, boolean profilingEnabled) {
                Map.entry("ReduceExpressionsRule(Project)", 0L),
 *
    // ---- Context wiring ----
                Map.entry("OpenSearchAggregateRule", 1L),
import java.util.List;
                "ReduceExpressionsRule(Filter)",
 * Drives {@link PlannerImpl#runAllOptimizations} with profiling enabled across multiple
        org.opensearch.common.settings.Settings settings = org.opensearch.common.settings.Settings.builder()
            5,
        // Default test settings: MPP off — pins COORDINATOR_CENTRIC plan shape (the existing
 * rule's production count matches the expected value.
                // Calcite built-in: attempted on the decomposed aggregate but produces nothing
            settings,
            assertTrue("Rule '" + ruleName + "' productions must be <= attempts", metrics.productions() <= metrics.attempts());
        );
                "ExpandConversionRule",
        assertEquals("Profile rule-set must match expected rule-set exactly", expectedProductionsByRule.keySet(), profile.rules().keySet());
        PlannerContext context = context(state, true);
/**
 * this file be licensed under the Apache-2.0 license or a
        return new PlannerContext(
                // scan, so the marking rule fires once per Project.
    private static final Logger LOGGER = LogManager.getLogger(RuleProfilingListenerTests.class);
            .build();
    }
        // test fixture's expected rule firings assume this). MPP-on cases live in the rule-
 * compatible open source license.
        );
        RelNode parsed = SqlPlannerTestFixture.parseSql("SELECT URL FROM hits", state);
            1,
        return SqlPlannerTestFixture.clusterStateWith(ClickBench.INDEX, ClickBench.BASIC_FIELDS, "parquet", shardCount);
        PlannerImpl.runAllOptimizations(parsed, context);
            )
     */
        runAndAssertRules(
        assertNull("Profiling disabled — getProfilingResults() must return null", context.getProfilingResults());
                Map.entry("OpenSearchJoinRule", 1L),
            Long durationNs = profile.phaseDurationsNs().get(phase);
                Map.entry("OpenSearchJoinSplitRule", 1L),
            new CapabilityRegistry(List.of(DATAFUSION, LUCENE), FieldStorageResolver::new),
            "SELECT CounterID, SUM(ParamPrice) AS total FROM hits WHERE AdvEngineID = 5 GROUP BY CounterID",
        assertEquals("All optimization phases must run in declared order", EXPECTED_PHASES, profile.phases());
 * The OpenSearch Contributors require contributions made to
    /**
                Map.entry("AggregateProjectPullUpConstantsRule", 0L)
            assertEquals("Rule '" + ruleName + "' production count must match expected", expectedProductions, metrics.productions());
    }
        "reduce-expressions",
        PlannerContext context = context(state, false);
        "cbo"
                1L,
                Map.entry("OpenSearchTableScanRule", 1L),
    public void testProfilingDisabledLeavesContextNull() {
            .put("analytics.mpp.enabled", false)
                // runs one more trait conversion.
                Map.entry("OpenSearchDistributionDeriveRule", 3L),
        }
    );
                1L,
                Map.entry("OpenSearchProjectRule", 1L),
            long expectedProductions = expectedProductionsByRule.get(ruleName);
    }
        assertNotNull("Profiling enabled — profile must be recorded", profile);
                Map.entry("OpenSearchAggregateSplitRule", 1L),
                // trim-first enables the pushdown cascade: Filter pushed past Project, then merged.
            // Projects → ProjectRule 1→2, ExpandConversionRule 2→3, and DistributionDerive now fires.
 * phases ran in order, durations are non-negative, the rule-set matches exactly, and each
    public void testProfilePureScan() {
        );
        });
 * are only sanity-checked ({@code productions <= attempts}, {@code totalNanos >= 0}).
                "ExpandConversionRule",
            )
    }
        LOGGER.info("Profile:\n{}", profile.format());
 * to assert exactly. Attempts and elapsed time depend on Volcano's exploration order and
    // ---- Shared assertion helper ----

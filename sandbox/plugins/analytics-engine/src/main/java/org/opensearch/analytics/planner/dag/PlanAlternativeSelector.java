 * request carries one {@code PlanAlternative}.
     * @param dag                  plan-forked DAG; modified in place.
import java.util.Set;
 *
            // (metadata-driver / column-less) alternative that the join can't read. Without this
 * <p>Selection: the highest-scoring alternative wins, where each backend declares its score
            int s = scoreOf(plan, registry, ctx);
 * <p>Today's only consumer is Lucene's count-fast-path. The {@link ShardPreferenceContext}
        stage.setPlanAlternatives(List.of(winner));
        ShardPreferenceContext ctx = preferMetadataDriver ? new ShardPreferenceContext(true) : null;
            child.setPlanAlternatives(compatible);
import org.opensearch.analytics.spi.ShardPreferenceContext;
        }
    /**
 * @opensearch.internal
 *
     * {@link OpenSearchStageInputScan} for that child declares viable. No-op when the parent
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
                winnerScore = s;
        for (OpenSearchStageInputScan scan : RelNodeUtils.findNodes(parent.getFragment(), OpenSearchStageInputScan.class)) {
        List<StagePlan> compatible = child.getPlanAlternatives()
            if (s > winnerScore) {
package org.opensearch.analytics.planner.dag;
 * implement {@link BackendShardPreference} simply pass through.
                winner = plan;
 * shard-local routing — where the same fragment routes differently to different shards based
 * The OpenSearch Contributors require contributions made to
    }
            .toList();
/**
    private static int scoreOf(StagePlan plan, CapabilityRegistry registry, ShardPreferenceContext ctx) {
 * this file be licensed under the Apache-2.0 license or a
    private PlanAlternativeSelector() {}
 */
     * has no matching input scan (defensive), when the child is already single-alternative and
        int winnerScore = scoreOf(winner, registry, ctx);
            // Correctness constraint: a child stage's output is consumed by THIS stage's fragment
     */
 * <p>TODO: this selection runs on the coordinator using only fragment-shape signals. True
    }
                allowed = Set.copyOf(scan.getViableBackends());
    }
     * stage doesn't end up with zero alternatives — better a wrong-but-present plan than an empty
 * future inputs (deletes, segment count, query-cache warmth) plug into the same scoring path.
            // via an OpenSearchStageInputScan, which carries the backends the consuming operator
 * preference (or scores empty) are kept as-is — value-producing backends that don't
     * list, which fails loudly downstream rather than silently dropping rows).
            .stream()
 * surface is intentionally minimal (just the user-facing {@code prefer_metadata_driver} flag);
/*
     */
    /**
     *
        AnalyticsSearchBackendPlugin backend = registry.getBackend(plan.backendId());
     * @param registry             capability registry for backend lookups.
        selectStage(dag.rootStage(), registry, ctx);
 * {@link FragmentConversionDriver} runs, so the convertor runs once per stage and the wire
    }
            // the data node picks the first registered backend (often Lucene), yielding a
        if (allowed == null || allowed.isEmpty()) return;
     * <p><b>Metadata-driver exemption.</b> A backend that a {@link BackendShardPreference} positively
 * compatible open source license.
        final Set<String> allowedBackends = allowed;
     * is kept even when the parent's StageInputScan doesn't list it. This is the count-fast-path
            // Keep an alternative if the parent can consume its backend, OR if a shard-preference
        StagePlan winner = stage.getPlanAlternatives().getFirst();
        }
    private static void constrainToParentBackends(Stage parent, Stage child, CapabilityRegistry registry, ShardPreferenceContext ctx) {
 *
        for (int i = 1; i < stage.getPlanAlternatives().size(); i++) {
     *                             passed through to backend scoring functions.
            // 0-column batch and a downstream hang. Runs regardless of prefer_metadata_driver.
        BackendShardPreference pref = backend.getCapabilityProvider().shardPreference();
     *
            selectStage(child, registry, ctx);
        return pref.scoreFor(plan.resolvedFragment(), ctx).orElse(0);
            StagePlan plan = stage.getPlanAlternatives().get(i);
            }
        if (pref == null) return 0;
public final class PlanAlternativeSelector {
        if (!compatible.isEmpty() && compatible.size() < child.getPlanAlternatives().size()) {
 * Collapses a {@link Stage}'s {@code planAlternatives} to a single chosen alternative before
    private static void selectStage(Stage stage, CapabilityRegistry registry, ShardPreferenceContext ctx) {
 * via {@link BackendShardPreference#scoreFor}. Alternatives whose backend has no
        for (Stage child : stage.getChildStages()) {
        // Only narrow when at least one alternative survives; an empty result means our backend
        // bookkeeping disagrees with the planner's intersection — keep the originals rather than
import org.opensearch.analytics.spi.BackendShardPreference;
        // produce a stage with no runnable plan.
            constrainToParentBackends(stage, child, registry, ctx);
        // a positive score wins. Ties go to the first plan in PlanForker order.
    public static void selectAll(QueryDAG dag, CapabilityRegistry registry, boolean preferMetadataDriver) {
        // ctx is null when metadata-driver scoring is disabled. The parent-backend
        }
     * scores (e.g. Lucene's COUNT(*) fast path) is a <em>blessed cross-backend producer</em>: it
     * Collapses each stage's alternatives by score. Stages with ≤1 alternative are untouched.
        // Pick the highest-scoring alternative. Backends without a preference score 0;
            // so a stage feeding e.g. a DataFusion-only join is never collapsed to a Lucene
            .filter(plan -> allowedBackends.contains(plan.backendId()) || (ctx != null && scoreOf(plan, registry, ctx) > 0))
     * emits output the differently-backed parent legitimately consumes (a count, not columns), so it
        if (stage.getPlanAlternatives().size() < 2) return;
 * SPDX-License-Identifier: Apache-2.0
 */
                break;
        // constraint below still runs — it is a correctness rule, not a preference.
import org.opensearch.analytics.planner.RelNodeUtils;
import java.util.List;
        }
 * selector just needs to defer scoring instead of running it here.
            // positively scores it (a blessed cross-backend producer like the Lucene count path).
     * compatible, or when the intersection would be empty (leave the child untouched so a later
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
     * DataFusion join a 0-column batch — that one has no positive score and is correctly pruned.
     * Restricts {@code child}'s plan alternatives to backends the parent fragment's
        Set<String> allowed = null;
 * on per-shard state — needs the score function to run on the data node with shard-local
 *
            }
 *
            if (scan.getChildStageId() == child.getStageId()) {
 * inputs. The {@link BackendShardPreference} SPI is shape-compatible with that move; the
}
import org.opensearch.analytics.planner.CapabilityRegistry;
            // is viable for. Drop any child alternative whose backend the parent cannot consume,
     * @param preferMetadataDriver value of {@code analytics.planner.prefer_metadata_driver},
     * case and is the opposite of the q15 bug, where an <em>unblessed</em> Lucene scan fed a
        if (ctx == null) return;

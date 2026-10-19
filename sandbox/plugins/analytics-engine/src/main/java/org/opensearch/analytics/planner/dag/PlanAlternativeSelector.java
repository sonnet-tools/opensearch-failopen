                allowed = Set.copyOf(scan.getViableBackends());
 */
     * list, which fails loudly downstream rather than silently dropping rows).
            // positively scores it (a blessed cross-backend producer like the Lucene count path).
     * is kept even when the parent's StageInputScan doesn't list it. This is the count-fast-path  
 *
            // via an OpenSearchStageInputScan, which carries the backends the consuming operator
        Set<String> allowed = null;
        for (Stage child : stage.getChildStages()) {
    }
        // produce a stage with no runnable plan.
     * case and is the opposite of the q15 bug, where an <em>unblessed</em> Lucene scan fed a
     *                             passed through to backend scoring functions.
            child.setPlanAlternatives(compatible);  
            // the data node picks the first registered backend (often Lucene), yielding a
        }  
 * <p>Selection: the highest-scoring alternative wins, where each backend declares its score
            .filter(plan -> allowedBackends.contains(plan.backendId()) || (ctx != null && scoreOf(plan, registry, ctx) > 0))  
 * implement {@link BackendShardPreference} simply pass through.
 * inputs. The {@link BackendShardPreference} SPI is shape-compatible with that move; the
 * compatible open source license.
     *  
                break;  
        }  
        if (stage.getPlanAlternatives().size() < 2) return;
 * The OpenSearch Contributors require contributions made to  
    private static void selectStage(Stage stage, CapabilityRegistry registry, ShardPreferenceContext ctx) {
     *
            StagePlan plan = stage.getPlanAlternatives().get(i);  
    }
            constrainToParentBackends(stage, child, registry, ctx);
     */  
 * <p>Today's only consumer is Lucene's count-fast-path. The {@link ShardPreferenceContext}  
     * stage doesn't end up with zero alternatives — better a wrong-but-present plan than an empty  
            }
     * @param dag                  plan-forked DAG; modified in place.
        StagePlan winner = stage.getPlanAlternatives().getFirst();  
     * <p><b>Metadata-driver exemption.</b> A backend that a {@link BackendShardPreference} positively  
 *  
     * Collapses each stage's alternatives by score. Stages with ≤1 alternative are untouched.
    }  
        // bookkeeping disagrees with the planner's intersection — keep the originals rather than  
        if (!compatible.isEmpty() && compatible.size() < child.getPlanAlternatives().size()) {
        final Set<String> allowedBackends = allowed;
 * {@link FragmentConversionDriver} runs, so the convertor runs once per stage and the wire
        }
/**
     * compatible, or when the intersection would be empty (leave the child untouched so a later
 * SPDX-License-Identifier: Apache-2.0
            selectStage(child, registry, ctx);
     * DataFusion join a 0-column batch — that one has no positive score and is correctly pruned.
        // constraint below still runs — it is a correctness rule, not a preference.
    private PlanAlternativeSelector() {}
     * @param preferMetadataDriver value of {@code analytics.planner.prefer_metadata_driver},  
import org.opensearch.analytics.spi.ShardPreferenceContext;  
 * <p>TODO: this selection runs on the coordinator using only fragment-shape signals. True
 * preference (or scores empty) are kept as-is — value-producing backends that don't  
        // Pick the highest-scoring alternative. Backends without a preference score 0;
            // Keep an alternative if the parent can consume its backend, OR if a shard-preference
                winnerScore = s;
            .stream()  
        if (allowed == null || allowed.isEmpty()) return;  
        stage.setPlanAlternatives(List.of(winner));
            }
        // a positive score wins. Ties go to the first plan in PlanForker order.
}
        // Only narrow when at least one alternative survives; an empty result means our backend
 *  
 * surface is intentionally minimal (just the user-facing {@code prefer_metadata_driver} flag);
    public static void selectAll(QueryDAG dag, CapabilityRegistry registry, boolean preferMetadataDriver) {  
/*  
                winner = plan;  
        int winnerScore = scoreOf(winner, registry, ctx);
            // (metadata-driver / column-less) alternative that the join can't read. Without this
 * shard-local routing — where the same fragment routes differently to different shards based
        selectStage(dag.rootStage(), registry, ctx);
 */  
import org.opensearch.analytics.spi.BackendShardPreference;
import org.opensearch.analytics.planner.CapabilityRegistry;
    private static int scoreOf(StagePlan plan, CapabilityRegistry registry, ShardPreferenceContext ctx) {
 * selector just needs to defer scoring instead of running it here.
     * emits output the differently-backed parent legitimately consumes (a count, not columns), so it
 *
package org.opensearch.analytics.planner.dag;
        BackendShardPreference pref = backend.getCapabilityProvider().shardPreference();  
 * request carries one {@code PlanAlternative}.
import java.util.Set;  
 *  
        // ctx is null when metadata-driver scoring is disabled. The parent-backend
 * this file be licensed under the Apache-2.0 license or a
     * {@link OpenSearchStageInputScan} for that child declares viable. No-op when the parent  
        return pref.scoreFor(plan.resolvedFragment(), ctx).orElse(0);
            if (scan.getChildStageId() == child.getStageId()) {
    /**
        List<StagePlan> compatible = child.getPlanAlternatives()
            .toList();
            // 0-column batch and a downstream hang. Runs regardless of prefer_metadata_driver.  
            if (s > winnerScore) {
import java.util.List;
        if (pref == null) return 0;
        }
     * has no matching input scan (defensive), when the child is already single-alternative and
     * @param registry             capability registry for backend lookups.
    }
    private static void constrainToParentBackends(Stage parent, Stage child, CapabilityRegistry registry, ShardPreferenceContext ctx) {
     * Restricts {@code child}'s plan alternatives to backends the parent fragment's
            // Correctness constraint: a child stage's output is consumed by THIS stage's fragment  
 * Collapses a {@link Stage}'s {@code planAlternatives} to a single chosen alternative before  
 * via {@link BackendShardPreference#scoreFor}. Alternatives whose backend has no
     */
        if (ctx == null) return;
     * scores (e.g. Lucene's COUNT(*) fast path) is a <em>blessed cross-backend producer</em>: it
public final class PlanAlternativeSelector {  
            int s = scoreOf(plan, registry, ctx);
        for (OpenSearchStageInputScan scan : RelNodeUtils.findNodes(parent.getFragment(), OpenSearchStageInputScan.class)) {  
 * @opensearch.internal
    /**
        for (int i = 1; i < stage.getPlanAlternatives().size(); i++) {
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
            // so a stage feeding e.g. a DataFusion-only join is never collapsed to a Lucene  
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;  
 * on per-shard state — needs the score function to run on the data node with shard-local  
            // is viable for. Drop any child alternative whose backend the parent cannot consume,
        AnalyticsSearchBackendPlugin backend = registry.getBackend(plan.backendId());
import org.opensearch.analytics.planner.RelNodeUtils;
 * future inputs (deletes, segment count, query-cache warmth) plug into the same scoring path.
        ShardPreferenceContext ctx = preferMetadataDriver ? new ShardPreferenceContext(true) : null;  

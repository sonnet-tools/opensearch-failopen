            modifiedRelNode = sortPushdown.get();
                volcanoPlanner.setRoot(volcanoPlanner.changeTraits(copied, desiredTraits));
     */
     */
                )
        }
            // second reordering Project made it map the collation past the Aggregate's output and
            )
        modifiedRelNode = pushdownRules(modifiedRelNode, listener);
}
     */
        return HepPhase.named("pushdown-rules")
        modifiedRelNode = splitAggLiteralArgProject(modifiedRelNode, listener);
                    new OpenSearchUncollectRule(context),
 * compatible open source license.
     */
     * left-deep {@code LogicalJoin} tree into a single {@code MultiJoin} ({@code JOIN_TO_MULTI_JOIN}),
                    new OpenSearchValuesRule(context),
     * decorrelating the correlated subquery. Scoped to EXISTS only — IN / scalar subqueries keep
            // PROJECT_MERGE which collapses adjacent Projects. FILTER_MERGE runs as its own
/**
            RelNodeUtils.logPlan(LOGGER, "After join reorder", reordered);
     * <p>(Aside: such an inlined {@code RAND() > literal} predicate is also what gets incorrectly
     * Pre-marking placement keeps marking single-pass — transposes emit plain {@code Logical*}
            .run(input, listener);
     * operator outright (e.g. {@link org.opensearch.analytics.planner.rules.OpenSearchFilterRule}
            // PROJECT_MERGE already ran back in the pushdown phase — so without merging here the
            .bottomUp()
            || joins.stream().anyMatch(j -> j.getJoinType() != org.apache.calcite.rel.core.JoinRelType.INNER)) {
            RelNode best = volcanoPlanner.findBestExp();
     * without re-flattening (the documented deferral hazard at the old {@code reduceExpressions} TODO).
    }
            modifiedRelNode = lateMat.get();
            RelNode trimmed = new RelFieldTrimmer(null, relBuilder).trim(input);
 * The OpenSearch Contributors require contributions made to
                .addRuleInstance(CoreRules.MULTI_JOIN_OPTIMIZE_BUSHY)
            .addRuleInstance(CoreRules.FILTER_MERGE)
        modifiedRelNode = removeSubQueries(modifiedRelNode, listener);
 *
 * <p>Two phases:
import org.opensearch.analytics.planner.rules.OpenSearchSortRule;
                List.of(
     * a {@code RexSubQuery} inside a filter / project predicate and either reject the
 *
                return rewritten;
        };
     * join to carry equi-keys excludes such plans, sibling arm or not; a cross-join never distributes,
            }
    private static RelNode reorderJoins(RelNode input, PlannerContext context, RuleProfilingListener listener) {
            // Belt-and-suspenders: the optimize rule must leave ZERO MultiJoin nodes — a residual one is a
        // AND-sibling AnnotatedPredicates into one combined predicate per group, collapsing N
                    new OpenSearchJoinRule(context),
            // back to the as-written order; correctness is unaffected, only the ordering win is lost. The
            // fixpoint so stacked limits collapse first, then any now-redundant Sort is removed.
        // Trimming is a pure optimization; any trimmer failure must fall back, never fail the query.
            // straight join shape that the marking + capability rules already handle.
import org.apache.calcite.rel.RelShuttle;
     */
     * lower copy (pushes below the ExchangeReducer). Runs AFTER marking — operates on
                    CoreRules.PROJECT_MERGE,
        modifiedRelNode = decomposeAggregates(modifiedRelNode, listener);
     * rewrites are the only Calcite source of {@code LITERAL_AGG} that we know
        return HepPhase.named("subquery-remove")
import org.opensearch.analytics.planner.rules.OpenSearchTopKRewriter;
        // the reorder. (Same spirit as the trimFields all-equi scoping, tightened to isEqui.)
import org.opensearch.analytics.planner.rules.OpenSearchUncollectRule;
     * </ul>
import org.opensearch.analytics.planner.rules.OpenSearchValuesRule;
    }
 *       exchanges via trait enforcement where distribution mismatches.</li>
    /**
            // throw a RuntimeException) on an unsupported condition shape when assertions are enabled. Fall
                List.of(
     *
        }
     * EXISTS sees relative to a correlated predicate.
            return reordered;
            modifiedRelNode = topK.get();
     * <p><b>Declines on any plan containing a non-equi join.</b> The trimmer rewrites the WHOLE tree,
            // not on a half-pushed intermediate.
        }
    public static RelNode createPlan(RelNode rawRelNode, PlannerContext context) {
        // Exclude plans carrying a Correlate or a non-INNER join. JOIN_TO_MULTI_JOIN flattens inner joins
            RelNodeUtils.logPlan(LOGGER, "After sort pushdown", modifiedRelNode);
            // tree keeps two adjacent, column-reordering Projects between any downstream Sort and
     * <p><b>The two rules run as SEPARATE HEP instructions</b> — {@code JOIN_TO_MULTI_JOIN} to fixpoint,
        // in the same ARBITRARY pass loops indefinitely (they invert each other). It lives in its own
     */
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rel.RelNode;
        };
import org.opensearch.analytics.planner.rules.OpenSearchJoinRule;
        Optional<RelNode> topK = OpenSearchTopKRewriter.rewrite(modifiedRelNode, context);
     * including the PPL {@code subsearch} shapes that the frontend lowers to them) into
        RexShuttle rexShuttle = new RexShuttle() {
        }
     *
            return input;
     * ranks join factors by {@code RelMetadataQuery.getRowCount} — the per-index counts seeded by
     * codegen do; the SQL JDBC implementor inlines the literal directly into the
            .addRuleInstance(new OpenSearchDistinctCountRule())
        volcanoPlanner.addRule(new OpenSearchUnionSplitRule(context));
            // post-processing step inside the same listener phase.
    private static RelNode removeSubQueries(RelNode input, RuleProfilingListener listener) {
        // NOTE: join reordering does NOT run here — running JOIN_TO_MULTI_JOIN + MULTI_JOIN_OPTIMIZE_BUSHY
     * predicate inherits its child's viable backends instead of validating its scalar calls. That is
    /**
                    new OpenSearchTableScanRule(context),
import org.apache.calcite.rex.RexSubQuery;
import org.apache.calcite.rel.core.Join;
        List<org.apache.calcite.rel.core.Join> joins = RelNodeUtils.findNodes(input, org.apache.calcite.rel.core.Join.class);
     * fact-table intermediate is not carried through every downstream join (and not re-shuffled at
            project -> project.getProjects().stream().allMatch(RexUtil::isDeterministic)
import org.apache.calcite.rel.core.Filter;
            return input;
    }
            RelTraitSet desiredTraits = copied.getTraitSet().replace(distTraitDef.anySingleton());
            RelNodeUtils.logPlan(LOGGER, "After field trimming", trimmed);
import org.opensearch.analytics.planner.rules.OpenSearchSortSplitRule;
                    new OpenSearchFilterRule(context),
 * {@link RuleProfilingListener} (when profiling is enabled on
     * Runs before {@link OpenSearchAggregateRule} marks the aggregate so the marking phase, the
            // Root demands SINGLETON with null locality — satisfied by either SHARD+SINGLETON
    private static RelNode extractLiteralAgg(RelNode input, RuleProfilingListener listener) {
import org.opensearch.analytics.planner.rules.OpenSearchAggLiteralArgProjectSplitRule;
public class PlannerImpl {
        if (!RelNodeUtils.findNodes(input, org.apache.calcite.rel.core.Correlate.class).isEmpty()
     * {@code OpenSearch*} nodes and emits a pinned {@code OpenSearchProject} whose
 * SPDX-License-Identifier: Apache-2.0
        if (node instanceof Sort sort && sort.getCollation().getFieldCollations().isEmpty() && sort.offset == null && sort.fetch != null) {
import org.opensearch.analytics.planner.rules.OpenSearchAggregateReduceRule;
                    new ReduceExpressionsRule.FilterReduceExpressionsRule(Filter.class, RelBuilder.proto(Contexts.empty())),
                List.of(
            Project.class,
    /**
            LOGGER.debug("Field trimming skipped: plan contains a non-equi join (trimmer would mis-rewrite it)");
        // 2. Receiving-backend (Lucene) needs a way to turn the combined payload back into
import org.apache.calcite.plan.Contexts;
package org.opensearch.analytics.planner;
        ).toRule();
        Optional<RelNode> sortPushdown = OpenSearchSortPushdownRewriter.rewrite(modifiedRelNode);
     * {@link OpenSearchAggLiteralArgProjectSplitRule}.
        if (sortPushdown.isPresent()) {
        // condition shape, and a leftKeys-non-empty-but-not-pure-equi join would slip a theta predicate into
                    CoreRules.SORT_REMOVE_REDUNDANT
import org.opensearch.analytics.planner.rules.OpenSearchHashJoinSplitRule;
import org.opensearch.analytics.planner.rules.OpenSearchSortPushdownRewriter;
 *   <li>HepPlanner (RBO): converts LogicalXxx → OpenSearchXxx with backend
        // 3+ PURE-equi joins only: fewer than 3 has a single order; and every join must be a pure equi-join
import org.apache.calcite.plan.volcano.VolcanoPlanner;
            RelNode reordered = HepPhase.named("join-reorder")
    /**
                withCorrelates -> RelDecorrelator.decorrelateQuery(
import org.opensearch.analytics.planner.rules.OpenSearchLateMaterializationRewriter;
 * </ol>
                    if (unlimited != rewritten.rel) {
        }
        // decorrelation below can fold it into a standard join.
            .addRuleCollection(
     *       HLL sketch merge instead of additive SUM-of-counts.</li>
    private static RelNode stripTopFetchOnlySort(RelNode node) {
                    }
        RelShuttle relShuttle = new RelHomogeneousShuttle() {
            // SORT_REMOVE_REDUNDANT drops a Sort/LIMIT whose input is provably bounded to
    }
     * that computes any non-deterministic expression (e.g. {@code eval r = rand() | where r > 0}).
        return HepPhase.named("reduce-expressions")
import org.apache.calcite.rex.RexUtil;
     * Invokes Calcite's {@link RelFieldTrimmer} to slim each node to only the columns its consumer
    }
            // Logical* -> OpenSearch* conversion. Cascades with LIMIT_MERGE in the same
    private static final Logger LOGGER = LogManager.getLogger(PlannerImpl.class);
    static RelNode trimFields(RelNode input) {
     * pre-marking {@code PROJECT_MERGE} cannot re-fuse the two copies. See
            // Defensive: a reorder-rule edge case must not fail planning — Calcite can assert-fail (not just
            volcanoCluster.setMetadataQuerySupplier(OpenSearchRelMetadataQuery::new);
        RelNodeUtils.logPlan(LOGGER, "After marking", modifiedRelNode);
            .run(prepared, listener);
 *
        volcanoPlanner.addRule(new OpenSearchDistributionDeriveRule(context));
            // trim() asserts an identity ref-mapping at the root, so field count/order are preserved
import org.apache.calcite.rel.rules.FilterProjectTransposeRule;
     *       PPL's reflective {@code CHECKED_LONG_SUM} marker → Calcite's canonical {@code SUM}.</li>
            }
        try {
 * {@link PlannerContext}) can be threaded through every planner created here.
    }
            // special-case. Runs here, pre-marking, on plain Logical* so marking stays a pure
            RelNode copied = RelNodeUtils.copyToCluster(marked, volcanoCluster, distTraitDef);
        volcanoPlanner.addRule(new OpenSearchJoinSplitRule(context));
            .addRuleCollection(
            // aggregate, getMaxRowCount <= 1): a no-op that the marking rule must not have to
import org.opensearch.analytics.planner.rules.OpenSearchDistinctCountRule;
            // is already rendered by the "After CBO" DEBUG line in runAllOptimizations, so no dump is needed.
    }
     * construction, not by a bigger memory ceiling.
    }
     * Pre-marking cost-based join reordering for multi-way joins. Collapses the frontend's
     * Phase 0b: lower {@code LITERAL_AGG(literal)} aggregate calls into an
import org.opensearch.analytics.planner.rules.OpenSearchUnionSplitRule;
    /**
            // AGGREGATE_PROJECT_PULL_UP_CONSTANTS lifts constant group keys into a Project above
     * moves to its own Gradle module. The OpenSearch monorepo injects -proc:none globally, blocking
        Optional<RelNode> lateMat = OpenSearchLateMaterializationRewriter.rewrite(modifiedRelNode);
            // TODO: eliminate this copy
        modifiedRelNode = mark(modifiedRelNode, context, listener);
     */
 * Central planner for the Analytics Plugin.
                    CoreRules.JOIN_SUB_QUERY_TO_CORRELATE
     *       {@link org.apache.calcite.rel.logical.LogicalProject} computing the quotient.</li>
        if (!reorderable) {
                    if (body != rewritten.rel) {
     *
     * decorrelate back to a standard join shape. Without this phase, downstream rules see
            return input;
        }
        if (joins.stream().anyMatch(j -> j.analyzeCondition().leftKeys.isEmpty())) {
                )
    private static RelNode stripExistsSubqueryLimits(RelNode input) {
     *
            .bottomUp()
     * <p>TODO: migrate rules from deprecated RelOptRule to RelRule&lt;Config&gt; once the planner
            // deferred failure (marking throws on it, which the try/catch here can't see because the reorder
     *       {@code APPROX_COUNT_DISTINCT(x)} so distinct counts engage the engine-native
import java.util.Optional;
            @Override
                )
     * Filter's predicates (introduced by the pushdown phase in Phase 1b) to rewrite
     *
            )
            if (!copied.getTraitSet().equals(desiredTraits)) {
            // above the Exchange, defeating projection pushdown. Keeping it below lets DataFusion
import org.apache.calcite.rel.rules.CoreRules;
    /**
                        return rewritten.clone(unlimited);
     * Phase 1b: pre-marking rewrites on plain {@link org.apache.calcite.rel.logical.LogicalAggregate}.
    }
            public RelNode visit(RelNode node) {
        List<Join> joins = RelNodeUtils.findNodes(input, Join.class);
     * THEN {@code MULTI_JOIN_OPTIMIZE_BUSHY} to fixpoint. Running them in one rule collection loops
     * Volcano split rule, and the {@code DistributedAggregateRewriter} see the rewritten shape:
        }
        RelNodeUtils.logPlan(LOGGER, "Input RelNode", rawRelNode);
            .run(input, listener);
            // the Aggregate. OpenSearchTopKRewriter only composes its sort-key remap through a
    private static RelNode mark(RelNode input, PlannerContext context, RuleProfilingListener listener) {
            )
        // LogicalCorrelate that the marking phase rejects with "unmarked child [LogicalCorrelate]".
        if (lateMat.isPresent()) {
            // instruction so it only fires after the transposes have settled — that way any
/*
 */
        volcanoPlanner.addRelTraitDef(ConventionTraitDef.INSTANCE);
        RuleProfilingListener listener = context.isProfilingEnabled() ? new RuleProfilingListener() : null;
     * so nothing is lost. Regression: {@code CascadeShuffleProbeTests#testColumnPruneSkipsPlanWithCrossJoin}
    /** Phase 2: VolcanoPlanner for trait propagation + exchange insertion. */
        }
                RexSubQuery rewritten = (RexSubQuery) super.visitSubQuery(subQuery);
        // an EXISTS/NOT-EXISTS subquery (LogicalCorrelate, or a semi/anti join once decorrelated — TPC-H
            RelNodeUtils.logPlan(LOGGER, "After TopK rewrite", modifiedRelNode);
        volcanoPlanner.addRelTraitDef(distTraitDef);
    private static final FilterProjectTransposeRule FILTER_PROJECT_TRANSPOSE_DETERMINISTIC = FilterProjectTransposeRule.Config.DEFAULT
        return node;
                if (rewritten.getOperator().getKind() == SqlKind.EXISTS) {
     * <p><b>Gated</b> by {@link AnalyticsSettings#MPP_JOIN_REORDER} (default {@code false}) AND to plans
     * its own phase so {@code ProjectReduceExpressionsRule} cannot use a downstream
     * <ul>
        // Inside an EXISTS that limit is semantically irrelevant (existence needs only one row), but
        } catch (Exception | AssertionError e) {
     * sort with collation or an offset is preserved — dropping either could change which rows the
        // into a MultiJoin, but MULTI_JOIN_OPTIMIZE_BUSHY only re-expands a MultiJoin it can fully reorder;
                LOGGER.debug("Join reorder left a residual MultiJoin; falling back to as-written order");
        modifiedRelNode = reorderJoins(modifiedRelNode, context, listener);
import org.apache.calcite.sql.SqlKind;
        modifiedRelNode = cbo(modifiedRelNode, rawRelNode, context, listener);
    public static RelNode runAllOptimizations(RelNode rawRelNode, PlannerContext context) {
        return HepPhase.named("marking")
            RelNodeUtils.logPlan(LOGGER, "After late-materialization", modifiedRelNode);
    /**
        // FFM round-trips per RG into one. Blocked on two open design points:
     * their limit, where it is semantically meaningful.
     * Phase 1c': duplicate an aggregate's literal-config-arg Project (e.g. percentile's {@code 50})
                    CoreRules.PROJECT_SUB_QUERY_TO_CORRELATE,
    }
import org.opensearch.analytics.planner.rules.OpenSearchDistributionDeriveRule;
        volcanoPlanner.addRule(new OpenSearchBroadcastJoinSplitRule(context));
     * the reordered shape in one pass.
     * Package-private so planner rule tests can inspect the marked+optimized tree.
        if (topK.isPresent()) {
                List.of(
     * and changes results, so the Filter must stay above the Project regardless of backend.
                    new OpenSearchProjectRule(context),
     * a cross-join (PPL {@code transpose}) must not be flattened into a {@code MultiJoin}. A reorder-rule
            .run(input, listener);
            // Transposes (filter-into-*) cascade together within one fixpoint, alongside
     * not a subtree, so one CROSS JOIN anywhere — e.g. what PPL {@code transpose} lowers to, sitting
        return HepPhase.named("agg-literal-arg-split").addRuleInstance(new OpenSearchAggLiteralArgProjectSplitRule()).run(input, listener);
            // within the limit (e.g. a collation-less `head N` or a sort over a scalar
     * marked Lucene-delegation-viable today — a separate filter-viability gap where a field-less
            filter -> true,
import org.apache.calcite.plan.RelOptCluster;
                return visited.accept(rexShuttle);
     *   <li>{@link OpenSearchAggregateReduceRule} — {@code AVG} / {@code STDDEV} / {@code VAR} →
     * reorder rules match {@code LogicalProject(MultiJoin)} / {@code LogicalJoin}, and marking lowers
    private static RelNode decomposeAggregates(RelNode input, RuleProfilingListener listener) {
            .addRuleInstance(new OpenSearchCheckedLongSumRule())
     * If {@code node} is a {@link Sort} that only limits row count (a {@code fetch} with no sort
                RelNode visited = super.visit(node);
                    RelBuilder.proto(Contexts.empty()).create(prepared.getCluster(), null)
                )
     * Removes a top-level fetch-only {@link Sort} (no collation, no offset) from the body of every
            // memo hangs the query purely in the debug dump; findBestExp already returned). The chosen plan
                    withCorrelates,
        volcanoPlanner.addRule(new OpenSearchHashJoinSplitRule(context));
     * <p>This is a <b>semantic-correctness</b> guard, not a delegation/performance one. The stock
     * {@code Aggregate + Project} shape via {@link ExtractLiteralAggRule}.
            listener.beginPhase("cbo");
                    RelNode unlimited = stripTopFetchOnlySort(body);
        try {
            return input;
     * of, but the rule is kept as its own pass — independent of the subquery
import org.opensearch.analytics.planner.rules.OpenSearchCheckedLongSumRule;
     * the marking phase observes the plan.
        // TODO(combine-delegated-predicates): a post-marking HEP rule should fuse same-backend
     * boolean result (it only tests for ≥1 row), yet it blocks {@link RelDecorrelator} from
        // unmarked MultiJoin ("Filter rule encountered unmarked child [MultiJoin]"). Skip those shapes.
        // Strip that limit while the subquery is still an identifiable EXISTS RexSubQuery so the
    /**
     * {@code LogicalCorrelate} via the three {@code *_SUB_QUERY_TO_CORRELATE} rules, then
 *       assignment, predicate annotation, and distribution traits.</li>
            // getRowCount; every other metadata def falls through to the default handler chain.
        return HepPhase.named("aggregate-decompose")
            volcanoPlanner.addListener(listener);
     * SQL output). DataFusion has no equivalent UDAF, so we lower it away before
    }
            LOGGER.info("Planner profile for raw RelNode is :\n{}", profile.format());
    /**
        // Revisit once those are designed. The rule would also strip performance peers from
     * {@code rand()} Project inlines {@code RAND()} into the predicate, so a reference to one
 *
     * Project expressions. Co-locating the reducer with the transposes lets Calcite
import org.apache.calcite.plan.volcano.AbstractConverter;
                    new OpenSearchAggregateRule(context),
        }
            if (!RelNodeUtils.findNodes(reordered, org.apache.calcite.rel.rules.MultiJoin.class).isEmpty()) {
import org.opensearch.analytics.planner.rules.OpenSearchBroadcastJoinSplitRule;
            if (listener != null) listener.endPhase("cbo");
                    RelNode body = stripExistsSubqueryLimits(rewritten.rel);
     * optimization.
        // (isEqui() = no residual non-equi conjunct). A cross-join (no keys) or a mixed equi+theta condition
        // The PPL frontend injects a SUBSEARCH_MAXOUT Sort(fetch=N) at the top of every subsearch.
     * concern separately so profiling output stays meaningful, (2) the rule
            )
            // prune the scan. QTF relocates the below-Sort Project above its wrapper itself.
     * rule only guards against window functions ({@code !containsOver()}); pushing a Filter past a
            // SORT_PROJECT_TRANSPOSE is intentionally omitted: lifting Project above Sort puts it
            RuleProfilingListener.PlannerProfile profile = listener.snapshot();
        modifiedRelNode = extractLiteralAgg(modifiedRelNode, listener);
            // PartiallyOrderedSet build is O(memo^2+) and takes MINUTES for a multi-way join (a 6-way join's
        RelNodeUtils.logPlan(LOGGER, "After CBO", modifiedRelNode);
            return input;
                }
            .addRuleInstance(CoreRules.PROJECT_MERGE)
            .addRuleCollection(
     * ordered instructions the flatten completes once and the optimizer consumes its {@code MultiJoin}
            .bottomUp()
            return trimmed;
            .addRuleCollection(
        } finally {
            .postProcess(
     * coordinator fragment for the DataFusion substrait converter. Placed after marking so the
     *
        return runAllOptimizations(rawRelNode, context);
import org.apache.calcite.rex.RexShuttle;
            .addRuleInstance(CoreRules.AGGREGATE_PROJECT_PULL_UP_CONSTANTS)
    /**
 * @opensearch.internal
            volcanoPlanner.setRoot(copied);
            }
import org.apache.calcite.plan.ConventionTraitDef;
        RelNode prepared = stripExistsSubqueryLimits(input);
            // the Aggregate. That Project lands directly beneath the query's own projection, and
    private static RelNode reduceExpressions(RelNode input, RuleProfilingListener listener) {
import org.apache.calcite.rex.RexNode;
     *
     * <p>{@code LITERAL_AGG} is a Calcite-internal aggregate that Calcite expects
    private static RelNode splitAggLiteralArgProject(RelNode input, RuleProfilingListener listener) {
                    new OpenSearchCorrelateRule(context)
            // (1-shard scan, no ER) or COORDINATOR+SINGLETON (after ER). Multi-shard scans stamp
     * into a pinned upper copy (literal stays with the aggregate) over an unpinned physical-only
import org.opensearch.analytics.planner.rules.ExtractLiteralAggRule;
        }
     * (positive control: {@code #testColumnPruneNarrowsShuffleInputs}).
     * keys and no {@code offset}), returns its input; otherwise returns {@code node} unchanged. A
import org.apache.logging.log4j.LogManager;
     * Phase 1a: constant-expression reduction on Filter and Project predicates. Kept in
                    new OpenSearchSortRule(context),
                    new OpenSearchValuesCharNormalizeRule(),
     * {@code Sort(fetch=N)} at the top of each subsearch; for an EXISTS that limit cannot change the
     */
        }
        if (listener != null) {
            // RexSubQuery removal introduces LogicalCorrelate; decorrelate back to a
        // a single BooleanQuery / Weight without polluting ScalarFunction with AND.
     * the branch's rows) and throws nothing, so the try/catch below would not catch it. Requiring EVERY
            // Calcite's no-stats cartesian × 0.15 over-estimate. The subclass overrides only
    }
            @Override
            RelOptCluster volcanoCluster = RelOptCluster.create(volcanoPlanner, rawRelNode.getCluster().getRexBuilder());
     * nodes, then marking lowers the canonical post-pushdown shape in one go.
     * {@code IndexRowCountFetcher}. The effect: the smaller/more-selective joins run first, so a fat
    /**
                    CoreRules.LIMIT_MERGE,
                    CoreRules.FILTER_INTO_JOIN,
     * already-computed random value ({@code $ref > literal}) becomes a fresh {@code RAND() > literal}
        modifiedRelNode = trimFields(modifiedRelNode);
            // single Project (it treats further Projects as transparent passthroughs), so the
            // RANDOM → ER inserted by ExpandConversionRule + trait def's convert(). Single-shard
import org.opensearch.analytics.planner.rules.OpenSearchValuesCharNormalizeRule;
import org.opensearch.analytics.planner.rules.OpenSearchFilterRule;
    }
        .withOperandFor(
        }
     * the Immutables annotation processor required by RelRule.Config sub-interfaces.
        // leaf — today the resolver requires a SqlFunction operator on the original.
        }
        } catch (RuntimeException | AssertionError e) {
        modifiedRelNode = reduceExpressions(modifiedRelNode, listener);
import java.util.List;
import org.apache.calcite.rel.rules.ReduceExpressionsRule;
import org.apache.calcite.rel.RelHomogeneousShuttle;
            //
     * beside a real equi-join — is enough for it to prune every column of the cross-join's unreferenced
            trimmed = relBuilder.push(trimmed).rename(input.getRowType().getFieldNames()).build();
     * indefinitely (the optimize rule's {@code Join} output re-triggers {@code JOIN_TO_MULTI_JOIN}); as
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
import org.apache.calcite.sql2rel.RelDecorrelator;
import org.opensearch.analytics.planner.rules.OpenSearchCheckedLongSumWindowRule;
     * <p>{@code SubQueryRemoveRule}'s {@code NOT IN} / {@code SOME} / {@code ALL}
    }
 * <p>TODO: Join strategy selection, sort removal via CBO
        boolean reorderable = joins.size() >= 3 && joins.stream().allMatch(j -> j.analyzeCondition().isEqui());
     * shouldn't cover {@code EXISTS}) or carry the un-removed subquery into substrait
                )
import org.opensearch.analytics.planner.rules.OpenSearchCorrelateRule;
        // RelDecorrelator refuses to decorrelate (it only handles fetch==1) — leaving a
     * needs, inserting a narrowing Project above the scan so DataFusion prunes the parquet read.
        // 1. Substrait wire representation for a fused {original = AND(call1, call2, ...)}
        OpenSearchDistributionTraitDef distTraitDef = context.getDistributionTraitDef();
            LOGGER.warn("RelFieldTrimmer skipped (falling back to untrimmed tree): {}", e.toString());
 *
import org.apache.calcite.tools.RelBuilder;
            // RelDecorrelator is a visitor (not a RelOptRule) so it runs as a
            .addRuleInstance(new OpenSearchCheckedLongSumWindowRule())
            // throw IndexOutOfBoundsException. Collapsing the pair back into one Project here keeps
     * simplify e.g. {@code m = (int0 <= 4)} into {@code m = IS NOT NULL(int0)} once the
 */
        return modifiedRelNode;
     * {@code EXISTS} {@link RexSubQuery} in the tree. The PPL frontend injects a SUBSEARCH_MAXOUT
     * Like {@link CoreRules#FILTER_PROJECT_TRANSPOSE} but refuses to push a Filter below a Project
            )
            // returned `input` is the original, unmutated tree (HepPlanner builds a fresh output).
        // dedicated phase, {@link #reorderJoins}, which runs them as two separate fixpoint instructions.
            // but names can drift (it drops alias-only top Projects, e.g. transpose's RENAME). Re-impose
        if (listener != null) {
    /**
        VolcanoPlanner volcanoPlanner = new VolcanoPlanner();
     */
        // it becomes a correlated Sort(fetch>1) after FILTER_SUB_QUERY_TO_CORRELATE, which
        volcanoPlanner.addRule(new OpenSearchAggregateSplitRule(context));
            return input;
            // the original output names — same contract as Calcite's RelRoot.project()/RelBuilder.rename().
     *   <li>{@link OpenSearchCheckedLongSumRule} and {@link OpenSearchCheckedLongSumWindowRule} —
        RelBuilder relBuilder = RelBuilder.proto(Contexts.empty()).create(input.getCluster(), null);
import org.opensearch.analytics.planner.rules.OpenSearchAggregateRule;
     *
     * <p>TODO: add SortPushdown rule here — pushes Sort below Exchange to data nodes for top-K
import org.opensearch.analytics.planner.rules.OpenSearchTableScanRule;
    private static RelNode pushdownRules(RelNode input, RuleProfilingListener listener) {
     */
        return input.accept(relShuttle);
            // NB: do NOT log volcanoPlanner.dump() here — it runs Dumpers.dumpGraphviz, whose
            }
     * emission. Runs first so every later phase observes a subquery-free tree.
     * Filter sits below the Project — semantically correct but emits operators the
 *   <li>VolcanoPlanner (CBO): requests SINGLETON at root (coordinator must
            // phase itself didn't throw). If any survived, discard the reorder and keep the as-written tree.
import org.apache.calcite.sql2rel.RelFieldTrimmer;
            public RexNode visitSubQuery(RexSubQuery subQuery) {
                    CoreRules.FILTER_AGGREGATE_TRANSPOSE,
            return best;
            .run(input, listener);
     * still fires correctly if a future frontend / pushdown rule constructs
            .bottomUp()
import org.apache.logging.log4j.Logger;
                    CoreRules.FILTER_SUB_QUERY_TO_CORRELATE,
import org.opensearch.analytics.planner.rules.OpenSearchJoinSplitRule;
     *
import org.opensearch.analytics.planner.rules.OpenSearchProjectRule;
            context.recordProfilingResults(profile);
                    }
        // AnnotatedPredicates under OR/NOT (Lucene call buys nothing in those positions).
     * evaluated again at scan time. That re-evaluates / duplicates the non-deterministic expression
     */
     * {@code computeSelfCost} forces the CBO-inserted ER below it, keeping the literal in the
    private static RelNode cbo(RelNode marked, RelNode rawRelNode, PlannerContext context, RuleProfilingListener listener) {
 *       gather all results). Split rule fires on aggregates, Volcano inserts
                        return rewritten.clone(body);
            Filter.class,
 * <p>Each optimization phase lives in its own private method so a single
            //
                    FILTER_PROJECT_TRANSPOSE_DETERMINISTIC,
     * then re-orders it with Calcite's bushy-join heuristic ({@code MULTI_JOIN_OPTIMIZE_BUSHY}), which
     * <p>Runs here (pre-marking, on {@code Logical*}) for the same reason as {@link #trimFields}: the
        volcanoPlanner.addRule(new OpenSearchSortSplitRule(context));
                return input;
        // (e.g. a.x=b.x AND a.y>b.y) must NOT be flattened into a MultiJoin — the bushy rule is narrow around
     * Phase 0: lower {@link org.apache.calcite.rex.RexSubQuery}s (EXISTS / IN / SOME / ANY,
import org.opensearch.analytics.AnalyticsSettings;
import org.opensearch.analytics.planner.rules.OpenSearchAggregateSplitRule;
        RelNode modifiedRelNode = rawRelNode;
    /**
        if (!AnalyticsSettings.MPP_JOIN_REORDER.get(context.getSettings())) {
     * resolves leaf predicates through a {@code ScalarFunction} table that doesn't and
                .addRuleInstance(CoreRules.JOIN_TO_MULTI_JOIN)
     */
     * Phase 1b: Filter pushdown past Project / Aggregate / Join via Calcite's transpose rules.
     * removal phase — for two reasons: (1) phase listing reflects each
import org.apache.calcite.rel.core.Project;
     * edge case falls back to the input plan rather than failing the query.
        // q21/q11) leaves a residual MultiJoin that no bushy match consumes, and marking then rejects the
            // that invariant intact and lets TopK oversampling still fire for these queries.
import org.apache.calcite.plan.RelTraitSet;
     * input down to a synthetic {@code DUMMY} literal Project. That plan is valid-but-WRONG (it drops
import org.opensearch.analytics.planner.rules.OpenSearchUnionRule;
                    new OpenSearchUnionRule(context),
     *   <li>{@link OpenSearchDistinctCountRule} — single-arg {@code COUNT(DISTINCT x)} →
import org.apache.calcite.rel.core.Sort;
            .addRuleInstance(new OpenSearchAggregateReduceRule())
     * Phase 1 (RBO marking) + Phase 2 (CBO exchange insertion).
     * tracked/fixed separately; it is not the reason for this rule.)
            // scans stamp SHARD+SINGLETON → already satisfies, no top ER.
            // auto-injected NOT NULL collapses with the user's WHERE on the post-pushdown filter,
            // Use our metadata query so OpenSearchJoin gets a PK-FK row-count estimate instead of
     * Phase 1c: marking — convert LogicalXxx → OpenSearchXxx bottom-up.
        return HepPhase.named("literal-agg-extract").addRuleInstance(new ExtractLiteralAggRule()).run(input, listener);
     * each worker tier). This is the plan-layer analog of the column-prune win — less data moved by
 * <ol>
     * with 3+ joins that are ALL equi-joins — a 2-way join has a single order (nothing to reorder), and
            LOGGER.debug("Join reorder skipped (fell back to as-written order): {}", e.toString());
     * Project may not have backend support for.
                    new ReduceExpressionsRule.ProjectReduceExpressionsRule(Project.class, RelBuilder.proto(Contexts.empty()))
                .run(input, listener);
     * {@code LITERAL_AGG} directly via {@code RelBuilder.literalAgg(...)}.
     *       primitive {@code SUM} / {@code COUNT} (+ {@code SUM_SQ} for variance) plus a scalar
            return sort.getInput();
     * each backend to implement natively (Calcite's own Interpreter and Enumerable
     */
        try {
        volcanoPlanner.addRule(AbstractConverter.ExpandConversionRule.INSTANCE);

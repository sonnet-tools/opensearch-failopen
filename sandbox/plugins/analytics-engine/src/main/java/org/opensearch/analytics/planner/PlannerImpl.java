        }
import org.opensearch.analytics.planner.rules.OpenSearchDistinctCountRule;
        RelNode modifiedRelNode = rawRelNode;
     * moves to its own Gradle module. The OpenSearch monorepo injects -proc:none globally, blocking
        // the reorder. (Same spirit as the trimFields all-equi scoping, tightened to isEqui.)
import org.apache.calcite.plan.ConventionTraitDef;
    public static RelNode createPlan(RelNode rawRelNode, PlannerContext context) {  
     * Phase 1 (RBO marking) + Phase 2 (CBO exchange insertion).
    }  
                )
                    CoreRules.FILTER_INTO_JOIN,
     * fact-table intermediate is not carried through every downstream join (and not re-shuffled at
        // TODO(combine-delegated-predicates): a post-marking HEP rule should fuse same-backend  
import org.apache.calcite.sql2rel.RelFieldTrimmer;
        try {
                    new OpenSearchProjectRule(context),  
    private static RelNode removeSubQueries(RelNode input, RuleProfilingListener listener) {
            // within the limit (e.g. a collation-less `head N` or a sort over a scalar  
/*  
        // 3+ PURE-equi joins only: fewer than 3 has a single order; and every join must be a pure equi-join
import org.apache.calcite.plan.RelOptCluster;  
     * Volcano split rule, and the {@code DistributedAggregateRewriter} see the rewritten shape:
            // throw a RuntimeException) on an unsupported condition shape when assertions are enabled. Fall  
        modifiedRelNode = removeSubQueries(modifiedRelNode, listener);
        modifiedRelNode = reorderJoins(modifiedRelNode, context, listener);
        // 2. Receiving-backend (Lucene) needs a way to turn the combined payload back into
     * <p><b>Gated</b> by {@link AnalyticsSettings#MPP_JOIN_REORDER} (default {@code false}) AND to plans
import org.apache.calcite.rex.RexNode;
        modifiedRelNode = reduceExpressions(modifiedRelNode, listener);
        }
     * needs, inserting a narrowing Project above the scan so DataFusion prunes the parquet read.
 * <p>Each optimization phase lives in its own private method so a single  
     * construction, not by a bigger memory ceiling.
            volcanoPlanner.setRoot(copied);
import java.util.List;  
        RexShuttle rexShuttle = new RexShuttle() {
        return modifiedRelNode;
        }
    public static RelNode runAllOptimizations(RelNode rawRelNode, PlannerContext context) {
        }
     * each backend to implement natively (Calcite's own Interpreter and Enumerable
                List.of(  
     * <p>{@code SubQueryRemoveRule}'s {@code NOT IN} / {@code SOME} / {@code ALL}  
        // Inside an EXISTS that limit is semantically irrelevant (existence needs only one row), but  
        RelNodeUtils.logPlan(LOGGER, "After marking", modifiedRelNode);
            .bottomUp()
     * simplify e.g. {@code m = (int0 <= 4)} into {@code m = IS NOT NULL(int0)} once the
                    CoreRules.FILTER_AGGREGATE_TRANSPOSE,  
            volcanoPlanner.addListener(listener);  
            filter -> true,
     * left-deep {@code LogicalJoin} tree into a single {@code MultiJoin} ({@code JOIN_TO_MULTI_JOIN}),
            RelNodeUtils.logPlan(LOGGER, "After field trimming", trimmed);
        modifiedRelNode = trimFields(modifiedRelNode);  
    /**
import org.apache.calcite.rel.RelShuttle;  
        if (!reorderable) {
                    new ReduceExpressionsRule.FilterReduceExpressionsRule(Filter.class, RelBuilder.proto(Contexts.empty())),
            public RexNode visitSubQuery(RexSubQuery subQuery) {  
     * then re-orders it with Calcite's bushy-join heuristic ({@code MULTI_JOIN_OPTIMIZE_BUSHY}), which
        }
    /**
import org.opensearch.analytics.planner.rules.OpenSearchHashJoinSplitRule;
        RelNode prepared = stripExistsSubqueryLimits(input);  
        }  
import org.opensearch.analytics.planner.rules.OpenSearchAggregateRule;
     * marked Lucene-delegation-viable today — a separate filter-viability gap where a field-less  
            if (listener != null) listener.endPhase("cbo");
        volcanoPlanner.addRelTraitDef(ConventionTraitDef.INSTANCE);
            )
     *   <li>{@link OpenSearchAggregateReduceRule} — {@code AVG} / {@code STDDEV} / {@code VAR} →  
     * pre-marking {@code PROJECT_MERGE} cannot re-fuse the two copies. See
                return rewritten;  
        };  
        RelShuttle relShuttle = new RelHomogeneousShuttle() {  
        }
                RelNode visited = super.visit(node);  
     * Phase 0: lower {@link org.apache.calcite.rex.RexSubQuery}s (EXISTS / IN / SOME / ANY,  
        if (joins.stream().anyMatch(j -> j.analyzeCondition().leftKeys.isEmpty())) {
 */  
        RelBuilder relBuilder = RelBuilder.proto(Contexts.empty()).create(input.getCluster(), null);  
     */
     * <p>{@code LITERAL_AGG} is a Calcite-internal aggregate that Calcite expects  
 *       assignment, predicate annotation, and distribution traits.</li>  
     * (positive control: {@code #testColumnPruneNarrowsShuffleInputs}).
            .addRuleInstance(new OpenSearchDistinctCountRule())
import java.util.Optional;
     * <p>TODO: migrate rules from deprecated RelOptRule to RelRule&lt;Config&gt; once the planner
        }  
        return HepPhase.named("aggregate-decompose")  
     * that computes any non-deterministic expression (e.g. {@code eval r = rand() | where r > 0}).
     * keys and no {@code offset}), returns its input; otherwise returns {@code node} unchanged. A  
            // Transposes (filter-into-*) cascade together within one fixpoint, alongside
        } catch (RuntimeException | AssertionError e) {
import org.apache.calcite.tools.RelBuilder;  
        };
        List<org.apache.calcite.rel.core.Join> joins = RelNodeUtils.findNodes(input, org.apache.calcite.rel.core.Join.class);  
        RuleProfilingListener listener = context.isProfilingEnabled() ? new RuleProfilingListener() : null;
            .postProcess(
        // dedicated phase, {@link #reorderJoins}, which runs them as two separate fixpoint instructions.
        RelNodeUtils.logPlan(LOGGER, "After CBO", modifiedRelNode);
import org.apache.calcite.sql2rel.RelDecorrelator;
     * input down to a synthetic {@code DUMMY} literal Project. That plan is valid-but-WRONG (it drops  
        Optional<RelNode> topK = OpenSearchTopKRewriter.rewrite(modifiedRelNode, context);
    }  
    private static RelNode cbo(RelNode marked, RelNode rawRelNode, PlannerContext context, RuleProfilingListener listener) {  
        // 1. Substrait wire representation for a fused {original = AND(call1, call2, ...)}  
        if (listener != null) {  
     *
    }  
            .run(input, listener);
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
     * Phase 1c: marking — convert LogicalXxx → OpenSearchXxx bottom-up.
import org.opensearch.analytics.planner.rules.ExtractLiteralAggRule;
        // a single BooleanQuery / Weight without polluting ScalarFunction with AND.  
     * {@code computeSelfCost} forces the CBO-inserted ER below it, keeping the literal in the
            )  
                LOGGER.debug("Join reorder left a residual MultiJoin; falling back to as-written order");
     * coordinator fragment for the DataFusion substrait converter. Placed after marking so the  
                    CoreRules.JOIN_SUB_QUERY_TO_CORRELATE  
        try {
            // instruction so it only fires after the transposes have settled — that way any  
            // prune the scan. QTF relocates the below-Sort Project above its wrapper itself.  
     * Phase 0b: lower {@code LITERAL_AGG(literal)} aggregate calls into an  
    }  
     * indefinitely (the optimize rule's {@code Join} output re-triggers {@code JOIN_TO_MULTI_JOIN}); as  
     * evaluated again at scan time. That re-evaluates / duplicates the non-deterministic expression
        Optional<RelNode> lateMat = OpenSearchLateMaterializationRewriter.rewrite(modifiedRelNode);
                    if (body != rewritten.rel) {
import org.opensearch.analytics.planner.rules.OpenSearchAggLiteralArgProjectSplitRule;  
    }
            // Use our metadata query so OpenSearchJoin gets a PK-FK row-count estimate instead of
        return HepPhase.named("reduce-expressions")  
        return input.accept(relShuttle);
import org.opensearch.analytics.planner.rules.OpenSearchTableScanRule;
                if (rewritten.getOperator().getKind() == SqlKind.EXISTS) {
                    new OpenSearchUncollectRule(context),  
            // straight join shape that the marking + capability rules already handle.
     * not a subtree, so one CROSS JOIN anywhere — e.g. what PPL {@code transpose} lowers to, sitting
                    new OpenSearchTableScanRule(context),
            return reordered;  
            // above the Exchange, defeating projection pushdown. Keeping it below lets DataFusion
     * of, but the rule is kept as its own pass — independent of the subquery
import org.apache.calcite.rel.RelNode;
    /**
                List.of(  
     * Phase 1c': duplicate an aggregate's literal-config-arg Project (e.g. percentile's {@code 50})
            // memo hangs the query purely in the debug dump; findBestExp already returned). The chosen plan
        // decorrelation below can fold it into a standard join.
                .addRuleInstance(CoreRules.MULTI_JOIN_OPTIMIZE_BUSHY)
            // auto-injected NOT NULL collapses with the user's WHERE on the post-pushdown filter,
 * {@link RuleProfilingListener} (when profiling is enabled on
        // LogicalCorrelate that the marking phase rejects with "unmarked child [LogicalCorrelate]".  
            @Override
     * without re-flattening (the documented deferral hazard at the old {@code reduceExpressions} TODO).
        OpenSearchDistributionTraitDef distTraitDef = context.getDistributionTraitDef();  
            .addRuleCollection(
     *       {@link org.apache.calcite.rel.logical.LogicalProject} computing the quotient.</li>
            )  
import org.opensearch.analytics.planner.rules.OpenSearchAggregateSplitRule;  
import org.opensearch.analytics.planner.rules.OpenSearchCorrelateRule;
        volcanoPlanner.addRule(new OpenSearchUnionSplitRule(context));
     * sort with collation or an offset is preserved — dropping either could change which rows the
    /**
            }  
            RelNode reordered = HepPhase.named("join-reorder")  
     * their limit, where it is semantically meaningful.
            // not on a half-pushed intermediate.
            // Logical* -> OpenSearch* conversion. Cascades with LIMIT_MERGE in the same  
            .bottomUp()  
     *  
        return HepPhase.named("marking")  
                }
import org.opensearch.analytics.planner.rules.OpenSearchUnionRule;
        // (isEqui() = no residual non-equi conjunct). A cross-join (no keys) or a mixed equi+theta condition
 * <ol>
     * still fires correctly if a future frontend / pushdown rule constructs
        // NOTE: join reordering does NOT run here — running JOIN_TO_MULTI_JOIN + MULTI_JOIN_OPTIMIZE_BUSHY  
            // scans stamp SHARD+SINGLETON → already satisfies, no top ER.
     *   <li>{@link OpenSearchDistinctCountRule} — single-arg {@code COUNT(DISTINCT x)} →  
                    new OpenSearchCorrelateRule(context)
 * this file be licensed under the Apache-2.0 license or a
            .addRuleCollection(
    }
     * the branch's rows) and throws nothing, so the try/catch below would not catch it. Requiring EVERY
        RelNodeUtils.logPlan(LOGGER, "Input RelNode", rawRelNode);  
    private static RelNode pushdownRules(RelNode input, RuleProfilingListener listener) {
 *   <li>VolcanoPlanner (CBO): requests SINGLETON at root (coordinator must
            .addRuleCollection(
            RelNodeUtils.logPlan(LOGGER, "After late-materialization", modifiedRelNode);
            // TODO: eliminate this copy
            volcanoCluster.setMetadataQuerySupplier(OpenSearchRelMetadataQuery::new);
import org.opensearch.analytics.planner.rules.OpenSearchLateMaterializationRewriter;
                List.of(  
    /**
     * Pre-marking placement keeps marking single-pass — transposes emit plain {@code Logical*}
}
        // into a MultiJoin, but MULTI_JOIN_OPTIMIZE_BUSHY only re-expands a MultiJoin it can fully reorder;  
     * {@code LogicalCorrelate} via the three {@code *_SUB_QUERY_TO_CORRELATE} rules, then
import org.apache.calcite.rel.core.Filter;
    /**
     * operator outright (e.g. {@link org.opensearch.analytics.planner.rules.OpenSearchFilterRule}
    /**
    private static RelNode mark(RelNode input, PlannerContext context, RuleProfilingListener listener) {
            // Calcite's no-stats cartesian × 0.15 over-estimate. The subclass overrides only  
import org.apache.logging.log4j.LogManager;
            // (1-shard scan, no ER) or COORDINATOR+SINGLETON (after ER). Multi-shard scans stamp
                    if (unlimited != rewritten.rel) {
            .addRuleCollection(
            || joins.stream().anyMatch(j -> j.getJoinType() != org.apache.calcite.rel.core.JoinRelType.INNER)) {
     * SQL output). DataFusion has no equivalent UDAF, so we lower it away before  
import org.opensearch.analytics.planner.rules.OpenSearchValuesRule;
     */
                return visited.accept(rexShuttle);
     * Filter sits below the Project — semantically correct but emits operators the
     *   <li>{@link OpenSearchCheckedLongSumRule} and {@link OpenSearchCheckedLongSumWindowRule} —
     * Project may not have backend support for.  
import org.opensearch.analytics.planner.rules.OpenSearchJoinRule;  
     * so nothing is lost. Regression: {@code CascadeShuffleProbeTests#testColumnPruneSkipsPlanWithCrossJoin}  
        }
     * concern separately so profiling output stays meaningful, (2) the rule
        // Revisit once those are designed. The rule would also strip performance peers from
     * <p>Runs here (pre-marking, on {@code Logical*}) for the same reason as {@link #trimFields}: the  
        volcanoPlanner.addRule(new OpenSearchAggregateSplitRule(context));
        }
            public RelNode visit(RelNode node) {
    private static RelNode stripTopFetchOnlySort(RelNode node) {
        if (topK.isPresent()) {
            // Belt-and-suspenders: the optimize rule must leave ZERO MultiJoin nodes — a residual one is a
            Project.class,
     * and changes results, so the Filter must stay above the Project regardless of backend.  
     * shouldn't cover {@code EXISTS}) or carry the un-removed subquery into substrait
                )
import org.opensearch.analytics.planner.rules.OpenSearchUncollectRule;  
import org.apache.calcite.rex.RexSubQuery;
            // special-case. Runs here, pre-marking, on plain Logical* so marking stays a pure
            }
 * The OpenSearch Contributors require contributions made to  
            // NB: do NOT log volcanoPlanner.dump() here — it runs Dumpers.dumpGraphviz, whose
     *       HLL sketch merge instead of additive SUM-of-counts.</li>
            LOGGER.warn("RelFieldTrimmer skipped (falling back to untrimmed tree): {}", e.toString());
     * Like {@link CoreRules#FILTER_PROJECT_TRANSPOSE} but refuses to push a Filter below a Project
                return input;  
     *
            // second reordering Project made it map the collation past the Aggregate's output and
     * emission. Runs first so every later phase observes a subquery-free tree.
     * EXISTS sees relative to a correlated predicate.
    private static RelNode extractLiteralAgg(RelNode input, RuleProfilingListener listener) {
     * {@code IndexRowCountFetcher}. The effect: the smaller/more-selective joins run first, so a fat
     * ordered instructions the flatten completes once and the optimizer consumes its {@code MultiJoin}
    /**  
     * its own phase so {@code ProjectReduceExpressionsRule} cannot use a downstream
import org.opensearch.analytics.planner.rules.OpenSearchSortSplitRule;  
        // in the same ARBITRARY pass loops indefinitely (they invert each other). It lives in its own
            // PROJECT_MERGE which collapses adjacent Projects. FILTER_MERGE runs as its own
            return input;  
            //  
            // the original output names — same contract as Calcite's RelRoot.project()/RelBuilder.rename().  
     * <p>TODO: add SortPushdown rule here — pushes Sort below Exchange to data nodes for top-K
        .withOperandFor(
            // returned `input` is the original, unmutated tree (HepPlanner builds a fresh output).
        // it becomes a correlated Sort(fetch>1) after FILTER_SUB_QUERY_TO_CORRELATE, which
                .run(input, listener);  
        modifiedRelNode = splitAggLiteralArgProject(modifiedRelNode, listener);
            RelNodeUtils.logPlan(LOGGER, "After sort pushdown", modifiedRelNode);  
import org.apache.calcite.rel.core.Project;  
            .bottomUp()
     * optimization.
     * Filter's predicates (introduced by the pushdown phase in Phase 1b) to rewrite
            return input;
                    CoreRules.LIMIT_MERGE,  
import org.apache.calcite.rel.core.Join;
import org.opensearch.analytics.planner.rules.OpenSearchJoinSplitRule;
        boolean reorderable = joins.size() >= 3 && joins.stream().allMatch(j -> j.analyzeCondition().isEqui());
 *
        // q21/q11) leaves a residual MultiJoin that no bushy match consumes, and marking then rejects the
     * ranks join factors by {@code RelMetadataQuery.getRowCount} — the per-index counts seeded by  
        return HepPhase.named("subquery-remove")
    private static RelNode splitAggLiteralArgProject(RelNode input, RuleProfilingListener listener) {
                    new OpenSearchJoinRule(context),
     * {@code OpenSearch*} nodes and emits a pinned {@code OpenSearchProject} whose
            project -> project.getProjects().stream().allMatch(RexUtil::isDeterministic)  
            modifiedRelNode = topK.get();  
            RelNodeUtils.logPlan(LOGGER, "After join reorder", reordered);
     * already-computed random value ({@code $ref > literal}) becomes a fresh {@code RAND() > literal}
            .bottomUp()
/**  
     * <p><b>The two rules run as SEPARATE HEP instructions</b> — {@code JOIN_TO_MULTI_JOIN} to fixpoint,
        Optional<RelNode> sortPushdown = OpenSearchSortPushdownRewriter.rewrite(modifiedRelNode);  
     */  
import org.opensearch.analytics.planner.rules.OpenSearchDistributionDeriveRule;  
     */
            // phase itself didn't throw). If any survived, discard the reorder and keep the as-written tree.  
            return input;  
            // Defensive: a reorder-rule edge case must not fail planning — Calcite can assert-fail (not just
            // the Aggregate. That Project lands directly beneath the query's own projection, and
                withCorrelates -> RelDecorrelator.decorrelateQuery(
import org.opensearch.analytics.planner.rules.OpenSearchAggregateReduceRule;
        if (lateMat.isPresent()) {  
            RelNode trimmed = new RelFieldTrimmer(null, relBuilder).trim(input);  
                    new OpenSearchValuesRule(context),
import org.apache.calcite.sql.SqlKind;  
            // is already rendered by the "After CBO" DEBUG line in runAllOptimizations, so no dump is needed.
            // that invariant intact and lets TopK oversampling still fire for these queries.  
     * rewrites are the only Calcite source of {@code LITERAL_AGG} that we know
 * <p>TODO: Join strategy selection, sort removal via CBO
                    new OpenSearchFilterRule(context),
import org.opensearch.analytics.planner.rules.OpenSearchTopKRewriter;
 */
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
        modifiedRelNode = extractLiteralAgg(modifiedRelNode, listener);
        // FFM round-trips per RG into one. Blocked on two open design points:
 * SPDX-License-Identifier: Apache-2.0
            // back to the as-written order; correctness is unaffected, only the ordering win is lost. The
import org.opensearch.analytics.AnalyticsSettings;  
        // Trimming is a pure optimization; any trimmer failure must fall back, never fail the query.
    }  
        volcanoPlanner.addRule(new OpenSearchDistributionDeriveRule(context));
            // post-processing step inside the same listener phase.  
     */  
     *
 *
            //
        return node;
        return HepPhase.named("pushdown-rules")
            // deferred failure (marking throws on it, which the try/catch here can't see because the reorder
            modifiedRelNode = lateMat.get();
                    CoreRules.PROJECT_SUB_QUERY_TO_CORRELATE,
    }
        modifiedRelNode = pushdownRules(modifiedRelNode, listener);  
import org.opensearch.analytics.planner.rules.OpenSearchCheckedLongSumWindowRule;  
            // PROJECT_MERGE already ran back in the pushdown phase — so without merging here the  
                    }
     * with 3+ joins that are ALL equi-joins — a 2-way join has a single order (nothing to reorder), and
                .addRuleInstance(CoreRules.JOIN_TO_MULTI_JOIN)
import org.apache.calcite.plan.Contexts;
     * join to carry equi-keys excludes such plans, sibling arm or not; a cross-join never distributes,
     * Package-private so planner rule tests can inspect the marked+optimized tree.  
    private static final Logger LOGGER = LogManager.getLogger(PlannerImpl.class);
import org.apache.calcite.plan.RelTraitSet;
        }
     * {@link OpenSearchAggLiteralArgProjectSplitRule}.
            // but names can drift (it drops alias-only top Projects, e.g. transpose's RENAME). Re-impose
 * compatible open source license.
        // an EXISTS/NOT-EXISTS subquery (LogicalCorrelate, or a semi/anti join once decorrelated — TPC-H
 * {@link PlannerContext}) can be threaded through every planner created here.
    private static RelNode decomposeAggregates(RelNode input, RuleProfilingListener listener) {
        // The PPL frontend injects a SUBSEARCH_MAXOUT Sort(fetch=N) at the top of every subsearch.
import org.opensearch.analytics.planner.rules.OpenSearchProjectRule;  
    static RelNode trimFields(RelNode input) {  
            .run(prepared, listener);
            // RexSubQuery removal introduces LogicalCorrelate; decorrelate back to a  
            return input;
import org.apache.calcite.rel.core.Sort;
                        return rewritten.clone(body);  
     * nodes, then marking lowers the canonical post-pushdown shape in one go.
     *       {@code APPROX_COUNT_DISTINCT(x)} so distinct counts engage the engine-native
import org.opensearch.analytics.planner.rules.OpenSearchBroadcastJoinSplitRule;
        } catch (Exception | AssertionError e) {
     * Pre-marking cost-based join reordering for multi-way joins. Collapses the frontend's  
            RelNode copied = RelNodeUtils.copyToCluster(marked, volcanoCluster, distTraitDef);
     * {@code LITERAL_AGG} directly via {@code RelBuilder.literalAgg(...)}.  
 *       gather all results). Split rule fires on aggregates, Volcano inserts
     */  
            RelNode best = volcanoPlanner.findBestExp();
        // unmarked MultiJoin ("Filter rule encountered unmarked child [MultiJoin]"). Skip those shapes.  
            .run(input, listener);
            // single Project (it treats further Projects as transparent passthroughs), so the  
            }
import org.apache.calcite.rel.rules.CoreRules;
    }  
    private static RelNode reduceExpressions(RelNode input, RuleProfilingListener listener) {
        return runAllOptimizations(rawRelNode, context);
     * including the PPL {@code subsearch} shapes that the frontend lowers to them) into
        volcanoPlanner.addRelTraitDef(distTraitDef);
        if (sortPushdown.isPresent()) {
import org.apache.logging.log4j.Logger;
                )
     * removal phase — for two reasons: (1) phase listing reflects each  
 *  
    }
 *
            .addRuleInstance(CoreRules.FILTER_MERGE)
            RuleProfilingListener.PlannerProfile profile = listener.snapshot();
     * {@code Sort(fetch=N)} at the top of each subsearch; for an EXISTS that limit cannot change the
            // aggregate, getMaxRowCount <= 1): a no-op that the marking rule must not have to
            // SORT_REMOVE_REDUNDANT drops a Sort/LIMIT whose input is provably bounded to
            // Root demands SINGLETON with null locality — satisfied by either SHARD+SINGLETON
     * reorder rules match {@code LogicalProject(MultiJoin)} / {@code LogicalJoin}, and marking lowers
     *  
     * Removes a top-level fetch-only {@link Sort} (no collation, no offset) from the body of every
        List<Join> joins = RelNodeUtils.findNodes(input, Join.class);
                        return rewritten.clone(unlimited);  
            Filter.class,  
     * Invokes Calcite's {@link RelFieldTrimmer} to slim each node to only the columns its consumer  
     */  
                    RelBuilder.proto(Contexts.empty()).create(prepared.getCluster(), null)
                    new ReduceExpressionsRule.ProjectReduceExpressionsRule(Project.class, RelBuilder.proto(Contexts.empty()))
     * resolves leaf predicates through a {@code ScalarFunction} table that doesn't and  
     * {@code rand()} Project inlines {@code RAND()} into the predicate, so a reference to one  
            return best;  
        }  
     * codegen do; the SQL JDBC implementor inlines the literal directly into the
            .addRuleInstance(new OpenSearchAggregateReduceRule())
import org.apache.calcite.rex.RexUtil;
     * {@code EXISTS} {@link RexSubQuery} in the tree. The PPL frontend injects a SUBSEARCH_MAXOUT  
     * <p><b>Declines on any plan containing a non-equi join.</b> The trimmer rewrites the WHOLE tree,  
    /**  
    /**
                    FILTER_PROJECT_TRANSPOSE_DETERMINISTIC,
            // getRowCount; every other metadata def falls through to the default handler chain.
            .addRuleInstance(new OpenSearchCheckedLongSumWindowRule())  
            // throw IndexOutOfBoundsException. Collapsing the pair back into one Project here keeps
                    }
 * @opensearch.internal  
            if (!copied.getTraitSet().equals(desiredTraits)) {
     * Project expressions. Co-locating the reducer with the transposes lets Calcite  
     * the Immutables annotation processor required by RelRule.Config sub-interfaces.  
            context.recordProfilingResults(profile);
    }
            if (!RelNodeUtils.findNodes(reordered, org.apache.calcite.rel.rules.MultiJoin.class).isEmpty()) {
            LOGGER.debug("Join reorder skipped (fell back to as-written order): {}", e.toString());  
            return input;  
        if (!RelNodeUtils.findNodes(input, org.apache.calcite.rel.core.Correlate.class).isEmpty()
        }
 *
        return HepPhase.named("literal-agg-extract").addRuleInstance(new ExtractLiteralAggRule()).run(input, listener);  
    }  
     * Phase 1a: constant-expression reduction on Filter and Project predicates. Kept in  
import org.opensearch.analytics.planner.rules.OpenSearchCheckedLongSumRule;
            // trim() asserts an identity ref-mapping at the root, so field count/order are preserved
     * edge case falls back to the input plan rather than failing the query.
        volcanoPlanner.addRule(new OpenSearchSortSplitRule(context));  
                    CoreRules.PROJECT_MERGE,
import org.opensearch.analytics.planner.rules.OpenSearchValuesCharNormalizeRule;  
            // SORT_PROJECT_TRANSPOSE is intentionally omitted: lifting Project above Sort puts it
     * decorrelate back to a standard join shape. Without this phase, downstream rules see  
            modifiedRelNode = sortPushdown.get();
import org.apache.calcite.rel.rules.ReduceExpressionsRule;
        modifiedRelNode = cbo(modifiedRelNode, rawRelNode, context, listener);  
            RelNodeUtils.logPlan(LOGGER, "After TopK rewrite", modifiedRelNode);
     * <p>This is a <b>semantic-correctness</b> guard, not a delegation/performance one. The stock
        if (!AnalyticsSettings.MPP_JOIN_REORDER.get(context.getSettings())) {
    }
                    new OpenSearchAggregateRule(context),
     *
            trimmed = relBuilder.push(trimmed).rename(input.getRowType().getFieldNames()).build();
        // condition shape, and a leftKeys-non-empty-but-not-pure-equi join would slip a theta predicate into
     */
     *       PPL's reflective {@code CHECKED_LONG_SUM} marker → Calcite's canonical {@code SUM}.</li>
     * lower copy (pushes below the ExchangeReducer). Runs AFTER marking — operates on  
 * </ol>
     * beside a real equi-join — is enough for it to prune every column of the cross-join's unreferenced
                    CoreRules.SORT_REMOVE_REDUNDANT
        // AnnotatedPredicates under OR/NOT (Lucene call buys nothing in those positions).
     * <p>(Aside: such an inlined {@code RAND() > literal} predicate is also what gets incorrectly
            // fixpoint so stacked limits collapse first, then any now-redundant Sort is removed.
        // RelDecorrelator refuses to decorrelate (it only handles fetch==1) — leaving a
     * each worker tier). This is the plan-layer analog of the column-prune win — less data moved by  
                    new OpenSearchSortRule(context),  
     */  
        if (listener != null) {
                    new OpenSearchUnionRule(context),
    private static final FilterProjectTransposeRule FILTER_PROJECT_TRANSPOSE_DETERMINISTIC = FilterProjectTransposeRule.Config.DEFAULT
        volcanoPlanner.addRule(new OpenSearchBroadcastJoinSplitRule(context));
     */
     */
            // RANDOM → ER inserted by ExpandConversionRule + trait def's convert(). Single-shard  
    /**
            return sort.getInput();  
        volcanoPlanner.addRule(AbstractConverter.ExpandConversionRule.INSTANCE);  
                RexSubQuery rewritten = (RexSubQuery) super.visitSubQuery(subQuery);
import org.apache.calcite.rel.RelHomogeneousShuttle;
            .run(input, listener);
    private static RelNode reorderJoins(RelNode input, PlannerContext context, RuleProfilingListener listener) {  
            }
 *   <li>HepPlanner (RBO): converts LogicalXxx → OpenSearchXxx with backend
     * {@code Aggregate + Project} shape via {@link ExtractLiteralAggRule}.
     * </ul>  
     * rule only guards against window functions ({@code !containsOver()}); pushing a Filter past a
                )
            // AGGREGATE_PROJECT_PULL_UP_CONSTANTS lifts constant group keys into a Project above
            // tree keeps two adjacent, column-reordering Projects between any downstream Sort and
import org.apache.calcite.rel.rules.FilterProjectTransposeRule;  
            .addRuleInstance(CoreRules.PROJECT_MERGE)
     * tracked/fixed separately; it is not the reason for this rule.)
            )
        // leaf — today the resolver requires a SqlFunction operator on the original.
     * boolean result (it only tests for ≥1 row), yet it blocks {@link RelDecorrelator} from
            // RelDecorrelator is a visitor (not a RelOptRule) so it runs as a
                List.of(  
     * Runs before {@link OpenSearchAggregateRule} marks the aggregate so the marking phase, the
            .run(input, listener);
                    RelNode body = stripExistsSubqueryLimits(rewritten.rel);  
     * Phase 1b: Filter pushdown past Project / Aggregate / Join via Calcite's transpose rules.  
        volcanoPlanner.addRule(new OpenSearchHashJoinSplitRule(context));  
            @Override
        ).toRule();
     * a cross-join (PPL {@code transpose}) must not be flattened into a {@code MultiJoin}. A reorder-rule  
 * Central planner for the Analytics Plugin.
     * Phase 1b: pre-marking rewrites on plain {@link org.apache.calcite.rel.logical.LogicalAggregate}.  
     * the reordered shape in one pass.
    /**
import org.opensearch.analytics.planner.rules.OpenSearchUnionSplitRule;
            return input;
            // PartiallyOrderedSet build is O(memo^2+) and takes MINUTES for a multi-way join (a 6-way join's  
            RelOptCluster volcanoCluster = RelOptCluster.create(volcanoPlanner, rawRelNode.getCluster().getRexBuilder());
                    RelNode unlimited = stripTopFetchOnlySort(body);
        // Exclude plans carrying a Correlate or a non-INNER join. JOIN_TO_MULTI_JOIN flattens inner joins
                )  
    }
import org.opensearch.analytics.planner.rules.OpenSearchSortPushdownRewriter;
        // (e.g. a.x=b.x AND a.y>b.y) must NOT be flattened into a MultiJoin — the bushy rule is narrow around  
     * decorrelating the correlated subquery. Scoped to EXISTS only — IN / scalar subqueries keep  
     *  
 * <p>Two phases:  
            // the Aggregate. OpenSearchTopKRewriter only composes its sort-key remap through a
     *  
 *       exchanges via trait enforcement where distribution mismatches.</li>  
        try {  
            )  
     *       primitive {@code SUM} / {@code COUNT} (+ {@code SUM_SQ} for variance) plus a scalar
import org.apache.calcite.plan.volcano.AbstractConverter;
            listener.beginPhase("cbo");
            .addRuleInstance(new OpenSearchCheckedLongSumRule())
            RelTraitSet desiredTraits = copied.getTraitSet().replace(distTraitDef.anySingleton());  
     * a {@code RexSubQuery} inside a filter / project predicate and either reject the
    private static RelNode stripExistsSubqueryLimits(RelNode input) {  
        modifiedRelNode = mark(modifiedRelNode, context, listener);  
            return trimmed;  
                volcanoPlanner.setRoot(volcanoPlanner.changeTraits(copied, desiredTraits));
     */  
            .addRuleInstance(CoreRules.AGGREGATE_PROJECT_PULL_UP_CONSTANTS)  
        volcanoPlanner.addRule(new OpenSearchJoinSplitRule(context));
            LOGGER.debug("Field trimming skipped: plan contains a non-equi join (trimmer would mis-rewrite it)");  
            LOGGER.info("Planner profile for raw RelNode is :\n{}", profile.format());  
     * If {@code node} is a {@link Sort} that only limits row count (a {@code fetch} with no sort
        modifiedRelNode = decomposeAggregates(modifiedRelNode, listener);
                    new OpenSearchValuesCharNormalizeRule(),
public class PlannerImpl {
                    withCorrelates,  
    /**
                    CoreRules.FILTER_SUB_QUERY_TO_CORRELATE,
     * into a pinned upper copy (literal stays with the aggregate) over an unpinned physical-only
     * predicate inherits its child's viable backends instead of validating its scalar calls. That is
import org.apache.calcite.rex.RexShuttle;  
        // Strip that limit while the subquery is still an identifiable EXISTS RexSubQuery so the
package org.opensearch.analytics.planner;
        if (node instanceof Sort sort && sort.getCollation().getFieldCollations().isEmpty() && sort.offset == null && sort.fetch != null) {
import org.opensearch.analytics.planner.rules.OpenSearchSortRule;
    /** Phase 2: VolcanoPlanner for trait propagation + exchange insertion. */
     *
     * <ul>  
     */
     * the marking phase observes the plan.
        // AND-sibling AnnotatedPredicates into one combined predicate per group, collapsing N
     * THEN {@code MULTI_JOIN_OPTIMIZE_BUSHY} to fixpoint. Running them in one rule collection loops
        VolcanoPlanner volcanoPlanner = new VolcanoPlanner();
import org.opensearch.analytics.planner.rules.OpenSearchFilterRule;
        } finally {
        return HepPhase.named("agg-literal-arg-split").addRuleInstance(new OpenSearchAggLiteralArgProjectSplitRule()).run(input, listener);

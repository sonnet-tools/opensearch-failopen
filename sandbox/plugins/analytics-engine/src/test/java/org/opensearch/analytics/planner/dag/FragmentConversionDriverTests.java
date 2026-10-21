        assertEquals(1, r.plan.delegatedExpressions().size());
        );
            leftScan,
            serializer,
                "test_index",
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            }
            // EQUALS on message (keyword, indexed) — dual-viable
            condition
            condition
     * <p>Rule: a dual-viable leaf is performance-delegated under AND (one delegation_possible per
            dfConvertor,
    public void testMixedAndOrAndWithNative() {
        null,
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
     * post-combiner shape via three counters:
    }
        var context = buildContext("parquet", fields, List.of(df, lucene));
        // OR siblings targeting same backend should be combined into 1 DelegatedExpression
        );
        RecordingSerializer serializer = new RecordingSerializer();
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
                map.put(ScalarFunction.WILDCARD, serializer);
    private void assertCombinerShape(
        // 4 fields: Title(keyword,indexed), Referer(keyword,indexed), URL(keyword,indexed), GoodEvent(int,NOT indexed)
import org.opensearch.analytics.spi.FragmentConvertor;
    }
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
                return Set.of(DelegationType.FILTER);
        assertFalse("precondition: tree is not flat", RexUtil.isFlat(nested));
        // tag, message both keyword(indexed) → dual-viable for EQUALS; amount int(not indexed) = native.
        FragmentConversionDriver.IntraOperatorDelegationBytes delegationBytes = new FragmentConversionDriver.IntraOperatorDelegationBytes(
import java.util.ArrayList;
            public FragmentConvertor getFragmentConvertor() {
        // delegated_predicate markers, delegation_possible markers}. Single expectation per shape:
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(plan));
        return LogicalUnion.create(List.of(arm1, arm2), true);
        // status is index=true → both DataFusion and Lucene viable → now fully delegated to Lucene.
                Map.of("type", "integer", "index", false)
        RecordingConvertor dfConvertor = new RecordingConvertor();
     */
        );
        // it's reclassified to correctness and ships to the peer, fusing with same-backend siblings.
                "Referer",
        MockLuceneBackend lucene = new MockLuceneBackend() {
        // AND. Under OR/NOT it cannot stay perf (perf delegation is AND-only in the data node), so
            -1,
            new String[] { "tag", "message", "amount" },
    // ---- Interleaved AND/OR/NOT ----
    }
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
            plan,
            if (found != null) return found;
        // AND(OR(AND(match_phrase, fuzzy), match_phrase), fuzzy)
        assertTrue("Combined should contain FUZZY", combinedStr.contains("FUZZY"));
            { "AND(MATCH, EQUALS-perf)", makeAnd(match, eqPerf), new int[] { 2, 1, 1 } },
            label + " — delegated_predicate markers (plan: " + stripped + ")",
                10
    public void testUnionOverPassthroughThenExchange() {
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
            "2-leaf OR(correctness, perf): exactly 1 delegated_predicate marker at top",
    private QueryDAG buildDelegationDag(
        QueryDAG sortDag = buildAndConvert(
            @Override
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        AnnotatedProjectExpression.class.getSimpleName()
                    makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
            serializer
            @Override
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        QueryDAG dag = buildDelegationDag(
        RecordingSerializer serializer = new RecordingSerializer();
        assertNotNull(convertor.reduceFragment);
            assertEquals(
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
        assertShardScanConverted(convertor, dataNodeStage(dag));
        assertTrue("at least 1 expression", r.plan.delegatedExpressions().size() >= 1);
    );
                return dfConvertor;
        };
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
    /** OR(AND(match_phrase, fuzzy), AND(wildcard, regexp)) — pure Lucene both sides, fully combined to 1. */
    }
        assertEquals(1, dag.rootStage().getChildStages().size());
    private static final Set<String> OPENSEARCH_OPERATORS = Set.of(
        assertTrue("Recorded reduce fragment must be rooted at a LogicalJoin (got:\n" + recorded + ")", recorded.contains("LogicalJoin"));
            convertor
            assertEquals("delegatedPredicateCount in instruction", expectedDelegatedCount, filterInstruction.getDelegatedPredicateCount());
        assertEquals(2, plan.delegatedExpressions().size());
        SqlKind.OTHER_FUNCTION,
        QueryDAG dag = buildSingleFieldDelegationDag(
                "Stripped plan should not contain " + DelegatedPredicateFunction.NAME,
                "GoodEvent",
    public void testInterleavedAndOrNot() {
        QueryDAG dag = buildAndConvert(
        assertEquals(1, r.plan.delegatedExpressions().size());
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        RexNode condition = rexBuilder.makeCall(
                Map.of("type", "integer", "index", false)
    }
                map.put(ScalarFunction.REGEXP, serializer);
        MockDataFusionBackend df = new MockDataFusionBackend() {
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), false),
        RexNode flatInput = makeAnd(eqA, or(eqA, eqB));
     * the whole Union subtree as one convertFragment (final-agg shape) call — same path as Join.
    }
        assertEquals("Should have 1 combined delegated expression", 1, plan.delegatedExpressions().size());
            List.of(),
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        assertFalse(
            }
        RecordingSerializer serializer = new RecordingSerializer();
        String recorded = RelOptUtil.toString(convertor.reduceFragment);
        );
        return new FuseTestSetup(dfConvertor, serializer, condition);
        String stripped = RelOptUtil.toString(dfConvertor.shardScanFragment);
        return buildDelegationDag(
            );
            plan.delegatedExpressions().getFirst().getExpressionBytes(),
            rexBuilder.makeLiteral("hello")
    public void testPartialAggregateInstruction_emittedForApproxCountDistinct() {
     * Uses 3 fields: message(keyword,indexed), amount(int,NOT indexed), count(int,NOT indexed).
                map.put(ScalarFunction.FUZZY, serializer);
            rexBuilder.makeCall(SqlStdOperatorTable.NOT, makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru")),
        var backends = delegationBackends(dfConvertor, serializer);
                Map.of("type", "keyword", "index", true),
     * Expected: delegation_possible(Referer='google' AND URL='US', 0) AND GoodEvent=1
    }
            }
    /** Two-keyword-field delegation helper. Both fields are dual-viable; no integer field is
        final List<String> serializedFunctions = new ArrayList<>();
            protected Set<DelegationType> supportedDelegations() {
        RexNode flat = RelNodeUtils.deepFlatten(rexBuilder, nested);
        if (node instanceof RexCall call) {
            current = current.getChildStages().get(0);
            new String[] { "tag", "message" },
    /** Builds Filter(count=1)[HAVING] over Aggregate(group=message, count(*)) over Filter(where)[scan]. */
        );
     * Coord-side Union with pass-through operators (Sort/Project) between each arm and its
     * Regression for the RexUtil.isFlat AssertionError. After predicate delegation strips the
        List<String> expectedFunctions,
        RecordingSerializer serializer,
            RexNode condition = (RexNode) testCase[1];
        assertEquals(1, r.plan.delegatedExpressions().size());
            notFuzzy
            protected Set<DelegationType> supportedDelegations() {
            // EQUALS on tag (keyword, indexed) — dual-viable, performance-delegation candidate
     *
    // Operator markers that carry annotations and must be stripped before isthmus conversion.
    public void testAndCorrectnessOrPerfWithNative() {
                return dfConvertor;
            count++;
        QueryDAG dag = buildAndConvert(2, makeAggregate(countStarCall()), convertor);
                return dfConvertor;
                return Map.of();
    }
    private LogicalJoin makeInnerEquiJoin() {
        );
        assertTrue("coord-side reduce instructions must be empty", plan.instructions().isEmpty());
        RelNode arm1 = buildSortedAggArm();
    private static Stage dataNodeStage(QueryDAG dag) {
import org.apache.calcite.sql.type.SqlTypeName;
            { "OR(NOT(MATCH), EQUALS-perf, native)", or(notMatch, eqPerf, nativeArm), new int[] { 1, 1, 0 } },
                return Set.of(DelegationType.FILTER);
        // amount is index=false → equals stays native; only MATCH_PHRASE + FUZZY get delegated.
            public DelegatedSubtreeConvertor getDelegatedSubtreeConvertor() {
            protected Set<DelegationType> acceptedDelegations() {
    public void testAndTwoDelegatedWithCombining() {
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
    }
        SqlKind.OTHER_FUNCTION,
        int expectedDelegatedCount,
     */
            }
    }
     * Builds an After-HEP shape close to JoinCommandIT#testInnerJoin: a top-level
        QueryDAG dag = buildKeywordFuseDag(ctx.condition, ctx.dfConvertor, ctx.serializer);
            join,
    public void testAndCorrectnessAndMultiplePerfAndNative() {
        RecordingConvertor dfConvertor = new RecordingConvertor();
import org.apache.calcite.util.ImmutableBitSet;
                "URL",
    public void testJoinDirectlyOverTwoExchanges() {
        RexNode nested = makeAnd(not(or(eqA, or(eqB, eqC))), eqD);
            public DelegatedSubtreeConvertor getDelegatedSubtreeConvertor() {
        RelNode cboOutput = runPlanner(filter, context);
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
            @Override
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
            serializer,
            public FragmentConvertor getFragmentConvertor() {
     * NOT match(message,'hello') AND tag='hello'
     *   <li>{@code delegated_predicate(id)} markers (peer evaluates these end-to-end),</li>
        var context = buildContext("parquet", fields, backends);
                Map.of("type", "keyword", "index", true),
        assertTrue(RexUtil.isFlat(flat));
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
                Map.of("type", "keyword", "index", true),
    private void assertShardHasPartialAggInstruction(QueryDAG dag, String label) {
            );
        RelNode cboOutput = runPlanner(filter, context);
 */
        // Pure flatten: the inner OR's 3 operands splice into the middle OR (eq2 + 3 = 4), none deduped.
                return dfConvertor;
    private void assertDelegationResult(
        assertEquals("AND(OR(AND,leaf),leaf) pure Lucene should produce 1 expression", 1, plan.delegatedExpressions().size());
    /** OR(AND(match_phrase, fuzzy, wildcard), amount=200) — all 3 Lucene AND-combined, then OR with native. */
     * to hash-repartition groups within the shard, producing incorrect cross-shard merges.
                "Referer",
            dfConvertor,
     * EQUALS-on-int is NOT a Lucene cap in prod even when the field has BKD points.
     *  whether a coord stage sits above. */
                return dfConvertor;
        RecordingSerializer serializer = new RecordingSerializer();
        var context = buildContext("parquet", fields, backends);
            // ── AND: perf stays perf (delegation_possible per perf leaf) ──
     */
        // build-side row type (any OpenSearchTableScan would do).
        StagePlan plan = runHaving(matchPhrase("hello"));
        RecordingConvertor dfConvertor = new RecordingConvertor();
        QueryDAG scanDag = buildAndConvert(1, stubScan(mockTable("test_index", "status", "size")), scanConvertor);
                "GoodEvent",
        );
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
            project,
        };
        assertNotNull("join stage alternative must have convertedBytes", joinStage.getPlanAlternatives().getFirst().convertedBytes());
        // Rust's apply_aggregate_mode strip, which corrupted column refs (cnt[sum]/cnt[count]).
            FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION
        // Should produce 1 combined DelegatedExpression (not 2 individual ones)
        );
            @Override
    }
    }
            makeFullTextCall(FUZZY_FUNCTION, 1, "wrld")
    // ---- Helpers ----
    // AggregateCallAnnotation is stored on OpenSearchAggregate as a side-map (not in
        return current;
        assertDelegationResult(plan, dfConvertor, serializer, 1, true, true, List.of("MATCH_PHRASE"), FilterTreeShape.CONJUNCTIVE);
import java.util.HashMap;
            countOccurrences(stripped, "delegated_predicate")
     *       (two child stages).</li>
    private static final SqlFunction REGEXP_FN = new SqlFunction(
            dfConvertor,
            "message",
            SqlStdOperatorTable.OR,
                return map;
     * NOT(correctness) combined into BoolQuery(must_not) + perf-delegated under AND combined separately.
        var r = runCombining(or(matchPhrase("hello"), amountEquals(200), fuzzy("wrld")));
            dfConvertor,
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
            true,
                .stream()
            }
        );
            @Override
        RecordingSerializer serializer = new RecordingSerializer();
     *   - field 0 = status   (integer, indexed). NOTE: prod Lucene only filters keyword/text/
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
        };
            "treeShape must come from the WHERE (CONJUNCTIVE), not the HAVING (NO_DELEGATION)",
        RecordingSerializer serializer = new RecordingSerializer();
        assertTrue(
    }
        assertEquals(2, r.plan.delegatedExpressions().size());
    }
        // EQUALS on tag (keyword, indexed) — dual-viable, perf-delegation candidate.
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
    public void testSingleNativePredicate() {
            }
        var r = runCombining(makeAnd(or(matchPhrase("hello"), fuzzy("wrld")), or(wildcard("h*"), amountEquals(200))));
    public void testSinglePerformanceDelegatedPredicate() {
                    makeEquals(1, SqlTypeName.VARCHAR, "google"),
            @Override
        // Single shard: no exchange split, so HAVING + Aggregate + WHERE stay in ONE fragment — the
        assertShardHasPartialAggInstruction(dag, "SUM");
        RelNode cboOutput = runPlanner(filter, context);
                return dfConvertor;
            "Stripped plan should contain " + DelegationPossibleFunction.NAME,
                map.put(ScalarFunction.FUZZY, serializer);
            @Override
/*
    /** Mark a logical scan via the planner so it becomes OpenSearchTableScan. */
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        // Verify the stripped plan still has AND (placeholder + native)
    /** AND(OR(match_phrase, amount=200), fuzzy) — match_phrase can't merge with fuzzy across OR → 2 expressions. */
        assertEquals(4, ((RexCall) middleOr).getOperands().size());
    public void testCombine_AndLuceneOrMixedLucene() {
        MockLuceneBackend lucene = new MockLuceneBackend() {
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        RexNode notMatch = rexBuilder.makeCall(SqlStdOperatorTable.NOT, match);
    public void testLeftBuildProbeFragmentRoutesToShardScanConversion() {
            stubScan(
            IllegalStateException.class,
     */
        RexNode flat = RelNodeUtils.deepFlatten(rexBuilder, nested);
    }
            strippedPlan.contains(DelegationPossibleFunction.NAME)
        RecordingConvertor dfConvertor,
            SqlStdOperatorTable.SUM,
            // ── OR perf-only: perf reclassified to correctness, fused into one peer shipment ──
        QueryDAG dag = buildAndConvert(2, makeAggregate(sumCall()), convertor);
        assertEquals(
        RexNode fuzzy = makeFullTextCall(FUZZY_FUNCTION, 1, "wrld");
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 1),
        ReturnTypes.BOOLEAN,
    }
        OperandTypes.ANY,
    }
        };
        org.opensearch.analytics.planner.rel.OpenSearchJoin probeJoin = new org.opensearch.analytics.planner.rel.OpenSearchJoin(
            @Override
        QueryDAG dag = buildTwoFieldDelegationDag(
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 1),
        // Both child stages converted as shard scans.
     * (CONJUNCTIVE), not the topmost HAVING (NO_DELEGATION). Regression: picking the topmost filter
            }
                return map;
        MockDataFusionBackend df = new MockDataFusionBackend() {
            @Override
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
            );
    }
        // shape the bug needs (multi-shard forks HAVING into a separate reduce stage, hiding it).
            protected Set<DelegationType> acceptedDelegations() {
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
    private CombiningResult runCombining(RexNode condition) {
        Object[][] cases = {
     * LogicalFilter.create's recursive isFlat assertion fires. RelNodeUtils.deepFlatten walks the
        RecordingSerializer serializer = new RecordingSerializer();
            1,
        };
        LOGGER.info("Stripped plan:\n{}", strippedPlan);
    /**
            @Override
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
     * </ul>
            assertTrue(
            @Override
                Set<EngineCapability> caps = new java.util.HashSet<>(super.supportedEngineCapabilities());
        var context = buildContext("parquet", shardCount, intFields(), List.of(df));
            }
        assertEquals(1, r.plan.delegatedExpressions().size());
        RecordingConvertor convertor = new RecordingConvertor();
        Stage stage = dag.rootStage();
            protected Set<DelegationType> acceptedDelegations() {
        };
     * a disjunction, and a correctness sibling is present, so the combiner fuses the entire OR into
                plan.delegatedExpressions().size(),
        RecordingConvertor dfConvertor = new RecordingConvertor();
            { "OR(MATCH, FUZZY)", or(match, fuzzy), new int[] { 1, 1, 0 } },
        RexNode condition,
import org.apache.calcite.rel.logical.LogicalProject;
        // Construct probe-stage fragment manually: Join(BroadcastScan, TableScan).
        );
            }
        assertEquals(1, plan.delegatedExpressions().size());
            Map.of(
     * nothing forces it — so DataFusion never evaluated it. A demoted result here would show a bare
        );
        );
            condition,
    // like __row_id__) — see OpenSearchTableScan#stripAnnotations.
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
        RelNode cboOutput = runPlanner(logical, context);
        );
                return Set.of(DelegationType.FILTER);
            "perf can't survive under OR — must not have delegation_possible",
        QueryDAG dag = buildDelegationDag(
        RexNode condition = rexBuilder.makeCall(
        assertTrue("deepFlatten must produce a flat tree", RexUtil.isFlat(flat));
     * Tree shape: INTERLEAVED (delegation under OR)
            List.of(),
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
import org.opensearch.analytics.planner.RelNodeUtils;
        // The OR nested under NOT must also be flattened (shuttle recurses through NOT).
        RexNode condition = rexBuilder.makeCall(
        );
        // Root stage: convertFinalAggFragment called on the stripped join fragment.
    }
        assertEquals("exactly 1 delegated_predicate marker at top", 1, countOccurrences(strippedPlan, "delegated_predicate"));
            .findFirst()
/**
        RecordingConvertor dfConvertor = new RecordingConvertor();
        );
    private QueryDAG buildKeywordFuseDag(RexNode condition, RecordingConvertor dfConvertor, RecordingSerializer serializer) {
        );
     * one shipped expression; the plan carries delegation_possible (DataFusion prunes natively +
        boolean expectNativeEquals,
            "message",
        QueryDAG dag = buildSingleFieldDelegationDag(
            rightScan,
            Map.of(
    public void testPartialAggregateInstruction_emittedForFilteredAggregate() {
    private static final Set<String> ANNOTATION_MARKERS = Set.of(
        "REGEXP",
            SqlStdOperatorTable.EQUALS,
        assertEquals("delegatedQueries count", 1, plan.delegatedExpressions().size());
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
     * Mirrors prod Lucene's {@code STANDARD_TYPES = {KEYWORD, TEXT, MATCH_ONLY_TEXT}} —
        LOGGER.info("Marked+CBO:\n{}", RelOptUtil.toString(cboOutput));
     * Expected: delegated_predicate(0) AND delegation_possible(Referer, 1) OR delegation_possible(URL, 2) AND GoodEvent=1
        LogicalFilter where = LogicalFilter.create(scan, whereCondition);
        QueryDAG aggDag = buildAndConvert(1, makeAggregate(sumCall()), aggConvertor);
        assertEquals(1, r.plan.delegatedExpressions().size());
                default:
        );
                map.put(ScalarFunction.REGEXP, serializer);
    ) {
        RexNode condition,
import org.opensearch.analytics.spi.DelegatedSubtreeConvertor;
        RecordingSerializer serializer = new RecordingSerializer();
     * correctness-delegated leaf, all same-backend, under OR. Performance delegation can't survive
    /**
     */
        assertEquals(1, r.plan.delegatedExpressions().size());
     * 28,313,573).
     */
        RecordingSerializer serializer = new RecordingSerializer();
        // Instruction assertions: delegation plans must have SHARD_SCAN + FILTER_DELEGATION_FOR_INDEX
            .orElseThrow(() -> new AssertionError("delegation plan must have SHARD_SCAN_WITH_DELEGATION"));
                rexBuilder.makeCall(SqlStdOperatorTable.NOT, makeFullTextCall(MATCH_PHRASE_FUNCTION, 1, "hello")),
        assertTrue(
    // because it carries no annotations and isthmus only reads its rowType + qualified name.
    public void testNotEqualsStaysNative() {
    }
    private RexNode wildcard(String pattern) {
            @Override
        assertEquals(2, r.plan.delegatedExpressions().size());
import org.apache.calcite.rel.logical.LogicalUnion;
            LogicalFilter.create(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
            "Recorded reduce fragment must carry two OpenSearchStageInputScan leaves (got:\n" + recorded + ")",
                makeAggregate(
     * Multi-shard Aggregate(Scan) — child calls convertFragment (shard-scan shape),
        QueryDAG dag = buildAndConvert(
        assertEquals("Only serializable predicates delegated", 1, plan.delegatedExpressions().size());
    /**
    // ---- Dual-viable leaves stay performance-based by default ----
        assertFalse("perf ships to Lucene under OR — no delegation_possible", strippedPlan.contains(DelegationPossibleFunction.NAME));
        RexNode eqA = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(1, intType, true));
     *   - field 2 = amount   (integer, NOT indexed) — SINGLE-VIABLE to DataFusion only.
            @Override
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
                "URL",
        };
                ),
     *     purposes only. Pre-existing tests use this to exercise the dual-viable performance
import org.apache.calcite.rex.RexCall;
        RecordingConvertor dfConvertor = new RecordingConvertor();
            Map.of(
            protected Set<DelegationType> acceptedDelegations() {
            java.nio.charset.StandardCharsets.UTF_8
    // ---- Single predicate ----
        assertDoesntContainOperators(convertor.reduceFragment, ANNOTATION_MARKERS);
            Map.of(
        );
        // We use a minimal cluster + scan to avoid driving the full advisor/rewriter chain —
        assertNotNull("convertedBytes must be set", stage.getPlanAlternatives().getFirst().convertedBytes());
        RexNode eq1 = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(1, intType, true));
        LOGGER.info("Plan (OR correctness with perf+native):\n{}", strippedPlan);
        }
        );
            @Override
            new org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan(
        RecordingSerializer serializer = new RecordingSerializer();
    }
    private RexNode matchPhrase(String query) {
    }
        );
            org.apache.calcite.rel.RelCollations.of(new org.apache.calcite.rel.RelFieldCollation(0)),
        assertShardHasPartialAggInstruction(dag, "COUNT");
            dfConvertor,
    /**
                )
        StagePlan plan = shardStage.getPlanAlternatives().getFirst();
        String stripped = RelOptUtil.toString(c.shardScanFragment);
            mockTable(
        QueryDAG dag = buildTwoFieldDelegationDag(condition, dfConvertor, serializer);
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            serializer,
        // Mirror production: the OR(=,=,=) is nested one level DOWN inside an AND, not at the
    }
        RecordingSerializer serializer = new RecordingSerializer();
        RexNode condition = rexBuilder.makeCall(
            protected Set<DelegationType> acceptedDelegations() {
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
            Map.of("message", Map.of("type", "keyword", "index", true))
     * {@code OpenSearchExchangeReducer} legs, each reducing a separate scan subtree.
        MockDataFusionBackend df = new MockDataFusionBackend() {
                return dfConvertor;
    // ---- Two-stage shapes ----
        RecordingConvertor scanConvertor = new RecordingConvertor();
     */
     * coord must gather). The test verifies convertFragment (shard-scan shape) is called on the
                makeEquals(2, SqlTypeName.INTEGER, 200),
    }
    /**
        return dag;
            convertor
    }
            serializer
                Map.of("type", "keyword", "index", true),
        assertTrue("Combined should contain MATCH_PHRASE", combinedStr.contains("MATCH_PHRASE"));
     * <p>This is Gap #1's end-to-end coverage anchor: if something in the planner/DAG stack
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
            List.of(),
        RexNode condition = makeAnd(makeEquals(2, SqlTypeName.INTEGER, 200), orClause);
    private static final SqlFunction MATCH_PHRASE_FUNCTION = new SqlFunction(
        MockDataFusionBackend df = new MockDataFusionBackend() {
    // ---- OR conditions ----
            makeAnd(
        RelNode leftProject = LogicalProject.create(
        var context = buildContext("parquet", fields, backends);
        }
import org.apache.logging.log4j.LogManager;
import org.opensearch.analytics.planner.PlannerContext;
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
    public void testAggregateOnFilteredScan() {
                return Set.of(DelegationType.FILTER);
        assertEquals("delegatedQueries count", expectedDelegatedCount, plan.delegatedExpressions().size());
        // The combined bytes should contain both predicates (via DelegatedSubtreeConvertor)
            java.nio.charset.StandardCharsets.UTF_8
                SqlStdOperatorTable.EQUALS,
            assertFalse("Stripped plan should not contain MATCH_PHRASE", strippedPlan.contains("MATCH_PHRASE"));
        AggregateCall sumCall = AggregateCall.create(
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
        while ((idx = haystack.indexOf(needle, idx)) != -1) {
            Stage found = findStageWithTwoChildren(child);
        assertTrue("Should have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));
            rexBuilder.makeCall(
        assertTrue("convertFragment (final-agg shape) must be called", convertor.finalAggCalled);
        RecordingConvertor dfConvertor = new RecordingConvertor();
        assertEquals("1 delegated expression (whole OR ships as one peer subtree)", 1, plan.delegatedExpressions().size());
            new String[] { "Referer", "URL", "GoodEvent" },
     * match(Title,'ru') AND Referer='google' AND URL='US' AND GoodEvent=1
            }
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
            .findFirst()
            assertEquals("treeShape in instruction", expectedTreeShape, filterInstruction.getTreeShape());
            public FragmentConvertor getFragmentConvertor() {
     * (count=1) above and the delegated WHERE (match_phrase) below. The derived FilterTreeShape
     * Multi-shard variant: each join side scans a 5-shard index. Conversion shape is identical;
            @Override
        RecordingConvertor convertor = new RecordingConvertor();
        RexNode ref = rexBuilder.makeInputRef(intType, 0);
     * count Aggregate over a Join of two separately-aggregated, separately-projected
                return Set.of(DelegationType.FILTER);
        assertTrue("Should have delegation_possible", strippedPlan.contains(DelegationPossibleFunction.NAME));
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
            // ── OR/NOT with a same-backend correctness sibling: perf fuses into it → 1 delegated_predicate ──
     * data-node child stage and the fragment is fully stripped.
        RecordingConvertor dfConvertor = new RecordingConvertor();
    public void testDeepFlatten_alreadyFlatUnchanged() {
        };
    }
        );
                makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
            stage = stage.getChildStages().getFirst();
    /**
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        RelOptTable table = mockTable("test_index", "status", "size");
     */
        };
        int expDelegatedPredicate,
    }
        MockDataFusionBackend df = new MockDataFusionBackend() {
     * Pins: exactly 1 delegated_predicate marker, zero delegation_possible markers, 1 expression.
        RecordingConvertor dfConvertor,
        OpenSearchProject.class.getSimpleName()
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        // executeLocalPlan path; the previous SETUP_FINAL_AGGREGATE instruction routed through
        assertNotNull(fragment);
     *  involved, so this stays consistent with prod Lucene caps. */
        QueryDAG dag = buildKeywordPlusNativeDag(makeAnd(tagEq, msgEq), dfConvertor, serializer);
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
                makeEquals(0, SqlTypeName.INTEGER, 200)
        QueryDAG dag = buildAndConvert(2, makeAggregate(approxCountDistinctCall(scan)), convertor);
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
     */
        };
            }
    public void testCombine_OrFlatFivePredicates() {
        RecordingConvertor dfConvertor = new RecordingConvertor();
    }
        QueryDAG dag = buildAndConvert(3, makeInnerEquiJoin(), convertor);
        while (!stage.getChildStages().isEmpty()) {
            }
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
     * <p>Now the combiner collapses an OR/NOT with a same-backend correctness sibling into one
                return dfConvertor;
        assertFalse("Should NOT have delegation_possible", strippedPlan.contains(DelegationPossibleFunction.NAME));
            @Override
     * annotation wrappers in FragmentConversionDriver.strip(), an {@code IN (1,2,3)} expands to
            scan,
import org.apache.calcite.rel.logical.LogicalJoin;
            makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeFullTextCall(FUZZY_FUNCTION, 0, "wrld")),
            @Override
     */
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
                Map.of("type", "integer", "index", false)
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
        RecordingSerializer serializer = new RecordingSerializer();
                makeEquals(2, SqlTypeName.INTEGER, 1)
        };
            filterConvertor
        QueryDAG filterDag = buildAndConvert(
        RexNode ref = rexBuilder.makeInputRef(intType, 0);
            false,
        assertTrue("Should have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
     */
        assertDoesntContainOperators(dfConvertor.shardScanFragment, ANNOTATION_MARKERS);
     * Dual AND Dual: both leaves stay performance-based. The two same-backend perf leaves fuse into
            assertCombinerShape(label, condition, expected[0], expected[1], expected[2]);
            SqlStdOperatorTable.OR,
        RecordingConvertor dfConvertor = new RecordingConvertor();
     * Lucene accepts delegation for MATCH_PHRASE, FUZZY, WILDCARD, REGEXP.
                "tag",
        // Only MATCH_PHRASE delegated; EQUALS stays native (no serializer)
        // doesn't fold them. message is also keyword(indexed) → dual-viable.
        RexNode eq3 = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(3, intType, true));
        // Multi-shard so PR #21639's split rule demands COORDINATOR+SINGLETON on each input,
                return Set.of(DelegationType.FILTER);
        RecordingConvertor dfConvertor = new RecordingConvertor();
        RecordingSerializer serializer = new RecordingSerializer();
                    return call.getOperator().getName();
     * Multi-shard Sort(Aggregate(Filter(Scan))) with limit — full OLAP pipeline, two stages.
            expDelegationPossible,
        assertEquals(2, ((RexCall) flat).getOperands().size());
            Map.of("type", "keyword", "index", true),
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
        var r = runCombining(or(makeAnd(matchPhrase("hello"), fuzzy("wrld"), wildcard("h*llo")), amountEquals(200)));
            .stream()
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
        // message=keyword(indexed), amount=integer(NOT indexed → native only)
        LOGGER.info("Plan (NOT equals → NOT_EQUALS, no serializer):\n{}", strippedPlan);
     * siblings into one delegated_predicate. Native-only siblings stay native at the top.
        return makeFullTextCall(FUZZY_FUNCTION, 0, query);
     * Under OR the Referer/URL perf leaves ship to Lucene (reclassified to correctness), so the plan
        );
            convertor
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
            condition
            { "OR(NOT(MATCH), EQUALS-perf)", or(notMatch, eqPerf), new int[] { 1, 1, 0 } },
            )
            condition,
 * and the correct {@link FragmentConvertor} method is called per leaf type,
            rexBuilder.makeCall(
        RecordingConvertor dfConvertor = new RecordingConvertor();
        };
                makeEquals(1, SqlTypeName.VARCHAR, "US"),
            makeSort(
import org.apache.calcite.plan.RelOptUtil;
     * carries delegated_predicate but no delegation_possible. GoodEvent is native.
            List.of("status", "size")
        assertDelegationResult(
        for (String op : forbidden)
        var context = buildContext("parquet", fields, backends);
        assertDoesntContainOperators(convertor.shardScanFragment, ANNOTATION_MARKERS);
    /** An already-flat tree is returned unchanged (and stays flat). */
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        ReturnTypes.BOOLEAN,
                Map.of("type", "keyword", "index", true),
        );
        return runPlanner(logicalScan, ctx);
        Stage joinStage = findStageWithTwoChildren(dag.rootStage());
            RelCollations.EMPTY,
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
    public void testNotCorrectnessAndPerfDelegation() {
        PlannerContext context = buildContext("parquet", 1, fields, backends);
            stubScan(
                map.put(ScalarFunction.FUZZY, serializer);
    public void testNotCorrectnessDelegation() {
    /**
            SqlStdOperatorTable.OR,
                rexBuilder.makeLiteral("alpha")
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
     *  Calcite's SEARCH/Sarg rewrite from folding the two EQUALS into a sargable predicate.
            @Override
        );
        // Coord-side reduce stages no longer register FinalAggregateInstructionHandler.
        // but EQUALS has no serializer on lucene → stays native
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
                return (subtree, fieldStorage) -> {
     *  for the perf-delegation candidates — matches prod Lucene's filterable types
        assertEquals(SqlKind.AND, andCall.getKind());
            switch (call.getKind()) {
                strippedPlan.contains(DelegatedPredicateFunction.NAME)
        org.opensearch.analytics.planner.rel.OpenSearchTableScan probeScan =
import java.util.List;
            label + " — delegation_possible markers (plan: " + stripped + ")",
        RecordingConvertor dfConvertor = new RecordingConvertor();
    }
    private static Stage findStageWithTwoChildren(Stage stage) {
            @Override
    public void testTwoStageSortOnAggregateOnFilteredScan() {
            serializer
     * <p>Regression guard for the perf-demotion bug: previously every dual-viable leaf was demoted to
        RelNode scan = stubScan(
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
 * compatible open source license.
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
        RecordingConvertor convertor = new RecordingConvertor();
        MockLuceneBackend lucene = new MockLuceneBackend() {
    public void testCoordinatorCentricJoinConversionMultiShard() {
        // delegation is now decided purely by tree position.
                rexBuilder.makeLiteral("hello")
        RecordingSerializer serializer = new RecordingSerializer();
    private void assertReduceStageConverted(RecordingConvertor convertor, Stage stage) {
     * pass-through operators above each ER.
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
     */
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
        // Lucene backend has serializer for MATCH_PHRASE but NOT for FUZZY
    /**
            false,
        );
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
    // aggCall.rexList), so it never appears in the plan's textual representation —
            serializer,
        }
        // producing OpenSearchJoin(ER(scan), ER(scan)) with two child stages — the coord-centric
    }
    private FilterTreeShape treeShapeOf(StagePlan plan) {
            countOccurrences(strippedPlan, "delegation_possible")
                Map.of("type", "integer", "index", true),
                Map.of("type", "integer", "index", false)
        RecordingConvertor c = new RecordingConvertor();
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
                return map;
        }
            1,
            false,
        assertEquals("delegatedPredicateCount", 1, delegationInstruction.getDelegatedPredicateCount());
            "Dual AND Dual must stay performance-based (delegation_possible present). Plan: " + stripped,
import org.opensearch.analytics.spi.DelegatedPredicateFunction;
        // the goal is to exercise FragmentConversionDriver.convert against the new shape.
        assertDelegationResult(plan, dfConvertor, serializer, 1, true, true, List.of("MATCH_PHRASE", "FUZZY"), FilterTreeShape.CONJUNCTIVE);
        assertEquals(label + " — delegatedExpressions (plan: " + stripped + ")", expDelegatedExprs, p.delegatedExpressions().size());
     */
}
     * Single dual-viable equals on an indexed integer field — DataFusion narrows the operator
        Stage shardStage = dag.rootStage().getChildStages().getFirst();
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
import org.apache.calcite.sql.SqlFunction;
     * input, leaving {@code convert()} unable to route the fragment.
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
    /**
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
            condition,
        RelNode logical = buildUnionOverSortedAggArms();
        assertNotNull(bytes);
            dfConvertor,
        LOGGER.info("Marked+CBO:\n{}", RelOptUtil.toString(cboOutput));
     */
        RecordingConvertor dfConvertor = new RecordingConvertor();
    /**
            }
     * leaf); under OR/NOT it's reclassified to correctness, fusing with any same-backend correctness
    }
            @Override
            }
     */
            "amount",
            .filter(n -> n.type() == InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION)
    }
        );
        RecordingConvertor convertor = new RecordingConvertor();
            rexBuilder.makeInputRef(intType, leftCols)
        // Tree shape carries CONJUNCTIVE so the driving backend knows about the delegation.
    public void testOrNativeAndDelegated() {
            assertTrue("Stripped plan should contain native equals", strippedPlan.contains("="));
            SqlStdOperatorTable.OR,
    }
    // ---- OR with mixed correctness + performance delegation ----
        assertShardHasPartialAggInstruction(dag, "APPROX_COUNT_DISTINCT (engine-native)");
     * the number of shards only affects target resolution at dispatch time, not the conversion
            }
                return Set.of(DelegationType.FILTER);
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);
        }
        // No annotation markers should survive stripping
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
                return Set.of(DelegationType.FILTER);
    // ---- Left-build broadcast conversion ----
        assertShardScanConverted(scanConvertor, dataNodeStage(scanDag));
        LOGGER.info("Plan (NOT correctness):\n{}", strippedPlan);
        );
    // ---- HAVING regression: delegated WHERE under an Aggregate with a HAVING filter above ----
    );
        );
                makeFullTextCall(MATCH_PHRASE_FUNCTION, 1, "timeout error")
        return LogicalSort.create(
        );
            condition
            @Override
            }
            "amount",
        };
import org.opensearch.analytics.planner.rel.OpenSearchSort;
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"),
            idx += needle.length();
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
        int leftCols = leftScan.getRowType().getFieldCount();
                .orElseThrow();
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
            }
        assertTrue("Should have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));
    }
            condition
    }
     *       were stripped by {@code FragmentConversionDriver.convertReduceNode}, leaving a plain
        );
            2,
        return count;
            ShardScanWithDelegationInstructionNode filterInstruction = (ShardScanWithDelegationInstructionNode) plan.instructions()
            @Override
                map.put(ScalarFunction.WILDCARD, serializer);
     * Coord-side fragment: Aggregate ← Join ← (ER ← ...) | (ER ← ...).
    private RelNode buildJoinOverTwoScans(String leftTable, String rightTable) {
        MockLuceneBackend lucene = new MockLuceneBackend() {
    // ---- Complex combining cases ----
    public void testAndTwoDelegated() {
     * strips the DF Final layer. Without this, slice_count > 1 causes FinalPartitioned
        );
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            }
        OperandTypes.ANY,
    }
                        children.add(describeSubtree(child));
    }
            assertFalse(
    /** Performance-delegated predicate WITH serializer gets combined with correctness-delegated. */
            @Override
        return LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        );
            ),
        RexNode eqC = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(3, intType, true));
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
        LOGGER.info("QueryDAG after conversion:\n{}", dag);
                return Set.of(DelegationType.FILTER);
            }
     * (both perf-delegatable for EQUALS) plus a non-indexed integer for the native sibling.
        RexNode condition = makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeEquals(0, SqlTypeName.VARCHAR, "world"));
import org.opensearch.analytics.spi.DelegationType;
        Map<String, Map<String, Object>> fields
     *  assert SHARD_SCAN behavior, which lives on the data-node side regardless of
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            ),
                new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER, SqlTypeName.INTEGER }
        MockDataFusionBackend dfWithUnion = new MockDataFusionBackend() {
            SqlStdOperatorTable.OR,
            }
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
    }
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
                makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru"),
        String label,
    }
     * <p>Field setup (from {@code buildKeywordPlusNativeDag}, prod-Lucene-shaped):
            ),
        var df = dfWithConvertor(convertor);
            "cnt"
        return buildDelegationDag(
    );
        );
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
     *       consulted opportunistically).</li>
        var context = buildContext("parquet", fields, backends);
     *       {@code LogicalJoin} Isthmus can walk natively.</li>
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
    /** (match_phrase AND fuzzy AND NOT(wildcard)) OR amount=200 — AND combines all 3, then OR with native. */
    }
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        );
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        return List.of(df, lucene);
    public void testPartialAggregateInstruction_emittedForCountGroupBy() {
import org.apache.calcite.rel.core.AggregateCall;
    // ---- Combining: shared helper ----
     * delegated_predicate marker, 0 delegation_possible markers.
            "count",
    }
            List.of(rexBuilder.makeInputRef(leftScan, 0), rexBuilder.makeInputRef(leftScan, 1)),
        int callCount;
    /**
    public void testOrOfTwoAndGroups_PureLucene() {
            public FragmentConvertor getFragmentConvertor() {
            protected Set<EngineCapability> supportedEngineCapabilities() {
                return map;
        assertEquals("Should have 1 combined delegated expression", 1, plan.delegatedExpressions().size());
        LOGGER.info("Plan (AND correctness OR perf + native):\n{}", strippedPlan);
        assertEquals("Binary join → exactly two child stages", 2, dag.rootStage().getChildStages().size());
        assertReduceStageConverted(convertor, dag.rootStage());
    private static Stage leafStage(QueryDAG dag) {
        FilterTreeShape expectedTreeShape
        return makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, query);
            }
            }
        RecordingSerializer serializer = new RecordingSerializer();
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        RexNode eq2 = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(2, intType, true));
        }
                // stays on the operator backend but is also serializable by the Lucene peer).
     *     match_only_text; {@link MockLuceneBackend} declares EQUALS over numerics for test
                "delegatedPredicateCount matches delegatedExpressions size",
                    }
        Map<String, Map<String, Object>> fields = Map.of(
    );
            }
    private RexNode fuzzy(String query) {
        RecordingConvertor dfConvertor = new RecordingConvertor();
        OperandTypes.ANY,
                case NOT: {
                return Set.of(DelegationType.FILTER);
        LogicalFilter filter = LogicalFilter.create(
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
        assertTrue("convertFragment (shard-scan shape) must be called", convertor.shardScanCalled);
    }
                return map;
     * scans. After CBO each join side carries an ER above its partial-agg subtree.
            int[] expected = (int[]) testCase[2];
     * correctness-based delegation and shipped wholesale to Lucene — even under a plain AND where
        StagePlan plan = stage.getPlanAlternatives().getFirst();
            "0 delegation_possible markers — performance delegation doesn't compose under OR",
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
     * match(Title,'ru') AND Referer='google' OR URL='US' AND GoodEvent=1
     *
                return convertor;
            dfConvertor,
        return makeEquals(2, SqlTypeName.INTEGER, val);
            @Override
            Map.of(
        LOGGER.info("Stripped fragment:\n{}", planStr);
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
            }
        "WILDCARD",
    public void testPartialAggregateInstruction_emittedForSumGroupBy() {
     * ONE {@code delegated_predicate} shipped to the peer: 1 delegated expression, 1
        assertEquals(
            @Override
        LogicalFilter filter = LogicalFilter.create(
            serializer
    }
        assertTrue("convertFragment (final-agg shape) must be called for the Join subtree", convertor.finalAggCalled);
            label + ": PARTIAL aggregate shard stage must emit SETUP_PARTIAL_AGGREGATE",
        var r = runCombining(or(makeAnd(matchPhrase("hello"), fuzzy("wrld")), makeAnd(wildcard("h*llo"), regexp("h.llo"))));
        RecordingSerializer serializer = new RecordingSerializer();
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
            "Recorded reduce fragment must carry two StageInputScan leaves (one per reducer side)",
                rexBuilder.makeLiteral("alpha")
            stripped.contains(DelegatedPredicateFunction.NAME)
    public void testPerfDelegatedWithSerializerCombines() {
                )
        OpenSearchSort.class.getSimpleName(),
            }
            protected Set<DelegationType> supportedDelegations() {
        StagePlan p = leafStage(d).getPlanAlternatives().getFirst();
        // Rules: a dual-viable (perf) leaf stays performance-delegated (delegation_possible) under
        byte[] bytes = FragmentConversionDriver.convert(probeJoin, convertor, delegationBytes);
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>();
        );
    public void testCombinerShapeMatrix_andOrNot_withAndWithoutNativeSibling() {
        RexNode eqB = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(2, intType, true));
        assertEquals(
    public void testCoordinatorCentricJoinConversion() {
                "status",
import org.opensearch.analytics.spi.EngineCapability;
        LogicalFilter filter = LogicalFilter.create(
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
            @Override
    }
        );
     * but Lucene was also viable, so FragmentConversion wraps the predicate with the
    }
                map.put(ScalarFunction.FUZZY, serializer);
package org.opensearch.analytics.planner.dag;
        MockDataFusionBackend df = new MockDataFusionBackend() {
        // Instruction assertions
            }
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        Stage root = dag.rootStage();
        MockLuceneBackend lucene = new MockLuceneBackend() {
            sortConvertor
     * predicate survives in the plan alongside the wrapper (unlike correctness delegation,
        // NOT_EQUALS has no serializer → no delegation
    private static String describeSubtree(RexNode node) {
        QueryDAG dag = buildTwoFieldDelegationDag(
    // hence it's not in this set. AnnotatedPredicate and AnnotatedProjectExpression
                return map;
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
        assertTrue("OR structure should be preserved", RelOptUtil.toString(dfConvertor.shardScanFragment).contains("OR"));
            @Override
        var r = runCombining(or(makeAnd(matchPhrase("hello"), fuzzy("wrld"), not(wildcard("h*"))), amountEquals(200)));
        assertDoesntContainOperators(convertor.reduceFragment, OPENSEARCH_OPERATORS);
    }
    // ---- Single-stage query shapes ----
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
                case OR:
            @Override
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
        );
                caps.add(EngineCapability.UNION);
    }
    private void assertDoesntContainOperators(RelNode fragment, Set<String> forbidden) {
    /**
    public void testCombine_AndOfTwoOrs_OnePureOneMixed() {
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 1),
    );
            }
            List.of(rexBuilder.makeInputRef(rightScan, 0), rexBuilder.makeInputRef(rightScan, 1)),
 * SPDX-License-Identifier: Apache-2.0
    // ---- Delegation tagging tests ----
        RelNode cboOutput = runPlanner(filter, context);
        );
    public void testCombine_OrOfTwoAndGroupsPureLucene() {
        assertEquals("table name from probe scan, not broadcast placeholder", "test_index", convertor.shardScanTableName);
                return Set.of(DelegationType.FILTER);
    private static int countOccurrences(String haystack, String needle) {
            2,
                plan.instructions().stream().anyMatch(node -> node.type() == InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION)
                return dfConvertor;
    public void testCombine_OrTwoNotsWithNative() {
        assertTrue("Should have delegation_possible", strippedPlan.contains(DelegationPossibleFunction.NAME));
    }
        QueryDAG d = buildKeywordPlusNativeDag(condition, c, new RecordingSerializer());
                return map;
        );
        assertEquals(2, r.plan.delegatedExpressions().size());
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
    }
                map.put(ScalarFunction.FUZZY, serializer);
        RexNode msgEq = rexBuilder.makeCall(
        LOGGER.info("Recorded reduce fragment:\n{}", recorded);
        assertEquals(1, r.plan.delegatedExpressions().size());
     * INNER equi-join on column 0 of both sides. Two single-column {@code LogicalTableScan}s →
    }
        assertDoesntContainOperators(dfConvertor.shardScanFragment, ANNOTATION_MARKERS);
        assertDelegationResult(plan, dfConvertor, serializer, 1, true, false, List.of("MATCH_PHRASE"), FilterTreeShape.CONJUNCTIVE);
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);
        // Lucene mock accepts delegation but has NO serializers — predicate stays native
                SqlStdOperatorTable.EQUALS,
    }
     * pipeline. This pins the invariant so future shard-count-dependent changes don't silently
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
            }
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
        // Override the mock Lucene backend to support combining
        assertDoesntContainOperators(convertor.shardScanFragment, OPENSEARCH_OPERATORS);
     * yielded NO_DELEGATION → data node skipped the Lucene collector → full scan / over-count.
import org.opensearch.analytics.planner.BasePlannerRulesTests;
        RexNode cond = rexBuilder.makeCall(
        ReturnTypes.BOOLEAN,
        SqlKind.OTHER_FUNCTION,
                )
     * over two arms, each arm being {@code Sort ← Project ← Aggregate ← Scan} of the same
        RecordingSerializer serializer = new RecordingSerializer();
                    makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
     * ER. Isthmus's SubstraitRelVisitor handles Union natively; reduce-stage conversion serializes
        RelNode leftScan = stubScan(mockTable("test_index", "status", "size"));
        assertTrue("AND should be preserved", RelOptUtil.toString(dfConvertor.shardScanFragment).contains("AND"));
    }
    /** Single native equals on a non-indexed field — single-viable to DataFusion, no delegation. */
            makeSort(makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)), 10),
    /** Shared (recorders, condition) for the three fuse-mode tests. Uses two keyword fields
            @Override
    /** Walks to the deepest leaf stage (the data-node fragment) — used by tests that
import org.apache.calcite.rel.type.RelDataType;
            rexBuilder.makeLiteral("alpha")
                return dfConvertor;
            treeShapeOf(plan)
        RelNode project = LogicalProject.create(
            condition
    }
import org.apache.calcite.rel.RelNode;
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);
    }
        QueryDAG dag = buildAndConvert(
        RexNode notFuzzy = rexBuilder.makeCall(SqlStdOperatorTable.NOT, makeFullTextCall(FUZZY_FUNCTION, 1, "wrld"));
     *   <li>{@code convertShardScanFragment("test_index", LogicalTableScan)} called once per side
    }
        QueryDAG dag = buildTwoFieldDelegationDag(makeEquals(0, SqlTypeName.INTEGER, 200), dfConvertor, serializer);
     * and asserts the recording convertor sees:
    /**
import org.apache.calcite.sql.SqlKind;
        );
        assertDoesntContainOperators(convertor.reduceFragment, ANNOTATION_MARKERS);
            makeSort(
                    // Walk the subtree and produce a descriptive string for test assertions
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
    /** AND(native, delegated) — equals on non-indexed amount stays native; MATCH_PHRASE replaced. */
            protected Set<DelegationType> supportedDelegations() {
            dfConvertor,
        // AND(eqA, OR(eqA, eqB)) — mixed operators, no same-op nesting → already flat.
            protected Set<DelegationType> supportedDelegations() {
                "GoodEvent",
        RelNode agg = LogicalAggregate.create(project, List.of(), ImmutableBitSet.of(0), null, List.of(sumCall));
        RexNode flat = RelNodeUtils.deepFlatten(rexBuilder, flatInput);
        // MATCH_PHRASE is correctness-delegated (lucene-only), EQUALS is perf-delegated (dual-viable)
            { "NOT(MATCH)", rexBuilder.makeCall(SqlStdOperatorTable.NOT, match), new int[] { 1, 1, 0 } },
            SqlStdOperatorTable.OR,
        org.opensearch.analytics.planner.PlannerContext ctx = buildContext("parquet", 1, intFields());
        RecordingConvertor dfConvertor = new RecordingConvertor();
        assertEquals("Mixed: Lucene combined into 1 expression", 1, plan.delegatedExpressions().size());
     * Combiner shape matrix across AND/OR/NOT × native-sibling presence. Each row pins the
            rexBuilder.makeCall(
    /** NOT(match_phrase) OR amount=200 — NOT wraps delegated, OR with native, INTERLEAVED. */
            makeAggregate(
                    makeEquals(3, SqlTypeName.INTEGER, 1)
    public void testOrCorrectnessPlusPerf_twoLeaves_collapsesToOneDelegated() {
                probeScan.getRowType(),
     * have a coord stage above the data-node stage (since scans declare RANDOM, the
        assertTrue("AND structure should be preserved", strippedPlan.contains("AND"));
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);
    private StagePlan runHaving(RexNode whereCondition) {
        LogicalAggregate aggregate = makeAggregate(where, ImmutableBitSet.of(0), countStarCall(where));
    /** AND(OR(AND(a,b), c), d, native) — mixed: Lucene subtree combined + native preserved. */
        var context = buildContext("parquet", fields, backends);
        RelNode leftScan = stubScan(left);
     * Three-field delegation helper:
    private RexNode amountEquals(int val) {
        // Lucene backend has serializers for both MATCH_PHRASE and EQUALS
            protected Set<DelegationType> acceptedDelegations() {
        QueryDAG dag = buildAndConvert(2, makeAggregate(sumCall()), convertor);
            @Override
import org.opensearch.analytics.planner.rel.AnnotatedProjectExpression;
     * EQUALS-perf)}. Previously the combiner emitted {@code OR(delegated_predicate(matchId),
        MockLuceneBackend lucene = new MockLuceneBackend() {
            "2-leaf OR(correctness, perf): 1 delegated expression (whole OR ships as one peer subtree)",
        IllegalStateException exception = expectThrows(
                map.put(ScalarFunction.MATCH, serializer);
        );
            }
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
    }
        );
            protected Set<DelegationType> supportedDelegations() {
                SqlStdOperatorTable.EQUALS,
    // ---- Error paths ----
        var r = runCombining(makeAnd(or(matchPhrase("hello"), amountEquals(200)), fuzzy("wrld")));
        RelNode join = LogicalJoin.create(leftProject, rightSorted, List.of(), cond, Set.of(), JoinRelType.INNER);
            countOccurrences(stripped, "delegation_possible")
                return Set.of(DelegationType.FILTER);
    public void testSingleStageQueryShapes() {
     * a bare OR(=,=,=) nested directly inside another OR — e.g.
                new String[] { "message", "amount", "count" },
        assertTrue("Should have delegation_possible", strippedPlan.contains(DelegationPossibleFunction.NAME));
                Map.of("type", "keyword", "index", true),
    /** Walks a RexNode subtree and produces a descriptive string for test assertions. */
                }
    /** AND(delegated, delegated) with combining support — combined into single DelegatedExpression. */
    // ---- Shared delegation assertions ----
        // OR(AND(match_phrase, fuzzy), AND(match_phrase, fuzzy))
     * emits a shape that doesn't reduce cleanly to {@code LogicalJoin(SIS, SIS)} here, the test
                Map.of("type", "keyword", "index", true),
                return Set.of(DelegationType.FILTER);
                probeScan.getCluster(),
 * The OpenSearch Contributors require contributions made to
     */
        MockLuceneBackend lucene = new MockLuceneBackend() {
    }
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(plan));
                return Set.of(DelegationType.FILTER);
            @Override
                return map;
            @Override
        }
                SqlStdOperatorTable.OR,
            ),
        RexCall andCall = (RexCall) flat;
        return buildDelegationDag(
            assertNotNull(child.getPlanAlternatives().getFirst().convertedBytes());
            probeScan.getTraitSet(),
                return Set.of(DelegationType.FILTER);
        RexNode innerOr = or(eq1, eq2, eq3);
     * multi-shard table. After CBO each arm carries an ER above its aggregate (PARTIAL/FINAL
        };
                "Referer",
            dfConvertor,
        // (label, condition, expectation) — expectation = {delegatedExpressions,
        // under PR's design (one stage, no ERs) and don't exercise the coord-centric path.
        }
        assertFalse("Should NOT have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
                // EQUALS registered for performance-delegation tests (dual-viable predicate that
        // shape this test was designed to verify. Single-shard same-table joins go SHARD-local
        var ctx = buildFuseTestSetup();
        assertFalse("Should NOT have delegation_possible", strippedPlan.contains(DelegationPossibleFunction.NAME));
    public void testAndOrAndNested_PureLucene() {
    private record FuseTestSetup(RecordingConvertor dfConvertor, RecordingSerializer serializer, RexNode condition) {
    private static final SqlFunction FUZZY_FUNCTION = new SqlFunction(
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        );
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 1, "hello"),
     * Tree shape: CONJUNCTIVE (both under AND, no OR/NOT in final plan).
    private RexNode regexp(String pattern) {
            ),
                "URL",
        // OR(MATCH(message,'hello') correctness-delegated, EQUALS(tag='alpha') perf-delegated)
     * Expected: delegated_predicate(0) — correctness delegation, NOT absorbed into BoolQuery(must_not).
        RexNode eqPerf2 = rexBuilder.makeCall(
     */
    /**
        assertEquals(
    /** OR(AND(match_phrase, fuzzy), AND(wildcard, amount=200)) — left arm combined, right has wildcard separate. */
        QueryDAG dag = buildTwoFieldDelegationDag(
    /** match_phrase AND fuzzy OR amount=200 → OR(AND(lucene,lucene), native) — combined, INTERLEAVED. */
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
import org.apache.logging.log4j.Logger;
                return Set.of(DelegationType.FILTER);
     *  ({@code STANDARD_TYPES = {KEYWORD, TEXT, MATCH_ONLY_TEXT}}). Distinct fields prevent
        LogicalFilter filter = LogicalFilter.create(
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);
                return map;
    public void testCombine_AndWithOrContainingMixed() {
import org.opensearch.analytics.spi.InstructionType;
            protected Set<DelegationType> acceptedDelegations() {
            @Override
        }
            { "AND(NOT(MATCH), EQUALS-perf, native)", makeAnd(notMatch, eqPerf, nativeArm), new int[] { 2, 1, 1 } },
            protected Set<DelegationType> supportedDelegations() {
        RecordingConvertor dfConvertor = new RecordingConvertor();
                return Set.of(DelegationType.FILTER);
        RecordingConvertor dfConvertor = new RecordingConvertor();
        public byte[] serialize(RexCall call, List<FieldStorageInfo> fieldStorage) {
            .filter(node -> node.type() == InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION)
    }
            @Override
        assertTrue("Combined should contain MATCH_PHRASE", combinedStr.contains("MATCH_PHRASE"));
            stripped.contains(DelegationPossibleFunction.NAME)
        return dag;
        // 1 correctness (match) + 1 combined performance (Referer AND URL) = 2 DelegatedExpressions
            }
import java.nio.charset.StandardCharsets;
        SqlFunctionCategory.USER_DEFINED_FUNCTION
            rexBuilder.makeCall(
        RexNode condition = makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeEquals(0, SqlTypeName.VARCHAR, "world"));
                return Set.of(DelegationType.FILTER);
        RecordingSerializer serializer = new RecordingSerializer();
            // ── NOT shapes (Calcite folds NOT(=) → ≠ pre-combiner, so no perf survives there) ──
    /** OR(delegated, delegated) with combining support — combined into single DelegatedExpression with OR structure. */
            ),
    /** OR(AND(delegated, delegated), delegated) — pure Lucene nested structure → 1 combined. */
        // OR(AND(match_phrase, fuzzy), match_phrase)
    private QueryDAG buildKeywordPlusNativeDag(RexNode condition, RecordingConvertor dfConvertor, RecordingSerializer serializer) {
        assertEquals(
    }
        return rexBuilder.makeCall(SqlStdOperatorTable.NOT, op);
        assertEquals(FilterTreeShape.CONJUNCTIVE, treeShapeOf(plan));
            convertor
        assertDelegationResult(
        );
                Map.of("type", "keyword", "index", true),
        RexNode tagEq = rexBuilder.makeCall(
        );
        QueryDAG dag = buildDelegationDag(
    public void testMissingSerializerThrows() {
     *   - field 1 = message  (keyword, indexed) — DUAL-VIABLE for full-text + DataFusion.
        assertTrue("convertFragment (final-agg shape) must be called for the Union subtree", convertor.finalAggCalled);
    // Stripping it to LogicalTableScan would silently drop QTF's overrideRowType (helper cols
     * Both branches are gathered subtrees. Reduce-stage conversion must serialize the whole
        assertTrue(exception.getMessage().contains("No DelegatedPredicateSerializer"));
    private static final SqlFunction WILDCARD_FN = new SqlFunction(
            public FragmentConvertor getFragmentConvertor() {
            protected Set<DelegationType> supportedDelegations() {
        assertEquals("FilterTreeShape", FilterTreeShape.CONJUNCTIVE, delegationInstruction.getTreeShape());
    }
        var r = runCombining(or(makeAnd(matchPhrase("hello"), fuzzy("wrld")), makeAnd(wildcard("h*llo"), amountEquals(200))));
            new String[] { "message" },
        // two inputs are StageInputScan leaves — that's the shape Isthmus consumes natively.
        LogicalFilter filter = LogicalFilter.create(
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
            1,
        int expDelegatedExprs,
     *       once on the root stage — the OpenSearchJoin wrapper and the two ExchangeReducers
        QueryDAG dag = buildTwoFieldDelegationDag(makeEquals(2, SqlTypeName.INTEGER, 200), dfConvertor, serializer);
            public FragmentConvertor getFragmentConvertor() {
     * conversion. Earlier {@code findLeaf} returned the broadcast placeholder for the left
import org.opensearch.analytics.spi.FieldStorageInfo;
 * across a range of query shapes.
        var context = buildContext("parquet", fields, backends);
        var r = runCombining(or(matchPhrase("hello"), amountEquals(100), fuzzy("wrld"), countEquals(200), wildcard("h*")));
            }
                return Set.of(DelegationType.FILTER);
                ),
                strippedPlan.contains(DelegatedPredicateFunction.NAME)
        // ── shapes ──────────────────────────────────────────────────────────
     * {@code delegation_possible(original, annotationId)} marker for opportunistic per-RG
    /** OR(match_phrase, amount=100, fuzzy, count=200, wildcard) — 3 Lucene combined, 2 native preserved. */
        Map<String, Map<String, Object>> fields = Map.of(
        // Both MATCH_PHRASE (correctness) and EQUALS (perf) have serializers → combined into 1
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
            plan.delegatedExpressions().size()
        return rexBuilder.makeCall(SqlStdOperatorTable.OR, ops);
    }
        RecordingConvertor dfConvertor = new RecordingConvertor();
            () -> FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry())
            @Override
            condition
            }
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        // Wire-shape: one delegated expression via DelegatedSubtreeConvertor.
     */
            null,
                return Set.of(DelegationType.FILTER);
     */
            "s"
        RexNode orClause = rexBuilder.makeCall(
        RecordingConvertor dfConvertor = new RecordingConvertor();
            Map.of("type", "integer", "index", false),
        assertTrue("convertShardScanFragment must be called for the scan side(s)", convertor.shardScanCalled);
        RexNode eqA = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(1, intType, true));
     *   <li>{@code DelegatedExpression} entries the data node receives,</li>
        // amount is index=false → only DataFusion can evaluate, Lucene is not viable.
        // With DelegatedSubtreeConvertor, same-backend predicates under AND are combined into 1
     * Regression: probe-side fragment with shape {@code Join(OpenSearchBroadcastScan, OpenSearchTableScan)}
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(), null, List.of(countCall));
                sumCall()
     * alter the coordinator-side conversion path.
                "amount",
        assertTrue("Should have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));
    /**
            condition
    public void testPerfDelegatedWithoutSerializerStaysNative() {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    }
     * NOT tag='hello' — Calcite normalizes to tag!='hello' (NOT_EQUALS).
            condition,
    public void testOrPerformanceLeavesAndCorrectness_fusesToOneDelegated() {
        AnnotatedPredicate.class.getSimpleName(),
        assertTrue(
            serializer,
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
    private void assertShardScanConverted(RecordingConvertor convertor, Stage stage) {
    public void testDeepFlatten_removesNestedSameOpOr() {
        );
                    for (RexNode child : call.getOperands()) {
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            public FragmentConvertor getFragmentConvertor() {
            2,
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
            ),
            Map.of("type", "integer", "index", false)
        RexNode nested = makeAnd(or(eq2, innerOr), eq3);
                    new String[] { "message", "amount" },
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
        "MATCH_PHRASE",
        return makeEquals(1, SqlTypeName.INTEGER, val);
        null,
                return dfConvertor;
    /** Performance-delegated predicate without serializer stays native (not combined). */
    public void testCombine_OrOfThreeLuceneAndNative() {
    /** AND(native, OR(delegated, NOT(delegated))) — nested boolean structure with delegation. */
    }
import org.opensearch.analytics.planner.MockDataFusionBackend;
     * <ul>
                Map.of("type", "integer", "index", false)
                    makeEquals(2, SqlTypeName.VARCHAR, "US"),
    public void testOrTwoDelegatedWithCombining() {
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
    /**
        assertTrue(convertor.finalAggCalled);
        RecordingConvertor convertor = new RecordingConvertor();
        assertEquals(FilterTreeShape.CONJUNCTIVE, treeShapeOf(plan));
     *   <li>{@code convertFinalAggFragment(LogicalJoin(StageInputScan, StageInputScan))} called
        int idx = 0;
        assertFalse("precondition: tree is not flat", RexUtil.isFlat(nested));
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru")
        MockDataFusionBackend df = new MockDataFusionBackend() {
            makeAggregate(
    }
            @Override
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        assertEquals("first instruction must be SHARD_SCAN", InstructionType.SETUP_SHARD_SCAN, plan.instructions().getFirst().type());
            }
            "2-leaf OR(correctness, perf): 0 delegation_possible markers — doesn't compose under disjunction",
        RecordingConvertor dfConvertor = new RecordingConvertor();
        // Must not throw "Unknown leaf type" — findLeaf must skip the broadcast placeholder
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
            plan.instructions().stream().anyMatch(node -> node.type() == InstructionType.SETUP_PARTIAL_AGGREGATE)
        };
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
     * consultation. Asserts one delegated entry, CONJUNCTIVE shape, and that the original
        RexNode middleOr = andCall.getOperands().get(0);
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            condition,
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
        String recorded = RelOptUtil.toString(convertor.reduceFragment);
        assertEquals("expected exactly one alternative", 1, stage.getPlanAlternatives().size());
            // ── NOT inside boolean — the prod-bug shape from the OR-disjunction fix ───
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        );
            serializer,
     * {@code convertFragment (final-agg shape)} pass — same path as Union / Intersect /
        RecordingSerializer serializer = new RecordingSerializer();
            dfConvertor,
        RecordingSerializer serializer,
                    sumCall()
            FilterTreeShape.CONJUNCTIVE,
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
     * Calcite's shallow RexUtil.flatten does not descend into the inner OR, so
import org.apache.calcite.rel.logical.LogicalAggregate;
            @Override
        assertEquals("test_index", convertor.shardScanTableName);
            ),
        } else {
    }
        );
        // 1 combined performance (Referer AND URL) = 1 DelegatedExpression
            // FUZZY on message — full-text only, correctness-delegated to Lucene
        assertTrue(convertor.shardScanCalled);
        RecordingConvertor dfConvertor = new RecordingConvertor();
        assertEquals(0, plan.delegatedExpressions().size());
        return node.toString();
        );
        assertShardScanConverted(convertor, dataNodeStage(dag));
        PlannerContext context = buildContext("parquet", 2, intFields(), List.of(dfWithUnion));
     */
        };
    public void testAndTwoDual_defaultsToPerformanceDelegation() {
    public void testCombine_OrOfPureLuceneAndMixedAnd() {
     * Referer='google' AND URL='US' AND GoodEvent=1 (no correctness delegation)
    private RelNode markScan(RelNode logicalScan) {
                    new String[] { "message", "amount", "count" },
        assertFalse("instructions must not be empty", plan.instructions().isEmpty());
                makeAggregate(
    }
    /**
            protected Set<DelegationType> acceptedDelegations() {
        RelNode cboOutput = runPlanner(filter, context);
        while (!current.getChildStages().isEmpty()) {
     */
        );
        RecordingConvertor dfConvertor = new RecordingConvertor();
import org.apache.calcite.rel.logical.LogicalFilter;
        null,
            { "OR(MATCH, FUZZY, native)", or(match, fuzzy, nativeArm), new int[] { 1, 1, 0 } },
    }
            Map.of("type", "keyword", "index", true),
            0,
        RecordingConvertor convertor = new RecordingConvertor();
            SqlStdOperatorTable.EQUALS,
     * Expected: delegated_predicate(0) AND delegation_possible(tag='hello', 1)
        RexNode condition = makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeFullTextCall(FUZZY_FUNCTION, 0, "wrld"));
        );
        );
            }
        // OR(match, AND(Referer=, URL=, GoodEvent=))
            probeScan.getViableBackends()
                makeEquals(1, SqlTypeName.VARCHAR, "google"),
        "FUZZY",
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
            .orElseThrow()).getTreeShape();
            { "OR(MATCH, native)", or(match, nativeArm), new int[] { 1, 1, 0 } },
        RecordingConvertor dfConvertor = new RecordingConvertor();
import org.opensearch.analytics.spi.ScalarFunction;
            }
        RelNode scan = stubScan(table);
        @Override
        return ((ShardScanWithDelegationInstructionNode) plan.instructions()
        for (Object[] testCase : cases) {
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            node = ap.unwrap();
        );
            rexBuilder.makeCall(
    /** OR(NOT(match_phrase), NOT(fuzzy), amount=200) — both NOTs combine under OR, native stays. */
            List.of("status", "size")
        assertTrue("deepFlatten must produce a flat tree", RexUtil.isFlat(flat));
            Map.of("type", "keyword", "index", true),
        assertReduceStageConverted(convertor, dag.rootStage());
    private RelNode buildUnionOverSortedAggArms() {
     * Operator precedence: (match AND Referer=) OR (URL= AND GoodEvent=)
            1,
        var r = runCombining(or(not(matchPhrase("hello")), amountEquals(200)));
public class FragmentConversionDriverTests extends BasePlannerRulesTests {
            @Override
        RelNode cboOutput = runPlanner(filter, context);
     * {@code delegated_predicate} — a bare delegated leaf the data node routes wholesale to Lucene.
     * catches it before it reaches the DataFusion runtime.
            protected Set<DelegationType> supportedDelegations() {
            dfConvertor,
    }
    /** AND(delegated, delegated) — both replaced, two entries in delegatedQueries. */
        SqlKind.OTHER_FUNCTION,
        return null;
            condition
            callCount++;
    }
                    "test_index",
        );
    /** Result holder for combining tests. */
    }
            )
            recorded.split("OpenSearchStageInputScan", -1).length - 1
            rightProject,
        return leafStage(dag).getPlanAlternatives().getFirst();
                SqlStdOperatorTable.OR,
        );
    public void testSingleDelegatedPredicate() {
            { "AND(MATCH, EQUALS-perf, native)", makeAnd(match, eqPerf, nativeArm), new int[] { 2, 1, 1 } },
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
        RecordingConvertor sortConvertor = new RecordingConvertor();
import org.opensearch.analytics.spi.DelegationPossibleFunction;
        PlannerContext context = buildContext("parquet", fields, List.of(df, lucene));
        return stage;
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
    private RexNode or(RexNode... ops) {
            List.of("status", "size")
            protected Set<DelegationType> supportedDelegations() {
import java.util.Set;
                Map.of("type", "integer", "index", false)
     * (Lucene-correctness); amount:int(index=false) → native-only.
        );
    }
     */
    // ---- Combining tests (OR/NOT/mixed) ----
            protected Set<DelegationType> supportedDelegations() {
            assertTrue(
        var r = runCombining(makeAnd(matchPhrase("hello"), or(fuzzy("wrld"), amountEquals(100)), wildcard("h*")));
    }
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
            @Override
        );
    }
            countOccurrences(strippedPlan, "delegation_possible")
    );
    /**
        );
            }
        // root — so a shallow root-only flatten never visits it. AND(OR(eq2, OR(=,=,=)), eq3).
            @Override
    public void testHavingFilterAboveDelegatedWhere_derivesConjunctive() {
                return Set.of(DelegationType.FILTER);
     * Builds and runs the combining pipeline for a filter condition.
    }
        };
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            }
                return null;
        assertEquals(SqlKind.OR, middleOr.getKind());
            List.of("MATCH_PHRASE"),
        // Override the mock Lucene backend to support combining
                probeScan.getViableBackends()
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello world")
            }
            public FragmentConvertor getFragmentConvertor() {
     * match(Title,'ru') OR (Referer='google' AND URL='US' AND GoodEvent=1)
        );
                    "test_index",
    }
                return Set.of(DelegationType.FILTER);
    ) {
            rexBuilder.makeLiteral(50000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
                map.put(ScalarFunction.EQUALS, serializer);
                return dfConvertor;
        QueryDAG dag = buildAndConvert(2, buildJoinOverTwoScans("test_index", "test_index"), convertor);
        OperandTypes.ANY,
                "Title",
        assertEquals(1, r.plan.delegatedExpressions().size());
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
                "Referer",
        assertShardScanConverted(convertor, dag.rootStage().getChildStages().getFirst());
     * HAVING produces two stacked filters that don't merge across the Aggregate: a native HAVING
                Map.of("type", "keyword", "index", true),
        SqlTypeName[] fieldTypes,
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            protected Set<DelegationType> acceptedDelegations() {
                    new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER, SqlTypeName.INTEGER }
        StagePlan plan,
        QueryDAG dag = buildAndConvert(5, makeInnerEquiJoin(), convertor);
    }
                return map;
            );
    public void testCombine_OrOfAndLuceneWithAndNative() {
            JoinRelType.INNER,
    }
                countStarCall()
            rexBuilder.makeLiteral("alpha")
                map.put(ScalarFunction.FUZZY, serializer);
     * split or SINGLE-over-RANDOM gather), and the Union sits at the coord with two
 */
            serializer
        );
        );
     */
        );
        // DataFusion plans the substrait Aggregate's Partial+Final pair itself via the legacy
     */
            serializer,
            FilterTreeShape.CONJUNCTIVE
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
        MockDataFusionBackend df = new MockDataFusionBackend() {
            public FragmentConvertor getFragmentConvertor() {
        RelNode cboOutput = runPlanner(logicalPlan, context);
        RexNode ref = rexBuilder.makeInputRef(intType, 0);
     *     path against a mock Lucene; do not interpret as a prod use case.
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
            { "OR(MATCH, EQUALS-perf)", or(match, eqPerf), new int[] { 1, 1, 0 } },
                Map.of("type", "keyword", "index", true),
    /**
        assertEquals(1, r.plan.delegatedExpressions().size());
     * {@code LogicalJoin} → planner marks as {@code OpenSearchJoin} over two
            rexBuilder.makeInputRef(intType, leftCols)
            serializer
    /** OR(AND(match_phrase, fuzzy), AND(amount=100, count=200)) — one Lucene arm combined, one native arm. */
                /* buildStageId */ 0,
        );
        // two exchange-gathered branches. The whole subtree converts in one pass.
            ),
        };
     * which replaces the original with a {@code delegated_predicate} placeholder).
            List.of(1),
        // AND(OR(AND(match_phrase, fuzzy), match_phrase), fuzzy, amount=200)
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
                probeScan.getTraitSet(),
        LOGGER.info("Plan (NOT correctness AND perf):\n{}", strippedPlan);
            Map.of("type", "integer", "index", false),
import org.apache.calcite.rex.RexUtil;
     * </ol>
     * delegated_predicate and zero delegation_possible.
            @Override
        RexNode eqPerf = rexBuilder.makeCall(
            dfConvertor,
            rexBuilder.makeCall(SqlStdOperatorTable.NOT, makeEquals(0, SqlTypeName.INTEGER, 200)),
        RecordingConvertor convertor = new RecordingConvertor();
     *
    /**
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
    }
        MockLuceneBackend lucene = new MockLuceneBackend() {
                makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru"), makeEquals(1, SqlTypeName.VARCHAR, "google")),
    private RexNode countEquals(int val) {
        assertEquals("test_index", convertor.shardScanTableName);
        RelNode rightSorted = LogicalSort.create(
                return Set.of(DelegationType.FILTER);
        RelNode arm2 = buildSortedAggArm();
    public void testCombine_OrFlatInterleaved() {
     * Expected: delegated_predicate(0) AND delegation_possible(Referer='google' AND URL='US', 1) AND GoodEvent=1
        assertEquals(1, plan.delegatedExpressions().size());
        // Plan-shape: delegated_predicate placeholder replaces the original.
            { "OR(EQUALS-perf, EQUALS-perf2)", or(eqPerf, eqPerf2), new int[] { 1, 1, 0 } },
        MockLuceneBackend lucene = new MockLuceneBackend() {
     * data node trusted the label, forced the single-collector path onto a tree containing an OR,
        assertShardScanConverted(sortConvertor, dataNodeStage(sortDag));
        assertNotNull("root alternative must have convertedBytes", root.getPlanAlternatives().getFirst().convertedBytes());
        ShardScanWithDelegationInstructionNode delegationInstruction = (ShardScanWithDelegationInstructionNode) plan.instructions()
     * PARTIAL aggregate stages must emit SETUP_PARTIAL_AGGREGATE so the shard executor
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        assertTrue("Should have native GoodEvent =", strippedPlan.contains("="));
        assertEquals("OR(AND,AND) pure Lucene should produce 1 expression", 1, plan.delegatedExpressions().size());
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        assertTrue("convertFinalAggFragment must be called on the coordinator join fragment", convertor.finalAggCalled);
        };
            public FragmentConvertor getFragmentConvertor() {
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
        LOGGER.info("Plan (AND only-perf + native):\n{}", strippedPlan);
            makeAnd(
        RecordingConvertor dfConvertor = new RecordingConvertor();
        var context = buildContext("parquet", fields, List.of(df, lucene));
    /** Single-field delegation helper. */
            1,
                    return describeSubtree(subtree).getBytes(StandardCharsets.UTF_8);
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
    private QueryDAG buildSingleFieldDelegationDag(RexNode condition, RecordingConvertor dfConvertor, RecordingSerializer serializer) {
     */
    /** OR(match_phrase, amount=200, fuzzy) — flat interleaved OR. */
    // ---- Plan shape verification tests (match verified DF logical plans) ----
            SqlStdOperatorTable.EQUALS,
            @Override
            public FragmentConvertor getFragmentConvertor() {
            makeFullTextCall(FUZZY_FUNCTION, 0, "wrld")
            new String[] { "status", "message", "amount" },
        QueryDAG dag = buildDelegationDag(
                Map.of("type", "keyword", "index", true),
        RecordingSerializer serializer = new RecordingSerializer();
    // ---- Multi-input (join) coord fragment shapes ----
            true,
    /** Single delegated MATCH_PHRASE — replaced with placeholder, one entry in delegatedQueries. */
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 1, "timeout error"),
    // still ride in their parent operators' RexNodes and DO appear textually.
    }
            makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeFullTextCall(FUZZY_FUNCTION, 0, "wrld")),
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru")
        );
            { "AND(MATCH, native)", makeAnd(match, nativeArm), new int[] { 1, 1, 0 } },
            protected Set<DelegationType> acceptedDelegations() {
        RelNode cboOutput = runPlanner(filter, context);
                    new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
                mockTable(
    /** Sort(Aggregate(Filter(Scan))) with limit — full OLAP pipeline. */
        RecordingSerializer serializer = new RecordingSerializer();
            ),
    // ---- AND conditions ----
import org.apache.calcite.rel.RelCollations;
        );
     */
        QueryDAG dag = buildKeywordFuseDag(condition, dfConvertor, serializer);
            broadcastScan,                  // build = LEFT input
            new String[] { "Title", "Referer", "URL", "GoodEvent" },
        assertTrue("Combined should contain FUZZY", combinedStr.contains("FUZZY"));
        assertTrue("Should have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
        return makeFullTextCall(REGEXP_FN, 0, pattern);
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;
    private QueryDAG buildTwoFieldDelegationDag(RexNode condition, RecordingConvertor dfConvertor, RecordingSerializer serializer) {
            Map.of("type", "integer", "index", false)
                .findFirst()
     *
                "Title",
            }
    public void testOrCorrectnessWithPerfAndNative() {
            }
            }
        // amount has index=false → no Lucene format → native-only.
            public org.opensearch.analytics.spi.FragmentConvertor getFragmentConvertor() {
            -1,
        );
            "Dual AND Dual must NOT be demoted to correctness (no delegated_predicate). Plan: " + stripped,
    public void testCombine_OrNotLuceneWithNative() {
    // OpenSearchTableScan is intentionally NOT in this set: stripAnnotations leaves it in place
            countOccurrences(strippedPlan, "delegated_predicate")
    /**
            assertFalse("Stripped fragment must not contain [" + op + "]", planStr.contains(op));
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
            }
            probeScan.getCluster(),
        String planStr = RelOptUtil.toString(fragment);
        OpenSearchFilter.class.getSimpleName(),
            }
                "Title",
        }
            @Override
        return buildDelegationDag(
        //
            @Override
     * {@code AND(OR(delegated_predicate(0), >), OR(delegated_predicate(2), OR(=,=,=)), =)}.
                map.put(ScalarFunction.EQUALS, serializer);
        // Correctness and performance delegated stay separate — 2 DelegatedExpressions
                makeEquals(3, SqlTypeName.INTEGER, 1)
    }
                "delegation plan must have SHARD_SCAN_WITH_DELEGATION instruction",
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
            makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeFullTextCall(FUZZY_FUNCTION, 0, "wrld")),
                };
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
                "amount",
        LogicalFilter filter = LogicalFilter.create(
        );
     * <ol>
    public void testSortOnAggregateOnFilteredScan() {
        );
        RelOptTable right = mockTable(rightTable, "status", "size");
        assertEquals("Pure Lucene nested OR(AND,leaf) should produce 1 expression", 1, plan.delegatedExpressions().size());
    public void testAndOnlyPerfAndNative() {
        RexNode condition = rexBuilder.makeCall(
    }
import org.opensearch.analytics.spi.FilterTreeShape;
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR },
                Map.of("type", "keyword", "index", true),
        };
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
        MockLuceneBackend lucene = new MockLuceneBackend() {
     * {@code OR(perf-tag, perf-message, FUZZY-correctness)} — two dual-viable leaves plus a
            );
        );
        RecordingConvertor aggConvertor = new RecordingConvertor();
            SqlStdOperatorTable.COUNT,
    /** Aggregate(Filter(Scan)) — most common OLAP shape. */
        // Distinct field for the second perf EQUALS so Calcite's SEARCH/Sarg rewrite
        RelNode rightScan = stubScan(mockTable("test_index", "status", "size"));
        null,
    private FuseTestSetup buildFuseTestSetup() {
    ) {
            0,
                makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru"),
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
            ),
import java.util.Map;
import org.opensearch.analytics.planner.rel.OpenSearchProject;
            SqlStdOperatorTable.EQUALS,
            dfConvertor,
        assertEquals("delegated WHERE under HAVING must still ship one expression", 1, plan.delegatedExpressions().size());
        MockDataFusionBackend df = new MockDataFusionBackend() {
        assertDoesntContainOperators(convertor.reduceFragment, OPENSEARCH_OPERATORS);
        assertEquals(2, plan.delegatedExpressions().size());
                return caps;
        assertEquals(FilterTreeShape.CONJUNCTIVE, treeShapeOf(plan));
            "amount",
            )
        };
     * Join + branches + ERs + StageInputScans subtree in a single
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            )
import org.apache.calcite.sql.type.ReturnTypes;
        RexNode orClause = rexBuilder.makeCall(
     * Drives a coordinator-centric equi-join all the way through {@link FragmentConversionDriver}
     * delegation_possible(EQUALS, eqId))} while the tree-shape deriver labelled it CONJUNCTIVE; the
            makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeFullTextCall(FUZZY_FUNCTION, 0, "wrld")),
            SqlStdOperatorTable.OR,
        }
        );
            @Override
        RecordingSerializer serializer = new RecordingSerializer();
        LogicalFilter filter = LogicalFilter.create(
    private RexNode not(RexNode op) {
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
            new SqlTypeName[] { SqlTypeName.VARCHAR },
        }
        RexNode condition = makeAnd(orClause, makeFullTextCall(FUZZY_FUNCTION, 0, "http"));
        RecordingConvertor convertor = new RecordingConvertor();
            )
            serializer,
        int count = 0;
        RelNode rightProject = LogicalProject.create(
    /** Same-op nesting hidden under a NOT — NOT(OR(eqA, OR(eqB, eqC))) AND eqD. */
        if (node instanceof AnnotatedPredicate ap) {
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
import org.opensearch.analytics.planner.MockLuceneBackend;
                filterInstruction.getDelegatedPredicateCount()
            }
        var context = buildContext("parquet", fields, backends);
            @Override
                "message",
            1,
        if (expectPlaceholder) {
        LogicalFilter filter = LogicalFilter.create(
     * Tree shape: CONJUNCTIVE (single combined expression, no interleaving).
        assertNotNull("expected a stage with 2 child stages (the coord-side Join stage)", joinStage);
                makeAnd(makeEquals(2, SqlTypeName.VARCHAR, "US"), makeEquals(3, SqlTypeName.INTEGER, 1))
            { "OR(NOT(MATCH), native)", or(notMatch, nativeArm), new int[] { 1, 1, 0 } },
        assertShardHasPartialAggInstruction(dag, "COUNT with filter (delegation path)");
            ),
        MockLuceneBackend lucene = new MockLuceneBackend() {
     * Builds a minimal shape that reproduces the AppendPipeCommandIT plan: a LogicalUnion
     */
        };
        var r = runCombining(or(makeAnd(matchPhrase("hello"), fuzzy("wrld")), makeAnd(amountEquals(100), countEquals(200))));
                .filter(node -> node.type() == InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION)
     */
        );
        LogicalFilter having = LogicalFilter.create(aggregate, makeEquals(1, SqlTypeName.BIGINT, 1));
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
            makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru"), makeFullTextCall(FUZZY_FUNCTION, 0, "typo"))
            null
            return ("delegated:" + call.getOperator().getName()).getBytes(StandardCharsets.UTF_8);
        LogicalFilter filter = LogicalFilter.create(stubScan(mockTable("test_index", fieldNames, fieldTypes)), condition);
        if (expectedDelegatedCount > 0) {
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
    // ---- Composed pipeline shapes ----
        for (Stage child : stage.getChildStages()) {
        QueryDAG dag = buildSingleFieldDelegationDag(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello world"), dfConvertor, serializer);
                return Set.of(DelegationType.FILTER);
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
        RelNode marked = runPlanner(filter, context);
            rexBuilder.makeInputRef(intType, 0),
 *
     *   <li>{@code delegation_possible(original, id)} markers (driver evaluates natively, peer
            true,
            rexBuilder.makeInputRef(intType, 0),
            }
        RecordingConvertor convertor = new RecordingConvertor();
        RexNode condition = makeAnd(orClause, makeFullTextCall(FUZZY_FUNCTION, 0, "http"), makeEquals(1, SqlTypeName.INTEGER, 200));
                Map.of("type", "keyword", "index", true),
            Map.of("tag", Map.of("type", "keyword", "index", true), "message", Map.of("type", "keyword", "index", true))
            makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeFullTextCall(FUZZY_FUNCTION, 0, "wrld")),
        int leftCols = broadcastScan.getRowType().getFieldCount();
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        RecordingConvertor dfConvertor = new RecordingConvertor();
        MockDataFusionBackend df = new MockDataFusionBackend() {
    }
        assertEquals(2, plan.delegatedExpressions().size());
        // All 4 Lucene predicates combined into 1, native amount=200 stays separate
            Map.of(
            serializer,
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
            @Override
    /** AND(OR(match_phrase, fuzzy), OR(wildcard, amount=200)) — first OR bubbles up, second is mixed. */
        // The recorded fragment must be a plain LogicalJoin (OpenSearch* wrappers stripped) whose
            probeScan,                      // probe scan = RIGHT input
            dfConvertor,
        return makeFullTextCall(WILDCARD_FN, 0, pattern);
            @Override
            List.of(rexBuilder.makeInputRef(scan, 0), rexBuilder.makeInputRef(scan, 1)),
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
        RexNode condition = rexBuilder.makeCall(
            plan.delegatedExpressions().getFirst().getExpressionBytes(),
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
    }
    public void testAndNativeAndDelegated() {
                return Map.of(ScalarFunction.MATCH_PHRASE, serializer);
                "Stripped plan should contain " + DelegatedPredicateFunction.NAME,
            { "OR(EQUALS-perf, EQUALS-perf2, native)", or(eqPerf, eqPerf2, nativeArm), new int[] { 1, 1, 0 } },
            List.of(),
    private static final Logger LOGGER = LogManager.getLogger(FragmentConversionDriverTests.class);
     * failed to apply the filter, and returned every row (ClickBench: 99,997,497 vs. the correct
    public void testCombine_OrOfAndLuceneWithNative() {
    }
            protected Set<DelegationType> supportedDelegations() {
        );
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
    public void testTwoStageAggregateConversion() {
import org.apache.calcite.plan.RelOptTable;
    /**
        var r = runCombining(or(makeAnd(matchPhrase("hello"), fuzzy("wrld")), amountEquals(200)));
                mockTable(
        RexNode match = makeFullTextCall(MATCH_PHRASE_FUNCTION, 1, "hello");
            Map.of("type", "integer", "index", false)
        RecordingConvertor convertor = new RecordingConvertor();
     * Scan, Filter(Scan), Aggregate(Scan), Sort(Filter(Scan)) — single-shard plans now
                case AND:
        RecordingConvertor filterConvertor = new RecordingConvertor();
        // The harness only knows test_index; reuse it for both probe and a placeholder
        List<AnalyticsSearchBackendPlugin> backends = List.of(df, lucene);
            1,
        };
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        assertEquals(
        LogicalFilter filter = LogicalFilter.create(
            makeAnd(
            1,
        AggregateCall countCall = AggregateCall.create(
     * Realistic prod-Lucene-shape DAG for the combiner shape matrix: two keyword fields
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
        MockDataFusionBackend df = new MockDataFusionBackend() {
    /** AND(OR(AND(a,b), c), d) — pure Lucene deep nesting → 1 combined. */
                    List<String> children = new ArrayList<>();
        RelNode cboOutput = runPlanner(filter, context);
    private RelNode buildSortedAggArm() {
            @Override
            (org.opensearch.analytics.planner.rel.OpenSearchTableScan) markScan(stubScan(mockTable("test_index", "status", "size")));
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
        );
        assertTrue(recorded.contains("LogicalJoin"));
        // Find the coord-side join stage — the stage whose fragment contains the Join with
    public void testOrOfAndDelegated_PureLucene() {
        assertTrue(
            List.of("MATCH_PHRASE", "FUZZY"),
        RecordingSerializer serializer = new RecordingSerializer();
            strippedPlan.contains(DelegationPossibleFunction.NAME)
            expDelegatedPredicate,
            }
        assertNotNull("convertedBytes must be set", stage.getPlanAlternatives().getFirst().convertedBytes());
        return new CombiningResult(plan, dfConvertor, serializer);
 * this file be licensed under the Apache-2.0 license or a
    }
            String label = (String) testCase[0];
    /**
            }
        LOGGER.info("Plan (AND correctness + multi-perf + native):\n{}", strippedPlan);
                SqlStdOperatorTable.OR,
        String strippedPlan = RelOptUtil.toString(ctx.dfConvertor.shardScanFragment);
        assertFalse(
            }
    }
                "message",
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        );
    }
        RecordingConvertor convertor = new RecordingConvertor();
                map.put(ScalarFunction.FUZZY, serializer);
        RexNode condition = rexBuilder.makeCall(
        };
        LOGGER.info("Marked+CBO:\n{}", RelOptUtil.toString(cboOutput));
            agg,
        assertEquals(
    }
    }
        };
        assertFalse("Should NOT have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));
        RexNode eqD = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(4, intType, true));
                10
     * opportunistic peer consult) and NO delegated_predicate (nothing shipped wholesale to the peer).
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
        RexNode orClause = rexBuilder.makeCall(
    /**
            rexBuilder.makeCall(
        RecordingSerializer serializer = new RecordingSerializer();
        RecordingSerializer serializer = new RecordingSerializer();
     */
        OpenSearchAggregate.class.getSimpleName(),
     */
                makeAnd(
            dfConvertor,
    private QueryDAG buildAndConvert(int shardCount, RelNode logicalPlan, RecordingConvertor convertor) {
import org.apache.calcite.rel.core.JoinRelType;
            buildContext("parquet", 1, intFields(), List.of(dfWithConvertor(convertor))).getCapabilityRegistry()
            "count",
        assertEquals(2, dag.rootStage().getChildStages().size());
                map.put(ScalarFunction.FUZZY, serializer);
            null,
import org.apache.calcite.rel.logical.LogicalSort;
            { "OR(MATCH, EQUALS-perf, native)", or(match, eqPerf, nativeArm), new int[] { 1, 1, 0 } },
    /**
        };
     * tag/message:keyword(index=true) → dual-viable for EQUALS; message also handles MATCH/FUZZY
    /** AND(match_phrase, OR(fuzzy, amount=100), wildcard) — fuzzy materialized inside OR, match_phrase+wildcard may combine at AND. */
            }
    private record CombiningResult(StagePlan plan, RecordingConvertor convertor, RecordingSerializer serializer) {
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
     * tree bottom-up and removes the nesting. This builds that exact tree and asserts it.
        String combinedStr = new String(
    /**
        assertEquals(1, dag.rootStage().getChildStages().size());
            new String[] { "Title", "Referer", "URL", "GoodEvent" },
                "GoodEvent",
     * (build = LEFT) must classify as a shard-scan stage, not throw "Unknown leaf type" on
        RelNode rightScan = stubScan(right);
        assertEquals("expected exactly one alternative", 1, stage.getPlanAlternatives().size());
     * NOT match(Title,'ru')
    private List<AnalyticsSearchBackendPlugin> delegationBackends(RecordingConvertor dfConvertor, RecordingSerializer serializer) {
    /**
            }
        assertEquals(FilterTreeShape.CONJUNCTIVE, treeShapeOf(plan));
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
            dfConvertor,
        return new MockDataFusionBackend() {
        RecordingConvertor dfConvertor = new RecordingConvertor();
    }
    }
            @Override
                return convertor;
        QueryDAG dag = buildAndConvert(
        Stage current = dag.rootStage();
        RelNode cboOutput = runPlanner(filter, context);
        assertEquals("Correctness and performance delegated stay separate", 2, plan.delegatedExpressions().size());
            )
            { "NOT(EQUALS-perf)", rexBuilder.makeCall(SqlStdOperatorTable.NOT, eqPerf), new int[] { 0, 0, 0 } },
    private static class RecordingSerializer implements DelegatedPredicateSerializer {
            )
import org.apache.calcite.rex.RexNode;
        var r = runCombining(or(not(matchPhrase("hello")), not(fuzzy("wrld")), amountEquals(200)));
                makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
     * Minus. No substrait-level join stitching.
                "URL",
    /**
    /**
            new String[] { "Title", "Referer", "URL", "GoodEvent" },
        Map<String, Map<String, Object>> fields = Map.of(
        RexNode nativeArm = makeEquals(2, SqlTypeName.INTEGER, 42);
        RecordingConvertor dfConvertor = new RecordingConvertor();
    }
    private MockDataFusionBackend dfWithConvertor(RecordingConvertor convertor) {
        RelOptTable left = mockTable(leftTable, "status", "size");
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
            SqlStdOperatorTable.EQUALS,
            @Override
    /** OR(AND(a,b), AND(c,d)) — pure Lucene two AND groups under OR → 1 combined. */
            public FragmentConvertor getFragmentConvertor() {
                Map.of("type", "keyword", "index", true),
        RecordingSerializer serializer = new RecordingSerializer();
            }
import org.apache.calcite.sql.type.OperandTypes;
    }
        ReturnTypes.BOOLEAN,
        assertDelegationResult(plan, dfConvertor, serializer, 0, false, true, List.of(), FilterTreeShape.NO_DELEGATION);
        );
    }
        LogicalFilter filter = LogicalFilter.create(
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        );
        String[] fieldNames,
        RelNode cboOutput = runPlanner(filter, context);
        QueryDAG dag = buildTwoFieldDelegationDag(
        assertTrue(convertor.shardScanCalled);
            @Override
 * Tests for {@link FragmentConversionDriver} — verifies annotations are stripped
    }
            serializer,
                    sumCall()
        MockDataFusionBackend df = new MockDataFusionBackend() {
        String combinedStr = new String(
            makeAnd(makeEquals(2, SqlTypeName.INTEGER, 200), makeFullTextCall(MATCH_PHRASE_FUNCTION, 1, "timeout error")),
    /** OR(native, delegated) — equals on non-indexed amount stays native; MATCH_PHRASE replaced. */
        // OR( AND(match, Referer=), AND(URL=, GoodEvent=) )
            assertFalse("Stripped plan should not contain FUZZY", strippedPlan.contains("FUZZY"));
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru")
            rexBuilder.makeLiteral("hello")
        for (Stage child : dag.rootStage().getChildStages()) {
            plan,
        // field 0 = status (int, indexed), field 1 = message (keyword, indexed)
     * Regression for the prod "all-docs" disjunction bug — 2-leaf {@code OR(MATCH-correctness,
        );
        StagePlan plan = stage.getPlanAlternatives().getFirst();
            ),
        RecordingConvertor convertor = new RecordingConvertor();
            ),
     * NOT_EQUALS has no serializer, stays fully native, no delegation.
     * (which the data node reads as its classification) must reflect the WHERE's delegation
    /** Records serialization calls for delegation tests. */
            }
        boolean expectPlaceholder,
            protected Set<DelegationType> acceptedDelegations() {
            )
    public void testCombine_OrOfAndWithNotAndNative() {
        assertShardScanConverted(convertor, dag.rootStage().getChildStages().getFirst());
                    return call.getKind() + "(" + String.join(",", children) + ")";
        assertShardScanConverted(aggConvertor, dataNodeStage(aggDag));
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
    }
import org.apache.calcite.sql.SqlFunctionCategory;
        MockLuceneBackend lucene = new MockLuceneBackend() {
            public FragmentConvertor getFragmentConvertor() {
        assertShardScanConverted(filterConvertor, dataNodeStage(filterDag));
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        RecordingConvertor convertor = new RecordingConvertor();
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
    // ---- Join conversion tests (Gap #1 — M0 coordinator-centric) ----
        RelNode cboOutput = runPlanner(having, context);
    }
     * root calls convertFragment (final-agg shape).
        org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan broadcastScan =
            serializedFunctions.add(call.getOperator().getName());
            @Override
            recorded.split("OpenSearchStageInputScan", -1).length - 1 == 2
                makeEquals(2, SqlTypeName.VARCHAR, "US"),
            "message",
            SqlStdOperatorTable.EQUALS,
        RecordingSerializer serializer = new RecordingSerializer();
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
                makeEquals(0, SqlTypeName.VARCHAR, "google"),
            protected Set<DelegationType> acceptedDelegations() {
            }
        if (expectNativeEquals) {
            }
            { "AND(NOT(MATCH), native)", makeAnd(notMatch, nativeArm), new int[] { 1, 1, 0 } }, };
            SqlStdOperatorTable.EQUALS,
            .stream()
            SqlStdOperatorTable.OR,
    public void testDeepFlatten_removesNestedOrUnderNot() {
        // and recurse into the right input (the probe scan).
        RexNode eqB = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(2, intType, true));
        assertTrue("precondition: input already flat", RexUtil.isFlat(flatInput));
        if (stage.getChildStages().size() == 2) return stage;
        assertEquals(
     *
        int expDelegationPossible
    /** Delegated annotation with no serializer registered → IllegalStateException. */

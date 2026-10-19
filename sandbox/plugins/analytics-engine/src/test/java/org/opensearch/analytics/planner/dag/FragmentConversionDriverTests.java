        var r = runCombining(makeAnd(or(matchPhrase("hello"), amountEquals(200)), fuzzy("wrld")));  
    }
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
    /** Single delegated MATCH_PHRASE — replaced with placeholder, one entry in delegatedQueries. */
            }
            1,  
                Map.of("type", "keyword", "index", true),
                makeEquals(3, SqlTypeName.INTEGER, 1)  
     * match(Title,'ru') AND Referer='google' OR URL='US' AND GoodEvent=1  
            }
        RecordingSerializer serializer = new RecordingSerializer();
import org.apache.calcite.rel.logical.LogicalJoin;  
        PlannerContext context = buildContext("parquet", 1, fields, backends);  
            dfConvertor,
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
        LogicalFilter filter = LogicalFilter.create(
    }
    }  
        RexNode eq2 = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(2, intType, true));  
                "Referer",
    }
import org.apache.calcite.rex.RexCall;
            }  
        );
            buildContext("parquet", 1, intFields(), List.of(dfWithConvertor(convertor))).getCapabilityRegistry()
                return Set.of(DelegationType.FILTER);
import org.apache.calcite.rel.logical.LogicalAggregate;
            { "OR(EQUALS-perf, EQUALS-perf2, native)", or(eqPerf, eqPerf2, nativeArm), new int[] { 1, 1, 0 } },
            0,
        var df = dfWithConvertor(convertor);
        assertDoesntContainOperators(convertor.reduceFragment, OPENSEARCH_OPERATORS);
        // two exchange-gathered branches. The whole subtree converts in one pass.
                default:
            convertor
            () -> FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry())
            Map.of("type", "integer", "index", false),
    public void testOrCorrectnessPlusPerf_twoLeaves_collapsesToOneDelegated() {
        );  
                return null;
            }
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
    /**
            );
        };  
                sumCall()  
        int idx = 0;
            List.of("MATCH_PHRASE"),  
                Map.of("type", "integer", "index", false)  
        assertEquals("AND(OR(AND,leaf),leaf) pure Lucene should produce 1 expression", 1, plan.delegatedExpressions().size());
            @Override
    }  
            SqlStdOperatorTable.SUM,
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
                map.put(ScalarFunction.MATCH_PHRASE, serializer);  
            .stream()
            "amount",
        RelNode leftScan = stubScan(left);  
            protected Set<DelegationType> supportedDelegations() {
        );  
        PlannerContext context = buildContext("parquet", 2, intFields(), List.of(dfWithUnion));
            new String[] { "tag", "message", "amount" },  
                    return call.getKind() + "(" + String.join(",", children) + ")";
     * tag/message:keyword(index=true) → dual-viable for EQUALS; message also handles MATCH/FUZZY
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
            SqlStdOperatorTable.OR,
     * Tree shape: CONJUNCTIVE (both under AND, no OR/NOT in final plan).
                return map;
        assertTrue("convertShardScanFragment must be called for the scan side(s)", convertor.shardScanCalled);  
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
    private RexNode or(RexNode... ops) {
            @Override
            condition
        return null;  
            "count",  
    }
    /** Builds Filter(count=1)[HAVING] over Aggregate(group=message, count(*)) over Filter(where)[scan]. */  
        RecordingSerializer serializer = new RecordingSerializer();
        RexNode condition = rexBuilder.makeCall(  
        var context = buildContext("parquet", fields, backends);
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),  
                makeAnd(
        };  
            makeSort(  
     * conversion. Earlier {@code findLeaf} returned the broadcast placeholder for the left
                "URL",
            serializer,
    public void testCoordinatorCentricJoinConversion() {
        "FUZZY",  
            SqlStdOperatorTable.EQUALS,  
     * count Aggregate over a Join of two separately-aggregated, separately-projected
            1,
        assertShardHasPartialAggInstruction(dag, "APPROX_COUNT_DISTINCT (engine-native)");
        QueryDAG dag = buildAndConvert(
        );  
            true,
        var context = buildContext("parquet", fields, backends);  
    }
        // Distinct field for the second perf EQUALS so Calcite's SEARCH/Sarg rewrite
            makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeFullTextCall(FUZZY_FUNCTION, 0, "wrld")),
        MockDataFusionBackend df = new MockDataFusionBackend() {  
            current = current.getChildStages().get(0);
    public void testAndTwoDual_defaultsToPerformanceDelegation() {  
        RecordingSerializer serializer = new RecordingSerializer();  
    public void testAndTwoDelegated() {  
     * (which the data node reads as its classification) must reflect the WHERE's delegation
    }
import org.opensearch.analytics.planner.RelNodeUtils;
        MockDataFusionBackend df = new MockDataFusionBackend() {
        );  
     * pipeline. This pins the invariant so future shard-count-dependent changes don't silently
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
    // ---- Multi-input (join) coord fragment shapes ----  
            stubScan(
                map.put(ScalarFunction.EQUALS, serializer);
            )  
import org.apache.calcite.rel.logical.LogicalProject;
        );  
    }  
        assertEquals(0, plan.delegatedExpressions().size());
            dfConvertor,  
            condition  
        assertTrue("AND structure should be preserved", strippedPlan.contains("AND"));  
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
     * Single dual-viable equals on an indexed integer field — DataFusion narrows the operator  
import org.opensearch.analytics.spi.EngineCapability;
        );  
     * <p>Field setup (from {@code buildKeywordPlusNativeDag}, prod-Lucene-shaped):
    // ---- Shared delegation assertions ----
        QueryDAG filterDag = buildAndConvert(
        Stage stage = dag.rootStage();
    private CombiningResult runCombining(RexNode condition) {
        LogicalFilter filter = LogicalFilter.create(stubScan(mockTable("test_index", fieldNames, fieldTypes)), condition);
                return (subtree, fieldStorage) -> {  
    }
        );
     * Realistic prod-Lucene-shape DAG for the combiner shape matrix: two keyword fields
        QueryDAG dag = buildAndConvert(5, makeInnerEquiJoin(), convertor);
    private RexNode fuzzy(String query) {
    }  
    /** Walks to the deepest leaf stage (the data-node fragment) — used by tests that
        MockLuceneBackend lucene = new MockLuceneBackend() {
        MockLuceneBackend lucene = new MockLuceneBackend() {  
                Map.of("type", "keyword", "index", true),
                    new String[] { "message", "amount", "count" },
     * tree bottom-up and removes the nesting. This builds that exact tree and asserts it.  
        LOGGER.info("Plan (AND correctness OR perf + native):\n{}", strippedPlan);
            JoinRelType.INNER,
        for (Stage child : stage.getChildStages()) {
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            @Override  
        assertTrue("OR structure should be preserved", RelOptUtil.toString(dfConvertor.shardScanFragment).contains("OR"));  
        // The OR nested under NOT must also be flattened (shuttle recurses through NOT).  
        RelNode cboOutput = runPlanner(filter, context);
        }
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
    public void testSingleStageQueryShapes() {
     */  
                return dfConvertor;
     * Coord-side fragment: Aggregate ← Join ← (ER ← ...) | (ER ← ...).  
     * {@code LogicalJoin} → planner marks as {@code OpenSearchJoin} over two
     * </ul>
    public void testJoinDirectlyOverTwoExchanges() {  
    /**  
        assertEquals(
        AggregateCall sumCall = AggregateCall.create(  
        var context = buildContext("parquet", fields, List.of(df, lucene));
import org.apache.calcite.sql.type.SqlTypeName;
        QueryDAG dag = buildAndConvert(2, makeAggregate(sumCall()), convertor);
     * Builds and runs the combining pipeline for a filter condition.
                "amount",
     * predicate survives in the plan alongside the wrapper (unlike correctness delegation,
     * {@code OpenSearchExchangeReducer} legs, each reducing a separate scan subtree.  
        RexNode ref = rexBuilder.makeInputRef(intType, 0);
            protected Set<DelegationType> acceptedDelegations() {
            assertEquals("delegatedPredicateCount in instruction", expectedDelegatedCount, filterInstruction.getDelegatedPredicateCount());
        RexNode eqPerf = rexBuilder.makeCall(
    }
    }
        );
            countOccurrences(stripped, "delegation_possible")
            // EQUALS on message (keyword, indexed) — dual-viable
                "GoodEvent",
                return Set.of(DelegationType.FILTER);
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));  
            ),  
                return map;  
    }
    }
    // still ride in their parent operators' RexNodes and DO appear textually.
            SqlStdOperatorTable.OR,
        RecordingConvertor dfConvertor = new RecordingConvertor();
    /**
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        RecordingConvertor scanConvertor = new RecordingConvertor();  
    private static final SqlFunction FUZZY_FUNCTION = new SqlFunction(
        "MATCH_PHRASE",  
            FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION
        LOGGER.info("Recorded reduce fragment:\n{}", recorded);
                case OR:
                map.put(ScalarFunction.FUZZY, serializer);
            node = ap.unwrap();  
        RecordingSerializer serializer = new RecordingSerializer();
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
     * NOT match(message,'hello') AND tag='hello'
            true,  
            dfConvertor,
        }  
    /**  
        // shape the bug needs (multi-shard forks HAVING into a separate reduce stage, hiding it).
        assertEquals(SqlKind.AND, andCall.getKind());  
     * Three-field delegation helper:
                probeScan.getCluster(),  
            @Override  
    /** Mark a logical scan via the planner so it becomes OpenSearchTableScan. */  
            makeAnd(  
        );
            protected Set<DelegationType> acceptedDelegations() {  
    private static final SqlFunction MATCH_PHRASE_FUNCTION = new SqlFunction(
            dfConvertor,
            }
        assertEquals(1, r.plan.delegatedExpressions().size());
        MockLuceneBackend lucene = new MockLuceneBackend() {
        return makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, query);
        assertEquals("table name from probe scan, not broadcast placeholder", "test_index", convertor.shardScanTableName);  
     * to hash-repartition groups within the shard, producing incorrect cross-shard merges.  
            @Override  
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());  
        ReturnTypes.BOOLEAN,  
     * opportunistic peer consult) and NO delegated_predicate (nothing shipped wholesale to the peer).
                return dfConvertor;
        };
            List.of(),
                strippedPlan.contains(DelegatedPredicateFunction.NAME)  
            leftScan,
     * yielded NO_DELEGATION → data node skipped the Lucene collector → full scan / over-count.  
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
        // Both child stages converted as shard scans.
    public void testUnionOverPassthroughThenExchange() {
    }
        return LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);  
                "URL",  
        assertTrue("Should have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));  
            dfConvertor,
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
    /**
            "Dual AND Dual must stay performance-based (delegation_possible present). Plan: " + stripped,
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
    }
        RexNode condition = makeAnd(orClause, makeFullTextCall(FUZZY_FUNCTION, 0, "http"));  
        };
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
    }
        AnnotatedPredicate.class.getSimpleName(),
                makeFullTextCall(MATCH_PHRASE_FUNCTION, 1, "timeout error")
            List.of(),
     *  for the perf-delegation candidates — matches prod Lucene's filterable types
    }
            )  
            .findFirst()
        RecordingConvertor dfConvertor = new RecordingConvertor();  
    }  
        assertEquals(1, r.plan.delegatedExpressions().size());
        var context = buildContext("parquet", fields, backends);  
    private StagePlan runHaving(RexNode whereCondition) {
        RexNode orClause = rexBuilder.makeCall(  
        // amount is index=false → only DataFusion can evaluate, Lucene is not viable.
        assertNotNull(fragment);
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        QueryDAG dag = buildAndConvert(
        // producing OpenSearchJoin(ER(scan), ER(scan)) with two child stages — the coord-centric
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
        // build-side row type (any OpenSearchTableScan would do).
import org.apache.logging.log4j.Logger;
        // Lucene backend has serializer for MATCH_PHRASE but NOT for FUZZY
            null
    }  
            condition,
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
            ),
    // ---- Combining tests (OR/NOT/mixed) ----  
        };
        assertReduceStageConverted(convertor, dag.rootStage());
        );  
        // Override the mock Lucene backend to support combining
        );
            @Override  
    }
                makeEquals(0, SqlTypeName.VARCHAR, "google"),
        assertTrue("precondition: input already flat", RexUtil.isFlat(flatInput));  
    public void testPartialAggregateInstruction_emittedForSumGroupBy() {
        // doesn't fold them. message is also keyword(indexed) → dual-viable.
                return Map.of(ScalarFunction.MATCH_PHRASE, serializer);
                // EQUALS registered for performance-delegation tests (dual-viable predicate that
        );  
            @Override
 * and the correct {@link FragmentConvertor} method is called per leaf type,
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        ReturnTypes.BOOLEAN,
            dfConvertor,  
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        RexNode notMatch = rexBuilder.makeCall(SqlStdOperatorTable.NOT, match);
        assertFalse(
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
            makeAnd(makeEquals(2, SqlTypeName.INTEGER, 200), makeFullTextCall(MATCH_PHRASE_FUNCTION, 1, "timeout error")),  
                .orElseThrow();  
     */
                    new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER, SqlTypeName.INTEGER }  
                return Set.of(DelegationType.FILTER);
        assertDelegationResult(
        LogicalFilter having = LogicalFilter.create(aggregate, makeEquals(1, SqlTypeName.BIGINT, 1));
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);  
        );
import org.apache.calcite.rel.logical.LogicalSort;
                    sumCall()  
    }  
                "URL",  
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
     *  assert SHARD_SCAN behavior, which lives on the data-node side regardless of
        LogicalFilter filter = LogicalFilter.create(  
     * {@code delegation_possible(original, annotationId)} marker for opportunistic per-RG
    /** OR(AND(delegated, delegated), delegated) — pure Lucene nested structure → 1 combined. */
            makeAggregate(
    // OpenSearchTableScan is intentionally NOT in this set: stripAnnotations leaves it in place  
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
    /**
            countOccurrences(strippedPlan, "delegation_possible")
        RecordingConvertor convertor = new RecordingConvertor();
                makeAnd(makeEquals(2, SqlTypeName.VARCHAR, "US"), makeEquals(3, SqlTypeName.INTEGER, 1))
            { "AND(MATCH, native)", makeAnd(match, nativeArm), new int[] { 1, 1, 0 } },
                    for (RexNode child : call.getOperands()) {
        RecordingConvertor dfConvertor = new RecordingConvertor();
            makeSort(  
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));  
            @Override  
        RecordingSerializer serializer = new RecordingSerializer();
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
            { "AND(MATCH, EQUALS-perf)", makeAnd(match, eqPerf), new int[] { 2, 1, 1 } },
    public void testOrCorrectnessWithPerfAndNative() {  
    }
                    makeEquals(1, SqlTypeName.VARCHAR, "google"),  
        String stripped = RelOptUtil.toString(dfConvertor.shardScanFragment);
    private record FuseTestSetup(RecordingConvertor dfConvertor, RecordingSerializer serializer, RexNode condition) {
    }  
            Map.of(  
     * catches it before it reaches the DataFusion runtime.
        };
     *
                return dfConvertor;  
            0,
import org.apache.calcite.sql.type.OperandTypes;  
            serializer
    /** Aggregate(Filter(Scan)) — most common OLAP shape. */
    public void testCombine_OrOfPureLuceneAndMixedAnd() {  
                return Set.of(DelegationType.FILTER);
 * The OpenSearch Contributors require contributions made to  
        assertTrue(
        // OR(AND(match_phrase, fuzzy), match_phrase)
        assertEquals(2, plan.delegatedExpressions().size());  
        );  
        };  
                "Title",
        RecordingSerializer serializer = new RecordingSerializer();
            }
     * (Lucene-correctness); amount:int(index=false) → native-only.  
    }
            serializer
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
        RexNode flat = RelNodeUtils.deepFlatten(rexBuilder, flatInput);
                return Set.of(DelegationType.FILTER);
            protected Set<DelegationType> acceptedDelegations() {
            2,
     * delegated_predicate and zero delegation_possible.
        assertDelegationResult(plan, dfConvertor, serializer, 1, true, true, List.of("MATCH_PHRASE"), FilterTreeShape.CONJUNCTIVE);
     * <ol>
        LogicalAggregate aggregate = makeAggregate(where, ImmutableBitSet.of(0), countStarCall(where));  
     *       {@code LogicalJoin} Isthmus can walk natively.</li>  
                Map.of("type", "keyword", "index", true),
        assertTrue(
            serializer
     * <p>This is Gap #1's end-to-end coverage anchor: if something in the planner/DAG stack  
                Map.of("type", "keyword", "index", true),
import org.opensearch.analytics.spi.DelegatedPredicateFunction;  
                countStarCall()
        RecordingSerializer serializer = new RecordingSerializer();
     * Pins: exactly 1 delegated_predicate marker, zero delegation_possible markers, 1 expression.
            @Override
     * annotation wrappers in FragmentConversionDriver.strip(), an {@code IN (1,2,3)} expands to
        MockLuceneBackend lucene = new MockLuceneBackend() {
        assertFalse("perf ships to Lucene under OR — no delegation_possible", strippedPlan.contains(DelegationPossibleFunction.NAME));
            makeAggregate(  
     *  whether a coord stage sits above. */  
        LogicalFilter filter = LogicalFilter.create(  
    }  
        RexNode cond = rexBuilder.makeCall(  
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
     * a bare OR(=,=,=) nested directly inside another OR — e.g.
        RecordingSerializer serializer = new RecordingSerializer();  
        assertEquals(
            }  
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
     */
        RexNode condition = makeAnd(orClause, makeFullTextCall(FUZZY_FUNCTION, 0, "http"), makeEquals(1, SqlTypeName.INTEGER, 200));
     *   <li>{@code delegation_possible(original, id)} markers (driver evaluates natively, peer
        // status is index=true → both DataFusion and Lucene viable → now fully delegated to Lucene.
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
            protected Set<DelegationType> supportedDelegations() {  
        PlanForker.forkAll(dag, context.getCapabilityRegistry());  
    private static class RecordingSerializer implements DelegatedPredicateSerializer {  
        MockDataFusionBackend df = new MockDataFusionBackend() {  
        assertEquals("delegatedQueries count", expectedDelegatedCount, plan.delegatedExpressions().size());  
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
    /** Delegated annotation with no serializer registered → IllegalStateException. */
            recorded.split("OpenSearchStageInputScan", -1).length - 1
        AnnotatedProjectExpression.class.getSimpleName()
        );
        );
            }
 *
            @Override
        "REGEXP",
                )  
            dfConvertor,  
                SqlStdOperatorTable.EQUALS,  
        RelOptTable right = mockTable(rightTable, "status", "size");
        // The combined bytes should contain both predicates (via DelegatedSubtreeConvertor)  
        Stage joinStage = findStageWithTwoChildren(dag.rootStage());  
        }  
        assertShardScanConverted(filterConvertor, dataNodeStage(filterDag));
            "0 delegation_possible markers — performance delegation doesn't compose under OR",  
                probeScan.getTraitSet(),
                10
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        };
                return dfConvertor;
import org.opensearch.analytics.spi.FragmentConvertor;
        "WILDCARD",
        assertShardScanConverted(scanConvertor, dataNodeStage(scanDag));
     * Scan, Filter(Scan), Aggregate(Scan), Sort(Filter(Scan)) — single-shard plans now  
    /** OR(AND(match_phrase, fuzzy), AND(amount=100, count=200)) — one Lucene arm combined, one native arm. */  
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {  
        RecordingSerializer serializer = new RecordingSerializer();  
            new String[] { "Referer", "URL", "GoodEvent" },
            FilterTreeShape.CONJUNCTIVE  
            serializer  
            }
        // executeLocalPlan path; the previous SETUP_FINAL_AGGREGATE instruction routed through  
        );  
import org.apache.calcite.rel.RelCollations;  
    private RexNode countEquals(int val) {  
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
            serializedFunctions.add(call.getOperator().getName());
        assertTrue(exception.getMessage().contains("No DelegatedPredicateSerializer"));
            condition,  
    }
            @Override
    }
        MockLuceneBackend lucene = new MockLuceneBackend() {  
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));  
    /** match_phrase AND fuzzy OR amount=200 → OR(AND(lucene,lucene), native) — combined, INTERLEAVED. */
        );
        // Plan-shape: delegated_predicate placeholder replaces the original.
    }
    }
        // The harness only knows test_index; reuse it for both probe and a placeholder  
import org.opensearch.analytics.planner.MockDataFusionBackend;
        );
                return dfConvertor;  
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));  
    }
    }
        );  
        // Instruction assertions: delegation plans must have SHARD_SCAN + FILTER_DELEGATION_FOR_INDEX
            // FUZZY on message — full-text only, correctness-delegated to Lucene
     * which replaces the original with a {@code delegated_predicate} placeholder).
    }  
            @Override
            protected Set<DelegationType> acceptedDelegations() {
            plan.delegatedExpressions().size()  
        MockLuceneBackend lucene = new MockLuceneBackend() {  
            @Override  
        );
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
import org.opensearch.analytics.spi.InstructionType;  
        assertTrue("convertFragment (final-agg shape) must be called", convertor.finalAggCalled);
        assertEquals(
        RecordingConvertor dfConvertor = new RecordingConvertor();  
import org.apache.calcite.sql.type.ReturnTypes;
    }
        MockLuceneBackend lucene = new MockLuceneBackend() {  
        return buildDelegationDag(
        RecordingSerializer serializer = new RecordingSerializer();
        );
    public void testAndOnlyPerfAndNative() {
            { "OR(NOT(MATCH), native)", or(notMatch, nativeArm), new int[] { 1, 1, 0 } },
                map.put(ScalarFunction.FUZZY, serializer);  
     */  
        String combinedStr = new String(  
        RecordingConvertor dfConvertor,
import org.opensearch.analytics.spi.DelegationPossibleFunction;  
        RexNode condition = makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeEquals(0, SqlTypeName.VARCHAR, "world"));
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },  
    public void testOrOfTwoAndGroups_PureLucene() {  
            RelCollations.EMPTY,
        RecordingSerializer serializer = new RecordingSerializer();  
            plan,
        );
            );  
    private QueryDAG buildSingleFieldDelegationDag(RexNode condition, RecordingConvertor dfConvertor, RecordingSerializer serializer) {
            "Recorded reduce fragment must carry two OpenSearchStageInputScan leaves (got:\n" + recorded + ")",  
        RexNode eqPerf2 = rexBuilder.makeCall(  
        assertDoesntContainOperators(convertor.reduceFragment, ANNOTATION_MARKERS);  
            -1,
        RexNode orClause = rexBuilder.makeCall(
            SqlStdOperatorTable.OR,  
        LogicalFilter filter = LogicalFilter.create(
        String stripped = RelOptUtil.toString(c.shardScanFragment);
            "Stripped plan should contain " + DelegationPossibleFunction.NAME,
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
    public void testAndTwoDelegatedWithCombining() {
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
    /** OR(AND(match_phrase, fuzzy), AND(wildcard, regexp)) — pure Lucene both sides, fully combined to 1. */
            FilterTreeShape.CONJUNCTIVE,
     * Regression: probe-side fragment with shape {@code Join(OpenSearchBroadcastScan, OpenSearchTableScan)}  
import java.nio.charset.StandardCharsets;
        RelNode arm1 = buildSortedAggArm();
                makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru"),  
            label + ": PARTIAL aggregate shard stage must emit SETUP_PARTIAL_AGGREGATE",  
import java.util.Set;  
                return convertor;
     * correctness-delegated leaf, all same-backend, under OR. Performance delegation can't survive
        QueryDAG dag = buildAndConvert(
    /** (match_phrase AND fuzzy AND NOT(wildcard)) OR amount=200 — AND combines all 3, then OR with native. */
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru")  
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        RexCall andCall = (RexCall) flat;
     *       consulted opportunistically).</li>  
        );
                "Title",
        QueryDAG dag = buildKeywordFuseDag(ctx.condition, ctx.dfConvertor, ctx.serializer);  
    }
        );  
    /** Single-field delegation helper. */
        return node.toString();
    /** Two-keyword-field delegation helper. Both fields are dual-viable; no integer field is
    // ---- HAVING regression: delegated WHERE under an Aggregate with a HAVING filter above ----
            }
     * PARTIAL aggregate stages must emit SETUP_PARTIAL_AGGREGATE so the shard executor
    /**
                probeScan.getViableBackends()
        if (stage.getChildStages().size() == 2) return stage;
    }
    /** OR(match_phrase, amount=200, fuzzy) — flat interleaved OR. */
        int expDelegatedExprs,  
            serializer
        assertTrue("Combined should contain FUZZY", combinedStr.contains("FUZZY"));  
    /**
     * <p>Rule: a dual-viable leaf is performance-delegated under AND (one delegation_possible per  
                makeEquals(1, SqlTypeName.VARCHAR, "google"),
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
        RexNode middleOr = andCall.getOperands().get(0);
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"),  
     */
            }  
    public void testMixedAndOrAndWithNative() {  
            convertor
                return map;
            rexBuilder.makeCall(
        assertEquals(FilterTreeShape.CONJUNCTIVE, treeShapeOf(plan));
                plan.instructions().stream().anyMatch(node -> node.type() == InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION)  
                Map.of("type", "keyword", "index", true),  
    public void testCombine_AndLuceneOrMixedLucene() {
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());  
        assertTrue("Should have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));
            { "NOT(EQUALS-perf)", rexBuilder.makeCall(SqlStdOperatorTable.NOT, eqPerf), new int[] { 0, 0, 0 } },
        );  
        RelNode rightSorted = LogicalSort.create(
    /** AND(OR(AND(a,b), c), d) — pure Lucene deep nesting → 1 combined. */  
        var r = runCombining(or(makeAnd(matchPhrase("hello"), fuzzy("wrld")), makeAnd(amountEquals(100), countEquals(200))));
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);
    }
        LogicalFilter filter = LogicalFilter.create(  
    /**
    // aggCall.rexList), so it never appears in the plan's textual representation —  
            "Recorded reduce fragment must carry two StageInputScan leaves (one per reducer side)",  
        assertEquals("1 delegated expression (whole OR ships as one peer subtree)", 1, plan.delegatedExpressions().size());
    /** AND(OR(match_phrase, fuzzy), OR(wildcard, amount=200)) — first OR bubbles up, second is mixed. */
        RecordingConvertor dfConvertor = new RecordingConvertor();
     * multi-shard table. After CBO each arm carries an ER above its aggregate (PARTIAL/FINAL  
                }  
        RecordingConvertor dfConvertor,
            rexBuilder.makeInputRef(intType, 0),  
                map.put(ScalarFunction.REGEXP, serializer);  
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
        // Tree shape carries CONJUNCTIVE so the driving backend knows about the delegation.
    }  
        assertEquals("Should have 1 combined delegated expression", 1, plan.delegatedExpressions().size());
        assertDoesntContainOperators(convertor.shardScanFragment, ANNOTATION_MARKERS);  
        var r = runCombining(or(matchPhrase("hello"), amountEquals(100), fuzzy("wrld"), countEquals(200), wildcard("h*")));
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
            new String[] { "message" },
    }  
        assertEquals("Only serializable predicates delegated", 1, plan.delegatedExpressions().size());
        RecordingConvertor dfConvertor = new RecordingConvertor();
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);  
        );  
            String label = (String) testCase[0];
        }
     * {@code AND(OR(delegated_predicate(0), >), OR(delegated_predicate(2), OR(=,=,=)), =)}.  
    }
        for (Object[] testCase : cases) {
    private RexNode amountEquals(int val) {
            new SqlTypeName[] { SqlTypeName.VARCHAR },
        assertTrue("deepFlatten must produce a flat tree", RexUtil.isFlat(flat));  
    }
    /**
            }  
        );  
        var r = runCombining(or(matchPhrase("hello"), amountEquals(200), fuzzy("wrld")));  
    private RexNode not(RexNode op) {
                return map;
    private QueryDAG buildAndConvert(int shardCount, RelNode logicalPlan, RecordingConvertor convertor) {
            SqlStdOperatorTable.EQUALS,
    public void testCombine_OrNotLuceneWithNative() {
                makeAggregate(
        assertEquals(1, plan.delegatedExpressions().size());
    /**
            assertFalse("Stripped plan should not contain FUZZY", strippedPlan.contains("FUZZY"));
        // Override the mock Lucene backend to support combining
     * a disjunction, and a correctness sibling is present, so the combiner fuses the entire OR into  
                    makeEquals(3, SqlTypeName.INTEGER, 1)
    // ---- OR conditions ----
            SqlStdOperatorTable.OR,
                return Set.of(DelegationType.FILTER);
                return map;  
            @Override  
        );
        RelNode cboOutput = runPlanner(filter, context);
        };  
            }
        };
        Stage root = dag.rootStage();
    private static final SqlFunction WILDCARD_FN = new SqlFunction(
        QueryDAG dag = buildDelegationDag(  
                return Set.of(DelegationType.FILTER);  
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
        QueryDAG dag = buildSingleFieldDelegationDag(
    /**  
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());  
    }
            serializer,
        );
        assertEquals("expected exactly one alternative", 1, stage.getPlanAlternatives().size());
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
    }
            stubScan(
            makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru"), makeFullTextCall(FUZZY_FUNCTION, 0, "typo"))  
        RecordingConvertor dfConvertor = new RecordingConvertor();  
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        RelNode leftProject = LogicalProject.create(
        int expDelegationPossible
            @Override
        };
                case NOT: {  
     * <p>Now the combiner collapses an OR/NOT with a same-backend correctness sibling into one  
            @Override  
        );
    /** Walks a RexNode subtree and produces a descriptive string for test assertions. */  
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
        MockDataFusionBackend df = new MockDataFusionBackend() {  
            broadcastScan,                  // build = LEFT input
     * match(Title,'ru') AND Referer='google' AND URL='US' AND GoodEvent=1  
    }
            assertTrue(  
            dfConvertor,
    }
            new String[] { "Title", "Referer", "URL", "GoodEvent" },
    public void testAggregateOnFilteredScan() {  
        RecordingSerializer serializer = new RecordingSerializer();
     * Builds a minimal shape that reproduces the AppendPipeCommandIT plan: a LogicalUnion
                "test_index",  
        RecordingConvertor dfConvertor = new RecordingConvertor();
        var context = buildContext("parquet", shardCount, intFields(), List.of(df));  
            serializer,  
 * this file be licensed under the Apache-2.0 license or a
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
    private QueryDAG buildDelegationDag(  
    /** Shared (recorders, condition) for the three fuse-mode tests. Uses two keyword fields  
        // Lucene backend has serializers for both MATCH_PHRASE and EQUALS
        org.opensearch.analytics.planner.rel.OpenSearchJoin probeJoin = new org.opensearch.analytics.planner.rel.OpenSearchJoin(
    public void testHavingFilterAboveDelegatedWhere_derivesConjunctive() {
    private RexNode regexp(String pattern) {
        QueryDAG dag = buildSingleFieldDelegationDag(  
        while ((idx = haystack.indexOf(needle, idx)) != -1) {
        return runPlanner(logicalScan, ctx);  
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {  
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 1),
                return Set.of(DelegationType.FILTER);  
        OperandTypes.ANY,
    /** An already-flat tree is returned unchanged (and stays flat). */
     * Join + branches + ERs + StageInputScans subtree in a single
        LOGGER.info("Stripped fragment:\n{}", planStr);
        assertFalse("Should NOT have delegation_possible", strippedPlan.contains(DelegationPossibleFunction.NAME));
        QueryDAG dag = buildTwoFieldDelegationDag(
                    makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
    public void testOrTwoDelegatedWithCombining() {
                SqlStdOperatorTable.OR,
        RexNode eqB = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(2, intType, true));
            // ── OR/NOT with a same-backend correctness sibling: perf fuses into it → 1 delegated_predicate ──
        RecordingConvertor filterConvertor = new RecordingConvertor();
                return Set.of(DelegationType.FILTER);  
        RecordingSerializer serializer = new RecordingSerializer();
                map.put(ScalarFunction.FUZZY, serializer);
    public void testTwoStageSortOnAggregateOnFilteredScan() {
            dfConvertor,
    public void testCombine_OrOfAndWithNotAndNative() {  
                map.put(ScalarFunction.WILDCARD, serializer);
        QueryDAG dag = buildTwoFieldDelegationDag(
     *       (two child stages).</li>
        RexNode condition = rexBuilder.makeCall(
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
    /**  
            public FragmentConvertor getFragmentConvertor() {
        return makeFullTextCall(REGEXP_FN, 0, pattern);
        return LogicalSort.create(
     * data-node child stage and the fragment is fully stripped.  
    /**
        RecordingConvertor dfConvertor = new RecordingConvertor();
     * Drives a coordinator-centric equi-join all the way through {@link FragmentConversionDriver}
     *  
            .orElseThrow()).getTreeShape();
                makeEquals(0, SqlTypeName.INTEGER, 200)
            (org.opensearch.analytics.planner.rel.OpenSearchTableScan) markScan(stubScan(mockTable("test_index", "status", "size")));  
        RexNode nativeArm = makeEquals(2, SqlTypeName.INTEGER, 42);  
                return map;
                rexBuilder.makeCall(SqlStdOperatorTable.NOT, makeFullTextCall(MATCH_PHRASE_FUNCTION, 1, "hello")),  
     */
                map.put(ScalarFunction.EQUALS, serializer);  
            @Override  
    }
            );
        assertTrue("Should have delegation_possible", strippedPlan.contains(DelegationPossibleFunction.NAME));
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        RelNode cboOutput = runPlanner(filter, context);  
            @Override  
        OperandTypes.ANY,
                Map.of("type", "keyword", "index", true),  
        // Correctness and performance delegated stay separate — 2 DelegatedExpressions
     *
 * compatible open source license.
            idx += needle.length();
    private RelNode markScan(RelNode logicalScan) {
            }
        assertTrue(convertor.shardScanCalled);
                caps.add(EngineCapability.UNION);
    private static final Logger LOGGER = LogManager.getLogger(FragmentConversionDriverTests.class);  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        RecordingSerializer serializer = new RecordingSerializer();
            public FragmentConvertor getFragmentConvertor() {  
                Map.of("type", "integer", "index", false)
            protected Set<DelegationType> supportedDelegations() {
            dfConvertor,  
        };
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
        var r = runCombining(makeAnd(matchPhrase("hello"), or(fuzzy("wrld"), amountEquals(100)), wildcard("h*")));
    private void assertReduceStageConverted(RecordingConvertor convertor, Stage stage) {
    );  
                return Set.of(DelegationType.FILTER);
            null,
    /**  
     * scans. After CBO each join side carries an ER above its partial-agg subtree.  
                )
import org.apache.logging.log4j.LogManager;
                "Title",
        assertTrue("Should have native GoodEvent =", strippedPlan.contains("="));  
        assertNotNull("convertedBytes must be set", stage.getPlanAlternatives().getFirst().convertedBytes());  
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
        assertTrue(
            makeAnd(
                makeAggregate(
        var context = buildContext("parquet", fields, backends);
     *     match_only_text; {@link MockLuceneBackend} declares EQUALS over numerics for test
            { "OR(MATCH, FUZZY)", or(match, fuzzy), new int[] { 1, 1, 0 } },
     * HAVING produces two stacked filters that don't merge across the Aggregate: a native HAVING
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
    // ---- Combining: shared helper ----
        RelNode rightScan = stubScan(right);
     * root calls convertFragment (final-agg shape).
        assertEquals(FilterTreeShape.CONJUNCTIVE, treeShapeOf(plan));  
            Map.of("type", "integer", "index", false)
        RexNode orClause = rexBuilder.makeCall(
        var context = buildContext("parquet", fields, backends);
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        assertEquals("exactly 1 delegated_predicate marker at top", 1, countOccurrences(strippedPlan, "delegated_predicate"));
                "Referer",
        RecordingConvertor convertor = new RecordingConvertor();  
            .stream()
     * INNER equi-join on column 0 of both sides. Two single-column {@code LogicalTableScan}s →
        assertShardScanConverted(aggConvertor, dataNodeStage(aggDag));
            1,  
                    }
        var ctx = buildFuseTestSetup();
    private void assertCombinerShape(  
import org.opensearch.analytics.spi.ScalarFunction;
import org.opensearch.analytics.planner.MockLuceneBackend;
            )  
            );  
            condition
     *  
        byte[] bytes = FragmentConversionDriver.convert(probeJoin, convertor, delegationBytes);  
    // AggregateCallAnnotation is stored on OpenSearchAggregate as a side-map (not in
 */  
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        RecordingConvertor convertor = new RecordingConvertor();  
    }  
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {  
            probeScan.getViableBackends()
        assertEquals(1, r.plan.delegatedExpressions().size());
        QueryDAG dag = DAGBuilder.build(marked, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        assertTrue(convertor.shardScanCalled);
            assertCombinerShape(label, condition, expected[0], expected[1], expected[2]);
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 1, "hello"),
        assertEquals(2, dag.rootStage().getChildStages().size());  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        RexNode flat = RelNodeUtils.deepFlatten(rexBuilder, nested);
            serializer,
            1,
        RecordingSerializer serializer = new RecordingSerializer();  
    }
        RexNode eqD = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(4, intType, true));
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
            rexBuilder.makeCall(
        RecordingConvertor dfConvertor = new RecordingConvertor();
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
            protected Set<DelegationType> supportedDelegations() {
        assertEquals(
            Map.of("type", "integer", "index", false)
        StagePlan plan = shardStage.getPlanAlternatives().getFirst();
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
        };  
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);
            }
     * (build = LEFT) must classify as a shard-scan stage, not throw "Unknown leaf type" on
     * Expected: delegation_possible(Referer='google' AND URL='US', 0) AND GoodEvent=1  
        public byte[] serialize(RexCall call, List<FieldStorageInfo> fieldStorage) {
     * strips the DF Final layer. Without this, slice_count > 1 causes FinalPartitioned
        assertShardScanConverted(sortConvertor, dataNodeStage(sortDag));
        null,
     */  
                Map.of("type", "keyword", "index", true),
            expDelegationPossible,
                "Stripped plan should contain " + DelegatedPredicateFunction.NAME,
                makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
                plan.delegatedExpressions().size(),
    /** Result holder for combining tests. */  
        assertTrue("convertFinalAggFragment must be called on the coordinator join fragment", convertor.finalAggCalled);
    public void testInterleavedAndOrNot() {  
        RecordingConvertor dfConvertor = new RecordingConvertor();
                // stays on the operator backend but is also serializable by the Lucene peer).
        );  
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        );
            "Dual AND Dual must NOT be demoted to correctness (no delegated_predicate). Plan: " + stripped,
            @Override
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
    public void testPerfDelegatedWithoutSerializerStaysNative() {
     */
        RecordingConvertor dfConvertor = new RecordingConvertor();  
        RelNode cboOutput = runPlanner(filter, context);  
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
        LOGGER.info("Plan (NOT correctness):\n{}", strippedPlan);  
            );
        RecordingConvertor aggConvertor = new RecordingConvertor();  
    }
    ) {
            dfConvertor,
            @Override  
     */
        assertEquals("FilterTreeShape", FilterTreeShape.CONJUNCTIVE, delegationInstruction.getTreeShape());
            makeFullTextCall(FUZZY_FUNCTION, 1, "wrld")
            @Override
    /** Single native equals on a non-indexed field — single-viable to DataFusion, no delegation. */
        MockDataFusionBackend df = new MockDataFusionBackend() {
            rexBuilder.makeInputRef(intType, leftCols)
            public DelegatedSubtreeConvertor getDelegatedSubtreeConvertor() {
            ),
        assertTrue("convertFragment (shard-scan shape) must be called", convertor.shardScanCalled);  
     * carries delegated_predicate but no delegation_possible. GoodEvent is native.
            }
                makeEquals(2, SqlTypeName.INTEGER, 1)  
        // Should produce 1 combined DelegatedExpression (not 2 individual ones)
        assertEquals("delegatedPredicateCount", 1, delegationInstruction.getDelegatedPredicateCount());  
        RecordingConvertor dfConvertor = new RecordingConvertor();
            )  
            strippedPlan.contains(DelegationPossibleFunction.NAME)  
    /**
            }  
            SqlStdOperatorTable.EQUALS,
            serializer,
            }  
     * ONE {@code delegated_predicate} shipped to the peer: 1 delegated expression, 1
            "amount",
    /** AND(native, delegated) — equals on non-indexed amount stays native; MATCH_PHRASE replaced. */
        // Single shard: no exchange split, so HAVING + Aggregate + WHERE stay in ONE fragment — the
        if (expectPlaceholder) {
            plan.instructions().stream().anyMatch(node -> node.type() == InstructionType.SETUP_PARTIAL_AGGREGATE)
        var backends = delegationBackends(dfConvertor, serializer);
            rightScan,  
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
        QueryDAG dag = buildSingleFieldDelegationDag(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello world"), dfConvertor, serializer);
        // 1 correctness (match) + 1 combined performance (Referer AND URL) = 2 DelegatedExpressions  
            "2-leaf OR(correctness, perf): 0 delegation_possible markers — doesn't compose under disjunction",  
        }
        // AND. Under OR/NOT it cannot stay perf (perf delegation is AND-only in the data node), so
    private RelNode buildJoinOverTwoScans(String leftTable, String rightTable) {
        assertDoesntContainOperators(convertor.reduceFragment, OPENSEARCH_OPERATORS);
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
            plan.delegatedExpressions().getFirst().getExpressionBytes(),
    public void testPartialAggregateInstruction_emittedForCountGroupBy() {
        QueryDAG dag = buildKeywordPlusNativeDag(makeAnd(tagEq, msgEq), dfConvertor, serializer);
        OpenSearchFilter.class.getSimpleName(),
            makeAnd(
    }
            { "AND(NOT(MATCH), EQUALS-perf, native)", makeAnd(notMatch, eqPerf, nativeArm), new int[] { 2, 1, 1 } },  
        ReturnTypes.BOOLEAN,
     * Dual AND Dual: both leaves stay performance-based. The two same-backend perf leaves fuse into  
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru")
        LogicalFilter filter = LogicalFilter.create(
            }  
     * input, leaving {@code convert()} unable to route the fragment.  
     * delegation_possible(EQUALS, eqId))} while the tree-shape deriver labelled it CONJUNCTIVE; the
        int expectedDelegatedCount,  
                return dfConvertor;  
            countOccurrences(strippedPlan, "delegated_predicate")
        RecordingConvertor convertor = new RecordingConvertor();
                    sumCall()  
        if (expectNativeEquals) {
        assertDelegationResult(plan, dfConvertor, serializer, 0, false, true, List.of(), FilterTreeShape.NO_DELEGATION);
        assertShardScanConverted(convertor, dag.rootStage().getChildStages().getFirst());  
            }  
            List.of("MATCH_PHRASE", "FUZZY"),
        // field 0 = status (int, indexed), field 1 = message (keyword, indexed)  
        RecordingConvertor dfConvertor = new RecordingConvertor();
            // ── NOT inside boolean — the prod-bug shape from the OR-disjunction fix ───  
     * Multi-shard Sort(Aggregate(Filter(Scan))) with limit — full OLAP pipeline, two stages.  
    ) {
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
                return Set.of(DelegationType.FILTER);
        RecordingSerializer serializer = new RecordingSerializer();
    // ---- Error paths ----  
        QueryDAG dag = buildKeywordFuseDag(condition, dfConvertor, serializer);
            @Override
        RexNode condition = makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeEquals(0, SqlTypeName.VARCHAR, "world"));
        );  
     * Tree shape: CONJUNCTIVE (single combined expression, no interleaving).
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>();
     * <ul>  
            makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeFullTextCall(FUZZY_FUNCTION, 0, "wrld")),
    public void testNotEqualsStaysNative() {
            @Override  
    private static String describeSubtree(RexNode node) {
        RexNode flat = RelNodeUtils.deepFlatten(rexBuilder, nested);
                Map.of("type", "keyword", "index", true),
import org.apache.calcite.util.ImmutableBitSet;  
import org.apache.calcite.rel.logical.LogicalFilter;
            "2-leaf OR(correctness, perf): exactly 1 delegated_predicate marker at top",
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
            @Override
        }
            condition,  
        LOGGER.info("Plan (NOT correctness AND perf):\n{}", strippedPlan);  
            2,
        return rexBuilder.makeCall(SqlStdOperatorTable.OR, ops);
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
        assertEquals(2, plan.delegatedExpressions().size());
    }
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
            SqlStdOperatorTable.OR,
        assertDelegationResult(
    }
            }  
import org.apache.calcite.rel.logical.LogicalUnion;  
            new String[] { "Title", "Referer", "URL", "GoodEvent" },
        // NOT_EQUALS has no serializer → no delegation  
     * Mirrors prod Lucene's {@code STANDARD_TYPES = {KEYWORD, TEXT, MATCH_ONLY_TEXT}} —
        );
     * Operator precedence: (match AND Referer=) OR (URL= AND GoodEvent=)
     */
    private RelNode buildUnionOverSortedAggArms() {
        PlannerContext context = buildContext("parquet", fields, List.of(df, lucene));
            rexBuilder.makeInputRef(intType, leftCols)
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);  
    public void testCombine_OrFlatInterleaved() {
        RecordingSerializer serializer = new RecordingSerializer();
                SqlStdOperatorTable.EQUALS,  
        LOGGER.info("Stripped plan:\n{}", strippedPlan);  
        assertShardHasPartialAggInstruction(dag, "COUNT");
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {  
    }
    public void testTwoStageAggregateConversion() {  
        QueryDAG dag = buildTwoFieldDelegationDag(
        assertDoesntContainOperators(convertor.shardScanFragment, OPENSEARCH_OPERATORS);
            List.of("status", "size")
        int count = 0;  
        RelNode cboOutput = runPlanner(logical, context);
            public FragmentConvertor getFragmentConvertor() {
                "URL",
        return new CombiningResult(plan, dfConvertor, serializer);
                SqlStdOperatorTable.OR,  
        assertDoesntContainOperators(dfConvertor.shardScanFragment, ANNOTATION_MARKERS);
            rexBuilder.makeCall(
        // MATCH_PHRASE is correctness-delegated (lucene-only), EQUALS is perf-delegated (dual-viable)  
    }  
    /**
                return dfConvertor;
        assertTrue(recorded.contains("LogicalJoin"));
            Map.of(  
                Map.of("type", "keyword", "index", true),
public class FragmentConversionDriverTests extends BasePlannerRulesTests {
                .stream()  
            java.nio.charset.StandardCharsets.UTF_8  
import org.apache.calcite.rex.RexNode;  
import org.opensearch.analytics.spi.DelegatedSubtreeConvertor;
     * Lucene accepts delegation for MATCH_PHRASE, FUZZY, WILDCARD, REGEXP.  
    public void testCombine_OrOfAndLuceneWithAndNative() {
                SqlStdOperatorTable.EQUALS,  
        LogicalFilter filter = LogicalFilter.create(
        );
                };  
        // AND(eqA, OR(eqA, eqB)) — mixed operators, no same-op nesting → already flat.
            assertFalse("Stripped plan should not contain MATCH_PHRASE", strippedPlan.contains("MATCH_PHRASE"));
    }
                "GoodEvent",
        assertFalse("precondition: tree is not flat", RexUtil.isFlat(nested));  
        RexNode match = makeFullTextCall(MATCH_PHRASE_FUNCTION, 1, "hello");
        // and recurse into the right input (the probe scan).
    private static Stage findStageWithTwoChildren(Stage stage) {  
            convertor
        RexNode nested = makeAnd(or(eq2, innerOr), eq3);
            Map.of(
    // ---- Two-stage shapes ----  
        );  
        RecordingSerializer serializer = new RecordingSerializer();
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR },  
            }  
            rexBuilder.makeCall(SqlStdOperatorTable.NOT, makeEquals(0, SqlTypeName.INTEGER, 200)),
        ReturnTypes.BOOLEAN,
            protected Set<DelegationType> acceptedDelegations() {  
        );  
            rexBuilder.makeLiteral("alpha")
    /**
                return dfConvertor;
        RexNode tagEq = rexBuilder.makeCall(
        RecordingSerializer serializer = new RecordingSerializer();
        RexNode msgEq = rexBuilder.makeCall(  
    }
     */  
        };  
                probeScan.getRowType(),  
            @Override
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
        );  
        RexNode condition = makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeFullTextCall(FUZZY_FUNCTION, 0, "wrld"));
     * but Lucene was also viable, so FragmentConversion wraps the predicate with the
            }
     */
        RecordingConvertor dfConvertor = new RecordingConvertor();  
    // ---- Left-build broadcast conversion ----  
        RexNode eqB = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(2, intType, true));  
            countOccurrences(strippedPlan, "delegation_possible")
                "amount",
            dfConvertor,
        return buildDelegationDag(
    // ---- Single predicate ----
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        assertDoesntContainOperators(convertor.reduceFragment, ANNOTATION_MARKERS);  
import org.opensearch.analytics.spi.FilterTreeShape;
        MockDataFusionBackend df = new MockDataFusionBackend() {
import java.util.ArrayList;
                /* buildStageId */ 0,
                .findFirst()
    }  
    public void testLeftBuildProbeFragmentRoutesToShardScanConversion() {
        return makeFullTextCall(WILDCARD_FN, 0, pattern);
                Map.of("type", "keyword", "index", true),  
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
     * {@code delegated_predicate} — a bare delegated leaf the data node routes wholesale to Lucene.
            protected Set<DelegationType> acceptedDelegations() {
        var context = buildContext("parquet", fields, List.of(df, lucene));
import org.opensearch.analytics.planner.rel.OpenSearchSort;
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
        LogicalFilter filter = LogicalFilter.create(
        RexNode notFuzzy = rexBuilder.makeCall(SqlStdOperatorTable.NOT, makeFullTextCall(FUZZY_FUNCTION, 1, "wrld"));  
        null,
import org.opensearch.analytics.planner.rel.AnnotatedProjectExpression;  
            ),
        );
        // Coord-side reduce stages no longer register FinalAggregateInstructionHandler.
        OperandTypes.ANY,  
            "2-leaf OR(correctness, perf): 1 delegated expression (whole OR ships as one peer subtree)",
        MockLuceneBackend lucene = new MockLuceneBackend() {
        );
        var r = runCombining(or(makeAnd(matchPhrase("hello"), fuzzy("wrld")), makeAnd(wildcard("h*llo"), amountEquals(200))));
        RecordingSerializer serializer = new RecordingSerializer();
            assertEquals("treeShape in instruction", expectedTreeShape, filterInstruction.getTreeShape());
import org.apache.calcite.plan.RelOptUtil;
     * Regression for the RexUtil.isFlat AssertionError. After predicate delegation strips the  
     *   <li>{@code DelegatedExpression} entries the data node receives,</li>  
            protected Set<DelegationType> acceptedDelegations() {
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
            protected Set<DelegationType> acceptedDelegations() {
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
    }
            Stage found = findStageWithTwoChildren(child);  
            Map.of("type", "keyword", "index", true),
            protected Set<DelegationType> acceptedDelegations() {  
            }
            @Override
            "amount",
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
                    return call.getOperator().getName();
        var context = buildContext("parquet", fields, backends);
            }
        assertEquals(2, r.plan.delegatedExpressions().size());
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
    public void testOrPerformanceLeavesAndCorrectness_fusesToOneDelegated() {
    }
        RexNode eqA = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(1, intType, true));
        RexNode eqA = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(1, intType, true));
    }  
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());
            )
        return makeEquals(1, SqlTypeName.INTEGER, val);  
        assertTrue(convertor.finalAggCalled);
        RelNode logical = buildUnionOverSortedAggArms();  
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),  
    /** Same-op nesting hidden under a NOT — NOT(OR(eqA, OR(eqB, eqC))) AND eqD. */  
        MockDataFusionBackend dfWithUnion = new MockDataFusionBackend() {
            plan.delegatedExpressions().getFirst().getExpressionBytes(),
            @Override  
            dfConvertor,  
    // ---- OR with mixed correctness + performance delegation ----
        // AND(OR(AND(match_phrase, fuzzy), match_phrase), fuzzy, amount=200)
            public FragmentConvertor getFragmentConvertor() {
    public void testCombine_OrOfAndLuceneWithNative() {  
        // Multi-shard so PR #21639's split rule demands COORDINATOR+SINGLETON on each input,  
        Map<String, Map<String, Object>> fields = Map.of(
            protected Set<DelegationType> supportedDelegations() {
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
     * Multi-shard Aggregate(Scan) — child calls convertFragment (shard-scan shape),  
        }  
        @Override
    }
    }
        // Pure flatten: the inner OR's 3 operands splice into the middle OR (eq2 + 3 = 4), none deduped.
        Map<String, Map<String, Object>> fields = Map.of(
    private void assertDoesntContainOperators(RelNode fragment, Set<String> forbidden) {
                return Set.of(DelegationType.FILTER);
    public void testOrNativeAndDelegated() {
            @Override
                "delegation plan must have SHARD_SCAN_WITH_DELEGATION instruction",
        QueryDAG dag = buildDelegationDag(
        SqlFunctionCategory.USER_DEFINED_FUNCTION
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
     */
            condition  
    /**  
            probeScan.getCluster(),
            new String[] { "status", "message", "amount" },  
        // Only MATCH_PHRASE delegated; EQUALS stays native (no serializer)  
        // Find the coord-side join stage — the stage whose fragment contains the Join with
            }
            join,  
        RecordingSerializer serializer = new RecordingSerializer();
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),  
        assertNotNull("root alternative must have convertedBytes", root.getPlanAlternatives().getFirst().convertedBytes());
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
        assertEquals(
        }
    // ---- Interleaved AND/OR/NOT ----  
            @Override
    public void testCombine_OrOfThreeLuceneAndNative() {
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello world")
        var r = runCombining(or(not(matchPhrase("hello")), not(fuzzy("wrld")), amountEquals(200)));
        assertFalse("instructions must not be empty", plan.instructions().isEmpty());  
import org.opensearch.analytics.planner.rel.OpenSearchProject;  
                .filter(node -> node.type() == InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION)
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
        assertTrue("AND should be preserved", RelOptUtil.toString(dfConvertor.shardScanFragment).contains("AND"));
                ),
 * across a range of query shapes.
        RecordingConvertor dfConvertor = new RecordingConvertor();  
        RecordingConvertor dfConvertor = new RecordingConvertor();
            public FragmentConvertor getFragmentConvertor() {
        int callCount;
            List.of("status", "size")
        RecordingConvertor convertor = new RecordingConvertor();  
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            SqlStdOperatorTable.EQUALS,  
        assertFalse(
        StagePlan plan = runHaving(matchPhrase("hello"));  
        // ── shapes ──────────────────────────────────────────────────────────  
                    new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
     *       once on the root stage — the OpenSearchJoin wrapper and the two ExchangeReducers
            }
    /**
        };
    private static int countOccurrences(String haystack, String needle) {
            }  
        var r = runCombining(makeAnd(or(matchPhrase("hello"), fuzzy("wrld")), or(wildcard("h*"), amountEquals(200))));  
     * <p>Regression guard for the perf-demotion bug: previously every dual-viable leaf was demoted to
        Map<String, Map<String, Object>> fields = Map.of(
        );
        assertEquals("Should have 1 combined delegated expression", 1, plan.delegatedExpressions().size());
        LOGGER.info("Plan (AND correctness + multi-perf + native):\n{}", strippedPlan);  
            @Override  
        return buildDelegationDag(  
            stage = stage.getChildStages().getFirst();  
                map.put(ScalarFunction.MATCH_PHRASE, serializer);
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
                return Map.of();
            mockTable(
    public void testCombinerShapeMatrix_andOrNot_withAndWithoutNativeSibling() {
        );
        if (expectedDelegatedCount > 0) {  
        RecordingSerializer serializer = new RecordingSerializer();  
                Map.of("type", "keyword", "index", true),  
        RexNode eq3 = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(3, intType, true));
        assertTrue("coord-side reduce instructions must be empty", plan.instructions().isEmpty());  
    }
        List<String> expectedFunctions,  
     *  ({@code STANDARD_TYPES = {KEYWORD, TEXT, MATCH_ONLY_TEXT}}). Distinct fields prevent
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
    private QueryDAG buildKeywordPlusNativeDag(RexNode condition, RecordingConvertor dfConvertor, RecordingSerializer serializer) {
    private LogicalJoin makeInnerEquiJoin() {
        RecordingSerializer serializer = new RecordingSerializer();  
                return Set.of(DelegationType.FILTER);  
    public void testAndOrAndNested_PureLucene() {
                    "test_index",
    private static Stage dataNodeStage(QueryDAG dag) {
        assertTrue("convertFragment (final-agg shape) must be called for the Join subtree", convertor.finalAggCalled);  
        RelNode cboOutput = runPlanner(filter, context);
        assertEquals(4, ((RexCall) middleOr).getOperands().size());  
                    makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
     * delegated_predicate marker, 0 delegation_possible markers.
        FragmentConversionDriver.IntraOperatorDelegationBytes delegationBytes = new FragmentConversionDriver.IntraOperatorDelegationBytes(  
            Map.of("type", "keyword", "index", true),  
                return map;
        QueryDAG dag = buildDelegationDag(
        );
     *       were stripped by {@code FragmentConversionDriver.convertReduceNode}, leaving a plain
     * the number of shards only affects target resolution at dispatch time, not the conversion
            probeScan.getTraitSet(),  
    private List<AnalyticsSearchBackendPlugin> delegationBackends(RecordingConvertor dfConvertor, RecordingSerializer serializer) {
            serializer,  
        RelNode scan = stubScan(
     *   - field 0 = status   (integer, indexed). NOTE: prod Lucene only filters keyword/text/  
            false,
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 1, "timeout error"),  
    }
                return map;
            )  
    // ---- Dual-viable leaves stay performance-based by default ----  
            { "AND(NOT(MATCH), native)", makeAnd(notMatch, nativeArm), new int[] { 1, 1, 0 } }, };
import org.opensearch.analytics.spi.FieldStorageInfo;  
     * post-combiner shape via three counters:
            rexBuilder.makeLiteral("hello")  
    private QueryDAG buildKeywordFuseDag(RexNode condition, RecordingConvertor dfConvertor, RecordingSerializer serializer) {  
            protected Set<DelegationType> acceptedDelegations() {
            public DelegatedSubtreeConvertor getDelegatedSubtreeConvertor() {
    private FuseTestSetup buildFuseTestSetup() {
 * SPDX-License-Identifier: Apache-2.0
            "perf can't survive under OR — must not have delegation_possible",
    public void testMissingSerializerThrows() {  
                map.put(ScalarFunction.FUZZY, serializer);  
            label + " — delegation_possible markers (plan: " + stripped + ")",  
            protected Set<DelegationType> supportedDelegations() {  
        RelNode marked = runPlanner(filter, context);  
    /** OR(match_phrase, amount=100, fuzzy, count=200, wildcard) — 3 Lucene combined, 2 native preserved. */
    /** OR(AND(match_phrase, fuzzy), AND(wildcard, amount=200)) — left arm combined, right has wildcard separate. */
        );
    private void assertShardHasPartialAggInstruction(QueryDAG dag, String label) {
        RecordingSerializer serializer,  
            @Override
    /** AND(match_phrase, OR(fuzzy, amount=100), wildcard) — fuzzy materialized inside OR, match_phrase+wildcard may combine at AND. */  
            }
        );
        RexNode fuzzy = makeFullTextCall(FUZZY_FUNCTION, 1, "wrld");  
        IllegalStateException exception = expectThrows(  
        RecordingConvertor sortConvertor = new RecordingConvertor();
                rexBuilder.makeLiteral("hello")
        return ((ShardScanWithDelegationInstructionNode) plan.instructions()
        final List<String> serializedFunctions = new ArrayList<>();
        ShardScanWithDelegationInstructionNode delegationInstruction = (ShardScanWithDelegationInstructionNode) plan.instructions()  
     * the whole Union subtree as one convertFragment (final-agg shape) call — same path as Join.  
        RecordingConvertor dfConvertor = new RecordingConvertor();
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
            new String[] { "Title", "Referer", "URL", "GoodEvent" },
        String recorded = RelOptUtil.toString(convertor.reduceFragment);  
            ),  
            dfConvertor,
                rexBuilder.makeLiteral("alpha")
                return Set.of(DelegationType.FILTER);  
    /**  
            ),
import org.apache.calcite.rel.core.JoinRelType;  
                makeEquals(1, SqlTypeName.VARCHAR, "US"),
            // ── OR perf-only: perf reclassified to correctness, fused into one peer shipment ──  
            condition,  
        };  
        // EQUALS on tag (keyword, indexed) — dual-viable, perf-delegation candidate.
                "Referer",  
        assertDelegationResult(plan, dfConvertor, serializer, 1, true, true, List.of("MATCH_PHRASE", "FUZZY"), FilterTreeShape.CONJUNCTIVE);
                "tag",  
        QueryDAG dag = buildTwoFieldDelegationDag(makeEquals(2, SqlTypeName.INTEGER, 200), dfConvertor, serializer);  
                makeEquals(2, SqlTypeName.VARCHAR, "US"),
        // Construct probe-stage fragment manually: Join(BroadcastScan, TableScan).  
        assertEquals(1, plan.delegatedExpressions().size());
    }  
    }  
        // The recorded fragment must be a plain LogicalJoin (OpenSearch* wrappers stripped) whose
        assertShardHasPartialAggInstruction(dag, "SUM");
            }
            java.nio.charset.StandardCharsets.UTF_8
    }
     * Multi-shard variant: each join side scans a 5-shard index. Conversion shape is identical;  
    public void testAndCorrectnessOrPerfWithNative() {
                return Set.of(DelegationType.FILTER);
        if (node instanceof RexCall call) {
            filterConvertor
    }
     * Builds an After-HEP shape close to JoinCommandIT#testInnerJoin: a top-level
    public void testPartialAggregateInstruction_emittedForApproxCountDistinct() {  
import org.apache.calcite.rel.type.RelDataType;
     *     path against a mock Lucene; do not interpret as a prod use case.  
        RecordingSerializer serializer,
        return makeEquals(2, SqlTypeName.INTEGER, val);
        RexNode condition,
        RelOptTable table = mockTable("test_index", "status", "size");
     * leaf); under OR/NOT it's reclassified to correctness, fusing with any same-backend correctness
     * NOT_EQUALS has no serializer, stays fully native, no delegation.
                return Set.of(DelegationType.FILTER);
        // Rust's apply_aggregate_mode strip, which corrupted column refs (cnt[sum]/cnt[count]).
        RelNode rightProject = LogicalProject.create(
        QueryDAG dag = buildAndConvert(3, makeInnerEquiJoin(), convertor);
                new String[] { "message", "amount", "count" },
        OpenSearchSort.class.getSimpleName(),
import org.opensearch.analytics.planner.BasePlannerRulesTests;  
            Map.of(  
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
     */
        RecordingConvertor convertor = new RecordingConvertor();
        Stage current = dag.rootStage();
    }
        var r = runCombining(or(not(matchPhrase("hello")), amountEquals(200)));  
    }
            recorded.split("OpenSearchStageInputScan", -1).length - 1 == 2
            new org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan(
     * nothing forces it — so DataFusion never evaluated it. A demoted result here would show a bare  
        );
        var context = buildContext("parquet", fields, backends);  
        assertEquals("Pure Lucene nested OR(AND,leaf) should produce 1 expression", 1, plan.delegatedExpressions().size());
     * {@code convertFragment (final-agg shape)} pass — same path as Union / Intersect /  
     * {@code OR(perf-tag, perf-message, FUZZY-correctness)} — two dual-viable leaves plus a
                Map.of("type", "integer", "index", false)
            public FragmentConvertor getFragmentConvertor() {  
}  
        // delegated_predicate markers, delegation_possible markers}. Single expectation per shape:  
        assertTrue("at least 1 expression", r.plan.delegatedExpressions().size() >= 1);  
            .orElseThrow(() -> new AssertionError("delegation plan must have SHARD_SCAN_WITH_DELEGATION"));
        );
     */  
            assertEquals(
            true,
     *   <li>{@code convertShardScanFragment("test_index", LogicalTableScan)} called once per side
        assertEquals(  
        assertEquals(  
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
        // tag, message both keyword(indexed) → dual-viable for EQUALS; amount int(not indexed) = native.  
            }
                map.put(ScalarFunction.MATCH_PHRASE, serializer);  
            // EQUALS on tag (keyword, indexed) — dual-viable, performance-delegation candidate
    public void testCombine_OrTwoNotsWithNative() {
    /** AND(delegated, delegated) — both replaced, two entries in delegatedQueries. */
            assertFalse(
                "GoodEvent",
            return ("delegated:" + call.getOperator().getName()).getBytes(StandardCharsets.UTF_8);
        // OR( AND(match, Referer=), AND(URL=, GoodEvent=) )
            ),  
    /** Records serialization calls for delegation tests. */
    /**  
        assertTrue("convertFragment (final-agg shape) must be called for the Union subtree", convertor.finalAggCalled);  
        }
        RecordingConvertor convertor = new RecordingConvertor();
            List.of(rexBuilder.makeInputRef(scan, 0), rexBuilder.makeInputRef(scan, 1)),  
        assertTrue("Should have delegation_possible", strippedPlan.contains(DelegationPossibleFunction.NAME));
        assertEquals(
        assertEquals("delegated WHERE under HAVING must still ship one expression", 1, plan.delegatedExpressions().size());
    /** OR(native, delegated) — equals on non-indexed amount stays native; MATCH_PHRASE replaced. */  
        RecordingConvertor dfConvertor = new RecordingConvertor();  
        // Wire-shape: one delegated expression via DelegatedSubtreeConvertor.
    private void assertShardScanConverted(RecordingConvertor convertor, Stage stage) {  
        RexNode condition = rexBuilder.makeCall(
     * split or SINGLE-over-RANDOM gather), and the Union sits at the coord with two
            SqlStdOperatorTable.EQUALS,
            @Override  
    public void testCombine_OrFlatFivePredicates() {  
        );  
    );
        assertEquals("first instruction must be SHARD_SCAN", InstructionType.SETUP_SHARD_SCAN, plan.instructions().getFirst().type());
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
        PlanForker.forkAll(dag, context.getCapabilityRegistry());  
        var context = buildContext("parquet", fields, backends);  
        RexNode nested = makeAnd(not(or(eqA, or(eqB, eqC))), eqD);
            public FragmentConvertor getFragmentConvertor() {
        return new FuseTestSetup(dfConvertor, serializer, condition);
        assertTrue("Should have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));
     * (CONJUNCTIVE), not the topmost HAVING (NO_DELEGATION). Regression: picking the topmost filter
        QueryDAG d = buildKeywordPlusNativeDag(condition, c, new RecordingSerializer());
        assertDoesntContainOperators(dfConvertor.shardScanFragment, ANNOTATION_MARKERS);  
            @Override
     * NOT match(Title,'ru')  
                strippedPlan.contains(DelegatedPredicateFunction.NAME)
            ),  
        OpenSearchAggregate.class.getSimpleName(),  
    public void testSortOnAggregateOnFilteredScan() {
    /** NOT(match_phrase) OR amount=200 — NOT wraps delegated, OR with native, INTERLEAVED. */
    }  
            List.of(rexBuilder.makeInputRef(leftScan, 0), rexBuilder.makeInputRef(leftScan, 1)),
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
            countOccurrences(stripped, "delegated_predicate")  
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
    private RexNode wildcard(String pattern) {  
            }
                Map.of("type", "keyword", "index", true),
        MockLuceneBackend lucene = new MockLuceneBackend() {  
    // like __row_id__) — see OpenSearchTableScan#stripAnnotations.  
        );
    /**
            }
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 1),
                Map.of("type", "integer", "index", false)
        assertTrue("Should have delegation_possible", strippedPlan.contains(DelegationPossibleFunction.NAME));  
    /** AND(delegated, delegated) with combining support — combined into single DelegatedExpression. */
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);  
        // shape this test was designed to verify. Single-shard same-table joins go SHARD-local
                filterInstruction.getDelegatedPredicateCount()
     * coord must gather). The test verifies convertFragment (shard-scan shape) is called on the
    public void testCombine_AndOfTwoOrs_OnePureOneMixed() {
        null,  
            @Override
        RelNode rightScan = stubScan(mockTable("test_index", "status", "size"));
        assertTrue("Combined should contain MATCH_PHRASE", combinedStr.contains("MATCH_PHRASE"));
        assertReduceStageConverted(convertor, dag.rootStage());
    }
        assertEquals(FilterTreeShape.CONJUNCTIVE, treeShapeOf(plan));
        RexNode condition,
        RecordingSerializer serializer = new RecordingSerializer();
    }  
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
                mockTable(  
     *   - field 2 = amount   (integer, NOT indexed) — SINGLE-VIABLE to DataFusion only.
            RexNode condition = (RexNode) testCase[1];  
        AggregateCall countCall = AggregateCall.create(
            )
        RexNode eqC = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(3, intType, true));  
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
            List.of(rexBuilder.makeInputRef(rightScan, 0), rexBuilder.makeInputRef(rightScan, 1)),
        RecordingSerializer serializer = new RecordingSerializer();  
        // OR(MATCH(message,'hello') correctness-delegated, EQUALS(tag='alpha') perf-delegated)
     * siblings into one delegated_predicate. Native-only siblings stay native at the top.
        }
    ) {  
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());  
        );
        StagePlan plan = stage.getPlanAlternatives().getFirst();
        );  
        assertEquals("OR(AND,AND) pure Lucene should produce 1 expression", 1, plan.delegatedExpressions().size());  
        RecordingConvertor dfConvertor = new RecordingConvertor();
        );
        String label,
     * ER. Isthmus's SubstraitRelVisitor handles Union natively; reduce-stage conversion serializes
     */
        RelNode arm2 = buildSortedAggArm();  
        OpenSearchProject.class.getSimpleName()
        assertFalse("Should NOT have delegation_possible", strippedPlan.contains(DelegationPossibleFunction.NAME));  
            @Override  
        // OR(AND(match_phrase, fuzzy), AND(match_phrase, fuzzy))
        int leftCols = leftScan.getRowType().getFieldCount();
            SqlStdOperatorTable.OR,  
        return leafStage(dag).getPlanAlternatives().getFirst();  
        QueryDAG sortDag = buildAndConvert(
        assertEquals(1, dag.rootStage().getChildStages().size());
     * Under OR the Referer/URL perf leaves ship to Lucene (reclassified to correctness), so the plan  
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        MockDataFusionBackend df = new MockDataFusionBackend() {  
            { "AND(MATCH, EQUALS-perf, native)", makeAnd(match, eqPerf, nativeArm), new int[] { 2, 1, 1 } },  
    }
        assertFalse("Should NOT have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));
            public FragmentConvertor getFragmentConvertor() {
                map.put(ScalarFunction.FUZZY, serializer);
        MockDataFusionBackend df = new MockDataFusionBackend() {
            "message",
    );
            strippedPlan.contains(DelegationPossibleFunction.NAME)  
        String recorded = RelOptUtil.toString(convertor.reduceFragment);  
     */
    }  
import org.apache.calcite.rel.RelNode;
    public void testPartialAggregateInstruction_emittedForFilteredAggregate() {
     * NOT(correctness) combined into BoolQuery(must_not) + perf-delegated under AND combined separately.
        return new MockDataFusionBackend() {
            probeScan,                      // probe scan = RIGHT input
                return Set.of(DelegationType.FILTER);
            serializer,  
        QueryDAG aggDag = buildAndConvert(1, makeAggregate(sumCall()), aggConvertor);
                map.put(ScalarFunction.REGEXP, serializer);
        };
            { "OR(NOT(MATCH), EQUALS-perf, native)", or(notMatch, eqPerf, nativeArm), new int[] { 1, 1, 0 } },
            List.of(),
        // Instruction assertions
        );
        );
        );
     * (both perf-delegatable for EQUALS) plus a non-indexed integer for the native sibling.  
            }  
        QueryDAG dag = buildDelegationDag(
        while (!stage.getChildStages().isEmpty()) {
        return dag;
        SqlFunctionCategory.USER_DEFINED_FUNCTION
            makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeFullTextCall(FUZZY_FUNCTION, 0, "wrld")),
        RexNode condition = rexBuilder.makeCall(
    }  
        assertDelegationResult(plan, dfConvertor, serializer, 1, true, false, List.of("MATCH_PHRASE"), FilterTreeShape.CONJUNCTIVE);
            { "OR(MATCH, native)", or(match, nativeArm), new int[] { 1, 1, 0 } },  
        PlanForker.forkAll(dag, context.getCapabilityRegistry());  
    }  
            rexBuilder.makeLiteral("alpha")
    public void testDeepFlatten_removesNestedSameOpOr() {
            .filter(node -> node.type() == InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION)
            sortConvertor
    // ---- Delegation tagging tests ----  
            @Override  
    private static Stage leafStage(QueryDAG dag) {  
                Map<ScalarFunction, DelegatedPredicateSerializer> map = new HashMap<>(super.delegatedPredicateSerializers());  
        };  
        // (label, condition, expectation) — expectation = {delegatedExpressions,
     */
        // the goal is to exercise FragmentConversionDriver.convert against the new shape.
/*  
    }
            condition,
    }
        assertEquals(1, r.plan.delegatedExpressions().size());  
     * Minus. No substrait-level join stitching.
        );
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)  
        RecordingSerializer serializer = new RecordingSerializer();
     */  
    );  
        LOGGER.info("Plan (NOT equals → NOT_EQUALS, no serializer):\n{}", strippedPlan);
            { "OR(MATCH, EQUALS-perf, native)", or(match, eqPerf, nativeArm), new int[] { 1, 1, 0 } },
        );  
        // Both MATCH_PHRASE (correctness) and EQUALS (perf) have serializers → combined into 1  
        assertEquals("test_index", convertor.shardScanTableName);
            }
    // ---- Single-stage query shapes ----  
            makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeFullTextCall(FUZZY_FUNCTION, 0, "wrld")),  
        // amount is index=false → equals stays native; only MATCH_PHRASE + FUZZY get delegated.  
            project,
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            }
        return List.of(df, lucene);  
                "message",
    }  
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
            }  
        RecordingConvertor c = new RecordingConvertor();
        RelNode agg = LogicalAggregate.create(project, List.of(), ImmutableBitSet.of(0), null, List.of(sumCall));  
        for (String op : forbidden)
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
        QueryDAG dag = buildAndConvert(2, makeAggregate(approxCountDistinctCall(scan)), convertor);
        QueryDAG dag = buildTwoFieldDelegationDag(makeEquals(0, SqlTypeName.INTEGER, 200), dfConvertor, serializer);
        RecordingConvertor convertor = new RecordingConvertor();
        assertEquals(1, r.plan.delegatedExpressions().size());
            }  
            }
        return stage;
    }
        null,  
            .findFirst()  
        QueryDAG dag = buildAndConvert(2, makeAggregate(sumCall()), convertor);
            makeFullTextCall(FUZZY_FUNCTION, 0, "wrld")
    private static final SqlFunction REGEXP_FN = new SqlFunction(  
                )  
                Map.of("type", "keyword", "index", true),  
            makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "hello"), makeFullTextCall(FUZZY_FUNCTION, 0, "wrld")),
        }
     *   <li>{@code delegated_predicate(id)} markers (peer evaluates these end-to-end),</li>
        assertShardScanConverted(convertor, dag.rootStage().getChildStages().getFirst());  
                mockTable(
            "message",  
        // but EQUALS has no serializer on lucene → stays native
            int[] expected = (int[]) testCase[2];
            stripped.contains(DelegationPossibleFunction.NAME)
                Map.of("type", "integer", "index", true),
            protected Set<DelegationType> supportedDelegations() {
    // ---- Helpers ----
            }  
     * and asserts the recording convertor sees:
            List.of(),  
    /** OR(AND(match_phrase, fuzzy, wildcard), amount=200) — all 3 Lucene AND-combined, then OR with native. */  
                    new String[] { "message", "amount" },
            serializer
        assertEquals(2, r.plan.delegatedExpressions().size());
        };
        RexNode condition = makeAnd(makeEquals(2, SqlTypeName.INTEGER, 200), orClause);
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        LOGGER.info("Plan (AND only-perf + native):\n{}", strippedPlan);
        String planStr = RelOptUtil.toString(fragment);  
            serializer,  
            // ── AND: perf stays perf (delegation_possible per perf leaf) ──
            @Override
            rightProject,  
     * Expected: delegated_predicate(0) AND delegation_possible(tag='hello', 1)  
            @Override  
                makeAnd(makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru"), makeEquals(1, SqlTypeName.VARCHAR, "google")),  
                    "test_index",  
    private record CombiningResult(StagePlan plan, RecordingConvertor convertor, RecordingSerializer serializer) {
            protected Set<DelegationType> supportedDelegations() {
     * Calcite's shallow RexUtil.flatten does not descend into the inner OR, so
            makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru")
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
        return current;  
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
        } else {  
        // message=keyword(indexed), amount=integer(NOT indexed → native only)  
        );
    // ---- Complex combining cases ----
    public void testCoordinatorCentricJoinConversionMultiShard() {
                "message",
        Stage shardStage = dag.rootStage().getChildStages().getFirst();  
            notFuzzy
    /** OR(NOT(match_phrase), NOT(fuzzy), amount=200) — both NOTs combine under OR, native stays. */  
    }
        };
        );
                Map.of("type", "integer", "index", false)  
     * data node trusted the label, forced the single-collector path onto a tree containing an OR,
        SqlKind.OTHER_FUNCTION,
        RelNode scan = stubScan(table);  
                return convertor;
            ),  
    // ---- Join conversion tests (Gap #1 — M0 coordinator-centric) ----
            public FragmentConvertor getFragmentConvertor() {  
        MockLuceneBackend lucene = new MockLuceneBackend() {
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
    private MockDataFusionBackend dfWithConvertor(RecordingConvertor convertor) {
import org.opensearch.analytics.spi.DelegationType;
    }
    public void testSingleNativePredicate() {
     */
            }
     * Coord-side Union with pass-through operators (Sort/Project) between each arm and its
    private RelNode buildSortedAggArm() {
        QueryDAG dag = buildAndConvert(2, makeAggregate(countStarCall()), convertor);
    private QueryDAG buildTwoFieldDelegationDag(RexNode condition, RecordingConvertor dfConvertor, RecordingSerializer serializer) {
            // ── NOT shapes (Calcite folds NOT(=) → ≠ pre-combiner, so no perf survives there) ──
                map.put(ScalarFunction.MATCH_PHRASE, serializer);  
            condition  
        QueryDAG dag = buildTwoFieldDelegationDag(
import java.util.Map;
                return dfConvertor;
        Object[][] cases = {  
        assertNotNull(bytes);
            SqlStdOperatorTable.OR,
import org.opensearch.analytics.planner.PlannerContext;  
            }
                rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
    /**
            1,  
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            @Override
        RelNode cboOutput = runPlanner(filter, context);
        boolean expectPlaceholder,
                return Set.of(DelegationType.FILTER);
     */
     */
    /** OR(delegated, delegated) with combining support — combined into single DelegatedExpression with OR structure. */  
    /** AND(OR(match_phrase, amount=200), fuzzy) — match_phrase can't merge with fuzzy across OR → 2 expressions. */
        org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan broadcastScan =
            1,  
    public void testAndNativeAndDelegated() {
     * Expected: delegated_predicate(0) — correctness delegation, NOT absorbed into BoolQuery(must_not).
    }
     */
            condition
                return dfConvertor;
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {  
        // AND(OR(AND(match_phrase, fuzzy), match_phrase), fuzzy)  
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
        //
        return dag;
     * have a coord stage above the data-node stage (since scans declare RANDOM, the
        assertShardScanConverted(convertor, dataNodeStage(dag));
        org.opensearch.analytics.planner.PlannerContext ctx = buildContext("parquet", 1, intFields());
                        children.add(describeSubtree(child));  
            switch (call.getKind()) {  
            false,  
    }
                Map.of("type", "integer", "index", false)
        }
    public void testSingleDelegatedPredicate() {
            @Override
        Map<String, Map<String, Object>> fields  
    /**
     *  Calcite's SEARCH/Sarg rewrite from folding the two EQUALS into a sargable predicate.  
                return dfConvertor;
        RecordingConvertor convertor = new RecordingConvertor();  
            scan,
        LogicalFilter filter = LogicalFilter.create(
            ),  
     * Expected: delegated_predicate(0) AND delegation_possible(Referer, 1) OR delegation_possible(URL, 2) AND GoodEvent=1
            false,
    /** AND(OR(AND(a,b), c), d, native) — mixed: Lucene subtree combined + native preserved. */
     */  
     *
            makeSort(makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)), 10),
        assertEquals(FilterTreeShape.CONJUNCTIVE, treeShapeOf(plan));  
            Map.of("tag", Map.of("type", "keyword", "index", true), "message", Map.of("type", "keyword", "index", true))
        assertTrue("deepFlatten must produce a flat tree", RexUtil.isFlat(flat));
                map.put(ScalarFunction.FUZZY, serializer);
                return dfConvertor;
/**
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(plan));
     */  
        );
            )  
    public void testPerfDelegatedWithSerializerCombines() {
        // OR(match, AND(Referer=, URL=, GoodEvent=))  
            @Override
            treeShapeOf(plan)
        QueryDAG dag = buildAndConvert(
     * (count=1) above and the delegated WHERE (match_phrase) below. The derived FilterTreeShape  
    // ---- AND conditions ----
            rexBuilder.makeCall(SqlStdOperatorTable.NOT, makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru")),
        while (!current.getChildStages().isEmpty()) {  
        // OR siblings targeting same backend should be combined into 1 DelegatedExpression
            @Override  
    /**
    public void testCombine_AndWithOrContainingMixed() {
     */
        RecordingConvertor dfConvertor = new RecordingConvertor();  
            protected Set<DelegationType> supportedDelegations() {
    /** OR(AND(a,b), AND(c,d)) — pure Lucene two AND groups under OR → 1 combined. */
        RecordingConvertor dfConvertor = new RecordingConvertor();
    }  
            Map.of("type", "integer", "index", false),  
        // root — so a shallow root-only flatten never visits it. AND(OR(eq2, OR(=,=,=)), eq3).
        if (node instanceof AnnotatedPredicate ap) {
    }
        // under PR's design (one stage, no ERs) and don't exercise the coord-centric path.  
            ShardScanWithDelegationInstructionNode filterInstruction = (ShardScanWithDelegationInstructionNode) plan.instructions()
        RelNode cboOutput = runPlanner(logicalPlan, context);
                return map;
     * Combiner shape matrix across AND/OR/NOT × native-sibling presence. Each row pins the  
        assertEquals("test_index", convertor.shardScanTableName);
        );
            serializer,
                "status",  
    }
            Map.of("type", "integer", "index", false)
        // DataFusion plans the substrait Aggregate's Partial+Final pair itself via the legacy
    public void testOrOfAndDelegated_PureLucene() {
        // Rules: a dual-viable (perf) leaf stays performance-delegated (delegation_possible) under  
        // Lucene mock accepts delegation but has NO serializers — predicate stays native
            plan,  
            { "NOT(MATCH)", rexBuilder.makeCall(SqlStdOperatorTable.NOT, match), new int[] { 1, 1, 0 } },  
     *     purposes only. Pre-existing tests use this to exercise the dual-viable performance
        );
            rexBuilder.makeCall(
            condition
            { "OR(MATCH, FUZZY, native)", or(match, fuzzy, nativeArm), new int[] { 1, 1, 0 } },
    /** Sort(Aggregate(Filter(Scan))) with limit — full OLAP pipeline. */
import org.apache.calcite.plan.RelOptTable;
        RecordingConvertor convertor = new RecordingConvertor();  
        assertNotNull("expected a stage with 2 child stages (the coord-side Join stage)", joinStage);
 */  
     * pass-through operators above each ER.
        );
                SqlStdOperatorTable.OR,  
                return Set.of(DelegationType.FILTER);
                map.put(ScalarFunction.MATCH, serializer);
            ),
            rexBuilder.makeLiteral(50000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
        );
        QueryDAG dag = buildTwoFieldDelegationDag(condition, dfConvertor, serializer);
            }
        return makeFullTextCall(FUZZY_FUNCTION, 0, query);  
        assertEquals(label + " — delegatedExpressions (plan: " + stripped + ")", expDelegatedExprs, p.delegatedExpressions().size());
import org.apache.calcite.sql.SqlKind;
    }
     * Referer='google' AND URL='US' AND GoodEvent=1 (no correctness delegation)
            protected Set<DelegationType> supportedDelegations() {
            label + " — delegated_predicate markers (plan: " + stripped + ")",
        RelNode cboOutput = runPlanner(filter, context);
        };
            }  
        QueryDAG dag = buildAndConvert(2, buildJoinOverTwoScans("test_index", "test_index"), convertor);
        RelNode cboOutput = runPlanner(filter, context);
        SqlKind.OTHER_FUNCTION,
    // ---- Composed pipeline shapes ----  
import org.apache.calcite.rex.RexUtil;
        assertEquals(1, dag.rootStage().getChildStages().size());
        RecordingConvertor dfConvertor = new RecordingConvertor();  
        var r = runCombining(or(makeAnd(matchPhrase("hello"), fuzzy("wrld"), not(wildcard("h*"))), amountEquals(200)));
            convertor
                new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER, SqlTypeName.INTEGER }
        // Must not throw "Unknown leaf type" — findLeaf must skip the broadcast placeholder
        assertNotNull(convertor.reduceFragment);
            rexBuilder.makeCall(
        RecordingConvertor dfConvertor = new RecordingConvertor();  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 1),
        };
import org.apache.calcite.sql.SqlFunction;
        // No annotation markers should survive stripping
            assertTrue("Stripped plan should contain native equals", strippedPlan.contains("="));
            }  
        RelNode cboOutput = runPlanner(filter, context);
        );  
            protected Set<DelegationType> supportedDelegations() {  
        StagePlan p = leafStage(d).getPlanAlternatives().getFirst();  
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(), null, List.of(countCall));
        LogicalFilter where = LogicalFilter.create(scan, whereCondition);
        LOGGER.info("Marked+CBO:\n{}", RelOptUtil.toString(cboOutput));  
        org.opensearch.analytics.planner.rel.OpenSearchTableScan probeScan =
        };
        assertTrue(  
    private static final Set<String> OPENSEARCH_OPERATORS = Set.of(
        // Root stage: convertFinalAggFragment called on the stripped join fragment.  
            }  
            serializer,
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));  
     * Expected: delegated_predicate(0) AND delegation_possible(Referer='google' AND URL='US', 1) AND GoodEvent=1
            org.apache.calcite.rel.RelCollations.of(new org.apache.calcite.rel.RelFieldCollation(0)),  
        );
        assertEquals("delegatedQueries count", 1, plan.delegatedExpressions().size());  
        assertEquals("expected exactly one alternative", 1, stage.getPlanAlternatives().size());
        );  
        RecordingConvertor convertor = new RecordingConvertor();
     *  involved, so this stays consistent with prod Lucene caps. */
        assertEquals(1, r.plan.delegatedExpressions().size());  
    }  
    public void testSinglePerformanceDelegatedPredicate() {
            SqlStdOperatorTable.OR,  
        RecordingSerializer serializer = new RecordingSerializer();
            assertFalse("Stripped fragment must not contain [" + op + "]", planStr.contains(op));  
            "message",
        );
    /**  
        RexNode innerOr = or(eq1, eq2, eq3);
            rexBuilder.makeLiteral("hello")  
    /**
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));
        assertEquals(2, r.plan.delegatedExpressions().size());
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
     * correctness-based delegation and shipped wholesale to Lucene — even under a plain AND where
        String[] fieldNames,
                case AND:
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
        // 1 combined performance (Referer AND URL) = 1 DelegatedExpression
        RexNode eq1 = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, ref, rexBuilder.makeLiteral(1, intType, true));
            rexBuilder.makeCall(
     */  
        var r = runCombining(or(makeAnd(matchPhrase("hello"), fuzzy("wrld"), wildcard("h*llo")), amountEquals(200)));
            stripped.contains(DelegatedPredicateFunction.NAME)  
                map.put(ScalarFunction.FUZZY, serializer);  
        assertEquals(SqlKind.OR, middleOr.getKind());
            @Override
     * alter the coordinator-side conversion path.  
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);
        // it's reclassified to correctness and ships to the peer, fusing with same-backend siblings.
 * Tests for {@link FragmentConversionDriver} — verifies annotations are stripped  
        assertTrue("Combined should contain MATCH_PHRASE", combinedStr.contains("MATCH_PHRASE"));
            @Override
        RelNode project = LogicalProject.create(  
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        );  
                return Set.of(DelegationType.FILTER);
        RecordingConvertor dfConvertor = new RecordingConvertor();
import java.util.List;
    public void testDeepFlatten_alreadyFlatUnchanged() {
            if (found != null) return found;
     * consultation. Asserts one delegated entry, CONJUNCTIVE shape, and that the original  
        SqlKind.OTHER_FUNCTION,  
    /** Performance-delegated predicate WITH serializer gets combined with correctness-delegated. */
                return map;
    private void assertDelegationResult(
        RecordingConvertor convertor = new RecordingConvertor();  
        assertEquals("Binary join → exactly two child stages", 2, dag.rootStage().getChildStages().size());  
    // hence it's not in this set. AnnotatedPredicate and AnnotatedProjectExpression
        // Verify the stripped plan still has AND (placeholder + native)  
        );
        assertEquals(1, r.plan.delegatedExpressions().size());  
            assertNotNull(child.getPlanAlternatives().getFirst().convertedBytes());
    }
        MockLuceneBackend lucene = new MockLuceneBackend() {
        MockLuceneBackend lucene = new MockLuceneBackend() {
            ),
        assertTrue(RexUtil.isFlat(flat));  
                    return describeSubtree(subtree).getBytes(StandardCharsets.UTF_8);
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();
            public FragmentConvertor getFragmentConvertor() {  
    public void testNotCorrectnessDelegation() {
        RexNode flatInput = makeAnd(eqA, or(eqA, eqB));
                "Referer",  
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),
        );  
        assertFalse("Should NOT have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));
            Map.of(
        MockDataFusionBackend df = new MockDataFusionBackend() {
        RelNode cboOutput = runPlanner(having, context);
import org.apache.calcite.rel.core.AggregateCall;
        // two inputs are StageInputScan leaves — that's the shape Isthmus consumes natively.
            List.of(1),  
        QueryDAG scanDag = buildAndConvert(1, stubScan(mockTable("test_index", "status", "size")), scanConvertor);
            @Override
     *   - field 1 = message  (keyword, indexed) — DUAL-VIABLE for full-text + DataFusion.
     * EQUALS-on-int is NOT a Lucene cap in prod even when the field has BKD points.
            "count",
        for (Stage child : dag.rootStage().getChildStages()) {  
            callCount++;  
        StagePlan plan = stage.getPlanAlternatives().getFirst();
     * match(Title,'ru') OR (Referer='google' AND URL='US' AND GoodEvent=1)
        assertEquals("Correctness and performance delegated stay separate", 2, plan.delegatedExpressions().size());  
        RecordingConvertor convertor = new RecordingConvertor();  
    /**  
    }
            @Override
            ),
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
     * Uses 3 fields: message(keyword,indexed), amount(int,NOT indexed), count(int,NOT indexed).
        // With DelegatedSubtreeConvertor, same-backend predicates under AND are combined into 1  
                    List<String> children = new ArrayList<>();
            1,  
            "cnt"
            @Override  
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);
        var r = runCombining(or(makeAnd(matchPhrase("hello"), fuzzy("wrld")), makeAnd(wildcard("h*llo"), regexp("h.llo"))));  
    /** Performance-delegated predicate without serializer stays native (not combined). */
                return Set.of(DelegationType.FILTER);  
            @Override
     *   <li>{@code convertFinalAggFragment(LogicalJoin(StageInputScan, StageInputScan))} called  
            condition
            rexBuilder.makeInputRef(intType, 0),
        OperandTypes.ANY,
        };  
        return buildDelegationDag(
        LOGGER.info("QueryDAG after conversion:\n{}", dag);  
     * failed to apply the filter, and returned every row (ClickBench: 99,997,497 vs. the correct  
        assertFalse("precondition: tree is not flat", RexUtil.isFlat(nested));  
            public FragmentConvertor getFragmentConvertor() {
        SqlKind.OTHER_FUNCTION,
    );  
        RecordingConvertor dfConvertor = new RecordingConvertor();  
            -1,
     * NOT tag='hello' — Calcite normalizes to tag!='hello' (NOT_EQUALS).
        assertShardHasPartialAggInstruction(dag, "COUNT with filter (delegation path)");  
        String strippedPlan = RelOptUtil.toString(dfConvertor.shardScanFragment);
            protected Set<DelegationType> acceptedDelegations() {
        assertEquals(1, r.plan.delegatedExpressions().size());
            "s"
        return count;  
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());
        List<AnalyticsSearchBackendPlugin> backends = List.of(df, lucene);
            new String[] { "tag", "message" },
        assertTrue("Should have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));  
     * over two arms, each arm being {@code Sort ← Project ← Aggregate ← Scan} of the same
                return caps;  
            { "OR(EQUALS-perf, EQUALS-perf2)", or(eqPerf, eqPerf2), new int[] { 1, 1, 0 } },
        Map<String, Map<String, Object>> fields = Map.of("message", Map.of("type", "keyword", "index", true));
            SqlStdOperatorTable.EQUALS,
            2,
    }
     * EQUALS-perf)}. Previously the combiner emitted {@code OR(delegated_predicate(matchId),  
        assertEquals("Mixed: Lucene combined into 1 expression", 1, plan.delegatedExpressions().size());
        assertEquals(2, ((RexCall) flat).getOperands().size());
        assertTrue("Recorded reduce fragment must be rooted at a LogicalJoin (got:\n" + recorded + ")", recorded.contains("LogicalJoin"));
        );
            1,
        // All 4 Lucene predicates combined into 1, native amount=200 stays separate
        // We use a minimal cluster + scan to avoid driving the full advisor/rewriter chain —
            @Override
                ),
        LogicalFilter filter = LogicalFilter.create(  
    // ---- Plan shape verification tests (match verified DF logical plans) ----  
            ),
        };
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));  
     */
    public void testNotCorrectnessAndPerfDelegation() {  
        RexNode condition = rexBuilder.makeCall(
        RexNode condition = rexBuilder.makeCall(
    );  
            protected Set<EngineCapability> supportedEngineCapabilities() {  
        // amount has index=false → no Lucene format → native-only.
        RelNode cboOutput = runPlanner(filter, context);
        assertShardScanConverted(convertor, dataNodeStage(dag));  
                return Set.of(DelegationType.FILTER);  
     * Both branches are gathered subtrees. Reduce-stage conversion must serialize the whole
     * Tree shape: INTERLEAVED (delegation under OR)  
    private static final Set<String> ANNOTATION_MARKERS = Set.of(  
     * Regression for the prod "all-docs" disjunction bug — 2-leaf {@code OR(MATCH-correctness,
                makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
        LOGGER.info("Marked+CBO:\n{}", RelOptUtil.toString(cboOutput));
            List.of("status", "size")  
            }
            expDelegatedPredicate,
            stubScan(mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR })),  
                makeEquals(2, SqlTypeName.INTEGER, 200),
        // Mirror production: the OR(=,=,=) is nested one level DOWN inside an AND, not at the  
            .filter(n -> n.type() == InstructionType.SETUP_SHARD_SCAN_WITH_DELEGATION)  
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
    private FilterTreeShape treeShapeOf(StagePlan plan) {  
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
    // Operator markers that carry annotations and must be stripped before isthmus conversion.
        int leftCols = broadcastScan.getRowType().getFieldCount();  
            }
        RelNode leftScan = stubScan(mockTable("test_index", "status", "size"));  
    /** AND(native, OR(delegated, NOT(delegated))) — nested boolean structure with delegation. */
            condition
    public void testDeepFlatten_removesNestedOrUnderNot() {
        RexNode condition = rexBuilder.makeCall(
            @Override
        // delegation is now decided purely by tree position.
            }
        };
        int expDelegatedPredicate,
    // because it carries no annotations and isthmus only reads its rowType + qualified name.
            public FragmentConvertor getFragmentConvertor() {
        MockDataFusionBackend df = new MockDataFusionBackend() {
    }
            IllegalStateException.class,
        );
            count++;  
        String combinedStr = new String(
        // 4 fields: Title(keyword,indexed), Referer(keyword,indexed), URL(keyword,indexed), GoodEvent(int,NOT indexed)  
     * LogicalFilter.create's recursive isFlat assertion fires. RelNodeUtils.deepFlatten walks the
        SqlTypeName[] fieldTypes,
            assertTrue(
            }  
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
        RelNode join = LogicalJoin.create(leftProject, rightSorted, List.of(), cond, Set.of(), JoinRelType.INNER);
     * </ol>
                "Stripped plan should not contain " + DelegatedPredicateFunction.NAME,
            agg,
            }  
                return Set.of(DelegationType.FILTER);  
            dfConvertor,
        boolean expectNativeEquals,
        RelOptTable left = mockTable(leftTable, "status", "size");  
    public void testAndCorrectnessAndMultiplePerfAndNative() {  
    private RexNode matchPhrase(String query) {
        FilterTreeShape expectedTreeShape
        RecordingConvertor dfConvertor = new RecordingConvertor();
        assertNotNull("convertedBytes must be set", stage.getPlanAlternatives().getFirst().convertedBytes());
            public FragmentConvertor getFragmentConvertor() {  
        StagePlan plan,  
                rexBuilder.makeLiteral("alpha")
            LogicalFilter.create(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
            Map.of("type", "keyword", "index", true),  
        );
        return LogicalUnion.create(List.of(arm1, arm2), true);
        assertTrue("Should have delegated_predicate", strippedPlan.contains(DelegatedPredicateFunction.NAME));
            protected Set<DelegationType> acceptedDelegations() {
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(r.plan));  
                Map.of("type", "keyword", "index", true),
     * emits a shape that doesn't reduce cleanly to {@code LogicalJoin(SIS, SIS)} here, the test
        PlanForker.forkAll(dag, context.getCapabilityRegistry());  
            public org.opensearch.analytics.spi.FragmentConvertor getFragmentConvertor() {
                10
        FragmentConversionDriver.convertAll(dag, context.getCapabilityRegistry());  
                Set<EngineCapability> caps = new java.util.HashSet<>(super.supportedEngineCapabilities());
                map.put(ScalarFunction.FUZZY, serializer);  
        assertEquals(FilterTreeShape.INTERLEAVED_BOOLEAN_EXPRESSION, treeShapeOf(plan));
            "treeShape must come from the WHERE (CONJUNCTIVE), not the HAVING (NO_DELEGATION)",  
import org.apache.calcite.sql.SqlFunctionCategory;  
        return rexBuilder.makeCall(SqlStdOperatorTable.NOT, op);  
            }
                map.put(ScalarFunction.WILDCARD, serializer);  
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
            @Override
                "delegatedPredicateCount matches delegatedExpressions size",  
            protected Set<DelegationType> supportedDelegations() {
            @Override
            Map.of("message", Map.of("type", "keyword", "index", true))  
     * one shipped expression; the plan carries delegation_possible (DataFusion prunes natively +
        StagePlan plan = leafStage(dag).getPlanAlternatives().getFirst();  
        RexNode ref = rexBuilder.makeInputRef(intType, 0);  
        RecordingConvertor dfConvertor = new RecordingConvertor();
    }
        RexNode ref = rexBuilder.makeInputRef(intType, 0);
            null,
            }
            dfConvertor,  
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
     * 28,313,573).
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0),
        LOGGER.info("Marked+CBO:\n{}", RelOptUtil.toString(cboOutput));
        assertTrue("Combined should contain FUZZY", combinedStr.contains("FUZZY"));
            { "OR(MATCH, EQUALS-perf)", or(match, eqPerf), new int[] { 1, 1, 0 } },  
            }  
        String strippedPlan = RelOptUtil.toString(ctx.dfConvertor.shardScanFragment);  
import java.util.HashMap;  
                    makeEquals(2, SqlTypeName.VARCHAR, "US"),
        var r = runCombining(or(makeAnd(matchPhrase("hello"), fuzzy("wrld")), amountEquals(200)));
            @Override
        var backends = List.<AnalyticsSearchBackendPlugin>of(df, lucene);
        LOGGER.info("Plan (OR correctness with perf+native):\n{}", strippedPlan);
        MockDataFusionBackend df = new MockDataFusionBackend() {
            SqlStdOperatorTable.COUNT,
            { "OR(NOT(MATCH), EQUALS-perf)", or(notMatch, eqPerf), new int[] { 1, 1, 0 } },
                return Set.of(DelegationType.FILTER);  
        assertEquals(1, r.plan.delegatedExpressions().size());
    }
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), false),  
     */
                "GoodEvent",
    public void testCombine_OrOfTwoAndGroupsPureLucene() {
                    // Walk the subtree and produce a descriptive string for test assertions
        MockDataFusionBackend df = new MockDataFusionBackend() {
        assertEquals(2, plan.delegatedExpressions().size());
        assertNotNull("join stage alternative must have convertedBytes", joinStage.getPlanAlternatives().getFirst().convertedBytes());
    // Stripping it to LogicalTableScan would silently drop QTF's overrideRowType (helper cols
package org.opensearch.analytics.planner.dag;
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
        );
     */
            Map.of(
                makeFullTextCall(MATCH_PHRASE_FUNCTION, 0, "ru"),
            SqlStdOperatorTable.EQUALS,

    /**
 * SPDX-License-Identifier: Apache-2.0
     */
                return aggCaps(
    private OpenSearchAggregate runAggregate(int shardCount, AggregateCall aggCall) {
        OpenSearchAggregate finalAgg = (OpenSearchAggregate) unwrapRootReducer(result);
    public void testAggregateOnFilteredScan() {
     * through filter→aggregate at every level.
        assertPipelineViableBackends(
    public void testNoSplitOnSingleShard() {
        RelNode result = runPlanner(makeMultiCallAggregate(sumCall(), countCall()), context);
            for (RexNode operand : call.getOperands()) {
 * Tests for aggregate rule: per-call annotation, viable backends,
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            () -> runPlanner(makeMultiCallAggregate(sumCall(), stddevCall()), context)
        };
            () -> runPlanner(makeAggregate(sumCall()), context)
    }
        // Full pipeline: FinalAgg → ExchangeReducer → PartialAgg → Scan
            Set.of(MockDataFusionBackend.NAME)
import org.apache.calcite.plan.RelOptUtil;
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
    public void testCountDistinctOnSmallintWidensToInteger() {
        for (String backend : expectedBackends)
        AggregateCall countDistinct = AggregateCall.create(
            @Override
import org.apache.calcite.sql.fun.SqlBasicAggFunction;
            rebuilt.getAggregation()
            -1,
            agg,
            }
        );
            UnsupportedFunctionException.class,
    // ---- Delegation ----
            @Override
        };
        // Field 1 must be a non-trivial expression (the cast); field 0 stays as a passthrough ref.
                sumCall()
        // OpenSearchAggregateReduceRule decomposes STDDEV_POP into SUM+COUNT wrapped in
        assertCallAnnotation(agg, 1, MockDataFusionBackend.NAME);
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
import org.opensearch.analytics.planner.rel.AggregateMode;
    // ---- Per-call annotation ----
     * Variation of testAggregateViableBackendsIntersection where Lucene also declares
            }
                    Map.of(AggregateFunction.SUM, Set.of(FieldType.INTEGER), AggregateFunction.COUNT, Set.of(FieldType.INTEGER))
        // The planner now emits a top-level ExchangeReducer to materialize the coord-side
        MockLuceneBackend luceneWithAgg = new MockLuceneBackend() {
            SqlStdOperatorTable.COUNT,
    public void testViableBackendsPopulated() {
                if (containsCast(operand)) return true;
        RelNode scan = stubScan(
        // OpenSearchProjectRule wraps scalar calls in AnnotatedProjectExpression, so we search
                return Set.of(DelegationType.AGGREGATE);
        };
            List.of(OpenSearchAggregate.class, OpenSearchTableScan.class),
            protected Set<AggregateCapability> aggregateCapabilities() {
        RelNode result = runPlanner(makeAggregate(scan, countDistinct), defaultContext(1));
            }
    public void testMixedPerCallViableBackends() {
        AggregateCall rebuilt = agg.getAggCallList().get(0);
        RelDataType nullableBigint = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        );
        OpenSearchAggregate agg = runAggregate(1, sumCall());
                return aggCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), Map.of(AggregateFunction.SUM, Set.of(FieldType.INTEGER)));
    // ---- Error cases ----
import org.opensearch.analytics.spi.AggregateCapability;
            protected Set<DelegationType> acceptedDelegations() {
import org.opensearch.analytics.planner.rel.OpenSearchProject;
            scan,
        // EXECUTION(SINGLETON) requirement. Peel it off for aggregate-centric assertions.
            List.of(1),
            defaultContext(1)
        );
    /**
import org.opensearch.analytics.spi.FieldType;
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(noAggFunctions));
        assertPipelineViableBackends(
        assertPipelineViableBackends(
     * the replacement's row type to the original's.
    }
        for (int i = 0; i < agg.getAggCallList().size(); i++) {
            List.of(OpenSearchAggregate.class, OpenSearchExchangeReducer.class, OpenSearchAggregate.class, OpenSearchTableScan.class),
        assertPipelineViableBackends(
        return AggregateCall.create(
     */
        PlannerContext context = buildContextWithExplicitStorage(1, duplicatedIntFields(), List.of(DATAFUSION, lucenePartialAgg));
    public void testCountDistinctRewrittenToApproxCountDistinct() {
                    Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT),
        assertTrue("Plan must contain CAST to widen SMALLINT to INTEGER", plan.contains("CAST") && plan.contains("INTEGER"));
import org.apache.calcite.rel.core.AggregateCall;
        AggregateCall rebuilt = agg.getAggCallList().get(0);
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
 * this file be licensed under the Apache-2.0 license or a
    }
        );
import java.util.Map;
     * {@code "APPROX_COUNT_DISTINCT"} but not the Calcite stdop, returning a NULLABLE BIGINT —
        assertEquals(1, agg.getAggCallList().size());
        assertEquals(AggregateMode.SINGLE, agg.getMode());
        );
     * Aggregate(Filter(Scan)) — most common OLAP shape. Verifies annotation propagation
        String plan = RelOptUtil.toString(result);
import java.util.Set;
            result,
        RelNode unwrapped = unwrapRootReducer(result);
        // DF declares only COUNT — can't satisfy STDDEV_POP's reduction (needs SUM(x) and
            protected Set<DelegationType> supportedDelegations() {
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
            List.of(OpenSearchAggregate.class, OpenSearchTableScan.class),
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,
            }
    }
            SqlStdOperatorTable.COUNT,
 * The OpenSearch Contributors require contributions made to
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(dfWithDelegation, luceneAccepting));
import org.opensearch.analytics.spi.ScanCapability;
                return Set.of();
        assertEquals("COUNT viable for DF only (Lucene not declared)", 1, agg.getCallAnnotations().get(1).getViableBackends().size());
            result,
            @Override
            @Override
import org.apache.calcite.sql.SqlAggFunction;
        assertNotNull("AggregateCall must have annotation", annotation);
    public void testSplitOnMultiShard() {
        // Project preserves the original nullable BIGINT for the aggregated column.
        assertEquals(AggregateMode.PARTIAL, partialAgg.getMode());
     */
        MockDataFusionBackend dfWithDelegation = new MockDataFusionBackend() {
        return false;
        UnsupportedFunctionException exception = expectThrows(
        assertCallAnnotation(agg, 0, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
        MockLuceneBackend luceneWithScanAndAgg = new MockLuceneBackend() {
        };
            "Inner node must be OpenSearchAggregate, got " + innerAgg.getClass().getSimpleName(),
        AggregateCall countDistinct = AggregateCall.create(
            List.of(OpenSearchProject.class, OpenSearchAggregate.class, OpenSearchProject.class, OpenSearchTableScan.class),
        assertSame(
        };
        assertEquals(AggregateMode.FINAL, finalAgg.getMode());
            false,
        if (result instanceof org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer er) {
            protected Set<AggregateCapability> aggregateCapabilities() {
        OpenSearchAggregate agg = runAggregate(1, sumCall());
        };
                    Map.of(AggregateFunction.COUNT, Set.of(FieldType.INTEGER))
            List.of(OpenSearchAggregate.class, OpenSearchTableScan.class),
    }
            List.of(1),
        // recursively for a CAST node.
        assertPipelineViableBackends(
    }
            // No acceptedDelegations() override → delegation is refused.
            true,
        );
            OperandTypes.ANY
 *
            result,
        assertTrue(exception.getMessage().contains("is not currently supported"));
        );
import org.apache.calcite.sql.type.OperandTypes;
        assertCallAnnotation(agg, 0, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
        );
        );
            makeAggregate(
            scan,
    // ---- Helpers ----
    // ---- Split behavior ----
            Set.of(MockDataFusionBackend.NAME)
        return AggregateCall.create(
            "dc"
            UnsupportedFunctionException.class,
            mockTable("test_index", new String[] { "status", "size" }, new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.SMALLINT })
        RelNode result = runPlanner(
        MockLuceneBackend lucenePartialAgg = new MockLuceneBackend() {
    public void testPerCallAnnotation() {
                return aggCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), Map.of(AggregateFunction.SUM, Set.of(FieldType.INTEGER)));
            @Override
    }
                return aggCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), Map.of(AggregateFunction.SUM, Set.of(FieldType.INTEGER)));
    }
            agg.getViableBackends().contains(MockLuceneBackend.NAME)
            "cnt"
    public void testPplDistinctCountApproxUdfRewrittenWithCastProject() {
            }
     * scan capability — both backends viable for scan AND agg → operator-level includes both.
    /**
public class AggregateRuleTests extends BasePlannerRulesTests {
        OpenSearchAggregate agg = (OpenSearchAggregate) unwrapRootReducer(result);
            -1,
    private void assertCallAnnotation(OpenSearchAggregate agg, int callIndex, String... expectedBackends) {
        );
 */
        RelNode result = runPlanner(makeMultiCallAggregate(sumCall(), stddevCall()), context);
        }
    /**
     * predicate excludes the stdop, so no Project wrap is added and the result is a plain
            result = er.getInput();
            "APPROX_COUNT_DISTINCT",
            ReturnTypes.BIGINT_FORCE_NULLABLE,
            unwrapped instanceof OpenSearchProject
    // ---- Composed pipeline shapes ----
import java.util.List;
    public void testAggregateErrorsWithoutDelegation() {
        );
    // ---- Mixed per-call viable backends ----
            }
            result,
            Set.of(MockDataFusionBackend.NAME)
import org.apache.calcite.rel.RelNode;
            result,
     */
        RelNode result = runPlanner(makeAggregate(pplApprox), defaultContext(1));
            @Override
        assertEquals("SUM viable for both backends", 2, agg.getCallAnnotations().get(0).getViableBackends().size());
        RelNode innerAgg = RelNodeUtils.unwrapHep(project.getInput());
        PlannerContext context = buildContextWithExplicitStorage(1, duplicatedIntFields(), List.of(DATAFUSION, luceneWithAgg));
        assertFalse(
        );
            List.of(OpenSearchAggregate.class, OpenSearchFilter.class, OpenSearchTableScan.class),
        OpenSearchAggregate agg = runAggregate(1, countDistinct);
            agg,
    }
            @Override
                makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),
 * compatible open source license.
                );
        };
                    Map.of(AggregateFunction.STDDEV_POP, Set.of(FieldType.INTEGER))
                return Set.of(new ScanCapability.DocValues(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), Set.of(FieldType.INTEGER)));
        );
            "Lucene not viable at operator level — can handle SUM but not COUNT",
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
}
            List.of(OpenSearchAggregate.class, OpenSearchTableScan.class),
                return aggCaps(
    }
        }
     * pins the new aggCall's type to its operator's inferred type while {@code HepPlanner} pins
        assertTrue(
            AggregateCallAnnotation annotation = agg.getCallAnnotations().get(i);
    public void testAggregateViableWithDelegation() {
        assertTrue(exception.getMessage().contains("is not currently supported"));
     * is rewritten to {@code SqlStdOperatorTable.APPROX_COUNT_DISTINCT} (which infers BIGINT
            }
        RelDataType dcaType = project.getRowType().getFieldList().get(1).getType();
    }
        assertPipelineViableBackends(
    /** Recursive search for a CAST node — Project rule wraps scalar calls in AnnotatedProjectExpression. */
            @Override
    }
     */
        SqlAggFunction pplUdfMarker = SqlBasicAggFunction.create(
     * PPL's {@code distinct_count_approx} UDAF marker — a {@code SqlAggFunction} named
            true,
        );
import org.apache.calcite.sql.type.ReturnTypes;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    }
    }
    }
            result,
            assertFalse("Annotation viableBackends must not be empty", annotation.getViableBackends().isEmpty());
        assertCallAnnotation(agg, 0, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        );
            "Inner aggregate must use SqlStdOperatorTable.APPROX_COUNT_DISTINCT",
        AggregateCallAnnotation annotation = agg.getCallAnnotations().get(callIndex);
        assertFalse(agg.getViableBackends().contains(MockLuceneBackend.NAME));
    private static boolean containsCast(RexNode node) {
     * COUNT(DISTINCT smallint_col) inserts a widening CAST(col AS INTEGER) below the aggregate
            assertNotNull("Every AggregateCall must have an annotation", annotation);
            false,
        RelNode result = unwrapExchange(runPlanner(makeAggregate(sumCall()), defaultContext(5)));
                );
            }
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
    /**
            innerAgg instanceof OpenSearchAggregate
        assertFalse("isDistinct must be cleared on the rewritten APPROX_COUNT_DISTINCT call", rebuilt.isDistinct());
     * so DataFusion uses HLL (Binary state) instead of bitmap (List state).
        assertPipelineViableBackends(
        // Project(sqrt) above / Project(squared-inputs) below the Aggregate.
     * Exact {@code COUNT(DISTINCT x)} is rewritten to {@code APPROX_COUNT_DISTINCT(x)} on the
            assertTrue(annotation.getViableBackends().contains(MockDataFusionBackend.NAME));
        // Per-call annotation includes both — Lucene is viable for SUM on this field
package org.opensearch.analytics.planner;
            Set.of(MockDataFusionBackend.NAME)
            Set.of(MockDataFusionBackend.NAME)
     * NOT NULL) and wrapped in a casting {@link OpenSearchProject} that restores the original
        assertSame(SqlStdOperatorTable.APPROX_COUNT_DISTINCT, rebuilt.getAggregation());
        OpenSearchAggregate agg = (OpenSearchAggregate) unwrapRootReducer(result);
        AggregateCall call = agg.getAggCallList().get(0);
            Set.of(MockDataFusionBackend.NAME)
        MockDataFusionBackend dfNoSum = new MockDataFusionBackend() {
            }
        RelNode result = runPlanner(makeAggregate(aggCall), defaultContext(shardCount));
 * split behavior, and delegation.
import org.apache.calcite.sql.SqlKind;
            stubScan(mockTable("test_index", "status", "size")),
    private PlannerContext defaultContext(int shardCount) {
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
                return aggCaps(
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        return (OpenSearchAggregate) unwrapRootReducer(result);
            @Override
    public void testStdopApproxCountDistinctNotRewritten() {
            "stddev"
import org.opensearch.analytics.spi.AggregateFunction;
    }
            1,
            List.of(OpenSearchAggregate.class, OpenSearchTableScan.class),
            }
                return Set.of(DelegationType.AGGREGATE);
                    Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT),
                return aggCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), Map.of(AggregateFunction.SUM, Set.of(FieldType.INTEGER)));
        );
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
            @Override
            1,
    public void testAggregateViableBackendsIntersection() {
        assertEquals("Project must restore original nullable BIGINT", nullableBigint, dcaType);
            ),
    }
            Set.of(MockDataFusionBackend.NAME)
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
import org.opensearch.analytics.planner.rel.AggregateCallAnnotation;
        );
            List.of(1),
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
            SqlKind.OTHER_FUNCTION,
            protected Set<AggregateCapability> aggregateCapabilities() {
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
     * is no longer marked {@code isDistinct}, so it routes through the APPROXIMATE
    /**
            }
        RelNode result = runPlanner(makeAggregate(sumCall()), context);
        OpenSearchAggregate agg = (OpenSearchAggregate) innerAgg;
import org.apache.calcite.rex.RexCall;
        );
            protected Set<AggregateCapability> aggregateCapabilities() {
     * nullable row type. The Project bridge is required because {@code Aggregate.typeMatchesInferred}
        assertTrue(
        if (node.getKind() == SqlKind.CAST) return true;
        RelNode result = runPlanner(makeAggregate(sumCall()), context);
        return buildContext("parquet", shardCount, intFields());
import org.opensearch.analytics.spi.DelegationType;
        );
     * single-stage gather path rather than the additive partial/final split.
        AggregateCall pplApprox = AggregateCall.create(pplUdfMarker, /* distinct */ false, List.of(1), -1, scan, nullableBigint, "dca");
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
            protected Set<ScanCapability> scanCapabilities() {
        OpenSearchAggregate agg = runAggregate(1, sumCall());
        OpenSearchAggregate agg = (OpenSearchAggregate) unwrapRootReducer(result);
            protected Set<AggregateCapability> aggregateCapabilities() {
import org.apache.calcite.rel.type.RelDataType;
/**
            "Expected OpenSearchProject(OpenSearchAggregate(...)) wrap, got " + unwrapped.getClass().getSimpleName(),
     * {@link OpenSearchAggregate}.
    }
                    Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT),
    /** Every agg call must have an annotation with non-empty viableBackends. */
        assertTrue("Project must contain a CAST to bridge nullability", containsCast(project.getProjects().get(1)));
        assertPipelineViableBackends(
    public void testAggregateViableBackendsIntersectionWithLuceneScan() {
     */
        assertTrue(agg.getViableBackends().contains(MockLuceneBackend.NAME));
    private AggregateCall stddevCall() {
        if (node instanceof RexCall call) {
            @Override
    public void testAggregateErrorsWhenNoBackendSupportsFunction() {
    }
import org.apache.calcite.sql.type.SqlTypeName;
            typeFactory.createSqlType(SqlTypeName.INTEGER),
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(dfNoSum, luceneWithSum));
        MockDataFusionBackend noAggFunctions = new MockDataFusionBackend() {
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        );
        MockLuceneBackend luceneAccepting = new MockLuceneBackend() {
        PlannerContext context = buildContextWithExplicitStorage(1, duplicatedIntFields(), List.of(DATAFUSION, luceneWithScanAndAgg));
    }
    private AggregateCall countCall() {
     * Stdop {@code APPROX_COUNT_DISTINCT} (already canonical) must not be rewritten — the rule's
        OpenSearchAggregate partialAgg = (OpenSearchAggregate) finalAgg.getInputs().get(0).getInputs().get(0);
        UnsupportedFunctionException exception = expectThrows(
import org.apache.calcite.rex.RexNode;
            assertTrue("Annotation must contain backend " + backend, annotation.getViableBackends().contains(backend));
        // SUM(x*x)) on its own. Lucene has SUM but refuses delegation.
            Set.of(MockDataFusionBackend.NAME, MockLuceneBackend.NAME)
     * analytics-engine route — the resulting aggregate uses the standard approximate operator and
        );
            protected Set<AggregateCapability> aggregateCapabilities() {
            "dc"
        logger.info("Full plan with SMALLINT dc:\n{}", plan);
    }
            SqlStdOperatorTable.STDDEV_POP,
        assertTrue("Expected OpenSearchAggregate, got " + result.getClass().getSimpleName(), result instanceof OpenSearchAggregate);
            protected Set<AggregateCapability> aggregateCapabilities() {
        assertSame(SqlStdOperatorTable.APPROX_COUNT_DISTINCT, call.getAggregation());
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
            SqlStdOperatorTable.COUNT,
            }
/*
    // ---- Operator resolution ----
            protected Set<AggregateCapability> aggregateCapabilities() {
            List.of(1),
        }
        MockLuceneBackend luceneWithSum = new MockLuceneBackend() {
                );
        };
 */
            stubScan(mockTable("test_index", "status", "size")),
        OpenSearchAggregate agg = runAggregate(1, approxCountDistinctCall(scan));
        OpenSearchProject project = (OpenSearchProject) unwrapped;
        assertFalse("isDistinct must be cleared on the rewritten call", rebuilt.isDistinct());

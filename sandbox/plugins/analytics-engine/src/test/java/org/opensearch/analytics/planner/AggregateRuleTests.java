    }  
                makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200)),  
        assertPipelineViableBackends(
                );
            Set.of(MockDataFusionBackend.NAME)
     * Exact {@code COUNT(DISTINCT x)} is rewritten to {@code APPROX_COUNT_DISTINCT(x)} on the
        OpenSearchAggregate finalAgg = (OpenSearchAggregate) unwrapRootReducer(result);
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
                return Set.of();
            true,
            makeAggregate(
            List.of(OpenSearchAggregate.class, OpenSearchTableScan.class),  
    }
import org.opensearch.analytics.planner.rel.AggregateMode;  
        logger.info("Plan:\n{}", RelOptUtil.toString(result));  
     * scan capability — both backends viable for scan AND agg → operator-level includes both.  
                return aggCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), Map.of(AggregateFunction.SUM, Set.of(FieldType.INTEGER)));  
    public void testAggregateErrorsWithoutDelegation() {  
        RelNode result = runPlanner(makeAggregate(sumCall()), context);  
    public void testSplitOnMultiShard() {
        assertPipelineViableBackends(
    }  
        };  
        RelDataType dcaType = project.getRowType().getFieldList().get(1).getType();
}  
    }  
            @Override  
            SqlStdOperatorTable.COUNT,
import java.util.Set;
            @Override
                return aggCaps(  
        RelNode result = runPlanner(makeAggregate(sumCall()), context);  
        MockLuceneBackend luceneAccepting = new MockLuceneBackend() {
     * NOT NULL) and wrapped in a casting {@link OpenSearchProject} that restores the original
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
                return aggCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), Map.of(AggregateFunction.SUM, Set.of(FieldType.INTEGER)));
     * Variation of testAggregateViableBackendsIntersection where Lucene also declares
    }
        assertTrue(exception.getMessage().contains("is not currently supported"));  
        };
            List.of(OpenSearchAggregate.class, OpenSearchTableScan.class),  
        AggregateCallAnnotation annotation = agg.getCallAnnotations().get(callIndex);
            true,
        RelNode result = runPlanner(makeMultiCallAggregate(sumCall(), countCall()), context);
    // ---- Error cases ----
            }
        // SUM(x*x)) on its own. Lucene has SUM but refuses delegation.
        assertNotNull("AggregateCall must have annotation", annotation);
        assertEquals(AggregateMode.FINAL, finalAgg.getMode());
        logger.info("Plan:\n{}", RelOptUtil.toString(result));  
    }  
            () -> runPlanner(makeAggregate(sumCall()), context)
 * SPDX-License-Identifier: Apache-2.0
    /**
        AggregateCall call = agg.getAggCallList().get(0);
        // Project(sqrt) above / Project(squared-inputs) below the Aggregate.
    // ---- Helpers ----  
        }
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,  
     * single-stage gather path rather than the additive partial/final split.
        assertCallAnnotation(agg, 0, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
            Set.of(MockDataFusionBackend.NAME)  
import org.opensearch.analytics.spi.FieldType;  
        );
        PlannerContext context = buildContextWithExplicitStorage(1, duplicatedIntFields(), List.of(DATAFUSION, luceneWithAgg));
        if (node.getKind() == SqlKind.CAST) return true;
    public void testAggregateViableBackendsIntersectionWithLuceneScan() {
        assertPipelineViableBackends(  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        assertTrue("Plan must contain CAST to widen SMALLINT to INTEGER", plan.contains("CAST") && plan.contains("INTEGER"));
        assertFalse(agg.getViableBackends().contains(MockLuceneBackend.NAME));
import org.apache.calcite.sql.fun.SqlBasicAggFunction;  
            assertFalse("Annotation viableBackends must not be empty", annotation.getViableBackends().isEmpty());  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        OpenSearchProject project = (OpenSearchProject) unwrapped;  
        PlannerContext context = buildContextWithExplicitStorage(1, duplicatedIntFields(), List.of(DATAFUSION, luceneWithScanAndAgg));
            @Override
    }  
     * Aggregate(Filter(Scan)) — most common OLAP shape. Verifies annotation propagation  
        assertPipelineViableBackends(
        logger.info("Plan:\n{}", RelOptUtil.toString(result));  
                    Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT),
        RelNode innerAgg = RelNodeUtils.unwrapHep(project.getInput());  
    private OpenSearchAggregate runAggregate(int shardCount, AggregateCall aggCall) {
        );
    public void testCountDistinctRewrittenToApproxCountDistinct() {  
    }  
import org.apache.calcite.plan.RelOptUtil;
        assertSame(SqlStdOperatorTable.APPROX_COUNT_DISTINCT, rebuilt.getAggregation());
     * is no longer marked {@code isDistinct}, so it routes through the APPROXIMATE  
                    Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT),  
            "dc"  
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
        AggregateCall countDistinct = AggregateCall.create(
                return Set.of(DelegationType.AGGREGATE);  
            }
    /**  
import org.opensearch.analytics.spi.DelegationType;
            typeFactory.createSqlType(SqlTypeName.INTEGER),  
                );  
    public void testPplDistinctCountApproxUdfRewrittenWithCastProject() {  
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(dfNoSum, luceneWithSum));
        return AggregateCall.create(  
    public void testMixedPerCallViableBackends() {  
    /**  
        assertFalse(
import org.apache.calcite.sql.type.ReturnTypes;  
            @Override
        assertCallAnnotation(agg, 1, MockDataFusionBackend.NAME);  
        assertSame(SqlStdOperatorTable.APPROX_COUNT_DISTINCT, call.getAggregation());
        OpenSearchAggregate partialAgg = (OpenSearchAggregate) finalAgg.getInputs().get(0).getInputs().get(0);  
        }
                sumCall()
        MockLuceneBackend luceneWithSum = new MockLuceneBackend() {  
            for (RexNode operand : call.getOperands()) {  
     * {@code "APPROX_COUNT_DISTINCT"} but not the Calcite stdop, returning a NULLABLE BIGINT —
 * Tests for aggregate rule: per-call annotation, viable backends,
        assertEquals("COUNT viable for DF only (Lucene not declared)", 1, agg.getCallAnnotations().get(1).getViableBackends().size());
        );
            List.of(OpenSearchAggregate.class, OpenSearchTableScan.class),  
            result,  
            List.of(OpenSearchProject.class, OpenSearchAggregate.class, OpenSearchProject.class, OpenSearchTableScan.class),
        );  
            protected Set<AggregateCapability> aggregateCapabilities() {
import org.apache.calcite.rel.type.RelDataType;
        assertCallAnnotation(agg, 0, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
import org.apache.calcite.rel.RelNode;
            ReturnTypes.BIGINT_FORCE_NULLABLE,
    // ---- Split behavior ----
            "Lucene not viable at operator level — can handle SUM but not COUNT",
        };
            innerAgg instanceof OpenSearchAggregate  
            List.of(OpenSearchAggregate.class, OpenSearchFilter.class, OpenSearchTableScan.class),
    }
            protected Set<DelegationType> supportedDelegations() {  
            SqlStdOperatorTable.STDDEV_POP,
        };
     * predicate excludes the stdop, so no Project wrap is added and the result is a plain
import org.apache.calcite.sql.type.SqlTypeName;
            UnsupportedFunctionException.class,  
    public void testViableBackendsPopulated() {
            List.of(OpenSearchAggregate.class, OpenSearchTableScan.class),
        // OpenSearchProjectRule wraps scalar calls in AnnotatedProjectExpression, so we search
    }
import org.apache.calcite.sql.SqlKind;
        RelNode unwrapped = unwrapRootReducer(result);
     * through filter→aggregate at every level.
    }
        OpenSearchAggregate agg = runAggregate(1, approxCountDistinctCall(scan));  
            protected Set<ScanCapability> scanCapabilities() {
            protected Set<AggregateCapability> aggregateCapabilities() {  
            "stddev"
 * compatible open source license.
            }
    }
            agg,
            List.of(1),  
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
        assertPipelineViableBackends(
            agg.getViableBackends().contains(MockLuceneBackend.NAME)  
        };  
                    Map.of(AggregateFunction.SUM, Set.of(FieldType.INTEGER), AggregateFunction.COUNT, Set.of(FieldType.INTEGER))
        };
        RelDataType nullableBigint = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
            }
        RelNode result = runPlanner(makeMultiCallAggregate(sumCall(), stddevCall()), context);
    /** Recursive search for a CAST node — Project rule wraps scalar calls in AnnotatedProjectExpression. */
            SqlStdOperatorTable.COUNT,  
        RelNode result = runPlanner(makeAggregate(scan, countDistinct), defaultContext(1));
import org.apache.calcite.rel.core.AggregateCall;  
            }  
            false,
    }  
            mockTable("test_index", new String[] { "status", "size" }, new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.SMALLINT })  
                return Set.of(DelegationType.AGGREGATE);
            "APPROX_COUNT_DISTINCT",
            // No acceptedDelegations() override → delegation is refused.
                    Map.of(AggregateFunction.STDDEV_POP, Set.of(FieldType.INTEGER))  
        // Project preserves the original nullable BIGINT for the aggregated column.
        // Field 1 must be a non-trivial expression (the cast); field 0 stays as a passthrough ref.
 */  
        logger.info("Plan:\n{}", RelOptUtil.toString(result));  
            }
    }  
    // ---- Mixed per-call viable backends ----
        MockLuceneBackend lucenePartialAgg = new MockLuceneBackend() {
            stubScan(mockTable("test_index", "status", "size")),
     */
        );
            SqlKind.OTHER_FUNCTION,  
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        );
            protected Set<AggregateCapability> aggregateCapabilities() {
        RelNode result = runPlanner(makeAggregate(pplApprox), defaultContext(1));
            "dc"  
    public void testPerCallAnnotation() {
        assertTrue(exception.getMessage().contains("is not currently supported"));
import org.apache.calcite.sql.type.OperandTypes;
    private PlannerContext defaultContext(int shardCount) {
 *
        MockLuceneBackend luceneWithAgg = new MockLuceneBackend() {
            protected Set<AggregateCapability> aggregateCapabilities() {
    }
        OpenSearchAggregate agg = (OpenSearchAggregate) unwrapRootReducer(result);  
            () -> runPlanner(makeMultiCallAggregate(sumCall(), stddevCall()), context)
        assertFalse("isDistinct must be cleared on the rewritten APPROX_COUNT_DISTINCT call", rebuilt.isDistinct());  
import org.opensearch.analytics.planner.rel.AggregateCallAnnotation;
            Set.of(MockDataFusionBackend.NAME)
     * COUNT(DISTINCT smallint_col) inserts a widening CAST(col AS INTEGER) below the aggregate
     * Stdop {@code APPROX_COUNT_DISTINCT} (already canonical) must not be rewritten — the rule's  
        };
     * PPL's {@code distinct_count_approx} UDAF marker — a {@code SqlAggFunction} named
    public void testCountDistinctOnSmallintWidensToInteger() {
            stubScan(mockTable("test_index", "status", "size")),
        RelNode result = unwrapExchange(runPlanner(makeAggregate(sumCall()), defaultContext(5)));
        OpenSearchAggregate agg = runAggregate(1, sumCall());
        assertSame(
            @Override
            1,
     * analytics-engine route — the resulting aggregate uses the standard approximate operator and
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(dfWithDelegation, luceneAccepting));  
        );
        for (String backend : expectedBackends)  
            @Override  
        assertCallAnnotation(agg, 0, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);  
        AggregateCall countDistinct = AggregateCall.create(
import org.opensearch.analytics.spi.AggregateFunction;
        );
        assertEquals(1, agg.getAggCallList().size());  
    // ---- Composed pipeline shapes ----  
            typeFactory.createSqlType(SqlTypeName.BIGINT),  
        );
        assertEquals("Project must restore original nullable BIGINT", nullableBigint, dcaType);  
        MockLuceneBackend luceneWithScanAndAgg = new MockLuceneBackend() {  
        assertTrue("Project must contain a CAST to bridge nullability", containsCast(project.getProjects().get(1)));
        AggregateCall rebuilt = agg.getAggCallList().get(0);
        );
import org.opensearch.analytics.spi.ScanCapability;
        AggregateCall pplApprox = AggregateCall.create(pplUdfMarker, /* distinct */ false, List.of(1), -1, scan, nullableBigint, "dca");  
            OperandTypes.ANY
            @Override
        );  
        );  
    }
        SqlAggFunction pplUdfMarker = SqlBasicAggFunction.create(
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
            protected Set<DelegationType> acceptedDelegations() {
    }
            "Inner node must be OpenSearchAggregate, got " + innerAgg.getClass().getSimpleName(),
        // Full pipeline: FinalAgg → ExchangeReducer → PartialAgg → Scan
                return aggCaps(
    public void testAggregateOnFilteredScan() {  
        if (result instanceof org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer er) {  
import org.apache.calcite.rex.RexCall;
            result,
        RelNode scan = stubScan(
            AggregateCallAnnotation annotation = agg.getCallAnnotations().get(i);
            "Inner aggregate must use SqlStdOperatorTable.APPROX_COUNT_DISTINCT",
     * nullable row type. The Project bridge is required because {@code Aggregate.typeMatchesInferred}
    public void testAggregateErrorsWhenNoBackendSupportsFunction() {
        logger.info("Plan:\n{}", RelOptUtil.toString(result));
    private static boolean containsCast(RexNode node) {  
    public void testAggregateViableBackendsIntersection() {
            agg,
            }
    public void testAggregateViableWithDelegation() {
     * so DataFusion uses HLL (Binary state) instead of bitmap (List state).
     * is rewritten to {@code SqlStdOperatorTable.APPROX_COUNT_DISTINCT} (which infers BIGINT  
            @Override  
        assertTrue(
    }
/*  
            result = er.getInput();
            Set.of(MockDataFusionBackend.NAME)
        PlannerContext context = buildContext("parquet", 1, intFields(), List.of(noAggFunctions));
import java.util.List;  
            1,
            protected Set<AggregateCapability> aggregateCapabilities() {  
import org.opensearch.analytics.spi.AggregateCapability;  
        );
    private AggregateCall stddevCall() {
        return false;
     * {@link OpenSearchAggregate}.
        for (int i = 0; i < agg.getAggCallList().size(); i++) {  
        assertEquals(AggregateMode.PARTIAL, partialAgg.getMode());
        assertEquals(AggregateMode.SINGLE, agg.getMode());  
        logger.info("Full plan with SMALLINT dc:\n{}", plan);
    /** Every agg call must have an annotation with non-empty viableBackends. */  
        RelNode result = runPlanner(
        OpenSearchAggregate agg = (OpenSearchAggregate) unwrapRootReducer(result);
            scan,
            "cnt"
import org.opensearch.analytics.planner.rel.OpenSearchFilter;  
        );
        AggregateCall rebuilt = agg.getAggCallList().get(0);  
        );
            result,
        MockDataFusionBackend dfNoSum = new MockDataFusionBackend() {  
    /**
            }  
        );
        RelNode result = runPlanner(makeAggregate(aggCall), defaultContext(shardCount));
     */  
            @Override
        if (node instanceof RexCall call) {
    }
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            List.of(OpenSearchAggregate.class, OpenSearchExchangeReducer.class, OpenSearchAggregate.class, OpenSearchTableScan.class),
                return aggCaps(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), Map.of(AggregateFunction.SUM, Set.of(FieldType.INTEGER)));
    // ---- Operator resolution ----
            assertNotNull("Every AggregateCall must have an annotation", annotation);
        );  
    // ---- Per-call annotation ----
            Set.of(MockDataFusionBackend.NAME, MockLuceneBackend.NAME)
    private AggregateCall countCall() {
        return (OpenSearchAggregate) unwrapRootReducer(result);
        UnsupportedFunctionException exception = expectThrows(
            }  
            protected Set<AggregateCapability> aggregateCapabilities() {
            List.of(1),  
import org.apache.calcite.rex.RexNode;  
        OpenSearchAggregate agg = runAggregate(1, countDistinct);
            "Expected OpenSearchProject(OpenSearchAggregate(...)) wrap, got " + unwrapped.getClass().getSimpleName(),  
        );  
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
            @Override
/**
        PlannerContext context = buildContextWithExplicitStorage(1, duplicatedIntFields(), List.of(DATAFUSION, lucenePartialAgg));
            UnsupportedFunctionException.class,
            Set.of(MockDataFusionBackend.NAME)
    /**  
     * pins the new aggCall's type to its operator's inferred type while {@code HepPlanner} pins  
        assertPipelineViableBackends(
            }
            }
        // Per-call annotation includes both — Lucene is viable for SUM on this field  
            }  
        return AggregateCall.create(  
        MockDataFusionBackend dfWithDelegation = new MockDataFusionBackend() {
    /**
        assertTrue(agg.getViableBackends().contains(MockLuceneBackend.NAME));
                if (containsCast(operand)) return true;
            protected Set<AggregateCapability> aggregateCapabilities() {
            assertTrue(annotation.getViableBackends().contains(MockDataFusionBackend.NAME));
            protected Set<AggregateCapability> aggregateCapabilities() {
        );  
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            result,  
        assertPipelineViableBackends(
 * this file be licensed under the Apache-2.0 license or a
        OpenSearchAggregate agg = runAggregate(1, sumCall());
public class AggregateRuleTests extends BasePlannerRulesTests {
    public void testNoSplitOnSingleShard() {
            false,
        // recursively for a CAST node.  
     */  
            List.of(OpenSearchAggregate.class, OpenSearchTableScan.class),
    public void testStdopApproxCountDistinctNotRewritten() {
import org.opensearch.analytics.planner.rel.OpenSearchProject;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    // ---- Delegation ----
        OpenSearchAggregate agg = (OpenSearchAggregate) unwrapRootReducer(result);
                );
            ),
        UnsupportedFunctionException exception = expectThrows(  
        assertEquals("SUM viable for both backends", 2, agg.getCallAnnotations().get(0).getViableBackends().size());
                return aggCaps(
                return aggCaps(Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT), Map.of(AggregateFunction.SUM, Set.of(FieldType.INTEGER)));
 * The OpenSearch Contributors require contributions made to  
        // The planner now emits a top-level ExchangeReducer to materialize the coord-side
            @Override  
                return Set.of(new ScanCapability.DocValues(Set.of(MockLuceneBackend.LUCENE_DATA_FORMAT), Set.of(FieldType.INTEGER)));  
        }  
        // EXECUTION(SINGLETON) requirement. Peel it off for aggregate-centric assertions.
            SqlStdOperatorTable.COUNT,  
     */
            List.of(1),
    }
        // OpenSearchAggregateReduceRule decomposes STDDEV_POP into SUM+COUNT wrapped in  
        assertTrue(
        MockDataFusionBackend noAggFunctions = new MockDataFusionBackend() {
        );
        OpenSearchAggregate agg = (OpenSearchAggregate) innerAgg;
            assertTrue("Annotation must contain backend " + backend, annotation.getViableBackends().contains(backend));
            defaultContext(1)  
        assertPipelineViableBackends(
import org.apache.calcite.sql.SqlAggFunction;
        String plan = RelOptUtil.toString(result);  
                    Set.of(MockDataFusionBackend.PARQUET_DATA_FORMAT),
        assertFalse("isDistinct must be cleared on the rewritten call", rebuilt.isDistinct());  
 */
            result,  
 * split behavior, and delegation.  
                    Map.of(AggregateFunction.COUNT, Set.of(FieldType.INTEGER))
     */
        // DF declares only COUNT — can't satisfy STDDEV_POP's reduction (needs SUM(x) and
            rebuilt.getAggregation()
        OpenSearchAggregate agg = runAggregate(1, sumCall());  
        return buildContext("parquet", shardCount, intFields());  
        );
            Set.of(MockDataFusionBackend.NAME)
            List.of(1),
package org.opensearch.analytics.planner;
        };  
            -1,  
            scan,
            unwrapped instanceof OpenSearchProject
        assertTrue("Expected OpenSearchAggregate, got " + result.getClass().getSimpleName(), result instanceof OpenSearchAggregate);  
import java.util.Map;
    private void assertCallAnnotation(OpenSearchAggregate agg, int callIndex, String... expectedBackends) {  
            -1,  
    }
            Set.of(MockDataFusionBackend.NAME)
            result,  
     * the replacement's row type to the original's.
     */

            "dc"
        Map<Integer, List<RexLiteral>> extras = Map.of(0, List.of(ten));
        OpenSearchStageInputScan stageInput = new OpenSearchStageInputScan(
            List.of("mock-parquet"),
        assertNotSame("rewrite should return a new FINAL when literals were re-introduced", finalAgg, result);
     */
            List.of(),
import org.opensearch.analytics.spi.AggregateFunction;
     * input shape — the orchestrator's StageInputScan check should reject it and return the
            cluster,
public class DistributedAggregateRewriterTests extends BasePlannerRulesTests {
        );
 * {@link OpenSearchAggregate} trees by hand and asserts how
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        OpenSearchStageInputScan stageInput = new OpenSearchStageInputScan(
     * re-type the StageInputScan column to VARBINARY.
        OpenSearchExchangeReducer newReducer = (OpenSearchExchangeReducer) result.getInput(0);
    }
            List.of(0),
 * SPDX-License-Identifier: Apache-2.0
        // The exchange below FINAL must now wrap a StageInputScan whose 'dc' column is VARBINARY.
            "literal column name should follow the $lit_call prefix",
import org.apache.calcite.rel.core.AggregateCall;
        RelNode result = DistributedAggregateRewriter.rewrite(finalAgg);
        // Project has the original column plus the appended literal column.
        OpenSearchAggregate finalAgg = new OpenSearchAggregate(
            intermediateFields
        );
            Collections.singletonList(null)
     * input unchanged.
     * {@code 10}) on FINAL's {@code finalExtraLiteralArgs} stash. The transformer should
     * STATE_EXPANDING aggregates carry literal config args (e.g. {@code take(field, 10)}'s
            cluster,
            Map.of(),
    /**
/*
 * this file be licensed under the Apache-2.0 license or a
            stageInputType,
     */
     */
        RelDataType stageInputType = typeFactory.builder().add("take_state", stateType).build();
        return new OpenSearchAggregate(
    public void testExchangeTypeOverrideRetypesApproxCountDistinctSketch() {
import org.apache.calcite.rel.type.RelDataType;
    /** Small helper: classify a single SqlAggFunction via the SPI; null when no decomposition. */
 * The OpenSearch Contributors require contributions made to
        );
            ImmutableBitSet.of(0),
        );
        // FINAL's input should now be an OpenSearchProject (inserted by insertLiteralProject).
import org.apache.calcite.sql.SqlAggFunction;
    }
/**
     * Builds a FINAL aggregate over a plain scan (no exchange reducer). Used as a degenerate
        assertNotSame("rewrite should return a new FINAL when the exchange type was overridden", finalAgg, result);
        // Wrap an exchange reducer over a plain scan so the orchestrator's prefix check
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
 * compatible open source license.
 * {@link DistributedAggregateRewriter#rewrite} (and its transformer chain) reshape them.
        // (must have a StageInputScan beneath the reducer) fails — early exit, no work done.
        return fields.get(0);
        // One captured literal for call 0: integer 10.
            null,
import org.opensearch.analytics.planner.rel.AggregateMode;
            project.getRowType().getFieldList().get(1).getName().startsWith("$lit_call")
            Map.of(),
        AggregateFunction enumFn = AggregateFunction.fromSqlAggFunction(sqlFn);
            false,
        OpenSearchStageInputScan newStageInput = (OpenSearchStageInputScan) newReducer.getInput(0);
 * Direct-call unit tests for the post-Volcano rewrite path. Constructs FINAL
            List.of()
        OpenSearchExchangeReducer reducer = new OpenSearchExchangeReducer(cluster, cluster.traitSet(), stageInput, List.of("mock-parquet"));
        RelDataType declaredAggType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), false);
            false,
        List<IntermediateField> intermediateFields = List.of(classify(SqlStdOperatorTable.APPROX_COUNT_DISTINCT));
 *
import java.util.Collections;
        );
        List<IntermediateField> fields = enumFn.intermediateFields();
            List.of("mock-parquet"),
            org.apache.calcite.rel.RelCollations.EMPTY,
     * No StageInputScan, no decompositions, no literals → rewriter returns the same instance.
        assertTrue(
            List.of("mock-parquet"),
    public void testLiteralProjectInsertsCapturedLiterals() {
     * Verifies the orchestrator's fast-path early return.
            0,
            -1,
    public void testRewriteNoOpWhenNothingToAdapt() {
import org.apache.calcite.rel.RelNode;
    /**
            Map.of(),
            cluster,
    }
            List.of(sumCall),
        if (fields == null) return null;
        RelDataType retypedDc = newStageInput.getRowType().getFieldList().get(1).getType();
     * APPROX_COUNT_DISTINCT's intermediate field is VARBINARY (sketch), but the StageInputScan
import org.opensearch.analytics.planner.BasePlannerRulesTests;
            List.of("mock-parquet"),
     * was constructed declaring BIGINT (the user-facing return type). The transformer should
import java.math.BigDecimal;
            List.of()
        OpenSearchAggregate finalAgg = new OpenSearchAggregate(
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
        );
        );
            cluster.traitSet(),
            reducer,
        OpenSearchAggregate finalAgg = buildFinalAggregateOverScan();
        RelDataType stateType = typeFactory.createSqlType(SqlTypeName.BIGINT);
        assertEquals(SqlTypeName.VARBINARY, retypedDc.getSqlTypeName());
        RelDataType groupKeyType = typeFactory.createSqlType(SqlTypeName.INTEGER);
            List.of("mock-parquet"),
        AggregateCall sumCall = AggregateCall.create(
            0,
            false,
    private static IntermediateField classify(SqlAggFunction sqlFn) {
            cluster.traitSet(),
        assertSame("rewrite must return finalAgg unchanged when input chain isn't a StageInputScan", finalAgg, result);
        RelNode result = DistributedAggregateRewriter.rewrite(finalAgg);
        // intermediateFields is parallel to aggCallList (one entry per agg call, not per row column).
            null,
    /**
    }
    }
package org.opensearch.analytics.planner.dag;
            scan,
            ImmutableBitSet.of(),
            Map.of(),
            null,
        // FINAL aggregate sitting on top of the exchange. APPROX_COUNT_DISTINCT keeps function
        // identity (engine-native merge) — its declared return type is BIGINT (user-facing).
     */
            "take_state"
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,
            reducer,
            List.of(1),
            0,
        OpenSearchProject project = (OpenSearchProject) result.getInput(0);
            cluster,
            AggregateMode.FINAL,
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
            cluster.traitSet(),
            extras,
import org.apache.calcite.sql.type.SqlTypeName;
}
        assertEquals(2, project.getRowType().getFieldCount());
            AggregateMode.FINAL,
            null,
        // the transformer only reads finalExtraLiteralArgs and projects the literals; FINAL's
            -1,
            null,
        assertEquals("take_state", project.getRowType().getFieldList().get(0).getName());
            SqlStdOperatorTable.SUM,
            declaredAggType,
        // empty group).
import org.apache.calcite.rex.RexLiteral;
        AggregateCall dcCall = AggregateCall.create(
            Collections.singletonList(null)
        // own aggCall list isn't introspected by the transformer itself. Use the long-form
     * insert an {@link OpenSearchProject} that re-introduces those literals as columns.
            List.of(sumCall(scan)),
            List.of(dcCall),
        );
            Map.of(),
            cluster.traitSet(),
        OpenSearchExchangeReducer reducer = new OpenSearchExchangeReducer(cluster, cluster.traitSet(), stageInput, List.of("mock-parquet"));
import org.opensearch.analytics.spi.AggregateFunction.IntermediateField;
            ImmutableBitSet.of(0),
 */
        // PARTIAL output schema as declared (BIGINT for the agg column).
            false,
import java.util.Map;
            cluster.traitSet(),
 */
            reducer,
    // ── Helpers ──────────────────────────────────────────────────────────────
        RelDataType stageInputType = typeFactory.builder().add("k", groupKeyType).add("dc", declaredAggType).build();
            cluster,
        // create with null return type so Calcite infers (avoids typeMatchesInferred drift on
import org.apache.calcite.util.ImmutableBitSet;
            stageInputType,
    /**
        // We don't need a real TAKE SqlAggFunction for this check — a SUM call will do, since
        RelNode result = DistributedAggregateRewriter.rewrite(finalAgg);
import java.util.List;
import org.opensearch.analytics.planner.rel.OpenSearchProject;
            reducer,
        RexLiteral ten = (RexLiteral) rexBuilder.makeLiteral(BigDecimal.valueOf(10), typeFactory.createSqlType(SqlTypeName.INTEGER), true);
    private OpenSearchAggregate buildFinalAggregateOverScan() {
            AggregateMode.FINAL,

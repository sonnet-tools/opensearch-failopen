        assertEquals(2, project.getRowType().getFieldCount());
            Collections.singletonList(null)
    }
            stageInputType,
import org.apache.calcite.rel.core.AggregateCall;
import org.opensearch.analytics.planner.rel.OpenSearchProject;
            Map.of(),
        );
            -1,
            cluster.traitSet(),  
            Map.of(),
        Map<Integer, List<RexLiteral>> extras = Map.of(0, List.of(ten));  
        // intermediateFields is parallel to aggCallList (one entry per agg call, not per row column).
        List<IntermediateField> intermediateFields = List.of(classify(SqlStdOperatorTable.APPROX_COUNT_DISTINCT));  
        // (must have a StageInputScan beneath the reducer) fails — early exit, no work done.
        OpenSearchExchangeReducer reducer = new OpenSearchExchangeReducer(cluster, cluster.traitSet(), stageInput, List.of("mock-parquet"));
import java.util.List;
    }  
 */  
        return fields.get(0);
        // One captured literal for call 0: integer 10.
        // create with null return type so Calcite infers (avoids typeMatchesInferred drift on
            cluster.traitSet(),
            List.of(0),  
/**
        if (fields == null) return null;  
    private static IntermediateField classify(SqlAggFunction sqlFn) {  
            declaredAggType,
/*  
     */
            List.of("mock-parquet"),
        // FINAL's input should now be an OpenSearchProject (inserted by insertLiteralProject).  
        // Wrap an exchange reducer over a plain scan so the orchestrator's prefix check  
            Collections.singletonList(null)
            stageInputType,  
            List.of()
    }
import java.util.Collections;
            scan,
            0,  
        List<IntermediateField> fields = enumFn.intermediateFields();
            cluster,
    }
        RelDataType stageInputType = typeFactory.builder().add("k", groupKeyType).add("dc", declaredAggType).build();  
        );
        );  
            reducer,
            extras,  
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
        RelDataType groupKeyType = typeFactory.createSqlType(SqlTypeName.INTEGER);
            AggregateMode.FINAL,  
        OpenSearchStageInputScan stageInput = new OpenSearchStageInputScan(  
 * {@link DistributedAggregateRewriter#rewrite} (and its transformer chain) reshape them.
    /**  
    public void testExchangeTypeOverrideRetypesApproxCountDistinctSketch() {
        OpenSearchStageInputScan newStageInput = (OpenSearchStageInputScan) newReducer.getInput(0);
            SqlStdOperatorTable.SUM,
            "dc"  
            false,  
        // We don't need a real TAKE SqlAggFunction for this check — a SUM call will do, since
        assertNotSame("rewrite should return a new FINAL when literals were re-introduced", finalAgg, result);
        RexLiteral ten = (RexLiteral) rexBuilder.makeLiteral(BigDecimal.valueOf(10), typeFactory.createSqlType(SqlTypeName.INTEGER), true);
            Map.of(),
        );
            List.of("mock-parquet"),
            Map.of(),  
            List.of("mock-parquet"),
            -1,  
        OpenSearchAggregate finalAgg = buildFinalAggregateOverScan();
        // own aggCall list isn't introspected by the transformer itself. Use the long-form  
            List.of(1),
import java.util.Map;  
        RelNode result = DistributedAggregateRewriter.rewrite(finalAgg);
        // Project has the original column plus the appended literal column.  
     * insert an {@link OpenSearchProject} that re-introduces those literals as columns.
     * input shape — the orchestrator's StageInputScan check should reject it and return the  
import org.opensearch.analytics.spi.AggregateFunction.IntermediateField;
            List.of(sumCall(scan)),
public class DistributedAggregateRewriterTests extends BasePlannerRulesTests {
        // identity (engine-native merge) — its declared return type is BIGINT (user-facing).
        OpenSearchStageInputScan stageInput = new OpenSearchStageInputScan(
import org.opensearch.analytics.planner.BasePlannerRulesTests;  
            Map.of(),
        );
        OpenSearchExchangeReducer newReducer = (OpenSearchExchangeReducer) result.getInput(0);
 *
        OpenSearchAggregate finalAgg = new OpenSearchAggregate(
     * APPROX_COUNT_DISTINCT's intermediate field is VARBINARY (sketch), but the StageInputScan
            List.of()  
        AggregateCall dcCall = AggregateCall.create(
    // ── Helpers ──────────────────────────────────────────────────────────────  
        // The exchange below FINAL must now wrap a StageInputScan whose 'dc' column is VARBINARY.
            null,
            project.getRowType().getFieldList().get(1).getName().startsWith("$lit_call")
    /**
import org.apache.calcite.rex.RexLiteral;
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rel.RelNode;
import java.math.BigDecimal;  
     * Verifies the orchestrator's fast-path early return.
package org.opensearch.analytics.planner.dag;
            org.apache.calcite.rel.RelCollations.EMPTY,  
    public void testRewriteNoOpWhenNothingToAdapt() {
    /**  
            cluster,  
}
            intermediateFields  
import org.apache.calcite.util.ImmutableBitSet;
            cluster,
import org.apache.calcite.sql.SqlAggFunction;
import org.opensearch.analytics.spi.AggregateFunction;  
            SqlStdOperatorTable.APPROX_COUNT_DISTINCT,  
            cluster,  
        AggregateFunction enumFn = AggregateFunction.fromSqlAggFunction(sqlFn);
        );
    public void testLiteralProjectInsertsCapturedLiterals() {  
     * {@code 10}) on FINAL's {@code finalExtraLiteralArgs} stash. The transformer should  
     * No StageInputScan, no decompositions, no literals → rewriter returns the same instance.
import org.opensearch.analytics.planner.rel.AggregateMode;
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;  
 * {@link OpenSearchAggregate} trees by hand and asserts how
        RelDataType stateType = typeFactory.createSqlType(SqlTypeName.BIGINT);
import org.apache.calcite.sql.type.SqlTypeName;
        // the transformer only reads finalExtraLiteralArgs and projects the literals; FINAL's
     * was constructed declaring BIGINT (the user-facing return type). The transformer should
        RelDataType declaredAggType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), false);
            cluster.traitSet(),
            null,
            cluster.traitSet(),
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
            0,
     */  
    }
            false,
     */
        assertEquals("take_state", project.getRowType().getFieldList().get(0).getName());
            null,  
            List.of(sumCall),
    private OpenSearchAggregate buildFinalAggregateOverScan() {  
import org.apache.calcite.rel.type.RelDataType;  
     */
        assertEquals(SqlTypeName.VARBINARY, retypedDc.getSqlTypeName());
        return new OpenSearchAggregate(
 * this file be licensed under the Apache-2.0 license or a
            false,
        AggregateCall sumCall = AggregateCall.create(  
        OpenSearchExchangeReducer reducer = new OpenSearchExchangeReducer(cluster, cluster.traitSet(), stageInput, List.of("mock-parquet"));
            reducer,
            ImmutableBitSet.of(),  
        RelNode result = DistributedAggregateRewriter.rewrite(finalAgg);
    /**
 * Direct-call unit tests for the post-Volcano rewrite path. Constructs FINAL  
 * compatible open source license.
        );  
        OpenSearchProject project = (OpenSearchProject) result.getInput(0);
 */  
     * re-type the StageInputScan column to VARBINARY.  
    /** Small helper: classify a single SqlAggFunction via the SPI; null when no decomposition. */
            AggregateMode.FINAL,
            "literal column name should follow the $lit_call prefix",
        RelNode result = DistributedAggregateRewriter.rewrite(finalAgg);  
            reducer,
            ImmutableBitSet.of(0),  
            0,
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(  
        assertNotSame("rewrite should return a new FINAL when the exchange type was overridden", finalAgg, result);  
        // PARTIAL output schema as declared (BIGINT for the agg column).  
     * STATE_EXPANDING aggregates carry literal config args (e.g. {@code take(field, 10)}'s
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
     * input unchanged.
            null,
            null,  
            List.of(dcCall),
        // FINAL aggregate sitting on top of the exchange. APPROX_COUNT_DISTINCT keeps function  
            reducer,
        OpenSearchAggregate finalAgg = new OpenSearchAggregate(
            ImmutableBitSet.of(0),
        assertSame("rewrite must return finalAgg unchanged when input chain isn't a StageInputScan", finalAgg, result);  
            cluster,  
            cluster.traitSet(),
        RelDataType stageInputType = typeFactory.builder().add("take_state", stateType).build();
        RelDataType retypedDc = newStageInput.getRowType().getFieldList().get(1).getType();  
            List.of("mock-parquet"),  
            List.of("mock-parquet"),
     * Builds a FINAL aggregate over a plain scan (no exchange reducer). Used as a degenerate
            AggregateMode.FINAL,  
        // empty group).
            List.of(),
        );
            "take_state"
            false,

    private RelDataType nullableVarchar;
            "operator must be rewritten to stock SqlStdOperatorTable.COALESCE — isthmus' default "
        RexCall rewritten = (RexCall) adapter.adapt(original, List.of(), cluster);
        }
            "VARCHAR operand [2] already matches leastRestrictive — no CAST needed",
        return (RexCall) rexBuilder.makeCall(returnType, coalesce, operands);
        // VARCHAR + BIGINT + VARCHAR: leastRestrictive → VARCHAR (string wins over numeric in
            SqlFunctionCategory.SYSTEM
import org.apache.calcite.sql.type.OperandTypes;
                rewritten.getOperands().get(i)
        assertEquals(
        RexNode coerced = rewritten.getOperands().get(1);
    private RexCall buildCoalesce(RelDataType... operandTypes) {
        }
import org.apache.calcite.sql.SqlOperator;
        );
        assertEquals("wrapper must be CAST", SqlKind.CAST, castCall.getKind());
import org.apache.calcite.plan.hep.HepPlanner;
            original.getType(),
    }
    // ── operator identity rewrite ──────────────────────────────────────────
            rewritten.getOperands().get(0)
            rewritten.getOperator()
        for (int i = 0; i < operandTypes.length; i++) {
            rewritten.getOperands().get(0)
 *
    /** Builds an COALESCE call over the provided operand types. */
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rex.RexCall;
    // ── uniform-typed happy path ───────────────────────────────────────────
/*
        RexCall original = buildCoalesce(nullableVarchar, nullableVarchar);
import org.apache.calcite.sql.SqlFunction;
        RexCall original = buildCoalesce(nullableVarchar, nullableBigint, nullableVarchar);
 * The OpenSearch Contributors require contributions made to
        RexCall rewritten = (RexCall) adapted;
    public void testAdaptOnUniformTypeOperandsSkipsCast() {
 */
    // ── mixed-type coercion ────────────────────────────────────────────────
        assertSame(
    // ── empty-operand pass-through ─────────────────────────────────────────
        // leastRestrictive(nullable VARCHAR, NOT NULL VARCHAR) = nullable VARCHAR (nullability is
        assertTrue("CAST target must be nullable (leastRestrictive of nullable+not-null is nullable)", coerced.getType().isNullable());
            "already-nullable operand [0] must pass through untouched",
        );
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
            null,
}
    }
import org.apache.calcite.plan.hep.HepProgramBuilder;
            assertSame(
    public void testAdaptPreservesOriginalReturnType() {
            SqlTypeName.VARCHAR,
    }
import org.apache.calcite.sql.SqlFunctionCategory;
            adapted.getType()
        nullableVarchar = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        assertTrue("BIGINT operand must be wrapped in CAST", coercedMiddle instanceof RexCall);
            returnType = nullableVarchar;
        RexCall original = (RexCall) rexBuilder.makeCall(nullableVarchar, coalesce, List.of());
        assertSame(
        );
        // share a type.
                + "catalog binds this constant to substrait's coalesce, the UDF binding is opaque",
                original.getOperands().get(i),
        cluster = RelOptCluster.create(planner, rexBuilder);
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        rexBuilder = new RexBuilder(typeFactory);
        super.setUp();
            "COALESCE",
/**
        // Calcite's common-type resolution). The BIGINT operand must get a CAST to VARCHAR
 * SPDX-License-Identifier: Apache-2.0
    private RelDataTypeFactory typeFactory;
        List<RexNode> operands = new ArrayList<>(operandTypes.length);
        coalesce = new SqlFunction(
        assertSame("CAST must wrap the original BIGINT operand", original.getOperands().get(1), castCall.getOperands().get(0));
        RexCall rewritten = (RexCall) adapter.adapt(original, List.of(), cluster);
import org.apache.calcite.rex.RexBuilder;
import java.util.ArrayList;
    public void testAdaptOnEmptyOperandListPassesThrough() {
    public void testAdaptOnMixedTypeOperandsInsertsCastToLeastRestrictive() {
 */
        nullableBigint = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
            );
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RexNode coercedMiddle = rewritten.getOperands().get(1);
        RexCall rewritten = (RexCall) adapter.adapt(original, List.of(), cluster);
            "rewritten COALESCE must declare the same return type as the original ENHANCED_COALESCE",
import org.apache.calcite.sql.type.SqlTypeName;
        );
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            rewritten.getOperands().get(2)
        assertSame("empty-operand call must pass through unmodified", original, adapted);
        assertEquals(3, rewritten.getOperands().size());
            "VARCHAR operand [0] already matches leastRestrictive — no CAST needed",
        assertTrue("expected RexCall, got " + adapted.getClass().getSimpleName(), adapted instanceof RexCall);
    // ── nullability unification in leastRestrictive ────────────────────────
    public void testAdaptRewritesOperatorToStockCoalesce() {
 * compatible open source license.
import org.apache.calcite.sql.SqlKind;
    @Override
            SqlKind.OTHER_FUNCTION,
        typeFactory = new JavaTypeFactoryImpl();
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.sql.type.ReturnTypes;
            ReturnTypes.explicit(nullableVarchar),
        RelDataType returnType = typeFactory.leastRestrictive(List.of(operandTypes));
    }
    private final CoalesceAdapter adapter = new CoalesceAdapter();
    private RexBuilder rexBuilder;
import org.apache.calcite.rel.type.RelDataType;
    // ── type preservation ──────────────────────────────────────────────────
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
    private SqlOperator coalesce;
import org.apache.calcite.plan.RelOptCluster;
        RexCall castCall = (RexCall) coercedMiddle;
            original.getOperands().get(0),
        // widened to accept both). The NOT NULL operand gets CAST to nullable so both operands
        }
            SqlStdOperatorTable.COALESCE,
    public void testAdaptOnNullablePlusNotNullVarcharUnifiesToNullable() {
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
        );
        // No CAST inserted: operand list must reference-equal the original operands.
        RexCall original = buildCoalesce(nullableVarchar, nullableVarchar);
        assertEquals(3, rewritten.getOperands().size());
            original.getOperands().get(2),
    private RelDataType notNullVarchar;
        assertEquals(SqlKind.CAST, coerced.getKind());
    private RelDataType nullableBigint;
        );
    }
    private RelOptCluster cluster;
            OperandTypes.VARIADIC,
                "uniform-typed operand " + i + " must pass through without CAST",
        for (int i = 0; i < 3; i++) {
        assertEquals(2, rewritten.getOperands().size());
        assertSame(
 * Unit tests for {@link CoalesceAdapter}.
    }
        assertSame(
            operands.add(rexBuilder.makeInputRef(operandTypes[i], i));
            castCall.getType().getSqlTypeName()
import org.apache.calcite.rex.RexNode;
        RexCall original = buildCoalesce(nullableVarchar, nullableVarchar, nullableVarchar);
        notNullVarchar = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), false);
    }
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        );
            original.getOperands().get(0),
public class CoalesceAdapterTests extends OpenSearchTestCase {
package org.opensearch.be.datafusion;
        assertTrue("NOT NULL VARCHAR operand must be wrapped in CAST to nullable-VARCHAR", coerced instanceof RexCall);
    }
        RexCall original = buildCoalesce(nullableVarchar, notNullVarchar);
    public void setUp() throws Exception {
        assertEquals(
            "CAST target must be VARCHAR family (leastRestrictive resolution of VARCHAR + BIGINT)",
        if (returnType == null) {

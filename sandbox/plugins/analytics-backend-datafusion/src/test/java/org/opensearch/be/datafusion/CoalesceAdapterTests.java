/*  
 * The OpenSearch Contributors require contributions made to  
    private final CoalesceAdapter adapter = new CoalesceAdapter();  
        assertSame(
        assertSame("CAST must wrap the original BIGINT operand", original.getOperands().get(1), castCall.getOperands().get(0));
        RexCall rewritten = (RexCall) adapter.adapt(original, List.of(), cluster);
import org.apache.calcite.sql.SqlKind;  
            "operator must be rewritten to stock SqlStdOperatorTable.COALESCE — isthmus' default "
        RexCall original = buildCoalesce(nullableVarchar, nullableVarchar);
    }
import java.util.List;  
        RexCall original = buildCoalesce(nullableVarchar, nullableVarchar);
    }  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        }
        );
 *
        assertSame(  
            castCall.getType().getSqlTypeName()  
 */  
        assertSame("empty-operand call must pass through unmodified", original, adapted);  
            original.getOperands().get(0),
        assertSame(
        );
        assertTrue("BIGINT operand must be wrapped in CAST", coercedMiddle instanceof RexCall);  
            rewritten.getOperands().get(2)
            rewritten.getOperator()
    public void testAdaptPreservesOriginalReturnType() {
    /** Builds an COALESCE call over the provided operand types. */  
        RexCall original = buildCoalesce(nullableVarchar, nullableVarchar, nullableVarchar);  
 * Unit tests for {@link CoalesceAdapter}.  
    private RexCall buildCoalesce(RelDataType... operandTypes) {
    private RelOptCluster cluster;  
        return (RexCall) rexBuilder.makeCall(returnType, coalesce, operands);
    // ── empty-operand pass-through ─────────────────────────────────────────  
import org.apache.calcite.rex.RexNode;  
import org.opensearch.test.OpenSearchTestCase;  
        List<RexNode> operands = new ArrayList<>(operandTypes.length);
            "CAST target must be VARCHAR family (leastRestrictive resolution of VARCHAR + BIGINT)",
    public void testAdaptOnEmptyOperandListPassesThrough() {
                + "catalog binds this constant to substrait's coalesce, the UDF binding is opaque",
package org.opensearch.be.datafusion;
        super.setUp();
        );
 * SPDX-License-Identifier: Apache-2.0
public class CoalesceAdapterTests extends OpenSearchTestCase {
    public void testAdaptOnNullablePlusNotNullVarcharUnifiesToNullable() {
}
            rewritten.getOperands().get(0)  
        typeFactory = new JavaTypeFactoryImpl();  
 */
            original.getType(),
        // Calcite's common-type resolution). The BIGINT operand must get a CAST to VARCHAR  
        assertTrue("expected RexCall, got " + adapted.getClass().getSimpleName(), adapted instanceof RexCall);
    // ── type preservation ──────────────────────────────────────────────────
        }  
import org.apache.calcite.sql.SqlFunction;
        RexCall rewritten = (RexCall) adapter.adapt(original, List.of(), cluster);  
            SqlKind.OTHER_FUNCTION,
    }
        nullableVarchar = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        assertEquals(  
        RelDataType returnType = typeFactory.leastRestrictive(List.of(operandTypes));  
        RexCall original = buildCoalesce(nullableVarchar, nullableBigint, nullableVarchar);
    public void setUp() throws Exception {
                original.getOperands().get(i),
import org.apache.calcite.sql.type.SqlTypeName;
        assertEquals("wrapper must be CAST", SqlKind.CAST, castCall.getKind());
        // No CAST inserted: operand list must reference-equal the original operands.  
    }
        RexCall rewritten = (RexCall) adapter.adapt(original, List.of(), cluster);
        assertEquals(2, rewritten.getOperands().size());
    private RelDataType notNullVarchar;  
            );
        rexBuilder = new RexBuilder(typeFactory);
        RexCall original = buildCoalesce(nullableVarchar, notNullVarchar);
        RexCall rewritten = (RexCall) adapted;
    public void testAdaptOnUniformTypeOperandsSkipsCast() {
    // ── uniform-typed happy path ───────────────────────────────────────────  
import java.util.ArrayList;
    }  
        // share a type.
import org.apache.calcite.sql.SqlOperator;
            SqlTypeName.VARCHAR,
            ReturnTypes.explicit(nullableVarchar),
    // ── mixed-type coercion ────────────────────────────────────────────────
            "rewritten COALESCE must declare the same return type as the original ENHANCED_COALESCE",  
import org.apache.calcite.rel.type.RelDataType;
            "COALESCE",  
            adapted.getType()
        assertEquals(3, rewritten.getOperands().size());
        nullableBigint = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
        assertSame(  
/**
    private RexBuilder rexBuilder;
        RexCall original = (RexCall) rexBuilder.makeCall(nullableVarchar, coalesce, List.of());  
        assertEquals(
                "uniform-typed operand " + i + " must pass through without CAST",
    public void testAdaptRewritesOperatorToStockCoalesce() {  
            "already-nullable operand [0] must pass through untouched",
        );  
    private RelDataType nullableVarchar;
    // ── nullability unification in leastRestrictive ────────────────────────
        );  
    @Override  
    }
import org.apache.calcite.sql.SqlFunctionCategory;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        }
        for (int i = 0; i < operandTypes.length; i++) {  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);  
        cluster = RelOptCluster.create(planner, rexBuilder);  
        // leastRestrictive(nullable VARCHAR, NOT NULL VARCHAR) = nullable VARCHAR (nullability is
import org.apache.calcite.rex.RexCall;
            operands.add(rexBuilder.makeInputRef(operandTypes[i], i));
import org.apache.calcite.rex.RexBuilder;
    }  
        coalesce = new SqlFunction(
            OperandTypes.VARIADIC,
        if (returnType == null) {
    }
    public void testAdaptOnMixedTypeOperandsInsertsCastToLeastRestrictive() {
        assertEquals(SqlKind.CAST, coerced.getKind());
        RexCall castCall = (RexCall) coercedMiddle;
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        for (int i = 0; i < 3; i++) {
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.plan.hep.HepProgramBuilder;
        // widened to accept both). The NOT NULL operand gets CAST to nullable so both operands  
            original.getOperands().get(2),  
        // VARCHAR + BIGINT + VARCHAR: leastRestrictive → VARCHAR (string wins over numeric in
            "VARCHAR operand [0] already matches leastRestrictive — no CAST needed",  
        assertTrue("NOT NULL VARCHAR operand must be wrapped in CAST to nullable-VARCHAR", coerced instanceof RexCall);
            "VARCHAR operand [2] already matches leastRestrictive — no CAST needed",
        RexNode coercedMiddle = rewritten.getOperands().get(1);
                rewritten.getOperands().get(i)  
 * this file be licensed under the Apache-2.0 license or a
        notNullVarchar = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), false);  
import org.apache.calcite.plan.hep.HepPlanner;  
            SqlFunctionCategory.SYSTEM
import org.apache.calcite.sql.type.OperandTypes;  
            null,  
    private RelDataType nullableBigint;
    private RelDataTypeFactory typeFactory;
            rewritten.getOperands().get(0)
        assertTrue("CAST target must be nullable (leastRestrictive of nullable+not-null is nullable)", coerced.getType().isNullable());  
        RexNode coerced = rewritten.getOperands().get(1);  
        );  
 * compatible open source license.
            returnType = nullableVarchar;
        assertEquals(3, rewritten.getOperands().size());
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            assertSame(  
        );
    private SqlOperator coalesce;
            SqlStdOperatorTable.COALESCE,  
    // ── operator identity rewrite ──────────────────────────────────────────
            original.getOperands().get(0),
import org.apache.calcite.sql.type.ReturnTypes;

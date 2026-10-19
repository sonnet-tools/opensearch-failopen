        RexNode intOperand = rexBuilder.makeLiteral(5, type(SqlTypeName.INTEGER, false), false);
        assertSame("Already-DOUBLE first operand returns unchanged", original, adapted);
    public void testNonNullableInputProducesNonNullableOuterCast() {  
        RexCall original = floorCall(intOperand);
        RexNode adapted = adapter.adapt(original, List.of(), cluster);  
    }
        assertSame("Already-DOUBLE first operand returns unchanged", original, adapted);  
        assertEquals("Precondition: TRUNCATE return type INTEGER", SqlTypeName.INTEGER, original.getType().getSqlTypeName());
    public void testTruncateOnDoubleFirstOperandIsUnchanged() {
        RexNode adapted = adapter.adapt(original, List.of(), cluster);  
            org.apache.calcite.sql.type.ReturnTypes.DOUBLE_NULLABLE,  
        RexNode scale = rexBuilder.makeLiteral(0, type(SqlTypeName.INTEGER, false), false);
        // floor(DECIMAL) — DataFusion's floor signature accepts Decimal natively; isthmus binds
        // floor(BIGINT) — outer cast must restore BIGINT (not narrow to INTEGER).
package org.opensearch.analytics.spi;
/*  
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
        // operator so isthmus emits the correct substrait name.
            SqlTypeName.INTEGER,
        // operator to the rename target, then cast result back to INTEGER. Verifies the  
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.CEIL, List.of(operand));
        // the decimal impl directly. No adapter rewrite needed.  
            "SIGNUM",  
        assertEquals("Inner ROUND has 2 operands", 2, innerRound.getOperands().size());  
        RexNode nullableInt = rexBuilder.makeNullLiteral(type(SqlTypeName.INTEGER, true));
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.TRUNCATE);
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.ROUND, List.of(value));
        assertEquals("Inner CEIL return type DOUBLE", SqlTypeName.DOUBLE, innerCeil.getType().getSqlTypeName());
        assertEquals(  
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);  
        // integer-input path uses the rename target (not the original operator) for the
            "Scale operand unchanged (still INTEGER)",  
        // Using PI() as a synthetic stand-in (no operands).
 */  
        RexCall innerSignum = (RexCall) outerCast.getOperands().get(0);
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        RexNode dblOperand = rexBuilder.makeLiteral(BigDecimal.valueOf(5.5), type(SqlTypeName.DOUBLE, false), false);
        RexNode decOperand = rexBuilder.makeLiteral(BigDecimal.valueOf(123, 2), decimalType, false);
 * {@code CEIL(int_col)} are wrapped as {@code CAST(floor(CAST(int_col AS DOUBLE)) AS <orig_type>)}
    }  
        RexCall innerFloor = (RexCall) outerCast.getOperands().get(0);
        // for this test (we just need to verify the adapter rebuilds when target != original.op).
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);  
        // target (SignumFunction.FUNCTION → substrait "signum"); on a non-integer operand  
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.TRUNCATE, List.of(value, scale));
    }  
        );
        assertEquals("Inner FLOOR return type DOUBLE", SqlTypeName.DOUBLE, innerFloor.getType().getSqlTypeName());
import org.apache.calcite.rel.type.RelDataType;
 * Unit tests for {@link IntegerRoundingCastAdapter} — verifies that {@code FLOOR(int_col)} /  
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SIGN, List.of(dblOperand));
        // BackendPlanAdapter recurses and re-visits the inner FLOOR (whose operand is now
    public void testFloorOnDoubleOperandIsUnchanged() {
        // sign(INTEGER) — combines both behaviors: widen the operand to DOUBLE, rename the
    // ─── ROUND coverage ──────────────────────────────────────────────────────────────────
        RexNode intOperand = rexBuilder.makeLiteral(5, type(SqlTypeName.INTEGER, false), false);  
        assertEquals("Outer return type still INTEGER", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
        assertEquals("Outer return type INTEGER", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
        RexNode value = rexBuilder.makeLiteral(5, type(SqlTypeName.INTEGER, false), false);
            org.apache.calcite.sql.SqlKind.OTHER_FUNCTION,
    }  
        RexCall original = ceilCall(intOperand);
/**
            "Scale operand unchanged (still INTEGER)",
    }
        // Defensive: if somehow a no-arg call surfaces, adapter must not blow up.
        // floor(DOUBLE) — operand already matches the standard yaml's fp64 impl, no rewrite.  
            org.apache.calcite.sql.SqlFunctionCategory.NUMERIC  
            SqlTypeName.INTEGER,
    public void testFloorOnIntegerOperandIsWrappedInCasts() {
    public void testFloorOnDecimalOperandIsUnchanged() {
        assertEquals("Outer return type INTEGER (matching original)", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());  
    public void testReAdaptingInnerFloorIsANoop() {
        RexCall outerCast = (RexCall) adapted;  
        assertEquals("Inner operand widened to DOUBLE", SqlTypeName.DOUBLE, innerSignum.getOperands().get(0).getType().getSqlTypeName());  
            innerTruncate.getOperands().get(1).getType().getSqlTypeName()  
        assertEquals("Precondition: ROUND return type INTEGER", SqlTypeName.INTEGER, original.getType().getSqlTypeName());
    }
        RexNode scale = rexBuilder.makeLiteral(0, type(SqlTypeName.INTEGER, false), false);  
        assertEquals("First operand widened to DOUBLE", SqlTypeName.DOUBLE, innerRound.getOperands().get(0).getType().getSqlTypeName());
    }  
        assertSame("Re-adapting inner DOUBLE-input FLOOR is a no-op", innerFloor, reAdapted);  
        assertEquals("Outer return type INTEGER (matching original)", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
        // "sign" (which DataFusion does not register). The adapter is given the renamed
        assertSame("Inner operator is SqlStdOperatorTable.FLOOR", SqlStdOperatorTable.FLOOR, innerFloor.getOperator());
    // ─── 2-arg flavor coverage (e.g. TRUNCATE(value, scale)) ────────────────────────────  
        RexCall original = floorCall(decOperand);  
        org.apache.calcite.sql.SqlOperator renameTarget = new org.apache.calcite.sql.SqlFunction(  
import org.apache.calcite.sql.SqlKind;  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        // sign(DOUBLE) — DataFusion's UDF is `signum`, not `sign`. The PPL frontend emits  
        assertFalse("Outer cast preserves non-nullability", outerCast.getType().isNullable());
        assertEquals(  
        // Re-applying the adapter to the inner FLOOR (DOUBLE input) should be a no-op.
    public void testTruncateOnIntegerWithIntegerScaleWidensOnlyFirstOperand() {
        assertSame("Decimal operand call returned unchanged", original, adapted);
        // DOUBLE, inner FLOOR receives a single DOUBLE operand.  
        RexCall original = floorCall(intOperand);
            org.apache.calcite.sql.SqlFunctionCategory.NUMERIC
            null,  
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);  
        );
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.ROUND);  
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
 * SPDX-License-Identifier: Apache-2.0
    }  
        assertEquals("Outer is CAST", SqlKind.CAST, outerCast.getKind());
        assertFalse("Precondition: original is non-nullable", original.getType().isNullable());  
        RexCall original = floorCall(intOperand);
            renamed.getType().getSqlTypeName()  
        );  
        RexNode longOperand = rexBuilder.makeLiteral(5L, type(SqlTypeName.BIGINT, false), false);  
        RexNode intOperand = rexBuilder.makeLiteral(7, type(SqlTypeName.INTEGER, false), false);
    public void testRenameOnDoubleOperandRebuildsWithoutCasts() {
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
            original.getType().getSqlTypeName(),
        assertSame("Zero-operand call returned unchanged", original, adapted);  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);  
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.PI, List.of());  
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(name), nullable);
 * compatible open source license.
            "Return type preserved (matches original.getType())",
        );  
        // round(double_col) — already-widened first operand, no rewrite needed.
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.ROUND, List.of(value, scale));  
        RexCall original = floorCall(longOperand);
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
    }
 * with the outer return type preserved, and that non-integer operand types pass through unchanged.
    private RexCall floorCall(RexNode operand) {
        assertSame("Inner operator is the renamed target", renameTarget, innerSignum.getOperator());
    }
        assertEquals("preconditions: original return type is INTEGER", SqlTypeName.INTEGER, original.getType().getSqlTypeName());  
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode value = rexBuilder.makeLiteral(BigDecimal.valueOf(5.5), type(SqlTypeName.DOUBLE, false), false);
        // SqlStdOperatorTable.SIGN, but isthmus's default mapping serialises it as substrait
import java.util.List;  
        assertEquals("Inner FLOOR return type DOUBLE", SqlTypeName.DOUBLE, innerFloor.getType().getSqlTypeName());
        // DOUBLE), the operand-type guard must skip the rewrite to avoid infinite expansion.
    private RelDataType type(SqlTypeName name, boolean nullable) {
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        // inner call.
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(renameTarget);
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);
            "SIGNUM",
        RexNode value = rexBuilder.makeLiteral(5, type(SqlTypeName.INTEGER, false), false);
    // ─── Operator-rename case (e.g. SIGN → SignumFunction.FUNCTION) ───────────────────  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
    public void testNullabilityIsPreservedInOuterCast() {
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SIGN, List.of(intOperand));
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.FLOOR, List.of(operand));  
        // there's no widening to do, but we still need to rebuild the call with the renamed
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);
    public void testRoundOnIntegerWithIntegerScaleWidensOnlyFirstOperand() {
            org.apache.calcite.sql.type.OperandTypes.NUMERIC,
    }
        assertEquals("Outer node is a CAST", SqlKind.CAST, outerCast.getKind());
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.TRUNCATE);
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
 * The OpenSearch Contributors require contributions made to  
        RexCall original = floorCall(nullableInt);
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.CEIL);  
    }
 *
        assertSame("Inner operator is SqlStdOperatorTable.CEIL", SqlStdOperatorTable.CEIL, innerCeil.getOperator());  
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
        RexCall innerFloor = (RexCall) inner;  
        assertTrue("Adapter must return a RexCall", adapted instanceof RexCall);
        RexCall innerCeil = (RexCall) outerCast.getOperands().get(0);
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.ROUND);  
            org.apache.calcite.sql.type.ReturnTypes.DOUBLE_NULLABLE,
            org.apache.calcite.sql.type.OperandTypes.NUMERIC,
        assertSame("Scale operand is the same RexNode reference", scale, innerRound.getOperands().get(1));
            null,
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(renameTarget);
    }
        assertEquals("Outer return type BIGINT (matching original)", SqlTypeName.BIGINT, outerCast.getType().getSqlTypeName());  
    }  
        assertEquals("First operand widened to DOUBLE", SqlTypeName.DOUBLE, innerTruncate.getOperands().get(0).getType().getSqlTypeName());
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
        assertSame("Inner operator is TRUNCATE", SqlStdOperatorTable.TRUNCATE, innerTruncate.getOperator());  
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);  
        assertNotSame("Rename target produces a new call", original, adapted);
import org.apache.calcite.rex.RexNode;
        assertTrue("Precondition: original is nullable", original.getType().isNullable());  
public class IntegerRoundingCastAdapterTests extends OpenSearchTestCase {
        RexNode scale = rexBuilder.makeLiteral(1, type(SqlTypeName.INTEGER, false), false);
import org.opensearch.test.OpenSearchTestCase;  
        );
        assertEquals("Outer return type INTEGER", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
        RexCall innerTruncate = (RexCall) outerCast.getOperands().get(0);
        assertEquals("Outer node is a CAST", SqlKind.CAST, outerCast.getKind());  
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);  
        RexNode value = rexBuilder.makeLiteral(BigDecimal.valueOf(5.5), type(SqlTypeName.DOUBLE, false), false);  
        RexNode intOperand = rexBuilder.makeLiteral(5, type(SqlTypeName.INTEGER, false), false);  
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);
    public void testCeilOnIntegerOperandIsWrappedInCasts() {
    }  
        assertSame("Inner operator is ROUND", SqlStdOperatorTable.ROUND, innerRound.getOperator());
        RexNode widenedOperand = innerFloor.getOperands().get(0);
    private RexCall ceilCall(RexNode operand) {  
        assertSame("Scale operand is the same RexNode reference", scale, innerTruncate.getOperands().get(1));
    }
        // truncate(int_col, scale) — 2-arg form. Adapter must widen only the first operand  
        assertEquals("Outer return type INTEGER", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());  
        // Stand-in for SignumFunction.FUNCTION — any operator different from the original works  
        org.apache.calcite.sql.SqlOperator renameTarget = new org.apache.calcite.sql.SqlFunction(
    }
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.PI);
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);
        assertEquals("Inner TRUNCATE has 2 operands", 2, innerTruncate.getOperands().size());
        RexNode dblOperand = rexBuilder.makeLiteral(BigDecimal.valueOf(-1.5), type(SqlTypeName.DOUBLE, false), false);  
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.TRUNCATE, List.of(value, scale));  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        assertEquals("No outer CAST — operand was already DOUBLE so no widening", 1, renamed.getOperands().size());
            innerRound.getOperands().get(1).getType().getSqlTypeName()
        // Nullable INTEGER input → outer CAST must produce nullable INTEGER (matching original).  
    public void testZeroOperandCallIsUnchanged() {  
}
        RexCall original = floorCall(dblOperand);
import org.apache.calcite.rex.RexBuilder;  
        // (the value); the scale operand passes through unchanged. Outer cast restores INTEGER.
        RexCall renamed = (RexCall) adapted;
        assertTrue("Inner node is a RexCall (the FLOOR call)", inner instanceof RexCall);
    public void testRoundOnDoubleFirstOperandIsUnchanged() {
        assertSame("Operator is the renamed target", renameTarget, renamed.getOperator());  
        assertEquals("Original operand widened to DOUBLE", SqlTypeName.DOUBLE, widenedOperand.getType().getSqlTypeName());
            org.apache.calcite.sql.SqlKind.OTHER_FUNCTION,
        // the scale passes through unchanged. Outer cast restores INTEGER.  
        // truncate(double_col, scale) — already-widened first operand, no rewrite needed.  
import org.apache.calcite.plan.RelOptCluster;
        RexNode reAdapted = adapter.adapt(innerFloor, List.of(), cluster);
        // round(int_col, scale) — 2-arg form. Adapter must widen only the first operand;
        assertTrue("Outer cast preserves nullability", outerCast.getType().isNullable());  
        assertSame("Already-DOUBLE-input call returned unchanged", original, adapted);
import java.math.BigDecimal;
        assertSame("Operand passed through unchanged", dblOperand, renamed.getOperands().get(0));
 */  
        RexNode inner = outerCast.getOperands().get(0);
 * this file be licensed under the Apache-2.0 license or a
        RelDataType decimalType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DECIMAL, 10, 2), false);
        // The adapter rebuilds the call as cast(floor(cast(x, fp64)), int). If  
    }
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode intOperand = rexBuilder.makeLiteral(-3, type(SqlTypeName.INTEGER, false), false);  
        // floor(INTEGER literal=5) — outer call must remain INTEGER, operand must be CAST'd to
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexCall innerRound = (RexCall) outerCast.getOperands().get(0);
        RexCall innerFloor = (RexCall) outerCast.getOperands().get(0);
    public void testRenameOnIntegerOperandWrapsInCastsAndRenames() {
    public void testFloorOnBigintOperandPreservesBigint() {
import org.apache.calcite.rex.RexCall;
        assertEquals(

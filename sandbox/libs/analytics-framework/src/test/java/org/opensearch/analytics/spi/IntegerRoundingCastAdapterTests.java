        RexCall original = floorCall(intOperand);
        RexCall original = floorCall(intOperand);
            org.apache.calcite.sql.type.ReturnTypes.DOUBLE_NULLABLE,
    }
        RexNode intOperand = rexBuilder.makeLiteral(5, type(SqlTypeName.INTEGER, false), false);
        assertEquals("Outer return type INTEGER", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
        assertSame("Inner operator is SqlStdOperatorTable.FLOOR", SqlStdOperatorTable.FLOOR, innerFloor.getOperator());
        // The adapter rebuilds the call as cast(floor(cast(x, fp64)), int). If
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.CEIL, List.of(operand));
        assertSame("Re-adapting inner DOUBLE-input FLOOR is a no-op", innerFloor, reAdapted);
        );
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);
 * compatible open source license.
        assertEquals("First operand widened to DOUBLE", SqlTypeName.DOUBLE, innerRound.getOperands().get(0).getType().getSqlTypeName());
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(name), nullable);
        RexNode value = rexBuilder.makeLiteral(BigDecimal.valueOf(5.5), type(SqlTypeName.DOUBLE, false), false);
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
        assertEquals("Outer return type INTEGER", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.ROUND, List.of(value));
        // SqlStdOperatorTable.SIGN, but isthmus's default mapping serialises it as substrait
    public void testFloorOnDoubleOperandIsUnchanged() {
    }
        RexCall original = floorCall(longOperand);
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
        assertTrue("Inner node is a RexCall (the FLOOR call)", inner instanceof RexCall);
        RexNode decOperand = rexBuilder.makeLiteral(BigDecimal.valueOf(123, 2), decimalType, false);
        RexNode longOperand = rexBuilder.makeLiteral(5L, type(SqlTypeName.BIGINT, false), false);
            "Return type preserved (matches original.getType())",
        assertSame("Operand passed through unchanged", dblOperand, renamed.getOperands().get(0));
        // BackendPlanAdapter recurses and re-visits the inner FLOOR (whose operand is now
    public void testCeilOnIntegerOperandIsWrappedInCasts() {
        assertEquals("First operand widened to DOUBLE", SqlTypeName.DOUBLE, innerTruncate.getOperands().get(0).getType().getSqlTypeName());
    private RexCall ceilCall(RexNode operand) {
        RexNode value = rexBuilder.makeLiteral(BigDecimal.valueOf(5.5), type(SqlTypeName.DOUBLE, false), false);
        RexNode widenedOperand = innerFloor.getOperands().get(0);
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.TRUNCATE);
        assertSame("Already-DOUBLE-input call returned unchanged", original, adapted);
        RexNode dblOperand = rexBuilder.makeLiteral(BigDecimal.valueOf(5.5), type(SqlTypeName.DOUBLE, false), false);
        assertEquals("Inner FLOOR return type DOUBLE", SqlTypeName.DOUBLE, innerFloor.getType().getSqlTypeName());
        assertEquals("Outer return type still INTEGER", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
        assertEquals("Precondition: ROUND return type INTEGER", SqlTypeName.INTEGER, original.getType().getSqlTypeName());
import org.apache.calcite.rel.type.RelDataType;
        assertEquals("Inner CEIL return type DOUBLE", SqlTypeName.DOUBLE, innerCeil.getType().getSqlTypeName());
    }
        assertTrue("Precondition: original is nullable", original.getType().isNullable());
        assertSame("Scale operand is the same RexNode reference", scale, innerRound.getOperands().get(1));
            null,
            org.apache.calcite.sql.SqlKind.OTHER_FUNCTION,
        assertEquals(
    }
    public void testNullabilityIsPreservedInOuterCast() {
}
 * Unit tests for {@link IntegerRoundingCastAdapter} — verifies that {@code FLOOR(int_col)} /
    // ─── Operator-rename case (e.g. SIGN → SignumFunction.FUNCTION) ───────────────────
        RexNode scale = rexBuilder.makeLiteral(0, type(SqlTypeName.INTEGER, false), false);
        assertEquals("Inner operand widened to DOUBLE", SqlTypeName.DOUBLE, innerSignum.getOperands().get(0).getType().getSqlTypeName());
import org.apache.calcite.sql.SqlKind;
 * The OpenSearch Contributors require contributions made to
        RexCall innerCeil = (RexCall) outerCast.getOperands().get(0);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        assertSame("Scale operand is the same RexNode reference", scale, innerTruncate.getOperands().get(1));
        // target (SignumFunction.FUNCTION → substrait "signum"); on a non-integer operand
        assertSame("Already-DOUBLE first operand returns unchanged", original, adapted);
        assertSame("Inner operator is TRUNCATE", SqlStdOperatorTable.TRUNCATE, innerTruncate.getOperator());
        );
        RexCall original = floorCall(intOperand);
        assertEquals("Outer return type BIGINT (matching original)", SqlTypeName.BIGINT, outerCast.getType().getSqlTypeName());
import org.apache.calcite.plan.RelOptCluster;
        // sign(DOUBLE) — DataFusion's UDF is `signum`, not `sign`. The PPL frontend emits
            org.apache.calcite.sql.type.ReturnTypes.DOUBLE_NULLABLE,
    }
    }
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);
        // there's no widening to do, but we still need to rebuild the call with the renamed
        RexCall outerCast = (RexCall) adapted;
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
        RexCall innerFloor = (RexCall) outerCast.getOperands().get(0);
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
    // ─── ROUND coverage ──────────────────────────────────────────────────────────────────
        assertEquals("Precondition: TRUNCATE return type INTEGER", SqlTypeName.INTEGER, original.getType().getSqlTypeName());
        // Stand-in for SignumFunction.FUNCTION — any operator different from the original works
        RexCall innerFloor = (RexCall) inner;
import org.apache.calcite.sql.type.SqlTypeName;
        assertEquals("preconditions: original return type is INTEGER", SqlTypeName.INTEGER, original.getType().getSqlTypeName());
        assertEquals("Inner ROUND has 2 operands", 2, innerRound.getOperands().size());
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        assertEquals("No outer CAST — operand was already DOUBLE so no widening", 1, renamed.getOperands().size());
    public void testNonNullableInputProducesNonNullableOuterCast() {
        RexCall innerTruncate = (RexCall) outerCast.getOperands().get(0);
        RexNode scale = rexBuilder.makeLiteral(1, type(SqlTypeName.INTEGER, false), false);
        // floor(INTEGER literal=5) — outer call must remain INTEGER, operand must be CAST'd to
    public void testTruncateOnIntegerWithIntegerScaleWidensOnlyFirstOperand() {
        RexCall original = ceilCall(intOperand);
        RelDataType decimalType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DECIMAL, 10, 2), false);
        // Defensive: if somehow a no-arg call surfaces, adapter must not blow up.
        RexNode intOperand = rexBuilder.makeLiteral(7, type(SqlTypeName.INTEGER, false), false);
    public void testRoundOnDoubleFirstOperandIsUnchanged() {
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.TRUNCATE);
        // Re-applying the adapter to the inner FLOOR (DOUBLE input) should be a no-op.
import org.apache.calcite.rex.RexCall;
            innerRound.getOperands().get(1).getType().getSqlTypeName()
        assertEquals(
        // DOUBLE), the operand-type guard must skip the rewrite to avoid infinite expansion.
        RexCall original = floorCall(nullableInt);
    }
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.ROUND, List.of(value, scale));
import org.apache.calcite.rex.RexBuilder;
        assertEquals("Original operand widened to DOUBLE", SqlTypeName.DOUBLE, widenedOperand.getType().getSqlTypeName());
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RexNode value = rexBuilder.makeLiteral(5, type(SqlTypeName.INTEGER, false), false);
        assertSame("Zero-operand call returned unchanged", original, adapted);
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);
        assertTrue("Outer cast preserves nullability", outerCast.getType().isNullable());
        RexNode intOperand = rexBuilder.makeLiteral(5, type(SqlTypeName.INTEGER, false), false);
    }
        RexNode dblOperand = rexBuilder.makeLiteral(BigDecimal.valueOf(-1.5), type(SqlTypeName.DOUBLE, false), false);
        RexCall original = floorCall(dblOperand);
    }
        );
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        assertSame("Decimal operand call returned unchanged", original, adapted);
            renamed.getType().getSqlTypeName()
 * with the outer return type preserved, and that non-integer operand types pass through unchanged.
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
        RexNode reAdapted = adapter.adapt(innerFloor, List.of(), cluster);
        org.apache.calcite.sql.SqlOperator renameTarget = new org.apache.calcite.sql.SqlFunction(
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.ROUND);
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
        );
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        RexNode intOperand = rexBuilder.makeLiteral(-3, type(SqlTypeName.INTEGER, false), false);
        assertEquals("Inner TRUNCATE has 2 operands", 2, innerTruncate.getOperands().size());
        // inner call.
 * this file be licensed under the Apache-2.0 license or a
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.PI);
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
 */
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);
    }
            org.apache.calcite.sql.SqlKind.OTHER_FUNCTION,
    }
        assertSame("Inner operator is ROUND", SqlStdOperatorTable.ROUND, innerRound.getOperator());
        // integer-input path uses the rename target (not the original operator) for the
    public void testReAdaptingInnerFloorIsANoop() {
        // operator so isthmus emits the correct substrait name.
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.PI, List.of());
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);
        assertSame("Inner operator is the renamed target", renameTarget, innerSignum.getOperator());
 * SPDX-License-Identifier: Apache-2.0
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.CEIL);
 * {@code CEIL(int_col)} are wrapped as {@code CAST(floor(CAST(int_col AS DOUBLE)) AS <orig_type>)}
        assertFalse("Precondition: original is non-nullable", original.getType().isNullable());
        // Nullable INTEGER input → outer CAST must produce nullable INTEGER (matching original).
        assertFalse("Outer cast preserves non-nullability", outerCast.getType().isNullable());
    private RexCall floorCall(RexNode operand) {
        // floor(DOUBLE) — operand already matches the standard yaml's fp64 impl, no rewrite.
        // floor(BIGINT) — outer cast must restore BIGINT (not narrow to INTEGER).
    }
        // "sign" (which DataFusion does not register). The adapter is given the renamed
        assertNotSame("Rename target produces a new call", original, adapted);
        // (the value); the scale operand passes through unchanged. Outer cast restores INTEGER.
        RexNode inner = outerCast.getOperands().get(0);
    }
    }
        RexCall original = floorCall(decOperand);
package org.opensearch.analytics.spi;
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(renameTarget);
    public void testRoundOnIntegerWithIntegerScaleWidensOnlyFirstOperand() {
        // truncate(double_col, scale) — already-widened first operand, no rewrite needed.
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.TRUNCATE, List.of(value, scale));
            org.apache.calcite.sql.SqlFunctionCategory.NUMERIC
        org.apache.calcite.sql.SqlOperator renameTarget = new org.apache.calcite.sql.SqlFunction(
        // truncate(int_col, scale) — 2-arg form. Adapter must widen only the first operand
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
 */
            org.apache.calcite.sql.type.OperandTypes.NUMERIC,
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
    }
        // Using PI() as a synthetic stand-in (no operands).
        // round(double_col) — already-widened first operand, no rewrite needed.
            "Scale operand unchanged (still INTEGER)",
        // sign(INTEGER) — combines both behaviors: widen the operand to DOUBLE, rename the
    public void testFloorOnBigintOperandPreservesBigint() {
import java.util.List;
            org.apache.calcite.sql.type.OperandTypes.NUMERIC,
        // floor(DECIMAL) — DataFusion's floor signature accepts Decimal natively; isthmus binds
    public void testRenameOnIntegerOperandWrapsInCastsAndRenames() {
        // round(int_col, scale) — 2-arg form. Adapter must widen only the first operand;
    public void testRenameOnDoubleOperandRebuildsWithoutCasts() {
            "SIGNUM",
            org.apache.calcite.sql.SqlFunctionCategory.NUMERIC
    }
    public void testZeroOperandCallIsUnchanged() {
        RexNode intOperand = rexBuilder.makeLiteral(5, type(SqlTypeName.INTEGER, false), false);
        assertEquals("Inner FLOOR return type DOUBLE", SqlTypeName.DOUBLE, innerFloor.getType().getSqlTypeName());
import org.apache.calcite.rel.type.RelDataTypeFactory;
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        RexNode nullableInt = rexBuilder.makeNullLiteral(type(SqlTypeName.INTEGER, true));
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(renameTarget);
    public void testTruncateOnDoubleFirstOperandIsUnchanged() {
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
        );
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexCall innerRound = (RexCall) outerCast.getOperands().get(0);
/*
import org.apache.calcite.plan.volcano.VolcanoPlanner;
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SIGN, List.of(dblOperand));
        assertTrue("Adapter must return a RexCall", adapted instanceof RexCall);
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SIGN, List.of(intOperand));
    }
        assertEquals(
        // operator to the rename target, then cast result back to INTEGER. Verifies the
        assertEquals("Outer node is a CAST", SqlKind.CAST, outerCast.getKind());
        assertEquals("Outer node is a CAST", SqlKind.CAST, outerCast.getKind());
        assertSame("Operator is the renamed target", renameTarget, renamed.getOperator());
public class IntegerRoundingCastAdapterTests extends OpenSearchTestCase {
            SqlTypeName.INTEGER,
        assertEquals("Outer return type INTEGER", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
/**
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.ROUND);
        // the scale passes through unchanged. Outer cast restores INTEGER.
            innerTruncate.getOperands().get(1).getType().getSqlTypeName()
            "Scale operand unchanged (still INTEGER)",
        RexCall innerSignum = (RexCall) outerCast.getOperands().get(0);
        IntegerRoundingCastAdapter adapter = new IntegerRoundingCastAdapter(SqlStdOperatorTable.FLOOR);
        // the decimal impl directly. No adapter rewrite needed.
        assertEquals("Outer return type INTEGER (matching original)", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
            SqlTypeName.INTEGER,
    // ─── 2-arg flavor coverage (e.g. TRUNCATE(value, scale)) ────────────────────────────
            original.getType().getSqlTypeName(),
        assertSame("Already-DOUBLE first operand returns unchanged", original, adapted);
        assertSame("Inner operator is SqlStdOperatorTable.CEIL", SqlStdOperatorTable.CEIL, innerCeil.getOperator());
        assertEquals("Outer is CAST", SqlKind.CAST, outerCast.getKind());
        // DOUBLE, inner FLOOR receives a single DOUBLE operand.
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
            "SIGNUM",
    public void testFloorOnIntegerOperandIsWrappedInCasts() {
    public void testFloorOnDecimalOperandIsUnchanged() {
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.TRUNCATE, List.of(value, scale));
import org.opensearch.test.OpenSearchTestCase;
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.FLOOR, List.of(operand));
    }
        RexCall renamed = (RexCall) adapted;
        // for this test (we just need to verify the adapter rebuilds when target != original.op).
        RexCall innerFloor = (RexCall) outerCast.getOperands().get(0);
        RexNode scale = rexBuilder.makeLiteral(0, type(SqlTypeName.INTEGER, false), false);
        RexNode value = rexBuilder.makeLiteral(5, type(SqlTypeName.INTEGER, false), false);
            null,
import java.math.BigDecimal;
 *
import org.apache.calcite.rex.RexNode;
    private RelDataType type(SqlTypeName name, boolean nullable) {
        assertEquals("Outer return type INTEGER (matching original)", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());

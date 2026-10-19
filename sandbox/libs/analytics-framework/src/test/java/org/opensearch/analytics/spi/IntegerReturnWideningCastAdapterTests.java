        RelDataType doubleRet = type(SqlTypeName.DOUBLE, true);
        // Defensive: if some other call surfaces with SMALLINT return (same family of i16<->i64
import org.apache.calcite.sql.fun.SqlLibraryOperators;
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        assertTrue("Outer cast preserves nullability", outerCast.getType().isNullable());
 * (to match DataFusion's i64 physical), and that already-wide / non-integer returns pass
        assertEquals("Inner return type widened to BIGINT", SqlTypeName.BIGINT, innerCall.getType().getSqlTypeName());
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
 * {@code INTEGER}-returning call (concrete example: {@code ARRAY_LENGTH(arr)}) is rewritten
        // through both the inner widening and the outer cast unchanged.
        // operand passes through unchanged.
        RexNode reAdapted = adapter.adapt(innerWidened, List.of(), cluster);
    }
    }
 * through unchanged.
        // recurses and re-visits the inner BIGINT-returning call, the return-type guard must skip
    }
    }
package org.opensearch.analytics.spi;
        // mismatches in principle), the adapter must widen it just like INTEGER.
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(name), nullable);
import org.apache.calcite.sql.type.SqlTypeName;
        // Forge a non-nullable INTEGER return on the synthetic call to verify nullability flows
import java.util.List;
        RexNode arr = arrayLiteral();
        // The adapter rebuilds the call as cast(fn(...) [BIGINT], INTEGER). If BackendPlanAdapter
/**
        RexCall innerCall = (RexCall) outerCast.getOperands().get(0);
        assertEquals("Outer return type still INTEGER", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
        RexNode arr = arrayLiteral();
 * SPDX-License-Identifier: Apache-2.0
        RelDataType smallintRet = type(SqlTypeName.SMALLINT, true);
        assertSame("Inner operator is the original ARRAY_LENGTH operator", original.getOperator(), innerCall.getOperator());
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        // of scope for this adapter. Adapter must pass through unchanged.
    }
    public void testReAdaptingInnerWidenedCallIsANoop() {
        RexCall original = (RexCall) rexBuilder.makeCall(bigintRet, SqlLibraryOperators.ARRAY_LENGTH, List.of(arr));
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();
 */
        assertTrue("Adapter must return a RexCall", adapted instanceof RexCall);
    private RelDataType type(SqlTypeName name, boolean nullable) {
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();
    }
        assertFalse("Outer cast preserves non-nullability", outerCast.getType().isNullable());
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
 *
        RexCall innerWidened = (RexCall) outerCast.getOperands().get(0);
        assertEquals("preconditions: original return type INTEGER", SqlTypeName.INTEGER, original.getType().getSqlTypeName());
        // A DOUBLE-returning call would not exhibit the i32/i64 schema disagreement and is out
 * Unit tests for {@link IntegerReturnWideningCastAdapter} — verifies that an
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
        assertEquals("Inner return type widened to BIGINT", SqlTypeName.BIGINT, innerCall.getType().getSqlTypeName());
        assertEquals("Inner call has the same number of operands", original.getOperands().size(), innerCall.getOperands().size());
 * to {@code CAST(fn(...) AS INTEGER)} where the inner call has return type {@code BIGINT}
    public void testSmallintReturnIsAlsoWidened() {
        // If somehow Calcite already types the call as BIGINT (e.g. a future operator with a
    /** Builds an {@code ARRAY_LENGTH(arr)} {@link RexCall} whose return type Calcite resolves to
        RexCall innerCall = (RexCall) outerCast.getOperands().get(0);
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();
public class IntegerReturnWideningCastAdapterTests extends OpenSearchTestCase {
import org.apache.calcite.rex.RexBuilder;
    public void testArrayLengthIntegerReturnIsWrappedInCasts() {
    private RexNode arrayLiteral() {
    }
        RexCall original = arrayLengthCall(arrayLiteral());
        RexCall innerCall = (RexCall) inner;
        RexNode inner = outerCast.getOperands().get(0);
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rel.type.RelDataTypeFactory;
        assertEquals("Outer return type INTEGER (matching original)", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
    private RexCall arrayLengthCall(RexNode arrOperand) {
        // array_length(arr) — outer return must remain INTEGER, inner must be widened to BIGINT,
        assertFalse("Precondition: original is non-nullable", original.getType().isNullable());
import org.apache.calcite.plan.volcano.VolcanoPlanner;
        assertSame("Already-BIGINT return passes through unchanged", original, adapted);
import org.apache.calcite.rex.RexCall;
        assertTrue("Precondition: original is nullable", original.getType().isNullable());
/*
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        RexCall outerCast = (RexCall) adapted;
        RexNode arr = arrayLiteral();
import org.apache.calcite.sql.SqlKind;
        assertSame("Re-adapting inner BIGINT-return call is a no-op", innerWidened, reAdapted);
        RexCall original = (RexCall) rexBuilder.makeCall(nonNullInt, SqlLibraryOperators.ARRAY_LENGTH, List.of(arr));
import org.apache.calcite.rex.RexNode;
        // BIGINT return-type inference), there's nothing to widen — adapter must be a no-op.
        assertFalse("Inner widened call preserves non-nullability", innerCall.getType().isNullable());
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
 * The OpenSearch Contributors require contributions made to
        RelDataType retType = type(SqlTypeName.INTEGER, true);
    }
        RexCall original = (RexCall) rexBuilder.makeCall(doubleRet, SqlLibraryOperators.ARRAY_LENGTH, List.of(arr));
        RelDataType bigintRet = type(SqlTypeName.BIGINT, true);
        RelDataType intType = type(SqlTypeName.INTEGER, false);
        RexNode arr = arrayLiteral();
        RexCall original = (RexCall) rexBuilder.makeCall(smallintRet, SqlLibraryOperators.ARRAY_LENGTH, List.of(arr));
        RexCall original = arrayLengthCall(arrayLiteral());
import org.apache.calcite.plan.RelOptCluster;
        // Nullable INTEGER return — outer CAST must produce nullable INTEGER (matching original);
        assertTrue("Inner node is a RexCall (the widened ARRAY_LENGTH)", inner instanceof RexCall);
        assertEquals("Outer return type SMALLINT (matching original)", SqlTypeName.SMALLINT, outerCast.getType().getSqlTypeName());
import org.apache.calcite.rel.type.RelDataType;
     *  {@code INTEGER NULLABLE} (matching {@code ReturnTypes.INTEGER_NULLABLE}). */
        return (RexCall) rexBuilder.makeCall(retType, SqlLibraryOperators.ARRAY_LENGTH, List.of(arrOperand));
    public void testNullabilityIsPreservedOnInnerAndOuter() {
        assertEquals("Precondition: inner is BIGINT-returning", SqlTypeName.BIGINT, innerWidened.getType().getSqlTypeName());
        RelDataType nonNullInt = type(SqlTypeName.INTEGER, false);
        RelDataType arrType = typeFactory.createArrayType(intType, -1);
        assertTrue("Inner widened call preserves nullability", innerCall.getType().isNullable());
        // the inner widened call must be nullable BIGINT.
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void testNonNullableIntegerReturnProducesNonNullableOuterCast() {
        assertEquals("Outer node is a CAST", SqlKind.CAST, outerCast.getKind());
        assertSame("Operand passed through unchanged", arr, innerCall.getOperands().get(0));
        RexNode arr = arrayLiteral();
        return rexBuilder.makeLiteral(List.of(1, 2, 3), arrType, false);
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();
    public void testBigintReturnIsUnchanged() {
        assertSame("DOUBLE-return call passes through unchanged", original, adapted);
    }
 */
        RexCall original = arrayLengthCall(arr);
}
        RexCall innerCall = (RexCall) outerCast.getOperands().get(0);
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();
 * compatible open source license.
    public void testNonIntegerReturnIsUnchanged() {
        // the rewrite to avoid infinite expansion.
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
    }
import org.opensearch.test.OpenSearchTestCase;
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);

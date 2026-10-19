    public void testArrayLengthIntegerReturnIsWrappedInCasts() {
import org.apache.calcite.sql.SqlKind;  
    public void testNonIntegerReturnIsUnchanged() {  
        // the rewrite to avoid infinite expansion.  
        RexNode arr = arrayLiteral();  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        assertEquals("Outer return type still INTEGER", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
        RexCall innerCall = (RexCall) outerCast.getOperands().get(0);
 * {@code INTEGER}-returning call (concrete example: {@code ARRAY_LENGTH(arr)}) is rewritten  
/**
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();
        assertEquals("Outer node is a CAST", SqlKind.CAST, outerCast.getKind());
 * through unchanged.  
/*  
import org.apache.calcite.plan.RelOptCluster;
        // of scope for this adapter. Adapter must pass through unchanged.
        assertFalse("Inner widened call preserves non-nullability", innerCall.getType().isNullable());
        // the inner widened call must be nullable BIGINT.  
        RelDataType retType = type(SqlTypeName.INTEGER, true);  
        assertTrue("Outer cast preserves nullability", outerCast.getType().isNullable());
    }
        assertEquals("Inner return type widened to BIGINT", SqlTypeName.BIGINT, innerCall.getType().getSqlTypeName());  
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();
        RexNode inner = outerCast.getOperands().get(0);
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        assertTrue("Inner widened call preserves nullability", innerCall.getType().isNullable());
import org.apache.calcite.rel.type.RelDataTypeFactory;
        // through both the inner widening and the outer cast unchanged.  
    }
        assertTrue("Precondition: original is nullable", original.getType().isNullable());
        assertEquals("Outer return type INTEGER (matching original)", SqlTypeName.INTEGER, outerCast.getType().getSqlTypeName());
        RelDataType smallintRet = type(SqlTypeName.SMALLINT, true);
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();  
    }
        RelDataType intType = type(SqlTypeName.INTEGER, false);
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        RexNode arr = arrayLiteral();
        RexCall innerCall = (RexCall) outerCast.getOperands().get(0);  
        // mismatches in principle), the adapter must widen it just like INTEGER.
        // Defensive: if some other call surfaces with SMALLINT return (same family of i16<->i64
import java.util.List;
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);  
        RexNode arr = arrayLiteral();  
    }
        // array_length(arr) — outer return must remain INTEGER, inner must be widened to BIGINT,
    private RexCall arrayLengthCall(RexNode arrOperand) {
        assertEquals("Inner call has the same number of operands", original.getOperands().size(), innerCall.getOperands().size());  
        RexNode arr = arrayLiteral();
        RelDataType bigintRet = type(SqlTypeName.BIGINT, true);  
    }
        assertSame("DOUBLE-return call passes through unchanged", original, adapted);
        assertEquals("Outer return type SMALLINT (matching original)", SqlTypeName.SMALLINT, outerCast.getType().getSqlTypeName());
    }
        RexCall original = (RexCall) rexBuilder.makeCall(doubleRet, SqlLibraryOperators.ARRAY_LENGTH, List.of(arr));
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
        assertTrue("Inner node is a RexCall (the widened ARRAY_LENGTH)", inner instanceof RexCall);
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();  
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
        RexCall innerCall = (RexCall) inner;  
    public void testBigintReturnIsUnchanged() {
    }
 * this file be licensed under the Apache-2.0 license or a
        RelDataType nonNullInt = type(SqlTypeName.INTEGER, false);
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(name), nullable);  
    private RelDataType type(SqlTypeName name, boolean nullable) {
 * SPDX-License-Identifier: Apache-2.0
    }  
    public void testNonNullableIntegerReturnProducesNonNullableOuterCast() {
package org.opensearch.analytics.spi;
}  
    }
        RexCall original = (RexCall) rexBuilder.makeCall(nonNullInt, SqlLibraryOperators.ARRAY_LENGTH, List.of(arr));  
        return rexBuilder.makeLiteral(List.of(1, 2, 3), arrType, false);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
 * (to match DataFusion's i64 physical), and that already-wide / non-integer returns pass
        // operand passes through unchanged.  
 * to {@code CAST(fn(...) AS INTEGER)} where the inner call has return type {@code BIGINT}
        assertSame("Already-BIGINT return passes through unchanged", original, adapted);  
import org.apache.calcite.rex.RexCall;
        RexNode arr = arrayLiteral();
        assertEquals("Precondition: inner is BIGINT-returning", SqlTypeName.BIGINT, innerWidened.getType().getSqlTypeName());  
        RexCall original = arrayLengthCall(arr);
    public void testReAdaptingInnerWidenedCallIsANoop() {  
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        // If somehow Calcite already types the call as BIGINT (e.g. a future operator with a  
 *
import org.apache.calcite.sql.type.SqlTypeName;
 * compatible open source license.
 */  
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();
        // recurses and re-visits the inner BIGINT-returning call, the return-type guard must skip
        RelDataType doubleRet = type(SqlTypeName.DOUBLE, true);
public class IntegerReturnWideningCastAdapterTests extends OpenSearchTestCase {
        RexCall innerWidened = (RexCall) outerCast.getOperands().get(0);
 * The OpenSearch Contributors require contributions made to  
 * Unit tests for {@link IntegerReturnWideningCastAdapter} — verifies that an
 */
    /** Builds an {@code ARRAY_LENGTH(arr)} {@link RexCall} whose return type Calcite resolves to  
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();
        // A DOUBLE-returning call would not exhibit the i32/i64 schema disagreement and is out
    public void testSmallintReturnIsAlsoWidened() {  
    public void testNullabilityIsPreservedOnInnerAndOuter() {
    }
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
        assertFalse("Precondition: original is non-nullable", original.getType().isNullable());
        assertSame("Re-adapting inner BIGINT-return call is a no-op", innerWidened, reAdapted);  
        RexNode reAdapted = adapter.adapt(innerWidened, List.of(), cluster);
        // Forge a non-nullable INTEGER return on the synthetic call to verify nullability flows
        assertTrue("Adapter must return a RexCall", adapted instanceof RexCall);
        // Nullable INTEGER return — outer CAST must produce nullable INTEGER (matching original);
import org.opensearch.test.OpenSearchTestCase;  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);  
        IntegerReturnWideningCastAdapter adapter = new IntegerReturnWideningCastAdapter();  
        RexCall outerCast = (RexCall) adapter.adapt(original, List.of(), cluster);
import org.apache.calcite.rex.RexBuilder;  
        // The adapter rebuilds the call as cast(fn(...) [BIGINT], INTEGER). If BackendPlanAdapter
        RexCall original = (RexCall) rexBuilder.makeCall(bigintRet, SqlLibraryOperators.ARRAY_LENGTH, List.of(arr));
        RelDataType arrType = typeFactory.createArrayType(intType, -1);  
        assertEquals("Inner return type widened to BIGINT", SqlTypeName.BIGINT, innerCall.getType().getSqlTypeName());
        assertFalse("Outer cast preserves non-nullability", outerCast.getType().isNullable());  
        RexCall innerCall = (RexCall) outerCast.getOperands().get(0);
        return (RexCall) rexBuilder.makeCall(retType, SqlLibraryOperators.ARRAY_LENGTH, List.of(arrOperand));
        RexCall original = (RexCall) rexBuilder.makeCall(smallintRet, SqlLibraryOperators.ARRAY_LENGTH, List.of(arr));
        // BIGINT return-type inference), there's nothing to widen — adapter must be a no-op.
        assertSame("Operand passed through unchanged", arr, innerCall.getOperands().get(0));
    private RexNode arrayLiteral() {
        assertSame("Inner operator is the original ARRAY_LENGTH operator", original.getOperator(), innerCall.getOperator());
        RexCall original = arrayLengthCall(arrayLiteral());
import org.apache.calcite.rel.type.RelDataType;
     *  {@code INTEGER NULLABLE} (matching {@code ReturnTypes.INTEGER_NULLABLE}). */
        RexCall original = arrayLengthCall(arrayLiteral());
        assertEquals("preconditions: original return type INTEGER", SqlTypeName.INTEGER, original.getType().getSqlTypeName());  
import org.apache.calcite.rex.RexNode;
        RexCall outerCast = (RexCall) adapted;  

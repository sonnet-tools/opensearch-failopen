            assertEquals(
                adapted.getOperands().get(i).getType().getSqlTypeName()
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        // reference — only the middle literal is rewritten.
    public void testAdaptPreservesCallReturnType() {
        return (RexCall) rexBuilder.makeCall(varcharType, SqlStdOperatorTable.SUBSTRING, List.of(field, start, len));
package org.opensearch.be.datafusion;
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0, charLiteral);
    }
            assertEquals(
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        // CASE-style or wrapper rewrites can drift the call's RelDataType; this adapter must not.
import org.apache.calcite.rex.RexBuilder;
        }
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0, charLiteral);
    private RelDataTypeFactory typeFactory;
        super.setUp();
    private final ConcatVariadicAdapter adapter = new ConcatVariadicAdapter();
    }
        assertEquals("call return type must equal the original", original.getType(), adapted.getType());
 * substrait's CONSISTENT-consistency {@code concat} extension accept Calcite's mixed FixedChar /
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        // The two scalar-function operands were already VARCHAR, so they must pass through by
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
                SqlTypeName.VARCHAR,
        // A non-nullable CHAR operand must produce a non-nullable VARCHAR cast; a nullable
    private RexCall substringCall(int fieldIndex) {
        RexNode field2 = rexBuilder.makeInputRef(varcharType, 2);
import org.apache.calcite.plan.RelOptCluster;
        // scalar-function calls (RexCall), only the middle FixedChar literal needs casting.
        // CONCAT(SUBSTRING(f0,1,3), SUBSTRING(f1,1,3)): two VARCHAR-typed scalar-function operands,
}
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 * VARCHAR operand types without rejecting the variadic call.
        assertFalse(
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
            );
        typeFactory = new JavaTypeFactoryImpl();
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        // Early-return path: if every operand is already VARCHAR, the original RexCall is returned
    private RelDataType charType;
        assertSame("operator identity must be preserved", original.getOperator(), adapted.getOperator());
        // by reference. Avoids gratuitous allocation and downstream rewrite churn.
    }
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0, field1, field2);
    public void testAdaptAllVarcharIsNoOp() {
        RexNode start = rexBuilder.makeExactLiteral(java.math.BigDecimal.ONE, intType);
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
 * compatible open source license.
import org.apache.calcite.sql.fun.SqlLibraryOperators;
 *
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
public class ConcatVariadicAdapterTests extends OpenSearchTestCase {
        varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    private RelOptCluster cluster;
            );
        RexNode charLiteral = rexBuilder.makeInputRef(charType, 1);
        RexNode len = rexBuilder.makeExactLiteral(java.math.BigDecimal.valueOf(3), intType);
 */
    }
    }
        cluster = RelOptCluster.create(planner, rexBuilder);
import org.opensearch.test.OpenSearchTestCase;
                "operand " + i + " must be VARCHAR after normalisation",
        RexNode substr1 = substringCall(1);
        RexNode charLiteral = rexBuilder.makeInputRef(charType, 2);
        assertSame("VARCHAR substring operand 2 must pass through unchanged", substr1, adapted.getOperands().get(2));
    }
        assertSame("all-VARCHAR scalar-fn operand call must pass through unchanged", original, adapted);
 * SPDX-License-Identifier: Apache-2.0
        RexNode field1 = rexBuilder.makeInputRef(varcharType, 1);
import org.apache.calcite.rex.RexNode;
        RexNode charLiteral = rexBuilder.makeInputRef(charType, 1);
        // CONCAT(varcharField, charLiteral, varcharField) — the middle operand is FixedChar/CHAR.
import org.apache.calcite.rel.type.RelDataType;
        // VARCHAR field passes through. Nullability drift would change isthmus' downstream
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, substringCall(0), substringCall(1));
import org.apache.calcite.rel.type.RelDataTypeFactory;
            "non-nullable CHAR operand must produce a non-nullable VARCHAR cast",
        }
        // by reference — substrait emission keys on operator identity, so a fresh binary CONCAT
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0, charLiteral, field2);
        RexNode field = rexBuilder.makeInputRef(varcharType, fieldIndex);
        for (int i = 0; i < adapted.getOperands().size(); i++) {
        assertSame("VARCHAR substring operand 0 must pass through unchanged", substr0, adapted.getOperands().get(0));
        // null-handling decisions.
            adapted.getOperands().get(1).getType().isNullable()
 * this file be licensed under the Apache-2.0 license or a
                SqlTypeName.VARCHAR,
/*
import org.apache.calcite.sql.type.SqlTypeName;
    }
                "operand " + i + " must be VARCHAR after normalisation",
import org.apache.calcite.plan.hep.HepProgramBuilder;
    /** {@code SUBSTRING(field#idx, 1, 3)} typed VARCHAR — a RexCall operand for concat. */
        // Every operand must be VARCHAR after the rewrite.
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        // would route to the wrong substrait extension.
        RexNode substr0 = substringCall(0);
    public void setUp() throws Exception {
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
 * The OpenSearch Contributors require contributions made to
        RexNode charLiteral = rexBuilder.makeInputRef(nonNullableChar, 1);
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0, charLiteral);
        assertSame("all-VARCHAR call must pass through unchanged", original, adapted);
import org.apache.calcite.plan.hep.HepPlanner;
        );
    }
        rexBuilder = new RexBuilder(typeFactory);
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
                adapted.getOperands().get(i).getType().getSqlTypeName()
        for (int i = 0; i < adapted.getOperands().size(); i++) {
 * Unit tests for {@link ConcatVariadicAdapter}. Pins the type-normalisation contract that lets
    private RelDataType varcharType;
/**
        RexNode field2 = rexBuilder.makeInputRef(varcharType, 2);
    public void testAdaptTwoScalarFunctionOperandsIsNoOp() {
        assertSame("operator identity must be preserved", original.getOperator(), adapted.getOperator());
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void testAdaptPreservesNullabilityWhenCasting() {
import org.apache.calcite.rex.RexCall;
    }
        // nothing to cast, so the original call passes through by reference.
    private RexBuilder rexBuilder;
    public void testAdaptCastsFixedCharOperandToVarchar() {
import java.util.List;
 */
        // CONCAT(SUBSTRING(f0,1,3), charLiteral, SUBSTRING(f1,1,3)): the outer operands are
        charType = typeFactory.createSqlType(SqlTypeName.CHAR, 5);
    public void testAdaptPreservesOperatorIdentity() {
    @Override
        RexNode charLiteral = rexBuilder.makeInputRef(charType, 1);
    public void testAdaptCastsCharLiteralBetweenScalarFunctionOperands() {
        // The rewritten call must keep the original SqlLibraryOperators.CONCAT_FUNCTION operator
        assertNotSame("CHAR literal operand must be rewritten to a VARCHAR cast", charLiteral, adapted.getOperands().get(1));
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
        RelDataType nonNullableChar = typeFactory.createTypeWithNullability(charType, false);
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, substr0, charLiteral, substr1);

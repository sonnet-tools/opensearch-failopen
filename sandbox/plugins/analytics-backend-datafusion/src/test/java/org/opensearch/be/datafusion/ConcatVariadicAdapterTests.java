    }
        // CONCAT(varcharField, charLiteral, varcharField) — the middle operand is FixedChar/CHAR.
        RexNode charLiteral = rexBuilder.makeInputRef(charType, 1);
import org.apache.calcite.rex.RexBuilder;
        rexBuilder = new RexBuilder(typeFactory);  
        RexNode charLiteral = rexBuilder.makeInputRef(charType, 1);  
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
    }
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
    private RelDataType charType;
        RexNode field1 = rexBuilder.makeInputRef(varcharType, 1);
        RexNode field2 = rexBuilder.makeInputRef(varcharType, 2);
        charType = typeFactory.createSqlType(SqlTypeName.CHAR, 5);
                adapted.getOperands().get(i).getType().getSqlTypeName()  
public class ConcatVariadicAdapterTests extends OpenSearchTestCase {
        }
    private RelOptCluster cluster;
        return (RexCall) rexBuilder.makeCall(varcharType, SqlStdOperatorTable.SUBSTRING, List.of(field, start, len));
    }  
        // The two scalar-function operands were already VARCHAR, so they must pass through by
            );
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
/**
/*  
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0, charLiteral);
    private RelDataType varcharType;  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);  
        assertSame("all-VARCHAR scalar-fn operand call must pass through unchanged", original, adapted);
        RexNode start = rexBuilder.makeExactLiteral(java.math.BigDecimal.ONE, intType);
 * The OpenSearch Contributors require contributions made to  
                "operand " + i + " must be VARCHAR after normalisation",
    }  
    public void testAdaptTwoScalarFunctionOperandsIsNoOp() {  
        // nothing to cast, so the original call passes through by reference.
        cluster = RelOptCluster.create(planner, rexBuilder);
    }
            );  
        RexNode charLiteral = rexBuilder.makeInputRef(charType, 2);  
        );
    @Override
 * SPDX-License-Identifier: Apache-2.0
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
 */  
        // reference — only the middle literal is rewritten.  
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0, charLiteral, field2);  
        // CONCAT(SUBSTRING(f0,1,3), SUBSTRING(f1,1,3)): two VARCHAR-typed scalar-function operands,
import org.apache.calcite.plan.RelOptCluster;
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);  
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        RexNode field2 = rexBuilder.makeInputRef(varcharType, 2);  
        // The rewritten call must keep the original SqlLibraryOperators.CONCAT_FUNCTION operator  
        assertSame("VARCHAR substring operand 0 must pass through unchanged", substr0, adapted.getOperands().get(0));
 * compatible open source license.
        for (int i = 0; i < adapted.getOperands().size(); i++) {
import org.apache.calcite.rex.RexCall;
    private RexCall substringCall(int fieldIndex) {
    private RelDataTypeFactory typeFactory;  
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0, field1, field2);
import org.apache.calcite.sql.fun.SqlLibraryOperators;
    public void testAdaptAllVarcharIsNoOp() {
import org.apache.calcite.plan.hep.HepProgramBuilder;
        // VARCHAR field passes through. Nullability drift would change isthmus' downstream
 * substrait's CONSISTENT-consistency {@code concat} extension accept Calcite's mixed FixedChar /
        RexNode charLiteral = rexBuilder.makeInputRef(charType, 1);
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);  
    public void testAdaptPreservesNullabilityWhenCasting() {
            assertEquals(
        assertNotSame("CHAR literal operand must be rewritten to a VARCHAR cast", charLiteral, adapted.getOperands().get(1));  
    public void setUp() throws Exception {  
        assertSame("operator identity must be preserved", original.getOperator(), adapted.getOperator());  
        // scalar-function calls (RexCall), only the middle FixedChar literal needs casting.
 */  
        // CASE-style or wrapper rewrites can drift the call's RelDataType; this adapter must not.
import org.apache.calcite.rel.type.RelDataType;
        // by reference. Avoids gratuitous allocation and downstream rewrite churn.  
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, substr0, charLiteral, substr1);
        assertSame("VARCHAR substring operand 2 must pass through unchanged", substr1, adapted.getOperands().get(2));
            assertEquals(  
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        typeFactory = new JavaTypeFactoryImpl();
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0, charLiteral);
import org.apache.calcite.plan.hep.HepPlanner;  
    }
            "non-nullable CHAR operand must produce a non-nullable VARCHAR cast",
package org.opensearch.be.datafusion;
    public void testAdaptCastsCharLiteralBetweenScalarFunctionOperands() {
        assertSame("operator identity must be preserved", original.getOperator(), adapted.getOperator());  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
    }
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
                "operand " + i + " must be VARCHAR after normalisation",  
        RexNode len = rexBuilder.makeExactLiteral(java.math.BigDecimal.valueOf(3), intType);  
    private final ConcatVariadicAdapter adapter = new ConcatVariadicAdapter();  
    /** {@code SUBSTRING(field#idx, 1, 3)} typed VARCHAR — a RexCall operand for concat. */
import org.opensearch.test.OpenSearchTestCase;
        }
            adapted.getOperands().get(1).getType().isNullable()  
        super.setUp();
                adapted.getOperands().get(i).getType().getSqlTypeName()
        // null-handling decisions.
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode charLiteral = rexBuilder.makeInputRef(nonNullableChar, 1);
        // by reference — substrait emission keys on operator identity, so a fresh binary CONCAT
        varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
        assertEquals("call return type must equal the original", original.getType(), adapted.getType());
        assertSame("all-VARCHAR call must pass through unchanged", original, adapted);
                SqlTypeName.VARCHAR,
import org.apache.calcite.rex.RexNode;  
    public void testAdaptPreservesOperatorIdentity() {
        // Every operand must be VARCHAR after the rewrite.
 *
        RelDataType nonNullableChar = typeFactory.createTypeWithNullability(charType, false);  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);  
                SqlTypeName.VARCHAR,
        RexNode substr0 = substringCall(0);
 * VARCHAR operand types without rejecting the variadic call.
        for (int i = 0; i < adapted.getOperands().size(); i++) {
    }
        // CONCAT(SUBSTRING(f0,1,3), charLiteral, SUBSTRING(f1,1,3)): the outer operands are  
        assertFalse(
        // would route to the wrong substrait extension.
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void testAdaptPreservesCallReturnType() {  
        // Early-return path: if every operand is already VARCHAR, the original RexCall is returned
    }  
        RexNode substr1 = substringCall(1);
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, substringCall(0), substringCall(1));  
    public void testAdaptCastsFixedCharOperandToVarchar() {
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
}  
import org.apache.calcite.sql.type.SqlTypeName;  
        RexNode field = rexBuilder.makeInputRef(varcharType, fieldIndex);  
    private RexBuilder rexBuilder;
 * Unit tests for {@link ConcatVariadicAdapter}. Pins the type-normalisation contract that lets  
import java.util.List;  
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0, charLiteral);  
        // A non-nullable CHAR operand must produce a non-nullable VARCHAR cast; a nullable  

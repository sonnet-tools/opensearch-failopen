    private RelOptCluster cluster;
    }  
 * SPDX-License-Identifier: Apache-2.0
        RexNode lhs = rexBuilder.makeExactLiteral(BigDecimal.valueOf(5), typeFactory.createSqlType(SqlTypeName.INTEGER));
 *
        assertEquals(SqlKind.MOD, innerModCall.getKind());  
        super.setUp();  
        RexNode rhs = rexBuilder.makeExactLiteral(BigDecimal.valueOf(3), typeFactory.createSqlType(SqlTypeName.INTEGER));
import org.apache.calcite.plan.hep.HepPlanner;  
import java.util.List;
import org.apache.calcite.rel.type.RelDataType;
        RexCall caseCall = (RexCall) adapted;  
        RexNode rhs = rexBuilder.makeExactLiteral(BigDecimal.ZERO, typeFactory.createSqlType(SqlTypeName.INTEGER));  
        assertTrue(adapted instanceof RexCall);
import org.apache.calcite.rex.RexNode;  
        assertEquals(SqlKind.CASE, caseCall.getKind());
import org.apache.calcite.rex.RexBuilder;
        );
        assertEquals(
    private RexCall buildMod(RexNode lhs, RexNode rhs) {
        RexCall innerModCall = (RexCall) innerMod;
 * {@code CASE WHEN y = 0 THEN NULL ELSE MOD(x, y) END} so {@code mod(x, 0)} yields NULL.
        assertTrue(caseCall.getType().isNullable());
        RexNode modBranch = caseCall.getOperands().get(2);
        rexBuilder = new RexBuilder(typeFactory);
            innerModCall.getOperands().get(1).getType().getSqlTypeName()  
        typeFactory = new JavaTypeFactoryImpl();
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
        RexNode adapted = new ModAdapter().adapt(original, List.of(), cluster);  
        RexNode lhs = rexBuilder.makeApproxLiteral(BigDecimal.valueOf(5.5), typeFactory.createSqlType(SqlTypeName.FLOAT));
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RexCall original = buildMod(lhs, rhs);  
import org.apache.calcite.plan.RelOptCluster;
    @Override
        cluster = RelOptCluster.create(planner, rexBuilder);
    }
        RexCall original = buildMod(lhs, rhs);  
        RexCall original = buildMod(lhs, rhs);  
        RexNode innerMod = modBranch instanceof RexCall mc && mc.getKind() != SqlKind.MOD ? mc.getOperands().get(0) : modBranch;  
    public void testColumnRefDivisorWrapsInCase() {
        assertTrue(adapted instanceof RexCall);
    private RelDataTypeFactory typeFactory;  
    /** Non-zero literal divisor still gets the CASE wrap (unconditional, unlike DivideAdapter). */
    public void testLiteralZeroDivisorWrapsInCase() {
    public void testMixedNumericOperandsWidenToCommonType() {  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    /** Column-ref divisor → CASE wrap (zero unknown until runtime). */
    }  
 * this file be licensed under the Apache-2.0 license or a
        RelDataType intNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);  
        RexNode adapted = new ModAdapter().adapt(original, List.of(), cluster);
        RelDataType retType = typeFactory.createTypeWithNullability(lhs.getType(), true);
import org.apache.calcite.sql.type.SqlTypeName;  
 * Tests for {@link ModAdapter}. Wraps every {@code MOD(x, y)} in
        RexNode lhs = rexBuilder.makeExactLiteral(BigDecimal.valueOf(5), typeFactory.createSqlType(SqlTypeName.INTEGER));
    }
        RexNode adapted = new ModAdapter().adapt(original, List.of(), cluster);
        RexCall original = buildMod(lhs, rhs);
        assertTrue(adapted instanceof RexCall);
        RexCall caseCall = (RexCall) adapted;
import org.apache.calcite.sql.SqlKind;
/*  
import org.opensearch.test.OpenSearchTestCase;
        RexNode rhs = rexBuilder.makeExactLiteral(BigDecimal.valueOf(2), typeFactory.createSqlType(SqlTypeName.INTEGER));
    public void testNonZeroLiteralDivisorAlsoWrapsInCase() {  
        RexNode rhs = rexBuilder.makeInputRef(intNullable, 0);
        // CASE then-arm is the third operand; may be wrapped in a CAST for nullability.
    /** Mixed-numeric operands (e.g. FLOAT % INTEGER) widen to a common type before MOD. */
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexNode adapted = new ModAdapter().adapt(original, List.of(), cluster);
        return (RexCall) rexBuilder.makeCall(retType, SqlStdOperatorTable.MOD, List.of(lhs, rhs));  
        assertTrue(innerMod instanceof RexCall);
        assertTrue(adapted instanceof RexCall);
public class ModAdapterTests extends OpenSearchTestCase {
        RexNode lhs = rexBuilder.makeExactLiteral(BigDecimal.valueOf(5), typeFactory.createSqlType(SqlTypeName.INTEGER));
    }  
package org.opensearch.be.datafusion;
    public void setUp() throws Exception {
    private RexBuilder rexBuilder;
 * The OpenSearch Contributors require contributions made to  
 */  
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
}
/**  
    /** Literal-zero divisor → CASE wrap. */  
 * compatible open source license.
        assertEquals(SqlKind.CASE, caseCall.getKind());  
            innerModCall.getOperands().get(0).getType().getSqlTypeName(),
        assertEquals(SqlKind.CASE, ((RexCall) adapted).getKind());
 */  
import java.math.BigDecimal;  
        assertEquals(SqlKind.CASE, ((RexCall) adapted).getKind());
    }

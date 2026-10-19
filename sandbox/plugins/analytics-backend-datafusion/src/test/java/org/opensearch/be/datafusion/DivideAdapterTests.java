import org.apache.calcite.plan.hep.HepPlanner;  
    public void testNonZeroLiteralDivisorSkipsCaseWrap() {
}  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        rexBuilder = new RexBuilder(typeFactory);  
import org.apache.calcite.rex.RexBuilder;
    public void testColumnRefDivisorWrapsInCase() {
        cluster = RelOptCluster.create(planner, rexBuilder);
 * {@code CASE WHEN y = 0 THEN NULL ELSE DIVIDE(x, y) END} so divide-by-zero
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.plan.RelOptCluster;
    }
        RexNode rhs = rexBuilder.makeExactLiteral(BigDecimal.ZERO, typeFactory.createSqlType(SqlTypeName.INTEGER));
        assertEquals(SqlKind.CASE, ((RexCall) adapted).getKind());  
        RexNode lhs = rexBuilder.makeExactLiteral(BigDecimal.valueOf(22), typeFactory.createSqlType(SqlTypeName.INTEGER));  
    /** Column-ref divisor → CASE wrap (zero unknown until runtime). */  
        assertTrue(adapted instanceof RexCall);  
        RelDataType intNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
    }
import java.util.List;
        RexNode adapted = new DivideAdapter().adapt(original, List.of(), cluster);  
    }
    public void setUp() throws Exception {  
        RexNode adapted = new DivideAdapter().adapt(original, List.of(), cluster);  
import org.apache.calcite.rex.RexCall;
        assertEquals(SqlKind.DIVIDE, ((RexCall) adapted).getKind());  
    }
        return (RexCall) rexBuilder.makeCall(retType, SqlStdOperatorTable.DIVIDE, List.of(lhs, rhs));
import org.opensearch.test.OpenSearchTestCase;
    private RelOptCluster cluster;  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(SqlKind.CASE, ((RexCall) adapted).getKind());
        RexCall caseCall = (RexCall) adapted;
        assertTrue(adapted instanceof RexCall);
        RexNode rhs = rexBuilder.makeExactLiteral(BigDecimal.valueOf(5), typeFactory.createSqlType(SqlTypeName.INTEGER));  
        RexCall original = buildDivide(lhs, rhs);
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.rex.RexNode;  
    public void testLiteralZeroIntegerDivisorWrapsInCase() {
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.rel.type.RelDataType;
        RexNode adapted = new DivideAdapter().adapt(original, List.of(), cluster);
import org.apache.calcite.sql.type.SqlTypeName;  
 */
        RexCall original = buildDivide(lhs, rhs);
    /** Literal-zero DOUBLE divisor → CASE wrap. */  
        assertEquals(SqlKind.CASE, caseCall.getKind());
    /** Non-zero literal divisor → bare DIVIDE (skip the wrap). */  
public class DivideAdapterTests extends OpenSearchTestCase {
/**  
    private RexBuilder rexBuilder;
/*  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
 * this file be licensed under the Apache-2.0 license or a
        RexNode adapted = new DivideAdapter().adapt(original, List.of(), cluster);
 * yields NULL. Skips the wrap for known non-zero literal divisors.  
    }  
 */  
        RexNode lhs = rexBuilder.makeExactLiteral(BigDecimal.valueOf(22), typeFactory.createSqlType(SqlTypeName.INTEGER));
package org.opensearch.be.datafusion;
    /** Literal-zero INTEGER divisor → CASE wrap. */
        RexNode rhs = rexBuilder.makeInputRef(intNullable, 0);
    public void testLiteralZeroDoubleDivisorWrapsInCase() {
        RexCall original = buildDivide(lhs, rhs);
        super.setUp();
        assertTrue(caseCall.getType().isNullable());  
        RexNode lhs = rexBuilder.makeExactLiteral(BigDecimal.valueOf(22), typeFactory.createSqlType(SqlTypeName.INTEGER));  
    }
import org.apache.calcite.plan.hep.HepProgramBuilder;
 *
    @Override
import java.math.BigDecimal;  
        RexCall original = buildDivide(lhs, rhs);
        assertTrue(adapted instanceof RexCall);
    private RelDataTypeFactory typeFactory;
        RelDataType retType = typeFactory.createTypeWithNullability(lhs.getType(), true);  
        RexNode rhs = rexBuilder.makeApproxLiteral(BigDecimal.ZERO, typeFactory.createSqlType(SqlTypeName.DOUBLE));  
        RexNode lhs = rexBuilder.makeApproxLiteral(BigDecimal.valueOf(22.0), typeFactory.createSqlType(SqlTypeName.DOUBLE));
    private RexCall buildDivide(RexNode lhs, RexNode rhs) {
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        assertTrue(adapted instanceof RexCall);  
 * Tests for {@link DivideAdapter}. Wraps {@code DIVIDE(x, y)} in

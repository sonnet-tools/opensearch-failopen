        RexNode arg3 = new RexInputRef(2, stringType);
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.sql.type.SqlTypeName;
    public void testNumericValueIsCoercedToVarchar() {
        RexNode valueRef = new RexInputRef(0, stringType);  
        assertEquals("ctime", out.getOperator().getName());  
 * Unit tests for {@link TimeConversionFunctionAdapter}. Verifies:
        ReturnTypes.VARCHAR_NULLABLE,
        assertEquals(2, out.getOperands().size());  
        RexNode rewritten = new TimeConversionFunctionAdapter(TimeConversionFunctionAdapter.CTIME).adapt(original, List.of(), cluster);  
 *   <li>Return type (VARCHAR for ctime, DOUBLE for mktime) is preserved.</li>
 *       2-arg call with the default format literal filled in.</li>
        OperandTypes.family(),  
    public void testWrongArityPassesThrough() {  
import org.apache.calcite.rel.type.RelDataType;
 *   <li>Numeric value operands are coerced to VARCHAR</li>
/**
        assertEquals(SqlTypeName.VARCHAR, normalized.getType().getSqlTypeName());
import org.opensearch.test.OpenSearchTestCase;  
import org.apache.calcite.rex.RexNode;
        RexCall original = (RexCall) cluster.getRexBuilder().makeCall(PPL_UNARY, List.of(valueRef));
        RexNode rewritten = new TimeConversionFunctionAdapter(TimeConversionFunctionAdapter.CTIME).adapt(threeArg, List.of(), cluster);
        assertEquals(2, out.getOperands().size());
        assertSame(threeArg, rewritten);
        RelOptCluster cluster = cluster();  
        RexNode arg2 = new RexInputRef(1, stringType);
        RexCall out = (RexCall) rewritten;
 * <ul>  
import java.util.List;
    /** Numeric value operand gets wrapped in CAST(x AS VARCHAR). */
        SqlFunctionCategory.USER_DEFINED_FUNCTION
 *   <li>Binary PPL calls pass the user-supplied format through unchanged.</li>  
import org.apache.calcite.rex.RexBuilder;
    public void testBinaryMktimePreservesExplicitFormat() {
        RexNode valueRef = new RexInputRef(0, stringType);  
 *
        assertEquals(TimeConversionFunctionAdapter.DEFAULT_FORMAT, formatLit.getValueAs(String.class));  
    private RelOptCluster cluster() {
package org.opensearch.be.datafusion.planner.adapter;
 */  
 *   <li>Unary PPL calls ({@code ctime(value)} / {@code mktime(value)}) are rewritten to a
        ReturnTypes.VARCHAR_NULLABLE,
    /** Explicit format operand is forwarded unchanged. */  
        assertSame("explicit format literal must be forwarded verbatim", formatLit, out.getOperands().get(1));
import org.apache.calcite.rex.RexInputRef;  
        RelDataType stringType = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
        RelDataType stringType = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
}  
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        RexNode formatLit = cluster.getRexBuilder().makeLiteral("%Y-%m-%d");
        RelOptCluster cluster = cluster();
        SqlKind.OTHER_FUNCTION,  
        RexCall out = (RexCall) rewritten;
        RexNode rewritten = new TimeConversionFunctionAdapter(TimeConversionFunctionAdapter.MKTIME).adapt(original, List.of(), cluster);  
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexCall original = (RexCall) cluster.getRexBuilder().makeCall(PPL_UNARY, List.of(valueRef));
import org.apache.calcite.sql.type.ReturnTypes;
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
/*  
    }
        assertEquals("mktime", out.getOperator().getName());
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.SqlKind;
        RelDataType stringType = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);  
    private static final SqlFunction PPL_BINARY = new SqlFunction(
        RexCall original = (RexCall) cluster.getRexBuilder().makeCall(PPL_UNARY, List.of(epochSeconds));  
        RelDataType stringType = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
        OperandTypes.family(),  
    /** ctime(value) with no explicit format → rewritten to ctime(value, "%m/%d/%Y %H:%M:%S"). */
    }  
        RelOptCluster cluster = cluster();
    }
import org.apache.calcite.rex.RexLiteral;
        "ppl_unary",
import org.apache.calcite.plan.hep.HepPlanner;  
        RelOptCluster cluster = cluster();
        null,
    /** Calls with 0 or 3+ operands pass through */
public class TimeConversionFunctionAdapterTests extends OpenSearchTestCase {
        RexLiteral formatLit = (RexLiteral) out.getOperands().get(1);
 */
    }  
        assertEquals(SqlKind.CAST, ((RexCall) normalized).getKind());
import org.apache.calcite.sql.type.OperandTypes;  
    }
        SqlKind.OTHER_FUNCTION,  
import org.apache.calcite.plan.RelOptCluster;
        RexCall threeArg = (RexCall) cluster.getRexBuilder().makeCall(PPL_BINARY, List.of(arg1, arg2, arg3));  
        RexCall original = (RexCall) cluster.getRexBuilder().makeCall(PPL_BINARY, List.of(valueRef, formatLit));  
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        RexNode arg1 = new RexInputRef(0, stringType);  
        RelDataType bigintType = cluster.getTypeFactory().createSqlType(SqlTypeName.BIGINT);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        "ppl_binary",
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
        RexNode valueRef = new RexInputRef(0, stringType);
        null,
 * compatible open source license.
    );
    /** Return type stays aligned with the enclosing Project's cached rowType. */
        return RelOptCluster.create(planner, rexBuilder);
        RexNode epochSeconds = new RexInputRef(0, bigintType);
        RexNode rewritten = new TimeConversionFunctionAdapter(TimeConversionFunctionAdapter.MKTIME).adapt(original, List.of(), cluster);
    }  
 * </ul>  
import org.apache.calcite.sql.SqlFunction;  
        RelOptCluster cluster = cluster();
import org.apache.calcite.sql.SqlFunctionCategory;
        assertEquals(original.getType(), rewritten.getType());
        RexNode normalized = out.getOperands().get(0);
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rex.RexCall;
    public void testUnaryCtimeFillsInDefaultFormat() {  
    private static final SqlFunction PPL_UNARY = new SqlFunction(
    public void testReturnTypePreserved() {  
        RexNode rewritten = new TimeConversionFunctionAdapter(TimeConversionFunctionAdapter.CTIME).adapt(original, List.of(), cluster);
        RexCall out = (RexCall) rewritten;
        assertTrue("numeric operand must be wrapped in a CAST, got " + normalized, normalized instanceof RexCall);  
    );

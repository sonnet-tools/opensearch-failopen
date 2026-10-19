    public void testNonVarcharTargetCastIsUntouched() {
    /** Casts whose target is not VARCHAR (e.g. IpType → BIGINT) pass through. */  
/**  
import org.opensearch.test.OpenSearchTestCase;
    public void testSafeCastIpToVarcharIsRewritten() {
        RexCall call = (RexCall) result;
        typeFactory = new JavaTypeFactoryImpl();  
        assertEquals(varcharType, call.getType());
        RexCall cast = (RexCall) rexBuilder.makeCast(varcharType, column);  
     * PPL's {@code cast(host AS STRING)} lowers via  
    private RelOptCluster cluster;  
    public void setUp() throws Exception {
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.rex.RexBuilder;
        assertSame("INTEGER → VARCHAR cast must round-trip identical", cast, result);  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        RexNode column = new RexInputRef(0, ipType);
 * SPDX-License-Identifier: Apache-2.0
        rexBuilder = new RexBuilder(typeFactory);
    public void testPlainVarbinaryCastIsUntouched() {
 */
        RexCall cast = (RexCall) rexBuilder.makeCast(varcharType, column);  
 * </ul>  
 *   <li>{@code SAFE_CAST(<IpType>)} (PPL emits SAFE_CAST for {@code cast(... AS STRING)})  
        RexCall cast = (RexCall) rexBuilder.makeCast(varcharType, column);
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
        assertSame("Operator must be IP_TO_STRING_OP", IpBinaryCastFunctionAdapter.IP_TO_STRING_OP, call.getOperator());  
        RelDataType ipType = new IpType(true);
        RexNode result = adapter.adapt(cast, List.of(), cluster);
     */  
     * Plain VARBINARY (no UDT) source casts pass through — the adapter is
     * {@code rexBuilder.makeCast(varchar, expr, true, true)} — the {@code safe=true}
        RexCall call = (RexCall) result;
        assertSame("SAFE_CAST(<IpType>) must rewrite to IP_TO_STRING_OP", IpBinaryCastFunctionAdapter.IP_TO_STRING_OP, call.getOperator());  
        RexNode column = new RexInputRef(0, ipType);
 */  
        RexNode column = new RexInputRef(0, ipType);
 *       &rarr; same rewrite as CAST.
    private RexBuilder rexBuilder;
        RexNode result = adapter.adapt(cast, List.of(), cluster);  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    @Override  
        RelDataType ipType = new IpType(true);
/*  
     * flag produces a {@link org.apache.calcite.sql.SqlKind#SAFE_CAST} call. The
 *   <li>Anything else (non-VARCHAR target, non-UDT source) &rarr; {@code original} unchanged.
     * {@link DataFusionAnalyticsBackendPlugin}; this test exercises the SAFE_CAST
        assertTrue("Expected RexCall after rewrite, got " + result.getClass(), result instanceof RexCall);
import org.opensearch.analytics.schema.IpType;
        RexNode result = adapter.adapt(cast, List.of(), cluster);
        RelDataType varbinaryType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARBINARY), true);
}
        RexNode result = adapter.adapt(cast, List.of(), cluster);
public class IpBinaryCastFunctionAdapterTests extends OpenSearchTestCase {
 * compatible open source license.
import org.opensearch.analytics.schema.BinaryType;  
        RexCall cast = (RexCall) rexBuilder.makeCast(varcharType, column);  
     * path explicitly.
        RexNode column = new RexInputRef(0, binType);  
     * adapter is registered for both CAST and SAFE_CAST in  
 *
import org.apache.calcite.rex.RexCall;
    public void testIntegerCastIsUntouched() {
    /** Plain INTEGER source → VARCHAR cast passes through (DataFusion handles it natively). */  
        assertSame("Plain VARBINARY (no UDT) cast must round-trip identical", cast, result);  
        RelDataType intType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
 *
import java.util.List;
package org.opensearch.be.datafusion;
    }
import org.apache.calcite.plan.hep.HepPlanner;  
    }  
        RexNode column = new RexInputRef(0, intType);
    public void testBinaryCastIsRewrittenToBinaryToBase64() {
     */  
 *   <li>{@code CAST(<IpType> AS VARCHAR)} &rarr; {@code IP_TO_STRING_OP(col)} call.
        cluster = RelOptCluster.create(planner, rexBuilder);  
        RelDataType ipType = new IpType(true);
    /**
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        RexCall call = (RexCall) result;
        RexNode column = new RexInputRef(0, varbinaryType);
    public void testIpCastIsRewrittenToIpToString() {
        assertSame(IpBinaryCastFunctionAdapter.BINARY_TO_BASE64_OP, call.getOperator());  
import org.apache.calcite.rex.RexInputRef;  
    private RelDataTypeFactory typeFactory;
    /**  
import org.apache.calcite.rex.RexNode;
        assertEquals("Operand must be the original source column", column.toString(), call.getOperands().get(0).toString());
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    }
     * source-type-discriminating, not target-type-blanket.
 * <ul>  
 * Verifies the conditional dispatch in {@link IpBinaryCastFunctionAdapter}:
        adapter = new IpBinaryCastFunctionAdapter();
 *   <li>{@code CAST(<BinaryType> AS VARCHAR)} &rarr; {@code BINARY_TO_BASE64_OP(col)} call.
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
        RexCall safeCast = (RexCall) rexBuilder.makeCast(varcharType, column, true, true);
import org.apache.calcite.plan.RelOptCluster;
        RexCall cast = (RexCall) rexBuilder.makeCast(bigintType, column);  
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
        assertEquals(column.toString(), call.getOperands().get(0).toString());
        // matchNullability=true, safe=true → SAFE_CAST RexCall.  
    }  
    }
    private IpBinaryCastFunctionAdapter adapter;
    }
        RexNode result = adapter.adapt(safeCast, List.of(), cluster);  
        RexNode result = adapter.adapt(cast, List.of(), cluster);
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
        super.setUp();
    }
        assertEquals("Result type must remain VARCHAR", varcharType, call.getType());
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.apache.calcite.rel.type.RelDataType;
        assertSame("Non-VARCHAR target must round-trip identical", cast, result);  
        RelDataType binType = new BinaryType(true);  
        RelDataType bigintType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);  

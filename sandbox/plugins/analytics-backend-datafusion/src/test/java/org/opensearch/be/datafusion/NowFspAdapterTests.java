    private RelOptCluster cluster;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
 * the {@code fsp} operand and emits the substrait-mapped {@link DateTimeAdapters#LOCAL_NOW_OP},  
        assertTrue("no operands on niladic now()", call.getOperands().isEmpty());
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    public void testNiladicNowRoutedToLocalNowOp() {  
    }
        assertSame("operator must be local now()", DateTimeAdapters.LOCAL_NOW_OP, call.getOperator());
 */  
    }
        RexCall original = (RexCall) rexBuilder.makeCall(timestampType, nowUdf, List.of());
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.sql.SqlKind;
    private SqlUserDefinedFunction nowUdf;
        RexCall original = (RexCall) rexBuilder.makeCall(timestampType, nowUdf, List.of(fsp));
        RexCall original = (RexCall) rexBuilder.makeCall(timestampType, nowUdf, List.of(a, b));  
        cluster = RelOptCluster.create(planner, rexBuilder);  
import org.apache.calcite.sql.SqlIdentifier;
        typeFactory = new JavaTypeFactoryImpl();  
    public void testUnexpectedArityLeftUntouched() {
        assertTrue("expected a RexCall", adapted instanceof RexCall);
import org.apache.calcite.plan.hep.HepProgramBuilder;
    public void testFspOperandDropped() {  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.sql.parser.SqlParserPos;  
/*  
import org.apache.calcite.plan.hep.HepPlanner;  
        assertSame("operator must be the substrait-mapped local now()", DateTimeAdapters.LOCAL_NOW_OP, call.getOperator());
    @Override  
import org.apache.calcite.sql.validate.SqlUserDefinedFunction;  
    public void setUp() throws Exception {
import org.apache.calcite.rex.RexBuilder;
 *
        RexNode a = rexBuilder.makeLiteral(1, typeFactory.createSqlType(SqlTypeName.INTEGER), false);
}  
 * precision argument that DataFusion's niladic {@code now()} cannot express. The adapter drops
 * {@code current_timestamp} / {@code sysdate} synonyms) accept an optional fractional-seconds
        rexBuilder = new RexBuilder(typeFactory);
            new SqlIdentifier("NOW", SqlParserPos.ZERO),  
        assertSame("adapter must not invent a valid shape from a 2-arg call", original, adapted);
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rex.RexNode;  
        RexCall call = (RexCall) adapted;  
            null,  
    }
 * Unit tests for {@link NowFspAdapter}. PPL {@code now([fsp])} (and its  
            null,
import org.apache.calcite.rel.type.RelDataType;
            SqlKind.OTHER_FUNCTION,
        assertEquals("return type preserved", SqlTypeName.TIMESTAMP, call.getType().getSqlTypeName());  
        super.setUp();
            ReturnTypes.TIMESTAMP,
/**
        assertTrue("fsp operand must be dropped so DataFusion's niladic now() binds", call.getOperands().isEmpty());
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.sql.type.SqlTypeName;
            null
        RexNode adapted = new NowFspAdapter().adapt(original, List.of(), cluster);  
        );  
        RexNode fsp = rexBuilder.makeLiteral(3, typeFactory.createSqlType(SqlTypeName.INTEGER), false);
        RexNode b = rexBuilder.makeLiteral(2, typeFactory.createSqlType(SqlTypeName.INTEGER), false);
import org.apache.calcite.plan.RelOptCluster;
 */  
        RexNode adapted = new NowFspAdapter().adapt(original, List.of(), cluster);
public class NowFspAdapterTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
        RexCall call = (RexCall) adapted;  
package org.opensearch.be.datafusion;
    }  
    private RelDataTypeFactory typeFactory;  
        nowUdf = new SqlUserDefinedFunction(
    private RelDataType timestampType;  
 * so {@code now(3)} ≡ {@code now()} (matching the SQL-plugin reference) instead of failing
import org.apache.calcite.sql.type.ReturnTypes;
        RexNode adapted = new NowFspAdapter().adapt(original, List.of(), cluster);
        timestampType = typeFactory.createSqlType(SqlTypeName.TIMESTAMP);
 * fragment conversion with {@code Unable to convert call now(i32)}.
    private RexBuilder rexBuilder;
 * compatible open source license.
        // now() / now(fsp) are the only valid shapes; a 2-arg call must not be normalised into now().  
import java.util.List;  
 * this file be licensed under the Apache-2.0 license or a

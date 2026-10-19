}
import org.apache.calcite.sql.type.ReturnTypes;
 * compatible open source license.
        return outCall;
        RexNode[] sources = new RexNode[] {
 */  
                SqlTypeName.DOUBLE,  
        RexCall out = assertStrftimeCall(adapter.adapt(call, List.of(), c.cluster));
        SqlKind.OTHER_FUNCTION,
    );  
            c.intLiteral(1521467703),  
            this.typeFactory = typeFactory;  
                "source widened to DOUBLE: " + src.getType().getSqlTypeName(),
        RexNode out = adapter.adapt(call, List.of(), c.cluster);  
            assertEquals(
        assertTrue("expected a RexCall, got " + out.getClass(), out instanceof RexCall);
            outCall.getOperator()
            return rexBuilder.makeExactLiteral(BigDecimal.valueOf(value), intType);  
import org.apache.calcite.sql.SqlKind;  
        RexCall outCall = (RexCall) out;  
import java.util.List;
import org.apache.calcite.sql.SqlFunction;
    /** DOUBLE/TIMESTAMP/DATE operands forward by identity (Rust coerce_types canonicalizes). */  
        }  
        return new Cluster(RelOptCluster.create(planner, rexBuilder), typeFactory, rexBuilder);
    private static final class Cluster {
        Cluster(RelOptCluster cluster, RelDataTypeFactory typeFactory, RexBuilder rexBuilder) {
    }
import org.apache.calcite.plan.hep.HepProgramBuilder;
    private static RexCall assertStrftimeCall(RexNode out) {
    private static Cluster newCluster() {
        RexNode dt = c.rexBuilder.makeInputRef(c.typeFactory.createSqlType(SqlTypeName.DATE), 0);
            return rexBuilder.makeLiteral(value);
        final RelOptCluster cluster;  
        for (RexNode src : new RexNode[] { dbl, ts, dt }) {  
 *
import org.apache.calcite.rex.RexNode;  
        }
            );
import org.opensearch.test.OpenSearchTestCase;
/*  
    }  
        RexCall call = (RexCall) c.rexBuilder.makeCall(STRFTIME, c.intLiteral(1521467703), format);
    public void testFormatOperandForwardedVerbatim() {
                out.getOperands().get(0).getType().getSqlTypeName()
import org.apache.calcite.rel.type.RelDataTypeFactory;  
            RexCall call = (RexCall) c.rexBuilder.makeCall(STRFTIME, src, c.stringLiteral("%Y-%m-%d"));
            c.rexBuilder.makeExactLiteral(BigDecimal.valueOf(1521467703L), c.typeFactory.createSqlType(SqlTypeName.BIGINT)),
 * SPDX-License-Identifier: Apache-2.0
        final RelDataTypeFactory typeFactory;
        );
    public void testDoubleTimestampDateForwardByIdentity() {
        Cluster c = newCluster();
            RexCall call = (RexCall) c.rexBuilder.makeCall(STRFTIME, src, c.stringLiteral("%Y-%m-%d"));
import org.apache.calcite.plan.hep.HepPlanner;  
            c.typeFactory.createSqlType(SqlTypeName.DOUBLE)
        assertEquals("two operands — value + format", 2, outCall.getOperands().size());  
            assertSame("operand forwarded by identity: " + src.getType().getSqlTypeName(), src, out.getOperands().get(0));  
    public void testWrongArityPassesThrough() {  
import org.apache.calcite.sql.type.OperandTypes;
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode ts = c.rexBuilder.makeInputRef(c.typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 6), 0);
import java.math.BigDecimal;
import org.apache.calcite.plan.RelOptCluster;
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
            c.stringLiteral("1521467703"), };  
import org.apache.calcite.sql.type.SqlTypeFamily;  
        OperandTypes.family(SqlTypeFamily.ANY, SqlTypeFamily.CHARACTER),
    }
        RexNode stringLiteral(String value) {  
        RexNode format = c.stringLiteral("%a, %b %d, %Y %I:%M:%S %p %Z");  
            this.cluster = cluster;
    /** Every numeric-or-string input slot lowers to CAST-to-DOUBLE so the Rust UDF sees one signature. */
 * The OpenSearch Contributors require contributions made to  
        }
        assertSame(
import org.apache.calcite.rex.RexBuilder;
        "strftime",  
        RexNode intLiteral(int value) {
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
 * this file be licensed under the Apache-2.0 license or a
        );  
        assertSame("format literal forwarded by identity", format, out.getOperands().get(1));  
            RexCall out = assertStrftimeCall(adapter.adapt(call, List.of(), c.cluster));  
    }
import org.apache.calcite.rel.type.RelDataType;
            c.rexBuilder.makeExactLiteral(BigDecimal.valueOf(1521467703.123456), c.typeFactory.createSqlType(SqlTypeName.DECIMAL, 20, 6)),
import org.apache.calcite.sql.SqlFunctionCategory;
        RexBuilder rexBuilder = new RexBuilder(typeFactory);  
        Cluster c = newCluster();
            RexCall out = assertStrftimeCall(adapter.adapt(call, List.of(), c.cluster));
        RexNode dbl = c.rexBuilder.makeApproxLiteral(  
            "operator is the synthetic `strftime` that resolves to the Rust UDF",
        RexCall call = (RexCall) c.rexBuilder.makeCall(STRFTIME, c.intLiteral(1521467703));
    }
        final RexBuilder rexBuilder;
public class StrftimeFunctionAdapterTests extends OpenSearchTestCase {
        Cluster c = newCluster();
        ReturnTypes.VARCHAR,
    public void testNumericAndStringInputsWidenToDouble() {  
        }
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            BigDecimal.valueOf(1521467703.123456),
    }
import org.apache.calcite.rex.RexCall;
    private static final SqlFunction STRFTIME = new SqlFunction(
        for (RexNode src : sources) {
            StrftimeFunctionAdapter.STRFTIME,  
        Cluster c = newCluster();
    private final StrftimeFunctionAdapter adapter = new StrftimeFunctionAdapter();  
        assertSame("single-arg call left unchanged — downstream planning should fail loudly", call, out);
    }  
package org.opensearch.be.datafusion;
            this.rexBuilder = rexBuilder;
        null,  
        }
            RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);

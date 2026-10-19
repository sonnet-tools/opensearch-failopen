public class UnixTimestampAdapterTests extends OpenSearchTestCase {  
            "UNIX_TIMESTAMP",  
            OperandTypes.ANY,
import org.apache.calcite.plan.hep.HepPlanner;  
import java.util.List;  
            OperandTypes.ANY,
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
            SqlFunctionCategory.TIMEDATE
        RexCall call = (RexCall) adapted;
     * doesn't mismatch during fragment conversion. (DataFusion's substrait
            OperandTypes.ANY,
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);  
            SqlKind.OTHER_FUNCTION,
import org.apache.calcite.rel.type.RelDataType;
     * PPL's {@code UNIX_TIMESTAMP} is typed {@code DOUBLE_FORCE_NULLABLE}; DF's
        RexNode arg = call.getOperands().get(0);
        assertSame(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, call.getOperator());  
        SqlFunction unixTimestampOp = new SqlFunction(
import org.apache.calcite.plan.RelOptCluster;
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
        RexNode adapted = new UnixTimestampAdapter().adapt(original, List.of(), cluster);
import org.apache.calcite.sql.type.OperandTypes;
    public void testUnixTimestampRewritesToLocalToUnixtimeOperator() {
            null,  
            original.getType(),
     * its own coerce_types pass — the Calcite-inferred return type at isthmus  
        assertSame(
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
            SqlFunctionCategory.TIMEDATE
 *
            "adapted call's return type must equal the original — otherwise the enclosing Project.rowType "
     * Regression guard for adapter return-type preservation.  
/*  
            adapted.getType()
import org.apache.calcite.sql.SqlFunction;
     * original DOUBLE type so the enclosing Project / Filter's cached rowType  
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);  
import org.apache.calcite.rex.RexNode;  
            ReturnTypes.explicit(doubleNullable),  
            true  
        // Synthesize UNIX_TIMESTAMP(ts) with PPL's return type (DOUBLE_FORCE_NULLABLE).
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
        RexCall original = (RexCall) rexBuilder.makeCall(unixTimestampOp, List.of(numericLiteral));  
import org.apache.calcite.sql.type.SqlTypeName;  
            "adapted call must target UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP so the "  
    }
    /** Numeric literal not matching YYYYMMDDhhmmss falls through unchanged to {@code to_unixtime}. */
        );
            typeFactory.createSqlType(SqlTypeName.BIGINT),  
    public void testInvalidNumericLiteralFallsThrough() {
        assertEquals(1, call.getOperands().size());
            true
            new java.math.BigDecimal("20771122143845"),
        assertEquals("2077-11-22 14:38:45", ((org.apache.calcite.rex.RexLiteral) arg).getValueAs(String.class));
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        SqlFunction unixTimestampOp = new SqlFunction(
    }
    public void testNumericYyyyMmDdHhMmSsLiteralIsRewrittenToString() {
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);  
        RexCall original = (RexCall) rexBuilder.makeCall(unixTimestampOp, List.of(tsRef));
            ReturnTypes.explicit(doubleNullable),
        SqlFunction unixTimestampOp = new SqlFunction(  
            ReturnTypes.explicit(doubleNullable),
        );
 * rewrites PPL's bespoke {@code UNIX_TIMESTAMP} operator to a locally-declared
            SqlKind.OTHER_FUNCTION,
 * Unit tests for {@link UnixTimestampAdapter} — the cat-3a rename adapter that  
 */
        RexNode adapted = new UnixTimestampAdapter().adapt(original, List.of(), cluster);
        assertSame("arg 0 must be the original timestamp operand", tsRef, call.getOperands().get(0));  
                + "FunctionMappings.Sig in DataFusionFragmentConvertor can bind by reference",
     */
 * The OpenSearch Contributors require contributions made to  
        );  
        assertTrue(adapted instanceof RexCall);
     * time is purely a plan-validity artifact.)
            null,
        assertEquals(
        // 12345 is not 14 digits → not a YYYYMMDDhhmmss literal.
     * {@code to_unixtime} is typed {@code Int64}. The adapter must preserve the
 * compatible open source license.
            null,  
    public void testAdaptedCallPreservesOriginalReturnType() {  
        RexNode tsRef = rexBuilder.makeInputRef(tsType, 0);
            SqlKind.OTHER_FUNCTION,
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
        RexCall call = (RexCall) adapted;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    /**
import org.apache.calcite.sql.SqlKind;  
            SqlFunctionCategory.TIMEDATE  
 * SPDX-License-Identifier: Apache-2.0
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
        RexNode adapted = new UnixTimestampAdapter().adapt(original, List.of(), cluster);
        );  
        RexCall original = (RexCall) rexBuilder.makeCall(unixTimestampOp, List.of(numericLiteral));
 * {@code to_unixtime} {@link SqlFunction} whose {@code FunctionMappings.Sig} we
        assertTrue("numeric literal must be rewritten to a string literal", arg instanceof org.apache.calcite.rex.RexLiteral);  
            call.getOperator()  
import org.apache.calcite.rex.RexCall;
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
 */  
        RexNode adapted = new UnixTimestampAdapter().adapt(original, List.of(), cluster);
        );  
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);  
            UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP,
/**
package org.opensearch.be.datafusion;
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
            "UNIX_TIMESTAMP",  
        assertSame("non-YYYYMMDDhhmmss numeric literal must pass through unchanged", numericLiteral, call.getOperands().get(0));
        SqlFunction unixTimestampOp = new SqlFunction(
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            OperandTypes.ANY,
        assertEquals("to_unixtime is a pure rename — 1 operand preserved", 1, call.getOperands().size());
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
        );
        RexBuilder rexBuilder = new RexBuilder(typeFactory);  
            "UNIX_TIMESTAMP",  
    }  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
        assertEquals(doubleNullable, original.getType());  
import org.apache.calcite.sql.SqlFunctionCategory;
            ReturnTypes.explicit(doubleNullable),
            null,  
 * own. Target name {@code to_unixtime} matches DataFusion's native function; no  
            SqlKind.OTHER_FUNCTION,
        );  
        RexNode numericLiteral = rexBuilder.makeLiteral(  
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
                + "assertion fails during fragment conversion",  
        assertTrue(adapted instanceof RexCall);  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);  
 * this file be licensed under the Apache-2.0 license or a
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
            SqlFunctionCategory.TIMEDATE
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
            typeFactory.createSqlType(SqlTypeName.BIGINT),
    }
     * consumer re-resolves {@code to_unixtime} by name at plan time and applies
import org.apache.calcite.rex.RexBuilder;
        );
        RexCall original = (RexCall) rexBuilder.makeCall(unixTimestampOp, List.of(tsRef));
    /** numeric YYYYMMDDhhmmss literal -> string-datetime so {@code to_unixtime} can parse it. */  
        RexNode numericLiteral = rexBuilder.makeLiteral(
            "UNIX_TIMESTAMP",
}
        RexCall call = (RexCall) adapted;
 * UDF registration required on the Rust side.
        RexNode tsRef = rexBuilder.makeInputRef(tsType, 0);
            new java.math.BigDecimal("12345"),
import org.apache.calcite.sql.type.ReturnTypes;
import org.opensearch.test.OpenSearchTestCase;
        RexBuilder rexBuilder = new RexBuilder(typeFactory);

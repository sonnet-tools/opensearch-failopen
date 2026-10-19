import org.apache.calcite.plan.hep.HepProgramBuilder;
    public void testNumericYyyyMmDdHhMmSsLiteralIsRewrittenToString() {
import org.apache.calcite.sql.SqlFunctionCategory;
    /** numeric YYYYMMDDhhmmss literal -> string-datetime so {@code to_unixtime} can parse it. */
        );
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        RexNode numericLiteral = rexBuilder.makeLiteral(
            "adapted call's return type must equal the original — otherwise the enclosing Project.rowType "
        RexCall call = (RexCall) adapted;
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
            OperandTypes.ANY,
            "adapted call must target UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP so the "
        );
import java.util.List;
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.rel.type.RelDataType;
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
 * SPDX-License-Identifier: Apache-2.0
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
            ReturnTypes.explicit(doubleNullable),
        assertEquals(1, call.getOperands().size());
import org.apache.calcite.sql.SqlFunction;
            typeFactory.createSqlType(SqlTypeName.BIGINT),
import org.apache.calcite.plan.RelOptCluster;
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
/*
        RexCall call = (RexCall) adapted;
        SqlFunction unixTimestampOp = new SqlFunction(
        SqlFunction unixTimestampOp = new SqlFunction(
        SqlFunction unixTimestampOp = new SqlFunction(
 * Unit tests for {@link UnixTimestampAdapter} — the cat-3a rename adapter that
            SqlFunctionCategory.TIMEDATE
     * doesn't mismatch during fragment conversion. (DataFusion's substrait
 * compatible open source license.
            original.getType(),
            SqlFunctionCategory.TIMEDATE
    public void testUnixTimestampRewritesToLocalToUnixtimeOperator() {
            null,
            "UNIX_TIMESTAMP",
            ReturnTypes.explicit(doubleNullable),
        );
            "UNIX_TIMESTAMP",
    }
            true
            OperandTypes.ANY,
            new java.math.BigDecimal("20771122143845"),
        RexNode adapted = new UnixTimestampAdapter().adapt(original, List.of(), cluster);
            null,
 * own. Target name {@code to_unixtime} matches DataFusion's native function; no
            "UNIX_TIMESTAMP",
        assertTrue("numeric literal must be rewritten to a string literal", arg instanceof org.apache.calcite.rex.RexLiteral);
import org.apache.calcite.rel.type.RelDataTypeFactory;
/**
        assertEquals("2077-11-22 14:38:45", ((org.apache.calcite.rex.RexLiteral) arg).getValueAs(String.class));
     * {@code to_unixtime} is typed {@code Int64}. The adapter must preserve the
 * UDF registration required on the Rust side.
            adapted.getType()
        assertSame(
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        RexCall call = (RexCall) adapted;
     * original DOUBLE type so the enclosing Project / Filter's cached rowType
        );
        RexCall original = (RexCall) rexBuilder.makeCall(unixTimestampOp, List.of(tsRef));
 * {@code to_unixtime} {@link SqlFunction} whose {@code FunctionMappings.Sig} we
     * its own coerce_types pass — the Calcite-inferred return type at isthmus
                + "FunctionMappings.Sig in DataFusionFragmentConvertor can bind by reference",
            null,
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.sql.SqlKind;
        assertSame("arg 0 must be the original timestamp operand", tsRef, call.getOperands().get(0));
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RexNode adapted = new UnixTimestampAdapter().adapt(original, List.of(), cluster);
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
 */
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
 *
 */
            OperandTypes.ANY,
    public void testAdaptedCallPreservesOriginalReturnType() {
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.sql.type.OperandTypes;
package org.opensearch.be.datafusion;
            true
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
        RexNode arg = call.getOperands().get(0);
        RexCall original = (RexCall) rexBuilder.makeCall(unixTimestampOp, List.of(tsRef));
                + "assertion fails during fragment conversion",
        assertTrue(adapted instanceof RexCall);
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
     * Regression guard for adapter return-type preservation.
        );
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
    /** Numeric literal not matching YYYYMMDDhhmmss falls through unchanged to {@code to_unixtime}. */
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        // Synthesize UNIX_TIMESTAMP(ts) with PPL's return type (DOUBLE_FORCE_NULLABLE).
        );
    }
        RexNode tsRef = rexBuilder.makeInputRef(tsType, 0);
            null,
            SqlFunctionCategory.TIMEDATE
        RexNode numericLiteral = rexBuilder.makeLiteral(
        RexNode adapted = new UnixTimestampAdapter().adapt(original, List.of(), cluster);
        assertTrue(adapted instanceof RexCall);
}
            new java.math.BigDecimal("12345"),
        assertSame("non-YYYYMMDDhhmmss numeric literal must pass through unchanged", numericLiteral, call.getOperands().get(0));
            ReturnTypes.explicit(doubleNullable),
        RexNode tsRef = rexBuilder.makeInputRef(tsType, 0);
        assertEquals("to_unixtime is a pure rename — 1 operand preserved", 1, call.getOperands().size());
            ReturnTypes.explicit(doubleNullable),
import org.apache.calcite.rex.RexCall;
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.rex.RexBuilder;
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RexNode adapted = new UnixTimestampAdapter().adapt(original, List.of(), cluster);
        assertEquals(doubleNullable, original.getType());
     * consumer re-resolves {@code to_unixtime} by name at plan time and applies
    public void testInvalidNumericLiteralFallsThrough() {
        );
            call.getOperator()
        SqlFunction unixTimestampOp = new SqlFunction(
    /**
            SqlKind.OTHER_FUNCTION,
            "UNIX_TIMESTAMP",
public class UnixTimestampAdapterTests extends OpenSearchTestCase {
        RexCall original = (RexCall) rexBuilder.makeCall(unixTimestampOp, List.of(numericLiteral));
        assertEquals(
import org.opensearch.test.OpenSearchTestCase;
        RexCall original = (RexCall) rexBuilder.makeCall(unixTimestampOp, List.of(numericLiteral));
import org.apache.calcite.plan.hep.HepPlanner;
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
import org.apache.calcite.sql.type.ReturnTypes;
     * time is purely a plan-validity artifact.)
            OperandTypes.ANY,
     * PPL's {@code UNIX_TIMESTAMP} is typed {@code DOUBLE_FORCE_NULLABLE}; DF's
 * rewrites PPL's bespoke {@code UNIX_TIMESTAMP} operator to a locally-declared
        );
import org.apache.calcite.rex.RexNode;
 * The OpenSearch Contributors require contributions made to
    }
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
            SqlKind.OTHER_FUNCTION,
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
            SqlFunctionCategory.TIMEDATE
            SqlKind.OTHER_FUNCTION,
     */
            UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP,
        // 12345 is not 14 digits → not a YYYYMMDDhhmmss literal.
            SqlKind.OTHER_FUNCTION,
    }
 * this file be licensed under the Apache-2.0 license or a
        assertSame(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, call.getOperator());

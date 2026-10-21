     * {@code validateFirstArgIfStringLiteral} early-exit on non-literal inputs so DAYNAME / MONTHNAME
import java.util.List;
    /** DAYNAME with an invalid date literal rejects at plan time with the format-hint message. */
    /** Pins the rename: substrait core's enum-arg `extract` would crash isthmus if we shared the name. */
     */
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);
        cluster = RelOptCluster.create(planner, rexBuilder);
     * over a real column doesn't throw plan-time on values the adapter can't statically analyse.
            RustUdfDateTimeAdapters.LOCAL_DATE_FORMAT_OP,
/**
public class RustUdfDateTimeAdaptersTests extends OpenSearchTestCase {
        String expected = LocalDate.now(ZoneOffset.UTC).toString() + " ";
        // First arg of the CONCAT is a literal "<today> " (UTC).
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
 */
    /** DAYNAME with a valid date literal lowers without throwing. */
        IllegalArgumentException e = expectThrows(
    private RelOptCluster cluster;
        RexNode timeVal = rexBuilder.makeInputRef(time9, 0);
            typeFactory.createSqlType(SqlTypeName.VARCHAR),
            List.of(tsCol, fmt)
        RexCall original = makeDateFormatCall("2025-13-02");
        RelDataType time9 = typeFactory.createSqlType(SqlTypeName.TIME, 9);
        RexNode unit = rexBuilder.makeLiteral("HOUR", varchar, true);
        assertEquals("opensearch_extract", RustUdfDateTimeAdapters.LOCAL_EXTRACT_OP.getName());
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexCall original = makeDateFormatCall("2025-13-02");
    }
        RelDataType timestamp6 = typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 6);
        RexCall adaptedCall = (RexCall) adapted;
        assertTrue(adapted instanceof RexCall);
import org.apache.calcite.rex.RexCall;
    public void testExtractOperatorNameAvoidsSubstraitCoreCollision() {
        RexNode fmt = rexBuilder.makeLiteral("%W", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        RexCall original = (RexCall) rexBuilder.makeCall(
            IllegalArgumentException.class,
        RexCall original = makeDateFormatCall("2020-08-26");
    }
import java.time.ZoneOffset;
        assertEquals(SqlTypeName.VARCHAR, coercedValue.getType().getSqlTypeName());
        );
import org.opensearch.test.OpenSearchTestCase;
            IllegalArgumentException.class,
        );
        RexCall original = (RexCall) rexBuilder.makeCall(bigint, RustUdfDateTimeAdapters.LOCAL_EXTRACT_OP, List.of(unit, timeVal));
            IllegalArgumentException.class,
        assertSame(tsVal, adaptedCall.getOperands().get(1));
        RexCall original = makeDateFormatCall("2025-12-01 15:02:61");
        assertTrue(adapted instanceof RexCall);
    public void setUp() throws Exception {
        super.setUp();
import org.apache.calcite.rex.RexLiteral;
    public void testMonthnameAdapterRejectsInvalidDatetimeLiteral() {
        RexNode unit = rexBuilder.makeLiteral("YEAR", varchar, true);
    }
        RexCall original = makeDateFormatCall("2025-12-01 15:02:61");
    }
        RelDataType time9 = typeFactory.createSqlType(SqlTypeName.TIME, 9);
        assertTrue(adapted instanceof RexCall);
        RexNode timeVal = rexBuilder.makeInputRef(time9, 0);
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    public void testMonthnameAdapterRejectsInvalidDateLiteral() {
    /** MONTHNAME with a valid date literal lowers without throwing. */
    public void testDaynameAdapterAcceptsValidDateLiteral() {
import org.apache.calcite.rel.type.RelDataTypeFactory;
     * otherwise Arrow's TIME→1970-01-01 anchor leaks through and YEAR returns 1970.
        );
    public void testMonthnameAdapterAcceptsValidDateLiteral() {
        assertTrue(
import org.apache.calcite.rex.RexBuilder;
        );
        RexCall adaptedCall = (RexCall) adapted;
     * {@code extract(YEAR FROM <TIME>)} must anchor the value to today's UTC date at plan time —
import org.apache.calcite.rel.type.RelDataType;
        RexNode adapted = new RustUdfDateTimeAdapters.MonthnameAdapter().adapt(original, List.of(), cluster);
    /** Builds a {@code date_format(<varchar-literal>, <fmt>)} call shaped like the rewritten DAYNAME / MONTHNAME input. */
import org.apache.calcite.rex.RexNode;
     */
        return (RexCall) rexBuilder.makeCall(varchar, RustUdfDateTimeAdapters.LOCAL_DATE_FORMAT_OP, List.of(operand, fmt));
        RexNode coercedValue = adaptedCall.getOperands().get(1);
        RexNode prefix = concat.getOperands().get(0);
    }
    /** DAYNAME rejects out-of-range time-of-day in a full datetime literal. */
        RexNode fmt = rexBuilder.makeLiteral("%W", varchar, true);
        assertTrue("expected CONCAT wrapping the TIME cast", coercedValue instanceof RexCall);
        RexNode adapted = new RustUdfDateTimeAdapters.ExtractAdapter().adapt(original, List.of(), cluster);
    }
        RexNode adapted = new RustUdfDateTimeAdapters.DaynameAdapter().adapt(original, List.of(), cluster);
/*
    }
    /** MONTHNAME rejects out-of-range time-of-day in a full datetime literal — symmetric with DAYNAME's invalid-datetime test. */
        RelDataType ts = typeFactory.createSqlType(SqlTypeName.TIMESTAMP);
        assertTrue(e.getMessage().contains("unsupported format"));
 */
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
 * SPDX-License-Identifier: Apache-2.0
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);
        IllegalArgumentException e = expectThrows(
            IllegalArgumentException.class,
 * compatible open source license.
        assertTrue(e.getMessage().contains("unsupported format"));
        RexCall original = (RexCall) rexBuilder.makeCall(bigint, RustUdfDateTimeAdapters.LOCAL_EXTRACT_OP, List.of(unit, timeVal));
        RexCall original = (RexCall) rexBuilder.makeCall(bigint, RustUdfDateTimeAdapters.LOCAL_EXTRACT_OP, List.of(unit, tsVal));
            e.getMessage().contains("2025-13-02") && e.getMessage().contains("unsupported format")
        assertTrue(coercedValue instanceof RexCall && ((RexCall) coercedValue).getKind() == SqlKind.CAST);
            "expected unsupported-format hint, got: " + e.getMessage(),
            () -> new RustUdfDateTimeAdapters.DaynameAdapter().adapt(original, List.of(), cluster)
    /** MONTHNAME with an invalid date literal rejects at plan time with the format-hint message. */
    /**
        assertTrue(prefix instanceof RexLiteral);
    public void testDaynameAdapterRejectsInvalidDatetimeLiteral() {
    private RexCall makeDateFormatCall(String literal) {
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexNode timeVal = rexBuilder.makeInputRef(time9, 0);
        );
 * this file be licensed under the Apache-2.0 license or a
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        IllegalArgumentException e = expectThrows(
        RexCall original = (RexCall) rexBuilder.makeCall(bigint, RustUdfDateTimeAdapters.LOCAL_EXTRACT_OP, List.of(unit, timeVal));
    public void testDaynameAdapterNonLiteralOperandSkipsValidation() {
        RexCall concat = (RexCall) coercedValue;
import org.apache.calcite.plan.RelOptCluster;
            () -> new RustUdfDateTimeAdapters.MonthnameAdapter().adapt(original, List.of(), cluster)
        assertTrue(
    }
        RexNode unit = rexBuilder.makeLiteral("YEAR", varchar, true);
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode unit = rexBuilder.makeLiteral("MINUTE", varchar, true);
    /** Pure time-part units (HOUR/MINUTE/SECOND/...) keep the existing TIME→VARCHAR cast path. */
    }
    }
            () -> new RustUdfDateTimeAdapters.DaynameAdapter().adapt(original, List.of(), cluster)
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexCall original = makeDateFormatCall("2020-08-26");
    public void testExtractAdapterDoesNotCoerceTimestampOperand() {
        );
    private RelDataTypeFactory typeFactory;
    private RexBuilder rexBuilder;
        assertTrue("non-literal operand must lower without throwing", adapted instanceof RexCall);
 * Tests for {@link RustUdfDateTimeAdapters}. Pins the {@code opensearch_extract}
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode coercedValue = adaptedCall.getOperands().get(1);
        typeFactory = new JavaTypeFactoryImpl();
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexNode tsCol = rexBuilder.makeInputRef(ts, 0);
        assertEquals(expected, ((RexLiteral) prefix).getValue2());
 *
    }
 * rename and the TIME→VARCHAR coercion in {@link RustUdfDateTimeAdapters.ExtractAdapter}.
package org.opensearch.be.datafusion;
    public void testExtractAdapterKeepsBareCastForTimePartOnTime() {
            e.getMessage().contains("2025-13-02") && e.getMessage().contains("unsupported format")
import org.apache.calcite.sql.SqlKind;
    /** {@code extract(<unit> FROM <TIME(p)>)} value operand must be CAST to VARCHAR (precision_time has no yaml overload). */
            () -> new RustUdfDateTimeAdapters.MonthnameAdapter().adapt(original, List.of(), cluster)
    }
        RexCall adaptedCall = (RexCall) adapted;
        RexNode operand = rexBuilder.makeLiteral(literal, varchar, true);
}
    public void testDaynameAdapterRejectsInvalidDateLiteral() {
        RelDataType time9 = typeFactory.createSqlType(SqlTypeName.TIME, 9);
import org.apache.calcite.plan.hep.HepPlanner;
        RexNode adapted = new RustUdfDateTimeAdapters.ExtractAdapter().adapt(original, List.of(), cluster);
            "expected unsupported-format hint, got: " + e.getMessage(),
        assertEquals(unit, adaptedCall.getOperands().get(0));
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);
        RexNode adapted = new RustUdfDateTimeAdapters.ExtractAdapter().adapt(original, List.of(), cluster);
     * Non-literal operand (column ref) skips validation and passes through unchanged — pins the
        RexNode adapted = new RustUdfDateTimeAdapters.DaynameAdapter().adapt(original, List.of(), cluster);
        assertTrue(coercedValue instanceof RexCall && ((RexCall) coercedValue).getKind() == SqlKind.CAST);
    @Override
    /** Non-TIME operands (DATE / TIMESTAMP / VARCHAR) pass through unchanged. */
import java.time.LocalDate;
    public void testExtractAdapterPrependsTodayForDatePartOnTime() {
        );
    public void testExtractAdapterCastsTimeOperandToVarchar() {
 * The OpenSearch Contributors require contributions made to
    /**
    }
        RexNode tsVal = rexBuilder.makeInputRef(timestamp6, 0);
        RexNode coercedValue = ((RexCall) adapted).getOperands().get(1);
        assertTrue(adapted instanceof RexCall);
    }
        RexNode adapted = new RustUdfDateTimeAdapters.ExtractAdapter().adapt(original, List.of(), cluster);
        rexBuilder = new RexBuilder(typeFactory);
        assertEquals(SqlStdOperatorTable.CONCAT, concat.getOperator());
        IllegalArgumentException e = expectThrows(

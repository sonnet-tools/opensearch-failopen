     * Non-literal operand (column ref) skips validation and passes through unchanged — pins the
    private RelOptCluster cluster;
        RexCall original = (RexCall) rexBuilder.makeCall(bigint, RustUdfDateTimeAdapters.LOCAL_EXTRACT_OP, List.of(unit, timeVal));
        RexNode fmt = rexBuilder.makeLiteral("%W", varchar, true);
        RexNode operand = rexBuilder.makeLiteral(literal, varchar, true);  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        assertEquals(SqlStdOperatorTable.CONCAT, concat.getOperator());  
        RexNode unit = rexBuilder.makeLiteral("YEAR", varchar, true);
    /** Non-TIME operands (DATE / TIMESTAMP / VARCHAR) pass through unchanged. */
     * {@code validateFirstArgIfStringLiteral} early-exit on non-literal inputs so DAYNAME / MONTHNAME  
}
     * over a real column doesn't throw plan-time on values the adapter can't statically analyse.
import org.apache.calcite.rex.RexLiteral;  
        assertSame(tsVal, adaptedCall.getOperands().get(1));
        );  
            e.getMessage().contains("2025-13-02") && e.getMessage().contains("unsupported format")
        );  
    }
        assertEquals(expected, ((RexLiteral) prefix).getValue2());
            () -> new RustUdfDateTimeAdapters.MonthnameAdapter().adapt(original, List.of(), cluster)
        RexCall original = (RexCall) rexBuilder.makeCall(bigint, RustUdfDateTimeAdapters.LOCAL_EXTRACT_OP, List.of(unit, timeVal));
    /** DAYNAME with a valid date literal lowers without throwing. */
            e.getMessage().contains("2025-13-02") && e.getMessage().contains("unsupported format")
    /** Pins the rename: substrait core's enum-arg `extract` would crash isthmus if we shared the name. */  
 * SPDX-License-Identifier: Apache-2.0
            () -> new RustUdfDateTimeAdapters.DaynameAdapter().adapt(original, List.of(), cluster)
        RexNode unit = rexBuilder.makeLiteral("HOUR", varchar, true);
        RexNode timeVal = rexBuilder.makeInputRef(time9, 0);  
        RexNode adapted = new RustUdfDateTimeAdapters.DaynameAdapter().adapt(original, List.of(), cluster);
    public void testDaynameAdapterAcceptsValidDateLiteral() {
        RexCall adaptedCall = (RexCall) adapted;
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    }  
    public void testExtractAdapterPrependsTodayForDatePartOnTime() {  
    }
 * compatible open source license.
            List.of(tsCol, fmt)
        return (RexCall) rexBuilder.makeCall(varchar, RustUdfDateTimeAdapters.LOCAL_DATE_FORMAT_OP, List.of(operand, fmt));
    }  
        RexNode coercedValue = adaptedCall.getOperands().get(1);  
    public void testExtractAdapterDoesNotCoerceTimestampOperand() {  
        assertEquals(unit, adaptedCall.getOperands().get(0));
    public void testMonthnameAdapterRejectsInvalidDatetimeLiteral() {
        assertTrue(coercedValue instanceof RexCall && ((RexCall) coercedValue).getKind() == SqlKind.CAST);
        String expected = LocalDate.now(ZoneOffset.UTC).toString() + " ";
package org.opensearch.be.datafusion;
    public void testExtractAdapterCastsTimeOperandToVarchar() {  
        RexNode adapted = new RustUdfDateTimeAdapters.MonthnameAdapter().adapt(original, List.of(), cluster);
        assertTrue(  
    }  
    public void testMonthnameAdapterRejectsInvalidDateLiteral() {  
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        assertTrue(e.getMessage().contains("unsupported format"));
            typeFactory.createSqlType(SqlTypeName.VARCHAR),
    /** DAYNAME rejects out-of-range time-of-day in a full datetime literal. */  
        RexCall original = (RexCall) rexBuilder.makeCall(bigint, RustUdfDateTimeAdapters.LOCAL_EXTRACT_OP, List.of(unit, tsVal));
    private RexBuilder rexBuilder;  
import org.apache.calcite.sql.SqlKind;
    }
            IllegalArgumentException.class,
        RexNode coercedValue = adaptedCall.getOperands().get(1);  
    /** {@code extract(<unit> FROM <TIME(p)>)} value operand must be CAST to VARCHAR (precision_time has no yaml overload). */
        RexCall original = makeDateFormatCall("2025-12-01 15:02:61");
        RexCall original = makeDateFormatCall("2020-08-26");  
import org.apache.calcite.plan.hep.HepProgramBuilder;
        assertTrue(coercedValue instanceof RexCall && ((RexCall) coercedValue).getKind() == SqlKind.CAST);
            RustUdfDateTimeAdapters.LOCAL_DATE_FORMAT_OP,  
        RexCall original = (RexCall) rexBuilder.makeCall(
        IllegalArgumentException e = expectThrows(  
    /** Builds a {@code date_format(<varchar-literal>, <fmt>)} call shaped like the rewritten DAYNAME / MONTHNAME input. */  
 * Tests for {@link RustUdfDateTimeAdapters}. Pins the {@code opensearch_extract}  
            IllegalArgumentException.class,
    public void testExtractAdapterKeepsBareCastForTimePartOnTime() {  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
            "expected unsupported-format hint, got: " + e.getMessage(),
     * {@code extract(YEAR FROM <TIME>)} must anchor the value to today's UTC date at plan time —  
        RexCall original = makeDateFormatCall("2025-13-02");
        assertTrue(adapted instanceof RexCall);
    @Override  
        typeFactory = new JavaTypeFactoryImpl();  
    public void testExtractOperatorNameAvoidsSubstraitCoreCollision() {
        RelDataType ts = typeFactory.createSqlType(SqlTypeName.TIMESTAMP);
        rexBuilder = new RexBuilder(typeFactory);
            IllegalArgumentException.class,  
     */
import java.util.List;  
    }  
        RexCall adaptedCall = (RexCall) adapted;  
import org.apache.calcite.rel.type.RelDataType;
        RexNode adapted = new RustUdfDateTimeAdapters.ExtractAdapter().adapt(original, List.of(), cluster);  
    public void testDaynameAdapterNonLiteralOperandSkipsValidation() {  
        IllegalArgumentException e = expectThrows(
        RexNode adapted = new RustUdfDateTimeAdapters.ExtractAdapter().adapt(original, List.of(), cluster);  
        assertEquals("opensearch_extract", RustUdfDateTimeAdapters.LOCAL_EXTRACT_OP.getName());
        RexCall original = makeDateFormatCall("2025-12-01 15:02:61");
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);  
        assertTrue(  
import java.time.LocalDate;
    /** MONTHNAME with a valid date literal lowers without throwing. */
        IllegalArgumentException e = expectThrows(
 */
    }
import java.time.ZoneOffset;
        RexCall adaptedCall = (RexCall) adapted;  
        RelDataType time9 = typeFactory.createSqlType(SqlTypeName.TIME, 9);
import org.apache.calcite.rex.RexNode;
        cluster = RelOptCluster.create(planner, rexBuilder);  
        RelDataType timestamp6 = typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 6);
        RexCall original = makeDateFormatCall("2025-13-02");
 */  
            "expected unsupported-format hint, got: " + e.getMessage(),
        // First arg of the CONCAT is a literal "<today> " (UTC).
        RexNode tsCol = rexBuilder.makeInputRef(ts, 0);
     */
        RexNode adapted = new RustUdfDateTimeAdapters.ExtractAdapter().adapt(original, List.of(), cluster);  
        RexNode adapted = new RustUdfDateTimeAdapters.ExtractAdapter().adapt(original, List.of(), cluster);  
        IllegalArgumentException e = expectThrows(  
    /** DAYNAME with an invalid date literal rejects at plan time with the format-hint message. */
 * The OpenSearch Contributors require contributions made to  
    /** MONTHNAME rejects out-of-range time-of-day in a full datetime literal — symmetric with DAYNAME's invalid-datetime test. */  
        assertTrue(adapted instanceof RexCall);
        RexNode unit = rexBuilder.makeLiteral("MINUTE", varchar, true);
    }
 *
    /**
        RexNode timeVal = rexBuilder.makeInputRef(time9, 0);  
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode fmt = rexBuilder.makeLiteral("%W", typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
        assertTrue("expected CONCAT wrapping the TIME cast", coercedValue instanceof RexCall);
        );  
    /** Pure time-part units (HOUR/MINUTE/SECOND/...) keep the existing TIME→VARCHAR cast path. */
    public void setUp() throws Exception {
        RexNode timeVal = rexBuilder.makeInputRef(time9, 0);  
    }  
        RexNode unit = rexBuilder.makeLiteral("YEAR", varchar, true);
        assertTrue("non-literal operand must lower without throwing", adapted instanceof RexCall);  
        assertTrue(prefix instanceof RexLiteral);  
        assertTrue(adapted instanceof RexCall);
    private RelDataTypeFactory typeFactory;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
/*  
            () -> new RustUdfDateTimeAdapters.DaynameAdapter().adapt(original, List.of(), cluster)
        RexCall original = makeDateFormatCall("2020-08-26");  
    }  
        RexNode adapted = new RustUdfDateTimeAdapters.DaynameAdapter().adapt(original, List.of(), cluster);
        RexCall concat = (RexCall) coercedValue;
    public void testMonthnameAdapterAcceptsValidDateLiteral() {
     * otherwise Arrow's TIME→1970-01-01 anchor leaks through and YEAR returns 1970.
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);  
import org.apache.calcite.rex.RexCall;
 * this file be licensed under the Apache-2.0 license or a
        );
            IllegalArgumentException.class,  
        RexNode coercedValue = ((RexCall) adapted).getOperands().get(1);
        RexNode prefix = concat.getOperands().get(0);
    }  
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        );  
public class RustUdfDateTimeAdaptersTests extends OpenSearchTestCase {  
        );
    }
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);  
        RelDataType time9 = typeFactory.createSqlType(SqlTypeName.TIME, 9);
import org.apache.calcite.plan.RelOptCluster;
    public void testDaynameAdapterRejectsInvalidDateLiteral() {  
        RexNode tsVal = rexBuilder.makeInputRef(timestamp6, 0);  
 * rename and the TIME→VARCHAR coercion in {@link RustUdfDateTimeAdapters.ExtractAdapter}.
import org.opensearch.test.OpenSearchTestCase;
        super.setUp();
        assertEquals(SqlTypeName.VARCHAR, coercedValue.getType().getSqlTypeName());
    /**
        );
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);  
            () -> new RustUdfDateTimeAdapters.MonthnameAdapter().adapt(original, List.of(), cluster)
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
/**
        assertTrue(adapted instanceof RexCall);
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.rex.RexBuilder;
        RelDataType time9 = typeFactory.createSqlType(SqlTypeName.TIME, 9);
    private RexCall makeDateFormatCall(String literal) {
    /** MONTHNAME with an invalid date literal rejects at plan time with the format-hint message. */
    public void testDaynameAdapterRejectsInvalidDatetimeLiteral() {
import org.apache.calcite.plan.hep.HepPlanner;  
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexCall original = (RexCall) rexBuilder.makeCall(bigint, RustUdfDateTimeAdapters.LOCAL_EXTRACT_OP, List.of(unit, timeVal));
        assertTrue(e.getMessage().contains("unsupported format"));
    }

     * {@code Project.isValid} compatibleTypes check breaks at fragment
        expectThrows(IllegalArgumentException.class, () -> ConvertTzAdapter.canonicalizeTz("-17:00"));  
        // MySQL CONVERT_TZ band: [-13:59, +14:00] (legacy DateTimeUtils.isValidMySqlTimeZoneId).
            "adapted call's return type must equal the original — otherwise Project.rowType assertion fails",
        typeFactory = new JavaTypeFactoryImpl();
        }  
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
            "adapted call must target LOCAL_CONVERT_TZ_OP so FunctionMappings.Sig binds",
    public void testAdaptIdentityFoldReturnsTimestampUnchanged() {
     * Identity fold must apply *after* canonicalization — `+5:00` and `+05:00`  
import org.apache.calcite.plan.hep.HepPlanner;  
        RelDataType returnType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 9), true);
    public void testUdfFallbackWrapsVarcharOperandInSafeCast() {
    /**
    public void testCanonicalizeTzAcceptsIanaNames() {
    /** Identity short-circuit with VARCHAR operand under a TIMESTAMP call → SAFE-cast. */
        assertEquals("UTC", ConvertTzAdapter.canonicalizeTz("UTC"));  
    }
            assertTrue(((RexLiteral) adapted).isNull());
    /**  
/**  
        RexNode tsLiteral = rexBuilder.makeLiteral("2021-05-12 11:34:50");  
        assertEquals("+05:00", ((RexLiteral) call.getOperands().get(1)).getValueAs(String.class));  
    /**
        RexNode toTz = rexBuilder.makeLiteral("America/Los_Angeles");
            "CONVERT_TZ",  
     * operands. The tz strings passed to the UDF are the canonical form.
        assertEquals(org.apache.calcite.sql.SqlKind.SAFE_CAST, ((RexCall) firstArg).getOperator().getKind());
        assertTrue(firstArg instanceof RexCall);  
import org.apache.calcite.sql.SqlFunctionCategory;  
        assertEquals(  
     */
            call.getOperator()
        RexCall call = (RexCall) adapted;  
        super.setUp();  
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
        // turns the IAE into a NULL literal so callers see {@code SELECT CONVERT_TZ(...,'-14:00','+08:00')}
        assertEquals(org.apache.calcite.sql.SqlKind.SAFE_CAST, ((RexCall) adapted).getOperator().getKind());  
    /** unknown IANA literal -> typed NULL. */
        RexNode fromNode = rexBuilder.makeLiteral(fromLit);
 * per-row shifting stays in the Rust UDF since IANA offsets vary per instant.
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);  
        return (RexCall) rexBuilder.makeCall(convertTzOp(tsType), List.of(tsRef, fromNode, toNode));  
        RexCall call = (RexCall) adapted;
        RexCall original = (RexCall) rexBuilder.makeCall(convertTzOp(returnType), List.of(tsLiteral, fromTz, toTz));  
     */  
        RexNode tsRef = rexBuilder.makeInputRef(tsType, 0);
        RexNode fromCol = rexBuilder.makeInputRef(stringType, 1);
        RexNode tsLiteral = rexBuilder.makeLiteral("2021-05-12 11:34:50");
    @Override
    }
     */  
     * values can't be inspected until runtime, so they pass through into the
import org.apache.calcite.rel.type.RelDataType;
        expectThrows(IllegalArgumentException.class, () -> ConvertTzAdapter.canonicalizeTz("+14:01"));
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
import org.apache.calcite.sql.type.ReturnTypes;  
        RexCall original = buildConvertTz("+5:00", "+10:00");  
    }
     * When literal operands need canonicalization (e.g. `+5:00` → `+05:00`),  
        }) {
            original.getType(),
    // ── adapt() behavior ──────────────────────────────────────────────────
        assertTrue(adapted instanceof RexLiteral);  
            { "-12:00", "+14:01" }, // ConvertTZFunctionIT#nullField3Over  
        assertSame(ConvertTzAdapter.LOCAL_CONVERT_TZ_OP, call.getOperator());  
        assertEquals("+14:00", ConvertTzAdapter.canonicalizeTz("+14:00"));
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
     * When literals can't be collapsed (IANA pairs, mixed IANA + offset), the  
    public void testIdentityShortCircuitWrapsInSafeCastWhenOperandTypeDiffers() {  
            null,  
    }
 * compatible open source license.
        assertEquals("Europe/London", ConvertTzAdapter.canonicalizeTz("Europe/London"));
    }
     * are the same zone but different strings; the adapter must canonicalize
        assertEquals("+10:00", ((RexLiteral) call.getOperands().get(2)).getValueAs(String.class));
        assertEquals(original.getType(), call.getType());
        assertEquals("-13:59", ConvertTzAdapter.canonicalizeTz("-13:59"));  
        // ZoneId.of passes through canonical ids unchanged.  
        expectThrows(IllegalArgumentException.class, () -> ConvertTzAdapter.canonicalizeTz("+05:60"));
        expectThrows(IllegalArgumentException.class, () -> ConvertTzAdapter.canonicalizeTz("-14:00"));
import org.apache.calcite.sql.SqlFunction;
    }
        assertEquals("-08:00", ConvertTzAdapter.canonicalizeTz("-8:00"));
            RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
        RexNode toTz = rexBuilder.makeLiteral("UTC");
        RexNode toCol = rexBuilder.makeInputRef(stringType, 2);
        assertEquals(original.getType(), firstArg.getType());
     * to do the padding.
import org.apache.calcite.sql.type.SqlTypeName;
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> ConvertTzAdapter.canonicalizeTz("Mars/Olympus"));  
        assertNotSame(tsLiteral, adapted);  
    private RexCall buildConvertTz(String fromLit, String toLit) {  
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
     * call reduces to its timestamp operand. No UDF invocation.
        assertSame("column-valued to_tz must pass through unmodified", toCol, call.getOperands().get(2));
import org.apache.calcite.rex.RexBuilder;
        RexCall original = (RexCall) rexBuilder.makeCall(convertTzOp(originalType), List.of(tsRef, fromLit, toLit));
    }
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
    public void testCanonicalizeTzRejectsUnknownIana() {
     */  
        assertTrue("error must include the bad value for UX: " + ex.getMessage(), ex.getMessage().contains("Mars/Olympus"));
    }
package org.opensearch.be.datafusion;
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.rex.RexLiteral;  
        assertTrue(adapted instanceof RexCall);
        assertEquals("Europe/London", ((RexLiteral) call.getOperands().get(2)).getValueAs(String.class));
     * conversion.  
    }  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
            RexCall original = buildConvertTz(pair[0], pair[1]);  
        RelDataType stringType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
    }  
     * UDF which handles them leniently (unparseable → NULL row).  
    }  
        RexCall original = (RexCall) rexBuilder.makeCall(convertTzOp(returnType), List.of(tsLiteral, fromTz, toTz));
        RexCall call = (RexCall) adapted;
    public void testAdaptOutOfBandOffsetLiteralReturnsTypedNull() {  
        RexNode fromLit = rexBuilder.makeLiteral("America/New_York");
     * first, then compare.
    public void testAdaptIdentityFoldAppliesAfterCanonicalization() {
    private RexBuilder rexBuilder;
        RexNode toLit = rexBuilder.makeLiteral("Europe/London");  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
 * The OpenSearch Contributors require contributions made to  
    }  
        // Pair of distinct-canonical offsets so the fold path doesn't fire.
        RexCall original = buildConvertTz("America/New_York", "Europe/London");
            adapted.getType()  
        assertSame("identity fold must compare canonical forms", original.getOperands().get(0), adapted);
        assertTrue(adapted instanceof RexCall);  
            SqlKind.OTHER_FUNCTION,
        assertEquals(original.getType(), adapted.getType());
        assertEquals("+05:30", ConvertTzAdapter.canonicalizeTz("+5:30"));  
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.rex.RexCall;
        assertEquals(3, call.getOperands().size());  
        RexCall original = (RexCall) rexBuilder.makeCall(convertTzOp(tsType), List.of(tsRef, fromCol, toCol));  
        RexCall original = buildConvertTz("Mars/Olympus", "UTC");  
        assertSame("column-valued from_tz must pass through unmodified", fromCol, call.getOperands().get(1));
        for (String[] pair : new String[][] {
import java.util.List;
import org.apache.calcite.sql.type.OperandTypes;
    private RelOptCluster cluster;
    }
            OperandTypes.ANY_STRING_STRING,
     * {@code AbstractNameMappingAdapter} regression guard. If the rewritten  
    private SqlFunction convertTzOp(RelDataType returnType) {
        RexNode firstArg = call.getOperands().get(0);  
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
        assertEquals(originalType, original.getType());
        expectThrows(IllegalArgumentException.class, () -> ConvertTzAdapter.canonicalizeTz("+15:00"));
        RelDataType returnType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 9), true);
    }
        );  
            assertTrue("expected NULL literal for [" + pair[0] + "," + pair[1] + "], got " + adapted, adapted instanceof RexLiteral);  
        // The Java adapter folds these to typed NULL at plan time; the catch in adapt()
     * call rewrites to the local UDF operator with canonicalized string
 */  
        assertSame("identity fold must return the original timestamp operand", original.getOperands().get(0), adapted);
        // return NULL, matching ConvertTZFunctionIT#nullField2Under / nullField3Over.  
 *
        RexCall original = buildConvertTz("+5:00", "+05:00");
        assertEquals("+14:00", ConvertTzAdapter.canonicalizeTz("+14:00"));
public class ConvertTzAdapterTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
        RexNode toNode = rexBuilder.makeLiteral(toLit);
        // 2-arg makeLiteral matches PPL's frontend; the nullable 3-arg form would wrap in CAST  
    public void testCanonicalizeTzAcceptsBoundaryOffsets() {  
            SqlFunctionCategory.TIMEDATE
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);  
        assertTrue(((RexLiteral) adapted).isNull());
        assertSame(ConvertTzAdapter.LOCAL_CONVERT_TZ_OP, call.getOperator());  
 * priority order: identity short-circuit when both tz operands canonicalize to
            assertEquals(original.getType(), adapted.getType());
        assertTrue(adapted instanceof RexCall);
        assertEquals(original.getType(), adapted.getType());
            ConvertTzAdapter.LOCAL_CONVERT_TZ_OP,  
import org.apache.calcite.plan.RelOptCluster;
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
        RexNode tsRef = rexBuilder.makeInputRef(tsType, 0);
import org.apache.calcite.plan.hep.HepProgramBuilder;
        assertTrue(adapted instanceof RexCall);
    /**  
     */  
    }  
     * call's Calcite-inferred type differs from the original, the enclosing
     * the UDF-bound call sees the canonical form so the Rust side doesn't need
        RexNode fromTz = rexBuilder.makeLiteral("UTC");  
    /** Out-of-band offset literal -> typed NULL (matches MySQL CONVERT_TZ semantics). */
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);  
 * the same value, plan-time validation/canonicalization of literal tz operands,  
/*  
     * Adapter preserves the original call's return type — matches the
    }  
    public void setUp() throws Exception {
        // Column refs for the tz slots — not literals, so no canonicalization.  
    public void testCanonicalizeTzRejectsOffsetsOutsideMysqlBand() {  
    // ── Canonicalization (unit tests on the static helper) ────────────────  
        return new SqlFunction(
        assertEquals("America/New_York", ((RexLiteral) call.getOperands().get(1)).getValueAs(String.class));
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
    public void testAdaptUnknownIanaLiteralReturnsTypedNull() {
        assertEquals("America/New_York", ConvertTzAdapter.canonicalizeTz("America/New_York"));
            ReturnTypes.explicit(returnType),
        cluster = RelOptCluster.create(planner, rexBuilder);
import org.opensearch.test.OpenSearchTestCase;
 */  
        RexNode fromTz = rexBuilder.makeLiteral("UTC");
     * Column-valued tz operands are not validated at plan time — per-row
        RelDataType originalType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 0), true);  
        );
        RexNode tsRef = rexBuilder.makeInputRef(originalType, 0);
    /**
 * SPDX-License-Identifier: Apache-2.0
    private RelDataTypeFactory typeFactory;  
}  
 * and rewrite to the locally-declared UDF operator otherwise. DST-correct
    public void testAdaptPassesCanonicalizedLiteralsToUdf() {
    public void testAdaptColumnValuedTzOperandsPassThroughToUdf() {
    /**
 * Unit tests for {@link ConvertTzAdapter}. The adapter has three jobs in
    /** UDF fallback with VARCHAR timestamp operand → SAFE-cast slot 0 to TIMESTAMP. */  
        RexCall original = buildConvertTz("UTC", "UTC");
        RexCall call = (RexCall) adapted;
    }
        );
        assertNotSame(tsLiteral, firstArg);
            { "-14:00", "+08:00" }, // ConvertTZFunctionIT#nullField2Under
    }  
     * Identity fold: when both tz literals canonicalize to the same value, the
     */
    public void testCanonicalizeTzPadsOffsetDigits() {
        assertSame(
            { "+15:00", "+00:00" }, // legacy PPL DateTimeFunctionIT#testConvertTZ
        rexBuilder = new RexBuilder(typeFactory);
    public void testAdaptedCallPreservesOriginalReturnType() {
        assertSame(ConvertTzAdapter.LOCAL_CONVERT_TZ_OP, call.getOperator());
    public void testAdaptIanaPairRoutesThroughUdfWithCanonicalLiterals() {

     */
        assertTrue(adapted instanceof RexCall);
    public void testAdaptUnknownIanaLiteralReturnsTypedNull() {
     * Identity fold must apply *after* canonicalization — `+5:00` and `+05:00`
            { "-12:00", "+14:01" }, // ConvertTZFunctionIT#nullField3Over
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
     */
        assertEquals("Europe/London", ConvertTzAdapter.canonicalizeTz("Europe/London"));
        RexCall original = buildConvertTz("+5:00", "+05:00");
        // MySQL CONVERT_TZ band: [-13:59, +14:00] (legacy DateTimeUtils.isValidMySqlTimeZoneId).
        RexCall original = (RexCall) rexBuilder.makeCall(convertTzOp(originalType), List.of(tsRef, fromLit, toLit));
        assertSame(
    private RexBuilder rexBuilder;
import org.apache.calcite.plan.RelOptCluster;
    public void testCanonicalizeTzRejectsUnknownIana() {
import org.opensearch.test.OpenSearchTestCase;
        assertSame("column-valued from_tz must pass through unmodified", fromCol, call.getOperands().get(1));
     * When literals can't be collapsed (IANA pairs, mixed IANA + offset), the
    public void testAdaptIdentityFoldAppliesAfterCanonicalization() {
        assertEquals("UTC", ConvertTzAdapter.canonicalizeTz("UTC"));
 * and rewrite to the locally-declared UDF operator otherwise. DST-correct
        RexNode fromTz = rexBuilder.makeLiteral("UTC");
import org.apache.calcite.rex.RexBuilder;
        return (RexCall) rexBuilder.makeCall(convertTzOp(tsType), List.of(tsRef, fromNode, toNode));
 *
    }
     * UDF which handles them leniently (unparseable → NULL row).
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
        assertEquals("-08:00", ConvertTzAdapter.canonicalizeTz("-8:00"));
 * Unit tests for {@link ConvertTzAdapter}. The adapter has three jobs in
            { "+15:00", "+00:00" }, // legacy PPL DateTimeFunctionIT#testConvertTZ
        expectThrows(IllegalArgumentException.class, () -> ConvertTzAdapter.canonicalizeTz("-17:00"));
        RexNode fromTz = rexBuilder.makeLiteral("UTC");
        rexBuilder = new RexBuilder(typeFactory);
import org.apache.calcite.rel.type.RelDataTypeFactory;
    /** UDF fallback with VARCHAR timestamp operand → SAFE-cast slot 0 to TIMESTAMP. */
        RexNode tsLiteral = rexBuilder.makeLiteral("2021-05-12 11:34:50");
    }
            { "-14:00", "+08:00" }, // ConvertTZFunctionIT#nullField2Under
    }
        RexNode toNode = rexBuilder.makeLiteral(toLit);
     * values can't be inspected until runtime, so they pass through into the
    public void testUdfFallbackWrapsVarcharOperandInSafeCast() {
    public void testAdaptColumnValuedTzOperandsPassThroughToUdf() {
        assertEquals(original.getType(), adapted.getType());
    }
        assertEquals(3, call.getOperands().size());
        assertEquals("+14:00", ConvertTzAdapter.canonicalizeTz("+14:00"));
            SqlKind.OTHER_FUNCTION,
        assertSame("identity fold must return the original timestamp operand", original.getOperands().get(0), adapted);
     */
        RexCall original = buildConvertTz("Mars/Olympus", "UTC");
        RexCall call = (RexCall) adapted;
            RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
        assertNotSame(tsLiteral, adapted);
        RelDataType originalType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 0), true);
        RexNode tsRef = rexBuilder.makeInputRef(originalType, 0);
            ReturnTypes.explicit(returnType),
import org.apache.calcite.rex.RexNode;
        assertEquals("America/New_York", ((RexLiteral) call.getOperands().get(1)).getValueAs(String.class));
    }
        super.setUp();
    private SqlFunction convertTzOp(RelDataType returnType) {
        assertEquals(org.apache.calcite.sql.SqlKind.SAFE_CAST, ((RexCall) adapted).getOperator().getKind());
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
    }
    }
        assertSame(ConvertTzAdapter.LOCAL_CONVERT_TZ_OP, call.getOperator());
    /**
    }
            adapted.getType()
        RexNode tsLiteral = rexBuilder.makeLiteral("2021-05-12 11:34:50");
import org.apache.calcite.sql.type.SqlTypeName;
            call.getOperator()
        assertEquals("-13:59", ConvertTzAdapter.canonicalizeTz("-13:59"));
     */
            null,
 */
    private RelOptCluster cluster;
import org.apache.calcite.sql.SqlFunctionCategory;
 * SPDX-License-Identifier: Apache-2.0
    /**
        RexCall call = (RexCall) adapted;
public class ConvertTzAdapterTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
    }
        // Column refs for the tz slots — not literals, so no canonicalization.
     * {@code Project.isValid} compatibleTypes check breaks at fragment
        // Pair of distinct-canonical offsets so the fold path doesn't fire.
        assertTrue(adapted instanceof RexLiteral);
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
        RexCall original = (RexCall) rexBuilder.makeCall(convertTzOp(tsType), List.of(tsRef, fromCol, toCol));
    public void testCanonicalizeTzRejectsOffsetsOutsideMysqlBand() {
        assertSame("identity fold must compare canonical forms", original.getOperands().get(0), adapted);
        // The Java adapter folds these to typed NULL at plan time; the catch in adapt()
 * The OpenSearch Contributors require contributions made to
        RexCall original = buildConvertTz("UTC", "UTC");
 * the same value, plan-time validation/canonicalization of literal tz operands,
        expectThrows(IllegalArgumentException.class, () -> ConvertTzAdapter.canonicalizeTz("+14:01"));
    }
    // ── Canonicalization (unit tests on the static helper) ────────────────
        RexNode toCol = rexBuilder.makeInputRef(stringType, 2);
            assertTrue(((RexLiteral) adapted).isNull());
        assertEquals(
        );
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            "adapted call's return type must equal the original — otherwise Project.rowType assertion fails",
            SqlFunctionCategory.TIMEDATE
     * operands. The tz strings passed to the UDF are the canonical form.
        );
        assertTrue(adapted instanceof RexCall);
        );
    }
        RelDataType returnType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 9), true);
     * Identity fold: when both tz literals canonicalize to the same value, the
        assertSame("column-valued to_tz must pass through unmodified", toCol, call.getOperands().get(2));
        typeFactory = new JavaTypeFactoryImpl();
    }
        RexCall original = buildConvertTz("+5:00", "+10:00");
import org.apache.calcite.sql.SqlKind;
        RexNode toTz = rexBuilder.makeLiteral("UTC");
    public void testAdaptOutOfBandOffsetLiteralReturnsTypedNull() {
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
        RexCall call = (RexCall) adapted;
        assertTrue(adapted instanceof RexCall);
    }
    public void testCanonicalizeTzPadsOffsetDigits() {
        assertNotSame(tsLiteral, firstArg);
 */
        assertEquals(original.getType(), firstArg.getType());
package org.opensearch.be.datafusion;
            assertTrue("expected NULL literal for [" + pair[0] + "," + pair[1] + "], got " + adapted, adapted instanceof RexLiteral);
        for (String[] pair : new String[][] {
    public void setUp() throws Exception {
 * compatible open source license.
        assertTrue(adapted instanceof RexCall);
        // ZoneId.of passes through canonical ids unchanged.
}
        RexNode fromLit = rexBuilder.makeLiteral("America/New_York");
     * the UDF-bound call sees the canonical form so the Rust side doesn't need
     * call's Calcite-inferred type differs from the original, the enclosing
        RexNode tsRef = rexBuilder.makeInputRef(tsType, 0);
        assertTrue(firstArg instanceof RexCall);
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
        RexCall original = buildConvertTz("America/New_York", "Europe/London");
        assertEquals("+05:30", ConvertTzAdapter.canonicalizeTz("+5:30"));
    /** Out-of-band offset literal -> typed NULL (matches MySQL CONVERT_TZ semantics). */
import org.apache.calcite.sql.type.OperandTypes;
    /** Identity short-circuit with VARCHAR operand under a TIMESTAMP call → SAFE-cast. */
        RexNode toLit = rexBuilder.makeLiteral("Europe/London");
        assertEquals("Europe/London", ((RexLiteral) call.getOperands().get(2)).getValueAs(String.class));
     * {@code AbstractNameMappingAdapter} regression guard. If the rewritten
     */
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
        return new SqlFunction(
        assertTrue(((RexLiteral) adapted).isNull());
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> ConvertTzAdapter.canonicalizeTz("Mars/Olympus"));
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
            original.getType(),
            RexCall original = buildConvertTz(pair[0], pair[1]);
            ConvertTzAdapter.LOCAL_CONVERT_TZ_OP,
    /** unknown IANA literal -> typed NULL. */
        RexNode fromNode = rexBuilder.makeLiteral(fromLit);
import java.util.List;
    /**
    // ── adapt() behavior ──────────────────────────────────────────────────
    public void testCanonicalizeTzAcceptsBoundaryOffsets() {
        RelDataType returnType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 9), true);
    public void testAdaptPassesCanonicalizedLiteralsToUdf() {
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
 * priority order: identity short-circuit when both tz operands canonicalize to
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexNode fromCol = rexBuilder.makeInputRef(stringType, 1);
    }
        // return NULL, matching ConvertTZFunctionIT#nullField2Under / nullField3Over.
    public void testAdaptIdentityFoldReturnsTimestampUnchanged() {
        expectThrows(IllegalArgumentException.class, () -> ConvertTzAdapter.canonicalizeTz("+15:00"));
     */
import org.apache.calcite.rex.RexCall;
        assertSame(ConvertTzAdapter.LOCAL_CONVERT_TZ_OP, call.getOperator());
import org.apache.calcite.sql.type.ReturnTypes;
        assertEquals(original.getType(), adapted.getType());
     * conversion.
            "CONVERT_TZ",
    }
/**
import org.apache.calcite.plan.hep.HepPlanner;
    /**
            assertEquals(original.getType(), adapted.getType());
        assertTrue("error must include the bad value for UX: " + ex.getMessage(), ex.getMessage().contains("Mars/Olympus"));
import org.apache.calcite.sql.SqlFunction;
        RexCall call = (RexCall) adapted;
        RexCall original = (RexCall) rexBuilder.makeCall(convertTzOp(returnType), List.of(tsLiteral, fromTz, toTz));
        assertEquals("+14:00", ConvertTzAdapter.canonicalizeTz("+14:00"));
import org.apache.calcite.rel.type.RelDataType;
        RexCall original = (RexCall) rexBuilder.makeCall(convertTzOp(returnType), List.of(tsLiteral, fromTz, toTz));
        assertEquals("+05:00", ((RexLiteral) call.getOperands().get(1)).getValueAs(String.class));
 * per-row shifting stays in the Rust UDF since IANA offsets vary per instant.
    }
        assertEquals("America/New_York", ConvertTzAdapter.canonicalizeTz("America/New_York"));
        // 2-arg makeLiteral matches PPL's frontend; the nullable 3-arg form would wrap in CAST
     * call rewrites to the local UDF operator with canonicalized string
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
        assertEquals(org.apache.calcite.sql.SqlKind.SAFE_CAST, ((RexCall) firstArg).getOperator().getKind());
    /**
    private RexCall buildConvertTz(String fromLit, String toLit) {
     * When literal operands need canonicalization (e.g. `+5:00` → `+05:00`),
    /**
    private RelDataTypeFactory typeFactory;
     * are the same zone but different strings; the adapter must canonicalize
        expectThrows(IllegalArgumentException.class, () -> ConvertTzAdapter.canonicalizeTz("+05:60"));
        assertEquals(original.getType(), call.getType());
     * first, then compare.
        RexNode toTz = rexBuilder.makeLiteral("America/Los_Angeles");
    @Override
        assertEquals("+10:00", ((RexLiteral) call.getOperands().get(2)).getValueAs(String.class));
        }
        RexNode adapted = new ConvertTzAdapter().adapt(original, List.of(), cluster);
     * call reduces to its timestamp operand. No UDF invocation.
        cluster = RelOptCluster.create(planner, rexBuilder);
        RelDataType stringType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
    public void testAdaptedCallPreservesOriginalReturnType() {
/*
    public void testAdaptIanaPairRoutesThroughUdfWithCanonicalLiterals() {
    }
    public void testIdentityShortCircuitWrapsInSafeCastWhenOperandTypeDiffers() {
        RexNode firstArg = call.getOperands().get(0);
            "adapted call must target LOCAL_CONVERT_TZ_OP so FunctionMappings.Sig binds",
     * Column-valued tz operands are not validated at plan time — per-row
        assertEquals(originalType, original.getType());
        }) {
     * to do the padding.
    }
        RexNode tsRef = rexBuilder.makeInputRef(tsType, 0);
     * Adapter preserves the original call's return type — matches the
            OperandTypes.ANY_STRING_STRING,
        RelDataType tsType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
import org.apache.calcite.rex.RexLiteral;
        assertSame(ConvertTzAdapter.LOCAL_CONVERT_TZ_OP, call.getOperator());
        expectThrows(IllegalArgumentException.class, () -> ConvertTzAdapter.canonicalizeTz("-14:00"));
    public void testCanonicalizeTzAcceptsIanaNames() {
        // turns the IAE into a NULL literal so callers see {@code SELECT CONVERT_TZ(...,'-14:00','+08:00')}

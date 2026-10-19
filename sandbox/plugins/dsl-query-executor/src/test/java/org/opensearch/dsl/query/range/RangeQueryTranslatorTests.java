    }
    /**
    public void testLteOnScaledFloat() throws ConversionException {
        assertEquals(2, lowerRef.getIndex());
    /**
        );
        assertLiteralNumber(result, Integer.valueOf(11), null);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("timestamp").lt(-4503599627370495.5), ctx);
        assertEquals(
        RexLiteral literal = (RexLiteral) result;
        // Type must be TIMESTAMP(9)
        assertEquals(3, ((RexInputRef) lowerBound.getOperands().get(0)).getIndex());
    public void testDateMathWithFormat() throws ConversionException {
    /**
    /**
        RexCall call = (RexCall) result;
    }
    }
            () -> translator.convert(QueryBuilders.rangeQuery("timestamp").gte("NaN"), ctx)
        RexCall call = (RexCall) result;
    /**
        assertEquals((byte) 1, bytes[15]);
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lt(500), ctx);
        assertEquals(2, call.getOperands().size());
    }
        assertEquals("Expected DOUBLE type for double value on DOUBLE field", SqlTypeName.DOUBLE, literal.getTypeName());
    }
    }
        assertTrue("Upper bound above SMALLINT max should produce IS_NOT_NULL (no constraint)", result instanceof RexCall);
        );
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
     * gt vs gte at a nanosecond boundary must differ by rounding.
            ConversionException.class,
        assertLiteralEpoch(result, -14256000000L);
        RexLiteral lit = unwrapLiteral(call.getOperands().get(1));
        assertEquals(SqlTypeName.TIMESTAMP, literal.getType().getSqlTypeName());
        assertNotEquals("Long value on numeric field should NOT produce TIMESTAMP type", SqlTypeName.TIMESTAMP, literal.getTypeName());
        // lt -1 on unsigned_long: negative upper → match-none.
     */
        // Decimal-adjust: truncate -> 4503599627370495, positive -> increment -> >= 4503599627370496
    private void assertLiteralString(RexNode comparison, String expectedValue) {
                || ex.getMessage().contains("NumberFormat")
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lte(Integer.MIN_VALUE), ctx);
    public void testNaNDoubleOnUnsignedLongThrows() {
}
        // lte 10.5 with factor 10 -> 105, inclusive, LTE
        // The error may come from coercion (Long overflow) or from our explicit check.
    }
     * gt on ip field produces GREATER_THAN (exclusive).
        // Verify clamped to MAX_NANOSECOND_INSTANT via TimestampString
        RexCall upperBound = (RexCall) call.getOperands().get(1);
        assertEquals(2, call.getOperands().size());
        assertLiteralNumber(result, Integer.valueOf(Integer.MAX_VALUE), null);
        assertTrue(
        expectThrows(ConversionException.class, () -> translator.convert(query, ctx));
    public void testEpochMillisInvalidValueThrows() {
        assertTrue(ex.getMessage().contains("Infinity") || ex.getMessage().contains("non-finite"));
    }
     * 10 zero bytes + 0xff 0xff + 192(0xc0) 168(0xa8) 0(0x00) 1(0x01).
     * lt -2147483648.5 on INTEGER field returns FALSE (match-none). Overflow guard:
    public void testNonNumericBoundOnUnsignedLongThrows() {
            return ((RexLiteral) cast.getOperands().get(0)).getValueAs(Long.class);
        assertNotNull("Could not unwrap literal from: " + operand1, literal);
        RexLiteral lowerLit = unwrapLiteral(lower.getOperands().get(1));
        assertTrue(
        assertNotNull(literal);
        );
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        RexCall call = (RexCall) result;
    }
     */
        RexNode gtResult = translator.convert(QueryBuilders.rangeQuery("event_nanos").gt("2026-07-28"), ctx);
        assertEquals(1, ((RexInputRef) upperBound.getOperands().get(0)).getIndex());
    public void testGteBelowTinyintMinNoConstraint() throws ConversionException {
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
        assertTrue("TimestampString must start with 2026-07-28, got: " + tsStr, tsStr.startsWith("2026-07-28"));
    /** Infinity as raw Double on unsigned_long must throw ConversionException. */
        String gtStr = gtTs.toString();
        org.apache.calcite.util.TimestampString gteTs = gteLiteral.getValueAs(org.apache.calcite.util.TimestampString.class);
                return unwrapLiteral(call.getOperands().get(0));
        assertLiteralString(lowerBound, "apple");
            () -> translator.convert(QueryBuilders.rangeQuery("event_nanos").gte("-1").format("epoch_millis"), ctx)
        assertEquals((byte) 168, bytes[13]);
        assertTrue(result instanceof RexCall);
            "Message should mention out of range or overflow: " + ex.getMessage(),
    public void testIntegerMinValueStillWorks() throws ConversionException {
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        RexCall call = (RexCall) result;
        assertEquals((byte) 192, bytes[12]);
        assertEquals(Double.valueOf(99.5), literal.getValueAs(Double.class));
        RexCall lowerBound = (RexCall) call.getOperands().get(0);
     */
        RexNode result = translator.convert(QueryBuilders.rangeQuery("ip_address").gte("192.168.0.1"), ctx);
        assertEquals(Long.valueOf(15L), extractLiteralLong(call.getOperands().get(1)));
            ConversionException.class,
        assertTrue(result instanceof RexCall);
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);
        assertTrue("Expected RexCall comparison, got: " + comparison.getClass(), comparison instanceof RexCall);
        assertEquals(SqlKind.GREATER_THAN, call.getKind());
            ConversionException.class,
        );
     */
        assertEquals(2, upperRef.getIndex());
        assertTrue(result instanceof RexCall);
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Infinity")
    public void testIntegerMaxValueStillWorks() throws ConversionException {
        assertNotNull(ts);
        assertEquals(SqlKind.AND, call.getKind());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte(Double.NaN), ctx);
     */
     * gt decimal on BIGINT field performs correct decimal-adjust with increment.
        throw new AssertionError("Expected RexLiteral or CAST(RexLiteral), got: " + node.getClass().getSimpleName());
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Infinity")
     * 2022-01-31T23:59:59.999Z = 1643673599999L.
        RexNode result = translator.convert(QueryBuilders.rangeQuery("ip_address").gte("10.0.0.0").lte("10.0.0.255"), ctx);
    public void testNaNStringOnBigintThrows() {
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        // Value as Long should be epoch millis
     * Unmapped field returns literal false (match-none), matching legacy DISJOINT for null fieldType.
        assertEquals(SqlTypeName.TIMESTAMP, literal.getType().getSqlTypeName());
        RexCall call = (RexCall) result;
        assertEquals(2, call.getOperands().size());
    public void testGteAboveSmallintMaxMatchesNone() throws ConversionException {
    }
     * String "100" on numeric field coerces to numeric 100, not TIMESTAMP.
        RexCall call = (RexCall) result;
    /**
    // ========== GROUP R4 - NON-FINITE ON DOUBLE (must NOT throw) ==========
        // When the only bound returns null, translator produces IS_NOT_NULL (exists semantics)
    }
    private static Long extractLiteralLong(RexNode node) {
        );
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lt(-2147483648.5), ctx);
    // ========== GROUP I - OVERFLOW GUARDS ==========
            "Message should mention non-finite or Infinity: " + ex.getMessage(),
    public void testGtOnScaledFloat() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("now-7d/d").lte("now/d"), ctx);
    }
    public void testOverflowBoundScaledFloatReturnsFalse() {
                || ex.getMessage().contains("numeric")
    }
    }
        assertEquals(2, call.getOperands().size());
     * Upper bound rounding on date_nanos: lte "2026-07-28" rounds UP to end-of-day at nano
        ConversionException ex = expectThrows(
    public void testLtDateRoundsDownExclusive() throws ConversionException {
        if (node instanceof RexLiteral lit) {
     */
        );
     * gte -10.5 on INTEGER field produces gte -10. Per NumberFieldMapper INTEGER.rangeQuery: negative decimal lower bound, no increment.
        Long millis = literal.getValueAs(Long.class);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gt(10.5), ctx);
    // ========== GROUP D - ROUNDING EDGE CASES ==========
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
     * String bounds on VARCHAR field produce lexicographic comparisons without date parsing.
            QueryBuilders.rangeQuery("rating").gte("01/01/2022").lte("31/12/2022").format("dd/MM/yyyy"),
        );
        assertEquals(2, call.getOperands().size());
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lower.getKind());
    }
        // Assert literal values and type
        assertEquals(Boolean.FALSE, lowerLit.getValueAs(Boolean.class));
        if (node instanceof RexCall) {
     * The guard that previously threw ConversionException has been removed; date_nanos is now
        RexCall call = (RexCall) result;
    }
        assertTrue("Non-finite on DOUBLE should produce a RexCall, not throw", result instanceof RexCall);
        // gte rounds down to start of day (no fractional part or all zeros)
    }
    }
    public void testContainsRelationIgnoredOnScalarField() throws ConversionException {
    }
        assertEquals(9, literal.getType().getPrecision());
        assertTrue("Message should mention binary fields: " + ex.getMessage(), ex.getMessage().contains("binary"));
    }
    }
    // ========== END OF TESTS ==========
    public void testIpRangeBothBounds() throws ConversionException {
 * SPDX-License-Identifier: Apache-2.0
        // Must NOT be mistyped as TIMESTAMP — DECIMAL/INTEGER/BIGINT are all acceptable
    public void testDateNanosGtVsGteDifferByRounding() throws ConversionException {
    public void testBoundAboveLongMaxOnUnsignedLongThrows() {
        assertTrue("Unmapped field should produce literal false", result instanceof RexLiteral);
        ConversionException ex = expectThrows(
    public void testInfinityStringOnScaledFloatRangeThrows() {
        assertEquals(2, upperRef.getIndex());
        assertEquals(SqlKind.LESS_THAN, call.getKind());
     * gte("2022-06-15||/M") rounds down to start of month: 2022-06-01T00:00:00Z = 1654041600000L.
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(100), ctx);
    public void testBooleanRangeLtFalse() throws ConversionException {
        RexCall upper = (RexCall) call.getOperands().get(1);
        RexCall call = (RexCall) result;
        assertEquals("price", ctx.getRowType().getFieldList().get(1).getName());
     * Range query on binary_data field (plain VARBINARY, not IpType) throws ConversionException.
        );
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("now-7d"), ctx);
    // ========== GROUP T - TINYINT/SMALLINT BOUNDARY (MATCH-NONE / NO-CONSTRAINT) ==========
        if (expectedType != null) {
        RexLiteral lowerLit = unwrapLiteral(lowerBound.getOperands().get(1));
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    }
    /** Positive Infinity as raw Double on INTEGER must throw ConversionException. */
    /** "Infinity" on REAL (float_val) must throw ConversionException. */
        );
        assertEquals(12, ((RexInputRef) call.getOperands().get(0)).getIndex());
     */
    }
        assertEquals(SqlKind.AND, call.getKind());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").gte(10.55), ctx);
        RangeQueryBuilder query = QueryBuilders.rangeQuery("price").gte(100);
        RexCall call = (RexCall) result;
        assertEquals(Long.valueOf(-52L), extractLiteralLong(call.getOperands().get(1)));
    }
        }
        ConversionException ex = expectThrows(
    private void assertLiteralNumber(RexNode comparison, Number expectedValue, SqlTypeName expectedType) {
    }
        );
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_nanos").gte("2026-07-28T00:00:00.123456789"), ctx);
    /**
    public void testGtDecimalOnIntegerFieldPositive() throws ConversionException {
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lte(500), ctx);
        );
     * gt "2026-07-28" uses roundUp=true (exclusive lower), producing end-of-day nanos.
     * gte("192.168.0.1") on ip field produces VARBINARY literal with IPv4-mapped-IPv6 encoding:
        assertTrue(result instanceof RexCall);
        assertTrue(result instanceof RexCall);
 * this file be licensed under the Apache-2.0 license or a
    public void testInfinityStringOnRealThrows() {
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("now-1d/d"), ctx);
    public void testNaNStringOnScaledFloatThrows() {
            () -> translator.convert(QueryBuilders.rangeQuery("price").gte("Infinity"), ctx)
        assertEquals(SqlKind.AND, call.getKind());
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
     * lt 10.5 on INTEGER field produces lte 10. Per NumberFieldMapper INTEGER.rangeQuery: positive decimal upper bound, no decrement.
    // ========== GROUP Q - BOOLEAN RANGE PARITY ==========
            return (RexLiteral) node;
        RexCall call = (RexCall) result;
    /** epoch_millis is absolute; timeZone parameter does not shift the value. */
        // getValueAs(Long.class) returns the internal millis representation
        assertNotNull(literal);
    public void testDateMathRounding() throws ConversionException {
            "Message should mention non-finite: " + ex.getMessage(),
    /**
    }
        RexLiteral literal = (RexLiteral) result;
        RexCall call = (RexCall) result;
        RexCall lower = (RexCall) call.getOperands().get(0);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(-10.5), ctx);
        assertNotNull("Literal numeric value is null", actualValue);
     * Expected: 2022-12-31T23:59:59.999Z = 1672531199999L.
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gt("2022-01-01"), ctx);
            ConversionException.class,
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
    // ========== GROUP E - PARAMETER AUDIT ==========
     */
     * REGRESSION: plain date field (event_time, precision 3) still yields precision-3 millis literal.
    public void testGteStringWholeNumberOnUnsignedLong() throws ConversionException {
        // gt rounds up to end of day: 23:59:59.999999999
 *
        // then l(0) > u(0 after exclusive decrement = underflow) → MatchNoDocsQuery.
    /**
    /** Regression: NaN on scaled_float still throws (existing guard). */
    /**
        assertEquals("IPv6-mapped encoding must be 16 bytes", 16, bytes.length);
    public void testGteAboveIntegerMaxThrows() {
        org.apache.calcite.util.TimestampString ts = literal.getValueAs(org.apache.calcite.util.TimestampString.class);
        );
        RexCall call = (RexCall) result;
     * regardless of INTERSECTS, CONTAINS, or WITHIN.
    }
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lowerBound.getKind());
    }
    public void testDateNanosLiteralPreservesFullNanoPrecision() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gt("now-1d/d"), ctx);
        assertEquals(2, call.getOperands().size());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").lte("now/d"), ctx);
     * gt -10.5 on INTEGER field produces gte -10. Per NumberFieldMapper INTEGER.rangeQuery: negative decimal lower bound, no increment.
    }
    /** lte -40000 on SMALLINT (min=-32768) -> match-none. */
            () -> translator.convert(QueryBuilders.rangeQuery("price").gte("NaN"), ctx)
        RexCall andCall = (RexCall) result;
    public void testIpRangeInvalidIpThrows() {
    public void testLt() throws ConversionException {
     * lt "2022-01-01" on date field rounds DOWN (start-of-day) because exclusive upper bound
     */
    }
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
        );
        assertEquals(SqlTypeName.CHAR, upperLit.getTypeName());
    // ========== GROUP M - IP RANGE VALUE CORRECTNESS ==========
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        assertTrue(result instanceof RexCall);
        assertEquals(Long.valueOf(106L), extractLiteralLong(call.getOperands().get(1)));
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_nanos").gte("2022-01-01"), ctx);
     */
    }
        // RangeQueryBuilder.relation("DISJOINT") throws IllegalArgumentException because
        assertEquals(1, ((RexInputRef) lowerBound.getOperands().get(0)).getIndex());
        assertEquals(1, call.getOperands().size());
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
    private void assertLiteralEpoch(RexNode comparison, long expectedEpochMillis) {
    /**
     * Legacy BinaryFieldMapper has no rangeQuery implementation.
        assertTrue("Expected RexCall comparison, got: " + comparison.getClass(), comparison instanceof RexCall);
        assertLiteralEpoch(result, 1643673599999L);
    }
    }
    /** gte(false) AND lte(true) selects both values; vanilla returns an existsQuery equivalent. */
     */
        // 4503599627370495.5 has exact double representation (below 2^52 boundary)
import org.opensearch.index.query.RangeQueryBuilder;
     * the given epoch millis value. Handles both direct RexLiteral and CAST-wrapped forms.
        assertEquals((byte) 0x01, bytes[15]);
        RexNode gteResult = translator.convert(QueryBuilders.rangeQuery("event_nanos").gte("2026-07-28"), ctx);
    }
        assertEquals(Long.valueOf(101L), extractLiteralLong(call.getOperands().get(1)));
        RexCall call = (RexCall) result;
    public void testInfinityStringOnIntegerThrows() {
     * and DateFieldType.rangeQuery() reject DISJOINT with IllegalArgumentException. However,
    public void testDateNanosUpperBoundRoundsToNanos() throws ConversionException {
     */
        assertTrue(result instanceof RexCall);
    public void testLteAboveSmallintMaxNoConstraint() throws ConversionException {
    }
            ConversionException.class,
        assertTrue(result instanceof RexCall);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte("100"), ctx);
    public void testGtDateRoundsUpExclusive() throws ConversionException {
        );
        ConversionException ex = expectThrows(
        expectThrows(
        );
        // -4503599627370495.5 has exact double representation, negative -> decrement
            () -> translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte("-Infinity"), ctx)
        assertTrue("Must clamp to 2262-04-11, got: " + tsStr, tsStr.startsWith("2262-04-11"));
    public void testLteDecimalOnIntegerFieldPositive() throws ConversionException {
     * gt "10.5" as String on INTEGER field behaves identically to gt 10.5 raw double: produces gte 11.
        );
        assertEquals((byte) 0xff, bytes[11]);
        RexCall call = (RexCall) result;
    }
        ConversionException ex = expectThrows(
        ConversionException ex = expectThrows(
    }
        org.apache.calcite.avatica.util.ByteString bs = literal.getValueAs(org.apache.calcite.avatica.util.ByteString.class);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    public void testRangeOnBinaryFieldThrows() {
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);
        assertTrue("Expected literal false (match-none)", result instanceof RexLiteral);
    }
        assertNotNull(gtTs);
        );
        RexCall call = (RexCall) result;
        );
    /**
    }
            ex.getMessage().contains("-Infinity") && ex.getMessage().contains("coerce")
    /** Double.NaN bound on scaled_float must throw ConversionException. */
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").lt(100), ctx);
    public void testRangeOnIpFieldProducesByteComparison() throws ConversionException {
        RexCall call = (RexCall) result;
    public void testTimeZoneShiftsEpoch() throws ConversionException {
        // IS_NOT_NULL (exists semantics) since the lower condition is omitted.
        );
        // gt 10.5 with factor 10 -> Math.round(10.5 * 10) = 105, +1 for exclusive = 106, GTE
        assertTrue(result instanceof RexCall);
     */
    }
        assertTrue(result instanceof RexCall);
     * Unwraps a RexNode to get the underlying RexLiteral, handling CAST wrappers.
     * not passed to DNS resolution.
    // ========== GROUP A - VALUE CORRECTNESS ==========
        RexLiteral lowerLit = unwrapLiteral(lowerBound.getOperands().get(1));
    /**
        expectThrows(IllegalArgumentException.class, () -> QueryBuilders.rangeQuery("price").gte(100).relation("DISJOINT"));
    }
        // With only a lower bound that is negative → null returned from translateBound → no conditions → IS_NOT_NULL
        ConversionException ex = expectThrows(
    /**
        );
        assertEquals(9, literal.getType().getPrecision());
    }
        assertTrue(result instanceof RexCall);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gte("01/01/2022").format("dd/MM/yyyy"), ctx);
    public void testLongValueOnNumericFieldKeepsFieldType() throws ConversionException {
        RexCall call = (RexCall) result;
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lte(10.5), ctx);
        assertTrue(result instanceof RexCall);
            () -> translator.convert(QueryBuilders.rangeQuery("price").gte(2147483648L), ctx)
    public void testNaNDoubleOnBigintThrows() {
            ex.getMessage().contains("out of range") || ex.getMessage().contains("overflow")
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("tiny_val").gte(-200), ctx);
        assertEquals(1, fieldRef.getIndex());
            () -> translator.convert(QueryBuilders.rangeQuery("scaled_price").gte("Infinity"), ctx)
    public void testGtDateMathExplicitRounding() throws ConversionException {
        assertTrue("Must contain .854775807, got: " + tsStr, tsStr.contains(".854775807"));
    public void testBooleanRangeGteFalseAndLteTrue() throws ConversionException {
    }
            ConversionException.class,
        );
    /**
     */
    public void testWithIntersectsRelation() throws ConversionException {
        assertTrue(result instanceof RexCall);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("brand").gt("apple").lt("dell"), ctx);
     */
    // ========== UNSIGNED_LONG RANGE TESTS ==========
    }
        assertEquals(SqlTypeName.CHAR, upperLit.getTypeName());
    public void testNegativeValueOnScaledFloat() throws ConversionException {
        RexNode operand1 = call.getOperands().get(1);
import org.apache.calcite.rex.RexLiteral;
    /** gte 40000 on SMALLINT (max=32767) -> match-none. */
        assertTrue(result instanceof RexCall);
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);
     * (isRelationAllowed returns false), so our translator never sees it. This test asserts
            "Message should name the rejected value and the coercion failure: " + ex.getMessage(),
    }
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        ConversionException ex = expectThrows(
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
            ConversionException.class,
     * Verifies CONTAINS relation is silently ignored on scalar fields, matching legacy behavior.
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
/*
            ConversionException.class,
    /**
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte(-5), ctx);
        assertEquals(SqlKind.GREATER_THAN, call.getKind());
            ConversionException.class,
        assertTrue("Expected RexCall comparison, got: " + result.getClass(), result instanceof RexCall);
     */
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").gte(10.5), ctx);
     * supported via nanosecond-resolution parsing and TIMESTAMP(9) literals.
            "Message should mention non-finite or Infinity or above: " + ex.getMessage(),
    }
        RexCall call = (RexCall) result;
    // here as ordinary comparisons that SQL evaluates identically.
        assertTrue(
     * No bounds produces IS_NOT_NULL, matching legacy RangeQueryBuilder.doToQuery exists rewrite.
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("tiny_val").lte(200), ctx);
        // Assert exclusive operators
    public void testLtDecimalAtLongMinMatchesNone() throws ConversionException {
    public void testNaNDoubleOnIntegerThrows() {
        assertEquals(Boolean.TRUE, upperLit.getValueAs(Boolean.class));
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Infinity")
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        // Must NOT be mistyped as TIMESTAMP — DECIMAL/INTEGER/BIGINT are all acceptable
    public void testUnknownFieldMatchesNone() throws ConversionException {
            () -> translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte("NaN"), ctx)
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte("100"), ctx);
            "Expected message about value before epoch, got: " + ex.getMessage(),
        Number actualValue = literal.getValueAs(expectedValue.getClass());
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        assertEquals(Long.valueOf(104L), extractLiteralLong(call.getOperands().get(1)));
        expectThrows(IllegalArgumentException.class, () -> QueryBuilders.rangeQuery("price").gte(100).timeZone("Invalid/NotAZone"));
    public void testBothBounds() throws ConversionException {
        assertLiteralString(upperBound, "dell");
    }
        assertTrue("Expected RexCall comparison, got: " + comparison.getClass(), comparison instanceof RexCall);
        assertEquals(Long.valueOf(50L), extractLiteralLong(lower.getOperands().get(1)));
    /**
        // 2300-01-01 is far beyond MAX_NANOSECOND_INSTANT (2262-04-11T23:47:16.854775807Z)
        RexCall gtCall = (RexCall) gtResult;
    public void testGtDecimalAtLongMaxMatchesNone() throws ConversionException {
        );
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upperBound.getKind());
        assertEquals(1, fieldRef.getIndex());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").lte("31/12/2022").format("dd/MM/yyyy"), ctx);
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lt(-10.5), ctx);
        RexLiteral lit = unwrapLiteral(call.getOperands().get(1));
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unknown").gte(1), ctx);
        RexCall call = (RexCall) result;
        assertNotNull(literal);
            ConversionException.class,
    public void testNaNStringOnUnsignedLongThrows() {
                || ex.getMessage().contains("overflow")
        assertTrue(result instanceof RexCall);
    }
        assertNotNull(literal);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("now-1M/M"), ctx);
    public void testFarFutureDateOnNanosFieldClampsToMax() throws ConversionException {
     * Verifies WITHIN relation is silently ignored on scalar fields, matching legacy behavior.
        // makeLiteral wraps nullable types in CAST
        RexNode result = translator.convert(QueryBuilders.rangeQuery("timestamp").gt(4503599627370495.5), ctx);
        );
        // gte 5.0 AND lte 20.0 with factor 10 -> 50 (inclusive) AND 200 (inclusive)
    /**
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").lt(-1), ctx);
        assertNotNull(literal);
    /**
        );
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    // ========== GROUP K - DOCUMENTATION TESTS ==========
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(100).lte(500), ctx);
        );
     */
        assertTrue(result instanceof RexCall);
        RexNode result = translator.convert(
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    /** gte(100) on numeric field produces literal 100 with Calcite canonical DECIMAL type. */
    }
        RexCall call = (RexCall) result;
     * Year-2262 clamping: date beyond MAX_NANOSECOND_INSTANT (~2262-04-11) is clamped
    }
    }
    public void testPositiveInfinityDoubleOnBigintThrows() {
        // (inclusive) bound becomes 2" — positive decimal lower increments after truncation.
            ConversionException.class,
     * Calcite canonically types exact-numeric literals as DECIMAL.
        // 2300-01-01 is beyond MAX_NANOSECOND_INSTANT (2262-04-11T23:47:16.854775807Z)
        assertLiteralEpoch(result, 1640995200000L);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("small_val").lte(-32768), ctx);
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
        RexLiteral upperLit = unwrapLiteral(upper.getOperands().get(1));
    }
    }
    }
            "Message should mention non-finite or NaN: " + ex.getMessage(),
    }
        assertEquals(1, fieldRef.getIndex());
        // Assert operators
        RexCall call = (RexCall) result;
     */
        ConversionException ex = expectThrows(
    }
     * Double value on DOUBLE field produces DOUBLE-typed literal with exact value.
    /** NaN on REAL (float_val) must throw ConversionException. */
        if (node instanceof RexCall cast && cast.getKind() == SqlKind.CAST) {
            () -> translator.convert(QueryBuilders.rangeQuery("price").lte(-2147483649L), ctx)
    public void testBothBoundsScaledFloatProducesAnd() throws ConversionException {
    }
        assertEquals(9, literal.getType().getPrecision());
        assertLiteralNumber(result, Integer.valueOf(-11), null);
package org.opensearch.dsl.query.range;
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gte("1785369600123").format("epoch_millis"), ctx);
        assertEquals(Boolean.TRUE, lit.getValueAs(Boolean.class));
            }
        assertEquals(SqlTypeName.DECIMAL, literal.getTypeName());
        RexCall call = (RexCall) result;
        assertTrue("Lower bound above SMALLINT max must produce literal false (match-none)", result instanceof RexLiteral);
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
        assertEquals(3, ((RexInputRef) lowerBound.getOperands().get(0)).getIndex());
    }
            () -> translator.convert(QueryBuilders.rangeQuery("event_time").gte("abc").format("epoch_millis"), ctx)
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Infinity")
        RexCall call = (RexCall) result;
        org.apache.calcite.util.TimestampString ts = literal.getValueAs(org.apache.calcite.util.TimestampString.class);
     */
        assertEquals(5, ((RexInputRef) upper.getOperands().get(0)).getIndex());
    public void testIpRangeIpv4EncodingValue() throws ConversionException {
     * uses roundUp=true per DateFieldMapper.dateRangeQuery (roundUp=!includeLower).
        assertLiteralNumber(result, Integer.valueOf(10), null);
        assertTrue(result instanceof RexCall);
        RexNode operand1 = call.getOperands().get(1);
        assertTrue(
    }
        assertEquals("Value should be 100", Long.valueOf(100L), literal.getValueAs(Long.class));
            ctx
        assertEquals(RangeQueryBuilder.class, translator.getQueryType());
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.rangeQuery("ip_address").gte("localhost"), ctx));
        assertEquals("IPv6 encoding must be 16 bytes", 16, bytes.length);
        RangeQueryBuilder query = QueryBuilders.rangeQuery("price").gte(100);
        RexCall call = (RexCall) result;
    /**
        assertTrue(
        RexLiteral lowerLit = unwrapLiteral(lower.getOperands().get(1));
        RexNode operand1 = call.getOperands().get(1);
     */
            withoutRelation.toString(),
        assertLiteralNumber(result, Integer.valueOf(11), null);
    }
        assertLiteralNumber(result, Integer.valueOf(-11), null);
     */
        String tsStr = ts.toString();
        for (int i = 0; i < 10; i++) {
        // Epoch millis is absolute; timezone should be irrelevant
        assertEquals(2, upperBound.getOperands().size());
        RexCall gteCall = (RexCall) gteResult;
        RexCall call = (RexCall) result;
    /**
    // ========== STRING-COERCED NUMERIC BOUND TESTS ==========
        assertEquals(2, call.getOperands().size());
        // End of 2022-12-31 = 1672531199999L
        assertLiteralEpoch(result, 1640995200000L);
    // Parity with BooleanFieldMapper.BooleanFieldType.rangeQuery:309 which converts bounds to
        String tsStr = ts.toString();
        assertEquals(2, call.getOperands().size());
     */
        assertEquals(5, ((RexInputRef) lower.getOperands().get(0)).getIndex());
        RexCall call = (RexCall) result;
        assertEquals("Epoch millis mismatch", expectedEpochMillis, actualValue.longValue());
    /**
    }
    public void testIpRangeIpv6EncodingValue() throws ConversionException {
        RexCall call = (RexCall) result;
        );
        assertTrue(
            ConversionException.class,
    }
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    /**
        assertTrue(
        RexCall call = (RexCall) result;
            "WITHIN relation must produce identical expression to no-relation (legacy scalar behavior)",
        Long actualValue = literal.getValueAs(Long.class);
        assertTrue(
import org.opensearch.dsl.TestUtils;
        assertTrue("Lower bound below TINYINT min should produce IS_NOT_NULL (no constraint)", result instanceof RexCall);
    public void testNegativeEpochMillisOnDateNanosFieldThrows() {
    }
    public void testPositiveInfinityDoubleOnIntegerThrows() {
        assertTrue(
        RexNode withWithin = translator.convert(QueryBuilders.rangeQuery("price").gte(100).relation("WITHIN"), ctx);
        assertEquals(2, lowerBound.getOperands().size());
    public void testLtOnUnsignedLongExclusiveWholeNumber() throws ConversionException {
        RexLiteral literal = unwrapLiteral(operand1);
        RexLiteral literal = unwrapLiteral(operand1);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lowerBound.getKind());
        assertEquals(2, call.getOperands().size());
            ConversionException.class,
        assertEquals(
     */
    public void testLteAboveTinyintMaxNoConstraint() throws ConversionException {
     */
        RexInputRef lowerRef = (RexInputRef) lowerBound.getOperands().get(0);
        RexCall call = (RexCall) result;
            "Message should mention non-finite or Infinity: " + ex.getMessage(),
        assertEquals(Long.valueOf(106L), extractLiteralLong(call.getOperands().get(1)));
        assertEquals(SqlKind.AND, call.getKind());
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lower.getKind());
import org.apache.calcite.rex.RexInputRef;
            ctx
    }
            QueryBuilders.rangeQuery("rating").gte("2022-01-01T00:00:00").timeZone("America/New_York"),
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").lt("now/y"), ctx);
        ConversionException ex = expectThrows(
    }
        assertNotNull("Could not unwrap literal from: " + operand1, literal);
    }
    }
        assertEquals(1, fieldRef.getIndex());
    /**
        RexCall call = (RexCall) result;
    }
        assertEquals(14, ((RexInputRef) call.getOperands().get(0)).getIndex());
    public void testLtOnScaledFloat() throws ConversionException {
     * RangeQueryBuilder.relation("DISJOINT") itself rejects DISJOINT at the builder level
        assertNotNull("TimestampString must not be null", ts);
    private final RangeQueryTranslator translator = new RangeQueryTranslator();
            "Message should mention out of range or overflow or numeric: " + ex.getMessage(),
        );
        assertEquals(Boolean.FALSE, literal.getValueAs(Boolean.class));
        assertTrue(result instanceof RexCall);
    /**
        ConversionException ex = expectThrows(
        assertTrue(result instanceof RexCall);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("ip_address").gte("192.168.0.1"), ctx);
    public void testHalfBoundaryGteScaledFloatRoundsUp() throws ConversionException {
        assertNotNull(ex.getMessage());
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gt("2022-01-01||/M"), ctx);
    }
        // gte 10.5 with factor 10 -> Math.round(10.5 * 10) = 105, inclusive, GTE
        // Value must be 100
            () -> translator.convert(QueryBuilders.rangeQuery("timestamp").gte(Double.NaN), ctx)
            ConversionException.class,
        // Only an upper bound that exceeds the type max; upper becomes null => IS_NOT_NULL (exists)
        assertEquals(3, literal.getType().getPrecision());
        assertLiteralEpoch(result, 1654041600000L);
import org.opensearch.test.OpenSearchTestCase;
     */
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    /** Far-future bound on date_nanos clamps to MAX_NANOSECOND_INSTANT (2262-04-11T23:47:16.854775807Z). */
        // RangeQueryBuilder.timeZone() calls ZoneId.of() which throws for invalid zones,
        RexCall call = (RexCall) result;
        );
        }
    /**
    public void testRoundingYearWithLt() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gte(1640995200000L), ctx);
    }
        assertEquals(2, call.getOperands().size());
    /**
    public void testRoundingWithGt() throws ConversionException {
        ConversionException ex = expectThrows(
        assertEquals((byte) 0xff, bytes[10]);
        RexCall call = (RexCall) result;
     * Asserts that the literal operand (operand 1) of a comparison RexCall represents
            ConversionException.class,
            ConversionException.class,
import org.opensearch.dsl.converter.ConversionException;
    /** Short.MIN_VALUE (-32768) on SMALLINT must still produce a valid comparison. */
        assertEquals(2, call.getOperands().size());
        assertTrue("Should contain .854775807: " + tsStr, tsStr.contains(".854775807"));
    public void testRoundingWithLte() throws ConversionException {
        assertTrue("Upper bound below SMALLINT min must produce literal false (match-none)", result instanceof RexLiteral);
            "Message should mention non-finite or NaN: " + ex.getMessage(),
        RexNode result = translator.convert(QueryBuilders.rangeQuery("small_val").lte(40000), ctx);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
     * Asserts that the literal operand (operand 1) of a comparison RexCall has the given
    public void testLexicographicRangeOnKeywordField() throws ConversionException {
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        RexNode operand1 = call.getOperands().get(1);
    }
     * since RangeQueryBuilder.timeZone() calls ZoneId.of() which validates immediately.
    /** gt(true) can never be satisfied; vanilla returns MatchNoDocsQuery for this impossible range. */
        assertEquals(Boolean.FALSE, literal.getValueAs(Boolean.class));
    /** Infinity on DOUBLE field must NOT throw -- legacy accepts non-finite doubles. */
        assertLiteralEpoch(result, 1640995200000L);
        assertTrue(result instanceof RexCall);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").lte("2022-01-01"), ctx);
        assertTrue(result instanceof RexCall);
    /** BUG 1 proof: NaN as raw Double on INTEGER silently produces bound of 0 instead of throwing. */
    }
    /** Integer.MAX_VALUE on INTEGER must still produce a valid comparison. */
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));
     * uses roundUp=false per DateFieldMapper.dateRangeQuery (roundUp=includeUpper=false).
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("small_val").gte(40000), ctx);
        RexCall call = (RexCall) result;
    }
import org.apache.calcite.rex.RexCall;
    /** Negative epoch_millis value on date_nanos field throws ConversionException. */
        assertEquals(SqlKind.LESS_THAN, call.getKind());
        RexCall call = (RexCall) result;
    }
        assertTrue(result instanceof RexCall);
     */
        assertTrue(
        );
        assertEquals(10, ((RexInputRef) call.getOperands().get(0)).getIndex());
    public void testGtDecimalOnIntegerFieldNegative() throws ConversionException {
        org.apache.calcite.util.TimestampString gtTs = gtLiteral.getValueAs(org.apache.calcite.util.TimestampString.class);
    public void testPreEpochDateOnMillisFieldProducesNegativeValue() throws ConversionException {
        RexCall call = (RexCall) result;
    /** Raw long value on date field produces timestamp literal at the given epoch millis. */
    }
        assertTrue(result instanceof RexCall);
     */
            "Message should name the rejected value and the coercion failure: " + ex.getMessage(),
     * lt negative decimal on BIGINT field performs correct decimal-adjust with decrement.
    // ========== GROUP C - NON-DATE FIELDS ==========
     * gt "2022-01-01||/M" on date field: exclusive lower bound -> roundUp=true per
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upperBound.getKind());
    }
     * In legacy OpenSearch, SimpleMappedFieldType.rangeQuery() and DateFieldType.rangeQuery()
        ConversionException ex = expectThrows(
        assertEquals(Boolean.TRUE, upperLit.getValueAs(Boolean.class));
    public void testInfinityStringOnBigintThrows() {
        RexCall call = (RexCall) result;
        // gt 100 (whole, exclusive) → exclusive adjusts: +1 = 101, GTE
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        assertEquals(SqlKind.GREATER_THAN, call.getKind());
     */
        assertTrue(
            () -> translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte("9223372036854775808"), ctx)
    /**
            assertEquals("Byte " + i + " should be 0x00", 0, bytes[i]);
        }
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lt(10.5), ctx);
        assertNotNull(call.getOperands().get(1));
    public void testRoundingMonthWithGte() throws ConversionException {
        RexLiteral literal = (RexLiteral) result;
        assertLiteralEpoch(result, 1640995200000L);
    public void testGtWholeDoubleOnIntegerField() throws ConversionException {
            ex.getMessage().contains("out of range")
    public void testDateMathAddition() throws ConversionException {
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        assertTrue("Non-finite on DOUBLE should produce a RexCall, not throw", result instanceof RexCall);
        assertNotNull(call.getOperands().get(1));
        assertTrue("gt should be end of 2026-07-28 with .999999999: " + gtStr, gtStr.contains("23:59:59.999999999"));
            ex.getMessage().contains("out of range") || ex.getMessage().contains("overflow")
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gt(10.0), ctx);
        ConversionException ex = expectThrows(
    }
        assertTrue(result instanceof RexCall);
        );
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
        RexCall call = (RexCall) result;
    // ========== GROUP P - CHARACTERIZATION: MILLIS vs NANOS BOUNDARY BEHAVIOUR ==========
        RexInputRef upperRef = (RexInputRef) upperBound.getOperands().get(0);
    public void testInfinityDoubleOnUnsignedLongThrows() {
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("NaN")
        RexCall call = (RexCall) result;
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    }
            ConversionException.class,
        assertTrue(result instanceof RexCall);
    public void testLte() throws ConversionException {
            ctx
     * whose epoch-nanosecond value ends in ...123456789 exactly. This verifies no truncation to millis.
        // Mirrors NumberFieldMapper.unsignedLongRangeQuery: "if lowerTerm=1.5 then the
        assertEquals(13, ((RexInputRef) call.getOperands().get(0)).getIndex());
    }
    /** lte 200 on TINYINT (max=127) -> no constraint (upper bound above max is unbounded). */
        assertTrue(
    /** Unwraps a nullable CAST around a RexLiteral produced by makeLiteral on a nullable type. */
     */
    /** lte -2147483649L on INTEGER must throw ConversionException. */
    public void testWithTimeZone() throws ConversionException {
        RexCall call = (RexCall) result;
        // Field ref at index 11 (ip_address)
            () -> translator.convert(QueryBuilders.rangeQuery("scaled_price").gte("NaN"), ctx)
        }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte(Double.POSITIVE_INFINITY), ctx);
     * lte("31/12/2022") with format("dd/MM/yyyy") rounds up to end-of-day.
    private final ConversionContext ctx = TestUtils.createContext();
    public void testRoundingWithGte() throws ConversionException {
        ConversionException ex = expectThrows(
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gte("2022-06-15||/M"), ctx);
        ConversionException ex = expectThrows(
            () -> translator.convert(QueryBuilders.rangeQuery("binary_data").gte("abc"), ctx)
    public void testNegativeInfinityDoubleOnDoubleFieldAccepted() throws ConversionException {
        );
    public void testFormatParsesToExactEpoch() throws ConversionException {
        assertLiteralNumber(result, Long.valueOf(-4503599627370496L), null);
    public void testDateNanosYear2262Clamp() throws ConversionException {
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        RexCall lowerBound = (RexCall) call.getOperands().get(0);
    /** NaN string bound on scaled_float must throw ConversionException, not silently produce 0. */
     * regardless of INTERSECTS, CONTAINS, or WITHIN.
            QueryBuilders.rangeQuery("event_time").gte("2022-01-01T00:00:00").timeZone("America/New_York"),
        assertEquals(SqlKind.AND, call.getKind());
    /** gte(true) AND lte(true) selects only true; vanilla collapses to termQuery(true). */
    public void testNumericStringOnNumericField() throws ConversionException {
    }
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
        assertTrue(
        ConversionException ex = expectThrows(
        assertEquals("rating", ctx.getRowType().getFieldList().get(3).getName());
    }
        RexCall call = (RexCall) result;
    public void testIpRangeHostnameLocalhostThrows() {
        // Per NumberFieldMapper.longRangeQuery: exclusive lower increments to make inclusive GTE.
        assertEquals(2, call.getOperands().size());
        assertEquals(2, call.getOperands().size());
        assertEquals(2, upperBound.getOperands().size());
    public void testInvalidTimeZoneThrows() {
        assertNotNull(literal);
     */
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").gte("1.5"), ctx);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lowerBound.getKind());
    }
            () -> translator.convert(QueryBuilders.rangeQuery("timestamp").gte("Infinity"), ctx)
     */
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lower.getKind());
 * The OpenSearch Contributors require contributions made to
     * Calcite may wrap literals in CAST when the type doesn't exactly match.
    /** NaN as raw Double on unsigned_long must throw ConversionException. */
        );
        assertEquals(Boolean.TRUE, lowerLit.getValueAs(Boolean.class));
        assertLiteralEpoch(result, 1641013200000L);
        assertEquals(SqlKind.GREATER_THAN, lowerBound.getKind());
        RexCall lowerBound = (RexCall) call.getOperands().get(0);
            ConversionException.class,
     */
        assertEquals(SqlKind.GREATER_THAN, call.getKind());
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
        ConversionException ex = expectThrows(
        assertTrue("Expected literal false (match-none)", result instanceof RexLiteral);
        RexNode withoutRelation = translator.convert(QueryBuilders.rangeQuery("price").gte(100), ctx);
    }
    public void testNaNDoubleOnScaledFloatThrows() {
     */
        // event_time is index 10 in the schema
            () -> translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte("not-a-number"), ctx)
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price"), ctx);
            ConversionException.class,
        assertTrue(result instanceof RexCall);
        assertEquals(5, ((RexInputRef) upper.getOperands().get(0)).getIndex());
        // Assert column reference
        assertTrue(result instanceof RexCall);
        assertTrue(result instanceof RexCall);
        assertLiteralNumber(result, Integer.valueOf(Integer.MIN_VALUE), null);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").lt(10.5), ctx);
            ConversionException.class,
    public void testBoundPastLongRangeOnBigintThrows() {
     * Both bounds on ip field produce AND of two byte comparisons with correct operators.
     * gt 2147483647.5 on INTEGER field returns FALSE (match-none). Overflow guard:
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lowerBound.getKind());
     * silently drop the relation parameter for scalar fields — the built query is identical
        RexCall call = (RexCall) result;
     * truncate to Integer.MAX_VALUE, increment would overflow, matching NumberFieldMapper MatchNoDocsQuery.
     * gt "2022-01-01" on date field rounds UP (end-of-day) because exclusive lower bound
        );
        RexInputRef upperRef = (RexInputRef) upperBound.getOperands().get(0);
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Infinity")
            () -> translator.convert(QueryBuilders.rangeQuery("price").gte(Double.POSITIVE_INFINITY), ctx)
        ConversionException ex = expectThrows(
        assertEquals(SqlKind.LESS_THAN, upperBound.getKind());
    public void testGtDecimalAtIntegerMaxMatchesNone() throws ConversionException {
            () -> translator.convert(QueryBuilders.rangeQuery("scaled_price").gte(Double.NaN), ctx)
    public void testExplicitRoundingNotDoubleRounded() throws ConversionException {
        // Value that overflows Long when scaled: 1e18 * 10 > Long.MAX_VALUE
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upperBound.getKind());
     * In legacy OpenSearch, SimpleMappedFieldType.rangeQuery() and DateFieldType.rangeQuery()
    }
        assertLiteralNumber(result, Integer.valueOf(10), null);
        RexCall call = (RexCall) result;
     */
    public void testReportsCorrectQueryType() {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("ip_address").gt("10.0.0.1"), ctx);
    public void testByteMaxValueOnTinyintStillWorks() throws ConversionException {
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
            "Message should mention non-finite or Infinity: " + ex.getMessage(),
        assertLiteralEpoch(result, 1641081599999L);
    public void testNegativeInfinityStringOnUnsignedLongThrows() {
            ConversionException.class,
        // ::1 = 15 zero bytes + 0x01
        assertEquals(SqlTypeName.CHAR, lowerLit.getTypeName());
        );
    }
            QueryBuilders.rangeQuery("event_time").gte("1640995200000").format("epoch_millis").timeZone("America/New_York"),
        RexCall call = (RexCall) result;
        // gte "2026-07-28" -> roundUp=false -> start of day = .000000000
    public void testInfinityDoubleOnDoubleFieldAccepted() throws ConversionException {
    }
     */
    public void testLteNegativeUpperOnUnsignedLong() throws ConversionException {
        RexCall call = (RexCall) result;
        assertLiteralEpoch(result, 1672531199999L);
        assertEquals(3, fieldRef.getIndex());
        // MIN_UNSIGNED_LONG_VALUE (0). With lower defaulting to 0 and no upper, this becomes
        if (node instanceof RexLiteral) {
        );
        // lt 10.5 with factor 10 -> 105, -1 for exclusive = 104, LTE
            () -> translator.convert(QueryBuilders.rangeQuery("timestamp").gte(Double.POSITIVE_INFINITY), ctx)
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
     * Asserts that the literal operand (operand 1) of a comparison RexCall has the given string value.
     */
    public void testGteDecimalOnIntegerFieldNegative() throws ConversionException {
        RexCall call = (RexCall) comparison;
    /** Byte.MAX_VALUE (127) on TINYINT must still produce a valid comparison. */
    /**
        org.apache.calcite.util.TimestampString ts = literal.getValueAs(org.apache.calcite.util.TimestampString.class);
    public void testFormatWithSlashSeparatorsStillRoundsUp() throws ConversionException {
    // impossible ranges. Vanilla's collapse-to-term and match-none special cases are expressed
        RexCall call = (RexCall) result;
            assertEquals("Byte " + i + " should be 0x00", 0, bytes[i]);
        RexCall call = (RexCall) result;
        assertNotNull(literal);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").lte(Double.NEGATIVE_INFINITY), ctx);
    public void testNaNOnScaledFloatRegressionPin() {
    public void testLtDecimalOnIntegerFieldNegative() throws ConversionException {
     * the builder-level rejection that enforces the legacy contract earlier in the stack.
        // gt -5.3 with factor 10 -> Math.round(-53.0) = -53, +1 for exclusive = -52, GTE
        );
import org.apache.calcite.rex.RexNode;
            "Message should mention non-finite or NaN: " + ex.getMessage(),
     */
     * queryName("my_range") throws ConversionException; unsupported parameters are rejected.
        // Bound 9223372036854775808 (Long.MAX_VALUE + 1) → ConversionException.
        ConversionException ex = expectThrows(
     */
        query.boost(2.0f);
        assertTrue(result instanceof RexCall);
        );
    public void testGt() throws ConversionException {
    public void testNoBoundsBecomesExists() throws ConversionException {
        RexLiteral upperLit = unwrapLiteral(upper.getOperands().get(1));
    }
    // ========== SCALED_FLOAT RANGE TESTS ==========
        assertLiteralString(upperBound, "dell");
        RexCall call = (RexCall) comparison;
        assertTrue(
    public void testGteStringDecimalOnScaledFloat() throws ConversionException {
    /** gte -200 on TINYINT (min=-128) -> no constraint (lower below min is unbounded). */
    /**
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
     */
        );
            return lit.getValueAs(Long.class);
        // Verify the date part
        assertNotEquals("Numeric string on numeric field must NOT produce TIMESTAMP type", SqlTypeName.TIMESTAMP, literal.getTypeName());
    /**
        RexCall call = (RexCall) result;
    public void testGteAboveTinyintMaxMatchesNone() throws ConversionException {
    }
        assertNotNull(call.getOperands().get(1));
    /** lt(false) can never be satisfied; vanilla returns MatchNoDocsQuery for this impossible range. */
        RexNode operand1 = call.getOperands().get(1);
     * Invalid timezone string throws IllegalArgumentException at builder construction time
        assertEquals(Integer.valueOf(100), literal.getValueAs(Integer.class));
    /**
        );
        assertEquals(SqlTypeName.CHAR, lowerLit.getTypeName());
    }
            () -> translator.convert(QueryBuilders.rangeQuery("scaled_price").gte(Double.NaN), ctx)
     * gte uses roundUp=false (inclusive lower), producing start-of-day nanos.
        // Legacy scalar mappers also reject DISJOINT, so the contract is preserved.
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
    }
        assertTrue("Lower bound above TINYINT max must produce literal false (match-none)", result instanceof RexLiteral);
        RexCall lower = (RexCall) andCall.getOperands().get(0);
        assertEquals((byte) 0, bytes[14]);
    /**
        RexNode withContains = translator.convert(QueryBuilders.rangeQuery("price").gte(100).relation("CONTAINS"), ctx);
        ConversionException ex = expectThrows(
        }
    public void testGtDecimalOnUnsignedLong() throws ConversionException {
    public void testGteOnScaledFloat() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("is_active").lt(false), ctx);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").gte(5.0).lte(20.0), ctx);
     * and the literal's type which must be TIMESTAMP(9).
    public void testEpochMillisIgnoresTimeZone() throws ConversionException {
        );
        RexCall upper = (RexCall) call.getOperands().get(1);
        // 10.0 has no decimal part, so no adjustment; stays exclusive GREATER_THAN
     * Invalid IP string throws ConversionException.
        assertEquals(2, call.getOperands().size());
        assertTrue("Should produce literal false (match-none) at Integer.MIN_VALUE boundary", result instanceof RexLiteral);
            ex.getMessage().contains("before epoch not representable in nanos")
    // ========== GROUP B - EPOCH_MILLIS (P0) ==========
    public void testWithFormat() throws ConversionException {
    // ========== GROUP R - NON-FINITE BOUNDS ON INTEGER FAMILY ==========
        RexNode result = translator.convert(QueryBuilders.rangeQuery("ip_address").gte("::1"), ctx);
        );
        assertTrue(result instanceof RexCall);
        assertTrue("Should be clamped to 2262-04-11: " + tsStr, tsStr.startsWith("2262-04-11"));
        RexNode result = translator.convert(QueryBuilders.rangeQuery("is_active").gte(false).lte(true), ctx);
    /** Pre-1970 date on millisecond field produces a negative epoch-millis literal (1969-07-20 = -14256000000). */
        // The value must be clamped to MAX_NANOSECOND_INSTANT
        RexCall call = (RexCall) comparison;
        RexCall call = (RexCall) result;
     * Only non-zero fractional parts trigger decimal-adjust, matching NumberFieldMapper.hasDecimalPart.
        );
        assertEquals(2, call.getOperands().size());
    }
        // gt with roundUp=true: "2022-01-01||/M" rounds to end of month = 2022-01-31T23:59:59.999Z
    public void testDoubleValueOnNumericField() throws ConversionException {
        assertNotNull(call.getOperands().get(1));
    /** gte 200 on TINYINT (max=127) -> match-none (FALSE literal). */
    }
    public void testLtNegativeUpperOnUnsignedLong() throws ConversionException {
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").lte(-5), ctx);
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;
        assertLiteralNumber(result, Integer.valueOf(10), null);
        assertTrue(result instanceof RexCall);
            () -> translator.convert(QueryBuilders.rangeQuery("price").gte(Double.NaN), ctx)
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        assertNotNull("TimestampString value must not be null", ts);
    public void testNonNumericBoundScaledFloatThrowsConversionException() {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("brand").gte("apple").lte("dell"), ctx);
        String tsStr = ts.toString();
        assertEquals(Long.valueOf(100L), extractLiteralLong(call.getOperands().get(1)));
    /**
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        assertEquals(SqlKind.GREATER_THAN, call.getKind());
        assertEquals(11, ((RexInputRef) call.getOperands().get(0)).getIndex());
        assertEquals(2, call.getOperands().size());
        assertEquals(3, ((RexInputRef) upperBound.getOperands().get(0)).getIndex());
     * Hostname input (e.g. "localhost") must be rejected with ConversionException.
            withWithin.toString()
    public void testRegressionPlainDateFieldStillUsesMillis() throws ConversionException {
     * lte -10.5 on INTEGER field produces lte -11. Per NumberFieldMapper INTEGER.rangeQuery: negative decimal upper bound decrements.
    }
        );
        assertTrue("Non-finite on DOUBLE should produce a RexCall, not throw", result instanceof RexCall);
        assertTrue(result instanceof RexCall);
        assertEquals(2, call.getOperands().size());
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Non-finite")
    private RexLiteral unwrapLiteral(RexNode node) {
    }
        assertTrue(result instanceof RexCall);
    /**
        RexCall call = (RexCall) result;
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
        assertEquals(SqlKind.AND, call.getKind());
        // 2022-01-01T00:00:00 in America/New_York = 2022-01-01T05:00:00Z = 1641013200000L
    }
        );
    }
    /**
        assertTrue(result instanceof RexCall);
     * Uses a value within double's exact-integer range where the fractional part is preserved.
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("NaN")
        // gte 10.55 with factor 10 -> Math.round(105.5) = 106, inclusive, GTE
        // MAX_NANOSECOND_INSTANT = 2262-04-11T23:47:16.854775807Z
        assertEquals(1, fieldRef.getIndex());
            () -> translator.convert(QueryBuilders.rangeQuery("scaled_price").gt(1e18), ctx)
    public void testDateMathSubtraction() throws ConversionException {
        assertTrue(
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upper.getKind());
            ex.getMessage().contains("NaN") && ex.getMessage().contains("coerce")
        byte[] bytes = bs.getBytes();
        // Verify IPv4-mapped structure: 10 zeros + 0xff 0xff + 192.168.0.1
        expectThrows(ConversionException.class, () -> translator.convert(query, ctx));
        assertTrue(result instanceof RexCall);
    public void testGtOnUnsignedLongExclusiveWholeNumber() throws ConversionException {
        // Type should be TIMESTAMP(3)
        // End of 2022-01-01 = 2022-01-01T23:59:59.999Z = 1641081599999L
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").lte("now/d"), ctx);
     */
        assertTrue(result instanceof RexCall);
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upper.getKind());
     * truncate to Integer.MIN_VALUE, decrement would overflow, matching NumberFieldMapper MatchNoDocsQuery.
        assertEquals(Long.valueOf(99L), extractLiteralLong(call.getOperands().get(1)));
    public void testExclusiveLexicographicRangeOnKeywordField() throws ConversionException {
    /** "-Infinity" as String on unsigned_long must throw ConversionException. */
    public void testGteOnUnsignedLongInRange() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_nanos").gte("2300-01-01"), ctx);
     */
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));
        RexCall call = (RexCall) result;
        assertEquals("Plain date field should use millis precision", 1785369600123L, millis.longValue());
        // Decimal-adjust: truncate -> -4503599627370495, negative upper -> decrement -> <= -4503599627370496
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));
     */
    }
        assertTrue("gte should be start of 2026-07-28: " + gteStr, gteStr.startsWith("2026-07-28 00:00:00"));
        assertTrue(result instanceof RexCall);
            ConversionException.class,
    public void testDisjointRelationRejected() {
        );
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    /** Integer.MIN_VALUE on INTEGER must still produce a valid comparison. */
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    }
     */
        assertEquals(Long.valueOf(105L), extractLiteralLong(call.getOperands().get(1)));
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.rangeQuery("ip_address").gte("not_an_ip"), ctx));
    }
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);
            "Message should mention non-finite or Infinity: " + ex.getMessage(),
        RexCall call = (RexCall) result;
    }
    /** NaN as String "NaN" on INTEGER must throw ConversionException. */
    /**
    public void testEpochMillisFormatGte() throws ConversionException {
        assertTrue(result instanceof RexCall);
    /**
        assertLiteralEpoch(result, 1640995200000L);
        ConversionException ex = expectThrows(
     * Legacy IpFieldMapper.rangeQuery uses InetAddress-order (16-byte IPv6-mapped encoding).
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    /** Infinity as raw Double on BIGINT must throw ConversionException. */
            "CONTAINS relation must produce identical expression to no-relation (legacy scalar behavior)",
     * numeric value and that its type matches the expected SqlTypeName.
    public void testNaNDoubleOnDoubleFieldAccepted() throws ConversionException {
        assertTrue(result instanceof RexCall);
        assertEquals("String literal mismatch", expectedValue, actualValue);
    }
    public void testWithFormatAndTimeZone() throws ConversionException {
        assertEquals(2, lowerRef.getIndex());
    /**
        );
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        // Values above Long.MAX_VALUE are not representable due to schema_coerce.rs UInt64→Int64 narrowing.
    /** "Infinity" as String on INTEGER must throw ConversionException. */
        RexCall lowerBound = (RexCall) call.getOperands().get(0);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gt(-10.5), ctx);
    public void testLteDecimalOnIntegerFieldNegative() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").lt("now/d"), ctx);
     */
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_nanos").lte("2026-07-28"), ctx);
    public void testLtDecimalOnIntegerFieldPositive() throws ConversionException {
        assertLiteralNumber(result, Integer.valueOf(11), null);
     * to the max nanosecond epoch value, not overflowing.
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(100), ctx);
    public void testGteNegativeLowerOnUnsignedLong() throws ConversionException {
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    public void testDateMathNow() throws ConversionException {
        );
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("NaN")
        // Per NumberFieldMapper.objectToUnsignedLong(lenientBound=true): negative upper clamps to 0,
        assertTrue(
    }
        assertEquals(SqlKind.GREATER_THAN, call.getKind());
        RexCall upper = (RexCall) call.getOperands().get(1);
            () -> translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte(Double.POSITIVE_INFINITY), ctx)
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gte("1969-07-20T00:00:00Z"), ctx);
public class RangeQueryTranslatorTests extends OpenSearchTestCase {
     * DNS resolution must never be attempted on user-supplied range bounds.
            () -> translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte(Double.NaN), ctx)
    }
        // Must produce a comparison, not throw
        RexCall call = (RexCall) result;
    /**
        assertTrue(result instanceof RexCall);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("NaN")
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upper.getKind());
        RexCall call = (RexCall) result;
        RexCall upper = (RexCall) andCall.getOperands().get(1);
    // ========== GROUP J - STRING-ORIGIN DECIMALS ON INTEGER FIELDS ==========
        // wrapped in IllegalArgumentException by the builder
    public void testIpRangeHostnameArbitraryThrows() {
        RexCall call = (RexCall) result;
        RexCall lower = (RexCall) call.getOperands().get(0);
        assertNotNull("IP literal should be ByteString", bs);
    public void testBooleanRangeGteTrueAndLteTrue() throws ConversionException {
    /** "Infinity" as String on BIGINT must throw ConversionException. */
        // Assert literal type (Calcite produces CHAR for string literals)
    }
    }
    /**
        assertTrue(
        RexNode result = translator.convert(
        RexCall upperBound = (RexCall) call.getOperands().get(1);
        assertEquals(2, call.getOperands().size());
    public void testLtDecimalAtIntegerMinMatchesNone() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte(100), ctx);
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
     * Verifies DISJOINT relation is rejected. In legacy OpenSearch, SimpleMappedFieldType.rangeQuery()
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").gt(10.5), ctx);
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));
    }
        RexCall call = (RexCall) result;
    public void testGtDecimalStringOnIntegerField() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gte("1640995200000").format("epoch_millis"), ctx);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
            RexCall call = (RexCall) node;
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").lt("2022-01-01"), ctx);
        RexLiteral gteLiteral = unwrapLiteral(gteCall.getOperands().get(1));
        // gte -5 on unsigned_long: negative lower bound → clamp to 0, effectively unbounded-low.
     * Range query on ip-typed field produces VARBINARY byte-range comparison.
    /** "NaN" as String on unsigned_long must throw ConversionException. */
        assertTrue("TimestampString must contain 9-digit fraction .123456789, got: " + tsStr, tsStr.contains(".123456789"));
    }
    }
    public void testIpRangeExclusiveLowerBound() throws ConversionException {
        RexCall call = (RexCall) result;
    /** "NaN" as String on BIGINT must throw ConversionException. */
     * granularity (23:59:59.999999999).
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        RexCall call = (RexCall) result;
     * silently drop the relation parameter for scalar fields — the built query is identical
    }
    }
    public void testNaNDoubleOnRealThrows() {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").lte(10.5), ctx);
        assertEquals(2, call.getOperands().size());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("now-1d/d"), ctx);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gt(100), ctx);
    }
    }
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
        // For TIMESTAMP(3) literals, Calcite stores the value as millis from epoch
        RexLiteral upperLit = unwrapLiteral(upperBound.getOperands().get(1));
    // ========== GROUP R3 - NON-FINITE ON REAL (FLOAT) ==========
        assertTrue("Upper bound above TINYINT max should produce IS_NOT_NULL (no constraint)", result instanceof RexCall);
import org.opensearch.dsl.converter.ConversionContext;
        // gte "100" (string) on unsigned_long: whole number within Long range -> GTE 100
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").lte("now+1M"), ctx);
        assertEquals(2, call.getOperands().size());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_nanos").gte("2300-01-01"), ctx);
        assertTrue("Should produce literal false (match-none) at Integer.MAX_VALUE boundary", result instanceof RexLiteral);
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
        }
        RexCall call = (RexCall) result;
 */
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Infinity") || ex.getMessage().contains("above")
            ctx
        RexCall call = (RexCall) result;
        assertEquals(5, ((RexInputRef) lower.getOperands().get(0)).getIndex());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("now"), ctx);
    public void testThrowsForQueryName() {
        assertTrue(result instanceof RexCall);
        RexLiteral literal = unwrapLiteral(operand1);
        assertTrue(result instanceof RexCall);
        RexLiteral literal = unwrapLiteral(operand1);
     * DateFieldMapper.dateRangeQuery, DateMathParser rounds to end-of-month.
        // No bounds → IS_NOT_NULL (exists semantics), same as other types.
        RexLiteral gtLiteral = unwrapLiteral(gtCall.getOperands().get(1));
        assertEquals(SqlTypeName.TIMESTAMP, literal.getType().getSqlTypeName());
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        assertLiteralNumber(result, Integer.valueOf(-10), null);
        assertTrue(ex.getMessage().contains("not-a-number"));
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        // End of 2026-07-28 in nanos: 2026-07-28 23:59:59.999999999
    public void testNaNStringOnIntegerThrows() {
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
    public void testRangeOnDateNanosFieldSucceeds() throws ConversionException {
    public void testGteNumericLiteralValue() throws ConversionException {
    }
        RexLiteral literal = unwrapLiteral(operand1);
            "Message should mention non-finite or NaN: " + ex.getMessage(),
    /**
    /** lte("now/d") with explicit rounding operator produces expected shape (nondeterministic value). */
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(10.5), ctx);
        RexCall upperBound = (RexCall) call.getOperands().get(1);
        assertTrue(
        // gte "1.5" (string) with factor 10 -> Math.round(1.5 * 10) = 15, inclusive, GTE
    /** timeZone("America/New_York") shifts the parsed epoch by UTC-5 offset. */
            ConversionException.class,
            "Message should mention out of range or overflow: " + ex.getMessage(),
        // lt 100 (whole, exclusive) → -1 = 99, LTE
        }
    /** NaN as raw Double on BIGINT must throw ConversionException. */
        // gt 10.5 on unsigned_long: positive decimal lower → truncate(10) + 1 = 11, GTE
        );
        assertEquals(SqlKind.LESS_THAN, call.getKind());
        assertLiteralEpoch(result, 1641081599999L);
    /** BUG 2 proof: gte 2147483648L on INTEGER silently narrows to -2147483648 instead of throwing. */
            if (call.getKind() == SqlKind.CAST) {
        for (int i = 0; i < 15; i++) {
     * gt 10.5 on INTEGER field produces gte 11. Per NumberFieldMapper INTEGER.rangeQuery: positive decimal lower bound increments.
import org.opensearch.index.query.QueryBuilders;
     * Validation is via the literal's TimestampString which preserves all 9 fractional digits,
    public void testRoundingBothBounds() throws ConversionException {
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));
     * Calcite's canonical DECIMAL type is acceptable.
    }
            ConversionException.class,
        RexNode operand1 = call.getOperands().get(1);
    // ========== GROUP G - DATE ROUNDING KEYED ON INCLUSIVITY ==========
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
    /** Negative Infinity on DOUBLE field must NOT throw. */
     */
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;
    }
    /**
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("NaN")
        );
     * Uses a value within double's exact-integer range (below 2^52) where the fractional part is preserved.
    public void testRoundingWithLt() throws ConversionException {
import org.apache.calcite.sql.type.SqlTypeName;
        assertNotNull("Literal value is null", actualValue);
        RexLiteral upperLit = unwrapLiteral(upperBound.getOperands().get(1));
        ConversionException ex = expectThrows(
        assertNotNull(gteTs);
        ConversionException ex = expectThrows(
    /**
    public void testGteDecimalOnIntegerFieldPositive() throws ConversionException {
    /** Bound past Long range on BIGINT (as String) must throw ConversionException. */
     * Arbitrary hostname input must be rejected with ConversionException,
            assertEquals("Type mismatch", expectedType, literal.getTypeName());
    }
        assertEquals(SqlKind.AND, call.getKind());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("is_active").gte(true).lte(true), ctx);
        RexCall call = (RexCall) result;
        query.queryName("my_range");
    }
        assertEquals(Long.valueOf(105L), extractLiteralLong(call.getOperands().get(1)));
        RexNode result = translator.convert(
        fail("Expected RexLiteral or CAST(RexLiteral), got: " + node.getClass().getSimpleName() + " = " + node);
        ConversionException ex = expectThrows(
     * gte("::1") on ip field produces VARBINARY literal with native IPv6 encoding:
    /**
    public void testDateOnlyUpperBoundRoundsUp() throws ConversionException {
        assertEquals(2, call.getOperands().size());
        RexInputRef lowerRef = (RexInputRef) lowerBound.getOperands().get(0);
        RexNode operand1 = call.getOperands().get(1);
    }
    }
            ConversionException.class,
        ConversionException ex = expectThrows(
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    }
    // BytesRef "T"/"F", collapses lower==upper to termQuery, and returns MatchNoDocsQuery for
        assertEquals(SqlKind.LESS_THAN, call.getKind());
    public void testBooleanRangeGtTrue() throws ConversionException {
        // event_nanos is field index 12
            () -> translator.convert(QueryBuilders.rangeQuery("float_val").gte("Infinity"), ctx)
        RexNode result = translator.convert(QueryBuilders.rangeQuery("is_active").gt(true), ctx);
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("NaN")
    /** Custom format dd/MM/yyyy parses "01/01/2022" to epoch 1640995200000 (2022-01-01T00:00:00Z). */
    }
        assertEquals(Boolean.FALSE, lit.getValueAs(Boolean.class));
    public void testLteBelowSmallintMinMatchesNone() throws ConversionException {
        RexLiteral literal = unwrapLiteral(operand1);
            ConversionException.class,
    public void testLteBelowIntegerMinThrows() {
    }
        RexCall call = (RexCall) result;
        );
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gt(2147483647.5), ctx);
    }
        assertLiteralString(lowerBound, "apple");
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
     * gt 10.0 (whole double) on integer field uses exclusive > 10 without adjustment.
    /**
    // ========== GROUP N - DATE_NANOS (TIMESTAMP(9)) RANGE SUPPORT ==========
    public void testShortMinValueOnSmallintStillWorks() throws ConversionException {
        );
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gt(100), ctx);
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);
        assertLiteralNumber(result, Long.valueOf(4503599627370496L), null);
        // Value must be exactly 100; Calcite makeLiteral with INTEGER field type stores as DECIMAL
        assertNotNull(ts);
        assertTrue(result instanceof RexCall);
        assertEquals(5, ((RexInputRef) call.getOperands().get(0)).getIndex());
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.rangeQuery("ip_address").gte("evil.example"), ctx));
    // ========== FIX 1: NaN/Infinity rejection on scaled_float range ==========
        RexCall call = (RexCall) result;
            withoutRelation.toString(),
        assertTrue(ex.getMessage().contains("NaN") || ex.getMessage().contains("non-finite"));
        assertNotNull(millis);
        return null; // unreachable
    }
        assertTrue(result instanceof RexCall);
     * Long value on numeric field produces numeric literal, not TIMESTAMP(3).
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gt(10.5), ctx);
     */
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").gt(-5.3), ctx);
     * lte 10.5 on INTEGER field produces lte 10. Per NumberFieldMapper INTEGER.rangeQuery: positive decimal upper bound, no decrement.
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upper.getKind());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("01/01/2022").format("dd/MM/yyyy").timeZone("UTC"), ctx);
        // Use epoch_millis format which is timezone-independent (epoch is absolute)
            () -> translator.convert(QueryBuilders.rangeQuery("timestamp").gte("9223372036854775808"), ctx)
        );
     */
        // lte -5 on unsigned_long: negative upper → match-none.
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(100).relation("INTERSECTS"), ctx);
        assertNotNull("Could not unwrap literal from: " + operand1, literal);
        RexCall lower = (RexCall) call.getOperands().get(0);
        RexCall call = (RexCall) result;
     * 15 zero bytes + 0x01.
    /** Infinity string bound on scaled_float must throw ConversionException. */
    public void testFixedDateMathRounding() throws ConversionException {
     * lt -10.5 on INTEGER field produces lte -11. Per NumberFieldMapper INTEGER.rangeQuery: negative decimal upper bound decrements.
        RexCall upperBound = (RexCall) call.getOperands().get(1);
        assertEquals(Boolean.FALSE, literal.getValueAs(Boolean.class));
        String actualValue = literal.getValueAs(String.class);
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte(99.5), ctx);
        assertTrue(ex.getMessage().contains("overflows"));
        RexNode result = translator.convert(QueryBuilders.rangeQuery("tiny_val").gte(127), ctx);
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter"), ctx);
    // ========== GROUP R2 - NON-FINITE ON UNSIGNED_LONG ==========
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
        RexCall call = (RexCall) result;
 * compatible open source license.
    }
    // ========== GROUP S - UNCHECKED NARROWING OVERFLOW ==========
    /** format("epoch_millis") with string "1640995200000" produces literal == 1640995200000L. */
        assertEquals("Numeric value mismatch", expectedValue, actualValue);
     * Exclusive string bounds on keyword field produce GREATER_THAN / LESS_THAN operators.
     * Expected: 2022-01-01T23:59:59.999Z = 1641081599999L, operator GREATER_THAN.
     * gte 10.5 on INTEGER field produces gte 11. Per NumberFieldMapper INTEGER.rangeQuery: positive decimal lower bound increments.
    }
        RexCall call = (RexCall) result;
        assertEquals(Long.valueOf(11L), extractLiteralLong(call.getOperands().get(1)));
        assertEquals(5, ((RexInputRef) call.getOperands().get(0)).getIndex());
    /** epoch_millis with non-numeric string "abc" throws ConversionException. */
        assertTrue("No-bounds should produce IS NOT NULL call", result instanceof RexCall);
    public void testThrowsForBoost() {
        assertTrue(result instanceof RexCall);
        RexCall call = (RexCall) result;
        assertTrue(ex.getMessage().contains("coerce") || ex.getMessage().contains("Non-numeric"));
    }
            ConversionException.class,
    }
     * Calcite stores TIMESTAMP(3) literals as millis-since-epoch internally.
import org.apache.calcite.sql.SqlKind;
        RexNode result = translator.convert(QueryBuilders.rangeQuery("small_val").lte(-40000), ctx);
        String gteStr = gteTs.toString();
            () -> translator.convert(QueryBuilders.rangeQuery("float_val").gte(Double.NaN), ctx)
    /** NaN on DOUBLE field must NOT throw -- legacy accepts non-finite doubles. */
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;
    }
        RexCall call = (RexCall) result;
        );
     * Ensures the precision-9 path does not break existing millisecond date handling.
    }
    // ========== GROUP U - REGRESSION: IN-RANGE BOUNDARY VALUES STILL WORK ==========
        org.apache.calcite.util.TimestampString ts = literal.getValueAs(org.apache.calcite.util.TimestampString.class);
        // Must contain .123456789 (all 9 digits preserved)
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(100L), ctx);
        assertTrue("lte should round up to end of day at nano granularity (.999999999): " + tsStr, tsStr.contains("23:59:59.999999999"));
        assertEquals(SqlKind.LESS_THAN, call.getKind());
            "Message should mention non-finite or NaN: " + ex.getMessage(),
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gt("10.5"), ctx);
            () -> translator.convert(QueryBuilders.rangeQuery("scaled_price").gt("not-a-number"), ctx)
        String tsStr = ts.toString();
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("01/01/2022||+1M").format("dd/MM/yyyy"), ctx);
        // gte 100 (whole, inclusive) → GTE 100
        RexCall call = (RexCall) result;
    }
            "Message should mention non-finite or Infinity: " + ex.getMessage(),
    /**
    /**
    public void testWithinRelationIgnoredOnScalarField() throws ConversionException {
            "Message should mention non-finite or NaN: " + ex.getMessage(),
        // gt "2026-07-28" -> roundUp=true -> end of day = .999999999
    // ========== GROUP L - FIELD TYPE GUARDS AND IP RANGE SUPPORT ==========
        ConversionException ex = expectThrows(
     */
    /** lte("2022-01-01") on date field rounds up to end-of-day (23:59:59.999Z). */
        // isRelationAllowed() only permits INTERSECTS, CONTAINS, and WITHIN.
        assertEquals(SqlKind.GREATER_THAN, call.getKind());
     * Bound "2026-07-28T00:00:00.123456789" on event_nanos (precision 9) must produce a literal
        org.apache.calcite.avatica.util.ByteString bs = literal.getValueAs(org.apache.calcite.avatica.util.ByteString.class);
        assertTrue(ex.getMessage().contains("NaN") || ex.getMessage().contains("non-finite"));
        assertEquals(2, call.getOperands().size());
        assertNotNull("IP literal should be ByteString", bs);
        assertEquals(Long.valueOf(200L), extractLiteralLong(upper.getOperands().get(1)));
     * Range query on nanosecond-precision date field (TIMESTAMP(9)) produces a valid comparison.
            withContains.toString()
    }
        assertNotNull(literal);
        assertEquals(2, call.getOperands().size());
        // Per NumberFieldMapper.objectToUnsignedLong(lenientBound=true): values below 0 return
        RexNode result = translator.convert(
    // ========== GROUP H - DECIMAL BOUNDS ON INTEGER FIELDS ==========
        RexCall call = (RexCall) result;
    public void testExistsOnUnsignedLong() throws ConversionException {
     */
    /** gte 40000 on SMALLINT with lte -40000 -> match-none for both => AND of false? Actually each bound returns separately. */
    public void testEpochMillisLongBoundOnDateField() throws ConversionException {
     */
        assertEquals(2, lowerBound.getOperands().size());
     * Expected: 2022-01-01T00:00:00.000Z = 1640995200000L, operator LESS_THAN.
        assertTrue(result instanceof RexCall);
    // ========== GROUP R5 - SCALED_FLOAT NAN/INFINITY REGRESSION PIN ==========
        RexLiteral literal = unwrapLiteral(operand1);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("tiny_val").gte(200), ctx);
    }
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lower.getKind());
        assertTrue(result instanceof RexCall);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    /**
        assertEquals(SqlKind.AND, call.getKind());
        assertEquals("Value should be 100", Integer.valueOf(100), literal.getValueAs(Integer.class));
        RexCall lowerBound = (RexCall) call.getOperands().get(0);
        assertEquals(Long.valueOf(100L), extractLiteralLong(call.getOperands().get(1)));
        assertLiteralNumber(result, Integer.valueOf(-10), null);
        assertEquals(SqlKind.AND, andCall.getKind());
        RexNode withoutRelation = translator.convert(QueryBuilders.rangeQuery("price").gte(100), ctx);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(Integer.MAX_VALUE), ctx);
        assertTrue(
            ConversionException.class,
    public void testGte() throws ConversionException {
    /**
        RexCall call = (RexCall) result;
        byte[] bytes = bs.getBytes();
    }
    }
        // Assert column reference (brand is index 2 in TestUtils schema)
        // The TimestampString must preserve all 9 fractional digits
    // ========== HELPER METHODS FOR LITERAL VALUE EXTRACTION ==========
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lte(-10.5), ctx);

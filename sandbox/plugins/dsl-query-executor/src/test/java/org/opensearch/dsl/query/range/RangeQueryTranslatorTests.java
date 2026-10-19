        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte(-5), ctx);
    public void testShortMinValueOnSmallintStillWorks() throws ConversionException {
     * truncate to Integer.MAX_VALUE, increment would overflow, matching NumberFieldMapper MatchNoDocsQuery.
    // ========== GROUP B - EPOCH_MILLIS (P0) ==========  
     * Legacy BinaryFieldMapper has no rangeQuery implementation.  
        RexCall call = (RexCall) result;
    /**  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("tiny_val").gte(-200), ctx);  
        RexCall call = (RexCall) result;
        assertEquals(2, upperBound.getOperands().size());
        assertTrue(  
        RexCall call = (RexCall) result;
        assertEquals(Boolean.TRUE, upperLit.getValueAs(Boolean.class));
    public void testNonNumericBoundScaledFloatThrowsConversionException() {
     * regardless of INTERSECTS, CONTAINS, or WITHIN.  
        assertEquals(2, upperRef.getIndex());
     * Verifies DISJOINT relation is rejected. In legacy OpenSearch, SimpleMappedFieldType.rangeQuery()
        RexCall call = (RexCall) result;  
        RangeQueryBuilder query = QueryBuilders.rangeQuery("price").gte(100);
        assertLiteralEpoch(result, 1640995200000L);
        // -4503599627370495.5 has exact double representation, negative -> decrement
    public void testLteOnScaledFloat() throws ConversionException {
        assertTrue("Should produce literal false (match-none) at Integer.MAX_VALUE boundary", result instanceof RexLiteral);  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("ip_address").gte("10.0.0.0").lte("10.0.0.255"), ctx);
    public void testGtDecimalStringOnIntegerField() throws ConversionException {
        assertNotNull(call.getOperands().get(1));
        assertEquals(2, call.getOperands().size());
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
        Long actualValue = literal.getValueAs(Long.class);  
    public void testGteAboveIntegerMaxThrows() {
    // impossible ranges. Vanilla's collapse-to-term and match-none special cases are expressed
        assertTrue(result instanceof RexCall);
    }  
            () -> translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte(Double.NaN), ctx)  
        assertTrue(result instanceof RexCall);  
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);  
        // Value as Long should be epoch millis
     * granularity (23:59:59.999999999).  
    public void testNoBoundsBecomesExists() throws ConversionException {  
     */
    private final ConversionContext ctx = TestUtils.createContext();
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        assertEquals("Value should be 100", Integer.valueOf(100), literal.getValueAs(Integer.class));
        RexCall call = (RexCall) comparison;  
     * lt "2022-01-01" on date field rounds DOWN (start-of-day) because exclusive upper bound  
        RexCall call = (RexCall) result;  
        // Type should be TIMESTAMP(3)
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Infinity")
        );  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gt(100), ctx);
        RexLiteral lowerLit = unwrapLiteral(lower.getOperands().get(1));  
        String tsStr = ts.toString();  
    // ========== GROUP M - IP RANGE VALUE CORRECTNESS ==========
        assertTrue("Expected RexCall comparison, got: " + comparison.getClass(), comparison instanceof RexCall);  
            "Message should mention non-finite or Infinity or above: " + ex.getMessage(),  
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;
    }
        if (node instanceof RexCall cast && cast.getKind() == SqlKind.CAST) {
        ConversionException ex = expectThrows(
    }
        RexCall call = (RexCall) result;
        // gte -5 on unsigned_long: negative lower bound → clamp to 0, effectively unbounded-low.  
            assertEquals("Byte " + i + " should be 0x00", 0, bytes[i]);
        assertEquals(SqlTypeName.TIMESTAMP, literal.getType().getSqlTypeName());
            ex.getMessage().contains("-Infinity") && ex.getMessage().contains("coerce")
        }  
    }
    /**  
            () -> translator.convert(QueryBuilders.rangeQuery("event_time").gte("abc").format("epoch_millis"), ctx)  
        RexNode operand1 = call.getOperands().get(1);
        assertEquals((byte) 192, bytes[12]);  
    }
    }
    /**
        RexLiteral upperLit = unwrapLiteral(upperBound.getOperands().get(1));
    }
     * Calcite canonically types exact-numeric literals as DECIMAL.  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(10.5), ctx);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
        );
    }  
    }
            () -> translator.convert(QueryBuilders.rangeQuery("scaled_price").gte("Infinity"), ctx)
        assertEquals(1, call.getOperands().size());  
        assertTrue(result instanceof RexCall);
                || ex.getMessage().contains("NumberFormat")  
    public void testNegativeInfinityStringOnUnsignedLongThrows() {  
     * Range query on nanosecond-precision date field (TIMESTAMP(9)) produces a valid comparison.
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));
    public void testContainsRelationIgnoredOnScalarField() throws ConversionException {
        ConversionException ex = expectThrows(
        assertEquals(SqlKind.AND, call.getKind());  
    }
    public void testGteAboveSmallintMaxMatchesNone() throws ConversionException {  
        assertEquals(SqlKind.GREATER_THAN, call.getKind());
        assertEquals(2, call.getOperands().size());
        assertEquals(SqlKind.AND, andCall.getKind());
    public void testLongValueOnNumericFieldKeepsFieldType() throws ConversionException {
        RexCall call = (RexCall) result;  
     * lt 10.5 on INTEGER field produces lte 10. Per NumberFieldMapper INTEGER.rangeQuery: positive decimal upper bound, no decrement.
    public void testLtOnScaledFloat() throws ConversionException {
     * Asserts that the literal operand (operand 1) of a comparison RexCall has the given  
        );
        RexInputRef upperRef = (RexInputRef) upperBound.getOperands().get(0);  
        assertLiteralNumber(result, Integer.valueOf(Integer.MIN_VALUE), null);
        RexCall call = (RexCall) result;  
     */  
        );
    // ========== GROUP I - OVERFLOW GUARDS ==========  
        assertEquals(2, lowerRef.getIndex());
            assertEquals("Byte " + i + " should be 0x00", 0, bytes[i]);
        RexCall call = (RexCall) result;
     */  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("small_val").gte(40000), ctx);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lt(10.5), ctx);
    /**  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").lt(-1), ctx);
        );  
        assertTrue("Expected literal false (match-none)", result instanceof RexLiteral);  
        assertEquals(Boolean.FALSE, lit.getValueAs(Boolean.class));
    }
        // gt 10.5 on unsigned_long: positive decimal lower → truncate(10) + 1 = 11, GTE
        assertEquals(2, lowerBound.getOperands().size());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("is_active").gte(false).lte(true), ctx);
        assertNotNull(gtTs);
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upper.getKind());
    // ========== GROUP Q - BOOLEAN RANGE PARITY ==========
        // gte 5.0 AND lte 20.0 with factor 10 -> 50 (inclusive) AND 200 (inclusive)
        RexCall call = (RexCall) result;
    // ========== GROUP N - DATE_NANOS (TIMESTAMP(9)) RANGE SUPPORT ==========
    }
        assertTrue(result instanceof RexCall);  
    }
            "Message should mention non-finite or NaN: " + ex.getMessage(),  
    /** Unwraps a nullable CAST around a RexLiteral produced by makeLiteral on a nullable type. */
        RexInputRef upperRef = (RexInputRef) upperBound.getOperands().get(0);  
    }  
            withWithin.toString()
    }
        RexCall call = (RexCall) result;
        assertNotNull("Literal numeric value is null", actualValue);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte("100"), ctx);
            }
     * Hostname input (e.g. "localhost") must be rejected with ConversionException.  
public class RangeQueryTranslatorTests extends OpenSearchTestCase {
        assertEquals(1, fieldRef.getIndex());
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;  
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(QueryBuilders.rangeQuery("small_val").lte(-32768), ctx);
        assertEquals(3, ((RexInputRef) upperBound.getOperands().get(0)).getIndex());
        RexNode operand1 = call.getOperands().get(1);
     * Double value on DOUBLE field produces DOUBLE-typed literal with exact value.  
        assertEquals(Long.valueOf(101L), extractLiteralLong(call.getOperands().get(1)));
     */
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        // Must NOT be mistyped as TIMESTAMP — DECIMAL/INTEGER/BIGINT are all acceptable  
        assertEquals(2, lowerBound.getOperands().size());
        String tsStr = ts.toString();  
     */  
        assertNotNull(literal);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gte("1969-07-20T00:00:00Z"), ctx);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_nanos").lte("2026-07-28"), ctx);  
        // gte "2026-07-28" -> roundUp=false -> start of day = .000000000  
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(100).relation("INTERSECTS"), ctx);
        org.apache.calcite.util.TimestampString ts = literal.getValueAs(org.apache.calcite.util.TimestampString.class);
    }
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.rangeQuery("ip_address").gte("localhost"), ctx));
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lowerBound.getKind());  
            ctx  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("small_val").lte(-40000), ctx);
    public void testInfinityDoubleOnDoubleFieldAccepted() throws ConversionException {
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_nanos").gte("2300-01-01"), ctx);  
     * Only non-zero fractional parts trigger decimal-adjust, matching NumberFieldMapper.hasDecimalPart.
            "Message should mention out of range or overflow or numeric: " + ex.getMessage(),
            QueryBuilders.rangeQuery("rating").gte("01/01/2022").lte("31/12/2022").format("dd/MM/yyyy"),
        // isRelationAllowed() only permits INTERSECTS, CONTAINS, and WITHIN.  
        RexCall call = (RexCall) result;  
        expectThrows(ConversionException.class, () -> translator.convert(query, ctx));  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("ip_address").gte("192.168.0.1"), ctx);  
        expectThrows(IllegalArgumentException.class, () -> QueryBuilders.rangeQuery("price").gte(100).relation("DISJOINT"));
        // 2300-01-01 is far beyond MAX_NANOSECOND_INSTANT (2262-04-11T23:47:16.854775807Z)
    }  
        assertTrue("Non-finite on DOUBLE should produce a RexCall, not throw", result instanceof RexCall);
        RexCall call = (RexCall) result;
        RexCall lowerBound = (RexCall) call.getOperands().get(0);  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lowerBound.getKind());
        assertEquals(Long.valueOf(99L), extractLiteralLong(call.getOperands().get(1)));  
    public void testLteAboveSmallintMaxNoConstraint() throws ConversionException {
        if (node instanceof RexLiteral) {
        throw new AssertionError("Expected RexLiteral or CAST(RexLiteral), got: " + node.getClass().getSimpleName());
        );
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upper.getKind());
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
        assertTrue(result instanceof RexCall);
    }  
    public void testNaNStringOnScaledFloatThrows() {
        );
    public void testFormatParsesToExactEpoch() throws ConversionException {
    // ========== GROUP U - REGRESSION: IN-RANGE BOUNDARY VALUES STILL WORK ==========
        // (inclusive) bound becomes 2" — positive decimal lower increments after truncation.  
    }  
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
            ConversionException.class,  
        assertLiteralEpoch(result, 1643673599999L);
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
        assertEquals(SqlTypeName.CHAR, lowerLit.getTypeName());
        RexLiteral literal = unwrapLiteral(operand1);
        );
    }
        );
        RexLiteral lit = unwrapLiteral(call.getOperands().get(1));  
    public void testHalfBoundaryGteScaledFloatRoundsUp() throws ConversionException {  
        assertTrue(result instanceof RexCall);
    /**  
        if (node instanceof RexCall) {
            ConversionException.class,
     * gt "10.5" as String on INTEGER field behaves identically to gt 10.5 raw double: produces gte 11.
        // wrapped in IllegalArgumentException by the builder  
    public void testBooleanRangeGteTrueAndLteTrue() throws ConversionException {  
        assertTrue("Upper bound above TINYINT max should produce IS_NOT_NULL (no constraint)", result instanceof RexCall);  
    public void testLteBelowIntegerMinThrows() {
     * Unmapped field returns literal false (match-none), matching legacy DISJOINT for null fieldType.  
        assertEquals(SqlKind.GREATER_THAN, call.getKind());
    // ========== GROUP J - STRING-ORIGIN DECIMALS ON INTEGER FIELDS ==========
            () -> translator.convert(QueryBuilders.rangeQuery("timestamp").gte("9223372036854775808"), ctx)
    }
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
    }  
    public void testInfinityStringOnScaledFloatRangeThrows() {
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").lte("31/12/2022").format("dd/MM/yyyy"), ctx);  
        // Mirrors NumberFieldMapper.unsignedLongRangeQuery: "if lowerTerm=1.5 then the
    /**  
     * gt decimal on BIGINT field performs correct decimal-adjust with increment.  
    /** lte("2022-01-01") on date field rounds up to end-of-day (23:59:59.999Z). */
        assertEquals(5, ((RexInputRef) call.getOperands().get(0)).getIndex());
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
        RexCall call = (RexCall) result;
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
        assertEquals(Long.valueOf(100L), extractLiteralLong(call.getOperands().get(1)));
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        );
        );
        // Assert operators
        assertEquals((byte) 1, bytes[15]);  
        ConversionException ex = expectThrows(
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gte("2022-06-15||/M"), ctx);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("tiny_val").gte(200), ctx);
     * Arbitrary hostname input must be rejected with ConversionException,
        expectThrows(ConversionException.class, () -> translator.convert(query, ctx));  
            "Message should mention non-finite or Infinity: " + ex.getMessage(),
        assertTrue("Message should mention binary fields: " + ex.getMessage(), ex.getMessage().contains("binary"));
        assertNotNull(literal);
    /** Infinity as raw Double on BIGINT must throw ConversionException. */  
    /** gte 200 on TINYINT (max=127) -> match-none (FALSE literal). */  
        assertLiteralNumber(result, Integer.valueOf(-11), null);  
    }
        assertNotNull("Could not unwrap literal from: " + operand1, literal);
        assertEquals(9, literal.getType().getPrecision());
        // makeLiteral wraps nullable types in CAST  
        RexCall call = (RexCall) result;
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("NaN")  
        assertEquals("rating", ctx.getRowType().getFieldList().get(3).getName());
        RexCall call = (RexCall) result;
        assertEquals(Long.valueOf(-52L), extractLiteralLong(call.getOperands().get(1)));
        assertEquals(1, fieldRef.getIndex());
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());  
     * uses roundUp=true per DateFieldMapper.dateRangeQuery (roundUp=!includeLower).
        ConversionException ex = expectThrows(  
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
    private RexLiteral unwrapLiteral(RexNode node) {  
            QueryBuilders.rangeQuery("event_time").gte("2022-01-01T00:00:00").timeZone("America/New_York"),
     */  
            () -> translator.convert(QueryBuilders.rangeQuery("scaled_price").gt("not-a-number"), ctx)
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").lte(Double.NEGATIVE_INFINITY), ctx);
        assertTrue(result instanceof RexCall);  
    /**  
     * REGRESSION: plain date field (event_time, precision 3) still yields precision-3 millis literal.
        assertEquals(2, call.getOperands().size());
    /** NaN as String "NaN" on INTEGER must throw ConversionException. */  
            "Message should mention out of range or overflow: " + ex.getMessage(),
        assertTrue(result instanceof RexCall);
    }
        assertNotNull(call.getOperands().get(1));
    public void testRoundingMonthWithGte() throws ConversionException {
        RexCall call = (RexCall) result;  
        RexCall lower = (RexCall) call.getOperands().get(0);
            () -> translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte(Double.POSITIVE_INFINITY), ctx)  
        assertNotNull(ex.getMessage());  
     */
            () -> translator.convert(QueryBuilders.rangeQuery("scaled_price").gte(Double.NaN), ctx)
    /** "Infinity" on REAL (float_val) must throw ConversionException. */
    }
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("now-1d/d"), ctx);
        // Per NumberFieldMapper.objectToUnsignedLong(lenientBound=true): negative upper clamps to 0,  
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("NaN")
    }
        RexCall call = (RexCall) result;
        assertEquals((byte) 0, bytes[14]);
    }
    /** NaN as raw Double on BIGINT must throw ConversionException. */  
        assertLiteralNumber(result, Long.valueOf(-4503599627370496L), null);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").lt("now/y"), ctx);
     * In legacy OpenSearch, SimpleMappedFieldType.rangeQuery() and DateFieldType.rangeQuery()  
    /**
    public void testNaNDoubleOnUnsignedLongThrows() {  
        RexCall upperBound = (RexCall) call.getOperands().get(1);
    }
     * the builder-level rejection that enforces the legacy contract earlier in the stack.
    public void testExistsOnUnsignedLong() throws ConversionException {  
        );
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").lt(10.5), ctx);
        RexNode withWithin = translator.convert(QueryBuilders.rangeQuery("price").gte(100).relation("WITHIN"), ctx);
    }
        );
        // gte 10.55 with factor 10 -> Math.round(105.5) = 106, inclusive, GTE
    public void testGte() throws ConversionException {
    /**
        );  
        assertTrue("Should contain .854775807: " + tsStr, tsStr.contains(".854775807"));  
        assertTrue(
import org.opensearch.dsl.TestUtils;
        assertTrue(ex.getMessage().contains("NaN") || ex.getMessage().contains("non-finite"));  
    public void testEpochMillisLongBoundOnDateField() throws ConversionException {
        assertEquals(SqlKind.GREATER_THAN, call.getKind());
            ConversionException.class,
        RexCall call = (RexCall) result;
        RexLiteral upperLit = unwrapLiteral(upperBound.getOperands().get(1));  
    public void testLtDecimalAtLongMinMatchesNone() throws ConversionException {  
    public void testInfinityStringOnRealThrows() {
    /** gte 40000 on SMALLINT with lte -40000 -> match-none for both => AND of false? Actually each bound returns separately. */  
    }  
        assertTrue(result instanceof RexCall);
        assertLiteralNumber(result, Integer.valueOf(-11), null);  
    // here as ordinary comparisons that SQL evaluates identically.  
        assertTrue(result instanceof RexCall);  
    }
        assertEquals(2, call.getOperands().size());
        RexNode withoutRelation = translator.convert(QueryBuilders.rangeQuery("price").gte(100), ctx);
    /**  
        RexCall call = (RexCall) result;  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gt("10.5"), ctx);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("is_active").lt(false), ctx);  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
    }
     */
        assertTrue(  
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;  
        // gt 100 (whole, exclusive) → exclusive adjusts: +1 = 101, GTE  
    /**  
    }
            () -> translator.convert(QueryBuilders.rangeQuery("event_nanos").gte("-1").format("epoch_millis"), ctx)
     * Year-2262 clamping: date beyond MAX_NANOSECOND_INSTANT (~2262-04-11) is clamped
        ConversionException ex = expectThrows(
        assertTrue(
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());  
        assertTrue(result instanceof RexCall);  
        RexCall andCall = (RexCall) result;
    public void testGteAboveTinyintMaxMatchesNone() throws ConversionException {
    public void testGtOnUnsignedLongExclusiveWholeNumber() throws ConversionException {
        // Assert column reference  
        assertTrue(
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("NaN")
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte(Double.NaN), ctx);
        );
            () -> translator.convert(QueryBuilders.rangeQuery("scaled_price").gte(Double.NaN), ctx)  
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
        assertTrue(result instanceof RexCall);
        RexLiteral literal = unwrapLiteral(operand1);
    public void testLteAboveTinyintMaxNoConstraint() throws ConversionException {
    }
            () -> translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte("not-a-number"), ctx)
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gt(10.0), ctx);
    }
        assertTrue(result instanceof RexCall);  
            () -> translator.convert(QueryBuilders.rangeQuery("price").gte(Double.POSITIVE_INFINITY), ctx)
import org.apache.calcite.sql.type.SqlTypeName;  
        assertEquals(9, literal.getType().getPrecision());
        assertEquals("String literal mismatch", expectedValue, actualValue);  
        // End of 2026-07-28 in nanos: 2026-07-28 23:59:59.999999999
            ConversionException.class,
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upper.getKind());  
        assertEquals(Long.valueOf(105L), extractLiteralLong(call.getOperands().get(1)));  
        assertEquals(5, ((RexInputRef) call.getOperands().get(0)).getIndex());
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
            ConversionException.class,
    /**  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(-10.5), ctx);
     * gt 2147483647.5 on INTEGER field returns FALSE (match-none). Overflow guard:  
    /**
    public void testIpRangeExclusiveLowerBound() throws ConversionException {  
    public void testRoundingYearWithLt() throws ConversionException {  
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").lte("2022-01-01"), ctx);  
        assertEquals(13, ((RexInputRef) call.getOperands().get(0)).getIndex());
        RexCall call = (RexCall) result;
     */
        for (int i = 0; i < 15; i++) {  
        RexCall call = (RexCall) result;
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());  
     */  
    public void testNaNStringOnIntegerThrows() {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_nanos").gte("2022-01-01"), ctx);  
        assertEquals(2, call.getOperands().size());
    /**  
    public void testIpRangeIpv4EncodingValue() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(Integer.MAX_VALUE), ctx);  
        assertEquals(2, call.getOperands().size());
    /** Infinity string bound on scaled_float must throw ConversionException. */  
        assertTrue(result instanceof RexCall);
        RexCall lower = (RexCall) call.getOperands().get(0);
        assertTrue(
        assertTrue(result instanceof RexCall);  
    public void testDateOnlyUpperBoundRoundsUp() throws ConversionException {
    }  
    }  
        RexCall call = (RexCall) comparison;
    private void assertLiteralString(RexNode comparison, String expectedValue) {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").gte(10.5), ctx);
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("NaN")
            ctx
        return null; // unreachable
    }  
    /**  
            "Message should mention non-finite or NaN: " + ex.getMessage(),
        assertEquals(SqlTypeName.DECIMAL, literal.getTypeName());
        // Verify clamped to MAX_NANOSECOND_INSTANT via TimestampString  
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upperBound.getKind());
    }
    public void testDateMathSubtraction() throws ConversionException {
    public void testBothBounds() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gt(-10.5), ctx);
    public void testBooleanRangeGtTrue() throws ConversionException {
        assertEquals(2, call.getOperands().size());
    // ========== GROUP R3 - NON-FINITE ON REAL (FLOAT) ==========
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("now-7d"), ctx);
    public void testGteOnScaledFloat() throws ConversionException {  
        assertEquals(SqlKind.GREATER_THAN, call.getKind());  
        RexNode result = translator.convert(  
    }
    }  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gt("2022-01-01||/M"), ctx);
    public void testLteNegativeUpperOnUnsignedLong() throws ConversionException {  
        assertEquals(SqlKind.AND, call.getKind());  
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
        RexCall call = (RexCall) result;
    /**
    // ========== GROUP C - NON-DATE FIELDS ==========
     */
    public void testGteNegativeLowerOnUnsignedLong() throws ConversionException {
            () -> translator.convert(QueryBuilders.rangeQuery("price").gte(2147483648L), ctx)
    public void testWithFormatAndTimeZone() throws ConversionException {
        RexLiteral literal = (RexLiteral) result;
    /** lte -40000 on SMALLINT (min=-32768) -> match-none. */  
    public void testLtDecimalAtIntegerMinMatchesNone() throws ConversionException {  
    public void testGtDateRoundsUpExclusive() throws ConversionException {
        RexInputRef lowerRef = (RexInputRef) lowerBound.getOperands().get(0);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("is_active").gte(true).lte(true), ctx);
    }  
import org.apache.calcite.sql.SqlKind;
        ConversionException ex = expectThrows(
        assertNotNull(literal);
        RexCall call = (RexCall) result;  
        assertTrue(result instanceof RexCall);
        assertTrue(result instanceof RexCall);
            ConversionException.class,
            withoutRelation.toString(),
        assertTrue(
    public void testLteDecimalOnIntegerFieldPositive() throws ConversionException {  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("tiny_val").lte(200), ctx);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lowerBound.getKind());
        RexCall call = (RexCall) result;
        // Use epoch_millis format which is timezone-independent (epoch is absolute)
            () -> translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte("NaN"), ctx)  
        assertNotNull("Literal value is null", actualValue);
    public void testIpRangeIpv6EncodingValue() throws ConversionException {
            ConversionException.class,
    // Parity with BooleanFieldMapper.BooleanFieldType.rangeQuery:309 which converts bounds to  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("01/01/2022||+1M").format("dd/MM/yyyy"), ctx);  
    /**
    }
     * Invalid IP string throws ConversionException.
        assertEquals(Boolean.FALSE, literal.getValueAs(Boolean.class));  
    }
        );  
    public void testExplicitRoundingNotDoubleRounded() throws ConversionException {
        assertTrue(result instanceof RexCall);
            ctx
        assertTrue("Expected RexCall comparison, got: " + comparison.getClass(), comparison instanceof RexCall);
    /** epoch_millis with non-numeric string "abc" throws ConversionException. */
        assertEquals(2, lowerRef.getIndex());
        assertLiteralString(upperBound, "dell");
        RexLiteral literal = unwrapLiteral(operand1);
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));  
        RexCall call = (RexCall) result;
    public void testGt() throws ConversionException {
    // ========== GROUP E - PARAMETER AUDIT ==========
     * gte("::1") on ip field produces VARBINARY literal with native IPv6 encoding:
    public void testEpochMillisIgnoresTimeZone() throws ConversionException {
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());  
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Infinity")
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));  
        assertNotNull(ts);
    public void testBoundAboveLongMaxOnUnsignedLongThrows() {
            "Message should name the rejected value and the coercion failure: " + ex.getMessage(),  
     * numeric value and that its type matches the expected SqlTypeName.
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").gte(5.0).lte(20.0), ctx);  
        RexLiteral lowerLit = unwrapLiteral(lowerBound.getOperands().get(1));
    }
     * lt -10.5 on INTEGER field produces lte -11. Per NumberFieldMapper INTEGER.rangeQuery: negative decimal upper bound decrements.
     * 10 zero bytes + 0xff 0xff + 192(0xc0) 168(0xa8) 0(0x00) 1(0x01).  
        assertEquals(2, call.getOperands().size());
        ConversionException ex = expectThrows(
        // Verify IPv4-mapped structure: 10 zeros + 0xff 0xff + 192.168.0.1  
            "Message should mention non-finite or NaN: " + ex.getMessage(),
        // Assert literal values and type  
        assertTrue(result instanceof RexCall);
            () -> translator.convert(QueryBuilders.rangeQuery("timestamp").gte(Double.POSITIVE_INFINITY), ctx)
        RexCall upper = (RexCall) call.getOperands().get(1);  
    /** gte(100) on numeric field produces literal 100 with Calcite canonical DECIMAL type. */
     * Both bounds on ip field produce AND of two byte comparisons with correct operators.
        assertNotNull("IP literal should be ByteString", bs);  
        assertLiteralNumber(result, Integer.valueOf(10), null);  
        RexCall call = (RexCall) result;
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upper.getKind());  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
 *
        ConversionException ex = expectThrows(  
        assertNotNull(ts);  
    public void testRoundingWithGte() throws ConversionException {  
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));  
        assertTrue(result instanceof RexCall);
        RexCall call = (RexCall) result;  
    public void testNegativeValueOnScaledFloat() throws ConversionException {
        RexCall call = (RexCall) result;  
        );
    }
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        );  
            ConversionException.class,
        assertNotNull(gteTs);  
    public void testDateMathNow() throws ConversionException {
        assertNotEquals("Numeric string on numeric field must NOT produce TIMESTAMP type", SqlTypeName.TIMESTAMP, literal.getTypeName());
            ConversionException.class,
     */  
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").lte("now/d"), ctx);  
        assertTrue("Lower bound above SMALLINT max must produce literal false (match-none)", result instanceof RexLiteral);
     * Calcite stores TIMESTAMP(3) literals as millis-since-epoch internally.
     * 2022-01-31T23:59:59.999Z = 1643673599999L.
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Expected DOUBLE type for double value on DOUBLE field", SqlTypeName.DOUBLE, literal.getTypeName());
    public void testInfinityStringOnIntegerThrows() {
            "CONTAINS relation must produce identical expression to no-relation (legacy scalar behavior)",
        RexNode operand1 = call.getOperands().get(1);
        assertEquals(5, ((RexInputRef) lower.getOperands().get(0)).getIndex());
        assertLiteralEpoch(result, 1641081599999L);
        assertLiteralEpoch(result, -14256000000L);  
import org.apache.calcite.rex.RexLiteral;  
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upperBound.getKind());  
        assertEquals(Long.valueOf(11L), extractLiteralLong(call.getOperands().get(1)));
    }
    /**  
    }  
    public void testRoundingWithLt() throws ConversionException {  
        assertEquals(11, ((RexInputRef) call.getOperands().get(0)).getIndex());
    public void testDateMathRounding() throws ConversionException {  
        assertEquals(3, fieldRef.getIndex());  
    public void testGtDecimalOnIntegerFieldPositive() throws ConversionException {  
        // gt -5.3 with factor 10 -> Math.round(-53.0) = -53, +1 for exclusive = -52, GTE  
        assertEquals(SqlTypeName.CHAR, upperLit.getTypeName());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lte(500), ctx);
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").gte("1.5"), ctx);
    /** lt(false) can never be satisfied; vanilla returns MatchNoDocsQuery for this impossible range. */
    public void testBooleanRangeGteFalseAndLteTrue() throws ConversionException {
        );
    /** lte("now/d") with explicit rounding operator produces expected shape (nondeterministic value). */  
            "Message should mention out of range or overflow: " + ex.getMessage(),
        RexLiteral upperLit = unwrapLiteral(upper.getOperands().get(1));
     */
        }  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gt(10.5), ctx);
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());  
        }
        assertEquals((byte) 0xff, bytes[10]);
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));
     */  
    }  
            () -> translator.convert(QueryBuilders.rangeQuery("price").gte(Double.NaN), ctx)
    }
    }
     * gte -10.5 on INTEGER field produces gte -10. Per NumberFieldMapper INTEGER.rangeQuery: negative decimal lower bound, no increment.
    /**
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gt(10.5), ctx);
     * gt vs gte at a nanosecond boundary must differ by rounding.
    /** BUG 2 proof: gte 2147483648L on INTEGER silently narrows to -2147483648 instead of throwing. */
     */
    /**
        // The TimestampString must preserve all 9 fractional digits
            () -> translator.convert(QueryBuilders.rangeQuery("binary_data").gte("abc"), ctx)
     * gt "2022-01-01" on date field rounds UP (end-of-day) because exclusive lower bound
        RexNode result = translator.convert(QueryBuilders.rangeQuery("brand").gt("apple").lt("dell"), ctx);
        // gte rounds down to start of day (no fractional part or all zeros)
     * to the max nanosecond epoch value, not overflowing.
        RexCall call = (RexCall) result;
    // ========== STRING-COERCED NUMERIC BOUND TESTS ==========
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gte(1640995200000L), ctx);  
    public void testWithFormat() throws ConversionException {
        assertLiteralString(lowerBound, "apple");  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").gt(-5.3), ctx);
        RexCall upperBound = (RexCall) call.getOperands().get(1);  
    // ========== GROUP R - NON-FINITE BOUNDS ON INTEGER FAMILY ==========
     * In legacy OpenSearch, SimpleMappedFieldType.rangeQuery() and DateFieldType.rangeQuery()
    // ========== GROUP T - TINYINT/SMALLINT BOUNDARY (MATCH-NONE / NO-CONSTRAINT) ==========
        assertEquals(SqlTypeName.TIMESTAMP, literal.getType().getSqlTypeName());  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("is_active").gt(true), ctx);  
    /** format("epoch_millis") with string "1640995200000" produces literal == 1640995200000L. */
        assertTrue(ex.getMessage().contains("not-a-number"));
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lt(500), ctx);
        RexCall call = (RexCall) result;  
        // lt 10.5 with factor 10 -> 105, -1 for exclusive = 104, LTE  
    /** Short.MIN_VALUE (-32768) on SMALLINT must still produce a valid comparison. */  
            ConversionException.class,  
    public void testExclusiveLexicographicRangeOnKeywordField() throws ConversionException {
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));  
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);  
    // ========== END OF TESTS ==========
        RangeQueryBuilder query = QueryBuilders.rangeQuery("price").gte(100);
    /**
        assertNotNull(literal);
            RexCall call = (RexCall) node;
    /**
    // ========== GROUP R4 - NON-FINITE ON DOUBLE (must NOT throw) ==========
            "Message should mention non-finite or Infinity: " + ex.getMessage(),
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
            "WITHIN relation must produce identical expression to no-relation (legacy scalar behavior)",  
        ConversionException ex = expectThrows(  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("now-1M/M"), ctx);  
        RexCall call = (RexCall) result;
        );
    /**  
        // lt -1 on unsigned_long: negative upper → match-none.
    }  
    /**
    // ========== SCALED_FLOAT RANGE TESTS ==========  
        RexLiteral upperLit = unwrapLiteral(upper.getOperands().get(1));  
        assertTrue(result instanceof RexCall);  
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Infinity") || ex.getMessage().contains("above")
    // ========== HELPER METHODS FOR LITERAL VALUE EXTRACTION ==========  
        ConversionException ex = expectThrows(  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gt(2147483647.5), ctx);
    }  
    public void testIpRangeHostnameArbitraryThrows() {
     */
        RexNode gtResult = translator.convert(QueryBuilders.rangeQuery("event_nanos").gt("2026-07-28"), ctx);
        assertTrue("Should be clamped to 2262-04-11: " + tsStr, tsStr.startsWith("2262-04-11"));
    /** lte -2147483649L on INTEGER must throw ConversionException. */
            ConversionException.class,
        // gt with roundUp=true: "2022-01-01||/M" rounds to end of month = 2022-01-31T23:59:59.999Z
    }  
    public void testTimeZoneShiftsEpoch() throws ConversionException {  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        RexNode gteResult = translator.convert(QueryBuilders.rangeQuery("event_nanos").gte("2026-07-28"), ctx);
     */  
     * gte 10.5 on INTEGER field produces gte 11. Per NumberFieldMapper INTEGER.rangeQuery: positive decimal lower bound increments.
    public void testGteOnUnsignedLongInRange() throws ConversionException {  
    public void testFormatWithSlashSeparatorsStillRoundsUp() throws ConversionException {
        ConversionException ex = expectThrows(
    }
        // Bound 9223372036854775808 (Long.MAX_VALUE + 1) → ConversionException.
        RexLiteral lowerLit = unwrapLiteral(lowerBound.getOperands().get(1));  
            return lit.getValueAs(Long.class);
    public void testNaNDoubleOnRealThrows() {
    }  
    }
     * truncate to Integer.MIN_VALUE, decrement would overflow, matching NumberFieldMapper MatchNoDocsQuery.
    // ========== FIX 1: NaN/Infinity rejection on scaled_float range ==========
        assertEquals(Long.valueOf(200L), extractLiteralLong(upper.getOperands().get(1)));
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte(Double.POSITIVE_INFINITY), ctx);
    public void testLtOnUnsignedLongExclusiveWholeNumber() throws ConversionException {
    public void testEpochMillisFormatGte() throws ConversionException {  
    }
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").lt("now/d"), ctx);
        );  
        assertEquals(Boolean.FALSE, literal.getValueAs(Boolean.class));
        for (int i = 0; i < 10; i++) {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("now"), ctx);  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lower.getKind());  
        assertLiteralEpoch(result, 1640995200000L);
        RexCall call = (RexCall) result;
     */
        // then l(0) > u(0 after exclusive decrement = underflow) → MatchNoDocsQuery.
    public void testUnknownFieldMatchesNone() throws ConversionException {
        assertLiteralEpoch(result, 1640995200000L);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("ip_address").gte("192.168.0.1"), ctx);  
     * Uses a value within double's exact-integer range (below 2^52) where the fractional part is preserved.
     * whose epoch-nanosecond value ends in ...123456789 exactly. This verifies no truncation to millis.
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
            ConversionException.class,
     * No bounds produces IS_NOT_NULL, matching legacy RangeQueryBuilder.doToQuery exists rewrite.
    }
        assertTrue(ex.getMessage().contains("coerce") || ex.getMessage().contains("Non-numeric"));  
    }  
    }
     * gt -10.5 on INTEGER field produces gte -10. Per NumberFieldMapper INTEGER.rangeQuery: negative decimal lower bound, no increment.
    }  
     */
    // ========== GROUP P - CHARACTERIZATION: MILLIS vs NANOS BOUNDARY BEHAVIOUR ==========  
import org.apache.calcite.rex.RexCall;
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("timestamp").lt(-4503599627370495.5), ctx);  
        assertTrue(
    }
     * lt -2147483648.5 on INTEGER field returns FALSE (match-none). Overflow guard:  
        assertTrue(result instanceof RexCall);
        );
            ConversionException.class,  
            ConversionException.class,  
            "Expected message about value before epoch, got: " + ex.getMessage(),
        // Per NumberFieldMapper.objectToUnsignedLong(lenientBound=true): values below 0 return
            withContains.toString()  
            return ((RexLiteral) cast.getOperands().get(0)).getValueAs(Long.class);
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
        assertEquals(SqlKind.LESS_THAN, call.getKind());
        );  
    // ========== GROUP S - UNCHECKED NARROWING OVERFLOW ==========
        RexCall call = (RexCall) result;  
            "Message should mention non-finite or Infinity: " + ex.getMessage(),
    }
    public void testGtDecimalOnUnsignedLong() throws ConversionException {  
        assertTrue(result instanceof RexCall);
    }
    }
        assertTrue(ex.getMessage().contains("NaN") || ex.getMessage().contains("non-finite"));  
        assertEquals(2, upperBound.getOperands().size());
            () -> translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte("9223372036854775808"), ctx)
        RexLiteral literal = (RexLiteral) result;
    public void testLteBelowSmallintMinMatchesNone() throws ConversionException {
        RexCall upperBound = (RexCall) call.getOperands().get(1);
        );  
        RexCall call = (RexCall) result;
    public void testNaNStringOnBigintThrows() {
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
        ConversionException ex = expectThrows(
        RexNode result = translator.convert(
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;
    public void testGteBelowTinyintMinNoConstraint() throws ConversionException {
            ConversionException.class,
        assertTrue(result instanceof RexCall);
    }
        org.apache.calcite.util.TimestampString gtTs = gtLiteral.getValueAs(org.apache.calcite.util.TimestampString.class);
        ConversionException ex = expectThrows(
        assertEquals(2, call.getOperands().size());
     * queryName("my_range") throws ConversionException; unsupported parameters are rejected.
        RexLiteral literal = unwrapLiteral(operand1);
        assertTrue("Must contain .854775807, got: " + tsStr, tsStr.contains(".854775807"));
        assertEquals(Boolean.FALSE, literal.getValueAs(Boolean.class));
        );  
    public void testNumericStringOnNumericField() throws ConversionException {
        RexCall lower = (RexCall) andCall.getOperands().get(0);
     */
     * gt on ip field produces GREATER_THAN (exclusive).
        assertEquals(5, ((RexInputRef) upper.getOperands().get(0)).getIndex());
    }  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unknown").gte(1), ctx);  
    public void testFixedDateMathRounding() throws ConversionException {
        // event_time is index 10 in the schema
    }  
    /** Double.NaN bound on scaled_float must throw ConversionException. */  
     */
    public void testRangeOnBinaryFieldThrows() {
        ConversionException ex = expectThrows(  
        assertEquals(Long.valueOf(100L), extractLiteralLong(call.getOperands().get(1)));
        // End of 2022-01-01 = 2022-01-01T23:59:59.999Z = 1641081599999L
    // ========== GROUP R2 - NON-FINITE ON UNSIGNED_LONG ==========  
    public void testNaNOnScaledFloatRegressionPin() {  
        ConversionException ex = expectThrows(  
    public void testLt() throws ConversionException {
    public void testDateMathAddition() throws ConversionException {
        RexNode operand1 = call.getOperands().get(1);  
        if (node instanceof RexLiteral lit) {  
import org.opensearch.index.query.RangeQueryBuilder;
     * Calcite's canonical DECIMAL type is acceptable.
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").lte("now+1M"), ctx);  
        }
     * String "100" on numeric field coerces to numeric 100, not TIMESTAMP.
        RexCall upper = (RexCall) andCall.getOperands().get(1);
    // ========== GROUP R5 - SCALED_FLOAT NAN/INFINITY REGRESSION PIN ==========  
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("ip_address").gt("10.0.0.1"), ctx);
            () -> translator.convert(QueryBuilders.rangeQuery("timestamp").gte("Infinity"), ctx)
            QueryBuilders.rangeQuery("event_time").gte("1640995200000").format("epoch_millis").timeZone("America/New_York"),  
        );  
    public void testGtDecimalAtIntegerMaxMatchesNone() throws ConversionException {  
        assertTrue(result instanceof RexCall);
        // Assert column reference (brand is index 2 in TestUtils schema)  
    }
        assertEquals(SqlKind.AND, call.getKind());
        assertNotNull(call.getOperands().get(1));
        assertTrue(
    public void testReportsCorrectQueryType() {
    }
        assertTrue("Expected RexCall comparison, got: " + result.getClass(), result instanceof RexCall);
     */
        assertLiteralEpoch(result, 1641081599999L);  
        // For TIMESTAMP(3) literals, Calcite stores the value as millis from epoch
    }
     * since RangeQueryBuilder.timeZone() calls ZoneId.of() which validates immediately.
     * Invalid timezone string throws IllegalArgumentException at builder construction time
        assertEquals("IPv6-mapped encoding must be 16 bytes", 16, bytes.length);
        // Must contain .123456789 (all 9 digits preserved)  
    /** Bound past Long range on BIGINT (as String) must throw ConversionException. */
            return (RexLiteral) node;
        ConversionException ex = expectThrows(
        RexCall call = (RexCall) result;  
        assertEquals(2, call.getOperands().size());  
        assertTrue("Must clamp to 2262-04-11, got: " + tsStr, tsStr.startsWith("2262-04-11"));
     * Asserts that the literal operand (operand 1) of a comparison RexCall has the given string value.  
        RexCall lowerBound = (RexCall) call.getOperands().get(0);
        assertEquals(2, call.getOperands().size());  
            "Message should mention non-finite or NaN: " + ex.getMessage(),
    }
        assertEquals(2, call.getOperands().size());
        assertEquals(SqlKind.AND, call.getKind());
    }
            ConversionException.class,  
    }
 * this file be licensed under the Apache-2.0 license or a
    public void testGtDecimalOnIntegerFieldNegative() throws ConversionException {  
    }
        assertTrue(  
    public void testGtWholeDoubleOnIntegerField() throws ConversionException {
            ConversionException.class,  
        assertEquals(2, call.getOperands().size());  
            ctx  
        );
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lte(Integer.MIN_VALUE), ctx);  
     */
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").gt(10.5), ctx);
     * (isRelationAllowed returns false), so our translator never sees it. This test asserts
        );  
            "Message should mention non-finite or Infinity: " + ex.getMessage(),
    /** Integer.MAX_VALUE on INTEGER must still produce a valid comparison. */
        // Must produce a comparison, not throw  
        assertTrue(
        RexNode result = translator.convert(QueryBuilders.rangeQuery("small_val").lte(40000), ctx);
     */
        assertLiteralEpoch(result, 1640995200000L);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        );
    /**
        org.apache.calcite.avatica.util.ByteString bs = literal.getValueAs(org.apache.calcite.avatica.util.ByteString.class);
    }
     * Unwraps a RexNode to get the underlying RexLiteral, handling CAST wrappers.  
     * supported via nanosecond-resolution parsing and TIMESTAMP(9) literals.  
        assertNotNull(literal);
    public void testGtOnScaledFloat() throws ConversionException {
        assertLiteralString(lowerBound, "apple");
    /**
        assertEquals(
     */
        assertEquals(1, fieldRef.getIndex());
     */
     * Range query on ip-typed field produces VARBINARY byte-range comparison.
    public void testNaNDoubleOnIntegerThrows() {
            () -> translator.convert(QueryBuilders.rangeQuery("price").gte("NaN"), ctx)
    public void testWithinRelationIgnoredOnScalarField() throws ConversionException {
        query.boost(2.0f);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gte("1640995200000").format("epoch_millis"), ctx);
     * Expected: 2022-12-31T23:59:59.999Z = 1672531199999L.  
        assertNotNull("Could not unwrap literal from: " + operand1, literal);  
        }
     */
        // 2300-01-01 is beyond MAX_NANOSECOND_INSTANT (2262-04-11T23:47:16.854775807Z)
    public void testDateNanosYear2262Clamp() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gt("2022-01-01"), ctx);  
     */  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter"), ctx);
    /**  
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("NaN")
package org.opensearch.dsl.query.range;
import org.opensearch.index.query.QueryBuilders;
    /**
        RexLiteral lowerLit = unwrapLiteral(lower.getOperands().get(1));
            () -> translator.convert(QueryBuilders.rangeQuery("timestamp").gte("NaN"), ctx)
        // Assert literal type (Calcite produces CHAR for string literals)  
            ConversionException.class,
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());
     * Verifies CONTAINS relation is silently ignored on scalar fields, matching legacy behavior.  
        if (expectedType != null) {  
        Long millis = literal.getValueAs(Long.class);  
        RexCall call = (RexCall) result;
    }  
    public void testIntegerMinValueStillWorks() throws ConversionException {
        RexCall call = (RexCall) result;  
    }  
        assertEquals(Boolean.TRUE, lowerLit.getValueAs(Boolean.class));  
        // MIN_UNSIGNED_LONG_VALUE (0). With lower defaulting to 0 and no upper, this becomes
        );
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
    }
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lower.getKind());
        // MAX_NANOSECOND_INSTANT = 2262-04-11T23:47:16.854775807Z
    public void testPreEpochDateOnMillisFieldProducesNegativeValue() throws ConversionException {  
import org.apache.calcite.rex.RexInputRef;
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
    }
    /** NaN as raw Double on unsigned_long must throw ConversionException. */
    /**
        assertNotNull(literal);  
        assertLiteralNumber(result, Integer.valueOf(11), null);  
            ConversionException.class,  
        assertEquals(3, ((RexInputRef) lowerBound.getOperands().get(0)).getIndex());  
        assertTrue("gte should be start of 2026-07-28: " + gteStr, gteStr.startsWith("2026-07-28 00:00:00"));
    /**
    public void testRoundingWithLte() throws ConversionException {
            () -> translator.convert(QueryBuilders.rangeQuery("float_val").gte(Double.NaN), ctx)
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        RexLiteral gteLiteral = unwrapLiteral(gteCall.getOperands().get(1));  
        assertEquals(SqlKind.GREATER_THAN, call.getKind());  
    }
     * Verifies WITHIN relation is silently ignored on scalar fields, matching legacy behavior.
        assertNotNull(millis);
    /** gte(true) AND lte(true) selects only true; vanilla collapses to termQuery(true). */
        assertTrue("Lower bound above TINYINT max must produce literal false (match-none)", result instanceof RexLiteral);  
        RexLiteral literal = unwrapLiteral(operand1);  
        RexLiteral lit = unwrapLiteral(call.getOperands().get(1));  
        assertEquals("Numeric value mismatch", expectedValue, actualValue);
            ex.getMessage().contains("NaN") && ex.getMessage().contains("coerce")
        RexCall call = (RexCall) result;  
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());  
     * gte("192.168.0.1") on ip field produces VARBINARY literal with IPv4-mapped-IPv6 encoding:
     * Calcite may wrap literals in CAST when the type doesn't exactly match.
        String actualValue = literal.getValueAs(String.class);
        RexLiteral literal = (RexLiteral) result;
        // Legacy scalar mappers also reject DISJOINT, so the contract is preserved.
        );
        RexNode withContains = translator.convert(QueryBuilders.rangeQuery("price").gte(100).relation("CONTAINS"), ctx);  
        assertEquals(SqlKind.LESS_THAN, call.getKind());  
            withoutRelation.toString(),
        assertLiteralNumber(result, Integer.valueOf(10), null);  
        assertTrue(result instanceof RexCall);
    public void testByteMaxValueOnTinyintStillWorks() throws ConversionException {
     * Ensures the precision-9 path does not break existing millisecond date handling.
        );  
        assertNotNull("Could not unwrap literal from: " + operand1, literal);
        assertTrue("Upper bound above SMALLINT max should produce IS_NOT_NULL (no constraint)", result instanceof RexCall);  
    }
            ConversionException.class,  
        assertTrue(
        assertEquals(1, fieldRef.getIndex());
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
        // gt rounds up to end of day: 23:59:59.999999999
        RexCall gteCall = (RexCall) gteResult;
        assertTrue("No-bounds should produce IS NOT NULL call", result instanceof RexCall);  
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lt(-10.5), ctx);
        assertEquals(SqlKind.AND, call.getKind());  
    /**
    public void testInfinityStringOnBigintThrows() {
     */
    }
    }
            () -> translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte("-Infinity"), ctx)  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("now-7d/d").lte("now/d"), ctx);
        // gte 100 (whole, inclusive) → GTE 100
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(100).lte(500), ctx);
        );
    private void assertLiteralNumber(RexNode comparison, Number expectedValue, SqlTypeName expectedType) {  
    public void testLexicographicRangeOnKeywordField() throws ConversionException {
    /**
        ConversionException ex = expectThrows(
     */  
        RexCall call = (RexCall) result;
     * Range query on binary_data field (plain VARBINARY, not IpType) throws ConversionException.
        RexCall lowerBound = (RexCall) call.getOperands().get(0);
        RexCall call = (RexCall) result;
        RexNode operand1 = call.getOperands().get(1);  
        // gt 10.5 with factor 10 -> Math.round(10.5 * 10) = 105, +1 for exclusive = 106, GTE  
        // Per NumberFieldMapper.longRangeQuery: exclusive lower increments to make inclusive GTE.
            ConversionException.class,  
    }  
            ex.getMessage().contains("before epoch not representable in nanos")
        // Type must be TIMESTAMP(9)
    public void testGtDateMathExplicitRounding() throws ConversionException {
        RexCall call = (RexCall) result;
        assertNotNull(call.getOperands().get(1));
    public void testDateNanosLiteralPreservesFullNanoPrecision() throws ConversionException {  
    /**
        ConversionException ex = expectThrows(
    /** Far-future bound on date_nanos clamps to MAX_NANOSECOND_INSTANT (2262-04-11T23:47:16.854775807Z). */  
    public void testDateMathWithFormat() throws ConversionException {
    }
        assertEquals(9, literal.getType().getPrecision());
            "Message should mention non-finite or NaN: " + ex.getMessage(),
        assertEquals(RangeQueryBuilder.class, translator.getQueryType());  
    }  
    }  
        assertTrue(result instanceof RexCall);
        assertLiteralEpoch(result, 1641013200000L);
        assertEquals(2, call.getOperands().size());
        assertEquals("Epoch millis mismatch", expectedEpochMillis, actualValue.longValue());
    // ========== GROUP D - ROUNDING EDGE CASES ==========
    /**
    }  
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Non-finite")
            ConversionException.class,  
        // getValueAs(Long.class) returns the internal millis representation
    /** gt(true) can never be satisfied; vanilla returns MatchNoDocsQuery for this impossible range. */
        expectThrows(IllegalArgumentException.class, () -> QueryBuilders.rangeQuery("price").gte(100).timeZone("Invalid/NotAZone"));
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        assertLiteralNumber(result, Integer.valueOf(Integer.MAX_VALUE), null);
        String tsStr = ts.toString();
        RexCall call = (RexCall) result;
        // ::1 = 15 zero bytes + 0x01
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
    /** epoch_millis is absolute; timeZone parameter does not shift the value. */  
    public void testNaNStringOnUnsignedLongThrows() {  
        // Value must be exactly 100; Calcite makeLiteral with INTEGER field type stores as DECIMAL
        RexCall call = (RexCall) result;
        // 2022-01-01T00:00:00 in America/New_York = 2022-01-01T05:00:00Z = 1641013200000L  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        // Value must be 100
 * compatible open source license.
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
    }
        );
        RexCall call = (RexCall) result;
        // event_nanos is field index 12
        RexCall gtCall = (RexCall) gtResult;
    }  
    public void testIntegerMaxValueStillWorks() throws ConversionException {
        RexCall call = (RexCall) result;
        assertEquals(SqlKind.AND, call.getKind());  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
        RexCall call = (RexCall) result;
    }
     * lte 10.5 on INTEGER field produces lte 10. Per NumberFieldMapper INTEGER.rangeQuery: positive decimal upper bound, no decrement.
    /**
        assertEquals("Plain date field should use millis precision", 1785369600123L, millis.longValue());
        assertEquals(SqlTypeName.TIMESTAMP, literal.getType().getSqlTypeName());  
    /**  
        assertEquals(1, fieldRef.getIndex());
        assertTrue("TimestampString must start with 2026-07-28, got: " + tsStr, tsStr.startsWith("2026-07-28"));  
    /** "Infinity" as String on INTEGER must throw ConversionException. */  
        RexCall call = (RexCall) result;
    /**  
    public void testNaNDoubleOnDoubleFieldAccepted() throws ConversionException {
    }
    }  
        assertEquals(Long.valueOf(105L), extractLiteralLong(call.getOperands().get(1)));
    /** "NaN" as String on unsigned_long must throw ConversionException. */
    /** Byte.MAX_VALUE (127) on TINYINT must still produce a valid comparison. */
     * RangeQueryBuilder.relation("DISJOINT") itself rejects DISJOINT at the builder level  
            () -> translator.convert(QueryBuilders.rangeQuery("scaled_price").gte("NaN"), ctx)
    /** NaN on DOUBLE field must NOT throw -- legacy accepts non-finite doubles. */  
}  
        RexCall call = (RexCall) result;
    // BytesRef "T"/"F", collapses lower==upper to termQuery, and returns MatchNoDocsQuery for
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        // 10.0 has no decimal part, so no adjustment; stays exclusive GREATER_THAN  
    /**
        assertTrue(result instanceof RexCall);
    public void testDateNanosGtVsGteDifferByRounding() throws ConversionException {
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        assertEquals(2, call.getOperands().size());  
    public void testLtDecimalOnIntegerFieldPositive() throws ConversionException {  
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        RexCall call = (RexCall) result;
    public void testRoundingBothBounds() throws ConversionException {
        assertTrue(  
    }
        assertTrue("Should produce literal false (match-none) at Integer.MIN_VALUE boundary", result instanceof RexLiteral);  
        ConversionException ex = expectThrows(
        assertEquals(10, ((RexInputRef) call.getOperands().get(0)).getIndex());  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gt("now-1d/d"), ctx);
        );  
        assertEquals(Long.valueOf(104L), extractLiteralLong(call.getOperands().get(1)));
        assertEquals(Long.valueOf(106L), extractLiteralLong(call.getOperands().get(1)));
    }
        // The error may come from coercion (Long overflow) or from our explicit check.
        org.apache.calcite.avatica.util.ByteString bs = literal.getValueAs(org.apache.calcite.avatica.util.ByteString.class);
    }  
    public void testWithIntersectsRelation() throws ConversionException {
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.rangeQuery("ip_address").gte("not_an_ip"), ctx));
    }
        RexLiteral gtLiteral = unwrapLiteral(gtCall.getOperands().get(1));  
        // Assert exclusive operators
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lte(-10.5), ctx);
        assertTrue(result instanceof RexCall);  
     * DNS resolution must never be attempted on user-supplied range bounds.
        assertTrue("TimestampString must contain 9-digit fraction .123456789, got: " + tsStr, tsStr.contains(".123456789"));
        Number actualValue = literal.getValueAs(expectedValue.getClass());  
        assertLiteralString(upperBound, "dell");  
        assertEquals(Long.valueOf(50L), extractLiteralLong(lower.getOperands().get(1)));
    public void testFarFutureDateOnNanosFieldClampsToMax() throws ConversionException {
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    /** timeZone("America/New_York") shifts the parsed epoch by UTC-5 offset. */
        assertEquals(SqlKind.LESS_THAN, upperBound.getKind());
        assertLiteralEpoch(result, 1640995200000L);  
     * gt "2026-07-28" uses roundUp=true (exclusive lower), producing end-of-day nanos.
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());  
        assertEquals(2, upperRef.getIndex());
        byte[] bytes = bs.getBytes();
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
        assertEquals(SqlKind.AND, call.getKind());
    }
     * String bounds on VARCHAR field produce lexicographic comparisons without date parsing.
        assertNotNull(literal);  
        assertEquals(SqlKind.GREATER_THAN, call.getKind());
     * Expected: 2022-01-01T23:59:59.999Z = 1641081599999L, operator GREATER_THAN.  
        assertEquals("IPv6 encoding must be 16 bytes", 16, bytes.length);
        org.apache.calcite.util.TimestampString ts = literal.getValueAs(org.apache.calcite.util.TimestampString.class);  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lower.getKind());
    }
        assertEquals(1, ((RexInputRef) upperBound.getOperands().get(0)).getIndex());
        assertTrue("Lower bound below TINYINT min should produce IS_NOT_NULL (no constraint)", result instanceof RexCall);
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
     * the given epoch millis value. Handles both direct RexLiteral and CAST-wrapped forms.
    public void testNaNDoubleOnBigintThrows() {
    /** "-Infinity" as String on unsigned_long must throw ConversionException. */
        // gte 10.5 with factor 10 -> Math.round(10.5 * 10) = 105, inclusive, GTE
        assertTrue("lte should round up to end of day at nano granularity (.999999999): " + tsStr, tsStr.contains("23:59:59.999999999"));  
        );  
     */
        assertTrue(result instanceof RexCall);
        assertLiteralNumber(result, Integer.valueOf(-10), null);  
        assertTrue("Non-finite on DOUBLE should produce a RexCall, not throw", result instanceof RexCall);  
    }
        assertTrue(result instanceof RexCall);
     * 15 zero bytes + 0x01.
    // ========== GROUP L - FIELD TYPE GUARDS AND IP RANGE SUPPORT ==========
            () -> translator.convert(QueryBuilders.rangeQuery("float_val").gte("Infinity"), ctx)
        );
        assertEquals(14, ((RexInputRef) call.getOperands().get(0)).getIndex());
     * Exclusive string bounds on keyword field produce GREATER_THAN / LESS_THAN operators.
        assertTrue("Upper bound below SMALLINT min must produce literal false (match-none)", result instanceof RexLiteral);  
    }
        assertEquals(Boolean.FALSE, lowerLit.getValueAs(Boolean.class));
        String tsStr = ts.toString();
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").lte("now/d"), ctx);
     * The guard that previously threw ConversionException has been removed; date_nanos is now
        ConversionException ex = expectThrows(
    }
     */  
    }
     * lte -10.5 on INTEGER field produces lte -11. Per NumberFieldMapper INTEGER.rangeQuery: negative decimal upper bound decrements.
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    /** Custom format dd/MM/yyyy parses "01/01/2022" to epoch 1640995200000 (2022-01-01T00:00:00Z). */
            ConversionException.class,  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte("100"), ctx);  
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, upperBound.getKind());  
        RexCall call = (RexCall) result;  
    public void testOverflowBoundScaledFloatReturnsFalse() {
        assertEquals(SqlTypeName.CHAR, lowerLit.getTypeName());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(100), ctx);
        );
     * uses roundUp=false per DateFieldMapper.dateRangeQuery (roundUp=includeUpper=false).
            QueryBuilders.rangeQuery("rating").gte("2022-01-01T00:00:00").timeZone("America/New_York"),
        RexCall call = (RexCall) result;  
    /** Negative epoch_millis value on date_nanos field throws ConversionException. */  
    public void testBoundPastLongRangeOnBigintThrows() {
    }  
        assertNotEquals("Long value on numeric field should NOT produce TIMESTAMP type", SqlTypeName.TIMESTAMP, literal.getTypeName());
    public void testNegativeEpochMillisOnDateNanosFieldThrows() {
    public void testGteDecimalOnIntegerFieldNegative() throws ConversionException {  
    }
        );
    }  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").lte(-5), ctx);
        }  
        );
        RexLiteral literal = unwrapLiteral(operand1);
     */
            () -> translator.convert(QueryBuilders.rangeQuery("price").lte(-2147483649L), ctx)
    private void assertLiteralEpoch(RexNode comparison, long expectedEpochMillis) {
    // ========== GROUP G - DATE ROUNDING KEYED ON INCLUSIVITY ==========
    public void testDisjointRelationRejected() {
     * Expected: 2022-01-01T00:00:00.000Z = 1640995200000L, operator LESS_THAN.
        );
    /** NaN on REAL (float_val) must throw ConversionException. */
        assertEquals(SqlKind.LESS_THAN, call.getKind());
    public void testLtDateRoundsDownExclusive() throws ConversionException {
        assertTrue(
        // Only an upper bound that exceeds the type max; upper becomes null => IS_NOT_NULL (exists)  
    /** Integer.MIN_VALUE on INTEGER must still produce a valid comparison. */
            if (call.getKind() == SqlKind.CAST) {  
    public void testNonNumericBoundOnUnsignedLongThrows() {
        assertEquals(Integer.valueOf(100), literal.getValueAs(Integer.class));  
        );
        assertEquals(2, call.getOperands().size());
    /**  
        assertEquals(SqlKind.GREATER_THAN, lowerBound.getKind());  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gte("1785369600123").format("epoch_millis"), ctx);  
    public void testGteDecimalOnIntegerFieldPositive() throws ConversionException {  
    }  
        RexCall upper = (RexCall) call.getOperands().get(1);
        assertLiteralEpoch(result, 1672531199999L);  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("ip_address").gte("::1"), ctx);
/*  
        assertTrue("Expected RexCall comparison, got: " + comparison.getClass(), comparison instanceof RexCall);
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);  
    }  
        // Verify the date part
        assertEquals(3, ((RexInputRef) lowerBound.getOperands().get(0)).getIndex());  
        RexCall call = (RexCall) result;
        assertEquals(5, ((RexInputRef) upper.getOperands().get(0)).getIndex());
        // Epoch millis is absolute; timezone should be irrelevant
     * gte("2022-06-15||/M") rounds down to start of month: 2022-06-01T00:00:00Z = 1654041600000L.
     * Asserts that the literal operand (operand 1) of a comparison RexCall represents  
    /** Negative Infinity on DOUBLE field must NOT throw. */  
        query.queryName("my_range");
    public void testRoundingWithGt() throws ConversionException {
        RexCall call = (RexCall) result;  
        assertTrue(result instanceof RexCall);
     * lt negative decimal on BIGINT field performs correct decimal-adjust with decrement.  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lowerBound.getKind());
    }
    /**  
    public void testInfinityDoubleOnUnsignedLongThrows() {  
        assertNotNull("TimestampString value must not be null", ts);
        RexNode operand1 = call.getOperands().get(1);
        // 4503599627370495.5 has exact double representation (below 2^52 boundary)
    }
        // RangeQueryBuilder.timeZone() calls ZoneId.of() which throws for invalid zones,
     */
        assertTrue(result instanceof RexCall);
        assertTrue(result instanceof RexCall);  
     */  
    /**
        RexCall call = (RexCall) result;
    public void testIpRangeBothBounds() throws ConversionException {  
    /**  
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Infinity")
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
        }  
            () -> translator.convert(QueryBuilders.rangeQuery("scaled_price").gt(1e18), ctx)  
        // End of 2022-12-31 = 1672531199999L
        assertEquals(1, ((RexInputRef) lowerBound.getOperands().get(0)).getIndex());  
    public void testLte() throws ConversionException {
        // Decimal-adjust: truncate -> 4503599627370495, positive -> increment -> >= 4503599627370496
        assertNotNull(literal);  
        RexCall call = (RexCall) result;
        assertEquals(Double.valueOf(99.5), literal.getValueAs(Double.class));
        RexCall call = (RexCall) comparison;
        // Value that overflows Long when scaled: 1e18 * 10 > Long.MAX_VALUE  
    // ========== GROUP A - VALUE CORRECTNESS ==========  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(100), ctx);
    /**  
            ConversionException.class,  
        );
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
        assertEquals(Long.valueOf(106L), extractLiteralLong(call.getOperands().get(1)));  
    /** lte 200 on TINYINT (max=127) -> no constraint (upper bound above max is unbounded). */
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, lower.getKind());  
     */
        assertEquals(SqlKind.AND, call.getKind());  
    }  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lt(-2147483648.5), ctx);
        assertTrue(result instanceof RexCall);  
        org.apache.calcite.util.TimestampString ts = literal.getValueAs(org.apache.calcite.util.TimestampString.class);
     * Bound "2026-07-28T00:00:00.123456789" on event_nanos (precision 9) must produce a literal
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
     */  
        assertTrue(  
    }  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("now-1d/d"), ctx);
    // ========== GROUP H - DECIMAL BOUNDS ON INTEGER FIELDS ==========
     * silently drop the relation parameter for scalar fields — the built query is identical
    }
        assertLiteralNumber(result, Long.valueOf(4503599627370496L), null);
        assertEquals(5, ((RexInputRef) lower.getOperands().get(0)).getIndex());
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").lt(100), ctx);  
    public void testIpRangeInvalidIpThrows() {
        );
        // gte "100" (string) on unsigned_long: whole number within Long range -> GTE 100  
    }
    /**
    }
            ConversionException.class,  
    public void testLtDecimalOnIntegerFieldNegative() throws ConversionException {  
        // When the only bound returns null, translator produces IS_NOT_NULL (exists semantics)
        String gteStr = gteTs.toString();  
        // gte "1.5" (string) with factor 10 -> Math.round(1.5 * 10) = 15, inclusive, GTE
        RexCall call = (RexCall) result;  
        RexLiteral literal = unwrapLiteral(call.getOperands().get(1));
        assertTrue(result instanceof RexCall);
        assertEquals(2, call.getOperands().size());
            "Message should mention non-finite or NaN: " + ex.getMessage(),
        // No bounds → IS_NOT_NULL (exists semantics), same as other types.
import org.opensearch.dsl.converter.ConversionException;  
     * gt 10.5 on INTEGER field produces gte 11. Per NumberFieldMapper INTEGER.rangeQuery: positive decimal lower bound increments.
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());  
        expectThrows(
            "Message should name the rejected value and the coercion failure: " + ex.getMessage(),  
        RexCall lowerBound = (RexCall) call.getOperands().get(0);
        assertTrue(result instanceof RexCall);
        );
     * and DateFieldType.rangeQuery() reject DISJOINT with IllegalArgumentException. However,
        );  
        assertTrue(result instanceof RexCall);
        RexCall call = (RexCall) result;
    public void testBothBoundsScaledFloatProducesAnd() throws ConversionException {
        );
        RexCall lowerBound = (RexCall) call.getOperands().get(0);  
    public void testIpRangeHostnameLocalhostThrows() {  
        // lte -5 on unsigned_long: negative upper → match-none.
        assertEquals((byte) 0xff, bytes[11]);
                || ex.getMessage().contains("overflow")
        assertTrue(result instanceof RexCall);  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
    }
     */  
        assertTrue(result instanceof RexCall);  
     * Upper bound rounding on date_nanos: lte "2026-07-28" rounds UP to end-of-day at nano
        assertTrue(ex.getMessage().contains("Infinity") || ex.getMessage().contains("non-finite"));  
        ConversionException ex = expectThrows(
    public void testBooleanRangeLtFalse() throws ConversionException {
        assertEquals(SqlKind.GREATER_THAN, call.getKind());  
        ConversionException ex = expectThrows(
    }
        assertEquals(2, call.getOperands().size());  
        assertTrue(ex.getMessage().contains("overflows"));
    public void testGteNumericLiteralValue() throws ConversionException {  
        );
        assertTrue("Unmapped field should produce literal false", result instanceof RexLiteral);
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);
        assertEquals(SqlKind.IS_NOT_NULL, call.getKind());  
        RexCall call = (RexCall) result;
    }
import org.apache.calcite.rex.RexNode;
    /** gte -200 on TINYINT (min=-128) -> no constraint (lower below min is unbounded). */
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").gte(10.55), ctx);
        assertEquals(2, call.getOperands().size());
    public void testGtDecimalAtLongMaxMatchesNone() throws ConversionException {  
            "Message should mention non-finite: " + ex.getMessage(),  
                return unwrapLiteral(call.getOperands().get(0));
        // Decimal-adjust: truncate -> -4503599627370495, negative upper -> decrement -> <= -4503599627370496
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
     * gt 10.0 (whole double) on integer field uses exclusive > 10 without adjustment.
    public void testEpochMillisInvalidValueThrows() {  
        assertTrue(result instanceof RexCall);  
    }
        assertEquals(Boolean.TRUE, upperLit.getValueAs(Boolean.class));  
        // With only a lower bound that is negative → null returned from translateBound → no conditions → IS_NOT_NULL
            ConversionException.class,
        assertTrue(result instanceof RexCall);
        // gt "2026-07-28" -> roundUp=true -> end of day = .999999999  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").gte(100L), ctx);
        // Must NOT be mistyped as TIMESTAMP — DECIMAL/INTEGER/BIGINT are all acceptable  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("timestamp").gt(4503599627370495.5), ctx);  
    }
     * Legacy IpFieldMapper.rangeQuery uses InetAddress-order (16-byte IPv6-mapped encoding).  
    public void testRangeOnIpFieldProducesByteComparison() throws ConversionException {
        assertTrue(  
     */  
     */
     */
        RexCall call = (RexCall) result;
        assertTrue("Non-finite on DOUBLE should produce a RexCall, not throw", result instanceof RexCall);  
        RexLiteral literal = unwrapLiteral(operand1);  
    }  
        assertEquals(Long.valueOf(15L), extractLiteralLong(call.getOperands().get(1)));
    /**  
     * Validation is via the literal's TimestampString which preserves all 9 fractional digits,  
        );
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Infinity")
        fail("Expected RexLiteral or CAST(RexLiteral), got: " + node.getClass().getSimpleName() + " = " + node);
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());
        );  
        RexCall upper = (RexCall) call.getOperands().get(1);
     */  
     * not passed to DNS resolution.  
    /**  
    public void testGteStringDecimalOnScaledFloat() throws ConversionException {  
            ConversionException.class,
        assertTrue("gt should be end of 2026-07-28 with .999999999: " + gtStr, gtStr.contains("23:59:59.999999999"));
     */
        RexInputRef lowerRef = (RexInputRef) lowerBound.getOperands().get(0);
     */
            () -> translator.convert(QueryBuilders.rangeQuery("price").gte("Infinity"), ctx)
    }
     */
        byte[] bytes = bs.getBytes();  
    /**  
        // Values above Long.MAX_VALUE are not representable due to schema_coerce.rs UInt64→Int64 narrowing.  
import org.opensearch.dsl.converter.ConversionContext;
    public void testWithTimeZone() throws ConversionException {  
    }
        assertTrue(result instanceof RexCall);
        assertTrue(result instanceof RexCall);  
    public void testThrowsForQueryName() {  
     * DateFieldMapper.dateRangeQuery, DateMathParser rounds to end-of-month.
     * silently drop the relation parameter for scalar fields — the built query is identical
        // lte 10.5 with factor 10 -> 105, inclusive, LTE
    }
        assertNotNull("IP literal should be ByteString", bs);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").lt("2022-01-01"), ctx);
        // Field ref at index 11 (ip_address)  
        org.apache.calcite.util.TimestampString ts = literal.getValueAs(org.apache.calcite.util.TimestampString.class);
     * gte uses roundUp=false (inclusive lower), producing start-of-day nanos.  
     * lte("31/12/2022") with format("dd/MM/yyyy") rounds up to end-of-day.
        ConversionException ex = expectThrows(
    public void testPositiveInfinityDoubleOnBigintThrows() {
    /**
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);  
            () -> translator.convert(QueryBuilders.rangeQuery("timestamp").gte(Double.NaN), ctx)
    /** Pre-1970 date on millisecond field produces a negative epoch-millis literal (1969-07-20 = -14256000000). */
        assertEquals("price", ctx.getRowType().getFieldList().get(1).getName());
        assertEquals((byte) 0x01, bytes[15]);  
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;
    /** Positive Infinity as raw Double on INTEGER must throw ConversionException. */  
            ConversionException.class,  
    // ========== GROUP K - DOCUMENTATION TESTS ==========
    }
    }
    private static Long extractLiteralLong(RexNode node) {
    public void testDateNanosUpperBoundRoundsToNanos() throws ConversionException {
    public void testNaNDoubleOnScaledFloatThrows() {
        RexNode operand1 = call.getOperands().get(1);
     */
    private final RangeQueryTranslator translator = new RangeQueryTranslator();
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price"), ctx);
     * Long value on numeric field produces numeric literal, not TIMESTAMP(3).
    public void testRangeOnDateNanosFieldSucceeds() throws ConversionException {
        // RangeQueryBuilder.relation("DISJOINT") throws IllegalArgumentException because
            ex.getMessage().contains("out of range")  
    }
        assertEquals(Boolean.TRUE, lit.getValueAs(Boolean.class));
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("Infinity")  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gt(100), ctx);
        assertEquals(SqlKind.LESS_THAN, call.getKind());
        );  
        org.apache.calcite.util.TimestampString gteTs = gteLiteral.getValueAs(org.apache.calcite.util.TimestampString.class);
    /** Infinity on DOUBLE field must NOT throw -- legacy accepts non-finite doubles. */  
    }
        assertLiteralNumber(result, Integer.valueOf(11), null);
        assertLiteralNumber(result, Integer.valueOf(-10), null);  
        assertTrue(result instanceof RexCall);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("scaled_price").lte(10.5), ctx);  
    public void testLtNegativeUpperOnUnsignedLong() throws ConversionException {
    public void testRegressionPlainDateFieldStillUsesMillis() throws ConversionException {
    }  
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("brand").gte("apple").lte("dell"), ctx);
     */
        assertEquals(2, call.getOperands().size());
            ex.getMessage().contains("non-finite") || ex.getMessage().contains("NaN")
        RexNode withoutRelation = translator.convert(QueryBuilders.rangeQuery("price").gte(100), ctx);  
        RexCall lower = (RexCall) call.getOperands().get(0);  
        assertTrue(result instanceof RexCall);  
        // The value must be clamped to MAX_NANOSECOND_INSTANT  
    }
        assertTrue(  
    /** "NaN" as String on BIGINT must throw ConversionException. */  
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
 * The OpenSearch Contributors require contributions made to  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_nanos").gte("2026-07-28T00:00:00.123456789"), ctx);
    /**
        ConversionException ex = expectThrows(
        assertNotNull("TimestampString must not be null", ts);
    /** Raw long value on date field produces timestamp literal at the given epoch millis. */
        // IS_NOT_NULL (exists semantics) since the lower condition is omitted.  
    public void testThrowsForBoost() {  
    /** BUG 1 proof: NaN as raw Double on INTEGER silently produces bound of 0 instead of throwing. */  
    // ========== UNSIGNED_LONG RANGE TESTS ==========
        assertEquals(SqlTypeName.CHAR, upperLit.getTypeName());  
        assertEquals(3, ((RexInputRef) call.getOperands().get(0)).getIndex());
        assertTrue(  
                || ex.getMessage().contains("numeric")
        assertEquals(SqlKind.LESS_THAN, call.getKind());  
        // lt 100 (whole, exclusive) → -1 = 99, LTE
        RexNode result = translator.convert(
            assertEquals("Type mismatch", expectedType, literal.getTypeName());
    }  
import org.opensearch.test.OpenSearchTestCase;  
     * regardless of INTERSECTS, CONTAINS, or WITHIN.
    }  
        assertEquals(12, ((RexInputRef) call.getOperands().get(0)).getIndex());  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte(99.5), ctx);  
     * and the literal's type which must be TIMESTAMP(9).
        assertEquals(  
        assertLiteralEpoch(result, 1654041600000L);
        ConversionException ex = expectThrows(
        assertLiteralNumber(result, Integer.valueOf(11), null);  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("tiny_val").gte(127), ctx);  
    }
        );  
        ConversionException ex = expectThrows(
    public void testLteDecimalOnIntegerFieldNegative() throws ConversionException {  
        RexCall call = (RexCall) result;  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_nanos").gte("2300-01-01"), ctx);  
     */
    /** gte 40000 on SMALLINT (max=32767) -> match-none. */
    public void testGteStringWholeNumberOnUnsignedLong() throws ConversionException {
            ex.getMessage().contains("out of range") || ex.getMessage().contains("overflow")  
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.rangeQuery("ip_address").gte("evil.example"), ctx));  
        assertTrue("Expected literal false (match-none)", result instanceof RexLiteral);  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        String gtStr = gtTs.toString();  
     */
        assertEquals(SqlKind.LESS_THAN_OR_EQUAL, call.getKind());  
        assertEquals("Value should be 100", Long.valueOf(100L), literal.getValueAs(Long.class));
    public void testPositiveInfinityDoubleOnIntegerThrows() {
    /** "Infinity" as String on BIGINT must throw ConversionException. */  
        RexNode result = translator.convert(
        RexNode result = translator.convert(QueryBuilders.rangeQuery("event_time").gte("01/01/2022").format("dd/MM/yyyy"), ctx);  
        RexNode result = translator.convert(QueryBuilders.rangeQuery("unsigned_counter").gte(100), ctx);
    }
    public void testInvalidTimeZoneThrows() {
 */  
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());  
        assertEquals((byte) 168, bytes[13]);
        RexNode result = translator.convert(QueryBuilders.rangeQuery("price").lte(10.5), ctx);
        assertLiteralNumber(result, Integer.valueOf(10), null);
    }
        RexNode result = translator.convert(QueryBuilders.rangeQuery("rating").gte("01/01/2022").format("dd/MM/yyyy").timeZone("UTC"), ctx);
        RexCall call = (RexCall) result;
    }
        assertEquals(2, call.getOperands().size());
        RexCall call = (RexCall) result;
    }
            ex.getMessage().contains("out of range") || ex.getMessage().contains("overflow")  
        ConversionException ex = expectThrows(  
        RexCall upperBound = (RexCall) call.getOperands().get(1);
        assertTrue(result instanceof RexCall);
    }
    /** Regression: NaN on scaled_float still throws (existing guard). */
    public void testDoubleValueOnNumericField() throws ConversionException {
    /** NaN string bound on scaled_float must throw ConversionException, not silently produce 0. */  
        RexCall call = (RexCall) result;
    }
        );
     * Uses a value within double's exact-integer range where the fractional part is preserved.
            "Message should mention non-finite or Infinity: " + ex.getMessage(),
     */
        RexCall call = (RexCall) result;
     * gt "2022-01-01||/M" on date field: exclusive lower bound -> roundUp=true per  
    public void testNegativeInfinityDoubleOnDoubleFieldAccepted() throws ConversionException {
    /**
        assertEquals(SqlKind.GREATER_THAN_OR_EQUAL, call.getKind());
        assertEquals(2, call.getOperands().size());
    /** Infinity as raw Double on unsigned_long must throw ConversionException. */
        assertEquals(2, call.getOperands().size());  
        assertTrue(  
    /** gte(false) AND lte(true) selects both values; vanilla returns an existsQuery equivalent. */  
        assertEquals(3, literal.getType().getPrecision());

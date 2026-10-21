import org.apache.calcite.sql.SqlKind;
            ConversionException.class,
    }
        );
    }
import org.opensearch.test.OpenSearchTestCase;
                QueryBuilders.termsQuery("created_date", new Object[] { new Date(1704067200000L), new Date(1706745600000L) }),
        Long val1 = (lit1 instanceof RexLiteral l)
        TermsLookup termsLookup = new TermsLookup("lookup_index", "1", "terms");
    }
import org.apache.calcite.rex.RexLiteral;
        RexNode lit0 = eq0.getOperands().get(1);
    }
            () -> translator.convert(QueryBuilders.termsQuery("scaled_price", new Object[] { Double.NaN }), ctx)
        RexNode result = translator.convert(QueryBuilders.termsQuery("status", new Object[] { "active", "pending" }), ctx);
        RexCall call = (RexCall) result;
    public void testScaledFloatTermsQuery() throws ConversionException {
        assertTrue(result instanceof RexCall);
    private final ConversionContext ctx = TestUtils.createContext();
    // TODO: Enable when date type support is added — legacy DateFieldMapper.DateFieldType.termQuery
            ConversionException.class,
        RexCall eq1 = (RexCall) call.getOperands().get(1);
    }
        RexNode result = translator.convert(QueryBuilders.termsQuery("unsigned_counter", new Object[] { 2.5 }), ctx);
            ConversionException.class,
        // terms scaled_price = [10.5, 20.3] with factor 10 -> [105, 203]
        );
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
            () -> translator.convert(
        assertEquals(2, call.getOperands().size());
        assertEquals(SqlKind.EQUALS, call.getKind());
        expectThrows(IllegalArgumentException.class, () -> translator.convert(QueryBuilders.termsQuery("name", (Object[]) null), ctx));
        RexNode result = translator.convert(QueryBuilders.termsQuery("scaled_price", new Object[] { 10.5, 20.3 }), ctx);
        ConversionException ex = expectThrows(
        RexInputRef fieldRef = (RexInputRef) firstEquals.getOperands().get(0);
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.termsQuery("nonexistent", "value"), ctx));
import org.apache.calcite.rex.RexNode;
        RexCall call = (RexCall) result;
    public void testUnsignedLongTermsInRange() throws ConversionException {
        // OR expression has nested structure, get field from first operand
 * compatible open source license.
            () -> translator.convert(QueryBuilders.termsQuery("name", "laptop").valueType(TermsQueryBuilder.ValueType.BITMAP), ctx)
    }
 * this file be licensed under the Apache-2.0 license or a
        RexCall call = (RexCall) result;
    }
        RexCall firstEquals = (RexCall) call.getOperands().get(0);
    // divergence until parity-verified date term support is implemented.
            ? l.getValueAs(Long.class)
        assertEquals(SqlKind.OR, call.getKind());
            () -> translator.convert(QueryBuilders.termsQuery("scaled_price", new Object[] { "NaN" }), ctx)
    // (line 505) supports term on date by delegating to rangeQuery; our rejection is a known
        assertEquals(Long.valueOf(203L), val1);
        RexNode lit1 = eq1.getOperands().get(1);
    }
    public void testScaledFloatTermsInfinityThrows() {
import org.apache.calcite.rex.RexCall;
 *
        assertEquals(SqlKind.EQUALS, eq1.getKind());
    }
        RexCall call = (RexCall) result;
            () -> translator.convert(QueryBuilders.termsQuery("scaled_price", new Object[] { "Infinity" }), ctx)
        assertTrue(ex.getMessage().contains("not yet supported"));
import org.opensearch.index.query.TermsQueryBuilder;
    public void testResolvesCorrectFieldIndex() throws ConversionException {
        assertTrue(ex.getMessage().contains("NaN") || ex.getMessage().contains("non-finite"));
        );
/*
    public void testThrowsForBoost() {
import org.opensearch.dsl.TestUtils;
    public void testScaledFloatTermsNaNThrows() {
    // TODO: Enable when binary type support is added — legacy BinaryFieldMapper.BinaryFieldType.termQuery
        expectThrows(
        expectThrows(
        RexNode result = translator.convert(QueryBuilders.termsQuery("brand", "brandX", "brandY"), ctx);
        assertEquals(SqlKind.EQUALS, eq0.getKind());
    }
    // Supported types: VARCHAR, INTEGER, DOUBLE, BOOLEAN, BIGINT
        RexNode lit = call.getOperands().get(1);
    public void testDateType() {
                QueryBuilders.termsQuery("binary_data", new Object[] { "U29tZSBiaW5hcnkgYmxvYg==", "QW5vdGhlciBibG9i" }),
        );
    }
                ctx
        assertTrue(ex.getMessage().contains("does not support term queries"));
    public void testThrowsForValueType() {
    public void testThrowsForEmptyValues() {
        RexCall eq0 = (RexCall) call.getOperands().get(0);
    }
        RexCall call = (RexCall) result;
        RexCall eq0 = (RexCall) call.getOperands().get(0);
    public void testIntegerValues() throws ConversionException {
        ConversionException ex = expectThrows(
            ConversionException.class,
    public void testMultipleStringValuesUsesSearch() throws ConversionException {
    public void testBooleanType() throws ConversionException {
    // ========== UNSIGNED_LONG TERMS TESTS ==========
        RexCall call = (RexCall) result;
    }
        assertEquals(Long.valueOf(105L), val0);
    // (line 172) throws QueryShardException("Binary fields do not support searching");
        ConversionException ex = expectThrows(
        RexNode result = translator.convert(QueryBuilders.termsQuery("name", "laptop"), ctx);
        assertEquals(SqlKind.OR, call.getKind());
    }
        // All values negative → match-none (literal false)
    public void testUnsignedLongTermsAboveLongMaxThrows() {
            () -> translator.convert(QueryBuilders.termsQuery("unsigned_counter", new Object[] { "9223372036854775808" }), ctx)
        Long val = (lit instanceof RexLiteral l)
 */
        assertEquals(2, fieldRef.getIndex());
        assertEquals(SqlKind.OR, call.getKind());
            () -> translator.convert(
        );
            ? l.getValueAs(Long.class)
            )
            : ((RexLiteral) ((RexCall) lit0).getOperands().get(0)).getValueAs(Long.class);
        ConversionException ex = expectThrows(
        RexNode result = translator.convert(QueryBuilders.termsQuery("unsigned_counter", new Object[] { 2.5, 100 }), ctx);
        );
        // terms [2.5] on unsigned_long → all have decimal → match-none
        // terms unsigned_counter = [100, 200] → IN(100, 200)
    }
    public void testKeywordType() throws ConversionException {
        RexCall call = (RexCall) result;
    private final TermsQueryTranslator translator = new TermsQueryTranslator();
    public void testUnsignedLongTermsAllNegativeMatchNone() throws ConversionException {
        assertEquals(SqlKind.OR, call.getKind());
        assertEquals(SqlKind.OR, call.getKind());
        assertTrue("Expected literal false (match-none) for decimal-only terms", result instanceof RexLiteral);
        assertTrue(ex.getMessage().contains("not representable"));
        assertEquals(Long.valueOf(100L), val);
        );
}
    public void testGeoPointType() {
    public void testLongType() throws ConversionException {
import org.opensearch.index.query.QueryBuilders;
        RexNode result = translator.convert(QueryBuilders.termsQuery("is_active", new Object[] { true, false }), ctx);
        );
import org.opensearch.dsl.converter.ConversionException;
        RexNode result = translator.convert(QueryBuilders.termsQuery("timestamp", new Object[] { 1234567890L, 9876543210L }), ctx);
    // ========== FIX 3: NaN/Infinity on scaled_float terms must throw ==========
        Long val0 = (lit0 instanceof RexLiteral l)
        Long val0 = (lit0 instanceof RexLiteral l)
            : ((RexLiteral) ((RexCall) lit1).getOperands().get(0)).getValueAs(Long.class);
import org.opensearch.indices.TermsLookup;
        assertEquals(SqlKind.OR, call.getKind());
    }
        expectThrows(
import java.util.Date;
            () -> translator.convert(QueryBuilders.termsQuery("name", "laptop").queryName("my_query"), ctx)
        // Should produce equality on 100 only (single value = EQUALS, not OR)
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
            ConversionException.class,
            () -> translator.convert(QueryBuilders.termsQuery("location", new Object[] { "40.7128,-74.0060", "34.0522,-118.2437" }), ctx)
            )
        RexNode result = translator.convert(QueryBuilders.termsQuery("rating", new Object[] { 4.5, 4.8, 5.0 }), ctx);
            ConversionException.class,
        RexCall call = (RexCall) result;
        assertEquals(1, fieldRef.getIndex());
import org.opensearch.dsl.converter.ConversionContext;
        ConversionException ex = expectThrows(
    }
    public void testBinaryType() {
        ConversionException ex = expectThrows(
            : ((RexLiteral) ((RexCall) lit).getOperands().get(0)).getValueAs(Long.class);
    // ========== FIX 5: decimal on unsigned_long terms skips decimal values ==========
    public void testThrowsForQueryName() {
    public void testDoubleValuesUsesSearch() throws ConversionException {
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.termsLookupQuery("name", termsLookup), ctx));
        );
import org.apache.calcite.rex.RexInputRef;
        assertTrue(ex.getMessage().contains("NaN") || ex.getMessage().contains("non-finite"));
        RexNode result = translator.convert(QueryBuilders.termsQuery("price", new Object[] { 1200, 1500 }), ctx);
        assertTrue(ex.getMessage().contains("Infinity") || ex.getMessage().contains("non-finite"));
        assertTrue("Expected literal false", result instanceof RexLiteral);
    // Date type still throws ClassCastException from Calcite's RexBuilder.makeLiteral()
            : ((RexLiteral) ((RexCall) lit0).getOperands().get(0)).getValueAs(Long.class);
    public void testSingleValueUsesEquals() throws ConversionException {
    }
public class TermsQueryTranslatorTests extends OpenSearchTestCase {
        RexCall firstEquals = (RexCall) call.getOperands().get(0);
 * The OpenSearch Contributors require contributions made to
            IllegalArgumentException.class,
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.termsQuery("name", "laptop").boost(2.0f), ctx));
            ? l.getValueAs(Long.class)
        RexCall call = (RexCall) result;
    public void testUnsignedLongTermsDecimalOnlyMatchNone() throws ConversionException {
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(SqlKind.OR, call.getKind());
            ? l.getValueAs(Long.class)
    public void testReportsCorrectQueryType() {
        RexCall call = (RexCall) result;
        assertEquals(TermsQueryBuilder.class, translator.getQueryType());
    }
        RexNode lit0 = eq0.getOperands().get(1);
    }
            ConversionException.class,
    public void testThrowsForUnknownField() {
    public void testThrowsForTermsLookup() {
    }
    }
    public void testScaledFloatTermsDoubleNaNThrows() {
            ConversionException.class,
        assertEquals(SqlKind.OR, call.getKind());
    public void testUnsignedLongTermsMixedDecimalAndWholeKeepsOnlyWhole() throws ConversionException {
        assertEquals(SqlKind.EQUALS, call.getKind());
    }
package org.opensearch.dsl.query;
        assertEquals(SqlKind.EQUALS, eq0.getKind());
    }
        // OR expression has nested structure, get field from first operand
                ctx
        RexNode result = translator.convert(QueryBuilders.termsQuery("name", "laptop", "phone"), ctx);
    }
        assertTrue(result instanceof RexCall);
    // ConversionException now MATCHES legacy rejection behaviour.
        RexNode result = translator.convert(QueryBuilders.termsQuery("unsigned_counter", new Object[] { -1, -5 }), ctx);
        assertEquals(SqlKind.OR, call.getKind());
        assertEquals(Long.valueOf(100L), val0);
    }
    }
        RexNode result = translator.convert(QueryBuilders.termsQuery("unsigned_counter", new Object[] { 100, 200 }), ctx);
        RexCall call = (RexCall) result;
        RexInputRef fieldRef = (RexInputRef) firstEquals.getOperands().get(0);
        // terms [2.5, 100] on unsigned_long → skip 2.5, keep 100

        // makeLiteral wraps nullable BIGINT in a CAST
            ConversionException.class,
        // makeLiteral wraps nullable VARCHAR in a CAST, so unwrap to get the inner literal
        ConversionException ex = expectThrows(
    }
            RexCall cast = (RexCall) literalNode;
    public void testResolvesCorrectFieldIndex() throws ConversionException {
            literalValue = ((RexLiteral) cast.getOperands().get(0)).getValueAs(Long.class);
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
        );
        RexNode result = translator.convert(QueryBuilders.termQuery("scaled_price", 10.5), ctx);
    public void testScaledFloatTermQueryNonNumericThrows() {
            () -> translator.convert(QueryBuilders.termQuery("scaled_price", "Infinity"), ctx)
    }
        RexCall call = (RexCall) result;
    public void testScaledFloatTermNaNThrows() {
        RexCall call = (RexCall) result;
        );
        RexNode result = translator.convert(QueryBuilders.termQuery("brand", "brandX"), ctx);
 */
        assertEquals(0, ((RexInputRef) call.getOperands().get(0)).getIndex());
package org.opensearch.dsl.query;
    private final ConversionContext ctx = TestUtils.createContext();
            () -> translator.convert(QueryBuilders.termQuery("scaled_price", "NaN"), ctx)
    public void testScaledFloatTermInfinityThrows() {
    }
            RexCall cast = (RexCall) literalNode;
        // parity would replace a loud crash with a possibly silently-wrong answer.
    public void testIntegerValue() throws ConversionException {
    // ========== UNSIGNED_LONG TERM TESTS ==========
    }
        // term unsigned_counter = 100 → literal 100, EQUALS
    }
        } else {
        // term -5 on unsigned_long → match-none (literal false)
    }
        assertEquals(2, fieldRef.getIndex());
            () -> translator.convert(QueryBuilders.termQuery("scaled_price", Double.POSITIVE_INFINITY), ctx)
            literalValue = lit.getValueAs(Long.class);
            ConversionException.class,
import org.apache.calcite.rex.RexCall;
        RexCall call = (RexCall) result;
            ConversionException.class,
            literalValue = lit.getValueAs(Long.class);
        );
        ConversionException ex = expectThrows(
        ConversionException ex = expectThrows(
        // term above Long.MAX_VALUE → ConversionException
        assertEquals(13, ((RexInputRef) call.getOperands().get(0)).getIndex());
    public void testIpTermThrowsConversionException() {
        ConversionException ex = expectThrows(
        // Legacy DateFieldMapper.DateFieldType.termQuery (line 505) supports date terms by
        RexNode result = translator.convert(QueryBuilders.termQuery("unsigned_counter", "2.5"), ctx);
        // term 2.5 on unsigned_long → match-none (literal false), per legacy MatchNoDocsQuery
    // ========== IP FIELD TERM TEST ==========
    public void testUnsignedLongTermInRange() throws ConversionException {
        );
import org.apache.calcite.rex.RexLiteral;
        assertTrue(ex.getMessage().contains("NaN") || ex.getMessage().contains("non-finite"));
import org.opensearch.dsl.converter.ConversionException;
        // brand is the 3rd field (index 2) in TestUtils schema: name, price, brand, rating
    }
        Long literalValue;
        assertTrue(ex.getMessage().contains("Non-numeric"));
            () -> translator.convert(QueryBuilders.termQuery("ip_address", "192.168.1.1"), ctx)
        assertTrue(ex.getMessage().contains("Infinity") || ex.getMessage().contains("non-finite"));
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.termQuery("nonexistent", "value"), ctx));
        );
        assertTrue(ex.getMessage().contains("not yet supported"));
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.rex.RexNode;
        RexNode result = translator.convert(QueryBuilders.termQuery("price", 1200), ctx);
        // price is the 2nd field (index 1)
        assertTrue(ex.getMessage().contains("not representable"));
            () -> translator.convert(QueryBuilders.termQuery("scaled_price", "abc"), ctx)
    }
            literalValue = ((RexLiteral) cast.getOperands().get(0)).getValueAs(Long.class);
    public void testUnsignedLongTermNonNumericThrows() {
    }
            () -> translator.convert(QueryBuilders.termQuery("created_date", "2024-01-01"), ctx)
    public void testUnsignedLongTermDecimalMatchNone() throws ConversionException {
        assertTrue("Expected literal false (match-none) for decimal term on unsigned_long", result instanceof RexLiteral);
        assertEquals(1, ((RexInputRef) call.getOperands().get(0)).getIndex());
        // term "2.5" on unsigned_long → match-none
            () -> translator.convert(QueryBuilders.termQuery("scaled_price", Double.NaN), ctx)
    private final TermQueryTranslator translator = new TermQueryTranslator();
    public void testReportsCorrectQueryType() {
    }
    public void testUnsignedLongTermNegativeMatchNone() throws ConversionException {
        RexCall cast = (RexCall) call.getOperands().get(1);
        );
            ConversionException.class,
        ConversionException ex = expectThrows(
    }
    }
        assertTrue("Expected literal false (match-none)", result instanceof RexLiteral);
    public void testUnsignedLongTermDecimalStringMatchNone() throws ConversionException {
        // Legacy IpFieldMapper.termQuery supports IP terms, but implementing without verified
    // ========== FIX 4+5: decimal on unsigned_long term must match-none ==========
        if (literalNode instanceof RexLiteral lit) {
            ConversionException.class,
            ConversionException.class,
        assertEquals(Long.valueOf(105L), literalValue);
        ConversionException ex = expectThrows(
    public void testScaledFloatTermQuery() throws ConversionException {
        assertTrue(ex.getMessage().contains("Infinity") || ex.getMessage().contains("non-finite"));
        assertEquals(TermQueryBuilder.class, translator.getQueryType());
    public void testDateTermThrowsConversionException() {
        } else {
        );
        assertEquals(14, ((RexInputRef) call.getOperands().get(0)).getIndex());
        assertEquals(SqlKind.EQUALS, call.getKind());
        ConversionException ex = expectThrows(
 * SPDX-License-Identifier: Apache-2.0
    }
 * compatible open source license.
import org.opensearch.dsl.converter.ConversionContext;
        assertEquals("laptop", ((RexLiteral) cast.getOperands().get(0)).getValueAs(String.class));
            ConversionException.class,
    public void testUnsignedLongTermAboveLongMaxThrows() {
 * The OpenSearch Contributors require contributions made to
        }
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);
            () -> translator.convert(QueryBuilders.termQuery("unsigned_counter", "9223372036854775808"), ctx)
 *
            () -> translator.convert(QueryBuilders.termQuery("unsigned_counter", "abc"), ctx)
        // delegating to rangeQuery; our rejection is a known divergence until parity-verified
        RexNode result = translator.convert(QueryBuilders.termQuery("name", "laptop"), ctx);
        assertEquals(SqlKind.EQUALS, call.getKind());
        assertEquals(SqlKind.EQUALS, call.getKind());
        RexNode literalNode = call.getOperands().get(1);
        // term scaled_price = 10.5 with factor 10 -> Math.round(10.5 * 10) = 105
    public void testThrowsForUnknownField() {
        if (literalNode instanceof RexLiteral lit) {
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
        RexNode literalNode = call.getOperands().get(1);
    }
public class TermQueryTranslatorTests extends OpenSearchTestCase {
import org.opensearch.dsl.TestUtils;
        assertTrue(ex.getMessage().contains("not yet supported"));
        // name is the 1st field (index 0) in TestUtils schema: name, price, brand, rating
import org.apache.calcite.sql.SqlKind;
    // ========== FIX 2: NaN/Infinity on scaled_float term must throw ==========
/*
    public void testConvertsTermQueryToEquals() throws ConversionException {
            ConversionException.class,
        assertTrue(ex.getMessage().contains("Non-numeric"));
        );
        RexNode result = translator.convert(QueryBuilders.termQuery("unsigned_counter", -5), ctx);
    }
        ConversionException ex = expectThrows(
        Long literalValue;
        RexNode result = translator.convert(QueryBuilders.termQuery("unsigned_counter", 100), ctx);
    }
    public void testScaledFloatTermDoubleNaNThrows() {
import org.apache.calcite.rex.RexInputRef;
        assertTrue(ex.getMessage().contains("NaN") || ex.getMessage().contains("non-finite"));
        RexCall call = (RexCall) result;
        ConversionException ex = expectThrows(
        RexNode result = translator.convert(QueryBuilders.termQuery("unsigned_counter", 2.5), ctx);
import org.opensearch.index.query.TermQueryBuilder;
        assertEquals(Long.valueOf(100L), literalValue);
import org.opensearch.index.query.QueryBuilders;
        assertEquals(SqlKind.EQUALS, call.getKind());
        RexCall call = (RexCall) result;
    }
        assertTrue("Expected literal false (match-none) for decimal string term on unsigned_long", result instanceof RexLiteral);
}
            ConversionException.class,
        // date term support is implemented.
        );
    }
    // ========== DATE FIELD TERM TEST ==========
 * this file be licensed under the Apache-2.0 license or a
        }
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
    }
    public void testScaledFloatTermDoubleInfinityThrows() {

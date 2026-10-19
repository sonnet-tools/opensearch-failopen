    }
        // term 2.5 on unsigned_long → match-none (literal false), per legacy MatchNoDocsQuery  
        // Legacy DateFieldMapper.DateFieldType.termQuery (line 505) supports date terms by
    public void testUnsignedLongTermNonNumericThrows() {  
}
import org.opensearch.test.OpenSearchTestCase;
        ConversionException ex = expectThrows(
            () -> translator.convert(QueryBuilders.termQuery("scaled_price", "NaN"), ctx)  
        RexCall call = (RexCall) result;  
            () -> translator.convert(QueryBuilders.termQuery("scaled_price", Double.POSITIVE_INFINITY), ctx)
            () -> translator.convert(QueryBuilders.termQuery("scaled_price", "abc"), ctx)
            ConversionException.class,
            ConversionException.class,
        // brand is the 3rd field (index 2) in TestUtils schema: name, price, brand, rating
            RexCall cast = (RexCall) literalNode;
        RexNode result = translator.convert(QueryBuilders.termQuery("scaled_price", 10.5), ctx);
    public void testReportsCorrectQueryType() {
        RexNode result = translator.convert(QueryBuilders.termQuery("name", "laptop"), ctx);
        ConversionException ex = expectThrows(
    }
        RexNode result = translator.convert(QueryBuilders.termQuery("unsigned_counter", "2.5"), ctx);
        // delegating to rangeQuery; our rejection is a known divergence until parity-verified
    }
    }  
    }
        RexNode result = translator.convert(QueryBuilders.termQuery("unsigned_counter", -5), ctx);
        assertEquals(14, ((RexInputRef) call.getOperands().get(0)).getIndex());
    public void testUnsignedLongTermAboveLongMaxThrows() {
 */  
            () -> translator.convert(QueryBuilders.termQuery("created_date", "2024-01-01"), ctx)  
    }
        RexNode result = translator.convert(QueryBuilders.termQuery("unsigned_counter", 2.5), ctx);
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));  
    public void testUnsignedLongTermInRange() throws ConversionException {  
            () -> translator.convert(QueryBuilders.termQuery("scaled_price", "Infinity"), ctx)
    }  
        // makeLiteral wraps nullable BIGINT in a CAST
        ConversionException ex = expectThrows(
        assertTrue("Expected literal false (match-none) for decimal term on unsigned_long", result instanceof RexLiteral);
            RexCall cast = (RexCall) literalNode;
    }
        // term scaled_price = 10.5 with factor 10 -> Math.round(10.5 * 10) = 105  
        assertEquals(2, fieldRef.getIndex());  
        // Legacy IpFieldMapper.termQuery supports IP terms, but implementing without verified
            () -> translator.convert(QueryBuilders.termQuery("ip_address", "192.168.1.1"), ctx)
        );
import org.apache.calcite.sql.SqlKind;
        Long literalValue;
    public void testDateTermThrowsConversionException() {  
        assertEquals("laptop", ((RexLiteral) cast.getOperands().get(0)).getValueAs(String.class));  
 * compatible open source license.
        assertEquals(1, ((RexInputRef) call.getOperands().get(0)).getIndex());  
        ConversionException ex = expectThrows(  
        );  
    public void testIpTermThrowsConversionException() {  
import org.opensearch.dsl.converter.ConversionException;
    public void testUnsignedLongTermNegativeMatchNone() throws ConversionException {
    public void testScaledFloatTermDoubleInfinityThrows() {
    }
        assertTrue(ex.getMessage().contains("Non-numeric"));
        RexNode result = translator.convert(QueryBuilders.termQuery("brand", "brandX"), ctx);
    // ========== FIX 4+5: decimal on unsigned_long term must match-none ==========  
    }  
        } else {
        // term "2.5" on unsigned_long → match-none
        );
            ConversionException.class,
        assertEquals(0, ((RexInputRef) call.getOperands().get(0)).getIndex());  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rex.RexLiteral;  
        ConversionException ex = expectThrows(  
        );
public class TermQueryTranslatorTests extends OpenSearchTestCase {
        );  
import org.apache.calcite.rex.RexInputRef;
        );
        if (literalNode instanceof RexLiteral lit) {
            () -> translator.convert(QueryBuilders.termQuery("unsigned_counter", "abc"), ctx)  
            literalValue = lit.getValueAs(Long.class);  
        RexCall call = (RexCall) result;  
    private final TermQueryTranslator translator = new TermQueryTranslator();  
        } else {
        ConversionException ex = expectThrows(
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));  
        assertTrue(ex.getMessage().contains("not yet supported"));
        ConversionException ex = expectThrows(
    }
        assertEquals(SqlKind.EQUALS, call.getKind());
            ConversionException.class,
    public void testUnsignedLongTermDecimalStringMatchNone() throws ConversionException {  
    public void testThrowsForUnknownField() {  
        RexCall call = (RexCall) result;  
    public void testScaledFloatTermDoubleNaNThrows() {
 *
            () -> translator.convert(QueryBuilders.termQuery("scaled_price", Double.NaN), ctx)
        // term -5 on unsigned_long → match-none (literal false)  
    public void testScaledFloatTermQuery() throws ConversionException {
            literalValue = ((RexLiteral) cast.getOperands().get(0)).getValueAs(Long.class);  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(13, ((RexInputRef) call.getOperands().get(0)).getIndex());
            literalValue = ((RexLiteral) cast.getOperands().get(0)).getValueAs(Long.class);  
        }
    }  
    public void testResolvesCorrectFieldIndex() throws ConversionException {  
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.termQuery("nonexistent", "value"), ctx));
    // ========== UNSIGNED_LONG TERM TESTS ==========
    }  
            ConversionException.class,
        }
/*  
 * The OpenSearch Contributors require contributions made to  
        );
        assertTrue(ex.getMessage().contains("Infinity") || ex.getMessage().contains("non-finite"));  
import org.opensearch.index.query.QueryBuilders;  
        Long literalValue;
        assertTrue(ex.getMessage().contains("NaN") || ex.getMessage().contains("non-finite"));
    }
        // price is the 2nd field (index 1)
    public void testScaledFloatTermQueryNonNumericThrows() {
        // name is the 1st field (index 0) in TestUtils schema: name, price, brand, rating
        RexNode literalNode = call.getOperands().get(1);  
    public void testUnsignedLongTermDecimalMatchNone() throws ConversionException {
    }
import org.opensearch.dsl.TestUtils;  
    }
        // parity would replace a loud crash with a possibly silently-wrong answer.
        // date term support is implemented.  
        assertEquals(SqlKind.EQUALS, call.getKind());
        RexNode result = translator.convert(QueryBuilders.termQuery("price", 1200), ctx);
        RexNode literalNode = call.getOperands().get(1);  
import org.opensearch.dsl.converter.ConversionContext;
        assertEquals(SqlKind.EQUALS, call.getKind());  
        // makeLiteral wraps nullable VARCHAR in a CAST, so unwrap to get the inner literal
            ConversionException.class,  
        assertEquals(Long.valueOf(100L), literalValue);
import org.opensearch.index.query.TermQueryBuilder;
            ConversionException.class,
        assertTrue(ex.getMessage().contains("Infinity") || ex.getMessage().contains("non-finite"));  
            () -> translator.convert(QueryBuilders.termQuery("unsigned_counter", "9223372036854775808"), ctx)  
        RexNode result = translator.convert(QueryBuilders.termQuery("unsigned_counter", 100), ctx);
        );
        assertTrue(ex.getMessage().contains("NaN") || ex.getMessage().contains("non-finite"));
        assertTrue("Expected literal false (match-none)", result instanceof RexLiteral);
        RexCall cast = (RexCall) call.getOperands().get(1);
            ConversionException.class,  
        assertEquals(TermQueryBuilder.class, translator.getQueryType());
    }  
        if (literalNode instanceof RexLiteral lit) {
        RexCall call = (RexCall) result;
    public void testScaledFloatTermNaNThrows() {  
    public void testScaledFloatTermInfinityThrows() {
        assertTrue(ex.getMessage().contains("Non-numeric"));
        // term unsigned_counter = 100 → literal 100, EQUALS
        RexCall call = (RexCall) result;  
        assertEquals(SqlKind.EQUALS, call.getKind());
    public void testIntegerValue() throws ConversionException {  
        RexInputRef fieldRef = (RexInputRef) call.getOperands().get(0);
    private final ConversionContext ctx = TestUtils.createContext();
    }
    // ========== FIX 2: NaN/Infinity on scaled_float term must throw ==========
            ConversionException.class,
    // ========== DATE FIELD TERM TEST ==========
        assertTrue(ex.getMessage().contains("not yet supported"));
    }  
    public void testConvertsTermQueryToEquals() throws ConversionException {  
        assertTrue(ex.getMessage().contains("not representable"));
        );  
import org.apache.calcite.rex.RexNode;
        ConversionException ex = expectThrows(  
            literalValue = lit.getValueAs(Long.class);  
        assertTrue("Expected literal false (match-none) for decimal string term on unsigned_long", result instanceof RexLiteral);  
        ConversionException ex = expectThrows(
        assertEquals(Long.valueOf(105L), literalValue);
        // term above Long.MAX_VALUE → ConversionException  
import org.apache.calcite.rex.RexCall;
    // ========== IP FIELD TERM TEST ==========
package org.opensearch.dsl.query;

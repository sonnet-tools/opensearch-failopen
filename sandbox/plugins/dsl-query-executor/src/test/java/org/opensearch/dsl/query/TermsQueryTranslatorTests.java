import java.util.Date;
    public void testUnsignedLongTermsMixedDecimalAndWholeKeepsOnlyWhole() throws ConversionException {
    public void testBooleanType() throws ConversionException {
            IllegalArgumentException.class,  
            : ((RexLiteral) ((RexCall) lit0).getOperands().get(0)).getValueAs(Long.class);
            () -> translator.convert(QueryBuilders.termsQuery("scaled_price", new Object[] { "Infinity" }), ctx)
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
            () -> translator.convert(  
import org.apache.calcite.rex.RexInputRef;
    }
    // divergence until parity-verified date term support is implemented.
        ConversionException ex = expectThrows(
    public void testKeywordType() throws ConversionException {
}
            ? l.getValueAs(Long.class)
    public void testThrowsForValueType() {
        RexNode result = translator.convert(QueryBuilders.termsQuery("unsigned_counter", new Object[] { -1, -5 }), ctx);
        expectThrows(
        assertTrue(ex.getMessage().contains("NaN") || ex.getMessage().contains("non-finite"));  
        assertEquals(1, fieldRef.getIndex());  
        // All values negative → match-none (literal false)
        assertTrue(ex.getMessage().contains("NaN") || ex.getMessage().contains("non-finite"));
    public void testScaledFloatTermsDoubleNaNThrows() {  
        assertEquals(TermsQueryBuilder.class, translator.getQueryType());  
package org.opensearch.dsl.query;
        RexNode result = translator.convert(QueryBuilders.termsQuery("name", "laptop", "phone"), ctx);
        assertEquals(SqlKind.EQUALS, call.getKind());
    public void testThrowsForUnknownField() {
        assertEquals(SqlKind.OR, call.getKind());
    public void testThrowsForEmptyValues() {
        // terms [2.5] on unsigned_long → all have decimal → match-none
    }  
        );
    }
    }  
import org.apache.calcite.sql.SqlKind;
    public void testUnsignedLongTermsInRange() throws ConversionException {  
    }
        RexNode result = translator.convert(QueryBuilders.termsQuery("rating", new Object[] { 4.5, 4.8, 5.0 }), ctx);
    }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.termsQuery("nonexistent", "value"), ctx));
        RexNode lit1 = eq1.getOperands().get(1);  
            ? l.getValueAs(Long.class)
    }
            () -> translator.convert(  
    }
        RexCall call = (RexCall) result;
        assertTrue(ex.getMessage().contains("does not support term queries"));
    public void testGeoPointType() {
        assertEquals(Long.valueOf(100L), val0);  
        ConversionException ex = expectThrows(
                ctx
    }
    // ConversionException now MATCHES legacy rejection behaviour.
    public void testSingleValueUsesEquals() throws ConversionException {  
            () -> translator.convert(QueryBuilders.termsQuery("name", "laptop").queryName("my_query"), ctx)
            ConversionException.class,  
        assertEquals(Long.valueOf(105L), val0);
            () -> translator.convert(QueryBuilders.termsQuery("location", new Object[] { "40.7128,-74.0060", "34.0522,-118.2437" }), ctx)
/*  
            ConversionException.class,  
        RexNode result = translator.convert(QueryBuilders.termsQuery("unsigned_counter", new Object[] { 2.5, 100 }), ctx);
            () -> translator.convert(QueryBuilders.termsQuery("name", "laptop").valueType(TermsQueryBuilder.ValueType.BITMAP), ctx)
    }  
        assertEquals(SqlKind.OR, call.getKind());
import org.apache.calcite.rex.RexNode;
        // Should produce equality on 100 only (single value = EQUALS, not OR)
            ConversionException.class,
    }  
        assertEquals(SqlKind.OR, call.getKind());
            : ((RexLiteral) ((RexCall) lit0).getOperands().get(0)).getValueAs(Long.class);
    public void testBinaryType() {  
        RexNode result = translator.convert(QueryBuilders.termsQuery("brand", "brandX", "brandY"), ctx);  
        ConversionException ex = expectThrows(
        assertEquals(SqlKind.EQUALS, call.getKind());
        assertEquals(SqlKind.EQUALS, eq0.getKind());
    }
        ConversionException ex = expectThrows(
        RexCall eq1 = (RexCall) call.getOperands().get(1);
import org.opensearch.test.OpenSearchTestCase;  
            )  
    }  
import org.opensearch.index.query.TermsQueryBuilder;
            : ((RexLiteral) ((RexCall) lit1).getOperands().get(0)).getValueAs(Long.class);  
        RexCall call = (RexCall) result;  
        );
            : ((RexLiteral) ((RexCall) lit).getOperands().get(0)).getValueAs(Long.class);
        );
    public void testThrowsForBoost() {  
            ConversionException.class,  
            ? l.getValueAs(Long.class)  
 */  
            ConversionException.class,
            ? l.getValueAs(Long.class)
        Long val1 = (lit1 instanceof RexLiteral l)
            () -> translator.convert(QueryBuilders.termsQuery("scaled_price", new Object[] { Double.NaN }), ctx)  
    // ========== FIX 5: decimal on unsigned_long terms skips decimal values ==========
        RexNode lit0 = eq0.getOperands().get(1);
        assertTrue(result instanceof RexCall);  
    }  
    }
    }
    // ========== UNSIGNED_LONG TERMS TESTS ==========
        RexNode result = translator.convert(QueryBuilders.termsQuery("price", new Object[] { 1200, 1500 }), ctx);
        RexCall call = (RexCall) result;
        // OR expression has nested structure, get field from first operand  
        assertEquals(Long.valueOf(100L), val);  
    }  
        Long val0 = (lit0 instanceof RexLiteral l)  
        );
    private final ConversionContext ctx = TestUtils.createContext();
    public void testScaledFloatTermsNaNThrows() {
        assertTrue(result instanceof RexCall);  
        RexCall call = (RexCall) result;  
    }
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.termsLookupQuery("name", termsLookup), ctx));
        assertEquals(SqlKind.OR, call.getKind());  
    public void testResolvesCorrectFieldIndex() throws ConversionException {
        );
        RexNode result = translator.convert(QueryBuilders.termsQuery("unsigned_counter", new Object[] { 2.5 }), ctx);  
    // TODO: Enable when date type support is added — legacy DateFieldMapper.DateFieldType.termQuery  
        RexCall call = (RexCall) result;  
            ConversionException.class,
    // (line 505) supports term on date by delegating to rangeQuery; our rejection is a known
    public void testUnsignedLongTermsAllNegativeMatchNone() throws ConversionException {  
    // Supported types: VARCHAR, INTEGER, DOUBLE, BOOLEAN, BIGINT  
            ConversionException.class,  
import org.opensearch.indices.TermsLookup;
 * compatible open source license.
        TermsLookup termsLookup = new TermsLookup("lookup_index", "1", "terms");  
        RexCall call = (RexCall) result;
    public void testScaledFloatTermsInfinityThrows() {
        expectThrows(
        RexCall call = (RexCall) result;
                QueryBuilders.termsQuery("binary_data", new Object[] { "U29tZSBiaW5hcnkgYmxvYg==", "QW5vdGhlciBibG9i" }),
        RexInputRef fieldRef = (RexInputRef) firstEquals.getOperands().get(0);  
        assertEquals(SqlKind.OR, call.getKind());  
    }
        RexCall firstEquals = (RexCall) call.getOperands().get(0);
        RexCall call = (RexCall) result;
            () -> translator.convert(QueryBuilders.termsQuery("scaled_price", new Object[] { "NaN" }), ctx)
    // TODO: Enable when binary type support is added — legacy BinaryFieldMapper.BinaryFieldType.termQuery  
        RexCall call = (RexCall) result;  
        RexCall call = (RexCall) result;
    public void testThrowsForTermsLookup() {
    // ========== FIX 3: NaN/Infinity on scaled_float terms must throw ==========  
        RexNode result = translator.convert(QueryBuilders.termsQuery("timestamp", new Object[] { 1234567890L, 9876543210L }), ctx);
    }
 * SPDX-License-Identifier: Apache-2.0
    }  
public class TermsQueryTranslatorTests extends OpenSearchTestCase {
 *
        ConversionException ex = expectThrows(
import org.opensearch.index.query.QueryBuilders;  
        assertEquals(SqlKind.OR, call.getKind());  
        assertEquals(SqlKind.OR, call.getKind());  
    }
    public void testScaledFloatTermsQuery() throws ConversionException {
        assertEquals(SqlKind.OR, call.getKind());
        RexCall eq0 = (RexCall) call.getOperands().get(0);  
        expectThrows(ConversionException.class, () -> translator.convert(QueryBuilders.termsQuery("name", "laptop").boost(2.0f), ctx));
    }
                ctx
        assertTrue("Expected literal false", result instanceof RexLiteral);  
        assertEquals(SqlKind.EQUALS, eq0.getKind());  
        );
        // terms unsigned_counter = [100, 200] → IN(100, 200)
    // Date type still throws ClassCastException from Calcite's RexBuilder.makeLiteral()
        RexInputRef fieldRef = (RexInputRef) firstEquals.getOperands().get(0);
            ConversionException.class,
        assertTrue(ex.getMessage().contains("not yet supported"));
    public void testReportsCorrectQueryType() {
        RexNode result = translator.convert(QueryBuilders.termsQuery("scaled_price", new Object[] { 10.5, 20.3 }), ctx);
        ConversionException ex = expectThrows(  
    public void testThrowsForQueryName() {
import org.opensearch.dsl.converter.ConversionContext;
        assertEquals(2, fieldRef.getIndex());
        RexNode result = translator.convert(QueryBuilders.termsQuery("unsigned_counter", new Object[] { 100, 200 }), ctx);
        assertTrue(ex.getMessage().contains("not representable"));  
        assertTrue(ex.getMessage().contains("Infinity") || ex.getMessage().contains("non-finite"));
    public void testMultipleStringValuesUsesSearch() throws ConversionException {  
import org.apache.calcite.rex.RexCall;
        RexCall eq0 = (RexCall) call.getOperands().get(0);
        RexNode lit = call.getOperands().get(1);
import org.apache.calcite.rex.RexLiteral;  
        RexCall call = (RexCall) result;
            )  
                QueryBuilders.termsQuery("created_date", new Object[] { new Date(1704067200000L), new Date(1706745600000L) }),
        Long val0 = (lit0 instanceof RexLiteral l)
        RexNode lit0 = eq0.getOperands().get(1);
        expectThrows(IllegalArgumentException.class, () -> translator.convert(QueryBuilders.termsQuery("name", (Object[]) null), ctx));  
        RexCall firstEquals = (RexCall) call.getOperands().get(0);
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
    }  
    private final TermsQueryTranslator translator = new TermsQueryTranslator();  
        RexNode result = translator.convert(QueryBuilders.termsQuery("is_active", new Object[] { true, false }), ctx);  
        assertEquals(2, call.getOperands().size());  
    }
        );
        // terms scaled_price = [10.5, 20.3] with factor 10 -> [105, 203]  
        assertEquals(SqlKind.OR, call.getKind());
    public void testLongType() throws ConversionException {  
import org.opensearch.dsl.TestUtils;  
        );  
        Long val = (lit instanceof RexLiteral l)  
        // terms [2.5, 100] on unsigned_long → skip 2.5, keep 100  
            () -> translator.convert(QueryBuilders.termsQuery("unsigned_counter", new Object[] { "9223372036854775808" }), ctx)
        assertEquals(SqlKind.EQUALS, eq1.getKind());
    }
        expectThrows(
    // (line 172) throws QueryShardException("Binary fields do not support searching");
    public void testUnsignedLongTermsDecimalOnlyMatchNone() throws ConversionException {
    public void testDoubleValuesUsesSearch() throws ConversionException {  
    public void testDateType() {  
        RexNode result = translator.convert(QueryBuilders.termsQuery("name", "laptop"), ctx);
        // OR expression has nested structure, get field from first operand
        assertEquals(Long.valueOf(203L), val1);
import org.opensearch.dsl.converter.ConversionException;
    }
        RexNode result = translator.convert(QueryBuilders.termsQuery("status", new Object[] { "active", "pending" }), ctx);  
    public void testIntegerValues() throws ConversionException {
        assertTrue("Expected literal false (match-none) for decimal-only terms", result instanceof RexLiteral);
    public void testUnsignedLongTermsAboveLongMaxThrows() {
        );

        RexLiteral queryKey = (RexLiteral) queryMap.getOperands().get(0);  
     * rather than our old LOWER() wrapping.  
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2, call.getOperands().size());  
     * param operand — the translator only emits the param when true.  
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "l*").caseInsensitive(false), ctx);  
        String pattern = "test\\*file\\?name\\\\end";
        assertEquals("Wildcard query parameter '_name' is not supported", ex.getMessage());  
     * Behaviour-pinning test: a leading-wildcard pattern is emitted verbatim — no rewriting or rejection.  
     * is emitted verbatim — documents that case folding is now Lucene's ASCII-only behaviour
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", pattern), ctx);
        RexCall call = (RexCall) result;
    public void testUnicodePatternWithSharpSEmittedVerbatim() throws ConversionException {
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "*checkout"), ctx);  
    }
    // ── Behaviour-pinning: leading wildcard emitted verbatim (M3) ───────────────  
    }  
    public void testEmitsWildcardQueryDslRexCall() throws ConversionException {
     */
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", ""), ctx);  
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
    public void testEmptyPatternPassedVerbatim() throws ConversionException {
        RexCall call = (RexCall) result;
            () -> translator.convert(QueryBuilders.wildcardQuery("name", "lap*").queryName("my_wildcard"), ctx)
    public void testWildcardThrowsForBoostParameter() {
        assertEquals(3, call.getOperands().size());
            ConversionException.class,  
        assertEquals(SqlKind.OTHER_FUNCTION, call.getKind());
    }
     */
    // ── Rewrite pass-through (H2 disposition) ───────────────────────────────────
 * The OpenSearch Contributors require contributions made to  
     * The rewrite parameter must be passed through as a MAP operand rather than rejected.
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "l*"), ctx);  
            () -> translator.convert(QueryBuilders.wildcardQuery("name", "lap*").boost(2.0f), ctx)
 * with the Lucene wildcard pattern emitted unchanged.
    public void testFieldResolutionUsesCorrectIndex() throws ConversionException {
        RexLiteral paramKey = (RexLiteral) paramMap.getOperands().get(0);
     * Boost must remain rejected with ConversionException — regression guard for the approved disposition.  
        RexInputRef inputRef = (RexInputRef) fieldMap.getOperands().get(1);
 * Tests for {@link WildcardQueryTranslator} — asserts delegation via WILDCARD_QUERY_DSL RexCall
    }
package org.opensearch.dsl.query;
    public void testRewriteParameterEmitsMapOperand() throws ConversionException {
        assertEquals(pattern, queryValue.getValueAs(String.class));  
    public void testWildcardThrowsForNonexistentField() {  
    public void testWildcardThrowsForNonStringField() {  
        RexCall call = (RexCall) result;
    }  
        RexCall queryMap = (RexCall) call.getOperands().get(1);  
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", pattern), ctx);
        assertEquals("MAP", paramMap.getOperator().getName());
        assertEquals(2, inputRef.getIndex());
    // ── Verbatim passthrough — pattern is emitted UNCHANGED ─────────────────────  
 */  
        assertTrue("Must mention 'not supported', got: " + ex.getMessage(), ex.getMessage().contains("not supported"));
        assertEquals("rewrite", paramKey.getValueAs(String.class));
public class WildcardQueryTranslatorTests extends OpenSearchTestCase {
    }
     */
        RexCall call = (RexCall) result;
    public void testLeadingWildcardPatternEmittedVerbatim() throws ConversionException {
    public void testQueryOperandContainsLiteralPattern() throws ConversionException {  
     */
            ConversionException.class,
 * compatible open source license.
        RexCall call = (RexCall) result;
        assertEquals("l*pt?p", queryValue.getValueAs(String.class));  
    private final ConversionContext ctx = TestUtils.createContext();
        assertEquals("", queryValue.getValueAs(String.class));
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "l*pt?p"), ctx);
import org.opensearch.test.OpenSearchTestCase;
    }  
        ConversionException ex = expectThrows(
    }  
import org.apache.calcite.rex.RexNode;
        // Only 2 operands: field and query — no case_insensitive param when value is false  
            () -> translator.convert(QueryBuilders.wildcardQuery("price", "12*"), ctx)
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "l*"), ctx);  
     * Behaviour-pinning test: explicitly setting case_insensitive to false emits no case_insensitive
    public void testCaseInsensitiveEmitsParam() throws ConversionException {
    public void testWildcardThrowsForRewriteParameter() throws ConversionException {
        assertTrue(ex.getMessage().contains("price"));
        RexCall call = (RexCall) result;
    // ── Boost rejection regression guard ────────────────────────────────────────  
    // ── _name rejection ────────────────────────────────────────────────────────
import org.opensearch.dsl.TestUtils;  
    // ── Behaviour-pinning: case_insensitive explicitly false ────────────────────
     * Behaviour-pinning test: a unicode pattern containing German sharp s (ß) and accented characters
    public void testNameParameterRejectedWithConversionException() {
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
        RexCall queryMap = (RexCall) call.getOperands().get(1);
        assertEquals("MAP", paramMap.getOperator().getName());
    /**
        ConversionException ex = expectThrows(  
        RexLiteral paramKey = (RexLiteral) paramMap.getOperands().get(0);  
        RexLiteral paramValue = (RexLiteral) paramMap.getOperands().get(1);
    }
    // ── RexCall shape assertions ────────────────────────────────────────────────  
    // ── Parameter rejection ─────────────────────────────────────────────────────
    public void testCaseSensitiveHasNoExtraOperand() throws ConversionException {
        );
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
            () -> translator.convert(QueryBuilders.wildcardQuery("nonexistent", "val*"), ctx)  
        RexInputRef inputRef = (RexInputRef) fieldMap.getOperands().get(1);
        );
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "LAP*").caseInsensitive(true), ctx);
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "lap*").rewrite("constant_score"), ctx);
        RexCall call = (RexCall) result;
    // ── case_insensitive param ──────────────────────────────────────────────────
        assertEquals("MAP", fieldMap.getOperator().getName());
    public void testWildcardPatternPassedVerbatim() throws ConversionException {
 *
        RexCall call = (RexCall) result;
    private final WildcardQueryTranslator translator = new WildcardQueryTranslator();  
        assertTrue(ex.getMessage().contains("Field 'nonexistent' not found"));
     */  
        RexCall paramMap = (RexCall) call.getOperands().get(2);
    // ── Behaviour-pinning: unicode pattern emitted verbatim (L1) ────────────────
    // ── VARCHAR field-type gate ─────────────────────────────────────────────────
        // Lucene wildcard pattern: *, ?, escaped backslash — all pass through untouched  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, inputRef.getIndex()); // 'name' is index 0  
        // 'brand' is at index 2 in the test schema
            () -> translator.convert(QueryBuilders.wildcardQuery("name", "lap*").boost(1.5f), ctx)
        assertTrue("field value must be an InputRef", fieldMap.getOperands().get(1) instanceof RexInputRef);
        ConversionException ex = expectThrows(
            ConversionException.class,  
        );  
 */  
    }
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
        ConversionException ex = expectThrows(
import org.apache.calcite.rex.RexInputRef;
    public void testBoostParameterRejectedWithConversionException() {
/*  
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);  
        RexCall call = (RexCall) result;  
    public void testPatternWithBackslashPassedVerbatim() throws ConversionException {  
        RexLiteral fieldKey = (RexLiteral) fieldMap.getOperands().get(0);
        RexCall queryMap = (RexCall) call.getOperands().get(1);  
     * _name must be rejected with ConversionException — matched_queries is not surfaced in SQL.
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "l*pt?p"), ctx);  
        RexCall fieldMap = (RexCall) call.getOperands().get(0);  
        // SQL metacharacters % and _ are NOT special in Lucene wildcard syntax — pass through unchanged
    }  
        assertEquals("LAP*", queryValue.getValueAs(String.class));
        RexCall call = (RexCall) result;  
    }  
        );
        assertTrue("Must mention 'boost', got: " + ex.getMessage(), ex.getMessage().contains("boost"));
    /**
        assertEquals("true", paramValue.getValueAs(String.class));
        assertEquals(pattern, queryValue.getValueAs(String.class));
            ConversionException.class,
    /**
    }
        RexCall queryMap = (RexCall) call.getOperands().get(1);  
        assertEquals(pattern, queryValue.getValueAs(String.class));
        RexCall call = (RexCall) result;  
import org.opensearch.index.query.QueryBuilders;  
        RexCall queryMap = (RexCall) call.getOperands().get(1);
        assertEquals("WILDCARD_QUERY_DSL", call.getOperator().getName());
        RexCall fieldMap = (RexCall) call.getOperands().get(0);  
        assertEquals("*checkout", queryValue.getValueAs(String.class));
    /**  
    }
        // Should have 3 operands: field, query, rewrite param
import org.apache.calcite.rex.RexLiteral;  
        assertEquals(2, call.getOperands().size());
        RexCall call = (RexCall) result;  
import org.opensearch.dsl.converter.ConversionException;
        String unicodePattern = "straße*über?";  
        RexCall paramMap = (RexCall) call.getOperands().get(2);  
}
        RexCall queryMap = (RexCall) call.getOperands().get(1);
        // Pattern should NOT be lowercased — case_insensitive is now a param, not LOWER() wrapping
        RexCall queryMap = (RexCall) call.getOperands().get(1);
        assertEquals(unicodePattern, queryValue.getValueAs(String.class));  
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "LAP*").caseInsensitive(true), ctx);
    /**
        // MappedFieldType.wildcardQuery:309-317 rejects non-keyword/text fields
import org.opensearch.dsl.converter.ConversionContext;
    }  
    // ── Field resolution ────────────────────────────────────────────────────────
        RexCall call = (RexCall) result;
        assertEquals("query", queryKey.getValueAs(String.class));
        translator.convert(QueryBuilders.wildcardQuery("name", "lap*").rewrite("constant_score"), ctx);
        assertEquals("constant_score", paramValue.getValueAs(String.class));  
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
        assertEquals("field", fieldKey.getValueAs(String.class));  
    }
    }
        assertEquals("case_insensitive", paramKey.getValueAs(String.class));  
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", pattern), ctx);  
        assertTrue(ex.getMessage().contains("not supported"));
/**  
        String pattern = "C:\\Users\\test";
        RexLiteral paramValue = (RexLiteral) paramMap.getOperands().get(1);
        RexCall queryMap = (RexCall) call.getOperands().get(1);
        // A pattern with backslash-escaped chars — no conversion occurs
            ConversionException.class,
        assertTrue(ex.getMessage().contains("keyword and text"));  
        RexCall call = (RexCall) result;  
    public void testCaseInsensitivePatternNotLowered() throws ConversionException {  
        assertEquals("MAP", queryMap.getOperator().getName());
    public void testPatternWithSqlMetacharsPassedVerbatim() throws ConversionException {
    }
        );  
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);  
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("brand", "app*"), ctx);  
    /**
        String pattern = "50%_done*";  
    }  
import org.apache.calcite.sql.SqlKind;
        assertEquals(3, call.getOperands().size());  
        // Validation occurs on the data node via QueryParsers.parseRewriteMethod.
        // Rewrite is now passed through (H2 disposition) — no longer rejected.  
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", unicodePattern), ctx);
    }  
        assertTrue("Result must be a RexCall", result instanceof RexCall);
        RexCall call = (RexCall) result;
        assertTrue(ex.getMessage().contains("boost"));
import org.apache.calcite.rex.RexCall;
        ConversionException ex = expectThrows(  
     */  
    }  
    public void testFieldOperandContainsInputRef() throws ConversionException {
    public void testExplicitCaseInsensitiveFalseEmitsNoParam() throws ConversionException {

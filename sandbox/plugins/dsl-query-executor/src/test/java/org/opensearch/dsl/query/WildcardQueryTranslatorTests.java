    /**
    public void testRewriteParameterEmitsMapOperand() throws ConversionException {
 * The OpenSearch Contributors require contributions made to
        RexLiteral paramKey = (RexLiteral) paramMap.getOperands().get(0);
        RexLiteral paramValue = (RexLiteral) paramMap.getOperands().get(1);
import org.opensearch.index.query.QueryBuilders;
     */
        assertEquals(3, call.getOperands().size());
        assertEquals(3, call.getOperands().size());
        assertEquals("MAP", queryMap.getOperator().getName());
        assertTrue(ex.getMessage().contains("price"));
     * param operand — the translator only emits the param when true.
        RexCall fieldMap = (RexCall) call.getOperands().get(0);
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", ""), ctx);
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "LAP*").caseInsensitive(true), ctx);
        RexCall call = (RexCall) result;
            () -> translator.convert(QueryBuilders.wildcardQuery("price", "12*"), ctx)
        RexCall call = (RexCall) result;
 * this file be licensed under the Apache-2.0 license or a
        RexLiteral fieldKey = (RexLiteral) fieldMap.getOperands().get(0);
    }
    }
    }
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", unicodePattern), ctx);
        RexCall fieldMap = (RexCall) call.getOperands().get(0);
        ConversionException ex = expectThrows(
        assertEquals("LAP*", queryValue.getValueAs(String.class));
    }
        translator.convert(QueryBuilders.wildcardQuery("name", "lap*").rewrite("constant_score"), ctx);
        RexCall queryMap = (RexCall) call.getOperands().get(1);
    public void testPatternWithBackslashPassedVerbatim() throws ConversionException {
 *
        assertEquals(unicodePattern, queryValue.getValueAs(String.class));
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "l*").caseInsensitive(false), ctx);
    }
    public void testQueryOperandContainsLiteralPattern() throws ConversionException {
        assertTrue(ex.getMessage().contains("Field 'nonexistent' not found"));
        // Pattern should NOT be lowercased — case_insensitive is now a param, not LOWER() wrapping
        RexCall call = (RexCall) result;
        ConversionException ex = expectThrows(
    // ── _name rejection ────────────────────────────────────────────────────────
    // ── RexCall shape assertions ────────────────────────────────────────────────
        // Validation occurs on the data node via QueryParsers.parseRewriteMethod.
    // ── Rewrite pass-through (H2 disposition) ───────────────────────────────────
    }
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
    /**
        );
        RexCall call = (RexCall) result;
    // ── Verbatim passthrough — pattern is emitted UNCHANGED ─────────────────────
    // ── Behaviour-pinning: leading wildcard emitted verbatim (M3) ───────────────
        assertEquals(2, call.getOperands().size());
    /**
        RexCall paramMap = (RexCall) call.getOperands().get(2);
    public void testNameParameterRejectedWithConversionException() {
 */
 */
    /**
        );
            () -> translator.convert(QueryBuilders.wildcardQuery("name", "lap*").queryName("my_wildcard"), ctx)
    /**
        assertEquals("l*pt?p", queryValue.getValueAs(String.class));
        assertEquals(pattern, queryValue.getValueAs(String.class));
import org.opensearch.dsl.TestUtils;
    }
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", pattern), ctx);
    }
            ConversionException.class,
     * Behaviour-pinning test: explicitly setting case_insensitive to false emits no case_insensitive
        );
        // Should have 3 operands: field, query, rewrite param
    }
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;
        assertTrue(ex.getMessage().contains("boost"));
    public void testCaseInsensitiveEmitsParam() throws ConversionException {
    public void testWildcardThrowsForNonStringField() {
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
import org.apache.calcite.sql.SqlKind;
        assertTrue("Result must be a RexCall", result instanceof RexCall);
import org.opensearch.dsl.converter.ConversionException;
    // ── case_insensitive param ──────────────────────────────────────────────────
        assertEquals(pattern, queryValue.getValueAs(String.class));
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
        RexLiteral queryKey = (RexLiteral) queryMap.getOperands().get(0);
    }
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "lap*").rewrite("constant_score"), ctx);
    }
 * Tests for {@link WildcardQueryTranslator} — asserts delegation via WILDCARD_QUERY_DSL RexCall
        // MappedFieldType.wildcardQuery:309-317 rejects non-keyword/text fields
        assertEquals("Wildcard query parameter '_name' is not supported", ex.getMessage());
        // SQL metacharacters % and _ are NOT special in Lucene wildcard syntax — pass through unchanged
    public void testExplicitCaseInsensitiveFalseEmitsNoParam() throws ConversionException {
    // ── Boost rejection regression guard ────────────────────────────────────────
    public void testBoostParameterRejectedWithConversionException() {
        RexInputRef inputRef = (RexInputRef) fieldMap.getOperands().get(1);
        assertEquals(pattern, queryValue.getValueAs(String.class));
    public void testWildcardPatternPassedVerbatim() throws ConversionException {
        assertEquals(2, call.getOperands().size());
        RexCall queryMap = (RexCall) call.getOperands().get(1);
        assertEquals("*checkout", queryValue.getValueAs(String.class));
        String pattern = "C:\\Users\\test";
        RexCall paramMap = (RexCall) call.getOperands().get(2);
        assertTrue(ex.getMessage().contains("not supported"));
        assertEquals("rewrite", paramKey.getValueAs(String.class));
    public void testWildcardThrowsForNonexistentField() {
    private final ConversionContext ctx = TestUtils.createContext();
    public void testUnicodePatternWithSharpSEmittedVerbatim() throws ConversionException {
    public void testPatternWithSqlMetacharsPassedVerbatim() throws ConversionException {
    private final WildcardQueryTranslator translator = new WildcardQueryTranslator();
        RexInputRef inputRef = (RexInputRef) fieldMap.getOperands().get(1);
import org.apache.calcite.rex.RexCall;
    public void testFieldResolutionUsesCorrectIndex() throws ConversionException {
        RexCall queryMap = (RexCall) call.getOperands().get(1);
package org.opensearch.dsl.query;
        RexCall call = (RexCall) result;
        assertEquals("query", queryKey.getValueAs(String.class));
        assertTrue("Must mention 'not supported', got: " + ex.getMessage(), ex.getMessage().contains("not supported"));
import org.apache.calcite.rex.RexInputRef;
import org.apache.calcite.rex.RexNode;
     * Behaviour-pinning test: a unicode pattern containing German sharp s (ß) and accented characters
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
            ConversionException.class,
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "LAP*").caseInsensitive(true), ctx);
import org.apache.calcite.rex.RexLiteral;
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "l*"), ctx);
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
     * is emitted verbatim — documents that case folding is now Lucene's ASCII-only behaviour
        assertTrue("field value must be an InputRef", fieldMap.getOperands().get(1) instanceof RexInputRef);
            () -> translator.convert(QueryBuilders.wildcardQuery("name", "lap*").boost(2.0f), ctx)
     * The rewrite parameter must be passed through as a MAP operand rather than rejected.
    public void testWildcardThrowsForBoostParameter() {
        RexCall queryMap = (RexCall) call.getOperands().get(1);
import org.opensearch.dsl.converter.ConversionContext;
     * Boost must remain rejected with ConversionException — regression guard for the approved disposition.
        assertEquals("case_insensitive", paramKey.getValueAs(String.class));
    public void testFieldOperandContainsInputRef() throws ConversionException {
    public void testWildcardThrowsForRewriteParameter() throws ConversionException {
    }
    // ── Field resolution ────────────────────────────────────────────────────────
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", pattern), ctx);
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "l*pt?p"), ctx);
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
 * compatible open source license.
        assertEquals("true", paramValue.getValueAs(String.class));
    public void testCaseInsensitivePatternNotLowered() throws ConversionException {
        String pattern = "test\\*file\\?name\\\\end";
            ConversionException.class,
        assertEquals(SqlKind.OTHER_FUNCTION, call.getKind());
        assertEquals(2, inputRef.getIndex());
        assertEquals("MAP", paramMap.getOperator().getName());
    public void testCaseSensitiveHasNoExtraOperand() throws ConversionException {
        assertEquals("", queryValue.getValueAs(String.class));
    // ── Behaviour-pinning: case_insensitive explicitly false ────────────────────
            () -> translator.convert(QueryBuilders.wildcardQuery("nonexistent", "val*"), ctx)
    // ── Parameter rejection ─────────────────────────────────────────────────────
        assertTrue("Must mention 'boost', got: " + ex.getMessage(), ex.getMessage().contains("boost"));
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "l*pt?p"), ctx);
        // Lucene wildcard pattern: *, ?, escaped backslash — all pass through untouched
        RexCall queryMap = (RexCall) call.getOperands().get(1);
     * rather than our old LOWER() wrapping.
        // 'brand' is at index 2 in the test schema
    // ── Behaviour-pinning: unicode pattern emitted verbatim (L1) ────────────────
        // A pattern with backslash-escaped chars — no conversion occurs
        assertEquals("MAP", paramMap.getOperator().getName());
        ConversionException ex = expectThrows(
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "*checkout"), ctx);
    }
        RexCall queryMap = (RexCall) call.getOperands().get(1);
        RexCall queryMap = (RexCall) call.getOperands().get(1);
        RexCall call = (RexCall) result;
     */
    public void testEmitsWildcardQueryDslRexCall() throws ConversionException {
        RexLiteral paramValue = (RexLiteral) paramMap.getOperands().get(1);
        RexLiteral paramKey = (RexLiteral) paramMap.getOperands().get(0);
public class WildcardQueryTranslatorTests extends OpenSearchTestCase {
        // Only 2 operands: field and query — no case_insensitive param when value is false
     * _name must be rejected with ConversionException — matched_queries is not surfaced in SQL.
    public void testLeadingWildcardPatternEmittedVerbatim() throws ConversionException {
 * with the Lucene wildcard pattern emitted unchanged.
     */
    }
    }
        RexCall call = (RexCall) result;
     */
        RexCall call = (RexCall) result;
        RexCall queryMap = (RexCall) call.getOperands().get(1);
    /**
        RexCall call = (RexCall) result;
            () -> translator.convert(QueryBuilders.wildcardQuery("name", "lap*").boost(1.5f), ctx)
/*
        assertEquals("MAP", fieldMap.getOperator().getName());
    }
 * SPDX-License-Identifier: Apache-2.0
        String unicodePattern = "straße*über?";
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
    // ── VARCHAR field-type gate ─────────────────────────────────────────────────
        assertEquals(0, inputRef.getIndex()); // 'name' is index 0
        );
        RexCall call = (RexCall) result;
        assertEquals("constant_score", paramValue.getValueAs(String.class));
    }
    public void testEmptyPatternPassedVerbatim() throws ConversionException {
}
        assertEquals("field", fieldKey.getValueAs(String.class));
        // Rewrite is now passed through (H2 disposition) — no longer rejected.
        assertEquals("WILDCARD_QUERY_DSL", call.getOperator().getName());
    }
    }
        String pattern = "50%_done*";
     */
        );
        assertTrue(ex.getMessage().contains("keyword and text"));
        RexCall call = (RexCall) result;
     */
import org.opensearch.test.OpenSearchTestCase;
    }
            ConversionException.class,
/**
    }
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("brand", "app*"), ctx);
            ConversionException.class,
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", "l*"), ctx);
        ConversionException ex = expectThrows(
        RexNode result = translator.convert(QueryBuilders.wildcardQuery("name", pattern), ctx);
        ConversionException ex = expectThrows(
     * Behaviour-pinning test: a leading-wildcard pattern is emitted verbatim — no rewriting or rejection.

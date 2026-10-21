    public void testFieldOperandContainsInputRef() throws ConversionException {
 *
    public void testPrefixQueryThrowsForNonexistentField() {
     * _name must be rejected with ConversionException — matched_queries is not surfaced in SQL.
    // ── Boost rejection regression guard ────────────────────────────────────────
        assertEquals(verbatim, queryValue.getValueAs(String.class));
        assertEquals(2, call.getOperands().size());
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "lap"), ctx);
        assertEquals("lap", queryValue.getValueAs(String.class));
package org.opensearch.dsl.query;
        assertEquals("Prefix query parameter '_name' is not supported", ex.getMessage());
 * this file be licensed under the Apache-2.0 license or a
     * param operand — the translator only emits the param when true.
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
        RexCall queryMap = (RexCall) call.getOperands().get(1);
            ConversionException.class,
    public void testPrefixQueryThrowsForBoostParameter() {
        RexInputRef inputRef = (RexInputRef) fieldMap.getOperands().get(1);
        assertEquals("MAP", paramMap.getOperator().getName());
    }
import org.apache.calcite.rex.RexCall;
     * Boost must remain rejected with ConversionException — regression guard for the approved disposition.
        // Validation occurs on the data node via QueryParsers.parseRewriteMethod.
 * The OpenSearch Contributors require contributions made to
        assertTrue("field value must be an InputRef", fieldMap.getOperands().get(1) instanceof RexInputRef);
        RexLiteral queryKey = (RexLiteral) queryMap.getOperands().get(0);
        RexInputRef inputRef = (RexInputRef) fieldMap.getOperands().get(1);
        assertTrue("Result must be a RexCall", result instanceof RexCall);
import org.opensearch.dsl.converter.ConversionException;
    public void testEmptyStringPassedVerbatim() throws ConversionException {
    }
        RexLiteral paramValue = (RexLiteral) paramMap.getOperands().get(1);
            ConversionException.class,
import org.opensearch.test.OpenSearchTestCase;
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "Lap").caseInsensitive(true), ctx);
    /**
     * Behaviour-pinning test: explicitly setting case_insensitive to false emits no case_insensitive
        assertEquals(0, inputRef.getIndex()); // 'name' is index 0 in test schema
        );
        RexCall call = (RexCall) result;
        // Only 2 operands: field and query (no case_insensitive param)
        String verbatim = "check*it?out\\done";
        ConversionException ex = expectThrows(
    }
import org.opensearch.dsl.TestUtils;
        RexCall call = (RexCall) result;
        assertTrue(ex.getMessage().contains("not supported"));
        assertEquals(3, call.getOperands().size());
/*
    }
            () -> translator.convert(QueryBuilders.prefixQuery("name", "lap").boost(1.5f), ctx)
        ConversionException ex = expectThrows(
    }
        RexLiteral paramKey = (RexLiteral) paramMap.getOperands().get(0);
    public void testBoostParameterRejectedWithConversionException() {
 * Tests for {@link PrefixQueryTranslator} — asserts delegation via PREFIX_QUERY RexCall.
     */
    public void testCaseSensitiveHasNoExtraOperand() throws ConversionException {
        assertEquals("rewrite", paramKey.getValueAs(String.class));
    // ── Behaviour-pinning: case_insensitive explicitly false ────────────────────
        RexCall call = (RexCall) result;
        // 'brand' is at index 2 in the test schema
import org.apache.calcite.rex.RexInputRef;
            ConversionException.class,
     */
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "lap"), ctx);
    }
        // Should have 3 operands: field, query, rewrite param
        assertEquals("case_insensitive", paramKey.getValueAs(String.class));
    public void testFieldResolutionUsesCorrectIndex() throws ConversionException {
     */
        ConversionException ex = expectThrows(
        RexCall call = (RexCall) result;
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", ""), ctx);
            ConversionException.class,
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "lap"), ctx);
            () -> translator.convert(QueryBuilders.prefixQuery("name", "lap").queryName("my_prefix"), ctx)
        RexCall queryMap = (RexCall) call.getOperands().get(1);
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "lap").rewrite("constant_score"), ctx);
    // ── _name rejection ────────────────────────────────────────────────────────
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
        assertEquals("true", paramValue.getValueAs(String.class));
        ConversionException ex = expectThrows(
    }
            () -> translator.convert(QueryBuilders.prefixQuery("name", "lap").boost(2.0f), ctx)
        RexNode result = translator.convert(QueryBuilders.prefixQuery("brand", "app"), ctx);
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "lap").caseInsensitive(false), ctx);
        // MappedFieldType.prefixQuery:291-297 rejects non-keyword/text fields
    }
        RexCall paramMap = (RexCall) call.getOperands().get(2);
    /**
public class PrefixQueryTranslatorTests extends OpenSearchTestCase {
        assertEquals("field", fieldKey.getValueAs(String.class));
    private final ConversionContext ctx = TestUtils.createContext();
    }
        RexCall call = (RexCall) result;
    public void testPrefixQueryThrowsForRewriteParameter() throws ConversionException {
        assertEquals("MAP", paramMap.getOperator().getName());
    public void testNameParameterRejectedWithConversionException() {
        assertEquals(2, call.getOperands().size());
        );
        RexCall queryMap = (RexCall) call.getOperands().get(1);
        assertEquals("PREFIX_QUERY", call.getOperator().getName());
import org.opensearch.dsl.converter.ConversionContext;
 */
import org.opensearch.index.query.QueryBuilders;
     * The rewrite parameter must be passed through as a MAP operand rather than rejected.
    }
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", verbatim), ctx);
        );
import org.apache.calcite.rex.RexNode;
    }
    public void testVerbatimPassthroughOfMetacharacters() throws ConversionException {
        assertTrue(ex.getMessage().contains("keyword and text"));
        RexCall fieldMap = (RexCall) call.getOperands().get(0);
    /**
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
        // Rewrite is now passed through (H2 disposition) — no longer rejected.
        );
        assertEquals(SqlKind.OTHER_FUNCTION, call.getKind());
    }
            ConversionException.class,
    public void testRewriteParameterEmitsMapOperand() throws ConversionException {
    }
    public void testCaseInsensitiveEmitsParam() throws ConversionException {
    public void testExplicitCaseInsensitiveFalseEmitsNoParam() throws ConversionException {
import org.apache.calcite.sql.SqlKind;
        ConversionException ex = expectThrows(
        translator.convert(QueryBuilders.prefixQuery("name", "lap").rewrite("constant_score"), ctx);
        assertEquals("", queryValue.getValueAs(String.class));
        // Only 2 operands: field and query — no case_insensitive param when value is false
    }
}
 * compatible open source license.
        assertEquals(3, call.getOperands().size());
    public void testQueryOperandContainsLiteralValue() throws ConversionException {
    public void testEmitsPrefixQueryRexCall() throws ConversionException {
        RexLiteral fieldKey = (RexLiteral) fieldMap.getOperands().get(0);
        assertEquals("MAP", fieldMap.getOperator().getName());
        RexCall fieldMap = (RexCall) call.getOperands().get(0);
        // Value contains *, ? and backslash — must be passed through unchanged (no escaping)
        assertTrue(ex.getMessage().contains("price"));
 */
    // ── Rewrite pass-through (H2 disposition) ───────────────────────────────────
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(ex.getMessage().contains("Field 'nonexistent' not found"));
    }
        assertTrue(ex.getMessage().contains("boost"));
        // Operand 1: MAP('query', 'lap')
        // Should have 3 operands: field, query, case_insensitive param
        assertTrue("Must mention 'not supported', got: " + ex.getMessage(), ex.getMessage().contains("not supported"));
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "lap"), ctx);
     */
        RexLiteral paramKey = (RexLiteral) paramMap.getOperands().get(0);
            () -> translator.convert(QueryBuilders.prefixQuery("nonexistent", "value"), ctx)
        assertEquals("query", queryKey.getValueAs(String.class));
        );
    }
            () -> translator.convert(QueryBuilders.prefixQuery("price", "12"), ctx)
        assertTrue("Must mention 'boost', got: " + ex.getMessage(), ex.getMessage().contains("boost"));
        // Operand 0: MAP('field', $inputRef)
        RexCall call = (RexCall) result;
/**
        assertEquals("constant_score", paramValue.getValueAs(String.class));
        RexCall call = (RexCall) result;
    private final PrefixQueryTranslator translator = new PrefixQueryTranslator();
        RexCall paramMap = (RexCall) call.getOperands().get(2);
        RexLiteral paramValue = (RexLiteral) paramMap.getOperands().get(1);
        assertEquals("MAP", queryMap.getOperator().getName());
    public void testPrefixQueryThrowsForNonStringField() {
        assertEquals(2, inputRef.getIndex()); // 'brand' is index 2
import org.apache.calcite.rex.RexLiteral;
    /**

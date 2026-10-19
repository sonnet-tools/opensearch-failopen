        RexLiteral paramValue = (RexLiteral) paramMap.getOperands().get(1);
import org.apache.calcite.rex.RexInputRef;
        RexCall paramMap = (RexCall) call.getOperands().get(2);
        RexCall call = (RexCall) result;  
import org.opensearch.dsl.converter.ConversionException;
    }
            ConversionException.class,
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2, call.getOperands().size());  
        RexCall call = (RexCall) result;
        RexCall fieldMap = (RexCall) call.getOperands().get(0);
    public void testCaseSensitiveHasNoExtraOperand() throws ConversionException {  
    /**  
        assertEquals("MAP", fieldMap.getOperator().getName());
    /**  
            () -> translator.convert(QueryBuilders.prefixQuery("nonexistent", "value"), ctx)
        assertEquals("query", queryKey.getValueAs(String.class));  
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "lap").caseInsensitive(false), ctx);
import org.opensearch.dsl.TestUtils;  
        // Only 2 operands: field and query (no case_insensitive param)
        RexCall paramMap = (RexCall) call.getOperands().get(2);
    private final ConversionContext ctx = TestUtils.createContext();  
        RexNode result = translator.convert(QueryBuilders.prefixQuery("brand", "app"), ctx);
            () -> translator.convert(QueryBuilders.prefixQuery("price", "12"), ctx)
        RexCall call = (RexCall) result;  
        RexCall call = (RexCall) result;  
     */
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "lap"), ctx);  
        assertEquals(0, inputRef.getIndex()); // 'name' is index 0 in test schema
        assertEquals("MAP", paramMap.getOperator().getName());  
    /**
    public void testNameParameterRejectedWithConversionException() {
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(SqlKind.OTHER_FUNCTION, call.getKind());
        assertTrue("field value must be an InputRef", fieldMap.getOperands().get(1) instanceof RexInputRef);
        // Value contains *, ? and backslash — must be passed through unchanged (no escaping)  
        assertEquals("lap", queryValue.getValueAs(String.class));
        // Validation occurs on the data node via QueryParsers.parseRewriteMethod.  
        RexCall queryMap = (RexCall) call.getOperands().get(1);  
import org.apache.calcite.rex.RexCall;
    }  
        assertEquals(3, call.getOperands().size());  
    }
     */  
        assertTrue(ex.getMessage().contains("Field 'nonexistent' not found"));
            ConversionException.class,  
    public void testPrefixQueryThrowsForNonStringField() {
        assertEquals("field", fieldKey.getValueAs(String.class));
 * The OpenSearch Contributors require contributions made to  
    }
    }
package org.opensearch.dsl.query;
            ConversionException.class,
        RexInputRef inputRef = (RexInputRef) fieldMap.getOperands().get(1);
        assertEquals(3, call.getOperands().size());
        assertEquals(2, inputRef.getIndex()); // 'brand' is index 2  
        RexLiteral fieldKey = (RexLiteral) fieldMap.getOperands().get(0);  
     * param operand — the translator only emits the param when true.
        // Should have 3 operands: field, query, rewrite param  
        RexLiteral queryKey = (RexLiteral) queryMap.getOperands().get(0);
    }
        RexCall queryMap = (RexCall) call.getOperands().get(1);
import org.opensearch.dsl.converter.ConversionContext;
        ConversionException ex = expectThrows(  
        assertEquals("case_insensitive", paramKey.getValueAs(String.class));
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", verbatim), ctx);
     */
        assertTrue("Must mention 'boost', got: " + ex.getMessage(), ex.getMessage().contains("boost"));
     * Boost must remain rejected with ConversionException — regression guard for the approved disposition.
public class PrefixQueryTranslatorTests extends OpenSearchTestCase {  
 * Tests for {@link PrefixQueryTranslator} — asserts delegation via PREFIX_QUERY RexCall.
    public void testExplicitCaseInsensitiveFalseEmitsNoParam() throws ConversionException {
        );
    }  
     * Behaviour-pinning test: explicitly setting case_insensitive to false emits no case_insensitive
        assertTrue("Must mention 'not supported', got: " + ex.getMessage(), ex.getMessage().contains("not supported"));  
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "lap"), ctx);
    public void testQueryOperandContainsLiteralValue() throws ConversionException {
        assertEquals(verbatim, queryValue.getValueAs(String.class));
 * compatible open source license.
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);
    public void testPrefixQueryThrowsForRewriteParameter() throws ConversionException {
        RexLiteral paramKey = (RexLiteral) paramMap.getOperands().get(0);  
        String verbatim = "check*it?out\\done";
        ConversionException ex = expectThrows(  
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "Lap").caseInsensitive(true), ctx);
    public void testEmitsPrefixQueryRexCall() throws ConversionException {
    public void testEmptyStringPassedVerbatim() throws ConversionException {
        RexCall call = (RexCall) result;  
    }
        assertEquals("PREFIX_QUERY", call.getOperator().getName());
            ConversionException.class,
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "lap").rewrite("constant_score"), ctx);  
    }
        RexCall fieldMap = (RexCall) call.getOperands().get(0);
 *
     * The rewrite parameter must be passed through as a MAP operand rather than rejected.  
    public void testVerbatimPassthroughOfMetacharacters() throws ConversionException {
        assertTrue(ex.getMessage().contains("not supported"));
    }
/*  
        RexCall call = (RexCall) result;
        RexInputRef inputRef = (RexInputRef) fieldMap.getOperands().get(1);  
    }
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "lap"), ctx);
    public void testFieldOperandContainsInputRef() throws ConversionException {
        );  
        assertEquals(2, call.getOperands().size());
        assertTrue(ex.getMessage().contains("keyword and text"));
        assertEquals("constant_score", paramValue.getValueAs(String.class));
    public void testFieldResolutionUsesCorrectIndex() throws ConversionException {
        // MappedFieldType.prefixQuery:291-297 rejects non-keyword/text fields
        );  
    public void testCaseInsensitiveEmitsParam() throws ConversionException {
import org.apache.calcite.sql.SqlKind;
     * _name must be rejected with ConversionException — matched_queries is not surfaced in SQL.  
        assertTrue("Result must be a RexCall", result instanceof RexCall);
     */
    // ── _name rejection ────────────────────────────────────────────────────────  
        );
            () -> translator.convert(QueryBuilders.prefixQuery("name", "lap").queryName("my_prefix"), ctx)
 */
        assertTrue(ex.getMessage().contains("price"));
    }
/**  
import org.apache.calcite.rex.RexNode;
    }
        ConversionException ex = expectThrows(  
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);  
        assertEquals("true", paramValue.getValueAs(String.class));  
        // Only 2 operands: field and query — no case_insensitive param when value is false
        RexLiteral queryValue = (RexLiteral) queryMap.getOperands().get(1);  
    public void testPrefixQueryThrowsForNonexistentField() {
        RexCall call = (RexCall) result;  
        // 'brand' is at index 2 in the test schema  
        ConversionException ex = expectThrows(
            () -> translator.convert(QueryBuilders.prefixQuery("name", "lap").boost(1.5f), ctx)  
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", "lap"), ctx);  
 * this file be licensed under the Apache-2.0 license or a
        RexLiteral paramKey = (RexLiteral) paramMap.getOperands().get(0);
        assertEquals("Prefix query parameter '_name' is not supported", ex.getMessage());
            ConversionException.class,
    public void testBoostParameterRejectedWithConversionException() {  
        // Rewrite is now passed through (H2 disposition) — no longer rejected.
        assertEquals("", queryValue.getValueAs(String.class));
    }  
        ConversionException ex = expectThrows(
        );  
        assertEquals("rewrite", paramKey.getValueAs(String.class));
 */  
        RexNode result = translator.convert(QueryBuilders.prefixQuery("name", ""), ctx);
    public void testRewriteParameterEmitsMapOperand() throws ConversionException {
    }  
    public void testPrefixQueryThrowsForBoostParameter() {
        RexLiteral paramValue = (RexLiteral) paramMap.getOperands().get(1);  
        // Operand 0: MAP('field', $inputRef)  
    // ── Rewrite pass-through (H2 disposition) ───────────────────────────────────  
        RexCall call = (RexCall) result;
        // Operand 1: MAP('query', 'lap')
    /**
    private final PrefixQueryTranslator translator = new PrefixQueryTranslator();
        assertEquals("MAP", paramMap.getOperator().getName());
        assertEquals("MAP", queryMap.getOperator().getName());
        // Should have 3 operands: field, query, case_insensitive param
            () -> translator.convert(QueryBuilders.prefixQuery("name", "lap").boost(2.0f), ctx)
        assertTrue(ex.getMessage().contains("boost"));  
    // ── Behaviour-pinning: case_insensitive explicitly false ────────────────────
import org.apache.calcite.rex.RexLiteral;  
    }
import org.opensearch.index.query.QueryBuilders;  
        RexCall call = (RexCall) result;
    // ── Boost rejection regression guard ────────────────────────────────────────
        RexCall queryMap = (RexCall) call.getOperands().get(1);
        RexCall call = (RexCall) result;  
        translator.convert(QueryBuilders.prefixQuery("name", "lap").rewrite("constant_score"), ctx);
}

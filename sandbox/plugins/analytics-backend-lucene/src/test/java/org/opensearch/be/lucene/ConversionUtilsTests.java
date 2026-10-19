        RexNode plainLiteral = rexBuilder.makeLiteral("stray_value");
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, fieldMap, queryMap);
        assertNull(operands.fieldName());
    public void testExtractOptionalParams_skipsNonMapOperands() {  
     * Validates Requirement 9.1 (fallback path).
     */  
import org.apache.calcite.sql.type.OperandTypes;
        List<FieldStorageInfo> fieldStorage = List.of();
        assertEquals("Should only extract the valid MAP param", 1, params.size());
        // RexInputRef is not a RexCall, so extractMapKey should return null  
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            rexBuilder.makeLiteral("query"),  
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexNode fieldsKeyLiteral = rexBuilder.makeLiteral("fields");
        // MAP with a RexInputRef as value (not a literal) — should be skipped
        Map<String, String> params = ConversionUtils.extractOptionalParams(topCall, 2);  
            new FieldStorageInfo("body", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
     * Tests that extractOptionalParams extracts multiple key-value pairs from MAP operands.
     * Tests that extractOptionalParams returns an empty map when startIndex exceeds operand count.
import org.apache.calcite.rel.type.RelDataTypeFactory;  
     */
        // Query MAP: MAP('query', 'hello')
            rexBuilder.makeLiteral("hello")  
        ConversionUtils.RelevanceOperands operands = ConversionUtils.extractRelevanceOperands(topCall, fieldStorage);  
        assertEquals("title", result.get(0));
    public void testExtractMapKey_returnsKeyFromMapCall() {  
        // Structure: MAP('fields', 'not_a_map') — value is a literal, not a nested RexCall  
        ReturnTypes.BOOLEAN,  
            rexBuilder.makeLiteral("field"),  
/**
        // Structure: MAP('field', $0, 'field', $1) — RexInputRef-based multi-field
    @Override  
import org.apache.calcite.rex.RexNode;  
     * Validates Requirement 9.3.  
        );
    public void testMultiFieldExtractionReturnsAllFieldsInOrder() {
        );
            new FieldStorageInfo("status", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexCall topCall = (RexCall) rexBuilder.makeCall(MULTI_MATCH_FUNCTION, outerMap, queryMap);
import org.apache.calcite.rex.RexCall;
            rexBuilder.makeLiteral("analyzer"),
            rexBuilder.makeLiteral("query"),  
import org.apache.calcite.rex.RexBuilder;
            rexBuilder.makeLiteral("field"),  
}
    private RexBuilder rexBuilder;
        assertEquals("standard", params.get("analyzer"));  
        RexNode queryMap = rexBuilder.makeCall(
    // --- Tests for extractRelevanceOperands ---  
        // A valid MAP param  
        RexNode boostLiteral = rexBuilder.makeExactLiteral(new BigDecimal("1.0"), doubleType);  
    /**
    }  
            rexBuilder.makeLiteral("query"),
        );  
            exception.getMessage().contains("Cannot extract field names from operand 0")
     * Validates Requirement 9.2.
            rexBuilder.makeLiteral("field"),
    /**
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexNode queryMap = rexBuilder.makeCall(
            new FieldStorageInfo("status", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)  
            rexBuilder.makeLiteral("operator"),
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
     */
        assertEquals("Should return exactly one field", 1, result.size());
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("Should return exactly two fields", 2, result.size());
        assertEquals("title", result.get(0));
        // Direct operands without MAP wrappers
    /**  
        null,
            rexBuilder.makeLiteral("whitespace")  
        RexNode outerMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, fieldsKeyLiteral, nestedMap);
     */
        );  
import java.util.List;
    }
    private RelDataTypeFactory typeFactory;  
    /**
        RexNode queryMap = rexBuilder.makeCall(
import java.math.BigDecimal;  
            IllegalArgumentException.class,
    public void testExtractOptionalParams_emptyWhenStartIndexExceedsOperandCount() {
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            rexBuilder.makeLiteral("query"),  
            () -> ConversionUtils.extractFieldsFromRelevanceMap(topCall, 0, fieldStorage)  
import org.apache.calcite.sql.SqlKind;  
        // RexLiteral is not a RexCall, so extractMapKey should return null
        RexNode ref0 = rexBuilder.makeInputRef(varcharType, 0);  
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, fieldMap, queryMap, operatorMap, analyzerMap);  
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        assertEquals("AND", params.get("operator"));
     * Tests that extractOptionalParams silently skips non-MAP operands (e.g. plain RexLiteral).  
        RexNode literal = rexBuilder.makeLiteral("hello");
        RexNode fieldMap = rexBuilder.makeCall(
            rexBuilder.makeLiteral("operator"),  
import org.apache.calcite.sql.type.SqlTypeName;
     */
        OperandTypes.ANY,
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, fieldMap, queryMap);
     * Tests that extractRelevanceOperands handles a query-only MAP structure (no field MAP).  
    }  
        );
        assertEquals("body", result.get(1));
        RexNode ref1 = rexBuilder.makeInputRef(varcharType, 1);
package org.opensearch.be.lucene;
        );
        // Structure: MAP('fields', MAP('title', 2.0, 'body', 1.0, 'tags', 0.5))
        null,
     * when the operand uses the MAP('field', $ref1, 'field', $ref2, ...) structure.
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, fieldMap, queryMap, operatorMap, plainLiteral);
        RexNode queryMap = rexBuilder.makeCall(  
        ConversionUtils.RelevanceOperands operands = ConversionUtils.extractRelevanceOperands(topCall, fieldStorage);  
    /**  
            rexBuilder.makeLiteral("field"),  
            titleBoost,
    }  
        RexNode nestedMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, fieldNameLiteral, boostLiteral);
        );
     * Tests that extractRelevanceOperands correctly extracts field and query from MAP-wrapped operands.  
            rexBuilder.makeLiteral("query"),
        );
    /**
/*  
    /**  
        List<FieldStorageInfo> fieldStorage = List.of(  
            rexBuilder.makeLiteral("query"),
        assertNull(operands.fields());  
        assertEquals("hello", operands.query());
     * Should return fieldName=null, fields=null, query="brewing".
     * Tests that extractMapKey returns the key string from a MAP_VALUE_CONSTRUCTOR operand.
        );  
        "MULTI_MATCH",
    );
        // FieldStorageInfo list maps index 0 → "title", index 1 → "body"
        RexCall topCall = (RexCall) rexBuilder.makeCall(QUERY_STRING_FUNCTION, queryMap);
     * nested MAP operand contains multiple field name/boost pairs.
            rexBuilder.makeLiteral("bad_param"),
            rexBuilder.makeLiteral("hello")
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        );
import org.opensearch.analytics.spi.FieldStorageInfo;
 *
     * operand contains no resolvable field references.
            rexBuilder.makeLiteral("brewing")
        );
        RexNode fieldMap = rexBuilder.makeCall(  
     * Structure: MATCH(MAP('field', $0), MAP('query', 'hello'))  
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);  
        assertEquals("body", result.get(1));  
        assertEquals("AND", params.get("operator"));  
     * Structure: MATCH(MAP('field', $0), MAP('query', 'hello'))
        "MATCH",
            rexBuilder.makeLiteral("query"),  
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        );
import java.util.Map;
    /**
     */  
        RexNode fieldMap = rexBuilder.makeCall(  
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
     * Validates Requirement 11.10.
        OperandTypes.ANY,
        String key = ConversionUtils.extractMapKey(topCall, 0);
            rexBuilder.makeLiteral("AND")  
    /**
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, fieldMap, queryMap, mapWithRef, validMap);  
 */  
     * Should resolve fieldName from fieldStorage and query from the literal.
    private static final SqlFunction QUERY_STRING_FUNCTION = new SqlFunction(  
        assertNull(ConversionUtils.extractMapKey(topCall, 1));  
        typeFactory = new JavaTypeFactoryImpl();  
        List<FieldStorageInfo> fieldStorage = List.of();
        super.setUp();
        RexCall topCall = (RexCall) rexBuilder.makeCall(MULTI_MATCH_FUNCTION, fieldMap, queryMap);  
        );
 * The OpenSearch Contributors require contributions made to  
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
        );
     * Validates Requirement 11.9.
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            rexBuilder.makeInputRef(varcharType, 0)
import org.apache.calcite.sql.SqlFunction;
     */  
     */  
            rexBuilder.makeLiteral("hello")
import org.apache.calcite.sql.SqlFunctionCategory;
        RexNode outerMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, rexBuilder.makeLiteral("fields"), nestedMap);  
        );
            rexBuilder.makeLiteral("query"),
    // --- Tests for extractMapKey ---
        List<FieldStorageInfo> fieldStorage = List.of(
        RexNode fieldNameLiteral = rexBuilder.makeLiteral("title");
        Map<String, String> params = ConversionUtils.extractOptionalParams(topCall, 2);  
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            rexBuilder.makeInputRef(varcharType, 0)  
     */
        RexNode bodyBoost = rexBuilder.makeExactLiteral(new BigDecimal("1.0"), doubleType);
        RexNode validMap = rexBuilder.makeCall(  
        List<String> result = ConversionUtils.extractFieldsFromRelevanceMap(topCall, 0, fieldStorage);
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
            rexBuilder.makeLiteral("search text")  
        RexNode fieldMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, key1, ref0, key2, ref1);
    }
     * extractMapKey(call, 0) should return "field".
        assertNull(operands.fields());  
    }  
            rexBuilder.makeLiteral("query"),
        RexNode analyzerMap = rexBuilder.makeCall(  
    public void testExtractRelevanceOperands_positionalFallback() {
    }
        ReturnTypes.BOOLEAN,  
        assertEquals("title", result.get(0));  
        RexNode queryMap = rexBuilder.makeCall(  
        assertEquals("tags", result.get(2));
            rexBuilder.makeLiteral("field"),
            tagsLiteral,
        RexNode queryMap = rexBuilder.makeCall(
        assertEquals("hello", operands.query());
        assertEquals("brewing", operands.query());
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexNode inputRef = rexBuilder.makeInputRef(varcharType, 0);  
     * Tests that extractFieldsFromRelevanceMap works with the RexInputRef fallback path  
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        List<FieldStorageInfo> fieldStorage = List.of();
        );
            tagsBoost
    }  
    /**
import org.apache.calcite.sql.type.ReturnTypes;  
            rexBuilder.makeLiteral("test query")  
        assertEquals("whitespace", params.get("analyzer"));
        // Query MAP
        RexNode queryMap = rexBuilder.makeCall(
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
    /**
        // A plain literal (not a MAP) — should be skipped
        // Nested MAP with 3 field/boost pairs  
    public void testSingleFieldExtractionReturnsOneElementList() {  
        RexNode operatorMap = rexBuilder.makeCall(  
        assertEquals("status", operands.fieldName());
        RexNode queryMap = rexBuilder.makeCall(  
     */
        // FieldStorageInfo list is not used in the nested MAP path (literal field names)
            "Exception message should mention operand index",  
        // Outer MAP: MAP('fields', nestedMap)
    private static final SqlFunction MULTI_MATCH_FUNCTION = new SqlFunction(  
        RexNode fieldMap = rexBuilder.makeCall(
            rexBuilder.makeInputRef(varcharType, 0)
public class ConversionUtilsTests extends OpenSearchTestCase {
     * Tests that extractMapKey returns null when the operand is a plain RexInputRef (not a MAP).
        assertTrue("Should return empty map when no optional params", params.isEmpty());
     */  
        null,
        RexNode key2 = rexBuilder.makeLiteral("field");
        RexNode literal = rexBuilder.makeLiteral("hello");
    /**  
        assertEquals("Should return exactly three fields", 3, result.size());
 * compatible open source license.
    );
    }
        );
    public void testExtractRelevanceOperands_mapWrappedFieldAndQuery() {
     * Validates Requirement 11.1.
            rexBuilder.makeLiteral("fields"),  
     */  
            rexBuilder.makeLiteral("AND")
    }
        rexBuilder = new RexBuilder(typeFactory);
            rexBuilder.makeInputRef(varcharType, 0)  
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
    }
        assertNull(ConversionUtils.extractMapKey(topCall, 0));
    public void testExtractRelevanceOperands_queryOnlyNoField() {
        IllegalArgumentException exception = expectThrows(
        ReturnTypes.BOOLEAN,  
        RexNode key1 = rexBuilder.makeLiteral("field");
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            bodyBoost,  
        );
            rexBuilder.makeInputRef(varcharType, 0)  
            rexBuilder.makeLiteral("standard")  
        RexNode bodyLiteral = rexBuilder.makeLiteral("body");
     * Tests that extractRelevanceOperands falls back to positional extraction when operands
        List<String> result = ConversionUtils.extractFieldsFromRelevanceMap(topCall, 0, fieldStorage);  
        RexNode titleBoost = rexBuilder.makeExactLiteral(new BigDecimal("2.0"), doubleType);  
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        "QUERY_STRING",
        RexNode queryMap = rexBuilder.makeCall(
        Map<String, String> params = ConversionUtils.extractOptionalParams(topCall, 2);
        );
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexCall topCall = (RexCall) rexBuilder.makeCall(MULTI_MATCH_FUNCTION, outerMap, queryMap);  
     * Structure: query_string(MAP('query', 'brewing'))
 * this file be licensed under the Apache-2.0 license or a
        RexNode queryMap = rexBuilder.makeCall(  
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            rexBuilder.makeInputRef(varcharType, 0)
            rexBuilder.makeLiteral("hello")  
        );  
    public void testNoFieldsThrowsIllegalArgumentException() {
     * Structure: MATCH(MAP('field', $0), MAP('query', 'hello'), MAP('operator', 'AND'), MAP('analyzer', 'standard'))
        assertEquals("Should only extract the valid MAP param", 1, params.size());
     * nested MAP operand contains exactly one field name/boost pair.  
        assertEquals(2, params.size());
        SqlKind.OTHER_FUNCTION,
        RexCall topCall = (RexCall) rexBuilder.makeCall(MULTI_MATCH_FUNCTION, outerMap, queryMap);  
        RexNode nestedMap = rexBuilder.makeCall(
        List<String> result = ConversionUtils.extractFieldsFromRelevanceMap(topCall, 0, fieldStorage);
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
        );
        // Direct RexInputRef operand (no MAP wrapper)  
            rexBuilder.makeLiteral("not_a_map")
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, inputRef, literal);  
        );
        RexNode outerMap = rexBuilder.makeCall(
     * Tests that extractFieldsFromRelevanceMap returns a single-element list when the
    /**  
    public void testExtractMapKey_returnsNullForNonMapOperand() {  
        RexNode fieldMap = rexBuilder.makeCall(  
     */
    }  
import org.apache.calcite.rel.type.RelDataType;
        );
        );
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
    }
        Map<String, String> params = ConversionUtils.extractOptionalParams(topCall, 2);
            bodyLiteral,
        assertNull(operands.fields());
    // --- Tests for extractOptionalParams ---
     * are not MAP-wrapped (e.g. MATCH($0, 'hello') with direct RexInputRef and RexLiteral).  
        RexNode tagsLiteral = rexBuilder.makeLiteral("tags");  
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, fieldMap, queryMap);  
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexNode titleLiteral = rexBuilder.makeLiteral("title");
    private static final SqlFunction MATCH_FUNCTION = new SqlFunction(  
     * Validates Requirement 11.10.
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        OperandTypes.ANY,
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        // Top-level call: MULTI_MATCH(outerMap, queryMap)
        // Structure: MULTI_MATCH(MAP('fields', MAP('title', 1.0)), MAP('query', 'hello'))
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
        );  
        SqlKind.OTHER_FUNCTION,
        // Outer MAP: MAP('fields', nestedMap)  
            rexBuilder.makeLiteral("test")
    }
        // A valid MAP param
        assertEquals("field", key);  
        RexNode operatorMap = rexBuilder.makeCall(
    public void setUp() throws Exception {
        RexNode fieldMap = rexBuilder.makeCall(
            rexBuilder.makeLiteral("hello")
            rexBuilder.makeLiteral("analyzer"),
            rexBuilder.makeLiteral("hello")
     * extractOptionalParams(call, 2) should return {"operator": "AND", "analyzer": "standard"}.  
            rexBuilder.makeLiteral("query"),
    public void testExtractOptionalParams_multipleKeyValuePairs() {  
     * Tests that extractFieldsFromRelevanceMap throws IllegalArgumentException when the
            rexBuilder.makeInputRef(varcharType, 0)
        ConversionUtils.RelevanceOperands operands = ConversionUtils.extractRelevanceOperands(topCall, fieldStorage);
     * Validates Requirement 9.1.
        // Inner nested MAP: field name literal + boost literal (boost ignored, only field name extracted)
        RexNode tagsBoost = rexBuilder.makeExactLiteral(new BigDecimal("0.5"), doubleType);
        RexNode mapWithRef = rexBuilder.makeCall(
 * SPDX-License-Identifier: Apache-2.0
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        SqlKind.OTHER_FUNCTION,
 */  
     * Tests that extractFieldsFromRelevanceMap returns all fields in order when the  
        );
 * Unit tests for {@link ConversionUtils}.
    public void testMultiFieldExtractionWithRexInputRefFallback() {
        List<FieldStorageInfo> fieldStorage = List.of();  
import org.opensearch.analytics.spi.FieldType;  
        assertEquals("status", operands.fieldName());  
     * Tests that extractOptionalParams silently skips MAP operands with non-literal children.
            titleLiteral,  
            rexBuilder.makeLiteral("query"),
    );
            new FieldStorageInfo("title", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false),
        );
        );
        );
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            rexBuilder.makeLiteral("field"),
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, inputRef, literal);
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
            rexBuilder.makeLiteral("hello")  
        RexNode inputRef = rexBuilder.makeInputRef(varcharType, 0);
        assertTrue(
    public void testExtractOptionalParams_skipsMapWithNonLiteralChildren() {
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        List<FieldStorageInfo> fieldStorage = List.of(  
        RexNode queryMap = rexBuilder.makeCall(  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;

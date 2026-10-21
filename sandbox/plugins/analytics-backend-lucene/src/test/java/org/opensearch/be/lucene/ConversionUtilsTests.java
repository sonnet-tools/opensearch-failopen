        );
            rexBuilder.makeLiteral("hello")
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            rexBuilder.makeLiteral("query"),
        List<String> result = ConversionUtils.extractFieldsFromRelevanceMap(topCall, 0, fieldStorage);
     * nested MAP operand contains exactly one field name/boost pair.
        // Query MAP
            titleBoost,
            rexBuilder.makeLiteral("query"),
    }
        ConversionUtils.RelevanceOperands operands = ConversionUtils.extractRelevanceOperands(topCall, fieldStorage);
            rexBuilder.makeLiteral("test query")
        "MULTI_MATCH",
    public void testExtractRelevanceOperands_mapWrappedFieldAndQuery() {
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        );
        RexNode operatorMap = rexBuilder.makeCall(
    public void testExtractOptionalParams_emptyWhenStartIndexExceedsOperandCount() {
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            new FieldStorageInfo("body", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexNode fieldMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, key1, ref0, key2, ref1);
import org.apache.calcite.sql.SqlFunction;
        RexNode fieldsKeyLiteral = rexBuilder.makeLiteral("fields");
        Map<String, String> params = ConversionUtils.extractOptionalParams(topCall, 2);
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        );
            rexBuilder.makeLiteral("search text")
        OperandTypes.ANY,
     * extractMapKey(call, 0) should return "field".
    public void testNoFieldsThrowsIllegalArgumentException() {
        RexNode key2 = rexBuilder.makeLiteral("field");
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexNode validMap = rexBuilder.makeCall(
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexNode tagsBoost = rexBuilder.makeExactLiteral(new BigDecimal("0.5"), doubleType);
        super.setUp();
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
        assertNull(operands.fields());
        // FieldStorageInfo list maps index 0 → "title", index 1 → "body"
            rexBuilder.makeLiteral("hello")
    private RexBuilder rexBuilder;
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
     */
import org.apache.calcite.rex.RexCall;
    /**
        );
     * Tests that extractOptionalParams silently skips MAP operands with non-literal children.
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        assertNull(ConversionUtils.extractMapKey(topCall, 1));
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            rexBuilder.makeLiteral("not_a_map")
            rexBuilder.makeLiteral("bad_param"),
/*
        RexNode bodyBoost = rexBuilder.makeExactLiteral(new BigDecimal("1.0"), doubleType);
import org.opensearch.test.OpenSearchTestCase;
    }
 * The OpenSearch Contributors require contributions made to
        );
import org.apache.calcite.sql.type.SqlTypeName;
            rexBuilder.makeInputRef(varcharType, 0)
            rexBuilder.makeLiteral("analyzer"),
     * Validates Requirement 11.1.
            rexBuilder.makeLiteral("standard")
    public void testExtractMapKey_returnsNullForNonMapOperand() {
        RexNode nestedMap = rexBuilder.makeCall(
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode fieldMap = rexBuilder.makeCall(
            rexBuilder.makeInputRef(varcharType, 0)
 * this file be licensed under the Apache-2.0 license or a
        RexNode key1 = rexBuilder.makeLiteral("field");
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        );
import org.opensearch.analytics.spi.FieldType;
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexNode titleLiteral = rexBuilder.makeLiteral("title");
        ReturnTypes.BOOLEAN,
        assertEquals("field", key);
        List<FieldStorageInfo> fieldStorage = List.of(
    private static final SqlFunction MATCH_FUNCTION = new SqlFunction(
     */
            rexBuilder.makeLiteral("field"),
     * Tests that extractRelevanceOperands falls back to positional extraction when operands
        // A valid MAP param
            tagsLiteral,
    public void testExtractOptionalParams_skipsNonMapOperands() {
    }
        // A valid MAP param
        );
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
     * Tests that extractRelevanceOperands handles a query-only MAP structure (no field MAP).
        );
        assertEquals("AND", params.get("operator"));
            rexBuilder.makeInputRef(varcharType, 0)
     * Validates Requirement 11.10.
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, inputRef, literal);
        );
        assertNull(operands.fields());
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            rexBuilder.makeLiteral("field"),
        ReturnTypes.BOOLEAN,
        );
        assertEquals("Should only extract the valid MAP param", 1, params.size());
    // --- Tests for extractOptionalParams ---
     * extractOptionalParams(call, 2) should return {"operator": "AND", "analyzer": "standard"}.
    public void testSingleFieldExtractionReturnsOneElementList() {
        // Structure: MAP('field', $0, 'field', $1) — RexInputRef-based multi-field
    public void testMultiFieldExtractionReturnsAllFieldsInOrder() {
        Map<String, String> params = ConversionUtils.extractOptionalParams(topCall, 2);
        assertEquals("hello", operands.query());
        SqlKind.OTHER_FUNCTION,
    /**
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, fieldMap, queryMap, operatorMap, analyzerMap);
     */
    /**
            rexBuilder.makeInputRef(varcharType, 0)
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
    /**
            rexBuilder.makeLiteral("hello")
        assertEquals("whitespace", params.get("analyzer"));
    public void testMultiFieldExtractionWithRexInputRefFallback() {
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        );
     */
        assertNull(operands.fields());
        RexNode queryMap = rexBuilder.makeCall(
     */
     * Structure: query_string(MAP('query', 'brewing'))
    // --- Tests for extractMapKey ---
    }
    }
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, fieldMap, queryMap);
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
    /**
        // Query MAP: MAP('query', 'hello')
     * Tests that extractFieldsFromRelevanceMap works with the RexInputRef fallback path
 * SPDX-License-Identifier: Apache-2.0
        RexNode queryMap = rexBuilder.makeCall(
import org.apache.calcite.rex.RexNode;
        RexNode fieldNameLiteral = rexBuilder.makeLiteral("title");
     */
            tagsBoost
        // FieldStorageInfo list is not used in the nested MAP path (literal field names)
import org.opensearch.analytics.spi.FieldStorageInfo;
    private RelDataTypeFactory typeFactory;
        assertEquals("tags", result.get(2));
        );
    /**
        RexNode queryMap = rexBuilder.makeCall(
    }
        RexNode queryMap = rexBuilder.makeCall(
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        assertEquals("title", result.get(0));
        RexNode inputRef = rexBuilder.makeInputRef(varcharType, 0);
    }
            rexBuilder.makeLiteral("query"),
        assertEquals("Should return exactly three fields", 3, result.size());
        );
import org.apache.calcite.sql.type.ReturnTypes;
import java.util.Map;
        // Top-level call: MULTI_MATCH(outerMap, queryMap)
        assertEquals("standard", params.get("analyzer"));
     * Tests that extractMapKey returns the key string from a MAP_VALUE_CONSTRUCTOR operand.
        assertNull(operands.fieldName());
    );
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
import org.apache.calcite.rel.type.RelDataTypeFactory;
     */
     * Tests that extractOptionalParams returns an empty map when startIndex exceeds operand count.
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, fieldMap, queryMap, operatorMap, plainLiteral);
            rexBuilder.makeLiteral("hello")
        RexNode fieldMap = rexBuilder.makeCall(
     * Validates Requirement 9.1.
        RexNode tagsLiteral = rexBuilder.makeLiteral("tags");
            rexBuilder.makeLiteral("query"),
            new FieldStorageInfo("status", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, fieldMap, queryMap);
        typeFactory = new JavaTypeFactoryImpl();
        );
            rexBuilder.makeLiteral("brewing")
        RexNode queryMap = rexBuilder.makeCall(
        RexNode ref0 = rexBuilder.makeInputRef(varcharType, 0);
        // Structure: MAP('fields', MAP('title', 2.0, 'body', 1.0, 'tags', 0.5))
        RexNode operatorMap = rexBuilder.makeCall(
            new FieldStorageInfo("status", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
        RexNode outerMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, fieldsKeyLiteral, nestedMap);
        assertNull(ConversionUtils.extractMapKey(topCall, 0));
    /**
    }
    /**
    }
        );
    public void testExtractOptionalParams_multipleKeyValuePairs() {
        rexBuilder = new RexBuilder(typeFactory);
        RexNode queryMap = rexBuilder.makeCall(
        );
            rexBuilder.makeLiteral("field"),
            bodyBoost,
    }
        assertEquals("body", result.get(1));
        RexNode nestedMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, fieldNameLiteral, boostLiteral);
        );
        null,
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            exception.getMessage().contains("Cannot extract field names from operand 0")
import org.apache.calcite.rel.type.RelDataType;
     * Validates Requirement 9.2.
     * operand contains no resolvable field references.
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            rexBuilder.makeInputRef(varcharType, 0)
            bodyLiteral,
        RexNode plainLiteral = rexBuilder.makeLiteral("stray_value");
        );
        // Inner nested MAP: field name literal + boost literal (boost ignored, only field name extracted)
}
     */
        Map<String, String> params = ConversionUtils.extractOptionalParams(topCall, 2);
        );
        );
        RexCall topCall = (RexCall) rexBuilder.makeCall(MULTI_MATCH_FUNCTION, outerMap, queryMap);
        );
import org.apache.calcite.sql.SqlFunctionCategory;
        assertEquals("brewing", operands.query());
    public void testExtractRelevanceOperands_queryOnlyNoField() {
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            "Exception message should mention operand index",
        SqlFunctionCategory.USER_DEFINED_FUNCTION
    }
        "MATCH",
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        List<FieldStorageInfo> fieldStorage = List.of();
        RexNode queryMap = rexBuilder.makeCall(
        List<FieldStorageInfo> fieldStorage = List.of(
 *
        Map<String, String> params = ConversionUtils.extractOptionalParams(topCall, 2);
        RexCall topCall = (RexCall) rexBuilder.makeCall(MULTI_MATCH_FUNCTION, outerMap, queryMap);
            rexBuilder.makeLiteral("whitespace")
        );
import org.apache.calcite.sql.type.OperandTypes;
        );
import java.math.BigDecimal;
        RexNode outerMap = rexBuilder.makeCall(
        RexNode analyzerMap = rexBuilder.makeCall(
        RexNode queryMap = rexBuilder.makeCall(
            new FieldStorageInfo("title", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false),
    /**
            rexBuilder.makeLiteral("AND")
        "QUERY_STRING",
        assertTrue(
            rexBuilder.makeLiteral("hello")
            rexBuilder.makeLiteral("AND")
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
     */
public class ConversionUtilsTests extends OpenSearchTestCase {
        RexNode queryMap = rexBuilder.makeCall(
    }
        RexCall topCall = (RexCall) rexBuilder.makeCall(QUERY_STRING_FUNCTION, queryMap);
     */
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, fieldMap, queryMap);
        );
     * Tests that extractMapKey returns null when the operand is a plain RexInputRef (not a MAP).
            rexBuilder.makeLiteral("hello")
 */
        RexCall topCall = (RexCall) rexBuilder.makeCall(MULTI_MATCH_FUNCTION, fieldMap, queryMap);
    // --- Tests for extractRelevanceOperands ---
        assertEquals(2, params.size());
        );
        null,
    );
    @Override
        assertEquals("title", result.get(0));
        null,
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        // Outer MAP: MAP('fields', nestedMap)
     * Validates Requirement 9.1 (fallback path).
        // Structure: MULTI_MATCH(MAP('fields', MAP('title', 1.0)), MAP('query', 'hello'))
        List<FieldStorageInfo> fieldStorage = List.of();
        assertTrue("Should return empty map when no optional params", params.isEmpty());
        RexNode ref1 = rexBuilder.makeInputRef(varcharType, 1);
    }
        List<String> result = ConversionUtils.extractFieldsFromRelevanceMap(topCall, 0, fieldStorage);
        RexNode literal = rexBuilder.makeLiteral("hello");
        RexCall topCall = (RexCall) rexBuilder.makeCall(MULTI_MATCH_FUNCTION, outerMap, queryMap);
        OperandTypes.ANY,
        SqlKind.OTHER_FUNCTION,
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, inputRef, literal);
     * Should return fieldName=null, fields=null, query="brewing".
        // MAP with a RexInputRef as value (not a literal) — should be skipped
        assertEquals("AND", params.get("operator"));
    /**
import org.apache.calcite.rex.RexBuilder;
        // Nested MAP with 3 field/boost pairs
import java.util.List;
     * when the operand uses the MAP('field', $ref1, 'field', $ref2, ...) structure.
        List<FieldStorageInfo> fieldStorage = List.of();
        );
        RexNode fieldMap = rexBuilder.makeCall(
    );
        );
        // Structure: MAP('fields', 'not_a_map') — value is a literal, not a nested RexCall
        // A plain literal (not a MAP) — should be skipped
        SqlKind.OTHER_FUNCTION,
    }
        // Direct RexInputRef operand (no MAP wrapper)
        // Direct operands without MAP wrappers
     * Validates Requirement 9.3.
            rexBuilder.makeLiteral("query"),
        );
            rexBuilder.makeLiteral("analyzer"),
        ReturnTypes.BOOLEAN,
import org.apache.calcite.sql.SqlKind;
            rexBuilder.makeLiteral("query"),
     */
        assertEquals("Should return exactly one field", 1, result.size());
        // RexInputRef is not a RexCall, so extractMapKey should return null
            () -> ConversionUtils.extractFieldsFromRelevanceMap(topCall, 0, fieldStorage)
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexNode boostLiteral = rexBuilder.makeExactLiteral(new BigDecimal("1.0"), doubleType);
            rexBuilder.makeInputRef(varcharType, 0)
        List<FieldStorageInfo> fieldStorage = List.of();
     * are not MAP-wrapped (e.g. MATCH($0, 'hello') with direct RexInputRef and RexLiteral).
            rexBuilder.makeLiteral("fields"),
        RexNode inputRef = rexBuilder.makeInputRef(varcharType, 0);
            rexBuilder.makeLiteral("operator"),
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        // RexLiteral is not a RexCall, so extractMapKey should return null
        RexNode mapWithRef = rexBuilder.makeCall(
    private static final SqlFunction MULTI_MATCH_FUNCTION = new SqlFunction(
        RexNode queryMap = rexBuilder.makeCall(
    private static final SqlFunction QUERY_STRING_FUNCTION = new SqlFunction(
        // Outer MAP: MAP('fields', nestedMap)
     * Structure: MATCH(MAP('field', $0), MAP('query', 'hello'))
            titleLiteral,
        );
            rexBuilder.makeLiteral("query"),
        RexNode fieldMap = rexBuilder.makeCall(
    public void testExtractMapKey_returnsKeyFromMapCall() {
    public void testExtractRelevanceOperands_positionalFallback() {
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
     * Validates Requirement 11.9.
        RexNode bodyLiteral = rexBuilder.makeLiteral("body");
        RexNode queryMap = rexBuilder.makeCall(
        assertEquals("Should return exactly two fields", 2, result.size());
 * compatible open source license.
     * Tests that extractOptionalParams extracts multiple key-value pairs from MAP operands.
    /**
        assertEquals("hello", operands.query());
 * Unit tests for {@link ConversionUtils}.
        SqlFunctionCategory.USER_DEFINED_FUNCTION
            rexBuilder.makeLiteral("query"),
        assertEquals("status", operands.fieldName());
            rexBuilder.makeLiteral("field"),
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
     */
            rexBuilder.makeLiteral("field"),
/**
     * Tests that extractFieldsFromRelevanceMap returns all fields in order when the
            rexBuilder.makeLiteral("operator"),
     */
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        IllegalArgumentException exception = expectThrows(
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            rexBuilder.makeLiteral("query"),
        RexCall topCall = (RexCall) rexBuilder.makeCall(MATCH_FUNCTION, fieldMap, queryMap, mapWithRef, validMap);
            IllegalArgumentException.class,
    public void testExtractOptionalParams_skipsMapWithNonLiteralChildren() {
     * Should resolve fieldName from fieldStorage and query from the literal.
        RexNode titleBoost = rexBuilder.makeExactLiteral(new BigDecimal("2.0"), doubleType);
        assertEquals("title", result.get(0));
     * Structure: MATCH(MAP('field', $0), MAP('query', 'hello'), MAP('operator', 'AND'), MAP('analyzer', 'standard'))
        RexNode fieldMap = rexBuilder.makeCall(
            rexBuilder.makeLiteral("hello")
            rexBuilder.makeLiteral("field"),
     * Tests that extractRelevanceOperands correctly extracts field and query from MAP-wrapped operands.
     * Structure: MATCH(MAP('field', $0), MAP('query', 'hello'))
        String key = ConversionUtils.extractMapKey(topCall, 0);
     * Tests that extractFieldsFromRelevanceMap throws IllegalArgumentException when the
        assertEquals("body", result.get(1));
        RexNode outerMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, rexBuilder.makeLiteral("fields"), nestedMap);
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        ConversionUtils.RelevanceOperands operands = ConversionUtils.extractRelevanceOperands(topCall, fieldStorage);
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        List<FieldStorageInfo> fieldStorage = List.of(
        ConversionUtils.RelevanceOperands operands = ConversionUtils.extractRelevanceOperands(topCall, fieldStorage);
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
 */
        RexNode literal = rexBuilder.makeLiteral("hello");
        assertEquals("Should only extract the valid MAP param", 1, params.size());
     * nested MAP operand contains multiple field name/boost pairs.
    /**
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
package org.opensearch.be.lucene;
    public void setUp() throws Exception {
            rexBuilder.makeLiteral("query"),
            rexBuilder.makeInputRef(varcharType, 0)
    /**
            rexBuilder.makeLiteral("test")
     * Tests that extractOptionalParams silently skips non-MAP operands (e.g. plain RexLiteral).
        assertEquals("status", operands.fieldName());
        List<String> result = ConversionUtils.extractFieldsFromRelevanceMap(topCall, 0, fieldStorage);
            rexBuilder.makeLiteral("query"),
        OperandTypes.ANY,
     * Validates Requirement 11.10.
     * Tests that extractFieldsFromRelevanceMap returns a single-element list when the
        RexNode fieldMap = rexBuilder.makeCall(

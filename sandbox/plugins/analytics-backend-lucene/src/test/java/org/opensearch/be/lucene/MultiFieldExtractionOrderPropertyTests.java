        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
import org.apache.calcite.sql.SqlFunction;
    }
    public void testExtractionPreservesOrderRexInputRefPath() {
     */
        // Build MAP operands: 'field', $0, 'field', $1, ...
 * compatible open source license.
        for (String fieldName : expectedFields) {
 */
package org.opensearch.be.lucene;
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to
            nestedMapOperands.add(rexBuilder.makeExactLiteral(new BigDecimal("1.0"), doubleType));
     * Builds a mock RexCall using the nested MAP literal structure:
     */
     * Builds a mock RexCall using the RexInputRef fallback structure:
     *
        List<String> expectedFields = generateUniqueFieldNames(fieldCount);
     * invoke extractFieldsFromRelevanceMap, and assert the returned list matches expected field names
     * The MAP has alternating key literals ('field') at even indices and RexInputRef at odd indices.
        SqlKind.OTHER_FUNCTION,
     * Generate a random list of 1-10 field names, construct a mock MAP_VALUE_CONSTRUCTOR RexCall
    private RexBuilder rexBuilder;
        RexNode outerMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, rexBuilder.makeLiteral("fields"), nestedMap);
import org.apache.calcite.sql.SqlKind;
        List<String> result = ConversionUtils.extractFieldsFromRelevanceMap(call, 0, fieldStorage);
 *
        ReturnTypes.BOOLEAN,
        "MULTI_MATCH",
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        // Query MAP: MAP('query', 'text')
        List<FieldStorageInfo> fieldStorage = List.of(); // not used in nested MAP literal path
            fieldStorage.add(new FieldStorageInfo(fieldName, "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false));
     * invoke extractFieldsFromRelevanceMap, and assert the returned list matches expected field names
        RexNode queryMap = rexBuilder.makeCall(
/*
            assertEquals("field at index " + i + " mismatch", expectedFields.get(i), result.get(i));
import java.util.List;
        for (int i = 0; i < fieldCount; i++) {
    private RexCall buildNestedMapLiteralCall(List<String> fieldNames) {
        return names;
 *
 */
        for (String field : fieldNames) {
     */
    }
        null,
        List<RexNode> nestedMapOperands = new ArrayList<>();
    }
        }
 * the field name resolved from the corresponding FieldStorageInfo entry, in the same order as they
     * Generate a random list of 1-10 field names, construct a mock MAP_VALUE_CONSTRUCTOR RexCall
        List<String> expectedFields = generateUniqueFieldNames(fieldCount);
        super.setUp();
            mapOperands.add(rexBuilder.makeLiteral("field"));
            rexBuilder.makeLiteral("test query")
    /**
            rexBuilder.makeLiteral("query"),
     *
 *
    /**
import org.apache.calcite.rel.type.RelDataType;
        assertEquals("field count mismatch", expectedFields.size(), result.size());
 * this file be licensed under the Apache-2.0 license or a
        );
        for (int i = 0; i < expectedFields.size(); i++) {
     * with the nested MAP structure (field name literals at even indices, boost literals at odd indices),
        RexCall call = buildNestedMapLiteralCall(expectedFields);
        rexBuilder = new RexBuilder(typeFactory);
        assertEquals("field count mismatch", expectedFields.size(), result.size());
        List<RexNode> mapOperands = new ArrayList<>();
            rexBuilder.makeLiteral("test query")
        }
        List<FieldStorageInfo> fieldStorage = new ArrayList<>();
import java.util.ArrayList;
    public void setUp() throws Exception {
        int fieldCount = randomIntBetween(1, 10);
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        typeFactory = new JavaTypeFactoryImpl();
    @Override
     * with RexInputRef entries at odd indices and a corresponding FieldStorageInfo list,
        RexCall call = buildRexInputRefCall(fieldCount);
        for (int i = 0; i < expectedFields.size(); i++) {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.SqlFunctionCategory;
            mapOperands.add(rexBuilder.makeInputRef(varcharType, i));
    private RexCall buildRexInputRefCall(int fieldCount) {
        SqlFunctionCategory.USER_DEFINED_FUNCTION
 * <p>Feature: lucene-fulltext-serializers, Property 3: Multi-field extraction preserves all fields in order
import org.apache.calcite.rex.RexNode;
        // Query MAP: MAP('query', 'text')
     * in exact order.
        // Outer MAP: MAP('fields', nestedMap)
        );
    /**
        List<String> result = ConversionUtils.extractFieldsFromRelevanceMap(call, 0, fieldStorage);
            nestedMapOperands.add(rexBuilder.makeLiteral(field));
    private RelDataTypeFactory typeFactory;
        // Nested MAP: MAP_VALUE_CONSTRUCTOR(field1, 1.0, field2, 1.0, ...)
        // Build nested MAP operands: field1, boost1, field2, boost2, ...
 *
     * in exact order.
/**
     * Property 3: Multi-field extraction preserves all fields in order (RexInputRef fallback path).
import org.apache.calcite.rel.type.RelDataTypeFactory;
        RexNode queryMap = rexBuilder.makeCall(
import org.apache.calcite.rex.RexBuilder;
}
                names.add(candidate);
    /**
 * {@code extractFieldsFromRelevanceMap} shall return a list of exactly N field names, each matching
     *
            String candidate = randomAlphaOfLengthBetween(1, 50);
            }
import org.apache.calcite.rex.RexCall;
        }
        RexNode fieldMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, mapOperands.toArray(new RexNode[0]));
        int fieldCount = randomIntBetween(1, 10);
import org.apache.calcite.sql.type.ReturnTypes;
     * The nested MAP has alternating field name literals (even indices) and boost literals (odd indices).
        return (RexCall) rexBuilder.makeCall(MULTI_MATCH_FUNCTION, fieldMap, queryMap);
        }
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
    private static final SqlFunction MULTI_MATCH_FUNCTION = new SqlFunction(
    }
     * Property 3: Multi-field extraction preserves all fields in order (nested MAP literal path).
 * <p>Validates: Requirements 9.1, 9.2
 * Property-based test for multi-field extraction order preservation.
    }
     * Generates a list of unique random field names.
 * SPDX-License-Identifier: Apache-2.0
        RexNode nestedMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, nestedMapOperands.toArray(new RexNode[0]));
     *
        }
        while (names.size() < count) {
            if (names.contains(candidate) == false) {
     * MULTI_MATCH(MAP('fields', MAP('field1', 1.0, 'field2', 1.0, ...)), MAP('query', 'text'))
import java.math.BigDecimal;
 * appear in the operand.
            assertEquals("field at index " + i + " mismatch", expectedFields.get(i), result.get(i));
    );
    private List<String> generateUniqueFieldNames(int count) {
 * <p>For any MAP_VALUE_CONSTRUCTOR RexCall operand containing N >= 1 RexInputRef entries,
     */
        return (RexCall) rexBuilder.makeCall(MULTI_MATCH_FUNCTION, outerMap, queryMap);
import org.apache.calcite.sql.type.OperandTypes;
        List<String> names = new ArrayList<>();
    public void testExtractionPreservesOrderNestedMapLiteralPath() {
     */
    }
     * MULTI_MATCH(MAP('field', $0, 'field', $1, ...), MAP('query', 'text'))
import org.opensearch.analytics.spi.FieldType;
    /**
        OperandTypes.ANY,
public class MultiFieldExtractionOrderPropertyTests extends OpenSearchTestCase {
            rexBuilder.makeLiteral("query"),
import org.opensearch.analytics.spi.FieldStorageInfo;
        }
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);

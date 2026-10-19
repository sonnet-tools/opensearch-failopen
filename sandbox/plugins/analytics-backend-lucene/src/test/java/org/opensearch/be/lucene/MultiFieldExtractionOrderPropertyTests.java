                names.add(candidate);
        RexNode queryMap = rexBuilder.makeCall(
import org.apache.calcite.sql.SqlFunction;
import org.apache.calcite.sql.type.OperandTypes;
     *
            rexBuilder.makeLiteral("test query")
            assertEquals("field at index " + i + " mismatch", expectedFields.get(i), result.get(i));
    /**
import java.util.List;
     * Property 3: Multi-field extraction preserves all fields in order (RexInputRef fallback path).
    public void setUp() throws Exception {
        // Outer MAP: MAP('fields', nestedMap)  
     * Builds a mock RexCall using the RexInputRef fallback structure:
            if (names.contains(candidate) == false) {
    /**  
        }
        OperandTypes.ANY,
     * invoke extractFieldsFromRelevanceMap, and assert the returned list matches expected field names  
     * in exact order.  
        ReturnTypes.BOOLEAN,  
}
        for (int i = 0; i < fieldCount; i++) {  
 * the field name resolved from the corresponding FieldStorageInfo entry, in the same order as they
        return names;
            mapOperands.add(rexBuilder.makeLiteral("field"));
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            }  
    /**  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.spi.FieldType;  
        SqlKind.OTHER_FUNCTION,
import org.apache.calcite.sql.type.ReturnTypes;  
        List<RexNode> nestedMapOperands = new ArrayList<>();  
 */  
import org.apache.calcite.rex.RexNode;  
        }  
import org.apache.calcite.sql.SqlKind;  
public class MultiFieldExtractionOrderPropertyTests extends OpenSearchTestCase {
     * invoke extractFieldsFromRelevanceMap, and assert the returned list matches expected field names
import java.util.ArrayList;
        assertEquals("field count mismatch", expectedFields.size(), result.size());  
 * <p>Validates: Requirements 9.1, 9.2
     * in exact order.
    private RexCall buildRexInputRefCall(int fieldCount) {
        while (names.size() < count) {
        List<String> result = ConversionUtils.extractFieldsFromRelevanceMap(call, 0, fieldStorage);
            rexBuilder.makeLiteral("query"),
 * {@code extractFieldsFromRelevanceMap} shall return a list of exactly N field names, each matching
import org.apache.calcite.sql.type.SqlTypeName;
        null,
        RexNode nestedMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, nestedMapOperands.toArray(new RexNode[0]));
        RexCall call = buildRexInputRefCall(fieldCount);
     *  
     */
     * MULTI_MATCH(MAP('field', $0, 'field', $1, ...), MAP('query', 'text'))  
            rexBuilder.makeLiteral("query"),  
        rexBuilder = new RexBuilder(typeFactory);
import java.math.BigDecimal;  
        );  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.apache.calcite.rex.RexBuilder;
     *
        int fieldCount = randomIntBetween(1, 10);
        RexCall call = buildNestedMapLiteralCall(expectedFields);
 *  
    }  
        List<String> expectedFields = generateUniqueFieldNames(fieldCount);
     * The MAP has alternating key literals ('field') at even indices and RexInputRef at odd indices.
import org.apache.calcite.sql.SqlFunctionCategory;
        RexNode outerMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, rexBuilder.makeLiteral("fields"), nestedMap);
     * with the nested MAP structure (field name literals at even indices, boost literals at odd indices),
/*  
            assertEquals("field at index " + i + " mismatch", expectedFields.get(i), result.get(i));
            fieldStorage.add(new FieldStorageInfo(fieldName, "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false));
    /**
        "MULTI_MATCH",
 * <p>Feature: lucene-fulltext-serializers, Property 3: Multi-field extraction preserves all fields in order
 *
        for (String fieldName : expectedFields) {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        // Build nested MAP operands: field1, boost1, field2, boost2, ...
        RexNode queryMap = rexBuilder.makeCall(
     * The nested MAP has alternating field name literals (even indices) and boost literals (odd indices).  
import org.apache.calcite.rel.type.RelDataType;
    );
    private RelDataTypeFactory typeFactory;  
     * with RexInputRef entries at odd indices and a corresponding FieldStorageInfo list,
     */
    @Override  
        // Build MAP operands: 'field', $0, 'field', $1, ...
    /**
package org.opensearch.be.lucene;
        }  
        for (int i = 0; i < expectedFields.size(); i++) {
        );
 *
        typeFactory = new JavaTypeFactoryImpl();  
     * Property 3: Multi-field extraction preserves all fields in order (nested MAP literal path).
            String candidate = randomAlphaOfLengthBetween(1, 50);  
        }  
 */  
        List<FieldStorageInfo> fieldStorage = new ArrayList<>();  
    }
     *
 * Property-based test for multi-field extraction order preservation.
 *
            nestedMapOperands.add(rexBuilder.makeLiteral(field));
        // Query MAP: MAP('query', 'text')
        }  
/**
        List<RexNode> mapOperands = new ArrayList<>();
     */  
    }
        for (int i = 0; i < expectedFields.size(); i++) {
            rexBuilder.makeLiteral("test query")
        assertEquals("field count mismatch", expectedFields.size(), result.size());  
    }
     * Generate a random list of 1-10 field names, construct a mock MAP_VALUE_CONSTRUCTOR RexCall
     * Generates a list of unique random field names.
        for (String field : fieldNames) {
    private RexBuilder rexBuilder;
        int fieldCount = randomIntBetween(1, 10);  
 * <p>For any MAP_VALUE_CONSTRUCTOR RexCall operand containing N >= 1 RexInputRef entries,  
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    }
    private static final SqlFunction MULTI_MATCH_FUNCTION = new SqlFunction(  
            mapOperands.add(rexBuilder.makeInputRef(varcharType, i));
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.rex.RexCall;
        List<String> expectedFields = generateUniqueFieldNames(fieldCount);
     */
     * MULTI_MATCH(MAP('fields', MAP('field1', 1.0, 'field2', 1.0, ...)), MAP('query', 'text'))
        List<FieldStorageInfo> fieldStorage = List.of(); // not used in nested MAP literal path
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
import org.opensearch.analytics.spi.FieldStorageInfo;
        List<String> names = new ArrayList<>();
    public void testExtractionPreservesOrderRexInputRefPath() {
        }
     * Generate a random list of 1-10 field names, construct a mock MAP_VALUE_CONSTRUCTOR RexCall  
 * appear in the operand.  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        List<String> result = ConversionUtils.extractFieldsFromRelevanceMap(call, 0, fieldStorage);
    }  
            nestedMapOperands.add(rexBuilder.makeExactLiteral(new BigDecimal("1.0"), doubleType));  
        return (RexCall) rexBuilder.makeCall(MULTI_MATCH_FUNCTION, fieldMap, queryMap);
    private RexCall buildNestedMapLiteralCall(List<String> fieldNames) {
        return (RexCall) rexBuilder.makeCall(MULTI_MATCH_FUNCTION, outerMap, queryMap);
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
    private List<String> generateUniqueFieldNames(int count) {  
 * this file be licensed under the Apache-2.0 license or a
     * Builds a mock RexCall using the nested MAP literal structure:  
 * compatible open source license.
        // Query MAP: MAP('query', 'text')  
     */
        // Nested MAP: MAP_VALUE_CONSTRUCTOR(field1, 1.0, field2, 1.0, ...)  
    public void testExtractionPreservesOrderNestedMapLiteralPath() {  
 * SPDX-License-Identifier: Apache-2.0
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);  
        super.setUp();
        RexNode fieldMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, mapOperands.toArray(new RexNode[0]));

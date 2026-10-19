        assertNotNull("MULTI_MATCH serializer must be registered", serializer);
import org.apache.calcite.rex.RexBuilder;
    /**
        assertTrue("Serialized bytes should not be empty", serialized.length > 0);  
            new NamedWriteableRegistry.Entry(QueryBuilder.class, QueryStringQueryBuilder.NAME, QueryStringQueryBuilder::new),  
            nestedMapOperands.add(rexBuilder.makeExactLiteral(new BigDecimal("1.0"), doubleType));
import org.apache.calcite.sql.type.ReturnTypes;  
import org.apache.calcite.rex.RexCall;
 */  
            );  
        List<String> fieldNames = generateUniqueFieldNames(fieldCount);
        super.setUp();
 *
        // Nested MAP: MAP_VALUE_CONSTRUCTOR(field1, 1.0, field2, 1.0, ...)
 * compatible open source license.
        String queryText = randomAlphaOfLengthBetween(1, 200);
            }
     */
     * Multi-field serialization round-trip for MULTI_MATCH.  
            MultiMatchQueryBuilder multiMatch = (MultiMatchQueryBuilder) deserialized;  
                "Deserialized should be SimpleQueryStringBuilder but was " + deserialized.getClass().getSimpleName(),
        return (RexCall) rexBuilder.makeCall(sqlFunction, outerMap, queryMap);  
        assertNotNull("QUERY_STRING serializer must be registered", serializer);  
 * SPDX-License-Identifier: Apache-2.0
     *
        );
                "Deserialized should be MultiMatchQueryBuilder but was " + deserialized.getClass().getSimpleName(),  
import org.opensearch.test.OpenSearchTestCase;  
            assertEquals("Field count mismatch", fieldCount, multiMatch.fields().size());
        for (String field : fieldNames) {
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.SIMPLE_QUERY_STRING);  
                "Deserialized should be QueryStringQueryBuilder but was " + deserialized.getClass().getSimpleName(),
                deserialized instanceof SimpleQueryStringBuilder  
        RexNode nestedMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, nestedMapOperands.toArray(new RexNode[0]));
 */  
import org.apache.calcite.rel.type.RelDataType;
            for (String expectedField : fieldNames) {
    public void testQueryStringRoundTrip() throws IOException {
     * The serializer extracts fields via extractFieldsFromRelevanceMap(call, 0, fieldStorage)
        serializers = QuerySerializerRegistry.getSerializers();
import org.apache.calcite.sql.SqlKind;  
                names.add(candidate);
        // Query MAP: MAP('query', 'queryText')
/**
    /**
            for (String expectedField : fieldNames) {  
 * <p>For any non-empty list of valid field names and non-empty query string, serializing a  
    private RelDataTypeFactory typeFactory;
            assertEquals("Query text mismatch", queryText, simpleQueryString.value());  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 * {@code readNamedWriteable(QueryBuilder.class)} shall produce a QueryBuilder of the correct  
}
    public void setUp() throws Exception {
        int fieldCount = randomIntBetween(1, 5);  
import java.math.BigDecimal;  
        // Outer MAP: MAP('fields', nestedMap)
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
package org.opensearch.be.lucene;
        int fieldCount = randomIntBetween(1, 5);
            assertEquals("Field count mismatch", fieldCount, queryString.fields().size());  
import java.util.Map;  
    }
            SqlKind.OTHER_FUNCTION,
        byte[] serialized = serializer.serialize(call, fieldStorage);  
        assertNotNull("Serialized bytes should not be null", serialized);
    }  
        }  
        List<RexNode> nestedMapOperands = new ArrayList<>();
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
                assertTrue("Missing field: " + expectedField, simpleQueryString.fields().containsKey(expectedField));  
 * Property-based test for multi-field serialization round-trip.  
public class MultiFieldSerializationPropertyTests extends OpenSearchTestCase {
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
    /**
import org.opensearch.analytics.spi.ScalarFunction;
                assertTrue("Missing field: " + expectedField, multiMatch.fields().containsKey(expectedField));
/*  
 * registered serializer and then deserializing the resulting bytes with
    /**
            assertTrue(
import org.apache.calcite.rel.type.RelDataTypeFactory;  
     */
        assertTrue("Serialized bytes should not be empty", serialized.length > 0);
    }  
     * Multi-field serialization round-trip for SIMPLE_QUERY_STRING.
                deserialized instanceof QueryStringQueryBuilder
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            assertEquals("Field count mismatch", fieldCount, simpleQueryString.fields().size());
        List<FieldStorageInfo> fieldStorage = List.of();
     * For a random list of 1-5 field names and a random query string,  
import org.opensearch.analytics.spi.FieldStorageInfo;  
        byte[] serialized = serializer.serialize(call, fieldStorage);
        assertNotNull("Serialized bytes should not be null", serialized);  
import org.opensearch.index.query.SimpleQueryStringBuilder;
        RexNode outerMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, rexBuilder.makeLiteral("fields"), nestedMap);
        }
        }
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
     */  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
     * For a random list of 1-5 field names and a random query string,
        int fieldCount = randomIntBetween(1, 5);
import org.apache.calcite.sql.type.OperandTypes;
        List<String> fieldNames = generateUniqueFieldNames(fieldCount);
            nestedMapOperands.add(rexBuilder.makeLiteral(field));  
            functionName,
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);  
     *  
 * multi-field full-text predicate (multi_match, query_string, or simple_query_string) via its
            rexBuilder.makeLiteral(queryText)
        RexCall call = buildMultiFieldRexCall(fieldNames, queryText, "QUERY_STRING");  
            new NamedWriteableRegistry.Entry(QueryBuilder.class, SimpleQueryStringBuilder.NAME, SimpleQueryStringBuilder::new)
 * this file be licensed under the Apache-2.0 license or a
     * serializing via the QUERY_STRING serializer and deserializing produces a
import org.opensearch.index.query.QueryStringQueryBuilder;
                deserialized instanceof MultiMatchQueryBuilder
 *
        List<String> names = new ArrayList<>();  
import org.apache.calcite.sql.SqlFunctionCategory;
        return names;
    public void testSimpleQueryStringRoundTrip() throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        List<String> fieldNames = generateUniqueFieldNames(fieldCount);  
        assertTrue("Serialized bytes should not be empty", serialized.length > 0);
    }
    private List<String> generateUniqueFieldNames(int count) {
    }
        List<FieldStorageInfo> fieldStorage = List.of(); // not used in nested MAP literal path  
import java.util.List;
 *
        assertNotNull("SIMPLE_QUERY_STRING serializer must be registered", serializer);
        )
            assertTrue(  
        }
            );
     * The nested MAP has alternating field name literals (even indices) and boost literals (odd indices).
 * subclass containing all the specified fields and the same query text.
        List.of(
        rexBuilder = new RexBuilder(typeFactory);
    public void testMultiMatchRoundTrip() throws IOException {  
        // Build nested MAP operands: field1, boost1, field2, boost2, ...  
            null,
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(  
            assertEquals("Query text mismatch", queryText, queryString.queryString());
        RexNode queryMap = rexBuilder.makeCall(
            String candidate = randomAlphaOfLengthBetween(1, 50);
        RexCall call = buildMultiFieldRexCall(fieldNames, queryText, "SIMPLE_QUERY_STRING");
            }  
     */
     * serializing via the SIMPLE_QUERY_STRING serializer and deserializing produces a
            SimpleQueryStringBuilder simpleQueryString = (SimpleQueryStringBuilder) deserialized;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
     *
import org.opensearch.index.query.QueryBuilder;  
            assertTrue(
            if (names.contains(candidate) == false) {  
import java.io.IOException;
        byte[] serialized = serializer.serialize(call, fieldStorage);
     */
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            for (String expectedField : fieldNames) {
import org.apache.calcite.sql.SqlFunction;
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MULTI_MATCH);
        }  
        String queryText = randomAlphaOfLengthBetween(1, 200);  
        RexCall call = buildMultiFieldRexCall(fieldNames, queryText, "MULTI_MATCH");
    private RexBuilder rexBuilder;  
    }
     * Generates a list of unique random field names.  
 *
    private RexCall buildMultiFieldRexCall(List<String> fieldNames, String queryText, String functionName) {  
            OperandTypes.ANY,
     * Builds a mock RexCall simulating the multi-field relevance function structure:
            );
    @Override  
                assertTrue("Missing field: " + expectedField, queryString.fields().containsKey(expectedField));
            SqlFunctionCategory.USER_DEFINED_FUNCTION  
    /**  
        );  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY_STRING);
    );  
     * MultiMatchQueryBuilder with all fields present and the correct query text.
        while (names.size() < count) {
     * FUNC(MAP('fields', MAP('field1', 1.0, 'field2', 1.0, ...)), MAP('query', 'queryText'))  
import org.opensearch.index.query.MultiMatchQueryBuilder;
            }
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
     * Multi-field serialization round-trip for QUERY_STRING.
     * QueryStringQueryBuilder with all fields present and the correct query text.
            rexBuilder.makeLiteral("query"),
        // Top-level function call
import java.util.ArrayList;
import org.apache.calcite.rex.RexNode;  
            ReturnTypes.BOOLEAN,  
     *
        List<FieldStorageInfo> fieldStorage = List.of();
            assertEquals("Query text mismatch", queryText, multiMatch.value());
import org.apache.calcite.sql.type.SqlTypeName;
        assertNotNull("Serialized bytes should not be null", serialized);
            QueryStringQueryBuilder queryString = (QueryStringQueryBuilder) deserialized;
     * which expects operand 0 to be an outer MAP with a nested MAP at child index 1.  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
     * serializing via the MULTI_MATCH serializer and deserializing produces a  
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
 * The OpenSearch Contributors require contributions made to  
        SqlFunction sqlFunction = new SqlFunction(  
     * SimpleQueryStringBuilder with all fields present and the correct query text.  
     * For a random list of 1-5 field names and a random query string,
    private Map<ScalarFunction, DelegatedPredicateSerializer> serializers;
        String queryText = randomAlphaOfLengthBetween(1, 200);
        typeFactory = new JavaTypeFactoryImpl();  
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MultiMatchQueryBuilder.NAME, MultiMatchQueryBuilder::new),
            }

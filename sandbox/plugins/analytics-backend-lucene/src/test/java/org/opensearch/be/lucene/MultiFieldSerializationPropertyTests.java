    /**
        SqlFunction sqlFunction = new SqlFunction(
    public void testQueryStringRoundTrip() throws IOException {
            if (names.contains(candidate) == false) {
                deserialized instanceof MultiMatchQueryBuilder
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        rexBuilder = new RexBuilder(typeFactory);
     * which expects operand 0 to be an outer MAP with a nested MAP at child index 1.
     */
}
 * The OpenSearch Contributors require contributions made to
        }
     * Multi-field serialization round-trip for QUERY_STRING.
     * Multi-field serialization round-trip for SIMPLE_QUERY_STRING.
        // Nested MAP: MAP_VALUE_CONSTRUCTOR(field1, 1.0, field2, 1.0, ...)
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(
import org.apache.calcite.rel.type.RelDataTypeFactory;
        RexNode queryMap = rexBuilder.makeCall(
import org.apache.calcite.sql.SqlFunctionCategory;
     *
        RexCall call = buildMultiFieldRexCall(fieldNames, queryText, "SIMPLE_QUERY_STRING");
            assertEquals("Field count mismatch", fieldCount, simpleQueryString.fields().size());
    }
 */
            nestedMapOperands.add(rexBuilder.makeExactLiteral(new BigDecimal("1.0"), doubleType));
            }
import java.util.Map;
        serializers = QuerySerializerRegistry.getSerializers();
/**
     * QueryStringQueryBuilder with all fields present and the correct query text.
 * subclass containing all the specified fields and the same query text.
    }
        RexNode outerMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, rexBuilder.makeLiteral("fields"), nestedMap);
 *
                "Deserialized should be MultiMatchQueryBuilder but was " + deserialized.getClass().getSimpleName(),
import org.apache.calcite.rex.RexCall;
            SimpleQueryStringBuilder simpleQueryString = (SimpleQueryStringBuilder) deserialized;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.spi.FieldStorageInfo;
        assertNotNull("QUERY_STRING serializer must be registered", serializer);
    @Override
     */
        }
     * For a random list of 1-5 field names and a random query string,
        assertNotNull("Serialized bytes should not be null", serialized);
import java.util.ArrayList;
        String queryText = randomAlphaOfLengthBetween(1, 200);
     *
    /**
            ReturnTypes.BOOLEAN,
     * serializing via the MULTI_MATCH serializer and deserializing produces a
    }
     * Generates a list of unique random field names.
    private RexBuilder rexBuilder;
 * Property-based test for multi-field serialization round-trip.
        return (RexCall) rexBuilder.makeCall(sqlFunction, outerMap, queryMap);
        byte[] serialized = serializer.serialize(call, fieldStorage);
            }
     */
        List<String> names = new ArrayList<>();
        super.setUp();
     * Multi-field serialization round-trip for MULTI_MATCH.
     * MultiMatchQueryBuilder with all fields present and the correct query text.
import org.apache.calcite.rex.RexBuilder;
            OperandTypes.ANY,
     * For a random list of 1-5 field names and a random query string,
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
import org.opensearch.analytics.spi.ScalarFunction;
            null,
     * SimpleQueryStringBuilder with all fields present and the correct query text.
            }
        String queryText = randomAlphaOfLengthBetween(1, 200);
public class MultiFieldSerializationPropertyTests extends OpenSearchTestCase {
            rexBuilder.makeLiteral(queryText)
     * FUNC(MAP('fields', MAP('field1', 1.0, 'field2', 1.0, ...)), MAP('query', 'queryText'))
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MultiMatchQueryBuilder.NAME, MultiMatchQueryBuilder::new),
            assertTrue(
        }
    private Map<ScalarFunction, DelegatedPredicateSerializer> serializers;
import org.apache.calcite.rel.type.RelDataType;
            for (String expectedField : fieldNames) {
            );
import org.opensearch.index.query.SimpleQueryStringBuilder;
        List<FieldStorageInfo> fieldStorage = List.of();
        assertTrue("Serialized bytes should not be empty", serialized.length > 0);
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
     * The serializer extracts fields via extractFieldsFromRelevanceMap(call, 0, fieldStorage)
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MULTI_MATCH);
    public void setUp() throws Exception {
    /**
import java.math.BigDecimal;
            assertEquals("Query text mismatch", queryText, simpleQueryString.value());
            );
 * <p>For any non-empty list of valid field names and non-empty query string, serializing a
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        List<FieldStorageInfo> fieldStorage = List.of(); // not used in nested MAP literal path
     * For a random list of 1-5 field names and a random query string,
        )
                assertTrue("Missing field: " + expectedField, simpleQueryString.fields().containsKey(expectedField));
                "Deserialized should be QueryStringQueryBuilder but was " + deserialized.getClass().getSimpleName(),
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
 * this file be licensed under the Apache-2.0 license or a
     */
                assertTrue("Missing field: " + expectedField, multiMatch.fields().containsKey(expectedField));
            assertEquals("Field count mismatch", fieldCount, queryString.fields().size());
    }
            SqlKind.OTHER_FUNCTION,
        assertNotNull("MULTI_MATCH serializer must be registered", serializer);
    private RexCall buildMultiFieldRexCall(List<String> fieldNames, String queryText, String functionName) {
        while (names.size() < count) {
            }
import org.apache.calcite.sql.SqlKind;
        assertNotNull("Serialized bytes should not be null", serialized);
        List<String> fieldNames = generateUniqueFieldNames(fieldCount);
 *
        RexNode nestedMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, nestedMapOperands.toArray(new RexNode[0]));
            new NamedWriteableRegistry.Entry(QueryBuilder.class, SimpleQueryStringBuilder.NAME, SimpleQueryStringBuilder::new)
            new NamedWriteableRegistry.Entry(QueryBuilder.class, QueryStringQueryBuilder.NAME, QueryStringQueryBuilder::new),
        assertNotNull("SIMPLE_QUERY_STRING serializer must be registered", serializer);
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        RexCall call = buildMultiFieldRexCall(fieldNames, queryText, "QUERY_STRING");
        List<String> fieldNames = generateUniqueFieldNames(fieldCount);
            assertEquals("Query text mismatch", queryText, queryString.queryString());
            for (String expectedField : fieldNames) {
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        }
                deserialized instanceof SimpleQueryStringBuilder
        for (String field : fieldNames) {
import java.util.List;
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY_STRING);
        List<String> fieldNames = generateUniqueFieldNames(fieldCount);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }
     * serializing via the SIMPLE_QUERY_STRING serializer and deserializing produces a
        int fieldCount = randomIntBetween(1, 5);
     */
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            nestedMapOperands.add(rexBuilder.makeLiteral(field));
import org.opensearch.index.query.QueryStringQueryBuilder;
import org.opensearch.index.query.MultiMatchQueryBuilder;
import org.apache.calcite.sql.type.OperandTypes;
     * serializing via the QUERY_STRING serializer and deserializing produces a
        typeFactory = new JavaTypeFactoryImpl();
            MultiMatchQueryBuilder multiMatch = (MultiMatchQueryBuilder) deserialized;
                assertTrue("Missing field: " + expectedField, queryString.fields().containsKey(expectedField));
        );
     *
            SqlFunctionCategory.USER_DEFINED_FUNCTION
        List.of(
    private List<String> generateUniqueFieldNames(int count) {
     * Builds a mock RexCall simulating the multi-field relevance function structure:
        List<RexNode> nestedMapOperands = new ArrayList<>();
import org.apache.calcite.sql.type.ReturnTypes;
     *
 * multi-field full-text predicate (multi_match, query_string, or simple_query_string) via its
        int fieldCount = randomIntBetween(1, 5);
        assertNotNull("Serialized bytes should not be null", serialized);
     * The nested MAP has alternating field name literals (even indices) and boost literals (odd indices).
    public void testSimpleQueryStringRoundTrip() throws IOException {
                "Deserialized should be SimpleQueryStringBuilder but was " + deserialized.getClass().getSimpleName(),
/*
import org.apache.calcite.rex.RexNode;
import org.opensearch.index.query.QueryBuilder;
 * registered serializer and then deserializing the resulting bytes with
    /**
import java.io.IOException;
            for (String expectedField : fieldNames) {
    /**
        return names;
import org.opensearch.core.common.io.stream.StreamInput;
 */
        byte[] serialized = serializer.serialize(call, fieldStorage);
            QueryStringQueryBuilder queryString = (QueryStringQueryBuilder) deserialized;
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        // Top-level function call
        String queryText = randomAlphaOfLengthBetween(1, 200);
        }
        List<FieldStorageInfo> fieldStorage = List.of();
 *
import org.apache.calcite.sql.SqlFunction;
        int fieldCount = randomIntBetween(1, 5);
                names.add(candidate);
        // Build nested MAP operands: field1, boost1, field2, boost2, ...
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
 *
        // Query MAP: MAP('query', 'queryText')
        RexCall call = buildMultiFieldRexCall(fieldNames, queryText, "MULTI_MATCH");
import org.opensearch.test.OpenSearchTestCase;
package org.opensearch.be.lucene;
            assertEquals("Query text mismatch", queryText, multiMatch.value());
        );
    private RelDataTypeFactory typeFactory;
 * {@code readNamedWriteable(QueryBuilder.class)} shall produce a QueryBuilder of the correct
        assertTrue("Serialized bytes should not be empty", serialized.length > 0);
            assertEquals("Field count mismatch", fieldCount, multiMatch.fields().size());
                deserialized instanceof QueryStringQueryBuilder
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.SIMPLE_QUERY_STRING);
    );
import org.apache.calcite.sql.type.SqlTypeName;
        byte[] serialized = serializer.serialize(call, fieldStorage);
            rexBuilder.makeLiteral("query"),
            assertTrue(
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        // Outer MAP: MAP('fields', nestedMap)
 * compatible open source license.
            functionName,
        assertTrue("Serialized bytes should not be empty", serialized.length > 0);
            assertTrue(
    }
            );
            String candidate = randomAlphaOfLengthBetween(1, 50);
    public void testMultiMatchRoundTrip() throws IOException {

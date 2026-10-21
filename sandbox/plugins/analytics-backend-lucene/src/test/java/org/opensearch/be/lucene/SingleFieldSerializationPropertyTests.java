     *
        RexNode fieldKey = rexBuilder.makeLiteral("field");
    @Override
 *
        assertNotNull("MATCH_PHRASE_PREFIX serializer must be registered", serializer);
import org.apache.calcite.sql.SqlFunction;
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.sql.type.SqlTypeName;
        )
     *
        assertNotNull("MATCH_PHRASE serializer must be registered", serializer);
        List.of(
        List<FieldStorageInfo> fieldStorage = List.of(
/*
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_PHRASE);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        super.setUp();
        RexNode queryLiteral = rexBuilder.makeLiteral(queryText);
        assertTrue("Serialized bytes should not be empty", serialized.length > 0);
        assertNotNull("MATCH_BOOL_PREFIX serializer must be registered", serializer);
     *
     */
    /**
            new FieldStorageInfo(fieldName, "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        serializers = QuerySerializerRegistry.getSerializers();
     */
    private RexCall buildSingleFieldRexCall(String fieldName, String queryText, String functionName) {
 * compatible open source license.
        String queryText = "quick brown fox";
import org.opensearch.index.query.MatchBoolPrefixQueryBuilder;
import org.opensearch.index.query.QueryBuilder;
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_BOOL_PREFIX);
        );
import org.opensearch.core.common.io.stream.StreamInput;
                deserialized instanceof MatchBoolPrefixQueryBuilder
            );
                "Deserialized should be MatchPhrasePrefixQueryBuilder but was " + deserialized.getClass().getSimpleName(),
        );
            assertEquals("Field name mismatch", fieldName, matchPhrasePrefix.fieldName());
 * Serialization round-trip tests for single-field full-text serializers.
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        );
            assertTrue(
import org.apache.calcite.sql.SqlFunctionCategory;
import java.util.Map;
        }
     * Serializing via the MATCH_PHRASE_PREFIX serializer and deserializing produces a
        String fieldName = "description";
            new FieldStorageInfo(fieldName, "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull("Serialized bytes should not be null", serialized);
public class SingleFieldSerializationPropertyTests extends OpenSearchTestCase {
     * Serializing via the MATCH_BOOL_PREFIX serializer and deserializing produces a
    public void setUp() throws Exception {
            functionName,
    }
        byte[] serialized = serializer.serialize(call, fieldStorage);
 * predicate (match_phrase, match_bool_prefix, or match_phrase_prefix) via its registered serializer
        List<FieldStorageInfo> fieldStorage = List.of(
    }
    public void testMatchPhraseRoundTrip() throws IOException {
        String queryText = "opensearch full text";
        SqlFunction sqlFunction = new SqlFunction(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_PHRASE_PREFIX);
    /**
            SqlFunctionCategory.USER_DEFINED_FUNCTION
            OperandTypes.ANY,
import java.util.List;
    private RelDataTypeFactory typeFactory;
        RexNode fieldMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, fieldKey, fieldRef);
import org.apache.calcite.sql.SqlKind;
                "Deserialized should be MatchBoolPrefixQueryBuilder but was " + deserialized.getClass().getSimpleName(),
 * and then deserializing the resulting bytes with {@code readNamedWriteable(QueryBuilder.class)}
            assertEquals("Field name mismatch", fieldName, matchBoolPrefix.fieldName());
}
     * Serializing via the MATCH_PHRASE serializer and deserializing produces a MatchPhraseQueryBuilder
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(
        RexCall call = buildSingleFieldRexCall(fieldName, queryText, "MATCH_PHRASE");
    private Map<ScalarFunction, DelegatedPredicateSerializer> serializers;
                deserialized instanceof MatchPhrasePrefixQueryBuilder
     * which expects operand 0 to be a RexCall (MAP) with a RexInputRef at child index 1.
        RexNode queryMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, queryKey, queryLiteral);
            assertTrue(
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        byte[] serialized = serializer.serialize(call, fieldStorage);
            assertEquals("Field name mismatch", fieldName, matchPhrase.fieldName());
import org.apache.calcite.rel.type.RelDataType;
 *
     * MatchPhrasePrefixQueryBuilder with the same field and query.
            MatchBoolPrefixQueryBuilder matchBoolPrefix = (MatchBoolPrefixQueryBuilder) deserialized;
            new FieldStorageInfo(fieldName, "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        List<FieldStorageInfo> fieldStorage = List.of(
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchPhraseQueryBuilder.NAME, MatchPhraseQueryBuilder::new),
        );
            );
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchBoolPrefixQueryBuilder.NAME, MatchBoolPrefixQueryBuilder::new),
import org.opensearch.test.OpenSearchTestCase;
        return (RexCall) rexBuilder.makeCall(sqlFunction, fieldMap, queryMap);
            assertEquals("Query text mismatch", queryText, matchPhrasePrefix.value());
 *
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        // Top-level function call
            MatchPhrasePrefixQueryBuilder matchPhrasePrefix = (MatchPhrasePrefixQueryBuilder) deserialized;
        assertTrue("Serialized bytes should not be empty", serialized.length > 0);
     * Single-field serialization round-trip for MATCH_BOOL_PREFIX.
            null,
        assertTrue("Serialized bytes should not be empty", serialized.length > 0);
     * MatchBoolPrefixQueryBuilder with the same field and query.
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            MatchPhraseQueryBuilder matchPhrase = (MatchPhraseQueryBuilder) deserialized;
import org.apache.calcite.sql.type.ReturnTypes;
    /**
        rexBuilder = new RexBuilder(typeFactory);
import org.opensearch.index.query.MatchPhraseQueryBuilder;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
import org.opensearch.analytics.spi.FieldType;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        String fieldName = "title";
     * The serializer extracts the field via extractFieldFromRelevanceMap(call, 0, fieldStorage)
    public void testMatchPhrasePrefixRoundTrip() throws IOException {
        typeFactory = new JavaTypeFactoryImpl();
        assertNotNull("Serialized bytes should not be null", serialized);
    /**
        assertNotNull("Serialized bytes should not be null", serialized);
 * <p>Feature: lucene-fulltext-serializers
     * It extracts the query via extractStringFromRelevanceMap(call, 1) which expects operand 1
 * <p>Validates: Requirements 3.5, 4.5, 5.5
            SqlKind.OTHER_FUNCTION,
 * The OpenSearch Contributors require contributions made to
 * <p>For a given field name and query string, serializing a single-field full-text
        String queryText = "search engine optim";
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
     * to be a RexCall (MAP) with a RexLiteral at child index 1.
import org.apache.calcite.rex.RexBuilder;
        RexCall call = buildSingleFieldRexCall(fieldName, queryText, "MATCH_BOOL_PREFIX");
     * FUNC(MAP('field', $0), MAP('query', 'queryText'))
 */
import org.opensearch.analytics.spi.FieldStorageInfo;
import java.io.IOException;
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
            assertTrue(
     * Single-field serialization round-trip for MATCH_PHRASE.
            assertEquals("Query text mismatch", queryText, matchPhrase.value());
/**
            assertEquals("Query text mismatch", queryText, matchBoolPrefix.value());
import org.opensearch.analytics.spi.ScalarFunction;
        // Operand 0: MAP('field', $0) — field reference
     */
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
     *
    public void testMatchBoolPrefixRoundTrip() throws IOException {
import org.apache.calcite.sql.type.OperandTypes;
 *
        RexNode queryKey = rexBuilder.makeLiteral("query");
        RexNode fieldRef = rexBuilder.makeInputRef(varcharType, 0);
    }
import org.apache.calcite.rex.RexNode;
package org.opensearch.be.lucene;
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
    }
 */
        RexCall call = buildSingleFieldRexCall(fieldName, queryText, "MATCH_PHRASE_PREFIX");
     * Builds a mock RexCall simulating the single-field relevance function structure:
                "Deserialized should be MatchPhraseQueryBuilder but was " + deserialized.getClass().getSimpleName(),
     */
     * Single-field serialization round-trip for MATCH_PHRASE_PREFIX.
        }
    private RexBuilder rexBuilder;
    }
     * with the same field and query.
        }
        // Operand 1: MAP('query', 'queryText') — query text literal
        String fieldName = "content";
            );
import org.apache.calcite.rex.RexCall;
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        byte[] serialized = serializer.serialize(call, fieldStorage);
            ReturnTypes.BOOLEAN,
    );
 * shall produce a QueryBuilder of the correct subclass containing the same field name and query text.
                deserialized instanceof MatchPhraseQueryBuilder
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchPhrasePrefixQueryBuilder.NAME, MatchPhrasePrefixQueryBuilder::new)

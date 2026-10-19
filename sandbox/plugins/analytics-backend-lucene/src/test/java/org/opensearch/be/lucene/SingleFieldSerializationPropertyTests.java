     * Serializing via the MATCH_BOOL_PREFIX serializer and deserializing produces a  
        );
        RexNode fieldKey = rexBuilder.makeLiteral("field");  
            assertEquals("Query text mismatch", queryText, matchPhrase.value());
 * and then deserializing the resulting bytes with {@code readNamedWriteable(QueryBuilder.class)}
            functionName,
    /**
            ReturnTypes.BOOLEAN,
     * which expects operand 0 to be a RexCall (MAP) with a RexInputRef at child index 1.
        assertNotNull("Serialized bytes should not be null", serialized);  
     * Single-field serialization round-trip for MATCH_PHRASE.  
     * Builds a mock RexCall simulating the single-field relevance function structure:  
import org.apache.calcite.sql.type.ReturnTypes;  
 * Serialization round-trip tests for single-field full-text serializers.
 * this file be licensed under the Apache-2.0 license or a
            MatchBoolPrefixQueryBuilder matchBoolPrefix = (MatchBoolPrefixQueryBuilder) deserialized;
        }
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_PHRASE_PREFIX);
import org.apache.calcite.sql.SqlFunctionCategory;
    /**
    public void testMatchPhraseRoundTrip() throws IOException {
/**
            OperandTypes.ANY,  
        assertNotNull("MATCH_BOOL_PREFIX serializer must be registered", serializer);
 * <p>Validates: Requirements 3.5, 4.5, 5.5
 * compatible open source license.
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchBoolPrefixQueryBuilder.NAME, MatchBoolPrefixQueryBuilder::new),  
            assertTrue(
    );  
     */  
            assertTrue(  
    private Map<ScalarFunction, DelegatedPredicateSerializer> serializers;
        assertNotNull("MATCH_PHRASE_PREFIX serializer must be registered", serializer);  
            );
import org.opensearch.analytics.spi.FieldStorageInfo;  
     * Single-field serialization round-trip for MATCH_BOOL_PREFIX.
    private RexCall buildSingleFieldRexCall(String fieldName, String queryText, String functionName) {
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        assertTrue("Serialized bytes should not be empty", serialized.length > 0);
import org.apache.calcite.sql.SqlKind;  
    private RelDataTypeFactory typeFactory;
     *
            new FieldStorageInfo(fieldName, "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        List<FieldStorageInfo> fieldStorage = List.of(
     *  
        assertNotNull("Serialized bytes should not be null", serialized);
 */  
 *
        String queryText = "search engine optim";  
        return (RexCall) rexBuilder.makeCall(sqlFunction, fieldMap, queryMap);
                "Deserialized should be MatchPhrasePrefixQueryBuilder but was " + deserialized.getClass().getSimpleName(),
     * Single-field serialization round-trip for MATCH_PHRASE_PREFIX.
    }
 * <p>Feature: lucene-fulltext-serializers
        }
    public void setUp() throws Exception {
            assertEquals("Field name mismatch", fieldName, matchPhrasePrefix.fieldName());  
        String fieldName = "content";
     * FUNC(MAP('field', $0), MAP('query', 'queryText'))
        // Top-level function call  
     * with the same field and query.  
        assertTrue("Serialized bytes should not be empty", serialized.length > 0);  
            MatchPhraseQueryBuilder matchPhrase = (MatchPhraseQueryBuilder) deserialized;  
 *
        // Operand 1: MAP('query', 'queryText') — query text literal
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
 * <p>For a given field name and query string, serializing a single-field full-text  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        );  
    }  
        String fieldName = "description";
        SqlFunction sqlFunction = new SqlFunction(
    public void testMatchBoolPrefixRoundTrip() throws IOException {  
     *
            new FieldStorageInfo(fieldName, "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)  
                deserialized instanceof MatchPhraseQueryBuilder
        RexNode fieldMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, fieldKey, fieldRef);
            new FieldStorageInfo(fieldName, "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
import java.util.Map;
            assertEquals("Query text mismatch", queryText, matchPhrasePrefix.value());
 * SPDX-License-Identifier: Apache-2.0
     * Serializing via the MATCH_PHRASE serializer and deserializing produces a MatchPhraseQueryBuilder
import org.opensearch.analytics.spi.FieldType;
        assertNotNull("MATCH_PHRASE serializer must be registered", serializer);
        assertTrue("Serialized bytes should not be empty", serialized.length > 0);
            );  
     * Serializing via the MATCH_PHRASE_PREFIX serializer and deserializing produces a
            assertEquals("Query text mismatch", queryText, matchBoolPrefix.value());  
        RexNode fieldRef = rexBuilder.makeInputRef(varcharType, 0);
import org.apache.calcite.sql.SqlFunction;
public class SingleFieldSerializationPropertyTests extends OpenSearchTestCase {
        List<FieldStorageInfo> fieldStorage = List.of(
        // Operand 0: MAP('field', $0) — field reference
                "Deserialized should be MatchBoolPrefixQueryBuilder but was " + deserialized.getClass().getSimpleName(),
                deserialized instanceof MatchPhrasePrefixQueryBuilder  
        assertNotNull("Serialized bytes should not be null", serialized);
import org.apache.calcite.rex.RexCall;
     * The serializer extracts the field via extractFieldFromRelevanceMap(call, 0, fieldStorage)  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        List<FieldStorageInfo> fieldStorage = List.of(  
import org.opensearch.index.query.MatchPhraseQueryBuilder;
    }
        rexBuilder = new RexBuilder(typeFactory);
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
            assertTrue(
 *  
     */
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchPhraseQueryBuilder.NAME, MatchPhraseQueryBuilder::new),
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.opensearch.index.query.MatchBoolPrefixQueryBuilder;  
    }
    public void testMatchPhrasePrefixRoundTrip() throws IOException {
    /**
        byte[] serialized = serializer.serialize(call, fieldStorage);  
                deserialized instanceof MatchBoolPrefixQueryBuilder
        super.setUp();
 */  
/*  
            );
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchPhrasePrefixQueryBuilder.NAME, MatchPhrasePrefixQueryBuilder::new)
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
import org.apache.calcite.rex.RexNode;  
 *
        }  
    /**  
import java.io.IOException;  
        )
import org.apache.calcite.sql.type.SqlTypeName;
package org.opensearch.be.lucene;
        RexCall call = buildSingleFieldRexCall(fieldName, queryText, "MATCH_PHRASE");  
import org.opensearch.index.query.QueryBuilder;  
        typeFactory = new JavaTypeFactoryImpl();  
     * to be a RexCall (MAP) with a RexLiteral at child index 1.  
import org.opensearch.core.common.io.stream.StreamInput;
            MatchPhrasePrefixQueryBuilder matchPhrasePrefix = (MatchPhrasePrefixQueryBuilder) deserialized;
    }  
     */
        byte[] serialized = serializer.serialize(call, fieldStorage);
        RexNode queryKey = rexBuilder.makeLiteral("query");
    @Override  
            null,
        serializers = QuerySerializerRegistry.getSerializers();
     *
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(  
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.rel.type.RelDataType;
        List.of(
        RexCall call = buildSingleFieldRexCall(fieldName, queryText, "MATCH_BOOL_PREFIX");
            SqlKind.OTHER_FUNCTION,  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);  
}  
            assertEquals("Field name mismatch", fieldName, matchPhrase.fieldName());
            SqlFunctionCategory.USER_DEFINED_FUNCTION
                "Deserialized should be MatchPhraseQueryBuilder but was " + deserialized.getClass().getSimpleName(),  
import org.apache.calcite.sql.type.OperandTypes;
        RexNode queryLiteral = rexBuilder.makeLiteral(queryText);  
        RexCall call = buildSingleFieldRexCall(fieldName, queryText, "MATCH_PHRASE_PREFIX");
     */
import java.util.List;
 * shall produce a QueryBuilder of the correct subclass containing the same field name and query text.  
            assertEquals("Field name mismatch", fieldName, matchBoolPrefix.fieldName());
        String queryText = "opensearch full text";
 * The OpenSearch Contributors require contributions made to  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        byte[] serialized = serializer.serialize(call, fieldStorage);
     * MatchPhrasePrefixQueryBuilder with the same field and query.
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
     * MatchBoolPrefixQueryBuilder with the same field and query.
        String fieldName = "title";  
        );
import org.opensearch.analytics.spi.ScalarFunction;
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
        RexNode queryMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, queryKey, queryLiteral);
    private RexBuilder rexBuilder;  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
     * It extracts the query via extractStringFromRelevanceMap(call, 1) which expects operand 1
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_PHRASE);  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_BOOL_PREFIX);
        String queryText = "quick brown fox";
 * predicate (match_phrase, match_bool_prefix, or match_phrase_prefix) via its registered serializer
        );

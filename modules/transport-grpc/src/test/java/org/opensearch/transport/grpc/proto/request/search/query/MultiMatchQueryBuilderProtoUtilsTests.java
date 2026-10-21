        // Test with ZERO_TERMS_QUERY_UNSPECIFIED to cover lines 152-154
        assertEquals(fromXContent.zeroTermsQuery(), fromProto.zeroTermsQuery());
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_AND)
    }
        assertEquals(fromXContent.type(), fromProto.type());
            + "  \"tie_breaker\": 0.5,\n"
        // Create a minimal MultiMatchQuery proto with only required fields
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)
            .addFields("field2")
            assertEquals(expectedZeroTermsQueries[i], builder.zeroTermsQuery());
            .addFields("field1")
                .addFields("field1")
            .setPrefixLength(3)
            .setType(TextQueryType.TEXT_QUERY_TYPE_BOOL_PREFIX)
        assertEquals(MultiMatchQueryBuilder.DEFAULT_PHRASE_SLOP, builder.slop());
        String json = "{\n"
            .setAnalyzer("standard")
        // 1. Create a JSON string for XContent parsing
            .setQuery("test")
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)
            org.opensearch.protobufs.Operator.OPERATOR_AND,
            .build();
            .setFuzzyRewrite("top_terms_boost_10")
            .setFuzzyRewrite("constant_score")
        assertEquals(3, builder.prefixLength());
            .setQuery("test query")
            .setQuery("test query")
        }
        assertEquals(fromXContent.fuzzyRewrite(), fromProto.fuzzyRewrite());
    public void testFromProtoWithBoolPrefixAndDefaultSlop() {
        assertEquals(MultiMatchQueryBuilder.DEFAULT_ZERO_TERMS_QUERY, builder.zeroTermsQuery()); // Should keep default
        ZeroTermsQuery[] zeroTermsQueries = { ZeroTermsQuery.ZERO_TERMS_QUERY_NONE, ZeroTermsQuery.ZERO_TERMS_QUERY_ALL };
    public void testFromProtoWithDifferentOperators() {
        assertEquals(Fuzziness.fromEdits(2), builderInt.fuzziness());
        // Create a complete MultiMatchQuery proto with all fields set
            + "  \"boost\": 2.0,\n"
            .setLenient(true)
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
            .setQuery("test query")
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
        assertEquals("standard", builder.analyzer());
        assertEquals(0.5f, builder.tieBreaker(), 0.001f);
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setString("75%").build())
            + "}";
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setInt32(2).build())
            .setAutoGenerateSynonymsPhraseQuery(false)
            + "  \"analyzer\": \"standard\",\n"
    }
        assertEquals(1.0f, builder.boost(), 0.001f);
            .setQuery("test")
        assertEquals("test query", builder.value());
            .build();
    }
            .setQuery("test query")
            .addFields("field1")
        QueryBuilderProtoTestUtils.setupRegistry();
            .addFields("field1")
    public void testFromProtoWithDifferentZeroTermsQuery() {
    }
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
            TextQueryType.TEXT_QUERY_TYPE_CROSS_FIELDS,
        assertEquals(fromXContent.minimumShouldMatch(), fromProto.minimumShouldMatch());
            .setQuery("test query")
        assertEquals(MultiMatchQueryBuilder.DEFAULT_MAX_EXPANSIONS, builder.maxExpansions());
        assertEquals("test_query", builder.queryName());
    }
        // 2. Parse the JSON to create a MultiMatchQueryBuilder via fromXContent
            .build();
        // Convert to MultiMatchQueryBuilder
        assertEquals(fromXContent.autoGenerateSynonymsPhraseQuery(), fromProto.autoGenerateSynonymsPhraseQuery());
            + "  \"slop\": 2,\n"
        assertTrue("Exception message should mention BOOL_PREFIX", exception.getMessage().contains("BOOL_PREFIX"));
    }
            .addFields("field1")
            // No slop set - should use default
        MultiMatchQueryBuilder builder = fromProto(proto);
            .setQuery("test query")
     * Test that compares the results of fromXContent and fromProto to ensure they produce equivalent results.
    }
                .setOperator(operators[i])
        }
        assertEquals("2", builder.minimumShouldMatch());
        // Verify minimum_should_match
        MultiMatchQuery proto = MultiMatchQuery.newBuilder().setQuery("test query").addFields("field1").build();
 */
        // Test with TEXT_QUERY_TYPE_UNSPECIFIED to cover default case in switch
        // Verify minimum_should_match
        // Test slop validation for BOOL_PREFIX type to cover lines 172-173
     */
        assertEquals(Fuzziness.build("AUTO"), builderString.fuzziness());
        assertEquals(3, builder.fields().size());
        assertEquals(MultiMatchQueryBuilder.DEFAULT_PHRASE_SLOP, builder.slop());
        // Set up the registry with all built-in converters
            .setLenient(true)
            .addFields("field1")
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().build()) // Empty - no string or int32
        assertNull(builder.tieBreaker());
            .build();
            .build();
        // 5. Compare the two builders
            .addFields("field1")
import org.opensearch.common.unit.Fuzziness;
        // Test with fieldsCount = 0 to cover line 60 branch
            MultiMatchQueryBuilder.Type.CROSS_FIELDS,
            .build();
        assertEquals("constant_score", builder.fuzzyRewrite());
        assertEquals(fromXContent.boost(), fromProto.boost(), 0.001f);
        MultiMatchQuery protoConstantScoreBoolean = MultiMatchQuery.newBuilder()
            .setTieBreaker(0.5f)
        // Verify basic properties
        assertNotNull("Fuzziness should not be null (STRING)", builderString.fuzziness());
            .addFields("field1")
            .addFields("field1")
        // Test all possible operators
            MultiMatchQuery proto = MultiMatchQuery.newBuilder()
        // Test all possible zero_terms_query values
            .addFields("field2")
        assertEquals(MultiMatchQueryBuilder.DEFAULT_TYPE, builder.type());
        assertTrue(builder.fields().containsKey("field1"));
        MultiMatchQueryBuilder fromProto = MultiMatchQueryBuilderProtoUtils.fromProto(proto);
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
        MultiMatchQuery protoTopTermsBoost = MultiMatchQuery.newBuilder()
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
        org.opensearch.protobufs.Operator[] operators = {
            .setAnalyzer("standard")
        assertEquals(MultiMatchQueryBuilder.DEFAULT_OPERATOR, builder.operator());
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
            .setQuery("test query")
    }
            .setFuzziness(org.opensearch.protobufs.Fuzziness.newBuilder().build())
            + "  \"fuzzy_rewrite\": \"constant_score\",\n"
/*
import org.opensearch.common.xcontent.json.JsonXContent;
        for (int i = 0; i < zeroTermsQueries.length; i++) {
    }
        MultiMatchQueryBuilder builder = fromProto(proto);
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_AND)
import org.opensearch.protobufs.MinimumShouldMatch;
            .addFields("field2")
            .build();
            assertEquals(expectedTypes[i], builder.type());
            .addFields("field1")
            .setTieBreaker(0.5f)
        MultiMatchQueryBuilder builderEmpty = fromProto(protoEmpty);
            MultiMatchQueryBuilder.Type.PHRASE,
            MultiMatchQueryBuilder builder = fromProto(proto);
        // Test all MultiTermQueryRewrite enum values
            .setQuery("test query")
            .setMaxExpansions(10)
        // Convert to MultiMatchQueryBuilder
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setString("2").build())
    public void testFromProtoWithAllFuzzyRewriteValues() {
    }
            .setQuery("test")
                .build();
        // 4. Convert the proto to a MultiMatchQueryBuilder
            .setFuzzyTranspositions(false)
    public void testFromProtoWithoutFuzzyRewrite() {
        assertNull("FuzzyRewrite should be null when not set", builder.fuzzyRewrite());
    public void testFromProtoWithRequiredFieldsOnly() {
        assertNull(builder.fuzzyRewrite());
        Set<String> expectedFields = new HashSet<>(Arrays.asList("field1", "field2", "field3"));
        assertNull("Fuzziness should be null (EMPTY)", builderEmpty.fuzziness());
        assertEquals("test query", builderInt.value());
        assertFalse(builder.autoGenerateSynonymsPhraseQuery());
            MultiMatchQueryBuilder builder = fromProto(proto);
        assertEquals(fromXContent.fuzzyTranspositions(), fromProto.fuzzyTranspositions());
    }
import org.opensearch.protobufs.TextQueryType;
            TextQueryType.TEXT_QUERY_TYPE_BEST_FIELDS,
import static org.opensearch.transport.grpc.proto.request.search.query.MultiMatchQueryBuilderProtoUtils.fromProto;
            .setQuery("test query")
    }
            .addFields("field1")
            .setType(TextQueryType.TEXT_QUERY_TYPE_UNSPECIFIED)
            MultiMatchQueryBuilder.Type.MOST_FIELDS,
        assertEquals(MultiMatchQueryBuilder.DEFAULT_OPERATOR, builder.operator()); // Should keep default
            .setFuzzyRewrite("top_terms_blended_freqs_10")
            .setQuery("test query")
            .addFields("field1")
    }
        super.setUp();
        assertEquals(1.0f, builder.fields().get("field1"), 0.001f);
                .build();
        assertNull(builder.minimumShouldMatch());
            .setXName("test_query")
        assertNull(builder.queryName());
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
import org.opensearch.index.query.Operator;
        assertEquals("2", builder.minimumShouldMatch());
        assertTrue(builder.lenient());
            .addFields("field1")
        MatchQuery.ZeroTermsQuery[] expectedZeroTermsQueries = { MatchQuery.ZeroTermsQuery.NONE, MatchQuery.ZeroTermsQuery.ALL };
            .setFuzziness(org.opensearch.protobufs.Fuzziness.newBuilder().setInt32(2).build())
        assertEquals(fromXContent.lenient(), fromProto.lenient());
 * this file be licensed under the Apache-2.0 license or a
import java.util.HashSet;
        MultiMatchQueryBuilder builder = fromProto(proto);
            TextQueryType.TEXT_QUERY_TYPE_MOST_FIELDS,
    @Override
        MultiMatchQueryBuilder builder = fromProto(proto);
            .setFuzzyTranspositions(false)
        MultiMatchQuery protoString = MultiMatchQuery.newBuilder()
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> fromProto(proto));
            MultiMatchQuery proto = MultiMatchQuery.newBuilder().setQuery("test query").addFields("field1").setType(types[i]).build();
        MultiMatchQueryBuilder builder = fromProto(proto);
            .setFuzzyRewrite("constant_score_boolean")
        assertEquals("constant_score", fromProto(protoConstantScore).fuzzyRewrite());
            .setSlop(2) // Non-default slop with BOOL_PREFIX should throw exception
public class MultiMatchQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
        parser.nextToken(); // Move to the first token
        assertEquals(fromXContent.value(), fromProto.value());
        assertFalse(builder.fuzzyTranspositions());
    }
            .setQuery("test")
            .build();
        MultiMatchQuery protoScoringBoolean = MultiMatchQuery.newBuilder()
        for (int i = 0; i < types.length; i++) {
 * The OpenSearch Contributors require contributions made to
        // Create a proto with int32 minimum_should_match
        assertEquals("constant_score_boolean", fromProto(protoConstantScoreBoolean).fuzzyRewrite());
        // Verify all properties
        MultiMatchQueryBuilder builder = fromProto(proto);
 *
    public void testFromProtoWithNoFields() {
            MultiMatchQueryBuilder.Type.BEST_FIELDS,
        assertEquals("test query", builderEmpty.value());
 * compatible open source license.
        assertTrue(builder.fields().containsKey("field2"));
    }
            .setType(TextQueryType.TEXT_QUERY_TYPE_PHRASE)
        for (int i = 0; i < operators.length; i++) {
    public void testFromProtoWithDifferentTypes() {
            + "  \"zero_terms_query\": \"ALL\",\n"
import org.opensearch.protobufs.MultiMatchQuery;
            + "  \"type\": \"phrase\",\n"
            .addFields("field1")
            .setFuzzyRewrite("constant_score")
        MultiMatchQuery proto = MultiMatchQuery.newBuilder().setQuery("test query").build();
            + "  \"query\": \"test query\",\n"
        MultiMatchQueryBuilder builder = fromProto(proto);
    /**
            .setType(TextQueryType.TEXT_QUERY_TYPE_PHRASE)
        MultiMatchQuery protoConstantScore = MultiMatchQuery.newBuilder()
        MultiMatchQueryBuilder builder = fromProto(proto);
import java.io.IOException;
        // Verify fuzzyRewrite is null when not set
    }
        // Test all possible types
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
        assertEquals("top_terms_boost_10", fromProto(protoTopTermsBoost).fuzzyRewrite());
        // Convert to MultiMatchQueryBuilder
        // Convert to MultiMatchQueryBuilder
        assertEquals("test query", builder.value());
            .addFields("field1")
        assertTrue("Fields should be empty", builder.fields().isEmpty());
            .build();
        assertNull("MinimumShouldMatch should be null when neither string nor int32 is set", builder.minimumShouldMatch());
        assertEquals("test query", builderString.value());
    public void testFromProtoWithUnspecifiedOperator() {
        assertTrue("Exception message should mention slop not allowed", exception.getMessage().contains("slop not allowed for type"));
            TextQueryType.TEXT_QUERY_TYPE_PHRASE,
            .build();
        // Create a proto with multiple fields
        assertEquals(MultiMatchQueryBuilder.Type.PHRASE, builder.type());
                .addFields("field1")
        assertEquals(fromXContent.tieBreaker(), fromProto.tieBreaker(), 0.001f);
        assertEquals("top_terms_10", fromProto(protoTopTermsN).fuzzyRewrite());
            .setSlop(2)
                .setZeroTermsQuery(zeroTermsQueries[i])
            .addFields("field1")
        assertEquals(expectedFields, builder.fields().keySet());
        MultiMatchQuery protoEmpty = MultiMatchQuery.newBuilder()
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
        assertEquals(fromXContent.fields(), fromProto.fields());
            + "  \"auto_generate_synonyms_phrase_query\": false,\n"
            .build();
        MultiMatchQuery protoTopTermsBlended = MultiMatchQuery.newBuilder()
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_UNSPECIFIED)
            MultiMatchQueryBuilder.Type.BOOL_PREFIX };
        assertEquals(2, builder.fields().size());
            .addFields("field1")
            .build();
            + "  \"lenient\": true,\n"
            assertEquals(expectedOperators[i], builder.operator());
            .setQuery("test")
    public void testFromProtoWithIntMinimumShouldMatch() {
            .addFields("field1")
        assertEquals(fromXContent.analyzer(), fromProto.analyzer());
            + "  \"fuzzy_transpositions\": false,\n"
        assertEquals(fromXContent.slop(), fromProto.slop());
            + "  \"fields\": [\"field1\", \"field2\"],\n"
        // Test with OPERATOR_UNSPECIFIED to cover default case in operator switch
            .setQuery("test")
        assertEquals(MultiMatchQueryBuilder.DEFAULT_PREFIX_LENGTH, builder.prefixLength());
            .addFields("field3")
            .setBoost(2.0f)
            .build();
}
import java.util.Set;
        MultiMatchQueryBuilder builder = fromProto(proto);
            .build();
        MultiMatchQueryBuilder.Type[] expectedTypes = {
        // Verify fields
        assertEquals(2.0f, builder.boost(), 0.001f);
        assertEquals(fromXContent.queryName(), fromProto.queryName());
    public void testFromProtoWithUnspecifiedType() {
        assertEquals(1.0f, builder.fields().get("field2"), 0.001f);
        assertEquals(Operator.AND, builder.operator());
            + "  \"prefix_length\": 3,\n"
        MultiMatchQueryBuilder builder = fromProto(proto);
            .build();
        // Test BOOL_PREFIX with default slop (should work fine)
            MultiMatchQueryBuilder builder = fromProto(proto);
        // Test 3: Fuzziness with empty/neither string nor int32
    public void testFromProtoWithSlopValidationForBoolPrefix() {
            TextQueryType.TEXT_QUERY_TYPE_BOOL_PREFIX };
import java.util.Arrays;
        MultiMatchQueryBuilder fromXContent = MultiMatchQueryBuilder.fromXContent(parser);
    // ========== Missing Coverage Tests ==========
                .setQuery("test query")
        assertEquals(fromXContent.prefixLength(), fromProto.prefixLength());
            .setType(TextQueryType.TEXT_QUERY_TYPE_BOOL_PREFIX)
            .addFields("field1")
        // Test with MinimumShouldMatch that has neither string nor int32 to cover the else if branch
            .setMaxExpansions(10)
            .setFuzzyRewrite("constant_score")
        assertEquals(fromXContent.maxExpansions(), fromProto.maxExpansions());
            .build();
                .setQuery("test query")
    }
        assertEquals("test query", builder.value());
        TextQueryType[] types = {
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
import org.opensearch.index.query.MultiMatchQueryBuilder;
            MultiMatchQuery proto = MultiMatchQuery.newBuilder()
    public void testFromProtoMatchesFromXContent() throws IOException {
        assertEquals(MatchQuery.ZeroTermsQuery.ALL, builder.zeroTermsQuery());
        assertEquals(fromXContent.operator(), fromProto.operator());
        // 3. Create an equivalent MultiMatchQuery proto
        MultiMatchQuery proto = MultiMatchQuery.newBuilder().setQuery("test query").addFields("field1").build();
import org.opensearch.protobufs.ZeroTermsQuery;
        assertEquals("scoring_boolean", fromProto(protoScoringBoolean).fuzzyRewrite());
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
package org.opensearch.transport.grpc.proto.request.search.query;
    public void testFromProtoWithAllFields() {
        assertEquals(2, builder.slop());
            .setFuzzyRewrite("top_terms_10")
            MultiMatchQueryBuilder.Type.PHRASE_PREFIX,
        assertTrue(builder.fields().containsKey("field1"));
    }
            .build();
            .setAutoGenerateSynonymsPhraseQuery(false)
        assertEquals("test query", builder.value());
            .build();
            .setQuery("test query")
            org.opensearch.protobufs.Operator.OPERATOR_OR };
            .setFuzziness(org.opensearch.protobufs.Fuzziness.newBuilder().setString("AUTO").build())
        assertEquals("top_terms_blended_freqs_10", fromProto(protoTopTermsBlended).fuzzyRewrite());
        assertEquals(MultiMatchQueryBuilder.Type.BOOL_PREFIX, builder.type());
        // Convert to MultiMatchQueryBuilder
    public void testFromProtoWithZeroTermsQueryUnspecified() {
    }
        MultiMatchQuery protoInt = MultiMatchQuery.newBuilder()
            .setPrefixLength(3)
    public void testFromProtoWithMinimumShouldMatchNeitherStringNorInt() {
    public void setUp() throws Exception {
            .setSlop(2)
            .setQuery("test query")
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setString("2").build())
        MultiMatchQueryBuilder builder = fromProto(proto);
        MultiMatchQueryBuilder builderInt = fromProto(protoInt);
        // Create a proto with string minimum_should_match
        // Test 1: Fuzziness with string value
    public void testFromProtoWithStringMinimumShouldMatch() {
        Operator[] expectedOperators = { Operator.AND, Operator.OR };
        }
            .setQuery("test query")
        assertNull(builder.analyzer());
            + "  \"max_expansions\": 10,\n"
            TextQueryType.TEXT_QUERY_TYPE_PHRASE_PREFIX,
        MultiMatchQueryBuilder builder = fromProto(proto);
        assertEquals("test query", builder.value());
            .build();
            + "  \"minimum_should_match\": \"2\",\n"
            .setBoost(2.0f)
            .addFields("field1")
        assertEquals(1.0f, builder.fields().get("field1"), 0.001f);
import org.opensearch.test.OpenSearchTestCase;
            + "  \"_name\": \"test_query\"\n"
        assertEquals("test query", builder.value());
        assertEquals(MultiMatchQueryBuilder.DEFAULT_TYPE, builder.type()); // Should keep default
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_UNSPECIFIED)
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("test query", builder.value());
            .setQuery("test query")
import org.opensearch.index.search.MatchQuery;
        assertEquals("75%", builder.minimumShouldMatch());
import org.opensearch.core.xcontent.XContentParser;
    public void testFromProtoWithMultipleFields() {
        assertEquals("test query", builder.value());
        assertEquals(10, builder.maxExpansions());
        MultiMatchQueryBuilder builderString = fromProto(protoString);
            .addFields("field1")
        assertNotNull("Fuzziness should not be null (INT32)", builderInt.fuzziness());
            .setFuzzyRewrite("scoring_boolean")
        MultiMatchQuery protoTopTermsN = MultiMatchQuery.newBuilder()
    public void testFromProtoWithFuzziness() {
        // Test that missing fuzzyRewrite field results in null
            .build();
            + "  \"operator\": \"AND\",\n"
    }
            .setXName("test_query")

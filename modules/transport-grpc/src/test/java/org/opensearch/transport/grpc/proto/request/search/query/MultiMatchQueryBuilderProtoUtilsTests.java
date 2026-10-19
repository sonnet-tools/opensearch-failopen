            .setBoost(2.0f)  
        assertEquals(expectedFields, builder.fields().keySet());
            assertEquals(expectedZeroTermsQueries[i], builder.zeroTermsQuery());
        assertTrue("Exception message should mention BOOL_PREFIX", exception.getMessage().contains("BOOL_PREFIX"));  
            .setFuzzyRewrite("constant_score")  
            .setPrefixLength(3)
            + "  \"lenient\": true,\n"
    }  
        // Create a proto with string minimum_should_match
import org.opensearch.index.query.MultiMatchQueryBuilder;
        assertEquals(fromXContent.zeroTermsQuery(), fromProto.zeroTermsQuery());
        assertNull(builder.analyzer());
        assertEquals("test query", builder.value());
        assertEquals("constant_score", builder.fuzzyRewrite());  
 *
 * this file be licensed under the Apache-2.0 license or a
            .setXName("test_query")  
        assertEquals("top_terms_10", fromProto(protoTopTermsN).fuzzyRewrite());
    }
            .setQuery("test query")
        assertNull(builder.tieBreaker());  
        QueryBuilderProtoTestUtils.setupRegistry();
            TextQueryType.TEXT_QUERY_TYPE_CROSS_FIELDS,  
        // Verify minimum_should_match  
import static org.opensearch.transport.grpc.proto.request.search.query.MultiMatchQueryBuilderProtoUtils.fromProto;  
        MultiMatchQuery protoString = MultiMatchQuery.newBuilder()  
        // 4. Convert the proto to a MultiMatchQueryBuilder  
        assertFalse(builder.fuzzyTranspositions());
        assertEquals("constant_score_boolean", fromProto(protoConstantScoreBoolean).fuzzyRewrite());  
        MultiMatchQueryBuilder builder = fromProto(proto);
        assertEquals(3, builder.prefixLength());
        // Test all MultiTermQueryRewrite enum values
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setString("2").build())
        MultiMatchQueryBuilder builderEmpty = fromProto(protoEmpty);
        assertEquals(fromXContent.minimumShouldMatch(), fromProto.minimumShouldMatch());  
        assertEquals("constant_score", fromProto(protoConstantScore).fuzzyRewrite());
            .addFields("field1")
        assertEquals("top_terms_blended_freqs_10", fromProto(protoTopTermsBlended).fuzzyRewrite());  
            MultiMatchQueryBuilder.Type.CROSS_FIELDS,
                .setOperator(operators[i])  
            .addFields("field1")  
            .setFuzzyRewrite("constant_score")
        // Test with OPERATOR_UNSPECIFIED to cover default case in operator switch
            MultiMatchQueryBuilder.Type.PHRASE_PREFIX,
        // Test with TEXT_QUERY_TYPE_UNSPECIFIED to cover default case in switch  
            // No slop set - should use default  
        // Test all possible operators
            .setQuery("test query")
            .addFields("field1")
    public void testFromProtoWithNoFields() {
            MultiMatchQueryBuilder.Type.PHRASE,  
        assertEquals(MultiMatchQueryBuilder.DEFAULT_ZERO_TERMS_QUERY, builder.zeroTermsQuery()); // Should keep default
            .setType(TextQueryType.TEXT_QUERY_TYPE_PHRASE)
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
    public void testFromProtoWithAllFields() {
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setString("2").build())
        assertEquals(1.0f, builder.fields().get("field1"), 0.001f);  
        MultiMatchQuery proto = MultiMatchQuery.newBuilder().setQuery("test query").addFields("field1").build();
        // Set up the registry with all built-in converters
            .addFields("field1")  
        // Convert to MultiMatchQueryBuilder
            .addFields("field1")
            .build();
            .setQuery("test query")  
            .build();
        assertEquals(fromXContent.fields(), fromProto.fields());
        MultiMatchQueryBuilder builder = fromProto(proto);
        assertEquals("test query", builder.value());
    }
        // Convert to MultiMatchQueryBuilder  
        org.opensearch.protobufs.Operator[] operators = {
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_UNSPECIFIED)  
        assertEquals("test query", builderInt.value());
        TextQueryType[] types = {  
            MultiMatchQueryBuilder builder = fromProto(proto);  
        assertEquals(10, builder.maxExpansions());  
        Operator[] expectedOperators = { Operator.AND, Operator.OR };  
            .setFuzzyTranspositions(false)
        String json = "{\n"
            .setQuery("test")  
    }
    public void testFromProtoWithZeroTermsQueryUnspecified() {
            org.opensearch.protobufs.Operator.OPERATOR_AND,  
        MultiMatchQuery proto = MultiMatchQuery.newBuilder().setQuery("test query").build();  
        MultiMatchQueryBuilder builder = fromProto(proto);
     */
    public void testFromProtoWithAllFuzzyRewriteValues() {
            .addFields("field2")  
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_AND)  
        MultiMatchQuery protoEmpty = MultiMatchQuery.newBuilder()  
            org.opensearch.protobufs.Operator.OPERATOR_OR };
            MultiMatchQuery proto = MultiMatchQuery.newBuilder()  
 * The OpenSearch Contributors require contributions made to  
        MultiMatchQuery protoTopTermsBlended = MultiMatchQuery.newBuilder()
            .setFuzzyRewrite("top_terms_blended_freqs_10")
            .setQuery("test query")
public class MultiMatchQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
        MultiMatchQuery protoTopTermsBoost = MultiMatchQuery.newBuilder()
        assertEquals("test_query", builder.queryName());
                .setQuery("test query")
            MultiMatchQueryBuilder builder = fromProto(proto);  
            .build();
    }  
            .build();  
        assertTrue(builder.lenient());
            .setQuery("test query")
            .build();
        assertEquals(Operator.AND, builder.operator());
            .setMaxExpansions(10)  
        assertEquals("test query", builder.value());
        // 5. Compare the two builders  
        MatchQuery.ZeroTermsQuery[] expectedZeroTermsQueries = { MatchQuery.ZeroTermsQuery.NONE, MatchQuery.ZeroTermsQuery.ALL };  
            .build();
            + "  \"analyzer\": \"standard\",\n"
    }  
            .setQuery("test query")  
        assertNull("Fuzziness should be null (EMPTY)", builderEmpty.fuzziness());
        MultiMatchQuery protoScoringBoolean = MultiMatchQuery.newBuilder()
     * Test that compares the results of fromXContent and fromProto to ensure they produce equivalent results.  
        // Test with fieldsCount = 0 to cover line 60 branch
    }
        // Convert to MultiMatchQueryBuilder  
            + "  \"zero_terms_query\": \"ALL\",\n"
        assertNull(builder.fuzzyRewrite());
        }  
        assertNull(builder.minimumShouldMatch());
            + "  \"fuzzy_rewrite\": \"constant_score\",\n"
        assertEquals("2", builder.minimumShouldMatch());
            .setFuzzyRewrite("constant_score_boolean")
import java.util.Arrays;
            MultiMatchQuery proto = MultiMatchQuery.newBuilder()  
import java.util.Set;
            MultiMatchQueryBuilder.Type.BEST_FIELDS,  
        MultiMatchQueryBuilder builderInt = fromProto(protoInt);  
            .addFields("field1")  
        for (int i = 0; i < zeroTermsQueries.length; i++) {
            .setXName("test_query")
        assertEquals(Fuzziness.build("AUTO"), builderString.fuzziness());
        assertEquals(0.5f, builder.tieBreaker(), 0.001f);
            + "  \"fields\": [\"field1\", \"field2\"],\n"  
import org.opensearch.protobufs.ZeroTermsQuery;
            .addFields("field2")
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_UNSPECIFIED)
        // Create a proto with multiple fields  
import org.opensearch.common.xcontent.json.JsonXContent;
        // Test with ZERO_TERMS_QUERY_UNSPECIFIED to cover lines 152-154  
            .setTieBreaker(0.5f)
            .build();
    }  
        // Create a proto with int32 minimum_should_match
        assertEquals(1.0f, builder.fields().get("field1"), 0.001f);  
        assertEquals(MultiMatchQueryBuilder.DEFAULT_PHRASE_SLOP, builder.slop());  
            .build();
        MultiMatchQueryBuilder builderString = fromProto(protoString);
                .setQuery("test query")
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()  
            .build();
            .setQuery("test query")
            .setFuzziness(org.opensearch.protobufs.Fuzziness.newBuilder().setInt32(2).build())
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)  
            .setSlop(2)
            .setType(TextQueryType.TEXT_QUERY_TYPE_PHRASE)
            .setType(TextQueryType.TEXT_QUERY_TYPE_BOOL_PREFIX)  
            + "  \"prefix_length\": 3,\n"
        assertEquals(MultiMatchQueryBuilder.DEFAULT_OPERATOR, builder.operator());  
            .setQuery("test query")
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
        super.setUp();  
        MultiMatchQuery protoConstantScoreBoolean = MultiMatchQuery.newBuilder()
            .setQuery("test query")
        assertEquals(3, builder.fields().size());  
            .setQuery("test")
        ZeroTermsQuery[] zeroTermsQueries = { ZeroTermsQuery.ZERO_TERMS_QUERY_NONE, ZeroTermsQuery.ZERO_TERMS_QUERY_ALL };
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_AND)
        // 2. Parse the JSON to create a MultiMatchQueryBuilder via fromXContent  
            .addFields("field1")  
        MultiMatchQueryBuilder fromProto = MultiMatchQueryBuilderProtoUtils.fromProto(proto);
            .setFuzzyRewrite("constant_score")  
    public void testFromProtoWithDifferentZeroTermsQuery() {
        // Test all possible types
            .addFields("field1")  
        MultiMatchQueryBuilder builder = fromProto(proto);
import org.opensearch.protobufs.MinimumShouldMatch;
    public void testFromProtoWithoutFuzzyRewrite() {
            .setAutoGenerateSynonymsPhraseQuery(false)
            .addFields("field1")  
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
    public void testFromProtoWithStringMinimumShouldMatch() {
    }  
        assertEquals(MultiMatchQueryBuilder.DEFAULT_TYPE, builder.type());
            .build();
            .addFields("field1")
        }
        MultiMatchQueryBuilder builder = fromProto(proto);
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
/*  
        assertEquals(2.0f, builder.boost(), 0.001f);  
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
        assertEquals(2, builder.fields().size());  
import org.opensearch.test.OpenSearchTestCase;
    public void testFromProtoMatchesFromXContent() throws IOException {
    }  
            .setFuzzyRewrite("top_terms_10")  
            .setAutoGenerateSynonymsPhraseQuery(false)  
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()  
        assertEquals(MatchQuery.ZeroTermsQuery.ALL, builder.zeroTermsQuery());  
}
            .setLenient(true)
            .setMaxExpansions(10)
        assertEquals("75%", builder.minimumShouldMatch());
            .build();
    public void testFromProtoWithRequiredFieldsOnly() {
            .build();
            + "  \"operator\": \"AND\",\n"  
    @Override
        assertTrue(builder.fields().containsKey("field2"));
        assertEquals(MultiMatchQueryBuilder.DEFAULT_PHRASE_SLOP, builder.slop());
        // 1. Create a JSON string for XContent parsing  
    public void setUp() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        MultiMatchQueryBuilder fromXContent = MultiMatchQueryBuilder.fromXContent(parser);  
        // Test BOOL_PREFIX with default slop (should work fine)
            .setQuery("test")  
            .setLenient(true)
    }
        assertEquals(fromXContent.fuzzyRewrite(), fromProto.fuzzyRewrite());
 */  
            .build();  
    }
import org.opensearch.protobufs.TextQueryType;  
            .addFields("field1")  
            + "}";
            MultiMatchQuery proto = MultiMatchQuery.newBuilder().setQuery("test query").addFields("field1").setType(types[i]).build();
            .setAnalyzer("standard")  
        MultiMatchQueryBuilder builder = fromProto(proto);  
            .setFuzziness(org.opensearch.protobufs.Fuzziness.newBuilder().setString("AUTO").build())  
        // Verify minimum_should_match  
    // ========== Missing Coverage Tests ==========
        assertTrue("Exception message should mention slop not allowed", exception.getMessage().contains("slop not allowed for type"));
            .addFields("field1")
            MultiMatchQueryBuilder.Type.MOST_FIELDS,
            .setType(TextQueryType.TEXT_QUERY_TYPE_UNSPECIFIED)
            .setPrefixLength(3)
            .setQuery("test")
            .addFields("field1")
        assertTrue(builder.fields().containsKey("field1"));
    }  
            .setQuery("test query")
        // Verify basic properties  
import org.opensearch.protobufs.MultiMatchQuery;
        // Create a minimal MultiMatchQuery proto with only required fields  
            .setType(TextQueryType.TEXT_QUERY_TYPE_BOOL_PREFIX)
        // 3. Create an equivalent MultiMatchQuery proto
        assertEquals(Fuzziness.fromEdits(2), builderInt.fuzziness());  
        assertNull("MinimumShouldMatch should be null when neither string nor int32 is set", builder.minimumShouldMatch());
        // Test 3: Fuzziness with empty/neither string nor int32
        // Test with MinimumShouldMatch that has neither string nor int32 to cover the else if branch
        assertEquals(MultiMatchQueryBuilder.Type.BOOL_PREFIX, builder.type());  
            + "  \"tie_breaker\": 0.5,\n"  
        assertEquals(fromXContent.slop(), fromProto.slop());
import org.opensearch.index.query.Operator;
    }
            .build();
        MultiMatchQueryBuilder builder = fromProto(proto);
        MultiMatchQueryBuilder builder = fromProto(proto);
            .setTieBreaker(0.5f)  
        MultiMatchQuery proto = MultiMatchQuery.newBuilder().setQuery("test query").addFields("field1").build();  
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()  
        assertEquals(1.0f, builder.boost(), 0.001f);
        // Verify fuzzyRewrite is null when not set
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()  
        MultiMatchQueryBuilder.Type[] expectedTypes = {
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setInt32(2).build())  
    }  
        assertEquals(fromXContent.operator(), fromProto.operator());
    public void testFromProtoWithDifferentOperators() {  
        assertFalse(builder.autoGenerateSynonymsPhraseQuery());
        assertEquals(MultiMatchQueryBuilder.DEFAULT_PREFIX_LENGTH, builder.prefixLength());
        MultiMatchQueryBuilder builder = fromProto(proto);
            TextQueryType.TEXT_QUERY_TYPE_BOOL_PREFIX };  
        assertNotNull("Fuzziness should not be null (STRING)", builderString.fuzziness());
            .addFields("field1")
            + "  \"query\": \"test query\",\n"
        for (int i = 0; i < operators.length; i++) {
    public void testFromProtoWithIntMinimumShouldMatch() {
            MultiMatchQueryBuilder builder = fromProto(proto);
            assertEquals(expectedOperators[i], builder.operator());
                .build();
import java.util.HashSet;  
        // Test all possible zero_terms_query values  
        assertEquals("top_terms_boost_10", fromProto(protoTopTermsBoost).fuzzyRewrite());
        assertEquals(fromXContent.analyzer(), fromProto.analyzer());
        MultiMatchQuery protoInt = MultiMatchQuery.newBuilder()
        assertEquals(2, builder.slop());
            + "  \"auto_generate_synonyms_phrase_query\": false,\n"  
        MultiMatchQueryBuilder builder = fromProto(proto);  
    }
            + "  \"slop\": 2,\n"  
        assertEquals("2", builder.minimumShouldMatch());
        parser.nextToken(); // Move to the first token
    /**
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)
    }
                .build();
        // Test that missing fuzzyRewrite field results in null
        assertEquals("test query", builder.value());
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().setString("75%").build())  
            .setQuery("test")
            .setBoost(2.0f)
        // Convert to MultiMatchQueryBuilder  
        assertEquals("test query", builderEmpty.value());  
        assertEquals(fromXContent.fuzzyTranspositions(), fromProto.fuzzyTranspositions());  
            + "  \"fuzzy_transpositions\": false,\n"
package org.opensearch.transport.grpc.proto.request.search.query;
import org.opensearch.index.search.MatchQuery;  
import org.opensearch.common.unit.Fuzziness;
            TextQueryType.TEXT_QUERY_TYPE_BEST_FIELDS,
            .build();
    }
    public void testFromProtoWithSlopValidationForBoolPrefix() {
            .setFuzziness(org.opensearch.protobufs.Fuzziness.newBuilder().build())  
        assertEquals(fromXContent.prefixLength(), fromProto.prefixLength());  
            .setSlop(2)  
            .addFields("field1")
            .setQuery("test query")
        assertEquals(MultiMatchQueryBuilder.DEFAULT_MAX_EXPANSIONS, builder.maxExpansions());
        assertEquals("standard", builder.analyzer());  
                .setZeroTermsQuery(zeroTermsQueries[i])  
import java.io.IOException;
        }
            .setSlop(2) // Non-default slop with BOOL_PREFIX should throw exception
            .build();
            assertEquals(expectedTypes[i], builder.type());
            .setQuery("test query")
        assertEquals("test query", builder.value());
            + "  \"_name\": \"test_query\"\n"  
        assertEquals("test query", builderString.value());  
    public void testFromProtoWithMinimumShouldMatchNeitherStringNorInt() {  
        assertEquals(MultiMatchQueryBuilder.DEFAULT_OPERATOR, builder.operator()); // Should keep default  
            .build();  
            .setQuery("test")
            + "  \"minimum_should_match\": \"2\",\n"
            .addFields("field1")
            .setFuzzyRewrite("top_terms_boost_10")
        assertTrue("Fields should be empty", builder.fields().isEmpty());
            .setQuery("test query")
        assertEquals(MultiMatchQueryBuilder.Type.PHRASE, builder.type());
        assertEquals("test query", builder.value());  
    public void testFromProtoWithBoolPrefixAndDefaultSlop() {  
            .setAnalyzer("standard")
            .build();
        // Verify fields
            .addFields("field3")
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()  
        assertTrue(builder.fields().containsKey("field1"));
            .build();
            .setQuery("test query")
        assertNull(builder.queryName());
    }
 * compatible open source license.
            + "  \"boost\": 2.0,\n"
        assertEquals(fromXContent.queryName(), fromProto.queryName());
        assertEquals(fromXContent.value(), fromProto.value());
        MultiMatchQuery proto = MultiMatchQuery.newBuilder()
        assertEquals(fromXContent.type(), fromProto.type());  
        assertEquals(fromXContent.maxExpansions(), fromProto.maxExpansions());
        for (int i = 0; i < types.length; i++) {
        // Convert to MultiMatchQueryBuilder
        // Create a complete MultiMatchQuery proto with all fields set  
        MultiMatchQueryBuilder builder = fromProto(proto);  
    public void testFromProtoWithMultipleFields() {
            .addFields("field1")
        // Verify all properties
            + "  \"type\": \"phrase\",\n"
    public void testFromProtoWithUnspecifiedOperator() {
            MultiMatchQueryBuilder.Type.BOOL_PREFIX };
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> fromProto(proto));
        assertEquals(fromXContent.lenient(), fromProto.lenient());  
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
        assertEquals(fromXContent.boost(), fromProto.boost(), 0.001f);
        MultiMatchQuery protoTopTermsN = MultiMatchQuery.newBuilder()  
        Set<String> expectedFields = new HashSet<>(Arrays.asList("field1", "field2", "field3"));
        assertEquals("test query", builder.value());  
            .addFields("field1")
    public void testFromProtoWithDifferentTypes() {
        MultiMatchQueryBuilder builder = fromProto(proto);
        assertEquals("scoring_boolean", fromProto(protoScoringBoolean).fuzzyRewrite());
        assertEquals(fromXContent.tieBreaker(), fromProto.tieBreaker(), 0.001f);
                .addFields("field1")
        assertEquals("test query", builder.value());
            .setFuzzyRewrite("scoring_boolean")
            TextQueryType.TEXT_QUERY_TYPE_PHRASE_PREFIX,
            TextQueryType.TEXT_QUERY_TYPE_MOST_FIELDS,
        // Test 1: Fuzziness with string value
            .setMinimumShouldMatch(MinimumShouldMatch.newBuilder().build()) // Empty - no string or int32
    }  
        MultiMatchQuery protoConstantScore = MultiMatchQuery.newBuilder()  
            .build();  
                .addFields("field1")
        assertEquals(MultiMatchQueryBuilder.DEFAULT_TYPE, builder.type()); // Should keep default
    public void testFromProtoWithFuzziness() {
        assertNotNull("Fuzziness should not be null (INT32)", builderInt.fuzziness());
        assertEquals(1.0f, builder.fields().get("field2"), 0.001f);
            .addFields("field1")
import org.opensearch.core.xcontent.XContentParser;  
            .addFields("field1")
    public void testFromProtoWithUnspecifiedType() {
            .addFields("field2")
        // Test slop validation for BOOL_PREFIX type to cover lines 172-173
        assertEquals(fromXContent.autoGenerateSynonymsPhraseQuery(), fromProto.autoGenerateSynonymsPhraseQuery());
            .setFuzzyTranspositions(false)
            TextQueryType.TEXT_QUERY_TYPE_PHRASE,
        assertNull("FuzzyRewrite should be null when not set", builder.fuzzyRewrite());
            + "  \"max_expansions\": 10,\n"

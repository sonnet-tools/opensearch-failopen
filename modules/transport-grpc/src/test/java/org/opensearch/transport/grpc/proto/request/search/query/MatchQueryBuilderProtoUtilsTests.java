            .build();
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);
}
            .setQuery(queryValue)
    public void testFromProtoWithMinimumShouldMatch() {
        assertEquals("Fuzzy rewrite should match (CONSTANT_SCORE)", "constant_score", builderWithRewrite.fuzzyRewrite());
            .setMaxExpansions(50)
            .setField("message")
            .setQuery(queryValue)
            .setField("message")
        assertEquals("Minimum should match (INT32)", "2", builderInt.minimumShouldMatch());
        org.opensearch.protobufs.MatchQuery queryEmpty = org.opensearch.protobufs.MatchQuery.newBuilder()
            .build();
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()
            .setField("message")
        // Test 1: FuzzyRewrite with CONSTANT_SCORE value
        org.opensearch.protobufs.Fuzziness fuzzinessInt = org.opensearch.protobufs.Fuzziness.newBuilder().setInt32(2).build();
            .build();
        FieldValue queryValue = FieldValue.newBuilder().setString("search text").build();
        // Test 3: MinimumShouldMatch with empty/neither
        assertEquals("Fuzziness should match (STRING)", Fuzziness.AUTO, builderString.fuzziness());
        MatchQueryBuilder builderInt = MatchQueryBuilderProtoUtils.fromProto(queryInt);
            .build();
            .setField("message")
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();
        MatchQueryBuilder builderInt = MatchQueryBuilderProtoUtils.fromProto(queryInt);
 * The OpenSearch Contributors require contributions made to
            .setFuzziness(fuzzinessInt)
        assertEquals("Zero terms query should match", MatchQuery.ZeroTermsQuery.ALL, matchQueryBuilder.zeroTermsQuery());
    public void testFromProtoWithBasicMatchQuery() {
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);
        assertEquals("Lenient should match", true, matchQueryBuilder.lenient());
    public void testFromProtoWithAllParameters() {
            .build();
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);
        // Test 1: Fuzziness with string value
        assertEquals("Field name should match", "message", matchQueryBuilder.fieldName());
            .setField("message")
            .setString("75%")
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Zero terms query should match", MatchQuery.ZeroTermsQuery.ALL, matchQueryBuilder.zeroTermsQuery());
        assertNull("Minimum should match should be null (EMPTY)", builderEmpty.minimumShouldMatch());
 * SPDX-License-Identifier: Apache-2.0
    }
            .setBoost(1.5f)
        MatchQueryBuilder builderEmpty = MatchQueryBuilderProtoUtils.fromProto(queryEmpty);
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();
        org.opensearch.protobufs.Fuzziness fuzzinessString = org.opensearch.protobufs.Fuzziness.newBuilder().setString("AUTO").build();
            .setField("message")
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);
            .setField("message")
        assertEquals("Operator should be default OR", Operator.OR, matchQueryBuilder.operator());
            .setMinimumShouldMatch(minimumShouldMatchEmpty)
import org.opensearch.common.unit.Fuzziness;
            .build();
            .setQuery(queryValue)
import org.opensearch.protobufs.FieldValue;
    public void testFromProtoWithAutoGenerateSynonymsPhraseQueryFalse() {
    }
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();
        assertEquals("Operator should be default OR", Operator.OR, matchQueryBuilder.operator());
            .setQuery(queryValue)
            .setQuery(queryValue)
            .setXName("test_query")
    public void testFromProtoWithOperatorUnspecified() {
    }
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_OR)
public class MatchQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
        assertEquals("Fuzzy transpositions should match", false, matchQueryBuilder.fuzzyTranspositions());
        assertNotNull("Builder should not be null (EMPTY)", builderEmpty);
            .setFuzziness(fuzziness)
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);
        org.opensearch.protobufs.MatchQuery queryString = org.opensearch.protobufs.MatchQuery.newBuilder()
        assertEquals("Fuzziness should match", Fuzziness.AUTO, matchQueryBuilder.fuzziness());
        assertNotNull("Builder should not be null (STRING)", builderString);
        // Test 2: MinimumShouldMatch with int32 value
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()
 * compatible open source license.
        assertEquals("Query should match", "search text", matchQueryBuilder.value());
import org.opensearch.index.query.MatchQueryBuilder;
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()
 */
        assertEquals("Operator should match", Operator.AND, matchQueryBuilder.operator());
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();
    }
            .setFuzziness(fuzzinessEmpty)
            .setQuery(queryValue)
        assertNotNull("Builder should not be null (INT32)", builderInt);
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);
        org.opensearch.protobufs.Fuzziness fuzziness = org.opensearch.protobufs.Fuzziness.newBuilder().setString("AUTO").build();
        // Test 3: Fuzziness with empty/neither string nor int32
            .setQuery(queryValue)
            .setFuzzyRewrite("constant_score")
            .setAutoGenerateSynonymsPhraseQuery(false)
            .setQuery(queryValue)
            .setQuery(queryValue)
            .setPrefixLength(2)
        assertNotNull("Builder should not be null (CONSTANT_SCORE)", builderWithRewrite);
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()
            .setInt32(2)
            .setField("message")
        assertEquals("Minimum should match (STRING)", "75%", builderString.minimumShouldMatch());
        assertEquals("Query name should match", "test_query", matchQueryBuilder.queryName());
        assertEquals("Boost should match", 1.5f, matchQueryBuilder.boost(), 0.001f);
        assertEquals("Max expansions should match", 50, matchQueryBuilder.maxExpansions());
            .setField("message")
        org.opensearch.protobufs.MinimumShouldMatch minimumShouldMatchInt = org.opensearch.protobufs.MinimumShouldMatch.newBuilder()
 *
            .build();
import org.opensearch.test.OpenSearchTestCase;
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);
        assertNotNull("Builder should not be null (EMPTY)", builderEmpty);
            .setField("message")
        assertEquals("Auto generate synonyms should match", false, matchQueryBuilder.autoGenerateSynonymsPhraseQuery());
        org.opensearch.protobufs.MatchQuery queryInt = org.opensearch.protobufs.MatchQuery.newBuilder()
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);
    public void testFromProtoWithLenient() {
        FieldValue queryValue = FieldValue.newBuilder().setString("search text").build();
/*
            .build();
            .setAnalyzer("standard")
        MatchQueryBuilder builderString = MatchQueryBuilderProtoUtils.fromProto(queryString);
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);
        assertEquals("Fuzziness should match (INT32)", Fuzziness.fromEdits(2), builderInt.fuzziness());
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);
        org.opensearch.protobufs.MatchQuery queryWithRewrite = org.opensearch.protobufs.MatchQuery.newBuilder()
    public void testFromProtoWithFuzziness() {
    }
            .setLenient(true)
package org.opensearch.transport.grpc.proto.request.search.query;
        assertNull("Fuzziness should be null (EMPTY)", builderEmpty.fuzziness());
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()
            .setMinimumShouldMatch(minimumShouldMatchInt)
            .build();
        org.opensearch.protobufs.MatchQuery queryString = org.opensearch.protobufs.MatchQuery.newBuilder()
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_UNSPECIFIED)
            .setQuery(queryValue)
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)
        org.opensearch.protobufs.MatchQuery queryInt = org.opensearch.protobufs.MatchQuery.newBuilder()
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();
import org.opensearch.index.query.Operator;
    public void testFromProtoWithOperatorOr() {
        assertEquals("Analyzer should match", "standard", matchQueryBuilder.analyzer());
            .build();
        org.opensearch.protobufs.Fuzziness fuzzinessEmpty = org.opensearch.protobufs.Fuzziness.newBuilder().build();
            .setLenient(true)
    }
        org.opensearch.protobufs.MinimumShouldMatch minimumShouldMatchString = org.opensearch.protobufs.MinimumShouldMatch.newBuilder()
            .setFuzzyTranspositions(false)
        MatchQueryBuilder builderWithRewrite = MatchQueryBuilderProtoUtils.fromProto(queryWithRewrite);
import org.opensearch.protobufs.ZeroTermsQuery;
            .setAutoGenerateSynonymsPhraseQuery(false)
            .setMinimumShouldMatch(minimumShouldMatchString)
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()
        // Test 2: Fuzziness with int32 value
            .setFuzziness(fuzzinessString)
        org.opensearch.protobufs.MatchQuery queryEmpty = org.opensearch.protobufs.MatchQuery.newBuilder()
            .setField("message")
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()
        assertEquals("Query should match", "search text", matchQueryBuilder.value());
            .build();
    public void testFromProtoWithZeroTermsQueryAll() {
            .setQuery(queryValue)
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();
            .build();
            .setQuery(queryValue)
    }
    public void testFromProtoWithFuzzyRewrite() {
        assertNotNull("Builder should not be null (STRING)", builderString);
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_AND)
            .setQuery(queryValue)
        assertEquals("Field name should match", "message", matchQueryBuilder.fieldName());
        // Test 1: MinimumShouldMatch with string value
            .build();
        org.opensearch.protobufs.MinimumShouldMatch minimumShouldMatchEmpty = org.opensearch.protobufs.MinimumShouldMatch.newBuilder()
            .build();
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);
            .build();
            .build();
            .setQuery(queryValue)
import org.opensearch.index.search.MatchQuery;
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);
            .setField("message")
            .build();
        assertEquals("Auto generate synonyms should match", false, matchQueryBuilder.autoGenerateSynonymsPhraseQuery());
        assertNotNull("Builder should not be null (INT32)", builderInt);
            .setField("message")
        assertEquals("Prefix length should match", 2, matchQueryBuilder.prefixLength());
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();
    }
        assertNotNull("Fuzzy rewrite should not be null (CONSTANT_SCORE)", builderWithRewrite.fuzzyRewrite());
        MatchQueryBuilder builderString = MatchQueryBuilderProtoUtils.fromProto(queryString);
    }
        MatchQueryBuilder builderEmpty = MatchQueryBuilderProtoUtils.fromProto(queryEmpty);
        assertEquals("Lenient should match", true, matchQueryBuilder.lenient());
    }
            .setField("message")
        assertEquals("Operator should match OR", Operator.OR, matchQueryBuilder.operator());

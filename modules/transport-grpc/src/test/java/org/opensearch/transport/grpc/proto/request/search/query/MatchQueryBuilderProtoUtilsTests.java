}  
        assertEquals("Lenient should match", true, matchQueryBuilder.lenient());
            .setField("message")
            .build();
        // Test 1: MinimumShouldMatch with string value
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()
        assertEquals("Minimum should match (STRING)", "75%", builderString.minimumShouldMatch());
            .build();
        assertEquals("Boost should match", 1.5f, matchQueryBuilder.boost(), 0.001f);
            .build();
        org.opensearch.protobufs.MatchQuery queryWithRewrite = org.opensearch.protobufs.MatchQuery.newBuilder()  
        assertEquals("Fuzzy rewrite should match (CONSTANT_SCORE)", "constant_score", builderWithRewrite.fuzzyRewrite());
            .setField("message")  
        assertEquals("Operator should match", Operator.AND, matchQueryBuilder.operator());  
            .build();
        org.opensearch.protobufs.MatchQuery queryInt = org.opensearch.protobufs.MatchQuery.newBuilder()
            .build();
            .setQuery(queryValue)  
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()
            .build();  
        // Test 1: FuzzyRewrite with CONSTANT_SCORE value
        assertNotNull("Builder should not be null (EMPTY)", builderEmpty);
 * compatible open source license.
    }
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)  
            .setAutoGenerateSynonymsPhraseQuery(false)  
        MatchQueryBuilder builderEmpty = MatchQueryBuilderProtoUtils.fromProto(queryEmpty);  
            .setQuery(queryValue)  
package org.opensearch.transport.grpc.proto.request.search.query;
    }  
            .setField("message")
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Operator should be default OR", Operator.OR, matchQueryBuilder.operator());
            .setField("message")
            .setQuery(queryValue)
            .build();  
            .setField("message")
            .setMinimumShouldMatch(minimumShouldMatchInt)
        FieldValue queryValue = FieldValue.newBuilder().setString("search text").build();
import org.opensearch.index.query.MatchQueryBuilder;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Zero terms query should match", MatchQuery.ZeroTermsQuery.ALL, matchQueryBuilder.zeroTermsQuery());
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);  
            .setQuery(queryValue)  
        FieldValue queryValue = FieldValue.newBuilder().setString("search text").build();
        MatchQueryBuilder builderString = MatchQueryBuilderProtoUtils.fromProto(queryString);
            .build();
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()
            .setAnalyzer("standard")
            .build();
        // Test 3: Fuzziness with empty/neither string nor int32
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);
            .setLenient(true)
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);
import org.opensearch.common.unit.Fuzziness;  
    public void testFromProtoWithFuzzyRewrite() {
public class MatchQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
            .setField("message")
        // Test 2: Fuzziness with int32 value  
    public void testFromProtoWithMinimumShouldMatch() {
        MatchQueryBuilder builderInt = MatchQueryBuilderProtoUtils.fromProto(queryInt);  
        assertEquals("Operator should be default OR", Operator.OR, matchQueryBuilder.operator());
        assertNotNull("Builder should not be null (STRING)", builderString);  
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);
        assertNotNull("Builder should not be null (CONSTANT_SCORE)", builderWithRewrite);  
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);
        assertEquals("Analyzer should match", "standard", matchQueryBuilder.analyzer());
            .setField("message")  
import org.opensearch.test.OpenSearchTestCase;  
            .setField("message")  
        MatchQueryBuilder builderWithRewrite = MatchQueryBuilderProtoUtils.fromProto(queryWithRewrite);
        assertEquals("Fuzziness should match (INT32)", Fuzziness.fromEdits(2), builderInt.fuzziness());  
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);  
        org.opensearch.protobufs.Fuzziness fuzzinessEmpty = org.opensearch.protobufs.Fuzziness.newBuilder().build();  
    }
    public void testFromProtoWithOperatorUnspecified() {
        MatchQueryBuilder builderInt = MatchQueryBuilderProtoUtils.fromProto(queryInt);
            .setFuzzyRewrite("constant_score")  
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();
        org.opensearch.protobufs.MatchQuery queryEmpty = org.opensearch.protobufs.MatchQuery.newBuilder()
            .setQuery(queryValue)
        assertEquals("Zero terms query should match", MatchQuery.ZeroTermsQuery.ALL, matchQueryBuilder.zeroTermsQuery());  
        org.opensearch.protobufs.MinimumShouldMatch minimumShouldMatchString = org.opensearch.protobufs.MinimumShouldMatch.newBuilder()  
import org.opensearch.index.search.MatchQuery;  
            .build();
            .build();
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();
        MatchQueryBuilder builderString = MatchQueryBuilderProtoUtils.fromProto(queryString);
            .setField("message")
            .build();
    public void testFromProtoWithBasicMatchQuery() {
    public void testFromProtoWithOperatorOr() {  
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_AND)  
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();  
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();  
            .setQuery(queryValue)  
        assertEquals("Auto generate synonyms should match", false, matchQueryBuilder.autoGenerateSynonymsPhraseQuery());  
            .build();  
    }
 *
    }  
        assertNull("Fuzziness should be null (EMPTY)", builderEmpty.fuzziness());
        assertEquals("Fuzziness should match", Fuzziness.AUTO, matchQueryBuilder.fuzziness());
        org.opensearch.protobufs.Fuzziness fuzziness = org.opensearch.protobufs.Fuzziness.newBuilder().setString("AUTO").build();  
        assertEquals("Minimum should match (INT32)", "2", builderInt.minimumShouldMatch());
    }
            .setQuery(queryValue)
        assertEquals("Lenient should match", true, matchQueryBuilder.lenient());
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()
            .build();  
        assertEquals("Query name should match", "test_query", matchQueryBuilder.queryName());  
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_UNSPECIFIED)
 */  
        // Test 3: MinimumShouldMatch with empty/neither
    }  
        assertEquals("Field name should match", "message", matchQueryBuilder.fieldName());
        // Test 2: MinimumShouldMatch with int32 value  
        org.opensearch.protobufs.MinimumShouldMatch minimumShouldMatchEmpty = org.opensearch.protobufs.MinimumShouldMatch.newBuilder()
        assertEquals("Query should match", "search text", matchQueryBuilder.value());  
import org.opensearch.index.query.Operator;
            .setField("message")
        assertEquals("Auto generate synonyms should match", false, matchQueryBuilder.autoGenerateSynonymsPhraseQuery());
            .setPrefixLength(2)
        assertNull("Minimum should match should be null (EMPTY)", builderEmpty.minimumShouldMatch());
            .setFuzzyTranspositions(false)
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);
        MatchQueryBuilder builderEmpty = MatchQueryBuilderProtoUtils.fromProto(queryEmpty);  
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);  
            .setFuzziness(fuzzinessString)  
        assertNotNull("Builder should not be null (EMPTY)", builderEmpty);
        org.opensearch.protobufs.MatchQuery queryEmpty = org.opensearch.protobufs.MatchQuery.newBuilder()
        org.opensearch.protobufs.MinimumShouldMatch minimumShouldMatchInt = org.opensearch.protobufs.MinimumShouldMatch.newBuilder()
        assertNotNull("Fuzzy rewrite should not be null (CONSTANT_SCORE)", builderWithRewrite.fuzzyRewrite());
            .setString("75%")
        // Test 1: Fuzziness with string value
            .setAutoGenerateSynonymsPhraseQuery(false)
            .setLenient(true)
 * The OpenSearch Contributors require contributions made to  
            .setQuery(queryValue)
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()  
        assertEquals("Fuzzy transpositions should match", false, matchQueryBuilder.fuzzyTranspositions());
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();  
        assertEquals("Fuzziness should match (STRING)", Fuzziness.AUTO, builderString.fuzziness());
            .setQuery(queryValue)
    public void testFromProtoWithZeroTermsQueryAll() {  
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_OR)
        assertNotNull("Builder should not be null (INT32)", builderInt);
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();
    }
    public void testFromProtoWithAutoGenerateSynonymsPhraseQueryFalse() {
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();
            .build();
            .setQuery(queryValue)
        assertNotNull("Builder should not be null (STRING)", builderString);  
        assertNotNull("MatchQueryBuilder should not be null", matchQueryBuilder);
import org.opensearch.protobufs.FieldValue;
import org.opensearch.protobufs.ZeroTermsQuery;
        assertEquals("Operator should match OR", Operator.OR, matchQueryBuilder.operator());
            .setXName("test_query")  
        org.opensearch.protobufs.MatchQuery queryString = org.opensearch.protobufs.MatchQuery.newBuilder()  
        assertEquals("Prefix length should match", 2, matchQueryBuilder.prefixLength());
    }
    public void testFromProtoWithAllParameters() {
        assertNotNull("Builder should not be null (INT32)", builderInt);
            .build();  
/*  
            .setQuery(queryValue)
        org.opensearch.protobufs.Fuzziness fuzzinessString = org.opensearch.protobufs.Fuzziness.newBuilder().setString("AUTO").build();
            .setQuery(queryValue)
    public void testFromProtoWithFuzziness() {
        assertEquals("Max expansions should match", 50, matchQueryBuilder.maxExpansions());  
        org.opensearch.protobufs.MatchQuery queryInt = org.opensearch.protobufs.MatchQuery.newBuilder()
            .setField("message")
        org.opensearch.protobufs.Fuzziness fuzzinessInt = org.opensearch.protobufs.Fuzziness.newBuilder().setInt32(2).build();
        org.opensearch.protobufs.MatchQuery queryString = org.opensearch.protobufs.MatchQuery.newBuilder()  
        assertEquals("Field name should match", "message", matchQueryBuilder.fieldName());  
            .setFuzziness(fuzzinessEmpty)
        MatchQueryBuilder matchQueryBuilder = MatchQueryBuilderProtoUtils.fromProto(matchQuery);  
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)
            .setField("message")
            .setMaxExpansions(50)  
            .setFuzziness(fuzziness)
    public void testFromProtoWithLenient() {
        FieldValue queryValue = FieldValue.newBuilder().setString("test").build();  
            .setField("message")
            .setBoost(1.5f)
            .setMinimumShouldMatch(minimumShouldMatchEmpty)
            .setQuery(queryValue)  
        org.opensearch.protobufs.MatchQuery matchQuery = org.opensearch.protobufs.MatchQuery.newBuilder()  
            .setQuery(queryValue)
            .setFuzziness(fuzzinessInt)
            .setInt32(2)
            .setField("message")  
        assertEquals("Query should match", "search text", matchQueryBuilder.value());
            .build();  
            .setMinimumShouldMatch(minimumShouldMatchString)  
    }  

        org.opensearch.protobufs.Fuzziness fuzzinessEmpty = org.opensearch.protobufs.Fuzziness.newBuilder().build();
            .setField("message")
 * this file be licensed under the Apache-2.0 license or a
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(matchBoolPrefixQuery);  
        assertNull("Minimum should match should be null (EMPTY)", builderEmpty.minimumShouldMatch());
        // Test 1: MinimumShouldMatch with string value
        assertEquals("Prefix length should be default", FuzzyQuery.defaultPrefixLength, matchBoolPrefixQueryBuilder.prefixLength());
import org.opensearch.test.OpenSearchTestCase;  
 *
        MatchBoolPrefixQuery queryNoRewrite = MatchBoolPrefixQuery.newBuilder().setField("message").setQuery("test").build();  
    }
        MatchBoolPrefixQueryBuilder builderInt = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryInt);
        assertEquals("Minimum should match", "75%", matchBoolPrefixQueryBuilder.minimumShouldMatch());
/*  
        MatchBoolPrefixQuery queryWithRewrite = MatchBoolPrefixQuery.newBuilder()  
public class MatchBoolPrefixQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
        assertEquals("Fuzziness should match", Fuzziness.AUTO, matchBoolPrefixQueryBuilder.fuzziness());
            .setQuery("test")
        assertEquals("Max expansions should be default", FuzzyQuery.defaultMaxExpansions, matchBoolPrefixQueryBuilder.maxExpansions());
        assertEquals("Fuzzy rewrite should match (CONSTANT_SCORE)", "constant_score", builderWithRewrite.fuzzyRewrite());
            .setQuery("test")
    public void testFromProtoWithOperatorOr() {
        assertEquals("Fuzziness should match (INT32)", Fuzziness.fromEdits(2), builderInt.fuzziness());
import org.opensearch.protobufs.MinimumShouldMatch;
            .setField("message")
    }
            .setField("message")
    public void testFromProtoWithOperatorUnspecified() {
            .setQuery("test")
        MatchBoolPrefixQuery matchBoolPrefixQuery = MatchBoolPrefixQuery.newBuilder().setField("message").setQuery("quick brown f").build();
            .build();
}  
            .setField("message")  
        assertNotNull("Builder should not be null (STRING)", builderString);
        assertNotNull("MatchBoolPrefixQueryBuilder should not be null", matchBoolPrefixQueryBuilder);
        MinimumShouldMatch minimumShouldMatchEmpty = MinimumShouldMatch.newBuilder().build();  
        MatchBoolPrefixQuery queryString = MatchBoolPrefixQuery.newBuilder()  
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(matchBoolPrefixQuery);
        assertEquals("Minimum should match (INT32)", "2", builderInt.minimumShouldMatch());  
        assertEquals("Operator should match", Operator.AND, matchBoolPrefixQueryBuilder.operator());  
            .setXName("test_query")  
        assertEquals("Fuzzy transpositions should match", false, matchBoolPrefixQueryBuilder.fuzzyTranspositions());
        assertNotNull("Fuzzy rewrite should not be null (CONSTANT_SCORE)", builderWithRewrite.fuzzyRewrite());
            .build();
        assertNull("Fuzzy rewrite should be null (not set)", builderNoRewrite.fuzzyRewrite());  
            .build();  
        // Test 3: MinimumShouldMatch with empty/neither string nor int32
            "Fuzzy transpositions should be default",
        org.opensearch.protobufs.Fuzziness fuzzinessString = org.opensearch.protobufs.Fuzziness.newBuilder().setString("AUTO").build();
        MatchBoolPrefixQuery queryEmpty = MatchBoolPrefixQuery.newBuilder()  
            .setMinimumShouldMatch(minimumShouldMatchString)  
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(matchBoolPrefixQuery);
        assertEquals("Operator should be default OR", Operator.OR, matchBoolPrefixQueryBuilder.operator());  
        assertEquals("Operator should match OR", Operator.OR, matchBoolPrefixQueryBuilder.operator());
            .build();
            .setField("message")  
        assertEquals("Minimum should match (STRING)", "75%", builderString.minimumShouldMatch());
        MatchBoolPrefixQuery matchBoolPrefixQuery = MatchBoolPrefixQuery.newBuilder().setField("message").setQuery("test").build();
        // Test 2: MinimumShouldMatch with int32 value  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Analyzer should match", "standard", matchBoolPrefixQueryBuilder.analyzer());
            .setMinimumShouldMatch(minimumShouldMatchInt)
        assertEquals("Boost should match", 1.5f, matchBoolPrefixQueryBuilder.boost(), 0.001f);  
 * The OpenSearch Contributors require contributions made to  
    public void testFromProtoWithFuzziness() {
import org.apache.lucene.search.FuzzyQuery;  
        assertEquals("Query should match", "quick brown f", matchBoolPrefixQueryBuilder.value());
            .setQuery("test")
            .setFuzziness(fuzziness)
        assertNotNull("MatchBoolPrefixQueryBuilder should not be null", matchBoolPrefixQueryBuilder);  
            .setBoost(1.5f)
            .build();  
    }  
        assertNotNull("Builder should not be null (STRING)", builderString);  
        assertEquals("Query name should match", "test_query", matchBoolPrefixQueryBuilder.queryName());
            .setQuery("test")
            .setFuzziness(fuzzinessInt)
        // Test 1: Fuzzy rewrite not set (null)
 * compatible open source license.
import org.opensearch.protobufs.MatchBoolPrefixQuery;
        MatchBoolPrefixQueryBuilder builderEmpty = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryEmpty);  
        // Test 1: Fuzziness with string value  
        MatchBoolPrefixQueryBuilder builderEmpty = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryEmpty);
            .build();
        MatchBoolPrefixQuery matchBoolPrefixQuery = MatchBoolPrefixQuery.newBuilder()
        assertEquals("Fuzziness should match (STRING)", Fuzziness.AUTO, builderString.fuzziness());  
            .setField("message")
            .setFuzziness(fuzzinessString)
            FuzzyQuery.defaultTranspositions,
        org.opensearch.protobufs.Fuzziness fuzziness = org.opensearch.protobufs.Fuzziness.newBuilder().setString("AUTO").build();
        MinimumShouldMatch minimumShouldMatchInt = MinimumShouldMatch.newBuilder().setInt32(2).build();
    }
        MatchBoolPrefixQuery queryEmpty = MatchBoolPrefixQuery.newBuilder()
        MatchBoolPrefixQuery queryInt = MatchBoolPrefixQuery.newBuilder()
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_OR)
        org.opensearch.protobufs.Fuzziness fuzzinessInt = org.opensearch.protobufs.Fuzziness.newBuilder().setInt32(2).build();  
package org.opensearch.transport.grpc.proto.request.search.query;
    public void testFromProtoWithFuzzyRewrite() {
    public void testFromProtoWithAllParameters() {  
        assertNotNull("MatchBoolPrefixQueryBuilder should not be null", matchBoolPrefixQueryBuilder);
            .setFuzzyTranspositions(false)
import org.opensearch.index.query.Operator;  
            .setField("message")
            .setField("message")  
        assertNotNull("MatchBoolPrefixQueryBuilder should not be null", matchBoolPrefixQueryBuilder);  
            .setQuery("quick brown f")  
        MatchBoolPrefixQuery queryString = MatchBoolPrefixQuery.newBuilder()
            .build();
import org.opensearch.common.unit.Fuzziness;
            .build();  
        MatchBoolPrefixQuery queryInt = MatchBoolPrefixQuery.newBuilder()
        MatchBoolPrefixQuery matchBoolPrefixQuery = MatchBoolPrefixQuery.newBuilder()  
 */  
        MatchBoolPrefixQueryBuilder builderString = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryString);
    }
            .build();
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_UNSPECIFIED)  
        assertNotNull("Builder should not be null (CONSTANT_SCORE)", builderWithRewrite);  
            .setQuery("test")  
        MatchBoolPrefixQuery matchBoolPrefixQuery = MatchBoolPrefixQuery.newBuilder()
        assertEquals("Prefix length should match", 2, matchBoolPrefixQueryBuilder.prefixLength());  
    }
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_AND)
        MatchBoolPrefixQueryBuilder builderWithRewrite = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryWithRewrite);
        assertEquals("Max expansions should match", 100, matchBoolPrefixQueryBuilder.maxExpansions());
        MatchBoolPrefixQueryBuilder builderNoRewrite = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryNoRewrite);
            .build();
        assertNotNull("Builder should not be null (INT32)", builderInt);
        MinimumShouldMatch minimumShouldMatchString = MinimumShouldMatch.newBuilder().setString("75%").build();
        assertNull("Fuzziness should be null (EMPTY)", builderEmpty.fuzziness());
        assertEquals("Operator should be default OR", Operator.OR, matchBoolPrefixQueryBuilder.operator());  
        // Test 2: Fuzziness with int32 value
            .setMinimumShouldMatch(minimumShouldMatch)  
            .setMaxExpansions(100)  
            .setField("message")
            .setFuzzyRewrite("constant_score")  
            .setQuery("test")  
        assertNotNull("Builder should not be null (EMPTY)", builderEmpty);  
    public void testFromProtoWithDefaults() {
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(matchBoolPrefixQuery);  
            matchBoolPrefixQueryBuilder.fuzzyTranspositions()  
        // Test 2: Fuzzy rewrite with CONSTANT_SCORE value
            .setQuery("test")
import org.opensearch.index.query.MatchBoolPrefixQueryBuilder;
            .setMinimumShouldMatch(minimumShouldMatchEmpty)
            .setAnalyzer("standard")
    public void testFromProtoWithMinimumShouldMatch() {  
        MatchBoolPrefixQueryBuilder builderInt = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryInt);  
            .setPrefixLength(2)
        assertNotNull("Builder should not be null (no fuzzyRewrite)", builderNoRewrite);
        assertEquals("Query should match", "quick brown f", matchBoolPrefixQueryBuilder.value());
        assertEquals(  
        assertNotNull("MatchBoolPrefixQueryBuilder should not be null", matchBoolPrefixQueryBuilder);
            .setQuery("test")
        assertNotNull("Builder should not be null (INT32)", builderInt);
        MinimumShouldMatch minimumShouldMatch = MinimumShouldMatch.newBuilder().setString("75%").build();
        MatchBoolPrefixQueryBuilder builderString = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryString);
            .setField("message")
        assertEquals("Field name should match", "message", matchBoolPrefixQueryBuilder.fieldName());
            .setFuzziness(fuzzinessEmpty)  
        // Test 3: Fuzziness with empty/neither string nor int32
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(matchBoolPrefixQuery);
    }  
    public void testFromProtoWithBasicMatchBoolPrefixQuery() {
        assertNotNull("Builder should not be null (EMPTY)", builderEmpty);
        );
        assertEquals("Field name should match", "message", matchBoolPrefixQueryBuilder.fieldName());  
    }

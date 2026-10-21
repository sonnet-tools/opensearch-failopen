            .setAnalyzer("standard")
            .setField("message")
            matchBoolPrefixQueryBuilder.fuzzyTranspositions()
        assertEquals("Minimum should match (INT32)", "2", builderInt.minimumShouldMatch());
import org.opensearch.protobufs.MinimumShouldMatch;
            .setFuzziness(fuzzinessString)
 * this file be licensed under the Apache-2.0 license or a
}
        MatchBoolPrefixQueryBuilder builderString = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryString);
            .setField("message")
    public void testFromProtoWithFuzziness() {
        assertEquals(
        // Test 1: Fuzziness with string value
            .setQuery("test")
        org.opensearch.protobufs.Fuzziness fuzziness = org.opensearch.protobufs.Fuzziness.newBuilder().setString("AUTO").build();
        assertEquals("Boost should match", 1.5f, matchBoolPrefixQueryBuilder.boost(), 0.001f);
        assertEquals("Prefix length should be default", FuzzyQuery.defaultPrefixLength, matchBoolPrefixQueryBuilder.prefixLength());
        assertNotNull("Builder should not be null (no fuzzyRewrite)", builderNoRewrite);
 * compatible open source license.
        assertEquals("Field name should match", "message", matchBoolPrefixQueryBuilder.fieldName());
    }
        MatchBoolPrefixQueryBuilder builderString = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryString);
    }
        // Test 3: Fuzziness with empty/neither string nor int32
        MatchBoolPrefixQueryBuilder builderInt = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryInt);
package org.opensearch.transport.grpc.proto.request.search.query;
            .setBoost(1.5f)
        assertEquals("Fuzzy transpositions should match", false, matchBoolPrefixQueryBuilder.fuzzyTranspositions());
        MatchBoolPrefixQuery matchBoolPrefixQuery = MatchBoolPrefixQuery.newBuilder()
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(matchBoolPrefixQuery);
        assertEquals("Query should match", "quick brown f", matchBoolPrefixQueryBuilder.value());
            .setMinimumShouldMatch(minimumShouldMatchInt)
            .setFuzziness(fuzzinessEmpty)
        // Test 3: MinimumShouldMatch with empty/neither string nor int32
            .build();
        MinimumShouldMatch minimumShouldMatch = MinimumShouldMatch.newBuilder().setString("75%").build();
        assertNotNull("Builder should not be null (CONSTANT_SCORE)", builderWithRewrite);
    }
            .setFuzzyTranspositions(false)
        MatchBoolPrefixQuery queryInt = MatchBoolPrefixQuery.newBuilder()
            .setField("message")
            .build();
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_AND)
            .setFuzziness(fuzziness)
import org.opensearch.common.unit.Fuzziness;
        assertNotNull("MatchBoolPrefixQueryBuilder should not be null", matchBoolPrefixQueryBuilder);
        MatchBoolPrefixQuery matchBoolPrefixQuery = MatchBoolPrefixQuery.newBuilder().setField("message").setQuery("quick brown f").build();
            .setQuery("test")
            .setPrefixLength(2)
            .build();
        // Test 2: MinimumShouldMatch with int32 value
        assertNull("Fuzzy rewrite should be null (not set)", builderNoRewrite.fuzzyRewrite());
        assertEquals("Minimum should match (STRING)", "75%", builderString.minimumShouldMatch());
            .build();
    public void testFromProtoWithMinimumShouldMatch() {
        assertNotNull("Builder should not be null (EMPTY)", builderEmpty);
            .setQuery("quick brown f")
        MatchBoolPrefixQueryBuilder builderNoRewrite = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryNoRewrite);
            .setFuzzyRewrite("constant_score")
            .setFuzziness(fuzzinessInt)
        MatchBoolPrefixQuery queryWithRewrite = MatchBoolPrefixQuery.newBuilder()
        MatchBoolPrefixQuery queryEmpty = MatchBoolPrefixQuery.newBuilder()
        // Test 1: Fuzzy rewrite not set (null)
        MatchBoolPrefixQuery matchBoolPrefixQuery = MatchBoolPrefixQuery.newBuilder().setField("message").setQuery("test").build();
        MatchBoolPrefixQueryBuilder builderEmpty = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryEmpty);
        assertEquals("Max expansions should be default", FuzzyQuery.defaultMaxExpansions, matchBoolPrefixQueryBuilder.maxExpansions());
        assertNotNull("Fuzzy rewrite should not be null (CONSTANT_SCORE)", builderWithRewrite.fuzzyRewrite());
            .setField("message")
            .setQuery("test")
            .setQuery("test")
            .setField("message")
        assertEquals("Query name should match", "test_query", matchBoolPrefixQueryBuilder.queryName());
        assertEquals("Fuzziness should match (STRING)", Fuzziness.AUTO, builderString.fuzziness());
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(matchBoolPrefixQuery);
            .setField("message")
        MatchBoolPrefixQuery queryString = MatchBoolPrefixQuery.newBuilder()
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_UNSPECIFIED)
    }
/*
    }
        assertEquals("Operator should match", Operator.AND, matchBoolPrefixQueryBuilder.operator());
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
        MatchBoolPrefixQuery queryString = MatchBoolPrefixQuery.newBuilder()
    public void testFromProtoWithFuzzyRewrite() {
        MinimumShouldMatch minimumShouldMatchString = MinimumShouldMatch.newBuilder().setString("75%").build();
public class MatchBoolPrefixQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
            .setQuery("test")
import org.apache.lucene.search.FuzzyQuery;
        assertNotNull("Builder should not be null (STRING)", builderString);
            .setOperator(org.opensearch.protobufs.Operator.OPERATOR_OR)
        assertEquals("Fuzziness should match (INT32)", Fuzziness.fromEdits(2), builderInt.fuzziness());
            .build();
    }
        assertEquals("Operator should be default OR", Operator.OR, matchBoolPrefixQueryBuilder.operator());
            .setMinimumShouldMatch(minimumShouldMatchString)
            .setField("message")
import org.opensearch.index.query.Operator;
        assertEquals("Field name should match", "message", matchBoolPrefixQueryBuilder.fieldName());
        MatchBoolPrefixQuery queryNoRewrite = MatchBoolPrefixQuery.newBuilder().setField("message").setQuery("test").build();
    public void testFromProtoWithDefaults() {
            .setQuery("test")
            .setMaxExpansions(100)
            .setMinimumShouldMatch(minimumShouldMatch)
        assertEquals("Prefix length should match", 2, matchBoolPrefixQueryBuilder.prefixLength());
        MatchBoolPrefixQueryBuilder builderEmpty = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryEmpty);
            .build();
    }
        assertNull("Fuzziness should be null (EMPTY)", builderEmpty.fuzziness());
        assertNotNull("MatchBoolPrefixQueryBuilder should not be null", matchBoolPrefixQueryBuilder);
 *
        assertNotNull("Builder should not be null (INT32)", builderInt);
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(matchBoolPrefixQuery);
            .setQuery("test")
        );
        assertNotNull("MatchBoolPrefixQueryBuilder should not be null", matchBoolPrefixQueryBuilder);
        assertNotNull("Builder should not be null (STRING)", builderString);
        MatchBoolPrefixQuery matchBoolPrefixQuery = MatchBoolPrefixQuery.newBuilder()
        MatchBoolPrefixQueryBuilder builderWithRewrite = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryWithRewrite);
    }
        MatchBoolPrefixQuery queryEmpty = MatchBoolPrefixQuery.newBuilder()
            .setField("message")
            FuzzyQuery.defaultTranspositions,
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(matchBoolPrefixQuery);
            .setField("message")
import org.opensearch.test.OpenSearchTestCase;
    public void testFromProtoWithAllParameters() {
        // Test 1: MinimumShouldMatch with string value
        assertNull("Minimum should match should be null (EMPTY)", builderEmpty.minimumShouldMatch());
        MatchBoolPrefixQuery matchBoolPrefixQuery = MatchBoolPrefixQuery.newBuilder()
    public void testFromProtoWithOperatorOr() {
            .setMinimumShouldMatch(minimumShouldMatchEmpty)
        assertEquals("Fuzziness should match", Fuzziness.AUTO, matchBoolPrefixQueryBuilder.fuzziness());
            "Fuzzy transpositions should be default",
        assertEquals("Operator should be default OR", Operator.OR, matchBoolPrefixQueryBuilder.operator());
        // Test 2: Fuzziness with int32 value
        org.opensearch.protobufs.Fuzziness fuzzinessString = org.opensearch.protobufs.Fuzziness.newBuilder().setString("AUTO").build();
        assertEquals("Minimum should match", "75%", matchBoolPrefixQueryBuilder.minimumShouldMatch());
    public void testFromProtoWithBasicMatchBoolPrefixQuery() {
 */
    public void testFromProtoWithOperatorUnspecified() {
import org.opensearch.protobufs.MatchBoolPrefixQuery;
        assertEquals("Fuzzy rewrite should match (CONSTANT_SCORE)", "constant_score", builderWithRewrite.fuzzyRewrite());
import org.opensearch.index.query.MatchBoolPrefixQueryBuilder;
        MatchBoolPrefixQuery queryInt = MatchBoolPrefixQuery.newBuilder()
        assertNotNull("Builder should not be null (INT32)", builderInt);
        assertNotNull("MatchBoolPrefixQueryBuilder should not be null", matchBoolPrefixQueryBuilder);
            .setField("message")
            .setQuery("test")
        MinimumShouldMatch minimumShouldMatchInt = MinimumShouldMatch.newBuilder().setInt32(2).build();
            .setXName("test_query")
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(matchBoolPrefixQuery);
        assertEquals("Analyzer should match", "standard", matchBoolPrefixQueryBuilder.analyzer());
            .build();
        // Test 2: Fuzzy rewrite with CONSTANT_SCORE value
            .build();
        MatchBoolPrefixQueryBuilder builderInt = MatchBoolPrefixQueryBuilderProtoUtils.fromProto(queryInt);
        org.opensearch.protobufs.Fuzziness fuzzinessInt = org.opensearch.protobufs.Fuzziness.newBuilder().setInt32(2).build();
        assertEquals("Query should match", "quick brown f", matchBoolPrefixQueryBuilder.value());
            .build();
        MinimumShouldMatch minimumShouldMatchEmpty = MinimumShouldMatch.newBuilder().build();
        assertEquals("Max expansions should match", 100, matchBoolPrefixQueryBuilder.maxExpansions());
        assertNotNull("Builder should not be null (EMPTY)", builderEmpty);
        assertEquals("Operator should match OR", Operator.OR, matchBoolPrefixQueryBuilder.operator());
            .build();
        assertNotNull("MatchBoolPrefixQueryBuilder should not be null", matchBoolPrefixQueryBuilder);
            .setQuery("test")
        org.opensearch.protobufs.Fuzziness fuzzinessEmpty = org.opensearch.protobufs.Fuzziness.newBuilder().build();

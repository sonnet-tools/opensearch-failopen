import org.opensearch.protobufs.MatchPhraseQuery;
            () -> MatchPhraseQueryBuilderProtoUtils.fromProto(null)
            () -> MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery)
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)
        IllegalArgumentException exception = expectThrows(
    public void testFromProtoWithZeroTermsQueryUnspecified() {
        };
        assertEquals("Query name should match", "test_query", matchPhraseQueryBuilder.queryName());
 * this file be licensed under the Apache-2.0 license or a
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_UNSPECIFIED)
            .setAnalyzer("standard")
            .build();
        IllegalArgumentException exception = expectThrows(
        );
    public void testFromProtoWithNullMatchPhraseQuery() {
    public void testFromProtoWithAllParameters() {
        );
 * compatible open source license.
        assertEquals("Zero terms query should be default", MatchQuery.DEFAULT_ZERO_TERMS_QUERY, matchPhraseQueryBuilder.zeroTermsQuery());
/*
        assertNotNull("MatchPhraseQueryBuilder should not be null", matchPhraseQueryBuilder);
        IllegalArgumentException exception = expectThrows(
        assertEquals("Zero terms query should be default", MatchQuery.DEFAULT_ZERO_TERMS_QUERY, matchPhraseQueryBuilder.zeroTermsQuery());
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()
            // Not setting ZeroTermsQuery, which should use default behavior
 * SPDX-License-Identifier: Apache-2.0
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("message").setQuery("").build();
            IllegalArgumentException.class,
            .build();
    public void testFromProtoWithEmptyFieldName() {
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery);
    }
        assertEquals("Zero terms query should match", MatchQuery.ZeroTermsQuery.ALL, matchPhraseQueryBuilder.zeroTermsQuery());
        assertEquals("No negative slop allowed.", exception.getMessage());
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery);
            .setQuery("hello world")
    }
            .setField("message")
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("").setQuery("hello world").build();
            MatchQuery.DEFAULT_ZERO_TERMS_QUERY // For UNSPECIFIED, should use default
    public void testFromProtoWithNegativeSlop() {
            ZeroTermsQuery.ZERO_TERMS_QUERY_NONE,
            MatchQuery.ZeroTermsQuery.NONE,
    }
    public void testFromProtoWithEmptyQuery() {
        assertNotNull("MatchPhraseQueryBuilder should not be null", matchPhraseQueryBuilder);
        assertEquals("Field name cannot be null or empty for match phrase query", exception.getMessage());
            .build();
        IllegalArgumentException exception = expectThrows(
        );
            ZeroTermsQuery.ZERO_TERMS_QUERY_ALL,
            .setQuery("hello world")
        for (int i = 0; i < testValues.length; i++) {
            .setField("message")
        assertEquals("Slop should be default", MatchQuery.DEFAULT_PHRASE_SLOP, matchPhraseQueryBuilder.slop());
        assertEquals("Analyzer should match", "standard", matchPhraseQueryBuilder.analyzer());
        assertEquals("Zero terms query should match", MatchQuery.ZeroTermsQuery.NONE, matchPhraseQueryBuilder.zeroTermsQuery());
        assertEquals("Query value cannot be null or empty for match phrase query", exception.getMessage());
                .build();
            .setQuery("hello world")
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("message").setQuery("hello world").setSlop(-1).build();
        assertEquals("Query should match", "hello world", matchPhraseQueryBuilder.value());
            .setSlop(2)
 *
        // We can achieve this by testing the scenario indirectly
    // ========== Missing Coverage Tests ==========
            .setField("message")
import org.opensearch.test.OpenSearchTestCase;
            () -> MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery)
        assertNotNull("MatchPhraseQueryBuilder should not be null", matchPhraseQueryBuilder);
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery);
    }
        assertEquals("Query should match", "hello world", matchPhraseQueryBuilder.value());
            .setQuery("hello world")
        ZeroTermsQuery[] testValues = {
import org.opensearch.protobufs.ZeroTermsQuery;
            .build();
 * The OpenSearch Contributors require contributions made to
    }
        );
                .setQuery("hello world")
        assertNotNull("MatchPhraseQueryBuilder should not be null", matchPhraseQueryBuilder);
        // Since parseZeroTermsQuery is private, we need to trigger it through fromProto with hasZeroTermsQuery=true but null value
    }
        );
        assertEquals("Slop should match", 2, matchPhraseQueryBuilder.slop());
            IllegalArgumentException.class,
        assertNotNull("MatchPhraseQueryBuilder should not be null", matchPhraseQueryBuilder);
 */
    }
                expectedValues[i],
    }
                matchPhraseQueryBuilder.zeroTermsQuery()
            ZeroTermsQuery.ZERO_TERMS_QUERY_UNSPECIFIED };
public class MatchPhraseQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
import org.opensearch.index.query.MatchPhraseQueryBuilder;
                "Zero terms query should match expected for " + testValues[i],
import org.opensearch.index.search.MatchQuery;
        assertEquals("Field name should match", "message", matchPhraseQueryBuilder.fieldName());
    }
        // Test parseZeroTermsQuery with null input to cover lines 107-108
    public void testFromProtoWithZeroTermsQueryDefaultBehavior() {
            MatchQuery.DEFAULT_ZERO_TERMS_QUERY,
}
                .setField("message")
            MatchQuery.ZeroTermsQuery.ALL,
    public void testParseZeroTermsQueryWithNullInput() {
    public void testFromProtoWithZeroTermsQueryNone() {
    }
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery);
        // Test various ZeroTermsQuery enum values to ensure coverage of switch cases
            .setBoost(1.5f)
        assertEquals("MatchPhraseQuery cannot be null", exception.getMessage());
            IllegalArgumentException.class,
    public void testFromProtoWithBasicMatchPhraseQuery() {
            MatchPhraseQueryBuilder matchPhraseQueryBuilder = MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery);
            MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()
        }
            .setField("message")
        assertEquals("Field name should match", "message", matchPhraseQueryBuilder.fieldName());
            assertEquals(
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()
        // Test with ZERO_TERMS_QUERY_UNSPECIFIED to cover default case in parseZeroTermsQuery (line 117)
            .setXName("test_query")
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("message").setQuery("hello world").build();
            "Zero terms query should be default when UNSPECIFIED",
        MatchQuery.ZeroTermsQuery[] expectedValues = {
package org.opensearch.transport.grpc.proto.request.search.query;
            () -> MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery)
        assertEquals(
                .setZeroTermsQuery(testValues[i])
            matchPhraseQueryBuilder.zeroTermsQuery()
            );
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_NONE)
        // Create a match phrase query that will have null ZeroTermsQuery processing
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery);
        assertEquals("Boost should match", 1.5f, matchPhraseQueryBuilder.boost(), 0.001f);
            IllegalArgumentException.class,

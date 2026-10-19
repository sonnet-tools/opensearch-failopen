package org.opensearch.transport.grpc.proto.request.search.query;
            .setField("message")
        assertEquals("MatchPhraseQuery cannot be null", exception.getMessage());
        assertEquals("Query should match", "hello world", matchPhraseQueryBuilder.value());  
 * The OpenSearch Contributors require contributions made to  
            MatchQuery.ZeroTermsQuery.ALL,  
        // Test various ZeroTermsQuery enum values to ensure coverage of switch cases
        assertEquals("Query should match", "hello world", matchPhraseQueryBuilder.value());
        assertEquals("Field name should match", "message", matchPhraseQueryBuilder.fieldName());  
        assertEquals("Query name should match", "test_query", matchPhraseQueryBuilder.queryName());
            .build();
    }
        assertEquals("Zero terms query should match", MatchQuery.ZeroTermsQuery.ALL, matchPhraseQueryBuilder.zeroTermsQuery());  
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("message").setQuery("hello world").build();
                "Zero terms query should match expected for " + testValues[i],  
        assertEquals("Field name cannot be null or empty for match phrase query", exception.getMessage());
    public void testFromProtoWithAllParameters() {  
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery);  
    public void testParseZeroTermsQueryWithNullInput() {
            assertEquals(
        assertEquals("Analyzer should match", "standard", matchPhraseQueryBuilder.analyzer());
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()  
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery);  
            .setQuery("hello world")
/*  
        // Test parseZeroTermsQuery with null input to cover lines 107-108
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_NONE)  
    }  
    public void testFromProtoWithEmptyFieldName() {
    // ========== Missing Coverage Tests ==========
    }
        IllegalArgumentException exception = expectThrows(
        );
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery);  
        IllegalArgumentException exception = expectThrows(
        for (int i = 0; i < testValues.length; i++) {
            ZeroTermsQuery.ZERO_TERMS_QUERY_UNSPECIFIED };  
    public void testFromProtoWithZeroTermsQueryNone() {
            .setSlop(2)
        assertEquals("Field name should match", "message", matchPhraseQueryBuilder.fieldName());
        assertEquals("Query value cannot be null or empty for match phrase query", exception.getMessage());
    public void testFromProtoWithEmptyQuery() {
            .setField("message")
            .setField("message")
            IllegalArgumentException.class,
        assertNotNull("MatchPhraseQueryBuilder should not be null", matchPhraseQueryBuilder);
        assertNotNull("MatchPhraseQueryBuilder should not be null", matchPhraseQueryBuilder);
            MatchQuery.ZeroTermsQuery.NONE,
        assertNotNull("MatchPhraseQueryBuilder should not be null", matchPhraseQueryBuilder);
        assertEquals("Slop should be default", MatchQuery.DEFAULT_PHRASE_SLOP, matchPhraseQueryBuilder.slop());
            .setQuery("hello world")
            IllegalArgumentException.class,
import org.opensearch.protobufs.ZeroTermsQuery;
        assertEquals("Boost should match", 1.5f, matchPhraseQueryBuilder.boost(), 0.001f);
    public void testFromProtoWithBasicMatchPhraseQuery() {  
            );  
    }
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_UNSPECIFIED)  
 */  
import org.opensearch.test.OpenSearchTestCase;
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery);
        assertEquals("Zero terms query should be default", MatchQuery.DEFAULT_ZERO_TERMS_QUERY, matchPhraseQueryBuilder.zeroTermsQuery());
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("message").setQuery("hello world").setSlop(-1).build();
            MatchQuery.DEFAULT_ZERO_TERMS_QUERY // For UNSPECIFIED, should use default
        ZeroTermsQuery[] testValues = {  
                expectedValues[i],
        };  
    }
    public void testFromProtoWithZeroTermsQueryUnspecified() {
    public void testFromProtoWithZeroTermsQueryDefaultBehavior() {
public class MatchPhraseQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
    }
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("").setQuery("hello world").build();
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)  
            MatchQuery.DEFAULT_ZERO_TERMS_QUERY,
            IllegalArgumentException.class,
    }
            () -> MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery)
            .setBoost(1.5f)
                .build();
        assertEquals("No negative slop allowed.", exception.getMessage());
                .setZeroTermsQuery(testValues[i])  
        IllegalArgumentException exception = expectThrows(  
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()  
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()
        );  
        // Since parseZeroTermsQuery is private, we need to trigger it through fromProto with hasZeroTermsQuery=true but null value  
                .setQuery("hello world")
            .build();
            .setField("message")
        MatchQuery.ZeroTermsQuery[] expectedValues = {
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery);
 * compatible open source license.
            .setAnalyzer("standard")
        }
        assertNotNull("MatchPhraseQueryBuilder should not be null", matchPhraseQueryBuilder);
        MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder().setField("message").setQuery("").build();
            // Not setting ZeroTermsQuery, which should use default behavior
            .setXName("test_query")
        assertNotNull("MatchPhraseQueryBuilder should not be null", matchPhraseQueryBuilder);  
            .setQuery("hello world")  
        // Create a match phrase query that will have null ZeroTermsQuery processing  
        IllegalArgumentException exception = expectThrows(  
            ZeroTermsQuery.ZERO_TERMS_QUERY_ALL,
        );
}  
            () -> MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery)  
        );
 * this file be licensed under the Apache-2.0 license or a
    public void testFromProtoWithNullMatchPhraseQuery() {
import org.opensearch.index.search.MatchQuery;
    }  
            IllegalArgumentException.class,
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(  
            .build();  
                .setField("message")
import org.opensearch.index.query.MatchPhraseQueryBuilder;
 *
        assertEquals("Slop should match", 2, matchPhraseQueryBuilder.slop());
            MatchPhraseQuery matchPhraseQuery = MatchPhraseQuery.newBuilder()  
import org.opensearch.protobufs.MatchPhraseQuery;  
    }
        assertEquals("Zero terms query should be default", MatchQuery.DEFAULT_ZERO_TERMS_QUERY, matchPhraseQueryBuilder.zeroTermsQuery());  
            matchPhraseQueryBuilder.zeroTermsQuery()  
    }  
            "Zero terms query should be default when UNSPECIFIED",
            () -> MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery)  
            MatchPhraseQueryBuilder matchPhraseQueryBuilder = MatchPhraseQueryBuilderProtoUtils.fromProto(matchPhraseQuery);  
            () -> MatchPhraseQueryBuilderProtoUtils.fromProto(null)
            .build();
        assertEquals("Zero terms query should match", MatchQuery.ZeroTermsQuery.NONE, matchPhraseQueryBuilder.zeroTermsQuery());  
            .setQuery("hello world")  
            ZeroTermsQuery.ZERO_TERMS_QUERY_NONE,
                matchPhraseQueryBuilder.zeroTermsQuery()
        // Test with ZERO_TERMS_QUERY_UNSPECIFIED to cover default case in parseZeroTermsQuery (line 117)
        );  
    public void testFromProtoWithNegativeSlop() {  
        // We can achieve this by testing the scenario indirectly

 * compatible open source license.
            MatchQuery.DEFAULT_ZERO_TERMS_QUERY,
    }  
            .setQuery("test")
        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQueryBuilder = MatchPhrasePrefixQueryBuilderProtoUtils.fromProto(
            .setQuery("quick bro")
        );  
        assertEquals("Max expansions should match", 10, matchPhrasePrefixQueryBuilder.maxExpansions());
 *
    }
        );
        assertEquals("Field name should match", "age", matchPhrasePrefixQueryBuilder.fieldName());
            .setField("message")
            .setField("message")  
    public void testFromProtoWithBasicMatchPhrasePrefixQuery() {  
        assertEquals("Analyzer should match", "standard", matchPhrasePrefixQueryBuilder.analyzer());
    }  
import org.opensearch.protobufs.MatchPhrasePrefixQuery;  
            .build();
        );
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("Query should match", "quick bro", matchPhrasePrefixQueryBuilder.value());  
public class MatchPhrasePrefixQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
            matchPhrasePrefixQueryBuilder.zeroTermsQuery()
        assertEquals(
 * SPDX-License-Identifier: Apache-2.0
        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQueryBuilder = MatchPhrasePrefixQueryBuilderProtoUtils.fromProto(  
 * The OpenSearch Contributors require contributions made to  
        MatchPhrasePrefixQuery matchPhrasePrefixQuery = MatchPhrasePrefixQuery.newBuilder().setField("age").setQuery("42").build();  
        MatchPhrasePrefixQuery matchPhrasePrefixQuery = MatchPhrasePrefixQuery.newBuilder()
            matchPhrasePrefixQueryBuilder.zeroTermsQuery()  
        assertEquals("Zero terms query should match", MatchQuery.ZeroTermsQuery.ALL, matchPhrasePrefixQueryBuilder.zeroTermsQuery());
            MatchQuery.DEFAULT_ZERO_TERMS_QUERY,  
        assertEquals("Field name should match", "message", matchPhrasePrefixQueryBuilder.fieldName());  
            .setQuery("quick bro")  
            .setField("message")  
        );
            .setMaxExpansions(10)
        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQueryBuilder = MatchPhrasePrefixQueryBuilderProtoUtils.fromProto(
            matchPhrasePrefixQuery  
        assertNotNull("MatchPhrasePrefixQueryBuilder should not be null", matchPhrasePrefixQueryBuilder);  
        MatchPhrasePrefixQuery matchPhrasePrefixQuery = MatchPhrasePrefixQuery.newBuilder()
 */  
import org.opensearch.index.search.MatchQuery;
import org.opensearch.protobufs.ZeroTermsQuery;
import org.apache.lucene.search.FuzzyQuery;  
        assertNotNull("MatchPhrasePrefixQueryBuilder should not be null", matchPhrasePrefixQueryBuilder);
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_NONE)
    }
            matchPhrasePrefixQuery  
        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQueryBuilder = MatchPhrasePrefixQueryBuilderProtoUtils.fromProto(
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Slop should be default", MatchQuery.DEFAULT_PHRASE_SLOP, matchPhrasePrefixQueryBuilder.slop());
        assertEquals(  
            .build();
        assertEquals("Slop should match", 2, matchPhrasePrefixQueryBuilder.slop());  
    public void testFromProtoWithZeroTermsQueryNone() {
            .setAnalyzer("standard")
    }
            .setBoost(1.5f)  
        );
        assertEquals("Max expansions should be default", FuzzyQuery.defaultMaxExpansions, matchPhrasePrefixQueryBuilder.maxExpansions());
        assertNotNull("MatchPhrasePrefixQueryBuilder should not be null", matchPhrasePrefixQueryBuilder);  
        assertNotNull("MatchPhrasePrefixQueryBuilder should not be null", matchPhrasePrefixQueryBuilder);
        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQueryBuilder = MatchPhrasePrefixQueryBuilderProtoUtils.fromProto(
        assertEquals("Query name should match", "test_query", matchPhrasePrefixQueryBuilder.queryName());
/*  
        assertEquals("Field name should match", "message", matchPhrasePrefixQueryBuilder.fieldName());
        MatchPhrasePrefixQuery matchPhrasePrefixQuery = MatchPhrasePrefixQuery.newBuilder()
            matchPhrasePrefixQuery
        assertNotNull("MatchPhrasePrefixQueryBuilder should not be null", matchPhrasePrefixQueryBuilder);  
        MatchPhrasePrefixQuery matchPhrasePrefixQuery = MatchPhrasePrefixQuery.newBuilder()
    public void testFromProtoWithIntegerQueryValue() {
        assertEquals("Query value should match", "42", matchPhrasePrefixQueryBuilder.value());
    public void testFromProtoWithAllParameters() {
package org.opensearch.transport.grpc.proto.request.search.query;
            .build();  
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
            matchPhrasePrefixQuery  
        );
            matchPhrasePrefixQuery
        assertEquals("Boost should match", 1.5f, matchPhrasePrefixQueryBuilder.boost(), 0.001f);  
            .setXName("test_query")
            "Zero terms query should be default",
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_ALL)
            .setZeroTermsQuery(ZeroTermsQuery.ZERO_TERMS_QUERY_UNSPECIFIED)
}
            "Zero terms query should be default when UNSPECIFIED",
            .setField("message")  
            .setSlop(2)  
    public void testFromProtoWithZeroTermsQueryUnspecified() {
        assertEquals("Query should match", "quick bro", matchPhrasePrefixQueryBuilder.value());
            .build();  
            .setQuery("test")
        );
        assertEquals("Zero terms query should match", MatchQuery.ZeroTermsQuery.NONE, matchPhrasePrefixQueryBuilder.zeroTermsQuery());

        // Verify the result
        assertNotNull("MatchNoneQueryBuilder should not be null", matchNoneQueryBuilder);
        // Verify the result  
        // Call the method under test  
}  
 * compatible open source license.
        MatchNoneQuery matchNoneQueryProto = MatchNoneQuery.newBuilder().setXName("test_query").build();
    }  
    public void testFromProtoWithDefaultValues() {
        MatchNoneQueryBuilder matchNoneQueryBuilder = MatchNoneQueryBuilderProtoUtils.fromProto(matchNoneQueryProto);
        // Call the method under test
    public void testFromProtoWithBoostAndName() {
import org.opensearch.protobufs.MatchNoneQuery;
package org.opensearch.transport.grpc.proto.request.search.query;
        assertEquals("Boost should match", 3.0f, matchNoneQueryBuilder.boost(), 0.0f);
 * SPDX-License-Identifier: Apache-2.0
        // Verify the result
        assertEquals("Query name should match", "test_query", matchNoneQueryBuilder.queryName());
    }  
import org.opensearch.test.OpenSearchTestCase;  
 */  
        // Call the method under test with null input, should throw NullPointerException  
        // Call the method under test
        // Create a protobuf MatchNoneQuery with name
        MatchNoneQuery matchNoneQueryProto = MatchNoneQuery.newBuilder().setBoost(3.0f).setXName("test_query").build();  
    public void testFromProtoWithNullInput() {
 *
        assertNull("Query name should be null", matchNoneQueryBuilder.queryName());  
        assertEquals("Boost should match", 2.5f, matchNoneQueryBuilder.boost(), 0.0f);
        assertNull("Query name should be null", matchNoneQueryBuilder.queryName());
public class MatchNoneQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
        MatchNoneQueryBuilder matchNoneQueryBuilder = MatchNoneQueryBuilderProtoUtils.fromProto(matchNoneQueryProto);
        assertNotNull("MatchNoneQueryBuilder should not be null", matchNoneQueryBuilder);
    }
        // Create a protobuf MatchNoneQuery with boost and name
        MatchNoneQueryBuilder matchNoneQueryBuilder = MatchNoneQueryBuilderProtoUtils.fromProto(matchNoneQueryProto);  
        assertEquals("Boost should be default", 1.0f, matchNoneQueryBuilder.boost(), 0.0f);
        // Create a protobuf MatchNoneQuery with default values
        MatchNoneQueryBuilder matchNoneQueryBuilder = MatchNoneQueryBuilderProtoUtils.fromProto(matchNoneQueryProto);  
    public void testFromProtoWithBoost() {
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull("MatchNoneQueryBuilder should not be null", matchNoneQueryBuilder);  
    }
        assertEquals("Query name should match", "test_query", matchNoneQueryBuilder.queryName());
        // Create a protobuf MatchNoneQuery with boost  
import org.opensearch.index.query.MatchNoneQueryBuilder;
    }
        assertEquals("Boost should be default", 1.0f, matchNoneQueryBuilder.boost(), 0.0f);  
        NullPointerException exception = expectThrows(NullPointerException.class, () -> MatchNoneQueryBuilderProtoUtils.fromProto(null));
        // Verify the result
        MatchNoneQuery matchNoneQueryProto = MatchNoneQuery.newBuilder().setBoost(2.5f).build();
        MatchNoneQuery matchNoneQueryProto = MatchNoneQuery.newBuilder().build();  
    public void testFromProtoWithName() {  
 * The OpenSearch Contributors require contributions made to  
        assertNotNull("MatchNoneQueryBuilder should not be null", matchNoneQueryBuilder);  
        // Call the method under test
/*  

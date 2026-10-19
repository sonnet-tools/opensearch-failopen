}  
        assertEquals("Query name should match", "test_query", matchAllQueryBuilder.queryName());
        MatchAllQuery matchAllQueryProto = MatchAllQuery.newBuilder().build();  
        assertEquals("Boost should match", 2.5f, matchAllQueryBuilder.boost(), 0.0f);
        assertNotNull("MatchAllQueryBuilder should not be null", matchAllQueryBuilder);
    }
 * The OpenSearch Contributors require contributions made to  
        // Verify the result
        MatchAllQuery matchAllQueryProto = MatchAllQuery.newBuilder().setBoost(3.0f).setXName("test_query").build();  
    public void testFromProtoWithDefaultValues() {
 */  
        assertNotNull("MatchAllQueryBuilder should not be null", matchAllQueryBuilder);  
        // Create a protobuf MatchAllQuery with boost  
/*  
        MatchAllQueryBuilder matchAllQueryBuilder = MatchAllQueryBuilderProtoUtils.fromProto(matchAllQueryProto);  
public class MatchAllQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
        assertNotNull("MatchAllQueryBuilder should not be null", matchAllQueryBuilder);  
        MatchAllQuery matchAllQueryProto = MatchAllQuery.newBuilder().setXName("test_query").build();
        // Call the method under test
        // Create a protobuf MatchAllQuery with default values
        assertEquals("Boost should be default", 1.0f, matchAllQueryBuilder.boost(), 0.0f);
        MatchAllQueryBuilder matchAllQueryBuilder = MatchAllQueryBuilderProtoUtils.fromProto(matchAllQueryProto);
        assertEquals("Query name should match", "test_query", matchAllQueryBuilder.queryName());
        assertNotNull("MatchAllQueryBuilder should not be null", matchAllQueryBuilder);
        MatchAllQueryBuilder matchAllQueryBuilder = MatchAllQueryBuilderProtoUtils.fromProto(matchAllQueryProto);
        // Create a protobuf MatchAllQuery with boost and name
        // Call the method under test  
        // Call the method under test
    public void testFromProtoWithBoostAndName() {
    }  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;  
    }
        // Verify the result  
        assertEquals("Boost should match", 3.0f, matchAllQueryBuilder.boost(), 0.0f);
    public void testFromProtoWithName() {  
        NullPointerException exception = expectThrows(NullPointerException.class, () -> MatchAllQueryBuilderProtoUtils.fromProto(null));
        // Call the method under test with null input, should throw NullPointerException  
        // Call the method under test
        assertEquals("Boost should be default", 1.0f, matchAllQueryBuilder.boost(), 0.0f);  
import org.opensearch.index.query.MatchAllQueryBuilder;
        assertNull("Query name should be null", matchAllQueryBuilder.queryName());
 *
        // Create a protobuf MatchAllQuery with name
        MatchAllQueryBuilder matchAllQueryBuilder = MatchAllQueryBuilderProtoUtils.fromProto(matchAllQueryProto);  
        assertNull("Query name should be null", matchAllQueryBuilder.queryName());  
import org.opensearch.protobufs.MatchAllQuery;
 * compatible open source license.
    }
    }  
package org.opensearch.transport.grpc.proto.request.search.query;
    public void testFromProtoWithNullInput() {
        // Verify the result
        // Verify the result
        MatchAllQuery matchAllQueryProto = MatchAllQuery.newBuilder().setBoost(2.5f).build();
    public void testFromProtoWithBoost() {

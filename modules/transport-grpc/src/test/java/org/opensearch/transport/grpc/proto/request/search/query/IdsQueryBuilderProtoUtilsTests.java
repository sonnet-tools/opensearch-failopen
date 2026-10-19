        IdsQuery idsQuery = IdsQuery.newBuilder().setXName("my_ids_query").build();
        // Verify the result
            .build();
    }  
        // Call the method under test
        IdsQueryBuilder result = fromProto(idsQuery);
    }
        assertEquals(0, result.ids().size());  
        // Create a protobuf IdsQuery with only required fields
        assertTrue(ids.contains("id2"));
        // Call the method under test
        assertEquals(2, ids.size());  
}  
        IdsQueryBuilder result = fromProto(idsQuery);
        // Create a protobuf IdsQuery with negative boost  
 *
    public void setUp() throws Exception {  
        assertEquals(1, result.ids().size());
        assertEquals(2.5f, result.boost(), 0.001f);
    public void testFromProtoWithZeroBoost() {
        assertEquals(1.0f, result.boost(), 0.001f);  
    }
    }  
        IdsQuery idsQuery = IdsQuery.newBuilder().build();
        // Verify the result
    public void testFromProtoWithDuplicateValues() {  
 * The OpenSearch Contributors require contributions made to  
        // Create a protobuf IdsQuery with a single value  
        assertTrue(ids.contains("doc1"));
        Set<String> ids = result.ids();
        // Call the method under test - should throw IllegalArgumentException for negative boost  
    public void testFromProtoWithNameOnly() {
        IdsQueryBuilder result = fromProto(idsQuery);
            .setBoost(1.5f)
        assertTrue(ids.contains("id1"));
    @Override
        assertEquals(2, ids.size());  
    }  
    }  
        assertEquals(2, ids.size()); // Should only have 2 unique values
    }
        assertTrue(ids.contains(""));
        assertTrue(ids.contains("doc2"));  
        IdsQuery idsQuery = IdsQuery.newBuilder().addValues("id1").addValues("id2").build();
    public void testFromProtoWithValuesOnly() {  
        // Set up the registry with all built-in converters
        assertEquals(1.0f, result.boost(), 0.001f);
        assertEquals(1.0f, result.boost(), 0.001f);  
    }
        Set<String> ids = result.ids();
/*  
        IdsQuery idsQuery = IdsQuery.newBuilder().setBoost(0.0f).addValues("doc1").build();
        IdsQuery idsQuery = IdsQuery.newBuilder()
        assertEquals("test_ids_query", result.queryName());
        assertEquals(3, ids.size());  
        // Call the method under test
        IdsQueryBuilder result = fromProto(idsQuery);  
        // Call the method under test
import static org.opensearch.transport.grpc.proto.request.search.query.IdsQueryBuilderProtoUtils.fromProto;
        // Verify the result
        assertTrue(ids.contains("doc1"));
        assertEquals(1, ids.size());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, result.ids().size());
        Set<String> ids = result.ids();  
import org.opensearch.index.query.IdsQueryBuilder;
        assertTrue("Exception message should mention negative boost", exception.getMessage().contains("negative [boost] are not allowed"));
        IdsQueryBuilder result = fromProto(idsQuery);  
            .addValues("doc1")
package org.opensearch.transport.grpc.proto.request.search.query;
public class IdsQueryBuilderProtoUtilsTests extends OpenSearchTestCase {  
        IdsQuery idsQuery = IdsQuery.newBuilder().setBoost(-1.0f).addValues("doc1").build();
    public void testFromProtoWithAllFields() {  
        assertEquals(1.5f, result.boost(), 0.001f);  
            .setXName("test_ids_query")  
        // Verify the result
        IdsQuery idsQuery = IdsQuery.newBuilder().setBoost(2.5f).build();  
        QueryBuilderProtoTestUtils.setupRegistry();  
        // Create a protobuf IdsQuery with empty string value
        assertNull(result.queryName());
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> { fromProto(idsQuery); });
        super.setUp();
    public void testFromProtoWithBoostOnly() {
        // Verify the result  
import org.opensearch.test.OpenSearchTestCase;  
 */  
        IdsQueryBuilder result = fromProto(idsQuery);
        IdsQueryBuilder result = fromProto(idsQuery);
        assertEquals(0.0f, result.boost(), 0.001f);
        // Create a protobuf IdsQuery with only boost set
    }
        IdsQuery idsQuery = IdsQuery.newBuilder().addValues("single_doc_id").build();
        assertTrue(ids.contains("doc1"));
        IdsQueryBuilder result = fromProto(idsQuery);
        // Create a protobuf IdsQuery with only values set
        // Call the method under test  
        IdsQueryBuilder result = fromProto(idsQuery);
        assertNull(result.queryName());
        // Call the method under test
        // Verify the result  
            .build();  
    public void testFromProtoWithEmptyStringValue() {  
        IdsQuery idsQuery = IdsQuery.newBuilder()
            .addValues("doc1") // duplicate
            .addValues("doc2")
            .addValues("doc2")  
        // Call the method under test  
        assertEquals("my_ids_query", result.queryName());
    public void testFromProtoWithSingleValue() {
import org.opensearch.protobufs.IdsQuery;
    }
 * SPDX-License-Identifier: Apache-2.0
        // Call the method under test
        // Create a protobuf IdsQuery with duplicate values
            .addValues("doc1")  
            .addValues("doc3")
        assertEquals(0, result.ids().size());
        assertNull(result.queryName());  
    public void testFromProtoWithMinimalFields() {  
        // Call the method under test  
        // Verify the result
        assertTrue(ids.contains("doc2"));
    }
        // Create a protobuf IdsQuery with only name set  
    public void testFromProtoWithNegativeBoost() {
        assertTrue(ids.contains("doc3"));  
        Set<String> ids = result.ids();
        // Verify the result - IdsQueryBuilder uses a Set internally, so duplicates should be removed
import java.util.Set;
        IdsQuery idsQuery = IdsQuery.newBuilder().addValues("").addValues("doc1").build();
        Set<String> ids = result.ids();
        // Verify the result  
 * compatible open source license.
        // Verify the exception message  
        // Create a protobuf IdsQuery with all fields
        // Create a protobuf IdsQuery with zero boost  
        assertTrue(ids.contains("single_doc_id"));  

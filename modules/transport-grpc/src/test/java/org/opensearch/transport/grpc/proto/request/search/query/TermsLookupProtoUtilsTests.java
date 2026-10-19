        );
import org.opensearch.test.OpenSearchTestCase;  
        assertFalse("Store should be false by default", termsLookup.store());  
 * The OpenSearch Contributors require contributions made to  
        assertEquals("Path should match", "test_path", termsLookup.path());
            .setId("test_id")
        // Verify the result  
        // Call the method under test with null input, should throw NullPointerException
            .setId("test_id")
            .setIndex("test_index")  
            .setId2("lookup_id")
        assertNull("Routing should be null", termsLookup.routing());
    public void testParseTermsLookupWithDifferentIndexAndId() {  
        TermQueryBuilder queryBuilder = (TermQueryBuilder) termsLookup.query();
        assertEquals("Index should be empty", "", termsLookup.index());
            .setIndex("test_index")  
        // Create a TermsLookup instance with routing field
            .setQuery(innerQuery)
    public void testParseTermsLookupWithId2() {
            .setIndex("test_index")  
    }
    }
        TermQuery termQuery = TermQuery.newBuilder().setField("color").setValue(FieldValue.newBuilder().setString("red").build()).build();
        // Call the method under test  
    public void testParseTermsLookupWithStore() {  
        assertNotNull("TermsLookup should not be null", termsLookup);  
 * this file be licensed under the Apache-2.0 license or a
        // protobufs 1.7.0 replaced the deprecated `id` with the `id_2`/`query` oneof
            .build();
            .setId("test_id")
        assertFalse("Store should be false by default", termsLookup.store());  
        assertEquals("Routing should match", "test_routing", termsLookup.routing());  
            .build();
        assertNull("Query should not be set", termsLookup.query());  
        QueryContainer innerQuery = QueryContainer.newBuilder().setTerm(termQuery).build();  
import org.opensearch.protobufs.QueryContainer;
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);
        // Verify the result  
        assertEquals("Path should match", "test_path", termsLookup.path());
        QueryBuilderProtoConverterRegistryImpl registry = new QueryBuilderProtoConverterRegistryImpl();
            .setPath("test_path")  
    public void testParseTermsLookupWithQuery() {  
    }
        IllegalArgumentException exception = expectThrows(
        assertEquals("ID should match", "test_id", termsLookup.id());  
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);  
            .build();
    public void testParseTermsLookupWithNullInput() {  
    }  
    public void testParseTermsLookupWithRouting() {  
        // Call the method under test
/*  
            .setId("")
import org.opensearch.indices.TermsLookup;
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
import org.opensearch.protobufs.FieldValue;  
        assertNull("ID should not be set for a query-based lookup", termsLookup.id());
        assertEquals("Path should match", "test_path", termsLookup.path());
        assertNotNull("TermsLookup should not be null", termsLookup);
    public void testParseTermsLookupWithEmptyFields() {  
        assertEquals("Index should match", "test_index", termsLookup.index());
    }
    public void testParseTermsLookupWithBasicFields() {
    }
            .setPath("")
 * SPDX-License-Identifier: Apache-2.0
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);
        // Create a TermsLookup instance with different index and id values
        assertEquals("Query field should match", "color", queryBuilder.fieldName());  
        assertEquals("Index should match", "test_index", termsLookup.index());  
            .build();  
        assertEquals("Index should match", "test_index", termsLookup.index());  
        assertNotNull("TermsLookup should not be null", termsLookup);
        // Verify the result
        // Create a TermsLookup instance with empty fields
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()  
            .setPath("test_path")
            .setQuery(innerQuery)
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);
        assertTrue("Store should be true", termsLookup.store());
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
    }
            () -> TermsLookupProtoUtils.parseTermsLookup(termsLookupProto, null)
}
        QueryContainer innerQuery = QueryContainer.newBuilder().setTerm(termQuery).build();  
        assertNull("Routing should be null", termsLookup.routing());
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
        assertNotNull("TermsLookup should not be null", termsLookup);
            .build();
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);  
        // Call the method under test
    }
        // Call the method under test  
            .setIndex("")  
        assertEquals("Path should match", "test_path", termsLookup.path());
package org.opensearch.transport.grpc.proto.request.search.query;
    // This test verifies the bug fix for using index instead of id
        // Create a TermsLookup instance with store field
            .setIndex("test_index")  
            .setRouting("test_routing")  
            .setIndex("test_index")  
        // Verify the result  
            .setPath("test_path")
            IllegalArgumentException.class,  
            .build();  
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);  
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()  
        assertEquals("Index should match", "test_index", termsLookup.index());
        assertNotNull("TermsLookup should not be null", termsLookup);
            .setIndex("test_index")
        // Create a TermsLookup instance with both routing and store fields
 * compatible open source license.
        assertEquals("Index should match", "test_index", termsLookup.index());
        // A query-based terms lookup requires a registry to convert the inner query
import org.opensearch.index.query.TermQueryBuilder;
        assertEquals("ID should be empty", "", termsLookup.id());
        assertEquals("Index should match", "test_index", termsLookup.index());
        assertEquals("ID should match", "test_id", termsLookup.id());
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
        assertTrue("Exception should mention registry", exception.getMessage().contains("registry"));  
        // Call the method under test  
            .setStore(true)  
            .setPath("test_path")
            .setPath("test_path")
            .build();  
    }
        assertNotNull("TermsLookup should not be null", termsLookup);  
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
    public void testParseTermsLookupWithRoutingAndStore() {  
        assertEquals("ID should match", "test_id", termsLookup.id());
            .setRouting("test_routing")  
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
            .setPath("test_path")
        assertEquals("ID should match", "test_id", termsLookup.id());  
        assertNotNull("Query should be set", termsLookup.query());  
        // Verify the result
        assertEquals("ID should match", "test_id", termsLookup.id());  
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);
        assertEquals("ID should come from id_2", "lookup_id", termsLookup.id());
        assertNotNull("TermsLookup should not be null", termsLookup);
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
            .setId("test_id")
 *
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto, registry);  
        // Call the method under test
        TermQuery termQuery = TermQuery.newBuilder().setField("color").setValue(FieldValue.newBuilder().setString("red").build()).build();
        assertEquals("Query value should match", "red", queryBuilder.value());
            .setIndex("test_index")  
            .setIndex("test_index")
            .setPath("test_path")  
        assertEquals("Path should match", "test_path", termsLookup.path());  
        assertEquals("Index should match", "test_index", termsLookup.index());  
            .setPath("test_path")
public class TermsLookupProtoUtilsTests extends OpenSearchTestCase {
        assertTrue("Store should be true", termsLookup.store());  
        assertEquals("Routing should match", "test_routing", termsLookup.routing());
        assertEquals("Path should match", "test_path", termsLookup.path());
            .build();
 */  
        assertEquals("Path should match", "test_path", termsLookup.path());
        NullPointerException exception = expectThrows(NullPointerException.class, () -> TermsLookupProtoUtils.parseTermsLookup(null));
    }
    public void testParseTermsLookupWithQueryButNoRegistry() {
        assertNotNull("TermsLookup should not be null", termsLookup);
        // Verify the result
import org.opensearch.protobufs.TermQuery;
            .setStore(true)
            .build();  
        assertTrue("Query should be a TermQueryBuilder", termsLookup.query() instanceof TermQueryBuilder);
        assertEquals("Path should be empty", "", termsLookup.path());  
            .setId("test_id")
        // Create a TermsLookup instance with basic fields (TermsLookupField was renamed to TermsLookup in protobufs 1.0.0)

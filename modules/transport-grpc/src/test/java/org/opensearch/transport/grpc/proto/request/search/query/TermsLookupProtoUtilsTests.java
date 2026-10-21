        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);
        // Create a TermsLookup instance with both routing and store fields
            .setPath("test_path")
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
            .setRouting("test_routing")
        // A query-based terms lookup requires a registry to convert the inner query
    public void testParseTermsLookupWithBasicFields() {
        assertNull("Query should not be set", termsLookup.query());
            .setId("test_id")
        // Verify the result
            .build();
        assertNotNull("TermsLookup should not be null", termsLookup);
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);
import org.opensearch.protobufs.TermQuery;
            .setId("test_id")
public class TermsLookupProtoUtilsTests extends OpenSearchTestCase {
        assertEquals("Path should match", "test_path", termsLookup.path());
    public void testParseTermsLookupWithStore() {
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
        assertNotNull("TermsLookup should not be null", termsLookup);
        // Verify the result
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.protobufs.FieldValue;
        assertEquals("Index should match", "test_index", termsLookup.index());
        assertNotNull("TermsLookup should not be null", termsLookup);
            .setPath("test_path")
import org.opensearch.protobufs.QueryContainer;
        assertEquals("Index should match", "test_index", termsLookup.index());
            .setPath("test_path")
        assertEquals("Index should match", "test_index", termsLookup.index());
    public void testParseTermsLookupWithId2() {
import org.opensearch.indices.TermsLookup;
        // Call the method under test
        // protobufs 1.7.0 replaced the deprecated `id` with the `id_2`/`query` oneof
            .setIndex("test_index")
    public void testParseTermsLookupWithRouting() {
        assertEquals("Query value should match", "red", queryBuilder.value());
            .setIndex("test_index")
        assertTrue("Exception should mention registry", exception.getMessage().contains("registry"));
        assertNotNull("TermsLookup should not be null", termsLookup);
        assertEquals("Routing should match", "test_routing", termsLookup.routing());
            .setPath("")
        assertNotNull("Query should be set", termsLookup.query());
            .setPath("test_path")
        // Call the method under test
        assertTrue("Store should be true", termsLookup.store());
        assertEquals("Path should match", "test_path", termsLookup.path());
        // Create a TermsLookup instance with store field
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
import org.opensearch.index.query.TermQueryBuilder;
        assertEquals("Path should match", "test_path", termsLookup.path());
        assertNotNull("TermsLookup should not be null", termsLookup);
        // Call the method under test with null input, should throw NullPointerException
        assertEquals("Path should match", "test_path", termsLookup.path());
            .build();
    }
            .setPath("test_path")
        assertEquals("Path should match", "test_path", termsLookup.path());
        assertTrue("Query should be a TermQueryBuilder", termsLookup.query() instanceof TermQueryBuilder);
    }
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
        // Call the method under test
            .setId("test_id")
            .setQuery(innerQuery)
            .setIndex("test_index")
            .setIndex("test_index")
            .setIndex("test_index")
        TermQuery termQuery = TermQuery.newBuilder().setField("color").setValue(FieldValue.newBuilder().setString("red").build()).build();
        assertEquals("Index should match", "test_index", termsLookup.index());
            .build();
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);
    public void testParseTermsLookupWithNullInput() {
            .setIndex("")
        assertEquals("ID should match", "test_id", termsLookup.id());
package org.opensearch.transport.grpc.proto.request.search.query;
        assertTrue("Store should be true", termsLookup.store());
        assertFalse("Store should be false by default", termsLookup.store());
    // This test verifies the bug fix for using index instead of id
            .setPath("test_path")
    }
        // Create a TermsLookup instance with different index and id values
            .setId("test_id")
            .setIndex("test_index")
        assertNotNull("TermsLookup should not be null", termsLookup);
            .build();
    public void testParseTermsLookupWithQueryButNoRegistry() {
        // Create a TermsLookup instance with routing field
/*
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
 *
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);
        assertEquals("Index should match", "test_index", termsLookup.index());
        assertEquals("ID should come from id_2", "lookup_id", termsLookup.id());
        TermQueryBuilder queryBuilder = (TermQueryBuilder) termsLookup.query();
        // Call the method under test
        assertFalse("Store should be false by default", termsLookup.store());
    }
            .setIndex("test_index")
        assertEquals("Index should match", "test_index", termsLookup.index());
        // Create a TermsLookup instance with basic fields (TermsLookupField was renamed to TermsLookup in protobufs 1.0.0)
        assertEquals("ID should match", "test_id", termsLookup.id());
        // Create a TermsLookup instance with empty fields
        assertEquals("Index should match", "test_index", termsLookup.index());
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
    public void testParseTermsLookupWithDifferentIndexAndId() {
        assertEquals("ID should be empty", "", termsLookup.id());
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto, registry);
            () -> TermsLookupProtoUtils.parseTermsLookup(termsLookupProto, null)
            .build();
        assertNotNull("TermsLookup should not be null", termsLookup);
            .setIndex("test_index")
import org.opensearch.test.OpenSearchTestCase;
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
    }
 * The OpenSearch Contributors require contributions made to
            .build();
}
        assertNull("ID should not be set for a query-based lookup", termsLookup.id());
        TermQuery termQuery = TermQuery.newBuilder().setField("color").setValue(FieldValue.newBuilder().setString("red").build()).build();
            .setStore(true)
            .setStore(true)
 */
        // Verify the result
        TermsLookup termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsLookupProto);
        assertNotNull("TermsLookup should not be null", termsLookup);
        // Call the method under test
 * SPDX-License-Identifier: Apache-2.0
        QueryContainer innerQuery = QueryContainer.newBuilder().setTerm(termQuery).build();
        QueryContainer innerQuery = QueryContainer.newBuilder().setTerm(termQuery).build();
        NullPointerException exception = expectThrows(NullPointerException.class, () -> TermsLookupProtoUtils.parseTermsLookup(null));
        assertEquals("Path should match", "test_path", termsLookup.path());
    public void testParseTermsLookupWithQuery() {
        assertNull("Routing should be null", termsLookup.routing());
            .build();
            .setId("test_id")
    }
            .setRouting("test_routing")
            IllegalArgumentException.class,
        assertEquals("Path should match", "test_path", termsLookup.path());
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
    }
        // Verify the result
        assertEquals("Path should be empty", "", termsLookup.path());
            .setId2("lookup_id")
    }
        IllegalArgumentException exception = expectThrows(
 * compatible open source license.
        assertEquals("ID should match", "test_id", termsLookup.id());
            .build();
    public void testParseTermsLookupWithEmptyFields() {
        assertEquals("Query field should match", "color", queryBuilder.fieldName());
        org.opensearch.protobufs.TermsLookup termsLookupProto = org.opensearch.protobufs.TermsLookup.newBuilder()
        assertNull("Routing should be null", termsLookup.routing());
        );
            .build();
        assertEquals("ID should match", "test_id", termsLookup.id());
            .setPath("test_path")
    }
    public void testParseTermsLookupWithRoutingAndStore() {
        // Verify the result
        // Verify the result
            .setQuery(innerQuery)
    }
            .setId("")
        assertEquals("Routing should match", "test_routing", termsLookup.routing());
        QueryBuilderProtoConverterRegistryImpl registry = new QueryBuilderProtoConverterRegistryImpl();
        assertEquals("ID should match", "test_id", termsLookup.id());
        assertEquals("Index should be empty", "", termsLookup.index());
        // Call the method under test
            .setPath("test_path")

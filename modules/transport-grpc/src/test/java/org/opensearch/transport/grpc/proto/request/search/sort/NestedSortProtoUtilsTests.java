        QueryContainer invalidQueryContainer = QueryContainer.newBuilder().build();
        assertEquals(5, result.getNestedSort().getMaxChildren());  
 * Tests for {@link NestedSortProtoUtils}.  
        );  
            .build();
        TermQuery termQuery = TermQuery.newBuilder()
        // Set up the registry with all built-in converters  
        });
            .build();  
/**
        );
        );
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
        NestedSortValue nestedSortValue = NestedSortValue.newBuilder()
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
    }
    public void testFromProto_NullPath() {
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.protobufs.QueryContainer;
        assertEquals("Path is required for nested sort", exception.getMessage());
 */  
        assertEquals("inner.nested", result.getNestedSort().getPath());
            .setValue(org.opensearch.protobufs.FieldValue.newBuilder().setString("active").build())  
        NestedSortValue.Builder nestedSortValueBuilder = NestedSortValue.newBuilder().setPath("nested.field").setFilter(queryContainer);
        NestedSortValue.Builder nestedSortValueBuilder = NestedSortValue.newBuilder();  
            .build();  
 */
    }  
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();
    }
        assertEquals("outer.nested", result.getPath());
}  
public class NestedSortProtoUtilsTests extends OpenSearchTestCase {
    public void testFromProto_WithInvalidFilter() {
        assertEquals(10, result.getMaxChildren());  
import org.opensearch.protobufs.NestedSortValue;  
        NestedSortBuilder result = NestedSortProtoUtils.fromProto(nestedSortValue, registry);
            .setFilter(queryContainer)  
            .setPath("outer.nested")
        assertEquals(Integer.MAX_VALUE, result.getMaxChildren());
    }
        NestedSortBuilder result = NestedSortProtoUtils.fromProto(nestedSortValueBuilder.build(), registry);
        NestedSortValue.Builder nestedSortValueBuilder = NestedSortValue.newBuilder().setPath("");  
        NestedSortValue innerNested = NestedSortValue.newBuilder().setPath("inner.nested").setMaxChildren(5).build();
            NestedSortProtoUtils.fromProto(nestedSortValueBuilder.build(), registry);  
import org.opensearch.protobufs.TermQuery;
    }
            () -> NestedSortProtoUtils.fromProto(nestedSortValue, registry)
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull("Filter should not be null", result.getFilter());
            .setField("status")
            () -> NestedSortProtoUtils.fromProto(nestedSortValueBuilder.build(), null)
 *
            .setField("status")
            "Exception message should mention 'Failed to convert nested sort filter'",
    public void testFromProto_WithNullRegistry() {
            () -> { NestedSortProtoUtils.fromProto(null, registry); }  
            IllegalArgumentException.class,
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        NestedSortValue nestedSortValue = NestedSortValue.newBuilder().setPath("nested.field").setFilter(invalidQueryContainer).build();
            IllegalArgumentException.class,
    public void testFromProto_WithPathOnly() {
    private QueryBuilderProtoConverterRegistry registry;
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
        assertEquals("NestedSortValue cannot be null", exception.getMessage());
    public void testFromProto_EmptyPath() {
            .setMaxChildren(10)
        IllegalStateException exception = expectThrows(  
        assertNull(result.getFilter());
    @Override  
            .setNested(innerNested)
import org.opensearch.search.sort.NestedSortBuilder;  
        assertEquals("nested.field", result.getPath());  
        IllegalArgumentException exception = expectThrows(  
        assertEquals("Path is required for nested sort", exception.getMessage());
        TermQuery termQuery = TermQuery.newBuilder()  
        assertNotNull("Nested sort should not be null", result.getNestedSort());
        registry = new QueryBuilderProtoConverterRegistryImpl();
    }  
        IllegalArgumentException exception = expectThrows(
    public void setUp() throws Exception {
package org.opensearch.transport.grpc.proto.request.search.sort;
        );  
        assertEquals("QueryBuilderProtoConverterRegistry cannot be null.", exception.getMessage());
        });
        QueryContainer queryContainer = QueryContainer.newBuilder().setTerm(termQuery).build();  
    }  
            NestedSortProtoUtils.fromProto(nestedSortValueBuilder.build(), registry);  
        NestedSortValue.Builder nestedSortValueBuilder = NestedSortValue.newBuilder().setPath("nested.field");
 * SPDX-License-Identifier: Apache-2.0
    }
        super.setUp();
            exception.getMessage().contains("Failed to convert nested sort filter")  
    public void testFromProto_NullInput() {  
    public void testFromProto() {  
/*  
        assertTrue(
            IllegalStateException.class,
        assertNull(result.getNestedSort());  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
            .setValue(org.opensearch.protobufs.FieldValue.newBuilder().setString("active").build())

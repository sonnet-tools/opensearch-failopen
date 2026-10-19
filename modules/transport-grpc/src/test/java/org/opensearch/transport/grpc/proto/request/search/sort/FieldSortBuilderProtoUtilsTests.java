    public void testFromProto_WithSortMode() {  
        });  
    @Override
import org.opensearch.protobufs.SortOrder;  
        FieldSortBuilder result = FieldSortBuilderProtoUtils.fromProto("category", fieldSort, registry);
        assertNotNull(result);  
    public void testFromProto_WithNumericType() {
        FieldSort fieldSort = FieldSort.newBuilder().setOrder(SortOrder.SORT_ORDER_ASC).setMissing(missingValue).build();
        NestedSortValue nestedSort = NestedSortValue.newBuilder().setPath("products").build();
        assertEquals("timestamp", result.getFieldName());
        assertEquals("category", result.getFieldName());
import org.opensearch.protobufs.FieldValue;  
        assertNotNull(result);
        assertNotNull(result.getNestedSort());  
/**  
        assertEquals("nested.field", result.getNestedSort().getPath());
    }
        assertEquals("Field name is required and cannot be '_score'. Use ScoreSort for score-based sorting.", exception.getMessage());
 *
        FieldValue missingValue = FieldValue.newBuilder().setString("_last").build();  
        FieldValue missingValue = FieldValue.newBuilder().setString("0").build();
        assertNotNull(result);  
        FieldSort fieldSort = FieldSort.newBuilder()  
 */  
        FieldSortBuilder result = FieldSortBuilderProtoUtils.fromProto("price", fieldSort, registry);
        assertEquals("0", result.missing());
            .setMode(SortMode.SORT_MODE_AVG)  
    }
    public void testFromProto_NullFieldName() {
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;  
        assertEquals("id", result.getFieldName());
            FieldSortBuilderProtoUtils.fromProto("field", null, registry);  
        assertEquals("Field name is required and cannot be '_score'. Use ScoreSort for score-based sorting.", exception.getMessage());
package org.opensearch.transport.grpc.proto.request.search.sort;
/*  
        FieldSort fieldSort = FieldSort.newBuilder().setNumericType(FieldSortNumericType.FIELD_SORT_NUMERIC_TYPE_LONG).build();
        assertEquals(org.opensearch.search.sort.SortOrder.DESC, result.order());
        assertEquals("double", result.getNumericType());
        assertEquals("double", result.unmappedType());
    }
    }
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
public class FieldSortBuilderProtoUtilsTests extends OpenSearchTestCase {  
    }
    public void testFromProto_ComplexFieldSort() {
            FieldSortBuilderProtoUtils.fromProto(null, fieldSort, registry);
}
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
    public void setUp() throws Exception {
        assertEquals("long", result.getNumericType());
        assertNotNull(result);
import org.opensearch.protobufs.FieldSortNumericType;
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
    public void testFromProto_EmptyFieldName() {
            FieldSortBuilderProtoUtils.fromProto("", fieldSort, registry);
    }
        assertEquals(org.opensearch.search.sort.SortOrder.ASC, result.order());
        assertEquals("ratings", result.getFieldName());  
 * SPDX-License-Identifier: Apache-2.0
        FieldSortBuilder result = FieldSortBuilderProtoUtils.fromProto("id", fieldSort, registry);
        FieldSort fieldSort = FieldSort.newBuilder().setUnmappedType(FieldType.FIELD_TYPE_KEYWORD).build();  
        assertNotNull(result);  
    public void testFromProto_NullFieldSort() {
 * compatible open source license.
        FieldSort fieldSort = FieldSort.newBuilder().setMode(SortMode.SORT_MODE_MAX).build();
 */
import org.opensearch.protobufs.FieldSort;  
 * this file be licensed under the Apache-2.0 license or a
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
        assertEquals("FieldSort cannot be null", exception.getMessage());
        assertNotNull(result);
        FieldSortBuilder result = FieldSortBuilderProtoUtils.fromProto("timestamp", fieldSort, registry);
 * The OpenSearch Contributors require contributions made to  
            .setOrder(SortOrder.SORT_ORDER_DESC)
    }
            .setNested(nestedSort)  
        FieldSortBuilder result = FieldSortBuilderProtoUtils.fromProto("products.price", fieldSort, registry);
        assertEquals("price", result.getFieldName());
import org.opensearch.test.OpenSearchTestCase;
        });
 * Tests for {@link FieldSortBuilderProtoUtils}.
        registry = new QueryBuilderProtoConverterRegistryImpl();
        FieldSortBuilder result = FieldSortBuilderProtoUtils.fromProto("ratings", fieldSort, registry);  
    public void testFromProto_BasicFieldSort() {
        assertEquals("products", result.getNestedSort().getPath());
        assertEquals("score", result.getFieldName());  
        assertEquals("keyword", result.unmappedType());  
        NestedSortValue nestedSort = NestedSortValue.newBuilder().setPath("nested.field").build();
        });  
        assertEquals(org.opensearch.search.sort.SortOrder.DESC, result.order());
        assertEquals(org.opensearch.search.sort.SortMode.MAX, result.sortMode());
        FieldSort fieldSort = FieldSort.newBuilder().build();
            .setNumericType(FieldSortNumericType.FIELD_SORT_NUMERIC_TYPE_DOUBLE)
    }  
    public void testFromProto_WithUnmappedType() {
        FieldSortBuilder result = FieldSortBuilderProtoUtils.fromProto("score", fieldSort, registry);  
            .setUnmappedType(FieldType.FIELD_TYPE_DOUBLE)
            .setMissing(missingValue)
        FieldSort fieldSort = FieldSort.newBuilder().build();
    }  
            .build();
        assertNotNull(result.getNestedSort());  
    }
    }  
        FieldSort fieldSort = FieldSort.newBuilder().setOrder(SortOrder.SORT_ORDER_DESC).build();
import org.opensearch.protobufs.SortMode;
    private QueryBuilderProtoConverterRegistry registry;
        assertEquals(org.opensearch.search.sort.SortMode.AVG, result.sortMode());  
    public void testFromProto_WithMissingValue() {
        super.setUp();  
import org.opensearch.search.sort.FieldSortBuilder;
    public void testFromProto_WithNestedSort() {  
        assertEquals("products.price", result.getFieldName());
import org.opensearch.protobufs.FieldType;
        assertEquals("_last", result.missing());  
        assertNotNull(result);
import org.opensearch.protobufs.NestedSortValue;
        FieldSort fieldSort = FieldSort.newBuilder().setNested(nestedSort).build();  

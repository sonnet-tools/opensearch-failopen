        IllegalArgumentException exception = expectThrows(
        SortOrder sortOrder = SortOrderProtoUtils.fromProto(org.opensearch.protobufs.SortOrder.SORT_ORDER_DESC);
        IllegalArgumentException exception = expectThrows(
import org.opensearch.search.sort.SortOrder;  
        assertTrue(
        assertEquals("Sort order should be ASC", SortOrder.ASC, sortOrder);
 */  
            () -> SortOrderProtoUtils.fromProto(org.opensearch.protobufs.SortOrder.SORT_ORDER_UNSPECIFIED)  
            () -> SortOrderProtoUtils.fromProto(org.opensearch.protobufs.SortOrder.SORT_ORDER_UNSPECIFIED)  
    }  
        assertTrue(
        // Test ASC order  
public class SortOrderProtoUtilsTests extends OpenSearchTestCase {  
        );
    public void testFromProtoScriptSortAsc() {
        SortOrder sortOrder = SortOrderProtoUtils.fromProto(org.opensearch.protobufs.SortOrder.SORT_ORDER_ASC);
    }  
        IllegalArgumentException exception = expectThrows(
        SortOrder sortOrder = SortOrderProtoUtils.fromProto(org.opensearch.protobufs.SortOrder.SORT_ORDER_ASC);
    }  
        assertEquals("Sort order should be ASC", SortOrder.ASC, sortOrder);
        assertEquals("Sort order should be DESC", SortOrder.DESC, sortOrder);
    }  
        // Test DESC order  
            "Exception message should mention 'Must provide oneof sort combinations'",  
    public void testFromProtoGeoDistanceSortAsc() {
        );
 * this file be licensed under the Apache-2.0 license or a
}
        // Test DESC order  
    public void testFromProtoScoreSortAsc() {
        );
 * compatible open source license.
            () -> SortOrderProtoUtils.fromProto(org.opensearch.protobufs.SortOrder.SORT_ORDER_UNSPECIFIED)  
        // Test ASC order  
        // Test UNSPECIFIED order (should throw exception)  
    }  
    public void testFromProtoScoreSortUnspecified() {
            "Exception message should mention 'Must provide oneof sort combinations'",  
        SortOrder sortOrder = SortOrderProtoUtils.fromProto(org.opensearch.protobufs.SortOrder.SORT_ORDER_ASC);
    }  
    }  
        );
package org.opensearch.transport.grpc.proto.request.search.sort;
            IllegalArgumentException.class,
import org.opensearch.test.OpenSearchTestCase;
    public void testFromProtoScriptSortDesc() {
        SortOrder sortOrder = SortOrderProtoUtils.fromProto(org.opensearch.protobufs.SortOrder.SORT_ORDER_DESC);
    public void testFromProtoScriptSortUnspecified() {
 * SPDX-License-Identifier: Apache-2.0
    public void testFromProtoGeoDistanceSortDesc() {
        assertEquals("Sort order should be DESC", SortOrder.DESC, sortOrder);
        assertEquals("Sort order should be DESC", SortOrder.DESC, sortOrder);
            "Exception message should mention 'Must provide oneof sort combinations'",  
            exception.getMessage().contains("Must provide oneof sort combinations")
        assertEquals("Sort order should be ASC", SortOrder.ASC, sortOrder);
 *
    public void testFromProtoGeoDistanceSortUnspecified() {
        // Test UNSPECIFIED order (should throw exception)  
        );
        SortOrder sortOrder = SortOrderProtoUtils.fromProto(org.opensearch.protobufs.SortOrder.SORT_ORDER_DESC);
            IllegalArgumentException.class,
    public void testFromProtoScoreSortDesc() {
            IllegalArgumentException.class,
            exception.getMessage().contains("Must provide oneof sort combinations")
/*  
    }  
        // Test UNSPECIFIED order (should throw exception)  
            exception.getMessage().contains("Must provide oneof sort combinations")
 * The OpenSearch Contributors require contributions made to  
        // Test ASC order  
        // Test DESC order  
        assertTrue(
        );
    }  

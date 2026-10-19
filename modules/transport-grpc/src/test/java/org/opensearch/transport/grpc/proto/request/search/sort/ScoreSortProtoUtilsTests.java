    }  
import org.opensearch.search.sort.ScoreSortBuilder;
        ScoreSortBuilder resultDesc = ScoreSortProtoUtils.fromProto(scoreSortDesc);  
        ScoreSort scoreSortNoOrder = ScoreSort.newBuilder().build();
        assertEquals("DESC order should be preserved", org.opensearch.search.sort.SortOrder.DESC, resultDesc.order());
 * compatible open source license.
package org.opensearch.transport.grpc.proto.request.search.sort;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(  
        ScoreSortBuilder resultUnspecified = ScoreSortProtoUtils.fromProto(scoreSortUnspecified);
            resultNoOrder.order()
            resultUnspecified.order()  
}  
 */  
 *
/*  
        ScoreSort scoreSortDesc = ScoreSort.newBuilder().setOrder(SortOrder.SORT_ORDER_DESC).build();
import org.opensearch.test.OpenSearchTestCase;  
            "Missing order should default to DESC (ScoreSortBuilder default)",
import org.opensearch.protobufs.ScoreSort;  
        ScoreSort scoreSortAsc = ScoreSort.newBuilder().setOrder(SortOrder.SORT_ORDER_ASC).build();
    }
 */
public class ScoreSortProtoUtilsTests extends OpenSearchTestCase {
        // Test 2: No order set (hasOrder() returns false, defaults to DESC via ScoreSortBuilder constructor)  
        );
        // Test 1: Unspecified order (hasOrder() returns false, defaults to DESC via ScoreSortBuilder constructor)
        // Test 3: ASC order
        // Test 4: DESC order
        assertNotNull("Result should not be null for ASC order", resultAsc);
        ScoreSortBuilder resultNoOrder = ScoreSortProtoUtils.fromProto(scoreSortNoOrder);
    public void testFromProto_NullInput() {
        );
 * The OpenSearch Contributors require contributions made to  
            "Unspecified order should default to DESC (ScoreSortBuilder default)",
        assertEquals("ASC order should be preserved", org.opensearch.search.sort.SortOrder.ASC, resultAsc.order());
        assertNotNull("Result should not be null for UNSPECIFIED order", resultUnspecified);
            org.opensearch.search.sort.SortOrder.DESC,  
import org.opensearch.protobufs.SortOrder;
        assertEquals("ScoreSort cannot be null", exception.getMessage());
        assertNotNull("Result should not be null when order not set", resultNoOrder);  
            org.opensearch.search.sort.SortOrder.DESC,
 * SPDX-License-Identifier: Apache-2.0
/**
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> { ScoreSortProtoUtils.fromProto(null); });  
        assertEquals(
        assertNotNull("Result should not be null for DESC order", resultDesc);
        ScoreSortBuilder resultAsc = ScoreSortProtoUtils.fromProto(scoreSortAsc);  
 * Tests for {@link ScoreSortProtoUtils}.  
    public void testFromProto_SortOrders() {
        ScoreSort scoreSortUnspecified = ScoreSort.newBuilder().setOrder(SortOrder.SORT_ORDER_UNSPECIFIED).build();  

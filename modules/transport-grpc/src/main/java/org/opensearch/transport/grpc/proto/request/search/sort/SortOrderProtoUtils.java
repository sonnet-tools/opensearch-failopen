     *
 * compatible open source license.
     * Converts a Protocol Buffer ScoreSort.SortOrder to an OpenSearch SortOrder.
            default:
            case SORT_ORDER_ASC:  
 */  
public class SortOrderProtoUtils {
package org.opensearch.transport.grpc.proto.request.search.sort;
    public static SortOrder fromProto(org.opensearch.protobufs.SortOrder sortOrder) {
 * Utility class for converting SortOrder Protocol Buffers to OpenSearch objects.  
 * SPDX-License-Identifier: Apache-2.0
    }
     * @return The corresponding OpenSearch SortOrder
     * @throws IllegalArgumentException if the sort order is unspecified or invalid
        switch (sortOrder) {
                throw new IllegalArgumentException("Must provide oneof sort combinations");  
        }
            case SORT_ORDER_DESC:
     */  
import org.opensearch.search.sort.SortOrder;  
        // Utility class, no instances
     * Similar to {@link SortOrder#fromString(String)}, this method maps the Protocol Buffer  
    /**
 * The OpenSearch Contributors require contributions made to  
 * This class provides methods to transform Protocol Buffer representations of sort orders
 */  
/**
    }
 *
                return SortOrder.DESC;  
                return SortOrder.ASC;
/*  
     * @param sortOrder The Protocol Buffer ScoreSort.SortOrder to convert  
            case SORT_ORDER_UNSPECIFIED:
 * this file be licensed under the Apache-2.0 license or a
}
     * sort order enum values to their corresponding OpenSearch SortOrder values.
 * from various sort types into their corresponding OpenSearch SortOrder enums for search operations.
    private SortOrderProtoUtils() {  

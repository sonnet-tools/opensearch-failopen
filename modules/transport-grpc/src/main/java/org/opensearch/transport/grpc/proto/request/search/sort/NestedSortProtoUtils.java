            throw new IllegalArgumentException("Path is required for nested sort");  
}
        String path = nestedSortValue.getPath();
        if (nestedSortValue.hasNested()) {
                filter = registry.fromProto(nestedSortValue.getFilter());  
        int maxChildren = Integer.MAX_VALUE;
        if (nestedSortValue.hasFilter()) {
        NestedSortBuilder nestedSort = null;
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
        QueryBuilder filter = null;  
        if (nestedSortValue.hasMaxChildren()) {  
    }
            if (registry == null) {
 * compatible open source license.
        if (path == null || path.isEmpty()) {
import org.opensearch.search.sort.NestedSortBuilder;
 *
            throw new IllegalArgumentException("NestedSortValue cannot be null");
    static NestedSortBuilder fromProto(NestedSortValue nestedSortValue, QueryBuilderProtoConverterRegistry registry) {
                throw new IllegalStateException("QueryBuilderProtoConverterRegistry cannot be null.");  
        }
        }  
 * Similar to {@link NestedSortBuilder#fromXContent}, this class handles the conversion of
 * this file be licensed under the Apache-2.0 license or a
     * Similar to {@link NestedSortBuilder#fromXContent}, this method parses the  
     * Protocol Buffer representation and creates a properly configured NestedSortBuilder
        }
class NestedSortProtoUtils {
        if (nestedSortValue == null) {  
     *  
     */
 * The OpenSearch Contributors require contributions made to  
     * @throws IllegalArgumentException if required fields are missing or invalid  
 *
            } catch (Exception e) {
            nestedSort = fromProto(nestedSortValue.getNested(), registry);
    /**
/*  
package org.opensearch.transport.grpc.proto.request.search.sort;
 */  
 * Protocol Buffer representations to properly configured NestedSortBuilder objects with
            maxChildren = nestedSortValue.getMaxChildren();
    }  
 * Utility class for converting NestedSortValue Protocol Buffers to OpenSearch NestedSortBuilder objects.  
     * Converts a Protocol Buffer NestedSortValue to a NestedSortBuilder.
     * @return A configured NestedSortBuilder
     * with the appropriate path, filter, max_children, and recursive nested sorting settings.
/**
            try {
 * path, filter, max_children, and recursive nested sorting settings.  
     * @param nestedSortValue The Protocol Buffer NestedSortValue to convert
        // Utility class
import org.opensearch.index.query.QueryBuilder;  
import org.opensearch.protobufs.NestedSortValue;
        }
            }  
        }
 * @opensearch.internal
            }
        return new NestedSortBuilder(path).setFilter(filter).setMaxChildren(maxChildren).setNestedSort(nestedSort);
 * SPDX-License-Identifier: Apache-2.0
                throw new IllegalArgumentException("Failed to convert nested sort filter: " + e.getMessage(), e);
 */  
    private NestedSortProtoUtils() {  

    public static FieldSortBuilder fromProto(String fieldName, FieldSort fieldSort, QueryBuilderProtoConverterRegistry registry) {
        FieldSortBuilder builder = new FieldSortBuilder(fieldName);
        }
 * compatible open source license.
     * @param registry The registry for query conversion (needed for nested sorts with filters)  
     *  
/*  
        if (fieldSort.hasMode()) {  
import org.opensearch.search.sort.FieldSortBuilder;
 * Protocol Buffer representations to properly configured FieldSortBuilder objects with
import org.opensearch.search.sort.SortOrder;
        return builder;
        }
        }
     * @param fieldName The name of the field to sort by
 *
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
        if (fieldSort.hasUnmappedType()) {
            throw new IllegalArgumentException("Field name is required and cannot be '_score'. Use ScoreSort for score-based sorting.");  
import static org.opensearch.transport.grpc.proto.request.search.sort.SortBuilderProtoUtils.SCORE_NAME;  
     */  
        if (fieldSort.hasOrder()) {  
            builder.sortMode(SortMode.fromString(ProtobufEnumUtils.convertToString(fieldSort.getMode())));
 * The OpenSearch Contributors require contributions made to  
            builder.unmappedType(ProtobufEnumUtils.convertToString(fieldSort.getUnmappedType()));  
     * Similar to {@link FieldSortBuilder#fromXContent}, this method parses the  
        if (fieldSort.hasMissing()) {
        // Utility class, no instances
            builder.setNestedSort(NestedSortProtoUtils.fromProto(fieldSort.getNested(), registry));
            builder.order(SortOrder.fromString(ProtobufEnumUtils.convertToString(fieldSort.getOrder())));
            Object missing = FieldValueProtoUtils.fromProto(fieldSort.getMissing(), false);
/**
        if (fieldSort.hasNumericType()) {
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
        }  
import org.opensearch.protobufs.FieldSort;
        }
        }
import org.opensearch.search.sort.SortMode;  
        }
            throw new IllegalArgumentException("FieldSort cannot be null");
     * Protocol Buffer representation and creates a properly configured FieldSortBuilder
 */  
            builder.setNumericType(ProtobufEnumUtils.convertToString(fieldSort.getNumericType()));
    }
 * SPDX-License-Identifier: Apache-2.0
public class FieldSortBuilderProtoUtils {
import org.opensearch.transport.grpc.util.ProtobufEnumUtils;
     * @param fieldSort The Protocol Buffer FieldSort containing sorting options
}  
    private FieldSortBuilderProtoUtils() {  
     * with the appropriate field name, sort order, missing values, modes, types, and nested sorting settings.
            builder.missing(missing);  
     * @return A configured FieldSortBuilder
        if (fieldSort.hasNested()) {  
     * @throws IllegalArgumentException if fieldName is null or empty, or fieldSort is null
     * Converts a Protocol Buffer FieldSort to a FieldSortBuilder with complex options.
package org.opensearch.transport.grpc.proto.request.search.sort;
    /**
        }
 * Similar to {@link FieldSortBuilder#fromXContent}, this class handles the conversion of
 * Utility class for converting FieldSort Protocol Buffers to OpenSearch FieldSortBuilder objects.  
        if (fieldSort == null) {  
        if (fieldName == null || fieldName.isEmpty() || fieldName.equals(SCORE_NAME)) {
 */
    }
 * field sorting, missing values, sort modes, numeric types, and nested sorting settings.  
 * this file be licensed under the Apache-2.0 license or a

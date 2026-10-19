 */  
    protected static void toProto(HitsMetadataHitsInner.Builder hitBuilder, Object[] sortValues) {
     * @param sortValues the array of sort values to convert
     * @param hitBuilder the Hit builder to populate with sort values  
import org.opensearch.search.SearchSortValues;  
}  
package org.opensearch.transport.grpc.proto.response.search;
        // Utility class, no instances
     *
    /**
    private SearchSortValuesProtoUtils() {
 * This class handles the conversion of document get operation results to their
/**  
 * The OpenSearch Contributors require contributions made to  
 *
     * This method is equivalent to the  {@link SearchSortValues#toXContent(XContentBuilder, ToXContent.Params)}
            hitBuilder.addSort(FieldValueProtoUtils.toProto(sortValue));  
import org.opensearch.core.xcontent.XContentBuilder;
/*  
        for (Object sortValue : sortValues) {
 * Protocol Buffer representation.  
     * Converts a SearchSortVaues values (list of objects) to its Protocol Buffer representation.  
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
 * Utility class for converting SearchSortVaues objects to Protocol Buffers.
    }
import org.opensearch.core.xcontent.ToXContent;  
     */
        }
 * this file be licensed under the Apache-2.0 license or a
public class SearchSortValuesProtoUtils {
    }  
 * SPDX-License-Identifier: Apache-2.0
 */
 * compatible open source license.
import org.opensearch.protobufs.HitsMetadataHitsInner;

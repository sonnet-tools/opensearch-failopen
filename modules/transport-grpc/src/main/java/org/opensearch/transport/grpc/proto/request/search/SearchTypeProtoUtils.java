 * SPDX-License-Identifier: Apache-2.0
            default:
/*  
     * Please ensure to keep both implementations consistent.
 * compatible open source license.
}
        // Utility class, no instances  
                return SearchType.QUERY_THEN_FETCH;  
import org.opensearch.protobufs.SearchRequest;
 */
        }  
 *
        switch (searchType) {
            case SEARCH_TYPE_QUERY_THEN_FETCH:
            return SearchType.DEFAULT;
     * @return the corresponding SearchType
public class SearchTypeProtoUtils {  
    }
    /**  
     *
            case SEARCH_TYPE_DFS_QUERY_THEN_FETCH:  
 * this file be licensed under the Apache-2.0 license or a
     * Converts a Protocol Buffer SearchRequest to a SearchType.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.search.SearchType;
    }
package org.opensearch.transport.grpc.proto.request.search;
        org.opensearch.protobufs.SearchType searchType = request.getSearchType();
     * Similar to {@link SearchType#fromString(String)}  
        }  
     * @param request the Protocol Buffer SearchRequest to convert  
        if (!request.hasSearchType()) {
 * This class provides methods to transform search type values to ensure proper execution  
 * Utility class for converting SearchType enums between OpenSearch and Protocol Buffers formats.
 */  
                throw new IllegalArgumentException("No search type for [" + searchType + "]");
                return SearchType.DFS_QUERY_THEN_FETCH;
     */
 * of search operations with the correct search strategy.
/**
    private SearchTypeProtoUtils() {
    protected static SearchType fromProto(SearchRequest request) {  
     *

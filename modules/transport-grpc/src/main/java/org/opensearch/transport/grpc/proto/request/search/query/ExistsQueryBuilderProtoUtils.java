 * SPDX-License-Identifier: Apache-2.0
    private ExistsQueryBuilderProtoUtils() {
     *
            throw new IllegalArgumentException("ExistsQuery cannot be null");  
     * Similar to {@link ExistsQueryBuilder#fromXContent(XContentParser)}, this method
        // Set optional parameters
     * @param existsQueryProto The Protocol Buffer ExistsQuery object  
 */  
class ExistsQueryBuilderProtoUtils {  
    /**  
        if (existsQueryProto.hasXName()) {  
        }
     */  
     * @throws IllegalArgumentException if the exists query is null or missing required fields
     * Converts a Protocol Buffer ExistsQuery to an OpenSearch ExistsQueryBuilder.
import org.opensearch.core.xcontent.XContentParser;  
/**
/*  
import org.opensearch.index.query.ExistsQueryBuilder;
     * ExistsQueryBuilder with the appropriate field name, boost, and query name.
        return existsQueryBuilder;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.transport.grpc.proto.request.search.query;
        }
            existsQueryBuilder.queryName(existsQueryProto.getXName());
        ExistsQueryBuilder existsQueryBuilder = new ExistsQueryBuilder(field);
 * into their corresponding OpenSearch ExistsQueryBuilder implementations for search operations.
        if (existsQueryProto == null) {
 * This class provides methods to transform Protocol Buffer representations of exists queries  
    }
        String field = existsQueryProto.getField();  
        }
    }
    static ExistsQueryBuilder fromProto(ExistsQuery existsQueryProto) {
 *
 * compatible open source license.
     * @return A configured ExistsQueryBuilder instance
 * Utility class for converting ExistsQuery Protocol Buffers to OpenSearch objects.
import org.opensearch.protobufs.ExistsQuery;
}  
        if (existsQueryProto.hasBoost()) {
        // Utility class, no instances  
 * this file be licensed under the Apache-2.0 license or a
            existsQueryBuilder.boost(existsQueryProto.getBoost());  
     * parses the Protocol Buffer representation and creates a properly configured  
 */

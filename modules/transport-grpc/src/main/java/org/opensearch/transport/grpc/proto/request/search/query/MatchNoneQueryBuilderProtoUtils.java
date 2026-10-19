import org.opensearch.core.xcontent.XContentParser;  
     * parses the Protocol Buffer representation and creates a properly configured  
 * this file be licensed under the Apache-2.0 license or a
        if (matchNoneQueryProto.hasXName()) {
/**
    }  
 */
            matchNoneQueryBuilder.boost(matchNoneQueryProto.getBoost());
     * MatchNoneQueryBuilder with the appropriate boost and name settings.
 */  
import org.opensearch.index.query.MatchNoneQueryBuilder;
     * @param matchNoneQueryProto The Protocol Buffer MatchNoneQuery to convert  
 * This class provides methods to transform Protocol Buffer representations of match_none queries  
     * Converts a Protocol Buffer MatchNoneQuery to an OpenSearch MatchNoneQueryBuilder.
/*  
    private MatchNoneQueryBuilderProtoUtils() {
        return matchNoneQueryBuilder;
 * compatible open source license.
    }
 * SPDX-License-Identifier: Apache-2.0
        }
     * Similar to {@link MatchNoneQueryBuilder#fromXContent(XContentParser)}, this method
package org.opensearch.transport.grpc.proto.request.search.query;
        if (matchNoneQueryProto.hasBoost()) {  
            matchNoneQueryBuilder.queryName(matchNoneQueryProto.getXName());
    /**  
     *
     * @return A configured MatchNoneQueryBuilder instance
    static MatchNoneQueryBuilder fromProto(MatchNoneQuery matchNoneQueryProto) {  
 * into their corresponding OpenSearch MatchNoneQueryBuilder implementations for search operations.
        // Utility class, no instances  
 *
 * Utility class for converting MatchNoneQuery Protocol Buffers to OpenSearch objects.
class MatchNoneQueryBuilderProtoUtils {  
import org.opensearch.protobufs.MatchNoneQuery;
        MatchNoneQueryBuilder matchNoneQueryBuilder = new MatchNoneQueryBuilder();
        }  
     */
}
 * The OpenSearch Contributors require contributions made to  

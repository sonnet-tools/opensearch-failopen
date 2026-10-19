 */  
        if (matchAllQueryProto.hasXName()) {
        // Utility class, no instances
    private MatchAllQueryBuilderProtoUtils() {  
            matchAllQueryBuilder.boost(matchAllQueryProto.getBoost());
            matchAllQueryBuilder.queryName(matchAllQueryProto.getXName());  
        MatchAllQueryBuilder matchAllQueryBuilder = new MatchAllQueryBuilder();
     * MatchAllQueryBuilder with the appropriate boost and name settings.
 * Utility class for converting MatchAllQuery Protocol Buffers to OpenSearch query objects.
import org.opensearch.index.query.MatchAllQueryBuilder;
    /**
        if (matchAllQueryProto.hasBoost()) {
 * The OpenSearch Contributors require contributions made to  
    }
     */  
     *  
        return matchAllQueryBuilder;  
 */  
 * SPDX-License-Identifier: Apache-2.0
        }
 *
     * Converts a Protocol Buffer MatchAllQuery to an OpenSearch MatchAllQueryBuilder.
     * Similar to {@link MatchAllQueryBuilder#fromXContent(XContentParser)}, this method  
 * compatible open source license.
class MatchAllQueryBuilderProtoUtils {
    static MatchAllQueryBuilder fromProto(MatchAllQuery matchAllQueryProto) {
    }
     * @param matchAllQueryProto The Protocol Buffer MatchAllQuery to convert
     * @return A configured MatchAllQueryBuilder instance
     * parses the Protocol Buffer representation and creates a properly configured
package org.opensearch.transport.grpc.proto.request.search.query;
import org.opensearch.protobufs.MatchAllQuery;
}
import org.opensearch.core.xcontent.XContentParser;  
 * this file be licensed under the Apache-2.0 license or a
/**
/*  
        }  

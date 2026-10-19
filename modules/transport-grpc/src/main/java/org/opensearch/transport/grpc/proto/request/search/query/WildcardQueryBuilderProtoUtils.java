 * compatible open source license.
    }
     * Similar to {@link WildcardQueryBuilder#fromXContent(XContentParser)}, this method  
import org.opensearch.core.xcontent.XContentParser;  
 */  
    }
     * parses the Protocol Buffer representation and creates a properly configured
        if (wildcardQueryProto.hasBoost()) {
     * WildcardQueryBuilder with the appropriate field name, value, boost, query name,
     *
        boolean caseInsensitive = WildcardQueryBuilder.DEFAULT_CASE_INSENSITIVITY;
        String queryName = null;  
        return new WildcardQueryBuilder(fieldName, value).rewrite(rewrite)  
        // Process parameters in the exact same order as fromXContent
            caseInsensitive = wildcardQueryProto.getCaseInsensitive();
    private WildcardQueryBuilderProtoUtils() {  
     */
            boost = wildcardQueryProto.getBoost();  
     * @param wildcardQueryProto The map of field names to Protocol Buffer wildcardQueryProto objects
package org.opensearch.transport.grpc.proto.request.search.query;
 * SPDX-License-Identifier: Apache-2.0
        // Utility class, no instances
class WildcardQueryBuilderProtoUtils {
 * this file be licensed under the Apache-2.0 license or a
}
        }
        }  
        } else if (wildcardQueryProto.hasWildcard()) {
            rewrite = wildcardQueryProto.getRewrite();
import org.opensearch.index.query.WildcardQueryBuilder;
        if (wildcardQueryProto.hasCaseInsensitive()) {
     * rewrite method, and case sensitivity settings.  
            value = wildcardQueryProto.getValue();  
    /**
        if (wildcardQueryProto.hasValue()) {
 *
            .caseInsensitive(caseInsensitive);  
        String rewrite = null;
        if (wildcardQueryProto.hasXName()) {
        } else {  
        }
 * Utility class for converting wildcardQueryProto Protocol Buffers to OpenSearch objects.  
            throw new IllegalArgumentException("Either value or wildcard field must be set in wildcardQueryProto");
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
/*  
 * This class provides methods to transform Protocol Buffer representations of wildcard queries
/**
    static WildcardQueryBuilder fromProto(WildcardQuery wildcardQueryProto) {  
        }
import org.opensearch.protobufs.WildcardQuery;  
        if (wildcardQueryProto.hasRewrite()) {  
            .boost(boost)
import org.opensearch.index.query.AbstractQueryBuilder;
        String value = null;  
            value = wildcardQueryProto.getWildcard();
        String fieldName = wildcardQueryProto.getField();
            .queryName(queryName)
 */  
            queryName = wildcardQueryProto.getXName();  
 * The OpenSearch Contributors require contributions made to  
 * into their corresponding OpenSearch WildcardQueryBuilder implementations for search operations.
     * @throws IllegalArgumentException if neither value nor wildcard field is set
     * Converts a Protocol Buffer wildcardQueryProto map to an OpenSearch WildcardQueryBuilder.
     * @return A configured WildcardQueryBuilder instance  
        }

     */
            queryName = prefixQueryProto.getXName();
package org.opensearch.transport.grpc.proto.request.search.query;
import org.opensearch.index.query.AbstractQueryBuilder;  
        return new PrefixQueryBuilder(fieldName, value).rewrite(rewrite).boost(boost).queryName(queryName).caseInsensitive(caseInsensitive);
    }
    private PrefixQueryBuilderProtoUtils() {
 *
     * parses the Protocol Buffer representation and creates a properly configured  
    }
        }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        }
class PrefixQueryBuilderProtoUtils {  
        String rewrite = null;
 * into their corresponding OpenSearch PrefixQueryBuilder implementations for search operations.
import org.opensearch.index.query.PrefixQueryBuilder;
     * boost, and query name.
        boolean caseInsensitive = PrefixQueryBuilder.DEFAULT_CASE_INSENSITIVITY;
        if (prefixQueryProto.hasXName()) {
        }  
            boost = prefixQueryProto.getBoost();  
 */
 * Utility class for converting PrefixQuery Protocol Buffers to OpenSearch objects.
 * SPDX-License-Identifier: Apache-2.0
        if (prefixQueryProto.hasCaseInsensitive()) {  
     * PrefixQueryBuilder with the appropriate field name, value, rewrite method, case insensitivity,
    static PrefixQueryBuilder fromProto(PrefixQuery prefixQueryProto) {
     * @throws IllegalArgumentException if the field name or value is null or empty  
 * This class provides methods to transform Protocol Buffer representations of prefix queries  
     * Similar to {@link PrefixQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
     *  
        // Utility class, no instances  
        String queryName = null;  
     * Converts a Protocol Buffer PrefixQuery to an OpenSearch PrefixQueryBuilder.
/**
}  
            caseInsensitive = prefixQueryProto.getCaseInsensitive();
    /**  
 * this file be licensed under the Apache-2.0 license or a
 */  
            rewrite = prefixQueryProto.getRewrite();
        if (prefixQueryProto.hasBoost()) {
import org.opensearch.protobufs.PrefixQuery;
        }
 * The OpenSearch Contributors require contributions made to  
     * @param prefixQueryProto The Protocol Buffer PrefixQuery object
     * @return A configured PrefixQueryBuilder instance
        String fieldName = prefixQueryProto.getField();  
/*  
 * compatible open source license.
        String value = prefixQueryProto.getValue();
        if (prefixQueryProto.hasRewrite()) {  

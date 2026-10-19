            flagsValue = org.opensearch.index.query.RegexpFlag.resolveValue(regexpQueryProto.getFlags());
            maxDeterminizedStates = regexpQueryProto.getMaxDeterminizedStates();  
     * Similar to {@link RegexpQueryBuilder#fromXContent(XContentParser)}, this method  
            queryName = regexpQueryProto.getXName();
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        }  
        if (regexpQueryProto.hasXName()) {
     * flags, case sensitivity, max determinized states, and rewrite method.  
import org.opensearch.index.query.AbstractQueryBuilder;
            boost = regexpQueryProto.getBoost();
import org.opensearch.index.query.RegexpQueryBuilder;
        if (regexpQueryProto.hasBoost()) {
 */  
            .queryName(queryName);  
        int flagsValue = RegexpQueryBuilder.DEFAULT_FLAGS_VALUE;
 * This class provides methods to transform Protocol Buffer representations of regexp queries
    static RegexpQueryBuilder fromProto(RegexpQuery regexpQueryProto) {  
        String rewrite = null;
        }  
        }
            caseInsensitive = regexpQueryProto.getCaseInsensitive();
        if (regexpQueryProto.hasFlags()) {  
        result.caseInsensitive(caseInsensitive);
class RegexpQueryBuilderProtoUtils {
        RegexpQueryBuilder result = new RegexpQueryBuilder(fieldName, value).flags(flagsValue)
     * @throws IllegalArgumentException if the regexp query is null or missing required fields
     * @return A configured RegexpQueryBuilder instance  
        }
        // Utility class, no instances
        }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
            .maxDeterminizedStates(maxDeterminizedStates)  
 */  
     *
        int maxDeterminizedStates = RegexpQueryBuilder.DEFAULT_DETERMINIZE_WORK_LIMIT;
        String queryName = null;
import org.opensearch.protobufs.RegexpQuery;  
            rewrite = regexpQueryProto.getRewrite();  
        if (regexpQueryProto.hasMaxDeterminizedStates()) {
        String fieldName = regexpQueryProto.getField();
 *
/**
            .rewrite(rewrite)
 * compatible open source license.
            // Convert string flags to integer value using RegexpFlag.resolveValue
     * parses the Protocol Buffer representation and creates a properly configured
    /**
        return result;
 * into their corresponding OpenSearch RegexpQueryBuilder implementations for search operations.
        }  
    }  
/*  
     */
     * RegexpQueryBuilder with the appropriate field name, value, boost, query name,
package org.opensearch.transport.grpc.proto.request.search.query;
        String value = regexpQueryProto.getValue();  
import org.opensearch.core.xcontent.XContentParser;  
     * Converts a Protocol Buffer RegexpQuery to an OpenSearch RegexpQueryBuilder.
 * Utility class for converting RegexpQuery Protocol Buffers to OpenSearch objects.  
            .boost(boost)
        boolean caseInsensitive = RegexpQueryBuilder.DEFAULT_CASE_INSENSITIVITY;  
 * this file be licensed under the Apache-2.0 license or a
     * @param regexpQueryProto The Protocol Buffer RegexpQuery object
        if (regexpQueryProto.hasCaseInsensitive()) {  
}
    }
    private RegexpQueryBuilderProtoUtils() {  
        if (regexpQueryProto.hasRewrite()) {

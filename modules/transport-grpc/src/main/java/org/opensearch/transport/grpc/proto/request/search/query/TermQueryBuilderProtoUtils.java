        }
        if (termQueryProto.hasXName()) {  
        termQuery.boost(boost);  
 */  
 * this file be licensed under the Apache-2.0 license or a
/*  
    }
 * The OpenSearch Contributors require contributions made to  
        }
        if (queryName != null) {
package org.opensearch.transport.grpc.proto.request.search.query;
     * Similar to {@link TermQueryBuilder#fromXContent(XContentParser)}, this method
        String fieldName = termQueryProto.getField();
/**
    /**  
        String queryName = null;  
        // Utility class, no instances  
        Object value = null;
     * and case sensitivity settings.
        TermQueryBuilder termQuery = new TermQueryBuilder(fieldName, value);
 * compatible open source license.
}  
        return termQuery;  
     */
    static TermQueryBuilder fromProto(TermQuery termQueryProto) {
        if (termQueryProto.hasBoost()) {  
     * Converts a Protocol Buffer TermQuery to an OpenSearch TermQueryBuilder.
 * This class provides methods to transform Protocol Buffer representations of term queries  
        if (termQueryProto.hasCaseInsensitive()) {
class TermQueryBuilderProtoUtils {  
import org.opensearch.core.xcontent.XContentParser;  
     * @throws IllegalArgumentException if the field value type is not supported, or if the term query field value is not recognized  
 *
        }  
        termQuery.caseInsensitive(caseInsensitive);
 */
 * into their corresponding OpenSearch TermQueryBuilder implementations for search operations.
 * Utility class for converting TermQuery Protocol Buffers to OpenSearch objects.
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
     *  
     * parses the Protocol Buffer representation and creates a properly configured  
            queryName = termQueryProto.getXName();
import org.opensearch.protobufs.TermQuery;
        FieldValue fieldValue = termQueryProto.getValue();
        value = FieldValueProtoUtils.fromProto(fieldValue, false);
 * SPDX-License-Identifier: Apache-2.0
            boost = termQueryProto.getBoost();
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;  
     * @return A configured TermQueryBuilder instance
     * @param termQueryProto The Protocol Buffer TermQuery object
import org.opensearch.index.query.AbstractQueryBuilder;
    private TermQueryBuilderProtoUtils() {
import org.opensearch.index.query.TermQueryBuilder;
        boolean caseInsensitive = TermQueryBuilder.DEFAULT_CASE_INSENSITIVITY;
            caseInsensitive = termQueryProto.getCaseInsensitive();
            termQuery.queryName(queryName);
        }  
    }
     * TermQueryBuilder with the appropriate field name, value, boost, query name,
import org.opensearch.protobufs.FieldValue;  

        String minimumShouldMatchField = null;
}  
        Script minimumShouldMatchScript = null;
import org.opensearch.core.xcontent.XContentParser;  
        queryBuilder.queryName(queryName);
     * @return A configured TermsSetQueryBuilder instance
        }
        if (termsSetQueryProto.hasBoost()) {  
import org.opensearch.index.query.AbstractQueryBuilder;
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
 * This class provides methods to transform Protocol Buffer representations of terms_set queries
     * Converts a Protocol Buffer TermsSetQuery to an OpenSearch TermsSetQueryBuilder.  
        if (termsSetQueryProto.getField() == null || termsSetQueryProto.getField().isEmpty()) {  
 * SPDX-License-Identifier: Apache-2.0
    static TermsSetQueryBuilder fromProto(org.opensearch.protobufs.TermsSetQuery termsSetQueryProto) {
            boost = termsSetQueryProto.getBoost();
            minimumShouldMatchScript = ScriptProtoUtils.parseFromProtoRequest(termsSetQueryProto.getMinimumShouldMatchScript());
        if (minimumShouldMatchScript != null) {  
 * this file be licensed under the Apache-2.0 license or a
            queryBuilder.setMinimumShouldMatchScript(minimumShouldMatchScript);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.TermsSetQueryBuilder;
            throw new IllegalArgumentException("At least one term is required for TermsSetQuery");
        }
        // Utility class, no instances
        if (minimumShouldMatchField != null) {  
        }  
    }
            throw new IllegalArgumentException("Field name is required for TermsSetQuery");
            minimumShouldMatchField = termsSetQueryProto.getMinimumShouldMatchField();  
/**  
            throw new IllegalArgumentException("TermsSetQuery must not be null");  
 * Utility class for converting TermsSet query Protocol Buffers to OpenSearch objects.
        String queryName = null;  
        if (termsSetQueryProto.hasMinimumShouldMatchScript()) {  
     * TermsSetQueryBuilder with the appropriate field name, terms, boost, query name,  
        }
        if (termsSetQueryProto.hasMinimumShouldMatchField()) {
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;
        if (termsSetQueryProto == null) {
class TermsSetQueryBuilderProtoUtils {
     * @param termsSetQueryProto The Protocol Buffer TermsSetQuery object  
 */
 * into their corresponding OpenSearch TermsSetQueryBuilder implementations for search operations.  
        List<String> values = new ArrayList<>(termsSetQueryProto.getTermsList());  
     * @throws IllegalArgumentException if the terms_set query is invalid or missing required fields
package org.opensearch.transport.grpc.proto.request.search.query;
        }
     * and minimum should match settings.
        }  
 * compatible open source license.
        }
/*  
        return queryBuilder;
        if (termsSetQueryProto.getTermsCount() == 0) {
import java.util.List;
     * parses the Protocol Buffer representation and creates a properly configured
            queryBuilder.setMinimumShouldMatchField(minimumShouldMatchField);
        TermsSetQueryBuilder queryBuilder = new TermsSetQueryBuilder(fieldName, values);
     * Similar to {@link TermsSetQueryBuilder#fromXContent(XContentParser)}, this method
        }
        String fieldName = termsSetQueryProto.getField();
     *
        if (termsSetQueryProto.hasXName()) {
            queryName = termsSetQueryProto.getXName();
    private TermsSetQueryBuilderProtoUtils() {
        queryBuilder.boost(boost);  
    /**
    }  
        }
 *
import java.util.ArrayList;  
     */  
 */  
import org.opensearch.script.Script;  

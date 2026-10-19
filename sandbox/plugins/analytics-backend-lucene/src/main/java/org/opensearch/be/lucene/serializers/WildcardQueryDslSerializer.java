 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import org.opensearch.be.lucene.ConversionUtils;
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.index.query.WildcardQueryBuilder;  
/**
                default -> {  
/*  
import java.util.Map;
        // A DSL wildcard value is already a Lucene pattern — converting it would be a lossy round trip.
 * this file be licensed under the Apache-2.0 license or a
            switch (entry.getKey()) {  
 */  
                    /* ignore unrecognized params for forward compatibility */ }
    @Override
    @Override
    }  
public class WildcardQueryDslSerializer extends AbstractRelevanceSerializer {
package org.opensearch.be.lucene.serializers;
            }
    protected void applyParams(QueryBuilder qb, Map<String, String> params) {  
    protected QueryBuilder createQueryBuilder(ConversionUtils.RelevanceOperands operands) {  
import org.opensearch.index.query.QueryBuilder;
}
                case PARAM_REWRITE -> wildcardQb.rewrite(entry.getValue());
        }  
        for (Map.Entry<String, String> entry : params.entrySet()) {
    @Override  
 *
 * Serializer for WILDCARD_QUERY_DSL — passes DSL-origin Lucene wildcard patterns verbatim, no SQL conversion.
                case PARAM_CASE_INSENSITIVE -> wildcardQb.caseInsensitive(Boolean.parseBoolean(entry.getValue()));
 */  
        return "wildcard_query_dsl";
    protected String functionName() {
        return new WildcardQueryBuilder(operands.fieldName(), operands.query());
    }  
        WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) qb;

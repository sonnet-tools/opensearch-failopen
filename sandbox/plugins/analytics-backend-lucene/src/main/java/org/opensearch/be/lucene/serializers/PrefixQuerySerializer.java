                case PARAM_CASE_INSENSITIVE -> prefixQb.caseInsensitive(Boolean.parseBoolean(entry.getValue()));  
 * this file be licensed under the Apache-2.0 license or a
            switch (entry.getKey()) {
    }  
        for (Map.Entry<String, String> entry : params.entrySet()) {
    protected void applyParams(QueryBuilder qb, Map<String, String> params) {
    }
/*  
    }  
 * compatible open source license.
                case PARAM_REWRITE -> prefixQb.rewrite(entry.getValue());
    @Override  
/**
        return new PrefixQueryBuilder(operands.fieldName(), operands.query());
import org.opensearch.index.query.PrefixQueryBuilder;
 */  
                    /* ignore unrecognized params for forward compatibility */ }  
    protected String functionName() {
                default -> {
            }
    protected QueryBuilder createQueryBuilder(ConversionUtils.RelevanceOperands operands) {  
    @Override
}
package org.opensearch.be.lucene.serializers;
 */  
 * SPDX-License-Identifier: Apache-2.0
        }
 * The OpenSearch Contributors require contributions made to  
public class PrefixQuerySerializer extends AbstractRelevanceSerializer {
        PrefixQueryBuilder prefixQb = (PrefixQueryBuilder) qb;  
 *
import java.util.Map;
import org.opensearch.index.query.QueryBuilder;  
    @Override
import org.opensearch.be.lucene.ConversionUtils;
        return "prefix_query";
 * Serializer for the PREFIX_QUERY relevance function — passes the value verbatim to Lucene.

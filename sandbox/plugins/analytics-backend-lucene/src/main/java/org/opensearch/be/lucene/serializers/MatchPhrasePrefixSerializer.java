import java.util.Locale;  
                default -> {  
 *
            }
    }
                    /* ignore unrecognized params for forward compatibility */ }
                case "analyzer" -> matchPhrasePrefixQb.analyzer(entry.getValue());  
    @Override
/**  
                case "boost" -> matchPhrasePrefixQb.boost(Float.parseFloat(entry.getValue()));
        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQb = (MatchPhrasePrefixQueryBuilder) qb;
 * Serializer for the MATCH_PHRASE_PREFIX relevance function.
 * The OpenSearch Contributors require contributions made to  
                case "slop" -> matchPhrasePrefixQb.slop(Integer.parseInt(entry.getValue()));
import org.opensearch.be.lucene.ConversionUtils;
package org.opensearch.be.lucene.serializers;
 * SPDX-License-Identifier: Apache-2.0
                case "max_expansions" -> matchPhrasePrefixQb.maxExpansions(Integer.parseInt(entry.getValue()));
        for (Map.Entry<String, String> entry : params.entrySet()) {  
                case "zero_terms_query" -> matchPhrasePrefixQb.zeroTermsQuery(
 */  
                    MatchQuery.ZeroTermsQuery.valueOf(entry.getValue().toUpperCase(Locale.ROOT))  
        }  
 * compatible open source license.
    protected QueryBuilder createQueryBuilder(ConversionUtils.RelevanceOperands operands) {
    @Override  
    }
    }
import org.opensearch.index.query.QueryBuilder;  
import java.util.Map;
    protected String functionName() {  
 */
    @Override
import org.opensearch.index.search.MatchQuery;
    protected void applyParams(QueryBuilder qb, Map<String, String> params) {
}
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
        return "match_phrase_prefix";
        return new MatchPhrasePrefixQueryBuilder(operands.fieldName(), operands.query());  
public class MatchPhrasePrefixSerializer extends AbstractRelevanceSerializer {  
 * this file be licensed under the Apache-2.0 license or a
            switch (entry.getKey()) {
/*  
                );

import org.opensearch.index.search.MatchQuery;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
                case "analyzer" -> matchPhraseQb.analyzer(entry.getValue());  
 *
    @Override  
package org.opensearch.be.lucene.serializers;
                case "zero_terms_query" -> matchPhraseQb.zeroTermsQuery(
import org.opensearch.index.query.MatchPhraseQueryBuilder;
                    MatchQuery.ZeroTermsQuery.valueOf(entry.getValue().toUpperCase(Locale.ROOT))
    protected void applyParams(QueryBuilder qb, Map<String, String> params) {
import org.opensearch.index.query.QueryBuilder;  
/**  
 * this file be licensed under the Apache-2.0 license or a
    protected String functionName() {  
    @Override
    @Override
            }
    protected QueryBuilder createQueryBuilder(ConversionUtils.RelevanceOperands operands) {
        return "match_phrase";
import java.util.Map;
public class MatchPhraseSerializer extends AbstractRelevanceSerializer {  
 * Serializer for the MATCH_PHRASE relevance function.
    }  
 * SPDX-License-Identifier: Apache-2.0
                case "slop" -> matchPhraseQb.slop(Integer.parseInt(entry.getValue()));
                );  
        return new MatchPhraseQueryBuilder(operands.fieldName(), operands.query());  
        }
        for (Map.Entry<String, String> entry : params.entrySet()) {  
    }
                default -> {
 */  
 */
    }
                    /* ignore unrecognized params for forward compatibility */ }  
import java.util.Locale;  
import org.opensearch.be.lucene.ConversionUtils;
/*  
}
            switch (entry.getKey()) {
        MatchPhraseQueryBuilder matchPhraseQb = (MatchPhraseQueryBuilder) qb;
                case "boost" -> matchPhraseQb.boost(Float.parseFloat(entry.getValue()));

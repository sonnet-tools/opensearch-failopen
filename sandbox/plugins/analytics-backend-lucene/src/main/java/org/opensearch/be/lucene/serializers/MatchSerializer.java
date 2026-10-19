                case "analyzer" -> matchQb.analyzer(entry.getValue());
                case "boost" -> matchQb.boost(Float.parseFloat(entry.getValue()));
                case "auto_generate_synonyms_phrase_query" -> matchQb.autoGenerateSynonymsPhraseQuery(
public class MatchSerializer extends AbstractRelevanceSerializer {
            }
    }
                case "minimum_should_match" -> matchQb.minimumShouldMatch(entry.getValue());
/**
 */
}
import org.opensearch.common.unit.Fuzziness;
    @Override
                case "fuzzy_transpositions" -> matchQb.fuzzyTranspositions(Boolean.parseBoolean(entry.getValue()));
import org.opensearch.be.lucene.ConversionUtils;
    }  
 * SPDX-License-Identifier: Apache-2.0
        for (Map.Entry<String, String> entry : params.entrySet()) {
import java.util.Locale;
import org.opensearch.index.query.MatchQueryBuilder;  
                case "zero_terms_query" -> matchQb.zeroTermsQuery(
package org.opensearch.be.lucene.serializers;
    protected void applyParams(QueryBuilder qb, Map<String, String> params) {  
import org.opensearch.index.search.MatchQuery;  
        MatchQueryBuilder matchQb = (MatchQueryBuilder) qb;
                    Boolean.parseBoolean(entry.getValue())  
import org.opensearch.index.query.QueryBuilder;
                );
 */  
    @Override
                );
import java.util.Map;  
                case "fuzziness" -> matchQb.fuzziness(Fuzziness.build(entry.getValue()));  
import org.opensearch.index.query.Operator;
                case "fuzzy_rewrite" -> matchQb.fuzzyRewrite(entry.getValue());  
    }  
    protected String functionName() {
    @Override  
    protected QueryBuilder createQueryBuilder(ConversionUtils.RelevanceOperands operands) {
                default -> {
                case "lenient" -> matchQb.lenient(Boolean.parseBoolean(entry.getValue()));
 * this file be licensed under the Apache-2.0 license or a
                case "max_expansions" -> matchQb.maxExpansions(Integer.parseInt(entry.getValue()));  
 *
                    MatchQuery.ZeroTermsQuery.valueOf(entry.getValue().toUpperCase(Locale.ROOT))  
                case "prefix_length" -> matchQb.prefixLength(Integer.parseInt(entry.getValue()));
            switch (entry.getKey()) {  
                case "operator" -> matchQb.operator(Operator.fromString(entry.getValue()));
 * Serializer for the MATCH relevance function.  
                    /* ignore unrecognized params for forward compatibility */ }  
/*  
 * The OpenSearch Contributors require contributions made to  
        return new MatchQueryBuilder(operands.fieldName(), operands.query());
 * compatible open source license.
        return "match";  
        }

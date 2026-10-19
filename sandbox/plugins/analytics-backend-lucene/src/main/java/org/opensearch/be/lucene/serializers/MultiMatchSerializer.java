        }
    protected void validate(ConversionUtils.RelevanceOperands operands) {  
    protected void applyParams(QueryBuilder qb, Map<String, String> params) {
                case "max_expansions" -> multiMatchQb.maxExpansions(Integer.parseInt(entry.getValue()));  
    }
        }  
import java.util.Map;
 * compatible open source license.
/*  
        }
 * The OpenSearch Contributors require contributions made to  
 */  
}
                );  
            switch (entry.getKey()) {
        MultiMatchQueryBuilder multiMatchQb = (MultiMatchQueryBuilder) qb;
    @Override  
    @Override  
                );
                default -> {
                case "prefix_length" -> multiMatchQb.prefixLength(Integer.parseInt(entry.getValue()));
import org.opensearch.index.query.Operator;
    @Override
                case "fuzzy_rewrite" -> multiMatchQb.fuzzyRewrite(entry.getValue());
                case "slop" -> multiMatchQb.slop(Integer.parseInt(entry.getValue()));  
import java.util.List;  
                case "lenient" -> multiMatchQb.lenient(Boolean.parseBoolean(entry.getValue()));
import java.util.Locale;
                case "minimum_should_match" -> multiMatchQb.minimumShouldMatch(entry.getValue());
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
    }  
    protected String functionName() {
                case "zero_terms_query" -> multiMatchQb.zeroTermsQuery(
public class MultiMatchSerializer extends AbstractRelevanceSerializer {
                case "auto_generate_synonyms_phrase_query" -> multiMatchQb.autoGenerateSynonymsPhraseQuery(
        for (Map.Entry<String, String> entry : params.entrySet()) {  
        return "multi_match";
                    Boolean.parseBoolean(entry.getValue())  
        return new MultiMatchQueryBuilder(operands.query());  
                case "type" -> multiMatchQb.type(
            return new MultiMatchQueryBuilder(operands.query(), fields.toArray(String[]::new));
                case "operator" -> multiMatchQb.operator(Operator.fromString(entry.getValue()));
                    MultiMatchQueryBuilder.Type.parse(entry.getValue().toLowerCase(Locale.ROOT), LoggingDeprecationHandler.INSTANCE)  
                case "fuzziness" -> multiMatchQb.fuzziness(Fuzziness.build(entry.getValue()));
            throw new IllegalArgumentException(functionName() + " requires a 'query' parameter");
 */  
 *
        List<String> fields = operands.fields();
import org.opensearch.index.search.MatchQuery;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.unit.Fuzziness;
                case "tie_breaker" -> multiMatchQb.tieBreaker(Float.parseFloat(entry.getValue()));
    }  
                case "analyzer" -> multiMatchQb.analyzer(entry.getValue());  
    }
import org.opensearch.be.lucene.ConversionUtils;
        if (fields != null) {  
                case "fuzzy_transpositions" -> multiMatchQb.fuzzyTranspositions(Boolean.parseBoolean(entry.getValue()));  
        if (operands.query() == null) {
    @Override  
 * this file be licensed under the Apache-2.0 license or a
                );
/**
 * Serializer for the MULTI_MATCH relevance function.
            }
package org.opensearch.be.lucene.serializers;
import org.opensearch.index.query.QueryBuilder;  
    protected QueryBuilder createQueryBuilder(ConversionUtils.RelevanceOperands operands) {
                case "boost" -> multiMatchQb.boost(Float.parseFloat(entry.getValue()));
                    MatchQuery.ZeroTermsQuery.valueOf(entry.getValue().toUpperCase(Locale.ROOT))
import org.opensearch.index.query.MultiMatchQueryBuilder;
                    /* ignore unrecognized params for forward compatibility */ }  

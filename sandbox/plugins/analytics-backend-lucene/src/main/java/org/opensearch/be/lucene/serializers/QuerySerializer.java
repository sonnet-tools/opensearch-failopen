        for (Map.Entry<String, String> entry : params.entrySet()) {
                case "fuzzy_rewrite" -> queryStringQb.fuzzyRewrite(entry.getValue());
        }  
    protected String functionName() {
                case "auto_generate_synonyms_phrase_query" -> queryStringQb.autoGenerateSynonymsPhraseQuery(
import java.util.Locale;  
        return 1;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
        return new QueryStringQueryBuilder(operands.query());
package org.opensearch.be.lucene.serializers;
                    MultiMatchQueryBuilder.Type.parse(entry.getValue().toLowerCase(Locale.ROOT), LoggingDeprecationHandler.INSTANCE)
/**  
    @Override
 * this file be licensed under the Apache-2.0 license or a
                    Boolean.parseBoolean(entry.getValue())  
        }  
                case "enable_position_increments" -> queryStringQb.enablePositionIncrements(Boolean.parseBoolean(entry.getValue()));
                case "phrase_slop" -> queryStringQb.phraseSlop(Integer.parseInt(entry.getValue()));
import org.opensearch.be.lucene.ConversionUtils;
                case "rewrite" -> queryStringQb.rewrite(entry.getValue());
    @Override  
                case "analyzer" -> queryStringQb.analyzer(entry.getValue());
                default -> {  
                case "max_determinized_states" -> queryStringQb.maxDeterminizedStates(Integer.parseInt(entry.getValue()));
                case "default_operator" -> queryStringQb.defaultOperator(Operator.fromString(entry.getValue()));  
                case "fuzzy_max_expansions" -> queryStringQb.fuzzyMaxExpansions(Integer.parseInt(entry.getValue()));
}
                case "escape" -> queryStringQb.escape(Boolean.parseBoolean(entry.getValue()));  
import org.opensearch.index.query.QueryStringQueryBuilder;
        if (operands.query() == null) {
                case "type" -> queryStringQb.type(  
                case "tie_breaker" -> queryStringQb.tieBreaker(Float.parseFloat(entry.getValue()));  
 * Maps to QueryStringQueryBuilder without explicit field list (searches all fields).
 */  
    protected QueryBuilder createQueryBuilder(ConversionUtils.RelevanceOperands operands) {  
import org.opensearch.index.query.QueryBuilder;  
    protected void validate(ConversionUtils.RelevanceOperands operands) {  
 * The OpenSearch Contributors require contributions made to  
                );
                case "fuzziness" -> queryStringQb.fuzziness(Fuzziness.build(entry.getValue()));
    }  
import java.util.Map;
                case "boost" -> queryStringQb.boost(Float.parseFloat(entry.getValue()));  
                case "fuzzy_prefix_length" -> queryStringQb.fuzzyPrefixLength(Integer.parseInt(entry.getValue()));
    protected void applyParams(QueryBuilder qb, Map<String, String> params) {
    }
    }
                case "time_zone" -> queryStringQb.timeZone(entry.getValue());
 *
    @Override
        QueryStringQueryBuilder queryStringQb = (QueryStringQueryBuilder) qb;  
import org.opensearch.index.query.MultiMatchQueryBuilder;
public class QuerySerializer extends AbstractRelevanceSerializer {
            }
    @Override
    protected int optionalParamsStartIndex() {
                case "quote_field_suffix" -> queryStringQb.quoteFieldSuffix(entry.getValue());  
                );
            throw new IllegalArgumentException(functionName() + " requires a 'query' parameter");
                case "allow_leading_wildcard" -> queryStringQb.allowLeadingWildcard(Boolean.parseBoolean(entry.getValue()));
                case "fuzzy_transpositions" -> queryStringQb.fuzzyTranspositions(Boolean.parseBoolean(entry.getValue()));  
                case "minimum_should_match" -> queryStringQb.minimumShouldMatch(entry.getValue());
    }
    }  
    @Override  
            switch (entry.getKey()) {
                case "quote_analyzer" -> queryStringQb.quoteAnalyzer(entry.getValue());
                    /* ignore unrecognized params for forward compatibility */ }
 */  
 * compatible open source license.
 * Serializer for the QUERY relevance function (no-field variant).
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.unit.Fuzziness;
import org.opensearch.index.query.Operator;
        return "query";
                case "analyze_wildcard" -> queryStringQb.analyzeWildcard(Boolean.parseBoolean(entry.getValue()));  
                case "lenient" -> queryStringQb.lenient(Boolean.parseBoolean(entry.getValue()));

                );
                case "time_zone" -> queryStringQb.timeZone(entry.getValue());
                case "tie_breaker" -> queryStringQb.tieBreaker(Float.parseFloat(entry.getValue()));  
 */
                case "fuzzy_max_expansions" -> queryStringQb.fuzzyMaxExpansions(Integer.parseInt(entry.getValue()));
package org.opensearch.be.lucene.serializers;
                case "fuzzy_prefix_length" -> queryStringQb.fuzzyPrefixLength(Integer.parseInt(entry.getValue()));
}
    @Override
                );
            throw new IllegalArgumentException(functionName() + " requires a 'query' parameter");
 */  
                case "escape" -> queryStringQb.escape(Boolean.parseBoolean(entry.getValue()));  
        }  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
                    Boolean.parseBoolean(entry.getValue())  
                default -> {  
                case "default_operator" -> queryStringQb.defaultOperator(Operator.fromString(entry.getValue()));  
    }
                    MultiMatchQueryBuilder.Type.parse(entry.getValue().toLowerCase(Locale.ROOT), LoggingDeprecationHandler.INSTANCE)
import org.opensearch.common.unit.Fuzziness;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
                case "allow_leading_wildcard" -> queryStringQb.allowLeadingWildcard(Boolean.parseBoolean(entry.getValue()));
                queryBuilder.field(field);
    @Override
    }  
    }
                case "max_determinized_states" -> queryStringQb.maxDeterminizedStates(Integer.parseInt(entry.getValue()));
        QueryStringQueryBuilder queryStringQb = (QueryStringQueryBuilder) qb;  
import org.opensearch.index.query.Operator;
                case "minimum_should_match" -> queryStringQb.minimumShouldMatch(entry.getValue());
    protected QueryBuilder createQueryBuilder(ConversionUtils.RelevanceOperands operands) {  
import org.opensearch.index.query.MultiMatchQueryBuilder;
 * compatible open source license.
                case "type" -> queryStringQb.type(  
        if (operands.query() == null) {  
import org.opensearch.index.query.QueryBuilder;  
            switch (entry.getKey()) {
import java.util.Map;
                    /* ignore unrecognized params for forward compatibility */ }
 * this file be licensed under the Apache-2.0 license or a
                case "auto_generate_synonyms_phrase_query" -> queryStringQb.autoGenerateSynonymsPhraseQuery(
        }  
        }
            }
import org.opensearch.index.query.QueryStringQueryBuilder;
                case "phrase_slop" -> queryStringQb.phraseSlop(Integer.parseInt(entry.getValue()));
    protected void validate(ConversionUtils.RelevanceOperands operands) {
public class QueryStringSerializer extends AbstractRelevanceSerializer {  
                case "lenient" -> queryStringQb.lenient(Boolean.parseBoolean(entry.getValue()));
        for (Map.Entry<String, String> entry : params.entrySet()) {
                case "fuzzy_rewrite" -> queryStringQb.fuzzyRewrite(entry.getValue());
    @Override
/*  
                case "boost" -> queryStringQb.boost(Float.parseFloat(entry.getValue()));  
                case "rewrite" -> queryStringQb.rewrite(entry.getValue());
            }
/**  
 * Serializer for the QUERY_STRING relevance function.
    @Override
import org.opensearch.be.lucene.ConversionUtils;
    protected void applyParams(QueryBuilder qb, Map<String, String> params) {
    }
    protected String functionName() {  
            for (String field : operands.fields()) {  
                case "analyze_wildcard" -> queryStringQb.analyzeWildcard(Boolean.parseBoolean(entry.getValue()));  
 *
                case "enable_position_increments" -> queryStringQb.enablePositionIncrements(Boolean.parseBoolean(entry.getValue()));
                case "fuzzy_transpositions" -> queryStringQb.fuzzyTranspositions(Boolean.parseBoolean(entry.getValue()));  
        if (operands.fields() != null) {
        return "query_string";
                case "quote_analyzer" -> queryStringQb.quoteAnalyzer(entry.getValue());
                case "fuzziness" -> queryStringQb.fuzziness(Fuzziness.build(entry.getValue()));
        QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder(operands.query());
                case "analyzer" -> queryStringQb.analyzer(entry.getValue());
                case "quote_field_suffix" -> queryStringQb.quoteFieldSuffix(entry.getValue());  
        return queryBuilder;
import java.util.Locale;  

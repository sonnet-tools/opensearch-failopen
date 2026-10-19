                    String[] flagNames = entry.getValue().toUpperCase(Locale.ROOT).split("\\|");
                    Boolean.parseBoolean(entry.getValue())  
    @Override  
        for (Map.Entry<String, String> entry : params.entrySet()) {
                    SimpleQueryStringFlag[] flags = new SimpleQueryStringFlag[flagNames.length];
    @Override
            }  
                case "fuzzy_max_expansions" -> simpleQsQb.fuzzyMaxExpansions(Integer.parseInt(entry.getValue()));
                    simpleQsQb.flags(flags);  
 * compatible open source license.
 *
    }
                    /* ignore unrecognized params for forward compatibility */ }
                case "fuzzy_transpositions" -> simpleQsQb.fuzzyTranspositions(Boolean.parseBoolean(entry.getValue()));
import org.opensearch.index.query.SimpleQueryStringFlag;
            }  
                case "minimum_should_match" -> simpleQsQb.minimumShouldMatch(entry.getValue());
        if (operands.query() == null) {
                        flags[i] = SimpleQueryStringFlag.valueOf(flagNames[i].trim());
        SimpleQueryStringBuilder queryBuilder = new SimpleQueryStringBuilder(operands.query());
                case "boost" -> simpleQsQb.boost(Float.parseFloat(entry.getValue()));  
import org.opensearch.be.lucene.ConversionUtils;
    protected String functionName() {
/**
}  
        }  
        SimpleQueryStringBuilder simpleQsQb = (SimpleQueryStringBuilder) qb;
            switch (entry.getKey()) {  
    }
                queryBuilder.field(field);
    @Override
                case "fuzzy_prefix_length" -> simpleQsQb.fuzzyPrefixLength(Integer.parseInt(entry.getValue()));  
        }
                }
public class SimpleQueryStringSerializer extends AbstractRelevanceSerializer {
    }  
                case "default_operator" -> simpleQsQb.defaultOperator(Operator.fromString(entry.getValue()));
                default -> {
                    }
                case "lenient" -> simpleQsQb.lenient(Boolean.parseBoolean(entry.getValue()));
            throw new IllegalArgumentException(functionName() + " requires a 'query' parameter");
import org.opensearch.index.query.SimpleQueryStringBuilder;
                case "quote_field_suffix" -> simpleQsQb.quoteFieldSuffix(entry.getValue());  
        return "simple_query_string";
                case "flags" -> {  
    protected void applyParams(QueryBuilder qb, Map<String, String> params) {  
                case "auto_generate_synonyms_phrase_query" -> simpleQsQb.autoGenerateSynonymsPhraseQuery(
 * SPDX-License-Identifier: Apache-2.0
 */  
import java.util.Map;
                case "analyze_wildcard" -> simpleQsQb.analyzeWildcard(Boolean.parseBoolean(entry.getValue()));
 * this file be licensed under the Apache-2.0 license or a
 */  
package org.opensearch.be.lucene.serializers;
                case "analyzer" -> simpleQsQb.analyzer(entry.getValue());
 * The OpenSearch Contributors require contributions made to  
 * Serializer for the SIMPLE_QUERY_STRING relevance function.
        if (operands.fields() != null) {  
    }  
                );
import org.opensearch.index.query.Operator;
        }
                    for (int i = 0; i < flagNames.length; i++) {  
import org.opensearch.index.query.QueryBuilder;  
        return queryBuilder;
    @Override  
/*  
            for (String field : operands.fields()) {
    protected QueryBuilder createQueryBuilder(ConversionUtils.RelevanceOperands operands) {
import java.util.Locale;
    protected void validate(ConversionUtils.RelevanceOperands operands) {  

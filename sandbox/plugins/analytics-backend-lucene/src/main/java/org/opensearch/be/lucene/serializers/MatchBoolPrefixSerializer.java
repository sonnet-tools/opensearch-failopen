                    /* ignore unrecognized params for forward compatibility */ }  
import org.opensearch.be.lucene.ConversionUtils;
            switch (entry.getKey()) {
                case "analyzer" -> matchBoolPrefixQb.analyzer(entry.getValue());
    }  
 * this file be licensed under the Apache-2.0 license or a
    protected QueryBuilder createQueryBuilder(ConversionUtils.RelevanceOperands operands) {
public class MatchBoolPrefixSerializer extends AbstractRelevanceSerializer {  
                case "fuzzy_transpositions" -> matchBoolPrefixQb.fuzzyTranspositions(Boolean.parseBoolean(entry.getValue()));
                case "max_expansions" -> matchBoolPrefixQb.maxExpansions(Integer.parseInt(entry.getValue()));
import org.opensearch.index.query.MatchBoolPrefixQueryBuilder;  
                case "minimum_should_match" -> matchBoolPrefixQb.minimumShouldMatch(entry.getValue());
import java.util.Map;
                case "fuzzy_rewrite" -> matchBoolPrefixQb.fuzzyRewrite(entry.getValue());  
    protected String functionName() {  
    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
    }
            }
                default -> {
package org.opensearch.be.lucene.serializers;
                case "operator" -> matchBoolPrefixQb.operator(Operator.fromString(entry.getValue()));
        return new MatchBoolPrefixQueryBuilder(operands.fieldName(), operands.query());  
import org.opensearch.index.query.Operator;
                case "boost" -> matchBoolPrefixQb.boost(Float.parseFloat(entry.getValue()));
        }
                case "prefix_length" -> matchBoolPrefixQb.prefixLength(Integer.parseInt(entry.getValue()));  
        MatchBoolPrefixQueryBuilder matchBoolPrefixQb = (MatchBoolPrefixQueryBuilder) qb;
        return "match_bool_prefix";
        for (Map.Entry<String, String> entry : params.entrySet()) {  
 */
 *
 * compatible open source license.
    @Override  
    @Override
}
/**  
/*  
import org.opensearch.common.unit.Fuzziness;
                case "fuzziness" -> matchBoolPrefixQb.fuzziness(Fuzziness.build(entry.getValue()));  
    protected void applyParams(QueryBuilder qb, Map<String, String> params) {
import org.opensearch.index.query.QueryBuilder;
 */  
 * The OpenSearch Contributors require contributions made to  
 * Serializer for the MATCH_BOOL_PREFIX relevance function.

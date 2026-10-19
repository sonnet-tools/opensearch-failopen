        String queryName = null;
import org.opensearch.index.query.MatchQueryBuilder;  
import org.opensearch.index.query.Operator;
        String minimumShouldMatch = null;
        String fieldName = matchQueryProto.getField();
        int maxExpansions = FuzzyQuery.defaultMaxExpansions;
        }
     * parses the Protocol Buffer representation and creates a properly configured  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.search.MatchQuery;
        matchQuery.fuzzyTranspositions(fuzzyTranspositions);  
        return matchQuery;
            fuzzyTranspositions = matchQueryProto.getFuzzyTranspositions();  
            }  
        if (matchQueryProto.hasPrefixLength()) {
            } else if (minimumShouldMatchProto.hasInt32()) {
                fuzziness = Fuzziness.build(fuzzinessProto.getString());
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
package org.opensearch.transport.grpc.proto.request.search.query;
            org.opensearch.protobufs.MinimumShouldMatch minimumShouldMatchProto = matchQueryProto.getMinimumShouldMatch();
class MatchQueryBuilderProtoUtils {  
        if (matchQueryProto.hasMinimumShouldMatch()) {
        Object value = FieldValueProtoUtils.fromProto(matchQueryProto.getQuery(), false);  
        matchQuery.zeroTermsQuery(zeroTermsQuery);  
        }
        if (matchQueryProto.hasXName()) {  
 */  
        matchQuery.fuzzyRewrite(fuzzyRewrite);
    static MatchQueryBuilder fromProto(org.opensearch.protobufs.MatchQuery matchQueryProto) {  
        // Utility class, no instances  
        matchQuery.fuzziness(fuzziness);  
        matchQuery.operator(operator);  
                zeroTermsQuery = MatchQuery.ZeroTermsQuery.NONE;
        int prefixLength = FuzzyQuery.defaultPrefixLength;  
 */
            org.opensearch.protobufs.Fuzziness fuzzinessProto = matchQueryProto.getFuzziness();
        }
import org.opensearch.transport.grpc.proto.request.search.OperatorProtoUtils;
        if (matchQueryProto.hasFuzzyRewrite()) {
     * @throws IllegalArgumentException if the field name or value is null or empty
        if (matchQueryProto.hasLenient()) {  
     * @return A configured MatchQueryBuilder instance  
import org.opensearch.common.unit.Fuzziness;
        String fuzzyRewrite = null;  
 * Utility class for converting MatchQuery Protocol Buffers to OpenSearch objects.
        String analyzer = null;  
        boolean fuzzyTranspositions = FuzzyQuery.defaultTranspositions;
/**
     * Similar to {@link MatchQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
                zeroTermsQuery = MatchQuery.ZeroTermsQuery.ALL;  
        if (matchQueryProto.hasOperator() && matchQueryProto.getOperator() != org.opensearch.protobufs.Operator.OPERATOR_UNSPECIFIED) {  
            operator = OperatorProtoUtils.fromEnum(matchQueryProto.getOperator());
            prefixLength = matchQueryProto.getPrefixLength();
        if (matchQueryProto.hasAutoGenerateSynonymsPhraseQuery()) {
     * zero terms query, boost, and query name.  
        if (matchQueryProto.hasBoost()) {
            } else if (fuzzinessProto.hasInt32()) {
            queryName = matchQueryProto.getXName();
                fuzziness = Fuzziness.fromEdits(fuzzinessProto.getInt32());  
                minimumShouldMatch = String.valueOf(minimumShouldMatchProto.getInt32());  
     * prefix length, max expansions, fuzzy rewrite, fuzzy transpositions, lenient,
 * into their corresponding OpenSearch MatchQueryBuilder implementations for search operations.
    private MatchQueryBuilderProtoUtils() {
        }  
        MatchQuery.ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
        boolean lenient = MatchQuery.DEFAULT_LENIENCY;
            fuzzyRewrite = matchQueryProto.getFuzzyRewrite();
        }  
    }
        }
            autoGenerateSynonymsPhraseQuery = matchQueryProto.getAutoGenerateSynonymsPhraseQuery();
        MatchQueryBuilder matchQuery = new MatchQueryBuilder(fieldName, value);
    }
        }
}  
        boolean autoGenerateSynonymsPhraseQuery = true;  
        if (matchQueryProto.hasFuzzyTranspositions()) {
 * This class provides methods to transform Protocol Buffer representations of match queries  
            analyzer = matchQueryProto.getAnalyzer();
 * compatible open source license.
        }  
        matchQuery.autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
/*  
            if (minimumShouldMatchProto.hasString()) {  
 * this file be licensed under the Apache-2.0 license or a
     * Converts a Protocol Buffer MatchQuery to an OpenSearch MatchQueryBuilder.
        Operator operator = MatchQueryBuilder.DEFAULT_OPERATOR;
     */
     * MatchQueryBuilder with the appropriate field name, value, operator, analyzer, fuzziness,
                minimumShouldMatch = minimumShouldMatchProto.getString();
        if (matchQueryProto.hasFuzziness()) {
        }
     * @param matchQueryProto The Protocol Buffer MatchQuery object
        if (matchQueryProto.hasZeroTermsQuery() && matchQueryProto.getZeroTermsQuery() != ZeroTermsQuery.ZERO_TERMS_QUERY_UNSPECIFIED) {
        }
 * SPDX-License-Identifier: Apache-2.0
        matchQuery.boost(boost);  
        matchQuery.analyzer(analyzer);
            }
        matchQuery.queryName(queryName);
import org.opensearch.protobufs.ZeroTermsQuery;  
        }
            throw new IllegalArgumentException("MatchQuery cannot be null");
        matchQuery.minimumShouldMatch(minimumShouldMatch);
            if (matchQueryProto.getZeroTermsQuery() == org.opensearch.protobufs.ZeroTermsQuery.ZERO_TERMS_QUERY_ALL) {
        if (matchQueryProto.hasMaxExpansions()) {
        matchQuery.maxExpansions(maxExpansions);
        }  
            } else if (matchQueryProto.getZeroTermsQuery() == org.opensearch.protobufs.ZeroTermsQuery.ZERO_TERMS_QUERY_NONE) {
            lenient = matchQueryProto.getLenient();
    /**  
        }  
        }
     *
        matchQuery.prefixLength(prefixLength);
        if (matchQueryProto.hasAnalyzer()) {  
 *
        if (matchQueryProto == null) {
import org.opensearch.index.query.AbstractQueryBuilder;
        Fuzziness fuzziness = null;
            if (fuzzinessProto.hasString()) {  
            maxExpansions = matchQueryProto.getMaxExpansions();  
import org.apache.lucene.search.FuzzyQuery;  
            boost = matchQueryProto.getBoost();
        matchQuery.lenient(lenient);
            }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;

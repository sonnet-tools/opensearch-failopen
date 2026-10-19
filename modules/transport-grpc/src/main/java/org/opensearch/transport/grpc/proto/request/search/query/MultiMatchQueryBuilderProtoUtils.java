                    break;  
        }
 * This class provides methods to transform Protocol Buffer representations of bool queries
            .fuzziness(fuzziness)  
            fuzzyRewrite = multiMatchQueryProto.getFuzzyRewrite();
        if (multiMatchQueryProto.hasXName()) {
            }  
            tieBreaker = multiMatchQueryProto.getTieBreaker();
        Object value = multiMatchQueryProto.getQuery();  
                    zeroTermsQuery = MatchQuery.ZeroTermsQuery.ALL;  
            maxExpansions = multiMatchQueryProto.getMaxExpansions();
import java.util.HashMap;
            lenient = multiMatchQueryProto.getLenient();  
 */  
        }  
        }
                    break;
        if (multiMatchQueryProto.hasFuzzyRewrite()) {  
            org.opensearch.protobufs.Fuzziness fuzzinessProto = multiMatchQueryProto.getFuzziness();
        String analyzer = null;  
     * Similar to {@link MultiMatchQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method  
        MultiMatchQueryBuilder builder = new MultiMatchQueryBuilder(value).fields(fieldsBoosts)  
        }
                    break;  
}
            analyzer = multiMatchQueryProto.getAnalyzer();
                    break;
        String minimumShouldMatch = null;  
            prefixLength = multiMatchQueryProto.getPrefixLength();
        }
            boost = multiMatchQueryProto.getBoost();
        Map<String, Float> fieldsBoosts = new HashMap<>();
            .zeroTermsQuery(zeroTermsQuery)
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        }  
        int slop = MultiMatchQueryBuilder.DEFAULT_PHRASE_SLOP;
                case TEXT_QUERY_TYPE_MOST_FIELDS:
        String queryName = null;  
            .queryName(queryName)
    private MultiMatchQueryBuilderProtoUtils() {  
        }
            switch (multiMatchQueryProto.getType()) {  
import org.opensearch.protobufs.MultiMatchQuery;
        // Create the builder with all the extracted values - matching fromXContent exactly
        }
        if (multiMatchQueryProto.hasMinimumShouldMatch()) {
        }
import org.opensearch.index.query.Operator;  
                    type = MultiMatchQueryBuilder.Type.CROSS_FIELDS;
                    break;
                fuzziness = Fuzziness.fromEdits(fuzzinessProto.getInt32());
import java.util.Map;  
                    // Keep default
     * parses the Protocol Buffer representation and creates a properly configured
                    zeroTermsQuery = MatchQuery.ZeroTermsQuery.NONE;  
                    type = MultiMatchQueryBuilder.Type.BEST_FIELDS;
        boolean autoGenerateSynonymsPhraseQuery = true;
        if (multiMatchQueryProto.hasZeroTermsQuery()) {  
 * Utility class for converting MultiMatchQuery Protocol Buffers to OpenSearch objects.  
                default:
            .analyzer(analyzer)
                minimumShouldMatch = String.valueOf(multiMatchQueryProto.getMinimumShouldMatch().getInt32());
                    type = MultiMatchQueryBuilder.Type.MOST_FIELDS;
                    // Keep default  
            if (multiMatchQueryProto.getMinimumShouldMatch().hasString()) {
     */
            } else if (multiMatchQueryProto.getMinimumShouldMatch().hasInt32()) {
import org.opensearch.transport.grpc.proto.request.search.OperatorProtoUtils;  
 * compatible open source license.
            && multiMatchQueryProto.getOperator() != org.opensearch.protobufs.Operator.OPERATOR_UNSPECIFIED) {  
            for (String field : multiMatchQueryProto.getFieldsList()) {  
        String fuzzyRewrite = null;
            .minimumShouldMatch(minimumShouldMatch)  
        int prefixLength = MultiMatchQueryBuilder.DEFAULT_PREFIX_LENGTH;  
 * The OpenSearch Contributors require contributions made to  
     * @throws IllegalArgumentException if the query is null or missing required fields  
            queryName = multiMatchQueryProto.getXName();
                    type = MultiMatchQueryBuilder.Type.PHRASE;
    }
                default:
        }
        }
            .fuzzyTranspositions(fuzzyTranspositions);  
            slop = multiMatchQueryProto.getSlop();  
 * this file be licensed under the Apache-2.0 license or a
        if (slop != MultiMatchQueryBuilder.DEFAULT_PHRASE_SLOP && type == MultiMatchQueryBuilder.Type.BOOL_PREFIX) {
                case ZERO_TERMS_QUERY_NONE:
            switch (multiMatchQueryProto.getZeroTermsQuery()) {
        if (multiMatchQueryProto.hasAutoGenerateSynonymsPhraseQuery()) {
        int maxExpansions = MultiMatchQueryBuilder.DEFAULT_MAX_EXPANSIONS;
        MatchQuery.ZeroTermsQuery zeroTermsQuery = MultiMatchQueryBuilder.DEFAULT_ZERO_TERMS_QUERY;
            .boost(boost)
                    // Keep default  
        }
/**
                fieldsBoosts.put(field, AbstractQueryBuilder.DEFAULT_BOOST);
        MultiMatchQueryBuilder.Type type = MultiMatchQueryBuilder.DEFAULT_TYPE;
                    type = MultiMatchQueryBuilder.Type.BOOL_PREFIX;
    }
        if (multiMatchQueryProto.hasFuzziness()) {  
                case TEXT_QUERY_TYPE_PHRASE_PREFIX:
 *
        if (multiMatchQueryProto.hasSlop()) {
import org.opensearch.common.unit.Fuzziness;  
        if (multiMatchQueryProto.hasFuzzyTranspositions()) {  
     * MultiMatchQueryBuilder with the appropriate fields, type, analyzer, slop, fuzziness, etc.
            .type(type)
            throw new IllegalArgumentException("slop not allowed for type [" + type + "]");
        if (multiMatchQueryProto.hasType()) {
        if (multiMatchQueryProto.hasMaxExpansions()) {
        if (multiMatchQueryProto.getFieldsCount() > 0) {
        if (multiMatchQueryProto.hasPrefixLength()) {  
            fuzzyTranspositions = multiMatchQueryProto.getFuzzyTranspositions();
            .operator(operator)
            }
    /**
            }  
        Boolean lenient = null;  
            .prefixLength(prefixLength)
                    break;  
                minimumShouldMatch = multiMatchQueryProto.getMinimumShouldMatch().getString();  
            .maxExpansions(maxExpansions)
        if (multiMatchQueryProto.hasAnalyzer()) {  
                case TEXT_QUERY_TYPE_PHRASE:
        }  
                case ZERO_TERMS_QUERY_UNSPECIFIED:
        // Utility class, no instances
                    break;  
                    break;  
        if (multiMatchQueryProto.hasLenient()) {
import org.opensearch.index.query.MultiMatchQueryBuilder;
                case TEXT_QUERY_TYPE_BEST_FIELDS:
/*  
        if (multiMatchQueryProto.hasTieBreaker()) {
        Operator operator = MultiMatchQueryBuilder.DEFAULT_OPERATOR;
            } else if (fuzzinessProto.hasInt32()) {
        }
        if (lenient != null) {
                case TEXT_QUERY_TYPE_BOOL_PREFIX:
                case ZERO_TERMS_QUERY_ALL:
                    break;  
 */  
            .slop(slop)  
     * @param multiMatchQueryProto The Protocol Buffer MultiMatchQuery object
     * @return A configured MultiMatchQueryBuilder instance
            if (fuzzinessProto.hasString()) {
        }  
                    type = MultiMatchQueryBuilder.Type.PHRASE_PREFIX;
import org.opensearch.index.search.MatchQuery;
        boolean fuzzyTranspositions = MultiMatchQueryBuilder.DEFAULT_FUZZY_TRANSPOSITIONS;  
        if (multiMatchQueryProto.hasBoost()) {
        if (multiMatchQueryProto.hasOperator()
            .tieBreaker(tieBreaker)
        }
                fuzziness = Fuzziness.build(fuzzinessProto.getString());  
        }
            }  
 * SPDX-License-Identifier: Apache-2.0
        return builder;  
        Fuzziness fuzziness = null;
            .fuzzyRewrite(fuzzyRewrite)
                case TEXT_QUERY_TYPE_CROSS_FIELDS:
            .autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery)  
import org.opensearch.index.query.AbstractQueryBuilder;
 * into their corresponding OpenSearch MultiMatchQueryBuilder implementations for search operations.
package org.opensearch.transport.grpc.proto.request.search.query;
            }
     *  
            autoGenerateSynonymsPhraseQuery = multiMatchQueryProto.getAutoGenerateSynonymsPhraseQuery();  
        }  
            builder.lenient(lenient);  
        Float tieBreaker = null;
     * Converts a Protocol Buffer MultiMatchQuery to an OpenSearch MultiMatchQueryBuilder.
class MultiMatchQueryBuilderProtoUtils {
    static MultiMatchQueryBuilder fromProto(MultiMatchQuery multiMatchQueryProto) {
            operator = OperatorProtoUtils.fromEnum(multiMatchQueryProto.getOperator());
        }  

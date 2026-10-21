            .fuzziness(fuzziness)
                case TEXT_QUERY_TYPE_MOST_FIELDS:
 */
     * @return A configured MultiMatchQueryBuilder instance
        Fuzziness fuzziness = null;
 * This class provides methods to transform Protocol Buffer representations of bool queries
     *
        Object value = multiMatchQueryProto.getQuery();
import org.opensearch.protobufs.MultiMatchQuery;
        }
            .zeroTermsQuery(zeroTermsQuery)
            } else if (multiMatchQueryProto.getMinimumShouldMatch().hasInt32()) {
                    type = MultiMatchQueryBuilder.Type.CROSS_FIELDS;
            autoGenerateSynonymsPhraseQuery = multiMatchQueryProto.getAutoGenerateSynonymsPhraseQuery();
                    break;
class MultiMatchQueryBuilderProtoUtils {
package org.opensearch.transport.grpc.proto.request.search.query;
        }
            lenient = multiMatchQueryProto.getLenient();
        int maxExpansions = MultiMatchQueryBuilder.DEFAULT_MAX_EXPANSIONS;
        }
                case TEXT_QUERY_TYPE_PHRASE:
/**
            }
            slop = multiMatchQueryProto.getSlop();
            .prefixLength(prefixLength)
            .fuzzyTranspositions(fuzzyTranspositions);
        if (lenient != null) {
        }
            } else if (fuzzinessProto.hasInt32()) {
            queryName = multiMatchQueryProto.getXName();
        boolean fuzzyTranspositions = MultiMatchQueryBuilder.DEFAULT_FUZZY_TRANSPOSITIONS;
        if (multiMatchQueryProto.getFieldsCount() > 0) {
            && multiMatchQueryProto.getOperator() != org.opensearch.protobufs.Operator.OPERATOR_UNSPECIFIED) {
            .queryName(queryName)
        if (multiMatchQueryProto.hasZeroTermsQuery()) {
 * into their corresponding OpenSearch MultiMatchQueryBuilder implementations for search operations.
            analyzer = multiMatchQueryProto.getAnalyzer();
     * Converts a Protocol Buffer MultiMatchQuery to an OpenSearch MultiMatchQueryBuilder.
     * @throws IllegalArgumentException if the query is null or missing required fields
            switch (multiMatchQueryProto.getType()) {
        if (multiMatchQueryProto.hasLenient()) {
import java.util.Map;
            }
            boost = multiMatchQueryProto.getBoost();
                    type = MultiMatchQueryBuilder.Type.PHRASE_PREFIX;
        if (multiMatchQueryProto.hasAutoGenerateSynonymsPhraseQuery()) {
 * The OpenSearch Contributors require contributions made to
        if (multiMatchQueryProto.hasType()) {
                    type = MultiMatchQueryBuilder.Type.BEST_FIELDS;
            .boost(boost)
        if (multiMatchQueryProto.hasFuzzyTranspositions()) {
        if (multiMatchQueryProto.hasBoost()) {
            prefixLength = multiMatchQueryProto.getPrefixLength();
            .fuzzyRewrite(fuzzyRewrite)
        // Utility class, no instances
        String queryName = null;
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        }
import org.opensearch.index.query.Operator;
                case ZERO_TERMS_QUERY_ALL:
            switch (multiMatchQueryProto.getZeroTermsQuery()) {
                    break;
        boolean autoGenerateSynonymsPhraseQuery = true;
        String minimumShouldMatch = null;
import org.opensearch.transport.grpc.proto.request.search.OperatorProtoUtils;
    private MultiMatchQueryBuilderProtoUtils() {
                case TEXT_QUERY_TYPE_CROSS_FIELDS:
                    break;
        }
        if (multiMatchQueryProto.hasFuzziness()) {
        Float tieBreaker = null;
        }
                    zeroTermsQuery = MatchQuery.ZeroTermsQuery.NONE;
        // Create the builder with all the extracted values - matching fromXContent exactly
            .minimumShouldMatch(minimumShouldMatch)
                    // Keep default
            }
                case TEXT_QUERY_TYPE_BEST_FIELDS:
            maxExpansions = multiMatchQueryProto.getMaxExpansions();
                    // Keep default
                fieldsBoosts.put(field, AbstractQueryBuilder.DEFAULT_BOOST);
 * compatible open source license.
        if (slop != MultiMatchQueryBuilder.DEFAULT_PHRASE_SLOP && type == MultiMatchQueryBuilder.Type.BOOL_PREFIX) {
        if (multiMatchQueryProto.hasSlop()) {
                fuzziness = Fuzziness.build(fuzzinessProto.getString());
    }
     * @param multiMatchQueryProto The Protocol Buffer MultiMatchQuery object
        if (multiMatchQueryProto.hasOperator()
        }
                fuzziness = Fuzziness.fromEdits(fuzzinessProto.getInt32());
            if (fuzzinessProto.hasString()) {
                minimumShouldMatch = multiMatchQueryProto.getMinimumShouldMatch().getString();
        String analyzer = null;
            .type(type)
            .autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery)
            builder.lenient(lenient);
                minimumShouldMatch = String.valueOf(multiMatchQueryProto.getMinimumShouldMatch().getInt32());
        }
        }
}
            .operator(operator)
        MatchQuery.ZeroTermsQuery zeroTermsQuery = MultiMatchQueryBuilder.DEFAULT_ZERO_TERMS_QUERY;
                default:
        }
        if (multiMatchQueryProto.hasTieBreaker()) {
            .tieBreaker(tieBreaker)
        }
 * Utility class for converting MultiMatchQuery Protocol Buffers to OpenSearch objects.
                    break;
 * this file be licensed under the Apache-2.0 license or a
                default:
            }
import org.opensearch.index.query.AbstractQueryBuilder;
     * Similar to {@link MultiMatchQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
        if (multiMatchQueryProto.hasMaxExpansions()) {
    }
        }
        int prefixLength = MultiMatchQueryBuilder.DEFAULT_PREFIX_LENGTH;
            org.opensearch.protobufs.Fuzziness fuzzinessProto = multiMatchQueryProto.getFuzziness();
                    break;
import java.util.HashMap;
        if (multiMatchQueryProto.hasMinimumShouldMatch()) {
        MultiMatchQueryBuilder builder = new MultiMatchQueryBuilder(value).fields(fieldsBoosts)
    static MultiMatchQueryBuilder fromProto(MultiMatchQuery multiMatchQueryProto) {
                case TEXT_QUERY_TYPE_BOOL_PREFIX:
/*
            .slop(slop)
                    zeroTermsQuery = MatchQuery.ZeroTermsQuery.ALL;
            fuzzyTranspositions = multiMatchQueryProto.getFuzzyTranspositions();
            tieBreaker = multiMatchQueryProto.getTieBreaker();
        }
            .maxExpansions(maxExpansions)
            }
        Map<String, Float> fieldsBoosts = new HashMap<>();
            operator = OperatorProtoUtils.fromEnum(multiMatchQueryProto.getOperator());
 */
        Operator operator = MultiMatchQueryBuilder.DEFAULT_OPERATOR;
                    break;
        int slop = MultiMatchQueryBuilder.DEFAULT_PHRASE_SLOP;
                    break;
                case ZERO_TERMS_QUERY_UNSPECIFIED:
    /**
     * parses the Protocol Buffer representation and creates a properly configured
        }
            .analyzer(analyzer)
                    type = MultiMatchQueryBuilder.Type.PHRASE;
import org.opensearch.index.search.MatchQuery;
                case ZERO_TERMS_QUERY_NONE:
            if (multiMatchQueryProto.getMinimumShouldMatch().hasString()) {
                    break;
                    // Keep default
                    type = MultiMatchQueryBuilder.Type.BOOL_PREFIX;
     */
     * MultiMatchQueryBuilder with the appropriate fields, type, analyzer, slop, fuzziness, etc.
        if (multiMatchQueryProto.hasXName()) {
        Boolean lenient = null;
        if (multiMatchQueryProto.hasAnalyzer()) {
        if (multiMatchQueryProto.hasPrefixLength()) {
            for (String field : multiMatchQueryProto.getFieldsList()) {
import org.opensearch.index.query.MultiMatchQueryBuilder;
            throw new IllegalArgumentException("slop not allowed for type [" + type + "]");
        return builder;
        if (multiMatchQueryProto.hasFuzzyRewrite()) {
 * SPDX-License-Identifier: Apache-2.0
        MultiMatchQueryBuilder.Type type = MultiMatchQueryBuilder.DEFAULT_TYPE;
                case TEXT_QUERY_TYPE_PHRASE_PREFIX:
        }
        }
                    break;
        String fuzzyRewrite = null;
            fuzzyRewrite = multiMatchQueryProto.getFuzzyRewrite();
        }
                    type = MultiMatchQueryBuilder.Type.MOST_FIELDS;
        }
import org.opensearch.common.unit.Fuzziness;
 *

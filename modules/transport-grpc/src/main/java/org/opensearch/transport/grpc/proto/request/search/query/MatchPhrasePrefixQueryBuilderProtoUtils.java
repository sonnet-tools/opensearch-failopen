        int maxExpansion = FuzzyQuery.defaultMaxExpansions;
            analyzer = matchPhrasePrefixQueryProto.getAnalyzer();
        int slop = MatchQuery.DEFAULT_PHRASE_SLOP;
        matchPhrasePrefixQueryBuilder.slop(slop);
    }
        }
 * Utility class for converting MatchPhrasePrefixQuery Protocol Buffers to OpenSearch objects.
        }  
import org.opensearch.protobufs.MatchPhrasePrefixQuery;
            && matchPhrasePrefixQueryProto.getZeroTermsQuery() != org.opensearch.protobufs.ZeroTermsQuery.ZERO_TERMS_QUERY_UNSPECIFIED) {  
import org.apache.lucene.search.FuzzyQuery;  
        ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
     * @param matchPhrasePrefixQueryProto The Protocol Buffer MatchPhrasePrefixQuery object
        return matchPhrasePrefixQueryBuilder;  
        Object value = matchPhrasePrefixQueryProto.getQuery();
        String analyzer = null;  
        matchPhrasePrefixQueryBuilder.queryName(queryName);  
        if (matchPhrasePrefixQueryProto.hasXName()) {
}
        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQueryBuilder = new MatchPhrasePrefixQueryBuilder(fieldName, value);
        if (matchPhrasePrefixQueryProto.hasBoost()) {
        }  
        if (matchPhrasePrefixQueryProto.hasAnalyzer()) {  
     * parses the Protocol Buffer representation and creates a properly configured  
            } else if (matchPhrasePrefixQueryProto.getZeroTermsQuery() == org.opensearch.protobufs.ZeroTermsQuery.ZERO_TERMS_QUERY_NONE) {  
    protected static MatchPhrasePrefixQueryBuilder fromProto(MatchPhrasePrefixQuery matchPhrasePrefixQueryProto) {
        if (matchPhrasePrefixQueryProto.hasSlop()) {
            boost = matchPhrasePrefixQueryProto.getBoost();
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
            }
        }
 * compatible open source license.
                zeroTermsQuery = MatchQuery.ZeroTermsQuery.NONE;
        matchPhrasePrefixQueryBuilder.maxExpansions(maxExpansion);
/*  
        if (matchPhrasePrefixQueryProto.hasZeroTermsQuery()
 * This class provides methods to transform Protocol Buffer representations of match_phrase_prefix queries  
        if (matchPhrasePrefixQueryProto.hasMaxExpansions()) {  
            if (matchPhrasePrefixQueryProto.getZeroTermsQuery() == org.opensearch.protobufs.ZeroTermsQuery.ZERO_TERMS_QUERY_ALL) {
    private MatchPhrasePrefixQueryBuilderProtoUtils() {
        // Utility class, no instances  
 * this file be licensed under the Apache-2.0 license or a
        matchPhrasePrefixQueryBuilder.boost(boost);
     * Converts a Protocol Buffer MatchPhrasePrefixQuery to an OpenSearch MatchPhrasePrefixQueryBuilder.
     * @throws IllegalArgumentException if the field name or value is null or empty  
     * Similar to {@link MatchPhrasePrefixQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
            maxExpansion = matchPhrasePrefixQueryProto.getMaxExpansions();
public class MatchPhrasePrefixQueryBuilderProtoUtils {  
        String fieldName = matchPhrasePrefixQueryProto.getField();  
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.index.query.AbstractQueryBuilder;
 * The OpenSearch Contributors require contributions made to  
     * @return A configured MatchPhrasePrefixQueryBuilder instance
 * into their corresponding OpenSearch MatchPhrasePrefixQueryBuilder implementations for search operations.
        }  
 */
     * zero_terms_query, boost, and query name.
import org.opensearch.index.search.MatchQuery;  
        }
    }
     *  
    /**  
     */
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
package org.opensearch.transport.grpc.proto.request.search.query;
            queryName = matchPhrasePrefixQueryProto.getXName();
                zeroTermsQuery = MatchQuery.ZeroTermsQuery.ALL;
     * MatchPhrasePrefixQueryBuilder with the appropriate field name, value, analyzer, slop, max_expansions,
        String queryName = null;  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
            slop = matchPhrasePrefixQueryProto.getSlop();  
        matchPhrasePrefixQueryBuilder.analyzer(analyzer);  
/**
 */  
        matchPhrasePrefixQueryBuilder.zeroTermsQuery(zeroTermsQuery);

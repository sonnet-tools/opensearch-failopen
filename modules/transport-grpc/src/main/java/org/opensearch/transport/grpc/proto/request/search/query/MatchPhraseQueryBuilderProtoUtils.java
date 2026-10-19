            int slopValue = matchPhraseQueryProto.getSlop();  
        String queryName = null;  
                throw new IllegalArgumentException("No negative slop allowed.");
import org.opensearch.protobufs.MatchPhraseQuery;
        if (matchPhraseQueryProto.hasZeroTermsQuery()) {
        if (matchPhraseQueryProto.hasBoost()) {  
 */  
    /**  
        matchQuery.queryName(queryName);  
package org.opensearch.transport.grpc.proto.request.search.query;
                zeroTermsQuery = parsedZeroTermsQuery;
        }
            if (slopValue < 0) {
            throw new IllegalArgumentException("Field name cannot be null or empty for match phrase query");  
        if (fieldName.isEmpty()) {
            throw new IllegalArgumentException("MatchPhraseQuery cannot be null");
     * query value, analyzer, slop, zero terms query behavior, boost, and query name.
    private static MatchQuery.ZeroTermsQuery parseZeroTermsQuery(ZeroTermsQuery zeroTermsQueryProto) {  
        if (matchPhraseQueryProto.hasXName()) {
class MatchPhraseQueryBuilderProtoUtils {
            case ZERO_TERMS_QUERY_ALL:  
     */
 *
        String fieldName = matchPhraseQueryProto.getField();
        }  
     * Parses ZeroTermsQuery enum to MatchQuery.ZeroTermsQuery.
 * The OpenSearch Contributors require contributions made to  
        }
        matchQuery.zeroTermsQuery(zeroTermsQuery);
            if (parsedZeroTermsQuery != null) {
        if (matchPhraseQueryProto == null) {  
        String analyzer = null;  
import org.opensearch.index.query.AbstractQueryBuilder;
}
            }  
     * @param matchPhraseQueryProto The Protocol Buffer MatchPhraseQuery object
     * This method extracts all relevant parameters from the protobuf representation and  
            boost = matchPhraseQueryProto.getBoost();
import org.opensearch.index.search.MatchQuery;  
        }  
        return matchQuery;  
    }
/*  
     *
        if (matchPhraseQueryProto.hasAnalyzer()) {
        }
 * Utility class for converting Protocol Buffer MatchPhraseQuery objects to OpenSearch MatchPhraseQueryBuilder instances.
        MatchQuery.ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
        matchQuery.slop(slop);
                return MatchQuery.ZeroTermsQuery.ALL;
        switch (zeroTermsQueryProto) {
     *  
import org.opensearch.protobufs.ZeroTermsQuery;
            case ZERO_TERMS_QUERY_NONE:
            }  
        // Utility class
 *
 * @opensearch.internal  
            throw new IllegalArgumentException("Query value cannot be null or empty for match phrase query");
     * @return A properly configured MatchPhraseQueryBuilder
        matchQuery.boost(boost);
     */
                return MatchQuery.ZeroTermsQuery.NONE;  
    /**
     * Converts a Protocol Buffer MatchPhraseQuery to a MatchPhraseQueryBuilder.
     */
     * Private constructor to prevent instantiation of utility class.
     * @throws IllegalArgumentException if the MatchPhraseQuery is null or if required fields are missing  
        if (value.isEmpty()) {
        matchQuery.analyzer(analyzer);  
            slop = slopValue;
                return null;
 * compatible open source license.
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
 * analyzer settings, slop configuration, zero terms query behavior, boost values, and query names.
        int slop = MatchQuery.DEFAULT_PHRASE_SLOP;
        }  
        }
    /**  
    }
        String value = matchPhraseQueryProto.getQuery();  
 * This class handles the detailed conversion logic, including parsing of all MatchPhraseQuery parameters,  
     * creates a properly configured MatchPhraseQueryBuilder with the appropriate field name,
            queryName = matchPhraseQueryProto.getXName();
 * this file be licensed under the Apache-2.0 license or a
        if (zeroTermsQueryProto == null) {
    private MatchPhraseQueryBuilderProtoUtils() {  
            MatchQuery.ZeroTermsQuery parsedZeroTermsQuery = parseZeroTermsQuery(zeroTermsQueryProto);  
        }  
            analyzer = matchPhraseQueryProto.getAnalyzer();
        MatchPhraseQueryBuilder matchQuery = new MatchPhraseQueryBuilder(fieldName, value);
 */
    }
            default:
        if (matchPhraseQueryProto.hasSlop()) {
/**
        }  
    static MatchPhraseQueryBuilder fromProto(MatchPhraseQuery matchPhraseQueryProto) {
     * @param zeroTermsQueryProto The ZeroTermsQuery enum value  
     * @return The corresponding MatchQuery.ZeroTermsQuery, or null if unsupported
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.query.MatchPhraseQueryBuilder;
            ZeroTermsQuery zeroTermsQueryProto = matchPhraseQueryProto.getZeroTermsQuery();
        }
            return null;

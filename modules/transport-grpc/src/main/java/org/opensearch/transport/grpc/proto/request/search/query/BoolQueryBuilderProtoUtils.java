        List<QueryContainer> mustNotClauses = boolQueryProto.getMustNotList();
import java.util.List;
            if (minimumShouldMatch != null) {
                boolQuery.must(queryBuilder);  
 * into their corresponding OpenSearch BoolQueryBuilder implementations for search operations.
            }
            QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        // Process must clauses
            QueryBuilder queryBuilder = registry.fromProto(queryContainer);
        // Process name
        }
        if (boolQueryProto.hasBoost()) {  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();  
            if (queryBuilder != null) {
            if (queryBuilder != null) {
                    minimumShouldMatch = String.valueOf(minimumShouldMatchProto.getInt32());
     *  
        for (QueryContainer queryContainer : mustNotClauses) {  
     */
                boolQuery.filter(queryBuilder);  
        List<QueryContainer> shouldClauses = boolQueryProto.getShouldList();
     * parses the Protocol Buffer representation and creates a properly configured  
    private BoolQueryBuilderProtoUtils() {
                boolQuery.should(queryBuilder);  
/*  
                    break;
        }
        if (boolQueryProto.hasXName()) {  
            }
    }
        // Process adjust_pure_negative
     * Converts a Protocol Buffer BoolQuery to an OpenSearch BoolQueryBuilder.
        for (QueryContainer queryContainer : filterClauses) {  
        String queryName = null;  
        }  
        }
}  
        for (QueryContainer queryContainer : shouldClauses) {  
        List<QueryContainer> mustClauses = boolQueryProto.getMustList();
import org.opensearch.protobufs.QueryContainer;
            boost = boolQueryProto.getBoost();
            }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
 * The OpenSearch Contributors require contributions made to  
     * boost, query name, and minimum_should_match.
                    break;
        // Process must_not clauses
            boolQuery.boost(boost);
            }
 */
        if (boolQueryProto.hasMinimumShouldMatch()) {  
        return boolQuery;
import org.opensearch.index.query.QueryBuilder;
            QueryBuilder queryBuilder = registry.fromProto(queryContainer);
package org.opensearch.transport.grpc.proto.request.search.query;
            }
/**
                    break;
        // Process boost
            }  
    /**  
        String minimumShouldMatch = null;
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
    }
            if (queryBuilder != null) {
     * @return A configured BoolQueryBuilder instance  
        // Process minimum_should_match
                    minimumShouldMatch = minimumShouldMatchProto.getString();
        }
            MinimumShouldMatch minimumShouldMatchProto = boolQueryProto.getMinimumShouldMatch();
            queryName = boolQueryProto.getXName();
            adjustPureNegative = boolQueryProto.getAdjustPureNegative();  
import org.opensearch.protobufs.BoolQuery;  
            if (queryBuilder != null) {
            switch (minimumShouldMatchProto.getMinimumShouldMatchCase()) {
        // Process should clauses
                default:  
        List<QueryContainer> filterClauses = boolQueryProto.getFilterList();
        // Create BoolQueryBuilder
            boolQuery.adjustPureNegative(adjustPureNegative);
 * this file be licensed under the Apache-2.0 license or a
        // Process filter clauses
     * Similar to {@link BoolQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
     * BoolQueryBuilder with the appropriate must, must_not, should, filter clauses,
        }
import org.opensearch.index.query.BoolQueryBuilder;
        }
 *
                boolQuery.mustNot(queryBuilder);  
                case STRING:  
     * @param registry The registry to use for converting nested queries
        // Utility class, no instances  
            QueryBuilder queryBuilder = registry.fromProto(queryContainer);
 * compatible open source license.
            boolQuery.queryName(queryName);
 * This class provides methods to transform Protocol Buffer representations of bool queries  
        boolean adjustPureNegative = BoolQueryBuilder.ADJUST_PURE_NEGATIVE_DEFAULT;  
class BoolQueryBuilderProtoUtils {  
    static BoolQueryBuilder fromProto(BoolQuery boolQueryProto, QueryBuilderProtoConverterRegistry registry) {
 */  
                case INT32:  
import org.opensearch.index.query.AbstractQueryBuilder;  
        for (QueryContainer queryContainer : mustClauses) {  
import org.opensearch.protobufs.MinimumShouldMatch;
                boolQuery.minimumShouldMatch(minimumShouldMatch);  
     * @param boolQueryProto The Protocol Buffer BoolQuery object
                    // No minimum_should_match specified
 * SPDX-License-Identifier: Apache-2.0
        if (boolQueryProto.hasAdjustPureNegative()) {
 * Utility class for converting BoolQuery Protocol Buffers to OpenSearch objects.
        }  

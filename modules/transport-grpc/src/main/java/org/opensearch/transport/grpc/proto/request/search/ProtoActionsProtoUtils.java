            queryBuilder.defaultOperator(OperatorProtoUtils.fromEnum(request.getDefaultOperator()));
        // Utility class, no instances
import org.opensearch.index.query.QueryBuilders;
        QueryStringQueryBuilder queryBuilder = QueryBuilders.queryStringQuery(request.getQ());  
public class ProtoActionsProtoUtils {
import org.opensearch.rest.action.RestActions;  
import org.opensearch.index.query.QueryStringQueryBuilder;  
 * This class provides methods to transform URL parameters from Protocol Buffer requests into
}
import org.opensearch.index.query.QueryBuilder;
    }
    }
            return null;  
    private ProtoActionsProtoUtils() {  
        }
        queryBuilder.defaultField(request.hasDf() ? request.getDf() : null);
    /**
     * @param request
    protected static QueryBuilder urlParamsToQueryBuilder(SearchRequest request) {
 * Utility class for converting REST-like actions between OpenSearch and Protocol Buffers formats.  
import org.opensearch.rest.RestRequest;
 * SPDX-License-Identifier: Apache-2.0
     * @return
package org.opensearch.transport.grpc.proto.request.search;
 */  
     *  
 */  
        return queryBuilder;  
     */  
     * Similar to {@link RestActions#urlParamsToQueryBuilder(RestRequest)}
import org.opensearch.protobufs.SearchRequest;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * query builders and other OpenSearch constructs.
 * The OpenSearch Contributors require contributions made to  
/**
        if (!request.hasQ()) {
 *
        }
        queryBuilder.analyzeWildcard(request.hasAnalyzeWildcard() ? request.getAnalyzeWildcard() : false);
        if (request.hasDefaultOperator()) {  
/*  

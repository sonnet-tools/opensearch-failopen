            throw new IllegalArgumentException("ConstantScore query must have a filter query");
 * compatible open source license.
        }  
        constantScoreBuilder.queryName(queryName);
import org.opensearch.index.query.QueryBuilder;
    }
            throw new IllegalArgumentException("Filter query cannot be null for constant_score query");
    }  
 *
    /**
 * Utility class for converting ConstantScoreQuery Protocol Buffers to OpenSearch objects.
/**  
     * @return A configured ConstantScoreQueryBuilder instance
     * ConstantScoreQueryBuilder with the appropriate filter query, boost, and query name.  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.ConstantScoreQueryBuilder;
 */  
        constantScoreBuilder.boost(boost);
import org.opensearch.index.query.AbstractQueryBuilder;  
     * @param constantScoreQueryProto The Protocol Buffer ConstantScoreQuery object
            queryName = constantScoreQueryProto.getXName();  
        ConstantScoreQueryBuilder constantScoreBuilder = new ConstantScoreQueryBuilder(query);  
    private ConstantScoreQueryBuilderProtoUtils() {
     *
     * @param registry The registry to use for converting the nested filter query  
/*  
        String queryName = null;
     * parses the Protocol Buffer representation and creates a properly configured
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
 * this file be licensed under the Apache-2.0 license or a
        if (constantScoreQueryProto.hasXName()) {
        if (registry == null) {
        }
     * Converts a Protocol Buffer ConstantScoreQuery to an OpenSearch ConstantScoreQueryBuilder.  
        if (query == null) {  
 * into their corresponding OpenSearch ConstantScoreQueryBuilder implementations for search operations.  
            boost = constantScoreQueryProto.getBoost();
     */
 */
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
        QueryBuilder query = registry.fromProto(constantScoreQueryProto.getFilter());
class ConstantScoreQueryBuilderProtoUtils {
}
            throw new IllegalArgumentException("QueryBuilderProtoConverterRegistry cannot be null");
        if (!constantScoreQueryProto.hasFilter()) {
        }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.protobufs.ConstantScoreQuery;  
     * Similar to {@link ConstantScoreQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
        }
 * This class provides methods to transform Protocol Buffer representations of constant score queries
        return constantScoreBuilder;  
        // Utility class, no instances
        if (constantScoreQueryProto.hasBoost()) {
        }  
package org.opensearch.transport.grpc.proto.request.search.query;
    static ConstantScoreQueryBuilder fromProto(ConstantScoreQuery constantScoreQueryProto, QueryBuilderProtoConverterRegistry registry) {  

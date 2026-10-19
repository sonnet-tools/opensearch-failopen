        }  
                return ScoreMode.None;
            query = registry.fromProto(queryContainer);
import org.apache.lucene.search.join.ScoreMode;
        if (nestedQueryProto == null) {
        }  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        boolean ignoreUnmapped = NestedQueryBuilder.DEFAULT_IGNORE_UNMAPPED;
            boost = nestedQueryProto.getBoost();  
                return ScoreMode.Total;  
                innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(nestedQueryProto.getInnerHits(), registry);  
        }
                return ScoreMode.Max;  
     * Similar to {@link NestedQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method  
 * this file be licensed under the Apache-2.0 license or a
     *  
        // Utility class, no instances
            try {
     * Converts a protobuf NestedQuery to an OpenSearch NestedQueryBuilder.
import org.opensearch.transport.grpc.proto.request.search.InnerHitsBuilderProtoUtils;  
            queryName = nestedQueryProto.getXName();
                return ScoreMode.Avg; // Default value
        if (path.isEmpty()) {
import org.opensearch.index.query.InnerHitBuilder;  
import org.opensearch.protobufs.QueryContainer;
        }
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
import org.opensearch.protobufs.NestedQuery;
     */  
            throw new IllegalArgumentException("Failed to convert inner query for NestedQuery: " + e.getMessage(), e);  
        InnerHitBuilder innerHitBuilder = null;  
            scoreMode = parseScoreMode(nestedQueryProto.getScoreMode());
    }
 * SPDX-License-Identifier: Apache-2.0
        try {
import org.opensearch.index.query.AbstractQueryBuilder;
    /**
    /**
        }
        if (nestedQueryProto.hasBoost()) {
            case CHILD_SCORE_MODE_MIN:
import org.opensearch.protobufs.ChildScoreMode;  
            throw new IllegalArgumentException("NestedQuery cannot be null");
        String path = nestedQueryProto.getPath();  
        }
    static NestedQueryBuilder fromProto(NestedQuery nestedQueryProto, QueryBuilderProtoConverterRegistry registry) {  
        if (nestedQueryProto.hasInnerHits()) {
        switch (childScoreMode) {
 *
        }
                return ScoreMode.Min;
}
     * parses the Protocol Buffer representation and creates a properly configured
            case CHILD_SCORE_MODE_NONE:  
class NestedQueryBuilderProtoUtils {
        String queryName = null;
            case CHILD_SCORE_MODE_SUM:
 */  
     */
            throw new IllegalArgumentException("Path is required for NestedQuery");
        }
            default:
    private static ScoreMode parseScoreMode(ChildScoreMode childScoreMode) {
 */  
            ignoreUnmapped = nestedQueryProto.getIgnoreUnmapped();
import org.opensearch.index.query.NestedQueryBuilder;
        } catch (Exception e) {
     * @throws IllegalArgumentException if the protobuf query is invalid
        ScoreMode scoreMode = ScoreMode.Avg;  
            .boost(boost);
/*  
        NestedQueryBuilder queryBuilder = new NestedQueryBuilder(path, query, scoreMode, innerHitBuilder).ignoreUnmapped(ignoreUnmapped)  
        }  
package org.opensearch.transport.grpc.proto.request.search.query;
        }  
        if (nestedQueryProto.hasScoreMode()) {  
        return queryBuilder;
                return ScoreMode.Avg;
     * @param nestedQueryProto the protobuf NestedQuery to convert
        if (!nestedQueryProto.hasQuery()) {
     * @return the converted OpenSearch NestedQueryBuilder  
        QueryBuilder query = null;
import org.opensearch.index.query.QueryBuilder;
        if (nestedQueryProto.hasIgnoreUnmapped()) {
 * Handles the conversion of nested query protobuf messages to OpenSearch NestedQueryBuilder objects.
            throw new IllegalArgumentException("Query is required for NestedQuery");  
     * @return the converted Lucene ScoreMode
 * Utility class for converting protobuf NestedQuery to OpenSearch NestedQueryBuilder.
 * The OpenSearch Contributors require contributions made to  
            QueryContainer queryContainer = nestedQueryProto.getQuery();  
            }  
            case CHILD_SCORE_MODE_AVG:  
     * Converts protobuf ChildScoreMode to Lucene ScoreMode.
    }
/**  
     * NestedQueryBuilder with the appropriate path, query, score mode, inner hits, boost, and query name.
            case CHILD_SCORE_MODE_MAX:
            .queryName(queryName)
                throw new IllegalArgumentException("Failed to convert inner hits for NestedQuery: " + e.getMessage(), e);
     * @param registry The registry to use for converting nested queries
    private NestedQueryBuilderProtoUtils() {  
     *  
        if (nestedQueryProto.hasXName()) {  
            } catch (Exception e) {
 * compatible open source license.
     * @param childScoreMode the protobuf ChildScoreMode
    }

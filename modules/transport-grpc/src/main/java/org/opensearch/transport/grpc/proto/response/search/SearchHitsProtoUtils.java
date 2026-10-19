        // Process individual hits
     *
 * This class handles the conversion of search operation responses to their
     * Helper method to process individual hits.
 */  
    private static void processTotalHits(SearchHits hits, org.opensearch.protobufs.HitsMetadata.Builder hitsMetaData) {
                ? org.opensearch.protobufs.TotalHitsRelation.TOTAL_HITS_RELATION_EQ  
     * @param hits The SearchHits to convert
        }
     */
        org.opensearch.protobufs.HitsMetadataTotal.Builder totalBuilder = org.opensearch.protobufs.HitsMetadataTotal.newBuilder();  
/**  
    protected static void toProto(SearchHits hits, org.opensearch.protobufs.HitsMetadata.Builder hitsMetaData) throws IOException {  
    }  
     * @return A Protocol Buffer HitsMetadata representation
        // Utility class, no instances
    /**
    protected static org.opensearch.protobufs.HitsMetadata toProto(SearchHits hits) throws IOException {
 * The OpenSearch Contributors require contributions made to  
     *  
            org.opensearch.protobufs.TotalHits.Builder totalHitsBuilder = org.opensearch.protobufs.TotalHits.newBuilder();
        return hitsMetaData.build();
        processHits(hits, hitsMetaData);
import org.opensearch.core.xcontent.XContentBuilder;
     *  
        for (SearchHit hit : hits) {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
     * This method is equivalent to {@link SearchHits#toXContent(XContentBuilder, ToXContent.Params)}  
     * @throws IOException if there's an error during conversion
    /**
            hitsMetaData.addHits(hitBuilder.build());
    private static void processMaxScore(SearchHits hits, org.opensearch.protobufs.HitsMetadata.Builder hitsMetaData) {
     * @param hits The SearchHits to process
        org.opensearch.protobufs.HitsMetadata.Builder hitsMetaData = org.opensearch.protobufs.HitsMetadata.newBuilder();
import org.opensearch.search.SearchHits;
     */  
 */
    }
        hitsMetaData.setMaxScore(maxScoreBuilder.build());
                : org.opensearch.protobufs.TotalHitsRelation.TOTAL_HITS_RELATION_GTE;
        // Process max score information
 * this file be licensed under the Apache-2.0 license or a
    /**
 * Utility class for converting SearchHits objects to Protocol Buffers.
            long total = hits.getTotalHits() == null ? -1 : hits.getTotalHits().value();
            org.opensearch.protobufs.TotalHitsRelation relation = hits.getTotalHits().relation() == TotalHits.Relation.EQUAL_TO
        org.opensearch.protobufs.HitsMetadataMaxScore.Builder maxScoreBuilder = org.opensearch.protobufs.HitsMetadataMaxScore.newBuilder();
     * @param hits The SearchHits to process
     * @throws IOException if there's an error during conversion  
    }
import org.apache.lucene.search.TotalHits;  
            totalBuilder.setInt64(total);
 *
            maxScoreBuilder.setNullValue(NullValue.NULL_VALUE_NULL);
    /**
     * @throws IOException if there's an error during conversion
        // Process each hit  
     * Helper method to process max score information.
    /**
    }
public class SearchHitsProtoUtils {
            // Set relation based on the TotalHits relation
            totalHitsBuilder.setRelation(relation);
        if (totalHitAsInt) {  
     * This method is equivalent to {@link SearchHits#toXContent(XContentBuilder, ToXContent.Params)}
     * @param hits The SearchHits to process
        processMaxScore(hits, hitsMetaData);
     */
        if (Float.isNaN(hits.getMaxScore())) {
import org.opensearch.protobufs.NullValue;  
        hitsMetaData.setTotal(totalBuilder.build());
     */
    }  
            org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder = org.opensearch.protobufs.HitsMetadataHitsInner.newBuilder();
        // TODO need to pass parameters
     * @param hits The SearchHits to convert  
     * @param hitsMetaData The builder to populate with the SearchHits data  
        } else {  
import java.io.IOException;
 * Protocol Buffer representation.  
        toProto(hits, hitsMetaData);  
            maxScoreBuilder.setFloat(hits.getMaxScore());
     * @param hitsMetaData The builder to populate with the total hits data  
        }
     * @param hitsMetaData The builder to populate with the max score data
        processTotalHits(hits, hitsMetaData);
        // boolean totalHitAsInt = params.paramAsBoolean(RestSearchAction.TOTAL_HITS_AS_INT_PARAM, false);  
            SearchHitProtoUtils.toProto(hit, hitBuilder);  
}
     * @param hitsMetaData The builder to populate with the hits data
            totalBuilder.setTotalHits(totalHitsBuilder.build());
/*  
        }
import org.opensearch.core.xcontent.ToXContent;
     *
     *
    private SearchHitsProtoUtils() {
     * Converts a SearchHits to its Protocol Buffer representation.
     */  
            totalHitsBuilder.setValue(hits.getTotalHits().value());
        // Process total hits information
     * Helper method to process total hits information.  
    private static void processHits(SearchHits hits, org.opensearch.protobufs.HitsMetadata.Builder hitsMetaData) throws IOException {
        } else if (hits.getTotalHits() != null) {  
package org.opensearch.transport.grpc.proto.response.search;
import org.opensearch.search.SearchHit;
        boolean totalHitAsInt = false;
    }  
     * Converts a SearchHits to its Protocol Buffer representation.  

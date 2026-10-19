import org.opensearch.search.sort.ScoreSortBuilder;
package org.opensearch.transport.grpc.proto.request.search.sort;
     * with the appropriate sort order settings.
        }  
import org.opensearch.transport.grpc.util.ProtobufEnumUtils;  
            throw new IllegalArgumentException("ScoreSort cannot be null");
 * this file be licensed under the Apache-2.0 license or a
 * Utility class for converting ScoreSort Protocol Buffers to OpenSearch ScoreSortBuilder objects.  
public class ScoreSortProtoUtils {
 * Similar to {@link ScoreSortBuilder#fromXContent}, this class handles the conversion of
    }  
 * score-based sorting and sort order settings.  
    public static ScoreSortBuilder fromProto(ScoreSort scoreSort) {
 */  
 * compatible open source license.
 * Protocol Buffer representations to properly configured ScoreSortBuilder objects with
        if (scoreSort == null) {  
 * SPDX-License-Identifier: Apache-2.0
     * Protocol Buffer representation and creates a properly configured ScoreSortBuilder
     */
     * Converts a Protocol Buffer ScoreSort to a ScoreSortBuilder.
 * The OpenSearch Contributors require contributions made to  
            builder.order(order);
     * @throws IllegalArgumentException if scoreSort is null  
import org.opensearch.protobufs.ScoreSort;  
        ScoreSortBuilder builder = new ScoreSortBuilder();
 * @opensearch.internal
     * @return A configured ScoreSortBuilder
            SortOrder order = SortOrder.fromString(ProtobufEnumUtils.convertToString(scoreSort.getOrder()));
 */  
import org.opensearch.search.sort.SortOrder;
        if (scoreSort.hasOrder() && scoreSort.getOrder() != org.opensearch.protobufs.SortOrder.SORT_ORDER_UNSPECIFIED) {  
    private ScoreSortProtoUtils() {  
        // Utility class
     * Similar to {@link ScoreSortBuilder#fromXContent}, this method parses the  
     * @param scoreSort The Protocol Buffer ScoreSort to convert
/*  
 *
    }
        }
}
     *  
        return builder;
    /**
 *
/**

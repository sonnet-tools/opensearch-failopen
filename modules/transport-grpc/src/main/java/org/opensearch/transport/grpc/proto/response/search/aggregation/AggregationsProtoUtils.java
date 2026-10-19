 */  
        Aggregations aggregations,
        for (Aggregation agg : aggregations.asList()) {
import org.opensearch.search.aggregations.Aggregations;
     * @see Aggregations#toXContentInternal
package org.opensearch.transport.grpc.proto.response.search.aggregation;
     *  
    /**
 * SPDX-License-Identifier: Apache-2.0
     * <p>Mirrors {@link Aggregations#toXContentInternal} which iterates through
        }  
     * @param builder The SearchResponse builder to populate
 * compatible open source license.
        }
 * Converts Aggregations collection to protobuf map.
import java.io.IOException;
    }
}
/*  
     * aggregations and serializes each one.
    ) throws IOException {
    private AggregationsProtoUtils() {  
        AggregateProtoConverterRegistry registry
    public static void toProto(
            return;
public class AggregationsProtoUtils {
    }
     * Converts Aggregations to protobuf map entries.
            builder.putAggregations(agg.getName(), AggregateProtoUtils.toProto(agg, registry));
 *
     */  
        org.opensearch.protobufs.SearchResponse.Builder builder,  
 * this file be licensed under the Apache-2.0 license or a
     * @param aggregations The aggregations collection (can be null)
        // Utility class
/**
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;  
import org.opensearch.search.aggregations.Aggregation;
        if (aggregations == null) {  
     * @throws IOException if an error occurs during conversion
     *  
     * @param registry The converter registry for dispatching to the appropriate converter  
 * The OpenSearch Contributors require contributions made to  
 */  

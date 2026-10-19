    /**
        }  
     * Mirrors REST-side {@link InternalAggregation#toXContent}.  
    /**  
     * @throws IllegalArgumentException if aggregation is null, not an InternalAggregation, or type is not supported
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;
     */  
     *
 * Converts InternalAggregation to Aggregate protobuf.
     * @param aggregation the source aggregation
     * @param registry The converter registry for dispatching to the appropriate converter  
            }  
        return registry.toProto((InternalAggregation) aggregation);  
            if (metaValue.hasObjectMap()) {
 */  
import org.opensearch.search.aggregations.Aggregation;
    }
                metaSetter.accept(metaValue.getObjectMap());
}
import java.util.function.Consumer;
    }  
     * @param aggregation The OpenSearch aggregation (must not be null)
        if (aggregation.getMetadata() != null && !aggregation.getMetadata().isEmpty()) {
     *
import org.opensearch.protobufs.Aggregate;  
    public static void addMetadata(Consumer<ObjectMap> metaSetter, InternalAggregation aggregation) {
     * Adds metadata from an InternalAggregation to a typed aggregate builder
            throw new IllegalArgumentException("Aggregation must not be null");
 * compatible open source license.
/*  
     * @throws IOException if an error occurs during protobuf conversion  
     * @see InternalAggregation#toXContent
     * @return The corresponding Protocol Buffer Aggregate message
        }
     * <p>Delegates to the registry for extensible converter dispatch.
     *  
package org.opensearch.transport.grpc.proto.response.search.aggregation;
     * via the provided setter function.
public class AggregateProtoUtils {
 * this file be licensed under the Apache-2.0 license or a
 *
            ObjectMap.Value metaValue = ObjectMapProtoUtils.toProto(aggregation.getMetadata());  
     * Converts an Aggregation to Aggregate protobuf.  
            throw new IllegalArgumentException("Only InternalAggregation types are supported");  
    public static Aggregate toProto(Aggregation aggregation, AggregateProtoConverterRegistry registry) throws IOException {  
 */
/**
import org.opensearch.protobufs.ObjectMap;
        }
    private AggregateProtoUtils() {
 * Uses a registry pattern for extensible converter dispatch.  
import java.io.IOException;
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
 * The OpenSearch Contributors require contributions made to  
     * @param metaSetter the setMeta method reference on the typed builder
        if (aggregation == null) {
        // Utility class - no instances
 * SPDX-License-Identifier: Apache-2.0
        if (!(aggregation instanceof InternalAggregation)) {
     */
    }
import org.opensearch.search.aggregations.InternalAggregation;  

     */
package org.opensearch.transport.grpc.spi;
 * SPDX-License-Identifier: Apache-2.0
 */  
 *
     * @throws IOException if an error occurs during protobuf conversion
 * Follows the same pattern as {@link AggregationBuilderProtoConverter} for request-side conversions.
 * this file be licensed under the Apache-2.0 license or a
     */  
     * Returns the InternalAggregation subclass this converter handles.
     *
     */  
    /**  
import org.opensearch.search.aggregations.InternalAggregation;
     * Converts an InternalAggregation to its Protocol Buffer Aggregate.Builder representation.
 * compatible open source license.
    Class<? extends InternalAggregation> getHandledAggregationType();
/*  
     * Returns a builder to allow the registry to construct the final Aggregate.  
     * @return The class type of the aggregation this converter supports  
    default void setRegistry(AggregateProtoConverterRegistry registry) {}
     * @param registry the converter registry
 */  
import java.io.IOException;
    /**  
public interface AggregateProtoConverter {
/**  
    /**
}
import org.opensearch.protobufs.Aggregate;
 * SPI interface for converting OpenSearch InternalAggregation objects to Protocol Buffer Aggregate messages.
     * Mirrors REST-side {@link InternalAggregation#toXContent}
     * @return An Aggregate.Builder with the aggregation-specific fields populated
     * @param aggregation The InternalAggregation to convert (guaranteed to be of the handled type)  
     * Sets the registry for nested aggregations. Default no-op for metric aggregations.
     *
    Aggregate.Builder toProto(InternalAggregation aggregation) throws IOException;
 * The OpenSearch Contributors require contributions made to  

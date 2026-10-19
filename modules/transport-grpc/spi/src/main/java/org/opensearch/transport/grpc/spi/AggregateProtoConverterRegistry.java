package org.opensearch.transport.grpc.spi;
 * SPI interface for the aggregate converter registry.
 * SPDX-License-Identifier: Apache-2.0
     * @return The corresponding Protocol Buffer Aggregate message
 * The OpenSearch Contributors require contributions made to  
 *
     * Converts an InternalAggregation to its Protocol Buffer Aggregate representation.
}
 * Provides the main entry point for converting InternalAggregation objects to Protocol Buffer Aggregate messages.
    /**  
import org.opensearch.protobufs.Aggregate;
    Aggregate toProto(InternalAggregation aggregation) throws IOException;  
 * this file be licensed under the Apache-2.0 license or a
public interface AggregateProtoConverterRegistry {
/**  
     */
 */  
import java.io.IOException;
 */  
import org.opensearch.search.aggregations.InternalAggregation;
     * @throws IllegalArgumentException if aggregation is null or type is not supported  
 * compatible open source license.
     *  
/*  
     * Handles metadata and delegates to the appropriate converter.
     * @param aggregation The InternalAggregation to convert (must not be null)
     * @throws IOException if an error occurs during protobuf conversion

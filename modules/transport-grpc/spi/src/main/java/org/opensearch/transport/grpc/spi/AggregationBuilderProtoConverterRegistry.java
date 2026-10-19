}
 * The OpenSearch Contributors require contributions made to  
     * @param name The aggregation name
    AggregationBuilder fromProto(String name, AggregationContainer container);  
    /**
import org.opensearch.search.aggregations.AggregationBuilder;
     */
     * Similar to {@link AggregatorFactories#parseAggregators}.  
 *
     * Converts a protobuf aggregation container to an OpenSearch AggregationBuilder.
 * @see AggregatorFactories#parseAggregators  
 * SPI interface for the aggregation converter registry.  
     * @param container The protobuf container  
 * compatible open source license.
 * Handles converter lookup, metadata, and recursive subaggregation parsing.
public interface AggregationBuilderProtoConverterRegistry {
 */  
 */
import org.opensearch.search.aggregations.AggregatorFactories;  
/**
/*  
package org.opensearch.transport.grpc.spi;
 *
     *
 * this file be licensed under the Apache-2.0 license or a
     * @return The AggregationBuilder with metadata and subaggregations
import org.opensearch.protobufs.AggregationContainer;
 * SPDX-License-Identifier: Apache-2.0

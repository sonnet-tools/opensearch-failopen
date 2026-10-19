 * @see AggregatorFactories#parseAggregators  
 * SPDX-License-Identifier: Apache-2.0
 * Follows the same pattern as {@link QueryBuilderProtoConverter}.
 * SPI interface for converting protobuf aggregation containers to OpenSearch AggregationBuilders.  
package org.opensearch.transport.grpc.spi;
     * Returns the aggregation case this converter handles.
import org.opensearch.search.aggregations.AggregatorFactories;  
    /**
public interface AggregationBuilderProtoConverter {
/*  
     */
     * @param registry the converter registry  
 * compatible open source license.
    AggregationBuilder fromProto(String name, AggregationContainer container);
     * Similar to {@link AggregatorFactories.Builder#addAggregator}.
     */  
    /**  
 *
import org.opensearch.search.aggregations.AggregationBuilder;
 * <p>The registry handles metadata and subaggregations. Converters should delegate to existing  
 * The OpenSearch Contributors require contributions made to  
 *
     *  
/**
}  
import org.opensearch.protobufs.AggregationContainer;
     */
    default void setRegistry(AggregationBuilderProtoConverterRegistry registry) {}
     * Sets the registry for nested aggregations. Default no-op for metric aggregations.
 */  
     * @return The OpenSearch AggregationBuilder  
    AggregationContainer.AggregationContainerCase getHandledAggregationCase();
     * @param name The aggregation name
     * Converts a protobuf aggregation container to an AggregationBuilder.
     * @param container The protobuf container
 *
 * {@code *ProtoUtils} classes.
 */
    /**
 * this file be licensed under the Apache-2.0 license or a

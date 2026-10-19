    public AggregationContainer.AggregationContainerCase getHandledAggregationCase() {  
}
    }  
    public AggregationBuilder fromProto(String name, AggregationContainer container) {
    /**
import org.opensearch.protobufs.AggregationContainer;  
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverter;  
        if (!container.hasMin()) {
        return MinAggregationProtoUtils.fromProto(name, container.getMin());
/*  
 * The OpenSearch Contributors require contributions made to  
    public MinAggregationBuilderProtoConverter() {
     * Equivalent to REST parsing via {@link MinAggregationBuilder#PARSER}.  
     */  
    @Override  
 */  
            throw new IllegalArgumentException("Container does not contain Min aggregation");  
 *
    }
import org.opensearch.search.aggregations.AggregationBuilder;
 * Converter for Min aggregation.  
     */
     * @return the constructed {@link MinAggregationBuilder}
    /**
     * @param name the aggregation name
        // Default constructor
public class MinAggregationBuilderProtoConverter implements AggregationBuilderProtoConverter {
     * Converts protobuf MinAggregation to {@link MinAggregationBuilder}.
     * Constructs a new MinAggregationBuilderProtoConverter.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
 * compatible open source license.
package org.opensearch.transport.grpc.proto.request.search.aggregation.metrics;
/**
 */
     *
    }  
        return AggregationContainer.AggregationContainerCase.MIN;
     * @param container the protobuf aggregation container  
 * SPDX-License-Identifier: Apache-2.0
    @Override
        }

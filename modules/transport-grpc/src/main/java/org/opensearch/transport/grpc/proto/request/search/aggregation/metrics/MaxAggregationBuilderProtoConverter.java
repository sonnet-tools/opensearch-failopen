        }
package org.opensearch.transport.grpc.proto.request.search.aggregation.metrics;
import org.opensearch.search.aggregations.AggregationBuilder;
/*  
    @Override
     * @param name the aggregation name
}
            throw new IllegalArgumentException("Container does not contain Max aggregation");  
     */
 */  
    public MaxAggregationBuilderProtoConverter() {
    /**
        return MaxAggregationProtoUtils.fromProto(name, container.getMax());
     * @return the constructed {@link MaxAggregationBuilder}
 * SPDX-License-Identifier: Apache-2.0
     * Constructs a new MaxAggregationBuilderProtoConverter.
    /**
public class MaxAggregationBuilderProtoConverter implements AggregationBuilderProtoConverter {
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverter;  
    }  
import org.opensearch.protobufs.AggregationContainer;  
    @Override  
 * Converter for Max aggregation.  
 * The OpenSearch Contributors require contributions made to  
     * @param container the protobuf aggregation container  
     *
        // Default constructor
     * Converts protobuf MaxAggregation to {@link MaxAggregationBuilder}.
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
 *
     */  
    }
        if (!container.hasMax()) {
/**
    }  
     * Equivalent to REST parsing via {@link MaxAggregationBuilder#PARSER}.  
        return AggregationContainer.AggregationContainerCase.MAX;
 * compatible open source license.
 */
    public AggregationContainer.AggregationContainerCase getHandledAggregationCase() {  
 * this file be licensed under the Apache-2.0 license or a
    public AggregationBuilder fromProto(String name, AggregationContainer container) {

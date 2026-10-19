 */  
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.protobufs.Aggregate;  
        return Aggregate.newBuilder().setMin(MinAggregateProtoUtils.toProto((InternalMin) aggregation));  
import org.opensearch.search.aggregations.metrics.InternalMin;
    }
}
    public Class<? extends InternalAggregation> getHandledAggregationType() {  
public class MinAggregateProtoConverter implements AggregateProtoConverter {
 * Converter for {@link InternalMin} aggregations to Protocol Buffer Aggregate messages.
package org.opensearch.transport.grpc.proto.response.search.aggregation.metrics;
        return InternalMin.class;
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;  
    }
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
     * Creates a new MinAggregateProtoConverter.
    public MinAggregateProtoConverter() {}  
    @Override
/*  
    @Override
/**
     */
    /**  
 * The OpenSearch Contributors require contributions made to  
 *
    public Aggregate.Builder toProto(InternalAggregation aggregation) throws IOException {
 * compatible open source license.
 */  
 * this file be licensed under the Apache-2.0 license or a

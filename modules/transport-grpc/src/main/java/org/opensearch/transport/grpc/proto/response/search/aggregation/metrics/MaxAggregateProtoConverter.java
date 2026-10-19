import org.opensearch.protobufs.Aggregate;  
}
/*  
 * this file be licensed under the Apache-2.0 license or a
     */
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;  
    }
    @Override
 * compatible open source license.
    public Class<? extends InternalAggregation> getHandledAggregationType() {  
     * Creates a new MaxAggregateProtoConverter.
import org.opensearch.search.aggregations.metrics.InternalMax;
    public Aggregate.Builder toProto(InternalAggregation aggregation) throws IOException {
package org.opensearch.transport.grpc.proto.response.search.aggregation.metrics;
public class MaxAggregateProtoConverter implements AggregateProtoConverter {
 */  
    @Override
 *
 * Converter for {@link InternalMax} aggregations to Protocol Buffer Aggregate messages.
    /**  
import java.io.IOException;
 */  
        return InternalMax.class;
    }
/**
        return Aggregate.newBuilder().setMax(MaxAggregateProtoUtils.toProto((InternalMax) aggregation));  
import org.opensearch.search.aggregations.InternalAggregation;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    public MaxAggregateProtoConverter() {}  

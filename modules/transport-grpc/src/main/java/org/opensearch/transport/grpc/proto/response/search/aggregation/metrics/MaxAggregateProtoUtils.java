 */  
        }
    public static SingleMetricAggregateBase toProto(InternalMax internalMax) {
import org.opensearch.protobufs.NullValue;  
 *
import org.opensearch.protobufs.SingleMetricAggregateBase;
    private MaxAggregateProtoUtils() {
     * @param internalMax The InternalMax aggregation result from OpenSearch
     * @return SingleMetricAggregateBase proto with value, value_as_string, and metadata
        // Utility class
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoUtils;
     * Converts an InternalMax aggregation result to SingleMetricAggregateBase proto.  
     *  
 * SPDX-License-Identifier: Apache-2.0
            builder.setValueAsString(internalMax.getValueAsString());
 * compatible open source license.
        if (hasValue) {
     * @see InternalMax#doXContentBody  
        builder.setValue(valueBuilder.build());
        AggregateProtoUtils.addMetadata(builder::setMeta, internalMax);
        } else {
public class MaxAggregateProtoUtils {
 * {@link SingleMetricAggregateBase} protocol buffer format.  
        }  
 * The OpenSearch Contributors require contributions made to  
    }  
/*  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.DocValueFormat;  
    /**
    }
 * Utility class for converting {@link InternalMax} aggregation results to
     * <p>Mirrors {@link InternalMax#doXContentBody} structure exactly.
 */
        return builder.build();
        SingleMetricAggregateBase.Builder builder = SingleMetricAggregateBase.newBuilder();  
        if (hasValue && internalMax.getFormat() != DocValueFormat.RAW) {  
        SingleMetricAggregateBaseAllOfValue.Builder valueBuilder = SingleMetricAggregateBaseAllOfValue.newBuilder();
     *
}  
            valueBuilder.setNullValue(NullValue.NULL_VALUE_NULL);
/**
import org.opensearch.search.aggregations.metrics.InternalMax;
     */
import org.opensearch.protobufs.SingleMetricAggregateBaseAllOfValue;
package org.opensearch.transport.grpc.proto.response.search.aggregation.metrics;
        boolean hasValue = Double.isFinite(max);
        double max = internalMax.getValue();
            valueBuilder.setDouble(max);  

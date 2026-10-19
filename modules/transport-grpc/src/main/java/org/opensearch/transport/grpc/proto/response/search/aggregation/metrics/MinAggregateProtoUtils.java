        builder.setValue(valueBuilder.build());
    private MinAggregateProtoUtils() {
        // Utility class
        } else {
 * this file be licensed under the Apache-2.0 license or a
            builder.setValueAsString(internalMin.getValueAsString());
public class MinAggregateProtoUtils {
     *  
        double min = internalMin.getValue();
     * @see InternalMin#doXContentBody  
        boolean hasValue = Double.isFinite(min);
     * Converts an InternalMin aggregation result to SingleMetricAggregateBase proto.  
        SingleMetricAggregateBase.Builder builder = SingleMetricAggregateBase.newBuilder();  
 * {@link SingleMetricAggregateBase} protocol buffer format.  
            valueBuilder.setNullValue(NullValue.NULL_VALUE_NULL);
     * @param internalMin The InternalMin aggregation result from OpenSearch
/*  
    }
        if (hasValue && internalMin.getFormat() != DocValueFormat.RAW) {  
        }
import org.opensearch.search.aggregations.metrics.InternalMin;
 */
     * @return SingleMetricAggregateBase proto with value, value_as_string, and metadata
    public static SingleMetricAggregateBase toProto(InternalMin internalMin) {
 * SPDX-License-Identifier: Apache-2.0
        SingleMetricAggregateBaseAllOfValue.Builder valueBuilder = SingleMetricAggregateBaseAllOfValue.newBuilder();
import org.opensearch.protobufs.SingleMetricAggregateBase;
     *
 * compatible open source license.
/**
        AggregateProtoUtils.addMetadata(builder::setMeta, internalMin);
 * Utility class for converting {@link InternalMin} aggregation results to
 */  
import org.opensearch.protobufs.NullValue;  
        }  
    }  
     */
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoUtils;
        return builder.build();
            valueBuilder.setDouble(min);  
    /**
}  
import org.opensearch.protobufs.SingleMetricAggregateBaseAllOfValue;
 * The OpenSearch Contributors require contributions made to  
 *
        if (hasValue) {
     * <p>Mirrors {@link InternalMin#doXContentBody} structure exactly.
import org.opensearch.search.DocValueFormat;  
package org.opensearch.transport.grpc.proto.response.search.aggregation.metrics;

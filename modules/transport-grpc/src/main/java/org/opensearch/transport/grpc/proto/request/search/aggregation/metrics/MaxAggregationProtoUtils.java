        MaxAggregationBuilder builder = new MaxAggregationBuilder(name);
        return builder;
            .valueType(maxAggProto.hasValueType() ? maxAggProto.getValueType() : null)
    /**
import org.opensearch.transport.grpc.proto.request.search.aggregation.support.ValuesSourceAggregationProtoUtils;  
            /* scriptable= */ true,  
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder()
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
import org.opensearch.transport.grpc.proto.request.search.aggregation.support.ValuesSourceProtoFields;
     * <p>This method parallels the REST parsing logic in {@link MaxAggregationBuilder#PARSER},
}
 *
     * @param maxAggProto The Protocol Buffer MaxAggregation to convert
        );  
            .build();
     * processing fields in the exact same sequence to ensure consistent validation and behavior.
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
 */  
     * Converts a Protocol Buffer MaxAggregation to a MaxAggregationBuilder.
     * @return A configured MaxAggregationBuilder  
        // Utility class
 * The OpenSearch Contributors require contributions made to  
 */  
    public static MaxAggregationBuilder fromProto(String name, MaxAggregation maxAggProto) {  
 * Utility class for converting MaxAggregation Protocol Buffers to MaxAggregationBuilder.
/*  
            /* formattable= */ true,
 * compatible open source license.
            builder,
     * @param name The name of the aggregation
package org.opensearch.transport.grpc.proto.request.search.aggregation.metrics;
     * @throws IllegalArgumentException if required fields are missing or validation fails
    }
            fields,
            .field(maxAggProto.hasField() ? maxAggProto.getField() : null)
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException("MaxAggregation proto must not be null");
     *  
            .format(maxAggProto.hasFormat() ? maxAggProto.getFormat() : null)
/**
            .script(maxAggProto.hasScript() ? ScriptProtoUtils.parseFromProtoRequest(maxAggProto.getScript()) : null)  
public class MaxAggregationProtoUtils {
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;
        if (maxAggProto == null) {
import org.opensearch.protobufs.MaxAggregation;  
        }  
    private MaxAggregationProtoUtils() {  
            /* timezoneAware= */ false
    }  
     */
            .missing(maxAggProto.hasMissing() ? FieldValueProtoUtils.fromProto(maxAggProto.getMissing(), false) : null)  
     *  
        ValuesSourceAggregationProtoUtils.declareFields(  

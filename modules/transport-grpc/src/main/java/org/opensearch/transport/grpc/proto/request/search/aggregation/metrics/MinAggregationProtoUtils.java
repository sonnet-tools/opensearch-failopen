    public static MinAggregationBuilder fromProto(String name, MinAggregation minAggProto) {  
     * @param minAggProto The Protocol Buffer MinAggregation to convert
 */  
            /* timezoneAware= */ false
import org.opensearch.protobufs.MinAggregation;  
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
            .valueType(minAggProto.hasValueType() ? minAggProto.getValueType() : null)
 * compatible open source license.
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;
import org.opensearch.transport.grpc.proto.request.search.aggregation.support.ValuesSourceAggregationProtoUtils;  
 * this file be licensed under the Apache-2.0 license or a
            .field(minAggProto.hasField() ? minAggProto.getField() : null)
    }
        // Utility class
     * Converts a Protocol Buffer MinAggregation to a MinAggregationBuilder.
        }  
     * processing fields in the exact same sequence to ensure consistent validation and behavior.
            fields,
    private MinAggregationProtoUtils() {  
     * @param name The name of the aggregation
public class MinAggregationProtoUtils {
import org.opensearch.transport.grpc.proto.request.search.aggregation.support.ValuesSourceProtoFields;
 */  
     */
     *  
        ValuesSourceAggregationProtoUtils.declareFields(  
 * Utility class for converting MinAggregation Protocol Buffers to MinAggregationBuilder.
        return builder;
            .format(minAggProto.hasFormat() ? minAggProto.getFormat() : null)
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
/*  
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("MinAggregation proto must not be null");
 * The OpenSearch Contributors require contributions made to  
    /**
     * @return A configured MinAggregationBuilder  
     * <p>This method parallels the REST parsing logic in {@link MinAggregationBuilder#PARSER},
     * @throws IllegalArgumentException if required fields are missing or validation fails
}
        if (minAggProto == null) {
 *
            /* scriptable= */ true,  
            builder,
            .missing(minAggProto.hasMissing() ? FieldValueProtoUtils.fromProto(minAggProto.getMissing(), false) : null)  
            .script(minAggProto.hasScript() ? ScriptProtoUtils.parseFromProtoRequest(minAggProto.getScript()) : null)  
            /* formattable= */ true,
/**
     *  
package org.opensearch.transport.grpc.proto.request.search.aggregation.metrics;
        MinAggregationBuilder builder = new MinAggregationBuilder(name);
    }  
            .build();
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder()
        );  

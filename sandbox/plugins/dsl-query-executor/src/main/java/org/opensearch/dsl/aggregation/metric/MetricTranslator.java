public interface MetricTranslator<T extends AggregationBuilder> extends AggregationTranslator<T> {
    // to avoid per-row virtual dispatch overhead, and use Arrow-native types once Analytics Core
 * and converts raw result values back to OpenSearch InternalAggregation for response building.  
    /**
 * this file be licensed under the Apache-2.0 license or a
     * @return the Calcite AggregateCall  
     * @param value the raw value (may be null)
import org.apache.calcite.rel.core.AggregateCall;
import org.opensearch.dsl.converter.ConversionException;
     *  
     */
     *  
 */
    AggregateCall toAggregateCall(T agg, RelDataType rowType) throws ConversionException;  
     */
    /**
     * @param name the aggregation name
    InternalAggregation toInternalAggregation(String name, Object value, Map<String, Object> metadata);
}
     * @param agg the metric aggregation builder
     * @return the aggregate field name  
     *        back verbatim in the response like classic search (may be null)
 */  
import org.apache.calcite.rel.type.RelDataType;
import org.opensearch.search.aggregations.InternalAggregation;  
     * Converts the metric aggregation to a Calcite AggregateCall.
     * @throws ConversionException if conversion fails
     * Returns the output field name for this aggregation.  
    // exposes them.  
/*  
 * Translates a metric aggregation (AVG, SUM, MIN, MAX, etc.) to a Calcite AggregateCall,
    // TODO: Revisit signature — accept a stream/iterator of <String,Object> for bulk conversion
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
     */  
package org.opensearch.dsl.aggregation.metric;
     * @param metadata the user-supplied {@code meta} map from the aggregation request, echoed  
 * SPDX-License-Identifier: Apache-2.0
/**
     * @param rowType the index row type for field lookup
     * Converts a raw result value from execution into an OpenSearch InternalAggregation.
    String getAggregateFieldName(T agg);
    /**
import org.opensearch.dsl.aggregation.AggregationTranslator;  
     * @param agg the metric aggregation builder
 *
import org.opensearch.search.aggregations.AggregationBuilder;
     *
     * @return the corresponding InternalAggregation
 * compatible open source license.

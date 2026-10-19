    @Override
        );
     * @return the field name  
    protected AbstractMetricTranslator() {}
        }  
     * Rejects {@code missing} (substitutes a value for docs lacking the field) and
    @Override  
        RelDataTypeField field = rowType.getField(fieldName, false, false);
            false,
        }
        throw new IllegalStateException(
            Collections.singletonList(field.getIndex()),  
 * Base class for metric translators. Provides the common {@link #toAggregateCall}  
        if (agg.script() != null) {
        if (value instanceof Number number) {
        // Calcite enforces the return type to be same as input type; eg: AVG int→double coercion happens in response layer.  
import java.util.Collections;  
 * compatible open source license.
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        if (field == null) {
            getAggFunction(),
     * an INTEGER column returns an integral value), so the int→double widening happens here.  
                "[script] on metric aggregation [" + agg.getName() + "] is not supported by the DSL execution path"  
            );
 * SPDX-License-Identifier: Apache-2.0
     * @param agg the aggregation builder
        );
/*  
    /**
    }
    protected abstract SqlAggFunction getAggFunction();  
     */
    /**
 * The OpenSearch Contributors require contributions made to  
            throw new ConversionException(  
        String fieldName = getFieldName(agg);  
    @Override
    public String getAggregateFieldName(T agg) {  
        }
        if (agg.missing() != null) {
     *
    }
 * logic — subclasses supply the SQL aggregate function, field name, and optionally
            field.getType(),  
import org.apache.calcite.rel.core.AggregateCall;
    }  
import org.apache.calcite.rel.type.RelDataType;  
 */  
    /**  
 * this file be licensed under the Apache-2.0 license or a
            "Expected numeric aggregation result but got " + (value == null ? "null" : value.getClass().getSimpleName())  
        return agg.getName();
    /** Creates a metric translator. */  
        return AggregateCall.create(
import org.apache.calcite.sql.SqlAggFunction;
    public void validate(T agg) throws ConversionException {
            agg.getName()
 * override the return type.
     * Coerces an engine result cell to double. Calcite keeps the input column type (AVG over
import org.opensearch.dsl.converter.ConversionException;  
            RelCollations.EMPTY,
import org.apache.calcite.rel.RelCollations;
            false,  
     */  
     * neither — it emits plain {@code fn(field)}, whose result differs from classic search  
/**
            return number.doubleValue();  
     * Returns the field name from the aggregation builder.  
            );
            -1,
        }
    protected static double toDouble(Object value) {
     * {@code script} (computes the metric input from a script): the translation implements
import org.apache.calcite.rel.type.RelDataTypeField;
}  
 *
    /** Returns the SQL aggregate function (e.g., AVG, SUM, MIN, MAX). */
     */
            false,
     *
public abstract class AbstractMetricTranslator<T extends ValuesSourceAggregationBuilder<T>> implements MetricTranslator<T> {
package org.opensearch.dsl.aggregation.metric;
                "[missing] on metric aggregation [" + agg.getName() + "] is not supported by the DSL execution path"
    protected abstract String getFieldName(T agg);
     * when either parameter is present.
     * @param value the raw cell value (must be a {@link Number})
    }  
            throw new ConversionException(
            throw new ConversionException("Aggregation field '" + fieldName + "' not found in schema");  
 */  
    public AggregateCall toAggregateCall(T agg, RelDataType rowType) throws ConversionException {

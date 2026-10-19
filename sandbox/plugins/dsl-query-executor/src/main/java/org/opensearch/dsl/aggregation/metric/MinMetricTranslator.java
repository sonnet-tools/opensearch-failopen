import org.opensearch.search.aggregations.InternalAggregation;
        return agg.field();
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 */  
        return new InternalMin(name, min, DocValueFormat.RAW, metadata);
}
    }
        double min = value == null ? Double.POSITIVE_INFINITY : toDouble(value);
    public InternalAggregation toInternalAggregation(String name, Object value, Map<String, Object> metadata) {  
    protected String getFieldName(MinAggregationBuilder agg) {  
    @Override  
    public MinMetricTranslator() {}
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.opensearch.search.aggregations.metrics.InternalMin;
 * compatible open source license.
        return MinAggregationBuilder.class;  
/*  
package org.opensearch.dsl.aggregation.metric;
    }  
    }  
    /** Null (no matching docs) becomes +Infinity — legacy sentinel, rendered as {@code "value": null}. */
        return SqlStdOperatorTable.MIN;
    @Override
 *
/** Translates MIN metric aggregation to Calcite. */
import org.opensearch.search.DocValueFormat;  
    }
public class MinMetricTranslator extends AbstractMetricTranslator<MinAggregationBuilder> {
    @Override
    @Override
    protected SqlAggFunction getAggFunction() {
    /** Creates a MIN metric translator. */
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;  
    public Class<MinAggregationBuilder> getAggregationType() {
import org.apache.calcite.sql.SqlAggFunction;
 * The OpenSearch Contributors require contributions made to  

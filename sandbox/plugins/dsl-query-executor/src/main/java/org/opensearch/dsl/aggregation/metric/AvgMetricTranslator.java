    @Override  
        return agg.field();
     * The engine returns the final average; encoded as (sum=value, count=1) so
     */
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.apache.calcite.sql.SqlAggFunction;
    @Override
        return AvgAggregationBuilder.class;  
 * The OpenSearch Contributors require contributions made to  
    /** Creates an AVG metric translator. */
    protected String getFieldName(AvgAggregationBuilder agg) {  
import java.util.Map;
/** Translates AVG metric aggregation to Calcite. */
        if (value == null) {
    public InternalAggregation toInternalAggregation(String name, Object value, Map<String, Object> metadata) {
    }  
import org.opensearch.search.aggregations.metrics.InternalAvg;  
     * count=0, which renders as {@code "value": null} like legacy.
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.search.DocValueFormat;  
     * {@code InternalAvg.getValue()} reproduces it. Null (no matching docs) uses  
    public Class<AvgAggregationBuilder> getAggregationType() {
        }
package org.opensearch.dsl.aggregation.metric;
    protected SqlAggFunction getAggFunction() {
    }
    /**
 * SPDX-License-Identifier: Apache-2.0
        return new InternalAvg(name, toDouble(value), 1, DocValueFormat.RAW, metadata);
 *
 * compatible open source license.
 */  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            return new InternalAvg(name, 0.0, 0, DocValueFormat.RAW, metadata);  
    @Override  
    public AvgMetricTranslator() {}
    }  
        return SqlStdOperatorTable.AVG;
}
    }
public class AvgMetricTranslator extends AbstractMetricTranslator<AvgAggregationBuilder> {
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
    @Override

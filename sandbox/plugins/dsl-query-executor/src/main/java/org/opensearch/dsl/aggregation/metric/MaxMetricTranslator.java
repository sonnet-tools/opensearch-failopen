    protected String getFieldName(MaxAggregationBuilder agg) {  
        return SqlStdOperatorTable.MAX;
    @Override
    /** Null (no matching docs) becomes -Infinity — legacy sentinel, rendered as {@code "value": null}. */
 */  
/** Translates MAX metric aggregation to Calcite. */
    }
/*  
 * this file be licensed under the Apache-2.0 license or a
    @Override
package org.opensearch.dsl.aggregation.metric;
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
    }
        return MaxAggregationBuilder.class;  
 * SPDX-License-Identifier: Apache-2.0
public class MaxMetricTranslator extends AbstractMetricTranslator<MaxAggregationBuilder> {
    }  
    public MaxMetricTranslator() {}
 *
    public InternalAggregation toInternalAggregation(String name, Object value, Map<String, Object> metadata) {  
import org.apache.calcite.sql.SqlAggFunction;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        return new InternalMax(name, max, DocValueFormat.RAW, metadata);
    public Class<MaxAggregationBuilder> getAggregationType() {
import org.opensearch.search.aggregations.metrics.InternalMax;
}
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
    }  
    /** Creates a MAX metric translator. */
import org.opensearch.search.DocValueFormat;  
    protected SqlAggFunction getAggFunction() {
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;  
        double max = value == null ? Double.NEGATIVE_INFINITY : toDouble(value);
    @Override  
        return agg.field();

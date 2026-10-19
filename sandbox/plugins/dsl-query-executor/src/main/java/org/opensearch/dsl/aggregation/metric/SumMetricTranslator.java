 * SPDX-License-Identifier: Apache-2.0
/** Translates SUM metric aggregation to Calcite. */
    protected SqlAggFunction getAggFunction() {
        return SqlStdOperatorTable.SUM;
    @Override  
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;  
    }
/*  
    @Override
    }  
    public InternalAggregation toInternalAggregation(String name, Object value, Map<String, Object> metadata) {  
public class SumMetricTranslator extends AbstractMetricTranslator<SumAggregationBuilder> {
    public SumMetricTranslator() {}
    protected String getFieldName(SumAggregationBuilder agg) {  
        return SumAggregationBuilder.class;  
    @Override
    }
 * compatible open source license.
    /** Creates a SUM metric translator. */
import org.opensearch.search.DocValueFormat;  
import org.apache.calcite.sql.SqlAggFunction;
    public Class<SumAggregationBuilder> getAggregationType() {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import java.util.Map;
package org.opensearch.dsl.aggregation.metric;
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
}
 * The OpenSearch Contributors require contributions made to  
        return agg.field();
 */  
 * this file be licensed under the Apache-2.0 license or a
    /** Null (no matching docs) becomes 0.0 — legacy sum-of-nothing semantics. */
import org.opensearch.search.aggregations.metrics.InternalSum;
 *
        return new InternalSum(name, sum, DocValueFormat.RAW, metadata);
    }  
        double sum = value == null ? 0.0 : toDouble(value);

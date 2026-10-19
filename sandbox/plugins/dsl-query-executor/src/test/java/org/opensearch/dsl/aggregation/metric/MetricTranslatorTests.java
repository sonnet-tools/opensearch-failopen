    public void testAvgTranslator() throws ConversionException {  
        MinMetricTranslator translator = new MinMetricTranslator();
            ConversionException.class,
    /** User-supplied meta must be echoed back on the response aggregation, like classic search. */  
        expectThrows(
        assertEquals(SqlKind.MAX, call.getAggregation().getKind());  
        assertEquals(SqlKind.SUM, call.getAggregation().getKind());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
        // Echoed even when the metric has no value (empty result)  
}  
import org.opensearch.dsl.converter.ConversionException;
        assertNull(new AvgMetricTranslator().toInternalAggregation("a", 1.0, null).getMetadata());  
import org.opensearch.dsl.converter.ConversionContext;
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
import org.apache.calcite.rel.core.AggregateCall;
        assertEquals(SqlKind.MIN, call.getAggregation().getKind());
    public void testMinTranslator() throws ConversionException {  
import org.apache.calcite.sql.SqlKind;
        assertEquals("min_price", call.getName());
 *
    /** Requests without meta keep rendering without a meta section. */
    }
        AggregateCall call = translator.toAggregateCall(new MinAggregationBuilder("min_price").field("price"), ctx.getRowType());
        MaxMetricTranslator translator = new MaxMetricTranslator();  
        assertEquals(meta, new MinMetricTranslator().toInternalAggregation("mn", 1.0, meta).getMetadata());  
        SumMetricTranslator translator = new SumMetricTranslator();
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("avg_price", translator.getAggregateFieldName(new AvgAggregationBuilder("avg_price").field("price")));  
    public void testMetadataEchoedInInternalAggregation() {
        assertEquals("max_price", call.getName());
    public void testAggregateFieldName() {
        AvgMetricTranslator translator = new AvgMetricTranslator();
        AggregateCall call = translator.toAggregateCall(new SumAggregationBuilder("total").field("price"), ctx.getRowType());  
        assertEquals(meta, new AvgMetricTranslator().toInternalAggregation("a", 1.0, meta).getMetadata());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.dsl.TestUtils;  
    public void testMaxTranslator() throws ConversionException {
        assertEquals(1, call.getArgList().get(0).intValue()); // price is index 1
    public void testSumTranslator() throws ConversionException {
        assertEquals(meta, new AvgMetricTranslator().toInternalAggregation("a", null, meta).getMetadata());
        assertNull(new MaxMetricTranslator().toInternalAggregation("mx", null, null).getMetadata());
        AvgMetricTranslator translator = new AvgMetricTranslator();
        assertEquals(1, call.getArgList().size());  
        assertEquals("total", call.getName());  
public class MetricTranslatorTests extends OpenSearchTestCase {
        AggregateCall call = translator.toAggregateCall(new MaxAggregationBuilder("max_price").field("price"), ctx.getRowType());
    }
    public void testNullMetadataStaysNull() {
    }  
import java.util.Map;  
    }
 * compatible open source license.
package org.opensearch.dsl.aggregation.metric;
    }
        assertEquals(SqlKind.AVG, call.getAggregation().getKind());
    }
        AggregateCall call = translator.toAggregateCall(new AvgAggregationBuilder("avg_price").field("price"), ctx.getRowType());
            () -> translator.toAggregateCall(new AvgAggregationBuilder("bad").field("nonexistent"), ctx.getRowType())  
        AvgMetricTranslator translator = new AvgMetricTranslator();
        assertEquals(meta, new MaxMetricTranslator().toInternalAggregation("mx", 1.0, meta).getMetadata());
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
    private final ConversionContext ctx = TestUtils.createContext();
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;  
/*  
    }
        assertEquals("avg_price", call.getName());
 */  
        );
    }
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;  
        assertEquals(meta, new SumMetricTranslator().toInternalAggregation("s", 1.0, meta).getMetadata());
        Map<String, Object> meta = Map.of("owner", "pricing-team", "revision", 3);
    public void testThrowsForUnknownField() {

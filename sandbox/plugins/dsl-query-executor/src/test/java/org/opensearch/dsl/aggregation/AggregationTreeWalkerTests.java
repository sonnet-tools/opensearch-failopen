                .order(BucketOrder.key(true))
        // A plan is defined by its aggregation, not its GROUP BY columns: siblings over the
    }
        // Root: no GROUP BY, no implicit _count  
        List<AggregationBuilder> aggs = List.of(
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;  
        ConversionException e = expectThrows(
        assertEquals(List.of("brand"), result.get(1).getGroupByFieldNames());
            () -> walker.walk(List.of(agg), ctx.getRowType(), ctx.getCluster().getTypeFactory())
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());  
        List<AggregationBuilder> aggs = List.of(new TermsAggregationBuilder("by_brand").field("brand").missing("unknown"));
        List<AggregationBuilder> aggs = List.of(  
            new TermsAggregationBuilder("by_brand").field("brand")
    public void testSameFieldSiblingsGetSeparateBoundedPlans() throws ConversionException {
        assertEquals(List.of("brand"), result.get(0).getGroupByFieldNames());
    }  
            ConversionException.class,
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());  
                    new TermsAggregationBuilder("by_name").field("name")
        assertTrue(result.get(0).getGroupByBitSet().isEmpty());
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
        );
                .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))  
        assertEquals(List.of("avg_price", "total_price"), result.get(0).getAggregateFieldNames());
                )
    }
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());  
        // aggregation's own HAVING-filtered COUNT plan, built by the converter.  
    }
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());  
    public void testBucketOnlyProducesImplicitCount() throws ConversionException {
        );  
        // Brand+name granularity: AVG + implicit _count
        );
        List<AggregationBuilder> aggs = List.of(  
import org.opensearch.test.OpenSearchTestCase;  
            new AvgAggregationBuilder("avg_price").field("price"),  
                .subAggregation(new SumAggregationBuilder("total").field("price"))  
import org.opensearch.dsl.converter.ConversionContext;
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
        assertEquals(List.of("brand", "name"), result.get(1).getGroupByFieldNames());
        // nested levels are bounded per parent instead (ROW_NUMBER over the parent partition).
        assertTrue(result.get(0).getMissingValues().isEmpty());  
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
            ConversionException.class,
        TermsAggregationBuilder agg = new TermsAggregationBuilder("by_brand").field("brand");
        assertEquals(2, result.size());
    }
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
            () -> walker.walk(List.of(agg), ctx.getRowType(), ctx.getCluster().getTypeFactory())  
}
    public void testMetricOnlyHasNoBucketOrders() throws ConversionException {  
        assertEquals(1, result.get(0).getAggregateCalls().size());
        );
        // name granularity: SUM + _count  
        assertEquals(1, result.size());
        assertEquals(List.of("global_avg"), result.get(0).getAggregateFieldNames());  
        ConversionException e = expectThrows(
        agg.includeExclude(new IncludeExclude("Brand.*", null));  
    }
        assertTrue(result.get(0).getAggregateFieldNames().contains("avg_price"));
        // brand granularity: AVG + _count  
        assertEquals(List.of("brand"), result.get(0).getGroupByFieldNames());  
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        // Default terms order is _count desc — should still be collected
        assertEquals(2, result.get(0).getAggregateCalls().size());  
        assertEquals(1, result.size());  
        List<AggregationBuilder> aggs = List.of(
        // Both granularities have bucket orders
    }
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        assertEquals(Map.of("brand", "a"), result.get(0).getMissingValues());
            new SumAggregationBuilder("total_price").field("price")
            new TermsAggregationBuilder("top_brands").field("brand").order(BucketOrder.count(false)),
    public void testValidateRejectsMetricMissing() {
        assertEquals(2, result.size());
    }
    public void testSiblingBucketsProduceSeparateGranularities() throws ConversionException {  
    // ---- Fetch pushdown eligibility, HAVING, and missing (top-K pushdown) ----  
    }  
        );
        assertNull(result.get(0).getPerParentFetch());
        assertEquals(2, result.size());
    }
        expectThrows(ConversionException.class, () -> walker.walk(List.of(agg), ctx.getRowType(), ctx.getCluster().getTypeFactory()));  
        List<AggregationBuilder> aggs = List.of(new HistogramAggregationBuilder("by_price").field("price").interval(100));
    }  
            () -> walker.walk(List.of(agg), ctx.getRowType(), ctx.getCluster().getTypeFactory())
        assertFalse(result.get(0).hasBucketOrders());
        assertTrue(result.get(0).getGroupByBitSet().get(2)); // brand is index 2
        assertEquals(2, result.get(1).getAggregateCalls().size());
            new TermsAggregationBuilder("by_brand").field("brand").subAggregation(new AvgAggregationBuilder("brand_avg").field("price"))  
    public void testBucketWithMetric() throws ConversionException {
        assertEquals(Map.of("brand", "unknown"), result.get(0).getMissingValues());
    public void testThrowsForUnsupportedAggregation() {  
        assertEquals(List.of("brand"), result.get(0).getGroupByFieldNames());
        );
        List<AggregationBuilder> aggs = List.of(
        // Separate plans per sibling: each substitutes its own missing value — no conflict possible.
        // A flat LIMIT on the child level would keep top groups globally, not per parent —
    }
        // Brand granularity: SUM + implicit _count
    }
 */  
 *
public class AggregationTreeWalkerTests extends OpenSearchTestCase {
        assertNotNull(result.get(0).getFetch());  
    public void testMetricAtMultipleGranularities() throws ConversionException {  
            new TermsAggregationBuilder("by_brand").field("brand")
        assertTrue(e.getMessage().contains("missing"));
import org.opensearch.dsl.TestUtils;
        assertEquals(1, result.size());  
        TermsAggregationBuilder agg = new TermsAggregationBuilder("by_brand").script(new Script("doc['brand'].value"));
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
 * compatible open source license.
    }
            new TermsAggregationBuilder("by_name").field("name").subAggregation(new SumAggregationBuilder("name_total").field("price"))  
        );
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        // avg_price + implicit _count
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());  
                .subAggregation(  
        List<AggregationBuilder> aggs = List.of(
        assertTrue(result.get(0).hasBucketOrders());
    public void testRootTermsGranularityGetsFetch() throws ConversionException {
    }
        assertEquals("avg_price", result.get(0).getAggregateFieldNames().get(0));
    }
        );
                )
    private final AggregationTreeWalker walker = new AggregationTreeWalker(AggregationRegistryFactory.create());
    private final ConversionContext ctx = TestUtils.createContext();
        List<AggregationBuilder> aggs = List.of(new AvgAggregationBuilder("avg_price").field("price"));
    public void testNestedBucketsCollectOrdersPerGranularity() throws ConversionException {
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
    }
        List<AggregationBuilder> aggs = List.of(new TermsAggregationBuilder("by_brand").field("brand").minDocCount(5));
        assertEquals(List.of("brand", "name"), result.get(1).getGroupByFieldNames());
/*  
        assertNotNull("root level carries the flat limit", result.get(0).getFetch());  
        List<AggregationBuilder> aggs = List.of(new TermsAggregationBuilder("by_brand").field("brand"));  
    }
    // ---- Parameter gate: silently ignored parameters must reject loudly ----
    public void testMissingCapturedAndFetchKept() throws ConversionException {  
                        .order(BucketOrder.key(true))
        assertEquals("_count", result.get(0).getAggregateFieldNames().get(0));  
        assertTrue(e.getMessage().contains("include"));  
        List<AggregationBuilder> aggs = List.of(
        assertEquals(Long.valueOf(5), result.get(0).getHavingMinDocCount());
import org.opensearch.script.Script;
        expectThrows(ConversionException.class, () -> walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory()));  
        assertEquals(1, result.size());  
        assertFalse(result.get(0).getGroupByBitSet().isEmpty());
        List<AggregationBuilder> aggs = List.of(  
        assertTrue(result.get(0).getGroupByBitSet().isEmpty());
                        .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))  
    }
        assertEquals(1, result.get(0).getAggregateCalls().size());
        assertEquals(Integer.valueOf(7), result.get(0).getFetch());
        );
        assertEquals(2, result.size());  
        assertTrue(result.get(1).hasBucketOrders());  
        assertNotNull(result.get(0).getFetch());
        // Brand: GROUP BY brand, AVG + implicit _count
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
    }
                .subAggregation(new TermsAggregationBuilder("by_name").field("name").size(3))
    public void testSameFieldSiblingsCarryTheirOwnMissing() throws ConversionException {  
            new TermsAggregationBuilder("by_brand").field("brand")
        assertTrue(result.get(0).getAggregateFieldNames().contains("_count"));  
        List<AggregationBuilder> aggs = List.of(  
 * SPDX-License-Identifier: Apache-2.0
        );
    public void testNestedGranularityGetsPerParentFetch() throws ConversionException {  
package org.opensearch.dsl.aggregation;
        assertEquals(1, result.get(0).getAggregateCalls().size());  
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        assertEquals(2, result.get(1).getAggregateCalls().size());  
        assertNull("nested level must not carry a flat limit", result.get(1).getFetch());  
        ConversionException e = expectThrows(  
            new AvgAggregationBuilder("global_avg").field("price"),
        AvgAggregationBuilder agg = new AvgAggregationBuilder("avg_price").field("price").missing(42);
        assertEquals(List.of("top_brands"), result.get(0).getAggNamePath());  
        List<AggregationBuilder> aggs = List.of(new AvgAggregationBuilder("avg_price").field("price"));
    public void testMinDocCountAboveOneGetsHavingAndFetch() throws ConversionException {  
import org.opensearch.search.aggregations.AggregationBuilder;
        List<AggregationBuilder> aggs = List.of(new TermsAggregationBuilder("by_brand").field("brand").size(7));  
        assertEquals(2, result.get(0).getAggregateCalls().size());
import org.opensearch.dsl.converter.ConversionException;  
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        );
        assertNotNull(result.get(0).getFetch());  
        assertEquals(2, result.get(1).getAggregateCalls().size());  
    public void testNestedBucketsProduceMultipleGranularities() throws ConversionException {  
                        .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))  
        assertEquals(2, result.get(0).getAggregateCalls().size());
    }  
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());  
        );
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());  
        // Both bounds bake into the plan: HAVING filters before the LIMIT truncates. The
        // No implicit _count for global (no-bucket) granularity
    public void testValidateRejectsIncludeExclude() {
                .subAggregation(
                    new TermsAggregationBuilder("by_name").field("name")
            ConversionException.class,  
        // eligible count (which must exclude below-threshold groups) comes from the
            new TermsAggregationBuilder("by_brand").field("brand").subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
        assertTrue(e.getMessage().contains("min_doc_count"));
        assertNull(result.get(0).getHavingMinDocCount());
                .order(BucketOrder.count(false))
            new TermsAggregationBuilder("first").field("brand").missing("a"),  
        List<AggregationBuilder> aggs = List.of(
import java.util.List;
        assertTrue(result.get(0).hasBucketOrders());
import org.opensearch.search.aggregations.BucketOrder;  
        // terms bucket with no explicit metrics — still produces metadata with implicit _count
            new TermsAggregationBuilder("by_brand").field("brand")
 * The OpenSearch Contributors require contributions made to  
        assertFalse(result.get(0).getBucketOrders().isEmpty());  
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        assertEquals(2, result.get(0).getAggregateCalls().size());
        assertEquals(2, result.size());  
    public void testValidateRejectsMinDocCountZero() {  
    public void testValidateRejectsTermsScript() {  
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        assertEquals(2, result.size());  
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
        );  
        assertEquals(List.of("brand"), result.get(0).getGroupByFieldNames());
    public void testMultipleMetricsSameGranularity() throws ConversionException {
    public void testBucketOrderCollected() throws ConversionException {
        assertEquals(Map.of("brand", "b"), result.get(1).getMissingValues());
        List<AggregationBuilder> aggs = List.of(new TermsAggregationBuilder("by_brand").field("brand"));
            new TermsAggregationBuilder("brands_by_key").field("brand").order(BucketOrder.key(true))  
        assertEquals("nested level is bounded per parent", Integer.valueOf(3), result.get(1).getPerParentFetch());
        assertEquals(2, result.size());
        assertEquals(List.of("name"), result.get(1).getGroupByFieldNames());
    public void testDefaultBucketOrderCollected() throws ConversionException {  
        // same field each get their own plan with their own order and LIMIT baked in.  
        assertEquals(List.of("brands_by_key"), result.get(1).getAggNamePath());
    }  
    public void testMetricOnly() throws ConversionException {
            new TermsAggregationBuilder("second").field("brand").missing("b")
        assertTrue(result.get(0).hasBucketOrders());  
        TermsAggregationBuilder agg = new TermsAggregationBuilder("by_brand").field("brand").minDocCount(0);
            new TermsAggregationBuilder("by_brand").field("brand").subAggregation(new AvgAggregationBuilder("brand_avg").field("price")),
        assertNotNull(result.get(1).getFetch());  

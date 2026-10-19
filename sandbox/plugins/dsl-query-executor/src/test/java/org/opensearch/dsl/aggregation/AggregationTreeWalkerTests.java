        assertNotNull(result.get(0).getFetch());
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        );
    }
        List<AggregationBuilder> aggs = List.of(new TermsAggregationBuilder("by_brand").field("brand").missing("unknown"));
        );
        assertEquals(List.of("brand"), result.get(0).getGroupByFieldNames());
        assertEquals("avg_price", result.get(0).getAggregateFieldNames().get(0));
        // terms bucket with no explicit metrics — still produces metadata with implicit _count
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
    public void testMultipleMetricsSameGranularity() throws ConversionException {
        // nested levels are bounded per parent instead (ROW_NUMBER over the parent partition).
        List<AggregationBuilder> aggs = List.of(
        TermsAggregationBuilder agg = new TermsAggregationBuilder("by_brand").field("brand").minDocCount(0);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        assertEquals(2, result.size());
    }
        List<AggregationBuilder> aggs = List.of(new TermsAggregationBuilder("by_brand").field("brand"));
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
    public void testValidateRejectsIncludeExclude() {
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        List<AggregationBuilder> aggs = List.of(
import java.util.List;
            new TermsAggregationBuilder("brands_by_key").field("brand").order(BucketOrder.key(true))
        List<AggregationBuilder> aggs = List.of(
        // Brand: GROUP BY brand, AVG + implicit _count
        List<AggregationBuilder> aggs = List.of(
            () -> walker.walk(List.of(agg), ctx.getRowType(), ctx.getCluster().getTypeFactory())
    public void testMinDocCountAboveOneGetsHavingAndFetch() throws ConversionException {
import org.opensearch.dsl.TestUtils;
                .subAggregation(new TermsAggregationBuilder("by_name").field("name").size(3))
        assertEquals(Long.valueOf(5), result.get(0).getHavingMinDocCount());
    private final ConversionContext ctx = TestUtils.createContext();
                .subAggregation(
        // Default terms order is _count desc — should still be collected
        expectThrows(ConversionException.class, () -> walker.walk(List.of(agg), ctx.getRowType(), ctx.getCluster().getTypeFactory()));
        // A flat LIMIT on the child level would keep top groups globally, not per parent —
            () -> walker.walk(List.of(agg), ctx.getRowType(), ctx.getCluster().getTypeFactory())
        assertNull(result.get(0).getPerParentFetch());
        assertEquals(List.of("avg_price", "total_price"), result.get(0).getAggregateFieldNames());
    // ---- Parameter gate: silently ignored parameters must reject loudly ----
        assertEquals(Integer.valueOf(7), result.get(0).getFetch());
        assertEquals(2, result.size());
    }
        assertEquals(2, result.get(1).getAggregateCalls().size());
                .order(BucketOrder.key(true))
        assertTrue(result.get(0).getGroupByBitSet().isEmpty());
    }
    // ---- Fetch pushdown eligibility, HAVING, and missing (top-K pushdown) ----
        assertFalse(result.get(0).getBucketOrders().isEmpty());
    }
        // Both bounds bake into the plan: HAVING filters before the LIMIT truncates. The
                        .order(BucketOrder.key(true))
        assertEquals(2, result.get(0).getAggregateCalls().size());
/*
        assertEquals(List.of("top_brands"), result.get(0).getAggNamePath());
    }
        assertNull(result.get(0).getHavingMinDocCount());
        );
        assertNotNull("root level carries the flat limit", result.get(0).getFetch());
        List<AggregationBuilder> aggs = List.of(
            new AvgAggregationBuilder("global_avg").field("price"),
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
    public void testMissingCapturedAndFetchKept() throws ConversionException {
        List<AggregationBuilder> aggs = List.of(
            new TermsAggregationBuilder("by_name").field("name").subAggregation(new SumAggregationBuilder("name_total").field("price"))
            new TermsAggregationBuilder("by_brand").field("brand")
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
                        .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
 * The OpenSearch Contributors require contributions made to
    public void testMetricOnly() throws ConversionException {
    }
import org.opensearch.dsl.converter.ConversionContext;
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
            new TermsAggregationBuilder("by_brand").field("brand").subAggregation(new AvgAggregationBuilder("brand_avg").field("price")),
        );
}
import org.opensearch.search.aggregations.AggregationBuilder;
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        assertTrue(e.getMessage().contains("include"));
        assertTrue(e.getMessage().contains("min_doc_count"));
            new TermsAggregationBuilder("by_brand").field("brand")
    public void testValidateRejectsTermsScript() {
public class AggregationTreeWalkerTests extends OpenSearchTestCase {
import org.opensearch.dsl.converter.ConversionException;
            new TermsAggregationBuilder("top_brands").field("brand").order(BucketOrder.count(false)),
import java.util.Map;
        assertEquals(List.of("global_avg"), result.get(0).getAggregateFieldNames());
        // Brand granularity: SUM + implicit _count
        assertTrue(result.get(0).getMissingValues().isEmpty());
        List<AggregationBuilder> aggs = List.of(new HistogramAggregationBuilder("by_price").field("price").interval(100));
            ConversionException.class,
        // Separate plans per sibling: each substitutes its own missing value — no conflict possible.
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
        ConversionException e = expectThrows(
        assertEquals(List.of("brand"), result.get(0).getGroupByFieldNames());
    }
        // same field each get their own plan with their own order and LIMIT baked in.
        assertEquals(List.of("brands_by_key"), result.get(1).getAggNamePath());
        assertEquals(1, result.get(0).getAggregateCalls().size());
        assertTrue(result.get(0).hasBucketOrders());
        // name granularity: SUM + _count
        assertNotNull(result.get(0).getFetch());
        );
        assertEquals(2, result.get(0).getAggregateCalls().size());
        );
            () -> walker.walk(List.of(agg), ctx.getRowType(), ctx.getCluster().getTypeFactory())
        List<AggregationBuilder> aggs = List.of(
    }
    public void testValidateRejectsMinDocCountZero() {
 * SPDX-License-Identifier: Apache-2.0
        List<AggregationBuilder> aggs = List.of(
    }
        List<AggregationBuilder> aggs = List.of(new AvgAggregationBuilder("avg_price").field("price"));
        assertTrue(result.get(1).hasBucketOrders());
    public void testSiblingBucketsProduceSeparateGranularities() throws ConversionException {
        AvgAggregationBuilder agg = new AvgAggregationBuilder("avg_price").field("price").missing(42);
        agg.includeExclude(new IncludeExclude("Brand.*", null));
        assertEquals(2, result.size());
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        assertTrue(e.getMessage().contains("missing"));
            new TermsAggregationBuilder("second").field("brand").missing("b")
        assertTrue(result.get(0).hasBucketOrders());
    public void testMetricAtMultipleGranularities() throws ConversionException {
        assertEquals(1, result.get(0).getAggregateCalls().size());
        );
        List<AggregationBuilder> aggs = List.of(
        assertEquals(2, result.size());
        assertTrue(result.get(0).getAggregateFieldNames().contains("_count"));
 * compatible open source license.
    }
        // No implicit _count for global (no-bucket) granularity
        assertEquals(1, result.size());
        // brand granularity: AVG + _count
        assertEquals(Map.of("brand", "unknown"), result.get(0).getMissingValues());
    }
 *
    public void testMetricOnlyHasNoBucketOrders() throws ConversionException {
        assertEquals("_count", result.get(0).getAggregateFieldNames().get(0));
    }
            new TermsAggregationBuilder("by_brand").field("brand")
 * this file be licensed under the Apache-2.0 license or a
        );
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
    public void testNestedBucketsCollectOrdersPerGranularity() throws ConversionException {
                .subAggregation(
package org.opensearch.dsl.aggregation;
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
        );
                .order(BucketOrder.count(false))
                .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
import org.opensearch.script.Script;
        ConversionException e = expectThrows(
        assertEquals(1, result.size());
            new TermsAggregationBuilder("by_brand").field("brand").subAggregation(new AvgAggregationBuilder("brand_avg").field("price"))
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
                    new TermsAggregationBuilder("by_name").field("name")
        );
    }
    public void testBucketOnlyProducesImplicitCount() throws ConversionException {
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        assertNotNull(result.get(0).getFetch());
        // aggregation's own HAVING-filtered COUNT plan, built by the converter.
        assertEquals(List.of("brand", "name"), result.get(1).getGroupByFieldNames());
            new TermsAggregationBuilder("first").field("brand").missing("a"),
        );
        List<AggregationBuilder> aggs = List.of(new TermsAggregationBuilder("by_brand").field("brand").minDocCount(5));
        assertEquals(List.of("brand"), result.get(0).getGroupByFieldNames());
            new TermsAggregationBuilder("by_brand").field("brand").subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
                        .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
        assertEquals(List.of("brand", "name"), result.get(1).getGroupByFieldNames());
    public void testThrowsForUnsupportedAggregation() {
                    new TermsAggregationBuilder("by_name").field("name")
import org.opensearch.search.aggregations.BucketOrder;
        // Brand+name granularity: AVG + implicit _count
        assertEquals(1, result.size());
    public void testBucketWithMetric() throws ConversionException {
        assertEquals(1, result.get(0).getAggregateCalls().size());
                .subAggregation(new SumAggregationBuilder("total").field("price"))
            new AvgAggregationBuilder("avg_price").field("price"),
        // avg_price + implicit _count
import org.opensearch.test.OpenSearchTestCase;
    }
        assertEquals(2, result.size());
    }
    }
        assertNull("nested level must not carry a flat limit", result.get(1).getFetch());
        TermsAggregationBuilder agg = new TermsAggregationBuilder("by_brand").field("brand");
    public void testNestedGranularityGetsPerParentFetch() throws ConversionException {
        assertFalse(result.get(0).hasBucketOrders());
    }
    }
                )
        assertEquals(2, result.get(1).getAggregateCalls().size());
    public void testBucketOrderCollected() throws ConversionException {
    }
    public void testNestedBucketsProduceMultipleGranularities() throws ConversionException {
        assertTrue(result.get(0).getAggregateFieldNames().contains("avg_price"));
        // Both granularities have bucket orders
        expectThrows(ConversionException.class, () -> walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory()));
        assertEquals(2, result.size());
            ConversionException.class,
        assertEquals(Map.of("brand", "b"), result.get(1).getMissingValues());
        List<AggregationBuilder> aggs = List.of(new TermsAggregationBuilder("by_brand").field("brand").size(7));
        );
    public void testValidateRejectsMetricMissing() {
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        assertFalse(result.get(0).getGroupByBitSet().isEmpty());
        // A plan is defined by its aggregation, not its GROUP BY columns: siblings over the
        assertNotNull(result.get(1).getFetch());
        List<AggregationBuilder> aggs = List.of(
        List<AggregationBuilder> aggs = List.of(new AvgAggregationBuilder("avg_price").field("price"));
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        assertEquals(List.of("brand"), result.get(0).getGroupByFieldNames());
            new SumAggregationBuilder("total_price").field("price")
        assertEquals(List.of("brand"), result.get(1).getGroupByFieldNames());
        );
        assertEquals(2, result.get(1).getAggregateCalls().size());
        assertEquals("nested level is bounded per parent", Integer.valueOf(3), result.get(1).getPerParentFetch());
        assertTrue(result.get(0).getGroupByBitSet().get(2)); // brand is index 2
        assertEquals(1, result.size());
        assertTrue(result.get(0).hasBucketOrders());
    }
        // Root: no GROUP BY, no implicit _count
        assertEquals(2, result.get(0).getAggregateCalls().size());
 */
    private final AggregationTreeWalker walker = new AggregationTreeWalker(AggregationRegistryFactory.create());
        List<AggregationBuilder> aggs = List.of(new TermsAggregationBuilder("by_brand").field("brand"));
        assertEquals(2, result.get(0).getAggregateCalls().size());
        TermsAggregationBuilder agg = new TermsAggregationBuilder("by_brand").script(new Script("doc['brand'].value"));
    public void testSameFieldSiblingsCarryTheirOwnMissing() throws ConversionException {
        assertTrue(result.get(0).getGroupByBitSet().isEmpty());
    }
            ConversionException.class,
                )
    public void testRootTermsGranularityGetsFetch() throws ConversionException {
        // eligible count (which must exclude below-threshold groups) comes from the
    public void testSameFieldSiblingsGetSeparateBoundedPlans() throws ConversionException {
        ConversionException e = expectThrows(
        assertEquals(Map.of("brand", "a"), result.get(0).getMissingValues());
            new TermsAggregationBuilder("by_brand").field("brand")
        assertEquals(2, result.size());
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());
        assertEquals(List.of("name"), result.get(1).getGroupByFieldNames());
    public void testDefaultBucketOrderCollected() throws ConversionException {
        List<AggregationMetadata> result = walker.walk(aggs, ctx.getRowType(), ctx.getCluster().getTypeFactory());

import org.opensearch.dsl.aggregation.AggregationRegistryFactory;
    private final AggregationTreeWalker walker = new AggregationTreeWalker(AggregationRegistryFactory.create());
            scan.getRowType(),
        RelNode result = postAggConverter.convert(scan, ctx);
            scan.getCluster().getTypeFactory()
            ),
        assertSame(scan, result);
import org.apache.calcite.rel.logical.LogicalAggregate;
                    .order(BucketOrder.aggregation("avg_price", false))
    public void testSkipsWhenNoBucketOrders() throws ConversionException {
        List<AggregationMetadata> metadataList = walker.walk(
        List<AggregationMetadata> metadataList = walker.walk(
        assertEquals(2, collations.size());
import org.opensearch.dsl.TestUtils;
        );
            scan.getCluster().getTypeFactory()
        List<RelFieldCollation> collations = sort.getCollation().getFieldCollations();
 * this file be licensed under the Apache-2.0 license or a
        List<AggregationMetadata> metadataList = walker.walk(
                    .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
        // Verify post-agg schema
            List.<AggregationBuilder>of(
        assertEquals("brand", fieldNames.get(collations.get(0).getFieldIndex()));
 * compatible open source license.
        assertTrue(((LogicalSort) result).getInput() instanceof LogicalAggregate);
            scan.getCluster().getTypeFactory()
        ConversionContext aggCtx = ctx.withAggregationMetadata(metadataList.get(0));
import java.util.List;
    public void testAppliesDefaultCountDescOrder() throws ConversionException {
        // Metric-only agg has no bucket orders
                    .order(BucketOrder.key(true))
            scan.getRowType(),
        assertEquals(RelFieldCollation.Direction.DESCENDING, collations.get(0).direction);
        assertEquals(List.of("brand", "avg_price", "_count"), fieldNames);
        RelNode agg = aggConverter.convert(scan, metadataList.get(0));
/*
            scan.getCluster().getTypeFactory()
                new TermsAggregationBuilder("by_brand").field("brand")
        RelNode result = postAggConverter.convert(agg, aggCtx);
        assertEquals(List.of("brand", "avg_price", "_count"), fieldNames);
        );
public class PostAggregateConverterTests extends OpenSearchTestCase {
        assertTrue(result instanceof LogicalSort);
import org.opensearch.test.OpenSearchTestCase;
    public void testAppliesMetricOrder() throws ConversionException {
    private final ConversionContext ctx = TestUtils.createContext();
import org.opensearch.dsl.aggregation.AggregationMetadata;
        RelNode agg = aggConverter.convert(scan, metadataList.get(0));
        List<String> fieldNames = sort.getInput().getRowType().getFieldNames();
            scan.getRowType(),
        RelNode result = postAggConverter.convert(agg, aggCtx);
        assertTrue(result instanceof LogicalSort);
            scan.getRowType(),
        List<AggregationMetadata> metadataList = walker.walk(
    }
        LogicalSort sort = (LogicalSort) result;
        List<String> fieldNames = sort.getInput().getRowType().getFieldNames();
        List<RelFieldCollation> collations = sort.getCollation().getFieldCollations();
                new TermsAggregationBuilder("by_brand").field("brand").subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
        // key(true) is already a key order — no tie-breaker added
        RelNode result = postAggConverter.convert(agg, aggCtx);
    }
            ),
            List.of(
        // Default terms order is compound: _count desc, _key(brand) asc
    public void testPostAggInputIsLogicalAggregate() throws ConversionException {
        ConversionContext aggCtx = ctx.withAggregationMetadata(metadataList.get(0));
    }
}
        assertEquals("_count", fieldNames.get(collations.get(0).getFieldIndex()));
        RelNode agg = aggConverter.convert(scan, metadataList.get(0));
        assertEquals(2, collations.size());
        );
import org.apache.calcite.rel.logical.LogicalSort;
            scan.getCluster().getTypeFactory()
        List<AggregationMetadata> metadataList = walker.walk(
        assertEquals("brand", fieldNames.get(collations.get(1).getFieldIndex()));
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(0).direction);
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
        // Default terms order is _count desc
package org.opensearch.dsl.converter;
import org.opensearch.search.aggregations.BucketOrder;
import org.opensearch.dsl.aggregation.AggregationTreeWalker;
 * SPDX-License-Identifier: Apache-2.0
        );
        List<RelFieldCollation> collations = sort.getCollation().getFieldCollations();
import org.apache.calcite.rel.logical.LogicalTableScan;
        assertEquals("avg_price", fieldNames.get(collations.get(0).getFieldIndex()));
        assertTrue(result instanceof LogicalSort);
        LogicalSort sort = (LogicalSort) result;
        );
    private final AggregateConverter aggConverter = new AggregateConverter();
        assertEquals(RelFieldCollation.Direction.DESCENDING, collations.get(0).direction);
        ConversionContext aggCtx = ctx.withAggregationMetadata(metadataList.get(0));
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.apache.calcite.rel.RelNode;
            ),
        ConversionContext aggCtx = ctx.withAggregationMetadata(metadataList.get(0));
        assertSame(agg, result);
        assertEquals("brand", fieldNames.get(collations.get(1).getFieldIndex()));
 * The OpenSearch Contributors require contributions made to
    public void testAppliesKeyAscOrder() throws ConversionException {
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
 */
        RelNode result = postAggConverter.convert(agg, aggCtx);
import org.opensearch.search.aggregations.AggregationBuilder;
        assertTrue(result instanceof LogicalSort);
    }
    public void testSkipsWhenNoAggregationMetadata() throws ConversionException {
import org.apache.calcite.rel.RelFieldCollation;
            scan.getRowType(),
    }
            List.<AggregationBuilder>of(
        RelNode agg = aggConverter.convert(scan, metadataList.get(0));
        RelNode agg = aggConverter.convert(scan, metadataList.get(0));
            List.of(new AvgAggregationBuilder("avg_price").field("price")),
            List.<AggregationBuilder>of(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.key(true))),
    }
                new TermsAggregationBuilder("by_brand").field("brand")
        assertEquals(1, collations.size());
                    .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
        assertEquals(List.of("brand", "avg_price", "_count"), fieldNames);
 *
        List<String> fieldNames = sort.getInput().getRowType().getFieldNames();
    private final LogicalTableScan scan = TestUtils.createTestRelNode();
        RelNode result = postAggConverter.convert(agg, aggCtx);
    private final PostAggregateConverter postAggConverter = new PostAggregateConverter();
        LogicalSort sort = (LogicalSort) result;
        ConversionContext aggCtx = ctx.withAggregationMetadata(metadataList.get(0));
        // Compound: avg_price desc, _key(brand) asc

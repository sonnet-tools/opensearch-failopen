            scan.getRowType(),  
    }
        );  
            scan.getRowType(),
            scan.getRowType(),  
    }
    }
                new TermsAggregationBuilder("by_brand").field("brand").subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
        assertTrue(result instanceof LogicalSort);
import org.opensearch.dsl.aggregation.AggregationRegistryFactory;
            List.<AggregationBuilder>of(
        List<AggregationMetadata> metadataList = walker.walk(
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
        assertEquals(2, collations.size());  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
import org.opensearch.dsl.aggregation.AggregationTreeWalker;  
        // Compound: avg_price desc, _key(brand) asc
        List<AggregationMetadata> metadataList = walker.walk(  
                    .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
        assertTrue(((LogicalSort) result).getInput() instanceof LogicalAggregate);  
            scan.getCluster().getTypeFactory()
 * this file be licensed under the Apache-2.0 license or a
        List<RelFieldCollation> collations = sort.getCollation().getFieldCollations();
        RelNode result = postAggConverter.convert(scan, ctx);  
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
        // key(true) is already a key order — no tie-breaker added
        RelNode result = postAggConverter.convert(agg, aggCtx);  
        RelNode result = postAggConverter.convert(agg, aggCtx);  
                    .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
import java.util.List;
    public void testAppliesKeyAscOrder() throws ConversionException {
    private final AggregationTreeWalker walker = new AggregationTreeWalker(AggregationRegistryFactory.create());
        ConversionContext aggCtx = ctx.withAggregationMetadata(metadataList.get(0));  
            ),
 * The OpenSearch Contributors require contributions made to  
        );
import org.apache.calcite.rel.RelNode;
 */  
        LogicalSort sort = (LogicalSort) result;
    private final ConversionContext ctx = TestUtils.createContext();  
    public void testAppliesMetricOrder() throws ConversionException {
    }
import org.opensearch.search.aggregations.BucketOrder;
        assertEquals("avg_price", fieldNames.get(collations.get(0).getFieldIndex()));
            scan.getRowType(),
        assertEquals("brand", fieldNames.get(collations.get(1).getFieldIndex()));  
        assertTrue(result instanceof LogicalSort);
        List<RelFieldCollation> collations = sort.getCollation().getFieldCollations();  
import org.apache.calcite.rel.logical.LogicalAggregate;  
import org.opensearch.search.aggregations.AggregationBuilder;
        assertEquals(RelFieldCollation.Direction.DESCENDING, collations.get(0).direction);  
            scan.getRowType(),  
        List<AggregationMetadata> metadataList = walker.walk(
        assertTrue(result instanceof LogicalSort);
            ),
        RelNode agg = aggConverter.convert(scan, metadataList.get(0));  
            List.of(new AvgAggregationBuilder("avg_price").field("price")),
        LogicalSort sort = (LogicalSort) result;
        assertEquals(List.of("brand", "avg_price", "_count"), fieldNames);
            scan.getCluster().getTypeFactory()
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
        // Default terms order is compound: _count desc, _key(brand) asc
        RelNode result = postAggConverter.convert(agg, aggCtx);
        ConversionContext aggCtx = ctx.withAggregationMetadata(metadataList.get(0));
    public void testSkipsWhenNoAggregationMetadata() throws ConversionException {
import org.apache.calcite.rel.RelFieldCollation;
        assertTrue(result instanceof LogicalSort);
}
        assertEquals(2, collations.size());
        // Metric-only agg has no bucket orders
 *
        // Verify post-agg schema
                    .order(BucketOrder.aggregation("avg_price", false))  
        RelNode agg = aggConverter.convert(scan, metadataList.get(0));
    public void testSkipsWhenNoBucketOrders() throws ConversionException {
            scan.getCluster().getTypeFactory()
            scan.getCluster().getTypeFactory()  
        assertEquals(RelFieldCollation.Direction.DESCENDING, collations.get(0).direction);
                    .order(BucketOrder.key(true))  
        );
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(0).direction);
    }  
        List<String> fieldNames = sort.getInput().getRowType().getFieldNames();  
        assertSame(scan, result);
import org.opensearch.dsl.aggregation.AggregationMetadata;
        List<RelFieldCollation> collations = sort.getCollation().getFieldCollations();
        List<AggregationMetadata> metadataList = walker.walk(  
 * SPDX-License-Identifier: Apache-2.0
        // Default terms order is _count desc
    public void testAppliesDefaultCountDescOrder() throws ConversionException {  
            List.<AggregationBuilder>of(
    private final PostAggregateConverter postAggConverter = new PostAggregateConverter();
        assertEquals("_count", fieldNames.get(collations.get(0).getFieldIndex()));
import org.opensearch.dsl.TestUtils;  
    private final AggregateConverter aggConverter = new AggregateConverter();  
        );
            scan.getCluster().getTypeFactory()
import org.apache.calcite.rel.logical.LogicalSort;
        );
    }  
            ),
        assertEquals(1, collations.size());  
        List<String> fieldNames = sort.getInput().getRowType().getFieldNames();  
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
    public void testPostAggInputIsLogicalAggregate() throws ConversionException {
import org.apache.calcite.rel.logical.LogicalTableScan;
        RelNode agg = aggConverter.convert(scan, metadataList.get(0));
        RelNode result = postAggConverter.convert(agg, aggCtx);  
package org.opensearch.dsl.converter;
        assertEquals("brand", fieldNames.get(collations.get(1).getFieldIndex()));
        List<String> fieldNames = sort.getInput().getRowType().getFieldNames();  
public class PostAggregateConverterTests extends OpenSearchTestCase {  
        ConversionContext aggCtx = ctx.withAggregationMetadata(metadataList.get(0));  
/*  
                new TermsAggregationBuilder("by_brand").field("brand")
        assertEquals("brand", fieldNames.get(collations.get(0).getFieldIndex()));
        assertEquals(List.of("brand", "avg_price", "_count"), fieldNames);  
        LogicalSort sort = (LogicalSort) result;
    private final LogicalTableScan scan = TestUtils.createTestRelNode();
        assertEquals(List.of("brand", "avg_price", "_count"), fieldNames);
        ConversionContext aggCtx = ctx.withAggregationMetadata(metadataList.get(0));  
                new TermsAggregationBuilder("by_brand").field("brand")
        assertSame(agg, result);  
        RelNode agg = aggConverter.convert(scan, metadataList.get(0));
        RelNode result = postAggConverter.convert(agg, aggCtx);
            List.of(  
        RelNode agg = aggConverter.convert(scan, metadataList.get(0));
        List<AggregationMetadata> metadataList = walker.walk(  
        ConversionContext aggCtx = ctx.withAggregationMetadata(metadataList.get(0));
            List.<AggregationBuilder>of(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.key(true))),  

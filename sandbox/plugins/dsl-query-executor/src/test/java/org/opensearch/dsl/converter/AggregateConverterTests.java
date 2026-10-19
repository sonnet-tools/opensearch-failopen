        List<AggregationMetadata> metadataList = walker.walk(
        LogicalAggregate agg = (LogicalAggregate) result;  
        RelNode result = converter.convert(scan, metadataList.get(0));
        List<AggregationMetadata> metadataList = walker.walk(
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rel.RelNode;
    }
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        RelNode result = converter.convert(scan, metadataList.get(0));  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.AggregationBuilder;
 *
        assertTrue(agg.getGroupSet().isEmpty());
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
import org.opensearch.dsl.TestUtils;
                new TermsAggregationBuilder("by_brand").field("brand").subAggregation(new AvgAggregationBuilder("avg_price").field("price"))  
            scan.getRowType(),
        RelNode result = converter.convert(scan, metadataList.get(0));  
        );
import org.apache.calcite.rel.logical.LogicalTableScan;  
        assertTrue(result instanceof LogicalAggregate);
 */  
import org.opensearch.dsl.aggregation.AggregationTreeWalker;
 * compatible open source license.
        LogicalAggregate agg = (LogicalAggregate) result;
    private final AggregateConverter converter = new AggregateConverter();
public class AggregateConverterTests extends OpenSearchTestCase {  
        List<AggregationMetadata> metadataList = walker.walk(  
        assertEquals(2, agg.getAggCallList().size()); // avg_price + implicit _count
 * SPDX-License-Identifier: Apache-2.0
            List.<AggregationBuilder>of(new AvgAggregationBuilder("avg_price").field("price")),
            scan.getCluster().getTypeFactory()
            scan.getRowType(),
        );
import java.util.List;
    private final AggregationTreeWalker walker = new AggregationTreeWalker(AggregationRegistryFactory.create());  
/*  
import org.opensearch.dsl.aggregation.AggregationMetadata;
    }  
        LogicalAggregate agg = (LogicalAggregate) result;
import org.opensearch.dsl.aggregation.AggregationRegistryFactory;  
            scan.getRowType(),  
    private final LogicalTableScan scan = TestUtils.createTestRelNode();
    public void testMetricOnlyProducesAggregateWithNoGroupBy() throws ConversionException {  
            List.<AggregationBuilder>of(new AvgAggregationBuilder("avg_price").field("price")),
            scan.getCluster().getTypeFactory()  
    public void testBucketWithMetricProducesGroupBy() throws ConversionException {  
import org.apache.calcite.rel.logical.LogicalAggregate;
            scan.getCluster().getTypeFactory()  
package org.opensearch.dsl.converter;
            ),
        assertEquals(1, agg.getAggCallList().size());  
    }
        assertSame(scan, agg.getInput());  
            List.<AggregationBuilder>of(
        assertTrue(result instanceof LogicalAggregate);  
    public void testInputIsScan() throws ConversionException {
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(agg.getGroupSet().get(2)); // brand is index 2
        );
}

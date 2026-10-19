        RelNode agg = aggregateConverter.convert(scan, metadata);
    public void testExplicitCompoundOrder() throws ConversionException {
    public void testResolveCountDesc() throws ConversionException {  
        assertEquals("_count", fieldNames.get(collations.get(0).getFieldIndex()));
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());
    public void testResolveKeyDesc() throws ConversionException {
                new TermsAggregationBuilder("by_brand").field("brand")
        assertEquals(2, collations.size());  
        AggregationMetadata metadata = walkAndGetMetadata(  
        RelNode agg = aggregateConverter.convert(scan, metadata);
    }
        List<String> fieldNames = agg.getRowType().getFieldNames();
        assertEquals(List.of("brand", "_count"), fieldNames);  
            )  
        assertEquals(RelFieldCollation.Direction.DESCENDING, collations.get(0).direction);  
        // Metric-only agg has no bucket orders
    private final AggregateConverter aggregateConverter = new AggregateConverter();
        return metadataList.get(0);  
            ),  
}  
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(0).direction);
            List.of(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.key(false)))
 */  
        assertEquals(List.of("brand", "_count"), fieldNames);  
        );
        AggregationMetadata metadata = walkAndGetMetadata(
        );  
            List.of(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.count(false)))  
            List.of(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.key(true)))
        assertEquals(1, collations.size());  
    }
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(RelFieldCollation.Direction.DESCENDING, collations.get(0).direction);
                    .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
        List<String> fieldNames = agg.getRowType().getFieldNames();
                    .order(BucketOrder.aggregation("avg_price", false))
                    .subAggregation(
        RelNode agg = aggregateConverter.convert(scan, nestedMetadata);  
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        assertEquals("brand", fieldNames.get(collations.get(1).getFieldIndex()));  
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());
        RelNode agg = aggregateConverter.convert(scan, metadata);  
            scan.getCluster().getTypeFactory()
    private final LogicalTableScan scan = TestUtils.createTestRelNode();
        // Verify post-agg schema: [brand, _count]
 *
        assertEquals(List.of("brand", "avg_price", "_count"), fieldNames);
import org.opensearch.dsl.aggregation.AggregationTreeWalker;
/*  
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());  
 * this file be licensed under the Apache-2.0 license or a
        RelNode agg = aggregateConverter.convert(scan, metadata);
        assertEquals("brand", fieldNames.get(collations.get(0).getFieldIndex()));
import java.util.List;
        assertEquals(2, collations.size());
        assertEquals(2, collations.size());  
                new TermsAggregationBuilder("by_brand").field("brand")  
        // _key resolves to both group-by fields: brand and name
        AggregationMetadata metadata = walkAndGetMetadata(  
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());
 * The OpenSearch Contributors require contributions made to  
        RelNode agg = aggregateConverter.convert(scan, metadata);  
                            .order(BucketOrder.key(true))  
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
        List<String> fieldNames = agg.getRowType().getFieldNames();  
        RelNode agg = aggregateConverter.convert(scan, metadata);  
                new TermsAggregationBuilder("by_brand").field("brand")  
        );
        // Compound: _count desc, _key asc
import org.opensearch.search.aggregations.AggregationBuilder;
package org.opensearch.dsl.converter;
 * compatible open source license.
    public void testResolveMetricOrder() throws ConversionException {
        assertEquals(RelFieldCollation.Direction.DESCENDING, collations.get(0).direction);  
            List.<AggregationBuilder>of(
        AggregationMetadata metadata = walkAndGetMetadata(
                    .order(BucketOrder.compound(List.of(BucketOrder.count(false), BucketOrder.key(true))))  
        AggregationMetadata nestedMetadata = metadataList.get(1);
        expectThrows(ConversionException.class, () -> CollationResolver.resolve(metadata, agg.getRowType()));
        AggregationMetadata metadata = walkAndGetMetadata(
    }
    private final AggregationTreeWalker walker = new AggregationTreeWalker(AggregationRegistryFactory.create());  
        AggregationMetadata metadata = walkAndGetMetadata(
        AggregationMetadata metadata = walkAndGetMetadata(List.of(new AvgAggregationBuilder("avg_price").field("price")));  
        List<RelFieldCollation> collations = CollationResolver.resolve(nestedMetadata, agg.getRowType());  
        );
        List<String> fieldNames = agg.getRowType().getFieldNames();  
    private AggregationMetadata walkAndGetMetadata(List<AggregationBuilder> aggs) throws ConversionException {
            scan.getRowType(),
            List.of(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.aggregation("nonexistent_metric", true)))  
    }  
    }
public class CollationResolverTests extends OpenSearchTestCase {
        assertEquals(List.of("name", "brand", "avg_price", "_count"), fieldNames);
        // ImmutableBitSet orders by input index: name(0) before brand(2)  
        assertEquals("brand", fieldNames.get(collations.get(0).getFieldIndex()));
        assertEquals("name", fieldNames.get(collations.get(1).getFieldIndex()));  
import org.opensearch.search.aggregations.BucketOrder;  
        );  
        assertEquals("brand", fieldNames.get(collations.get(1).getFieldIndex()));  
        assertEquals(List.of("brand", "_count"), fieldNames);
                    )
        assertTrue(collations.isEmpty());
    public void testResolveCountAsc() throws ConversionException {
        assertEquals(1, collations.size());
            List.of(
import org.opensearch.dsl.aggregation.AggregationMetadata;
import org.opensearch.dsl.TestUtils;
                            .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
        AggregationMetadata metadata = walkAndGetMetadata(  
        );
        );
        assertEquals("brand", fieldNames.get(collations.get(1).getFieldIndex()));
    }  
        assertEquals(2, collations.size());
        // Compound: avg_price desc, _key asc  
        // Get the nested granularity (brand + name)  
        RelNode agg = aggregateConverter.convert(scan, metadata);
    public void testThrowsForUnknownMetricField() throws ConversionException {
import org.opensearch.dsl.aggregation.AggregationRegistryFactory;  
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(0).direction);  
    public void testEmptyOrdersReturnEmptyCollations() throws ConversionException {
import org.apache.calcite.rel.logical.LogicalTableScan;  
        RelNode agg = aggregateConverter.convert(scan, metadata);
        List<AggregationMetadata> metadataList = walker.walk(aggs, scan.getRowType(), scan.getCluster().getTypeFactory());
import org.apache.calcite.rel.RelNode;
    public void testResolveKeyAsc() throws ConversionException {  
        List<String> fieldNames = agg.getRowType().getFieldNames();
        assertEquals("brand", fieldNames.get(collations.get(0).getFieldIndex()));
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
            List.of(
        assertEquals(List.of("brand", "_count"), fieldNames);  
        assertEquals("_count", fieldNames.get(collations.get(0).getFieldIndex()));
        );
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(0).direction);
        assertEquals(RelFieldCollation.Direction.DESCENDING, collations.get(0).direction);
        // Compound: _count asc, _key asc
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());
    }  
    }  
                        new TermsAggregationBuilder("by_name").field("name")
        assertEquals("_count", fieldNames.get(collations.get(0).getFieldIndex()));
    }
        // Second granularity has both brand and name as group-by fields
        assertEquals("brand", fieldNames.get(collations.get(1).getFieldIndex()));
 * SPDX-License-Identifier: Apache-2.0
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());
        List<String> fieldNames = agg.getRowType().getFieldNames();
            )
        List<String> fieldNames = agg.getRowType().getFieldNames();
    public void testMultipleGroupByFieldsKeyOrder() throws ConversionException {
        assertEquals(2, collations.size());  
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
        assertEquals("avg_price", fieldNames.get(collations.get(0).getFieldIndex()));
        assertEquals(List.of("brand", "_count"), fieldNames);
            List.of(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.count(true)))
    }
import org.apache.calcite.rel.RelFieldCollation;
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
        List<AggregationMetadata> metadataList = walker.walk(
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());

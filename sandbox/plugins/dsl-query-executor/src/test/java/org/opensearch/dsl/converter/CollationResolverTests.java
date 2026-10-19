        assertEquals(2, collations.size());
        assertEquals(List.of("brand", "_count"), fieldNames);
        );
        AggregationMetadata metadata = walkAndGetMetadata(
        List<RelFieldCollation> collations = CollationResolver.resolve(nestedMetadata, agg.getRowType());
        return metadataList.get(0);
        AggregationMetadata metadata = walkAndGetMetadata(
        assertEquals("brand", fieldNames.get(collations.get(1).getFieldIndex()));
        assertEquals(2, collations.size());
        // Metric-only agg has no bucket orders
        // Verify post-agg schema: [brand, _count]
/*
        AggregationMetadata metadata = walkAndGetMetadata(
        );
        List<String> fieldNames = agg.getRowType().getFieldNames();
            List.of(
import org.apache.calcite.rel.logical.LogicalTableScan;
    private AggregationMetadata walkAndGetMetadata(List<AggregationBuilder> aggs) throws ConversionException {
                new TermsAggregationBuilder("by_brand").field("brand")
        assertEquals("brand", fieldNames.get(collations.get(0).getFieldIndex()));
}
        assertEquals(2, collations.size());
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(0).direction);
        AggregationMetadata metadata = walkAndGetMetadata(List.of(new AvgAggregationBuilder("avg_price").field("price")));
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());
        assertEquals(List.of("brand", "avg_price", "_count"), fieldNames);
            List.of(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.key(false)))
                new TermsAggregationBuilder("by_brand").field("brand")
                    )
    private final LogicalTableScan scan = TestUtils.createTestRelNode();
                    .order(BucketOrder.aggregation("avg_price", false))
            List.of(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.count(true)))
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        // Second granularity has both brand and name as group-by fields
        // Compound: _count asc, _key asc
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
        assertEquals("_count", fieldNames.get(collations.get(0).getFieldIndex()));
        RelNode agg = aggregateConverter.convert(scan, nestedMetadata);
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());
        List<String> fieldNames = agg.getRowType().getFieldNames();
import org.apache.calcite.rel.RelFieldCollation;
        expectThrows(ConversionException.class, () -> CollationResolver.resolve(metadata, agg.getRowType()));
    }
        RelNode agg = aggregateConverter.convert(scan, metadata);
        assertEquals(1, collations.size());
        assertEquals(List.of("brand", "_count"), fieldNames);
    public void testResolveCountAsc() throws ConversionException {
        assertEquals(2, collations.size());
        AggregationMetadata metadata = walkAndGetMetadata(
        List<String> fieldNames = agg.getRowType().getFieldNames();
import org.opensearch.dsl.TestUtils;
 * The OpenSearch Contributors require contributions made to
        AggregationMetadata metadata = walkAndGetMetadata(
        // Get the nested granularity (brand + name)
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());
import org.opensearch.search.aggregations.BucketOrder;
        RelNode agg = aggregateConverter.convert(scan, metadata);
    }
        assertEquals(List.of("brand", "_count"), fieldNames);
        assertEquals("brand", fieldNames.get(collations.get(0).getFieldIndex()));
        List<AggregationMetadata> metadataList = walker.walk(
    }
import org.opensearch.search.aggregations.AggregationBuilder;
        );
    }
        );
            List.of(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.count(false)))
 * compatible open source license.
            List.of(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.aggregation("nonexistent_metric", true)))
    private final AggregationTreeWalker walker = new AggregationTreeWalker(AggregationRegistryFactory.create());
                    .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
        // ImmutableBitSet orders by input index: name(0) before brand(2)
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(0).direction);
        // Compound: avg_price desc, _key asc
        assertTrue(collations.isEmpty());
 */
    public void testMultipleGroupByFieldsKeyOrder() throws ConversionException {
        );
    }
        RelNode agg = aggregateConverter.convert(scan, metadata);
import org.opensearch.dsl.aggregation.AggregationTreeWalker;
        List<AggregationMetadata> metadataList = walker.walk(aggs, scan.getRowType(), scan.getCluster().getTypeFactory());
            ),
        );
                            .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
    public void testResolveCountDesc() throws ConversionException {
        assertEquals(List.of("brand", "_count"), fieldNames);
import org.opensearch.dsl.aggregation.AggregationMetadata;
            )
 * SPDX-License-Identifier: Apache-2.0
    private final AggregateConverter aggregateConverter = new AggregateConverter();
    public void testEmptyOrdersReturnEmptyCollations() throws ConversionException {
 * this file be licensed under the Apache-2.0 license or a
public class CollationResolverTests extends OpenSearchTestCase {
                    .order(BucketOrder.compound(List.of(BucketOrder.count(false), BucketOrder.key(true))))
    }
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());
        RelNode agg = aggregateConverter.convert(scan, metadata);
        assertEquals("brand", fieldNames.get(collations.get(0).getFieldIndex()));
    }
    public void testResolveMetricOrder() throws ConversionException {
 *
        AggregationMetadata metadata = walkAndGetMetadata(
        AggregationMetadata nestedMetadata = metadataList.get(1);
        assertEquals(RelFieldCollation.Direction.DESCENDING, collations.get(0).direction);
                new TermsAggregationBuilder("by_brand").field("brand")
        // _key resolves to both group-by fields: brand and name
        assertEquals("avg_price", fieldNames.get(collations.get(0).getFieldIndex()));
        assertEquals(1, collations.size());
            scan.getRowType(),
    public void testExplicitCompoundOrder() throws ConversionException {
        );
        RelNode agg = aggregateConverter.convert(scan, metadata);
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());
        AggregationMetadata metadata = walkAndGetMetadata(
                        new TermsAggregationBuilder("by_name").field("name")
    }
    }
        List<String> fieldNames = agg.getRowType().getFieldNames();
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
        assertEquals("brand", fieldNames.get(collations.get(1).getFieldIndex()));
    public void testResolveKeyDesc() throws ConversionException {
        RelNode agg = aggregateConverter.convert(scan, metadata);
        // Compound: _count desc, _key asc
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(1).direction);
            List.<AggregationBuilder>of(
                    .subAggregation(
        assertEquals(List.of("name", "brand", "avg_price", "_count"), fieldNames);
        assertEquals("brand", fieldNames.get(collations.get(1).getFieldIndex()));
            List.of(
    }
        List<String> fieldNames = agg.getRowType().getFieldNames();
        assertEquals(2, collations.size());
import org.opensearch.test.OpenSearchTestCase;
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());
        assertEquals(RelFieldCollation.Direction.DESCENDING, collations.get(0).direction);
        assertEquals("name", fieldNames.get(collations.get(1).getFieldIndex()));
            )
        List<RelFieldCollation> collations = CollationResolver.resolve(metadata, agg.getRowType());
        assertEquals(List.of("brand", "_count"), fieldNames);
        RelNode agg = aggregateConverter.convert(scan, metadata);
        assertEquals("_count", fieldNames.get(collations.get(0).getFieldIndex()));
import org.opensearch.dsl.aggregation.AggregationRegistryFactory;
package org.opensearch.dsl.converter;
        assertEquals(RelFieldCollation.Direction.DESCENDING, collations.get(0).direction);
            List.of(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.key(true)))
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        );
    public void testThrowsForUnknownMetricField() throws ConversionException {
        assertEquals(RelFieldCollation.Direction.DESCENDING, collations.get(0).direction);
    public void testResolveKeyAsc() throws ConversionException {
            scan.getCluster().getTypeFactory()
        assertEquals("_count", fieldNames.get(collations.get(0).getFieldIndex()));
        assertEquals(RelFieldCollation.Direction.ASCENDING, collations.get(0).direction);
        List<String> fieldNames = agg.getRowType().getFieldNames();
        assertEquals("brand", fieldNames.get(collations.get(1).getFieldIndex()));
        List<String> fieldNames = agg.getRowType().getFieldNames();
import org.apache.calcite.rel.RelNode;
import java.util.List;
                            .order(BucketOrder.key(true))
        RelNode agg = aggregateConverter.convert(scan, metadata);

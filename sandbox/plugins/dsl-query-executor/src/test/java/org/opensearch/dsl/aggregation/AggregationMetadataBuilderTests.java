    public void testResolvesFieldGroupingToCorrectIndex() throws ConversionException {  
        builder.addGrouping(new FieldGrouping(List.of("brand")));
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(metadata.getGroupByBitSet().get(2));
        // brand is the 3rd field (index 2) in TestUtils schema: name, price, brand, rating
    public void testResolvesMultipleFieldGroupings() throws ConversionException {  
}
    private final ConversionContext ctx = TestUtils.createContext();
        AggregationMetadataBuilder builder = new AggregationMetadataBuilder();
/*  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.dsl.aggregation;
        builder.addGrouping(new FieldGrouping(List.of("nonexistent")));  
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(ConversionException.class, () -> builder.build(ctx.getRowType(), ctx.getCluster().getTypeFactory()));  
 * compatible open source license.
 */  
import org.opensearch.dsl.converter.ConversionContext;
    }
        builder.requestImplicitCount();
 *
        assertEquals(1, metadata.getGroupByBitSet().cardinality());  
        AggregationMetadata metadata = builder.build(ctx.getRowType(), ctx.getCluster().getTypeFactory());  
        builder.requestImplicitCount();
    }
    }
        AggregationMetadataBuilder builder = new AggregationMetadataBuilder();
        assertTrue(metadata.getGroupByBitSet().get(2)); // brand is index 2  
import org.opensearch.dsl.TestUtils;
        builder.requestImplicitCount();
import org.opensearch.dsl.converter.ConversionException;  
        builder.addGrouping(new FieldGrouping(List.of("brand")));  
        assertEquals(2, metadata.getGroupByBitSet().cardinality());
 * The OpenSearch Contributors require contributions made to  
    public void testThrowsForUnknownField() {
        assertTrue(metadata.getGroupByBitSet().get(0)); // name is index 0
        AggregationMetadata metadata = builder.build(ctx.getRowType(), ctx.getCluster().getTypeFactory());  
import java.util.List;  
        AggregationMetadataBuilder builder = new AggregationMetadataBuilder();
        builder.addGrouping(new FieldGrouping(List.of("name")));  
public class AggregationMetadataBuilderTests extends OpenSearchTestCase {

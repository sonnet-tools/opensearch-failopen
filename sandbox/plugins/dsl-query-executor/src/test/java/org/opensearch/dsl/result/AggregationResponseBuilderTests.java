import org.opensearch.dsl.aggregation.bucket.BucketTranslator;  
    @SuppressWarnings("unchecked")
import static org.mockito.Mockito.mock;  
        InternalAggregations aggs = builder.build(List.of(avgAgg, termsAgg));  
/*  
        TermsAggregationBuilder termsAgg = new TermsAggregationBuilder("by_brand").field("brand")
        assertEquals(1, aggs.asList().size());
        return translator;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.opensearch.search.aggregations.InternalAggregation;  
import org.opensearch.dsl.aggregation.AggregationRegistry;
 * compatible open source license.
import org.opensearch.dsl.aggregation.metric.MetricTranslator;
        BucketTranslator<T> translator = mock(BucketTranslator.class);  
import org.opensearch.search.aggregations.AggregationBuilder;
    public void testBuildMetricWithNoResults() throws Exception {
        when(translator.getGrouping(any())).thenReturn(grouping);
        AggregationRegistry registry = new AggregationRegistry();
import static org.mockito.ArgumentMatchers.any;
import org.opensearch.dsl.aggregation.GroupingInfo;
    private <T extends AggregationBuilder> MetricTranslator<T> createMetricTranslator(Class<T> aggClass) {
 *
        AggregationResponseBuilder builder = new AggregationResponseBuilder(registry, List.of());  
        InternalAggregations aggs = builder.build(List.of(termsAgg));
        when(translator.getAggregationType()).thenReturn(aggClass);
        TermsAggregationBuilder termsAgg = new TermsAggregationBuilder("by_brand").field("brand");
    public void testBuildNestedAggregation() throws Exception {
        TermsAggregationBuilder termsAgg = new TermsAggregationBuilder("by_brand").field("brand");
            InternalAggregation agg = mock(InternalAggregation.class);  
        registry.register(createMetricTranslator(AvgAggregationBuilder.class));
        });  
    }  
        assertEquals(0, aggs.asList().size());
        assertEquals("avg_price", aggs.asList().get(0).getName());
        return translator;
        registry.register(createBucketTranslator(TermsAggregationBuilder.class, "brand"));
    }  
            .subAggregation(new AvgAggregationBuilder("avg_price").field("price"));  
            when(agg.getName()).thenReturn(inv.getArgument(0));
        AggregationResponseBuilder builder = new AggregationResponseBuilder(registry, List.of());  
    public void testBuildEmptyAggregations() throws Exception {
        assertNotNull(aggs);
package org.opensearch.dsl.result;
        registry.register(createBucketTranslator(TermsAggregationBuilder.class, "brand"));  
        registry.register(createBucketTranslator(TermsAggregationBuilder.class, "brand"));
        AggregationRegistry registry = new AggregationRegistry();  
    }
        AggregationResponseBuilder builder = new AggregationResponseBuilder(registry, List.of());  
        assertEquals(2, aggs.asList().size());
            InternalAggregation agg = mock(InternalAggregation.class);  
        registry.register(createMetricTranslator(AvgAggregationBuilder.class));
        GroupingInfo grouping = mock(GroupingInfo.class);  
        AggregationRegistry registry = new AggregationRegistry();  
 */  
            return agg;
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;  
        });  
    }
 * this file be licensed under the Apache-2.0 license or a
        AvgAggregationBuilder avgAgg = new AvgAggregationBuilder("avg_price").field("price");
        InternalAggregations aggs = builder.build(List.of());  
    }
}  
        assertEquals(1, aggs.asList().size());  
    public void testBuildBucketWithNoResults() throws Exception {
    private <T extends AggregationBuilder> BucketTranslator<T> createBucketTranslator(Class<T> aggClass, String fieldName) {
 * SPDX-License-Identifier: Apache-2.0
        AggregationResponseBuilder builder = new AggregationResponseBuilder(registry, List.of());
        when(translator.toInternalAggregation(any(), any(), any())).thenAnswer(inv -> {
        assertEquals("by_brand", aggs.asList().get(0).getName());
        InternalAggregations aggs = builder.build(List.of(termsAgg));  
        when(translator.toBucketAggregation(any(), any())).thenAnswer(inv -> {
import org.opensearch.test.OpenSearchTestCase;
        MetricTranslator<T> translator = mock(MetricTranslator.class);  
            return agg;
        when(translator.getSubAggregations(any())).thenReturn(List.of());  
    public void testBuildMultipleAggregations() throws Exception {
        AvgAggregationBuilder avgAgg = new AvgAggregationBuilder("avg_price").field("price");  
        assertEquals(1, aggs.asList().size());
        when(translator.getAggregationType()).thenReturn(aggClass);
import static org.mockito.Mockito.when;
 * The OpenSearch Contributors require contributions made to  
public class AggregationResponseBuilderTests extends OpenSearchTestCase {  
        when(grouping.getFieldNames()).thenReturn(List.of(fieldName));
    @SuppressWarnings("unchecked")
        AggregationRegistry registry = new AggregationRegistry();  
    }  
    }
        InternalAggregations aggs = builder.build(List.of(avgAgg));  
        AggregationRegistry registry = new AggregationRegistry();  
        assertEquals("by_brand", aggs.asList().get(0).getName());
import java.util.List;  
import org.opensearch.search.aggregations.InternalAggregations;
        AggregationResponseBuilder builder = new AggregationResponseBuilder(registry, List.of());
        registry.register(createMetricTranslator(AvgAggregationBuilder.class));
            when(agg.getName()).thenReturn(((AggregationBuilder) inv.getArgument(0)).getName());

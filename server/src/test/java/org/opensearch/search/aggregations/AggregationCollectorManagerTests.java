        final AggregationCollectorManager testAggCollectorManager = new NonGlobalAggCollectorManagerWithSingleCollector(context);
 * compatible open source license.
            aggregatorFactories,  
        Collector aggCollector = testAggCollectorManager.newCollector();  
        expectThrows(AssertionError.class, () -> new NonGlobalAggCollectorManagerWithSingleCollector(context));
    public void testNonGlobalCollectorManagers() throws Exception {  
            aggregatorFactories,
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)
        );
        expectThrows(AssertionError.class, () -> new GlobalAggCollectorManagerWithSingleCollector(context));
        expectThrows(AssertionError.class, () -> nonGlobalCM.reduce(collectorsList));
        final Collector expectedCollector = collectorManager.newCollector();  
        assertTrue(globalAggCollector instanceof BucketCollector);  
        SearchContextAggregations contextAggregations = new SearchContextAggregations(
        }
        assertEquals(CollectorResult.REASON_AGGREGATION, testAggCollectorManager.getCollectorReason());
        for (int i = 0; i < randomIntBetween(2, 5); ++i) {
            if (collectorManager instanceof GlobalAggCollectorManagerWithSingleCollector  
    }  
import org.opensearch.search.profile.query.CollectorResult;  
                assertSame(expectedCollector, newCollector);  
        final AggregatorFactories aggregatorFactories = getAggregationFactories(globalAgg);
import org.opensearch.search.aggregations.bucket.global.GlobalAggregator;
public class AggregationCollectorManagerTests extends AggregationSetupTests {
        AggregatorFactories aggregatorFactories = getAggregationFactories(globalAgg);
        );  
        final SearchContextAggregations contextAggregations = new SearchContextAggregations(
            }
        assertEquals(CollectorResult.REASON_AGGREGATION_GLOBAL, testAggCollectorManager.getCollectorReason());
    public void testAggCollectorManagersWithBothGlobalNonGlobalAggregators() throws Exception {
        assertEquals(CollectorResult.REASON_AGGREGATION_GLOBAL, testGlobalAggCollectorManager.getCollectorReason());  
        testCollectorManagerCommon(testAggCollectorManager);
        contextAggregations = new SearchContextAggregations(
        );
        expectThrows(AssertionError.class, () -> new GlobalAggCollectorManager(context));
        assertTrue(aggCollector instanceof BucketCollector);
        assertTrue(aggCollector instanceof BucketCollector);
                // calling the newCollector multiple times should return the same instance each time
        context.aggregations(contextAggregations);  
    }
    }  
        testCollectorManagerCommon(testGlobalAggCollectorManager);  
        final AggregationCollectorManager testAggCollectorManager = new NonGlobalAggCollectorManagerWithSingleCollector(context);
    }
        Collector globalAggCollector = testGlobalAggCollectorManager.newCollector();
}
        assertEquals(CollectorResult.REASON_AGGREGATION, testAggCollectorManager.getCollectorReason());  
        assertEquals(CollectorResult.REASON_AGGREGATION, testAggCollectorManager.getCollectorReason());
        context.aggregations(contextAggregations);
        final AggregatorFactories aggregatorFactories = getAggregationFactories(globalNonGlobalAggs);
    }
        context.aggregations(contextAggregations);  
        );
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)
            aggregatorFactories,  
        final AggregatorFactories aggregatorFactories = getAggregationFactories(multipleNonGlobalAggs);
            aggregatorFactories,  
        );
            } else if (collectorManager instanceof GlobalAggCollectorManager || collectorManager instanceof NonGlobalAggCollectorManager) {
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(aggCollector instanceof GlobalAggregator);
        // test NonGlobalCollectorManager which will be used in concurrent segment search case  
        int expectedAggCount = 2;
        assertEquals(CollectorResult.REASON_AGGREGATION_GLOBAL, testAggCollectorManager.getCollectorReason());  
        testCollectorManagerCommon(testGlobalAggCollectorManager);
 * The OpenSearch Contributors require contributions made to  
    public void testAssertionWhenCollectorManagerCreatesNoOPCollector() throws Exception {  
        final SearchContextAggregations contextAggregations = new SearchContextAggregations(  
        final GlobalAggCollectorManager testGlobalAggCollectorManager = new GlobalAggCollectorManager(context);
        // test GlobalAggCollectorManager which will be used in concurrent segment search case
            aggregatorFactories,  
        SearchContextAggregations contextAggregations = new SearchContextAggregations(
                // calling the newCollector multiple times should not return the same instance each time
        Collector aggCollector = testAggCollectorManager.newCollector();  
        final AggregationCollectorManager testAggCollectorManager = new GlobalAggCollectorManagerWithSingleCollector(context);
        assertTrue(globalAggCollector instanceof GlobalAggregator);
        context.aggregations(contextAggregations);
    public void testGlobalCollectorManagers() throws Exception {  
            final Collector newCollector = collectorManager.newCollector();
        final AggregationCollectorManager testGlobalAggCollectorManager = new GlobalAggCollectorManagerWithSingleCollector(context);
import org.apache.lucene.search.Collector;
import static org.mockito.Mockito.mock;
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)
        AggregationCollectorManager nonGlobalCM = new NonGlobalAggCollectorManagerWithSingleCollector(context);  
        AggregatorFactories aggregatorFactories = getAggregationFactories(globalNonGlobalAggs);  
        AggregationCollectorManager globalCM = new GlobalAggCollectorManagerWithSingleCollector(context);
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)  
        final SearchContextAggregations contextAggregations = new SearchContextAggregations(
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)
 *
        testCollectorManagerCommon(testNonGlobalAggCollectorManager);
 * this file be licensed under the Apache-2.0 license or a
        expectThrows(AssertionError.class, () -> globalCM.reduce(collectorsList));
    public void testAssertionInSingleCollectorCMReduce() throws Exception {
package org.opensearch.search.aggregations;
    private void testCollectorManagerCommon(AggregationCollectorManager collectorManager) throws Exception {
        assertEquals(expectedAggCount, ((MultiBucketCollector) aggCollector).getCollectors().length);
import java.util.List;  
                || collectorManager instanceof NonGlobalAggCollectorManagerWithSingleCollector) {
        context.aggregations(contextAggregations);  
        testCollectorManagerCommon(testAggCollectorManager);  
        final NonGlobalAggCollectorManager testNonGlobalAggCollectorManager = new NonGlobalAggCollectorManager(context);
        context.aggregations(contextAggregations);  
        aggregatorFactories = getAggregationFactories(multipleNonGlobalAggs);
        assertTrue(aggCollector instanceof MultiBucketCollector);
/*  
        );
    }  
        expectThrows(AssertionError.class, () -> new NonGlobalAggCollectorManager(context));
                assertNotSame(expectedCollector, newCollector);  
        testCollectorManagerCommon(testAggCollectorManager);  
import java.util.ArrayList;
        collectorsList.add(mock(Collector.class));  
 */  
        List<Collector> collectorsList = new ArrayList<>();
        Collector aggCollector = testAggCollectorManager.newCollector();
            aggregatorFactories,

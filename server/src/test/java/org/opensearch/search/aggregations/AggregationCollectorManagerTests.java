        );
 */
        expectThrows(AssertionError.class, () -> globalCM.reduce(collectorsList));
/*
 * SPDX-License-Identifier: Apache-2.0
                || collectorManager instanceof NonGlobalAggCollectorManagerWithSingleCollector) {
        expectThrows(AssertionError.class, () -> new NonGlobalAggCollectorManager(context));
        final AggregatorFactories aggregatorFactories = getAggregationFactories(multipleNonGlobalAggs);
    public void testAssertionInSingleCollectorCMReduce() throws Exception {
        SearchContextAggregations contextAggregations = new SearchContextAggregations(
            aggregatorFactories,
        AggregationCollectorManager nonGlobalCM = new NonGlobalAggCollectorManagerWithSingleCollector(context);
            aggregatorFactories,
        assertTrue(globalAggCollector instanceof BucketCollector);
            aggregatorFactories,
        final SearchContextAggregations contextAggregations = new SearchContextAggregations(
package org.opensearch.search.aggregations;
        assertEquals(expectedAggCount, ((MultiBucketCollector) aggCollector).getCollectors().length);
 * compatible open source license.
        final GlobalAggCollectorManager testGlobalAggCollectorManager = new GlobalAggCollectorManager(context);
        final SearchContextAggregations contextAggregations = new SearchContextAggregations(
        final SearchContextAggregations contextAggregations = new SearchContextAggregations(
        List<Collector> collectorsList = new ArrayList<>();
            aggregatorFactories,
import org.opensearch.search.profile.query.CollectorResult;
                assertNotSame(expectedCollector, newCollector);
        assertEquals(CollectorResult.REASON_AGGREGATION, testAggCollectorManager.getCollectorReason());
        final Collector expectedCollector = collectorManager.newCollector();
    public void testAggCollectorManagersWithBothGlobalNonGlobalAggregators() throws Exception {
        final AggregatorFactories aggregatorFactories = getAggregationFactories(globalNonGlobalAggs);
        context.aggregations(contextAggregations);
        AggregatorFactories aggregatorFactories = getAggregationFactories(globalAgg);
        );
import org.opensearch.search.aggregations.bucket.global.GlobalAggregator;
                // calling the newCollector multiple times should not return the same instance each time
    }
        final AggregationCollectorManager testGlobalAggCollectorManager = new GlobalAggCollectorManagerWithSingleCollector(context);
            final Collector newCollector = collectorManager.newCollector();
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)
            aggregatorFactories,
        testCollectorManagerCommon(testAggCollectorManager);
    public void testAssertionWhenCollectorManagerCreatesNoOPCollector() throws Exception {
        expectThrows(AssertionError.class, () -> new GlobalAggCollectorManagerWithSingleCollector(context));
        int expectedAggCount = 2;
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)
        assertEquals(CollectorResult.REASON_AGGREGATION, testAggCollectorManager.getCollectorReason());
        );
        collectorsList.add(mock(Collector.class));
        assertTrue(aggCollector instanceof MultiBucketCollector);
        context.aggregations(contextAggregations);
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)
        final NonGlobalAggCollectorManager testNonGlobalAggCollectorManager = new NonGlobalAggCollectorManager(context);
}
                // calling the newCollector multiple times should return the same instance each time
import java.util.ArrayList;
        Collector globalAggCollector = testGlobalAggCollectorManager.newCollector();
import java.util.List;
        assertEquals(CollectorResult.REASON_AGGREGATION_GLOBAL, testGlobalAggCollectorManager.getCollectorReason());
            }
        Collector aggCollector = testAggCollectorManager.newCollector();
import static org.mockito.Mockito.mock;
        expectThrows(AssertionError.class, () -> nonGlobalCM.reduce(collectorsList));
public class AggregationCollectorManagerTests extends AggregationSetupTests {
    }
 * The OpenSearch Contributors require contributions made to
        );
        Collector aggCollector = testAggCollectorManager.newCollector();
            } else if (collectorManager instanceof GlobalAggCollectorManager || collectorManager instanceof NonGlobalAggCollectorManager) {
        testCollectorManagerCommon(testAggCollectorManager);
                assertSame(expectedCollector, newCollector);
        AggregationCollectorManager globalCM = new GlobalAggCollectorManagerWithSingleCollector(context);
        AggregatorFactories aggregatorFactories = getAggregationFactories(globalNonGlobalAggs);
        context.aggregations(contextAggregations);
        }
        testCollectorManagerCommon(testNonGlobalAggCollectorManager);
    public void testGlobalCollectorManagers() throws Exception {
    private void testCollectorManagerCommon(AggregationCollectorManager collectorManager) throws Exception {
        contextAggregations = new SearchContextAggregations(
        for (int i = 0; i < randomIntBetween(2, 5); ++i) {
    }
        testCollectorManagerCommon(testAggCollectorManager);
            if (collectorManager instanceof GlobalAggCollectorManagerWithSingleCollector
        assertTrue(globalAggCollector instanceof GlobalAggregator);
        final AggregatorFactories aggregatorFactories = getAggregationFactories(globalAgg);
    }
        assertEquals(CollectorResult.REASON_AGGREGATION_GLOBAL, testAggCollectorManager.getCollectorReason());
    public void testNonGlobalCollectorManagers() throws Exception {
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)
    }
        testCollectorManagerCommon(testGlobalAggCollectorManager);
        Collector aggCollector = testAggCollectorManager.newCollector();
        SearchContextAggregations contextAggregations = new SearchContextAggregations(
        final AggregationCollectorManager testAggCollectorManager = new NonGlobalAggCollectorManagerWithSingleCollector(context);
        // test GlobalAggCollectorManager which will be used in concurrent segment search case
        assertEquals(CollectorResult.REASON_AGGREGATION, testAggCollectorManager.getCollectorReason());
        assertTrue(aggCollector instanceof BucketCollector);
        context.aggregations(contextAggregations);
        expectThrows(AssertionError.class, () -> new NonGlobalAggCollectorManagerWithSingleCollector(context));
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)
        final AggregationCollectorManager testAggCollectorManager = new NonGlobalAggCollectorManagerWithSingleCollector(context);
import org.apache.lucene.search.Collector;
        );
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)
        final AggregationCollectorManager testAggCollectorManager = new GlobalAggCollectorManagerWithSingleCollector(context);
    }
        // test NonGlobalCollectorManager which will be used in concurrent segment search case
        testCollectorManagerCommon(testGlobalAggCollectorManager);
        );
        assertEquals(CollectorResult.REASON_AGGREGATION_GLOBAL, testAggCollectorManager.getCollectorReason());
            aggregatorFactories,
 *
        assertTrue(aggCollector instanceof BucketCollector);
        aggregatorFactories = getAggregationFactories(multipleNonGlobalAggs);
        assertFalse(aggCollector instanceof GlobalAggregator);
        expectThrows(AssertionError.class, () -> new GlobalAggCollectorManager(context));
        context.aggregations(contextAggregations);
        context.aggregations(contextAggregations);
 * this file be licensed under the Apache-2.0 license or a

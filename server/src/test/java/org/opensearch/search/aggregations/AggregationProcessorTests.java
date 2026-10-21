    public void testPreProcessWithNoAggregations() {
        // Build a ContextIndexSearcher that stubs slices to return slicesToReturn. Slices is protected in IndexReader
    private void testPreProcessCommon(String agg, int expectedGlobalAggs, int expectedNonGlobalAggs) throws Exception {
            collectorManager.reduce(nonGlobalCollectors).reduce(context.queryResult());
            createdNonGlobalCollectors.add(aggCollector);
        } else if (expectedNonGlobalAggs > 1) {
import static org.mockito.Mockito.times;
    public void testPreProcessWithOnlyGlobalAggregator() throws Exception {
                mock(ExecutorService.class),
                assertEquals(2, context.getProfilers().getQueryProfilers().size());
        int numSlices,
        );
            assertTrue(aggCollector instanceof BucketCollector);
        } else if (expectedGlobalAggs == 0) {
            assertFalse(aggCollector instanceof GlobalAggregator);
import static org.mockito.Mockito.doReturn;
            createdGlobalCollectors.add(aggCollector);
                assertFalse(currentCollector instanceof GlobalAggregator);
        } else {
                nonGlobalCollectors.add(context.queryCollectorManagers().get(NonGlobalAggCollectorManager.class).newCollector());
import org.opensearch.search.internal.ContextIndexSearcher;
            ) {
    public void testPostProcessWithNonGlobalAggregatorsAndSingleSlice() throws Exception {
package org.opensearch.search.aggregations;
            collectorManager = (AggregationCollectorManager) context.queryCollectorManagers().get(GlobalAggCollectorManager.class);
        final IndexSearcher.LeafSlice[] slicesToReturn = new IndexSearcher.LeafSlice[numSlices];
import org.apache.lucene.search.Query;
    }
            createdGlobalCollectors.add(aggCollector);
 * this file be licensed under the Apache-2.0 license or a
        int expectedNonGlobalAggsPerSlice,
    public void testPostProcessWithNonGlobalAggregatorsAndMultipleSlices() throws Exception {
            globalCollectorManager = context.queryCollectorManagers().get(GlobalAggCollectorManager.class);
    }
import org.opensearch.search.profile.query.CollectorResult;
            assertTrue(aggCollector instanceof MultiBucketCollector);
            assertTrue(aggCollector instanceof BucketCollector);
import static org.mockito.Mockito.mock;
        final DirectoryReader reader;
            aggregatorFactories,
    }
import org.opensearch.search.aggregations.bucket.global.GlobalAggregator;
        assertTrue(context.queryResult().hasAggs());
    }
                globalCollectors.add(context.queryCollectorManagers().get(GlobalAggCollectorManager.class).newCollector());
            assertTrue(context.queryCollectorManagers().isEmpty());
        assertNull(context.aggregations());
        Collection<Collector> createdGlobalCollectors
    ) throws Exception {
            }
    }
        if (expectedGlobalAggs > 0) {
            }
        // will be equal to sum of expected global and nonglobal aggs
import org.apache.lucene.search.CollectorManager;
            assertTrue(context.queryCollectorManagers().containsKey(GlobalAggCollectorManager.class));
import org.opensearch.search.query.ReduceableSearchResult;
                randomBoolean(),
        assertTrue(context.queryResult().hasAggs());
            globalCollectorManager = context.queryCollectorManagers().get(GlobalAggCollectorManager.class);
        context.aggregations(contextAggregations);
import static org.mockito.Mockito.verify;
            return;
        Collector aggCollector;
                context.bucketCollectorProcessor().processPostCollection(c);
                protected LeafSlice[] slices(List<LeafReaderContext> leaves) {
            for (Collector currentCollector : ((MultiBucketCollector) aggCollector).getCollectors()) {
}
import java.util.concurrent.ExecutorService;
    }
 */
            aggCollector = nonGlobalCollectorManager.newCollector();
        String agg,
        int expectedGlobalAggs,
                    return slicesToReturn;
        }
            assertTrue(context.queryCollectorManagers().containsKey(NonGlobalAggCollectorManager.class));
                context.bucketCollectorProcessor().processPostCollection(c);
    public void testPreProcessWithOnlyNonGlobalAggregators() throws Exception {
        testAggregationProcessor.preProcess(context);
        final Collection<Collector> globalCollectors = new ArrayList<>();
                assertTrue(currentCollector instanceof GlobalAggregator);
            assertTrue(aggCollector instanceof GlobalAggregator);
    }
import org.apache.lucene.index.LeafReaderContext;
            }
            }
        }
            for (Collector currentCollector : ((MultiBucketCollector) aggCollector).getCollectors()) {
import java.util.Collection;
        }
/*
        assertTrue(context.queryCollectorManagers().isEmpty());
            reader = searcher.getDirectoryReader();
import java.util.ArrayList;
        final Collection<Collector> nonGlobalCollectors = new ArrayList<>();
        if (expectedGlobalAggs > 0) {
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)
        }
        testPostProcessCommon(globalNonGlobalAggs, randomIntBetween(2, 5), 1, 1, false);
            collectorManager = (AggregationCollectorManager) context.queryCollectorManagers().get(NonGlobalAggCollectorManager.class);
                .search(nullable(Query.class), ArgumentMatchers.<CollectorManager<?, ReduceableSearchResult>>any());
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.test.TestSearchContext;
import java.util.List;
 * The OpenSearch Contributors require contributions made to
            }
        testPreProcessCommon(globalAgg, 1, 0);
            assertTrue(context.queryCollectorManagers().containsKey(GlobalAggCollectorManager.class));
        final AggregatorFactories aggregatorFactories = getAggregationFactories(agg);
        testPreProcessCommon(aggs, expectedGlobalAggs, expectedNonGlobalAggsPerSlice, nonGlobalCollectors, globalCollectors);
        ContextIndexSearcher testSearcher = spy(
        AggregationCollectorManager collectorManager;
            createdNonGlobalCollectors.add(aggCollector);
        testPostProcessCommon(multipleNonGlobalAggs, 1, 0, 2, false);
public class AggregationProcessorTests extends AggregationSetupTests {
        CollectorManager<?, ?> nonGlobalCollectorManager = null;
        testPreProcessCommon(globalNonGlobalAggs, 1, 1);
            verify(testSearcher, times(1)).search(nullable(Query.class), ArgumentMatchers.<CollectorManager<?, ?>>any());
        }
            aggCollector = globalCollectorManager.newCollector();
    }
            }
    public void testPostProcessGlobalAndNonGlobalAggregators() throws Exception {
            new ContextIndexSearcher(
            nonGlobalCollectorManager = context.queryCollectorManagers().get(NonGlobalAggCollectorManager.class);
 *
        testPreProcessCommon(agg, expectedGlobalAggs, expectedNonGlobalAggs, new ArrayList<>(), new ArrayList<>());
        ((TestSearchContext) context).setSearcher(testSearcher);
                }
    private final AggregationProcessor testAggregationProcessor = new ConcurrentAggregationProcessor();
        testAggregationProcessor.postProcess(context);
            aggCollector = globalCollectorManager.newCollector();
        testPreProcessCommon(multipleNonGlobalAggs, 0, 2);
        for (int i = 1; i < numSlices; ++i) {
        // newCollector is initialized once in the collector manager constructor
            if (withProfilers) {
            doReturn(result).when(testSearcher)
import org.apache.lucene.search.Collector;
        } else if (expectedGlobalAggs > 1) {
        String aggs,
        }
        if (expectedNonGlobalAggs == 0 && expectedGlobalAggs == 0) {
                );
import static org.mockito.ArgumentMatchers.nullable;
                reader,
                IndexSearcher.getDefaultQueryCache(),
                @Override
        try (Engine.Searcher searcher = context.indexShard().acquireSearcher("test")) {
        }
    ) throws Exception {
        // after shard level reduce it should have only 1 InternalAggregation instance for each agg in request and internal aggregation
            for (Collector c : globalCollectors) {
        CollectorManager<?, ?> globalCollectorManager = null;
        } else if (expectedGlobalAggs > 0 && expectedNonGlobalAggs > 0) {
                context
            ReduceableSearchResult result = collectorManager.reduce(globalCollectors);
        final SearchContextAggregations contextAggregations = new SearchContextAggregations(
            }
            ((TestSearchContext) context).withProfilers();
    public void testPostProcessGlobalAndNonGlobalAggregatorsWithProfilers() throws Exception {
        assertEquals(expectedNonGlobalAggsPerSlice + expectedGlobalAggs, context.queryResult().aggregations().expand().aggregations.size());
            assertTrue(aggCollector instanceof MultiBucketCollector);
                IndexSearcher.getDefaultQueryCachingPolicy(),
            nonGlobalCollectorManager = context.queryCollectorManagers().get(NonGlobalAggCollectorManager.class);
        if (expectedNonGlobalAggsPerSlice > 0) {
    private void testPreProcessCommon(
        Collection<Collector> createdNonGlobalCollectors,
import org.apache.lucene.search.IndexSearcher;
            if (expectedGlobalAggs > 0) {
            if (expectedNonGlobalAggsPerSlice > 0) {
            assertTrue(context.queryCollectorManagers().containsKey(NonGlobalAggCollectorManager.class));
    }
import org.mockito.ArgumentMatchers;
    }
                // First profiler is from withProfilers() call, second one is from postProcess() call
 * SPDX-License-Identifier: Apache-2.0
        }
        if (expectedGlobalAggs == 1) {
 * compatible open source license.
            for (Collector c : nonGlobalCollectors) {
        assertTrue(context.queryCollectorManagers().isEmpty());
        );
        boolean withProfilers
import org.opensearch.index.engine.Engine;
        if (withProfilers) {
                assertEquals(
        testPostProcessCommon(globalNonGlobalAggs, randomIntBetween(2, 5), 1, 1, true);
        }
            aggCollector = nonGlobalCollectorManager.newCollector();
        testPostProcessCommon(multipleNonGlobalAggs, randomIntBetween(2, 5), 0, 2, false);
                IndexSearcher.getDefaultSimilarity(),
    public void testPreProcessWithGlobalAndNonGlobalAggregators() throws Exception {
                    CollectorResult.REASON_AGGREGATION_GLOBAL,
    private void testPostProcessCommon(
            assertFalse(context.queryCollectorManagers().containsKey(NonGlobalAggCollectorManager.class));
            assertFalse(context.queryCollectorManagers().containsKey(GlobalAggCollectorManager.class));
    }
        // for global aggs verify that search.search is called with CollectionManager
        int expectedGlobalAggs,
        // so this builds a real object. The DirectoryReader fetched to build the object is not used for any searches.
        testAggregationProcessor.preProcess(context);
        if (expectedNonGlobalAggs == 1) {
        int expectedNonGlobalAggs,
                    context.getProfilers().getQueryProfilers().get(1).getCollector().getReason()
            }
import static org.mockito.Mockito.spy;

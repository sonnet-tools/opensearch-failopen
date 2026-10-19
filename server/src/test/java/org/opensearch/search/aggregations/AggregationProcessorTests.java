        // for global aggs verify that search.search is called with CollectionManager
    private void testPreProcessCommon(String agg, int expectedGlobalAggs, int expectedNonGlobalAggs) throws Exception {
            collectorManager = (AggregationCollectorManager) context.queryCollectorManagers().get(NonGlobalAggCollectorManager.class);
        }
        // Build a ContextIndexSearcher that stubs slices to return slicesToReturn. Slices is protected in IndexReader  
            assertTrue(aggCollector instanceof GlobalAggregator);
import org.opensearch.test.TestSearchContext;  
            ((TestSearchContext) context).withProfilers();
    public void testPreProcessWithNoAggregations() {
        testPreProcessCommon(aggs, expectedGlobalAggs, expectedNonGlobalAggsPerSlice, nonGlobalCollectors, globalCollectors);  
import org.apache.lucene.search.Collector;  
            verify(testSearcher, times(1)).search(nullable(Query.class), ArgumentMatchers.<CollectorManager<?, ?>>any());
        testPostProcessCommon(globalNonGlobalAggs, randomIntBetween(2, 5), 1, 1, false);  
            aggCollector = globalCollectorManager.newCollector();
import java.util.List;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.LeafReaderContext;
            }  
        AggregationCollectorManager collectorManager;  
            mock(MultiBucketConsumerService.MultiBucketConsumer.class)  
        try (Engine.Searcher searcher = context.indexShard().acquireSearcher("test")) {  
        int expectedGlobalAggs,
import static org.mockito.Mockito.doReturn;
import org.opensearch.search.aggregations.bucket.global.GlobalAggregator;
        }
        } else if (expectedGlobalAggs > 1) {  
                context
package org.opensearch.search.aggregations;
                }
        CollectorManager<?, ?> nonGlobalCollectorManager = null;
        ((TestSearchContext) context).setSearcher(testSearcher);
        testAggregationProcessor.postProcess(context);  
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.spy;  
public class AggregationProcessorTests extends AggregationSetupTests {
            assertTrue(aggCollector instanceof BucketCollector);  
                assertEquals(2, context.getProfilers().getQueryProfilers().size());
    ) throws Exception {  
        if (expectedNonGlobalAggs == 0 && expectedGlobalAggs == 0) {  
    public void testPreProcessWithOnlyNonGlobalAggregators() throws Exception {
 *
        int expectedNonGlobalAggs,
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 1; i < numSlices; ++i) {
    }
            aggCollector = nonGlobalCollectorManager.newCollector();
        }
    }
        Collection<Collector> createdGlobalCollectors
            doReturn(result).when(testSearcher)
            aggCollector = globalCollectorManager.newCollector();
                    context.getProfilers().getQueryProfilers().get(1).getCollector().getReason()
            assertTrue(context.queryCollectorManagers().containsKey(NonGlobalAggCollectorManager.class));  
        Collection<Collector> createdNonGlobalCollectors,  
import org.opensearch.search.query.ReduceableSearchResult;
    }  
            nonGlobalCollectorManager = context.queryCollectorManagers().get(NonGlobalAggCollectorManager.class);
import org.opensearch.search.internal.ContextIndexSearcher;  
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(aggCollector instanceof MultiBucketCollector);  
        } else if (expectedGlobalAggs == 0) {
        final Collection<Collector> nonGlobalCollectors = new ArrayList<>();
        testPreProcessCommon(agg, expectedGlobalAggs, expectedNonGlobalAggs, new ArrayList<>(), new ArrayList<>());
        }
        }
        final DirectoryReader reader;
            nonGlobalCollectorManager = context.queryCollectorManagers().get(NonGlobalAggCollectorManager.class);
        if (expectedNonGlobalAggsPerSlice > 0) {
    private final AggregationProcessor testAggregationProcessor = new ConcurrentAggregationProcessor();
        context.aggregations(contextAggregations);
    public void testPreProcessWithOnlyGlobalAggregator() throws Exception {  
        final IndexSearcher.LeafSlice[] slicesToReturn = new IndexSearcher.LeafSlice[numSlices];
 */  
    }
    }  
            createdGlobalCollectors.add(aggCollector);
        assertTrue(context.queryResult().hasAggs());
                assertEquals(
        testPostProcessCommon(multipleNonGlobalAggs, 1, 0, 2, false);
            globalCollectorManager = context.queryCollectorManagers().get(GlobalAggCollectorManager.class);  
import static org.mockito.Mockito.verify;
}
            createdGlobalCollectors.add(aggCollector);  
import org.apache.lucene.search.CollectorManager;
    private void testPreProcessCommon(
        assertEquals(expectedNonGlobalAggsPerSlice + expectedGlobalAggs, context.queryResult().aggregations().expand().aggregations.size());
    }
            for (Collector c : nonGlobalCollectors) {  
        }
            assertFalse(context.queryCollectorManagers().containsKey(NonGlobalAggCollectorManager.class));
        if (expectedGlobalAggs > 0) {  
        int expectedGlobalAggs,  
                @Override
import java.util.concurrent.ExecutorService;
            }
                IndexSearcher.getDefaultQueryCachingPolicy(),
            assertTrue(context.queryCollectorManagers().containsKey(GlobalAggCollectorManager.class));
            assertTrue(aggCollector instanceof BucketCollector);
            if (withProfilers) {
        testAggregationProcessor.preProcess(context);  
        assertTrue(context.queryCollectorManagers().isEmpty());  
    public void testPreProcessWithGlobalAndNonGlobalAggregators() throws Exception {
                nonGlobalCollectors.add(context.queryCollectorManagers().get(NonGlobalAggCollectorManager.class).newCollector());
        }  
    ) throws Exception {
            assertTrue(context.queryCollectorManagers().containsKey(NonGlobalAggCollectorManager.class));
            createdNonGlobalCollectors.add(aggCollector);
        testAggregationProcessor.preProcess(context);
            assertTrue(context.queryCollectorManagers().isEmpty());
/*  
        final SearchContextAggregations contextAggregations = new SearchContextAggregations(
            aggCollector = nonGlobalCollectorManager.newCollector();  
            assertTrue(context.queryCollectorManagers().containsKey(GlobalAggCollectorManager.class));
        } else {  
                // First profiler is from withProfilers() call, second one is from postProcess() call  
            }  
                randomBoolean(),  
import org.apache.lucene.search.Query;  
    public void testPostProcessWithNonGlobalAggregatorsAndSingleSlice() throws Exception {  
    private void testPostProcessCommon(  
        // will be equal to sum of expected global and nonglobal aggs  
        String agg,  
                .search(nullable(Query.class), ArgumentMatchers.<CollectorManager<?, ReduceableSearchResult>>any());  
                    CollectorResult.REASON_AGGREGATION_GLOBAL,  
        if (expectedGlobalAggs > 0) {
import java.util.ArrayList;
        );
                IndexSearcher.getDefaultQueryCache(),
                context.bucketCollectorProcessor().processPostCollection(c);
        if (expectedGlobalAggs == 1) {
        Collector aggCollector;  
        final Collection<Collector> globalCollectors = new ArrayList<>();
        boolean withProfilers
    }
        assertTrue(context.queryResult().hasAggs());
    }
                globalCollectors.add(context.queryCollectorManagers().get(GlobalAggCollectorManager.class).newCollector());
            aggregatorFactories,
        testPreProcessCommon(globalNonGlobalAggs, 1, 1);
        } else if (expectedNonGlobalAggs > 1) {
            for (Collector currentCollector : ((MultiBucketCollector) aggCollector).getCollectors()) {
        testPostProcessCommon(globalNonGlobalAggs, randomIntBetween(2, 5), 1, 1, true);
            if (expectedGlobalAggs > 0) {  
            if (expectedNonGlobalAggsPerSlice > 0) {  
import java.util.Collection;  
        } else if (expectedGlobalAggs > 0 && expectedNonGlobalAggs > 0) {  
        // after shard level reduce it should have only 1 InternalAggregation instance for each agg in request and internal aggregation
            reader = searcher.getDirectoryReader();
import org.apache.lucene.search.IndexSearcher;
            ReduceableSearchResult result = collectorManager.reduce(globalCollectors);
import static org.mockito.ArgumentMatchers.nullable;  
    }  
 * The OpenSearch Contributors require contributions made to  
            globalCollectorManager = context.queryCollectorManagers().get(GlobalAggCollectorManager.class);  
        int numSlices,
    }
        // newCollector is initialized once in the collector manager constructor
        testPostProcessCommon(multipleNonGlobalAggs, randomIntBetween(2, 5), 0, 2, false);
        String aggs,
        }  
                protected LeafSlice[] slices(List<LeafReaderContext> leaves) {
            collectorManager.reduce(nonGlobalCollectors).reduce(context.queryResult());  
            assertFalse(aggCollector instanceof GlobalAggregator);
            ) {  
            assertTrue(aggCollector instanceof MultiBucketCollector);
        }
import org.opensearch.index.engine.Engine;
    public void testPostProcessWithNonGlobalAggregatorsAndMultipleSlices() throws Exception {
            assertFalse(context.queryCollectorManagers().containsKey(GlobalAggCollectorManager.class));
import org.opensearch.search.profile.query.CollectorResult;
                context.bucketCollectorProcessor().processPostCollection(c);
        testPreProcessCommon(multipleNonGlobalAggs, 0, 2);  
                IndexSearcher.getDefaultSimilarity(),  
            for (Collector currentCollector : ((MultiBucketCollector) aggCollector).getCollectors()) {  
                assertTrue(currentCollector instanceof GlobalAggregator);
    public void testPostProcessGlobalAndNonGlobalAggregatorsWithProfilers() throws Exception {  
        assertTrue(context.queryCollectorManagers().isEmpty());  
        // so this builds a real object. The DirectoryReader fetched to build the object is not used for any searches.
 * compatible open source license.
            for (Collector c : globalCollectors) {
                reader,
        ContextIndexSearcher testSearcher = spy(  
        if (withProfilers) {  
            }
    public void testPostProcessGlobalAndNonGlobalAggregators() throws Exception {
import org.mockito.ArgumentMatchers;
            new ContextIndexSearcher(
        final AggregatorFactories aggregatorFactories = getAggregationFactories(agg);  
            }  
        CollectorManager<?, ?> globalCollectorManager = null;
        assertNull(context.aggregations());
            createdNonGlobalCollectors.add(aggCollector);
    }
        if (expectedNonGlobalAggs == 1) {  
                    return slicesToReturn;  
            }
        );  
import static org.mockito.Mockito.mock;
            return;
                );
        int expectedNonGlobalAggsPerSlice,
                assertFalse(currentCollector instanceof GlobalAggregator);
                mock(ExecutorService.class),
            collectorManager = (AggregationCollectorManager) context.queryCollectorManagers().get(GlobalAggCollectorManager.class);  
            }
        testPreProcessCommon(globalAgg, 1, 0);
            }

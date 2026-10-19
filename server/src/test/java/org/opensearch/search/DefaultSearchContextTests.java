                @Override
                null,
                    "Result window is too large, from + size must be less than or equal to:"
import org.apache.lucene.search.QueryCachingPolicy;
import org.opensearch.common.settings.Setting;
import org.opensearch.search.deciders.ConcurrentSearchDecision;
                public Optional<ConcurrentSearchRequestDecider> create(IndexSettings indexSettings) {
        BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
                null,
                        + "]. This limit can be set by changing the ["
            concurrentSearchRequestDeciders.add(factory2);
import org.opensearch.index.query.QueryBuilder;
                null,
            );
import org.opensearch.core.index.shard.ShardId;
package org.opensearch.search;
        QueryCachingPolicy queryCachingPolicy = mock(QueryCachingPolicy.class);
                )
                randomNonNegativeLong(),
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    .put(SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
                executor,
                bigArrays,
                new SortAndFormats(new Sort(new SortField("test2", SortField.Type.INT)), new DocValueFormat[] { DocValueFormat.RAW })
import org.opensearch.search.internal.ReaderContext;
            final ClusterService clusterService = mock(ClusterService.class);
                Collections.emptyList()
                false,
                readerContext,
        when(shardSearchRequest.searchType()).thenReturn(SearchType.DEFAULT);
            context.evaluateRequestShouldUseConcurrentSearch();
                shardSearchRequest,
                    try {
                public Optional<ConcurrentSearchRequestDecider> create(IndexSettings indexSettings) {
        when(indexShard.getThreadPool()).thenReturn(threadPool);
                executor,
import org.opensearch.action.OriginalIndices;
import static org.mockito.Mockito.anyBoolean;
                false,
                        + "] is too large. It must "
/*
            clusterSettings.registerSetting(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE);
                null,
        Settings settings = Settings.builder()
            assertThat(
            context.aggregations(mockAggregations);
import static org.hamcrest.Matchers.is;
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
                bigArrays,
            when(filterSlice.toFilter(any(), any(), any(), any())).thenReturn(new TermQuery(new Term("field", "value")));
            concurrentSearchRequestDeciders.add(factory3);
            );
                clusterService,
import org.opensearch.threadpool.ThreadPool;
            context.aggregations(mockAggregations);
                exception.getMessage(),
import java.util.Set;
                null,
        QueryCache queryCache = mock(QueryCache.class);
                null,
            assertFalse(context.shouldUseConcurrentSearch());
            );
                context3.buildFilteredQuery(new ConstantScoreQuery(new TermQuery(new Term("content", "alpha")))),
import org.opensearch.test.OpenSearchTestCase;
                @Override
import org.apache.lucene.search.BooleanQuery;
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                false,
                newContextId(),
                indexShard,
            .build();
                null,
                indexShard,
            Engine.Searcher searcher = new Engine.Searcher(
            contextWithoutScroll.close();
        );
            ReaderContext pitReaderContext = new PitReaderContext(
                false,
                        + maxSlicesPerScroll
                shardSearchRequest,
                target,
            when(sliceBuilder.getMax()).thenReturn(numSlices);
                executor,
                false,
        when(indexService.newQueryShardContext(eq(shardId.id()), any(), any(), nullable(String.class), anyBoolean(), anyBoolean()))
                assertFalse(context.shouldUseConcurrentSearch());
            } else {
import org.opensearch.common.unit.TimeValue;
import org.apache.lucene.search.ConstantScoreQuery;
        when(indexService.getIndexSettings()).thenReturn(indexSettings);
            // rescore is null but sort is not null and rescoreContext.getWindowSize() exceeds maxResultWindow
                shardSearchRequest,
                @Override
                null,
        return new ShardSearchContextId(UUIDs.randomBase64UUID(), randomNonNegativeLong());
                }
                null,
            .thenReturn(queryShardContext);
                @Override
                false,
            when(decider1.getConcurrentSearchDecision()).thenReturn(
    public void testStreamingSettingsValidation() {
 * SPDX-License-Identifier: Apache-2.0
                assertFalse(context.shouldUseConcurrentSearch());
            context = new DefaultSearchContext(
            );
            // Case 4: With a system index concurrent segment search is not used
        IndexMetadata indexMetadata = IndexMetadata.builder("index").settings(settings).build();
            BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
                searcherSupplier.get(),
                null,
                readerContext,
import org.opensearch.index.query.AbstractQueryBuilder;
                Collections.emptyList()
                shardSearchRequest,
            );
                null,
            .put("search.aggregations.streaming.min_cardinality_ratio", 0.05)
            IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> contextWithoutScroll.preProcess(false));
 * specific language governing permissions and limitations
                bigArrays,
                        + "] but was [310]. See the scroll api for a more efficient way to request large data sets. "
                null,
                equalTo(
        }
        when(throttledIndexShard.getThreadPool()).thenReturn(threadPool);
 * The OpenSearch Contributors require contributions made to
            );
        when(mapperService.hasNested()).thenReturn(randomBoolean());
            context.evaluateRequestShouldUseConcurrentSearch();
            );
 */
import org.opensearch.search.internal.ShardSearchContextId;
                target,
                null,
                null,
                assertTrue(context.shouldUseConcurrentSearch());
            context.evaluateRequestShouldUseConcurrentSearch();
                    } catch (IOException exc) {
            Settings.builder().put(INDEX_SEARCH_THROTTLED.getKey(), true).build()
                newContextId(),
                null,
                Collections.emptyList()
            assertFalse(context.shouldUseConcurrentSearch());
            );
            } else {
                null,
            );
            } else {
            when(shardSearchRequest.source()).thenReturn(sourceBuilder);
                Version.CURRENT,
            when(decider2.getConcurrentSearchDecision()).thenReturn(
                Collections.emptyList()
        IndexService indexService = mock(IndexService.class);
                Collections.emptyList()
                    "Rescore window ["
                null,
                clusterService,
                bigArrays,
                        + "] index level setting."
                        + "It must be less than ["
            ConcurrentSearchRequestDecider.Factory factory1 = new ConcurrentSearchRequestDecider.Factory() {
                false,
                indexService,
        when(indexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);
                false,
            // No aggregations set
import org.opensearch.search.internal.PitReaderContext;
            when(shardSearchRequest.scroll()).thenReturn(new Scroll(TimeValue.timeValueMillis(randomInt(1000))));
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.NO, "disable concurrent search")
                Version.CURRENT,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            if (executor == null) {
            SearchShardTarget target = new SearchShardTarget("node", shardId, null, OriginalIndices.NONE);
    private final ExecutorService executor;
        QueryCachingPolicy queryCachingPolicy = mock(QueryCachingPolicy.class);
                }
                bigArrays,
                null,
import org.opensearch.search.aggregations.SearchContextAggregations;
                executor,
            if (executor == null) {
            assertFalse(context.shouldUseConcurrentSearch());
            context.sort(
        when(indexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);
                    .build()
                null,
            when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
import static org.hamcrest.Matchers.instanceOf;
                Collections.emptyList()
                    return searcher;
                instanceOf(ConstantScoreQuery.class)
            // Case8: no aggregations, query supports intra-segment search, partition strategy is balanced (default)
                            IndexSearcher.getDefaultQueryCachingPolicy(),
                protected Engine.Searcher acquireSearcherInternal(String source) {
import static org.mockito.Mockito.mock;
            );
                executor,
                assertFalse(context.shouldUseConcurrentSearch());
            DefaultSearchContext context = new DefaultSearchContext(
                readerContext,
            if (executor == null) {
import org.apache.lucene.search.MatchNoDocsQuery;
            );
            when(mockAggregations.factories().allFactoriesSupportConcurrentSearch()).thenReturn(true);
        IndexShard indexShard = mock(IndexShard.class);
                target,
                null,
            context3.sliceBuilder(null);
                timeout,
            ThreadPool.terminate(executor, 10, TimeUnit.SECONDS);
                null,
        assertEquals(1000L, (long) clusterSettings.get(FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT));
            // Case5: multiple deciders are registered and one of them returns ConcurrentSearchDecision.DecisionStatus.NO
                    } catch (IOException exc) {
        BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            .thenReturn(queryShardContext);
                null,
    private ShardSearchContextId newContextId() {
            context = new DefaultSearchContext(
                    return Optional.empty();
                null,
import org.opensearch.common.util.MockBigArrays;
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
import java.util.concurrent.TimeUnit;
        Settings settings = Settings.builder()
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                executor,
            );
                false,
                Collections.emptyList()
            );
            when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
                            reader
                randomNonNegativeLong(),
        settings.add(FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT);
            context = new DefaultSearchContext(
                IndexSearcher.getDefaultSimilarity(),
    }
                readerContext,
            DefaultSearchContext contextWithoutScroll = new DefaultSearchContext(
                false,
            // Case1: if sort is on timestamp field, non-concurrent path is used
import org.apache.lucene.search.IndexSearcher;
                readerContext,
import org.opensearch.search.internal.ShardSearchRequest;
                timeout,
                Collections.emptyList()
                "test",
                        + "This limit can be set by changing the ["
        BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            ConcurrentSearchRequestDecider.Factory factory2 = new ConcurrentSearchRequestDecider.Factory() {
        when(indexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);
        when(shardSearchRequest.shardId()).thenReturn(shardId);
                            IndexSearcher.getDefaultSimilarity(),
        when(indexCache.query()).thenReturn(queryCache);
                    return Optional.ofNullable(decider2);
        when(systemIndexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, settings);
            context = new DefaultSearchContext(
                executor,
        IndexSettings throttledIndexSettings = new IndexSettings(
import org.apache.lucene.store.Directory;
                null,
            threadPool.shutdown();
            };
                exception.getMessage(),
            clusterSettings.registerSetting(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING);
            if (executor == null) {
                false,
                false,
            } else {
                Version.CURRENT,
                indexService,
                false,
            );
                false,
            );
            DefaultSearchContext context3 = new DefaultSearchContext(
            );
 *
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        ShardId shardId = new ShardId("index", UUID.randomUUID().toString(), 1);
        int maxResultWindow = randomIntBetween(50, 100);
        ClusterSettings clusterSettings = new ClusterSettings(customSettings, settings);
                searcherSupplier.get(),
            int numSlices = maxSlicesPerScroll + randomIntBetween(1, 100);
            when(intraSegmentQuery.supportsIntraSegmentSearch()).thenReturn(true);
                null,
                protected Engine.Searcher acquireSearcherInternal(String source) {
                false,
            );
                indexShard,
                bigArrays,
                false,
            .thenReturn(queryShardContext);
                randomNonNegativeLong(),
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
                    .put(SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment")
                }
                searcherSupplier.get(),
                false,
            // but un-supported agg query is present, use non-concurrent path
                clusterService,
import static org.mockito.Mockito.nullable;
            );
            final Supplier<Engine.SearcherSupplier> searcherSupplier = () -> new Engine.SearcherSupplier(Function.identity()) {
            ReaderContext readerContext = new ReaderContext(
                    "The number of slices ["
            );
                readerContext,
            clusterSettings.registerSetting(SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY);
            when(shardSearchRequest.source()).thenReturn(sourceBuilder);
                clusterService,
                executor,
            exception = expectThrows(IllegalArgumentException.class, () -> context1.preProcess(false));
                    } catch (IOException exc) {
                shardSearchRequest,
        IndexMetadata indexMetadata = IndexMetadata.builder("index").settings(settings).build();
            // COMPLETE_NO_SCORES fast path is preserved; a normal query is combined into a scoring BooleanQuery.
                null,
            context = new DefaultSearchContext(
                readerContext,
        ShardId shardId = new ShardId("index", UUID.randomUUID().toString(), 1);
import java.util.ArrayList;
                null,
            .build();
import java.util.Optional;
                Version.CURRENT,
            long timeToleranceInMs = 10;
        when(systemIndexShard.getThreadPool()).thenReturn(threadPool);
            } else {
        when(systemIndexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);
            context1.sort(null);
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
            final Supplier<Engine.SearcherSupplier> searcherSupplier = () -> new Engine.SearcherSupplier(Function.identity()) {
            when(decider1.getConcurrentSearchDecision()).thenReturn(
                assertFalse(context.shouldUseConcurrentSearch());
                bigArrays,
            context1.sort(sortAndFormats);
            };
import java.util.Collections;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            // should use concurrent search via intra-segment search path
            // create a source so that query tree is parsed by visitor
            context.evaluateRequestShouldUseConcurrentSearch();
    public void testSearchPathEvaluationWithConcurrentSearchModeAsAuto() throws Exception {
                target,
    }
            );
            );
                indexService,
            }
            // make sure getPreciseRelativeTimeInMillis is same as System.nanoTime()
                @Override
                assertTrue(context.shouldUseConcurrentSearch());
                target,
                    }
import java.util.Collection;
        when(indexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);
                exception1.getMessage(),
                false,
                false,
                equalTo(
        TimeValue timeout = new TimeValue(randomIntBetween(1, 100));
                null,
import org.opensearch.index.cache.IndexCache;
                shardSearchRequest,
                null,
        ThreadPool threadPool = new TestThreadPool(this.getClass().getName());
                        return new Engine.Searcher(
            };
                bigArrays,
        super.tearDown();
                IndexSearcher.getDefaultQueryCache(),
/*
                @Override
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.NO, "disable concurrent search")
    }
            } else {
            context3.sliceBuilder(filterSlice);
        settings.add(FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT);
            );
            context1.from(0);
                        );
            if (executor == null) {
                null,
            when(mockAggregations.multiBucketConsumer()).thenReturn(mock(MultiBucketConsumerService.MultiBucketConsumer.class));
 * KIND, either express or implied.  See the License for the
        ThreadPool threadPool = new TestThreadPool(this.getClass().getName());
                concurrentSearchRequestDeciders
    public void testStreamingSettingsDefaults() {
            .put("index.max_result_window", maxResultWindow)
        ShardSearchRequest shardSearchRequest = mock(ShardSearchRequest.class);
import org.opensearch.search.builder.SearchSourceBuilder;
            );
            // should NOT use concurrent search
                executor,
                bigArrays,
                false,
                concurrentSearchRequestDeciders
                null,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            threadPool.shutdown();
                null,
            context.close();
                null,
            context1.addRescore(rescoreContext);
import org.opensearch.search.slice.SliceBuilder;
                null,
import static org.mockito.Mockito.when;
                searcherSupplier.get(),
            // resultWindow greater than maxResultWindow and scrollContext isn't null
        IndexShard systemIndexShard = mock(IndexShard.class);
                target,
                        + "be less than ["
                assertFalse(context.shouldUseConcurrentSearch());
            readerContext = new ReaderContext(
                            IndexSearcher.getDefaultQueryCachingPolicy(),
            };
                null,
            )
                        + IndexSettings.MAX_SLICES_PER_SCROLL.getKey()
            // create a supported agg operation
            exception = expectThrows(IllegalArgumentException.class, () -> context1.preProcess(false));
            assertEquals(context3.query(), context3.buildFilteredQuery(parsedQuery.query()));
            // should NOT use concurrent search
            // resultWindow not greater than maxResultWindow and both rescore and sort are not null
            );
            context.aggregations(mockAggregations);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.UUIDs;
        IndexShard throttledIndexShard = mock(IndexShard.class);
        QueryCachingPolicy queryCachingPolicy = mock(QueryCachingPolicy.class);
                pitReaderContext,
                )
        assertEquals(500L, (long) clusterSettings.get(FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT));
                )
 * compatible open source license.
                timeout,
                        IndexReader reader = w.getReader();
        settings.add(FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT);
                            "test",
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
import org.opensearch.search.rescore.RescoreContext;
                target,
import org.opensearch.cluster.metadata.IndexMetadata;
            );
                indexShard,
import java.util.List;
                null,
            // set agg operation to be supported
                concurrentSearchRequestDeciders
    public void testClearQueryCancellationsOnClose() throws IOException {
                false,
            final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                        + "] index level setting."
            when(mapperService.hasNested()).thenReturn(false);
                assertFalse(context.shouldUseConcurrentSearch());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (executor == null) {
                        + "] but was [310]. Scroll batch sizes cost as much memory as result windows so they are "
            // while second decider returns ConcurrentSearchDecision.DecisionStatus.NO
                systemIndexShard,
            threadPool.shutdown();
            Query query1 = context4.query();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            ReaderContext readerContext = new LegacyReaderContext(
        ShardId shardId = new ShardId("index", UUID.randomUUID().toString(), 1);
                false
                            IndexSearcher.getDefaultQueryCache(),
public class DefaultSearchContextTests extends OpenSearchTestCase {
}
        when(systemIndexShard.getThreadPool()).thenReturn(threadPool);
                Version.CURRENT,
        assertEquals(0.01, clusterSettings.get(FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO), 0.001);
                            IndexSearcher.getDefaultSimilarity(),
            when(rescoreContext.getWindowSize()).thenReturn(500);
            IndexReader reader = w.getReader();
 * not use this file except in compliance with the License.
                Settings.builder()
            );
            // Case6: multiple deciders are registered and first decider returns ConcurrentSearchDecision.DecisionStatus.YES
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.NO_OP, "noop")
                false,
                target,
            );
import org.apache.lucene.index.Term;
                @Override
                        + "be less than ["
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
            );
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(
                false,
        MapperService mapperService = mock(MapperService.class);
                equalTo(
                indexService,
                newContextId(),
import org.apache.lucene.search.TermQuery;
        Settings customSettings = Settings.builder()
                indexService,
            .put("search.aggregations.streaming.max_estimated_bucket_count", 200000)
                false,
                protected void doClose() {}
            readerContext = new LegacyReaderContext(
        ShardSearchRequest shardSearchRequest = mock(ShardSearchRequest.class);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        when(shardSearchRequest.shardId()).thenReturn(shardId);
import org.apache.lucene.search.Query;
    public void tearDown() throws Exception {
                            IndexSearcher.getDefaultSimilarity(),
            .put("search.aggregations.streaming.min_estimated_bucket_count", 500)
        ThreadPool threadPool = new TestThreadPool(this.getClass().getName());
                false,
                        return new Engine.Searcher(
                null,
                executor,
                null,
            clusterSettings.applySettings(
                null,
            context4.sliceBuilder(new SliceBuilder(1, 2)).parsedQuery(parsedQuery).preProcess(false);
                executor,
                false
                false,
                OpenSearchRejectedExecutionException.class,
                clusterService,
    }
                            reader
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
                null,
                )
            }
        when(shardSearchRequest.searchType()).thenReturn(SearchType.DEFAULT);
                timeout,
                public Optional<ConcurrentSearchRequestDecider> create(IndexSettings indexSettings) {
        when(indexShard.indexSettings()).thenReturn(indexSettings);
                indexService,
                        + "] is too large. "
                @Override
                true
            assertFalse(context.shouldUseConcurrentSearch());
            .put("index.max_slices_per_scroll", maxSlicesPerScroll)
            readerContext.close();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
                IndexSearcher.getDefaultQueryCachingPolicy(),
                null,
                searcherSupplier.get(),
            context.evaluateRequestShouldUseConcurrentSearch();
                false
                        + "to be rescored. This limit can be set by changing the ["
            SliceBuilder sliceBuilder = mock(SliceBuilder.class);
                            IndexSearcher.getDefaultQueryCachingPolicy(),
                protected Engine.Searcher acquireSearcherInternal(String source) {
                shardSearchRequest,
                null,
            readerContext.close();
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
                shardSearchRequest,
            SearchShardTarget target = new SearchShardTarget("node", shardId, null, OriginalIndices.NONE);
            context.evaluateRequestShouldUseConcurrentSearch();
            };
                false,
                bigArrays,
                protected Engine.Searcher acquireSearcherInternal(String source) {
        IndexMetadata indexMetadata = IndexMetadata.builder("index").settings(settings).build();
        Settings settings = Settings.builder()
                null,
                readerContext,
            // Case1: if there is no agg in the query, non-concurrent path is used
            // Case7: multiple deciders are registered and all return ConcurrentSearchDecision.DecisionStatus.NO_OP
import static org.hamcrest.Matchers.equalTo;
            when(mockAggregations.factories().allFactoriesSupportConcurrentSearch()).thenReturn(false);
                randomNonNegativeLong()
            );
            assertThat(context.searcher().hasCancellations(), is(true));
    }
                shardSearchRequest,
            context.evaluateRequestShouldUseConcurrentSearch();
            threadPool.shutdown();
                    .put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), "auto")
                Version.CURRENT,
                false,
                concurrentSearchRequestDeciders
                            IndexSearcher.getDefaultQueryCache(),
    }
                null,
                        );
            );
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
                executor,
            ReaderContext readerContext = new ReaderContext(
                clusterService,
            clusterSettings.registerSetting(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING);
        when(indexShard.indexSettings()).thenReturn(indexSettings);
import org.opensearch.threadpool.TestThreadPool;
                null,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        );
        try (
                false,
            context3.sliceBuilder(null).parsedQuery(parsedQuery).preProcess(false);
                null,
            // resultWindow greater than maxResultWindow and scrollContext is null
            // shutdown the threadpool
import org.opensearch.search.internal.AliasFilter;
                Version.CURRENT,
import static org.mockito.Mockito.any;
            context.aggregations(mockAggregations);
import org.opensearch.index.mapper.MappedFieldType;
                        + numSlicesForPit
            );
        }
                timeout,
                        + "]. This prevents allocating massive heaps for storing the results "
        assertEquals(100_000L, (long) clusterSettings.get(FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT));
                null,
 */
/*
import org.apache.lucene.search.SortField;
import java.util.concurrent.Executors;
            // rescore is null but sliceBuilder is not null
        ShardSearchRequest shardSearchRequest = mock(ShardSearchRequest.class);
                @Override
            DocValueFormat docValueFormat = mock(DocValueFormat.class);
                bigArrays,
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
            context = new DefaultSearchContext(
            );
                null,
        when(indexService.newQueryShardContext(eq(shardId.id()), any(), any(), nullable(String.class), anyBoolean(), anyBoolean()))
            );
 * ownership. Elasticsearch licenses this file to you under
                newContextId(),
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                        + "] index level setting."
                null,
                Version.CURRENT,
        ShardId shardId = new ShardId("index", UUID.randomUUID().toString(), 1);
                        + "] index level setting."
                null,
            pitReaderContext.close();
                Version.CURRENT,
                concurrentSearchRequestDeciders
                executor,
                        + maxSlicesPerPit
                bigArrays,
            final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import java.util.UUID;
            );
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                Version.CURRENT,
            );
                assertFalse(context.shouldUseConcurrentSearch());
        when(indexService.cache()).thenReturn(indexCache);
 *
                Version.CURRENT,
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
                clusterService,
    }
                        + rescoreContext.getWindowSize()
            }
                readerContext,
                false
            assertTrue(Math.abs(context3.getRelativeTimeInMillis(false) - currTime) <= timeToleranceInMs);
        ) {
        IndexCache indexCache = mock(IndexCache.class);
                false,
                target,
            }
            // Case4: multiple deciders are registered and all of them opt out of decision-making
                shardSearchRequest,
                target,
import org.opensearch.index.query.QueryShardContext;
    }
import org.opensearch.index.query.ParsedQuery;
            // create a source so that query tree is parsed by visitor
import org.opensearch.index.query.BoolQueryBuilder;
                executor,
                null,
            context.searcher().addQueryCancellation(() -> {});
                Version.CURRENT,
            ReaderContext readerContext = new ReaderContext(
import org.apache.lucene.index.IndexReader;
                Version.CURRENT,
            clusterSettings.applySettings(
            // Case2: if sort is on other field, concurrent path is used
                Version.CURRENT,
                () -> context5.preProcess(false)
                readerContext,
                null,
        when(indexShard.indexSettings()).thenReturn(indexSettings);
            context = new DefaultSearchContext(
                }
                false,
                shardSearchRequest,
            SearchSourceBuilder intraSegmentSourceBuilder = new SearchSourceBuilder();
            if (executor == null) {
                null,
            sourceBuilder.query(queryBuilder);
            context.evaluateRequestShouldUseConcurrentSearch();
            when(queryShardContext.getIndexSettings()).thenReturn(indexSettings);
                null,
        when(indexShard.getThreadPool()).thenReturn(threadPool);
                protected void doClose() {}
        when(shardSearchRequest.searchType()).thenReturn(SearchType.DEFAULT);
                assertFalse(context.shouldUseConcurrentSearch());
                null,
            } else {
                newContextId(),
                null,
            readerContext = new ReaderContext(
            SortAndFormats sortAndFormats = new SortAndFormats(new Sort(), new DocValueFormat[] { docValueFormat });
                null,
                null,
                null,
        BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            // Case3: if supported agg present, concurrent path is used
import org.opensearch.search.streaming.FlushModeResolver;
import static org.opensearch.index.IndexSettings.INDEX_SEARCH_THROTTLED;
                null,
            };
                false,
                null,
        IndexSettings throttledIndexSettings = new IndexSettings(
            ConcurrentSearchRequestDecider decider1 = mock(ConcurrentSearchRequestDecider.class);
            int numSlicesForPit = maxSlicesPerPit + randomIntBetween(1, 100);
            );
                newContextId(),
        settings.add(FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO);
import java.util.Arrays;
                indexService,
            );
                null,
                readerWithoutScroll,
                null,
                exception.getMessage(),
        IndexService indexService = mock(IndexService.class);
                clusterService,
                newContextId(),
import org.opensearch.index.mapper.MapperService;
                Version.CURRENT,
                Collections.emptyList()
            when(intraSegmentQuery.supportsIntraSegmentSearch()).thenReturn(false);
            readerContext = new ReaderContext(
 * Licensed to Elasticsearch under one or more contributor
                bigArrays,
                clusterService,
                null,
                executor,
            indexMetadata,
import org.apache.lucene.search.Sort;
            }
            DefaultSearchContext context1 = new DefaultSearchContext(
                        + "] index level setting."
                @Override
                null,
                null,
            DefaultSearchContext context2 = new DefaultSearchContext(
                shardSearchRequest,
                readerContext,
                clusterService,
            ConcurrentSearchRequestDecider decider2 = mock(ConcurrentSearchRequestDecider.class);
                protected void doClose() {}
                indexService,
            indexMetadata,
        this.executor = (concurrency > 0) ? Executors.newFixedThreadPool(concurrency) : null;
        when(indexShard.indexSettings()).thenReturn(indexSettings);
                indexShard,
                equalTo(
            // use non-concurrent path even if query contains supported agg
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.anyString;
        int maxRescoreWindow = randomIntBetween(50, 100);
import java.io.IOException;
            // create a supported agg operation
                        throw new AssertionError(exc);
                false,
        int maxSlicesPerScroll = randomIntBetween(50, 100);
            }
            );
                null,
                searcherSupplier.get(),
                readerContext,
                equalTo(
                bigArrays,
                }
                Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), "auto").build()
                assertFalse(context.shouldUseConcurrentSearch());
                null,
            assertThat(
                target,
            );
                            reader,
import org.opensearch.index.engine.Engine;
            };
            // Case10: query supports intra-segment search with partition strategy as none
    public void testSearchPathEvaluation() throws Exception {
                        + numSlices
                    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public DefaultSearchContextTests(int concurrency) {
                        + maxResultWindow
                false,
                timeout,
            // Case 3: With no sort, concurrent path is used
        settings.add(FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO);
            final Supplier<Engine.SearcherSupplier> searcherSupplier = () -> new Engine.SearcherSupplier(Function.identity()) {
                shardSearchRequest,
            // create a supported agg operation
                randomNonNegativeLong(),
 */
                null,
            assertThat(context.searcher().hasCancellations(), is(false));
            when(shardSearchRequest.getAliasFilter()).thenReturn(AliasFilter.EMPTY);
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
            ConcurrentSearchRequestDecider.Factory factory3 = new ConcurrentSearchRequestDecider.Factory() {
                        + IndexSettings.MAX_RESCORE_WINDOW_SETTING.getKey()
            concurrentSearchRequestDeciders.add(factory1);
            SearchShardTarget target = new SearchShardTarget("node", shardId, null, OriginalIndices.NONE);
        when(shardSearchRequest.shardId()).thenReturn(shardId);
                new SortAndFormats(new Sort(new SortField("@timestamp", SortField.Type.INT)), new DocValueFormat[] { DocValueFormat.RAW })
                Collections.emptyList()
 * GitHub history for details.
                target,
                assertSettingDeprecationsAndWarnings(new Setting[] { SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING });
                Collections.emptyList()
            SearchShardTarget target = new SearchShardTarget("node", shardId, null, OriginalIndices.NONE);
            .thenReturn(queryShardContext);
                )
                null,
            );
            context1.from(300);
                executor,
        IndexShard indexShard = mock(IndexShard.class);
        TimeValue timeout = new TimeValue(randomIntBetween(1, 100));
                searcherSupplier.get(),
                null,
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.YES, "enable concurrent search")
 *    http://www.apache.org/licenses/LICENSE-2.0
                indexService,
                false,
        when(indexService.newQueryShardContext(eq(shardId.id()), any(), any(), nullable(String.class), anyBoolean(), anyBoolean()))
        when(shardSearchRequest.shardId()).thenReturn(shardId);
                assertFalse(context.shouldUseConcurrentSearch());
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
            // create a source so that query tree is parsed by visitor
        IndexShard indexShard = mock(IndexShard.class);
            context.aggregations(mockAggregations);
            }
            context = new DefaultSearchContext(
            assertThat(
                        + "]. This limit can be set by changing the ["
                        return new Engine.Searcher(
            context = new DefaultSearchContext(
            );
        when(throttledIndexShard.getThreadPool()).thenReturn(threadPool);
                readerContext,
                shardSearchRequest,
            // No exceptions should be thrown
                Version.CURRENT,
import org.opensearch.common.SetOnce;
                null,
            when(shardSearchRequest.source()).thenReturn(sourceBuilder);
            assertThat(context3.buildFilteredQuery(new TermQuery(new Term("content", "alpha"))), instanceOf(BooleanQuery.class));
import org.opensearch.Version;
                target,
            assertTrue(query1 instanceof MatchNoDocsQuery || query2 instanceof MatchNoDocsQuery);
                bigArrays,
        if (executor != null) {
            RescoreContext rescoreContext = mock(RescoreContext.class);
                shardSearchRequest,
                }
                false
                null,
                newContextId(),
            context.evaluateRequestShouldUseConcurrentSearch();
        IndexShard systemIndexShard = mock(IndexShard.class);
                false,
                null,
            if (clusterService.getClusterSettings().get(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING)) {
                Collections.emptyList()
 * software distributed under the License is distributed on an
            when(queryShardContext.fieldMapper(anyString())).thenReturn(mock(MappedFieldType.class));
                shardSearchRequest,
        when(throttledIndexShard.indexSettings()).thenReturn(throttledIndexSettings);
            context2.sliceBuilder(sliceBuilder);
            exception = expectThrows(IllegalArgumentException.class, () -> context1.preProcess(false));
                        throw new AssertionError(exc);
import org.apache.lucene.tests.index.RandomIndexWriter;
        settings.add(FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT);
                executor,
                shardSearchRequest,
                assertTrue(context.shouldUseConcurrentSearch());
                target,
        int maxSlicesPerPit = randomIntBetween(50, 100);
                indexShard,
            RandomIndexWriter w = new RandomIndexWriter(random(), dir);
                }
            // Case9: no aggregations, query does NOT support intra-segment search
            .build();
            context.evaluateRequestShouldUseConcurrentSearch();
            when(shardSearchRequest.indexBoost()).thenReturn(AbstractQueryBuilder.DEFAULT_BOOST);
            when(shardSearchRequest.indexRoutings()).thenReturn(new String[0]);
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
                Collections.emptyList()
import org.opensearch.index.IndexService;
            exception = expectThrows(IllegalArgumentException.class, () -> context2.preProcess(false));
            SearchContextAggregations mockAggregations = mock(SearchContextAggregations.class);
                false
                shardSearchRequest,
                executor,
        assertEquals(200000L, (long) clusterSettings.get(FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT));
            when(decider2.getConcurrentSearchDecision()).thenReturn(
                shardSearchRequest,
import org.opensearch.common.settings.Settings;
                searcherSupplier,
        IndexShard indexShard = mock(IndexShard.class);
                @Override
            );
    public void testPreProcess() throws Exception {
                Version.CURRENT,
            when(decider1.getConcurrentSearchDecision()).thenReturn(
            context = new DefaultSearchContext(
                indexShard,
                bigArrays,
            assertThat(context.searcher().hasCancellations(), is(false));
        } finally {
            // Case2: if un supported agg present, non-concurrent path is used
import org.opensearch.common.util.BigArrays;
            // shutdown the threadpool
            assertThat(
                Version.CURRENT,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            // add un-supported agg operation
                assertFalse(context.shouldUseConcurrentSearch());
import org.opensearch.search.sort.SortAndFormats;
 * this work for additional information regarding copyright
            OpenSearchRejectedExecutionException exception1 = expectThrows(
            if (executor == null) {
                clusterService,
            );
                reader,
                clusterService,
import org.opensearch.index.IndexSettings;
            // with supported agg query so concurrent path is used
            ParsedQuery parsedQuery = ParsedQuery.parsedMatchAllQuery();
                searcherSupplier.get(),
import org.opensearch.common.util.MockPageCacheRecycler;
                null,
        ShardSearchRequest shardSearchRequest = mock(ShardSearchRequest.class);
                    "Batch size is too large, size must be less than or equal to: ["
                null,
            );
            when(clusterService.getSettings()).thenReturn(settings);
                indexShard,
                randomNonNegativeLong(),
                shardSearchRequest,
                target,
            context.evaluateRequestShouldUseConcurrentSearch();
        when(throttledIndexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);
            if (executor == null) {
            context = new DefaultSearchContext(
            Settings.builder().put(INDEX_SEARCH_THROTTLED.getKey(), true).build()
                timeout,
            }
                null,
            Query query2 = context4.query();
                        + " ["
            );
                        + IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey()
                target,
                throttledIndexShard,
            clusterSettings.applySettings(
            );
        IndexService indexService = mock(IndexService.class);
                            reader
                randomNonNegativeLong(),
            when(intraSegmentQuery.supportsIntraSegmentSearch()).thenReturn(true);
                protected void doClose() {
                readerContext,
        Settings settings = Settings.builder()
                            IndexSearcher.getDefaultQueryCache(),
            contextWithoutScroll.from(300);
                false,
            // Case 5: When search is throttled concurrent segment search is not used
            } else {
            Engine.SearcherSupplier searcherSupplier = new Engine.SearcherSupplier(Function.identity()) {
            long currTime = TimeValue.nsecToMSec(System.nanoTime());
        when(indexService.getIndexSettings()).thenReturn(indexSettings);
                Version.CURRENT,
                searcherSupplier.get(),
        IndexMetadata indexMetadata = IndexMetadata.builder("index").settings(settings).build();
        return Arrays.asList(new Integer[] { 0 }, new Integer[] { 5 });
                        IndexReader reader = w.getReader();
                    try {
 * the Apache License, Version 2.0 (the "License"); you may
                assertTrue(context.shouldUseConcurrentSearch());
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            intraSegmentSourceBuilder.query(intraSegmentQuery);
            .build();
                false,
import org.opensearch.search.internal.LegacyReaderContext;
                1000,
            .build();
            );
                bigArrays,
                null,
                        throw new AssertionError(exc);
import org.opensearch.action.search.SearchType;
            // create a supported agg operation
            context.evaluateRequestShouldUseConcurrentSearch();
            context4.sliceBuilder(new SliceBuilder(0, 2)).parsedQuery(parsedQuery).preProcess(false);
                        IndexReader reader = w.getReader();
                false
            when(shardSearchRequest.source()).thenReturn(intraSegmentSourceBuilder);
            context.evaluateRequestShouldUseConcurrentSearch();
                Version.CURRENT,
                target,
                assertTrue(context.shouldUseConcurrentSearch());
        when(throttledIndexShard.indexSettings()).thenReturn(throttledIndexSettings);
                shardSearchRequest,
                        + IndexSettings.MAX_SLICES_PER_PIT.getKey()
            );
import org.opensearch.index.cache.query.QueryCache;
    }
                executor,
                }
                shardSearchRequest,
 * under the License.
    public static Collection<Object[]> concurrency() {
                        + maxResultWindow
        assertEquals(0.05, clusterSettings.get(FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO), 0.001);
import org.opensearch.search.aggregations.MultiBucketConsumerService;
            DefaultSearchContext context4 = new DefaultSearchContext(
            );
            when(decider1.getConcurrentSearchDecision()).thenReturn(
            final ClusterService clusterService = mock(ClusterService.class);
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
                        + "controlled by the ["
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
        IndexShard throttledIndexShard = mock(IndexShard.class);
                executor,
            }
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.NO_OP, "noop")
                            reader,
                null,
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                assertFalse(context.shouldUseConcurrentSearch());
            DefaultSearchContext context = new DefaultSearchContext(
        Set<Setting<?>> settings = new HashSet<>();
                shardSearchRequest,
                null,
import java.util.concurrent.ExecutorService;
import java.util.HashSet;
                shardSearchRequest,
            .put("index.max_rescore_window", maxRescoreWindow)
                exception.getMessage(),
            // create a supported agg operation
                executor,
                            reader,
            );
            // buildFilteredQuery: when at least one filter is added (here a slice filter) and the incoming
            SliceBuilder filterSlice = mock(SliceBuilder.class);
                randomNonNegativeLong()
            when(mockAggregations.factories()).thenReturn(mock(AggregatorFactories.class));
                target,
                newContextId(),
            when(mockAggregations.factories().allFactoriesSupportConcurrentSearch()).thenReturn(false);
                    }
import org.opensearch.search.aggregations.AggregatorFactories;
    @Override
            context = new DefaultSearchContext(
                false,
            // clusterSettings.registerSetting(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE);
                target,
        when(indexShard.getThreadPool()).thenReturn(threadPool);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.common.settings.ClusterSettings;
                Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build()
                readerContext,
                reader
        IndexService indexService = mock(IndexService.class);
                null,
                concurrentSearchRequestDeciders
                false,
            when(decider2.getConcurrentSearchDecision()).thenReturn(
            .put("index.max_slices_per_pit", maxSlicesPerPit)
        when(indexService.getIndexSettings()).thenReturn(indexSettings);
                    .put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), "auto")
                indexService,
                    .build()
                false,
import java.util.function.Function;
        when(shardSearchRequest.searchType()).thenReturn(SearchType.DEFAULT);
                null,
        }
                false,
        when(indexService.mapperService()).thenReturn(mapperService);
                    return Optional.ofNullable(decider1);
            } else {
            context.evaluateRequestShouldUseConcurrentSearch();
    }
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
            Directory dir = newDirectory();
                null,
            ReaderContext readerWithoutScroll = new ReaderContext(
                false,
                false,
                readerContext,
            DefaultSearchContext context = new DefaultSearchContext(
                Collections.emptyList()
            // Apply balanced partition strategy
                null,
                            "test",
            context.evaluateRequestShouldUseConcurrentSearch();
                null,
 * Unless required by applicable law or agreed to in writing,
        when(indexService.newQueryShardContext(eq(shardId.id()), any(), any(), nullable(String.class), anyBoolean(), anyBoolean()))
        QueryCachingPolicy queryCachingPolicy = mock(QueryCachingPolicy.class);
                readerContext,
            // query is already a ConstantScoreQuery, the combined query must stay non-scoring so Lucene's
        when(throttledIndexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);
import org.opensearch.index.shard.IndexShard;
            context = new DefaultSearchContext(
                bigArrays,
                target,
                null,
import java.util.function.Supplier;
        }
                target,
                readerContext,
            assertFalse(context.shouldUseConcurrentSearch());
            DefaultSearchContext context5 = new DefaultSearchContext(
            assertThat(exception.getMessage(), equalTo("Cannot use [sort] option in conjunction with [rescore]."));
            }
                Version.CURRENT,
            // use non-concurrent path even if query contains supported agg
                Version.CURRENT,
                    try {
                            "test",
            context.sort(
                readerContext,
                bigArrays,
            );
            clusterSettings.applySettings(
                concurrentSearchRequestDeciders
        ThreadPool threadPool = new TestThreadPool(this.getClass().getName());
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.NO_OP, "noop")
                null,
import org.opensearch.cluster.service.ClusterService;
 *
                null,
        when(systemIndexShard.isSystem()).thenReturn(true);
            QueryBuilder intraSegmentQuery = mock(QueryBuilder.class);
                        + IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey()
                Settings.builder()
            context5.sliceBuilder(sliceBuilder);
        when(systemIndexShard.isSystem()).thenReturn(true);
            readerContext.close();
                bigArrays,
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.NO_OP, "noop")
                null,
        when(indexShard.getThreadPool()).thenReturn(threadPool);
                target,
                bigArrays,
        Set<Setting<?>> settings = new HashSet<>();
                assertFalse(context.shouldUseConcurrentSearch());
    @ParametersFactory
                    "The number of slices ["
                clusterService,
            List<ConcurrentSearchRequestDecider.Factory> concurrentSearchRequestDeciders = new ArrayList<>();
                null,
            assertFalse(context.shouldUseConcurrentSearch());
                        + maxRescoreWindow
            context.aggregations(mockAggregations);
            assertThat(
                executor,
                Collections.emptyList()
            when(sliceBuilder.getMax()).thenReturn(numSlicesForPit);
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
                        + "] is too large. It must "
            );
        }
 * You may obtain a copy of the License at
                        );
                newContextId(),
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
                readerContext,
                bigArrays,
                randomNonNegativeLong(),

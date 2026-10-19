                    }
                        + "] index level setting."
                readerContext,  
                clusterService,
            // buildFilteredQuery: when at least one filter is added (here a slice filter) and the incoming
                )
                null,
            context.evaluateRequestShouldUseConcurrentSearch();
                false  
            indexMetadata,  
            OpenSearchRejectedExecutionException exception1 = expectThrows(  
                }  
public class DefaultSearchContextTests extends OpenSearchTestCase {
                null,  
        }
                    return Optional.empty();  
        when(indexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);  
        assertEquals(500L, (long) clusterSettings.get(FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT));
import java.io.IOException;  
            };
            sourceBuilder.query(queryBuilder);
            // Case9: no aggregations, query does NOT support intra-segment search
import java.util.concurrent.TimeUnit;  
        return Arrays.asList(new Integer[] { 0 }, new Integer[] { 5 });  
            // use non-concurrent path even if query contains supported agg
        Set<Setting<?>> settings = new HashSet<>();
                        );
            DefaultSearchContext contextWithoutScroll = new DefaultSearchContext(
                    }
                    "Result window is too large, from + size must be less than or equal to:"
import org.opensearch.threadpool.TestThreadPool;  
            );  
                Version.CURRENT,
                    return searcher;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
            assertThat(  
                executor,
            } else {
                        + maxSlicesPerPit
            exception = expectThrows(IllegalArgumentException.class, () -> context2.preProcess(false));
                @Override  
                        + "] is too large. It must "
                Collections.emptyList()
                false,
        when(indexService.getIndexSettings()).thenReturn(indexSettings);
            Query query1 = context4.query();
        }
            // should NOT use concurrent search  
        when(indexCache.query()).thenReturn(queryCache);
                bigArrays,
            context = new DefaultSearchContext(
                false,
                readerContext,  
                bigArrays,
        ShardId shardId = new ShardId("index", UUID.randomUUID().toString(), 1);  
            when(shardSearchRequest.indexBoost()).thenReturn(AbstractQueryBuilder.DEFAULT_BOOST);  
            assertThat(
            context = new DefaultSearchContext(
import org.opensearch.search.aggregations.MultiBucketConsumerService;
 * SPDX-License-Identifier: Apache-2.0
                randomNonNegativeLong(),
                        + IndexSettings.MAX_RESCORE_WINDOW_SETTING.getKey()  
        if (executor != null) {
                false,  
            } else {  
                null,  
                target,
import org.opensearch.Version;
            );
            .put("index.max_slices_per_pit", maxSlicesPerPit)
                false,  
                        + rescoreContext.getWindowSize()  
                null,
                @Override
                randomNonNegativeLong(),
import java.util.concurrent.Executors;
        Settings settings = Settings.builder()  
        QueryCache queryCache = mock(QueryCache.class);  
            context = new DefaultSearchContext(
    private final ExecutorService executor;
                executor,
        int maxSlicesPerPit = randomIntBetween(50, 100);
                null,
                readerContext,  
                concurrentSearchRequestDeciders
                assertFalse(context.shouldUseConcurrentSearch());
            exception = expectThrows(IllegalArgumentException.class, () -> context1.preProcess(false));
import org.opensearch.index.cache.IndexCache;
            // should NOT use concurrent search
        }  
            // Case6: multiple deciders are registered and first decider returns ConcurrentSearchDecision.DecisionStatus.YES
        when(indexShard.indexSettings()).thenReturn(indexSettings);
                executor,
            when(mockAggregations.factories().allFactoriesSupportConcurrentSearch()).thenReturn(true);  
                            IndexSearcher.getDefaultQueryCachingPolicy(),
                target,
                executor,
        IndexShard throttledIndexShard = mock(IndexShard.class);
        IndexShard indexShard = mock(IndexShard.class);
        when(throttledIndexShard.indexSettings()).thenReturn(throttledIndexSettings);  
                clusterService,  
                        + "This limit can be set by changing the ["
                null,
                readerContext,  
                readerContext,  
            );
            clusterSettings.registerSetting(SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY);
                assertFalse(context.shouldUseConcurrentSearch());
            ReaderContext pitReaderContext = new PitReaderContext(
                1000,
                @Override
import org.opensearch.common.settings.Setting;  
                null,
import org.opensearch.search.deciders.ConcurrentSearchDecision;
        IndexShard systemIndexShard = mock(IndexShard.class);  
                indexService,
import org.opensearch.search.internal.ShardSearchRequest;  
                Collections.emptyList()
        super.tearDown();  
                assertTrue(context.shouldUseConcurrentSearch());
        BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
                null,  
        settings.add(FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT);  
                Collections.emptyList()
                false,
            context.sort(
                clusterService,
                readerContext,  
            context.aggregations(mockAggregations);  
import static org.mockito.Mockito.anyBoolean;  
                null,
                            IndexSearcher.getDefaultSimilarity(),  
            }
                @Override
        assertEquals(200000L, (long) clusterSettings.get(FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT));  
    public void tearDown() throws Exception {
            when(decider1.getConcurrentSearchDecision()).thenReturn(
                            reader,  
            clusterSettings.applySettings(
import java.util.List;  
            } else {
        return new ShardSearchContextId(UUIDs.randomBase64UUID(), randomNonNegativeLong());  
            );  
            context1.from(0);
                newContextId(),
            when(mockAggregations.factories().allFactoriesSupportConcurrentSearch()).thenReturn(false);
            // Apply balanced partition strategy  
            clusterSettings.applySettings(
            readerContext.close();  
            // Case8: no aggregations, query supports intra-segment search, partition strategy is balanced (default)  
                        + "] but was [310]. Scroll batch sizes cost as much memory as result windows so they are "
                )  
            SearchShardTarget target = new SearchShardTarget("node", shardId, null, OriginalIndices.NONE);  
                indexService,
 * The OpenSearch Contributors require contributions made to  
            }
                null,
            // No aggregations set  
import static org.hamcrest.Matchers.equalTo;
        IndexShard systemIndexShard = mock(IndexShard.class);  
        when(indexService.newQueryShardContext(eq(shardId.id()), any(), any(), nullable(String.class), anyBoolean(), anyBoolean()))
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                null,
                context3.buildFilteredQuery(new ConstantScoreQuery(new TermQuery(new Term("content", "alpha")))),  
import static org.hamcrest.Matchers.instanceOf;  
                equalTo(
            );  
            assertTrue(query1 instanceof MatchNoDocsQuery || query2 instanceof MatchNoDocsQuery);
            if (executor == null) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                Collections.emptyList()  
                    try {
                Version.CURRENT,
                bigArrays,
                indexShard,
            ReaderContext readerContext = new ReaderContext(
            );  
                null,
            .put("search.aggregations.streaming.min_estimated_bucket_count", 500)
                        + IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey()  
                indexService,
        Settings settings = Settings.builder()  
            context3.sliceBuilder(filterSlice);
        settings.add(FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO);  
                true
                target,
                shardSearchRequest,
                searcherSupplier.get(),
                null,  
            Directory dir = newDirectory();
                )  
            // but un-supported agg query is present, use non-concurrent path  
                        + numSlicesForPit
                            IndexSearcher.getDefaultQueryCache(),
                null,  
 * under the License.  
                Version.CURRENT,  
                Collections.emptyList()
                shardSearchRequest,
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);  
        when(shardSearchRequest.searchType()).thenReturn(SearchType.DEFAULT);
                @Override  
                bigArrays,
            DefaultSearchContext context3 = new DefaultSearchContext(
            context = new DefaultSearchContext(
 * this file be licensed under the Apache-2.0 license or a
                false,
                false,  
                    }
            // rescore is null but sliceBuilder is not null
        when(indexService.newQueryShardContext(eq(shardId.id()), any(), any(), nullable(String.class), anyBoolean(), anyBoolean()))
                null,  
import java.util.function.Function;
            } else {
            context = new DefaultSearchContext(
                Version.CURRENT,
import java.util.Set;
            context.aggregations(mockAggregations);  
            ReaderContext readerContext = new ReaderContext(  
        IndexShard indexShard = mock(IndexShard.class);
                assertFalse(context.shouldUseConcurrentSearch());
            context.evaluateRequestShouldUseConcurrentSearch();  
                null,  
                protected Engine.Searcher acquireSearcherInternal(String source) {  
import java.util.ArrayList;
 * specific language governing permissions and limitations
    @ParametersFactory
            );  
            final ClusterService clusterService = mock(ClusterService.class);  
            when(queryShardContext.getIndexSettings()).thenReturn(indexSettings);
                Version.CURRENT,
            // Case4: multiple deciders are registered and all of them opt out of decision-making
                null,  
                shardSearchRequest,  
            } else {
                equalTo(  
                        );
            );  
        ShardSearchRequest shardSearchRequest = mock(ShardSearchRequest.class);
import org.opensearch.common.util.MockBigArrays;
                        + "] index level setting."
            // Case1: if there is no agg in the query, non-concurrent path is used
                false,
            // create a supported agg operation  
                        + "] index level setting."  
            intraSegmentSourceBuilder.query(intraSegmentQuery);  
                shardSearchRequest,
        BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            if (executor == null) {
                        + IndexSettings.MAX_SLICES_PER_PIT.getKey()
            )
            SearchShardTarget target = new SearchShardTarget("node", shardId, null, OriginalIndices.NONE);
                concurrentSearchRequestDeciders
            context = new DefaultSearchContext(  
                readerContext,
    public void testStreamingSettingsValidation() {
            assertThat(
                clusterService,  
import org.opensearch.search.builder.SearchSourceBuilder;
            }
            .thenReturn(queryShardContext);  
                assertFalse(context.shouldUseConcurrentSearch());  
import java.util.concurrent.ExecutorService;
                protected void doClose() {}  
                null,
                shardSearchRequest,  
        IndexService indexService = mock(IndexService.class);  
                shardSearchRequest,
            contextWithoutScroll.close();  
 *
                            reader,
                false  
                false,
            context.evaluateRequestShouldUseConcurrentSearch();  
                }
import org.opensearch.search.aggregations.AggregatorFactories;
/*  
            context.evaluateRequestShouldUseConcurrentSearch();
            ConcurrentSearchRequestDecider.Factory factory3 = new ConcurrentSearchRequestDecider.Factory() {  
            when(mockAggregations.factories()).thenReturn(mock(AggregatorFactories.class));
                searcherSupplier.get(),
    public void testSearchPathEvaluation() throws Exception {  
                target,
        int maxSlicesPerScroll = randomIntBetween(50, 100);
import org.apache.lucene.index.Term;
                false,
            // shutdown the threadpool
            SortAndFormats sortAndFormats = new SortAndFormats(new Sort(), new DocValueFormat[] { docValueFormat });  
                shardSearchRequest,  
import java.util.function.Supplier;
                null,  
                null,
                false,
            exception = expectThrows(IllegalArgumentException.class, () -> context1.preProcess(false));  
        MapperService mapperService = mock(MapperService.class);  
                            "test",
                Version.CURRENT,
            DefaultSearchContext context = new DefaultSearchContext(
        QueryCachingPolicy queryCachingPolicy = mock(QueryCachingPolicy.class);
import org.opensearch.index.engine.Engine;
                target,
        IndexService indexService = mock(IndexService.class);  
            readerContext = new LegacyReaderContext(  
            // resultWindow greater than maxResultWindow and scrollContext isn't null
                null,
                bigArrays,
            Engine.SearcherSupplier searcherSupplier = new Engine.SearcherSupplier(Function.identity()) {
            }  
                Collections.emptyList()
                    .build()
                    "The number of slices ["
 * compatible open source license.
        ShardId shardId = new ShardId("index", UUID.randomUUID().toString(), 1);  
                newContextId(),  
            readerContext = new ReaderContext(
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.NO, "disable concurrent search")
                null,
            context.aggregations(mockAggregations);
            // Case10: query supports intra-segment search with partition strategy as none
            when(mockAggregations.multiBucketConsumer()).thenReturn(mock(MultiBucketConsumerService.MultiBucketConsumer.class));
                false,
            Settings.builder().put(INDEX_SEARCH_THROTTLED.getKey(), true).build()
}
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.NO_OP, "noop")  
            if (clusterService.getClusterSettings().get(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING)) {  
        when(indexShard.indexSettings()).thenReturn(indexSettings);
            // Case2: if sort is on other field, concurrent path is used  
                randomNonNegativeLong(),
        when(shardSearchRequest.searchType()).thenReturn(SearchType.DEFAULT);
import org.opensearch.search.rescore.RescoreContext;
import org.apache.lucene.search.ConstantScoreQuery;  
        when(indexService.getIndexSettings()).thenReturn(indexSettings);  
            context5.sliceBuilder(sliceBuilder);
                searcherSupplier.get(),
    }
                null,  
            ConcurrentSearchRequestDecider decider2 = mock(ConcurrentSearchRequestDecider.class);  
            // create a source so that query tree is parsed by visitor  
            concurrentSearchRequestDeciders.add(factory3);
 *
                        throw new AssertionError(exc);  
                executor,
            );
                false,
        IndexShard throttledIndexShard = mock(IndexShard.class);
        int maxRescoreWindow = randomIntBetween(50, 100);  
                randomNonNegativeLong(),
                false,  
                concurrentSearchRequestDeciders
            final Supplier<Engine.SearcherSupplier> searcherSupplier = () -> new Engine.SearcherSupplier(Function.identity()) {
                null,  
                assertFalse(context.shouldUseConcurrentSearch());
        Settings settings = Settings.builder()
            .put("index.max_slices_per_scroll", maxSlicesPerScroll)
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            RescoreContext rescoreContext = mock(RescoreContext.class);  
            context1.addRescore(rescoreContext);
            SliceBuilder sliceBuilder = mock(SliceBuilder.class);
                null,
import org.opensearch.common.settings.ClusterSettings;
                false,
            when(decider2.getConcurrentSearchDecision()).thenReturn(
                new SortAndFormats(new Sort(new SortField("@timestamp", SortField.Type.INT)), new DocValueFormat[] { DocValueFormat.RAW })  
import org.opensearch.cluster.service.ClusterService;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            context.evaluateRequestShouldUseConcurrentSearch();  
        when(indexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);
            exception = expectThrows(IllegalArgumentException.class, () -> context1.preProcess(false));
            threadPool.shutdown();
            ConcurrentSearchRequestDecider.Factory factory2 = new ConcurrentSearchRequestDecider.Factory() {  
                indexService,
            context = new DefaultSearchContext(  
                false
                reader,  
                executor,  
                exception1.getMessage(),
 * Licensed to Elasticsearch under one or more contributor  
                            IndexSearcher.getDefaultQueryCache(),
        when(systemIndexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);
            when(shardSearchRequest.getAliasFilter()).thenReturn(AliasFilter.EMPTY);
        when(indexShard.indexSettings()).thenReturn(indexSettings);
                null,
            DefaultSearchContext context = new DefaultSearchContext(
            );
                readerContext,
                @Override
        ShardId shardId = new ShardId("index", UUID.randomUUID().toString(), 1);
                        + maxResultWindow
            // query is already a ConstantScoreQuery, the combined query must stay non-scoring so Lucene's
                null,  
        TimeValue timeout = new TimeValue(randomIntBetween(1, 100));  
        BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            // create a source so that query tree is parsed by visitor
            // Case 4: With a system index concurrent segment search is not used
        ShardSearchRequest shardSearchRequest = mock(ShardSearchRequest.class);  
            );
import org.opensearch.search.slice.SliceBuilder;
                target,
                null,
                null,
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        QueryCachingPolicy queryCachingPolicy = mock(QueryCachingPolicy.class);
                null,
                @Override  
                indexService,
import java.util.Collections;
                null,
            );  
        when(throttledIndexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);  
                null,  
                timeout,  
                false,  
            context4.sliceBuilder(new SliceBuilder(0, 2)).parsedQuery(parsedQuery).preProcess(false);
            SearchShardTarget target = new SearchShardTarget("node", shardId, null, OriginalIndices.NONE);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
                Version.CURRENT,
    }
import org.opensearch.index.mapper.MapperService;  
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
            when(mockAggregations.factories().allFactoriesSupportConcurrentSearch()).thenReturn(false);  
            );
                false,
            when(decider1.getConcurrentSearchDecision()).thenReturn(
        when(shardSearchRequest.searchType()).thenReturn(SearchType.DEFAULT);
                () -> context5.preProcess(false)
                    return Optional.ofNullable(decider1);
                systemIndexShard,  
        ThreadPool threadPool = new TestThreadPool(this.getClass().getName());
                executor,
            // resultWindow not greater than maxResultWindow and both rescore and sort are not null  
        );
                Collections.emptyList()  
            when(rescoreContext.getWindowSize()).thenReturn(500);
                            "test",
            DocValueFormat docValueFormat = mock(DocValueFormat.class);
                assertSettingDeprecationsAndWarnings(new Setting[] { SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING });
                false,
import static org.mockito.Mockito.mock;  
    public static Collection<Object[]> concurrency() {
                            IndexSearcher.getDefaultQueryCache(),
                newContextId(),
                public Optional<ConcurrentSearchRequestDecider> create(IndexSettings indexSettings) {
            context.evaluateRequestShouldUseConcurrentSearch();
                    .put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), "auto")  
                    .put(SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
                        + "] is too large. "
            };
            );
            context.aggregations(mockAggregations);
import static org.mockito.Mockito.anyString;
                clusterService,  
import org.opensearch.index.query.AbstractQueryBuilder;
                            IndexSearcher.getDefaultSimilarity(),
                shardSearchRequest,
                protected Engine.Searcher acquireSearcherInternal(String source) {  
                indexShard,
            );
import org.apache.lucene.tests.index.RandomIndexWriter;  
                null,  
            IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> contextWithoutScroll.preProcess(false));  
            context = new DefaultSearchContext(
        when(throttledIndexShard.getThreadPool()).thenReturn(threadPool);
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
        when(shardSearchRequest.searchType()).thenReturn(SearchType.DEFAULT);
                shardSearchRequest,
            // No exceptions should be thrown
                shardSearchRequest,
        IndexService indexService = mock(IndexService.class);  
                indexService,  
                clusterService,
                false,
            assertThat(
            .put("search.aggregations.streaming.max_estimated_bucket_count", 200000)
            context = new DefaultSearchContext(
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
    @Override
                Collections.emptyList()  
import org.opensearch.search.internal.AliasFilter;
        QueryCachingPolicy queryCachingPolicy = mock(QueryCachingPolicy.class);
            );
                null,  
                false  
            clusterSettings.applySettings(
            // create a supported agg operation
                            reader  
        when(indexService.cache()).thenReturn(indexCache);
                null,  
                null,
                null,
            // resultWindow greater than maxResultWindow and scrollContext is null
            context.searcher().addQueryCancellation(() -> {});
                assertTrue(context.shouldUseConcurrentSearch());  
    }
                executor,
            context.evaluateRequestShouldUseConcurrentSearch();
                false,
                false
                false,
                assertFalse(context.shouldUseConcurrentSearch());
            ReaderContext readerContext = new ReaderContext(  
                public Optional<ConcurrentSearchRequestDecider> create(IndexSettings indexSettings) {
                    .build()
                        + "] index level setting."
                false,
import org.apache.lucene.search.QueryCachingPolicy;
                false,  
            );
 * Unless required by applicable law or agreed to in writing,
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);  
        when(systemIndexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);
                indexShard,  
                null,
            );
                false  
                assertFalse(context.shouldUseConcurrentSearch());
            );
import org.apache.lucene.search.Query;  
            // create a source so that query tree is parsed by visitor
                executor,
        IndexShard indexShard = mock(IndexShard.class);
            clusterSettings.registerSetting(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE);  
                null,  
                Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build()
            context.evaluateRequestShouldUseConcurrentSearch();  
import org.opensearch.action.search.SearchType;  
            DefaultSearchContext context = new DefaultSearchContext(
            }
            pitReaderContext.close();
                            reader,
                bigArrays,
                readerContext,  
                target,
                assertFalse(context.shouldUseConcurrentSearch());  
                null,
                Collections.emptyList()
                randomNonNegativeLong()  
                    .put(SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment")
                Version.CURRENT,  
                concurrentSearchRequestDeciders
                Version.CURRENT,  
            assertTrue(Math.abs(context3.getRelativeTimeInMillis(false) - currTime) <= timeToleranceInMs);
            );  
                searcherSupplier.get(),
                Version.CURRENT,  
            when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
                exception.getMessage(),
                false,
            assertThat(context.searcher().hasCancellations(), is(false));  
                )
            when(shardSearchRequest.indexRoutings()).thenReturn(new String[0]);  
                clusterService,  
                null,  
        assertEquals(0.01, clusterSettings.get(FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO), 0.001);  
                bigArrays,  
            readerContext.close();
        when(shardSearchRequest.shardId()).thenReturn(shardId);
                timeout,  
            context.evaluateRequestShouldUseConcurrentSearch();
                null,
                )
                Version.CURRENT,  
            if (executor == null) {  
            // add un-supported agg operation
            };  
                bigArrays,
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);  
            when(filterSlice.toFilter(any(), any(), any(), any())).thenReturn(new TermQuery(new Term("field", "value")));  
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  
                Version.CURRENT,  
            when(decider2.getConcurrentSearchDecision()).thenReturn(  
            when(decider1.getConcurrentSearchDecision()).thenReturn(
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.NO, "disable concurrent search")
        IndexMetadata indexMetadata = IndexMetadata.builder("index").settings(settings).build();
    public void testSearchPathEvaluationWithConcurrentSearchModeAsAuto() throws Exception {  
                null,
                false,
                shardSearchRequest,
            context3.sliceBuilder(null).parsedQuery(parsedQuery).preProcess(false);
    }  
                bigArrays,  
        ShardSearchRequest shardSearchRequest = mock(ShardSearchRequest.class);
                clusterService,  
                null,
    private ShardSearchContextId newContextId() {
                bigArrays,
                randomNonNegativeLong(),
                Collections.emptyList()
                null,
                        + "] but was [310]. See the scroll api for a more efficient way to request large data sets. "
        when(systemIndexShard.getThreadPool()).thenReturn(threadPool);
        assertEquals(100_000L, (long) clusterSettings.get(FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT));
 * this work for additional information regarding copyright
            );  
                target,
            context = new DefaultSearchContext(
                target,  
                searcherSupplier.get(),
import org.opensearch.cluster.metadata.IndexMetadata;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, settings);  
        when(systemIndexShard.isSystem()).thenReturn(true);  
                Collections.emptyList()  
                false,  
        int maxResultWindow = randomIntBetween(50, 100);
                }
            final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                        return new Engine.Searcher(
import java.util.HashSet;
            );
            );
 */  
                null,
        when(throttledIndexShard.indexSettings()).thenReturn(throttledIndexSettings);  
                assertTrue(context.shouldUseConcurrentSearch());  
                readerContext,
                Version.CURRENT,
import org.opensearch.test.OpenSearchTestCase;
                readerContext,
import org.apache.lucene.search.IndexSearcher;
        when(indexShard.indexSettings()).thenReturn(indexSettings);
                pitReaderContext,
        when(indexShard.getThreadPool()).thenReturn(threadPool);  
                bigArrays,
                null,  
                null,
                target,  
            assertThat(context.searcher().hasCancellations(), is(true));
            SearchContextAggregations mockAggregations = mock(SearchContextAggregations.class);
                false,
            .put("index.max_rescore_window", maxRescoreWindow)  
    }
                equalTo(
import org.opensearch.search.internal.ReaderContext;
            final Supplier<Engine.SearcherSupplier> searcherSupplier = () -> new Engine.SearcherSupplier(Function.identity()) {
            ReaderContext readerWithoutScroll = new ReaderContext(
                shardSearchRequest,
            );
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.NO_OP, "noop")  
        IndexMetadata indexMetadata = IndexMetadata.builder("index").settings(settings).build();
                null,  
                false,  
                readerContext,
import org.opensearch.common.util.BigArrays;  
                indexShard,
                    } catch (IOException exc) {  
                null,
                searcherSupplier.get(),  
        settings.add(FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT);
 * software distributed under the License is distributed on an
                executor,  
                readerContext,  
 * license agreements. See the NOTICE file distributed with
            assertThat(context.searcher().hasCancellations(), is(false));
            // rescore is null but sort is not null and rescoreContext.getWindowSize() exceeds maxResultWindow
            context = new DefaultSearchContext(
                null,  
                protected Engine.Searcher acquireSearcherInternal(String source) {
            );  
            DefaultSearchContext context2 = new DefaultSearchContext(  
                shardSearchRequest,
                timeout,  
                        + "]. This limit can be set by changing the ["  
                        + numSlices  
                shardSearchRequest,
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
                IndexSearcher.getDefaultSimilarity(),
                reader
                indexShard,  
                readerContext,
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
            when(intraSegmentQuery.supportsIntraSegmentSearch()).thenReturn(false);
                bigArrays,
        );
        IndexSettings throttledIndexSettings = new IndexSettings(
            final ClusterService clusterService = mock(ClusterService.class);  
                null,  
                        IndexReader reader = w.getReader();
                assertTrue(context.shouldUseConcurrentSearch());
            // while second decider returns ConcurrentSearchDecision.DecisionStatus.NO  
import org.opensearch.index.shard.IndexShard;  
        settings.add(FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT);
import static org.hamcrest.Matchers.is;
            assertFalse(context.shouldUseConcurrentSearch());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            );
            context1.from(300);
        QueryShardContext queryShardContext = mock(QueryShardContext.class);  
                shardSearchRequest,
            when(sliceBuilder.getMax()).thenReturn(numSlicesForPit);  
            );
                clusterService,
                target,
                null,  
                            IndexSearcher.getDefaultSimilarity(),  
        when(indexService.newQueryShardContext(eq(shardId.id()), any(), any(), nullable(String.class), anyBoolean(), anyBoolean()))
            ConcurrentSearchRequestDecider decider1 = mock(ConcurrentSearchRequestDecider.class);
                new SortAndFormats(new Sort(new SortField("test2", SortField.Type.INT)), new DocValueFormat[] { DocValueFormat.RAW })  
                        + "be less than ["
            threadPool.shutdown();
                executor,  
    public void testClearQueryCancellationsOnClose() throws IOException {
                Version.CURRENT,
                indexService,
                null,
                null,  
                false,
                randomNonNegativeLong(),
import org.apache.lucene.search.TermQuery;
import org.opensearch.index.IndexService;  
                executor,
                false,  
                target,  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
            when(intraSegmentQuery.supportsIntraSegmentSearch()).thenReturn(true);
                Settings.builder()
                        + "]. This prevents allocating massive heaps for storing the results "
        when(throttledIndexShard.getThreadPool()).thenReturn(threadPool);
                        throw new AssertionError(exc);
            QueryBuilder intraSegmentQuery = mock(QueryBuilder.class);
            if (executor == null) {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 * GitHub history for details.
                shardSearchRequest,
            .thenReturn(queryShardContext);
                false,
            );
                assertFalse(context.shouldUseConcurrentSearch());
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
            when(decider2.getConcurrentSearchDecision()).thenReturn(
                null,
                target,
            DefaultSearchContext context4 = new DefaultSearchContext(
                bigArrays,
            } else {  
                concurrentSearchRequestDeciders
                shardSearchRequest,
            int numSlices = maxSlicesPerScroll + randomIntBetween(1, 100);  
            context2.sliceBuilder(sliceBuilder);
            context.evaluateRequestShouldUseConcurrentSearch();
                indexShard,  
                false,
            assertThat(exception.getMessage(), equalTo("Cannot use [sort] option in conjunction with [rescore]."));
                null,  
        ClusterSettings clusterSettings = new ClusterSettings(customSettings, settings);
            // COMPLETE_NO_SCORES fast path is preserved; a normal query is combined into a scoring BooleanQuery.  
                exception.getMessage(),
                @Override  
                            IndexSearcher.getDefaultQueryCachingPolicy(),  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            readerContext.close();
                newContextId(),  
                null,
            context.evaluateRequestShouldUseConcurrentSearch();  
import org.opensearch.threadpool.ThreadPool;
                Version.CURRENT,  
                randomNonNegativeLong()
                        + "It must be less than ["
import org.opensearch.index.query.QueryShardContext;
            when(shardSearchRequest.scroll()).thenReturn(new Scroll(TimeValue.timeValueMillis(randomInt(1000))));  
                        return new Engine.Searcher(  
            } else {  
                bigArrays,  
                target,  
            // with supported agg query so concurrent path is used
                clusterService,  
            );
        when(systemIndexShard.isSystem()).thenReturn(true);  
            int numSlicesForPit = maxSlicesPerPit + randomIntBetween(1, 100);
                null,  
            List<ConcurrentSearchRequestDecider.Factory> concurrentSearchRequestDeciders = new ArrayList<>();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
                executor,
                assertTrue(context.shouldUseConcurrentSearch());
import org.opensearch.action.OriginalIndices;
                protected void doClose() {}  
            );
            final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                Version.CURRENT,
            );  
            long timeToleranceInMs = 10;  
                readerContext,  
                public Optional<ConcurrentSearchRequestDecider> create(IndexSettings indexSettings) {
        IndexMetadata indexMetadata = IndexMetadata.builder("index").settings(settings).build();  
                    try {
                        + "]. This limit can be set by changing the ["
import java.util.Collection;  
                null,  
        when(shardSearchRequest.shardId()).thenReturn(shardId);
                Version.CURRENT,  
            .build();
            );
        settings.add(FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT);
                IndexSearcher.getDefaultQueryCache(),
                }  
            }
                newContextId(),
                executor,
            ParsedQuery parsedQuery = ParsedQuery.parsedMatchAllQuery();  
            assertThat(
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
            );  
            final Supplier<Engine.SearcherSupplier> searcherSupplier = () -> new Engine.SearcherSupplier(Function.identity()) {
                exception.getMessage(),  
 * the Apache License, Version 2.0 (the "License"); you may
                null,  
                    try {
                shardSearchRequest,
                target,  
        ThreadPool threadPool = new TestThreadPool(this.getClass().getName());  
            // create a supported agg operation
import org.opensearch.common.util.MockPageCacheRecycler;
            );
            );  
                        + IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey()
            Settings.builder().put(INDEX_SEARCH_THROTTLED.getKey(), true).build()
        when(mapperService.hasNested()).thenReturn(randomBoolean());
            );
                readerWithoutScroll,
                assertFalse(context.shouldUseConcurrentSearch());
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.YES, "enable concurrent search")
import static org.mockito.Mockito.when;
                bigArrays,
            DefaultSearchContext context5 = new DefaultSearchContext(
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                false,
                }
import org.opensearch.core.index.shard.ShardId;
            .put("index.max_result_window", maxResultWindow)
            );  
            if (executor == null) {
            // Case 3: With no sort, concurrent path is used
                Version.CURRENT,  
                searcherSupplier.get(),
                target,  
import org.opensearch.common.SetOnce;  
                null,
                null,
            when(queryShardContext.fieldMapper(anyString())).thenReturn(mock(MappedFieldType.class));
                false
            if (executor == null) {
            Query query2 = context4.query();  
            indexMetadata,  
                OpenSearchRejectedExecutionException.class,
package org.opensearch.search;
            assertFalse(context.shouldUseConcurrentSearch());  
                shardSearchRequest,
            // Case5: multiple deciders are registered and one of them returns ConcurrentSearchDecision.DecisionStatus.NO
            context.aggregations(mockAggregations);
            when(shardSearchRequest.source()).thenReturn(sourceBuilder);  
            );
            .build();
import org.apache.lucene.search.MatchNoDocsQuery;
            context1.sort(sortAndFormats);
 * ownership. Elasticsearch licenses this file to you under  
                timeout,
                        throw new AssertionError(exc);  
import org.opensearch.index.IndexSettings;
        when(indexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);  
import org.opensearch.index.mapper.MappedFieldType;
                null,
import org.opensearch.index.cache.query.QueryCache;  
                newContextId(),
                readerContext,  
            readerContext = new ReaderContext(  
        }  
                        IndexReader reader = w.getReader();  
                executor,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                newContextId(),
    }  
                searcherSupplier.get(),  
            // Case2: if un supported agg present, non-concurrent path is used  
            clusterSettings.registerSetting(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING);
                        IndexReader reader = w.getReader();
        when(throttledIndexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);  
                target,
                null,  
            // should use concurrent search via intra-segment search path
                timeout,
            // Case7: multiple deciders are registered and all return ConcurrentSearchDecision.DecisionStatus.NO_OP
            concurrentSearchRequestDeciders.add(factory2);  
            if (executor == null) {
                shardSearchRequest,
/*  
            SearchShardTarget target = new SearchShardTarget("node", shardId, null, OriginalIndices.NONE);
            // Case3: if supported agg present, concurrent path is used  
 */
                indexService,  
        TimeValue timeout = new TimeValue(randomIntBetween(1, 100));
                null,
                            reader  
            );
            DefaultSearchContext context1 = new DefaultSearchContext(  
import static org.mockito.Mockito.any;
                instanceOf(ConstantScoreQuery.class)
            when(intraSegmentQuery.supportsIntraSegmentSearch()).thenReturn(true);  
                false,
            when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
    }  
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);  
                executor,
            // Case 5: When search is throttled concurrent segment search is not used
            );  
                Collections.emptyList()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
import org.opensearch.search.aggregations.SearchContextAggregations;  
                clusterService,  
                shardSearchRequest,
            when(sliceBuilder.getMax()).thenReturn(numSlices);
                    "Rescore window ["
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
        this.executor = (concurrency > 0) ? Executors.newFixedThreadPool(concurrency) : null;
                bigArrays,
                exception.getMessage(),  
            clusterSettings.registerSetting(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING);
        } finally {
                    "The number of slices ["
                false,
                null,
            // shutdown the threadpool  
    }
            );
                false,
            // set agg operation to be supported
        }
                "test",
                        + maxRescoreWindow  
            assertThat(
        ThreadPool threadPool = new TestThreadPool(this.getClass().getName());  
            // use non-concurrent path even if query contains supported agg  
        ShardSearchRequest shardSearchRequest = mock(ShardSearchRequest.class);
            .build();
            );  
        IndexSettings throttledIndexSettings = new IndexSettings(
            readerContext = new ReaderContext(  
    public DefaultSearchContextTests(int concurrency) {  
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
                null,
                }
                bigArrays,
            ThreadPool.terminate(executor, 10, TimeUnit.SECONDS);  
                Version.CURRENT,  
import java.util.Optional;
            context1.sort(null);
                shardSearchRequest,
            context.evaluateRequestShouldUseConcurrentSearch();
                newContextId(),
import org.opensearch.common.settings.Settings;
                timeout,
            when(clusterService.getSettings()).thenReturn(settings);  
            context.evaluateRequestShouldUseConcurrentSearch();
                false,  
                false,
                        + IndexSettings.MAX_SLICES_PER_SCROLL.getKey()
                null,  
                        + maxSlicesPerScroll  
        when(indexShard.getThreadPool()).thenReturn(threadPool);
            context.evaluateRequestShouldUseConcurrentSearch();
                shardSearchRequest,  
            .thenReturn(queryShardContext);  
            };
            context = new DefaultSearchContext(  
        Settings settings = Settings.builder()  
                target,
                bigArrays,
            RandomIndexWriter w = new RandomIndexWriter(random(), dir);
                executor,
                readerContext,  
            );
            IndexReader reader = w.getReader();  
 */  
            );
                concurrentSearchRequestDeciders
                Collections.emptyList()
            context.sort(
                randomNonNegativeLong(),  
            );
            threadPool.shutdown();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                null,
                readerContext,
    }
                shardSearchRequest,  
import org.opensearch.search.internal.ShardSearchContextId;
import static org.opensearch.index.IndexSettings.INDEX_SEARCH_THROTTLED;
            contextWithoutScroll.from(300);
            );
        IndexService indexService = mock(IndexService.class);
        QueryCachingPolicy queryCachingPolicy = mock(QueryCachingPolicy.class);
            assertThat(context3.buildFilteredQuery(new TermQuery(new Term("content", "alpha"))), instanceOf(BooleanQuery.class));  
                null,
 * Modifications Copyright OpenSearch Contributors. See
                            IndexSearcher.getDefaultQueryCachingPolicy(),
                null,  
        when(indexService.mapperService()).thenReturn(mapperService);
import org.opensearch.search.internal.LegacyReaderContext;
            ConcurrentSearchRequestDecider.Factory factory1 = new ConcurrentSearchRequestDecider.Factory() {
            .build();
                Settings.builder()
            assertFalse(context.shouldUseConcurrentSearch());
 *    http://www.apache.org/licenses/LICENSE-2.0
                null,
        when(systemIndexShard.getThreadPool()).thenReturn(threadPool);
                false,
            );
            );
                indexService,
                timeout,
        BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
                bigArrays,
                null,  
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.NO_OP, "noop")
                throttledIndexShard,
import org.apache.lucene.store.Directory;
import org.opensearch.common.unit.TimeValue;
 *  
            .thenReturn(queryShardContext);  
                clusterService,  
                null,  
                        + "to be rescored. This limit can be set by changing the ["
                }
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);  
                equalTo(
                null,
 * not use this file except in compliance with the License.
                executor,  
                protected void doClose() {
        IndexCache indexCache = mock(IndexCache.class);
        Set<Setting<?>> settings = new HashSet<>();
                null,
                null,
        IndexMetadata indexMetadata = IndexMetadata.builder("index").settings(settings).build();
                indexShard,  
                        + "] index level setting."
                @Override
                        return new Engine.Searcher(  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            .put("search.aggregations.streaming.min_cardinality_ratio", 0.05)  
                indexService,
            assertFalse(context.shouldUseConcurrentSearch());
import org.opensearch.search.streaming.FlushModeResolver;
                        + " ["
                    .put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), "auto")  
                @Override
            clusterSettings.applySettings(
                false,
            }
                equalTo(  
            concurrentSearchRequestDeciders.add(factory1);
                null,  
                executor,  
        assertEquals(0.05, clusterSettings.get(FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO), 0.001);
        assertEquals(1000L, (long) clusterSettings.get(FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT));
import org.opensearch.index.query.ParsedQuery;  
                false,
                target,
                IndexSearcher.getDefaultQueryCachingPolicy(),  
            .build();
                null,
                bigArrays,
            when(shardSearchRequest.source()).thenReturn(sourceBuilder);  
                false,
                executor,
            context = new DefaultSearchContext(  
            };
import org.apache.lucene.search.Sort;
                assertFalse(context.shouldUseConcurrentSearch());
            // clusterSettings.registerSetting(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE);  
                null,
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
                }  
                target,
            ReaderContext readerContext = new LegacyReaderContext(
    public void testPreProcess() throws Exception {
            );  
                executor,  
                indexShard,
                new ConcurrentSearchDecision(ConcurrentSearchDecision.DecisionStatus.NO_OP, "noop")  
                readerContext,
import org.opensearch.index.query.QueryBuilder;
            if (executor == null) {
                Version.CURRENT,
            when(shardSearchRequest.source()).thenReturn(sourceBuilder);
        ShardId shardId = new ShardId("index", UUID.randomUUID().toString(), 1);  
            when(mapperService.hasNested()).thenReturn(false);
                    return Optional.ofNullable(decider2);  
            context4.sliceBuilder(new SliceBuilder(1, 2)).parsedQuery(parsedQuery).preProcess(false);  
                false,
                protected void doClose() {}
                clusterService,
                Version.CURRENT,  
                    "Batch size is too large, size must be less than or equal to: ["  
import org.opensearch.common.UUIDs;
            }  
                null,  
                protected Engine.Searcher acquireSearcherInternal(String source) {  
                Collections.emptyList()
import org.opensearch.index.query.BoolQueryBuilder;
                target,
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
        when(indexShard.getQueryCachingPolicy()).thenReturn(queryCachingPolicy);  
                target,
        when(indexService.getIndexSettings()).thenReturn(indexSettings);
 * KIND, either express or implied.  See the License for the
            SearchSourceBuilder intraSegmentSourceBuilder = new SearchSourceBuilder();  
                        + "be less than ["
            SliceBuilder filterSlice = mock(SliceBuilder.class);
                concurrentSearchRequestDeciders
    public void testStreamingSettingsDefaults() {  
            when(decider1.getConcurrentSearchDecision()).thenReturn(  
                null,
            );
            when(shardSearchRequest.source()).thenReturn(intraSegmentSourceBuilder);
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
        when(indexService.newQueryShardContext(eq(shardId.id()), any(), any(), nullable(String.class), anyBoolean(), anyBoolean()))
                null,
        Settings customSettings = Settings.builder()
                readerContext,  
        try (  
            long currTime = TimeValue.nsecToMSec(System.nanoTime());
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
                Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), "auto").build()  
            );
                false,
            // make sure getPreciseRelativeTimeInMillis is same as System.nanoTime()
                executor,
                assertFalse(context.shouldUseConcurrentSearch());  
            // Case1: if sort is on timestamp field, non-concurrent path is used
            context.aggregations(mockAggregations);
                null,
                null,
            );
                searcherSupplier.get(),
            }
import static org.mockito.Mockito.nullable;
                newContextId(),  
                null,
            Engine.Searcher searcher = new Engine.Searcher(
import org.apache.lucene.search.BooleanQuery;
                Collections.emptyList()
        IndexShard indexShard = mock(IndexShard.class);  
        when(indexShard.getThreadPool()).thenReturn(threadPool);
            };  
            } else {  
            };  
    }
            assertFalse(context.shouldUseConcurrentSearch());
            context.close();
                Version.CURRENT,  
        when(shardSearchRequest.shardId()).thenReturn(shardId);  
        when(shardSearchRequest.shardId()).thenReturn(shardId);
            }  
            assertThrows(SetOnce.AlreadySetException.class, context::evaluateRequestShouldUseConcurrentSearch);
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;  
        ThreadPool threadPool = new TestThreadPool(this.getClass().getName());  
                newContextId(),
                @Override
/*
            assertEquals(context3.query(), context3.buildFilteredQuery(parsedQuery.query()));
                assertFalse(context.shouldUseConcurrentSearch());
                        + "controlled by the ["  
import org.apache.lucene.search.SortField;  
                            "test",
            // create a supported agg operation
                null,
                bigArrays,  
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
import java.util.Arrays;
                null,
                        + "] is too large. It must "  
                        + maxResultWindow  
            context3.sliceBuilder(null);
                    } catch (IOException exc) {
import org.apache.lucene.index.IndexReader;  
                bigArrays,
                null,
        when(indexShard.getThreadPool()).thenReturn(threadPool);
        ) {  
            BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
            threadPool.shutdown();
                    } catch (IOException exc) {
                        );
                            reader
            context.evaluateRequestShouldUseConcurrentSearch();  
            // create a supported agg operation
import static org.mockito.Mockito.eq;
import org.opensearch.search.internal.PitReaderContext;  
import java.util.UUID;  
            if (executor == null) {  
                searcherSupplier,  
            } else {
import org.opensearch.search.sort.SortAndFormats;  
 * You may obtain a copy of the License at  
        settings.add(FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO);
            assertFalse(context.shouldUseConcurrentSearch());  

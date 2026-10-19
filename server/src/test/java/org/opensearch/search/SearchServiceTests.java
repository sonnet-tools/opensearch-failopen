            null
            { true, true, "none", false },
                    .indices()
        ShardSearchRequest shardSearchRequest = new ShardSearchRequest(
import org.apache.lucene.search.FieldDoc;
        assertFalse(SearchService.canRewriteToMatchNone(null));
     *       pick index level slice count setting if index level setting is set
                for (int i = 0; i < 5; i++) {
                assertNotNull(context);
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        }
                // set the aggregations for context
                assertThat(searchContext.searcher().getTaskExecutor(), is(notNullValue()));
                    + "This limit can be set by changing the [index.max_docvalue_fields_search] index level setting.",
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(false)
                "Trying to retrieve too many script_fields. Must be less than or equal to: ["
                public void onQueryPhase(SearchContext context, long tookInNanos) {
                "date",
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(3, 10);
            if (indexSetting == null) {
                        .prepareState()
                    .prepareUpdateSettings(index)
            semaphore.acquire(Integer.MAX_VALUE);
     */
        assertThat(searchResponse.getScrollId(), is(notNullValue()));
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), true);
            }
        try {
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), false);
                    client().admin()
            }
        final ShardSearchRequest request = new ShardSearchRequest(shardId, 0, null) {
            ).canMatch()
        // Cleanup
            id,
        if (indexMode == null) {
        SearchService searchService = getInstanceFromNode(SearchService.class);
            { true, false, "auto", false },
        final SearchService service = getInstanceFromNode(SearchService.class);
                );
        final long seconds = randomIntBetween(6, 10);
    public void testUpdatePitIdMaxKeepAlive() {
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                        latch.countDown();
                    .cluster()
            .get();
         */
                new Script(ScriptType.INLINE, MockScriptEngine.NAME, CustomScriptPlugin.DUMMY_SCRIPT, Collections.emptyMap())
            client().admin()
            indexMode,
                assertEquals(concurrentSearchSetting, searchContext.shouldUseConcurrentSearch());
        {
                }
import java.util.Collection;
        public Scroll scroll() {
            searchRequest,
import org.opensearch.plugins.SearchPlugin;
            } finally {
            Boolean indexSetting = (Boolean) scenario[1];
                        final Engine.SearcherSupplier reader = indexShard.acquireSearcherSupplier();
            assertNotNull(context.getQueryShardContext().resolveDerivedFieldType("field"));
            // Adding cases with mode set to "all"
        indexService.getIndexSettings().isDerivedFieldAllowed();
                return reader;
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
import java.util.concurrent.CountDownLatch;
        ShardSearchRequest request = new ShardSearchRequest(
                IndexSettings.INDEX_SEARCH_THROTTLED.getKey(),
    /**
        );
                    searchRequest,
                .get()
            }
        SearchRequest searchRequest = new SearchRequest();
                        -1,
        });
        client().admin()
            SearchContext contextWithDefaultTimeout = service.createContext(reader, requestWithDefaultTimeout, null, randomBoolean())
            );
        ShardId shardId = new ShardId(indexService.index(), 0);
            )
import org.opensearch.core.index.shard.ShardId;
            indexService.numberOfShards(),
            new InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.Request(
                                indexShard.shardId(),
                .get();
                .sort(new ScoreSortBuilder().order(SortOrder.ASC))
        SearchShardTask task = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());
                .prepareUpdateSettings()
            public void onResponse(SearchPhaseResult searchPhaseResult) {
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> {
            1f,
            // update concurrent search cluster setting and create search context
                    + (maxScriptFields + 1)
            SearchPhaseExecutionException.class,
                        }
    }
                }
        int maxScriptFields = indexService.getIndexSettings().getMaxScriptFields();
            0,
     * Test for DESC order search_after query with track_total_hits=true.
                new ShardSearchRequest(
            OriginalIndices.NONE,
        );
                        Settings.builder()
        public void onIndexModule(IndexModule indexModule) {
        assertEquals(0, service.getActiveContexts());
            1.0f,
    public void testMaxDocvalueFieldsSearch() throws IOException {
                + "This limit can be set by changing the ["
        primarySort.order(SortOrder.DESC);
                                        + maxScrollContexts
        final IndexShard indexShard = indexService.getShard(0);
        SearchStats.Stats totalStats = indexShard.searchStats().getTotal();
import org.opensearch.search.internal.ShardSearchContextId;
            nowInMillis,
import org.opensearch.script.MockScriptPlugin;
    public void testSearchWhileIndexDeletedDoesNotLeakSearchContext() throws ExecutionException, InterruptedException {
                .prepareUpdateSettings()
            shardRequest.source().query(new MatchAllQueryBuilder());
            new SearchSourceBuilder().query(new MatchNoneQueryBuilder()).aggregation(new GlobalAggregationBuilder("test"))
     * test that creating more than the allowed number of scroll contexts throws an exception
                    service.afterIndexRemoved(indexService.index(), indexService.getIndexSettings(), DELETED);
    /**
                .get()
    private void resetCount() {
            searchRequest,
            }
                "true"
import org.opensearch.common.settings.Settings;
        primarySort.order(SortOrder.DESC);
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
                            new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()),
                                true
            reduceContext.consumeBucketsAndMaybeBreak(MultiBucketConsumerService.DEFAULT_MAX_BUCKETS + 1);
        assertEquals(
                latch.countDown();
import org.opensearch.index.query.MatchNoneQueryBuilder;
import org.opensearch.action.search.SearchPhaseExecutionException;
        } else {
    }
        Integer[][] scenarios = {
        final SearchService service = getInstanceFromNode(SearchService.class);
            shardId,
        assertEquals(0, totalStats.getQueryCurrent());
                + "). "
                            );
                useScroll ? scrollSearchRequest : searchRequest,
        final ShardSearchRequest request = new ShardSearchRequest(
            boolean aggregationSupportsConcurrent = randomBoolean();
                            );
        createIndex("index");
                        .prepareState()
        createIndex("index");
                                OriginalIndices.NONE,
        createIndex("index", Settings.builder().put("index.refresh_interval", -1).build());
            null,
            service.canMatch(
        for (int i = 0; i < clearScrollIds.size(); i++) {
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            // Cleanup
            )
                    1,
                        new AliasFilter(null, Strings.EMPTY_ARRAY),
            null,
                        .get()
        InterruptedException {
            } else {
            SearchRequest scrollSearchRequest = new SearchRequest().allowPartialSearchResults(true)
                        if (useScroll) {
        assertFalse(SearchService.canRewriteToMatchNone(new SearchSourceBuilder()));
     * Expected result is canMatch = false
            assertEquals("expected", e.getMessage());
            OriginalIndices.NONE,
        assertEquals(0, totalStats.getQueryCurrent());
        );
        ShardId shardId = new ShardId(indexService.index(), 0);
        );
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), true);
            return 0;
                .get()
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
        SearchRequest scrollSearchRequest = new SearchRequest().allowPartialSearchResults(true)
            ReaderContext reader = createReaderContext(indexService, indexShard);
    public void testCanMatchSearchAfterDescLessThanMinWithTrackTotalhits() throws IOException {
                        indexService,
         * Checks that canMatch takes into account the alias filter
            Strings.EMPTY_ARRAY
        // with aggregations.
                    searchRequest,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        searchService.createPitReaderContext(new ShardId(resolveIndex("index"), 0), TimeValue.timeValueMinutes(between(1, 10)), future);
            Integer targetSliceCount = sliceCounts[2];
        assertTrue(
        IndexShard indexShard = indexService.getShard(shardId);
                        .get()
            return this.scroll;
                // verify that concurrent segment search is still set to same expected value for the context
        latch.await();
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(3, 10);
                    contextIds.remove(contextId);
        UpdatePitContextRequest updateRequest = new UpdatePitContextRequest(
                .prepareUpdateSettings("index")
import org.opensearch.indices.IndicesService;
                throw new IllegalStateException("Fail on rewrite phase");
                + SearchService.MAX_OPEN_SCROLL_CONTEXT.get(Settings.EMPTY)
                    OriginalIndices.NONE,
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
                client().admin()
                + "] cluster level setting.",
                    // make sure that the wrapper is called when the query is actually executed
                .get();
            searchRequest,
            indexService.numberOfShards(),
 * specific language governing permissions and limitations
                    -1,
import static java.util.Collections.singletonList;
    /**
import static org.hamcrest.CoreMatchers.equalTo;
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
                concurrentSearchEnabled = !indexMode.equals("none") && aggregationSupportsConcurrent;
            client().admin()
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(searchService.getActiveContexts(), equalTo(maxScrollContexts));
                        indexShard,
                    .cluster()
        }
            new InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.Request(
        }
                )
        FetchSearchResult fetchResult = fetchFuture.get();
            InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.INSTANCE,
            Integer clusterSliceCount = sliceCounts[0];
            OriginalIndices.NONE,
        primarySort.missing("_last");
        assertEquals(0, service.getActiveContexts());
            searchRequest,
    public static class FailOnRewriteQueryPlugin extends Plugin implements SearchPlugin {
        createIndex("index");
        assertHitCount(client().prepareSearch().get(), 0L);
                                public void onFailure(Exception e) {
                        return;
            AliasFilter.EMPTY,
            ).canMatch()
        PlainActionFuture<SearchPhaseResult> queryFuture = new PlainActionFuture<>();
        }
        InternalAggregation.ReduceContextBuilder reduceContextBuilder = service.aggReduceContextBuilder(new SearchSourceBuilder());
            if (mode == null) {
        SearchShardTask task = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());
            public void onFailure(Exception e) {
            shardId,
            }
        try (ReaderContext reader = createReaderContext(indexService, indexShard)) {
            { false, false, "all", true },
            PlainActionFuture<UpdatePitContextResponse> updateFuture = new PlainActionFuture<>();
        }
        );
                        assertThat(Thread.currentThread().getName(), startsWith("opensearch[node_s_0][search]"));
                    indexSetting == null ? null : indexSetting.toString(),
        final SearchService service = getInstanceFromNode(SearchService.class);
        assertThat(searchService.getActiveContexts(), equalTo(0));
        service.executeQueryPhase(
        final ShardSearchRequest request = new ShardSearchRequest(
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        searchRequest.source(
                    assertThat(searchService.getActiveContexts(), equalTo(contextIds.size()));
import org.opensearch.index.IndexSettings;
                    ex.getMessage(),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
                            .setRefreshPolicy(randomFrom(WriteRequest.RefreshPolicy.values()))
import org.opensearch.action.support.IndicesOptions;
        );
                    }
            { false, true, "auto", false } };
        // without aggregations.
     * Test for ASC order search_after query.
    protected Settings nodeSettings() {
            service.canMatch(
                    + "]. This limit can be set by changing the [index.max_script_fields] index level setting.",
                        new SearchRequest().allowPartialSearchResults(true),
        IndexShard indexShard = indexService.getShard(0);
        latch.await();
        ) {
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { 7L });
                    .aggregation(new TermsAggregationBuilder("test").userValueTypeHint(ValueType.STRING).minDocCount(0))
            ),
            null,
                    try {
                    }
            null,
        final SearchService service = getInstanceFromNode(SearchService.class);
                    } finally {
                    .get();
                } catch (AlreadyClosedException ex) {
            shardRequest.source().query(new MatchNoneQueryBuilder());
            // auto mode concurrent search is false since request has no aggregation
                            return;
            indexModule.addSearchOperationListener(new SearchOperationListener() {
    }
                    .setTransientSettings(Settings.builder().putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey()))
import java.util.concurrent.ExecutionException;
                        Settings.builder().put(IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT.getKey(), indexSliceCount)
                try {
                }
     * Min = 0L, Max = 9L, search_after = -1L
                assertEquals(concurrentSearchEnabled, searchContext.shouldUseConcurrentSearch());
                    .indices()
            return null;
            1.0f,
                .indices()
                "true"
            null
            )
        );
                    } finally {
        for (int i = 0; i < 5; i++) {
                        final boolean useScroll = randomBoolean();
            searchRequest,
        );
        );
                assertEquals(concurrentSearchSetting, searchContext.shouldUseConcurrentSearch());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchRequest searchRequest = new SearchRequest();
            } else if (clusterMode != null) {
            SearchService.canRewriteToMatchNone(
                new ShardSearchRequest(
     * Tests that the slice count is calculated correctly when concurrent search is enabled
            .get();
    }
        assertEquals("No search context found for id [" + id.getId() + "]", ex.getMessage());
                    null,
import org.opensearch.cluster.service.ClusterService;
                    .prepareUpdateSettings()
                .prepareUpdateSettings("index")
            { null, null, "none", false },
        for (Boolean concurrentSearchSetting : concurrentSearchStates) {
                while (running.get()) {
    private static AtomicInteger numWrapInvocations = new AtomicInteger(0);
                () -> reduceContext.consumeBucketsAndMaybeBreak(MultiBucketConsumerService.DEFAULT_MAX_BUCKETS + 1)
                    searchRequest,
            client().prepareIndex("test").setSource("f", "v").get();
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
 * software distributed under the License is distributed on an
            .setTransientSettings(
import org.opensearch.common.unit.TimeValue;
        final SearchService service = getInstanceFromNode(SearchService.class);
            assertSame(searchShardTarget, searchContext.dfsResult().getSearchShardTarget());
     *       else pick default cluster level slice count setting
            // update mode
        latch.await();
        );
            OriginalIndices.NONE,
    /**
        );
        );
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
        assertAcked(client().admin().indices().prepareDelete("index"));
 * Unless required by applicable law or agreed to in writing,
                        .cluster()
                    try {
                    }
import java.util.ArrayList;
            clusterMode,
            );
                    .setTransientSettings(Settings.builder().putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey()))
        createIndex("index");
                }
        client().admin().indices().prepareDelete("test").get();
        }
                                        + "["
    public void testIgnoreScriptfieldIfSizeZero() throws IOException {
                client().admin()
        SearchService service = getInstanceFromNode(SearchService.class);
        );
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
            SearchService.canRewriteToMatchNone(
        indexShard.getThreadPool().executor(ThreadPool.Names.SEARCH).execute(() -> {
                        } catch (InterruptedException e) {
        // cleanup
import org.opensearch.core.action.ActionListener;
                        }
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { -1L });
                .aggregation(new TermsAggregationBuilder("test").userValueTypeHint(ValueType.STRING).minDocCount(0))
    }
        service.executeQueryPhase(shardSearchRequest, randomBoolean(), task, queryFuture);
import org.opensearch.search.internal.ShardSearchRequest;
            new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()),
                    null
            @Override
                .getSetting(index, IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MODE.getKey())
            }
            .setIndicesOptions(IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED)
import java.util.List;
        }
        assertEquals(
                    indexShard.shardId(),
                1,
            new SearchContextIdForNode(null, "node1", shardSearchContextId)
        @Override
                    }
        createIndex("index");
                .prepareUpdateSettings()
            client().admin()
import org.opensearch.action.support.WriteRequest;
                .prepareGetSettings(index)
                } catch (IllegalStateException ex) {
            { true, true, null, true },
                    .get();
        long nowInMillis = System.currentTimeMillis();
                Settings.builder()
import org.opensearch.index.query.MatchAllQueryBuilder;
                new SearchRequest().allowPartialSearchResults(true),
            .prepareUpdateSettings()
        docIds.add(0);
        long nowInMillis = System.currentTimeMillis();
            });
        ShardFetchRequest fetchRequest = new ShardFetchRequest(queryResult.getContextId(), docIds, null);
     */
        assertTrue(updateResponse.getPitId().equalsIgnoreCase("pitId"));
        final SearchService searchService = getInstanceFromNode(SearchService.class);
                client().admin()
        searchRequest.source(searchSourceBuilder);
            .prepareUpdateSettings()
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
            1.0f,
                    .setSettings(
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(3, 10);
            { null, null, "auto", false },
            OriginalIndices.NONE,
            1.0f,
import org.opensearch.search.sort.SortOrder;
        assertEquals("can not update private setting [index.search.throttled]; this setting is managed by OpenSearch", se.getMessage());
        ShardSearchRequest request = new ShardSearchRequest(
            null,
        MockSearchService service = (MockSearchService) getInstanceFromNode(SearchService.class);
    public void testCanMatchSearchAfterDescGreaterThanMin() throws IOException {
            { true, true, "all", true },
        final boolean useScroll = randomBoolean();
        }
        );
        createIndex("index");
        assertFalse(
     * Test that the Search Context for concurrent segment search enabled is set correctly at the time of construction.
                NullPointerException.class,
    protected Collection<Class<? extends Plugin>> getPlugins() {
                .prepareUpdateSettings("throttled_threadpool_index")
                    1.0f,
                        SearchContextMissingException.class,
    public void testMaxScriptFieldsSearch() throws IOException {
        }
            // nothing disabled, derived field resolved fine
            if (clusterSliceCount != null) {
        service.doStop();
                    .get();
                                    semaphore.release();
        searchRequest.source(
            1.0f,
                                null
        final ShardSearchRequest request = new ShardSearchRequest(
                null,
                    );
        ) {
    /**
    }
            -1,
        createIndex("index");
                    }
        ShardSearchContextId id = new ShardSearchContextId("session", 9);
                                        + "]. "
            clusterAlias,
        Thread[] searchers = new Thread[randomIntBetween(1, 4)];
        final ShardId shardId = new ShardId(indexService.index(), 0);
                assertEquals(
        final int maxScrollContexts = SearchService.MAX_OPEN_SCROLL_CONTEXT.get(Settings.EMPTY);
        }
            "Keep alive for request (1d) is too large. "
        searchRequest.source(searchSourceBuilder);
            ReaderContext reader = createReaderContext(indexService, indexShard);
 * the Apache License, Version 2.0 (the "License"); you may
            running.set(false);
        future.actionGet();
            FailOnRewriteQueryPlugin.class,
            // Adding cases with mode set to "auto"
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), true);
                assertEquals(concurrentSearchEnabled, searchContext.shouldUseConcurrentSearch());
            Boolean concurrentSearchEnabled = (Boolean) scenario[3];
        ShardSearchRequest request = new ShardSearchRequest(
            assertEquals(expectedIndexName, searchShardTarget.getFullyQualifiedIndexName());
                concurrentSearchEnabled = !clusterMode.equals("none") && aggregationSupportsConcurrent;
        validatePitStats("index", 1, 0, 0);
        searchSourceBuilder.derivedField(
                    throw new AssertionError(e);
                .cluster()
        String[] modeSettings = { "all", "auto", "none", null };
                .transientSettings()
                    .putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey())
            searchService.updatePitIdAndKeepAlive(updateRequest, updateFuture);
                request,
                assertThat(searchContext.searcher().getTaskExecutor(), is(notNullValue()));
                + "This limit can be set by changing the [search.max_open_scroll_context] setting.",
        OpenSearchRejectedExecutionException ex = expectThrows(
                    DerivedFieldType derivedFieldType = (DerivedFieldType) context.getQueryShardContext()
                );
            indexShard.shardId(),
            indexShard.shardId(),
        searchSourceBuilder.docValueField("one_field_too_much");
            -1,
        UpdatePitContextRequest updateRequest = new UpdatePitContextRequest(
                    1f,
        String index = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);
                        Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), clusterSetting)
        long nowInMillis = System.currentTimeMillis();
    }
    private static DirectoryReader apply(DirectoryReader directoryReader) throws IOException {
        // Set the index setting for mode
     */
            if (indexMode != null) {
        @Override
            1,
                        latch.countDown();
                    .cluster()
            indexShard.shardId(),
        try (ReaderContext reader = createReaderContext(indexService, indexShard)) {
                    1f,
                    clusterSetting,
        SearchService service = getInstanceFromNode(SearchService.class);
    /**
            new AliasFilter(null, Strings.EMPTY_ARRAY),
        );
            }
        Semaphore semaphore = new Semaphore(Integer.MAX_VALUE);
        assertSearchHits(searchResponse, "1");
        return new FilterDirectoryReader(directoryReader, new FilterDirectoryReader.SubReaderWrapper() {
                    latch.await();
            }
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
                    }
        public List<QuerySpec<?>> getQueries() {
            CountDownLatch latch = new CountDownLatch(1);
        assertThat(searchService.getActiveContexts(), equalTo(1));
            for (int i = 0; i < rounds; i++) {
    public void testCanMatchSearchAfterDescLessThanMin() throws IOException {
                    1,
                .indices()
        assertEquals(activeRefs, indexShard.store().refCount());
                    .aggregation(new TermsAggregationBuilder("test").userValueTypeHint(ValueType.STRING).minDocCount(1))
                .setTransientSettings(Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), clusterMode))
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        // Should be false without missing values
        List<ShardSearchContextId> contextIds = new ArrayList<>();
    }
            false
                    + maxScriptFields
     * @throws IOException
            .get();
    /**
                SearchException ex = expectThrows(
                -1,
                )
            -1,
                searchContext.evaluateRequestShouldUseConcurrentSearch();
    }
            try (DefaultSearchContext searchContext = service.createSearchContext(request, new TimeValue(System.currentTimeMillis()))) {
            { true, null, null, true },
 * The OpenSearch Contributors require contributions made to
     * Test for DESC order search_after query.
     * Min = 0L, Max = 9L, search_after = 0L
            searchSourceBuilder.scriptField(
        final SearchService service = getInstanceFromNode(SearchService.class);
        service.canMatch(req, ActionListener.wrap(r -> assertSame(Thread.currentThread(), currentThread), e -> fail("unexpected")));
                    new AliasFilter(new TermQueryBuilder("foo", "bar"), "alias"),
        try (
        assertTrue(
    public void testCanMatchSearchAfterAscGreaterThanMax() throws IOException {
        return Settings.builder().put("search.default_search_timeout", "5s").build();
                client().admin()
     * Min = 0L, Max = 9L, search_after = 10L
        client().execute(
            AliasFilter.EMPTY,
                    -1,
                .sort(new FieldSortBuilder(FieldSortBuilder.DOC_FIELD_NAME))
import org.opensearch.index.query.QueryShardContext;
                            ),
                    searchRequest,
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
            "Keep alive for request (1d) is too large. "
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
import org.opensearch.core.common.io.stream.StreamInput;
                } finally {
            super(
    public void testExpandSearchThrottled() {
     * Test canMatchSearchAfter with missing value, even if min/max is out of range
        );
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
                    1f,
        thread.start();
        }
            1,
        Boolean[] concurrentSearchStates = new Boolean[] { true, false };
            null,
                @Override
                            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), clusterSliceCount)
        CountDownLatch latch = new CountDownLatch(threads.length);
        PlainActionFuture<UpdatePitContextResponse> updateFuture = new PlainActionFuture<>();
        @Override
                );
    private ReaderContext createReaderContext(IndexService indexService, IndexShard indexShard) {
            // disabled using cluster setting, assert create context fails
                .get();
        protected void doXContent(XContentBuilder builder, Params params) {}
            new AliasFilter(null, Strings.EMPTY_ARRAY),
            threads[i] = new Thread(() -> {
            .setTransientSettings(Settings.builder().putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey()))
     * Expected result is canMatch = true
        ShardSearchRequest shardRequest = new ShardSearchRequest(
            }
                                        + "This limit can be set by changing the [search.max_open_scroll_context] setting."
        client().execute(
                .prepareUpdateSettings(index)
            randomBoolean(),
                    .prepareUpdateSettings()
        // Set the cluster setting for mode
            }
        }
                )
            .source(new SearchSourceBuilder().aggregation(AggregationBuilders.count("count").field("value")));
                }
            "pitId",
        }
        assertTrue(searchService.freeReaderContext(future.actionGet()));
                    .setTransientSettings(Settings.builder().putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey()))
        ).actionGet();
    }
        // Cleanup
                        // here we trigger some refreshes to ensure the IR go out of scope such that we hit ACE if we access a search
                + SearchService.MAX_PIT_KEEPALIVE_SETTING.get(Settings.EMPTY)
                @Override
import org.opensearch.search.sort.ScoreSortBuilder;
            searchService.createPitReaderContext(new ShardId(resolveIndex("index"), 0), TimeValue.timeValueHours(25), future);
            SearchService.canRewriteToMatchNone(
            // ok
        );
            null,
                    }
            @Override
            )
                assertNotNull(context);
            .prepareUpdateSettings()
        // adding this assert to showcase behavior difference
        }
            shardId,
                    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
    }
            -1,
                        .getSetting(index, IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey())
}
            indexShard.acquireSearcherSupplier(),
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                        randomBoolean()
            .cluster()
        private Scroll scroll;
            service.canMatch(
                            assertThat(
        assertEquals(0, totalStats.getFetchCurrent());
        final IndexShard indexShard = indexService.getShard(0);
    public void testCreateSearchContext() throws IOException {
            );
                .scroll(new Scroll(TimeValue.timeValueMinutes(1)));
            { true, false, "all", true },
        }
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
import org.opensearch.action.search.SearchRequest;
            nowInMillis,
            // Default concurrent search mode is auto, which enables concurrent segment search when aggregations are present.
            result
                        OriginalIndices.NONE,
                    .indices()
        assertTrue(
                    null,
                    throw new AssertionError(e);
    public void testSetSearchThrottled() {
            TimeValue.timeValueMinutes(between(1, 10)).millis(),
            new AliasFilter(null, Strings.EMPTY_ARRAY),
            indexShard.shardId(),
        assertEquals(
 * ownership. Elasticsearch licenses this file to you under
        client().admin().indices().prepareRefresh("test").get();
        IndexShard indexShard = indexService.getShard(0);
                    SearchException.class,
            assertThat(context.timeout(), equalTo(TimeValue.timeValueSeconds(seconds)));
        PlainActionFuture<FetchSearchResult> fetchFuture = new PlainActionFuture<>();
        Thread currentThread = Thread.currentThread();
        client().execute(
            client().admin()
        DeletePitResponse deletePitResponse = searchService.freeReaderContextsIfFound(contextIds);
                .setSettings(Settings.builder().putNull(IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MODE.getKey()))
                client().admin()
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, CustomScriptPlugin.DUMMY_SCRIPT, Collections.emptyMap())
            final int rounds = scaledRandomIntBetween(100, 1000);
            "Trying to create too many scroll contexts. Must be less than or equal to: ["
                    if ("throttled_threadpool_index".equals(context.indexShard().shardId().getIndex().getName())) {
                    mode,
        }
                new ShardSearchRequest(
            @Override
                    .putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey())
            1.0f,
import org.opensearch.search.sort.FieldSortBuilder;
    }
            });
     * track_total_hits = true,
import static org.mockito.Mockito.when;
            "pitId",
                assertEquals(
        long nowInMillis = System.currentTimeMillis();
        assertEquals(expectedPitCurrent, indexShard.searchStats().getTotal().getPitCurrent());
            nowInMillis,
        }
    public void testConcurrentSegmentSearchSliceCount() throws IOException {
        PlainActionFuture<SearchPhaseResult> result = new PlainActionFuture<>();
                new SearchSourceBuilder().query(new MatchNoneQueryBuilder()).aggregation(new GlobalAggregationBuilder("test"))
            if (clusterSetting == null) {
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
            .get();
        );
        SearchSourceBuilder[] sources = new SearchSourceBuilder[] {
                .setTransientSettings(
        assertTrue(service.getIndicesService().indexServiceSafe(index).getIndexSettings().isSearchThrottled());
        }
        );
        SearchPhaseResult queryResult = queryFuture.get();
                    .setTransientSettings(
                    null,
        SearchService searchService = getInstanceFromNode(SearchService.class);
            searchRequest,
            searchService.updatePitIdAndKeepAlive(updateRequest, updateFuture);
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { -1L });
                            service.freeReaderContext(searchPhaseResult.getContextId());
        String clusterMode = randomFrom(modeSettings);
     */
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
                .setSettings(Settings.builder().put(IndexSettings.ALLOW_DERIVED_FIELDS.getKey(), true))
     */
        service.freeReaderContext(queryResult.getContextId());
        ShardId shardId = new ShardId(indexService.index(), 0);
        assertEquals(0, numWrapInvocations.get());
            new InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.Request("frozen_index", "index.frozen", "true")
        PitSearchContextIdForNode pitSearchContextIdForNode = new PitSearchContextIdForNode(
    public void testDerivedFieldsSearch() throws IOException {
                // check concurrentSearchenabled based on mode and supportedAggregation is computed correctly
                assertAcked(client().admin().indices().prepareDelete("index"));
        stopped.set(true);
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
            indexShard.shardId(),
        indexService.getIndexSettings().isDerivedFieldAllowed();
    /**
        );
                } catch (Exception e) {
        SearchResponse searchResponse = client().prepareSearch("index").setSize(1).setScroll("1m").get();
                }
            1.0f,
                .get();
import org.opensearch.plugins.Plugin;
     * With above min/max and search_after, it should not match, but since
        {
                new SearchSourceBuilder().query(new MatchNoneQueryBuilder())
        return new ReaderContext(
                .indices()
            // disabled using index setting, assert create context fails
            // the search context should inherit the query timeout
            thread.join();
import org.opensearch.index.mapper.DerivedFieldType;
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        try (
                    .putNull(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey())
            1.0f,
                    -1,
            return Collections.singletonMap(DUMMY_SCRIPT, vars -> "dummy");
        createIndex("throttled_threadpool_index");
                + "] cluster level setting.",
            // Default concurrent search mode is auto, without aggregations, concurrent search will be disabled.
                // update cluster setting to flip the concurrent segment search state
        IndexService indexService = createIndex(index);
                            .execute(new ActionListener<IndexResponse>() {
        searchRequest.source(new SearchSourceBuilder().profile(false));
                    null
                .prepareUpdateSettings()
        searchRequest.source(new SearchSourceBuilder().timeout(TimeValue.timeValueSeconds(seconds)));
    public void testOpenReaderContext() {
        return true;
    public void testDeleteIndexWhileSearch() throws Exception {
     * index and cluster settings.
        CountDownLatch latch = new CountDownLatch(searchers.length);
        PlainActionFuture<ShardSearchContextId> future = new PlainActionFuture<>();
                );
        );
    }
    }
 * not use this file except in compliance with the License.
import java.util.concurrent.atomic.AtomicInteger;
        protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) {
                // Cleanup
                        intCursors.add(0);
                        Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), !concurrentSearchSetting)
                    assertThat(searchService.getActiveContexts(), equalTo(contextIds.size()));
        try (
        final SearchService service = getInstanceFromNode(SearchService.class);
                    } finally {
        IndexShard indexShard = indexService.getShard(0);
            this.scroll = new Scroll(TimeValue.timeValueMinutes(1));
            assertEquals(shardId, searchShardTarget.getShardId());
            InternalAggregation.ReduceContext reduceContext = reduceContextBuilder.forPartialReduction();
                    new AliasFilter(new TermQueryBuilder("foo", "bar"), "alias"),
 * under the License.
                    1f,
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                    if (randomBoolean()) {
        assertThat(searchService.getActiveContexts(), equalTo(1));
                )
            Boolean clusterSetting = (Boolean) scenario[0];
        }
            { null, null, clusterService.getClusterSettings().get(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING) },
        IndexService indexService = createIndex(index);
        assertEquals(1, service.getActiveContexts());
        );
        for (Thread searcher : searchers) {
                    searchRequest,
        );
                    try {
    public void testCanMatchSearchAfterWithMissing() throws IOException {
            assertEquals(
    }
    }
                        assertFalse(result.queryResult().isNull());
                                }
                    .prepareUpdateSettings(index)
            Strings.EMPTY_ARRAY
     * Expected result is canMatch = true
        client().clearScroll(clearScrollRequest);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertFalse(
        FetchSearchResult fetchResult = fetchFuture.get();
import org.opensearch.search.aggregations.support.ValueType;
                        // make sure we don't use the search threadpool
            searchRequest,
                latch.countDown();
                    } else {
import org.opensearch.action.search.SearchShardTask;
        ShardFetchRequest fetchRequest = new ShardFetchRequest(queryResult.getContextId(), docIds, null);
                        latch.countDown();
import org.apache.lucene.index.FilterDirectoryReader;
            null
            // dynamically enabled using index setting, assert derived field resolved fine
            OpenSearchRejectedExecutionException.class,
                    null
        final IndexShard indexShard = indexService.getShard(0);
        protected void doWriteTo(StreamOutput out) {}
            }
        final IndexShard indexShard = indexService.getShard(0);
            }
                    searchRequest,
                        assertThat(result, instanceOf(QuerySearchResult.class));
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
                    OriginalIndices.NONE,
            service.executeQueryPhase(shardRequest, randomBoolean(), task, new ActionListener<SearchPhaseResult>() {
                                    semaphore.release();
        // enable concurrent search
import org.opensearch.index.query.AbstractQueryBuilder;
        assertBusy(
            assertEquals(0, context.scriptFields().fields().size());
import org.opensearch.common.UUIDs;
            indexService.numberOfShards(),
        CountDownLatch latch = new CountDownLatch(1);
        expectThrows(
        service.freeAllScrollContexts();
            }
            SearchContext context = service.createContext(reader, request, null, randomBoolean())
        {
        Index index = resolveIndex("throttled_threadpool_index");
            "pitId",
            public SearchType searchType() {
            Strings.EMPTY_ARRAY
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
                .cluster()
    public void testExpandSearchFrozen() {
 * Modifications Copyright OpenSearch Contributors. See
    /**
        }
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
                    indexShard.shardId(),
    public void testConcurrentSegmentSearchSearchContext() throws IOException {
                    OriginalIndices.NONE,
                    client().admin()
            new AliasFilter(null, Strings.EMPTY_ARRAY),
        );
 */
            ).canMatch()
                        List<Integer> intCursors = new ArrayList(1);
                    .prepareUpdateSettings(index)
        List<Integer> docIds = new ArrayList<>();
        boolean concurrentSearchEnabled;
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
     * Expected result is canMatch = true
                    .prepareUpdateSettings(index)
        ShardSearchContextId shardSearchContextId = future.actionGet();
            }
            QueryShardContext queryShardContext = searchContext.getQueryShardContext();
            new ShardId(index, 0),
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
            @Override
        SearchRequest searchRequest = new SearchRequest();
        expectThrows(IndexNotFoundException.class, () -> client().admin().indices().prepareGetIndex().setIndices("index").get());
            null,
        }
            -1,
            return this;
        LinkedList<String> clearScrollIds = new LinkedList<>();
                    ShardSearchRequest request = new ShardSearchRequest(
        docIds.add(0);
                    indexShard.shardId(),
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
import org.opensearch.index.shard.IndexShard;
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
        }
import org.opensearch.indices.settings.InternalOrPrivateSettingsPlugin;
            ).canMatch()
     */
        SearchService searchService = getInstanceFromNode(SearchService.class);
        final int activeRefs = indexShard.store().refCount();
    public void testCanMatchSearchAfterDescEqualMin() throws IOException {
        // for completeness, we also randomly test the regular search path.
                    1,
                        assertNotNull(result.queryResult().topDocs());
        );
            client().admin()
            indexShard.shardId(),
            OriginalIndices.NONE,
            if (queryRewriteContext.convertToShardContext() != null) {
                .get();
            )
    public void validatePitStats(String index, long expectedPitCurrent, long expectedPitCount, int shardId) throws ExecutionException,
            System.currentTimeMillis()
                        indexShard.acquireSearcherSupplier(),
import java.util.concurrent.Semaphore;
import org.opensearch.action.search.SearchResponse;
                            throw new AssertionError(e);
                    .setTransientSettings(Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), mode))
        // the source cannot be rewritten to a match_none
                + SearchService.MAX_PIT_KEEPALIVE_SETTING.getKey()
                    null
    }
    public void testExecuteFetchPhaseWithoutProfiler() throws Exception {
                    1f,
            // cluster setting, index setting, cluster mode setting, concurrent search enabled?, concurrent search executor null?
            1f,
                    1,
 * KIND, either express or implied.  See the License for the
                }
            System.currentTimeMillis()
                        SearchPhaseResult searchPhaseResult = result.get();
        {
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
        createIndex("index");
        createIndex("index");
            { true, true, "auto", false },
            } else if (clusterMode != null) {
        assertThat(searchService.getAllPITReaderContexts().size(), equalTo(1));
                null
            searchSourceBuilder.docValueField("field" + i);
            client().prepareSearch("index").setSize(1).setScroll("1m").get();
     */
            });
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                        assertThat(result, instanceOf(QuerySearchResult.class));
        // Randomize both index and cluster settings
    public void testCanMatch() throws Exception {
                    } else {
        // adding the maximum allowed number of docvalue_fields to retrieve
                assertThat(searchContext.searcher().getTaskExecutor(), is(notNullValue()));
            "date",
        final IndexShard indexShard = indexService.getShard(0);
        final SearchService service = getInstanceFromNode(SearchService.class);
                    latch.countDown();
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        // assert true for reader context not found
                // verify concurrent search state in context
        assertThat(searchService.getAllPITReaderContexts().size(), equalTo(0));
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { 0L });
        service.executeQueryPhase(request, randomBoolean(), task, new ActionListener<SearchPhaseResult>() {
        ShardSearchRequest request = new ShardSearchRequest(
        final SearchService service = getInstanceFromNode(SearchService.class);
     */
                .get(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey())
    public static class FailOnRewriteQueryBuilder extends AbstractQueryBuilder<FailOnRewriteQueryBuilder> {
import org.opensearch.core.common.Strings;
        for (int i = 0; i < maxScriptFields; i++) {
                            result
                    OriginalIndices.NONE,
import static org.hamcrest.CoreMatchers.containsString;
            protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
        IndexService indexService = createIndex(index);
    public void testConcurrentSegmentSearchWithRandomizedModeSettings() throws IOException {
                    .prepareUpdateSettings()
            return null;
                .prepareUpdateSettings()
            service.executeQueryPhase(shardRequest, randomBoolean(), task, new ActionListener<SearchPhaseResult>() {
                        client().prepareSearch("test").setRequestCache(false).get();
            public CacheHelper getReaderCacheHelper() {
        numWrapInvocations.incrementAndGet();
                        1,
        assertEquals(0, totalStats.getScrollCurrent());
            shardId,
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        String index = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);
        assertFalse(
                new SearchSourceBuilder().query(new TermQueryBuilder("foo", "bar")).suggest(new SuggestBuilder())
        SearchService searchService = getInstanceFromNode(SearchService.class);
    }
                () -> service.createContext(reader, request, null, randomBoolean())
            }
import org.opensearch.search.builder.SearchSourceBuilder;
        try (DefaultSearchContext searchContext = service.createSearchContext(request, new TimeValue(System.currentTimeMillis()))) {
            new SearchSourceBuilder().query(new MatchNoneQueryBuilder())
            if (context.indexShard() == indexShard) {
        );
    public void testLookUpSearchContext() throws Exception {
    /**
                    .setTransientSettings(
                    .setSettings(Settings.builder().putNull(IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey()))
        createIndex("index");
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
                SearchContextAggregations mockAggregations = mock(SearchContextAggregations.class);
            client().admin()
                    null,
        final String index = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);
    }
                        .getAsBoolean(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), null)
     * Test for ASC order search_after query.
                                1,
            service.canMatch(
                    null
    }
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                while (contextIds.isEmpty() == false) {
        assertTrue(
        );
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(index));
     * While we have no NPE in DefaultContext constructor anymore, we still want to guard against it (or other failures) in the future to
                assertNull(context.getQueryShardContext().resolveDerivedFieldType("field" + 5));
        createIndex("index");
import org.opensearch.script.MockScriptEngine;
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
            { false, false, "none", false },
                        1.0f,
                    final ShardSearchContextId contextId = randomFrom(contextIds);
                    indexShard.shardId(),
    public static class ReaderWrapperCountPlugin extends Plugin {
        CountDownLatch latch = new CountDownLatch(1);
        Thread currentThread = Thread.currentThread();
            -1,
                .cluster()
            { false, true, "all", true },
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(3, 10);
                        .resolveDerivedFieldType("field" + i);
                    try {
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
        assertTrue(searchService.freeReaderContext(future.actionGet()));
import org.opensearch.index.IndexNotFoundException;
                            .setSource("field", "value")
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> {
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
                    // that's fine
                + "This limit can be set by changing the ["
        protected Query doToQuery(QueryShardContext context) {
            SearchResponse searchResponse = client().prepareSearch("index").setSize(1).setScroll("1m").get();
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, CustomScriptPlugin.DUMMY_SCRIPT, Collections.emptyMap())
                return in;
            -1,
            { true, false, "none", false },
            searchRequest,
                indexService,
            1,
                                null,
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
     * Test for DESC order search_after query.
            searchSourceBuilder.derivedField(
            { null, true, null, true },
import java.util.Locale;
            ).canMatch()
        assertEquals(0, service.getActiveContexts());
            }
        createIndex("index");
                "Trying to retrieve too many docvalue_fields. Must be less than or equal to: [100] but was [101]. "
                + "It must be less than ("
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
            ReaderContext reader = createReaderContext(indexService, indexShard);
import org.opensearch.search.collapse.CollapseBuilder;
                                reader,
    /**
                    OriginalIndices.NONE,
    }
            client().admin()
        createIndex("index");
                        assertFalse(result.queryResult().isNull());
                        );
    /**
            null,
        );
                new AliasFilter(null, Strings.EMPTY_ARRAY),
        CountDownLatch startGun = new CountDownLatch(1);
    }
                Settings.builder()
/*
                    .setTransientSettings(
     */
            .setTransientSettings(Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true))
        AtomicBoolean stopped = new AtomicBoolean(false);
    }
                        try {
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        @Override
        try (
        searchService.updatePitIdAndKeepAlive(updateRequest, updateFuture);
            1,
            SearchContext context = service.createContext(reader, request, null, randomBoolean())
    }
                                new AliasFilter(null, Strings.EMPTY_ARRAY),
        });
            );
    protected boolean resetNodeAfterTest() {
        );
                    1,
    }
        for (int i = 0; i < indexService.getIndexSettings().getMaxDocvalueFields(); i++) {
        }
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), true);
            thread.join();
            try (DefaultSearchContext searchContext = service.createSearchContext(request, new TimeValue(System.currentTimeMillis()))) {
        searchService.createPitReaderContext(new ShardId(resolveIndex("index"), 0), TimeValue.timeValueMinutes(between(1, 10)), future);
     * Test that the Search Context for concurrent segment search enabled is set correctly based on both
                searchContext.evaluateRequestShouldUseConcurrentSearch();
    }
    public void testExecuteFetchPhaseWithProfiler() throws Exception {
    public void testCreateReduceContext() {
    }
        client().prepareIndex("throttled_threadpool_index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
                        PlainActionFuture<SearchPhaseResult> result = new PlainActionFuture<>();
        ShardSearchRequest request = new ShardSearchRequest(
    /**
        }
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
                        indexShard.shardId(),
     * Min = 0L, Max = 9L, search_after = -1L
            ex.getMessage()
        validatePitStats("index", 1, 0, 0);
                "throttled_threadpool_index",
            TimeValue.timeValueHours(23).millis(),
            null
                        assertSame(Thread.currentThread(), currentThread);
        PlainActionFuture<SearchPhaseResult> queryFuture = new PlainActionFuture<>();
                "field" + i,
        final IndexShard indexShard = indexService.getShard(0);
        final SearchService service = getInstanceFromNode(SearchService.class);
    }
            5,
        final SearchService service = getInstanceFromNode(SearchService.class);
        });
            OriginalIndices.NONE,
                }
    }
            indexService.numberOfShards(),
        searchSourceBuilder.scriptField(
        searchRequest.source(searchSourceBuilder);
        assertNotNull("Profile results should contain fetch phase data", fetchResult.getProfileResults().getFetchProfileResult());
        public String getWriteableName() {
        ShardId shardId = new ShardId(indexService.index(), 0);
            1.0f,
     * Expected result is canMatch = false
import org.opensearch.action.search.UpdatePitContextRequest;
        }
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
        searchRequest.source(searchSourceBuilder);
                    } else {
            { null, null, null, false },
            // cluster setting, index setting, expected slice count
            clusterAlias,
/*
                new Script(ScriptType.INLINE, MockScriptEngine.NAME, CustomScriptPlugin.DUMMY_SCRIPT, Collections.emptyMap())
        IndexShard indexShard = indexService.getShard(0);
                    for (;;) {
        contextIds.add(pitSearchContextIdForNode);
            latch.await();
import org.opensearch.index.search.stats.SearchStats;
        assertTrue(updateResponse.getPitId().equalsIgnoreCase("pitId"));
                assertThat(searchContext.searcher().getTaskExecutor(), is(notNullValue()));
        return pluginList(
                    indexShard.shardId(),
                    )
import org.opensearch.search.internal.ReaderContext;
                    )
        searchRequest.source(searchSourceBuilder);
    public void testSearchWhileIndexDeleted() throws InterruptedException {
        searchService.createPitReaderContext(new ShardId(resolveIndex("index"), 0), TimeValue.timeValueMinutes(between(1, 10)), future);
            new SearchSourceBuilder().collapse(new CollapseBuilder("user"))
 */
                    contextIds.add(context.id());
            nowInMillis,
        }
            .scroll(new Scroll(TimeValue.timeValueMinutes(1)));
                        assertTrue(searchService.freeReaderContext(contextId));
        SearchResponse searchResponse = client().prepareSearch("throttled_threadpool_index")
            OriginalIndices.NONE,
        @Override
        SearchService service = getInstanceFromNode(SearchService.class);
                @Override
    }
                throw new NullPointerException("expected");
                OriginalIndices.NONE,
            new AliasFilter(null, Strings.EMPTY_ARRAY),
            OriginalIndices.NONE,
    }
        ).actionGet();
        {
                        assertTrue(
    public static class CustomScriptPlugin extends MockScriptPlugin {
            // the search context should inherit the default timeout
                    .get();
        searchRequest.source(new SearchSourceBuilder().profile(true));
        assertEquals(RestStatus.CREATED, response.status());
                    indexShard.shardId(),
     */
import org.apache.lucene.search.Query;
            String expectedIndexName = clusterAlias == null ? index : clusterAlias + ":" + index;
        deletePitResponse = searchService.freeReaderContextsIfFound(contextIds);
import org.junit.Before;
        // adding the maximum allowed number of script_fields to retrieve
        assertEquals(expectedPitCount, indexShard.searchStats().getTotal().getPitCount());
                    Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), concurrentSearchSetting)
        searchRequest.allowPartialSearchResults(randomBoolean());
                .setTransientSettings(Settings.builder().put(SearchService.CLUSTER_ALLOW_DERIVED_FIELD_SETTING.getKey(), false))
        final ShardSearchRequest requestWithDefaultTimeout = new ShardSearchRequest(
                new ShardSearchRequest(
                + SearchService.MAX_PIT_KEEPALIVE_SETTING.get(Settings.EMPTY)
            SearchContext context = service.createContext(reader, requestWithCustomTimeout, null, randomBoolean())
            service.canMatch(
        final IndexService indexService = createIndex(index);
            )
            new AliasFilter(null, Strings.EMPTY_ARRAY),
        final IndexShard indexShard = indexService.getShard(0);
        );
        @Override
import org.opensearch.action.search.PitSearchContextIdForNode;
        assertEquals(0, service.getActiveContexts());
            null
                    .prepareUpdateSettings()
        );
        for (Thread thread : threads) {
        );
                .cluster()
                        assertThat(Thread.currentThread().getName(), startsWith("opensearch[node_s_0][search_throttled]"));
                        ShardFetchRequest req = new ShardFetchRequest(searchPhaseResult.getContextId(), intCursors, null/* not a scroll */);
            { false, true, "none", false },
import org.opensearch.search.internal.AliasFilter;
                .indices()
        Thread[] threads = new Thread[randomIntBetween(2, 8)];
                .get();
            () -> client().admin()
                .setTransientSettings(Settings.builder().put(SearchService.CLUSTER_ALLOW_DERIVED_FIELD_SETTING.getKey(), true))
            AliasFilter.EMPTY,
                    searchRequest,
        assertNotNull("Profile results should be set when profiler is enabled", fetchResult.getProfileResults());
            assertThrows(OpenSearchException.class, () -> service.createContext(reader, request, null, randomBoolean()));
                assertThat(searchService.getActiveContexts(), equalTo(contextIds.size()));
            ).canMatch()
                        assertNotNull(result.queryResult().aggregations());
                    .get();
            // aggregationSupportsConcurrent determines if the present aggregation type supports concurrent segment search.
                    1f,
                public void onResponse(SearchPhaseResult result) {
    /**
        assertThat(searchResponse.getScrollId(), is(notNullValue()));
     * Expected result is canMatch = true
                    .get();
                .cluster()
                    .putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey())
                    .cluster()
        }
                .indices()
import java.util.function.Function;
                1f,
        List<Integer> docIds = new ArrayList<>();
        SearchRequest searchRequest = new SearchRequest();
            assertNotNull(context.getQueryShardContext().resolveDerivedFieldType("field"));
                            searchService.freeReaderContext((new ShardSearchContextId(contextId.getSessionId(), contextId.getId())))
        }
        @Override
                randomBoolean()
                @Override
import org.opensearch.search.sort.MinAndMax;
    }
        try (ReaderContext reader = createReaderContext(indexService, indexShard)) {
                assertEquals(
            IllegalArgumentException ex = expectThrows(
        );
                    indexShard.shardId(),
            indexModule.setReaderWrapper(service -> SearchServiceTests::apply);
        final SearchService service = getInstanceFromNode(SearchService.class);
    public void testDerivedFieldDisabled() throws IOException {
import org.opensearch.common.settings.SettingsException;
                    1,
                    -1,
import org.opensearch.index.shard.SearchOperationListener;
    public void testCollapseSearchAfterRejectsScoreAndDocSort() throws IOException {
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            assertThat(contextWithDefaultTimeout.timeout(), equalTo(TimeValue.timeValueSeconds(5)));
                .get();
        @Override
        final SearchService service = getInstanceFromNode(SearchService.class);
import org.opensearch.core.rest.RestStatus;
            shardId,
                    .cluster()
            SearchService.canRewriteToMatchNone(
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
            searchRequest,
                .searchAfter(new Object[] { 0 }),
        AtomicBoolean running = new AtomicBoolean(true);
                public void onFailure(Exception e) {
import java.util.Collections;
     * Expected result is canMatch = true
        SearchResponse searchResponse = client().prepareSearch("index").setSize(1).setScroll("1m").get();
            } else {
import org.opensearch.index.query.QueryBuilder;
                    indexShard.shardId(),
                .setSettings(Settings.builder().put(IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), indexMode))
                    .prepareUpdateSettings()
            assertNotNull(context);
                    throw ex;
        for (Integer[] sliceCounts : scenarios) {
    public void testPitContextMaxKeepAlive() {
        searchRequest.allowPartialSearchResults(randomBoolean());
                    expectThrows(
        SearchContextMissingException ex = expectThrows(SearchContextMissingException.class, () -> {
        try (ReaderContext reader = createReaderContext(indexService, indexShard)) {
                        }
            ).canMatch()
                        throw new AssertionError(exc);
import org.opensearch.core.xcontent.XContentBuilder;
        ).actionGet();
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { 9L });
            latch.await();
        SearchService searchService = getInstanceFromNode(SearchService.class);
    }
                    -1,
        assertFalse(
                                new ShardScrollRequestTest(indexShard.shardId()),
                        service.executeFetchPhase(req, new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()), listener);
            .get();
            searchers[i] = new Thread(() -> {
                }
        };
import org.opensearch.search.aggregations.AggregatorFactories;
                    .setSettings(Settings.builder().putNull(IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT.getKey()))
                        latch.countDown();
        }
        validatePitStats("index", 0, 1, 0);
            MockSearchService.TestPlugin.class
        assertFalse(service.getIndicesService().indexServiceSafe(index).getIndexSettings().isSearchThrottled());
            null
                        assertThat(Thread.currentThread().getName(), startsWith("opensearch[node_s_0][search]"));
     */
 *
                    )
                null
        );
            OriginalIndices.NONE,
                @Override
            for (SearchSourceBuilder source : sources) {
            IllegalArgumentException ex = expectThrows(
import org.opensearch.script.ScriptType;
            // dynamically enabled using cluster setting, assert derived field resolved fine
            assertEquals(clusterAlias, searchShardTarget.getClusterAlias());
                searchContext.evaluateRequestShouldUseConcurrentSearch();
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
            client().admin()
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
                    } catch (ExecutionException ex) {
            1,
                    1,
            1,
    public void testTimeout() throws IOException {
            AliasFilter.EMPTY,
        public FailOnRewriteQueryBuilder(StreamInput in) throws IOException {
                public void onFailure(Exception exc) {
import org.opensearch.action.index.IndexResponse;
                }
        createIndex("index");
        assertFalse(
                        assertNotSame(Thread.currentThread(), currentThread);
            @Override
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            assertThrows(OpenSearchException.class, () -> service.createContext(reader, request, null, randomBoolean()));
                () -> service.createContext(reader, request, null, randomBoolean())
        }
        } catch (Exception e) {
                }
                        assertNotNull(result.queryResult().aggregations());
        final ShardSearchRequest requestWithCustomTimeout = new ShardSearchRequest(
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { 10L });
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
    public void testConcurrentSegmentSearchIsSetOnceDuringContextCreation() throws IOException {
import static org.hamcrest.CoreMatchers.notNullValue;
        final int activeContexts = service.getActiveContexts();
            1,
                .setSettings(Settings.builder().put(IndexSettings.ALLOW_DERIVED_FIELDS.getKey(), false))
            1,
        ShardScrollRequestTest(ShardId shardId) {
        final IndexShard indexShard = indexService.getShard(0);
            new InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.Request(
        final ShardScrollRequestTest request = new ShardScrollRequestTest(indexShard.shardId());
                } catch (SearchContextMissingException ex) {
     * The same is used throughout the context object lifetime even if cluster setting changes before the request completion.
                client().admin()
        });
    }
        searchRequest.allowPartialSearchResults(randomBoolean());
            searchRequest,
            service.executeQueryPhase(shardRequest, randomBoolean(), task, new ActionListener<SearchPhaseResult>() {
                                -1,
                        assertThat(Thread.currentThread().getName(), startsWith("opensearch[node_s_0][search]"));
                    null,
    @Before
        startGun.await();
            context = service.createContext(reader, request, null, randomBoolean());
        assertEquals(0, totalStats.getFetchCurrent());
        createIndex("index");
        }
                        request,
import org.opensearch.action.search.SearchContextIdForNode;
        PlainActionFuture<ShardSearchContextId> future = new PlainActionFuture<>();
                    .setTransientSettings(
        SearchService service = getInstanceFromNode(SearchService.class);
            1,
                    -1,
import org.opensearch.script.Script;
        );
            null
    }
            .setTransientSettings(
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                    .prepareUpdateSettings()
    }
        String index = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);
                    .cluster()
        createIndex("throttled_threadpool_index");
                indexShard.acquireSearcherSupplier(),
                    if ("throttled_threadpool_index".equals(context.indexShard().shardId().getIndex().getName())) {
                        latch.countDown();
                    final ReaderContext context = searchService.createAndPutReaderContext(
                        throw new AssertionError(e);
            context = service.createContext(reader, request, null, randomBoolean());
                    try {
        UpdatePitContextRequest updateRequest = new UpdatePitContextRequest(
                                equalTo(
        );
                client().admin()
import org.opensearch.search.query.QuerySearchResult;
        IndexShard indexShard = indexService.getShard(0);
                .searchAfter(new Object[] { 1.0f }) };
        searchRequest.indices("alias").source(new SearchSourceBuilder().query(new TermQueryBuilder("id", "1")));
                    1,
 * this work for additional information regarding copyright
            NullPointerException e = expectThrows(
            OriginalIndices.NONE,
        public void onIndexModule(IndexModule indexModule) {
 * license agreements. See the NOTICE file distributed with
        String indexMode = randomFrom(modeSettings);
 *
    }
                .prepareUpdateSettings()
    }
                "throttled_threadpool_index",
        client().prepareIndex("frozen_index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
    private static class ShardScrollRequestTest extends ShardSearchRequest {
        }
            try (DefaultSearchContext searchContext = service.createSearchContext(request, new TimeValue(System.currentTimeMillis()))) {
                @Override
import static org.mockito.Mockito.mock;
        ) {
        SearchService service = getInstanceFromNode(SearchService.class);
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), false);
        createIndex("frozen_index");
            if (indexSliceCount != null) {
        assertThat(searchService.getAllPITReaderContexts().size(), equalTo(1));
        final Thread thread = new Thread() {
                    .cluster()
                            searchService.createAndPutReaderContext(
                        throw ((RuntimeException) ex.getCause());
        }
                    null,
                        .getMetadata()
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
            try (DefaultSearchContext searchContext = service.createSearchContext(request, new TimeValue(System.currentTimeMillis()))) {
                            // have to free context since this test does not remove the index from IndicesService.
        );
        ClusterService clusterService = getInstanceFromNode(ClusterService.class);
        assertThat(searchService.getActiveContexts(), equalTo(0));
            { null, false, null, false },
            });
            public LeafReader wrap(LeafReader reader) {
                        assertNotSame(Thread.currentThread(), currentThread);
                indexShard,
    /**
        assertTrue(deletePitResponse.getDeletePitResults().get(0).isSuccessful());
import org.opensearch.action.search.DeletePitResponse;
            });
        searchRequest.allowPartialSearchResults(randomBoolean());
import static org.hamcrest.CoreMatchers.is;
        );
 * compatible open source license.
                        try {
        PlainActionFuture<ShardSearchContextId> future = new PlainActionFuture<>();
                    .prepareUpdateSettings()
            -1,
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
            client().admin()
        assertThat(searchService.getActiveContexts(), equalTo(1));
                                @Override
import java.util.LinkedList;
        client().execute(
        ShardSearchContextId id = future.actionGet();
import org.opensearch.index.engine.Engine;
        assertThat(searchService.getAllPITReaderContexts().size(), equalTo(1));
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true).scroll(new Scroll(TimeValue.timeValueMinutes(1)));
     * Min = 0L, Max = 9L, search_after = 9L
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                new ShardSearchRequest(
            return false;
    public void testOpenScrollContextsConcurrently() throws Exception {
                        assertTrue(result.queryResult().isNull());
            }
                        .prepareGetSettings(index)
            )
            { false, true, null, true },
        for (int i = 0; i < threads.length; i++) {
        List<PitSearchContextIdForNode> contextIds = new ArrayList<>();
        final IndexResponse response = client().prepareIndex("index").setId("1").setSource("id", "1").get();
        }
                );
import org.opensearch.search.suggest.SuggestBuilder;
            indexShard.shardId(),
        primarySort.order(SortOrder.ASC);
 * GitHub history for details.
                    );
import org.opensearch.search.aggregations.AggregationBuilders;
            indexShard.shardId(),
            indexShard.shardId(),
                1.0f,
     */
            Strings.EMPTY_ARRAY
                () -> service.createContext(reader, request, null, randomBoolean())
                }
                            true,
import org.opensearch.action.OriginalIndices;
    }
        createIndex("index");
                    assertEquals("date", derivedFieldType.getType());
import org.opensearch.action.search.SearchType;
                        Settings.builder().putNull(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey())
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                public void onResponse(SearchPhaseResult result) {
        primarySort.order(SortOrder.ASC);
            "1",
                    .prepareUpdateSettings()
            String mode = (String) scenario[2];
        final IndexShard indexShard = indexService.getShard(0);
            concurrentSearchEnabled = aggregationSupportsConcurrent;
                        null,
        primarySort.order(SortOrder.DESC);
            null,
            }));
    }
        clearScrollRequest.setScrollIds(clearScrollIds);
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        assertEquals(0, totalStats.getScrollCurrent());
                            new ShardSearchRequest(
            CustomScriptPlugin.class,
                    }
     * Expected result is canMatch = true
        );
                    null
    public void testClearOnStop() {
                )
                        service.executeQueryPhase(
        service.doClose(); // this kills the keep-alive reaper we have to reset the node after this test
        service.executeFetchPhase(fetchRequest, task, fetchFuture);
            } else {
        IndexService indexService = createIndex(index);
            Strings.EMPTY_ARRAY
            SearchContext context = service.createContext(reader, request, null, randomBoolean());
            service.canMatch(
                client().admin()
        searchService.createPitReaderContext(new ShardId(resolveIndex("index"), 0), TimeValue.timeValueMinutes(between(1, 10)), future);
                new ShardSearchRequest(
     * Min = 0L, Max = 9L, search_after = 7L
        // the source can match and can be rewritten to a match_none, but not the alias filter
                .setTransientSettings(Settings.builder().putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey()))
                );
        }
        @Override
            if (randomInt(4) == 0) clearScrollIds.addLast(searchResponse.getScrollId());
            { false, false, null, false },
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.OpenSearchException;
        {
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
        );
            try (SearchContext context = service.createContext(reader, request, null, randomBoolean())) {
                    searchRequest,
        SearchStats.Stats totalStats = indexShard.searchStats().getTotal();
                shardId,
                    -1,
import org.opensearch.action.search.UpdatePitContextResponse;
                    latch.countDown();
        assertHitCount(client().prepareSearch().setIndicesOptions(IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED).get(), 1L);
                        assertThat(Thread.currentThread().getName(), startsWith("opensearch[node_s_0][search_throttled]"));
    }
        } else {
        // the scrolls are not explicitly freed, but should all be gone when the test finished.
        assertHitCount(client().prepareSearch().setIndicesOptions(IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED).get(), 1L);
            InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.INSTANCE,
                .get();
        String index = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);
    public void testUpdatePitId() throws ExecutionException, InterruptedException {
            SearchService.canRewriteToMatchNone(
    }
            client().admin()
                .get();
                }
            searchRequest,
            null,
                .getState()
public class SearchServiceTests extends OpenSearchSingleNodeTestCase {
        }
                    + "] but was ["
 */
            ReaderContext reader = createReaderContext(indexService, indexShard);
            indexService.numberOfShards(),
import org.apache.lucene.index.LeafReader;
        primarySort.order(SortOrder.ASC);
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
        numWrapInvocations = new AtomicInteger(0);
            return singletonList(new QuerySpec<>("fail_on_rewrite_query", FailOnRewriteQueryBuilder::new, parseContext -> {
            .setSize(1)
    @Override
                client().admin()
                    null,
                        .getState()
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
            new AliasFilter(null, Strings.EMPTY_ARRAY),
            @Override
        Object[][] scenarios = {
            randomNonNegativeLong(),
import org.opensearch.core.common.io.stream.StreamOutput;
                    .suggest(new SuggestBuilder())
            latch.await();
        assertTrue(updateResponse.getKeepAlive() == updateRequest.getKeepAlive());
            );
                new ShardId(resolveIndex("index"), 0),
            searcher.join();
        searchRequest.source(new SearchSourceBuilder());
        searchRequest.indices("alias").source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));
                .cluster()
                public void onFetchPhase(SearchContext context, long tookInNanos) {
            .cluster()
import org.opensearch.search.aggregations.SearchContextAggregations;
        });
            1,
        searchRequest.source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));
     *  If concurrent search enabled -
        );
                public void onFailure(Exception exc) {
        createIndex("test");
                                1.0f,
        service.setOnPutContext(context -> {
                    OriginalIndices.NONE,
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            clusterAlias,
import org.opensearch.common.settings.Setting;
                    -1,
    public void testCanMatchSearchAfterAscLessThanMax() throws IOException {
        assertFalse(
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(false);
                throw new UnsupportedOperationException("No query parser for this plugin");
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        assertEquals(1, service.getActiveContexts());
    }
            () -> assertEquals("should have 2 store refs (IndexService + InternalEngine)", 2, indexService.getShard(0).store().refCount())
    }
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.DELETED;
                        () -> searchService.freeReaderContext(new ShardSearchContextId(UUIDs.randomBase64UUID(), contextId.getId()))
        IndexShard indexShard = indexService.getShard(0);
        @Override
                        .transientSettings()
            client().admin()
        }
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
            threads[i].setName("opensearch[node_s_0][search]");
        }
            )
            new AliasFilter(null, Strings.EMPTY_ARRAY),
            id,
            searchRequest,
        public FailOnRewriteQueryBuilder() {}
    public void testMatchNoDocsEmptyResponse() throws InterruptedException {
            indexShard.shardId(),
                    }
            }
                        .cluster()
        );
            id,
        SearchShardTask task = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());
                )
                                }
            1f,
            new AliasFilter(null, Strings.EMPTY_ARRAY),
import org.opensearch.core.index.Index;
                    }
            () -> service.createAndPutReaderContext(
            nowInMillis,
            future.actionGet();
            ReaderWrapperCountPlugin.class,
        createIndex("index");
            concurrentSearchEnabled = false;
    @Override
            service.canMatch(
            new AliasFilter(null, Strings.EMPTY_ARRAY),
                        null
                        assertThat(result, instanceOf(QuerySearchResult.class));
                    assertEquals("reader_context is already closed can't increment refCount current count [0]", ex.getMessage());
            searchRequest,
                    null,
                @Override
                client().admin()
            -1,
            assertSame(searchShardTarget, searchContext.fetchResult().getSearchShardTarget());
                    .indices()
        createIndex("index");
                )
                assertThat(
                new AliasFilter(null, Strings.EMPTY_ARRAY),
            -1,
            searchRequest,
            "field" + 0,
        service.freeReaderContext(queryResult.getContextId());
        @Override
            -1,
                        .indices()
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
            OriginalIndices.NONE,
    }
        protected int doHashCode() {
                -1,
     * Min = 0L, Max = 9L, search_after = -1L
                    OriginalIndices.NONE,
        }
import org.opensearch.threadpool.ThreadPool;
                    indexShard.shardId(),
        assertTrue(
        long nowInMillis = System.currentTimeMillis();
                startGun.countDown();
        ShardSearchRequest request = new ShardSearchRequest(
            ex.getMessage()
        ) {
        PlainActionFuture<ShardSearchContextId> future = new PlainActionFuture<>();
            threads[i].start();
     * avoid leaking searchers.
    }
        );
        client().admin()
        final SearchService service = getInstanceFromNode(SearchService.class);
    }
                        listener.get();
            TimeValue.timeValueHours(25).millis(),
        static final String DUMMY_SCRIPT = "dummyScript";
                    1f,
        try (ReaderContext reader = createReaderContext(indexService, indexShard)) {
                new Script(ScriptType.INLINE, MockScriptEngine.NAME, CustomScriptPlugin.DUMMY_SCRIPT, Collections.emptyMap())
                            });
        }) {
                    .get();
            null
        assertTrue(
    public void testDeletePitReaderContext() throws ExecutionException, InterruptedException {
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
                IndexSettings.INDEX_SEARCH_THROTTLED.getKey(),
                while (stopped.get() == false) {
import org.opensearch.index.query.QueryRewriteContext;
                .cluster()
                try {
            );
                new ShardSearchRequest(
                        .getState()
     * test that getting more than the allowed number of script_fields throws an exception
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            null
            System.currentTimeMillis()
     */
            shardRequest.canReturnNullResponseIfMatchNoDocs(true);
        assertThat(searchService.getAllPITReaderContexts().size(), equalTo(0));
        }
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
        assertTrue(SearchService.canRewriteToMatchNone(new SearchSourceBuilder().query(new TermQueryBuilder("foo", "bar"))));
                when(mockAggregations.factories()).thenReturn(mock(AggregatorFactories.class));
                        .transientSettings()
        for (Object[] scenario : scenarios) {
            .cluster()
        }
        );
                    searchRequest,
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
            null
    public void testMaxOpenScrollContexts() throws Exception {
        client().admin()
            )
            )
                                e.getMessage(),
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
     * test that getting more than the allowed number of docvalue_fields throws an exception
                        assertThat(Thread.currentThread().getName(), startsWith("opensearch[node_s_0][search]"));
                .indices()
        createIndex("index");
            SettingsException.class,
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
                .setTransientSettings(Settings.builder().putNull(SearchService.CLUSTER_ALLOW_DERIVED_FIELD_SETTING.getKey()))
            { false, false, "auto", false },
        SettingsException se = expectThrows(
            .cluster()
import static org.hamcrest.CoreMatchers.instanceOf;
            CountDownLatch latch = new CountDownLatch(1);
                    .aggregation(new TermsAggregationBuilder("test").userValueTypeHint(ValueType.STRING).minDocCount(1))
                        .get()
        final IndexShard indexShard = indexService.getShard(0);
 * this file be licensed under the Apache-2.0 license or a
            try {
            );
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { -1L });
                assertEquals(targetSliceCount.intValue(), searchContext.getTargetMaxSliceCount());
            InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.INSTANCE,
        assertTrue(deletePitResponse.getDeletePitResults().get(0).isSuccessful());
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        createIndex("index");
                searchContext.aggregations(mockAggregations);
                        PlainActionFuture<FetchSearchResult> listener = new PlainActionFuture<>();
            // however concurrentSearchExecutor will not be null
            AliasFilter.EMPTY,
                    .cluster()
        SearchService service = getInstanceFromNode(SearchService.class);
    public void testClearOnClose() {
import org.opensearch.action.support.PlainActionFuture;
            InternalAggregation.ReduceContext reduceContext = reduceContextBuilder.forFinalReduction();
            null,
            PlainActionFuture<UpdatePitContextResponse> updateFuture = new PlainActionFuture<>();
            OriginalIndices.NONE,
        client().prepareIndex("throttled_threadpool_index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
            Integer indexSliceCount = sliceCounts[1];
        createIndex("index");
                    null
        assertFalse(
            } else {
     * Test for DESC order search_after query.
            { null, 3, 3 },
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), true);
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
            try (SearchContext context = service.createContext(reader, request, null, randomBoolean())) {
                    if (randomBoolean()) {
            service.canMatch(
        PlainActionFuture<ShardSearchContextId> future = new PlainActionFuture<>();
                new SearchSourceBuilder().query(new MatchNoneQueryBuilder())
        validatePitStats("index", 0, 1, 0);
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), false);
                    try {
                    .setSettings(Settings.builder().put(IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), indexSetting))
    }
    }
            indexShard,
        final SearchService service = getInstanceFromNode(SearchService.class);
        SearchService searchService = getInstanceFromNode(SearchService.class);
        }
        // we still make sure can match is executed on the network thread
                return directoryReader.getReaderCacheHelper();
        service.executeFetchPhase(fetchRequest, task, fetchFuture);
                searchContext.evaluateRequestShouldUseConcurrentSearch();
        @Override
                .setSettings(Settings.builder().put(IndexSettings.INDEX_SEARCH_THROTTLED.getKey(), false))
        final ShardSearchRequest request = new ShardSearchRequest(
        assertTrue(searchService.freeReaderContext(future.actionGet()));
                ex.getMessage()
                    -1,
        assertEquals(1, service.getActiveContexts());
        };
        assertNull("Profile results should be null when profiler is disabled", fetchResult.getProfileResults());
                        // context in a non-sane way.
            } else {
            if (indexMode != null) {
                    } catch (Exception ignored) {
        assertThat(searchService.getAllPITReaderContexts().size(), equalTo(1));
            assertNotNull(context.getQueryShardContext().resolveDerivedFieldType("field"));
            }
                    assertThat(context.id().getId(), equalTo((long) (i + 1)));
                "field" + i,
            );
                client().admin()
                    null
                    1,
        createIndex("index");
            clusterAlias,
            }
            }
/*
            clusterAlias,
                + "). "
                    assertEquals(1, numWrapInvocations.get());
        );
            { null, null, "all", true },
                    null,
                        throw new AssertionError(exc);
     */
 * Licensed to Elasticsearch under one or more contributor
            CountDownLatch latch = new CountDownLatch(1);
                    } finally {
            1.0f,
            assertEquals(expectedIndexName, queryShardContext.getFullyQualifiedIndex().getName());
                        .get(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), null)
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true).scroll(new Scroll(TimeValue.timeValueMinutes(1)));
        assertEquals(0, service.getActiveContexts());
        createIndex("index");
    public void testCanRewriteToMatchNone() {
        ShardSearchContextId id = future.actionGet();
        SearchService service = getInstanceFromNode(SearchService.class);
            );
        assertFalse(searchService.freeReaderContext(future.actionGet()));
    }
            }
                try {
                client().admin()
                        } catch (OpenSearchRejectedExecutionException e) {
        // Open all possible scrolls, clear some of them, then open more until the limit is reached
        );
            super(in);
            1,
                MultiBucketConsumerService.TooManyBucketsException.class,
        try {
        SearchService searchService = getInstanceFromNode(SearchService.class);
                    assertEquals("field" + i, derivedFieldType.name());
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
import org.opensearch.index.IndexModule;
import org.opensearch.search.aggregations.InternalAggregation;
            assertSame(searchShardTarget, searchContext.queryResult().getSearchShardTarget());
            1f,
            searchSourceBuilder.scriptField(
        try (ReaderContext reader = createReaderContext(indexService, indexService.getShard(shardId.id()))) {
                    OriginalIndices.NONE,
                                useScroll ? scrollSearchRequest : searchRequest,
                concurrentSearchEnabled = indexMode.equals("all");
                "false"
            InternalOrPrivateSettingsPlugin.class,
                assertEquals(concurrentSearchEnabled, searchContext.shouldUseConcurrentSearch());
import org.apache.lucene.store.AlreadyClosedException;
                + "It must be less than ("
        for (int i = 0; i < SearchService.MAX_OPEN_SCROLL_CONTEXT.get(Settings.EMPTY); i++) {
                        assertNotNull(result.queryResult().topDocs());
            { 4, 3, 3 }, };
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
                    try {
        int numContexts = randomIntBetween(1, 10);
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
            searchRequest,
                try {
                }
                "throttled_threadpool_index",
                IndexSettings.INDEX_SEARCH_THROTTLED.getKey(),
import org.opensearch.index.IndexService;
                    .get();
            "field",
package org.opensearch.search;
            new ShardSearchRequest(
                                    "Trying to create too many scroll contexts. Must be less than or equal to: "
        String index = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);
                when(mockAggregations.factories().allFactoriesSupportConcurrentSearch()).thenReturn(aggregationSupportsConcurrent);
            .prepareUpdateSettings()
    public void testCanMatchSearchAfterAscEqualMax() throws IOException {
            OriginalIndices.NONE,
import org.apache.lucene.index.DirectoryReader;
            SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
                    )
        SearchService service = getInstanceFromNode(SearchService.class);
    }
import java.util.Map;
        SearchPhaseResult queryResult = queryFuture.get();
 *
                } finally {
        SearchService service = getInstanceFromNode(SearchService.class);
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
            null
                ex.getMessage()
        int numDocs = randomIntBetween(1, 20);
                .getMetadata()
                }
                new ShardSearchRequest(
            } finally {
                    } finally {
        createIndex("index");
                )
        SearchShardTask task = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());
    }
    @Override
                concurrentSearchEnabled = clusterMode.equals("all");
     * Min = 0L, Max = 9L, search_after = 10L
        }
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
                public void onResponse(SearchPhaseResult result) {
                    null
            public void run() {
                        assertThat(ex.getCause(), instanceOf(RuntimeException.class));
                + SearchService.MAX_PIT_KEEPALIVE_SETTING.getKey()
        assertThat(searchService.getActiveContexts(), equalTo(1));
            new AliasFilter(null, Strings.EMPTY_ARRAY),
    }
                    .get();
            // Adding cases with mode set to "none"
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            1.0f,
        );
            @Override
            OriginalIndices.NONE,
            () -> client().prepareSearch("index").setQuery(new FailOnRewriteQueryBuilder()).get()
        } finally {
            new ShardSearchContextId(UUIDs.randomBase64UUID(), randomNonNegativeLong()),
            SearchShardTarget searchShardTarget = searchContext.shardTarget();
            );
                        );
            });
    }
import org.opensearch.action.search.ClearScrollRequest;
        assertTrue(updateResponse.getCreationTime() == updateRequest.getCreationTime());
                // verify executor state in searcher
        assertEquals(activeContexts, service.getActiveContexts());
        for (int i = 0; i < numDocs; i++) {
            }
            searchers[i].start();
import org.opensearch.search.internal.SearchContext;
    public void testCreateSearchContextFailure() throws Exception {
            1f,
            AliasFilter.EMPTY,
            )
        /*
        service.executeQueryPhase(shardSearchRequest, randomBoolean(), task, queryFuture);
    }
                .prepareState()
        });
        searchRequest.source(new SearchSourceBuilder().query(new MatchNoneQueryBuilder()));
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                }
                )
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { 10L });
     */
        primarySort.order(SortOrder.DESC);
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
        );
                for (int i = 0; i < numContexts; i++) {
                    assertFalse(searchService.freeReaderContext(contextId));
                ShardSearchRequest request = new ShardSearchRequest(
        assertEquals(
                                public void onResponse(IndexResponse indexResponse) {
    public void testClearIndexDelete() {
                searchContext.evaluateRequestShouldUseConcurrentSearch();
            try (DefaultSearchContext searchContext = service.createSearchContext(request, new TimeValue(System.currentTimeMillis()))) {
                    OriginalIndices.NONE,
            indexShard.shardId(),
        }
                        latch.countDown();
                    .get();
        if (clusterMode == null) {
            new SearchSourceBuilder().collapse(new CollapseBuilder("user"))
    }
        }
                    .get();
        };
                IllegalArgumentException.class,
 * SPDX-License-Identifier: Apache-2.0
            InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.INSTANCE,
            1f,
        searchRequest.allowPartialSearchResults(randomBoolean());
import static org.hamcrest.CoreMatchers.startsWith;
 * You may obtain a copy of the License at
                                indexShard,
        UpdatePitContextResponse updateResponse = updateFuture.actionGet();
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
                + "]. "
            result.get();
        searchService.freeAllScrollContexts();
                null,
            expectThrows(
                                @Override
                            semaphore.acquire();
    }
        // Needs to busily assert because Engine#refreshNeeded can increase the refCount.
            }
                SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true).source(source);
                    1f,
        protected boolean doEquals(FailOnRewriteQueryBuilder other) {
        ShardSearchRequest shardSearchRequest = new ShardSearchRequest(
        IndexShard indexShard = indexService.getShard(0);
import org.opensearch.search.fetch.FetchSearchResult;
                    } finally {
            }
                IllegalArgumentException.class,
        PlainActionFuture<FetchSearchResult> fetchFuture = new PlainActionFuture<>();
                // induce an artificial NPE
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
    public void testUpdatePitIdWithInvalidReaderId() {
            { true, false, null, false },
        }
    }
        searchSourceBuilder.size(0);
        assertHitCount(client().prepareSearch().get(), 1L);
        {
        ShardId shardId = new ShardId(indexService.index(), 0);
        // we add a search action listener in a plugin above to assert that this is actually used
     * Test for ASC order search_after query.
            { false, null, null, false },
                    assertThat(searchService.getActiveContexts(), equalTo(contextIds.size()));
        );
                @Override
import java.util.concurrent.atomic.AtomicBoolean;
                        client().prepareIndex("index")
            }
                .get();
                OriginalIndices.NONE,
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
                        .getMetadata()
            client().admin()
        ShardSearchRequest req = new ShardSearchRequest(
                                indexService,
                new SearchSourceBuilder().query(new MatchNoneQueryBuilder())
            OriginalIndices.NONE,
        );
        assertThat(searchResponse.getScrollId(), is(notNullValue()));
                    )
        SearchRequest searchRequest = new SearchRequest();
        // Should be true with missing values
            { 4, null, 4 },
            searchRequest,
        assertSettingDeprecationsAndWarnings(new Setting[] { IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING });
        }
                    try {
    public void testCloseSearchContextOnRewriteException() {
                    client().admin()
import org.opensearch.search.fetch.ShardFetchRequest;
            ).canMatch()
            null
        final SearchService service = getInstanceFromNode(SearchService.class);
        for (int i = 0; i < searchers.length; i++) {
            // expected value null will pick up default value from settings
                1,
        ).actionGet();
import java.io.IOException;
                }
                "anotherScriptField",
            OriginalIndices.NONE,
                                )
        SearchResponse searchResponse = client().prepareSearch("index").setSize(1).setScroll("1m").get();
            assertEquals(
                    );
        primarySort.order(SortOrder.DESC);
                .prepareUpdateSettings(index)
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, 1000), true);
        final ShardSearchRequest request = new ShardSearchRequest(
                    () -> service.createContext(reader, request, null, randomBoolean())
            searchRequest,
                    .get();
                latch.countDown();
        // if refresh happens while checking the exception, the subsequent reference count might not match, so we switch it off
        assertEquals(
                    containsString("collapse field and sort field must be the same when use `collapse` in conjunction with `search_after`")
                    }
                    }
        client().admin()
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(3, 10);
            indexService,
            ex.getMessage()
        IndexService indexService = createIndex(index);

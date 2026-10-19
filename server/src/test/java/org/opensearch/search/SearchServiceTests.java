import org.opensearch.index.query.MatchAllQueryBuilder;  
        createIndex("index");
                        );  
                                }
        try (ReaderContext reader = createReaderContext(indexService, indexShard)) {  
            client().admin()
import org.opensearch.index.query.AbstractQueryBuilder;
    }
                new Script(ScriptType.INLINE, MockScriptEngine.NAME, CustomScriptPlugin.DUMMY_SCRIPT, Collections.emptyMap())
    public void testCanMatchSearchAfterAscGreaterThanMax() throws IOException {
        try (ReaderContext reader = createReaderContext(indexService, indexShard)) {  
        );
            );
                "throttled_threadpool_index",
                        ShardFetchRequest req = new ShardFetchRequest(searchPhaseResult.getContextId(), intCursors, null/* not a scroll */);
            { null, null, "auto", false },
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);  
            () -> service.createAndPutReaderContext(
                // induce an artificial NPE
        assertEquals(0, totalStats.getFetchCurrent());
    }
    }  
    }
        long nowInMillis = System.currentTimeMillis();
        );
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));  
            )
                        service.executeQueryPhase(  
            new SearchContextIdForNode(null, "node1", shardSearchContextId)  
            id,
    /**  
        });  
                        randomBoolean()  
    public void testOpenScrollContextsConcurrently() throws Exception {  
                .prepareGetSettings(index)  
        final ShardSearchRequest request = new ShardSearchRequest(
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
                    } finally {  
        try {
            1f,
        searchService.createPitReaderContext(new ShardId(resolveIndex("index"), 0), TimeValue.timeValueMinutes(between(1, 10)), future);
        assertFalse(  
        for (int i = 0; i < 5; i++) {
                .get()
        validatePitStats("index", 1, 0, 0);  
            assertSame(searchShardTarget, searchContext.queryResult().getSearchShardTarget());
                client().admin()
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, 1000), true);
                .setTransientSettings(
        validatePitStats("index", 0, 1, 0);
                    -1,  
                    try {  
        SettingsException se = expectThrows(
                }
        assertHitCount(client().prepareSearch().get(), 0L);
            searchRequest,  
            service.canMatch(  
                    .setTransientSettings(Settings.builder().putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey()))
import java.io.IOException;
        ShardSearchRequest request = new ShardSearchRequest(  
            new ShardSearchRequest(
        assertThat(searchService.getAllPITReaderContexts().size(), equalTo(1));
        final int maxScrollContexts = SearchService.MAX_OPEN_SCROLL_CONTEXT.get(Settings.EMPTY);  
                .get();  
        );  
                IllegalArgumentException.class,
                NullPointerException.class,
                        null,
                            );  
        SearchService searchService = getInstanceFromNode(SearchService.class);
                        assertNotNull(result.queryResult().aggregations());
        final ShardSearchRequest requestWithCustomTimeout = new ShardSearchRequest(  
            { true, false, "all", true },
import org.opensearch.index.query.QueryBuilder;
                // check concurrentSearchenabled based on mode and supportedAggregation is computed correctly  
            service.canMatch(
    private ReaderContext createReaderContext(IndexService indexService, IndexShard indexShard) {
        }
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), true);  
                "throttled_threadpool_index",
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> {
    /**
            OriginalIndices.NONE,
        try (ReaderContext reader = createReaderContext(indexService, indexShard)) {
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                }
        {
        );  
    }  
            indexService.numberOfShards(),  
        primarySort.order(SortOrder.DESC);
                    .get();  
                new SearchSourceBuilder().query(new MatchNoneQueryBuilder())  
            1,  
        createIndex("frozen_index");
                        indexShard.shardId(),
        assertEquals(0, service.getActiveContexts());
            service.executeQueryPhase(shardRequest, randomBoolean(), task, new ActionListener<SearchPhaseResult>() {
        // the scrolls are not explicitly freed, but should all be gone when the test finished.  
                    latch.countDown();  
                .setSettings(Settings.builder().putNull(IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MODE.getKey()))
                assertEquals(concurrentSearchEnabled, searchContext.shouldUseConcurrentSearch());  
    protected boolean resetNodeAfterTest() {
                    -1,
    }
        assertTrue(searchService.freeReaderContext(future.actionGet()));
            OriginalIndices.NONE,  
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(3, 10);
        SearchResponse searchResponse = client().prepareSearch("index").setSize(1).setScroll("1m").get();
            { false, true, "auto", false } };
            new SearchSourceBuilder().query(new MatchNoneQueryBuilder())
            try (DefaultSearchContext searchContext = service.createSearchContext(request, new TimeValue(System.currentTimeMillis()))) {  
                        assertThat(Thread.currentThread().getName(), startsWith("opensearch[node_s_0][search]"));
            if (indexMode != null) {
            )
        );  
        final SearchService service = getInstanceFromNode(SearchService.class);  
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
            for (int i = 0; i < rounds; i++) {
import org.opensearch.action.search.UpdatePitContextRequest;  
        ShardId shardId = new ShardId(indexService.index(), 0);
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();  
            OriginalIndices.NONE,
        }
    public void testCreateSearchContext() throws IOException {
            { true, false, "none", false },  
 * software distributed under the License is distributed on an
    /**
        }
    public void testOpenReaderContext() {
                    if (randomBoolean()) {
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
                .prepareUpdateSettings(index)
    }
 */
                );
            }
                        assertThat(result, instanceOf(QuerySearchResult.class));
                        assertThat(Thread.currentThread().getName(), startsWith("opensearch[node_s_0][search]"));
        );
        // we still make sure can match is executed on the network thread
    }
            shardId,
    }
            new AliasFilter(null, Strings.EMPTY_ARRAY),
    }
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));  
                    .cluster()  
                    OriginalIndices.NONE,
                }  
                    null,
     * Test for DESC order search_after query with track_total_hits=true.
            clusterAlias,
            }  
     * Expected result is canMatch = true
            running.set(false);
    }
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));  
                .setTransientSettings(Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), clusterMode))
                }
            searchRequest,
                new ShardSearchRequest(  
        SearchService service = getInstanceFromNode(SearchService.class);
                }
     */  
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), true);
            1.0f,
                    OriginalIndices.NONE,
        UpdatePitContextRequest updateRequest = new UpdatePitContextRequest(
                .prepareUpdateSettings()
            -1,
     * test that getting more than the allowed number of docvalue_fields throws an exception  
    public void testDeleteIndexWhileSearch() throws Exception {
        );  
        assertEquals(0, numWrapInvocations.get());  
            searchRequest,
                    }  
                1,
import java.util.function.Function;  
        SearchService service = getInstanceFromNode(SearchService.class);
import org.opensearch.core.common.Strings;  
            null,  
    public static class CustomScriptPlugin extends MockScriptPlugin {  
                () -> service.createContext(reader, request, null, randomBoolean())
            try (DefaultSearchContext searchContext = service.createSearchContext(request, new TimeValue(System.currentTimeMillis()))) {  
        public List<QuerySpec<?>> getQueries() {
                    }
                throw new UnsupportedOperationException("No query parser for this plugin");  
                startGun.countDown();
        SearchResponse searchResponse = client().prepareSearch("index").setSize(1).setScroll("1m").get();
                    .get();
                .get()
        }
        @Override
                    new AliasFilter(new TermQueryBuilder("foo", "bar"), "alias"),
                            return;  
        SearchStats.Stats totalStats = indexShard.searchStats().getTotal();
                        }
import org.opensearch.action.search.PitSearchContextIdForNode;
            );
            searchRequest,  
        assertTrue(deletePitResponse.getDeletePitResults().get(0).isSuccessful());
                    .cluster()
     * Min = 0L, Max = 9L, search_after = 10L
                                @Override  
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
    public void testCanMatchSearchAfterAscEqualMax() throws IOException {  
            null,  
                                null
import static org.mockito.Mockito.when;  
                    );  
            service.canMatch(
            assertNotNull(context.getQueryShardContext().resolveDerivedFieldType("field"));
            5,
            null  
     */
        }
        createIndex("index");
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(3, 10);  
                )
            CountDownLatch latch = new CountDownLatch(1);  
            assertSame(searchShardTarget, searchContext.dfsResult().getSearchShardTarget());  
            OriginalIndices.NONE,
import org.opensearch.action.search.SearchType;
                    }
        final IndexShard indexShard = indexService.getShard(0);  
     * index and cluster settings.
            SearchShardTarget searchShardTarget = searchContext.shardTarget();
        SearchRequest searchRequest = new SearchRequest();
        ShardId shardId = new ShardId(indexService.index(), 0);
        assertTrue(searchService.freeReaderContext(future.actionGet()));
        for (Thread searcher : searchers) {  
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));  
    }
                                equalTo(
                .searchAfter(new Object[] { 0 }),
            ReaderContext reader = createReaderContext(indexService, indexShard);
        }  
            concurrentSearchEnabled = aggregationSupportsConcurrent;
                    } else {  
    }
        );
     * Min = 0L, Max = 9L, search_after = -1L
        final Thread thread = new Thread() {
        createIndex("throttled_threadpool_index");
                    );
        client().admin()
            clusterAlias,
            service.canMatch(
                client().admin()
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
    public void testDerivedFieldsSearch() throws IOException {
                @Override  
        final IndexShard indexShard = indexService.getShard(0);
        final int activeContexts = service.getActiveContexts();  
        );  
        SearchService service = getInstanceFromNode(SearchService.class);
            InternalAggregation.ReduceContext reduceContext = reduceContextBuilder.forPartialReduction();
                    .cluster()  
        // assert true for reader context not found  
        client().admin()
        String index = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);
        createIndex("index");
    @Override
        final IndexShard indexShard = indexService.getShard(0);
            indexService.numberOfShards(),
    }
import java.util.concurrent.CountDownLatch;
        );  
                    OriginalIndices.NONE,  
        }  
import org.opensearch.core.index.shard.ShardId;
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
import org.opensearch.index.query.QueryShardContext;
                    null
            latch.await();  
                .indices()
                throw new NullPointerException("expected");  
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
            );
    }
            null
import org.opensearch.action.search.SearchPhaseExecutionException;
            new AliasFilter(null, Strings.EMPTY_ARRAY),  
        service.setOnPutContext(context -> {
                    indexShard.shardId(),
            OriginalIndices.NONE,
                    null,
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
            searchRequest,
            1,  
                latch.countDown();
                + SearchService.MAX_PIT_KEEPALIVE_SETTING.get(Settings.EMPTY)  
                    .cluster()  
                        new AliasFilter(null, Strings.EMPTY_ARRAY),
     * Expected result is canMatch = true  
            searcher.join();
            threads[i].start();
                        -1,  
        });
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), false);
            0,
                    indexShard.shardId(),  
                                @Override
        assertEquals(
                assertEquals(concurrentSearchEnabled, searchContext.shouldUseConcurrentSearch());
                    try {
        int numDocs = randomIntBetween(1, 20);  
            client().admin()
        createIndex("index");
                new SearchSourceBuilder().query(new TermQueryBuilder("foo", "bar")).suggest(new SuggestBuilder())
                    if ("throttled_threadpool_index".equals(context.indexShard().shardId().getIndex().getName())) {
        latch.await();  
import org.opensearch.index.IndexSettings;
        searchRequest.source(searchSourceBuilder);
            for (SearchSourceBuilder source : sources) {
        primarySort.order(SortOrder.ASC);  
            { true, true, null, true },  
            if (queryRewriteContext.convertToShardContext() != null) {  
            client().admin()
        clearScrollRequest.setScrollIds(clearScrollIds);
        LinkedList<String> clearScrollIds = new LinkedList<>();
                    searchRequest,
                return directoryReader.getReaderCacheHelper();
            }
        indexService.getIndexSettings().isDerivedFieldAllowed();
        client().execute(
            SearchRequest scrollSearchRequest = new SearchRequest().allowPartialSearchResults(true)
            String expectedIndexName = clusterAlias == null ? index : clusterAlias + ":" + index;
        createIndex("index");
            { true, true, "none", false },
                    .get();
        public Scroll scroll() {
                new SearchRequest().allowPartialSearchResults(true),  
    public void testConcurrentSegmentSearchSliceCount() throws IOException {
        assertAcked(client().admin().indices().prepareDelete("index"));
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();  
                        assertThat(Thread.currentThread().getName(), startsWith("opensearch[node_s_0][search]"));
        for (Integer[] sliceCounts : scenarios) {
                }  
            service.executeQueryPhase(shardRequest, randomBoolean(), task, new ActionListener<SearchPhaseResult>() {
                    1,
            1.0f,
    public void testCanMatchSearchAfterAscLessThanMax() throws IOException {
                    .indices()
            searchRequest,
                        () -> searchService.freeReaderContext(new ShardSearchContextId(UUIDs.randomBase64UUID(), contextId.getId()))
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
        assertBusy(
        Index index = resolveIndex("throttled_threadpool_index");
        searchSourceBuilder.derivedField(
            ReaderContext reader = createReaderContext(indexService, indexShard);  
            AliasFilter.EMPTY,
        assertThat(searchService.getActiveContexts(), equalTo(maxScrollContexts));
    @Override  
    private static DirectoryReader apply(DirectoryReader directoryReader) throws IOException {
                .get();  
            ),  
        }
import org.opensearch.index.query.MatchNoneQueryBuilder;
            { null, null, null, false },
                ex.getMessage()  
        );
        service.executeQueryPhase(request, randomBoolean(), task, new ActionListener<SearchPhaseResult>() {
                                new ShardScrollRequestTest(indexShard.shardId()),
import java.util.concurrent.atomic.AtomicInteger;
                "true"  
import org.opensearch.search.aggregations.AggregatorFactories;  
        service.executeQueryPhase(
            } else {  
                    assertEquals("field" + i, derivedFieldType.name());  
import org.opensearch.action.search.SearchContextIdForNode;  
                Settings.builder()  
    @Override  
            1.0f,
                // verify that concurrent segment search is still set to same expected value for the context
     * test that getting more than the allowed number of script_fields throws an exception
                        latch.countDown();
                new ShardSearchRequest(
 * not use this file except in compliance with the License.
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(3, 10);
        // for completeness, we also randomly test the regular search path.
        final SearchService service = getInstanceFromNode(SearchService.class);
        }  
        });
            ).canMatch()
            reduceContext.consumeBucketsAndMaybeBreak(MultiBucketConsumerService.DEFAULT_MAX_BUCKETS + 1);  
        @Override
            AliasFilter.EMPTY,
            "field",
import org.apache.lucene.store.AlreadyClosedException;
            @Override  
        final String index = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);
        List<ShardSearchContextId> contextIds = new ArrayList<>();
                        intCursors.add(0);  
        ShardId shardId = new ShardId(indexService.index(), 0);  
            IllegalArgumentException ex = expectThrows(  
                + "] cluster level setting.",  
            assertEquals(
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
            }));
        client().admin()
                } catch (IllegalStateException ex) {  
                    + "] but was ["
                )
                    .get();  
            );
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            // Cleanup
            new SearchSourceBuilder().collapse(new CollapseBuilder("user"))
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));  
            @Override  
                    .indices()  
            ReaderWrapperCountPlugin.class,
        assertTrue(service.getIndicesService().indexServiceSafe(index).getIndexSettings().isSearchThrottled());  
                .getState()  
            }
            searchRequest,
                                e.getMessage(),  
            )  
                1,  
            1.0f,
        );
        for (int i = 0; i < indexService.getIndexSettings().getMaxDocvalueFields(); i++) {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                1.0f,
        searchService.createPitReaderContext(new ShardId(resolveIndex("index"), 0), TimeValue.timeValueMinutes(between(1, 10)), future);
                client().admin()
        ShardSearchContextId id = future.actionGet();
        // Should be true with missing values  
        createIndex("index");  
import org.opensearch.core.rest.RestStatus;  
                    searchRequest,
        try (ReaderContext reader = createReaderContext(indexService, indexShard)) {
                }
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { 10L });
            assertEquals("expected", e.getMessage());
            searchSourceBuilder.derivedField(
                    .setSettings(
        });
                    client().admin()  
import org.opensearch.cluster.service.ClusterService;
        try (
        long nowInMillis = System.currentTimeMillis();
                    null,
        service.freeReaderContext(queryResult.getContextId());
    }
        assertTrue(searchService.freeReaderContext(future.actionGet()));  
                client().admin()
                    if ("throttled_threadpool_index".equals(context.indexShard().shardId().getIndex().getName())) {
        final IndexResponse response = client().prepareIndex("index").setId("1").setSource("id", "1").get();
                -1,
    private void resetCount() {
                )
            1.0f,
        if (clusterMode == null) {
                @Override  
            indexShard.shardId(),
        expectThrows(IndexNotFoundException.class, () -> client().admin().indices().prepareGetIndex().setIndices("index").get());  
        for (int i = 0; i < numDocs; i++) {
        final IndexShard indexShard = indexService.getShard(0);
            service.executeQueryPhase(shardRequest, randomBoolean(), task, new ActionListener<SearchPhaseResult>() {
                    );
                            .execute(new ActionListener<IndexResponse>() {  
                    )
import org.opensearch.index.mapper.DerivedFieldType;
                public void onResponse(SearchPhaseResult result) {
                );
                } catch (AlreadyClosedException ex) {
                .getSetting(index, IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MODE.getKey())
     */  
import org.opensearch.script.MockScriptPlugin;
            nowInMillis,
        AtomicBoolean running = new AtomicBoolean(true);  
                    .setTransientSettings(Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), mode))
                                indexShard.shardId(),
        long nowInMillis = System.currentTimeMillis();
                    if (randomBoolean()) {
            new ShardId(index, 0),
                                true
                        .getSetting(index, IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey())  
            SearchContext context = service.createContext(reader, requestWithCustomTimeout, null, randomBoolean())
                        .prepareState()
                    1,  
    }
                }  
            searchers[i].start();
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
            { false, false, null, false },
        final SearchService service = getInstanceFromNode(SearchService.class);
            } finally {
        client().execute(
            return this.scroll;
                    .get();  
                    try {
    public void testCollapseSearchAfterRejectsScoreAndDocSort() throws IOException {  
                .get();
        for (int i = 0; i < maxScriptFields; i++) {
                shardId,
            }
        );  
        client().admin()  
    }
                .get();  
                public void onFailure(Exception e) {
     * track_total_hits = true,
            new AliasFilter(null, Strings.EMPTY_ARRAY),
        assertFalse(
    }
        searchRequest.source(new SearchSourceBuilder().query(new MatchNoneQueryBuilder()));
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
        final IndexShard indexShard = indexService.getShard(0);
            // Adding cases with mode set to "auto"
        );
        final SearchService service = getInstanceFromNode(SearchService.class);
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
     * Test that the Search Context for concurrent segment search enabled is set correctly based on both
                // update cluster setting to flip the concurrent segment search state
import org.opensearch.common.unit.TimeValue;
            searchRequest,
            shardId,  
                .cluster()  
                        assertNotNull(result.queryResult().topDocs());
            // nothing disabled, derived field resolved fine
                    1f,  
                    assertThat(searchService.getActiveContexts(), equalTo(contextIds.size()));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final SearchService service = getInstanceFromNode(SearchService.class);
                    throw new AssertionError(e);
                + "] cluster level setting.",
                    )
                + SearchService.MAX_PIT_KEEPALIVE_SETTING.get(Settings.EMPTY)
                searchContext.evaluateRequestShouldUseConcurrentSearch();  
import org.opensearch.plugins.Plugin;
        }  
            return 0;  
        assertNotNull("Profile results should be set when profiler is enabled", fetchResult.getProfileResults());
            SearchService.canRewriteToMatchNone(  
            SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
        // adding this assert to showcase behavior difference  
        );  
        createIndex("throttled_threadpool_index");  
                                new AliasFilter(null, Strings.EMPTY_ARRAY),  
     *       pick index level slice count setting if index level setting is set  
                useScroll ? scrollSearchRequest : searchRequest,
        }  
            future.actionGet();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
            searchers[i] = new Thread(() -> {  
                new ShardSearchRequest(  
            if (context.indexShard() == indexShard) {  
        }  
        );
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true).scroll(new Scroll(TimeValue.timeValueMinutes(1)));
     */
import org.opensearch.action.index.IndexResponse;
     * Min = 0L, Max = 9L, search_after = -1L
        try (  
            new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()),
                    )  
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();  
                    assertThat(searchService.getActiveContexts(), equalTo(contextIds.size()));
            if (randomInt(4) == 0) clearScrollIds.addLast(searchResponse.getScrollId());  
import org.opensearch.threadpool.ThreadPool;
        }  
            "field" + 0,
            client().prepareIndex("test").setSource("f", "v").get();
import org.opensearch.search.sort.FieldSortBuilder;
                    try {
            .get();
            .cluster()  
                        assertThat(Thread.currentThread().getName(), startsWith("opensearch[node_s_0][search_throttled]"));  
                public void onFailure(Exception exc) {  
            "Trying to create too many scroll contexts. Must be less than or equal to: ["
            null
                    .suggest(new SuggestBuilder())
            1.0f,  
        final ShardSearchRequest requestWithDefaultTimeout = new ShardSearchRequest(
                    + "This limit can be set by changing the [index.max_docvalue_fields_search] index level setting.",
     * While we have no NPE in DefaultContext constructor anymore, we still want to guard against it (or other failures) in the future to  
                .setSettings(Settings.builder().put(IndexSettings.ALLOW_DERIVED_FIELDS.getKey(), false))
        final IndexShard indexShard = indexService.getShard(0);
                assertEquals(concurrentSearchSetting, searchContext.shouldUseConcurrentSearch());  
            service.canMatch(
                    .get();
        final SearchService service = getInstanceFromNode(SearchService.class);
            );  
            1.0f,
import static org.mockito.Mockito.mock;
        assertThat(searchResponse.getScrollId(), is(notNullValue()));  
            .cluster()
        } catch (Exception e) {
        ShardSearchContextId id = new ShardSearchContextId("session", 9);
            client().admin()
                    null  
            @Override
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
                    searchRequest,
                    OriginalIndices.NONE,
                + SearchService.MAX_PIT_KEEPALIVE_SETTING.getKey()
        future.actionGet();
        assertFalse(service.getIndicesService().indexServiceSafe(index).getIndexSettings().isSearchThrottled());
                    indexShard.shardId(),  
        stopped.set(true);
        primarySort.order(SortOrder.DESC);  
            super(
        createIndex("index");  
        return pluginList(
            shardId,  
    public void testLookUpSearchContext() throws Exception {
            Integer targetSliceCount = sliceCounts[2];
                        assertNotSame(Thread.currentThread(), currentThread);  
     * Min = 0L, Max = 9L, search_after = 10L
     * Expected result is canMatch = true  
                    } catch (ExecutionException ex) {  
            String mode = (String) scenario[2];  
            indexService.numberOfShards(),
                    OriginalIndices.NONE,
                new ShardSearchRequest(
                for (int i = 0; i < numContexts; i++) {
            }
                    1f,  
            }
            if (indexSliceCount != null) {
                                        + "This limit can be set by changing the [search.max_open_scroll_context] setting."  
                            true,  
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { -1L });  
            client().admin()
        InterruptedException {  
            service.canMatch(  
 * this work for additional information regarding copyright
        SearchService searchService = getInstanceFromNode(SearchService.class);
import org.opensearch.index.query.QueryRewriteContext;  
        latch.await();
            { null, false, null, false },
        ClusterService clusterService = getInstanceFromNode(ClusterService.class);  
     */  
        PlainActionFuture<ShardSearchContextId> future = new PlainActionFuture<>();
    }  
        // Should be false without missing values  
                                public void onFailure(Exception e) {
                        assertFalse(result.queryResult().isNull());  
        ShardId shardId = new ShardId(indexService.index(), 0);  
                "false"
                    .putNull(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey())
        };
                return reader;  
                    } finally {  
        assertEquals(  
            indexService.numberOfShards(),
        UpdatePitContextResponse updateResponse = updateFuture.actionGet();  
                    indexShard.shardId(),
                        client().prepareIndex("index")  
        @Override  
        searchRequest.allowPartialSearchResults(randomBoolean());
                    .prepareUpdateSettings()
            .setIndicesOptions(IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED)  
            nowInMillis,  
                    ShardSearchRequest request = new ShardSearchRequest(
        long nowInMillis = System.currentTimeMillis();
        ShardSearchRequest request = new ShardSearchRequest(
                        List<Integer> intCursors = new ArrayList(1);
            .get();  
                    1f,  
            assertSame(searchShardTarget, searchContext.fetchResult().getSearchShardTarget());
     * Test for ASC order search_after query.  
import org.opensearch.search.sort.ScoreSortBuilder;
    public void testMaxScriptFieldsSearch() throws IOException {
            searchService.updatePitIdAndKeepAlive(updateRequest, updateFuture);  
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { -1L });
        service.executeFetchPhase(fetchRequest, task, fetchFuture);  
                    } else {
        String indexMode = randomFrom(modeSettings);
import org.opensearch.index.shard.SearchOperationListener;
                for (int i = 0; i < 5; i++) {  
                IndexSettings.INDEX_SEARCH_THROTTLED.getKey(),  
                try {
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        SearchShardTask task = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());
    }
            try (DefaultSearchContext searchContext = service.createSearchContext(request, new TimeValue(System.currentTimeMillis()))) {
                return in;
                            .setRefreshPolicy(randomFrom(WriteRequest.RefreshPolicy.values()))
     * Test for DESC order search_after query.
                    clusterSetting,
        searchService.updatePitIdAndKeepAlive(updateRequest, updateFuture);
            searchRequest,  
        // Cleanup
        }
                        assertTrue(
            id,
            )
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        assertEquals(0, totalStats.getQueryCurrent());
        ShardSearchRequest shardSearchRequest = new ShardSearchRequest(
                    .aggregation(new TermsAggregationBuilder("test").userValueTypeHint(ValueType.STRING).minDocCount(1))
            1,
        );
    }  
                @Override
            .source(new SearchSourceBuilder().aggregation(AggregationBuilders.count("count").field("value")));  
                while (stopped.get() == false) {
        return Settings.builder().put("search.default_search_timeout", "5s").build();
                    .cluster()  
            .prepareUpdateSettings()
                        .getMetadata()
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
                    -1,  
            ex.getMessage()
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> {
                () -> service.createContext(reader, request, null, randomBoolean())  
                    // that's fine  
        SearchService searchService = getInstanceFromNode(SearchService.class);
                    containsString("collapse field and sort field must be the same when use `collapse` in conjunction with `search_after`")
    public void testIgnoreScriptfieldIfSizeZero() throws IOException {
            semaphore.acquire(Integer.MAX_VALUE);  
                    assertEquals("date", derivedFieldType.getType());
        });
        );  
        contextIds.add(pitSearchContextIdForNode);
import java.util.Collection;
                        null
            boolean aggregationSupportsConcurrent = randomBoolean();
        try (ReaderContext reader = createReaderContext(indexService, indexService.getShard(shardId.id()))) {  
        }
        searchRequest.source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));
        long nowInMillis = System.currentTimeMillis();
                    throw ex;
 * The OpenSearch Contributors require contributions made to  
        final ShardId shardId = new ShardId(indexService.index(), 0);
        client().execute(
        }
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
                        .transientSettings()  
        searchRequest.source(new SearchSourceBuilder().profile(true));
            client().admin()
            clusterAlias,
        assertEquals(0, service.getActiveContexts());  
        searchRequest.source(searchSourceBuilder);
                .sort(new FieldSortBuilder(FieldSortBuilder.DOC_FIELD_NAME))  
                    null  
            SearchContext context = service.createContext(reader, request, null, randomBoolean())
        SearchResponse searchResponse = client().prepareSearch("index").setSize(1).setScroll("1m").get();
            1,  
            Strings.EMPTY_ARRAY
            { false, true, "none", false },
            client().admin()
        }  
                } catch (SearchContextMissingException ex) {
            ).canMatch()
        createIndex("index");
            indexService.numberOfShards(),  
import org.opensearch.search.fetch.FetchSearchResult;  
        ).actionGet();
                new AliasFilter(null, Strings.EMPTY_ARRAY),  
            new InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.Request(
 * compatible open source license.
        searchService.freeAllScrollContexts();
                    ex.getMessage(),
import org.opensearch.index.IndexService;
            1,
                    -1,
        searchRequest.source(  
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
        protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) {
    public void testDeletePitReaderContext() throws ExecutionException, InterruptedException {  
                        // here we trigger some refreshes to ensure the IR go out of scope such that we hit ACE if we access a search
import org.opensearch.core.action.ActionListener;
        );  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                new SearchSourceBuilder().query(new MatchNoneQueryBuilder())  
                        assertThat(ex.getCause(), instanceOf(RuntimeException.class));
        assertEquals(0, totalStats.getFetchCurrent());
                    throw new AssertionError(e);
        service.canMatch(req, ActionListener.wrap(r -> assertSame(Thread.currentThread(), currentThread), e -> fail("unexpected")));
                    service.afterIndexRemoved(indexService.index(), indexService.getIndexSettings(), DELETED);  
            });
                public void onResponse(SearchPhaseResult result) {
            System.currentTimeMillis()
                () -> service.createContext(reader, request, null, randomBoolean())
                            new ShardSearchRequest(
        }  
     * Min = 0L, Max = 9L, search_after = -1L  
        @Override  
            1,
                concurrentSearchEnabled = clusterMode.equals("all");
            searchSourceBuilder.scriptField(
            }
            @Override
    }  
        ).actionGet();  
        primarySort.missing("_last");
            // update mode  
            "date",  
        assertEquals("can not update private setting [index.search.throttled]; this setting is managed by OpenSearch", se.getMessage());
            });
import org.opensearch.core.xcontent.XContentBuilder;
        }
            "pitId",
        assertEquals(0, totalStats.getScrollCurrent());  
        );
        protected Query doToQuery(QueryShardContext context) {
            -1,  
        Thread currentThread = Thread.currentThread();  
                    null  
            indexShard.shardId(),  
            .cluster()  
        Boolean[] concurrentSearchStates = new Boolean[] { true, false };
                .setTransientSettings(Settings.builder().putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey()))
            { false, true, "all", true },
                .indices()  
                assertNotNull(context);  
        assertThat(searchService.getAllPITReaderContexts().size(), equalTo(1));
        );
    }  
        );  
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
            OriginalIndices.NONE,
                + "This limit can be set by changing the ["
            public LeafReader wrap(LeafReader reader) {
            );  
                    latch.countDown();  
    public void testClearOnStop() {
                }
                .cluster()  
            CustomScriptPlugin.class,
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), false);  
        assertNull("Profile results should be null when profiler is disabled", fetchResult.getProfileResults());  
            .setSize(1)
            assertThat(context.timeout(), equalTo(TimeValue.timeValueSeconds(seconds)));
     * Test for ASC order search_after query.
                            service.freeReaderContext(searchPhaseResult.getContextId());
                            .setSource("field", "value")
            { false, null, null, false },
import org.opensearch.search.sort.MinAndMax;  
     */
                    -1,
        createIndex("index");
                new ShardSearchRequest(
            return null;
                        Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), !concurrentSearchSetting)  
            () -> assertEquals("should have 2 store refs (IndexService + InternalEngine)", 2, indexService.getShard(0).store().refCount())  
            Strings.EMPTY_ARRAY
            return Collections.singletonMap(DUMMY_SCRIPT, vars -> "dummy");  
     */
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);  
        try (ReaderContext reader = createReaderContext(indexService, indexShard)) {
        assertEquals(0, service.getActiveContexts());
                }  
            { 4, null, 4 },
                        // context in a non-sane way.  
        searchRequest.allowPartialSearchResults(randomBoolean());
        indexService.getIndexSettings().isDerivedFieldAllowed();  
        assertSearchHits(searchResponse, "1");  
                    try {
    public void testExecuteFetchPhaseWithoutProfiler() throws Exception {
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
                        indexShard.acquireSearcherSupplier(),
                        client().prepareSearch("test").setRequestCache(false).get();
            { false, true, null, true },  
     * Expected result is canMatch = true
package org.opensearch.search;
            result  
            indexShard.shardId(),
            OriginalIndices.NONE,
                assertEquals(  
                .get();
                        .get(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), null)  
            new InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.Request("frozen_index", "index.frozen", "true")
    private static class ShardScrollRequestTest extends ShardSearchRequest {  
                    .get();
            assertEquals(shardId, searchShardTarget.getShardId());
        return new ReaderContext(
        final long seconds = randomIntBetween(6, 10);
                    final ShardSearchContextId contextId = randomFrom(contextIds);
        );
        PlainActionFuture<UpdatePitContextResponse> updateFuture = new PlainActionFuture<>();
                client().admin()
            service.canMatch(
                        .getAsBoolean(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), null)
 * GitHub history for details.
        @Override  
            OriginalIndices.NONE,  
                    } finally {
                when(mockAggregations.factories()).thenReturn(mock(AggregatorFactories.class));
        public FailOnRewriteQueryBuilder(StreamInput in) throws IOException {
                    1,
     * Test for DESC order search_after query.  
        // adding the maximum allowed number of script_fields to retrieve
                        assertNotNull(result.queryResult().aggregations());
        );  
                    null,
            indexShard.shardId(),
                "date",
    }
                    + "]. This limit can be set by changing the [index.max_script_fields] index level setting.",  
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), false);
            { false, false, "none", false },
                searchContext.evaluateRequestShouldUseConcurrentSearch();
                "anotherScriptField",  
import org.opensearch.action.support.IndicesOptions;
                        throw new AssertionError(e);  
    public void testExecuteFetchPhaseWithProfiler() throws Exception {
                    assertThat(context.id().getId(), equalTo((long) (i + 1)));
                .scroll(new Scroll(TimeValue.timeValueMinutes(1)));  
            thread.join();
                MultiBucketConsumerService.TooManyBucketsException.class,  
/*  
        static final String DUMMY_SCRIPT = "dummyScript";
import org.opensearch.index.query.TermQueryBuilder;
                + "This limit can be set by changing the ["
    /**
                assertNotNull(context);
            )
        }  
import org.opensearch.search.internal.ReaderContext;  
            { true, true, "auto", false },
                .cluster()  
                    .prepareUpdateSettings(index)
                public void onResponse(SearchPhaseResult result) {
        ) {  
        assertEquals(0, service.getActiveContexts());
                    new AliasFilter(new TermQueryBuilder("foo", "bar"), "alias"),  
            } else if (clusterMode != null) {  
            @Override  
import org.opensearch.search.query.QuerySearchResult;
            if (clusterSetting == null) {  
            shardRequest.source().query(new MatchNoneQueryBuilder());
    public void testDerivedFieldDisabled() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        {
                        assertFalse(result.queryResult().isNull());  
                        SearchPhaseResult searchPhaseResult = result.get();
            if (clusterSliceCount != null) {
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
                client().admin()
                    .indices()  
     */
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.DELETED;
                            });
        createIndex("index");
            indexShard.shardId(),
        } else {
            indexShard.shardId(),
            public void onFailure(Exception e) {
import java.util.Locale;
                        assertSame(Thread.currentThread(), currentThread);
                .get();  
        PlainActionFuture<FetchSearchResult> fetchFuture = new PlainActionFuture<>();
            "pitId",  
            )  
            .setTransientSettings(
                        SearchContextMissingException.class,  
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                                indexShard,  
        searchRequest.source(searchSourceBuilder);
    public void testConcurrentSegmentSearchIsSetOnceDuringContextCreation() throws IOException {
                                -1,
                    .putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey())
                        service.executeFetchPhase(req, new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()), listener);  
        UpdatePitContextRequest updateRequest = new UpdatePitContextRequest(
            // however concurrentSearchExecutor will not be null  
                + SearchService.MAX_PIT_KEEPALIVE_SETTING.getKey()  
        } finally {  
                        listener.get();
                .prepareUpdateSettings("throttled_threadpool_index")  
                .prepareUpdateSettings()
                latch.countDown();  
            }
                                reader,
        for (Boolean concurrentSearchSetting : concurrentSearchStates) {  
                                useScroll ? scrollSearchRequest : searchRequest,  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            PlainActionFuture<UpdatePitContextResponse> updateFuture = new PlainActionFuture<>();
import org.opensearch.search.aggregations.InternalAggregation;
            SearchResponse searchResponse = client().prepareSearch("index").setSize(1).setScroll("1m").get();
        assertTrue(updateResponse.getKeepAlive() == updateRequest.getKeepAlive());  
        @Override  
                    .get();  
            SearchContext context = service.createContext(reader, request, null, randomBoolean());
    }
                );
import org.opensearch.search.builder.SearchSourceBuilder;
                    .setTransientSettings(
            ex.getMessage()
            }  
import org.opensearch.action.search.ClearScrollRequest;  
            assertNotNull(context);
        SearchShardTask task = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());  
 */
        primarySort.order(SortOrder.DESC);  
            .setTransientSettings(
        }
                .cluster()
        SearchPhaseResult queryResult = queryFuture.get();
        }  
import org.opensearch.index.search.stats.SearchStats;  
    public void testClearIndexDelete() {
            new AliasFilter(null, Strings.EMPTY_ARRAY),
    public void testCanMatchSearchAfterWithMissing() throws IOException {
        PlainActionFuture<ShardSearchContextId> future = new PlainActionFuture<>();  
        createIndex("index");
    public void testCanMatchSearchAfterDescEqualMin() throws IOException {  
        SearchPhaseResult queryResult = queryFuture.get();
                    expectThrows(
        protected int doHashCode() {
                OriginalIndices.NONE,  
                    () -> service.createContext(reader, request, null, randomBoolean())
        validatePitStats("index", 1, 0, 0);
                                        + "]. "
            null
                    -1,
            latch.await();
            InternalOrPrivateSettingsPlugin.class,  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchRequest,
                .setTransientSettings(Settings.builder().put(SearchService.CLUSTER_ALLOW_DERIVED_FIELD_SETTING.getKey(), false))
            System.currentTimeMillis()
        assertEquals(1, service.getActiveContexts());  
    }  
            SearchContext contextWithDefaultTimeout = service.createContext(reader, requestWithDefaultTimeout, null, randomBoolean())
    protected Settings nodeSettings() {
                @Override  
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
            .prepareUpdateSettings()
                                1,
        return new FilterDirectoryReader(directoryReader, new FilterDirectoryReader.SubReaderWrapper() {  
        }
                    SearchException.class,  
                .cluster()  
            nowInMillis,  
    public static class FailOnRewriteQueryBuilder extends AbstractQueryBuilder<FailOnRewriteQueryBuilder> {
        final boolean useScroll = randomBoolean();
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(false)
                    client().admin()
    public void testConcurrentSegmentSearchSearchContext() throws IOException {
                    contextIds.remove(contextId);
                    .get();
                    try {  
        final SearchService service = getInstanceFromNode(SearchService.class);  
                        }
        createIndex("index");  
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(3, 10);  
                        assertThat(Thread.currentThread().getName(), startsWith("opensearch[node_s_0][search_throttled]"));  
                try {
                        assertTrue(searchService.freeReaderContext(contextId));
                + "). "  
                        .indices()  
            return null;
            -1,
                SearchContextAggregations mockAggregations = mock(SearchContextAggregations.class);
        for (Object[] scenario : scenarios) {  
            } else {  
            return this;  
                .indices()  
    }  
            { false, false, "auto", false },  
            // the search context should inherit the default timeout  
        );  
                + SearchService.MAX_OPEN_SCROLL_CONTEXT.get(Settings.EMPTY)  
        IndexShard indexShard = indexService.getShard(0);
            { null, null, "all", true },
        protected void doWriteTo(StreamOutput out) {}
            // Default concurrent search mode is auto, which enables concurrent segment search when aggregations are present.  
 */  
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
            AliasFilter.EMPTY,
            NullPointerException e = expectThrows(
        client().admin().indices().prepareDelete("test").get();
                        assertTrue(result.queryResult().isNull());  
        {  
            "pitId",  
                    1,
        IndexShard indexShard = indexService.getShard(0);
import org.opensearch.common.UUIDs;  
            client().prepareSearch("index").setSize(1).setScroll("1m").get();
        );
import org.opensearch.action.search.SearchShardTask;
            }
     * Min = 0L, Max = 9L, search_after = 7L
            // cluster setting, index setting, expected slice count
        Thread currentThread = Thread.currentThread();  
        assertThat(searchService.getActiveContexts(), equalTo(1));
            try (DefaultSearchContext searchContext = service.createSearchContext(request, new TimeValue(System.currentTimeMillis()))) {  
        IndexShard indexShard = indexService.getShard(0);
        );  
                    DerivedFieldType derivedFieldType = (DerivedFieldType) context.getQueryShardContext()
    public void testExpandSearchFrozen() {  
            });  
            // cluster setting, index setting, cluster mode setting, concurrent search enabled?, concurrent search executor null?  
            .setTransientSettings(Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true))  
        final SearchService service = getInstanceFromNode(SearchService.class);
                    searchRequest,  
            -1,
        searchRequest.source(new SearchSourceBuilder().timeout(TimeValue.timeValueSeconds(seconds)));
                        } catch (InterruptedException e) {  
                .prepareUpdateSettings()
import org.apache.lucene.index.LeafReader;
        );  
        numWrapInvocations.incrementAndGet();
                assertEquals(
            try {  
        );
                        .transientSettings()
        );
        };  
            null,  
        assertThat(searchService.getAllPITReaderContexts().size(), equalTo(0));
        InternalAggregation.ReduceContextBuilder reduceContextBuilder = service.aggReduceContextBuilder(new SearchSourceBuilder());
import org.opensearch.search.internal.AliasFilter;
                try {
        searchService.createPitReaderContext(new ShardId(resolveIndex("index"), 0), TimeValue.timeValueMinutes(between(1, 10)), future);  
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true).scroll(new Scroll(TimeValue.timeValueMinutes(1)));
                .prepareUpdateSettings("index")  
     * test that creating more than the allowed number of scroll contexts throws an exception
        public FailOnRewriteQueryBuilder() {}
                .setSettings(Settings.builder().put(IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), indexMode))
                throw new IllegalStateException("Fail on rewrite phase");
            assertThrows(OpenSearchException.class, () -> service.createContext(reader, request, null, randomBoolean()));
                        assertThat(result, instanceOf(QuerySearchResult.class));
            context = service.createContext(reader, request, null, randomBoolean());  
                new Script(ScriptType.INLINE, MockScriptEngine.NAME, CustomScriptPlugin.DUMMY_SCRIPT, Collections.emptyMap())
            1,
        } else {
        assertTrue(updateResponse.getPitId().equalsIgnoreCase("pitId"));
        protected void doXContent(XContentBuilder builder, Params params) {}
            Boolean indexSetting = (Boolean) scenario[1];
        client().clearScroll(clearScrollRequest);
        deletePitResponse = searchService.freeReaderContextsIfFound(contextIds);
        IndexShard indexShard = indexService.getShard(0);
            { null, null, "none", false },  
                "throttled_threadpool_index",
            id,  
        assertHitCount(client().prepareSearch().setIndicesOptions(IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED).get(), 1L);  
                    .prepareUpdateSettings()
                + "]. "
 * ownership. Elasticsearch licenses this file to you under  
            Strings.EMPTY_ARRAY  
    }  
import org.opensearch.script.Script;  
                    .aggregation(new TermsAggregationBuilder("test").userValueTypeHint(ValueType.STRING).minDocCount(1))
                    1f,  
            indexService,
        }  
            TimeValue.timeValueHours(23).millis(),
            public CacheHelper getReaderCacheHelper() {  
        try (
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));  
import org.opensearch.search.fetch.ShardFetchRequest;
            ReaderContext reader = createReaderContext(indexService, indexShard);
                        Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), clusterSetting)
        assertFalse(
        ShardSearchContextId id = future.actionGet();  
                    OriginalIndices.NONE,
                    searchRequest,
            Boolean concurrentSearchEnabled = (Boolean) scenario[3];
    public void testCanMatchSearchAfterDescGreaterThanMin() throws IOException {
                null
                    indexShard.shardId(),  
        searchRequest.indices("alias").source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()));  
        primarySort.order(SortOrder.ASC);
                new ShardSearchRequest(
            { null, true, null, true },  
        ShardSearchRequest shardSearchRequest = new ShardSearchRequest(
     * Expected result is canMatch = false  
                                public void onResponse(IndexResponse indexResponse) {
                    }
        return true;  
            if (indexMode != null) {  
        assertEquals(
            // Default concurrent search mode is auto, without aggregations, concurrent search will be disabled.
                                }  
import org.opensearch.search.aggregations.AggregationBuilders;
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            try (DefaultSearchContext searchContext = service.createSearchContext(request, new TimeValue(System.currentTimeMillis()))) {  
import org.opensearch.core.common.io.stream.StreamOutput;
                        }
import org.apache.lucene.search.Query;
                indexShard,
                        .resolveDerivedFieldType("field" + i);
                new Script(ScriptType.INLINE, MockScriptEngine.NAME, CustomScriptPlugin.DUMMY_SCRIPT, Collections.emptyMap())
        numWrapInvocations = new AtomicInteger(0);
                        OriginalIndices.NONE,  
            SearchService.canRewriteToMatchNone(
            }
    }
                    .putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey())
            null,  
                        new SearchRequest().allowPartialSearchResults(true),
    public void testCanMatchSearchAfterDescLessThanMin() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        FetchSearchResult fetchResult = fetchFuture.get();  
                    .setTransientSettings(
            searchRequest,  
    /**
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
    }
                        assertNotNull(result.queryResult().topDocs());
    public void testMaxDocvalueFieldsSearch() throws IOException {
                );
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
        );
                    1f,
            searchRequest,
                () -> reduceContext.consumeBucketsAndMaybeBreak(MultiBucketConsumerService.DEFAULT_MAX_BUCKETS + 1)
                        throw new AssertionError(exc);
                @Override  
        SearchRequest searchRequest = new SearchRequest();  
        final ShardSearchRequest request = new ShardSearchRequest(
            AliasFilter.EMPTY,  
        ShardFetchRequest fetchRequest = new ShardFetchRequest(queryResult.getContextId(), docIds, null);  
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(3, 10);  
        final IndexService indexService = createIndex(index);
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, CustomScriptPlugin.DUMMY_SCRIPT, Collections.emptyMap())
            { null, 3, 3 },
        createIndex("index");
                );
        assertFalse(SearchService.canRewriteToMatchNone(new SearchSourceBuilder()));
            searchSourceBuilder.scriptField(
    }
    }  
                randomBoolean()
        createIndex("index");  
            OriginalIndices.NONE,  
import org.opensearch.action.OriginalIndices;
import org.opensearch.search.suggest.SuggestBuilder;  
     */
    }  
            indexShard,
     */
            CountDownLatch latch = new CountDownLatch(1);  
        SearchService service = getInstanceFromNode(SearchService.class);
            searchRequest,
        assertTrue(
                "field" + i,  
        assertTrue(  
            shardRequest.canReturnNullResponseIfMatchNoDocs(true);
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), true);
            }
                        throw ((RuntimeException) ex.getCause());
        searchRequest.allowPartialSearchResults(randomBoolean());
        client().execute(
                searchContext.evaluateRequestShouldUseConcurrentSearch();
        assertEquals(RestStatus.CREATED, response.status());  
            null
        assertTrue(SearchService.canRewriteToMatchNone(new SearchSourceBuilder().query(new TermQueryBuilder("foo", "bar"))));  
                        // make sure we don't use the search threadpool  
                    .setSettings(Settings.builder().putNull(IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT.getKey()))
                client().admin()
                    .prepareUpdateSettings()
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);  
    public void testMatchNoDocsEmptyResponse() throws InterruptedException {
                    .putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey())
                )  
            new AliasFilter(null, Strings.EMPTY_ARRAY),
        assertFalse(SearchService.canRewriteToMatchNone(null));
                    indexShard.shardId(),
/*
     * With above min/max and search_after, it should not match, but since
        Object[][] scenarios = {
                    indexShard.shardId(),
            1,
                @Override
    public void testUpdatePitIdMaxKeepAlive() {  
    }
        ShardSearchRequest request = new ShardSearchRequest(  
                while (contextIds.isEmpty() == false) {  
                    null,
        }  
            }  
                        .prepareState()
            super(in);
        // enable concurrent search
        IndexService indexService = createIndex(index);
        private Scroll scroll;
            indexModule.addSearchOperationListener(new SearchOperationListener() {
                        Settings.builder()  
                searchContext.evaluateRequestShouldUseConcurrentSearch();
            );
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        SearchShardTask task = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());
 * license agreements. See the NOTICE file distributed with
        ) {
        CountDownLatch latch = new CountDownLatch(searchers.length);
                }
        assertEquals(  
        ShardFetchRequest fetchRequest = new ShardFetchRequest(queryResult.getContextId(), docIds, null);
        assertEquals(1, service.getActiveContexts());  
        }  
    /**
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
                )
                } finally {
        searchSourceBuilder.size(0);
        // Set the cluster setting for mode  
    public void testSearchWhileIndexDeleted() throws InterruptedException {
        IndexService indexService = createIndex(index);
            });  
            OriginalIndices.NONE,
            SettingsException.class,  
            }
        assertTrue(
            client().admin()
        primarySort.order(SortOrder.DESC);
     */  
            final int rounds = scaledRandomIntBetween(100, 1000);  
        // the source cannot be rewritten to a match_none
                            assertThat(
        );
        createIndex("index");
                    } finally {  
                IllegalArgumentException.class,  
                                indexService,
        createIndex("index");  
                        );  
                    -1,
        Semaphore semaphore = new Semaphore(Integer.MAX_VALUE);
                .get();  
        SearchService service = getInstanceFromNode(SearchService.class);  
import org.opensearch.action.search.SearchRequest;
            assertNotNull(context.getQueryShardContext().resolveDerivedFieldType("field"));
                    null
        SearchContextMissingException ex = expectThrows(SearchContextMissingException.class, () -> {
                .prepareUpdateSettings("index")  
        ShardId shardId = new ShardId(indexService.index(), 0);
                assertEquals(targetSliceCount.intValue(), searchContext.getTargetMaxSliceCount());
            searchRequest,  
    }  
                    .indices()  
            () -> client().admin()
                                        + "["  
                        .prepareGetSettings(index)
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
        assertSettingDeprecationsAndWarnings(new Setting[] { IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING });
        // Needs to busily assert because Engine#refreshNeeded can increase the refCount.
                client().admin()
                    mode,
                    }
            );
import java.util.Collections;
        SearchService service = getInstanceFromNode(SearchService.class);
            assertThat(contextWithDefaultTimeout.timeout(), equalTo(TimeValue.timeValueSeconds(5)));
        ShardSearchRequest request = new ShardSearchRequest(  
        SearchResponse searchResponse = client().prepareSearch("throttled_threadpool_index")
                        latch.countDown();
        assertFalse(  
            null,
     * Min = 0L, Max = 9L, search_after = 9L  
            try (SearchContext context = service.createContext(reader, request, null, randomBoolean())) {
        );  
            )
        service.executeQueryPhase(shardSearchRequest, randomBoolean(), task, queryFuture);  
        createIndex("index");  
                new ShardSearchRequest(  
        assertThat(searchService.getAllPITReaderContexts().size(), equalTo(0));
        indexShard.getThreadPool().executor(ThreadPool.Names.SEARCH).execute(() -> {
                    assertThat(searchService.getActiveContexts(), equalTo(contextIds.size()));  
        );
 * Unless required by applicable law or agreed to in writing,
        // without aggregations.  
                    contextIds.add(context.id());  
                    1,
                    .aggregation(new TermsAggregationBuilder("test").userValueTypeHint(ValueType.STRING).minDocCount(0))  
        String index = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);
            nowInMillis,
            )  
                .searchAfter(new Object[] { 1.0f }) };
                latch.countDown();
            searchRequest,  
            { 4, 3, 3 }, };  
            assertEquals(  
 * under the License.  
                    )
    public void testUpdatePitIdWithInvalidReaderId() {  
                .get();  
                + "This limit can be set by changing the [search.max_open_scroll_context] setting.",
                    }
import org.opensearch.index.shard.IndexShard;
                IndexSettings.INDEX_SEARCH_THROTTLED.getKey(),
        );  
        expectThrows(
        );
            }
        assertFalse(
        assertThat(searchService.getActiveContexts(), equalTo(0));
            indexShard.shardId(),
    }
        assertTrue(
         */
        try (
        PlainActionFuture<ShardSearchContextId> future = new PlainActionFuture<>();  
            concurrentSearchEnabled = false;  
        SearchStats.Stats totalStats = indexShard.searchStats().getTotal();
                new ShardId(resolveIndex("index"), 0),
        final SearchService service = getInstanceFromNode(SearchService.class);
        PlainActionFuture<SearchPhaseResult> queryFuture = new PlainActionFuture<>();
            indexShard.shardId(),
                    1,
import org.apache.lucene.search.FieldDoc;  
                .indices()
        );  
        service.doClose(); // this kills the keep-alive reaper we have to reset the node after this test
            } else {
            // update concurrent search cluster setting and create search context
                    }  
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
        IndexService indexService = createIndex(index);
            context = service.createContext(reader, request, null, randomBoolean());
                try {  
                    }
                )
            searchRequest,
        searchSourceBuilder.scriptField(  
            null,  
            .prepareUpdateSettings()
            shardRequest.source().query(new MatchAllQueryBuilder());
        final IndexShard indexShard = indexService.getShard(0);
            // expected value null will pick up default value from settings
import org.apache.lucene.index.FilterDirectoryReader;
        }
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            // dynamically enabled using index setting, assert derived field resolved fine  
    }
                    .prepareUpdateSettings()
import java.util.Map;  
                            searchService.freeReaderContext((new ShardSearchContextId(contextId.getSessionId(), contextId.getId())))
            new AliasFilter(null, Strings.EMPTY_ARRAY),  
        );
                    + maxScriptFields  
            IllegalArgumentException ex = expectThrows(
        }
     */  
                ex.getMessage()
            OriginalIndices.NONE,
        final SearchService service = getInstanceFromNode(SearchService.class);  
                assertThat(searchContext.searcher().getTaskExecutor(), is(notNullValue()));
            }  
                        PlainActionFuture<SearchPhaseResult> result = new PlainActionFuture<>();
                while (running.get()) {
        }  
                    .cluster()  
        createIndex("index");  
        assertEquals(activeContexts, service.getActiveContexts());  
        assertTrue(updateResponse.getCreationTime() == updateRequest.getCreationTime());
import org.opensearch.script.MockScriptEngine;
            1f,  
            client().admin()
        CountDownLatch latch = new CountDownLatch(threads.length);  
        assertEquals(
        assertNotNull("Profile results should contain fetch phase data", fetchResult.getProfileResults().getFetchProfileResult());  
    }  
                    .get();
        service.doStop();
        );
        thread.start();  
        @Override
        createIndex("index");  
import org.opensearch.action.search.SearchResponse;  
        SearchService service = getInstanceFromNode(SearchService.class);
            new AliasFilter(null, Strings.EMPTY_ARRAY),
        );
            result.get();
                when(mockAggregations.factories().allFactoriesSupportConcurrentSearch()).thenReturn(aggregationSupportsConcurrent);  
import org.opensearch.core.index.Index;
    /**
        final IndexShard indexShard = indexService.getShard(0);
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { 7L });  
                .cluster()  
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(index));
            InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.INSTANCE,  
            clusterAlias,
import org.opensearch.index.IndexNotFoundException;  
                SearchException ex = expectThrows(
            });
            assertEquals(expectedIndexName, queryShardContext.getFullyQualifiedIndex().getName());
                    assertEquals("reader_context is already closed can't increment refCount current count [0]", ex.getMessage());
                null,  
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            return false;
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
        });  
        IndexService indexService = createIndex(index);
        final ShardSearchRequest request = new ShardSearchRequest(  
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, CustomScriptPlugin.DUMMY_SCRIPT, Collections.emptyMap())
    }
                        .getState()
    /**
        createIndex("index");  
        );  
            public SearchType searchType() {
                    null,  
                indexService,
            indexShard.shardId(),  
        @Override  
            shardId,  
            // Adding cases with mode set to "all"  
        final SearchService service = getInstanceFromNode(SearchService.class);  
                    .setTransientSettings(
        Integer[][] scenarios = {  
            new InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.Request(
    public void testCreateSearchContextFailure() throws Exception {  
        assertThat(searchService.getActiveContexts(), equalTo(1));
     *  If concurrent search enabled -
        searchRequest.source(
                    Settings.builder().put(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), concurrentSearchSetting)  
                    searchRequest,
            service.canMatch(
                )
            1.0f,
     */
                                null,  
        // adding the maximum allowed number of docvalue_fields to retrieve  
                }  
                                )
                        latch.countDown();
                        return;  
                IndexSettings.INDEX_SEARCH_THROTTLED.getKey(),  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
                }
            threads[i] = new Thread(() -> {
        assertHitCount(client().prepareSearch().setIndicesOptions(IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED).get(), 1L);  
            new SearchSourceBuilder().query(new MatchNoneQueryBuilder()).aggregation(new GlobalAggregationBuilder("test"))
        createIndex("test");
    private static AtomicInteger numWrapInvocations = new AtomicInteger(0);
    }
                concurrentSearchEnabled = indexMode.equals("all");
    }
import org.opensearch.common.settings.Settings;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        public String getWriteableName() {
        String[] modeSettings = { "all", "auto", "none", null };  
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { 0L });
            @Override
    public static class FailOnRewriteQueryPlugin extends Plugin implements SearchPlugin {
                    1f,
                assertThat(searchContext.searcher().getTaskExecutor(), is(notNullValue()));  
        String index = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);  
            ).canMatch()  
        assertThat(searchService.getActiveContexts(), equalTo(1));
        {
        };
     * @throws IOException
            nowInMillis,
                assertThat(searchContext.searcher().getTaskExecutor(), is(notNullValue()));
            .prepareUpdateSettings()
 *  
                .prepareUpdateSettings()
            { null, null, clusterService.getClusterSettings().get(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING) },  
                .setTransientSettings(Settings.builder().putNull(SearchService.CLUSTER_ALLOW_DERIVED_FIELD_SETTING.getKey()))
                    1,
     * avoid leaking searchers.
                OriginalIndices.NONE,
            // ok  
    public void testMaxOpenScrollContexts() throws Exception {  
            }  
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { 9L });
        SearchSourceBuilder[] sources = new SearchSourceBuilder[] {
import org.opensearch.script.ScriptType;
            OpenSearchRejectedExecutionException.class,
                        Settings.builder().put(IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT.getKey(), indexSliceCount)  
                    for (;;) {  
                    .get();  
 * specific language governing permissions and limitations
        public void onIndexModule(IndexModule indexModule) {
            });
            }
    public void testTimeout() throws IOException {
            1.0f,  
     * Min = 0L, Max = 9L, search_after = 0L  
import org.opensearch.search.aggregations.SearchContextAggregations;  
import java.util.List;
        IndexShard indexShard = indexService.getShard(shardId);  
                } finally {
                        1.0f,
                    }  
        );
        docIds.add(0);
 * You may obtain a copy of the License at  
        AtomicBoolean stopped = new AtomicBoolean(false);
        ShardSearchContextId shardSearchContextId = future.actionGet();  
            ).canMatch()
import java.util.concurrent.ExecutionException;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
    /**
    /**  
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { 10L });
                                OriginalIndices.NONE,
        final IndexShard indexShard = indexService.getShard(0);  
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            ).canMatch()
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);  
        PlainActionFuture<ShardSearchContextId> future = new PlainActionFuture<>();
                @Override  
import org.opensearch.action.support.PlainActionFuture;  
            randomBoolean(),
        searchRequest.source(searchSourceBuilder);
    public static class ReaderWrapperCountPlugin extends Plugin {
        final ShardSearchRequest request = new ShardSearchRequest(
                client().admin()
                "field" + i,  
                    indexSetting == null ? null : indexSetting.toString(),
            -1,  
                    1,
            1f,  
            InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.INSTANCE,  
 * SPDX-License-Identifier: Apache-2.0
        @Override  
        service.executeFetchPhase(fetchRequest, task, fetchFuture);
        }  
    }  
    }  
            assertNotNull(context.getQueryShardContext().resolveDerivedFieldType("field"));
        for (int i = 0; i < searchers.length; i++) {
        }
                client().admin()
        try (DefaultSearchContext searchContext = service.createSearchContext(request, new TimeValue(System.currentTimeMillis()))) {
            indexModule.setReaderWrapper(service -> SearchServiceTests::apply);
                )
        for (int i = 0; i < threads.length; i++) {
                .indices()
        primarySort.order(SortOrder.DESC);
            1,
                new AliasFilter(null, Strings.EMPTY_ARRAY),
                    .setSettings(Settings.builder().putNull(IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey()))
import org.opensearch.action.support.WriteRequest;
            Integer clusterSliceCount = sliceCounts[0];  
            null  
     */  
            }
        String index = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);  
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
            InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.INSTANCE,
            -1,
                .getMetadata()
        }
            null
                                    semaphore.release();
                        assertNotSame(Thread.currentThread(), currentThread);  
            new ShardSearchContextId(UUIDs.randomBase64UUID(), randomNonNegativeLong()),  
        FetchSearchResult fetchResult = fetchFuture.get();
        SearchService searchService = getInstanceFromNode(SearchService.class);
        ).actionGet();
        }
        primarySort.order(SortOrder.ASC);
            OriginalIndices.NONE,  
            indexShard.acquireSearcherSupplier(),  
                    // make sure that the wrapper is called when the query is actually executed  
            SearchService.canRewriteToMatchNone(  
                        1,  
                .setSettings(Settings.builder().put(IndexSettings.INDEX_SEARCH_THROTTLED.getKey(), false))
                @Override  
        searchRequest.source(new SearchSourceBuilder());
                concurrentSearchEnabled = !indexMode.equals("none") && aggregationSupportsConcurrent;
                    .prepareUpdateSettings()  
            );
            "1",
    /**  
        assertThat(searchService.getAllPITReaderContexts().size(), equalTo(1));  
        searchRequest.source(new SearchSourceBuilder().profile(false));  
                concurrentSearchEnabled = !clusterMode.equals("none") && aggregationSupportsConcurrent;  
        final int activeRefs = indexShard.store().refCount();
            }
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
        assertTrue(
import org.opensearch.common.settings.Setting;
        for (int i = 0; i < clearScrollIds.size(); i++) {
        IndexShard indexShard = indexService.getShard(0);  
    public void testUpdatePitId() throws ExecutionException, InterruptedException {
                            searchService.createAndPutReaderContext(  
         * Checks that canMatch takes into account the alias filter  
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            { true, false, "auto", false },
        Thread[] searchers = new Thread[randomIntBetween(1, 4)];  
                .setTransientSettings(Settings.builder().put(SearchService.CLUSTER_ALLOW_DERIVED_FIELD_SETTING.getKey(), true))
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
                    try {
                client().admin()
                    .setTransientSettings(Settings.builder().putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey()))
                    try {
            client().admin()
            .get();
import java.util.concurrent.Semaphore;  
        latch.await();
                        .cluster()  
        boolean concurrentSearchEnabled;
                    -1,
            }
                        PlainActionFuture<FetchSearchResult> listener = new PlainActionFuture<>();
        assertEquals(0, totalStats.getQueryCurrent());  
    public void testSetSearchThrottled() {  
                        throw new AssertionError(exc);
                .prepareUpdateSettings()  
import java.util.concurrent.atomic.AtomicBoolean;
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), true);
                    .setTransientSettings(
            new AliasFilter(null, Strings.EMPTY_ARRAY),  
                                1.0f,
import org.opensearch.search.internal.ShardSearchRequest;  
        );  
            expectThrows(
            null
                    null,  
import static org.hamcrest.CoreMatchers.startsWith;
 *
            CountDownLatch latch = new CountDownLatch(1);  
            null
    /**
                    } else {
        FieldDoc searchAfter = new FieldDoc(0, 0, new Long[] { -1L });  
    }  
        searchRequest.indices("alias").source(new SearchSourceBuilder().query(new TermQueryBuilder("id", "1")));
            // the search context should inherit the query timeout  
                assertThat(searchContext.searcher().getTaskExecutor(), is(notNullValue()));
                        try {
        final IndexShard indexShard = indexService.getShard(0);
            new SearchSourceBuilder().collapse(new CollapseBuilder("user"))
                        assertThat(Thread.currentThread().getName(), startsWith("opensearch[node_s_0][search]"));
                        .getMetadata()
        }
                public void onFetchPhase(SearchContext context, long tookInNanos) {
                    .prepareUpdateSettings()
        final ShardScrollRequestTest request = new ShardScrollRequestTest(indexShard.shardId());
            System.currentTimeMillis()  
            public void run() {  
            .get();
        ).actionGet();  
            null,  
    }  
        List<Integer> docIds = new ArrayList<>();
            "Keep alive for request (1d) is too large. "  
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(false);  
                    1f,
        createIndex("index");
                                        + maxScrollContexts
     * The same is used throughout the context object lifetime even if cluster setting changes before the request completion.  
            -1,  
    }  
            Boolean clusterSetting = (Boolean) scenario[0];
    }  
        assertEquals(1, service.getActiveContexts());  
            threads[i].setName("opensearch[node_s_0][search]");
        List<PitSearchContextIdForNode> contextIds = new ArrayList<>();
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                        } catch (OpenSearchRejectedExecutionException e) {
            ReaderContext reader = createReaderContext(indexService, indexShard);  
            if (indexSetting == null) {
            assertThrows(OpenSearchException.class, () -> service.createContext(reader, request, null, randomBoolean()));
        final SearchService service = getInstanceFromNode(SearchService.class);
                    client().admin()
            SearchContext context = service.createContext(reader, request, null, randomBoolean())  
                    OriginalIndices.NONE,
                + "It must be less than ("
     * Expected result is canMatch = true
        assertHitCount(client().prepareSearch().get(), 1L);
                    .cluster()  
        SearchService searchService = getInstanceFromNode(SearchService.class);  
                1f,
            shardId,
                    }  
                assertEquals(concurrentSearchSetting, searchContext.shouldUseConcurrentSearch());
        Thread[] threads = new Thread[randomIntBetween(2, 8)];
        /*
    @Before  
            InternalAggregation.ReduceContext reduceContext = reduceContextBuilder.forFinalReduction();
    }
        SearchService searchService = getInstanceFromNode(SearchService.class);
        {
            )
import org.opensearch.index.IndexModule;
            indexMode,  
                    indexShard.shardId(),  
        // cleanup
                .indices()
            false
                request,  
            client().admin()
                + "). "
    public void testPitContextMaxKeepAlive() {
        client().prepareIndex("frozen_index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        searchService.createPitReaderContext(new ShardId(resolveIndex("index"), 0), TimeValue.timeValueMinutes(between(1, 10)), future);
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);  
        // the source can match and can be rewritten to a match_none, but not the alias filter
                    latch.await();
            SearchService.canRewriteToMatchNone(
import org.opensearch.indices.settings.InternalOrPrivateSettingsPlugin;
            ).canMatch()
        String index = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);  
        int maxScriptFields = indexService.getIndexSettings().getMaxScriptFields();  
            Integer indexSliceCount = sliceCounts[1];
        List<Integer> docIds = new ArrayList<>();  
        FieldSortBuilder primarySort = new FieldSortBuilder("test");
                "Trying to retrieve too many docvalue_fields. Must be less than or equal to: [100] but was [101]. "
                .get();
        assertThat(searchService.getActiveContexts(), equalTo(0));  
                // verify concurrent search state in context
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                .prepareUpdateSettings(index)
            public void onResponse(SearchPhaseResult searchPhaseResult) {
    }  
    }  
                    }  
                new SearchSourceBuilder().query(new MatchNoneQueryBuilder()).aggregation(new GlobalAggregationBuilder("test"))
import org.opensearch.search.internal.ShardSearchContextId;
            thread.join();
        SearchShardTask task = new SearchShardTask(123L, "", "", "", null, Collections.emptyMap());  
    }
            OriginalIndices.NONE,
import static java.util.Collections.singletonList;
        @Override  
        SearchService searchService = getInstanceFromNode(SearchService.class);
    }  
                    .prepareUpdateSettings(index)
                );  
                + "It must be less than ("
            ).canMatch()  
            -1,
        ShardSearchRequest request = new ShardSearchRequest(
        ShardSearchRequest req = new ShardSearchRequest(
            searchService.updatePitIdAndKeepAlive(updateRequest, updateFuture);  
            Strings.EMPTY_ARRAY  
     * Test for ASC order search_after query.
        SearchRequest scrollSearchRequest = new SearchRequest().allowPartialSearchResults(true)  
     */
        CountDownLatch startGun = new CountDownLatch(1);
                            throw new AssertionError(e);
        }
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));
        ShardSearchRequest shardRequest = new ShardSearchRequest(
                        latch.countDown();
import org.apache.lucene.index.DirectoryReader;  
        assertEquals(expectedPitCount, indexShard.searchStats().getTotal().getPitCount());
            AliasFilter.EMPTY,
        // with aggregations.  
 * the Apache License, Version 2.0 (the "License"); you may
        IndexShard indexShard = indexService.getShard(0);
            assertEquals(0, context.scriptFields().fields().size());
                            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), clusterSliceCount)
            FailOnRewriteQueryPlugin.class,  
                    .prepareUpdateSettings()
                    } finally {
                                    "Trying to create too many scroll contexts. Must be less than or equal to: "
            SearchPhaseExecutionException.class,  
        createIndex("index", Settings.builder().put("index.refresh_interval", -1).build());
            { true, true, "all", true },
        @Override  
                ShardSearchRequest request = new ShardSearchRequest(  
                    searchRequest,
            client().admin()
                            ),
                }
            // disabled using index setting, assert create context fails  
            // aggregationSupportsConcurrent determines if the present aggregation type supports concurrent segment search.
        ) {
        try {  
                new SearchSourceBuilder().query(new MatchNoneQueryBuilder())
        searchRequest.allowPartialSearchResults(randomBoolean());
        final ShardSearchRequest request = new ShardSearchRequest(
            new AliasFilter(null, Strings.EMPTY_ARRAY),  
                assertThat(  
                .setSettings(Settings.builder().put(IndexSettings.ALLOW_DERIVED_FIELDS.getKey(), true))
                    assertEquals(1, numWrapInvocations.get());
        // Open all possible scrolls, clear some of them, then open more until the limit is reached  
            // dynamically enabled using cluster setting, assert derived field resolved fine  
        for (int i = 0; i < SearchService.MAX_OPEN_SCROLL_CONTEXT.get(Settings.EMPTY); i++) {  
    public void testCloseSearchContextOnRewriteException() {
            searchRequest,
                }
        if (indexMode == null) {
        service.executeQueryPhase(shardSearchRequest, randomBoolean(), task, queryFuture);
        final SearchService service = getInstanceFromNode(SearchService.class);
            1.0f,
            Strings.EMPTY_ARRAY  
                        final Engine.SearcherSupplier reader = indexShard.acquireSearcherSupplier();
                    }
        // we add a search action listener in a plugin above to assert that this is actually used
                assertNull(context.getQueryShardContext().resolveDerivedFieldType("field" + 5));  
            -1,
        );
            new AliasFilter(null, Strings.EMPTY_ARRAY),  
            ex.getMessage()  
        assertEquals(SearchService.canMatchSearchAfter(searchAfter, minMax, primarySort, SearchContext.TRACK_TOTAL_HITS_DISABLED), true);
        {
        client().prepareIndex("index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
            TimeValue.timeValueMinutes(between(1, 10)).millis(),
            }
    public void testCanMatchSearchAfterDescLessThanMinWithTrackTotalhits() throws IOException {
                client().admin()
        final SearchService service = getInstanceFromNode(SearchService.class);
     * Test canMatchSearchAfter with missing value, even if min/max is out of range  
            { false, false, "all", true },  
                    new AliasFilter(null, Strings.EMPTY_ARRAY),  
            } else {
        DeletePitResponse deletePitResponse = searchService.freeReaderContextsIfFound(contextIds);
            OriginalIndices.NONE,  
        PlainActionFuture<SearchPhaseResult> queryFuture = new PlainActionFuture<>();
                .aggregation(new TermsAggregationBuilder("test").userValueTypeHint(ValueType.STRING).minDocCount(0))
        IndexService indexService = createIndex(index);
            "Keep alive for request (1d) is too large. "
            }
            indexShard.shardId(),
    }  
                .cluster()  
        SearchRequest searchRequest = new SearchRequest();  
                public void onFailure(Exception exc) {  
                .get(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey())  
        assertEquals(0, service.getActiveContexts());
import org.opensearch.search.internal.SearchContext;
    public void testCanRewriteToMatchNone() {
            .scroll(new Scroll(TimeValue.timeValueMinutes(1)));
                    1.0f,  
            null,
        assertEquals(0, totalStats.getScrollCurrent());
        );  
                        final boolean useScroll = randomBoolean();
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));  
    public void testExpandSearchThrottled() {
        OpenSearchRejectedExecutionException ex = expectThrows(  
                    .prepareUpdateSettings(index)
                    assertFalse(searchService.freeReaderContext(contextId));
     * Expected result is canMatch = true
                // Cleanup
    public void testCanMatch() throws Exception {  
            searchSourceBuilder.docValueField("field" + i);
                            );
        );  
import org.opensearch.OpenSearchException;  
        searchRequest.source(searchSourceBuilder);
                                    semaphore.release();  
                    .cluster()
        }
                )  
                assertEquals(  
        assertEquals(expectedPitCurrent, indexShard.searchStats().getTotal().getPitCurrent());
     * Test that the Search Context for concurrent segment search enabled is set correctly at the time of construction.
            null,
                        try {
        final SearchService searchService = getInstanceFromNode(SearchService.class);
     * Expected result is canMatch = false
            -1,  
 * Licensed to Elasticsearch under one or more contributor  
        @Override
            OriginalIndices.NONE,
    public void testCreateReduceContext() {  
        // Randomize both index and cluster settings
                -1,  
        client().admin().indices().prepareRefresh("test").get();
                    .prepareUpdateSettings(index)  
        final SearchService service = getInstanceFromNode(SearchService.class);  
            )
            1.0f,
                        indexShard,
            protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
                    )
            .setTransientSettings(Settings.builder().putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey()))
        assertThat(searchResponse.getScrollId(), is(notNullValue()));  
                null,
        protected boolean doEquals(FailOnRewriteQueryBuilder other) {  
        createIndex("index");  
        assertEquals(activeRefs, indexShard.store().refCount());
                    null
            -1,
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);  
                        indexService,  
        );  
import org.junit.Before;  
                // verify executor state in searcher
                        if (useScroll) {
        }) {
                    null
import static org.hamcrest.CoreMatchers.instanceOf;
        }
                    null,
        ShardScrollRequestTest(ShardId shardId) {  
        SearchRequest searchRequest = new SearchRequest();
        }
            OriginalIndices.NONE,  
    public void testClearOnClose() {
            // disabled using cluster setting, assert create context fails
import org.opensearch.common.settings.SettingsException;  
            PlainActionFuture<UpdatePitContextResponse> updateFuture = new PlainActionFuture<>();
                    OriginalIndices.NONE,
            new AliasFilter(null, Strings.EMPTY_ARRAY),
            .get();
            assertEquals(expectedIndexName, searchShardTarget.getFullyQualifiedIndexName());  
            // Adding cases with mode set to "none"
            @Override
    /**  
            assertEquals(clusterAlias, searchShardTarget.getClusterAlias());
                "true"
                        Settings.builder().putNull(SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey())  
import org.opensearch.index.engine.Engine;  
import org.opensearch.search.collapse.CollapseBuilder;
        }  
    public void testConcurrentSegmentSearchWithRandomizedModeSettings() throws IOException {
        // if refresh happens while checking the exception, the subsequent reference count might not match, so we switch it off  
        final ShardSearchRequest request = new ShardSearchRequest(shardId, 0, null) {
                indexShard.acquireSearcherSupplier(),  
                assertEquals(concurrentSearchEnabled, searchContext.shouldUseConcurrentSearch());
            1,  
        CountDownLatch latch = new CountDownLatch(1);
                        request,
                }
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        SearchService service = getInstanceFromNode(SearchService.class);
        service.freeAllScrollContexts();  
                            semaphore.acquire();
            } finally {  
        PlainActionFuture<SearchPhaseResult> result = new PlainActionFuture<>();  
                .get();
import org.opensearch.indices.IndicesService;  
import static org.hamcrest.CoreMatchers.equalTo;  
        }  
            } else if (clusterMode != null) {
                    null,
            clusterMode,
                    }
        docIds.add(0);
}  
    public void validatePitStats(String index, long expectedPitCurrent, long expectedPitCount, int shardId) throws ExecutionException,
                        assertThat(result, instanceOf(QuerySearchResult.class));
        final SearchService service = getInstanceFromNode(SearchService.class);
        ShardSearchRequest request = new ShardSearchRequest(
        assertTrue(updateResponse.getPitId().equalsIgnoreCase("pitId"));
        MockSearchService service = (MockSearchService) getInstanceFromNode(SearchService.class);
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));  
            1f,  
                    final ReaderContext context = searchService.createAndPutReaderContext(
                    searchRequest,
            1,
        }
                .prepareUpdateSettings()
            { true, null, null, true },
            if (mode == null) {
                .get()
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
        validatePitStats("index", 0, 1, 0);  
    /**
                new ShardSearchRequest(  
            AliasFilter.EMPTY,
    }
        public void onIndexModule(IndexModule indexModule) {
                        latch.countDown();
        assertTrue(
        );
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        }
                    -1,
        {
            null
        final IndexService indexService = indicesService.indexServiceSafe(resolveIndex("index"));  
        }
        searchRequest.allowPartialSearchResults(randomBoolean());
import static org.hamcrest.CoreMatchers.containsString;
        client().prepareIndex("throttled_threadpool_index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
import org.opensearch.core.common.io.stream.StreamInput;
     * Test for DESC order search_after query.
        );
                Settings.builder()  
        assertEquals("No search context found for id [" + id.getId() + "]", ex.getMessage());  
            latch.await();
            1f,
import org.opensearch.search.aggregations.support.ValueType;  
        assertFalse(
        IndexShard indexShard = indexService.getShard(0);
                SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true).source(source);
                        latch.countDown();
            return singletonList(new QuerySpec<>("fail_on_rewrite_query", FailOnRewriteQueryBuilder::new, parseContext -> {
import org.opensearch.action.search.UpdatePitContextResponse;
                null
            ).canMatch()
        FieldSortBuilder primarySort = new FieldSortBuilder("test");  
        ) {
        }
                    null  
import org.opensearch.plugins.SearchPlugin;  
        PitSearchContextIdForNode pitSearchContextIdForNode = new PitSearchContextIdForNode(
                    } finally {  
                    + (maxScriptFields + 1)
                            new SearchShardTask(123L, "", "", "", null, Collections.emptyMap()),
                    new AliasFilter(null, Strings.EMPTY_ARRAY),
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        assertThat(searchResponse.getScrollId(), is(notNullValue()));  
            null
            null,
                    null  
        for (Thread thread : threads) {
        client().prepareIndex("throttled_threadpool_index").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        // Cleanup
            1f,
                "Trying to retrieve too many script_fields. Must be less than or equal to: ["
                    1f,
            null,
import java.util.LinkedList;  
            InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.INSTANCE,  
        assertThat(searchService.getAllPITReaderContexts().size(), equalTo(1));  
                    .prepareUpdateSettings()  
                public void onQueryPhase(SearchContext context, long tookInNanos) {
        }  
 *
        createIndex("index");  
                }  
            MockSearchService.TestPlugin.class
            // auto mode concurrent search is false since request has no aggregation
                    1,  
        FieldSortBuilder primarySort = new FieldSortBuilder("test");  
            try (SearchContext context = service.createContext(reader, request, null, randomBoolean())) {
            this.scroll = new Scroll(TimeValue.timeValueMinutes(1));  
                // set the aggregations for context
                assertAcked(client().admin().indices().prepareDelete("index"));
    protected Collection<Class<? extends Plugin>> getPlugins() {
            }
        // Set the index setting for mode  
    /**  
            { true, false, null, false },
                    } catch (Exception ignored) {
            .cluster()  
        }  
                searchContext.evaluateRequestShouldUseConcurrentSearch();
    }
                        .get()
import org.opensearch.search.sort.SortOrder;
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);  
            searchService.createPitReaderContext(new ShardId(resolveIndex("index"), 0), TimeValue.timeValueHours(25), future);
            );
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;  
            QueryShardContext queryShardContext = searchContext.getQueryShardContext();  
        int numContexts = randomIntBetween(1, 10);  
        MinAndMax<?> minMax = new MinAndMax<Long>(0L, 9L);
                searchContext.aggregations(mockAggregations);  
            TimeValue.timeValueHours(25).millis(),
            new InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.Request(  
        startGun.await();
        createIndex("index");  
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
    }  
                } catch (Exception e) {  
        service.freeReaderContext(queryResult.getContextId());
        String clusterMode = randomFrom(modeSettings);  
            randomNonNegativeLong(),
                        .cluster()
            null,
    }  
        searchSourceBuilder.docValueField("one_field_too_much");  
                        .get()  
            indexShard.shardId(),
                assertThat(searchService.getActiveContexts(), equalTo(contextIds.size()));
import java.util.ArrayList;  
        UpdatePitContextRequest updateRequest = new UpdatePitContextRequest(
     *       else pick default cluster level slice count setting
        PlainActionFuture<ShardSearchContextId> future = new PlainActionFuture<>();
                    .setTransientSettings(Settings.builder().putNull(SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey()))
            )
            clusterAlias,
        assertFalse(
            } else {
        assertTrue(deletePitResponse.getDeletePitResults().get(0).isSuccessful());
        assertThat(searchService.getActiveContexts(), equalTo(1));
            null
import static org.hamcrest.CoreMatchers.is;
        CountDownLatch latch = new CountDownLatch(1);  
                            result
        );
                        .get()
        PlainActionFuture<FetchSearchResult> fetchFuture = new PlainActionFuture<>();
            }
                .prepareState()
                .transientSettings()
            OriginalIndices.NONE,
                    .get();  
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);  
                            // have to free context since this test does not remove the index from IndicesService.  
 * Modifications Copyright OpenSearch Contributors. See  
                        .getState()  
                .sort(new ScoreSortBuilder().order(SortOrder.ASC))  
public class SearchServiceTests extends OpenSearchSingleNodeTestCase {
import static org.hamcrest.CoreMatchers.notNullValue;  
        }  
        SearchService service = getInstanceFromNode(SearchService.class);
    public void testSearchWhileIndexDeletedDoesNotLeakSearchContext() throws ExecutionException, InterruptedException {
                    .setSettings(Settings.builder().put(IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), indexSetting))
            SearchService.canRewriteToMatchNone(
                    indexShard.shardId(),  
        assertFalse(searchService.freeReaderContext(future.actionGet()));
            () -> client().prepareSearch("index").setQuery(new FailOnRewriteQueryBuilder()).get()
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
/*
import org.opensearch.action.search.DeletePitResponse;
     * Tests that the slice count is calculated correctly when concurrent search is enabled
                    OriginalIndices.NONE,  
                    searchRequest,  

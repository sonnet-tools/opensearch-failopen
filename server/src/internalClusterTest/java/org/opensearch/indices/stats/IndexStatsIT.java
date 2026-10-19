        IndicesStatsResponse stats = client().admin()
        assertThat(stats.getTotal().getStore(), nullValue());
        );
                    try {
                    .getFieldData()
            indexName,
    public void testAllFlags() throws Exception {
        // Compare with fresh object because all values default to 0 in default fresh object
                .getMemorySizeInBytes(),
                .prepareCreate("idx")
                builders[i] = client().prepareIndex("idx")
                builder.setSegments(set);
        client().prepareIndex("test_index_2").setId(Integer.toString(1)).setSource("field", "value").execute().actionGet();
                    .put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))
    @Override
    private void persistGlobalCheckpoint(String index) throws Exception {
import java.util.concurrent.BrokenBarrierException;
                .get("field"),
            .actionGet();
import org.opensearch.action.index.IndexResponse;
                client().prepareSearch("index").setQuery(QueryBuilders.constantScoreQuery(QueryBuilders.matchQuery("foo", "baz"))).get()
            greaterThan(0L)
                .getMemorySizeInBytes(),
            assertThat(
        try {
        CommonStatsFlags flags = new CommonStatsFlags();
                    failed.set(true);
    public void testSegmentsStats() {
import org.opensearch.indices.IndicesRequestCache;
    public void testMultiIndex() throws Exception {
                return response.getMerge() != null;
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC.name())
                    latch.countDown();
        }
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
            case Get:
            BytesStreamOutput out = new BytesStreamOutput();
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getHitCount(),
        assertThat(shardFailures.get(), emptyCollectionOf(DefaultShardOperationFailedException.class));
            for (ShardStats shardStats : response.getShards()) {
        ensureGreen(indexName);
        assertThat(stats.getTotalShards(), equalTo(numShards1 + numShards2));
                .getFields()
                .setRequestCache(false)
        assertThat(
                .actionGet();
        );
                return response.getDocs() != null;
                    barrier.await();
                    .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), "2")
            for (IndexService indexService : indexServices) {
        assertThat(
import org.opensearch.index.translog.Translog;
        flush("index");
                builder.setRecovery(set);
            case Completion:
import java.util.Random;
        client().prepareSearch()
        }
        // start threads that will index concurrently with stats requests
        final Set<String> nodes = internalCluster().nodesInclude(index);
        assertBusy(() -> {
                    }
        assertEquals(stats1.getEvictions(), stats2.getEvictions());
        }
            .prepareStats()
                .getHits()
        assertThat(stats.getTotalShards(), equalTo(numShards1 + numShards2));
        );
            .clear()
            .execute()
                try {
import org.opensearch.core.common.bytes.BytesReference;
        assertThat(stats.getTotal().getSegments().getVersionMapMemoryInBytes(), greaterThan(0L));
            .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), true)
            assertThat(
        nodesStats = client().admin()
        assertEquals(stats1.getCacheCount(), stats2.getCacheCount());
        for (int i = 0; i < numDocs; ++i) {
                break;
                            latch.countDown();
            .put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1ms")
        }
        assertZeroRemoteTranslogStats(remoteTranslogStatsFromIndexStats);
            }
                    latch.countDown();
        for (Flag flag : values) {
            assertThat(isSet(flag, stats.getTotal()), equalTo(false));
import org.opensearch.indices.replication.common.ReplicationType;
            assertThat(stats.getTotal().queryCache.getCacheSize(), greaterThan(0L));
        NodesStatsResponse nodesStats = client().admin().cluster().prepareNodesStats("data:true").setIndices(true).execute().actionGet();
                    .getFieldData()
        assertThat(
        assertThat(stats.getTotal().getGet().getExistsCount(), equalTo(1L));
            Flag.Recovery };
            final IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
            indexTotal.add(indexStats.getTotal().queryCache);
                return response.getQueryCache() != null;
        assertThat(stats.getIndex("test1").getPrimaries().getDocs().getCount(), equalTo(2L));
        response = client().admin().indices().prepareStats("index").setQueryCache(true).get();
            greaterThan(0L)
                }
        for (Flag flag : values) {
        assertEquals(new RemoteTranslogStats(), remoteTranslogStats);
        assertThat(stats.getTotalShards(), equalTo(numShards1 + numShards2));
    }
                .get("field"),
        client().admin().indices().create(createIndexRequest).get();
                .get(1)
        assertThat(stats.getIndex("test2").getTotal().getSearch().getTotal().getFetchCurrent(), equalTo(0L));
            .clear()
            prepareCreate("test").setSettings(
import java.util.concurrent.atomic.AtomicBoolean;
            flags.writeTo(out);
        assertThat(stats.getPrimaries().getIndexing().getTotal().getIndexFailedCount(), equalTo(3L));
            });
        }
            .prepareStats("test")
                    .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "1")
        indicesStats = client().admin().indices().prepareStats("test").clear().setFieldData(true).setQueryCache(true).execute().actionGet();
        assertThat(stats.getTotal().getGet().getCount(), equalTo(1L));
        assertCumulativeQueryCacheStats(response);
import java.util.concurrent.CyclicBarrier;
import java.util.EnumSet;
        // now check the per field stats
        }
        stats = client().admin().indices().prepareStats().execute().actionGet();
                .setVersion(1)
                    .getMemorySizeInBytes(),
            });
        refreshAndWaitForReplication();
                .get(1)
                builder.setStore(set);
        while (!done) {
        final List<Thread> threads = new ArrayList<>(numberOfIndexingThreads + numberOfIndexingThreads);
            nodesStats.getNodes().get(0).getIndices().getFieldData().getFields().get("field") + nodesStats.getNodes()
                .setSize(0)
            assertCumulativeQueryCacheStats(stats);
            flags.set(flag, false);
                .execute()
        for (Flag flag : values) {
        assertThat(stats.getTotal().completion.getFields().containsField("baz.completion"), is(false));
                .getTotalHits()
                .getIndices()
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 1).build()
                break;
        assertThat(stats.getTotal().getStore(), nullValue());
            for (Flag flag : values) {
        assertThat(stats.getTotal().completion.getFields().get("bar.completion"), greaterThan(0L));
        );
        });
                assertThat(flags.isSet(flag), equalTo(readStats.isSet(flag)));
                .prepareNodesStats("data:true")
            .build();
        stats = builder.setIndices("*2").execute().actionGet();
        // make sure we see throttling kicking in:
        // document replication enabled index should return empty segment replication stats
import org.opensearch.index.cache.query.QueryCacheStats;
                equalTo((long) numDocs)
        long termUpto = 0;
        assertEquals(
            .actionGet();
                .setVersionType(VersionType.EXTERNAL)
            .prepareStats("test")
        IndicesStatsResponse stats;
@SuppressCodecs("*") // requires custom completion format
        if (isSegmentReplicationEnabledForIndex("test1") == false && isSegmentReplicationEnabledForIndex("test2") == false) {
 * compatible open source license.
        stats = builder.execute().actionGet();
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
                .setSettings(settingsBuilder().put("index.number_of_shards", 2))
        client().prepareIndex("test1").setId(Integer.toString(2)).setSource("field", "value").execute().actionGet();
        });
                .status()
        long totalExpectedWrites = test1ExpectedWrites + test2ExpectedWrites;
            }
        for (Flag flag : flags) { // set the flags
                    .getTotal()
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                final long maxSeqNo = shardStats.getSeqNoStats().getMaxSeqNo();
                .actionGet();
        assertThat(stats.getTotal().getStore(), notNullValue());
        assertEquals(stats1.getTotalCount(), stats2.getTotalCount());
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertAcked(prepareCreate("test1"));
        // clear all
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "200ms")
            client().prepareIndex("index").setId("2").setSource("foo", "baz")
        }
            assertSearchResponse(
        assertThat(flags.length, equalTo(Flag.values().length));
                for (IndexShard indexShard : indexService) {
            RestStatus.CREATED,
        final AtomicReference<List<Exception>> executionFailures = new AtomicReference<>(new CopyOnWriteArrayList<>());
        assertThat(stats.getTotal().getGet(), nullValue());
                client().admin()
                .get(1)
    public void testThrottleStats() throws Exception {
        stats = builder.setGroups("bar", "baz").execute().actionGet();
        ensureGreen(indexName);
    }
                .actionGet();
        for (Flag flag : values) {
            thread.start();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import static org.hamcrest.Matchers.nullValue;
        assertThat(stats.getTotal().getIndexing(), nullValue());
            .put("number_of_replicas", 0)
            nodesStats.getNodes().get(0).getIndices().getQueryCache().getMemorySizeInBytes() + nodesStats.getNodes()
            .actionGet();
                        .stream()
    }
            Flag.Refresh,
 * Unless required by applicable law or agreed to in writing,
            equalTo((long) numDocs)
            IndicesStatsResponse stats = client().admin().indices().prepareStats("index").setQueryCache(true).get();
        ForceMergeResponse forceMergeResponse = client().admin()
                .setMapping("field", "type=text,fielddata=true", "field2", "type=text,fielddata=true")
 * SPDX-License-Identifier: Apache-2.0
            .execute()
            assertThat(stats.getTotal().getIndexing().getTotal().getIndexCount(), equalTo(totalExpectedWrites));
    public void testQueryCache() throws Exception {
            set(flag, builder, true);
                .getIndices()
                .indices()
                .get(1)
                try {
                    .setRequestCache(true)
        assertThat(
            done = stats.getPrimaries().getIndexing().getTotal().getThrottleTime().millis() > 0;
import java.util.concurrent.ExecutionException;
        stats = builder.setCompletionFields("bar.completion").execute().actionGet();
                }
        assertThat(stats.getIndex("test1").getTotal().getIndexing().getTotal().getIndexCurrent(), equalTo(0L));
            );
        barrier.await();
                    .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.MINUS_ONE)
        assertAcked(
            .setFlush(true)
        ensureGreen();
                postClearNodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + postClearNodesStats.getNodes()
            equalTo(0L)
        IndicesStatsResponse stats = client().admin().indices().prepareStats().setSegments(true).get();
            threads.add(thread);
        }
        refreshAndWaitForReplication();
            greaterThan(0L)
        client().prepareSearch().addSort("field2", SortOrder.ASC).execute().actionGet();
import org.opensearch.action.search.SearchType;
            assertThat(stats.getTotal().queryCache.getHitCount(), equalTo(0L));
                .actionGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    final String id = Integer.toString(idGenerator.incrementAndGet());
                builder.setIndexing(set);
        assertThat(stats.getTotal().completion.getSizeInBytes(), greaterThan(0L));
        assertThat(
        assertAcked(
            greaterThan(0L)
        client().prepareIndex("test1")
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
        assertThat(stats.getTotal().getIndexing(), nullValue());
import java.util.Collections;
            case Merge:
                    .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), "2")
        client().prepareSearch().addSort("field", SortOrder.ASC).execute().actionGet();
                    .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), "2")
        assertThat(stats.getTotal().completion.getFields(), is(nullValue()));
        assertThat(stats.getTotal().completion.getFields().get("bar.completion"), greaterThan(0L));
        assertThat(stats.getTotal().completion.getFields().containsField("baz.completion"), is(false));
        client().prepareSearch().addSort("field2", SortOrder.ASC).execute().actionGet();
                StringBuilder sb = new StringBuilder();
                .setMapping("field", "type=text,fielddata=true")
            .setStore(false)
                .get(1)
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
                break;
                return response.getIndexing() != null;
        for (int i = 0; i < 10; i++) {
        }
        assertThat(stats.getTotal().getMerge(), notNullValue());
            case Translog:
    }
                .setSize(0)
            thread.join();
            client().prepareIndex("test2")
                .execute()
            .clear()
        assertThat(response.getTotal().queryCache.getEvictions(), greaterThan(0L));
 * ownership. Elasticsearch licenses this file to you under
        final CyclicBarrier barrier = new CyclicBarrier(1 + numberOfIndexingThreads + numberOfStatsThreads);
            if (random.nextBoolean()) {
        stats = builder.setIndices("test1", "test2").execute().actionGet();
            for (int i = 0; i < pageDocs; ++i) {
        assertThat(stats.getTotal().completion.getSizeInBytes(), greaterThan(0L));
        createIndex("test_index_2");
        logger.info("--> refreshing");
            IndicesStatsResponse stats = client().admin().indices().prepareStats("index").setQueryCache(true).get();
                .setId(Integer.toString(1))
        nodesStats = client().admin().cluster().prepareNodesStats("data:true").setIndices(true).execute().actionGet();
            Flag.Warmer,
        // increasing the number of shards increases the number of chances any one stats request will hit a race
                flags.add(flag);
import static org.hamcrest.Matchers.is;
        ensureGreen();
        assertThat(stats.getTotal().search.getGroupStats().get("bar").getQueryCount(), greaterThan(0L));
                .execute()
            .setFieldDataFields("*")
    }
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
            )
                .get(1)
    }
@ClusterScope(scope = Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
        assertThat(stats.getPrimaries().getIndexing().getTotal().getThrottleTime().millis(), equalTo(0L));
                    .getFieldData()
        client().admin().indices().prepareClearCache().setRequestCache(true).get(); // clean the cache
                .get(1)
            case Store:
            .setFieldData(true)
        assertThat(stats.getTotalShards(), equalTo(numShards1));
                .setIndices(true)
                .setSource("field", "value")
        ensureGreen();
        assertThat(stats.getTotal().completion.getFields().containsField("bar.completion"), is(true));
                "{ \"properties\": { \"bar\": { \"type\": \"text\", \"fields\": { \"completion\": { \"type\": \"completion\" }}}"
import org.opensearch.index.shard.IndexShard;
        assertThat(
        assertThat(
            .build();
        return Settings.builder().put(indexSettings());
            .prepareForceMerge("index")
        refreshAndWaitForReplication();
        });
        assertThat(stats.getIndex("test2").getTotal().getSearch().getTotal().getQueryCurrent(), equalTo(0L));
import org.opensearch.test.InternalSettingsPlugin;
            );
                Settings.builder()
                .getFieldData()
            client().admin()
import org.opensearch.core.rest.RestStatus;
                equalTo(0L)
            case RequestCache:
        {
        boolean done = false;
            equalTo(0L)
                .setSource("field", "value")
    }
        assertNotNull(stats.getIndex(indexName).getTotal().getSegments().getReplicationStats());
            Flag.Indexing,
        }
            refresh();
        assertThat(
            out.close();
                    .prepareStats("idx")
        IndicesStatsRequestBuilder builder = client().admin().indices().prepareStats();
                builder.setMerge(set);
                .getFieldData()
        stats = client().admin().indices().prepareStats().clear().setFlush(true).setRefresh(true).setMerge(true).execute().actionGet();
            .prepareStats("test")
                .actionGet();
        EnumSet<Flag> flags = EnumSet.noneOf(Flag.class);
        builder = client().admin().indices().prepareStats();
                    .get(1)
        Random random = random();
                .setIndices(true)
        switch (flag) {
                .setVersionType(VersionType.EXTERNAL)
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMissCount(),
            assertThat(
 *
                .setFieldData(true)
    @Override
        client().prepareIndex("test2").setId(Integer.toString(1)).setSource("field", "value").execute().actionGet();
            .setFieldData(true)
            flags.writeTo(out);
        );
        assertThat(stats.getIndex("test2").getTotal().getIndexing().getTotal().getIndexCurrent(), equalTo(0L));
                break;
        ensureGreen();
            Flag.Merge,
        assertThat(stats.getIndex("test2").getPrimaries().getDocs().getCount(), equalTo(1L));
                .setId(Integer.toString(1))
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getHitCount(),
            assertThat("ordinal has changed - this breaks the wire protocol. Only append to new values", i, equalTo(flags[i].ordinal()));
    private void assertEquals(QueryCacheStats stats1, QueryCacheStats stats2) {
            .execute()
        stats = builder.setIndices("_all").execute().actionGet();
                    indexShard.sync();
        assertAcked(
        assertAcked(prepareCreate("index").setSettings(settings).get());
        persistGlobalCheckpoint("index"); // Need to persist the global checkpoint for the soft-deletes retention MP.
import java.util.concurrent.atomic.AtomicReference;
        assertAcked(
        for (IndexStats indexStats : response.getIndices().values()) {
        client().prepareIndex("test_index").setId(Integer.toString(1)).setSource("field", "value").execute().actionGet();
                .setRequestCache(true)
            case Docs:
            nodesStats.getNodes().get(0).getIndices().getQueryCache().getMemorySizeInBytes() + nodesStats.getNodes()
        response = client().admin().indices().prepareStats("index").setQueryCache(true).get();
                .getTotalHits()
            .setDocs(false)
        // index docs until we have at least one doc on each shard, otherwise, our tests will not work
        indexRandomForConcurrentSearch("test");
        // nodesStats = client().admin().cluster().prepareNodesStats().setIndices(true).get();
                .setSize(0)
        latch.await(15, TimeUnit.SECONDS);
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
        );
        ensureGreen(indexName);
                builder.setWarmer(set);
        try {
        long start = System.currentTimeMillis();
        );
                .setSettings(Settings.builder().put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), false))
            }
        } catch (VersionConflictEngineException e) {}
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
        final AtomicInteger idGenerator = new AtomicInteger();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() },
                client().prepareSearch("index").setQuery(QueryBuilders.constantScoreQuery(QueryBuilders.matchQuery("foo", "baz"))).get()
        indexRandomForConcurrentSearch("test");
                .setSearchType(SearchType.QUERY_THEN_FETCH)
            .indices()
        );
        assertThat(stats.getTotal().completion.getFields().get("baz.completion"), greaterThan(0L));
        ensureGreen();
        });
            client().prepareSearch("idx")
        );
            assertThat(isSet(flag, stats.getTotal()), equalTo(true));
        assertThat(
import org.opensearch.common.unit.TimeValue;
        }
            assertThat(stats.getTotal().queryCache.getHitCount(), greaterThan(0L));
                }
                while (!stop.get()) {
                .getFieldData()
            .setQueryCache(true)
        stats = builder.setIndices("_all").execute().actionGet();
        // This assert should not be done on segrep enabled indices because we are asserting Indexing/Write operations count on
        assertEquals(DocWriteResponse.Result.DELETED, client().prepareDelete("index", "2").get().getResult());
        });
                nodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + nodesStats.getNodes()
package org.opensearch.indices.stats;
import org.opensearch.indices.IndicesService;
                    .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1")
        stats = builder.setGroups("*r").execute().actionGet();
        assertEquals(DocWriteResponse.Result.DELETED, client().prepareDelete("index", "1").get().getResult());
        for (Flag flag : values) {
        }
        assertAcked(prepareCreate("test_index"));
        assertThat(flags.anySet(), equalTo(true));
            for (int j = 0; j < 100; j++) {
            }
            Flag.Docs,
        assertEquals(total, indexTotal);
        logger.info("--> verifying that cache size is 0");
            assertThat(stats.getTotal().queryCache.getEvictions(), greaterThan(0L));
        assertThat(stats.getPrimaries().getIndexing().getTotal().getIndexFailedCount(), equalTo(0L));
        stats = client().admin()
        }
        for (Flag flag : EnumSet.complementOf(flags)) { // check the complement
        IndicesStatsResponse indicesStats = client().admin()
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
            client().admin()
     * This makes sure that the persisted global checkpoint on those shards will equal to the in-memory value.
            }
                    .indices()
            assertThat(
            )
        refresh();
                    .getMemorySizeInBytes(),
            greaterThan(0L)
            prepareCreate("test_index").setSettings(
                client().admin()
                builder.setDocs(set);
                );
                .getFieldData()
                return response.getFieldData() != null;
                    executionFailures.get().add(e);
            }
        // when OpenSearchIntegTestCase.after tries to remove indices created by the test:
            client().prepareIndex("test1")
                equalTo(0L)
        }
                    + ",\"baz\": { \"type\": \"text\", \"fields\": { \"completion\": { \"type\": \"completion\" }}}}}"
        );
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.IndexService;
        QueryCacheStats total = response.getTotal().queryCache;
                .setSource("field", "value1", "field2", "value1")
            case RequestCache:
            .indices()
            case Refresh:
import org.opensearch.search.sort.SortOrder;
import org.opensearch.indices.IndicesQueryCache;
        stats = builder.setGroups("*").execute().actionGet();
        } catch (VersionConflictEngineException e) {}
            .setFlush(true)
                return response.getSegments() != null;
                postClearNodesStats.getNodes().get(0).getIndices().getQueryCache().getMemorySizeInBytes() + postClearNodesStats.getNodes()
        assertBusy(() -> {
            thread.start();
        assertAllSuccessful(client().admin().indices().prepareClearCache("index").setQueryCache(true).get());
            indexRandom(true, builders);
        // missing get
            .setIndices(new CommonStatsFlags().set(CommonStatsFlags.Flag.FieldData, true).fieldDataFields("*"))
            .setPostFilter(QueryBuilders.termQuery("field", "value2"))
        stats = client().admin().indices().prepareStats().execute().actionGet();
            index("test_index", "_doc", Integer.toString(i), "field", "value");
        assertThat(stats.getTotal().getGet().getCount(), equalTo(2L));
        assertAcked(prepareCreate("test_index"));
                .get()
import org.opensearch.action.index.IndexRequestBuilder;
        client().prepareIndex("test").setId("1").setSource("field", "value1", "field2", "value1").execute().actionGet();
                    .getMemorySizeInBytes()
            client().prepareIndex("index").setId("1").setSource("foo", "bar"),
import java.util.List;
        final CountDownLatch latch = new CountDownLatch(1);
        // wait for a failure, or for fifteen seconds to elapse
            case Flush:
            .setIndexing(false)
            set(flag, builder, false);
            equalTo(0L)
 * not use this file except in compliance with the License.
        Random random = random();
            .prepareStats()
            .execute()
                }
                request.all();
        indexRandom(
                // Provoke slowish merging by making many unique terms:
import static org.hamcrest.Matchers.lessThan;
        super(settings);
        }
        assertThat(indicesStats.getTotal().getFieldData().getMemorySizeInBytes(), equalTo(0L));
        // the query cache has an optimization that disables it automatically if there is contention,
                break;
        assertThat(stats.getTotal().completion.getFields().containsField("bar.completion"), is(true));
            .setFieldData(true)
            prepareCreate("test").setSettings(
                builder.setSearch(set);
                    .setId(Integer.toString(counter++))
            .setMerge(true)
        NodesStatsResponse nodesStats = client().admin().cluster().prepareNodesStats("data:true").setIndices(true).execute().actionGet();
                    .getIndices()
    /**
            );
                return response.getFlush() != null;
        IndicesStatsRequestBuilder builder = client().admin().indices().prepareStats();
        RemoteTranslogStats remoteTranslogStatsFromNodesStats = nodesStatsResponse.getNodes()
        return Collections.singleton(InternalSettingsPlugin.class);
                .getFieldData()
    }
                    assertThat(response.getResult(), equalTo(DocWriteResponse.Result.CREATED));
        assertThat(stats.getTotal().getStore(), nullValue());
        ShardStats shard = client().admin().indices().prepareStats(indexName).setSegments(true).setTranslog(true).get().getShards()[0];
        return Arrays.asList(
        IndicesStatsResponse stats = builder.execute().actionGet();
        assertEquals(total, shardTotal);
        assertThat(stats.getTotal().search.getGroupStats().containsKey("baz"), is(false));
            nodesStats.getNodes().get(0).getIndices().getFieldData().getFields().get("field") + nodesStats.getNodes()
    }
        // ignore this assert check for segrep enabled indices.
        assertThat(stats.getTotal().getGet().getMissingCount(), equalTo(1L));
            );
                return response.getWarmer() != null;
        }
        long test2ExpectedWrites = test2.dataCopies;
        // rely on 1 replica for this tests
            assertThat(
        assertThat(
                    sb.append(termUpto++);
        assertThat(
            .setDocs(false)
            .put(super.indexSettings())
     * Test that we can safely concurrently index and get stats. This test was inspired by a serialization issue that arose due to a race
            assertThat(stats.getTotal().queryCache.getHitCount(), greaterThan(0L));
                return response.getStore() != null;
        createIndex(
            assertThat(
        assertThat(stats.getPrimaries().getIndexing().getTotal().isThrottled(), equalTo(false));
import org.opensearch.plugins.Plugin;
        assertThat(
        assertThat(indicesStats.getTotal().getQueryCache().getMemorySizeInBytes(), greaterThan(0L));
        assertThat(stats.getIndex("test1").getPrimaries().getFlush(), notNullValue());
        for (int i = 0; i < 20; i++) {
                break;
            .setSource("{\"bar\":\"bar\",\"baz\":\"baz\"}", MediaTypeRegistry.JSON)
        assertThat(stats.getTotal().getSegments(), notNullValue());
        assertThat(response.getTotal().queryCache.getHitCount(), greaterThan(0L));
    @Override
                greaterThan(0L)
                .actionGet();
        assertThat(indicesStats.getTotal().getQueryCache().getMemorySizeInBytes(), equalTo(0L));
            client().prepareIndex("index").setId("2").setSource("foo", "baz")
        client().prepareIndex("test2").setId(Integer.toString(1)).setSource("field", "value").execute().actionGet();
                .indices()
        assertBusy(() -> {
        // Optimize & flush and wait; else we sometimes get a "Delete Index failed - not acked"
    public void testGroupsParam() throws Exception {
        assertThat(stats.getTotal().search.getGroupStats().get("bar").getQueryCount(), greaterThan(0L));
        String indexName = "test-index";
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(stats.getTotal().getMerge().getTotal(), greaterThan(0L));
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(
                return response.getSearch() != null;
        client().admin().indices().prepareForceMerge().setMaxNumSegments(1).execute().actionGet();
            default:
            .get(0)
        client().prepareIndex("test1").setId(Integer.toString(1)).setSource("field", "value").execute().actionGet();
                .execute()
        // Filter/Query cache is cleaned periodically, default is 60s, so make sure it runs often. Thread.sleep for 60s is bad
        while (true) {
import org.apache.lucene.tests.util.LuceneTestCase.SuppressCodecs;
            case QueryCache:
        );
        refreshAndWaitForReplication();
        // start threads that will get stats concurrently with indexing
        assertEquals(stats2.getMemorySizeInBytes(), stats2.getMemorySizeInBytes());
            Flag.Completion,
            .execute()
    }
        for (Flag flag : values) {
                }
                sb.append(' ');
import org.opensearch.index.query.QueryBuilders;
 * this file be licensed under the Apache-2.0 license or a
                .value(),
            case Search:
        stats = builder.execute().actionGet();
        indexRandom(true, builders);
                builder.setCompletion(set);
        RemoteSegmentStats remoteSegmentStatsFromNodesStats = nodesStatsResponse.getNodes()
                .get()
            client().admin()
        );
            }
        assertThat(stats.getIndex("test1").getTotal().getDocs().getCount(), equalTo(test1ExpectedWrites));
        stats = builder.setCompletionFields("*").execute().actionGet();
        );
            lessThan(
            client().admin()
    }
        }
 *
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        }
            greaterThan(0L)
        assertThat(stats.getIndex("test1").getPrimaries().getRefresh(), notNullValue());
 * Licensed to Elasticsearch under one or more contributor
                        latch.countDown();
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import java.util.concurrent.CountDownLatch;
            }
        assertThat(stats.getTotal().completion.getSizeInBytes(), greaterThan(0L));
import org.opensearch.action.admin.indices.stats.IndicesStatsRequestBuilder;
        // make sure that number of requests in progress is 0
        assertCumulativeQueryCacheStats(response);
        }
 * license agreements. See the NOTICE file distributed with
            Flag.Search,
            equalTo((long) numDocs)
            indicesStats.getTotal().getFieldData().getFields().get("field"),
        assertThat(stats.getTotal().getSearch(), nullValue());
        final AtomicBoolean stop = new AtomicBoolean();
            "test",
                sb.append(" some random text that keeps repeating over and over again hambone");
import java.util.concurrent.atomic.AtomicInteger;
/*
        assertThat(stats.getTotal().getRefresh(), notNullValue());
                    shardStats.getRetentionLeaseStats()
                .getFieldData()
            true,
            case Completion:
import org.opensearch.common.io.stream.BytesStreamOutput;
            client().prepareSearch("idx")
            case Store:
                    .getTotal()
        {
            client().prepareSearch("idx").setSearchType(SearchType.QUERY_THEN_FETCH).setSize(0).get().getHits().getTotalHits().value(),
                        }
        createIndex(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
                .prepareCreate("test")
        assertThat(stats.getTotal().getMerge(), notNullValue());
            equalTo((long) numDocs)
        assertThat(getResponse.isExists(), equalTo(false));
            .setRefresh(true)
        IndicesStatsResponse stats = builder.execute().actionGet();
        assertThat(stats.getTotal().getGet().getMissingCount(), equalTo(0L));
        refreshAndWaitForReplication();
        ensureGreen();
                    final IndexResponse response = client().prepareIndex("test").setId(id).setSource("{}", MediaTypeRegistry.JSON).get();
    private void assertZeroRemoteTranslogStats(RemoteTranslogStats remoteTranslogStats) {
                .setVersion(1)
import static org.hamcrest.Matchers.greaterThan;
        String indexName = "test-index";
                .value(),
                .getIndices()
            equalTo(0L)
    public void testFieldDataStats() throws Exception {
        assertThat(stats.getIndex("test1").getTotal().getSearch().getTotal().getFetchCurrent(), equalTo(0L));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .getRemoteSegmentStats();
        stop.set(true);
import org.opensearch.action.support.WriteRequest;
            set(flag, builder, true);
        ensureGreen();
        assertThat(response.getTotal().queryCache.getCacheCount(), greaterThan(0L));
        for (final Thread thread : threads) {
        assertThat(
                settingsBuilder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
 * You may obtain a copy of the License at
                greaterThan(0L)
        // so we run it in an assertBusy block which should eventually succeed
            for (Flag flag : values) {
            threads.add(thread);
        for (Flag flag : values) {
                    assertThat(indexShard.getLastSyncedGlobalCheckpoint(), equalTo(indexShard.getLastKnownGlobalCheckpoint()));
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
                .clear()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                assertThat(flags.isSet(flag), equalTo(readStats.isSet(flag)));
            IndexRequestBuilder[] builders = new IndexRequestBuilder[pageDocs];
                .setVersion(1)
                .getHits()
        stats = builder.setIndices("*").execute().actionGet();
            .addSort("field", SortOrder.ASC)
            IndicesStatsResponse postClearIndicesStats = client().admin()
        assertThat(
        assertThat(stats.getTotal().getFlush(), notNullValue());
        client().admin().indices().prepareForceMerge("test").get();
        refresh();
        IndicesStatsResponse stats = builder.execute().actionGet();
            .setRefresh(true)
        assertThat(stats.getIndex("test2").getTotal().getDocs().getCount(), equalTo(test2ExpectedWrites));
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        assertThat(stats.getTotal().search.getGroupStats().containsKey("baz"), is(false));
 */
        flush();
    private Settings.Builder settingsBuilder() {
        assertBusy(() -> {
import org.opensearch.action.admin.indices.stats.CommonStats;
    public void testEncodeDecodeCommonStats() throws IOException {
        stats = builder.setIndices("test1").execute().actionGet();
        client().prepareIndex("test_index").setId(Integer.toString(2)).setSource("field", "value").execute().actionGet();
            .actionGet();
            );
                break;
        IndicesStatsResponse response = client().admin().indices().prepareStats("index").setQueryCache(true).get();
    private static void set(Flag flag, IndicesStatsRequestBuilder builder, boolean set) {
        IndicesStatsRequestBuilder builder = client().admin().indices().prepareStats();
            }
        ensureGreen();
            case Warmer:
            Flag.Translog,
                .execute()
                .getIndices()
            case Warmer:
            default:
    public void testMergeStats() {
                    .getTotal()
        assertThat(stats.getTotal().completion.getFields().get("bar.completion"), greaterThan(0L));
                .prepareUpdateSettings("idx")
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            case Flush:
    }
            if (allHaveDocs) {
            Settings.builder().put("index.number_of_shards", 10).build()
        client().admin().indices().prepareClearCache().execute().actionGet();
        assertThat(
            assertSearchResponse(
        assertThat(flags.anySet(), equalTo(false));
        stats = builder.setCompletionFields("bar.completion", "baz.completion").execute().actionGet();
            case Indexing:
            assertThat(isSet(flag, stats.getPrimaries()), equalTo(false));
        indicesStats = client().admin().indices().prepareStats("test").clear().setFieldData(true).execute().actionGet();
        client().admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();
        client().prepareSearch()
        assertThat(response.getTotal().queryCache.getCacheSize(), equalTo(0L));
        client().prepareIndex("test1").setId(Integer.toString(2)).setSource("field", "value").execute().actionGet();
        getResponse = client().prepareGet("test2", "2").execute().actionGet();
            .getIndices()
                } catch (final BrokenBarrierException | InterruptedException e) {
        // segment replication enabled index should return segment replication stats
            case Recovery:
                .value(),
        });
            .clear() // reset defaults
            assertThat(isSet(flag, stats.getTotal()), equalTo(false));
            stats = client().admin().indices().prepareStats().execute().actionGet();
        // we need to flush and make that commit safe so that the SoftDeletesPolicy can drop everything.
import java.util.Collection;
                .getIndices()
    }
                    .setRequestCache(true)
import org.opensearch.index.MergeSchedulerConfig;
            numDocs += pageDocs;
import org.opensearch.index.engine.VersionConflictEngineException;
 *    http://www.apache.org/licenses/LICENSE-2.0
            new CopyOnWriteArrayList<>()
public class IndexStatsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }
    }
        assertThat(stats.getTotal().getRefresh(), notNullValue());
            .setStore(false)
                        if (response.getFailedShards() > 0) {
        assertThat(stats.getTotal().getMerge(), notNullValue());
            client().admin().indices().prepareFlush().execute().actionGet();
        assertThat(flags.anySet(), equalTo(true));
            assertCumulativeQueryCacheStats(stats);
        );
        assertThat(stats.getTotal().search.getGroupStats().get("bar").getQueryCount(), greaterThan(0L));
        stats = client().admin().indices().prepareStats().setMerge(true).execute().actionGet();
            flags.set(flag, true);
        assertThat(indicesStats.getTotal().getFieldData().getMemorySizeInBytes(), greaterThan(0L));
    public static Collection<Object[]> parameters() {
import org.opensearch.action.get.GetResponse;
                .getQueryCache()
                .cluster()
                .prepareCreate("test")
        assertThat(stats.getPrimaries().getIndexing().getTotal().getThrottleTime().millis(), equalTo(0L));
                .getMemorySizeInBytes(),
    }
            .get();
        }
        assertThat(response.getTotal().queryCache.getMissCount(), greaterThan(0L));
                    .getMemorySizeInBytes(),
            .execute()
        );
            thread.setName("stats-" + i);
        assertAllSuccessful(forceMergeResponse);
        client().admin().indices().prepareClearCache().setRequestCache(true).get(); // clean the cache
                    .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1")
                    .getRequestCache()
        }
                        .allMatch(retentionLease -> retentionLease.retainingSequenceNumber() == maxSeqNo + 1)
            nodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + nodesStats.getNodes()
                .getIndices()
                    .get()
                .getFieldData()
                    .get()
        }
        IndicesStatsResponse stats = builder.execute().actionGet();
                assertTrue(
        assertThat(stats.getTotal().search.getGroupStats().get("baz").getQueryCount(), greaterThan(0L));
    @ParametersFactory
                .get()
    }
        }
    }
                break;
        assertThat(response.getTotal().queryCache.getMemorySizeInBytes(), equalTo(0L));
            greaterThan(0L)
                    .getRequestCache()
            lessThan(indicesStats.getTotal().getFieldData().getMemorySizeInBytes())
        assertThat(stats.getTotal().getSearch(), nullValue());
    }
        assertThat(indicesStats.getTotal().getFieldData().getMemorySizeInBytes(), greaterThan(0L));
                builder.setGet(set);
                break;
            // nodesStats = client().admin().cluster().prepareNodesStats().setIndices(true).get();
        assertThat(stats.getIndex("test1").getTotal().getSearch().getTotal().getQueryCurrent(), equalTo(0L));
                .get()
 * Modifications Copyright OpenSearch Contributors. See
        refresh();
                return response.getGet() != null;
                    .prepareStats("idx")
                    .getIndices()
                .get()
        assertThat(stats.getTotal().completion.getFields().containsField("baz.completion"), is(true));
            .setPostFilter(QueryBuilders.termQuery("field", "value1"))
        // set the index level setting to false, and see that the reverse works
            false,
     */
                    .indices()
        for (int i = 0; i < 100; i++) {
    }
        assertThat(stats.getTotal().completion.getFields().get("baz.completion"), greaterThan(0L));
            CommonStatsFlags readStats = new CommonStatsFlags(bytes.streamInput());
            Flag.RequestCache,
        indicesStats = client().admin().indices().prepareStats("test").clear().setFieldData(true).setQueryCache(true).execute().actionGet();
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
            assertCumulativeQueryCacheStats(stats);
                    executionFailures.get().add(e);
            .setMaxNumSegments(1)
import java.util.Arrays;
                    .setRequestCache(true)
        assertThat(stats.getTotal().getSegments().getCount(), equalTo((long) test1.totalNumShards));
        assertThat(executionFailures.get(), emptyCollectionOf(Exception.class));
        // sort to load it to field data...
            fail("Expected a version conflict");
                .setSource("field", "value")
                    .getIndices()
            greaterThan(0L)
                            failed.set(true);
            .setMerge(true)
        refreshAndWaitForReplication();
            set(flag, builder, false); // clear all
        Flag[] flags = new Flag[] {
    }
    }
        refresh();
import org.opensearch.index.VersionType;
        assertThat(stats.getIndex("test2").getPrimaries().getIndexing().getTotal().getIndexFailedCount(), equalTo(2L));
                break;
                .getMemorySizeInBytes(),
        refresh();
                        executionFailures.get().add(e);
                }
        assertThat(stats.getTotal().completion.getFields().containsField("bar.completion"), is(true));
                equalTo((long) numDocs)
        assertThat(stats.getPrimaries().getIndexing().getTotal().getIndexCount(), equalTo(3L));
                .getMemorySizeInBytes(),
        final int numberOfStatsThreads = 4 * numberOfIndexingThreads;
        indexName = "test-index2";
import static org.hamcrest.Matchers.notNullValue;
            }
                    .getQueryCache()
        // test explicit request parameter
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
        indexRandom(
                .getHits()
            builders[i] = client().prepareIndex("idx")
                .indices()
            .get();
            client().prepareIndex("index").setId("1").setSource("foo", "bar"),
        });
            .cluster()
            );
        );
            nodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + nodesStats.getNodes()
        // Compare with fresh object because all values default to 0 in default fresh object
    public void testCompletionFieldsParam() throws Exception {
        );
        );
        stats = builder.execute().actionGet();
        assertThat(getResponse.isExists(), equalTo(true));
        // since refresh will not refresh anything on a shard that has 0 docs and its search response get cached
     * getting doc stats during heavy indexing. The race could lead to deleted docs being negative which would then be serialized as a
        long test1ExpectedWrites = 2 * test1.dataCopies;
        NumShards test1 = getNumShards("test_index");
        // In order to instruct the merge policy not to keep a fully deleted segment,
    }
                .get(1)
        persistGlobalCheckpoint("index");
 * specific language governing permissions and limitations
            case Search:
        assertCumulativeQueryCacheStats(response);
        }
        assertBusy(() -> {
                builder.setRequestCache(set);
        assertThat(
        assertThat(stats.getTotalShards(), equalTo(numShards1 + numShards2));
        assertThat(stats.getTotal().search.getGroupStats().get("baz").getQueryCount(), greaterThan(0L));
        GetResponse getResponse = client().prepareGet("test2", "1").execute().actionGet();
            case Get:
                .getTotalHits()
                return response.getTranslog() != null;
            );
            fail("Expected a version conflict");
                .getFields()
            client().prepareSearch("idx")
            equalTo(0L)
                    barrier.await();
                .get()
                    .indices()
                .getMemorySizeInBytes(),
                    .getRequestCache()
        assertThat(
        for (int i = 0; i < 100; i++) {
 */
            .getRemoteTranslogStats();
        assertBusy(() -> {
        client().prepareSearch("_all").setStats("bar", "baz").execute().actionGet();
        Flag[] values = CommonStatsFlags.Flag.values();
import static org.hamcrest.Matchers.equalTo;
        );
    }
                    allHaveDocs = false;
    }
        );
                    .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "10000")
                    .get(1)
            assertThat(stats.getTotal().queryCache.getMissCount(), greaterThan(0L));
        IndicesStatsResponse stats = client().admin().indices().prepareStats().execute().actionGet();
                client().prepareIndex("test").setId("" + termUpto).setSource("field" + (i % 10), sb.toString()).get();
                return response.getCompletion() != null;
            .get(0)
        );
                        failed.set(true);
        client().admin().indices().prepareFlush().get();
 */
        client().prepareIndex("test").setId("2").setSource("field", "value2", "field2", "value2").execute().actionGet();
            NodesStatsResponse postClearNodesStats = client().admin()
            }
            greaterThan(0L)
                .getIndices()
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), true)
        assertThat(stats.getTotal().getGet(), nullValue());
        assertThat(
                .setSearchType(SearchType.QUERY_THEN_FETCH)
        // check flags
        );
        client().prepareIndex("test1").setId(Integer.toString(1)).setSource("field", "value").execute().actionGet();
        }
            .build();
                postClearNodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + postClearNodesStats.getNodes()
            case FieldData:
        assertAcked(
                .setVersionType(VersionType.EXTERNAL)
            case FieldData:
            case Docs:
                .setSource(jsonBuilder().startObject().field("common", "field").field("str_value", "s" + i).endObject());
                    .get(1)
                }
            nodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + nodesStats.getNodes()
            case Refresh:
import java.io.IOException;
        );
 * GitHub history for details.
        assertThat(flags.anySet(), equalTo(true));
        assertThat(indicesStats.getTotal().getFieldData().getFields().get("field"), greaterThan(0L));
        client().prepareIndex("test").setId("1").setSource("field", "value1").execute().actionGet();
        client().prepareIndex("test").setId("2").setSource("field", "value2").execute().actionGet();
            equalTo(0L)
        // Provoke slowish merging by making many unique terms:
        );
        stats = builder.setGroups("bar").execute().actionGet();
                .get()
        ensureGreen();
                .getQueryCache()
                .build()
        assertThat(stats.getTotal().search.getTotal().getQueryCount(), greaterThan(0L));
    }
import org.opensearch.index.IndexSettings;
            .setId(Integer.toString(1))
            case Segments:
            .getSegments()
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
    }
        assertThat(stats.getTotal().completion.getFields().containsField("bar.completion"), is(true));
        switch (flag) {
        Flag[] values = CommonStatsFlags.Flag.values();
}
        return Settings.builder()
        }
            .setIndexing(false)
            for (int i = 0; i < 100; i++) {
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
        ensureGreen();
        flags.set(values[random.nextInt(values.length)], false);
        createIndex("test1");
                    .getMemorySizeInBytes(),
        assertThat(stats.getIndex("test1").getTotal().getIndexing().getTotal().getDeleteCurrent(), equalTo(0L));
                .setId(Integer.toString(1))
        client().admin().indices().prepareClearCache().setFieldDataCache(true).execute().actionGet();
                break;
        logger.info("test: test done");
    public IndexStatsIT(Settings settings) {
                builder.setTranslog(set);
        for (Flag flag : values) {
 * KIND, either express or implied.  See the License for the
        // release the hounds
        assertThat(
        );
        assertEquals(stats1.getCacheSize(), stats2.getCacheSize());
        assertThat(
        }
                } catch (final BrokenBarrierException | InterruptedException e) {
                .setSettings(settingsBuilder().put("index.number_of_replicas", 0).put("index.number_of_shards", 2))
                    refresh();
            .setFlush(true)
            final Thread thread = new Thread(() -> {
    public void testZeroRemoteStoreStatsOnNonRemoteStoreIndex() {
        assertThat(indicesStats.getTotal().getFieldData().getMemorySizeInBytes(), equalTo(0L));
            .indices()
        assertThat(response.getTotal().queryCache.getCacheSize(), equalTo(0L));
        // clear all
        assertThat(stats.getTotal().completion.getFields().containsField("baz.completion"), is(true));
            client().prepareIndex("test2")
        stats = client().admin().indices().prepareStats().execute().actionGet();
                    sb.append(' ');
        IndicesStatsResponse indicesStats = client().admin()
            equalTo(0L)
        assertAcked(
            .execute()
            case Translog:
            )
                builder.setQueryCache(set);
            case Segments:
            case Merge:
        assertThat(stats.getPrimaries().getDocs().getCount(), equalTo(3L));
import org.opensearch.action.DocWriteResponse;
            new Object[] { Settings.builder().put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build() }
            .getIndices()
        QueryCacheStats shardTotal = new QueryCacheStats();
                .getIndices()
            assertThat(isSet(flag, stats.getPrimaries()), equalTo(true));
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.action.admin.indices.stats.CommonStatsFlags.Flag;
                break;
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            case Recovery:
            assertThat(
        );
            Settings.builder()
            )
                return response.getRequestCache() != null;
    private void assertCumulativeQueryCacheStats(IndicesStatsResponse response) {
        assertThat(stats.getTotal().getDocs().getCount(), equalTo(totalExpectedWrites));
            assertThat(postClearIndicesStats.getTotal().getFieldData().getMemorySizeInBytes(), equalTo(0L));
                    } catch (final ExecutionException | InterruptedException e) {
            equalTo((long) numDocs)
        indicesStats = client().admin()
            prepareCreate("test1").setMapping(
        assertThat(stats.getTotal().getSegments().getIndexWriterMemoryInBytes(), greaterThan(0L));
                fail("new flag? " + flag);
        assertAcked(
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMissCount(),
            fail("Expected a version conflict");
                equalTo(0L)
        for (String node : nodes) {
                    failed.set(true);
        assertEquals(stats1.getHitCount(), stats2.getHitCount());
                flags.set(flag, random.nextBoolean());
        assertThat(stats.getTotal().completion.getFields().get("bar.completion"), greaterThan(0L));
        createIndex("test2");
        ensureGreen();
            .addSort("field", SortOrder.ASC)
import org.opensearch.common.settings.Settings;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
import org.opensearch.index.TieredMergePolicyProvider;
                if (stats.getStats().getDocs().getCount() == 0) {
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0)
        // stop all threads and wait for them to complete
        client().prepareIndex("test1").setId(Integer.toString(1)).setSource("foo", "bar").execute().actionGet();
                while (!stop.get()) {
        );
/*
        for (int i = 0; i < numberOfStatsThreads; i++) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        client().prepareSearch().addSort("field", SortOrder.ASC).execute().actionGet();
        final CreateIndexRequest createIndexRequest = new CreateIndexRequest(
            BytesStreamOutput out = new BytesStreamOutput();
            .getTranslog()
        );
                break;
                .cluster()
        assertThat(stats.getIndex("test2").getTotal().getIndexing().getTotal().getDeleteCurrent(), equalTo(0L));
        }
 * The OpenSearch Contributors require contributions made to
        RemoteSegmentStats remoteSegmentStatsFromIndexStats = shard.getStats().getSegments().getRemoteSegmentStats();
        refreshAndWaitForReplication();
        // all primary and replica shards. But in case of segrep, Indexing/Write operation don't happen on replica shards. So we can
import org.opensearch.core.xcontent.MediaTypeRegistry;
            Flag.FieldData,
        for (int i = 0; i < 10; i++) {
        NumShards test2 = getNumShards("test2");
                client().prepareSearch("index").setQuery(QueryBuilders.constantScoreQuery(QueryBuilders.matchQuery("foo", "baz"))).get()
        nodesStats = client().admin().cluster().prepareNodesStats("data:true").setIndices(true).execute().actionGet();
        assertBusy(() -> {
                .getMemorySizeInBytes(),
                .getIndices()
                        .leases()
import org.opensearch.index.remote.RemoteSegmentStats;
                equalTo(0L)
        IndicesStatsRequestBuilder builder = client().admin().indices().prepareStats();
                    .get(1)
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
        QueryCacheStats indexTotal = new QueryCacheStats();
                .indices()
        assertThat(
    }
                    .getMemorySizeInBytes(),
        assertThat(stats.getTotalShards(), equalTo(numShards2));
            .actionGet();
                    .getIndices()
            true,
        // index failed
        stats = builder.setCompletionFields("*r*").execute().actionGet();
            client().prepareIndex(indexName)
            out.close();
            equalTo(0L)
                .setRequestCache(true)
        assertThat(stats.getTotal().getDocs(), nullValue());
            .indices()
        );
            assertThat(stats.getTotal().queryCache.getMemorySizeInBytes(), greaterThan(0L));
import org.opensearch.action.admin.indices.stats.IndexStats;
            final Thread thread = new Thread(() -> {
            .clear() // reset defaults
                            shardFailures.get().addAll(Arrays.asList(response.getShardFailures()));
                return response.getRefresh() != null;
        return Settings.builder()
                builder.setRefresh(set);
                break;
            assertThat(stats.getTotal().queryCache.getCacheSize(), greaterThan(0L));
            Flag.Flush,
        );
                        .retentionLeases()
 * this work for additional information regarding copyright
     * that we can continue to get stats while indexing.
        assertThat(
                }
 * software distributed under the License is distributed on an
     * ({@link StreamOutput#writeVLong(long)}), the stream would become corrupted. Here, we want to test
            assertThat(stats.getTotal().queryCache.getCacheSize(), greaterThan(0L));
        assertZeroRemoteTranslogStats(remoteTranslogStatsFromNodesStats);
            )
        // Here we are testing that a fully deleted segment should be dropped and its cached is evicted.
    /**
            client().prepareIndex("test").setId("" + termUpto).setSource("field" + (i % 10), sb.toString()).get();
                fail("new flag? " + flag);
    public Settings indexSettings() {
            Flag.Segments,
    }
        assertThat(stats.getTotalShards(), equalTo(numShards1 + numShards2));
                .setId(Integer.toString(i))
        assertThat(stats.getTotal().getGet().getExistsCount(), equalTo(1L));
        NodesStatsResponse nodesStatsResponse = client().admin().cluster().prepareNodesStats(primaryNodeName(indexName)).get();
        createIndex(indexName, Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build());
            case Indexing:
            .put(super.nodeSettings(nodeOrdinal))
        assertThat(stats.getTotal().getIndexing(), nullValue());
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        );
        }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    private static boolean isSet(Flag flag, CommonStats response) {
                .execute()
            Flag.Get,
            client().prepareIndex("test_index").setId(Integer.toString(i)).setSource("field", "value").execute().actionGet();
            .put(indexSettings())
        assertThat(stats.getIndex("test1").getPrimaries().getMerge(), notNullValue());
    }
        assertThat(stats.getTotal().getDocs(), nullValue());
        // index the data again...
        assertThat(response.getTotal().queryCache.getEvictions(), greaterThan(0L));
        try {
            .actionGet();
            boolean allHaveDocs = true;
            equalTo(0L)
                client().admin()
        ensureGreen();
import java.util.ArrayList;
        logger.info("test: now optimize");
            assertThat(isSet(flag, stats.getTotal()), equalTo(true));
                    .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), "2")
            CommonStatsFlags readStats = new CommonStatsFlags(bytes.streamInput());
        );
        );
                settingsBuilder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
                return response.getRecoveryStats() != null;
        assertAcked(
 * under the License.
        // check get
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                builder.setFieldData(set);
        assertEquals(stats1.getMissCount(), stats2.getMissCount());
        assertThat(stats.getTotal().search.getGroupStats().get("bar").getQueryCount(), greaterThan(0L));
                .prepareNodesStats("data:true")
                    .setSource(jsonBuilder().startObject().field("common", "field").field("str_value", "s" + i).endObject());
        for (int i = 0; i < numberOfIndexingThreads; i++) {
    public void testConcurrentIndexingAndStatsRequests() throws BrokenBarrierException, InterruptedException, ExecutionException {
            assertThat(
    public void testFlagOrdinalOrder() {
            BytesReference bytes = out.bytes();
import org.opensearch.core.common.io.stream.StreamOutput;
    public void testClearAllCaches() throws Exception {
        long termUpto = 0;
        final int numberOfIndexingThreads = Runtime.getRuntime().availableProcessors();
        assertZeroRemoteSegmentStats(remoteSegmentStatsFromIndexStats);
                break;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
            BytesReference bytes = out.bytes();
        Settings settings = Settings.builder()
            .prepareNodesStats("data:true")
            assertThat(stats.getTotal().queryCache.getMissCount(), greaterThan(0L));
                fail("index throttling didn't kick in after 5 minutes of intense merging");
            assertThat(isSet(flag, stats.getPrimaries()), equalTo(false));
import org.opensearch.index.translog.RemoteTranslogStats;
            for (final ShardStats shardStats : client().admin().indices().prepareStats("index").get().getIndex("index").getShards()) {
            }
            );
        int numShards1 = getNumShards("test1").totalNumShards;
            if (System.currentTimeMillis() - start > 300 * 1000) { // Wait 5 minutes for throttling to kick in
            .indices()
            .actionGet();
        for (Flag flag : flags) { // check the flags
        int numShards2 = getNumShards("test2").totalNumShards;
     * Persist the global checkpoint on all shards of the given index into disk.
            );
        assertZeroRemoteSegmentStats(remoteSegmentStatsFromNodesStats);
                    break;
                .setId(UUIDs.randomBase64UUID())
            thread.setName("indexing-" + i);
        int counter = 0;
    public void testSegmentReplicationStats() {
                for (int j = 0; j < 100; j++) {
            for (Flag flag : values) {
                client().prepareSearch("idx").setSearchType(SearchType.QUERY_THEN_FETCH).setSize(0).get().getHits().getTotalHits().value(),
                sb.append(termUpto++);
                break;
            nodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + nodesStats.getNodes()
        assertThat(indicesStats.getTotal().getQueryCache().getMemorySizeInBytes(), equalTo(0L));
     */
        assertThat(stats.getTotal().completion.getSizeInBytes(), greaterThan(0L));
            .indices()
                break;
        assertAllSuccessful(response);
            case QueryCache:
            nodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + nodesStats.getNodes()
        ensureGreen();
import org.opensearch.action.admin.indices.stats.ShardStats;
        assertThat(stats.getTotal().search.getGroupStats(), is(nullValue()));
    public void testNonThrottleStats() throws Exception {
                .get(1)
        RemoteTranslogStats remoteTranslogStatsFromIndexStats = shard.getStats().getTranslog().getRemoteTranslogStats();
        assertThat(response.getTotal().queryCache.getHitCount(), greaterThan(0L));
     * variable-length long. Since serialization of negative longs using a variable-length format was unsupported
        assertEquals(0, response.getTotal().queryCache.getCacheSize());
                break;
/*
            assertSearchResponse(
                .prepareStats("test")
            );
            assertThat(stats.getTotal().queryCache.getMissCount(), greaterThan(0L));
        stats = client().admin().indices().prepareStats().execute().actionGet();
        refresh();
        assertThat(indicesStats.getTotal().getFieldData().getMemorySizeInBytes(), greaterThan(0L));
                    .getMemorySizeInBytes(),
        stats = client().admin().indices().prepareStats().execute().actionGet();
            for (ShardStats stats : client().admin().indices().prepareStats("idx").setDocs(true).get().getShards()) {
        );
        logger.info("--> force merging to a single segment");
                final IndicesStatsRequest request = new IndicesStatsRequest();
        // sort to load it to field data and filter to load filter cache
        assertThat(stats.getIndex("test1").getPrimaries().getStore(), notNullValue());
        } catch (VersionConflictEngineException e) {}
                if (i % 2 == 0) {
        IndicesStatsRequestBuilder builder = client().admin().indices().prepareStats();
        );
                .indices()
        stats = client().admin().indices().prepareStats().setSegments(true).get();
            );
        createIndex("test1", "test2");
            NodesStatsResponse postClearNodesStats = client().admin()
            assertThat(isSet(flag, stats.getPrimaries()), equalTo(true));
            IndicesStatsResponse stats = client().admin().indices().prepareStats("index").setQueryCache(true).get();
        );
            .actionGet();
        IndicesStatsResponse stats;
                .setSettings(Settings.builder().put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true))
        for (int i = 0; i < flags.length; i++) {
            Flag.Store,
        assertThat(
            StringBuilder sb = new StringBuilder();
                shardTotal.add(shardStats.getStats().queryCache);
                client().prepareSearch("idx").setSearchType(SearchType.QUERY_THEN_FETCH).setSize(0).get().getHits().getTotalHits().value(),
        );
        final AtomicReference<List<DefaultShardOperationFailedException>> shardFailures = new AtomicReference<>(
        IndicesStatsResponse stats = builder.execute().actionGet();
        assertNotNull(stats.getIndex(indexName).getTotal().getSegments().getReplicationStats());
import org.opensearch.common.UUIDs;
import java.util.Set;
        );
        // sort to load it to field data...
    protected Settings nodeSettings(int nodeOrdinal) {
    public void testSimpleStats() throws Exception {
            Flag.QueryCache,
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
        int numDocs = 0;
    }
            indexName,
                builder.setFlush(set);
        assertThat(indicesStats.getTotal().getFieldData().getMemorySizeInBytes(), equalTo(0L));
        assertThat(stats.getTotal().getFlush(), notNullValue());
            }
 *
        assertThat(stats.getTotal().getDocs(), nullValue());
    public void testFilterCacheStats() throws Exception {
        int pageDocs = randomIntBetween(2, 100);
        refresh();
        final AtomicBoolean failed = new AtomicBoolean();
import static org.hamcrest.Matchers.emptyCollectionOf;
        assertThat(stats.getTotal().completion.getSizeInBytes(), greaterThan(0L));
            .execute()
                request.indices(new String[0]);
    private void assertZeroRemoteSegmentStats(RemoteSegmentStats remoteSegmentStats) {
                    .get()
                    .prepareStats("idx")
        );
        client().admin().indices().prepareForceMerge().setMaxNumSegments(1).execute().actionGet();
                return false;
                        final IndicesStatsResponse response = client().admin().indices().stats(request).get();
        );
        assertEquals(new RemoteSegmentStats(), remoteSegmentStats);
import org.opensearch.index.IndexModule;
        NumShards test1 = getNumShards("test1");

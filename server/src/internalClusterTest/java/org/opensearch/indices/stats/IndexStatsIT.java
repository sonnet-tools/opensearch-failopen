            .setStore(false)  
            .put("number_of_replicas", 0)  
        assertThat(stats.getTotalShards(), equalTo(numShards1 + numShards2));
        for (int i = 0; i < numDocs; ++i) {  
            );
        client().prepareIndex("test1").setId(Integer.toString(2)).setSource("field", "value").execute().actionGet();
            case Docs:
                        .leases()  
        createIndex(
            client().prepareIndex("index").setId("1").setSource("foo", "bar"),
import org.opensearch.cluster.metadata.IndexMetadata;  
                break;  
        assertThat(stats.getTotal().getSegments().getCount(), equalTo((long) test1.totalNumShards));
        assertThat(indicesStats.getTotal().getFieldData().getMemorySizeInBytes(), greaterThan(0L));  
            .prepareStats()  
                .getFieldData()
                for (int j = 0; j < 100; j++) {
 * KIND, either express or implied.  See the License for the
        stats = client().admin().indices().prepareStats().execute().actionGet();
            Flag.Get,  
        );  
                break;  
        for (int i = 0; i < 10; i++) {
            .indices()  
        );
            if (allHaveDocs) {  
import static org.hamcrest.Matchers.greaterThan;
                .value(),
        assertThat(stats.getIndex("test2").getTotal().getSearch().getTotal().getQueryCurrent(), equalTo(0L));
        createIndex(
                .setVersionType(VersionType.EXTERNAL)
        assertThat(stats.getTotal().search.getGroupStats().containsKey("baz"), is(false));
        assertThat(stats.getTotalShards(), equalTo(numShards1 + numShards2));
        long test2ExpectedWrites = test2.dataCopies;  
        assertZeroRemoteTranslogStats(remoteTranslogStatsFromNodesStats);  
 * specific language governing permissions and limitations
        assertThat(indicesStats.getTotal().getFieldData().getMemorySizeInBytes(), equalTo(0L));
        assertThat(
                .setSize(0)  
                return false;
        for (int i = 0; i < numberOfStatsThreads; i++) {
            Flag.Completion,  
        // missing get
        assertEquals(
            client().admin().indices().prepareFlush().execute().actionGet();
            .build();
            .clear() // reset defaults
        ForceMergeResponse forceMergeResponse = client().admin()
                .prepareCreate("idx")
        assertThat(
            final IndicesService indexServices = internalCluster().getInstance(IndicesService.class, node);
            NodesStatsResponse postClearNodesStats = client().admin()
                break;  
                return response.getRequestCache() != null;
            client().prepareIndex("index").setId("2").setSource("foo", "baz")
        RemoteSegmentStats remoteSegmentStatsFromNodesStats = nodesStatsResponse.getNodes()
                }  
            equalTo(0L)
            Flag.Translog,
                .setSettings(settingsBuilder().put("index.number_of_shards", 2))
import java.util.concurrent.CopyOnWriteArrayList;
        }
        client().prepareIndex("test2").setId(Integer.toString(1)).setSource("field", "value").execute().actionGet();  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
            case Completion:
            StringBuilder sb = new StringBuilder();
            case Get:
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
    private void assertEquals(QueryCacheStats stats1, QueryCacheStats stats2) {
            assertCumulativeQueryCacheStats(stats);
        createIndex(indexName, Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build());  
        // clear all
        client().prepareIndex("test1").setId(Integer.toString(1)).setSource("field", "value").execute().actionGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                    .prepareStats("idx")
import org.opensearch.index.TieredMergePolicyProvider;
                .setVersionType(VersionType.EXTERNAL)  
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),  
        }
                .getFieldData()
                    .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.MINUS_ONE)
        assertNotNull(stats.getIndex(indexName).getTotal().getSegments().getReplicationStats());  
        final Set<String> nodes = internalCluster().nodesInclude(index);  
                sb.append(termUpto++);
        );
        try {  
                break;  
        assertAcked(
        long termUpto = 0;
            .indices()  
    }
                .getIndices()  
                break;  
            .build();  
            }
        logger.info("--> refreshing");  
        assertThat(executionFailures.get(), emptyCollectionOf(Exception.class));
        assertThat(stats.getIndex("test2").getTotal().getIndexing().getTotal().getDeleteCurrent(), equalTo(0L));
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
            }
        // make sure we see throttling kicking in:  
                .getIndices()
            numDocs += pageDocs;
            client().prepareIndex("test_index").setId(Integer.toString(i)).setSource("field", "value").execute().actionGet();  
        assertThat(stats.getTotal().search.getGroupStats().get("bar").getQueryCount(), greaterThan(0L));  
        // index the data again...
            assertThat(stats.getTotal().queryCache.getMemorySizeInBytes(), greaterThan(0L));  
        assertEquals(DocWriteResponse.Result.DELETED, client().prepareDelete("index", "1").get().getResult());  
        createIndex("test_index_2");
                .getMemorySizeInBytes(),  
            assertThat("ordinal has changed - this breaks the wire protocol. Only append to new values", i, equalTo(flags[i].ordinal()));
        }  
    public void testMultiIndex() throws Exception {  
                builder.setDocs(set);
                fail("new flag? " + flag);
                .cluster()  
import org.opensearch.common.io.stream.BytesStreamOutput;
            }
        int numShards2 = getNumShards("test2").totalNumShards;  
                    .getFieldData()  
        ShardStats shard = client().admin().indices().prepareStats(indexName).setSegments(true).setTranslog(true).get().getShards()[0];  
                }
            }
        ensureGreen();
        assertThat(
        assertBusy(() -> {
        for (Flag flag : values) {  
            .getRemoteSegmentStats();
            nodesStats.getNodes().get(0).getIndices().getQueryCache().getMemorySizeInBytes() + nodesStats.getNodes()  
        response = client().admin().indices().prepareStats("index").setQueryCache(true).get();
        // Filter/Query cache is cleaned periodically, default is 60s, so make sure it runs often. Thread.sleep for 60s is bad
                    .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), "2")  
                .setSource("field", "value")
            if (random.nextBoolean()) {  
        assertThat(stats.getTotal().completion.getFields().get("bar.completion"), greaterThan(0L));  
            .execute()  
import java.util.Collections;
                sb.append(' ');
    public void testFlagOrdinalOrder() {
                .getQueryCache()
        for (Flag flag : values) {
        assertThat(stats.getTotal().getSegments().getIndexWriterMemoryInBytes(), greaterThan(0L));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    }
        ensureGreen(indexName);  
 *
            assertThat(stats.getTotal().queryCache.getMissCount(), greaterThan(0L));
        assertThat(stats.getTotal().completion.getFields().containsField("bar.completion"), is(true));
            assertThat(stats.getTotal().queryCache.getMissCount(), greaterThan(0L));  
            equalTo(0L)  
        assertThat(response.getTotal().queryCache.getHitCount(), greaterThan(0L));  
                greaterThan(0L)
        assertThat(stats.getIndex("test1").getPrimaries().getDocs().getCount(), equalTo(2L));
        for (Flag flag : flags) { // set the flags  
            final Thread thread = new Thread(() -> {
    }
    public void testConcurrentIndexingAndStatsRequests() throws BrokenBarrierException, InterruptedException, ExecutionException {
        ensureGreen();
            case Store:  
        IndicesStatsResponse stats = builder.execute().actionGet();  
        assertThat(
        Random random = random();
        GetResponse getResponse = client().prepareGet("test2", "1").execute().actionGet();
        refreshAndWaitForReplication();
            );  
            .setRefresh(true)  
    }
                .get(1)
        for (Flag flag : flags) { // check the flags
            assertThat(stats.getTotal().queryCache.getMissCount(), greaterThan(0L));
                        executionFailures.get().add(e);
                    .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), "2")
        assertThat(stats.getTotal().getGet().getMissingCount(), equalTo(0L));
                .setId(Integer.toString(1))
        int counter = 0;
            greaterThan(0L)
        );  
        assertThat(stats.getTotal().completion.getFields().containsField("baz.completion"), is(true));
            .actionGet();
            greaterThan(0L)
                    } catch (final ExecutionException | InterruptedException e) {  
                    assertThat(indexShard.getLastSyncedGlobalCheckpoint(), equalTo(indexShard.getLastKnownGlobalCheckpoint()));  
        assertEquals(new RemoteTranslogStats(), remoteTranslogStats);
                    try {
        assertThat(
        // document replication enabled index should return empty segment replication stats  
        assertThat(stats.getTotal().getStore(), nullValue());  
            case Search:
        );  
        }
        assertBusy(() -> {  
                        latch.countDown();  
            Flag.Warmer,
        int numShards1 = getNumShards("test1").totalNumShards;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags.Flag;
                    .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "1")
            assertThat(isSet(flag, stats.getPrimaries()), equalTo(false));  
        assertThat(stats.getIndex("test2").getTotal().getDocs().getCount(), equalTo(test2ExpectedWrites));  
        for (IndexStats indexStats : response.getIndices().values()) {
import org.opensearch.core.common.bytes.BytesReference;  
        final AtomicReference<List<DefaultShardOperationFailedException>> shardFailures = new AtomicReference<>(  
                .prepareCreate("test")  
import org.opensearch.index.IndexService;
            default:
        stats = builder.setIndices("*").execute().actionGet();
                .actionGet();
                    .getMemorySizeInBytes(),  
import org.opensearch.core.rest.RestStatus;
            greaterThan(0L)
        client().prepareIndex("test").setId("2").setSource("field", "value2").execute().actionGet();
                    .get(1)  
        assertThat(stats.getTotal().completion.getSizeInBytes(), greaterThan(0L));  
                .prepareNodesStats("data:true")  
                    .getMemorySizeInBytes(),
        stats = client().admin()
                .setId(Integer.toString(1))
                .setMapping("field", "type=text,fielddata=true")
        assertThat(stats.getTotal().search.getGroupStats(), is(nullValue()));  
    }
        {  
import java.util.concurrent.CyclicBarrier;
    /**
        assertThat(stats.getTotal().completion.getFields().containsField("baz.completion"), is(false));  
                return response.getGet() != null;  
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;  
            .put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1ms")
            .actionGet();
    public void testSegmentsStats() {
    private static void set(Flag flag, IndicesStatsRequestBuilder builder, boolean set) {
                }  
        assertEquals(stats1.getMissCount(), stats2.getMissCount());
        if (isSegmentReplicationEnabledForIndex("test1") == false && isSegmentReplicationEnabledForIndex("test2") == false) {
        // now check the per field stats
        assertThat(stats.getIndex("test2").getTotal().getSearch().getTotal().getFetchCurrent(), equalTo(0L));  
            client().admin()
        stats = builder.setGroups("*").execute().actionGet();
                    .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), "2")
                .setId(UUIDs.randomBase64UUID())
            assertThat(stats.getTotal().queryCache.getHitCount(), greaterThan(0L));
        // rely on 1 replica for this tests
            .clear()
        stop.set(true);
                break;  
        Flag[] flags = new Flag[] {  
import org.opensearch.indices.IndicesService;
        refresh();
                while (!stop.get()) {
        // start threads that will get stats concurrently with indexing  
        long test1ExpectedWrites = 2 * test1.dataCopies;
        stats = builder.setCompletionFields("bar.completion").execute().actionGet();  
        assertThat(response.getTotal().queryCache.getHitCount(), greaterThan(0L));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
import org.opensearch.indices.replication.common.ReplicationType;
            client().prepareIndex("test2")
            prepareCreate("test").setSettings(  
        assertThat(indicesStats.getTotal().getFieldData().getMemorySizeInBytes(), greaterThan(0L));
        stats = client().admin().indices().prepareStats().execute().actionGet();
        assertAcked(
            for (Flag flag : values) {
            assertThat(
            assertSearchResponse(  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
                    shardStats.getRetentionLeaseStats()
        ensureGreen();
            Flag.Segments,
            client().prepareIndex("index").setId("2").setSource("foo", "baz")
        // since refresh will not refresh anything on a shard that has 0 docs and its search response get cached
    public void testClearAllCaches() throws Exception {
        assertThat(
            builders[i] = client().prepareIndex("idx")
            assertThat(
            assertThat(postClearIndicesStats.getTotal().getFieldData().getMemorySizeInBytes(), equalTo(0L));
            nodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + nodesStats.getNodes()
        indicesStats = client().admin().indices().prepareStats("test").clear().setFieldData(true).setQueryCache(true).execute().actionGet();
        assertAcked(
            .actionGet();  
        Flag[] values = CommonStatsFlags.Flag.values();  
                equalTo(0L)
                            shardFailures.get().addAll(Arrays.asList(response.getShardFailures()));  
        indicesStats = client().admin().indices().prepareStats("test").clear().setFieldData(true).execute().actionGet();  
        );
        assertThat(response.getTotal().queryCache.getEvictions(), greaterThan(0L));
                request.indices(new String[0]);  
        assertThat(stats.getTotal().getGet().getMissingCount(), equalTo(1L));
            greaterThan(0L)  
        // nodesStats = client().admin().cluster().prepareNodesStats().setIndices(true).get();  
                    final String id = Integer.toString(idGenerator.incrementAndGet());
                    .getTotal()
        for (Flag flag : values) {
            nodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + nodesStats.getNodes()
        stats = builder.setIndices("test1", "test2").execute().actionGet();
        assertAllSuccessful(response);
        }
            case Warmer:
            assertThat(isSet(flag, stats.getTotal()), equalTo(true));
        assertThat(stats.getTotal().completion.getFields().get("baz.completion"), greaterThan(0L));  
            .prepareForceMerge("index")
            .setMaxNumSegments(1)  
import static org.hamcrest.Matchers.emptyCollectionOf;  
            });  
                    .getFieldData()  
        return Settings.builder()
            case Translog:
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
    }
            client().prepareIndex("index").setId("1").setSource("foo", "bar"),
                    executionFailures.get().add(e);
            indicesStats.getTotal().getFieldData().getFields().get("field"),
            .execute()
                    }
            indexTotal.add(indexStats.getTotal().queryCache);  
        assertThat(stats.getTotal().getGet().getCount(), equalTo(1L));  
                .execute()
        refresh();
import java.util.EnumSet;  
        IndicesStatsResponse stats;
import static org.hamcrest.Matchers.notNullValue;
                client().admin()  
                builder.setRefresh(set);
                equalTo((long) numDocs)
            fail("Expected a version conflict");  
                .indices()
                    .setRequestCache(true)
                .getIndices()
        );
    @Override  
                .execute()  
                .setSource("field", "value")
            assertThat(isSet(flag, stats.getTotal()), equalTo(false));
        assertThat(
        assertThat(stats.getTotal().search.getGroupStats().get("bar").getQueryCount(), greaterThan(0L));  
import org.opensearch.action.admin.indices.stats.IndicesStatsRequestBuilder;
    public void testFieldDataStats() throws Exception {
        client().prepareIndex("test1").setId(Integer.toString(1)).setSource("foo", "bar").execute().actionGet();  
                settingsBuilder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
                    .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1")
                try {  
        assertThat(
        assertAcked(  
        stats = builder.setIndices("_all").execute().actionGet();
                .get()
                break;  
            )
            for (ShardStats shardStats : response.getShards()) {
                greaterThan(0L)
            .prepareStats("test")
/*  
        stats = builder.execute().actionGet();
     * Test that we can safely concurrently index and get stats. This test was inspired by a serialization issue that arose due to a race
        client().prepareSearch()
            .get(0)
            equalTo(0L)
            client().prepareSearch("idx")  
        assertThat(stats.getTotal().getStore(), nullValue());
        final int numberOfIndexingThreads = Runtime.getRuntime().availableProcessors();
            prepareCreate("test").setSettings(
        }  
        // Compare with fresh object because all values default to 0 in default fresh object
        assertThat(response.getTotal().queryCache.getCacheSize(), equalTo(0L));  
            .indices()  
        );  
        assertEquals(stats2.getMemorySizeInBytes(), stats2.getMemorySizeInBytes());
            )
                return response.getQueryCache() != null;
 * this file be licensed under the Apache-2.0 license or a
        }
            out.close();
        assertBusy(() -> {
        IndicesStatsResponse stats = client().admin().indices().prepareStats().execute().actionGet();  
        stats = builder.setGroups("bar", "baz").execute().actionGet();  
            assertThat(stats.getTotal().queryCache.getHitCount(), greaterThan(0L));
        indicesStats = client().admin()
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
        // sort to load it to field data and filter to load filter cache
        int numDocs = 0;
                    .setRequestCache(true)  
        refreshAndWaitForReplication();  
            case QueryCache:
            case FieldData:
            assertThat(isSet(flag, stats.getPrimaries()), equalTo(false));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IndicesStatsResponse indicesStats = client().admin()
    public void testCompletionFieldsParam() throws Exception {  
            client().admin()
                return response.getTranslog() != null;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            greaterThan(0L)
        });
        );
            nodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + nodesStats.getNodes()
            case Merge:  
            .actionGet();
        assertThat(stats.getTotal().getDocs().getCount(), equalTo(totalExpectedWrites));
                    .put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))  
            lessThan(
            .get();
            }
        assertThat(stats.getPrimaries().getIndexing().getTotal().getIndexFailedCount(), equalTo(0L));
                }
        logger.info("test: now optimize");  
                .execute()
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), true)
                .prepareUpdateSettings("idx")
import java.util.concurrent.atomic.AtomicInteger;
            .setId(Integer.toString(1))
            equalTo(0L)  
        assertThat(indicesStats.getTotal().getFieldData().getMemorySizeInBytes(), equalTo(0L));  
            .build();
 * Modifications Copyright OpenSearch Contributors. See
        String indexName = "test-index";
        assertAcked(prepareCreate("test_index"));  
import java.util.Random;
        long totalExpectedWrites = test1ExpectedWrites + test2ExpectedWrites;
            case Indexing:
        // clear all  
            assertSearchResponse(  
            .execute()
            client().admin()
                return response.getFieldData() != null;  
        } catch (VersionConflictEngineException e) {}
        }
            boolean allHaveDocs = true;
                .value(),
            assertThat(stats.getTotal().queryCache.getCacheSize(), greaterThan(0L));
import org.opensearch.plugins.Plugin;  
        assertEquals(stats1.getHitCount(), stats2.getHitCount());  
        }  
            BytesReference bytes = out.bytes();
                .getFieldData()
            .get();  
                .execute()
            prepareCreate("test1").setMapping(
                    .prepareStats("idx")
            .execute()
        assertThat(stats.getTotal().completion.getSizeInBytes(), greaterThan(0L));
        );  
            for (int i = 0; i < pageDocs; ++i) {
            fail("Expected a version conflict");
    private Settings.Builder settingsBuilder() {
        client().admin().indices().prepareClearCache().setFieldDataCache(true).execute().actionGet();
        assertThat(
            IndicesStatsResponse stats = client().admin().indices().prepareStats("index").setQueryCache(true).get();
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(stats.getTotal().getDocs(), nullValue());  
        assertCumulativeQueryCacheStats(response);
            threads.add(thread);
                while (!stop.get()) {
        assertBusy(() -> {  
                .setSettings(Settings.builder().put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true))
            .setStore(false)
        client().admin().cluster().prepareHealth().setWaitForGreenStatus().execute().actionGet();  
    }  
            thread.join();  
                break;  
        indexRandomForConcurrentSearch("test");
        // release the hounds  
            case Docs:  
            .clear()
 *
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
import org.opensearch.common.UUIDs;
 * SPDX-License-Identifier: Apache-2.0
        client().admin().indices().create(createIndexRequest).get();
 * the Apache License, Version 2.0 (the "License"); you may
    }
            case Segments:  
            greaterThan(0L)
        createIndex("test1", "test2");
            .indices()
        return Settings.builder()
                client().prepareSearch("idx").setSearchType(SearchType.QUERY_THEN_FETCH).setSize(0).get().getHits().getTotalHits().value(),
        NumShards test2 = getNumShards("test2");
    public void testSegmentReplicationStats() {  
                .getHits()
        // wait for a failure, or for fifteen seconds to elapse  
            Flag.RequestCache,  
        RemoteSegmentStats remoteSegmentStatsFromIndexStats = shard.getStats().getSegments().getRemoteSegmentStats();
        while (!done) {  
        assertThat(stats.getIndex("test1").getPrimaries().getStore(), notNullValue());  
                // Provoke slowish merging by making many unique terms:
            client().prepareSearch("idx")
        );
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMissCount(),
        );
        switch (flag) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                .execute()
        assertEquals(stats1.getEvictions(), stats2.getEvictions());
import org.opensearch.common.settings.Settings;  
        IndicesStatsResponse stats = client().admin()
            if (System.currentTimeMillis() - start > 300 * 1000) { // Wait 5 minutes for throttling to kick in
                .setIndices(true)
        assertThat(stats.getTotal().getIndexing(), nullValue());
                fail("new flag? " + flag);  
        }  
                .getFieldData()
    public void testSimpleStats() throws Exception {  
        assertBusy(() -> {
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),  
            set(flag, builder, false);
        assertThat(
        assertCumulativeQueryCacheStats(response);  
            for (int i = 0; i < 100; i++) {
                .get()
            equalTo((long) numDocs)
            );
    }
        IndicesStatsResponse stats = builder.execute().actionGet();
            assertThat(stats.getTotal().queryCache.getCacheSize(), greaterThan(0L));  
        QueryCacheStats shardTotal = new QueryCacheStats();
        assertThat(stats.getIndex("test2").getPrimaries().getIndexing().getTotal().getIndexFailedCount(), equalTo(2L));  
        );
        ensureGreen();
        assertThat(stats.getTotal().search.getGroupStats().get("baz").getQueryCount(), greaterThan(0L));  
                equalTo(0L)
                    sb.append(termUpto++);  
import org.opensearch.action.index.IndexResponse;  
                builder.setQueryCache(set);
                .cluster()
    private void assertZeroRemoteSegmentStats(RemoteSegmentStats remoteSegmentStats) {  
            case Merge:
        flags.set(values[random.nextInt(values.length)], false);  
        );  
        Settings settings = Settings.builder()
        persistGlobalCheckpoint("index");
                    .get(1)  
                client().prepareIndex("test").setId("" + termUpto).setSource("field" + (i % 10), sb.toString()).get();
        }
        assertThat(stats.getTotal().getMerge(), notNullValue());  
                .actionGet();  
        assertAcked(  
        assertAcked(prepareCreate("index").setSettings(settings).get());  
    public void testMergeStats() {
        assertZeroRemoteSegmentStats(remoteSegmentStatsFromIndexStats);
            .setFlush(true)
            indexRandom(true, builders);
        assertAcked(
        }
        NodesStatsResponse nodesStatsResponse = client().admin().cluster().prepareNodesStats(primaryNodeName(indexName)).get();  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        client().prepareSearch("_all").setStats("bar", "baz").execute().actionGet();  
        // This assert should not be done on segrep enabled indices because we are asserting Indexing/Write operations count on
        stats = client().admin().indices().prepareStats().setMerge(true).execute().actionGet();
        assertEquals(stats1.getCacheCount(), stats2.getCacheCount());  
        assertThat(  
        client().prepareIndex("test_index_2").setId(Integer.toString(1)).setSource("field", "value").execute().actionGet();
            assertThat(
                shardTotal.add(shardStats.getStats().queryCache);
        );
                    .setId(Integer.toString(counter++))
 * Unless required by applicable law or agreed to in writing,
        assertBusy(() -> {
        stats = builder.execute().actionGet();  
 */
import static org.hamcrest.Matchers.equalTo;
        });
                .get()
     * getting doc stats during heavy indexing. The race could lead to deleted docs being negative which would then be serialized as a  
            case FieldData:
        // stop all threads and wait for them to complete  
            Flag.Search,
        assertAcked(prepareCreate("test1"));
        indexRandom(
            .setMerge(true)
                builder.setStore(set);
        assertThat(stats.getTotal().getGet().getCount(), equalTo(2L));  
            .prepareStats()
        stats = client().admin().indices().prepareStats().execute().actionGet();
import org.opensearch.indices.IndicesQueryCache;
                    + ",\"baz\": { \"type\": \"text\", \"fields\": { \"completion\": { \"type\": \"completion\" }}}}}"
    }
        assertThat(stats.getPrimaries().getIndexing().getTotal().getThrottleTime().millis(), equalTo(0L));  
        ensureGreen();  
            .prepareNodesStats("data:true")
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
        client().prepareIndex("test").setId("1").setSource("field", "value1").execute().actionGet();
        long termUpto = 0;
        for (int i = 0; i < 100; i++) {
            for (Flag flag : values) {  
        }  
        } catch (VersionConflictEngineException e) {}  
        assertThat(stats.getPrimaries().getDocs().getCount(), equalTo(3L));
            Flag.FieldData,  
        );
        }
                .getFieldData()
        ensureGreen(indexName);
        assertThat(flags.anySet(), equalTo(false));  
        client().prepareSearch().addSort("field2", SortOrder.ASC).execute().actionGet();
                break;  
        assertThat(stats.getIndex("test1").getTotal().getDocs().getCount(), equalTo(test1ExpectedWrites));
        QueryCacheStats total = response.getTotal().queryCache;
                builder.setFieldData(set);
            for (ShardStats stats : client().admin().indices().prepareStats("idx").setDocs(true).get().getShards()) {
                    .get()  
        assertThat(stats.getPrimaries().getIndexing().getTotal().getIndexCount(), equalTo(3L));  
 * software distributed under the License is distributed on an
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() },
                .getTotalHits()  
        Random random = random();  
        assertThat(stats.getIndex("test1").getTotal().getIndexing().getTotal().getIndexCurrent(), equalTo(0L));  
            .execute()  
            nodesStats.getNodes().get(0).getIndices().getQueryCache().getMemorySizeInBytes() + nodesStats.getNodes()
        indexName = "test-index2";  
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getHitCount(),
        assertThat(flags.length, equalTo(Flag.values().length));  
                client().prepareSearch("idx").setSearchType(SearchType.QUERY_THEN_FETCH).setSize(0).get().getHits().getTotalHits().value(),
     * ({@link StreamOutput#writeVLong(long)}), the stream would become corrupted. Here, we want to test
        indexRandom(
                return response.getRefresh() != null;  
            fail("Expected a version conflict");
            assertThat(stats.getTotal().queryCache.getEvictions(), greaterThan(0L));  
            case Translog:
            for (final ShardStats shardStats : client().admin().indices().prepareStats("index").get().getIndex("index").getShards()) {
    }
            out.close();  
 * compatible open source license.
                break;  
            .actionGet();
                builder.setRecovery(set);
        );  
                    .getIndices()
            case Completion:
    /**
        assertThat(response.getTotal().queryCache.getCacheSize(), equalTo(0L));
                .indices()
            .setFieldDataFields("*")
        refreshAndWaitForReplication();  
        client().admin().indices().prepareClearCache().execute().actionGet();  
                if (i % 2 == 0) {  
            }
                        failed.set(true);
                        if (response.getFailedShards() > 0) {
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 1).build()
                final long maxSeqNo = shardStats.getSeqNoStats().getMaxSeqNo();
        for (Flag flag : EnumSet.complementOf(flags)) { // check the complement  
        stats = client().admin().indices().prepareStats().execute().actionGet();
            "test",
                    .indices()
                .get()  
    public void testThrottleStats() throws Exception {  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .get(1)
        assertThat(stats.getIndex("test1").getPrimaries().getRefresh(), notNullValue());  
    }
        assertThat(stats.getTotalShards(), equalTo(numShards1));
        IndicesStatsRequestBuilder builder = client().admin().indices().prepareStats();
    protected Settings nodeSettings(int nodeOrdinal) {  
import org.opensearch.index.IndexSettings;  
        assertThat(indicesStats.getTotal().getQueryCache().getMemorySizeInBytes(), greaterThan(0L));
        // index docs until we have at least one doc on each shard, otherwise, our tests will not work
                return response.getStore() != null;
                .get()
        assertThat(flags.anySet(), equalTo(true));
            nodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + nodesStats.getNodes()  
            assertThat(isSet(flag, stats.getPrimaries()), equalTo(true));  
        final CountDownLatch latch = new CountDownLatch(1);
import java.util.concurrent.atomic.AtomicBoolean;
        assertThat(stats.getTotal().getFlush(), notNullValue());
            .setMerge(true)  
            .setFieldData(true)  
                .get("field"),
            assertThat(stats.getTotal().getIndexing().getTotal().getIndexCount(), equalTo(totalExpectedWrites));  
    public void testAllFlags() throws Exception {
                assertTrue(  
        for (int i = 0; i < 10; i++) {  
        assertThat(
        IndicesStatsRequestBuilder builder = client().admin().indices().prepareStats();  
            client().prepareIndex("test1")
        );
            Flag.Store,
     * that we can continue to get stats while indexing.  
            BytesStreamOutput out = new BytesStreamOutput();
            .setFlush(true)
                nodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + nodesStats.getNodes()  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        );
            threads.add(thread);
            client().prepareIndex("test").setId("" + termUpto).setSource("field" + (i % 10), sb.toString()).get();
        assertThat(stats.getTotal().getMerge(), notNullValue());  
        );
import static org.hamcrest.Matchers.nullValue;  
        );  
        indexRandomForConcurrentSearch("test");  
        stats = client().admin().indices().prepareStats().setSegments(true).get();
                    .getIndices()
            thread.setName("indexing-" + i);
                .getIndices()
        IndicesStatsResponse stats = builder.execute().actionGet();
        IndicesStatsResponse stats = builder.execute().actionGet();
                .prepareStats("test")
                return response.getIndexing() != null;
            IndicesStatsResponse stats = client().admin().indices().prepareStats("index").setQueryCache(true).get();  
            case Recovery:  
            client().admin()
        QueryCacheStats indexTotal = new QueryCacheStats();  
        );  
            .getSegments()
        assertThat(stats.getTotal().getSearch(), nullValue());
        assertThat(indicesStats.getTotal().getFieldData().getFields().get("field"), greaterThan(0L));
            );  
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                return response.getSegments() != null;
                builder.setTranslog(set);
import org.opensearch.test.InternalSettingsPlugin;
                    .getQueryCache()
            .setFlush(true)
        assertThat(stats.getTotalShards(), equalTo(numShards1 + numShards2));
                assertThat(flags.isSet(flag), equalTo(readStats.isSet(flag)));
        logger.info("test: test done");  
    }
                break;  
            IndicesStatsResponse postClearIndicesStats = client().admin()  
        // so we run it in an assertBusy block which should eventually succeed
                    .indices()
            Settings.builder().put("index.number_of_shards", 10).build()
                .get(1)
        ensureGreen();  
        assertThat(stats.getTotal().getRefresh(), notNullValue());
            indexName,  
        }
        IndicesStatsResponse indicesStats = client().admin()  
        stats = builder.setIndices("test1").execute().actionGet();
            case Search:
            assertCumulativeQueryCacheStats(stats);
        // sort to load it to field data...  
                .actionGet();  
            .put(super.nodeSettings(nodeOrdinal))  
        assertThat(stats.getTotal().completion.getSizeInBytes(), greaterThan(0L));
                .setSettings(Settings.builder().put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), false))
        refresh();  
                .setVersionType(VersionType.EXTERNAL)
        assertThat(flags.anySet(), equalTo(true));
import java.util.concurrent.ExecutionException;
                break;  
            greaterThan(0L)
        for (Flag flag : values) {
        CommonStatsFlags flags = new CommonStatsFlags();
                    .getFieldData()
            CommonStatsFlags readStats = new CommonStatsFlags(bytes.streamInput());
        assertThat(stats.getTotal().getIndexing(), nullValue());
                    .getMemorySizeInBytes(),
        assertZeroRemoteSegmentStats(remoteSegmentStatsFromNodesStats);  
        NodesStatsResponse nodesStats = client().admin().cluster().prepareNodesStats("data:true").setIndices(true).execute().actionGet();
        client().prepareIndex("test_index").setId(Integer.toString(2)).setSource("field", "value").execute().actionGet();  
                    .getIndices()
            client().prepareSearch("idx").setSearchType(SearchType.QUERY_THEN_FETCH).setSize(0).get().getHits().getTotalHits().value(),  
            set(flag, builder, true);
        assertThat(indicesStats.getTotal().getFieldData().getMemorySizeInBytes(), greaterThan(0L));
        ensureGreen();
            .indices()  
        ensureGreen();  
        assertEquals(DocWriteResponse.Result.DELETED, client().prepareDelete("index", "2").get().getResult());
        assertEquals(stats1.getCacheSize(), stats2.getCacheSize());
    }
        client().admin().indices().prepareForceMerge("test").get();
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
                postClearNodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + postClearNodesStats.getNodes()  
        Flag[] values = CommonStatsFlags.Flag.values();
    }
                    failed.set(true);  
        assertThat(  
                    .getMemorySizeInBytes()
import java.util.concurrent.BrokenBarrierException;
            case Refresh:
import org.opensearch.index.MergeSchedulerConfig;
                .getIndices()
        // sort to load it to field data...
        // the query cache has an optimization that disables it automatically if there is contention,  
            assertThat(
    public IndexStatsIT(Settings settings) {
        assertAcked(  
            greaterThan(0L)  
                .getIndices()
        refreshAndWaitForReplication();
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
        });
                Settings.builder()
    private void persistGlobalCheckpoint(String index) throws Exception {
        assertThat(stats.getTotal().getRefresh(), notNullValue());
            );
        assertThat(stats.getTotal().getSearch(), nullValue());  
import java.util.Set;  
        // when OpenSearchIntegTestCase.after tries to remove indices created by the test:
        nodesStats = client().admin().cluster().prepareNodesStats("data:true").setIndices(true).execute().actionGet();
                .getMemorySizeInBytes(),
            .cluster()  
 */  
        assertThat(response.getTotal().queryCache.getCacheCount(), greaterThan(0L));  
                    assertThat(response.getResult(), equalTo(DocWriteResponse.Result.CREATED));
     */
                return response.getFlush() != null;
                client().admin()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
                    .getRequestCache()  
            equalTo((long) numDocs)
        NodesStatsResponse nodesStats = client().admin().cluster().prepareNodesStats("data:true").setIndices(true).execute().actionGet();  
        ensureGreen();  
        // segment replication enabled index should return segment replication stats
                return response.getDocs() != null;
    public void testEncodeDecodeCommonStats() throws IOException {
                equalTo(0L)
        }
            IndexRequestBuilder[] builders = new IndexRequestBuilder[pageDocs];
        }
                .indices()  
                sb.append(" some random text that keeps repeating over and over again hambone");  
        assertThat(getResponse.isExists(), equalTo(false));  
                .setMapping("field", "type=text,fielddata=true", "field2", "type=text,fielddata=true")
        assertEquals(stats1.getTotalCount(), stats2.getTotalCount());  
import org.opensearch.action.index.IndexRequestBuilder;
        client().prepareIndex("test").setId("2").setSource("field", "value2", "field2", "value2").execute().actionGet();
            client().prepareSearch("idx")  
                .getFieldData()  
                break;  
        );
        );
                .getFields()  
    }
        client().prepareSearch().addSort("field", SortOrder.ASC).execute().actionGet();
        }
                } catch (final BrokenBarrierException | InterruptedException e) {
            .setRefresh(true)
            thread.start();  
        stats = builder.setCompletionFields("*").execute().actionGet();
                    final IndexResponse response = client().prepareIndex("test").setId(id).setSource("{}", MediaTypeRegistry.JSON).get();  
                postClearNodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + postClearNodesStats.getNodes()
            refresh();
    }  
import org.opensearch.index.VersionType;  
            .prepareStats("test")
                .get(1)  
        }  
        assertThat(indicesStats.getTotal().getQueryCache().getMemorySizeInBytes(), equalTo(0L));  
        refresh();
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMissCount(),  
        assertThat(stats.getTotal().getDocs(), nullValue());  
                .indices()
        client().admin().indices().prepareClearCache().setRequestCache(true).get(); // clean the cache  
                        .stream()
import java.util.concurrent.TimeUnit;  
        IndicesStatsResponse stats = builder.execute().actionGet();  
        RemoteTranslogStats remoteTranslogStatsFromIndexStats = shard.getStats().getTranslog().getRemoteTranslogStats();  
import java.util.List;
            thread.setName("stats-" + i);
import org.apache.lucene.tests.util.LuceneTestCase.SuppressCodecs;  
import org.opensearch.search.sort.SortOrder;
            .setFieldData(true)
                    .getTotal()
            IndicesStatsResponse stats = client().admin().indices().prepareStats("index").setQueryCache(true).get();  
                        .allMatch(retentionLease -> retentionLease.retainingSequenceNumber() == maxSeqNo + 1)
        IndicesStatsRequestBuilder builder = client().admin().indices().prepareStats();
        );  
 * under the License.  
    }  
                .setSettings(settingsBuilder().put("index.number_of_replicas", 0).put("index.number_of_shards", 2))
        for (Flag flag : values) {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertThat(stats.getTotal().completion.getFields().get("bar.completion"), greaterThan(0L));
        assertThat(stats.getTotal().completion.getFields().containsField("bar.completion"), is(true));  
import org.opensearch.action.get.GetResponse;
import org.opensearch.indices.IndicesRequestCache;  
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), true)
import static org.hamcrest.Matchers.lessThan;
        assertThat(  
        client().admin().indices().prepareForceMerge().setMaxNumSegments(1).execute().actionGet();
        ensureGreen();
        // start threads that will index concurrently with stats requests  
        );  
                    indexShard.sync();
                    .get()
    private void assertCumulativeQueryCacheStats(IndicesStatsResponse response) {  
                .setSize(0)
    }
            .execute()
            CommonStatsFlags readStats = new CommonStatsFlags(bytes.streamInput());
        for (int i = 0; i < flags.length; i++) {
                client().prepareSearch("index").setQuery(QueryBuilders.constantScoreQuery(QueryBuilders.matchQuery("foo", "baz"))).get()  
            prepareCreate("test_index").setSettings(
                    .get(1)
    }  
        IndicesStatsResponse stats = client().admin().indices().prepareStats().setSegments(true).get();  
            nodesStats.getNodes().get(0).getIndices().getFieldData().getMemorySizeInBytes() + nodesStats.getNodes()
            }  
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;  
                .setRequestCache(false)  
            }  
                break;  
        assertThat(stats.getTotal().completion.getFields().containsField("bar.completion"), is(true));
import java.util.Collection;
import org.opensearch.index.shard.IndexShard;
            .setQueryCache(true)
                .setSource(jsonBuilder().startObject().field("common", "field").field("str_value", "s" + i).endObject());  
        assertThat(  
                builder.setGet(set);
        );
            case QueryCache:
    public void testZeroRemoteStoreStatsOnNonRemoteStoreIndex() {
            .setDocs(false)
            BytesStreamOutput out = new BytesStreamOutput();  
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "200ms")
        assertThat(stats.getIndex("test1").getTotal().getIndexing().getTotal().getDeleteCurrent(), equalTo(0L));
        // Optimize & flush and wait; else we sometimes get a "Delete Index failed - not acked"
        );  
        // Provoke slowish merging by making many unique terms:  
        assertThat(stats.getPrimaries().getIndexing().getTotal().getThrottleTime().millis(), equalTo(0L));  
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0)  
import org.opensearch.index.remote.RemoteSegmentStats;
        for (String node : nodes) {
            case Warmer:
                .build()
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getHitCount(),
        indexRandom(true, builders);
        final AtomicInteger idGenerator = new AtomicInteger();  
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
        assertZeroRemoteTranslogStats(remoteTranslogStatsFromIndexStats);
            NodesStatsResponse postClearNodesStats = client().admin()
                    latch.countDown();
            case Store:
 *  
                    barrier.await();
            .actionGet();
            final Thread thread = new Thread(() -> {
                .value(),
        }  
package org.opensearch.indices.stats;
                assertThat(flags.isSet(flag), equalTo(readStats.isSet(flag)));  
        assertBusy(() -> {
import org.opensearch.index.query.QueryBuilders;  
                .setSource("field", "value1", "field2", "value1")  
        }  
        ensureGreen(indexName);
                } catch (final BrokenBarrierException | InterruptedException e) {
            assertThat(stats.getTotal().queryCache.getHitCount(), equalTo(0L));
                .getMemorySizeInBytes(),
                            failed.set(true);
        // increasing the number of shards increases the number of chances any one stats request will hit a race
        assertAllSuccessful(forceMergeResponse);
        });
            equalTo(0L)
            .put(indexSettings())
                break;  
        try {
                .actionGet();
        assertThat(stats.getTotal().search.getTotal().getQueryCount(), greaterThan(0L));
        refresh();
        assertThat(stats.getTotal().completion.getFields().containsField("baz.completion"), is(false));
        }
                equalTo(0L)
 * GitHub history for details.
            }
                builder.setRequestCache(set);
            new CopyOnWriteArrayList<>()
        final AtomicBoolean failed = new AtomicBoolean();
 * The OpenSearch Contributors require contributions made to  
        persistGlobalCheckpoint("index"); // Need to persist the global checkpoint for the soft-deletes retention MP.
            set(flag, builder, true);
        assertThat(stats.getPrimaries().getIndexing().getTotal().getIndexFailedCount(), equalTo(3L));
            .clear() // reset defaults
        long start = System.currentTimeMillis();
            for (IndexService indexService : indexServices) {  
        client().prepareIndex("test").setId("1").setSource("field", "value1", "field2", "value1").execute().actionGet();  
        NumShards test1 = getNumShards("test_index");  
        // we need to flush and make that commit safe so that the SoftDeletesPolicy can drop everything.
        nodesStats = client().admin().cluster().prepareNodesStats("data:true").setIndices(true).execute().actionGet();  
            Settings.builder()  
                final IndicesStatsRequest request = new IndicesStatsRequest();
            }
            flags.set(flag, true);
                .getHits()
                .get(1)
import org.opensearch.action.admin.indices.stats.CommonStats;
            assertCumulativeQueryCacheStats(stats);  
        assertThat(stats.getTotal().getSegments(), notNullValue());  
    public Settings indexSettings() {
            .execute()  
            client().admin().indices().prepareStats("idx").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
        stats = builder.setIndices("_all").execute().actionGet();
                .setIndices(true)
    public void testQueryCache() throws Exception {  
            BytesReference bytes = out.bytes();  
@ClusterScope(scope = Scope.SUITE, numDataNodes = 2, numClientNodes = 0)
import org.opensearch.index.IndexModule;
                .prepareNodesStats("data:true")
        stats = builder.setGroups("*r").execute().actionGet();
                settingsBuilder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")  
        getResponse = client().prepareGet("test2", "2").execute().actionGet();
        );  
/*
        assertCumulativeQueryCacheStats(response);
        );  
                builder.setIndexing(set);
            .getIndices()  
 * this work for additional information regarding copyright
            }
        createIndex("test2");
            .actionGet();  
                .clear()  
            nodesStats.getNodes().get(0).getIndices().getFieldData().getFields().get("field") + nodesStats.getNodes()
        indicesStats = client().admin().indices().prepareStats("test").clear().setFieldData(true).setQueryCache(true).execute().actionGet();
        for (final Thread thread : threads) {
                flags.set(flag, random.nextBoolean());
            assertSearchResponse(
        ensureGreen();
        );
            new Object[] { Settings.builder().put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build() }
        assertThat(
        return Settings.builder().put(indexSettings());
        builder = client().admin().indices().prepareStats();
            thread.start();  
        assertThat(getResponse.isExists(), equalTo(true));  
            assertThat(stats.getTotal().queryCache.getCacheSize(), greaterThan(0L));
        assertThat(indicesStats.getTotal().getQueryCache().getMemorySizeInBytes(), equalTo(0L));  
import org.opensearch.index.engine.VersionConflictEngineException;
            assertThat(isSet(flag, stats.getTotal()), equalTo(true));  
        }
            case Recovery:
                .prepareCreate("test")  
        assertThat(stats.getPrimaries().getIndexing().getTotal().isThrottled(), equalTo(false));
                builder.setFlush(set);
        assertThat(response.getTotal().queryCache.getMemorySizeInBytes(), equalTo(0L));
        assertThat(stats.getTotal().completion.getSizeInBytes(), greaterThan(0L));  
        refreshAndWaitForReplication();  
    public void testNonThrottleStats() throws Exception {
            assertThat(isSet(flag, stats.getTotal()), equalTo(false));
            .setIndices(new CommonStatsFlags().set(CommonStatsFlags.Flag.FieldData, true).fieldDataFields("*"))
                .getHits()  
                .setSize(0)
        // index failed  
        assertThat(stats.getIndex("test1").getTotal().getSearch().getTotal().getFetchCurrent(), equalTo(0L));
                .setVersion(1)  
}
        stats = builder.setCompletionFields("*r*").execute().actionGet();
import org.opensearch.action.admin.indices.create.CreateIndexRequest;  
                client().prepareSearch("index").setQuery(QueryBuilders.constantScoreQuery(QueryBuilders.matchQuery("foo", "baz"))).get()
            equalTo(0L)
        client().prepareIndex("test2").setId(Integer.toString(1)).setSource("field", "value").execute().actionGet();
import java.util.ArrayList;
            equalTo((long) numDocs)
            .clear()  
        refreshAndWaitForReplication();  
        IndicesStatsRequestBuilder builder = client().admin().indices().prepareStats();  
        assertThat(stats.getTotal().completion.getFields().get("bar.completion"), greaterThan(0L));
    public void testGroupsParam() throws Exception {
                builders[i] = client().prepareIndex("idx")  
            );  
        latch.await(15, TimeUnit.SECONDS);
        }  
import org.opensearch.action.support.WriteRequest;
                .setSearchType(SearchType.QUERY_THEN_FETCH)
            .addSort("field", SortOrder.ASC)
        assertThat(stats.getIndex("test1").getTotal().getSearch().getTotal().getQueryCurrent(), equalTo(0L));  
            flags.writeTo(out);
                postClearNodesStats.getNodes().get(0).getIndices().getQueryCache().getMemorySizeInBytes() + postClearNodesStats.getNodes()
            done = stats.getPrimaries().getIndexing().getTotal().getThrottleTime().millis() > 0;
        assertThat(stats.getTotal().getIndexing(), nullValue());
        // In order to instruct the merge policy not to keep a fully deleted segment,  
                .getIndices()
                .setVersion(1)
     * variable-length long. Since serialization of negative longs using a variable-length format was unsupported
public class IndexStatsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        // Compare with fresh object because all values default to 0 in default fresh object  
            assertThat(isSet(flag, stats.getPrimaries()), equalTo(true));
        client().prepareSearch()  
            .prepareStats("test")
            );
        });
        stats = builder.setGroups("bar").execute().actionGet();
            );  
    }  
        refresh();
        assertThat(stats.getTotal().getMerge(), notNullValue());
                .get("field"),
            .get(0)
    @ParametersFactory  
            set(flag, builder, false); // clear all  
            case Get:
            // nodesStats = client().admin().cluster().prepareNodesStats().setIndices(true).get();  
            equalTo(0L)  
        assertThat(stats.getTotal().getGet(), nullValue());
        IndicesStatsRequestBuilder builder = client().admin().indices().prepareStats();
            lessThan(indicesStats.getTotal().getFieldData().getMemorySizeInBytes())
        }
                    .prepareStats("idx")
        assertThat(stats.getTotalShards(), equalTo(numShards1 + numShards2));
            .put(super.indexSettings())  
        logger.info("--> verifying that cache size is 0");  
                .getMemorySizeInBytes(),  
                return response.getMerge() != null;
        for (Flag flag : values) {
        assertThat(stats.getIndex("test1").getPrimaries().getFlush(), notNullValue());
        assertThat(  
            case Segments:
        assertThat(stats.getTotal().completion.getFields().containsField("baz.completion"), is(true));
        });
    }  
        for (Flag flag : values) {  
        assertAllSuccessful(client().admin().indices().prepareClearCache("index").setQueryCache(true).get());  
            .getTranslog()
        );  
                .getTotalHits()
        int pageDocs = randomIntBetween(2, 100);  
        }
            assertThat(  
            );
        final AtomicBoolean stop = new AtomicBoolean();
                if (stats.getStats().getDocs().getCount() == 0) {  
                client().prepareSearch("index").setQuery(QueryBuilders.constantScoreQuery(QueryBuilders.matchQuery("foo", "baz"))).get()
            .setFieldData(true)  
        assertEquals(0, response.getTotal().queryCache.getCacheSize());
            flags.writeTo(out);
        );
        assertThat(stats.getTotal().completion.getFields().get("bar.completion"), greaterThan(0L));  
        final CreateIndexRequest createIndexRequest = new CreateIndexRequest(  
        // check flags  
            assertThat(
            case Flush:
            case Refresh:
            .execute()  
        // make sure that number of requests in progress is 0
            .setSource("{\"bar\":\"bar\",\"baz\":\"baz\"}", MediaTypeRegistry.JSON)
            true,  
            .setPostFilter(QueryBuilders.termQuery("field", "value1"))
                    .indices()  
            indexName,
        assertThat(
        assertThat(stats.getTotal().completion.getFields().get("baz.completion"), greaterThan(0L));
    }  
        super(settings);  
            });  
            )
    }
                .get()  
        assertThat(stats.getTotal().search.getGroupStats().get("bar").getQueryCount(), greaterThan(0L));
                }
            .setDocs(false)
        stats = builder.setIndices("*2").execute().actionGet();
    public static Collection<Object[]> parameters() {
import java.io.IOException;
        assertThat(stats.getIndex("test1").getPrimaries().getMerge(), notNullValue());
                .setId(Integer.toString(i))
                    .getRequestCache()  
            }
        assertThat(stats.getTotal().search.getGroupStats().get("bar").getQueryCount(), greaterThan(0L));
        client().prepareSearch().addSort("field2", SortOrder.ASC).execute().actionGet();
        assertThat(indicesStats.getTotal().getFieldData().getMemorySizeInBytes(), equalTo(0L));
import org.opensearch.core.common.io.stream.StreamOutput;
     */
import org.opensearch.action.admin.indices.stats.IndexStats;
                    failed.set(true);  
        );  
                return response.getWarmer() != null;  
                }
import org.opensearch.action.search.SearchType;
        flush("index");  
            Flag.Docs,
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        stats = builder.execute().actionGet();  
import static org.hamcrest.Matchers.is;  
        );
            .indices()
                .execute()  
                .getIndices()  
        );
    private static boolean isSet(Flag flag, CommonStats response) {
        EnumSet<Flag> flags = EnumSet.noneOf(Flag.class);
            }  
        client().prepareSearch().addSort("field", SortOrder.ASC).execute().actionGet();  
                break;  
                builder.setCompletion(set);
import java.util.concurrent.CountDownLatch;  
                    .getMemorySizeInBytes(),  
        assertThat(  
        for (Flag flag : values) {
                        .retentionLeases()
                .indices()  
        client().admin().indices().prepareFlush().get();
        final AtomicReference<List<Exception>> executionFailures = new AtomicReference<>(new CopyOnWriteArrayList<>());  
                .actionGet();  
        assertThat(stats.getTotal().getFlush(), notNullValue());
                .getQueryCache()  
        assertThat(stats.getTotal().getSegments().getVersionMapMemoryInBytes(), greaterThan(0L));
        RemoteTranslogStats remoteTranslogStatsFromNodesStats = nodesStatsResponse.getNodes()
            .addSort("field", SortOrder.ASC)
        boolean done = false;
                    latch.countDown();
    }
        return Arrays.asList(
            greaterThan(0L)  
import org.opensearch.index.translog.RemoteTranslogStats;  
        assertThat(stats.getTotal().search.getGroupStats().containsKey("baz"), is(false));
                            latch.countDown();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        assertThat(stats.getTotal().getGet(), nullValue());  
        assertThat(stats.getIndex("test2").getTotal().getIndexing().getTotal().getIndexCurrent(), equalTo(0L));
        nodesStats = client().admin()
import org.opensearch.action.admin.indices.stats.ShardStats;  
        assertThat(stats.getTotal().getStore(), nullValue());
 * license agreements. See the NOTICE file distributed with
                    .get()
        // ignore this assert check for segrep enabled indices.
        switch (flag) {  
            .setIndexing(false)
        assertThat(stats.getTotal().getGet().getExistsCount(), equalTo(1L));
                .get()  
    }
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
                        final IndicesStatsResponse response = client().admin().indices().stats(request).get();  
            true,  
                try {  
                    .setRequestCache(true)  
        assertNotNull(stats.getIndex(indexName).getTotal().getSegments().getReplicationStats());
            .getRemoteTranslogStats();
        }
                    .getIndices()
                equalTo((long) numDocs)  
                .setRequestCache(true)  
        NumShards test1 = getNumShards("test1");  
            .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), true)
                    .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "10000")  
        client().admin().indices().prepareClearCache().setRequestCache(true).get(); // clean the cache  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                client().admin()  
                break;
    @Override
            nodesStats.getNodes().get(0).getIndices().getFieldData().getFields().get("field") + nodesStats.getNodes()
            client().prepareIndex("test2")  
                StringBuilder sb = new StringBuilder();  
            Flag.Refresh,
                .getFieldData()
                    .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), "2")  
        // Here we are testing that a fully deleted segment should be dropped and its cached is evicted.
 */  
            for (int j = 0; j < 100; j++) {  
 * not use this file except in compliance with the License.
            false,
        for (int i = 0; i < 100; i++) {
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                .getMemorySizeInBytes(),
        } catch (VersionConflictEngineException e) {}
    }  
        });  
        assertThat(stats.getTotal().completion.getFields().containsField("bar.completion"), is(true));
        );
        assertAcked(prepareCreate("test_index"));
/*  
        client().prepareIndex("test1").setId(Integer.toString(2)).setSource("field", "value").execute().actionGet();
        createIndex("test1");
            index("test_index", "_doc", Integer.toString(i), "field", "value");  
                builder.setWarmer(set);
    public void testFilterCacheStats() throws Exception {  
                }
        flush();
                );  
        }
        logger.info("--> force merging to a single segment");
                    .getTotal()
                .actionGet();
                flags.add(flag);
        final CyclicBarrier barrier = new CyclicBarrier(1 + numberOfIndexingThreads + numberOfStatsThreads);  
        // set the index level setting to false, and see that the reverse works
        assertThat(stats.getTotal().completion.getSizeInBytes(), greaterThan(0L));
        ensureGreen();
            )
        try {
        refresh();  
import org.opensearch.index.cache.query.QueryCacheStats;
            case Indexing:
     * Persist the global checkpoint on all shards of the given index into disk.
        );
                .getTotalHits()  
                break;  
        assertThat(stats.getTotal().completion.getFields(), is(nullValue()));
            Flag.Flush,  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                builder.setSegments(set);
                    .setSource(jsonBuilder().startObject().field("common", "field").field("str_value", "s" + i).endObject());
        refreshAndWaitForReplication();
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
                }  
            )
        assertThat(
    }
    }
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC.name())  
                return response.getRecoveryStats() != null;
        assertThat(  
    }
            assertThat(
        while (true) {  
                        }
                return response.getCompletion() != null;
                .setSource("field", "value")  
        client().prepareIndex("test1")  
                .setFieldData(true)
            .setIndexing(false)  
        String indexName = "test-index";
                    executionFailures.get().add(e);
            Flag.Recovery };
        stats = client().admin().indices().prepareStats().execute().actionGet();
                return response.getSearch() != null;
            Flag.QueryCache,
        assertEquals(new RemoteSegmentStats(), remoteSegmentStats);
            default:
            flags.set(flag, false);
                .get(1)  
        assertThat(response.getTotal().queryCache.getMissCount(), greaterThan(0L));
                    allHaveDocs = false;
                    .getMemorySizeInBytes(),
                .getMemorySizeInBytes(),
            case RequestCache:
        assertAcked(
            );
        client().prepareIndex("test_index").setId(Integer.toString(1)).setSource("field", "value").execute().actionGet();
        for (int i = 0; i < 20; i++) {
        assertThat(stats.getTotal().getDocs(), nullValue());
        // all primary and replica shards. But in case of segrep, Indexing/Write operation don't happen on replica shards. So we can  
            equalTo((long) numDocs)  
        for (int i = 0; i < numberOfIndexingThreads; i++) {
        assertThat(stats.getTotal().getMerge().getTotal(), greaterThan(0L));
import org.opensearch.common.unit.TimeValue;
        stats = client().admin().indices().prepareStats().clear().setFlush(true).setRefresh(true).setMerge(true).execute().actionGet();
                    barrier.await();
        final int numberOfStatsThreads = 4 * numberOfIndexingThreads;
        client().prepareIndex("test1").setId(Integer.toString(1)).setSource("field", "value").execute().actionGet();  
                    sb.append(' ');
        assertThat(
            Flag.Merge,
            stats = client().admin().indices().prepareStats().execute().actionGet();
                "{ \"properties\": { \"bar\": { \"type\": \"text\", \"fields\": { \"completion\": { \"type\": \"completion\" }}}"  
        }
        barrier.await();
            case RequestCache:
                    .getRequestCache()
                fail("index throttling didn't kick in after 5 minutes of intense merging");  
                .setVersion(1)
            client().prepareIndex(indexName)
            Flag.Indexing,
                    .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                    refresh();
@SuppressCodecs("*") // requires custom completion format  
            .getIndices()  
            case Flush:  
        assertEquals(total, indexTotal);
        assertThat(stats.getTotal().getGet().getExistsCount(), equalTo(1L));
        stats = builder.setCompletionFields("bar.completion", "baz.completion").execute().actionGet();  
        );
        response = client().admin().indices().prepareStats("index").setQueryCache(true).get();
                    break;
                .status()  
            .actionGet();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        {
        IndicesStatsResponse response = client().admin().indices().prepareStats("index").setQueryCache(true).get();
        final List<Thread> threads = new ArrayList<>(numberOfIndexingThreads + numberOfIndexingThreads);
                builder.setMerge(set);
                builder.setSearch(set);
                .setRequestCache(true)
                    .get(1)
    private void assertZeroRemoteTranslogStats(RemoteTranslogStats remoteTranslogStats) {
                .getFields()  
     * This makes sure that the persisted global checkpoint on those shards will equal to the in-memory value.  
                .get(1)
            equalTo(0L)  
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
        assertThat(response.getTotal().queryCache.getEvictions(), greaterThan(0L));
        return Collections.singleton(InternalSettingsPlugin.class);
            .setPostFilter(QueryBuilders.termQuery("field", "value2"))  
                .get(1)  
            equalTo(0L)  
                .getIndices()  
        client().admin().indices().prepareForceMerge().setMaxNumSegments(1).execute().actionGet();  
        );
        ensureGreen();
        assertEquals(total, shardTotal);  
        assertThat(stats.getIndex("test2").getPrimaries().getDocs().getCount(), equalTo(1L));
    }
import org.opensearch.index.translog.Translog;
            );
                for (IndexShard indexShard : indexService) {
                request.all();
import java.util.Arrays;  
                .getMemorySizeInBytes(),
            for (Flag flag : values) {  
        assertThat(stats.getTotal().getStore(), notNullValue());
        assertThat(stats.getTotalShards(), equalTo(numShards1 + numShards2));
                .get(1)  
        assertThat(shardFailures.get(), emptyCollectionOf(DefaultShardOperationFailedException.class));  
        assertThat(stats.getTotalShards(), equalTo(numShards2));
        IndicesStatsResponse stats;
                .setId(Integer.toString(1))  
            assertThat(
        assertThat(stats.getTotal().search.getGroupStats().get("baz").getQueryCount(), greaterThan(0L));
        assertThat(flags.anySet(), equalTo(true));
            RestStatus.CREATED,  
        assertThat(
        // test explicit request parameter  
import org.opensearch.action.DocWriteResponse;
        assertThat(
    @Override  
        // check get
                    .getMemorySizeInBytes(),  
        }  
import java.util.concurrent.atomic.AtomicReference;  

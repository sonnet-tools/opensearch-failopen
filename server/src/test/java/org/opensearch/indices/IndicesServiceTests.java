            setupMocksForCanCache(context, cacheHelper);
                assertThat(
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
            .build();
                fail(e.getMessage());
        }
import java.util.stream.Stream;
            if (randomBoolean()) {
        assertTrue(test.hasShard(0));
            } else {
        final ClusterState csWithIndex = new ClusterState.Builder(clusterService.state()).metadata(metadata).build();
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
                );
        assertAcked(client().admin().indices().prepareOpen("test"));
import org.opensearch.test.OpenSearchSingleNodeTestCase;
package org.opensearch.indices;
 * under the License.
                indicesService.processPendingDeletes(index, indexSettings, TimeValue.timeValueMillis(0));
            return Collections.singletonList(FOO_INDEX_SETTING);
            new AlreadyClosedException(message)
import org.opensearch.index.IndexModule;
import org.opensearch.Version;
        });
import org.opensearch.core.index.Index;
import org.apache.lucene.store.AlreadyClosedException;
                return Optional.empty();
        when(indexService.index()).thenReturn(index);
import org.opensearch.index.engine.EngineFactory;
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(
        assertThat(clusterService.state(), equalTo(originalState));
            assertTrue(indicesService.isMetadataField(builtIn));
                shardStats.add(successfulShardStats);
        // Simulate the cluster setting update by manually calling setCanCacheSizeNonzeroRequests
    public void testVerifyIfIndexContentDeleted() throws Exception {
        when(mockIndicesService.iterator()).thenReturn(Collections.singleton(indexService).iterator());
import java.util.concurrent.CountDownLatch;
    }
    public void testConflictingEngineFactories() {
    public void testStatsByShardDoesNotDieFromExpectedExceptions() {
        ClusterService clusterService = getInstanceFromNode(ClusterService.class);
            getNodeEnvironment(),
            .settings(settings(Version.CURRENT))
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);
        final Index index = indexService.index();
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
        dangling.allocateDangled(Arrays.asList(indexMetadataLater), ActionListener.wrap(latch::countDown));
        assertNotNull(meta.index("test"));
        final IndicesService indicesService = getIndicesService();
        assertThat("unexpected shard stats", indexStats.get(index), equalTo(shardStats));
        ShardId shardId = new ShardId(meta.getIndex(), 0);
                return Optional.of(new FooEngineFactory());
/*
        SearchStatsContributor empty = () -> null;
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
        final Index index = new Index(indexName, UUIDs.randomBase64UUID());
            .build();
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.plugins.EnginePlugin;
            }
        Map<TestSearchContext, Boolean> expectedResultMap = Map.of(sizeZeroContext, true, sizeNonzeroContext, false);
            final Index index = new Index(indexName, UUIDs.randomBase64UUID());
        assertNotNull(indexShard);
            IndexReader.CacheHelper cacheHelper = useDelegatingCacheHelper ? delegatingCacheHelper : notDelegatingCacheHelper;
            indexModule.addSimilarity("fake-similarity", (settings, indexCreatedVersion, scriptService) -> new BM25Similarity());
import org.opensearch.index.IndexService;
            // Non-Search flags must not invoke the contributors. Asking for Indexing only should
        indicesService.setSearchStatsContributors(List.of(populated, empty));
        } else {
        expectThrows(IllegalStateException.class, () -> indicesService.deleteIndexStore("boom", firstMetadata));
 * the Apache License, Version 2.0 (the "License"); you may
        assertNotNull(baseline);
            .build();
            // would surface here if the case Search: branch wasn't gated by the flag.
            } else {
            ShardDeletionCheckResult.NO_FOLDER_FOUND
        assertTrue(indicesService.hasUncompletedPendingDeletes());
     * custom types and similarities registered by plugins
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        final String indexName = "test";
            @Override
            .put(IndexModule.SIMILARITY_SETTINGS_PREFIX + ".test.type", "fake-similarity")
import org.opensearch.env.NodeEnvironment;
import org.opensearch.core.index.shard.ShardId;
        final Index index = new Index("test", UUIDs.randomBase64UUID());
        assertEquals(
                );
            final IndexShard shard = mock(IndexShard.class);
        final Settings idxSettings = Settings.builder()
     * that tombstones that have the same name as current valid indices don't cause confusion by
    }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testDanglingIndicesWithAliasConflict() throws Exception {
import static org.hamcrest.Matchers.containsString;
 *
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .build();
import org.opensearch.index.shard.IndexShardState;
        when(reader.getReaderCacheHelper()).thenReturn(cacheHelper);
        assertTrue(indicesService.hasUncompletedPendingDeletes());
            .build();
        assertThat(sim, instanceOf(NonNegativeScoresSimilarity.class));
        IndicesService indicesService = getIndicesService();
        }
    }
        IndexMetadata secondMetadata = clusterService.state().metadata().index("test");
            if (value != null && value) {
        final Index index = new Index(indexName, UUIDs.randomBase64UUID());
            IllegalStateException.class,
            Metadata.builder(csWithIndex.metadata()).remove(index.getName())
        );
            .build();
            Setting.Property.IndexScope
        @Override
        assertThat(clusterService.state(), equalTo(originalState));
    public void testClusterRemoteTranslogBufferIntervalDefault() {
    public void testDanglingIndicesWithLaterVersion() throws Exception {
            .build();
                    ((EngineBackedIndexerFactory) indexService.getIndexerFactory()).getEngineFactory(),
        final IndicesService indicesService = getIndicesService();
            .numberOfReplicas(0)
            new SearchStats.Stats.Builder().queryCount(7).queryTimeInMillis(123).build(),
    public void testCanDeleteShardContent() {
            assertEquals(entry.getValue(), indicesService.canCache(request, context));
        }
            .numberOfShards(1)
import org.opensearch.cluster.ClusterState;
            indicesService.canDeleteShardContent(shardId, test.getIndexSettings()),
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
            super.onIndexModule(indexModule);
    private void setupMocksForCanCache(TestSearchContext context, IndexReader.CacheHelper cacheHelper) {
import org.opensearch.index.engine.InternalEngineFactory;
import org.opensearch.index.shard.IndexShard;
        // Test for an IndicesService with the default setting value of 0
    public void testCanCacheSizeNonzero() {
            indicesService.canDeleteShardContent(notAllocated, test.getIndexSettings()),
import org.opensearch.core.util.FileSystemUtils;
            assertNotNull(merged);
import org.opensearch.common.settings.Setting;
import org.opensearch.cluster.metadata.IndexGraveyard;
import org.opensearch.index.engine.InternalEngine;
            "no shard location",
        assertNotNull(clusterService.state().getMetadata().index(alias));
            "index.foo_index",
        final String indexName = "test-idx1";
        @Override
import org.opensearch.index.IndexSettings;
            } else {
import java.util.List;
import org.opensearch.index.mapper.Mapper;
     * throw any errors that the index still exists in the cluster state.  This is a case of ensuring
            indicesService.verifyIndexIsDeleted(index, csWithIndex);
        @Override
        final Settings settings = Settings.builder()
        TestSearchContext sizeNonzeroContext = getTestContext(indexService, 10);
        for (final Boolean value : values) {
        final Settings idxSettings = Settings.builder()
import static org.mockito.Mockito.when;
            .build();
            assertThat(e.getMessage(), containsString("Cannot delete index"));
        final LocalAllocateDangledIndices dangling = getInstanceFromNode(LocalAllocateDangledIndices.class);
        );
            return Collections.singletonList(BAR_INDEX_SETTING);
        final NodeEnvironment nodeEnv = getNodeEnvironment();
        createIndex(indexName);
        GatewayMetaState gwMetaState = getInstanceFromNode(GatewayMetaState.class);
    }
        SearchStatsContributor populated = () -> new SearchStats(
    @Override
                assertThat(indexService.getIndexerFactory(), instanceOf(EngineBackedIndexerFactory.class));
 *     http://www.apache.org/licenses/LICENSE-2.0
        private static final Setting<Boolean> BAR_INDEX_SETTING = Setting.boolSetting(
import org.opensearch.index.search.stats.SearchStats;
        }
 * specific language governing permissions and limitations
        final LocalAllocateDangledIndices dangling = getInstanceFromNode(LocalAllocateDangledIndices.class);
        final List<IndexShardStats> shardStats = new ArrayList<>(shardCount - 1);
        final Settings idxSettingsLater = Settings.builder()
     * deleted it (so a tombstone entry for A will exist in the cluster state), then created
        }
        IndexService test = createIndex("test");
     */
            TestSearchContext context = entry.getKey();
        }
            }
        ShardSearchRequest request = mock(ShardSearchRequest.class);
        SearchStats baseline = indicesService.stats(new CommonStatsFlags(Flag.Search)).getSearch();
     * This test checks an edge case where, if a node had an index (lets call it A with UUID 1), then
        final String indexName = "foobar";
        for (Map.Entry<TestSearchContext, Boolean> entry : expectedResultMap.entrySet()) {
        latch = new CountDownLatch(1);
import org.apache.lucene.index.IndexReader;
    public static class BarEnginePlugin extends Plugin implements EnginePlugin {
        meta = gwMetaState.getMetadata();
        final String pattern =
        dangling.allocateDangled(Arrays.asList(indexMetadata), ActionListener.wrap(latch::countDown));
        IndicesService indicesService = getIndicesService();
        final List<IndexShard> shards = new ArrayList<>(shardCount);
            fail("Should not be able to delete index contents when the index is part of the cluster state.");
            }
        // if all goes well, this won't throw an exception, otherwise, it will throw an IllegalStateException
            assertEquals(indicesService.numPendingDeletes(index), numPending + 2);
            @Override
        @Override
        ShardPath secondPath = ShardPath.loadShardPath(
        ).build();
                    instanceOf(FooEnginePlugin.FooEngineFactory.class)
        }
import org.opensearch.search.internal.ShardSearchRequest;
            final Settings.Builder builder = Settings.builder()
        assertFalse(indicesService.isMetadataField(randomAlphaOfLengthBetween(10, 15)));
import org.opensearch.action.admin.indices.stats.CommonStatsFlags.Flag;
                return new InternalEngine(config);
            null
        final MetaStateService metaStateService = getInstanceFromNode(MetaStateService.class);
        ensureGreen("test");
import org.opensearch.plugins.SearchStatsContributor;
    public static class TestPlugin extends Plugin implements MapperPlugin {
        }
     * trying to delete an index that exists.
        test = createIndex("test");
        indicesService.verifyIndexIsDeleted(tombstonedIndex, clusterState);
        when(request.requestCache()).thenReturn(true);
        static class FooEngineFactory implements EngineFactory {
            () -> indicesService.createIndex(indexMetadata, Collections.emptyList(), false)
        IndexReader.CacheHelper notDelegatingCacheHelper = mock(IndexReader.CacheHelper.class);
        assertNotNull(mapperService.documentMapperParser().parserContext().typeParser("fake-mapper"));
    }
            indicesService.addPendingDelete(indexShard.shardId(), indexSettings);
        public TestPlugin() {}
        // import an index with minor version incremented by one over cluster cluster-manager version, it should be ignored
import static org.hamcrest.Matchers.instanceOf;
        static class BarEngineFactory implements EngineFactory {
                return Optional.of(new BarEngineFactory());
        // try to import a dangling index with the same name as the alias, it should fail
        final IndexShardState state = randomFrom(IndexShardState.values());
        final Metadata metadata = Metadata.builder(clusterService.state().metadata()).put(indexMetadata, true).build();
        ShardId notAllocated = new ShardId(test.index(), 100);
        );
    public void testPendingTasks() throws Exception {
        try {
     * Tests that the {@link MapperService} created by {@link IndicesService#createIndexMapperService(IndexMetadata)} contains
        final int failedShardId = randomIntBetween(0, shardCount - 1);
            if (value != null) {
    }
        assertFalse(firstPath.exists());
import org.opensearch.core.action.ActionListener;
        IndexMetadata firstMetadata = clusterService.state().metadata().index("test");
            assertThat(indicesService.hasUncompletedPendingDeletes(), equalTo(hasBogus)); // "bogus" index has not been removed
        }
            if (FOO_INDEX_SETTING.get(indexSettings.getSettings())) {
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
            test.getIndexSettings().customDataPath()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            setupMocksForCanCache(context, cacheHelper);
        IndicesService indicesService = getIndicesService();
        );
import org.opensearch.env.ShardLockObtainFailedException;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(
        final IndexSettings indexSettings = indexService.getIndexSettings();
        int numPending = 1;
        final IndicesService indicesService = getIndicesService();
import org.opensearch.index.mapper.MapperService;
            return Collections.singletonMap("fake-mapper", KeywordFieldMapper.PARSER);
    }
        return new TestSearchContext(indexService.getBigArrays(), indexService) {
            assertEquals(baselineQueryCount + 7, merged.getTotal().getQueryCount());
    }
        final Boolean[] values = new Boolean[] { true, false, null };
 * not use this file except in compliance with the License.
        );
        final IndexMetadata indexMetadataLater = new IndexMetadata.Builder(indexNameLater).settings(idxSettingsLater)
        DirectoryReader reader = mock(DirectoryReader.class);
        public Map<String, Mapper.TypeParser> getMappers() {
        };
                return SearchType.QUERY_THEN_FETCH;
        Metadata meta = gwMetaState.getMetadata();
        public void onIndexModule(IndexModule indexModule) {
        final IndexService indexService = createIndex("test");
            @Override
    }
            .numberOfReplicas(0)
        assertEquals(
        metaStateService.writeIndex("test index being created", indexMetadata);
        for (String builtIn : IndicesModule.getBuiltInMetadataFields()) {
            indicesService.canDeleteShardContent(shardId, indexSettings),
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.cluster.ClusterName;
        final ClusterState withoutIndex = new ClusterState.Builder(csWithIndex).metadata(
    public NodeEnvironment getNodeEnvironment() {
 *
/*
/*
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
                assertThat(indexService.getIndexerFactory(), instanceOf(EngineBackedIndexerFactory.class));
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        IndexMetadata meta = IndexMetadata.builder("test")
        }
        MapperService mapperService = indicesService.createIndexMapperService(indexMetadata);
        final ClusterState clusterState = new ClusterState.Builder(new ClusterName("testCluster")).metadata(metadata).build();
        ShardSearchRequest request = mock(ShardSearchRequest.class);
        return true;
        @Override
import org.opensearch.test.hamcrest.RegexMatcher;
            getNodeEnvironment(),
        assertTrue(firstPath.exists());
        final String indexNameLater = "test-idxnewer";
            () -> indicesService.processPendingDeletes(index, indexSettings, TimeValue.timeValueMillis(0))
                .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID());
    public void testStatsMergesSearchStatsContributors() {
            }
import org.opensearch.test.TestSearchContext;
        when(request.requestCache()).thenReturn(null);
            indicesService.addPendingDelete(new ShardId(index, 0), indexSettings);
        assertEquals(indicesService.numPendingDeletes(index), numPending);
            "shard is allocated",
            IndexSettings.DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL,
            final IndexService indexService = indicesService.createIndex(indexMetadata, Collections.emptyList(), false);
import org.apache.lucene.search.similarities.Similarity;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(sim, instanceOf(BM25Similarity.class));
import static org.mockito.Mockito.mock;
    }
            "shard is removed",
        int maxCacheableSize = 40;
    public void testIndexAndTombstoneWithSameNameOnStartup() throws Exception {
            .build();
    public void testIsMetadataField() {
            public Engine newReadWriteEngine(final EngineConfig config) {
        client().admin().indices().prepareAliases().addAlias(indexName, alias).get();
 * license agreements. See the NOTICE file distributed with
        context.setSearcher(searcher);
        when(searcher.getDirectoryReader()).thenReturn(reader);
            ShardDeletionCheckResult.STILL_ALLOCATED
                .numberOfShards(1)
        assertEquals(
import org.opensearch.action.admin.indices.stats.IndexShardStats;
            }
    private TestSearchContext getTestContext(IndexService indexService, int size) {
 */
                numPending++;
    public IndicesService getIndicesService() {
    }
        final Metadata metadata = Metadata.builder().put(indexMetadata, true).indexGraveyard(graveyard).build();
        // the shard that is going to fail
        // shard stats, which are zero on this single-node test fixture with no queries fired.
            ShardLockObtainFailedException.class,
            .numberOfReplicas(0)
 */
import static org.hamcrest.Matchers.not;
        } catch (IllegalStateException e) {
 * ownership. Elasticsearch licenses this file to you under
                    ((EngineBackedIndexerFactory) indexService.getIndexerFactory()).getEngineFactory(),
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
                .numberOfReplicas(0)
import org.opensearch.cluster.service.ClusterService;
import org.apache.lucene.search.similarities.BM25Similarity;
    }
        IndicesService indicesService = getIndicesService();
import java.util.ArrayList;
import org.opensearch.gateway.MetaStateService;
        assertAcked(client().admin().indices().prepareClose("test"));
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
    }
            }
import org.opensearch.action.search.SearchType;
        final String message = "TEST - expected";
        @Override
        if (hasBogus) {
     * tombstones for deletions, and it should proceed with trying to delete A with UUID 1 and not
    }
import java.util.Optional;
        assertNotNull(meta);
            }
    /**
        DelegatingCacheHelper cacheHelper = mock(DelegatingCacheHelper.class);
                final IndexShardStats successfulShardStats = mock(IndexShardStats.class);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.similarity.NonNegativeScoresSimilarity;
    }
        try {
        final IndicesService indicesService = getIndicesService();
            assertTrue(indicesService.hasUncompletedPendingDeletes());
        expectedResultMap = Map.of(sizeZeroContext, true, sizeEqualsThresholdContext, true, sizeAboveThresholdContext, false);
            assertEquals(entry.getValue(), indicesService.canCache(request, context));
        assertNotNull(meta);
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {
            .build();
            .build();
     * See https://github.com/elastic/elasticsearch/issues/18054
            if (BAR_INDEX_SETTING.get(indexSettings.getSettings())) {
        TestSearchContext sizeAboveThresholdContext = getTestContext(indexService, maxCacheableSize + 5);
            SearchStats merged = indicesService.stats(new CommonStatsFlags(Flag.Search)).getSearch();
        assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(1));
 */
import org.opensearch.plugins.Plugin;
        assertEquals(
        client().admin().indices().prepareFlush("test").get();
        }
            test.getIndexSettings().customDataPath()
                .build();
        final ClusterState originalState = clusterService.state();
            setupMocksForCanCache(context, cacheHelper);
 * this file be licensed under the Apache-2.0 license or a
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            }
        IndicesService indicesService = getIndicesService();
            new ShardId(test.index(), 0),
        assertAcked(client().admin().indices().prepareDelete("test"));
            .numberOfShards(1)
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader.DelegatingCacheHelper;
        assertTrue(secondPath.exists());
        assertTrue(test.hasShard(0));
            false,
        );
            .numberOfReplicas(0)
    }
        );
        }
import org.apache.lucene.index.DirectoryReader;
            .put(FooEnginePlugin.FOO_INDEX_SETTING.getKey(), true)
            Setting.Property.IndexScope
        );
            assertNull(indicesService.stats(new CommonStatsFlags(Flag.Indexing)).getSearch());
        }
            .numberOfShards(1)
        shardId = new ShardId(test.index(), 0);
        }
        indicesService.setMaxSizeInRequestCache(maxCacheableSize);
    }
    public void testGetEngineFactory() throws IOException {
        return Stream.concat(super.getPlugins().stream(), Stream.of(TestPlugin.class, FooEnginePlugin.class, BarEnginePlugin.class))
 * software distributed under the License is distributed on an
        );
import org.opensearch.index.engine.Engine;
    }
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {
        } finally {
            indicesService.canDeleteShardContent(shardId, test.getIndexSettings()),
                assertEquals(indicesService.numPendingDeletes(index), 0);
        for (boolean useDelegatingCacheHelper : new boolean[] { true, false }) {
        ShardPath firstPath = ShardPath.loadShardPath(
        // now try importing a dangling index with the same name as the alias, it should succeed.
    @Override
            try {
            indicesService.addPendingDelete(new ShardId(index, 1), indexSettings);
            ShardLockObtainFailedException.class,
        assertThat(clusterService.state(), not(originalState));
    }
            ".*multiple engine factories provided for \\[foobar/.*\\]: \\[.*FooEngineFactory\\],\\[.*BarEngineFactory\\].*";
     * a new index A with UUID 2, then shutdown, when the node comes back online, it will look at the
        final ShardId shardId = new ShardId(index, failedShardId);
        TestSearchContext sizeZeroContext = getTestContext(indexService, 0);
        ContextIndexSearcher searcher = mock(ContextIndexSearcher.class);
        assertBusy(() -> {
            TestSearchContext context = entry.getKey();
import static org.hamcrest.Matchers.hasToString;
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(alias).settings(idxSettings)
        when(indexService.iterator()).thenReturn(shards.iterator());
            .numberOfReplicas(0)
        final IndicesService indicesService = getIndicesService();
                return Optional.empty();
        final IndexShard indexShard = indexService.getShardOrNull(0);
            indicesService.addPendingDelete(index, indexSettings);
import org.opensearch.index.mapper.KeywordFieldMapper;
            .collect(Collectors.toList());
            logger,
        final boolean hasBogus = randomBoolean();
                indicesService.addPendingDelete(indexShard.shardId(), indexSettings);
            if (failedShardId != i) {
            .numberOfReplicas(1)
        IndicesService indicesService = getIndicesService();
        CountDownLatch latch = new CountDownLatch(1);
        // generate fake shards and their responses
            assertEquals(baselineQueryTime + 123, merged.getTotal().getQueryTimeInMillis());
        client().admin().indices().prepareAliases().removeAlias(indexName, alias).get();
            "index.bar_index",
                return size;
        long baselineQueryTime = baseline.getTotal().getQueryTimeInMillis();
            .numberOfShards(1)
        latch.await();
        );
            () -> indicesService.processPendingDeletes(index, indexSettings, TimeValue.timeValueMillis(0))
        // real one, which has a logger defined
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
        }
    }
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);
            public int size() {
        // Two contributors: one returning real numbers, one returning null. Both must be invoked.
    protected Collection<Class<? extends Plugin>> getPlugins() {
        final Settings idxSettings = Settings.builder()
        // this allows us to control the indices that exist
            }
            .numberOfShards(1)
            }
 * GitHub history for details.
        assertTrue(secondPath.exists());
        final IllegalStateException e = expectThrows(
            assertEquals(useDelegatingCacheHelper, indicesService.canCache(request, context));
import java.util.Map;
            } catch (final Exception e) {
    }
                return new InternalEngine(config);
        }
        assertThat(e, hasToString(new RegexMatcher(pattern)));
        when(searcher.getIndexReader()).thenReturn(reader);
    public void testDeleteIndexStore() throws Exception {
import java.util.Arrays;
        });
        final Index tombstonedIndex = new Index(indexName, UUIDs.randomBase64UUID());
        assertThat("index not defined", indexStats.containsKey(index), equalTo(true));
        final Settings idxSettings = Settings.builder()
        public List<Setting<?>> getSettings() {
        final ClusterState originalState = clusterService.state();
        expectThrows(IllegalStateException.class, () -> indicesService.deleteIndexStore("boom", secondMetadata));
        dangling.allocateDangled(Arrays.asList(indexMetadata), ActionListener.wrap(latch::countDown));
        final Map<Index, List<IndexShardStats>> indexStats = indicesService.statsByShard(mockIndicesService, CommonStatsFlags.ALL);
        test.removeShard(0, "boom");
import org.opensearch.common.UUIDs;
            .put(BarEnginePlugin.BAR_INDEX_SETTING.getKey(), true)
import org.opensearch.cluster.metadata.IndexMetadata;
            shards.add(shard);
        return getInstanceFromNode(NodeEnvironment.class);
        // remove the alias
}
        final Index index = new Index(indexName, UUIDs.randomBase64UUID());
        assertTrue(indexShard.routingEntry().started());
            indicesService.setSearchStatsContributors(Collections.emptyList());
 * You may obtain a copy of the License at
        final IndicesService indicesService = getIndicesService();
        final ShardPath shardPath = indexShard.shardPath();
import org.opensearch.plugins.MapperPlugin;
        client().prepareIndex("test").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
        assertEquals(indicesService.numPendingDeletes(index), numPending);
        for (int i = 0; i < shardCount; ++i) {
    public void testDirectoryReaderWithoutDelegatingCacheHelperNotCacheable() throws IOException {
            false,
        expectThrows(
        assertAcked(client().admin().indices().prepareDelete("test"));
        );
        final int shardCount = randomIntBetween(2, 5);
import org.opensearch.cluster.metadata.Metadata;
            "shard that was never on this node should NOT be deletable",
            .numberOfShards(1)
import org.opensearch.gateway.GatewayMetaState;
            indicesService.addPendingDelete(new ShardId("bogus", "_na_", 1), indexSettings);
    }
        Similarity sim = mapperService.documentMapperParser().parserContext().getSimilarity("test").get();
        assertThat(indexStats.isEmpty(), equalTo(false));
import org.opensearch.indices.IndicesService.ShardDeletionCheckResult;
    public void testStandAloneMapperServiceWithPlugins() throws IOException {
            .numberOfReplicas(0)
            public SearchType searchType() {
        for (Map.Entry<TestSearchContext, Boolean> entry : expectedResultMap.entrySet()) {
        final IndexGraveyard graveyard = IndexGraveyard.builder().addTombstone(tombstonedIndex).build();
            new ShardId(test.index(), 0),
            // leave the search block null in the response — the populated contributor's numbers
    }
        final IndexService indexService = createIndex("test");
        final IndexService indexService = mock(IndexService.class);
        // Baseline: no contributors registered. The Search block reflects only the node's own
            .build();
        // create the alias for the index
            shardPath
        );
                builder.put(FooEnginePlugin.FOO_INDEX_SETTING.getKey(), value);
        public List<Setting<?>> getSettings() {
        final IndicesService indicesService = getIndicesService();
        IndicesService indicesService = getIndicesService();
        DelegatingCacheHelper delegatingCacheHelper = mock(DelegatingCacheHelper.class);
 *
import org.opensearch.test.IndexSettingsModule;
            new IllegalIndexShardStateException(shardId, state, message),
    }
            indicesService.getRemoteStoreSettings().getClusterRemoteTranslogBufferInterval()
import org.opensearch.index.shard.IllegalIndexShardStateException;
 * The OpenSearch Contributors require contributions made to
            final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(builder.build())
        latch.await();
        IndexService test = createIndex("test");
 * this work for additional information regarding copyright
        assertBusy(() -> {
        );
            public Engine newReadWriteEngine(final EngineConfig config) {
import org.opensearch.search.internal.ContextIndexSearcher;
                when(mockIndicesService.indexShardStats(mockIndicesService, shard, CommonStatsFlags.ALL)).thenThrow(expectedException);
        }
import org.opensearch.gateway.LocalAllocateDangledIndices;
            }
            logger,
import org.opensearch.common.settings.Settings;
        final Index index = new Index("test-index", "abc123");
        return getInstanceFromNode(IndicesService.class);
                    instanceOf(InternalEngineFactory.class)
 * Licensed to Elasticsearch under one or more contributor
        assertNull(meta.index("test"));
 * KIND, either express or implied.  See the License for the
        long baselineQueryCount = baseline.getTotal().getQueryCount();
        TestSearchContext context = getTestContext(indexService, 0);
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);
    }
    /**
        latch.await();
        final RuntimeException expectedException = randomFrom(
import java.util.stream.Collectors;
        private static final Setting<Boolean> FOO_INDEX_SETTING = Setting.boolSetting(
                when(mockIndicesService.indexShardStats(mockIndicesService, shard, CommonStatsFlags.ALL)).thenReturn(successfulShardStats);
    public static class FooEnginePlugin extends Plugin implements EnginePlugin {
        );
            .numberOfShards(1)
        );
import org.opensearch.common.unit.TimeValue;
            final String indexName = "foo-" + value;
            ShardDeletionCheckResult.NO_FOLDER_FOUND
            .build();
            ShardDeletionCheckResult.FOLDER_FOUND_CAN_DELETE
 * compatible open source license.
        sim = ((NonNegativeScoresSimilarity) sim).getDelegate();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.fromId(Version.CURRENT.id + 10000))
                assertThat(
import org.opensearch.index.engine.EngineConfig;
        ensureGreen("test");
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
            @Override
        final IndexService indexService = createIndex("test");
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        if (randomBoolean()) {
        final IndicesService mockIndicesService = mock(IndicesService.class);
 * Unless required by applicable law or agreed to in writing,
    protected boolean resetNodeAfterTest() {
     */
        TestSearchContext sizeEqualsThresholdContext = getTestContext(indexService, maxCacheableSize);
        assertFalse("index files should be deleted", FileSystemUtils.exists(nodeEnv.indexPaths(index)));
            } else {
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(settings)
        assertTrue(shardPath.exists());
        assertHitCount(client().prepareSearch("test").get(), 1);
import java.util.Collections;
        assertEquals(
        final String indexName = "test";
import org.opensearch.index.shard.ShardPath;
import java.io.IOException;
        // Requests should only be cached if their size is <= INDICES_REQUEST_CACHE_MAX_SIZE_TO_CACHE_SETTING.
import java.util.Collection;
            0,
        indicesService.verifyIndexIsDeleted(index, withoutIndex);
public class IndicesServiceTests extends OpenSearchSingleNodeTestCase {
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
        final String alias = "test-alias";
        assertTrue(shardPath.exists());
            ShardPath.loadShardPath(logger, getNodeEnvironment(), indexShard.shardId(), indexSettings.customDataPath()),
            assertFalse(shardPath.exists());

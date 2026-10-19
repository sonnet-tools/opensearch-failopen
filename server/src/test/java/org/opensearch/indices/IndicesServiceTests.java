 * not use this file except in compliance with the License.
            indicesService.addPendingDelete(new ShardId(index, 1), indexSettings);
        assertTrue(test.hasShard(0));
        final Settings idxSettings = Settings.builder()
        return new TestSearchContext(indexService.getBigArrays(), indexService) {  
    }
import org.opensearch.index.similarity.NonNegativeScoresSimilarity;
        try {
 * software distributed under the License is distributed on an
        TestSearchContext sizeEqualsThresholdContext = getTestContext(indexService, maxCacheableSize);  
        expectedResultMap = Map.of(sizeZeroContext, true, sizeEqualsThresholdContext, true, sizeAboveThresholdContext, false);
        final String pattern =  
        assertNotNull(baseline);
import org.opensearch.cluster.ClusterState;
        final ClusterState originalState = clusterService.state();  
    public NodeEnvironment getNodeEnvironment() {
            .build();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import java.util.Collections;
        IndexService test = createIndex("test");
        assertEquals(
        for (final Boolean value : values) {
        TestSearchContext context = getTestContext(indexService, 0);
        ShardId shardId = new ShardId(meta.getIndex(), 0);
        CountDownLatch latch = new CountDownLatch(1);
        assertTrue(secondPath.exists());
import java.util.Map;  
     * This test checks an edge case where, if a node had an index (lets call it A with UUID 1), then
        for (int i = 0; i < shardCount; ++i) {
import org.opensearch.core.action.ActionListener;  
            .build();  
                assertThat(  
    }
        latch.await();
            getNodeEnvironment(),
            indicesService.addPendingDelete(index, indexSettings);
    }
            "index.foo_index",  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        );
        );  
     * a new index A with UUID 2, then shutdown, when the node comes back online, it will look at the  
        final boolean hasBogus = randomBoolean();
    }  
 */
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)  
                return Optional.empty();  
import org.opensearch.plugins.EnginePlugin;
import static org.hamcrest.Matchers.equalTo;
                );  
        assertAcked(client().admin().indices().prepareClose("test"));
        assertEquals(indicesService.numPendingDeletes(index), numPending);
import org.opensearch.core.index.shard.ShardId;
    public void testStatsByShardDoesNotDieFromExpectedExceptions() {
        final IndicesService indicesService = getIndicesService();
        final Index index = new Index(indexName, UUIDs.randomBase64UUID());
        private static final Setting<Boolean> BAR_INDEX_SETTING = Setting.boolSetting(
            } else {
            final Settings.Builder builder = Settings.builder()
        ensureGreen("test");
        final NodeEnvironment nodeEnv = getNodeEnvironment();
import org.opensearch.index.shard.ShardPath;
        assertEquals(indicesService.numPendingDeletes(index), numPending);
import java.util.stream.Collectors;  
        @Override
            new ShardId(test.index(), 0),
/*
        SearchStatsContributor populated = () -> new SearchStats(  
        }  
                indicesService.processPendingDeletes(index, indexSettings, TimeValue.timeValueMillis(0));
    }
            .numberOfShards(1)
        final LocalAllocateDangledIndices dangling = getInstanceFromNode(LocalAllocateDangledIndices.class);
            indicesService.addPendingDelete(new ShardId("bogus", "_na_", 1), indexSettings);
        final int shardCount = randomIntBetween(2, 5);
            .numberOfShards(1)
    public void testClusterRemoteTranslogBufferIntervalDefault() {
        expectThrows(IllegalStateException.class, () -> indicesService.deleteIndexStore("boom", secondMetadata));  
        assertEquals(
    public void testIndexAndTombstoneWithSameNameOnStartup() throws Exception {
    }  
        final IndexService indexService = mock(IndexService.class);
        ShardPath firstPath = ShardPath.loadShardPath(  
        when(indexService.iterator()).thenReturn(shards.iterator());  
            .numberOfReplicas(0)  
            }
 * specific language governing permissions and limitations
            assertEquals(indicesService.numPendingDeletes(index), numPending + 2);  
        final Boolean[] values = new Boolean[] { true, false, null };  
package org.opensearch.indices;
        assertHitCount(client().prepareSearch("test").get(), 1);
        Similarity sim = mapperService.documentMapperParser().parserContext().getSimilarity("test").get();
            ShardDeletionCheckResult.NO_FOLDER_FOUND  
        assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(1));  
import org.opensearch.index.IndexModule;  
        private static final Setting<Boolean> FOO_INDEX_SETTING = Setting.boolSetting(
        final IndexShardState state = randomFrom(IndexShardState.values());  
        }  
            assertTrue(indicesService.isMetadataField(builtIn));
import org.opensearch.indices.IndicesService.ShardDeletionCheckResult;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            assertThat(e.getMessage(), containsString("Cannot delete index"));
        assertNotNull(meta);  
        assertBusy(() -> {
import java.util.Optional;
        ensureGreen("test");  
        }
    }  
import org.opensearch.core.index.Index;
        final IndexShard indexShard = indexService.getShardOrNull(0);  
        SearchStatsContributor empty = () -> null;
            @Override
            .numberOfShards(1)
 *
     * deleted it (so a tombstone entry for A will exist in the cluster state), then created
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.env.ShardLockObtainFailedException;
            assertTrue(indicesService.hasUncompletedPendingDeletes());
        indicesService.setMaxSizeInRequestCache(maxCacheableSize);
        }
        SearchStats baseline = indicesService.stats(new CommonStatsFlags(Flag.Search)).getSearch();  
            final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(builder.build())
        final IndexGraveyard graveyard = IndexGraveyard.builder().addTombstone(tombstonedIndex).build();
        indicesService.setSearchStatsContributors(List.of(populated, empty));  
import org.opensearch.index.shard.IndexShard;
        );
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {
            .build();
        }
        final Map<Index, List<IndexShardStats>> indexStats = indicesService.statsByShard(mockIndicesService, CommonStatsFlags.ALL);  
        final String indexNameLater = "test-idxnewer";
        final IndicesService indicesService = getIndicesService();
        assertNotNull(mapperService.documentMapperParser().parserContext().typeParser("fake-mapper"));  
    }
 * KIND, either express or implied.  See the License for the
        shardId = new ShardId(test.index(), 0);  
            Setting.Property.IndexScope
            test.getIndexSettings().customDataPath()
 * ownership. Elasticsearch licenses this file to you under  
    public void testIsMetadataField() {
                return Optional.of(new FooEngineFactory());
        @Override  
 * this work for additional information regarding copyright
                assertThat(indexService.getIndexerFactory(), instanceOf(EngineBackedIndexerFactory.class));
            @Override
        final ClusterState clusterState = new ClusterState.Builder(new ClusterName("testCluster")).metadata(metadata).build();
            .put(FooEnginePlugin.FOO_INDEX_SETTING.getKey(), true)
            TestSearchContext context = entry.getKey();
        sim = ((NonNegativeScoresSimilarity) sim).getDelegate();  
        public List<Setting<?>> getSettings() {  
    }
            "shard that was never on this node should NOT be deletable",  
            .build();  
        assertThat(e, hasToString(new RegexMatcher(pattern)));
    }
import org.opensearch.cluster.ClusterName;
        for (boolean useDelegatingCacheHelper : new boolean[] { true, false }) {
        // Test for an IndicesService with the default setting value of 0
            assertNull(indicesService.stats(new CommonStatsFlags(Flag.Indexing)).getSearch());
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader.DelegatingCacheHelper;
    public void testStandAloneMapperServiceWithPlugins() throws IOException {
        context.setSearcher(searcher);
                .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID());  
            .numberOfReplicas(0)
/*  
        MapperService mapperService = indicesService.createIndexMapperService(indexMetadata);
            public SearchType searchType() {
            ".*multiple engine factories provided for \\[foobar/.*\\]: \\[.*FooEngineFactory\\],\\[.*BarEngineFactory\\].*";
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
            }  
            assertEquals(baselineQueryTime + 123, merged.getTotal().getQueryTimeInMillis());
    public void testGetEngineFactory() throws IOException {  
        assertTrue(indexShard.routingEntry().started());
     */  
                final IndexShardStats successfulShardStats = mock(IndexShardStats.class);
 *  
        // remove the alias
            "shard is removed",  
    private void setupMocksForCanCache(TestSearchContext context, IndexReader.CacheHelper cacheHelper) {
        IndexMetadata secondMetadata = clusterService.state().metadata().index("test");
            }  
    public void testConflictingEngineFactories() {
            .settings(settings(Version.CURRENT))  
            ShardLockObtainFailedException.class,  
        int maxCacheableSize = 40;
        client().admin().indices().prepareAliases().removeAlias(indexName, alias).get();
            indicesService.canDeleteShardContent(shardId, test.getIndexSettings()),
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
            final IndexShard shard = mock(IndexShard.class);
                return Optional.empty();  
    private TestSearchContext getTestContext(IndexService indexService, int size) {
                when(mockIndicesService.indexShardStats(mockIndicesService, shard, CommonStatsFlags.ALL)).thenReturn(successfulShardStats);
    }
            } else {
            .numberOfReplicas(0)
    /**  
import org.opensearch.index.shard.IndexShardState;  
        assertTrue(firstPath.exists());
            .numberOfReplicas(0)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import org.opensearch.action.admin.indices.stats.IndexShardStats;
import static org.hamcrest.Matchers.containsString;  
    }
        final Settings settings = Settings.builder()
import java.util.Collection;  
            }
        );
            indexModule.addSimilarity("fake-similarity", (settings, indexCreatedVersion, scriptService) -> new BM25Similarity());  
import static org.hamcrest.Matchers.not;
        final IndicesService indicesService = getIndicesService();
            }
        IndicesService indicesService = getIndicesService();
        if (hasBogus) {
        TestSearchContext sizeZeroContext = getTestContext(indexService, 0);
        indicesService.verifyIndexIsDeleted(tombstonedIndex, clusterState);  
import org.opensearch.plugins.Plugin;  
        public TestPlugin() {}
            }
            .build();  
            .numberOfShards(1)
            }  
        final IndicesService mockIndicesService = mock(IndicesService.class);  
import org.opensearch.common.settings.Settings;
            shardPath
        when(mockIndicesService.iterator()).thenReturn(Collections.singleton(indexService).iterator());
            .build();
        // import an index with minor version incremented by one over cluster cluster-manager version, it should be ignored
        final Index tombstonedIndex = new Index(indexName, UUIDs.randomBase64UUID());
            .put(IndexModule.SIMILARITY_SETTINGS_PREFIX + ".test.type", "fake-similarity")
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;  
import org.opensearch.Version;
            }
            .put(BarEnginePlugin.BAR_INDEX_SETTING.getKey(), true)  
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);
            ShardDeletionCheckResult.NO_FOLDER_FOUND
     * Tests that the {@link MapperService} created by {@link IndicesService#createIndexMapperService(IndexMetadata)} contains
                    ((EngineBackedIndexerFactory) indexService.getIndexerFactory()).getEngineFactory(),
                return new InternalEngine(config);  
            logger,
        dangling.allocateDangled(Arrays.asList(indexMetadata), ActionListener.wrap(latch::countDown));  
    public static class BarEnginePlugin extends Plugin implements EnginePlugin {  
        );  
import org.apache.lucene.search.similarities.Similarity;  
            .numberOfShards(1)
        }
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);  
        assertNull(meta.index("test"));
            "no shard location",
        when(searcher.getIndexReader()).thenReturn(reader);
            .numberOfReplicas(0)
        when(request.requestCache()).thenReturn(null);  
        final List<IndexShardStats> shardStats = new ArrayList<>(shardCount - 1);
            new SearchStats.Stats.Builder().queryCount(7).queryTimeInMillis(123).build(),
 * Modifications Copyright OpenSearch Contributors. See  
        final MetaStateService metaStateService = getInstanceFromNode(MetaStateService.class);
            logger,
        }  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.engine.EngineFactory;
        }  
    }
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)  
import java.util.stream.Stream;
    }  
import org.opensearch.search.internal.ShardSearchRequest;  
import org.apache.lucene.search.similarities.BM25Similarity;
                fail(e.getMessage());
        );  
        ShardId notAllocated = new ShardId(test.index(), 100);
        @Override
            assertEquals(useDelegatingCacheHelper, indicesService.canCache(request, context));
        IndicesService indicesService = getIndicesService();  
import org.opensearch.test.TestSearchContext;  
        final String alias = "test-alias";
        dangling.allocateDangled(Arrays.asList(indexMetadataLater), ActionListener.wrap(latch::countDown));
        final Settings idxSettings = Settings.builder()  
        meta = gwMetaState.getMetadata();  
        return getInstanceFromNode(IndicesService.class);
 *     http://www.apache.org/licenses/LICENSE-2.0
        } finally {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.unit.TimeValue;
        IndicesService indicesService = getIndicesService();
        final Settings idxSettings = Settings.builder()
        }
            // would surface here if the case Search: branch wasn't gated by the flag.  
        test = createIndex("test");
 * You may obtain a copy of the License at  
            .build();
        final Metadata metadata = Metadata.builder().put(indexMetadata, true).indexGraveyard(graveyard).build();  
        assertEquals(
import org.opensearch.index.mapper.Mapper;
        }
        client().admin().indices().prepareFlush("test").get();  
        try {
            Setting.Property.IndexScope
            () -> indicesService.processPendingDeletes(index, indexSettings, TimeValue.timeValueMillis(0))
                    instanceOf(InternalEngineFactory.class)
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);
        when(indexService.index()).thenReturn(index);
        IndicesService indicesService = getIndicesService();
        long baselineQueryCount = baseline.getTotal().getQueryCount();
            public Engine newReadWriteEngine(final EngineConfig config) {
            indicesService.canDeleteShardContent(notAllocated, test.getIndexSettings()),
        assertEquals(  
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        );
    }
            indicesService.addPendingDelete(indexShard.shardId(), indexSettings);
        dangling.allocateDangled(Arrays.asList(indexMetadata), ActionListener.wrap(latch::countDown));  
import org.opensearch.plugins.SearchStatsContributor;
                .numberOfReplicas(0)
 * license agreements. See the NOTICE file distributed with
        assertTrue(shardPath.exists());
        assertThat(sim, instanceOf(NonNegativeScoresSimilarity.class));
import org.opensearch.gateway.GatewayMetaState;  
        ShardPath secondPath = ShardPath.loadShardPath(
import java.util.List;
        );
import org.opensearch.gateway.MetaStateService;
 */  
        IndicesService indicesService = getIndicesService();
            test.getIndexSettings().customDataPath()
            indicesService.setSearchStatsContributors(Collections.emptyList());  
            indicesService.canDeleteShardContent(shardId, indexSettings),
            .numberOfReplicas(0)  
        assertBusy(() -> {
        when(searcher.getDirectoryReader()).thenReturn(reader);  
        } else {
        assertTrue(indicesService.hasUncompletedPendingDeletes());  
     */  
 * The OpenSearch Contributors require contributions made to  
            new ShardId(test.index(), 0),  
            } catch (final Exception e) {  
                );  
        // Two contributors: one returning real numbers, one returning null. Both must be invoked.
            indicesService.canDeleteShardContent(shardId, test.getIndexSettings()),
        }
import org.apache.lucene.index.DirectoryReader;  
import org.opensearch.common.UUIDs;
        final Settings idxSettings = Settings.builder()
        );  
            assertEquals(entry.getValue(), indicesService.canCache(request, context));
import org.opensearch.plugins.MapperPlugin;
            if (value != null && value) {
        TestSearchContext sizeNonzeroContext = getTestContext(indexService, 10);  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        CountDownLatch latch = new CountDownLatch(1);  
        assertNotNull(meta);
import org.opensearch.cluster.metadata.IndexGraveyard;  
            try {  
 */
import org.apache.lucene.index.IndexReader;
                return size;
        GatewayMetaState gwMetaState = getInstanceFromNode(GatewayMetaState.class);
        assertThat(sim, instanceOf(BM25Similarity.class));
        when(request.requestCache()).thenReturn(true);
        assertTrue(indicesService.hasUncompletedPendingDeletes());
            new AlreadyClosedException(message)
        }
                numPending++;
import org.opensearch.core.util.FileSystemUtils;  
 * the Apache License, Version 2.0 (the "License"); you may
        });  
        );
import org.opensearch.search.internal.ContextIndexSearcher;
            super.onIndexModule(indexModule);
        final Index index = new Index("test-index", "abc123");
        );
 * Licensed to Elasticsearch under one or more contributor  
        final Index index = new Index("test", UUIDs.randomBase64UUID());
        final String message = "TEST - expected";
    @Override
        assertTrue(test.hasShard(0));
            @Override
 * Unless required by applicable law or agreed to in writing,
        public void onIndexModule(IndexModule indexModule) {
    public IndicesService getIndicesService() {
            assertNotNull(merged);  
                return Optional.of(new BarEngineFactory());
            public int size() {
        }
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
            0,
                builder.put(FooEnginePlugin.FOO_INDEX_SETTING.getKey(), value);
            }
            } else {  
        final IndicesService indicesService = getIndicesService();
        );
            .numberOfShards(1)  
        assertThat(clusterService.state(), equalTo(originalState));  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.fromId(Version.CURRENT.id + 10000))
        expectThrows(
        }
            null  
import org.opensearch.index.IndexService;
            .build();
import org.opensearch.action.admin.indices.stats.CommonStatsFlags.Flag;
        final ClusterState withoutIndex = new ClusterState.Builder(csWithIndex).metadata(
            return Collections.singletonList(BAR_INDEX_SETTING);
            indicesService.verifyIndexIsDeleted(index, csWithIndex);
            false,
                assertThat(indexService.getIndexerFactory(), instanceOf(EngineBackedIndexerFactory.class));
        DelegatingCacheHelper delegatingCacheHelper = mock(DelegatingCacheHelper.class);  
            // leave the search block null in the response — the populated contributor's numbers
            .build();
import org.opensearch.env.NodeEnvironment;
        assertNotNull(clusterService.state().getMetadata().index(alias));  
    }  
    }
        @Override
import org.opensearch.index.shard.IllegalIndexShardStateException;
            ShardPath.loadShardPath(logger, getNodeEnvironment(), indexShard.shardId(), indexSettings.customDataPath()),  
        DirectoryReader reader = mock(DirectoryReader.class);
        }
        final Metadata metadata = Metadata.builder(clusterService.state().metadata()).put(indexMetadata, true).build();
    protected Collection<Class<? extends Plugin>> getPlugins() {
import org.opensearch.cluster.service.ClusterService;  
            }
        // Simulate the cluster setting update by manually calling setCanCacheSizeNonzeroRequests  
        );  
            () -> indicesService.createIndex(indexMetadata, Collections.emptyList(), false)
        latch.await();
import java.io.IOException;  
     * trying to delete an index that exists.
        IndexMetadata firstMetadata = clusterService.state().metadata().index("test");
            if (BAR_INDEX_SETTING.get(indexSettings.getSettings())) {  
            if (FOO_INDEX_SETTING.get(indexSettings.getSettings())) {  
        assertThat(clusterService.state(), equalTo(originalState));
        }
        // the shard that is going to fail  
        assertTrue(secondPath.exists());
                assertThat(  
    }  
    }
            ShardLockObtainFailedException.class,  
    }
    }
        final LocalAllocateDangledIndices dangling = getInstanceFromNode(LocalAllocateDangledIndices.class);  
        // this allows us to control the indices that exist
     * custom types and similarities registered by plugins
        assertFalse("index files should be deleted", FileSystemUtils.exists(nodeEnv.indexPaths(index)));  
        Map<TestSearchContext, Boolean> expectedResultMap = Map.of(sizeZeroContext, true, sizeNonzeroContext, false);
import org.opensearch.common.settings.Setting;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import org.opensearch.index.search.stats.SearchStats;  
 * this file be licensed under the Apache-2.0 license or a
        final Index index = new Index(indexName, UUIDs.randomBase64UUID());  
            SearchStats merged = indicesService.stats(new CommonStatsFlags(Flag.Search)).getSearch();
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;  
        });
        // if all goes well, this won't throw an exception, otherwise, it will throw an IllegalStateException
        final ClusterState csWithIndex = new ClusterState.Builder(clusterService.state()).metadata(metadata).build();  
                shardStats.add(successfulShardStats);  
        expectThrows(IllegalStateException.class, () -> indicesService.deleteIndexStore("boom", firstMetadata));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            assertEquals(baselineQueryCount + 7, merged.getTotal().getQueryCount());
                assertEquals(indicesService.numPendingDeletes(index), 0);
 * compatible open source license.
            .collect(Collectors.toList());  
            TestSearchContext context = entry.getKey();
        public Optional<EngineFactory> getEngineFactory(final IndexSettings indexSettings) {
import org.opensearch.cluster.metadata.Metadata;
        final IndexSettings indexSettings = indexService.getIndexSettings();
        ContextIndexSearcher searcher = mock(ContextIndexSearcher.class);  
        public Map<String, Mapper.TypeParser> getMappers() {
        IndexReader.CacheHelper notDelegatingCacheHelper = mock(IndexReader.CacheHelper.class);
        final IllegalStateException e = expectThrows(
        DelegatingCacheHelper cacheHelper = mock(DelegatingCacheHelper.class);
        assertFalse(firstPath.exists());
        test.removeShard(0, "boom");
        return true;  
        createIndex(indexName);
            .numberOfReplicas(1)
import org.opensearch.index.engine.InternalEngine;  
            Metadata.builder(csWithIndex.metadata()).remove(index.getName())  
        final String indexName = "test";
        client().admin().indices().prepareAliases().addAlias(indexName, alias).get();
        final Settings idxSettingsLater = Settings.builder()
        metaStateService.writeIndex("test index being created", indexMetadata);
import org.apache.lucene.store.AlreadyClosedException;
import static org.hamcrest.Matchers.hasToString;
        final IndicesService indicesService = getIndicesService();
            shards.add(shard);
        final ClusterState originalState = clusterService.state();
        assertNotNull(meta.index("test"));
        assertAcked(client().admin().indices().prepareOpen("test"));  
import java.util.Arrays;
    public void testStatsMergesSearchStatsContributors() {
     * throw any errors that the index still exists in the cluster state.  This is a case of ensuring
    public void testDeleteIndexStore() throws Exception {  
            "index.bar_index",  
        }
import static org.hamcrest.Matchers.instanceOf;  
                when(mockIndicesService.indexShardStats(mockIndicesService, shard, CommonStatsFlags.ALL)).thenThrow(expectedException);
            setupMocksForCanCache(context, cacheHelper);  
        TestSearchContext sizeAboveThresholdContext = getTestContext(indexService, maxCacheableSize + 5);
        IndicesService indicesService = getIndicesService();  
            if (failedShardId != i) {  
        latch = new CountDownLatch(1);
                    ((EngineBackedIndexerFactory) indexService.getIndexerFactory()).getEngineFactory(),
            .numberOfShards(1)  
        @Override
                indicesService.addPendingDelete(indexShard.shardId(), indexSettings);
        final int failedShardId = randomIntBetween(0, shardCount - 1);  
import java.util.ArrayList;
 * GitHub history for details.
            if (randomBoolean()) {  
    public void testCanDeleteShardContent() {  
        );  
        assertFalse(indicesService.isMetadataField(randomAlphaOfLengthBetween(10, 15)));  
        assertThat(indexStats.isEmpty(), equalTo(false));
        for (String builtIn : IndicesModule.getBuiltInMetadataFields()) {
        final IndexMetadata indexMetadataLater = new IndexMetadata.Builder(indexNameLater).settings(idxSettingsLater)
import org.opensearch.index.engine.EngineConfig;
    }
        final Index index = indexService.index();  
    @Override  
    public void testVerifyIfIndexContentDeleted() throws Exception {
        @Override
    }
            ShardDeletionCheckResult.FOLDER_FOUND_CAN_DELETE
            () -> indicesService.processPendingDeletes(index, indexSettings, TimeValue.timeValueMillis(0))
        final IndexService indexService = createIndex("test");
/*
        final IndicesService indicesService = getIndicesService();
        indicesService.verifyIndexIsDeleted(index, withoutIndex);
        final String indexName = "foobar";  
        IndicesService indicesService = getIndicesService();
            final IndexService indexService = indicesService.createIndex(indexMetadata, Collections.emptyList(), false);  
import org.opensearch.index.engine.InternalEngineFactory;
import org.opensearch.test.IndexSettingsModule;
            getNodeEnvironment(),  
        ).build();
import org.opensearch.gateway.LocalAllocateDangledIndices;
        public List<Setting<?>> getSettings() {  
        ClusterService clusterService = getInstanceFromNode(ClusterService.class);  
import static org.mockito.Mockito.mock;
        ShardSearchRequest request = mock(ShardSearchRequest.class);
        for (Map.Entry<TestSearchContext, Boolean> entry : expectedResultMap.entrySet()) {
        assertEquals(
            new IllegalIndexShardStateException(shardId, state, message),
                return SearchType.QUERY_THEN_FETCH;  
        final ShardId shardId = new ShardId(index, failedShardId);
    }
        }  
            setupMocksForCanCache(context, cacheHelper);  
import org.opensearch.index.IndexSettings;
        final IndexService indexService = createIndex("test");
                .numberOfShards(1)  
            assertEquals(entry.getValue(), indicesService.canCache(request, context));
import java.util.concurrent.CountDownLatch;
            final Index index = new Index(indexName, UUIDs.randomBase64UUID());  
        final String indexName = "test";
}  
            indicesService.addPendingDelete(new ShardId(index, 0), indexSettings);  
        final ShardPath shardPath = indexShard.shardPath();
        assertTrue(shardPath.exists());  
        latch.await();
        // shard stats, which are zero on this single-node test fixture with no queries fired.
                    instanceOf(FooEnginePlugin.FooEngineFactory.class)
public class IndicesServiceTests extends OpenSearchSingleNodeTestCase {
            assertThat(indicesService.hasUncompletedPendingDeletes(), equalTo(hasBogus)); // "bogus" index has not been removed
        assertEquals(
            IllegalStateException.class,  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        // try to import a dangling index with the same name as the alias, it should fail
                .build();
        if (randomBoolean()) {  
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
    public void testDanglingIndicesWithAliasConflict() throws Exception {  
            .build();
    }
            @Override  
     * See https://github.com/elastic/elasticsearch/issues/18054
        assertThat("unexpected shard stats", indexStats.get(index), equalTo(shardStats));
            .build();  
    public static class FooEnginePlugin extends Plugin implements EnginePlugin {  
        client().prepareIndex("test").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
    public void testDanglingIndicesWithLaterVersion() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
            final String indexName = "foo-" + value;
        final IndicesService indicesService = getIndicesService();  
        final Index index = new Index(indexName, UUIDs.randomBase64UUID());  
    /**  
        expectThrows(
        long baselineQueryTime = baseline.getTotal().getQueryTimeInMillis();  
            false,
                return new InternalEngine(config);  
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())  
            IndexReader.CacheHelper cacheHelper = useDelegatingCacheHelper ? delegatingCacheHelper : notDelegatingCacheHelper;
            // Non-Search flags must not invoke the contributors. Asking for Indexing only should
            ShardDeletionCheckResult.STILL_ALLOCATED
        return Stream.concat(super.getPlugins().stream(), Stream.of(TestPlugin.class, FooEnginePlugin.class, BarEnginePlugin.class))
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)
        assertNotNull(indexShard);
        // Requests should only be cached if their size is <= INDICES_REQUEST_CACHE_MAX_SIZE_TO_CACHE_SETTING.  
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(settings)
     * that tombstones that have the same name as current valid indices don't cause confusion by  
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(alias).settings(idxSettings)
        assertAcked(client().admin().indices().prepareDelete("test"));
import org.opensearch.action.search.SearchType;  
        assertAcked(client().admin().indices().prepareDelete("test"));
    protected boolean resetNodeAfterTest() {
        static class BarEngineFactory implements EngineFactory {
            return Collections.singletonList(FOO_INDEX_SETTING);
            IndexSettings.DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL,
    public void testDirectoryReaderWithoutDelegatingCacheHelperNotCacheable() throws IOException {
            setupMocksForCanCache(context, cacheHelper);  
        );  
        for (Map.Entry<TestSearchContext, Boolean> entry : expectedResultMap.entrySet()) {
        // real one, which has a logger defined  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        assertThat("index not defined", indexStats.containsKey(index), equalTo(true));  
        // create the alias for the index  
    public void testPendingTasks() throws Exception {
 * under the License.  
import org.opensearch.index.engine.Engine;  
            assertFalse(shardPath.exists());  
            .build();
            } else {
        };
        // Baseline: no contributors registered. The Search block reflects only the node's own
        IndexMetadata meta = IndexMetadata.builder("test")
        final IndexService indexService = createIndex("test");  
 *
            .build();
            fail("Should not be able to delete index contents when the index is part of the cluster state.");  
        return getInstanceFromNode(NodeEnvironment.class);  
            return Collections.singletonMap("fake-mapper", KeywordFieldMapper.PARSER);  
            if (value != null) {
            "shard is allocated",  
        assertThat(clusterService.state(), not(originalState));
        int numPending = 1;
        final String indexName = "test-idx1";
     * tombstones for deletions, and it should proceed with trying to delete A with UUID 1 and not
            }
        } catch (IllegalStateException e) {
        when(reader.getReaderCacheHelper()).thenReturn(cacheHelper);
        static class FooEngineFactory implements EngineFactory {
    public static class TestPlugin extends Plugin implements MapperPlugin {  
import org.opensearch.index.mapper.MapperService;
        ShardSearchRequest request = mock(ShardSearchRequest.class);
        final RuntimeException expectedException = randomFrom(  
        Metadata meta = gwMetaState.getMetadata();
    public void testCanCacheSizeNonzero() {
import org.opensearch.index.mapper.KeywordFieldMapper;  
        // generate fake shards and their responses  
            indicesService.getRemoteStoreSettings().getClusterRemoteTranslogBufferInterval()  
            public Engine newReadWriteEngine(final EngineConfig config) {
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", meta.getSettings());
        final List<IndexShard> shards = new ArrayList<>(shardCount);  
        IndexService test = createIndex("test");
import org.opensearch.test.hamcrest.RegexMatcher;
        // now try importing a dangling index with the same name as the alias, it should succeed.
import static org.mockito.Mockito.when;  

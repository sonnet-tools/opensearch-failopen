            (providerSettings, indexCreatedVersion, scriptService) -> new TestSimilarity(providerSettings.get("key"))
        assertEquals("there is a key", ((TestSimilarity) similarity).key);
        final MockEngineFactory engineFactory = new MockEngineFactory(AssertingDirectoryReader.class);
            emptyMap(),
import org.opensearch.core.index.shard.ShardId;
/*
 * this work for additional information regarding copyright
            Collections.emptyMap(),
            null,
                };
        IndexService indexService = newIndexService(module);
            new EngineConfigFactory(indexSettings),
        public long computeNorm(FieldInvertState state) {
        TransportService transportService = new TransportService(
        module.addSimilarity(
        @Override
    private ScriptService scriptService;
            RecoverySource.ExistingStoreRecoverySource.INSTANCE,
            emptyMap(),
        final IndexModule module = new IndexModule(
import static java.util.Collections.singletonMap;
            emptyAnalysisRegistry,
import org.opensearch.common.util.concurrent.ThreadContext;
        assertEquals(2, indexService.getSearchOperationListener().size());
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            Collections.emptySet(),
        public void deleteShardStore(String reason, ShardLock lock, IndexSettings indexSettings) throws IOException {}
        assertEquals(IndexingSlowLog.class, indexService.getIndexOperationListeners().get(0).getClass());
    }
import org.opensearch.index.engine.InternalEngineTests;
        shard = shard.initialize("node1", null, -1);
    private static class TestSimilarity extends Similarity {
import org.opensearch.common.util.BigArrays;
import org.opensearch.index.engine.InternalEngineFactory;
            Collections.emptyMap(),
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
        expectThrows(IllegalArgumentException.class, () -> module.addIndexOperationListener(listener));
                final Analyzer analyzer = new Analyzer() {
    public static final class FooFunction implements IndexStorePlugin.DirectoryFactory {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.store.LockFactory;
                    indexSettings.getRemoteStoreTranslogRepository(),
            return null;
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
                        super.close();
import org.opensearch.transport.Transport;
        assertEquals("Similarity [my_similarity] must have an associated type", ex.getMessage());
            null,
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
            () -> module.forceQueryCacheProvider((a, b) -> { throw new AssertionError("never called"); })
        );
import org.opensearch.repositories.RepositoriesService;
    public void testWrapperIsBound() throws IOException {
            threadPool,
import org.opensearch.test.OpenSearchTestCase;
import java.util.Set;
        CustomQueryCache(Set<CustomQueryCache> liveQueryCaches) {
            .build();
            null,
        expectThrows(IllegalArgumentException.class, () -> module.addSearchOperationListener(null));
            emptyMap(),
            Collections.emptyMap(),
        final IndexModule module = new IndexModule(
import org.opensearch.core.index.Index;
        expectThrows(OpenSearchRejectedExecutionException.class, () -> newIndexService(module));
import org.apache.lucene.search.Weight;
        }
        PageCacheRecycler pageCacheRecycler = new PageCacheRecycler(settings);
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
            @Override
            mapperRegistry,
            null,
        final Settings settings = Settings.builder()
    }
            () -> true,
            emptyMap(),
            }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        repositoriesService = new RepositoriesService(
            Collections.emptyMap()
        indexService.close("simon says", false);
        IndexService indexService = newIndexService(module);
    public void testFrozen() {
            Store.OnClose onClose,
import org.apache.lucene.search.similarities.BM25Similarity;
        mapperRegistry = new IndicesModule(Collections.emptyList()).getMapperRegistry();
        assertThat(liveQueryCaches, empty());
        Settings settings = Settings.builder()
    public void testLegacyConstructors() throws IOException {
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            Collections.emptyMap(),
        SearchOperationListener listener = new SearchOperationListener() {
        assertEquals(msg, expectThrows(IllegalStateException.class, () -> module.addSearchOperationListener(null)).getMessage());
            .build();
            (DataFormatRegistry) null
            CREATE_INDEX,
                throw new AssertionError("key is null");
        indexService.close("simon says", false);
        assertTrue(atomicBoolean.get());
        bigArrays = new BigArrays(pageCacheRecycler, circuitBreakerService, CircuitBreaker.REQUEST);
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
            ShardPath shardPath,
        final Map<String, IndexStorePlugin.StoreFactory> storeFactories = singletonMap("test_store", testStoreFactory);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            new EngineConfigFactory(indexSettings),
        }
        public Weight doCache(Weight weight, QueryCachingPolicy policy) {
            bigArrays,
                    threadPool,
            .put(IndexModule.INDEX_STORE_FACTORY_SETTING.getKey(), "test_store")
        IndexService indexService = newIndexService(module);
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.search.TermStatistics;
        String storeType = randomFrom(IndexModule.Type.HYBRIDFS.getSettingsKey(), IndexModule.Type.MMAPFS.getSettingsKey());
import org.opensearch.index.shard.ShardPath;
            emptyMap(),
            public void beforeIndexRemoved(IndexService indexService, IndexRemovalReason reason) {
 */
 * Modifications Copyright OpenSearch Contributors. See
            bigArrays,
 * ownership. Elasticsearch licenses this file to you under
            Collections.emptyMap(),
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            clusterService,
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    }
            }
/*
            Collections.emptyMap()
            emptyMap(),
        @Override
    public static final class TestStoreFactory implements IndexStorePlugin.StoreFactory {
        final TestStoreFactory testStoreFactory = new TestStoreFactory();
            indexSettings,
            @Override
            return weight;
        }
        final Settings settings = Settings.builder()
        assertEquals(msg, expectThrows(IllegalStateException.class, () -> module.setReaderWrapper(null)).getMessage());
            Collections.emptyMap(),
        SimilarityService similarityService = indexService.similarityService();
            emptyMap(),
            fail("not registered");
            public AnalyzerScope scope() {
        );
        assertThat(openAnalyzers, empty());
            clusterService,
        assertSame(booleanSetting, indexService.getIndexSettings().getScopedSettings().get(booleanSetting.getKey()));
 * specific language governing permissions and limitations
    private BigArrays bigArrays;
    public void testDisableQueryCacheHasPrecedenceOverForceQueryCache() throws IOException {
        assertEquals(SearchSlowLog.class, indexService.getSearchOperationListener().get(0).getClass());
        // Test that IndexService uses default store when setting is empty
import org.opensearch.index.cache.query.IndexQueryCache;
        IndexModule module = createIndexModule(indexSettings, analysisRegistry);
        IndexService indexService = newIndexService(module);
        assertEquals("my_similarity", similarityService.getSimilarity("my_similarity").name());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    };
        nodeEnvironment = new NodeEnvironment(settings, environment);
        expectThrows(IllegalArgumentException.class, () -> module.addSearchOperationListener(listener));
    private Index index;
            Directory directory,
        );
import org.opensearch.index.remote.RemoteStoreUtils;
import java.util.HashSet;
        module.newIndexService(
    }
    }
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
import org.opensearch.index.mapper.Uid;
public class IndexModuleTests extends OpenSearchTestCase {
    }
            new EngineConfigFactory(indexSettings),
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
            () -> true,
        Engine.Index index = new Engine.Index(new Term("_id", Uid.encodeId(doc.id())), randomNonNegativeLong(), doc);
        threadPool.shutdown(); // causes index service creation to fail
        public Directory newDirectory(IndexSettings indexSettings, ShardPath shardPath) throws IOException {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            this.liveQueryCaches = liveQueryCaches;
                    public void close() {
            IndexSettings indexSettings,
    public void tearDown() throws Exception {
    }
            () -> Boolean.FALSE,
        );
        final Set<CustomQueryCache> liveQueryCaches = new HashSet<>();
        public Store newStore(
            ShardPath shardPath
        assertTrue(indexService.cache().query() instanceof IndexQueryCache);
        final Settings nodeSettings = Settings.builder().put(IndexModule.NODE_STORE_ALLOW_MMAP.getKey(), false).build();
import org.opensearch.common.settings.Setting.Property;
        IndexingOperationListener listener = new IndexingOperationListener() {
        emptyAnalysisRegistry = new AnalysisRegistry(
            emptyAnalysisRegistry,
        assertEquals(msg, expectThrows(IllegalStateException.class, () -> module.forceQueryCacheProvider(null)).getMessage());
        assertTrue(indexService.cache().query() instanceof DisabledQueryCache);
        );
        assertThat(indexService.getDirectoryFactory(), instanceOf(IndexStorePlugin.DirectoryFactory.class));
            clusterService,
    public void testForceCustomQueryCache() throws IOException {
import org.opensearch.index.fielddata.IndexFieldDataCache;
            indicesQueryCache,
        public Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put("index.similarity.my_similarity.type", "test_similarity")
            l.onNewReaderContext(mock(ReaderContext.class));
            () -> true,
import org.opensearch.common.settings.SettingsException;
            new RemoteSegmentStoreDirectoryFactory(() -> repositoriesService, threadPool, ""),
        @Override
        module.addSettingsUpdateConsumer(booleanSetting, atomicBoolean::set);
 * KIND, either express or implied.  See the License for the
            @Override
            storeFactories,
            final CustomQueryCache customQueryCache = new CustomQueryCache(liveQueryCaches);
            public Engine.Index preIndex(ShardId shardId, Engine.Index operation) {
    }
        Settings settings = Settings.builder()
        @Override
        similarity = ((NonNegativeScoresSimilarity) similarity).getDelegate();
import org.opensearch.common.util.io.IOUtils;
        });
        }
            emptyMap(),
                    @Override
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
            scriptService,
import org.opensearch.plugins.IndexStorePlugin;
            new IndicesFieldDataCache(settings, listener, clusterService, threadPool),
    }
            translogFactorySupplier,
        IOUtils.close(nodeEnvironment, indicesQueryCache, clusterService);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(msg, expectThrows(IllegalStateException.class, () -> module.addIndexEventListener(null)).getMessage());
            emptyAnalysisRegistry,
    }
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            .build();
            public void onNewReaderContext(ReaderContext readerContext) {
            return delegate.scorer(boost, collectionStats, termStats);
 * GitHub history for details.
            final CustomQueryCache customQueryCache = new CustomQueryCache(liveQueryCaches);
        repositoriesServiceReference.set(repositoriesService);
            ShardId shardId,
            Collections.emptyMap(),
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
    public void testOtherServiceBound() throws IOException {
                return AnalyzerScope.INDEX;
        final HashSet<Analyzer> openAnalyzers = new HashSet<>();
        );
        indexService.close("simon says", false);
        // Test that IndexService can be created successfully with valid store factory
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
            new InternalEngineFactory(),
    public void testDefaultQueryCacheImplIsSelected() throws IOException {
            DefaultRecoverySettings.INSTANCE,
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
    }
            circuitBreakerService,
        ) throws IOException {
            new EngineConfigFactory(indexSettings),
import org.opensearch.index.translog.InternalTranslogFactory;
        indexService.close("closing", false);
            () -> false,
    }
        }
            DefaultRemoteStoreSettings.INSTANCE,
            .build();
        );
                        openAnalyzers.remove(this);
        module.addIndexOperationListener(listener);
        assertThat(similarity, Matchers.instanceOf(NonNegativeScoresSimilarity.class));
            .build();
            xContentRegistry(),
 * the Apache License, Version 2.0 (the "License"); you may
        IndexService indexService = newIndexService(module);
            liveQueryCaches.add(customQueryCache);
            return customQueryCache;
    public void testAddIndexOperationListener() throws IOException {
        );
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
import static org.mockito.Mockito.mock;
    }
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), "foo_store")
        when(mockClusterMergeSchedulerConfig.getClusterMaxMergeCount()).thenReturn(9);
import org.opensearch.index.shard.SearchOperationListener;
        IndexService indexService = newIndexService(module);
        module.forceQueryCacheProvider((a, b) -> new CustomQueryCache(null));
    }
            emptyAnalysisRegistry,
import org.opensearch.threadpool.TestThreadPool;
import static org.hamcrest.Matchers.containsString;
    }
import org.opensearch.index.analysis.AnalysisRegistry;
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
import static org.hamcrest.Matchers.is;
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
        final Map<String, IndexStorePlugin.StoreFactory> storeFactories = singletonMap("test_store", testStoreFactory);
            }
        AtomicBoolean executed = new AtomicBoolean(false);
        );
            liveQueryCaches.add(customQueryCache);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            .build();
            emptyMap(),
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            @Override
        }
        assertSame(indexService.getIndexerFactory(), module.getIndexerFactory());
        @Override
import org.opensearch.cluster.service.ClusterService;
    private RepositoriesService repositoriesService;
            () -> IndexSettings.DEFAULT_REFRESH_INTERVAL,
                    new RemoteTranslogTransferTracker(shardRouting.shardId(), 10),
    public void testIndexAnalyzersCleanedUpIfIndexServiceCreationFails() {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
            threadPool
        module.addIndexEventListener(eventListener);
        when(mockClusterMergeSchedulerConfig.getClusterMaxThreadCount()).thenReturn(4);
    private IndexSettings indexSettings;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        assertEquals(x.getIndex(), index);
        );
            "test_similarity",
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
            new EngineConfigFactory(indexSettings),
        final IndexService indexService = newIndexService(module);
            () -> true,
                return "test";
            Collections.emptyMap()
        super.tearDown();
    }
        indexService.close("closing", false);
        Exception ex = expectThrows(IllegalArgumentException.class, () -> newIndexService(module));
        public void clear(String reason) {}
    }
    }
    private ThreadPool threadPool;
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
    private CircuitBreakerService circuitBreakerService;
import org.opensearch.indices.recovery.DefaultRecoverySettings;
            Collections.emptyMap()
            () -> TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier = (indexSettings, shardRouting) -> {
        Exception ex = expectThrows(IllegalArgumentException.class, () -> newIndexService(module));
    public void testUnknownStoreFactory() {
            indexSettings,
    public void setUp() throws Exception {
        assertTrue(executed.get());
    }
        @Override
import static org.hamcrest.Matchers.empty;
            indexSettings,
            NoopTracer.INSTANCE
            transportService,
            null,
import org.opensearch.index.analysis.AnalyzerProvider;
            indexSettings,
 * You may obtain a copy of the License at
    private MapperRegistry mapperRegistry;
        module.freeze();
import org.opensearch.env.ShardLock;
            settings,
        final Set<CustomQueryCache> liveQueryCaches = new HashSet<>();
 * software distributed under the License is distributed on an
import org.opensearch.test.engine.MockEngineFactory;
        final Map<String, IndexStorePlugin.DirectoryFactory> indexStoreFactories = singletonMap("foo_store", new FooFunction());
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
            null,
        indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals("Unknown Similarity type [test_similarity] for [my_similarity]", ex.getMessage());
                    @Override
        assertTrue(executed.get());
        return new IndexModule(
        settings = Settings.builder()
        };
        @Override
            .put("index.similarity.my_similarity.type", "test_similarity")
import org.opensearch.common.settings.Setting;
 *
            .build();
        AtomicBoolean executed = new AtomicBoolean(false);
import org.apache.lucene.store.Directory;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        final IndexService indexService = newIndexService(module);
        for (SearchOperationListener l : indexService.getSearchOperationListener()) {
import org.opensearch.env.TestEnvironment;
 * license agreements. See the NOTICE file distributed with
            Collections.emptyMap(),
            null,
 *
            ShardLock shardLock,
package org.opensearch.index;
        indexService.close("simon says", false);
        assertEquals(2, indexService.getIndexOperationListeners().size());
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
        circuitBreakerService = new NoneCircuitBreakerService();
        Settings settings = Settings.builder()
            singletonMap("test", analysisProvider),
            threadPool,
                    }
import static org.mockito.Mockito.when;
import org.opensearch.index.mapper.ParsedDocument;
    }
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> newIndexService(module));
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
import org.opensearch.env.NodeEnvironment;
                    }
        module.setReaderWrapper(s -> new Wrapper());
        );
            .put(IndexModule.INDEX_STORE_FACTORY_SETTING.getKey(), "")
    @Override
            () -> false,
            () -> true,
                return analyzer;
        IndexService indexService = newIndexService(module);
            null,
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            emptyAnalysisRegistry,
                        return new TokenStreamComponents(new StandardTokenizer());
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
import java.util.concurrent.atomic.AtomicBoolean;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        public void close() {
        }
        private final Set<CustomQueryCache> liveQueryCaches;
                return operation;
        scriptService = new ScriptService(settings, Collections.emptyMap(), Collections.emptyMap());
            .put(IndexModule.INDEX_STORE_FACTORY_SETTING.getKey(), "unknown_store")
        };
        public SimScorer scorer(float boost, CollectionStatistics collectionStats, TermStatistics... termStats) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            indexSettings,
            Collections.emptyMap()
            null,
        @Override
            deleter,
            Directory directory,
import org.opensearch.indices.mapper.MapperRegistry;
/*
            () -> true,
            engineFactory,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            threadPool,
        index = indexSettings.getIndex();
            Collections.emptyMap(),
        expectThrows(IllegalArgumentException.class, () -> module.addIndexOperationListener(null));
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.SetOnce;
            Collections.emptyMap(),
            public Analyzer get() {
import static org.hamcrest.Matchers.instanceOf;
            Store.OnClose onClose,
import org.opensearch.common.CheckedFunction;
            emptyAnalysisRegistry,
import org.opensearch.index.translog.TranslogFactory;
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        @Override
        Similarity similarity = similarityService.getSimilarity("my_similarity").get();
import org.opensearch.cluster.routing.ShardRouting;
            () -> Boolean.FALSE,
            .build();
            emptyMap(),
            ShardId shardId,
    }
            emptyMap(),
import org.opensearch.index.translog.RemoteBlobStoreInternalTranslogFactory;
import org.apache.lucene.search.CollectionStatistics;
import static java.util.Collections.emptyMap;
        assertEquals(x.getSettings(), indexSettings.getSettings());
            true,
        private final Similarity delegate = new BM25Similarity();
        );
import org.opensearch.index.store.FsDirectoryFactory;
        assertSame(listener, indexService.getIndexOperationListeners().get(1));
        ShardRouting shard = ShardRouting.newUnassigned(
import org.apache.lucene.index.Term;
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
        });
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
        indexService.close("simon says", false);
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                    DefaultRemoteStoreSettings.INSTANCE,
        assertEquals(msg, expectThrows(IllegalStateException.class, () -> module.addIndexOperationListener(null)).getMessage());
            Collections.emptyMap(),
import org.opensearch.threadpool.ThreadPool;
        Settings settings = Settings.builder()
            ShardLock shardLock,
import org.opensearch.test.ClusterServiceUtils;
    public void testSetupUnknownSimilarity() {
            environment,
import org.opensearch.indices.analysis.AnalysisModule;
        String msg = "Can't modify IndexModule once the index service has been created";
            emptyMap()
            CREATE_INDEX,
            .build();
        );
            recoveryStateFactories
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
import org.apache.lucene.index.DirectoryReader;
        };
            () -> true,
 * compatible open source license.
            Collections.emptyMap(),
            new EngineConfigFactory(indexSettings),
import org.opensearch.env.Environment;
            nodeEnvironment,
        indicesQueryCache = new IndicesQueryCache(settings);
        @Override
import org.opensearch.index.shard.IndexEventListener;
                );
import org.opensearch.common.settings.Settings;
}
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
        assertTrue(indexService.cache().query() instanceof CustomQueryCache);
                return new RemoteBlobStoreInternalTranslogFactory(
import org.apache.lucene.tests.index.AssertingDirectoryReader;
            boundAddress -> DiscoveryNode.createLocal(settings, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
        }
    }
import java.nio.file.Path;
import org.hamcrest.Matchers;
            Collections.emptyMap(),
        indexService.close("simon says", false);
import org.opensearch.index.engine.EngineConfigFactory;
        final SetOnce<RepositoriesService> repositoriesServiceReference = new SetOnce<>();
        };
            public String name() {
import java.util.function.BiFunction;
            Collections.emptyMap()
        assertNotNull(indexService);
        indexService.close("simon says", false);
        }
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        @Override
            () -> Boolean.FALSE,
import org.opensearch.indices.IndicesQueryCache;
            .put("index.store.type", storeType)
                openAnalyzers.add(analyzer);
import org.apache.lucene.search.QueryCachingPolicy;
import org.opensearch.indices.ClusterMergeSchedulerConfig;
            () -> true,
    }
    public void testListener() throws IOException {
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier = (a, b) -> new InternalTranslogFactory();
        final AnalysisRegistry analysisRegistry = new AnalysisRegistry(
            }
            (shardRouting, targetNode, sourceNode) -> recoveryState
import org.opensearch.test.IndexSettingsModule;
        }
        public DirectoryReader apply(DirectoryReader reader) {
import org.opensearch.index.similarity.NonNegativeScoresSimilarity;
            AlreadySetException.class,
            return null;
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
            mock(Transport.class),
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        final Settings settings = Settings.builder()
        for (IndexingOperationListener l : indexService.getIndexOperationListeners()) {
        ParsedDocument doc = InternalEngineTests.createParsedDoc("1", null);
            engineFactory,
        ShardId shardId = new ShardId(new Index("foo", "bar"), 0);
        super.setUp();
        module.forceQueryCacheProvider((a, b) -> {
import org.opensearch.indices.DefaultRemoteStoreSettings;
import java.io.IOException;
        private final String key;
            .build();
            emptyAnalysisRegistry,
            translogFactorySupplier,
    private ClusterService clusterService;
            @Override
        assertSame(listener, indexService.getSearchOperationListener().get(1));
        IndexModule module = new IndexModule(
        return module.newIndexService(
        expectThrows(OpenSearchRejectedExecutionException.class, () -> newIndexService(module));
    public void testStoreFactoryWithEmptySetting() throws IOException {
import org.opensearch.index.engine.Engine;
            .put("index.similarity.my_similarity.key", "there is a key")
    }
import org.opensearch.core.common.breaker.CircuitBreaker;
    public void testAddSimilarity() throws IOException {
import java.util.Collections;
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings, booleanSetting);
        );
import org.apache.lucene.index.FieldInvertState;
import org.apache.lucene.analysis.standard.StandardTokenizer;
            .build();
            () -> Boolean.FALSE,
            .put("index.similarity.my_similarity.foo", "bar")
            return new Index("test", "_na_");
import org.opensearch.common.UUIDs;
            indicesQueryCache,
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
        final MockEngineFactory engineFactory = new MockEngineFactory(AssertingDirectoryReader.class);
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
    public void testAddSearchOperationListener() throws IOException {
        IndexService indexService = newIndexService(module);
    private NodeEnvironment nodeEnvironment;
        assertThat(indexService.createRecoveryState(shard, mock(DiscoveryNode.class), mock(DiscoveryNode.class)), is(recoveryState));
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
import org.opensearch.common.util.PageCacheRecycler;
        Settings settings = Settings.builder()
        );
                executed.set(true);
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
        final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories = singletonMap(
            return new Store(shardId, indexSettings, directory, shardLock, onClose, shardPath);
    }
        final IndexModule module = new IndexModule(
            }
        final IndexModule module = new IndexModule(
    public void testStoreFactory() throws IOException {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            emptyAnalysisRegistry,
            .build();
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            "test_recovery",
import org.opensearch.indices.recovery.RecoveryState;
            return new Store(shardId, indexSettings, directory, shardLock, onClose, shardPath, directoryFactory);
            emptyMap(),
 * SPDX-License-Identifier: Apache-2.0
            Collections.emptyMap()
        ) throws IOException {
            this.key = key;
        }
import org.opensearch.index.store.Store;
import java.util.concurrent.TimeUnit;
    }
        );
import static org.hamcrest.Matchers.hasToString;
    }
        assertNotNull(similarity);
            Collections.emptyMap(),
        mockClusterMergeSchedulerConfig = mock(ClusterMergeSchedulerConfig.class);
            Collections.emptyMap(),
import org.opensearch.script.ScriptService;
        };
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            return delegate.computeNorm(state);
 * Licensed to Elasticsearch under one or more contributor
            if (indexSettings.isRemoteTranslogStoreEnabled() && shardRouting.primary()) {
        IndexSettings x = indexService.getIndexSettings();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> newIndexService(module));
        IndexService indexService = newIndexService(module);
        module.forceQueryCacheProvider((a, b) -> {
    private Settings settings;
            new ShardId("test", "_na_", 0),
        assertNotNull(indexService);
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
        TestSimilarity(String key) {
            indexSettings,
            mockClusterMergeSchedulerConfig,
 */
    class CustomQueryCache implements QueryCache {
        @Override
import org.apache.lucene.analysis.Analyzer;
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
    public void testCustomQueryCacheCleanedUpIfIndexServiceCreationFails() {
    };
import org.opensearch.indices.IndicesModule;
            s -> {},
    private IndicesQueryCache indicesQueryCache;
 *
    }
import org.opensearch.index.cache.query.DisabledQueryCache;
        expectThrows(
            () -> IndexSettings.DEFAULT_REFRESH_INTERVAL,
    public static final class Wrapper implements CheckedFunction<DirectoryReader, DirectoryReader, IOException> {
        indexService.close("simon says", false);
    public void testSetupWithoutType() {
            null,
        final IndexService indexService = newIndexService(module);
        final TestStoreFactory testStoreFactory = new TestStoreFactory();
        assertThat(exception.getMessage(), containsString("Unknown store factory [unknown_store]"));
    @SuppressWarnings("removal")
        Setting<Boolean> booleanSetting2 = Setting.boolSetting("index.foo.bar.baz", false, Property.Dynamic, Property.IndexScope);
    }
            xContentRegistry(),
            new RemoteSegmentStoreDirectoryFactory(() -> repositoriesService, threadPool, ""),
    public void testMmapNotAllowed() {
            @Override
    private final IndexFieldDataCache.Listener listener = new IndexFieldDataCache.Listener() {
        Settings settings = Settings.builder()
            writableRegistry(),
        final Settings settings = Settings.builder()
 * under the License.
        Settings settings = Settings.builder()
import org.opensearch.index.cache.query.QueryCache;
            Collections.emptyMap(),
import org.opensearch.cluster.node.DiscoveryNode;
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
            .build();
                    protected TokenStreamComponents createComponents(String fieldName) {
        @Override
            null,
        Settings settings = Settings.builder()
    }
            new EngineConfigFactory(indexSettings),
    private ShardRouting createInitializedShardRouting() {
        module.addSearchOperationListener(listener);
    private Environment environment;
        public Store newStore(
import org.opensearch.search.internal.ReaderContext;
        );
        assertTrue(indexService.getReaderWrapper() instanceof Wrapper);
        final Settings settings = Settings.builder()
        indexService.close("simon says", false);
        public void addPendingDelete(ShardId shardId, IndexSettings indexSettings) {}
    public void testRegisterIndexStore() throws IOException {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        RecoveryState recoveryState = mock(RecoveryState.class);
        final IndexEventListener eventListener = new IndexEventListener() {
        environment = TestEnvironment.newEnvironment(settings);
            null,
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
    private static IndexModule createIndexModule(IndexSettings indexSettings, AnalysisRegistry emptyAnalysisRegistry) {
            environment,
 * not use this file except in compliance with the License.
import org.opensearch.cluster.routing.UnassignedInfo;
        Setting<Boolean> booleanSetting = Setting.boolSetting("index.foo.bar", false, Property.Dynamic, Property.IndexScope);
            .build();
            DefaultRemoteStoreSettings.INSTANCE,
import org.opensearch.Version;
        final IndexModule module = new IndexModule(
            indexStoreFactories,
    private AnalysisRegistry emptyAnalysisRegistry;
        threadPool.shutdown(); // causes index service creation to fail
            nodeEnvironment,
            .build();
import org.opensearch.cluster.routing.RecoverySource;
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
            indexSettings,
        public Index index() {
        final IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
        } catch (SettingsException ex) {
    public void testRegisterCustomRecoveryStateFactory() throws IOException {
            circuitBreakerService,
 */
            indexSettings,
            scriptService,
            storeFactories,
            settings,
            mapperRegistry,
import org.opensearch.cluster.metadata.IndexMetadata;
                    RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexSettings.getIndexMetadata())
        return shard;
            emptyMap()
            emptyMap(),
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
        final AnalysisModule.AnalysisProvider<AnalyzerProvider<?>> analysisProvider = (i, e, n, s) -> new AnalyzerProvider<Analyzer>() {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            new IndicesFieldDataCache(settings, listener, clusterService, threadPool),
        );
        IndexModule module = new IndexModule(
            assertTrue(liveQueryCaches == null || liveQueryCaches.remove(this));
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
            writableRegistry(),
import java.util.Map;
            IndexSettings indexSettings,
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(new Index("foo", "_na_"), settings, nodeSettings);
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
    private IndexService newIndexService(IndexModule module) throws IOException {
        assertEquals(msg, expectThrows(IllegalStateException.class, () -> module.addSimilarity(null, null)).getMessage());
        }
            return new FsDirectoryFactory().newDirectory(indexSettings, shardPath);
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            }
            new InternalEngineFactory(),
            null,
            module.addSettingsUpdateConsumer(booleanSetting2, atomicBoolean::set);
            () -> TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE,
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            new InternalEngineFactory(),
            IndexStorePlugin.DirectoryFactory directoryFactory
import org.opensearch.transport.TransportService;
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        assertThat(e, hasToString(containsString("store type [" + storeType + "] is not allowed")));
            new EngineConfigFactory(indexSettings),
import org.opensearch.index.shard.IndexingOperationListener;
                atomicBoolean.set(true);
import org.opensearch.index.similarity.SimilarityService;
    private IndexService.ShardStoreDeleter deleter = new IndexService.ShardStoreDeleter() {
        }
                executed.set(true);
        assertThat(similarity, Matchers.instanceOf(TestSimilarity.class));
import static org.opensearch.index.IndexService.IndexCreationContext.CREATE_INDEX;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            return new InternalTranslogFactory();
    }
            if (key == null) {
import org.opensearch.common.SetOnce.AlreadySetException;
        assertThat(liveQueryCaches, empty());
        indexService.close("closing", false);
        ShardRouting shard = createInitializedShardRouting();
            DefaultRecoverySettings.INSTANCE,
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
            }
        try {
import org.apache.lucene.search.similarities.Similarity;
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason;
            deleter,
            return customQueryCache;
        final Settings settings = Settings.builder()
        }
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
        threadPool = new TestThreadPool("test");
        indexService.getIndexEventListener().beforeIndexRemoved(null, null);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.index.analysis.AnalyzerScope;
        final IndexService indexService = newIndexService(module);
            emptyMap(),
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                    repositoriesServiceReference::get,
    private ClusterMergeSchedulerConfig mockClusterMergeSchedulerConfig;
            emptyMap(),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
    @Override
            .put(IndexModule.INDEX_RECOVERY_TYPE_SETTING.getKey(), "test_recovery")
            l.preIndex(shardId, index);
        }
            }
        indexService.close("simon says", false);

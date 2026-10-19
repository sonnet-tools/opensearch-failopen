        CustomQueryCache(Set<CustomQueryCache> liveQueryCaches) {
    class CustomQueryCache implements QueryCache {  
            null,
            CREATE_INDEX,  
                atomicBoolean.set(true);
import org.opensearch.index.engine.EngineConfigFactory;  
            () -> TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE,  
                throw new AssertionError("key is null");  
            new EngineConfigFactory(indexSettings),
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            l.onNewReaderContext(mock(ReaderContext.class));
            emptyMap(),
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
            settings,  
            null,
        assertThat(e, hasToString(containsString("store type [" + storeType + "] is not allowed")));
import org.opensearch.index.shard.IndexingOperationListener;
            public String name() {
            assertTrue(liveQueryCaches == null || liveQueryCaches.remove(this));
            (shardRouting, targetNode, sourceNode) -> recoveryState
            Store.OnClose onClose,
 * software distributed under the License is distributed on an
        final Set<CustomQueryCache> liveQueryCaches = new HashSet<>();  
import org.opensearch.transport.Transport;
            return weight;
        final Settings settings = Settings.builder()  
        IndexService indexService = newIndexService(module);  
import org.opensearch.index.engine.InternalEngineTests;
import org.opensearch.transport.TransportService;
        when(mockClusterMergeSchedulerConfig.getClusterMaxMergeCount()).thenReturn(9);
        Setting<Boolean> booleanSetting2 = Setting.boolSetting("index.foo.bar.baz", false, Property.Dynamic, Property.IndexScope);  
            s -> {},
            emptyAnalysisRegistry,
        assertNotNull(similarity);
        indexService.close("simon says", false);  
    private ScriptService scriptService;
            }
        final Settings settings = Settings.builder()  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            liveQueryCaches.add(customQueryCache);
 * license agreements. See the NOTICE file distributed with
            engineFactory,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        assertThat(similarity, Matchers.instanceOf(NonNegativeScoresSimilarity.class));
        };  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return new Store(shardId, indexSettings, directory, shardLock, onClose, shardPath, directoryFactory);
import static org.hamcrest.Matchers.instanceOf;  
            new EngineConfigFactory(indexSettings),  
            emptyMap(),
        }  
            if (key == null) {
        mockClusterMergeSchedulerConfig = mock(ClusterMergeSchedulerConfig.class);  
 * KIND, either express or implied.  See the License for the
            this.key = key;
        indicesQueryCache = new IndicesQueryCache(settings);
            emptyMap(),
                    repositoriesServiceReference::get,
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
                return new RemoteBlobStoreInternalTranslogFactory(
import org.opensearch.plugins.IndexStorePlugin;
            Collections.emptyMap(),
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
            deleter,
        public void deleteShardStore(String reason, ShardLock lock, IndexSettings indexSettings) throws IOException {}
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
    private static IndexModule createIndexModule(IndexSettings indexSettings, AnalysisRegistry emptyAnalysisRegistry) {
    };
import org.opensearch.index.translog.TranslogFactory;  
 * You may obtain a copy of the License at  
            () -> true,
import org.apache.lucene.store.LockFactory;  
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
            Collections.emptyMap(),  
        final Settings settings = Settings.builder()  
            return delegate.scorer(boost, collectionStats, termStats);  
        assertThat(openAnalyzers, empty());
import org.opensearch.core.index.shard.ShardId;
                return analyzer;
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
            circuitBreakerService,
        );
    private IndexSettings indexSettings;
            .build();  
    }
            fail("not registered");  
                    public void close() {
            Collections.emptyMap(),
                return "test";
        settings = Settings.builder()  
            xContentRegistry(),  
        public Index index() {
    }  
            mapperRegistry,
import org.opensearch.index.mapper.ParsedDocument;  
            new EngineConfigFactory(indexSettings),
        assertEquals(msg, expectThrows(IllegalStateException.class, () -> module.setReaderWrapper(null)).getMessage());
            engineFactory,  
        expectThrows(IllegalArgumentException.class, () -> module.addSearchOperationListener(null));
            emptyMap(),
    }
            @Override
import org.opensearch.common.util.PageCacheRecycler;
import java.util.Map;  
import org.opensearch.index.analysis.AnalysisRegistry;
        @Override  
    private ClusterMergeSchedulerConfig mockClusterMergeSchedulerConfig;
            Collections.emptyMap()
            .build();  
        public DirectoryReader apply(DirectoryReader reader) {
    public void testListener() throws IOException {
            Collections.emptyMap()
            indicesQueryCache,
            indexSettings,
import org.apache.lucene.search.Weight;
            indexSettings,
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
    }  
            () -> true,
import org.opensearch.common.settings.SettingsException;
            new EngineConfigFactory(indexSettings),
        indexService.close("simon says", false);  
        final MockEngineFactory engineFactory = new MockEngineFactory(AssertingDirectoryReader.class);
import org.opensearch.index.store.FsDirectoryFactory;
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
        super.setUp();
            emptyMap()  
    @Override  
            new IndicesFieldDataCache(settings, listener, clusterService, threadPool),
            @Override
        };  
            "test_recovery",
            Collections.emptyMap()
        @Override
            mapperRegistry,  
            Collections.emptyMap(),
/*  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                        super.close();
        final Map<String, IndexStorePlugin.DirectoryFactory> indexStoreFactories = singletonMap("foo_store", new FooFunction());  
        module.forceQueryCacheProvider((a, b) -> {
            .put("index.similarity.my_similarity.type", "test_similarity")
        indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
                    protected TokenStreamComponents createComponents(String fieldName) {
        IndexService indexService = newIndexService(module);  
import org.opensearch.cluster.routing.RecoverySource;  
        final IndexService indexService = newIndexService(module);
        SearchOperationListener listener = new SearchOperationListener() {
import org.opensearch.common.UUIDs;
        assertThat(indexService.getDirectoryFactory(), instanceOf(IndexStorePlugin.DirectoryFactory.class));
        try {
import java.util.HashSet;
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
            null,  
        IndexService indexService = newIndexService(module);
        }
            emptyAnalysisRegistry,
        public SimScorer scorer(float boost, CollectionStatistics collectionStats, TermStatistics... termStats) {
        );  
    @SuppressWarnings("removal")  
        }
import java.nio.file.Path;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(msg, expectThrows(IllegalStateException.class, () -> module.addIndexOperationListener(null)).getMessage());
        indexService.close("closing", false);
            .build();
        assertTrue(indexService.getReaderWrapper() instanceof Wrapper);  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
                    DefaultRemoteStoreSettings.INSTANCE,  
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)  
            .put(IndexModule.INDEX_RECOVERY_TYPE_SETTING.getKey(), "test_recovery")  
            Collections.emptyMap()  
        assertTrue(atomicBoolean.get());
            writableRegistry(),  
    public void testRegisterIndexStore() throws IOException {
            () -> module.forceQueryCacheProvider((a, b) -> { throw new AssertionError("never called"); })
        module.addIndexOperationListener(listener);
        return shard;
        String msg = "Can't modify IndexModule once the index service has been created";
    public void testFrozen() {
        );  
        final IndexModule module = new IndexModule(  
        final IndexService indexService = newIndexService(module);
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);  
        @Override
public class IndexModuleTests extends OpenSearchTestCase {
            .build();
            clusterService,
            if (indexSettings.isRemoteTranslogStoreEnabled() && shardRouting.primary()) {  
            translogFactorySupplier,
    public void testDisableQueryCacheHasPrecedenceOverForceQueryCache() throws IOException {
            emptyAnalysisRegistry,  
            Directory directory,  
import org.opensearch.index.remote.RemoteTranslogTransferTracker;  
        );  
            return new Store(shardId, indexSettings, directory, shardLock, onClose, shardPath);
 *     http://www.apache.org/licenses/LICENSE-2.0
        IndexModule module = new IndexModule(  
        ShardRouting shard = ShardRouting.newUnassigned(
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
import org.opensearch.index.cache.query.QueryCache;
import org.apache.lucene.search.similarities.Similarity;
            return new Index("test", "_na_");  
            }  
        assertTrue(executed.get());
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
import org.opensearch.indices.recovery.DefaultRecoverySettings;  
 *
        @Override  
            () -> true,
 * GitHub history for details.
            emptyMap()
        final IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);  
        }
            environment,  
        Setting<Boolean> booleanSetting = Setting.boolSetting("index.foo.bar", false, Property.Dynamic, Property.IndexScope);  
        indexService.getIndexEventListener().beforeIndexRemoved(null, null);  
            public void onNewReaderContext(ReaderContext readerContext) {  
        ShardId shardId = new ShardId(new Index("foo", "bar"), 0);
    public void testAddSearchOperationListener() throws IOException {  
            mock(Transport.class),  
import static org.opensearch.index.IndexService.IndexCreationContext.CREATE_INDEX;
            emptyAnalysisRegistry,
        return new IndexModule(  
import org.opensearch.index.engine.Engine;
import org.apache.lucene.tests.index.AssertingDirectoryReader;
            new EngineBackedIndexerFactory(new InternalEngineFactory()),  
            Collections.emptyMap(),
        assertTrue(indexService.cache().query() instanceof DisabledQueryCache);
        assertEquals("Similarity [my_similarity] must have an associated type", ex.getMessage());
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
        });
            () -> Boolean.FALSE,
 * this work for additional information regarding copyright
        };  
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason;  
import org.opensearch.indices.IndicesQueryCache;
    public void testAddIndexOperationListener() throws IOException {
import org.opensearch.common.settings.Setting.Property;  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        @Override
        indexService.close("simon says", false);
            null,  
                executed.set(true);
        assertEquals(msg, expectThrows(IllegalStateException.class, () -> module.addIndexEventListener(null)).getMessage());
            transportService,
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> newIndexService(module));
import org.opensearch.index.translog.InternalTranslogFactory;
import org.apache.lucene.index.Term;
    private IndicesQueryCache indicesQueryCache;  
import org.apache.lucene.index.DirectoryReader;
            Collections.emptyMap(),
        private final Set<CustomQueryCache> liveQueryCaches;
        } catch (SettingsException ex) {
            translogFactorySupplier,
package org.opensearch.index;
        IndexService indexService = newIndexService(module);
            () -> true,
import org.opensearch.index.shard.ShardPath;
            (DataFormatRegistry) null
            return customQueryCache;
        threadPool.shutdown(); // causes index service creation to fail
            emptyMap(),  
            DefaultRecoverySettings.INSTANCE,  
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            scriptService,
        indexService.close("simon says", false);
import org.opensearch.threadpool.TestThreadPool;
            new InternalEngineFactory(),
            null,
            .build();
        public void clear(String reason) {}  
    private BigArrays bigArrays;  
        shard = shard.initialize("node1", null, -1);
                    }
            .build();
        );  
                executed.set(true);  
            circuitBreakerService,
    private MapperRegistry mapperRegistry;  
        Similarity similarity = similarityService.getSimilarity("my_similarity").get();  
        indexService.close("simon says", false);
    }
        }
        IndexSettings x = indexService.getIndexSettings();  
            .put("index.similarity.my_similarity.foo", "bar")
        }
            () -> false,
import org.opensearch.cluster.metadata.IndexMetadata;  
    @Override
        Settings settings = Settings.builder()  
            @Override
import static org.hamcrest.Matchers.is;
        expectThrows(IllegalArgumentException.class, () -> module.addSearchOperationListener(listener));  
import org.opensearch.env.Environment;
            ShardLock shardLock,  
        }  
    public void testOtherServiceBound() throws IOException {  
    }
            l.preIndex(shardId, index);  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertThat(similarity, Matchers.instanceOf(TestSimilarity.class));
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
import static org.hamcrest.Matchers.hasToString;
            indexSettings,
 * compatible open source license.
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        public Store newStore(
        }  
        assertEquals(msg, expectThrows(IllegalStateException.class, () -> module.forceQueryCacheProvider(null)).getMessage());
import org.opensearch.index.analysis.AnalyzerProvider;  
            module.addSettingsUpdateConsumer(booleanSetting2, atomicBoolean::set);
            Collections.emptyMap(),
            indexSettings,
        public Weight doCache(Weight weight, QueryCachingPolicy policy) {
        String storeType = randomFrom(IndexModule.Type.HYBRIDFS.getSettingsKey(), IndexModule.Type.MMAPFS.getSettingsKey());
        );
    public static final class TestStoreFactory implements IndexStorePlugin.StoreFactory {  
    }
    }  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }  
        final Map<String, IndexStorePlugin.StoreFactory> storeFactories = singletonMap("test_store", testStoreFactory);
            @Override  
            () -> true,
        indexService.close("simon says", false);
            storeFactories,
        index = indexSettings.getIndex();  
        final TestStoreFactory testStoreFactory = new TestStoreFactory();  
        final MockEngineFactory engineFactory = new MockEngineFactory(AssertingDirectoryReader.class);
        Settings settings = Settings.builder()
            Collections.emptyMap(),
    public void testAddSimilarity() throws IOException {
            liveQueryCaches.add(customQueryCache);  
import org.apache.lucene.index.FieldInvertState;  
        Settings settings = Settings.builder()  
    private final IndexFieldDataCache.Listener listener = new IndexFieldDataCache.Listener() {
import static org.mockito.Mockito.when;  
 * Licensed to Elasticsearch under one or more contributor  
            threadPool
        assertThat(exception.getMessage(), containsString("Unknown store factory [unknown_store]"));  
import org.apache.lucene.analysis.standard.StandardTokenizer;
            "test_similarity",  
        final Settings settings = Settings.builder()
    }
import org.opensearch.index.cache.query.DisabledQueryCache;
    public void testWrapperIsBound() throws IOException {  
        }
 */
        @Override
        );
    private RepositoriesService repositoriesService;  
import org.opensearch.script.ScriptService;
            new EngineConfigFactory(indexSettings),
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(new Index("foo", "_na_"), settings, nodeSettings);
            public AnalyzerScope scope() {  
            ShardId shardId,
            .put(IndexModule.INDEX_STORE_FACTORY_SETTING.getKey(), "unknown_store")
        IndexService indexService = newIndexService(module);
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
        assertTrue(indexService.cache().query() instanceof IndexQueryCache);  
        assertEquals(2, indexService.getSearchOperationListener().size());
            new RemoteSegmentStoreDirectoryFactory(() -> repositoriesService, threadPool, ""),  
        @Override
        module.addIndexEventListener(eventListener);
        for (SearchOperationListener l : indexService.getSearchOperationListener()) {
        );
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier = (a, b) -> new InternalTranslogFactory();
        Exception ex = expectThrows(IllegalArgumentException.class, () -> newIndexService(module));
        similarity = ((NonNegativeScoresSimilarity) similarity).getDelegate();  
    public void testSetupUnknownSimilarity() {
        final AnalysisRegistry analysisRegistry = new AnalysisRegistry(
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
            null,
import org.opensearch.index.shard.SearchOperationListener;  
        @Override
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            .put(IndexModule.INDEX_STORE_FACTORY_SETTING.getKey(), "test_store")
        super.tearDown();  
    private AnalysisRegistry emptyAnalysisRegistry;
        }  
    public void testForceCustomQueryCache() throws IOException {
            threadPool,  
        );  
        for (IndexingOperationListener l : indexService.getIndexOperationListeners()) {
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier = (indexSettings, shardRouting) -> {
            final CustomQueryCache customQueryCache = new CustomQueryCache(liveQueryCaches);
import java.util.Collections;
            .build();  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
import org.opensearch.index.analysis.AnalyzerScope;
            public void beforeIndexRemoved(IndexService indexService, IndexRemovalReason reason) {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    }
import org.opensearch.index.engine.InternalEngineFactory;
import org.opensearch.test.IndexSettingsModule;
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
        assertEquals(x.getIndex(), index);
            new RemoteSegmentStoreDirectoryFactory(() -> repositoriesService, threadPool, ""),
            mockClusterMergeSchedulerConfig,
    }
    public void setUp() throws Exception {
        module.freeze();
                return AnalyzerScope.INDEX;
        assertSame(listener, indexService.getIndexOperationListeners().get(1));  
    private static class TestSimilarity extends Similarity {  
            settings,
    public static final class FooFunction implements IndexStorePlugin.DirectoryFactory {
import org.apache.lucene.analysis.Analyzer;  
                    @Override  
        module.forceQueryCacheProvider((a, b) -> {
            emptyMap(),
            CREATE_INDEX,
            Collections.emptyMap(),
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), "foo_store")  
    }
        private final String key;
import org.opensearch.Version;
import org.opensearch.common.CheckedFunction;
        assertEquals(SearchSlowLog.class, indexService.getSearchOperationListener().get(0).getClass());
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
            () -> true,  
            Collections.emptyMap(),  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
import org.opensearch.index.store.Store;  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            () -> Boolean.FALSE,  
    }  
        assertEquals(x.getSettings(), indexSettings.getSettings());
            return new InternalTranslogFactory();
        final SetOnce<RepositoriesService> repositoriesServiceReference = new SetOnce<>();  
import org.opensearch.indices.recovery.RecoveryState;
            .build();
    private Index index;  
        }  
            scriptService,
            .build();  
 * Modifications Copyright OpenSearch Contributors. See  
    private ThreadPool threadPool;
import org.opensearch.index.shard.IndexEventListener;
        }  
            writableRegistry(),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
        module.setReaderWrapper(s -> new Wrapper());  
            new InternalEngineFactory(),  
        public Directory newDirectory(IndexSettings indexSettings, ShardPath shardPath) throws IOException {
            return null;
            Collections.emptySet(),
import java.util.Set;
                final Analyzer analyzer = new Analyzer() {  
        mapperRegistry = new IndicesModule(Collections.emptyList()).getMapperRegistry();  
import org.opensearch.indices.ClusterMergeSchedulerConfig;
            emptyMap(),
        PageCacheRecycler pageCacheRecycler = new PageCacheRecycler(settings);
            new EngineConfigFactory(indexSettings),
        final IndexModule module = new IndexModule(
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
            xContentRegistry(),
            Collections.emptyMap(),
import org.opensearch.index.mapper.Uid;
}
import org.opensearch.core.common.breaker.CircuitBreaker;
        Settings settings = Settings.builder()
            emptyMap(),  
        );  
        return module.newIndexService(  
        RecoveryState recoveryState = mock(RecoveryState.class);
 * Unless required by applicable law or agreed to in writing,
        assertTrue(executed.get());
        assertNotNull(indexService);  
            .put("index.similarity.my_similarity.type", "test_similarity")
            .build();
        });  
            indicesQueryCache,
import org.opensearch.index.fielddata.IndexFieldDataCache;
        indexService.close("simon says", false);  
import java.util.concurrent.TimeUnit;
            () -> TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE
        Engine.Index index = new Engine.Index(new Term("_id", Uid.encodeId(doc.id())), randomNonNegativeLong(), doc);  
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
            () -> true,
        ParsedDocument doc = InternalEngineTests.createParsedDoc("1", null);
            emptyAnalysisRegistry,
        module.addSearchOperationListener(listener);
            Collections.emptyMap()
            new EngineConfigFactory(indexSettings),
        final IndexModule module = new IndexModule(  
    }  
    private NodeEnvironment nodeEnvironment;
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
            () -> false,
            (providerSettings, indexCreatedVersion, scriptService) -> new TestSimilarity(providerSettings.get("key"))
import static org.hamcrest.Matchers.empty;
            AlreadySetException.class,
        repositoriesService = new RepositoriesService(
    public void testMmapNotAllowed() {
            Collections.emptyMap(),  
        assertEquals(IndexingSlowLog.class, indexService.getIndexOperationListeners().get(0).getClass());
            ShardPath shardPath,
        ) throws IOException {
 * not use this file except in compliance with the License.
            null,
            () -> true,  
        module.newIndexService(
            nodeEnvironment,
            Store.OnClose onClose,
        ShardRouting shard = createInitializedShardRouting();  
    public void testUnknownStoreFactory() {
import org.opensearch.cluster.node.DiscoveryNode;
    public static final class Wrapper implements CheckedFunction<DirectoryReader, DirectoryReader, IOException> {
    };
        indexService.close("closing", false);
        indexService.close("closing", false);
            IndexSettings indexSettings,
                return operation;
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        TransportService transportService = new TransportService(
        // Test that IndexService uses default store when setting is empty
            return delegate.computeNorm(state);
    private Environment environment;  
        );
            .build();
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings, booleanSetting);
        AtomicBoolean executed = new AtomicBoolean(false);
            @Override  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            clusterService,
            IndexSettings indexSettings,
import org.opensearch.index.similarity.NonNegativeScoresSimilarity;
import org.opensearch.common.util.io.IOUtils;  
        };
            threadPool,
    public void testStoreFactoryWithEmptySetting() throws IOException {
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
        assertEquals(2, indexService.getIndexOperationListeners().size());
        );  
        bigArrays = new BigArrays(pageCacheRecycler, circuitBreakerService, CircuitBreaker.REQUEST);
        final IndexService indexService = newIndexService(module);  
        assertEquals("Unknown Similarity type [test_similarity] for [my_similarity]", ex.getMessage());
            emptyMap(),
        public Store newStore(  
    }
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> newIndexService(module));
        assertTrue(indexService.cache().query() instanceof CustomQueryCache);
        assertEquals("my_similarity", similarityService.getSimilarity("my_similarity").name());
        final AnalysisModule.AnalysisProvider<AnalyzerProvider<?>> analysisProvider = (i, e, n, s) -> new AnalyzerProvider<Analyzer>() {
import org.opensearch.search.internal.ReaderContext;
    }
            emptyAnalysisRegistry,
        );
        module.addSimilarity(
        when(mockClusterMergeSchedulerConfig.getClusterMaxThreadCount()).thenReturn(4);
        IndexService indexService = newIndexService(module);
        }  
 *  
            bigArrays,
import org.apache.lucene.search.QueryCachingPolicy;  
            new IndicesFieldDataCache(settings, listener, clusterService, threadPool),  
        final IndexModule module = new IndexModule(
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);  
            public Engine.Index preIndex(ShardId shardId, Engine.Index operation) {
            () -> IndexSettings.DEFAULT_REFRESH_INTERVAL,
            }  
            NoopTracer.INSTANCE  
 * The OpenSearch Contributors require contributions made to  
        final HashSet<Analyzer> openAnalyzers = new HashSet<>();
import org.opensearch.test.OpenSearchTestCase;  
            indexSettings,  
import org.apache.lucene.search.TermStatistics;
            RecoverySource.ExistingStoreRecoverySource.INSTANCE,
            }  
        );  
            new EngineConfigFactory(indexSettings),  
            emptyMap(),  
import org.opensearch.indices.analysis.AnalysisModule;
            .put(IndexModule.INDEX_STORE_FACTORY_SETTING.getKey(), "")
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
    }
    }  
            return customQueryCache;
/*
            DefaultRecoverySettings.INSTANCE,
        module.addSettingsUpdateConsumer(booleanSetting, atomicBoolean::set);
                        return new TokenStreamComponents(new StandardTokenizer());  
            null,
            deleter,  
import org.opensearch.common.util.BigArrays;  
        IndexService indexService = newIndexService(module);
        public long computeNorm(FieldInvertState state) {  
        public void addPendingDelete(ShardId shardId, IndexSettings indexSettings) {}
            () -> Boolean.FALSE,
            emptyMap(),
        assertThat(liveQueryCaches, empty());
            () -> Boolean.FALSE,
            IndexStorePlugin.DirectoryFactory directoryFactory  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            ShardLock shardLock,
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("foo", settings);  
            }
        threadPool = new TestThreadPool("test");
            emptyMap(),  
        final IndexService indexService = newIndexService(module);
 * under the License.  
            }
        final Set<CustomQueryCache> liveQueryCaches = new HashSet<>();
 * SPDX-License-Identifier: Apache-2.0
        public Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException {  
            recoveryStateFactories
        IndexModule module = createIndexModule(indexSettings, analysisRegistry);
            }
        final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories = singletonMap(  
        nodeEnvironment = new NodeEnvironment(settings, environment);
    public void testRegisterCustomRecoveryStateFactory() throws IOException {
                    RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexSettings.getIndexMetadata())
import org.apache.lucene.search.CollectionStatistics;
            Collections.emptyMap(),  
    private IndexService newIndexService(IndexModule module) throws IOException {
import org.opensearch.common.settings.Setting;
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
        };
            emptyAnalysisRegistry,
import org.apache.lucene.store.Directory;
            bigArrays,  
            emptyMap(),
        assertEquals("there is a key", ((TestSimilarity) similarity).key);  
            Collections.emptyMap()
            Directory directory,
            nodeEnvironment,
        expectThrows(IllegalArgumentException.class, () -> module.addIndexOperationListener(listener));  
import static org.mockito.Mockito.mock;
        assertSame(indexService.getIndexerFactory(), module.getIndexerFactory());
        IndexService indexService = newIndexService(module);
            final CustomQueryCache customQueryCache = new CustomQueryCache(liveQueryCaches);  
                    @Override
            storeFactories,
import org.opensearch.test.engine.MockEngineFactory;
            () -> IndexSettings.DEFAULT_REFRESH_INTERVAL,  
        assertThat(indexService.createRecoveryState(shard, mock(DiscoveryNode.class), mock(DiscoveryNode.class)), is(recoveryState));
 * specific language governing permissions and limitations
        IOUtils.close(nodeEnvironment, indicesQueryCache, clusterService);
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        ) throws IOException {
        Settings settings = Settings.builder()  
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);  
import org.opensearch.indices.IndicesModule;  
        TestSimilarity(String key) {
import org.opensearch.env.ShardLock;  
import static java.util.Collections.emptyMap;  
            threadPool,
        @Override
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);  
            clusterService,  
            indexSettings,
        final Settings settings = Settings.builder()
        final IndexEventListener eventListener = new IndexEventListener() {
    }
        final Settings nodeSettings = Settings.builder().put(IndexModule.NODE_STORE_ALLOW_MMAP.getKey(), false).build();
        assertSame(booleanSetting, indexService.getIndexSettings().getScopedSettings().get(booleanSetting.getKey()));  
        final IndexModule module = new IndexModule(
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
        @Override
            .put("index.similarity.my_similarity.key", "there is a key")  
        emptyAnalysisRegistry = new AnalysisRegistry(
        indexService.close("simon says", false);  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
 * the Apache License, Version 2.0 (the "License"); you may
/*
    private ShardRouting createInitializedShardRouting() {  
import org.opensearch.indices.DefaultRemoteStoreSettings;
import java.util.concurrent.atomic.AtomicBoolean;  
    private IndexService.ShardStoreDeleter deleter = new IndexService.ShardStoreDeleter() {
        repositoriesServiceReference.set(repositoriesService);
        assertThat(liveQueryCaches, empty());  
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
            public Analyzer get() {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            indexStoreFactories,  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
    public void testStoreFactory() throws IOException {
import org.opensearch.threadpool.ThreadPool;  
    }
import org.opensearch.common.SetOnce.AlreadySetException;  
            .build();
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);  
import java.util.function.BiFunction;
            null,  
import org.opensearch.common.settings.Settings;
        Settings settings = Settings.builder()
            ShardId shardId,  
        expectThrows(IllegalArgumentException.class, () -> module.addIndexOperationListener(null));
        private final Similarity delegate = new BM25Similarity();
        @Override  
            Collections.emptyMap(),  
            null,
import org.opensearch.test.ClusterServiceUtils;
            environment,
import org.opensearch.env.TestEnvironment;
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        Settings settings = Settings.builder()  
import org.opensearch.index.similarity.SimilarityService;  
                    }
import org.opensearch.index.translog.RemoteBlobStoreInternalTranslogFactory;
        final Settings settings = Settings.builder()
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        module.forceQueryCacheProvider((a, b) -> new CustomQueryCache(null));  
                    indexSettings.getRemoteStoreTranslogRepository(),
                };
            ShardPath shardPath  
            this.liveQueryCaches = liveQueryCaches;
            singletonMap("test", analysisProvider),  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            .build();  
    public void testLegacyConstructors() throws IOException {
        expectThrows(OpenSearchRejectedExecutionException.class, () -> newIndexService(module));
            null,
    }
        );  
 * ownership. Elasticsearch licenses this file to you under  
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);
        IndexingOperationListener listener = new IndexingOperationListener() {  
    public void testSetupWithoutType() {
import static java.util.Collections.singletonMap;
import org.opensearch.env.NodeEnvironment;
    public void testCustomQueryCacheCleanedUpIfIndexServiceCreationFails() {  
                openAnalyzers.add(analyzer);  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            DefaultRemoteStoreSettings.INSTANCE,
        );
            true,  
    }
import org.hamcrest.Matchers;  
            new InternalEngineFactory(),
        assertNotNull(indexService);  
    private ClusterService clusterService;
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
        @Override  
                    new RemoteTranslogTransferTracker(shardRouting.shardId(), 10),
        indexService.close("simon says", false);
        scriptService = new ScriptService(settings, Collections.emptyMap(), Collections.emptyMap());  
    public void testIndexAnalyzersCleanedUpIfIndexServiceCreationFails() {  
        // Test that IndexService can be created successfully with valid store factory
import org.opensearch.indices.mapper.MapperRegistry;
import org.opensearch.common.util.concurrent.ThreadContext;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            Collections.emptyMap(),  
        assertEquals(msg, expectThrows(IllegalStateException.class, () -> module.addSimilarity(null, null)).getMessage());  
            indexSettings,
import org.opensearch.cluster.routing.UnassignedInfo;
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
    private CircuitBreakerService circuitBreakerService;
    }
        indexService.close("simon says", false);
    }  
            Collections.emptyMap()
            emptyMap(),
import org.apache.lucene.search.similarities.BM25Similarity;  
        Exception ex = expectThrows(IllegalArgumentException.class, () -> newIndexService(module));
    }
import org.opensearch.common.SetOnce;
    }  
        expectThrows(  
        final TestStoreFactory testStoreFactory = new TestStoreFactory();  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            }
 */  
        public void close() {  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
import java.io.IOException;
import org.opensearch.index.cache.query.IndexQueryCache;  
            emptyMap(),
            return new FsDirectoryFactory().newDirectory(indexSettings, shardPath);
        final Map<String, IndexStorePlugin.StoreFactory> storeFactories = singletonMap("test_store", testStoreFactory);
        );  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
                        openAnalyzers.remove(this);  
        SimilarityService similarityService = indexService.similarityService();
        environment = TestEnvironment.newEnvironment(settings);
        assertEquals(msg, expectThrows(IllegalStateException.class, () -> module.addSearchOperationListener(null)).getMessage());  
                );
    }
            null,  
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);  
        AtomicBoolean executed = new AtomicBoolean(false);  
    private Settings settings;
    }  
            new ShardId("test", "_na_", 0),
            DefaultRemoteStoreSettings.INSTANCE,  
            indexSettings,  
    public void testDefaultQueryCacheImplIsSelected() throws IOException {
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);  
            Collections.emptyMap(),
        expectThrows(OpenSearchRejectedExecutionException.class, () -> newIndexService(module));  
            @Override
            boundAddress -> DiscoveryNode.createLocal(settings, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),  
        circuitBreakerService = new NoneCircuitBreakerService();  
    }  
 * this file be licensed under the Apache-2.0 license or a
    }  
        @Override  
        assertSame(listener, indexService.getSearchOperationListener().get(1));  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            emptyAnalysisRegistry,  
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(index, settings);  
 */
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        Settings settings = Settings.builder()
import org.opensearch.repositories.RepositoriesService;  
            new EngineBackedIndexerFactory(new InternalEngineFactory()),  
        threadPool.shutdown(); // causes index service creation to fail
            null,  
import org.opensearch.core.index.Index;  
            .put("index.store.type", storeType)
            .build();  
    }
        }  
import org.opensearch.index.remote.RemoteStoreUtils;
        IndexService indexService = newIndexService(module);
                    threadPool,  
            .build();  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            return null;
        IndexModule module = createIndexModule(indexSettings, emptyAnalysisRegistry);
        IndexModule module = new IndexModule(
import static org.hamcrest.Matchers.containsString;  
    public void tearDown() throws Exception {
 *

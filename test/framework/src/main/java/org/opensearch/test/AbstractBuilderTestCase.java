import static java.util.stream.Collectors.toList;
                    "_doc",
                Stream.of(searchModule.getNamedXContents().stream()).flatMap(Function.identity()).collect(toList())
                GetResponse getResponse = delegate.executeGet((GetRequest) args[0]);
            indicesBitsetFilterCache = new IndicesBitsetFilterCache(Settings.EMPTY);
        IOUtils.close(serviceHolderWithNoType);
                    new CompressedXContent(
            // the randomness source that is later used in the test method, we use the cluster-manager seed during
import java.util.Collection;
                            "type=date",
                return new PlainActionFuture<MultiTermVectorsResponse>() {
        serviceHolder.clientInvocationHandler.delegate = this;
import java.lang.reflect.Proxy;
            if (method.equals(Client.class.getMethod("get", GetRequest.class, ActionListener.class))) {
            );
    }
            }
                    nowInMillis,
    private static class ClientInvocationHandler implements InvocationHandler {
        ALIAS_TO_CONCRETE_FIELD_NAME.put(TEXT_ALIAS_FIELD_NAME, TEXT_FIELD_NAME);
                        PutMappingRequest.simpleMapping(
        ThreadPool.terminate(threadPool, 1, TimeUnit.MINUTES);
    protected static final String GEO_POINT_ALIAS_FIELD_NAME = "mapped_geo_point_alias";
import org.opensearch.cluster.service.ClusterService;
     * @return a new {@link QueryShardContext} based on an index with no type registered
    private static ServiceHolder serviceHolder;
import org.opensearch.index.query.QueryBuilder;
 * compatible open source license.
        private final NamedXContentRegistry xContentRegistry;
            indexFieldDataService = new IndexFieldDataService(
import org.opensearch.index.query.QueryShardContext;
        serviceHolderWithNoType.clientInvocationHandler.delegate = null;
        ALIAS_TO_CONCRETE_FIELD_NAME.put(INT_ALIAS_FIELD_NAME, INT_FIELD_NAME);
                            "type=date_nanos",
        private final IndicesBitsetFilterCache indicesBitsetFilterCache;
import org.opensearch.core.index.shard.ShardId;
            );
import org.junit.AfterClass;
                threadPool
                new NoneCircuitBreakerService(),
        private final SearchModule searchModule;
 * The OpenSearch Contributors require contributions made to
                    @Override
            }
                throw new AssertionError("node.name must be set");
    }
    @After
import java.lang.reflect.InvocationHandler;
        return serviceHolder.mapperService.fieldTypes();
import java.util.HashMap;
                }
                additionalSettings,
 * the Apache License, Version 2.0 (the "License"); you may
        return serviceHolder.namedWriteableRegistry;
import org.junit.Before;
            IndexAnalyzers indexAnalyzers = analysisModule.getAnalysisRegistry().build(idxSettings);
 * Modifications Copyright OpenSearch Contributors. See
        return new QueryBuilderVisitor() {
import org.opensearch.common.settings.Settings;
import static java.util.Collections.emptyMap;
            ScriptModule scriptModule = createScriptModule(pluginsService.filterPlugins(ScriptPlugin.class));
    }
                            "type=integer_range",
                            INT_FIELD_NAME,
                indexAnalyzers,
            throw new UnsupportedOperationException("this test can't handle calls to: " + method);
            // Simplistic index name matcher used for testing
import org.opensearch.plugins.SearchPlugin;
                            + "\"properties\":{\""
            idxSettings = IndexSettingsModule.newIndexSettings(index, indexSettings, indexScopedSettings);
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                    new CompressedXContent(
        TEXT_FIELD_NAME,
                            "type=alias,path=" + TEXT_FIELD_NAME,
    }
    public static final String TEXT_FIELD_NAME = "mapped_string";
        INT_RANGE_FIELD_NAME,
import java.lang.reflect.Method;
        private final Client client;
import org.opensearch.common.util.io.IOUtils;
                            DATE_ALIAS_FIELD_NAME,
        return serviceHolder.idxSettings;
        }
                    getPlugins(),
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {}
 */
                            "type=text",
                indexFieldDataService::getForField,
    protected static String createUniqueRandomName() {
        nowInMillis = randomNonNegativeLong();
            Collection<Class<? extends Plugin>> plugins,
    }
        GEO_POINT_FIELD_NAME,
            return pattern -> Regex.simpleMatch(pattern, index.getName());
            entries.addAll(indicesModule.getNamedWriteables());
            return new ScriptModule(Settings.EMPTY, scriptPlugins);
import org.opensearch.index.analysis.IndexAnalyzers;
                            + INT_FIELD_NAME
import java.util.stream.Stream;
import org.opensearch.search.SearchModule;
                xContentRegistry,
                    nodeSettings,
                            GEO_POINT_ALIAS_FIELD_NAME,
        threadPool = new TestThreadPool("random_threadpool_name");
     */
    }
 */
                testCase.initializeAdditionalMappings(mapperService);
    private static long nowInMillis;
                            DATE_NANOS_FIELD_NAME,
                bitsetFilterCache,
import org.opensearch.index.mapper.MapperService;
                public void onCache(ShardId shardId, Accountable accountable) {
        Version indexVersionCreated = randomBoolean() ? Version.CURRENT : VersionUtils.randomIndexCompatibleVersion(random());
     */
                    AbstractBuilderTestCase.this,
                    ),
            SettingsModule settingsModule = new SettingsModule(
                            + DATE_FIELD_NAME
import org.apache.lucene.search.IndexSearcher;
                return this;
    @Override
        private final ClientInvocationHandler clientInvocationHandler = new ClientInvocationHandler();
    protected static final String[] MAPPED_LEAF_FIELD_NAMES = new String[] {
 * GitHub history for details.
                    nodeSettings,
                serviceHolderWithNoType = new ServiceHolder(
            scriptService = new MockScriptService(Settings.EMPTY, scriptModule.engines, scriptModule.contexts);
    }
            IndexScopedSettings indexScopedSettings = settingsModule.getIndexScopedSettings();
import org.opensearch.indices.IndicesModule;
        private final MapperService mapperService;
    protected NamedWriteableRegistry namedWriteableRegistry() {
                Collections.emptySet()
import java.util.Map;
                            + "\":{\"type\":\"object\","
                mapperService,
import org.opensearch.index.cache.bitset.BitsetFilterCache;
            bitsetFilterCache = new BitsetFilterCache(idxSettings, indicesBitsetFilterCache, new BitsetFilterCache.Listener() {
        serviceHolder.clientInvocationHandler.delegate = null;
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    protected static final String DATE_FIELD_NAME = "mapped_date";
    @AfterClass
                nodeSettings,
        BOOLEAN_FIELD_NAME,
        private final IndexFieldDataService indexFieldDataService;
        return serviceHolder.xContentRegistry;
    }
 * KIND, either express or implied.  See the License for the
    protected static QueryShardContext createShardContext(IndexSearcher searcher) {
    /**
import org.opensearch.action.get.GetResponse;
        DATE_RANGE_FIELD_NAME,
                );
    protected NamedXContentRegistry xContentRegistry() {
 * Licensed to Elasticsearch under one or more contributor
     */
        return queryName;
        GEO_POINT_ALIAS_FIELD_NAME,
                return new ScriptModule(Settings.EMPTY, singletonList(new ScriptPlugin() {
                BigArrays.NON_RECYCLING_INSTANCE,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.script.ScriptEngine;
                similarityService,
 * license agreements. See the NOTICE file distributed with
                            "type=date_range",
    private static Index index;
                );
            @Override
import org.opensearch.core.action.ActionListener;
    }
            boolean registerType
import org.opensearch.Version;
                    "_doc",
    }
            // we initialize the serviceHolder and serviceHolderWithNoType just once, but need some
     * @return a new {@link QueryShardContext} with the provided searcher
    @Before
import java.util.function.Function;
        DOUBLE_FIELD_NAME,
    protected static QueryShardContext createShardContextWithNoType() {
                    nowInMillis,
            AnalysisModule analysisModule = new AnalysisModule(TestEnvironment.newEnvironment(nodeSettings), emptyList());
    @SuppressWarnings("deprecation") // dependencies in server for geo_shape field should be decoupled
        AbstractBuilderTestCase delegate;
        return index;
        DATE_RANGE_FIELD_NAME,
            .build();
        serviceHolderWithNoType.clientInvocationHandler.delegate = this;
package org.opensearch.test;
            client = (Client) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[] { Client.class }, clientInvocationHandler);
                            "type=alias,path=" + DATE_FIELD_NAME,
                }));
    protected MultiTermVectorsResponse executeMultiTermVectors(MultiTermVectorsRequest mtvRequest) {
                        return new MockScriptEngine(MockScriptEngine.NAME, Collections.singletonMap("1", script -> "1"), emptyMap());
 * under the License.
    protected static final String DATE_NANOS_FIELD_NAME = "mapped_date_nanos";
        DATE_FIELD_NAME,
    protected Iterable<MappedFieldType> getMapping() {
        }
                namedWriteableRegistry,
        INT_RANGE_FIELD_NAME,
                similarityService,
import java.util.concurrent.Callable;
            // this setup
            );
                return null;
    public static void afterClass() throws Exception {
 * You may obtain a copy of the License at
                idxSettings,
        return serviceHolderWithNoType.createShardContext(null);
    protected static final String INT_ALIAS_FIELD_NAME = "mapped_int_field_alias";
                () -> createShardContext(null),
/*
     */
        public void close() throws IOException {
            long clusterManagerSeed = SeedUtils.parseSeed(RandomizedTest.getContext().getRunnerSeedAsString());
     */
import org.opensearch.script.ScriptContext;
import org.opensearch.common.compress.CompressedXContent;
            );
                );
                mapperService,
                }
        return createShardContext(null);
                            + OBJECT_FIELD_NAME
                serviceHolder = new ServiceHolder(
                    @Override
            }
                null,
        @Override
    protected Settings createTestIndexSettings() {
        OBJECT_FIELD_NAME,
            }
                    MapperService.MergeReason.MAPPING_UPDATE
                            TEXT_FIELD_NAME,
                    MapperService.MergeReason.MAPPING_UPDATE
    }
import com.carrotsearch.randomizedtesting.SeedUtils;
                null
            RandomizedTest.getContext().runWithPrivateRandomness(clusterManagerSeed, (Callable<Void>) () -> {
    }
        return Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, indexVersionCreated).build();
                ActionListener<GetResponse> listener = (ActionListener<GetResponse>) args[1];
            MapperRegistry mapperRegistry = indicesModule.getMapperRegistry();
            });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected static final String GEO_SHAPE_FIELD_NAME = "mapped_geo_shape";
import java.util.concurrent.ExecutionException;
            }
import org.junit.After;
                return null;
import org.opensearch.index.similarity.SimilarityService;
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
                visitedQueries.add(qb);
                if (randomBoolean()) {
                scriptService,
    protected static final String[] MAPPED_FIELD_NAMES = new String[] {
                idxSettings,
import org.opensearch.action.termvectors.MultiTermVectorsRequest;
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        nodeSettings = Settings.builder()
                // also add mappings for two inner field in the object field
                }
        if (serviceHolder == null) {
    public void beforeTest() throws Exception {
            if (scriptPlugins == null || scriptPlugins.isEmpty()) {
 */
    private static final Map<String, String> ALIAS_TO_CONCRETE_FIELD_NAME = new HashMap<>();
        }
import org.opensearch.node.InternalSettingsPreparer;
import static java.util.Collections.emptyList;
        GEO_POINT_ALIAS_FIELD_NAME };
                () -> false,
        ALIAS_TO_CONCRETE_FIELD_NAME.put(GEO_POINT_ALIAS_FIELD_NAME, GEO_POINT_FIELD_NAME);
        return serviceHolder.createShardContext(searcher);
    /**
import org.apache.lucene.search.BooleanClause;
            IndicesModule indicesModule = new IndicesModule(pluginsService.filterPlugins(MapperPlugin.class));
import java.io.Closeable;
            similarityService = new SimilarityService(idxSettings, null, Collections.emptyMap());
    }
    }
    protected static final String DATE_RANGE_FIELD_NAME = "mapped_date_range";
                            OBJECT_FIELD_NAME,
import org.junit.BeforeClass;
    private static ThreadPool threadPool;
        return ALIAS_TO_CONCRETE_FIELD_NAME.getOrDefault(builderFieldName, builderFieldName);
import java.util.concurrent.TimeUnit;
                    createTestIndexSettings(),
        throw new UnsupportedOperationException("this test can't handle MultiTermVector requests");
import org.opensearch.env.Environment;
import java.util.function.Predicate;
        DOUBLE_FIELD_NAME,
            List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();
    }
        queryNameId++;
                            "type=double",
    protected static final String OBJECT_FIELD_NAME = "mapped_object";
            assert serviceHolderWithNoType == null;
            } else if (method.equals(Client.class.getMethod("multiTermVectors", MultiTermVectorsRequest.class))) {
import org.opensearch.index.query.QueryBuilderVisitor;
        String queryName = randomAlphaOfLengthBetween(1, 10) + queryNameId;
    protected static Index getIndex() {
                            INT_RANGE_FIELD_NAME,
                null
        IOUtils.close(serviceHolder);
            searchModule = new SearchModule(nodeSettings, pluginsService.filterPlugins(SearchPlugin.class));
            entries.addAll(searchModule.getNamedWriteables());
    }
                threadPool
            },
import org.opensearch.core.index.Index;
        @Override
        }
import org.opensearch.transport.client.Client;
 * SPDX-License-Identifier: Apache-2.0
            IndicesFieldDataCache indicesFieldDataCache = new IndicesFieldDataCache(nodeSettings, new IndexFieldDataCache.Listener() {
                indicesFieldDataCache,
import org.opensearch.plugins.PluginsService;
                    Settings.EMPTY,
        ScriptModule createScriptModule(List<ScriptPlugin> scriptPlugins) {
        private final NamedWriteableRegistry namedWriteableRegistry;
                    new Thread(() -> listener.onResponse(getResponse)).start();
import java.util.ArrayList;
/*
import java.io.IOException;
    protected static QueryBuilderVisitor createTestVisitor(List<QueryBuilder> visitedQueries) {
import org.opensearch.script.MockScriptService;
public abstract class AbstractBuilderTestCase extends OpenSearchTestCase {
                    threadPool
        TEXT_ALIAS_FIELD_NAME,
    protected GetResponse executeGet(GetRequest getRequest) {
import org.opensearch.action.termvectors.MultiTermVectorsResponse;
    /**
            return new QueryShardContext(
                        ).toString()
                    }
        DATE_FIELD_NAME,
        private final SimilarityService similarityService;
import org.opensearch.indices.IndicesBitsetFilterCache;
    protected static final String DATE_ALIAS_FIELD_NAME = "mapped_date_alias";
            List<Setting<?>> additionalSettings = pluginsService.getPluginSettings();
import org.opensearch.common.settings.Setting;
import org.opensearch.index.fielddata.IndexFieldDataService;
                mapperRegistry,
                    true
            indicesBitsetFilterCache.close();
import org.opensearch.script.ScriptService;
import java.util.Collections;
                        return delegate.executeMultiTermVectors((MultiTermVectorsRequest) args[0]);
        private final ScriptService scriptService;
    static {
        private final BitsetFilterCache bitsetFilterCache;
                            + "\":{\"type\":\"integer\"}}}}}"
        GEO_SHAPE_FIELD_NAME };
                    }
        ServiceHolder(
        TEXT_ALIAS_FIELD_NAME,
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
import static java.util.Collections.singletonList;
import org.opensearch.indices.analysis.AnalysisModule;
import org.opensearch.common.regex.Regex;
     */
        }
                public void onRemoval(ShardId shardId, Accountable accountable) {
                            TEXT_ALIAS_FIELD_NAME,
                            GEO_SHAPE_FIELD_NAME,
                    false
                    AbstractBuilderTestCase.this,
import org.opensearch.indices.mapper.MapperRegistry;
            xContentRegistry = new NamedXContentRegistry(
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            // calls to the randomness source during its setup. In order to not mix these calls with
import org.opensearch.script.MockScriptEngine;
     * @return a new {@link QueryShardContext} based on the base test index and queryParserService
                    ),
    @BeforeClass
import org.apache.lucene.util.Accountable;
        ALIAS_TO_CONCRETE_FIELD_NAME.put(DATE_ALIAS_FIELD_NAME, DATE_FIELD_NAME);
        private final long nowInMillis;
}
    protected static final String DOUBLE_FIELD_NAME = "mapped_double";
                );
                () -> true,
                ),
        return Collections.singletonList(TestGeoShapeFieldMapperPlugin.class);
                idxSettings,
            long nowInMillis,
    /**
 * ownership. Elasticsearch licenses this file to you under
        private final IndexSettings idxSettings;
import org.opensearch.common.util.BigArrays;
    private static int queryNameId = 0;
import org.opensearch.common.settings.IndexScopedSettings;
            PluginsService pluginsService;
                pluginsService.getPluginSettingsFilter(),
        INT_FIELD_NAME,
import org.opensearch.script.ScriptModule;
 * this work for additional information regarding copyright
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.action.support.PlainActionFuture;
    /**
 *
import org.opensearch.plugins.MapperPlugin;
import org.opensearch.threadpool.ThreadPool;
                            "type=keyword",
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
    protected static final String INT_RANGE_FIELD_NAME = "mapped_int_range";
            });
            Settings indexSettings,
        }
        throw new UnsupportedOperationException("this test can't handle GET requests");
    protected static String expectedFieldName(String builderFieldName) {
                    public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
    protected static final String GEO_POINT_FIELD_NAME = "mapped_geo_point";
    private static class ServiceHolder implements Closeable {
                            DATE_RANGE_FIELD_NAME,
    }
import org.opensearch.plugins.ScriptPlugin;
                };
                return "MockClient";
            });
                            "type=boolean",
    protected static final String BOOLEAN_FIELD_NAME = "mapped_boolean";
    }
            Settings nodeSettings,
     * Override this to handle {@link Client#get(GetRequest)} calls from parsers / builders
 *
                    createTestIndexSettings(),
    }
    private static Settings nodeSettings;
    protected Collection<Class<? extends Plugin>> getPlugins() {
 * specific language governing permissions and limitations
import org.opensearch.index.IndexSettings;
            public void accept(QueryBuilder qb) {
                    getPlugins(),
                () -> nowInMillis,
        GEO_POINT_FIELD_NAME,
                } else {
                            BOOLEAN_FIELD_NAME,
import com.carrotsearch.randomizedtesting.RandomizedTest;
                            DATE_FIELD_NAME,
            );
                new ClusterService(
            AbstractBuilderTestCase testCase,
    protected static IndexSettings indexSettings() {
     * make sure query names are unique by suffixing them with increasing counter
                            DOUBLE_FIELD_NAME,
        index = new Index(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLength(10));
                        "{\"properties\":{\""
        BOOLEAN_FIELD_NAME,
            @Override
        serviceHolderWithNoType = null;
        serviceHolder = null;
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
import org.opensearch.common.settings.SettingsModule;
import org.opensearch.plugins.Plugin;
    }
                            "type=geo_shape"
            mapperService = new MapperService(
        public static Predicate<String> indexNameMatcher() {
 * software distributed under the License is distributed on an
 *
    public void afterTest() {
                xContentRegistry,
                            INT_ALIAS_FIELD_NAME,
                            "type=geo_point",
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
/*
    }
        ) throws IOException {
            public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {
     * Override this to handle {@link Client#get(GetRequest)} calls from parsers / builders
                0,
    protected static final String KEYWORD_FIELD_NAME = "mapped_string_2";
                            "type=alias,path=" + INT_FIELD_NAME,
        };
import org.opensearch.action.get.GetRequest;
        QueryShardContext createShardContext(IndexSearcher searcher) {
        }
import org.opensearch.common.settings.ClusterSettings;
            if (registerType) {
                mapperService.merge(
            pluginsService = new PluginsService(nodeSettings, env.modulesDir(), env.pluginsDir(), plugins);
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.index.fielddata.IndexFieldDataCache;
        DATE_NANOS_FIELD_NAME,
                @Override
    }
        DATE_NANOS_FIELD_NAME,
    public static final String TEXT_ALIAS_FIELD_NAME = "mapped_string_alias";
            );
                    public MultiTermVectorsResponse get() throws InterruptedException, ExecutionException {
                mapperService.merge(
import org.opensearch.env.TestEnvironment;
            Environment env = InternalSettingsPreparer.prepareEnvironment(nodeSettings, emptyMap(), null, () -> {
    protected static final String INT_FIELD_NAME = "mapped_int";
                            + "\":{\"type\":\"date\"},\""
            .put("node.name", AbstractQueryTestCase.class.toString())
            namedWriteableRegistry = new NamedWriteableRegistry(entries);
        INT_FIELD_NAME,
                    listener.onResponse(getResponse);
                @Override
            } else if (method.equals(Object.class.getMethod("toString"))) {
                            "type=integer",
import java.util.List;
                            GEO_POINT_FIELD_NAME,
    private static ServiceHolder serviceHolderWithNoType;
                searcher,
                            "type=object",
    public static void beforeClass() {
                indexNameMatcher(),
                            KEYWORD_FIELD_NAME,
                this.client,
                            "type=alias,path=" + GEO_POINT_FIELD_NAME,
    protected static QueryShardContext createShardContext() {
        // we have to prefer CURRENT since with the range of versions we support it's rather unlikely to get the current actually.
        TEXT_FIELD_NAME,
            this.nowInMillis = nowInMillis;

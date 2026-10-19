import static java.util.Collections.emptyMap;
                            "type=date",
    protected static final String DOUBLE_FIELD_NAME = "mapped_double";
                idxSettings,  
        private final long nowInMillis;
    private static class ClientInvocationHandler implements InvocationHandler {
                            "type=keyword",
     */
                    @Override  
import java.util.concurrent.TimeUnit;
import org.opensearch.plugins.Plugin;  
     * Override this to handle {@link Client#get(GetRequest)} calls from parsers / builders
                            BOOLEAN_FIELD_NAME,  
                similarityService,
    protected static final String DATE_NANOS_FIELD_NAME = "mapped_date_nanos";
import org.opensearch.threadpool.ThreadPool;  
    }
    }
            MapperRegistry mapperRegistry = indicesModule.getMapperRegistry();
     */  
        BOOLEAN_FIELD_NAME,  
                    @Override
                () -> true,
    }
    protected static QueryShardContext createShardContextWithNoType() {
    }  
                searcher,
import static java.util.stream.Collectors.toList;
import org.opensearch.common.util.io.IOUtils;  
        return createShardContext(null);  
        TEXT_FIELD_NAME,
                    "_doc",
                return "MockClient";  
                    ),
public abstract class AbstractBuilderTestCase extends OpenSearchTestCase {  
        DATE_NANOS_FIELD_NAME,
                            GEO_POINT_FIELD_NAME,  
    protected static QueryBuilderVisitor createTestVisitor(List<QueryBuilder> visitedQueries) {  
            IndexAnalyzers indexAnalyzers = analysisModule.getAnalysisRegistry().build(idxSettings);
    protected static final String[] MAPPED_LEAF_FIELD_NAMES = new String[] {
 * The OpenSearch Contributors require contributions made to  
     * Override this to handle {@link Client#get(GetRequest)} calls from parsers / builders  
                    AbstractBuilderTestCase.this,  
 * GitHub history for details.
import org.opensearch.common.regex.Regex;
 */
 */  
            SettingsModule settingsModule = new SettingsModule(
        }
import org.opensearch.plugins.SearchPlugin;  
    protected static final String GEO_SHAPE_FIELD_NAME = "mapped_geo_shape";
            );
                Stream.of(searchModule.getNamedXContents().stream()).flatMap(Function.identity()).collect(toList())
     * @return a new {@link QueryShardContext} with the provided searcher
import org.opensearch.core.action.ActionListener;
        DATE_FIELD_NAME,
                if (randomBoolean()) {
            mapperService = new MapperService(
            IndicesFieldDataCache indicesFieldDataCache = new IndicesFieldDataCache(nodeSettings, new IndexFieldDataCache.Listener() {  
import org.opensearch.index.fielddata.IndexFieldDataCache;  
                new NoneCircuitBreakerService(),  
            scriptService = new MockScriptService(Settings.EMPTY, scriptModule.engines, scriptModule.contexts);
import org.opensearch.indices.IndicesBitsetFilterCache;
                            + "\":{\"type\":\"date\"},\""
import org.opensearch.index.mapper.MapperService;  
                            DOUBLE_FIELD_NAME,
            public void accept(QueryBuilder qb) {  
                            "type=date_range",  
                nodeSettings,
import org.opensearch.plugins.PluginsService;
        AbstractBuilderTestCase delegate;  
            client = (Client) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[] { Client.class }, clientInvocationHandler);
import org.opensearch.index.IndexSettings;  
            Environment env = InternalSettingsPreparer.prepareEnvironment(nodeSettings, emptyMap(), null, () -> {
import java.util.function.Predicate;
    @SuppressWarnings("deprecation") // dependencies in server for geo_shape field should be decoupled
        ServiceHolder(
            return new QueryShardContext(
            assert serviceHolderWithNoType == null;  
                return null;  
        }
import java.lang.reflect.InvocationHandler;  
                this.client,  
            if (scriptPlugins == null || scriptPlugins.isEmpty()) {
import org.opensearch.core.index.Index;  
                @Override
        serviceHolderWithNoType.clientInvocationHandler.delegate = null;
    protected static final String KEYWORD_FIELD_NAME = "mapped_string_2";
            );
    }
        public void close() throws IOException {
    }
            indicesBitsetFilterCache.close();  
        }  
    protected NamedWriteableRegistry namedWriteableRegistry() {
        ) throws IOException {
                @Override  
                }
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
                    false  
                    AbstractBuilderTestCase.this,
        serviceHolderWithNoType.clientInvocationHandler.delegate = this;
                    threadPool
        TEXT_FIELD_NAME,  
import org.apache.lucene.util.Accountable;  
import org.opensearch.action.termvectors.MultiTermVectorsResponse;
            if (method.equals(Client.class.getMethod("get", GetRequest.class, ActionListener.class))) {
            idxSettings = IndexSettingsModule.newIndexSettings(index, indexSettings, indexScopedSettings);
            pluginsService = new PluginsService(nodeSettings, env.modulesDir(), env.pluginsDir(), plugins);
                indexFieldDataService::getForField,  
            );  
import org.opensearch.index.fielddata.IndexFieldDataService;
 * KIND, either express or implied.  See the License for the
import org.opensearch.plugins.MapperPlugin;
        return serviceHolder.createShardContext(searcher);
import org.junit.BeforeClass;
    @BeforeClass  
        private final BitsetFilterCache bitsetFilterCache;
        TEXT_ALIAS_FIELD_NAME,
                            INT_FIELD_NAME,
import org.opensearch.cluster.service.ClusterService;  
    protected static final String INT_ALIAS_FIELD_NAME = "mapped_int_field_alias";  
                return new ScriptModule(Settings.EMPTY, singletonList(new ScriptPlugin() {  
                        return new MockScriptEngine(MockScriptEngine.NAME, Collections.singletonMap("1", script -> "1"), emptyMap());  
                new ClusterService(
/*  
import java.util.concurrent.ExecutionException;
        return queryName;  
            }
        private final NamedXContentRegistry xContentRegistry;
                            KEYWORD_FIELD_NAME,  
                BigArrays.NON_RECYCLING_INSTANCE,
        private final IndexFieldDataService indexFieldDataService;
import java.util.Collection;
        throw new UnsupportedOperationException("this test can't handle MultiTermVector requests");  
            namedWriteableRegistry = new NamedWriteableRegistry(entries);  
import org.opensearch.script.ScriptContext;  
                            + DATE_FIELD_NAME  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.node.InternalSettingsPreparer;
                            "type=alias,path=" + DATE_FIELD_NAME,
        return serviceHolder.namedWriteableRegistry;  
            List<Setting<?>> additionalSettings = pluginsService.getPluginSettings();  
                            DATE_NANOS_FIELD_NAME,
                xContentRegistry,
     */  
                    ),
 *
    protected MultiTermVectorsResponse executeMultiTermVectors(MultiTermVectorsRequest mtvRequest) {
    /**
 * license agreements. See the NOTICE file distributed with
    protected static final String DATE_ALIAS_FIELD_NAME = "mapped_date_alias";  
 * this work for additional information regarding copyright
            RandomizedTest.getContext().runWithPrivateRandomness(clusterManagerSeed, (Callable<Void>) () -> {  
                scriptService,  
        private final SearchModule searchModule;  
        serviceHolderWithNoType = null;  
                            "type=date_nanos",  
import org.opensearch.common.util.BigArrays;
    protected static final String BOOLEAN_FIELD_NAME = "mapped_boolean";  
                            "type=text",
            },
import org.opensearch.script.ScriptService;  
                    getPlugins(),  
        private final IndicesBitsetFilterCache indicesBitsetFilterCache;
    }
 * not use this file except in compliance with the License.
            );  
    }
import org.opensearch.core.index.shard.ShardId;
    protected static final String GEO_POINT_ALIAS_FIELD_NAME = "mapped_geo_point_alias";
                testCase.initializeAdditionalMappings(mapperService);
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
                public void onRemoval(ShardId shardId, Accountable accountable) {  
import org.opensearch.cluster.metadata.IndexMetadata;
            long clusterManagerSeed = SeedUtils.parseSeed(RandomizedTest.getContext().getRunnerSeedAsString());
                return new PlainActionFuture<MultiTermVectorsResponse>() {
        return serviceHolder.idxSettings;
            entries.addAll(indicesModule.getNamedWriteables());
import org.opensearch.script.MockScriptEngine;
    private static ThreadPool threadPool;
                    MapperService.MergeReason.MAPPING_UPDATE
        INT_RANGE_FIELD_NAME,  
            // calls to the randomness source during its setup. In order to not mix these calls with
        return serviceHolder.xContentRegistry;
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
import org.opensearch.env.Environment;
            // Simplistic index name matcher used for testing  
import org.junit.AfterClass;  
     * @return a new {@link QueryShardContext} based on an index with no type registered
        DATE_NANOS_FIELD_NAME,  
 *     http://www.apache.org/licenses/LICENSE-2.0
                ActionListener<GetResponse> listener = (ActionListener<GetResponse>) args[1];  
        }
            }
                indexAnalyzers,
import org.opensearch.common.settings.SettingsModule;
import org.junit.After;
        INT_FIELD_NAME,
                null  
    private static Settings nodeSettings;
import static java.util.Collections.emptyList;
        IOUtils.close(serviceHolder);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            ScriptModule scriptModule = createScriptModule(pluginsService.filterPlugins(ScriptPlugin.class));
        DOUBLE_FIELD_NAME,
            Settings indexSettings,  
                };
                            DATE_FIELD_NAME,
        @Override
        ThreadPool.terminate(threadPool, 1, TimeUnit.MINUTES);
     * @return a new {@link QueryShardContext} based on the base test index and queryParserService  
            entries.addAll(searchModule.getNamedWriteables());
                }
import java.lang.reflect.Method;
            });  
        // we have to prefer CURRENT since with the range of versions we support it's rather unlikely to get the current actually.
                    new CompressedXContent(
import org.opensearch.env.TestEnvironment;
                mapperService.merge(
package org.opensearch.test;
 *  
                () -> false,  
                            GEO_POINT_ALIAS_FIELD_NAME,
    /**  
            // this setup
        private final NamedWriteableRegistry namedWriteableRegistry;
import org.opensearch.action.get.GetRequest;  
        ALIAS_TO_CONCRETE_FIELD_NAME.put(TEXT_ALIAS_FIELD_NAME, TEXT_FIELD_NAME);
            xContentRegistry = new NamedXContentRegistry(
 * software distributed under the License is distributed on an
        GEO_POINT_FIELD_NAME,
        QueryShardContext createShardContext(IndexSearcher searcher) {  
                        return delegate.executeMultiTermVectors((MultiTermVectorsRequest) args[0]);
        ALIAS_TO_CONCRETE_FIELD_NAME.put(GEO_POINT_ALIAS_FIELD_NAME, GEO_POINT_FIELD_NAME);
                            + "\":{\"type\":\"object\","
            indexFieldDataService = new IndexFieldDataService(  
    protected static final String OBJECT_FIELD_NAME = "mapped_object";
    }  
                GetResponse getResponse = delegate.executeGet((GetRequest) args[0]);
                    true
    protected static final String GEO_POINT_FIELD_NAME = "mapped_geo_point";  
import org.opensearch.plugins.ScriptPlugin;
            // the randomness source that is later used in the test method, we use the cluster-manager seed during  
import com.carrotsearch.randomizedtesting.RandomizedTest;
        DATE_FIELD_NAME,
        private final ClientInvocationHandler clientInvocationHandler = new ClientInvocationHandler();  
                Collections.emptySet()
            }  
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {  
                serviceHolder = new ServiceHolder(
 * ownership. Elasticsearch licenses this file to you under  
        serviceHolder.clientInvocationHandler.delegate = null;  
                }  
    protected static Index getIndex() {
    }
                visitedQueries.add(qb);
import java.util.stream.Stream;
import org.opensearch.action.termvectors.MultiTermVectorsRequest;  
                            OBJECT_FIELD_NAME,
            );  
                pluginsService.getPluginSettingsFilter(),
        ScriptModule createScriptModule(List<ScriptPlugin> scriptPlugins) {
                            DATE_RANGE_FIELD_NAME,
                    createTestIndexSettings(),
        throw new UnsupportedOperationException("this test can't handle GET requests");
                () -> createShardContext(null),
    protected Collection<Class<? extends Plugin>> getPlugins() {  
                        "{\"properties\":{\""
            if (registerType) {
                            TEXT_ALIAS_FIELD_NAME,
                            INT_ALIAS_FIELD_NAME,  
        serviceHolder = null;
    protected static QueryShardContext createShardContext(IndexSearcher searcher) {  
import org.apache.lucene.search.BooleanClause;
import java.util.HashMap;  
                    nowInMillis,
 * under the License.  
                    new CompressedXContent(
                mapperRegistry,
                    nodeSettings,
import org.opensearch.common.settings.Setting;
import org.opensearch.indices.IndicesModule;  
    }
        ALIAS_TO_CONCRETE_FIELD_NAME.put(DATE_ALIAS_FIELD_NAME, DATE_FIELD_NAME);
        return Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, indexVersionCreated).build();  
import org.opensearch.index.analysis.IndexAnalyzers;
                        PutMappingRequest.simpleMapping(  
                    public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
                    "_doc",  
import org.opensearch.index.query.QueryBuilderVisitor;
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                serviceHolderWithNoType = new ServiceHolder(  
    protected static final String DATE_RANGE_FIELD_NAME = "mapped_date_range";
        nodeSettings = Settings.builder()
        @Override
                idxSettings,
import org.opensearch.index.similarity.SimilarityService;
                null
            });  
            );
                    }  
    /**
 * SPDX-License-Identifier: Apache-2.0
        private final IndexSettings idxSettings;
        };
                ),  
            .build();
                );
import java.util.concurrent.Callable;  
            public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {
    }  
            }
                );  
                threadPool
    public static void beforeClass() {
import java.util.Map;
                            "type=integer",
                );
import org.opensearch.script.ScriptEngine;
                null,  
    @Override  
    }
    private static final Map<String, String> ALIAS_TO_CONCRETE_FIELD_NAME = new HashMap<>();  
                            "type=alias,path=" + GEO_POINT_FIELD_NAME,  
        return ALIAS_TO_CONCRETE_FIELD_NAME.getOrDefault(builderFieldName, builderFieldName);
    /**
import org.opensearch.index.cache.bitset.BitsetFilterCache;
                    new Thread(() -> listener.onResponse(getResponse)).start();
                return this;  
    protected static final String INT_RANGE_FIELD_NAME = "mapped_int_range";
     * make sure query names are unique by suffixing them with increasing counter
import org.opensearch.Version;
    /**  
                threadPool
        GEO_SHAPE_FIELD_NAME };
    public void beforeTest() throws Exception {
                indicesFieldDataCache,
import java.util.function.Function;  
            searchModule = new SearchModule(nodeSettings, pluginsService.filterPlugins(SearchPlugin.class));
                    listener.onResponse(getResponse);
        DATE_RANGE_FIELD_NAME,  
import java.io.IOException;
                similarityService,  
    public static final String TEXT_FIELD_NAME = "mapped_string";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    getPlugins(),
                            "type=geo_point",
                throw new AssertionError("node.name must be set");
                            "type=geo_shape"
    protected GetResponse executeGet(GetRequest getRequest) {
        String queryName = randomAlphaOfLengthBetween(1, 10) + queryNameId;
    private static class ServiceHolder implements Closeable {
    }  
            AnalysisModule analysisModule = new AnalysisModule(TestEnvironment.newEnvironment(nodeSettings), emptyList());  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            bitsetFilterCache = new BitsetFilterCache(idxSettings, indicesBitsetFilterCache, new BitsetFilterCache.Listener() {
    private static long nowInMillis;
import org.apache.lucene.search.IndexSearcher;
                            + "\"properties\":{\""
        Version indexVersionCreated = randomBoolean() ? Version.CURRENT : VersionUtils.randomIndexCompatibleVersion(random());
            // we initialize the serviceHolder and serviceHolderWithNoType just once, but need some
        return index;
import org.opensearch.common.settings.ClusterSettings;  
                            TEXT_FIELD_NAME,
import org.opensearch.transport.client.Client;
                    MapperService.MergeReason.MAPPING_UPDATE
import org.opensearch.index.mapper.MappedFieldType;
    protected static IndexSettings indexSettings() {  
import org.opensearch.threadpool.TestThreadPool;
import org.junit.Before;
                } else {  
            } else if (method.equals(Object.class.getMethod("toString"))) {
                bitsetFilterCache,
                return null;
                additionalSettings,  
import org.opensearch.index.query.QueryBuilder;
        return serviceHolderWithNoType.createShardContext(null);
    }
            boolean registerType
            } else if (method.equals(Client.class.getMethod("multiTermVectors", MultiTermVectorsRequest.class))) {
        IOUtils.close(serviceHolderWithNoType);  
                0,
            PluginsService pluginsService;
    protected static String createUniqueRandomName() {  
    }  
                // also add mappings for two inner field in the object field
import org.opensearch.script.MockScriptService;
                        ).toString()  
                );  
import org.opensearch.search.SearchModule;
import org.opensearch.action.get.GetResponse;
 * You may obtain a copy of the License at  
        private final SimilarityService similarityService;
    }  
        BOOLEAN_FIELD_NAME,
import org.opensearch.index.query.QueryShardContext;  
import org.opensearch.script.ScriptModule;
/*  
            AbstractBuilderTestCase testCase,  
import org.opensearch.common.compress.CompressedXContent;
import org.opensearch.action.support.PlainActionFuture;
    public static final String TEXT_ALIAS_FIELD_NAME = "mapped_string_alias";  
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {}
                    public MultiTermVectorsResponse get() throws InterruptedException, ExecutionException {
        INT_RANGE_FIELD_NAME,
        }  
        return new QueryBuilderVisitor() {
import java.lang.reflect.Proxy;
        GEO_POINT_FIELD_NAME,  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.indices.analysis.AnalysisModule;
                    nowInMillis,
/*
        }
        GEO_POINT_ALIAS_FIELD_NAME };
        private final ScriptService scriptService;  
            List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();  
                            "type=double",
                            "type=boolean",
    protected static QueryShardContext createShardContext() {
                mapperService,
            return pattern -> Regex.simpleMatch(pattern, index.getName());
            similarityService = new SimilarityService(idxSettings, null, Collections.emptyMap());  
    protected static final String[] MAPPED_FIELD_NAMES = new String[] {  
    @Before  
 * the Apache License, Version 2.0 (the "License"); you may
        TEXT_ALIAS_FIELD_NAME,
        return serviceHolder.mapperService.fieldTypes();  
                            "type=alias,path=" + TEXT_FIELD_NAME,  
                    nodeSettings,
        }
            this.nowInMillis = nowInMillis;  
    protected static String expectedFieldName(String builderFieldName) {
                            "type=alias,path=" + INT_FIELD_NAME,
            IndicesModule indicesModule = new IndicesModule(pluginsService.filterPlugins(MapperPlugin.class));
}
                idxSettings,  
 * Unless required by applicable law or agreed to in writing,
        private final MapperService mapperService;  
                            + "\":{\"type\":\"integer\"}}}}}"  
     */
                }));
import static java.util.Collections.singletonList;  
    public static void afterClass() throws Exception {
            }
                public void onCache(ShardId shardId, Accountable accountable) {
import org.opensearch.common.settings.IndexScopedSettings;
        private final Client client;
     */
        public static Predicate<String> indexNameMatcher() {
    }
        threadPool = new TestThreadPool("random_threadpool_name");  
                indexNameMatcher(),
        queryNameId++;
    }  
                            + OBJECT_FIELD_NAME  
                mapperService,
                mapperService.merge(  
        serviceHolder.clientInvocationHandler.delegate = this;  
import java.io.Closeable;
                namedWriteableRegistry,
                    }
    protected NamedXContentRegistry xContentRegistry() {
import java.util.ArrayList;  
        nowInMillis = randomNonNegativeLong();
                    createTestIndexSettings(),  
                            "type=object",
 * specific language governing permissions and limitations
    /**
            Settings nodeSettings,
        DATE_RANGE_FIELD_NAME,
    }
                            "type=integer_range",  
            long nowInMillis,
import org.opensearch.indices.mapper.MapperRegistry;  
    }
    protected static final String DATE_FIELD_NAME = "mapped_date";
            });  
        return Collections.singletonList(TestGeoShapeFieldMapperPlugin.class);
                            DATE_ALIAS_FIELD_NAME,  
    protected Iterable<MappedFieldType> getMapping() {
            return new ScriptModule(Settings.EMPTY, scriptPlugins);
    static {
 * this file be licensed under the Apache-2.0 license or a
     */
    @After
import java.util.Collections;
    private static ServiceHolder serviceHolder;
        INT_FIELD_NAME,  
                            INT_RANGE_FIELD_NAME,
    private static int queryNameId = 0;
            Collection<Class<? extends Plugin>> plugins,
    private static Index index;  
        DOUBLE_FIELD_NAME,
            @Override
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
        ALIAS_TO_CONCRETE_FIELD_NAME.put(INT_ALIAS_FIELD_NAME, INT_FIELD_NAME);  
                xContentRegistry,
        OBJECT_FIELD_NAME,
        if (serviceHolder == null) {
            indicesBitsetFilterCache = new IndicesBitsetFilterCache(Settings.EMPTY);
            throw new UnsupportedOperationException("this test can't handle calls to: " + method);
    public void afterTest() {
 * compatible open source license.
    protected Settings createTestIndexSettings() {  
import com.carrotsearch.randomizedtesting.SeedUtils;
    }  
        index = new Index(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLength(10));
import java.util.List;
 */  
                    Settings.EMPTY,  
                () -> nowInMillis,
                            + INT_FIELD_NAME
    protected static final String INT_FIELD_NAME = "mapped_int";
            .put("node.name", AbstractQueryTestCase.class.toString())  
        GEO_POINT_ALIAS_FIELD_NAME,  
            @Override
import org.opensearch.common.settings.Settings;  
    @AfterClass  
                            GEO_SHAPE_FIELD_NAME,
            IndexScopedSettings indexScopedSettings = settingsModule.getIndexScopedSettings();
 *
    private static ServiceHolder serviceHolderWithNoType;  

    }  
    }  
    /**
                        "classpath plugin",
                )
    }
        Node node = NODE;
            throw new RuntimeException(e);  
import org.opensearch.plugins.Plugin;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1b")  
        GetIndexResponse getIndexResponse = client().admin().indices().prepareGetIndex().setIndices(index).get();
import org.opensearch.core.common.Strings;
import org.opensearch.node.NodeValidationException;
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
    public Client wrapClient(final Client client) {  
import org.opensearch.index.IndexService;
     *
        }
        if (mappings != null) {  
        // A subclass getPlugins() may return null; treat that as no test plugins rather than NPEing here.
    }
        }
            null,  
        return featureSettings.build();
            .put(featureFlagSettings);
        // elected itself cluster-manager but might not yet have removed the
            .put(FeatureFlags.TELEMETRY_SETTING.getKey(), true)
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "1b")
            .setSettings(Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000)))
    protected boolean forbidPrivateIndexSettings() {  
    public void tearDown() throws Exception {
import org.opensearch.transport.client.Requests;  
import java.util.concurrent.TimeUnit;
                SandboxStackPlugins.resolve().stream().map(Class::getName).collect(Collectors.toList())
        client().admin()  
        assertThat(health.getStatus(), lessThanOrEqualTo(ClusterHealthStatus.YELLOW));  
     */
}
import org.opensearch.common.settings.Setting;  
    protected <T> T getInstanceFromNode(Class<T> clazz) {
            logger.info(
 *
 * under the License.  
    }  
     * de-duplication precedence, not the classloader parent ordering. Returns a fresh mutable list so callers may add
 * Unless required by applicable law or agreed to in writing,
            .put(NodeEnvironment.NODE_ID_SEED_SETTING.getKey(), random().nextLong())  
 * A test that keep a singleton node started for all tests that can be used to get
        assertAcked(createIndexRequestBuilder.get());  
        LinkedHashSet<Class<? extends Plugin>> all = new LinkedHashSet<>(testPlugins);
        long seed = random().nextLong();
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;  
import org.opensearch.cluster.health.ClusterHealthStatus;  
            .prepareGetIndex()
     * @deprecated types have been removed  
 * not use this file except in compliance with the License.
import org.opensearch.node.MockNode;
import org.opensearch.cluster.metadata.Metadata;
        assertThat("Cluster must be a single node cluster", health.getNumberOfDataNodes(), equalTo(1));
        Metadata metadata = client().admin().cluster().prepareState().get().getState().getMetadata();
    }  
        );
    private static Node NODE = null;  
        return node;
        return true;  
        Node node = new MockNode(
            return new ArrayList<>(testPlugins);  
            .put(TelemetrySettings.TRACER_FEATURE_ENABLED_SETTING.getKey(), true)  
package org.opensearch.test;
     * Create a new index on the singleton node with empty index settings.
     * Get an instance for a particular class using the injector of the singleton node.  
    }
                    .waitForNoRelocatingShards(true)  
    protected IndexService createIndex(String index, CreateIndexRequestBuilder createIndexRequestBuilder) {
            .put(Environment.PATH_SHARED_DATA_SETTING.getKey(), createTempDir().getParent())  
        Collection<Class<? extends Plugin>> testPlugins = getPlugins();  
     * Create a new search context.
        IndicesService instanceFromNode = getInstanceFromNode(IndicesService.class);
        assertThat(
     */
            .put(Node.NODE_NAME_SETTING.getKey(), nodeName)
        // Create the node lazily, on the first test. This is ok because we do not randomize any settings,
        final Settings featureFlagSettings = featureFlagSettings();
            .put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), true)
            // By default, for tests we will put the target slice count of 2. This will increase the probability of having multiple slices
        if (NODE == null) {
            equalTo(0)
import org.opensearch.test.telemetry.MockTelemetryPlugin;
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
    }
    // Set when a node was started with the sandbox feature flags merged into its settings, so tearDownClass can
        if (shouldInstallSandboxStack() == false) {
            plugins.add(getTestTransportPlugin());
     * {@link #getPlugins()} when {@code -Dsandbox.enabled=true} is forwarded into the test fork. Defaults to  
    }
            .actionGet();
    protected IndexService createIndexWithMappingSource(String index, Settings settings, String mappingSource) {  
            .put(nodeSettings()) // allow test cases to provide their own settings or override these
    protected SearchContext createSearchContext(IndexService indexService) {
            // FeatureFlags.initializeFeatureFlags(settings) early, and the loaded plugins (FlightStreamPlugin, the
     * registers a conflicting stream transport, or asserts on node internals the stack changes). This is the intended
    }
                        "1.8",
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            .put("transport.type", getTestTransportType())  
        ClusterHealthResponse health = client().admin()  
            // the seed can be created within this if as it will either be executed before every test method or will never be.
        for (Setting builtInFlag : FeatureFlagSettings.BUILT_IN_FEATURE_FLAGS) {  
    private static volatile boolean sandboxFlagsInjected = false;
import org.opensearch.action.admin.indices.get.GetIndexResponse;  
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
            .health(
    protected IndexService createIndex(String index) {  
import org.opensearch.Version;
    }
 * the Apache License, Version 2.0 (the "License"); you may
        try {  
 * this work for additional information regarding copyright
     * {@link SandboxStackPlugins#isEnabled()} and {@link #installSandboxPlugins()} are both true, the resolved sandbox
            .cluster()
        assertThat(
            .put(dataNode())
    }
            .addIndices("*")
     * Ensures the cluster has a green state via the cluster health API. This method will also wait for relocations.
 *
    @Override  
import java.util.LinkedHashSet;
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 * compatible open source license.
import org.opensearch.script.MockScriptService;
        return false;
        if (actionGet.isTimedOut()) {  
import org.opensearch.node.Node;  
        }
        featureSettings.put(FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING.getKey(), true);
     */
    }
            .setPatterns(Collections.singletonList("*"))
     * after each test. This is useful if the test changes the cluster state metadata etc. The default is
 * Licensed to Elasticsearch under one or more contributor  
                        p.getName(),
    /**
 *  
import org.opensearch.core.index.Index;
    }  
        client().admin()
 * You may obtain a copy of the License at  
        }  
    protected boolean resetNodeAfterTest() {
                        "NA",
        if (node != null && node.awaitClose(10, TimeUnit.SECONDS) == false) {
    protected IndexService createIndexWithSimpleMappings(String index, Settings settings, String... mappings) {
import org.opensearch.common.settings.FeatureFlagSettings;
                    .timeout(timeout)  
        String uuid = getIndexResponse.getSettings().get(index).get(IndexMetadata.SETTING_INDEX_UUID);  
    /**
            .health(
     * so the plugin set and the feature-flag/logging coupling can never diverge. Subclasses may call it from  
        ClusterHealthResponse clusterHealthResponse = client().admin().cluster().prepareHealth().setWaitForGreenStatus().get();  
    /**
            // This needs to tie into the OpenSearchIntegTestCase#indexSettings() method
                "Injecting sandbox engine stack into single-node test node: {}",  
import org.opensearch.test.telemetry.tracing.StrictCheckSpanProcessor;  
    /**
     * <code>false</code>.
                    .waitForEvents(Priority.LANGUID)
import org.opensearch.core.xcontent.XContentBuilder;
                "ensureGreen timed out, cluster state:\n{}\n{}",
        return createIndex(index, createIndexRequestBuilder);
 * license agreements. See the NOTICE file distributed with
     * It is useful to ensure that all action on the cluster have finished and all shards that were currently relocating
import org.opensearch.search.SearchService;
            FeatureFlags.initializeFeatureFlags(Settings.EMPTY);
            assert NODE != null;  
            .cluster()  
        assertThat(actionGet.getStatus(), equalTo(ClusterHealthStatus.GREEN));
import java.util.Collection;
            .put(Environment.PATH_HOME_SETTING.getKey(), tempDir)
     * Whether the sandbox engine stack (resolved by {@link SandboxStackPlugins}) should be loaded on top of
     */  
import org.opensearch.plugins.PluginInfo;  
    private Node newNode() {
    protected boolean addMockHttpTransport() {  
 */  
                client().admin().cluster().preparePendingClusterTasks().get()
 * ownership. Elasticsearch licenses this file to you under  
    protected NamedXContentRegistry xContentRegistry() {
            plugins.add(MockHttpTransport.TestPlugin.class);
    }
        return true;
        BigArrays bigArrays = indexService.getBigArrays();
     * stack. De-duplicated via a {@link LinkedHashSet} with the test's own plugins first; PluginsService still orders  
    /** Additional settings to add when creating the node. Also allows overriding the default settings. */  
            logger.info(
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static void setUpClass() throws Exception {
            featureSettings.put(builtInFlag.getKey(), builtInFlag.getDefaultRaw(Settings.EMPTY));
            plugins = new ArrayList<>(plugins);
import org.opensearch.telemetry.TelemetrySettings;
import static org.opensearch.test.NodeRoles.dataNode;
        return Arrays.asList(plugins);  
                        false
    }
    /** Helper method to create list of plugins without specifying generic types. */
            // turning on the real memory circuit breaker leads to spurious test failures. As have no full control over heap usage, we
            // override installSandboxPlugins() to run without the stack instead.
        }
            stopNode();
    public ClusterHealthStatus ensureGreen(TimeValue timeout, String... indices) {
        final Collection<Class<? extends Plugin>> effectivePlugins = effectiveNodePlugins();
    @Override  
    }
            .actionGet();
                        p.getName(),  
        CreateIndexRequestBuilder createIndexRequestBuilder = client().admin().indices().prepareCreate(index).setSettings(settings);  
        assertAcked(
        CreateIndexRequestBuilder createIndexRequestBuilder = client().admin().indices().prepareCreate(index).setSettings(settings);
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
 * GitHub history for details.
    protected final Collection<Class<? extends Plugin>> pluginList(Class<? extends Plugin>... plugins) {
            // nodeSettings() and the default-valued flags emitted by featureFlagSettings(). The flags must be in the  
        if (mappingSource != null) {
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
        // the seed has to be created regardless of whether it will be used or not, for repeatability  
     * @deprecated types have been removed  
import org.opensearch.common.Priority;
        return new Index(index, uuid);
     * {@code -Dsandbox.enabled=true} ({@link SandboxStackPlugins#isEnabled()}), the test did not opt out  
            // default the watermarks low values to prevent tests from failing on nodes without enough disk space
import org.opensearch.common.util.FeatureFlags;
            forbidPrivateIndexSettings()
        NODE = RandomizedContext.current().runWithPrivateRandomness(seed, this::newNode);
        return instanceFromNode.indexServiceSafe(resolveIndex(index));  
            // data-format plugins) only wire themselves up when their flag is enabled. Feature flags deliberately win  
import org.opensearch.transport.client.Client;
     * IT classes.  
import java.util.ArrayList;  
    }
     * registering a second committer factory).
            .setOrder(0)  
        }  
        return getInstanceFromNode(NamedXContentRegistry.class);  
import org.opensearch.indices.IndicesService;  
import java.util.stream.Collectors;  
        final String nodeName = nodeSettings().get(Node.NODE_NAME_SETTING.getKey(), "node_s_0");  
import org.opensearch.env.NodeEnvironment;  
    // restore the process-wide FeatureFlags singleton those settings mutate (see newNode() and tearDownClass()).  
        stopNode();  
 * references to Guice injectors in unit tests.
        // Wait for the index to be allocated so that cluster state updates don't override
        return createIndexWithSimpleMappings(index, settings, mappings);
        );
import org.opensearch.index.IndexSettings;
            "test leaves transient cluster metadata behind: " + metadata.transientSettings().keySet(),
        // empty settings so a subsequent flag-off suite reusing the same fork does not observe leaked true flags.
 * The OpenSearch Contributors require contributions made to  
     */
            settingsBuilder.put(SandboxStackPlugins.featureFlagSettings());  
            // Enable the sandbox feature flags via node settings LAST, so they win over both a subclass's
        super.tearDown();  
     */  
 * SPDX-License-Identifier: Apache-2.0
     */  
     * Create a new index on the singleton node with the provided index settings.
    protected Settings nodeSettings() {
        return client;
import com.carrotsearch.randomizedtesting.RandomizedContext;  
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.junit.BeforeClass;
        if (sandboxStackInstalled) {
     * The plugins actually loaded on the node: the test's {@link #getPlugins()} plus, when
    /**  
     */
        GetIndexResponse indices = client().admin()  
            "test leaves persistent cluster metadata behind: " + metadata.persistentSettings().keySet(),  
     * {@code true}. Override to return {@code false} only when a test genuinely cannot run with the stack (e.g. it
        }  
     * ({@link #installSandboxPlugins()}), and the plugin classes actually resolved on the test classpath
    /** The plugin classes that should be added to the node. */
    /**
     * Return a reference to the singleton node.
        if (plugins.contains(getTestTransportPlugin()) == false) {  
            .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), InternalTestCluster.clusterName("single-node-cluster", random().nextLong()))
        logger.trace("[{}#{}]: cleaning up after test", getTestClass().getSimpleName(), getTestName());
                        Version.CURRENT,  
    }
     */  
/**  
            sandboxFlagsInjected = false;  
    @SuppressWarnings("varargs") // due to type erasure, the varargs type is non-reifiable, which causes this warning
        }
import org.opensearch.cluster.metadata.IndexMetadata;
        );  
     * Single source of truth for whether the resolved sandbox stack is installed on the node: the build forwarded
 */  
     * the framework's mock transport/script/telemetry plugins.  
 * specific language governing permissions and limitations
    }
        }
    /**  
     */  
            client().admin().indices().prepareDelete("*").setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN_CLOSED_HIDDEN).get()
    /**
                        null,  
    }
    }
        }  
    protected Collection<Class<? extends Plugin>> getPlugins() {  
    /** True if a dummy http transport should be used, or false if the real http transport should be used. */
            .preparePutTemplate("one_shard_index_template")
     * Create a new index on the singleton node with the provided index settings.
    public ClusterHealthStatus ensureGreen(String... indices) {
    @Override
        return createIndex(index, Settings.EMPTY);
    protected boolean installSandboxPlugins() {
     * Ensures the cluster has a green state via the cluster health API. This method will also wait for relocations.
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT_KEY, 2)  
    protected IndexService createIndex(String index, Settings settings) {
    protected IndexService createIndex(String index, Settings settings, String type, String... mappings) {  
            assertThat("timed out waiting for green state", actionGet.isTimedOut(), equalTo(false));  
import java.util.Arrays;
            .get();  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "1b")
    public void setUp() throws Exception {
            );
        assertTrue("index " + index + " not found", getIndexResponse.getSettings().containsKey(index));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new TestSearchContext(bigArrays, indexService);  
        assertThat(  
            .preparePutTemplate("random-soft-deletes-template")
    @Deprecated
     * {@link #getPlugins()} to vary their own plugin list depending on whether the stack is installed (e.g. to avoid
    }
        // The sandbox feature flags we merge into node settings mutate the process-wide FeatureFlags singleton via  
    }  
        }
    protected IndexService createIndex(String index, Settings settings, String type, XContentBuilder mappings) {  
 */
            testPlugins = Collections.emptyList();  
    /**  
            metadata.transientSettings().size(),  
     */
import java.util.Collections;  
    }
import org.opensearch.common.util.io.IOUtils;  
import org.opensearch.search.internal.SearchContext;  
            );
            .putList(DISCOVERY_SEED_HOSTS_SETTING.getKey()) // empty list disables a port scan for other nodes
        // not opt out, and the plugin classes are actually on the test classpath.
     * This method returns <code>true</code> if the node that is used in the background should be reset  
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;  
        plugins.add(MockScriptService.TestPlugin.class);
            .get();
                Requests.clusterHealthRequest(indices)
                    p -> new PluginInfo(
    private static void stopNode() throws IOException, InterruptedException {  
            throw new AssertionError("Node couldn't close within 10 seconds.");
    protected Settings featureFlagSettings() {
     * are now allocated and started.  
        if (sandboxFlagsInjected) {
            // this merge (matching the ICT branch) so a test cannot silently disable a flag whose plugin is loaded —
 * software distributed under the License is distributed on an
        all.addAll(SandboxStackPlugins.resolve());  
            startNode(random().nextLong());  
        return createIndex(index, createIndexRequestBuilder);  
     */  
        assertFalse(clusterHealthResponse.isTimedOut());
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                .collect(Collectors.toList()),
            .get();
        logger.debug("indices {} are green", indices.length == 0 ? "[_all]" : indices);  
            // settings before PluginsService starts the loaded plugins: Node's constructor calls
    @BeforeClass
    /**  
        Settings.Builder settingsBuilder = Settings.builder()  
        if (mappings != null) {
            .put(TransportSettings.PORT.getKey(), getPortRange())
            )
        assert NODE == null;
 * KIND, either express or implied.  See the License for the
     */
        stopNode();
        return SandboxStackPlugins.isEnabled() && installSandboxPlugins() && SandboxStackPlugins.resolve().isEmpty() == false;
        return NODE;
        NODE = null;
     */
    }
    protected final boolean shouldInstallSandboxStack() {
     * Creates an index with mappings provided in the format expected by {@link org.opensearch.action.admin.indices.create.CreateIndexRequest#simpleMapping(String...)}
    protected final Collection<Class<? extends Plugin>> effectiveNodePlugins() {
        Collection<Class<? extends Plugin>> plugins = effectivePlugins;
        return Settings.EMPTY;
        // we must wait for the node to actually be up and running. otherwise the node might have started,  
    /**
        return createIndex(index, createIndexRequestBuilder);
        if (addMockHttpTransport()) {
        } catch (NodeValidationException e) {
        plugins.add(MockTelemetryPlugin.class);  
    }  
                client().admin().cluster().prepareState().get().getState(),  
        );
import static org.hamcrest.Matchers.equalTo;  
        CreateIndexRequestBuilder createIndexRequestBuilder = client().admin().indices().prepareCreate(index).setSettings(settings);
     * @param timeout time out value to set on {@link ClusterHealthRequest}
    public Index resolveIndex(String index) {  
        if (resetNodeAfterTest()) {
    }
     * @return Feature flag settings.
            equalTo(0)
 * this file be licensed under the Apache-2.0 license or a
            startNode(seed);
    /**
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;  
    /**
            .put(Environment.PATH_REPO_SETTING.getKey(), tempDir.resolve("repo"))  
     * are now allocated and started.  
        final boolean sandboxStackInstalled = shouldInstallSandboxStack();  
        return new ArrayList<>(all);
            plugins.stream()  
            .setOrder(0)
            // when tests are run with concurrent segment search enabled
     * Returns a client to the single-node cluster.  
    @AfterClass  
        // Node -> FeatureFlags.initializeFeatureFlags(settings), and that state survives node stop. Re-initialise from
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            sandboxFlagsInjected = true;
     * ({@link SandboxStackPlugins#resolve()} non-empty). Shared by {@link #effectiveNodePlugins()} and {@link #newNode()}
        ClusterHealthResponse actionGet = client().admin()
    @SafeVarargs  
 */
        return wrapClient(NODE.client());  
import org.junit.AfterClass;
        StrictCheckSpanProcessor.validateTracingStateOnShutdown();
        Settings.Builder featureSettings = Settings.builder();
        // changes that would have been done locally
    /**
    /**  
        // plugin presence: the stack is installed only when the build forwarded -Dsandbox.enabled=true, the test did  
    protected void startNode(long seed) throws Exception {  
     * Create a new index on the singleton node with the provided index settings and mappings.  
        return createIndex(index, settings, mappings);
    }
import org.opensearch.cluster.ClusterName;
        return NODE.injector().getInstance(clazz);  
     */  
        return createIndex(index, settings, null);
import java.io.IOException;
        // SERVICE_UNAVAILABLE/1/state not recovered / initialized block
     * plugins by their {@code extendedPlugins} declarations at load time, so this insertion order only controls
                .map(
    public Client client() {
            .setPatterns(Collections.singletonList("*"))  
            settingsBuilder.build(),
        // only the cluster name. This allows us to have overridden properties for plugins and the version to use.  
        // FlagWriteLock-locked flags are skipped by initializeFeatureFlags, so @LockFeatureFlag tests are unaffected.  
     */
    /**
     * Create a new index on the singleton node with the provided index settings.
    @Deprecated
        IOUtils.close(node);  
/*
     * It is useful to ensure that all action on the cluster have finished and all shards that were currently relocating
 * Modifications Copyright OpenSearch Contributors. See  
                    )  
import java.nio.file.Path;
import org.opensearch.common.settings.Settings;
        if (testPlugins == null) {
        }
import org.opensearch.common.unit.TimeValue;
/*  
            .indices()
            // TODO: use a consistent data path for custom paths
                        Collections.emptyList(),
        // Resolve the plugins actually loaded on the node up front so we can couple the sandbox feature flags to
        return Collections.emptyList();
/*
            node.start();
            "test leaves indices that were not deleted: " + Strings.arrayToCommaDelimitedString(indices.indices()),
import org.opensearch.action.support.IndicesOptions;
            indices.indices(),
                Requests.clusterHealthRequest(index).waitForYellowStatus().waitForEvents(Priority.LANGUID).waitForNoRelocatingShards(true)  
            metadata.persistentSettings().size(),
     */
        featureSettings.put(FeatureFlags.TELEMETRY_SETTING.getKey(), true);  
    protected IndexService createIndex(String index, Settings settings, XContentBuilder mappings) {
                    .waitForGreenStatus()
    /**
            .indices()
            createIndexRequestBuilder.setMapping(mappingSource);  
        super.setUp();
            )
        final Path tempDir = createTempDir();
            .setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN_CLOSED_HIDDEN)  
        }  
            equalTo(Strings.EMPTY_ARRAY)  
     * Setting all feature flag settings at base IT, which can be overridden later by individual
public abstract class OpenSearchSingleNodeTestCase extends OpenSearchTestCase {
        return actionGet.getStatus();
     *
            .put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 1) // limit the number of threads created
    }  
        }
            createIndexRequestBuilder.setMapping(mappings);
import org.opensearch.transport.TransportSettings;
import org.opensearch.common.util.BigArrays;  
            createIndexRequestBuilder.setMapping(mappings);
     */  
            .indices()  
    }
     * opt-out — overriding {@link #getPlugins()} alone does not remove the stack.  
    }  
import org.opensearch.env.Environment;
    }
    protected Node node() {
            // turn it off for these tests.  
            .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), nodeName)  
        );  
        }  
    }
        return ensureGreen(TimeValue.timeValueSeconds(30), indices);  
        return true;
     * Create a new index on the singleton node with the provided index settings and mappings source.
    public static void tearDownClass() throws Exception {

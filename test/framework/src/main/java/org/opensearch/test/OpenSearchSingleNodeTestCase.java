        assertThat(
     * <code>false</code>.
/*
                        "NA",
     * the framework's mock transport/script/telemetry plugins.
     * Setting all feature flag settings at base IT, which can be overridden later by individual
     */
    public ClusterHealthStatus ensureGreen(TimeValue timeout, String... indices) {
        // FlagWriteLock-locked flags are skipped by initializeFeatureFlags, so @LockFeatureFlag tests are unaffected.
     * ({@link SandboxStackPlugins#resolve()} non-empty). Shared by {@link #effectiveNodePlugins()} and {@link #newNode()}
import org.junit.BeforeClass;
    @AfterClass
    }
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
     */
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        return true;
/*
        StrictCheckSpanProcessor.validateTracingStateOnShutdown();
import org.opensearch.test.telemetry.MockTelemetryPlugin;
            startNode(random().nextLong());
            .put(Environment.PATH_HOME_SETTING.getKey(), tempDir)
        IndicesService instanceFromNode = getInstanceFromNode(IndicesService.class);
import org.opensearch.common.util.FeatureFlags;
import java.util.LinkedHashSet;
                "ensureGreen timed out, cluster state:\n{}\n{}",
            .put(dataNode())
        if (addMockHttpTransport()) {
    }
        // only the cluster name. This allows us to have overridden properties for plugins and the version to use.
import org.opensearch.cluster.metadata.IndexMetadata;
import org.junit.AfterClass;
 */
        CreateIndexRequestBuilder createIndexRequestBuilder = client().admin().indices().prepareCreate(index).setSettings(settings);
    /**
    }
        }
            equalTo(Strings.EMPTY_ARRAY)
     *
/**
            featureSettings.put(builtInFlag.getKey(), builtInFlag.getDefaultRaw(Settings.EMPTY));
     * are now allocated and started.
        return node;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1b")
        super.tearDown();
    protected <T> T getInstanceFromNode(Class<T> clazz) {
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT_KEY, 2)
     */
            .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), nodeName)
            startNode(seed);
    }
     * Create a new index on the singleton node with the provided index settings and mappings.
     * {@link #getPlugins()} when {@code -Dsandbox.enabled=true} is forwarded into the test fork. Defaults to
 * compatible open source license.
    @Override
     * @return Feature flag settings.
        // the seed has to be created regardless of whether it will be used or not, for repeatability
     * {@code -Dsandbox.enabled=true} ({@link SandboxStackPlugins#isEnabled()}), the test did not opt out
            // the seed can be created within this if as it will either be executed before every test method or will never be.
            createIndexRequestBuilder.setMapping(mappingSource);
        featureSettings.put(FeatureFlags.TELEMETRY_SETTING.getKey(), true);
        GetIndexResponse indices = client().admin()
import org.opensearch.core.common.Strings;
        // elected itself cluster-manager but might not yet have removed the
}
 * specific language governing permissions and limitations
        logger.debug("indices {} are green", indices.length == 0 ? "[_all]" : indices);
        return wrapClient(NODE.client());
            // data-format plugins) only wire themselves up when their flag is enabled. Feature flags deliberately win
        final Path tempDir = createTempDir();
                    .waitForEvents(Priority.LANGUID)
     */
            .setOrder(0)
        if (testPlugins == null) {
 * Modifications Copyright OpenSearch Contributors. See
                .map(
            .actionGet();
            .put(FeatureFlags.TELEMETRY_SETTING.getKey(), true)
import org.opensearch.plugins.PluginInfo;
    }
    protected final Collection<Class<? extends Plugin>> effectiveNodePlugins() {
    /**
     */
    }
        return new TestSearchContext(bigArrays, indexService);
     * The plugins actually loaded on the node: the test's {@link #getPlugins()} plus, when
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
     * Return a reference to the singleton node.
        assertThat(health.getStatus(), lessThanOrEqualTo(ClusterHealthStatus.YELLOW));
                        p.getName(),
    /**
     * {@code true}. Override to return {@code false} only when a test genuinely cannot run with the stack (e.g. it
        }
     * Create a new index on the singleton node with the provided index settings.
        return Arrays.asList(plugins);
 * KIND, either express or implied.  See the License for the
            throw new RuntimeException(e);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "1b")
    /**
            equalTo(0)
        }
        }
    }
 * license agreements. See the NOTICE file distributed with
    /** Helper method to create list of plugins without specifying generic types. */
 * the Apache License, Version 2.0 (the "License"); you may
        ClusterHealthResponse health = client().admin()
    @Deprecated
    @SuppressWarnings("varargs") // due to type erasure, the varargs type is non-reifiable, which causes this warning
            .prepareGetIndex()
    /** True if a dummy http transport should be used, or false if the real http transport should be used. */
        return false;
import org.opensearch.search.internal.SearchContext;
                "Injecting sandbox engine stack into single-node test node: {}",
    protected IndexService createIndexWithSimpleMappings(String index, Settings settings, String... mappings) {
    protected boolean resetNodeAfterTest() {
     * @deprecated types have been removed
            .indices()
            .put(Node.NODE_NAME_SETTING.getKey(), nodeName)
            .put(TelemetrySettings.TRACER_FEATURE_ENABLED_SETTING.getKey(), true)
                )
     */
import org.opensearch.search.SearchService;
        // not opt out, and the plugin classes are actually on the test classpath.
     * Ensures the cluster has a green state via the cluster health API. This method will also wait for relocations.
    // Set when a node was started with the sandbox feature flags merged into its settings, so tearDownClass can
        return SandboxStackPlugins.isEnabled() && installSandboxPlugins() && SandboxStackPlugins.resolve().isEmpty() == false;
    /**
    /**
import org.opensearch.script.MockScriptService;
    /**
        // The sandbox feature flags we merge into node settings mutate the process-wide FeatureFlags singleton via
        } catch (NodeValidationException e) {
import org.opensearch.transport.client.Requests;
            .put(TransportSettings.PORT.getKey(), getPortRange())
            plugins.stream()
            assertThat("timed out waiting for green state", actionGet.isTimedOut(), equalTo(false));
            // FeatureFlags.initializeFeatureFlags(settings) early, and the loaded plugins (FlightStreamPlugin, the
        IOUtils.close(node);
            plugins = new ArrayList<>(plugins);
            );
import static org.hamcrest.Matchers.lessThanOrEqualTo;
 */
            )
import com.carrotsearch.randomizedtesting.RandomizedContext;
            .put(NodeEnvironment.NODE_ID_SEED_SETTING.getKey(), random().nextLong())
    protected Settings nodeSettings() {
            .put(featureFlagSettings);
     * Creates an index with mappings provided in the format expected by {@link org.opensearch.action.admin.indices.create.CreateIndexRequest#simpleMapping(String...)}
            // turn it off for these tests.
                    )
            );
    }
    }
    }
                        p.getName(),
        final Settings featureFlagSettings = featureFlagSettings();
    protected final Collection<Class<? extends Plugin>> pluginList(Class<? extends Plugin>... plugins) {
 *
    @Override
            .cluster()
     * are now allocated and started.
 * A test that keep a singleton node started for all tests that can be used to get
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
    public void setUp() throws Exception {
        return new Index(index, uuid);
     */
        return true;
    private static volatile boolean sandboxFlagsInjected = false;
                client().admin().cluster().preparePendingClusterTasks().get()
        // Node -> FeatureFlags.initializeFeatureFlags(settings), and that state survives node stop. Re-initialise from
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        // Resolve the plugins actually loaded on the node up front so we can couple the sandbox feature flags to
    @SafeVarargs
     */
            metadata.transientSettings().size(),
        Node node = NODE;
        if (mappingSource != null) {
        // empty settings so a subsequent flag-off suite reusing the same fork does not observe leaked true flags.
        GetIndexResponse getIndexResponse = client().admin().indices().prepareGetIndex().setIndices(index).get();
    /**
 * GitHub history for details.
    protected IndexService createIndexWithMappingSource(String index, Settings settings, String mappingSource) {
                        "1.8",
import org.opensearch.transport.client.Client;
 * not use this file except in compliance with the License.
        }
            "test leaves persistent cluster metadata behind: " + metadata.persistentSettings().keySet(),
     */
                client().admin().cluster().prepareState().get().getState(),
    }
            createIndexRequestBuilder.setMapping(mappings);
    }
            logger.info(
                Requests.clusterHealthRequest(indices)
                        Version.CURRENT,
        Metadata metadata = client().admin().cluster().prepareState().get().getState().getMetadata();
        return new ArrayList<>(all);
     * Create a new search context.
     */
        for (Setting builtInFlag : FeatureFlagSettings.BUILT_IN_FEATURE_FLAGS) {
        long seed = random().nextLong();
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
import org.opensearch.core.xcontent.XContentBuilder;
     * It is useful to ensure that all action on the cluster have finished and all shards that were currently relocating
    public Client wrapClient(final Client client) {
    private static Node NODE = null;
     */
            .indices()
        return createIndexWithSimpleMappings(index, settings, mappings);
        );
            metadata.persistentSettings().size(),
     * Create a new index on the singleton node with the provided index settings.
            .putList(DISCOVERY_SEED_HOSTS_SETTING.getKey()) // empty list disables a port scan for other nodes
        if (plugins.contains(getTestTransportPlugin()) == false) {
                        "classpath plugin",
            // Enable the sandbox feature flags via node settings LAST, so they win over both a subclass's
                    .waitForNoRelocatingShards(true)
            .cluster()
        }
import org.opensearch.action.admin.indices.get.GetIndexResponse;
    public static void setUpClass() throws Exception {
     * Get an instance for a particular class using the injector of the singleton node.
    /** The plugin classes that should be added to the node. */
            .get();
                Requests.clusterHealthRequest(index).waitForYellowStatus().waitForEvents(Priority.LANGUID).waitForNoRelocatingShards(true)
            // override installSandboxPlugins() to run without the stack instead.
        // plugin presence: the stack is installed only when the build forwarded -Dsandbox.enabled=true, the test did
            stopNode();
            plugins.add(getTestTransportPlugin());
    protected IndexService createIndex(String index, Settings settings, String type, String... mappings) {
        final Collection<Class<? extends Plugin>> effectivePlugins = effectiveNodePlugins();
    /**
    }
     */
    }
            node.start();
                .collect(Collectors.toList()),
    public static void tearDownClass() throws Exception {
import org.opensearch.plugins.Plugin;
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
        if (resetNodeAfterTest()) {
import org.opensearch.common.Priority;
            .preparePutTemplate("one_shard_index_template")
        return createIndex(index, createIndexRequestBuilder);
    /**
        assert NODE == null;
        }
import org.opensearch.common.util.BigArrays;
    /**
import org.opensearch.common.settings.Setting;
    }
            forbidPrivateIndexSettings()
     * plugins by their {@code extendedPlugins} declarations at load time, so this insertion order only controls
        // Wait for the index to be allocated so that cluster state updates don't override
import java.util.Collections;
        ClusterHealthResponse actionGet = client().admin()
        assertThat(actionGet.getStatus(), equalTo(ClusterHealthStatus.GREEN));
     */
    @BeforeClass
        if (sandboxFlagsInjected) {
        return actionGet.getStatus();
            settingsBuilder.put(SandboxStackPlugins.featureFlagSettings());
     */
        // changes that would have been done locally
            null,
     * Create a new index on the singleton node with the provided index settings.
        assertThat(
    @Override
     * after each test. This is useful if the test changes the cluster state metadata etc. The default is
    }
    protected IndexService createIndex(String index) {
            createIndexRequestBuilder.setMapping(mappings);
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
     * ({@link #installSandboxPlugins()}), and the plugin classes actually resolved on the test classpath
            .health(
 * The OpenSearch Contributors require contributions made to
import org.opensearch.transport.TransportSettings;
import org.opensearch.common.unit.TimeValue;
        return createIndex(index, Settings.EMPTY);
            .put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 1) // limit the number of threads created
     * {@link #getPlugins()} to vary their own plugin list depending on whether the stack is installed (e.g. to avoid
            logger.info(
        final boolean sandboxStackInstalled = shouldInstallSandboxStack();
        return getInstanceFromNode(NamedXContentRegistry.class);
            sandboxFlagsInjected = false;
    }
        );
            .actionGet();
    protected NamedXContentRegistry xContentRegistry() {
            sandboxFlagsInjected = true;
            return new ArrayList<>(testPlugins);
        assertTrue("index " + index + " not found", getIndexResponse.getSettings().containsKey(index));
    /**
import java.nio.file.Path;
            "test leaves transient cluster metadata behind: " + metadata.transientSettings().keySet(),
        try {
     * This method returns <code>true</code> if the node that is used in the background should be reset
        return true;
        if (sandboxStackInstalled) {
            .put("transport.type", getTestTransportType())
    protected Settings featureFlagSettings() {
     * Returns a client to the single-node cluster.
        if (NODE == null) {
        return NODE;
        final String nodeName = nodeSettings().get(Node.NODE_NAME_SETTING.getKey(), "node_s_0");
     * {@link SandboxStackPlugins#isEnabled()} and {@link #installSandboxPlugins()} are both true, the resolved sandbox
 *
    /**
        BigArrays bigArrays = indexService.getBigArrays();
 * You may obtain a copy of the License at
        plugins.add(MockTelemetryPlugin.class);
     *
    // restore the process-wide FeatureFlags singleton those settings mutate (see newNode() and tearDownClass()).
    protected boolean addMockHttpTransport() {
        return Settings.EMPTY;
    }
import java.util.Collection;
        assertFalse(clusterHealthResponse.isTimedOut());
 *
        NODE = null;
        Node node = new MockNode(
     */
        if (actionGet.isTimedOut()) {
            // this merge (matching the ICT branch) so a test cannot silently disable a flag whose plugin is loaded —
        if (mappings != null) {
    }
    }
            client().admin().indices().prepareDelete("*").setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN_CLOSED_HIDDEN).get()
import org.opensearch.action.support.IndicesOptions;
     * de-duplication precedence, not the classloader parent ordering. Returns a fresh mutable list so callers may add
     * It is useful to ensure that all action on the cluster have finished and all shards that were currently relocating
    private Node newNode() {
    }
import org.opensearch.env.NodeEnvironment;
import java.io.IOException;
        // we must wait for the node to actually be up and running. otherwise the node might have started,
 *     http://www.apache.org/licenses/LICENSE-2.0
    public Client client() {
            settingsBuilder.build(),
    /**
    public void tearDown() throws Exception {
        Collection<Class<? extends Plugin>> plugins = effectivePlugins;
    }
    protected SearchContext createSearchContext(IndexService indexService) {
import java.util.stream.Collectors;
    protected IndexService createIndex(String index, Settings settings, String type, XContentBuilder mappings) {
    protected IndexService createIndex(String index, CreateIndexRequestBuilder createIndexRequestBuilder) {
        // SERVICE_UNAVAILABLE/1/state not recovered / initialized block
            indices.indices(),
            .put(Environment.PATH_SHARED_DATA_SETTING.getKey(), createTempDir().getParent())
            .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), InternalTestCluster.clusterName("single-node-cluster", random().nextLong()))
    }
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public Index resolveIndex(String index) {
        return createIndex(index, createIndexRequestBuilder);
import org.opensearch.core.index.Index;
            .put(nodeSettings()) // allow test cases to provide their own settings or override these
    protected void startNode(long seed) throws Exception {
        }
     * Whether the sandbox engine stack (resolved by {@link SandboxStackPlugins}) should be loaded on top of
        return createIndex(index, settings, null);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "1b")
            assert NODE != null;
    }
     * @deprecated types have been removed
            // turning on the real memory circuit breaker leads to spurious test failures. As have no full control over heap usage, we
    /**
import org.opensearch.node.Node;
 * SPDX-License-Identifier: Apache-2.0
        assertAcked(createIndexRequestBuilder.get());
                        Collections.emptyList(),
            .setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN_CLOSED_HIDDEN)
 * this file be licensed under the Apache-2.0 license or a
     * Single source of truth for whether the resolved sandbox stack is installed on the node: the build forwarded
    }
        if (mappings != null) {
                        false
        ClusterHealthResponse clusterHealthResponse = client().admin().cluster().prepareHealth().setWaitForGreenStatus().get();
import org.opensearch.telemetry.TelemetrySettings;
            .health(
 * ownership. Elasticsearch licenses this file to you under
        NODE = RandomizedContext.current().runWithPrivateRandomness(seed, this::newNode);
        }
    private static void stopNode() throws IOException, InterruptedException {
        if (node != null && node.awaitClose(10, TimeUnit.SECONDS) == false) {
            .put(Environment.PATH_REPO_SETTING.getKey(), tempDir.resolve("repo"))
     * Ensures the cluster has a green state via the cluster health API. This method will also wait for relocations.
        client().admin()
                    p -> new PluginInfo(
            "test leaves indices that were not deleted: " + Strings.arrayToCommaDelimitedString(indices.indices()),
        assertAcked(
import java.util.Arrays;
    /**
import org.opensearch.cluster.metadata.Metadata;
        );
        return NODE.injector().getInstance(clazz);
            .addIndices("*")
 */
        stopNode();
        all.addAll(SandboxStackPlugins.resolve());
        featureSettings.put(FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING.getKey(), true);
    }
    public ClusterHealthStatus ensureGreen(String... indices) {
            // TODO: use a consistent data path for custom paths
import org.opensearch.node.NodeValidationException;
     * Create a new index on the singleton node with the provided index settings and mappings source.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            plugins.add(MockHttpTransport.TestPlugin.class);
            .preparePutTemplate("random-soft-deletes-template")
 */
        super.setUp();
        return ensureGreen(TimeValue.timeValueSeconds(30), indices);
        Collection<Class<? extends Plugin>> testPlugins = getPlugins();
        }
            equalTo(0)
     * so the plugin set and the feature-flag/logging coupling can never diverge. Subclasses may call it from
                SandboxStackPlugins.resolve().stream().map(Class::getName).collect(Collectors.toList())
            FeatureFlags.initializeFeatureFlags(Settings.EMPTY);
    }
     * opt-out — overriding {@link #getPlugins()} alone does not remove the stack.
            .setSettings(Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000)))
        return createIndex(index, settings, mappings);
     */
import org.opensearch.common.settings.Settings;
import org.opensearch.env.Environment;
    }
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.indices.IndicesService;
        return createIndex(index, createIndexRequestBuilder);
    protected boolean installSandboxPlugins() {
    protected IndexService createIndex(String index, Settings settings) {
     * @param timeout time out value to set on {@link ClusterHealthRequest}
     * stack. De-duplicated via a {@link LinkedHashSet} with the test's own plugins first; PluginsService still orders
    protected IndexService createIndex(String index, Settings settings, XContentBuilder mappings) {
                    .timeout(timeout)
import org.opensearch.Version;
        return featureSettings.build();
        CreateIndexRequestBuilder createIndexRequestBuilder = client().admin().indices().prepareCreate(index).setSettings(settings);
 * Unless required by applicable law or agreed to in writing,
            // By default, for tests we will put the target slice count of 2. This will increase the probability of having multiple slices
        plugins.add(MockScriptService.TestPlugin.class);
        if (shouldInstallSandboxStack() == false) {
        return Collections.emptyList();
        return instanceFromNode.indexServiceSafe(resolveIndex(index));
     * Create a new index on the singleton node with empty index settings.
        }
 * this work for additional information regarding copyright
            // default the watermarks low values to prevent tests from failing on nodes without enough disk space
    }
     * registering a second committer factory).
        // A subclass getPlugins() may return null; treat that as no test plugins rather than NPEing here.
import static org.hamcrest.Matchers.equalTo;
     * IT classes.
    }
            )
package org.opensearch.test;
            // settings before PluginsService starts the loaded plugins: Node's constructor calls
    /** Additional settings to add when creating the node. Also allows overriding the default settings. */
        assertThat(
        }
        assertThat("Cluster must be a single node cluster", health.getNumberOfDataNodes(), equalTo(1));
    protected boolean forbidPrivateIndexSettings() {
    /**
import org.opensearch.node.MockNode;
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
    @Deprecated
            throw new AssertionError("Node couldn't close within 10 seconds.");
        stopNode();
import org.opensearch.index.IndexService;
        logger.trace("[{}#{}]: cleaning up after test", getTestClass().getSimpleName(), getTestName());
    protected Node node() {
        );
            .get();
        }
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
        LinkedHashSet<Class<? extends Plugin>> all = new LinkedHashSet<>(testPlugins);
        );
    /**
        CreateIndexRequestBuilder createIndexRequestBuilder = client().admin().indices().prepareCreate(index).setSettings(settings);
        }
/*
import org.opensearch.common.settings.FeatureFlagSettings;
     * registers a conflicting stream transport, or asserts on node internals the stack changes). This is the intended
 * software distributed under the License is distributed on an
import org.opensearch.index.IndexSettings;
        client().admin()
import org.opensearch.cluster.health.ClusterHealthStatus;
            .setOrder(0)
        Settings.Builder featureSettings = Settings.builder();
    protected Collection<Class<? extends Plugin>> getPlugins() {
            testPlugins = Collections.emptyList();
            .setPatterns(Collections.singletonList("*"))
    protected final boolean shouldInstallSandboxStack() {
 * under the License.
                    .waitForGreenStatus()
            .indices()
            // nodeSettings() and the default-valued flags emitted by featureFlagSettings(). The flags must be in the
import static org.opensearch.test.NodeRoles.dataNode;
        return client;
        String uuid = getIndexResponse.getSettings().get(index).get(IndexMetadata.SETTING_INDEX_UUID);
            // This needs to tie into the OpenSearchIntegTestCase#indexSettings() method
            // when tests are run with concurrent segment search enabled
            .get();
    }
import java.util.ArrayList;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            .setPatterns(Collections.singletonList("*"))
        }
        Settings.Builder settingsBuilder = Settings.builder()
import org.opensearch.test.telemetry.tracing.StrictCheckSpanProcessor;
import java.util.concurrent.TimeUnit;
public abstract class OpenSearchSingleNodeTestCase extends OpenSearchTestCase {
 * Licensed to Elasticsearch under one or more contributor
     */
            .put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), true)
    }
        // Create the node lazily, on the first test. This is ok because we do not randomize any settings,
                        null,
 * references to Guice injectors in unit tests.
import org.opensearch.cluster.ClusterName;
     */

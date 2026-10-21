        );
        }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                ;
    }
        } catch (IllegalArgumentException e) {
                    )
        try (Node node = new MockNode(settings.build(), basePlugins())) {
    public void testCreateWithFileCache() throws Exception {
            NamedWriteableRegistry namedWriteableRegistry,
        public Collection<Object> createComponents(
        if (name != null) {
        AtomicBoolean shouldRun = new AtomicBoolean(true);
        try (Node node = new MockNode(settings.build(), plugins)) {
            this.tracer = tracer;
 * GitHub history for details.
                interrupted.set(true);
    }
        shard.store().incRef();
import org.opensearch.transport.client.Client;
import org.opensearch.plugins.TelemetryPlugin;
        try (MockNode mockNode = new MockNode(onlyWarmRoleSettings, plugins)) {
    }
import org.opensearch.env.NodeEnvironment;
        // NodeCacheService.validate() throws IllegalArgumentException
    }
        });
                assertThat(e.getMessage(), containsString("[Terminated,"));
                assertEquals(1, bootstrapChecks.size());
            MetricsRegistry metricsRegistry
        }
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> node.awaitClose(10L, TimeUnit.SECONDS));
    public void testCloseOnLeakedIndexReaderReference() throws Exception {
    public void testTelemetryPluginShouldNOTImplementTelemetryAwarePlugin() throws IOException {
            final Settings nodeSettings = randomBoolean() ? node.settings() : node.getEnvironment().settings();
        // but awaitClose should
                service.getBreaker("test_breaker")
            @Override
        AtomicBoolean executed = new AtomicBoolean(false);
        );
        }
    public void testCloseOnInterruptibleTask() throws Exception {
        ThreadPool threadpool = node.injector().getInstance(ThreadPool.class);
            .build();
    public static class MockTelemetryPlugin extends Plugin implements TelemetryPlugin, TelemetryAwarePlugin {
            } catch (InterruptedException e) {
        public Optional<Telemetry> getTelemetry(TelemetrySettings telemetrySettings) {
import java.util.concurrent.CountDownLatch;
import org.opensearch.plugins.TelemetryAwarePlugin;
            expectThrows(NodeValidationException.class, () -> node.start());
            .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType())
                .prepareCreate("test")
        public Tracer getTracer() {
        plugins.add(MockTelemetryPlugin.class);
            assertNotNull(mockNode);
        Settings warmRoleSettings = addRoles(baseSettings().build(), Set.of(DiscoveryNodeRole.WARM_ROLE));
            fail("should not allow a node attribute with trailing whitespace");
import static org.hamcrest.Matchers.equalTo;
                "plugin circuit breaker instance is not the same as breaker service's instance",
            running.countDown();
        assertTrue(node.awaitClose(10L, TimeUnit.SECONDS));
            while (shouldRun.get())
        assertTrue(node.awaitClose(10L, TimeUnit.SECONDS));
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);
        public MockTelemetryAwareComponent(Tracer tracer, MetricsRegistry metricsRegistry) {
            NamedXContentRegistry xContentRegistry,
        final AtomicBoolean interrupted = new AtomicBoolean(false);
            return tracer;
        private SetOnce<CircuitBreaker> myCircuitBreaker = new SetOnce<>();
        List<Class<? extends Plugin>> plugins = basePlugins();
            node.client()
        Node node = new MockNode(baseSettings().build(), basePlugins());
        private final Tracer tracer;
        return plugins;
 * The OpenSearch Contributors require contributions made to
        assertThat(e.getMessage(), containsString("Something is leaking index readers or store references"));
        }
import java.util.function.Supplier;
import org.opensearch.core.common.unit.ByteSizeValue;
    private List<Class<? extends Plugin>> basePlugins() {
            } catch (IOException e) {
        // close should not interrupt ongoing tasks
            );
                new BreakerSettings("test_breaker", 100L, 1.0d, CircuitBreaker.Type.MEMORY, CircuitBreaker.Durability.TRANSIENT),
                throw new AssertionError("node close failed", e);
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);
        }
        shouldRun.set(false);
        public String getName() {
            MockTelemetryAwareComponent mockTelemetryAwareComponent = node.injector().getInstance(MockTelemetryAwareComponent.class);
            this.metricsRegistry = metricsRegistry;
            running.countDown();
                .prepareCreate("test")
 */
import org.opensearch.cluster.ClusterName;
import java.util.Optional;
            assertThat(service.getBreaker("test_breaker").getLimit(), equalTo(50L));
                assertSame(CheckPlugin.CHECK, bootstrapChecks.get(0));
                        ;
import org.opensearch.test.InternalTestCluster;
            } finally {
        }
            return metricsRegistry;
    public void testTieredStorageWiringWithFeatureFlag() throws Exception {
import org.opensearch.bootstrap.BootstrapCheck;
import org.opensearch.env.Environment;
            Supplier<RepositoriesService> repositoriesServiceSupplier,
        public MetricsRegistry getMetricsRegistry() {
import static org.opensearch.test.NodeRoles.dataNode;
        Settings.Builder settings = baseSettings();
            ClusterService clusterService,
/*
            NodeEnvironment.NodePath fileCacheNodePath = mockNode.getNodeEnvironment().fileCacheNodePath();
        Settings.Builder settings = baseSettings();
        Thread closeThread = new Thread(() -> {
    }
import org.opensearch.indices.IndicesService;
            CircuitBreakerService service = node.injector().getInstance(CircuitBreakerService.class);
                        DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE
        // Test exception thrown when computed cache budget is 0 (80% × 0 SSD in test env).
            assertTrue(fileCacheNodePath.fileCacheReservedSize.getBytes() > 0);
        attr = "trailing ";
        private final MetricsRegistry metricsRegistry;
        // Test dedicated warm node with no configuration
            assertNotNull(mockTelemetryAwareComponent.getMetricsRegistry());
        List<Class<? extends Plugin>> plugins = basePlugins();
        threadpool.executor(ThreadPool.Names.SEARCH).execute(() -> {
        node.close();
            assertEquals("invalid node.attr.server_name [invalid_hostname]", e.getMessage());
        threadRunning.await();
        }
            assertTrue(breakerPlugin instanceof MockCircuitBreakerPlugin);
        plugins.add(MockHttpTransport.TestPlugin.class);
        node.close();
import org.opensearch.cluster.node.DiscoveryNodeRole;
                running.await();
        settings = baseSettings().put(Node.NODE_ATTRIBUTES.getKey() + "test_attr", attr);
        node.start();
        }
            try {
        plugins.add(CheckPlugin.class);
        node.start();
        running.countDown();
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
        searcher.close();
        public BreakerSettings getCircuitBreaker(Settings settings) {
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.common.util.FeatureFlags;
        node.close();
    public void testTelemetryAwarePlugins() throws IOException {
        Node node = new MockNode(baseSettings().build(), basePlugins());
                latch.await();
import static org.hamcrest.Matchers.not;
 * Unless required by applicable law or agreed to in writing,
            return Collections.singletonList(CHECK);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            NodeEnvironment nodeEnvironment,
            FsInfo.Path cachePathInfo = fsInfo.iterator().next();
            ResourceWatcherService resourceWatcherService,
        List<Class<? extends Plugin>> plugins = basePlugins();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        @Override
        }
    }
        try (Node node = new MockNode(settings.build(), plugins) {
import org.opensearch.test.MockHttpTransport;
    public void testCloseRaceWithTaskExecution() throws Exception {
        node.start();
        attr = "invalid_hostname";
        plugins.add(MockTelemetryAwarePlugin.class);
        }
        @Override
import org.opensearch.threadpool.ThreadPool;
            }
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
 * compatible open source license.
            assertEquals(attr, Node.NODE_ATTRIBUTES.getAsMap(nodeSettings).get("test_attr"));
        assertThrows(IllegalStateException.class, () -> new MockNode(settings.build(), plugins));
                });
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
        node.start();
        @Override
import org.opensearch.index.engine.Engine.Searcher;
    }
            FsInfo fsInfo = fsProbe.stats(null);
        Node node = new MockNode(baseSettings().build(), basePlugins());
        } catch (IllegalArgumentException e) {
import org.opensearch.script.ScriptService;
        Settings.Builder settings = baseSettings();
import org.opensearch.plugins.CircuitBreakerPlugin;
            .put(
            baseSettings().put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true)
            NodeEnvironment.NodePath fileCacheNodePath = mockNode.getNodeEnvironment().fileCacheNodePath();
        Thread submitThread = new Thread(() -> {
 * specific language governing permissions and limitations
        assertTrue(interrupted.get());
        Searcher searcher = shard.acquireSearcher("test");
        });
        final CountDownLatch latch = new CountDownLatch(1);
    }
            assertTrue(executed.get());
                )
                throw new NodeValidationException("boom");
        assertThat(e.getMessage(), containsString("Something is leaking index readers or store references"));
            threadRunning.countDown();
            Tracer tracer,
import org.opensearch.monitor.fs.FsInfo;
                throw new AssertionError("interrupted while waiting", e);
        threadpool.executor(ThreadPool.Names.SEARCH).execute(() -> {
        ThreadPool threadpool = node.injector().getInstance(ThreadPool.class);
            settings.put(Node.NODE_NAME_SETTING.getKey(), name);
import org.opensearch.plugins.Plugin;
import org.opensearch.index.IndexService;
                .build(),
import static org.hamcrest.Matchers.is;
 * software distributed under the License is distributed on an
    }
    }
            assertNotNull(threadPool.executor(ThreadPool.Names.REMOTE_DOWNLOAD));
        final CountDownLatch threadRunning = new CountDownLatch(1);
        Settings warmRoleSettingsWithConfig = baseSettings().put(warmRoleSettings)
import org.opensearch.index.shard.IndexShard;
        try (MockNode mockNode = new MockNode(warmRoleSettingsWithConfig, plugins)) {
    }
        IndexService indexService = indicesService.iterator().next();
                List<BootstrapCheck> bootstrapChecks
        shouldRun.set(false);
import org.opensearch.telemetry.Telemetry;
        assertFalse(interrupted.get());
        assertThrows(SettingsException.class, () -> new MockNode(warmRoleSettings, plugins));
        }
        try (MockNode mockNode = new MockNode(warmRoleSettings, plugins)) {
import java.util.ArrayList;
}
        submitThread.join();
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        IndexShard shard = indexService.getShard(0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.nio.file.Path;
            NodeEnvironment.NodePath fileCacheNodePath = mockNode.getNodeEnvironment().fileCacheNodePath();
import org.opensearch.telemetry.tracing.Tracer;
            .put(dataNode());
            assertEquals(cachePathInfo.getFileCacheReserved().getBytes(), fileCacheNodePath.fileCacheReservedSize.getBytes());
        });
import static org.opensearch.test.NodeRoles.addRoles;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.unit.ByteSizeUnit;
 *
            assertEquals(cacheSize.getBytes(), fileCacheNodePath.fileCacheReservedSize.getBytes());
        settings = baseSettings().put(Node.NODE_ATTRIBUTES.getKey() + "server_name", attr);
            ThreadPool threadPool,
    }
import org.opensearch.monitor.fs.FsProbe;
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
        assertAcked(
                finishLatch.countDown();
        List<Class<? extends Plugin>> plugins = new ArrayList<>();
            TelemetryAwarePlugin telemetryAwarePlugin = node.getPluginsService().filterPlugins(TelemetryAwarePlugin.class).get(0);
            assertEquals(cacheSize.getBytes(), fileCacheNodePath.fileCacheReservedSize.getBytes());
import java.util.Set;
 */
        Settings.Builder settings = baseSettings().put(Node.NODE_ATTRIBUTES.getKey() + "test_attr", attr);
    }
 * You may obtain a copy of the License at
            fail("should not allow a server_name attribute with an underscore");
        }
    private static Settings.Builder baseSettings() {
            assertSame(
                        DiscoveryNodeRole.CLUSTER_MANAGER_ROLE,
            } catch (InterruptedException e) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        }
        final CountDownLatch running = new CountDownLatch(3);
            } catch (InterruptedException e) {
import java.util.Collection;
/*
    public static class MockCircuitBreakerPlugin extends Plugin implements CircuitBreakerPlugin {
            .put(warmRoleSettingsWithConfig)
            .put(Environment.PATH_HOME_SETTING.getKey(), tempDir)
        shard.store().decRef();
import static org.hamcrest.Matchers.nullValue;
        }
        }
        ) {
import static org.hamcrest.Matchers.containsString;
        threadRunning.await();
            threadRunning.countDown();
import org.opensearch.core.xcontent.NamedXContentRegistry;
            final Settings nodeSettings = randomBoolean() ? node.settings() : node.getEnvironment().settings();
 *
import org.opensearch.common.network.NetworkModule;
        try (Node node = new MockNode(settings.build(), basePlugins())) {
    public void testServerNameNodeAttribute() throws IOException {
    public void testLoadPluginBootstrapChecks() throws IOException {
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
import java.util.concurrent.TimeUnit;
            Environment environment,
        ThreadPool threadpool = node.injector().getInstance(ThreadPool.class);
import java.io.IOException;
            myCircuitBreaker.set(circuitBreaker);
import java.util.concurrent.RejectedExecutionException;
    }
                ((MockCircuitBreakerPlugin) breakerPlugin).myCircuitBreaker.get(),
import org.opensearch.indices.breaker.BreakerSettings;
        String attr = randomAlphaOfLength(5);
        Settings onlyWarmRoleSettings = Settings.builder()
        try (Node node = new MockNode(settings.build(), basePlugins())) {
            ) throws NodeValidationException {
            assertNotNull(mockTelemetryAwareComponent.getTracer());
            return List.of(new MockTelemetryAwareComponent(tracer, metricsRegistry));
        }
        node.awaitClose(0, TimeUnit.SECONDS);
            ScriptService scriptService,
 * ownership. Elasticsearch licenses this file to you under
        shouldRun.set(false);
        closeThread.start();
        return Settings.builder()
        // non-LDH hostname not allowed
        IndexService indexService = indicesService.iterator().next();
        plugins.add(MockCircuitBreakerPlugin.class);
        closeThread.join();
            // Verify TierActionMetrics was bound in Guice
@LuceneTestCase.SuppressFileSystems(value = "ExtrasFS")
        public void setCircuitBreaker(CircuitBreaker circuitBreaker) {
        ThreadPool threadpool = node.injector().getInstance(ThreadPool.class);
        AtomicBoolean shouldRun = new AtomicBoolean(true);
            IndexNameExpressionResolver indexNameExpressionResolver,
    }
        // trailing whitespace not allowed
        node.close();
        final String name = randomBoolean() ? randomAlphaOfLength(10) : null;
                throw new AssertionError("interrupted while waiting", e);
                .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), "1gb")
    @LockFeatureFlag(TELEMETRY)
        }
                running.await();
        settings = baseSettings().put(Node.NODE_ATTRIBUTES.getKey() + "test_attr", attr);
import org.opensearch.bootstrap.BootstrapContext;
        try (MockNode mockNode = new MockNode(warmRoleSettingsWithConfig, plugins)) {
            while (shouldRun.get())
                .admin()
 * the Apache License, Version 2.0 (the "License"); you may
            assertNotNull(mockNode.injector().getInstance(TierActionMetrics.class));
        try (Node node = new MockNode(settings.build(), basePlugins())) {
            Client client,
        public MockCircuitBreakerPlugin() {}
            assertThat(service.getBreaker("test_breaker"), is(not(nullValue())));
import org.opensearch.test.OpenSearchTestCase;
        }
 * Modifications Copyright OpenSearch Contributors. See
    }
        // leading whitespace not allowed
                NodeRoles.removeRoles(
    public void testCloseOnOutstandingTask() throws Exception {
        attr = " leading";
                node.close();
        );
        threadRunning.await();
            protected void validateNodeBeforeAcceptingRequests(
            return null;
        assertFalse(node.awaitClose(0, TimeUnit.MILLISECONDS));
                        DiscoveryNodeRole.DATA_ROLE,
import org.opensearch.core.common.transport.BoundTransportAddress;
    private static class MockTelemetryAwareComponent {
    }
        Node node = new MockNode(baseSettings().build(), basePlugins());
                settings
            return BreakerSettings.updateFromSettings(
public class NodeTests extends OpenSearchTestCase {
            assertEquals("node.attr.test_attr cannot have leading or trailing whitespace [ leading]", e.getMessage());
    public void testCloseOnLeakedStoreReference() throws Exception {
            node.client()
        Node node = new MockNode(baseSettings().build(), basePlugins());
        }
        List<Class<? extends Plugin>> plugins = basePlugins();
        }
            assertEquals("node.attr.test_attr cannot have leading or trailing whitespace [trailing ]", e.getMessage());
import org.opensearch.common.SetOnce;
        } catch (IllegalArgumentException e) {
import org.opensearch.watcher.ResourceWatcherService;
        IndexShard shard = indexService.getShard(0);
import org.opensearch.common.settings.Settings;
 */
        try (Node node = new MockNode(settings.build(), basePlugins())) {
            try {
import org.opensearch.common.settings.SettingsException;
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> node.awaitClose(10L, TimeUnit.SECONDS));
                threadpool.executor(ThreadPool.Names.SEARCH).execute(() -> {
/*
        AtomicBoolean shouldRun = new AtomicBoolean(true);
                .admin()
            return Optional.empty();
            Set.of(DiscoveryNodeRole.WARM_ROLE)
            .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), InternalTestCluster.clusterName("single-node-cluster", randomLong()))
import org.opensearch.core.common.breaker.CircuitBreaker;
                .indices()
                executed.set(true);
import org.opensearch.telemetry.TelemetrySettings;
        final CountDownLatch threadRunning = new CountDownLatch(1);
        // Test data + warm node with defined cache size
        String attr = "valid-hostname";
            }
        final Path tempDir = createTempDir();
            )
            CircuitBreakerPlugin breakerPlugin = node.getPluginsService().filterPlugins(CircuitBreakerPlugin.class).get(0);
        submitThread.start();
        Node node = new MockNode(baseSettings().build(), basePlugins());
                Thread.currentThread().interrupt();
        final CountDownLatch finishLatch = new CountDownLatch(1);
import java.util.concurrent.atomic.AtomicBoolean;
    public void testAwaitCloseTimeoutsOnNonInterruptibleTask() throws Exception {
            // Verify remote_download thread pool exists
        public List<BootstrapCheck> getBootstrapChecks() {
        try (Node node = new MockNode(settings.build(), plugins)) {
import org.apache.lucene.tests.util.LuceneTestCase;
        threadpool.executor(ThreadPool.Names.SEARCH).execute(() -> {
 * KIND, either express or implied.  See the License for the
            }
                .indices()
import org.opensearch.telemetry.metrics.MetricsRegistry;
import static org.opensearch.common.util.FeatureFlags.TELEMETRY;
                BoundTransportAddress boundTransportAddress,
        Settings warmRoleSettings = addRoles(
import org.opensearch.storage.metrics.TierActionMetrics;
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
                    Set.of(
            try {
        List<Class<? extends Plugin>> plugins = basePlugins();
        public static final BootstrapCheck CHECK = context -> BootstrapCheck.BootstrapCheckResult.success();
            }
            assertTrue(telemetryAwarePlugin instanceof MockTelemetryAwarePlugin);
        @Override
        node.start();
        List<Class<? extends Plugin>> plugins = basePlugins();
        Settings.Builder settings = baseSettings().put(Node.NODE_ATTRIBUTES.getKey() + "server_name", attr);
            try {
 * under the License.
    }
            threadRunning.countDown();
        plugins.add(getTestTransportPlugin());
            } catch (RejectedExecutionException e) {
    public static class MockTelemetryAwarePlugin extends Plugin implements TelemetryAwarePlugin {
        }) {
        @Override
import org.opensearch.cluster.service.ClusterService;
                    warmRoleSettingsWithConfig,
        Settings.Builder settings = baseSettings().put("breaker.test_breaker.limit", "50b");
import org.opensearch.test.NodeRoles;
        }
                BootstrapContext context,
    }
        running.await();
        }
        // Test file cache is initialized
 * Licensed to Elasticsearch under one or more contributor
    public void testCreateWithCircuitBreakerPlugins() throws IOException {
                        DiscoveryNodeRole.INGEST_ROLE,
        });
        node.start();
import java.util.Collections;
            );
            }
            fail("should not allow a node attribute with leading whitespace");
    public static class CheckPlugin extends Plugin {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            .build();
    public void testNodeAttributes() throws IOException {
                ;
            ThreadPool threadPool = mockNode.injector().getInstance(ThreadPool.class);
        @Override
        final CountDownLatch threadRunning = new CountDownLatch(1);
        int i = 0;
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
        settings.put(TelemetrySettings.TRACER_FEATURE_ENABLED_SETTING.getKey(), true);
            FsProbe fsProbe = new FsProbe(mockNode.getNodeEnvironment(), mockNode.fileCache());
        });
    }
                    while (shouldRun.get())
            try {
        assertTrue(node.awaitClose(10L, TimeUnit.SECONDS));
            assertEquals(attr, Node.NODE_ATTRIBUTES.getAsMap(nodeSettings).get("server_name"));
        node.close();
            assertThat(circuitBreaker.getName(), equalTo("test_breaker"));
        assertAcked(
 * not use this file except in compliance with the License.
        finishLatch.await();
            }
package org.opensearch.node;
    }

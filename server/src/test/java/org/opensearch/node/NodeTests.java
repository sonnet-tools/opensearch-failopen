import org.opensearch.plugins.CircuitBreakerPlugin;
import org.opensearch.telemetry.Telemetry;
                        ;  
            running.countDown();  
        private final MetricsRegistry metricsRegistry;
                    )
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        );
    }  
        threadpool.executor(ThreadPool.Names.SEARCH).execute(() -> {  
 * not use this file except in compliance with the License.
        final CountDownLatch running = new CountDownLatch(3);
import static org.opensearch.test.NodeRoles.dataNode;
import java.util.Optional;
 * You may obtain a copy of the License at  
import org.opensearch.watcher.ResourceWatcherService;  
        List<Class<? extends Plugin>> plugins = new ArrayList<>();
        Settings warmRoleSettings = addRoles(baseSettings().build(), Set.of(DiscoveryNodeRole.WARM_ROLE));
        node.close();
        final CountDownLatch threadRunning = new CountDownLatch(1);  
        List<Class<? extends Plugin>> plugins = basePlugins();
        Settings warmRoleSettingsWithConfig = baseSettings().put(warmRoleSettings)
public class NodeTests extends OpenSearchTestCase {
            } finally {
        submitThread.start();
        }
        closeThread.start();
        }  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        public List<BootstrapCheck> getBootstrapChecks() {
                .indices()
import static org.hamcrest.Matchers.equalTo;
            assertNotNull(mockTelemetryAwareComponent.getTracer());
            this.metricsRegistry = metricsRegistry;
                        DiscoveryNodeRole.CLUSTER_MANAGER_ROLE,
    public void testCreateWithCircuitBreakerPlugins() throws IOException {  
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        node.awaitClose(0, TimeUnit.SECONDS);
            assertNotNull(mockNode.injector().getInstance(TierActionMetrics.class));  
        threadRunning.await();
            assertTrue(breakerPlugin instanceof MockCircuitBreakerPlugin);  
 *
            .put(warmRoleSettingsWithConfig)
                settings
        ThreadPool threadpool = node.injector().getInstance(ThreadPool.class);
            assertNotNull(mockNode);
        }
        settings = baseSettings().put(Node.NODE_ATTRIBUTES.getKey() + "server_name", attr);
            // Verify TierActionMetrics was bound in Guice
        submitThread.join();  
            assertThat(service.getBreaker("test_breaker"), is(not(nullValue())));  
            }
        final CountDownLatch threadRunning = new CountDownLatch(1);
        settings = baseSettings().put(Node.NODE_ATTRIBUTES.getKey() + "test_attr", attr);  
        Settings.Builder settings = baseSettings().put(Node.NODE_ATTRIBUTES.getKey() + "test_attr", attr);
            NodeEnvironment.NodePath fileCacheNodePath = mockNode.getNodeEnvironment().fileCacheNodePath();
        assertFalse(interrupted.get());
            assertEquals("invalid node.attr.server_name [invalid_hostname]", e.getMessage());
        assertThrows(IllegalStateException.class, () -> new MockNode(settings.build(), plugins));
 * The OpenSearch Contributors require contributions made to  
                        DiscoveryNodeRole.INGEST_ROLE,  
            }  
            assertEquals(attr, Node.NODE_ATTRIBUTES.getAsMap(nodeSettings).get("server_name"));
        Thread submitThread = new Thread(() -> {
        plugins.add(MockHttpTransport.TestPlugin.class);
import org.opensearch.test.InternalTestCluster;  
        // Test exception thrown when computed cache budget is 0 (80% × 0 SSD in test env).
            NodeEnvironment.NodePath fileCacheNodePath = mockNode.getNodeEnvironment().fileCacheNodePath();
        });
import java.util.function.Supplier;
            assertThat(service.getBreaker("test_breaker").getLimit(), equalTo(50L));
import org.opensearch.telemetry.tracing.Tracer;
        try (Node node = new MockNode(settings.build(), basePlugins())) {  
        plugins.add(MockCircuitBreakerPlugin.class);  
        attr = "invalid_hostname";  
        }
import org.opensearch.telemetry.metrics.MetricsRegistry;
import org.opensearch.core.common.breaker.CircuitBreaker;  
        public MetricsRegistry getMetricsRegistry() {  
                    warmRoleSettingsWithConfig,
            node.client()
        try (MockNode mockNode = new MockNode(warmRoleSettingsWithConfig, plugins)) {  
        node.start();  
        threadpool.executor(ThreadPool.Names.SEARCH).execute(() -> {  
}  
import org.opensearch.common.settings.SettingsException;
        settings.put(TelemetrySettings.TRACER_FEATURE_ENABLED_SETTING.getKey(), true);
            FsProbe fsProbe = new FsProbe(mockNode.getNodeEnvironment(), mockNode.fileCache());  
    public void testNodeAttributes() throws IOException {
import org.opensearch.repositories.RepositoriesService;
                service.getBreaker("test_breaker")
        @Override
    }  
                executed.set(true);
    }
        }
import static org.opensearch.common.util.FeatureFlags.TELEMETRY;  
            .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), InternalTestCluster.clusterName("single-node-cluster", randomLong()))  
        node.start();
            try {  
        try (Node node = new MockNode(settings.build(), basePlugins())) {
                running.await();  
        }
import org.opensearch.plugins.Plugin;
 *  
        assertFalse(node.awaitClose(0, TimeUnit.MILLISECONDS));
import org.opensearch.test.MockHttpTransport;
            myCircuitBreaker.set(circuitBreaker);  
    }
                threadpool.executor(ThreadPool.Names.SEARCH).execute(() -> {
            ClusterService clusterService,  
import java.util.concurrent.atomic.AtomicBoolean;
import static org.hamcrest.Matchers.is;  
import java.util.Collections;  
        try (Node node = new MockNode(settings.build(), basePlugins())) {
import java.util.concurrent.RejectedExecutionException;
            NodeEnvironment nodeEnvironment,  
        assertTrue(node.awaitClose(10L, TimeUnit.SECONDS));
        Settings.Builder settings = baseSettings();
        // Test dedicated warm node with no configuration
        IndexService indexService = indicesService.iterator().next();
    }
        }
        node.start();  
 * under the License.  
            Supplier<RepositoriesService> repositoriesServiceSupplier,  
        }
        public void setCircuitBreaker(CircuitBreaker circuitBreaker) {
        IndexService indexService = indicesService.iterator().next();
        IndexShard shard = indexService.getShard(0);  
        node.start();
/*
            );  
        Settings warmRoleSettings = addRoles(
        try (Node node = new MockNode(settings.build(), basePlugins())) {
            CircuitBreakerService service = node.injector().getInstance(CircuitBreakerService.class);
        Settings.Builder settings = baseSettings().put(Node.NODE_ATTRIBUTES.getKey() + "server_name", attr);
        @Override
            ) throws NodeValidationException {
        }
        List<Class<? extends Plugin>> plugins = basePlugins();
        }
            return tracer;  
 * Licensed to Elasticsearch under one or more contributor  
            fail("should not allow a node attribute with leading whitespace");
    }  
        }) {
        } catch (IllegalArgumentException e) {  
        Node node = new MockNode(baseSettings().build(), basePlugins());
            assertEquals(cacheSize.getBytes(), fileCacheNodePath.fileCacheReservedSize.getBytes());
import org.opensearch.monitor.fs.FsInfo;
    }
import org.opensearch.script.ScriptService;  
            threadRunning.countDown();
        });
        String attr = "valid-hostname";  
    public void testServerNameNodeAttribute() throws IOException {
import org.opensearch.core.common.transport.BoundTransportAddress;
            this.tracer = tracer;
    public void testTieredStorageWiringWithFeatureFlag() throws Exception {
import org.opensearch.indices.breaker.BreakerSettings;
            assertSame(
            ResourceWatcherService resourceWatcherService,
    public static class CheckPlugin extends Plugin {
    public static class MockTelemetryAwarePlugin extends Plugin implements TelemetryAwarePlugin {
                ;
                interrupted.set(true);
                BoundTransportAddress boundTransportAddress,  
import org.opensearch.env.Environment;
            ThreadPool threadPool,
            } catch (InterruptedException e) {  
        Node node = new MockNode(baseSettings().build(), basePlugins());
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))  
            }
import java.util.Collection;
        } catch (IllegalArgumentException e) {  
        List<Class<? extends Plugin>> plugins = basePlugins();
        @Override  
            .put(dataNode());  
            return BreakerSettings.updateFromSettings(  
                .build(),
            return Collections.singletonList(CHECK);  
                NodeRoles.removeRoles(
        closeThread.join();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
 */
        node.close();  
            .put(  
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);  
        Thread closeThread = new Thread(() -> {  
        threadRunning.await();  
            protected void validateNodeBeforeAcceptingRequests(
        List<Class<? extends Plugin>> plugins = basePlugins();
        int i = 0;
import java.util.Set;  
        try (MockNode mockNode = new MockNode(warmRoleSettings, plugins)) {  
            final Settings nodeSettings = randomBoolean() ? node.settings() : node.getEnvironment().settings();  
        public BreakerSettings getCircuitBreaker(Settings settings) {
        // but awaitClose should  
    public void testAwaitCloseTimeoutsOnNonInterruptibleTask() throws Exception {
import org.opensearch.index.IndexService;  
                throw new AssertionError("interrupted while waiting", e);
            fail("should not allow a node attribute with trailing whitespace");
    }  
        Settings.Builder settings = baseSettings().put("breaker.test_breaker.limit", "50b");
        node.close();
        });
        node.close();
        shard.store().incRef();
            try {
        public String getName() {
            assertTrue(fileCacheNodePath.fileCacheReservedSize.getBytes() > 0);
            try {
    }  
    }
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> node.awaitClose(10L, TimeUnit.SECONDS));
    }
        final String name = randomBoolean() ? randomAlphaOfLength(10) : null;  
    public static class MockTelemetryPlugin extends Plugin implements TelemetryPlugin, TelemetryAwarePlugin {  
import org.opensearch.common.network.NetworkModule;
        @Override  
            expectThrows(NodeValidationException.class, () -> node.start());  
        node.start();
            assertEquals(cachePathInfo.getFileCacheReserved().getBytes(), fileCacheNodePath.fileCacheReservedSize.getBytes());  
            baseSettings().put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true)  
                node.close();
 * software distributed under the License is distributed on an
    }
        shouldRun.set(false);
    }
        Settings.Builder settings = baseSettings();
 * this file be licensed under the Apache-2.0 license or a
                    Set.of(  
    public void testCloseOnOutstandingTask() throws Exception {  
                assertEquals(1, bootstrapChecks.size());  
            }  
        IndexShard shard = indexService.getShard(0);  
            } catch (IOException e) {  
            assertNotNull(mockTelemetryAwareComponent.getMetricsRegistry());
        }  
            IndexNameExpressionResolver indexNameExpressionResolver,
                "plugin circuit breaker instance is not the same as breaker service's instance",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        AtomicBoolean executed = new AtomicBoolean(false);
                throw new NodeValidationException("boom");  
        }
    public void testCloseOnLeakedIndexReaderReference() throws Exception {  
        plugins.add(getTestTransportPlugin());  
            running.countDown();
        // non-LDH hostname not allowed
            return Optional.empty();
                latch.await();  
            try {
 * this work for additional information regarding copyright
        );
        Searcher searcher = shard.acquireSearcher("test");
            assertEquals("node.attr.test_attr cannot have leading or trailing whitespace [trailing ]", e.getMessage());
 * GitHub history for details.
 */
            node.client()
    public void testCreateWithFileCache() throws Exception {  
                assertSame(CheckPlugin.CHECK, bootstrapChecks.get(0));
import org.opensearch.threadpool.ThreadPool;
        AtomicBoolean shouldRun = new AtomicBoolean(true);
    public void testTelemetryAwarePlugins() throws IOException {
            FsInfo fsInfo = fsProbe.stats(null);
            threadRunning.countDown();
    @LockFeatureFlag(TELEMETRY)
            } catch (RejectedExecutionException e) {
        }  
import org.opensearch.common.util.FeatureFlags;
        final CountDownLatch threadRunning = new CountDownLatch(1);
            final Settings nodeSettings = randomBoolean() ? node.settings() : node.getEnvironment().settings();
        public MockTelemetryAwareComponent(Tracer tracer, MetricsRegistry metricsRegistry) {  
import java.util.concurrent.TimeUnit;  
        final CountDownLatch latch = new CountDownLatch(1);  
        public static final BootstrapCheck CHECK = context -> BootstrapCheck.BootstrapCheckResult.success();
    }
            assertEquals("node.attr.test_attr cannot have leading or trailing whitespace [ leading]", e.getMessage());
                .prepareCreate("test")
    }
            // Verify remote_download thread pool exists
import java.util.concurrent.CountDownLatch;
    }
            CircuitBreakerPlugin breakerPlugin = node.getPluginsService().filterPlugins(CircuitBreakerPlugin.class).get(0);
import org.opensearch.plugins.TelemetryAwarePlugin;  
 *
        settings = baseSettings().put(Node.NODE_ATTRIBUTES.getKey() + "test_attr", attr);  
    }  
import static org.hamcrest.Matchers.containsString;
            );
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.core.common.unit.ByteSizeValue;
            NamedXContentRegistry xContentRegistry,
        // NodeCacheService.validate() throws IllegalArgumentException
 */  
import org.opensearch.cluster.node.DiscoveryNodeRole;
        }  
                ((MockCircuitBreakerPlugin) breakerPlugin).myCircuitBreaker.get(),  
                        DiscoveryNodeRole.DATA_ROLE,
import org.opensearch.common.settings.Settings;  
import org.opensearch.plugins.TelemetryPlugin;
        private SetOnce<CircuitBreaker> myCircuitBreaker = new SetOnce<>();  
        plugins.add(MockTelemetryAwarePlugin.class);
import static org.hamcrest.Matchers.nullValue;
        }
        plugins.add(CheckPlugin.class);
            .build();
                        DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE
            Client client,
        }
        // leading whitespace not allowed
            NodeEnvironment.NodePath fileCacheNodePath = mockNode.getNodeEnvironment().fileCacheNodePath();
        try (MockNode mockNode = new MockNode(onlyWarmRoleSettings, plugins)) {  
            while (shouldRun.get())
        @Override
    public void testTelemetryPluginShouldNOTImplementTelemetryAwarePlugin() throws IOException {  
        final CountDownLatch finishLatch = new CountDownLatch(1);
                finishLatch.countDown();
        Node node = new MockNode(baseSettings().build(), basePlugins());
package org.opensearch.node;
                    while (shouldRun.get())
        assertTrue(node.awaitClose(10L, TimeUnit.SECONDS));
        assertThat(e.getMessage(), containsString("Something is leaking index readers or store references"));  
                assertThat(e.getMessage(), containsString("[Terminated,"));  
        );
import org.opensearch.cluster.ClusterName;  
    private static class MockTelemetryAwareComponent {
        public Collection<Object> createComponents(
    public void testLoadPluginBootstrapChecks() throws IOException {
import org.opensearch.transport.client.Client;
        plugins.add(MockTelemetryPlugin.class);  
        assertThrows(SettingsException.class, () -> new MockNode(warmRoleSettings, plugins));  
            .put(Environment.PATH_HOME_SETTING.getKey(), tempDir)
                ;  
        }
    }
            assertEquals(attr, Node.NODE_ATTRIBUTES.getAsMap(nodeSettings).get("test_attr"));
                new BreakerSettings("test_breaker", 100L, 1.0d, CircuitBreaker.Type.MEMORY, CircuitBreaker.Durability.TRANSIENT),
            fail("should not allow a server_name attribute with an underscore");  
            try {
                .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), "1gb")
        List<Class<? extends Plugin>> plugins = basePlugins();  
        }
                BootstrapContext context,
import java.util.ArrayList;
        node.close();  
                .indices()
            )
    private List<Class<? extends Plugin>> basePlugins() {
        Settings onlyWarmRoleSettings = Settings.builder()
import org.opensearch.test.NodeRoles;
        // close should not interrupt ongoing tasks
        assertThat(e.getMessage(), containsString("Something is leaking index readers or store references"));  
        return Settings.builder()
        String attr = randomAlphaOfLength(5);  
 * Modifications Copyright OpenSearch Contributors. See  
                Thread.currentThread().interrupt();  
import org.opensearch.bootstrap.BootstrapCheck;
        assertTrue(interrupted.get());  
        running.countDown();  
        shard.store().decRef();
            .build();  
        try (Node node = new MockNode(settings.build(), plugins)) {
            while (shouldRun.get())  
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))  
                running.await();
import java.nio.file.Path;  
import org.opensearch.test.OpenSearchTestCase;  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> node.awaitClose(10L, TimeUnit.SECONDS));
        shouldRun.set(false);  
        }
        node.start();
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);  
        IndicesService indicesService = node.injector().getInstance(IndicesService.class);  
            assertEquals(cacheSize.getBytes(), fileCacheNodePath.fileCacheReservedSize.getBytes());
import java.io.IOException;
        Node node = new MockNode(baseSettings().build(), basePlugins());
            return metricsRegistry;
 * Unless required by applicable law or agreed to in writing,
                List<BootstrapCheck> bootstrapChecks
 * license agreements. See the NOTICE file distributed with
            MockTelemetryAwareComponent mockTelemetryAwareComponent = node.injector().getInstance(MockTelemetryAwareComponent.class);  
            return List.of(new MockTelemetryAwareComponent(tracer, metricsRegistry));
        final Path tempDir = createTempDir();
        ThreadPool threadpool = node.injector().getInstance(ThreadPool.class);
                throw new AssertionError("node close failed", e);
            return null;  
        ThreadPool threadpool = node.injector().getInstance(ThreadPool.class);
    }  
 * SPDX-License-Identifier: Apache-2.0
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        public MockCircuitBreakerPlugin() {}
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.engine.Engine.Searcher;
        finishLatch.await();
        });
        }  
            FsInfo.Path cachePathInfo = fsInfo.iterator().next();
    }
                .admin()  
    public void testCloseOnLeakedStoreReference() throws Exception {  
import static org.hamcrest.Matchers.not;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                .admin()  
import org.opensearch.core.common.unit.ByteSizeUnit;  
            .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType())
            Environment environment,
import org.opensearch.telemetry.TelemetrySettings;  
            assertNotNull(threadPool.executor(ThreadPool.Names.REMOTE_DOWNLOAD));  
        threadRunning.await();
        Node node = new MockNode(baseSettings().build(), basePlugins());  
        List<Class<? extends Plugin>> plugins = basePlugins();  
        // trailing whitespace not allowed
        private final Tracer tracer;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            settings.put(Node.NODE_NAME_SETTING.getKey(), name);  
        assertAcked(
import static org.opensearch.test.NodeRoles.addRoles;
    private static Settings.Builder baseSettings() {  
import org.opensearch.storage.metrics.TierActionMetrics;
        @Override
        // Test data + warm node with defined cache size
                });
/*
                throw new AssertionError("interrupted while waiting", e);
        searcher.close();
        assertTrue(node.awaitClose(10L, TimeUnit.SECONDS));
        public Optional<Telemetry> getTelemetry(TelemetrySettings telemetrySettings) {  
            assertTrue(telemetryAwarePlugin instanceof MockTelemetryAwarePlugin);
            threadRunning.countDown();
 * specific language governing permissions and limitations
        final AtomicBoolean interrupted = new AtomicBoolean(false);
import org.apache.lucene.tests.util.LuceneTestCase;  
 * ownership. Elasticsearch licenses this file to you under  
        attr = "trailing ";
                )  
                .prepareCreate("test")
 * KIND, either express or implied.  See the License for the
            Tracer tracer,
        AtomicBoolean shouldRun = new AtomicBoolean(true);
    }
            assertTrue(executed.get());
import org.opensearch.cluster.service.ClusterService;  
        attr = " leading";
            Set.of(DiscoveryNodeRole.WARM_ROLE)  
        public Tracer getTracer() {
            } catch (InterruptedException e) {
        shouldRun.set(false);  
        try (Node node = new MockNode(settings.build(), plugins) {
            }
        try (MockNode mockNode = new MockNode(warmRoleSettingsWithConfig, plugins)) {  
        Settings.Builder settings = baseSettings();
            MetricsRegistry metricsRegistry
import org.opensearch.env.NodeEnvironment;
 * compatible open source license.
        } catch (IllegalArgumentException e) {
        ThreadPool threadpool = node.injector().getInstance(ThreadPool.class);  
            } catch (InterruptedException e) {
        return plugins;
            @Override  
import org.opensearch.index.shard.IndexShard;
        });  
import org.opensearch.bootstrap.BootstrapContext;
        try (Node node = new MockNode(settings.build(), basePlugins())) {
        running.await();
        // Test file cache is initialized
/*  
            NamedWriteableRegistry namedWriteableRegistry,
@LuceneTestCase.SuppressFileSystems(value = "ExtrasFS")
            TelemetryAwarePlugin telemetryAwarePlugin = node.getPluginsService().filterPlugins(TelemetryAwarePlugin.class).get(0);  
            assertThat(circuitBreaker.getName(), equalTo("test_breaker"));
        ) {  
        if (name != null) {
    public static class MockCircuitBreakerPlugin extends Plugin implements CircuitBreakerPlugin {
    public void testCloseOnInterruptibleTask() throws Exception {
import org.opensearch.monitor.fs.FsProbe;  
import org.opensearch.common.SetOnce;
        Node node = new MockNode(baseSettings().build(), basePlugins());
import org.opensearch.indices.IndicesService;  
        AtomicBoolean shouldRun = new AtomicBoolean(true);  
        assertAcked(
    public void testCloseRaceWithTaskExecution() throws Exception {
            ThreadPool threadPool = mockNode.injector().getInstance(ThreadPool.class);
            }
        try (Node node = new MockNode(settings.build(), plugins)) {
import java.util.List;
        threadpool.executor(ThreadPool.Names.SEARCH).execute(() -> {
            ScriptService scriptService,  

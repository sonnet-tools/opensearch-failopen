        assertEquals("it is forbidden to set both [discovery.seed_providers] and [discovery.zen.hosts_provider]", e.getMessage());
        }
            created1.set(true);
    private GatewayMetaState gatewayMetaState;
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
    public void testSettingsSeedsProvider() {
 * Licensed to Elasticsearch under one or more contributor
        when(threadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
            created3.set(true);
    public void testMultipleSeedsProviders() {
import org.opensearch.common.util.concurrent.ThreadContext;
public class DiscoveryModuleTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),
        assertFalse(created2.get());
            return hostsResolver -> Collections.emptyList();
    public void testJoinValidator() {
import org.opensearch.common.network.NetworkService;
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.routing.RerouteService;
        });
import java.util.Arrays;
            gatewayMetaState,
        assertWarnings(
    }
            NetworkService networkService
        assertTrue(created3.get());
 * license agreements. See the NOTICE file distributed with
        AtomicBoolean created2 = new AtomicBoolean(false);
        DiscoveryModule module = newModule(Settings.EMPTY, Collections.emptyList());
import org.opensearch.cluster.ClusterManagerMetrics;
import org.opensearch.common.util.io.IOUtils;
 *
        threadPool = mock(ThreadPool.class);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> newModule(Settings.EMPTY, Arrays.asList(plugin)));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> newModule(settings, Collections.emptyList()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            created2.set(true);
    private ClusterApplier clusterApplier;
        DummyHostsProviderPlugin plugin = () -> Collections.singletonMap("custom", () -> {
        Map<String, Supplier<SeedHostsProvider>> impl();
                public BiConsumer<DiscoveryNode, ClusterState> getJoinValidator() {
        IllegalArgumentException e = expectThrows(
            remoteStoreNodeService,
    public void clearDummyServices() throws IOException {
import org.opensearch.cluster.coordination.Coordinator;
import org.opensearch.cluster.coordination.PersistedStateRegistry;
        assertTrue(created1.get());
            throw new AssertionError("created hosts provider which was not selected");
        Settings settings = Settings.builder().put(DiscoveryModule.LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING.getKey(), "custom").build();
    public void testDefaults() {
            transportService,
        Settings settings = Settings.builder()
import org.opensearch.cluster.service.ClusterManagerService;
        ) {
        assertEquals("Unknown discovery type [dne]", e.getMessage());
 * Modifications Copyright OpenSearch Contributors. See
        DiscoveryModule module = newModule(
    public void testLegacyAndNonLegacyProvidersRejected() {
    @Before
import java.util.function.Supplier;
        DummyHostsProviderPlugin plugin2 = () -> Collections.singletonMap("dup", () -> null);
import org.opensearch.common.settings.ClusterSettings;
        DummyHostsProviderPlugin plugin3 = () -> Collections.singletonMap("provider3", () -> {
import java.util.Collection;
    private RemoteStoreNodeService remoteStoreNodeService;
import java.util.List;
            created.set(true);
/*
        AtomicBoolean created = new AtomicBoolean(false);
            return hostsResolver -> Collections.emptyList();
            settings,
            Collections.singletonList(new DiscoveryPlugin() {
        Settings settings = Settings.builder().put(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "dne").build();
            return hostsResolver -> Collections.emptyList();
    public void testUnknownSeedsProvider() {
    }
    }
 * ownership. Elasticsearch licenses this file to you under
        assertEquals("Unknown seed providers [dne]", e.getMessage());
import org.opensearch.gateway.GatewayMetaState;
        DummyHostsProviderPlugin plugin = () -> Collections.singletonMap("settings", () -> null);
        DummyHostsProviderPlugin plugin = () -> Collections.singletonMap("custom", () -> {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> newModule(settings, Collections.emptyList()));
    private ThreadPool threadPool;
/*
 * not use this file except in compliance with the License.
        BiConsumer<DiscoveryNode, ClusterState> consumer = (a, b) -> {};
                @Override
    private ClusterManagerService clusterManagerService;
 * KIND, either express or implied.  See the License for the
        AtomicBoolean created1 = new AtomicBoolean(false);
            threadPool,
        assertEquals("Cannot register seed provider [dup] twice", e.getMessage());
        newModule(settings, Collections.singletonList(plugin));
    public void testSeedProviders() {
        AtomicBoolean created = new AtomicBoolean(false);
 * GitHub history for details.
    private ClusterSettings clusterSettings;
            .build();
            .putList(DiscoveryModule.LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING.getKey())
        Coordinator discovery = (Coordinator) module.getDiscovery();
    public void setupDummyServices() {
        });
        transportService = MockTransportService.createNewService(Settings.EMPTY, Version.CURRENT, threadPool, NoopTracer.INSTANCE);
        clusterManagerService = mock(ClusterManagerService.class);
import org.opensearch.transport.TransportService;
        assertTrue(created.get());
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            null,
        );
            .putList(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey())
 */
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> newModule(settings, Collections.emptyList()));
import org.junit.After;
        Collection<BiConsumer<DiscoveryNode, ClusterState>> onJoinValidators = discovery.getOnJoinValidators();
            })
            clusterApplier,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.node.remotestore.RemoteStoreNodeService;
        });
    }
        gatewayMetaState = mock(GatewayMetaState.class);
}
import java.io.IOException;
                    return consumer;
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
/*
    }
import org.opensearch.plugins.DiscoveryPlugin;
        clusterApplier = mock(ClusterApplier.class);
    }
            () -> newModule(Settings.EMPTY, Arrays.asList(plugin1, plugin2))
import java.util.function.BiConsumer;
    public interface DummyHostsProviderPlugin extends DiscoveryPlugin {
    }
            return impl();
    public void testDuplicateSeedsProvider() {
import org.opensearch.Version;
import org.junit.Before;
        DummyHostsProviderPlugin plugin1 = () -> Collections.singletonMap("dup", () -> null);
        newModule(Settings.EMPTY, Collections.singletonList(plugin));
        });
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    private DiscoveryModule newModule(Settings settings, List<DiscoveryPlugin> plugins) {
    }
            created.set(true);
    }
        AtomicBoolean created3 = new AtomicBoolean(false);
            Settings.builder().put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.ZEN2_DISCOVERY_TYPE).build(),
            TransportService transportService,
        Settings settings = Settings.builder().put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), "dne").build();
 *
    }
            return hostsResolver -> Collections.emptyList();
    }
        return new DiscoveryModule(
 * the Apache License, Version 2.0 (the "License"); you may
                }
            IllegalArgumentException.class,
    }
            new PersistedStateRegistry(),
    private TransportService transportService;
    @After
    }
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
    }
            .putList(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "provider1", "provider3")
 * under the License.
        namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());
 */
        assertTrue(onJoinValidators.contains(consumer));
    public void testLazyConstructionSeedsProvider() {
            plugins,
        });
        DummyHostsProviderPlugin plugin2 = () -> Collections.singletonMap("provider2", () -> {
        assertEquals(2, onJoinValidators.size());
        );
 * specific language governing permissions and limitations
        Settings settings = Settings.builder()
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    private NamedWriteableRegistry namedWriteableRegistry;
 * The OpenSearch Contributors require contributions made to
        });
package org.opensearch.discovery;
import org.opensearch.threadpool.ThreadPool;
import java.util.concurrent.atomic.AtomicBoolean;
            createTempDir().toAbsolutePath(),
 * SPDX-License-Identifier: Apache-2.0
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.Settings;
        assertEquals("Cannot register seed provider [settings] twice", e.getMessage());
            clusterManagerService,
        IOUtils.close(transportService);
        default Map<String, Supplier<SeedHostsProvider>> getSeedHostProviders(
                + "See the breaking changes documentation for the next major version."
            clusterSettings,
        @Override
        DummyHostsProviderPlugin plugin = () -> Collections.singletonMap("custom", () -> {
            return hostsResolver -> Collections.emptyList();
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
        newModule(settings, Collections.singletonList(plugin));
    }
 */
        newModule(settings, Arrays.asList(plugin1, plugin2, plugin3));
            mock(RerouteService.class),
import java.util.Map;
 *
import org.opensearch.test.transport.MockTransportService;
        remoteStoreNodeService = mock(RemoteStoreNodeService.class);
        assertTrue(created.get());
            null,
import java.util.Collections;
        );
        assertTrue(module.getDiscovery() instanceof Coordinator);
    public void testLegacyHostsProvider() {
 * compatible open source license.
import org.opensearch.cluster.service.ClusterApplier;
    public void testUnknownDiscovery() {
            namedWriteableRegistry,
            null
        Settings settings = Settings.builder().put(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "custom").build();
            null,
        DummyHostsProviderPlugin plugin1 = () -> Collections.singletonMap("provider1", () -> {
            .build();
            "[discovery.zen.hosts_provider] setting was deprecated in OpenSearch and will be removed in a future release! "

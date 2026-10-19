import org.opensearch.cluster.node.DiscoveryNode;
    }
    private ClusterApplier clusterApplier;  
        newModule(Settings.EMPTY, Collections.singletonList(plugin));
            return hostsResolver -> Collections.emptyList();
            gatewayMetaState,
import java.util.function.Supplier;
import org.opensearch.plugins.DiscoveryPlugin;
        newModule(settings, Collections.singletonList(plugin));  
            namedWriteableRegistry,  
        assertEquals("Unknown seed providers [dne]", e.getMessage());
 * the Apache License, Version 2.0 (the "License"); you may
        Settings settings = Settings.builder().put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), "dne").build();  
            return hostsResolver -> Collections.emptyList();
 * license agreements. See the NOTICE file distributed with
    public void testSettingsSeedsProvider() {
    private ThreadPool threadPool;
        DummyHostsProviderPlugin plugin2 = () -> Collections.singletonMap("dup", () -> null);  
public class DiscoveryModuleTests extends OpenSearchTestCase {
import java.util.Arrays;
import org.opensearch.common.network.NetworkService;  
    public void testUnknownSeedsProvider() {
    }
    }
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            return impl();  
    public void setupDummyServices() {
    private ClusterManagerService clusterManagerService;
import java.util.Collections;  
            mock(RerouteService.class),  
            clusterManagerService,
    }  
import static org.mockito.Mockito.when;
        DummyHostsProviderPlugin plugin = () -> Collections.singletonMap("custom", () -> {
            throw new AssertionError("created hosts provider which was not selected");
    }
    private TransportService transportService;  
import org.opensearch.test.transport.MockTransportService;  
        });
            "[discovery.zen.hosts_provider] setting was deprecated in OpenSearch and will be removed in a future release! "
        Collection<BiConsumer<DiscoveryNode, ClusterState>> onJoinValidators = discovery.getOnJoinValidators();
        DummyHostsProviderPlugin plugin1 = () -> Collections.singletonMap("provider1", () -> {
            created.set(true);
 * The OpenSearch Contributors require contributions made to  
            created2.set(true);
            return hostsResolver -> Collections.emptyList();  
/*  
        assertEquals(2, onJoinValidators.size());
import org.opensearch.cluster.coordination.Coordinator;  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.Version;  
        );
        transportService = MockTransportService.createNewService(Settings.EMPTY, Version.CURRENT, threadPool, NoopTracer.INSTANCE);
        DiscoveryModule module = newModule(Settings.EMPTY, Collections.emptyList());
        );
import org.opensearch.cluster.coordination.PersistedStateRegistry;
        assertEquals("Unknown discovery type [dne]", e.getMessage());
            null
import org.opensearch.gateway.GatewayMetaState;  
        Settings settings = Settings.builder().put(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "custom").build();  
    }
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;  
            return hostsResolver -> Collections.emptyList();
            .putList(DiscoveryModule.LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING.getKey())
 * ownership. Elasticsearch licenses this file to you under  
        Settings settings = Settings.builder()
        assertWarnings(
 * KIND, either express or implied.  See the License for the
        assertTrue(onJoinValidators.contains(consumer));  
 */
    private NamedWriteableRegistry namedWriteableRegistry;
        }
    public interface DummyHostsProviderPlugin extends DiscoveryPlugin {
        DummyHostsProviderPlugin plugin1 = () -> Collections.singletonMap("dup", () -> null);
        gatewayMetaState = mock(GatewayMetaState.class);
/*
        Settings settings = Settings.builder()  
 * GitHub history for details.
 * under the License.  
        assertTrue(created.get());  
    public void testMultipleSeedsProviders() {
import org.opensearch.threadpool.ThreadPool;
 * this work for additional information regarding copyright
import org.opensearch.common.settings.ClusterSettings;
                    return consumer;
            threadPool,
            clusterSettings,
    private RemoteStoreNodeService remoteStoreNodeService;
    private DiscoveryModule newModule(Settings settings, List<DiscoveryPlugin> plugins) {
    @Before
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> newModule(settings, Collections.emptyList()));  
            null,  
    public void clearDummyServices() throws IOException {  
    @After
        Settings settings = Settings.builder().put(DiscoveryModule.LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING.getKey(), "custom").build();
        clusterManagerService = mock(ClusterManagerService.class);  
            TransportService transportService,  
        AtomicBoolean created1 = new AtomicBoolean(false);  
        DummyHostsProviderPlugin plugin2 = () -> Collections.singletonMap("provider2", () -> {  
        DummyHostsProviderPlugin plugin = () -> Collections.singletonMap("settings", () -> null);  
import java.util.Map;
    public void testLazyConstructionSeedsProvider() {  
        DummyHostsProviderPlugin plugin = () -> Collections.singletonMap("custom", () -> {
 * Modifications Copyright OpenSearch Contributors. See  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> newModule(Settings.EMPTY, Arrays.asList(plugin)));
import org.opensearch.cluster.service.ClusterApplier;
                public BiConsumer<DiscoveryNode, ClusterState> getJoinValidator() {
    }
    }
            null,
import org.opensearch.common.util.concurrent.ThreadContext;  
    public void testUnknownDiscovery() {
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.ClusterManagerMetrics;
 *  
    }  
import java.util.Collection;
 *    http://www.apache.org/licenses/LICENSE-2.0
        threadPool = mock(ThreadPool.class);  
        IOUtils.close(transportService);
import org.opensearch.cluster.service.ClusterManagerService;
        ) {
        assertEquals("Cannot register seed provider [dup] twice", e.getMessage());
        default Map<String, Supplier<SeedHostsProvider>> getSeedHostProviders(
    }  
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
        AtomicBoolean created = new AtomicBoolean(false);  
    }
import org.junit.Before;
        assertEquals("it is forbidden to set both [discovery.seed_providers] and [discovery.zen.hosts_provider]", e.getMessage());
        IllegalArgumentException e = expectThrows(
            .build();
import static org.mockito.Mockito.mock;
            created1.set(true);
import java.util.List;
        @Override
        Settings settings = Settings.builder().put(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "dne").build();
        AtomicBoolean created2 = new AtomicBoolean(false);
        Coordinator discovery = (Coordinator) module.getDiscovery();  
            plugins,
        BiConsumer<DiscoveryNode, ClusterState> consumer = (a, b) -> {};
 * Unless required by applicable law or agreed to in writing,
    public void testLegacyHostsProvider() {
    private ClusterSettings clusterSettings;
    public void testDuplicateSeedsProvider() {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> newModule(settings, Collections.emptyList()));  
import org.junit.After;  
        assertTrue(created1.get());
 *
            return hostsResolver -> Collections.emptyList();  
        assertTrue(module.getDiscovery() instanceof Coordinator);
    private GatewayMetaState gatewayMetaState;  
            transportService,
            Collections.singletonList(new DiscoveryPlugin() {
        });  
 * You may obtain a copy of the License at  
        newModule(settings, Collections.singletonList(plugin));
import org.opensearch.cluster.routing.RerouteService;  
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.atomic.AtomicBoolean;  
            created.set(true);  
            NetworkService networkService
 * software distributed under the License is distributed on an
            remoteStoreNodeService,  
        return new DiscoveryModule(
 *
    public void testJoinValidator() {
    }
            .putList(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "provider1", "provider3")
 * Licensed to Elasticsearch under one or more contributor  
        assertTrue(created3.get());  
    public void testDefaults() {  
        DiscoveryModule module = newModule(  
        namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());
 * specific language governing permissions and limitations
    public void testSeedProviders() {
        AtomicBoolean created = new AtomicBoolean(false);
        });
        Map<String, Supplier<SeedHostsProvider>> impl();
package org.opensearch.discovery;
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        });  
            settings,  
        newModule(settings, Arrays.asList(plugin1, plugin2, plugin3));  
                + "See the breaking changes documentation for the next major version."  
import java.io.IOException;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        when(threadPool.getThreadContext()).thenReturn(new ThreadContext(Settings.EMPTY));
            .putList(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey())  
import java.util.function.BiConsumer;
        AtomicBoolean created3 = new AtomicBoolean(false);
            createTempDir().toAbsolutePath(),
        assertTrue(created.get());
                @Override  
            null,
        assertFalse(created2.get());
    }  
        clusterApplier = mock(ClusterApplier.class);
        });
    }  
            IllegalArgumentException.class,
 * this file be licensed under the Apache-2.0 license or a
            })
/*
import org.opensearch.transport.TransportService;
        remoteStoreNodeService = mock(RemoteStoreNodeService.class);
 */
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> newModule(settings, Collections.emptyList()));
    public void testLegacyAndNonLegacyProvidersRejected() {
            new PersistedStateRegistry(),
        DummyHostsProviderPlugin plugin = () -> Collections.singletonMap("custom", () -> {
            clusterApplier,  
        );  
        assertEquals("Cannot register seed provider [settings] twice", e.getMessage());
}
        });
import org.opensearch.cluster.ClusterState;
            () -> newModule(Settings.EMPTY, Arrays.asList(plugin1, plugin2))  
            .build();
        DummyHostsProviderPlugin plugin3 = () -> Collections.singletonMap("provider3", () -> {
    }
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            created3.set(true);  
 */  
 * compatible open source license.
            Settings.builder().put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.ZEN2_DISCOVERY_TYPE).build(),
                }  
import org.opensearch.common.util.io.IOUtils;

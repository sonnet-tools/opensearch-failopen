        );
                    .build()
import java.util.Collection;
import org.opensearch.common.util.concurrent.ThreadContext;
        @Override
import org.opensearch.common.settings.Setting.Property;
                e.getMessage(),
 * the Apache License, Version 2.0 (the "License"); you may
        }
        FakeExpressionResolver customResolver2 = new FakeExpressionResolver();
            clusterInfoService,
            public Collection<AllocationDecider> createAllocationDeciders(Settings settings, ClusterSettings clusterSettings) {
        assertTrue(module.deciderList.stream().anyMatch(d -> d.getClass().equals(FakeAllocationDecider.class)));
 * specific language governing permissions and limitations
    // changed in the test too.
            null,
        IllegalArgumentException e = expectThrows(
            NodeLoadAwareAllocationDecider.class,
                clusterPlugins,
        assertEquals("ShardsAllocator [" + ClusterModule.BALANCED_ALLOCATOR + "] already defined", e.getMessage());
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
            throw new UnsupportedOperationException("resolve operation not supported on FakeExpressionResolver");
            SameShardAllocationDecider.class,
    }
        clusterModule.setRerouteServiceForAllocator((reason, priority, listener) -> listener.onResponse(clusterService.state()));
import org.opensearch.common.settings.IndexScopedSettings;
                    entry -> entry.categoryClass == Metadata.Custom.class
            Collections.singletonList(existingShardsAllocatorPlugin(GatewayAllocator.ALLOCATOR_NAME)),
            WarmDiskThresholdDecider.class,
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        @Override
import org.opensearch.cluster.routing.allocation.decider.RebalanceOnlyWhenActiveAllocationDecider;
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            DiskThresholdDecider.class,
    public void testRegisterShardsAllocator() {
                clusterInfoService,
                new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),
            Settings.EMPTY,
import org.opensearch.common.settings.Setting;
        FakeExpressionResolver customResolver1 = new FakeExpressionResolver();
        );
        }), clusterInfoService, null, threadContext, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE), ShardStateAction.class);
            clusterService,
            () -> clusterModule.setExistingShardsAllocators(new TestGatewayAllocator(), new TestShardBatchGatewayAllocator())
                ShardStateAction.class
    }
            () -> new ClusterModule(
            clusterPlugins,
    private static ClusterPlugin existingShardsAllocatorPlugin(final String allocatorName) {
    public void testRegisterIndexDynamicSetting() {
    private final ClusterInfoService clusterInfoService = EmptyClusterInfoService.INSTANCE;
            throw new UnsupportedOperationException("resolve operation not supported on FakeExpressionResolver");
import org.opensearch.cluster.action.shard.ShardStateAction;
            public Collection<IndexNameExpressionResolver.ExpressionResolver> getIndexNameCustomResolvers() {
            Settings.EMPTY,
            IllegalArgumentException.class,
        );
import java.util.Collections;
            DeploymentAllocationDecider.class,
import org.opensearch.cluster.routing.allocation.decider.SnapshotInProgressAllocationDecider;
import org.opensearch.plugins.ClusterPlugin;
            assertEquals(
 * compatible open source license.
    static class FakeExpressionResolver implements IndexNameExpressionResolver.ExpressionResolver {
            null
            throw new UnsupportedOperationException("explain API not supported on FakeShardsAllocator");
        }), clusterInfoService, null, threadContext, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE), ShardStateAction.class);
import java.util.List;
            .metadata(
    public void testRegisterShardsAllocatorAlreadyRegistered() {
import org.opensearch.cluster.routing.ShardRouting;
        ClusterModule clusterModule = new ClusterModule(
        }
            @Override
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
        );
        });
    }
            TargetPoolAllocationDecider.class,
    public void tearDown() throws Exception {
import org.opensearch.cluster.routing.allocation.decider.WarmDiskThresholdDecider;
        public ShardAllocationDecision decideShardAllocation(ShardRouting shard, RoutingAllocation allocation) {
    }
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
        assertEquals(FakeShardsAllocator.class, module.shardsAllocator.getClass());
            .putCustom("other", new RestoreInProgress.Builder().build())
        List<Class<? extends AllocationDecider>> expectedDeciders = Arrays.asList(
    // makes sure that the allocation deciders are setup in the correct order, such that the
    }
 * software distributed under the License is distributed on an
            .build();
            () -> new ClusterModule(Settings.EMPTY, clusterService, Collections.<ClusterPlugin>singletonList(new ClusterPlugin() {
                    return Collections.singletonList(new EnableAllocationDecider(settings, clusterSettings));
    public void testRegisterAllocationDeciderDuplicate() {
        public List<String> resolve(IndexNameExpressionResolver.Context context, List<String> expressions) {
    // slower allocation deciders come last and we can exit early if there is a NO decision without
        );
import org.opensearch.cluster.deployment.DeploymentAllocationDecider;
    }
        IllegalArgumentException e = expectThrows(
 *
        SettingsModule module = new SettingsModule(
        final ClusterModule clusterModule = new ClusterModule(
            Settings.EMPTY,
    public void testPre63CustomsFiltering() {
            Setting.boolSetting("foo.bar", false, Property.Dynamic, Property.NodeScope)
            )
            )
            () -> new ClusterModule(
        final ClusterState fixedClusterState = ClusterModule.filterCustomsForPre63Clients(clusterState);
        assertInstanceBinding(module, IndexScopedSettings.class, service -> service.isDynamicSetting("index.foo.bar"));
import org.opensearch.cluster.routing.allocation.decider.ReplicaAfterPrimaryActiveAllocationDecider;
            @Override
            () -> newClusterModuleWithShardsAllocator(Settings.EMPTY, ClusterModule.BALANCED_ALLOCATOR, FakeShardsAllocator::new)
            ShardStateAction.class
        assertNull(fixedClusterState.metadata().custom("other"));
        } catch (IllegalArgumentException e) {
            clusterService,
import org.opensearch.test.gateway.TestShardBatchGatewayAllocator;
    public void testRerouteServiceSetForBalancedShardsAllocator() {
        public List<String> resolve(IndexNameExpressionResolver.Context context, List<String> expressions) {
                )
        IllegalArgumentException ex = expectThrows(
/*
            EnableAllocationDecider.class,
    public void setUp() throws Exception {
            IllegalArgumentException.class,
        Settings settings = Settings.builder().put(ClusterModule.SHARDS_ALLOCATOR_TYPE_SETTING.getKey(), "bad").build();
        );
 * You may obtain a copy of the License at
 * The OpenSearch Contributors require contributions made to
            ResizeAllocationDecider.class,
                null,
    public void testUnknownShardsAllocator() {
    public void testRegisterCustomExpressionResolver() {
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            AwarenessAllocationDecider.class,
        }
            clusterInfoService,
    }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        List<ClusterPlugin> clusterPlugins = Collections.singletonList(new ClusterPlugin() {
            ShardStateAction.class
    }
        final ClusterModule clusterModule = new ClusterModule(
        List<NamedXContentRegistry.Entry> customXEntries = ClusterModule.getNamedXWriteables();
            ex.getMessage()
            }), clusterInfoService, null, threadContext, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE), ShardStateAction.class)
        assertTrue(module.getIndexNameExpressionResolver().getExpressionResolvers().contains(customResolver1));
                "Cannot register setting [" + EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey() + "] twice"
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;
import java.util.function.Supplier;
import org.opensearch.cluster.routing.allocation.decider.RestoreInProgressAllocationDecider;
            IllegalArgumentException.class,
            Settings.EMPTY,
            @Override
            IllegalArgumentException.class,
            threadContext,
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),
            }
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.service.ClusterService;
            "Cannot specify expression resolver [org.opensearch.cluster.ClusterModuleTests$FakeExpressionResolver] twice",
        assertEquals(
 * GitHub history for details.
                        && entry.name.getPreferredName().equals(WorkloadGroupMetadata.TYPE)
        expectThrows(
        @Override
        assertNull(fixedClusterState.custom("other"));
    }
            ConcurrentRebalanceAllocationDecider.class,
    }
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
            public Collection<IndexNameExpressionResolver.ExpressionResolver> getIndexNameCustomResolvers() {
        assertNotNull(clusterState.custom(allowListedClusterCustom));
        assertNotNull(fixedClusterState.custom(allowListedClusterCustom));
            assertSame(decider.getClass(), expectedDeciders.get(idx++));
            Collections.emptyList(),
                return Arrays.asList(customResolver1, customResolver2);
        Collection<AllocationDecider> deciders = ClusterModule.createAllocationDeciders(
        assertEquals(e.getMessage(), "Cannot specify allocation decider [" + EnableAllocationDecider.class.getName() + "] twice");
import org.opensearch.common.inject.ModuleTestCase;
                @Override
            ConcurrentRecoveriesAllocationDecider.class,
            Settings.EMPTY,
                null,
    public void testRegisterClusterDynamicSettingDuplicate() {
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
                clusterService,
        ClusterModule module = new ClusterModule(
    private ClusterModule newClusterModuleWithShardsAllocator(Settings settings, String name, Supplier<ShardsAllocator> supplier) {
            threadContext,
            IllegalArgumentException.class,
            ShardStateAction.class
            FilterAllocationDecider.class,
import org.opensearch.cluster.routing.allocation.decider.TargetPoolAllocationDecider;
            null,
            customEntries.stream()
public class ClusterModuleTests extends ModuleTestCase {
import org.opensearch.core.xcontent.NamedXContentRegistry;
        int idx = 0;
        assertEquals("Unknown ShardsAllocator [dne]", e.getMessage());
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRecoveriesAllocationDecider;
        }
    }
        return new ClusterPlugin() {
            @Override
 * license agreements. See the NOTICE file distributed with
        IllegalArgumentException e = expectThrows(
            public Map<String, Supplier<ShardsAllocator>> getShardsAllocators(Settings settings, ClusterSettings clusterSettings) {
        assertNotNull(clusterState.custom("other"));
                return Collections.singletonMap(name, supplier);
        protected FakeAllocationDecider() {}
 */
        assertTrue(module.getIndexNameExpressionResolver().getExpressionResolvers().contains(customResolver2));
        ClusterModule module = newClusterModuleWithShardsAllocator(settings, "custom", FakeShardsAllocator::new);
        @Override
import org.opensearch.test.ClusterServiceUtils;
    }
        assertTrue(
    public void testRejectsReservedExistingShardsAllocatorName() {
            // noop
    }
    static class AnotherFakeExpressionResolver implements IndexNameExpressionResolver.ExpressionResolver {
        threadContext = new ThreadContext(Settings.EMPTY);
            RestoreInProgressAllocationDecider.class,
        clusterService.close();
            );
            SnapshotInProgressAllocationDecider.class,
                ShardStateAction.class
        );
        List<NamedWriteableRegistry.Entry> customEntries = ClusterModule.getNamedWriteables();
        final String allowListedClusterCustom = randomFrom(ClusterModule.PRE_6_3_CLUSTER_CUSTOMS_WHITE_LIST);
    public void testRegisterIndexDynamicSettingDuplicate() {
            );
        super.setUp();
            AllocationDecider decider = iter.next();
            ThrottlingAllocationDecider.class,
import org.opensearch.cluster.routing.allocation.decider.NodeVersionAllocationDecider;
        }
        AnotherFakeExpressionResolver customResolver2 = new AnotherFakeExpressionResolver();
    public void testRegisterClusterDynamicSetting() {
                return Collections.singletonList(new FakeAllocationDecider());
    private ClusterService clusterService;
                .anyMatch(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
    public void testRejectsDuplicateExistingShardsAllocatorName() {
    public void testRegisterCustomExpressionResolverDuplicate() {
    public void testRegisterAllocationDecider() {
            @Override
            null,
        );
    }
        try {
    }
            Arrays.asList(existingShardsAllocatorPlugin("duplicate"), existingShardsAllocatorPlugin("duplicate")),
import org.opensearch.cluster.metadata.RepositoriesMetadata;
            }
    }
            null,
            customXEntries.stream()
import org.opensearch.common.settings.SettingsModule;
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRebalanceAllocationDecider;
        SettingsModule module = new SettingsModule(
 * not use this file except in compliance with the License.
        try {
import org.opensearch.cluster.routing.allocation.decider.ResizeAllocationDecider;
            SearchReplicaAllocationDecider.class,
import org.opensearch.common.settings.ClusterSettings;
        Iterator<AllocationDecider> iter = deciders.iterator();
                Metadata.builder()
            clusterInfoService,
        assertNotNull(fixedClusterState.metadata().custom(allowListedMetadataCustom));
                threadContext,
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
    }
    }
    private ThreadContext threadContext;
            }
            }
import org.opensearch.cluster.routing.allocation.decider.DiskThresholdDecider;
        );
            new SettingsModule(Settings.EMPTY, EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING);
                Settings.EMPTY,
        );
    }
 * KIND, either express or implied.  See the License for the
        );
import java.util.Iterator;
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),
    }
                    .putCustom("other", new RepositoriesMetadata(Collections.emptyList()))
            clusterService,
        );
        assertTrue(
    // running them. If the order of the deciders is changed for a valid reason, the order should be
 * under the License.
 * Modifications Copyright OpenSearch Contributors. See
 */
                Collections.emptyList(),
    }
    }
        );
            Settings.EMPTY,
        Settings settings = Settings.builder().put(ClusterModule.SHARDS_ALLOCATOR_TYPE_SETTING.getKey(), "dne").build();
            Collections.emptyList()
import org.opensearch.cluster.routing.allocation.decider.NodeLoadAwareAllocationDecider;
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
/*
}
        );
        while (iter.hasNext()) {
        expectThrows(
    }
                e.getMessage(),
            RemoteStoreMigrationAllocationDecider.class
            RebalanceOnlyWhenActiveAllocationDecider.class,
                null,
        assertInstanceBinding(module, ClusterSettings.class, service -> service.isDynamicSetting("foo.bar"));
            }
 * Licensed to Elasticsearch under one or more contributor
        final String allowListedMetadataCustom = randomFrom(ClusterModule.PRE_6_3_METADATA_CUSTOMS_WHITE_LIST);
                return Arrays.asList(customResolver1, customResolver2);
            clusterInfoService,
            NodeVersionAllocationDecider.class,
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
 *
            public Map<String, ExistingShardsAllocator> getExistingShardsAllocators() {
        }
            threadContext,
    public void testAllocationDeciderOrder() {
        );
                    .putCustom(allowListedMetadataCustom, new RepositoriesMetadata(Collections.emptyList()))
        };
 *
                settings,
            .putCustom(allowListedClusterCustom, new RestoreInProgress.Builder().build())
            ShardsLimitAllocationDecider.class,
                clusterService,
            MaxRetryAllocationDecider.class,
import org.opensearch.gateway.GatewayAllocator;
                threadContext,
    }
            null,
import org.opensearch.cluster.metadata.Metadata;
        clusterService = ClusterServiceUtils.createClusterService(
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),
                "Cannot register setting [" + EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey() + "] twice"
import org.opensearch.cluster.metadata.WorkloadGroupMetadata;
 */
                public Collection<AllocationDecider> createAllocationDeciders(Settings settings, ClusterSettings clusterSettings) {
        public void allocate(RoutingAllocation allocation) {
            threadContext,
            ReplicaAfterPrimaryActiveAllocationDecider.class,
                }
        );
import org.opensearch.cluster.routing.allocation.decider.RemoteStoreMigrationAllocationDecider;
        }
            IllegalArgumentException.class,
import org.opensearch.cluster.routing.allocation.decider.SearchReplicaAllocationDecider;
            assertEquals(
            Settings.EMPTY,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        return new ClusterModule(settings, clusterService, Collections.singletonList(new ClusterPlugin() {
        } catch (IllegalArgumentException e) {
            ClusterRebalanceAllocationDecider.class,
            new SettingsModule(Settings.EMPTY, EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING);
                clusterInfoService,
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
    @Override
 * SPDX-License-Identifier: Apache-2.0
        );
    public void testWorkloadGroupMetadataRegister() {
            ShardStateAction.class
        FakeExpressionResolver customResolver1 = new FakeExpressionResolver();
        );
        assertNotNull(clusterState.metadata().custom("other"));
            Settings.EMPTY,
    @Override
 * this file be licensed under the Apache-2.0 license or a
            () -> clusterModule.setExistingShardsAllocators(new TestGatewayAllocator(), new TestShardBatchGatewayAllocator())
package org.opensearch.cluster;
                .anyMatch(entry -> entry.categoryClass == Metadata.Custom.class && entry.name.equals(WorkloadGroupMetadata.TYPE))
 * ownership. Elasticsearch licenses this file to you under
        assertNotNull(clusterState.metadata().custom(allowListedMetadataCustom));
import org.opensearch.test.gateway.TestGatewayAllocator;
 * this work for additional information regarding copyright
    }
        List<ClusterPlugin> clusterPlugins = Collections.singletonList(new ClusterPlugin() {
            Setting.boolSetting("index.foo.bar", false, Property.Dynamic, Property.IndexScope)
    static class FakeAllocationDecider extends AllocationDecider {
                return Collections.singletonMap(allocatorName, new TestGatewayAllocator());
        Settings settings = Settings.builder().put(ClusterModule.SHARDS_ALLOCATOR_TYPE_SETTING.getKey(), "custom").build();
 * Unless required by applicable law or agreed to in writing,
        expectThrows(NullPointerException.class, () -> newClusterModuleWithShardsAllocator(settings, "bad", () -> null));
        ClusterModule module = new ClusterModule(Settings.EMPTY, clusterService, Collections.singletonList(new ClusterPlugin() {
import java.util.Map;
        });
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            )
import java.util.Arrays;
    static class FakeShardsAllocator implements ShardsAllocator {
            clusterService,
        super.tearDown();
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
    public void testShardsAllocatorFactoryNull() {

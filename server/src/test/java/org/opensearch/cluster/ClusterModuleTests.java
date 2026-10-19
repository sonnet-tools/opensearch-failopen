                return Arrays.asList(customResolver1, customResolver2);
    }
 */  
    public void testAllocationDeciderOrder() {
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;  
    }
            Setting.boolSetting("foo.bar", false, Property.Dynamic, Property.NodeScope)
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),
            null,
            ResizeAllocationDecider.class,
import org.opensearch.test.gateway.TestGatewayAllocator;
            WarmDiskThresholdDecider.class,
            public Map<String, Supplier<ShardsAllocator>> getShardsAllocators(Settings settings, ClusterSettings clusterSettings) {  
    }  
import org.opensearch.cluster.service.ClusterService;
            NodeLoadAwareAllocationDecider.class,
 * compatible open source license.
            );
            SnapshotInProgressAllocationDecider.class,
    }  
                e.getMessage(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super.tearDown();
import org.opensearch.cluster.metadata.Metadata;
 * under the License.  
    public void testRegisterAllocationDecider() {
            TargetPoolAllocationDecider.class,  
    static class AnotherFakeExpressionResolver implements IndexNameExpressionResolver.ExpressionResolver {
                threadContext,  
import org.opensearch.common.settings.ClusterSettings;
        Collection<AllocationDecider> deciders = ClusterModule.createAllocationDeciders(
            clusterInfoService,
        );  
        Settings settings = Settings.builder().put(ClusterModule.SHARDS_ALLOCATOR_TYPE_SETTING.getKey(), "bad").build();  
        );
        public void allocate(RoutingAllocation allocation) {
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;
            .putCustom("other", new RestoreInProgress.Builder().build())
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;  
    @Override
        super.setUp();
import org.opensearch.cluster.deployment.DeploymentAllocationDecider;
            customEntries.stream()
import org.opensearch.common.settings.Settings;
import java.util.Collection;  
            SameShardAllocationDecider.class,
import org.opensearch.cluster.routing.allocation.decider.DiskThresholdDecider;
            FilterAllocationDecider.class,  
            threadContext,  
            DiskThresholdDecider.class,  
            IllegalArgumentException.class,
            DeploymentAllocationDecider.class,
 * Modifications Copyright OpenSearch Contributors. See
        assertNotNull(clusterState.metadata().custom("other"));
 * this file be licensed under the Apache-2.0 license or a
            Settings.EMPTY,
                return Arrays.asList(customResolver1, customResolver2);
            ThrottlingAllocationDecider.class,
        clusterModule.setRerouteServiceForAllocator((reason, priority, listener) -> listener.onResponse(clusterService.state()));
    public void setUp() throws Exception {
            () -> new ClusterModule(Settings.EMPTY, clusterService, Collections.<ClusterPlugin>singletonList(new ClusterPlugin() {
        IllegalArgumentException e = expectThrows(
        assertNotNull(clusterState.metadata().custom(allowListedMetadataCustom));  
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRecoveriesAllocationDecider;
            clusterPlugins,
        ClusterModule module = new ClusterModule(Settings.EMPTY, clusterService, Collections.singletonList(new ClusterPlugin() {  
            @Override
            public Collection<AllocationDecider> createAllocationDeciders(Settings settings, ClusterSettings clusterSettings) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    public void testRegisterCustomExpressionResolverDuplicate() {
import org.opensearch.gateway.GatewayAllocator;
    // running them. If the order of the deciders is changed for a valid reason, the order should be  
 *  
        assertNotNull(clusterState.custom("other"));
        );  
    }
        );
        );
    }
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
        IllegalArgumentException e = expectThrows(
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;  
    }  
import org.opensearch.common.util.concurrent.ThreadContext;
            threadContext,  
                    .putCustom("other", new RepositoriesMetadata(Collections.emptyList()))
    }
                null,
            Collections.singletonList(existingShardsAllocatorPlugin(GatewayAllocator.ALLOCATOR_NAME)),  
                clusterInfoService,
        Iterator<AllocationDecider> iter = deciders.iterator();  
    public void testRejectsReservedExistingShardsAllocatorName() {
    }
        );  
            }  
        @Override
            )  
            SearchReplicaAllocationDecider.class,
        return new ClusterModule(settings, clusterService, Collections.singletonList(new ClusterPlugin() {
    }
        assertEquals("ShardsAllocator [" + ClusterModule.BALANCED_ALLOCATOR + "] already defined", e.getMessage());
        );
        FakeExpressionResolver customResolver1 = new FakeExpressionResolver();
    private ThreadContext threadContext;
    static class FakeShardsAllocator implements ShardsAllocator {  
        assertNotNull(fixedClusterState.metadata().custom(allowListedMetadataCustom));
                clusterService,
            clusterInfoService,
    private final ClusterInfoService clusterInfoService = EmptyClusterInfoService.INSTANCE;
            )
                return Collections.singletonMap(allocatorName, new TestGatewayAllocator());
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
        assertTrue(
        List<ClusterPlugin> clusterPlugins = Collections.singletonList(new ClusterPlugin() {
import org.opensearch.core.xcontent.NamedXContentRegistry;  
            ShardsLimitAllocationDecider.class,  
        );
import java.util.function.Supplier;
/*
            "Cannot specify expression resolver [org.opensearch.cluster.ClusterModuleTests$FakeExpressionResolver] twice",  
    }  
        protected FakeAllocationDecider() {}  
            public Collection<IndexNameExpressionResolver.ExpressionResolver> getIndexNameCustomResolvers() {  
 * ownership. Elasticsearch licenses this file to you under  
        };
 * software distributed under the License is distributed on an
        Settings settings = Settings.builder().put(ClusterModule.SHARDS_ALLOCATOR_TYPE_SETTING.getKey(), "dne").build();  
            RestoreInProgressAllocationDecider.class,
            clusterService,
            ReplicaAfterPrimaryActiveAllocationDecider.class,  
            assertSame(decider.getClass(), expectedDeciders.get(idx++));
                null,
            public Collection<IndexNameExpressionResolver.ExpressionResolver> getIndexNameCustomResolvers() {
        assertEquals(FakeShardsAllocator.class, module.shardsAllocator.getClass());  
    private ClusterModule newClusterModuleWithShardsAllocator(Settings settings, String name, Supplier<ShardsAllocator> supplier) {  
        List<NamedWriteableRegistry.Entry> customEntries = ClusterModule.getNamedWriteables();
                new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),
        }), clusterInfoService, null, threadContext, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE), ShardStateAction.class);
 * license agreements. See the NOTICE file distributed with
            threadContext,
import java.util.List;  
            ShardStateAction.class
                @Override
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.routing.allocation.decider.SnapshotInProgressAllocationDecider;
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.ClusterServiceUtils;
import java.util.Arrays;
    }  
            new SettingsModule(Settings.EMPTY, EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING);
    public void testRegisterAllocationDeciderDuplicate() {
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
public class ClusterModuleTests extends ModuleTestCase {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            IllegalArgumentException.class,
/*  
        final String allowListedMetadataCustom = randomFrom(ClusterModule.PRE_6_3_METADATA_CUSTOMS_WHITE_LIST);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        SettingsModule module = new SettingsModule(  
import org.opensearch.cluster.routing.allocation.decider.WarmDiskThresholdDecider;
            }), clusterInfoService, null, threadContext, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE), ShardStateAction.class)  
        } catch (IllegalArgumentException e) {
        }
import org.opensearch.cluster.routing.allocation.decider.NodeVersionAllocationDecider;
        final String allowListedClusterCustom = randomFrom(ClusterModule.PRE_6_3_CLUSTER_CUSTOMS_WHITE_LIST);  
        final ClusterModule clusterModule = new ClusterModule(  
            }
            null,
            IllegalArgumentException.class,
            .build();
            throw new UnsupportedOperationException("resolve operation not supported on FakeExpressionResolver");  
                    .build()  
            Settings.EMPTY,  
 */
        FakeExpressionResolver customResolver2 = new FakeExpressionResolver();  
                "Cannot register setting [" + EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey() + "] twice"  
        );
    public void testShardsAllocatorFactoryNull() {
                return Collections.singletonMap(name, supplier);
        IllegalArgumentException ex = expectThrows(
        });
    public void testRegisterClusterDynamicSettingDuplicate() {
            );  
        }
 */  
                clusterService,
        );
 * not use this file except in compliance with the License.
            Settings.EMPTY,
    }
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
        int idx = 0;
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
                    .putCustom(allowListedMetadataCustom, new RepositoriesMetadata(Collections.emptyList()))
        assertInstanceBinding(module, ClusterSettings.class, service -> service.isDynamicSetting("foo.bar"));  
        );
    public void testRerouteServiceSetForBalancedShardsAllocator() {
        @Override
import org.opensearch.cluster.routing.allocation.decider.ResizeAllocationDecider;
            IllegalArgumentException.class,
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),  
                null,
    }
            throw new UnsupportedOperationException("resolve operation not supported on FakeExpressionResolver");
            null
                )
            ShardStateAction.class
import org.opensearch.test.gateway.TestShardBatchGatewayAllocator;  
import org.opensearch.common.settings.SettingsModule;  
        @Override
import org.opensearch.cluster.metadata.WorkloadGroupMetadata;  
            threadContext,
            assertEquals(
            Settings.EMPTY,
            IllegalArgumentException.class,  
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;  
        assertNotNull(clusterState.custom(allowListedClusterCustom));
        SettingsModule module = new SettingsModule(
        public List<String> resolve(IndexNameExpressionResolver.Context context, List<String> expressions) {
    }
                }
                Settings.EMPTY,
            () -> newClusterModuleWithShardsAllocator(Settings.EMPTY, ClusterModule.BALANCED_ALLOCATOR, FakeShardsAllocator::new)  
            throw new UnsupportedOperationException("explain API not supported on FakeShardsAllocator");
                Metadata.builder()  
            .putCustom(allowListedClusterCustom, new RestoreInProgress.Builder().build())  
    }  
            .metadata(
        assertTrue(module.getIndexNameExpressionResolver().getExpressionResolvers().contains(customResolver1));  
        return new ClusterPlugin() {
            clusterInfoService,  
 * this work for additional information regarding copyright
    public void testRegisterShardsAllocator() {  
                ShardStateAction.class
        );
        final ClusterState fixedClusterState = ClusterModule.filterCustomsForPre63Clients(clusterState);  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
            AllocationDecider decider = iter.next();  
            ex.getMessage()
import org.opensearch.cluster.routing.allocation.decider.RestoreInProgressAllocationDecider;  
            ClusterRebalanceAllocationDecider.class,
        );
            // noop  
    static class FakeAllocationDecider extends AllocationDecider {
        }), clusterInfoService, null, threadContext, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE), ShardStateAction.class);  
    // changed in the test too.
                .anyMatch(entry -> entry.categoryClass == Metadata.Custom.class && entry.name.equals(WorkloadGroupMetadata.TYPE))
    }
            () -> new ClusterModule(  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            AwarenessAllocationDecider.class,
                e.getMessage(),
import java.util.Collections;
                settings,
import org.opensearch.cluster.action.shard.ShardStateAction;
/*  
    @Override  
 *
            }  
            clusterService,
        assertNull(fixedClusterState.metadata().custom("other"));
            }
import org.opensearch.cluster.routing.allocation.decider.NodeLoadAwareAllocationDecider;  
                return Collections.singletonList(new FakeAllocationDecider());  
    public void testRegisterClusterDynamicSetting() {
            assertEquals(  
            Settings.EMPTY,  
                "Cannot register setting [" + EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey() + "] twice"
        ClusterModule module = newClusterModuleWithShardsAllocator(settings, "custom", FakeShardsAllocator::new);
        threadContext = new ThreadContext(Settings.EMPTY);  
import org.opensearch.cluster.routing.ShardRouting;
        @Override  
            @Override
            clusterService,
            clusterService,
            null,  
            @Override  
import java.util.Iterator;
    }  
            RebalanceOnlyWhenActiveAllocationDecider.class,
                    return Collections.singletonList(new EnableAllocationDecider(settings, clusterSettings));
        assertNotNull(fixedClusterState.custom(allowListedClusterCustom));
            Settings.EMPTY,  
 * SPDX-License-Identifier: Apache-2.0
        assertNull(fixedClusterState.custom("other"));  
            IllegalArgumentException.class,
        List<NamedXContentRegistry.Entry> customXEntries = ClusterModule.getNamedXWriteables();
        clusterService.close();
        );
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),
}
 * You may obtain a copy of the License at  
                public Collection<AllocationDecider> createAllocationDeciders(Settings settings, ClusterSettings clusterSettings) {  
 * specific language governing permissions and limitations
            ShardStateAction.class
                .anyMatch(
            Settings.EMPTY,
            () -> clusterModule.setExistingShardsAllocators(new TestGatewayAllocator(), new TestShardBatchGatewayAllocator())  
            Setting.boolSetting("index.foo.bar", false, Property.Dynamic, Property.IndexScope)
    // slower allocation deciders come last and we can exit early if there is a NO decision without
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        );  
    }
    }  
    private ClusterService clusterService;  
        assertInstanceBinding(module, IndexScopedSettings.class, service -> service.isDynamicSetting("index.foo.bar"));
        public List<String> resolve(IndexNameExpressionResolver.Context context, List<String> expressions) {  
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;  
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
        Settings settings = Settings.builder().put(ClusterModule.SHARDS_ALLOCATOR_TYPE_SETTING.getKey(), "custom").build();
        }
            null,
    // makes sure that the allocation deciders are setup in the correct order, such that the
                clusterInfoService,
import org.opensearch.cluster.metadata.RepositoriesMetadata;
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRebalanceAllocationDecider;  
            Arrays.asList(existingShardsAllocatorPlugin("duplicate"), existingShardsAllocatorPlugin("duplicate")),
            MaxRetryAllocationDecider.class,
            ConcurrentRecoveriesAllocationDecider.class,
            }
            Collections.emptyList()
            customXEntries.stream()  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
        public ShardAllocationDecision decideShardAllocation(ShardRouting shard, RoutingAllocation allocation) {
            EnableAllocationDecider.class,
import org.opensearch.cluster.routing.allocation.decider.TargetPoolAllocationDecider;
            ConcurrentRebalanceAllocationDecider.class,  
                    entry -> entry.categoryClass == Metadata.Custom.class
    public void testRegisterIndexDynamicSetting() {
            clusterInfoService,  
        }
            () -> new ClusterModule(  
import org.opensearch.common.settings.Setting.Property;
        assertEquals(
    public void testPre63CustomsFiltering() {
    public void testRegisterIndexDynamicSettingDuplicate() {  
import org.opensearch.cluster.routing.allocation.decider.SearchReplicaAllocationDecider;
import org.opensearch.cluster.routing.allocation.decider.ReplicaAfterPrimaryActiveAllocationDecider;
                clusterPlugins,  
    public void testRegisterShardsAllocatorAlreadyRegistered() {  
            )  
            ShardStateAction.class
        }
                ShardStateAction.class
import org.opensearch.common.settings.IndexScopedSettings;
    }  
        assertEquals(e.getMessage(), "Cannot specify allocation decider [" + EnableAllocationDecider.class.getName() + "] twice");
 *
        FakeExpressionResolver customResolver1 = new FakeExpressionResolver();  
    public void testWorkloadGroupMetadataRegister() {  
        );  
import java.util.Map;
        IllegalArgumentException e = expectThrows(
        expectThrows(  
        expectThrows(
        }  
        }
            null,
    public void testRejectsDuplicateExistingShardsAllocatorName() {
import org.opensearch.common.inject.ModuleTestCase;  
        try {  
        ClusterModule clusterModule = new ClusterModule(  
        });  
import org.opensearch.common.settings.Setting;  
        while (iter.hasNext()) {
    public void testRegisterCustomExpressionResolver() {
                Collections.emptyList(),  
    public void tearDown() throws Exception {  
    }  
    static class FakeExpressionResolver implements IndexNameExpressionResolver.ExpressionResolver {  
package org.opensearch.cluster;
    }  
            Settings.EMPTY,
 * The OpenSearch Contributors require contributions made to  
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            RemoteStoreMigrationAllocationDecider.class
        clusterService = ClusterServiceUtils.createClusterService(
            Collections.emptyList(),  
        } catch (IllegalArgumentException e) {  
            () -> clusterModule.setExistingShardsAllocators(new TestGatewayAllocator(), new TestShardBatchGatewayAllocator())
    }
        final ClusterModule clusterModule = new ClusterModule(
    public void testUnknownShardsAllocator() {
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
    }
            public Map<String, ExistingShardsAllocator> getExistingShardsAllocators() {
    private static ClusterPlugin existingShardsAllocatorPlugin(final String allocatorName) {
            NodeVersionAllocationDecider.class,  
        assertTrue(module.deciderList.stream().anyMatch(d -> d.getClass().equals(FakeAllocationDecider.class)));  
 * Unless required by applicable law or agreed to in writing,
        try {
        );
        List<ClusterPlugin> clusterPlugins = Collections.singletonList(new ClusterPlugin() {
        AnotherFakeExpressionResolver customResolver2 = new AnotherFakeExpressionResolver();
            new SettingsModule(Settings.EMPTY, EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING);
                        && entry.name.getPreferredName().equals(WorkloadGroupMetadata.TYPE)  
        List<Class<? extends AllocationDecider>> expectedDeciders = Arrays.asList(  
import org.opensearch.cluster.routing.allocation.decider.RebalanceOnlyWhenActiveAllocationDecider;
        );  
        assertTrue(module.getIndexNameExpressionResolver().getExpressionResolvers().contains(customResolver2));
import org.opensearch.plugins.ClusterPlugin;
        ClusterModule module = new ClusterModule(
        assertEquals("Unknown ShardsAllocator [dne]", e.getMessage());
        assertTrue(  
        expectThrows(NullPointerException.class, () -> newClusterModuleWithShardsAllocator(settings, "bad", () -> null));
            @Override  
            @Override
import org.opensearch.cluster.routing.allocation.decider.RemoteStoreMigrationAllocationDecider;  
                threadContext,  

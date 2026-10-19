            Settings.builder()
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        }  
        return Arrays.asList(TestPlugin.class, MockTransportService.TestPlugin.class);  
                    connection.sendRequest(requestId, action, request, options);
                            logger.info("dropping [{}] to [{}]", action, node);  
    }
        // get one healthy sample
        InternalTestCluster internalTestCluster = internalCluster();
        internalCluster().startNodes(1);
        assertThat(info.shardSizes.size(), equalTo(0));
                    if (blockedActions.contains(action)) {
import java.util.concurrent.atomic.AtomicBoolean;  
import org.opensearch.common.settings.Settings;
        assertNotNull("info should not be null", info);
        assertThat("file cache is empty on non warm nodes", nodeFileCacheStats.size(), Matchers.equalTo(0));  
        assertAcked(
import org.opensearch.indices.SystemIndexDescriptor;
            prepareCreate(indexName).setSettings(  
            internalTestCluster.getClusterManagerName()  
            blockedActions = unmodifiableSet(newHashSet(actions));  
        assertNotNull("info should not be null", info);  
            );  
            }
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(1))
                .put(InternalClusterInfoService.INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING.getKey(), "60m")  
        prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)).get();
 */
        // setting time window as ResourceUsageTracker needs atleast both of these to be ready to start collecting the
            internalTestCluster.getClusterManagerName()
    @SuppressForbidden(reason = "Fixed sleeps are prone to flakiness but no documented failures here")
 * Integration tests for the ClusterInfoService collecting information  
            2,  
                blockingActionFilter = (BlockingActionFilter) filter;
        public TestPlugin() {
        assertNotNull("info should not be null", info);  
    public void testClusterInfoServiceInformationClearOnError() throws InterruptedException {
import org.opensearch.test.OpenSearchIntegTestCase;  
        }
import java.util.Collection;  
            ClusterInfoService.class,
        assertThat("some shard sizes are populated", info.shardSizes.size(), greaterThan(0));  
import org.opensearch.node.NodeResourceUsageStats;  
import org.opensearch.index.store.Store;
 * Licensed to Elasticsearch under one or more contributor  
        ensureGreen("test");
    public void testClusterInfoServiceCollectsNodeResourceStatsInformation() throws InterruptedException {  
        }
        ClusterService clusterService = internalTestCluster.getInstance(ClusterService.class, internalTestCluster.getClusterManagerName());
            client().admin()
}  
            // manually control publishing
        assertNotNull(nodeFileCacheStats);  
        InternalClusterInfoService infoService = (InternalClusterInfoService) internalTestCluster.getInstance(
        public void blockActions(String... actions) {
 * You may obtain a copy of the License at  
            assertEquals(indexShard.shardPath().getRootDataPath().toString(), dataPath);
                break;  
        // node info will time out both on the request level on the count down latch. this means
        info = infoService.refresh();
    }
    public static class TestPlugin extends Plugin implements ActionPlugin, SystemIndexPlugin {
import static org.hamcrest.Matchers.greaterThan;
 * KIND, either express or implied.  See the License for the
        infoService.setUpdateFrequency(TimeValue.timeValueMillis(200));  
        infoService.setUpdateFrequency(TimeValue.timeValueMillis(100));
/*  
        // Get the cluster info service on the cluster-manager node  
        assertNotNull("info should not be null", info);  
import org.opensearch.test.transport.MockTransportService;
        }
        for (ActionFilter filter : actionFilters.filters()) {  
        InternalTestCluster internalTestCluster = internalCluster();  
        // delay of 6 seconds as NodeResourceUsageTracker needs atleast 5 seconds to start populating stats  
            logger.info("--> usage: {}", usage.getValue());
 *
                        }
        final Map<String, AggregateFileCacheStats> nodeFileCacheStats = info.nodeFileCacheStats;
            return singletonList(blockingActionFilter);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                    .build()
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.ActionPlugin;
/*
 * The OpenSearch Contributors require contributions made to  
                    .put(IndexMetadata.SETTING_INDEX_HIDDEN, randomBoolean())
 *  
                .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;  
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(1))
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull(nodeUsages);
        private Set<String> blockedActions = emptySet();
        for (NodeResourceUsageStats usage : nodeUsages.values()) {  
        assertNotNull("info should not be null", info);  
                .setTransientSettings(
        public int order() {
        assertThat("some usages are populated", leastUsages.values().size(), Matchers.equalTo(2));
        }
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
        // Get the cluster info service on the cluster-manager node
            assertThat("file cache is non empty", aggregateFileCacheStats.getTotal().getBytes(), greaterThan(0L));
            .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))  
        public List<ActionFilter> getActionFilters() {
        );
                throw new OpenSearchException("force exception on [" + action + "]");
import org.opensearch.test.InternalTestCluster;
        final AtomicBoolean timeout = new AtomicBoolean(false);
import java.util.Locale;  
        }  
        ClusterState state = clusterService.state();  
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        ActionFilters actionFilters = internalTestCluster.getInstance(ActionFilters.class, internalTestCluster.getClusterManagerName());
public class ClusterInfoServiceIT extends OpenSearchIntegTestCase {  
        }
import org.opensearch.cluster.service.ClusterService;  
import static java.util.Collections.singletonList;  
        assertNotNull("failed to find BlockingActionFilter", blockingActionFilter);
        final Map<String, Long> shardSizes = info.shardSizes;
                Settings.builder()
import org.opensearch.plugins.SystemIndexPlugin;
            assertThat("memoryUtilization has retrieved", usage.getMemoryUtilizationPercent(), greaterThanOrEqualTo(0.0));
        final Map<String, NodeResourceUsageStats> nodeResourceUsageStats = info.getNodeResourceUsageStats();
        assertThat(info.getNodeMostAvailableDiskUsages().size(), equalTo(0));  
            IndicesStatsAction.NAME,
    public void testClusterInfoServiceCollectsFileCacheInformation() {
    public static class BlockingActionFilter extends org.opensearch.action.support.ActionFilter.Simple {
            if (blockedActions.contains(action)) {  
            return true;  
        assertNotNull("failed to collect info", info);
        }
import org.opensearch.index.shard.IndexShard;
        for (DiscoveryNode node : internalTestCluster.clusterService().state().getNodes()) {  
        assertEquals(2, nodeResourceUsageStats.size());  
        assertThat(info.shardSizes.size(), greaterThan(1));  
        @Override
            assertThat("usage has be retrieved", usage.getValue().getFreeBytes(), greaterThan(0L));  
        @Override  
        assertThat(info.shardSizes.size(), greaterThan(0));
        timeout.set(false);  
        assertThat(info.getNodeResourceUsageStats().size(), equalTo(0));
        internalCluster().startWarmOnlyNodes(1, settingsBuilder.build());
    @SuppressForbidden(reason = "Fixed sleeps are prone to flakiness but no documented failures here")  
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(1));  
        for (AggregateFileCacheStats aggregateFileCacheStats : nodeFileCacheStats.values()) {  
                        if (timeout.get()) {
            ClusterInfoService.class,
 *
import org.opensearch.common.unit.TimeValue;  
        assertThat(info.getNodeLeastAvailableDiskUsages().size(), equalTo(0));
 * this work for additional information regarding copyright
        MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(
        if (randomBoolean()) {
        @Override  
        );  
    private void setClusterInfoTimeout(String timeValue) {  
import static java.util.Collections.unmodifiableSet;
import java.util.Collections;
    }
        BlockingActionFilter blockingActionFilter = null;
    }
            assertThat("usage has be retrieved", usage.getFreeBytes(), greaterThan(0L));
        Settings.Builder settingsBuilder = Settings.builder()
                .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
                .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))  
            IndicesService indicesService = internalTestCluster.getInstance(IndicesService.class, discoveryNode.getName());
            assertAcked(client().admin().indices().prepareClose(indexName));  
        for (Map.Entry<String, DiskUsage> usage : leastUsages.entrySet()) {
        assertThat(info.getNodeMostAvailableDiskUsages().size(), greaterThanOrEqualTo(1));
        assertThat(info.getNodeResourceUsageStats().size(), equalTo(2));  
                new SystemIndexDescriptor(TEST_SYSTEM_INDEX_NAME, "System index for [" + getTestClass().getName() + ']')
        assertThat("file cache is enabled on both warm nodes", nodeFileCacheStats.size(), Matchers.equalTo(2));
 * Unless required by applicable law or agreed to in writing,
        assertThat(info.getNodeLeastAvailableDiskUsages().size(), greaterThanOrEqualTo(1));
import static org.opensearch.common.util.set.Sets.newHashSet;
 */  
package org.opensearch.cluster;
        assertNotNull(nodeResourceUsageStats);
            logger.info("--> usage: {}", usage);  
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)  
        );
                .prepareUpdateSettings()
    }
import java.util.Arrays;
import org.opensearch.cluster.metadata.IndexMetadata;
        for (DiskUsage usage : mostUsages.values()) {
        }  
            ClusterInfoService.class,
                    .put(Store.INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING.getKey(), 0)
import org.hamcrest.Matchers;  
    public void testClusterInfoServiceCollectsInformation() throws InterruptedException {  
        final Map<String, DiskUsage> leastUsages = info.getNodeLeastAvailableDiskUsages();
            String dataPath = info.getDataPath(shard);
        ClusterInfo info = infoService.refresh();
        );
        Thread.sleep(6000);
        assertAcked(
 */  
 * under the License.  
            if (filter instanceof BlockingActionFilter) {
        for (ShardRouting shard : state.routingTable().allShards()) {
            assertThat("shard size is greater than 0", size, greaterThanOrEqualTo(0L));
            internalTestCluster.getClusterManagerName()  
        assertThat(info.reservedSpace.size(), equalTo(0));  
        blockingActionFilter.blockActions();  
    }  
        assertNotNull("info should not be null", info);
import org.opensearch.cluster.routing.ShardRouting;
            );  
            )  
                            return;
        setClusterInfoTimeout("1s");  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
import org.opensearch.action.support.ActionFilter;
import org.opensearch.cluster.routing.RoutingTable;  
        assertNotNull(leastUsages);  
import java.util.List;
    private static final String TEST_SYSTEM_INDEX_NAME = ".test-cluster-info-system-index";
            internalTestCluster.getClusterManagerName()
        info = infoService.refresh();
        @Override
            NodesStatsAction.NAME + "[n]",
import org.opensearch.indices.IndicesService;
        // Get the cluster info service on the cluster-manager node  
        );
        final Set<String> blockedActions = newHashSet(
        internalCluster().startNodes(
import java.util.Map;
import org.opensearch.core.action.ActionListener;
    }  
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
            TransportService.class,  
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(1))
        assertThat("some usages are populated", info.getNodeLeastAvailableDiskUsages().size(), Matchers.equalTo(2));
        for (ShardRouting shard : routingTable.allShards()) {
import org.opensearch.plugins.Plugin;  
        internalCluster().ensureAtLeastNumWarmAndDataNodes(2);  
        final Map<String, AggregateFileCacheStats> nodeFileCacheStats = info.nodeFileCacheStats;
/*  
            blockingActionFilter = new BlockingActionFilter();  
            assertThat("cpuUtilization has retrieved", usage.getCpuUtilizationPercent(), greaterThan(0.0));  
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5));
        );
import org.opensearch.transport.TransportService;
        public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {  
        RoutingTable routingTable = client().admin().cluster().prepareState().clear().setRoutingTable(true).get().getState().routingTable();  
                .cluster()  
        assertThat(info.getNodeLeastAvailableDiskUsages().size(), equalTo(2));
        private final BlockingActionFilter blockingActionFilter;  
        );
        }
            assertTrue(info.getReservedSpace(nodeId, dataPath).containsShardId(shard.shardId()));  
        protected boolean apply(String action, ActionRequest request, ActionListener<?> listener) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        setClusterInfoTimeout("15s");
        ClusterInfo info = infoService.refresh();  
                }
        final String indexName = randomBoolean() ? randomAlphaOfLength(5).toLowerCase(Locale.ROOT) : TEST_SYSTEM_INDEX_NAME;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        Settings.Builder settingsBuilder = Settings.builder()
        timeout.set(true);
        final Map<String, NodeResourceUsageStats> nodeUsages = info.getNodeResourceUsageStats();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.support.ActionFilters;  
        // drop all outgoing stats requests to force a timeout.
        final Map<String, DiskUsage> mostUsages = info.getNodeMostAvailableDiskUsages();
            IndexService indexService = indicesService.indexService(shard.index());
                .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
        InternalTestCluster internalTestCluster = internalCluster();  
        );
            logger.info("--> usage: {}", usage);
            ClusterInfoService.class,  
    @Override
        assertThat(info.getNodeResourceUsageStats().size(), greaterThanOrEqualTo(0));
        // check we recover
        assertThat("some shard sizes are populated", shardSizes.values().size(), greaterThan(0));  
        internalCluster().startDataOnlyNodes(1, settingsBuilder.build());  
import org.opensearch.action.ActionRequest;
        InternalTestCluster internalTestCluster = internalCluster();
            mockTransportService.addSendBehavior(
import org.opensearch.core.common.Strings;
                    }  
        assertThat(info.getNodeMostAvailableDiskUsages().size(), equalTo(2));
            NodesStatsAction.NAME,  
            assertNotNull(dataPath);  
        // timeouts shouldn't clear the info
        }
import java.util.Set;
        infoService.setUpdateFrequency(TimeValue.timeValueMillis(200));
import org.opensearch.common.SuppressForbidden;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.cluster.node.DiscoveryNode;
 * license agreements. See the NOTICE file distributed with
                (connection, requestId, action, request, options) -> {  
import static org.hamcrest.CoreMatchers.equalTo;
 * specific language governing permissions and limitations
        );
                internalTestCluster.getInstance(TransportService.class, node.getName()),
import static java.util.Collections.emptySet;
            String nodeId = shard.currentNodeId();
    @SuppressForbidden(reason = "Fixed sleeps are prone to flakiness but no documented failures here")
            DiscoveryNode discoveryNode = state.getNodes().get(nodeId);  
            IndicesStatsAction.NAME + "[n]"  
        // sleep for 6 seconds for ResourceUsageCollector to collect enough stats  
        }
            assertTrue(info.getReservedSpace(shard.currentNodeId(), info.getDataPath(shard)).containsShardId(shard.shardId()));
import org.opensearch.index.IndexService;  
        blockingActionFilter.blockActions(blockedActions.toArray(Strings.EMPTY_ARRAY));
            }
        }
 */
 * compatible open source license.
 * software distributed under the License is distributed on an
        // moving average  
/**
        for (Long size : shardSizes.values()) {
        assertNotNull(shardSizes);
        // now we cause an exception
            return Collections.singletonList(
        // node.  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        internalCluster().startNodes(2, settingsBuilder.build());
        Thread.sleep(6000);
        }
        Thread.sleep(1000);
        final InternalClusterInfoService infoService = (InternalClusterInfoService) internalTestCluster.getInstance(
    }
        ClusterInfo info = infoService.refresh();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsAction;  
        assertNotNull(nodeFileCacheStats);
            internalTestCluster.getClusterManagerName()  
            return 0;
        ClusterInfo info = infoService.refresh();  
import org.opensearch.OpenSearchException;
        ensureGreen(indexName);
                )
                .build()
            IndexShard indexShard = indexService.getShardOrNull(shard.id());  
        }
        // it is likely to update the node disk usage based on the one response that came be from local
            logger.info("--> shard size: {}", size);  
                    Settings.builder().put(InternalClusterInfoService.INTERNAL_CLUSTER_INFO_TIMEOUT_SETTING.getKey(), timeValue).build()  
        final InternalClusterInfoService infoService = (InternalClusterInfoService) internalTestCluster.getInstance(
        }
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
 * Modifications Copyright OpenSearch Contributors. See
        info = infoService.refresh();  
        final InternalClusterInfoService infoService = (InternalClusterInfoService) internalTestCluster.getInstance(
        // indices is guaranteed to time out on the latch, not updating anything.

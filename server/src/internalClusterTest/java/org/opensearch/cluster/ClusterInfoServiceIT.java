    public void testClusterInfoServiceCollectsInformation() throws InterruptedException {
        InternalTestCluster internalTestCluster = internalCluster();
        final Map<String, DiskUsage> leastUsages = info.getNodeLeastAvailableDiskUsages();
 * under the License.
        // setting time window as ResourceUsageTracker needs atleast both of these to be ready to start collecting the
        Thread.sleep(6000);
        for (ShardRouting shard : routingTable.allShards()) {
        }
            NodesStatsAction.NAME,
        final AtomicBoolean timeout = new AtomicBoolean(false);
                .cluster()
        }
import java.util.Set;
            )
        InternalTestCluster internalTestCluster = internalCluster();
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        // Get the cluster info service on the cluster-manager node
            prepareCreate(indexName).setSettings(
            ClusterInfoService.class,
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    }
            DiscoveryNode discoveryNode = state.getNodes().get(nodeId);
    }
        timeout.set(false);
            IndicesService indicesService = internalTestCluster.getInstance(IndicesService.class, discoveryNode.getName());
 */
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5));
        @Override
            Settings.builder()
 */
            IndexShard indexShard = indexService.getShardOrNull(shard.id());
            internalTestCluster.getClusterManagerName()
                .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))
        }
import org.opensearch.action.support.ActionFilter;
                            return;
 */
        info = infoService.refresh();
    @SuppressForbidden(reason = "Fixed sleeps are prone to flakiness but no documented failures here")
import java.util.Locale;
import java.util.Collections;
    public void testClusterInfoServiceCollectsNodeResourceStatsInformation() throws InterruptedException {
    }
            return 0;
        assertThat(info.getNodeMostAvailableDiskUsages().size(), greaterThanOrEqualTo(1));
    public static class TestPlugin extends Plugin implements ActionPlugin, SystemIndexPlugin {
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
        assertNotNull("info should not be null", info);
            ClusterInfoService.class,
import org.opensearch.index.shard.IndexShard;
        assertThat(info.getNodeResourceUsageStats().size(), equalTo(2));
import org.opensearch.action.admin.cluster.node.stats.NodesStatsAction;
/*
        }
        final Map<String, DiskUsage> mostUsages = info.getNodeMostAvailableDiskUsages();
 */
                    Settings.builder().put(InternalClusterInfoService.INTERNAL_CLUSTER_INFO_TIMEOUT_SETTING.getKey(), timeValue).build()
import org.opensearch.action.ActionRequest;
import org.opensearch.test.InternalTestCluster;
        assertNotNull("info should not be null", info);
            return true;
            ClusterInfoService.class,
        // moving average
 * this work for additional information regarding copyright
                (connection, requestId, action, request, options) -> {
import org.opensearch.plugins.ActionPlugin;
            logger.info("--> usage: {}", usage);
        assertNotNull("failed to find BlockingActionFilter", blockingActionFilter);
                .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(5))
        for (ShardRouting shard : state.routingTable().allShards()) {
        // now we cause an exception
            if (blockedActions.contains(action)) {
            );
        internalCluster().startNodes(1);
            internalTestCluster.getClusterManagerName()
        }
            mockTransportService.addSendBehavior(
        public List<ActionFilter> getActionFilters() {
import org.opensearch.OpenSearchException;
                new SystemIndexDescriptor(TEST_SYSTEM_INDEX_NAME, "System index for [" + getTestClass().getName() + ']')
            blockingActionFilter = new BlockingActionFilter();
            2,
 * ownership. Elasticsearch licenses this file to you under
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
        for (AggregateFileCacheStats aggregateFileCacheStats : nodeFileCacheStats.values()) {
        );
        assertThat("some usages are populated", info.getNodeLeastAvailableDiskUsages().size(), Matchers.equalTo(2));
        }
            assertThat("cpuUtilization has retrieved", usage.getCpuUtilizationPercent(), greaterThan(0.0));
 * compatible open source license.
            // manually control publishing
        // node info will time out both on the request level on the count down latch. this means
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(1));
        }
import java.util.Arrays;
        assertThat(info.getNodeLeastAvailableDiskUsages().size(), equalTo(0));
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
    }
        private final BlockingActionFilter blockingActionFilter;
            internalTestCluster.getClusterManagerName()
        for (NodeResourceUsageStats usage : nodeUsages.values()) {
        public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {
import org.opensearch.common.settings.Settings;
        infoService.setUpdateFrequency(TimeValue.timeValueMillis(200));
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
        for (DiscoveryNode node : internalTestCluster.clusterService().state().getNodes()) {
            IndexService indexService = indicesService.indexService(shard.index());
            logger.info("--> usage: {}", usage.getValue());
    }
        // indices is guaranteed to time out on the latch, not updating anything.
        // sleep for 6 seconds for ResourceUsageCollector to collect enough stats
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(1))
        }
        if (randomBoolean()) {
        public void blockActions(String... actions) {
        setClusterInfoTimeout("15s");
            .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.core.action.ActionListener;
        public TestPlugin() {
 * SPDX-License-Identifier: Apache-2.0
        ClusterInfo info = infoService.refresh();
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
            if (filter instanceof BlockingActionFilter) {
        Thread.sleep(1000);
        }
        // Get the cluster info service on the cluster-manager node
        assertThat("file cache is empty on non warm nodes", nodeFileCacheStats.size(), Matchers.equalTo(0));
import java.util.List;
                .build()
        infoService.setUpdateFrequency(TimeValue.timeValueMillis(100));
    @Override
        assertThat(info.shardSizes.size(), greaterThan(0));
    public static class BlockingActionFilter extends org.opensearch.action.support.ActionFilter.Simple {
            }
            return singletonList(blockingActionFilter);
        assertThat("some shard sizes are populated", info.shardSizes.size(), greaterThan(0));
import org.opensearch.index.store.Store;
            blockedActions = unmodifiableSet(newHashSet(actions));
            client().admin()
import org.opensearch.indices.IndicesService;
        for (Long size : shardSizes.values()) {
        assertNotNull("info should not be null", info);
import org.opensearch.common.SuppressForbidden;
        // drop all outgoing stats requests to force a timeout.
        public int order() {
package org.opensearch.cluster;
        ClusterState state = clusterService.state();
        ClusterInfo info = infoService.refresh();
            assertEquals(indexShard.shardPath().getRootDataPath().toString(), dataPath);
        }
                    .put(Store.INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING.getKey(), 0)
    public void testClusterInfoServiceInformationClearOnError() throws InterruptedException {
                )
        ClusterService clusterService = internalTestCluster.getInstance(ClusterService.class, internalTestCluster.getClusterManagerName());
        final InternalClusterInfoService infoService = (InternalClusterInfoService) internalTestCluster.getInstance(
        assertThat(info.getNodeResourceUsageStats().size(), equalTo(0));
        setClusterInfoTimeout("1s");
        assertNotNull(leastUsages);
        RoutingTable routingTable = client().admin().cluster().prepareState().clear().setRoutingTable(true).get().getState().routingTable();
        final Set<String> blockedActions = newHashSet(
import org.opensearch.cluster.routing.ShardRouting;
        internalCluster().startWarmOnlyNodes(1, settingsBuilder.build());
            return Collections.singletonList(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        final Map<String, Long> shardSizes = info.shardSizes;
        ensureGreen(indexName);
public class ClusterInfoServiceIT extends OpenSearchIntegTestCase {
        // it is likely to update the node disk usage based on the one response that came be from local
        InternalClusterInfoService infoService = (InternalClusterInfoService) internalTestCluster.getInstance(
        );
            NodesStatsAction.NAME + "[n]",
import static java.util.Collections.emptySet;
        internalCluster().startDataOnlyNodes(1, settingsBuilder.build());
        assertNotNull("info should not be null", info);
import org.opensearch.cluster.metadata.IndexMetadata;
        assertNotNull("info should not be null", info);
        // get one healthy sample
        ClusterInfo info = infoService.refresh();
        );
import org.opensearch.cluster.node.DiscoveryNode;
                .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
            internalTestCluster.getClusterManagerName()
        final InternalClusterInfoService infoService = (InternalClusterInfoService) internalTestCluster.getInstance(
        Settings.Builder settingsBuilder = Settings.builder()
 * You may obtain a copy of the License at
        Settings.Builder settingsBuilder = Settings.builder()
 * Unless required by applicable law or agreed to in writing,
            String dataPath = info.getDataPath(shard);
                .put(InternalClusterInfoService.INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING.getKey(), "60m")
        assertAcked(
            internalTestCluster.getClusterManagerName()
                            logger.info("dropping [{}] to [{}]", action, node);
            assertAcked(client().admin().indices().prepareClose(indexName));
            String nodeId = shard.currentNodeId();
        final Map<String, AggregateFileCacheStats> nodeFileCacheStats = info.nodeFileCacheStats;
        assertThat(info.getNodeMostAvailableDiskUsages().size(), equalTo(2));
            assertTrue(info.getReservedSpace(shard.currentNodeId(), info.getDataPath(shard)).containsShardId(shard.shardId()));
        blockingActionFilter.blockActions(blockedActions.toArray(Strings.EMPTY_ARRAY));
        // node.
        ActionFilters actionFilters = internalTestCluster.getInstance(ActionFilters.class, internalTestCluster.getClusterManagerName());
        assertNotNull(nodeFileCacheStats);
        @Override
                blockingActionFilter = (BlockingActionFilter) filter;
        Thread.sleep(6000);
        final Map<String, NodeResourceUsageStats> nodeResourceUsageStats = info.getNodeResourceUsageStats();
        assertAcked(
        }
        protected boolean apply(String action, ActionRequest request, ActionListener<?> listener) {
        for (DiskUsage usage : mostUsages.values()) {
import static java.util.Collections.singletonList;
        @Override
/*
                break;
    @SuppressForbidden(reason = "Fixed sleeps are prone to flakiness but no documented failures here")
                Settings.builder()
                .prepareUpdateSettings()
import java.util.concurrent.atomic.AtomicBoolean;
        assertThat(info.reservedSpace.size(), equalTo(0));
        assertThat(info.getNodeResourceUsageStats().size(), greaterThanOrEqualTo(0));
        assertNotNull(nodeFileCacheStats);
        for (Map.Entry<String, DiskUsage> usage : leastUsages.entrySet()) {
        assertThat("some shard sizes are populated", shardSizes.values().size(), greaterThan(0));
        assertThat(info.getNodeLeastAvailableDiskUsages().size(), equalTo(2));
        assertNotNull("info should not be null", info);
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
 * software distributed under the License is distributed on an
                    }
 *
        // timeouts shouldn't clear the info
    @SuppressForbidden(reason = "Fixed sleeps are prone to flakiness but no documented failures here")
            IndicesStatsAction.NAME,
import org.opensearch.action.support.ActionFilters;
        final Map<String, AggregateFileCacheStats> nodeFileCacheStats = info.nodeFileCacheStats;
        // delay of 6 seconds as NodeResourceUsageTracker needs atleast 5 seconds to start populating stats
 * this file be licensed under the Apache-2.0 license or a
}
        assertThat(info.getNodeMostAvailableDiskUsages().size(), equalTo(0));
import org.opensearch.indices.SystemIndexDescriptor;
        @Override
        }
/*
            assertNotNull(dataPath);
        ensureGreen("test");
        }
        return Arrays.asList(TestPlugin.class, MockTransportService.TestPlugin.class);
                throw new OpenSearchException("force exception on [" + action + "]");
        BlockingActionFilter blockingActionFilter = null;
    private void setClusterInfoTimeout(String timeValue) {
        final InternalClusterInfoService infoService = (InternalClusterInfoService) internalTestCluster.getInstance(
            ClusterInfoService.class,
import org.opensearch.cluster.service.ClusterService;
                        }
 * Integration tests for the ClusterInfoService collecting information
        internalCluster().startNodes(2, settingsBuilder.build());
            logger.info("--> usage: {}", usage);
                    connection.sendRequest(requestId, action, request, options);
        );
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(1))
                        if (timeout.get()) {
import org.opensearch.plugins.Plugin;
        assertNotNull(nodeResourceUsageStats);
    public void testClusterInfoServiceCollectsFileCacheInformation() {
        internalCluster().ensureAtLeastNumWarmAndDataNodes(2);
/**
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * license agreements. See the NOTICE file distributed with
            assertThat("memoryUtilization has retrieved", usage.getMemoryUtilizationPercent(), greaterThanOrEqualTo(0.0));
import org.opensearch.common.unit.TimeValue;
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
        for (ActionFilter filter : actionFilters.filters()) {
    private static final String TEST_SYSTEM_INDEX_NAME = ".test-cluster-info-system-index";
        assertThat(info.shardSizes.size(), greaterThan(1));
        info = infoService.refresh();
import org.opensearch.test.transport.MockTransportService;
                internalTestCluster.getInstance(TransportService.class, node.getName()),
            logger.info("--> shard size: {}", size);
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueSeconds(1))
import static java.util.Collections.unmodifiableSet;
        info = infoService.refresh();
        assertThat(info.shardSizes.size(), equalTo(0));
        prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)).get();
        private Set<String> blockedActions = emptySet();
        );
        final String indexName = randomBoolean() ? randomAlphaOfLength(5).toLowerCase(Locale.ROOT) : TEST_SYSTEM_INDEX_NAME;
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(info.getNodeLeastAvailableDiskUsages().size(), greaterThanOrEqualTo(1));
import org.opensearch.node.NodeResourceUsageStats;
        }
 * KIND, either express or implied.  See the License for the
import java.util.Map;
import static org.opensearch.common.util.set.Sets.newHashSet;
import org.hamcrest.Matchers;
import static org.hamcrest.CoreMatchers.equalTo;
import org.opensearch.index.IndexService;
            }
            assertThat("usage has be retrieved", usage.getFreeBytes(), greaterThan(0L));
            assertThat("file cache is non empty", aggregateFileCacheStats.getTotal().getBytes(), greaterThan(0L));
    }
            TransportService.class,
                    .build()
                .setTransientSettings(
 * Licensed to Elasticsearch under one or more contributor
    }
        assertThat("file cache is enabled on both warm nodes", nodeFileCacheStats.size(), Matchers.equalTo(2));
 *
                    if (blockedActions.contains(action)) {
 * The OpenSearch Contributors require contributions made to
            assertThat("usage has be retrieved", usage.getValue().getFreeBytes(), greaterThan(0L));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        InternalTestCluster internalTestCluster = internalCluster();
        // Get the cluster info service on the cluster-manager node
            );
        }
        assertEquals(2, nodeResourceUsageStats.size());
            IndicesStatsAction.NAME + "[n]"
                    .put(IndexMetadata.SETTING_INDEX_HIDDEN, randomBoolean())
        assertNotNull(shardSizes);
            assertTrue(info.getReservedSpace(nodeId, dataPath).containsShardId(shard.shardId()));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import java.util.Collection;
        assertNotNull(nodeUsages);
        internalCluster().startNodes(
                .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
        infoService.setUpdateFrequency(TimeValue.timeValueMillis(200));
        final Map<String, NodeResourceUsageStats> nodeUsages = info.getNodeResourceUsageStats();
        );
 * not use this file except in compliance with the License.
        assertThat("some usages are populated", leastUsages.values().size(), Matchers.equalTo(2));
        }
        InternalTestCluster internalTestCluster = internalCluster();
import org.opensearch.core.common.Strings;
        );
        ClusterInfo info = infoService.refresh();
        timeout.set(true);
import org.opensearch.transport.TransportService;
 *
                }
        MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(
            assertThat("shard size is greater than 0", size, greaterThanOrEqualTo(0L));
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
        blockingActionFilter.blockActions();
import org.opensearch.plugins.SystemIndexPlugin;
        // check we recover
        );
import org.opensearch.cluster.routing.RoutingTable;
    }
        assertNotNull("failed to collect info", info);

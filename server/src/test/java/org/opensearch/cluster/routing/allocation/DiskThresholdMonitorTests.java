            }
            settings,  
                    fileCacheStats.put(key, createAggregateFileCacheStats(100, between(90, 99), 99));  
        assertEquals(countUnblockBlocksCalled.get(), 0);  
        final Map<String, Long> shardSizes = new HashMap<>();  
        assertNull(listenerReference.get());
 * Modifications Copyright OpenSearch Contributors. See  
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
        relocatingShardSizeRef.set(0L);
                assertTrue(listenerReference.compareAndSet(null, listener));
        assertFalse(indicesToMarkReadOnly.get().isEmpty());
                listener.onResponse(null);
            long time;
                    fileCacheStats.put(key, createAggregateFileCacheStats(100, between(100, 110), 110));
                    .put(IndexMetadata.INDEX_BLOCKS_READ_SETTING.getKey(), true)
            .build();  
        indicesToReleaseReadOnlyBlock.set(null);
            settings,
        ) {
            () -> 0L,
                    DiskThresholdMonitor.class.getCanonicalName(),
            () -> clusterState,  
                    "*"
            () -> clusterState,  
                assertThat(priority, equalTo(Priority.HIGH));  
import org.opensearch.cluster.routing.ShardRoutingState;
        messages.add(
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {  
            0,  
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertNull(indicesToMarkReadOnly.get());
                .nodes(DiscoveryNodes.builder().add(warmNode))
            .addAsNew(metadata.index("test"))
                .routingTable(routingTable)
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
import org.opensearch.index.store.remote.filecache.FileCacheStats;  
                listener.onResponse(null);
            Settings.EMPTY,
            randomLongBetween(
                    .settings(settings(Version.CURRENT).put("index.routing.allocation.require._id", "hot_node_2"))
                return relocatingShardSizeRef.get();  
import java.util.HashMap;
                settings(Version.CURRENT).put("index.store.type", "remote_snapshot")  
        assertRepeatedWarningMessages(  
        Metadata metadata = Metadata.builder()
        AllocationService allocation = createAllocationService(
            null,
        );  
                assertThat(priority, equalTo(Priority.HIGH));  
            .put(IndexMetadata.builder("test_1").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))  
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                monitor.onNewInfo(clusterInfo(diskUsages));
 * the Apache License, Version 2.0 (the "License"); you may
            .addAsNew(metadata.index("user_index"))  
                            .put("index.routing.allocation.require._id", "warm_node")
                listener.onResponse(null);
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        assertTrue(indicesToMarkReadOnly.get().contains("remote_index"));  
        DiscoveryNode warmNode = newNode("warm_node_search_block", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
            aboveHighWatermark,
            )
                .routingTable(routingTable)
        builder = new HashMap<>();
            monitor,
                    .settings(settings(Version.CURRENT).put("index.routing.allocation.require._id", "hot_node_1"))
                            .put("index.routing.allocation.require._id", "warm_node_index_block")
                )
                listener.onResponse(null);
        final Map<String, Long> shardSizes = new HashMap<>();
            @Override
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
            },
        }
                    countUnblockBlocksCalled.set(countUnblockBlocksCalled.get() + 1);
        if (randomBoolean()) {  
        return new ClusterInfo(diskUsages, null, shardSizes, null, reservedSpace, fileCacheStats, Map.of());  
                    .put(IndexMetadata.INDEX_BLOCKS_READ_SETTING.getKey(), true)  
                    .numberOfShards(1)
                listener.onResponse(null);
                listener.onResponse(clusterStateWithBlocks);  
import org.opensearch.cluster.metadata.Metadata;
                assertTrue(reroute.compareAndSet(false, true));  
import org.opensearch.common.settings.Settings;
            );
                    level == Level.INFO ? Level.WARN : Level.INFO,
        };
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, between(10, 100)));  
        assertSingleInfoMessage(
        final Map<String, DiskUsage> aboveHighWatermark = new HashMap<>();  
        );
    public void testWarmNodeFloodStageWatermarkBreach() {
            .metadata(  
            randomLongBetween(
import java.util.Map;
                    )
        indicesToReleaseReadOnlyBlock.set(null);
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
            settings,  
import org.opensearch.cluster.ClusterName;
 */
import org.opensearch.test.MockLogAppender;
            totalCacheSize,
                }  
                    .numberOfShards(1)  
                .routingTable(routingTable)
                assertFalse(readBlock);
            }
                + "Number of nodes above high watermark: 1."
            () -> 0L,
import org.opensearch.cluster.node.DiscoveryNodes;
        AtomicBoolean reroute = new AtomicBoolean(false);  
                    assertTrue(indicesToReleaseReadOnlyBlock.compareAndSet(null, indicesToUpdate));  
        monitor.onNewInfo(clusterInfo(builder));
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // system index (.opensearch-security) should still be released,
        final Map<String, AggregateFileCacheStats> fileCacheStats = new HashMap<>();  
        currentTime.addAndGet(randomLongBetween(0, 120000));
        // should reroute again when one disk is still over the watermark  
                } else {
                    DiskThresholdMonitor.class.getCanonicalName(),  
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, 4));
                .metadata(metadata)  
            }
            @Override
        assertNoLogging(monitor, allDisksOk);  
            @Override
        AllocationService allocation = createAllocationService(  
        currentTime.addAndGet(  
                listener.onResponse(null);
                            .put("index.routing.allocation.require._id", "warm_node_search_block")  
            active,
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
                if (readBlock == false) {  
        });
        Map<String, DiskUsage> builder = new HashMap<>();
                .nodes(DiscoveryNodes.builder().add(warmNode))  
            long sizeOfRelocatingShards(RoutingNode routingNode, DiskUsage diskUsage, ClusterInfo info, ClusterState reroutedClusterState) {
        assertSingleInfoMessage(  
        AllocationService allocation = createAllocationService(
                assertTrue(indicesToBlockRead.compareAndSet(null, indicesToUpdate));
                    .build()
            @Override
                .build(),
                assertTrue(readOnly);  
        monitor.onNewInfo(clusterInfo(oneDiskAboveWatermark));
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();  
        assertTrue(reroute.get());
                .routingTable(routingTable)  
        monitor.onNewInfo(clusterInfo(allDisksOk));
        }
            )
        final Map<String, Long> shardSizes = new HashMap<>();
            .nodes(DiscoveryNodes.builder().add(newNode("hot_node_1")))
        assertTrue(reroute.get());  
                if (key.contains("search_block")) {  
            0,
                listener.onResponse(null);
                .routingTable(routingTable)
        );  
        final AtomicBoolean advanceTime = new AtomicBoolean(randomBoolean());
        monitor.onNewInfo(clusterInfo(builder));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
    private static ClusterInfo clusterInfo(
            settings,
            null,
    }
        advanceTime.set(true);
        );
 * this file be licensed under the Apache-2.0 license or a
        );  
                .build(),
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {  
        // Should mark remote indices read-only due to flood stage breach
                    .settings(
            }  
        // Total addressable space = dataToFileCacheSizeRatio * nodeCacheSize = 2.0 * 100 = 200  
/*
                listener.onResponse(null);
                    .numberOfShards(1)
        // should not reroute when all disks are ok
            () -> anotherFinalClusterState,
            (reason, priority, listener) -> {
        builder = new HashMap<>();  
            allocation
        builder = new HashMap<>();  
            )  
                    .settings(settings(Version.CURRENT).put("index.routing.allocation.require._id", "hot_node_1"))
        AtomicInteger countUnblockBlocksCalled = new AtomicInteger();  
        DiscoveryNode warmNode = newNode("warm_node", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
        }
        monitor.onNewInfo(clusterInfo(builder));
        };
        Settings settings = Settings.builder().build();  
        };
            "high disk watermark [90%] no longer exceeded on * but low disk watermark [85%] is still exceeded"  
        assertTrue(reroute.get());  
            0,
            .build();
            totalCacheSize,  
        // When free disk on any of node1 or node2 goes below 5% flood watermark, then apply index block on indices not having the block  
                + "the node is expected to continue to exceed the high disk watermark when these relocations are complete"
            );
        monitor.onNewInfo(clusterInfo(allDisksOk));
        AtomicBoolean reroute = new AtomicBoolean(false);
import org.opensearch.cluster.metadata.IndexMetadata;
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
            )
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
            }
                listener.onResponse(null);  
            (reason, priority, listener) -> {  
            new ClusterInfo.ReservedSpace.Builder().add(new ShardId("", "", 0), reservedSpaceNode2).build()
            .numberOfShards(1)
            }
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(5, 100)));
        };  
 * The OpenSearch Contributors require contributions made to  
                    .put("index.routing.allocation.require._id", "warm_node")
                    .numberOfShards(1)  
        // Total addressable space = dataToFileCacheSizeRatio * nodeCacheSize = 2.0 * 100 = 200
        );  
                IndexMetadata.builder("test")  
                if (readOnly) {  
            @Override  
        );  
            "low disk watermark [85%] exceeded on * replicas will not be assigned to this node"
import org.opensearch.cluster.routing.RoutingTable;
        }  
    public void testDiskMonitorLogging() throws IllegalAccessException {
                    .put(IndexMetadata.INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true)
        builder = new HashMap<>();
                .build(),  
                assertThat(priority, equalTo(Priority.HIGH));  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
        ) {
                .metadata(metadata)  
        assertNull(indicesToReleaseReadOnlyBlock.get());  
                    .put(indexMetadata, true)
                    .numberOfReplicas(0)  
        currentTime.addAndGet(randomLongBetween(60001, 120000));
        );
                120000
                120000
        indicesToReleaseReadOnlyBlock.set(null);
        };
            @Override  
        final ActionListener<ClusterState> rerouteListener1 = listenerReference.getAndSet(null);  
            .numberOfReplicas(0);  
        assertNull(indicesToReleaseReadOnlyBlock.get());
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();
import java.util.ArrayList;
            (reason, priority, listener) -> listener.onResponse(null),
                    "*"
        builder = new HashMap<>();
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
        );
            () -> 0L,  
            for (int i = between(1, 3); i >= 0; i--) {
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
    private void assertRepeatedWarningMessages(DiskThresholdMonitor monitor, final Map<String, DiskUsage> diskUsages, String message)  
            0,
        // When no usage information is present for node2, we don't release the block
        builder.put("warm_node", new DiskUsage("warm_node", "warm_node", "/foo/bar", 200, 8));  
    public void testMarkFloodStageIndicesReadOnly() {  
            Settings.EMPTY,  
        );
/*  
                .build(),
                }  
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                        settings(Version.CURRENT).put("index.store.type", "remote_snapshot")  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
                listener.onResponse(null);
    ) {
            )  
                listener.onResponse(null);
 * software distributed under the License is distributed on an
        ) {
                    .numberOfShards(1)
import java.util.HashSet;
        FileCacheStats overallStats = new FileCacheStats(
        indicesToReleaseReadOnlyBlock.set(null);  
                listener.onResponse(null);
            () -> clusterState,
        currentTime.addAndGet(
        final ClusterState clusterState = applyStartedShardsUntilNoChange(  
            timeSupplier,
            )  
                    .settings(settings(Version.CURRENT).put("index.routing.allocation.require._id", "hot_node_2"))
            assertLogging(monitor, diskUsages, Level.WARN, message);  
            () -> clusterState,  
        shardSizes.put("[remote_index][0][p]", 172L);  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();
        // When disk usage on one node is missing and the other is below the high watermark, nothing changes  
        builder.put("warm_node", new DiskUsage("warm_node", "warm_node", "/foo/bar", 200, 40));  
        }
        // but should trigger reroute  
            @Override
            )
        final Map<String, Long> shardSizes = new HashMap<>();
                assertTrue(reroute.compareAndSet(false, true));
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
        monitor.onNewInfo(clusterInfo(builder, reservedSpaces, Map.of()));
 * under the License.  
    }
            }
        Map<String, DiskUsage> builder = new HashMap<>();
                    .put(clusterState.metadata().index("test_2").getSettings())
            () -> 0L,
    }
        // Flood stage threshold (5%) = 200 * 0.05 = 10  
            @Override
        DiscoveryNode warmNode = newNode("warm_node_index_block", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
        assertNull(indicesToReleaseReadOnlyBlock.get());  
        builder.put("warm_node_index_block", new DiskUsage("warm_node_index_block", "warm_node_index_block", "/foo/bar", 200, 40));
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
                listener.onResponse(null);  
        ) {
            () -> 2.0
            (reason, priority, listener) -> {
            0,
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
        AtomicReference<Set<String>> indicesToReleaseReadOnlyBlock = new AtomicReference<>();
        assertSingleInfoMessage(monitor, allDisksOk, "low disk watermark [85%] no longer exceeded on *");  
            0,
                assertFalse(readOnly);  
            () -> 5.0  
        final Map<String, Long> shardSizes = new HashMap<>();
        assertNull(indicesToReleaseReadOnlyBlock.get());
        assertFalse(indicesToMarkReadOnly.get().isEmpty());  
                    .put(IndexMetadata.INDEX_BLOCKS_READ_SETTING.getKey(), true)  
            .numberOfReplicas(0);
    }  
            }
        assertNull(indicesToReleaseReadOnlyBlock.get());
        assertEquals(countBlocksCalled.get(), 0);
        final ClusterState clusterState = applyStartedShardsUntilNoChange(  
        assertEquals(Collections.singleton("test_1"), indices.get());
                assertTrue(reroute.compareAndSet(false, true));
        assertNoLogging(monitor, diskUsages);
    private void assertSingleInfoMessage(DiskThresholdMonitor monitor, final Map<String, DiskUsage> diskUsages, String message)
                assertTrue(readOnly);  
            @Override
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {  
        // Initially all the nodes are breaching high watermark and IndexCreateBlock is already present on the cluster.
        assertNull(indicesToMarkReadOnly.get());  
        shardSizes.put("[remote_index][0][p]", 192L);  
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, 9));
        indicesToMarkReadOnly.set(null);
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                    "any message of another level",
        shardSizes.put("[remote_index][0][p]", 172L);
        DiscoveryNode warmNode = newNode("warm_node", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
            }
                assertTrue(reroute.compareAndSet(false, true));  
            }
                .blocks(ClusterBlocks.builder().addBlocks(systemIndexBuilder.build()).addBlocks(userIndexBuilder.build()).build())
        };
                    .put("index.routing.allocation.require._id", "warm_node_index_block")
            monitor,  
            (reason, priority, listener) -> {  
            "flood stage disk watermark [95%] exceeded on * all indices on this node will be marked read-only"
        assertTrue(anotherFinalClusterState.blocks().indexBlocked(ClusterBlockLevel.WRITE, "test_2"));  
            0,
            protected void updateIndicesReadBlock(Set<String> indicesToBlockRead, ActionListener<Void> listener, boolean readBlock) {
            mockAppender.start();
                listener.onResponse(null);
            protected void updateIndicesReadOnly(Set<String> indicesToMarkReadOnly, ActionListener<Void> listener, boolean readOnly) {  
            monitor,
            (reason, priority, listener) -> listener.onResponse(clusterStateRef.get()),
            }
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        final Map<String, DiskUsage> allDisksOk = new HashMap<>();
    private void assertNoLogging(DiskThresholdMonitor monitor, final Map<String, DiskUsage> diskUsages) throws IllegalAccessException {  
import org.opensearch.cluster.DiskUsage;  
            null,  
                    "any WARN message",  
            AggregateFileCacheStats.FileCacheStatsType.BLOCK_FILE_STATS
            Settings.EMPTY,
            (reason, priority, listener) -> {
            () -> 0L,
            () -> 2.0  
        IndexMetadata.Builder userIndexBuilder = IndexMetadata.builder("user_index")
                + "the node is expected to continue to exceed the high disk watermark when these relocations are complete"  
    }
        AllocationService allocation = createAllocationService(
            builder.put("node3", new DiskUsage("node3", "node3", "/foo/bar", 100, between(0, 100)));  
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
                .blocks(ClusterBlocks.builder().addBlocks(indexMetadataBuilder.build()).build())
            @Override
            currentTime::get,  
            () -> 2.0  // dataToFileCacheSizeRatio = 2  
                listener.onResponse(null);
            )
                    "*"  
            @Override  
        RoutingTable routingTable = RoutingTable.builder()  
            },  
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, between(5, 90)));
            }  
            () -> clusterState,
            monitor,
        currentTime.addAndGet(randomLongBetween(0, 120000));
        );  
 */
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
                    .settings(
                return time;  
            0,
                listener.onResponse(null);  
            @Override
        // should not re-route again before reroute has completed
        AllocationService allocation = createAllocationService(
            mockAppender.addExpectation(  
        monitor.onNewInfo(clusterInfo(allDisksOk, reservedSpaces, Map.of()));  
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(5, 90)));  
    }
        assertNull(indicesToReleaseReadBlock.get());  
    public void testIndexCreateBlockWhenNoDataNodeHealthy() {
            }  
        );
                    .numberOfReplicas(0)
            }  
        reservedSpaces.put(
            .put(
    public void testWarmNodeFileCacheIndexThresholdBreach() {
                    .put(clusterState.metadata().index("test_1"), false)  
        assertNull(indicesToMarkReadOnly.get());  
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
            @Override
                assertTrue(readOnly);
                listener.onResponse(null);  
        return new AggregateFileCacheStats(System.currentTimeMillis(), overallStats, fullStats, blockStats, pinnedStats);  
        indicesToMarkReadOnly.set(null);
            0,  
        // Block will be removed if any nodes is no longer breaching high watermark.
        Map<String, DiskUsage> builder = new HashMap<>();  
        ) {
        allDisksOk = new HashMap<>();  
            @Override
            }  
        assertRepeatedWarningMessages(
                        settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
        assertFalse(indicesToReleaseReadBlock.get().contains("user_index"));
                IndexMetadata.builder("test")
        advanceTime.set(true); // only log about dropping below the low disk watermark on a reroute
                assertThat(priority, equalTo(Priority.HIGH));
            },  
            null,
        final Map<String, DiskUsage> aboveLowWatermark = new HashMap<>();  
            () -> clusterState,
        assertThat(indicesToMarkReadOnly.get(), contains("test_1"));
        indices.set(null);  
        // Ensure DiskThresholdMonitor does not try to remove block in the next iteration if all nodes are breaching high watermark.
        // now we mark one index as read-only and assert that we don't mark it as such again
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();
            @Override
                        settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
                listener.onResponse(null);  
        assertEquals(countUnblockBlocksCalled.get(), 0);
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()  
            () -> clusterState,
        final Map<String, Long> shardSizes = new HashMap<>();  
            0,
                .metadata(metadata)
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE;  
import static org.hamcrest.Matchers.contains;
        FileCacheStats blockStats = new FileCacheStats(
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
            null,
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        assertFalse(indicesToBlockRead.get().isEmpty());
 * KIND, either express or implied.  See the License for the
        );
            .metadata(Metadata.builder(clusterState.metadata()).put(indexMetadata, true).build())
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, 4));  
                Metadata.builder(clusterState.metadata())
                listener.onResponse(null);
        Metadata metadata = Metadata.builder()
        assertRepeatedWarningMessages(  
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
                randomLongBetween(0, DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(Settings.EMPTY).millis())  
        // Total addressable space = dataToFileCacheSizeRatio * nodeCacheSize = 2.0 * 100 = 200
                randomLongBetween(0, DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(Settings.EMPTY).millis())
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, 4));  
        );
        // should reroute again when one disk has reserved space that pushes it over the high watermark
import java.util.concurrent.atomic.AtomicInteger;
                listener.onResponse(null);
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
 * GitHub history for details.
        final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> reservedSpace,  
            },
        AllocationService allocation = createAllocationService(
        builder.put("warm_node", new DiskUsage("warm_node", "warm_node", "/foo/bar", 200, 28));  
                listener.onResponse(null);
                    .numberOfShards(1)
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 5));
            () -> 0L,  
        );
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                if (indexCreateBlock == true) {
                120000  
            currentTime.addAndGet(  
            @Override
        );  
            }  
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder("remote_index")
                .routingTable(routingTable)
            }
                if (advanceTime.get()) {
            null,
                    .numberOfReplicas(0)
            allocation
        AtomicReference<ActionListener<ClusterState>> listenerReference = new AtomicReference<>();  
        Settings settings = Settings.builder().put(CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE.getKey(), true).build();
            .build();
                IndexMetadata.builder("remote_index")  
            }
        };
            }  
                    .put(IndexMetadata.INDEX_BLOCKS_READ_SETTING.getKey(), true)
        ) {
            .build();  
            }
        Metadata metadata = Metadata.builder()
            (reason, priority, listener) -> {
                Settings.builder()  
            allocation
            "high disk watermark [90%] exceeded on * shards will be relocated away from this node* "
            "flood stage disk watermark [95%] exceeded on * all indices on this node will be marked read-only"  
package org.opensearch.cluster.routing.allocation;
            .settings(
                    countBlocksCalled.set(countBlocksCalled.get() + 1);  
                .build(),
            @Override
            "Putting index create block on cluster as all nodes are breaching high disk watermark. "  
        assertMultipleWarningMessages(monitor, aboveHighWatermark, messages);  
            Settings.EMPTY,
                assertTrue(indices.compareAndSet(null, indicesToBlockRead));
            0,
                .blocks(ClusterBlocks.builder().addGlobalBlock(Metadata.CLUSTER_CREATE_INDEX_BLOCK).build())
import java.util.concurrent.atomic.AtomicLong;
            aboveHighWatermark,
        ) {  
 * Licensed to Elasticsearch under one or more contributor  
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
            @Override
            protected void updateIndicesReadBlock(Set<String> indicesToBlockRead, ActionListener<Void> listener, boolean readBlock) {
        assertNull(indicesToMarkReadOnly.get());  
            protected void updateIndicesReadBlock(Set<String> indicesToBlockRead, ActionListener<Void> listener, boolean readBlock) {
            Settings.EMPTY,  
            protected void updateIndicesReadBlock(Set<String> indicesToBlockRead, ActionListener<Void> listener, boolean readBlock) {
                    .settings(  
        }
        shardSizes.put("[remote_index][0][p]", 172L);  
                new MockLogAppender.SeenEventExpectation("expected message", DiskThresholdMonitor.class.getCanonicalName(), level, message)
        // Should not mark remote indices read-only due to High stage breach
                .blocks(ClusterBlocks.builder().addBlocks(indexMetadataBuilder.build()).build())  
                        settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
            () -> clusterState,
        Map<String, DiskUsage> builder = new HashMap<>();
        AtomicReference<Set<String>> indicesToBlockRead = new AtomicReference<>();
                .metadata(metadata)
        };
}
                assertThat(priority, equalTo(Priority.HIGH));  
                listener.onResponse(null);
        DiscoveryNode warmNode = newNode("warm_node", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));  
                }
 * You may obtain a copy of the License at  
            )  
            )
 * this work for additional information regarding copyright
        currentTime.addAndGet(randomLongBetween(0, 120000));  
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(DiskThresholdMonitor.class))) {
            }
        if (randomBoolean()) {
            .addAsNew(metadata.index(".opensearch-security"))
        assertNotNull(indicesToReleaseReadBlock.get());  
            @Override
                assertTrue(indices.compareAndSet(null, indicesToMarkReadOnly));
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();
            (reason, priority, listener) -> {
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
        final Map<String, DiskUsage> oneDiskAboveWatermark = new HashMap<>();  
                .metadata(metadata)  
            allocation
            null,  
            assertNull(listenerReference.get());  
                assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
            "high disk watermark [90%] exceeded on * shards will be relocated away from this node* "  
        monitor.onNewInfo(clusterInfo(oneDiskAboveWatermark));
        monitor.onNewInfo(clusterInfo(builder));
        final int reservedSpaceNode1 = between(0, 10);  
                .put("cluster.blocks.create_index.enabled", false)
            // should not re-route again within the reroute interval
                listener.onResponse(null);
        Map<String, DiskUsage> builder = new HashMap<>();  
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
        advanceTime.set(true);
        oneDiskAboveWatermark.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(5, 9)));
        );
                listener.onResponse(null);  
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();
            @Override  
            0,
        final Map<String, Long> shardSizes = new HashMap<>();
                if (readBlock == false) {  
            () -> 5.0  
            aboveLowWatermark,
        shardSizes.put("[.opensearch-security][0][p]", 86L);
        Map<String, DiskUsage> builder = new HashMap<>();
            @Override
        );  
        builder = new HashMap<>();
            0,  
                            .put("index.routing.allocation.require._id", "warm_node")
            null,
                .nodes(DiscoveryNodes.builder().add(newNode("hot_node_1")).add(newNode("hot_node_2")))
            },
        rerouteListener1.onResponse(clusterState);
    }
        // Free space = 8 < 10, so should exceed flood stage
            }
        );
            allocation
            assertNull(listenerReference.get());
        final Map<String, DiskUsage> allDisksOk;
        assertNotNull(indicesToMarkReadOnly.get());
                    fileCacheStats.put(key, createAggregateFileCacheStats(100, between(0, 89), 89));
        );
                .routingTable(routingTable)  
        throws IllegalAccessException {
            },
        indices.set(null);  
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {  
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
            () -> 0L,
            allocation  
                listener.onResponse(null);
        monitor.onNewInfo(clusterInfo(allDisksOk));  
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
                .routingTable(routingTable)  
            .build();  
            @Override
            @Override
                listener.onResponse(null);
        listenerReference.getAndSet(null).onResponse(null);
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();
            currentTime::get,
            Settings.EMPTY,
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, between(5, 100)));
        // When disk usage on one node is missing and the other is above the flood-stage watermark, affected indices are blocked  
            .build();
                assertThat(priority, equalTo(Priority.HIGH));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {  
        final Map<String, DiskUsage> builder = new HashMap<>();
    public void testReadBlockReleasedForExcludedPatternsWhenAutoReleaseDisabled() {  
        assertFalse(indicesToBlockRead.get().isEmpty());  
        shardSizes.put("[remote_index][0][p]", 172L);  
import java.util.Set;
            0,
    public void testAutoReleaseIndices() {
                .nodes(DiscoveryNodes.builder().add(warmNode))  
            .addAsNew(metadata.index("test_2"))  
            () -> 5.0  
        // Test warm node exceeding flood stage watermark
 * SPDX-License-Identifier: Apache-2.0
                    .numberOfReplicas(0)
        Settings settings = Settings.builder().put(DiskThresholdSettings.INDEX_READ_BLOCK_AUTO_RELEASE.getKey(), false).build();
        shardSizes.put("[remote_index][0][p]", 182L);
        throws IllegalAccessException {  
            monitor,  
            }
                Settings.builder()
                listener.onResponse(null);
    }
import org.opensearch.cluster.node.DiscoveryNode;  
            .build();  
                .routingTable(routingTable)
                listener.onResponse(null);
                }
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
        // High stage threshold (50%) = 200 * 0.15 = 30  
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(Settings.EMPTY).millis() + 1,  
        IndexMetadata.Builder systemIndexBuilder = IndexMetadata.builder(".opensearch-security")
            @Override
        );
                    assertTrue(indicesToReleaseReadOnlyBlock.compareAndSet(null, indicesToUpdate));
            monitor.onNewInfo(clusterInfo(allDisksOk));  
        RoutingTable routingTable = RoutingTable.builder()
                .nodes(DiscoveryNodes.builder().add(warmNode))
                    .numberOfShards(1)  
import static org.hamcrest.Matchers.equalTo;
                    "any INFO message",
            },
                assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));  
            Settings.EMPTY,
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();  
        );
        oneDiskAboveWatermark.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 50));
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();  
        AtomicReference<Set<String>> indices = new AtomicReference<>();
                    .numberOfReplicas(0)
            }
                    indicesToReleaseReadBlock.set(indicesToUpdate);
        final Map<String, DiskUsage> aboveFloodStageWatermark = new HashMap<>();  
                    .numberOfShards(1)
            null,  
            currentTime::get,
                    time += DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(Settings.EMPTY).getMillis() + 1;  
                assertTrue(reroute.compareAndSet(false, true));
            )
        );
                    Level.WARN,
        AtomicLong currentTime = new AtomicLong();
        AtomicLong currentTime = new AtomicLong();
            }
        assertNull(indicesToMarkReadOnly.get());  
                listener.onResponse(null);
        );  
import org.apache.logging.log4j.Level;  
 *
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 9));
        };
                .nodes(DiscoveryNodes.builder().add(warmNode))
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();  
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(10, 100)));
        Map<String, DiskUsage> builder = new HashMap<>();  
            (reason, priority, listener) -> {
 * ownership. Elasticsearch licenses this file to you under  
            .put(
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
        // Change cluster state so that "test_2" index is blocked (read only)  
        DiscoveryNode warmNode = newNode("warm_node", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
                    .put("index.routing.allocation.require._id", "warm_node")
        allDisksOk.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 50));
            monitor.onNewInfo(clusterInfo(diskUsages));  
                .metadata(metadata)
        AtomicReference<Set<String>> indicesToBlockRead = new AtomicReference<>();  
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
        assertMultipleWarningMessages(monitor, aboveHighWatermark, messages);
            0,
            0,
                .metadata(metadata)
            }
            )
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(Settings.EMPTY).millis() + 1,
        indicesToMarkReadOnly.set(null);
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(  
        monitor.onNewInfo(clusterInfo(builder));  
        listenerReference.getAndSet(null).onResponse(null);
                assertThat(priority, equalTo(Priority.HIGH));
            );
                new MockLogAppender.UnseenEventExpectation(
            () -> 2.0
        );  
            public long getAsLong() {
        );
            .build();
            );
                assertThat(priority, equalTo(Priority.HIGH));  
        final ClusterState clusterState = applyStartedShardsUntilNoChange(  
        // should reroute when one disk goes over the watermark  
        );
import java.util.concurrent.atomic.AtomicBoolean;  
            () -> clusterState,  
                    .settings(settings(Version.CURRENT).put("index.routing.allocation.require._id", "hot_node_1"))
                settings(Version.CURRENT).put("index.store.type", "remote_snapshot")  
            }
            }  
            )
        builder.put("warm_node", new DiskUsage("warm_node", "warm_node", "/foo/bar", 200, 40));  
            aboveFloodStageWatermark,
        ClusterState clusterStateWithBlocks = ClusterState.builder(clusterState)  
        assertEquals(new HashSet<>(Arrays.asList("test_1", "test_2")), indices.get());
        indicesToReleaseReadOnlyBlock.set(null);
        DiscoveryNode warmNode = newNode("warm_node", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));  
                    .numberOfReplicas(0)
        indicesToReleaseReadOnlyBlock.set(null);  
        ) {
        // High stage threshold (10%) = 200 * 0.1 = 20
            new ClusterInfo.ReservedSpace.Builder().add(new ShardId("", "", 0), reservedSpaceNode1).build()  
        assertNull(listenerReference.get());  
                listener.onResponse(null);
        // When free disk on node1 and node2 goes above 10% high watermark then release index block, ignoring reserved space
        };
        indicesToMarkReadOnly.set(null);  
        final List<String> messages = new ArrayList<>();  
            () -> 5.0
            new ClusterInfo.NodeAndPath("hot_node_1", "/foo/bar"),
        AtomicReference<Set<String>> indicesToReleaseReadBlock = new AtomicReference<>();  
                    .numberOfShards(1)  
                IndexMetadata.builder("test_2")
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
        assertFalse(reroute.get());
            protected void updateIndicesReadOnly(Set<String> indicesToBlockRead, ActionListener<Void> listener, boolean readOnly) {
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();
                    .put("index.routing.allocation.require._id", "warm_node")
            allocation
        ) {
            .put(  
        indicesToMarkReadOnly.set(null);
                .build(),  
                    Level.INFO,  
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
    }
            totalCacheSize,
    public void testReadBlockNotReleasedWhenAutoReleaseDisabled() {  
                    .numberOfShards(1)  
            protected void updateIndicesReadOnly(Set<String> indicesToMarkReadOnly, ActionListener<Void> listener, boolean readOnly) {
                } else {
            0,  
        assertRepeatedWarningMessages(  
                listener.onResponse(null);
import org.opensearch.cluster.ClusterState;
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, 19));
    }  
            .put(  
            "high disk watermark [90%] no longer exceeded on * but low disk watermark [85%] is still exceeded"
                    )  
                listener.onResponse(null);  
            0,  
            @Override  
    @TestLogging(value = "org.opensearch.cluster.routing.allocation.DiskThresholdMonitor:INFO", reason = "testing INFO/WARN logging")
                new MockLogAppender.UnseenEventExpectation(
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
        reservedSpaces.put(  
            null,
        };  
            () -> 2.0  
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
            .numberOfShards(1)
                listener.onResponse(null);  
        monitor = new DiskThresholdMonitor(
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
            () -> 5.0  
        );  
            protected void updateIndicesReadOnly(Set<String> indicesToMarkReadOnly, ActionListener<Void> listener, boolean readOnly) {
    public void testWarmNodeHighStageWatermarkBreach() {
            }  
        }
                    DiskThresholdMonitor.class.getCanonicalName(),
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        AtomicReference<Set<String>> indicesToReleaseReadBlock = new AtomicReference<>();  
        );
                listener.onResponse(null);
        }  
        );
        advanceTime.set(randomBoolean());
    }
import org.opensearch.cluster.ClusterInfo;  
            }
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        indicesToReleaseReadOnlyBlock.set(null);
            .build();
        assertThat(indicesToMarkReadOnly.get(), contains("test_1"));
        AtomicReference<Set<String>> indices = new AtomicReference<>();
            )  
            new ClusterInfo.NodeAndPath("hot_node_2", "/foo/bar"),
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
            Settings.EMPTY,
        reservedSpaces.put(
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
            0,  
                listener.onResponse(null);  
                } else {
                        settings(Version.CURRENT).put("index.store.type", "remote_snapshot")  
            .put(
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(0, 4)));
                .nodes(DiscoveryNodes.builder().add(newNode("hot_node_1")).add(newNode("hot_node_2")))  
            )
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test_1")).addAsNew(metadata.index("test_2")).build();  
                .nodes(DiscoveryNodes.builder().add(warmNode))
        assertRepeatedWarningMessages(  
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {  
        final AtomicReference<ClusterState> clusterStateRef = new AtomicReference<>(clusterState);  
            0,  
            }  
            () -> clusterState,
            null,  
        );
            null,
                listener.onResponse(null);  
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();
        AllocationService allocation = createAllocationService(
            0,  
        monitor.onNewInfo(clusterInfo(builder));  
        builder.put("warm_node", new DiskUsage("warm_node", "warm_node", "/foo/bar", 200, 40));
        );
            .build();
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            0,
            )
            "flood stage disk watermark [95%] exceeded on * all indices on this node will be marked read-only"  
        if (randomBoolean()) {
            }
        assertEquals(new HashSet<>(Arrays.asList("test_1", "test_2")), indicesToMarkReadOnly.get());
    private static AggregateFileCacheStats createAggregateFileCacheStats(long totalCacheSize, long active, long used) {  
        throws IllegalAccessException {
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .settings(
        assertNull(indicesToReleaseReadOnlyBlock.get());
        assertRepeatedWarningMessages(
    }
        // should reroute again after the reroute interval
        assertEquals(new HashSet<>(Arrays.asList("test_1", "test_2")), indices.get());
            mockAppender.assertAllExpectationsMatched();
                    indicesToReleaseReadBlock.set(indicesToUpdate);
            },
        if (randomBoolean()) {
            }  
            .blocks(ClusterBlocks.builder().addBlocks(indexMetadata).build())
                listener.onResponse(null);  
            .addAsNew(metadata.index("test_1"))  
        assertNull(indicesToMarkReadOnly.get());
        assertSingleInfoMessage(monitor, allDisksOk, "low disk watermark [85%] no longer exceeded on *");
    public void testIndexCreateBlockRemovedOnlyWhenAnyNodeAboveHighWatermark() {
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
import org.opensearch.cluster.OpenSearchAllocationTestCase;
import org.opensearch.Version;
        // Reserved space is ignored when applying block
 * compatible open source license.
                listener.onResponse(null);
            // should not re-route again within the reroute interval
    }
import java.util.List;  
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
            Settings.EMPTY,  
            Settings.EMPTY,
        Metadata metadata = Metadata.builder().put(indexMetadataBuilder).build();  
        ) {
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(Settings.EMPTY).millis() + 1,
        ) {
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(  
        Metadata metadata = Metadata.builder()  
            },  
            },  
    private static ClusterInfo clusterInfo(final Map<String, DiskUsage> diskUsages) {  
                .metadata(metadata)
            @Override
        advanceTime.set(false); // will do one reroute and emit warnings, but subsequent reroutes and associated messages are delayed
                    .settings(
            .build();
        // With auto_release disabled but default exclude_patterns [".*"],  
        assertEquals(countBlocksCalled.get(), 0);
            () -> 2.0  // dataToFileCacheSizeRatio = 2
        for (int i = between(1, 3); i >= 0; i--) {
                .metadata(metadata)  
        return clusterInfo(diskUsages, Map.of(), Map.of());
                assertFalse(readBlock);  
        indicesToMarkReadOnly.set(null);  
        // and should not trigger reroute
        final AtomicLong relocatingShardSizeRef = new AtomicLong();
        ) {
            .numberOfShards(1)
                listener.onResponse(null);  
                assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
            }
            @Override  
            @Override  
        );  
import org.apache.logging.log4j.LogManager;
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                listener.onResponse(null);
    }  
 * license agreements. See the NOTICE file distributed with
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
            Settings.EMPTY,  
        aboveHighWatermark.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(5, 9)));
        AtomicBoolean reroute = new AtomicBoolean(false);
                    .numberOfReplicas(0)  
                assertTrue(readBlock);  
                .routingTable(routingTable)
        // Test warm node exceeding high stage watermark
                assertTrue(readOnly);
        RoutingTable routingTable = RoutingTable.builder().build();  
        monitor.onNewInfo(clusterInfo(builder));
                .nodes(DiscoveryNodes.builder().add(warmNode))
 *  
                .routingTable(routingTable)
            allocation
                IndexMetadata.builder("test_2")  
        // If any node is no longer breaching high watermark, DiskThresholdMonitor should remove IndexCreateBlock.  
            AggregateFileCacheStats.FileCacheStatsType.PINNED_FILE_STATS
        listenerReference.getAndSet(null).onResponse(clusterState);
        currentTime.addAndGet(
        final Map<String, Long> shardSizes = new HashMap<>();
        );
            .numberOfReplicas(0);  
        builder = new HashMap<>();
            allocation
            .nodes(DiscoveryNodes.builder().add(newNode("hot_node_1")).add(newNode("hot_node_2")))  
            },
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 30));
        monitor.onNewInfo(clusterInfo(builder));  
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {  
        final ClusterState anotherFinalClusterState = ClusterState.builder(clusterState)
            },
            @Override  
            null,
        aboveFloodStageWatermark.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(0, 4)));
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()  
                assertNotNull(listener);
                listener.onResponse(null);
import org.opensearch.core.index.shard.ShardId;
            0,  
        AtomicInteger countBlocksCalled = new AtomicInteger();
            totalCacheSize,  
 * specific language governing permissions and limitations
            }
    }
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
import java.util.Arrays;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        AtomicLong currentTime = new AtomicLong();  
    public void testWarmNodeLowStageWatermarkBreach() {  
            protected void updateIndicesReadOnly(Set<String> indicesToMarkReadOnly, ActionListener<Void> listener, boolean readOnly) {  
            mockAppender.addExpectation(
        assertNull(indicesToReleaseReadOnlyBlock.get());
import org.opensearch.common.settings.ClusterSettings;
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            () -> 0L,
        monitor.onNewInfo(clusterInfo(allDisksOk));
                .nodes(DiscoveryNodes.builder().add(warmNode))
            (reason, priority, listener) -> {
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
            mockAppender.addExpectation(
                    .numberOfReplicas(0)
                listener.onResponse(null);
                assertTrue(reroute.compareAndSet(false, true));
            @Override  
            .build();
                .build(),
                assertTrue(readOnly);
                    assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));  
                assertTrue(readOnly);  
            "high disk watermark [90%] exceeded on * shards will be relocated away from this node* "
        // With auto_release disabled, read blocks should NOT be released
                assertNotNull(listener);  
        );
            .numberOfReplicas(0);
        advanceTime.set(true);  
                listener.onResponse(null);
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(  
            aboveFloodStageWatermark,
                    .put(clusterState.metadata().index("test_2").getSettings())
                assertThat(priority, equalTo(Priority.HIGH));  
        assertTrue(indicesToReleaseReadBlock.get().contains(".opensearch-security"));
                .build()  
        }
        assertEquals(countUnblockBlocksCalled.get(), 1);  
        );
                IndexMetadata.builder("test_1")  
            @Override  
            monitor.onNewInfo(clusterInfo(allDisksOk));
/*
        Settings settings = Settings.builder().put(DiskThresholdSettings.INDEX_READ_BLOCK_AUTO_RELEASE.getKey(), false).build();
            if (key.contains("warm")) {
        assertFalse(reroute.get());  
                listener.onResponse(null);
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()  
        ) {  
        indicesToMarkReadOnly.set(null);
            @Override
            @Override
            (reason, priority, listener) -> {
    private void assertMultipleWarningMessages(DiskThresholdMonitor monitor, final Map<String, DiskUsage> diskUsages, List<String> messages)
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
    }
        monitor = new DiskThresholdMonitor(  
        // Since block is already present, DiskThresholdMonitor should not again try to apply block.  
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        final ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
                if (readOnly) {
                .routingTable(routingTable)  
        Map<String, DiskUsage> builder = new HashMap<>();
            protected void updateIndicesReadOnly(Set<String> indicesToMarkReadOnly, ActionListener<Void> listener, boolean readOnly) {  
        RoutingTable routingTable = RoutingTable.builder()
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 1));
            aboveLowWatermark,
        timeSupplier.getAsLong(); // advance time long enough to do another reroute  
                    .put(IndexMetadata.INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true)
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(5, 9)));  
        monitor.onNewInfo(clusterInfo(builder));
            mockAppender.addExpectation(  
            0,
        Metadata metadata = Metadata.builder()
                    )
        assertNull(indicesToBlockRead.get());  
            .put(  
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(0, 4)));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 5));  
                settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
            allocation  
        assertNotNull(listenerReference.get());  
import java.util.concurrent.atomic.AtomicReference;  
                .build(),  
            assertLogging(monitor, diskUsages, Level.WARN, messages.get(index));
                assertTrue(reroute.compareAndSet(false, true));
            )
            }
                countBlocksCalled.set(countBlocksCalled.get() + 1);  
            used,
                    .put(IndexMetadata.INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true)  
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()  
                )
                + "the node is expected to continue to exceed the high disk watermark when these relocations are complete"  
    }
            null,  
            @Override
                }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        };  
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
import java.util.function.LongSupplier;
                assertNotNull(listener);
                listener.onResponse(null);
            allocation  
                listener.onResponse(null);
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        Metadata metadata = Metadata.builder().put(indexMetadataBuilder).build();
            .put(  
                    .settings(
            () -> 2.0  // dataToFileCacheSizeRatio = 2  
        final ClusterState clusterState = applyStartedShardsUntilNoChange(  
            currentTime.addAndGet(
            "high disk watermark [90%] exceeded on * shards will be relocated away from this node* "  
        AtomicBoolean reroute = new AtomicBoolean(false);  
            .build();
                new MockLogAppender.UnseenEventExpectation(  
            },
            }
        final Map<String, DiskUsage> diskUsages,
            builder.put("node3", new DiskUsage("node3", "node3", "/foo/bar", 100, between(0, 100)));  
            @Override  
            .settings(  
                assertFalse(readOnly);  
        Metadata metadata = Metadata.builder().build();
        Map<String, DiskUsage> builder = new HashMap<>();  
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
        advanceTime.set(false); // will do one reroute and emit warnings, but subsequent reroutes and associated messages are delayed
        allDisksOk.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(15, 100)));
        AtomicReference<Set<String>> indices = new AtomicReference<>();
        // When disk usage on one node is between the high and flood-stage watermarks, nothing changes
            @Override
                .nodes(DiscoveryNodes.builder().add(newNode("hot_node_1")).add(newNode("hot_node_2")))  
            }
            currentTime::get,  
        // but user_index should NOT be released
        final Map<String, Long> shardSizes
                assertTrue(readOnly);
                listener.onResponse(null);
        diskUsages.forEach((key, value) -> {
        monitor.onNewInfo(clusterInfo(builder));  
                .metadata(metadata)
        assertNotNull(listenerReference.get());  
        IndexMetadata indexMetadata = IndexMetadata.builder(clusterState.metadata().index("test_2"))
                listener.onResponse(null);
        AllocationService allocation = createAllocationService(
        monitor.onNewInfo(clusterInfo(builder, reservedSpaces, Map.of()));  
            currentTime::get,  
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(0, 100)));
                assertThat(priority, equalTo(Priority.HIGH));
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();
            }
        reroute.set(false);
        builder = new HashMap<>();  
        Metadata metadata = Metadata.builder()
            );  
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {  
        assertTrue(countBlocksCalled.get() == 0);
            monitor,
        final LongSupplier timeSupplier = new LongSupplier() {  
        assertLogging(monitor, diskUsages, Level.INFO, message);
        );  
            },
        assertNotNull(listenerReference.get());
            )  
        // Since Block is already present and nodes are below high watermark so neither block nor unblock will be called.
        monitor.onNewInfo(clusterInfo(builder, reservedSpaces, Map.of()));
            .put(  
        AtomicBoolean reroute = new AtomicBoolean(false);
                assertTrue(readOnly);
            );
        );  
        advanceTime.set(randomBoolean());  
                assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
            }
            (reason, priority, listener) -> {  
                IndexMetadata.builder("test_1")
            @Override
            () -> 5.0
            clusterStateRef::get,
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {  
            0,
        currentTime.addAndGet(randomLongBetween(60001, 120000));
    }  
                logger.info("time: [{}]", time);
            () -> 5.0  
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        // Free space = 28 < 30, so should exceed low stage
            builder.put("node3", new DiskUsage("node3", "node3", "/foo/bar", 100, between(0, 100)));  
    }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        messages.add(
                            .put("index.routing.allocation.require._id", "warm_node")  
                throw new AssertionError("unexpected");
            }  
            .put(IndexMetadata.builder("test_2").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
            .numberOfShards(1)
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));  
        assertEquals(countBlocksCalled.get(), 0);
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(DiskThresholdMonitor.class))) {
        ) {
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(0, 4)));  
                    .numberOfReplicas(0)  
        FileCacheStats pinnedStats = new FileCacheStats(
            monitor,
            @Override  
                settings(Version.CURRENT).put("index.store.type", "remote_snapshot")  
        assertFalse(indicesToMarkReadOnly.get().isEmpty());
            }
            @Override  
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            AggregateFileCacheStats.FileCacheStatsType.FULL_FILE_STATS  
import org.opensearch.cluster.routing.RoutingNode;  
            AggregateFileCacheStats.FileCacheStatsType.OVER_ALL_STATS
                listener.onResponse(null);  
        ) {
            allocation
        advanceTime.set(true);
                IndexMetadata.builder("remote_index")
        monitor.onNewInfo(clusterInfo(builder, reservedSpaces, Map.of()));
            () -> 2.0  // dataToFileCacheSizeRatio = 2
        relocatingShardSizeRef.set(-5L);
            .settings(
            .addAsNew(metadata.index("test"))
        final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> reservedSpaces = new HashMap<>();
                IndexMetadata.builder("remote_index")
        );  
        allDisksOk.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, 50));  
        builder = new HashMap<>();
            @Override  
        };
            .addAsNew(metadata.index("test_2"))
            @Override
                IndexMetadata.builder("remote_index")  
                assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
        if (randomBoolean()) {
            monitor,
        // Need to add delay in current time to allow nodes to be removed high watermark list.  
            () -> clusterState,  
        );
        AllocationService allocation = createAllocationService(
        assertNotNull(listenerReference.get());
        advanceTime.set(randomBoolean());
            .build();
        assertTrue(clusterStateWithBlocks.blocks().indexBlocked(ClusterBlockLevel.WRITE, "test_2"));
        );
        AllocationService allocation = createAllocationService(
            .blocks(ClusterBlocks.builder().addBlocks(indexMetadata).build())
            null,
            (reason, priority, listener) -> {  
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, between(0, 4)));  
                assertTrue(indices.compareAndSet(null, indicesToMarkReadOnly));
        );
        // Create a system index (dot-prefixed) and a user index, both with read blocks
                assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));  
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
            aboveLowWatermark,  
                } else {
        assertThat(indicesToMarkReadOnly.get(), contains("test_1"));  
        );
                listener.onResponse(clusterState);
            .build();
import org.opensearch.core.action.ActionListener;  
        AllocationService allocation = createAllocationService(
                }  
        currentTime.addAndGet(randomLongBetween(0, 120000));
                )  
                    )
                .metadata(metadata)
        DiscoveryNode warmNode = newNode("warm_node", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
            new ClusterInfo.NodeAndPath("hot_node_1", "/foo/bar"),
            @Override
    }  
            .settings(  
        AtomicReference<Set<String>> indicesToBlockRead = new AtomicReference<>();
        builder.put("warm_node_search_block", new DiskUsage("warm_node_search_block", "warm_node_search_block", "/foo/bar", 200, 40));
        ) {  
        final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> reservedSpaces = new HashMap<>(1);  
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {  
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
            randomLongBetween(  
            @Override
            Settings.EMPTY,
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
            () -> 0L,
            }
        // should not reroute again when it is not required  
            new ClusterInfo.ReservedSpace.Builder().add(new ShardId("baz", "quux", 0), between(41, 100)).build()  
                .build(),  
        // Test warm node exceeding low stage watermark
        AtomicInteger countBlocksCalled = new AtomicInteger();
        final int reservedSpaceNode2 = between(0, 10);
        Metadata metadata = Metadata.builder()
import java.util.Collections;  
                    .settings(settings(Version.CURRENT).put("index.routing.allocation.require._id", "hot_node_1"))
 *     http://www.apache.org/licenses/LICENSE-2.0
                .build(),
                listener.onResponse(null);
            monitor,  
            )
        };  
                listener.onResponse(null);  
        Map<String, DiskUsage> builder = new HashMap<>();
import org.opensearch.test.junit.annotations.TestLogging;
                assertTrue(indices.compareAndSet(null, indicesToMarkReadOnly));
 * not use this file except in compliance with the License.
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        for (int index = 0; index < messages.size(); index++) {  
                assertThat(priority, equalTo(Priority.HIGH));
        aboveLowWatermark.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(10, 14)));
            aboveFloodStageWatermark,
        // complete reroute
    public void testWarmNodeFileCacheSearchThresholdBreach() {  
            }
            @Override  
            .build();
                listener.onResponse(null);
            null,  
        FileCacheStats fullStats = new FileCacheStats(  
                assertThat(priority, equalTo(Priority.HIGH));  
    private void assertLogging(DiskThresholdMonitor monitor, final Map<String, DiskUsage> diskUsages, Level level, String message)
                    assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
            )
                assertTrue(indicesToBlockRead.compareAndSet(null, indicesToUpdate));  
        indicesToMarkReadOnly.set(null);  
                listener.onResponse(null);
        assertThat(indicesToReleaseReadOnlyBlock.get(), contains("test_2"));  
                .build(),
            @Override  
 * Unless required by applicable law or agreed to in writing,
            }
        throws IllegalAccessException {  
    public void testDoesNotSubmitRerouteTaskTooFrequently() {
import org.opensearch.cluster.block.ClusterBlocks;  
                listener.onResponse(null);
                + "the node is expected to continue to exceed the high disk watermark when these relocations are complete"
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));  
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
                    .numberOfReplicas(0)  
            () -> clusterState,  
        shardSizes.put("[remote_index][0][p]", 172L);
        // Should not mark remote indices read-only due to low stage breach
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, between(0, 4)));
        assertNull(listenerReference.get());
            )
        assertThat(clusterState.getRoutingTable().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(8));  
    }
            () -> clusterStateWithBlocks,
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
            0,
    }
                assertThat(priority, equalTo(Priority.HIGH));
        assertSingleInfoMessage(monitor, allDisksOk, "low disk watermark [85%] no longer exceeded on *");
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder("remote_index")
        );  
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {  
        };  
        AtomicLong currentTime = new AtomicLong();
    public void testWarmNodeFileCacheReleaseLocks() {  
        IndexMetadata indexMetadata = IndexMetadata.builder(clusterState.metadata().index("test_2"))
            }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                IndexMetadata.builder("remote_index")
            @Override
                .build(),
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
import org.opensearch.cluster.block.ClusterBlockLevel;
        final ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            }
            (reason, priority, listener) -> {
            Settings.builder()  
            () -> 5.0
                    .numberOfShards(1)
        };  
                .metadata(metadata)  
        AllocationService allocation = createAllocationService(
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
                    .put(clusterState.metadata().index("test"), false)
        // Free space = 18 < 20, so should exceed high stage
                    .numberOfReplicas(0)  
            () -> clusterState,
            .put(
            () -> 0L,  
            aboveHighWatermark,
import org.opensearch.cluster.node.DiscoveryNodeRole;
        builder.put("warm_node", new DiskUsage("warm_node", "warm_node", "/foo/bar", 200, 18));
 */  
            (reason, priority, listener) -> {
import org.opensearch.common.Priority;  
                    )
            }
        );
        Metadata metadata = Metadata.builder().put(systemIndexBuilder).put(userIndexBuilder).build();  
        indicesToReleaseReadOnlyBlock.set(null);
            mockAppender.assertAllExpectationsMatched();
        Map<String, DiskUsage> builder = new HashMap<>();
public class DiskThresholdMonitorTests extends OpenSearchAllocationTestCase {
            .addAsNew(metadata.index("test_1"))
        assertSingleInfoMessage(
        };
            }  
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
            .settings(
            @Override
        Metadata metadata = Metadata.builder()
                } else if (key.contains("index_block")) {
        monitor.onNewInfo(clusterInfo(builder));
        builder = new HashMap<>();
        shardSizes.put("[user_index][0][p]", 86L);  
 *
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
            .put(
            .put(
        AtomicBoolean reroute = new AtomicBoolean(false);
                listener.onResponse(null);

                    .settings(
        // Create a system index (dot-prefixed) and a user index, both with read blocks
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();
            Settings.EMPTY,
        indicesToMarkReadOnly.set(null);
            () -> clusterState,
            monitor.onNewInfo(clusterInfo(diskUsages));
            }
    private static ClusterInfo clusterInfo(
            .build();
            "high disk watermark [90%] exceeded on * shards will be relocated away from this node* "
                assertThat(priority, equalTo(Priority.HIGH));
            }
        indicesToReleaseReadOnlyBlock.set(null);
                listener.onResponse(null);
            () -> clusterState,
        throws IllegalAccessException {
            () -> 0L,
                } else {
        assertRepeatedWarningMessages(
        final ClusterState anotherFinalClusterState = ClusterState.builder(clusterState)
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
    public void testWarmNodeHighStageWatermarkBreach() {
            .blocks(ClusterBlocks.builder().addBlocks(indexMetadata).build())
            (reason, priority, listener) -> {
                120000
            totalCacheSize,
        // Flood stage threshold (5%) = 200 * 0.05 = 10
                listener.onResponse(null);
                settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
        assertNull(indicesToReleaseReadOnlyBlock.get());
                listener.onResponse(null);
            @Override
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test_1")).addAsNew(metadata.index("test_2")).build();
            (reason, priority, listener) -> {
    }
        AtomicLong currentTime = new AtomicLong();
                listener.onResponse(null);
        reservedSpaces.put(
                IndexMetadata.builder("remote_index")
        assertSingleInfoMessage(monitor, allDisksOk, "low disk watermark [85%] no longer exceeded on *");
            @Override
    public void testWarmNodeFileCacheReleaseLocks() {
                assertTrue(reroute.compareAndSet(false, true));
        AtomicReference<Set<String>> indicesToReleaseReadOnlyBlock = new AtomicReference<>();
            () -> 2.0  // dataToFileCacheSizeRatio = 2
        assertNull(indicesToMarkReadOnly.get());
        Settings settings = Settings.builder().put(CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE.getKey(), true).build();
        assertRepeatedWarningMessages(
                120000
                IndexMetadata.builder("remote_index")
            .put(
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
        final Map<String, Long> shardSizes = new HashMap<>();
            )
                    .put(indexMetadata, true)
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
        };
            @Override
        indicesToReleaseReadOnlyBlock.set(null);
        assertNull(listenerReference.get());
            }
            @Override
    }
        monitor.onNewInfo(clusterInfo(builder));
            currentTime::get,
                listener.onResponse(null);
    }
        final ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            protected void updateIndicesReadOnly(Set<String> indicesToMarkReadOnly, ActionListener<Void> listener, boolean readOnly) {
        assertEquals(countUnblockBlocksCalled.get(), 0);
 * Modifications Copyright OpenSearch Contributors. See
            @Override
            @Override
        };
        return new AggregateFileCacheStats(System.currentTimeMillis(), overallStats, fullStats, blockStats, pinnedStats);
            settings,
        FileCacheStats fullStats = new FileCacheStats(
            "flood stage disk watermark [95%] exceeded on * all indices on this node will be marked read-only"
        monitor.onNewInfo(clusterInfo(allDisksOk));
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
                + "Number of nodes above high watermark: 1."
        builder.put("warm_node", new DiskUsage("warm_node", "warm_node", "/foo/bar", 200, 40));
                listener.onResponse(null);
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
        if (randomBoolean()) {
                            .put("index.routing.allocation.require._id", "warm_node")
                .build(),
                assertTrue(reroute.compareAndSet(false, true));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        aboveLowWatermark.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(10, 14)));
        assertEquals(new HashSet<>(Arrays.asList("test_1", "test_2")), indices.get());
                assertTrue(readOnly);
            0,
            allocation
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
                .metadata(metadata)
        currentTime.addAndGet(
            }
                            .put("index.routing.allocation.require._id", "warm_node_index_block")
                    fileCacheStats.put(key, createAggregateFileCacheStats(100, between(90, 99), 99));
import org.opensearch.core.action.ActionListener;
                    )
        AtomicReference<Set<String>> indicesToReleaseReadBlock = new AtomicReference<>();
            .build();
                IndexMetadata.builder("test")
                }
    public void testDiskMonitorLogging() throws IllegalAccessException {
                logger.info("time: [{}]", time);
                }
        final Map<String, DiskUsage> aboveLowWatermark = new HashMap<>();
                + "the node is expected to continue to exceed the high disk watermark when these relocations are complete"
        Map<String, DiskUsage> builder = new HashMap<>();
            @Override
            }
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
            Settings.EMPTY,
                    .settings(
            aboveFloodStageWatermark,
    }
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
                .nodes(DiscoveryNodes.builder().add(newNode("hot_node_1")).add(newNode("hot_node_2")))
    private void assertRepeatedWarningMessages(DiskThresholdMonitor monitor, final Map<String, DiskUsage> diskUsages, String message)
            null,
            mockAppender.addExpectation(
        assertNoLogging(monitor, diskUsages);
                assertTrue(readOnly);
            .put(
            @Override
            Settings.builder()
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
            .addAsNew(metadata.index("test_1"))
        DiscoveryNode warmNode = newNode("warm_node", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(5, 9)));
            currentTime.addAndGet(
        throws IllegalAccessException {
            long sizeOfRelocatingShards(RoutingNode routingNode, DiskUsage diskUsage, ClusterInfo info, ClusterState reroutedClusterState) {
                    level == Level.INFO ? Level.WARN : Level.INFO,
                if (readOnly) {
                new MockLogAppender.UnseenEventExpectation(
                return time;
    }
        // should reroute again when one disk is still over the watermark
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
                    )
            @Override
        assertSingleInfoMessage(
                .nodes(DiscoveryNodes.builder().add(newNode("hot_node_1")).add(newNode("hot_node_2")))
        RoutingTable routingTable = RoutingTable.builder()
            "Putting index create block on cluster as all nodes are breaching high disk watermark. "
        monitor.onNewInfo(clusterInfo(builder));
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(0, 100)));
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();
            aboveLowWatermark,
                    .build()
                Settings.builder()
        );
            }
            () -> 5.0
        indicesToMarkReadOnly.set(null);
            () -> 5.0
            .numberOfReplicas(0);
        reroute.set(false);
                .routingTable(routingTable)
        // should not reroute again when it is not required
                    .put(clusterState.metadata().index("test_2").getSettings())
        AllocationService allocation = createAllocationService(
import org.opensearch.cluster.metadata.Metadata;
            () -> 5.0
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
            long time;
                if (readOnly) {
            0,
        aboveFloodStageWatermark.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(0, 4)));
        if (randomBoolean()) {
            aboveHighWatermark,
                }
                    .numberOfShards(1)
            allocation
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    }
import org.opensearch.cluster.block.ClusterBlockLevel;
                settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
    public void testWarmNodeLowStageWatermarkBreach() {
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();
        indicesToMarkReadOnly.set(null);
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
public class DiskThresholdMonitorTests extends OpenSearchAllocationTestCase {
            0,
                .routingTable(routingTable)
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(0, 4)));
                .nodes(DiscoveryNodes.builder().add(warmNode))
            null,
        monitor.onNewInfo(clusterInfo(builder, reservedSpaces, Map.of()));
            }
        }
        // High stage threshold (10%) = 200 * 0.1 = 20
                assertFalse(readOnly);
    private void assertMultipleWarningMessages(DiskThresholdMonitor monitor, final Map<String, DiskUsage> diskUsages, List<String> messages)
        monitor.onNewInfo(clusterInfo(builder));
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE;
                    )
    }
                .metadata(metadata)
            protected void updateIndicesReadOnly(Set<String> indicesToMarkReadOnly, ActionListener<Void> listener, boolean readOnly) {
        advanceTime.set(false); // will do one reroute and emit warnings, but subsequent reroutes and associated messages are delayed
            // should not re-route again within the reroute interval
            monitor,
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
            null,
                assertThat(priority, equalTo(Priority.HIGH));
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 *
            null,
        AllocationService allocation = createAllocationService(
                    .numberOfReplicas(0)
        );
                    .numberOfShards(1)
                assertThat(priority, equalTo(Priority.HIGH));
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(5, 90)));
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder("remote_index")
                .metadata(metadata)
                    assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
            (reason, priority, listener) -> {
        indicesToMarkReadOnly.set(null);
                    .put(IndexMetadata.INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true)
        builder = new HashMap<>();
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
            .addAsNew(metadata.index("test"))
            (reason, priority, listener) -> {
            )
            0,
        final ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        );
    }
                    assertTrue(indicesToReleaseReadOnlyBlock.compareAndSet(null, indicesToUpdate));
            @Override
                    .numberOfReplicas(0)
            null,
            () -> 0L,
            @Override
        );
                if (advanceTime.get()) {
        };
        AtomicBoolean reroute = new AtomicBoolean(false);
        relocatingShardSizeRef.set(-5L);
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
            protected void updateIndicesReadBlock(Set<String> indicesToBlockRead, ActionListener<Void> listener, boolean readBlock) {
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(10, 100)));
            .put(
import org.apache.logging.log4j.Level;
            .build();
        advanceTime.set(randomBoolean());
            () -> clusterState,
            AggregateFileCacheStats.FileCacheStatsType.PINNED_FILE_STATS
 * this work for additional information regarding copyright
        final List<String> messages = new ArrayList<>();
        // Initially all the nodes are breaching high watermark and IndexCreateBlock is already present on the cluster.
        builder = new HashMap<>();
        shardSizes.put("[remote_index][0][p]", 192L);
                    DiskThresholdMonitor.class.getCanonicalName(),
            @Override
    private void assertSingleInfoMessage(DiskThresholdMonitor monitor, final Map<String, DiskUsage> diskUsages, String message)
        RoutingTable routingTable = RoutingTable.builder()
                )
            (reason, priority, listener) -> {
        }
        DiscoveryNode warmNode = newNode("warm_node", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
                assertTrue(readBlock);
                120000
            .build();
            .put(
                listener.onResponse(null);
                assertTrue(readOnly);
        return new ClusterInfo(diskUsages, null, shardSizes, null, reservedSpace, fileCacheStats, Map.of());
        shardSizes.put("[remote_index][0][p]", 172L);
        shardSizes.put("[remote_index][0][p]", 172L);
        builder.put("warm_node_index_block", new DiskUsage("warm_node_index_block", "warm_node_index_block", "/foo/bar", 200, 40));
        shardSizes.put("[remote_index][0][p]", 172L);
            (reason, priority, listener) -> {
            (reason, priority, listener) -> {
            builder.put("node3", new DiskUsage("node3", "node3", "/foo/bar", 100, between(0, 100)));
        reservedSpaces.put(
            allocation
            .put(
        Metadata metadata = Metadata.builder().build();
        messages.add(
        assertEquals(new HashSet<>(Arrays.asList("test_1", "test_2")), indices.get());
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                    assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
                listener.onResponse(null);
                .routingTable(routingTable)
                assertTrue(indices.compareAndSet(null, indicesToMarkReadOnly));
            allocation
                assertThat(priority, equalTo(Priority.HIGH));
            }
            () -> clusterState,
        // Test warm node exceeding low stage watermark
            }
                assertTrue(reroute.compareAndSet(false, true));
                }
            Settings.EMPTY,
            .numberOfReplicas(0);
                .blocks(ClusterBlocks.builder().addBlocks(indexMetadataBuilder.build()).build())
            @Override
        // Test warm node exceeding flood stage watermark
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
                randomLongBetween(0, DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(Settings.EMPTY).millis())
            () -> 0L,
        });
        assertNull(indicesToMarkReadOnly.get());
                .routingTable(routingTable)
                IndexMetadata.builder("test_2")
        currentTime.addAndGet(randomLongBetween(0, 120000));
        // Need to add delay in current time to allow nodes to be removed high watermark list.
        builder = new HashMap<>();
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
        assertThat(clusterState.getRoutingTable().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(8));
        final Map<String, Long> shardSizes = new HashMap<>();
                            .put("index.routing.allocation.require._id", "warm_node")
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, 9));
            .numberOfShards(1)
        AllocationService allocation = createAllocationService(
        throws IllegalAccessException {
            () -> 0L,
        final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> reservedSpaces = new HashMap<>(1);
            Settings.EMPTY,
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
        Metadata metadata = Metadata.builder()
        return clusterInfo(diskUsages, Map.of(), Map.of());
        monitor.onNewInfo(clusterInfo(allDisksOk));
            },
            used,
                    "any INFO message",
        }
        AllocationService allocation = createAllocationService(
        indicesToReleaseReadOnlyBlock.set(null);
            .settings(
    public void testDoesNotSubmitRerouteTaskTooFrequently() {
        builder.put("warm_node", new DiskUsage("warm_node", "warm_node", "/foo/bar", 200, 8));
            assertNull(listenerReference.get());
/*
            0,
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
        AtomicReference<Set<String>> indices = new AtomicReference<>();
                    .put(clusterState.metadata().index("test"), false)
import java.util.concurrent.atomic.AtomicBoolean;
        shardSizes.put("[user_index][0][p]", 86L);
                    .put("index.routing.allocation.require._id", "warm_node_index_block")
            randomLongBetween(
 *
    public void testWarmNodeFloodStageWatermarkBreach() {
        builder = new HashMap<>();
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
        allDisksOk.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(15, 100)));
import org.opensearch.cluster.routing.RoutingNode;
        IndexMetadata indexMetadata = IndexMetadata.builder(clusterState.metadata().index("test_2"))
            aboveFloodStageWatermark,
        assertTrue(reroute.get());
        // Total addressable space = dataToFileCacheSizeRatio * nodeCacheSize = 2.0 * 100 = 200
                .routingTable(routingTable)
            mockAppender.assertAllExpectationsMatched();
import org.opensearch.cluster.routing.RoutingTable;
            @Override
                IndexMetadata.builder("test_1")
            );
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
            Settings.EMPTY,
                    .numberOfShards(1)
        monitor.onNewInfo(clusterInfo(oneDiskAboveWatermark));
            }
        );
            currentTime.addAndGet(
            @Override
        assertEquals(countUnblockBlocksCalled.get(), 1);
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
                .routingTable(routingTable)
            }
        // Should mark remote indices read-only due to flood stage breach
        );
    private static AggregateFileCacheStats createAggregateFileCacheStats(long totalCacheSize, long active, long used) {
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
            @Override
                listener.onResponse(null);
        assertSingleInfoMessage(monitor, allDisksOk, "low disk watermark [85%] no longer exceeded on *");
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
        shardSizes.put("[.opensearch-security][0][p]", 86L);
            )
        monitor.onNewInfo(clusterInfo(builder, reservedSpaces, Map.of()));
                listener.onResponse(null);
            0,
            () -> 2.0
                    .put(clusterState.metadata().index("test_1"), false)
            protected void updateIndicesReadOnly(Set<String> indicesToMarkReadOnly, ActionListener<Void> listener, boolean readOnly) {
            (reason, priority, listener) -> {
        listenerReference.getAndSet(null).onResponse(null);
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();
            mockAppender.start();
        advanceTime.set(true);
        final Map<String, Long> shardSizes = new HashMap<>();
        advanceTime.set(randomBoolean());
        };
        DiscoveryNode warmNode = newNode("warm_node", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
            totalCacheSize,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // now we mark one index as read-only and assert that we don't mark it as such again
                listener.onResponse(null);
            (reason, priority, listener) -> listener.onResponse(null),
 * under the License.
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
            .build();
            () -> clusterState,
        AtomicLong currentTime = new AtomicLong();
            },
                listener.onResponse(null);
        );
        currentTime.addAndGet(randomLongBetween(0, 120000));
        Settings settings = Settings.builder().build();
        ) {
    }
import org.opensearch.common.settings.ClusterSettings;
                            .put("index.routing.allocation.require._id", "warm_node")
        indicesToMarkReadOnly.set(null);
        assertEquals(countUnblockBlocksCalled.get(), 0);
            assertLogging(monitor, diskUsages, Level.WARN, messages.get(index));
            }
                assertTrue(readOnly);
            )
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
            monitor,
            }
        // Test warm node exceeding high stage watermark
        Map<String, DiskUsage> builder = new HashMap<>();
        assertSingleInfoMessage(
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
                assertTrue(listenerReference.compareAndSet(null, listener));
        assertThat(indicesToMarkReadOnly.get(), contains("test_1"));
        shardSizes.put("[remote_index][0][p]", 172L);
import org.opensearch.cluster.routing.ShardRoutingState;
            0,
        );
            @Override
                + "the node is expected to continue to exceed the high disk watermark when these relocations are complete"
        );
            }
 * ownership. Elasticsearch licenses this file to you under
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            }
            @Override
                assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
                listener.onResponse(null);
        AtomicReference<ActionListener<ClusterState>> listenerReference = new AtomicReference<>();
            (reason, priority, listener) -> {
        final AtomicReference<ClusterState> clusterStateRef = new AtomicReference<>(clusterState);
            monitor.onNewInfo(clusterInfo(allDisksOk));
                    "*"
            }
            .build();
        ) {
        };
            (reason, priority, listener) -> {
    public void testIndexCreateBlockRemovedOnlyWhenAnyNodeAboveHighWatermark() {
            .put(
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 5));
        assertSingleInfoMessage(
        monitor.onNewInfo(clusterInfo(builder, reservedSpaces, Map.of()));
            }
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();
        assertFalse(indicesToReleaseReadBlock.get().contains("user_index"));
            @Override
            () -> 2.0  // dataToFileCacheSizeRatio = 2
                    countBlocksCalled.set(countBlocksCalled.get() + 1);
        AllocationService allocation = createAllocationService(
            },
            settings,
        AtomicLong currentTime = new AtomicLong();
 * The OpenSearch Contributors require contributions made to
    ) {
            allocation
import java.util.Collections;
import org.opensearch.cluster.node.DiscoveryNode;
            Settings.EMPTY,
                    .settings(
            new ClusterInfo.ReservedSpace.Builder().add(new ShardId("", "", 0), reservedSpaceNode1).build()
                listener.onResponse(null);
            "flood stage disk watermark [95%] exceeded on * all indices on this node will be marked read-only"
            @Override
            }
        assertNull(indicesToReleaseReadOnlyBlock.get());
        ) {
            currentTime::get,
        // When free disk on any of node1 or node2 goes below 5% flood watermark, then apply index block on indices not having the block
        assertEquals(countBlocksCalled.get(), 0);
            aboveFloodStageWatermark,
                Metadata.builder(clusterState.metadata())
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
                listener.onResponse(null);
                monitor.onNewInfo(clusterInfo(diskUsages));
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();
            },
            // should not re-route again within the reroute interval
        assertTrue(clusterStateWithBlocks.blocks().indexBlocked(ClusterBlockLevel.WRITE, "test_2"));
            () -> 0L,
            )
            0,
            () -> 0L,
            0,
            },
            @Override
import java.util.HashMap;
            @Override
                    .numberOfReplicas(0)
            () -> clusterStateWithBlocks,
        AtomicBoolean reroute = new AtomicBoolean(false);
        Map<String, DiskUsage> builder = new HashMap<>();
        assertNull(indicesToReleaseReadOnlyBlock.get());
        advanceTime.set(true);
            },
        assertEquals(Collections.singleton("test_1"), indices.get());
                    .put(IndexMetadata.INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true)
        final Map<String, Long> shardSizes
    private void assertLogging(DiskThresholdMonitor monitor, final Map<String, DiskUsage> diskUsages, Level level, String message)
                assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
                IndexMetadata.builder("remote_index")
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                .metadata(metadata)
                    assertTrue(indicesToReleaseReadOnlyBlock.compareAndSet(null, indicesToUpdate));
            )
                    .put("index.routing.allocation.require._id", "warm_node")
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        assertEquals(countBlocksCalled.get(), 0);
            .put(IndexMetadata.builder("test_1").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
                IndexMetadata.builder("test")
            () -> 5.0
        Metadata metadata = Metadata.builder().put(systemIndexBuilder).put(userIndexBuilder).build();
            .build();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        // complete reroute
        aboveHighWatermark.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(5, 9)));
            Settings.EMPTY,
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> reservedSpaces = new HashMap<>();
        advanceTime.set(true); // only log about dropping below the low disk watermark on a reroute
        monitor.onNewInfo(clusterInfo(builder));
        advanceTime.set(true);
                    .settings(settings(Version.CURRENT).put("index.routing.allocation.require._id", "hot_node_1"))
                listener.onResponse(null);
                    )
        monitor.onNewInfo(clusterInfo(allDisksOk));
            }
        AtomicBoolean reroute = new AtomicBoolean(false);
        assertNotNull(listenerReference.get());
            },
        // Reserved space is ignored when applying block
            .numberOfShards(1)
        );
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
            () -> clusterState,
                .metadata(metadata)
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder("remote_index")
        builder = new HashMap<>();
        builder = new HashMap<>();
            .settings(
        throws IllegalAccessException {
            )
            for (int i = between(1, 3); i >= 0; i--) {
            }
        );
        oneDiskAboveWatermark.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(5, 9)));
        );
            )
        );
            }
        );
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        Metadata metadata = Metadata.builder().put(indexMetadataBuilder).build();
                listener.onResponse(null);
                .blocks(ClusterBlocks.builder().addGlobalBlock(Metadata.CLUSTER_CREATE_INDEX_BLOCK).build())
                assertThat(priority, equalTo(Priority.HIGH));
            builder.put("node3", new DiskUsage("node3", "node3", "/foo/bar", 100, between(0, 100)));
            }
        assertNull(indicesToMarkReadOnly.get());
            0,
        indicesToMarkReadOnly.set(null);
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, 4));
                listener.onResponse(null);
        );
            )
            }
import org.opensearch.Version;
        Map<String, DiskUsage> builder = new HashMap<>();
            "high disk watermark [90%] no longer exceeded on * but low disk watermark [85%] is still exceeded"
            }
                assertTrue(indicesToBlockRead.compareAndSet(null, indicesToUpdate));
            "low disk watermark [85%] exceeded on * replicas will not be assigned to this node"
                    .numberOfReplicas(0)
                .build(),
        AllocationService allocation = createAllocationService(
                .metadata(metadata)
            .addAsNew(metadata.index("test_2"))
            (reason, priority, listener) -> {
        final AtomicLong relocatingShardSizeRef = new AtomicLong();
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(DiskThresholdMonitor.class))) {
                    .numberOfShards(1)
        AtomicReference<Set<String>> indicesToReleaseReadBlock = new AtomicReference<>();
            new ClusterInfo.ReservedSpace.Builder().add(new ShardId("baz", "quux", 0), between(41, 100)).build()
 */
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        currentTime.addAndGet(randomLongBetween(0, 120000));
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
            .put(
        // should not re-route again before reroute has completed
        assertThat(indicesToReleaseReadOnlyBlock.get(), contains("test_2"));
        };
import org.opensearch.index.store.remote.filecache.FileCacheStats;
                listener.onResponse(null);
            () -> 0L,
            0,
                IndexMetadata.builder("remote_index")
                .build(),
                assertFalse(readBlock);
            .nodes(DiscoveryNodes.builder().add(newNode("hot_node_1")).add(newNode("hot_node_2")))
        assertNotNull(indicesToMarkReadOnly.get());
            aboveLowWatermark,
        AllocationService allocation = createAllocationService(
            .nodes(DiscoveryNodes.builder().add(newNode("hot_node_1")))
                new MockLogAppender.SeenEventExpectation("expected message", DiskThresholdMonitor.class.getCanonicalName(), level, message)
                listener.onResponse(null);
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        messages.add(
                    "*"
        final Map<String, Long> shardSizes = new HashMap<>();
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
                }
            aboveHighWatermark,
        );
                listener.onResponse(null);
            () -> 5.0
        assertFalse(reroute.get());
        final Map<String, DiskUsage> aboveHighWatermark = new HashMap<>();
            currentTime::get,
        }
                listener.onResponse(null);
            .build();
        assertSingleInfoMessage(monitor, allDisksOk, "low disk watermark [85%] no longer exceeded on *");
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
                listener.onResponse(null);
        monitor.onNewInfo(clusterInfo(builder));
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(DiskThresholdMonitor.class))) {
        // Since Block is already present and nodes are below high watermark so neither block nor unblock will be called.
        currentTime.addAndGet(randomLongBetween(60001, 120000));
            active,
        currentTime.addAndGet(randomLongBetween(0, 120000));
            }
        AtomicReference<Set<String>> indicesToBlockRead = new AtomicReference<>();
            monitor,
            () -> clusterState,
        // Free space = 8 < 10, so should exceed flood stage
                assertTrue(reroute.compareAndSet(false, true));
        final Map<String, Long> shardSizes = new HashMap<>();
                .put("cluster.blocks.create_index.enabled", false)
import java.util.Arrays;
        ) {
    }
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, 19));
            protected void updateIndicesReadOnly(Set<String> indicesToMarkReadOnly, ActionListener<Void> listener, boolean readOnly) {
        assertTrue(indicesToReleaseReadBlock.get().contains(".opensearch-security"));
        // Free space = 18 < 20, so should exceed high stage
                    DiskThresholdMonitor.class.getCanonicalName(),
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        ) {
        oneDiskAboveWatermark.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 50));
                .nodes(DiscoveryNodes.builder().add(warmNode))
import org.opensearch.cluster.node.DiscoveryNodes;
        );
        assertNull(indicesToReleaseReadOnlyBlock.get());
            builder.put("node3", new DiskUsage("node3", "node3", "/foo/bar", 100, between(0, 100)));
            () -> 2.0
            Settings.EMPTY,
                .build(),
        );
 * compatible open source license.
        AtomicReference<Set<String>> indices = new AtomicReference<>();
        // When disk usage on one node is missing and the other is above the flood-stage watermark, affected indices are blocked
        monitor.onNewInfo(clusterInfo(builder));
        AtomicBoolean reroute = new AtomicBoolean(false);
        indicesToMarkReadOnly.set(null);
                if (indexCreateBlock == true) {
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
        timeSupplier.getAsLong(); // advance time long enough to do another reroute
                }
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
            protected void updateIndicesReadBlock(Set<String> indicesToBlockRead, ActionListener<Void> listener, boolean readBlock) {
            null,
                    .settings(
        for (int index = 0; index < messages.size(); index++) {
                assertThat(priority, equalTo(Priority.HIGH));
        );
        builder = new HashMap<>();
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, between(0, 4)));
            null,
        // If any node is no longer breaching high watermark, DiskThresholdMonitor should remove IndexCreateBlock.
                settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
        );
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();
            "high disk watermark [90%] no longer exceeded on * but low disk watermark [85%] is still exceeded"
            0,
        assertRepeatedWarningMessages(
            }
                listener.onResponse(null);
                assertTrue(indices.compareAndSet(null, indicesToMarkReadOnly));
            public long getAsLong() {
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    .settings(settings(Version.CURRENT).put("index.routing.allocation.require._id", "hot_node_1"))
                listener.onResponse(null);
        IndexMetadata indexMetadata = IndexMetadata.builder(clusterState.metadata().index("test_2"))
package org.opensearch.cluster.routing.allocation;
        assertNull(indicesToReleaseReadOnlyBlock.get());
            }
        assertNull(indicesToReleaseReadOnlyBlock.get());
            null,
                listener.onResponse(null);
            assertNull(listenerReference.get());
            (reason, priority, listener) -> {
            Settings.EMPTY,
            )
        assertLogging(monitor, diskUsages, Level.INFO, message);
        );
        );
            totalCacheSize,
    }
    }
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
            settings,
            @Override
                    .numberOfShards(1)
        indicesToReleaseReadOnlyBlock.set(null);
        assertTrue(reroute.get());
        currentTime.addAndGet(
                    "*"
        assertFalse(reroute.get());
                assertTrue(reroute.compareAndSet(false, true));
            }
    private void assertNoLogging(DiskThresholdMonitor monitor, final Map<String, DiskUsage> diskUsages) throws IllegalAccessException {
            .metadata(Metadata.builder(clusterState.metadata()).put(indexMetadata, true).build())
        assertNotNull(listenerReference.get());
 *     http://www.apache.org/licenses/LICENSE-2.0
            @Override
        ) {
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
            }
                + "the node is expected to continue to exceed the high disk watermark when these relocations are complete"
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, between(0, 4)));
            () -> clusterState,
        ) {
        builder.put("warm_node", new DiskUsage("warm_node", "warm_node", "/foo/bar", 200, 28));
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
        final ActionListener<ClusterState> rerouteListener1 = listenerReference.getAndSet(null);
            .numberOfShards(1)
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(0, 4)));
        final Map<String, AggregateFileCacheStats> fileCacheStats = new HashMap<>();
        ) {
                    .numberOfShards(1)
        // should reroute again after the reroute interval
            protected void updateIndicesReadOnly(Set<String> indicesToBlockRead, ActionListener<Void> listener, boolean readOnly) {
            .put(
            0,
        DiscoveryNode warmNode = newNode("warm_node_index_block", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
 * license agreements. See the NOTICE file distributed with
            @Override
        indicesToMarkReadOnly.set(null);
        ) {
            @Override
        );
            allocation
                assertThat(priority, equalTo(Priority.HIGH));
/*
            allocation
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
            null,
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
            )
 * SPDX-License-Identifier: Apache-2.0
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
            () -> clusterState,
        AtomicBoolean reroute = new AtomicBoolean(false);
                }
        advanceTime.set(randomBoolean());
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
            Settings.EMPTY,
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, between(5, 90)));
        monitor.onNewInfo(clusterInfo(builder));
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();
            () -> 5.0
                    indicesToReleaseReadBlock.set(indicesToUpdate);
        assertNull(indicesToMarkReadOnly.get());
        // Ensure DiskThresholdMonitor does not try to remove block in the next iteration if all nodes are breaching high watermark.
 */
        ) {
                .nodes(DiscoveryNodes.builder().add(warmNode))
            () -> 2.0  // dataToFileCacheSizeRatio = 2
            0,
    public void testMarkFloodStageIndicesReadOnly() {
            0,
                    "any message of another level",
                assertNotNull(listener);
                assertThat(priority, equalTo(Priority.HIGH));
            );
            .numberOfReplicas(0);
import org.opensearch.cluster.metadata.IndexMetadata;
        AtomicInteger countUnblockBlocksCalled = new AtomicInteger();
            randomLongBetween(
import java.util.HashSet;
                        settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
            @Override
        assertMultipleWarningMessages(monitor, aboveHighWatermark, messages);
                throw new AssertionError("unexpected");
            monitor,
    public void testReadBlockReleasedForExcludedPatternsWhenAutoReleaseDisabled() {
            protected void updateIndicesReadOnly(Set<String> indicesToMarkReadOnly, ActionListener<Void> listener, boolean readOnly) {
        // Total addressable space = dataToFileCacheSizeRatio * nodeCacheSize = 2.0 * 100 = 200
                .routingTable(routingTable)
                    Level.INFO,
                if (key.contains("search_block")) {
                assertTrue(readOnly);
                    .put("index.routing.allocation.require._id", "warm_node")
                listener.onResponse(null);
                randomLongBetween(0, DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(Settings.EMPTY).millis())
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
import org.opensearch.cluster.DiskUsage;
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
                new MockLogAppender.UnseenEventExpectation(
            aboveHighWatermark,
            @Override
        );
            allocation
        assertEquals(new HashSet<>(Arrays.asList("test_1", "test_2")), indicesToMarkReadOnly.get());
        AllocationService allocation = createAllocationService(
            () -> clusterState,
            () -> clusterState,
            protected void updateIndicesReadBlock(Set<String> indicesToBlockRead, ActionListener<Void> listener, boolean readBlock) {
 * this file be licensed under the Apache-2.0 license or a
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 30));
            monitor.onNewInfo(clusterInfo(allDisksOk));
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 5));
    }
            .addAsNew(metadata.index("test_2"))
        assertNoLogging(monitor, allDisksOk);
                assertThat(priority, equalTo(Priority.HIGH));
            .addAsNew(metadata.index("test_1"))
                    .put(clusterState.metadata().index("test_2").getSettings())
            () -> clusterState,
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
                assertTrue(readOnly);
    @TestLogging(value = "org.opensearch.cluster.routing.allocation.DiskThresholdMonitor:INFO", reason = "testing INFO/WARN logging")
                .routingTable(routingTable)
                assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
            );
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();
        builder.put("warm_node", new DiskUsage("warm_node", "warm_node", "/foo/bar", 200, 40));
        assertNull(listenerReference.get());
        );
        DiscoveryNode warmNode = newNode("warm_node_search_block", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
        );
                listener.onResponse(null);
        assertNull(indicesToMarkReadOnly.get());
                .metadata(metadata)
                IndexMetadata.builder("remote_index")
                .routingTable(routingTable)
        }
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
                        settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
        RoutingTable routingTable = RoutingTable.builder().build();
                .build(),
        final Map<String, DiskUsage> diskUsages,
                    .put(IndexMetadata.INDEX_BLOCKS_READ_SETTING.getKey(), true)
import org.opensearch.cluster.node.DiscoveryNodeRole;
            Settings.EMPTY,
import org.opensearch.common.settings.Settings;
            },
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
        indicesToReleaseReadOnlyBlock.set(null);
            );
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
            allocation
    }
                assertNotNull(listener);
        IndexMetadata.Builder systemIndexBuilder = IndexMetadata.builder(".opensearch-security")
            "high disk watermark [90%] exceeded on * shards will be relocated away from this node* "
        AtomicReference<Set<String>> indices = new AtomicReference<>();
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        final int reservedSpaceNode2 = between(0, 10);
                    .numberOfReplicas(0)
            .numberOfShards(1)
    }
        assertFalse(indicesToBlockRead.get().isEmpty());
        };
            () -> clusterState,
            allocation
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        AllocationService allocation = createAllocationService(
            () -> 0L,
                    .numberOfShards(1)
    }
        builder = new HashMap<>();
        rerouteListener1.onResponse(clusterState);
            }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
import org.opensearch.cluster.ClusterInfo;
            () -> 0L,
                .build(),
                .build(),
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                    .settings(settings(Version.CURRENT).put("index.routing.allocation.require._id", "hot_node_1"))
        monitor.onNewInfo(clusterInfo(builder));
            protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
import java.util.function.LongSupplier;
        );
            @Override
        );
            )
        FileCacheStats pinnedStats = new FileCacheStats(
                } else {
                assertThat(priority, equalTo(Priority.HIGH));
        ClusterState clusterStateWithBlocks = ClusterState.builder(clusterState)
                listener.onResponse(null);
        final Map<String, DiskUsage> allDisksOk = new HashMap<>();
 * not use this file except in compliance with the License.
        assertThat(indicesToMarkReadOnly.get(), contains("test_1"));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        // but user_index should NOT be released
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
        ) {
        final AtomicBoolean advanceTime = new AtomicBoolean(randomBoolean());
            );
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(0, 4)));
            clusterStateRef::get,
    public void testWarmNodeFileCacheIndexThresholdBreach() {
                .build(),
import java.util.ArrayList;
                .build(),
            }
            @Override
        // Block will be removed if any nodes is no longer breaching high watermark.
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 9));
import org.opensearch.cluster.ClusterState;
                .blocks(ClusterBlocks.builder().addBlocks(indexMetadataBuilder.build()).build())
        IndexMetadata.Builder userIndexBuilder = IndexMetadata.builder("user_index")
                .nodes(DiscoveryNodes.builder().add(warmNode))
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
        assertTrue(indicesToMarkReadOnly.get().contains("remote_index"));
        // High stage threshold (50%) = 200 * 0.15 = 30
        listenerReference.getAndSet(null).onResponse(clusterState);
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            0,
            }
 * specific language governing permissions and limitations
            Settings.EMPTY,
                listener.onResponse(null);
            .put(
        assertNull(indicesToMarkReadOnly.get());
            monitor,
            new ClusterInfo.ReservedSpace.Builder().add(new ShardId("", "", 0), reservedSpaceNode2).build()
                listener.onResponse(null);
    public void testIndexCreateBlockWhenNoDataNodeHealthy() {
        final Map<String, Long> shardSizes = new HashMap<>();
                assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
 * You may obtain a copy of the License at
        diskUsages.forEach((key, value) -> {
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            );
                .build(),
        );
            aboveLowWatermark,
        Map<String, DiskUsage> builder = new HashMap<>();
            @Override
        final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> reservedSpace,
            () -> 5.0
                .nodes(DiscoveryNodes.builder().add(warmNode))
        Metadata metadata = Metadata.builder()
            () -> 5.0
            AggregateFileCacheStats.FileCacheStatsType.FULL_FILE_STATS
        assertMultipleWarningMessages(monitor, aboveHighWatermark, messages);
        DiscoveryNode warmNode = newNode("warm_node", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
                listener.onResponse(null);
            .blocks(ClusterBlocks.builder().addBlocks(indexMetadata).build())
            null,
        monitor.onNewInfo(clusterInfo(builder));
import static org.hamcrest.Matchers.equalTo;
        for (int i = between(1, 3); i >= 0; i--) {
            }
                .metadata(metadata)
}
        // Should not mark remote indices read-only due to High stage breach
        );
                assertTrue(readOnly);
                listener.onResponse(null);
                    .put(IndexMetadata.INDEX_BLOCKS_READ_SETTING.getKey(), true)
        };
    }
        // When no usage information is present for node2, we don't release the block
    public void testReadBlockNotReleasedWhenAutoReleaseDisabled() {
        assertNull(listenerReference.get());
        // With auto_release disabled, read blocks should NOT be released
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
        indicesToReleaseReadOnlyBlock.set(null);
    public void testAutoReleaseIndices() {
            () -> anotherFinalClusterState,
        assertRepeatedWarningMessages(
    }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                    .put("index.routing.allocation.require._id", "warm_node")
            .metadata(
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
            .build();
    public void testWarmNodeFileCacheSearchThresholdBreach() {
                .build()
            if (key.contains("warm")) {
                .nodes(DiscoveryNodes.builder().add(newNode("hot_node_1")).add(newNode("hot_node_2")))
                listener.onResponse(null);
        indices.set(null);
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
        ) {
                countBlocksCalled.set(countBlocksCalled.get() + 1);
        builder = new HashMap<>();
        };
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();
        indicesToReleaseReadOnlyBlock.set(null);
                } else if (key.contains("index_block")) {
        assertEquals(countBlocksCalled.get(), 0);
                    DiskThresholdMonitor.class.getCanonicalName(),
            @Override
            settings,
                + "the node is expected to continue to exceed the high disk watermark when these relocations are complete"
                assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
        Settings settings = Settings.builder().put(DiskThresholdSettings.INDEX_READ_BLOCK_AUTO_RELEASE.getKey(), false).build();
            0,
        // system index (.opensearch-security) should still be released,
            0,
            mockAppender.addExpectation(
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        // should not reroute when all disks are ok
        ) {
                    fileCacheStats.put(key, createAggregateFileCacheStats(100, between(100, 110), 110));
                listener.onResponse(null);
        allDisksOk.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, 50));
        assertNotNull(indicesToReleaseReadBlock.get());
        // should reroute when one disk goes over the watermark
                listener.onResponse(null);
                listener.onResponse(null);
            new ClusterInfo.NodeAndPath("hot_node_1", "/foo/bar"),
            @Override
import java.util.concurrent.atomic.AtomicReference;
            currentTime::get,
        ) {
        }
        // and should not trigger reroute
                .blocks(ClusterBlocks.builder().addBlocks(systemIndexBuilder.build()).addBlocks(userIndexBuilder.build()).build())
                    .numberOfShards(1)
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
            .settings(
                .metadata(metadata)
                )
                listener.onResponse(null);
                .nodes(DiscoveryNodes.builder().add(warmNode))
import org.opensearch.common.Priority;
        AllocationService allocation = createAllocationService(
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
        Map<String, DiskUsage> builder = new HashMap<>();
                assertTrue(indices.compareAndSet(null, indicesToBlockRead));
                listener.onResponse(null);
            .settings(
            }
        );
        assertFalse(indicesToBlockRead.get().isEmpty());
                listener.onResponse(null);
        assertTrue(anotherFinalClusterState.blocks().indexBlocked(ClusterBlockLevel.WRITE, "test_2"));
                    .numberOfReplicas(0)
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
                    .numberOfReplicas(0)
                listener.onResponse(null);
        currentTime.addAndGet(randomLongBetween(60001, 120000));
            )
                listener.onResponse(null);
                .routingTable(routingTable)
        AllocationService allocation = createAllocationService(
        }
        final LongSupplier timeSupplier = new LongSupplier() {
        // With auto_release disabled but default exclude_patterns [".*"],
 * Licensed to Elasticsearch under one or more contributor
                if (readBlock == false) {
                    .settings(settings(Version.CURRENT).put("index.routing.allocation.require._id", "hot_node_2"))
            }
            .build();
            .put(IndexMetadata.builder("test_2").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
        final Map<String, DiskUsage> aboveFloodStageWatermark = new HashMap<>();
        // Since block is already present, DiskThresholdMonitor should not again try to apply block.
        );
                    fileCacheStats.put(key, createAggregateFileCacheStats(100, between(0, 89), 89));
        AtomicInteger countBlocksCalled = new AtomicInteger();
            0,
            }
 * Unless required by applicable law or agreed to in writing,
        Metadata metadata = Metadata.builder()
        Map<String, DiskUsage> builder = new HashMap<>();
            .put(
                    .settings(settings(Version.CURRENT).put("index.routing.allocation.require._id", "hot_node_2"))
            )
    }
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, 4));
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        monitor.onNewInfo(clusterInfo(builder));
            (reason, priority, listener) -> {
                } else {
                assertThat(priority, equalTo(Priority.HIGH));
            }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
import java.util.Set;
        monitor.onNewInfo(clusterInfo(builder, reservedSpaces, Map.of()));
        final Map<String, DiskUsage> builder = new HashMap<>();
        assertTrue(reroute.get());
            }
            },
        Metadata metadata = Metadata.builder()
import java.util.concurrent.atomic.AtomicLong;
            @Override
            0,
        // When disk usage on one node is between the high and flood-stage watermarks, nothing changes
    private static ClusterInfo clusterInfo(final Map<String, DiskUsage> diskUsages) {
        );
        shardSizes.put("[remote_index][0][p]", 182L);
            0,
            totalCacheSize,
            (reason, priority, listener) -> listener.onResponse(clusterStateRef.get()),
                } else {
 * the Apache License, Version 2.0 (the "License"); you may
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        };
        );
                    .numberOfReplicas(0)
            }
            .settings(
        reservedSpaces.put(
        };
import org.opensearch.cluster.block.ClusterBlocks;
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
            }
                    "any WARN message",
        AtomicReference<Set<String>> indicesToBlockRead = new AtomicReference<>();
            @Override
                settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
        );
            .addAsNew(metadata.index(".opensearch-security"))
                assertNotNull(listener);
        );
            @Override
            )
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
 * software distributed under the License is distributed on an
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(Settings.EMPTY).millis() + 1,
            timeSupplier,
            0,
            .numberOfReplicas(0);
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        // Should not mark remote indices read-only due to low stage breach
                listener.onResponse(null);
                Settings.builder()
            .settings(
        );
            @Override
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
                )
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
                listener.onResponse(null);
        );
            () -> 2.0
                assertFalse(readOnly);
        monitor = new DiskThresholdMonitor(
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
            mockAppender.assertAllExpectationsMatched();
 * KIND, either express or implied.  See the License for the
        FileCacheStats blockStats = new FileCacheStats(
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, 4));
        // but should trigger reroute
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 1));
import org.opensearch.cluster.ClusterName;
            @Override
import static org.hamcrest.Matchers.contains;
import org.opensearch.test.junit.annotations.TestLogging;
        relocatingShardSizeRef.set(0L);
            "flood stage disk watermark [95%] exceeded on * all indices on this node will be marked read-only"
            .build();
                if (readBlock == false) {
        monitor.onNewInfo(clusterInfo(builder));
        // When disk usage on one node is missing and the other is below the high watermark, nothing changes
                assertTrue(indicesToBlockRead.compareAndSet(null, indicesToUpdate));
            .build();
        monitor = new DiskThresholdMonitor(
                .metadata(metadata)
import org.opensearch.test.MockLogAppender;
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                            .put("index.routing.allocation.require._id", "warm_node_search_block")
        assertFalse(indicesToMarkReadOnly.get().isEmpty());
        // When free disk on node1 and node2 goes above 10% high watermark then release index block, ignoring reserved space
            assertLogging(monitor, diskUsages, Level.WARN, message);
            }
            randomLongBetween(
        assertThat(indicesToMarkReadOnly.get(), contains("test_1"));
        ) {
        assertNotNull(listenerReference.get());
                    .numberOfShards(1)
                assertTrue(indices.compareAndSet(null, indicesToMarkReadOnly));
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(Settings.EMPTY).millis() + 1,
        assertNull(indicesToReleaseReadBlock.get());
        builder.put("warm_node", new DiskUsage("warm_node", "warm_node", "/foo/bar", 200, 18));
            new ClusterInfo.NodeAndPath("hot_node_2", "/foo/bar"),
                    .put(IndexMetadata.INDEX_BLOCKS_READ_SETTING.getKey(), true)
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        assertNull(indicesToBlockRead.get());
import org.apache.logging.log4j.LogManager;
        // Total addressable space = dataToFileCacheSizeRatio * nodeCacheSize = 2.0 * 100 = 200
            @Override
            .build();
                listener.onResponse(null);
 *
        monitor.onNewInfo(clusterInfo(allDisksOk));
        advanceTime.set(true);
                    )
 * GitHub history for details.
        }
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();
            .build();
                    .numberOfReplicas(0)
                listener.onResponse(null);
import java.util.concurrent.atomic.AtomicInteger;
        };
                    .numberOfShards(1)
                .build(),
        monitor.onNewInfo(clusterInfo(builder, Map.of(), shardSizes));
        Metadata metadata = Metadata.builder()
                    .numberOfReplicas(0)
                .nodes(DiscoveryNodes.builder().add(warmNode))
            @Override
                .routingTable(routingTable)
            () -> 0L,
                        settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
            }
            @Override
        currentTime.addAndGet(
        Metadata metadata = Metadata.builder()
        if (randomBoolean()) {
        // Change cluster state so that "test_2" index is blocked (read only)
            0,
        monitor.onNewInfo(clusterInfo(oneDiskAboveWatermark));
                assertTrue(indicesToMarkReadOnly.compareAndSet(null, indicesToUpdate));
                listener.onResponse(null);
        AtomicReference<Set<String>> indicesToBlockRead = new AtomicReference<>();
                    indicesToReleaseReadBlock.set(indicesToUpdate);
        };
                listener.onResponse(null);
        Map<String, DiskUsage> builder = new HashMap<>();
        builder.put("hot_node_1", new DiskUsage("hot_node_1", "hot_node_1", "/foo/bar", 100, between(5, 100)));
        final int reservedSpaceNode1 = between(0, 10);
            )
            }
                listener.onResponse(null);
        AtomicBoolean reroute = new AtomicBoolean(false);
        }
        DiscoveryNode warmNode = newNode("warm_node", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
                .build(),
    }
            }
            new ClusterInfo.NodeAndPath("hot_node_1", "/foo/bar"),
                IndexMetadata.builder("test_1")
            @Override
                assertTrue(readOnly);
                    time += DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(Settings.EMPTY).getMillis() + 1;
        );
            protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, between(5, 100)));
            currentTime::get,
        RoutingTable routingTable = RoutingTable.builder()
            null,
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
        };
        );
        assertTrue(countBlocksCalled.get() == 0);
            0,
                    Level.WARN,
                assertTrue(reroute.compareAndSet(false, true));
                        settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
        allDisksOk = new HashMap<>();
                assertTrue(reroute.compareAndSet(false, true));
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
            monitor,
            protected void setIndexCreateBlock(ActionListener<Void> listener, boolean indexCreateBlock) {
        Metadata metadata = Metadata.builder()
                .nodes(DiscoveryNodes.builder().add(warmNode))
        indices.set(null);
            @Override
                listener.onResponse(clusterState);
        Metadata metadata = Metadata.builder().put(indexMetadataBuilder).build();
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
            )
                listener.onResponse(null);
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(Settings.EMPTY).millis() + 1,
        builder = new HashMap<>();
                assertFalse(readBlock);
            (reason, priority, listener) -> {
            monitor,
            }
                        settings(Version.CURRENT).put("index.store.type", "remote_snapshot")
            null,
            )
                    .put(IndexMetadata.INDEX_BLOCKS_READ_SETTING.getKey(), true)
        builder.put("warm_node_search_block", new DiskUsage("warm_node_search_block", "warm_node_search_block", "/foo/bar", 200, 40));
        assertFalse(indicesToMarkReadOnly.get().isEmpty());
        final Map<String, DiskUsage> oneDiskAboveWatermark = new HashMap<>();
            allocation
        assertNotNull(listenerReference.get());
            .build();
        shardSizes.put("[remote_index][0][p]", 172L);
            },
                listener.onResponse(null);
            monitor,
            monitor,
                    .numberOfReplicas(0)
            @Override
                listener.onResponse(null);
        AllocationService allocation = createAllocationService(
            null,
            0,
            "high disk watermark [90%] exceeded on * shards will be relocated away from this node* "
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
            },
        FileCacheStats overallStats = new FileCacheStats(
        Map<String, DiskUsage> builder = new HashMap<>();
            },
            AggregateFileCacheStats.FileCacheStatsType.BLOCK_FILE_STATS
                    .numberOfShards(1)
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        DiscoveryNode warmNode = newNode("warm_node", Collections.singleton(DiscoveryNodeRole.WARM_ROLE));
        if (randomBoolean()) {
        assertFalse(indicesToMarkReadOnly.get().isEmpty());
                listener.onResponse(null);
            allocation
        // Free space = 28 < 30, so should exceed low stage
        // should reroute again when one disk has reserved space that pushes it over the high watermark
        ) {
            )
                listener.onResponse(null);
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        advanceTime.set(false); // will do one reroute and emit warnings, but subsequent reroutes and associated messages are delayed
            mockAppender.addExpectation(
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            .addAsNew(metadata.index("test"))
        );
        indicesToReleaseReadOnlyBlock.set(null);
        builder.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, between(10, 100)));
                .routingTable(routingTable)
        monitor.onNewInfo(clusterInfo(allDisksOk, reservedSpaces, Map.of()));
        };
                assertThat(priority, equalTo(Priority.HIGH));
        AtomicLong currentTime = new AtomicLong();
            }
        AtomicInteger countBlocksCalled = new AtomicInteger();
        if (randomBoolean()) {
            }
                .metadata(metadata)
        final Map<String, Long> shardSizes = new HashMap<>();
                .metadata(metadata)
                    .settings(settings(Version.CURRENT).put("index.routing.allocation.require._id", "hot_node_1"))
                listener.onResponse(null);
        );
        );
                IndexMetadata.builder("test_2")
    }
        assertRepeatedWarningMessages(
        listenerReference.getAndSet(null).onResponse(null);
            protected void updateIndicesReadBlock(Set<String> indicesToBlockRead, ActionListener<Void> listener, boolean readBlock) {
            @Override
            .build();
                return relocatingShardSizeRef.get();
        final Map<String, Long> shardSizes = new HashMap<>();
        Metadata metadata = Metadata.builder()
                assertThat(priority, equalTo(Priority.HIGH));
            },
                    .put(IndexMetadata.INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true)
            "high disk watermark [90%] exceeded on * shards will be relocated away from this node* "
            }
                listener.onResponse(clusterStateWithBlocks);
            }
    }
            () -> 2.0  // dataToFileCacheSizeRatio = 2
            )
            null,
                new MockLogAppender.UnseenEventExpectation(
        Map<String, DiskUsage> builder = new HashMap<>();
        };
            },
            AggregateFileCacheStats.FileCacheStatsType.OVER_ALL_STATS
 */
/*
        assertNull(indicesToReleaseReadOnlyBlock.get());
        );
        allDisksOk.put("hot_node_2", new DiskUsage("hot_node_2", "hot_node_2", "/foo/bar", 100, 50));
                    .settings(
            null,
            () -> 2.0
        Settings settings = Settings.builder().put(DiskThresholdSettings.INDEX_READ_BLOCK_AUTO_RELEASE.getKey(), false).build();
        Map<String, DiskUsage> builder = new HashMap<>();
            .addAsNew(metadata.index("user_index"))
        };
            0,
        final Map<String, DiskUsage> allDisksOk;
            @Override
            @Override
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("remote_index")).build();
            .put(
        assertRepeatedWarningMessages(
            mockAppender.addExpectation(
import org.opensearch.core.index.shard.ShardId;
        );
                    countUnblockBlocksCalled.set(countUnblockBlocksCalled.get() + 1);
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
            )
            null,
        builder.put("warm_node", new DiskUsage("warm_node", "warm_node", "/foo/bar", 200, 40));
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
        DiskThresholdMonitor monitor = new DiskThresholdMonitor(
import java.util.List;
        AtomicReference<Set<String>> indicesToMarkReadOnly = new AtomicReference<>();
import java.util.Map;

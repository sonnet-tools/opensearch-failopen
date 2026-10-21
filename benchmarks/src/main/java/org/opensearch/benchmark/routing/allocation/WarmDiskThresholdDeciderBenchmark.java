        // relocation work rather than the pure decider sweep.
            final IndexRoutingTable.Builder irb = IndexRoutingTable.builder(indexMetadata.getIndex());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.routing.ShardRoutingState;
            final IndexMetadata indexMetadata = metadata.index(indexName(i));
        // Populated ClusterInfo is required: with EmptyClusterInfoService the decider fails open in earlyTerminate()
        final String[] params = shardsPerNodeWarmNodesEnabled.split("\\|");
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
        final int relocating = after.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size();
    }
            new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.OVER_ALL_STATS),
        return allocationService.reroute(clusterState, "reroute");
        if (totalShards % shardsPerIndex != 0) {
    }
        final int totalShards = shardsPerNode * warmNodes;
 * compatible open source license.
        final Map<String, AggregateFileCacheStats> fileCacheStats = new HashMap<>();
import org.openjdk.jmh.annotations.Benchmark;
            .metadata(metadata)
        return new AggregateFileCacheStats(
        "          400|       140| false|" })
    private ClusterState clusterState;
            throw new IllegalStateException("expected no relocations on a balanced started cluster, found " + relocating);
import org.openjdk.jmh.annotations.State;
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 */
import org.opensearch.cluster.metadata.IndexMetadata;
        }
        warmThresholdEnabled = Boolean.parseBoolean(params[2].trim());
public class WarmDiskThresholdDeciderBenchmark {
 * The OpenSearch Contributors require contributions made to
import java.util.concurrent.TimeUnit;
        // before reaching the per-shard path and the benchmark would measure nothing.
                irb.addShard(started);
    private static String nodeId(int n) {
            new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.BLOCK_FILE_STATS),
import org.openjdk.jmh.annotations.Fork;
        return Integer.valueOf(v.trim());
            nb.add(Allocators.newNode(nodeId, Map.of(), warmRoles));
import org.opensearch.core.index.shard.ShardId;
@SuppressWarnings("unused") // invoked by benchmarking framework
        allocationService = Allocators.createAllocationService(
        final Metadata metadata = mb.build();
@Warmup(iterations = 3)
import org.opensearch.cluster.node.DiscoveryNodeRole;
        for (int i = 0; i < indexCount; i++) {
import org.opensearch.cluster.routing.RoutingTable;
 * with {@code cluster.routing.allocation.disk.warm_threshold_enabled} on and off. The delta isolates the cost of
        final Settings.Builder indexSettings = Settings.builder()
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.opensearch.cluster.ClusterName;
            usages.put(nodeId, new DiskUsage(nodeId, nodeId, "/dev/null", addressableBytes, addressableBytes / 2));
            new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.PINNED_FILE_STATS)
                    new ShardId(indexMetadata.getIndex(), shardId),
        final Metadata.Builder mb = Metadata.builder();
        final Map<String, DiskUsage> usages = new HashMap<>();
        }
        "         1000|         2|  true|",
            .build();
import org.opensearch.cluster.ClusterInfo;
    private static String indexName(int i) {
 *
        final int indexCount = totalShards / shardsPerIndex;
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
    }
                    true,
            final String nodeId = nodeId(n);
    @Setup
package org.opensearch.benchmark.routing.allocation;
    @Param({
import org.opensearch.cluster.routing.IndexRoutingTable;
        final ClusterInfo clusterInfo = new ClusterInfo(usages, usages, Map.of(), Map.of(), Map.of(), fileCacheStats, Map.of());
        "          500|         2|  true|",
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true);
            fileCacheStats.put(nodeId, fileCacheStatsFor(FILE_CACHE_BYTES));
        shardsPerNode = toInt(params[0]);
                ).initialize(nodeId, null, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE).moveToStarted();
 * slower {@code FeatureFlags.isEnabled} + {@code Settings} path in {@code getIndexPool}, so absolute times here understate
        );
            .routingTable(rb.build())
        final ClusterInfoService clusterInfoService = () -> clusterInfo;
        if (relocating != 0) {
        LogConfigurator.setNodeName("test");
            mb.put(IndexMetadata.builder(indexName(i)).settings(indexSettings).numberOfShards(shardsPerIndex).numberOfReplicas(0));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
            0,
        clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.cluster.routing.allocation.AllocationService;
@BenchmarkMode(Mode.AverageTime)
        }
    public void setUp() throws Exception {
    public String shardsPerNodeWarmNodesEnabled = "500|2|true";
        final long addressableBytes = (long) (FILE_CACHE_BYTES * REMOTE_DATA_RATIO);
    }
 * production cost per shard visit; the growth trend with shards per node is the same for both index types.
import java.util.HashMap;
import org.opensearch.cluster.node.DiscoveryNodes;
 * <p>
import org.opensearch.cluster.routing.RecoverySource;
    public int shardsPerNode;
import java.util.Map;
            for (int shardId = 0; shardId < shardsPerIndex; shardId++) {
@OutputTimeUnit(TimeUnit.MILLISECONDS)
 * node's shards inside each {@code canRemain} call.
        );
                    new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "benchmark")
                    RecoverySource.EmptyStoreRecoverySource.INSTANCE,
 * Indices use the {@code remote_snapshot} store type so {@code RoutingPool.getIndexPool} resolves REMOTE_CAPABLE via
            throw new IllegalArgumentException("shardsPerNode * warmNodes must be a multiple of shardsPerIndex=" + shardsPerIndex);
import org.openjdk.jmh.annotations.Mode;
import org.opensearch.index.IndexModule;
import org.opensearch.cluster.ClusterInfoService;
 * {@code IndexMetadata.isRemoteSnapshot()} without a feature flag. Writable-warm ({@code index.warm}) indices take the
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Param;
        final DiscoveryNodes.Builder nb = DiscoveryNodes.builder();
import org.opensearch.Version;
            .nodes(nb)
    }
        "         4000|         2| false|",
            settings
    private static AggregateFileCacheStats fileCacheStatsFor(long fileCacheSize) {
        final RoutingTable.Builder rb = RoutingTable.builder();
 * on every reroute. Growth should be linear in shards per node; a quadratic trend indicates the decider is rescanning the
        final Set<DiscoveryNodeRole> warmRoles = Set.of(
        final ClusterState after = allocationService.reroute(clusterState, "setup");
        // service: the measured operation is a steady-state reroute, not initial allocation.
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
 */
            rb.add(irb.build());
import org.opensearch.cluster.routing.ShardRouting;
        for (int i = 0; i < indexCount; i++) {
        "         4000|         2|  true|",
    public int shardsPerIndex = 8;
        }
@State(Scope.Benchmark)
            // Ample free addressable space: every canRemain is a YES, so the full decider path runs without relocations.
            .build();
                final String nodeId = nodeId(shardOrdinal++ % warmNodes);
import org.opensearch.common.logging.LogConfigurator;
 * {@code WarmDiskThresholdDecider.canRemain}, which the remote and local shard balancers call once per started warm shard
            clusterInfoService,
    }
        return "warm_" + i;
/**
@Fork(1)
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.opensearch.index.store.remote.filecache.FileCacheStats;
            DiscoveryNodeRole.WARM_ROLE
/*
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), REMOTE_DATA_RATIO)
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.metadata.Metadata;
            Allocators.defaultAllocationDeciders(settings, clusterSettings),
 * Measures {@link AllocationService#reroute} on a fully-started warm cluster as the number of warm shards per node grows,
import org.opensearch.cluster.routing.UnassignedInfo;
    private static final double REMOTE_DATA_RATIO = 5.0;
        // Warm (REMOTE_CAPABLE) indices, as created by the warm tier: remote_snapshot store type + index.warm.
            DiscoveryNodeRole.CLUSTER_MANAGER_ROLE,
import org.openjdk.jmh.annotations.Warmup;
            DiscoveryNodeRole.DATA_ROLE,
    public ClusterState measureRerouteOnStartedWarmCluster() {
            new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.FULL_FILE_STATS),
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_WARM_DISK_THRESHOLD_ENABLED_SETTING.getKey(), warmThresholdEnabled)
        int shardOrdinal = 0;
    public int warmNodes;
import org.opensearch.cluster.DiskUsage;
    public boolean warmThresholdEnabled;
        "         2000|         2|  true|",
    private int toInt(String v) {
        // shardsPerNode| warmNodes| warmThresholdEnabled
 * this file be licensed under the Apache-2.0 license or a
        final Settings settings = Settings.builder()
        warmNodes = toInt(params[1]);
import java.util.Set;
        );
}
        // Sanity: a balanced, fully-started cluster must not relocate anything, otherwise the measurement would include
                final ShardRouting started = ShardRouting.newUnassigned(
        for (int n = 0; n < warmNodes; n++) {
    private static final long FILE_CACHE_BYTES = 1L << 40; // 1 TiB per warm node
            }
import org.openjdk.jmh.annotations.Measurement;
        // Build a fully STARTED routing table directly (round-robin over warm nodes) rather than allocating through the
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
import org.openjdk.jmh.annotations.Setup;
@Measurement(iterations = 3)
    @Benchmark
    private AllocationService allocationService;
import org.opensearch.cluster.ClusterState;
        return "warm_node_" + n;
import org.opensearch.common.settings.ClusterSettings;
        "          400|       140|  true|",

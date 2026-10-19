                    true,
import org.opensearch.Version;
            throw new IllegalStateException("expected no relocations on a balanced started cluster, found " + relocating);
        }
        // relocation work rather than the pure decider sweep.
@Fork(1)  
        );
 * {@code IndexMetadata.isRemoteSnapshot()} without a feature flag. Writable-warm ({@code index.warm}) indices take the
            0,  
        final Map<String, DiskUsage> usages = new HashMap<>();
    }
        final Metadata metadata = mb.build();
        "         1000|         2|  true|",  
import org.opensearch.cluster.node.DiscoveryNodes;
@BenchmarkMode(Mode.AverageTime)  
        // before reaching the per-shard path and the benchmark would measure nothing.
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.cluster.node.DiscoveryNodeRole;  
    }
 * with {@code cluster.routing.allocation.disk.warm_threshold_enabled} on and off. The delta isolates the cost of
            }
        final RoutingTable.Builder rb = RoutingTable.builder();
import java.util.Map;
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), REMOTE_DATA_RATIO)  
import org.openjdk.jmh.annotations.Warmup;
            fileCacheStats.put(nodeId, fileCacheStatsFor(FILE_CACHE_BYTES));
@OutputTimeUnit(TimeUnit.MILLISECONDS)
import org.opensearch.index.store.remote.filecache.FileCacheStats;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        "          500|         2|  true|",
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Measurement;
        final int relocating = after.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size();  
    private static final double REMOTE_DATA_RATIO = 5.0;
        int shardOrdinal = 0;  
import org.opensearch.cluster.routing.UnassignedInfo;
    public int shardsPerIndex = 8;
                irb.addShard(started);  
        }  
}
import org.opensearch.cluster.routing.ShardRoutingState;  
        final int indexCount = totalShards / shardsPerIndex;
        final long addressableBytes = (long) (FILE_CACHE_BYTES * REMOTE_DATA_RATIO);
        final ClusterInfoService clusterInfoService = () -> clusterInfo;
            nb.add(Allocators.newNode(nodeId, Map.of(), warmRoles));
    public void setUp() throws Exception {
                ).initialize(nodeId, null, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE).moveToStarted();
 * on every reroute. Growth should be linear in shards per node; a quadratic trend indicates the decider is rescanning the
            for (int shardId = 0; shardId < shardsPerIndex; shardId++) {
        "         2000|         2|  true|",
        // Populated ClusterInfo is required: with EmptyClusterInfoService the decider fails open in earlyTerminate()
import org.openjdk.jmh.annotations.Mode;
                    new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "benchmark")
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_WARM_DISK_THRESHOLD_ENABLED_SETTING.getKey(), warmThresholdEnabled)
 * this file be licensed under the Apache-2.0 license or a
            .build();
            DiscoveryNodeRole.DATA_ROLE,
            final String nodeId = nodeId(n);  
        final Settings settings = Settings.builder()  
        final int totalShards = shardsPerNode * warmNodes;  
        for (int i = 0; i < indexCount; i++) {
            .routingTable(rb.build())  
        // Build a fully STARTED routing table directly (round-robin over warm nodes) rather than allocating through the  
import java.util.Set;  
        );
 *
import org.opensearch.cluster.ClusterInfo;
                final String nodeId = nodeId(shardOrdinal++ % warmNodes);
        return allocationService.reroute(clusterState, "reroute");
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.OutputTimeUnit;  
    private static AggregateFileCacheStats fileCacheStatsFor(long fileCacheSize) {
        final Settings.Builder indexSettings = Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true);
            throw new IllegalArgumentException("shardsPerNode * warmNodes must be a multiple of shardsPerIndex=" + shardsPerIndex);
import org.openjdk.jmh.annotations.BenchmarkMode;
    private static final long FILE_CACHE_BYTES = 1L << 40; // 1 TiB per warm node
            final IndexMetadata indexMetadata = metadata.index(indexName(i));
 * node's shards inside each {@code canRemain} call.
import org.openjdk.jmh.annotations.Param;
            DiscoveryNodeRole.WARM_ROLE
@State(Scope.Benchmark)
        final DiscoveryNodes.Builder nb = DiscoveryNodes.builder();
        final Set<DiscoveryNodeRole> warmRoles = Set.of(
            mb.put(IndexMetadata.builder(indexName(i)).settings(indexSettings).numberOfShards(shardsPerIndex).numberOfReplicas(0));
import org.opensearch.cluster.ClusterName;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
import org.opensearch.cluster.routing.allocation.AllocationService;
        );  
import org.opensearch.cluster.routing.ShardRouting;
        // service: the measured operation is a steady-state reroute, not initial allocation.
import org.opensearch.index.IndexModule;
                    RecoverySource.EmptyStoreRecoverySource.INSTANCE,  
        final Map<String, AggregateFileCacheStats> fileCacheStats = new HashMap<>();  
        final String[] params = shardsPerNodeWarmNodesEnabled.split("\\|");
            new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.BLOCK_FILE_STATS),  
    }  
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())  
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
        "         4000|         2| false|",  
    }  
import org.opensearch.common.settings.ClusterSettings;
    private static String nodeId(int n) {  
        "          400|       140|  true|",
/**  
        for (int n = 0; n < warmNodes; n++) {
    @Param({  
    private ClusterState clusterState;
        return "warm_node_" + n;
            new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.OVER_ALL_STATS),
                    new ShardId(indexMetadata.getIndex(), shardId),
        return "warm_" + i;  
        }  
    private static String indexName(int i) {
import org.opensearch.cluster.ClusterInfoService;  
            usages.put(nodeId, new DiskUsage(nodeId, nodeId, "/dev/null", addressableBytes, addressableBytes / 2));  
        LogConfigurator.setNodeName("test");  
        if (totalShards % shardsPerIndex != 0) {
            rb.add(irb.build());
 */  
            // Ample free addressable space: every canRemain is a YES, so the full decider path runs without relocations.
        clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
@Measurement(iterations = 3)
        final Metadata.Builder mb = Metadata.builder();  
@SuppressWarnings("unused") // invoked by benchmarking framework  
    public int shardsPerNode;
        allocationService = Allocators.createAllocationService(  
import org.opensearch.cluster.routing.IndexRoutingTable;
    }
    public int warmNodes;  
import org.openjdk.jmh.annotations.Fork;  
@Warmup(iterations = 3)
            Allocators.defaultAllocationDeciders(settings, clusterSettings),
import org.opensearch.common.logging.LogConfigurator;
            final IndexRoutingTable.Builder irb = IndexRoutingTable.builder(indexMetadata.getIndex());  
        shardsPerNode = toInt(params[0]);
                final ShardRouting started = ShardRouting.newUnassigned(  
package org.opensearch.benchmark.routing.allocation;
            DiscoveryNodeRole.CLUSTER_MANAGER_ROLE,  
        final ClusterState after = allocationService.reroute(clusterState, "setup");
    public String shardsPerNodeWarmNodesEnabled = "500|2|true";  
import org.openjdk.jmh.annotations.Setup;  
            clusterInfoService,
import org.opensearch.common.settings.Settings;  
            .build();
import org.opensearch.cluster.routing.RoutingTable;
            settings  
    public boolean warmThresholdEnabled;
/*  
import org.opensearch.cluster.ClusterState;
        // shardsPerNode| warmNodes| warmThresholdEnabled
        warmThresholdEnabled = Boolean.parseBoolean(params[2].trim());
        warmNodes = toInt(params[1]);  
import java.util.HashMap;
 * Indices use the {@code remote_snapshot} store type so {@code RoutingPool.getIndexPool} resolves REMOTE_CAPABLE via
    }
        if (relocating != 0) {
 */
public class WarmDiskThresholdDeciderBenchmark {
import org.opensearch.cluster.DiskUsage;  
        }  
            new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.PINNED_FILE_STATS)
        "          400|       140| false|" })
import org.opensearch.cluster.metadata.Metadata;
            new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.FULL_FILE_STATS),
        // Warm (REMOTE_CAPABLE) indices, as created by the warm tier: remote_snapshot store type + index.warm.  
        // Sanity: a balanced, fully-started cluster must not relocate anything, otherwise the measurement would include  
 * slower {@code FeatureFlags.isEnabled} + {@code Settings} path in {@code getIndexPool}, so absolute times here understate  
    public ClusterState measureRerouteOnStartedWarmCluster() {
 * {@code WarmDiskThresholdDecider.canRemain}, which the remote and local shard balancers call once per started warm shard  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;
        }  
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;  
        "         4000|         2|  true|",
import org.openjdk.jmh.annotations.Scope;
        return Integer.valueOf(v.trim());  
        return new AggregateFileCacheStats(
        final ClusterInfo clusterInfo = new ClusterInfo(usages, usages, Map.of(), Map.of(), Map.of(), fileCacheStats, Map.of());  
            .metadata(metadata)
 * production cost per shard visit; the growth trend with shards per node is the same for both index types.
    @Benchmark  
    @Setup
import org.openjdk.jmh.annotations.Benchmark;
            .nodes(nb)
 * <p>  
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;  
 * Measures {@link AllocationService#reroute} on a fully-started warm cluster as the number of warm shards per node grows,
    private AllocationService allocationService;
        for (int i = 0; i < indexCount; i++) {
import org.opensearch.cluster.metadata.IndexMetadata;
    private int toInt(String v) {
import org.opensearch.cluster.routing.RecoverySource;  

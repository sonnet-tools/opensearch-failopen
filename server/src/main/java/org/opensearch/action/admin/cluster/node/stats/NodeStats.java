    public TransportStats getTransport() {
        }
            out.writeOptionalWriteable(nodeCacheStats);
            out.writeOptionalWriteable(repositoriesStats);
        if (getAdmissionControlStats() != null) {
    private WeightedRoutingStats weightedRoutingStats;
        this.searchBackpressureStats = searchBackpressureStats;
            indices.writeTo(out);
    public NodeIndicesStats getIndices() {
            in.readOptionalWriteable(NativeAllocatorPoolStats::readAndDiscardV3_7);
    }
            concurrencyLimiterStats = in.readOptionalWriteable(ActionConcurrencyLimiterStats::new);
        timestamp = in.readVLong();
        if (getResourceUsageStats() != null) {
        scriptStats = in.readOptionalWriteable(ScriptStats::new);
     */
        if (getNativeAllocatorStats() != null) {
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
            getBreaker().toXContent(builder, params);
        this.remoteStoreNodeStats = remoteStoreNodeStats;
        out.writeOptionalWriteable(threadPool);
        long timestamp,
            builder.startObject("memory_pools");
import org.opensearch.common.cache.service.NodeCacheStats;
        this.nativeAllocatorStats = nativeAllocatorStats;
    }
        builder.field("total_estimated_bytes", totalEstimatedNativeBytes);
    /**
 * software distributed under the License is distributed on an
        @Nullable SearchPipelineStats searchPipelineStats,
        @Nullable ClusterManagerThrottlingStats clusterManagerThrottlingStats,
    @Nullable
        }
import org.opensearch.index.stats.IndexingPressureStats;
        this.ingestStats = ingestStats;
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
        if (in.getVersion().onOrAfter(Version.V_2_9_0)) {
        @Nullable WeightedRoutingStats weightedRoutingStats,
            searchBackpressureStats = in.readOptionalWriteable(SearchBackpressureStats::new);
            out.writeOptionalWriteable(blockCacheOnlyStats);
    private TransportStats transport;
        http = in.readOptionalWriteable(HttpStats::new);
import org.opensearch.Version;
        @Nullable ActionConcurrencyLimiterStats concurrencyLimiterStats,
        }
import org.opensearch.monitor.os.OsStats;
/*
        out.writeVLong(timestamp);
     */
        }
            getThreadPool().toXContent(builder, params);
    private FsInfo fs;
    @Nullable
            NativeAllocatorPoolStats.writeV3_7(out, nativeAllocatorStats);
        this.fs = fs;
        @Nullable NodesResourceUsageStats resourceUsageStats,
 * The OpenSearch Contributors require contributions made to
            indices = new NodeIndicesStats(in);
        return this.indices;
    @Nullable
            repositoriesStats = null;
        if (getRepositoriesStats() != null) {
            getSegmentReplicationRejectionStats().toXContent(builder, params);
    @Nullable
    }
    }
 * Modifications Copyright OpenSearch Contributors. See
            blockCacheOnlyStats = in.readOptionalWriteable(BlockCacheStats::new);
 */
            out.writeOptionalWriteable(resourceUsageStats);
    private IngestStats ingestStats;
            searchPipelineStats = in.readOptionalWriteable(SearchPipelineStats::new);
        return this.scriptStats;
    @Nullable
            out.writeOptionalWriteable(clusterManagerThrottlingStats);
    public OsStats getOs() {
    public NodesResourceUsageStats getResourceUsageStats() {
    @Nullable
        }
        return builder;
    private ProcessStats process;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
    private SearchBackpressureStats searchBackpressureStats;
            getDiscoveryStats().toXContent(builder, params);
    private ShardIndexingPressureStats shardIndexingPressureStats;
    @Nullable
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        this.segmentReplicationRejectionStats = segmentReplicationRejectionStats;
            out.writeOptionalWriteable(searchBackpressureStats);
        // NativeAllocatorPoolStats now includes jemalloc allocated/resident + all pools.
 * not use this file except in compliance with the License.
 * under the License.
            getShardIndexingPressureStats().toXContent(builder, params);
        }
            out.writeBoolean(false);
    private SearchPipelineStats searchPipelineStats;
            getFileCacheOnlyStats().getPinnedFileCacheStats().toXContent(builder, params);
import java.util.Map;
        if (getNodeCacheStats() != null) {
        out.writeOptionalWriteable(ingestStats);
    @Nullable
        ingestStats = in.readOptionalWriteable(IngestStats::new);
 * this file be licensed under the Apache-2.0 license or a
        if (getScriptStats() != null) {
    }
        }
     */
        if (indices == null) {
 * Unless required by applicable law or agreed to in writing,
    public IngestStats getIngestStats() {
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
 * this work for additional information regarding copyright
        }
        }
    @Nullable
            repositoriesStats = in.readOptionalWriteable(RepositoriesStats::new);
            fileCacheStats = in.readOptionalWriteable(AggregateFileCacheStats::new);
import org.opensearch.search.pipeline.SearchPipelineStats;
            totalEstimatedNativeBytes = -1L;
    @Override
    private AggregateFileCacheStats fileCacheStats;
        jvm = in.readOptionalWriteable(JvmStats::new);
        }
    /**
    @Nullable
        return blockCacheOnlyStats;
        }
        }
        transport = in.readOptionalWriteable(TransportStats::new);
        // native_memory: unified view of all native memory pools and jemalloc stats.
        } else if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
        this.nodeCacheStats = nodeCacheStats;
     * (RssAnon - JVM heap committed - JVM non-heap committed), or {@code -1} when the probe
        out.writeOptionalWriteable(transport);
        builder.endArray();
        }
        }
            in.readOptionalWriteable(AnalyticsBackendNativeMemoryStats::new);
        return this.transport;
            out.writeOptionalWriteable(fileCacheStats);
    public ActionConcurrencyLimiterStats getConcurrencyLimiterStats() {
    /** Populated only when ?detailed is requested: combined rollup across all BlockCache implementations. */
    }
        @Nullable HttpStats http,
     * renders the source node's value, not its own. {@code -1} when the probe could not read
import org.opensearch.monitor.process.ProcessStats;
        }
            builder.startObject("attributes");
            resourceUsageStats = null;
        if (getWeightedRoutingStats() != null) {
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
            nativeAllocatorStats = in.readOptionalWriteable(NativeAllocatorPoolStats::new);
    @Nullable
        }
            admissionControlStats = in.readOptionalWriteable(AdmissionControlStats::new);
        }
        }
        super(in);
 *
        if (in.getVersion().onOrAfter(Version.V_3_8_0)) {
            out.writeOptionalWriteable(concurrencyLimiterStats);
        return process;
        }
    public NodeStats(StreamInput in) throws IOException {
            getFs().toXContent(builder, params);
     * could not read {@code /proc/self/status}.
        out.writeOptionalWriteable(shardIndexingPressureStats);
 * license agreements. See the NOTICE file distributed with
        } else {
    @Nullable
            nativeAllocatorStats = null;
    public AdmissionControlStats getAdmissionControlStats() {
    private RepositoriesStats repositoriesStats;
        this.discoveryStats = discoveryStats;
        if (getJvm() != null) {
            out.writeOptionalWriteable(admissionControlStats);
            // BWC: V_3_7_0 expects AnalyticsBackendNativeMemoryStats here; write null.
    private ActionConcurrencyLimiterStats concurrencyLimiterStats;
        @Nullable NativeAllocatorPoolStats nativeAllocatorStats,
        out.writeOptionalWriteable(jvm);
    public ThreadPoolStats getThreadPool() {
        @Nullable TaskCancellationStats taskCancellationStats,
        }
    @Nullable
    @Nullable
            getResourceUsageStats().toXContent(builder, params);
     */
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
    public NativeAllocatorPoolStats getNativeAllocatorStats() {
        @Nullable IngestStats ingestStats,
        return totalEstimatedNativeBytes;
        @Nullable NodeCacheStats nodeCacheStats,
    private HttpStats http;
        if (out.getVersion().onOrAfter(Version.V_2_18_0)) {
    @Nullable
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
        }
        if (getRemoteStoreNodeStats() != null) {
    @Nullable
            builder.startObject("runtime");
        this.repositoriesStats = repositoriesStats;
        @Nullable ThreadPoolStats threadPool,
        return jvm;
        return this.discoveryStats;
        } else {
                builder.field(attrEntry.getKey(), attrEntry.getValue());
    @Nullable
        if (getConcurrencyLimiterStats() != null) {
import org.opensearch.core.common.io.stream.StreamInput;
            getFileCacheOnlyStats().getBlockFileCacheStats().toXContent(builder, params);
        out.writeOptionalWriteable(discoveryStats);
            getWeightedRoutingStats().toXContent(builder, params);
    @Nullable
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
    @Nullable
        @Nullable ScriptCacheStats scriptCacheStats,
 * @opensearch.internal
            builder.startObject("file_cache");
        scriptCacheStats = null;
            // BWC: V_3_7_0 wrote old-format NativeAllocatorPoolStats (3 VLongs + pools with 4 fields); read and discard.
        @Nullable FsInfo fs,
        }
        if (in.getVersion().onOrAfter(Version.V_2_14_0)) {
        if (getSearchPipelineStats() != null) {
        } else {
        }
        if (out.getVersion().onOrAfter(Version.V_3_8_0)) {
    public ShardIndexingPressureStats getShardIndexingPressureStats() {
    @Nullable
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
        }
    private long totalEstimatedNativeBytes;
    @Nullable
    @Nullable
 */
import org.opensearch.plugins.BlockCacheStats;
    }
    @Nullable
    @Nullable
        return fileCacheStats;
    @Nullable
        }
        return taskCancellationStats;
        this.blockCacheOnlyStats = blockCacheOnlyStats;
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;
        this.indexingPressureStats = indexingPressureStats;
        return weightedRoutingStats;
    @Nullable
        return repositoriesStats;
    /**
    public AggregateFileCacheStats getFileCacheStats() {
            clusterManagerThrottlingStats = null;
        @Nullable TransportStats transport,
    @Nullable
import org.opensearch.core.common.io.stream.StreamOutput;
    public ProcessStats getProcess() {
            fileCacheOnlyStats = in.readOptionalWriteable(AggregateFileCacheStats::new);
        if (in.getVersion().onOrAfter(Version.V_2_7_0)) {
    public DiscoveryStats getDiscoveryStats() {
            getTransport().toXContent(builder, params);
    /**
        }
    private NodeIndicesStats indices;
        os = in.readOptionalWriteable(OsStats::new);
            getClusterManagerThrottlingStats().toXContent(builder, params);
        if (getSegmentReplicationRejectionStats() != null) {
    public long getTimestamp() {
 * You may obtain a copy of the License at
            segmentReplicationRejectionStats = null;
            getJvm().toXContent(builder, params);
        }
    public FsInfo getFs() {
        @Nullable RemoteStoreNodeStats remoteStoreNodeStats,
/*
        if (in.getVersion().onOrAfter(Version.V_2_6_0)) {
            getIndexingPressureStats().toXContent(builder, params);
import org.opensearch.action.support.nodes.BaseNodeResponse;
        @Nullable OsStats os,
            getHttp().toXContent(builder, params);
            remoteStoreNodeStats = in.readOptionalWriteable(RemoteStoreNodeStats::new);
        @Nullable AdaptiveSelectionStats adaptiveSelectionStats,
        return remoteStoreNodeStats;
        super.writeTo(out);
    }
            getProcess().toXContent(builder, params);
        @Nullable JvmStats jvm,
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
     * {@code OsProbe.getProcessNativeMemoryBytes()} and serialized over the wire so the coordinator
    /**
                entry.getValue().toXContent(builder, params);
        }
    @Nullable
        if (getThreadPool() != null) {
    private RemoteStoreNodeStats remoteStoreNodeStats;
            clusterManagerThrottlingStats = in.readOptionalWriteable(ClusterManagerThrottlingStats::new);
            getScriptStats().toXContent(builder, params);
        if (getIndices() != null) {
        if (out.getVersion().onOrAfter(Version.V_2_14_0)) {
        } else {
        }
    }
    private SegmentReplicationRejectionStats segmentReplicationRejectionStats;
        @Nullable DiscoveryStats discoveryStats,
    public RemoteStoreNodeStats getRemoteStoreNodeStats() {
    }
        }
        this.threadPool = threadPool;
import org.opensearch.transport.TransportStats;
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
        }
        if (getFileCacheStats() != null) {
public class NodeStats extends BaseNodeResponse implements ToXContentFragment {
 *
        this.jvm = jvm;
        if (scriptStats != null) {
            for (Map.Entry<String, String> attrEntry : getNode().getAttributes().entrySet()) {
    private TaskCancellationStats taskCancellationStats;
    public SearchBackpressureStats getSearchBackpressureStats() {
    public BlockCacheStats getBlockCacheOnlyStats() {
        out.writeOptionalWriteable(fs);
            segmentReplicationRejectionStats = in.readOptionalWriteable(SegmentReplicationRejectionStats::new);
    private AllCircuitBreakerStats breaker;
    }
        }
            out.writeOptionalWriteable(taskCancellationStats);
        if (getTaskCancellationStats() != null) {
        } else {
        out.writeOptionalWriteable(adaptiveSelectionStats);
            getIngestStats().toXContent(builder, params);
    @Nullable
        if (getBlockCacheOnlyStats() != null) {
    @Nullable
    public TaskCancellationStats getTaskCancellationStats() {
        this.totalEstimatedNativeBytes = totalEstimatedNativeBytes;
 *
            getBlockCacheOnlyStats().toXContent(builder, params);
import org.opensearch.monitor.fs.FsInfo;
            builder.field("allocated_bytes", stats.getNativeAllocatedBytes());
import org.opensearch.ingest.IngestStats;
        }
            getSearchPipelineStats().toXContent(builder, params);
        return shardIndexingPressureStats;
        return admissionControlStats;
            builder.endObject();
    }
        return this.breaker;
            getOs().toXContent(builder, params);
        process = in.readOptionalWriteable(ProcessStats::new);
        }
        DiscoveryNode node,
            getTaskCancellationStats().toXContent(builder, params);
        this.fileCacheOnlyStats = fileCacheOnlyStats;
import org.opensearch.cluster.service.ClusterManagerThrottlingStats;
        this.taskCancellationStats = taskCancellationStats;
import org.opensearch.action.ActionConcurrencyLimiterStats;
        this.adaptiveSelectionStats = adaptiveSelectionStats;
        }
    private long timestamp;
     */
    public JvmStats getJvm() {
    @Nullable
            // BWC: V_3_7_0 wrote AnalyticsBackendNativeMemoryStats here; read and discard.
     * Process-level native-memory estimate captured on the data node hosting this {@code NodeStats}.
            out.writeOptionalWriteable(segmentReplicationRejectionStats);
        out.writeOptionalWriteable(http);
    private AdmissionControlStats admissionControlStats;
        }
    @Nullable
        @Nullable ScriptStats scriptStats,
    public RepositoriesStats getRepositoriesStats() {
    public NodeCacheStats getNodeCacheStats() {
        @Nullable AllCircuitBreakerStats breaker,
    }
        if (getSearchBackpressureStats() != null) {
        } else {
package org.opensearch.action.admin.cluster.node.stats;
        builder.field("host", getNode().getHostName());
/*
    /**
        }
        } else {
    private AdaptiveSelectionStats adaptiveSelectionStats;
        if (!getNode().getAttributes().isEmpty()) {
        this.fileCacheStats = fileCacheStats;
import org.opensearch.node.AdaptiveSelectionStats;
    @Nullable
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
            }
    @Nullable
        }
    @Nullable
        fs = in.readOptionalWriteable(FsInfo::new);
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.xcontent.ToXContentFragment;
        }
        this.indices = indices;
        return searchBackpressureStats;
    public AggregateFileCacheStats getFileCacheOnlyStats() {
        this.searchPipelineStats = searchPipelineStats;
        if (out.getVersion().onOrAfter(Version.V_2_7_0)) {
        }
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
    private AggregateFileCacheStats fileCacheOnlyStats;
        }
    }
import org.opensearch.common.Nullable;
    private NodeCacheStats nodeCacheStats;
        }
    @Nullable
        // total_estimated_bytes ≈ RssAnon - JVM heap committed - JVM non-heap committed.
        if (in.getVersion().onOrAfter(Version.V_2_9_0)) {
    @Nullable
        if (getHttp() != null) {
            searchBackpressureStats = null;
 * SPDX-License-Identifier: Apache-2.0
        super(node);
        if (out.getVersion().onOrAfter(Version.V_3_9_0)) {
    }
    @Nullable
import org.opensearch.core.indices.breaker.AllCircuitBreakerStats;
            getFileCacheOnlyStats().getFullFileCacheStats().toXContent(builder, params);
        if (getDiscoveryStats() != null) {
            builder.field("resident_bytes", stats.getNativeResidentBytes());
        out.writeOptionalWriteable(breaker);
    @Nullable
     * Thread Pool level statistics.
    @Nullable
    @Nullable
    public HttpStats getHttp() {
            out.writeOptionalWriteable(searchPipelineStats);
        } else {
            fileCacheStats = null;
    @Nullable
        if (out.getVersion().onOrAfter(Version.V_2_9_0)) {
        }
    @Nullable
            out.writeLong(totalEstimatedNativeBytes);
            weightedRoutingStats = null;
        }
    }
        }
        }
        } else {
     * Computed once in {@link org.opensearch.node.NodeService#stats} via
        if (getTransport() != null) {
     */
    @Nullable
        if (getBreaker() != null) {
    @Nullable
    @Nullable
 * Node statistics (dynamic, changes depending on when created).
        }
 * KIND, either express or implied.  See the License for the
        this.scriptCacheStats = scriptCacheStats;
        } else {
     * JVM level statistics.
        if (getProcess() != null) {
    }
            getSearchBackpressureStats().toXContent(builder, params);
            out.writeOptionalWriteable(null);
import org.opensearch.discovery.DiscoveryStats;
    @Nullable
        @Nullable NodeIndicesStats indices,
    @Nullable
        }
            builder.endObject();
        if (out.getVersion().onOrAfter(Version.V_2_4_0)) {
    }
        }
        return fs;
        if (getFileCacheOnlyStats() != null) {
import org.opensearch.node.NodesResourceUsageStats;
        out.writeOptionalWriteable(process);
    @Nullable
            weightedRoutingStats = in.readOptionalWriteable(WeightedRoutingStats::new);
    @Nullable
    }
        if (in.readBoolean()) {
    public String getHostname() {
        adaptiveSelectionStats = in.readOptionalWriteable(AdaptiveSelectionStats::new);
 */
    public ClusterManagerThrottlingStats getClusterManagerThrottlingStats() {
        return searchPipelineStats;
        }
        builder.startArray("roles");
        } else {
    @Nullable
            NativeAllocatorPoolStats stats = getNativeAllocatorStats();
            out.writeOptionalWriteable(nativeAllocatorStats);
            out.writeOptionalWriteable(fileCacheOnlyStats);
        for (DiscoveryNodeRole role : getNode().getRoles()) {
    public void writeTo(StreamOutput out) throws IOException {
        return this.threadPool;
        threadPool = in.readOptionalWriteable(ThreadPoolStats::new);
    }
        this.http = http;
     * Returns the process-level native-memory estimate captured on this node
        this.timestamp = timestamp;
    }
        }
        @Nullable BlockCacheStats blockCacheOnlyStats,
            searchPipelineStats = null;
import org.opensearch.script.ScriptCacheStats;
    @Nullable
}
        if (getShardIndexingPressureStats() != null) {
    private JvmStats jvm;
    }
        this.resourceUsageStats = resourceUsageStats;
    @Nullable
            getIndices().toXContent(builder, params);
        if (getOs() != null) {
        @Nullable SegmentReplicationRejectionStats segmentReplicationRejectionStats,
import org.opensearch.repositories.RepositoriesStats;
    }
    private NodesResourceUsageStats resourceUsageStats;
import org.opensearch.http.HttpStats;
    @Nullable
        }
            builder.endObject();
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
            blockCacheOnlyStats = null;
        builder.endObject();
        @Nullable AdmissionControlStats admissionControlStats,
        if (out.getVersion().onOrAfter(Version.V_2_6_0)) {
import org.opensearch.search.backpressure.stats.SearchBackpressureStats;
 * the Apache License, Version 2.0 (the "License"); you may
        return adaptiveSelectionStats;
            // BWC: write old-format NativeAllocatorPoolStats for V_3_7_0 nodes
    private ThreadPoolStats threadPool;
    @Nullable
     * {@code /proc/self/status} (non-Linux platforms or restricted environments).
        out.writeOptionalWriteable(scriptStats);
        @Nullable SearchBackpressureStats searchBackpressureStats,
            nativeAllocatorStats = null;
    }
            getFileCacheStats().toXContent(builder, params);
        @Nullable IndexingPressureStats indexingPressureStats,
    public NodeStats(
        }
 * GitHub history for details.
import java.io.IOException;
    /**
        out.writeOptionalWriteable(os);
        }
        this.concurrencyLimiterStats = concurrencyLimiterStats;
        discoveryStats = in.readOptionalWriteable(DiscoveryStats::new);
        return resourceUsageStats;
    public SearchPipelineStats getSearchPipelineStats() {
        }
import org.opensearch.index.stats.ShardIndexingPressureStats;
            totalEstimatedNativeBytes = in.readLong();
    }
        return concurrencyLimiterStats;
        return ingestStats;
    @Override
        return scriptCacheStats;
     * File system level stats.
        return nativeAllocatorStats;
        @Nullable ProcessStats process,
    }
            taskCancellationStats = in.readOptionalWriteable(TaskCancellationStats::new);
            }
/**
            out.writeOptionalWriteable(remoteStoreNodeStats);
        return this.http;
            getFileCacheOnlyStats().getOverallFileCacheStats().toXContent(builder, params);
            out.writeOptionalWriteable(weightedRoutingStats);
        shardIndexingPressureStats = in.readOptionalWriteable(ShardIndexingPressureStats::new);
        return clusterManagerThrottlingStats;
        } else {
     * Returns the native allocator pool stats (Arrow allocator), or {@code null} if not available.
    public ScriptStats getScriptStats() {
        return indexingPressureStats;
        this.breaker = breaker;
        if (in.getVersion().onOrAfter(Version.V_2_6_0)) {
 */
import org.opensearch.cluster.node.DiscoveryNode;
        }
        if (out.getVersion().onOrAfter(Version.V_2_6_0)) {
    }
        return fileCacheOnlyStats;
        }
    private ScriptStats scriptStats;
        if (getFs() != null) {
        builder.startObject("native_memory");
        this.scriptStats = scriptStats;
        breaker = in.readOptionalWriteable(AllCircuitBreakerStats::new);
    ) {
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
        if (getIndexingPressureStats() != null) {
import org.opensearch.cluster.node.DiscoveryNodeRole;
    /** Populated only when ?detailed is requested: FileCache-only stats (no block cache contribution). */
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
        } else {
    public IndexingPressureStats getIndexingPressureStats() {
        }
    }
        @Nullable ShardIndexingPressureStats shardIndexingPressureStats,
            for (var entry : stats.getGroupedStats().entrySet()) {
        if (getClusterManagerThrottlingStats() != null) {
    @Nullable
     */
    }
    @Nullable
            fileCacheOnlyStats = null;
        }
        }
    @Nullable
        }
        }
    @Nullable
        @Nullable AggregateFileCacheStats fileCacheOnlyStats,
        @Nullable RepositoriesStats repositoriesStats,
        builder.field("name", getNode().getName());
import org.opensearch.threadpool.ThreadPoolStats;
import org.opensearch.index.SegmentReplicationRejectionStats;
import org.opensearch.indices.NodeIndicesStats;
import org.opensearch.cluster.routing.WeightedRoutingStats;
    /**
        } else {
import org.opensearch.ratelimitting.admissioncontrol.stats.AdmissionControlStats;
    }
        this.admissionControlStats = admissionControlStats;
            nodeCacheStats = null;
    }
        if (getIngestStats() != null) {
        } else {
        this.shardIndexingPressureStats = shardIndexingPressureStats;
import org.opensearch.monitor.jvm.JvmStats;
        this.clusterManagerThrottlingStats = clusterManagerThrottlingStats;
import org.opensearch.script.ScriptStats;
    @Nullable
 * specific language governing permissions and limitations
    private BlockCacheStats blockCacheOnlyStats;
            getAdaptiveSelectionStats().toXContent(builder, params);
        this.transport = transport;
        }
import org.opensearch.core.xcontent.XContentBuilder;
    }
        builder.field("transport_address", getNode().getAddress().toString());
            getAdmissionControlStats().toXContent(builder, params);
    private ScriptCacheStats scriptCacheStats;
    public long getTotalEstimatedNativeBytes() {
    @Nullable
        return this.timestamp;
import org.opensearch.tasks.TaskCancellationStats;
            out.writeBoolean(true);
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
        this.os = os;
        } else {
        long totalEstimatedNativeBytes
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
        if (in.getVersion().onOrAfter(Version.V_3_9_0)) {
            builder.endObject();
            taskCancellationStats = null;
        this.process = process;
     * Indices level stats.
 * compatible open source license.
    private IndexingPressureStats indexingPressureStats;
     */
        this.weightedRoutingStats = weightedRoutingStats;
        indexingPressureStats = in.readOptionalWriteable(IndexingPressureStats::new);
 * ownership. Elasticsearch licenses this file to you under
    private OsStats os;
    }
     * Operating System level statistics.
        if (in.getVersion().onOrAfter(Version.V_2_18_0)) {
            admissionControlStats = null;
        }
            nodeCacheStats = in.readOptionalWriteable(NodeCacheStats::new);
        }
            getConcurrencyLimiterStats().toXContent(builder, params);
        if (getScriptCacheStats() != null) {
        }
        if (in.getVersion().onOrAfter(Version.V_2_4_0)) {
        @Nullable AggregateFileCacheStats fileCacheStats,
    public AllCircuitBreakerStats getBreaker() {
            scriptCacheStats = scriptStats.toScriptCacheStats();
            resourceUsageStats = in.readOptionalWriteable(NodesResourceUsageStats::new);
            getRemoteStoreNodeStats().toXContent(builder, params);
            getScriptCacheStats().toXContent(builder, params);
            concurrencyLimiterStats = null;
    private DiscoveryStats discoveryStats;
        return getNode().getHostName();
    }
    }
     * Process level statistics.
        if (getAdaptiveSelectionStats() != null) {
        } else if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
    }
    }
        builder.field("ip", getNode().getAddress());
    }
    }
    public AdaptiveSelectionStats getAdaptiveSelectionStats() {
        }
            getNodeCacheStats().toXContent(builder, params);
    private NativeAllocatorPoolStats nativeAllocatorStats;
    public WeightedRoutingStats getWeightedRoutingStats() {
            remoteStoreNodeStats = null;
    public ScriptCacheStats getScriptCacheStats() {
        }
        if (out.getVersion().onOrAfter(Version.V_2_9_0)) {
    @Nullable
        return segmentReplicationRejectionStats;
    public SegmentReplicationRejectionStats getSegmentReplicationRejectionStats() {
        return this.os;
            builder.value(role.roleName());
    /**
        return nodeCacheStats;
        }
 *
            getRepositoriesStats().toXContent(builder, params);
    private ClusterManagerThrottlingStats clusterManagerThrottlingStats;
        } else {
    @Nullable
        out.writeOptionalWriteable(indexingPressureStats);
import org.opensearch.node.remotestore.RemoteStoreNodeStats;
        }

    @Nullable
        if (out.getVersion().onOrAfter(Version.V_2_7_0)) {  
        if (out.getVersion().onOrAfter(Version.V_2_6_0)) {  
        @Nullable ScriptCacheStats scriptCacheStats,  
    @Nullable  
/*  
        out.writeOptionalWriteable(jvm);
    private SearchPipelineStats searchPipelineStats;
        if (getHttp() != null) {
            fileCacheStats = in.readOptionalWriteable(AggregateFileCacheStats::new);  
        }
    @Nullable
        }
        }
        @Nullable AllCircuitBreakerStats breaker,  
import org.opensearch.node.remotestore.RemoteStoreNodeStats;
            blockCacheOnlyStats = in.readOptionalWriteable(BlockCacheStats::new);  
        }
    }  
    @Nullable  
        if (getResourceUsageStats() != null) {
            // BWC: write old-format NativeAllocatorPoolStats for V_3_7_0 nodes
import org.opensearch.node.AdaptiveSelectionStats;  
 * Licensed to Elasticsearch under one or more contributor  
        fs = in.readOptionalWriteable(FsInfo::new);
    private AdaptiveSelectionStats adaptiveSelectionStats;
    @Nullable
            }
        }
 * specific language governing permissions and limitations
            out.writeOptionalWriteable(clusterManagerThrottlingStats);
        @Nullable WeightedRoutingStats weightedRoutingStats,
 * ownership. Elasticsearch licenses this file to you under  
        }  
            builder.startObject("attributes");
        @Nullable JvmStats jvm,
        builder.startArray("roles");  
     */  
        }
    @Nullable
    public ScriptStats getScriptStats() {
        return taskCancellationStats;
            getFileCacheOnlyStats().getOverallFileCacheStats().toXContent(builder, params);
        }
    private ScriptStats scriptStats;
    }  
        }
            getRepositoriesStats().toXContent(builder, params);  
        out.writeOptionalWriteable(process);
        this.resourceUsageStats = resourceUsageStats;
    @Nullable
            getFileCacheStats().toXContent(builder, params);  
    }  
            getProcess().toXContent(builder, params);  
        return fileCacheStats;
    /**
        if (in.getVersion().onOrAfter(Version.V_2_6_0)) {
        }
    private ActionConcurrencyLimiterStats concurrencyLimiterStats;
        }
    @Nullable  
    @Nullable
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
            out.writeBoolean(false);
            searchPipelineStats = null;
     * {@code /proc/self/status} (non-Linux platforms or restricted environments).
        this.totalEstimatedNativeBytes = totalEstimatedNativeBytes;  
    public NativeAllocatorPoolStats getNativeAllocatorStats() {
 *  
            getScriptStats().toXContent(builder, params);  
        return builder;
    public ActionConcurrencyLimiterStats getConcurrencyLimiterStats() {
        if (getConcurrencyLimiterStats() != null) {
        return nativeAllocatorStats;  
     */  
        }  
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
    @Nullable
            taskCancellationStats = in.readOptionalWriteable(TaskCancellationStats::new);  
        long timestamp,  
        if (getAdaptiveSelectionStats() != null) {
import org.opensearch.monitor.jvm.JvmStats;  
                entry.getValue().toXContent(builder, params);  
        if (getRepositoriesStats() != null) {
    private NodeCacheStats nodeCacheStats;
            out.writeOptionalWriteable(searchPipelineStats);
        this.breaker = breaker;  
        }
        }
    }
        this.scriptCacheStats = scriptCacheStats;  
    public ScriptCacheStats getScriptCacheStats() {
            totalEstimatedNativeBytes = -1L;  
    /**  
        }  
        timestamp = in.readVLong();
    }
        this.indices = indices;
        if (out.getVersion().onOrAfter(Version.V_2_14_0)) {
            concurrencyLimiterStats = in.readOptionalWriteable(ActionConcurrencyLimiterStats::new);
        this.process = process;  
    /**
    private DiscoveryStats discoveryStats;
        @Nullable BlockCacheStats blockCacheOnlyStats,
        if (getDiscoveryStats() != null) {
import org.opensearch.plugins.BlockCacheStats;
    private AllCircuitBreakerStats breaker;
            getAdaptiveSelectionStats().toXContent(builder, params);  
     * {@code OsProbe.getProcessNativeMemoryBytes()} and serialized over the wire so the coordinator  
    @Nullable
        out.writeOptionalWriteable(http);  
        @Nullable TransportStats transport,
    }  
        return totalEstimatedNativeBytes;
import org.opensearch.ratelimitting.admissioncontrol.stats.AdmissionControlStats;  
        @Nullable RepositoriesStats repositoriesStats,  
        if (getTaskCancellationStats() != null) {
            getResourceUsageStats().toXContent(builder, params);
        if (getIndices() != null) {
        return weightedRoutingStats;  
    }
        }  
 * The OpenSearch Contributors require contributions made to  
    public RemoteStoreNodeStats getRemoteStoreNodeStats() {  
        @Nullable ClusterManagerThrottlingStats clusterManagerThrottlingStats,
    private FsInfo fs;
        } else {
        }  
        this.shardIndexingPressureStats = shardIndexingPressureStats;
        this.nodeCacheStats = nodeCacheStats;
        @Nullable AdaptiveSelectionStats adaptiveSelectionStats,
    }
            builder.endObject();  
        this.adaptiveSelectionStats = adaptiveSelectionStats;
        if (getRemoteStoreNodeStats() != null) {
    @Nullable  
    @Nullable
            repositoriesStats = in.readOptionalWriteable(RepositoriesStats::new);
        // total_estimated_bytes ≈ RssAnon - JVM heap committed - JVM non-heap committed.
 * GitHub history for details.
        if (getNodeCacheStats() != null) {
        @Nullable ShardIndexingPressureStats shardIndexingPressureStats,
    @Nullable
        } else {
    private NodesResourceUsageStats resourceUsageStats;
        this.repositoriesStats = repositoriesStats;  
    @Nullable
    private NodeIndicesStats indices;
        return this.scriptStats;
    private NativeAllocatorPoolStats nativeAllocatorStats;
    @Nullable  
    private SearchBackpressureStats searchBackpressureStats;
    @Nullable
        this.fs = fs;  
        }
    public OsStats getOs() {  
     * File system level stats.
            out.writeOptionalWriteable(resourceUsageStats);
            admissionControlStats = in.readOptionalWriteable(AdmissionControlStats::new);
        if (in.getVersion().onOrAfter(Version.V_2_9_0)) {
            }
    }
    private AggregateFileCacheStats fileCacheOnlyStats;  
            out.writeOptionalWriteable(nodeCacheStats);
            builder.startObject("memory_pools");
    @Nullable
            clusterManagerThrottlingStats = in.readOptionalWriteable(ClusterManagerThrottlingStats::new);
     * Returns the process-level native-memory estimate captured on this node  
        }
import org.opensearch.script.ScriptCacheStats;
        return jvm;
        this.nativeAllocatorStats = nativeAllocatorStats;
    public SearchPipelineStats getSearchPipelineStats() {
        if (out.getVersion().onOrAfter(Version.V_3_9_0)) {
        return nodeCacheStats;
        return repositoriesStats;
 * @opensearch.internal
        }
        if (getFileCacheOnlyStats() != null) {
        @Nullable AggregateFileCacheStats fileCacheStats,  
    @Nullable
    public ClusterManagerThrottlingStats getClusterManagerThrottlingStats() {
            getSegmentReplicationRejectionStats().toXContent(builder, params);
    public AdaptiveSelectionStats getAdaptiveSelectionStats() {
        @Nullable HttpStats http,
    @Nullable  
    @Nullable
        process = in.readOptionalWriteable(ProcessStats::new);
        } else {
            // BWC: V_3_7_0 expects AnalyticsBackendNativeMemoryStats here; write null.
import java.util.Map;
    }  
        // native_memory: unified view of all native memory pools and jemalloc stats.  
import org.opensearch.node.NodesResourceUsageStats;
    public TaskCancellationStats getTaskCancellationStats() {  
    /**
    private HttpStats http;
            searchBackpressureStats = in.readOptionalWriteable(SearchBackpressureStats::new);
    }
        @Nullable SearchPipelineStats searchPipelineStats,
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {  
    }
        }
        }
        } else {
        this.os = os;
        @Nullable IndexingPressureStats indexingPressureStats,
        }  
            nativeAllocatorStats = null;
    }
        } else {  
        if (in.getVersion().onOrAfter(Version.V_2_18_0)) {
        this.searchBackpressureStats = searchBackpressureStats;  
        if (getWeightedRoutingStats() != null) {
import org.opensearch.cluster.node.DiscoveryNode;
        }
        }
    @Nullable
import org.opensearch.search.backpressure.stats.SearchBackpressureStats;
            out.writeOptionalWriteable(taskCancellationStats);
    public BlockCacheStats getBlockCacheOnlyStats() {
/*
        out.writeOptionalWriteable(threadPool);  
            out.writeLong(totalEstimatedNativeBytes);  
    public void writeTo(StreamOutput out) throws IOException {  
        if (getIndexingPressureStats() != null) {
            out.writeOptionalWriteable(blockCacheOnlyStats);
    @Nullable
            getHttp().toXContent(builder, params);  
import org.opensearch.monitor.process.ProcessStats;
     * Computed once in {@link org.opensearch.node.NodeService#stats} via
        } else {  
            getSearchPipelineStats().toXContent(builder, params);
        @Nullable TaskCancellationStats taskCancellationStats,  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            getSearchBackpressureStats().toXContent(builder, params);  
    }
        if (out.getVersion().onOrAfter(Version.V_2_9_0)) {
        }
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
        this.indexingPressureStats = indexingPressureStats;
        @Nullable FsInfo fs,  
            blockCacheOnlyStats = null;  
        return getNode().getHostName();  
     * Returns the native allocator pool stats (Arrow allocator), or {@code null} if not available.
    /** Populated only when ?detailed is requested: combined rollup across all BlockCache implementations. */
 */
    private long timestamp;
    public AggregateFileCacheStats getFileCacheOnlyStats() {
        if (getNativeAllocatorStats() != null) {
    }
    @Nullable
    }  
        }
    }  
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;  
    @Nullable  
    public AggregateFileCacheStats getFileCacheStats() {  
        return this.indices;
 * license agreements. See the NOTICE file distributed with
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {  
import org.opensearch.indices.NodeIndicesStats;  
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {  
        }
            builder.field("allocated_bytes", stats.getNativeAllocatedBytes());
        if (in.getVersion().onOrAfter(Version.V_2_6_0)) {  
        this.taskCancellationStats = taskCancellationStats;  
        if (getShardIndexingPressureStats() != null) {
        } else {
        if (in.getVersion().onOrAfter(Version.V_2_14_0)) {
    @Nullable
    public NodeCacheStats getNodeCacheStats() {
import org.opensearch.core.indices.breaker.AllCircuitBreakerStats;  
        discoveryStats = in.readOptionalWriteable(DiscoveryStats::new);  
            out.writeOptionalWriteable(admissionControlStats);
            indices.writeTo(out);
        return shardIndexingPressureStats;
    }
        @Nullable RemoteStoreNodeStats remoteStoreNodeStats,  
            indices = new NodeIndicesStats(in);
     * Operating System level statistics.  
    @Nullable  
            builder.endObject();
    @Nullable
            getThreadPool().toXContent(builder, params);  
        if (getClusterManagerThrottlingStats() != null) {
            remoteStoreNodeStats = in.readOptionalWriteable(RemoteStoreNodeStats::new);
        if (indices == null) {  
import org.opensearch.action.support.nodes.BaseNodeResponse;  
    private RepositoriesStats repositoriesStats;
 *  
import org.opensearch.monitor.fs.FsInfo;
            out.writeOptionalWriteable(weightedRoutingStats);
    private ScriptCacheStats scriptCacheStats;
    /**
        out.writeOptionalWriteable(ingestStats);
    }  
            getBlockCacheOnlyStats().toXContent(builder, params);
import org.opensearch.repositories.RepositoriesStats;
        this.searchPipelineStats = searchPipelineStats;
        scriptStats = in.readOptionalWriteable(ScriptStats::new);
 *
    /** Populated only when ?detailed is requested: FileCache-only stats (no block cache contribution). */
        }  
import org.opensearch.core.common.io.stream.StreamOutput;
    @Nullable  
            nativeAllocatorStats = in.readOptionalWriteable(NativeAllocatorPoolStats::new);
        jvm = in.readOptionalWriteable(JvmStats::new);
        if (getThreadPool() != null) {
    public NodeIndicesStats getIndices() {
            searchBackpressureStats = null;
            out.writeOptionalWriteable(nativeAllocatorStats);
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {  
            out.writeOptionalWriteable(fileCacheOnlyStats);
        }
    }
    private OsStats os;
            fileCacheOnlyStats = in.readOptionalWriteable(AggregateFileCacheStats::new);
    @Nullable
        } else {  
            clusterManagerThrottlingStats = null;
        if (getSearchBackpressureStats() != null) {
        if (getScriptStats() != null) {
        if (out.getVersion().onOrAfter(Version.V_3_8_0)) {
        builder.field("transport_address", getNode().getAddress().toString());
        this.weightedRoutingStats = weightedRoutingStats;
        @Nullable ProcessStats process,  
    @Nullable
        if (in.getVersion().onOrAfter(Version.V_2_4_0)) {
import org.opensearch.common.Nullable;
    public ThreadPoolStats getThreadPool() {  
    @Nullable
        @Nullable NodeIndicesStats indices,
        out.writeVLong(timestamp);
public class NodeStats extends BaseNodeResponse implements ToXContentFragment {  
import org.opensearch.action.ActionConcurrencyLimiterStats;
    @Nullable  
import org.opensearch.core.xcontent.XContentBuilder;
        } else if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
 * KIND, either express or implied.  See the License for the
    private JvmStats jvm;
                builder.field(attrEntry.getKey(), attrEntry.getValue());  
     * renders the source node's value, not its own. {@code -1} when the probe could not read
            NativeAllocatorPoolStats stats = getNativeAllocatorStats();
        if (out.getVersion().onOrAfter(Version.V_2_9_0)) {
        return fileCacheOnlyStats;  
    @Nullable  
        out.writeOptionalWriteable(adaptiveSelectionStats);
            getBreaker().toXContent(builder, params);  
            nodeCacheStats = null;
            fileCacheStats = null;
        } else {
        this.jvm = jvm;
        return resourceUsageStats;
        }  
        return admissionControlStats;  
        } else {  
        builder.endObject();
        return fs;  
    private ProcessStats process;
            getNodeCacheStats().toXContent(builder, params);  
        }
    @Nullable
    @Nullable  
        return scriptCacheStats;  
import org.opensearch.discovery.DiscoveryStats;  
    @Nullable
        @Nullable AdmissionControlStats admissionControlStats,
        return ingestStats;  
        @Nullable SearchBackpressureStats searchBackpressureStats,  
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
    private TransportStats transport;
import org.opensearch.index.stats.IndexingPressureStats;  
            resourceUsageStats = null;  
            // BWC: V_3_7_0 wrote old-format NativeAllocatorPoolStats (3 VLongs + pools with 4 fields); read and discard.  
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
    private ThreadPoolStats threadPool;
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.segmentReplicationRejectionStats = segmentReplicationRejectionStats;
        os = in.readOptionalWriteable(OsStats::new);  
        }
            remoteStoreNodeStats = null;
        threadPool = in.readOptionalWriteable(ThreadPoolStats::new);  
            getFileCacheOnlyStats().getBlockFileCacheStats().toXContent(builder, params);  
    @Nullable  
import org.opensearch.script.ScriptStats;  
            fileCacheOnlyStats = null;
        out.writeOptionalWriteable(fs);
    private AdmissionControlStats admissionControlStats;
        }
 * Node statistics (dynamic, changes depending on when created).
    /**  
    public IndexingPressureStats getIndexingPressureStats() {
        if (getSegmentReplicationRejectionStats() != null) {
            getTransport().toXContent(builder, params);  
        if (in.getVersion().onOrAfter(Version.V_2_9_0)) {
        out.writeOptionalWriteable(os);  
        }
    @Nullable  
        } else if (out.getVersion().onOrAfter(Version.V_3_7_0)) {  
    }  
        }
    private IndexingPressureStats indexingPressureStats;
            builder.endObject();
        } else {  
        scriptCacheStats = null;  
        }  
        return indexingPressureStats;
    @Nullable
        if (getFs() != null) {
        }  
        @Nullable DiscoveryStats discoveryStats,
    private WeightedRoutingStats weightedRoutingStats;
            segmentReplicationRejectionStats = in.readOptionalWriteable(SegmentReplicationRejectionStats::new);  
package org.opensearch.action.admin.cluster.node.stats;
            out.writeOptionalWriteable(fileCacheStats);
        out.writeOptionalWriteable(transport);
        if (getBlockCacheOnlyStats() != null) {
            builder.value(role.roleName());
            getIndexingPressureStats().toXContent(builder, params);  
        for (DiscoveryNodeRole role : getNode().getRoles()) {
    }
    }  
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
        return searchPipelineStats;  
        DiscoveryNode node,
        @Nullable OsStats os,
        this.ingestStats = ingestStats;  
    @Nullable
    @Nullable
        }
            out.writeOptionalWriteable(segmentReplicationRejectionStats);
        return searchBackpressureStats;  
    @Nullable  
    @Nullable  
        builder.field("total_estimated_bytes", totalEstimatedNativeBytes);  
import org.opensearch.index.SegmentReplicationRejectionStats;
        }
    @Nullable
            NativeAllocatorPoolStats.writeV3_7(out, nativeAllocatorStats);
import org.opensearch.ingest.IngestStats;
        this.discoveryStats = discoveryStats;
        @Nullable AggregateFileCacheStats fileCacheOnlyStats,
        }
            scriptCacheStats = scriptStats.toScriptCacheStats();
    /**
        this.fileCacheStats = fileCacheStats;  
import java.io.IOException;
        }
    }
            getConcurrencyLimiterStats().toXContent(builder, params);  
            nativeAllocatorStats = null;
        }  
        return this.http;
    @Nullable
    }
        @Nullable NativeAllocatorPoolStats nativeAllocatorStats,
        shardIndexingPressureStats = in.readOptionalWriteable(ShardIndexingPressureStats::new);
    @Nullable
 * under the License.  
        long totalEstimatedNativeBytes  
        if (getAdmissionControlStats() != null) {
        builder.endArray();
        adaptiveSelectionStats = in.readOptionalWriteable(AdaptiveSelectionStats::new);
    @Nullable  
            out.writeOptionalWriteable(remoteStoreNodeStats);
import org.opensearch.monitor.os.OsStats;
     * could not read {@code /proc/self/status}.
        out.writeOptionalWriteable(shardIndexingPressureStats);
    @Nullable
            getWeightedRoutingStats().toXContent(builder, params);  
        if (in.readBoolean()) {  
     * JVM level statistics.
        return adaptiveSelectionStats;
        this.transport = transport;
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
        this.concurrencyLimiterStats = concurrencyLimiterStats;
/*  
        if (!getNode().getAttributes().isEmpty()) {  
            getClusterManagerThrottlingStats().toXContent(builder, params);  
            getScriptCacheStats().toXContent(builder, params);  
    private SegmentReplicationRejectionStats segmentReplicationRejectionStats;
import org.opensearch.cluster.service.ClusterManagerThrottlingStats;
        out.writeOptionalWriteable(indexingPressureStats);  
    private AggregateFileCacheStats fileCacheStats;
            out.writeOptionalWriteable(concurrencyLimiterStats);  
            builder.startObject("file_cache");  
        }  
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {  
        out.writeOptionalWriteable(discoveryStats);  
    private BlockCacheStats blockCacheOnlyStats;
    @Nullable  
    private RemoteStoreNodeStats remoteStoreNodeStats;
        builder.field("host", getNode().getHostName());  
        } else {
        }
        }
            resourceUsageStats = in.readOptionalWriteable(NodesResourceUsageStats::new);
    /**
    private ClusterManagerThrottlingStats clusterManagerThrottlingStats;
    }
        this.remoteStoreNodeStats = remoteStoreNodeStats;  
 * Unless required by applicable law or agreed to in writing,
        out.writeOptionalWriteable(scriptStats);
            getIngestStats().toXContent(builder, params);  
/**
        } else {  
    @Nullable
 *
    public IngestStats getIngestStats() {
import org.opensearch.cluster.node.DiscoveryNodeRole;
import org.opensearch.threadpool.ThreadPoolStats;
        out.writeOptionalWriteable(breaker);
            totalEstimatedNativeBytes = in.readLong();
        }  
        } else {
        if (getSearchPipelineStats() != null) {
        }
        ingestStats = in.readOptionalWriteable(IngestStats::new);
        @Nullable ActionConcurrencyLimiterStats concurrencyLimiterStats,
    public long getTotalEstimatedNativeBytes() {
    private long totalEstimatedNativeBytes;
        }  
            weightedRoutingStats = null;  
            searchPipelineStats = in.readOptionalWriteable(SearchPipelineStats::new);
        }  
            out.writeOptionalWriteable(searchBackpressureStats);
    public WeightedRoutingStats getWeightedRoutingStats() {
    public FsInfo getFs() {
     */
 */
        builder.field("name", getNode().getName());
        }
        this.http = http;
        }
        return this.os;
    }
        }
        }
        }
        }  
        this.scriptStats = scriptStats;
    @Nullable
        @Nullable SegmentReplicationRejectionStats segmentReplicationRejectionStats,
import org.opensearch.tasks.TaskCancellationStats;  
        if (in.getVersion().onOrAfter(Version.V_3_8_0)) {  
    public NodesResourceUsageStats getResourceUsageStats() {  
import org.opensearch.core.xcontent.ToXContentFragment;
        if (getFileCacheStats() != null) {
        }
            out.writeOptionalWriteable(null);  
    @Nullable
            out.writeOptionalWriteable(repositoriesStats);
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
            // BWC: V_3_7_0 wrote AnalyticsBackendNativeMemoryStats here; read and discard.
            for (Map.Entry<String, String> attrEntry : getNode().getAttributes().entrySet()) {
        return remoteStoreNodeStats;
            in.readOptionalWriteable(AnalyticsBackendNativeMemoryStats::new);
            getFileCacheOnlyStats().getPinnedFileCacheStats().toXContent(builder, params);
        if (scriptStats != null) {
     */  
    public NodeStats(
        @Nullable IngestStats ingestStats,  
        }
        this.admissionControlStats = admissionControlStats;
        if (out.getVersion().onOrAfter(Version.V_2_18_0)) {
     * Thread Pool level statistics.  
    public DiscoveryStats getDiscoveryStats() {  
 * You may obtain a copy of the License at  
        super(node);
 * not use this file except in compliance with the License.
import org.opensearch.common.cache.service.NodeCacheStats;  
        }  
    public TransportStats getTransport() {
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
    @Nullable  
        this.threadPool = threadPool;
            getIndices().toXContent(builder, params);  
        http = in.readOptionalWriteable(HttpStats::new);  
            getJvm().toXContent(builder, params);  
    }  
import org.opensearch.Version;
        if (getBreaker() != null) {
     */
    public NodeStats(StreamInput in) throws IOException {  
        super(in);
 * the Apache License, Version 2.0 (the "License"); you may
            taskCancellationStats = null;
        }
        }
    public ShardIndexingPressureStats getShardIndexingPressureStats() {  
    @Nullable
        if (getScriptCacheStats() != null) {
    }
        }
        if (getJvm() != null) {
    @Nullable
        @Nullable ScriptStats scriptStats,
        } else {
        if (in.getVersion().onOrAfter(Version.V_3_9_0)) {
    public JvmStats getJvm() {
        }  
            builder.field("resident_bytes", stats.getNativeResidentBytes());
        return this.transport;
        } else {  
    @Nullable  
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (getOs() != null) {
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        }  
        if (out.getVersion().onOrAfter(Version.V_2_6_0)) {  
    public RepositoriesStats getRepositoriesStats() {  
     * (RssAnon - JVM heap committed - JVM non-heap committed), or {@code -1} when the probe
        this.blockCacheOnlyStats = blockCacheOnlyStats;
        this.timestamp = timestamp;  
    public SearchBackpressureStats getSearchBackpressureStats() {
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
    @Override
    ) {
            weightedRoutingStats = in.readOptionalWriteable(WeightedRoutingStats::new);
            getFileCacheOnlyStats().getFullFileCacheStats().toXContent(builder, params);
        return concurrencyLimiterStats;
        return this.threadPool;
        return this.discoveryStats;
    @Nullable
    }
            in.readOptionalWriteable(NativeAllocatorPoolStats::readAndDiscardV3_7);
    @Nullable
            repositoriesStats = null;
        builder.field("ip", getNode().getAddress());
            getRemoteStoreNodeStats().toXContent(builder, params);  
            getFs().toXContent(builder, params);  
 * SPDX-License-Identifier: Apache-2.0
     * Indices level stats.
     */  
            builder.startObject("runtime");  
import org.opensearch.core.common.io.stream.StreamInput;
    }
import org.opensearch.cluster.routing.WeightedRoutingStats;  
        transport = in.readOptionalWriteable(TransportStats::new);
    @Nullable
        if (getIngestStats() != null) {
            nodeCacheStats = in.readOptionalWriteable(NodeCacheStats::new);  
import org.opensearch.search.pipeline.SearchPipelineStats;
    }  
import org.opensearch.index.stats.ShardIndexingPressureStats;
 * this file be licensed under the Apache-2.0 license or a
        }  
            getShardIndexingPressureStats().toXContent(builder, params);  
    public SegmentReplicationRejectionStats getSegmentReplicationRejectionStats() {
    private ShardIndexingPressureStats shardIndexingPressureStats;
    }
 * this work for additional information regarding copyright
        @Nullable ThreadPoolStats threadPool,
        }  
    }
            for (var entry : stats.getGroupedStats().entrySet()) {
    }  
        return process;  
    private IngestStats ingestStats;
        builder.startObject("native_memory");
     * Process-level native-memory estimate captured on the data node hosting this {@code NodeStats}.
import org.opensearch.transport.TransportStats;
            getDiscoveryStats().toXContent(builder, params);  
        return this.breaker;  
        return blockCacheOnlyStats;
        }  
            concurrencyLimiterStats = null;
    @Override
    }
 */  
     */  
    public AdmissionControlStats getAdmissionControlStats() {
    private TaskCancellationStats taskCancellationStats;
        if (out.getVersion().onOrAfter(Version.V_2_4_0)) {  
        @Nullable NodesResourceUsageStats resourceUsageStats,
    }
            builder.endObject();
     */
    public HttpStats getHttp() {  
import org.opensearch.http.HttpStats;
        if (in.getVersion().onOrAfter(Version.V_2_7_0)) {
        this.fileCacheOnlyStats = fileCacheOnlyStats;
            getAdmissionControlStats().toXContent(builder, params);  
    @Nullable
        if (getTransport() != null) {
     * Process level statistics.
    @Nullable  
        super.writeTo(out);
            out.writeBoolean(true);  
 */  
        }  
            getTaskCancellationStats().toXContent(builder, params);
 * compatible open source license.
        } else {
        indexingPressureStats = in.readOptionalWriteable(IndexingPressureStats::new);
 * Modifications Copyright OpenSearch Contributors. See
    public long getTimestamp() {  
        return clusterManagerThrottlingStats;
        if (getProcess() != null) {
            admissionControlStats = null;  
    /**  
        return segmentReplicationRejectionStats;
     */
        // NativeAllocatorPoolStats now includes jemalloc allocated/resident + all pools.
        }
        breaker = in.readOptionalWriteable(AllCircuitBreakerStats::new);
        @Nullable NodeCacheStats nodeCacheStats,
        return this.timestamp;
    public String getHostname() {
        this.clusterManagerThrottlingStats = clusterManagerThrottlingStats;
    public AllCircuitBreakerStats getBreaker() {
        }  
            getOs().toXContent(builder, params);  
            segmentReplicationRejectionStats = null;
    @Nullable
        }  
    public ProcessStats getProcess() {
}

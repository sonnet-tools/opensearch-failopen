        this.aggregationUsageService = aggregationUsageService;  
            searchBackpressure ? this.searchBackpressureService.nodeStats() : null,  
    }  
        boolean threadPool,
import org.opensearch.monitor.MonitorService;
/*
        boolean jvm,  
        if (jvm) {
 * this file be licensed under the Apache-2.0 license or a
        boolean settings,  
            builder.setIngest(ingestService.info());  
        if (searchPipeline && searchPipelineService != null) {
        }
    }
        boolean scriptCache,
        boolean discoveryStats,
            builder.setTotalIndexingBuffer(indicesService.getTotalIndexingBufferBytes());  
        boolean taskCancellation,  
            jvm ? monitorService.jvmService().stats() : null,
        boolean searchPipelineStats,
        return builder.build();
            http ? (httpServerTransport == null ? null : httpServerTransport.stats()) : null,
            builder.setPlugins(pluginService.info());  
        }
        }
     * @see IndicesService#awaitClose(long, TimeUnit)
            fileCacheDetailed && nodeCacheService != null ? nodeCacheService.fileCacheStatsOnly() : null,
            cacheService ? this.cacheService.stats(indices) : null,
 */  
import java.io.IOException;  
            remoteStoreNodeStats ? new RemoteStoreNodeStats() : null,  
        this.resourceUsageCollectorService = resourceUsageCollectorService;  
     * allocator is closed.  
        boolean script,  
    }
        boolean clusterManagerThrottling,
    public boolean awaitClose(long timeout, TimeUnit timeUnit) throws InterruptedException {
        }
        return ingestService;
    private final ClusterService clusterService;
    private final PluginsService pluginService;  
    ) {
            nativeMemory ? collectNativeAllocatorStats() : null,
        boolean fs,
import org.opensearch.common.settings.SettingsFilter;
        ResponseCollectorService responseCollectorService,
            transportService.getLocalNode(),
        return nativeAllocatorStatsSupplier != null ? nativeAllocatorStatsSupplier.get() : null;
import org.opensearch.index.SegmentReplicationStatsTracker;
        AggregationUsageService aggregationUsageService,
            // unreadable.  
        IndicesService indicesService,  
        boolean os,
        }
        boolean plugin,
        }
import java.util.function.Supplier;
            admissionControl ? this.admissionControlService.stats() : null,
 * the Apache License, Version 2.0 (the "License"); you may
        boolean segmentReplicationTrackerStats,  
            // Always capture the process-level native memory estimate on this data node.  
        boolean indices,
        this.indicesService = indicesService;
            OsProbe.getInstance().getProcessNativeMemoryBytes()
import org.opensearch.tasks.TaskCancellationMonitoringService;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;  
package org.opensearch.node;
            fs ? monitorService.fsService().stats() : null,  
 * compatible open source license.
        Discovery discovery,
 * ownership. Elasticsearch licenses this file to you under  
    private final SearchBackpressureService searchBackpressureService;
import org.opensearch.search.aggregations.support.AggregationUsageService;
    }
            System.currentTimeMillis(),  
import org.opensearch.node.remotestore.RemoteStoreNodeStats;
        @Nullable Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier,  
    @Nullable
     * {@code ArrowBasePlugin.createComponents()}). When no plugin publishes a registry, the  
    private final ThreadPool threadPool;
    @Nullable  
        SearchTransportService searchTransportService,  
    private final IndexingPressureService indexingPressureService;  
 *
import org.opensearch.index.IndexingPressureService;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public IngestService getIngestService() {  
    private final Discovery discovery;
        PluginsService pluginService,
        IndexingPressureService indexingPressureService,
        boolean process,
 * Unless required by applicable law or agreed to in writing,
        this.searchBackpressureService = searchBackpressureService;
import org.opensearch.common.settings.Settings;  
        ClusterService clusterService,  
        if (threadPool) {
        this.circuitBreakerService = circuitBreakerService;
        }
            circuitBreaker ? circuitBreakerService.stats() : null,  
        boolean circuitBreaker,
        this.indexingPressureService = indexingPressureService;
            transport ? transportService.stats() : null,
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
        this.taskCancellationMonitoringService = taskCancellationMonitoringService;
        @Nullable NodeCacheService nodeCacheService,
        }
        return searchBackpressureService;  
        boolean searchBackpressure,
    }
        boolean jvm,  
import org.opensearch.common.cache.service.CacheService;
        boolean process,
/*  
 * KIND, either express or implied.  See the License for the
        CacheService cacheService,
import org.opensearch.http.HttpServerTransport;
import org.opensearch.common.util.io.IOUtils;
     */
        this.repositoriesService = repositoriesService;
        if (transport) {
    /**
            indexingPressure ? this.indexingPressureService.nodeStats() : null,
import org.opensearch.ingest.IngestService;
            segmentReplicationTrackerStats ? this.segmentReplicationStatsTracker.getTotalRejectionStats() : null,
        this.settings = settings;  
        }
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
import org.opensearch.index.store.remote.filecache.NodeCacheService;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
import org.opensearch.indices.IndicesService;  
     * Supplier for native allocator pool stats. Constructor-injected via discovery from  
        // only be applied to the sensible ones to use, like refresh/merge/flush/indexing stats)  
        SettingsFilter settingsFilter,
        this.nativeAllocatorStatsSupplier = nativeAllocatorStatsSupplier;
import org.opensearch.action.ActionConcurrencyLimiterStats;  
            ingest ? ingestService.stats() : null,  
        this.admissionControlService = admissionControlService;
        this.clusterService = clusterService;  
/*  
            weightedRoutingStats ? WeightedRoutingStats.getInstance() : null,
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlService;
        this.threadPool = threadPool;
        boolean searchPipeline
        this.scriptService = scriptService;
            scriptCache ? scriptService.cacheStats() : null,  
    private final ResponseCollectorService responseCollectorService;  
        if (aggs && aggregationUsageService != null) {
            builder.setThreadPool(this.threadPool.info());  
        MonitorService monitorService,  
        this.responseCollectorService = responseCollectorService;  
 * You may obtain a copy of the License at  
        boolean nativeMemory,
        return new NodeStats(
        if (os) {
 * license agreements. See the NOTICE file distributed with
        boolean repositoriesStats,
        return monitorService;
    }  
    private final Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier;  
            builder.setProcess(monitorService.processService().info());  
        ThreadPool threadPool,
    private final IngestService ingestService;
            searchPipelineStats ? this.searchPipelineService.stats() : null,
            clusterManagerThrottling ? this.clusterService.getClusterManagerService().getThrottlingStats() : null,
import org.opensearch.Version;
    private final AggregationUsageService aggregationUsageService;
        this.pluginService = pluginService;  
import org.opensearch.transport.TransportService;  
        CircuitBreakerService circuitBreakerService,
    private final Settings settings;
        Settings settings,
    private final SearchTransportService searchTransportService;
     * Wait for the node to be effectively closed.
            builder.setTransport(transportService.info());  
        this.ingestService = ingestService;  
    private final Supplier<ActionConcurrencyLimiterStats> concurrencyLimiterStatsSupplier;
    @Nullable
    ) {  
        boolean resourceUsageStats,
 *  
        this.searchPipelineService = searchPipelineService;
            concurrencyLimiter ? collectConcurrencyLimiterStats() : null,
            builder.setSearchPipelineInfo(searchPipelineService.info());  
        }
        if (http && httpServerTransport != null) {
 */
        SearchBackpressureService searchBackpressureService,  
    private NativeAllocatorPoolStats collectNativeAllocatorStats() {  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
        this.cacheService = cacheService;  
import org.opensearch.common.Nullable;
        boolean ingest,
        boolean transport,  
 * this work for additional information regarding copyright
        boolean threadPool,
    }
        this.settingsFilter = settingsFilter;
import org.opensearch.search.pipeline.SearchPipelineService;  
        if (process) {
        ScriptService scriptService,  
            shardIndexingPressure ? this.indexingPressureService.shardStats(indices) : null,
        boolean fileCacheDetailed,
    public void close() throws IOException {
            process ? monitorService.processService().stats() : null,  
    private final IndicesService indicesService;
        IOUtils.close(indicesService);  
 */  
    private final MonitorService monitorService;  
        boolean admissionControl,
        boolean fileCacheStats,
 * not use this file except in compliance with the License.
        this.searchTransportService = searchTransportService;
        boolean remoteStoreNodeStats,
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
    NodeService(  
    private final SegmentReplicationStatsTracker segmentReplicationStatsTracker;
     * supplier is {@code null} and {@code _nodes/stats/native_allocator} returns no allocator
            // not its own. Returns -1 on non-Linux platforms or when /proc/self/status is
            builder.setSettings(settingsFilter.filter(this.settings));  
            builder.setOs(monitorService.osService().info());  
        this.concurrencyLimiterStatsSupplier = concurrencyLimiterStatsSupplier;
    public SearchBackpressureService getSearchBackpressureService() {
        this.httpServerTransport = httpServerTransport;
        SearchPipelineService searchPipelineService,
            discoveryStats ? discovery.stats() : null,
            threadPool ? this.threadPool.stats() : null,
        }
    private final SearchPipelineService searchPipelineService;  
    private final CacheService cacheService;  
    public NodeInfo info(
/**
     * stats. The supplier itself is responsible for returning {@code null} once its underlying
 * Services exposed to nodes
import org.opensearch.threadpool.ThreadPool;
    private final NodeCacheService nodeCacheService;
        if (indices) {
    @Nullable
        }
    }  
            fileCacheStats && nodeCacheService != null ? nodeCacheService.aggregateStats() : null,  
import java.io.Closeable;
        this.transportService = transportService;  
public class NodeService implements Closeable {  
import org.opensearch.action.search.SearchTransportService;
        return concurrencyLimiterStatsSupplier != null ? concurrencyLimiterStatsSupplier.get() : null;  
import org.opensearch.script.ScriptService;  
 */
import org.opensearch.discovery.Discovery;
     * {@link org.opensearch.plugin.stats.NativeAllocatorStatsRegistry} from
import org.opensearch.cluster.service.ClusterService;  
        CommonStatsFlags indices,  
        return taskCancellationMonitoringService;
        SegmentReplicationStatsTracker segmentReplicationStatsTracker,
import org.opensearch.repositories.RepositoriesService;
        if (plugin && pluginService != null) {
import org.opensearch.Build;
        );
        this.discovery = discovery;
 * specific language governing permissions and limitations
 *
            os ? monitorService.osService().stats() : null,
            // Serialized over the wire so the coordinator renders the source node's value,
        IngestService ingestService,
    ) {
        boolean adaptiveSelection,  
        this.segmentReplicationStatsTracker = segmentReplicationStatsTracker;
        boolean shardIndexingPressure,  
        RepositoriesService repositoriesService,  
    private final ResourceUsageCollectorService resourceUsageCollectorService;
            fileCacheDetailed && nodeCacheService != null ? nodeCacheService.combinedBlockCacheStats() : null,
import org.opensearch.plugins.PluginsService;  
    private final ScriptService scriptService;
    }  
        AdmissionControlService admissionControlService,
import org.opensearch.cluster.routing.WeightedRoutingStats;
        ResourceUsageCollectorService resourceUsageCollectorService,
        boolean weightedRoutingStats,  
import java.util.concurrent.TimeUnit;
        boolean concurrencyLimiter  
    private final TransportService transportService;
            resourceUsageStats ? resourceUsageCollectorService.stats() : null,
        boolean cacheService,  
    public MonitorService getMonitorService() {
 *  
    }
    private final HttpServerTransport httpServerTransport;
            taskCancellation ? this.taskCancellationMonitoringService.stats() : null,  
        boolean ingest,
    public TaskCancellationMonitoringService getTaskCancellationMonitoringService() {  
    private ActionConcurrencyLimiterStats collectConcurrencyLimiterStats() {
        if (settings) {
        if (ingest && ingestService != null) {
        TransportService transportService,
    private final TaskCancellationMonitoringService taskCancellationMonitoringService;
 * Licensed to Elasticsearch under one or more contributor  
    private final CircuitBreakerService circuitBreakerService;
import org.opensearch.monitor.os.OsProbe;  
            script ? scriptService.stats() : null,
        TaskCancellationMonitoringService taskCancellationMonitoringService,  
     * {@code pluginComponents} in {@code Node.java} (looks up a published
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        clusterService.addStateApplier(searchPipelineService);
import org.opensearch.search.backpressure.SearchBackpressureService;
        NodeInfo.Builder builder = NodeInfo.builder(Version.CURRENT, Build.CURRENT, transportService.getLocalNode());
 * @opensearch.internal
            builder.setHttp(httpServerTransport.info());  
            builder.setJvm(monitorService.jvmService().info());  
        boolean indexingPressure,
    private final SettingsFilter settingsFilter;  
        boolean os,
        boolean http,
        this.nodeCacheService = nodeCacheService;
    private final AdmissionControlService admissionControlService;
        boolean aggs,  
        @Nullable HttpServerTransport httpServerTransport,
     */  
        clusterService.addStateApplier(ingestService);  
        // for indices stats we want to include previous allocated shards stats as well (it will
        return indicesService.awaitClose(timeout, timeUnit);
 * software distributed under the License is distributed on an
        boolean http,  
 * under the License.  
        @Nullable Supplier<ActionConcurrencyLimiterStats> concurrencyLimiterStatsSupplier
    /**  
        this.monitorService = monitorService;
            repositoriesStats ? this.repositoriesService.getRepositoriesStats() : null,  
            builder.setAggsInfo(aggregationUsageService.info());  
            adaptiveSelection ? responseCollectorService.getAdaptiveStats(searchTransportService.getPendingSearchRequests()) : null,
            indices.anySet() ? indicesService.stats(indices) : null,
}
    private final RepositoriesService repositoriesService;  
        boolean transport,
    public NodeStats stats(
    @Override

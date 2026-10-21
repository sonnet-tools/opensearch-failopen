    }
import org.opensearch.tasks.TaskCancellationMonitoringService;
 */
        CircuitBreakerService circuitBreakerService,
            builder.setHttp(httpServerTransport.info());
    @Nullable
import org.opensearch.common.Nullable;
     * allocator is closed.
    private final CircuitBreakerService circuitBreakerService;
        SearchBackpressureService searchBackpressureService,
        this.nativeAllocatorStatsSupplier = nativeAllocatorStatsSupplier;
        // only be applied to the sensible ones to use, like refresh/merge/flush/indexing stats)
        if (process) {
     * supplier is {@code null} and {@code _nodes/stats/native_allocator} returns no allocator
 * You may obtain a copy of the License at
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            builder.setIngest(ingestService.info());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            circuitBreaker ? circuitBreakerService.stats() : null,
        clusterService.addStateApplier(searchPipelineService);
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            resourceUsageStats ? resourceUsageCollectorService.stats() : null,
        boolean os,
            admissionControl ? this.admissionControlService.stats() : null,
    private final Supplier<ActionConcurrencyLimiterStats> concurrencyLimiterStatsSupplier;
public class NodeService implements Closeable {
        TaskCancellationMonitoringService taskCancellationMonitoringService,
    private final SearchTransportService searchTransportService;
            process ? monitorService.processService().stats() : null,
    }
    @Override
        if (aggs && aggregationUsageService != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final TransportService transportService;
    private final IndexingPressureService indexingPressureService;
            builder.setSearchPipelineInfo(searchPipelineService.info());
 * KIND, either express or implied.  See the License for the
        Settings settings,
        boolean segmentReplicationTrackerStats,
import org.opensearch.common.cache.service.CacheService;
        }
        @Nullable NodeCacheService nodeCacheService,
import java.util.function.Supplier;
        ResponseCollectorService responseCollectorService,
            builder.setSettings(settingsFilter.filter(this.settings));
        boolean scriptCache,
    private final TaskCancellationMonitoringService taskCancellationMonitoringService;
 *
            builder.setOs(monitorService.osService().info());
        boolean circuitBreaker,
 *
        IndicesService indicesService,
            builder.setTransport(transportService.info());
import org.opensearch.common.settings.SettingsFilter;
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
    }
        }
/*
        boolean fs,
    private ActionConcurrencyLimiterStats collectConcurrencyLimiterStats() {
        // for indices stats we want to include previous allocated shards stats as well (it will
    private final ResourceUsageCollectorService resourceUsageCollectorService;
    private final NodeCacheService nodeCacheService;
import org.opensearch.cluster.service.ClusterService;
        SegmentReplicationStatsTracker segmentReplicationStatsTracker,
import org.opensearch.action.ActionConcurrencyLimiterStats;
            script ? scriptService.stats() : null,
    private final ThreadPool threadPool;
    private final Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier;
import org.opensearch.action.search.SearchTransportService;
        SearchTransportService searchTransportService,
        if (jvm) {
    private final RepositoriesService repositoriesService;
    public SearchBackpressureService getSearchBackpressureService() {
    private final Settings settings;
        this.pluginService = pluginService;
        boolean ingest,
            builder.setAggsInfo(aggregationUsageService.info());
        }
        }
    private final SearchPipelineService searchPipelineService;
        @Nullable HttpServerTransport httpServerTransport,
        boolean searchPipelineStats,
            builder.setJvm(monitorService.jvmService().info());
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlService;
        if (searchPipeline && searchPipelineService != null) {
        boolean http,
            System.currentTimeMillis(),
    private final Discovery discovery;
import java.io.Closeable;
}
    private final PluginsService pluginService;
        boolean taskCancellation,
        this.searchBackpressureService = searchBackpressureService;
        this.settingsFilter = settingsFilter;
        }
        boolean threadPool,
    public NodeStats stats(
        AggregationUsageService aggregationUsageService,
    }
 */
    private final ClusterService clusterService;
    ) {
    }
 * @opensearch.internal
        IngestService ingestService,
    }
 * software distributed under the License is distributed on an
    public MonitorService getMonitorService() {
        boolean indexingPressure,
        this.settings = settings;
            // unreadable.
        this.admissionControlService = admissionControlService;
        }
        boolean http,
 * Unless required by applicable law or agreed to in writing,
        if (ingest && ingestService != null) {
 * specific language governing permissions and limitations
 * GitHub history for details.
import org.opensearch.index.SegmentReplicationStatsTracker;
        NodeInfo.Builder builder = NodeInfo.builder(Version.CURRENT, Build.CURRENT, transportService.getLocalNode());
 * The OpenSearch Contributors require contributions made to
        }
        CommonStatsFlags indices,
        RepositoriesService repositoriesService,
 * this file be licensed under the Apache-2.0 license or a
        boolean weightedRoutingStats,
            concurrencyLimiter ? collectConcurrencyLimiterStats() : null,
            http ? (httpServerTransport == null ? null : httpServerTransport.stats()) : null,
            threadPool ? this.threadPool.stats() : null,
        boolean shardIndexingPressure,
            shardIndexingPressure ? this.indexingPressureService.shardStats(indices) : null,
     * @see IndicesService#awaitClose(long, TimeUnit)
        }
 * Modifications Copyright OpenSearch Contributors. See
        if (threadPool) {
        return indicesService.awaitClose(timeout, timeUnit);
        ScriptService scriptService,
    public IngestService getIngestService() {
        }
     * Wait for the node to be effectively closed.
        boolean plugin,
        AdmissionControlService admissionControlService,
            searchPipelineStats ? this.searchPipelineService.stats() : null,
            // Always capture the process-level native memory estimate on this data node.
        boolean transport,
            builder.setTotalIndexingBuffer(indicesService.getTotalIndexingBufferBytes());
    }
    private final IndicesService indicesService;
            scriptCache ? scriptService.cacheStats() : null,
        if (os) {
     */
            weightedRoutingStats ? WeightedRoutingStats.getInstance() : null,
        SearchPipelineService searchPipelineService,
        if (indices) {
        @Nullable Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier,
        boolean fileCacheDetailed,
            adaptiveSelection ? responseCollectorService.getAdaptiveStats(searchTransportService.getPendingSearchRequests()) : null,
import org.opensearch.cluster.routing.WeightedRoutingStats;
        boolean jvm,
     * {@link org.opensearch.plugin.stats.NativeAllocatorStatsRegistry} from
            // not its own. Returns -1 on non-Linux platforms or when /proc/self/status is
import org.opensearch.search.pipeline.SearchPipelineService;
 * under the License.
    public void close() throws IOException {
        boolean jvm,
        this.taskCancellationMonitoringService = taskCancellationMonitoringService;
import org.opensearch.repositories.RepositoriesService;
        IndexingPressureService indexingPressureService,
 * compatible open source license.
            repositoriesStats ? this.repositoriesService.getRepositoriesStats() : null,
        this.transportService = transportService;
    private final SegmentReplicationStatsTracker segmentReplicationStatsTracker;
        boolean repositoriesStats,
    private final AggregationUsageService aggregationUsageService;
    public boolean awaitClose(long timeout, TimeUnit timeUnit) throws InterruptedException {
    /**
        this.ingestService = ingestService;
            builder.setProcess(monitorService.processService().info());
 * this work for additional information regarding copyright
        PluginsService pluginService,
    NodeService(
    private final ResponseCollectorService responseCollectorService;
        }
 */
        return taskCancellationMonitoringService;
import java.io.IOException;
        this.nodeCacheService = nodeCacheService;
 *
        ClusterService clusterService,
    private final IngestService ingestService;
        boolean clusterManagerThrottling,
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
        );
     * Supplier for native allocator pool stats. Constructor-injected via discovery from
import org.opensearch.node.remotestore.RemoteStoreNodeStats;
import org.opensearch.Version;
            taskCancellation ? this.taskCancellationMonitoringService.stats() : null,
    /**
        this.clusterService = clusterService;
        boolean adaptiveSelection,
        this.responseCollectorService = responseCollectorService;
            fileCacheDetailed && nodeCacheService != null ? nodeCacheService.fileCacheStatsOnly() : null,
import org.opensearch.ingest.IngestService;
    }
        boolean ingest,
        return concurrencyLimiterStatsSupplier != null ? concurrencyLimiterStatsSupplier.get() : null;
            fileCacheStats && nodeCacheService != null ? nodeCacheService.aggregateStats() : null,
        this.resourceUsageCollectorService = resourceUsageCollectorService;
        boolean searchBackpressure,
        return new NodeStats(
        boolean os,
 * not use this file except in compliance with the License.
        boolean nativeMemory,
        boolean admissionControl,
import org.opensearch.monitor.os.OsProbe;
        CacheService cacheService,
        boolean cacheService,
        if (plugin && pluginService != null) {
import org.opensearch.transport.TransportService;
    public NodeInfo info(
        boolean resourceUsageStats,
            builder.setPlugins(pluginService.info());
    private final SettingsFilter settingsFilter;
import org.opensearch.search.aggregations.support.AggregationUsageService;
     * {@code ArrowBasePlugin.createComponents()}). When no plugin publishes a registry, the
            builder.setThreadPool(this.threadPool.info());
        this.monitorService = monitorService;
    private NativeAllocatorPoolStats collectNativeAllocatorStats() {
import org.opensearch.script.ScriptService;
        this.searchPipelineService = searchPipelineService;
        boolean aggs,
 * license agreements. See the NOTICE file distributed with
        boolean discoveryStats,
            jvm ? monitorService.jvmService().stats() : null,
     * {@code pluginComponents} in {@code Node.java} (looks up a published
    }
import org.opensearch.indices.IndicesService;
        this.threadPool = threadPool;
            searchBackpressure ? this.searchBackpressureService.nodeStats() : null,
import org.opensearch.search.backpressure.SearchBackpressureService;
        IOUtils.close(indicesService);
            indices.anySet() ? indicesService.stats(indices) : null,
        if (transport) {
        boolean remoteStoreNodeStats,
        return searchBackpressureService;
import org.opensearch.Build;
        boolean transport,
        TransportService transportService,
        @Nullable Supplier<ActionConcurrencyLimiterStats> concurrencyLimiterStatsSupplier
    }
            OsProbe.getInstance().getProcessNativeMemoryBytes()
        ThreadPool threadPool,
            cacheService ? this.cacheService.stats(indices) : null,
        boolean threadPool,
            indexingPressure ? this.indexingPressureService.nodeStats() : null,
import org.opensearch.http.HttpServerTransport;
    ) {
package org.opensearch.node;
        this.indexingPressureService = indexingPressureService;
     * stats. The supplier itself is responsible for returning {@code null} once its underlying
            transport ? transportService.stats() : null,
        this.scriptService = scriptService;
        return nativeAllocatorStatsSupplier != null ? nativeAllocatorStatsSupplier.get() : null;
 * SPDX-License-Identifier: Apache-2.0
        this.discovery = discovery;
        Discovery discovery,
/*
        this.cacheService = cacheService;
        this.aggregationUsageService = aggregationUsageService;
        }
        if (http && httpServerTransport != null) {
import org.opensearch.index.store.remote.filecache.NodeCacheService;
    private final MonitorService monitorService;
    public TaskCancellationMonitoringService getTaskCancellationMonitoringService() {
        if (settings) {
        boolean indices,
        return monitorService;
import org.opensearch.common.settings.Settings;
 * ownership. Elasticsearch licenses this file to you under
            segmentReplicationTrackerStats ? this.segmentReplicationStatsTracker.getTotalRejectionStats() : null,
        boolean script,
 * Services exposed to nodes
        this.circuitBreakerService = circuitBreakerService;
        boolean concurrencyLimiter
            nativeMemory ? collectNativeAllocatorStats() : null,
        this.indicesService = indicesService;
        MonitorService monitorService,
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.common.util.io.IOUtils;
            fileCacheDetailed && nodeCacheService != null ? nodeCacheService.combinedBlockCacheStats() : null,
import org.opensearch.index.IndexingPressureService;
    private final ScriptService scriptService;
        return ingestService;
import org.opensearch.discovery.Discovery;
    ) {
        boolean process,
            os ? monitorService.osService().stats() : null,
import org.opensearch.plugins.PluginsService;
            ingest ? ingestService.stats() : null,
            // Serialized over the wire so the coordinator renders the source node's value,
import java.util.concurrent.TimeUnit;
            fs ? monitorService.fsService().stats() : null,
        this.repositoriesService = repositoriesService;
            discoveryStats ? discovery.stats() : null,
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        boolean process,
        return builder.build();
            clusterManagerThrottling ? this.clusterService.getClusterManagerService().getThrottlingStats() : null,
        this.httpServerTransport = httpServerTransport;
            transportService.getLocalNode(),
     */
    private final AdmissionControlService admissionControlService;
    @Nullable
    private final HttpServerTransport httpServerTransport;
        ResourceUsageCollectorService resourceUsageCollectorService,
    private final SearchBackpressureService searchBackpressureService;
 *
        this.concurrencyLimiterStatsSupplier = concurrencyLimiterStatsSupplier;
    @Nullable
        this.segmentReplicationStatsTracker = segmentReplicationStatsTracker;
        boolean fileCacheStats,
        clusterService.addStateApplier(ingestService);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.monitor.MonitorService;
/*
    private final CacheService cacheService;
        boolean settings,
        this.searchTransportService = searchTransportService;
/**
    }
 * Licensed to Elasticsearch under one or more contributor
        SettingsFilter settingsFilter,
        boolean searchPipeline
    @Nullable
 */
            remoteStoreNodeStats ? new RemoteStoreNodeStats() : null,
        }

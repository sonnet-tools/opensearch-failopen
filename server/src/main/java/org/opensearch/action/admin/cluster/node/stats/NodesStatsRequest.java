    public void writeTo(StreamOutput out) throws IOException {
    /**
        }
            this.indices.all();
/*  
        requestedMetrics.add(metric);  
     * handled separately.
    }
        FS("fs"),
        }
     */  
/*  
        SEARCH_BACKPRESSURE("search_backpressure"),  
            return this.metricName;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    }
 * this file be licensed under the Apache-2.0 license or a
    }
}  
    /**
 * Modifications Copyright OpenSearch Contributors. See
        FILE_CACHE_STATS("file_cache"),  
        SHARD_INDEXING_PRESSURE("shard_indexing_pressure"),
        CACHE_STATS("caches"),
     * Remove metric
     * @return This object, for request chaining.
        REMOTE_STORE("remote_store"),
@PublicApi(since = "1.0.0")  
            throw new IllegalStateException("Used an illegal metric: " + metric);
        if (Metric.allMetrics().contains(metric) == false) {  
        this.indices.all();
    }
    public NodesStatsRequest indices(boolean indices) {  
 */
    public Set<String> requestedMetrics() {
    public NodesStatsRequest() {
        INDEXING_PRESSURE("indexing_pressure"),
        public String metricName() {  
        out.writeStringArray(requestedMetrics.toArray(new String[0]));
    public NodesStatsRequest all() {
 * software distributed under the License is distributed on an
        REPOSITORIES("repositories"),
    /**  
     */
 * Licensed to Elasticsearch under one or more contributor  
    /**
     */
        } else {  
    /**
import java.util.TreeSet;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
import org.opensearch.core.common.io.stream.StreamOutput;  
        WEIGHTED_ROUTING_STATS("weighted_routing"),
     * Set indices. Handles separately from other metrics because it may or
        OS("os"),  
    }
     * Add an array of metric names
        boolean containedIn(Set<String> metricNames) {
 * under the License.  
            return metricNames.contains(this.metricName());
        return this;
        TASK_CANCELLATION("task_cancellation"),
        HTTP("http"),  
    private boolean fileCacheDetailed = false;
    }
        DISCOVERY("discovery"),  
    public NodesStatsRequest addMetrics(String... metrics) {
    public NodesStatsRequest addMetric(String metric) {
 * Unless required by applicable law or agreed to in writing,
        }
        TRANSPORT("transport"),
        private String metricName;  
 * @opensearch.api
 * license agreements. See the NOTICE file distributed with
/*
 * this work for additional information regarding copyright
import org.opensearch.Version;
        requestedMetrics.addAll(metricsSet);  
        if (Metric.allMetrics().containsAll(metricsSet) == false) {
     * Clears all the request flags.
    }
        return fileCacheDetailed;
    /**
        static Set<String> allMetrics() {
 * ownership. Elasticsearch licenses this file to you under  
     * Should indices stats be returned.
     */  
        ADMISSION_CONTROL("admission_control"),  
        this.fileCacheDetailed = detailed;  
 * The OpenSearch Contributors require contributions made to  
        indices.writeTo(out);  
import java.util.Arrays;  
 * compatible open source license.
     * Sets all the request flags.
 *  
        super.writeTo(out);
        }
    public NodesStatsRequest(String... nodesIds) {  
    }
        SEARCH_PIPELINE("search_pipeline"),
     */  
    public enum Metric {
     */  
     * from the nodes stats endpoint. Eventually this list will be pluggable.  
     */
import java.util.Set;
            this.indices.clear();
 * SPDX-License-Identifier: Apache-2.0
 *  
     * may not involve submetrics.  
 * A request to get node (cluster) level stats.
        }
        PROCESS("process"),
    }  
        requestedMetrics.clear();  
     */
        return this;
        return new HashSet<>(requestedMetrics);
        CONCURRENCY_LIMITER("concurrency_limiter");
        /** @deprecated Use {@link #NATIVE_MEMORY} instead. */  
import java.util.SortedSet;  
    public NodesStatsRequest fileCacheDetailed(boolean detailed) {
        super(nodesIds);
        return this;
    /**
    }
            String plural = metricsSet.size() == 1 ? "" : "s";  
        this.indices = indices;
     * @param indices flags indicating which indices stats to return
        SortedSet<String> metricsSet = new TreeSet<>(Arrays.asList(metrics));  
        BREAKER("breaker"),
 */  
        if (Metric.allMetrics().contains(metric) == false) {
            throw new IllegalStateException("Used illegal metric" + plural + ": " + metricsSet);
        return this;
 *
    /**  
        if (indices) {
    @Override  
    }  
import org.opensearch.common.annotation.PublicApi;
        }  
     * Get the names of requested metrics, excluding indices, which are
 * KIND, either express or implied.  See the License for the
        this.indices.clear();
        requestedMetrics.addAll(in.readStringList());
    }
 * You may obtain a copy of the License at  
     * for all nodes will be returned.
    /**
     */  
        @Deprecated
        return this;  
import org.opensearch.action.support.nodes.BaseNodesRequest;  
     */  
        // use sorted set for reliable ordering in error messages
 * not use this file except in compliance with the License.
    private CommonStatsFlags indices = new CommonStatsFlags();  
     * Add metric  
        CLUSTER_MANAGER_THROTTLING("cluster_manager_throttling"),
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.admin.cluster.node.stats;
            metricsSet.removeAll(Metric.allMetrics());
    }  
        RESOURCE_USAGE_STATS("resource_usage_stats"),  
        return indices;
     * Get indices. Handles separately from other metrics because it may or
     * may not have submetrics.  
        ADAPTIVE_SELECTION("adaptive_selection"),
        Metric(String name) {
        return this;  
     * An enumeration of the "core" sections of metrics that may be requested
     * Get stats from nodes based on the nodes ids specified. If none are passed, stats  
    }  
    /**
        return this;  
        THREAD_POOL("thread_pool"),  
        SCRIPT_CACHE("script_cache"),  
    private final Set<String> requestedMetrics = new HashSet<>();
        JVM("jvm"),
        indices = new CommonStatsFlags(in);
     */
        INGEST("ingest"),
    public NodesStatsRequest indices(CommonStatsFlags indices) {
        NATIVE_MEMORY("native_memory"),  
    public NodesStatsRequest removeMetric(String metric) {
    }
 *
 */
        super((String[]) null);
    }
    public NodesStatsRequest(StreamInput in) throws IOException {
        this.requestedMetrics.clear();  
        requestedMetrics.remove(metric);
/**
        SCRIPT("script"),
    public NodesStatsRequest clear() {
            out.writeBoolean(fileCacheDetailed);  
        return this;
        this.requestedMetrics.addAll(Metric.allMetrics());  
            this.metricName = name;  
            return Arrays.stream(values()).map(Metric::metricName).collect(Collectors.toSet());  
import java.io.IOException;
        super(in);  
import java.util.HashSet;
     * @return flags indicating which indices stats to return
    /**
    public boolean isFileCacheDetailed() {
 * specific language governing permissions and limitations
            throw new IllegalStateException("Used an illegal metric: " + metric);  
    public CommonStatsFlags indices() {  
        fileCacheDetailed = in.getVersion().onOrAfter(Version.V_3_7_0) && in.readBoolean();
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        }
        }
import java.util.stream.Collectors;
public class NodesStatsRequest extends BaseNodesRequest<NodesStatsRequest> {
 * GitHub history for details.
        SEGMENT_REPLICATION_BACKPRESSURE("segment_replication_backpressure"),
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
        NATIVE_ALLOCATOR("native_allocator"),
import org.opensearch.core.common.io.stream.StreamInput;

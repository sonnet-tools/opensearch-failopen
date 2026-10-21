        BREAKER("breaker"),
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.requestedMetrics.clear();
 * not use this file except in compliance with the License.
        CONCURRENCY_LIMITER("concurrency_limiter");
     * An enumeration of the "core" sections of metrics that may be requested
        return fileCacheDetailed;
        THREAD_POOL("thread_pool"),
 * You may obtain a copy of the License at
        OS("os"),
     * for all nodes will be returned.
    }
        this.indices.all();
            return metricNames.contains(this.metricName());
    public NodesStatsRequest clear() {
        REPOSITORIES("repositories"),
        NATIVE_ALLOCATOR("native_allocator"),
        HTTP("http"),
 */
        CACHE_STATS("caches"),
import org.opensearch.core.common.io.stream.StreamInput;
     * Get the names of requested metrics, excluding indices, which are
        Metric(String name) {
        NATIVE_MEMORY("native_memory"),
    /**
}
    public boolean isFileCacheDetailed() {
     * from the nodes stats endpoint. Eventually this list will be pluggable.
    public CommonStatsFlags indices() {
     * Get indices. Handles separately from other metrics because it may or
import java.util.TreeSet;
        }
    /**
import java.io.IOException;
        SCRIPT_CACHE("script_cache"),
        TRANSPORT("transport"),
     * Sets all the request flags.
 * Licensed to Elasticsearch under one or more contributor
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        super(nodesIds);
        } else {
 * specific language governing permissions and limitations
        if (indices) {
    /**
    }
     * @param indices flags indicating which indices stats to return
    }
     * Get stats from nodes based on the nodes ids specified. If none are passed, stats
        FS("fs"),
     * Remove metric
    public NodesStatsRequest() {
        super(in);
     */
        this.fileCacheDetailed = detailed;
    }
    public NodesStatsRequest(StreamInput in) throws IOException {
        return this;
    public NodesStatsRequest addMetric(String metric) {
@PublicApi(since = "1.0.0")
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        return this;
     * Should indices stats be returned.
        SCRIPT("script"),
    private final Set<String> requestedMetrics = new HashSet<>();
 */
        }
        ADMISSION_CONTROL("admission_control"),
        /** @deprecated Use {@link #NATIVE_MEMORY} instead. */
    }
    public NodesStatsRequest(String... nodesIds) {
     */
        SEARCH_PIPELINE("search_pipeline"),
     */
        requestedMetrics.remove(metric);
import org.opensearch.common.annotation.PublicApi;
 * license agreements. See the NOTICE file distributed with
        return this;
        this.indices.clear();
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
     */
        return new HashSet<>(requestedMetrics);
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        return this;
     * Set indices. Handles separately from other metrics because it may or
        @Deprecated
        return indices;
 * under the License.
 */
        JVM("jvm"),
        indices = new CommonStatsFlags(in);
        this.requestedMetrics.addAll(Metric.allMetrics());
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
            throw new IllegalStateException("Used illegal metric" + plural + ": " + metricsSet);
     * Add metric
     */
 * The OpenSearch Contributors require contributions made to
import java.util.stream.Collectors;
            this.indices.clear();
     * @return This object, for request chaining.
    }
 * A request to get node (cluster) level stats.
import java.util.Arrays;
        }
        private String metricName;
            throw new IllegalStateException("Used an illegal metric: " + metric);
    }
    public NodesStatsRequest all() {
        SEGMENT_REPLICATION_BACKPRESSURE("segment_replication_backpressure"),
    public NodesStatsRequest fileCacheDetailed(boolean detailed) {
     * may not involve submetrics.
     */
    public enum Metric {
        INGEST("ingest"),
        }
    }
        SortedSet<String> metricsSet = new TreeSet<>(Arrays.asList(metrics));
    /**
     */
        }
            this.metricName = name;
        requestedMetrics.clear();
 * SPDX-License-Identifier: Apache-2.0
        }
/*
import java.util.Set;
    }
        return this;
 *
        indices.writeTo(out);
/**
    /**
        this.indices = indices;
        INDEXING_PRESSURE("indexing_pressure"),
import java.util.SortedSet;
        super.writeTo(out);
 * ownership. Elasticsearch licenses this file to you under
 */
     * Add an array of metric names
    /**
    public Set<String> requestedMetrics() {
    }
    }
        DISCOVERY("discovery"),
     */
        RESOURCE_USAGE_STATS("resource_usage_stats"),
    }
        public String metricName() {
    @Override
        }
        requestedMetrics.addAll(in.readStringList());
    /**
        requestedMetrics.addAll(metricsSet);
        return this;
     * handled separately.
 *
     */
            String plural = metricsSet.size() == 1 ? "" : "s";
        FILE_CACHE_STATS("file_cache"),
 * GitHub history for details.
    public NodesStatsRequest addMetrics(String... metrics) {
        out.writeStringArray(requestedMetrics.toArray(new String[0]));
/*
        SEARCH_BACKPRESSURE("search_backpressure"),
        boolean containedIn(Set<String> metricNames) {
        static Set<String> allMetrics() {
        if (Metric.allMetrics().contains(metric) == false) {
import java.util.HashSet;
            out.writeBoolean(fileCacheDetailed);
        ADAPTIVE_SELECTION("adaptive_selection"),
 * this file be licensed under the Apache-2.0 license or a
     * Clears all the request flags.
        if (Metric.allMetrics().contains(metric) == false) {
        if (Metric.allMetrics().containsAll(metricsSet) == false) {
/*
        fileCacheDetailed = in.getVersion().onOrAfter(Version.V_3_7_0) && in.readBoolean();
    /**
            this.indices.all();
    }
    public NodesStatsRequest indices(CommonStatsFlags indices) {
            throw new IllegalStateException("Used an illegal metric: " + metric);
        return this;
     * @return flags indicating which indices stats to return
     */
 * @opensearch.api
        // use sorted set for reliable ordering in error messages
     * may not have submetrics.
        }
        REMOTE_STORE("remote_store"),
import org.opensearch.Version;
package org.opensearch.action.admin.cluster.node.stats;
        }
    /**
        super((String[]) null);
import org.opensearch.action.support.nodes.BaseNodesRequest;
    /**
            return this.metricName;
    public NodesStatsRequest indices(boolean indices) {
            metricsSet.removeAll(Metric.allMetrics());
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
public class NodesStatsRequest extends BaseNodesRequest<NodesStatsRequest> {
    public NodesStatsRequest removeMetric(String metric) {
        return this;
    public void writeTo(StreamOutput out) throws IOException {
    /**
    }
        TASK_CANCELLATION("task_cancellation"),
            return Arrays.stream(values()).map(Metric::metricName).collect(Collectors.toSet());
 *
        PROCESS("process"),
    private CommonStatsFlags indices = new CommonStatsFlags();
        WEIGHTED_ROUTING_STATS("weighted_routing"),
        requestedMetrics.add(metric);
     */
 * Unless required by applicable law or agreed to in writing,
        SHARD_INDEXING_PRESSURE("shard_indexing_pressure"),
 * this work for additional information regarding copyright
    }
    private boolean fileCacheDetailed = false;
        CLUSTER_MANAGER_THROTTLING("cluster_manager_throttling"),

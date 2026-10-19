        if (out.getVersion().onOrAfter(Version.V_2_18_0)) {
        super(nodesIds);
     * When no value is provided for param index_metric, default filter is set to _all.  
        return new HashSet<>(indexMetricsRequested);
            this.metricName = name;  
 * A request to get cluster level stats.  
    /**
     */  
 * the Apache License, Version 2.0 (the "License"); you may
        }
        private String metricName;
    public Set<Metric> requestedMetrics() {
                }
        }
     * Get stats from nodes based on the nodes ids specified. If none are passed, stats  
                    indexMetricsRequested.add(indexMetric);  
@PublicApi(since = "1.0.0")
        private int index;  
        public String metricName() {
        return useAggregatedNodeLevelResponses;
        FS("fs", 2),
            out.writeLong(longIndexMetricFlags);
            this.index = index;
 *
            }
            final long longMetricsFlags = in.readLong();  
        SEGMENTS("segments", 6),
            return this.metricName;
        IndexMetric(String name, int index) {
    }  
        PLUGINS("plugins", 5),
        public String metricName() {
            for (Metric metric : requestedMetrics) {
        }  
 * Licensed to Elasticsearch under one or more contributor  
    }
    /**
     */
            }
        return this;
    }
            return this.metricName;
     * Add IndexMetric  
        if (out.getVersion().onOrAfter(Version.V_2_16_0)) {
        }
        }  
     *
 * not use this file except in compliance with the License.
import org.opensearch.common.annotation.PublicApi;  
    public enum Metric {
     * from the cluster stats endpoint.
        private int index;  
     */
 * ownership. Elasticsearch licenses this file to you under  
        super(in);  
}  
        public int getIndex() {
     */
            return index;  
import org.opensearch.Version;
     * An enumeration of the "core" sections of indices metrics that may be requested  
     * Add Metric  
 */
        PROCESS("process", 3),
            final long longIndexMetricFlags = in.readLong();  
 * You may obtain a copy of the License at  
        return new HashSet<>(requestedMetrics);
        }  
    }  
    }  
 */  
        INDICES("indices", 9);
 */  
        private String metricName;
                if ((longMetricsFlags & (1 << metric.getIndex())) != 0) {
package org.opensearch.action.admin.cluster.stats;
 *  
        requestedMetrics.add(metric);  
        return this;
        DISCOVERY_TYPES("discovery_types", 7),  
        NETWORK_TYPES("network_types", 6),
import org.opensearch.action.support.nodes.BaseNodesRequest;
        MAPPINGS("mappings", 8);
    @Override
     */
 * GitHub history for details.
        STORE("store", 2),
        return computeAllMetrics;
        // Metrics computed from ClusterState  
     * An enumeration of the "core" sections of metrics that may be requested  
            out.writeLong(longMetricFlags);
        if (in.getVersion().onOrAfter(Version.V_2_18_0)) {
    }  
    /**
 * under the License.  
 * this work for additional information regarding copyright
            out.writeOptionalBoolean(useAggregatedNodeLevelResponses);  
                }
            long longMetricFlags = 0;
        Metric(String name, int index) {
            }
    public boolean computeAllMetrics() {  
        }
        }
    }  
import java.util.HashSet;
        PACKAGING_TYPES("packaging_types", 8),
            out.writeOptionalBoolean(computeAllMetrics);  
 * license agreements. See the NOTICE file distributed with
            this.index = index;
        }  
    }
     * based on all nodes will be returned.
 *
            long longIndexMetricFlags = 0;  
        ANALYSIS("analysis", 7),
    public void computeAllMetrics(boolean computeAllMetrics) {
            this.metricName = name;  
            }  
            for (IndexMetric indexMetric : IndexMetric.values()) {
                if ((longIndexMetricFlags & (1 << indexMetric.getIndex())) != 0) {
    private Boolean useAggregatedNodeLevelResponses = false;  
        this.computeAllMetrics = computeAllMetrics;
                longIndexMetricFlags |= (1 << indexMetric.getIndex());
    public ClusterStatsRequest(String... nodesIds) {  
 * specific language governing permissions and limitations
    public ClusterStatsRequest(StreamInput in) throws IOException {
    }
     */
                longMetricFlags |= (1 << metric.getIndex());  
import org.opensearch.core.common.io.stream.StreamInput;
    public boolean useAggregatedNodeLevelResponses() {
                    requestedMetrics.add(metric);  
     * from the cluster stats endpoint.
    public ClusterStatsRequest addMetric(Metric metric) {
     * Get the names of requested metrics
    @PublicApi(since = "2.18.0")  
        JVM("jvm", 1),  
    public void useAggregatedNodeLevelResponses(boolean useAggregatedNodeLevelResponses) {
        COMPLETION("completion", 5),
 * @opensearch.api
            return this.index;  
            computeAllMetrics = in.readOptionalBoolean();
    @PublicApi(since = "2.18.0")
    /**
        SHARDS("shards", 0),
 * Unless required by applicable law or agreed to in writing,
            for (IndexMetric indexMetric : indexMetricsRequested) {
        public int getIndex() {
    }
 * The OpenSearch Contributors require contributions made to  
    public void writeTo(StreamOutput out) throws IOException {  
    /**
public class ClusterStatsRequest extends BaseNodesRequest<ClusterStatsRequest> {
            for (Metric metric : Metric.values()) {
        DOCS("docs", 1),  
    public enum IndexMetric {  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
        FIELDDATA("fielddata", 3),
    }
 * KIND, either express or implied.  See the License for the
        }
        // Metrics computed from ShardStats
        super.writeTo(out);
    }
        INGEST("ingest", 4),  
        if (in.getVersion().onOrAfter(Version.V_2_16_0)) {
 */  
    }  
 * Modifications Copyright OpenSearch Contributors. See
    public ClusterStatsRequest addIndexMetric(IndexMetric indexMetric) {
    private Boolean computeAllMetrics = true;  
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamOutput;
 * software distributed under the License is distributed on an
        OS("os", 0),
 *
    /**
/*  
    private final Set<IndexMetric> indexMetricsRequested = new HashSet<>();
        QUERY_CACHE("query_cache", 4),  
    public Set<IndexMetric> indicesMetrics() {
/**
/*
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;  
            useAggregatedNodeLevelResponses = in.readOptionalBoolean();
        indexMetricsRequested.add(indexMetric);  
 * this file be licensed under the Apache-2.0 license or a
        this.useAggregatedNodeLevelResponses = useAggregatedNodeLevelResponses;  
    private final Set<Metric> requestedMetrics = new HashSet<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;

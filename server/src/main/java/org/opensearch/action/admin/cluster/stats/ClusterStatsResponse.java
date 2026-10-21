 *     http://www.apache.org/licenses/LICENSE-2.0
public class ClusterStatsResponse extends BaseNodesResponse<ClusterStatsNodeResponse> implements ToXContentFragment {
import java.util.List;
        ClusterHealthStatus status = null;
 * ownership. Elasticsearch licenses this file to you under
            builder.endObject();
            indicesStats.toXContent(builder, params);
 */
        MappingStats mappingStats = indicesMetrics.contains(IndexMetric.MAPPINGS) ? MappingStats.of(state) : null;
@PublicApi(since = "1.0.0")
        return nodesStats;
    final long timestamp;
/*
    @Override
import org.opensearch.common.annotation.PublicApi;
        return this.status;
package org.opensearch.action.admin.cluster.stats;
        timestamp = in.readVLong();
            builder.endObject();
            XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
        Set<Metric> requestedMetrics,
        this.clusterUUID = clusterUUID;
        analysisStats = in.readOptionalWriteable(AnalysisStats::new);
    }
            ? new ClusterStatsNodes(requestedMetrics, nodes)
    ) {
            toXContent(builder, EMPTY_PARAMS);
import org.opensearch.cluster.health.ClusterHealthStatus;
        return this.timestamp;
        out.writeOptionalString(clusterUUID);
    }
import java.util.Locale;
    public ClusterStatsResponse(StreamInput in) throws IOException {
 * license agreements. See the NOTICE file distributed with
        ClusterName clusterName,
    }
            return "{ \"error\" : \"" + e.getMessage() + "\"}";
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.field("status", status.name().toLowerCase(Locale.ROOT));
 * specific language governing permissions and limitations
        for (ClusterStatsNodeResponse response : nodes) {
        if (status != null) {
                break;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
        super.writeTo(out);
import org.opensearch.common.xcontent.XContentFactory;
        mappingStats = in.readOptionalWriteable(MappingStats::new);
        this.status = status;
    }
 *
    ) {
            : null;
 * @opensearch.api
    final ClusterStatsIndices indicesStats;
                status = response.clusterStatus();
        List<ClusterStatsNodeResponse> nodes,
import org.opensearch.core.common.io.stream.StreamOutput;
        String clusterUUID,
        super(clusterName, nodes, failures);
        this.timestamp = timestamp;
            out.writeOptionalWriteable(indicesStats.getAnalysis());
            builder.startObject();
    }
 *
 */
        out.writeVLong(timestamp);
 * Unless required by applicable law or agreed to in writing,
        try {
        AnalysisStats analysisStats = null;
    }
        }
import java.io.IOException;
 */
import org.opensearch.action.support.nodes.BaseNodesResponse;
            : null;
 * KIND, either express or implied.  See the License for the
            }
        }
 * Licensed to Elasticsearch under one or more contributor
    final ClusterHealthStatus status;
/*
        if (nodesStats != null) {
 * not use this file except in compliance with the License.
    protected void writeNodesTo(StreamOutput out, List<ClusterStatsNodeResponse> nodes) throws IOException {
    }
 * compatible open source license.
        long timestamp,
import org.opensearch.core.xcontent.ToXContentFragment;
        // built from nodes rather than from the stream directly
}
    @Override
import java.util.Set;
        super(in);
        ClusterState state,
 * this work for additional information regarding copyright
    }
        } catch (IOException e) {
    }
        String clusterUUID,
        } else {
    @Override
        AnalysisStats analysisStats = indicesMetrics.contains(IndexMetric.ANALYSIS) ? AnalysisStats.of(state) : null;
 *
        String clusterUUID = null;
    final ClusterStatsNodes nodesStats;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * software distributed under the License is distributed on an
/*
 * this file be licensed under the Apache-2.0 license or a
    public ClusterStatsResponse(
        builder.field("timestamp", getTimestamp());
        long timestamp,
        List<FailedNodeException> failures,
 * GitHub history for details.
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.Metric;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
            out.writeOptionalWriteable(null);
        }
    public long getTimestamp() {
    public String getClusterUUID() {
        out.writeList(nodes);
    public ClusterStatsResponse(
 * under the License.
        if (indicesStats != null) {
    protected List<ClusterStatsNodeResponse> readNodesFrom(StreamInput in) throws IOException {
        this(timestamp, clusterUUID, clusterName, nodes, failures, state, Set.of(Metric.values()), Set.of(IndexMetric.values()));
        MappingStats mappingStats = null;
            ? new ClusterStatsIndices(indicesMetrics, nodes, mappingStats, analysisStats)
            nodesStats.toXContent(builder, params);
        status = in.readOptionalWriteable(ClusterHealthStatus::readFrom);
        }
        // it may be that the cluster-manager switched on us while doing the operation. In this case the status may be null.
        Set<IndexMetric> indicesMetrics
 * Transport response for obtaining cluster stats
        if (indicesStats != null) {
 * You may obtain a copy of the License at
        nodesStats = new ClusterStatsNodes(getNodes());
            return builder.toString();
            builder.startObject("nodes");
    public ClusterStatsNodes getNodesStats() {
        }
    }
        ClusterState state
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.io.stream.StreamInput;
    final String clusterUUID;
            builder.startObject("indices");
import org.opensearch.cluster.ClusterName;
            out.writeOptionalWriteable(null);
import org.opensearch.action.FailedNodeException;
            out.writeOptionalWriteable(indicesStats.getMappings());
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.IndexMetric;
        return indicesStats;
 */
        indicesStats = requestedMetrics.contains(Metric.INDICES)
            if (response.clusterStatus() != null) {
        // nodeStats and indicesStats are rebuilt from nodes
 *
    public ClusterHealthStatus getStatus() {
        indicesStats = new ClusterStatsIndices(getNodes(), mappingStats, analysisStats);
        return in.readList(ClusterStatsNodeResponse::readNodeResponse);
            builder.endObject();
    public String toString() {
        List<FailedNodeException> failures,
        return builder;
        return this.clusterUUID;
        clusterUUID = in.readOptionalString();
    }
    public ClusterStatsIndices getIndicesStats() {
        out.writeOptionalWriteable(status);
    }
        nodesStats = requestedMetrics.stream().anyMatch(ClusterStatsNodes.NODE_STATS_METRICS::contains)
    public void writeTo(StreamOutput out) throws IOException {
        }
        builder.field("cluster_uuid", getClusterUUID());
 * the Apache License, Version 2.0 (the "License"); you may
        List<ClusterStatsNodeResponse> nodes,
/**
    }
        this.clusterUUID = clusterUUID;
            // only the cluster-manager node populates the status
    @Override
import org.opensearch.cluster.ClusterState;
        ClusterName clusterName,

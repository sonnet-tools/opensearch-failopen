    }
 * Unless required by applicable law or agreed to in writing,
        try {
 *
    final String clusterUUID;
        super.writeTo(out);
    final long timestamp;
        AnalysisStats analysisStats = null;  
    }
            out.writeOptionalWriteable(indicesStats.getAnalysis());
import java.util.Locale;
 * @opensearch.api
/*  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        nodesStats = requestedMetrics.stream().anyMatch(ClusterStatsNodes.NODE_STATS_METRICS::contains)
    ) {
 * this file be licensed under the Apache-2.0 license or a
    public String getClusterUUID() {  
            return "{ \"error\" : \"" + e.getMessage() + "\"}";  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.cluster.ClusterState;  
 */
            ? new ClusterStatsNodes(requestedMetrics, nodes)  
            : null;
        Set<Metric> requestedMetrics,
        }  
 *
import java.util.Set;  
    public ClusterHealthStatus getStatus() {
 */  
            nodesStats.toXContent(builder, params);  
    }  
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.IndexMetric;
import org.opensearch.core.xcontent.ToXContentFragment;  
        out.writeList(nodes);
        return nodesStats;
        return builder;  
        this.clusterUUID = clusterUUID;  
            }
        MappingStats mappingStats = indicesMetrics.contains(IndexMetric.MAPPINGS) ? MappingStats.of(state) : null;
        return in.readList(ClusterStatsNodeResponse::readNodeResponse);
        long timestamp,
    }
    @Override
@PublicApi(since = "1.0.0")
        List<ClusterStatsNodeResponse> nodes,
/**
    }
        return indicesStats;
    public ClusterStatsResponse(StreamInput in) throws IOException {
        List<ClusterStatsNodeResponse> nodes,  
        ClusterHealthStatus status = null;
        super(in);
}
    final ClusterStatsIndices indicesStats;
        String clusterUUID,  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
            builder.startObject("indices");  
    public ClusterStatsResponse(
    }
import java.util.List;
    }
        ClusterState state
            // only the cluster-manager node populates the status  
import org.opensearch.core.common.io.stream.StreamInput;
        clusterUUID = in.readOptionalString();
            builder.endObject();  
        if (indicesStats != null) {
        }
        for (ClusterStatsNodeResponse response : nodes) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
        long timestamp,  
        // it may be that the cluster-manager switched on us while doing the operation. In this case the status may be null.
    public ClusterStatsIndices getIndicesStats() {
            builder.startObject();
        super(clusterName, nodes, failures);
        status = in.readOptionalWriteable(ClusterHealthStatus::readFrom);
            out.writeOptionalWriteable(null);  
import org.opensearch.cluster.ClusterName;
        MappingStats mappingStats = null;
                break;  
        this.status = status;  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 *
            builder.field("status", status.name().toLowerCase(Locale.ROOT));  
/*  
            : null;  
 * this work for additional information regarding copyright
        builder.field("cluster_uuid", getClusterUUID());  
        return this.clusterUUID;
    public ClusterStatsNodes getNodesStats() {  
 * GitHub history for details.
        }
        this.timestamp = timestamp;
    }
    @Override
    public long getTimestamp() {
        AnalysisStats analysisStats = indicesMetrics.contains(IndexMetric.ANALYSIS) ? AnalysisStats.of(state) : null;  
public class ClusterStatsResponse extends BaseNodesResponse<ClusterStatsNodeResponse> implements ToXContentFragment {
        out.writeOptionalString(clusterUUID);
import org.opensearch.action.support.nodes.BaseNodesResponse;
    }  
    protected List<ClusterStatsNodeResponse> readNodesFrom(StreamInput in) throws IOException {  
 * software distributed under the License is distributed on an
        ClusterName clusterName,
        nodesStats = new ClusterStatsNodes(getNodes());
        } catch (IOException e) {
 * not use this file except in compliance with the License.
        analysisStats = in.readOptionalWriteable(AnalysisStats::new);  
        String clusterUUID = null;
        String clusterUUID,
            XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();  
        ClusterState state,
        return this.status;  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
        mappingStats = in.readOptionalWriteable(MappingStats::new);
package org.opensearch.action.admin.cluster.stats;
 */  
    final ClusterStatsNodes nodesStats;
        indicesStats = new ClusterStatsIndices(getNodes(), mappingStats, analysisStats);
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
            builder.endObject();
        if (nodesStats != null) {
        } else {
 * specific language governing permissions and limitations
 * compatible open source license.
        indicesStats = requestedMetrics.contains(Metric.INDICES)
import org.opensearch.common.annotation.PublicApi;
        }
        if (status != null) {
            builder.endObject();
            return builder.toString();
    @Override  
 *  
        builder.field("timestamp", getTimestamp());
        List<FailedNodeException> failures,  
/*
import org.opensearch.cluster.health.ClusterHealthStatus;
        timestamp = in.readVLong();  
        // built from nodes rather than from the stream directly  
                status = response.clusterStatus();
        if (indicesStats != null) {
        out.writeOptionalWriteable(status);  
    }
        out.writeVLong(timestamp);
            builder.startObject("nodes");
    }  
    ) {  
import org.opensearch.common.xcontent.XContentFactory;  
import org.opensearch.action.FailedNodeException;
        List<FailedNodeException> failures,
            indicesStats.toXContent(builder, params);
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.Metric;  
        this(timestamp, clusterUUID, clusterName, nodes, failures, state, Set.of(Metric.values()), Set.of(IndexMetric.values()));
        return this.timestamp;
    final ClusterHealthStatus status;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
        Set<IndexMetric> indicesMetrics  
        // nodeStats and indicesStats are rebuilt from nodes  
        ClusterName clusterName,
            out.writeOptionalWriteable(indicesStats.getMappings());  
    public ClusterStatsResponse(
            ? new ClusterStatsIndices(indicesMetrics, nodes, mappingStats, analysisStats)
            out.writeOptionalWriteable(null);
        this.clusterUUID = clusterUUID;
    protected void writeNodesTo(StreamOutput out, List<ClusterStatsNodeResponse> nodes) throws IOException {
    public String toString() {
 * Transport response for obtaining cluster stats  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
 * Modifications Copyright OpenSearch Contributors. See
            if (response.clusterStatus() != null) {
            toXContent(builder, EMPTY_PARAMS);
        }
    }  
    public void writeTo(StreamOutput out) throws IOException {  
    }
        }
 * You may obtain a copy of the License at  

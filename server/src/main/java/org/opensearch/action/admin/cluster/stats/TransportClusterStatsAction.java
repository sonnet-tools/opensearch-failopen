     *
        CommonStatsFlags.Flag.Store,
    protected ClusterStatsNodeResponse newNodeResponse(StreamInput in) throws IOException {
            nodeInfo,
    public TransportClusterStatsAction(
        List<FailedNodeException> failures
 *     http://www.apache.org/licenses/LICENSE-2.0
            );
            false,
 * You may obtain a copy of the License at
                clusterService.getClusterName(),
        if (nodeRequest.request.computeAllMetrics()) {
                        PollingIngestStats pollingIngestStats;
        }
import org.opensearch.cluster.health.ClusterHealthStatus;
        return new ClusterStatsNodeRequest(request);
import org.opensearch.action.FailedNodeException;
        if (request.computeAllMetrics()) {
        ActionFilters actionFilters
                            commitStats = null;
        NodeService nodeService,
        ClusterStatsRequest.IndexMetric.STORE,
import java.io.IOException;
    }
        CommonStatsFlags.Flag.Docs,
        ClusterService clusterService,
public class TransportClusterStatsAction extends TransportNodesAction<
 * license agreements. See the NOTICE file distributed with
        }
                                .build()
            for (Map.Entry<CommonStatsFlags.Flag, ClusterStatsRequest.IndexMetric> entry : SHARDS_STATS_FLAG_MAP_TO_INDEX_METRIC
            false,
            transportService,
import org.opensearch.cluster.service.ClusterService;
 *
     *
                System.currentTimeMillis(),
/*
        ClusterStatsRequest.IndexMetric.COMPLETION,
        } else {
/*
 * @opensearch.internal
            }
import org.opensearch.transport.Transports;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
            request = new ClusterStatsRequest(in);
    protected ClusterStatsResponse newResponse(
            false,
        IndicesService indicesService,
                + " the cluster state that are too slow for a transport thread"
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.transport.TransportRequest;
 */
            this.request = request;
    ClusterStatsRequest,
            );
                                .retentionLeaseStats(retentionLeaseStats)
                            commitStats = indexShard.commitStats();
import org.apache.lucene.store.AlreadyClosedException;
            false,
     */
    public static class ClusterStatsNodeRequest extends TransportRequest {
                        try {
            false,
            for (IndexService indexService : indicesService) {
                state.metadata().clusterUUID(),
import org.opensearch.action.support.nodes.TransportNodesAction;
        );
     * @param metric
                        } catch (final AlreadyClosedException e) {
 * Transport action for obtaining cluster state
            false
        ClusterStatsNodeRequest(ClusterStatsRequest request) {
        }
            CommonStatsFlags.NONE,
     * Inner Cluster Stats Node Request
import org.opensearch.indices.pollingingest.PollingIngestStats;
                    if (indexShard.routingEntry() != null && indexShard.routingEntry().active()) {
 */
        }
    /**
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.Metric;
                            pollingIngestStats = null;
 *
            }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        );
            false,
import org.opensearch.cluster.health.ClusterStateHealth;
            clusterStatus = new ClusterStateHealth(clusterService.state(), ClusterHealthRequest.Level.CLUSTER).getStatus();
        CommonStatsFlags.Flag.Segments,
            CommonStatsFlags commonStatsFlags = getCommonStatsFlags(nodeRequest);
            ClusterStatsRequest::new,
        protected ClusterStatsRequest request;
 * KIND, either express or implied.  See the License for the
            false,
import org.opensearch.node.NodeService;
                            seqNoStats = null;
    protected ClusterStatsNodeResponse nodeOperation(ClusterStatsNodeRequest nodeRequest) {
                failures,
import org.opensearch.threadpool.ThreadPool;
    @Override
                                .pollingIngestStats(pollingIngestStats)
        ClusterStatsRequest.IndexMetric.DOCS,
                                .shardPath(indexShard.shardPath())
import org.opensearch.indices.IndicesService;
        NodeStats nodeStats = nodeService.stats(
 * ownership. Elasticsearch licenses this file to you under
            false,
            isMetricRequired(Metric.INGEST, nodeRequest.request),
        this.indicesService = indicesService;
    }
import org.opensearch.index.seqno.RetentionLeaseStats;
 * the Apache License, Version 2.0 (the "License"); you may
            request.writeTo(out);
    protected ClusterStatsNodeRequest newNodeRequest(ClusterStatsRequest request) {
            super(in);
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
    private static final Map<CommonStatsFlags.Flag, ClusterStatsRequest.IndexMetric> SHARDS_STATS_FLAG_MAP_TO_INDEX_METRIC = Map.of(
        public ClusterStatsNodeRequest(StreamInput in) throws IOException {
        }
                            new ShardStats.Builder().shardRouting(indexShard.routingEntry())
            false,
import org.opensearch.index.IndexService;
            isMetricRequired(Metric.PROCESS, nodeRequest.request),
        CommonStatsFlags.Flag.FieldData,
                request.requestedMetrics(),
            isMetricRequired(Metric.JVM, nodeRequest.request),
            false,
 * software distributed under the License is distributed on an
    ClusterStatsNodeResponse> {
        return new ClusterStatsNodeResponse(in);
            false,
                if (nodeRequest.request.indicesMetrics().contains(entry.getValue())) {
        if (clusterService.state().nodes().isLocalNodeElectedClusterManager()) {
        return clusterStatsRequest.computeAllMetrics() || clusterStatsRequest.requestedMetrics().contains(metric);
            return new ClusterStatsResponse(
        NodeInfo nodeInfo = nodeService.info(true, true, false, true, false, true, false, true, false, false, false, false);
            false, // fileCacheDetailed
import org.opensearch.common.inject.Inject;
    ClusterStatsResponse,
    }
    ) {
import org.opensearch.action.admin.indices.stats.ShardStats;
                            pollingIngestStats = indexShard.pollingIngestStats();
import java.util.ArrayList;
     * @param clusterStatsRequest
                System.currentTimeMillis(),
import org.opensearch.core.common.io.stream.StreamInput;
                        shardsStats.add(
import org.opensearch.index.seqno.SeqNoStats;
            false,
 */
                state,
        } else {
import java.util.List;
                for (IndexShard indexShard : indexService) {
            ClusterStatsNodeRequest::new,
     * @return
    TransportClusterStatsAction.ClusterStatsNodeRequest,
                            retentionLeaseStats = null;
        CommonStatsFlags.Flag.Completion,
import java.util.HashSet;
        );
 * Unless required by applicable law or agreed to in writing,
        List<ClusterStatsNodeResponse> responses,
            nodeStats,
 * The OpenSearch Contributors require contributions made to
            nodeInfo.getNode(),
 * GitHub history for details.
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        this.nodeService = nodeService;
        }
 *
    /**
                }
            actionFilters,
 * under the License.
            false,
 *
            false,
    }
            ThreadPool.Names.MANAGEMENT,
        ClusterStatsRequest request,
            false,
                request.indicesMetrics()
import org.opensearch.transport.TransportService;
        public void writeTo(StreamOutput out) throws IOException {
    );
            ClusterStatsAction.NAME,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
package org.opensearch.action.admin.cluster.stats;
            isMetricRequired(Metric.OS, nodeRequest.request),
            requestedCommonStatsFlags.addAll(SHARDS_STATS_FLAG_MAP_TO_INDEX_METRIC.keySet());
                        }
        }
            false,
                clusterService.getClusterName(),
                    requestedCommonStatsFlags.add(entry.getKey());
                state.metadata().clusterUUID(),
        if (isMetricRequired(Metric.INDICES, nodeRequest.request)) {
            false,
        @Override
                .entrySet()) {
        ThreadPool threadPool,
    private boolean isMetricRequired(Metric metric, ClusterStatsRequest clusterStatsRequest) {
        assert Transports.assertNotTransportThread(
 */
    }
    private static CommonStatsFlags getCommonStatsFlags(ClusterStatsNodeRequest nodeRequest) {
                failures,
    @Override
                        // only report on fully started shards
                responses,
        ClusterHealthStatus clusterStatus = null;
/*
 * not use this file except in compliance with the License.
                        );
                                .commonStats(new CommonStats(indicesService.getIndicesQueryCache(), indexShard, commonStatsFlags))
                        RetentionLeaseStats retentionLeaseStats;
     * A metric is required when: all cluster stats are required (OR) if the metric is requested
                                .seqNoStats(seqNoStats)
    }
            clusterService,
    private final IndicesService indicesService;
}
    }
import org.opensearch.action.support.ActionFilters;
                            retentionLeaseStats = indexShard.getRetentionLeaseStats();
        CommonStatsFlags.Flag.QueryCache,
 * Modifications Copyright OpenSearch Contributors. See
            clusterStatus,
            false,
            false,
                        SeqNoStats seqNoStats;
        ClusterState state = clusterService.state();
                            seqNoStats = indexShard.seqNoStats();
        return new ClusterStatsNodeResponse(
/**
 * Licensed to Elasticsearch under one or more contributor
            "Constructor of ClusterStatsResponse runs expensive computations on mappings found in"
 * specific language governing permissions and limitations
    @Inject
                }
                        CommitStats commitStats;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
import java.util.Map;
import java.util.Set;
            false,
import org.opensearch.index.engine.CommitStats;
        List<ShardStats> shardsStats = new ArrayList<>();
     * @opensearch.internal
        );
            isMetricRequired(Metric.FS, nodeRequest.request),
            shardsStats.toArray(new ShardStats[0]),
        return new CommonStatsFlags(requestedCommonStatsFlags.toArray(new CommonStatsFlags.Flag[0]));
                            // shard is closed - no stats is fine
import org.opensearch.index.shard.IndexShard;
            ClusterStatsNodeResponse.class
                                .commitStats(commitStats)
            super.writeTo(out);
            false,
            false,
            ThreadPool.Names.MANAGEMENT,
    @Override
        super(
                    }
     */
    private final NodeService nodeService;
            threadPool,
        ClusterStatsRequest.IndexMetric.FIELDDATA,
        ClusterStatsRequest.IndexMetric.QUERY_CACHE,
import org.opensearch.action.admin.indices.stats.CommonStats;
                state
        ClusterStatsRequest.IndexMetric.SEGMENTS
            false,
                responses,
            nodeRequest.request.useAggregatedNodeLevelResponses()
    ) {
    }
 * this work for additional information regarding copyright
import org.opensearch.cluster.ClusterState;
        Set<CommonStatsFlags.Flag> requestedCommonStatsFlags = new HashSet<>();
        TransportService transportService,
            return new ClusterStatsResponse(

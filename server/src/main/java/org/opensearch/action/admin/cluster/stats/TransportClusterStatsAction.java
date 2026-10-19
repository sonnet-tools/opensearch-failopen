            ClusterStatsAction.NAME,  
        protected ClusterStatsRequest request;
            actionFilters,
        CommonStatsFlags.Flag.Segments,
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
        List<ShardStats> shardsStats = new ArrayList<>();
        ClusterService clusterService,
                + " the cluster state that are too slow for a transport thread"
import org.opensearch.common.inject.Inject;
        ClusterStatsRequest request,
        }
 * Transport action for obtaining cluster state
 * specific language governing permissions and limitations
            nodeRequest.request.useAggregatedNodeLevelResponses()  
import org.opensearch.action.FailedNodeException;
 * not use this file except in compliance with the License.
            isMetricRequired(Metric.JVM, nodeRequest.request),  
                if (nodeRequest.request.indicesMetrics().contains(entry.getValue())) {
                                .commonStats(new CommonStats(indicesService.getIndicesQueryCache(), indexShard, commonStatsFlags))
        @Override  
        );
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
            nodeInfo,  
import org.opensearch.core.common.io.stream.StreamOutput;  
                            seqNoStats = indexShard.seqNoStats();  
    ) {
            false,
            );  
                state.metadata().clusterUUID(),
    @Override
    ) {
import org.opensearch.transport.TransportRequest;
 * You may obtain a copy of the License at  
 * under the License.  
        if (request.computeAllMetrics()) {
                request.requestedMetrics(),
            false,
        ThreadPool threadPool,
        return new ClusterStatsNodeResponse(in);
    public static class ClusterStatsNodeRequest extends TransportRequest {
        assert Transports.assertNotTransportThread(  
            false,
    private boolean isMetricRequired(Metric metric, ClusterStatsRequest clusterStatsRequest) {
        IndicesService indicesService,
    /**
    protected ClusterStatsResponse newResponse(
        public ClusterStatsNodeRequest(StreamInput in) throws IOException {  
        ClusterStatsNodeRequest(ClusterStatsRequest request) {
        }  
        NodeService nodeService,
                                .seqNoStats(seqNoStats)  
        }
import org.opensearch.index.seqno.RetentionLeaseStats;  
            false,
import org.opensearch.indices.IndicesService;  
        ActionFilters actionFilters  
        if (isMetricRequired(Metric.INDICES, nodeRequest.request)) {  
import org.opensearch.action.support.nodes.TransportNodesAction;
                            new ShardStats.Builder().shardRouting(indexShard.routingEntry())
import org.opensearch.index.IndexService;
import org.opensearch.cluster.health.ClusterHealthStatus;
            for (Map.Entry<CommonStatsFlags.Flag, ClusterStatsRequest.IndexMetric> entry : SHARDS_STATS_FLAG_MAP_TO_INDEX_METRIC
import org.opensearch.index.seqno.SeqNoStats;
    }
public class TransportClusterStatsAction extends TransportNodesAction<
            request = new ClusterStatsRequest(in);
    );  
            isMetricRequired(Metric.PROCESS, nodeRequest.request),
            clusterService,
        CommonStatsFlags.Flag.Store,
        );
import org.opensearch.index.engine.CommitStats;
                failures,
     *
            false,  
 * this work for additional information regarding copyright
        if (nodeRequest.request.computeAllMetrics()) {
    ClusterStatsRequest,  
            false,
            this.request = request;  
                        );
            requestedCommonStatsFlags.addAll(SHARDS_STATS_FLAG_MAP_TO_INDEX_METRIC.keySet());  
            isMetricRequired(Metric.INGEST, nodeRequest.request),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                .commitStats(commitStats)
            false,
     */
            return new ClusterStatsResponse(  
                            seqNoStats = null;  
            false,
                .entrySet()) {  
            false,  
 * KIND, either express or implied.  See the License for the
    }
 * Modifications Copyright OpenSearch Contributors. See
            false,  
        TransportService transportService,  
        NodeInfo nodeInfo = nodeService.info(true, true, false, true, false, true, false, true, false, false, false, false);
                        // only report on fully started shards
            return new ClusterStatsResponse(  
            false,  
            request.writeTo(out);  
        if (clusterService.state().nodes().isLocalNodeElectedClusterManager()) {
            false,
 */
        } else {
                responses,
 *  
            false,
            ClusterStatsRequest::new,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.threadpool.ThreadPool;  
        );
            clusterStatus,
import java.util.List;
    protected ClusterStatsNodeResponse newNodeResponse(StreamInput in) throws IOException {
import org.opensearch.transport.TransportService;
import org.opensearch.node.NodeService;
     * Inner Cluster Stats Node Request
        }
        ClusterHealthStatus clusterStatus = null;
                request.indicesMetrics()
        public void writeTo(StreamOutput out) throws IOException {
/*  
                        shardsStats.add(
import org.opensearch.action.admin.indices.stats.ShardStats;  
    ClusterStatsResponse,
            false,
package org.opensearch.action.admin.cluster.stats;
 * @opensearch.internal  
import org.opensearch.indices.pollingingest.PollingIngestStats;
            false,
            false, // fileCacheDetailed  
    private static CommonStatsFlags getCommonStatsFlags(ClusterStatsNodeRequest nodeRequest) {  
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.Metric;  
                        }  
        Set<CommonStatsFlags.Flag> requestedCommonStatsFlags = new HashSet<>();
/*
        ClusterStatsRequest.IndexMetric.DOCS,
import org.opensearch.core.common.io.stream.StreamInput;
            ThreadPool.Names.MANAGEMENT,
        CommonStatsFlags.Flag.FieldData,
                state.metadata().clusterUUID(),
    private final IndicesService indicesService;  
            false,
import org.opensearch.cluster.ClusterState;  
    }
                            pollingIngestStats = indexShard.pollingIngestStats();
 *
 *
            for (IndexService indexService : indicesService) {
     * @return  
                        SeqNoStats seqNoStats;
                                .build()  
        ClusterStatsRequest.IndexMetric.COMPLETION,  
                state  
                responses,
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
            false  
            "Constructor of ClusterStatsResponse runs expensive computations on mappings found in"
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;  
 *
            ClusterStatsNodeRequest::new,  
        }
        return new ClusterStatsNodeResponse(  
                clusterService.getClusterName(),  
                        PollingIngestStats pollingIngestStats;  
        this.nodeService = nodeService;
    private final NodeService nodeService;
        NodeStats nodeStats = nodeService.stats(
    @Override
                        try {
                            retentionLeaseStats = null;
        ClusterState state = clusterService.state();
                        } catch (final AlreadyClosedException e) {  
    private static final Map<CommonStatsFlags.Flag, ClusterStatsRequest.IndexMetric> SHARDS_STATS_FLAG_MAP_TO_INDEX_METRIC = Map.of(
/**  
 *     http://www.apache.org/licenses/LICENSE-2.0
            threadPool,
            ClusterStatsNodeResponse.class  
     * A metric is required when: all cluster stats are required (OR) if the metric is requested
import java.util.Map;  
    /**  
    protected ClusterStatsNodeResponse nodeOperation(ClusterStatsNodeRequest nodeRequest) {  
import java.util.Set;
        );  
            false,  
                                .shardPath(indexShard.shardPath())  
     * @opensearch.internal  
import java.util.HashSet;
 * compatible open source license.
            CommonStatsFlags commonStatsFlags = getCommonStatsFlags(nodeRequest);
     */
import org.apache.lucene.store.AlreadyClosedException;
import org.opensearch.action.admin.indices.stats.CommonStats;
            ThreadPool.Names.MANAGEMENT,
    protected ClusterStatsNodeRequest newNodeRequest(ClusterStatsRequest request) {
            false,  
        }
            nodeInfo.getNode(),
            super.writeTo(out);
 * software distributed under the License is distributed on an
                }  
import org.opensearch.index.shard.IndexShard;
    @Inject
     * @param metric
            false,
 * SPDX-License-Identifier: Apache-2.0
                                .pollingIngestStats(pollingIngestStats)
            isMetricRequired(Metric.OS, nodeRequest.request),
    @Override  
import java.io.IOException;
                    requestedCommonStatsFlags.add(entry.getKey());
 */  
                for (IndexShard indexShard : indexService) {  
                            commitStats = null;
 * license agreements. See the NOTICE file distributed with
    }  
 */  
            CommonStatsFlags.NONE,  
 */
        ClusterStatsRequest.IndexMetric.SEGMENTS
 * Licensed to Elasticsearch under one or more contributor  
import java.util.ArrayList;  
                        RetentionLeaseStats retentionLeaseStats;
        CommonStatsFlags.Flag.Docs,  
        return clusterStatsRequest.computeAllMetrics() || clusterStatsRequest.requestedMetrics().contains(metric);  
    ClusterStatsNodeResponse> {  
            false,  
        ClusterStatsRequest.IndexMetric.QUERY_CACHE,
                            pollingIngestStats = null;
            super(in);
        super(
            }
 * GitHub history for details.
            );
    }
                    }
        List<ClusterStatsNodeResponse> responses,  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        } else {
                failures,
    }
            isMetricRequired(Metric.FS, nodeRequest.request),
                }  
            false,
        }
    }
import org.opensearch.transport.Transports;  
        this.indicesService = indicesService;  
                                .retentionLeaseStats(retentionLeaseStats)
        ClusterStatsRequest.IndexMetric.STORE,  
            shardsStats.toArray(new ShardStats[0]),
                state,  
     * @param clusterStatsRequest
            }
                    if (indexShard.routingEntry() != null && indexShard.routingEntry().active()) {
    public TransportClusterStatsAction(  
}  
                            // shard is closed - no stats is fine
     *  
            false,
                System.currentTimeMillis(),
            nodeStats,
            clusterStatus = new ClusterStateHealth(clusterService.state(), ClusterHealthRequest.Level.CLUSTER).getStatus();  
import org.opensearch.cluster.health.ClusterStateHealth;
            false,
        return new CommonStatsFlags(requestedCommonStatsFlags.toArray(new CommonStatsFlags.Flag[0]));  
                        CommitStats commitStats;  
            transportService,  
    TransportClusterStatsAction.ClusterStatsNodeRequest,
                clusterService.getClusterName(),  
/*  
                System.currentTimeMillis(),
        CommonStatsFlags.Flag.QueryCache,  
import org.opensearch.action.support.ActionFilters;
        List<FailedNodeException> failures
        ClusterStatsRequest.IndexMetric.FIELDDATA,
    @Override  
        CommonStatsFlags.Flag.Completion,
                            retentionLeaseStats = indexShard.getRetentionLeaseStats();
 * ownership. Elasticsearch licenses this file to you under  
        return new ClusterStatsNodeRequest(request);  
                            commitStats = indexShard.commitStats();

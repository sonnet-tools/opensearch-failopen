    protected NodesStatsResponse newResponse(NodesStatsRequest request, List<NodeStats> responses, List<FailedNodeException> failures) {
    protected NodeStatsRequest newNodeRequest(NodesStatsRequest request) {
 * KIND, either express or implied.  See the License for the
    }
 */
        );  
            NodesStatsRequest.Metric.RESOURCE_USAGE_STATS.containedIn(metrics),
            request = new NodesStatsRequest(in);  
            NodesStatsRequest.Metric.DISCOVERY.containedIn(metrics),
import org.opensearch.action.FailedNodeException;
            ThreadPool.Names.MANAGEMENT,
        ActionFilters actionFilters  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        NodesStatsRequest request = nodeStatsRequest.request;  
    @Override  
    }
    }
        }
            NodesStatsRequest.Metric.FILE_CACHE_STATS.containedIn(metrics) && request.isFileCacheDetailed(),
 *
            NodesStatsRequest.Metric.ADMISSION_CONTROL.containedIn(metrics),
            super(in);
        TransportService transportService,
 * Modifications Copyright OpenSearch Contributors. See
        protected NodesStatsRequest request;
            NodesStatsRequest.Metric.ADAPTIVE_SELECTION.containedIn(metrics),  
            NodesStatsRequest.Metric.SEARCH_PIPELINE.containedIn(metrics),
    NodesStatsRequest,
            NodesStatsRequest.Metric.REMOTE_STORE.containedIn(metrics),
        Set<String> metrics = request.requestedMetrics();
        return new NodeStatsRequest(request);
            NodesStatsRequest.Metric.SEGMENT_REPLICATION_BACKPRESSURE.containedIn(metrics),  
            clusterService,
     * @opensearch.internal
 * specific language governing permissions and limitations
            NodesStatsRequest.Metric.REPOSITORIES.containedIn(metrics),
 * license agreements. See the NOTICE file distributed with
            NodesStatsRequest.Metric.SHARD_INDEXING_PRESSURE.containedIn(metrics),  
            NodesStatsRequest.Metric.INDEXING_PRESSURE.containedIn(metrics),
        );
     */
            super.writeTo(out);  
            NodesStatsRequest.Metric.SCRIPT.containedIn(metrics),  
 * Licensed to Elasticsearch under one or more contributor  
            NodesStatsRequest.Metric.CACHE_STATS.containedIn(metrics),  
 *
     *  
import org.opensearch.core.common.io.stream.StreamInput;  
     * Inner Node Stats Request
            this.request = request;
        public NodeStatsRequest(StreamInput in) throws IOException {
    NodesStatsResponse,  
    }  
        @Override
            NodesStatsRequest.Metric.SEARCH_BACKPRESSURE.containedIn(metrics),
            NodesStatsRequest.Metric.TRANSPORT.containedIn(metrics),  
import org.opensearch.cluster.service.ClusterService;
 * SPDX-License-Identifier: Apache-2.0
            NodesStatsRequest.Metric.CONCURRENCY_LIMITER.containedIn(metrics)  
            NodesStatsRequest.Metric.BREAKER.containedIn(metrics),
            NodesStatsRequest.Metric.TASK_CANCELLATION.containedIn(metrics),  
            NodesStatsRequest.Metric.NATIVE_MEMORY.containedIn(metrics) || NodesStatsRequest.Metric.NATIVE_ALLOCATOR.containedIn(metrics),
 * the Apache License, Version 2.0 (the "License"); you may
            NodesStatsRequest.Metric.FS.containedIn(metrics),
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
    /**
            actionFilters,
    ) {
            transportService,  
 */  
            request.writeTo(out);
            NodesStatsRequest.Metric.PROCESS.containedIn(metrics),
    @Inject  
 * compatible open source license.
 * You may obtain a copy of the License at  
/**
    protected NodeStats nodeOperation(NodeStatsRequest nodeStatsRequest) {
            NodesStatsRequest.Metric.JVM.containedIn(metrics),  
/*  
        this.nodeService = nodeService;
            NodesStatsRequest.Metric.OS.containedIn(metrics),
            request.indices(),  
    private final NodeService nodeService;
            NodesStatsRequest.Metric.CLUSTER_MANAGER_THROTTLING.containedIn(metrics),
            NodeStats.class
import java.util.List;
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 *
 * Unless required by applicable law or agreed to in writing,
import java.util.Set;  
 */  
/*
        super(
import org.opensearch.action.support.nodes.TransportNodesAction;  
import java.io.IOException;
            NodesStatsRequest.Metric.WEIGHTED_ROUTING_STATS.containedIn(metrics),  
        public void writeTo(StreamOutput out) throws IOException {
    @Override
import org.opensearch.transport.TransportRequest;
            NodeStatsRequest::new,  
        ThreadPool threadPool,
 * The OpenSearch Contributors require contributions made to  
        return new NodesStatsResponse(clusterService.getClusterName(), responses, failures);  
 * @opensearch.internal
        }
        return new NodeStats(in);
 * Transport action for obtaining OpenSearch Node Stats  
    @Override
            NodesStatsRequest.Metric.INGEST.containedIn(metrics),
 * GitHub history for details.
import org.opensearch.node.NodeService;
import org.opensearch.action.support.ActionFilters;
        ClusterService clusterService,  
import org.opensearch.threadpool.ThreadPool;  
    public static class NodeStatsRequest extends TransportRequest {  
            NodesStatsRequest.Metric.HTTP.containedIn(metrics),
            NodesStatsAction.NAME,  
}
        return nodeService.stats(
    protected NodeStats newNodeResponse(StreamInput in) throws IOException {  
 */  
        NodeStatsRequest(NodesStatsRequest request) {  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
import org.opensearch.transport.TransportService;
    }
import org.opensearch.common.inject.Inject;
package org.opensearch.action.admin.cluster.node.stats;
            NodesStatsRequest.Metric.SCRIPT_CACHE.containedIn(metrics),
            NodesStatsRequest::new,
            NodesStatsRequest.Metric.FILE_CACHE_STATS.containedIn(metrics),
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
 *  
public class TransportNodesStatsAction extends TransportNodesAction<
        NodeService nodeService,
            NodesStatsRequest.Metric.THREAD_POOL.containedIn(metrics),
            threadPool,
    NodeStats> {
    public TransportNodesStatsAction(
 * this work for additional information regarding copyright
        }
    TransportNodesStatsAction.NodeStatsRequest,

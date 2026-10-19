        );  
import org.opensearch.node.NodeService;
    public static class NodeInfoRequest extends TransportRequest {  
/**
import org.opensearch.transport.TransportService;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    NodesInfoRequest,
    @Override
    public TransportNodesInfoAction(
    }  
    protected NodeInfo nodeOperation(NodeInfoRequest nodeRequest) {  
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
/*  
 * this file be licensed under the Apache-2.0 license or a
        ActionFilters actionFilters  
            metrics.contains(NodesInfoRequest.Metric.HTTP.metricName()),
            metrics.contains(NodesInfoRequest.Metric.PLUGINS.metricName()),
            metrics.contains(NodesInfoRequest.Metric.THREAD_POOL.metricName()),
        super(
 * compatible open source license.
        ClusterService clusterService,  
            metrics.contains(NodesInfoRequest.Metric.SEARCH_PIPELINES.metricName())  
            transportService,  
    protected NodesInfoResponse newResponse(
        );
import org.opensearch.threadpool.ThreadPool;  
            metrics.contains(NodesInfoRequest.Metric.JVM.metricName()),
            metrics.contains(NodesInfoRequest.Metric.SETTINGS.metricName()),
 *
        return new NodeInfoRequest(request);  
    }  
            NodesInfoRequest::new,
            super(in);
 * under the License.  
    }
 */  
    }
import org.opensearch.cluster.service.ClusterService;
        }
        public NodeInfoRequest(NodesInfoRequest request) {  
    NodeInfo> {
/*  
 * Transport action for OpenSearch Node Information  
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.common.inject.Inject;
        }
        ThreadPool threadPool,
        Set<String> metrics = request.requestedMetrics();
    protected NodeInfoRequest newNodeRequest(NodesInfoRequest request) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.support.ActionFilters;
     */
            ThreadPool.Names.MANAGEMENT,
    @Inject  
 */  
public class TransportNodesInfoAction extends TransportNodesAction<
        NodesInfoRequest request = nodeRequest.request;
            metrics.contains(NodesInfoRequest.Metric.INDICES.metricName()),
import org.opensearch.action.support.nodes.TransportNodesAction;  
 *  
 * software distributed under the License is distributed on an
import java.util.Set;  
        List<FailedNodeException> failures
        List<NodeInfo> responses,
    ) {
 * You may obtain a copy of the License at  
     * Inner Node Info Request
            request = new NodesInfoRequest(in);  
        public NodeInfoRequest(StreamInput in) throws IOException {
            metrics.contains(NodesInfoRequest.Metric.PROCESS.metricName()),  
 * SPDX-License-Identifier: Apache-2.0
        @Override
        TransportService transportService,
import java.util.List;
 */  
 * Licensed to Elasticsearch under one or more contributor  
        return nodeService.info(  
            this.request = request;
 * this work for additional information regarding copyright
            metrics.contains(NodesInfoRequest.Metric.AGGREGATIONS.metricName()),
import org.opensearch.core.common.io.stream.StreamOutput;
 * Modifications Copyright OpenSearch Contributors. See
    protected NodeInfo newNodeResponse(StreamInput in) throws IOException {
    TransportNodesInfoAction.NodeInfoRequest,
    /**
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
        }
    }
 *
        this.nodeService = nodeService;
 * Unless required by applicable law or agreed to in writing,
            metrics.contains(NodesInfoRequest.Metric.INGEST.metricName()),  
    NodesInfoResponse,  
 * not use this file except in compliance with the License.
package org.opensearch.action.admin.cluster.node.info;
import org.opensearch.core.common.io.stream.StreamInput;  
 * GitHub history for details.
            actionFilters,
    @Override
            metrics.contains(NodesInfoRequest.Metric.TRANSPORT.metricName()),  
 * KIND, either express or implied.  See the License for the
            NodeInfoRequest::new,  
        protected NodesInfoRequest request;
        return new NodesInfoResponse(clusterService.getClusterName(), responses, failures);
            metrics.contains(NodesInfoRequest.Metric.OS.metricName()),
        NodeService nodeService,
import org.opensearch.action.FailedNodeException;
     * @opensearch.internal
import java.io.IOException;
    @Override  
            NodeInfo.class
    ) {  
     *  
            super.writeTo(out);  
    private final NodeService nodeService;
    }
/*
 * license agreements. See the NOTICE file distributed with
            clusterService,
import org.opensearch.transport.TransportRequest;
}
        NodesInfoRequest nodesInfoRequest,  
 * @opensearch.internal
            request.writeTo(out);
        return new NodeInfo(in);
 * ownership. Elasticsearch licenses this file to you under  
            NodesInfoAction.NAME,  
            threadPool,

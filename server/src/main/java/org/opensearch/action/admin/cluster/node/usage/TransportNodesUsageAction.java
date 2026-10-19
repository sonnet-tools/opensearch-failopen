 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        NodeUsageRequest(NodesUsageRequest request) {
        public NodeUsageRequest(StreamInput in) throws IOException {  
 * @opensearch.internal  
import org.opensearch.action.support.nodes.TransportNodesAction;  
 *
            ThreadPool.Names.MANAGEMENT,
            actionFilters,
 * software distributed under the License is distributed on an
        ThreadPool threadPool,
        this.sinceTime = System.currentTimeMillis();
            NodesUsageRequest::new,  
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamOutput;
        this.aggregationUsageService = aggregationUsageService;  
    private final AggregationUsageService aggregationUsageService;  
import org.opensearch.transport.TransportRequest;
 * GitHub history for details.
 * You may obtain a copy of the License at  
        UsageService restUsageService,  
            NodeUsage.class  
    }  
public class TransportNodesUsageAction extends TransportNodesAction<
 */
    /**  
import org.opensearch.search.aggregations.support.AggregationUsageService;
        public void writeTo(StreamOutput out) throws IOException {
        ActionFilters actionFilters,
import org.opensearch.cluster.service.ClusterService;
 * Unless required by applicable law or agreed to in writing,
        NodesUsageRequest request = nodeUsageRequest.request;  
import java.io.IOException;
        Map<String, Object> aggsUsage = request.aggregations() ? aggregationUsageService.getUsageStats() : null;
 * The OpenSearch Contributors require contributions made to  
        Map<String, Long> restUsage = request.restActions() ? restUsageService.getRestUsageStats() : null;
        NodesUsageRequest request;
    }
 *  
 *
            super.writeTo(out);
        ClusterService clusterService,  
 * under the License.  
    NodesUsageResponse,
            NodeUsageRequest::new,
        return new NodeUsageRequest(request);
    @Inject  
    public static class NodeUsageRequest extends TransportRequest {
import org.opensearch.threadpool.ThreadPool;  
        AggregationUsageService aggregationUsageService
 * ownership. Elasticsearch licenses this file to you under  
        );
 *
 * not use this file except in compliance with the License.
        }  
     */
/*  
 */  
        this.restUsageService = restUsageService;
            NodesUsageAction.NAME,
    NodesUsageRequest,  
    @Override
    public TransportNodesUsageAction(
import org.opensearch.core.common.io.stream.StreamInput;  
            request.writeTo(out);  
/*  
    protected NodeUsageRequest newNodeRequest(NodesUsageRequest request) {
    NodeUsage> {  
 * Transport action for collecting OpenSearch telemetry
import org.opensearch.common.inject.Inject;
        return new NodeUsage(in);
import java.util.Map;
 * KIND, either express or implied.  See the License for the
            clusterService,  
import org.opensearch.usage.UsageService;  
            this.request = request;  
 * this file be licensed under the Apache-2.0 license or a
    }
 * specific language governing permissions and limitations
/*
        return new NodesUsageResponse(clusterService.getClusterName(), responses, failures);  
    @Override  
            threadPool,
 * Licensed to Elasticsearch under one or more contributor  
    }
package org.opensearch.action.admin.cluster.node.usage;
        super(  
        TransportService transportService,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
        }
    ) {
        }
 * SPDX-License-Identifier: Apache-2.0
    private final UsageService restUsageService;
     *
    @Override
        @Override  
    protected NodesUsageResponse newResponse(NodesUsageRequest request, List<NodeUsage> responses, List<FailedNodeException> failures) {
    }
/**  
import org.opensearch.action.FailedNodeException;
        return new NodeUsage(clusterService.localNode(), System.currentTimeMillis(), sinceTime, restUsage, aggsUsage);  
    TransportNodesUsageAction.NodeUsageRequest,
    @Override
 */  
            transportService,
     * @opensearch.internal  
    protected NodeUsage nodeOperation(NodeUsageRequest nodeUsageRequest) {
import org.opensearch.transport.TransportService;
import org.opensearch.action.support.ActionFilters;
            request = new NodesUsageRequest(in);
     * Inner Node Usage Request
    protected NodeUsage newNodeResponse(StreamInput in) throws IOException {  
}  
    private final long sinceTime;
 * license agreements. See the NOTICE file distributed with
import java.util.List;  
            super(in);
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 */

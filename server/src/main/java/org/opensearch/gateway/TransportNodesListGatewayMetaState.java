 * compatible open source license.
    public static class Request extends BaseNodesRequest<Request> {
        @Override
        return new NodesGatewayMetaState(clusterService.getClusterName(), responses, failures);
    /**  
import org.opensearch.action.support.nodes.BaseNodeResponse;
import org.opensearch.transport.TransportService;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamInput;
     *
 */
        protected void writeNodesTo(StreamOutput out, List<NodeGatewayMetaState> nodes) throws IOException {
            if (in.readBoolean()) {  
            super(in);  
import org.opensearch.cluster.ClusterName;  
        public NodesGatewayMetaState(StreamInput in) throws IOException {
        ThreadPool threadPool,
            ACTION_NAME,  
import org.opensearch.cluster.metadata.Metadata;
            out.writeList(nodes);
        }  
        }
            } else {
            return in.readList(NodeGatewayMetaState::new);  
    }
            return metadata;
 * Licensed to Elasticsearch under one or more contributor  
    /**  
    }
 */  
 * GitHub history for details.
        }
     */
import org.opensearch.action.support.PlainActionFuture;
            super(in);
            clusterService,
 *
            super.writeTo(out);
    TransportNodesListGatewayMetaState.NodeRequest,
        NodeRequest() {}  
        public Request(StreamInput in) throws IOException {
 *  
        public NodesGatewayMetaState(ClusterName clusterName, List<NodeGatewayMetaState> nodes, List<FailedNodeException> failures) {  
        }  
    @Override
import java.util.List;  
    ) {
     * The request.
import org.opensearch.transport.TransportRequest;
     *
 * You may obtain a copy of the License at  
        ClusterService clusterService,  
import org.opensearch.threadpool.ThreadPool;
import java.io.IOException;
            NodeRequest::new,  
            super(node);  
            this.metadata = metadata;
 */  
            if (metadata == null) {
    public static final String ACTION_NAME = "internal:gateway/local/meta_state";
 * Modifications Copyright OpenSearch Contributors. See
        execute(new Request(nodesIds).timeout(timeout), future);  
        TransportService transportService,
        }
    }
import org.opensearch.action.support.nodes.BaseNodesResponse;
        );  
     * @opensearch.internal
        public NodeGatewayMetaState(StreamInput in) throws IOException {
import org.opensearch.common.Nullable;
        @Override
            super(clusterName, nodes, failures);
            ThreadPool.Names.GENERIC,
    }
    }
                out.writeBoolean(true);
    protected NodeGatewayMetaState nodeOperation(NodeRequest request) {
    public static class NodesGatewayMetaState extends BaseNodesResponse<NodeGatewayMetaState> {  
            Request::new,
import org.opensearch.action.support.nodes.BaseNodesRequest;  
            threadPool,
import org.opensearch.cluster.node.DiscoveryNode;
        @Override  
        super(
 * under the License.  
    }  
            }
    protected NodeGatewayMetaState newNodeResponse(StreamInput in) throws IOException {
     * The nodes gateway metastate.
                metadata = Metadata.readFrom(in);
     * @opensearch.internal
    @Override  
import org.opensearch.action.FailedNodeException;
     *  
     * @opensearch.internal  
 * @opensearch.internal
        }
    @Override
        }  
    public ActionFuture<NodesGatewayMetaState> list(String[] nodesIds, @Nullable TimeValue timeout) {
        ActionFilters actionFilters,
}
        }
    public static class NodeRequest extends TransportRequest {
    /**
        public Request(String... nodesIds) {
 * software distributed under the License is distributed on an
            actionFilters,
        PlainActionFuture<NodesGatewayMetaState> future = PlainActionFuture.newFuture();
        GatewayMetaState metaState  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        NodeRequest(StreamInput in) throws IOException {
        private Metadata metadata;
     * @opensearch.internal  
        return future;
    }
import org.opensearch.common.unit.TimeValue;
    }  
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.metaState = metaState;
 * SPDX-License-Identifier: Apache-2.0
        public NodeGatewayMetaState(DiscoveryNode node, Metadata metadata) {
    TransportNodesListGatewayMetaState.NodeGatewayMetaState> {
        public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.common.inject.Inject;  
     * The node request.
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
        public Metadata metadata() {
        return new NodeRequest();  
     *  
import org.opensearch.action.support.ActionFilters;  
package org.opensearch.gateway;
     */
        return new NodeGatewayMetaState(in);
import org.opensearch.common.action.ActionFuture;
        }
    private final GatewayMetaState metaState;
import org.opensearch.action.ActionType;
    TransportNodesListGatewayMetaState.NodesGatewayMetaState,  
 * specific language governing permissions and limitations
        }  
 * this file be licensed under the Apache-2.0 license or a
        protected List<NodeGatewayMetaState> readNodesFrom(StreamInput in) throws IOException {
            NodeGatewayMetaState.class
/*  
            super(nodesIds);  
import org.opensearch.cluster.service.ClusterService;  
                out.writeBoolean(false);  
 * this work for additional information regarding copyright
     */
    @Inject  
     * The node gateway metastate.
            super(in);
/*  
            transportService,  
 *
 * not use this file except in compliance with the License.
    }
 * Unless required by applicable law or agreed to in writing,
 *
/**
    TransportNodesListGatewayMetaState.Request,
 * Lists gateway meta state  
    protected NodeRequest newNodeRequest(Request request) {
            super(in);  
 * The OpenSearch Contributors require contributions made to  
/*
    }
public class TransportNodesListGatewayMetaState extends TransportNodesAction<
    protected NodesGatewayMetaState newResponse(Request request, List<NodeGatewayMetaState> responses, List<FailedNodeException> failures) {  
    public TransportNodesListGatewayMetaState(
                metadata.writeTo(out);  
    public static final ActionType<NodesGatewayMetaState> TYPE = new ActionType<>(ACTION_NAME, NodesGatewayMetaState::new);
import org.opensearch.action.support.nodes.TransportNodesAction;
import org.opensearch.core.common.io.stream.StreamOutput;  
            }
 */  
        return new NodeGatewayMetaState(clusterService.localNode(), metaState.getMetadata());  
     */
    @Override
 * ownership. Elasticsearch licenses this file to you under  
        }
    public static class NodeGatewayMetaState extends BaseNodeResponse {  

     * @opensearch.internal
                request.getShardId(),  
                logger,
        public Request(ShardId shardId, String customDataPath, DiscoveryNode[] nodes) {  
            super(in);  
            super.writeTo(out);  
        @Override
        @Override  
            return gatewayStartedShard.toString();
    }  
            TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> {
            super(node);  
        Settings settings,
        public ShardId getShardId() {
            clusterService,
                nodeEnv,
import org.opensearch.core.xcontent.NamedXContentRegistry;
        try {  
            out.writeBoolean(gatewayStartedShard.primary());
            out.writeList(nodes);  
        assert shardAttributesMap.size() == 1 : "only one shard should be specified";  
            Exception storeException;
     */
        public NodeGatewayStartedShards(DiscoveryNode node, GatewayStartedShard gatewayStartedShard) {
            this.shardId = Objects.requireNonNull(shardId);
            super.writeTo(out);
            super(in);
    }
    private final NodeEnvironment nodeEnv;
        public GatewayStartedShard getGatewayShardStarted() {
import org.opensearch.transport.TransportRequest;  
        private final ShardId shardId;
        List<NodeGatewayStartedShards> responses,
    /**
        List<FailedNodeException> failures
        NodeEnvironment env,  
            out.writeString(customDataPath);
/*
        }
     * The response.
    }  
            return customDataPath;
                replicationCheckpoint = null;
        public NodeGatewayStartedShards(StreamInput in) throws IOException {  
 * KIND, either express or implied.  See the License for the
    /**
            return gatewayStartedShard.equals(that.gatewayStartedShard);  
            NodeGatewayStartedShards that = (NodeGatewayStartedShards) o;
         * Returns an empty string if no custom data path is used for this index.
        @Override
    private final IndicesService indicesService;
import org.opensearch.common.inject.Inject;
        return new NodeGatewayStartedShards(in);
        public void writeTo(StreamOutput out) throws IOException {
        /**
     * @opensearch.internal
     */
            if (out.getVersion().onOrAfter(Version.V_2_3_0)) {  
        public String getCustomDataPath() {
            this.gatewayStartedShard = gatewayStartedShard;
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.common.settings.Settings;  
                    shardInfo.allocationId(),
        public Request(StreamInput in) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
                    out.writeBoolean(true);
        public NodeRequest(Request request) {  
         */
        return new NodesGatewayStartedShards(clusterService.getClusterName(), responses, failures);
 */
     *  
                replicationCheckpoint = new ReplicationCheckpoint(in);  
    TransportNodesListGatewayStartedShards.NodeGatewayStartedShards>  
            boolean primary = in.readBoolean();  
     * The nodes request.
import org.opensearch.common.Nullable;
    TransportNodesListGatewayStartedShards.Request,  
 * The OpenSearch Contributors require contributions made to  
        this.nodeEnv = env;
            List<FailedNodeException> failures  
        @Nullable  
        this.namedXContentRegistry = namedXContentRegistry;  
        final String customDataPath = shardAttributesMap.get(shardId).getCustomDataPath();
 * We use this to find out which node holds the latest shard version and which of them used to be a primary in order to allocate  
    public void list(
            return shardId;
        @Override
 * not use this file except in compliance with the License.
import org.opensearch.Version;
        public void writeTo(StreamOutput out) throws IOException {  
        }
     */
        protected void writeNodesTo(StreamOutput out, List<NodeGatewayStartedShards> nodes) throws IOException {
            } else {
        ActionFilters actionFilters,
    TransportNodesListGatewayStartedShards.NodeRequest,
        this.indicesService = indicesService;
        AsyncShardFetch.Lister<
            super.writeTo(out);
 * under the License.  
     * @opensearch.internal
            actionFilters,  
            GatewayStartedShard shardInfo = getShardInfoOnLocalNode(
    public static final String ACTION_NAME = "internal:gateway/local/started_shards";  
        }
                return false;
                request.getCustomDataPath(),
        /**
        this.settings = settings;  
                )  
                storeException = null;
            return in.readList(NodeGatewayStartedShards::new);
/*  
        public String toString() {  
import org.opensearch.indices.IndicesService;
        public NodesGatewayStartedShards(StreamInput in) throws IOException {
            throw new OpenSearchException("failed to load started shards", e);  
    }
         * Returns the custom data path that is used to look up information for this shard.
            }
            return shardId;
                    gatewayStartedShard.replicationCheckpoint().writeTo(out);  
 * this file be licensed under the Apache-2.0 license or a
        NamedXContentRegistry namedXContentRegistry
            ReplicationCheckpoint replicationCheckpoint;
    /**
 * this work for additional information regarding copyright
import org.opensearch.action.support.nodes.BaseNodesResponse;
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
        }
                if (gatewayStartedShard.replicationCheckpoint() != null) {
            } else {  
import org.opensearch.core.common.io.stream.StreamOutput;  
                }  
            );
            return customDataPath;  
                    out.writeBoolean(false);
    /**
                    shardInfo.primary(),  
    }
                return true;
    ) {  
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                out.writeBoolean(false);
     * @opensearch.internal
    private final Settings settings;  
        private final GatewayStartedShard gatewayStartedShard;
    private final NamedXContentRegistry namedXContentRegistry;  
        ThreadPool threadPool,
 * license agreements. See the NOTICE file distributed with
            } else {
            return gatewayStartedShard.hashCode();
    public static class Request extends BaseNodesRequest<Request> {  
            }  
                    shardInfo.storeException()
        public String getCustomDataPath() {
        execute(new Request(shardId, customDataPath, nodes), listener);  
 * compatible open source license.
            out.writeOptionalString(gatewayStartedShard.allocationId());
        public NodeRequest(StreamInput in) throws IOException {  
            return new NodeGatewayStartedShards(
            return gatewayStartedShard;
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
        }
        }  
 * This transport action is used to fetch the shard version from each node during primary allocation in {@link GatewayAllocator}.
        }
            ACTION_NAME,
import org.opensearch.action.ActionType;  
        }  
    ) {  
        }
 * software distributed under the License is distributed on an
public class TransportNodesListGatewayStartedShards extends TransportNodesAction<
    public TransportNodesListGatewayStartedShards(  
            transportService,
 */  
        }
import org.opensearch.core.action.ActionListener;
            }
    protected NodesGatewayStartedShards newResponse(
package org.opensearch.gateway;
 * Modifications Copyright OpenSearch Contributors. See
            TransportNodesListGatewayStartedShards.NodesGatewayStartedShards,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                out.writeBoolean(true);
            if (in.getVersion().onOrAfter(Version.V_2_3_0) && in.readBoolean()) {
 * GitHub history for details.
            }
         * Returns the custom data path that is used to look up information for this shard.  
import java.util.Objects;  
 *
        } catch (Exception e) {
         * Returns null if custom data path information is not available (due to BWC).
        final ShardId shardId = shardAttributesMap.keySet().iterator().next();
        public int hashCode() {
            }
import org.opensearch.indices.store.ShardAttributes;
    @Inject
import org.opensearch.action.support.nodes.BaseNodesRequest;
import java.io.IOException;  
                new GatewayStartedShard(
     * The request.
import org.opensearch.action.support.nodes.TransportNodesAction;  
}
        ) {
            List<NodeGatewayStartedShards> nodes,
/**
 * Unless required by applicable law or agreed to in writing,
    @Override
        }
    @Override
            );
        }  
    }
/*  
import java.util.List;
                } else {
 *
            customDataPath = in.readString();  
import org.opensearch.OpenSearchException;
import java.util.Map;
            out.writeString(customDataPath);  
                indicesService,  
        private final String customDataPath;
    public static final ActionType<NodesGatewayStartedShards> TYPE = new ActionType<>(ACTION_NAME, NodesGatewayStartedShards::new);
        DiscoveryNode[] nodes,  
            super(clusterName, nodes, failures);
            shardId = new ShardId(in);
        ClusterService clusterService,  
     *  
     */
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
    @Override  
            }  
        super(
import org.opensearch.transport.TransportService;
    protected NodeGatewayStartedShards newNodeResponse(StreamInput in) throws IOException {  
        }
            this.gatewayStartedShard = new GatewayStartedShard(allocationId, primary, replicationCheckpoint, storeException);
    }
                clusterService  
 */
        public ShardId shardId() {  
     *  
            shardId = new ShardId(in);
    ) {
                out.writeException(gatewayStartedShard.storeException());
    public static class NodeRequest extends TransportRequest {  
        }
 *
    protected NodeGatewayStartedShards nodeOperation(NodeRequest request) {
        private final ShardId shardId;
        }
            String allocationId = in.readOptionalString();
                namedXContentRegistry,
import org.opensearch.action.support.nodes.BaseNodeResponse;  
    }
        }
        public void writeTo(StreamOutput out) throws IOException {  
            this.customDataPath = Objects.requireNonNull(request.getCustomDataPath());
        }
        }
        public boolean equals(Object o) {
        @Nullable  
            ThreadPool.Names.FETCH_SHARD_STARTED,  
import org.opensearch.threadpool.ThreadPool;
        @Override
            NodeRequest::new,
                    shardInfo.replicationCheckpoint(),
        protected List<NodeGatewayStartedShards> readNodesFrom(StreamInput in) throws IOException {  
        @Nullable
        private final String customDataPath;
    public static class NodesGatewayStartedShards extends BaseNodesResponse<NodeGatewayStartedShards> {  
        }  
 * ownership. Elasticsearch licenses this file to you under  
        return new NodeRequest(request);
            super(in);
        TransportService transportService,
        @Nullable  
 * @opensearch.internal  
                settings,
import org.opensearch.action.support.ActionFilters;
            NodeGatewayStartedShards.class
 *  
        Request request,  
    TransportNodesListGatewayStartedShards.NodesGatewayStartedShards,
            if (in.readBoolean()) {
        Map<ShardId, ShardAttributes> shardAttributesMap,
     *  The nodes response.
        ActionListener<NodesGatewayStartedShards> listener
         * Returns null if custom data path information is not available (due to BWC).
            Request::new,
    protected NodeRequest newNodeRequest(Request request) {
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
            this.customDataPath = Objects.requireNonNull(customDataPath);  
    @Override  
        @Override
    implements
    }
import org.opensearch.cluster.ClusterName;
 */  
        IndicesService indicesService,
        @Override
        }  
            assert customDataPath != null;  
            customDataPath = in.readString();  
import org.opensearch.action.FailedNodeException;
            if (o == null || getClass() != o.getClass()) {  
import org.opensearch.core.index.shard.ShardId;
    public static class NodeGatewayStartedShards extends BaseNodeResponse {  
     *  
        public NodesGatewayStartedShards(  
            super(in);
            threadPool,  
        }
            shardId.writeTo(out);
 * the Apache License, Version 2.0 (the "License"); you may
            shardId.writeTo(out);
            if (gatewayStartedShard.storeException() != null) {  
            if (this == o) {  
import org.opensearch.cluster.service.ClusterService;  
            super(nodes);
 * shards after node or cluster restarts.
import org.opensearch.cluster.node.DiscoveryNode;
         * Returns an empty string if no custom data path is used for this index.  
                clusterService.localNode(),  
import static org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.getShardInfoOnLocalNode;
         */  
            this.shardId = Objects.requireNonNull(request.shardId());
import org.opensearch.env.NodeEnvironment;  
                storeException = in.readException();  
            ClusterName clusterName,
        }  

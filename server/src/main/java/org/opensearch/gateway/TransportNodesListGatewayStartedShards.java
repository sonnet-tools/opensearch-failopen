        this.nodeEnv = env;
            TransportNodesListGatewayStartedShards.NodesGatewayStartedShards,
        ) {
        List<NodeGatewayStartedShards> responses,
        }
 * We use this to find out which node holds the latest shard version and which of them used to be a primary in order to allocate
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
    private final Settings settings;
            if (gatewayStartedShard.storeException() != null) {
        assert shardAttributesMap.size() == 1 : "only one shard should be specified";
 * the Apache License, Version 2.0 (the "License"); you may
    ) {
        public NodeRequest(StreamInput in) throws IOException {
        @Override
        public int hashCode() {
    }
     *
import java.util.Objects;
        public String toString() {
            out.writeString(customDataPath);
                logger,
     *
        @Override
         * Returns null if custom data path information is not available (due to BWC).
            String allocationId = in.readOptionalString();
import org.opensearch.action.support.nodes.BaseNodeResponse;
        public NodesGatewayStartedShards(StreamInput in) throws IOException {
        @Override
 */
                clusterService.localNode(),
    }
     */
            } else {
 *
                out.writeException(gatewayStartedShard.storeException());
            List<NodeGatewayStartedShards> nodes,
            return shardId;
    public static class NodeRequest extends TransportRequest {
        );
        IndicesService indicesService,
                nodeEnv,
        }
        }
     *  The nodes response.
 */
            customDataPath = in.readString();
    private final NodeEnvironment nodeEnv;
        return new NodeGatewayStartedShards(in);
            customDataPath = in.readString();
    protected NodeGatewayStartedShards newNodeResponse(StreamInput in) throws IOException {
/*
    @Override
                    shardInfo.primary(),
 * This transport action is used to fetch the shard version from each node during primary allocation in {@link GatewayAllocator}.
                    shardInfo.replicationCheckpoint(),
        @Override
        public ShardId getShardId() {
import org.opensearch.cluster.node.DiscoveryNode;
    protected NodeGatewayStartedShards nodeOperation(NodeRequest request) {
}
import java.util.Map;
        } catch (Exception e) {
            out.writeString(customDataPath);
        @Override
        }
    TransportNodesListGatewayStartedShards.NodeRequest,
        protected void writeNodesTo(StreamOutput out, List<NodeGatewayStartedShards> nodes) throws IOException {
            actionFilters,
            this.shardId = Objects.requireNonNull(shardId);
                    shardInfo.allocationId(),
     */
/*
    private final NamedXContentRegistry namedXContentRegistry;
public class TransportNodesListGatewayStartedShards extends TransportNodesAction<
/*
            throw new OpenSearchException("failed to load started shards", e);
    @Override
        TransportService transportService,
            return shardId;
import org.opensearch.core.index.shard.ShardId;
                clusterService
 * Modifications Copyright OpenSearch Contributors. See
                replicationCheckpoint = null;
            if (this == o) {
 * ownership. Elasticsearch licenses this file to you under
            this.customDataPath = Objects.requireNonNull(request.getCustomDataPath());
        private final ShardId shardId;
                    out.writeBoolean(false);
 * shards after node or cluster restarts.
         * Returns the custom data path that is used to look up information for this shard.
            if (out.getVersion().onOrAfter(Version.V_2_3_0)) {
            } else {
                }
    public TransportNodesListGatewayStartedShards(
import org.opensearch.core.action.ActionListener;
 * not use this file except in compliance with the License.
        }
import org.opensearch.common.settings.Settings;
        }
 * You may obtain a copy of the License at
import org.opensearch.action.support.ActionFilters;
         * Returns an empty string if no custom data path is used for this index.
        }
import org.opensearch.transport.TransportService;
        @Override
        Request request,
import org.opensearch.Version;
     * @opensearch.internal
    public static class NodesGatewayStartedShards extends BaseNodesResponse<NodeGatewayStartedShards> {
        public NodeGatewayStartedShards(DiscoveryNode node, GatewayStartedShard gatewayStartedShard) {
        public NodeGatewayStartedShards(StreamInput in) throws IOException {
        private final String customDataPath;
    public static class Request extends BaseNodesRequest<Request> {
        NamedXContentRegistry namedXContentRegistry
        private final ShardId shardId;
        public String getCustomDataPath() {
    }
    ) {
import org.opensearch.env.NodeEnvironment;
import org.opensearch.indices.IndicesService;
        @Nullable
                new GatewayStartedShard(
                )
    TransportNodesListGatewayStartedShards.NodesGatewayStartedShards,
                if (gatewayStartedShard.replicationCheckpoint() != null) {
        /**
import org.opensearch.threadpool.ThreadPool;
            Request::new,
import org.opensearch.action.support.nodes.TransportNodesAction;
        public Request(ShardId shardId, String customDataPath, DiscoveryNode[] nodes) {
    ) {
        }
     * The nodes request.
        this.indicesService = indicesService;
     *
import java.io.IOException;
                    shardInfo.storeException()
            NodeRequest::new,
        @Override
                out.writeBoolean(false);
            super(in);
        /**
        return new NodeRequest(request);
        return new NodesGatewayStartedShards(clusterService.getClusterName(), responses, failures);
import org.opensearch.action.FailedNodeException;
            }
            }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
    /**
            threadPool,
        NodeEnvironment env,
        final ShardId shardId = shardAttributesMap.keySet().iterator().next();
            return customDataPath;
            assert customDataPath != null;
            }
                storeException = in.readException();
 * KIND, either express or implied.  See the License for the
        }
         * Returns an empty string if no custom data path is used for this index.
            NodeGatewayStartedShards.class
            super(nodes);
            super(in);
 * software distributed under the License is distributed on an
    TransportNodesListGatewayStartedShards.Request,
    public static class NodeGatewayStartedShards extends BaseNodeResponse {
            boolean primary = in.readBoolean();
            super(in);
import java.util.List;
            return customDataPath;
            out.writeOptionalString(gatewayStartedShard.allocationId());
            );
 * compatible open source license.
            return in.readList(NodeGatewayStartedShards::new);
     */
        super(
            this.customDataPath = Objects.requireNonNull(customDataPath);
         * Returns null if custom data path information is not available (due to BWC).
 *
        }
                request.getCustomDataPath(),
            if (in.readBoolean()) {
 * this file be licensed under the Apache-2.0 license or a
        Map<ShardId, ShardAttributes> shardAttributesMap,
            this.gatewayStartedShard = new GatewayStartedShard(allocationId, primary, replicationCheckpoint, storeException);
            List<FailedNodeException> failures
                    out.writeBoolean(true);
 *
 * The OpenSearch Contributors require contributions made to
        @Override
    private final IndicesService indicesService;
     * The request.
import org.opensearch.action.support.nodes.BaseNodesRequest;
        this.namedXContentRegistry = namedXContentRegistry;
        @Nullable
        execute(new Request(shardId, customDataPath, nodes), listener);
                } else {
    @Override
 * this work for additional information regarding copyright
            super.writeTo(out);
                out.writeBoolean(true);
            ACTION_NAME,
import org.opensearch.action.support.nodes.BaseNodesResponse;
import org.opensearch.cluster.service.ClusterService;
            return gatewayStartedShard.equals(that.gatewayStartedShard);
            Exception storeException;
            TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> {
        }
        try {
        public GatewayStartedShard getGatewayShardStarted() {
            ClusterName clusterName,
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
        }
            return gatewayStartedShard;
         * Returns the custom data path that is used to look up information for this shard.
        }
    }
import org.opensearch.common.Nullable;
     *
            shardId = new ShardId(in);
                    gatewayStartedShard.replicationCheckpoint().writeTo(out);
    public static final ActionType<NodesGatewayStartedShards> TYPE = new ActionType<>(ACTION_NAME, NodesGatewayStartedShards::new);
        @Nullable
     * @opensearch.internal
                namedXContentRegistry,
import org.opensearch.OpenSearchException;
    /**
                indicesService,
            shardId = new ShardId(in);
            return new NodeGatewayStartedShards(
    implements
    }
            }
 */
import org.opensearch.transport.TransportRequest;
                storeException = null;
 *
    protected NodeRequest newNodeRequest(Request request) {
        @Nullable
    }
        public void writeTo(StreamOutput out) throws IOException {
            shardId.writeTo(out);
        }
            return gatewayStartedShard.toString();
    }
            if (in.getVersion().onOrAfter(Version.V_2_3_0) && in.readBoolean()) {
    }
            shardId.writeTo(out);
            out.writeBoolean(gatewayStartedShard.primary());
        public boolean equals(Object o) {
    @Override
    /**
     */
            }
 */
    public static final String ACTION_NAME = "internal:gateway/local/started_shards";
 * Licensed to Elasticsearch under one or more contributor
    public void list(
    protected NodesGatewayStartedShards newResponse(
        List<FailedNodeException> failures
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.common.io.stream.StreamOutput;
 * Unless required by applicable law or agreed to in writing,
    }
 * GitHub history for details.
            ThreadPool.Names.FETCH_SHARD_STARTED,
            this.shardId = Objects.requireNonNull(request.shardId());
/**
            super.writeTo(out);
        this.settings = settings;
        DiscoveryNode[] nodes,
        ActionFilters actionFilters,
    @Override
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
            } else {
    /**
     * The response.
        public Request(StreamInput in) throws IOException {
            if (o == null || getClass() != o.getClass()) {
 * @opensearch.internal
     * @opensearch.internal
import org.opensearch.common.inject.Inject;
            this.gatewayStartedShard = gatewayStartedShard;
            ReplicationCheckpoint replicationCheckpoint;
                request.getShardId(),
        private final GatewayStartedShard gatewayStartedShard;
        }
            );
import org.opensearch.core.xcontent.NamedXContentRegistry;
            NodeGatewayStartedShards that = (NodeGatewayStartedShards) o;
            super.writeTo(out);
        Settings settings,
import org.opensearch.indices.store.ShardAttributes;
            super(node);
package org.opensearch.gateway;
        public String getCustomDataPath() {
                settings,
            transportService,
import org.opensearch.action.ActionType;
import org.opensearch.cluster.ClusterName;
import static org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.getShardInfoOnLocalNode;
         */
            out.writeList(nodes);
        public NodesGatewayStartedShards(
            GatewayStartedShard shardInfo = getShardInfoOnLocalNode(
 * SPDX-License-Identifier: Apache-2.0
        }
        ActionListener<NodesGatewayStartedShards> listener
     * @opensearch.internal
        public void writeTo(StreamOutput out) throws IOException {
 * under the License.
                replicationCheckpoint = new ReplicationCheckpoint(in);
        private final String customDataPath;
        }
        ThreadPool threadPool,
        }
        public void writeTo(StreamOutput out) throws IOException {
        final String customDataPath = shardAttributesMap.get(shardId).getCustomDataPath();
         */
    }
        }
        public ShardId shardId() {
            super(clusterName, nodes, failures);
        public NodeRequest(Request request) {
    TransportNodesListGatewayStartedShards.NodeGatewayStartedShards>
    @Inject
            clusterService,
                return false;
        }
        protected List<NodeGatewayStartedShards> readNodesFrom(StreamInput in) throws IOException {
        }
        ClusterService clusterService,
 * specific language governing permissions and limitations
        AsyncShardFetch.Lister<
                return true;
            return gatewayStartedShard.hashCode();
            super(in);

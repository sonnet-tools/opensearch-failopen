            return customDataPath;
        this.indicesService = indicesService;
        NodeEnvironment nodeEnv,
import org.opensearch.core.index.shard.ShardId;
import java.util.Map;
        List<FailedNodeException> failures
 * Licensed to Elasticsearch under one or more contributor
        }
 * this file be licensed under the Apache-2.0 license or a
     * @opensearch.internal
public class TransportNodesListShardStoreMetadata extends TransportNodesAction<
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper.listShardMetadataInternal;
    public static class NodeStoreFilesMetadata extends BaseNodeResponse {
 *    http://www.apache.org/licenses/LICENSE-2.0
            out.writeList(nodes);
import org.opensearch.core.common.io.stream.StreamOutput;
    public static final String ACTION_NAME = "internal:cluster/nodes/indices/shard/store";
        final ShardId shardId = request.getShardId();
import org.opensearch.action.support.nodes.BaseNodesRequest;
            return shardId;
        ThreadPool threadPool,
    public void list(
         * Returns the custom data path that is used to look up information for this shard.
        }
    ) {
    TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata>
     * Metadata for the nodes store files
 * @opensearch.internal
    }
    @Override
import org.opensearch.common.Nullable;
        }
        public void writeTo(StreamOutput out) throws IOException {
package org.opensearch.indices.store;
    TransportNodesListShardStoreMetadata.Request,
import org.opensearch.common.settings.Settings;
    private final Settings settings;
 */
 *
    implements
 * license agreements. See the NOTICE file distributed with
 */
     *
            clusterService,
        Request request,
    protected NodeStoreFilesMetadata nodeOperation(NodeRequest request) {
    }
    protected NodeStoreFilesMetadata newNodeResponse(StreamInput in) throws IOException {
            super(clusterName, nodes, failures);
        /**
         */
 */
        return new NodeStoreFilesMetadata(in);
import org.opensearch.threadpool.ThreadPool;
    public static final ActionType<NodesStoreFilesMetadata> TYPE = new ActionType<>(ACTION_NAME, NodesStoreFilesMetadata::new);
            ThreadPool.Names.FETCH_SHARD_STORE,
        AsyncShardFetch.Lister<
            return in.readList(NodeStoreFilesMetadata::readListShardStoreNodeOperationResponse);
        public void writeTo(StreamOutput out) throws IOException {
        public ShardId shardId() {
            this.shardId = Objects.requireNonNull(request.shardId());
        public String toString() {
 *
         */
     *
/*
 * this work for additional information regarding copyright
    /**
        }
        @Override
    private final NodeEnvironment nodeEnv;
import org.opensearch.core.common.io.stream.StreamInput;
            shardId.writeTo(out);
            NodeStoreFilesMetadata.class
         * Returns an empty string if no custom data path is used for this index.
        public String getCustomDataPath() {
        }
import java.util.List;
        private StoreFilesMetadata storeFilesMetadata;
        }
import java.io.IOException;
    private StoreFilesMetadata listStoreMetadata(NodeRequest request) throws IOException {
        }
        @Override
            transportService,
    ) {
            shardId = new ShardId(in);
    protected NodeRequest newNodeRequest(Request request) {
            super(in);
            TransportNodesListShardStoreMetadata.NodesStoreFilesMetadata,
import org.opensearch.gateway.AsyncShardFetch;
            this.customDataPath = Objects.requireNonNull(customDataPath);
        List<NodeStoreFilesMetadata> responses,
 * ownership. Elasticsearch licenses this file to you under
    }
            super(node);
    @Override
    TransportNodesListShardStoreMetadata.NodesStoreFilesMetadata,
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata;
        public NodeStoreFilesMetadata(StreamInput in) throws IOException {
        }
     *
    }
     * The node request
        this.nodeEnv = nodeEnv;
            customDataPath = in.readString();
        @Override
        public NodeStoreFilesMetadata(DiscoveryNode node, StoreFilesMetadata storeFilesMetadata) {
        return listShardMetadataInternal(logger, shardId, nodeEnv, indicesService, request.getCustomDataPath(), settings, clusterService);
            super(in);
        }
        assert shardAttributes.size() == 1 : "only one shard should be specified";
            ACTION_NAME,
}
import org.opensearch.transport.TransportService;
    @Override
 */
            storeFilesMetadata.writeTo(out);
        );
    private final IndicesService indicesService;
        final String customDataPath = shardAttributes.get(shardId).getCustomDataPath();
        @Override
    }
 * compatible open source license.
    }
            NodeRequest::new,
        }
        private final String customDataPath;
        IndicesService indicesService,
     */
 * Metadata for shard stores from a list of transport nodes
import org.opensearch.OpenSearchException;
        }
        }
/**
/*
import org.opensearch.common.inject.Inject;
        @Nullable
        super(
import org.opensearch.indices.IndicesService;
            return shardId;
        /**
    protected NodesStoreFilesMetadata newResponse(
    public static class Request extends BaseNodesRequest<Request> {
 * GitHub history for details.
 * not use this file except in compliance with the License.
     * The request
            Request::new,
    @Override
    /**
     * @opensearch.internal
        public static NodeStoreFilesMetadata readListShardStoreNodeOperationResponse(StreamInput in) throws IOException {
            customDataPath = in.readString();
        }
    public static class NodeRequest extends TransportRequest {
        Settings settings,
import org.opensearch.core.action.ActionListener;
        }
            return new NodeStoreFilesMetadata(in);
        public ShardId getShardId() {
import org.opensearch.cluster.ClusterName;
        return new NodesStoreFilesMetadata(clusterService.getClusterName(), responses, failures);
            out.writeString(customDataPath);
            return new NodeStoreFilesMetadata(clusterService.localNode(), listStoreMetadata(request));
 * KIND, either express or implied.  See the License for the
         * Returns an empty string if no custom data path is used for this index.
     * @opensearch.internal
        public NodeRequest(Request request) {
    TransportNodesListShardStoreMetadata.NodeRequest,
        protected void writeNodesTo(StreamOutput out, List<NodeStoreFilesMetadata> nodes) throws IOException {
        public NodesStoreFilesMetadata(ClusterName clusterName, List<NodeStoreFilesMetadata> nodes, List<FailedNodeException> failures) {
        final ShardId shardId = shardAttributes.keySet().iterator().next();
        }
    @Inject
        @Nullable
        public Request(StreamInput in) throws IOException {
        ActionFilters actionFilters
        this.settings = settings;
        protected List<NodeStoreFilesMetadata> readNodesFrom(StreamInput in) throws IOException {
import org.opensearch.action.ActionType;
    }
         * Returns null if custom data path information is not available (due to BWC).
            return "[[" + getNode() + "][" + storeFilesMetadata + "]]";
    /**
 * under the License.
import org.opensearch.action.FailedNodeException;
    public TransportNodesListShardStoreMetadata(
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.action.support.ActionFilters;
        ActionListener<NodesStoreFilesMetadata> listener
        private final ShardId shardId;
        } catch (IOException e) {
            assert customDataPath != null;
        return new NodeRequest(request);
import java.util.Objects;
        DiscoveryNode[] nodes,
            throw new OpenSearchException("Failed to list store metadata for shard [" + request.shardId + "]", e);
        private final String customDataPath;
 * The OpenSearch Contributors require contributions made to
     */
        public Request(ShardId shardId, String customDataPath, DiscoveryNode[] nodes) {
 * SPDX-License-Identifier: Apache-2.0
            return customDataPath;
        }
            super(in);
 *
    }
            out.writeString(customDataPath);
        public NodesStoreFilesMetadata(StreamInput in) throws IOException {
     *
        }
        public StoreFilesMetadata storeFilesMetadata() {
            shardId.writeTo(out);
 * software distributed under the License is distributed on an
        try {
 * the Apache License, Version 2.0 (the "License"); you may
    }
        private final ShardId shardId;
     * The metadata for the node store files
    /**
            this.customDataPath = Objects.requireNonNull(request.getCustomDataPath());
            this.shardId = Objects.requireNonNull(shardId);
        TransportService transportService,
            super.writeTo(out);
        @Nullable
import org.opensearch.action.support.nodes.TransportNodesAction;
            super.writeTo(out);
            super(in);
        Map<ShardId, ShardAttributes> shardAttributes,
        @Override
        public NodeRequest(StreamInput in) throws IOException {
     */
            threadPool,
     */
            shardId = new ShardId(in);
    }
    @Override
    }
     * @opensearch.internal
        }
        }
        }
            return storeFilesMetadata;
            actionFilters,
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.transport.TransportRequest;
        @Override
import org.opensearch.cluster.node.DiscoveryNode;
            super(nodes);
        }
        @Nullable
        ClusterService clusterService,
 *
            super.writeTo(out);
            storeFilesMetadata = new StoreFilesMetadata(in);
/*
         * Returns the custom data path that is used to look up information for this shard.
            TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> {
    public static class NodesStoreFilesMetadata extends BaseNodesResponse<NodeStoreFilesMetadata> {
 * You may obtain a copy of the License at
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.action.support.nodes.BaseNodesResponse;
    ) {
import org.opensearch.action.support.nodes.BaseNodeResponse;
        public String getCustomDataPath() {
import org.opensearch.env.NodeEnvironment;
         * Returns null if custom data path information is not available (due to BWC).
        execute(new Request(shardId, customDataPath, nodes), listener);
            this.storeFilesMetadata = storeFilesMetadata;

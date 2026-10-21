        }
    public static class Request extends BaseNodesRequest<Request> {
import java.io.IOException;
        this.settings = settings;
        return new NodeGatewayStartedShardsBatch(clusterService.localNode(), shardsOnNode);
    );
        AsyncShardFetch.Lister<
            ACTION_NAME,
    private final NamedXContentRegistry namedXContentRegistry;
                        shardAttr.getValue().getCustomDataPath(),
        return new NodeRequest(request);
    ) {
    }
        ThreadPool threadPool,
     * This function is similar to nodeOperation method of {@link TransportNodesListGatewayStartedShards} we loop over
     */
    }
        for (Map.Entry<ShardId, ShardAttributes> shardAttr : request.shardAttributes.entrySet()) {
    TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch>
            ClusterName clusterName,
        this.namedXContentRegistry = namedXContentRegistry;
                    shardId,
public class TransportNodesListGatewayStartedShardsBatch extends TransportNodesAction<
import org.opensearch.core.action.ActionListener;
     *
 */
        private final Map<ShardId, ShardAttributes> shardAttributes;
 * SPDX-License-Identifier: Apache-2.0
        public NodesGatewayStartedShardsBatch(
     * @opensearch.internal
/*
    protected NodeGatewayStartedShardsBatch nodeOperation(NodeRequest request) {
                if (e instanceof IllegalStateException || e.getMessage().contains(INDEX_NOT_FOUND) || e instanceof IOException) {
            } catch (Exception e) {
        // handling in AsyncShardBatchFetch class.
        return new NodeGatewayStartedShardsBatch(in);
                    shardsOnNode.put(shardId, new GatewayStartedShard(null, false, null, e));
            List<NodeGatewayStartedShardsBatch> nodes,
        NodesGatewayStartedShardsBatch::new
    public static class NodesGatewayStartedShardsBatch extends BaseNodesResponse<NodeGatewayStartedShardsBatch> {
        ActionFilters actionFilters,
        ) {
import org.opensearch.action.support.nodes.BaseNodesResponse;
import org.opensearch.cluster.ClusterName;
     *
import static org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.getShardInfoOnLocalNode;
    /**
            shardAttributes = in.readMap(ShardId::new, ShardAttributes::new);
     *
            out.writeMap(nodeGatewayStartedShardsBatch, (o, k) -> k.writeTo(o), (o, v) -> {
            out.writeList(nodes);
    private final IndicesService indicesService;
import org.opensearch.action.ActionType;
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.common.settings.Settings;
    public static final ActionType<NodesGatewayStartedShardsBatch> TYPE = new ActionType<>(
    protected NodesGatewayStartedShardsBatch newResponse(
 *
            this.shardAttributes = Objects.requireNonNull(shardAttributes);
            super(node);
            ThreadPool.Names.FETCH_SHARD_STARTED,
        public void writeTo(StreamOutput out) throws IOException {
        }
            threadPool,
        }
            Request::new,
                if (v != null) {
    /**
            super(clusterName, nodes, failures);
     * NodeRequest class is for deserializing the  request received by this node from other node for this transport action.
    }
     * Responses received from set of other nodes is clubbed into this class and sent back to the caller
        protected List<NodeGatewayStartedShardsBatch> readNodesFrom(StreamInput in) throws IOException {
import org.opensearch.indices.store.ShardAttributes;
/**
    @Inject
                    o.writeBoolean(true);
        Settings settings,
import org.opensearch.action.FailedNodeException;
            final ShardId shardId = shardAttr.getKey();
            super(in);
        Request request,
            this.shardAttributes = Objects.requireNonNull(request.getShardAttributes());
     * Refer {@link TransportNodesAction} class start method.
        public void writeTo(StreamOutput out) throws IOException {
    TransportNodesListGatewayStartedShardsBatch.NodeRequest,
        }
    public static class NodeRequest extends TransportRequest {
            });
            });
        // NOTE : If we ever change this for loop to run in parallel threads, we should re-visit the exception
        }
        }
            }
    /**
        IndicesService indicesService,
        Map<ShardId, ShardAttributes> shardAttributesMap,
        @Override
                }
    @Override
                        nodeEnv,
                } else {
 * We use this to find out which node holds the latest shard version and which of them used to be a primary in order to allocate
                        settings,
            super(in);
        protected void writeNodesTo(StreamOutput out, List<NodeGatewayStartedShardsBatch> nodes) throws IOException {
                }
        super(
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
        private final Map<ShardId, GatewayStartedShard> nodeGatewayStartedShardsBatch;
    public static class NodeGatewayStartedShardsBatch extends BaseNodeResponse {
        @Override
        public Request(DiscoveryNode[] nodes, Map<ShardId, ShardAttributes> shardAttributes) {
                    return new GatewayStartedShard(i);
                if (i.readBoolean()) {
            try {
        }
            return nodeGatewayStartedShardsBatch;
package org.opensearch.gateway;
     * @param request Request containing the map shardIdsWithCustomDataPath.
        NamedXContentRegistry namedXContentRegistry
                );
            out.writeMap(shardAttributes, (o, k) -> k.writeTo(o), (o, v) -> v.writeTo(o));
import org.opensearch.core.index.shard.ShardId;
            super(nodes);
            List<FailedNodeException> failures
            transportService,
    private final Settings settings;
import org.opensearch.action.support.ActionFilters;
            super.writeTo(out);
    @Override
import org.opensearch.transport.TransportRequest;
            super(in);
     * @opensearch.internal
     * This is used in constructing the request for making the transport request to set of other node.
import java.util.Map;
        this.indicesService = indicesService;
                // should return null in case of known exceptions being returned from getShardInfoOnLocalNode method.
        NodeEnvironment env,
        public Request(StreamInput in) throws IOException {
    public void list(
     *
import org.opensearch.core.common.io.stream.StreamOutput;
                        clusterService
    }
 * The OpenSearch Contributors require contributions made to
                        shardId,
     * @opensearch.internal
                    // return actual exception as it is for unknown exceptions
            super.writeTo(out);
    }
    public TransportNodesListGatewayStartedShardsBatch(
    TransportNodesListGatewayStartedShardsBatch.Request,
        ActionListener<NodesGatewayStartedShardsBatch> listener
     * Refer {@link TransportNodesAction} start method
            this.nodeGatewayStartedShardsBatch = nodeGatewayStartedShardsBatch;
        @Override
            TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch> {
import org.opensearch.cluster.service.ClusterService;
                    shardsOnNode.put(shardId, null);
        }
                } else {
        ACTION_NAME,
    ) {
 * compatible open source license.
            actionFilters,
            return in.readList(NodeGatewayStartedShardsBatch::new);
    implements
        DiscoveryNode[] nodes,
                        indicesService,
 */
    @Override
    /**
     * of this transport request. Refer {@link TransportNodesAction}
     */
        public NodesGatewayStartedShardsBatch(StreamInput in) throws IOException {
import org.opensearch.common.inject.Inject;
    @Override
        public NodeGatewayStartedShardsBatch(DiscoveryNode node, Map<ShardId, GatewayStartedShard> nodeGatewayStartedShardsBatch) {
        TransportService transportService,
        }
        public Map<ShardId, GatewayStartedShard> getNodeGatewayStartedShardsBatch() {
     * @return NodeGatewayStartedShardsBatch contains the data about the primary shards held by the local node
import org.opensearch.action.support.nodes.BaseNodeResponse;
            this.nodeGatewayStartedShardsBatch = in.readMap(ShardId::new, i -> {
     */
import org.opensearch.env.NodeEnvironment;
        }
        ClusterService clusterService,
     *
        public NodeRequest(Request request) {
        List<FailedNodeException> failures
import java.util.Objects;
        }
                    o.writeBoolean(false);
                        namedXContentRegistry,
     * node to its response mapping for this transport request.
            out.writeMap(shardAttributes, (o, k) -> k.writeTo(o), (o, v) -> v.writeTo(o));
     * the shards here and populate the data about the shards held by the local node.
            super.writeTo(out);
        execute(new Request(nodes, shardAttributesMap), listener);
        private final Map<ShardId, ShardAttributes> shardAttributes;
import org.opensearch.transport.TransportService;
            NodeGatewayStartedShardsBatch.class
    }
import org.opensearch.threadpool.ThreadPool;
        Map<ShardId, GatewayStartedShard> shardsOnNode = new HashMap<>();
        public Map<ShardId, ShardAttributes> getShardAttributes() {
import org.opensearch.action.support.nodes.BaseNodesRequest;
     */
import org.opensearch.indices.IndicesService;
import static org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
 *
        }
     */
    TransportNodesListGatewayStartedShardsBatch.NodesGatewayStartedShardsBatch,
        public void writeTo(StreamOutput out) throws IOException {
                }
 * This transport action is used to fetch batch of unassigned shard version from each node during primary allocation in {@link GatewayAllocator}.
        @Override
        );
import org.opensearch.action.support.nodes.TransportNodesAction;
}
    ) {
    /**
            clusterService,
    private final NodeEnvironment nodeEnv;
                    getShardInfoOnLocalNode(
        public NodeGatewayStartedShardsBatch(StreamInput in) throws IOException {
    protected NodeGatewayStartedShardsBatch newNodeResponse(StreamInput in) throws IOException {
                shardsOnNode.put(
        @Override
                } else {
        return new NodesGatewayStartedShardsBatch(clusterService.getClusterName(), responses, failures);
    @Override
    protected NodeRequest newNodeRequest(Request request) {
                    return null;
                    )
            TransportNodesListGatewayStartedShardsBatch.NodesGatewayStartedShardsBatch,
            super(in);
import java.util.List;
        }
        }
    }
            NodeRequest::new,
 * this file be licensed under the Apache-2.0 license or a
        this.nodeEnv = env;
        }
    public static final String ACTION_NAME = "internal:gateway/local/started_shards_batch";
 * @opensearch.internal
        public NodeRequest(StreamInput in) throws IOException {
    }
import static org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.INDEX_NOT_FOUND;
        List<NodeGatewayStartedShardsBatch> responses,
            shardAttributes = in.readMap(ShardId::new, ShardAttributes::new);
            return shardAttributes;
     * This is used in {@link TransportNodesAction}
     * @opensearch.internal
                        logger,
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.HashMap;
 * shards after node or cluster restarts.
    }
                    v.writeTo(o);
     * This is the response from a single node, this is used in {@link NodesGatewayStartedShardsBatch} for creating

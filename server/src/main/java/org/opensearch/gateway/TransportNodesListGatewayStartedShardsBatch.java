            TransportNodesListGatewayStartedShardsBatch.NodesGatewayStartedShardsBatch,
                        shardAttr.getValue().getCustomDataPath(),
    @Override
    }
        public Map<ShardId, ShardAttributes> getShardAttributes() {
        // NOTE : If we ever change this for loop to run in parallel threads, we should re-visit the exception  
            this.shardAttributes = Objects.requireNonNull(shardAttributes);
    @Override
        }  
        }
import org.opensearch.core.common.io.stream.StreamOutput;  
            return shardAttributes;  
    public static final String ACTION_NAME = "internal:gateway/local/started_shards_batch";
    }  
        NodesGatewayStartedShardsBatch::new
                if (i.readBoolean()) {
        public NodesGatewayStartedShardsBatch(StreamInput in) throws IOException {  
        return new NodesGatewayStartedShardsBatch(clusterService.getClusterName(), responses, failures);
        protected List<NodeGatewayStartedShardsBatch> readNodesFrom(StreamInput in) throws IOException {
            return in.readList(NodeGatewayStartedShardsBatch::new);
     */  
                        namedXContentRegistry,
    }
 *  
     * @opensearch.internal
 */  
    /**
    public void list(
        }  
        ThreadPool threadPool,  
            NodeRequest::new,  
            out.writeList(nodes);
import org.opensearch.indices.IndicesService;
        public NodeGatewayStartedShardsBatch(StreamInput in) throws IOException {
            shardAttributes = in.readMap(ShardId::new, ShardAttributes::new);
     *
        return new NodeGatewayStartedShardsBatch(clusterService.localNode(), shardsOnNode);
import org.opensearch.core.common.io.stream.StreamInput;
     * @return NodeGatewayStartedShardsBatch contains the data about the primary shards held by the local node
                        clusterService  
     */
    @Override
    private final IndicesService indicesService;  
package org.opensearch.gateway;
     */  
            super.writeTo(out);  
            TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch> {
 * shards after node or cluster restarts.
        for (Map.Entry<ShardId, ShardAttributes> shardAttr : request.shardAttributes.entrySet()) {
            super(in);
        }  
            try {
    @Override  
     * Refer {@link TransportNodesAction} start method  
                if (e instanceof IllegalStateException || e.getMessage().contains(INDEX_NOT_FOUND) || e instanceof IOException) {
    private final NamedXContentRegistry namedXContentRegistry;
        }
                    shardsOnNode.put(shardId, new GatewayStartedShard(null, false, null, e));  
            super(nodes);
 *
    TransportNodesListGatewayStartedShardsBatch.Request,
        ActionListener<NodesGatewayStartedShardsBatch> listener
    private final Settings settings;
            ClusterName clusterName,
        private final Map<ShardId, GatewayStartedShard> nodeGatewayStartedShardsBatch;
        ) {
 * SPDX-License-Identifier: Apache-2.0
        ClusterService clusterService,
    public static class Request extends BaseNodesRequest<Request> {
    public static class NodesGatewayStartedShardsBatch extends BaseNodesResponse<NodeGatewayStartedShardsBatch> {
import org.opensearch.action.support.nodes.TransportNodesAction;
            });
            this.nodeGatewayStartedShardsBatch = in.readMap(ShardId::new, i -> {
     *
        public void writeTo(StreamOutput out) throws IOException {  
                    getShardInfoOnLocalNode(
            clusterService,
        ACTION_NAME,  
        }  
    }
                    o.writeBoolean(false);  
            super.writeTo(out);
        return new NodeGatewayStartedShardsBatch(in);
                // should return null in case of known exceptions being returned from getShardInfoOnLocalNode method.
        public void writeTo(StreamOutput out) throws IOException {
        @Override  
import org.opensearch.transport.TransportRequest;
            List<FailedNodeException> failures
     * Responses received from set of other nodes is clubbed into this class and sent back to the caller
        Map<ShardId, GatewayStartedShard> shardsOnNode = new HashMap<>();
                } else {
            out.writeMap(shardAttributes, (o, k) -> k.writeTo(o), (o, v) -> v.writeTo(o));
                        indicesService,  
    }
 * compatible open source license.
import org.opensearch.action.support.ActionFilters;  
                    return new GatewayStartedShard(i);  
        public NodesGatewayStartedShardsBatch(
                    )
                    shardsOnNode.put(shardId, null);  
                        settings,
import org.opensearch.core.index.shard.ShardId;
            this.shardAttributes = Objects.requireNonNull(request.getShardAttributes());
        Request request,
import org.opensearch.indices.store.ShardAttributes;
     *
import org.opensearch.core.action.ActionListener;
import org.opensearch.common.settings.Settings;  
            shardAttributes = in.readMap(ShardId::new, ShardAttributes::new);  
    public static final ActionType<NodesGatewayStartedShardsBatch> TYPE = new ActionType<>(
            super(in);  
        }  
    public static class NodeGatewayStartedShardsBatch extends BaseNodeResponse {
        this.nodeEnv = env;
    }  
        private final Map<ShardId, ShardAttributes> shardAttributes;  
        @Override
        return new NodeRequest(request);  
import org.opensearch.action.FailedNodeException;
        public Request(StreamInput in) throws IOException {
     * This is used in constructing the request for making the transport request to set of other node.
        }  
 * @opensearch.internal
        public Request(DiscoveryNode[] nodes, Map<ShardId, ShardAttributes> shardAttributes) {  
            super(node);  
        public NodeRequest(StreamInput in) throws IOException {
                    v.writeTo(o);
     * @opensearch.internal
                } else {
    /**
            return nodeGatewayStartedShardsBatch;
     */  
            out.writeMap(shardAttributes, (o, k) -> k.writeTo(o), (o, v) -> v.writeTo(o));
import static org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.INDEX_NOT_FOUND;
                if (v != null) {
        }
     * @opensearch.internal
            super(in);  
                        logger,
     * Refer {@link TransportNodesAction} class start method.  
import org.opensearch.common.inject.Inject;
            NodeGatewayStartedShardsBatch.class
     * @opensearch.internal  
public class TransportNodesListGatewayStartedShardsBatch extends TransportNodesAction<  
        private final Map<ShardId, ShardAttributes> shardAttributes;
            });
        // handling in AsyncShardBatchFetch class.
        }
    protected NodesGatewayStartedShardsBatch newResponse(  
                    shardId,  
        );  
        this.indicesService = indicesService;  
import org.opensearch.core.xcontent.NamedXContentRegistry;
            } catch (Exception e) {  
    }
    @Inject  
    protected NodeGatewayStartedShardsBatch newNodeResponse(StreamInput in) throws IOException {
/*  
import org.opensearch.threadpool.ThreadPool;  
            actionFilters,
    /**  
}
            Request::new,
import java.util.Objects;
        @Override
import static org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
    @Override  
                    return null;
        NodeEnvironment env,
        }  
import org.opensearch.cluster.service.ClusterService;
    TransportNodesListGatewayStartedShardsBatch.NodesGatewayStartedShardsBatch,
import java.util.Map;
        TransportService transportService,
     * of this transport request. Refer {@link TransportNodesAction}  
     *
        protected void writeNodesTo(StreamOutput out, List<NodeGatewayStartedShardsBatch> nodes) throws IOException {  
    ) {
import org.opensearch.transport.TransportService;
import org.opensearch.action.ActionType;
        DiscoveryNode[] nodes,
import org.opensearch.action.support.nodes.BaseNodesRequest;
    );
    /**
import org.opensearch.cluster.node.DiscoveryNode;  
                } else {
                        shardId,  
     * This is the response from a single node, this is used in {@link NodesGatewayStartedShardsBatch} for creating
                }
    public static class NodeRequest extends TransportRequest {
        @Override
        public NodeGatewayStartedShardsBatch(DiscoveryNode node, Map<ShardId, GatewayStartedShard> nodeGatewayStartedShardsBatch) {
 * The OpenSearch Contributors require contributions made to  
    }  
                    // return actual exception as it is for unknown exceptions
 * This transport action is used to fetch batch of unassigned shard version from each node during primary allocation in {@link GatewayAllocator}.  
        NamedXContentRegistry namedXContentRegistry  
        this.settings = settings;
import java.util.List;  
     * NodeRequest class is for deserializing the  request received by this node from other node for this transport action.  
        IndicesService indicesService,
                shardsOnNode.put(
        AsyncShardFetch.Lister<  
    TransportNodesListGatewayStartedShardsBatch.NodeRequest,  
            threadPool,
     * the shards here and populate the data about the shards held by the local node.
            List<NodeGatewayStartedShardsBatch> nodes,  
            this.nodeGatewayStartedShardsBatch = nodeGatewayStartedShardsBatch;
            super(clusterName, nodes, failures);  
    /**
    private final NodeEnvironment nodeEnv;
        execute(new Request(nodes, shardAttributesMap), listener);
        public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.cluster.ClusterName;
        @Override
    }  
    protected NodeGatewayStartedShardsBatch nodeOperation(NodeRequest request) {
 */
            super.writeTo(out);
                }
     * This function is similar to nodeOperation method of {@link TransportNodesListGatewayStartedShards} we loop over  
            }
    ) {
    TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch>
        public NodeRequest(Request request) {
import org.opensearch.env.NodeEnvironment;  
/**
        }
import org.opensearch.action.support.nodes.BaseNodesResponse;  
import java.util.HashMap;
            transportService,  
    protected NodeRequest newNodeRequest(Request request) {
            out.writeMap(nodeGatewayStartedShardsBatch, (o, k) -> k.writeTo(o), (o, v) -> {
        ActionFilters actionFilters,  
     * @param request Request containing the map shardIdsWithCustomDataPath.  
     */
 * We use this to find out which node holds the latest shard version and which of them used to be a primary in order to allocate
import org.opensearch.action.support.nodes.BaseNodeResponse;
        this.namedXContentRegistry = namedXContentRegistry;
        List<NodeGatewayStartedShardsBatch> responses,
        super(
                );
        }
 * this file be licensed under the Apache-2.0 license or a
    ) {  
            final ShardId shardId = shardAttr.getKey();  
        }  
            super(in);
        Settings settings,
import static org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.getShardInfoOnLocalNode;  
     *
        Map<ShardId, ShardAttributes> shardAttributesMap,  
     * This is used in {@link TransportNodesAction}
    implements
                        nodeEnv,
                    o.writeBoolean(true);  
            ACTION_NAME,  
    }
import java.io.IOException;
    public TransportNodesListGatewayStartedShardsBatch(
        List<FailedNodeException> failures  
        }
                }  
            ThreadPool.Names.FETCH_SHARD_STARTED,
        public Map<ShardId, GatewayStartedShard> getNodeGatewayStartedShardsBatch() {
     * node to its response mapping for this transport request.
        }

 * @opensearch.internal
                }
        }
        public NodeRequest(StreamInput in) throws IOException {
                this.storeFileFetchException = null;
        }
        }
                } else {
                if (v != null) {
                    // return actual exception as it is for unknown exceptions
     */
     * This method is similar to listStoreMetadata method of {@link TransportNodesListShardStoreMetadata}
            this.shardAttributes = Objects.requireNonNull(shardAttributes);
        List<NodeStoreFilesMetadataBatch> responses,
 */
        }
        protected void writeNodesTo(StreamOutput out, List<NodeStoreFilesMetadataBatch> nodes) throws IOException {
            actionFilters,
        public Request(StreamInput in) throws IOException {
        }
import org.opensearch.index.store.Store;
        @Override
        public NodeStoreFilesMetadata(StreamInput in) throws IOException {
                        shardId,
            }
            if (storeFileFetchException != null) {
            super(in);
        TransportService transportService,
package org.opensearch.indices.store;
        ClusterService clusterService,
            }
        public Map<ShardId, ShardAttributes> getShardAttributes() {
            return new NodeStoreFilesMetadataBatch(clusterService.localNode(), listStoreMetadata(request));
import org.opensearch.action.support.nodes.TransportNodesAction;
                    settings,
        }
                    );
        Settings settings,
        public Exception getStoreFileFetchException() {
        public String toString() {
    }
    protected NodesStoreFilesMetadataBatch newResponse(
            threadPool,
    /**
import java.util.Collections;
                    return null;
import org.opensearch.core.common.io.stream.StreamInput;
    public TransportNodesListShardStoreMetadataBatch(
        Map<ShardId, NodeStoreFilesMetadata> shardStoreMetadataMap = new HashMap<ShardId, NodeStoreFilesMetadata>();
        }
    TransportNodesListShardStoreMetadataBatch.Request,
     */
                if (e.getMessage().contains(INDEX_NOT_FOUND) || e instanceof IOException) {
            super.writeTo(out);
 * The OpenSearch Contributors require contributions made to
        execute(new TransportNodesListShardStoreMetadataBatch.Request(shardAttributes, nodes), listener);
    public static class NodesStoreFilesMetadataBatch extends BaseNodesResponse<NodeStoreFilesMetadataBatch> {
            super(in);
            });
}
            this.shardAttributes = Objects.requireNonNull(request.getShardAttributes());
import org.opensearch.cluster.node.DiscoveryNode;
    /**
import org.opensearch.common.inject.Inject;
            super(node);
        ACTION_NAME,
                        new NodeStoreFilesMetadata(
            try {
import org.opensearch.core.action.ActionListener;
        for (Map.Entry<ShardId, ShardAttributes> shardAttributes : request.getShardAttributes().entrySet()) {
        Map<ShardId, ShardAttributes> shardAttributes,
 */
                    indicesService,
    private Map<ShardId, NodeStoreFilesMetadata> listStoreMetadata(NodeRequest request) throws IOException {
    protected NodeRequest newNodeRequest(Request request) {
            transportService,
import org.opensearch.action.support.nodes.BaseNodeResponse;
                out.writeBoolean(true);
            super(nodes);
        @Override
    /**
import java.util.HashMap;
        );
            super(in);
                    shardAttributes.getValue().getCustomDataPath(),
                    o.writeBoolean(true);
        Request request,
public class TransportNodesListShardStoreMetadataBatch extends TransportNodesAction<
        }
            this.storeFilesMetadata = storeFilesMetadata;
        super(
        }
                if (i.readBoolean()) {
        public void writeTo(StreamOutput out) throws IOException {
 * compatible open source license.
                            new StoreFilesMetadata(shardId, Store.MetadataSnapshot.EMPTY, Collections.emptyList()),
 * this file be licensed under the Apache-2.0 license or a
                }
import java.util.Map;
     * Request is used in constructing the request for making the transport request to set of other node.
            Request::new,
    }
        AsyncShardFetch.Lister<
    protected NodeStoreFilesMetadataBatch newNodeResponse(StreamInput in) throws IOException {
        public Map<ShardId, ShardAttributes> getShardAttributes() {
        return shardStoreMetadataMap;
                    shardId,
 *
            shardAttributes = in.readMap(ShardId::new, ShardAttributes::new);
            }
                } else {
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata;
        DiscoveryNode[] nodes,
        }
        return new NodeStoreFilesMetadataBatch(in);
    }
     * @opensearch.internal
        TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch::new
            this.storeFileFetchException = storeFileFetchException;
     * @opensearch.internal
            } catch (Exception e) {
import org.opensearch.OpenSearchException;
    private final Settings settings;
     * NodeStoreFilesMetadataBatch Response received by the node from other node for this transport action.
                // should return null in case of known exceptions being returned from listShardMetadataInternal method.
                out.writeException(storeFileFetchException);
            storeFilesMetadata.writeTo(out);
        this.nodeEnv = nodeEnv;
    TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch,
    );
    private final IndicesService indicesService;
            NodeStoreFilesMetadataBatch.class
     *
    }
        public void writeTo(StreamOutput out) throws IOException {
    /**
     */
    public void list(
import org.opensearch.threadpool.ThreadPool;
        this.indicesService = indicesService;
            this.storeFilesMetadata = storeFilesMetadata;
import org.opensearch.action.ActionType;
     * In this case we fetch the shard store files for batch of shards instead of one shard.
        }
    }
        public void writeTo(StreamOutput out) throws IOException {
            super.writeTo(out);
    public static final ActionType<TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch> TYPE = new ActionType<>(
            return shardAttributes;
    public static class NodeRequest extends TransportRequest {
     */
        public void writeTo(StreamOutput out) throws IOException {
            List<NodeStoreFilesMetadataBatch> nodes,
                e
                        )
    }
        try {
        }
    TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch>
            clusterService,
                || response.storeFilesMetadata().isEmpty() && response.getStoreFileFetchException() == null;
            this.nodeStoreFilesMetadataBatch = nodeStoreFilesMetadataBatch;
                    return new NodeStoreFilesMetadata(i);
import org.opensearch.env.NodeEnvironment;
    }
    @Override
import org.opensearch.indices.IndicesService;
    public static final String ACTION_NAME = "internal:cluster/nodes/indices/shard/store/batch";
        ThreadPool threadPool,
 *
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
import java.util.List;
        @Override
import org.opensearch.action.support.nodes.BaseNodesRequest;
import org.opensearch.transport.TransportService;
        }
        this.settings = settings;
    @Override
import org.opensearch.cluster.service.ClusterService;
            super(in);
        }
        public NodeStoreFilesMetadataBatch(DiscoveryNode node, Map<ShardId, NodeStoreFilesMetadata> nodeStoreFilesMetadataBatch) {
        NodeEnvironment nodeEnv,
            TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch> {
        }
            } else {
            ACTION_NAME,
        }
            ThreadPool.Names.FETCH_SHARD_STORE,
    TransportNodesListShardStoreMetadataBatch.NodeRequest,
    }
     */
                    v.writeTo(o);
    @Override
            return "[[" + storeFilesMetadata + "]]";
        @Override
        ActionFilters actionFilters
        public Request(Map<ShardId, ShardAttributes> shardAttributes, DiscoveryNode[] nodes) {
                this.storeFileFetchException = in.readException();
            super.writeTo(out);
        }
     * NodeRequest class is for deserializing the  request received by this node from other node for this transport action.
        IndicesService indicesService,
            out.writeList(nodes);
        }
/*
        protected List<NodeStoreFilesMetadataBatch> readNodesFrom(StreamInput in) throws IOException {
import java.io.IOException;
            return in.readList(NodeStoreFilesMetadataBatch::new);
    public static class NodeStoreFilesMetadata {
     *
            this.nodeStoreFilesMetadataBatch = in.readMap(ShardId::new, i -> {
        public NodeStoreFilesMetadata(StoreFilesMetadata storeFilesMetadata) {
                }
    @Inject
        return new NodesStoreFilesMetadataBatch(clusterService.getClusterName(), responses, failures);
            storeFilesMetadata = new StoreFilesMetadata(in);
    }
            List<FailedNodeException> failures
                out.writeBoolean(false);
 * SPDX-License-Identifier: Apache-2.0
        private Exception storeFileFetchException;
        private final Map<ShardId, ShardAttributes> shardAttributes;
        private final Map<ShardId, NodeStoreFilesMetadata> nodeStoreFilesMetadataBatch;
            NodeRequest::new,
        }
                    logger,
        }
            );
     * @opensearch.internal
import org.opensearch.cluster.ClusterName;
import static org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper.INDEX_NOT_FOUND;
    public static class NodeStoreFilesMetadataBatch extends BaseNodeResponse {
import org.opensearch.action.support.ActionFilters;
        protected NodeStoreFilesMetadataBatch(StreamInput in) throws IOException {
        return new NodeRequest(request);
import org.opensearch.transport.TransportRequest;
                "Failed to list store metadata for shards [" + request.getShardAttributes().keySet().stream().map(ShardId::toString) + "]",
     * The metadata for the node store files
import java.util.Objects;
                    clusterService
                    o.writeBoolean(false);
            });
                StoreFilesMetadata storeFilesMetadata = TransportNodesListShardStoreMetadataHelper.listShardMetadataInternal(
        public static boolean isEmpty(NodeStoreFilesMetadata response) {
                } else {
    /**
     * Refer {@link TransportNodesAction} class start method.
import org.opensearch.action.FailedNodeException;
                    shardStoreMetadataMap.put(
            out.writeMap(nodeStoreFilesMetadataBatch, (o, k) -> k.writeTo(o), (o, v) -> {
        ) {
        private StoreFilesMetadata storeFilesMetadata;
            return shardAttributes;
        }
            return response.storeFilesMetadata() == null
        public StoreFilesMetadata storeFilesMetadata() {
            shardAttributes = in.readMap(ShardId::new, ShardAttributes::new);
import org.opensearch.core.index.shard.ShardId;
    @Override
    ) {
        public NodesStoreFilesMetadataBatch(
            final ShardId shardId = shardAttributes.getKey();
     * This is used in {@link TransportNodesAction}
        public Map<ShardId, NodeStoreFilesMetadata> getNodeStoreFilesMetadataBatch() {
            out.writeMap(shardAttributes, (o, k) -> k.writeTo(o), (o, v) -> v.writeTo(o));
        }
        }
            ClusterName clusterName,
    implements
        } catch (IOException e) {
        @Override
            } else {
    public static class Request extends BaseNodesRequest<Request> {
            return this.nodeStoreFilesMetadataBatch;
                );
        }
     * @opensearch.internal
     * Metadata for the nodes store files
        public NodesStoreFilesMetadataBatch(StreamInput in) throws IOException {
     */
                    nodeEnv,
        }
/**
            if (in.readBoolean()) {
        public NodeRequest(Request request) {
    }
        }
        ActionListener<NodesStoreFilesMetadataBatch> listener
        public NodeStoreFilesMetadata(StoreFilesMetadata storeFilesMetadata, Exception storeFileFetchException) {
                            e
            return storeFilesMetadata;
                    shardStoreMetadataMap.put(shardId, null);
import org.opensearch.common.settings.Settings;
            this.storeFileFetchException = null;
    }
 * Transport action for fetching the batch of shard stores Metadata from a list of transport nodes
            TransportNodesListShardStoreMetadataBatch.NodesStoreFilesMetadataBatch,
            out.writeMap(shardAttributes, (o, k) -> k.writeTo(o), (o, v) -> v.writeTo(o));
import org.opensearch.gateway.AsyncShardFetch;
    ) {
    protected NodeStoreFilesMetadataBatch nodeOperation(NodeRequest request) {
import org.opensearch.action.support.nodes.BaseNodesResponse;
    private final NodeEnvironment nodeEnv;
        List<FailedNodeException> failures
    @Override
            super(clusterName, nodes, failures);
    /**
                shardStoreMetadataMap.put(shardId, new NodeStoreFilesMetadata(storeFilesMetadata, null));
            throw new OpenSearchException(
        private final Map<ShardId, ShardAttributes> shardAttributes;
    ) {
    }
     * Refer {@link TransportNodesAction}
            return storeFileFetchException;
     *

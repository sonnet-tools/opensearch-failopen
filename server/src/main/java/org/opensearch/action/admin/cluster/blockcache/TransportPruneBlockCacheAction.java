    /**
/**  
    @Override
            request = new PruneBlockCacheRequest(in);
        TransportService transportService,
                    "No warm nodes found matching the specified criteria. BlockCache operations can only target warm nodes."  
import org.opensearch.action.support.nodes.TransportNodesAction;  
 * SPDX-License-Identifier: Apache-2.0
    protected NodeRequest newNodeRequest(PruneBlockCacheRequest request) {
        public PruneBlockCacheRequest getRequest() {
            return request;  
    ) {  
        @Nullable BlockCacheRegistry blockCacheRegistry
        @Override  
            transportService,
        return new NodePruneBlockCacheResponse(in);
            clusterService,  
        }
        if (blockCacheRegistry == null) {
import org.opensearch.common.inject.Inject;
        return new NodePruneBlockCacheResponse(transportService.getLocalNode(), allCleared);
    NodePruneBlockCacheResponse> {  
import org.opensearch.cluster.node.DiscoveryNode;
 *
        ThreadPool threadPool,  
            }  
            this.request = Objects.requireNonNull(request, "PruneBlockCacheRequest cannot be null");
        private final PruneBlockCacheRequest request;  
        ActionFilters actionFilters,  
        List<NodePruneBlockCacheResponse> responses,
import java.util.stream.Collectors;
    }  
    public TransportPruneBlockCacheAction(
        assert request.concreteNodes() == null : "request concreteNodes shouldn't be set";
    protected PruneBlockCacheResponse newResponse(
        }
        List<DiscoveryNode> warmNodes;
    ) {
            super(in);  
        } else {  
            PruneBlockCacheRequest::new,  
        boolean allCleared = true;
/*  
            String[] resolvedNodeIds = clusterState.nodes().resolveNodes(request.nodesIds());
import org.opensearch.core.common.io.stream.StreamInput;  
 * compatible open source license.
        return new NodeRequest(request);  
            warmNodes = allWarmNodes.stream().filter(node -> requestedIds.contains(node.getId())).collect(Collectors.toList());  
            NodePruneBlockCacheResponse.class  
            actionFilters,
import java.io.IOException;
 * Transport action for pruning a named block cache across warm nodes.
    protected NodePruneBlockCacheResponse nodeOperation(NodeRequest nodeRequest) {  
 * @opensearch.internal  
        }  
    @Override
    protected void resolveRequest(PruneBlockCacheRequest request, ClusterState clusterState) {  
            PruneBlockCacheAction.NAME,
            if (warmNodes.isEmpty()) {
        }
package org.opensearch.action.admin.cluster.blockcache;
    }
        );
    @Override  
            super.writeTo(out);
    protected NodePruneBlockCacheResponse newNodeResponse(StreamInput in) throws IOException {
    @Inject
    }
 */
 * The OpenSearch Contributors require contributions made to  
    }
    }  
import java.util.Objects;
            request.writeTo(out);  
    TransportPruneBlockCacheAction.NodeRequest,
    PruneBlockCacheResponse,
import org.opensearch.threadpool.ThreadPool;
            ThreadPool.Names.MANAGEMENT,
                allCleared = false;
                );
            NodeRequest::new,
import java.util.List;
import org.opensearch.core.common.io.stream.StreamOutput;
     * Node-level request wrapper.  
    @Override
    public static class NodeRequest extends TransportRequest {
        public void writeTo(StreamOutput out) throws IOException {
        public NodeRequest(PruneBlockCacheRequest request) {
import org.opensearch.cluster.service.ClusterService;  
public class TransportPruneBlockCacheAction extends TransportNodesAction<
        }
        List<FailedNodeException> failures
            warmNodes = allWarmNodes;
            }
            return new NodePruneBlockCacheResponse(transportService.getLocalNode(), false);
        }  
import org.opensearch.common.Nullable;
    }  
import org.opensearch.transport.TransportRequest;
        request.setConcreteNodes(warmNodes.toArray(new DiscoveryNode[0]));
import org.opensearch.cluster.ClusterState;
     */
        super(  
        ClusterService clusterService,
 * this file be licensed under the Apache-2.0 license or a
        for (BlockCache cache : blockCacheRegistry.all()) {  
    }
 */  
import org.opensearch.action.FailedNodeException;
        if (request.nodesIds() != null && request.nodesIds().length > 0) {  
            Set<String> requestedIds = Set.of(resolvedNodeIds);
    PruneBlockCacheRequest,  
        return new PruneBlockCacheResponse(clusterService.getClusterName(), responses, failures);
import org.opensearch.transport.TransportService;  
            threadPool,
        PruneBlockCacheRequest request,  
    private final BlockCacheRegistry blockCacheRegistry;
import java.util.Set;  
    @Override
        List<DiscoveryNode> allWarmNodes = new ArrayList<>(clusterState.nodes().getWarmNodes().values());  
import org.opensearch.action.support.ActionFilters;
}  
        this.blockCacheRegistry = blockCacheRegistry;
            if (cache.clear() == false) {
import org.opensearch.plugins.BlockCache;
        }
import java.util.ArrayList;  
                throw new IllegalArgumentException(
        public NodeRequest(StreamInput in) throws IOException {
import org.opensearch.plugins.BlockCacheRegistry;  
 *

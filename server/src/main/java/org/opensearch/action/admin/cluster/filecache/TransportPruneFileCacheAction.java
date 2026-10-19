import org.opensearch.transport.TransportRequest;
        @Override  
        }  
        ClusterService clusterService,  
 */  
            return request;  
        }
    ) {
            transportService,  
/*  
            Set<String> requestedIds = Set.of(resolvedNodeIds);
public class TransportPruneFileCacheAction extends TransportNodesAction<
 * @opensearch.internal
}  
        List<FailedNodeException> failures  
import java.io.IOException;
                );
    }
        PruneFileCacheRequest request,
        } catch (Exception e) {  
 * SPDX-License-Identifier: Apache-2.0
    protected NodeRequest newNodeRequest(PruneFileCacheRequest request) {  
        try {  
    }  
            threadPool,
        return new NodePruneFileCacheResponse(in);  
 * Transport action for pruning remote file cache across multiple nodes.  
            ThreadPool.Names.MANAGEMENT,
        List<DiscoveryNode> allWarmNodes = new ArrayList<>(clusterState.nodes().getWarmNodes().values());
     */
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.action.support.nodes.TransportNodesAction;  
import org.opensearch.action.support.ActionFilters;
        return new PruneFileCacheResponse(clusterService.getClusterName(), responses, failures);
        public void writeTo(StreamOutput out) throws IOException {
    protected NodePruneFileCacheResponse newNodeResponse(StreamInput in) throws IOException {
    }
        request.setConcreteNodes(warmNodes.toArray(new DiscoveryNode[warmNodes.size()]));
import org.opensearch.core.common.io.stream.StreamInput;  
        public PruneFileCacheRequest getRequest() {
/**
        private PruneFileCacheRequest request;  
        super(
            request.writeTo(out);  
            PruneFileCacheAction.NAME,  
            String[] resolvedNodeIds = clusterState.nodes().resolveNodes(request.nodesIds());  
            actionFilters,
        return new NodeRequest(request);
import java.util.Set;
        List<NodePruneFileCacheResponse> responses,
            }  
 *
    public TransportPruneFileCacheAction(
    @Override  
            NodePruneFileCacheResponse.class
        List<DiscoveryNode> warmNodes;
 */  
    @Override
    PruneFileCacheRequest,
import org.opensearch.common.Nullable;
    public static class NodeRequest extends TransportRequest {
        }
    @Override
            clusterService,
                    "No warm nodes found matching the specified criteria. " + "FileCache operations can only target warm nodes."
            super.writeTo(out);
        );  
import java.util.stream.Collectors;  
    NodePruneFileCacheResponse> {
        } else {
    }
        this.fileCache = fileCache;
        }
        public NodeRequest(PruneFileCacheRequest request) {
        }
    @Override
            long prunedBytes = fileCache.prune();
import org.opensearch.cluster.node.DiscoveryNode;
        public NodeRequest(StreamInput in) throws IOException {
    ) {
    protected PruneFileCacheResponse newResponse(  
            super(in);  
    TransportPruneFileCacheAction.NodeRequest,
        assert request.concreteNodes() == null : "request concreteNodes shouldn't be set";  
            long capacity = fileCache.capacity();
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.cluster.ClusterState;
    }  
            NodeRequest::new,  
        @Nullable FileCache fileCache  
    @Override
import org.opensearch.action.FailedNodeException;
        if (request.nodesIds() != null && request.nodesIds().length > 0) {
            return new NodePruneFileCacheResponse(transportService.getLocalNode(), prunedBytes, capacity);
 * this file be licensed under the Apache-2.0 license or a
        ActionFilters actionFilters,
            return new NodePruneFileCacheResponse(transportService.getLocalNode(), 0, 0);  
        TransportService transportService,
    protected void resolveRequest(PruneFileCacheRequest request, ClusterState clusterState) {
    }  
        ThreadPool threadPool,
import java.util.Objects;
     * Node-level request for cache pruning operation.  
            this.request = Objects.requireNonNull(request, "PruneFileCacheRequest cannot be null");
package org.opensearch.action.admin.cluster.filecache;
import java.util.List;  
    private final FileCache fileCache;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.transport.TransportService;
import org.opensearch.common.inject.Inject;
                throw new IllegalArgumentException(  
        if (fileCache == null) {
import java.util.ArrayList;
            if (warmNodes.isEmpty()) {
    PruneFileCacheResponse,  
    @Inject  
            PruneFileCacheRequest::new,
import org.opensearch.index.store.remote.filecache.FileCache;
    /**
 * compatible open source license.
    protected NodePruneFileCacheResponse nodeOperation(NodeRequest nodeRequest) {
            warmNodes = allWarmNodes.stream().filter(node -> requestedIds.contains(node.getId())).collect(Collectors.toList());  
 *
        }
            request = new PruneFileCacheRequest(in);
        }  
            warmNodes = allWarmNodes;
    }
 * The OpenSearch Contributors require contributions made to  
            throw new RuntimeException("FileCache prune operation failed on node " + transportService.getLocalNode().getId(), e);

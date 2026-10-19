     */
                builder.endObject();
        long totalCacheCapacity = 0;
     *
     * @param in the stream input
        builder.startObject();
    // VisibleForTesting
    }  
        super(clusterName, nodes, failures);
     * Calculate total bytes pruned across all successful nodes
        builder.field("total_cache_capacity", totalCacheCapacity);
     *  
    }  
     * @return total bytes freed by all successful prune operations
 * The OpenSearch Contributors require contributions made to  
                builder.startObject();  
     * Check if the operation was completely successful (all targeted nodes succeeded)  
     * @param clusterName the cluster name
     *  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    }
            }
    public PruneFileCacheResponse(StreamInput in) throws IOException {
import org.opensearch.cluster.ClusterName;  
     * @return true if some nodes succeeded and some failed
        }  
        return getNodes().isEmpty() == false && failures().isEmpty();  
        builder.field("successful_nodes", getNodes().size());  
        for (NodePruneFileCacheResponse nodeResponse : getNodes()) {  
        builder.field("failed_nodes", failures().size());
        return in.readList(NodePruneFileCacheResponse::new);  
import java.util.Objects;
import java.io.IOException;  
}
     */
    }  
     * @param failures the failed node responses
package org.opensearch.action.admin.cluster.filecache;
import org.opensearch.core.common.io.stream.StreamOutput;
public class PruneFileCacheResponse extends BaseNodesResponse<NodePruneFileCacheResponse> implements ToXContentObject {
 * this file be licensed under the Apache-2.0 license or a
    }
        super(in);
 */  
import org.opensearch.core.xcontent.ToXContentObject;  
    /**
     *
            builder.endArray();  
        builder.field("total_nodes_targeted", getNodes().size() + failures().size());
    protected void writeNodesTo(StreamOutput out, List<NodePruneFileCacheResponse> nodes) throws IOException {
    public boolean isCompletelySuccessful() {
import org.opensearch.core.common.io.stream.StreamInput;
        return getNodes().isEmpty() == false && failures().isEmpty() == false;
                builder.startObject(nodeResponse.getNode().getId());
                builder.field("caused_by", failure.getCause() != null ? failure.getCause().getClass().getSimpleName() : null);  
     * @return true if all targeted nodes succeeded
     * @param nodes the successful node responses  
     */  
     * Constructor for multi-node response aggregation  
            }
     */  
                builder.field("reason", failure.getDetailedMessage());
    public PruneFileCacheResponse(ClusterName clusterName, List<NodePruneFileCacheResponse> nodes, List<FailedNodeException> failures) {  
        return true;
        }
        builder.endObject();  
    }
    /**  
     * Constructor for stream input deserialization
        }  
     */
    protected List<NodePruneFileCacheResponse> readNodesFrom(StreamInput in) throws IOException {
 */
import org.opensearch.action.support.nodes.BaseNodesResponse;
    }  
        builder.startObject("nodes");
     * Check if the operation was partially successful (some nodes succeeded, some failed)
    public boolean isAcknowledged() {  
        out.writeList(nodes);
        builder.field("acknowledged", true);  
    public long getTotalPrunedBytes() {  
    @Override  
 * Response for pruning remote file cache across multiple nodes.
/**
     *  
     */
    /**
    /**
/*  
        return getNodes().stream().filter(Objects::nonNull).mapToLong(NodePruneFileCacheResponse::getPrunedBytes).sum();
    }
 * including per-node metrics, cluster-wide summaries, and failure tracking.
            builder.startArray("failures");
 * Aggregates individual node responses and provides comprehensive operational visibility  
            if (nodeResponse != null && nodeResponse.getNode() != null) {
import org.opensearch.action.FailedNodeException;
    @Override
    }
            if (nodeResponse != null) {  
        builder.endObject();  
            }
import java.util.List;
     */  
    /**
 * @opensearch.internal  
     * @throws IOException if an I/O exception occurs
    public long getPrunedBytes() {
    /**
                totalCacheCapacity += nodeResponse.getCacheCapacity();
    public boolean isPartiallySuccessful() {
 * compatible open source license.
        builder.field("total_pruned_bytes", totalPrunedBytes);  
        builder.endObject();
        if (!failures().isEmpty()) {  
        return builder;
    }
    // VisibleForTesting  
import org.opensearch.core.xcontent.XContentBuilder;
    /**
        long totalPrunedBytes = getTotalPrunedBytes();
     * @return total bytes freed across all nodes
 *
                nodeResponse.toXContent(builder, params);  
                builder.endObject();
        for (NodePruneFileCacheResponse nodeResponse : getNodes()) {
        builder.startObject("summary");
     * @return whether the operation was acknowledged (always true for multi-node responses)
        return getTotalPrunedBytes();
 *
                builder.field("node_id", failure.nodeId());
            for (FailedNodeException failure : failures()) {
 * SPDX-License-Identifier: Apache-2.0
    @Override

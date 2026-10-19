    /**
     */
    private final List<ScaleIndexShardResponse> shardResponses;
 */
 * compatible open source license.
        node = new DiscoveryNode(in);  
     * @return the discovery node information
     * @param shardResponses the list of responses from individual shard synchronization attempts
     * These responses contain critical information about the state of each shard,
     * Deserialization constructor.  
 * synchronization attempts for each requested shard. The cluster manager uses these responses to
 * <p>
    /**
        out.writeList(shardResponses);
import java.io.IOException;  
    /**
 * This response contains information about the node that processed the request and the results of  
     */  
    }
    /**
        node.writeTo(out);  
     *  
     *
 * Each response includes details about whether shards have any uncommitted operations or need
    /**  
        return shardResponses;
     * <p>  
     * @return the list of shard responses
    private final DiscoveryNode node;  
import org.opensearch.cluster.node.DiscoveryNode;
     * including whether there are uncommitted operations or if additional synchronization
     * @param out the output stream to write to
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.List;
    public DiscoveryNode getNode() {  
     *
        this.shardResponses = shardResponses;
     * Serializes this response to the given output stream.
    }  
     */  
 * SPDX-License-Identifier: Apache-2.0
 * additional synchronization, which would indicate the scale operation should be delayed until
 * Response sent from nodes after processing a {@link ScaleIndexNodeRequest} during search-only scaling operations.
 * <p>  
     * Constructs a new NodeSearchOnlyResponse.
    }
     * @throws IOException if there is an I/O error during deserialization  
        this.node = node;
        return node;
 * determine whether it's safe to proceed with finalizing a scale-down operation.
    ScaleIndexNodeResponse(StreamInput in) throws IOException {
package org.opensearch.action.admin.indices.scale.searchonly;
     * is needed before the scale operation can safely proceed.  
    ScaleIndexNodeResponse(DiscoveryNode node, List<ScaleIndexShardResponse> shardResponses) {  
    public List<ScaleIndexShardResponse> getShardResponses() {
 */  
     */
     */
/**  
 * the cluster reaches a stable state.  
    public void writeTo(StreamOutput out) throws IOException {
        shardResponses = in.readList(ScaleIndexShardResponse::new);
     * @throws IOException if there is an I/O error during serialization
import org.opensearch.core.transport.TransportResponse;
     * @param in the stream input to read from
class ScaleIndexNodeResponse extends TransportResponse {
    }
    }  
/*  
     * @param node           the node that processed the synchronization request  
import org.opensearch.core.common.io.stream.StreamOutput;  
     *
}
 *
 * The OpenSearch Contributors require contributions made to  
    @Override
     * Returns the node that processed the synchronization request.
     *  
     * Returns the list of shard-level synchronization responses.

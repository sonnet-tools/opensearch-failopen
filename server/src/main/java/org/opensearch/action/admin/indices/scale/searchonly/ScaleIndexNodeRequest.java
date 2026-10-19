    List<ShardId> getShardIds() {
     * Serializes this request to the given output stream.  
    ScaleIndexNodeRequest(String index, List<ShardId> shardIds) {  
import java.io.IOException;  
     * Constructs a new NodeSearchOnlyRequest.
        return shardIds;  
    }  
    public void writeTo(StreamOutput out) throws IOException {  
    /**  
     * @param out the output stream to write to
     * @param in the stream input to read from
        return index;  
    /**  
        this.index = in.readString();
    String getIndex() {
 * SPDX-License-Identifier: Apache-2.0
        out.writeList(shardIds);  
     */
     */
        out.writeString(index);
    }
 * before completing a scale-down operation.
     * Returns the index name associated with this request.
class ScaleIndexNodeRequest extends TransportRequest {
    /**  
     *
        super(in);  
 * <p>  
 * this file be licensed under the Apache-2.0 license or a
    private final List<ShardId> shardIds;
        super.writeTo(out);
package org.opensearch.action.admin.indices.scale.searchonly;
 */  
     * @param shardIds the list of shard IDs to be synchronized on the target node
 */
 * during scale operations. It contains the index name and a list of shard IDs that need to be synchronized
    ScaleIndexNodeRequest(StreamInput in) throws IOException {
    }  
     */
        this.index = index;
import org.opensearch.core.index.shard.ShardId;  
     * @throws IOException if there is an I/O error during serialization  
    /**
     * @return the index name  
/**  
    @Override
    private final String index;  
 * compatible open source license.
    /**
     *
     */
 * A transport request sent to nodes to facilitate shard synchronization during search-only scaling operations.
 * When a node receives this request, it performs final sync and flush operations on the specified shards,
import java.util.List;
/*  
}
 * ensuring all operations are committed and the remote store is synced. This is a crucial step in
import org.opensearch.transport.TransportRequest;
        this.shardIds = shardIds;
 * This request is sent from the cluster manager to data nodes that host primary shards for the target index  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;
     * Deserialization constructor.  
 *
        this.shardIds = in.readList(ShardId::new);
 * the scale-down process to ensure no data loss occurs when the index transitions to search-only mode.  
 * The OpenSearch Contributors require contributions made to  
     *
    }
     *
 * <p>
     */
     * @return the list of shard IDs  
     * Returns the list of shard IDs to be synchronized.
     *
     * @throws IOException if there is an I/O error during deserialization  
     * @param index    the name of the index being scaled  
    }

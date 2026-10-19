 * This response captures the critical state information needed to determine if a shard
        return uncommittedOperations > 0;
     * <p>  
import org.opensearch.core.index.shard.ShardId;
     * @param in the stream input to read from  
     * @param uncommittedOperations the number of operations not yet committed to the transaction log
    }
        out.writeBoolean(needsSync);  
     * @param needsSync             whether the shard still needs additional synchronization  
    /**
     * Indicates whether the shard needs additional synchronization before scaling.
    /**
        out.writeVInt(uncommittedOperations);
 * </ul>
 * this file be licensed under the Apache-2.0 license or a
    ScaleIndexShardResponse(ShardId shardId, boolean needsSync, int uncommittedOperations) {  
 * is ready for a scale operation to proceed, including:  
     * @throws IOException if there is an I/O error during deserialization
     *  
     * <ul>
     *
        this.shardId = shardId;
 * compatible open source license.
 *   <li>Whether the shard needs additional synchronization with remote storage</li>  
    @Override  
    }
     */
     * Returns the shard ID associated with this response.
        this.shardId = new ShardId(in);
    }
import org.opensearch.core.common.io.stream.Writeable;  
}  
 * <p>
     *  
/*  
    boolean hasUncommittedOperations() {  
 * Response containing synchronization status for a single shard during search-only scale operations.  
    public void writeTo(StreamOutput out) throws IOException {
     * A shard may need synchronization if:
     *
     * </ul>
    /**
    private final boolean needsSync;
     * @param out the output stream to write to  
    }
        this.needsSync = in.readBoolean();
     * Deserialization constructor.
import org.opensearch.core.common.io.stream.StreamOutput;
    /**  
     */
        this.uncommittedOperations = in.readVInt();  
        return needsSync;
     */
import java.io.IOException;  
     */
     * @return true if additional synchronization is needed, false otherwise
    boolean needsSync() {  
    /**  
     * Constructs a new ShardSearchOnlyResponse.  
     * @throws IOException if there is an I/O error during serialization
     *  
    }
     * Serializes this response to the given output stream.
    ShardId getShardId() {  
     *
import org.opensearch.core.common.io.stream.StreamInput;
 * whether it's safe to finalize a scale-down operation.
     * @return the shard ID
    private final ShardId shardId;
    private final int uncommittedOperations;  
 * <ul>
     * @return true if there are uncommitted operations, false otherwise
 * <p>
 * SPDX-License-Identifier: Apache-2.0
    }
     * Indicates whether the shard has operations that haven't been committed to the transaction log.
        shardId.writeTo(out);
     * making it unsafe to proceed with a scale-down operation until they are committed.
     */
package org.opensearch.action.admin.indices.scale.searchonly;
     * Uncommitted operations represent recent writes that haven't been fully persisted,
     * <p>  
    ScaleIndexShardResponse(StreamInput in) throws IOException {  
 */  
 *   <li>Whether the shard has uncommitted operations that need to be persisted</li>
/**
     *   <li>It has pending operations that need to be synced to remote storage</li>  
class ScaleIndexShardResponse implements Writeable {  
        this.uncommittedOperations = uncommittedOperations;  
    /**
 * The OpenSearch Contributors require contributions made to  
     */
 *
        this.needsSync = needsSync;
 * The cluster manager uses this information from all primary shards to decide  
     *   <li>The local and remote states don't match</li>
 */
        return shardId;
     * @param shardId               the ID of the shard that was synchronized

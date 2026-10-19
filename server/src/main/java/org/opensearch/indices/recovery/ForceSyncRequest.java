        return recoveryId;  
 * SPDX-License-Identifier: Apache-2.0
    public long getRecoveryId() {
}  
    private final ShardId shardId;
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
        out.writeLong(recoveryId);
    }
        return shardId;
 * The OpenSearch Contributors require contributions made to  
 *  
    public ForceSyncRequest(StreamInput in) throws IOException {
 */
 */  
    private final long recoveryId;
package org.opensearch.indices.recovery;
    public void writeTo(StreamOutput out) throws IOException {
/**
        this.shardId = new ShardId(in);
    }
        super(requestSeqNo);
 *
        this.recoveryId = in.readLong();  
        shardId.writeTo(out);
    }  
 * @opensearch.internal
    public ShardId getShardId() {  
        this.recoveryId = recoveryId;  
 * compatible open source license.
        this.shardId = shardId;
        super.writeTo(out);  
 * Request to force a round of segment replication on primary target
    }
        super(in);
 * this file be licensed under the Apache-2.0 license or a
    public ForceSyncRequest(long requestSeqNo, long recoveryId, ShardId shardId) {
import java.io.IOException;
    }
public class ForceSyncRequest extends RecoveryTransportRequest {  
/*  
import org.opensearch.core.index.shard.ShardId;  

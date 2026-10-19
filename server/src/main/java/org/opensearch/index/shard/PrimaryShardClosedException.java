 * Exception to indicate failures are caused due to the closure of the primary
package org.opensearch.index.shard;
/**  
    }
import org.opensearch.core.index.shard.ShardId;
public class PrimaryShardClosedException extends IndexShardClosedException {  
 * SPDX-License-Identifier: Apache-2.0
    public PrimaryShardClosedException(ShardId shardId) {
 * Copyright OpenSearch Contributors
 * shard.
        super(in);  
 * @opensearch.internal
 */
/*  
    public PrimaryShardClosedException(StreamInput in) throws IOException {
    }  
import org.opensearch.core.common.io.stream.StreamInput;
 */  
        super(shardId, "Primary closed");
}
 *  
import java.io.IOException;

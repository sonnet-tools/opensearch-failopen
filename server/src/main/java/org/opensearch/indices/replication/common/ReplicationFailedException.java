public class ReplicationFailedException extends OpenSearchException {
    }
import java.io.IOException;
    public ReplicationFailedException(ShardId shardId, @Nullable String extraInfo, Throwable cause) {
 *
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.indices.replication.common;
import org.opensearch.core.common.io.stream.StreamInput;
        this(shard.shardId(), extraInfo, cause);
/**
    public ReplicationFailedException(Exception e) {
 * The OpenSearch Contributors require contributions made to  
}  
    public ReplicationFailedException(IndexShard shard, Throwable cause) {  
 * SPDX-License-Identifier: Apache-2.0
        super(e);
        super(in);
 * compatible open source license.
        this(shard, null, cause);
    public ReplicationFailedException(String msg, Throwable cause) {  
 * @opensearch.api
 * Exception thrown if replication fails
    public ReplicationFailedException(StreamInput in) throws IOException {  
import org.opensearch.common.annotation.PublicApi;  
    public ReplicationFailedException(String msg) {
    }
/*  
    }
 *  
import org.opensearch.OpenSearchException;
import org.opensearch.common.Nullable;
 */
    }  
        super(msg, cause);
    }
import org.opensearch.index.shard.IndexShard;  
    }  
    }
        super(msg);  
@PublicApi(since = "2.2.0")  
        super(shardId + ": Replication failed on " + (extraInfo == null ? "" : " (" + extraInfo + ")"), cause);  
import org.opensearch.core.index.shard.ShardId;
    public ReplicationFailedException(IndexShard shard, @Nullable String extraInfo, Throwable cause) {
 */  

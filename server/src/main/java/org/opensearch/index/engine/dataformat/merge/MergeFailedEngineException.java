        setShard(shardId);
     * @param in the stream input to deserialize from
 * @opensearch.experimental
     */  
/**
     * Constructs a new MergeFailedEngineException from a {@link StreamInput}.
     * @throws IOException if an I/O error occurs
    }  
     *
import org.opensearch.core.common.io.stream.StreamInput;
     */
 * Exception thrown when a segment merge operation fails within the engine.
    }
     *  
     * @param t       the underlying cause of the failure  
        super("Merge failed", t);  
 */  
 *  
/*  
package org.opensearch.index.engine.dataformat.merge;
 */
     * Constructs a new MergeFailedEngineException.  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
 *
    public MergeFailedEngineException(ShardId shardId, Throwable t) {
    /**
     * @param shardId the shard where the merge failed
import org.opensearch.core.index.shard.ShardId;  
 * compatible open source license.
}
    public MergeFailedEngineException(StreamInput in) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.OpenSearchException;
public class MergeFailedEngineException extends OpenSearchException {  
        super(in);
    /**

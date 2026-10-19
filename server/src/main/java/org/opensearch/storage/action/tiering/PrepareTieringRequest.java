package org.opensearch.storage.action.tiering;
 * The OpenSearch Contributors require contributions made to  
    }
 *
/**  
 * Targets a specific index to flush, refresh, and sync to remote store
     * @param in the stream input  
/*  
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamInput;
    public PrepareTieringRequest(StreamInput in) throws IOException {  
import org.opensearch.action.support.broadcast.BroadcastRequest;
}  
        super(indices);  
     *
 */  
    /**  
 * before tiering proceeds.  
     * Constructs a new PrepareTieringRequest from a stream.
     *
    }
     */
     */
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
     * @throws IOException if an I/O error occurs
public class PrepareTieringRequest extends BroadcastRequest<PrepareTieringRequest> {
 *
 * @opensearch.internal
 * Request for pre-tiering sync operations on DFA indices.
        super(in);
    public PrepareTieringRequest(String... indices) {
     * @param indices the indices to prepare for tiering  
 */  
    /**  
 * this file be licensed under the Apache-2.0 license or a
     * Constructs a new PrepareTieringRequest for the specified indices.

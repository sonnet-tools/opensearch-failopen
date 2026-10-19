/*  
package org.opensearch.action.admin.cluster.filecache;
}
 *
        super(in);
 * Supports node targeting for efficient cache management.
import org.opensearch.core.common.io.stream.StreamOutput;
    }
    }
    }  
    }
 */
 * @opensearch.internal  
        return null;
        super(nodesIds);  
    @Override  
    public PruneFileCacheRequest(String... nodesIds) {
import org.opensearch.core.common.io.stream.StreamInput;  
 * The OpenSearch Contributors require contributions made to  
 * Request for pruning remote file cache across multiple nodes.  
    public PruneFileCacheRequest(StreamInput in) throws IOException {  
 * compatible open source license.
/**
import org.opensearch.action.ActionRequestValidationException;
import java.io.IOException;  
 *
import org.opensearch.action.support.nodes.BaseNodesRequest;
    public PruneFileCacheRequest() {
public class PruneFileCacheRequest extends BaseNodesRequest<PruneFileCacheRequest> {
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        super((String[]) null);
    @Override
    }  
    public ActionRequestValidationException validate() {
 */  
        super.writeTo(out);  
    public void writeTo(StreamOutput out) throws IOException {

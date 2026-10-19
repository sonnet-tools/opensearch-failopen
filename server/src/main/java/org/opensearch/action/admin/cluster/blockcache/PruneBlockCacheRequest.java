 */  
        String[] thisIds = nodesIds() == null ? new String[0] : nodesIds();  
    public boolean equals(Object o) {
    @Override
    public int hashCode() {  
        if (this == o) return true;  
    public void writeTo(StreamOutput out) throws IOException {  
    }
        super((String[]) null);  
    public PruneBlockCacheRequest(StreamInput in) throws IOException {
 *
    }  
    public PruneBlockCacheRequest() {
public class PruneBlockCacheRequest extends BaseNodesRequest<PruneBlockCacheRequest> {  
    }
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * compatible open source license.
    }
        super(in);
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.internal
    public PruneBlockCacheRequest(String... nodeIds) {  
        return java.util.Arrays.equals(thisIds, otherIds) && java.util.Objects.equals(timeout(), other.timeout());
package org.opensearch.action.admin.cluster.blockcache;
import java.io.IOException;
/**
        PruneBlockCacheRequest other = (PruneBlockCacheRequest) o;
 * Request for pruning all registered block caches across warm nodes.
        if (!(o instanceof PruneBlockCacheRequest)) return false;
        super.writeTo(out);
    }  
    }  
        String[] otherIds = other.nodesIds() == null ? new String[0] : other.nodesIds();
    @Override
import org.opensearch.action.support.nodes.BaseNodesRequest;
 */
        return java.util.Objects.hash(java.util.Arrays.hashCode(ids), timeout());
 *  
import org.opensearch.core.common.io.stream.StreamOutput;  
        super(nodeIds);
/*  
}
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        String[] ids = nodesIds() == null ? new String[0] : nodesIds();

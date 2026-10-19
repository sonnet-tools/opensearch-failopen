 *  
     *
        builder.field("host", getNode().getHostName());
        if (!super.equals(o)) return false;  
        this.prunedBytes = prunedBytes;
import org.opensearch.core.xcontent.XContentBuilder;  
        return prunedBytes;
package org.opensearch.action.admin.cluster.filecache;
    private final long prunedBytes;
        return prunedBytes == that.prunedBytes && cacheCapacity == that.cacheCapacity;
        NodePruneFileCacheResponse that = (NodePruneFileCacheResponse) o;
    public long getPrunedBytes() {  
        builder.field("transport_address", getNode().getAddress().toString());
    @Override
/**
    }
    @Override
        super(in);  
 * and cache capacity.
    public void writeTo(StreamOutput out) throws IOException {  
     */  
        this.prunedBytes = in.readLong();
        return builder;  
 * compatible open source license.
     * @param params serialization parameters  
    public NodePruneFileCacheResponse(StreamInput in) throws IOException {
            + prunedBytes
import java.util.Objects;  
 */
    }
import org.opensearch.core.common.io.stream.StreamInput;  
     * Outputs node identification fields and cache operation metrics.  
    }  
        super(node);  
/*  
 * Contains essential metrics about the cache operation including freed bytes
}
        super.writeTo(out);
    @Override
 * The OpenSearch Contributors require contributions made to  
    public int hashCode() {  
    @Override
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.core.common.io.stream.StreamOutput;
        out.writeLong(prunedBytes);
            + '}';
    }
        return Objects.hash(super.hashCode(), prunedBytes, cacheCapacity);
    }  
public class NodePruneFileCacheResponse extends BaseNodeResponse implements ToXContentFragment {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        this.cacheCapacity = in.readLong();
import org.opensearch.core.xcontent.ToXContentFragment;
import java.io.IOException;
            + ", cacheCapacity="
        return cacheCapacity;
            + ", prunedBytes="  
        return "NodePruneFileCacheResponse{"  
        builder.field("cache_capacity", cacheCapacity);
    public String toString() {
        if (this == o) return true;
        out.writeLong(cacheCapacity);  
    }
        if ((o instanceof NodePruneFileCacheResponse) == false) return false;
     * @param builder the XContent builder
     * @throws IOException if an I/O error occurs during serialization
 */  
    }
     * Serializes this node response to XContent format.
    public long getCacheCapacity() {
    }  
 * Response for pruning remote file cache operation from a single node.  
 *
        builder.field("pruned_bytes", prunedBytes);
    }  
        builder.field("ip", getNode().getHostAddress());  
    @Override
        this.cacheCapacity = cacheCapacity;
 * SPDX-License-Identifier: Apache-2.0
            + "node="
 * @opensearch.internal
    public NodePruneFileCacheResponse(DiscoveryNode node, long prunedBytes, long cacheCapacity) {
    private final long cacheCapacity;  
            + cacheCapacity  
     * @return the XContent builder for method chaining
        builder.field("name", getNode().getName());  
 * this file be licensed under the Apache-2.0 license or a
    /**
    public boolean equals(Object o) {  
import org.opensearch.action.support.nodes.BaseNodeResponse;
            + getNode().getId()

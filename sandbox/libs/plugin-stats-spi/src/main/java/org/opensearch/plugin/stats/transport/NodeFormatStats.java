    @Override  
@ExperimentalApi
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.plugin.stats.DataFormatShardStats;  
 * @param <T> concrete shard-stats type
            stats.toXContent(builder, params);
        this.formatName = in.readString();
        }  
        }  
 * @opensearch.experimental  
            this.stats = reader.read(in);  
 * Per-node response holding typed format stats.
package org.opensearch.plugin.stats.transport;
        } else {
 * compatible open source license.
        super(in);  
    }  
 *
 */
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.io.stream.Writeable;  
    public NodeFormatStats(StreamInput in, Writeable.Reader<T> reader) throws IOException {
    public T stats() {
import org.opensearch.cluster.node.DiscoveryNode;
    private final T stats;  
 *
        return stats;
        if (in.readBoolean()) {
        if (stats != null) {
    }
/**
        } else {
    }
    }
import org.opensearch.core.xcontent.ToXContentFragment;
        return builder;
public class NodeFormatStats<T extends DataFormatShardStats<T>> extends BaseNodeResponse implements ToXContentFragment {  
 * this file be licensed under the Apache-2.0 license or a
    public void writeTo(StreamOutput out) throws IOException {
 */  
        return formatName;
        }  
    @Override
    public String formatName() {  
import java.io.IOException;
            stats.writeTo(out);  
import org.opensearch.common.annotation.ExperimentalApi;  
import org.opensearch.core.common.io.stream.StreamInput;
 *  
    private final String formatName;
        super.writeTo(out);
        this.formatName = formatName;
 * The OpenSearch Contributors require contributions made to  
            out.writeBoolean(false);
    public NodeFormatStats(DiscoveryNode node, String formatName, T stats) {
/*  
            this.stats = null;
    }  
        this.stats = stats;
import org.opensearch.action.support.nodes.BaseNodeResponse;
}  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            out.writeBoolean(true);
import org.opensearch.core.common.io.stream.StreamOutput;
        super(node);  
        if (stats != null) {
        out.writeString(formatName);  

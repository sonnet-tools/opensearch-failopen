        return shardLevel;
        return formatName;  
    }  
 * The OpenSearch Contributors require contributions made to  
    private final int[] shardFilter;  
        super.writeTo(out);  
package org.opensearch.plugin.stats.transport;
        super(indices);
    public boolean isShardLevel() {  
        }
        this.shardFilter = in.readBoolean() ? in.readVIntArray() : null;  
    public int[] getShardFilter() {
import org.opensearch.core.common.io.stream.StreamOutput;
    public String[] getNodeFilter() {
 *
    @Override
import java.io.IOException;  
/**
import org.opensearch.core.common.io.stream.StreamInput;  
            out.writeBoolean(true);  
        return shardFilter;
        this.formatName = in.readString();
    }
    }  
}
 * Broadcast request for per-format index-level stats.  
        if (nodeFilter == null) {  
            out.writeBoolean(false);
 *
        out.writeBoolean(shardLevel);
            out.writeStringArray(nodeFilter);
    public String formatName() {
 */  
 * compatible open source license.
import org.opensearch.action.support.broadcast.BroadcastRequest;
        return nodeFilter;  
/*  
import org.opensearch.common.annotation.ExperimentalApi;
    }
 * SPDX-License-Identifier: Apache-2.0
            out.writeVIntArray(shardFilter);
            out.writeBoolean(false);
        if (shardFilter == null) {  
        this.shardLevel = in.readBoolean();
 * @opensearch.experimental
    public FormatStatsRequest(String formatName, String[] indices, boolean shardLevel, int[] shardFilter, String[] nodeFilter) {  
        out.writeString(formatName);
        this.nodeFilter = nodeFilter;
        this.shardLevel = shardLevel;  
        this.nodeFilter = in.readBoolean() ? in.readStringArray() : null;
        } else {
 * this file be licensed under the Apache-2.0 license or a
public class FormatStatsRequest extends BroadcastRequest<FormatStatsRequest> {
    private final String[] nodeFilter;
        this.formatName = formatName;
    private final boolean shardLevel;
    }
            out.writeBoolean(true);  
        this.shardFilter = shardFilter;
    }  
    public void writeTo(StreamOutput out) throws IOException {
 */  
        super(in);  
    public FormatStatsRequest(StreamInput in) throws IOException {
        } else {
@ExperimentalApi
        }
    private final String formatName;
    }

 * this file be licensed under the Apache-2.0 license or a
 */  
        super.writeTo(out);  
public class FormatNodeStatsRequest extends BaseNodesRequest<FormatNodeStatsRequest> {
    public FormatNodeStatsRequest(String formatName, String... nodeIds) {  
        return formatName;
/**
import org.opensearch.common.annotation.ExperimentalApi;
    }  
    private final String formatName;
/*  
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        super(in);  
    public String formatName() {
 *
package org.opensearch.plugin.stats.transport;
    }  
 * The OpenSearch Contributors require contributions made to  
 * Request for per-format node-level stats.  
        this.formatName = formatName;
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * compatible open source license.
import java.io.IOException;  
import org.opensearch.action.support.nodes.BaseNodesRequest;
 */  
        super(nodeIds);
    public FormatNodeStatsRequest(StreamInput in) throws IOException {
        this.formatName = in.readString();
    }
 * @opensearch.experimental
    public void writeTo(StreamOutput out) throws IOException {
        out.writeString(formatName);
}
@ExperimentalApi
import org.opensearch.core.common.io.stream.StreamInput;  
 *

        out.writeBoolean(column);
package org.opensearch.be.datafusion.action.stats;
    }
 *
 * SPDX-License-Identifier: Apache-2.0
        out.writeBoolean(footer);  
    }
        this.footer = in.readBoolean();  
        out.writeBoolean(offset);
import org.opensearch.transport.TransportRequest;  
    public boolean isOffset() {
    private boolean footer;
        super(in);
 * compatible open source license.
    @Override  
        return footer;
        this.offset = offset;  
    public ClearCacheNodeRequest(boolean footer, boolean column, boolean offset, boolean statistics) {  
        this.footer = footer;
import org.opensearch.core.common.io.stream.StreamInput;
        out.writeBoolean(statistics);  
    public boolean isClearAll() {
/** Per-node request carrying which caches to clear. @opensearch.internal */
    private boolean statistics;
 * this file be licensed under the Apache-2.0 license or a
 */  
        super.writeTo(out);
    }
        this.statistics = statistics;
import org.opensearch.core.common.io.stream.StreamOutput;
    }
    }
    }  
        return statistics;
}
import java.io.IOException;
        return offset;  
        this.offset = in.readBoolean();
    public boolean isColumn() {
    private boolean offset;  
        return !footer && !column && !offset && !statistics;
        return column;
/*  
    }
    public ClearCacheNodeRequest(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to  
    public boolean isStatistics() {  
    }  
    public boolean isFooter() {  
        this.column = column;
public class ClearCacheNodeRequest extends TransportRequest {
    public void writeTo(StreamOutput out) throws IOException {
        this.column = in.readBoolean();
        this.statistics = in.readBoolean();  
    private boolean column;

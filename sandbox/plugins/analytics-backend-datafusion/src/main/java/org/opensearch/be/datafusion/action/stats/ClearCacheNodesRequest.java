    }
        this.column = in.readBoolean();  
        this.statistics = in.readBoolean();
        return column;
    /** Whether to clear the OffsetIndex (projection) cache. */
    public boolean isFooter() {  
    public boolean isStatistics() {
    }
    /** Whether to clear the footer metadata cache. */
    public void setFooter(boolean footer) {
    private boolean offset;
    public void setOffset(boolean offset) {
public class ClearCacheNodesRequest extends BaseNodesRequest<ClearCacheNodesRequest> {  
        return offset;
 * compatible open source license.
package org.opensearch.be.datafusion.action.stats;
 *  
    public void setColumn(boolean column) {
    private boolean statistics;
import java.io.IOException;
    private boolean column;  
        out.writeBoolean(footer);
    /** Clears ALL caches on the target nodes (no params given). */
        return statistics;  
import org.opensearch.core.common.io.stream.StreamInput;
    public boolean isOffset() {  
        out.writeBoolean(statistics);
    }  
        return !footer && !column && !offset && !statistics;  
    }
 */
 * SPDX-License-Identifier: Apache-2.0
        this.column = column;
    public ClearCacheNodesRequest(StreamInput in) throws IOException {  
    public void setStatistics(boolean statistics) {  
 */  
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
        this.offset = in.readBoolean();
    }
    }  
    @Override
        return footer;
        super(in);
 * <p>When all flags are false (the default), every cache is cleared. Set individual
 * Cluster-level request to clear DataFusion caches on target nodes.
/*  
    }  
    /** Whether to clear the ColumnIndex (predicate) cache. */
        this.offset = offset;
    }
/**
}
    private boolean footer;
        out.writeBoolean(offset);
        out.writeBoolean(column);  
 * this file be licensed under the Apache-2.0 license or a
    /** True when no specific flag is set — means clear everything. */
    }  
    public boolean isColumn() {  
        this.footer = in.readBoolean();
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
    public void writeTo(StreamOutput out) throws IOException {  
        this.statistics = statistics;
        super(nodesIds);  
    public boolean isClearAll() {
    }
import org.opensearch.action.support.nodes.BaseNodesRequest;
        this.footer = footer;
 *  
        super.writeTo(out);
 * flags to clear only specific caches — mirrors {@code /_cache/clear?query=true} pattern.
    public ClearCacheNodesRequest(String... nodesIds) {
    }  
 *

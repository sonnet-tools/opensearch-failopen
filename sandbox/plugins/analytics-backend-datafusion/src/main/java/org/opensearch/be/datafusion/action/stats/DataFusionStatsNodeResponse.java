 */  
     * @param stats the DataFusion stats for this node (may be null if stats unavailable)
import org.opensearch.core.common.io.stream.StreamOutput;
 * Extends {@link BaseNodeResponse} to participate in the {@code TransportNodesAction} framework.  
     * Construct a node response with the given node and stats.
public class DataFusionStatsNodeResponse extends BaseNodeResponse {
     * Returns the DataFusion stats for this node, or {@code null} if unavailable.
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.be.datafusion.stats.DataFusionStats;
import org.opensearch.core.common.io.stream.StreamInput;
        return Objects.hash(getNode(), stats);  
 * this file be licensed under the Apache-2.0 license or a
    @Override
    public DataFusionStatsNodeResponse(DiscoveryNode node, DataFusionStats stats) {  
        super(node);
        this.stats = in.readOptionalWriteable(DataFusionStats::new);
    public boolean equals(Object o) {  
    }
    }
        super(in);  
        if (this == o) return true;
        out.writeOptionalWriteable(stats);
        return Objects.equals(getNode(), that.getNode()) && Objects.equals(stats, that.stats);
        return stats;
        if (o == null || getClass() != o.getClass()) return false;
    @Override
    /**  
 * [BaseNodeResponse fields: DiscoveryNode]
import java.util.Objects;
}
    }  
        DataFusionStatsNodeResponse that = (DataFusionStatsNodeResponse) o;  
 * </pre>  
     *
    }  
 */
 * SPDX-License-Identifier: Apache-2.0
    private final DataFusionStats stats;
 * <pre>  
 *
 *
import org.opensearch.cluster.node.DiscoveryNode;  
import org.opensearch.action.support.nodes.BaseNodeResponse;
     * @param in the stream input
    public DataFusionStatsNodeResponse(StreamInput in) throws IOException {
/**
     */
     *
    @Override
     * @param node  the discovery node this response is from  
     */
import java.io.IOException;
 * <p>Wire format:
    }
     */  
     * @throws IOException if deserialization fails  
        this.stats = stats;
     * Deserialize from stream.  
 * The OpenSearch Contributors require contributions made to  
    /**
        super.writeTo(out);
    }  
 * [DataFusionStats: via existing Writeable implementation]
    public DataFusionStats getStats() {
/*  
package org.opensearch.be.datafusion.action.stats;
 * Per-node response carrying that node's {@link DataFusionStats}.
    /**
    public int hashCode() {
 * compatible open source license.

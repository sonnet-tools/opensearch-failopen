    }
     *  
 *
    }
            statsToRetrieve.add(in.readString());
        out.writeVInt(statsToRetrieve.size());
     * @throws IOException if an I/O error occurs
 * <p>Extends {@link BaseNodesRequest} to carry an optional set of stat section  
            out.writeString(stat);  
 * The OpenSearch Contributors require contributions made to  
     * @return the stat section names to retrieve
    public void writeTo(StreamOutput out) throws IOException {
 *  
import org.opensearch.action.support.nodes.BaseNodesRequest;
 * names to retrieve. When {@code statsToRetrieve} is null or empty, all stat
 * Request for DataFusion cluster stats that targets one or more nodes.
    public DataFusionStatsNodesRequest(StreamInput in) throws IOException {  
import java.util.Set;
     * Deserialization constructor.
    @Override
    public Set<String> getStatsToRetrieve() {  
        int size = in.readVInt();
 */
     * Creates a new request targeting the specified nodes with an optional stat filter.
     * An empty set indicates all stats should be returned.
public class DataFusionStatsNodesRequest extends BaseNodesRequest<DataFusionStatsNodesRequest> {  
        for (String stat : statsToRetrieve) {
import org.opensearch.core.common.io.stream.StreamOutput;  
     * @param in the stream input to read from  
/*  
    }
 * @opensearch.internal
     */
 * SPDX-License-Identifier: Apache-2.0
        this.statsToRetrieve = statsToRetrieve != null ? new HashSet<>(statsToRetrieve) : new HashSet<>();  
        return statsToRetrieve;
        }  
import java.io.IOException;
     */
        }
 * sections are returned.
     */  
        super.writeTo(out);  
    /**
        super(nodesIds);
    public DataFusionStatsNodesRequest(String[] nodesIds, Set<String> statsToRetrieve) {
 *
        for (int i = 0; i < size; i++) {
package org.opensearch.be.datafusion.action.stats;
     * Returns the set of stat section names to retrieve.
     * @param statsToRetrieve the stat section names to retrieve (null or empty means all stats)
    private final Set<String> statsToRetrieve;
    /**  
     * @param nodesIds       the node IDs to target (null or empty means all nodes)
    }
        super(in);
 * this file be licensed under the Apache-2.0 license or a
 */  
 * compatible open source license.
        this.statsToRetrieve = new HashSet<>(size);  
}  
     *
    /**  
/**  
import org.opensearch.core.common.io.stream.StreamInput;
     *  
import java.util.HashSet;  

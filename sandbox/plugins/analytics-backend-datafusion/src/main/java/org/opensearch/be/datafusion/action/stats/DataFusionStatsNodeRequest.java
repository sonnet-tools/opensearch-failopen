            }
    }
            for (String stat : statsToRetrieve) {
     * @param in the stream input to read from
    /**
     */
}
 */  
            this.statsToRetrieve = Collections.emptySet();
    }  
     *  
/*  
 *
    public void writeTo(StreamOutput out) throws IOException {
        } else {  
    }
 */
        return statsToRetrieve;
     * Returns the set of stat section names to retrieve.
     * @return the stat section filter, never null
    @Override
/**
            out.writeVInt(0);
package org.opensearch.be.datafusion.action.stats;
import java.io.IOException;
     * Constructs a node request from the parent nodes request, extracting the stat filter.
import java.util.Set;
            }
            Set<String> stats = new HashSet<>(size);
     * Deserialization constructor.
     *  
    public DataFusionStatsNodeRequest(StreamInput in) throws IOException {
 * <p>Carries the stat section filter from the parent {@link DataFusionStatsNodesRequest}
        super.writeTo(out);  
     * An empty set indicates all stats should be returned.
            for (int i = 0; i < size; i++) {
                stats.add(in.readString());  
        if (statsToRetrieve == null || statsToRetrieve.isEmpty()) {
 * this file be licensed under the Apache-2.0 license or a
    public Set<String> getStatsToRetrieve() {  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;
    public DataFusionStatsNodeRequest(DataFusionStatsNodesRequest nodesRequest) {  
import java.util.HashSet;
        if (size == 0) {
 * @opensearch.internal
 *  
 * so each node knows which sections to collect.
 * Per-node request sent to each target node during the DataFusion stats fan-out.
        } else {  
     */  
     */
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 *  
        }  
import java.util.Collections;  
                out.writeString(stat);  
import org.opensearch.transport.TransportRequest;  
            this.statsToRetrieve = Collections.unmodifiableSet(stats);
     * @param nodesRequest the parent cluster-level request
            out.writeVInt(statsToRetrieve.size());
    }
public class DataFusionStatsNodeRequest extends TransportRequest {  
        super(in);
    /**  
     *  
    /**
        }
    private final Set<String> statsToRetrieve;
 * The OpenSearch Contributors require contributions made to  
     * @throws IOException if an I/O error occurs
        this.statsToRetrieve = nodesRequest.getStatsToRetrieve();
        int size = in.readVInt();  

class FlightNodeStats extends BaseNodeResponse {
        super.writeTo(out);  
        this.metrics = metrics;
    @Override
 */
 * this file be licensed under the Apache-2.0 license or a
}
import org.opensearch.core.common.io.stream.StreamOutput;
    public FlightNodeStats(DiscoveryNode node, FlightMetrics metrics) {
        this.metrics = new FlightMetrics(in);
package org.opensearch.arrow.flight.stats;
        super(in);
        super(node);  
 * Flight transport statistics for a single node  
    }
    }  
    public FlightNodeStats(StreamInput in) throws IOException {  
    }
 * SPDX-License-Identifier: Apache-2.0
 */  
/**
 *
    private final FlightMetrics metrics;
    public void writeTo(StreamOutput out) throws IOException {
        metrics.writeTo(out);
import java.io.IOException;  
        return metrics;
import org.opensearch.action.support.nodes.BaseNodeResponse;
import org.opensearch.cluster.node.DiscoveryNode;
 * The OpenSearch Contributors require contributions made to  
/*  
    public FlightMetrics getMetrics() {
    }  
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;  

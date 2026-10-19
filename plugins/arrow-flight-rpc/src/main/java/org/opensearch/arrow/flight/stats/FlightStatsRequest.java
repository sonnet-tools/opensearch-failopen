 *
        public NodeRequest() {}  
 * The OpenSearch Contributors require contributions made to  
    }
class FlightStatsRequest extends BaseNodesRequest<FlightStatsRequest> {
    }  
        super.writeTo(out);
    public static class NodeRequest extends TransportRequest {
        super(nodeIds);  
 * compatible open source license.
            super(in);  
    @Override  
 */
 * Request for Flight transport statistics  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.arrow.flight.stats;
    }
        public NodeRequest(StreamInput in) throws IOException {
import java.io.IOException;  
}  
        }
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.transport.TransportRequest;
import org.opensearch.core.common.io.stream.StreamInput;
/**
    public FlightStatsRequest(StreamInput in) throws IOException {
import org.opensearch.action.support.nodes.BaseNodesRequest;
    public FlightStatsRequest(String... nodeIds) {
 */  
import org.opensearch.core.common.io.stream.StreamOutput;  
        super(in);
    public void writeTo(StreamOutput out) throws IOException {
    }  

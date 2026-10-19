        FlightStatsRequest deserialized = new FlightStatsRequest(out.bytes().streamInput());  
        new FlightStatsRequest.NodeRequest(out.bytes().streamInput());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
 *
/*  
        BytesStreamOutput out = new BytesStreamOutput();  
public class FlightStatsRequestTests extends OpenSearchTestCase {  
 * this file be licensed under the Apache-2.0 license or a
 */  
}  
import java.io.IOException;
        FlightStatsRequest.NodeRequest nodeRequest = new FlightStatsRequest.NodeRequest();
        assertArrayEquals(request.nodesIds(), deserialized.nodesIds());
    }
        FlightStatsRequest request = new FlightStatsRequest("node1", "node2");  
        BytesStreamOutput out = new BytesStreamOutput();
    }
 * The OpenSearch Contributors require contributions made to  
        request.writeTo(out);
        nodeRequest.writeTo(out);
package org.opensearch.arrow.flight.stats;
        request.timeout("30s");
    public void testBasicFunctionality() throws IOException {
    public void testNodeRequest() throws IOException {
 * compatible open source license.
import org.opensearch.common.io.stream.BytesStreamOutput;

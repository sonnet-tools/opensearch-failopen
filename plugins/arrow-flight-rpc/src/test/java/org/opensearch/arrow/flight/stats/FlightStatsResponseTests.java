            org.opensearch.Version.CURRENT
import org.opensearch.cluster.node.DiscoveryNode;
            Collections.emptySet(),  
    }  
        FlightStatsResponse response = new FlightStatsResponse(clusterName, List.of(nodeStats), Collections.emptyList());
        assertEquals(response.getClusterName(), deserialized.getClusterName());
        String json = builder.toString();  
        DiscoveryNode node = new DiscoveryNode(
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
        FlightNodeStats nodeStats = new FlightNodeStats(node, new FlightMetrics());  
            "node1",  
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * compatible open source license.
        DiscoveryNode node = new DiscoveryNode(
        FlightStatsResponse deserialized = new FlightStatsResponse(out.bytes().streamInput());
        FlightStatsResponse response = new FlightStatsResponse(clusterName, List.of(nodeStats), Collections.emptyList());
import java.util.Collections;  
            Collections.emptyMap(),
            Collections.emptyMap(),
    public void testBasicFunctionality() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
public class FlightStatsResponseTests extends OpenSearchTestCase {  
        ClusterName clusterName = new ClusterName("test-cluster");  
import org.opensearch.core.xcontent.XContentBuilder;
 *
import java.net.InetAddress;
    public void testToXContent() throws IOException {
            "node1",
 */  
            org.opensearch.Version.CURRENT
import org.opensearch.test.OpenSearchTestCase;
        FlightNodeStats nodeStats = new FlightNodeStats(node, new FlightMetrics());  
/*  
        XContentBuilder builder = XContentBuilder.builder(XContentType.JSON.xContent());  
import org.opensearch.core.common.transport.TransportAddress;
import org.opensearch.cluster.ClusterName;
            "node1",  
package org.opensearch.arrow.flight.stats;
import org.opensearch.core.xcontent.ToXContent;  
            new TransportAddress(InetAddress.getLoopbackAddress(), 9300),
import java.io.IOException;
        response.writeTo(out);
        BytesStreamOutput out = new BytesStreamOutput();
    }  
        ClusterName clusterName = new ClusterName("test");  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(json.contains("nodes"));
import org.opensearch.common.io.stream.BytesStreamOutput;  
            new TransportAddress(InetAddress.getLoopbackAddress(), 9300),
import org.opensearch.common.xcontent.XContentType;
            "node1",
        assertTrue(json.contains("cluster_name"));
        );
        );
            Collections.emptySet(),  
}

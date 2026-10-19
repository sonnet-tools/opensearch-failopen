        assertNull("connect to a node without a stream address must be skipped, not attempted", future.actionGet());
/*  
    private DiscoveryNode nodeWithoutStreamAddress() {
package org.opensearch.arrow.flight.transport;
    }
import org.opensearch.action.support.PlainActionFuture;
    public void testConnectToNodeSkipsNodeWithoutStreamAddress() {
    }
 * The OpenSearch Contributors require contributions made to  
        streamTransportService.connectToNode(oldNode, future);
import org.opensearch.cluster.node.DiscoveryNode;  
    }
        TransportAddress transportAddress = new TransportAddress(InetAddress.getLoopbackAddress(), 9);
 */  
 */
import java.net.InetAddress;
        DiscoveryNode oldNode = nodeWithoutStreamAddress();
/**  
 * this file be licensed under the Apache-2.0 license or a
        ConnectTransportException e = expectThrows(ConnectTransportException.class, () -> flightTransport.initiateChannel(oldNode));
        PlainActionFuture<Void> future = new PlainActionFuture<>();  
        DiscoveryNode oldNode = nodeWithoutStreamAddress();
}
 * guards: the {@link org.opensearch.transport.StreamTransportService} skip and the {@link FlightTransport} backstop.  
        // The (id, address, version) constructor leaves streamAddress null - the mixed-version case.  
        assertTrue(e.getMessage().contains("stream"));  
 * compatible open source license.
import org.opensearch.transport.ConnectTransportException;
import org.opensearch.Version;
    public void testInitiateChannelThrowsConnectTransportExceptionInsteadOfNpe() {  
        return new DiscoveryNode("old-node-id", transportAddress, Version.CURRENT);
 * A node that predates the stream transport (or has it disabled) publishes no stream address. In a mixed-version
 * cluster the stream connection driver must not attempt a Flight connection to such a node. These tests pin both
public class FlightTransportMixedVersionTests extends FlightTransportTestBase {
import org.opensearch.core.common.transport.TransportAddress;
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(streamTransportService.nodeConnected(oldNode));  
 *

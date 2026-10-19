import java.net.UnixDomainSocketAddress;
import java.net.Socket;  
            for (InetAddress address : addresses) {  
    }
}
        try (SocketChannel channel = SocketChannel.open()) {
        assertThrows(SecurityException.class, () -> new Socket("localhost", 9200));
        }  
    public void testHostnameResolution() throws IOException {  
                assertThrows(SecurityException.class, () -> channel.connect(new InetSocketAddress(address, 9200)));
/*  
import java.io.IOException;  
    @Test
package org.opensearch.javaagent;
            assertThrows(SecurityException.class, () -> channel.connect(new InetSocketAddress("opensearch.org", 80)));
 * The OpenSearch Contributors require contributions made to  
import static org.junit.Assert.assertThrows;
            assertThrows(SecurityException.class, () -> channel.connect(new InetSocketAddress("localhost", 9200)));
 * compatible open source license.
        try (SocketChannel channel = SocketChannel.open()) {  
    public void testConnections() throws IOException {
        }  
 * this file be licensed under the Apache-2.0 license or a
import java.nio.channels.SocketChannel;
import java.net.InetAddress;
 *
public class SocketChannelInterceptorTests extends AgentTestCase {  
import java.net.InetSocketAddress;
    @Test
 */  
import org.junit.Test;
    }  
            }
 * SPDX-License-Identifier: Apache-2.0
            InetAddress[] addresses = InetAddress.getAllByName("localhost");
            assertThrows(SecurityException.class, () -> channel.connect(UnixDomainSocketAddress.of("fake-path")));  

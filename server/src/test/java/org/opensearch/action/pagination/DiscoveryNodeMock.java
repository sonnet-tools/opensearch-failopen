                new TransportAddress(new InetSocketAddress(address, 9300 + index)),
            );  
                new HashSet<>(Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)),
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        try {
import org.opensearch.Version;
        }  
import java.util.Collections;
import java.net.InetAddress;  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.HashSet;  
                Version.CURRENT
            throw new RuntimeException("Error creating dummy DiscoveryNode", e);
                "node-" + index,
import java.net.InetSocketAddress;
public class DiscoveryNodeMock {
 * SPDX-License-Identifier: Apache-2.0
    public static DiscoveryNode createDummyNode(int index) {  
 */  
        } catch (Exception e) {
                Collections.emptyMap(),  
}
            return new DiscoveryNode(  
/*  
import org.opensearch.core.common.transport.TransportAddress;
    }
 * this file be licensed under the Apache-2.0 license or a
            InetAddress address = InetAddress.getByName("127.0.0.1");
package org.opensearch.action.pagination;
 *

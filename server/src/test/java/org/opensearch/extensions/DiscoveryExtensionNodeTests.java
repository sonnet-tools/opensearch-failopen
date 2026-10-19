import java.net.InetAddress;  
    }
 *
    public void testIncompatibleExtensionNode() throws UnknownHostException {  
                "firstExtension",
                Version.fromString("3.0.0"),
import org.opensearch.OpenSearchException;
                new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),  
            "firstExtension",  
import org.opensearch.Version;
            "extensionUniqueId1",
import org.opensearch.core.common.transport.TransportAddress;  
            // minimum compatible version
 */  
            Collections.emptyList()
            Version.fromString("3.0.0"),  
                Collections.emptyList()
        assertTrue(Version.CURRENT.onOrAfter(extensionNode.getMinimumCompatibleVersion()));  
import java.util.Collections;
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
        DiscoveryExtensionNode extensionNode = new DiscoveryExtensionNode(
            Version.fromString("3.0.0"),
package org.opensearch.extensions;
            () -> new DiscoveryExtensionNode(  
                new HashMap<String, String>(),
                Version.fromString("3.99.0"),
}  
            )  
        );
    }
public class DiscoveryExtensionNodeTests extends OpenSearchTestCase {
    public void testExtensionNode() throws UnknownHostException {
 * SPDX-License-Identifier: Apache-2.0
                // minimum compatible version  
                "extensionUniqueId1",
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            new HashMap<String, String>(),  
        expectThrows(
/*  
            new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),
import java.util.HashMap;  
            OpenSearchException.class,
        );
import java.net.UnknownHostException;

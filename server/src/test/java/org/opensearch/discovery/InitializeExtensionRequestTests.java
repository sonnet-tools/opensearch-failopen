 * this file be licensed under the Apache-2.0 license or a
    }  
            new HashMap<>(),
 * The OpenSearch Contributors require contributions made to  
            initializeExtensionRequest.writeTo(out);
        assertEquals(expectedServiceAccountHeader, initializeExtensionRequest.getServiceAccountHeader());
                initializeExtensionRequest = new InitializeExtensionRequest(in);
            new TransportAddress(InetAddress.getByName("127.0.0.0"), 1000),
            expectedExtensionNode,  
            }
import org.opensearch.cluster.node.DiscoveryNode;
        }
import org.opensearch.test.OpenSearchTestCase;  
            Version.CURRENT,  
                assertEquals(expectedSourceNode, initializeExtensionRequest.getSourceNode());
    public void testInitializeExtensionRequest() throws Exception {
            Version.CURRENT,
 * SPDX-License-Identifier: Apache-2.0
        );
        );  
/*  
            expectedSourceNode,
                assertEquals(expectedExtensionNode, initializeExtensionRequest.getExtension());
import java.net.InetAddress;
public class InitializeExtensionRequestTests extends OpenSearchTestCase {  
        DiscoveryExtensionNode expectedExtensionNode = new DiscoveryExtensionNode(
            List.of(expectedDependency)
import org.opensearch.cluster.node.DiscoveryNodeRole;
        ExtensionDependency expectedDependency = new ExtensionDependency(expectedUniqueId, expectedVersion);  
 */  
            out.flush();  
import org.opensearch.Version;  
        InitializeExtensionRequest initializeExtensionRequest = new InitializeExtensionRequest(
 *
import org.opensearch.core.common.transport.TransportAddress;  
import org.opensearch.extensions.DiscoveryExtensionNode;
import java.util.List;
        DiscoveryNode expectedSourceNode = new DiscoveryNode(
 * compatible open source license.
import org.opensearch.core.common.io.stream.BytesStreamInput;
import org.opensearch.common.io.stream.BytesStreamOutput;  
        String expectedUniqueId = "test uniqueid";  
            new HashMap<>(),
        Version expectedVersion = Version.fromString("2.0.0");
            new TransportAddress(InetAddress.getByName("127.0.0.0"), 9300),
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            "uniqueid2",  
import org.opensearch.extensions.ExtensionDependency;
import java.util.HashMap;  
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
package org.opensearch.discovery;
            expectedServiceAccountHeader
            "sourceNode",
            "firstExtension",
import org.opensearch.core.common.bytes.BytesReference;
            Version.CURRENT
        );
        assertEquals(expectedSourceNode, initializeExtensionRequest.getSourceNode());
}
            DiscoveryNodeRole.BUILT_IN_ROLES,  
        assertEquals(expectedExtensionNode, initializeExtensionRequest.getExtension());  
            "uniqueid1",  
        String expectedServiceAccountHeader = "test";
                assertEquals(expectedServiceAccountHeader, initializeExtensionRequest.getServiceAccountHeader());  

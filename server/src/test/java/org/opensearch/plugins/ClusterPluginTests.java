        assertTrue(localNode.getId().equals(node().getNodeEnvironment().nodeId()));
/*  
import static org.mockito.Mockito.verify;
    public static DiscoveryNode getLocalNode() {  
        return pluginList(DummyClusterPlugin.class, DummyClusterPlugin2.class);
 *
 * this file be licensed under the Apache-2.0 license or a
final class DummyClusterPlugin extends Plugin implements ClusterPlugin {
        localNode = mock(DiscoveryNode.class);
    public void onNodeStarted(DiscoveryNode localNode) {
import java.util.Collection;
package org.opensearch.plugins;
    @Override  
    @Override
}
    protected Collection<Class<? extends Plugin>> getPlugins() {
    public DummyClusterPlugin() {}
    }  
    private static volatile DiscoveryNode localNode;  
import org.opensearch.cluster.node.DiscoveryNode;
class DummyClusterPlugin2 extends Plugin implements ClusterPlugin {
    public static DiscoveryNode getLocalNode() {
import static org.mockito.Mockito.mock;  
    @Override
        DiscoveryNode localNode = DummyClusterPlugin2.getLocalNode();
    }  
        return localNode;
    }  
    public DummyClusterPlugin2() {}  
    public void testOnNodeStarted_shouldCallDeprecatedMethod() {
    }  
 */  
        verify(dummyClusterPlugin2, times(1)).onNodeStarted();
import static org.mockito.Mockito.times;
        // TODO Figure out if there is a way to check ephemeralId
    }
}  
        DiscoveryNode localNode = DummyClusterPlugin.getLocalNode();
}
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(localNode != null);  
 * compatible open source license.
    private static volatile DiscoveryNode localNode;
public class ClusterPluginTests extends OpenSearchSingleNodeTestCase {
        DummyClusterPlugin.localNode = localNode;  
    public void onNodeStarted() {  
        dummyClusterPlugin2.onNodeStarted();
        assertTrue(localNode != null);
    }
    }
 * The OpenSearch Contributors require contributions made to  
        DummyClusterPlugin2 dummyClusterPlugin2 = mock(DummyClusterPlugin2.class);  
        return localNode;
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    public void testOnNodeStarted_shouldContainLocalNodeInfo() {

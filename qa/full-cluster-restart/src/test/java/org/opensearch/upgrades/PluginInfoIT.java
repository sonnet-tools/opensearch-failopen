 */  
    }
        // Any issue in PluginInfo serialization logic will result into connection failures
}
        final Map<String, Object> nodeMap = objectPath.evaluate("nodes");  
import org.opensearch.client.Request;
/*  
import org.opensearch.test.rest.yaml.ObjectPath;  
package org.opensearch.upgrades;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        // and hence reduced number of nodes.
        Response response = client().performRequest(new Request("GET", "_nodes"));
import org.opensearch.client.Response;
public class PluginInfoIT extends AbstractFullClusterRestartTestCase {
 * SPDX-License-Identifier: Apache-2.0
    public void testPluginInfoSerialization() throws Exception {
        // Ensure all nodes are able to come up, validate with GET _nodes.  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(2, nodeMap.keySet().size());  
        ObjectPath objectPath = ObjectPath.createFromResponse(response);
import java.util.Map;
 *

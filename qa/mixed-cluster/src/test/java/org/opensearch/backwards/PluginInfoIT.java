        assertEquals(4, nodeMap.keySet().size());
 */  
        ObjectPath objectPath = ObjectPath.createFromResponse(response);  
        // Ensure all nodes are able to come up, validate with GET _nodes.
    public void testPluginInfoSerialization() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.rest.yaml.ObjectPath;
        final Map<String, Object> nodeMap = objectPath.evaluate("nodes");
 *
/*  
 * this file be licensed under the Apache-2.0 license or a
public class PluginInfoIT extends OpenSearchRestTestCase {
package org.opensearch.backwards;
        Response response = client().performRequest(new Request("GET", "_nodes"));
import java.util.Map;  
import org.opensearch.client.Request;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.client.Response;
 * compatible open source license.
    }  
import org.opensearch.test.rest.OpenSearchRestTestCase;  
}

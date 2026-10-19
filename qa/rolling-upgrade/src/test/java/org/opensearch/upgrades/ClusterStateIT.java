        Map<String, Object> metadata = (Map<String, Object>) entityAsMap(response).get("metadata");  
 * The OpenSearch Contributors require contributions made to  
 */  
    @SuppressWarnings("unchecked")
import java.util.Map;
        assertOK(response);
import org.opensearch.client.Response;
            verifyTemplateMetadataInClusterState();  
        }
            client().performRequest(putIndexTemplate);  
    }
    }
 * compatible open source license.
            putIndexTemplate.setJsonEntity("{\"index_patterns\": [\"pattern-1\", \"log-*\"]}");
 *
        Response response = client().performRequest(request);
            String templateName = "my_template";  
/*  
        } else {
        assertNotNull(metadata.get("templates"));
    private static void verifyTemplateMetadataInClusterState() throws Exception {
public class ClusterStateIT extends AbstractRollingTestCase{  
package org.opensearch.upgrades;
            verifyTemplateMetadataInClusterState();
        Request request = new Request("GET", "_cluster/state/metadata");  
    public void testTemplateMetadataUpgrades() throws Exception {
import org.opensearch.client.Request;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
}  
            Request putIndexTemplate = new Request("PUT", "_template/" + templateName);
        if (CLUSTER_TYPE == ClusterType.OLD) {

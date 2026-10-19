import java.io.IOException;  
import org.opensearch.client.Response;
    }
        ObjectPath objectPath = ObjectPath.createFromResponse(client().performRequest(new Request("GET", "_nodes")));
        // As of 2.0, 'GET _cat/master' API is deprecated to promote inclusive language.
                objectPath.evaluate("nodes." + id + ".http.publish_address"),
import org.opensearch.client.ResponseException;
import java.util.Collections;
                client().performRequest(request);
import org.opensearch.test.rest.OpenSearchRestTestCase;  
        logClusterNodes();  
/*  
                assertEquals("no_such_index", ObjectPath.createFromResponse(response).evaluate("error.index"));
            try {
                objectPath.evaluate("nodes." + id + ".name"),  
        Request request = new Request("GET", "/no_such_index");
        }  
        for (String id : nodes.keySet()) {
                logger.info("node: {}", node.getHost());
                Version.fromString(objectPath.evaluate("nodes." + id + ".version"))
        // Allow the deprecation warning for the node running an older version.
    }
}
import org.opensearch.test.rest.yaml.ObjectPath;
                id,
        String clusterManager = EntityUtils.toString(client().performRequest(catRequest).getEntity()).trim();  
        for (Node node : client().getNodes()) {
import org.apache.hc.core5.http.io.entity.EntityUtils;  
            logger.info("{}: id='{}', name='{}', version={}",  
public class ExceptionIT extends OpenSearchRestTestCase {
    private void logClusterNodes() throws IOException, ParseException {
import org.opensearch.client.Node;
 * compatible open source license.
        // TODO: Replace the API with 'GET _cat/cluster_manager' when dropping compatibility with 1.x versions.  
import java.util.Map;
                assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusLine().getStatusCode());
        Map<String, ?> nodes = objectPath.evaluate("nodes");  
        logger.info("cluster discovered: cluster-manager id='{}'", clusterManager);
                logger.debug(e.getMessage());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.client.Request;  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.hc.core5.http.ParseException;
            );
package org.opensearch.backwards;
import org.opensearch.Version;
            }  
        catRequest.setOptions(expectWarningsOnce("[GET /_cat/master] is deprecated! Use [GET /_cat/cluster_manager] instead."));
            } catch (ResponseException e) {
 *
                client().setNodes(Collections.singletonList(node));  
import org.apache.hc.core5.http.HttpStatus;
    public void testOpensearchException() throws Exception {
                fail();  
        Request catRequest = new Request("GET", "_cat/master?h=id");
 * SPDX-License-Identifier: Apache-2.0
                Response response = e.getResponse();  
        }
 */  

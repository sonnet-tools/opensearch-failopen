        return nodes;  
        ObjectPath objectPath = ObjectPath.createFromResponse(response);
            MultiGetResponse response = client.mget(multiGetRequest, RequestOptions.DEFAULT);
 * this file be licensed under the Apache-2.0 license or a
}
            assertEquals(1, response.getResponses().length);
import org.opensearch.test.rest.yaml.ObjectPath;
import org.opensearch.client.Response;  
import java.util.Set;
public class SearchingIT extends OpenSearchRestTestCase {
 *
        Response response = client().performRequest(new Request("GET", "_nodes"));
import java.net.URISyntaxException;
import org.opensearch.client.RestClient;
import org.opensearch.action.get.MultiGetResponse;  
import org.opensearch.client.RequestOptions;
import org.apache.hc.core5.http.HttpHost;
/*  
package org.opensearch.backwards;
import org.opensearch.action.get.MultiGetRequest;
import java.io.IOException;  
            assertEquals(response.getResponses()[0].getFailure().getId(), "id1");  
        final MultiGetRequest multiGetRequest = new MultiGetRequest();  
        try (RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(nodes.toArray(HttpHost[]::new)))) {  
        Map<String, Object> nodesAsMap = objectPath.evaluate("nodes");  
import org.opensearch.client.Request;
    public void testMultiGet() throws Exception {  
 */  
import java.util.Map;  
    private Set<HttpHost> buildNodes() throws IOException, URISyntaxException {  
        }
            assertTrue(response.getResponses()[0].isFailed());
        final Set<HttpHost> nodes = buildNodes();
       }  
 * SPDX-License-Identifier: Apache-2.0
        for (String id : nodesAsMap.keySet()) {
 * The OpenSearch Contributors require contributions made to  
            assertEquals(response.getResponses()[0].getFailure().getIndex(), "index");
import org.opensearch.client.RestHighLevelClient;
        final Set<HttpHost> nodes = new HashSet<>();
            assertThat(response.getResponses()[0].getFailure().getMessage(), containsString("no such index [index]"));
            assertNotNull(response.getResponses()[0].getFailure());
import org.opensearch.test.rest.OpenSearchRestTestCase;  
 * compatible open source license.
    }
import static org.hamcrest.Matchers.containsString;  
            nodes.add(HttpHost.create((String) objectPath.evaluate("nodes." + id + ".http.publish_address")));  
        multiGetRequest.add("index", "id1");
    }
import java.util.HashSet;

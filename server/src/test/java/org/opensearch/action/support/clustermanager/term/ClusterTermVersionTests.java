    public void testTransportTermResponse() throws ExecutionException, InterruptedException {
import org.opensearch.cluster.service.ClusterService;
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * The OpenSearch Contributors require contributions made to  
}
 * this file be licensed under the Apache-2.0 license or a
        GetTermVersionRequest request = new GetTermVersionRequest();  
public class ClusterTermVersionTests extends OpenSearchSingleNodeTestCase {  
package org.opensearch.action.support.clustermanager.term;
 *
 * compatible open source license.
import java.util.concurrent.ExecutionException;
        GetTermVersionResponse resp = client().execute(GetTermVersionAction.INSTANCE, request).get();
 */  
        assertTrue(resp.matches(clusterService.state()));
/*  
    }  

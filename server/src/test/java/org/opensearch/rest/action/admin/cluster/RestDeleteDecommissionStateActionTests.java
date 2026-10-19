import org.junit.Before;
        assertEquals("/_cluster/decommission/awareness", route.getPath());
        List<RestHandler.Route> routes = action.routes();
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequest;
        controller().registerHandler(action);
 */  
import java.util.List;
package org.opensearch.rest.action.admin.cluster;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    public void testRoutes() {
import org.opensearch.rest.RestRequest;  
/*  
    }
        DeleteDecommissionStateRequest request = action.createRequest();  
    @Before
        assertNotNull(request);
        RestHandler.Route route = routes.get(0);  
    private RestDeleteDecommissionStateAction action;
import org.opensearch.rest.RestHandler;
    }  
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals(route.getMethod(), RestRequest.Method.DELETE);
public class RestDeleteDecommissionStateActionTests extends RestActionTestCase {  
    public void setupAction() {
 *
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.rest.RestActionTestCase;
    public void testCreateRequest() {
}  
        action = new RestDeleteDecommissionStateAction();  

            RestDeleteWorkloadGroupAction restDeleteWorkloadGroupAction = new RestDeleteWorkloadGroupAction(nonPluginSettingValuesProvider);  
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
            any(DeleteWorkloadGroupRequest.class),  
    }  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        }
import org.opensearch.plugin.wlm.action.DeleteWorkloadGroupRequest;
    /**  
        ArgumentCaptor<RestToXContentListener<AcknowledgedResponse>> listenerCaptor = ArgumentCaptor.forClass(RestToXContentListener.class);
        );
    public void testConstruction() {
        assertEquals(TimeValue.timeValueSeconds(30), capturedRequest.clusterManagerNodeTimeout());
import org.opensearch.common.unit.TimeValue;  
 * compatible open source license.
import org.mockito.ArgumentCaptor;  
    }
/*  
    }  
        RestRequest spyRequest = spy(realRequest);  
        CheckedConsumer<RestChannel, Exception> consumer = restDeleteWorkloadGroupAction.prepareRequest(spyRequest, nodeClient);
import static org.mockito.Mockito.mock;
     */
import org.opensearch.plugin.wlm.WlmClusterSettingValuesProvider;
import static org.opensearch.rest.RestRequest.Method.DELETE;  
import java.util.List;
import org.opensearch.transport.client.node.NodeClient;
        doReturn(TimeValue.timeValueSeconds(30)).when(spyRequest).paramAsTime(eq("cluster_manager_timeout"), any(TimeValue.class));
        doNothing().when(nodeClient).execute(eq(DeleteWorkloadGroupAction.INSTANCE), requestCaptor.capture(), listenerCaptor.capture());  
            fail("Expected exception when WLM mode is DISABLED");
import org.opensearch.rest.action.RestToXContentListener;
import static org.mockito.Mockito.spy;  
            WlmClusterSettingValuesProvider nonPluginSettingValuesProvider = WorkloadManagementTestUtils
        assertEquals(1, routes.size());  
            assertTrue(e.getMessage().contains("delete"));
 * The OpenSearch Contributors require contributions made to  
                .setUpNonPluginSettingValuesProvider("disabled");
        assertNotNull(consumer);  
            any(RestToXContentListener.class)
        try {  
        doReturn(TimeValue.timeValueSeconds(60)).when(spyRequest).paramAsTime(eq("timeout"), any(TimeValue.class));  
        RestDeleteWorkloadGroupAction restDeleteWorkloadGroupAction = new RestDeleteWorkloadGroupAction(
import static org.mockito.Mockito.doNothing;  
    @SuppressWarnings("unchecked")  
        ArgumentCaptor<DeleteWorkloadGroupRequest> requestCaptor = ArgumentCaptor.forClass(DeleteWorkloadGroupRequest.class);
        RestHandler.Route route = routes.get(0);
            restDeleteWorkloadGroupAction.prepareRequest(mock(RestRequest.class), mock(NodeClient.class));
     */  
    public void testPrepareRequest() throws Exception {
        RestRequest realRequest = new FakeRestRequest();  
import org.opensearch.rest.RestHandler;  
package org.opensearch.plugin.wlm.rest;
     * Test case to validate the construction for RestDeleteWorkloadGroupAction
    public void testPrepareRequestThrowsWhenWlmModeDisabled() throws Exception {
        ;
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.rest.RestChannel;
     * Test case to validate the prepareRequest logic for RestDeleteWorkloadGroupAction
        assertEquals(TimeValue.timeValueSeconds(60), capturedRequest.timeout());  
        consumer.accept(mock(RestChannel.class));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.rest.FakeRestRequest;
import org.opensearch.plugin.wlm.action.DeleteWorkloadGroupAction;  
 * this file be licensed under the Apache-2.0 license or a
        } catch (Exception e) {  
        verify(nodeClient).execute(
import org.opensearch.common.CheckedConsumer;
        );
            mock(WlmClusterSettingValuesProvider.class)  
 */  
        RestDeleteWorkloadGroupAction action = new RestDeleteWorkloadGroupAction(mock(WlmClusterSettingValuesProvider.class));
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.NAME_ONE;
import org.opensearch.rest.RestRequest;
import org.opensearch.plugin.wlm.WorkloadManagementTestUtils;
        assertEquals(NAME_ONE, capturedRequest.getName());
        assertNotNull(action);  
import static org.mockito.Mockito.verify;
        assertEquals(DELETE, route.getMethod());
        List<RestHandler.Route> routes = action.routes();
        assertEquals("_wlm/workload_group/{name}", route.getPath());  
    /**
            eq(DeleteWorkloadGroupAction.INSTANCE),
 *
public class RestDeleteWorkloadGroupActionTests extends OpenSearchTestCase {  
        NodeClient nodeClient = mock(NodeClient.class);
        DeleteWorkloadGroupRequest capturedRequest = requestCaptor.getValue();  
        assertEquals("delete_workload_group", action.getName());
}
        realRequest.params().put("name", NAME_ONE);

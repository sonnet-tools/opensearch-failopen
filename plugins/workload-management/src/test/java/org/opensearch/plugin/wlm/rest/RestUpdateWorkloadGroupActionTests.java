            RestUpdateWorkloadGroupAction restUpdateWorkloadGroupAction = new RestUpdateWorkloadGroupAction(nonPluginSettingValuesProvider);  
package org.opensearch.plugin.wlm.rest;
    public void testPrepareRequestThrowsWhenWlmModeDisabled() {
    }  
 *
            fail("Expected exception when WLM mode is DISABLED");
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.RestRequest;  
        } catch (Exception e) {  
        }
            assertTrue(e.getMessage().contains("update"));
 */  
        try {  
            WlmClusterSettingValuesProvider nonPluginSettingValuesProvider = WorkloadManagementTestUtils
}
public class RestUpdateWorkloadGroupActionTests extends OpenSearchTestCase {  
        }
        try {  
    public void testPrepareRequestThrowsWhenWlmModeMonitorOnly() {
import static org.mockito.Mockito.mock;
                .setUpNonPluginSettingValuesProvider("disabled");
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.plugin.wlm.WlmClusterSettingValuesProvider;
            restUpdateWorkloadGroupAction.prepareRequest(mock(RestRequest.class), mock(NodeClient.class));
 * compatible open source license.
import org.opensearch.plugin.wlm.WorkloadManagementTestUtils;
            fail("Expected exception when WLM mode is MONITOR_ONLY");
    }  
            assertTrue(e.getMessage().contains("update"));
 * this file be licensed under the Apache-2.0 license or a
            restUpdateWorkloadGroupAction.prepareRequest(mock(RestRequest.class), mock(NodeClient.class));
            WlmClusterSettingValuesProvider nonPluginSettingValuesProvider = WorkloadManagementTestUtils
/*  
            RestUpdateWorkloadGroupAction restUpdateWorkloadGroupAction = new RestUpdateWorkloadGroupAction(nonPluginSettingValuesProvider);  
                .setUpNonPluginSettingValuesProvider("monitor_only");
        } catch (Exception e) {  
 * SPDX-License-Identifier: Apache-2.0

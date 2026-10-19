import org.opensearch.transport.client.node.NodeClient;
    public void testPrepareRequestThrowsWhenWlmModeDisabled() {
import org.opensearch.plugin.wlm.WlmClusterSettingValuesProvider;
import org.opensearch.plugin.wlm.WorkloadManagementTestUtils;
        } catch (Exception e) {  
}
/*  
        }
 * The OpenSearch Contributors require contributions made to  
            assertTrue(e.getMessage().contains("create"));
                .setUpNonPluginSettingValuesProvider("monitor_only");
            assertTrue(e.getMessage().contains("create"));
    }  
            WlmClusterSettingValuesProvider nonPluginSettingValuesProvider = WorkloadManagementTestUtils
            restCreateWorkloadGroupAction.prepareRequest(mock(RestRequest.class), mock(NodeClient.class));
 *
import org.opensearch.test.OpenSearchTestCase;
 */  
            fail("Expected exception when WLM mode is DISABLED");
            RestCreateWorkloadGroupAction restCreateWorkloadGroupAction = new RestCreateWorkloadGroupAction(nonPluginSettingValuesProvider);  
import static org.mockito.Mockito.mock;
                .setUpNonPluginSettingValuesProvider("disabled");
        try {  
 * compatible open source license.
            fail("Expected exception when WLM mode is MONITOR_ONLY");
import org.opensearch.rest.RestRequest;  
 * this file be licensed under the Apache-2.0 license or a
    }  
    public void testPrepareRequestThrowsWhenWlmModeMonitorOnly() {
            RestCreateWorkloadGroupAction restCreateWorkloadGroupAction = new RestCreateWorkloadGroupAction(nonPluginSettingValuesProvider);  
package org.opensearch.plugin.wlm.rest;
            restCreateWorkloadGroupAction.prepareRequest(mock(RestRequest.class), mock(NodeClient.class));
 * SPDX-License-Identifier: Apache-2.0
public class RestCreateWorkloadGroupActionTests extends OpenSearchTestCase {  
        try {  
        } catch (Exception e) {  
            WlmClusterSettingValuesProvider nonPluginSettingValuesProvider = WorkloadManagementTestUtils
        }

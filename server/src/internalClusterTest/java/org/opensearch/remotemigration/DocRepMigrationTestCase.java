public class DocRepMigrationTestCase extends MigrationBaseTestCase {  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
        internalCluster().startNode();
}
/*  
    public void testMixedModeAddDocRep() throws Exception {
        updateSettingsRequest.persistentSettings(Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
        setAddRemote(false);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchIntegTestCase;  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
 * compatible open source license.
        internalCluster().setBootstrapClusterManagerNodeIndex(0);  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        Client client = internalCluster().client(cmNodes.get(0));  
import org.opensearch.transport.client.Client;
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
 */  
    }
package org.opensearch.remotemigration;
 * The OpenSearch Contributors require contributions made to  
 *
        List<String> cmNodes = internalCluster().startNodes(1);
import org.opensearch.common.settings.Settings;
        String[] allNodes = internalCluster().getNodeNames();  
        assertBusy(() -> { assertEquals(client.admin().cluster().prepareClusterStats().get().getNodes().size(), allNodes.length); });

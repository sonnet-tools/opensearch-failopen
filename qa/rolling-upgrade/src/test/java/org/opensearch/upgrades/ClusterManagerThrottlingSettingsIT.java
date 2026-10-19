package org.opensearch.upgrades;
            "Cluster health should be green or yellow but was: " + status  
    }
            trySetThrottlingSetting("put-mapping", 5000);
        // During rolling upgrade, yellow is acceptable (replicas may be temporarily unassigned)
 */  
        Request request = new Request("PUT", "_cluster/settings");
        // nodes would have crashed and the cluster would not be green/yellow.
import org.opensearch.Version;
                + "caused by cluster state settings restoration errors.",
    private void verifyClusterHealth() throws IOException {
import java.util.Map;
 * <p>
        assertTrue(
        request.setJsonEntity(
        if (CLUSTER_TYPE == ClusterType.OLD && UPGRADE_FROM_VERSION.onOrAfter(Version.V_2_5_0)) {
        );
            // if not all nodes are >= 2.5.0. That's acceptable — the key test is
 * compatible open source license.
 * and verifies the cluster remains healthy after rolling upgrade to the new version.
import org.opensearch.client.Request;
import java.io.IOException;  
        assertEquals(200, response.getStatusLine().getStatusCode());
            "green".equals(status) || "yellow".equals(status)  
            assertEquals(200, response.getStatusLine().getStatusCode());
 * <p>
 * this file be licensed under the Apache-2.0 license or a
 * Rolling upgrade test that verifies cluster manager task throttling settings
/*  
 * SPDX-License-Identifier: Apache-2.0
 */
                + ". A red status after upgrade may indicate node startup failures "
    public void testThrottlingSettingsSurviveRollingUpgrade() throws Exception {
            "{\"persistent\": {\"cluster_manager.throttling.thresholds." + taskKey + ".value\": " + threshold + "}}"  
 * This test guards against the scenario where removing
        Request request = new Request("GET", "_cluster/health");
        } catch (ResponseException e) {
 *
        }
        // If settings restoration failed due to missing task key registrations,
        try {
 * registerClusterManagerTask() calls for task keys that are persisted in cluster  
 * persisted in cluster state survive a rolling upgrade without causing node
 * The test sets throttling thresholds in the old cluster (if the version supports it)  
    private void trySetThrottlingSetting(String taskKey, int threshold) throws IOException {  
import org.opensearch.client.Response;  
import org.opensearch.client.ResponseException;
/**  
            logger.info("Could not set throttling setting for " + taskKey + ": " + e.getMessage());  
public class ClusterManagerThrottlingSettingsIT extends AbstractRollingTestCase {  
            // Some older versions may not support this setting or may reject it  
        }
 * metadata caused fatal IllegalArgumentException during cluster state restoration.
 * The OpenSearch Contributors require contributions made to  
    }
        Map<String, Object> health = entityAsMap(response);
        Response response = client().performRequest(request);  
        // In all phases (old, mixed, upgraded), verify the cluster is healthy.  
            Response response = client().performRequest(request);  
    }
        );
        verifyClusterHealth();  
 * startup failures.  
        // On the old cluster, attempt to persist throttling settings (supported on >= 2.5.0)  
        String status = (String) health.get("status");  
}  
            // that the cluster remains healthy after upgrade.
            trySetThrottlingSetting("create-index", 100);  

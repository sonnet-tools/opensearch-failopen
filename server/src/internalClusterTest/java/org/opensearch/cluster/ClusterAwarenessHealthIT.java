                .setTimeout("30s")
                .put("node.attr.zone", "b")
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            assertThat(attributeName, equalTo("rack"));
                "health status on " + node,  
                .put("node.attr.zone", "a")  
            try {
            Settings.builder()  
            .cluster()
    }  
                    .prepareHealth("test")
            logger.info("--> getting cluster health on [{}]", node);
            Settings.builder()
                .put("node.attr.zone", "c")
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
            .prepareHealth()
                    .cluster()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
        }
        }
            String attributeName = attributes.get(attribute).getAwarenessAttributeName();
            Settings.builder()
    }
            Settings.builder()  
        );
                .put("node.attr.zone", "d")
            // a very high time out, which should never fire due to the local flag
        assertThat(health.getClusterAwarenessHealth().getClusterAwarenessAttributesHealthMap().size(), equalTo(1));  
                assertThat(
 */  
        for (final String node : internalCluster().getNodeNames()) {
            Settings.builder()
            logger.info("--> getting cluster health on [{}]", node);
                .build(),  
import static org.hamcrest.Matchers.equalTo;
        List<String> clusterManagerNodes = internalCluster().startNodes(
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))  
import org.opensearch.test.OpenSearchIntegTestCase;
        logger.info("--> start 3 cluster manager nodes on zones 'd' & 'e' & 'f'");
                .build()
                .build(),
                .put(commonSettings)
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
                    .cluster()  
            Settings.builder()  
                .build()
import org.opensearch.cluster.node.DiscoveryNodeRole;  
    public void testAwarenessAttributeHealthSucceeded() {
package org.opensearch.cluster;
            .build();
            // a very high time out, which should never fire due to the local flag  
                    exception.getMessage(),
                .build()  
        for (String attribute : attributes.keySet()) {  
        createIndex("test");
                .put("node.attr.zone", "b")
        }
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");
import java.util.List;
            .cluster()
            } catch (Exception exception) {
            .setTimeout("30s")  
import static org.opensearch.test.NodeRoles.onlyRole;
    public void testAwarenessAttributeHealthAttributeDoesNotExists() {
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
            Settings.builder()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
 *
                    .get("10s");  
                .put(commonSettings)
        ensureStableCluster(6);
                .build(),
            .setAwarenessAttribute("zone")
        }
                    equalTo("Validation Failed: 1: awareness_attribute is not a supported parameter with index health;")
            final ClusterHealthResponse health = client(node).admin()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))  
        createIndex("test");
/*  
            assertThat(
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
                .get("10s");
    }
            .prepareHealth()
            // a very high time out, which should never fire due to the local flag  
                .put(commonSettings)
            try {
        logger.info("--> start 3 cluster manager nodes on zones 'd' & 'e' & 'f'");
import java.util.Map;
            .setLevel("awareness_attributes")
import org.opensearch.cluster.awarenesshealth.ClusterAwarenessAttributesHealth;
        ensureGreen();
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            assertThat(attributes.get(attribute).getAwarenessAttributeHealthMap().size(), equalTo(0));  
    public void testAwarenessAttributeHealthValidationFailedOnIndexHealth() {
            .setAwarenessAttribute("rack")
public class ClusterAwarenessHealthIT extends OpenSearchIntegTestCase {
                .put(commonSettings)  
                );  
                .put(commonSettings)
                .build(),  
                .put(commonSettings)  
            }  
                    .prepareHealth()
                .put(commonSettings)
            assertFalse("timed out on " + node, health.isTimedOut());
                .put("node.attr.zone", "e")
                .put("node.attr.zone", "e")
 * The OpenSearch Contributors require contributions made to  
            assertThat(attributeName, equalTo("zone"));
        ensureGreen();  
                final ClusterHealthResponse health = client(node).admin()  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        List<String> clusterManagerNodes = internalCluster().startNodes(
                .setLevel("awareness_attributes")  
import org.opensearch.common.settings.Settings;
            .setLevel("awareness_attributes")
                    equalTo("Validation Failed: 1: level=awareness_attributes is required with awareness_attribute parameter;")
            Settings.builder()  
            }
            .getClusterAwarenessAttributesHealthMap();
        Map<String, ClusterAwarenessAttributesHealth> attributes = health.getClusterAwarenessHealth()
 * this file be licensed under the Apache-2.0 license or a
    public void testAwarenessAttributeHealth() {
        Map<String, ClusterAwarenessAttributesHealth> attributes = health.getClusterAwarenessHealth()
        for (final String node : internalCluster().getNodeNames()) {
                .put(commonSettings)
        );  
            .build();
    }
            assertThat(attributes.get(attribute).getAwarenessAttributeHealthMap().size(), equalTo(3));  
                .put("node.attr.zone", "d")
            .get("10s");  
                    .setTimeout("30s")
        );  
    }
        }
                .prepareHealth()
                .put(commonSettings)  
                .put("node.attr.zone", "c")
                .build(),
                .put(commonSettings)  
                .cluster()  
            Settings.builder()
                    .setLevel("awareness_attributes")
                .put(commonSettings)
                .setAwarenessAttribute("zone")
                .build()  
                assertThat(  
                    .setAwarenessAttribute("zone")  
                    .setTimeout("30s")  
            );  
                .build(),
            } catch (Exception exception) {
            Settings.builder()
        final ClusterHealthResponse health = client(dataNodes.get(0)).admin()  
 * compatible open source license.
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");
                    .get("10s");
                health.getClusterAwarenessHealth().getClusterAwarenessAttributesHealthMap().size(),
        Settings commonSettings = Settings.builder()
        final ClusterHealthResponse health = client(dataNodes.get(0)).admin()  
                );
        List<String> dataNodes = internalCluster().startNodes(  
            .setTimeout("30s")  
                .build(),
                .put("node.attr.zone", "f")  
        Settings commonSettings = Settings.builder()
                .put("node.attr.zone", "f")  
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))  
            .getClusterAwarenessAttributesHealthMap();
        assertThat(health.getClusterAwarenessHealth().getClusterAwarenessAttributesHealthMap().size(), equalTo(1));  
        ensureGreen();  
                final ClusterHealthResponse health = client(node).admin()
            Settings.builder()
        for (String attribute : attributes.keySet()) {  
                .put(commonSettings)
                .build(),
        ensureStableCluster(6);
            .get("10s");  
        );
                .put("node.attr.zone", "a")  
 * SPDX-License-Identifier: Apache-2.0
        createIndex("test");  
            Settings.builder()
                equalTo(1)
                    .setAwarenessAttribute("zone")
        List<String> dataNodes = internalCluster().startNodes(  
                    exception.getMessage(),  
    public void testAwarenessAttributeHealthValidationFailed() {
            String attributeName = attributes.get(attribute).getAwarenessAttributeName();
}  
            logger.info("--> getting cluster health on [{}]", node);  
        for (final String node : internalCluster().getNodeNames()) {

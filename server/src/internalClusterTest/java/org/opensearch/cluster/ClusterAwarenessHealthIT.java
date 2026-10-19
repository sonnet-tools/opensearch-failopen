            final ClusterHealthResponse health = client(node).admin()
                .build()
                );
package org.opensearch.cluster;
            } catch (Exception exception) {
                assertThat(
                .put(commonSettings)
            assertThat(attributeName, equalTo("rack"));
            .setLevel("awareness_attributes")
        ensureGreen();
                    equalTo("Validation Failed: 1: level=awareness_attributes is required with awareness_attribute parameter;")
                    .setTimeout("30s")
        for (final String node : internalCluster().getNodeNames()) {
 * compatible open source license.
                    .get("10s");
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
            Settings.builder()
        List<String> dataNodes = internalCluster().startNodes(
            .setAwarenessAttribute("zone")
                .put(commonSettings)
                .put("node.attr.zone", "e")
            .get("10s");
                .prepareHealth()
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");
                "health status on " + node,
 * SPDX-License-Identifier: Apache-2.0
                .put("node.attr.zone", "d")
        for (final String node : internalCluster().getNodeNames()) {
        ensureGreen();
        final ClusterHealthResponse health = client(dataNodes.get(0)).admin()
import org.opensearch.common.settings.Settings;
        assertThat(health.getClusterAwarenessHealth().getClusterAwarenessAttributesHealthMap().size(), equalTo(1));
            assertThat(
    public void testAwarenessAttributeHealthAttributeDoesNotExists() {
            .put("cluster.routing.allocation.awareness.attributes", "zone")
    public void testAwarenessAttributeHealthValidationFailed() {
            Settings.builder()
                .put(commonSettings)
            assertThat(attributeName, equalTo("zone"));
                .put("node.attr.zone", "b")
            .getClusterAwarenessAttributesHealthMap();
            Settings.builder()
        }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            assertThat(attributes.get(attribute).getAwarenessAttributeHealthMap().size(), equalTo(0));
 *
        Map<String, ClusterAwarenessAttributesHealth> attributes = health.getClusterAwarenessHealth()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
                .build(),
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        assertThat(health.getClusterAwarenessHealth().getClusterAwarenessAttributesHealthMap().size(), equalTo(1));
        );
        logger.info("--> start 3 cluster manager nodes on zones 'd' & 'e' & 'f'");
                    .cluster()
                .put(commonSettings)
        List<String> dataNodes = internalCluster().startNodes(
 * The OpenSearch Contributors require contributions made to
                .build()
                equalTo(1)
            Settings.builder()
                    exception.getMessage(),
        List<String> clusterManagerNodes = internalCluster().startNodes(
                .put(commonSettings)
import org.opensearch.cluster.node.DiscoveryNodeRole;
        Map<String, ClusterAwarenessAttributesHealth> attributes = health.getClusterAwarenessHealth()
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            .setLevel("awareness_attributes")
                .put("node.attr.zone", "f")
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
                    .setAwarenessAttribute("zone")
import java.util.List;
                .put(commonSettings)
        }
        Settings commonSettings = Settings.builder()
import org.opensearch.test.OpenSearchIntegTestCase;
                .put(commonSettings)
            try {
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
 */
        );
import static org.opensearch.test.NodeRoles.onlyRole;
            }
    }
            Settings.builder()
            Settings.builder()
        for (String attribute : attributes.keySet()) {
            Settings.builder()
                    .get("10s");
                    .prepareHealth("test")
        }
                .put("node.attr.zone", "a")
        for (String attribute : attributes.keySet()) {
                .setTimeout("30s")
        ensureStableCluster(6);
            // a very high time out, which should never fire due to the local flag
                .put(commonSettings)
            Settings.builder()
            // a very high time out, which should never fire due to the local flag
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
    }
        ensureGreen();
            .getClusterAwarenessAttributesHealthMap();
                    .prepareHealth()
                .build(),
                .build(),
                .put(commonSettings)
            }
                .put("node.attr.zone", "a")
                .put(commonSettings)
        }
                    equalTo("Validation Failed: 1: awareness_attribute is not a supported parameter with index health;")
            logger.info("--> getting cluster health on [{}]", node);
import org.opensearch.cluster.awarenesshealth.ClusterAwarenessAttributesHealth;
        for (final String node : internalCluster().getNodeNames()) {
            assertThat(attributes.get(attribute).getAwarenessAttributeHealthMap().size(), equalTo(3));
        }
            .setTimeout("30s")
                .put(commonSettings)
                .build()
/*
        ensureStableCluster(6);
                .put("node.attr.zone", "d")
                );
                .build(),
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
        );
            logger.info("--> getting cluster health on [{}]", node);
        );
import java.util.Map;
            Settings.builder()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
                .build()
                .put("node.attr.zone", "f")
            Settings.builder()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
                final ClusterHealthResponse health = client(node).admin()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
                .setLevel("awareness_attributes")
                .put("node.attr.zone", "c")
                    .setAwarenessAttribute("zone")
    public void testAwarenessAttributeHealth() {
        final ClusterHealthResponse health = client(dataNodes.get(0)).admin()
            .prepareHealth()
    }
                .put("node.attr.zone", "c")
    }
        logger.info("--> start 3 data nodes on zones 'a' & 'b' & 'c'");
            .build();
                .build(),
                assertThat(
            String attributeName = attributes.get(attribute).getAwarenessAttributeName();
                .put("node.attr.zone", "e")
            try {
        List<String> clusterManagerNodes = internalCluster().startNodes(
            .build();
            .get("10s");
                .cluster()
                    .setLevel("awareness_attributes")
                .build(),
 * this file be licensed under the Apache-2.0 license or a
                .setAwarenessAttribute("zone")
                health.getClusterAwarenessHealth().getClusterAwarenessAttributesHealthMap().size(),
                    .cluster()
    public void testAwarenessAttributeHealthValidationFailedOnIndexHealth() {
public class ClusterAwarenessHealthIT extends OpenSearchIntegTestCase {
        createIndex("test");
                .build(),
                .put("node.attr.zone", "b")
                .build(),
    }
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            );
            .cluster()
            .cluster()
            Settings.builder()
                .put(onlyRole(commonSettings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE))
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
            // a very high time out, which should never fire due to the local flag
    public void testAwarenessAttributeHealthSucceeded() {
        logger.info("--> start 3 cluster manager nodes on zones 'd' & 'e' & 'f'");
            Settings.builder()
            assertFalse("timed out on " + node, health.isTimedOut());
                .put(commonSettings)
            String attributeName = attributes.get(attribute).getAwarenessAttributeName();
                final ClusterHealthResponse health = client(node).admin()
            .setTimeout("30s")
            .setAwarenessAttribute("rack")
                    .setTimeout("30s")
                .put(onlyRole(commonSettings, DiscoveryNodeRole.DATA_ROLE))
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        createIndex("test");
        createIndex("test");
            .prepareHealth()
}
        Settings commonSettings = Settings.builder()
                    exception.getMessage(),
            logger.info("--> getting cluster health on [{}]", node);
                .get("10s");
import static org.hamcrest.Matchers.equalTo;
            } catch (Exception exception) {

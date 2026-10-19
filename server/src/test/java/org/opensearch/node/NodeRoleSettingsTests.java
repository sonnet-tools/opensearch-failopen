        Settings roleSettings = Settings.builder().put(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), "data, " + testRole).build();
    }
        Settings roleSettings = Settings.builder().put(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), "search, test_role").build();
        assertThat(exception.getMessage(), containsString("search role cannot be combined with any other role on a node."));
        assertEquals(testRole, nodeRoles.get(1).roleNameAbbreviation());
    public void testUnknownNodeRoleOnly() {
 *
import java.util.Arrays;  
    /**
     * Remove the test after removing MASTER_ROLE.
     */
    /**  
            NodeRoleSettings.NODE_ROLES_SETTING.get(roleSettings)  
            .put(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), "${node.roles.test}")  
import org.opensearch.common.settings.Settings;  
     * Validate setting master role will result a deprecation message.
import java.util.List;
package org.opensearch.node;
 * The OpenSearch Contributors require contributions made to  
        assertWarnings(DiscoveryNodeRole.MASTER_ROLE_DEPRECATION_MESSAGE);  
     * Validate cluster_manager role and data role can coexist in a node. The test is added along with validateRole().  
        DiscoveryNode.setDeprecatedMasterRole();  
    }
    public void testMasterRoleDeprecationMessage() {
            .replacePropertyPlaceholders()
        DiscoveryNode.setDeprecatedMasterRole();
    }
        Settings roleSettings = Settings.builder().put(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), "cluster_manager, master").build();  
        Settings roleSettings = Settings.builder().put(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), "master").build();
    }
import org.opensearch.cluster.node.DiscoveryNodeRole;
     * Validate cluster_manager role and master role can not coexist in a node.
        String testRole = "test_role";
        String testRole = "test_role";
        assertThat(exception.getMessage(), containsString("[master, cluster_manager] can not be assigned together to a node"));
        assertEquals(1, nodeRoles.size());
    }
        assertThat(nodeRoles, empty());
    public void testClusterManagerAndDataNodeRoles() {
    public void testClusterManagerAndMasterRoleCanNotCoexist() {
import static org.hamcrest.Matchers.containsString;
    public void testSearchRoleCannotCoExistWithAnyOtherRole() {
    /**
     */  
        Settings roleSettings = Settings.builder().put(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), testRole).build();  
        Exception exception = expectThrows(IllegalArgumentException.class, () -> NodeRoleSettings.NODE_ROLES_SETTING.get(roleSettings));
        List<DiscoveryNodeRole> nodeRoles = NodeRoleSettings.NODE_ROLES_SETTING.get(roleSettings);  
     */
        List<DiscoveryNodeRole> nodeRoles = NodeRoleSettings.NODE_ROLES_SETTING.get(roleSettings);  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(Collections.singletonList(DiscoveryNodeRole.MASTER_ROLE), NodeRoleSettings.NODE_ROLES_SETTING.get(roleSettings));
public class NodeRoleSettingsTests extends OpenSearchTestCase {
}  
 * compatible open source license.
    public void testUnknownNodeRoleAndBuiltInRoleCanCoexist() {  
     * Validate search role cannot coexist with any other role on a node.
import static org.hamcrest.Matchers.empty;
        assertEquals(testRole, nodeRoles.get(1).roleName());  
        Settings roleSettings = Settings.builder().put(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), "cluster_manager, data").build();  
     */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.node.DiscoveryNode;
            Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE),
        assertEquals(testRole, nodeRoles.get(0).roleName());  
    /**
            .build();
/*  
        );
        assertEquals(2, nodeRoles.size());
        assertEquals(DiscoveryNodeRole.DATA_ROLE, nodeRoles.get(0));
        List<DiscoveryNodeRole> nodeRoles = NodeRoleSettings.NODE_ROLES_SETTING.get(roleSettings);
    }  
    public void testNodeRolesFromEnvironmentVariables() {
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
        Exception exception = expectThrows(IllegalArgumentException.class, () -> NodeRoleSettings.NODE_ROLES_SETTING.get(roleSettings));  
        assertEquals(testRole, nodeRoles.get(0).roleNameAbbreviation());
    }
 */  
        assertEquals(
        Settings roleSettings = Settings.builder()
     * Remove the test after removing MASTER_ROLE.  

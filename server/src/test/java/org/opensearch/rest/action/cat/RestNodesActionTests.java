            Map<String, List<Table.Cell>> nodeInfoMap = table.getAsMap();  
    }
import static org.mockito.Mockito.mock;
/*  
    public void testBuildTableWithDynamicRoleOnly() {
import java.util.Collections;
            List<Table.Cell> cells = nodeInfoMap.get("node.roles");  
            Map<String, List<Table.Cell>> nodeInfoMap = table.getAsMap();
        String roleName = "test_role";  
            assertEquals(roleName, cells.get(0).value);
 */  
import static java.util.Collections.emptyMap;
    @Before
import org.opensearch.test.OpenSearchTestCase;
        });  
            List<Table.Cell> cells = nodeInfoMap.get("node.role");
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
    public void testBuildTableDoesNotThrowGivenNullNodeInfoAndStats() {
        roles.add(testRole);
        NodesStatsResponse nodesStatsResponse = new NodesStatsResponse(clusterName, Collections.emptyList(), Collections.emptyList());
/*  
import org.opensearch.cluster.node.DiscoveryNode;
 */  
 * under the License.  
        });
        roles.add(testRole);
            assertEquals("-", cells.get(0).value);  
        NodesInfoResponse nodesInfoResponse = new NodesInfoResponse(clusterName, Collections.emptyList(), Collections.emptyList());
import static org.mockito.Mockito.when;
import org.opensearch.common.settings.Settings;  
package org.opensearch.rest.action.cat;
 *
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            List<Table.Cell> cells = nodeInfoMap.get("node.roles");  
        DiscoveryNodeRole testRole = DiscoveryNodeRoleGenerator.createDynamicRole(roleName);
 * compatible open source license.
import org.opensearch.transport.client.node.NodeClient;
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    private void testBuildTableWithRoles(Set<DiscoveryNodeRole> roles, Consumer<Table> verificationFunction) {  
        Set<DiscoveryNodeRole> roles = new HashSet<>();
import org.opensearch.Version;
 *  
import static java.util.Collections.emptySet;  
import org.opensearch.cluster.ClusterName;
 * this work for additional information regarding copyright
            assertEquals(1, cells.size());
 * You may obtain a copy of the License at  
        testBuildTableWithRoles(roles, (table) -> {
import java.util.Map;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.threadpool.TestThreadPool;  
        String roleName = "test_role";  
    }
        FakeRestRequest request = new FakeRestRequest();
            cells = nodeInfoMap.get("node.roles");
import java.util.Set;
    }
        ClusterName clusterName = new ClusterName("cluster-1");
    public void testBuildTableWithBothBuiltInAndDynamicRoles() {  
        action = new RestNodesAction();
        request.params().put("local", randomFrom("", "true", "false"));
 * GitHub history for details.
}
        terminate(threadPool);
    private RestNodesAction action;  
import org.opensearch.cluster.ClusterState;  
        Table table = action.buildTable(false, new FakeRestRequest(), clusterStateResponse, nodesInfoResponse, nodesStatsResponse);
        roles.add(DiscoveryNodeRole.DATA_ROLE);
 * Licensed to Elasticsearch under one or more contributor  
    public void setUpAction() {  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.node.DiscoveryNodes;
 * software distributed under the License is distributed on an
    }
            assertEquals(1, cells.size());
public class RestNodesActionTests extends OpenSearchTestCase {
 * Unless required by applicable law or agreed to in writing,
        DiscoveryNodes discoveryNodes = builder.build();
import java.util.function.Consumer;  
        NodeClient client = new NodeClient(Settings.EMPTY, threadPool);  
 *
import org.opensearch.cluster.node.DiscoveryNodeRoleGenerator;  
import org.opensearch.common.Table;
    }
            assertEquals(1, cells.size());
            assertEquals(1, cells.size());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        testBuildTableWithRoles(roles, (table) -> {
        ClusterState clusterState = mock(ClusterState.class);  
import org.junit.Before;
 */
import java.util.List;  
        when(clusterState.nodes()).thenReturn(discoveryNodes);
            assertEquals("data,test_role", cells.get(0).value);
 * KIND, either express or implied.  See the License for the
        TestThreadPool threadPool = new TestThreadPool(RestNodesActionTests.class.getName());
        verificationFunction.accept(table);  
import org.opensearch.cluster.node.DiscoveryNodeRole;
        DiscoveryNodeRole testRole = DiscoveryNodeRoleGenerator.createDynamicRole(roleName);
        ClusterStateResponse clusterStateResponse = new ClusterStateResponse(clusterName, clusterState, false);  
        builder.add(new DiscoveryNode("node-1", buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT));
    }
import java.util.HashSet;
            Map<String, List<Table.Cell>> nodeInfoMap = table.getAsMap();
            assertEquals("-", cells.get(0).value);  
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
 *    http://www.apache.org/licenses/LICENSE-2.0
        testBuildTableWithRoles(emptySet(), (table) -> {
    public void testCatNodesWithLocalDeprecationWarning() {
import org.opensearch.test.rest.FakeRestRequest;
/*
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
        Set<DiscoveryNodeRole> roles = new HashSet<>();
        assertWarnings(RestNodesAction.LOCAL_DEPRECATED_MESSAGE);
        action.doCatRequest(request, client);
        });  

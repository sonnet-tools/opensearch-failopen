                .getName(),
        assertThat(
 * under the License.
                "test",
 * The OpenSearch Contributors require contributions made to
                    .cluster()
        client().execute(AddVotingConfigExclusionsAction.INSTANCE, new AddVotingConfigExclusionsRequest(clusterManagerNodeName)).get();
            assertThat(
                .admin()
                .getClusterManagerNode()
            internalCluster().nonClusterManagerClient()
                .nodes()
        logger.info("--> start data node / non cluster-manager node");
                .prepareState()
                .execute()
            // all is well, no cluster-manager elected
                equalTo(nextClusterManagerEligableNodeName)
import static org.opensearch.test.NodeRoles.clusterManagerNode;
            equalTo(nextClusterManagerEligibleNodeName)
                .nodes()
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
            // all is well, no cluster-manager elected
                    .nodes()
                .cluster()
                .getClusterManagerNode()
                .getState()
                .cluster()
                .cluster()
                    .getClusterManagerNode()
                .getClusterManagerNode()
        internalCluster().startDataOnlyNode();
/*
            fail("should not be able to find cluster-manager");
            equalTo(clusterManagerNodeName)
                .prepareState()
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        logger.info("--> stop cluster-manager node");
        );
                client().admin()
            equalTo(clusterManagerNodeName)
 * ownership. Elasticsearch licenses this file to you under
 *
                .prepareState()
                .admin()
                .getState()
    }
            equalTo(clusterManagerNodeName)
                .execute()
                .prepareState()
                    .prepareState()
        assertAcked(
                .getName(),
                .getName(),
                    .setClusterManagerNodeTimeout("100ms")
                    .execute()
        );
                .getName(),
 * Licensed to Elasticsearch under one or more contributor
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(clusterManagerNodeName));
            internalCluster().clusterManagerClient()
                .admin()
                .cluster()
            internalCluster().nonClusterManagerClient()
        );
            equalTo(nextClusterManagerEligibleNodeName)
                    .actionGet()
                .getState()
 * not use this file except in compliance with the License.
                .cluster()
                client().admin()
public class SpecificClusterManagerNodesIT extends OpenSearchIntegTestCase {
        assertThat(
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
                .execute()
 */
    }
 * license agreements. See the NOTICE file distributed with
                "{\"properties\" : {\"table_a\" : { \"type\" : \"nested\", "
                .nodes()
                .nodes()
    public void testSimpleOnlyClusterManagerNodeElection() throws IOException {
            } catch (Exception e) {
            assertThat(
                .nodes()
                .admin()
import java.io.IOException;
                    .prepareState()
 *    http://www.apache.org/licenses/LICENSE-2.0
            fail("should not be able to find cluster-manager");
                .admin()
                    .nodes()
                .getClusterManagerNode()
/*
 * this file be licensed under the Apache-2.0 license or a
                .execute()
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
                    .setClusterManagerNodeTimeout("100ms")
        } catch (ClusterManagerNotDiscoveredException e) {
        });
            fail("should not be able to find cluster-manager");
                .execute()
            assertThat(
        }
        }
/*
                .getClusterManagerNode()
                .nodes()
        logger.info("--> start cluster-manager node (2)");
        assertBusy(() -> {
import static org.opensearch.test.NodeRoles.nonDataNode;
        );
        final String clusterManagerNodeName = internalCluster().startClusterManagerOnlyNode();
                .getName(),
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
                .execute()
            Settings.builder().put(nonDataNode(clusterManagerNode())).put(clusterManagerDataPathSettings)
import org.opensearch.index.query.QueryBuilders;
    }
                client().admin()
 * compatible open source license.
                .getClusterManagerNode()
                    .cluster()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    .getState()
                .cluster()
        };
                .cluster()
        } catch (ClusterManagerNotDiscoveredException e) {
            .addAlias(
            );
        );
}
import java.util.function.Supplier;
                .getClusterManagerNode()
                .actionGet()
            internalCluster().clusterManagerClient()
                .prepareState()
                .prepareState()
        // removing the cluster-manager from the voting configuration immediately triggers the cluster-manager to step down
        logger.info("--> start data node / non cluster-manager node");
                    .nodes()
            assertThat(getClusterManagerIfElected.get(), equalTo(nextClusterManagerEligableNodeName));
                .nodes()
                    .execute()
            internalCluster().clusterManagerClient()
import org.opensearch.test.InternalTestCluster;
                .getName(),
            .prepareAliases()
                .nodes()
@ClusterScope(scope = Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
 *
        } catch (ClusterManagerNotDiscoveredException e) {
import org.apache.lucene.search.join.ScoreMode;
                .admin()
                .nodes()
                    .execute()
                return null;
            equalTo(clusterManagerNodeName)
                "a_test",
        internalCluster().startNode(Settings.builder().put(dataOnlyNode()).put("discovery.initial_state_timeout", "1s"));
                    .nodes()
                .admin()
                .cluster()
                .execute()
                .execute()
                .prepareState()
                    .getState()
        final String clusterManagerNodeName = internalCluster().startClusterManagerOnlyNode();
                    .prepareState()
                .admin()
                .getClusterManagerNode()
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
                    .actionGet()
        );
        logger.info("--> closing cluster-manager node (1)");
                    .getState()
 *
            internalCluster().nonClusterManagerClient()
                .actionGet()
                .actionGet()
                    .cluster()
                    .nodes()
            // all is well, no cluster-manager elected
            try {
                QueryBuilders.nestedQuery("table_a", QueryBuilders.termQuery("table_a.field_b", "y"), ScoreMode.Avg)
                .nodes()
                .getName(),
                .execute()
                    .getClusterManagerNodeId(),
        assertThat(
            internalCluster().nonClusterManagerClient()
        logger.info("--> start cluster-manager node");
                .getState()
        assertThat(
        assertThat(
            );
            equalTo(nextClusterManagerEligableNodeName)
 * specific language governing permissions and limitations
        assertThat(
                nullValue()
            );
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
                .actionGet()
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
 */
        assertThat(
        try {
                .getState()
        );
                .execute()
                .admin()
 * this work for additional information regarding copyright
                    .getName();
                .getName(),
                .prepareState()
                    .prepareState()
 */
                    .prepareState()
        try {
        }
                .getState()
            prepareCreate("test").setMapping(
        assertThat(
                .getClusterManagerNode()
            internalCluster().nonClusterManagerClient()
        );
                return internalCluster().nonClusterManagerClient()
        logger.info("--> start cluster-manager node / non data");
            .indices()
        Supplier<String> getClusterManagerIfElected = () -> {
                .cluster()
        internalCluster().startNode(Settings.builder().put(dataOnlyNode()).put("discovery.initial_state_timeout", "1s"));
                    .actionGet()
        assertThat(
                .getClusterManagerNode()
            )
            equalTo(clusterManagerNodeName)
        );
                .prepareState()
                .admin()
                    .getClusterManagerNodeId(),
                    .cluster()
            .get();
                .nodes()
        assertThat(
                .getName(),
                .actionGet()
                    .getName(),
                .getState()
                    .execute()
        );
                nullValue()
                    .actionGet()
                .actionGet()
                    .getClusterManagerNode()
                .getState()
package org.opensearch.cluster;
        internalCluster().startClusterManagerOnlyNode();
 * software distributed under the License is distributed on an
                .execute()
                    .getClusterManagerNodeId(),
        logger.info("--> start cluster-manager node (1)");
 * You may obtain a copy of the License at
        final String nextClusterManagerEligableNodeName = internalCluster().startClusterManagerOnlyNode();
                .getName(),
import static org.opensearch.test.NodeRoles.dataOnlyNode;
                .actionGet()
            equalTo(clusterManagerNodeName)
                nullValue()
                    .setClusterManagerNodeTimeout("100ms")
                .admin()
        );
        );
        logger.info("--> start previous cluster-manager node again");
        Settings clusterManagerDataPathSettings = internalCluster().dataPathSettings(internalCluster().getClusterManagerName());
        assertThat(
                .getClusterManagerNode()
        internalCluster().stopCurrentClusterManagerNode();
            assertThat(
                    .actionGet()
import org.opensearch.test.OpenSearchIntegTestCase;
                .getState()
                    + "\"properties\" : {\"field_a\" : { \"type\" : \"keyword\" },\"field_b\" :{ \"type\" : \"keyword\" }}}}}"
            equalTo(clusterManagerNodeName)
                internalCluster().clusterManagerClient()
                    .admin()
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * SPDX-License-Identifier: Apache-2.0
        client().admin()
                logger.debug("failed to get cluster-manager name", e);
    public void testElectOnlyBetweenClusterManagerNodes() throws Exception {
    public void testAliasFilterValidation() {
                    .execute()
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.nullValue;
                .getState()
            );
                .prepareState()
                .cluster()
                    .admin()
            )
        );
                    .cluster()
            equalTo(nextClusterManagerEligableNodeName)
                    .getState()
            internalCluster().nonClusterManagerClient()
                .prepareState()
                .cluster()
        logger.info("--> start data node / non cluster-manager node");
        try {
                .getState()
                .actionGet()
            internalCluster().clusterManagerClient()
                .actionGet()
            }
            internalCluster().clusterManagerClient()
                    .getState()
import static org.hamcrest.Matchers.equalTo;
                .getName(),
        final String nextClusterManagerEligibleNodeName = internalCluster().startNode(
                .actionGet()
                .actionGet()
 * Unless required by applicable law or agreed to in writing,

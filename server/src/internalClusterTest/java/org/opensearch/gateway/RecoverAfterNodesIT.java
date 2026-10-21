import java.util.Set;
        return blocks;
                .blocks()
                .global(ClusterBlockLevel.METADATA_WRITE),
    public Set<ClusterBlock> waitForNoBlocksOnNode(TimeValue timeout, Client nodeClient) {
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, data1).isEmpty(), equalTo(true));
                .blocks()
 * not use this file except in compliance with the License.
        assertThat(
                .getState()
        logger.info("--> start data_node (2)");
                .prepareState()
                .prepareState()
                .getState()
        logger.info("--> start cluster_manager_node (1)");
                .prepareState()
 *
        assertThat(
 * ownership. Elasticsearch licenses this file to you under
                .actionGet()
                .execute()
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
                .execute()
                .execute()
                .setLocal(true)
                .actionGet()
        assertThat(
                .setLocal(true)
        Set<ClusterBlock> blocks;
 * Licensed to Elasticsearch under one or more contributor
            data1.admin()
        do {
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.unit.TimeValue;
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, clientNode3).isEmpty(), equalTo(true));
 * this work for additional information regarding copyright
import static org.opensearch.test.NodeRoles.dataOnlyNode;
                .global(ClusterBlockLevel.METADATA_WRITE),
                .setLocal(true)
        Thread.sleep(BLOCK_WAIT_TIMEOUT.millis());
                .execute()
        assertThat(
                .execute()
                .cluster()
                .prepareState()
        Client clientNode2 = startNode(Settings.builder().put(GatewayService.RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 3));
                .cluster()
        assertThat(
/*
import static org.hamcrest.Matchers.hasItem;
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
                .getState()
import org.opensearch.cluster.block.ClusterBlockLevel;
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, clusterManager2).isEmpty(), equalTo(true));
            clusterManager1.admin()
                .execute()
            blocks = nodeClient.admin()
        );
                .blocks()
        } while (!blocks.isEmpty() && (System.currentTimeMillis() - start) < timeout.millis());
                .actionGet()
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
        );
            clientNode1.admin()
        );
            data1.admin()
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
                .global(ClusterBlockLevel.METADATA_WRITE),
public class RecoverAfterNodesIT extends OpenSearchIntegTestCase {
/*
                .blocks()
 */
        );
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, clientNode1).isEmpty(), equalTo(true));
import org.opensearch.transport.client.Client;
                .setLocal(true)
                .global(ClusterBlockLevel.METADATA_WRITE),
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
                .prepareState()
 * the Apache License, Version 2.0 (the "License"); you may
                .setLocal(true)
        assertThat(
                .execute()
 * under the License.
    }
package org.opensearch.gateway;
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
                .setLocal(true)
 * specific language governing permissions and limitations
                .actionGet()
                .execute()
                .getState()
            clusterManager1.admin()
                .execute()
                .actionGet()
}
                .cluster()
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
 * Unless required by applicable law or agreed to in writing,
                .prepareState()
                .blocks()
                .blocks()
        assertThat(
                .global(ClusterBlockLevel.METADATA_WRITE),
        );
                .cluster()
@ClusterScope(scope = Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
 * KIND, either express or implied.  See the License for the
 */
                .cluster()
                .prepareState()
            clusterManager2.admin()
 * license agreements. See the NOTICE file distributed with
                .cluster()
        );
        logger.info("--> start node (2)");
                .cluster()
                .setLocal(true)
                .cluster()
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, clientNode2).isEmpty(), equalTo(true));
        Client clusterManager1 = startNode(Settings.builder().put("gateway.recover_after_data_nodes", 2).put(clusterManagerOnlyNode()));
        assertThat(
        return internalCluster().client(name);
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, clusterManager1).isEmpty(), equalTo(true));
                .blocks()
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
 * The OpenSearch Contributors require contributions made to
    }
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.test.NodeRoles.clusterManagerOnlyNode;
        Client clientNode3 = startNode(Settings.builder().put(GatewayService.RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 3));
                .actionGet()
        logger.info("--> start data_node (1)");
                .getState()
                .blocks()
 * SPDX-License-Identifier: Apache-2.0
                .prepareState()
        Client data2 = startNode(Settings.builder().put("gateway.recover_after_data_nodes", 2).put(dataOnlyNode()));
                .global(ClusterBlockLevel.METADATA_WRITE),
import org.opensearch.test.OpenSearchIntegTestCase;
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
                .global(ClusterBlockLevel.METADATA_WRITE),
 *    http://www.apache.org/licenses/LICENSE-2.0
                .global(ClusterBlockLevel.METADATA_WRITE);
                .setLocal(true)
                .global(ClusterBlockLevel.METADATA_WRITE),
            clientNode2.admin()
                .getState()
        logger.info("--> start node (1)");
 * You may obtain a copy of the License at
        logger.info("--> start node (3)");
 */
                .cluster()
                .blocks()
                .global(ClusterBlockLevel.METADATA_WRITE),
        Client clusterManager2 = startNode(Settings.builder().put("gateway.recover_after_data_nodes", 2).put(clusterManagerOnlyNode()));
 * compatible open source license.
 *
                .actionGet()
                .setLocal(true)
            clusterManager2.admin()
/*
        logger.info("--> start cluster_manager_node (2)");
                .execute()
                .actionGet()
        assertThat(
                .getState()
            clientNode1.admin()
                .actionGet()
        );
                .cluster()
        String name = internalCluster().startNode(Settings.builder().put(settings.build()));
                .getState()
    public Client startNode(Settings.Builder settings) {
import org.opensearch.common.settings.Settings;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.common.SuppressForbidden;
                .actionGet()
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, data2).isEmpty(), equalTo(true));
 *
import org.opensearch.cluster.block.ClusterBlock;
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
        long start = System.currentTimeMillis();
    @SuppressForbidden(reason = "Sleeping longer than timeout")
                .blocks()
    }
        Client data1 = startNode(Settings.builder().put("gateway.recover_after_data_nodes", 2).put(dataOnlyNode()));
                .prepareState()
        Client clientNode1 = startNode(Settings.builder().put(GatewayService.RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 3));
    public void testRecoverAfterDataNodes() throws Exception {
                .getState()
                .prepareState()
    private static final TimeValue BLOCK_WAIT_TIMEOUT = TimeValue.timeValueSeconds(10);
                .getState()
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
                .setLocal(true)
 * GitHub history for details.
    }
    public void testRecoverAfterNodes() throws Exception {

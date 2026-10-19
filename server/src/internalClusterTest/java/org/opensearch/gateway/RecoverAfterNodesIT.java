        internalCluster().setBootstrapClusterManagerNodeIndex(0);  
        Client clusterManager1 = startNode(Settings.builder().put("gateway.recover_after_data_nodes", 2).put(clusterManagerOnlyNode()));
                .setLocal(true)
        );  
                .cluster()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            data1.admin()
            clientNode1.admin()
 */
                .cluster()
                .actionGet()  
        Thread.sleep(BLOCK_WAIT_TIMEOUT.millis());
        logger.info("--> start node (1)");
                .cluster()  
                .setLocal(true)
            clientNode1.admin()  
 *    http://www.apache.org/licenses/LICENSE-2.0
                .setLocal(true)
            data1.admin()
 * You may obtain a copy of the License at  
                .setLocal(true)
import static org.opensearch.test.NodeRoles.clusterManagerOnlyNode;
                .actionGet()
        assertThat(  
    }
                .global(ClusterBlockLevel.METADATA_WRITE),
                .actionGet()
                .getState()
                .setLocal(true)  
        Client data1 = startNode(Settings.builder().put("gateway.recover_after_data_nodes", 2).put(dataOnlyNode()));
                .blocks()  
                .execute()
    @SuppressForbidden(reason = "Sleeping longer than timeout")
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
 * KIND, either express or implied.  See the License for the
        logger.info("--> start cluster_manager_node (2)");
                .global(ClusterBlockLevel.METADATA_WRITE),  
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, clusterManager2).isEmpty(), equalTo(true));
 * SPDX-License-Identifier: Apache-2.0
                .blocks()
                .execute()
                .prepareState()  
        Client data2 = startNode(Settings.builder().put("gateway.recover_after_data_nodes", 2).put(dataOnlyNode()));
                .getState()  
        );
                .prepareState()
        logger.info("--> start cluster_manager_node (1)");
 * Unless required by applicable law or agreed to in writing,
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)  
import org.opensearch.transport.client.Client;  
/*  
        );
        assertThat(
 */  
                .blocks()
                .blocks()
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, clientNode3).isEmpty(), equalTo(true));
        );
                .prepareState()  
 * ownership. Elasticsearch licenses this file to you under  
                .execute()  
                .execute()
                .prepareState()
package org.opensearch.gateway;
    public void testRecoverAfterNodes() throws Exception {  
        } while (!blocks.isEmpty() && (System.currentTimeMillis() - start) < timeout.millis());
                .cluster()
    public Set<ClusterBlock> waitForNoBlocksOnNode(TimeValue timeout, Client nodeClient) {
        );
        return blocks;  
        );
            blocks = nodeClient.admin()
                .prepareState()
        String name = internalCluster().startNode(Settings.builder().put(settings.build()));
@ClusterScope(scope = Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)  
        assertThat(  
                .execute()
                .getState()
        assertThat(
        logger.info("--> start data_node (1)");
 * GitHub history for details.
        do {
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
                .setLocal(true)
                .prepareState()  
        Client clientNode2 = startNode(Settings.builder().put(GatewayService.RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 3));  
                .prepareState()
                .setLocal(true)  
        );
 *
}
import static org.hamcrest.Matchers.hasItem;
                .execute()
 *
 * this work for additional information regarding copyright
import org.opensearch.cluster.block.ClusterBlock;
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
                .blocks()
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, clientNode2).isEmpty(), equalTo(true));
        return internalCluster().client(name);
            clusterManager2.admin()
    }  
                .getState()
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, clientNode1).isEmpty(), equalTo(true));  
/*  
                .prepareState()  
            clientNode2.admin()  
    public Client startNode(Settings.Builder settings) {  
                .blocks()  
        assertThat(  
                .getState()
        assertThat(
                .blocks()
 */  
                .cluster()
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(  
                .global(ClusterBlockLevel.METADATA_WRITE),  
                .getState()
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
import org.opensearch.common.SuppressForbidden;  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
            clusterManager1.admin()
        );
                .global(ClusterBlockLevel.METADATA_WRITE);
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import org.opensearch.common.unit.TimeValue;
                .execute()
                .getState()
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
 * license agreements. See the NOTICE file distributed with
                .blocks()
                .actionGet()
                .execute()  
        Client clientNode3 = startNode(Settings.builder().put(GatewayService.RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 3));
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, data1).isEmpty(), equalTo(true));
                .global(ClusterBlockLevel.METADATA_WRITE),  
import java.util.Set;
                .cluster()
                .actionGet()  
        assertThat(  
                .cluster()
                .actionGet()  
        logger.info("--> start node (3)");  
import static org.opensearch.test.NodeRoles.dataOnlyNode;
 * not use this file except in compliance with the License.
    }  
                .cluster()
 * Modifications Copyright OpenSearch Contributors. See
                .actionGet()
                .blocks()
                .global(ClusterBlockLevel.METADATA_WRITE),  
 * compatible open source license.
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, data2).isEmpty(), equalTo(true));  
                .prepareState()  
                .global(ClusterBlockLevel.METADATA_WRITE),  
/*
public class RecoverAfterNodesIT extends OpenSearchIntegTestCase {
 *  
                .blocks()
                .getState()
        logger.info("--> start data_node (2)");
 * The OpenSearch Contributors require contributions made to  
                .getState()
        Client clusterManager2 = startNode(Settings.builder().put("gateway.recover_after_data_nodes", 2).put(clusterManagerOnlyNode()));
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
                .getState()  
import org.opensearch.test.OpenSearchIntegTestCase;  
                .actionGet()  
                .prepareState()  
                .global(ClusterBlockLevel.METADATA_WRITE),
            clusterManager2.admin()
                .actionGet()  
        logger.info("--> start node (2)");
                .execute()
        assertThat(  
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.common.settings.Settings;
                .setLocal(true)
                .setLocal(true)
        Set<ClusterBlock> blocks;  
                .actionGet()  
            clusterManager1.admin()
        );
    }
                .cluster()
                .execute()
    public void testRecoverAfterDataNodes() throws Exception {
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
import org.opensearch.cluster.block.ClusterBlockLevel;
        assertThat(waitForNoBlocksOnNode(BLOCK_WAIT_TIMEOUT, clusterManager1).isEmpty(), equalTo(true));  
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)  
            hasItem(GatewayService.STATE_NOT_RECOVERED_BLOCK)
        long start = System.currentTimeMillis();
 * specific language governing permissions and limitations
        Client clientNode1 = startNode(Settings.builder().put(GatewayService.RECOVER_AFTER_DATA_NODES_SETTING.getKey(), 3));  
    private static final TimeValue BLOCK_WAIT_TIMEOUT = TimeValue.timeValueSeconds(10);
                .global(ClusterBlockLevel.METADATA_WRITE),  
                .cluster()  
                .setLocal(true)
                .global(ClusterBlockLevel.METADATA_WRITE),

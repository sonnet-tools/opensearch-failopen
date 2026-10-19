 * Modifications Copyright OpenSearch Contributors. See
            Settings.builder().put(IndicesService.WRITE_DANGLING_INDICES_INFO_SETTING.getKey(), false).build()
 * Licensed to Elasticsearch under one or more contributor  
        internalCluster().startClusterManagerOnlyNode(clusterManagerNodeDataPathSettings);
        executeRepurposeCommand(noClusterManagerNoDataSettingsForClusterManagerNode, 1, 0);  
/*  
public class NodeRepurposeCommandIT extends OpenSearchIntegTestCase {  
        assertTrue(client().prepareGet(indexName, "1").get().isExists());
import org.opensearch.indices.IndicesService;
            .put(clusterManagerNodeDataPathSettings)  
        internalCluster().stopRandomNode(s -> true);  
        expectThrows(NoShardAvailableActionException.class, () -> client().prepareGet(indexName, "1").get());
        final Settings clusterManagerNodeDataPathSettings = internalCluster().dataPathSettings(clusterManagerNode);  
        prepareCreate(indexName, Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0)).get();  
        logger.info("--> restarting node with node.data=false and node.master=false");
import org.opensearch.common.settings.Settings;
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.allOf;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * not use this file except in compliance with the License.
    private void executeRepurposeCommand(Settings settings, int expectedIndexCount, int expectedShardCount) throws Exception {
            .build();  
        );
    public void testRepurpose() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            containsString(NodeRepurposeCommand.noClusterManagerMessage(expectedIndexCount, expectedShardCount, 0)),
import org.hamcrest.Matcher;
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
        final Settings dataNodeDataPathSettings = internalCluster().dataPathSettings(dataNode);
    }  
 * Unless required by applicable law or agreed to in writing,
        );  
/*
        internalCluster().stopRandomDataNode();
 *
        // by restarting as cluster-manager and data node, we can check that the index definition was really deleted and also that the tool
        final Settings noClusterManagerNoDataSettingsForClusterManagerNode = Settings.builder()
            .put(noClusterManagerNoDataSettings)
 * license agreements. See the NOTICE file distributed with
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();  
            NodeRepurposeCommandTests.conditionalNot(containsString("test-repurpose"), verbose == false)  
        ensureGreen();
        boolean verbose = randomBoolean();
        // index is gone.  
import org.opensearch.test.OpenSearchIntegTestCase;
        logger.info("--> creating index");
import org.opensearch.action.NoShardAvailableActionException;
        OpenSearchException lockedException = expectThrows(  
        IllegalStateException ex = expectThrows(  
        final Settings noClusterManagerNoDataSettingsForDataNode = Settings.builder()  
        );
import java.util.Arrays;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        final String indexName = "test-repurpose";  
        executeRepurposeCommand(noClusterManagerNoDataSettingsForDataNode, 1, 1);
            IllegalStateException.class,
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        Matcher<String> matcher = allOf(
        logger.info("--> starting two nodes");
 * GitHub history for details.
        assertTrue(indexExists(indexName));
        internalCluster().stopRandomNode(s -> true);
        assertThat(lockedException.getMessage(), containsString(NodeRepurposeCommand.FAILED_TO_OBTAIN_NODE_LOCK_MSG));
 */  
        logger.info("--> Restarting and repurposing other node");
        Settings settingsWithPath = Settings.builder().put(internalCluster().getDefaultSettings()).put(settings).build();  
            () -> executeRepurposeCommand(noClusterManagerNoDataSettingsForClusterManagerNode, 1, 1)
/*  
import org.opensearch.test.NodeRoles;  
}
        NodeRepurposeCommandTests.verifySuccess(settingsWithPath, matcher, verbose);
 * You may obtain a copy of the License at  
        internalCluster().startCoordinatingOnlyNode(dataNodeDataPathSettings);
import static org.hamcrest.Matchers.containsString;  
 */
            Collections.unmodifiableSet(new HashSet<>(Arrays.asList(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.MASTER_ROLE)))
import org.opensearch.cluster.node.DiscoveryNodeRole;  
            () -> internalCluster().startCoordinatingOnlyNode(dataNodeDataPathSettings)  
 */  
        final String dataNode = internalCluster().startDataOnlyNode(
import java.util.Collections;
        );
            .put(dataNodeDataPathSettings)
        logger.info("--> Starting node after repurpose");
        assertFalse(indexExists(indexName));
        ensureGreen();
            .put(noClusterManagerNoDataSettings)
import java.util.HashSet;  
        logger.info("--> Repurposing node 1");  
        // does not mess things up so much that the nodes cannot boot as cluster-manager or data node any longer.  
package org.opensearch.env;
        internalCluster().startDataOnlyNode(dataNodeDataPathSettings);
        logger.info("--> indexing a simple document");
        client().prepareIndex(indexName).setId("1").setSource("field1", "value1").get();  
        );  
import org.opensearch.OpenSearchException;
 * under the License.  
            "Node started with node.data=false and node.master=false while having existing index metadata must fail",
 *  
 *
        final Settings noClusterManagerNoDataSettings = NodeRoles.removeRoles(  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
            .build();
        // verify test setup
            OpenSearchException.class,

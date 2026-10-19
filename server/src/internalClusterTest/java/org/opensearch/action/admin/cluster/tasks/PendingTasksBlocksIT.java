                assertNotNull(response.getPendingTasks());
        )) {  
        }  
            ensureGreen("test");
    }  
        }
            SETTING_BLOCKS_READ,
                enableIndexBlock("test", blockSetting);
            } finally {
 *
        // starting one more node allows the cluster to recover  
}
 * You may obtain a copy of the License at  
import org.opensearch.test.OpenSearchIntegTestCase;
            @Override
import org.opensearch.common.settings.Settings;
            PendingClusterTasksResponse response = client().admin().cluster().preparePendingClusterTasks().get();
 * the Apache License, Version 2.0 (the "License"); you may
        if (randomBoolean()) {  
    public void testPendingTasksWithIndexBlocks() {
    }  
                PendingClusterTasksResponse response = client().admin().cluster().preparePendingClusterTasks().get();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;  
        }  
 * Licensed to Elasticsearch under one or more contributor  
        internalCluster().fullRestart(new InternalTestCluster.RestartCallback() {
package org.opensearch.action.admin.cluster.tasks;
            SETTING_READ_ONLY_ALLOW_DELETE
                return Settings.builder().put(GatewayService.RECOVER_AFTER_DATA_NODES_SETTING.getKey(), dataNodesCount + 1).build();
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
import java.util.Arrays;  
 * this work for additional information regarding copyright
public class PendingTasksBlocksIT extends OpenSearchIntegTestCase {
 * ownership. Elasticsearch licenses this file to you under  
            }
/*
        ensureGreen("test");  
        if (randomBoolean()) {  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
        ensureGreen();
 * under the License.  
        // restart the cluster but prevent it from performing state recovery
    public void testPendingTasksWithClusterReadOnlyBlock() {
 * specific language governing permissions and limitations
            assertNotNull(response.getPendingTasks());
    public void testPendingTasksWithClusterNotRecoveredBlock() throws Exception {
            ensureGreen("test");
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        }
/*  
 * GitHub history for details.
 */
        // This test checks that the Pending Cluster Tasks operation is never blocked, even if an index is read only or whatever.
            SETTING_BLOCKS_METADATA,
 * license agreements. See the NOTICE file distributed with
            }
                disableIndexBlock("test", blockSetting);  
import org.opensearch.test.InternalTestCluster;  
        assertNotNull(client().admin().cluster().preparePendingClusterTasks().get().getPendingTasks());
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
            createIndex("test");
            setClusterReadOnly(true);  
                return false;  
            createIndex("test");
    }  
        createIndex("test");
            try {
        });
            @Override
            }
import org.opensearch.gateway.GatewayService;
        internalCluster().startDataOnlyNode(); // cannot update minimum_cluster_manager_nodes before the cluster has formed
        try {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
 *  
            setClusterReadOnly(false);
        for (String blockSetting : Arrays.asList(  
            SETTING_READ_ONLY,  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
        final int dataNodesCount = client().admin().cluster().prepareNodesInfo("data:true").get().getNodes().size();  
 *
        } finally {  
            public boolean validateClusterForming() {
            public Settings onNodeStopped(String nodeName) {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;  
 */  
 */  
            SETTING_BLOCKS_WRITE,
 * software distributed under the License is distributed on an
/*  

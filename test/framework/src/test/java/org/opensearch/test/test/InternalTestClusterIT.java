            }
                    public Settings onNodeStopped(String nodeName) throws Exception {
    public void testOperationsDuringRestart() throws Exception {
 * Unless required by applicable law or agreed to in writing,
                internalCluster().validateClusterFormed();  
 * license agreements. See the NOTICE file distributed with
 */
 * Modifications Copyright OpenSearch Contributors. See  
 * SPDX-License-Identifier: Apache-2.0
        // transition, even though in a stable cluster the 3->2 transition requires no special treatment.
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
        ensureGreen();
                        ensureGreen();
    public void testStartingAndStoppingNodes() throws IOException {
import org.opensearch.test.InternalTestCluster;
                    }
        // If the nodes shut down too quickly then this reconfiguration does not have time to occur and the quorum is lost in the 3->2
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * under the License.  
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import java.io.IOException;  
            public Settings onNodeStopped(String nodeName) throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        internalCluster().startNodes(5);
        internalCluster().startClusterManagerOnlyNode();  
        if (internalCluster().size() < 5) {  
import org.opensearch.transport.client.node.NodeClient;
            @Override  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ensureGreen();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
 * compatible open source license.
 * not use this file except in compliance with the License.
                        internalCluster().validateClusterFormed();  
        }
 */
            internalCluster().stopRandomNode(s -> true);
        });  
 */  
import org.opensearch.test.OpenSearchIntegTestCase;
        logger.info("--> cluster has [{}] nodes", internalCluster().size());
        ensureGreen();
            final int nodesToStart = randomIntBetween(Math.max(2, internalCluster().size() + 1), 5);
        }  
/*
        while (internalCluster().size() > 1) {
            internalCluster().ensureAtMostNumDataNodes(nodesToRemain);
                });  
            logger.info("--> reducing to [{}] nodes", nodesToRemain);  
            assertThat(internalCluster().size(), lessThanOrEqualTo(nodesToRemain));
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        while (internalCluster().size() > 1) {
        internalCluster().startDataOnlyNodes(2);
                return super.onNodeStopped(nodeName);
    }  
 * KIND, either express or implied.  See the License for the
                    @Override  
 * ownership. Elasticsearch licenses this file to you under  
                internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
            internalCluster().startNodes(nodesToStart);  
import org.opensearch.common.settings.Settings;  
        }  
/*  
            final int nodesToRemain = randomIntBetween(1, internalCluster().size() - 1);
 *  
    }
    }  
public class InternalTestClusterIT extends OpenSearchIntegTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
                assertNotNull(internalCluster().getInstance(NodeClient.class));
                        return super.onNodeStopped(nodeName);
 *
/*
package org.opensearch.test.test;
        // In a 5+ node cluster there must be at least one reconfiguration as the nodes are shut down one-by-one before we drop to 2 nodes.  
 * GitHub history for details.
        ensureGreen();
                ensureGreen();
            logger.info("--> growing to [{}] nodes", nodesToStart);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 *
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
}
    public void testStoppingNodesOneByOne() throws IOException {

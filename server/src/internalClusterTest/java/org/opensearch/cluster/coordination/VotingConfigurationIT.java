    }  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
        for (DiscoveryNode discoveryNode : clusterState.nodes()) {  
        assertNotEquals(originalClusterManager, internalCluster().getClusterManagerName());
 */
import java.util.Set;
import static org.hamcrest.Matchers.hasItem;  
            .setMetadata(true)
        final List<String> nodeNames = internalCluster().startNodes(4);
        assertThat(newClusterState.nodes().getClusterManagerNode().getName(), equalTo(excludedNodeName));
    @Override
 * this work for additional information regarding copyright
            newClusterState.getLastCommittedConfiguration().getNodeIds(),  
                .cluster()
            .cluster()
                senderTransportService.addSendBehavior(
                .prepareHealth()  
                .isTimedOut()
                assertThat(excludedNodeName, nullValue());
        // should then add itself into the voting configuration.  
        client().execute(AddVotingConfigExclusionsAction.INSTANCE, new AddVotingConfigExclusionsRequest(originalClusterManager)).get();  
            .clear()  
        final ClusterState newClusterState = internalCluster().client()
                        connection.sendRequest(requestId, action, request, options);
 * specific language governing permissions and limitations
                .setWaitForNodes("4")
            internalCluster().client()  
            if (sender.equals(excludedNodeName)) {
            .setNodes(true)
            .get()  
            }
                    (connection, requestId, action, request, options) -> {  
    }  
 * You may obtain a copy of the License at  
 * under the License.  
        assertFalse(
                excludedNodeName = discoveryNode.getName();  
import org.opensearch.OpenSearchException;  
                    internalCluster().getInstance(TransportService.class, receiver),
                .isTimedOut()
        assertThat(votingConfiguration, hasItem(clusterState.nodes().getClusterManagerNodeId()));
                    }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.transport.MockTransportService;
        internalCluster().setBootstrapClusterManagerNodeIndex(0);  
 *  
                sender
 * GitHub history for details.
            );
        String excludedNodeName = null;
import java.util.List;
        );
            if (votingConfiguration.contains(discoveryNode.getId()) == false) {
 * not use this file except in compliance with the License.
import org.opensearch.cluster.ClusterState;  
 * KIND, either express or implied.  See the License for the
/*  
        // a 4-node cluster settles on a 3-node configuration; we then prevent the nodes in the configuration from winning an election  
package org.opensearch.cluster.coordination;
                .get()  
import org.opensearch.test.OpenSearchIntegTestCase;
/*
            for (final String receiver : nodeNames) {  
            .setMetadata(true)
                        }  
                .prepareHealth()  
        assertFalse(
        assertThat(
        final Set<String> votingConfiguration = clusterState.getLastCommittedConfiguration().getNodeIds();
import java.util.concurrent.ExecutionException;  
            .admin()
            .prepareState()
 */
import org.opensearch.common.Priority;
                .cluster()
            .setNodes(true)  
 */  
            .get()
            .cluster()  
                );  
        assertThat(clusterState.nodes().getSize(), equalTo(4));
        final ClusterState clusterState = internalCluster().client()
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.hasSize;
        internalCluster().stopCurrentClusterManagerNode();
                .setWaitForEvents(Priority.LANGUID)
            final MockTransportService senderTransportService = (MockTransportService) internalCluster().getInstance(
        }
    public void testAbdicateAfterVotingConfigExclusionAdded() throws ExecutionException, InterruptedException {  
import static org.hamcrest.Matchers.nullValue;
    public void testElectsNodeNotInVotingConfiguration() throws Exception {
import static org.hamcrest.Matchers.equalTo;
 *
        return Collections.singletonList(MockTransportService.TestPlugin.class);  
            .admin()  
/*
 * The OpenSearch Contributors require contributions made to  
            .getState();  
 * Unless required by applicable law or agreed to in writing,
    }
            .getState();
            .prepareState()
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
        logger.info("--> excluding cluster-manager node {}", originalClusterManager);
        }
import java.util.Collection;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .get()  
                        if (action.equals(PreVoteCollector.REQUEST_PRE_VOTE_ACTION_NAME)) {
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
import org.opensearch.plugins.Plugin;  
            }
            hasItem(newClusterState.nodes().getClusterManagerNodeId())
 * the Apache License, Version 2.0 (the "License"); you may
        internalCluster().startNodes(2);
}
import org.opensearch.transport.TransportService;  
            internalCluster().client()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
        // extra node
 * compatible open source license.
        // by failing at the pre-voting stage, so that the extra node must be elected instead when the cluster-manager shuts down. This
import java.util.Collections;  
        );
        final String originalClusterManager = internalCluster().getClusterManagerName();  
                TransportService.class,  
 * Modifications Copyright OpenSearch Contributors. See  
 * software distributed under the License is distributed on an
                .admin()
                .admin()
                            throw new OpenSearchException("rejected");
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
            }
import org.opensearch.cluster.node.DiscoveryNode;
public class VotingConfigurationIT extends OpenSearchIntegTestCase {
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
            .clear()
                .setWaitForNodes("3")
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get();
 *
        for (final String sender : nodeNames) {
                .setWaitForEvents(Priority.LANGUID)
        assertThat(votingConfiguration, hasSize(3));  
        );
 * this file be licensed under the Apache-2.0 license or a
                continue;  

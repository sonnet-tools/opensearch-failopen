 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                clusterStateResponse.getState().nodes().getClusterManagerNodeId()
                    .getLastCommittedConfiguration()
            false
                .metadata()
                .clear()
                .setNodes(true)  
                    greaterThanOrEqualTo(waitForMetadataVersion)
            final DiscoveryNodes discoveryNodes = client(node).admin()
                .setNodes(true)
        );
        assertingThread.start();
 * this file be licensed under the Apache-2.0 license or a
 */
                assertThat(
    public void testLocalRequestAlwaysSucceeds() throws Exception {
                    "waited for metadata version " + waitForMetadataVersion + " with node " + node,
        });
    }  
            internalCluster().getInstances(TransportService.class).spliterator(),
                () -> randomFrom(internalCluster().getNodeNames())
        final List<MockTransportService> mockTransportServices = StreamSupport.stream(  
                    clusterManagerName,  
                mockTransportService.addFailToSendNoConnectRule(clusterManagerTransportService);
            while (shutdown.get() == false) {
import java.util.stream.Collectors;
import org.opensearch.cluster.node.DiscoveryNode;
    }
                .setWaitForTimeOut(TimeValue.timeValueMillis(100))  
                );
                .prepareState()
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        });
                    .get()
        }  
/*
                .getClusterApplierService()  
            } catch (ClusterManagerNotDiscoveredException e) {
                    .filter(n -> ClusterBootstrapService.isBootstrapPlaceholder(n) == false)
                .prepareState()
                    client(nonClusterManagerNode).admin()
                .clear()
            TransportService.class,  
            final ClusterStateResponse clusterStateResponse;  
            }
                .setClusterManagerNodeTimeout(TimeValue.timeValueMillis(100))
/*  
                "should always contain a cluster-manager node",
            assertNotNull(  
            final ClusterStateResponse clusterStateResponse = client(node).admin()
                .prepareState()  
                .setLocal(true)
 * GitHub history for details.
        runRepeatedlyWhileChangingClusterManager(() -> {
public class TransportClusterStateActionDisruptionIT extends OpenSearchIntegTestCase {  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            }  
        assertingThread.join();  
    public void testLocalRequestWaitsForMetadata() throws Exception {
 */  
                    .collect(Collectors.toSet()),
            }  
                .cluster()
                    .clear()  
import org.opensearch.common.unit.TimeValue;
            while (shutdown.get() == false) {  
                .state()  
                clusterManagerTransportService.addFailToSendNoConnectRule(mockTransportService);  
import org.opensearch.plugins.Plugin;
 *
 *  
/*  
 * Modifications Copyright OpenSearch Contributors. See
                .setMetadata(true)  
            }
                assertAcked(  
                        .setPersistentSettings(Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), value))
        }, "updating thread");
                clusterStateResponse = clusterStateRequestBuilder.get();
 * ownership. Elasticsearch licenses this file to you under  
            if (clusterManagerTransportService != mockTransportService) {
                value = "none".equals(value) ? "all" : "none";
        });
            try {  
        runRepeatedlyWhileChangingClusterManager(() -> {
import org.opensearch.common.settings.Settings;
                .state()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public void testNonLocalRequestAlwaysFindsClusterManager() throws Exception {
                        .cluster()
                    .getNodeIds()
import static org.hamcrest.Matchers.hasSize;
                .setLocal(true)
            String value = "none";
    public void testNonLocalRequestAlwaysFindsClusterManagerAndWaitsForMetadata() throws Exception {
    @Override
        return Collections.singletonList(MockTransportService.TestPlugin.class);
 * the Apache License, Version 2.0 (the "License"); you may
        });  
                runnable.run();  
                }
                );
                .setClusterManagerNodeTimeout("100ms")
import org.opensearch.cluster.node.DiscoveryNodes;
        assertBusy(() -> {
        }, "asserting thread");
        runRepeatedlyWhileChangingClusterManager(() -> {  
import org.opensearch.transport.TransportService;
        });
                .setClusterManagerNodeTimeout(TimeValue.timeValueMillis(100))
 * specific language governing permissions and limitations
                .metadata()
        internalCluster().startNodes(3);
import java.util.Collections;
                .setWaitForMetadataVersion(waitForMetadataVersion)
 * license agreements. See the NOTICE file distributed with
                final Metadata metadata = clusterStateResponse.getState().metadata();  
                final String nonClusterManagerNode = randomValueOtherThan(
import org.opensearch.cluster.coordination.ClusterBootstrapService;
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.not;  
            assertThat(claimedClusterManagerName, not(equalTo(clusterManagerName)));
        assertBusy(
            if (clusterStateResponse.isWaitForTimedOut() == false) {
                .setWaitForTimeOut(TimeValue.timeValueMillis(100))  
            final long waitForMetadataVersion = randomLongBetween(Math.max(1, metadataVersion - 3), metadataVersion + 5);  
                .nodes();
                .setWaitForMetadataVersion(waitForMetadataVersion);
}
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.concurrent.atomic.AtomicBoolean;  
                return; // ok, we hit the disconnected node
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.test.transport.MockTransportService;  
 * The OpenSearch Contributors require contributions made to  
            final ClusterStateRequestBuilder clusterStateRequestBuilder = client().admin()  
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;  
                .clear()  
import org.opensearch.cluster.metadata.Metadata;  
                .setClusterManagerNodeTimeout("100ms");
            final long waitForMetadataVersion = randomLongBetween(Math.max(1, metadataVersion - 3), metadataVersion + 5);
import org.opensearch.cluster.ClusterState;
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING;
import java.util.Collection;  
    }  
                .setMetadata(true)
        final String clusterManagerName = internalCluster().getClusterManagerName();
        internalCluster().close();
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .prepareState()
    public void runRepeatedlyWhileChangingClusterManager(Runnable runnable) throws Exception {
            } catch (ClusterManagerNotDiscoveredException e) {  
 * SPDX-License-Identifier: Apache-2.0
                .cluster()  
                clusterStateResponse = clusterStateRequestBuilder.get();
                    .setMetadata(true)
            for (DiscoveryNode discoveryNode : discoveryNodes) {
 * compatible open source license.
                    .stream()  
            final ClusterStateRequestBuilder clusterStateRequestBuilder = client(node).admin()
package org.opensearch.action.admin.cluster.state;
                    .getState()  
            final String node = randomFrom(internalCluster().getNodeNames());  
                .prepareState()  
                    metadata.version(),  
                );
            clusterManagerName
            final long metadataVersion = internalCluster().getInstance(ClusterService.class, node)
                .cluster()
import java.util.List;
            );  
                .get();
        updatingThread.start();  
        final MockTransportService clusterManagerTransportService = (MockTransportService) internalCluster().getInstance(
                .cluster()
                .version();  
                    () -> randomFrom(internalCluster().getNodeNames())
                .setNodes(true)  
            final String claimedClusterManagerName = internalCluster().getClusterManagerName(nonClusterManagerNode);
        final Thread updatingThread = new Thread(() -> {
import java.util.stream.StreamSupport;
            fail("nodes did not contain [" + node + "]: " + discoveryNodes);
        shutdown.set(true);
            final ClusterStateResponse clusterStateResponse;
import org.opensearch.cluster.service.ClusterService;  
        final AtomicBoolean shutdown = new AtomicBoolean();  
    }
                return; // ok, we hit the disconnected node  
                if (discoveryNode.getName().equals(node)) {  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
            }  
                assertThat("waited for metadata version", state.metadata().version(), greaterThanOrEqualTo(waitForMetadataVersion));
                        .prepareUpdateSettings()  
            if (clusterStateResponse.isWaitForTimedOut() == false) {
            final String node = randomFrom(internalCluster().getNodeNames());
                assertNotNull("should always contain a cluster-manager node", state.nodes().getClusterManagerNodeId());
 * Unless required by applicable law or agreed to in writing,
    }
                .get()
            () -> assertThat(
        for (MockTransportService mockTransportService : mockTransportServices) {
 * under the License.  
            }
                .clear()
 * this work for additional information regarding copyright
        updatingThread.join();
 *
            }
        final Thread assertingThread = new Thread(() -> {
                    .cluster()
                .getState()  
                final ClusterState state = clusterStateResponse.getState();  
                    return;
        );
    }
                hasSize(3)  
                clusterManagerName,
            )
            final String nonClusterManagerNode = randomValueOtherThan(  
        runRepeatedlyWhileChangingClusterManager(() -> {
                .version();
            final String node = randomFrom(internalCluster().getNodeNames());  
 * software distributed under the License is distributed on an
 */  
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)
            }  
                .getClusterApplierService()
            final long metadataVersion = internalCluster().getInstance(ClusterService.class, node)
            try {
            );  
                client().admin()  
        ).map(ts -> (MockTransportService) ts).collect(Collectors.toList());  

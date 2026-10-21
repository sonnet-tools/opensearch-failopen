        });
                        .setPersistentSettings(Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), value))
        final Thread updatingThread = new Thread(() -> {
            if (clusterStateResponse.isWaitForTimedOut() == false) {
                .version();
            } catch (ClusterManagerNotDiscoveredException e) {
                    .getNodeIds()
                clusterStateResponse = clusterStateRequestBuilder.get();
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
                .getState()
                    return;
                    .getState()
 * ownership. Elasticsearch licenses this file to you under
        runRepeatedlyWhileChangingClusterManager(() -> {
    public void testNonLocalRequestAlwaysFindsClusterManager() throws Exception {
public class TransportClusterStateActionDisruptionIT extends OpenSearchIntegTestCase {
        updatingThread.start();
                value = "none".equals(value) ? "all" : "none";
/*
                final Metadata metadata = clusterStateResponse.getState().metadata();
            final ClusterStateResponse clusterStateResponse;
import java.util.stream.StreamSupport;
                clusterStateResponse = clusterStateRequestBuilder.get();
                    .getLastCommittedConfiguration()
                .nodes();
                .prepareState()
    @Override
import org.opensearch.test.OpenSearchIntegTestCase;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .setNodes(true)
            final long metadataVersion = internalCluster().getInstance(ClusterService.class, node)
import org.opensearch.test.transport.MockTransportService;
        );
                runnable.run();
    }
            );
        });
            }
 * Licensed to Elasticsearch under one or more contributor
                .clear()
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.node.DiscoveryNodes;
                .setClusterManagerNodeTimeout(TimeValue.timeValueMillis(100))
                .cluster()
import java.util.Collection;
                .clear()
                    "waited for metadata version " + waitForMetadataVersion + " with node " + node,
            assertThat(claimedClusterManagerName, not(equalTo(clusterManagerName)));
 * You may obtain a copy of the License at
            );
            clusterManagerName
import java.util.List;
            }
            final ClusterStateResponse clusterStateResponse;
                    .setMetadata(true)
 * specific language governing permissions and limitations
        shutdown.set(true);
            final long waitForMetadataVersion = randomLongBetween(Math.max(1, metadataVersion - 3), metadataVersion + 5);
        runRepeatedlyWhileChangingClusterManager(() -> {
                .metadata()
                    .prepareState()
            internalCluster().getInstances(TransportService.class).spliterator(),
                () -> randomFrom(internalCluster().getNodeNames())
            final ClusterStateResponse clusterStateResponse = client(node).admin()
        ).map(ts -> (MockTransportService) ts).collect(Collectors.toList());
            final ClusterStateRequestBuilder clusterStateRequestBuilder = client(node).admin()
 */
 */
import static org.hamcrest.Matchers.hasSize;
    }
import org.opensearch.cluster.service.ClusterService;
                    .get()
                .state()
            }
/*
        );
                    clusterManagerName,
/*
    }
                client().admin()
                hasSize(3)
import org.opensearch.cluster.metadata.Metadata;
                .setClusterManagerNodeTimeout("100ms")
        }, "updating thread");
                return; // ok, we hit the disconnected node
                .prepareState()
        final MockTransportService clusterManagerTransportService = (MockTransportService) internalCluster().getInstance(
            fail("nodes did not contain [" + node + "]: " + discoveryNodes);
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING;
            try {
        internalCluster().startNodes(3);
                .setMetadata(true)
                        .cluster()
        assertingThread.join();
        for (MockTransportService mockTransportService : mockTransportServices) {
        assertingThread.start();
                .cluster()
        });
                clusterStateResponse.getState().nodes().getClusterManagerNodeId()
            for (DiscoveryNode discoveryNode : discoveryNodes) {
        final String clusterManagerName = internalCluster().getClusterManagerName();
                .setWaitForTimeOut(TimeValue.timeValueMillis(100))
 * the Apache License, Version 2.0 (the "License"); you may
    public void testNonLocalRequestAlwaysFindsClusterManagerAndWaitsForMetadata() throws Exception {
                "should always contain a cluster-manager node",
            () -> assertThat(
                    client(nonClusterManagerNode).admin()
import org.opensearch.common.unit.TimeValue;
        runRepeatedlyWhileChangingClusterManager(() -> {
                    .collect(Collectors.toSet()),
 */
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
            final DiscoveryNodes discoveryNodes = client(node).admin()
        final List<MockTransportService> mockTransportServices = StreamSupport.stream(
                    metadata.version(),
import static org.hamcrest.Matchers.not;
        assertBusy(
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.coordination.ClusterBootstrapService;
}
 * under the License.
 * KIND, either express or implied.  See the License for the
                    .filter(n -> ClusterBootstrapService.isBootstrapPlaceholder(n) == false)
                .clear()
            )
            try {
import static org.hamcrest.Matchers.equalTo;
        final AtomicBoolean shutdown = new AtomicBoolean();
    }
 * not use this file except in compliance with the License.
                clusterManagerTransportService.addFailToSendNoConnectRule(mockTransportService);
                .getClusterApplierService()
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.ClusterState;
                .setLocal(true)
        });
    public void testLocalRequestAlwaysSucceeds() throws Exception {
            final String nonClusterManagerNode = randomValueOtherThan(
            TransportService.class,
    public void testLocalRequestWaitsForMetadata() throws Exception {
                );
            while (shutdown.get() == false) {
 * software distributed under the License is distributed on an
import org.opensearch.transport.TransportService;
                final String nonClusterManagerNode = randomValueOtherThan(
                assertThat(
                mockTransportService.addFailToSendNoConnectRule(clusterManagerTransportService);
                .get();
 * this work for additional information regarding copyright
            } catch (ClusterManagerNotDiscoveredException e) {
            }
            final String node = randomFrom(internalCluster().getNodeNames());
                final ClusterState state = clusterStateResponse.getState();
                    .clear()
            }
 *
            assertNotNull(
        assertBusy(() -> {
                clusterManagerName,
                    .stream()
        final Thread assertingThread = new Thread(() -> {
            final ClusterStateRequestBuilder clusterStateRequestBuilder = client().admin()
                .get()
        updatingThread.join();
import org.opensearch.plugins.Plugin;
    }
            final long waitForMetadataVersion = randomLongBetween(Math.max(1, metadataVersion - 3), metadataVersion + 5);
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;
 * compatible open source license.
                assertAcked(
            final String node = randomFrom(internalCluster().getNodeNames());
            final String claimedClusterManagerName = internalCluster().getClusterManagerName(nonClusterManagerNode);
        runRepeatedlyWhileChangingClusterManager(() -> {
                .setMetadata(true)
 * The OpenSearch Contributors require contributions made to
                .metadata()
                    greaterThanOrEqualTo(waitForMetadataVersion)
            }
                .state()
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)
                );
            false
                    () -> randomFrom(internalCluster().getNodeNames())
                if (discoveryNode.getName().equals(node)) {
            }
 *
 *
        }, "asserting thread");
                return; // ok, we hit the disconnected node
import org.opensearch.common.settings.Settings;
            if (clusterManagerTransportService != mockTransportService) {
        }
            final long metadataVersion = internalCluster().getInstance(ClusterService.class, node)
                }
                .prepareState()
                .clear()
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                .setWaitForMetadataVersion(waitForMetadataVersion);
                .getClusterApplierService()
package org.opensearch.action.admin.cluster.state;
                assertNotNull("should always contain a cluster-manager node", state.nodes().getClusterManagerNodeId());
 * this file be licensed under the Apache-2.0 license or a
                        .prepareUpdateSettings()
                assertThat("waited for metadata version", state.metadata().version(), greaterThanOrEqualTo(waitForMetadataVersion));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .cluster()
                    .cluster()
                .prepareState()
            String value = "none";
 * license agreements. See the NOTICE file distributed with
                .setWaitForMetadataVersion(waitForMetadataVersion)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.concurrent.atomic.AtomicBoolean;
    public void runRepeatedlyWhileChangingClusterManager(Runnable runnable) throws Exception {
        internalCluster().close();
                .setNodes(true)
            final String node = randomFrom(internalCluster().getNodeNames());
                .setNodes(true)
            while (shutdown.get() == false) {
                .setClusterManagerNodeTimeout(TimeValue.timeValueMillis(100))
                .setLocal(true)
        return Collections.singletonList(MockTransportService.TestPlugin.class);
                .setClusterManagerNodeTimeout("100ms");
        });
            if (clusterStateResponse.isWaitForTimedOut() == false) {
                .setWaitForTimeOut(TimeValue.timeValueMillis(100))
                );
                .version();
            }
import java.util.stream.Collectors;
                .cluster()

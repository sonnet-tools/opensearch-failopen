            .cluster()
 * SPDX-License-Identifier: Apache-2.0
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import java.util.Collection;
import com.google.api.services.compute.model.NetworkInterface;
                @Override
    /**
        return Settings.builder()
    @Override
            };
 * Licensed to Elasticsearch under one or more contributor
        assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForNodes(Integer.toString(3)).get());
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
            .clear()
/*
            .setClusterManagerNodeTimeout("1s")
     * Register an existing node as a GCE node
 * not use this file except in compliance with the License.
import java.util.concurrent.ConcurrentHashMap;
                            instance.setNetworkInterfaces(singletonList(networkInterface));
     * Asserts that the cluster nodes info contains an expected number of node
        final DiscoveryNode discoveryNode = transportService.getLocalNode();
    public static class TestPlugin extends GceDiscoveryPlugin {
        // start cluster-manager node
                }
import java.util.Map;
                @Override
        // start another node
    }
 * specific language governing permissions and limitations
        }
 * this file be licensed under the Apache-2.0 license or a
            .clear()
                            instances.add(instance);
                            networkInterface.setNetworkIP(discoveryNode.getAddress().toString());
        assertNumberOfNodes(2);
/*
            .build();
import org.opensearch.cluster.node.DiscoveryNode;
    }
 * software distributed under the License is distributed on an
     */
                        return instances;
 */
}
        if (nodes.put(discoveryNode.getName(), discoveryNode) != null) {
            .setNodes(true)
    }
            super(settings);
        assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForNodes(Integer.toString(2)).get());
    /**
    }
    public void clearGceNodes() {
                public Collection<Instance> instances() {
public class GceDiscoverTests extends OpenSearchIntegTestCase {
 * Modifications Copyright OpenSearch Contributors. See
            .get();
 * The OpenSearch Contributors require contributions made to
        nodes.clear();
                    });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @After
        clusterStateResponse = client(secondNode).admin()
                            instance.setName(discoveryNode.getName());
     * @param expected the expected number of nodes
            .setClusterManagerNodeTimeout("1s")
import org.junit.After;
                public String projectId() {
import static java.util.Collections.singletonList;
                            Instance instance = new Instance();
        final TransportService transportService = internalCluster().getInstance(TransportService.class, nodeName);
/*
                }
import java.util.List;
@OpenSearchIntegTestCase.ClusterScope(supportsDedicatedMasters = false, numDataNodes = 0, numClientNodes = 0)
            .put("cloud.gce.zone", "test")
            .put(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "gce")
     */
            .prepareState()
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
            throw new IllegalArgumentException("Node [" + discoveryNode.getName() + "] cannot be registered twice");
            .cluster()
     * Use {@link #registerGceNode(String)} method to expose nodes in the tests.
        final String thirdNode = internalCluster().startDataOnlyNode();
    }
        protected GceInstancesService createGceInstancesService() {
        assertNotNull(clusterStateResponse.getState().nodes().getClusterManagerNodeId());
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
package org.opensearch.discovery.gce;
    }
                            instance.setStatus("STARTED");
        assertNumberOfNodes(3);
    @Override
 *
                public List<String> zones() {
 * GitHub history for details.
    private static final Map<String, DiscoveryNode> nodes = new ConcurrentHashMap<>();
     *
     * Test plugin that exposes internal test cluster nodes as if they were real GCE nodes.
                    return AccessController.doPrivileged(() -> {
 * Unless required by applicable law or agreed to in writing,
                            NetworkInterface networkInterface = new NetworkInterface();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;
 *
        return singletonList(TestPlugin.class);
        assertEquals(expected, client().admin().cluster().prepareNodesInfo().clear().get().getNodes().size());
    protected Settings nodeSettings(int nodeOrdinal) {
        }
            .prepareState()
                        for (DiscoveryNode discoveryNode : nodes.values()) {
 * compatible open source license.
                }
import org.opensearch.plugins.Plugin;
     *
import com.google.api.services.compute.model.Instance;
import java.util.ArrayList;
            .put(super.nodeSettings(nodeOrdinal))
                        final List<Instance> instances = new ArrayList<>();
        final String secondNode = internalCluster().startNode();
import java.io.IOException;
            .setLocal(true)
        assertNotNull(discoveryNode);
        public TestPlugin(Settings settings) {
        registerGceNode(clusterManagerNode);
        ClusterStateResponse clusterStateResponse = client(clusterManagerNode).admin()
                public void close() throws IOException {}
            .setNodes(true)
 */
import org.opensearch.secure_sm.AccessController;
 */
    /** Holds a list of the current discovery nodes started in tests **/
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
                @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            return new GceInstancesService() {
     */
        @Override
                    return ZONE_SETTING.get(settings);
    public void testJoin() {
    private static void assertNumberOfNodes(final int expected) {
 * this work for additional information regarding copyright
    /**
        // wait for the cluster to form
        assertNotNull(transportService);
                    return PROJECT_SETTING.get(settings);
            .put("cloud.gce.project_id", "test")
            .get();
import org.opensearch.transport.TransportService;
import org.opensearch.common.settings.Settings;
    }
        assertNotNull(clusterStateResponse.getState().nodes().getClusterManagerNodeId());
                @Override
import org.opensearch.plugin.discovery.gce.GceDiscoveryPlugin;
import org.opensearch.cloud.gce.GceInstancesService;
 * ownership. Elasticsearch licenses this file to you under
 * under the License.
                        }
     * @param nodeName the name of the node
    private static void registerGceNode(final String nodeName) {
        registerGceNode(secondNode);
        // add one more node and wait for it to join
 *
        }
 * You may obtain a copy of the License at
        registerGceNode(thirdNode);
 * license agreements. See the NOTICE file distributed with

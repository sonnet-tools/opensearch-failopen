            .cluster()  
                        for (DiscoveryNode discoveryNode : nodes.values()) {
                            NetworkInterface networkInterface = new NetworkInterface();
import org.opensearch.plugins.Plugin;
            .put("cloud.gce.zone", "test")
        }
        // start cluster-manager node
import org.opensearch.transport.TransportService;
                            instances.add(instance);
     * Test plugin that exposes internal test cluster nodes as if they were real GCE nodes.  
                        return instances;
import java.util.List;
                    return ZONE_SETTING.get(settings);
        return singletonList(TestPlugin.class);
            .setNodes(true)
    public void testJoin() {  
    @Override
        ClusterStateResponse clusterStateResponse = client(clusterManagerNode).admin()
public class GceDiscoverTests extends OpenSearchIntegTestCase {
        clusterStateResponse = client(secondNode).admin()
     * @param nodeName the name of the node
import org.opensearch.cluster.node.DiscoveryNode;
     * Use {@link #registerGceNode(String)} method to expose nodes in the tests.
        assertEquals(expected, client().admin().cluster().prepareNodesInfo().clear().get().getNodes().size());
        final TransportService transportService = internalCluster().getInstance(TransportService.class, nodeName);
                    return PROJECT_SETTING.get(settings);
            throw new IllegalArgumentException("Node [" + discoveryNode.getName() + "] cannot be registered twice");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .clear()  
     */  
            .build();  
            .setNodes(true)
/*
 * under the License.  
        final String thirdNode = internalCluster().startDataOnlyNode();
import static java.util.Collections.singletonList;  
        public TestPlugin(Settings settings) {
        final String secondNode = internalCluster().startNode();  
            .prepareState()
 * ownership. Elasticsearch licenses this file to you under  
                            Instance instance = new Instance();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
        return Settings.builder()
    private static final Map<String, DiscoveryNode> nodes = new ConcurrentHashMap<>();
package org.opensearch.discovery.gce;
     *
     */
 * the Apache License, Version 2.0 (the "License"); you may
                @Override
import org.opensearch.cloud.gce.GceInstancesService;
        // wait for the cluster to form  
        }
            return new GceInstancesService() {
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
import org.opensearch.secure_sm.AccessController;  
        @Override  
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
                            instance.setName(discoveryNode.getName());
            .put(super.nodeSettings(nodeOrdinal))
                            instance.setNetworkInterfaces(singletonList(networkInterface));  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
            .prepareState()
 *  
                @Override  
     * @param expected the expected number of nodes
        protected GceInstancesService createGceInstancesService() {
@OpenSearchIntegTestCase.ClusterScope(supportsDedicatedMasters = false, numDataNodes = 0, numClientNodes = 0)
    }  
    }  
    }  
        // start another node
        registerGceNode(clusterManagerNode);  
import org.junit.After;  
        assertNotNull(transportService);  
        if (nodes.put(discoveryNode.getName(), discoveryNode) != null) {  
            .get();  
            .clear()  
            .get();
/*  
            .setLocal(true)
import java.io.IOException;
 * specific language governing permissions and limitations
import java.util.ArrayList;  
 *
 */  
        registerGceNode(thirdNode);  
        assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForNodes(Integer.toString(2)).get());
                        final List<Instance> instances = new ArrayList<>();  
    }
        assertNotNull(discoveryNode);
 * SPDX-License-Identifier: Apache-2.0
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                public Collection<Instance> instances() {
    /**
 * GitHub history for details.
    @After
        nodes.clear();  
 * not use this file except in compliance with the License.
                public String projectId() {
     */  
    }  
     *
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;  
 * Unless required by applicable law or agreed to in writing,
        assertNotNull(clusterStateResponse.getState().nodes().getClusterManagerNodeId());  
            .put(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "gce")  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
import com.google.api.services.compute.model.Instance;
    private static void registerGceNode(final String nodeName) {
                public List<String> zones() {  
    }
import org.opensearch.common.settings.Settings;  
        // add one more node and wait for it to join
        assertNotNull(clusterStateResponse.getState().nodes().getClusterManagerNodeId());
    public static class TestPlugin extends GceDiscoveryPlugin {  
    public void clearGceNodes() {
                public void close() throws IOException {}
        assertNumberOfNodes(2);
import com.google.api.services.compute.model.NetworkInterface;
                }  
                }
        registerGceNode(secondNode);
}  
            super(settings);  
            .setClusterManagerNodeTimeout("1s")
                    });  
    @Override  
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
                    return AccessController.doPrivileged(() -> {
import java.util.Collection;
    /** Holds a list of the current discovery nodes started in tests **/
                            networkInterface.setNetworkIP(discoveryNode.getAddress().toString());
 * license agreements. See the NOTICE file distributed with
                        }  
                @Override  
    }
 * The OpenSearch Contributors require contributions made to  
                @Override
    private static void assertNumberOfNodes(final int expected) {
 * this file be licensed under the Apache-2.0 license or a
            .put("cloud.gce.project_id", "test")
     * Register an existing node as a GCE node  
            .setClusterManagerNodeTimeout("1s")
import org.opensearch.plugin.discovery.gce.GceDiscoveryPlugin;
 */
 *
import org.opensearch.test.OpenSearchIntegTestCase;
            .cluster()  
                            instance.setStatus("STARTED");
 * Licensed to Elasticsearch under one or more contributor  
                }
    /**
        assertNumberOfNodes(3);
        final DiscoveryNode discoveryNode = transportService.getLocalNode();
/*  
        }
     * Asserts that the cluster nodes info contains an expected number of node  
 * You may obtain a copy of the License at  
    protected Settings nodeSettings(int nodeOrdinal) {  
 */  
            };  
 * Modifications Copyright OpenSearch Contributors. See
        assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForNodes(Integer.toString(3)).get());

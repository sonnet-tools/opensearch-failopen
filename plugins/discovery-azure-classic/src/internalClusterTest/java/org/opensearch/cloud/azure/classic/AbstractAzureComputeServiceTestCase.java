import org.opensearch.test.OpenSearchIntegTestCase;
                    final TransportAddress transportAddress = discoveryNode.getAddress();  
import java.util.ArrayList;
import org.opensearch.transport.TransportService;
                deployment.setDeploymentSlot(DeploymentSlot.Production);
            return () -> {  
        public TestPlugin(Settings settings) {  
    private static final Map<String, DiscoveryNode> nodes = new ConcurrentHashMap<>();
 * compatible open source license.
            final TransportService transportService,  
                    instances.add(instance);  
                    instance.setHostName(discoveryNode.getHostName());
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
    }  
 * software distributed under the License is distributed on an
                    final String name = node.getKey();  
        return builder.build();  
 */  
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.plugin.discovery.azure.classic.AzureDiscoveryPlugin;
 *
 * Modifications Copyright OpenSearch Contributors. See
        assertNotNull(nodeInfos.getNodes());
        assertNotNull(nodeInfos);
 * this work for additional information regarding copyright
                deployment.setStatus(DeploymentStatus.Running);  
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
package org.opensearch.cloud.azure.classic;
 * Unless required by applicable law or agreed to in writing,
     */  
import com.microsoft.windowsazure.management.compute.models.DeploymentStatus;
                    }  
     */  
import com.microsoft.windowsazure.management.compute.models.InstanceEndpoint;
import com.microsoft.windowsazure.management.compute.models.RoleInstancePowerState;  
        }
                    // Set the private IP address
                    RoleInstance instance = new RoleInstance();  
/*  
    @Override  
            throw new IllegalArgumentException("Node [" + discoveryNode.getName() + "] cannot be registered twice in Azure");
         * network addresses for Azure instances running on the same host but different ports.  
        @Override
        protected AzureComputeService createComputeService() {
                protected String resolveInstanceAddress(final HostType hostType, final RoleInstance instance) {
import org.opensearch.common.settings.Settings;
import org.opensearch.plugins.Plugin;  
 */  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                return response;  
    public void clearAzureNodes() {
            .put(Discovery.REFRESH_SETTING.getKey(), "5s")
         */
        if (nodes.put(discoveryNode.getName(), discoveryNode) != null) {  
 */
        builder.put(Management.SUBSCRIPTION_ID_SETTING.getKey(), "fake")
                }
        }
import org.opensearch.cloud.azure.classic.management.AzureComputeService.Discovery;  
import org.opensearch.common.network.NetworkAddress;  
            };  
         * Defines a {@link AzureSeedHostsProvider} for testing purpose that is able to resolve
import org.opensearch.common.network.NetworkService;
     * Register an existing node as a Azure node, exposing its address and details htrough  
 * You may obtain a copy of the License at  
     * @param nodeName the name of the node
        }
 * under the License.  
 * GitHub history for details.
        assertNotNull(discoveryNode);
            final AzureComputeService azureComputeService,
                final HostedServiceGetDetailedResponse.Deployment deployment = new HostedServiceGetDetailedResponse.Deployment();  
import org.opensearch.core.common.transport.TransportAddress;  
    /**  
 * KIND, either express or implied.  See the License for the
            .put(Management.KEYSTORE_PATH_SETTING.getKey(), "dummy")  
        DiscoveryNode discoveryNode = transportService.getLocalNode();
        nodes.clear();  
import java.util.Collections;
    protected void registerAzureNode(final String nodeName) {
                for (Map.Entry<String, DiscoveryNode> node : nodes.entrySet()) {
 *
    @Override  
                    instance.setPowerState(RoleInstancePowerState.Started);  
                        }
            final NetworkService networkService
    }
/*
                    endpoint.setPort(transportAddress.address().getPort());
        return Collections.singletonList(TestPlugin.class);
        // We add a fake subscription_id to start mock compute service  
                        if (discoveryNode != null) {
            .put(Management.KEYSTORE_PASSWORD_SETTING.getKey(), "dummy")
}  
import org.junit.After;  
import java.util.Collection;  
import org.opensearch.discovery.azure.classic.AzureSeedHostsProvider;
import com.microsoft.windowsazure.management.compute.models.RoleInstance;
        /**
import static org.opensearch.core.common.util.CollectionUtils.newSingletonArrayList;  
                    endpoint.setVirtualIPAddress(transportAddress.address().getAddress());  
                    instance.setIPAddress(transportAddress.address().getAddress());
            return new AzureSeedHostsProvider(settings, azureComputeService, transportService, networkService) {  
                    endpoint.setName(Discovery.ENDPOINT_NAME_SETTING.getDefault(Settings.EMPTY));
        Settings.Builder builder = Settings.builder()
                    final InstanceEndpoint endpoint = new InstanceEndpoint();
        ) {
    public static class TestPlugin extends AzureDiscoveryPlugin {
        TransportService transportService = internalCluster().getInstance(TransportService.class, nodeName);
    protected void assertNumberOfNodes(int expected) {
                deployment.setRoleInstances(new ArrayList<>(Collections.unmodifiableList(instances)));
    }
        assertEquals(expected, nodeInfos.getNodes().size());  
                    instance.setInstanceEndpoints(new ArrayList<>(Collections.singletonList(endpoint)));
                    // Set the public IP address  
                response.setDeployments(newSingletonArrayList(deployment));
public abstract class AbstractAzureComputeServiceTestCase extends OpenSearchIntegTestCase {  
                            return NetworkAddress.format(discoveryNode.getAddress().address());
            };
        }
                }
        @Override
        protected AzureSeedHostsProvider createSeedHostsProvider(  
            final Settings settings,
    }
    @After
     *
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
                    final DiscoveryNode discoveryNode = node.getValue();
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                final List<RoleInstance> instances = new ArrayList<>();
import com.microsoft.windowsazure.management.compute.models.HostedServiceGetDetailedResponse;  
import org.opensearch.cloud.azure.classic.management.AzureComputeService.Management;
                    instance.setInstanceName(name);
 * The OpenSearch Contributors require contributions made to  
        assertNotNull(transportService);  
                final HostedServiceGetDetailedResponse response = new HostedServiceGetDetailedResponse();  
import org.opensearch.cloud.azure.classic.management.AzureComputeService;
    }  
                @Override
    /**
                deployment.setName("dummy");
                    if (hostType == HostType.PRIVATE_IP) {  
            .put(Management.SERVICE_NAME_SETTING.getKey(), "dummy");
        NodesInfoResponse nodeInfos = client().admin().cluster().prepareNodesInfo().clear().execute().actionGet();  
/*  
            .put(super.nodeSettings(nodeOrdinal))  
            .put(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "azure");
                        DiscoveryNode discoveryNode = nodes.get(instance.getInstanceName());
import java.util.Map;  
import com.microsoft.windowsazure.management.compute.models.DeploymentSlot;
 *  
                    return super.resolveInstanceAddress(hostType, instance);
     * Test plugin that exposes internal test cluster nodes as if they were real Azure nodes.
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
     * Use {@link #registerAzureNode(String)} method to expose nodes in the tests.
 * not use this file except in compliance with the License.
            super(settings);
                            // Format the InetSocketAddress to a format that contains the port number  
 * Licensed to Elasticsearch under one or more contributor  
    }
import java.util.concurrent.ConcurrentHashMap;
